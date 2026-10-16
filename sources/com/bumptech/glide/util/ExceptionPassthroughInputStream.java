package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ExceptionPassthroughInputStream extends InputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Queue f67275c = Util.g(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InputStream f67276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IOException f67277b;

    ExceptionPassthroughInputStream() {
    }

    public static ExceptionPassthroughInputStream b(InputStream inputStream) {
        ExceptionPassthroughInputStream exceptionPassthroughInputStream;
        Queue queue = f67275c;
        synchronized (queue) {
            exceptionPassthroughInputStream = (ExceptionPassthroughInputStream) queue.poll();
        }
        if (exceptionPassthroughInputStream == null) {
            exceptionPassthroughInputStream = new ExceptionPassthroughInputStream();
        }
        exceptionPassthroughInputStream.f(inputStream);
        return exceptionPassthroughInputStream;
    }

    public IOException a() {
        return this.f67277b;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f67276a.available();
    }

    public void c() {
        this.f67277b = null;
        this.f67276a = null;
        Queue queue = f67275c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f67276a.close();
    }

    void f(InputStream inputStream) {
        this.f67276a = inputStream;
    }

    @Override // java.io.InputStream
    public void mark(int i3) {
        this.f67276a.mark(i3);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f67276a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.f67276a.read();
        } catch (IOException e3) {
            this.f67277b = e3;
            throw e3;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f67276a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j3) throws IOException {
        try {
            return this.f67276a.skip(j3);
        } catch (IOException e3) {
            this.f67277b = e3;
            throw e3;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.f67276a.read(bArr);
        } catch (IOException e3) {
            this.f67277b = e3;
            throw e3;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) throws IOException {
        try {
            return this.f67276a.read(bArr, i3, i4);
        } catch (IOException e3) {
            this.f67277b = e3;
            throw e3;
        }
    }
}
