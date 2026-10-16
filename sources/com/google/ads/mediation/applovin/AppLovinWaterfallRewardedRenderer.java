package com.google.ads.mediation.applovin;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAd;
import com.google.ads.mediation.applovin.AppLovinInitializer;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinWaterfallRewardedRenderer extends AppLovinRewardedRenderer implements MediationRewardedAd {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final HashMap f68982c = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f68983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f68984b;

    protected AppLovinWaterfallRewardedRenderer(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback mediationAdLoadCallback, AppLovinInitializer appLovinInitializer, AppLovinAdFactory appLovinAdFactory, AppLovinSdkUtilsWrapper appLovinSdkUtilsWrapper) {
        super(mediationRewardedAdConfiguration, mediationAdLoadCallback, appLovinInitializer, appLovinAdFactory, appLovinSdkUtilsWrapper);
        this.f68984b = false;
    }

    @Override // com.google.ads.mediation.applovin.AppLovinRewardedRenderer, com.applovin.sdk.AppLovinAdDisplayListener
    public void adHidden(AppLovinAd appLovinAd) {
        f68982c.remove(this.f68983a);
        super.adHidden(appLovinAd);
    }

    @Override // com.google.ads.mediation.applovin.AppLovinRewardedRenderer, com.applovin.sdk.AppLovinAdLoadListener
    public void adReceived(AppLovinAd appLovinAd) {
        if (this.f68984b) {
            f68982c.remove(this.f68983a);
        }
        super.adReceived(appLovinAd);
    }

    @Override // com.google.ads.mediation.applovin.AppLovinRewardedRenderer, com.applovin.sdk.AppLovinAdLoadListener
    public void failedToReceiveAd(int i3) {
        f68982c.remove(this.f68983a);
        super.failedToReceiveAd(i3);
    }

    public void loadAd() {
        final Context contextB = this.adConfiguration.b();
        final Bundle bundleD = this.adConfiguration.d();
        String string = bundleD.getString(AppLovinUtils.ServerParameterKeys.SDK_KEY);
        if (TextUtils.isEmpty(string)) {
            AdError adError = new AdError(110, "Missing or invalid SDK Key.", AppLovinMediationAdapter.APPLOVIN_SDK_ERROR_DOMAIN);
            Log.e(AppLovinRewardedRenderer.TAG, adError.toString());
            this.adLoadCallback.onFailure(adError);
        } else {
            if (AppLovinUtils.isMultiAdsEnabled(bundleD)) {
                this.f68984b = true;
            }
            this.appLovinInitializer.d(contextB, string, new AppLovinInitializer.OnInitializeSuccessListener() { // from class: com.google.ads.mediation.applovin.AppLovinWaterfallRewardedRenderer.1
                @Override // com.google.ads.mediation.applovin.AppLovinInitializer.OnInitializeSuccessListener
                public void onInitializeSuccess(String str) {
                    AppLovinWaterfallRewardedRenderer.this.f68983a = AppLovinUtils.retrieveZoneId(bundleD);
                    AppLovinWaterfallRewardedRenderer appLovinWaterfallRewardedRenderer = AppLovinWaterfallRewardedRenderer.this;
                    appLovinWaterfallRewardedRenderer.appLovinSdk = appLovinWaterfallRewardedRenderer.appLovinInitializer.e(bundleD, contextB);
                    String str2 = String.format("Requesting rewarded video for zone '%s'", AppLovinWaterfallRewardedRenderer.this.f68983a);
                    String str3 = AppLovinRewardedRenderer.TAG;
                    Log.d(str3, str2);
                    HashMap map = AppLovinWaterfallRewardedRenderer.f68982c;
                    if (map.containsKey(AppLovinWaterfallRewardedRenderer.this.f68983a)) {
                        AdError adError2 = new AdError(105, "Cannot load multiple rewarded ads with the same Zone ID. Display one ad before attempting to load another.", AppLovinMediationAdapter.ERROR_DOMAIN);
                        Log.e(str3, adError2.toString());
                        AppLovinWaterfallRewardedRenderer.this.adLoadCallback.onFailure(adError2);
                        return;
                    }
                    map.put(AppLovinWaterfallRewardedRenderer.this.f68983a, new WeakReference(AppLovinWaterfallRewardedRenderer.this));
                    if (Objects.equals(AppLovinWaterfallRewardedRenderer.this.f68983a, "")) {
                        AppLovinWaterfallRewardedRenderer appLovinWaterfallRewardedRenderer2 = AppLovinWaterfallRewardedRenderer.this;
                        appLovinWaterfallRewardedRenderer2.incentivizedInterstitial = appLovinWaterfallRewardedRenderer2.appLovinAdFactory.b(appLovinWaterfallRewardedRenderer2.appLovinSdk);
                    } else {
                        AppLovinWaterfallRewardedRenderer appLovinWaterfallRewardedRenderer3 = AppLovinWaterfallRewardedRenderer.this;
                        appLovinWaterfallRewardedRenderer3.incentivizedInterstitial = appLovinWaterfallRewardedRenderer3.appLovinAdFactory.c(appLovinWaterfallRewardedRenderer3.f68983a, AppLovinWaterfallRewardedRenderer.this.appLovinSdk);
                    }
                    AppLovinWaterfallRewardedRenderer appLovinWaterfallRewardedRenderer4 = AppLovinWaterfallRewardedRenderer.this;
                    appLovinWaterfallRewardedRenderer4.incentivizedInterstitial.preload(appLovinWaterfallRewardedRenderer4);
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAd
    public void showAd(Context context) {
        this.appLovinSdk.getSettings().setMuted(AppLovinUtils.shouldMuteAudio(this.adConfiguration.c()));
        String str = this.f68983a;
        if (str != null) {
            Log.d(AppLovinRewardedRenderer.TAG, String.format("Showing rewarded video for zone '%s'", str));
        }
        if (this.incentivizedInterstitial.isAdReadyToDisplay()) {
            this.incentivizedInterstitial.show(context, this, this, this, this);
            return;
        }
        AdError adError = new AdError(106, "Ad not ready to show.", AppLovinMediationAdapter.ERROR_DOMAIN);
        Log.e(AppLovinRewardedRenderer.TAG, adError.toString());
        this.rewardedAdCallback.onAdFailedToShow(adError);
    }
}
