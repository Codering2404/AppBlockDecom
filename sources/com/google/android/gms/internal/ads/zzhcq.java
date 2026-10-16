package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhcq implements Runnable {
    zzhcs zza;

    zzhcq(zzhcs zzhcsVar) {
        this.zza = zzhcsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture listenableFutureZzf;
        zzhcs zzhcsVar = this.zza;
        if (zzhcsVar == null || (listenableFutureZzf = zzhcsVar.zzf()) == null) {
            return;
        }
        this.zza = null;
        if (listenableFutureZzf.isDone()) {
            zzhcsVar.zzk(listenableFutureZzf);
            return;
        }
        try {
            ScheduledFuture scheduledFutureZzx = zzhcsVar.zzx();
            zzhcsVar.zzy(null);
            String string = "Timed out";
            if (scheduledFutureZzx != null) {
                try {
                    long jAbs = Math.abs(scheduledFutureZzx.getDelay(TimeUnit.MILLISECONDS));
                    if (jAbs > 10) {
                        StringBuilder sb = new StringBuilder(String.valueOf(jAbs).length() + 55);
                        sb.append("Timed out");
                        sb.append(" (timeout delayed by ");
                        sb.append(jAbs);
                        sb.append(" ms after scheduled time)");
                        string = sb.toString();
                    }
                } catch (Throwable th) {
                    zzhcsVar.zzb(new zzhcr(string, null));
                    throw th;
                }
            }
            String string2 = listenableFutureZzf.toString();
            StringBuilder sb2 = new StringBuilder(string.length() + 2 + string2.length());
            sb2.append(string);
            sb2.append(": ");
            sb2.append(string2);
            zzhcsVar.zzb(new zzhcr(sb2.toString(), null));
        } finally {
            listenableFutureZzf.cancel(true);
        }
    }
}
