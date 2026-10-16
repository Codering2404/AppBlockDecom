package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzifz {
    private static final zzifz zza = new zzifz();
    private final ConcurrentHashMap zzc = new ConcurrentHashMap();
    private final zzifg zzb = new zzifg();

    private zzifz() {
    }

    static zzifz zza() {
        return zza;
    }

    private <T> zzigh<T> zzc(Class<T> cls) {
        ConcurrentHashMap concurrentHashMap = this.zzc;
        zzigh<T> zzighVarZza = this.zzb.zza(cls);
        zzigh<T> zzighVar = (zzigh) concurrentHashMap.putIfAbsent(cls, zzighVarZza);
        return zzighVar != null ? zzighVar : zzighVarZza;
    }

    final zzigh zzb(Class cls) {
        Object obj = this.zzc.get(cls);
        return obj == null ? zzc(cls) : (zzigh) obj;
    }
}
