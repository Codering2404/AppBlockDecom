package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzejd {
    private long zza = 0;
    private int zzb = 0;
    private long zzc = 0;
    private long zzd = 0;
    private long zze = 0;
    private final Object zzf = new Object();
    private final Object zzg = new Object();
    private final Object zzh = new Object();
    private final Object zzi = new Object();
    private final Object zzj = new Object();

    public final synchronized void zza(long j3) {
        synchronized (this.zzf) {
            this.zza = j3;
        }
    }

    public final synchronized long zzb() {
        long j3;
        synchronized (this.zzf) {
            j3 = this.zza;
        }
        return j3;
    }

    public final void zzc(int i3) {
        synchronized (this.zzg) {
            this.zzb = i3;
        }
    }

    public final int zzd() {
        int i3;
        synchronized (this.zzg) {
            i3 = this.zzb;
        }
        return i3;
    }

    public final void zze(long j3) {
        synchronized (this.zzh) {
            this.zzc = j3;
        }
    }

    public final long zzf() {
        long j3;
        synchronized (this.zzh) {
            j3 = this.zzc;
        }
        return j3;
    }

    public final synchronized void zzg(long j3) {
        synchronized (this.zzi) {
            this.zzd = j3;
        }
    }

    public final synchronized long zzh() {
        long j3;
        synchronized (this.zzi) {
            j3 = this.zzd;
        }
        return j3;
    }

    public final synchronized void zzi(long j3) {
        synchronized (this.zzj) {
            this.zze = j3;
        }
    }

    public final synchronized long zzj() {
        long j3;
        synchronized (this.zzj) {
            j3 = this.zze;
        }
        return j3;
    }
}
