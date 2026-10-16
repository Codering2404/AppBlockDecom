package com.google.crypto.tink.subtle;

import com.google.crypto.tink.subtle.Ed25519;
import java.lang.reflect.Array;
import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class Ed25519Constants {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final long[] f87405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final long[] f87406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final long[] f87407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Ed25519.CachedXYT[][] f87408d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final Ed25519.CachedXYT[] f87409e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final BigInteger f87410f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final BigInteger f87411g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final BigInteger f87412h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final BigInteger f87413i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Point {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private BigInteger f87414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private BigInteger f87415b;

        private Point() {
        }
    }

    static {
        BigInteger bigIntegerSubtract = BigInteger.valueOf(2L).pow(255).subtract(BigInteger.valueOf(19L));
        f87410f = bigIntegerSubtract;
        BigInteger bigIntegerMod = BigInteger.valueOf(-121665L).multiply(BigInteger.valueOf(121666L).modInverse(bigIntegerSubtract)).mod(bigIntegerSubtract);
        f87411g = bigIntegerMod;
        BigInteger bigIntegerMod2 = BigInteger.valueOf(2L).multiply(bigIntegerMod).mod(bigIntegerSubtract);
        f87412h = bigIntegerMod2;
        BigInteger bigIntegerModPow = BigInteger.valueOf(2L).modPow(bigIntegerSubtract.subtract(BigInteger.ONE).divide(BigInteger.valueOf(4L)), bigIntegerSubtract);
        f87413i = bigIntegerModPow;
        Point point = new Point();
        point.f87415b = BigInteger.valueOf(4L).multiply(BigInteger.valueOf(5L).modInverse(bigIntegerSubtract)).mod(bigIntegerSubtract);
        point.f87414a = c(point.f87415b);
        f87405a = Field25519.c(d(bigIntegerMod));
        f87406b = Field25519.c(d(bigIntegerMod2));
        f87407c = Field25519.c(d(bigIntegerModPow));
        f87408d = (Ed25519.CachedXYT[][]) Array.newInstance((Class<?>) Ed25519.CachedXYT.class, 32, 8);
        Point pointA = point;
        for (int i3 = 0; i3 < 32; i3++) {
            Point pointA2 = pointA;
            for (int i4 = 0; i4 < 8; i4++) {
                f87408d[i3][i4] = b(pointA2);
                pointA2 = a(pointA2, pointA);
            }
            for (int i5 = 0; i5 < 8; i5++) {
                pointA = a(pointA, pointA);
            }
        }
        Point pointA3 = a(point, point);
        f87409e = new Ed25519.CachedXYT[8];
        for (int i6 = 0; i6 < 8; i6++) {
            f87409e[i6] = b(point);
            point = a(point, pointA3);
        }
    }

    private static Point a(Point point, Point point2) {
        Point point3 = new Point();
        BigInteger bigIntegerMultiply = f87411g.multiply(point.f87414a.multiply(point2.f87414a).multiply(point.f87415b).multiply(point2.f87415b));
        BigInteger bigInteger = f87410f;
        BigInteger bigIntegerMod = bigIntegerMultiply.mod(bigInteger);
        BigInteger bigIntegerAdd = point.f87414a.multiply(point2.f87415b).add(point2.f87414a.multiply(point.f87415b));
        BigInteger bigInteger2 = BigInteger.ONE;
        point3.f87414a = bigIntegerAdd.multiply(bigInteger2.add(bigIntegerMod).modInverse(bigInteger)).mod(bigInteger);
        point3.f87415b = point.f87415b.multiply(point2.f87415b).add(point.f87414a.multiply(point2.f87414a)).multiply(bigInteger2.subtract(bigIntegerMod).modInverse(bigInteger)).mod(bigInteger);
        return point3;
    }

    private static Ed25519.CachedXYT b(Point point) {
        BigInteger bigIntegerAdd = point.f87415b.add(point.f87414a);
        BigInteger bigInteger = f87410f;
        return new Ed25519.CachedXYT(Field25519.c(d(bigIntegerAdd.mod(bigInteger))), Field25519.c(d(point.f87415b.subtract(point.f87414a).mod(bigInteger))), Field25519.c(d(f87412h.multiply(point.f87414a).multiply(point.f87415b).mod(bigInteger))));
    }

    private static BigInteger c(BigInteger bigInteger) {
        BigInteger bigIntegerPow = bigInteger.pow(2);
        BigInteger bigInteger2 = BigInteger.ONE;
        BigInteger bigIntegerSubtract = bigIntegerPow.subtract(bigInteger2);
        BigInteger bigIntegerAdd = f87411g.multiply(bigInteger.pow(2)).add(bigInteger2);
        BigInteger bigInteger3 = f87410f;
        BigInteger bigIntegerMultiply = bigIntegerSubtract.multiply(bigIntegerAdd.modInverse(bigInteger3));
        BigInteger bigIntegerModPow = bigIntegerMultiply.modPow(bigInteger3.add(BigInteger.valueOf(3L)).divide(BigInteger.valueOf(8L)), bigInteger3);
        if (!bigIntegerModPow.pow(2).subtract(bigIntegerMultiply).mod(bigInteger3).equals(BigInteger.ZERO)) {
            bigIntegerModPow = bigIntegerModPow.multiply(f87413i).mod(bigInteger3);
        }
        return bigIntegerModPow.testBit(0) ? bigInteger3.subtract(bigIntegerModPow) : bigIntegerModPow;
    }

    private static byte[] d(BigInteger bigInteger) {
        byte[] bArr = new byte[32];
        byte[] byteArray = bigInteger.toByteArray();
        System.arraycopy(byteArray, 0, bArr, 32 - byteArray.length, byteArray.length);
        for (int i3 = 0; i3 < 16; i3++) {
            byte b3 = bArr[i3];
            int i4 = 31 - i3;
            bArr[i3] = bArr[i4];
            bArr[i4] = b3;
        }
        return bArr;
    }
}
