package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@ElementTypesAreNonnullByDefault
final class MacHashFunction extends AbstractHashFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Mac f85121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Key f85122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f85123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f85124d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f85125f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MacHasher extends AbstractByteHasher {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Mac f85126b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f85127c;

        private void o() {
            Preconditions.A(!this.f85127c, "Cannot re-use a Hasher after calling hash() on it");
        }

        @Override // com.google.common.hash.Hasher
        public HashCode i() {
            o();
            this.f85127c = true;
            return HashCode.f(this.f85126b.doFinal());
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void l(byte b3) {
            o();
            this.f85126b.update(b3);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void m(byte[] bArr) {
            o();
            this.f85126b.update(bArr);
        }

        @Override // com.google.common.hash.AbstractByteHasher
        protected void n(byte[] bArr, int i3, int i4) {
            o();
            this.f85126b.update(bArr, i3, i4);
        }

        private MacHasher(Mac mac) {
            this.f85126b = mac;
        }
    }

    private static Mac d(String str, Key key) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(key);
            return mac;
        } catch (InvalidKeyException e3) {
            throw new IllegalArgumentException(e3);
        } catch (NoSuchAlgorithmException e4) {
            throw new IllegalStateException(e4);
        }
    }

    @Override // com.google.common.hash.HashFunction
    public int a() {
        return this.f85124d;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher b() {
        if (this.f85125f) {
            try {
                return new MacHasher((Mac) this.f85121a.clone());
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new MacHasher(d(this.f85121a.getAlgorithm(), this.f85122b));
    }

    public String toString() {
        return this.f85123c;
    }
}
