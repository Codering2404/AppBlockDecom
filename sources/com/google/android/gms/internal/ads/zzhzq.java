package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhzq implements zzhek {
    public static zzhek zzb(zzhvl zzhvlVar) throws GeneralSecurityException {
        if (!zzhkr.zza(1)) {
            throw new GeneralSecurityException("Can not use Ed25519 in FIPS-mode.");
        }
        try {
            return zzhyc.zzb(zzhvlVar);
        } catch (GeneralSecurityException unused) {
            return new zzhzp(zzhvlVar.zzd().zzc(), zzhvlVar.zze().zzc(), zzhvlVar.zzf().zzc().equals(zzhvd.zzc) ? new byte[]{0} : new byte[0], null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhek
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
