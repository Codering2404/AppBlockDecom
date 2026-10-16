package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.Enum;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zznk<E extends Enum<E>, O> {
    private Map<E, O> zza;
    private Map<O, E> zzb;

    public final zznk<E, O> zza(E e3, O o3) {
        this.zza.put(e3, o3);
        this.zzb.put(o3, e3);
        return this;
    }

    private zznk() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    public final zznl<E, O> zza() {
        return new zznl<>(Collections.unmodifiableMap(this.zza), Collections.unmodifiableMap(this.zzb));
    }
}
