package com.google.android.gms.internal.auth;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgf {
    private static final zzgf zza = new zzgf();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzgj zzb = new zzfp();

    private zzgf() {
    }

    public static zzgf zza() {
        return zza;
    }

    public final zzgi zzb(Class cls) {
        zzfa.zzc(cls, "messageType");
        zzgi zzgiVar = (zzgi) this.zzc.get(cls);
        if (zzgiVar != null) {
            return zzgiVar;
        }
        zzgi zzgiVarZza = this.zzb.zza(cls);
        zzfa.zzc(cls, "messageType");
        zzgi zzgiVar2 = (zzgi) this.zzc.putIfAbsent(cls, zzgiVarZza);
        return zzgiVar2 == null ? zzgiVarZza : zzgiVar2;
    }
}
