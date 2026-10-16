package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class GlobalHistogramBinarizer extends Binarizer {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final byte[] f91814d = new byte[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f91815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[] f91816c;

    private static int c(int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = iArr[i6];
            if (i7 > i3) {
                i5 = i6;
                i3 = i7;
            }
            if (i7 > i4) {
                i4 = i7;
            }
        }
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 - i5;
            int i12 = iArr[i10] * i11 * i11;
            if (i12 > i9) {
                i8 = i10;
                i9 = i12;
            }
        }
        if (i5 <= i8) {
            int i13 = i5;
            i5 = i8;
            i8 = i13;
        }
        if (i5 - i8 <= length / 16) {
            throw NotFoundException.a();
        }
        int i14 = i5 - 1;
        int i15 = -1;
        int i16 = i14;
        while (i14 > i8) {
            int i17 = i14 - i8;
            int i18 = i17 * i17 * (i5 - i14) * (i4 - iArr[i14]);
            if (i18 > i15) {
                i16 = i14;
                i15 = i18;
            }
            i14--;
        }
        return i16 << 3;
    }

    private void d(int i3) {
        if (this.f91815b.length < i3) {
            this.f91815b = new byte[i3];
        }
        for (int i4 = 0; i4 < 32; i4++) {
            this.f91816c[i4] = 0;
        }
    }

    @Override // com.google.zxing.Binarizer
    public BitMatrix a() throws NotFoundException {
        LuminanceSource luminanceSourceB = b();
        int iD = luminanceSourceB.d();
        int iA = luminanceSourceB.a();
        BitMatrix bitMatrix = new BitMatrix(iD, iA);
        d(iD);
        int[] iArr = this.f91816c;
        for (int i3 = 1; i3 < 5; i3++) {
            byte[] bArrC = luminanceSourceB.c((iA * i3) / 5, this.f91815b);
            int i4 = (iD << 2) / 5;
            for (int i5 = iD / 5; i5 < i4; i5++) {
                int i6 = (bArrC[i5] & 255) >> 3;
                iArr[i6] = iArr[i6] + 1;
            }
        }
        int iC = c(iArr);
        byte[] bArrB = luminanceSourceB.b();
        for (int i7 = 0; i7 < iA; i7++) {
            int i8 = i7 * iD;
            for (int i9 = 0; i9 < iD; i9++) {
                if ((bArrB[i8 + i9] & 255) < iC) {
                    bitMatrix.i(i9, i7);
                }
            }
        }
        return bitMatrix;
    }
}
