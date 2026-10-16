package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdje implements zzimu {
    private final zzdir zza;

    private zzdje(zzdir zzdirVar) {
        this.zza = zzdirVar;
    }

    public static zzdje zza(zzdir zzdirVar) {
        return new zzdje(zzdirVar);
    }

    public static Set zzc(zzdir zzdirVar) {
        return zzdirVar.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return this.zza.zzm();
    }
}
