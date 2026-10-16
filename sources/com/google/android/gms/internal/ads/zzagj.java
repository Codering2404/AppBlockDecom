package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzagj implements zzahb {
    private final zzagl zza;
    private final long zzb;

    public zzagj(zzagl zzaglVar, long j3) {
        this.zza = zzaglVar;
        this.zzb = j3;
    }

    private final zzahc zze(long j3, long j4) {
        return new zzahc((j3 * 1000000) / ((long) this.zza.zze), this.zzb + j4);
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final long zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j3) {
        zzagl zzaglVar = this.zza;
        zzagk zzagkVar = zzaglVar.zzk;
        zzagkVar.getClass();
        long jZzb = zzaglVar.zzb(j3);
        long[] jArr = zzagkVar.zza;
        int iZzo = zzfl.zzo(jArr, jZzb, true, false);
        long j4 = iZzo == -1 ? 0L : jArr[iZzo];
        long[] jArr2 = zzagkVar.zzb;
        zzahc zzahcVarZze = zze(j4, iZzo != -1 ? jArr2[iZzo] : 0L);
        if (zzahcVarZze.zzb == j3 || iZzo == jArr.length - 1) {
            return new zzagz(zzahcVarZze, zzahcVarZze);
        }
        int i3 = iZzo + 1;
        return new zzagz(zzahcVarZze, zze(jArr[i3], jArr2[i3]));
    }
}
