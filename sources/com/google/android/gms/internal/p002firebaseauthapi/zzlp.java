package com.google.android.gms.internal.p002firebaseauthapi;

import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import com.google.android.gms.internal.p002firebaseauthapi.zzdx;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzlp implements zzlr {
    private final int zza;

    public zzlp(zzdx zzdxVar) throws GeneralSecurityException {
        if (zzdxVar.zzb() != 12) {
            throw new GeneralSecurityException("invalid IV size");
        }
        if (zzdxVar.zzd() != 16) {
            throw new GeneralSecurityException("invalid tag size");
        }
        if (zzdxVar.zzf() != zzdx.zza.zzc) {
            throw new GeneralSecurityException("invalid variant");
        }
        this.zza = zzdxVar.zzc();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlr
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzlr
    public final byte[] zza(byte[] bArr, byte[] bArr2, int i3) throws GeneralSecurityException {
        if (bArr2.length < i3) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (bArr.length != this.zza) {
            throw new GeneralSecurityException(qRMDmh.pHTi);
        }
        SecretKey secretKeyZzb = zzgr.zzb(bArr);
        int i4 = i3 + 12;
        if (bArr2.length < i3 + 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        AlgorithmParameterSpec algorithmParameterSpecZza = zzgr.zza(bArr2, i3, 12);
        Cipher cipherZza = zzgr.zza();
        cipherZza.init(2, secretKeyZzb, algorithmParameterSpecZza);
        return cipherZza.doFinal(bArr2, i4, (bArr2.length - i3) - 12);
    }
}
