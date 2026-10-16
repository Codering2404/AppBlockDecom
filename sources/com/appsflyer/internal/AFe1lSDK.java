package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.util.Map;
import kotlinx.serialization.json.internal.OBeo.vgWWUoTKYyuC;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFe1lSDK extends AFd1uSDK<Void> {
    private final AFb1fSDK AFLogger;
    private final Throwable afDebugLog;
    private final AFc1dSDK<String> afInfoLog;

    private Map<String, Object> AFLogger() {
        String strAFKeystoreWrapper = this.AFLogger.AFKeystoreWrapper("attributionId", null);
        if (strAFKeystoreWrapper == null) {
            return null;
        }
        try {
            new AFc1mSDK();
            return AFc1mSDK.AFKeystoreWrapper(strAFKeystoreWrapper);
        } catch (JSONException e3) {
            StringBuilder sb = new StringBuilder("[GCD] Failed to parse GCD response: ");
            sb.append(e3.getMessage());
            AFLogger.afErrorLog(sb.toString(), e3);
            return null;
        }
    }

    @Override // com.appsflyer.internal.AFd1uSDK
    public final long AFInAppEventType() {
        return 1000L;
    }

    @Override // com.appsflyer.internal.AFd1uSDK
    public final AFc1bSDK AFKeystoreWrapper() throws Exception {
        AFLogger.afDebugLog("[GCD-A01] Loading conversion data. Counter: ".concat(String.valueOf(this.AFLogger.values("appsFlyerCount", 0))));
        long jAFInAppEventParameterName = this.AFLogger.AFInAppEventParameterName("appsflyerConversionDataCacheExpiration", 0L);
        if (jAFInAppEventParameterName != 0 && System.currentTimeMillis() - jAFInAppEventParameterName > 5184000000L) {
            AFLogger.afDebugLog("[GCD-E02] Cached conversion data expired");
            this.AFLogger.valueOf("sixtyDayConversionData", true);
            this.AFLogger.values("attributionId", (String) null);
            this.AFLogger.AFInAppEventType("appsflyerConversionDataCacheExpiration", 0L);
        }
        Map<String, Object> mapAFLogger = AFLogger();
        if (mapAFLogger != null) {
            try {
                if (!mapAFLogger.containsKey("is_first_launch")) {
                    mapAFLogger.put("is_first_launch", Boolean.FALSE);
                }
                AFe1oSDK.AFKeystoreWrapper(mapAFLogger);
            } catch (Exception e3) {
                StringBuilder sb = new StringBuilder("[GCD] Error executing conversion data callback: ");
                sb.append(e3.getLocalizedMessage());
                AFLogger.afErrorLog(sb.toString(), e3);
            }
            return AFc1bSDK.SUCCESS;
        }
        try {
        } catch (Exception e4) {
            StringBuilder sb2 = new StringBuilder("[GCD] Error executing conversion data callback: ");
            sb2.append(e4.getLocalizedMessage());
            AFLogger.afErrorLog(sb2.toString(), e4);
        }
        if (this.afDebugLog != null) {
            StringBuilder sb3 = new StringBuilder("Launch exception: ");
            sb3.append(this.afDebugLog.getMessage());
            AFe1oSDK.AFKeystoreWrapper(sb3.toString());
            return AFc1bSDK.SUCCESS;
        }
        AFc1dSDK<String> aFc1dSDK = this.afInfoLog;
        if (aFc1dSDK != null && !aFc1dSDK.isSuccessful()) {
            StringBuilder sb4 = new StringBuilder("Launch status code: ");
            sb4.append(this.afInfoLog.getStatusCode());
            AFe1oSDK.AFKeystoreWrapper(sb4.toString());
            return AFc1bSDK.SUCCESS;
        }
        return AFc1bSDK.FAILURE;
    }

    @Override // com.appsflyer.internal.AFd1uSDK
    public final boolean valueOf() {
        return false;
    }

    public AFe1lSDK(AFd1hSDK aFd1hSDK, AFb1fSDK aFb1fSDK) {
        super(AFd1tSDK.GCDSDK, new AFd1tSDK[]{AFd1tSDK.RC_CDN}, vgWWUoTKYyuC.aTDMUmE);
        this.afDebugLog = aFd1hSDK.afInfoLog();
        this.afInfoLog = ((AFd1lSDK) aFd1hSDK).afDebugLog;
        this.AFLogger = aFb1fSDK;
    }
}
