package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.components.network.http.exceptions.HttpException;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import com.appsflyer.internal.components.queue.exceptions.CreateHttpCallException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AFd1lSDK<Result> extends AFd1uSDK<AFc1dSDK<Result>> {
    private AFa1cSDK AFLogger;
    private String AFLogger$LogLevel;
    public AFc1dSDK<Result> afDebugLog;
    protected final AFc1oSDK afErrorLog;
    protected final AFb1ySDK afInfoLog;
    public final AFe1pSDK afRDLog;

    private AFd1lSDK(AFd1tSDK aFd1tSDK, AFd1tSDK[] aFd1tSDKArr, AFc1oSDK aFc1oSDK, AFe1pSDK aFe1pSDK, AFb1ySDK aFb1ySDK, AFa1cSDK aFa1cSDK, String str) {
        super(aFd1tSDK, aFd1tSDKArr, str);
        this.afErrorLog = aFc1oSDK;
        this.afRDLog = aFe1pSDK;
        this.afInfoLog = aFb1ySDK;
        this.AFLogger = aFa1cSDK;
    }

    @Override // com.appsflyer.internal.AFd1uSDK
    public final void AFInAppEventParameterName() {
        String str;
        super.AFInAppEventParameterName();
        if (!afRDLog() || (str = this.afRDLog.values) == null || str.trim().isEmpty()) {
            return;
        }
        AFc1qSDK<Result> aFc1qSDKAFInAppEventType = AFInAppEventType(str);
        if (aFc1qSDKAFInAppEventType != null) {
            valueOf(aFc1qSDKAFInAppEventType.AFInAppEventParameterName);
        } else {
            AFLogger.afErrorLogForExcManagerOnly("Failed to create a cached HTTP call", new CreateHttpCallException("createHttpCall returned null"));
        }
    }

    @Override // com.appsflyer.internal.AFd1uSDK
    public long AFInAppEventType() {
        return 60000L;
    }

    protected abstract AFc1qSDK<Result> AFInAppEventType(String str);

    @Override // com.appsflyer.internal.AFd1uSDK
    public AFc1bSDK AFKeystoreWrapper() throws Exception {
        if (afWarnLog() && this.afRDLog.AFKeystoreWrapper()) {
            AppsFlyerRequestListener appsFlyerRequestListenerAFLogger = AFLogger();
            if (appsFlyerRequestListenerAFLogger != null) {
                appsFlyerRequestListenerAFLogger.onError(11, "Skipping event because 'isStopped' is true");
            }
            throw new AFd1oSDK();
        }
        String str = this.afRDLog.values;
        if (str == null || str.trim().isEmpty()) {
            AppsFlyerRequestListener appsFlyerRequestListenerAFLogger2 = AFLogger();
            if (appsFlyerRequestListenerAFLogger2 != null) {
                appsFlyerRequestListenerAFLogger2.onError(41, "No dev key");
            }
            throw new AFd1sSDK();
        }
        AFc1qSDK<Result> aFc1qSDKAFInAppEventType = AFInAppEventType(str);
        if (aFc1qSDKAFInAppEventType == null) {
            AFLogger.afErrorLogForExcManagerOnly("Failed to create a cached HTTP call", new CreateHttpCallException("createHttpCall returned null"));
            return AFc1bSDK.FAILURE;
        }
        if (afRDLog()) {
            valueOf(aFc1qSDKAFInAppEventType.AFInAppEventParameterName);
        }
        AFc1dSDK<Result> aFc1dSDKAFKeystoreWrapper = aFc1qSDKAFInAppEventType.AFKeystoreWrapper();
        this.afDebugLog = aFc1dSDKAFKeystoreWrapper;
        this.afInfoLog.values(aFc1qSDKAFInAppEventType.AFInAppEventParameterName.AFKeystoreWrapper, aFc1dSDKAFKeystoreWrapper.getStatusCode(), aFc1dSDKAFKeystoreWrapper.getBody().toString());
        AppsFlyerRequestListener appsFlyerRequestListenerAFLogger3 = AFLogger();
        if (appsFlyerRequestListenerAFLogger3 != null) {
            if (aFc1dSDKAFKeystoreWrapper.isSuccessful()) {
                appsFlyerRequestListenerAFLogger3.onSuccess();
            } else {
                StringBuilder sb = new StringBuilder("Status code failure ");
                sb.append(aFc1dSDKAFKeystoreWrapper.getStatusCode());
                appsFlyerRequestListenerAFLogger3.onError(50, sb.toString());
            }
        }
        return aFc1dSDKAFKeystoreWrapper.isSuccessful() ? AFc1bSDK.SUCCESS : AFc1bSDK.FAILURE;
    }

    protected abstract AppsFlyerRequestListener AFLogger();

    protected abstract boolean afRDLog();

    protected boolean afWarnLog() {
        return true;
    }

    @Override // com.appsflyer.internal.AFd1uSDK
    public boolean valueOf() {
        if (afInfoLog() instanceof AFd1oSDK) {
            return false;
        }
        if (this.AFKeystoreWrapper == AFc1bSDK.TIMEOUT) {
            return true;
        }
        Throwable thAfInfoLog = afInfoLog();
        return (thAfInfoLog instanceof IOException) && !(thAfInfoLog instanceof ParsingException);
    }

    @Override // com.appsflyer.internal.AFd1uSDK
    public final void values(Throwable th) {
        AFLogger.afErrorLog("Error while sending request to server: ".concat(String.valueOf(th)), th, true, !(th instanceof HttpException));
        AppsFlyerRequestListener appsFlyerRequestListenerAFLogger = AFLogger();
        if (appsFlyerRequestListenerAFLogger != null) {
            String message = th.getMessage();
            if (message == null) {
                message = "";
            }
            appsFlyerRequestListenerAFLogger.onError(40, message);
        }
    }

    public AFd1lSDK(AFd1tSDK aFd1tSDK, AFd1tSDK[] aFd1tSDKArr, AFc1ySDK aFc1ySDK, String str) {
        this(aFd1tSDK, aFd1tSDKArr, aFc1ySDK.valueOf(), aFc1ySDK.getLevel(), aFc1ySDK.afErrorLogForExcManagerOnly(), aFc1ySDK.AppsFlyer2dXConversionCallback(), str);
    }

    private void valueOf(AFb1zSDK aFb1zSDK) {
        String str = this.AFLogger$LogLevel;
        this.AFLogger$LogLevel = this.AFLogger.AFInAppEventType(new AFa1uSDK(aFb1zSDK.AFKeystoreWrapper, aFb1zSDK.AFInAppEventType(), "6.12.3", this.AFInAppEventParameterName));
        if (str != null) {
            this.AFLogger.valueOf(str);
        }
    }

    @Override // com.appsflyer.internal.AFd1uSDK
    public void values() {
        String str;
        if (this.AFKeystoreWrapper == AFc1bSDK.SUCCESS) {
            String str2 = this.AFLogger$LogLevel;
            if (str2 != null) {
                this.AFLogger.valueOf(str2);
                return;
            }
            return;
        }
        if (valueOf() || (str = this.AFLogger$LogLevel) == null) {
            return;
        }
        this.AFLogger.valueOf(str);
    }

    public AFd1lSDK(AFd1tSDK aFd1tSDK, AFd1tSDK[] aFd1tSDKArr, AFc1ySDK aFc1ySDK, String str, String str2) {
        this(aFd1tSDK, aFd1tSDKArr, aFc1ySDK.valueOf(), aFc1ySDK.getLevel(), aFc1ySDK.afErrorLogForExcManagerOnly(), aFc1ySDK.AppsFlyer2dXConversionCallback(), str);
        this.AFLogger$LogLevel = str2;
    }
}
