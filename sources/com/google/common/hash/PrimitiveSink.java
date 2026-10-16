package com.google.common.hash;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public interface PrimitiveSink {
    PrimitiveSink a(byte[] bArr);

    PrimitiveSink b(byte b3);

    PrimitiveSink c(CharSequence charSequence);

    PrimitiveSink d(byte[] bArr, int i3, int i4);

    PrimitiveSink e(int i3);

    PrimitiveSink f(CharSequence charSequence, Charset charset);

    PrimitiveSink g(long j3);
}
