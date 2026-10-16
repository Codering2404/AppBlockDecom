package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.zip.Checksum;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@ElementTypesAreNonnullByDefault
final class ChecksumHashFunction extends AbstractHashFunction implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImmutableSupplier f85068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f85069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f85070c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class ChecksumHasher extends AbstractByteHasher {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Checksum f85071b;

        @Override // com.google.common.hash.Hasher
        public HashCode i() {
            long value = this.f85071b.getValue();
            return ChecksumHashFunction.this.f85069b == 32 ? HashCode.g((int) value) : HashCode.h(value);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void l(byte b3) {
            this.f85071b.update(b3);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void n(byte[] bArr, int i3, int i4) {
            this.f85071b.update(bArr, i3, i4);
        }

        private ChecksumHasher(Checksum checksum) {
            this.f85071b = (Checksum) Preconditions.t(checksum);
        }
    }

    ChecksumHashFunction(ImmutableSupplier immutableSupplier, int i3, String str) {
        this.f85068a = (ImmutableSupplier) Preconditions.t(immutableSupplier);
        Preconditions.h(i3 == 32 || i3 == 64, "bits (%s) must be either 32 or 64", i3);
        this.f85069b = i3;
        this.f85070c = (String) Preconditions.t(str);
    }

    @Override // com.google.common.hash.HashFunction
    public int a() {
        return this.f85069b;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher b() {
        return new ChecksumHasher((Checksum) this.f85068a.get());
    }

    public String toString() {
        return this.f85070c;
    }
}
