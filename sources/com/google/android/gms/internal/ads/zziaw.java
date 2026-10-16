package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zziaw {
    public static String zza(zziai zziaiVar) throws GeneralSecurityException {
        zziax.zzb(zziaiVar);
        return zziaiVar.toString().concat("withECDSA");
    }

    public static String zzb(zziai zziaiVar) throws GeneralSecurityException {
        int iOrdinal = zziaiVar.ordinal();
        if (iOrdinal == 0) {
            return "SHA-1";
        }
        if (iOrdinal == 1) {
            return "SHA-224";
        }
        if (iOrdinal == 2) {
            return "SHA-256";
        }
        if (iOrdinal == 3) {
            return "SHA-384";
        }
        if (iOrdinal == 4) {
            return "SHA-512";
        }
        throw new GeneralSecurityException("Unsupported hash ".concat(zziaiVar.toString()));
    }
}
