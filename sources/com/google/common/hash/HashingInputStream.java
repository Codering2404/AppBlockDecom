package com.google.common.hash;

import java.io.FilterInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class HashingInputStream extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Hasher f85110a;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i3 = ((FilterInputStream) this).in.read();
        if (i3 != -1) {
            this.f85110a.b((byte) i3);
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new IOException("reset not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) throws IOException {
        int i5 = ((FilterInputStream) this).in.read(bArr, i3, i4);
        if (i5 != -1) {
            this.f85110a.d(bArr, i3, i5);
        }
        return i5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i3) {
    }
}
