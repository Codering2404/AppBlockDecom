package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzmz {
    public static zzba zza(String str) throws GeneralSecurityException {
        return new zznc(str, zza());
    }

    public static boolean zzb(String str) throws GeneralSecurityException {
        return zza().containsAlias(str);
    }

    private static KeyStore zza() throws GeneralSecurityException {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return keyStore;
        } catch (IOException e3) {
            throw new GeneralSecurityException(e3);
        }
    }
}
