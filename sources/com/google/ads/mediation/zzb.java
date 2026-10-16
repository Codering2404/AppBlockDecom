package com.google.ads.mediation;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.mediation.MediationBannerListener;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzb extends AdListener implements AppEventListener, com.google.android.gms.ads.internal.client.zza {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AbstractAdViewAdapter f69037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final MediationBannerListener f69038b;

    public zzb(AbstractAdViewAdapter abstractAdViewAdapter, MediationBannerListener mediationBannerListener) {
        this.f69037a = abstractAdViewAdapter;
        this.f69038b = mediationBannerListener;
    }

    @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        this.f69038b.onAdClicked(this.f69037a);
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdClosed() {
        this.f69038b.onAdClosed(this.f69037a);
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.f69038b.onAdFailedToLoad(this.f69037a, loadAdError);
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        this.f69038b.onAdLoaded(this.f69037a);
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdOpened() {
        this.f69038b.onAdOpened(this.f69037a);
    }

    @Override // com.google.android.gms.ads.admanager.AppEventListener
    public final void onAppEvent(String str, String str2) {
        this.f69038b.zza(this.f69037a, str, str2);
    }
}
