package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhbv {
    private final boolean zza;
    private final zzgwm zzb;

    /* synthetic */ zzhbv(boolean z2, zzgwm zzgwmVar, byte[] bArr) {
        this.zza = z2;
        this.zzb = zzgwmVar;
    }

    public final ListenableFuture zza(Callable callable, Executor executor) {
        return new zzhbk(this.zzb, this.zza, executor, callable);
    }
}
