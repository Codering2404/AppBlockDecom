package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.AdError;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public interface MediationInterstitialListener {
    void onAdClicked(MediationInterstitialAdapter mediationInterstitialAdapter);

    void onAdClosed(MediationInterstitialAdapter mediationInterstitialAdapter);

    void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, int i3);

    void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, AdError adError);

    void onAdLeftApplication(MediationInterstitialAdapter mediationInterstitialAdapter);

    void onAdLoaded(MediationInterstitialAdapter mediationInterstitialAdapter);

    void onAdOpened(MediationInterstitialAdapter mediationInterstitialAdapter);
}
