package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.deeplink.DeepLinkResult;
import com.facebook.internal.AnalyticsEvents;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFe1hSDK {
    public final Map<String, Object> AFInAppEventParameterName;
    public final AFb1fSDK AFInAppEventType;
    public final Map<String, Object> AFKeystoreWrapper;
    public long AFLogger;
    public long AFLogger$LogLevel;
    public long AFVersionDeclaration;
    public long afDebugLog;
    public final long[] afErrorLog;
    public final long[] afInfoLog;
    public final long[] afRDLog;
    public final Map<String, Object> valueOf;
    public long values;

    public AFe1hSDK(AFb1fSDK aFb1fSDK) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.AFInAppEventParameterName = concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        this.valueOf = concurrentHashMap2;
        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
        this.AFKeystoreWrapper = concurrentHashMap3;
        this.values = 0L;
        this.afDebugLog = 0L;
        this.afInfoLog = new long[2];
        this.afRDLog = new long[2];
        this.afErrorLog = new long[2];
        this.AFLogger = 0L;
        this.AFVersionDeclaration = 0L;
        this.AFInAppEventType = aFb1fSDK;
        concurrentHashMap.putAll(valueOf("first_launch"));
        concurrentHashMap2.putAll(valueOf("ddl"));
        concurrentHashMap3.putAll(valueOf("gcd"));
        this.AFLogger$LogLevel = aFb1fSDK.AFInAppEventParameterName("prev_session_dur", 0L);
    }

    private Map<String, Object> valueOf(String str) {
        Map<String, Object> map = Collections.EMPTY_MAP;
        String strAFKeystoreWrapper = this.AFInAppEventType.AFKeystoreWrapper(str, null);
        if (strAFKeystoreWrapper != null) {
            try {
                return AFa1uSDK.valueOf(new JSONObject(strAFKeystoreWrapper));
            } catch (Exception e3) {
                AFLogger.afErrorLog("Error while parsing cached json data", e3, true);
            }
        }
        return map;
    }

    public final void AFInAppEventParameterName(int i3) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.AFLogger = jCurrentTimeMillis;
        if (i3 == 1) {
            long j3 = this.afDebugLog;
            if (j3 == 0) {
                AFLogger.afInfoLog("Metrics: fg ts is missing");
                return;
            }
            this.AFInAppEventParameterName.put("from_fg", Long.valueOf(jCurrentTimeMillis - j3));
            this.AFInAppEventType.values("first_launch", new JSONObject(this.AFInAppEventParameterName).toString());
        }
    }

    public final void AFInAppEventType(int i3) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j3 = this.AFVersionDeclaration;
        if (j3 != 0) {
            this.AFKeystoreWrapper.put("net", Long.valueOf(jCurrentTimeMillis - j3));
        } else {
            AFLogger.afInfoLog("Metrics: gcdStart ts is missing");
        }
        this.AFKeystoreWrapper.put("retries", Integer.valueOf(i3));
        this.AFInAppEventType.values("gcd", new JSONObject(this.AFKeystoreWrapper).toString());
    }

    public final void AFKeystoreWrapper() {
        this.afDebugLog = System.currentTimeMillis();
        if (AFInAppEventType()) {
            long j3 = this.values;
            if (j3 == 0) {
                AFLogger.afInfoLog("Metrics: init ts is missing");
                return;
            }
            this.AFInAppEventParameterName.put("init_to_fg", Long.valueOf(this.afDebugLog - j3));
            this.AFInAppEventType.values("first_launch", new JSONObject(this.AFInAppEventParameterName).toString());
        }
    }

    public final void values(AFe1kSDK aFe1kSDK) {
        if (AFInAppEventType()) {
            this.AFInAppEventParameterName.put("start_with", aFe1kSDK.toString());
            this.AFInAppEventType.values("first_launch", new JSONObject(this.AFInAppEventParameterName).toString());
        }
    }

    public final void AFInAppEventParameterName(DeepLinkResult deepLinkResult, long j3) {
        this.valueOf.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, deepLinkResult.getStatus().toString());
        this.valueOf.put("timeout_value", Long.valueOf(j3));
        this.AFInAppEventType.values("ddl", new JSONObject(this.valueOf).toString());
    }

    public final boolean AFInAppEventType() {
        return this.AFInAppEventType.values("appsFlyerCount", 0) == 0;
    }
}
