package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@ElementTypesAreNonnullByDefault
final class SipHashFunction extends AbstractHashFunction implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final HashFunction f85154f = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f85155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f85156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f85157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f85158d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SipHasher extends AbstractStreamingHasher {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f85159d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f85160e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f85161f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f85162g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f85163h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f85164i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f85165j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f85166k;

        SipHasher(int i3, int i4, long j3, long j4) {
            super(8);
            this.f85165j = 0L;
            this.f85166k = 0L;
            this.f85159d = i3;
            this.f85160e = i4;
            this.f85161f = 8317987319222330741L ^ j3;
            this.f85162g = 7237128888997146477L ^ j4;
            this.f85163h = 7816392313619706465L ^ j3;
            this.f85164i = 8387220255154660723L ^ j4;
        }

        private void q(long j3) {
            this.f85164i ^= j3;
            r(this.f85159d);
            this.f85161f = j3 ^ this.f85161f;
        }

        private void r(int i3) {
            for (int i4 = 0; i4 < i3; i4++) {
                long j3 = this.f85161f;
                long j4 = this.f85162g;
                this.f85161f = j3 + j4;
                this.f85163h += this.f85164i;
                this.f85162g = Long.rotateLeft(j4, 13);
                long jRotateLeft = Long.rotateLeft(this.f85164i, 16);
                long j5 = this.f85162g;
                long j6 = this.f85161f;
                this.f85162g = j5 ^ j6;
                this.f85164i = jRotateLeft ^ this.f85163h;
                long jRotateLeft2 = Long.rotateLeft(j6, 32);
                long j7 = this.f85163h;
                long j8 = this.f85162g;
                this.f85163h = j7 + j8;
                this.f85161f = jRotateLeft2 + this.f85164i;
                this.f85162g = Long.rotateLeft(j8, 17);
                long jRotateLeft3 = Long.rotateLeft(this.f85164i, 21);
                long j9 = this.f85162g;
                long j10 = this.f85163h;
                this.f85162g = j9 ^ j10;
                this.f85164i = jRotateLeft3 ^ this.f85161f;
                this.f85163h = Long.rotateLeft(j10, 32);
            }
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected HashCode k() {
            long j3 = this.f85166k ^ (this.f85165j << 56);
            this.f85166k = j3;
            q(j3);
            this.f85163h ^= 255;
            r(this.f85160e);
            return HashCode.h(((this.f85161f ^ this.f85162g) ^ this.f85163h) ^ this.f85164i);
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void n(ByteBuffer byteBuffer) {
            this.f85165j += 8;
            q(byteBuffer.getLong());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void o(ByteBuffer byteBuffer) {
            this.f85165j += (long) byteBuffer.remaining();
            int i3 = 0;
            while (byteBuffer.hasRemaining()) {
                this.f85166k ^= (((long) byteBuffer.get()) & 255) << i3;
                i3 += 8;
            }
        }
    }

    SipHashFunction(int i3, int i4, long j3, long j4) {
        Preconditions.h(i3 > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i3);
        Preconditions.h(i4 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i4);
        this.f85155a = i3;
        this.f85156b = i4;
        this.f85157c = j3;
        this.f85158d = j4;
    }

    @Override // com.google.common.hash.HashFunction
    public int a() {
        return 64;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher b() {
        return new SipHasher(this.f85155a, this.f85156b, this.f85157c, this.f85158d);
    }

    public boolean equals(Object obj) {
        if (obj instanceof SipHashFunction) {
            SipHashFunction sipHashFunction = (SipHashFunction) obj;
            if (this.f85155a == sipHashFunction.f85155a && this.f85156b == sipHashFunction.f85156b && this.f85157c == sipHashFunction.f85157c && this.f85158d == sipHashFunction.f85158d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (int) ((((long) ((SipHashFunction.class.hashCode() ^ this.f85155a) ^ this.f85156b)) ^ this.f85157c) ^ this.f85158d);
    }

    public String toString() {
        return "Hashing.sipHash" + this.f85155a + "" + this.f85156b + "(" + this.f85157c + ", " + this.f85158d + ")";
    }
}
