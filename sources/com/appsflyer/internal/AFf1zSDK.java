package com.appsflyer.internal;

import com.appsflyer.AFInAppEventType;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFf1zSDK extends AFf1xSDK {
    public AFf1zSDK() {
        super(AFInAppEventType.PURCHASE, Boolean.TRUE);
    }

    @Override // com.appsflyer.internal.AFa1tSDK
    public final AFd1tSDK valueOf() {
        return AFd1tSDK.PURCHASE_VALIDATE;
    }

    @Override // com.appsflyer.internal.AFa1tSDK
    public final AFa1tSDK values(String str) {
        return super.values(AFa1tSDK.AFKeystoreWrapper(str));
    }
}
