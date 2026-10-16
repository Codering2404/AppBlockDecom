package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@ElementTypesAreNonnullByDefault
abstract class AbstractCompositeHashFunction extends AbstractHashFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final HashFunction[] f85047a;

    private Hasher d(final Hasher[] hasherArr) {
        return new Hasher(this) { // from class: com.google.common.hash.AbstractCompositeHashFunction.1

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AbstractCompositeHashFunction f85049b;

            {
                this.f85049b = this;
            }

            @Override // com.google.common.hash.Hasher
            public Hasher h(Object obj, Funnel funnel) {
                for (Hasher hasher : hasherArr) {
                    hasher.h(obj, funnel);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher
            public HashCode i() {
                return this.f85049b.e(hasherArr);
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher a(byte[] bArr) {
                for (Hasher hasher : hasherArr) {
                    hasher.a(bArr);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher b(byte b3) {
                for (Hasher hasher : hasherArr) {
                    hasher.b(b3);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher c(CharSequence charSequence) {
                for (Hasher hasher : hasherArr) {
                    hasher.c(charSequence);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher d(byte[] bArr, int i3, int i4) {
                for (Hasher hasher : hasherArr) {
                    hasher.d(bArr, i3, i4);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher e(int i3) {
                for (Hasher hasher : hasherArr) {
                    hasher.e(i3);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher f(CharSequence charSequence, Charset charset) {
                for (Hasher hasher : hasherArr) {
                    hasher.f(charSequence, charset);
                }
                return this;
            }

            @Override // com.google.common.hash.Hasher, com.google.common.hash.PrimitiveSink
            public Hasher g(long j3) {
                for (Hasher hasher : hasherArr) {
                    hasher.g(j3);
                }
                return this;
            }
        };
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher b() {
        int length = this.f85047a.length;
        Hasher[] hasherArr = new Hasher[length];
        for (int i3 = 0; i3 < length; i3++) {
            hasherArr[i3] = this.f85047a[i3].b();
        }
        return d(hasherArr);
    }

    abstract HashCode e(Hasher[] hasherArr);
}
