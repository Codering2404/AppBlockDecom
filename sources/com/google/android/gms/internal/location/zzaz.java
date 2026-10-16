package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaz implements zzdr {
    private ListenerHolder zza;

    zzaz(ListenerHolder listenerHolder) {
        this.zza = listenerHolder;
    }

    @Override // com.google.android.gms.internal.location.zzdr
    public final synchronized ListenerHolder zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.location.zzdr
    public final synchronized void zzb(ListenerHolder listenerHolder) {
        ListenerHolder listenerHolder2 = this.zza;
        if (listenerHolder2 != listenerHolder) {
            listenerHolder2.a();
            this.zza = listenerHolder;
        }
    }

    @Override // com.google.android.gms.internal.location.zzdr
    public final void zzc() {
    }
}
