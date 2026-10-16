package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbtp implements zzcga {
    final /* synthetic */ zzbto zza;

    zzbtp(zzbtt zzbttVar, zzbto zzbtoVar) {
        this.zza = zzbtoVar;
        Objects.requireNonNull(zzbttVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcga
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        com.google.android.gms.ads.internal.util.zze.k("Getting a new session for JS Engine.");
        this.zza.zzf(((zzbsp) obj).zzl());
    }
}
