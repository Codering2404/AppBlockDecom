package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ContentLengthInputStream extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f67270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f67271b;

    private ContentLengthInputStream(InputStream inputStream, long j3) {
        super(inputStream);
        this.f67270a = j3;
    }

    private int a(int i3) throws IOException {
        if (i3 >= 0) {
            this.f67271b += i3;
            return i3;
        }
        if (this.f67270a - ((long) this.f67271b) <= 0) {
            return i3;
        }
        throw new IOException("Failed to read all expected data, expected: " + this.f67270a + ", but read: " + this.f67271b);
    }

    public static InputStream b(InputStream inputStream, long j3) {
        return new ContentLengthInputStream(inputStream, j3);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return (int) Math.max(this.f67270a - ((long) this.f67271b), ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        int i3;
        i3 = super.read();
        a(i3 >= 0 ? 1 : -1);
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i3, int i4) {
        return a(super.read(bArr, i3, i4));
    }
}
