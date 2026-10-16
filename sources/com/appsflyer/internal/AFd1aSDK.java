package com.appsflyer.internal;

import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFd1aSDK extends AFd1lSDK<String> {
    private final Map<String, Object> AFLogger;

    public AFd1aSDK(Map<String, Object> map, AFc1ySDK aFc1ySDK) {
        super(AFd1tSDK.MONITORSDK, new AFd1tSDK[]{AFd1tSDK.RC_CDN}, aFc1ySDK, String.valueOf(map.hashCode()));
        this.AFLogger = new HashMap(map);
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    protected final AFc1qSDK<String> AFInAppEventType(String str) {
        return ((AFd1lSDK) this).afErrorLog.valueOf(this.AFLogger);
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    protected final AppsFlyerRequestListener AFLogger() {
        return null;
    }

    @Override // com.appsflyer.internal.AFd1lSDK
    protected final boolean afRDLog() {
        return false;
    }
}
