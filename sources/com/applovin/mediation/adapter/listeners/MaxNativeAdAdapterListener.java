package com.applovin.mediation.adapter.listeners;

import android.os.Bundle;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.nativeAds.MaxNativeAd;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface MaxNativeAdAdapterListener extends MaxAdapterListener {
    void onNativeAdClicked();

    void onNativeAdClicked(Bundle bundle);

    void onNativeAdDisplayed(Bundle bundle);

    void onNativeAdLoadFailed(MaxAdapterError maxAdapterError);

    void onNativeAdLoaded(MaxNativeAd maxNativeAd, Bundle bundle);
}
