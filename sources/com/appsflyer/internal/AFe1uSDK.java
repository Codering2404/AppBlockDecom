package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFe1uSDK {
    private static final long values = TimeUnit.HOURS.toSeconds(24);
    private final AFb1uSDK AFKeystoreWrapper;
    private final AFb1gSDK valueOf;

    public AFe1uSDK(AFb1gSDK aFb1gSDK, AFb1uSDK aFb1uSDK) {
        this.valueOf = aFb1gSDK;
        this.AFKeystoreWrapper = aFb1uSDK;
    }

    public final boolean AFInAppEventParameterName() {
        return Boolean.parseBoolean(this.valueOf.AFInAppEventParameterName("com.appsflyer.rc.staging"));
    }

    public final long AFInAppEventType() {
        String strAFInAppEventParameterName = this.valueOf.AFInAppEventParameterName("com.appsflyer.rc.cache.max-age-fallback");
        if (strAFInAppEventParameterName == null) {
            return values;
        }
        try {
            return Long.parseLong(strAFInAppEventParameterName);
        } catch (NumberFormatException e3) {
            StringBuilder sb = new StringBuilder("Can't read maxAgeFallback from Manifest: ");
            sb.append(e3.getMessage());
            AFLogger.afErrorLog(sb.toString(), e3);
            return values;
        }
    }

    public final boolean AFKeystoreWrapper() {
        return Boolean.parseBoolean(this.valueOf.AFInAppEventParameterName("com.appsflyer.rc.sandbox"));
    }

    public final boolean valueOf() {
        if (this.AFKeystoreWrapper.values == null) {
            AFLogger.afInfoLog("CFG: active config is missing - fetching from CDN");
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        AFb1uSDK aFb1uSDK = this.AFKeystoreWrapper;
        return jCurrentTimeMillis - aFb1uSDK.AFInAppEventType > TimeUnit.SECONDS.toMillis(aFb1uSDK.valueOf);
    }
}
