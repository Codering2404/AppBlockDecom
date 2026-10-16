package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.Immutable;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@ElementTypesAreNonnullByDefault
final class Murmur3_32HashFunction extends AbstractHashFunction implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final HashFunction f85144c = new Murmur3_32HashFunction(0, false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final HashFunction f85145d = new Murmur3_32HashFunction(0, true);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final HashFunction f85146f = new Murmur3_32HashFunction(Hashing.f85100a, true);
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f85147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f85148b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Murmur3_32Hasher extends AbstractHasher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f85149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f85150b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f85151c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f85152d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f85153e = false;

        Murmur3_32Hasher(int i3) {
            this.f85149a = i3;
        }

        private void k(int i3, long j3) {
            long j4 = this.f85150b;
            int i4 = this.f85151c;
            long j5 = ((j3 & 4294967295L) << i4) | j4;
            this.f85150b = j5;
            int i5 = i4 + (i3 * 8);
            this.f85151c = i5;
            this.f85152d += i3;
            if (i5 >= 32) {
                this.f85149a = Murmur3_32HashFunction.p(this.f85149a, Murmur3_32HashFunction.q((int) j5));
                this.f85150b >>>= 32;
                this.f85151c -= 32;
            }
        }

        @Override // com.google.common.hash.Hasher
        public HashCode i() {
            Preconditions.z(!this.f85153e);
            this.f85153e = true;
            int iQ = this.f85149a ^ Murmur3_32HashFunction.q((int) this.f85150b);
            this.f85149a = iQ;
            return Murmur3_32HashFunction.n(iQ, this.f85152d);
        }

        @Override // com.google.common.hash.AbstractHasher
        public Hasher j(char c3) {
            k(2, c3);
            return this;
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher b(byte b3) {
            k(1, b3 & 255);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher d(byte[] bArr, int i3, int i4) {
            Preconditions.y(i3, i3 + i4, bArr.length);
            int i5 = 0;
            while (true) {
                int i6 = i5 + 4;
                if (i6 > i4) {
                    break;
                }
                k(4, Murmur3_32HashFunction.o(bArr, i5 + i3));
                i5 = i6;
            }
            while (i5 < i4) {
                b(bArr[i3 + i5]);
                i5++;
            }
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher e(int i3) {
            k(4, i3);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher f(CharSequence charSequence, Charset charset) {
            if (!StandardCharsets.UTF_8.equals(charset)) {
                return super.f(charSequence, charset);
            }
            int length = charSequence.length();
            int i3 = 0;
            while (true) {
                int i4 = i3 + 4;
                if (i4 > length) {
                    break;
                }
                char cCharAt = charSequence.charAt(i3);
                char cCharAt2 = charSequence.charAt(i3 + 1);
                char cCharAt3 = charSequence.charAt(i3 + 2);
                char cCharAt4 = charSequence.charAt(i3 + 3);
                if (cCharAt >= 128 || cCharAt2 >= 128 || cCharAt3 >= 128 || cCharAt4 >= 128) {
                    break;
                }
                k(4, (cCharAt2 << '\b') | cCharAt | (cCharAt3 << 16) | (cCharAt4 << 24));
                i3 = i4;
            }
            while (i3 < length) {
                char cCharAt5 = charSequence.charAt(i3);
                if (cCharAt5 < 128) {
                    k(1, cCharAt5);
                } else if (cCharAt5 < 2048) {
                    k(2, Murmur3_32HashFunction.l(cCharAt5));
                } else if (cCharAt5 < 55296 || cCharAt5 > 57343) {
                    k(3, Murmur3_32HashFunction.k(cCharAt5));
                } else {
                    int iCodePointAt = Character.codePointAt(charSequence, i3);
                    if (iCodePointAt == cCharAt5) {
                        a(charSequence.subSequence(i3, length).toString().getBytes(charset));
                        return this;
                    }
                    i3++;
                    k(4, Murmur3_32HashFunction.m(iCodePointAt));
                }
                i3++;
            }
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher g(long j3) {
            k(4, (int) j3);
            k(4, j3 >>> 32);
            return this;
        }
    }

    Murmur3_32HashFunction(int i3, boolean z2) {
        this.f85147a = i3;
        this.f85148b = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long k(char c3) {
        return ((long) (c3 >>> '\f')) | 224 | ((long) ((((c3 >>> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) << 8)) | ((long) (((c3 & '?') | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) << 16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long l(char c3) {
        return ((long) (c3 >>> 6)) | 192 | ((long) (((c3 & '?') | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) << 8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long m(int i3) {
        return ((long) (i3 >>> 18)) | 240 | ((((long) ((i3 >>> 12) & 63)) | 128) << 8) | ((((long) ((i3 >>> 6) & 63)) | 128) << 16) | ((((long) (i3 & 63)) | 128) << 24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HashCode n(int i3, int i4) {
        int i5 = i3 ^ i4;
        int i6 = (i5 ^ (i5 >>> 16)) * (-2048144789);
        int i7 = (i6 ^ (i6 >>> 13)) * (-1028477387);
        return HashCode.g(i7 ^ (i7 >>> 16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int o(byte[] bArr, int i3) {
        return Ints.h(bArr[i3 + 3], bArr[i3 + 2], bArr[i3 + 1], bArr[i3]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int p(int i3, int i4) {
        return (Integer.rotateLeft(i3 ^ i4, 13) * 5) - 430675100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int q(int i3) {
        return Integer.rotateLeft(i3 * (-862048943), 15) * 461845907;
    }

    @Override // com.google.common.hash.HashFunction
    public int a() {
        return 32;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher b() {
        return new Murmur3_32Hasher(this.f85147a);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Murmur3_32HashFunction) {
            Murmur3_32HashFunction murmur3_32HashFunction = (Murmur3_32HashFunction) obj;
            if (this.f85147a == murmur3_32HashFunction.f85147a && this.f85148b == murmur3_32HashFunction.f85148b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Murmur3_32HashFunction.class.hashCode() ^ this.f85147a;
    }

    public String toString() {
        return "Hashing.murmur3_32(" + this.f85147a + ")";
    }
}
