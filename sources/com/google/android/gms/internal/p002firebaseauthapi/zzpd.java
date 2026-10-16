package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzqf;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzpd<SerializationT extends zzqf> {
    private final zzaaj zza;
    private final Class<SerializationT> zzb;

    public static <SerializationT extends zzqf> zzpd<SerializationT> zza(zzpf<SerializationT> zzpfVar, zzaaj zzaajVar, Class<SerializationT> cls) {
        return new zzpg(zzaajVar, cls, zzpfVar);
    }

    public abstract zzcb zza(SerializationT serializationt) throws GeneralSecurityException;

    public final Class<SerializationT> zzb() {
        return this.zzb;
    }

    private zzpd(zzaaj zzaajVar, Class<SerializationT> cls) {
        this.zza = zzaajVar;
        this.zzb = cls;
    }

    public final zzaaj zza() {
        return this.zza;
    }
}
