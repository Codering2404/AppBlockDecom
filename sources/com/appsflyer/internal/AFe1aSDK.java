package com.appsflyer.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFe1aSDK extends AFa1tSDK {
    public final AFd1tSDK AFLogger$LogLevel;

    @Deprecated
    public AFe1aSDK() {
        this.AFLogger$LogLevel = null;
    }

    @Override // com.appsflyer.internal.AFa1tSDK
    public final AFd1tSDK valueOf() {
        AFd1tSDK aFd1tSDK = this.AFLogger$LogLevel;
        return aFd1tSDK != null ? aFd1tSDK : AFd1tSDK.CACHED_EVENT;
    }

    public AFe1aSDK(String str, byte[] bArr, String str2, AFd1tSDK aFd1tSDK) {
        super(null, str, Boolean.FALSE);
        this.valueOf = str2;
        AFInAppEventParameterName(bArr);
        this.AFLogger$LogLevel = aFd1tSDK;
    }
}
