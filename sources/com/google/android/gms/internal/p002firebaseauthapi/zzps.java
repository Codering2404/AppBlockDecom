package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzbi;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzps<KeyT extends zzbi, PrimitiveT> {
    private final Class<KeyT> zza;
    private final Class<PrimitiveT> zzb;

    public static <KeyT extends zzbi, PrimitiveT> zzps<KeyT, PrimitiveT> zza(zzpu<KeyT, PrimitiveT> zzpuVar, Class<KeyT> cls, Class<PrimitiveT> cls2) {
        return new zzpr(cls, cls2, zzpuVar);
    }

    public abstract PrimitiveT zza(KeyT keyt) throws GeneralSecurityException;

    public final Class<PrimitiveT> zzb() {
        return this.zzb;
    }

    private zzps(Class<KeyT> cls, Class<PrimitiveT> cls2) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final Class<KeyT> zza() {
        return this.zza;
    }
}
