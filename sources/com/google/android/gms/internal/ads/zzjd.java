package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjd {
    private final long zza;
    private final long zzb;
    private long zzc = -9223372036854775807L;
    private long zzd = -9223372036854775807L;
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private float zzj = 0.97f;
    private float zzi = 1.03f;
    private float zzk = 1.0f;
    private long zzl = -9223372036854775807L;
    private long zze = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private long zzm = -9223372036854775807L;
    private long zzn = -9223372036854775807L;

    /* synthetic */ zzjd(float f3, float f4, long j3, float f5, long j4, long j5, float f6, byte[] bArr) {
        this.zza = j4;
        this.zzb = j5;
    }

    private final void zzf() {
        long j3;
        long j4 = this.zzc;
        if (j4 != -9223372036854775807L) {
            j3 = this.zzd;
            if (j3 == -9223372036854775807L) {
                long j5 = this.zzf;
                if (j5 != -9223372036854775807L && j4 < j5) {
                    j4 = j5;
                }
                j3 = this.zzg;
                if (j3 == -9223372036854775807L || j4 <= j3) {
                    j3 = j4;
                }
            }
        } else {
            j3 = -9223372036854775807L;
        }
        if (this.zze == j3) {
            return;
        }
        this.zze = j3;
        this.zzh = j3;
        this.zzm = -9223372036854775807L;
        this.zzn = -9223372036854775807L;
        this.zzl = -9223372036854775807L;
    }

    private static long zzg(long j3, long j4, float f3) {
        return (long) ((j3 * 0.999f) + (j4 * 9.999871E-4f));
    }

    public final void zza(zzaf zzafVar) {
        long j3 = zzafVar.zza;
        this.zzc = zzfl.zzs(-9223372036854775807L);
        this.zzf = zzfl.zzs(-9223372036854775807L);
        this.zzg = zzfl.zzs(-9223372036854775807L);
        this.zzj = 0.97f;
        this.zzi = 1.03f;
        zzf();
    }

    public final void zzb(long j3) {
        this.zzd = j3;
        zzf();
    }

    public final void zzc() {
        long j3 = this.zzh;
        if (j3 == -9223372036854775807L) {
            return;
        }
        long j4 = j3 + this.zzb;
        this.zzh = j4;
        long j5 = this.zzg;
        if (j5 != -9223372036854775807L && j4 > j5) {
            this.zzh = j5;
        }
        this.zzl = -9223372036854775807L;
    }

    public final float zzd(long j3, long j4) {
        long j5;
        if (this.zzc == -9223372036854775807L) {
            return 1.0f;
        }
        long j6 = j3 - j4;
        long j7 = this.zzm;
        if (j7 == -9223372036854775807L) {
            this.zzm = j6;
            this.zzn = 0L;
        } else {
            long jMax = Math.max(j6, zzg(j7, j6, 0.999f));
            this.zzm = jMax;
            this.zzn = zzg(this.zzn, Math.abs(j6 - jMax), 0.999f);
        }
        if (this.zzl != -9223372036854775807L && SystemClock.elapsedRealtime() - this.zzl < 1000) {
            return this.zzk;
        }
        this.zzl = SystemClock.elapsedRealtime();
        long j8 = this.zzm + (this.zzn * 3);
        if (this.zzh > j8) {
            float fZzs = zzfl.zzs(1000L);
            long[] jArr = {j8, this.zze, this.zzh - (((long) ((this.zzk - 1.0f) * fZzs)) + ((long) ((this.zzi - 1.0f) * fZzs)))};
            j5 = jArr[0];
            for (int i3 = 1; i3 < 3; i3++) {
                long j9 = jArr[i3];
                if (j9 > j5) {
                    j5 = j9;
                }
            }
            this.zzh = j5;
        } else {
            long jMax2 = j3 - ((long) (Math.max(0.0f, this.zzk - 1.0f) / 1.0E-7f));
            long j10 = this.zzh;
            String str = zzfl.zza;
            long jMax3 = Math.max(j10, Math.min(jMax2, j8));
            this.zzh = jMax3;
            long j11 = this.zzg;
            if (j11 == -9223372036854775807L || jMax3 <= j11) {
                j5 = jMax3;
            } else {
                this.zzh = j11;
                j5 = j11;
            }
        }
        long j12 = j3 - j5;
        if (Math.abs(j12) < this.zza) {
            this.zzk = 1.0f;
            return 1.0f;
        }
        float fMax = Math.max(this.zzj, Math.min((j12 * 1.0E-7f) + 1.0f, this.zzi));
        this.zzk = fMax;
        return fMax;
    }

    public final long zze() {
        return this.zzh;
    }
}
