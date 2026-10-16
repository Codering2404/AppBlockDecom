package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhbu implements Runnable {
    final Future zza;
    final zzhbt zzb;

    zzhbu(Future future, zzhbt zzhbtVar) {
        this.zza = future;
        this.zzb = zzhbtVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Throwable thZza;
        Future future = this.zza;
        if ((future instanceof zzhcy) && (thZza = zzhcz.zza((zzhcy) future)) != null) {
            this.zzb.zza(thZza);
            return;
        }
        try {
            this.zzb.zzb(zzhbw.zzs(future));
        } catch (ExecutionException e3) {
            this.zzb.zza(e3.getCause());
        } catch (Throwable th) {
            this.zzb.zza(th);
        }
    }

    public final String toString() {
        zzgtf zzgtfVarZzb = zzgtg.zzb(this);
        zzgtfVarZzb.zza(this.zzb);
        return zzgtfVarZzb.toString();
    }
}
