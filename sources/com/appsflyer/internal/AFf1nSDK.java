package com.appsflyer.internal;

import com.appsflyer.AFLogger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AFf1nSDK extends AFf1jSDK {
    public AFf1nSDK(String str, String str2, Runnable runnable) {
        super(str, str2, runnable);
    }

    protected static boolean AFInAppEventType() {
        if (AFa1bSDK.values().values(AFa1bSDK.values().valueOf().AFKeystoreWrapper(), false) <= 0) {
            return true;
        }
        AFLogger.afRDLog("Install referrer will not load, the counter > 1, ");
        return false;
    }
}
