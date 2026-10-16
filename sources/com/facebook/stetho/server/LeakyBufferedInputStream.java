package com.facebook.stetho.server;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LeakyBufferedInputStream extends BufferedInputStream {
    private boolean mLeaked;
    private boolean mMarked;

    public LeakyBufferedInputStream(InputStream inputStream, int i3) {
        super(inputStream, i3);
    }

    private byte[] clearBufferLocked() {
        int i3 = ((BufferedInputStream) this).count - ((BufferedInputStream) this).pos;
        byte[] bArr = new byte[i3];
        System.arraycopy(((BufferedInputStream) this).buf, ((BufferedInputStream) this).pos, bArr, 0, i3);
        ((BufferedInputStream) this).pos = 0;
        ((BufferedInputStream) this).count = 0;
        return bArr;
    }

    private void throwIfLeaked() {
        if (this.mLeaked) {
            throw new IllegalStateException();
        }
    }

    private void throwIfMarked() {
        if (this.mMarked) {
            throw new IllegalStateException();
        }
    }

    public synchronized InputStream leakBufferAndStream() {
        throwIfLeaked();
        throwIfMarked();
        this.mLeaked = true;
        return new CompositeInputStream(new InputStream[]{new ByteArrayInputStream(clearBufferLocked()), ((BufferedInputStream) this).in});
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i3) {
        throwIfLeaked();
        this.mMarked = true;
        super.mark(i3);
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        throwIfLeaked();
        this.mMarked = false;
        super.reset();
    }
}
