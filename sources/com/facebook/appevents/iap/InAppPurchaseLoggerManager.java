package com.facebook.appevents.iap;

import android.content.SharedPreferences;
import com.facebook.FacebookSdk;
import com.facebook.appevents.iap.InAppPurchaseUtils;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class InAppPurchaseLoggerManager {
    private static final long APPROXIMATE_IAP_ENHANCEMENT_RELEASE_TIME = 1736528400000L;
    private static final String APP_HAS_BEEN_LAUNCHED_KEY = "APP_HAS_BEEN_LAUNCHED_KEY";
    private static final String CACHED_PURCHASES_KEY = "PURCHASE_DETAILS_SET";
    private static final String IAP_CACHE_GPBLV2V7 = "com.facebook.internal.iap.IAP_CACHE_GPBLV2V7";
    private static final String IAP_CACHE_OLD = "com.facebook.internal.iap.PRODUCT_DETAILS";
    private static final String IAP_PURCHASE_CACHE_GPBLV1 = "com.facebook.internal.PURCHASE";
    private static final String IAP_SKU_CACHE_GPBLV1 = "com.facebook.internal.SKU_DETAILS";
    public static final InAppPurchaseLoggerManager INSTANCE = new InAppPurchaseLoggerManager();
    private static final double MILLISECONDS_IN_SECONDS = 1000.0d;
    private static final String PURCHASE_TIME = "purchaseTime";
    private static final String TIME_OF_LAST_LOGGED_PURCHASE_KEY = "TIME_OF_LAST_LOGGED_PURCHASE";
    private static final String TIME_OF_LAST_LOGGED_SUBSCRIPTION_KEY = "TIME_OF_LAST_LOGGED_SUBSCRIPTION";

    private InAppPurchaseLoggerManager() {
    }

    @JvmStatic
    public static final void deleteOldCacheHistory() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseLoggerManager.class)) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(IAP_SKU_CACHE_GPBLV1, 0);
            SharedPreferences sharedPreferences2 = FacebookSdk.getApplicationContext().getSharedPreferences(IAP_PURCHASE_CACHE_GPBLV1, 0);
            sharedPreferences.edit().clear().apply();
            sharedPreferences2.edit().clear().apply();
            FacebookSdk.getApplicationContext().getSharedPreferences(IAP_CACHE_OLD, 0).edit().clear().apply();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseLoggerManager.class);
        }
    }

    @JvmStatic
    public static final void filterPurchaseLogging(Map<String, JSONObject> purchaseDetailsMap, Map<String, ? extends JSONObject> skuDetailsMap, boolean z2, String packageName, InAppPurchaseUtils.BillingClientVersion billingClientVersion, boolean z3) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseLoggerManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(purchaseDetailsMap, "purchaseDetailsMap");
            Intrinsics.checkNotNullParameter(skuDetailsMap, "skuDetailsMap");
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(billingClientVersion, "billingClientVersion");
            InAppPurchaseLoggerManager inAppPurchaseLoggerManager = INSTANCE;
            inAppPurchaseLoggerManager.logPurchases(inAppPurchaseLoggerManager.constructLoggingReadyMap$facebook_core_release(inAppPurchaseLoggerManager.cacheDeDupPurchase$facebook_core_release(purchaseDetailsMap, z2), skuDetailsMap, packageName), z2, billingClientVersion, z3);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseLoggerManager.class);
        }
    }

    @JvmStatic
    public static final boolean getIsFirstAppLaunchWithNewIAP() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseLoggerManager.class)) {
            return false;
        }
        try {
            return !FacebookSdk.getApplicationContext().getSharedPreferences(IAP_CACHE_GPBLV2V7, 0).contains(APP_HAS_BEEN_LAUNCHED_KEY);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseLoggerManager.class);
            return false;
        }
    }

    private final void logPurchases(Map<String, String> map, boolean z2, InAppPurchaseUtils.BillingClientVersion billingClientVersion, boolean z3) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                AutomaticAnalyticsLogger.logPurchase(entry.getKey(), entry.getValue(), z2, billingClientVersion, z3);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @JvmStatic
    public static final void migrateOldCacheHistory() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseLoggerManager.class)) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(IAP_CACHE_GPBLV2V7, 0);
            long jMax = Math.max(Math.max(sharedPreferences.getLong(TIME_OF_LAST_LOGGED_PURCHASE_KEY, 0L), sharedPreferences.getLong(TIME_OF_LAST_LOGGED_SUBSCRIPTION_KEY, 0L)), APPROXIMATE_IAP_ENHANCEMENT_RELEASE_TIME);
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            SharedPreferences sharedPreferences2 = FacebookSdk.getApplicationContext().getSharedPreferences(IAP_CACHE_OLD, 0);
            if (sharedPreferences2.contains(CACHED_PURCHASES_KEY)) {
                Collection stringSet = sharedPreferences2.getStringSet(CACHED_PURCHASES_KEY, new HashSet());
                copyOnWriteArraySet.addAll(stringSet == null ? new HashSet() : stringSet);
                Iterator it = copyOnWriteArraySet.iterator();
                while (it.hasNext()) {
                    try {
                        long j3 = Long.parseLong((String) StringsKt.V0((String) it.next(), new String[]{";"}, false, 2, 2, null).get(1)) * 1000;
                        if (Math.abs(String.valueOf(j3).length() - 13) < Math.log10(MILLISECONDS_IN_SECONDS)) {
                            jMax = Math.max(jMax, j3);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            sharedPreferences.edit().putLong(TIME_OF_LAST_LOGGED_SUBSCRIPTION_KEY, jMax).apply();
            sharedPreferences.edit().putLong(TIME_OF_LAST_LOGGED_PURCHASE_KEY, jMax).apply();
            deleteOldCacheHistory();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseLoggerManager.class);
        }
    }

    @JvmStatic
    public static final void setAppHasBeenLaunchedWithNewIAP() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseLoggerManager.class)) {
            return;
        }
        try {
            try {
                FacebookSdk.getApplicationContext().getSharedPreferences(IAP_CACHE_GPBLV2V7, 0).edit().putBoolean(APP_HAS_BEEN_LAUNCHED_KEY, true).apply();
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseLoggerManager.class);
        }
    }

    @JvmStatic
    public static final void updateLatestPossiblePurchaseTime() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseLoggerManager.class)) {
            return;
        }
        try {
            setAppHasBeenLaunchedWithNewIAP();
            try {
                SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(IAP_CACHE_GPBLV2V7, 0);
                long jCurrentTimeMillis = System.currentTimeMillis();
                sharedPreferences.edit().putLong(TIME_OF_LAST_LOGGED_SUBSCRIPTION_KEY, jCurrentTimeMillis).apply();
                sharedPreferences.edit().putLong(TIME_OF_LAST_LOGGED_PURCHASE_KEY, jCurrentTimeMillis).apply();
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseLoggerManager.class);
        }
    }

    public final Map<String, JSONObject> cacheDeDupPurchase$facebook_core_release(Map<String, JSONObject> purchaseDetailsMap, boolean z2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(purchaseDetailsMap, "purchaseDetailsMap");
            SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(IAP_CACHE_GPBLV2V7, 0);
            long j3 = z2 ? sharedPreferences.getLong(TIME_OF_LAST_LOGGED_SUBSCRIPTION_KEY, APPROXIMATE_IAP_ENHANCEMENT_RELEASE_TIME) : sharedPreferences.getLong(TIME_OF_LAST_LOGGED_PURCHASE_KEY, APPROXIMATE_IAP_ENHANCEMENT_RELEASE_TIME);
            long jMax = 0;
            for (Map.Entry entry : MapsKt.toMap(purchaseDetailsMap).entrySet()) {
                String str = (String) entry.getKey();
                JSONObject jSONObject = (JSONObject) entry.getValue();
                try {
                    if (jSONObject.has("purchaseToken") && jSONObject.has("purchaseTime")) {
                        long j4 = jSONObject.getLong("purchaseTime");
                        if (j4 <= j3) {
                            purchaseDetailsMap.remove(str);
                        }
                        jMax = Math.max(jMax, j4);
                    }
                } catch (Exception unused) {
                }
            }
            if (jMax >= j3) {
                if (z2) {
                    sharedPreferences.edit().putLong(TIME_OF_LAST_LOGGED_SUBSCRIPTION_KEY, jMax).apply();
                } else {
                    sharedPreferences.edit().putLong(TIME_OF_LAST_LOGGED_PURCHASE_KEY, jMax).apply();
                }
            }
            return new HashMap(purchaseDetailsMap);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final Map<String, String> constructLoggingReadyMap$facebook_core_release(Map<String, ? extends JSONObject> purchaseDetailsMap, Map<String, ? extends JSONObject> skuDetailsMap, String packageName) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(purchaseDetailsMap, "purchaseDetailsMap");
            Intrinsics.checkNotNullParameter(skuDetailsMap, "skuDetailsMap");
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ? extends JSONObject> entry : purchaseDetailsMap.entrySet()) {
                String key = entry.getKey();
                JSONObject value = entry.getValue();
                JSONObject jSONObject = skuDetailsMap.get(key);
                try {
                    value.put("packageName", packageName);
                    if (jSONObject != null) {
                        String string = value.toString();
                        Intrinsics.checkNotNullExpressionValue(string, "purchaseDetail.toString()");
                        String string2 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(string2, "skuDetail.toString()");
                        linkedHashMap.put(string, string2);
                    }
                } catch (Exception unused) {
                }
            }
            return linkedHashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
