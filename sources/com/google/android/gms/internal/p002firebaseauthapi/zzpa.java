package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzpa {
    private static zzpa zza = new zzpa();
    private final AtomicReference<zzpw> zzb = new AtomicReference<>(zzpw.zza().zza());

    zzpa() {
    }

    public static zzpa zza() {
        return zza;
    }

    public final <KeyT extends zzbi, PrimitiveT> PrimitiveT zza(KeyT keyt, Class<PrimitiveT> cls) throws GeneralSecurityException {
        return (PrimitiveT) this.zzb.get().zza(keyt, cls);
    }

    public final synchronized <KeyT extends zzbi, PrimitiveT> void zza(zzps<KeyT, PrimitiveT> zzpsVar) throws GeneralSecurityException {
        this.zzb.set(zzpw.zza(this.zzb.get()).zza(zzpsVar).zza());
    }

    public final synchronized <InputPrimitiveT, WrapperPrimitiveT> void zza(zzpz<InputPrimitiveT, WrapperPrimitiveT> zzpzVar) throws GeneralSecurityException {
        this.zzb.set(zzpw.zza(this.zzb.get()).zza(zzpzVar).zza());
    }
}
