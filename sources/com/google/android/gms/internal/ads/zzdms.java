package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdms implements zzimu {
    private final zzind zza;

    private zzdms(zzdmd zzdmdVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdms zza(zzdmd zzdmdVar, zzind zzindVar) {
        return new zzdms(zzdmdVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton = Collections.singleton(new zzdkq((zzdbk) this.zza.zzb(), zzcfr.zzh));
        zzinc.zzb(setSingleton);
        return setSingleton;
    }
}
