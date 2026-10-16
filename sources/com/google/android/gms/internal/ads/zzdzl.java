package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdzl {
    private final zzdzq zza;
    private final Executor zzb;
    private final Map zzc;

    public zzdzl(zzdzq zzdzqVar, Executor executor) {
        this.zza = zzdzqVar;
        this.zzc = zzdzqVar.zza();
        this.zzb = executor;
    }

    public final zzdzk zza() {
        zzdzk zzdzkVar = new zzdzk(this);
        zzdzkVar.zzj();
        return zzdzkVar;
    }

    public final void zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zznc)).booleanValue()) {
            zzdzk zzdzkVarZza = zza();
            zzdzkVarZza.zzc("action", "pecr");
            zzdzkVarZza.zzd();
        }
    }

    final /* synthetic */ zzdzq zzc() {
        return this.zza;
    }

    final /* synthetic */ Executor zzd() {
        return this.zzb;
    }

    final /* synthetic */ Map zze() {
        return this.zzc;
    }
}
