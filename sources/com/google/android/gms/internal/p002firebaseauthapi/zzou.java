package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzou {
    private static final zzou zza = new zzou();
    private final Map<Class<? extends zzcb>, zzot<? extends zzcb>> zzb = new HashMap();

    public static zzou zza() {
        return zza;
    }

    public final synchronized <ParametersT extends zzcb> void zza(zzot<ParametersT> zzotVar, Class<ParametersT> cls) throws GeneralSecurityException {
        try {
            zzot<? extends zzcb> zzotVar2 = this.zzb.get(cls);
            if (zzotVar2 != null && !zzotVar2.equals(zzotVar)) {
                throw new GeneralSecurityException("Different key creator for parameters class already inserted");
            }
            this.zzb.put(cls, zzotVar);
        } catch (Throwable th) {
            throw th;
        }
    }
}
