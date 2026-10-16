package com.appsflyer.internal;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.view.WindowManager;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinEventTypes;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFa1gSDK;
import com.appsflyer.internal.AFb1cSDK;
import com.appsflyer.internal.AFc1tSDK;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.UserDataStore;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.ServerProtocol;
import com.google.common.cache.LSNn.vfptEEmYY;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import com.superwall.sdk.identity.Keys;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
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
public final class AFe1tSDK implements AFe1rSDK {
    private static char[] AppsFlyer2dXConversionCallback = {'1', 'e', 'V', 'R', 'j', 'l', 'e', 'g', 'm', 'r', 's', '`', 'V', 'k', 'q', '2', 'i', 'g', 'i', 'j'};
    private static int init = 0;
    private static int onAppOpenAttributionNative = 1;
    private final AFb1cSDK AFInAppEventParameterName;
    private final Context AFInAppEventType;
    private final AFf1cSDK AFKeystoreWrapper;
    private final AFa1gSDK AFLogger;
    private final AFb1xSDK AFLogger$LogLevel;
    private final Lazy AFVersionDeclaration;
    private final AFb1gSDK afDebugLog;
    private final AFe1pSDK afErrorLog;
    private final Lazy afErrorLogForExcManagerOnly;
    private final AFb1fSDK afInfoLog;
    private final AFe1hSDK afRDLog;
    private final AFb1tSDK afWarnLog;
    private final AFc1zSDK getLevel;
    private final AFa1kSDK valueOf;
    private final AFf1tSDK values;

