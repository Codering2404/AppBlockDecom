package com.bumptech.glide.load.data;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.facebook.internal.NativeProtocol;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class BufferedOutputStream extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OutputStream f66267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f66268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayPool f66269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f66270d;

    public BufferedOutputStream(OutputStream outputStream, ArrayPool arrayPool) {
        this(outputStream, arrayPool, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
    }

    private void a() throws IOException {
        int i3 = this.f66270d;
        if (i3 > 0) {
            this.f66267a.write(this.f66268b, 0, i3);
            this.f66270d = 0;
        }
    }

    private void b() throws IOException {
        if (this.f66270d == this.f66268b.length) {
            a();
        }
    }

    private void c() {
        byte[] bArr = this.f66268b;
        if (bArr != null) {
            this.f66269c.put(bArr);
            this.f66268b = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f66267a.close();
            c();
        } catch (Throwable th) {
            this.f66267a.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        a();
        this.f66267a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i3) throws IOException {
        byte[] bArr = this.f66268b;
        int i4 = this.f66270d;
        this.f66270d = i4 + 1;
        bArr[i4] = (byte) i3;
        b();
    }

    BufferedOutputStream(OutputStream outputStream, ArrayPool arrayPool, int i3) {
        this.f66267a = outputStream;
        this.f66269c = arrayPool;
        this.f66268b = (byte[]) arrayPool.c(i3, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i3, int i4) throws IOException {
        int i5 = 0;
        do {
            int i6 = i4 - i5;
            int i7 = i3 + i5;
            int i8 = this.f66270d;
            if (i8 == 0 && i6 >= this.f66268b.length) {
                this.f66267a.write(bArr, i7, i6);
                return;
            }
            int iMin = Math.min(i6, this.f66268b.length - i8);
            System.arraycopy(bArr, i7, this.f66268b, this.f66270d, iMin);
            this.f66270d += iMin;
            i5 += iMin;
            b();
        } while (i5 < i4);
    }
}
