package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzacw {
    private long zza;
    private long zzb;
    private long zzc;
    private long zzd;
    private long zze;
    private long zzf;
    private final boolean[] zzg = new boolean[15];
    private int zzh;

    public final void zza() {
        this.zzd = 0L;
        this.zze = 0L;
        this.zzf = 0L;
        this.zzh = 0;
        Arrays.fill(this.zzg, false);
    }

    public final boolean zzb() {
        return this.zzd > 15 && this.zzh == 0;
    }

    public final boolean zzc() {
        long j3 = this.zzd;
        if (j3 == 0) {
            return false;
        }
        return this.zzg[(int) ((j3 - 1) % 15)];
    }

    public final long zzd() {
        return this.zzf;
    }

    public final long zze() {
        long j3 = this.zze;
        if (j3 == 0) {
            return 0L;
        }
        return this.zzf / j3;
    }

    public final void zzf(long j3) {
        long j4 = this.zzd;
        if (j4 == 0) {
            this.zza = j3;
        } else if (j4 == 1) {
            long j5 = j3 - this.zza;
            this.zzb = j5;
            this.zzf = j5;
            this.zze = 1L;
        } else {
            long j6 = j3 - this.zzc;
            int i3 = (int) (j4 % 15);
            if (Math.abs(j6 - this.zzb) <= 1000000) {
                this.zze++;
                this.zzf += j6;
                boolean[] zArr = this.zzg;
                if (zArr[i3]) {
                    zArr[i3] = false;
                    this.zzh--;
                }
            } else {
                boolean[] zArr2 = this.zzg;
                if (!zArr2[i3]) {
                    zArr2[i3] = true;
                    this.zzh++;
                }
            }
        }
        this.zzd++;
        this.zzc = j3;
    }
}
