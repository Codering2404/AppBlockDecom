package com.facebook.ads.redexgen.core;

import com.google.android.gms.common.api.Api;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0869Lo extends BufferedInputStream {
    public static String[] A03 = {"yEbyHje8NcUxSO9Vq0KCjHXZXQexIrx8", "", "YDpf0JUXXv3vM7KYNqlKfCs4JIrQ9MgF", "YsWjcpRBLEj4Ul19eLlIoi2JTVU6PmF7", "RrIU59JghBJEpeymJLqkoB6uIS3R1kvl", "KslpVvwdI", "eBV46u0KGpW8gKNBF9SaAmjhVwB3niU2", "QySyK0NFyvlSgnCLWPpjCoJkkP0WQU4e"};
    public int A00;
    public int A01;
    public boolean A02;

    public C0869Lo(InputStream inputStream) {
        super(inputStream);
        this.A00 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final boolean A00() {
        return this.A02;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i3) {
        this.A00 = i3;
        super.mark(i3);
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (this.A01 + 1 > this.A00) {
            this.A02 = true;
            return -1;
        }
        int i3 = this.A01 + 1;
        String[] strArr = A03;
        if (strArr[4].charAt(24) == strArr[0].charAt(24)) {
            throw new RuntimeException();
        }
        A03[1] = "Q3BDu8k6tWq8iYS9U8U";
        this.A01 = i3;
        return super.read();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        if (this.A01 + bArr.length > this.A00) {
            this.A02 = true;
            return -1;
        }
        return super.read(bArr);
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i3, int i4) throws IOException {
        if (this.A01 + i4 > this.A00) {
            this.A02 = true;
            return -1;
        }
        int i5 = super.read(bArr, i3, i4);
        int read = this.A01;
        this.A01 = read + i5;
        return i5;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() throws IOException {
        this.A00 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        super.reset();
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j3) throws IOException {
        if (((long) this.A01) + j3 > this.A00) {
            this.A02 = true;
            return 0L;
        }
        this.A01 = (int) (((long) this.A01) + j3);
        return super.skip(j3);
    }
}
