package com.singular.sdk.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class QueueFile implements Closeable, Iterable<byte[]> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final byte[] f92619m = new byte[4096];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final RandomAccessFile f92620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f92621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f92622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f92623d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f92624f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Element f92625g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Element f92626h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final byte[] f92627i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f92628j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f92629k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f92630l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Element {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final Element f92631c = new Element(0, 0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long f92632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f92633b;

        Element(long j3, int i3) {
            this.f92632a = j3;
            this.f92633b = i3;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position=" + this.f92632a + ", length=" + this.f92633b + "]";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class ElementIterator implements Iterator<byte[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f92634a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f92635b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f92636c;

        ElementIterator() {
            this.f92635b = QueueFile.this.f92625g.f92632a;
            this.f92636c = QueueFile.this.f92628j;
        }

        private void a() {
            if (QueueFile.this.f92628j != this.f92636c) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] next() {
            if (QueueFile.this.f92630l) {
                throw new IllegalStateException("closed");
            }
            a();
            if (QueueFile.this.isEmpty()) {
                throw new NoSuchElementException();
            }
            int i3 = this.f92634a;
            QueueFile queueFile = QueueFile.this;
            if (i3 >= queueFile.f92624f) {
                throw new NoSuchElementException();
            }
            try {
                Element elementA = queueFile.a(this.f92635b);
                byte[] bArr = new byte[elementA.f92633b];
                long jK = QueueFile.this.K(elementA.f92632a + 4);
                this.f92635b = jK;
                QueueFile.this.z(jK, bArr, 0, elementA.f92633b);
                this.f92635b = QueueFile.this.K(elementA.f92632a + 4 + ((long) elementA.f92633b));
                this.f92634a++;
                return bArr;
            } catch (IOException e3) {
                throw new RuntimeException("todo: throw a proper error", e3);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (QueueFile.this.f92630l) {
                throw new IllegalStateException("closed");
            }
            a();
            return this.f92634a != QueueFile.this.f92624f;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            if (QueueFile.this.isEmpty()) {
                throw new NoSuchElementException();
            }
            if (this.f92634a != 1) {
                throw new UnsupportedOperationException("Removal is only permitted from the head.");
            }
            try {
                QueueFile.this.f();
                this.f92636c = QueueFile.this.f92628j;
                this.f92634a--;
            } catch (IOException e3) {
                throw new RuntimeException("todo: throw a proper error", e3);
            }
        }
    }

    private void C(long j3, byte[] bArr, int i3, int i4) throws IOException {
        long jK = K(j3);
        long j4 = ((long) i4) + jK;
        long j5 = this.f92623d;
        if (j4 <= j5) {
            this.f92620a.seek(jK);
            this.f92620a.write(bArr, i3, i4);
            return;
        }
        int i5 = (int) (j5 - jK);
        this.f92620a.seek(jK);
        this.f92620a.write(bArr, i3, i5);
        this.f92620a.seek(this.f92622c);
        this.f92620a.write(bArr, i3 + i5, i4 - i5);
    }

    private void J(long j3) throws IOException {
        this.f92620a.setLength(j3);
        this.f92620a.getChannel().force(true);
    }

    private void L(long j3, int i3, long j4, long j5) throws IOException {
        this.f92620a.seek(0L);
        if (!this.f92621b) {
            M(this.f92627i, 0, (int) j3);
            M(this.f92627i, 4, i3);
            M(this.f92627i, 8, (int) j4);
            M(this.f92627i, 12, (int) j5);
            this.f92620a.write(this.f92627i, 0, 16);
            return;
        }
        M(this.f92627i, 0, -2147483647);
        N(this.f92627i, 4, j3);
        M(this.f92627i, 12, i3);
        N(this.f92627i, 16, j4);
        N(this.f92627i, 24, j5);
        this.f92620a.write(this.f92627i, 0, 32);
    }

    private static void M(byte[] bArr, int i3, int i4) {
        bArr[i3] = (byte) (i4 >> 24);
        bArr[i3 + 1] = (byte) (i4 >> 16);
        bArr[i3 + 2] = (byte) (i4 >> 8);
        bArr[i3 + 3] = (byte) i4;
    }

    private static void N(byte[] bArr, int i3, long j3) {
        bArr[i3] = (byte) (j3 >> 56);
        bArr[i3 + 1] = (byte) (j3 >> 48);
        bArr[i3 + 2] = (byte) (j3 >> 40);
        bArr[i3 + 3] = (byte) (j3 >> 32);
        bArr[i3 + 4] = (byte) (j3 >> 24);
        bArr[i3 + 5] = (byte) (j3 >> 16);
        bArr[i3 + 6] = (byte) (j3 >> 8);
        bArr[i3 + 7] = (byte) j3;
    }

    private static int b(byte[] bArr, int i3) {
        return ((bArr[i3] & 255) << 24) + ((bArr[i3 + 1] & 255) << 16) + ((bArr[i3 + 2] & 255) << 8) + (bArr[i3 + 3] & 255);
    }

    private void n(long j3, long j4) throws IOException {
        long j5 = j3;
        while (j4 > 0) {
            byte[] bArr = f92619m;
            int iMin = (int) Math.min(j4, bArr.length);
            C(j5, bArr, 0, iMin);
            long j6 = iMin;
            j4 -= j6;
            j5 += j6;
        }
    }

    long K(long j3) {
        long j4 = this.f92623d;
        return j3 < j4 ? j3 : (((long) this.f92622c) + j3) - j4;
    }

    Element a(long j3) throws IOException {
        if (j3 == 0) {
            return Element.f92631c;
        }
        z(j3, this.f92627i, 0, 4);
        return new Element(j3, b(this.f92627i, 0));
    }

    public void clear() throws IOException {
        if (this.f92630l) {
            throw new IOException("closed");
        }
        L(4096L, 0, 0L, 0L);
        if (this.f92629k) {
            this.f92620a.seek(this.f92622c);
            this.f92620a.write(f92619m, 0, 4096 - this.f92622c);
        }
        this.f92624f = 0;
        Element element = Element.f92631c;
        this.f92625g = element;
        this.f92626h = element;
        if (this.f92623d > 4096) {
            J(4096L);
        }
        this.f92623d = 4096L;
        this.f92628j++;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f92630l = true;
        this.f92620a.close();
    }

    public void f() throws IOException {
        l(1);
    }

    public boolean isEmpty() {
        return this.f92624f == 0;
    }

    @Override // java.lang.Iterable
    public Iterator<byte[]> iterator() {
        return new ElementIterator();
    }

    public void l(int i3) throws IOException {
        if (i3 < 0) {
            throw new IllegalArgumentException("Cannot remove negative (" + i3 + ") number of elements.");
        }
        if (i3 == 0) {
            return;
        }
        if (i3 == this.f92624f) {
            clear();
            return;
        }
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (i3 > this.f92624f) {
            throw new IllegalArgumentException("Cannot remove more elements (" + i3 + ") than present in queue (" + this.f92624f + ").");
        }
        Element element = this.f92625g;
        long j3 = element.f92632a;
        int iB = element.f92633b;
        long j4 = 0;
        int i4 = 0;
        long j5 = j3;
        while (i4 < i3) {
            j4 += (long) (iB + 4);
            long jK = K(j5 + 4 + ((long) iB));
            z(jK, this.f92627i, 0, 4);
            iB = b(this.f92627i, 0);
            i4++;
            j5 = jK;
        }
        L(this.f92623d, this.f92624f - i3, j5, this.f92626h.f92632a);
        this.f92624f -= i3;
        this.f92628j++;
        this.f92625g = new Element(j5, iB);
        if (this.f92629k) {
            n(j3, j4);
        }
    }

    public String toString() {
        return QueueFile.class.getSimpleName() + "[length=" + this.f92623d + ", size=" + this.f92624f + ", first=" + this.f92625g + ", last=" + this.f92626h + "]";
    }

    void z(long j3, byte[] bArr, int i3, int i4) throws IOException {
        long jK = K(j3);
        long j4 = ((long) i4) + jK;
        long j5 = this.f92623d;
        if (j4 <= j5) {
            this.f92620a.seek(jK);
            this.f92620a.readFully(bArr, i3, i4);
            return;
        }
        int i5 = (int) (j5 - jK);
        this.f92620a.seek(jK);
        this.f92620a.readFully(bArr, i3, i5);
        this.f92620a.seek(this.f92622c);
        this.f92620a.readFully(bArr, i3 + i5, i4 - i5);
    }
}
