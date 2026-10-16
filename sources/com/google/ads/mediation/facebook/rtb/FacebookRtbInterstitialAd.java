package com.google.ads.mediation.facebook.rtb;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.Ad;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.ads.mediation.facebook.MetaFactory;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class FacebookRtbInterstitialAd implements MediationInterstitialAd, InterstitialAdExtendedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediationAdLoadCallback f69013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InterstitialAd f69014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MediationInterstitialAdCallback f69015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f69016d = new AtomicBoolean();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f69017f = new AtomicBoolean();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MetaFactory f69018g;

    public FacebookRtbInterstitialAd(MediationAdLoadCallback mediationAdLoadCallback, MetaFactory metaFactory) {
        this.f69013a = mediationAdLoadCallback;
        this.f69018g = metaFactory;
    }

    public void a(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration) {
        String placementId = FacebookMediationAdapter.getPlacementId(mediationInterstitialAdConfiguration.d());
        if (TextUtils.isEmpty(placementId)) {
            AdError adError = new AdError(101, "Failed to request ad. PlacementID is null or empty. ", FacebookMediationAdapter.ERROR_DOMAIN);
            Log.e(FacebookMediationAdapter.TAG, adError.c());
            this.f69013a.onFailure(adError);
        } else {
            FacebookMediationAdapter.setMixedAudience(mediationInterstitialAdConfiguration);
            this.f69014b = this.f69018g.b(mediationInterstitialAdConfiguration.b(), placementId);
            if (!TextUtils.isEmpty(mediationInterstitialAdConfiguration.e())) {
                this.f69014b.setExtraHints(new ExtraHints.Builder().mediationData(mediationInterstitialAdConfiguration.e()).build());
            }
            InterstitialAd interstitialAd = this.f69014b;
            interstitialAd.loadAd(interstitialAd.buildLoadAdConfig().withBid(mediationInterstitialAdConfiguration.a()).withAdListener(this).build());
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onAdClicked(Ad ad) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.f69015c;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.reportAdClicked();
            this.f69015c.onAdLeftApplication();
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onAdLoaded(Ad ad) {
        this.f69015c = (MediationInterstitialAdCallback) this.f69013a.onSuccess(this);
    }

    @Override // com.facebook.ads.AdListener
    public void onError(Ad ad, com.facebook.ads.AdError adError) {
        AdError adError2 = FacebookMediationAdapter.getAdError(adError);
        Log.w(FacebookMediationAdapter.TAG, adError2.c());
        if (!this.f69016d.get()) {
            this.f69013a.onFailure(adError2);
            return;
        }
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.f69015c;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdFailedToShow(adError2);
        }
    }

    @Override // com.facebook.ads.InterstitialAdExtendedListener
    public void onInterstitialActivityDestroyed() {
        MediationInterstitialAdCallback mediationInterstitialAdCallback;
        if (this.f69017f.getAndSet(true) || (mediationInterstitialAdCallback = this.f69015c) == null) {
            return;
        }
        mediationInterstitialAdCallback.onAdClosed();
    }

    @Override // com.facebook.ads.InterstitialAdListener
    public void onInterstitialDismissed(Ad ad) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback;
        if (this.f69017f.getAndSet(true) || (mediationInterstitialAdCallback = this.f69015c) == null) {
            return;
        }
        mediationInterstitialAdCallback.onAdClosed();
    }

    @Override // com.facebook.ads.InterstitialAdListener
    public void onInterstitialDisplayed(Ad ad) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.f69015c;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdOpened();
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onLoggingImpression(Ad ad) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.f69015c;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.reportAdImpression();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAd
    public void showAd(Context context) {
        this.f69016d.set(true);
        if (this.f69014b.show()) {
            return;
        }
        AdError adError = new AdError(110, "Failed to present interstitial ad.", FacebookMediationAdapter.ERROR_DOMAIN);
        Log.w(FacebookMediationAdapter.TAG, adError.toString());
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.f69015c;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdFailedToShow(adError);
        }
    }

    @Override // com.facebook.ads.RewardedAdListener
    public void onRewardedAdCompleted() {
    }

    @Override // com.facebook.ads.RewardedAdListener
    public void onRewardedAdServerFailed() {
    }

    @Override // com.facebook.ads.RewardedAdListener
    public void onRewardedAdServerSucceeded() {
    }
}
