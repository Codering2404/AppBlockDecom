package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractByteHasher extends AbstractHasher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteBuffer f85046a = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);

    AbstractByteHasher() {
    }

    private Hasher k(int i3) {
        try {
            n(this.f85046a.array(), 0, i3);
            return this;
        } finally {
            Java8Compatibility.a(this.f85046a);
        }
    }

    @Override // com.google.common.hash.AbstractHasher
    public Hasher j(char c3) {
        this.f85046a.putChar(c3);
        return k(2);
    }

    protected abstract void l(byte b3);

    protected void m(byte[] bArr) {
        n(bArr, 0, bArr.length);
    }

    protected void n(byte[] bArr, int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            l(bArr[i5]);
        }
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher a(byte[] bArr) {
        Preconditions.t(bArr);
        m(bArr);
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher b(byte b3) {
        l(b3);
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher d(byte[] bArr, int i3, int i4) {
        Preconditions.y(i3, i3 + i4, bArr.length);
        n(bArr, i3, i4);
        return this;
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher e(int i3) {
        this.f85046a.putInt(i3);
        return k(4);
    }

    @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher g(long j3) {
        this.f85046a.putLong(j3);
        return k(8);
    }
}
