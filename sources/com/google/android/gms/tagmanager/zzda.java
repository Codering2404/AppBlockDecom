package com.google.android.gms.tagmanager;

import android.util.LruCache;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzda {
    private final LruCache zza;

    zzda(int i3, zzq zzqVar) {
        this.zza = new zzcz(this, 1048576, zzqVar);
    }

    public final Object zza(Object obj) {
        return this.zza.get(obj);
    }

    public final void zzb(Object obj, Object obj2) {
        this.zza.put(obj, obj2);
    }
}
