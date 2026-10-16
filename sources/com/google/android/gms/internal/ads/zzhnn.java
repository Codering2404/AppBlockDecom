package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhnn implements zzhns {
    private final zziaz zza;
    private final zzhst zzb;

    private zzhnn(zzhst zzhstVar, zziaz zziazVar) {
        this.zzb = zzhstVar;
        this.zza = zziazVar;
    }

    public static zzhnn zza(zzhst zzhstVar) {
        return new zzhnn(zzhstVar, zzhnz.zza(zzhstVar.zza()));
    }

    public static zzhnn zzb(zzhst zzhstVar) throws GeneralSecurityException {
        return new zzhnn(zzhstVar, zzhnz.zzb(zzhstVar.zza()));
    }

    public final zzhst zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhns
    public final zziaz zzf() {
        return this.zza;
    }
}
