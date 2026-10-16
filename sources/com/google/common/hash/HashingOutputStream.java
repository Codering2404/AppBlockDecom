package com.google.common.hash;

import java.io.FilterOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class HashingOutputStream extends FilterOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Hasher f85111a;

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i3) throws IOException {
        this.f85111a.b((byte) i3);
        ((FilterOutputStream) this).out.write(i3);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i3, int i4) throws IOException {
        this.f85111a.d(bArr, i3, i4);
        ((FilterOutputStream) this).out.write(bArr, i3, i4);
    }
}
