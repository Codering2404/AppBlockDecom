package com.google.crypto.tink.subtle;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class Field25519 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f87449a = {0, 3, 6, 9, 12, 16, 19, 22, 25, 28};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f87450b = {0, 2, 3, 5, 6, 0, 1, 3, 4, 6};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f87451c = {67108863, 33554431};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f87452d = {26, 25};

    static byte[] a(long[] jArr) {
        int i3;
        long[] jArrCopyOf = Arrays.copyOf(jArr, 10);
        int i4 = 0;
        while (true) {
            if (i4 >= 2) {
                break;
            }
            int i5 = 0;
            while (i5 < 9) {
                long j3 = jArrCopyOf[i5];
                int i6 = f87452d[i5 & 1];
                int i7 = -((int) (((j3 >> 31) & j3) >> i6));
                jArrCopyOf[i5] = j3 + ((long) (i7 << i6));
                i5++;
                jArrCopyOf[i5] = jArrCopyOf[i5] - ((long) i7);
            }
            long j4 = jArrCopyOf[9];
            int i8 = -((int) (((j4 >> 31) & j4) >> 25));
            jArrCopyOf[9] = j4 + ((long) (i8 << 25));
            jArrCopyOf[0] = jArrCopyOf[0] - ((long) (i8 * 19));
            i4++;
        }
        long j5 = jArrCopyOf[0];
        int i9 = -((int) (((j5 >> 31) & j5) >> 26));
        jArrCopyOf[0] = j5 + ((long) (i9 << 26));
        jArrCopyOf[1] = jArrCopyOf[1] - ((long) i9);
        for (int i10 = 0; i10 < 2; i10++) {
            int i11 = 0;
            while (i11 < 9) {
                long j6 = jArrCopyOf[i11];
                int i12 = i11 & 1;
                int i13 = (int) (j6 >> f87452d[i12]);
                jArrCopyOf[i11] = j6 & ((long) f87451c[i12]);
                i11++;
                jArrCopyOf[i11] = jArrCopyOf[i11] + ((long) i13);
            }
        }
        long j7 = jArrCopyOf[9];
        jArrCopyOf[9] = j7 & 33554431;
        long j8 = jArrCopyOf[0] + ((long) (((int) (j7 >> 25)) * 19));
        jArrCopyOf[0] = j8;
        int iD = d((int) j8, 67108845);
        for (int i14 = 1; i14 < 10; i14++) {
            iD &= b((int) jArrCopyOf[i14], f87451c[i14 & 1]);
        }
        jArrCopyOf[0] = jArrCopyOf[0] - ((long) (67108845 & iD));
        long j9 = 33554431 & iD;
        jArrCopyOf[1] = jArrCopyOf[1] - j9;
        for (i3 = 2; i3 < 10; i3 += 2) {
            jArrCopyOf[i3] = jArrCopyOf[i3] - ((long) (67108863 & iD));
            int i15 = i3 + 1;
            jArrCopyOf[i15] = jArrCopyOf[i15] - j9;
        }
        for (int i16 = 0; i16 < 10; i16++) {
            jArrCopyOf[i16] = jArrCopyOf[i16] << f87450b[i16];
        }
        byte[] bArr = new byte[32];
        for (int i17 = 0; i17 < 10; i17++) {
            int i18 = f87449a[i17];
            long j10 = bArr[i18];
            long j11 = jArrCopyOf[i17];
            bArr[i18] = (byte) (j10 | (j11 & 255));
            bArr[i18 + 1] = (byte) (((long) bArr[r4]) | ((j11 >> 8) & 255));
            bArr[i18 + 2] = (byte) (((long) bArr[r4]) | ((j11 >> 16) & 255));
            bArr[i18 + 3] = (byte) (((long) bArr[r3]) | ((j11 >> 24) & 255));
        }
        return bArr;
    }

    private static int b(int i3, int i4) {
        int i5 = ~(i3 ^ i4);
        int i6 = i5 & (i5 << 16);
        int i7 = i6 & (i6 << 8);
        int i8 = i7 & (i7 << 4);
        int i9 = i8 & (i8 << 2);
        return (i9 & (i9 << 1)) >> 31;
    }

    static long[] c(byte[] bArr) {
        long[] jArr = new long[10];
        for (int i3 = 0; i3 < 10; i3++) {
            int i4 = f87449a[i3];
            jArr[i3] = ((((((long) (bArr[i4] & 255)) | (((long) (bArr[i4 + 1] & 255)) << 8)) | (((long) (bArr[i4 + 2] & 255)) << 16)) | (((long) (bArr[i4 + 3] & 255)) << 24)) >> f87450b[i3]) & ((long) f87451c[i3 & 1]);
        }
        return jArr;
    }

    private static int d(int i3, int i4) {
        return ~((i3 - i4) >> 31);
    }

    static void e(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[10];
        long[] jArr4 = new long[10];
        long[] jArr5 = new long[10];
        long[] jArr6 = new long[10];
        long[] jArr7 = new long[10];
        long[] jArr8 = new long[10];
        long[] jArr9 = new long[10];
        long[] jArr10 = new long[10];
        long[] jArr11 = new long[10];
        long[] jArr12 = new long[10];
        k(jArr3, jArr2);
        k(jArr12, jArr3);
        k(jArr11, jArr12);
        f(jArr4, jArr11, jArr2);
        f(jArr5, jArr4, jArr3);
        k(jArr11, jArr5);
        f(jArr6, jArr11, jArr4);
        k(jArr11, jArr6);
        k(jArr12, jArr11);
        k(jArr11, jArr12);
        k(jArr12, jArr11);
        k(jArr11, jArr12);
        f(jArr7, jArr11, jArr6);
        k(jArr11, jArr7);
        k(jArr12, jArr11);
        for (int i3 = 2; i3 < 10; i3 += 2) {
            k(jArr11, jArr12);
            k(jArr12, jArr11);
        }
        f(jArr8, jArr12, jArr7);
        k(jArr11, jArr8);
        k(jArr12, jArr11);
        for (int i4 = 2; i4 < 20; i4 += 2) {
            k(jArr11, jArr12);
            k(jArr12, jArr11);
        }
        f(jArr11, jArr12, jArr8);
        k(jArr12, jArr11);
        k(jArr11, jArr12);
        for (int i5 = 2; i5 < 10; i5 += 2) {
            k(jArr12, jArr11);
            k(jArr11, jArr12);
        }
        f(jArr9, jArr11, jArr7);
        k(jArr11, jArr9);
        k(jArr12, jArr11);
        for (int i6 = 2; i6 < 50; i6 += 2) {
            k(jArr11, jArr12);
            k(jArr12, jArr11);
        }
        f(jArr10, jArr12, jArr9);
        k(jArr12, jArr10);
        k(jArr11, jArr12);
        for (int i7 = 2; i7 < 100; i7 += 2) {
            k(jArr12, jArr11);
            k(jArr11, jArr12);
        }
        f(jArr12, jArr11, jArr10);
        k(jArr11, jArr12);
        k(jArr12, jArr11);
        for (int i8 = 2; i8 < 50; i8 += 2) {
            k(jArr11, jArr12);
            k(jArr12, jArr11);
        }
        f(jArr11, jArr12, jArr9);
        k(jArr12, jArr11);
        k(jArr11, jArr12);
        k(jArr12, jArr11);
        k(jArr11, jArr12);
        k(jArr12, jArr11);
        f(jArr, jArr12, jArr5);
    }

    static void f(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[19];
        g(jArr4, jArr2, jArr3);
        h(jArr4, jArr);
    }

    static void g(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr[0] = jArr2[0] * jArr3[0];
        long j3 = jArr2[0];
        long j4 = jArr3[1] * j3;
        long j5 = jArr2[1];
        long j6 = jArr3[0];
        jArr[1] = j4 + (j5 * j6);
        long j7 = jArr2[1];
        long j8 = jArr3[1];
        jArr[2] = (j7 * 2 * j8) + (jArr3[2] * j3) + (jArr2[2] * j6);
        long j9 = jArr3[2];
        long j10 = jArr2[2];
        jArr[3] = (j7 * j9) + (j10 * j8) + (jArr3[3] * j3) + (jArr2[3] * j6);
        long j11 = jArr3[3];
        long j12 = jArr2[3];
        jArr[4] = (j10 * j9) + (((j7 * j11) + (j12 * j8)) * 2) + (jArr3[4] * j3) + (jArr2[4] * j6);
        long j13 = jArr3[4];
        long j14 = jArr2[4];
        jArr[5] = (j10 * j11) + (j12 * j9) + (j7 * j13) + (j14 * j8) + (jArr3[5] * j3) + (jArr2[5] * j6);
        long j15 = jArr3[5];
        long j16 = jArr2[5];
        jArr[6] = (((j12 * j11) + (j7 * j15) + (j16 * j8)) * 2) + (j10 * j13) + (j14 * j9) + (jArr3[6] * j3) + (jArr2[6] * j6);
        long j17 = jArr3[6];
        long j18 = jArr2[6];
        jArr[7] = (j12 * j13) + (j14 * j11) + (j10 * j15) + (j16 * j9) + (j7 * j17) + (j18 * j8) + (jArr3[7] * j3) + (jArr2[7] * j6);
        long j19 = jArr3[7];
        long j20 = jArr2[7];
        jArr[8] = (j14 * j13) + (((j12 * j15) + (j16 * j11) + (j7 * j19) + (j20 * j8)) * 2) + (j10 * j17) + (j18 * j9) + (jArr3[8] * j3) + (jArr2[8] * j6);
        long j21 = jArr3[8];
        long j22 = jArr2[8];
        jArr[9] = (j14 * j15) + (j16 * j13) + (j12 * j17) + (j18 * j11) + (j10 * j19) + (j20 * j9) + (j7 * j21) + (j22 * j8) + (j3 * jArr3[9]) + (jArr2[9] * j6);
        long j23 = jArr3[9];
        long j24 = jArr2[9];
        jArr[10] = (((j16 * j15) + (j12 * j19) + (j20 * j11) + (j7 * j23) + (j8 * j24)) * 2) + (j14 * j17) + (j18 * j13) + (j10 * j21) + (j22 * j9);
        jArr[11] = (j16 * j17) + (j18 * j15) + (j14 * j19) + (j20 * j13) + (j12 * j21) + (j22 * j11) + (j10 * j23) + (j9 * j24);
        jArr[12] = (j18 * j17) + (((j16 * j19) + (j20 * j15) + (j12 * j23) + (j11 * j24)) * 2) + (j14 * j21) + (j22 * j13);
        jArr[13] = (j18 * j19) + (j20 * j17) + (j16 * j21) + (j22 * j15) + (j14 * j23) + (j13 * j24);
        jArr[14] = (((j20 * j19) + (j16 * j23) + (j15 * j24)) * 2) + (j18 * j21) + (j22 * j17);
        jArr[15] = (j20 * j21) + (j22 * j19) + (j18 * j23) + (j17 * j24);
        jArr[16] = (j22 * j21) + (((j20 * j23) + (j19 * j24)) * 2);
        jArr[17] = (j22 * j23) + (j21 * j24);
        jArr[18] = j24 * 2 * j23;
    }

    static void h(long[] jArr, long[] jArr2) {
        if (jArr.length != 19) {
            long[] jArr3 = new long[19];
            System.arraycopy(jArr, 0, jArr3, 0, jArr.length);
            jArr = jArr3;
        }
        j(jArr);
        i(jArr);
        System.arraycopy(jArr, 0, jArr2, 0, 10);
    }

    static void i(long[] jArr) {
        jArr[10] = 0;
        int i3 = 0;
        while (i3 < 10) {
            long j3 = jArr[i3];
            long j4 = j3 / 67108864;
            jArr[i3] = j3 - (j4 << 26);
            int i4 = i3 + 1;
            long j5 = jArr[i4] + j4;
            jArr[i4] = j5;
            long j6 = j5 / 33554432;
            jArr[i4] = j5 - (j6 << 25);
            i3 += 2;
            jArr[i3] = jArr[i3] + j6;
        }
        long j7 = jArr[0];
        long j8 = jArr[10];
        long j9 = j7 + (j8 << 4);
        jArr[0] = j9;
        long j10 = j9 + (j8 << 1);
        jArr[0] = j10;
        long j11 = j10 + j8;
        jArr[0] = j11;
        jArr[10] = 0;
        long j12 = j11 / 67108864;
        jArr[0] = j11 - (j12 << 26);
        jArr[1] = jArr[1] + j12;
    }

    static void j(long[] jArr) {
        long j3 = jArr[8];
        long j4 = jArr[18];
        long j5 = j3 + (j4 << 4);
        jArr[8] = j5;
        long j6 = j5 + (j4 << 1);
        jArr[8] = j6;
        jArr[8] = j6 + j4;
        long j7 = jArr[7];
        long j8 = jArr[17];
        long j9 = j7 + (j8 << 4);
        jArr[7] = j9;
        long j10 = j9 + (j8 << 1);
        jArr[7] = j10;
        jArr[7] = j10 + j8;
        long j11 = jArr[6];
        long j12 = jArr[16];
        long j13 = j11 + (j12 << 4);
        jArr[6] = j13;
        long j14 = j13 + (j12 << 1);
        jArr[6] = j14;
        jArr[6] = j14 + j12;
        long j15 = jArr[5];
        long j16 = jArr[15];
        long j17 = j15 + (j16 << 4);
        jArr[5] = j17;
        long j18 = j17 + (j16 << 1);
        jArr[5] = j18;
        jArr[5] = j18 + j16;
        long j19 = jArr[4];
        long j20 = jArr[14];
        long j21 = j19 + (j20 << 4);
        jArr[4] = j21;
        long j22 = j21 + (j20 << 1);
        jArr[4] = j22;
        jArr[4] = j22 + j20;
        long j23 = jArr[3];
        long j24 = jArr[13];
        long j25 = j23 + (j24 << 4);
        jArr[3] = j25;
        long j26 = j25 + (j24 << 1);
        jArr[3] = j26;
        jArr[3] = j26 + j24;
        long j27 = jArr[2];
        long j28 = jArr[12];
        long j29 = j27 + (j28 << 4);
        jArr[2] = j29;
        long j30 = j29 + (j28 << 1);
        jArr[2] = j30;
        jArr[2] = j30 + j28;
        long j31 = jArr[1];
        long j32 = jArr[11];
        long j33 = j31 + (j32 << 4);
        jArr[1] = j33;
        long j34 = j33 + (j32 << 1);
        jArr[1] = j34;
        jArr[1] = j34 + j32;
        long j35 = jArr[0];
        long j36 = jArr[10];
        long j37 = j35 + (j36 << 4);
        jArr[0] = j37;
        long j38 = j37 + (j36 << 1);
        jArr[0] = j38;
        jArr[0] = j38 + j36;
    }

    static void k(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[19];
        l(jArr3, jArr2);
        h(jArr3, jArr);
    }

    private static void l(long[] jArr, long[] jArr2) {
        long j3 = jArr2[0];
        jArr[0] = j3 * j3;
        long j4 = jArr2[0];
        jArr[1] = j4 * 2 * jArr2[1];
        long j5 = jArr2[1];
        jArr[2] = ((j5 * j5) + (jArr2[2] * j4)) * 2;
        long j6 = jArr2[2];
        jArr[3] = ((j5 * j6) + (jArr2[3] * j4)) * 2;
        long j7 = jArr2[3];
        jArr[4] = (j6 * j6) + (j5 * 4 * j7) + (j4 * 2 * jArr2[4]);
        long j8 = jArr2[4];
        jArr[5] = ((j6 * j7) + (j5 * j8) + (jArr2[5] * j4)) * 2;
        long j9 = (j7 * j7) + (j6 * j8) + (jArr2[6] * j4);
        long j10 = jArr2[5];
        jArr[6] = (j9 + (j5 * 2 * j10)) * 2;
        long j11 = jArr2[6];
        jArr[7] = ((j7 * j8) + (j6 * j10) + (j5 * j11) + (jArr2[7] * j4)) * 2;
        long j12 = (j6 * j11) + (jArr2[8] * j4);
        long j13 = jArr2[7];
        jArr[8] = (j8 * j8) + ((j12 + (((j5 * j13) + (j7 * j10)) * 2)) * 2);
        long j14 = jArr2[8];
        jArr[9] = ((j8 * j10) + (j7 * j11) + (j6 * j13) + (j5 * j14) + (j4 * jArr2[9])) * 2;
        long j15 = jArr2[9];
        jArr[10] = ((j10 * j10) + (j8 * j11) + (j6 * j14) + (((j7 * j13) + (j5 * j15)) * 2)) * 2;
        jArr[11] = ((j10 * j11) + (j8 * j13) + (j7 * j14) + (j6 * j15)) * 2;
        jArr[12] = (j11 * j11) + (((j8 * j14) + (((j10 * j13) + (j7 * j15)) * 2)) * 2);
        jArr[13] = ((j11 * j13) + (j10 * j14) + (j8 * j15)) * 2;
        jArr[14] = ((j13 * j13) + (j11 * j14) + (j10 * 2 * j15)) * 2;
        jArr[15] = ((j13 * j14) + (j11 * j15)) * 2;
        jArr[16] = (j14 * j14) + (j13 * 4 * j15);
        jArr[17] = j14 * 2 * j15;
        jArr[18] = 2 * j15 * j15;
    }

    static void m(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i3 = 0; i3 < 10; i3++) {
            jArr[i3] = jArr2[i3] - jArr3[i3];
        }
    }

    static void n(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i3 = 0; i3 < 10; i3++) {
            jArr[i3] = jArr2[i3] + jArr3[i3];
        }
    }
}
