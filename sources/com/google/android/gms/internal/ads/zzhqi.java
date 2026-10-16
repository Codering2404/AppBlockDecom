package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.Provider;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhqi implements zzhqd {
    private final Key zza;
    private final Provider zzb;

    private zzhqi(byte[] bArr, Provider provider) throws GeneralSecurityException {
        if (!zzhkr.zza(1)) {
            throw new GeneralSecurityException("Cannot use AES-CMAC in FIPS-mode, as BoringCrypto module is not available");
        }
        this.zza = new SecretKeySpec(bArr, "AES");
        this.zzb = provider;
    }

    public static zzhqd zzb(zzhqb zzhqbVar) throws GeneralSecurityException {
        Provider providerZza = zzhkv.zza();
        if (providerZza == null) {
            throw new GeneralSecurityException("Conscrypt not available");
        }
        Mac.getInstance("AESCMAC", providerZza);
        return new zzhqi(zzhqbVar.zzd().zzc(zzhdo.zza()), providerZza);
    }

    @Override // com.google.android.gms.internal.ads.zzhqd
    public final byte[] zza(byte[] bArr, int i3) throws GeneralSecurityException {
        if (i3 > 16) {
            throw new InvalidAlgorithmParameterException("outputLength must not be larger than 16");
        }
        Provider provider = this.zzb;
        Key key = this.zza;
        Mac mac = Mac.getInstance("AESCMAC", provider);
        mac.init(key);
        byte[] bArrDoFinal = mac.doFinal(bArr);
        return i3 == bArrDoFinal.length ? bArrDoFinal : Arrays.copyOf(bArrDoFinal, i3);
    }
}
