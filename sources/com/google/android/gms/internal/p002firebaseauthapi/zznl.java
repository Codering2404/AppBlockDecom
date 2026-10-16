package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.Enum;
import java.security.GeneralSecurityException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zznl<E extends Enum<E>, O> {
    private final Map<E, O> zza;
    private final Map<O, E> zzb;

    public static <E extends Enum<E>, O> zznk<E, O> zza() {
        return new zznk<>();
    }

    private zznl(Map<E, O> map, Map<O, E> map2) {
        this.zza = map;
        this.zzb = map2;
    }

    public final E zza(O o3) throws GeneralSecurityException {
        E e3 = this.zzb.get(o3);
        if (e3 != null) {
            return e3;
        }
        throw new GeneralSecurityException("Unable to convert object enum: " + String.valueOf(o3));
    }

    public final O zza(E e3) throws GeneralSecurityException {
        O o3 = this.zza.get(e3);
        if (o3 != null) {
            return o3;
        }
        throw new GeneralSecurityException("Unable to convert proto enum: " + String.valueOf(e3));
    }
}
