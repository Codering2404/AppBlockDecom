package com.facebook.ads.redexgen.core;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ex, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1539ex extends InputStream {
    public int A00;
    public long A01;
    public InterfaceC2144pF A02;
    public final Uri A03;
    public final C5Y A04;
    public final C1644ge A05;
    public final String A06;

    public C1539ex(C1644ge c1644ge, Uri uri, C5Y c5y) throws IOException {
        this.A05 = c1644ge;
        this.A04 = c5y;
        this.A03 = uri;
        this.A06 = C1579fb.A09(this.A05, this.A03);
        A00(0);
    }

    private void A00(int i3) throws IOException {
        if (this.A02 != null) {
            this.A02.close();
        }
        this.A02 = this.A04.A5I();
        this.A01 = (int) this.A02.AGi(new C04685i(this.A03, i3, -1L, this.A06));
    }

    @Override // java.io.InputStream
    public final int available() {
        return ((int) this.A01) - this.A00;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.A02.close();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        byte[] b3 = new byte[1];
        return read(b3);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i3, int i4) throws IOException {
        int i5 = this.A02.read(bArr, i3, i4);
        int read = this.A00;
        this.A00 = read + i5;
        return i5;
    }

    @Override // java.io.InputStream
    public final long skip(long j3) throws IOException {
        long j4 = this.A01 - ((long) this.A00);
        if (j4 <= 0) {
            return 0L;
        }
        if (j3 > j4) {
            j3 = j4;
        }
        this.A00 = (int) (((long) this.A00) + j3);
        A00(this.A00);
        return j3;
    }
}
