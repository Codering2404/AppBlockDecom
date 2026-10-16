package com.google.android.gms.tagmanager;

import android.util.LruCache;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcz extends LruCache {
    final /* synthetic */ zzq zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzcz(zzda zzdaVar, int i3, zzq zzqVar) {
        super(1048576);
        this.zza = zzqVar;
    }

    @Override // android.util.LruCache
    protected final int sizeOf(Object obj, Object obj2) {
        return this.zza.zza(obj, obj2);
    }
}
