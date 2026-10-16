package com.appsflyer.internal;

import com.applovin.exoplayer2.common.base.Ascii;
import com.sun.jna.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFg1uSDK {
    private static byte[] afInfoLog = new byte[Function.MAX_NARGS];
    static final byte[] AFInAppEventParameterName = new byte[Function.MAX_NARGS];
    static final int[] AFKeystoreWrapper = new int[Function.MAX_NARGS];
    static final int[] valueOf = new int[Function.MAX_NARGS];
    static final int[] AFInAppEventType = new int[Function.MAX_NARGS];
    static final int[] values = new int[Function.MAX_NARGS];
    private static int[] AFLogger = new int[10];

    static {
        byte[] bArr;
        int i3;
        byte b3 = 1;
        byte b4 = 1;
        do {
            b3 = (byte) (((b3 & 128) != 0 ? 27 : 0) ^ ((b3 << 1) ^ b3));
            byte b5 = (byte) (b4 ^ (b4 << 1));
            byte b6 = (byte) (b5 ^ (b5 << 2));
            byte b7 = (byte) (b6 ^ (b6 << 4));
            b4 = (byte) (b7 ^ ((b7 & 128) != 0 ? (byte) 9 : (byte) 0));
            bArr = afInfoLog;
            i3 = b3 & 255;
            int i4 = b4 & 255;
            bArr[i3] = (byte) (((((b4 ^ 99) ^ ((i4 << 1) | (i4 >> 7))) ^ ((i4 << 2) | (i4 >> 6))) ^ ((i4 << 3) | (i4 >> 5))) ^ ((i4 >> 4) | (i4 << 4)));
        } while (i3 != 1);
        bArr[0] = 99;
        for (int i5 = 0; i5 < 256; i5++) {
            int i6 = afInfoLog[i5] & 255;
            AFInAppEventParameterName[i6] = (byte) i5;
            int i7 = i5 << 1;
            if (i7 >= 256) {
                i7 ^= 283;
            }
            int i8 = i7 << 1;
            if (i8 >= 256) {
                i8 ^= 283;
            }
            int i9 = i8 << 1;
            if (i9 >= 256) {
                i9 ^= 283;
            }
            int i10 = i9 ^ i5;
            int i11 = ((i7 ^ (i8 ^ i9)) << 24) | (i10 << 16) | ((i10 ^ i8) << 8) | (i10 ^ i7);
            AFKeystoreWrapper[i6] = i11;
            valueOf[i6] = (i11 >>> 8) | (i11 << 24);
            AFInAppEventType[i6] = (i11 >>> 16) | (i11 << 16);
            values[i6] = (i11 << 8) | (i11 >>> 24);
        }
        AFLogger[0] = 16777216;
        int i12 = 1;
        for (int i13 = 1; i13 < 10; i13++) {
            i12 <<= 1;
            if (i12 >= 256) {
                i12 ^= 283;
            }
            AFLogger[i13] = i12 << 24;
        }
    }

    public static byte[][] AFInAppEventParameterName(int i3) {
        byte[][] bArr = new byte[4][];
        for (int i4 = 0; i4 < 4; i4++) {
            int i5 = i3 >>> (i4 << 3);
            bArr[i4] = new byte[]{(byte) (i5 & 3), (byte) ((i5 >> 2) & 3), (byte) ((i5 >> 4) & 3), (byte) ((i5 >> 6) & 3)};
        }
        return bArr;
    }

    static int[] AFKeystoreWrapper(byte[] bArr, int i3) throws IllegalArgumentException {
        if (bArr.length != 16) {
            throw new IllegalArgumentException();
        }
        int i4 = 4;
        int i5 = (i3 + 1) * 4;
        int[] iArr = new int[i5];
        int i6 = 0;
        for (int i7 = 0; i7 < 4; i7++) {
            int i8 = i6 + 3;
            int i9 = ((bArr[i6 + 1] & 255) << 16) | (bArr[i6] << Ascii.CAN) | ((bArr[i6 + 2] & 255) << 8);
            i6 += 4;
            iArr[i7] = i9 | (bArr[i8] & 255);
        }
        int i10 = 4;
        int i11 = 0;
        int i12 = 0;
        while (i10 < i5) {
            int i13 = iArr[i10 - 1];
            if (i11 == 0) {
                byte[] bArr2 = afInfoLog;
                i13 = ((bArr2[i13 >>> 24] & 255) | (((bArr2[(i13 >>> 16) & 255] << Ascii.CAN) | ((bArr2[(i13 >>> 8) & 255] & 255) << 16)) | ((bArr2[i13 & 255] & 255) << 8))) ^ AFLogger[i12];
                i11 = 4;
                i12++;
            }
            iArr[i10] = i13 ^ iArr[i10 - 4];
            i10++;
            i11--;
        }
        if (bArr.length != 16) {
            throw new IllegalArgumentException();
        }
        int[] iArr2 = new int[i5];
        int i14 = i3 * 4;
        iArr2[0] = iArr[i14];
        int i15 = 1;
        iArr2[1] = iArr[i14 + 1];
        iArr2[2] = iArr[i14 + 2];
        char c3 = 3;
        iArr2[3] = iArr[i14 + 3];
        int i16 = i14 - 4;
        while (i15 < i3) {
            int i17 = iArr[i16];
            int[] iArr3 = AFKeystoreWrapper;
            byte[] bArr3 = afInfoLog;
            int i18 = iArr3[bArr3[i17 >>> 24] & 255];
            int[] iArr4 = valueOf;
            int i19 = i18 ^ iArr4[bArr3[(i17 >>> 16) & 255] & 255];
            int[] iArr5 = AFInAppEventType;
            int i20 = i19 ^ iArr5[bArr3[(i17 >>> 8) & 255] & 255];
            int[] iArr6 = values;
            iArr2[i4] = iArr6[bArr3[i17 & 255] & 255] ^ i20;
            int i21 = iArr[i16 + 1];
            char c4 = c3;
            int[] iArr7 = iArr2;
            iArr7[i4 + 1] = ((iArr4[bArr3[(i21 >>> 16) & 255] & 255] ^ iArr3[bArr3[i21 >>> 24] & 255]) ^ iArr5[bArr3[(i21 >>> 8) & 255] & 255]) ^ iArr6[bArr3[i21 & 255] & 255];
            int i22 = iArr[i16 + 2];
            int i23 = i4 + 3;
            iArr7[i4 + 2] = iArr6[bArr3[i22 & 255] & 255] ^ ((iArr3[bArr3[i22 >>> 24] & 255] ^ iArr4[bArr3[(i22 >>> 16) & 255] & 255]) ^ iArr5[bArr3[(i22 >>> 8) & 255] & 255]);
            int i24 = iArr[i16 + 3];
            i4 += 4;
            iArr7[i23] = iArr6[bArr3[i24 & 255] & 255] ^ ((iArr3[bArr3[i24 >>> 24] & 255] ^ iArr4[bArr3[(i24 >>> 16) & 255] & 255]) ^ iArr5[bArr3[(i24 >>> 8) & 255] & 255]);
            i16 -= 4;
            i15++;
            c3 = c4;
            iArr2 = iArr7;
        }
        int[] iArr8 = iArr2;
        iArr8[i4] = iArr[i16];
        iArr8[i4 + 1] = iArr[i16 + 1];
        iArr8[i4 + 2] = iArr[i16 + 2];
        iArr8[i4 + 3] = iArr[i16 + 3];
        return iArr8;
    }
}
