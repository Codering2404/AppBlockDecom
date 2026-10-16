package androidx.datastore.preferences.protobuf;

import com.google.android.gms.common.api.Api;
import d.qFm.sECyKyO;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
public abstract class ByteString implements Iterable<Byte>, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ByteString f36020b = new LiteralByteString(Internal.f36426d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ByteArrayCopier f36021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Comparator f36022d;
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f36023a = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    static abstract class AbstractByteIterator implements ByteIterator {
        AbstractByteIterator() {
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class ArraysByteArrayCopier implements ByteArrayCopier {
        private ArraysByteArrayCopier() {
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.ByteArrayCopier
        public byte[] a(byte[] bArr, int i3, int i4) {
            return Arrays.copyOfRange(bArr, i3, i4 + i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f36027g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f36028h;

        BoundedByteString(byte[] bArr, int i3, int i4) {
            super(bArr);
            ByteString.g(i3, i3 + i4, bArr.length);
            this.f36027g = i3;
            this.f36028h = i4;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString
        protected int V() {
            return this.f36027g;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        public byte e(int i3) {
            ByteString.f(i3, size());
            return this.f36031f[this.f36027g + i3];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        public int size() {
            return this.f36028h;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        protected void u(byte[] bArr, int i3, int i4, int i5) {
            System.arraycopy(this.f36031f, V() + i3, bArr, i4, i5);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        byte w(int i3) {
            return this.f36031f[this.f36027g + i3];
        }

        Object writeReplace() {
            return ByteString.Q(I());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private interface ByteArrayCopier {
        byte[] a(byte[] bArr, int i3, int i4);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    static final class CodedBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CodedOutputStream f36029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f36030b;

        public ByteString a() {
            this.f36029a.U();
            return new LiteralByteString(this.f36030b);
        }

        public CodedOutputStream b() {
            return this.f36029a;
        }

        private CodedBuilder(int i3) {
            byte[] bArr = new byte[i3];
            this.f36030b = bArr;
            this.f36029a = CodedOutputStream.X0(bArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    static abstract class LeafByteString extends ByteString {
        private static final long serialVersionUID = 1;

        @Override // androidx.datastore.preferences.protobuf.ByteString
        void T(ByteOutput byteOutput) {
            S(byteOutput);
        }

        abstract boolean U(ByteString byteString, int i3, int i4);

        @Override // androidx.datastore.preferences.protobuf.ByteString, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return super.iterator();
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        protected final int v() {
            return 0;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        protected final boolean x() {
            return true;
        }

        private LeafByteString() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        protected final byte[] f36031f;

        LiteralByteString(byte[] bArr) {
            super();
            bArr.getClass();
            this.f36031f = bArr;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final CodedInputStream B() {
            return CodedInputStream.m(this.f36031f, V(), size(), true);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        protected final int C(int i3, int i4, int i5) {
            return Internal.i(i3, this.f36031f, V() + i4, i5);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        protected final int D(int i3, int i4, int i5) {
            int iV = V() + i4;
            return Utf8.w(i3, this.f36031f, iV, i5 + iV);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final ByteString H(int i3, int i4) {
            int iG = ByteString.g(i3, i4, size());
            return iG == 0 ? ByteString.f36020b : new BoundedByteString(this.f36031f, V() + i3, iG);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        protected final String L(Charset charset) {
            return new String(this.f36031f, V(), size(), charset);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        final void S(ByteOutput byteOutput) {
            byteOutput.S(this.f36031f, V(), size());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LeafByteString
        final boolean U(ByteString byteString, int i3, int i4) {
            if (i4 > byteString.size()) {
                throw new IllegalArgumentException("Length too large: " + i4 + size());
            }
            int i5 = i3 + i4;
            if (i5 > byteString.size()) {
                throw new IllegalArgumentException("Ran off end of other: " + i3 + ", " + i4 + ", " + byteString.size());
            }
            if (!(byteString instanceof LiteralByteString)) {
                return byteString.H(i3, i5).equals(H(0, i4));
            }
            LiteralByteString literalByteString = (LiteralByteString) byteString;
            byte[] bArr = this.f36031f;
            byte[] bArr2 = literalByteString.f36031f;
            int iV = V() + i4;
            int iV2 = V();
            int iV3 = literalByteString.V() + i3;
            while (iV2 < iV) {
                if (bArr[iV2] != bArr2[iV3]) {
                    return false;
                }
                iV2++;
                iV3++;
            }
            return true;
        }

        protected int V() {
            return 0;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final ByteBuffer b() {
            return ByteBuffer.wrap(this.f36031f, V(), size()).asReadOnlyBuffer();
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public byte e(int i3) {
            return this.f36031f[i3];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof LiteralByteString)) {
                return obj.equals(this);
            }
            LiteralByteString literalByteString = (LiteralByteString) obj;
            int iE = E();
            int iE2 = literalByteString.E();
            if (iE == 0 || iE2 == 0 || iE == iE2) {
                return U(literalByteString, 0, size());
            }
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public int size() {
            return this.f36031f.length;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        protected void u(byte[] bArr, int i3, int i4, int i5) {
            System.arraycopy(this.f36031f, i3, bArr, i4, i5);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        byte w(int i3) {
            return this.f36031f[i3];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final boolean y() {
            int iV = V();
            return Utf8.u(this.f36031f, iV, size() + iV);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class NioByteString extends LeafByteString {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ByteBuffer f36032f;

        NioByteString(ByteBuffer byteBuffer) {
            super();
            Internal.b(byteBuffer, "buffer");
            this.f36032f = byteBuffer.slice().order(ByteOrder.nativeOrder());
        }

        private ByteBuffer V(int i3, int i4) {
            if (i3 < this.f36032f.position() || i4 > this.f36032f.limit() || i3 > i4) {
                throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", Integer.valueOf(i3), Integer.valueOf(i4)));
            }
            ByteBuffer byteBufferSlice = this.f36032f.slice();
            Java8Compatibility.c(byteBufferSlice, i3 - this.f36032f.position());
            Java8Compatibility.a(byteBufferSlice, i4 - this.f36032f.position());
            return byteBufferSlice;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
        }

        private Object writeReplace() {
            return ByteString.n(this.f36032f.slice());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public CodedInputStream B() {
            return CodedInputStream.j(this.f36032f, true);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        protected int C(int i3, int i4, int i5) {
            for (int i6 = i4; i6 < i4 + i5; i6++) {
                i3 = (i3 * 31) + this.f36032f.get(i6);
            }
            return i3;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        protected int D(int i3, int i4, int i5) {
            return Utf8.v(i3, this.f36032f, i4, i5 + i4);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public ByteString H(int i3, int i4) {
            try {
                return new NioByteString(V(i3, i4));
            } catch (ArrayIndexOutOfBoundsException e3) {
                throw e3;
            } catch (IndexOutOfBoundsException e4) {
                throw new ArrayIndexOutOfBoundsException(e4.getMessage());
            }
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        protected String L(Charset charset) {
            byte[] bArrI;
            int length;
            int iArrayOffset;
            if (this.f36032f.hasArray()) {
                bArrI = this.f36032f.array();
                iArrayOffset = this.f36032f.arrayOffset() + this.f36032f.position();
                length = this.f36032f.remaining();
            } else {
                bArrI = I();
                length = bArrI.length;
                iArrayOffset = 0;
            }
            return new String(bArrI, iArrayOffset, length, charset);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        void S(ByteOutput byteOutput) {
            byteOutput.R(this.f36032f.slice());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LeafByteString
        boolean U(ByteString byteString, int i3, int i4) {
            return H(0, i4).equals(byteString.H(i3, i4 + i3));
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public ByteBuffer b() {
            return this.f36032f.asReadOnlyBuffer();
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public byte e(int i3) {
            try {
                return this.f36032f.get(i3);
            } catch (ArrayIndexOutOfBoundsException e3) {
                throw e3;
            } catch (IndexOutOfBoundsException e4) {
                throw new ArrayIndexOutOfBoundsException(e4.getMessage());
            }
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString)) {
                return false;
            }
            ByteString byteString = (ByteString) obj;
            if (size() != byteString.size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            return obj instanceof NioByteString ? this.f36032f.equals(((NioByteString) obj).f36032f) : obj instanceof RopeByteString ? obj.equals(this) : this.f36032f.equals(byteString.b());
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public int size() {
            return this.f36032f.remaining();
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        protected void u(byte[] bArr, int i3, int i4, int i5) {
            ByteBuffer byteBufferSlice = this.f36032f.slice();
            Java8Compatibility.c(byteBufferSlice, i3);
            byteBufferSlice.get(bArr, i4, i5);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public byte w(int i3) {
            return e(i3);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public boolean y() {
            return Utf8.s(this.f36032f);
        }

        /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.ByteString$NioByteString$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 extends InputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final ByteBuffer f36033a;

            @Override // java.io.InputStream
            public int available() {
                return this.f36033a.remaining();
            }

            @Override // java.io.InputStream
            public void mark(int i3) {
                Java8Compatibility.b(this.f36033a);
            }

            @Override // java.io.InputStream
            public boolean markSupported() {
                return true;
            }

            @Override // java.io.InputStream
            public int read() {
                if (this.f36033a.hasRemaining()) {
                    return this.f36033a.get() & 255;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public void reset() throws IOException {
                try {
                    Java8Compatibility.d(this.f36033a);
                } catch (InvalidMarkException e3) {
                    throw new IOException(e3);
                }
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i3, int i4) {
                if (!this.f36033a.hasRemaining()) {
                    return -1;
                }
                int iMin = Math.min(i4, this.f36033a.remaining());
                this.f36033a.get(bArr, i3, iMin);
                return iMin;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    private static final class SystemByteArrayCopier implements ByteArrayCopier {
        private SystemByteArrayCopier() {
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.ByteArrayCopier
        public byte[] a(byte[] bArr, int i3, int i4) {
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, i3, bArr2, 0, i4);
            return bArr2;
        }
    }

    static {
        f36021c = Android.c() ? new SystemByteArrayCopier() : new ArraysByteArrayCopier();
        f36022d = new Comparator<ByteString>() { // from class: androidx.datastore.preferences.protobuf.ByteString.2
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(ByteString byteString, ByteString byteString2) {
                ByteIterator it = byteString.iterator();
                ByteIterator it2 = byteString2.iterator();
                while (it.hasNext() && it2.hasNext()) {
                    int iCompareTo = Integer.valueOf(ByteString.J(it.nextByte())).compareTo(Integer.valueOf(ByteString.J(it2.nextByte())));
                    if (iCompareTo != 0) {
                        return iCompareTo;
                    }
                }
                return Integer.valueOf(byteString.size()).compareTo(Integer.valueOf(byteString2.size()));
            }
        };
    }

    ByteString() {
    }

    static CodedBuilder A(int i3) {
        return new CodedBuilder(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int J(byte b3) {
        return b3 & 255;
    }

    private String N() {
        if (size() <= 50) {
            return TextFormatEscaper.a(this);
        }
        return TextFormatEscaper.a(H(0, 47)) + "...";
    }

    static ByteString P(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            return new NioByteString(byteBuffer);
        }
        return R(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
    }

    static ByteString Q(byte[] bArr) {
        return new LiteralByteString(bArr);
    }

    static ByteString R(byte[] bArr, int i3, int i4) {
        return new BoundedByteString(bArr, i3, i4);
    }

    private static ByteString d(Iterator it, int i3) {
        if (i3 < 1) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i3)));
        }
        if (i3 == 1) {
            return (ByteString) it.next();
        }
        int i4 = i3 >>> 1;
        return d(it, i4).h(d(it, i3 - i4));
    }

    static void f(int i3, int i4) {
        if (((i4 - (i3 + 1)) | i3) < 0) {
            if (i3 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i3);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i3 + ", " + i4);
        }
    }

    public static ByteString l(Iterable iterable) {
        int size;
        if (iterable instanceof Collection) {
            size = ((Collection) iterable).size();
        } else {
            Iterator it = iterable.iterator();
            size = 0;
            while (it.hasNext()) {
                it.next();
                size++;
            }
        }
        return size == 0 ? f36020b : d(iterable.iterator(), size);
    }

    public static ByteString n(ByteBuffer byteBuffer) {
        return o(byteBuffer, byteBuffer.remaining());
    }

    public static ByteString o(ByteBuffer byteBuffer, int i3) {
        g(0, i3, byteBuffer.remaining());
        byte[] bArr = new byte[i3];
        byteBuffer.get(bArr);
        return new LiteralByteString(bArr);
    }

    public static ByteString p(byte[] bArr) {
        return q(bArr, 0, bArr.length);
    }

    public static ByteString q(byte[] bArr, int i3, int i4) {
        g(i3, i3 + i4, bArr.length);
        return new LiteralByteString(f36021c.a(bArr, i3, i4));
    }

    public static ByteString s(String str) {
        return new LiteralByteString(str.getBytes(Internal.f36424b));
    }

    public abstract CodedInputStream B();

    protected abstract int C(int i3, int i4, int i5);

    protected abstract int D(int i3, int i4, int i5);

    protected final int E() {
        return this.f36023a;
    }

    public final ByteString G(int i3) {
        return H(i3, size());
    }

    public abstract ByteString H(int i3, int i4);

    public final byte[] I() {
        int size = size();
        if (size == 0) {
            return Internal.f36426d;
        }
        byte[] bArr = new byte[size];
        u(bArr, 0, 0, size);
        return bArr;
    }

    public final String K(Charset charset) {
        return size() == 0 ? "" : L(charset);
    }

    protected abstract String L(Charset charset);

    public final String M() {
        return K(Internal.f36424b);
    }

    abstract void S(ByteOutput byteOutput);

    abstract void T(ByteOutput byteOutput);

    public abstract ByteBuffer b();

    public abstract byte e(int i3);

    public abstract boolean equals(Object obj);

    public final ByteString h(ByteString byteString) {
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - size() >= byteString.size()) {
            return RopeByteString.X(this, byteString);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size() + "+" + byteString.size());
    }

    public final int hashCode() {
        int iC = this.f36023a;
        if (iC == 0) {
            int size = size();
            iC = C(size, 0, size);
            if (iC == 0) {
                iC = 1;
            }
            this.f36023a = iC;
        }
        return iC;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public abstract int size();

    public final void t(byte[] bArr, int i3, int i4, int i5) {
        g(i3, i3 + i5, size());
        g(i4, i4 + i5, bArr.length);
        if (i5 > 0) {
            u(bArr, i3, i4, i5);
        }
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), N());
    }

    protected abstract void u(byte[] bArr, int i3, int i4, int i5);

    protected abstract int v();

    abstract byte w(int i3);

    protected abstract boolean x();

    public abstract boolean y();

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public ByteIterator iterator() {
        return new AbstractByteIterator() { // from class: androidx.datastore.preferences.protobuf.ByteString.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f36024a = 0;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f36025b;

            {
                this.f36025b = ByteString.this.size();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f36024a < this.f36025b;
            }

            @Override // androidx.datastore.preferences.protobuf.ByteString.ByteIterator
            public byte nextByte() {
                int i3 = this.f36024a;
                if (i3 >= this.f36025b) {
                    throw new NoSuchElementException();
                }
                this.f36024a = i3 + 1;
                return ByteString.this.w(i3);
            }
        };
    }

    static int g(int i3, int i4, int i5) {
        int i6 = i4 - i3;
        if ((i3 | i4 | i6 | (i5 - i4)) >= 0) {
            return i6;
        }
        if (i3 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i3 + " < 0");
        }
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i3 + ", " + i4);
        }
        throw new IndexOutOfBoundsException(sECyKyO.PTnBL + i4 + " >= " + i5);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class Output extends OutputStream {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final byte[] f36034g = new byte[0];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f36035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList f36036b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f36037c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private byte[] f36038d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f36039f;

        private void a(int i3) {
            this.f36036b.add(new LiteralByteString(this.f36038d));
            int length = this.f36037c + this.f36038d.length;
            this.f36037c = length;
            this.f36038d = new byte[Math.max(this.f36035a, Math.max(i3, length >>> 1))];
            this.f36039f = 0;
        }

        public synchronized int b() {
            return this.f36037c + this.f36039f;
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(b()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i3) {
            try {
                if (this.f36039f == this.f36038d.length) {
                    a(1);
                }
                byte[] bArr = this.f36038d;
                int i4 = this.f36039f;
                this.f36039f = i4 + 1;
                bArr[i4] = (byte) i3;
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i3, int i4) {
            try {
                byte[] bArr2 = this.f36038d;
                int length = bArr2.length;
                int i5 = this.f36039f;
                if (i4 <= length - i5) {
                    System.arraycopy(bArr, i3, bArr2, i5, i4);
                    this.f36039f += i4;
                } else {
                    int length2 = bArr2.length - i5;
                    System.arraycopy(bArr, i3, bArr2, i5, length2);
                    int i6 = i4 - length2;
                    a(i6);
                    System.arraycopy(bArr, i3 + length2, this.f36038d, 0, i6);
                    this.f36039f = i6;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
