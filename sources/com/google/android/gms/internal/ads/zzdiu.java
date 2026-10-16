package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdiu implements zzimu {
    private final zzdir zza;

    private zzdiu(zzdir zzdirVar) {
        this.zza = zzdirVar;
    }

    public static zzdiu zza(zzdir zzdirVar) {
        return new zzdiu(zzdirVar);
    }

    public static Set zzc(zzdir zzdirVar) {
        Set set = Collections.EMPTY_SET;
        zzinc.zzb(set);
        return set;
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return zzc(this.zza);
    }
}
