package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class StreamingAeadEncryptingChannel implements WritableByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WritableByteChannel f87511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private StreamSegmentEncrypter f87512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ByteBuffer f87513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ByteBuffer f87514d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f87515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f87516g;

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.f87516g) {
            while (this.f87514d.remaining() > 0) {
                if (this.f87511a.write(this.f87514d) <= 0) {
                    throw new IOException("Failed to write ciphertext before closing");
                }
            }
            try {
                this.f87514d.clear();
                this.f87513c.flip();
                this.f87512b.a(this.f87513c, true, this.f87514d);
                this.f87514d.flip();
                while (this.f87514d.remaining() > 0) {
                    if (this.f87511a.write(this.f87514d) <= 0) {
                        throw new IOException("Failed to write ciphertext before closing");
                    }
                }
                this.f87511a.close();
                this.f87516g = false;
            } catch (GeneralSecurityException e3) {
                throw new IOException(e3);
            }
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.f87516g;
    }

    @Override // java.nio.channels.WritableByteChannel
    public synchronized int write(ByteBuffer byteBuffer) {
        try {
            if (!this.f87516g) {
                throw new ClosedChannelException();
            }
            if (this.f87514d.remaining() > 0) {
                this.f87511a.write(this.f87514d);
            }
            int iPosition = byteBuffer.position();
            while (byteBuffer.remaining() > this.f87513c.remaining()) {
                if (this.f87514d.remaining() > 0) {
                    return byteBuffer.position() - iPosition;
                }
                int iRemaining = this.f87513c.remaining();
                ByteBuffer byteBufferSlice = byteBuffer.slice();
                byteBufferSlice.limit(iRemaining);
                byteBuffer.position(byteBuffer.position() + iRemaining);
                try {
                    this.f87513c.flip();
                    this.f87514d.clear();
                    if (byteBufferSlice.remaining() != 0) {
                        this.f87512b.b(this.f87513c, byteBufferSlice, false, this.f87514d);
                    } else {
                        this.f87512b.a(this.f87513c, false, this.f87514d);
                    }
                    this.f87514d.flip();
                    this.f87511a.write(this.f87514d);
                    this.f87513c.clear();
                    this.f87513c.limit(this.f87515f);
                } catch (GeneralSecurityException e3) {
                    throw new IOException(e3);
                }
            }
            this.f87513c.put(byteBuffer);
            return byteBuffer.position() - iPosition;
        } catch (Throwable th) {
            throw th;
        }
    }
}
