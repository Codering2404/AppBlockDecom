package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgqh {
    private final zzgfh zza;
    private final zzgcn zzb;

    zzgqh(zzgcn zzgcnVar, zzgfh zzgfhVar) {
        this.zza = zzgfhVar;
        this.zzb = zzgcnVar;
    }

    public final zzgqf zza(int i3) {
        return new zzgqf(i3, this.zzb, this.zza);
    }

    public final void zzb(int i3) {
        this.zza.zzb(i3 - 1, -1L, null, null);
    }

    public final void zzc(int i3, String str) {
        this.zza.zzb(i3 - 1, -1L, null, str);
    }

    public final void zzd(int i3, Throwable th) {
        this.zza.zzb(i3 - 1, -1L, th, null);
    }

    public final ListenableFuture zze(int i3, ListenableFuture listenableFuture) {
        zzgqf zzgqfVarZza = zza(i3);
        zzgqfVarZza.zza();
        zzhbw.zzr(listenableFuture, new zzgqg(this, zzgqfVarZza), zzhcn.zza());
        return listenableFuture;
    }

    public final void zzf(int i3, Runnable runnable) {
        try {
            zza(i3).zza();
            runnable.run();
        } finally {
        }
    }
}
