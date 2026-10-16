package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AdManagerAdView;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzboc implements Runnable {
    final /* synthetic */ AdManagerAdView zza;
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzbu zzb;
    final /* synthetic */ zzbod zzc;

    zzboc(zzbod zzbodVar, AdManagerAdView adManagerAdView, com.google.android.gms.ads.internal.client.zzbu zzbuVar) {
        this.zza = adManagerAdView;
        this.zzb = zzbuVar;
        Objects.requireNonNull(zzbodVar);
        this.zzc = zzbodVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AdManagerAdView adManagerAdView = this.zza;
        if (adManagerAdView.e(this.zzb)) {
            this.zzc.zzc().a(adManagerAdView);
        } else {
            com.google.android.gms.ads.internal.util.client.zzo.f("Could not bind.");
        }
    }
}
