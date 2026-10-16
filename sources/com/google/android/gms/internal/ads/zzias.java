package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.interfaces.RSAPrivateCrtKey;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzias implements zzhej {
    /* synthetic */ zzias(RSAPrivateCrtKey rSAPrivateCrtKey, zziai zziaiVar, zziai zziaiVar2, int i3, byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (zzhks.zza()) {
            throw new GeneralSecurityException("Can not use RSA PSS in FIPS-mode, as BoringCrypto module is not available.");
        }
        zziax.zzb(zziaiVar);
        if (!zziaiVar.equals(zziaiVar2)) {
            throw new GeneralSecurityException("sigHash and mgf1Hash must be the same");
        }
        zziax.zzc(rSAPrivateCrtKey.getModulus().bitLength());
        zziax.zzd(rSAPrivateCrtKey.getPublicExponent());
    }

    @Override // com.google.android.gms.internal.ads.zzhej
    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        throw null;
    }
}
