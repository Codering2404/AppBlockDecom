package com.google.android.gms.internal.gtm;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzzp {
    private static final zzzp zza = new zzzp();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzzu zzb = new zzyy();

    private zzzp() {
    }

    public static zzzp zza() {
        return zza;
    }

    public final zzzt zzb(Class cls) {
        zzye.zzc(cls, "messageType");
        zzzt zzztVar = (zzzt) this.zzc.get(cls);
        if (zzztVar != null) {
            return zzztVar;
        }
        zzzt zzztVarZza = this.zzb.zza(cls);
        zzye.zzc(cls, "messageType");
        zzzt zzztVar2 = (zzzt) this.zzc.putIfAbsent(cls, zzztVarZza);
        return zzztVar2 == null ? zzztVarZza : zzztVar2;
    }
}
