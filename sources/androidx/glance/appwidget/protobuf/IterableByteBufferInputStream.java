package androidx.glance.appwidget.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class IterableByteBufferInputStream extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Iterator f39099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ByteBuffer f39100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f39101c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f39102d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f39103f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f39104g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private byte[] f39105h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f39106i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f39107j;

    IterableByteBufferInputStream(Iterable iterable) {
        this.f39099a = iterable.iterator();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.f39101c++;
        }
        this.f39102d = -1;
        if (a()) {
            return;
        }
        this.f39100b = Internal.f39083e;
        this.f39102d = 0;
        this.f39103f = 0;
        this.f39107j = 0L;
    }

    private boolean a() {
        this.f39102d++;
        if (!this.f39099a.hasNext()) {
            return false;
        }
        ByteBuffer byteBuffer = (ByteBuffer) this.f39099a.next();
        this.f39100b = byteBuffer;
        this.f39103f = byteBuffer.position();
        if (this.f39100b.hasArray()) {
            this.f39104g = true;
            this.f39105h = this.f39100b.array();
            this.f39106i = this.f39100b.arrayOffset();
        } else {
            this.f39104g = false;
            this.f39107j = UnsafeUtil.k(this.f39100b);
            this.f39105h = null;
        }
        return true;
    }

    private void b(int i3) {
        int i4 = this.f39103f + i3;
        this.f39103f = i4;
        if (i4 == this.f39100b.limit()) {
            a();
        }
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f39102d == this.f39101c) {
            return -1;
        }
        if (this.f39104g) {
            int i3 = this.f39105h[this.f39103f + this.f39106i] & 255;
            b(1);
            return i3;
        }
        int iX = UnsafeUtil.x(((long) this.f39103f) + this.f39107j) & 255;
        b(1);
        return iX;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) {
        if (this.f39102d == this.f39101c) {
            return -1;
        }
        int iLimit = this.f39100b.limit();
        int i5 = this.f39103f;
        int i6 = iLimit - i5;
        if (i4 > i6) {
            i4 = i6;
        }
        if (this.f39104g) {
            System.arraycopy(this.f39105h, i5 + this.f39106i, bArr, i3, i4);
            b(i4);
            return i4;
        }
        int iPosition = this.f39100b.position();
        this.f39100b.position(this.f39103f);
        this.f39100b.get(bArr, i3, i4);
        this.f39100b.position(iPosition);
        b(i4);
        return i4;
    }
}
