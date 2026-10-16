package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzne {
    public static BigInteger zza(byte[] bArr) {
        return new BigInteger(1, bArr);
    }

    public static byte[] zza(BigInteger bigInteger) {
        if (bigInteger.signum() != -1) {
            return bigInteger.toByteArray();
        }
        throw new IllegalArgumentException("n must not be negative");
    }

    public static byte[] zza(BigInteger bigInteger, int i3) throws GeneralSecurityException {
        if (bigInteger.signum() != -1) {
            byte[] byteArray = bigInteger.toByteArray();
            if (byteArray.length == i3) {
                return byteArray;
            }
            int i4 = i3 + 1;
            if (byteArray.length <= i4) {
                if (byteArray.length == i4) {
                    if (byteArray[0] == 0) {
                        return Arrays.copyOfRange(byteArray, 1, byteArray.length);
                    }
                    throw new GeneralSecurityException("integer too large");
                }
                byte[] bArr = new byte[i3];
                System.arraycopy(byteArray, 0, bArr, i3 - byteArray.length, byteArray.length);
                return bArr;
            }
            throw new GeneralSecurityException("integer too large");
        }
        throw new IllegalArgumentException("integer must be nonnegative");
    }
}
