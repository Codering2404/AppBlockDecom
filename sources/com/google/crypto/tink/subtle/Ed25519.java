package com.google.crypto.tink.subtle;

import com.applovin.exoplayer2.common.base.Ascii;
import com.sun.jna.Function;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class Ed25519 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CachedXYT f87391a = new CachedXYT(new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final PartialXYZT f87392b = new PartialXYZT(new XYZ(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final byte[] f87393c = {-19, -45, -11, 92, Ascii.SUB, 99, Ascii.DC2, 88, -42, -100, -9, -94, -34, -7, -34, Ascii.DC4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Ascii.DLE};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class CachedXYT {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long[] f87394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long[] f87395b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long[] f87396c;

        CachedXYT(long[] jArr, long[] jArr2, long[] jArr3) {
            this.f87394a = jArr;
            this.f87395b = jArr2;
            this.f87396c = jArr3;
        }

        void a(long[] jArr, long[] jArr2) {
            System.arraycopy(jArr2, 0, jArr, 0, 10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CachedXYZT extends CachedXYT {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long[] f87397d;

        CachedXYZT() {
            this(new long[10], new long[10], new long[10], new long[10]);
        }

        @Override // com.google.crypto.tink.subtle.Ed25519.CachedXYT
        public void a(long[] jArr, long[] jArr2) {
            Field25519.f(jArr, jArr2, this.f87397d);
        }

        CachedXYZT(XYZT xyzt) {
            this();
            long[] jArr = this.f87394a;
            XYZ xyz = xyzt.f87403a;
            Field25519.n(jArr, xyz.f87401b, xyz.f87400a);
            long[] jArr2 = this.f87395b;
            XYZ xyz2 = xyzt.f87403a;
            Field25519.m(jArr2, xyz2.f87401b, xyz2.f87400a);
            System.arraycopy(xyzt.f87403a.f87402c, 0, this.f87397d, 0, 10);
            Field25519.f(this.f87396c, xyzt.f87404b, Ed25519Constants.f87406b);
        }

        CachedXYZT(long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4) {
            super(jArr, jArr2, jArr4);
            this.f87397d = jArr3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class PartialXYZT {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final XYZ f87398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long[] f87399b;

        PartialXYZT() {
            this(new XYZ(), new long[10]);
        }

        PartialXYZT(XYZ xyz, long[] jArr) {
            this.f87398a = xyz;
            this.f87399b = jArr;
        }

        PartialXYZT(PartialXYZT partialXYZT) {
            this.f87398a = new XYZ(partialXYZT.f87398a);
            this.f87399b = Arrays.copyOf(partialXYZT.f87399b, 10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class XYZ {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long[] f87400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long[] f87401b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long[] f87402c;

        XYZ() {
            this(new long[10], new long[10], new long[10]);
        }

        static XYZ a(XYZ xyz, PartialXYZT partialXYZT) {
            Field25519.f(xyz.f87400a, partialXYZT.f87398a.f87400a, partialXYZT.f87399b);
            long[] jArr = xyz.f87401b;
            XYZ xyz2 = partialXYZT.f87398a;
            Field25519.f(jArr, xyz2.f87401b, xyz2.f87402c);
            Field25519.f(xyz.f87402c, partialXYZT.f87398a.f87402c, partialXYZT.f87399b);
            return xyz;
        }

        byte[] b() {
            long[] jArr = new long[10];
            long[] jArr2 = new long[10];
            long[] jArr3 = new long[10];
            Field25519.e(jArr, this.f87402c);
            Field25519.f(jArr2, this.f87400a, jArr);
            Field25519.f(jArr3, this.f87401b, jArr);
            byte[] bArrA = Field25519.a(jArr3);
            bArrA[31] = (byte) ((Ed25519.i(jArr2) << 7) ^ bArrA[31]);
            return bArrA;
        }

        XYZ(long[] jArr, long[] jArr2, long[] jArr3) {
            this.f87400a = jArr;
            this.f87401b = jArr2;
            this.f87402c = jArr3;
        }

        XYZ(XYZ xyz) {
            this.f87400a = Arrays.copyOf(xyz.f87400a, 10);
            this.f87401b = Arrays.copyOf(xyz.f87401b, 10);
            this.f87402c = Arrays.copyOf(xyz.f87402c, 10);
        }

        XYZ(PartialXYZT partialXYZT) {
            this();
            a(this, partialXYZT);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class XYZT {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final XYZ f87403a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long[] f87404b;

        XYZT() {
            this(new XYZ(), new long[10]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static XYZT c(byte[] bArr) throws GeneralSecurityException {
            long[] jArr = new long[10];
            long[] jArrC = Field25519.c(bArr);
            long[] jArr2 = new long[10];
            jArr2[0] = 1;
            long[] jArr3 = new long[10];
            long[] jArr4 = new long[10];
            long[] jArr5 = new long[10];
            long[] jArr6 = new long[10];
            long[] jArr7 = new long[10];
            Field25519.k(jArr4, jArrC);
            Field25519.f(jArr5, jArr4, Ed25519Constants.f87405a);
            Field25519.m(jArr4, jArr4, jArr2);
            Field25519.n(jArr5, jArr5, jArr2);
            long[] jArr8 = new long[10];
            Field25519.k(jArr8, jArr5);
            Field25519.f(jArr8, jArr8, jArr5);
            Field25519.k(jArr, jArr8);
            Field25519.f(jArr, jArr, jArr5);
            Field25519.f(jArr, jArr, jArr4);
            Ed25519.o(jArr, jArr);
            Field25519.f(jArr, jArr, jArr8);
            Field25519.f(jArr, jArr, jArr4);
            Field25519.k(jArr6, jArr);
            Field25519.f(jArr6, jArr6, jArr5);
            Field25519.m(jArr7, jArr6, jArr4);
            if (Ed25519.j(jArr7)) {
                Field25519.n(jArr7, jArr6, jArr4);
                if (Ed25519.j(jArr7)) {
                    throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. No square root exists for modulo 2^255-19");
                }
                Field25519.f(jArr, jArr, Ed25519Constants.f87407c);
            }
            if (!Ed25519.j(jArr) && ((bArr[31] & 255) >> 7) != 0) {
                throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. Computed x is zero and encoded x's least significant bit is not zero");
            }
            if (Ed25519.i(jArr) == ((bArr[31] & 255) >> 7)) {
                Ed25519.n(jArr, jArr);
            }
            Field25519.f(jArr3, jArr, jArrC);
            return new XYZT(new XYZ(jArr, jArrC, jArr2), jArr3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static XYZT d(XYZT xyzt, PartialXYZT partialXYZT) {
            Field25519.f(xyzt.f87403a.f87400a, partialXYZT.f87398a.f87400a, partialXYZT.f87399b);
            long[] jArr = xyzt.f87403a.f87401b;
            XYZ xyz = partialXYZT.f87398a;
            Field25519.f(jArr, xyz.f87401b, xyz.f87402c);
            Field25519.f(xyzt.f87403a.f87402c, partialXYZT.f87398a.f87402c, partialXYZT.f87399b);
            long[] jArr2 = xyzt.f87404b;
            XYZ xyz2 = partialXYZT.f87398a;
            Field25519.f(jArr2, xyz2.f87400a, xyz2.f87401b);
            return xyzt;
        }

        XYZT(XYZ xyz, long[] jArr) {
            this.f87403a = xyz;
            this.f87404b = jArr;
        }

        XYZT(PartialXYZT partialXYZT) {
            this();
            d(this, partialXYZT);
        }
    }

    private static void e(PartialXYZT partialXYZT, XYZT xyzt, CachedXYT cachedXYT) {
        long[] jArr = new long[10];
        long[] jArr2 = partialXYZT.f87398a.f87400a;
        XYZ xyz = xyzt.f87403a;
        Field25519.n(jArr2, xyz.f87401b, xyz.f87400a);
        long[] jArr3 = partialXYZT.f87398a.f87401b;
        XYZ xyz2 = xyzt.f87403a;
        Field25519.m(jArr3, xyz2.f87401b, xyz2.f87400a);
        long[] jArr4 = partialXYZT.f87398a.f87401b;
        Field25519.f(jArr4, jArr4, cachedXYT.f87395b);
        XYZ xyz3 = partialXYZT.f87398a;
        Field25519.f(xyz3.f87402c, xyz3.f87400a, cachedXYT.f87394a);
        Field25519.f(partialXYZT.f87399b, xyzt.f87404b, cachedXYT.f87396c);
        cachedXYT.a(partialXYZT.f87398a.f87400a, xyzt.f87403a.f87402c);
        long[] jArr5 = partialXYZT.f87398a.f87400a;
        Field25519.n(jArr, jArr5, jArr5);
        XYZ xyz4 = partialXYZT.f87398a;
        Field25519.m(xyz4.f87400a, xyz4.f87402c, xyz4.f87401b);
        XYZ xyz5 = partialXYZT.f87398a;
        long[] jArr6 = xyz5.f87401b;
        Field25519.n(jArr6, xyz5.f87402c, jArr6);
        Field25519.n(partialXYZT.f87398a.f87402c, jArr, partialXYZT.f87399b);
        long[] jArr7 = partialXYZT.f87399b;
        Field25519.m(jArr7, jArr, jArr7);
    }

    private static XYZ f(byte[] bArr, XYZT xyzt, byte[] bArr2) {
        CachedXYZT[] cachedXYZTArr = new CachedXYZT[8];
        cachedXYZTArr[0] = new CachedXYZT(xyzt);
        PartialXYZT partialXYZT = new PartialXYZT();
        h(partialXYZT, xyzt);
        XYZT xyzt2 = new XYZT(partialXYZT);
        for (int i3 = 1; i3 < 8; i3++) {
            e(partialXYZT, xyzt2, cachedXYZTArr[i3 - 1]);
            cachedXYZTArr[i3] = new CachedXYZT(new XYZT(partialXYZT));
        }
        byte[] bArrQ = q(bArr);
        byte[] bArrQ2 = q(bArr2);
        PartialXYZT partialXYZT2 = new PartialXYZT(f87392b);
        XYZT xyzt3 = new XYZT();
        int i4 = 255;
        while (i4 >= 0 && bArrQ[i4] == 0 && bArrQ2[i4] == 0) {
            i4--;
        }
        while (i4 >= 0) {
            g(partialXYZT2, new XYZ(partialXYZT2));
            byte b3 = bArrQ[i4];
            if (b3 > 0) {
                e(partialXYZT2, XYZT.d(xyzt3, partialXYZT2), cachedXYZTArr[bArrQ[i4] / 2]);
            } else if (b3 < 0) {
                r(partialXYZT2, XYZT.d(xyzt3, partialXYZT2), cachedXYZTArr[(-bArrQ[i4]) / 2]);
            }
            byte b4 = bArrQ2[i4];
            if (b4 > 0) {
                e(partialXYZT2, XYZT.d(xyzt3, partialXYZT2), Ed25519Constants.f87409e[bArrQ2[i4] / 2]);
            } else if (b4 < 0) {
                r(partialXYZT2, XYZT.d(xyzt3, partialXYZT2), Ed25519Constants.f87409e[(-bArrQ2[i4]) / 2]);
            }
            i4--;
        }
        return new XYZ(partialXYZT2);
    }

    private static void g(PartialXYZT partialXYZT, XYZ xyz) {
        long[] jArr = new long[10];
        Field25519.k(partialXYZT.f87398a.f87400a, xyz.f87400a);
        Field25519.k(partialXYZT.f87398a.f87402c, xyz.f87401b);
        Field25519.k(partialXYZT.f87399b, xyz.f87402c);
        long[] jArr2 = partialXYZT.f87399b;
        Field25519.n(jArr2, jArr2, jArr2);
        Field25519.n(partialXYZT.f87398a.f87401b, xyz.f87400a, xyz.f87401b);
        Field25519.k(jArr, partialXYZT.f87398a.f87401b);
        XYZ xyz2 = partialXYZT.f87398a;
        Field25519.n(xyz2.f87401b, xyz2.f87402c, xyz2.f87400a);
        XYZ xyz3 = partialXYZT.f87398a;
        long[] jArr3 = xyz3.f87402c;
        Field25519.m(jArr3, jArr3, xyz3.f87400a);
        XYZ xyz4 = partialXYZT.f87398a;
        Field25519.m(xyz4.f87400a, jArr, xyz4.f87401b);
        long[] jArr4 = partialXYZT.f87399b;
        Field25519.m(jArr4, jArr4, partialXYZT.f87398a.f87402c);
    }

    private static void h(PartialXYZT partialXYZT, XYZT xyzt) {
        g(partialXYZT, xyzt.f87403a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int i(long[] jArr) {
        return Field25519.a(jArr)[0] & 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean j(long[] jArr) {
        long[] jArr2 = new long[jArr.length + 1];
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        Field25519.i(jArr2);
        for (byte b3 : Field25519.a(jArr2)) {
            if (b3 != 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean k(byte[] bArr) {
        for (int i3 = 31; i3 >= 0; i3--) {
            int i4 = bArr[i3] & 255;
            int i5 = f87393c[i3] & 255;
            if (i4 != i5) {
                return i4 < i5;
            }
        }
        return false;
    }

    private static long l(byte[] bArr, int i3) {
        return (((long) (bArr[i3 + 2] & 255)) << 16) | (((long) bArr[i3]) & 255) | (((long) (bArr[i3 + 1] & 255)) << 8);
    }

    private static long m(byte[] bArr, int i3) {
        return (((long) (bArr[i3 + 3] & 255)) << 24) | l(bArr, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(long[] jArr, long[] jArr2) {
        for (int i3 = 0; i3 < jArr2.length; i3++) {
            jArr[i3] = -jArr2[i3];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[10];
        long[] jArr4 = new long[10];
        long[] jArr5 = new long[10];
        Field25519.k(jArr3, jArr2);
        Field25519.k(jArr4, jArr3);
        Field25519.k(jArr4, jArr4);
        Field25519.f(jArr4, jArr2, jArr4);
        Field25519.f(jArr3, jArr3, jArr4);
        Field25519.k(jArr3, jArr3);
        Field25519.f(jArr3, jArr4, jArr3);
        Field25519.k(jArr4, jArr3);
        for (int i3 = 1; i3 < 5; i3++) {
            Field25519.k(jArr4, jArr4);
        }
        Field25519.f(jArr3, jArr4, jArr3);
        Field25519.k(jArr4, jArr3);
        for (int i4 = 1; i4 < 10; i4++) {
            Field25519.k(jArr4, jArr4);
        }
        Field25519.f(jArr4, jArr4, jArr3);
        Field25519.k(jArr5, jArr4);
        for (int i5 = 1; i5 < 20; i5++) {
            Field25519.k(jArr5, jArr5);
        }
        Field25519.f(jArr4, jArr5, jArr4);
        Field25519.k(jArr4, jArr4);
        for (int i6 = 1; i6 < 10; i6++) {
            Field25519.k(jArr4, jArr4);
        }
        Field25519.f(jArr3, jArr4, jArr3);
        Field25519.k(jArr4, jArr3);
        for (int i7 = 1; i7 < 50; i7++) {
            Field25519.k(jArr4, jArr4);
        }
        Field25519.f(jArr4, jArr4, jArr3);
        Field25519.k(jArr5, jArr4);
        for (int i8 = 1; i8 < 100; i8++) {
            Field25519.k(jArr5, jArr5);
        }
        Field25519.f(jArr4, jArr5, jArr4);
        Field25519.k(jArr4, jArr4);
        for (int i9 = 1; i9 < 50; i9++) {
            Field25519.k(jArr4, jArr4);
        }
        Field25519.f(jArr3, jArr4, jArr3);
        Field25519.k(jArr3, jArr3);
        Field25519.k(jArr3, jArr3);
        Field25519.f(jArr, jArr3, jArr2);
    }

    private static void p(byte[] bArr) {
        long jL = l(bArr, 0) & 2097151;
        long jM = (m(bArr, 2) >> 5) & 2097151;
        long jL2 = (l(bArr, 5) >> 2) & 2097151;
        long jM2 = (m(bArr, 7) >> 7) & 2097151;
        long jM3 = (m(bArr, 10) >> 4) & 2097151;
        long jL3 = (l(bArr, 13) >> 1) & 2097151;
        long jM4 = (m(bArr, 15) >> 6) & 2097151;
        long jL4 = (l(bArr, 18) >> 3) & 2097151;
        long jL5 = l(bArr, 21) & 2097151;
        long jM5 = (m(bArr, 23) >> 5) & 2097151;
        long jL6 = (l(bArr, 26) >> 2) & 2097151;
        long jM6 = (m(bArr, 28) >> 7) & 2097151;
        long jM7 = (m(bArr, 31) >> 4) & 2097151;
        long jL7 = (l(bArr, 34) >> 1) & 2097151;
        long jM8 = (m(bArr, 36) >> 6) & 2097151;
        long jL8 = (l(bArr, 39) >> 3) & 2097151;
        long jL9 = l(bArr, 42) & 2097151;
        long jM9 = (m(bArr, 44) >> 5) & 2097151;
        long jL10 = (l(bArr, 47) >> 2) & 2097151;
        long jM10 = (m(bArr, 49) >> 7) & 2097151;
        long jM11 = (m(bArr, 52) >> 4) & 2097151;
        long jL11 = (l(bArr, 55) >> 1) & 2097151;
        long jM12 = (m(bArr, 57) >> 6) & 2097151;
        long jM13 = m(bArr, 60) >> 3;
        long j3 = jL9 - (jM13 * 683901);
        long j4 = ((jM8 - (jM13 * 997805)) + (jM12 * 136657)) - (jL11 * 683901);
        long j5 = ((((jM7 + (jM13 * 470296)) + (jM12 * 654183)) - (jL11 * 997805)) + (jM11 * 136657)) - (jM10 * 683901);
        long j6 = jM4 + (jL10 * 666643);
        long j7 = jL4 + (jM10 * 666643) + (jL10 * 470296);
        long j8 = jL5 + (jM11 * 666643) + (jM10 * 470296) + (jL10 * 654183);
        long j9 = (((jM5 + (jL11 * 666643)) + (jM11 * 470296)) + (jM10 * 654183)) - (jL10 * 997805);
        long j10 = ((((jL6 + (jM12 * 666643)) + (jL11 * 470296)) + (jM11 * 654183)) - (jM10 * 997805)) + (jL10 * 136657);
        long j11 = (((((jM6 + (jM13 * 666643)) + (jM12 * 470296)) + (jL11 * 654183)) - (jM11 * 997805)) + (jM10 * 136657)) - (jL10 * 683901);
        long j12 = (j6 + 1048576) >> 21;
        long j13 = j7 + j12;
        long j14 = j6 - (j12 << 21);
        long j15 = (j8 + 1048576) >> 21;
        long j16 = j9 + j15;
        long j17 = j8 - (j15 << 21);
        long j18 = (j10 + 1048576) >> 21;
        long j19 = j11 + j18;
        long j20 = j10 - (j18 << 21);
        long j21 = (j5 + 1048576) >> 21;
        long j22 = ((((jL7 + (jM13 * 654183)) - (jM12 * 997805)) + (jL11 * 136657)) - (jM11 * 683901)) + j21;
        long j23 = j5 - (j21 << 21);
        long j24 = (j4 + 1048576) >> 21;
        long j25 = ((jL8 + (jM13 * 136657)) - (jM12 * 683901)) + j24;
        long j26 = j4 - (j24 << 21);
        long j27 = (j3 + 1048576) >> 21;
        long j28 = jM9 + j27;
        long j29 = j3 - (j27 << 21);
        long j30 = (j13 + 1048576) >> 21;
        long j31 = j17 + j30;
        long j32 = j13 - (j30 << 21);
        long j33 = (j16 + 1048576) >> 21;
        long j34 = j20 + j33;
        long j35 = j16 - (j33 << 21);
        long j36 = (j19 + 1048576) >> 21;
        long j37 = j23 + j36;
        long j38 = j19 - (j36 << 21);
        long j39 = (j22 + 1048576) >> 21;
        long j40 = j26 + j39;
        long j41 = j22 - (j39 << 21);
        long j42 = (j25 + 1048576) >> 21;
        long j43 = j29 + j42;
        long j44 = j25 - (j42 << 21);
        long j45 = j34 - (j28 * 683901);
        long j46 = ((j31 - (j28 * 997805)) + (j43 * 136657)) - (j44 * 683901);
        long j47 = ((((j14 + (j28 * 470296)) + (j43 * 654183)) - (j44 * 997805)) + (j40 * 136657)) - (j41 * 683901);
        long j48 = jL + (j37 * 666643);
        long j49 = jM + (j41 * 666643) + (j37 * 470296);
        long j50 = jL2 + (j40 * 666643) + (j41 * 470296) + (j37 * 654183);
        long j51 = (((jM2 + (j44 * 666643)) + (j40 * 470296)) + (j41 * 654183)) - (j37 * 997805);
        long j52 = ((((jM3 + (j43 * 666643)) + (j44 * 470296)) + (j40 * 654183)) - (j41 * 997805)) + (j37 * 136657);
        long j53 = (((((jL3 + (j28 * 666643)) + (j43 * 470296)) + (j44 * 654183)) - (j40 * 997805)) + (j41 * 136657)) - (j37 * 683901);
        long j54 = (j48 + 1048576) >> 21;
        long j55 = j49 + j54;
        long j56 = j48 - (j54 << 21);
        long j57 = (j50 + 1048576) >> 21;
        long j58 = j51 + j57;
        long j59 = j50 - (j57 << 21);
        long j60 = (j52 + 1048576) >> 21;
        long j61 = j53 + j60;
        long j62 = j52 - (j60 << 21);
        long j63 = (j47 + 1048576) >> 21;
        long j64 = ((((j32 + (j28 * 654183)) - (j43 * 997805)) + (j44 * 136657)) - (j40 * 683901)) + j63;
        long j65 = j47 - (j63 << 21);
        long j66 = (j46 + 1048576) >> 21;
        long j67 = ((j35 + (j28 * 136657)) - (j43 * 683901)) + j66;
        long j68 = j46 - (j66 << 21);
        long j69 = (j45 + 1048576) >> 21;
        long j70 = j38 + j69;
        long j71 = j45 - (j69 << 21);
        long j72 = (j55 + 1048576) >> 21;
        long j73 = j59 + j72;
        long j74 = j55 - (j72 << 21);
        long j75 = (j58 + 1048576) >> 21;
        long j76 = j62 + j75;
        long j77 = j58 - (j75 << 21);
        long j78 = (j61 + 1048576) >> 21;
        long j79 = j65 + j78;
        long j80 = j61 - (j78 << 21);
        long j81 = (j64 + 1048576) >> 21;
        long j82 = j68 + j81;
        long j83 = j64 - (j81 << 21);
        long j84 = (j67 + 1048576) >> 21;
        long j85 = (j70 + 1048576) >> 21;
        long j86 = j70 - (j85 << 21);
        long j87 = j56 + (j85 * 666643);
        long j88 = j74 + (j85 * 470296);
        long j89 = j73 + (j85 * 654183);
        long j90 = j77 - (j85 * 997805);
        long j91 = j76 + (j85 * 136657);
        long j92 = j80 - (j85 * 683901);
        long j93 = j87 >> 21;
        long j94 = j88 + j93;
        long j95 = j87 - (j93 << 21);
        long j96 = j94 >> 21;
        long j97 = j89 + j96;
        long j98 = j94 - (j96 << 21);
        long j99 = j97 >> 21;
        long j100 = j90 + j99;
        long j101 = j97 - (j99 << 21);
        long j102 = j100 >> 21;
        long j103 = j91 + j102;
        long j104 = j100 - (j102 << 21);
        long j105 = j103 >> 21;
        long j106 = j92 + j105;
        long j107 = j103 - (j105 << 21);
        long j108 = j106 >> 21;
        long j109 = j79 + j108;
        long j110 = j106 - (j108 << 21);
        long j111 = j109 >> 21;
        long j112 = j83 + j111;
        long j113 = j109 - (j111 << 21);
        long j114 = j112 >> 21;
        long j115 = j82 + j114;
        long j116 = j112 - (j114 << 21);
        long j117 = j115 >> 21;
        long j118 = (j67 - (j84 << 21)) + j117;
        long j119 = j115 - (j117 << 21);
        long j120 = j118 >> 21;
        long j121 = j71 + j84 + j120;
        long j122 = j118 - (j120 << 21);
        long j123 = j121 >> 21;
        long j124 = j86 + j123;
        long j125 = j121 - (j123 << 21);
        long j126 = j124 >> 21;
        long j127 = j124 - (j126 << 21);
        long j128 = j95 + (666643 * j126);
        long j129 = j98 + (470296 * j126);
        long j130 = j101 + (654183 * j126);
        long j131 = j104 - (997805 * j126);
        long j132 = j107 + (136657 * j126);
        long j133 = j110 - (j126 * 683901);
        long j134 = j128 >> 21;
        long j135 = j129 + j134;
        long j136 = j128 - (j134 << 21);
        long j137 = j135 >> 21;
        long j138 = j130 + j137;
        long j139 = j135 - (j137 << 21);
        long j140 = j138 >> 21;
        long j141 = j131 + j140;
        long j142 = j138 - (j140 << 21);
        long j143 = j141 >> 21;
        long j144 = j132 + j143;
        long j145 = j141 - (j143 << 21);
        long j146 = j144 >> 21;
        long j147 = j133 + j146;
        long j148 = j144 - (j146 << 21);
        long j149 = j147 >> 21;
        long j150 = j113 + j149;
        long j151 = j147 - (j149 << 21);
        long j152 = j150 >> 21;
        long j153 = j116 + j152;
        long j154 = j150 - (j152 << 21);
        long j155 = j153 >> 21;
        long j156 = j119 + j155;
        long j157 = j153 - (j155 << 21);
        long j158 = j156 >> 21;
        long j159 = j122 + j158;
        long j160 = j156 - (j158 << 21);
        long j161 = j159 >> 21;
        long j162 = j125 + j161;
        long j163 = j159 - (j161 << 21);
        long j164 = j162 >> 21;
        long j165 = j127 + j164;
        long j166 = j162 - (j164 << 21);
        bArr[0] = (byte) j136;
        bArr[1] = (byte) (j136 >> 8);
        bArr[2] = (byte) ((j136 >> 16) | (j139 << 5));
        bArr[3] = (byte) (j139 >> 3);
        bArr[4] = (byte) (j139 >> 11);
        bArr[5] = (byte) ((j139 >> 19) | (j142 << 2));
        bArr[6] = (byte) (j142 >> 6);
        bArr[7] = (byte) ((j142 >> 14) | (j145 << 7));
        bArr[8] = (byte) (j145 >> 1);
        bArr[9] = (byte) (j145 >> 9);
        bArr[10] = (byte) ((j145 >> 17) | (j148 << 4));
        bArr[11] = (byte) (j148 >> 4);
        bArr[12] = (byte) (j148 >> 12);
        bArr[13] = (byte) ((j148 >> 20) | (j151 << 1));
        bArr[14] = (byte) (j151 >> 7);
        bArr[15] = (byte) ((j151 >> 15) | (j154 << 6));
        bArr[16] = (byte) (j154 >> 2);
        bArr[17] = (byte) (j154 >> 10);
        bArr[18] = (byte) ((j154 >> 18) | (j157 << 3));
        bArr[19] = (byte) (j157 >> 5);
        bArr[20] = (byte) (j157 >> 13);
        bArr[21] = (byte) j160;
        bArr[22] = (byte) (j160 >> 8);
        bArr[23] = (byte) ((j160 >> 16) | (j163 << 5));
        bArr[24] = (byte) (j163 >> 3);
        bArr[25] = (byte) (j163 >> 11);
        bArr[26] = (byte) ((j163 >> 19) | (j166 << 2));
        bArr[27] = (byte) (j166 >> 6);
        bArr[28] = (byte) ((j166 >> 14) | (j165 << 7));
        bArr[29] = (byte) (j165 >> 1);
        bArr[30] = (byte) (j165 >> 9);
        bArr[31] = (byte) (j165 >> 17);
    }

    private static byte[] q(byte[] bArr) {
        int i3;
        byte[] bArr2 = new byte[Function.MAX_NARGS];
        for (int i4 = 0; i4 < 256; i4++) {
            bArr2[i4] = (byte) (1 & ((bArr[i4 >> 3] & 255) >> (i4 & 7)));
        }
        for (int i5 = 0; i5 < 256; i5++) {
            if (bArr2[i5] != 0) {
                for (int i6 = 1; i6 <= 6 && (i3 = i5 + i6) < 256; i6++) {
                    byte b3 = bArr2[i3];
                    if (b3 != 0) {
                        byte b4 = bArr2[i5];
                        if ((b3 << i6) + b4 <= 15) {
                            bArr2[i5] = (byte) (b4 + (b3 << i6));
                            bArr2[i3] = 0;
                        } else if (b4 - (b3 << i6) >= -15) {
                            bArr2[i5] = (byte) (b4 - (b3 << i6));
                            while (true) {
                                if (i3 >= 256) {
                                    break;
                                }
                                if (bArr2[i3] == 0) {
                                    bArr2[i3] = 1;
                                    break;
                                }
                                bArr2[i3] = 0;
                                i3++;
                            }
                        }
                    }
                }
            }
        }
        return bArr2;
    }

    private static void r(PartialXYZT partialXYZT, XYZT xyzt, CachedXYT cachedXYT) {
        long[] jArr = new long[10];
        long[] jArr2 = partialXYZT.f87398a.f87400a;
        XYZ xyz = xyzt.f87403a;
        Field25519.n(jArr2, xyz.f87401b, xyz.f87400a);
        long[] jArr3 = partialXYZT.f87398a.f87401b;
        XYZ xyz2 = xyzt.f87403a;
        Field25519.m(jArr3, xyz2.f87401b, xyz2.f87400a);
        long[] jArr4 = partialXYZT.f87398a.f87401b;
        Field25519.f(jArr4, jArr4, cachedXYT.f87394a);
        XYZ xyz3 = partialXYZT.f87398a;
        Field25519.f(xyz3.f87402c, xyz3.f87400a, cachedXYT.f87395b);
        Field25519.f(partialXYZT.f87399b, xyzt.f87404b, cachedXYT.f87396c);
        cachedXYT.a(partialXYZT.f87398a.f87400a, xyzt.f87403a.f87402c);
        long[] jArr5 = partialXYZT.f87398a.f87400a;
        Field25519.n(jArr, jArr5, jArr5);
        XYZ xyz4 = partialXYZT.f87398a;
        Field25519.m(xyz4.f87400a, xyz4.f87402c, xyz4.f87401b);
        XYZ xyz5 = partialXYZT.f87398a;
        long[] jArr6 = xyz5.f87401b;
        Field25519.n(jArr6, xyz5.f87402c, jArr6);
        Field25519.m(partialXYZT.f87398a.f87402c, jArr, partialXYZT.f87399b);
        long[] jArr7 = partialXYZT.f87399b;
        Field25519.n(jArr7, jArr, jArr7);
    }

    static boolean s(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr2.length != 64) {
            return false;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr2, 32, 64);
        if (!k(bArrCopyOfRange)) {
            return false;
        }
        MessageDigest messageDigest = (MessageDigest) EngineFactory.f87435e.a("SHA-512");
        messageDigest.update(bArr2, 0, 32);
        messageDigest.update(bArr3);
        messageDigest.update(bArr);
        byte[] bArrDigest = messageDigest.digest();
        p(bArrDigest);
        byte[] bArrB = f(bArrDigest, XYZT.c(bArr3), bArrCopyOfRange).b();
        for (int i3 = 0; i3 < 32; i3++) {
            if (bArrB[i3] != bArr2[i3]) {
                return false;
            }
        }
        return true;
    }
}
