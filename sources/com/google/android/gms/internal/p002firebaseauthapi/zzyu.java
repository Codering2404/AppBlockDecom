package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.p002firebaseauthapi.zziv;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzyu implements zzaaa {
    private static final zziv.zza zza = zziv.zza.zzb;
    private static final ThreadLocal<Cipher> zzb = new zzyt();
    private final SecretKeySpec zzc;
    private final int zzd;
    private final int zze;

    public zzyu(byte[] bArr, int i3) throws GeneralSecurityException {
        if (!zza.zza()) {
            throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzaai.zza(bArr.length);
        this.zzc = new SecretKeySpec(bArr, "AES");
        int blockSize = zzb.get().getBlockSize();
        this.zze = blockSize;
        if (i3 < 12 || i3 > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.zzd = i3;
    }

    private final void zza(byte[] bArr, int i3, int i4, byte[] bArr2, int i5, byte[] bArr3, boolean z2) throws GeneralSecurityException {
        Cipher cipher = zzb.get();
        byte[] bArr4 = new byte[this.zze];
        System.arraycopy(bArr3, 0, bArr4, 0, this.zzd);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr4);
        if (z2) {
            cipher.init(1, this.zzc, ivParameterSpec);
        } else {
            cipher.init(2, this.zzc, ivParameterSpec);
        }
        if (cipher.doFinal(bArr, i3, i4, bArr2, i5) != i4) {
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaaa
    public final byte[] zzb(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i3 = this.zzd;
        if (length > Api.BaseClientBuilder.API_PRIORITY_OTHER - i3) {
            throw new GeneralSecurityException("plaintext length can not exceed " + (Api.BaseClientBuilder.API_PRIORITY_OTHER - this.zzd));
        }
        byte[] bArr2 = new byte[bArr.length + i3];
        byte[] bArrZza = zzqd.zza(i3);
        System.arraycopy(bArrZza, 0, bArr2, 0, this.zzd);
        zza(bArr, 0, bArr.length, bArr2, this.zzd, bArrZza, true);
        return bArr2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaaa
    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i3 = this.zzd;
        if (length >= i3) {
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, 0, bArr2, 0, i3);
            int length2 = bArr.length;
            int i4 = this.zzd;
            byte[] bArr3 = new byte[length2 - i4];
            zza(bArr, i4, bArr.length - i4, bArr3, 0, bArr2, false);
            return bArr3;
        }
        throw new GeneralSecurityException("ciphertext too short");
    }
}
