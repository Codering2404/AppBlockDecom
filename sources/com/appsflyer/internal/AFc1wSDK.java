package com.appsflyer.internal;

import android.graphics.Color;
import android.os.Build;
import android.view.View;
import com.appsflyer.AFLogger;
import com.appsflyer.CreateOneLinkHttpTask;
import com.appsflyer.internal.AFb1dSDK;
import com.appsflyer.internal.AFc1tSDK;
import com.facebook.ads.AdError;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

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
public final class AFc1wSDK implements AFc1vSDK {
    private static char AFVersionDeclaration = 3;
    private static char[] afDebugLog = {13822, 13816, 13812, 13825, 13800, 13819, 13824, 13823, 13826};
    private static int afErrorLogForExcManagerOnly = 0;
    private static int afWarnLog = 1;
    private final Lazy AFInAppEventParameterName;
    private AFc1ySDK AFInAppEventType;
    private final Lazy AFKeystoreWrapper;
    private final Lazy AFLogger;
    private final String afErrorLog;
    private final Lazy afInfoLog;
    private final Lazy afRDLog;
    private final Lazy valueOf;
    private final Lazy values;

    public AFc1wSDK(AFc1ySDK aFc1ySDK) {
        Intrinsics.checkNotNullParameter(aFc1ySDK, "");
        this.AFInAppEventType = aFc1ySDK;
        this.values = LazyKt.b(new Function0<AFb1wSDK>() { // from class: com.appsflyer.internal.AFc1wSDK.3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: values, reason: merged with bridge method [inline-methods] */
            public final AFb1wSDK invoke() {
                AFb1wSDK aFb1wSDKAfInfoLog = AFc1wSDK.values(AFc1wSDK.this).afInfoLog();
                Intrinsics.checkNotNullExpressionValue(aFb1wSDKAfInfoLog, "");
                return aFb1wSDKAfInfoLog;
            }
        });
        this.AFInAppEventParameterName = LazyKt.b(new Function0<AFb1gSDK>() { // from class: com.appsflyer.internal.AFc1wSDK.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: AFInAppEventType, reason: merged with bridge method [inline-methods] */
            public final AFb1gSDK invoke() {
                AFb1gSDK aFb1gSDKAFInAppEventParameterName = AFc1wSDK.values(AFc1wSDK.this).AFInAppEventParameterName();
                Intrinsics.checkNotNullExpressionValue(aFb1gSDKAFInAppEventParameterName, "");
                return aFb1gSDKAFInAppEventParameterName;
            }
        });
        this.AFKeystoreWrapper = LazyKt.b(new Function0<AFb1fSDK>() { // from class: com.appsflyer.internal.AFc1wSDK.4
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: valueOf, reason: merged with bridge method [inline-methods] */
            public final AFb1fSDK invoke() {
                AFb1fSDK aFb1fSDKAFKeystoreWrapper = AFc1wSDK.values(AFc1wSDK.this).AFKeystoreWrapper();
                Intrinsics.checkNotNullExpressionValue(aFb1fSDKAFKeystoreWrapper, "");
                return aFb1fSDKAFKeystoreWrapper;
            }
        });
        this.valueOf = LazyKt.b(new Function0<AFe1pSDK>() { // from class: com.appsflyer.internal.AFc1wSDK.10
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: AFInAppEventParameterName, reason: merged with bridge method [inline-methods] */
            public final AFe1pSDK invoke() {
                AFe1pSDK level = AFc1wSDK.values(AFc1wSDK.this).getLevel();
                Intrinsics.checkNotNullExpressionValue(level, "");
                return level;
            }
        });
        this.afInfoLog = LazyKt.b(new Function0<ExecutorService>() { // from class: com.appsflyer.internal.AFc1wSDK.5
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: values, reason: merged with bridge method [inline-methods] */
            public final ExecutorService invoke() {
                ExecutorService executorServiceAFInAppEventType = AFc1wSDK.values(AFc1wSDK.this).AFInAppEventType();
                Intrinsics.checkNotNullExpressionValue(executorServiceAFInAppEventType, "");
                return executorServiceAFInAppEventType;
            }
        });
        this.afErrorLog = "6.12.3";
        this.AFLogger = LazyKt.b(new Function0<CreateOneLinkHttpTask>() { // from class: com.appsflyer.internal.AFc1wSDK.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: valueOf, reason: merged with bridge method [inline-methods] */
            public final CreateOneLinkHttpTask invoke() {
                AFc1zSDK aFc1zSDKAfWarnLog = AFc1wSDK.values(AFc1wSDK.this).afWarnLog();
                Intrinsics.checkNotNullExpressionValue(aFc1zSDKAfWarnLog, "");
                return new CreateOneLinkHttpTask(aFc1zSDKAfWarnLog);
            }
        });
        this.afRDLog = LazyKt.b(new Function0<AFc1rSDK>() { // from class: com.appsflyer.internal.AFc1wSDK.7
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: values, reason: merged with bridge method [inline-methods] */
            public final AFc1rSDK invoke() {
                return new AFc1rSDK(AFc1wSDK.this.valueOf());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AFKeystoreWrapper(AFc1wSDK aFc1wSDK) {
        int i3 = afErrorLogForExcManagerOnly + 101;
        afWarnLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            Intrinsics.checkNotNullParameter(aFc1wSDK, "");
            aFc1wSDK.getLevel();
            throw null;
        }
        Intrinsics.checkNotNullParameter(aFc1wSDK, "");
        aFc1wSDK.getLevel();
        int i4 = afErrorLogForExcManagerOnly + 25;
        afWarnLog = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 == 0) {
            throw null;
        }
    }

    private final AFe1pSDK AFLogger() {
        int i3 = afErrorLogForExcManagerOnly + 99;
        afWarnLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            throw null;
        }
        AFe1pSDK aFe1pSDK = (AFe1pSDK) this.valueOf.getValue();
        int i4 = afErrorLogForExcManagerOnly + 89;
        afWarnLog = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 != 0) {
            return aFe1pSDK;
        }
        throw null;
    }

