package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdi implements zzdr {
    final /* synthetic */ ListenerHolder zza;
    final /* synthetic */ TaskCompletionSource zzb;

    zzdi(zzdz zzdzVar, ListenerHolder listenerHolder, TaskCompletionSource taskCompletionSource) {
        this.zza = listenerHolder;
        this.zzb = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.location.zzdr
    public final ListenerHolder zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.location.zzdr
    public final void zzb(ListenerHolder listenerHolder) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.gms.internal.location.zzdr
    public final void zzc() {
        this.zzb.trySetResult(null);
    }
}
