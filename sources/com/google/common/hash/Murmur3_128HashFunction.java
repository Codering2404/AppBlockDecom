package com.google.common.hash;

import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.Immutable;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@ElementTypesAreNonnullByDefault
final class Murmur3_128HashFunction extends AbstractHashFunction implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final HashFunction f85138b = new Murmur3_128HashFunction(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final HashFunction f85139c = new Murmur3_128HashFunction(Hashing.f85100a);
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f85140a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Murmur3_128Hasher extends AbstractStreamingHasher {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f85141d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f85142e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f85143f;

        Murmur3_128Hasher(int i3) {
            super(16);
            long j3 = i3;
            this.f85141d = j3;
            this.f85142e = j3;
            this.f85143f = 0;
        }

        private void q(long j3, long j4) {
            long jS = s(j3) ^ this.f85141d;
            this.f85141d = jS;
            long jRotateLeft = Long.rotateLeft(jS, 27);
            long j5 = this.f85142e;
            this.f85141d = ((jRotateLeft + j5) * 5) + 1390208809;
            long jT = t(j4) ^ j5;
            this.f85142e = jT;
            this.f85142e = ((Long.rotateLeft(jT, 31) + this.f85141d) * 5) + 944331445;
        }

        private static long r(long j3) {
            long j4 = (j3 ^ (j3 >>> 33)) * (-49064778989728563L);
            long j5 = (j4 ^ (j4 >>> 33)) * (-4265267296055464877L);
            return j5 ^ (j5 >>> 33);
        }

        private static long s(long j3) {
            return Long.rotateLeft(j3 * (-8663945395140668459L), 31) * 5545529020109919103L;
        }

        private static long t(long j3) {
            return Long.rotateLeft(j3 * 5545529020109919103L, 33) * (-8663945395140668459L);
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected HashCode k() {
            long j3 = this.f85141d;
            int i3 = this.f85143f;
            long j4 = j3 ^ ((long) i3);
            long j5 = this.f85142e ^ ((long) i3);
            long j6 = j4 + j5;
            this.f85141d = j6;
            this.f85142e = j5 + j6;
            this.f85141d = r(j6);
            long jR = r(this.f85142e);
            long j7 = this.f85141d + jR;
            this.f85141d = j7;
            this.f85142e = jR + j7;
            return HashCode.f(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f85141d).putLong(this.f85142e).array());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void n(ByteBuffer byteBuffer) {
            q(byteBuffer.getLong(), byteBuffer.getLong());
            this.f85143f += 16;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void o(ByteBuffer byteBuffer) {
            long jD;
            long jD2;
            long jD3;
            long jD4;
            long jD5;
            long jD6;
            long jD7;
            this.f85143f += byteBuffer.remaining();
            long jD8 = 0;
            switch (byteBuffer.remaining()) {
                case 1:
                    jD = 0;
                    jD7 = jD ^ ((long) UnsignedBytes.d(byteBuffer.get(0)));
                    this.f85141d = s(jD7) ^ this.f85141d;
                    this.f85142e ^= t(jD8);
                    return;
                case 2:
                    jD2 = 0;
                    jD = jD2 ^ (((long) UnsignedBytes.d(byteBuffer.get(1))) << 8);
                    jD7 = jD ^ ((long) UnsignedBytes.d(byteBuffer.get(0)));
                    this.f85141d = s(jD7) ^ this.f85141d;
                    this.f85142e ^= t(jD8);
                    return;
                case 3:
                    jD3 = 0;
                    jD2 = (((long) UnsignedBytes.d(byteBuffer.get(2))) << 16) ^ jD3;
                    jD = jD2 ^ (((long) UnsignedBytes.d(byteBuffer.get(1))) << 8);
                    jD7 = jD ^ ((long) UnsignedBytes.d(byteBuffer.get(0)));
                    this.f85141d = s(jD7) ^ this.f85141d;
                    this.f85142e ^= t(jD8);
                    return;
                case 4:
                    jD4 = 0;
                    jD3 = jD4 ^ (((long) UnsignedBytes.d(byteBuffer.get(3))) << 24);
                    jD2 = (((long) UnsignedBytes.d(byteBuffer.get(2))) << 16) ^ jD3;
                    jD = jD2 ^ (((long) UnsignedBytes.d(byteBuffer.get(1))) << 8);
                    jD7 = jD ^ ((long) UnsignedBytes.d(byteBuffer.get(0)));
                    this.f85141d = s(jD7) ^ this.f85141d;
                    this.f85142e ^= t(jD8);
                    return;
                case 5:
                    jD5 = 0;
                    jD4 = jD5 ^ (((long) UnsignedBytes.d(byteBuffer.get(4))) << 32);
                    jD3 = jD4 ^ (((long) UnsignedBytes.d(byteBuffer.get(3))) << 24);
                    jD2 = (((long) UnsignedBytes.d(byteBuffer.get(2))) << 16) ^ jD3;
                    jD = jD2 ^ (((long) UnsignedBytes.d(byteBuffer.get(1))) << 8);
                    jD7 = jD ^ ((long) UnsignedBytes.d(byteBuffer.get(0)));
                    this.f85141d = s(jD7) ^ this.f85141d;
                    this.f85142e ^= t(jD8);
                    return;
                case 6:
                    jD6 = 0;
                    jD5 = (((long) UnsignedBytes.d(byteBuffer.get(5))) << 40) ^ jD6;
                    jD4 = jD5 ^ (((long) UnsignedBytes.d(byteBuffer.get(4))) << 32);
                    jD3 = jD4 ^ (((long) UnsignedBytes.d(byteBuffer.get(3))) << 24);
                    jD2 = (((long) UnsignedBytes.d(byteBuffer.get(2))) << 16) ^ jD3;
                    jD = jD2 ^ (((long) UnsignedBytes.d(byteBuffer.get(1))) << 8);
                    jD7 = jD ^ ((long) UnsignedBytes.d(byteBuffer.get(0)));
                    this.f85141d = s(jD7) ^ this.f85141d;
                    this.f85142e ^= t(jD8);
                    return;
                case 7:
                    jD6 = ((long) UnsignedBytes.d(byteBuffer.get(6))) << 48;
                    jD5 = (((long) UnsignedBytes.d(byteBuffer.get(5))) << 40) ^ jD6;
                    jD4 = jD5 ^ (((long) UnsignedBytes.d(byteBuffer.get(4))) << 32);
                    jD3 = jD4 ^ (((long) UnsignedBytes.d(byteBuffer.get(3))) << 24);
                    jD2 = (((long) UnsignedBytes.d(byteBuffer.get(2))) << 16) ^ jD3;
                    jD = jD2 ^ (((long) UnsignedBytes.d(byteBuffer.get(1))) << 8);
                    jD7 = jD ^ ((long) UnsignedBytes.d(byteBuffer.get(0)));
                    this.f85141d = s(jD7) ^ this.f85141d;
                    this.f85142e ^= t(jD8);
                    return;
                case 8:
                    jD7 = byteBuffer.getLong();
                    this.f85141d = s(jD7) ^ this.f85141d;
                    this.f85142e ^= t(jD8);
                    return;
                case 9:
                    jD8 ^= (long) UnsignedBytes.d(byteBuffer.get(8));
                    jD7 = byteBuffer.getLong();
                    this.f85141d = s(jD7) ^ this.f85141d;
                    this.f85142e ^= t(jD8);
                    return;
                case 10:
                    jD8 ^= ((long) UnsignedBytes.d(byteBuffer.get(9))) << 8;
                    jD8 ^= (long) UnsignedBytes.d(byteBuffer.get(8));
                    jD7 = byteBuffer.getLong();
                    this.f85141d = s(jD7) ^ this.f85141d;
                    this.f85142e ^= t(jD8);
                    return;
                case 11:
                    jD8 ^= ((long) UnsignedBytes.d(byteBuffer.get(10))) << 16;
                    jD8 ^= ((long) UnsignedBytes.d(byteBuffer.get(9))) << 8;
                    jD8 ^= (long) UnsignedBytes.d(byteBuffer.get(8));
                    jD7 = byteBuffer.getLong();
                    this.f85141d = s(jD7) ^ this.f85141d;
                    this.f85142e ^= t(jD8);
                    return;
                case 12:
                    jD8 ^= ((long) UnsignedBytes.d(byteBuffer.get(11))) << 24;
                    jD8 ^= ((long) UnsignedBytes.d(byteBuffer.get(10))) << 16;
                    jD8 ^= ((long) UnsignedBytes.d(byteBuffer.get(9))) << 8;
                    jD8 ^= (long) UnsignedBytes.d(byteBuffer.get(8));
                    jD7 = byteBuffer.getLong();
                    this.f85141d = s(jD7) ^ this.f85141d;
                    this.f85142e ^= t(jD8);
                    return;
                case 13:
                    jD8 ^= ((long) UnsignedBytes.d(byteBuffer.get(12))) << 32;
                    jD8 ^= ((long) UnsignedBytes.d(byteBuffer.get(11))) << 24;
                    jD8 ^= ((long) UnsignedBytes.d(byteBuffer.get(10))) << 16;
                    jD8 ^= ((long) UnsignedBytes.d(byteBuffer.get(9))) << 8;
                    jD8 ^= (long) UnsignedBytes.d(byteBuffer.get(8));
                    jD7 = byteBuffer.getLong();
                    this.f85141d = s(jD7) ^ this.f85141d;
                    this.f85142e ^= t(jD8);
                    return;
                case 14:
                    jD8 ^= ((long) UnsignedBytes.d(byteBuffer.get(13))) << 40;
                    jD8 ^= ((long) UnsignedBytes.d(byteBuffer.get(12))) << 32;
                    jD8 ^= ((long) UnsignedBytes.d(byteBuffer.get(11))) << 24;
                    jD8 ^= ((long) UnsignedBytes.d(byteBuffer.get(10))) << 16;
                    jD8 ^= ((long) UnsignedBytes.d(byteBuffer.get(9))) << 8;
                    jD8 ^= (long) UnsignedBytes.d(byteBuffer.get(8));
                    jD7 = byteBuffer.getLong();
                    this.f85141d = s(jD7) ^ this.f85141d;
                    this.f85142e ^= t(jD8);
                    return;
                case 15:
                    jD8 = ((long) UnsignedBytes.d(byteBuffer.get(14))) << 48;
                    jD8 ^= ((long) UnsignedBytes.d(byteBuffer.get(13))) << 40;
                    jD8 ^= ((long) UnsignedBytes.d(byteBuffer.get(12))) << 32;
                    jD8 ^= ((long) UnsignedBytes.d(byteBuffer.get(11))) << 24;
                    jD8 ^= ((long) UnsignedBytes.d(byteBuffer.get(10))) << 16;
                    jD8 ^= ((long) UnsignedBytes.d(byteBuffer.get(9))) << 8;
                    jD8 ^= (long) UnsignedBytes.d(byteBuffer.get(8));
                    jD7 = byteBuffer.getLong();
                    this.f85141d = s(jD7) ^ this.f85141d;
                    this.f85142e ^= t(jD8);
                    return;
                default:
                    throw new AssertionError("Should never get here.");
            }
        }
    }

    Murmur3_128HashFunction(int i3) {
        this.f85140a = i3;
    }

    @Override // com.google.common.hash.HashFunction
    public int a() {
        return ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher b() {
        return new Murmur3_128Hasher(this.f85140a);
    }

    public boolean equals(Object obj) {
        return (obj instanceof Murmur3_128HashFunction) && this.f85140a == ((Murmur3_128HashFunction) obj).f85140a;
    }

    public int hashCode() {
        return Murmur3_128HashFunction.class.hashCode() ^ this.f85140a;
    }

    public String toString() {
        return "Hashing.murmur3_128(" + this.f85140a + ")";
    }
}
