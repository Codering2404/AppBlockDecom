package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbxs implements com.google.android.gms.ads.internal.overlay.zzr {
    final /* synthetic */ zzbxu zza;

    zzbxs(zzbxu zzbxuVar) {
        Objects.requireNonNull(zzbxuVar);
        this.zza = zzbxuVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdT() {
        com.google.android.gms.ads.internal.util.client.zzo.a("Delay close AdMobCustomTabsAdapter overlay.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdU(int i3) {
        com.google.android.gms.ads.internal.util.client.zzo.a("AdMobCustomTabsAdapter overlay is closed.");
        zzbxu zzbxuVar = this.zza;
        zzbxuVar.zzb().onAdClosed(zzbxuVar);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdo() {
        com.google.android.gms.ads.internal.util.client.zzo.a("AdMobCustomTabsAdapter overlay is created.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdp() {
        com.google.android.gms.ads.internal.util.client.zzo.a("AdMobCustomTabsAdapter overlay is started.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdq() {
        com.google.android.gms.ads.internal.util.client.zzo.a("AdMobCustomTabsAdapter overlay is restarted.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdw() {
        com.google.android.gms.ads.internal.util.client.zzo.a("AdMobCustomTabsAdapter overlay is paused.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdx() {
        com.google.android.gms.ads.internal.util.client.zzo.a("AdMobCustomTabsAdapter overlay is resumed.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdy() {
        com.google.android.gms.ads.internal.util.client.zzo.a("AdMobCustomTabsAdapter overlay is stopped.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdz() {
        com.google.android.gms.ads.internal.util.client.zzo.a("AdMobCustomTabsAdapter overlay is destroyed.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzh() {
        com.google.android.gms.ads.internal.util.client.zzo.a("Opening AdMobCustomTabsAdapter overlay.");
        zzbxu zzbxuVar = this.zza;
        zzbxuVar.zzb().onAdOpened(zzbxuVar);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdv() {
    }
}
