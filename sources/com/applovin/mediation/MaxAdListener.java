package com.applovin.mediation;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface MaxAdListener {
    void onAdClicked(MaxAd maxAd);

    void onAdDisplayFailed(MaxAd maxAd, MaxError maxError);

    void onAdDisplayed(MaxAd maxAd);

    void onAdHidden(MaxAd maxAd);

    void onAdLoadFailed(String str, MaxError maxError);

    void onAdLoaded(MaxAd maxAd);
}
