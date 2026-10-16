package com.google.common.io;

import java.io.FilterOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class CountingOutputStream extends FilterOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f85258a;

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i3, int i4) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i3, i4);
        this.f85258a += (long) i4;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i3) throws IOException {
        ((FilterOutputStream) this).out.write(i3);
        this.f85258a++;
    }
}
