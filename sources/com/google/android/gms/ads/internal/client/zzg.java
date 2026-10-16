package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdListener;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzg extends zzbg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AdListener f69959a;

    public zzg(AdListener adListener) {
        this.f69959a = adListener;
    }

    public final AdListener x3() {
        return this.f69959a;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzb() {
        AdListener adListener = this.f69959a;
        if (adListener != null) {
            adListener.onAdClosed();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzd(zze zzeVar) {
        AdListener adListener = this.f69959a;
        if (adListener != null) {
            adListener.onAdFailedToLoad(zzeVar.N());
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzf() {
        AdListener adListener = this.f69959a;
        if (adListener != null) {
            adListener.onAdLoaded();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzg() {
        AdListener adListener = this.f69959a;
        if (adListener != null) {
            adListener.onAdOpened();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzh() {
        AdListener adListener = this.f69959a;
        if (adListener != null) {
            adListener.onAdClicked();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzi() {
        AdListener adListener = this.f69959a;
        if (adListener != null) {
            adListener.onAdSwipeGestureClicked();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzj() {
        AdListener adListener = this.f69959a;
        if (adListener != null) {
            adListener.onAdImpression();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zze() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzc(int i3) {
    }
}
