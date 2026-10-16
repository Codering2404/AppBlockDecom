package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcw implements Runnable {
    final Future zza;
    final zzcv zzb;

    zzcw(Future future, zzcv zzcvVar) {
        this.zza = future;
        this.zzb = zzcvVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Throwable thZza;
        Future future = this.zza;
        if ((future instanceof zzdi) && (thZza = zzdj.zza((zzdi) future)) != null) {
            this.zzb.zza(thZza);
            return;
        }
        try {
            if (!future.isDone()) {
                throw new IllegalStateException(zzbm.zzb("Future was expected to be done: %s", future));
            }
            boolean z2 = false;
            Future future2 = future;
            while (true) {
                try {
                    obj = future2.get();
                    break;
                } catch (InterruptedException unused) {
                    z2 = true;
                    future2 = future2;
                } catch (Throwable th) {
                    if (z2) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
            this.zzb.zzb(obj);
        } catch (ExecutionException e3) {
            this.zzb.zza(e3.getCause());
        } catch (Throwable th2) {
            this.zzb.zza(th2);
        }
    }

    public final String toString() {
        zzbf zzbfVarZza = zzbh.zza(this);
        zzbfVarZza.zza(this.zzb);
        return zzbfVarZza.toString();
    }
}
