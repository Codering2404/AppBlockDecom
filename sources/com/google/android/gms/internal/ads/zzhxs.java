package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECPrivateKeySpec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhxs implements zzhej {
    private static final byte[] zza = new byte[0];
    private static final byte[] zzb = {0};

    private zzhxs(ECPrivateKey eCPrivateKey, zziai zziaiVar, zzhzs zzhzsVar, byte[] bArr, byte[] bArr2, Provider provider) throws GeneralSecurityException {
        if (!zzhkr.zza(2)) {
            throw new GeneralSecurityException("Can not use ECDSA in FIPS-mode, as BoringCrypto is not available.");
        }
        zziaw.zza(zziaiVar);
    }

    public static zzhej zzb(zzhuw zzhuwVar) throws GeneralSecurityException {
        Provider providerZza = zzhkv.zza();
        return new zzhxs((ECPrivateKey) (providerZza != null ? KeyFactory.getInstance("EC", providerZza) : (KeyFactory) zzhzz.zzf.zzb("EC")).generatePrivate(new ECPrivateKeySpec(zzhuwVar.zzf().zzb(zzhdo.zza()), zzhzt.zzb((zzhzr) zzhxt.zzc.zzb(zzhuwVar.zzd().zzd())))), (zziai) zzhxt.zza.zzb(zzhuwVar.zzd().zze()), (zzhzs) zzhxt.zzb.zzb(zzhuwVar.zzd().zzc()), zzhuwVar.zze().zze().zzc(), zzhuwVar.zzd().zzf().equals(zzhut.zzc) ? zzb : zza, providerZza);
    }

    @Override // com.google.android.gms.internal.ads.zzhej
    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        throw null;
    }
}
