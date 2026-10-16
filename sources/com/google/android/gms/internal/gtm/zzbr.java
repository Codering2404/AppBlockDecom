package com.google.android.gms.internal.gtm;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbr implements Callable {
    final /* synthetic */ zzbs zza;

    zzbr(zzbs zzbsVar) {
        this.zza = zzbsVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        this.zza.zza.zzab();
        return null;
    }
}
