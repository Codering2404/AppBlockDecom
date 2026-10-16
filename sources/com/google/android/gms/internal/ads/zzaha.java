package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzaha implements zzahb {
    private final long zza;
    private final zzagz zzb;

    public zzaha(long j3, long j4) {
        this.zza = j3;
        zzahc zzahcVar = j4 == 0 ? zzahc.zza : new zzahc(0L, j4);
        this.zzb = new zzagz(zzahcVar, zzahcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final long zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzb() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j3) {
        return this.zzb;
    }
}
