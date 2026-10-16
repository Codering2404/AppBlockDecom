package com.google.android.gms.internal.play_billing;

import androidx.glance.color.Tq.KqqtdetwHMIO;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzde implements Runnable {
    zzdh zza;

    zzde(zzdh zzdhVar) {
        this.zza = zzdhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdc zzdcVar;
        zzdh zzdhVar = this.zza;
        if (zzdhVar == null || (zzdcVar = zzdhVar.zzd) == null) {
            return;
        }
        this.zza = null;
        if (zzdcVar.isDone()) {
            zzdhVar.zzj(zzdcVar);
            return;
        }
        try {
            ScheduledFuture scheduledFuture = zzdhVar.zze;
            zzdhVar.zze = null;
            String str = "Timed out";
            if (scheduledFuture != null) {
                try {
                    long jAbs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                    if (jAbs > 10) {
                        str = "Timed out (timeout delayed by " + jAbs + KqqtdetwHMIO.kNUFqRLjTdB;
                    }
                } catch (Throwable th) {
                    zzdhVar.zzi(new zzdf(str, null));
                    throw th;
                }
            }
            zzdhVar.zzi(new zzdf(str + ": " + zzdcVar.toString(), null));
        } finally {
            zzdcVar.cancel(true);
        }
    }
}
