package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhpn implements zzhoj {
    private zzhpn(zzhob zzhobVar, Provider provider) throws GeneralSecurityException {
        if (!zzhkr.zza(1)) {
            throw new GeneralSecurityException("Cannot use AES-CMAC in FIPS-mode.");
        }
        try {
            Mac.getInstance("AESCMAC", provider);
            zzhobVar.zze().zzc();
            zzhobVar.zzf();
            new SecretKeySpec(zzhobVar.zzd().zzc(zzhdo.zza()), "AES");
        } catch (NoSuchAlgorithmException e3) {
            throw new GeneralSecurityException("AES-CMAC not available.", e3);
        }
    }

    public static zzhoj zza(zzhob zzhobVar, Provider provider) throws GeneralSecurityException {
        return new zzhpn(zzhobVar, provider);
    }
}
