package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zziv;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzse implements zzqw {
    private static final zziv.zza zza = zziv.zza.zza;

    private zzse(zzqp zzqpVar, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            throw new IllegalArgumentException("conscrypt is null");
        }
        if (!zza.zza()) {
            throw new GeneralSecurityException("Cannot use AES-CMAC in FIPS-mode.");
        }
        try {
            Mac.getInstance("AESCMAC", provider);
            zzqpVar.zze().zzb();
            new SecretKeySpec(zzqpVar.zzf().zza(zzbf.zza()), "AES");
        } catch (NoSuchAlgorithmException e3) {
            throw new GeneralSecurityException("AES-CMAC not available.", e3);
        }
    }

    public static zzqw zza(zzqp zzqpVar, Provider provider) throws GeneralSecurityException {
        return new zzse(zzqpVar, provider);
    }
}
