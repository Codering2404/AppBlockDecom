package com.google.ads.mediation;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.zzg;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.internal.ads.zzbmw;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zze extends AdListener implements zzg, com.google.android.gms.ads.formats.zze, com.google.android.gms.ads.formats.zzd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AbstractAdViewAdapter f69043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final MediationNativeListener f69044b;

    public zze(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
        this.f69043a = abstractAdViewAdapter;
        this.f69044b = mediationNativeListener;
    }

    @Override // com.google.android.gms.ads.formats.zze
    public final void a(zzbmw zzbmwVar) {
        this.f69044b.zzc(this.f69043a, zzbmwVar);
    }

    @Override // com.google.android.gms.ads.formats.zzd
    public final void b(zzbmw zzbmwVar, String str) {
        this.f69044b.zzd(this.f69043a, zzbmwVar, str);
    }

    @Override // com.google.android.gms.ads.formats.zzg
    public final void c(UnifiedNativeAd unifiedNativeAd) {
        this.f69044b.onAdLoaded(this.f69043a, new zza(unifiedNativeAd));
    }

    @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        this.f69044b.onAdClicked(this.f69043a);
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdClosed() {
        this.f69044b.onAdClosed(this.f69043a);
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.f69044b.onAdFailedToLoad(this.f69043a, loadAdError);
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdImpression() {
        this.f69044b.onAdImpression(this.f69043a);
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdOpened() {
        this.f69044b.onAdOpened(this.f69043a);
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
    }
}
