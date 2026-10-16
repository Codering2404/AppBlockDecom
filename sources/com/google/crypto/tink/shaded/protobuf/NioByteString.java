package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class NioByteString extends ByteString.LeafByteString {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ByteBuffer f87047f;

    NioByteString(ByteBuffer byteBuffer) {
        Internal.b(byteBuffer, "buffer");
        this.f87047f = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    private ByteBuffer V(int i3, int i4) {
        if (i3 < this.f87047f.position() || i4 > this.f87047f.limit() || i3 > i4) {
            throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", Integer.valueOf(i3), Integer.valueOf(i4)));
        }
        ByteBuffer byteBufferSlice = this.f87047f.slice();
        byteBufferSlice.position(i3 - this.f87047f.position());
        byteBufferSlice.limit(i4 - this.f87047f.position());
        return byteBufferSlice;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    private Object writeReplace() {
        return ByteString.n(this.f87047f.slice());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public CodedInputStream B() {
        return CodedInputStream.i(this.f87047f, true);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    protected int C(int i3, int i4, int i5) {
        for (int i6 = i4; i6 < i4 + i5; i6++) {
            i3 = (i3 * 31) + this.f87047f.get(i6);
        }
        return i3;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    protected int D(int i3, int i4, int i5) {
        return Utf8.v(i3, this.f87047f, i4, i5 + i4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public ByteString H(int i3, int i4) {
        try {
            return new NioByteString(V(i3, i4));
        } catch (ArrayIndexOutOfBoundsException e3) {
            throw e3;
        } catch (IndexOutOfBoundsException e4) {
            throw new ArrayIndexOutOfBoundsException(e4.getMessage());
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    protected String L(Charset charset) {
        byte[] bArrI;
        int length;
        int iArrayOffset;
        if (this.f87047f.hasArray()) {
            bArrI = this.f87047f.array();
            iArrayOffset = this.f87047f.arrayOffset() + this.f87047f.position();
            length = this.f87047f.remaining();
        } else {
            bArrI = I();
            length = bArrI.length;
            iArrayOffset = 0;
        }
        return new String(bArrI, iArrayOffset, length, charset);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    void S(ByteOutput byteOutput) {
        byteOutput.R(this.f87047f.slice());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LeafByteString
    boolean U(ByteString byteString, int i3, int i4) {
        return H(0, i4).equals(byteString.H(i3, i4 + i3));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public ByteBuffer b() {
        return this.f87047f.asReadOnlyBuffer();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public byte e(int i3) {
        try {
            return this.f87047f.get(i3);
        } catch (ArrayIndexOutOfBoundsException e3) {
            throw e3;
        } catch (IndexOutOfBoundsException e4) {
            throw new ArrayIndexOutOfBoundsException(e4.getMessage());
        }
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
        if (size() != byteString.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        return obj instanceof NioByteString ? this.f87047f.equals(((NioByteString) obj).f87047f) : obj instanceof RopeByteString ? obj.equals(this) : this.f87047f.equals(byteString.b());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public int size() {
        return this.f87047f.remaining();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    protected void u(byte[] bArr, int i3, int i4, int i5) {
        ByteBuffer byteBufferSlice = this.f87047f.slice();
        byteBufferSlice.position(i3);
        byteBufferSlice.get(bArr, i4, i5);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public byte w(int i3) {
        return e(i3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public boolean y() {
        return Utf8.s(this.f87047f);
    }

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.NioByteString$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f87048a;

        @Override // java.io.InputStream
        public int available() {
            return this.f87048a.remaining();
        }

        @Override // java.io.InputStream
        public void mark(int i3) {
            this.f87048a.mark();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f87048a.hasRemaining()) {
                return this.f87048a.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public void reset() throws IOException {
            try {
                this.f87048a.reset();
            } catch (InvalidMarkException e3) {
                throw new IOException(e3);
            }
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i3, int i4) {
            if (!this.f87048a.hasRemaining()) {
                return -1;
            }
            int iMin = Math.min(i4, this.f87048a.remaining());
            this.f87048a.get(bArr, i3, iMin);
            return iMin;
        }
    }
}
