package com.google.ads.mediation.applovin;

import android.util.Log;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AppLovinInterstitialRenderer implements MediationInterstitialAd, AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdVideoPlaybackListener, AppLovinAdLoadListener {
    public static final String ERROR_MSG_MULTIPLE_INTERSTITIAL_AD = " Cannot load multiple interstitial ads with the same Zone ID. Display one ad before attempting to load another. ";
    protected static final String TAG = "AppLovinInterstitialRenderer";
    protected final AppLovinAdFactory appLovinAdFactory;
    protected final AppLovinInitializer appLovinInitializer;
    protected AppLovinAd appLovinInterstitialAd;
    private MediationInterstitialAdCallback interstitialAdCallback;
    protected final MediationInterstitialAdConfiguration interstitialAdConfiguration;
    protected final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> interstitialAdLoadCallback;
    protected String zoneId;

    public AppLovinInterstitialRenderer(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback mediationAdLoadCallback, AppLovinInitializer appLovinInitializer, AppLovinAdFactory appLovinAdFactory) {
        this.interstitialAdConfiguration = mediationInterstitialAdConfiguration;
        this.interstitialAdLoadCallback = mediationAdLoadCallback;
        this.appLovinInitializer = appLovinInitializer;
        this.appLovinAdFactory = appLovinAdFactory;
    }

    @Override // com.applovin.sdk.AppLovinAdClickListener
    public void adClicked(AppLovinAd appLovinAd) {
        Log.d(TAG, "Interstitial clicked.");
        this.interstitialAdCallback.reportAdClicked();
        this.interstitialAdCallback.onAdLeftApplication();
    }

    @Override // com.applovin.sdk.AppLovinAdDisplayListener
    public void adDisplayed(AppLovinAd appLovinAd) {
        Log.d(TAG, "Interstitial displayed.");
        this.interstitialAdCallback.onAdOpened();
    }

    @Override // com.applovin.sdk.AppLovinAdDisplayListener
    public void adHidden(AppLovinAd appLovinAd) {
        Log.d(TAG, "Interstitial dismissed.");
        this.interstitialAdCallback.onAdClosed();
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(AppLovinAd appLovinAd) {
        Log.d(TAG, "Interstitial did load ad for zone: " + this.zoneId);
        this.appLovinInterstitialAd = appLovinAd;
        this.interstitialAdCallback = (MediationInterstitialAdCallback) this.interstitialAdLoadCallback.onSuccess(this);
    }

    @Override // com.applovin.sdk.AppLovinAdLoadListener
    public void failedToReceiveAd(int i3) {
        AdError adError = AppLovinUtils.getAdError(i3);
        Log.w(TAG, adError.c());
        this.interstitialAdLoadCallback.onFailure(adError);
    }

    @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
    public void videoPlaybackBegan(AppLovinAd appLovinAd) {
        Log.d(TAG, "Interstitial video playback began.");
    }

    @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
    public void videoPlaybackEnded(AppLovinAd appLovinAd, double d3, boolean z2) {
        Log.d(TAG, "Interstitial video playback ended at playback percent: " + d3 + "%.");
    }
}
