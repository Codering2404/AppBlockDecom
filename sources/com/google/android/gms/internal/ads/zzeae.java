package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeae implements zzimu {
    private final zzeaa zza;
    private final zzind zzb;

    private zzeae(zzeaa zzeaaVar, zzind zzindVar, zzind zzindVar2) {
        this.zza = zzeaaVar;
        this.zzb = zzindVar;
    }

    public static zzeae zza(zzeaa zzeaaVar, zzind zzindVar, zzind zzindVar2) {
        return new zzeae(zzeaaVar, zzindVar, zzindVar2);
    }

    public static Set zzc(zzeaa zzeaaVar, zzeak zzeakVar, Executor executor) {
        Set setZzd = zzeaa.zzd(zzeakVar, executor);
        zzinc.zzb(setZzd);
        return setZzd;
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return zzc(this.zza, (zzeak) this.zzb.zzb(), zzfoa.zzc());
    }
}
