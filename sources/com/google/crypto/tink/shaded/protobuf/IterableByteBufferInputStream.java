package com.google.crypto.tink.shaded.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class IterableByteBufferInputStream extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Iterator f86960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ByteBuffer f86961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f86962c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f86963d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f86964f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f86965g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private byte[] f86966h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f86967i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f86968j;

    IterableByteBufferInputStream(Iterable iterable) {
        this.f86960a = iterable.iterator();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.f86962c++;
        }
        this.f86963d = -1;
        if (a()) {
            return;
        }
        this.f86961b = Internal.f86944e;
        this.f86963d = 0;
        this.f86964f = 0;
        this.f86968j = 0L;
    }

    private boolean a() {
        this.f86963d++;
        if (!this.f86960a.hasNext()) {
            return false;
        }
        ByteBuffer byteBuffer = (ByteBuffer) this.f86960a.next();
        this.f86961b = byteBuffer;
        this.f86964f = byteBuffer.position();
        if (this.f86961b.hasArray()) {
            this.f86965g = true;
            this.f86966h = this.f86961b.array();
            this.f86967i = this.f86961b.arrayOffset();
        } else {
            this.f86965g = false;
            this.f86968j = UnsafeUtil.k(this.f86961b);
            this.f86966h = null;
        }
        return true;
    }

    private void b(int i3) {
        int i4 = this.f86964f + i3;
        this.f86964f = i4;
        if (i4 == this.f86961b.limit()) {
            a();
        }
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f86963d == this.f86962c) {
            return -1;
        }
        if (this.f86965g) {
            int i3 = this.f86966h[this.f86964f + this.f86967i] & 255;
            b(1);
            return i3;
        }
        int iX = UnsafeUtil.x(((long) this.f86964f) + this.f86968j) & 255;
        b(1);
        return iX;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) {
        if (this.f86963d == this.f86962c) {
            return -1;
        }
        int iLimit = this.f86961b.limit();
        int i5 = this.f86964f;
        int i6 = iLimit - i5;
        if (i4 > i6) {
            i4 = i6;
        }
        if (this.f86965g) {
            System.arraycopy(this.f86966h, i5 + this.f86967i, bArr, i3, i4);
            b(i4);
            return i4;
        }
        int iPosition = this.f86961b.position();
        this.f86961b.position(this.f86964f);
        this.f86961b.get(bArr, i3, i4);
        this.f86961b.position(iPosition);
        b(i4);
        return i4;
    }
}
