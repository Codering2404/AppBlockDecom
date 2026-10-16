package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzamx {
    private static final zzamx zza = new zzamx();
    private final ConcurrentMap<Class<?>, zzanb<?>> zzc = new ConcurrentHashMap();
    private final zzane zzb = new zzama();

    private zzamx() {
    }

    public static zzamx zza() {
        return zza;
    }

    public final <T> zzanb<T> zza(Class<T> cls) {
        zzalh.zza(cls, "messageType");
        zzanb<T> zzanbVarZza = (zzanb) this.zzc.get(cls);
        if (zzanbVarZza == null) {
            zzanbVarZza = this.zzb.zza(cls);
            zzalh.zza(cls, "messageType");
            zzalh.zza(zzanbVarZza, "schema");
            zzanb<T> zzanbVar = (zzanb) this.zzc.putIfAbsent(cls, zzanbVarZza);
            if (zzanbVar != null) {
                return zzanbVar;
            }
        }
        return zzanbVarZza;
    }

    public final <T> zzanb<T> zza(T t2) {
        return zza((Class) t2.getClass());
    }
}
