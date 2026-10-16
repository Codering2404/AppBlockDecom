package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class ExceptionCatchingInputStream extends InputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Queue f67272c = Util.g(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InputStream f67273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IOException f67274b;

    @Override // java.io.InputStream
    public int available() {
        return this.f67273a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f67273a.close();
    }

    @Override // java.io.InputStream
    public void mark(int i3) {
        this.f67273a.mark(i3);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f67273a.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f67273a.read(bArr);
        } catch (IOException e3) {
            this.f67274b = e3;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f67273a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j3) {
        try {
            return this.f67273a.skip(j3);
        } catch (IOException e3) {
            this.f67274b = e3;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) {
        try {
            return this.f67273a.read(bArr, i3, i4);
        } catch (IOException e3) {
            this.f67274b = e3;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f67273a.read();
        } catch (IOException e3) {
            this.f67274b = e3;
            return -1;
        }
    }
}
