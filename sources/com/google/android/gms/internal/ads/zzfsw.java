package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfsw {
    private final long zza;
    private final long zzb;
    private final Clock zzf;
    private long zzg;
    private long zzd = 5;
    private long zze = 0;
    private final Random zzh = new Random();
    private long zzc = 0;

    public zzfsw(long j3, double d3, long j4, double d4, Clock clock) {
        this.zza = j3;
        this.zzb = j4;
        this.zzf = clock;
        zza();
    }

    public final synchronized void zza() {
        this.zzg = this.zza;
        this.zzc = 0L;
        this.zze = 0L;
    }

    public final synchronized long zzb() {
        double d3;
        double d4;
        long j3;
        d3 = this.zzg;
        d4 = 0.2d * d3;
        j3 = (long) (d3 + d4);
        return ((long) (d3 - d4)) + ((long) (this.zzh.nextDouble() * ((j3 - r0) + 1)));
    }

    public final synchronized void zzc() {
        this.zze = this.zzf.currentTimeMillis() + zzb();
        double d3 = this.zzg;
        this.zzg = Math.min((long) (d3 + d3), this.zzb);
        this.zzc++;
    }

    public final synchronized boolean zzd() {
        return this.zzf.currentTimeMillis() < this.zze;
    }

    public final synchronized boolean zze() {
        if (((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzI)).intValue() < 0) {
            return false;
        }
        if (this.zzc > Math.max(this.zzd, ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(r0)).intValue())) {
            if (this.zzg >= this.zzb) {
                return true;
            }
        }
        return false;
    }

    public final synchronized void zzf(int i3) {
        Preconditions.a(i3 > 0);
        this.zzd = i3;
    }
}
