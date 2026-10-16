package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzims implements zzimu {
    private zzind zza;

    public static void zza(zzind zzindVar, zzind zzindVar2) {
        zzims zzimsVar = (zzims) zzindVar;
        if (zzimsVar.zza != null) {
            throw new IllegalStateException();
        }
        zzimsVar.zza = zzindVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final Object zzb() {
        zzind zzindVar = this.zza;
        if (zzindVar != null) {
            return zzindVar.zzb();
        }
        throw new IllegalStateException();
    }
}
