package com.google.common.hash;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class Fingerprint2011 extends AbstractNonStreamingHashFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final HashFunction f85083a = new Fingerprint2011();

    Fingerprint2011() {
    }

    static long f(byte[] bArr, int i3, int i4) {
        long jH = h((i4 <= 32 ? j(bArr, i3, i4, -1397348546323613475L) : i4 <= 64 ? i(bArr, i3, i4) : g(bArr, i3, i4)) + (i4 >= 9 ? LittleEndianByteArray.b(bArr, (i3 + i4) - 8) : -6505348102511208375L), i4 >= 8 ? LittleEndianByteArray.b(bArr, i3) : -6505348102511208375L);
        return (jH == 0 || jH == 1) ? jH - 2 : jH;
    }

    private static long g(byte[] bArr, int i3, int i4) {
        byte[] bArr2 = bArr;
        long jB = LittleEndianByteArray.b(bArr, i3);
        int i5 = i3 + i4;
        long jB2 = LittleEndianByteArray.b(bArr2, i5 - 16) ^ (-8261664234251669945L);
        long jB3 = (-6505348102511208375L) ^ LittleEndianByteArray.b(bArr2, i5 - 56);
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long j3 = i4;
        l(bArr2, i5 - 64, j3, jB2, jArr);
        l(bArr2, i5 - 32, j3 * (-8261664234251669945L), -6505348102511208375L, jArr2);
        long[] jArr3 = jArr2;
        long jK = jB3 + (k(jArr[1]) * (-8261664234251669945L));
        long jRotateRight = Long.rotateRight(jB + jK, 39) * (-8261664234251669945L);
        int i6 = (i4 - 1) & (-64);
        long jRotateRight2 = Long.rotateRight(jB2, 33) * (-8261664234251669945L);
        long j4 = jRotateRight;
        int i7 = i3;
        while (true) {
            long jRotateRight3 = Long.rotateRight(j4 + jRotateRight2 + jArr[0] + LittleEndianByteArray.b(bArr2, i7 + 16), 37) * (-8261664234251669945L);
            long jRotateRight4 = Long.rotateRight(jRotateRight2 + jArr[1] + LittleEndianByteArray.b(bArr2, i7 + 48), 42) * (-8261664234251669945L);
            long j5 = jArr3[1] ^ jRotateRight3;
            long j6 = jRotateRight4 ^ jArr[0];
            long jRotateRight5 = Long.rotateRight(jArr3[0] ^ jK, 33);
            l(bArr2, i7, jArr[1] * (-8261664234251669945L), jArr3[0] + j5, jArr);
            int i8 = i7;
            long[] jArr4 = jArr3;
            jRotateRight2 = j6;
            l(bArr, i8 + 32, jArr3[1] + jRotateRight5, jRotateRight2, jArr4);
            i7 = i8 + 64;
            i6 -= 64;
            if (i6 == 0) {
                return h(h(jArr[0], jArr4[0]) + (k(jRotateRight2) * (-8261664234251669945L)) + j5, h(jArr[1], jArr4[1]) + jRotateRight5);
            }
            bArr2 = bArr;
            jArr3 = jArr4;
            j4 = jRotateRight5;
            jK = j5;
        }
    }

    static long h(long j3, long j4) {
        long j5 = (j4 ^ j3) * (-4132994306676758123L);
        long j6 = (j3 ^ (j5 ^ (j5 >>> 47))) * (-4132994306676758123L);
        return (j6 ^ (j6 >>> 47)) * (-4132994306676758123L);
    }

    private static long i(byte[] bArr, int i3, int i4) {
        long jB = LittleEndianByteArray.b(bArr, i3 + 24);
        int i5 = i3 + i4;
        int i6 = i5 - 16;
        long jB2 = LittleEndianByteArray.b(bArr, i3) + ((((long) i4) + LittleEndianByteArray.b(bArr, i6)) * (-6505348102511208375L));
        long jRotateRight = Long.rotateRight(jB2 + jB, 52);
        long jRotateRight2 = Long.rotateRight(jB2, 37);
        long jB3 = jB2 + LittleEndianByteArray.b(bArr, i3 + 8);
        long jRotateRight3 = jRotateRight2 + Long.rotateRight(jB3, 7);
        int i7 = i3 + 16;
        long jB4 = jB3 + LittleEndianByteArray.b(bArr, i7);
        long j3 = jB + jB4;
        long jRotateRight4 = jRotateRight + Long.rotateRight(jB4, 31) + jRotateRight3;
        long jB5 = LittleEndianByteArray.b(bArr, i7) + LittleEndianByteArray.b(bArr, i5 - 32);
        long jB6 = LittleEndianByteArray.b(bArr, i5 - 8);
        long jRotateRight5 = Long.rotateRight(jB5 + jB6, 52);
        long jRotateRight6 = Long.rotateRight(jB5, 37);
        long jB7 = jB5 + LittleEndianByteArray.b(bArr, i5 - 24);
        long jRotateRight7 = jRotateRight6 + Long.rotateRight(jB7, 7);
        long jB8 = jB7 + LittleEndianByteArray.b(bArr, i6);
        return k((k(((j3 + jRotateRight5 + Long.rotateRight(jB8, 31) + jRotateRight7) * (-4288712594273399085L)) + ((jB6 + jB8 + jRotateRight4) * (-6505348102511208375L))) * (-6505348102511208375L)) + jRotateRight4) * (-4288712594273399085L);
    }

    static long j(byte[] bArr, int i3, int i4, long j3) {
        int i5 = i4 & (-8);
        int i6 = i4 & 7;
        long jC = j3 ^ (((long) i4) * (-4132994306676758123L));
        for (int i7 = 0; i7 < i5; i7 += 8) {
            jC = (jC ^ (k(LittleEndianByteArray.b(bArr, i3 + i7) * (-4132994306676758123L)) * (-4132994306676758123L))) * (-4132994306676758123L);
        }
        if (i6 != 0) {
            jC = (LittleEndianByteArray.c(bArr, i3 + i5, i6) ^ jC) * (-4132994306676758123L);
        }
        return k(k(jC) * (-4132994306676758123L));
    }

    private static long k(long j3) {
        return j3 ^ (j3 >>> 47);
    }

    private static void l(byte[] bArr, int i3, long j3, long j4, long[] jArr) {
        long jB = LittleEndianByteArray.b(bArr, i3);
        long jB2 = LittleEndianByteArray.b(bArr, i3 + 8);
        long jB3 = LittleEndianByteArray.b(bArr, i3 + 16);
        long jB4 = LittleEndianByteArray.b(bArr, i3 + 24);
        long j5 = j3 + jB;
        long j6 = jB2 + j5 + jB3;
        long jRotateRight = Long.rotateRight(j4 + j5 + jB4, 51) + Long.rotateRight(j6, 23);
        jArr[0] = j6 + jB4;
        jArr[1] = jRotateRight + j5;
    }

    @Override // com.google.common.hash.HashFunction
    public int a() {
        return 64;
    }

    @Override // com.google.common.hash.AbstractNonStreamingHashFunction
    public HashCode d(byte[] bArr, int i3, int i4) {
        Preconditions.y(i3, i3 + i4, bArr.length);
        return HashCode.h(f(bArr, i3, i4));
    }

    public String toString() {
        return "Hashing.fingerprint2011()";
    }
}
