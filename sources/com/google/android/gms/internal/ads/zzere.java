package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzere implements com.google.android.gms.ads.internal.zzg {
    final /* synthetic */ zzcfw zza;
    final /* synthetic */ zzfkq zzb;
    final /* synthetic */ zzfkf zzc;
    final /* synthetic */ zzerl zzd;
    final /* synthetic */ zzerg zze;

    zzere(zzerg zzergVar, zzcfw zzcfwVar, zzfkq zzfkqVar, zzfkf zzfkfVar, zzerl zzerlVar) {
        this.zza = zzcfwVar;
        this.zzb = zzfkqVar;
        this.zzc = zzfkfVar;
        this.zzd = zzerlVar;
        Objects.requireNonNull(zzergVar);
        this.zze = zzergVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zza(View view) {
        zzerl zzerlVar = this.zzd;
        this.zza.zzc(this.zze.zzd().zza(this.zzb, this.zzc, view, zzerlVar));
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzb() {
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzc() {
    }
}
