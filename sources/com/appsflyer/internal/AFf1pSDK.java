package com.appsflyer.internal;

import com.appsflyer.internal.AFf1jSDK;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AFf1pSDK extends AFf1jSDK {
    AFf1pSDK(String str, String str2, Runnable runnable) {
        super(str, str2, runnable);
    }

    final void valueOf(AFb1fSDK aFb1fSDK, AFb1kSDK<Map<String, Object>> aFb1kSDK) {
        if (AFa1bSDK.values().values(aFb1fSDK, false) > 0 || !aFb1kSDK.valueOf()) {
            return;
        }
        aFb1kSDK.values.AFInAppEventType().execute(aFb1kSDK.AFInAppEventType);
        this.AFLogger = System.currentTimeMillis();
        this.afDebugLog = AFf1jSDK.AFa1vSDK.STARTED;
        addObserver(new AFf1jSDK.AnonymousClass3());
    }
}
