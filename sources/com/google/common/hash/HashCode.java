package com.google.common.hash;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class HashCode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f85096a = "0123456789abcdef".toCharArray();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class BytesHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final byte[] f85097b;

        BytesHashCode(byte[] bArr) {
            this.f85097b = (byte[]) Preconditions.t(bArr);
        }

        @Override // com.google.common.hash.HashCode
        public byte[] a() {
            return (byte[]) this.f85097b.clone();
        }

        @Override // com.google.common.hash.HashCode
        public int b() {
            byte[] bArr = this.f85097b;
            Preconditions.B(bArr.length >= 4, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", bArr.length);
            byte[] bArr2 = this.f85097b;
            return ((bArr2[3] & 255) << 24) | (bArr2[0] & 255) | ((bArr2[1] & 255) << 8) | ((bArr2[2] & 255) << 16);
        }

        @Override // com.google.common.hash.HashCode
        public long c() {
            byte[] bArr = this.f85097b;
            Preconditions.B(bArr.length >= 8, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", bArr.length);
            return l();
        }

        @Override // com.google.common.hash.HashCode
        public int d() {
            return this.f85097b.length * 8;
        }

        @Override // com.google.common.hash.HashCode
        boolean e(HashCode hashCode) {
            if (this.f85097b.length != hashCode.i().length) {
                return false;
            }
            boolean z2 = true;
            int i3 = 0;
            while (true) {
                byte[] bArr = this.f85097b;
                if (i3 >= bArr.length) {
                    return z2;
                }
                z2 &= bArr[i3] == hashCode.i()[i3];
                i3++;
            }
        }

        @Override // com.google.common.hash.HashCode
        byte[] i() {
            return this.f85097b;
        }

        @Override // com.google.common.hash.HashCode
        void k(byte[] bArr, int i3, int i4) {
            System.arraycopy(this.f85097b, 0, bArr, i3, i4);
        }

        public long l() {
            long j3 = this.f85097b[0] & 255;
            for (int i3 = 1; i3 < Math.min(this.f85097b.length, 8); i3++) {
                j3 |= (((long) this.f85097b[i3]) & 255) << (i3 * 8);
            }
            return j3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class IntHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f85098b;

        IntHashCode(int i3) {
            this.f85098b = i3;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] a() {
            int i3 = this.f85098b;
            return new byte[]{(byte) i3, (byte) (i3 >> 8), (byte) (i3 >> 16), (byte) (i3 >> 24)};
        }

        @Override // com.google.common.hash.HashCode
        public int b() {
            return this.f85098b;
        }

        @Override // com.google.common.hash.HashCode
        public long c() {
            throw new IllegalStateException("this HashCode only has 32 bits; cannot create a long");
        }

        @Override // com.google.common.hash.HashCode
        public int d() {
            return 32;
        }

        @Override // com.google.common.hash.HashCode
        boolean e(HashCode hashCode) {
            return this.f85098b == hashCode.b();
        }

        @Override // com.google.common.hash.HashCode
        void k(byte[] bArr, int i3, int i4) {
            for (int i5 = 0; i5 < i4; i5++) {
                bArr[i3 + i5] = (byte) (this.f85098b >> (i5 * 8));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class LongHashCode extends HashCode implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f85099b;

        LongHashCode(long j3) {
            this.f85099b = j3;
        }

        @Override // com.google.common.hash.HashCode
        public byte[] a() {
            return new byte[]{(byte) this.f85099b, (byte) (r0 >> 8), (byte) (r0 >> 16), (byte) (r0 >> 24), (byte) (r0 >> 32), (byte) (r0 >> 40), (byte) (r0 >> 48), (byte) (r0 >> 56)};
        }

        @Override // com.google.common.hash.HashCode
        public int b() {
            return (int) this.f85099b;
        }

        @Override // com.google.common.hash.HashCode
        public long c() {
            return this.f85099b;
        }

        @Override // com.google.common.hash.HashCode
        public int d() {
            return 64;
        }

        @Override // com.google.common.hash.HashCode
        boolean e(HashCode hashCode) {
            return this.f85099b == hashCode.c();
        }

        @Override // com.google.common.hash.HashCode
        void k(byte[] bArr, int i3, int i4) {
            for (int i5 = 0; i5 < i4; i5++) {
                bArr[i3 + i5] = (byte) (this.f85099b >> (i5 * 8));
            }
        }
    }

    HashCode() {
    }

    static HashCode f(byte[] bArr) {
        return new BytesHashCode(bArr);
    }

    public static HashCode g(int i3) {
        return new IntHashCode(i3);
    }

    public static HashCode h(long j3) {
        return new LongHashCode(j3);
    }

    public abstract byte[] a();

    public abstract int b();

    public abstract long c();

    public abstract int d();

    abstract boolean e(HashCode hashCode);

    public final boolean equals(Object obj) {
        if (obj instanceof HashCode) {
            HashCode hashCode = (HashCode) obj;
            if (d() == hashCode.d() && e(hashCode)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (d() >= 32) {
            return b();
        }
        byte[] bArrI = i();
        int i3 = bArrI[0] & 255;
        for (int i4 = 1; i4 < bArrI.length; i4++) {
            i3 |= (bArrI[i4] & 255) << (i4 * 8);
        }
        return i3;
    }

    byte[] i() {
        return a();
    }

    public int j(byte[] bArr, int i3, int i4) {
        int iL = Ints.l(i4, d() / 8);
        Preconditions.y(i3, i3 + iL, bArr.length);
        k(bArr, i3, iL);
        return iL;
    }

    abstract void k(byte[] bArr, int i3, int i4);

    public final String toString() {
        byte[] bArrI = i();
        StringBuilder sb = new StringBuilder(bArrI.length * 2);
        for (byte b3 : bArrI) {
            char[] cArr = f85096a;
            sb.append(cArr[(b3 >> 4) & 15]);
            sb.append(cArr[b3 & Ascii.SI]);
        }
        return sb.toString();
    }
}
