package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.StreamingAead;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.security.GeneralSecurityException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class SeekableByteChannelDecrypter implements SeekableByteChannel {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    SeekableByteChannel f87315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f87316d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f87317f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    byte[] f87319h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    SeekableByteChannel f87313a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    SeekableByteChannel f87314b = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Deque f87318g = new ArrayDeque();

    public SeekableByteChannelDecrypter(PrimitiveSet primitiveSet, SeekableByteChannel seekableByteChannel, byte[] bArr) {
        Iterator it = primitiveSet.b().iterator();
        while (it.hasNext()) {
            this.f87318g.add((StreamingAead) ((PrimitiveSet.Entry) it.next()).a());
        }
        this.f87315c = seekableByteChannel;
        this.f87316d = -1L;
        this.f87317f = seekableByteChannel.position();
        this.f87319h = (byte[]) bArr.clone();
    }

    private synchronized SeekableByteChannel a() {
        SeekableByteChannel seekableByteChannelB;
        while (!this.f87318g.isEmpty()) {
            this.f87315c.position(this.f87317f);
            try {
                seekableByteChannelB = ((StreamingAead) this.f87318g.removeFirst()).b(this.f87315c, this.f87319h);
                long j3 = this.f87316d;
                if (j3 >= 0) {
                    seekableByteChannelB.position(j3);
                }
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new IOException("No matching key found for the ciphertext in the stream.");
        return seekableByteChannelB;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f87315c.close();
    }

    @Override // java.nio.channels.Channel
    public synchronized boolean isOpen() {
        return this.f87315c.isOpen();
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized SeekableByteChannel position(long j3) {
        try {
            SeekableByteChannel seekableByteChannel = this.f87314b;
            if (seekableByteChannel != null) {
                seekableByteChannel.position(j3);
            } else {
                if (j3 < 0) {
                    throw new IllegalArgumentException("Position must be non-negative");
                }
                this.f87316d = j3;
                SeekableByteChannel seekableByteChannel2 = this.f87313a;
                if (seekableByteChannel2 != null) {
                    seekableByteChannel2.position(j3);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() == 0) {
            return 0;
        }
        SeekableByteChannel seekableByteChannel = this.f87314b;
        if (seekableByteChannel != null) {
            return seekableByteChannel.read(byteBuffer);
        }
        if (this.f87313a == null) {
            this.f87313a = a();
        }
        while (true) {
            try {
                int i3 = this.f87313a.read(byteBuffer);
                if (i3 == 0) {
                    return 0;
                }
                this.f87314b = this.f87313a;
                this.f87313a = null;
                return i3;
            } catch (IOException unused) {
                this.f87313a = a();
            }
        }
    }

    @Override // java.nio.channels.SeekableByteChannel
    public synchronized long size() {
        SeekableByteChannel seekableByteChannel;
        seekableByteChannel = this.f87314b;
        if (seekableByteChannel == null) {
            throw new IOException("Cannot determine size before first read()-call.");
        }
        return seekableByteChannel.size();
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
    public synchronized long position() {
        SeekableByteChannel seekableByteChannel = this.f87314b;
        if (seekableByteChannel != null) {
            return seekableByteChannel.position();
        }
        return this.f87316d;
    }
}