    public AFe1tSDK(Context context, AFf1tSDK aFf1tSDK, AFb1cSDK aFb1cSDK, AFf1cSDK aFf1cSDK, AFa1kSDK aFa1kSDK, AFe1hSDK aFe1hSDK, AFb1fSDK aFb1fSDK, AFb1gSDK aFb1gSDK, AFa1gSDK aFa1gSDK, AFe1pSDK aFe1pSDK, AFb1xSDK aFb1xSDK, AFc1zSDK aFc1zSDK, AFb1tSDK aFb1tSDK) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(aFf1tSDK, "");
        Intrinsics.checkNotNullParameter(aFb1cSDK, "");
        Intrinsics.checkNotNullParameter(aFf1cSDK, "");
        Intrinsics.checkNotNullParameter(aFa1kSDK, "");
        Intrinsics.checkNotNullParameter(aFe1hSDK, "");
        Intrinsics.checkNotNullParameter(aFb1fSDK, "");
        Intrinsics.checkNotNullParameter(aFb1gSDK, "");
        Intrinsics.checkNotNullParameter(aFa1gSDK, "");
        Intrinsics.checkNotNullParameter(aFe1pSDK, "");
        Intrinsics.checkNotNullParameter(aFb1xSDK, "");
        Intrinsics.checkNotNullParameter(aFc1zSDK, "");
        Intrinsics.checkNotNullParameter(aFb1tSDK, "");
        this.AFInAppEventType = context;
        this.values = aFf1tSDK;
        this.AFInAppEventParameterName = aFb1cSDK;
        this.AFKeystoreWrapper = aFf1cSDK;
        this.valueOf = aFa1kSDK;
        this.afRDLog = aFe1hSDK;
        this.afInfoLog = aFb1fSDK;
        this.afDebugLog = aFb1gSDK;
        this.AFLogger = aFa1gSDK;
        this.afErrorLog = aFe1pSDK;
        this.AFLogger$LogLevel = aFb1xSDK;
        this.getLevel = aFc1zSDK;
        this.afWarnLog = aFb1tSDK;
        this.AFVersionDeclaration = LazyKt.b(new Function0<AppsFlyerProperties>() { // from class: com.appsflyer.internal.AFe1tSDK.2
            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: values, reason: merged with bridge method [inline-methods] */
            public final AppsFlyerProperties invoke() {
                return AppsFlyerProperties.getInstance();
            }
        });
        this.afErrorLogForExcManagerOnly = LazyKt.b(new Function0<SimpleDateFormat>() { // from class: com.appsflyer.internal.AFe1tSDK.1
            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: valueOf, reason: merged with bridge method [inline-methods] */
            public final SimpleDateFormat invoke() {
                return new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
            }
        });
    }

    private final AppsFlyerProperties AFInAppEventParameterName() {
        int i3 = init + 27;
        onAppOpenAttributionNative = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            throw null;
        }
        AppsFlyerProperties appsFlyerProperties = (AppsFlyerProperties) this.AFVersionDeclaration.getValue();
        int i4 = onAppOpenAttributionNative + 113;
        init = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 == 0) {
            return appsFlyerProperties;
        }
        throw null;
    }

    private void AFInAppEventType(Map<String, Object> map) {
        String str = "";
        Intrinsics.checkNotNullParameter(map, "");
        Object systemService = this.AFInAppEventType.getSystemService("window");
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager == null) {
            onAppOpenAttributionNative = (init + 17) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            return;
        }
        int rotation = windowManager.getDefaultDisplay().getRotation();
        if (rotation == 0) {
            onAppOpenAttributionNative = (init + 59) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            str = "p";
        } else if (rotation == 1) {
            str = "l";
        } else if (rotation == 2) {
            str = "pr";
        } else if (rotation == 3) {
            str = "lr";
        }
        map.put("sc_o", str);
    }

    private void AFLogger(Map<String, Object> map) {
        onAppOpenAttributionNative = (init + 105) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        Intrinsics.checkNotNullParameter(map, "");
        String string = AFInAppEventParameterName().getString(AppsFlyerProperties.ONELINK_ID);
        String string2 = AFInAppEventParameterName().getString(AppsFlyerProperties.ONELINK_VERSION);
        if (string != null) {
            map.put("onelink_id", string);
        }
        if (string2 != null) {
            int i3 = init + 81;
            onAppOpenAttributionNative = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            int i4 = i3 % 2;
            map.put("onelink_ver", string2);
            if (i4 == 0) {
                int i5 = 22 / 0;
            }
        }
    }

    private static void AFLogger$LogLevel(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        Object objValues = AFb1rSDK.values();
        String strAFKeystoreWrapper = AFb1rSDK.AFKeystoreWrapper();
        if (objValues != null && strAFKeystoreWrapper != null && Integer.parseInt(strAFKeystoreWrapper) > 0) {
            int i3 = init + 31;
            onAppOpenAttributionNative = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i3 % 2 == 0) {
                map.put("reinstallCounter", strAFKeystoreWrapper);
                map.put("originalAppsflyerId", objValues);
                throw null;
            }
            map.put("reinstallCounter", strAFKeystoreWrapper);
            map.put("originalAppsflyerId", objValues);
        }
        onAppOpenAttributionNative = (init + 107) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    private boolean AFVersionDeclaration() {
        onAppOpenAttributionNative = (init + 31) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        try {
            Object systemService = this.AFInAppEventType.getSystemService("connectivity");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            Network[] allNetworks = connectivityManager.getAllNetworks();
            Intrinsics.checkNotNullExpressionValue(allNetworks, cJfnYMIyomoWf.zBwcOOPC);
            for (Network network : allNetworks) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                if (networkCapabilities != null) {
                    init = (onAppOpenAttributionNative + 13) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                    if (networkCapabilities.hasTransport(4)) {
                        init = (onAppOpenAttributionNative + 37) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        if (!networkCapabilities.hasCapability(15)) {
                            int i3 = (onAppOpenAttributionNative + 83) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                            init = i3;
                            onAppOpenAttributionNative = (i3 + 37) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                            return true;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return false;
        } catch (Exception e3) {
            AFLogger.afErrorLog("Failed collecting ivc data", e3);
            return false;
        }
    }

    private void AppsFlyer2dXConversionCallback(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        try {
            String strValueOf = AFa1aSDK.valueOf(this.getLevel, this.afInfoLog);
            if (strValueOf != null) {
                int i3 = onAppOpenAttributionNative + 39;
                init = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                if (i3 % 2 == 0) {
                    map.put("uid", strValueOf);
                    return;
                } else {
                    map.put("uid", strValueOf);
                    throw null;
                }
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("ERROR: could not get uid ");
            sb.append(th.getMessage());
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "");
            AFLogger.afErrorLog(string, th);
        }
        int i4 = onAppOpenAttributionNative + 21;
        init = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 != 0) {
            throw null;
        }
    }

    private final void afDebugLog(Map<String, Object> map) {
        String str;
        int i3 = init + 99;
        onAppOpenAttributionNative = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            AFb1cSDK.AFa1ySDK aFa1ySDKValueOf = this.AFInAppEventParameterName.valueOf(this.AFInAppEventType);
            float f3 = aFa1ySDKValueOf.AFInAppEventType;
            str = aFa1ySDKValueOf.valueOf;
            map.put("btl", String.valueOf(f3));
            int i4 = 70 / 0;
            if (str == null) {
                return;
            }
        } else {
            AFb1cSDK.AFa1ySDK aFa1ySDKValueOf2 = this.AFInAppEventParameterName.valueOf(this.AFInAppEventType);
            float f4 = aFa1ySDKValueOf2.AFInAppEventType;
            str = aFa1ySDKValueOf2.valueOf;
            map.put("btl", String.valueOf(f4));
            if (str == null) {
                return;
            }
        }
        onAppOpenAttributionNative = (init + 61) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        map.put("btch", str);
        onAppOpenAttributionNative = (init + 3) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    private boolean afErrorLog() {
        int i3 = init + 77;
        onAppOpenAttributionNative = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            this.afInfoLog.values("appsFlyerCount");
            throw null;
        }
        if (this.afInfoLog.values("appsFlyerCount")) {
            return false;
        }
        int i4 = onAppOpenAttributionNative + 85;
        init = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 == 0) {
            return true;
        }
        throw null;
    }

    private String afErrorLogForExcManagerOnly() {
        String string = AFInAppEventParameterName().getString("preInstallName");
        if (string != null) {
            int i3 = onAppOpenAttributionNative + 1;
            init = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i3 % 2 == 0) {
                return string;
            }
            throw null;
        }
        if (this.afInfoLog.values("preInstallName")) {
            string = this.afInfoLog.AFKeystoreWrapper("preInstallName", null);
            onAppOpenAttributionNative = (init + 85) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            if (afErrorLog() && (string = AFLogger$LogLevel()) == null) {
                string = values("AF_PRE_INSTALL_NAME");
            }
            if (string != null) {
                int i4 = init + 29;
                onAppOpenAttributionNative = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                if (i4 % 2 == 0) {
                    this.afInfoLog.values("preInstallName", string);
                    throw null;
                }
                this.afInfoLog.values("preInstallName", string);
            }
        }
        if (string != null) {
            AFInAppEventParameterName().set("preInstallName", string);
        }
        return string;
    }

    private void afInfoLog(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        AFe1hSDK aFe1hSDK = this.afRDLog;
        HashMap map2 = new HashMap(aFe1hSDK.AFKeystoreWrapper);
        aFe1hSDK.AFKeystoreWrapper.clear();
        this.afRDLog.AFInAppEventType.AFInAppEventParameterName("gcd");
        Intrinsics.checkNotNullExpressionValue(map2, "");
        if (map2.isEmpty()) {
            init = (onAppOpenAttributionNative + 33) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            return;
        }
        int i3 = (init + 63) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        onAppOpenAttributionNative = i3;
        int i4 = i3 + 43;
        init = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 == 0) {
            Map<String, Object> mapAFInAppEventParameterName = AFa1bSDK.AFInAppEventParameterName(map);
            Intrinsics.checkNotNullExpressionValue(mapAFInAppEventParameterName, "");
            mapAFInAppEventParameterName.put("gcd", map2);
        } else {
            Map<String, Object> mapAFInAppEventParameterName2 = AFa1bSDK.AFInAppEventParameterName(map);
            Intrinsics.checkNotNullExpressionValue(mapAFInAppEventParameterName2, "");
            mapAFInAppEventParameterName2.put("gcd", map2);
            int i5 = 16 / 0;
        }
    }

    private String afRDLog() {
        String string = AFInAppEventParameterName().getString(AppsFlyerProperties.AF_STORE_FROM_API);
        if (string == null) {
            init = (onAppOpenAttributionNative + 31) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            string = values("AF_STORE");
        }
        onAppOpenAttributionNative = (init + 119) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return string;
    }

    private final void afWarnLog(Map<String, Object> map) {
        UiModeManager uiModeManager = (UiModeManager) this.AFInAppEventType.getSystemService(UiModeManager.class);
        onAppOpenAttributionNative = (init + 79) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (uiModeManager != null && uiModeManager.getCurrentModeType() == 4) {
            map.put("tv", Boolean.TRUE);
        }
        onAppOpenAttributionNative = (init + 31) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    private void getLevel(Map<String, Object> map) {
        long j3;
        Intrinsics.checkNotNullParameter(map, "");
        long jAFInAppEventParameterName = this.afInfoLog.AFInAppEventParameterName("AppsFlyerTimePassedSincePrevLaunch", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.afInfoLog.AFInAppEventType("AppsFlyerTimePassedSincePrevLaunch", jCurrentTimeMillis);
        if (jAFInAppEventParameterName > 0) {
            int i3 = (onAppOpenAttributionNative + 123) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            init = i3;
            j3 = (jCurrentTimeMillis - jAFInAppEventParameterName) / 1000;
            onAppOpenAttributionNative = (i3 + 15) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            init = (onAppOpenAttributionNative + 77) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            j3 = -1;
        }
        map.put("timepassedsincelastlaunch", String.valueOf(j3));
    }

    private void init(Map<String, Object> map) {
        int i3 = onAppOpenAttributionNative + 61;
        init = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            Intrinsics.checkNotNullParameter(map, "");
            map.putAll(this.afWarnLog.AFKeystoreWrapper());
            int i4 = 88 / 0;
        } else {
            Intrinsics.checkNotNullParameter(map, "");
            map.putAll(this.afWarnLog.AFKeystoreWrapper());
        }
        init = (onAppOpenAttributionNative + 57) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    private static void onAppOpenAttributionNative(Map<String, Object> map) {
        int i3 = onAppOpenAttributionNative + 99;
        init = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        try {
        } catch (Exception e3) {
            AFLogger.afErrorLog("Exception while collecting display language name. ", e3);
        }
        if (i3 % 2 != 0) {
            Intrinsics.checkNotNullParameter(map, "");
            map.put("lang", Locale.getDefault().getDisplayLanguage());
            throw null;
        }
        Intrinsics.checkNotNullParameter(map, "");
        map.put("lang", Locale.getDefault().getDisplayLanguage());
        try {
            map.put("lang_code", Locale.getDefault().getLanguage());
        } catch (Exception e4) {
            AFLogger.afErrorLog("Exception while collecting display language code. ", e4);
        }
        try {
            map.put(UserDataStore.COUNTRY, Locale.getDefault().getCountry());
            init = (onAppOpenAttributionNative + 101) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } catch (Exception e5) {
            AFLogger.afErrorLog("Exception while collecting country name. ", e5);
        }
    }

    private void onAttributionFailureNative(Map<String, Object> map) {
        init = (onAppOpenAttributionNative + 123) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        Intrinsics.checkNotNullParameter(map, "");
        AFc1tSDK.AFa1wSDK aFa1wSDKAFInAppEventParameterName = AFa1eSDK.AFInAppEventParameterName(this.AFInAppEventType.getContentResolver());
        if (aFa1wSDKAFInAppEventParameterName != null) {
            map.put("amazon_aid", aFa1wSDKAFInAppEventParameterName.AFInAppEventParameterName);
            map.put("amazon_aid_limit", String.valueOf(aFa1wSDKAFInAppEventParameterName.AFInAppEventType));
            int i3 = init + 11;
            onAppOpenAttributionNative = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i3 % 2 == 0) {
                throw null;
            }
        }
    }

    private void onDeepLinkingNative(Map<String, Object> map) {
        onAppOpenAttributionNative = (init + 21) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        Intrinsics.checkNotNullParameter(map, "");
        if (this.afInfoLog.values("is_stop_tracking_used")) {
            init = (onAppOpenAttributionNative + 83) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            map.put("istu", String.valueOf(this.afInfoLog.AFInAppEventType("is_stop_tracking_used")));
        }
        init = (onAppOpenAttributionNative + 95) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    private void onInstallConversionDataLoadedNative(Map<String, Object> map) {
        int i3 = onAppOpenAttributionNative + 93;
        init = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            Intrinsics.checkNotNullParameter(map, "");
            AFInAppEventParameterName().getString(AppsFlyerProperties.EXTENSION);
            throw null;
        }
        Intrinsics.checkNotNullParameter(map, "");
        String string = AFInAppEventParameterName().getString(AppsFlyerProperties.EXTENSION);
        if (string == null || string.length() == 0) {
            return;
        }
        map.put(AppsFlyerProperties.EXTENSION, string);
        onAppOpenAttributionNative = (init + 115) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void onInstallConversionFailureNative(java.util.Map<java.lang.String, java.lang.Object> r5) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            com.appsflyer.internal.AFb1gSDK r1 = r4.afDebugLog
            java.lang.String r1 = r1.AFKeystoreWrapper()
            com.appsflyer.internal.AFb1fSDK r2 = r4.afInfoLog
            java.lang.String r2 = values(r2, r1)
            if (r2 == 0) goto L19
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r1)
            if (r3 == 0) goto L25
        L19:
            if (r2 != 0) goto L32
            int r2 = com.appsflyer.internal.AFe1tSDK.init
            int r2 = r2 + 53
            int r2 = r2 % 128
            com.appsflyer.internal.AFe1tSDK.onAppOpenAttributionNative = r2
            if (r1 == 0) goto L32
        L25:
            java.lang.String r2 = "af_latestchannel"
            r5.put(r2, r1)
            int r1 = com.appsflyer.internal.AFe1tSDK.init
            int r1 = r1 + 85
            int r1 = r1 % 128
            com.appsflyer.internal.AFe1tSDK.onAppOpenAttributionNative = r1
        L32:
            java.lang.String r1 = r4.afDebugLog()
            if (r1 == 0) goto L6b
            int r2 = com.appsflyer.internal.AFe1tSDK.onAppOpenAttributionNative
            int r2 = r2 + 123
            int r3 = r2 % 128
            com.appsflyer.internal.AFe1tSDK.init = r3
            int r2 = r2 % 2
            java.lang.String r3 = "af_installstore"
            if (r2 != 0) goto L58
            java.util.Locale r2 = java.util.Locale.getDefault()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            java.lang.String r1 = r1.toLowerCase(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r5.put(r3, r1)
            goto L6b
        L58:
            java.util.Locale r2 = java.util.Locale.getDefault()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            java.lang.String r1 = r1.toLowerCase(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r5.put(r3, r1)
            r5 = 0
            throw r5
        L6b:
            java.lang.String r1 = r4.afErrorLogForExcManagerOnly()
            if (r1 == 0) goto L84
            java.util.Locale r2 = java.util.Locale.getDefault()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            java.lang.String r1 = r1.toLowerCase(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            java.lang.String r2 = "af_preinstall_name"
            r5.put(r2, r1)
        L84:
            java.lang.String r1 = r4.afRDLog()
            if (r1 == 0) goto Lad
            java.util.Locale r2 = java.util.Locale.getDefault()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            java.lang.String r1 = r1.toLowerCase(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            java.lang.String r0 = "af_currentstore"
            r5.put(r0, r1)
            int r5 = com.appsflyer.internal.AFe1tSDK.onAppOpenAttributionNative
            int r5 = r5 + 55
            int r0 = r5 % 128
            com.appsflyer.internal.AFe1tSDK.init = r0
            int r5 = r5 % 2
            if (r5 == 0) goto Lad
            r5 = 50
            int r5 = r5 / 0
        Lad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1tSDK.onInstallConversionFailureNative(java.util.Map):void");
    }

    private void onResponseErrorNative(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        String str = this.afErrorLog.values;
        if (str == null || str.length() == 0) {
            onAppOpenAttributionNative = (init + 107) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            map.put("appsflyerKey", str);
        }
        int i3 = onAppOpenAttributionNative + 67;
        init = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            throw null;
        }
    }

    private void onResponseNative(Map<String, Object> map) {
        int i3 = init + 55;
        onAppOpenAttributionNative = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            Intrinsics.checkNotNullParameter(map, "");
            AFLogger.afDebugLog("didConfigureTokenRefreshService=".concat(String.valueOf(AFe1sSDK.values(this.AFInAppEventType))));
            throw null;
        }
        Intrinsics.checkNotNullParameter(map, "");
        boolean zValues = AFe1sSDK.values(this.AFInAppEventType);
        AFLogger.afDebugLog("didConfigureTokenRefreshService=".concat(String.valueOf(zValues)));
        if (!zValues) {
            map.put("tokenRefreshConfigured", Boolean.FALSE);
            onAppOpenAttributionNative = (init + 103) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        map.put("registeredUninstall", Boolean.valueOf(AFe1sSDK.AFKeystoreWrapper(this.afInfoLog)));
    }

    private String valueOf(SimpleDateFormat simpleDateFormat) throws UnsupportedEncodingException {
        String str = "";
        Intrinsics.checkNotNullParameter(simpleDateFormat, "");
        String strAFKeystoreWrapper = this.afInfoLog.AFKeystoreWrapper("appsFlyerFirstInstall", null);
        if (strAFKeystoreWrapper == null) {
            onAppOpenAttributionNative = (init + 123) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (afErrorLog()) {
                AFLogger.afDebugLog("AppsFlyer: first launch detected");
                str = simpleDateFormat.format(new Date());
            }
            this.afInfoLog.values("appsFlyerFirstInstall", str);
            init = (onAppOpenAttributionNative + 121) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            strAFKeystoreWrapper = str;
        }
        AFLogger.afInfoLog("AppsFlyer: first launch date: ".concat(String.valueOf(strAFKeystoreWrapper)));
        Object[] objArr = new Object[1];
        values("\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001", new int[]{0, 15, 0, 6}, false, objArr);
        Intrinsics.checkNotNullExpressionValue(strAFKeystoreWrapper, ((String) objArr[0]).intern());
        return strAFKeystoreWrapper;
    }

    @Override // com.appsflyer.internal.AFe1rSDK
    public final void AFKeystoreWrapper(Map<String, Object> map, AFa1fSDK aFa1fSDK) {
        String[] strArr;
        Intrinsics.checkNotNullParameter(map, "");
        String string = AFInAppEventParameterName().getString(AppsFlyerProperties.APP_ID);
        if (string != null) {
            onAppOpenAttributionNative = (init + 111) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            map.put(AppsFlyerProperties.APP_ID, string);
        }
        String string2 = AFInAppEventParameterName().getString(AppsFlyerProperties.CURRENCY_CODE);
        if (string2 != null) {
            if (string2.length() != 3) {
                StringBuilder sb = new StringBuilder("WARNING: currency code should be 3 characters!!! '");
                sb.append(string2);
                sb.append("' is not a legal value.");
                AFLogger.afWarnLog(sb.toString());
            }
            map.put(AppLovinEventParameters.REVENUE_CURRENCY, string2);
        }
        String string3 = AFInAppEventParameterName().getString(AppsFlyerProperties.IS_UPDATE);
        if (string3 != null) {
            int i3 = onAppOpenAttributionNative + 39;
            init = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i3 % 2 != 0) {
                map.put("isUpdate", string3);
                int i4 = 49 / 0;
            } else {
                map.put("isUpdate", string3);
            }
        }
        String string4 = AFInAppEventParameterName().getString(AppsFlyerProperties.ADDITIONAL_CUSTOM_DATA);
        if (string4 != null) {
            int i5 = onAppOpenAttributionNative + 123;
            init = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i5 % 2 != 0) {
                map.put("customData", string4);
                throw null;
            }
            map.put("customData", string4);
        }
        String string5 = AFInAppEventParameterName().getString(AppsFlyerProperties.APP_USER_ID);
        if (string5 != null) {
            init = (onAppOpenAttributionNative + 45) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            map.put(Keys.APP_USER_ID, string5);
        }
        String string6 = AFInAppEventParameterName().getString(AppsFlyerProperties.USER_EMAILS);
        if (string6 != null) {
            map.put("user_emails", string6);
        }
        if (aFa1fSDK == null || (strArr = aFa1fSDK.AFKeystoreWrapper) == null) {
            return;
        }
        onAppOpenAttributionNative = (init + 105) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        map.put("sharing_filter", strArr);
    }

    @Override // com.appsflyer.internal.AFe1rSDK
    public final void values(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, vfptEEmYY.bMHnr);
        boolean z2 = AFInAppEventParameterName().getBoolean(AppsFlyerProperties.DISABLE_NETWORK_DATA, false);
        AFa1gSDK.AFa1zSDK aFa1zSDKAFKeystoreWrapper = this.AFLogger.AFKeystoreWrapper(this.AFInAppEventType);
        map.put("network", aFa1zSDKAFKeystoreWrapper.values);
        if (z2) {
            onAppOpenAttributionNative = (init + 47) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            return;
        }
        String str = aFa1zSDKAFKeystoreWrapper.valueOf;
        if (str != null) {
            map.put("operator", str);
        }
        String str2 = aFa1zSDKAFKeystoreWrapper.AFInAppEventParameterName;
        if (str2 != null) {
            init = (onAppOpenAttributionNative + 93) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            map.put("carrier", str2);
        }
    }

    private final void afErrorLog(Map<String, Object> map) {
        if (AFInAppEventParameterName().isOtherSdkStringDisabled()) {
            return;
        }
        int i3 = onAppOpenAttributionNative + 1;
        init = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            map.put("batteryLevel", String.valueOf(this.AFInAppEventParameterName.valueOf(this.AFInAppEventType).AFInAppEventType));
            int i4 = 85 / 0;
        } else {
            map.put("batteryLevel", String.valueOf(this.AFInAppEventParameterName.valueOf(this.AFInAppEventType).AFInAppEventType));
        }
        onAppOpenAttributionNative = (init + 39) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    @Override // com.appsflyer.internal.AFe1rSDK
    public final void AFInAppEventParameterName(AFa1tSDK aFa1tSDK, String str, AFb1hSDK aFb1hSDK) {
        int i3 = init + 61;
        onAppOpenAttributionNative = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            Intrinsics.checkNotNullParameter(aFa1tSDK, "");
            aFa1tSDK.AFKeystoreWrapper();
            aFa1tSDK.AFInAppEventParameterName();
            throw null;
        }
        Intrinsics.checkNotNullParameter(aFa1tSDK, "");
        Map<String, Object> mapAFKeystoreWrapper = aFa1tSDK.AFKeystoreWrapper();
        if (aFa1tSDK.AFInAppEventParameterName()) {
            Intrinsics.checkNotNullExpressionValue(mapAFKeystoreWrapper, "");
            AFKeystoreWrapper(mapAFKeystoreWrapper, aFa1tSDK.afRDLog, str, aFb1hSDK);
            init = (onAppOpenAttributionNative + 15) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            Intrinsics.checkNotNullExpressionValue(mapAFKeystoreWrapper, "");
            String str2 = aFa1tSDK.afErrorLog;
            Intrinsics.checkNotNullExpressionValue(str2, "");
            AFInAppEventType(mapAFKeystoreWrapper, str2);
        }
        onResponseErrorNative(mapAFKeystoreWrapper);
        AFLogger$LogLevel(mapAFKeystoreWrapper);
        init(mapAFKeystoreWrapper);
        onInstallConversionDataLoadedNative(mapAFKeystoreWrapper);
        AppsFlyer2dXConversionCallback(mapAFKeystoreWrapper);
        valueOf(mapAFKeystoreWrapper, aFa1tSDK.AFInAppEventParameterName());
        onResponseNative(mapAFKeystoreWrapper);
        onDeepLinkingNative(mapAFKeystoreWrapper);
        valueOf(mapAFKeystoreWrapper, aFa1tSDK);
        mapAFKeystoreWrapper.put("af_events_api", AppEventsConstants.EVENT_PARAM_VALUE_YES);
    }

    private static void afRDLog(Map<String, Object> map) throws UnsupportedEncodingException {
        init = (onAppOpenAttributionNative + 125) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        Intrinsics.checkNotNullParameter(map, "");
        Object[] objArr = new Object[1];
        values("\u0000\u0000\u0001\u0001\u0000", new int[]{15, 5, 0, 0}, true, objArr);
        map.put(((String) objArr[0]).intern(), Build.BRAND);
        map.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, Build.DEVICE);
        map.put(AppLovinEventTypes.USER_VIEWED_PRODUCT, Build.PRODUCT);
        map.put("sdk", String.valueOf(Build.VERSION.SDK_INT));
        map.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL);
        map.put("deviceType", Build.TYPE);
        init = (onAppOpenAttributionNative + 123) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    private boolean AFLogger() {
        onAppOpenAttributionNative = (init + 117) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        boolean z2 = Boolean.parseBoolean(this.afInfoLog.AFKeystoreWrapper("sentSuccessfully", null));
        int i3 = init + 59;
        onAppOpenAttributionNative = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            return z2;
        }
        throw null;
    }

    private final SimpleDateFormat AFInAppEventType() {
        int i3 = init + 63;
        onAppOpenAttributionNative = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            return (SimpleDateFormat) this.afErrorLogForExcManagerOnly.getValue();
        }
        throw null;
    }

    private final boolean getLevel() {
        int i3 = onAppOpenAttributionNative + 89;
        init = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0 ? !AFInAppEventParameterName().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) : !AFInAppEventParameterName().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, true)) {
            if (!AFInAppEventParameterName().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false)) {
                AFa1bSDK.values();
                if (AFa1bSDK.AFInAppEventParameterName(this.AFInAppEventType)) {
                    int i4 = onAppOpenAttributionNative + 97;
                    init = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                    if (i4 % 2 != 0) {
                        int i5 = 72 / 0;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.appsflyer.internal.AFe1rSDK
    public final void AFInAppEventType(AFa1tSDK aFa1tSDK, int i3, String str) throws UnsupportedEncodingException {
        onAppOpenAttributionNative = (init + 51) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        Intrinsics.checkNotNullParameter(aFa1tSDK, "");
        Map<String, Object> mapAFKeystoreWrapper = aFa1tSDK.AFKeystoreWrapper();
        Intrinsics.checkNotNullExpressionValue(mapAFKeystoreWrapper, "");
        AFKeystoreWrapper(mapAFKeystoreWrapper, aFa1tSDK.AFInAppEventParameterName(), i3);
        AFKeystoreWrapper(aFa1tSDK, mapAFKeystoreWrapper);
        afRDLog(mapAFKeystoreWrapper);
        AFInAppEventType(mapAFKeystoreWrapper);
        onAppOpenAttributionNative(mapAFKeystoreWrapper);
        values(mapAFKeystoreWrapper);
        values(mapAFKeystoreWrapper, str);
        onAttributionFailureNative(mapAFKeystoreWrapper);
        mapAFKeystoreWrapper.put("ivc", Boolean.valueOf(AFVersionDeclaration()));
        mapAFKeystoreWrapper.put("cell", MapsKt.mapOf(TuplesKt.a("mcc", Integer.valueOf(this.AFInAppEventType.getResources().getConfiguration().mcc)), TuplesKt.a("mnc", Integer.valueOf(this.AFInAppEventType.getResources().getConfiguration().mnc))));
        mapAFKeystoreWrapper.put("sig", values());
        mapAFKeystoreWrapper.put("last_boot_time", Long.valueOf(valueOf()));
        mapAFKeystoreWrapper.put("disk", afInfoLog());
        int i4 = onAppOpenAttributionNative + 17;
        init = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 != 0) {
            throw null;
        }
    }

    private final String AFLogger$LogLevel() {
        File fileAFKeystoreWrapper = AFKeystoreWrapper(AFInAppEventType("ro.appsflyer.preinstall.path"));
        if (AFKeystoreWrapper(fileAFKeystoreWrapper)) {
            int i3 = onAppOpenAttributionNative + 103;
            init = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i3 % 2 != 0) {
                fileAFKeystoreWrapper = AFKeystoreWrapper(values("AF_PRE_INSTALL_PATH"));
                int i4 = 6 / 0;
            } else {
                fileAFKeystoreWrapper = AFKeystoreWrapper(values("AF_PRE_INSTALL_PATH"));
            }
        }
        if (AFKeystoreWrapper(fileAFKeystoreWrapper)) {
            fileAFKeystoreWrapper = AFKeystoreWrapper("/data/local/tmp/pre_install.appsflyer");
        }
        if (AFKeystoreWrapper(fileAFKeystoreWrapper)) {
            int i5 = init + 89;
            onAppOpenAttributionNative = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i5 % 2 == 0) {
                AFKeystoreWrapper("/etc/pre_install.appsflyer");
                throw null;
            }
            fileAFKeystoreWrapper = AFKeystoreWrapper("/etc/pre_install.appsflyer");
        }
        if (AFKeystoreWrapper(fileAFKeystoreWrapper)) {
            return null;
        }
        String packageName = this.AFInAppEventType.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "");
        return AFInAppEventType(fileAFKeystoreWrapper, packageName);
    }

    private static void valueOf(Map<String, Object> map, String str) {
        Intrinsics.checkNotNullParameter(map, "");
        if (str != null) {
            onAppOpenAttributionNative = (init + 91) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            map.put("phone", str);
        }
        onAppOpenAttributionNative = (init + 55) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    private String afDebugLog() {
        int i3 = onAppOpenAttributionNative + 83;
        init = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        String strAfRDLog = null;
        if (i3 % 2 == 0) {
            if (this.afInfoLog.values("INSTALL_STORE")) {
                init = (onAppOpenAttributionNative + 31) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                return this.afInfoLog.AFKeystoreWrapper("INSTALL_STORE", null);
            }
            if (afErrorLog()) {
                strAfRDLog = afRDLog();
                onAppOpenAttributionNative = (init + 15) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            }
            this.afInfoLog.values("INSTALL_STORE", strAfRDLog);
            return strAfRDLog;
        }
        this.afInfoLog.values("INSTALL_STORE");
        throw null;
    }

    private final void AFVersionDeclaration(Map<String, Object> map) {
        int i3 = init + 81;
        onAppOpenAttributionNative = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            if (AFe1mSDK.AFKeystoreWrapper(this.AFInAppEventType)) {
                int i4 = onAppOpenAttributionNative + 121;
                init = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                if (i4 % 2 == 0) {
                    map.put("inst_app", Boolean.TRUE);
                    return;
                } else {
                    map.put("inst_app", Boolean.TRUE);
                    throw null;
                }
            }
            return;
        }
        AFe1mSDK.AFKeystoreWrapper(this.AFInAppEventType);
        throw null;
    }

    private void afErrorLogForExcManagerOnly(Map<String, Object> map) {
        long j3;
        int i3 = init + 121;
        onAppOpenAttributionNative = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            Intrinsics.checkNotNullParameter(map, "");
            j3 = this.afRDLog.AFLogger$LogLevel;
            if (j3 == 0) {
                return;
            }
        } else {
            Intrinsics.checkNotNullParameter(map, "");
            j3 = this.afRDLog.AFLogger$LogLevel;
            if (j3 == 0) {
                return;
            }
        }
        int i4 = onAppOpenAttributionNative + 67;
        init = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 == 0) {
            map.put("prev_session_dur", Long.valueOf(j3));
        } else {
            map.put("prev_session_dur", Long.valueOf(j3));
            throw null;
        }
    }

    private static String afInfoLog() {
        long blockSizeLong;
        long availableBlocksLong;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
        int i3 = init + 89;
        onAppOpenAttributionNative = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            blockSizeLong = statFs.getBlockSizeLong();
            availableBlocksLong = statFs.getAvailableBlocksLong() + blockSizeLong;
        } else {
            blockSizeLong = statFs.getBlockSizeLong();
            availableBlocksLong = statFs.getAvailableBlocksLong() * blockSizeLong;
        }
        long blockCountLong = statFs.getBlockCountLong() * blockSizeLong;
        double dPow = Math.pow(2.0d, 20.0d);
        StringBuilder sb = new StringBuilder();
        sb.append((long) (availableBlocksLong / dPow));
        sb.append('/');
        sb.append((long) (blockCountLong / dPow));
        String string = sb.toString();
        onAppOpenAttributionNative = (init + 67) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return string;
    }

    private void valueOf(Map<String, Object> map, boolean z2) {
        Intrinsics.checkNotNullParameter(map, "");
        map.put("platformextension", this.AFLogger$LogLevel.values());
        if (z2) {
            int i3 = init + 3;
            onAppOpenAttributionNative = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i3 % 2 == 0) {
                map.put("platform_extension_v2", this.values.AFInAppEventParameterName());
                throw null;
            }
            map.put("platform_extension_v2", this.values.AFInAppEventParameterName());
        }
        int i4 = onAppOpenAttributionNative + 27;
        init = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 != 0) {
            throw null;
        }
    }

    private String values() throws NoSuchAlgorithmException, PackageManager.NameNotFoundException, CertificateException {
        int i3 = onAppOpenAttributionNative + 95;
        init = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            AFa1fSDK.AFInAppEventParameterName(this.AFInAppEventType.getApplicationContext().getPackageManager(), this.AFInAppEventType.getApplicationContext().getPackageName());
            throw null;
        }
        String strAFInAppEventParameterName = AFa1fSDK.AFInAppEventParameterName(this.AFInAppEventType.getApplicationContext().getPackageManager(), this.AFInAppEventType.getApplicationContext().getPackageName());
        int i4 = onAppOpenAttributionNative + 1;
        init = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 == 0) {
            return strAFInAppEventParameterName;
        }
        throw null;
    }

    @Override // com.appsflyer.internal.AFe1rSDK
    public final void values(Map<String, Object> map, int i3, int i4) {
        boolean z2;
        init = (onAppOpenAttributionNative + 101) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        Intrinsics.checkNotNullParameter(map, "");
        map.put("counter", String.valueOf(i3));
        map.put("iaecounter", String.valueOf(i4));
        if (AFLogger()) {
            z2 = false;
        } else {
            onAppOpenAttributionNative = (init + 39) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            z2 = true;
        }
        map.put("isFirstCall", String.valueOf(z2));
    }

    private final void valueOf(Map<String, Object> map) {
        try {
            long j3 = this.AFInAppEventType.getPackageManager().getPackageInfo(this.AFInAppEventType.getPackageName(), 0).firstInstallTime;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            map.put("installDate", simpleDateFormat.format(new Date(j3)));
            int i3 = init + 43;
            onAppOpenAttributionNative = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i3 % 2 == 0) {
                throw null;
            }
        } catch (Exception e3) {
            AFLogger.afErrorLog("Exception while collecting install date. ", e3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void values(java.util.Map<java.lang.String, java.lang.Object> r9, java.lang.String r10) {
        /*
            Method dump skipped, instruction units count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1tSDK.values(java.util.Map, java.lang.String):void");
    }

    private static long valueOf() {
        init = (onAppOpenAttributionNative + 65) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        long jCurrentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        int i3 = onAppOpenAttributionNative + 119;
        init = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            int i4 = 76 / 0;
        }
        return jCurrentTimeMillis;
    }

    private final void AFInAppEventParameterName(Map<String, Object> map) {
        onAppOpenAttributionNative = (init + 81) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        try {
            PackageInfo packageInfo = this.AFInAppEventType.getPackageManager().getPackageInfo(this.AFInAppEventType.getPackageName(), 0);
            int iValues = this.afInfoLog.values("versionCode", 0);
            int i3 = packageInfo.versionCode;
            if (i3 > iValues) {
                this.afInfoLog.AFInAppEventParameterName("versionCode", i3);
                onAppOpenAttributionNative = (init + 119) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            }
            map.put("app_version_code", String.valueOf(packageInfo.versionCode));
            Context context = this.afDebugLog.values.values;
            map.put("app_version_name", AFa1fSDK.AFKeystoreWrapper(context, context.getPackageName()));
            map.put("targetSDKver", Integer.valueOf(this.afDebugLog.values.values.getApplicationInfo().targetSdkVersion));
            long j3 = packageInfo.firstInstallTime;
            long j4 = packageInfo.lastUpdateTime;
            map.put("date1", AFInAppEventType().format(new Date(j3)));
            map.put("date2", AFInAppEventType().format(new Date(j4)));
            Object[] objArr = new Object[1];
            values("\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001", new int[]{0, 15, 0, 6}, false, objArr);
            String strIntern = ((String) objArr[0]).intern();
            SimpleDateFormat simpleDateFormatAFInAppEventType = AFInAppEventType();
            Intrinsics.checkNotNullExpressionValue(simpleDateFormatAFInAppEventType, "");
            map.put(strIntern, valueOf(simpleDateFormatAFInAppEventType));
        } catch (Throwable th) {
            AFLogger.afErrorLog(vfptEEmYY.xJf, th, true);
        }
    }

    private void AFKeystoreWrapper(Map<String, Object> map, String str) {
        Intrinsics.checkNotNullParameter(map, "");
        if (str != null) {
            int i3 = init + 31;
            onAppOpenAttributionNative = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i3 % 2 != 0) {
                if (str.length() != 0) {
                    map.put("referrer", str);
                }
            } else {
                throw null;
            }
        }
        String strAFKeystoreWrapper = this.afInfoLog.AFKeystoreWrapper("extraReferrers", null);
        if (strAFKeystoreWrapper != null) {
            onAppOpenAttributionNative = (init + 75) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            map.put("extraReferrers", strAFKeystoreWrapper);
        }
        String referrer = AFInAppEventParameterName().getReferrer(this.afInfoLog);
        if (referrer == null || referrer.length() == 0 || map.get("referrer") != null) {
            return;
        }
        map.put("referrer", referrer);
    }

    private static void valueOf(Map<String, Object> map, AFa1tSDK aFa1tSDK) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(aFa1tSDK, "");
        String str = aFa1tSDK.afErrorLog;
        if (str != null) {
            map.put("eventName", str);
            Map map2 = aFa1tSDK.AFInAppEventType;
            if (map2 == null) {
                map2 = new HashMap();
            }
            map.put("eventValue", new JSONObject(map2).toString());
        }
    }

    private void AFInAppEventType(Map<String, Object> map, String str) {
        onAppOpenAttributionNative = (init + 119) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(str, "");
        try {
            String strAFKeystoreWrapper = this.afInfoLog.AFKeystoreWrapper("prev_event_name", null);
            if (strAFKeystoreWrapper != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("prev_event_timestamp", this.afInfoLog.AFInAppEventParameterName("prev_event_timestamp", -1L));
                jSONObject.put("prev_event_name", strAFKeystoreWrapper);
                map.put("prev_event", jSONObject);
            }
            this.afInfoLog.values("prev_event_name", str);
            this.afInfoLog.AFInAppEventType("prev_event_timestamp", System.currentTimeMillis());
            onAppOpenAttributionNative = (init + 37) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } catch (Exception e3) {
            AFLogger.afErrorLog("Error while processing previous event.", e3);
        }
    }

    private void AFKeystoreWrapper(Map<String, Object> map, String str, String str2, AFb1hSDK aFb1hSDK) {
        Intrinsics.checkNotNullParameter(map, "");
        if (afErrorLog()) {
            afErrorLog(map);
            afWarnLog(map);
            AFVersionDeclaration(map);
            AFb1rSDK.AFKeystoreWrapper(this.getLevel, this.afInfoLog);
        }
        getLevel(map);
        AFLogger(map);
        afInfoLog(map);
        valueOf(map, str2);
        AFKeystoreWrapper(map, str);
        afErrorLogForExcManagerOnly(map);
        if (aFb1hSDK == null) {
            int i3 = onAppOpenAttributionNative + 37;
            init = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i3 % 2 != 0) {
                int i4 = 89 / 0;
                return;
            }
            return;
        }
        int i5 = onAppOpenAttributionNative + 65;
        init = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        int i6 = i5 % 2;
        aFb1hSDK.AFInAppEventType(map);
        if (i6 != 0) {
            throw null;
        }
    }

    private static String AFInAppEventType(String str) {
        init = (onAppOpenAttributionNative + 103) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
            if (objInvoke != null) {
                String str2 = (String) objInvoke;
                onAppOpenAttributionNative = (init + 69) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                return str2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x003d A[EXC_TOP_SPLITTER, PHI: r2
      0x003d: PHI (r2v4 java.io.InputStreamReader) = (r2v3 java.io.InputStreamReader), (r2v6 java.io.InputStreamReader) binds: [B:17:0x003b, B:26:0x0062] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String AFInAppEventType(java.io.File r5, java.lang.String r6) {
        /*
            r0 = 0
            if (r5 != 0) goto L4
            return r0
        L4:
            java.util.Properties r1 = new java.util.Properties     // Catch: java.lang.Throwable -> L32 java.io.FileNotFoundException -> L4c
            r1.<init>()     // Catch: java.lang.Throwable -> L32 java.io.FileNotFoundException -> L4c
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L32 java.io.FileNotFoundException -> L4c
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L32 java.io.FileNotFoundException -> L4c
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L32 java.io.FileNotFoundException -> L4c
            java.nio.charset.Charset r4 = java.nio.charset.Charset.defaultCharset()     // Catch: java.lang.Throwable -> L32 java.io.FileNotFoundException -> L4c
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L32 java.io.FileNotFoundException -> L4c
            r1.load(r2)     // Catch: java.lang.Throwable -> L30 java.io.FileNotFoundException -> L4d
            java.lang.String r3 = "Found PreInstall property!"
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch: java.lang.Throwable -> L30 java.io.FileNotFoundException -> L4d
            java.lang.String r5 = r1.getProperty(r6)     // Catch: java.lang.Throwable -> L30 java.io.FileNotFoundException -> L4d
            r2.close()     // Catch: java.lang.Throwable -> L27
            return r5
        L27:
            r6 = move-exception
            java.lang.String r0 = r6.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r0, r6)
            return r5
        L30:
            r5 = move-exception
            goto L34
        L32:
            r5 = move-exception
            r2 = r0
        L34:
            java.lang.String r6 = r5.getMessage()     // Catch: java.lang.Throwable -> L4a
            com.appsflyer.AFLogger.afErrorLog(r6, r5)     // Catch: java.lang.Throwable -> L4a
            if (r2 == 0) goto L65
        L3d:
            r2.close()     // Catch: java.lang.Throwable -> L41
            goto L65
        L41:
            r5 = move-exception
            java.lang.String r6 = r5.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r6, r5)
            goto L65
        L4a:
            r5 = move-exception
            goto L6e
        L4c:
            r2 = r0
        L4d:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4a
            java.lang.String r1 = "PreInstall file wasn't found: "
            r6.<init>(r1)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r5 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L4a
            r6.append(r5)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L4a
            com.appsflyer.AFLogger.afDebugLog(r5)     // Catch: java.lang.Throwable -> L4a
            if (r2 == 0) goto L65
            goto L3d
        L65:
            int r5 = com.appsflyer.internal.AFe1tSDK.onAppOpenAttributionNative
            int r5 = r5 + 75
            int r5 = r5 % 128
            com.appsflyer.internal.AFe1tSDK.init = r5
            return r0
        L6e:
            if (r2 != 0) goto L79
            int r6 = com.appsflyer.internal.AFe1tSDK.onAppOpenAttributionNative
            int r6 = r6 + 3
            int r6 = r6 % 128
            com.appsflyer.internal.AFe1tSDK.init = r6
            goto L85
        L79:
            r2.close()     // Catch: java.lang.Throwable -> L7d
            goto L85
        L7d:
            r6 = move-exception
            java.lang.String r0 = r6.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r0, r6)
        L85:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1tSDK.AFInAppEventType(java.io.File, java.lang.String):java.lang.String");
    }

    @Override // com.appsflyer.internal.AFe1rSDK
    public final void AFInAppEventParameterName(Map<String, Object> map, String str) throws JSONException {
        init = (onAppOpenAttributionNative + 49) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        Intrinsics.checkNotNullParameter(map, "");
        if (str != null) {
            init = (onAppOpenAttributionNative + 3) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (map.get("af_deeplink") != null) {
                int i3 = init + 113;
                onAppOpenAttributionNative = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                if (i3 % 2 != 0) {
                    AFLogger.afDebugLog("Skip 'af' payload as deeplink was found by path");
                    return;
                } else {
                    AFLogger.afDebugLog("Skip 'af' payload as deeplink was found by path");
                    throw null;
                }
            }
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("isPush", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            map.put("af_deeplink", jSONObject.toString());
            onAppOpenAttributionNative = (init + 107) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i4 = onAppOpenAttributionNative + 75;
        init = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 != 0) {
            throw null;
        }
    }

    private void AFKeystoreWrapper(Map<String, Object> map, boolean z2, int i3) {
        Intrinsics.checkNotNullParameter(map, "");
        HashMap map2 = new HashMap();
        map2.put("cpu_abi", AFInAppEventType("ro.product.cpu.abi"));
        map2.put("cpu_abi2", AFInAppEventType("ro.product.cpu.abi2"));
        map2.put("arch", AFInAppEventType("os.arch"));
        map2.put("build_display_id", AFInAppEventType("ro.build.display.id"));
        if (z2) {
            onAppOpenAttributionNative = (init + 41) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            afDebugLog(map2);
            if (i3 <= 2) {
                int i4 = init + 3;
                onAppOpenAttributionNative = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                if (i4 % 2 == 0) {
                    map2.putAll(this.AFKeystoreWrapper.values());
                    throw null;
                }
                map2.putAll(this.AFKeystoreWrapper.values());
            }
        }
        map2.put("dim", this.valueOf.AFInAppEventType(this.AFInAppEventType));
        map.put("deviceData", map2);
    }

    private static void values(Map<String, Object> map, boolean z2) {
        int i3 = onAppOpenAttributionNative + 53;
        init = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            Intrinsics.checkNotNullParameter(map, "");
            map.put("af_preinstalled", String.valueOf(z2));
        } else {
            Intrinsics.checkNotNullParameter(map, "");
            map.put("af_preinstalled", String.valueOf(z2));
            int i4 = 40 / 0;
        }
    }

    private static String values(AFb1fSDK aFb1fSDK, String str) {
        int i3 = onAppOpenAttributionNative + 73;
        init = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            String strAFKeystoreWrapper = aFb1fSDK.AFKeystoreWrapper("CACHED_CHANNEL", null);
            if (strAFKeystoreWrapper != null) {
                onAppOpenAttributionNative = (init + 81) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                return strAFKeystoreWrapper;
            }
            aFb1fSDK.values("CACHED_CHANNEL", str);
            init = (onAppOpenAttributionNative + 99) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            return str;
        }
        aFb1fSDK.AFKeystoreWrapper("CACHED_CHANNEL", null);
        throw null;
    }

    @Override // com.appsflyer.internal.AFe1rSDK
    public final void AFInAppEventParameterName(AFa1tSDK aFa1tSDK) {
        onAppOpenAttributionNative = (init + 83) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        Intrinsics.checkNotNullParameter(aFa1tSDK, "");
        Map<String, Object> mapAFKeystoreWrapper = aFa1tSDK.AFKeystoreWrapper();
        Intrinsics.checkNotNullExpressionValue(mapAFKeystoreWrapper, "");
        mapAFKeystoreWrapper.put("open_referrer", aFa1tSDK.AFInAppEventParameterName);
        String str = aFa1tSDK.afDebugLog;
        if (str != null) {
            init = (onAppOpenAttributionNative + 125) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (!StringsKt.p0(str)) {
                mapAFKeystoreWrapper.put("af_web_referrer", aFa1tSDK.afDebugLog);
            }
        }
        onAppOpenAttributionNative = (init + 21) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    private final String values(String str) {
        String strAFInAppEventParameterName;
        int i3 = onAppOpenAttributionNative + 29;
        init = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            strAFInAppEventParameterName = this.afDebugLog.AFInAppEventParameterName(str);
            int i4 = 95 / 0;
        } else {
            strAFInAppEventParameterName = this.afDebugLog.AFInAppEventParameterName(str);
        }
        int i5 = init + 95;
        onAppOpenAttributionNative = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i5 % 2 != 0) {
            return strAFInAppEventParameterName;
        }
        throw null;
    }

    private static void values(String str, int[] iArr, boolean z2, Object[] objArr) throws UnsupportedEncodingException {
        String str2;
        Object bytes = str;
        if (str != null) {
            bytes = str.getBytes("ISO-8859-1");
        }
        byte[] bArr = (byte[]) bytes;
        synchronized (AFg1oSDK.AFInAppEventParameterName) {
            try {
                int i3 = iArr[0];
                int i4 = iArr[1];
                int i5 = iArr[2];
                int i6 = iArr[3];
                char[] cArr = new char[i4];
                System.arraycopy(AppsFlyer2dXConversionCallback, i3, cArr, 0, i4);
                if (bArr != null) {
                    char[] cArr2 = new char[i4];
                    AFg1oSDK.values = 0;
                    char c3 = 0;
                    while (true) {
                        int i7 = AFg1oSDK.values;
                        if (i7 >= i4) {
                            break;
                        }
                        if (bArr[i7] == 1) {
                            cArr2[i7] = (char) (((cArr[i7] << 1) + 1) - c3);
                        } else {
                            cArr2[i7] = (char) ((cArr[i7] << 1) - c3);
                        }
                        c3 = cArr2[i7];
                        AFg1oSDK.values = i7 + 1;
                    }
                    cArr = cArr2;
                }
                if (i6 > 0) {
                    char[] cArr3 = new char[i4];
                    System.arraycopy(cArr, 0, cArr3, 0, i4);
                    int i8 = i4 - i6;
                    System.arraycopy(cArr3, 0, cArr, i8, i6);
                    System.arraycopy(cArr3, i6, cArr, 0, i8);
                }
                if (z2) {
                    char[] cArr4 = new char[i4];
                    AFg1oSDK.values = 0;
                    while (true) {
                        int i9 = AFg1oSDK.values;
                        if (i9 >= i4) {
                            break;
                        }
                        cArr4[i9] = cArr[(i4 - i9) - 1];
                        AFg1oSDK.values = i9 + 1;
                    }
                    cArr = cArr4;
                }
                if (i5 > 0) {
                    AFg1oSDK.values = 0;
                    while (true) {
                        int i10 = AFg1oSDK.values;
                        if (i10 >= i4) {
                            break;
                        }
                        cArr[i10] = (char) (cArr[i10] - iArr[2]);
                        AFg1oSDK.values = i10 + 1;
                    }
                }
                str2 = new String(cArr);
            } catch (Throwable th) {
                throw th;
            }
        }
        objArr[0] = str2;
    }

    @Override // com.appsflyer.internal.AFe1rSDK
    public final void AFKeystoreWrapper(Map<String, Object> map, boolean z2, Function0<String> function0) {
        init = (onAppOpenAttributionNative + 15) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(function0, "");
        valueOf(map);
        AFInAppEventParameterName(map);
        onInstallConversionFailureNative(map);
        values(map, z2);
        AFInAppEventParameterName(map, function0);
        int i3 = init + 11;
        onAppOpenAttributionNative = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 == 0) {
            throw null;
        }
    }

    private final void AFKeystoreWrapper(AFa1tSDK aFa1tSDK, Map<String, Object> map) {
        init = (onAppOpenAttributionNative + 91) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (aFa1tSDK.AFInAppEventParameterName()) {
            return;
        }
        try {
            map.putAll(this.AFKeystoreWrapper.AFInAppEventParameterName());
            init = (onAppOpenAttributionNative + 79) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } catch (Exception e3) {
            AFLogger.afErrorLogForExcManagerOnly("error while getting sensors data", e3);
            StringBuilder sb = new StringBuilder("Unexpected exception from AFSensorManager: ");
            sb.append(e3.getMessage());
            AFLogger.afRDLog(sb.toString());
        }
    }

    private void AFInAppEventParameterName(Map<String, Object> map, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(function0, "");
        if (AFInAppEventParameterName().getBoolean(AppsFlyerProperties.COLLECT_FACEBOOK_ATTR_ID, true)) {
            init = (onAppOpenAttributionNative + 11) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            String str = null;
            try {
                this.AFInAppEventType.getPackageManager().getApplicationInfo("com.facebook.katana", 0);
                str = (String) function0.invoke();
            } catch (PackageManager.NameNotFoundException e3) {
                AFLogger.afErrorLogForExcManagerOnly("com.facebook.katana not found", e3, true);
                AFLogger.afWarnLog("Exception while collecting facebook's attribution ID. ");
            } catch (Throwable th) {
                AFLogger.afErrorLog("Exception while collecting facebook's attribution ID. ", th);
            }
            if (str != null) {
                init = (onAppOpenAttributionNative + 49) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                map.put("fb", str);
            }
        }
    }

    @Override // com.appsflyer.internal.AFe1rSDK
    public final long AFKeystoreWrapper() {
        onAppOpenAttributionNative = (init + 19) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        long jCurrentTimeMillis = System.currentTimeMillis();
        init = (onAppOpenAttributionNative + 53) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        return jCurrentTimeMillis;
    }

    @Override // com.appsflyer.internal.AFe1rSDK
    public final void AFKeystoreWrapper(Map<String, Object> map) {
        int i3 = init + 81;
        onAppOpenAttributionNative = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        boolean z2 = false;
        if (i3 % 2 == 0) {
            Intrinsics.checkNotNullParameter(map, "");
            int i4 = 22 / 0;
            if (AFInAppEventParameterName().getString("advertiserId") != null) {
                return;
            }
        } else {
            Intrinsics.checkNotNullParameter(map, "");
            if (AFInAppEventParameterName().getString("advertiserId") != null) {
                return;
            }
        }
        AFa1eSDK.AFInAppEventType(this.AFInAppEventType, map);
        if (AFInAppEventParameterName().getString("advertiserId") != null) {
            onAppOpenAttributionNative = (init + 101) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            z2 = true;
        } else {
            onAppOpenAttributionNative = (init + 15) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        map.put("GAID_retry", String.valueOf(z2));
    }

    private static File AFKeystoreWrapper(String str) {
        int i3 = onAppOpenAttributionNative + 47;
        init = i3 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i3 % 2 != 0) {
            try {
                int i4 = 16 / 0;
                if (str == null) {
                    return null;
                }
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getMessage(), th);
                return null;
            }
        } else if (str == null) {
            return null;
        }
        if (StringsKt.t1(str).toString().length() <= 0) {
            onAppOpenAttributionNative = (init + 9) % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            return null;
        }
        int i5 = onAppOpenAttributionNative + 103;
        init = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i5 % 2 != 0) {
            return null;
        }
        return new File(StringsKt.t1(str).toString());
    }

    private static boolean AFKeystoreWrapper(File file) {
        int i3 = onAppOpenAttributionNative;
        int i4 = i3 + 121;
        init = i4 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i4 % 2 != 0) {
            throw null;
        }
        if (file == null) {
            return true;
        }
        int i5 = i3 + 5;
        init = i5 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        int i6 = i5 % 2;
        boolean zExists = file.exists();
        if (i6 != 0) {
            int i7 = 70 / 0;
            if (!zExists) {
                return true;
            }
        } else if (!zExists) {
            return true;
        }
        int i8 = init + 111;
        onAppOpenAttributionNative = i8 % ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i8 % 2 != 0) {
            return false;
        }
        throw null;
    }
}
