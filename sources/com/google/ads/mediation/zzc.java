package com.google.ads.mediation;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzc extends InterstitialAdLoadCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AbstractAdViewAdapter f69039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final MediationInterstitialListener f69040b;

    public zzc(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
        this.f69039a = abstractAdViewAdapter;
        this.f69040b = mediationInterstitialListener;
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.f69040b.onAdFailedToLoad(this.f69039a, loadAdError);
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final /* bridge */ /* synthetic */ void onAdLoaded(Object obj) {
        AbstractAdViewAdapter abstractAdViewAdapter = this.f69039a;
        InterstitialAd interstitialAd = (InterstitialAd) obj;
        abstractAdViewAdapter.mInterstitialAd = interstitialAd;
        MediationInterstitialListener mediationInterstitialListener = this.f69040b;
        interstitialAd.setFullScreenContentCallback(new zzd(abstractAdViewAdapter, mediationInterstitialListener));
        mediationInterstitialListener.onAdLoaded(abstractAdViewAdapter);
    }
}
