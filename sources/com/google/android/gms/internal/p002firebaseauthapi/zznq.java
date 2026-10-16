package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zziv;
import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zznq {
    private static final Logger zza = Logger.getLogger(zznq.class.getName());
    private static final zznq zzb = new zznq();
    private ConcurrentMap<String, zzbh<?>> zzc = new ConcurrentHashMap();
    private ConcurrentMap<String, Boolean> zzd = new ConcurrentHashMap();

    private final synchronized zzbh<?> zzc(String str) throws GeneralSecurityException {
        if (!this.zzc.containsKey(str)) {
            throw new GeneralSecurityException("No key manager found for key type " + str + ", see https://developers.google.com/tink/faq/registration_errors");
        }
        return this.zzc.get(str);
    }

    public final <P> zzbh<P> zza(String str, Class<P> cls) throws GeneralSecurityException {
        zzbh<P> zzbhVar = (zzbh<P>) zzc(str);
        if (zzbhVar.zza().equals(cls)) {
            return zzbhVar;
        }
        throw new GeneralSecurityException("Primitive type " + cls.getName() + " not supported by key manager of type " + String.valueOf(zzbhVar.getClass()) + ", which only supports: " + String.valueOf(zzbhVar.zza()));
    }

    public final boolean zzb(String str) {
        return this.zzd.get(str).booleanValue();
    }

    public final zzbh<?> zza(String str) throws GeneralSecurityException {
        return zzc(str);
    }

    public static zznq zza() {
        return zzb;
    }

    private final synchronized void zza(zzbh<?> zzbhVar, boolean z2, boolean z3) throws GeneralSecurityException {
        try {
            String strZzb = zzbhVar.zzb();
            if (z3 && this.zzd.containsKey(strZzb) && !this.zzd.get(strZzb).booleanValue()) {
                throw new GeneralSecurityException("New keys are already disallowed for key type " + strZzb);
            }
            zzbh<?> zzbhVar2 = this.zzc.get(strZzb);
            if (zzbhVar2 != null && !zzbhVar2.getClass().equals(zzbhVar.getClass())) {
                zza.logp(Level.WARNING, "com.google.crypto.tink.internal.KeyManagerRegistry", "insertKeyManager", "Attempted overwrite of a registered key manager for key type " + strZzb);
                throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", strZzb, zzbhVar2.getClass().getName(), zzbhVar.getClass().getName()));
            }
            this.zzc.putIfAbsent(strZzb, zzbhVar);
            this.zzd.put(strZzb, Boolean.valueOf(z3));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized <P> void zza(zzbh<P> zzbhVar, boolean z2) throws GeneralSecurityException {
        zza(zzbhVar, zziv.zza.zza, z2);
    }

    public final synchronized <P> void zza(zzbh<P> zzbhVar, zziv.zza zzaVar, boolean z2) throws GeneralSecurityException {
        if (zzaVar.zza()) {
            zza((zzbh<?>) zzbhVar, false, z2);
        } else {
            throw new GeneralSecurityException("Cannot register key manager: FIPS compatibility insufficient");
        }
    }
}
