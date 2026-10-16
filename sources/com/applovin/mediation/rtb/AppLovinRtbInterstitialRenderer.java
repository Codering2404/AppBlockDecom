package com.applovin.mediation.rtb;

import android.content.Context;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.mediation.AppLovinExtras;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinSdk;
import com.google.ads.mediation.applovin.AppLovinAdFactory;
import com.google.ads.mediation.applovin.AppLovinInitializer;
import com.google.ads.mediation.applovin.AppLovinInterstitialRenderer;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AppLovinRtbInterstitialRenderer extends AppLovinInterstitialRenderer implements MediationInterstitialAd {
    private AppLovinInterstitialAdDialog interstitialAd;
    private final AppLovinSdk sdk;

    public AppLovinRtbInterstitialRenderer(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback, AppLovinInitializer appLovinInitializer, AppLovinAdFactory appLovinAdFactory) {
        super(mediationInterstitialAdConfiguration, mediationAdLoadCallback, appLovinInitializer, appLovinAdFactory);
        this.sdk = appLovinInitializer.e(mediationInterstitialAdConfiguration.d(), mediationInterstitialAdConfiguration.b());
    }

    public void loadAd() {
        AppLovinInterstitialAdDialog appLovinInterstitialAdDialogD = this.appLovinAdFactory.d(this.sdk, this.interstitialAdConfiguration.b());
        this.interstitialAd = appLovinInterstitialAdDialogD;
        appLovinInterstitialAdDialogD.setAdDisplayListener(this);
        this.interstitialAd.setAdClickListener(this);
        this.interstitialAd.setAdVideoPlaybackListener(this);
        this.interstitialAd.setExtraInfo(AppLovinExtras.Keys.KEY_WATERMARK, this.interstitialAdConfiguration.e());
        this.sdk.getAdService().loadNextAdForAdToken(this.interstitialAdConfiguration.a(), this);
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAd
    public void showAd(Context context) {
        this.sdk.getSettings().setMuted(AppLovinUtils.shouldMuteAudio(this.interstitialAdConfiguration.c()));
        this.interstitialAd.showAndRender(this.appLovinInterstitialAd);
    }
}
