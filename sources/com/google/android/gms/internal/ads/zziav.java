package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchProviderException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zziav implements zzhek {
    static final zzhli zza;
    private static final byte[] zzb;
    private static final byte[] zzc;

    static {
        zzhlh zzhlhVarZza = zzhli.zza();
        zzhlhVarZza.zza(zziai.SHA256, zzhww.zza);
        zzhlhVarZza.zza(zziai.SHA384, zzhww.zzb);
        zzhlhVarZza.zza(zziai.SHA512, zzhww.zzc);
        zza = zzhlhVarZza.zzb();
        zzb = new byte[0];
        zzc = new byte[]{0};
    }

    public static zzhek zzb(zzhxc zzhxcVar) throws GeneralSecurityException {
        try {
            return zzhyw.zze(zzhxcVar);
        } catch (NoSuchProviderException unused) {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) ((KeyFactory) zzhzz.zzf.zzb("RSA")).generatePublic(new RSAPublicKeySpec(zzhxcVar.zzd(), zzhxcVar.zzf().zzd()));
            zzhwy zzhwyVarZzf = zzhxcVar.zzf();
            zzhli zzhliVar = zza;
            return new zziau(rSAPublicKey, (zziai) zzhliVar.zzb(zzhwyVarZzf.zzf()), (zziai) zzhliVar.zzb(zzhwyVarZzf.zzg()), zzhwyVarZzf.zzh(), zzhxcVar.zze().zzc(), zzhxcVar.zzf().zze().equals(zzhwx.zzc) ? zzc : zzb, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhek
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
