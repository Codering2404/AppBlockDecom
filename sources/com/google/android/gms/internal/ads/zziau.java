package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zziau implements zzhek {
    private final RSAPublicKey zza;
    private final zziai zzb;
    private final zziai zzc;
    private final int zzd;
    private final byte[] zze;
    private final byte[] zzf;

    /* synthetic */ zziau(RSAPublicKey rSAPublicKey, zziai zziaiVar, zziai zziaiVar2, int i3, byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (zzhks.zza()) {
            throw new GeneralSecurityException("Can not use RSA PSS in FIPS-mode, as BoringCrypto module is not available.");
        }
        zziax.zzb(zziaiVar);
        if (!zziaiVar.equals(zziaiVar2)) {
            throw new GeneralSecurityException("sigHash and mgf1Hash must be the same");
        }
        zziax.zzc(rSAPublicKey.getModulus().bitLength());
        zziax.zzd(rSAPublicKey.getPublicExponent());
        this.zza = rSAPublicKey;
        this.zzb = zziaiVar;
        this.zzc = zziaiVar2;
        this.zzd = i3;
        this.zze = bArr;
        this.zzf = bArr2;
    }

    private final void zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        RSAPublicKey rSAPublicKey = this.zza;
        BigInteger publicExponent = rSAPublicKey.getPublicExponent();
        BigInteger modulus = rSAPublicKey.getModulus();
        int iBitLength = modulus.bitLength() + 7;
        int iBitLength2 = modulus.bitLength() + 6;
        if (iBitLength / 8 != bArr.length) {
            throw new GeneralSecurityException("invalid signature's length");
        }
        BigInteger bigInteger = new BigInteger(1, bArr);
        if (bigInteger.compareTo(modulus) >= 0) {
            throw new GeneralSecurityException("signature out of range");
        }
        byte[] bArrZzb = zzhku.zzb(bigInteger.modPow(publicExponent, modulus), iBitLength2 / 8);
        int iBitLength3 = modulus.bitLength() - 1;
        zziai zziaiVar = this.zzb;
        zziax.zzb(zziaiVar);
        zzhzz zzhzzVar = zzhzz.zzd;
        MessageDigest messageDigest = (MessageDigest) zzhzzVar.zzb(zziaw.zzb(zziaiVar));
        messageDigest.update(bArr2);
        byte[] bArr3 = this.zzf;
        if (bArr3.length != 0) {
            messageDigest.update(bArr3);
        }
        byte[] bArrDigest = messageDigest.digest();
        int digestLength = messageDigest.getDigestLength();
        int length = bArrZzb.length;
        int i3 = this.zzd;
        if (length < digestLength + i3 + 2) {
            throw new GeneralSecurityException("inconsistent");
        }
        if (bArrZzb[length - 1] != -68) {
            throw new GeneralSecurityException("inconsistent");
        }
        int i4 = length - digestLength;
        int i5 = i4 - 1;
        byte[] bArrCopyOf = Arrays.copyOf(bArrZzb, i5);
        int length2 = bArrCopyOf.length;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrZzb, length2, length2 + digestLength);
        int i6 = 0;
        while (true) {
            long j3 = (((long) length) * 8) - ((long) iBitLength3);
            if (i6 < j3) {
                if (((bArrCopyOf[i6 / 8] >> (7 - (i6 % 8))) & 1) != 0) {
                    throw new GeneralSecurityException("inconsistent");
                }
                i6++;
            } else {
                MessageDigest messageDigest2 = (MessageDigest) zzhzzVar.zzb(zziaw.zzb(this.zzc));
                int digestLength2 = messageDigest2.getDigestLength();
                byte[] bArr4 = new byte[i5];
                int i7 = 0;
                int i8 = 0;
                while (i7 <= (i4 - 2) / digestLength2) {
                    messageDigest2.reset();
                    messageDigest2.update(bArrCopyOfRange);
                    int i9 = i3;
                    messageDigest2.update(zzhku.zzb(BigInteger.valueOf(i7), 4));
                    byte[] bArrDigest2 = messageDigest2.digest();
                    int length3 = bArrDigest2.length;
                    System.arraycopy(bArrDigest2, 0, bArr4, i8, Math.min(length3, i5 - i8));
                    i8 += length3;
                    i7++;
                    i3 = i9;
                    messageDigest2 = messageDigest2;
                }
                int i10 = i3;
                byte[] bArr5 = new byte[i5];
                for (int i11 = 0; i11 < i5; i11++) {
                    bArr5[i11] = (byte) (bArr4[i11] ^ bArrCopyOf[i11]);
                }
                for (int i12 = 0; i12 <= j3; i12++) {
                    int i13 = i12 / 8;
                    bArr5[i13] = (byte) ((~(1 << (7 - (i12 % 8)))) & bArr5[i13]);
                }
                int i14 = 0;
                while (true) {
                    int i15 = (i4 - i10) - 2;
                    if (i14 >= i15) {
                        if (bArr5[i15] != 1) {
                            throw new GeneralSecurityException("inconsistent");
                        }
                        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr5, i5 - i10, i5);
                        int i16 = digestLength + 8;
                        byte[] bArr6 = new byte[i16 + i10];
                        System.arraycopy(bArrDigest, 0, bArr6, 8, bArrDigest.length);
                        System.arraycopy(bArrCopyOfRange2, 0, bArr6, i16, bArrCopyOfRange2.length);
                        if (!MessageDigest.isEqual(messageDigest.digest(bArr6), bArrCopyOfRange)) {
                            throw new GeneralSecurityException("inconsistent");
                        }
                        return;
                    }
                    if (bArr5[i14] != 0) {
                        throw new GeneralSecurityException("inconsistent");
                    }
                    i14++;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhek
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zze;
        int length = bArr3.length;
        if (length == 0) {
            zzb(bArr, bArr2);
        } else {
            if (!zzhnz.zze(bArr3, bArr)) {
                throw new GeneralSecurityException("Invalid signature (output prefix mismatch)");
            }
            zzb(Arrays.copyOfRange(bArr, length, bArr.length), bArr2);
        }
    }
}
