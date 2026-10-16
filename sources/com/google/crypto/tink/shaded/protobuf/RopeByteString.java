package com.google.crypto.tink.shaded.protobuf;

import com.google.android.gms.common.api.Api;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class RopeByteString extends ByteString {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final int[] f87071k = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Api.BaseClientBuilder.API_PRIORITY_OTHER};
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f87072f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ByteString f87073g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ByteString f87074h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f87075i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f87076j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Balancer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayDeque f87080a;

        private Balancer() {
            this.f87080a = new ArrayDeque();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ByteString b(ByteString byteString, ByteString byteString2) {
            c(byteString);
            c(byteString2);
            ByteString ropeByteString = (ByteString) this.f87080a.pop();
            while (!this.f87080a.isEmpty()) {
                ropeByteString = new RopeByteString((ByteString) this.f87080a.pop(), ropeByteString);
            }
            return ropeByteString;
        }

        private void c(ByteString byteString) {
            if (byteString.x()) {
                e(byteString);
                return;
            }
            if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                c(ropeByteString.f87073g);
                c(ropeByteString.f87074h);
            } else {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + byteString.getClass());
            }
        }

        private int d(int i3) {
            int iBinarySearch = Arrays.binarySearch(RopeByteString.f87071k, i3);
            return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
        }

        private void e(ByteString byteString) {
            int iD = d(byteString.size());
            int iA0 = RopeByteString.a0(iD + 1);
            if (this.f87080a.isEmpty() || ((ByteString) this.f87080a.peek()).size() >= iA0) {
                this.f87080a.push(byteString);
                return;
            }
            int iA02 = RopeByteString.a0(iD);
            ByteString ropeByteString = (ByteString) this.f87080a.pop();
            while (true) {
                if (this.f87080a.isEmpty() || ((ByteString) this.f87080a.peek()).size() >= iA02) {
                    break;
                } else {
                    ropeByteString = new RopeByteString((ByteString) this.f87080a.pop(), ropeByteString);
                }
            }
            RopeByteString ropeByteString2 = new RopeByteString(ropeByteString, byteString);
            while (!this.f87080a.isEmpty()) {
                if (((ByteString) this.f87080a.peek()).size() >= RopeByteString.a0(d(ropeByteString2.size()) + 1)) {
                    break;
                } else {
                    ropeByteString2 = new RopeByteString((ByteString) this.f87080a.pop(), ropeByteString2);
                }
            }
            this.f87080a.push(ropeByteString2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class PieceIterator implements Iterator<ByteString.LeafByteString> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayDeque f87081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ByteString.LeafByteString f87082b;

        private ByteString.LeafByteString a(ByteString byteString) {
            while (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                this.f87081a.push(ropeByteString);
                byteString = ropeByteString.f87073g;
            }
            return (ByteString.LeafByteString) byteString;
        }

        private ByteString.LeafByteString b() {
            ByteString.LeafByteString leafByteStringA;
            do {
                ArrayDeque arrayDeque = this.f87081a;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    return null;
                }
                leafByteStringA = a(((RopeByteString) this.f87081a.pop()).f87074h);
            } while (leafByteStringA.isEmpty());
            return leafByteStringA;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public ByteString.LeafByteString next() {
            ByteString.LeafByteString leafByteString = this.f87082b;
            if (leafByteString == null) {
                throw new NoSuchElementException();
            }
            this.f87082b = b();
            return leafByteString;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f87082b != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private PieceIterator(ByteString byteString) {
            if (!(byteString instanceof RopeByteString)) {
                this.f87081a = null;
                this.f87082b = (ByteString.LeafByteString) byteString;
                return;
            }
            RopeByteString ropeByteString = (RopeByteString) byteString;
            ArrayDeque arrayDeque = new ArrayDeque(ropeByteString.v());
            this.f87081a = arrayDeque;
            arrayDeque.push(ropeByteString);
            this.f87082b = a(ropeByteString.f87073g);
        }
    }

    static ByteString X(ByteString byteString, ByteString byteString2) {
        if (byteString2.size() == 0) {
            return byteString;
        }
        if (byteString.size() == 0) {
            return byteString2;
        }
        int size = byteString.size() + byteString2.size();
        if (size < 128) {
            return Y(byteString, byteString2);
        }
        if (byteString instanceof RopeByteString) {
            RopeByteString ropeByteString = (RopeByteString) byteString;
            if (ropeByteString.f87074h.size() + byteString2.size() < 128) {
                return new RopeByteString(ropeByteString.f87073g, Y(ropeByteString.f87074h, byteString2));
            }
            if (ropeByteString.f87073g.v() > ropeByteString.f87074h.v() && ropeByteString.v() > byteString2.v()) {
                return new RopeByteString(ropeByteString.f87073g, new RopeByteString(ropeByteString.f87074h, byteString2));
            }
        }
        return size >= a0(Math.max(byteString.v(), byteString2.v()) + 1) ? new RopeByteString(byteString, byteString2) : new Balancer().b(byteString, byteString2);
    }

    private static ByteString Y(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[size + size2];
        byteString.t(bArr, 0, 0, size);
        byteString2.t(bArr, 0, size, size2);
        return ByteString.Q(bArr);
    }

    private boolean Z(ByteString byteString) {
        PieceIterator pieceIterator = new PieceIterator(this);
        ByteString.LeafByteString next = pieceIterator.next();
        PieceIterator pieceIterator2 = new PieceIterator(byteString);
        ByteString.LeafByteString next2 = pieceIterator2.next();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int size = next.size() - i3;
            int size2 = next2.size() - i4;
            int iMin = Math.min(size, size2);
            if (!(i3 == 0 ? next.U(next2, i4, iMin) : next2.U(next, i3, iMin))) {
                return false;
            }
            i5 += iMin;
            int i6 = this.f87072f;
            if (i5 >= i6) {
                if (i5 == i6) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == size) {
                i3 = 0;
                next = pieceIterator.next();
            } else {
                i3 += iMin;
                next = next;
            }
            if (iMin == size2) {
                next2 = pieceIterator2.next();
                i4 = 0;
            } else {
                i4 += iMin;
            }
        }
    }

    static int a0(int i3) {
        int[] iArr = f87071k;
        return i3 >= iArr.length ? Api.BaseClientBuilder.API_PRIORITY_OTHER : iArr[i3];
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public CodedInputStream B() {
        return CodedInputStream.h(W(), true);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    protected int C(int i3, int i4, int i5) {
        int i6 = i4 + i5;
        int i7 = this.f87075i;
        if (i6 <= i7) {
            return this.f87073g.C(i3, i4, i5);
        }
        if (i4 >= i7) {
            return this.f87074h.C(i3, i4 - i7, i5);
        }
        int i8 = i7 - i4;
        return this.f87074h.C(this.f87073g.C(i3, i4, i8), 0, i5 - i8);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    protected int D(int i3, int i4, int i5) {
        int i6 = i4 + i5;
        int i7 = this.f87075i;
        if (i6 <= i7) {
            return this.f87073g.D(i3, i4, i5);
        }
        if (i4 >= i7) {
            return this.f87074h.D(i3, i4 - i7, i5);
        }
        int i8 = i7 - i4;
        return this.f87074h.D(this.f87073g.D(i3, i4, i8), 0, i5 - i8);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public ByteString H(int i3, int i4) {
        int iG = ByteString.g(i3, i4, this.f87072f);
        if (iG == 0) {
            return ByteString.f86695b;
        }
        if (iG == this.f87072f) {
            return this;
        }
        int i5 = this.f87075i;
        return i4 <= i5 ? this.f87073g.H(i3, i4) : i3 >= i5 ? this.f87074h.H(i3 - i5, i4 - i5) : new RopeByteString(this.f87073g.G(i3), this.f87074h.H(0, i4 - this.f87075i));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    protected String L(Charset charset) {
        return new String(I(), charset);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    void S(ByteOutput byteOutput) {
        this.f87073g.S(byteOutput);
        this.f87074h.S(byteOutput);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    void T(ByteOutput byteOutput) {
        this.f87074h.T(byteOutput);
        this.f87073g.T(byteOutput);
    }

    public List W() {
        ArrayList arrayList = new ArrayList();
        PieceIterator pieceIterator = new PieceIterator(this);
        while (pieceIterator.hasNext()) {
            arrayList.add(pieceIterator.next().b());
        }
        return arrayList;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public ByteBuffer b() {
        return ByteBuffer.wrap(I()).asReadOnlyBuffer();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public byte e(int i3) {
        ByteString.f(i3, this.f87072f);
        return w(i3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.f87072f != byteString.size()) {
            return false;
        }
        if (this.f87072f == 0) {
            return true;
        }
        int iE = E();
        int iE2 = byteString.E();
        if (iE == 0 || iE2 == 0 || iE == iE2) {
            return Z(byteString);
        }
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public int size() {
        return this.f87072f;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    protected void u(byte[] bArr, int i3, int i4, int i5) {
        int i6 = i3 + i5;
        int i7 = this.f87075i;
        if (i6 <= i7) {
            this.f87073g.u(bArr, i3, i4, i5);
        } else {
            if (i3 >= i7) {
                this.f87074h.u(bArr, i3 - i7, i4, i5);
                return;
            }
            int i8 = i7 - i3;
            this.f87073g.u(bArr, i3, i4, i8);
            this.f87074h.u(bArr, 0, i4 + i8, i5 - i8);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    protected int v() {
        return this.f87076j;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    byte w(int i3) {
        int i4 = this.f87075i;
        return i3 < i4 ? this.f87073g.w(i3) : this.f87074h.w(i3 - i4);
    }

    Object writeReplace() {
        return ByteString.Q(I());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    protected boolean x() {
        return this.f87072f >= a0(this.f87076j);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public boolean y() {
        int iD = this.f87073g.D(0, 0, this.f87075i);
        ByteString byteString = this.f87074h;
        return byteString.D(iD, 0, byteString.size()) == 0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString, java.lang.Iterable
    /* JADX INFO: renamed from: z */
    public ByteString.ByteIterator iterator() {
        return new ByteString.AbstractByteIterator() { // from class: com.google.crypto.tink.shaded.protobuf.RopeByteString.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final PieceIterator f87077a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            ByteString.ByteIterator f87078b = b();

            {
                this.f87077a = new PieceIterator(RopeByteString.this);
            }

            private ByteString.ByteIterator b() {
                if (this.f87077a.hasNext()) {
                    return this.f87077a.next().iterator();
                }
                return null;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f87078b != null;
            }

            @Override // com.google.crypto.tink.shaded.protobuf.ByteString.ByteIterator
            public byte nextByte() {
                ByteString.ByteIterator byteIterator = this.f87078b;
                if (byteIterator == null) {
                    throw new NoSuchElementException();
                }
                byte bNextByte = byteIterator.nextByte();
                if (!this.f87078b.hasNext()) {
                    this.f87078b = b();
                }
                return bNextByte;
            }
        };
    }

    private RopeByteString(ByteString byteString, ByteString byteString2) {
        this.f87073g = byteString;
        this.f87074h = byteString2;
        int size = byteString.size();
        this.f87075i = size;
        this.f87072f = size + byteString2.size();
        this.f87076j = Math.max(byteString.v(), byteString2.v()) + 1;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class RopeInputStream extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private PieceIterator f87083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ByteString.LeafByteString f87084b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f87085c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f87086d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f87087f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f87088g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ RopeByteString f87089h;

        private void a() {
            if (this.f87084b != null) {
                int i3 = this.f87086d;
                int i4 = this.f87085c;
                if (i3 == i4) {
                    this.f87087f += i4;
                    this.f87086d = 0;
                    if (!this.f87083a.hasNext()) {
                        this.f87084b = null;
                        this.f87085c = 0;
                    } else {
                        ByteString.LeafByteString next = this.f87083a.next();
                        this.f87084b = next;
                        this.f87085c = next.size();
                    }
                }
            }
        }

        private int b() {
            return this.f87089h.size() - (this.f87087f + this.f87086d);
        }

        private void c() {
            PieceIterator pieceIterator = new PieceIterator(this.f87089h);
            this.f87083a = pieceIterator;
            ByteString.LeafByteString next = pieceIterator.next();
            this.f87084b = next;
            this.f87085c = next.size();
            this.f87086d = 0;
            this.f87087f = 0;
        }

        private int f(byte[] bArr, int i3, int i4) {
            int i5 = i4;
            while (i5 > 0) {
                a();
                if (this.f87084b == null) {
                    break;
                }
                int iMin = Math.min(this.f87085c - this.f87086d, i5);
                if (bArr != null) {
                    this.f87084b.t(bArr, this.f87086d, i3, iMin);
                    i3 += iMin;
                }
                this.f87086d += iMin;
                i5 -= iMin;
            }
            return i4 - i5;
        }

        @Override // java.io.InputStream
        public int available() {
            return b();
        }

        @Override // java.io.InputStream
        public void mark(int i3) {
            this.f87088g = this.f87087f + this.f87086d;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i3, int i4) {
            bArr.getClass();
            if (i3 < 0 || i4 < 0 || i4 > bArr.length - i3) {
                throw new IndexOutOfBoundsException();
            }
            int iF = f(bArr, i3, i4);
            if (iF != 0) {
                return iF;
            }
            if (i4 > 0 || b() == 0) {
                return -1;
            }
            return iF;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            c();
            f(null, 0, this.f87088g);
        }

        @Override // java.io.InputStream
        public long skip(long j3) {
            if (j3 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (j3 > 2147483647L) {
                j3 = 2147483647L;
            }
            return f(null, 0, (int) j3);
        }

        @Override // java.io.InputStream
        public int read() {
            a();
            ByteString.LeafByteString leafByteString = this.f87084b;
            if (leafByteString == null) {
                return -1;
            }
            int i3 = this.f87086d;
            this.f87086d = i3 + 1;
            return leafByteString.e(i3) & 255;
        }
    }
}
