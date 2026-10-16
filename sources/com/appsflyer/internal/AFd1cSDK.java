package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.internal.components.network.http.exceptions.HttpException;
import java.io.InterruptedIOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFd1cSDK extends AFd1uSDK<AFd1dSDK> {
    private final AFe1xSDK AFLogger;
    private final String AFLogger$LogLevel;
    private final AFb1uSDK AFVersionDeclaration;
    public AFf1ySDK afDebugLog;
    public AFd1dSDK afErrorLog;
    private final AFc1oSDK afErrorLogForExcManagerOnly;
    private final AFb1gSDK afInfoLog;
    public final AFe1zSDK afRDLog;
    private final AFe1pSDK afWarnLog;
    private final AFe1uSDK getLevel;

    public AFd1cSDK(AFe1xSDK aFe1xSDK, AFb1gSDK aFb1gSDK, AFe1pSDK aFe1pSDK, AFb1uSDK aFb1uSDK, AFc1oSDK aFc1oSDK, AFe1uSDK aFe1uSDK, String str, AFe1zSDK aFe1zSDK) {
        super(AFd1tSDK.RC_CDN, new AFd1tSDK[0], "UpdateRemoteConfiguration");
        this.afErrorLog = null;
        this.AFLogger = aFe1xSDK;
        this.afInfoLog = aFb1gSDK;
        this.afWarnLog = aFe1pSDK;
        this.AFVersionDeclaration = aFb1uSDK;
        this.afErrorLogForExcManagerOnly = aFc1oSDK;
        this.getLevel = aFe1uSDK;
        this.AFLogger$LogLevel = str;
        this.afRDLog = aFe1zSDK;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.appsflyer.internal.AFd1dSDK afRDLog() throws java.lang.InterruptedException, java.io.InterruptedIOException {
        /*
            Method dump skipped, instruction units count: 456
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1cSDK.afRDLog():com.appsflyer.internal.AFd1dSDK");
    }

    @Override // com.appsflyer.internal.AFd1uSDK
    public final long AFInAppEventType() {
        return 1500L;
    }

    @Override // com.appsflyer.internal.AFd1uSDK
    public final AFc1bSDK AFKeystoreWrapper() throws Exception {
        try {
            AFd1dSDK aFd1dSDKAfRDLog = afRDLog();
            this.afErrorLog = aFd1dSDKAfRDLog;
            return aFd1dSDKAfRDLog == AFd1dSDK.FAILURE ? AFc1bSDK.FAILURE : AFc1bSDK.SUCCESS;
        } catch (InterruptedIOException | InterruptedException e3) {
            AFLogger.afErrorLogForExcManagerOnly("RC update config failed", e3);
            this.afErrorLog = AFd1dSDK.FAILURE;
            return AFc1bSDK.TIMEOUT;
        }
    }

    @Override // com.appsflyer.internal.AFd1uSDK
    public final boolean valueOf() {
        return false;
    }

    private void AFKeystoreWrapper(String str, long j3, AFf1qSDK aFf1qSDK, String str2, AFc1dSDK<AFe1mSDK> aFc1dSDK) {
        AFKeystoreWrapper(str, j3, aFc1dSDK, aFc1dSDK != null ? aFc1dSDK.getBody() : null, aFf1qSDK, str2 != null ? str2 : null, null);
    }

    private void AFKeystoreWrapper(String str, long j3, AFc1dSDK<?> aFc1dSDK, AFe1mSDK aFe1mSDK, AFf1qSDK aFf1qSDK, String str2, Throwable th) {
        long j4;
        int statusCode;
        Throwable th2;
        if (aFc1dSDK != null) {
            j4 = aFc1dSDK.AFInAppEventType.values;
            statusCode = aFc1dSDK.getStatusCode();
        } else {
            j4 = 0;
            statusCode = 0;
        }
        int i3 = statusCode;
        if (th instanceof HttpException) {
            Throwable cause = th.getCause();
            j4 = ((HttpException) th).getMetrics().values;
            th2 = cause;
        } else {
            th2 = th;
        }
        this.afDebugLog = new AFf1ySDK(aFe1mSDK != null ? aFe1mSDK.AFInAppEventType : null, str, j4, System.currentTimeMillis() - j3, i3, aFf1qSDK, str2, th2);
    }
}
