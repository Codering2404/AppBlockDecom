package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfoo implements zzbfk {
    private final ScheduledExecutorService zza;
    private final Executor zzb;
    private final Map zzc = new HashMap();
    private boolean zzd = false;

    zzfoo(ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.zza = scheduledExecutorService;
        this.zzb = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final synchronized void zzc() {
        Map map = this.zzc;
        ArrayList arrayList = new ArrayList(map.keySet());
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ScheduledFuture scheduledFuture = (ScheduledFuture) arrayList.get(i3);
            zzfon zzfonVar = (zzfon) map.get(scheduledFuture);
            if (zzfonVar != null && scheduledFuture != null && !scheduledFuture.isDone()) {
                scheduledFuture.cancel(false);
                map.remove(scheduledFuture);
                zzb(zzfonVar.zza, Math.max(0L, zzfonVar.zzb - com.google.android.gms.ads.internal.zzt.o().currentTimeMillis()), TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void zza(boolean z2) {
        if (z2) {
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfom
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzc();
                }
            });
        }
    }

    public final synchronized void zzb(Runnable runnable, long j3, TimeUnit timeUnit) {
        try {
            if (!this.zzd) {
                com.google.android.gms.ads.internal.zzt.k().zzb(this);
                this.zzd = true;
            }
            final zzfon zzfonVar = new zzfon(this, runnable, com.google.android.gms.ads.internal.zzt.o().currentTimeMillis() + timeUnit.toMillis(j3));
            ScheduledFuture<?> scheduledFutureSchedule = this.zza.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfol
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzfon zzfonVar2;
                    zzfon zzfonVar3 = zzfonVar;
                    zzfoo zzfooVar = zzfonVar3.zzd;
                    synchronized (zzfooVar) {
                        try {
                            ScheduledFuture scheduledFuture = zzfonVar3.zzc;
                            zzfonVar2 = scheduledFuture != null ? (zzfon) zzfooVar.zze().remove(scheduledFuture) : null;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (zzfonVar2 != null) {
                        zzfonVar3.zzd.zzd().execute(zzfonVar3.zza);
                    }
                }
            }, j3, timeUnit);
            zzfonVar.zzc = scheduledFutureSchedule;
            this.zzc.put(scheduledFutureSchedule, zzfonVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    final /* synthetic */ Executor zzd() {
        return this.zzb;
    }

    final /* synthetic */ Map zze() {
        return this.zzc;
    }
}
