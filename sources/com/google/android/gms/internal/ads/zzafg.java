package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzafg {
    private final long zza;
    private final long zzb;
    private final long zzc;
    private long zzd = 0;
    private long zze;
    private long zzf;
    private long zzg;
    private long zzh;

    protected zzafg(long j3, long j4, long j5, long j6, long j7, long j8, long j9) {
        this.zza = j3;
        this.zzb = j4;
        this.zze = j6;
        this.zzf = j7;
        this.zzg = j8;
        this.zzc = j9;
        this.zzh = zza(j4, 0L, j6, j7, j8, j9);
    }

    protected static long zza(long j3, long j4, long j5, long j6, long j7, long j8) {
        if (j6 + 1 >= j7 || 1 + j4 >= j5) {
            return j6;
        }
        long j9 = (long) ((j3 - j4) * ((j7 - j6) / (j5 - j4)));
        String str = zzfl.zza;
        return Math.max(j6, Math.min(((j6 + j9) - j8) - (j9 / 20), j7 - 1));
    }

    private final void zzi() {
        this.zzh = zza(this.zzb, this.zzd, this.zze, this.zzf, this.zzg, this.zzc);
    }

    final /* synthetic */ long zzb() {
        return this.zzf;
    }

    final /* synthetic */ long zzc() {
        return this.zzg;
    }

    final /* synthetic */ long zzd() {
        return this.zzb;
    }

    final /* synthetic */ long zze() {
        return this.zza;
    }

    final /* synthetic */ void zzf(long j3, long j4) {
        this.zzd = j3;
        this.zzf = j4;
        zzi();
    }

    final /* synthetic */ void zzg(long j3, long j4) {
        this.zze = j3;
        this.zzg = j4;
        zzi();
    }

    final /* synthetic */ long zzh() {
        return this.zzh;
    }
}