    private final synchronized void AFLogger$LogLevel() {
        AFb1dSDK.AFa1wSDK aFa1wSDKAfErrorLogForExcManagerOnly = afErrorLogForExcManagerOnly();
        if (aFa1wSDKAfErrorLogForExcManagerOnly != null) {
            if (aFa1wSDKAfErrorLogForExcManagerOnly.valueOf == -1) {
                afErrorLog().AFInAppEventParameterName("af_send_exc_to_server_window");
                afWarnLog = (afErrorLogForExcManagerOnly + 89) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                return;
            }
            if (afErrorLog().AFInAppEventParameterName("af_send_exc_to_server_window", -1L) == -1) {
                afWarnLog = (afErrorLogForExcManagerOnly + 67) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                int i3 = aFa1wSDKAfErrorLogForExcManagerOnly.AFInAppEventParameterName;
                long jCurrentTimeMillis = System.currentTimeMillis() + TimeUnit.DAYS.toMillis(aFa1wSDKAfErrorLogForExcManagerOnly.valueOf);
                AFb1fSDK aFb1fSDKAfErrorLog = afErrorLog();
                aFb1fSDKAfErrorLog.AFInAppEventType("af_send_exc_to_server_window", jCurrentTimeMillis);
                aFb1fSDKAfErrorLog.AFInAppEventParameterName("af_send_exc_min", i3);
            }
        }
    }

