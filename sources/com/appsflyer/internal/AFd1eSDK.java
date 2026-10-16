package com.appsflyer.internal;

import android.util.Base64;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFd1eSDK extends AFd1lSDK<String> {
    private final AFe1aSDK AFLogger;

    public AFd1eSDK(AFe1aSDK aFe1aSDK, AFc1ySDK aFc1ySDK) {
        AFd1tSDK aFd1tSDK = aFe1aSDK.AFLogger$LogLevel;
        AFd1tSDK aFd1tSDK2 = aFd1tSDK == null ? AFd1tSDK.CACHED_EVENT : aFd1tSDK;
        AFd1tSDK[] aFd1tSDKArr = {AFd1tSDK.RC_CDN};
        StringBuilder sb = new StringBuilder();
        sb.append(aFe1aSDK.valueOf);
        sb.append("-");
        sb.append(valueOf(aFe1aSDK));
        super(aFd1tSDK2, aFd1tSDKArr, aFc1ySDK, sb.toString(), aFe1aSDK.valueOf);
        this.AFLogger = aFe1aSDK;
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    protected final AFc1qSDK<String> AFInAppEventType(String str) {
        String strEncodeToString = Base64.encodeToString(this.AFLogger.values(), 2);
        AFLogger.afInfoLog("cached data: ".concat(String.valueOf(strEncodeToString)));
        ((AFd1lSDK) this).afInfoLog.values(this.AFLogger.AFLogger, strEncodeToString);
        return ((AFd1lSDK) this).afErrorLog.AFInAppEventType(this.AFLogger);
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    protected final AppsFlyerRequestListener AFLogger() {
        return this.AFLogger.AFKeystoreWrapper;
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    protected final boolean afRDLog() {
        return false;
    }

    @Override // com.appsflyer.internal.AFd1lSDK, com.appsflyer.internal.AFd1uSDK
    public final boolean valueOf() {
        ResponseNetwork responseNetwork;
        AFd1tSDK aFd1tSDK = this.AFLogger.AFLogger$LogLevel;
        if (aFd1tSDK == null) {
            aFd1tSDK = AFd1tSDK.CACHED_EVENT;
        }
        return (aFd1tSDK == AFd1tSDK.ARS_VALIDATE && (responseNetwork = ((AFd1lSDK) this).afDebugLog) != null && responseNetwork.getStatusCode() == 424) || super.valueOf();
    }

    private static String valueOf(AFe1aSDK aFe1aSDK) {
        try {
            return new URL(aFe1aSDK.AFLogger).getHost();
        } catch (MalformedURLException unused) {
            return "";
        }
    }
}
