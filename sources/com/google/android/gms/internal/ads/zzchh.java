package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzchh {
    private long zzb;
    private final long zza = TimeUnit.MILLISECONDS.toNanos(((Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzar)).longValue());
    private boolean zzc = true;

    zzchh() {
    }

    public final void zza() {
        this.zzc = true;
    }

    public final void zzb(SurfaceTexture surfaceTexture, final zzcgs zzcgsVar) {
        if (zzcgsVar == null) {
            return;
        }
        long timestamp = surfaceTexture.getTimestamp();
        if (!this.zzc) {
            long j3 = timestamp - this.zzb;
            if (Math.abs(j3) < this.zza) {
                return;
            }
        }
        this.zzc = false;
        this.zzb = timestamp;
        com.google.android.gms.ads.internal.util.zzs.f70374l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzchg
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzcgsVar.zzi();
            }
        });
    }
}
