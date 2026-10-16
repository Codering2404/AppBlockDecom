package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaru implements zzahb {
    private final zzarr zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;

    public zzaru(zzarr zzarrVar, int i3, long j3, long j4) {
        this.zza = zzarrVar;
        this.zzb = i3;
        this.zzc = j3;
        long j5 = (j4 - j3) / ((long) zzarrVar.zzd);
        this.zzd = j5;
        this.zze = zze(j5);
    }

    private final long zze(long j3) {
        return zzfl.zzv(j3 * ((long) this.zzb), 1000000L, this.zza.zzc, RoundingMode.DOWN);
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final long zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j3) {
        long j4 = this.zzb;
        zzarr zzarrVar = this.zza;
        long j5 = (((long) zzarrVar.zzc) * j3) / (j4 * 1000000);
        String str = zzfl.zza;
        long j6 = this.zzd - 1;
        long jMax = Math.max(0L, Math.min(j5, j6));
        long j7 = zzarrVar.zzd;
        long jZze = zze(jMax);
        long j8 = this.zzc;
        zzahc zzahcVar = new zzahc(jZze, (jMax * j7) + j8);
        if (jZze >= j3 || jMax == j6) {
            return new zzagz(zzahcVar, zzahcVar);
        }
        long j9 = jMax + 1;
        return new zzagz(zzahcVar, new zzahc(zze(j9), j8 + (j7 * j9)));
    }
}
