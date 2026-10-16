package com.google.crypto.tink.subtle;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class StreamingAeadDecryptingStream extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteBuffer f87499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ByteBuffer f87500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f87501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f87502d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f87503f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f87504g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f87505h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final byte[] f87506i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f87507j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final StreamSegmentDecrypter f87508k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f87509l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f87510m;

    public StreamingAeadDecryptingStream(NonceBasedStreamingAead nonceBasedStreamingAead, InputStream inputStream, byte[] bArr) {
        super(inputStream);
        this.f87508k = nonceBasedStreamingAead.i();
        this.f87501c = nonceBasedStreamingAead.g();
        this.f87506i = Arrays.copyOf(bArr, bArr.length);
        int iF = nonceBasedStreamingAead.f();
        this.f87509l = iF;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iF + 1);
        this.f87499a = byteBufferAllocate;
        byteBufferAllocate.limit(0);
        this.f87510m = iF - nonceBasedStreamingAead.d();
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(nonceBasedStreamingAead.h() + 16);
        this.f87500b = byteBufferAllocate2;
        byteBufferAllocate2.limit(0);
        this.f87502d = false;
        this.f87503f = false;
        this.f87504g = false;
        this.f87507j = 0;
        this.f87505h = false;
    }

    private void a() throws IOException {
        byte b3;
        while (!this.f87503f && this.f87499a.remaining() > 0) {
            int i3 = ((FilterInputStream) this).in.read(this.f87499a.array(), this.f87499a.position(), this.f87499a.remaining());
            if (i3 > 0) {
                ByteBuffer byteBuffer = this.f87499a;
                byteBuffer.position(byteBuffer.position() + i3);
            } else if (i3 == -1) {
                this.f87503f = true;
            } else if (i3 == 0) {
                throw new IOException("Could not read bytes from the ciphertext stream");
            }
        }
        if (this.f87503f) {
            b3 = 0;
        } else {
            ByteBuffer byteBuffer2 = this.f87499a;
            b3 = byteBuffer2.get(byteBuffer2.position() - 1);
            ByteBuffer byteBuffer3 = this.f87499a;
            byteBuffer3.position(byteBuffer3.position() - 1);
        }
        this.f87499a.flip();
        this.f87500b.clear();
        try {
            this.f87508k.b(this.f87499a, this.f87507j, this.f87503f, this.f87500b);
            this.f87507j++;
            this.f87500b.flip();
            this.f87499a.clear();
            if (this.f87503f) {
                return;
            }
            this.f87499a.clear();
            this.f87499a.limit(this.f87509l + 1);
            this.f87499a.put(b3);
        } catch (GeneralSecurityException e3) {
            c();
            throw new IOException(e3.getMessage() + "\n" + toString() + "\nsegmentNr:" + this.f87507j + " endOfCiphertext:" + this.f87503f, e3);
        }
    }

    private void b() throws IOException {
        if (this.f87502d) {
            c();
            throw new IOException("Decryption failed.");
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.f87501c);
        while (byteBufferAllocate.remaining() > 0) {
            int i3 = ((FilterInputStream) this).in.read(byteBufferAllocate.array(), byteBufferAllocate.position(), byteBufferAllocate.remaining());
            if (i3 == -1) {
                c();
                throw new IOException("Ciphertext is too short");
            }
            if (i3 == 0) {
                throw new IOException("Could not read bytes from the ciphertext stream");
            }
            byteBufferAllocate.position(byteBufferAllocate.position() + i3);
        }
        byteBufferAllocate.flip();
        try {
            this.f87508k.a(byteBufferAllocate, this.f87506i);
            this.f87502d = true;
        } catch (GeneralSecurityException e3) {
            throw new IOException(e3);
        }
    }

    private void c() {
        this.f87505h = true;
        this.f87500b.limit(0);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return this.f87500b.remaining();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        super.close();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i3) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        int i3 = read(bArr, 0, 1);
        if (i3 == 1) {
            return bArr[0] & 255;
        }
        if (i3 == -1) {
            return i3;
        }
        throw new IOException("Reading failed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j3) {
        int i3;
        long j4 = this.f87509l;
        if (j3 <= 0) {
            return 0L;
        }
        int iMin = (int) Math.min(j4, j3);
        byte[] bArr = new byte[iMin];
        long j5 = j3;
        while (j5 > 0 && (i3 = read(bArr, 0, (int) Math.min(iMin, j5))) > 0) {
            j5 -= (long) i3;
        }
        return j3 - j5;
    }

    public synchronized String toString() {
        return "StreamingAeadDecryptingStream\nsegmentNr:" + this.f87507j + "\nciphertextSegmentSize:" + this.f87509l + "\nheaderRead:" + this.f87502d + "\nendOfCiphertext:" + this.f87503f + "\nendOfPlaintext:" + this.f87504g + "\ndecryptionErrorOccured:" + this.f87505h + "\nciphertextSgement position:" + this.f87499a.position() + " limit:" + this.f87499a.limit() + "\nplaintextSegment position:" + this.f87500b.position() + " limit:" + this.f87500b.limit();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i3, int i4) {
        try {
            if (!this.f87505h) {
                if (!this.f87502d) {
                    b();
                    this.f87499a.clear();
                    this.f87499a.limit(this.f87510m + 1);
                }
                if (this.f87504g) {
                    return -1;
                }
                int i5 = 0;
                while (true) {
                    if (i5 >= i4) {
                        break;
                    }
                    if (this.f87500b.remaining() == 0) {
                        if (this.f87503f) {
                            this.f87504g = true;
                            break;
                        }
                        a();
                    }
                    int iMin = Math.min(this.f87500b.remaining(), i4 - i5);
                    this.f87500b.get(bArr, i5 + i3, iMin);
                    i5 += iMin;
                }
                if (i5 == 0 && this.f87504g) {
                    return -1;
                }
                return i5;
            }
            throw new IOException("Decryption failed.");
        } catch (Throwable th) {
            throw th;
        }
    }
}
