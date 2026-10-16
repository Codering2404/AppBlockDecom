package com.google.android.gms.internal.consent_sdk;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzrx {
    private static final zzrx zza = new zzrx();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzsb zzb = new zzrh();

    private zzrx() {
    }

    static zzrx zza() {
        return zza;
    }

    final zzsa zzb(Class cls) {
        byte[] bArr = zzqs.zzb;
        if (cls == null) {
            throw new NullPointerException("messageType");
        }
        ConcurrentMap concurrentMap = this.zzc;
        zzsa zzsaVarZza = (zzsa) concurrentMap.get(cls);
        if (zzsaVarZza == null) {
            zzsaVarZza = this.zzb.zza(cls);
            zzsa zzsaVar = (zzsa) concurrentMap.putIfAbsent(cls, zzsaVarZza);
            if (zzsaVar != null) {
                return zzsaVar;
            }
        }
        return zzsaVarZza;
    }
}
