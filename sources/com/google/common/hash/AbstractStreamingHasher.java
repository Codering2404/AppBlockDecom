package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractStreamingHasher extends AbstractHasher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteBuffer f85052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f85053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f85054c;

    protected AbstractStreamingHasher(int i3) {
        this(i3, i3);
    }

    private void l() {
        Java8Compatibility.b(this.f85052a);
        while (this.f85052a.remaining() >= this.f85054c) {
            n(this.f85052a);
        }
        this.f85052a.compact();
    }

    private void m() {
        if (this.f85052a.remaining() < 8) {
            l();
        }
    }

    private Hasher p(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.f85052a.remaining()) {
            this.f85052a.put(byteBuffer);
            m();
            return this;
        }
        int iPosition = this.f85053b - this.f85052a.position();
        for (int i3 = 0; i3 < iPosition; i3++) {
            this.f85052a.put(byteBuffer.get());
        }
        l();
        while (byteBuffer.remaining() >= this.f85054c) {
            n(byteBuffer);
        }
        this.f85052a.put(byteBuffer);
        return this;
    }

    @Override // com.google.common.hash.Hasher
    public final HashCode i() {
        l();
        Java8Compatibility.b(this.f85052a);
        if (this.f85052a.remaining() > 0) {
            o(this.f85052a);
            ByteBuffer byteBuffer = this.f85052a;
            Java8Compatibility.d(byteBuffer, byteBuffer.limit());
        }
        return k();
    }

    @Override // com.google.common.hash.AbstractHasher
    public final Hasher j(char c3) {
        this.f85052a.putChar(c3);
        m();
        return this;
    }

    protected abstract HashCode k();

    protected abstract void n(ByteBuffer byteBuffer);

    protected void o(ByteBuffer byteBuffer) {
        Java8Compatibility.d(byteBuffer, byteBuffer.limit());
        Java8Compatibility.c(byteBuffer, this.f85054c + 7);
        while (true) {
            int iPosition = byteBuffer.position();
            int i3 = this.f85054c;
            if (iPosition >= i3) {
                Java8Compatibility.c(byteBuffer, i3);
                Java8Compatibility.b(byteBuffer);
                n(byteBuffer);
                return;
            }
            byteBuffer.putLong(0L);
        }
    }

    protected AbstractStreamingHasher(int i3, int i4) {
        Preconditions.d(i4 % i3 == 0);
        this.f85052a = ByteBuffer.allocate(i4 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.f85053b = i4;
        this.f85054c = i3;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher b(byte b3) {
        this.f85052a.put(b3);
        m();
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher d(byte[] bArr, int i3, int i4) {
        return p(ByteBuffer.wrap(bArr, i3, i4).order(ByteOrder.LITTLE_ENDIAN));
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher e(int i3) {
        this.f85052a.putInt(i3);
        m();
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public final Hasher g(long j3) {
        this.f85052a.putLong(j3);
        m();
        return this;
    }
}
