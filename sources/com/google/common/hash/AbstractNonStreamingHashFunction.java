package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@ElementTypesAreNonnullByDefault
abstract class AbstractNonStreamingHashFunction extends AbstractHashFunction {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class BufferingHasher extends AbstractHasher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ExposedByteArrayOutputStream f85050a;

        BufferingHasher(int i3) {
            this.f85050a = new ExposedByteArrayOutputStream(i3);
        }

        @Override // com.google.common.hash.Hasher
        public HashCode i() {
            return AbstractNonStreamingHashFunction.this.d(this.f85050a.a(), 0, this.f85050a.b());
        }

        @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher b(byte b3) throws IOException {
            this.f85050a.write(b3);
            return this;
        }

        @Override // com.google.common.hash.AbstractHasher, com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
        public Hasher d(byte[] bArr, int i3, int i4) throws IOException {
            this.f85050a.write(bArr, i3, i4);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        ExposedByteArrayOutputStream(int i3) {
            super(i3);
        }

        byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }

        int b() {
            return ((ByteArrayOutputStream) this).count;
        }
    }

    AbstractNonStreamingHashFunction() {
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher b() {
        return e(32);
    }

    public abstract HashCode d(byte[] bArr, int i3, int i4);

    public Hasher e(int i3) {
        Preconditions.d(i3 >= 0);
        return new BufferingHasher(i3);
    }
}
