package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Version;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class MatrixUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[][] f92095a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[][] f92096b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[][] f92097c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[][] f92098d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    static void a(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, int i3, ByteMatrix byteMatrix) throws WriterException {
        c(byteMatrix);
        d(version, byteMatrix);
        l(errorCorrectionLevel, i3, byteMatrix);
        s(version, byteMatrix);
        f(bitArray, i3, byteMatrix);
    }

    static int b(int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int iN = n(i4);
        int iN2 = i3 << (iN - 1);
        while (n(iN2) >= iN) {
            iN2 ^= i4 << (n(iN2) - iN);
        }
        return iN2;
    }

    static void c(ByteMatrix byteMatrix) {
        byteMatrix.a((byte) -1);
    }

    static void d(Version version, ByteMatrix byteMatrix) throws WriterException {
        j(byteMatrix);
        e(byteMatrix);
        r(version, byteMatrix);
        k(byteMatrix);
    }

    private static void e(ByteMatrix byteMatrix) throws WriterException {
        if (byteMatrix.b(8, byteMatrix.d() - 8) == 0) {
            throw new WriterException();
        }
        byteMatrix.f(8, byteMatrix.d() - 8, 1);
    }

    static void f(BitArray bitArray, int i3, ByteMatrix byteMatrix) throws WriterException {
        boolean zH;
        int iE = byteMatrix.e() - 1;
        int iD = byteMatrix.d() - 1;
        int i4 = 0;
        int i5 = -1;
        while (iE > 0) {
            if (iE == 6) {
                iE--;
            }
            while (iD >= 0 && iD < byteMatrix.d()) {
                for (int i6 = 0; i6 < 2; i6++) {
                    int i7 = iE - i6;
                    if (o(byteMatrix.b(i7, iD))) {
                        if (i4 < bitArray.i()) {
                            zH = bitArray.h(i4);
                            i4++;
                        } else {
                            zH = false;
                        }
                        if (i3 != -1 && MaskUtil.f(i3, i7, iD)) {
                            zH = !zH;
                        }
                        byteMatrix.g(i7, iD, zH);
                    }
                }
                iD += i5;
            }
            i5 = -i5;
            iD += i5;
            iE -= 2;
        }
        if (i4 == bitArray.i()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i4 + '/' + bitArray.i());
    }

    private static void g(int i3, int i4, ByteMatrix byteMatrix) throws WriterException {
        for (int i5 = 0; i5 < 8; i5++) {
            int i6 = i3 + i5;
            if (!o(byteMatrix.b(i6, i4))) {
                throw new WriterException();
            }
            byteMatrix.f(i6, i4, 0);
        }
    }

    private static void h(int i3, int i4, ByteMatrix byteMatrix) {
        for (int i5 = 0; i5 < 5; i5++) {
            int[] iArr = f92096b[i5];
            for (int i6 = 0; i6 < 5; i6++) {
                byteMatrix.f(i3 + i6, i4 + i5, iArr[i6]);
            }
        }
    }

    private static void i(int i3, int i4, ByteMatrix byteMatrix) {
        for (int i5 = 0; i5 < 7; i5++) {
            int[] iArr = f92095a[i5];
            for (int i6 = 0; i6 < 7; i6++) {
                byteMatrix.f(i3 + i6, i4 + i5, iArr[i6]);
            }
        }
    }

    private static void j(ByteMatrix byteMatrix) throws WriterException {
        int length = f92095a[0].length;
        i(0, 0, byteMatrix);
        i(byteMatrix.e() - length, 0, byteMatrix);
        i(0, byteMatrix.e() - length, byteMatrix);
        g(0, 7, byteMatrix);
        g(byteMatrix.e() - 8, 7, byteMatrix);
        g(0, byteMatrix.e() - 8, byteMatrix);
        m(7, 0, byteMatrix);
        m(byteMatrix.d() - 8, 0, byteMatrix);
        m(7, byteMatrix.d() - 7, byteMatrix);
    }

    private static void k(ByteMatrix byteMatrix) {
        int i3 = 8;
        while (i3 < byteMatrix.e() - 8) {
            int i4 = i3 + 1;
            int i5 = i4 % 2;
            if (o(byteMatrix.b(i3, 6))) {
                byteMatrix.f(i3, 6, i5);
            }
            if (o(byteMatrix.b(6, i3))) {
                byteMatrix.f(6, i3, i5);
            }
            i3 = i4;
        }
    }

    static void l(ErrorCorrectionLevel errorCorrectionLevel, int i3, ByteMatrix byteMatrix) throws WriterException {
        BitArray bitArray = new BitArray();
        p(errorCorrectionLevel, i3, bitArray);
        for (int i4 = 0; i4 < bitArray.i(); i4++) {
            boolean zH = bitArray.h((bitArray.i() - 1) - i4);
            int[] iArr = f92098d[i4];
            byteMatrix.g(iArr[0], iArr[1], zH);
            if (i4 < 8) {
                byteMatrix.g((byteMatrix.e() - i4) - 1, 8, zH);
            } else {
                byteMatrix.g(8, (byteMatrix.d() - 7) + (i4 - 8), zH);
            }
        }
    }

    private static void m(int i3, int i4, ByteMatrix byteMatrix) throws WriterException {
        for (int i5 = 0; i5 < 7; i5++) {
            int i6 = i4 + i5;
            if (!o(byteMatrix.b(i3, i6))) {
                throw new WriterException();
            }
            byteMatrix.f(i3, i6, 0);
        }
    }

    static int n(int i3) {
        return 32 - Integer.numberOfLeadingZeros(i3);
    }

    private static boolean o(int i3) {
        return i3 == -1;
    }

    static void p(ErrorCorrectionLevel errorCorrectionLevel, int i3, BitArray bitArray) throws WriterException {
        if (!QRCode.b(i3)) {
            throw new WriterException("Invalid mask pattern");
        }
        int iA = (errorCorrectionLevel.a() << 3) | i3;
        bitArray.c(iA, 5);
        bitArray.c(b(iA, 1335), 10);
        BitArray bitArray2 = new BitArray();
        bitArray2.c(21522, 15);
        bitArray.o(bitArray2);
        if (bitArray.i() == 15) {
            return;
        }
        throw new WriterException("should not happen but we got: " + bitArray.i());
    }

    static void q(Version version, BitArray bitArray) throws WriterException {
        bitArray.c(version.f(), 6);
        bitArray.c(b(version.f(), 7973), 12);
        if (bitArray.i() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + bitArray.i());
    }

    private static void r(Version version, ByteMatrix byteMatrix) {
        if (version.f() < 2) {
            return;
        }
        int[] iArr = f92097c[version.f() - 1];
        for (int i3 : iArr) {
            if (i3 >= 0) {
                for (int i4 : iArr) {
                    if (i4 >= 0 && o(byteMatrix.b(i4, i3))) {
                        h(i4 - 2, i3 - 2, byteMatrix);
                    }
                }
            }
        }
    }

    static void s(Version version, ByteMatrix byteMatrix) throws WriterException {
        if (version.f() < 7) {
            return;
        }
        BitArray bitArray = new BitArray();
        q(version, bitArray);
        int i3 = 17;
        for (int i4 = 0; i4 < 6; i4++) {
            for (int i5 = 0; i5 < 3; i5++) {
                boolean zH = bitArray.h(i3);
                i3--;
                byteMatrix.g(i4, (byteMatrix.d() - 11) + i5, zH);
                byteMatrix.g((byteMatrix.d() - 11) + i5, i4, zH);
            }
        }
    }
}
