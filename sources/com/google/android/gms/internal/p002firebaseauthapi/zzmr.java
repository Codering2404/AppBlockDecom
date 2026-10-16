package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmr implements zzmf {
    private final zzzi zza;
    private final zzlz zzb;

    private zzmr(zzlz zzlzVar, zzzi zzziVar) {
        this.zzb = zzlzVar;
        this.zza = zzziVar;
    }

    static zzmr zza(zzzi zzziVar) throws GeneralSecurityException {
        int i3 = zzmq.zza[zzziVar.ordinal()];
        if (i3 == 1) {
            return new zzmr(new zzlz("HmacSha256"), zzzi.NIST_P256);
        }
        if (i3 == 2) {
            return new zzmr(new zzlz("HmacSha384"), zzzi.NIST_P384);
        }
        if (i3 == 3) {
            return new zzmr(new zzlz("HmacSha512"), zzzi.NIST_P521);
        }
        throw new GeneralSecurityException("invalid curve type: " + String.valueOf(zzziVar));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmf
    public final byte[] zza(byte[] bArr, zzme zzmeVar) throws GeneralSecurityException {
        ECPrivateKey eCPrivateKeyZza = zzzf.zza(this.zza, zzmeVar.zza().zzb());
        zzzi zzziVar = this.zza;
        byte[] bArrZza = zzzf.zza(eCPrivateKeyZza, zzzf.zza(zzzf.zza(zzziVar), zzzh.UNCOMPRESSED, bArr));
        byte[] bArrZza2 = zzyz.zza(bArr, zzmeVar.zzb().zzb());
        byte[] bArrZza3 = zzmk.zza(zza());
        zzlz zzlzVar = this.zzb;
        return zzlzVar.zza(null, bArrZza, "eae_prk", bArrZza2, "shared_secret", bArrZza3, zzlzVar.zza());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzmf
    public final byte[] zza() throws GeneralSecurityException {
        int i3 = zzmq.zza[this.zza.ordinal()];
        if (i3 == 1) {
            return zzmk.zzc;
        }
        if (i3 == 2) {
            return zzmk.zzd;
        }
        if (i3 == 3) {
            return zzmk.zze;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }
}
