package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class StreamingAeadDecryptingChannel implements ReadableByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ReadableByteChannel f87486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ByteBuffer f87487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ByteBuffer f87488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ByteBuffer f87489d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f87490f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f87491g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f87492h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f87493i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final byte[] f87494j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f87495k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final StreamSegmentDecrypter f87496l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f87497m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f87498n;

    public StreamingAeadDecryptingChannel(NonceBasedStreamingAead nonceBasedStreamingAead, ReadableByteChannel readableByteChannel, byte[] bArr) {
        this.f87496l = nonceBasedStreamingAead.i();
        this.f87486a = readableByteChannel;
        this.f87489d = ByteBuffer.allocate(nonceBasedStreamingAead.g());
        this.f87494j = Arrays.copyOf(bArr, bArr.length);
        int iF = nonceBasedStreamingAead.f();
        this.f87497m = iF;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iF + 1);
        this.f87487b = byteBufferAllocate;
        byteBufferAllocate.limit(0);
        this.f87498n = iF - nonceBasedStreamingAead.d();
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(nonceBasedStreamingAead.h() + 16);
        this.f87488c = byteBufferAllocate2;
        byteBufferAllocate2.limit(0);
        this.f87490f = false;
        this.f87491g = false;
        this.f87492h = false;
        this.f87495k = 0;
        this.f87493i = true;
    }

    private void a(ByteBuffer byteBuffer) throws IOException {
        int i3;
        do {
            i3 = this.f87486a.read(byteBuffer);
            if (i3 <= 0) {
                break;
            }
        } while (byteBuffer.remaining() > 0);
        if (i3 == -1) {
            this.f87491g = true;
        }
    }

    private void b() {
        this.f87493i = false;
        this.f87488c.limit(0);
    }

    private boolean c() throws IOException {
        if (!this.f87491g) {
            a(this.f87487b);
        }
        byte b3 = 0;
        if (this.f87487b.remaining() > 0 && !this.f87491g) {
            return false;
        }
        if (!this.f87491g) {
            ByteBuffer byteBuffer = this.f87487b;
            b3 = byteBuffer.get(byteBuffer.position() - 1);
            ByteBuffer byteBuffer2 = this.f87487b;
            byteBuffer2.position(byteBuffer2.position() - 1);
        }
        this.f87487b.flip();
        this.f87488c.clear();
        try {
            this.f87496l.b(this.f87487b, this.f87495k, this.f87491g, this.f87488c);
            this.f87495k++;
            this.f87488c.flip();
            this.f87487b.clear();
            if (!this.f87491g) {
                this.f87487b.clear();
                this.f87487b.limit(this.f87497m + 1);
                this.f87487b.put(b3);
            }
            return true;
        } catch (GeneralSecurityException e3) {
            b();
            throw new IOException(e3.getMessage() + "\n" + toString() + "\nsegmentNr:" + this.f87495k + " endOfCiphertext:" + this.f87491g, e3);
        }
    }

    private boolean f() throws IOException {
        if (this.f87491g) {
            throw new IOException("Ciphertext is too short");
        }
        a(this.f87489d);
        if (this.f87489d.remaining() > 0) {
            return false;
        }
        this.f87489d.flip();
        try {
            this.f87496l.a(this.f87489d, this.f87494j);
            this.f87490f = true;
            return true;
        } catch (GeneralSecurityException e3) {
            b();
            throw new IOException(e3);
        }
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f87486a.close();
    }

    @Override // java.nio.channels.Channel
    public synchronized boolean isOpen() {
        return this.f87486a.isOpen();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer byteBuffer) {
        try {
            if (!this.f87493i) {
                throw new IOException("This StreamingAeadDecryptingChannel is in an undefined state");
            }
            if (!this.f87490f) {
                if (!f()) {
                    return 0;
                }
                this.f87487b.clear();
                this.f87487b.limit(this.f87498n + 1);
            }
            if (this.f87492h) {
                return -1;
            }
            int iPosition = byteBuffer.position();
            while (true) {
                if (byteBuffer.remaining() <= 0) {
                    break;
                }
                if (this.f87488c.remaining() == 0) {
                    if (!this.f87491g) {
                        if (!c()) {
                            break;
                        }
                    } else {
                        this.f87492h = true;
                        break;
                    }
                }
                if (this.f87488c.remaining() <= byteBuffer.remaining()) {
                    byteBuffer.put(this.f87488c);
                } else {
                    int iRemaining = byteBuffer.remaining();
                    ByteBuffer byteBufferDuplicate = this.f87488c.duplicate();
                    byteBufferDuplicate.limit(byteBufferDuplicate.position() + iRemaining);
                    byteBuffer.put(byteBufferDuplicate);
                    ByteBuffer byteBuffer2 = this.f87488c;
                    byteBuffer2.position(byteBuffer2.position() + iRemaining);
                }
            }
            int iPosition2 = byteBuffer.position() - iPosition;
            if (iPosition2 == 0 && this.f87492h) {
                return -1;
            }
            return iPosition2;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized String toString() {
        return "StreamingAeadDecryptingChannel\nsegmentNr:" + this.f87495k + "\nciphertextSegmentSize:" + this.f87497m + "\nheaderRead:" + this.f87490f + "\nendOfCiphertext:" + this.f87491g + "\nendOfPlaintext:" + this.f87492h + "\ndefinedState:" + this.f87493i + "\nHeader position:" + this.f87489d.position() + " limit:" + this.f87489d.position() + "\nciphertextSgement position:" + this.f87487b.position() + " limit:" + this.f87487b.limit() + "\nplaintextSegment position:" + this.f87488c.position() + " limit:" + this.f87488c.limit();
    }
}
