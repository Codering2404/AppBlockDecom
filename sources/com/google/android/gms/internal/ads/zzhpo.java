package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhpo implements zzhoj {
    public zzhpo(zzhob zzhobVar) {
    }

    public static zzhoj zza(zzhob zzhobVar) throws GeneralSecurityException {
        if (!zzhkr.zza(1)) {
            throw new GeneralSecurityException("Cannot use AES-CMAC in FIPS-mode.");
        }
        Provider providerZza = zzhkv.zza();
        if (providerZza != null) {
            try {
                return zzhpn.zza(zzhobVar, providerZza);
            } catch (GeneralSecurityException unused) {
            }
        }
        return new zzhpo(zzhobVar);
    }
}
