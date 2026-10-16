package com.facebook.appevents.iap;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.OperationalData;
import com.facebook.appevents.OperationalDataEnum;
import com.facebook.appevents.iap.InAppPurchaseUtils;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class InAppPurchaseManager {
    private static final String GOOGLE_BILLINGCLIENT_VERSION = "com.google.android.play.billingclient.version";
    private static String specificBillingLibraryVersion;
    public static final InAppPurchaseManager INSTANCE = new InAppPurchaseManager();
    private static final ConcurrentHashMap<InAppPurchase, List<Pair<Long, Pair<Bundle, OperationalData>>>> timesOfManualPurchases = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<InAppPurchase, List<Pair<Long, Pair<Bundle, OperationalData>>>> timesOfImplicitPurchases = new ConcurrentHashMap<>();
    private static final AtomicBoolean enabled = new AtomicBoolean(false);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InAppPurchaseUtils.BillingClientVersion.values().length];
            try {
                iArr[InAppPurchaseUtils.BillingClientVersion.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InAppPurchaseUtils.BillingClientVersion.V1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InAppPurchaseUtils.BillingClientVersion.V2_V4.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[InAppPurchaseUtils.BillingClientVersion.V5_V7.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private InAppPurchaseManager() {
    }

    @JvmStatic
    public static final void enableAutoLogging() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
            return;
        }
        try {
            if (!AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
                InAppPurchaseLoggerManager.updateLatestPossiblePurchaseTime();
            } else {
                enabled.set(true);
                startTracking();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseManager.class);
        }
    }

    private final InAppPurchaseUtils.BillingClientVersion getBillingClientVersion() {
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                Context applicationContext = FacebookSdk.getApplicationContext();
                ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                Intrinsics.checkNotNullExpressionValue(applicationInfo, "context.packageManager.g…TA_DATA\n                )");
                String string = applicationInfo.metaData.getString(GOOGLE_BILLINGCLIENT_VERSION);
                if (string == null) {
                    return InAppPurchaseUtils.BillingClientVersion.NONE;
                }
                List listV0 = StringsKt.V0(string, new String[]{"."}, false, 3, 2, null);
                if (string.length() == 0) {
                    return InAppPurchaseUtils.BillingClientVersion.V5_V7;
                }
                setSpecificBillingLibraryVersion("GPBL." + string);
                Integer numU = StringsKt.u((String) listV0.get(0));
                if (numU == null) {
                    return InAppPurchaseUtils.BillingClientVersion.V5_V7;
                }
                int iIntValue = numU.intValue();
                return iIntValue == 1 ? InAppPurchaseUtils.BillingClientVersion.V1 : iIntValue < 5 ? InAppPurchaseUtils.BillingClientVersion.V2_V4 : InAppPurchaseUtils.BillingClientVersion.V5_V7;
            } catch (Exception unused) {
                return InAppPurchaseUtils.BillingClientVersion.V5_V7;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public static /* synthetic */ String getDedupeParameter$default(InAppPurchaseManager inAppPurchaseManager, Bundle bundle, OperationalData operationalData, Bundle bundle2, OperationalData operationalData2, boolean z2, boolean z3, int i3, Object obj) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
            return null;
        }
        try {
            return inAppPurchaseManager.getDedupeParameter(bundle, operationalData, bundle2, operationalData2, z2, (i3 & 32) != 0 ? false : z3);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseManager.class);
            return null;
        }
    }

    @JvmStatic
    public static final String getSpecificBillingLibraryVersion() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
            return null;
        }
        try {
            return specificBillingLibraryVersion;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseManager.class);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [android.os.BaseBundle] */
    /* JADX WARN: Type inference failed for: r8v5, types: [android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r8v6, types: [android.os.BaseBundle] */
    /* JADX WARN: Type inference failed for: r8v7, types: [android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r8v8 */
    @JvmStatic
    public static final synchronized Bundle performDedupe(List<InAppPurchase> list, long j3, boolean z2, List<Pair<Bundle, OperationalData>> list2) {
        Bundle bundle;
        ?? r6;
        ?? ValueOf;
        ?? dedupeParameter$default;
        boolean z3;
        List<InAppPurchase> purchases = list;
        List<Pair<Bundle, OperationalData>> purchaseParameters = list2;
        synchronized (InAppPurchaseManager.class) {
            Bundle bundle2 = null;
            if (CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
                return null;
            }
            try {
                Intrinsics.checkNotNullParameter(purchases, "purchases");
                Intrinsics.checkNotNullParameter(purchaseParameters, "purchaseParameters");
                if (purchaseParameters.isEmpty()) {
                    return null;
                }
                if (purchases.size() != purchaseParameters.size()) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                int size = purchases.size();
                ?? bundle3 = 0;
                int i3 = 0;
                while (i3 < size) {
                    InAppPurchase inAppPurchase = purchases.get(i3);
                    Pair<Bundle, OperationalData> pair = purchaseParameters.get(i3);
                    Bundle bundle4 = (Bundle) pair.a();
                    OperationalData operationalData = (OperationalData) pair.b();
                    bundle = bundle2;
                    try {
                        int i4 = i3;
                        InAppPurchase inAppPurchase2 = new InAppPurchase(inAppPurchase.getEventName(), new BigDecimal(String.valueOf(inAppPurchase.getAmount())).setScale(2, RoundingMode.HALF_UP).doubleValue(), inAppPurchase.getCurrency());
                        List<Pair<Long, Pair<Bundle, OperationalData>>> list3 = z2 ? timesOfManualPurchases.get(inAppPurchase2) : timesOfImplicitPurchases.get(inAppPurchase2);
                        List<Pair<Long, Pair<Bundle, OperationalData>>> list4 = list3;
                        if (list4 == null || list4.isEmpty()) {
                            r6 = bundle;
                            ValueOf = r6;
                            dedupeParameter$default = ValueOf;
                            z3 = false;
                        } else {
                            r6 = bundle;
                            ValueOf = r6;
                            dedupeParameter$default = ValueOf;
                            z3 = false;
                            for (Pair<Long, Pair<Bundle, OperationalData>> pair2 : list3) {
                                long jLongValue = ((Number) pair2.e()).longValue();
                                Pair pair3 = (Pair) pair2.f();
                                Bundle bundle5 = (Bundle) pair3.a();
                                OperationalData operationalData2 = (OperationalData) pair3.b();
                                if (Math.abs(j3 - jLongValue) <= InAppPurchaseDedupeConfig.INSTANCE.getDedupeWindow() && (ValueOf == 0 || jLongValue < ValueOf.longValue())) {
                                    InAppPurchaseManager inAppPurchaseManager = INSTANCE;
                                    dedupeParameter$default = getDedupeParameter$default(inAppPurchaseManager, bundle4, operationalData, bundle5, operationalData2, !z2, false, 32, null);
                                    String dedupeParameter = inAppPurchaseManager.getDedupeParameter(bundle4, operationalData, bundle5, operationalData2, !z2, true);
                                    r6 = r6;
                                    if (dedupeParameter != null) {
                                        r6 = dedupeParameter;
                                    }
                                    if (dedupeParameter$default != 0) {
                                        ValueOf = Long.valueOf(jLongValue);
                                        arrayList.add(new Pair(inAppPurchase2, Long.valueOf(jLongValue)));
                                        z3 = true;
                                    }
                                }
                            }
                        }
                        if (r6 != 0) {
                            if (bundle3 == 0) {
                                bundle3 = new Bundle();
                            }
                            bundle3.putString(Constants.IAP_TEST_DEDUP_RESULT, AppEventsConstants.EVENT_PARAM_VALUE_YES);
                            bundle3.putString(Constants.IAP_TEST_DEDUP_KEY_USED, r6);
                        }
                        if (z3) {
                            if (bundle3 == 0) {
                                bundle3 = new Bundle();
                            }
                            bundle3.putString(Constants.IAP_NON_DEDUPED_EVENT_TIME, String.valueOf(ValueOf != 0 ? ValueOf.longValue() / ((long) 1000) : 0L));
                            bundle3.putString(Constants.IAP_ACTUAL_DEDUP_RESULT, AppEventsConstants.EVENT_PARAM_VALUE_YES);
                            bundle3.putString(Constants.IAP_ACTUAL_DEDUP_KEY_USED, dedupeParameter$default);
                        }
                        if (z2 && !z3) {
                            ConcurrentHashMap<InAppPurchase, List<Pair<Long, Pair<Bundle, OperationalData>>>> concurrentHashMap = timesOfImplicitPurchases;
                            if (concurrentHashMap.get(inAppPurchase2) == null) {
                                concurrentHashMap.put(inAppPurchase2, new ArrayList());
                            }
                            List<Pair<Long, Pair<Bundle, OperationalData>>> list5 = concurrentHashMap.get(inAppPurchase2);
                            if (list5 != null) {
                                list5.add(new Pair<>(Long.valueOf(j3), new Pair(bundle4, operationalData)));
                            }
                        } else if (!z2 && !z3) {
                            ConcurrentHashMap<InAppPurchase, List<Pair<Long, Pair<Bundle, OperationalData>>>> concurrentHashMap2 = timesOfManualPurchases;
                            if (concurrentHashMap2.get(inAppPurchase2) == null) {
                                concurrentHashMap2.put(inAppPurchase2, new ArrayList());
                            }
                            List<Pair<Long, Pair<Bundle, OperationalData>>> list6 = concurrentHashMap2.get(inAppPurchase2);
                            if (list6 != null) {
                                list6.add(new Pair<>(Long.valueOf(j3), new Pair(bundle4, operationalData)));
                            }
                        }
                        i3 = i4 + 1;
                        purchases = list;
                        purchaseParameters = list2;
                        bundle2 = bundle;
                        bundle3 = bundle3;
                    } catch (Throwable th) {
                        th = th;
                    }
                }
                bundle = bundle2;
                int size2 = arrayList.size();
                int i5 = 0;
                while (i5 < size2) {
                    Object obj = arrayList.get(i5);
                    i5++;
                    Pair pair4 = (Pair) obj;
                    List<Pair<Long, Pair<Bundle, OperationalData>>> list7 = z2 ? timesOfManualPurchases.get(pair4.e()) : timesOfImplicitPurchases.get(pair4.e());
                    if (list7 != null) {
                        Iterator<Pair<Long, Pair<Bundle, OperationalData>>> it = list7.iterator();
                        int i6 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            int i7 = i6 + 1;
                            if (((Number) it.next().e()).longValue() == ((Number) pair4.f()).longValue()) {
                                list7.remove(i6);
                                break;
                            }
                            i6 = i7;
                        }
                        if (z2) {
                            if (list7.isEmpty()) {
                                timesOfManualPurchases.remove(pair4.e());
                            } else {
                                timesOfManualPurchases.put((InAppPurchase) pair4.e(), list7);
                            }
                        } else if (list7.isEmpty()) {
                            timesOfImplicitPurchases.remove(pair4.e());
                        } else {
                            timesOfImplicitPurchases.put((InAppPurchase) pair4.e(), list7);
                        }
                    }
                }
                return bundle3;
            } catch (Throwable th2) {
                th = th2;
                bundle = bundle2;
            }
            CrashShieldHandler.handleThrowable(th, InAppPurchaseManager.class);
            return bundle;
        }
    }

    @JvmStatic
    private static final void setSpecificBillingLibraryVersion(String str) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
            return;
        }
        try {
            specificBillingLibraryVersion = str;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseManager.class);
        }
    }

    @JvmStatic
    public static final void startTracking() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
            return;
        }
        try {
            if (enabled.get()) {
                InAppPurchaseUtils.BillingClientVersion billingClientVersion = INSTANCE.getBillingClientVersion();
                int i3 = WhenMappings.$EnumSwitchMapping$0[billingClientVersion.ordinal()];
                if (i3 == 2) {
                    InAppPurchaseActivityLifecycleTracker.startIapLogging(InAppPurchaseUtils.BillingClientVersion.V1);
                    return;
                }
                if (i3 != 3) {
                    if (i3 == 4 && FeatureManager.isEnabled(FeatureManager.Feature.IapLoggingLib5To7)) {
                        InAppPurchaseAutoLogger.startIapLogging(FacebookSdk.getApplicationContext(), billingClientVersion);
                        return;
                    }
                    return;
                }
                if (FeatureManager.isEnabled(FeatureManager.Feature.IapLoggingLib2)) {
                    InAppPurchaseAutoLogger.startIapLogging(FacebookSdk.getApplicationContext(), billingClientVersion);
                } else {
                    InAppPurchaseActivityLifecycleTracker.startIapLogging(InAppPurchaseUtils.BillingClientVersion.V2_V4);
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseManager.class);
        }
    }

    public final String getDedupeParameter(Bundle bundle, OperationalData operationalData, Bundle bundle2, OperationalData operationalData2, boolean z2, boolean z3) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            List<Pair<String, List<String>>> testDedupeParameters = z3 ? InAppPurchaseDedupeConfig.INSTANCE.getTestDedupeParameters(z2) : InAppPurchaseDedupeConfig.INSTANCE.getDedupeParameters(z2);
            if (testDedupeParameters == null) {
                return null;
            }
            for (Pair<String, List<String>> pair : testDedupeParameters) {
                Object parameter = OperationalData.Companion.getParameter(OperationalDataEnum.IAPParameters, (String) pair.e(), bundle, operationalData);
                String str = parameter instanceof String ? (String) parameter : null;
                if (str != null && str.length() != 0) {
                    for (String str2 : (List) pair.f()) {
                        Object parameter2 = OperationalData.Companion.getParameter(OperationalDataEnum.IAPParameters, str2, bundle2, operationalData2);
                        String str3 = parameter2 instanceof String ? (String) parameter2 : null;
                        if (str3 != null && str3.length() != 0 && Intrinsics.areEqual(str3, str)) {
                            return z2 ? (String) pair.e() : str2;
                        }
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
