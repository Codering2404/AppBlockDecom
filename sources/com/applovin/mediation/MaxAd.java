package com.applovin.mediation;

import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface MaxAd {
    String getAdReviewCreativeId();

    String getAdUnitId();

    String getAdValue(String str);

    String getAdValue(String str, String str2);

    String getCreativeId();

    String getDspId();

    String getDspName();

    MaxAdFormat getFormat();

    MaxNativeAd getNativeAd();

    String getNetworkName();

    String getNetworkPlacement();

    String getPlacement();

    long getRequestLatencyMillis();

    double getRevenue();

    String getRevenuePrecision();

    AppLovinSdkUtils.Size getSize();

    MaxAdWaterfallInfo getWaterfall();
}
