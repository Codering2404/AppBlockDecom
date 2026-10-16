package com.applovin.mediation;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class AppLovinInterstitialAdListener implements AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdVideoPlaybackListener {
    private final ApplovinAdapter adapter;
    private final MediationInterstitialListener mediationInterstitialListener;

    AppLovinInterstitialAdListener(ApplovinAdapter applovinAdapter, MediationInterstitialListener mediationInterstitialListener) {
        this.adapter = applovinAdapter;
        this.mediationInterstitialListener = mediationInterstitialListener;
    }

    @Override // com.applovin.sdk.AppLovinAdClickListener
    public void adClicked(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Interstitial clicked.");
        this.mediationInterstitialListener.onAdClicked(this.adapter);
        this.mediationInterstitialListener.onAdLeftApplication(this.adapter);
    }

    @Override // com.applovin.sdk.AppLovinAdDisplayListener
    public void adDisplayed(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Interstitial displayed.");
        this.mediationInterstitialListener.onAdOpened(this.adapter);
    }

    @Override // com.applovin.sdk.AppLovinAdDisplayListener
    public void adHidden(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Interstitial dismissed.");
        this.adapter.unregister();
        this.mediationInterstitialListener.onAdClosed(this.adapter);
    }

    @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
    public void videoPlaybackBegan(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Interstitial video playback began.");
    }

    @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
    public void videoPlaybackEnded(AppLovinAd appLovinAd, double d3, boolean z2) {
        ApplovinAdapter.log(3, "Interstitial video playback ended at playback percent: " + d3 + "%.");
    }
}
