package com.google.ads.mediation;

import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzd extends FullScreenContentCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AbstractAdViewAdapter f69041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final MediationInterstitialListener f69042b;

    public zzd(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
        this.f69041a = abstractAdViewAdapter;
        this.f69042b = mediationInterstitialListener;
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public final void b() {
        this.f69042b.onAdClosed(this.f69041a);
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public final void e() {
        this.f69042b.onAdOpened(this.f69041a);
    }
}
