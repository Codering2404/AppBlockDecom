package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcus implements zzbfk {
    private final ScheduledExecutorService zza;
    private final Clock zzb;
    private ScheduledFuture zzc;
    private long zzd = -1;
    private long zze = -1;
    private Runnable zzf = null;
    private boolean zzg = false;

    public zzcus(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        this.zza = scheduledExecutorService;
        this.zzb = clock;
        com.google.android.gms.ads.internal.zzt.k().zzb(this);
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void zza(boolean z2) {
        if (z2) {
            zzd();
        } else {
            zzc();
        }
    }

    public final synchronized void zzb(int i3, Runnable runnable) {
        this.zzf = runnable;
        long j3 = i3;
        this.zzd = this.zzb.a() + j3;
        this.zzc = this.zza.schedule(runnable, j3, TimeUnit.MILLISECONDS);
    }

    final synchronized void zzc() {
        try {
            if (this.zzg) {
                return;
            }
            ScheduledFuture scheduledFuture = this.zzc;
            if (scheduledFuture == null || scheduledFuture.isDone()) {
                this.zze = -1L;
            } else {
                this.zzc.cancel(true);
                this.zze = this.zzd - this.zzb.a();
            }
            this.zzg = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    final synchronized void zzd() {
        ScheduledFuture scheduledFuture;
        try {
            if (this.zzg) {
                if (this.zze > 0 && (scheduledFuture = this.zzc) != null && scheduledFuture.isCancelled()) {
                    this.zzc = this.zza.schedule(this.zzf, this.zze, TimeUnit.MILLISECONDS);
                }
                this.zzg = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
