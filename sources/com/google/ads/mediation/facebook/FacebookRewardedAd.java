package com.google.ads.mediation.facebook;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.Ad;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdExtendedListener;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class FacebookRewardedAd implements MediationRewardedAd, RewardedVideoAdExtendedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediationAdLoadCallback f69001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RewardedVideoAd f69002b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MediationRewardedAdCallback f69004d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MetaFactory f69006g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f69003c = new AtomicBoolean();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f69005f = new AtomicBoolean();

    public FacebookRewardedAd(MediationAdLoadCallback mediationAdLoadCallback, MetaFactory metaFactory) {
        this.f69001a = mediationAdLoadCallback;
        this.f69006g = metaFactory;
    }

    AdExperienceType a() {
        return AdExperienceType.AD_EXPERIENCE_TYPE_REWARDED;
    }

    public void b(MediationRewardedAdConfiguration mediationRewardedAdConfiguration) {
        Context contextB = mediationRewardedAdConfiguration.b();
        String placementId = FacebookMediationAdapter.getPlacementId(mediationRewardedAdConfiguration.d());
        if (TextUtils.isEmpty(placementId)) {
            AdError adError = new AdError(101, "Failed to request ad. PlacementID is null or empty.", FacebookMediationAdapter.ERROR_DOMAIN);
            Log.e(FacebookMediationAdapter.TAG, adError.c());
            this.f69001a.onFailure(adError);
        } else {
            FacebookMediationAdapter.setMixedAudience(mediationRewardedAdConfiguration);
            this.f69002b = this.f69006g.e(contextB, placementId);
            if (!TextUtils.isEmpty(mediationRewardedAdConfiguration.e())) {
                this.f69002b.setExtraHints(new ExtraHints.Builder().mediationData(mediationRewardedAdConfiguration.e()).build());
            }
            RewardedVideoAd rewardedVideoAd = this.f69002b;
            rewardedVideoAd.loadAd(rewardedVideoAd.buildLoadAdConfig().withAdListener(this).withBid(mediationRewardedAdConfiguration.a()).withAdExperience(a()).build());
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onAdClicked(Ad ad) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.f69004d;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.reportAdClicked();
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onAdLoaded(Ad ad) {
        MediationAdLoadCallback mediationAdLoadCallback = this.f69001a;
        if (mediationAdLoadCallback != null) {
            this.f69004d = (MediationRewardedAdCallback) mediationAdLoadCallback.onSuccess(this);
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onError(Ad ad, com.facebook.ads.AdError adError) {
        AdError adError2 = FacebookMediationAdapter.getAdError(adError);
        if (this.f69003c.get()) {
            Log.w(FacebookMediationAdapter.TAG, adError2.c());
            MediationRewardedAdCallback mediationRewardedAdCallback = this.f69004d;
            if (mediationRewardedAdCallback != null) {
                mediationRewardedAdCallback.onAdFailedToShow(adError2);
            }
        } else {
            Log.w(FacebookMediationAdapter.TAG, adError2.c());
            MediationAdLoadCallback mediationAdLoadCallback = this.f69001a;
            if (mediationAdLoadCallback != null) {
                mediationAdLoadCallback.onFailure(adError2);
            }
        }
        this.f69002b.destroy();
    }

    @Override // com.facebook.ads.AdListener
    public void onLoggingImpression(Ad ad) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.f69004d;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.reportAdImpression();
        }
    }

    @Override // com.facebook.ads.RewardedVideoAdExtendedListener
    public void onRewardedVideoActivityDestroyed() {
        MediationRewardedAdCallback mediationRewardedAdCallback;
        if (!this.f69005f.getAndSet(true) && (mediationRewardedAdCallback = this.f69004d) != null) {
            mediationRewardedAdCallback.onAdClosed();
        }
        RewardedVideoAd rewardedVideoAd = this.f69002b;
        if (rewardedVideoAd != null) {
            rewardedVideoAd.destroy();
        }
    }

    @Override // com.facebook.ads.RewardedVideoAdListener
    public void onRewardedVideoClosed() {
        MediationRewardedAdCallback mediationRewardedAdCallback;
        if (!this.f69005f.getAndSet(true) && (mediationRewardedAdCallback = this.f69004d) != null) {
            mediationRewardedAdCallback.onAdClosed();
        }
        RewardedVideoAd rewardedVideoAd = this.f69002b;
        if (rewardedVideoAd != null) {
            rewardedVideoAd.destroy();
        }
    }

    @Override // com.facebook.ads.RewardedVideoAdListener
    public void onRewardedVideoCompleted() {
        this.f69004d.onVideoComplete();
        this.f69004d.onUserEarnedReward();
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAd
    public void showAd(Context context) {
        this.f69003c.set(true);
        if (this.f69002b.show()) {
            MediationRewardedAdCallback mediationRewardedAdCallback = this.f69004d;
            if (mediationRewardedAdCallback != null) {
                mediationRewardedAdCallback.onVideoStart();
                this.f69004d.onAdOpened();
                return;
            }
            return;
        }
        AdError adError = new AdError(110, "Failed to present rewarded ad.", FacebookMediationAdapter.ERROR_DOMAIN);
        Log.w(FacebookMediationAdapter.TAG, adError.c());
        MediationRewardedAdCallback mediationRewardedAdCallback2 = this.f69004d;
        if (mediationRewardedAdCallback2 != null) {
            mediationRewardedAdCallback2.onAdFailedToShow(adError);
        }
        this.f69002b.destroy();
    }
}
