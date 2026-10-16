package com.google.common.hash;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class FarmHashFingerprint64 extends AbstractNonStreamingHashFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final HashFunction f85082a = new FarmHashFingerprint64();

    FarmHashFingerprint64() {
    }

    static long f(byte[] bArr, int i3, int i4) {
        return i4 <= 32 ? i4 <= 16 ? g(bArr, i3, i4) : i(bArr, i3, i4) : i4 <= 64 ? j(bArr, i3, i4) : k(bArr, i3, i4);
    }

    private static long g(byte[] bArr, int i3, int i4) {
        if (i4 >= 8) {
            long j3 = (((long) i4) * 2) - 7286425919675154353L;
            long jB = LittleEndianByteArray.b(bArr, i3) - 7286425919675154353L;
            long jB2 = LittleEndianByteArray.b(bArr, (i3 + i4) - 8);
            return h((Long.rotateRight(jB2, 37) * j3) + jB, (Long.rotateRight(jB, 25) + jB2) * j3, j3);
        }
        if (i4 >= 4) {
            return h(((long) i4) + ((((long) LittleEndianByteArray.a(bArr, i3)) & 4294967295L) << 3), ((long) LittleEndianByteArray.a(bArr, (i3 + i4) - 4)) & 4294967295L, ((long) (i4 * 2)) - 7286425919675154353L);
        }
        if (i4 <= 0) {
            return -7286425919675154353L;
        }
        return l((((long) ((bArr[i3] & 255) + ((bArr[(i4 >> 1) + i3] & 255) << 8))) * (-7286425919675154353L)) ^ (((long) (i4 + ((bArr[i3 + (i4 - 1)] & 255) << 2))) * (-4348849565147123417L))) * (-7286425919675154353L);
    }

    private static long h(long j3, long j4, long j5) {
        long j6 = (j3 ^ j4) * j5;
        long j7 = ((j6 ^ (j6 >>> 47)) ^ j4) * j5;
        return (j7 ^ (j7 >>> 47)) * j5;
    }

    private static long i(byte[] bArr, int i3, int i4) {
        long j3 = (((long) i4) * 2) - 7286425919675154353L;
        long jB = LittleEndianByteArray.b(bArr, i3) * (-5435081209227447693L);
        long jB2 = LittleEndianByteArray.b(bArr, i3 + 8);
        int i5 = i3 + i4;
        long jB3 = LittleEndianByteArray.b(bArr, i5 - 8) * j3;
        return h(Long.rotateRight(jB + jB2, 43) + Long.rotateRight(jB3, 30) + (LittleEndianByteArray.b(bArr, i5 - 16) * (-7286425919675154353L)), jB3 + jB + Long.rotateRight(jB2 - 7286425919675154353L, 18), j3);
    }

    private static long j(byte[] bArr, int i3, int i4) {
        long j3 = (((long) i4) * 2) - 7286425919675154353L;
        long jB = LittleEndianByteArray.b(bArr, i3) * (-7286425919675154353L);
        long jB2 = LittleEndianByteArray.b(bArr, i3 + 8);
        int i5 = i3 + i4;
        long jB3 = LittleEndianByteArray.b(bArr, i5 - 8) * j3;
        long jRotateRight = Long.rotateRight(jB + jB2, 43) + Long.rotateRight(jB3, 30) + (LittleEndianByteArray.b(bArr, i5 - 16) * (-7286425919675154353L));
        long jH = h(jRotateRight, jB3 + Long.rotateRight(jB2 - 7286425919675154353L, 18) + jB, j3);
        long jB4 = LittleEndianByteArray.b(bArr, i3 + 16) * j3;
        long jB5 = LittleEndianByteArray.b(bArr, i3 + 24);
        long jB6 = (jRotateRight + LittleEndianByteArray.b(bArr, i5 - 32)) * j3;
        return h(Long.rotateRight(jB4 + jB5, 43) + Long.rotateRight(jB6, 30) + ((jH + LittleEndianByteArray.b(bArr, i5 - 24)) * j3), jB4 + Long.rotateRight(jB + jB5, 18) + jB6, j3);
    }

    private static long k(byte[] bArr, int i3, int i4) {
        byte[] bArr2 = bArr;
        long j3 = 81;
        long j4 = -5435081209227447693L;
        long j5 = (j3 * (-5435081209227447693L)) + 113;
        long jL = l((j5 * (-7286425919675154353L)) + 113) * (-7286425919675154353L);
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        char c3 = 1;
        int i5 = i4 - 1;
        int i6 = i3 + ((i5 / 64) * 64);
        int i7 = i5 & 63;
        int i8 = i6 + i7;
        int i9 = i8 - 63;
        long j6 = j5;
        long jB = (j3 * (-7286425919675154353L)) + LittleEndianByteArray.b(bArr, i3);
        int i10 = i3;
        while (true) {
            long j7 = j4;
            long jRotateRight = Long.rotateRight(jB + j6 + jArr[0] + LittleEndianByteArray.b(bArr2, i10 + 8), 37) * j7;
            long jRotateRight2 = Long.rotateRight(j6 + jArr[c3] + LittleEndianByteArray.b(bArr2, i10 + 48), 42) * j7;
            long j8 = jRotateRight ^ jArr2[c3];
            char c4 = c3;
            long jB2 = jRotateRight2 + jArr[0] + LittleEndianByteArray.b(bArr2, i10 + 40);
            long jRotateRight3 = Long.rotateRight(jL + jArr2[0], 33) * j7;
            m(bArr2, i10, jArr[c4] * j7, j8 + jArr2[0], jArr);
            int i11 = i10;
            long[] jArr3 = jArr;
            m(bArr2, i11 + 32, jArr2[c4] + jRotateRight3, jB2 + LittleEndianByteArray.b(bArr2, i11 + 16), jArr2);
            i10 = i11 + 64;
            if (i10 == i6) {
                long j9 = ((j8 & 255) << c4) + j7;
                long j10 = jArr2[0] + ((long) i7);
                jArr2[0] = j10;
                long j11 = jArr3[0] + j10;
                jArr3[0] = j11;
                jArr2[0] = jArr2[0] + j11;
                long jRotateRight4 = Long.rotateRight(jRotateRight3 + jB2 + jArr3[0] + LittleEndianByteArray.b(bArr2, i8 - 55), 37) * j9;
                long jRotateRight5 = Long.rotateRight(jB2 + jArr3[c4] + LittleEndianByteArray.b(bArr2, i8 - 15), 42) * j9;
                long j12 = jRotateRight4 ^ (jArr2[c4] * 9);
                long jB3 = jRotateRight5 + (jArr3[0] * 9) + LittleEndianByteArray.b(bArr2, i8 - 23);
                long jRotateRight6 = Long.rotateRight(j8 + jArr2[0], 33) * j9;
                m(bArr2, i9, jArr3[c4] * j9, jArr2[0] + j12, jArr3);
                m(bArr2, i8 - 31, jArr2[c4] + jRotateRight6, LittleEndianByteArray.b(bArr2, i8 - 47) + jB3, jArr2);
                return h(h(jArr3[0], jArr2[0], j9) + (l(jB3) * (-4348849565147123417L)) + j12, h(jArr3[c4], jArr2[c4], j9) + jRotateRight6, j9);
            }
            bArr2 = bArr;
            jB = jRotateRight3;
            j4 = j7;
            jL = j8;
            c3 = c4;
            j6 = jB2;
            jArr = jArr3;
        }
    }

    private static long l(long j3) {
        return j3 ^ (j3 >>> 47);
    }

    private static void m(byte[] bArr, int i3, long j3, long j4, long[] jArr) {
        long jB = LittleEndianByteArray.b(bArr, i3);
        long jB2 = LittleEndianByteArray.b(bArr, i3 + 8);
        long jB3 = LittleEndianByteArray.b(bArr, i3 + 16);
        long jB4 = LittleEndianByteArray.b(bArr, i3 + 24);
        long j5 = j3 + jB;
        long j6 = jB2 + j5 + jB3;
        long jRotateRight = Long.rotateRight(j4 + j5 + jB4, 21) + Long.rotateRight(j6, 44);
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
        return "Hashing.farmHashFingerprint64()";
    }
}
