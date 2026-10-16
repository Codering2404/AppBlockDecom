package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class RewindableReadableByteChannel implements ReadableByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ReadableByteChannel f87476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ByteBuffer f87477b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f87478c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f87479d = false;

    public RewindableReadableByteChannel(ReadableByteChannel readableByteChannel) {
        this.f87476a = readableByteChannel;
    }

    private synchronized void c(int i3) {
        try {
            if (this.f87477b.capacity() < i3) {
                int iPosition = this.f87477b.position();
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(Math.max(this.f87477b.capacity() * 2, i3));
                this.f87477b.rewind();
                byteBufferAllocate.put(this.f87477b);
                byteBufferAllocate.position(iPosition);
                this.f87477b = byteBufferAllocate;
            }
            this.f87477b.limit(i3);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void a() {
        this.f87478c = false;
    }

    public synchronized void b() {
        if (!this.f87478c) {
            throw new IOException("Cannot rewind anymore.");
        }
        ByteBuffer byteBuffer = this.f87477b;
        if (byteBuffer != null) {
            byteBuffer.position(0);
        }
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f87478c = false;
        this.f87479d = true;
        this.f87476a.close();
    }

    @Override // java.nio.channels.Channel
    public synchronized boolean isOpen() {
        return this.f87476a.isOpen();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer byteBuffer) {
        if (this.f87479d) {
            return this.f87476a.read(byteBuffer);
        }
        int iRemaining = byteBuffer.remaining();
        if (iRemaining == 0) {
            return 0;
        }
        ByteBuffer byteBuffer2 = this.f87477b;
        if (byteBuffer2 == null) {
            if (!this.f87478c) {
                this.f87479d = true;
                return this.f87476a.read(byteBuffer);
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iRemaining);
            this.f87477b = byteBufferAllocate;
            int i3 = this.f87476a.read(byteBufferAllocate);
            this.f87477b.flip();
            if (i3 > 0) {
                byteBuffer.put(this.f87477b);
            }
            return i3;
        }
        if (byteBuffer2.remaining() >= iRemaining) {
            int iLimit = this.f87477b.limit();
            ByteBuffer byteBuffer3 = this.f87477b;
            byteBuffer3.limit(byteBuffer3.position() + iRemaining);
            byteBuffer.put(this.f87477b);
            this.f87477b.limit(iLimit);
            if (!this.f87478c && !this.f87477b.hasRemaining()) {
                this.f87477b = null;
                this.f87479d = true;
            }
            return iRemaining;
        }
        int iRemaining2 = this.f87477b.remaining();
        int iPosition = this.f87477b.position();
        int iLimit2 = this.f87477b.limit();
        c((iRemaining - iRemaining2) + iLimit2);
        this.f87477b.position(iLimit2);
        int i4 = this.f87476a.read(this.f87477b);
        this.f87477b.flip();
        this.f87477b.position(iPosition);
        byteBuffer.put(this.f87477b);
        if (iRemaining2 == 0 && i4 < 0) {
            return -1;
        }
        int iPosition2 = this.f87477b.position() - iPosition;
        if (!this.f87478c && !this.f87477b.hasRemaining()) {
            this.f87477b = null;
            this.f87479d = true;
        }
        return iPosition2;
    }
}
