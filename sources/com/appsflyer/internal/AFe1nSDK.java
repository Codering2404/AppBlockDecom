package com.appsflyer.internal;

import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import com.facebook.FacebookRequestError;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFe1nSDK extends AFd1lSDK<Map<String, Object>> {
    private static final List<String> AFLogger = Arrays.asList("googleplay", "playstore", "googleplaystore");
    private Map<String, Object> AFLogger$LogLevel;
    private final AFe1hSDK AFVersionDeclaration;
    private final AFb1fSDK afErrorLogForExcManagerOnly;
    private final AFc1oSDK afWarnLog;
    private final AFb1gSDK getLevel;
    private String onAppOpenAttributionNative;

    public AFe1nSDK(AFc1ySDK aFc1ySDK) {
        super(AFd1tSDK.GCDSDK, new AFd1tSDK[]{AFd1tSDK.RC_CDN}, aFc1ySDK, "GCD-FETCH");
        this.afWarnLog = aFc1ySDK.valueOf();
        this.afErrorLogForExcManagerOnly = aFc1ySDK.AFKeystoreWrapper();
        this.AFVersionDeclaration = aFc1ySDK.afErrorLog();
        this.getLevel = aFc1ySDK.AFInAppEventParameterName();
        this.values.add(AFd1tSDK.CONVERSION);
        this.values.add(AFd1tSDK.LAUNCH);
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    public final AFc1qSDK<Map<String, Object>> AFInAppEventType(String str) {
        String strConcat;
        String strValues = AFa1bSDK.values(this.afErrorLogForExcManagerOnly, this.getLevel.AFKeystoreWrapper());
        if (strValues == null || strValues.trim().isEmpty()) {
            strConcat = "";
        } else if (AFLogger.contains(strValues.toLowerCase(Locale.getDefault()))) {
            AFLogger.afWarnLog(String.format("[GCD] AF detected using redundant Google-Play channel for attribution - %s. Using without channel postfix.", strValues));
            strConcat = "";
        } else {
            strConcat = "-".concat(strValues);
        }
        AFc1qSDK<Map<String, Object>> aFc1qSDKAFKeystoreWrapper = this.afWarnLog.AFKeystoreWrapper(strConcat, str);
        StringBuilder sb = new StringBuilder("[GCD-B01] URL: ");
        sb.append(aFc1qSDKAFKeystoreWrapper.AFInAppEventParameterName.AFKeystoreWrapper);
        AFc1sSDK.values(sb.toString());
        return aFc1qSDKAFKeystoreWrapper;
    }

    @Override // com.appsflyer.internal.AFd1lSDK, com.appsflyer.internal.AFd1uSDK
    public final AFc1bSDK AFKeystoreWrapper() throws Exception {
        AFc1bSDK aFc1bSDKAFKeystoreWrapper;
        AFc1bSDK aFc1bSDK;
        if (((AFd1lSDK) this).afRDLog.AFKeystoreWrapper()) {
            AFLogger.afDebugLog("[GCD-E03] 'isStopTracking' enabled");
            this.onAppOpenAttributionNative = "'isStopTracking' enabled";
            throw new AFd1oSDK();
        }
        AFc1bSDK aFc1bSDK2 = AFc1bSDK.FAILURE;
        int i3 = 0;
        while (i3 <= 2) {
            boolean z2 = true;
            boolean z3 = i3 >= 2;
            this.AFVersionDeclaration.AFVersionDeclaration = System.currentTimeMillis();
            try {
                try {
                    aFc1bSDKAFKeystoreWrapper = super.AFKeystoreWrapper();
                    ResponseNetwork responseNetwork = ((AFd1lSDK) this).afDebugLog;
                    if (responseNetwork != null) {
                        int statusCode = responseNetwork.getStatusCode();
                        if (statusCode != 403 && statusCode < 500) {
                            z2 = false;
                        }
                        if (responseNetwork.isSuccessful() || statusCode == 404) {
                            Map<String, Object> map = (Map) responseNetwork.getBody();
                            int statusCode2 = responseNetwork.getStatusCode();
                            Boolean bool = (Boolean) map.get("iscache");
                            if (statusCode2 == 404) {
                                map.remove(FacebookRequestError.ERROR_REASON_KEY);
                                map.remove("status_code");
                                map.put("af_status", "Organic");
                                map.put("af_message", "organic install");
                            }
                            if (bool != null && !bool.booleanValue()) {
                                this.afErrorLogForExcManagerOnly.AFInAppEventType("appsflyerConversionDataCacheExpiration", System.currentTimeMillis());
                            }
                            if (map.containsKey("af_siteid")) {
                                if (map.containsKey(AFInAppEventParameterName.AF_CHANNEL)) {
                                    StringBuilder sb = new StringBuilder("[Invite] Detected App-Invite via channel: ");
                                    sb.append(map.get(AFInAppEventParameterName.AF_CHANNEL));
                                    AFLogger.afDebugLog(sb.toString());
                                } else {
                                    AFLogger.afDebugLog(String.format("[CrossPromotion] App was installed via %s's Cross Promotion", map.get("af_siteid")));
                                }
                            }
                            map.put("is_first_launch", Boolean.FALSE);
                            this.afErrorLogForExcManagerOnly.values("attributionId", new JSONObject(map).toString());
                            if (!this.afErrorLogForExcManagerOnly.AFInAppEventType("sixtyDayConversionData")) {
                                map.put("is_first_launch", Boolean.TRUE);
                            }
                            this.AFLogger$LogLevel = map;
                            aFc1bSDK = AFc1bSDK.SUCCESS;
                        } else {
                            if (!z3) {
                                if (!z2) {
                                }
                            }
                            this.onAppOpenAttributionNative = "Error connection to server: ".concat(String.valueOf(statusCode));
                            aFc1bSDK = AFc1bSDK.FAILURE;
                        }
                        return aFc1bSDK;
                    }
                } catch (AFd1sSDK e3) {
                    AFLogger.afDebugLog("[GCD-E05] AppsFlyer dev key is missing");
                    this.onAppOpenAttributionNative = "AppsFlyer dev key is missing";
                    throw e3;
                } catch (Exception e4) {
                    StringBuilder sb2 = new StringBuilder("[GCD] Error: ");
                    sb2.append(e4.getMessage());
                    AFLogger.afErrorLog(sb2.toString(), e4);
                    aFc1bSDKAFKeystoreWrapper = AFc1bSDK.FAILURE;
                    if (z3) {
                        this.onAppOpenAttributionNative = e4.getMessage();
                        throw e4;
                    }
                }
                aFc1bSDK2 = aFc1bSDKAFKeystoreWrapper;
                i3++;
            } finally {
                this.AFVersionDeclaration.AFInAppEventType(i3);
                AFLogger.afDebugLog("[GCD-A03] Server retrieving attempt finished");
            }
        }
        return aFc1bSDK2;
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    public final AppsFlyerRequestListener AFLogger() {
        return null;
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    public final boolean afRDLog() {
        return false;
    }

    @Override // com.appsflyer.internal.AFd1lSDK, com.appsflyer.internal.AFd1uSDK
    public final boolean valueOf() {
        return false;
    }

    @Override // com.appsflyer.internal.AFd1lSDK, com.appsflyer.internal.AFd1uSDK
    public final void values() {
        super.values();
        Map<String, Object> map = this.AFLogger$LogLevel;
        String str = this.onAppOpenAttributionNative;
        if (map != null) {
            AFe1oSDK.AFKeystoreWrapper(map);
        } else if (str == null || str.isEmpty()) {
            AFe1oSDK.AFKeystoreWrapper("Unknown error");
        } else {
            AFe1oSDK.AFKeystoreWrapper(str);
        }
    }
}
