package com.bumptech.glide.load.data;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ExifOrientationStream extends FilterInputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f66274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f66275d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f66276f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte f66277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f66278b;

    static {
        byte[] bArr = {-1, -31, 0, Ascii.FS, 69, Framer.EXIT_FRAME_PREFIX, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, Ascii.DC2, 0, 2, 0, 0, 0, 1, 0};
        f66274c = bArr;
        int length = bArr.length;
        f66275d = length;
        f66276f = length + 2;
    }

    public ExifOrientationStream(InputStream inputStream, int i3) {
        super(inputStream);
        if (i3 >= -1 && i3 <= 8) {
            this.f66277a = (byte) i3;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i3);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int i3;
        int i4 = this.f66278b;
        int i5 = (i4 < 2 || i4 > (i3 = f66276f)) ? super.read() : i4 == i3 ? this.f66277a : f66274c[i4 - 2] & 255;
        if (i5 != -1) {
            this.f66278b++;
        }
        return i5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j3) throws IOException {
        long jSkip = super.skip(j3);
        if (jSkip > 0) {
            this.f66278b = (int) (((long) this.f66278b) + jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) throws IOException {
        int i5;
        int i6 = this.f66278b;
        int i7 = f66276f;
        if (i6 > i7) {
            i5 = super.read(bArr, i3, i4);
        } else if (i6 == i7) {
            bArr[i3] = this.f66277a;
            i5 = 1;
        } else if (i6 < 2) {
            i5 = super.read(bArr, i3, 2 - i6);
        } else {
            int iMin = Math.min(i7 - i6, i4);
            System.arraycopy(f66274c, this.f66278b - 2, bArr, i3, iMin);
            i5 = iMin;
        }
        if (i5 > 0) {
            this.f66278b += i5;
        }
        return i5;
    }
}
