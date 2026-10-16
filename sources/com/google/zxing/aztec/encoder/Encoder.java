package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class Encoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f91663a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private static int[] a(BitArray bitArray, int i3, int i4) {
        int[] iArr = new int[i4];
        int i5 = bitArray.i() / i3;
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = 0;
            for (int i8 = 0; i8 < i3; i8++) {
                i7 |= bitArray.h((i6 * i3) + i8) ? 1 << ((i3 - i8) - 1) : 0;
            }
            iArr[i6] = i7;
        }
        return iArr;
    }

    private static void b(BitMatrix bitMatrix, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5 += 2) {
            int i6 = i3 - i5;
            int i7 = i6;
            while (true) {
                int i8 = i3 + i5;
                if (i7 <= i8) {
                    bitMatrix.i(i7, i6);
                    bitMatrix.i(i7, i8);
                    bitMatrix.i(i6, i7);
                    bitMatrix.i(i8, i7);
                    i7++;
                }
            }
        }
        int i9 = i3 - i4;
        bitMatrix.i(i9, i9);
        int i10 = i9 + 1;
        bitMatrix.i(i10, i9);
        bitMatrix.i(i9, i10);
        int i11 = i3 + i4;
        bitMatrix.i(i11, i9);
        bitMatrix.i(i11, i10);
        bitMatrix.i(i11, i11 - 1);
    }

    private static void c(BitMatrix bitMatrix, boolean z2, int i3, BitArray bitArray) {
        int i4 = i3 / 2;
        int i5 = 0;
        if (z2) {
            while (i5 < 7) {
                int i6 = (i4 - 3) + i5;
                if (bitArray.h(i5)) {
                    bitMatrix.i(i6, i4 - 5);
                }
                if (bitArray.h(i5 + 7)) {
                    bitMatrix.i(i4 + 5, i6);
                }
                if (bitArray.h(20 - i5)) {
                    bitMatrix.i(i6, i4 + 5);
                }
                if (bitArray.h(27 - i5)) {
                    bitMatrix.i(i4 - 5, i6);
                }
                i5++;
            }
            return;
        }
        while (i5 < 10) {
            int i7 = (i4 - 5) + i5 + (i5 / 5);
            if (bitArray.h(i5)) {
                bitMatrix.i(i7, i4 - 7);
            }
            if (bitArray.h(i5 + 10)) {
                bitMatrix.i(i4 + 7, i7);
            }
            if (bitArray.h(29 - i5)) {
                bitMatrix.i(i7, i4 + 7);
            }
            if (bitArray.h(39 - i5)) {
                bitMatrix.i(i4 - 7, i7);
            }
            i5++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static AztecCode d(byte[] bArr, int i3, int i4) {
        BitArray bitArrayH;
        int i5;
        boolean z2;
        int iAbs;
        int i6;
        int i7;
        int i8;
        BitArray bitArrayA = new HighLevelEncoder(bArr).a();
        int i9 = ((bitArrayA.i() * i3) / 100) + 11;
        int i10 = bitArrayA.i() + i9;
        int i11 = 1;
        if (i4 == 0) {
            BitArray bitArrayH2 = null;
            int i12 = 0;
            int i13 = 0;
            while (i12 <= 32) {
                boolean z3 = i12 <= 3 ? i11 : 0;
                int i14 = z3 != 0 ? i12 + 1 : i12;
                int i15 = i(i14, z3);
                if (i10 <= i15) {
                    if (bitArrayH2 == null || i13 != f91663a[i14]) {
                        int i16 = f91663a[i14];
                        i13 = i16;
                        bitArrayH2 = h(bitArrayA, i16);
                    }
                    int i17 = i15 - (i15 % i13);
                    if ((z3 == 0 || bitArrayH2.i() <= (i13 << 6)) && bitArrayH2.i() + i9 <= i17) {
                        bitArrayH = bitArrayH2;
                        i5 = i13;
                        z2 = z3;
                        iAbs = i14;
                        i6 = i15;
                    }
                }
                i12++;
                i11 = i11;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        boolean z4 = i4 < 0;
        iAbs = Math.abs(i4);
        if (iAbs > (z4 ? 4 : 32)) {
            throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i4)));
        }
        i6 = i(iAbs, z4);
        i5 = f91663a[iAbs];
        int i18 = i6 - (i6 % i5);
        bitArrayH = h(bitArrayA, i5);
        z2 = z4;
        if (bitArrayH.i() + i9 > i18) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        if (z4) {
            z2 = z4;
            if (bitArrayH.i() > (i5 << 6)) {
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
        }
        BitArray bitArrayE = e(bitArrayH, i6, i5);
        int i19 = bitArrayH.i() / i5;
        BitArray bitArrayF = f(z2, iAbs, i19);
        int i20 = (z2 ? 11 : 14) + (iAbs << 2);
        int[] iArr = new int[i20];
        int i21 = 2;
        if (z2) {
            for (int i22 = 0; i22 < i20; i22++) {
                iArr[i22] = i22;
            }
            i7 = i20;
        } else {
            int i23 = i20 / 2;
            i7 = i20 + 1 + (((i23 - 1) / 15) * 2);
            int i24 = i7 / 2;
            for (int i25 = 0; i25 < i23; i25++) {
                iArr[(i23 - i25) - i11] = (i24 - r14) - 1;
                iArr[i23 + i25] = (i25 / 15) + i25 + i24 + i11;
            }
        }
        BitMatrix bitMatrix = new BitMatrix(i7);
        int i26 = 0;
        for (int i27 = 0; i27 < iAbs; i27++) {
            int i28 = ((iAbs - i27) << i21) + (z2 ? 9 : 12);
            for (int i29 = 0; i29 < i28; i29++) {
                int i30 = i29 << 1;
                int i31 = 0;
                while (i31 < i21) {
                    int i32 = i11;
                    if (bitArrayE.h(i26 + i30 + i31)) {
                        int i33 = i27 << 1;
                        i8 = i21;
                        bitMatrix.i(iArr[i33 + i31], iArr[i33 + i29]);
                    } else {
                        i8 = i21;
                    }
                    if (bitArrayE.h((i28 << 1) + i26 + i30 + i31)) {
                        int i34 = i27 << 1;
                        bitMatrix.i(iArr[i34 + i29], iArr[((i20 - 1) - i34) - i31]);
                    }
                    if (bitArrayE.h((i28 << 2) + i26 + i30 + i31)) {
                        int i35 = (i20 - 1) - (i27 << 1);
                        bitMatrix.i(iArr[i35 - i31], iArr[i35 - i29]);
                    }
                    if (bitArrayE.h((i28 * 6) + i26 + i30 + i31)) {
                        int i36 = i27 << 1;
                        bitMatrix.i(iArr[((i20 - 1) - i36) - i29], iArr[i36 + i31]);
                    }
                    i31++;
                    i11 = i32;
                    i21 = i8;
                }
            }
            i26 += i28 << 3;
        }
        c(bitMatrix, z2, i7, bitArrayF);
        if (z2) {
            b(bitMatrix, i7 / 2, 5);
        } else {
            int i37 = i7 / 2;
            b(bitMatrix, i37, 7);
            int i38 = 0;
            int i39 = 0;
            while (i39 < (i20 / 2) - 1) {
                for (int i40 = i37 & 1; i40 < i7; i40 += 2) {
                    int i41 = i37 - i38;
                    bitMatrix.i(i41, i40);
                    int i42 = i37 + i38;
                    bitMatrix.i(i42, i40);
                    bitMatrix.i(i40, i41);
                    bitMatrix.i(i40, i42);
                }
                i39 += 15;
                i38 += 16;
            }
        }
        AztecCode aztecCode = new AztecCode();
        aztecCode.c(z2);
        aztecCode.f(i7);
        aztecCode.d(iAbs);
        aztecCode.b(i19);
        aztecCode.e(bitMatrix);
        return aztecCode;
    }

    private static BitArray e(BitArray bitArray, int i3, int i4) {
        int i5 = bitArray.i() / i4;
        ReedSolomonEncoder reedSolomonEncoder = new ReedSolomonEncoder(g(i4));
        int i6 = i3 / i4;
        int[] iArrA = a(bitArray, i4, i6);
        reedSolomonEncoder.b(iArrA, i6 - i5);
        BitArray bitArray2 = new BitArray();
        bitArray2.c(0, i3 % i4);
        for (int i7 : iArrA) {
            bitArray2.c(i7, i4);
        }
        return bitArray2;
    }

    static BitArray f(boolean z2, int i3, int i4) {
        BitArray bitArray = new BitArray();
        if (z2) {
            bitArray.c(i3 - 1, 2);
            bitArray.c(i4 - 1, 6);
            return e(bitArray, 28, 4);
        }
        bitArray.c(i3 - 1, 5);
        bitArray.c(i4 - 1, 11);
        return e(bitArray, 40, 4);
    }

    private static GenericGF g(int i3) {
        if (i3 == 4) {
            return GenericGF.f91824k;
        }
        if (i3 == 6) {
            return GenericGF.f91823j;
        }
        if (i3 == 8) {
            return GenericGF.f91827n;
        }
        if (i3 == 10) {
            return GenericGF.f91822i;
        }
        if (i3 == 12) {
            return GenericGF.f91821h;
        }
        throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i3)));
    }

    static BitArray h(BitArray bitArray, int i3) {
        BitArray bitArray2 = new BitArray();
        int i4 = bitArray.i();
        int i5 = (1 << i3) - 2;
        int i6 = 0;
        while (i6 < i4) {
            int i7 = 0;
            for (int i8 = 0; i8 < i3; i8++) {
                int i9 = i6 + i8;
                if (i9 >= i4 || bitArray.h(i9)) {
                    i7 |= 1 << ((i3 - 1) - i8);
                }
            }
            int i10 = i7 & i5;
            if (i10 == i5) {
                bitArray2.c(i10, i3);
            } else if (i10 == 0) {
                bitArray2.c(i7 | 1, i3);
            } else {
                bitArray2.c(i7, i3);
                i6 += i3;
            }
            i6--;
            i6 += i3;
        }
        return bitArray2;
    }

    private static int i(int i3, boolean z2) {
        return ((z2 ? 88 : 112) + (i3 << 4)) * i3;
    }
}
