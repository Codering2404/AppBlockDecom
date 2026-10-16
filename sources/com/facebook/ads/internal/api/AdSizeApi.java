package com.facebook.ads.internal.api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface AdSizeApi {

    @Deprecated
    public static final int BANNER_320_50 = 4;
    public static final int BANNER_HEIGHT_50 = 5;
    public static final int BANNER_HEIGHT_90 = 6;
    public static final int INTERSTITIAL = 100;
    public static final int RECTANGLE_HEIGHT_250 = 7;

    int getHeight();

    int getWidth();
}
