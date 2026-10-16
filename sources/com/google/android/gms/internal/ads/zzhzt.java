package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.ECParameterSpec;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhzt {
    public static byte[] zza(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2;
        int i3;
        int length = bArr.length;
        if ((length & 1) != 0 || length == 0 || length > 132) {
            throw new GeneralSecurityException("Invalid IEEE_P1363 encoding");
        }
        int i4 = length >> 1;
        byte[] bArrZzc = zzc(Arrays.copyOf(bArr, i4));
        byte[] bArrZzc2 = zzc(Arrays.copyOfRange(bArr, i4, length));
        int length2 = bArrZzc.length;
        int length3 = bArrZzc2.length;
        int i5 = length2 + 4 + length3;
        if (i5 >= 128) {
            bArr2 = new byte[i5 + 3];
            bArr2[0] = 48;
            bArr2[1] = -127;
            bArr2[2] = (byte) i5;
            i3 = 3;
        } else {
            bArr2 = new byte[i5 + 2];
            bArr2[0] = 48;
            bArr2[1] = (byte) i5;
            i3 = 2;
        }
        int i6 = i3 + 1;
        bArr2[i3] = 2;
        int i7 = i3 + 2;
        bArr2[i6] = (byte) length2;
        System.arraycopy(bArrZzc, 0, bArr2, i7, length2);
        int i8 = i7 + length2;
        bArr2[i8] = 2;
        bArr2[i8 + 1] = (byte) length3;
        System.arraycopy(bArrZzc2, 0, bArr2, i8 + 2, length3);
        return bArr2;
    }

    public static ECParameterSpec zzb(zzhzr zzhzrVar) throws NoSuchAlgorithmException {
        int iOrdinal = zzhzrVar.ordinal();
        if (iOrdinal == 0) {
            return zzhlg.zza;
        }
        if (iOrdinal == 1) {
            return zzhlg.zzb;
        }
        if (iOrdinal == 2) {
            return zzhlg.zzc;
        }
        throw new NoSuchAlgorithmException("curve not implemented:".concat(zzhzrVar.toString()));
    }

    private static byte[] zzc(byte[] bArr) {
        int length;
        int i3 = 0;
        while (true) {
            length = bArr.length;
            if (i3 >= length || bArr[i3] != 0) {
                break;
            }
            i3++;
        }
        if (i3 == length) {
            i3 = length - 1;
        }
        int i4 = (bArr[i3] & 128) == 128 ? 1 : 0;
        int i5 = length - i3;
        byte[] bArr2 = new byte[i5 + i4];
        System.arraycopy(bArr, i3, bArr2, i4, i5);
        return bArr2;
    }
}
