package com.google.android.gms.internal.ads;

import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zziaq implements zzhek {
    private final RSAPublicKey zza;
    private final zziai zzb;
    private final byte[] zzc;
    private final byte[] zzd;

    /* synthetic */ zziaq(RSAPublicKey rSAPublicKey, zziai zziaiVar, byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (zzhks.zza()) {
            throw new GeneralSecurityException("Conscrypt is not available, and we cannot use Java Implementation of RSA-PKCS1.5 in FIPS-mode.");
        }
        zziax.zzb(zziaiVar);
        zziax.zzc(rSAPublicKey.getModulus().bitLength());
        zziax.zzd(rSAPublicKey.getPublicExponent());
        this.zza = rSAPublicKey;
        this.zzb = zziaiVar;
        this.zzc = bArr;
        this.zzd = bArr2;
    }

    @Override // com.google.android.gms.internal.ads.zzhek
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzc;
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

    private final void zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArrZza;
        int i3;
        RSAPublicKey rSAPublicKey = this.zza;
        BigInteger publicExponent = rSAPublicKey.getPublicExponent();
        BigInteger modulus = rSAPublicKey.getModulus();
        int iBitLength = (modulus.bitLength() + 7) / 8;
        if (iBitLength != bArr.length) {
            throw new GeneralSecurityException("invalid signature's length");
        }
        BigInteger bigInteger = new BigInteger(1, bArr);
        if (bigInteger.compareTo(modulus) >= 0) {
            throw new GeneralSecurityException("signature out of range");
        }
        byte[] bArrZzb = zzhku.zzb(bigInteger.modPow(publicExponent, modulus), iBitLength);
        zziai zziaiVar = this.zzb;
        zziax.zzb(zziaiVar);
        MessageDigest messageDigest = (MessageDigest) zzhzz.zzd.zzb(zziaw.zzb(zziaiVar));
        messageDigest.update(bArr2);
        byte[] bArr3 = this.zzd;
        if (bArr3.length != 0) {
            messageDigest.update(bArr3);
        }
        byte[] bArrDigest = messageDigest.digest();
        int iOrdinal = zziaiVar.ordinal();
        int i4 = 2;
        if (iOrdinal == 2) {
            bArrZza = zziaj.zza("3031300d060960864801650304020105000420");
        } else if (iOrdinal == 3) {
            bArrZza = zziaj.zza("3041300d060960864801650304020205000430");
        } else {
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("Unsupported hash ".concat(zziaiVar.toString()));
            }
            bArrZza = zziaj.zza("3051300d060960864801650304020305000440");
        }
        if (iBitLength < bArrZza.length + bArrDigest.length + 11) {
            throw new GeneralSecurityException("intended encoded message length too short");
        }
        byte[] bArr4 = new byte[iBitLength];
        bArr4[0] = 0;
        bArr4[1] = 1;
        int i5 = 0;
        while (true) {
            i3 = i4 + 1;
            if (i5 >= (iBitLength - r5) - 3) {
                break;
            }
            bArr4[i4] = -1;
            i5++;
            i4 = i3;
        }
        bArr4[i4] = 0;
        int length = bArrZza.length;
        System.arraycopy(bArrZza, 0, bArr4, i3, length);
        System.arraycopy(bArrDigest, 0, bArr4, i3 + length, bArrDigest.length);
        if (!MessageDigest.isEqual(bArrZzb, bArr4)) {
            throw new GeneralSecurityException(jTYhJgqLBN.iMj);
        }
    }
}
