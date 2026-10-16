package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFf1jSDK;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFd1hSDK extends AFd1fSDK {
    private final AFf1iSDK AFLogger$LogLevel;
    private final AFe1hSDK afErrorLogForExcManagerOnly;
    public Map<String, Object> afWarnLog;
    private final AFb1fSDK getLevel;
    private final AFb1wSDK onInstallConversionDataLoadedNative;
    private final AppsFlyerProperties onInstallConversionFailureNative;

    /* JADX INFO: renamed from: com.appsflyer.internal.AFd1hSDK$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] AFKeystoreWrapper;

        static {
            int[] iArr = new int[AFf1jSDK.AFa1vSDK.values().length];
            AFKeystoreWrapper = iArr;
            try {
                iArr[AFf1jSDK.AFa1vSDK.FINISHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                AFKeystoreWrapper[AFf1jSDK.AFa1vSDK.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public AFd1hSDK(AFa1tSDK aFa1tSDK, AFc1ySDK aFc1ySDK) {
        super(aFa1tSDK, aFc1ySDK);
        this.AFLogger$LogLevel = aFc1ySDK.AFVersionDeclaration();
        this.getLevel = aFc1ySDK.AFKeystoreWrapper();
        this.afErrorLogForExcManagerOnly = aFc1ySDK.afErrorLog();
        this.onInstallConversionDataLoadedNative = aFc1ySDK.afInfoLog();
        this.onInstallConversionFailureNative = AppsFlyerProperties.getInstance();
        this.values.add(AFd1tSDK.RESOLVE_ESP);
        this.values.add(AFd1tSDK.DLSDK);
    }

    @Override // com.appsflyer.internal.AFd1fSDK
    protected final void AFInAppEventParameterName(AFa1tSDK aFa1tSDK) throws JSONException {
        super.AFInAppEventParameterName(aFa1tSDK);
        int i3 = aFa1tSDK.afInfoLog;
        this.afErrorLogForExcManagerOnly.AFInAppEventParameterName(i3);
        Map map = (Map) aFa1tSDK.AFKeystoreWrapper().get("meta");
        if (map == null) {
            map = new HashMap();
            aFa1tSDK.AFKeystoreWrapper().put("meta", map);
        }
        AFf1ySDK aFf1ySDKAFInAppEventType = this.onInstallConversionDataLoadedNative.AFInAppEventType();
        if (aFf1ySDKAFInAppEventType != null) {
            HashMap map2 = new HashMap();
            map2.put("cdn_token", aFf1ySDKAFInAppEventType.AFInAppEventType);
            String str = aFf1ySDKAFInAppEventType.valueOf;
            if (str != null) {
                map2.put("c_ver", str);
            }
            long j3 = aFf1ySDKAFInAppEventType.values;
            if (j3 > 0) {
                map2.put("latency", Long.valueOf(j3));
            }
            long j4 = aFf1ySDKAFInAppEventType.AFInAppEventParameterName;
            if (j4 > 0) {
                map2.put("delay", Long.valueOf(j4));
            }
            int i4 = aFf1ySDKAFInAppEventType.AFKeystoreWrapper;
            if (i4 > 0) {
                map2.put("res_code", Integer.valueOf(i4));
            }
            if (aFf1ySDKAFInAppEventType.afRDLog != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(aFf1ySDKAFInAppEventType.afRDLog.getClass().getSimpleName());
                sb.append(": ");
                sb.append(aFf1ySDKAFInAppEventType.afRDLog.getMessage());
                map2.put("error", sb.toString());
            }
            AFf1qSDK aFf1qSDK = aFf1ySDKAFInAppEventType.AFLogger;
            if (aFf1qSDK != null) {
                map2.put("sig", aFf1qSDK.toString());
            }
            String str2 = aFf1ySDKAFInAppEventType.afDebugLog;
            if (str2 != null) {
                map2.put("cdn_cache_status", str2);
            }
            map.put("rc", map2);
        }
        if (i3 == 1) {
            if (this.onInstallConversionFailureNative.getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
                aFa1tSDK.AFKeystoreWrapper().put("wait_cid", Boolean.toString(true));
            }
            HashMap map3 = new HashMap(this.afErrorLogForExcManagerOnly.valueOf);
            this.afErrorLogForExcManagerOnly.AFInAppEventType.AFInAppEventParameterName("ddl");
            if (!map3.isEmpty()) {
                map.put("ddl", map3);
            }
            HashMap map4 = new HashMap(this.afErrorLogForExcManagerOnly.AFInAppEventParameterName);
            if (!map4.isEmpty()) {
                map.put("first_launch", map4);
            }
        } else if (i3 == 2) {
            HashMap map5 = new HashMap(this.afErrorLogForExcManagerOnly.AFInAppEventParameterName);
            if (!map5.isEmpty()) {
                map.put("first_launch", map5);
            }
            this.afErrorLogForExcManagerOnly.AFInAppEventType.AFInAppEventParameterName("first_launch");
        }
        if (map.isEmpty()) {
            aFa1tSDK.AFKeystoreWrapper().remove("meta");
        }
        if (i3 <= 2) {
            ArrayList arrayList = new ArrayList();
            for (AFf1jSDK aFf1jSDK : this.AFLogger$LogLevel.AFKeystoreWrapper()) {
                boolean z2 = aFf1jSDK instanceof AFf1lSDK;
                int i5 = AnonymousClass2.AFKeystoreWrapper[aFf1jSDK.afDebugLog.ordinal()];
                if (i5 == 1) {
                    if (z2) {
                        aFa1tSDK.AFInAppEventType("rfr", ((AFf1lSDK) aFf1jSDK).AFInAppEventType);
                        this.getLevel.valueOf(AppsFlyerProperties.NEW_REFERRER_SENT, true);
                    }
                    arrayList.add(aFf1jSDK.valueOf);
                } else if (i5 == 2 && i3 == 2 && !z2) {
                    HashMap map6 = new HashMap();
                    map6.put("source", aFf1jSDK.values);
                    map6.put("response", "TIMEOUT");
                    map6.put("type", aFf1jSDK.afInfoLog);
                    arrayList.add(map6);
                }
            }
            if (!arrayList.isEmpty()) {
                aFa1tSDK.AFInAppEventType("referrers", arrayList);
            }
            Object obj = this.afWarnLog;
            if (obj != null) {
                aFa1tSDK.AFInAppEventType("fb_ddl", obj);
            }
        }
    }

    @Override // com.appsflyer.internal.AFd1lSDK, com.appsflyer.internal.AFd1uSDK
    public final void values() {
        super.values();
        AFe1hSDK aFe1hSDK = this.afErrorLogForExcManagerOnly;
        int i3 = ((AFd1fSDK) this).AFLogger.afInfoLog;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (i3 == 1) {
            long j3 = aFe1hSDK.AFLogger;
            if (j3 == 0) {
                AFLogger.afInfoLog("Metrics: launch start ts is missing");
                return;
            }
            aFe1hSDK.AFInAppEventParameterName.put("net", Long.valueOf(jCurrentTimeMillis - j3));
            aFe1hSDK.AFInAppEventType.values("first_launch", new JSONObject(aFe1hSDK.AFInAppEventParameterName).toString());
        }
    }
}
