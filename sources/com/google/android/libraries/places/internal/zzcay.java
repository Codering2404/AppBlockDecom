package com.google.android.libraries.places.internal;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcay implements zzbzx {
    zzcay() {
    }

    @Override // com.google.android.libraries.places.internal.zzbzx
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        ((ExecutorService) ((Executor) obj)).shutdown();
    }

    @Override // com.google.android.libraries.places.internal.zzbzx
    public final /* bridge */ /* synthetic */ Object zzb() {
        return Executors.newCachedThreadPool(zzbsz.d("grpc-okhttp-%d", true));
    }
}
