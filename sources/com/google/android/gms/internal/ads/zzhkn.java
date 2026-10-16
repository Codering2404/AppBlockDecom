package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhkn implements zzhdi {
    private static final ThreadLocal zza = new zzhkl();

    public static zzhdi zzb(zzhfz zzhfzVar) throws GeneralSecurityException {
        return zzhjb.zzc(zzhfzVar, zzhkm.zza);
    }

    static /* synthetic */ Cipher zzc() throws GeneralSecurityException {
        try {
            Cipher cipher = (Cipher) zza.get();
            if (cipher != null) {
                return cipher;
            }
            throw new GeneralSecurityException("AES GCM SIV cipher is invalid.");
        } catch (IllegalStateException e3) {
            throw new GeneralSecurityException("AES GCM SIV cipher is not available or is invalid.", e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhdi
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
