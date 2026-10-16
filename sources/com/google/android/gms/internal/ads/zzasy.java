package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzasy extends Thread {
    private final BlockingQueue zza;
    private final zzasx zzb;
    private final zzaso zzc;
    private volatile boolean zzd = false;
    private final zzasv zze;

    public zzasy(BlockingQueue blockingQueue, zzasx zzasxVar, zzaso zzasoVar, zzasv zzasvVar) {
        this.zza = blockingQueue;
        this.zzb = zzasxVar;
        this.zzc = zzasoVar;
        this.zze = zzasvVar;
    }

    private void zzb() throws InterruptedException {
        zzate zzateVar = (zzate) this.zza.take();
        SystemClock.elapsedRealtime();
        zzateVar.zze(3);
        try {
            try {
                zzateVar.zzc("network-queue-take");
                zzateVar.zzl();
                TrafficStats.setThreadStatsTag(zzateVar.zzb());
                zzata zzataVarZza = this.zzb.zza(zzateVar);
                zzateVar.zzc("network-http-complete");
                if (zzataVarZza.zze && zzateVar.zzq()) {
                    zzateVar.zzd("not-modified");
                    zzateVar.zzw();
                } else {
                    zzatk zzatkVarZzr = zzateVar.zzr(zzataVarZza);
                    zzateVar.zzc("network-parse-complete");
                    zzasn zzasnVar = zzatkVarZzr.zzb;
                    if (zzasnVar != null) {
                        this.zzc.zzb(zzateVar.zzi(), zzasnVar);
                        zzateVar.zzc("network-cache-written");
                    }
                    zzateVar.zzp();
                    this.zze.zza(zzateVar, zzatkVarZzr, null);
                    zzateVar.zzv(zzatkVarZzr);
                }
            } catch (zzatn e3) {
                SystemClock.elapsedRealtime();
                this.zze.zzb(zzateVar, e3);
                zzateVar.zzw();
            } catch (Exception e4) {
                zzatq.zzd(e4, "Unhandled exception %s", e4.toString());
                zzatn zzatnVar = new zzatn(e4);
                SystemClock.elapsedRealtime();
                this.zze.zzb(zzateVar, zzatnVar);
                zzateVar.zzw();
            }
            zzateVar.zze(4);
        } catch (Throwable th) {
            zzateVar.zze(4);
            throw th;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                zzb();
            } catch (InterruptedException unused) {
                if (this.zzd) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzatq.zzc("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zza() {
        this.zzd = true;
        interrupt();
    }
}
