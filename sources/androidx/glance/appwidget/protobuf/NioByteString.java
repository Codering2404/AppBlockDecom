package androidx.glance.appwidget.protobuf;

import androidx.glance.appwidget.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class NioByteString extends ByteString.LeafByteString {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ByteBuffer f39186f;

    NioByteString(ByteBuffer byteBuffer) {
        Internal.b(byteBuffer, "buffer");
        this.f39186f = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    private ByteBuffer V(int i3, int i4) {
        if (i3 < this.f39186f.position() || i4 > this.f39186f.limit() || i3 > i4) {
            throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", Integer.valueOf(i3), Integer.valueOf(i4)));
        }
        ByteBuffer byteBufferSlice = this.f39186f.slice();
        byteBufferSlice.position(i3 - this.f39186f.position());
        byteBufferSlice.limit(i4 - this.f39186f.position());
        return byteBufferSlice;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    private Object writeReplace() {
        return ByteString.n(this.f39186f.slice());
    }

    @Override // androidx.glance.appwidget.protobuf.ByteString
    public CodedInputStream B() {
        return CodedInputStream.i(this.f39186f, true);
    }

    @Override // androidx.glance.appwidget.protobuf.ByteString
    protected int C(int i3, int i4, int i5) {
        for (int i6 = i4; i6 < i4 + i5; i6++) {
            i3 = (i3 * 31) + this.f39186f.get(i6);
        }
        return i3;
    }

    @Override // androidx.glance.appwidget.protobuf.ByteString
    protected int D(int i3, int i4, int i5) {
        return Utf8.v(i3, this.f39186f, i4, i5 + i4);
    }

    @Override // androidx.glance.appwidget.protobuf.ByteString
    public ByteString H(int i3, int i4) {
        try {
            return new NioByteString(V(i3, i4));
        } catch (ArrayIndexOutOfBoundsException e3) {
            throw e3;
        } catch (IndexOutOfBoundsException e4) {
            throw new ArrayIndexOutOfBoundsException(e4.getMessage());
        }
    }

    @Override // androidx.glance.appwidget.protobuf.ByteString
    protected String L(Charset charset) {
        byte[] bArrI;
        int length;
        int iArrayOffset;
        if (this.f39186f.hasArray()) {
            bArrI = this.f39186f.array();
            iArrayOffset = this.f39186f.arrayOffset() + this.f39186f.position();
            length = this.f39186f.remaining();
        } else {
            bArrI = I();
            length = bArrI.length;
            iArrayOffset = 0;
        }
        return new String(bArrI, iArrayOffset, length, charset);
    }

    @Override // androidx.glance.appwidget.protobuf.ByteString
    void S(ByteOutput byteOutput) {
        byteOutput.R(this.f39186f.slice());
    }

    @Override // androidx.glance.appwidget.protobuf.ByteString.LeafByteString
    boolean U(ByteString byteString, int i3, int i4) {
        return H(0, i4).equals(byteString.H(i3, i4 + i3));
    }

    @Override // androidx.glance.appwidget.protobuf.ByteString
    public ByteBuffer b() {
        return this.f39186f.asReadOnlyBuffer();
    }

    @Override // androidx.glance.appwidget.protobuf.ByteString
    public byte e(int i3) {
        try {
            return this.f39186f.get(i3);
        } catch (ArrayIndexOutOfBoundsException e3) {
            throw e3;
        } catch (IndexOutOfBoundsException e4) {
            throw new ArrayIndexOutOfBoundsException(e4.getMessage());
        }
    }

    @Override // androidx.glance.appwidget.protobuf.ByteString
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
        return obj instanceof NioByteString ? this.f39186f.equals(((NioByteString) obj).f39186f) : obj instanceof RopeByteString ? obj.equals(this) : this.f39186f.equals(byteString.b());
    }

    @Override // androidx.glance.appwidget.protobuf.ByteString
    public int size() {
        return this.f39186f.remaining();
    }

    @Override // androidx.glance.appwidget.protobuf.ByteString
    protected void u(byte[] bArr, int i3, int i4, int i5) {
        ByteBuffer byteBufferSlice = this.f39186f.slice();
        byteBufferSlice.position(i3);
        byteBufferSlice.get(bArr, i4, i5);
    }

    @Override // androidx.glance.appwidget.protobuf.ByteString
    public byte w(int i3) {
        return e(i3);
    }

    @Override // androidx.glance.appwidget.protobuf.ByteString
    public boolean y() {
        return Utf8.s(this.f39186f);
    }

    /* JADX INFO: renamed from: androidx.glance.appwidget.protobuf.NioByteString$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f39187a;

        @Override // java.io.InputStream
        public int available() {
            return this.f39187a.remaining();
        }

        @Override // java.io.InputStream
        public void mark(int i3) {
            this.f39187a.mark();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f39187a.hasRemaining()) {
                return this.f39187a.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public void reset() throws IOException {
            try {
                this.f39187a.reset();
            } catch (InvalidMarkException e3) {
                throw new IOException(e3);
            }
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i3, int i4) {
            if (!this.f39187a.hasRemaining()) {
                return -1;
            }
            int iMin = Math.min(i4, this.f39187a.remaining());
            this.f39187a.get(bArr, i3, iMin);
            return iMin;
        }
    }
}
