package com.google.common.io;

import java.io.FilterInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class CountingInputStream extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f85256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f85257b;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i3) {
        ((FilterInputStream) this).in.mark(i3);
        this.f85257b = this.f85256a;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i3 = ((FilterInputStream) this).in.read();
        if (i3 != -1) {
            this.f85256a++;
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        if (!((FilterInputStream) this).in.markSupported()) {
            throw new IOException("Mark not supported");
        }
        if (this.f85257b == -1) {
            throw new IOException("Mark not set");
        }
        ((FilterInputStream) this).in.reset();
        this.f85256a = this.f85257b;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j3) throws IOException {
        long jSkip = ((FilterInputStream) this).in.skip(j3);
        this.f85256a += jSkip;
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) throws IOException {
        int i5 = ((FilterInputStream) this).in.read(bArr, i3, i4);
        if (i5 != -1) {
            this.f85256a += (long) i5;
        }
        return i5;
    }
}
