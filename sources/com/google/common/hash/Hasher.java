package com.google.common.hash;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public interface Hasher extends PrimitiveSink {
    @Override // com.google.common.hash.PrimitiveSink
    Hasher a(byte[] bArr);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher b(byte b3);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher c(CharSequence charSequence);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher d(byte[] bArr, int i3, int i4);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher e(int i3);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher f(CharSequence charSequence, Charset charset);

    @Override // com.google.common.hash.PrimitiveSink
    Hasher g(long j3);

    Hasher h(Object obj, Funnel funnel);

    HashCode i();
}
