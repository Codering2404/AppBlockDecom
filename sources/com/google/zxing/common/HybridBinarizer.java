package com.google.zxing.common;

import com.google.zxing.LuminanceSource;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class HybridBinarizer extends GlobalHistogramBinarizer {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BitMatrix f91818e;

    private static int[][] e(byte[] bArr, int i3, int i4, int i5, int i6) {
        int i7 = 8;
        int i8 = i6 - 8;
        int i9 = i5 - 8;
        char c3 = 2;
        boolean z2 = true;
        int i10 = 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i4, i3);
        int i11 = 0;
        while (i11 < i4) {
            int i12 = i11 << 3;
            if (i12 > i8) {
                i12 = i8;
            }
            int i13 = i10;
            while (i13 < i3) {
                int i14 = i13 << 3;
                if (i14 > i9) {
                    i14 = i9;
                }
                int i15 = (i12 * i5) + i14;
                char c4 = c3;
                boolean z3 = z2;
                int i16 = i10;
                int i17 = i16;
                int i18 = i17;
                int i19 = 255;
                while (i16 < i7) {
                    int i20 = i10;
                    int i21 = i18;
                    while (i20 < i7) {
                        int i22 = bArr[i15 + i20] & 255;
                        i17 += i22;
                        if (i22 < i19) {
                            i19 = i22;
                        }
                        if (i22 > i21) {
                            i21 = i22;
                        }
                        i20++;
                        i7 = 8;
                    }
                    if (i21 - i19 > 24) {
                        while (true) {
                            i16++;
                            i15 += i5;
                            if (i16 < 8) {
                                int i23 = 0;
                                for (int i24 = 8; i23 < i24; i24 = 8) {
                                    i17 += bArr[i15 + i23] & 255;
                                    i23++;
                                }
                            }
                        }
                    }
                    i16++;
                    i15 += i5;
                    i18 = i21;
                    i7 = 8;
                    i10 = 0;
                }
                int i25 = i17 >> 6;
                if (i18 - i19 <= 24) {
                    i25 = i19 / 2;
                    if (i11 > 0 && i13 > 0) {
                        int[] iArr2 = iArr[i11 - 1];
                        int i26 = i13 - 1;
                        int i27 = ((iArr2[i13] + (iArr[i11][i26] * 2)) + iArr2[i26]) / 4;
                        if (i19 < i27) {
                            i25 = i27;
                        }
                    }
                }
                iArr[i11][i13] = i25;
                i13++;
                c3 = c4;
                z2 = z3;
                i7 = 8;
                i10 = 0;
            }
            i11++;
            i7 = 8;
            i10 = 0;
        }
        return iArr;
    }

    private static void f(byte[] bArr, int i3, int i4, int i5, int i6, int[][] iArr, BitMatrix bitMatrix) {
        int i7 = i6 - 8;
        int i8 = i5 - 8;
        for (int i9 = 0; i9 < i4; i9++) {
            int i10 = i9 << 3;
            int i11 = i10 > i7 ? i7 : i10;
            int iG = g(i9, 2, i4 - 3);
            for (int i12 = 0; i12 < i3; i12++) {
                int i13 = i12 << 3;
                int i14 = i13 > i8 ? i8 : i13;
                int iG2 = g(i12, 2, i3 - 3);
                int i15 = 0;
                for (int i16 = -2; i16 <= 2; i16++) {
                    int[] iArr2 = iArr[iG + i16];
                    i15 += iArr2[iG2 - 2] + iArr2[iG2 - 1] + iArr2[iG2] + iArr2[iG2 + 1] + iArr2[iG2 + 2];
                }
                h(bArr, i14, i11, i15 / 25, i5, bitMatrix);
            }
        }
    }

    private static int g(int i3, int i4, int i5) {
        return i3 < i4 ? i4 : i3 > i5 ? i5 : i3;
    }

    private static void h(byte[] bArr, int i3, int i4, int i5, int i6, BitMatrix bitMatrix) {
        int i7 = (i4 * i6) + i3;
        int i8 = 0;
        while (i8 < 8) {
            for (int i9 = 0; i9 < 8; i9++) {
                if ((bArr[i7 + i9] & 255) <= i5) {
                    bitMatrix.i(i3 + i9, i4 + i8);
                }
            }
            i8++;
            i7 += i6;
        }
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public BitMatrix a() {
        BitMatrix bitMatrix = this.f91818e;
        if (bitMatrix != null) {
            return bitMatrix;
        }
        LuminanceSource luminanceSourceB = b();
        int iD = luminanceSourceB.d();
        int iA = luminanceSourceB.a();
        if (iD < 40 || iA < 40) {
            this.f91818e = super.a();
        } else {
            byte[] bArrB = luminanceSourceB.b();
            int i3 = iD >> 3;
            if ((iD & 7) != 0) {
                i3++;
            }
            int i4 = i3;
            int i5 = iA >> 3;
            if ((iA & 7) != 0) {
                i5++;
            }
            int i6 = i5;
            int[][] iArrE = e(bArrB, i4, i6, iD, iA);
            BitMatrix bitMatrix2 = new BitMatrix(iD, iA);
            f(bArrB, i4, i6, iD, iA, iArrE, bitMatrix2);
            this.f91818e = bitMatrix2;
        }
        return this.f91818e;
    }
}
