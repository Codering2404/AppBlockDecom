package com.appsflyer.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public enum AFd1tSDK {
    RC_CDN(1),
    LOAD_CACHE(2),
    CACHED_EVENT(2),
    CONVERSION(2),
    ONELINK(2),
    DLSDK(2),
    RESOLVE_ESP(2),
    ATTR(2),
    GCDSDK(3),
    REGISTER(4),
    LAUNCH(4),
    INAPP(4),
    PURCHASE_VALIDATE(4),
    SDK_SERVICES(4),
    IMPRESSIONS(4),
    MONITORSDK(4),
    ARS_VALIDATE(4),
    ADREVENUE(4),
    AD_IMPRESSION(4);

    public final int onInstallConversionFailureNative;

    AFd1tSDK(int i3) {
        this.onInstallConversionFailureNative = i3;
    }
}
