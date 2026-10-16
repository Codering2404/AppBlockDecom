package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zziv;
import java.security.GeneralSecurityException;
import java.security.Provider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzsh implements zzqw {
    private static final zziv.zza zza = zziv.zza.zza;

    private zzsh(zzqp zzqpVar) {
    }

    public static zzqw zza(zzqp zzqpVar) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Cannot use AES-CMAC in FIPS-mode.");
        }
        Provider providerZza = zznh.zza();
        if (providerZza != null) {
            try {
                return zzse.zza(zzqpVar, providerZza);
            } catch (GeneralSecurityException unused) {
            }
        }
        return new zzsh(zzqpVar);
    }
}
