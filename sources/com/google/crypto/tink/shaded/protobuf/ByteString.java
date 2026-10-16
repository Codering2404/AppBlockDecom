package com.google.crypto.tink.shaded.protobuf;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@CheckReturnValue
public abstract class ByteString implements Iterable<Byte>, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ByteString f86695b = new LiteralByteString(Internal.f86943d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ByteArrayCopier f86696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Comparator f86697d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f86698a = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
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
    private static final class ArraysByteArrayCopier implements ByteArrayCopier {
        private ArraysByteArrayCopier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.ByteArrayCopier
        public byte[] a(byte[] bArr, int i3, int i4) {
            return Arrays.copyOfRange(bArr, i3, i4 + i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f86702g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f86703h;

        BoundedByteString(byte[] bArr, int i3, int i4) {
            super(bArr);
            ByteString.g(i3, i3 + i4, bArr.length);
            this.f86702g = i3;
            this.f86703h = i4;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString
        protected int V() {
            return this.f86702g;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        public byte e(int i3) {
            ByteString.f(i3, size());
            return this.f86706f[this.f86702g + i3];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        public int size() {
            return this.f86703h;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        protected void u(byte[] bArr, int i3, int i4, int i5) {
            System.arraycopy(this.f86706f, V() + i3, bArr, i4, i5);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        byte w(int i3) {
            return this.f86706f[this.f86702g + i3];
        }

        Object writeReplace() {
            return ByteString.Q(I());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface ByteArrayCopier {
        byte[] a(byte[] bArr, int i3, int i4);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CodedBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CodedOutputStream f86704a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f86705b;

        public ByteString a() {
            this.f86704a.U();
            return new LiteralByteString(this.f86705b);
        }

        public CodedOutputStream b() {
            return this.f86704a;
        }

        private CodedBuilder(int i3) {
            byte[] bArr = new byte[i3];
            this.f86705b = bArr;
            this.f86704a = CodedOutputStream.U0(bArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class LeafByteString extends ByteString {
        LeafByteString() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        void T(ByteOutput byteOutput) {
            S(byteOutput);
        }

        abstract boolean U(ByteString byteString, int i3, int i4);

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return super.iterator();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        protected final int v() {
            return 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        protected final boolean x() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        protected final byte[] f86706f;

        LiteralByteString(byte[] bArr) {
            bArr.getClass();
            this.f86706f = bArr;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final CodedInputStream B() {
            return CodedInputStream.l(this.f86706f, V(), size(), true);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        protected final int C(int i3, int i4, int i5) {
            return Internal.i(i3, this.f86706f, V() + i4, i5);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        protected final int D(int i3, int i4, int i5) {
            int iV = V() + i4;
            return Utf8.w(i3, this.f86706f, iV, i5 + iV);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final ByteString H(int i3, int i4) {
            int iG = ByteString.g(i3, i4, size());
            return iG == 0 ? ByteString.f86695b : new BoundedByteString(this.f86706f, V() + i3, iG);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        protected final String L(Charset charset) {
            return new String(this.f86706f, V(), size(), charset);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        final void S(ByteOutput byteOutput) {
            byteOutput.S(this.f86706f, V(), size());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LeafByteString
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
            byte[] bArr = this.f86706f;
            byte[] bArr2 = literalByteString.f86706f;
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

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final ByteBuffer b() {
            return ByteBuffer.wrap(this.f86706f, V(), size()).asReadOnlyBuffer();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public byte e(int i3) {
            return this.f86706f[i3];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
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

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public int size() {
            return this.f86706f.length;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        protected void u(byte[] bArr, int i3, int i4, int i5) {
            System.arraycopy(this.f86706f, i3, bArr, i4, i5);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        byte w(int i3) {
            return this.f86706f[i3];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final boolean y() {
            int iV = V();
            return Utf8.u(this.f86706f, iV, size() + iV);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SystemByteArrayCopier implements ByteArrayCopier {
        private SystemByteArrayCopier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.ByteArrayCopier
        public byte[] a(byte[] bArr, int i3, int i4) {
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, i3, bArr2, 0, i4);
            return bArr2;
        }
    }

    static {
        f86696c = Android.c() ? new SystemByteArrayCopier() : new ArraysByteArrayCopier();
        f86697d = new Comparator<ByteString>() { // from class: com.google.crypto.tink.shaded.protobuf.ByteString.2
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
        throw new IndexOutOfBoundsException("End index: " + i4 + " >= " + i5);
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
        return size == 0 ? f86695b : d(iterable.iterator(), size);
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
        return new LiteralByteString(f86696c.a(bArr, i3, i4));
    }

    public static ByteString s(String str) {
        return new LiteralByteString(str.getBytes(Internal.f86941b));
    }

    public abstract CodedInputStream B();

    protected abstract int C(int i3, int i4, int i5);

    protected abstract int D(int i3, int i4, int i5);

    protected final int E() {
        return this.f86698a;
    }

    public final ByteString G(int i3) {
        return H(i3, size());
    }

    public abstract ByteString H(int i3, int i4);

    public final byte[] I() {
        int size = size();
        if (size == 0) {
            return Internal.f86943d;
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
        return K(Internal.f86941b);
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
        int iC = this.f86698a;
        if (iC == 0) {
            int size = size();
            iC = C(size, 0, size);
            if (iC == 0) {
                iC = 1;
            }
            this.f86698a = iC;
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
        return new AbstractByteIterator() { // from class: com.google.crypto.tink.shaded.protobuf.ByteString.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f86699a = 0;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f86700b;

            {
                this.f86700b = ByteString.this.size();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f86699a < this.f86700b;
            }

            @Override // com.google.crypto.tink.shaded.protobuf.ByteString.ByteIterator
            public byte nextByte() {
                int i3 = this.f86699a;
                if (i3 >= this.f86700b) {
                    throw new NoSuchElementException();
                }
                this.f86699a = i3 + 1;
                return ByteString.this.w(i3);
            }
        };
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Output extends OutputStream {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final byte[] f86707g = new byte[0];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f86708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList f86709b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f86710c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private byte[] f86711d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f86712f;

        private void a(int i3) {
            this.f86709b.add(new LiteralByteString(this.f86711d));
            int length = this.f86710c + this.f86711d.length;
            this.f86710c = length;
            this.f86711d = new byte[Math.max(this.f86708a, Math.max(i3, length >>> 1))];
            this.f86712f = 0;
        }

        public synchronized int b() {
            return this.f86710c + this.f86712f;
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(b()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i3) {
            try {
                if (this.f86712f == this.f86711d.length) {
                    a(1);
                }
                byte[] bArr = this.f86711d;
                int i4 = this.f86712f;
                this.f86712f = i4 + 1;
                bArr[i4] = (byte) i3;
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i3, int i4) {
            try {
                byte[] bArr2 = this.f86711d;
                int length = bArr2.length;
                int i5 = this.f86712f;
                if (i4 <= length - i5) {
                    System.arraycopy(bArr, i3, bArr2, i5, i4);
                    this.f86712f += i4;
                } else {
                    int length2 = bArr2.length - i5;
                    System.arraycopy(bArr, i3, bArr2, i5, length2);
                    int i6 = i4 - length2;
                    a(i6);
                    System.arraycopy(bArr, i3 + length2, this.f86711d, 0, i6);
                    this.f86712f = i6;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
