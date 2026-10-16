package com.android.volley.toolbox;

import com.sun.jna.Function;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PoolingByteArrayOutputStream extends ByteArrayOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteArrayPool f57849a;

    public PoolingByteArrayOutputStream(ByteArrayPool byteArrayPool, int i3) {
        this.f57849a = byteArrayPool;
        ((ByteArrayOutputStream) this).buf = byteArrayPool.a(Math.max(i3, Function.MAX_NARGS));
    }

    private void a(int i3) {
        int i4 = ((ByteArrayOutputStream) this).count;
        if (i4 + i3 <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        byte[] bArrA = this.f57849a.a((i4 + i3) * 2);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, bArrA, 0, ((ByteArrayOutputStream) this).count);
        this.f57849a.b(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = bArrA;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f57849a.b(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public void finalize() {
        this.f57849a.b(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i3, int i4) {
        a(i4);
        super.write(bArr, i3, i4);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i3) {
        a(1);
        super.write(i3);
    }
}
