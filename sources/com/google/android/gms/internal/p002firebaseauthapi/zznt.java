package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzqf;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zznt<SerializationT extends zzqf> {
    private final zzaaj zza;
    private final Class<SerializationT> zzb;

    public static <SerializationT extends zzqf> zznt<SerializationT> zza(zznv<SerializationT> zznvVar, zzaaj zzaajVar, Class<SerializationT> cls) {
        return new zzns(zzaajVar, cls, zznvVar);
    }

    public abstract zzbi zza(SerializationT serializationt, @Nullable zzch zzchVar) throws GeneralSecurityException;

    public final Class<SerializationT> zzb() {
        return this.zzb;
    }

    private zznt(zzaaj zzaajVar, Class<SerializationT> cls) {
        this.zza = zzaajVar;
        this.zzb = cls;
    }

    public final zzaaj zza() {
        return this.zza;
    }
}
