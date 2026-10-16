package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzhbj extends zzhcd {
    private final Executor zza;
    final /* synthetic */ zzhbk zzb;

    zzhbj(zzhbk zzhbkVar, Executor executor) {
        Objects.requireNonNull(zzhbkVar);
        this.zzb = zzhbkVar;
        executor.getClass();
        this.zza = executor;
    }

    abstract void zzb(Object obj);

    @Override // com.google.android.gms.internal.ads.zzhcd
    final boolean zzd() {
        return this.zzb.isDone();
    }

    final void zze() {
        try {
            this.zza.execute(this);
        } catch (RejectedExecutionException e3) {
            this.zzb.zzb(e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcd
    final void zzf(Object obj) {
        this.zzb.zzD(null);
        zzb(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzhcd
    final void zzg(Throwable th) {
        zzhbk zzhbkVar = this.zzb;
        zzhbkVar.zzD(null);
        if (th instanceof ExecutionException) {
            zzhbkVar.zzb(((ExecutionException) th).getCause());
        } else if (th instanceof CancellationException) {
            zzhbkVar.cancel(false);
        } else {
            zzhbkVar.zzb(th);
        }
    }
}
