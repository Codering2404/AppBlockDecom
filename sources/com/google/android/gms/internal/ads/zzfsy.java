package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfsy {
    private final zzfsn zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);
    private volatile ScheduledFuture zzc;
    private final zzfub zzd;

    public zzfsy(final zzfsn zzfsnVar, ScheduledExecutorService scheduledExecutorService, long j3, final zzfub zzfubVar) {
        this.zzd = zzfubVar;
        this.zza = zzfsnVar;
        if (j3 > 0) {
            this.zzc = scheduledExecutorService.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfsx
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzb(zzfsnVar, zzfubVar);
                }
            }, j3, TimeUnit.MILLISECONDS);
        }
    }

    public final void zza() {
        if (this.zzb.compareAndSet(false, true)) {
            if (this.zzc != null) {
                this.zzc.cancel(false);
            }
            this.zza.zzc(this.zzd, false);
        }
    }

    final /* synthetic */ void zzb(zzfsn zzfsnVar, zzfub zzfubVar) {
        if (this.zzb.compareAndSet(false, true)) {
            zzfsnVar.zzc(zzfubVar, true);
        }
    }
}
