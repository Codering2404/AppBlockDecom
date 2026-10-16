package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractHasher implements Hasher {
    AbstractHasher() {
    }

    @Override // com.google.common.hash.Hasher
    public Hasher h(Object obj, Funnel funnel) {
        funnel.g0(obj, this);
        return this;
    }

    public Hasher j(char c3) {
        b((byte) c3);
        b((byte) (c3 >>> '\b'));
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher a(byte[] bArr) {
        return d(bArr, 0, bArr.length);
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher c(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i3 = 0; i3 < length; i3++) {
            j(charSequence.charAt(i3));
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher d(byte[] bArr, int i3, int i4) {
        Preconditions.y(i3, i3 + i4, bArr.length);
        for (int i5 = 0; i5 < i4; i5++) {
            b(bArr[i3 + i5]);
        }
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher e(int i3) {
        b((byte) i3);
        b((byte) (i3 >>> 8));
        b((byte) (i3 >>> 16));
        b((byte) (i3 >>> 24));
        return this;
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher f(CharSequence charSequence, Charset charset) {
        return a(charSequence.toString().getBytes(charset));
    }

    @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
    public Hasher g(long j3) {
        for (int i3 = 0; i3 < 64; i3 += 8) {
            b((byte) (j3 >>> i3));
        }
        return this;
    }
}
