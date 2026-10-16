package com.appsflyer.internal;

import android.net.Uri;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFd1xSDK.AnonymousClass4;
import com.facebook.internal.ServerProtocol;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFd1nSDK extends AFd1uSDK<Boolean> {
    private static volatile boolean afErrorLog = false;
    private final AFd1xSDK AFLogger;
    private final AFc1ySDK afDebugLog;
    private Boolean afInfoLog;
    private final AFa1cSDK afRDLog;

    public AFd1nSDK(AFc1ySDK aFc1ySDK) {
        super(AFd1tSDK.LOAD_CACHE, new AFd1tSDK[0], "LoadCachedRequests");
        this.afRDLog = aFc1ySDK.AppsFlyer2dXConversionCallback();
        this.AFLogger = aFc1ySDK.AFLogger$LogLevel();
        this.afDebugLog = aFc1ySDK;
    }

    public static boolean afRDLog() {
        return afErrorLog;
    }

    @Override // com.appsflyer.internal.AFd1uSDK
    public final long AFInAppEventType() {
        return 30000L;
    }

    @Override // com.appsflyer.internal.AFd1uSDK
    public final AFc1bSDK AFKeystoreWrapper() throws Exception {
        for (AFa1uSDK aFa1uSDK : this.afRDLog.AFKeystoreWrapper()) {
            StringBuilder sb = new StringBuilder("CACHE: resending request: ");
            sb.append(aFa1uSDK.values);
            AFLogger.afInfoLog(sb.toString());
            try {
                AFe1aSDK aFe1aSDK = new AFe1aSDK(AFInAppEventType(aFa1uSDK), aFa1uSDK.AFKeystoreWrapper(), aFa1uSDK.AFKeystoreWrapper, aFa1uSDK.valueOf);
                AFd1xSDK aFd1xSDK = this.AFLogger;
                aFd1xSDK.valueOf.execute(aFd1xSDK.new AnonymousClass4(new AFd1eSDK(aFe1aSDK, this.afDebugLog)));
            } catch (Exception e3) {
                AFLogger.afErrorLog("QUEUE: Failed to resend cached request", e3);
            }
        }
        this.afInfoLog = Boolean.TRUE;
        afErrorLog = true;
        return AFc1bSDK.SUCCESS;
    }

    @Override // com.appsflyer.internal.AFd1uSDK
    public final boolean valueOf() {
        return false;
    }

    private static String AFInAppEventType(AFa1uSDK aFa1uSDK) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j3 = Long.parseLong(aFa1uSDK.AFKeystoreWrapper, 10);
        String str = aFa1uSDK.values;
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("isCachedRequest", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE).appendQueryParameter("timeincache", String.valueOf((jCurrentTimeMillis - j3) / 1000)).toString();
        } catch (Exception e3) {
            AFLogger.afErrorLogForExcManagerOnly("Couldn't parse the uri", e3);
            return str;
        }
    }
}
