package com.google.android.gms.common.util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MurmurHash3 {
    public static int a(byte[] bArr, int i3, int i4, int i5) {
        int i6;
        int i7 = i3;
        while (true) {
            i6 = (i4 & (-4)) + i3;
            if (i7 >= i6) {
                break;
            }
            int i8 = ((bArr[i7] & 255) | ((bArr[i7 + 1] & 255) << 8) | ((bArr[i7 + 2] & 255) << 16) | (bArr[i7 + 3] << 24)) * (-862048943);
            int i9 = i5 ^ (((i8 >>> 17) | (i8 << 15)) * 461845907);
            i5 = (((i9 >>> 19) | (i9 << 13)) * 5) - 430675100;
            i7 += 4;
        }
        int i10 = i4 & 3;
        if (i10 == 1) {
            int i11 = ((bArr[i6] & 255) | i) * (-862048943);
            i5 ^= ((i11 >>> 17) | (i11 << 15)) * 461845907;
        } else {
            if (i10 != 2) {
                i = i10 == 3 ? (bArr[i6 + 2] & 255) << 16 : 0;
            }
            i |= (bArr[i6 + 1] & 255) << 8;
            int i112 = ((bArr[i6] & 255) | i) * (-862048943);
            i5 ^= ((i112 >>> 17) | (i112 << 15)) * 461845907;
        }
        int i12 = i5 ^ i4;
        int i13 = (i12 ^ (i12 >>> 16)) * (-2048144789);
        int i14 = (i13 ^ (i13 >>> 13)) * (-1028477387);
        return i14 ^ (i14 >>> 16);
    }
}
