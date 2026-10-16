package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerConversionListener;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFe1oSDK {
    public final double AFInAppEventType;

    public AFe1oSDK() {
    }

    static void AFKeystoreWrapper(Map<String, Object> map) {
        AppsFlyerConversionListener appsFlyerConversionListener = AFa1bSDK.values().AFKeystoreWrapper;
        if (appsFlyerConversionListener != null) {
            StringBuilder sb = new StringBuilder("[GCD-A02] Calling onConversionDataSuccess with:\n");
            sb.append(map.toString());
            AFLogger.afDebugLog(sb.toString());
            appsFlyerConversionListener.onConversionDataSuccess(map);
        }
    }

    public AFe1oSDK(double d3) {
        this.AFInAppEventType = d3;
    }

    static void AFKeystoreWrapper(String str) {
        AppsFlyerConversionListener appsFlyerConversionListener = AFa1bSDK.values().AFKeystoreWrapper;
        if (appsFlyerConversionListener != null) {
            AFLogger.afDebugLog("[GCD-A02] Calling onConversionFailure with:\n".concat(String.valueOf(str)));
            appsFlyerConversionListener.onConversionDataFail(str);
        }
    }
}
