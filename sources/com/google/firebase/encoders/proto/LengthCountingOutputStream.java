package com.google.firebase.encoders.proto;

import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class LengthCountingOutputStream extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f89155a = 0;

    LengthCountingOutputStream() {
    }

    long a() {
        return this.f89155a;
    }

    @Override // java.io.OutputStream
    public void write(int i3) {
        this.f89155a++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.f89155a += (long) bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i3, int i4) {
        int i5;
        if (i3 >= 0 && i3 <= bArr.length && i4 >= 0 && (i5 = i3 + i4) <= bArr.length && i5 >= 0) {
            this.f89155a += (long) i4;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
