package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzinh implements zzind {
    private static final Object zza = new Object();
    private volatile zzind zzb;
    private volatile Object zzc = zza;

    private zzinh(zzind zzindVar) {
        this.zzb = zzindVar;
    }

    public static zzind zza(zzind zzindVar) {
        return ((zzindVar instanceof zzinh) || (zzindVar instanceof zzimt)) ? zzindVar : new zzinh(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final Object zzb() {
        Object obj = this.zzc;
        if (obj != zza) {
            return obj;
        }
        zzind zzindVar = this.zzb;
        if (zzindVar == null) {
            return this.zzc;
        }
        Object objZzb = zzindVar.zzb();
        this.zzc = objZzb;
        this.zzb = null;
        return objZzb;
    }
}
