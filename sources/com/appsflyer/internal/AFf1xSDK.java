package com.appsflyer.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AFf1xSDK extends AFe1bSDK {
    AFf1xSDK() {
        this(null, null);
    }

    @Override // com.appsflyer.internal.AFa1tSDK
    public final boolean AFLogger() {
        return false;
    }

    @Override // com.appsflyer.internal.AFa1tSDK
    public final boolean afErrorLog() {
        return false;
    }

    @Override // com.appsflyer.internal.AFa1tSDK
    public final boolean afInfoLog() {
        return false;
    }

    AFf1xSDK(String str, Boolean bool) {
        super(str, null, Boolean.FALSE, null, bool);
    }
}
