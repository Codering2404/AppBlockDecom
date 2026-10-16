package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfi {
    private long zza;
    private long zzb;
    private long zzc;
    private final ThreadLocal zzd = new ThreadLocal();

    public zzfi(long j3) {
        zzd(0L);
    }

    public static long zzi(long j3) {
        return zzfl.zzv(j3, 1000000L, 90000L, RoundingMode.DOWN);
    }

    public static long zzj(long j3) {
        return zzfl.zzv(j3, 90000L, 1000000L, RoundingMode.DOWN);
    }

    public final synchronized long zza() {
        long j3 = this.zza;
        if (j3 == Long.MAX_VALUE || j3 == 9223372036854775806L) {
            return -9223372036854775807L;
        }
        return j3;
    }

    public final synchronized long zzb() {
        long j3;
        try {
            j3 = this.zzc;
        } catch (Throwable th) {
            throw th;
        }
        return j3 != -9223372036854775807L ? j3 + this.zzb : zza();
    }

    public final synchronized long zzc() {
        return this.zzb;
    }

    public final synchronized void zzd(long j3) {
        this.zza = j3;
        this.zzb = j3 == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.zzc = -9223372036854775807L;
    }

    public final synchronized long zze(long j3) {
        if (j3 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            long j4 = this.zzc;
            if (j4 != -9223372036854775807L) {
                long jZzj = zzj(j4);
                long j5 = (4294967296L + jZzj) / 8589934592L;
                long j6 = (((-1) + j5) * 8589934592L) + j3;
                j3 += j5 * 8589934592L;
                if (Math.abs(j6 - jZzj) < Math.abs(j3 - jZzj)) {
                    j3 = j6;
                }
            }
            return zzg(zzi(j3));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized long zzf(long j3) {
        if (j3 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            long j4 = this.zzc;
            if (j4 != -9223372036854775807L) {
                long jZzj = zzj(j4);
                long j5 = jZzj / 8589934592L;
                long j6 = (j5 * 8589934592L) + j3;
                j3 += (j5 + 1) * 8589934592L;
                if (j6 >= jZzj) {
                    j3 = j6;
                }
            }
            return zzg(zzi(j3));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized long zzg(long j3) {
        if (j3 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            if (!zzh()) {
                long jLongValue = this.zza;
                if (jLongValue == 9223372036854775806L) {
                    Long l3 = (Long) this.zzd.get();
                    if (l3 == null) {
                        throw null;
                    }
                    jLongValue = l3.longValue();
                }
                this.zzb = jLongValue - j3;
                notifyAll();
            }
            this.zzc = j3;
            return j3 + this.zzb;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean zzh() {
        return this.zzb != -9223372036854775807L;
    }
}
