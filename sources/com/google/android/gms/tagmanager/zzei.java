package com.google.android.gms.tagmanager;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzei implements zzai {
    private final String zza;
    private final Context zzb;
    private final ScheduledExecutorService zzc;
    private ScheduledFuture zzd;
    private boolean zze;
    private final zzao zzf;
    private String zzg;
    private zzdf zzh;
    private final zzeh zzi;

    private final synchronized void zzd() {
        if (this.zze) {
            throw new IllegalStateException("called method after closed");
        }
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final synchronized void release() {
        try {
            zzd();
            ScheduledFuture scheduledFuture = this.zzd;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.zzc.shutdown();
            this.zze = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.tagmanager.zzai
    public final synchronized void zza(long j3, String str) {
        try {
            zzdg.zzb.zzd("loadAfterDelay: containerId=" + this.zza + " delay=" + j3);
            zzd();
            if (this.zzh == null) {
                throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
            }
            ScheduledFuture scheduledFuture = this.zzd;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            ScheduledExecutorService scheduledExecutorService = this.zzc;
            zzeh zzehVar = this.zzi;
            zzao zzaoVar = this.zzf;
            zzei zzeiVar = zzehVar.zza;
            zzef zzefVar = new zzef(zzeiVar.zzb, zzeiVar.zza, zzaoVar);
            zzefVar.zzb(this.zzh);
            zzefVar.zza(this.zzg);
            zzefVar.zzc(str);
            this.zzd = scheduledExecutorService.schedule(zzefVar, j3, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.tagmanager.zzai
    public final synchronized void zzb(String str) {
        zzd();
        this.zzg = str;
    }
}
