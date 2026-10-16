package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzpy {
    private final Map<zzpx, zzps<?, ?>> zza;
    private final Map<Class<?>, zzpz<?, ?>> zzb;

    public final <KeyT extends zzbi, PrimitiveT> zzpy zza(zzps<KeyT, PrimitiveT> zzpsVar) throws GeneralSecurityException {
        if (zzpsVar == null) {
            throw new NullPointerException("primitive constructor must be non-null");
        }
        zzpx zzpxVar = new zzpx(zzpsVar.zza(), zzpsVar.zzb());
        if (!this.zza.containsKey(zzpxVar)) {
            this.zza.put(zzpxVar, zzpsVar);
            return this;
        }
        zzps<?, ?> zzpsVar2 = this.zza.get(zzpxVar);
        if (zzpsVar2.equals(zzpsVar) && zzpsVar.equals(zzpsVar2)) {
            return this;
        }
        throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: " + String.valueOf(zzpxVar));
    }

    private zzpy() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    private zzpy(zzpw zzpwVar) {
        this.zza = new HashMap(zzpwVar.zza);
        this.zzb = new HashMap(zzpwVar.zzb);
    }

    public final <InputPrimitiveT, WrapperPrimitiveT> zzpy zza(zzpz<InputPrimitiveT, WrapperPrimitiveT> zzpzVar) throws GeneralSecurityException {
        if (zzpzVar != null) {
            Class<WrapperPrimitiveT> clsZzb = zzpzVar.zzb();
            if (this.zzb.containsKey(clsZzb)) {
                zzpz<?, ?> zzpzVar2 = this.zzb.get(clsZzb);
                if (zzpzVar2.equals(zzpzVar) && zzpzVar.equals(zzpzVar2)) {
                    return this;
                }
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type" + String.valueOf(clsZzb));
            }
            this.zzb.put(clsZzb, zzpzVar);
            return this;
        }
        throw new NullPointerException("wrapper must be non-null");
    }

    public final zzpw zza() {
        return new zzpw(this);
    }
}
