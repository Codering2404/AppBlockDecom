package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzflx {
    private final Deque zza = new LinkedBlockingDeque();
    private final Callable zzb;
    private final zzhcg zzc;

    public zzflx(Callable callable, zzhcg zzhcgVar) {
        this.zzb = callable;
        this.zzc = zzhcgVar;
    }

    public final synchronized void zza(int i3) {
        Deque deque = this.zza;
        int size = i3 - deque.size();
        for (int i4 = 0; i4 < size; i4++) {
            deque.add(this.zzc.submit(this.zzb));
        }
    }

    public final synchronized ListenableFuture zzb() {
        zza(1);
        return (ListenableFuture) this.zza.poll();
    }

    public final synchronized void zzc(ListenableFuture listenableFuture) {
        this.zza.addFirst(listenableFuture);
    }
}
