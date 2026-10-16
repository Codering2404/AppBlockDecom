package com.google.ads.mediation.facebook.rtb;

import android.content.Context;
import android.os.Bundle;
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
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import com.google.android.gms.ads.mediation.MediationAppOpenAdCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class MetaRtbAppOpenAd implements MediationAppOpenAd, InterstitialAdExtendedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediationAdLoadCallback f69031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MetaFactory f69032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InterstitialAd f69033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MediationAppOpenAdCallback f69034d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f69035f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f69036g;

    public MetaRtbAppOpenAd(MediationAdLoadCallback loadCallback, MetaFactory metaFactory) {
        Intrinsics.checkNotNullParameter(loadCallback, "loadCallback");
        Intrinsics.checkNotNullParameter(metaFactory, "metaFactory");
        this.f69031a = loadCallback;
        this.f69032b = metaFactory;
        this.f69035f = new AtomicBoolean();
        this.f69036g = new AtomicBoolean();
    }

    public final void a(MediationAppOpenAdConfiguration adConfiguration) {
        InterstitialAd.InterstitialAdLoadConfigBuilder interstitialAdLoadConfigBuilderBuildLoadAdConfig;
        InterstitialAd.InterstitialAdLoadConfigBuilder interstitialAdLoadConfigBuilderWithBid;
        InterstitialAd.InterstitialAdLoadConfigBuilder interstitialAdLoadConfigBuilderWithAdListener;
        InterstitialAd interstitialAd;
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Bundle bundleD = adConfiguration.d();
        Intrinsics.checkNotNullExpressionValue(bundleD, "getServerParameters(...)");
        String placementId = FacebookMediationAdapter.getPlacementId(bundleD);
        if (TextUtils.isEmpty(placementId)) {
            AdError adError = new AdError(101, "Failed to request ad. PlacementID is null or empty. ", FacebookMediationAdapter.ERROR_DOMAIN);
            Log.e(FacebookMediationAdapter.TAG, adError.c());
            this.f69031a.onFailure(adError);
            return;
        }
        FacebookMediationAdapter.setMixedAudience(adConfiguration);
        this.f69033c = this.f69032b.a(adConfiguration.b(), placementId);
        if (!TextUtils.isEmpty(adConfiguration.e()) && (interstitialAd = this.f69033c) != null) {
            interstitialAd.setExtraHints(new ExtraHints.Builder().mediationData(adConfiguration.e()).build());
        }
        InterstitialAd interstitialAd2 = this.f69033c;
        if (interstitialAd2 != null) {
            interstitialAd2.loadAd((interstitialAd2 == null || (interstitialAdLoadConfigBuilderBuildLoadAdConfig = interstitialAd2.buildLoadAdConfig()) == null || (interstitialAdLoadConfigBuilderWithBid = interstitialAdLoadConfigBuilderBuildLoadAdConfig.withBid(adConfiguration.a())) == null || (interstitialAdLoadConfigBuilderWithAdListener = interstitialAdLoadConfigBuilderWithBid.withAdListener(this)) == null) ? null : interstitialAdLoadConfigBuilderWithAdListener.build());
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onAdClicked(Ad ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        MediationAppOpenAdCallback mediationAppOpenAdCallback = this.f69034d;
        if (mediationAppOpenAdCallback != null) {
            mediationAppOpenAdCallback.reportAdClicked();
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onAdLoaded(Ad ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        this.f69034d = (MediationAppOpenAdCallback) this.f69031a.onSuccess(this);
    }

    @Override // com.facebook.ads.AdListener
    public void onError(Ad ad, com.facebook.ads.AdError adError) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(adError, "adError");
        AdError adError2 = FacebookMediationAdapter.getAdError(adError);
        Intrinsics.checkNotNullExpressionValue(adError2, "getAdError(...)");
        Log.w(FacebookMediationAdapter.TAG, adError2.c());
        if (!this.f69035f.get()) {
            this.f69031a.onFailure(adError2);
            return;
        }
        MediationAppOpenAdCallback mediationAppOpenAdCallback = this.f69034d;
        if (mediationAppOpenAdCallback != null) {
            mediationAppOpenAdCallback.onAdFailedToShow(adError2);
        }
    }

    @Override // com.facebook.ads.InterstitialAdExtendedListener
    public void onInterstitialActivityDestroyed() {
        MediationAppOpenAdCallback mediationAppOpenAdCallback;
        if (this.f69036g.getAndSet(true) || (mediationAppOpenAdCallback = this.f69034d) == null) {
            return;
        }
        mediationAppOpenAdCallback.onAdClosed();
    }

    @Override // com.facebook.ads.InterstitialAdListener
    public void onInterstitialDismissed(Ad ad) {
        MediationAppOpenAdCallback mediationAppOpenAdCallback;
        Intrinsics.checkNotNullParameter(ad, "ad");
        if (this.f69036g.getAndSet(true) || (mediationAppOpenAdCallback = this.f69034d) == null) {
            return;
        }
        mediationAppOpenAdCallback.onAdClosed();
    }

    @Override // com.facebook.ads.InterstitialAdListener
    public void onInterstitialDisplayed(Ad ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        MediationAppOpenAdCallback mediationAppOpenAdCallback = this.f69034d;
        if (mediationAppOpenAdCallback != null) {
            mediationAppOpenAdCallback.onAdOpened();
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onLoggingImpression(Ad ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        MediationAppOpenAdCallback mediationAppOpenAdCallback = this.f69034d;
        if (mediationAppOpenAdCallback != null) {
            mediationAppOpenAdCallback.reportAdImpression();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAppOpenAd
    public void showAd(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f69035f.set(true);
        InterstitialAd interstitialAd = this.f69033c;
        if (interstitialAd == null || interstitialAd.show()) {
            return;
        }
        AdError adError = new AdError(110, "Failed to present app open ad.", FacebookMediationAdapter.ERROR_DOMAIN);
        Log.w(FacebookMediationAdapter.TAG, adError.toString());
        MediationAppOpenAdCallback mediationAppOpenAdCallback = this.f69034d;
        if (mediationAppOpenAdCallback != null) {
            mediationAppOpenAdCallback.onAdFailedToShow(adError);
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
