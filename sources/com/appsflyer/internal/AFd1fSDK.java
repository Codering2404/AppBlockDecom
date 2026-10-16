package com.appsflyer.internal;

import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.facebook.GraphRequest;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AFd1fSDK extends AFd1lSDK<String> {
    private static final AFd1tSDK[] AppsFlyer2dXConversionCallback = {AFd1tSDK.DLSDK, AFd1tSDK.ONELINK, AFd1tSDK.MONITORSDK, AFd1tSDK.REGISTER};
    public final AFa1tSDK AFLogger;
    private final AFc1zSDK AFLogger$LogLevel;
    protected final AFb1fSDK AFVersionDeclaration;
    private final AFb1gSDK afErrorLogForExcManagerOnly;
    private final AFd1ySDK afWarnLog;
    private final AFb1wSDK getLevel;

    public AFd1fSDK(AFa1tSDK aFa1tSDK, AFc1ySDK aFc1ySDK) {
        this(aFa1tSDK, aFc1ySDK, null);
    }

    private static Map<String, Object> AFKeystoreWrapper(AFa1tSDK aFa1tSDK) {
        Map<String, Object> map = (Map) aFa1tSDK.AFKeystoreWrapper().get("meta");
        if (map != null) {
            return map;
        }
        HashMap map2 = new HashMap();
        aFa1tSDK.AFKeystoreWrapper().put("meta", map2);
        return map2;
    }

    protected void AFInAppEventParameterName(AFa1tSDK aFa1tSDK) throws JSONException {
        if (aFa1tSDK.afErrorLog()) {
            aFa1tSDK.valueOf(new AFb1dSDK(aFa1tSDK.AFKeystoreWrapper(), ((AFd1lSDK) this).afRDLog.valueOf.values));
            aFa1tSDK.valueOf(((AFd1lSDK) this).afRDLog.AFInAppEventType(aFa1tSDK.AFKeystoreWrapper()));
        }
        if (aFa1tSDK.AFLogger()) {
            aFa1tSDK.valueOf(((AFd1lSDK) this).afRDLog.AFInAppEventType());
        }
        Set<AFd1tSDK> set = this.valueOf;
        boolean z2 = set.contains(AFd1tSDK.LAUNCH) || set.contains(AFd1tSDK.CONVERSION);
        if (afErrorLog() && z2) {
            aFa1tSDK.values(this.AFVersionDeclaration.values("appsFlyerCount", 0));
        }
        if (aFa1tSDK.afRDLog()) {
            Map<String, Object> mapAFKeystoreWrapper = AFKeystoreWrapper(aFa1tSDK);
            AFd1ySDK aFd1ySDK = this.afWarnLog;
            AFc1aSDK aFc1aSDK = new AFc1aSDK(aFd1ySDK.valueOf(), aFd1ySDK.AFInAppEventType(), AFd1ySDK.AFKeystoreWrapper() ? AFd1zSDK.DEFAULT : AFd1zSDK.API);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", aFc1aSDK.AFInAppEventParameterName);
            AFd1zSDK aFd1zSDK = aFc1aSDK.AFInAppEventType;
            if (aFd1zSDK != AFd1zSDK.DEFAULT) {
                jSONObject.put(GraphRequest.BATCH_METHOD_PARAM, aFd1zSDK.valueOf);
            }
            String str = aFc1aSDK.valueOf;
            if (str != null && !StringsKt.p0(str)) {
                jSONObject.put("prefix", aFc1aSDK.valueOf);
            }
            mapAFKeystoreWrapper.put(DiagnosticsTracker.HOST_KEY, jSONObject);
        }
        if (this.afErrorLogForExcManagerOnly.AFInAppEventType("AF_PREINSTALL_DISABLED")) {
            AFKeystoreWrapper(aFa1tSDK).put("preinstall_disabled", Boolean.TRUE);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f6  */
    @Override // com.appsflyer.internal.AFd1lSDK
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final com.appsflyer.internal.AFc1qSDK<java.lang.String> AFInAppEventType(java.lang.String r17) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1fSDK.AFInAppEventType(java.lang.String):com.appsflyer.internal.AFc1qSDK");
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    protected final AppsFlyerRequestListener AFLogger() {
        return this.AFLogger.AFKeystoreWrapper;
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    protected boolean afRDLog() {
        return true;
    }

    public AFd1fSDK(AFa1tSDK aFa1tSDK, AFc1ySDK aFc1ySDK, String str) {
        super(aFa1tSDK.valueOf(), new AFd1tSDK[]{AFd1tSDK.RC_CDN}, aFc1ySDK, str);
        this.AFLogger = aFa1tSDK;
        this.afWarnLog = aFc1ySDK.onAppOpenAttributionNative();
        this.AFVersionDeclaration = aFc1ySDK.AFKeystoreWrapper();
        this.getLevel = aFc1ySDK.afInfoLog();
        this.AFLogger$LogLevel = aFc1ySDK.afWarnLog();
        this.afErrorLogForExcManagerOnly = aFc1ySDK.AFInAppEventParameterName();
        for (AFd1tSDK aFd1tSDK : AppsFlyer2dXConversionCallback) {
            if (this.AFInAppEventParameterName == aFd1tSDK) {
                return;
            }
        }
        int i3 = this.AFLogger.afInfoLog;
        AFd1tSDK aFd1tSDK2 = this.AFInAppEventParameterName;
        if (i3 > 0) {
            this.values.add(AFd1tSDK.CONVERSION);
        } else {
            AFd1tSDK aFd1tSDK3 = AFd1tSDK.CONVERSION;
            if (aFd1tSDK2 != aFd1tSDK3) {
                this.valueOf.add(aFd1tSDK3);
            }
        }
    }
}
