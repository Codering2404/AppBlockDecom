package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzakw implements zzakt {
    private final long zza;
    private final int zzb;
    private final long zzc;
    private final int zzd;
    private final long zze;
    private final long zzf;
    private final long[] zzg;

    private zzakw(long j3, int i3, long j4, int i4, long j5, long[] jArr) {
        this.zza = j3;
        this.zzb = i3;
        this.zzc = j4;
        this.zzd = i4;
        this.zze = j5;
        this.zzg = jArr;
        this.zzf = j5 != -1 ? j3 + j5 : -1L;
    }

    public static zzakw zze(zzakv zzakvVar, long j3) {
        long jZzb = zzakvVar.zzb();
        if (jZzb == -9223372036854775807L) {
            return null;
        }
        zzagv zzagvVar = zzakvVar.zza;
        return new zzakw(j3, zzagvVar.zzc, jZzb, zzagvVar.zzf, zzakvVar.zzc, zzakvVar.zzg);
    }

    private final long zzi(int i3) {
        return (this.zzc * ((long) i3)) / 100;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzb() {
        return this.zzg != null;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j3) {
        if (!zzb()) {
            zzahc zzahcVar = new zzahc(0L, this.zza + ((long) this.zzb));
            return new zzagz(zzahcVar, zzahcVar);
        }
        long j4 = this.zzc;
        String str = zzfl.zza;
        long jMax = Math.max(0L, Math.min(j3, j4));
        double d3 = (jMax * 100.0d) / j4;
        double d4 = 0.0d;
        if (d3 > 0.0d) {
            if (d3 >= 100.0d) {
                d4 = 256.0d;
            } else {
                int i3 = (int) d3;
                long[] jArr = this.zzg;
                jArr.getClass();
                double d5 = jArr[i3];
                d4 = d5 + ((d3 - ((double) i3)) * ((i3 == 99 ? 256.0d : jArr[i3 + 1]) - d5));
            }
        }
        long j5 = this.zze;
        zzahc zzahcVar2 = new zzahc(jMax, this.zza + Math.max(this.zzb, Math.min(Math.round((d4 / 256.0d) * j5), j5 - 1)));
        return new zzagz(zzahcVar2, zzahcVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final long zzf(long j3) {
        if (!zzb()) {
            return 0L;
        }
        long j4 = j3 - this.zza;
        if (j4 <= this.zzb) {
            return 0L;
        }
        long[] jArr = this.zzg;
        jArr.getClass();
        double d3 = (j4 * 256.0d) / this.zze;
        int iZzo = zzfl.zzo(jArr, (long) d3, true, true);
        long jZzi = zzi(iZzo);
        long j5 = jArr[iZzo];
        int i3 = iZzo + 1;
        long jZzi2 = zzi(i3);
        return jZzi + Math.round((j5 == (iZzo == 99 ? 256L : jArr[i3]) ? 0.0d : (d3 - j5) / (r0 - j5)) * (jZzi2 - jZzi));
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final long zzg() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final int zzh() {
        return this.zzd;
    }
}
