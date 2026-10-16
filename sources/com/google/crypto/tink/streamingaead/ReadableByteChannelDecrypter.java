package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.StreamingAead;
import com.google.crypto.tink.subtle.RewindableReadableByteChannel;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.security.GeneralSecurityException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class ReadableByteChannelDecrypter implements ReadableByteChannel {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    RewindableReadableByteChannel f87310c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    byte[] f87312f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ReadableByteChannel f87308a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ReadableByteChannel f87309b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Deque f87311d = new ArrayDeque();

    public ReadableByteChannelDecrypter(PrimitiveSet primitiveSet, ReadableByteChannel readableByteChannel, byte[] bArr) {
        Iterator it = primitiveSet.b().iterator();
        while (it.hasNext()) {
            this.f87311d.add((StreamingAead) ((PrimitiveSet.Entry) it.next()).a());
        }
        this.f87310c = new RewindableReadableByteChannel(readableByteChannel);
        this.f87312f = (byte[]) bArr.clone();
    }

    private synchronized ReadableByteChannel a() {
        while (!this.f87311d.isEmpty()) {
            try {
            } catch (GeneralSecurityException unused) {
                this.f87310c.b();
            }
        }
        throw new IOException("No matching key found for the ciphertext in the stream.");
        return ((StreamingAead) this.f87311d.removeFirst()).a(this.f87310c, this.f87312f);
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f87310c.close();
    }

    @Override // java.nio.channels.Channel
    public synchronized boolean isOpen() {
        return this.f87310c.isOpen();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() == 0) {
            return 0;
        }
        ReadableByteChannel readableByteChannel = this.f87309b;
        if (readableByteChannel != null) {
            return readableByteChannel.read(byteBuffer);
        }
        if (this.f87308a == null) {
            this.f87308a = a();
        }
        while (true) {
            try {
                int i3 = this.f87308a.read(byteBuffer);
                if (i3 == 0) {
                    return 0;
                }
                this.f87309b = this.f87308a;
                this.f87308a = null;
                this.f87310c.a();
                return i3;
            } catch (IOException unused) {
                this.f87310c.b();
                this.f87308a = a();
            }
        }
    }
}
