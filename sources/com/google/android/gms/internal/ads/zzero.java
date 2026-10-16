package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzero implements com.google.android.gms.ads.internal.zzg {
    final /* synthetic */ zzdma zza;

    zzero(zzerp zzerpVar, zzdma zzdmaVar) {
        this.zza = zzdmaVar;
        Objects.requireNonNull(zzerpVar);
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzb() {
        this.zza.zzc().onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzc() {
        zzdma zzdmaVar = this.zza;
        zzdmaVar.zzd().zza();
        zzdmaVar.zze().zza();
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zza(View view) {
    }
}
