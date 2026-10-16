package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbuj implements zzcga {
    final /* synthetic */ zzbto zza;
    final /* synthetic */ Object zzb;
    final /* synthetic */ zzcfw zzc;
    final /* synthetic */ zzbum zzd;

    zzbuj(zzbum zzbumVar, zzbto zzbtoVar, Object obj, zzcfw zzcfwVar) {
        this.zza = zzbtoVar;
        this.zzb = obj;
        this.zzc = zzcfwVar;
        Objects.requireNonNull(zzbumVar);
        this.zzd = zzbumVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcga
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        com.google.android.gms.ads.internal.util.zze.k("callJs > getEngine: Promise fulfilled");
        Object obj2 = this.zzb;
        zzcfw zzcfwVar = this.zzc;
        this.zzd.zzc(this.zza, (zzbtv) obj, obj2, zzcfwVar);
    }
}
