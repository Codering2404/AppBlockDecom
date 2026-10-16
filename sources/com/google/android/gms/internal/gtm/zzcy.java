package com.google.android.gms.internal.gtm;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzcy {
    private static volatile Handler zza;
    private final zzbx zzb;
    private final Runnable zzc;
    private volatile long zzd;

    zzcy(zzbx zzbxVar) {
        Preconditions.m(zzbxVar);
        this.zzb = zzbxVar;
        this.zzc = new zzcx(this);
    }

    private final Handler zzi() {
        Handler handler;
        if (zza != null) {
            return zza;
        }
        synchronized (zzcy.class) {
            try {
                if (zza == null) {
                    zza = new zzgc(this.zzb.zza().getMainLooper());
                }
                handler = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public abstract void zza();

    public final long zzb() {
        if (this.zzd == 0) {
            return 0L;
        }
        return Math.abs(this.zzb.zzr().currentTimeMillis() - this.zzd);
    }

    public final void zze(long j3) {
        if (zzh()) {
            if (j3 < 0) {
                zzf();
                return;
            }
            long jAbs = j3 - Math.abs(this.zzb.zzr().currentTimeMillis() - this.zzd);
            long j4 = jAbs >= 0 ? jAbs : 0L;
            zzi().removeCallbacks(this.zzc);
            if (zzi().postDelayed(this.zzc, j4)) {
                return;
            }
            this.zzb.zzm().zzJ("Failed to adjust delayed post. time", Long.valueOf(j4));
        }
    }

    public final void zzf() {
        this.zzd = 0L;
        zzi().removeCallbacks(this.zzc);
    }

    public final void zzg(long j3) {
        zzf();
        if (j3 >= 0) {
            this.zzd = this.zzb.zzr().currentTimeMillis();
            if (zzi().postDelayed(this.zzc, j3)) {
                return;
            }
            this.zzb.zzm().zzJ("Failed to schedule delayed post. time", Long.valueOf(j3));
        }
    }

    public final boolean zzh() {
        return this.zzd != 0;
    }
}
