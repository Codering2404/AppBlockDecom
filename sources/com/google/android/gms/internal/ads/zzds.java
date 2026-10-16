package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzds {
    private boolean zza;

    public zzds() {
        throw null;
    }

    public final synchronized boolean zza() {
        if (this.zza) {
            return false;
        }
        this.zza = true;
        notifyAll();
        return true;
    }

    public final synchronized boolean zzb() {
        boolean z2;
        z2 = this.zza;
        this.zza = false;
        return z2;
    }

    public final synchronized void zzc() throws InterruptedException {
        while (!this.zza) {
            wait();
        }
    }

    public final synchronized void zzd() {
        boolean z2 = false;
        while (!this.zza) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z2 = true;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
    }

    public final synchronized boolean zze(long j3) {
        if (j3 > 0) {
            try {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j4 = j3 + jElapsedRealtime;
                if (j4 < jElapsedRealtime) {
                    zzd();
                } else {
                    boolean z2 = false;
                    while (!this.zza && jElapsedRealtime < j4) {
                        try {
                            wait(j4 - jElapsedRealtime);
                        } catch (InterruptedException unused) {
                            z2 = true;
                        }
                        jElapsedRealtime = SystemClock.elapsedRealtime();
                    }
                    if (z2) {
                        Thread.currentThread().interrupt();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.zza;
    }

    public final synchronized boolean zzf() {
        return this.zza;
    }

    public zzds(zzdo zzdoVar) {
    }
}
