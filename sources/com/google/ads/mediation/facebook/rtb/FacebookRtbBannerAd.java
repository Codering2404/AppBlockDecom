package com.google.ads.mediation.facebook.rtb;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.ads.Ad;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdView;
import com.facebook.ads.ExtraHints;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.ads.mediation.facebook.MetaFactory;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class FacebookRtbBannerAd implements MediationBannerAd, AdListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediationAdLoadCallback f69008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AdView f69009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FrameLayout f69010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MediationBannerAdCallback f69011d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MetaFactory f69012f;

    public FacebookRtbBannerAd(MediationAdLoadCallback mediationAdLoadCallback, MetaFactory metaFactory) {
        this.f69008a = mediationAdLoadCallback;
        this.f69012f = metaFactory;
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAd
    public View a() {
        return this.f69010c;
    }

    public void c(MediationBannerAdConfiguration mediationBannerAdConfiguration) {
        String placementId = FacebookMediationAdapter.getPlacementId(mediationBannerAdConfiguration.d());
        if (TextUtils.isEmpty(placementId)) {
            AdError adError = new AdError(101, "Failed to request ad. PlacementID is null or empty.", FacebookMediationAdapter.ERROR_DOMAIN);
            Log.e(FacebookMediationAdapter.TAG, adError.c());
            this.f69008a.onFailure(adError);
            return;
        }
        FacebookMediationAdapter.setMixedAudience(mediationBannerAdConfiguration);
        try {
            this.f69009b = this.f69012f.d(mediationBannerAdConfiguration.b(), placementId, mediationBannerAdConfiguration.a());
            if (!TextUtils.isEmpty(mediationBannerAdConfiguration.e())) {
                this.f69009b.setExtraHints(new ExtraHints.Builder().mediationData(mediationBannerAdConfiguration.e()).build());
            }
            Context contextB = mediationBannerAdConfiguration.b();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(mediationBannerAdConfiguration.h().e(contextB), -2);
            this.f69010c = new FrameLayout(contextB);
            this.f69009b.setLayoutParams(layoutParams);
            this.f69010c.addView(this.f69009b);
            AdView adView = this.f69009b;
            adView.loadAd(adView.buildLoadAdConfig().withAdListener(this).withBid(mediationBannerAdConfiguration.a()).build());
        } catch (Exception e3) {
            AdError adError2 = new AdError(111, "Failed to create banner ad: " + e3.getMessage(), FacebookMediationAdapter.ERROR_DOMAIN);
            Log.e(FacebookMediationAdapter.TAG, adError2.c());
            this.f69008a.onFailure(adError2);
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onAdClicked(Ad ad) {
        MediationBannerAdCallback mediationBannerAdCallback = this.f69011d;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.reportAdClicked();
            this.f69011d.onAdOpened();
            this.f69011d.onAdLeftApplication();
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onAdLoaded(Ad ad) {
        this.f69011d = (MediationBannerAdCallback) this.f69008a.onSuccess(this);
    }

    @Override // com.facebook.ads.AdListener
    public void onError(Ad ad, com.facebook.ads.AdError adError) {
        AdError adError2 = FacebookMediationAdapter.getAdError(adError);
        Log.w(FacebookMediationAdapter.TAG, adError2.c());
        this.f69008a.onFailure(adError2);
    }

    @Override // com.facebook.ads.AdListener
    public void onLoggingImpression(Ad ad) {
        MediationBannerAdCallback mediationBannerAdCallback = this.f69011d;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.reportAdImpression();
        }
    }
}
