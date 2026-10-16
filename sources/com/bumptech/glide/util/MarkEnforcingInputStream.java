package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MarkEnforcingInputStream extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f67291a;

    public MarkEnforcingInputStream(InputStream inputStream) {
        super(inputStream);
        this.f67291a = Integer.MIN_VALUE;
    }

    private long a(long j3) {
        int i3 = this.f67291a;
        if (i3 == 0) {
            return -1L;
        }
        return (i3 == Integer.MIN_VALUE || j3 <= ((long) i3)) ? j3 : i3;
    }

    private void b(long j3) {
        int i3 = this.f67291a;
        if (i3 == Integer.MIN_VALUE || j3 == -1) {
            return;
        }
        this.f67291a = (int) (((long) i3) - j3);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        int i3 = this.f67291a;
        return i3 == Integer.MIN_VALUE ? super.available() : Math.min(i3, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i3) {
        super.mark(i3);
        this.f67291a = i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (a(1L) == -1) {
            return -1;
        }
        int i3 = super.read();
        b(1L);
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        super.reset();
        this.f67291a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j3) throws IOException {
        long jA = a(j3);
        if (jA == -1) {
            return 0L;
        }
        long jSkip = super.skip(jA);
        b(jSkip);
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) throws IOException {
        int iA = (int) a(i4);
        if (iA == -1) {
            return -1;
        }
        int i5 = super.read(bArr, i3, iA);
        b(i5);
        return i5;
    }
}
