package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzbi;
import com.google.android.gms.internal.p002firebaseauthapi.zzqf;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zznx<KeyT extends zzbi, SerializationT extends zzqf> {
    private final Class<KeyT> zza;
    private final Class<SerializationT> zzb;

    public static <KeyT extends zzbi, SerializationT extends zzqf> zznx<KeyT, SerializationT> zza(zznz<KeyT, SerializationT> zznzVar, Class<KeyT> cls, Class<SerializationT> cls2) {
        return new zznw(cls, cls2, zznzVar);
    }

    public abstract SerializationT zza(KeyT keyt, @Nullable zzch zzchVar) throws GeneralSecurityException;

    public final Class<SerializationT> zzb() {
        return this.zzb;
    }

    private zznx(Class<KeyT> cls, Class<SerializationT> cls2) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final Class<KeyT> zza() {
        return this.zza;
    }
}
