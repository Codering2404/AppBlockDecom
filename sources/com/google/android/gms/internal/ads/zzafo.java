package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzafo implements zzahb {
    private final long zza;
    private final long zzb;
    private final int zzc;
    private final long zzd;
    private final int zze;
    private final long zzf;
    private final boolean zzg;

    protected zzafo(long j3, long j4, int i3, int i4, boolean z2, boolean z3) {
        long jZzf;
        this.zza = j3;
        this.zzb = j4;
        this.zzc = i4 == -1 ? 1 : i4;
        this.zze = i3;
        this.zzg = z3;
        if (j3 == -1) {
            this.zzd = -1L;
            jZzf = -9223372036854775807L;
        } else {
            this.zzd = j3 - j4;
            jZzf = zzf(j3, j4, i3);
        }
        this.zzf = jZzf;
    }

    private static long zzf(long j3, long j4, int i3) {
        return (Math.max(0L, j3 - j4) * 8000000) / ((long) i3);
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final long zza() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzb() {
        return this.zzd != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j3) {
        long j4 = this.zzd;
        if (j4 == -1) {
            zzahc zzahcVar = new zzahc(0L, this.zzb);
            return new zzagz(zzahcVar, zzahcVar);
        }
        long j5 = ((long) this.zze) * j3;
        long j6 = this.zzc;
        long jMin = ((j5 / 8000000) / j6) * j6;
        if (j4 != -1) {
            jMin = Math.min(jMin, j4 - j6);
        }
        long jMax = this.zzb + Math.max(jMin, 0L);
        long jZze = zze(jMax);
        zzahc zzahcVar2 = new zzahc(jZze, jMax);
        if (j4 != -1 && jZze < j3) {
            long j7 = jMax + j6;
            if (j7 < this.zza) {
                return new zzagz(zzahcVar2, new zzahc(zze(j7), j7));
            }
        }
        return new zzagz(zzahcVar2, zzahcVar2);
    }

    public final long zze(long j3) {
        return zzf(j3, this.zzb, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzj() {
        return this.zzg;
    }
}
