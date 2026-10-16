package androidx.glance.appwidget.protobuf;

import androidx.glance.appwidget.protobuf.Utf8;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CodedOutputStream extends ByteOutput {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Logger f38906c = Logger.getLogger(CodedOutputStream.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean f38907d = UnsafeUtil.J();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    CodedOutputStreamWriter f38908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f38909b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class AbstractBufferedEncoder extends CodedOutputStream {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final byte[] f38910e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f38911f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f38912g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f38913h;

        AbstractBufferedEncoder(int i3) {
            super();
            if (i3 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i3, 20)];
            this.f38910e = bArr;
            this.f38911f = bArr.length;
        }

        final void D1(byte b3) {
            byte[] bArr = this.f38910e;
            int i3 = this.f38912g;
            this.f38912g = i3 + 1;
            bArr[i3] = b3;
            this.f38913h++;
        }

        final void E1(int i3) {
            byte[] bArr = this.f38910e;
            int i4 = this.f38912g;
            int i5 = i4 + 1;
            this.f38912g = i5;
            bArr[i4] = (byte) (i3 & 255);
            int i6 = i4 + 2;
            this.f38912g = i6;
            bArr[i5] = (byte) ((i3 >> 8) & 255);
            int i7 = i4 + 3;
            this.f38912g = i7;
            bArr[i6] = (byte) ((i3 >> 16) & 255);
            this.f38912g = i4 + 4;
            bArr[i7] = (byte) ((i3 >> 24) & 255);
            this.f38913h += 4;
        }

        final void F1(long j3) {
            byte[] bArr = this.f38910e;
            int i3 = this.f38912g;
            int i4 = i3 + 1;
            this.f38912g = i4;
            bArr[i3] = (byte) (j3 & 255);
            int i5 = i3 + 2;
            this.f38912g = i5;
            bArr[i4] = (byte) ((j3 >> 8) & 255);
            int i6 = i3 + 3;
            this.f38912g = i6;
            bArr[i5] = (byte) ((j3 >> 16) & 255);
            int i7 = i3 + 4;
            this.f38912g = i7;
            bArr[i6] = (byte) (255 & (j3 >> 24));
            int i8 = i3 + 5;
            this.f38912g = i8;
            bArr[i7] = (byte) (((int) (j3 >> 32)) & 255);
            int i9 = i3 + 6;
            this.f38912g = i9;
            bArr[i8] = (byte) (((int) (j3 >> 40)) & 255);
            int i10 = i3 + 7;
            this.f38912g = i10;
            bArr[i9] = (byte) (((int) (j3 >> 48)) & 255);
            this.f38912g = i3 + 8;
            bArr[i10] = (byte) (((int) (j3 >> 56)) & 255);
            this.f38913h += 8;
        }

        final void G1(int i3) {
            if (i3 >= 0) {
                I1(i3);
            } else {
                J1(i3);
            }
        }

        final void H1(int i3, int i4) {
            I1(WireFormat.c(i3, i4));
        }

        final void I1(int i3) {
            if (!CodedOutputStream.f38907d) {
                while ((i3 & (-128)) != 0) {
                    byte[] bArr = this.f38910e;
                    int i4 = this.f38912g;
                    this.f38912g = i4 + 1;
                    bArr[i4] = (byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    this.f38913h++;
                    i3 >>>= 7;
                }
                byte[] bArr2 = this.f38910e;
                int i5 = this.f38912g;
                this.f38912g = i5 + 1;
                bArr2[i5] = (byte) i3;
                this.f38913h++;
                return;
            }
            long j3 = this.f38912g;
            while ((i3 & (-128)) != 0) {
                byte[] bArr3 = this.f38910e;
                int i6 = this.f38912g;
                this.f38912g = i6 + 1;
                UnsafeUtil.R(bArr3, i6, (byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                i3 >>>= 7;
            }
            byte[] bArr4 = this.f38910e;
            int i7 = this.f38912g;
            this.f38912g = i7 + 1;
            UnsafeUtil.R(bArr4, i7, (byte) i3);
            this.f38913h += (int) (((long) this.f38912g) - j3);
        }

        final void J1(long j3) {
            if (!CodedOutputStream.f38907d) {
                while ((j3 & (-128)) != 0) {
                    byte[] bArr = this.f38910e;
                    int i3 = this.f38912g;
                    this.f38912g = i3 + 1;
                    bArr[i3] = (byte) ((((int) j3) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    this.f38913h++;
                    j3 >>>= 7;
                }
                byte[] bArr2 = this.f38910e;
                int i4 = this.f38912g;
                this.f38912g = i4 + 1;
                bArr2[i4] = (byte) j3;
                this.f38913h++;
                return;
            }
            long j4 = this.f38912g;
            while ((j3 & (-128)) != 0) {
                byte[] bArr3 = this.f38910e;
                int i5 = this.f38912g;
                this.f38912g = i5 + 1;
                UnsafeUtil.R(bArr3, i5, (byte) ((((int) j3) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                j3 >>>= 7;
            }
            byte[] bArr4 = this.f38910e;
            int i6 = this.f38912g;
            this.f38912g = i6 + 1;
            UnsafeUtil.R(bArr4, i6, (byte) j3);
            this.f38913h += (int) (((long) this.f38912g) - j4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public final int Z0() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ByteOutputEncoder extends AbstractBufferedEncoder {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final ByteOutput f38918i;

        private void K1() {
            this.f38918i.Q(this.f38910e, 0, this.f38912g);
            this.f38912g = 0;
        }

        private void L1(int i3) {
            if (this.f38911f - this.f38912g < i3) {
                K1();
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void A1(int i3, int i4) {
            B1(WireFormat.c(i3, i4));
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void B1(int i3) {
            L1(5);
            I1(i3);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void C1(long j3) {
            L1(10);
            J1(j3);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void M(int i3, ByteString byteString) {
            A1(i3, 2);
            e1(byteString);
        }

        void M1(MessageLite messageLite, Schema schema) {
            B1(((AbstractMessageLite) messageLite).k(schema));
            schema.g(messageLite, this.f38908a);
        }

        @Override // androidx.glance.appwidget.protobuf.ByteOutput
        public void Q(byte[] bArr, int i3, int i4) {
            T0();
            this.f38918i.Q(bArr, i3, i4);
            this.f38913h += i4;
        }

        @Override // androidx.glance.appwidget.protobuf.ByteOutput
        public void R(ByteBuffer byteBuffer) {
            T0();
            int iRemaining = byteBuffer.remaining();
            this.f38918i.R(byteBuffer);
            this.f38913h += iRemaining;
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream, androidx.glance.appwidget.protobuf.ByteOutput
        public void S(byte[] bArr, int i3, int i4) {
            T0();
            this.f38918i.S(bArr, i3, i4);
            this.f38913h += i4;
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void T0() {
            if (this.f38912g > 0) {
                K1();
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void a1(byte b3) {
            if (this.f38912g == this.f38911f) {
                K1();
            }
            D1(b3);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void c(int i3, int i4) {
            L1(14);
            H1(i3, 5);
            E1(i4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void d1(byte[] bArr, int i3, int i4) {
            B1(i4);
            Q(bArr, i3, i4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void e(int i3, String str) throws OutOfSpaceException {
            A1(i3, 2);
            z1(str);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void e1(ByteString byteString) {
            B1(byteString.size());
            byteString.S(this);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void f(int i3, long j3) {
            L1(20);
            H1(i3, 0);
            J1(j3);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void h(int i3, int i4) {
            L1(20);
            H1(i3, 0);
            G1(i4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void h1(int i3) {
            L1(4);
            E1(i3);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void i1(long j3) {
            L1(8);
            F1(j3);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void o(int i3, int i4) {
            L1(20);
            H1(i3, 0);
            I1(i4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void o1(int i3) {
            if (i3 >= 0) {
                B1(i3);
            } else {
                C1(i3);
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void q1(int i3, MessageLite messageLite) {
            A1(i3, 2);
            s1(messageLite);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        void r1(int i3, MessageLite messageLite, Schema schema) {
            A1(i3, 2);
            M1(messageLite, schema);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void s(int i3, long j3) {
            L1(18);
            H1(i3, 1);
            F1(j3);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void s1(MessageLite messageLite) {
            B1(messageLite.c());
            messageLite.i(this);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void t1(int i3, MessageLite messageLite) {
            A1(1, 3);
            o(2, i3);
            q1(3, messageLite);
            A1(1, 4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void u1(int i3, ByteString byteString) {
            A1(1, 3);
            o(2, i3);
            M(3, byteString);
            A1(1, 4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void w(int i3, boolean z2) {
            L1(11);
            H1(i3, 0);
            D1(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void z1(String str) throws OutOfSpaceException {
            int length = str.length() * 3;
            int iO0 = CodedOutputStream.O0(length);
            int i3 = iO0 + length;
            int i4 = this.f38911f;
            if (i3 > i4) {
                byte[] bArr = new byte[length];
                int i5 = Utf8.i(str, bArr, 0, length);
                B1(i5);
                S(bArr, 0, i5);
                return;
            }
            if (i3 > i4 - this.f38912g) {
                K1();
            }
            int i6 = this.f38912g;
            try {
                int iO02 = CodedOutputStream.O0(str.length());
                if (iO02 != iO0) {
                    int iK = Utf8.k(str);
                    I1(iK);
                    this.f38912g = Utf8.i(str, this.f38910e, this.f38912g, iK);
                    this.f38913h += iK;
                    return;
                }
                int i7 = i6 + iO02;
                this.f38912g = i7;
                int i8 = Utf8.i(str, this.f38910e, i7, this.f38911f - i7);
                this.f38912g = i6;
                int i9 = (i8 - i6) - iO02;
                I1(i9);
                this.f38912g = i8;
                this.f38913h += i9;
            } catch (Utf8.UnpairedSurrogateException e3) {
                this.f38913h -= this.f38912g - i6;
                this.f38912g = i6;
                U0(str, e3);
            } catch (IndexOutOfBoundsException e4) {
                throw new OutOfSpaceException(e4);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class HeapNioEncoder extends ArrayEncoder {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final ByteBuffer f38919i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f38920j;

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream.ArrayEncoder, androidx.glance.appwidget.protobuf.CodedOutputStream
        public void T0() {
            this.f38919i.position(this.f38920j + D1());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class OutOfSpaceException extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        OutOfSpaceException(String str) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str);
        }

        OutOfSpaceException(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        OutOfSpaceException(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class OutputStreamEncoder extends AbstractBufferedEncoder {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final OutputStream f38921i;

        OutputStreamEncoder(OutputStream outputStream, int i3) {
            super(i3);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.f38921i = outputStream;
        }

        private void K1() throws IOException {
            this.f38921i.write(this.f38910e, 0, this.f38912g);
            this.f38912g = 0;
        }

        private void L1(int i3) throws IOException {
            if (this.f38911f - this.f38912g < i3) {
                K1();
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void A1(int i3, int i4) throws IOException {
            B1(WireFormat.c(i3, i4));
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void B1(int i3) throws IOException {
            L1(5);
            I1(i3);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void C1(long j3) throws IOException {
            L1(10);
            J1(j3);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void M(int i3, ByteString byteString) throws IOException {
            A1(i3, 2);
            e1(byteString);
        }

        public void M1(ByteBuffer byteBuffer) throws IOException {
            int iRemaining = byteBuffer.remaining();
            int i3 = this.f38911f;
            int i4 = this.f38912g;
            if (i3 - i4 >= iRemaining) {
                byteBuffer.get(this.f38910e, i4, iRemaining);
                this.f38912g += iRemaining;
                this.f38913h += iRemaining;
                return;
            }
            int i5 = i3 - i4;
            byteBuffer.get(this.f38910e, i4, i5);
            int i6 = iRemaining - i5;
            this.f38912g = this.f38911f;
            this.f38913h += i5;
            K1();
            while (true) {
                int i7 = this.f38911f;
                if (i6 <= i7) {
                    byteBuffer.get(this.f38910e, 0, i6);
                    this.f38912g = i6;
                    this.f38913h += i6;
                    return;
                } else {
                    byteBuffer.get(this.f38910e, 0, i7);
                    this.f38921i.write(this.f38910e, 0, this.f38911f);
                    int i8 = this.f38911f;
                    i6 -= i8;
                    this.f38913h += i8;
                }
            }
        }

        void N1(MessageLite messageLite, Schema schema) throws IOException {
            B1(((AbstractMessageLite) messageLite).k(schema));
            schema.g(messageLite, this.f38908a);
        }

        @Override // androidx.glance.appwidget.protobuf.ByteOutput
        public void Q(byte[] bArr, int i3, int i4) throws IOException {
            int i5 = this.f38911f;
            int i6 = this.f38912g;
            if (i5 - i6 >= i4) {
                System.arraycopy(bArr, i3, this.f38910e, i6, i4);
                this.f38912g += i4;
                this.f38913h += i4;
                return;
            }
            int i7 = i5 - i6;
            System.arraycopy(bArr, i3, this.f38910e, i6, i7);
            int i8 = i3 + i7;
            int i9 = i4 - i7;
            this.f38912g = this.f38911f;
            this.f38913h += i7;
            K1();
            if (i9 <= this.f38911f) {
                System.arraycopy(bArr, i8, this.f38910e, 0, i9);
                this.f38912g = i9;
            } else {
                this.f38921i.write(bArr, i8, i9);
            }
            this.f38913h += i9;
        }

        @Override // androidx.glance.appwidget.protobuf.ByteOutput
        public void R(ByteBuffer byteBuffer) throws IOException {
            M1(byteBuffer);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream, androidx.glance.appwidget.protobuf.ByteOutput
        public void S(byte[] bArr, int i3, int i4) throws IOException {
            Q(bArr, i3, i4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void T0() throws IOException {
            if (this.f38912g > 0) {
                K1();
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void a1(byte b3) throws IOException {
            if (this.f38912g == this.f38911f) {
                K1();
            }
            D1(b3);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void c(int i3, int i4) throws IOException {
            L1(14);
            H1(i3, 5);
            E1(i4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void d1(byte[] bArr, int i3, int i4) throws IOException {
            B1(i4);
            Q(bArr, i3, i4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void e(int i3, String str) throws IOException {
            A1(i3, 2);
            z1(str);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void e1(ByteString byteString) throws IOException {
            B1(byteString.size());
            byteString.S(this);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void f(int i3, long j3) throws IOException {
            L1(20);
            H1(i3, 0);
            J1(j3);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void h(int i3, int i4) throws IOException {
            L1(20);
            H1(i3, 0);
            G1(i4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void h1(int i3) throws IOException {
            L1(4);
            E1(i3);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void i1(long j3) throws IOException {
            L1(8);
            F1(j3);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void o(int i3, int i4) throws IOException {
            L1(20);
            H1(i3, 0);
            I1(i4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void o1(int i3) throws IOException {
            if (i3 >= 0) {
                B1(i3);
            } else {
                C1(i3);
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void q1(int i3, MessageLite messageLite) throws IOException {
            A1(i3, 2);
            s1(messageLite);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        void r1(int i3, MessageLite messageLite, Schema schema) throws IOException {
            A1(i3, 2);
            N1(messageLite, schema);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void s(int i3, long j3) throws IOException {
            L1(18);
            H1(i3, 1);
            F1(j3);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void s1(MessageLite messageLite) throws IOException {
            B1(messageLite.c());
            messageLite.i(this);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void t1(int i3, MessageLite messageLite) throws IOException {
            A1(1, 3);
            o(2, i3);
            q1(3, messageLite);
            A1(1, 4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void u1(int i3, ByteString byteString) throws IOException {
            A1(1, 3);
            o(2, i3);
            M(3, byteString);
            A1(1, 4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void w(int i3, boolean z2) throws IOException {
            L1(11);
            H1(i3, 0);
            D1(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void z1(String str) throws IOException {
            int iK;
            try {
                int length = str.length() * 3;
                int iO0 = CodedOutputStream.O0(length);
                int i3 = iO0 + length;
                int i4 = this.f38911f;
                if (i3 > i4) {
                    byte[] bArr = new byte[length];
                    int i5 = Utf8.i(str, bArr, 0, length);
                    B1(i5);
                    S(bArr, 0, i5);
                    return;
                }
                if (i3 > i4 - this.f38912g) {
                    K1();
                }
                int iO02 = CodedOutputStream.O0(str.length());
                int i6 = this.f38912g;
                try {
                    if (iO02 == iO0) {
                        int i7 = i6 + iO02;
                        this.f38912g = i7;
                        int i8 = Utf8.i(str, this.f38910e, i7, this.f38911f - i7);
                        this.f38912g = i6;
                        iK = (i8 - i6) - iO02;
                        I1(iK);
                        this.f38912g = i8;
                    } else {
                        iK = Utf8.k(str);
                        I1(iK);
                        this.f38912g = Utf8.i(str, this.f38910e, this.f38912g, iK);
                    }
                    this.f38913h += iK;
                } catch (Utf8.UnpairedSurrogateException e3) {
                    this.f38913h -= this.f38912g - i6;
                    this.f38912g = i6;
                    throw e3;
                } catch (ArrayIndexOutOfBoundsException e4) {
                    throw new OutOfSpaceException(e4);
                }
            } catch (Utf8.UnpairedSurrogateException e5) {
                U0(str, e5);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SafeDirectNioEncoder extends CodedOutputStream {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ByteBuffer f38922e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ByteBuffer f38923f;

        private void D1(String str) throws OutOfSpaceException {
            try {
                Utf8.j(str, this.f38923f);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void A1(int i3, int i4) throws OutOfSpaceException {
            B1(WireFormat.c(i3, i4));
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void B1(int i3) throws OutOfSpaceException {
            while ((i3 & (-128)) != 0) {
                try {
                    this.f38923f.put((byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                    i3 >>>= 7;
                } catch (BufferOverflowException e3) {
                    throw new OutOfSpaceException(e3);
                }
            }
            this.f38923f.put((byte) i3);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void C1(long j3) throws OutOfSpaceException {
            while (((-128) & j3) != 0) {
                try {
                    this.f38923f.put((byte) ((((int) j3) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                    j3 >>>= 7;
                } catch (BufferOverflowException e3) {
                    throw new OutOfSpaceException(e3);
                }
            }
            this.f38923f.put((byte) j3);
        }

        public void E1(ByteBuffer byteBuffer) throws OutOfSpaceException {
            try {
                this.f38923f.put(byteBuffer);
            } catch (BufferOverflowException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        void F1(MessageLite messageLite, Schema schema) throws OutOfSpaceException {
            B1(((AbstractMessageLite) messageLite).k(schema));
            schema.g(messageLite, this.f38908a);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void M(int i3, ByteString byteString) throws OutOfSpaceException {
            A1(i3, 2);
            e1(byteString);
        }

        @Override // androidx.glance.appwidget.protobuf.ByteOutput
        public void Q(byte[] bArr, int i3, int i4) throws OutOfSpaceException {
            try {
                this.f38923f.put(bArr, i3, i4);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(e3);
            } catch (BufferOverflowException e4) {
                throw new OutOfSpaceException(e4);
            }
        }

        @Override // androidx.glance.appwidget.protobuf.ByteOutput
        public void R(ByteBuffer byteBuffer) throws OutOfSpaceException {
            E1(byteBuffer);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream, androidx.glance.appwidget.protobuf.ByteOutput
        public void S(byte[] bArr, int i3, int i4) throws OutOfSpaceException {
            Q(bArr, i3, i4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void T0() {
            this.f38922e.position(this.f38923f.position());
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public int Z0() {
            return this.f38923f.remaining();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void a1(byte b3) throws OutOfSpaceException {
            try {
                this.f38923f.put(b3);
            } catch (BufferOverflowException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void c(int i3, int i4) throws OutOfSpaceException {
            A1(i3, 5);
            h1(i4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void d1(byte[] bArr, int i3, int i4) throws OutOfSpaceException {
            B1(i4);
            Q(bArr, i3, i4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void e(int i3, String str) throws OutOfSpaceException {
            A1(i3, 2);
            z1(str);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void e1(ByteString byteString) throws OutOfSpaceException {
            B1(byteString.size());
            byteString.S(this);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void f(int i3, long j3) throws OutOfSpaceException {
            A1(i3, 0);
            C1(j3);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void h(int i3, int i4) throws OutOfSpaceException {
            A1(i3, 0);
            o1(i4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void h1(int i3) throws OutOfSpaceException {
            try {
                this.f38923f.putInt(i3);
            } catch (BufferOverflowException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void i1(long j3) throws OutOfSpaceException {
            try {
                this.f38923f.putLong(j3);
            } catch (BufferOverflowException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void o(int i3, int i4) throws OutOfSpaceException {
            A1(i3, 0);
            B1(i4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void o1(int i3) throws OutOfSpaceException {
            if (i3 >= 0) {
                B1(i3);
            } else {
                C1(i3);
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void q1(int i3, MessageLite messageLite) throws OutOfSpaceException {
            A1(i3, 2);
            s1(messageLite);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        void r1(int i3, MessageLite messageLite, Schema schema) throws OutOfSpaceException {
            A1(i3, 2);
            F1(messageLite, schema);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void s(int i3, long j3) throws OutOfSpaceException {
            A1(i3, 1);
            i1(j3);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void s1(MessageLite messageLite) throws OutOfSpaceException {
            B1(messageLite.c());
            messageLite.i(this);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void t1(int i3, MessageLite messageLite) throws OutOfSpaceException {
            A1(1, 3);
            o(2, i3);
            q1(3, messageLite);
            A1(1, 4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void u1(int i3, ByteString byteString) throws OutOfSpaceException {
            A1(1, 3);
            o(2, i3);
            M(3, byteString);
            A1(1, 4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void w(int i3, boolean z2) throws OutOfSpaceException {
            A1(i3, 0);
            a1(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void z1(String str) throws OutOfSpaceException {
            int iPosition = this.f38923f.position();
            try {
                int iO0 = CodedOutputStream.O0(str.length() * 3);
                int iO02 = CodedOutputStream.O0(str.length());
                if (iO02 != iO0) {
                    B1(Utf8.k(str));
                    D1(str);
                    return;
                }
                int iPosition2 = this.f38923f.position() + iO02;
                this.f38923f.position(iPosition2);
                D1(str);
                int iPosition3 = this.f38923f.position();
                this.f38923f.position(iPosition);
                B1(iPosition3 - iPosition2);
                this.f38923f.position(iPosition3);
            } catch (Utf8.UnpairedSurrogateException e3) {
                this.f38923f.position(iPosition);
                U0(str, e3);
            } catch (IllegalArgumentException e4) {
                throw new OutOfSpaceException(e4);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class UnsafeDirectNioEncoder extends CodedOutputStream {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ByteBuffer f38924e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ByteBuffer f38925f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final long f38926g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final long f38927h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final long f38928i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f38929j;

        private int D1(long j3) {
            return (int) (j3 - this.f38926g);
        }

        private void E1(long j3) {
            this.f38925f.position(D1(j3));
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void A1(int i3, int i4) throws OutOfSpaceException {
            B1(WireFormat.c(i3, i4));
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void B1(int i3) throws OutOfSpaceException {
            if (this.f38929j <= this.f38928i) {
                while ((i3 & (-128)) != 0) {
                    long j3 = this.f38929j;
                    this.f38929j = j3 + 1;
                    UnsafeUtil.Q(j3, (byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                    i3 >>>= 7;
                }
                long j4 = this.f38929j;
                this.f38929j = 1 + j4;
                UnsafeUtil.Q(j4, (byte) i3);
                return;
            }
            while (true) {
                long j5 = this.f38929j;
                if (j5 >= this.f38927h) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f38929j), Long.valueOf(this.f38927h), 1));
                }
                if ((i3 & (-128)) == 0) {
                    this.f38929j = 1 + j5;
                    UnsafeUtil.Q(j5, (byte) i3);
                    return;
                } else {
                    this.f38929j = j5 + 1;
                    UnsafeUtil.Q(j5, (byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                    i3 >>>= 7;
                }
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void C1(long j3) throws OutOfSpaceException {
            if (this.f38929j <= this.f38928i) {
                while ((j3 & (-128)) != 0) {
                    long j4 = this.f38929j;
                    this.f38929j = j4 + 1;
                    UnsafeUtil.Q(j4, (byte) ((((int) j3) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                    j3 >>>= 7;
                }
                long j5 = this.f38929j;
                this.f38929j = 1 + j5;
                UnsafeUtil.Q(j5, (byte) j3);
                return;
            }
            while (true) {
                long j6 = this.f38929j;
                if (j6 >= this.f38927h) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f38929j), Long.valueOf(this.f38927h), 1));
                }
                if ((j3 & (-128)) == 0) {
                    this.f38929j = 1 + j6;
                    UnsafeUtil.Q(j6, (byte) j3);
                    return;
                } else {
                    this.f38929j = j6 + 1;
                    UnsafeUtil.Q(j6, (byte) ((((int) j3) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                    j3 >>>= 7;
                }
            }
        }

        public void F1(ByteBuffer byteBuffer) throws OutOfSpaceException {
            try {
                int iRemaining = byteBuffer.remaining();
                E1(this.f38929j);
                this.f38925f.put(byteBuffer);
                this.f38929j += (long) iRemaining;
            } catch (BufferOverflowException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        void G1(MessageLite messageLite, Schema schema) throws OutOfSpaceException {
            B1(((AbstractMessageLite) messageLite).k(schema));
            schema.g(messageLite, this.f38908a);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void M(int i3, ByteString byteString) throws OutOfSpaceException {
            A1(i3, 2);
            e1(byteString);
        }

        @Override // androidx.glance.appwidget.protobuf.ByteOutput
        public void Q(byte[] bArr, int i3, int i4) throws OutOfSpaceException {
            if (bArr != null && i3 >= 0 && i4 >= 0 && bArr.length - i4 >= i3) {
                long j3 = i4;
                long j4 = this.f38927h - j3;
                long j5 = this.f38929j;
                if (j4 >= j5) {
                    UnsafeUtil.q(bArr, i3, j5, j3);
                    this.f38929j += j3;
                    return;
                }
            }
            if (bArr != null) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f38929j), Long.valueOf(this.f38927h), Integer.valueOf(i4)));
            }
            throw new NullPointerException("value");
        }

        @Override // androidx.glance.appwidget.protobuf.ByteOutput
        public void R(ByteBuffer byteBuffer) throws OutOfSpaceException {
            F1(byteBuffer);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream, androidx.glance.appwidget.protobuf.ByteOutput
        public void S(byte[] bArr, int i3, int i4) throws OutOfSpaceException {
            Q(bArr, i3, i4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void T0() {
            this.f38924e.position(D1(this.f38929j));
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public int Z0() {
            return (int) (this.f38927h - this.f38929j);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void a1(byte b3) throws OutOfSpaceException {
            long j3 = this.f38929j;
            if (j3 >= this.f38927h) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f38929j), Long.valueOf(this.f38927h), 1));
            }
            this.f38929j = 1 + j3;
            UnsafeUtil.Q(j3, b3);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void c(int i3, int i4) throws OutOfSpaceException {
            A1(i3, 5);
            h1(i4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void d1(byte[] bArr, int i3, int i4) throws OutOfSpaceException {
            B1(i4);
            Q(bArr, i3, i4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void e(int i3, String str) throws OutOfSpaceException {
            A1(i3, 2);
            z1(str);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void e1(ByteString byteString) throws OutOfSpaceException {
            B1(byteString.size());
            byteString.S(this);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void f(int i3, long j3) throws OutOfSpaceException {
            A1(i3, 0);
            C1(j3);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void h(int i3, int i4) throws OutOfSpaceException {
            A1(i3, 0);
            o1(i4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void h1(int i3) {
            this.f38925f.putInt(D1(this.f38929j), i3);
            this.f38929j += 4;
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void i1(long j3) {
            this.f38925f.putLong(D1(this.f38929j), j3);
            this.f38929j += 8;
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void o(int i3, int i4) throws OutOfSpaceException {
            A1(i3, 0);
            B1(i4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void o1(int i3) throws OutOfSpaceException {
            if (i3 >= 0) {
                B1(i3);
            } else {
                C1(i3);
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void q1(int i3, MessageLite messageLite) throws OutOfSpaceException {
            A1(i3, 2);
            s1(messageLite);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        void r1(int i3, MessageLite messageLite, Schema schema) throws OutOfSpaceException {
            A1(i3, 2);
            G1(messageLite, schema);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void s(int i3, long j3) throws OutOfSpaceException {
            A1(i3, 1);
            i1(j3);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void s1(MessageLite messageLite) throws OutOfSpaceException {
            B1(messageLite.c());
            messageLite.i(this);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void t1(int i3, MessageLite messageLite) throws OutOfSpaceException {
            A1(1, 3);
            o(2, i3);
            q1(3, messageLite);
            A1(1, 4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void u1(int i3, ByteString byteString) throws OutOfSpaceException {
            A1(1, 3);
            o(2, i3);
            M(3, byteString);
            A1(1, 4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void w(int i3, boolean z2) throws OutOfSpaceException {
            A1(i3, 0);
            a1(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void z1(String str) throws OutOfSpaceException {
            long j3 = this.f38929j;
            try {
                int iO0 = CodedOutputStream.O0(str.length() * 3);
                int iO02 = CodedOutputStream.O0(str.length());
                if (iO02 != iO0) {
                    int iK = Utf8.k(str);
                    B1(iK);
                    E1(this.f38929j);
                    Utf8.j(str, this.f38925f);
                    this.f38929j += (long) iK;
                    return;
                }
                int iD1 = D1(this.f38929j) + iO02;
                this.f38925f.position(iD1);
                Utf8.j(str, this.f38925f);
                int iPosition = this.f38925f.position() - iD1;
                B1(iPosition);
                this.f38929j += (long) iPosition;
            } catch (Utf8.UnpairedSurrogateException e3) {
                this.f38929j = j3;
                E1(j3);
                U0(str, e3);
            } catch (IllegalArgumentException e4) {
                throw new OutOfSpaceException(e4);
            } catch (IndexOutOfBoundsException e5) {
                throw new OutOfSpaceException(e5);
            }
        }
    }

    static int A0(int i3) {
        if (i3 > 4096) {
            return 4096;
        }
        return i3;
    }

    public static int B0(int i3, ByteString byteString) {
        return (M0(1) * 2) + N0(2, i3) + Y(3, byteString);
    }

    public static int C0(int i3, int i4) {
        return M0(i3) + D0(i4);
    }

    public static int D0(int i3) {
        return 4;
    }

    public static int E0(int i3, long j3) {
        return M0(i3) + F0(j3);
    }

    public static int F0(long j3) {
        return 8;
    }

    public static int G0(int i3, int i4) {
        return M0(i3) + H0(i4);
    }

    public static int H0(int i3) {
        return O0(R0(i3));
    }

    public static int I0(int i3, long j3) {
        return M0(i3) + J0(j3);
    }

    public static int J0(long j3) {
        return Q0(S0(j3));
    }

    public static int K0(int i3, String str) {
        return M0(i3) + L0(str);
    }

    public static int L0(String str) {
        int length;
        try {
            length = Utf8.k(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            length = str.getBytes(Internal.f39080b).length;
        }
        return u0(length);
    }

    public static int M0(int i3) {
        return O0(WireFormat.c(i3, 0));
    }

    public static int N0(int i3, int i4) {
        return M0(i3) + O0(i4);
    }

    public static int O0(int i3) {
        if ((i3 & (-128)) == 0) {
            return 1;
        }
        if ((i3 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i3) == 0) {
            return 3;
        }
        return (i3 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int P0(int i3, long j3) {
        return M0(i3) + Q0(j3);
    }

    public static int Q0(long j3) {
        int i3;
        if (((-128) & j3) == 0) {
            return 1;
        }
        if (j3 < 0) {
            return 10;
        }
        if (((-34359738368L) & j3) != 0) {
            j3 >>>= 28;
            i3 = 6;
        } else {
            i3 = 2;
        }
        if (((-2097152) & j3) != 0) {
            i3 += 2;
            j3 >>>= 14;
        }
        return (j3 & (-16384)) != 0 ? i3 + 1 : i3;
    }

    public static int R0(int i3) {
        return (i3 >> 31) ^ (i3 << 1);
    }

    public static long S0(long j3) {
        return (j3 >> 63) ^ (j3 << 1);
    }

    public static int V(int i3, boolean z2) {
        return M0(i3) + W(z2);
    }

    public static int W(boolean z2) {
        return 1;
    }

    public static CodedOutputStream W0(OutputStream outputStream, int i3) {
        return new OutputStreamEncoder(outputStream, i3);
    }

    public static int X(byte[] bArr) {
        return u0(bArr.length);
    }

    public static CodedOutputStream X0(byte[] bArr) {
        return Y0(bArr, 0, bArr.length);
    }

    public static int Y(int i3, ByteString byteString) {
        return M0(i3) + Z(byteString);
    }

    public static CodedOutputStream Y0(byte[] bArr, int i3, int i4) {
        return new ArrayEncoder(bArr, i3, i4);
    }

    public static int Z(ByteString byteString) {
        return u0(byteString.size());
    }

    public static int a0(int i3, double d3) {
        return M0(i3) + b0(d3);
    }

    public static int b0(double d3) {
        return 8;
    }

    public static int c0(int i3, int i4) {
        return M0(i3) + d0(i4);
    }

    public static int d0(int i3) {
        return o0(i3);
    }

    public static int e0(int i3, int i4) {
        return M0(i3) + f0(i4);
    }

    public static int f0(int i3) {
        return 4;
    }

    public static int g0(int i3, long j3) {
        return M0(i3) + h0(j3);
    }

    public static int h0(long j3) {
        return 8;
    }

    public static int i0(int i3, float f3) {
        return M0(i3) + j0(f3);
    }

    public static int j0(float f3) {
        return 4;
    }

    static int k0(int i3, MessageLite messageLite, Schema schema) {
        return (M0(i3) * 2) + m0(messageLite, schema);
    }

    public static int l0(MessageLite messageLite) {
        return messageLite.c();
    }

    static int m0(MessageLite messageLite, Schema schema) {
        return ((AbstractMessageLite) messageLite).k(schema);
    }

    public static int n0(int i3, int i4) {
        return M0(i3) + o0(i4);
    }

    public static int o0(int i3) {
        if (i3 >= 0) {
            return O0(i3);
        }
        return 10;
    }

    public static int p0(int i3, long j3) {
        return M0(i3) + q0(j3);
    }

    public static int q0(long j3) {
        return Q0(j3);
    }

    public static int r0(int i3, LazyFieldLite lazyFieldLite) {
        return (M0(1) * 2) + N0(2, i3) + s0(3, lazyFieldLite);
    }

    public static int s0(int i3, LazyFieldLite lazyFieldLite) {
        return M0(i3) + t0(lazyFieldLite);
    }

    public static int t0(LazyFieldLite lazyFieldLite) {
        return u0(lazyFieldLite.b());
    }

    static int u0(int i3) {
        return O0(i3) + i3;
    }

    public static int v0(int i3, MessageLite messageLite) {
        return (M0(1) * 2) + N0(2, i3) + w0(3, messageLite);
    }

    public static int w0(int i3, MessageLite messageLite) {
        return M0(i3) + y0(messageLite);
    }

    static int x0(int i3, MessageLite messageLite, Schema schema) {
        return M0(i3) + z0(messageLite, schema);
    }

    public static int y0(MessageLite messageLite) {
        return u0(messageLite.c());
    }

    static int z0(MessageLite messageLite, Schema schema) {
        return u0(((AbstractMessageLite) messageLite).k(schema));
    }

    public abstract void A1(int i3, int i4);

    public abstract void B1(int i3);

    public final void C(int i3, float f3) {
        c(i3, Float.floatToRawIntBits(f3));
    }

    public abstract void C1(long j3);

    public final void F(int i3, int i4) {
        h(i3, i4);
    }

    public final void I(int i3, int i4) {
        o(i3, R0(i4));
    }

    public abstract void M(int i3, ByteString byteString);

    @Override // androidx.glance.appwidget.protobuf.ByteOutput
    public abstract void S(byte[] bArr, int i3, int i4);

    public abstract void T0();

    public final void U() {
        if (Z0() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    final void U0(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws OutOfSpaceException {
        f38906c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) unpairedSurrogateException);
        byte[] bytes = str.getBytes(Internal.f39080b);
        try {
            B1(bytes.length);
            S(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e3) {
            throw new OutOfSpaceException(e3);
        }
    }

    boolean V0() {
        return this.f38909b;
    }

    public abstract int Z0();

    public abstract void a1(byte b3);

    public final void b1(boolean z2) {
        a1(z2 ? (byte) 1 : (byte) 0);
    }

    public abstract void c(int i3, int i4);

    public final void c1(byte[] bArr) {
        d1(bArr, 0, bArr.length);
    }

    abstract void d1(byte[] bArr, int i3, int i4);

    public abstract void e(int i3, String str);

    public abstract void e1(ByteString byteString);

    public abstract void f(int i3, long j3);

    public final void f1(double d3) {
        i1(Double.doubleToRawLongBits(d3));
    }

    public final void g1(int i3) {
        o1(i3);
    }

    public abstract void h(int i3, int i4);

    public abstract void h1(int i3);

    public final void i(int i3, long j3) {
        s(i3, j3);
    }

    public abstract void i1(long j3);

    public final void j1(float f3) {
        h1(Float.floatToRawIntBits(f3));
    }

    public final void k1(int i3, MessageLite messageLite) {
        A1(i3, 3);
        m1(messageLite);
        A1(i3, 4);
    }

    final void l1(int i3, MessageLite messageLite, Schema schema) {
        A1(i3, 3);
        n1(messageLite, schema);
        A1(i3, 4);
    }

    public final void m(int i3, long j3) {
        f(i3, S0(j3));
    }

    public final void m1(MessageLite messageLite) {
        messageLite.i(this);
    }

    final void n1(MessageLite messageLite, Schema schema) {
        schema.g(messageLite, this.f38908a);
    }

    public abstract void o(int i3, int i4);

    public abstract void o1(int i3);

    public final void p(int i3, double d3) {
        s(i3, Double.doubleToRawLongBits(d3));
    }

    public final void p1(long j3) {
        C1(j3);
    }

    public abstract void q1(int i3, MessageLite messageLite);

    abstract void r1(int i3, MessageLite messageLite, Schema schema);

    public abstract void s(int i3, long j3);

    public abstract void s1(MessageLite messageLite);

    public abstract void t1(int i3, MessageLite messageLite);

    public abstract void u1(int i3, ByteString byteString);

    public final void v(int i3, long j3) {
        f(i3, j3);
    }

    public final void v1(int i3) {
        h1(i3);
    }

    public abstract void w(int i3, boolean z2);

    public final void w1(long j3) {
        i1(j3);
    }

    public final void x(int i3, int i4) {
        c(i3, i4);
    }

    public final void x1(int i3) {
        B1(R0(i3));
    }

    public final void y1(long j3) {
        C1(S0(j3));
    }

    public abstract void z1(String str);

    private CodedOutputStream() {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ArrayEncoder extends CodedOutputStream {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final byte[] f38914e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f38915f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f38916g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f38917h;

        ArrayEncoder(byte[] bArr, int i3, int i4) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i5 = i3 + i4;
            if ((i3 | i4 | (bArr.length - i5)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i3), Integer.valueOf(i4)));
            }
            this.f38914e = bArr;
            this.f38915f = i3;
            this.f38917h = i3;
            this.f38916g = i5;
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public final void A1(int i3, int i4) throws OutOfSpaceException {
            B1(WireFormat.c(i3, i4));
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public final void B1(int i3) throws OutOfSpaceException {
            while ((i3 & (-128)) != 0) {
                try {
                    byte[] bArr = this.f38914e;
                    int i4 = this.f38917h;
                    this.f38917h = i4 + 1;
                    bArr[i4] = (byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    i3 >>>= 7;
                } catch (IndexOutOfBoundsException e3) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f38917h), Integer.valueOf(this.f38916g), 1), e3);
                }
            }
            byte[] bArr2 = this.f38914e;
            int i5 = this.f38917h;
            this.f38917h = i5 + 1;
            bArr2[i5] = (byte) i3;
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public final void C1(long j3) throws OutOfSpaceException {
            if (CodedOutputStream.f38907d && Z0() >= 10) {
                while ((j3 & (-128)) != 0) {
                    byte[] bArr = this.f38914e;
                    int i3 = this.f38917h;
                    this.f38917h = i3 + 1;
                    UnsafeUtil.R(bArr, i3, (byte) ((((int) j3) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                    j3 >>>= 7;
                }
                byte[] bArr2 = this.f38914e;
                int i4 = this.f38917h;
                this.f38917h = i4 + 1;
                UnsafeUtil.R(bArr2, i4, (byte) j3);
                return;
            }
            while ((j3 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f38914e;
                    int i5 = this.f38917h;
                    this.f38917h = i5 + 1;
                    bArr3[i5] = (byte) ((((int) j3) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    j3 >>>= 7;
                } catch (IndexOutOfBoundsException e3) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f38917h), Integer.valueOf(this.f38916g), 1), e3);
                }
            }
            byte[] bArr4 = this.f38914e;
            int i6 = this.f38917h;
            this.f38917h = i6 + 1;
            bArr4[i6] = (byte) j3;
        }

        public final int D1() {
            return this.f38917h - this.f38915f;
        }

        public final void E1(ByteBuffer byteBuffer) throws OutOfSpaceException {
            int iRemaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.f38914e, this.f38917h, iRemaining);
                this.f38917h += iRemaining;
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f38917h), Integer.valueOf(this.f38916g), Integer.valueOf(iRemaining)), e3);
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public final void M(int i3, ByteString byteString) throws OutOfSpaceException {
            A1(i3, 2);
            e1(byteString);
        }

        @Override // androidx.glance.appwidget.protobuf.ByteOutput
        public final void Q(byte[] bArr, int i3, int i4) throws OutOfSpaceException {
            try {
                System.arraycopy(bArr, i3, this.f38914e, this.f38917h, i4);
                this.f38917h += i4;
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f38917h), Integer.valueOf(this.f38916g), Integer.valueOf(i4)), e3);
            }
        }

        @Override // androidx.glance.appwidget.protobuf.ByteOutput
        public final void R(ByteBuffer byteBuffer) throws OutOfSpaceException {
            E1(byteBuffer);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream, androidx.glance.appwidget.protobuf.ByteOutput
        public final void S(byte[] bArr, int i3, int i4) throws OutOfSpaceException {
            Q(bArr, i3, i4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public final int Z0() {
            return this.f38916g - this.f38917h;
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public final void a1(byte b3) throws OutOfSpaceException {
            try {
                byte[] bArr = this.f38914e;
                int i3 = this.f38917h;
                this.f38917h = i3 + 1;
                bArr[i3] = b3;
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f38917h), Integer.valueOf(this.f38916g), 1), e3);
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public final void c(int i3, int i4) throws OutOfSpaceException {
            A1(i3, 5);
            h1(i4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public final void d1(byte[] bArr, int i3, int i4) throws OutOfSpaceException {
            B1(i4);
            Q(bArr, i3, i4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public final void e(int i3, String str) throws OutOfSpaceException {
            A1(i3, 2);
            z1(str);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public final void e1(ByteString byteString) throws OutOfSpaceException {
            B1(byteString.size());
            byteString.S(this);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public final void f(int i3, long j3) throws OutOfSpaceException {
            A1(i3, 0);
            C1(j3);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public final void h(int i3, int i4) throws OutOfSpaceException {
            A1(i3, 0);
            o1(i4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public final void h1(int i3) throws OutOfSpaceException {
            try {
                byte[] bArr = this.f38914e;
                int i4 = this.f38917h;
                int i5 = i4 + 1;
                this.f38917h = i5;
                bArr[i4] = (byte) (i3 & 255);
                int i6 = i4 + 2;
                this.f38917h = i6;
                bArr[i5] = (byte) ((i3 >> 8) & 255);
                int i7 = i4 + 3;
                this.f38917h = i7;
                bArr[i6] = (byte) ((i3 >> 16) & 255);
                this.f38917h = i4 + 4;
                bArr[i7] = (byte) ((i3 >> 24) & 255);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f38917h), Integer.valueOf(this.f38916g), 1), e3);
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public final void i1(long j3) throws OutOfSpaceException {
            try {
                byte[] bArr = this.f38914e;
                int i3 = this.f38917h;
                int i4 = i3 + 1;
                this.f38917h = i4;
                bArr[i3] = (byte) (((int) j3) & 255);
                int i5 = i3 + 2;
                this.f38917h = i5;
                bArr[i4] = (byte) (((int) (j3 >> 8)) & 255);
                int i6 = i3 + 3;
                this.f38917h = i6;
                bArr[i5] = (byte) (((int) (j3 >> 16)) & 255);
                int i7 = i3 + 4;
                this.f38917h = i7;
                bArr[i6] = (byte) (((int) (j3 >> 24)) & 255);
                int i8 = i3 + 5;
                this.f38917h = i8;
                bArr[i7] = (byte) (((int) (j3 >> 32)) & 255);
                int i9 = i3 + 6;
                this.f38917h = i9;
                bArr[i8] = (byte) (((int) (j3 >> 40)) & 255);
                int i10 = i3 + 7;
                this.f38917h = i10;
                bArr[i9] = (byte) (((int) (j3 >> 48)) & 255);
                this.f38917h = i3 + 8;
                bArr[i10] = (byte) (((int) (j3 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f38917h), Integer.valueOf(this.f38916g), 1), e3);
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public final void o(int i3, int i4) throws OutOfSpaceException {
            A1(i3, 0);
            B1(i4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public final void o1(int i3) throws OutOfSpaceException {
            if (i3 >= 0) {
                B1(i3);
            } else {
                C1(i3);
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public final void q1(int i3, MessageLite messageLite) throws OutOfSpaceException {
            A1(i3, 2);
            s1(messageLite);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        final void r1(int i3, MessageLite messageLite, Schema schema) throws OutOfSpaceException {
            A1(i3, 2);
            B1(((AbstractMessageLite) messageLite).k(schema));
            schema.g(messageLite, this.f38908a);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public final void s(int i3, long j3) throws OutOfSpaceException {
            A1(i3, 1);
            i1(j3);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public final void s1(MessageLite messageLite) throws OutOfSpaceException {
            B1(messageLite.c());
            messageLite.i(this);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public final void t1(int i3, MessageLite messageLite) throws OutOfSpaceException {
            A1(1, 3);
            o(2, i3);
            q1(3, messageLite);
            A1(1, 4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public final void u1(int i3, ByteString byteString) throws OutOfSpaceException {
            A1(1, 3);
            o(2, i3);
            M(3, byteString);
            A1(1, 4);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public final void w(int i3, boolean z2) throws OutOfSpaceException {
            A1(i3, 0);
            a1(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public final void z1(String str) throws OutOfSpaceException {
            int i3 = this.f38917h;
            try {
                int iO0 = CodedOutputStream.O0(str.length() * 3);
                int iO02 = CodedOutputStream.O0(str.length());
                if (iO02 != iO0) {
                    B1(Utf8.k(str));
                    this.f38917h = Utf8.i(str, this.f38914e, this.f38917h, Z0());
                    return;
                }
                int i4 = i3 + iO02;
                this.f38917h = i4;
                int i5 = Utf8.i(str, this.f38914e, i4, Z0());
                this.f38917h = i3;
                B1((i5 - i3) - iO02);
                this.f38917h = i5;
            } catch (Utf8.UnpairedSurrogateException e3) {
                this.f38917h = i3;
                U0(str, e3);
            } catch (IndexOutOfBoundsException e4) {
                throw new OutOfSpaceException(e4);
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedOutputStream
        public void T0() {
        }
    }
}
