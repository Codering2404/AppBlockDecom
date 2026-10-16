package androidx.datastore.preferences.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class IterableByteBufferInputStream extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Iterator f36445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ByteBuffer f36446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f36447c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f36448d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f36449f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f36450g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private byte[] f36451h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f36452i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f36453j;

    IterableByteBufferInputStream(Iterable iterable) {
        this.f36445a = iterable.iterator();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.f36447c++;
        }
        this.f36448d = -1;
        if (a()) {
            return;
        }
        this.f36446b = Internal.f36427e;
        this.f36448d = 0;
        this.f36449f = 0;
        this.f36453j = 0L;
    }

    private boolean a() {
        this.f36448d++;
        if (!this.f36445a.hasNext()) {
            return false;
        }
        ByteBuffer byteBuffer = (ByteBuffer) this.f36445a.next();
        this.f36446b = byteBuffer;
        this.f36449f = byteBuffer.position();
        if (this.f36446b.hasArray()) {
            this.f36450g = true;
            this.f36451h = this.f36446b.array();
            this.f36452i = this.f36446b.arrayOffset();
        } else {
            this.f36450g = false;
            this.f36453j = UnsafeUtil.k(this.f36446b);
            this.f36451h = null;
        }
        return true;
    }

    private void b(int i3) {
        int i4 = this.f36449f + i3;
        this.f36449f = i4;
        if (i4 == this.f36446b.limit()) {
            a();
        }
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f36448d == this.f36447c) {
            return -1;
        }
        if (this.f36450g) {
            int i3 = this.f36451h[this.f36449f + this.f36452i] & 255;
            b(1);
            return i3;
        }
        int iX = UnsafeUtil.x(((long) this.f36449f) + this.f36453j) & 255;
        b(1);
        return iX;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) {
        if (this.f36448d == this.f36447c) {
            return -1;
        }
        int iLimit = this.f36446b.limit();
        int i5 = this.f36449f;
        int i6 = iLimit - i5;
        if (i4 > i6) {
            i4 = i6;
        }
        if (this.f36450g) {
            System.arraycopy(this.f36451h, i5 + this.f36452i, bArr, i3, i4);
            b(i4);
            return i4;
        }
        int iPosition = this.f36446b.position();
        Java8Compatibility.c(this.f36446b, this.f36449f);
        this.f36446b.get(bArr, i3, i4);
        Java8Compatibility.c(this.f36446b, iPosition);
        b(i4);
        return i4;
    }
}
