package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class StreamingAeadSeekableDecryptingChannel implements SeekableByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SeekableByteChannel f87522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ByteBuffer f87523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ByteBuffer f87524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ByteBuffer f87525d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f87526f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f87527g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f87528h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final byte[] f87529i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final StreamSegmentDecrypter f87530j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f87531k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f87532l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f87533m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f87534n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f87535o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f87536p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f87537q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f87538r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f87539s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f87540t;

    public StreamingAeadSeekableDecryptingChannel(NonceBasedStreamingAead nonceBasedStreamingAead, SeekableByteChannel seekableByteChannel, byte[] bArr) throws IOException {
        this.f87530j = nonceBasedStreamingAead.i();
        this.f87522a = seekableByteChannel;
        this.f87525d = ByteBuffer.allocate(nonceBasedStreamingAead.g());
        int iF = nonceBasedStreamingAead.f();
        this.f87538r = iF;
        this.f87523b = ByteBuffer.allocate(iF);
        int iH = nonceBasedStreamingAead.h();
        this.f87537q = iH;
        this.f87524c = ByteBuffer.allocate(iH + 16);
        this.f87531k = 0L;
        this.f87533m = false;
        this.f87535o = -1;
        this.f87534n = false;
        long size = seekableByteChannel.size();
        this.f87526f = size;
        this.f87529i = Arrays.copyOf(bArr, bArr.length);
        this.f87536p = seekableByteChannel.isOpen();
        int i3 = (int) (size / ((long) iF));
        int i4 = (int) (size % ((long) iF));
        int iE = nonceBasedStreamingAead.e();
        if (i4 > 0) {
            this.f87527g = i3 + 1;
            if (i4 < iE) {
                throw new IOException("Invalid ciphertext size");
            }
            this.f87528h = i4;
        } else {
            this.f87527g = i3;
            this.f87528h = iF;
        }
        int iD = nonceBasedStreamingAead.d();
        this.f87539s = iD;
        int iG = iD - nonceBasedStreamingAead.g();
        this.f87540t = iG;
        if (iG < 0) {
            throw new IOException("Invalid ciphertext offset or header length");
        }
        long j3 = (((long) this.f87527g) * ((long) iE)) + ((long) iD);
        if (j3 > size) {
            throw new IOException("Ciphertext is too short");
        }
        this.f87532l = size - j3;
    }

    private int a(long j3) {
        return (int) ((j3 + ((long) this.f87539s)) / ((long) this.f87537q));
    }

    private boolean b() {
        return this.f87534n && this.f87535o == this.f87527g - 1 && this.f87524c.remaining() == 0;
    }

    private boolean c(int i3) throws IOException {
        int i4;
        if (i3 < 0 || i3 >= (i4 = this.f87527g)) {
            throw new IOException("Invalid position");
        }
        boolean z2 = i3 == i4 - 1;
        if (i3 != this.f87535o) {
            int i5 = this.f87538r;
            long j3 = ((long) i3) * ((long) i5);
            if (z2) {
                i5 = this.f87528h;
            }
            if (i3 == 0) {
                int i6 = this.f87539s;
                i5 -= i6;
                j3 = i6;
            }
            this.f87522a.position(j3);
            this.f87523b.clear();
            this.f87523b.limit(i5);
            this.f87535o = i3;
            this.f87534n = false;
        } else if (this.f87534n) {
            return true;
        }
        if (this.f87523b.remaining() > 0) {
            this.f87522a.read(this.f87523b);
        }
        if (this.f87523b.remaining() > 0) {
            return false;
        }
        this.f87523b.flip();
        this.f87524c.clear();
        try {
            this.f87530j.b(this.f87523b, i3, z2, this.f87524c);
            this.f87524c.flip();
            this.f87534n = true;
            return true;
        } catch (GeneralSecurityException e3) {
            this.f87535o = -1;
            throw new IOException("Failed to decrypt", e3);
        }
    }

    private boolean f() throws IOException {
        this.f87522a.position(this.f87525d.position() + this.f87540t);
        this.f87522a.read(this.f87525d);
        if (this.f87525d.remaining() > 0) {
            return false;
        }
        this.f87525d.flip();
        try {
            this.f87530j.a(this.f87525d, this.f87529i);
            this.f87533m = true;
            return true;
        } catch (GeneralSecurityException e3) {
            throw new IOException(e3);
        }
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f87522a.close();
        this.f87536p = false;
    }

    @Override // java.nio.channels.Channel
    public synchronized boolean isOpen() {
        return this.f87536p;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized long position() {
        return this.f87531k;
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer byteBuffer) {
        if (!this.f87536p) {
            throw new ClosedChannelException();
        }
        if (!this.f87533m && !f()) {
            return 0;
        }
        int iPosition = byteBuffer.position();
        while (byteBuffer.remaining() > 0) {
            long j3 = this.f87531k;
            if (j3 < this.f87532l) {
                int iA = a(j3);
                int i3 = (int) (iA == 0 ? this.f87531k : (this.f87531k + ((long) this.f87539s)) % ((long) this.f87537q));
                if (!c(iA)) {
                    break;
                }
                this.f87524c.position(i3);
                if (this.f87524c.remaining() <= byteBuffer.remaining()) {
                    this.f87531k += (long) this.f87524c.remaining();
                    byteBuffer.put(this.f87524c);
                } else {
                    int iRemaining = byteBuffer.remaining();
                    ByteBuffer byteBufferDuplicate = this.f87524c.duplicate();
                    byteBufferDuplicate.limit(byteBufferDuplicate.position() + iRemaining);
                    byteBuffer.put(byteBufferDuplicate);
                    this.f87531k += (long) iRemaining;
                    ByteBuffer byteBuffer2 = this.f87524c;
                    byteBuffer2.position(byteBuffer2.position() + iRemaining);
                }
            } else {
                break;
            }
        }
        int iPosition2 = byteBuffer.position() - iPosition;
        if (iPosition2 == 0 && b()) {
            return -1;
        }
        return iPosition2;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public long size() {
        return this.f87532l;
    }

    public synchronized String toString() {
        StringBuilder sb;
        String str;
        sb = new StringBuilder();
        try {
            str = "position:" + this.f87522a.position();
        } catch (IOException unused) {
            str = "position: n/a";
        }
        sb.append("StreamingAeadSeekableDecryptingChannel");
        sb.append("\nciphertextChannel");
        sb.append(str);
        sb.append("\nciphertextChannelSize:");
        sb.append(this.f87526f);
        sb.append("\nplaintextSize:");
        sb.append(this.f87532l);
        sb.append("\nciphertextSegmentSize:");
        sb.append(this.f87538r);
        sb.append("\nnumberOfSegments:");
        sb.append(this.f87527g);
        sb.append("\nheaderRead:");
        sb.append(this.f87533m);
        sb.append("\nplaintextPosition:");
        sb.append(this.f87531k);
        sb.append("\nHeader");
        sb.append(" position:");
        sb.append(this.f87525d.position());
        sb.append(" limit:");
        sb.append(this.f87525d.position());
        sb.append("\ncurrentSegmentNr:");
        sb.append(this.f87535o);
        sb.append("\nciphertextSgement");
        sb.append(" position:");
        sb.append(this.f87523b.position());
        sb.append(" limit:");
        sb.append(this.f87523b.limit());
        sb.append("\nisCurrentSegmentDecrypted:");
        sb.append(this.f87534n);
        sb.append("\nplaintextSegment");
        sb.append(" position:");
        sb.append(this.f87524c.position());
        sb.append(" limit:");
        sb.append(this.f87524c.limit());
        return sb.toString();
    }

    @Override // java.nio.channels.SeekableByteChannel
    public SeekableByteChannel truncate(long j3) {
        throw new NonWritableChannelException();
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        throw new NonWritableChannelException();
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized SeekableByteChannel position(long j3) {
        this.f87531k = j3;
        return this;
    }
}
