package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzaim {
    protected final zzahk zza;

    protected zzaim(zzahk zzahkVar) {
        this.zza = zzahkVar;
    }

    protected abstract boolean zza(zzet zzetVar) throws zzat;

    protected abstract boolean zzb(zzet zzetVar, long j3) throws zzat;

    public final boolean zzf(zzet zzetVar, long j3) throws zzat {
        return zza(zzetVar) && zzb(zzetVar, j3);
    }
}
