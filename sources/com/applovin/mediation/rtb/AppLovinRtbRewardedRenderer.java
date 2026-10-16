package com.applovin.mediation.rtb;

import android.content.Context;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.mediation.AppLovinExtras;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinSdk;
import com.google.ads.mediation.applovin.AppLovinAdFactory;
import com.google.ads.mediation.applovin.AppLovinInitializer;
import com.google.ads.mediation.applovin.AppLovinRewardedRenderer;
import com.google.ads.mediation.applovin.AppLovinSdkUtilsWrapper;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AppLovinRtbRewardedRenderer extends AppLovinRewardedRenderer {
    private AppLovinAd appLovinAd;

    public AppLovinRtbRewardedRenderer(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback, AppLovinInitializer appLovinInitializer, AppLovinAdFactory appLovinAdFactory, AppLovinSdkUtilsWrapper appLovinSdkUtilsWrapper) {
        super(mediationRewardedAdConfiguration, mediationAdLoadCallback, appLovinInitializer, appLovinAdFactory, appLovinSdkUtilsWrapper);
    }

    @Override // com.google.ads.mediation.applovin.AppLovinRewardedRenderer, com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(AppLovinAd appLovinAd) {
        this.appLovinAd = appLovinAd;
        super.adReceived(appLovinAd);
    }

    public void loadAd() {
        AppLovinSdk appLovinSdkE = this.appLovinInitializer.e(this.adConfiguration.d(), this.adConfiguration.b());
        this.appLovinSdk = appLovinSdkE;
        AppLovinIncentivizedInterstitial appLovinIncentivizedInterstitialB = this.appLovinAdFactory.b(appLovinSdkE);
        this.incentivizedInterstitial = appLovinIncentivizedInterstitialB;
        appLovinIncentivizedInterstitialB.setExtraInfo(AppLovinExtras.Keys.KEY_WATERMARK, this.adConfiguration.e());
        this.appLovinSdk.getAdService().loadNextAdForAdToken(this.adConfiguration.a(), this);
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAd
    public void showAd(Context context) {
        this.appLovinSdk.getSettings().setMuted(AppLovinUtils.shouldMuteAudio(this.adConfiguration.c()));
        this.incentivizedInterstitial.show(this.appLovinAd, context, this, this, this, this);
    }
}
