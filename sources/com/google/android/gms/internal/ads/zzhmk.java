package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhmk {
    private static final zzhmk zzb = new zzhmk();
    private final Map zza = new HashMap();

    public static zzhmk zza() {
        return zzb;
    }

    public final synchronized void zzb(zzhmj zzhmjVar, Class cls) throws GeneralSecurityException {
        try {
            Map map = this.zza;
            zzhmj zzhmjVar2 = (zzhmj) map.get(cls);
            if (zzhmjVar2 != null && !zzhmjVar2.equals(zzhmjVar)) {
                throw new GeneralSecurityException("Different key creator for parameters class already inserted");
            }
            map.put(cls, zzhmjVar);
        } catch (Throwable th) {
            throw th;
        }
    }
}