    private AFc1tSDK AFVersionDeclaration() {
        int i3 = afErrorLogForExcManagerOnly + 75;
        afWarnLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            throw null;
        }
        AFc1tSDK aFc1tSDK = (AFc1tSDK) this.afRDLog.getValue();
        int i4 = afWarnLog + 121;
        afErrorLogForExcManagerOnly = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 == 0) {
            return aFc1tSDK;
        }
        throw null;
    }

    private final AFb1gSDK afDebugLog() {
        afWarnLog = (afErrorLogForExcManagerOnly + 15) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        AFb1gSDK aFb1gSDK = (AFb1gSDK) this.AFInAppEventParameterName.getValue();
        int i3 = afWarnLog + 35;
        afErrorLogForExcManagerOnly = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            int i4 = 0 / 0;
        }
        return aFb1gSDK;
    }

    private final AFb1fSDK afErrorLog() {
        AFb1fSDK aFb1fSDK;
        int i3 = afErrorLogForExcManagerOnly + 57;
        afWarnLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            aFb1fSDK = (AFb1fSDK) this.AFKeystoreWrapper.getValue();
            int i4 = 77 / 0;
        } else {
            aFb1fSDK = (AFb1fSDK) this.AFKeystoreWrapper.getValue();
        }
        int i5 = afWarnLog + 117;
        afErrorLogForExcManagerOnly = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i5 % 2 == 0) {
            return aFb1fSDK;
        }
        throw null;
    }

    private final AFb1dSDK.AFa1wSDK afErrorLogForExcManagerOnly() {
        AFe1wSDK aFe1wSDK;
        afErrorLogForExcManagerOnly = (afWarnLog + 85) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        AFe1mSDK aFe1mSDK = values().valueOf.values;
        if (aFe1mSDK == null || (aFe1wSDK = aFe1mSDK.AFInAppEventParameterName) == null) {
            return null;
        }
        int i3 = afErrorLogForExcManagerOnly + 119;
        afWarnLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        int i4 = i3 % 2;
        AFb1dSDK.AFa1wSDK aFa1wSDK = aFe1wSDK.valueOf;
        if (i4 != 0) {
            return aFa1wSDK;
        }
        throw null;
    }

    private final ExecutorService afInfoLog() {
        int i3 = afErrorLogForExcManagerOnly + 91;
        afWarnLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            return (ExecutorService) this.afInfoLog.getValue();
        }
        int i4 = 41 / 0;
        return (ExecutorService) this.afInfoLog.getValue();
    }

    private String afRDLog() {
        String str;
        int i3 = afWarnLog + 123;
        int i4 = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        afErrorLogForExcManagerOnly = i4;
        if (i3 % 2 != 0) {
            str = this.afErrorLog;
            int i5 = 61 / 0;
        } else {
            str = this.afErrorLog;
        }
        afWarnLog = (i4 + 31) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return str;
    }

    private final void afWarnLog() {
        int i3 = afErrorLogForExcManagerOnly + 35;
        afWarnLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            afErrorLogForExcManagerOnly();
            throw null;
        }
        AFb1dSDK.AFa1wSDK aFa1wSDKAfErrorLogForExcManagerOnly = afErrorLogForExcManagerOnly();
        if (aFa1wSDKAfErrorLogForExcManagerOnly != null) {
            if (!AFKeystoreWrapper(aFa1wSDKAfErrorLogForExcManagerOnly)) {
                Intrinsics.checkNotNullParameter("skipping", "");
                AFLogger.afRDLog("[Exception Manager]: ".concat("skipping"));
                int i4 = afWarnLog + 75;
                afErrorLogForExcManagerOnly = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                if (i4 % 2 != 0) {
                    int i5 = 2 / 0;
                    return;
                }
                return;
            }
            int i6 = afWarnLog + 35;
            afErrorLogForExcManagerOnly = i6 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i6 % 2 != 0) {
                String str = AFLogger().values;
                throw null;
            }
            String str2 = AFLogger().values;
            if (str2 != null) {
                String string = new JSONObject(values(AFInAppEventParameterName(aFa1wSDKAfErrorLogForExcManagerOnly), valueOf().values())).toString();
                Intrinsics.checkNotNullExpressionValue(string, "");
                Intrinsics.checkNotNullExpressionValue(str2, "");
                AFInAppEventType(string, str2);
            }
        }
    }

    private final synchronized void getLevel() {
        String str;
        try {
            AFb1dSDK.AFa1wSDK aFa1wSDKAfErrorLogForExcManagerOnly = afErrorLogForExcManagerOnly();
            long j3 = aFa1wSDKAfErrorLogForExcManagerOnly != null ? aFa1wSDKAfErrorLogForExcManagerOnly.AFInAppEventType : -1L;
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            try {
                AFb1dSDK.AFa1wSDK aFa1wSDKAfErrorLogForExcManagerOnly2 = afErrorLogForExcManagerOnly();
                if (aFa1wSDKAfErrorLogForExcManagerOnly2 != null) {
                    str = aFa1wSDKAfErrorLogForExcManagerOnly2.AFKeystoreWrapper;
                    afWarnLog = (afErrorLogForExcManagerOnly + 55) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
            } catch (NullPointerException unused) {
                str = "NOT_DETECTED";
            }
            if (j3 < jCurrentTimeMillis) {
                Intrinsics.checkNotNullParameter("TTL is already passed", "");
                AFLogger.afRDLog("[Exception Manager]: ".concat("TTL is already passed"));
                afErrorLog().AFInAppEventParameterName("af_send_exc_to_server_window");
                valueOf().AFInAppEventType();
                int i3 = afWarnLog + 57;
                afErrorLogForExcManagerOnly = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                if (i3 % 2 != 0) {
                    int i4 = 20 / 0;
                    return;
                }
                return;
            }
            if (AFc1tSDK.AFa1wSDK.values(str) == -1 || AFc1tSDK.AFa1wSDK.values(str) > AFc1tSDK.AFa1wSDK.values(afRDLog())) {
                afErrorLog().AFInAppEventParameterName("af_send_exc_to_server_window");
                valueOf().AFInAppEventType();
                return;
            }
            int i5 = afWarnLog + 97;
            afErrorLogForExcManagerOnly = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i5 % 2 != 0) {
                valueOf().values(afRDLog());
            } else {
                valueOf().values(afRDLog());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void values(AFc1wSDK aFc1wSDK, Throwable th, String str) {
        Intrinsics.checkNotNullParameter(aFc1wSDK, "");
        Intrinsics.checkNotNullParameter(th, "");
        Intrinsics.checkNotNullParameter(str, "");
        AFb1dSDK.AFa1wSDK aFa1wSDKAfErrorLogForExcManagerOnly = aFc1wSDK.afErrorLogForExcManagerOnly();
        if (aFa1wSDKAfErrorLogForExcManagerOnly == null) {
            afWarnLog = (afErrorLogForExcManagerOnly + 99) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else if (aFc1wSDK.valueOf(aFa1wSDKAfErrorLogForExcManagerOnly)) {
            aFc1wSDK.valueOf().valueOf(th, str);
        }
        int i3 = afWarnLog + 89;
        afErrorLogForExcManagerOnly = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            throw null;
        }
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    public final void AFInAppEventParameterName() {
        int i3 = afWarnLog + 107;
        afErrorLogForExcManagerOnly = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            afInfoLog().execute(new Runnable() { // from class: com.appsflyer.internal.p
                @Override // java.lang.Runnable
                public final void run() {
                    AFc1wSDK.AFKeystoreWrapper(this.f65649a);
                }
            });
            throw null;
        }
        afInfoLog().execute(new Runnable() { // from class: com.appsflyer.internal.p
            @Override // java.lang.Runnable
            public final void run() {
                AFc1wSDK.AFKeystoreWrapper(this.f65649a);
            }
        });
        afWarnLog = (afErrorLogForExcManagerOnly + 29) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    public final void AFInAppEventType() {
        afErrorLogForExcManagerOnly = (afWarnLog + 25) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        afInfoLog().execute(new Runnable() { // from class: com.appsflyer.internal.o
            @Override // java.lang.Runnable
            public final void run() {
                AFc1wSDK.AFInAppEventType(this.f65648a);
            }
        });
        int i3 = afErrorLogForExcManagerOnly + 15;
        afWarnLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            throw null;
        }
    }

    public final AFc1uSDK valueOf() {
        afErrorLogForExcManagerOnly = (afWarnLog + 95) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        AFc1uSDK aFc1uSDK = (AFc1uSDK) this.AFLogger.getValue();
        afWarnLog = (afErrorLogForExcManagerOnly + 35) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return aFc1uSDK;
    }

    private final Map<String, String> AFInAppEventParameterName(AFb1dSDK.AFa1wSDK aFa1wSDK) {
        Object[] objArr = new Object[1];
        AFInAppEventParameterName("\u0004\u0007\b\u0005㘋", View.MeasureSpec.getSize(0) + 5, (byte) (Color.red(0) + 13), objArr);
        Pair pairA = TuplesKt.a(((String) objArr[0]).intern(), Build.BRAND);
        Pair pairA2 = TuplesKt.a(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL);
        Pair pairA3 = TuplesKt.a("app_id", afDebugLog().values.values.getPackageName());
        Pair pairA4 = TuplesKt.a("p_ex", new AFb1xSDK().values());
        Pair pairA5 = TuplesKt.a("api", String.valueOf(Build.VERSION.SDK_INT));
        Pair pairA6 = TuplesKt.a("sdk", afRDLog());
        AFb1gSDK aFb1gSDKAfDebugLog = afDebugLog();
        Map<String, String> mapMapOf = MapsKt.mapOf(pairA, pairA2, pairA3, pairA4, pairA5, pairA6, TuplesKt.a("uid", AFa1aSDK.valueOf(aFb1gSDKAfDebugLog.values, aFb1gSDKAfDebugLog.valueOf)), TuplesKt.a("exc_config", aFa1wSDK.AFInAppEventType()));
        afWarnLog = (afErrorLogForExcManagerOnly + 23) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return mapMapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AFInAppEventType(AFc1wSDK aFc1wSDK) {
        int i3 = afWarnLog + 115;
        afErrorLogForExcManagerOnly = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            Intrinsics.checkNotNullParameter(aFc1wSDK, "");
            aFc1wSDK.afWarnLog();
            throw null;
        }
        Intrinsics.checkNotNullParameter(aFc1wSDK, "");
        aFc1wSDK.afWarnLog();
        int i4 = afErrorLogForExcManagerOnly + 71;
        afWarnLog = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void valueOf(AFc1wSDK aFc1wSDK) {
        afWarnLog = (afErrorLogForExcManagerOnly + 99) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        Intrinsics.checkNotNullParameter(aFc1wSDK, "");
        aFc1wSDK.AFLogger$LogLevel();
        afWarnLog = (afErrorLogForExcManagerOnly + 95) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    public static final /* synthetic */ AFc1ySDK values(AFc1wSDK aFc1wSDK) {
        int i3 = (afWarnLog + 125) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        afErrorLogForExcManagerOnly = i3;
        AFc1ySDK aFc1ySDK = aFc1wSDK.AFInAppEventType;
        int i4 = i3 + 103;
        afWarnLog = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 == 0) {
            int i5 = 2 / 0;
        }
        return aFc1ySDK;
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    public final void AFKeystoreWrapper() {
        afErrorLogForExcManagerOnly = (afWarnLog + 95) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        afInfoLog().execute(new Runnable() { // from class: com.appsflyer.internal.r
            @Override // java.lang.Runnable
            public final void run() {
                AFc1wSDK.valueOf(this.f65653a);
            }
        });
        int i3 = afErrorLogForExcManagerOnly + 121;
        afWarnLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            throw null;
        }
    }

    private final void AFInAppEventType(String str, String str2) {
        afErrorLogForExcManagerOnly = (afWarnLog + 43) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        byte[] bytes = str.getBytes(Charsets.f140510b);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        AFVersionDeclaration().valueOf(bytes, MapsKt.mapOf(TuplesKt.a("Authorization", AFc1rSDK.AFInAppEventParameterName(str, str2))), AdError.SERVER_ERROR_CODE);
        afErrorLogForExcManagerOnly = (afWarnLog + 91) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    private final boolean AFKeystoreWrapper(AFb1dSDK.AFa1wSDK aFa1wSDK) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jAFInAppEventParameterName = afErrorLog().AFInAppEventParameterName("af_send_exc_to_server_window", -1L);
        if (aFa1wSDK.AFInAppEventType < jCurrentTimeMillis / 1000) {
            int i3 = afErrorLogForExcManagerOnly + 53;
            afWarnLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            return i3 % 2 == 0;
        }
        if (jAFInAppEventParameterName != -1 && jAFInAppEventParameterName >= jCurrentTimeMillis) {
            int iValues = afErrorLog().values("af_send_exc_min", -1);
            if (iValues != -1 && valueOf().valueOf() >= iValues) {
                String str = aFa1wSDK.AFKeystoreWrapper;
                Intrinsics.checkNotNullExpressionValue(str, "");
                if (AFc1tSDK.AFa1wSDK.values(str) == AFc1tSDK.AFa1wSDK.values(afRDLog())) {
                    return true;
                }
                afWarnLog = (afErrorLogForExcManagerOnly + 81) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                return false;
            }
            afWarnLog = (afErrorLogForExcManagerOnly + 79) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        return false;
    }

    private final boolean valueOf(AFb1dSDK.AFa1wSDK aFa1wSDK) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jAFInAppEventParameterName = afErrorLog().AFInAppEventParameterName("af_send_exc_to_server_window", -1L);
        if (aFa1wSDK.AFInAppEventType >= jCurrentTimeMillis / 1000) {
            int i3 = afErrorLogForExcManagerOnly + 83;
            afWarnLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i3 % 2 == 0) {
                throw null;
            }
            if (jAFInAppEventParameterName == -1 || jAFInAppEventParameterName < jCurrentTimeMillis) {
                return false;
            }
            String str = aFa1wSDK.AFKeystoreWrapper;
            Intrinsics.checkNotNullExpressionValue(str, "");
            if (AFc1tSDK.AFa1wSDK.values(str) == AFc1tSDK.AFa1wSDK.values(afRDLog())) {
                afWarnLog = (afErrorLogForExcManagerOnly + 77) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                return true;
            }
        }
        afWarnLog = (afErrorLogForExcManagerOnly + 3) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return false;
    }

    private final AFb1wSDK values() {
        int i3 = afWarnLog + 69;
        afErrorLogForExcManagerOnly = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            throw null;
        }
        AFb1wSDK aFb1wSDK = (AFb1wSDK) this.values.getValue();
        afErrorLogForExcManagerOnly = (afWarnLog + 91) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return aFb1wSDK;
    }

    @Override // com.appsflyer.internal.AFc1vSDK
    public final void values(final Throwable th, final String str) {
        int i3 = afErrorLogForExcManagerOnly + 83;
        afWarnLog = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            Intrinsics.checkNotNullParameter(th, "");
            Intrinsics.checkNotNullParameter(str, "");
            afInfoLog().execute(new Runnable() { // from class: com.appsflyer.internal.q
                @Override // java.lang.Runnable
                public final void run() {
                    AFc1wSDK.values(this.f65650a, th, str);
                }
            });
            int i4 = 75 / 0;
        } else {
            Intrinsics.checkNotNullParameter(th, "");
            Intrinsics.checkNotNullParameter(str, "");
            afInfoLog().execute(new Runnable() { // from class: com.appsflyer.internal.q
                @Override // java.lang.Runnable
                public final void run() {
                    AFc1wSDK.values(this.f65650a, th, str);
                }
            });
        }
        afErrorLogForExcManagerOnly = (afWarnLog + 29) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    private static Map<String, Object> values(Map<String, ? extends Object> map, List<AFb1bSDK> list) {
        afErrorLogForExcManagerOnly = (afWarnLog + 61) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        Map<String, Object> mapMapOf = MapsKt.mapOf(TuplesKt.a("deviceInfo", map), TuplesKt.a("excs", AFc1tSDK.AFa1wSDK.AFInAppEventParameterName(list)));
        int i3 = afWarnLog + 73;
        afErrorLogForExcManagerOnly = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            int i4 = 86 / 0;
        }
        return mapMapOf;
    }

    private static void AFInAppEventParameterName(String str, int i3, byte b3, Object[] objArr) {
        int i4;
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (AFg1iSDK.afErrorLog) {
            try {
                char[] cArr2 = afDebugLog;
                char c3 = AFVersionDeclaration;
                char[] cArr3 = new char[i3];
                if (i3 % 2 != 0) {
                    i4 = i3 - 1;
                    cArr3[i4] = (char) (cArr[i4] - b3);
                } else {
                    i4 = i3;
                }
                if (i4 > 1) {
                    AFg1iSDK.values = 0;
                    while (true) {
                        int i5 = AFg1iSDK.values;
                        if (i5 >= i4) {
                            break;
                        }
                        AFg1iSDK.valueOf = cArr[i5];
                        AFg1iSDK.AFKeystoreWrapper = cArr[AFg1iSDK.values + 1];
                        if (AFg1iSDK.valueOf == AFg1iSDK.AFKeystoreWrapper) {
                            cArr3[AFg1iSDK.values] = (char) (AFg1iSDK.valueOf - b3);
                            cArr3[AFg1iSDK.values + 1] = (char) (AFg1iSDK.AFKeystoreWrapper - b3);
                        } else {
                            AFg1iSDK.AFInAppEventType = AFg1iSDK.valueOf / c3;
                            AFg1iSDK.afInfoLog = AFg1iSDK.valueOf % c3;
                            AFg1iSDK.AFInAppEventParameterName = AFg1iSDK.AFKeystoreWrapper / c3;
                            AFg1iSDK.afRDLog = AFg1iSDK.AFKeystoreWrapper % c3;
                            if (AFg1iSDK.afInfoLog == AFg1iSDK.afRDLog) {
                                AFg1iSDK.AFInAppEventType = ((AFg1iSDK.AFInAppEventType + c3) - 1) % c3;
                                AFg1iSDK.AFInAppEventParameterName = ((AFg1iSDK.AFInAppEventParameterName + c3) - 1) % c3;
                                int i6 = (AFg1iSDK.AFInAppEventType * c3) + AFg1iSDK.afInfoLog;
                                int i7 = (AFg1iSDK.AFInAppEventParameterName * c3) + AFg1iSDK.afRDLog;
                                int i8 = AFg1iSDK.values;
                                cArr3[i8] = cArr2[i6];
                                cArr3[i8 + 1] = cArr2[i7];
                            } else if (AFg1iSDK.AFInAppEventType == AFg1iSDK.AFInAppEventParameterName) {
                                AFg1iSDK.afInfoLog = ((AFg1iSDK.afInfoLog + c3) - 1) % c3;
                                AFg1iSDK.afRDLog = ((AFg1iSDK.afRDLog + c3) - 1) % c3;
                                int i9 = (AFg1iSDK.AFInAppEventType * c3) + AFg1iSDK.afInfoLog;
                                int i10 = (AFg1iSDK.AFInAppEventParameterName * c3) + AFg1iSDK.afRDLog;
                                int i11 = AFg1iSDK.values;
                                cArr3[i11] = cArr2[i9];
                                cArr3[i11 + 1] = cArr2[i10];
                            } else {
                                int i12 = (AFg1iSDK.AFInAppEventType * c3) + AFg1iSDK.afRDLog;
                                int i13 = (AFg1iSDK.AFInAppEventParameterName * c3) + AFg1iSDK.afInfoLog;
                                int i14 = AFg1iSDK.values;
                                cArr3[i14] = cArr2[i12];
                                cArr3[i14 + 1] = cArr2[i13];
                            }
                        }
                        AFg1iSDK.values += 2;
                    }
                }
                for (int i15 = 0; i15 < i3; i15++) {
                    cArr3[i15] = (char) (cArr3[i15] ^ 13722);
                }
                str2 = new String(cArr3);
            } catch (Throwable th) {
                throw th;
            }
        }
        objArr[0] = str2;
    }
}
