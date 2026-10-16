package com.google.crypto.tink.subtle;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class StreamingAeadEncryptingStream extends FilterOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StreamSegmentEncrypter f87517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f87518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ByteBuffer f87519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ByteBuffer f87520d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f87521f;

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.f87521f) {
            try {
                this.f87519c.flip();
                this.f87520d.clear();
                this.f87517a.a(this.f87519c, true, this.f87520d);
                this.f87520d.flip();
                ((FilterOutputStream) this).out.write(this.f87520d.array(), this.f87520d.position(), this.f87520d.remaining());
                this.f87521f = false;
                super.close();
            } catch (GeneralSecurityException e3) {
                throw new IOException("ptBuffer.remaining():" + this.f87519c.remaining() + " ctBuffer.remaining():" + this.f87520d.remaining(), e3);
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i3) {
        write(new byte[]{(byte) i3});
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i3, int i4) {
        try {
            if (this.f87521f) {
                while (i4 > this.f87519c.remaining()) {
                    int iRemaining = this.f87519c.remaining();
                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i3, iRemaining);
                    i3 += iRemaining;
                    i4 -= iRemaining;
                    try {
                        this.f87519c.flip();
                        this.f87520d.clear();
                        this.f87517a.b(this.f87519c, byteBufferWrap, false, this.f87520d);
                        this.f87520d.flip();
                        ((FilterOutputStream) this).out.write(this.f87520d.array(), this.f87520d.position(), this.f87520d.remaining());
                        this.f87519c.clear();
                        this.f87519c.limit(this.f87518b);
                    } catch (GeneralSecurityException e3) {
                        throw new IOException(e3);
                    }
                }
                this.f87519c.put(bArr, i3, i4);
            } else {
                throw new IOException("Trying to write to closed stream");
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
