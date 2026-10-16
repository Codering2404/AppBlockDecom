package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhqh implements zzhqd {
    private static final ThreadLocal zzd = new zzhqg();
    private final SecretKey zza;
    private final byte[] zzb;
    private final byte[] zzc;

    private zzhqh(byte[] bArr) throws GeneralSecurityException {
        zziax.zza(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.zza = secretKeySpec;
        Cipher cipherZzc = zzc();
        cipherZzc.init(1, secretKeySpec);
        byte[] bArrZza = zzhpm.zza(cipherZzc.doFinal(new byte[16]));
        this.zzb = bArrZza;
        this.zzc = zzhpm.zza(bArrZza);
    }

    public static zzhqd zzb(zzhqb zzhqbVar) throws GeneralSecurityException {
        return new zzhqh(zzhqbVar.zzd().zzc(zzhdo.zza()));
    }

    private static Cipher zzc() throws GeneralSecurityException {
        if (zzhkr.zza(1)) {
            return (Cipher) zzd.get();
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    private static void zzd(byte[] bArr, byte[] bArr2, int i3, byte[] bArr3) {
        for (int i4 = 0; i4 < 16; i4++) {
            bArr3[i4] = (byte) (bArr[i4] ^ bArr2[i4 + i3]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhqd
    public final byte[] zza(byte[] bArr, int i3) throws GeneralSecurityException {
        byte[] bArrZzb;
        if (i3 > 16) {
            throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        }
        SecretKey secretKey = this.zza;
        Cipher cipherZzc = zzc();
        cipherZzc.init(1, secretKey);
        int length = bArr.length;
        int i4 = length != 0 ? 1 + ((length - 1) >> 4) : 1;
        int i5 = i4 - 1;
        int i6 = i5 * 16;
        if (i4 * 16 == length) {
            bArrZzb = zzhzl.zzb(bArr, i6, this.zzb, 0, 16);
        } else {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i6, length);
            int length2 = bArrCopyOfRange.length;
            if (length2 >= 16) {
                throw new IllegalArgumentException("x must be smaller than a block.");
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArrCopyOfRange, 16);
            bArrCopyOf[length2] = -128;
            byte[] bArr2 = this.zzc;
            if (bArrCopyOf.length != 16) {
                throw new IllegalArgumentException("The lengths of x and y should match.");
            }
            bArrZzb = zzhzl.zzb(bArrCopyOf, 0, bArr2, 0, 16);
        }
        byte[] bArr3 = new byte[16];
        byte[] bArr4 = new byte[16];
        for (int i7 = 0; i7 < i5; i7++) {
            zzd(bArr3, bArr, i7 * 16, bArr4);
            if (cipherZzc.doFinal(bArr4, 0, 16, bArr3) != 16) {
                throw new IllegalStateException("Cipher didn't write full block");
            }
        }
        zzd(bArr3, bArrZzb, 0, bArr4);
        if (cipherZzc.doFinal(bArr4, 0, 16, bArr3) == 16) {
            return i3 == 16 ? bArr3 : Arrays.copyOf(bArr3, i3);
        }
        throw new IllegalStateException("Cipher didn't write full block");
    }
}
