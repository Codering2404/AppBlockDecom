package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFd1xSDK.AnonymousClass4;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFb1wSDK implements AFd1vSDK {
    private final AFe1pSDK AFInAppEventParameterName;
    private final Object AFInAppEventType;
    private final AFe1xSDK AFKeystoreWrapper;
    private final AFe1uSDK AFLogger;
    private AFd1dSDK afDebugLog;
    private final AFd1xSDK afErrorLog;
    private final AFc1oSDK afInfoLog;
    private AFf1ySDK afRDLog;
    public final AFb1uSDK valueOf;
    private final AFb1gSDK values;

    public AFb1wSDK() {
    }

    private void AFInAppEventParameterName(AFd1dSDK aFd1dSDK, AFe1zSDK aFe1zSDK) {
        synchronized (this.AFInAppEventType) {
            this.afDebugLog = aFd1dSDK;
        }
        if (aFe1zSDK != null) {
            aFe1zSDK.onRemoteConfigUpdateFinished(aFd1dSDK);
        }
    }

    @Override // com.appsflyer.internal.AFd1vSDK
    public final void AFInAppEventType(AFd1uSDK<?> aFd1uSDK) {
    }

    @Override // com.appsflyer.internal.AFd1vSDK
    public final void AFKeystoreWrapper(AFd1uSDK<?> aFd1uSDK, AFc1bSDK aFc1bSDK) {
        if (aFd1uSDK instanceof AFd1cSDK) {
            AFd1cSDK aFd1cSDK = (AFd1cSDK) aFd1uSDK;
            AFd1dSDK aFd1dSDK = aFd1cSDK.afErrorLog;
            if (aFd1dSDK == null) {
                AFLogger.afWarnLog("CFG: update RC returned null result, something went wrong!");
                aFd1dSDK = AFd1dSDK.FAILURE;
            }
            if (aFd1dSDK != AFd1dSDK.USE_CACHED) {
                AFf1ySDK aFf1ySDK = aFd1cSDK.afDebugLog;
                synchronized (this.AFInAppEventType) {
                    this.afRDLog = aFf1ySDK;
                }
            }
            AFInAppEventParameterName(aFd1dSDK, aFd1cSDK.afRDLog);
        }
    }

    public final void valueOf(AFe1zSDK aFe1zSDK) {
        AFd1cSDK aFd1cSDK = new AFd1cSDK(this.AFKeystoreWrapper, this.values, this.AFInAppEventParameterName, this.valueOf, this.afInfoLog, this.AFLogger, "v1", aFe1zSDK);
        AFd1xSDK aFd1xSDK = this.afErrorLog;
        aFd1xSDK.valueOf.execute(aFd1xSDK.new AnonymousClass4(aFd1cSDK));
    }

    public AFb1wSDK(AFe1xSDK aFe1xSDK, AFb1gSDK aFb1gSDK, AFe1pSDK aFe1pSDK, AFb1uSDK aFb1uSDK, AFc1oSDK aFc1oSDK, AFe1uSDK aFe1uSDK, AFd1xSDK aFd1xSDK) {
        this.AFInAppEventType = new Object();
        this.AFKeystoreWrapper = aFe1xSDK;
        this.values = aFb1gSDK;
        this.AFInAppEventParameterName = aFe1pSDK;
        this.valueOf = aFb1uSDK;
        this.afInfoLog = aFc1oSDK;
        this.AFLogger = aFe1uSDK;
        this.afErrorLog = aFd1xSDK;
        aFd1xSDK.AFKeystoreWrapper.add(this);
    }

    public final AFf1ySDK AFInAppEventType() {
        AFf1ySDK aFf1ySDK;
        synchronized (this.AFInAppEventType) {
            aFf1ySDK = this.afRDLog;
            this.afRDLog = null;
        }
        return aFf1ySDK;
    }

    @Override // com.appsflyer.internal.AFd1vSDK
    public final void valueOf(AFd1uSDK<?> aFd1uSDK) {
        if (aFd1uSDK instanceof AFd1cSDK) {
            AFd1cSDK aFd1cSDK = (AFd1cSDK) aFd1uSDK;
            synchronized (this.AFInAppEventType) {
                this.afRDLog = null;
            }
            AFInAppEventParameterName(AFd1dSDK.FAILURE, aFd1cSDK.afRDLog);
        }
    }
}
