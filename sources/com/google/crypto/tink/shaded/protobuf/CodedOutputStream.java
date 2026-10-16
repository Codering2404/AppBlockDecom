package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.Utf8;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class CodedOutputStream extends ByteOutput {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Logger f86771c = Logger.getLogger(CodedOutputStream.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean f86772d = UnsafeUtil.J();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    CodedOutputStreamWriter f86773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f86774b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class AbstractBufferedEncoder extends CodedOutputStream {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final byte[] f86775e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f86776f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f86777g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f86778h;

        final void A1(byte b3) {
            byte[] bArr = this.f86775e;
            int i3 = this.f86777g;
            this.f86777g = i3 + 1;
            bArr[i3] = b3;
            this.f86778h++;
        }

        final void B1(int i3) {
            byte[] bArr = this.f86775e;
            int i4 = this.f86777g;
            int i5 = i4 + 1;
            this.f86777g = i5;
            bArr[i4] = (byte) (i3 & 255);
            int i6 = i4 + 2;
            this.f86777g = i6;
            bArr[i5] = (byte) ((i3 >> 8) & 255);
            int i7 = i4 + 3;
            this.f86777g = i7;
            bArr[i6] = (byte) ((i3 >> 16) & 255);
            this.f86777g = i4 + 4;
            bArr[i7] = (byte) ((i3 >> 24) & 255);
            this.f86778h += 4;
        }

        final void C1(long j3) {
            byte[] bArr = this.f86775e;
            int i3 = this.f86777g;
            int i4 = i3 + 1;
            this.f86777g = i4;
            bArr[i3] = (byte) (j3 & 255);
            int i5 = i3 + 2;
            this.f86777g = i5;
            bArr[i4] = (byte) ((j3 >> 8) & 255);
            int i6 = i3 + 3;
            this.f86777g = i6;
            bArr[i5] = (byte) ((j3 >> 16) & 255);
            int i7 = i3 + 4;
            this.f86777g = i7;
            bArr[i6] = (byte) (255 & (j3 >> 24));
            int i8 = i3 + 5;
            this.f86777g = i8;
            bArr[i7] = (byte) (((int) (j3 >> 32)) & 255);
            int i9 = i3 + 6;
            this.f86777g = i9;
            bArr[i8] = (byte) (((int) (j3 >> 40)) & 255);
            int i10 = i3 + 7;
            this.f86777g = i10;
            bArr[i9] = (byte) (((int) (j3 >> 48)) & 255);
            this.f86777g = i3 + 8;
            bArr[i10] = (byte) (((int) (j3 >> 56)) & 255);
            this.f86778h += 8;
        }

        final void D1(int i3) {
            if (i3 >= 0) {
                F1(i3);
            } else {
                G1(i3);
            }
        }

        final void E1(int i3, int i4) {
            F1(WireFormat.c(i3, i4));
        }

        final void F1(int i3) {
            if (!CodedOutputStream.f86772d) {
                while ((i3 & (-128)) != 0) {
                    byte[] bArr = this.f86775e;
                    int i4 = this.f86777g;
                    this.f86777g = i4 + 1;
                    bArr[i4] = (byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    this.f86778h++;
                    i3 >>>= 7;
                }
                byte[] bArr2 = this.f86775e;
                int i5 = this.f86777g;
                this.f86777g = i5 + 1;
                bArr2[i5] = (byte) i3;
                this.f86778h++;
                return;
            }
            long j3 = this.f86777g;
            while ((i3 & (-128)) != 0) {
                byte[] bArr3 = this.f86775e;
                int i6 = this.f86777g;
                this.f86777g = i6 + 1;
                UnsafeUtil.R(bArr3, i6, (byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                i3 >>>= 7;
            }
            byte[] bArr4 = this.f86775e;
            int i7 = this.f86777g;
            this.f86777g = i7 + 1;
            UnsafeUtil.R(bArr4, i7, (byte) i3);
            this.f86778h += (int) (((long) this.f86777g) - j3);
        }

        final void G1(long j3) {
            if (!CodedOutputStream.f86772d) {
                while ((j3 & (-128)) != 0) {
                    byte[] bArr = this.f86775e;
                    int i3 = this.f86777g;
                    this.f86777g = i3 + 1;
                    bArr[i3] = (byte) ((((int) j3) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    this.f86778h++;
                    j3 >>>= 7;
                }
                byte[] bArr2 = this.f86775e;
                int i4 = this.f86777g;
                this.f86777g = i4 + 1;
                bArr2[i4] = (byte) j3;
                this.f86778h++;
                return;
            }
            long j4 = this.f86777g;
            while ((j3 & (-128)) != 0) {
                byte[] bArr3 = this.f86775e;
                int i5 = this.f86777g;
                this.f86777g = i5 + 1;
                UnsafeUtil.R(bArr3, i5, (byte) ((((int) j3) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                j3 >>>= 7;
            }
            byte[] bArr4 = this.f86775e;
            int i6 = this.f86777g;
            this.f86777g = i6 + 1;
            UnsafeUtil.R(bArr4, i6, (byte) j3);
            this.f86778h += (int) (((long) this.f86777g) - j4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final int W0() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ArrayEncoder extends CodedOutputStream {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final byte[] f86779e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f86780f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f86781g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f86782h;

        ArrayEncoder(byte[] bArr, int i3, int i4) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i5 = i3 + i4;
            if ((i3 | i4 | (bArr.length - i5)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i3), Integer.valueOf(i4)));
            }
            this.f86779e = bArr;
            this.f86780f = i3;
            this.f86782h = i3;
            this.f86781g = i5;
        }

        public final void A1(ByteBuffer byteBuffer) throws OutOfSpaceException {
            int iRemaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.f86779e, this.f86782h, iRemaining);
                this.f86782h += iRemaining;
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f86782h), Integer.valueOf(this.f86781g), Integer.valueOf(iRemaining)), e3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void N(int i3, ByteString byteString) throws OutOfSpaceException {
            x1(i3, 2);
            b1(byteString);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public final void Q(byte[] bArr, int i3, int i4) throws OutOfSpaceException {
            try {
                System.arraycopy(bArr, i3, this.f86779e, this.f86782h, i4);
                this.f86782h += i4;
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f86782h), Integer.valueOf(this.f86781g), Integer.valueOf(i4)), e3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public final void R(ByteBuffer byteBuffer) throws OutOfSpaceException {
            A1(byteBuffer);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public final void S(byte[] bArr, int i3, int i4) throws OutOfSpaceException {
            Q(bArr, i3, i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final int W0() {
            return this.f86781g - this.f86782h;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void X0(byte b3) throws OutOfSpaceException {
            try {
                byte[] bArr = this.f86779e;
                int i3 = this.f86782h;
                this.f86782h = i3 + 1;
                bArr[i3] = b3;
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f86782h), Integer.valueOf(this.f86781g), 1), e3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void a1(byte[] bArr, int i3, int i4) throws OutOfSpaceException {
            y1(i4);
            Q(bArr, i3, i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void b1(ByteString byteString) throws OutOfSpaceException {
            y1(byteString.size());
            byteString.S(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void c(int i3, int i4) throws OutOfSpaceException {
            x1(i3, 5);
            e1(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void e(int i3, String str) throws OutOfSpaceException {
            x1(i3, 2);
            w1(str);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void e1(int i3) throws OutOfSpaceException {
            try {
                byte[] bArr = this.f86779e;
                int i4 = this.f86782h;
                int i5 = i4 + 1;
                this.f86782h = i5;
                bArr[i4] = (byte) (i3 & 255);
                int i6 = i4 + 2;
                this.f86782h = i6;
                bArr[i5] = (byte) ((i3 >> 8) & 255);
                int i7 = i4 + 3;
                this.f86782h = i7;
                bArr[i6] = (byte) ((i3 >> 16) & 255);
                this.f86782h = i4 + 4;
                bArr[i7] = (byte) ((i3 >> 24) & 255);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f86782h), Integer.valueOf(this.f86781g), 1), e3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void f(int i3, long j3) throws OutOfSpaceException {
            x1(i3, 0);
            z1(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void f1(long j3) throws OutOfSpaceException {
            try {
                byte[] bArr = this.f86779e;
                int i3 = this.f86782h;
                int i4 = i3 + 1;
                this.f86782h = i4;
                bArr[i3] = (byte) (((int) j3) & 255);
                int i5 = i3 + 2;
                this.f86782h = i5;
                bArr[i4] = (byte) (((int) (j3 >> 8)) & 255);
                int i6 = i3 + 3;
                this.f86782h = i6;
                bArr[i5] = (byte) (((int) (j3 >> 16)) & 255);
                int i7 = i3 + 4;
                this.f86782h = i7;
                bArr[i6] = (byte) (((int) (j3 >> 24)) & 255);
                int i8 = i3 + 5;
                this.f86782h = i8;
                bArr[i7] = (byte) (((int) (j3 >> 32)) & 255);
                int i9 = i3 + 6;
                this.f86782h = i9;
                bArr[i8] = (byte) (((int) (j3 >> 40)) & 255);
                int i10 = i3 + 7;
                this.f86782h = i10;
                bArr[i9] = (byte) (((int) (j3 >> 48)) & 255);
                this.f86782h = i3 + 8;
                bArr[i10] = (byte) (((int) (j3 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f86782h), Integer.valueOf(this.f86781g), 1), e3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void h(int i3, int i4) throws OutOfSpaceException {
            x1(i3, 0);
            l1(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void l1(int i3) throws OutOfSpaceException {
            if (i3 >= 0) {
                y1(i3);
            } else {
                z1(i3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void n1(int i3, MessageLite messageLite) throws OutOfSpaceException {
            x1(i3, 2);
            p1(messageLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void o(int i3, int i4) throws OutOfSpaceException {
            x1(i3, 0);
            y1(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        final void o1(int i3, MessageLite messageLite, Schema schema) throws OutOfSpaceException {
            x1(i3, 2);
            y1(((AbstractMessageLite) messageLite).k(schema));
            schema.i(messageLite, this.f86773a);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void p1(MessageLite messageLite) throws OutOfSpaceException {
            y1(messageLite.c());
            messageLite.j(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void q1(int i3, MessageLite messageLite) throws OutOfSpaceException {
            x1(1, 3);
            o(2, i3);
            n1(3, messageLite);
            x1(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void r1(int i3, ByteString byteString) throws OutOfSpaceException {
            x1(1, 3);
            o(2, i3);
            N(3, byteString);
            x1(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void s(int i3, long j3) throws OutOfSpaceException {
            x1(i3, 1);
            f1(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void w(int i3, boolean z2) throws OutOfSpaceException {
            x1(i3, 0);
            X0(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void w1(String str) throws OutOfSpaceException {
            int i3 = this.f86782h;
            try {
                int iN0 = CodedOutputStream.N0(str.length() * 3);
                int iN02 = CodedOutputStream.N0(str.length());
                if (iN02 != iN0) {
                    y1(Utf8.k(str));
                    this.f86782h = Utf8.i(str, this.f86779e, this.f86782h, W0());
                    return;
                }
                int i4 = i3 + iN02;
                this.f86782h = i4;
                int i5 = Utf8.i(str, this.f86779e, i4, W0());
                this.f86782h = i3;
                y1((i5 - i3) - iN02);
                this.f86782h = i5;
            } catch (Utf8.UnpairedSurrogateException e3) {
                this.f86782h = i3;
                S0(str, e3);
            } catch (IndexOutOfBoundsException e4) {
                throw new OutOfSpaceException(e4);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void x1(int i3, int i4) throws OutOfSpaceException {
            y1(WireFormat.c(i3, i4));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void y1(int i3) throws OutOfSpaceException {
            while ((i3 & (-128)) != 0) {
                try {
                    byte[] bArr = this.f86779e;
                    int i4 = this.f86782h;
                    this.f86782h = i4 + 1;
                    bArr[i4] = (byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    i3 >>>= 7;
                } catch (IndexOutOfBoundsException e3) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f86782h), Integer.valueOf(this.f86781g), 1), e3);
                }
            }
            byte[] bArr2 = this.f86779e;
            int i5 = this.f86782h;
            this.f86782h = i5 + 1;
            bArr2[i5] = (byte) i3;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public final void z1(long j3) throws OutOfSpaceException {
            if (CodedOutputStream.f86772d && W0() >= 10) {
                while ((j3 & (-128)) != 0) {
                    byte[] bArr = this.f86779e;
                    int i3 = this.f86782h;
                    this.f86782h = i3 + 1;
                    UnsafeUtil.R(bArr, i3, (byte) ((((int) j3) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                    j3 >>>= 7;
                }
                byte[] bArr2 = this.f86779e;
                int i4 = this.f86782h;
                this.f86782h = i4 + 1;
                UnsafeUtil.R(bArr2, i4, (byte) j3);
                return;
            }
            while ((j3 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f86779e;
                    int i5 = this.f86782h;
                    this.f86782h = i5 + 1;
                    bArr3[i5] = (byte) ((((int) j3) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    j3 >>>= 7;
                } catch (IndexOutOfBoundsException e3) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f86782h), Integer.valueOf(this.f86781g), 1), e3);
                }
            }
            byte[] bArr4 = this.f86779e;
            int i6 = this.f86782h;
            this.f86782h = i6 + 1;
            bArr4[i6] = (byte) j3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ByteOutputEncoder extends AbstractBufferedEncoder {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final ByteOutput f86783i;

        private void H1() {
            this.f86783i.Q(this.f86775e, 0, this.f86777g);
            this.f86777g = 0;
        }

        private void J1(int i3) {
            if (this.f86776f - this.f86777g < i3) {
                H1();
            }
        }

        public void I1() {
            if (this.f86777g > 0) {
                H1();
            }
        }

        void K1(MessageLite messageLite, Schema schema) {
            y1(((AbstractMessageLite) messageLite).k(schema));
            schema.i(messageLite, this.f86773a);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void N(int i3, ByteString byteString) {
            x1(i3, 2);
            b1(byteString);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void Q(byte[] bArr, int i3, int i4) {
            I1();
            this.f86783i.Q(bArr, i3, i4);
            this.f86778h += i4;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void R(ByteBuffer byteBuffer) {
            I1();
            int iRemaining = byteBuffer.remaining();
            this.f86783i.R(byteBuffer);
            this.f86778h += iRemaining;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void S(byte[] bArr, int i3, int i4) {
            I1();
            this.f86783i.S(bArr, i3, i4);
            this.f86778h += i4;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void X0(byte b3) {
            if (this.f86777g == this.f86776f) {
                H1();
            }
            A1(b3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void a1(byte[] bArr, int i3, int i4) {
            y1(i4);
            Q(bArr, i3, i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void b1(ByteString byteString) {
            y1(byteString.size());
            byteString.S(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void c(int i3, int i4) {
            J1(14);
            E1(i3, 5);
            B1(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void e(int i3, String str) throws OutOfSpaceException {
            x1(i3, 2);
            w1(str);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void e1(int i3) {
            J1(4);
            B1(i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void f(int i3, long j3) {
            J1(20);
            E1(i3, 0);
            G1(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void f1(long j3) {
            J1(8);
            C1(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void h(int i3, int i4) {
            J1(20);
            E1(i3, 0);
            D1(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void l1(int i3) {
            if (i3 >= 0) {
                y1(i3);
            } else {
                z1(i3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void n1(int i3, MessageLite messageLite) {
            x1(i3, 2);
            p1(messageLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void o(int i3, int i4) {
            J1(20);
            E1(i3, 0);
            F1(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        void o1(int i3, MessageLite messageLite, Schema schema) {
            x1(i3, 2);
            K1(messageLite, schema);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void p1(MessageLite messageLite) {
            y1(messageLite.c());
            messageLite.j(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void q1(int i3, MessageLite messageLite) {
            x1(1, 3);
            o(2, i3);
            n1(3, messageLite);
            x1(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void r1(int i3, ByteString byteString) {
            x1(1, 3);
            o(2, i3);
            N(3, byteString);
            x1(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void s(int i3, long j3) {
            J1(18);
            E1(i3, 1);
            C1(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void w(int i3, boolean z2) {
            J1(11);
            E1(i3, 0);
            A1(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void w1(String str) throws OutOfSpaceException {
            int length = str.length() * 3;
            int iN0 = CodedOutputStream.N0(length);
            int i3 = iN0 + length;
            int i4 = this.f86776f;
            if (i3 > i4) {
                byte[] bArr = new byte[length];
                int i5 = Utf8.i(str, bArr, 0, length);
                y1(i5);
                S(bArr, 0, i5);
                return;
            }
            if (i3 > i4 - this.f86777g) {
                H1();
            }
            int i6 = this.f86777g;
            try {
                int iN02 = CodedOutputStream.N0(str.length());
                if (iN02 != iN0) {
                    int iK = Utf8.k(str);
                    F1(iK);
                    this.f86777g = Utf8.i(str, this.f86775e, this.f86777g, iK);
                    this.f86778h += iK;
                    return;
                }
                int i7 = i6 + iN02;
                this.f86777g = i7;
                int i8 = Utf8.i(str, this.f86775e, i7, this.f86776f - i7);
                this.f86777g = i6;
                int i9 = (i8 - i6) - iN02;
                F1(i9);
                this.f86777g = i8;
                this.f86778h += i9;
            } catch (Utf8.UnpairedSurrogateException e3) {
                this.f86778h -= this.f86777g - i6;
                this.f86777g = i6;
                S0(str, e3);
            } catch (IndexOutOfBoundsException e4) {
                throw new OutOfSpaceException(e4);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void x1(int i3, int i4) {
            y1(WireFormat.c(i3, i4));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void y1(int i3) {
            J1(5);
            F1(i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void z1(long j3) {
            J1(10);
            G1(j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class HeapNioEncoder extends ArrayEncoder {
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
        private final OutputStream f86784i;

        private void H1() throws IOException {
            this.f86784i.write(this.f86775e, 0, this.f86777g);
            this.f86777g = 0;
        }

        private void I1(int i3) throws IOException {
            if (this.f86776f - this.f86777g < i3) {
                H1();
            }
        }

        public void J1(ByteBuffer byteBuffer) throws IOException {
            int iRemaining = byteBuffer.remaining();
            int i3 = this.f86776f;
            int i4 = this.f86777g;
            if (i3 - i4 >= iRemaining) {
                byteBuffer.get(this.f86775e, i4, iRemaining);
                this.f86777g += iRemaining;
                this.f86778h += iRemaining;
                return;
            }
            int i5 = i3 - i4;
            byteBuffer.get(this.f86775e, i4, i5);
            int i6 = iRemaining - i5;
            this.f86777g = this.f86776f;
            this.f86778h += i5;
            H1();
            while (true) {
                int i7 = this.f86776f;
                if (i6 <= i7) {
                    byteBuffer.get(this.f86775e, 0, i6);
                    this.f86777g = i6;
                    this.f86778h += i6;
                    return;
                } else {
                    byteBuffer.get(this.f86775e, 0, i7);
                    this.f86784i.write(this.f86775e, 0, this.f86776f);
                    int i8 = this.f86776f;
                    i6 -= i8;
                    this.f86778h += i8;
                }
            }
        }

        void K1(MessageLite messageLite, Schema schema) throws IOException {
            y1(((AbstractMessageLite) messageLite).k(schema));
            schema.i(messageLite, this.f86773a);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void N(int i3, ByteString byteString) throws IOException {
            x1(i3, 2);
            b1(byteString);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void Q(byte[] bArr, int i3, int i4) throws IOException {
            int i5 = this.f86776f;
            int i6 = this.f86777g;
            if (i5 - i6 >= i4) {
                System.arraycopy(bArr, i3, this.f86775e, i6, i4);
                this.f86777g += i4;
                this.f86778h += i4;
                return;
            }
            int i7 = i5 - i6;
            System.arraycopy(bArr, i3, this.f86775e, i6, i7);
            int i8 = i3 + i7;
            int i9 = i4 - i7;
            this.f86777g = this.f86776f;
            this.f86778h += i7;
            H1();
            if (i9 <= this.f86776f) {
                System.arraycopy(bArr, i8, this.f86775e, 0, i9);
                this.f86777g = i9;
            } else {
                this.f86784i.write(bArr, i8, i9);
            }
            this.f86778h += i9;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void R(ByteBuffer byteBuffer) throws IOException {
            J1(byteBuffer);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void S(byte[] bArr, int i3, int i4) throws IOException {
            Q(bArr, i3, i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void X0(byte b3) throws IOException {
            if (this.f86777g == this.f86776f) {
                H1();
            }
            A1(b3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void a1(byte[] bArr, int i3, int i4) throws IOException {
            y1(i4);
            Q(bArr, i3, i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void b1(ByteString byteString) throws IOException {
            y1(byteString.size());
            byteString.S(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void c(int i3, int i4) throws IOException {
            I1(14);
            E1(i3, 5);
            B1(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void e(int i3, String str) throws IOException {
            x1(i3, 2);
            w1(str);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void e1(int i3) throws IOException {
            I1(4);
            B1(i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void f(int i3, long j3) throws IOException {
            I1(20);
            E1(i3, 0);
            G1(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void f1(long j3) throws IOException {
            I1(8);
            C1(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void h(int i3, int i4) throws IOException {
            I1(20);
            E1(i3, 0);
            D1(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void l1(int i3) throws IOException {
            if (i3 >= 0) {
                y1(i3);
            } else {
                z1(i3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void n1(int i3, MessageLite messageLite) throws IOException {
            x1(i3, 2);
            p1(messageLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void o(int i3, int i4) throws IOException {
            I1(20);
            E1(i3, 0);
            F1(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        void o1(int i3, MessageLite messageLite, Schema schema) throws IOException {
            x1(i3, 2);
            K1(messageLite, schema);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void p1(MessageLite messageLite) throws IOException {
            y1(messageLite.c());
            messageLite.j(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void q1(int i3, MessageLite messageLite) throws IOException {
            x1(1, 3);
            o(2, i3);
            n1(3, messageLite);
            x1(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void r1(int i3, ByteString byteString) throws IOException {
            x1(1, 3);
            o(2, i3);
            N(3, byteString);
            x1(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void s(int i3, long j3) throws IOException {
            I1(18);
            E1(i3, 1);
            C1(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void w(int i3, boolean z2) throws IOException {
            I1(11);
            E1(i3, 0);
            A1(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void w1(String str) throws IOException {
            int iK;
            try {
                int length = str.length() * 3;
                int iN0 = CodedOutputStream.N0(length);
                int i3 = iN0 + length;
                int i4 = this.f86776f;
                if (i3 > i4) {
                    byte[] bArr = new byte[length];
                    int i5 = Utf8.i(str, bArr, 0, length);
                    y1(i5);
                    S(bArr, 0, i5);
                    return;
                }
                if (i3 > i4 - this.f86777g) {
                    H1();
                }
                int iN02 = CodedOutputStream.N0(str.length());
                int i6 = this.f86777g;
                try {
                    if (iN02 == iN0) {
                        int i7 = i6 + iN02;
                        this.f86777g = i7;
                        int i8 = Utf8.i(str, this.f86775e, i7, this.f86776f - i7);
                        this.f86777g = i6;
                        iK = (i8 - i6) - iN02;
                        F1(iK);
                        this.f86777g = i8;
                    } else {
                        iK = Utf8.k(str);
                        F1(iK);
                        this.f86777g = Utf8.i(str, this.f86775e, this.f86777g, iK);
                    }
                    this.f86778h += iK;
                } catch (Utf8.UnpairedSurrogateException e3) {
                    this.f86778h -= this.f86777g - i6;
                    this.f86777g = i6;
                    throw e3;
                } catch (ArrayIndexOutOfBoundsException e4) {
                    throw new OutOfSpaceException(e4);
                }
            } catch (Utf8.UnpairedSurrogateException e5) {
                S0(str, e5);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void x1(int i3, int i4) throws IOException {
            y1(WireFormat.c(i3, i4));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void y1(int i3) throws IOException {
            I1(5);
            F1(i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void z1(long j3) throws IOException {
            I1(10);
            G1(j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SafeDirectNioEncoder extends CodedOutputStream {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ByteBuffer f86785e;

        private void A1(String str) throws OutOfSpaceException {
            try {
                Utf8.j(str, this.f86785e);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        public void B1(ByteBuffer byteBuffer) throws OutOfSpaceException {
            try {
                this.f86785e.put(byteBuffer);
            } catch (BufferOverflowException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        void C1(MessageLite messageLite, Schema schema) throws OutOfSpaceException {
            y1(((AbstractMessageLite) messageLite).k(schema));
            schema.i(messageLite, this.f86773a);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void N(int i3, ByteString byteString) throws OutOfSpaceException {
            x1(i3, 2);
            b1(byteString);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void Q(byte[] bArr, int i3, int i4) throws OutOfSpaceException {
            try {
                this.f86785e.put(bArr, i3, i4);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(e3);
            } catch (BufferOverflowException e4) {
                throw new OutOfSpaceException(e4);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void R(ByteBuffer byteBuffer) throws OutOfSpaceException {
            B1(byteBuffer);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void S(byte[] bArr, int i3, int i4) throws OutOfSpaceException {
            Q(bArr, i3, i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public int W0() {
            return this.f86785e.remaining();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void X0(byte b3) throws OutOfSpaceException {
            try {
                this.f86785e.put(b3);
            } catch (BufferOverflowException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void a1(byte[] bArr, int i3, int i4) throws OutOfSpaceException {
            y1(i4);
            Q(bArr, i3, i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void b1(ByteString byteString) throws OutOfSpaceException {
            y1(byteString.size());
            byteString.S(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void c(int i3, int i4) throws OutOfSpaceException {
            x1(i3, 5);
            e1(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void e(int i3, String str) throws OutOfSpaceException {
            x1(i3, 2);
            w1(str);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void e1(int i3) throws OutOfSpaceException {
            try {
                this.f86785e.putInt(i3);
            } catch (BufferOverflowException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void f(int i3, long j3) throws OutOfSpaceException {
            x1(i3, 0);
            z1(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void f1(long j3) throws OutOfSpaceException {
            try {
                this.f86785e.putLong(j3);
            } catch (BufferOverflowException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void h(int i3, int i4) throws OutOfSpaceException {
            x1(i3, 0);
            l1(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void l1(int i3) throws OutOfSpaceException {
            if (i3 >= 0) {
                y1(i3);
            } else {
                z1(i3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void n1(int i3, MessageLite messageLite) throws OutOfSpaceException {
            x1(i3, 2);
            p1(messageLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void o(int i3, int i4) throws OutOfSpaceException {
            x1(i3, 0);
            y1(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        void o1(int i3, MessageLite messageLite, Schema schema) throws OutOfSpaceException {
            x1(i3, 2);
            C1(messageLite, schema);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void p1(MessageLite messageLite) throws OutOfSpaceException {
            y1(messageLite.c());
            messageLite.j(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void q1(int i3, MessageLite messageLite) throws OutOfSpaceException {
            x1(1, 3);
            o(2, i3);
            n1(3, messageLite);
            x1(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void r1(int i3, ByteString byteString) throws OutOfSpaceException {
            x1(1, 3);
            o(2, i3);
            N(3, byteString);
            x1(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void s(int i3, long j3) throws OutOfSpaceException {
            x1(i3, 1);
            f1(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void w(int i3, boolean z2) throws OutOfSpaceException {
            x1(i3, 0);
            X0(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void w1(String str) throws OutOfSpaceException {
            int iPosition = this.f86785e.position();
            try {
                int iN0 = CodedOutputStream.N0(str.length() * 3);
                int iN02 = CodedOutputStream.N0(str.length());
                if (iN02 != iN0) {
                    y1(Utf8.k(str));
                    A1(str);
                    return;
                }
                int iPosition2 = this.f86785e.position() + iN02;
                this.f86785e.position(iPosition2);
                A1(str);
                int iPosition3 = this.f86785e.position();
                this.f86785e.position(iPosition);
                y1(iPosition3 - iPosition2);
                this.f86785e.position(iPosition3);
            } catch (Utf8.UnpairedSurrogateException e3) {
                this.f86785e.position(iPosition);
                S0(str, e3);
            } catch (IllegalArgumentException e4) {
                throw new OutOfSpaceException(e4);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void x1(int i3, int i4) throws OutOfSpaceException {
            y1(WireFormat.c(i3, i4));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void y1(int i3) throws OutOfSpaceException {
            while ((i3 & (-128)) != 0) {
                try {
                    this.f86785e.put((byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                    i3 >>>= 7;
                } catch (BufferOverflowException e3) {
                    throw new OutOfSpaceException(e3);
                }
            }
            this.f86785e.put((byte) i3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void z1(long j3) throws OutOfSpaceException {
            while (((-128) & j3) != 0) {
                try {
                    this.f86785e.put((byte) ((((int) j3) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                    j3 >>>= 7;
                } catch (BufferOverflowException e3) {
                    throw new OutOfSpaceException(e3);
                }
            }
            this.f86785e.put((byte) j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class UnsafeDirectNioEncoder extends CodedOutputStream {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ByteBuffer f86786e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final long f86787f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final long f86788g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final long f86789h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f86790i;

        private int A1(long j3) {
            return (int) (j3 - this.f86787f);
        }

        private void B1(long j3) {
            this.f86786e.position(A1(j3));
        }

        public void C1(ByteBuffer byteBuffer) throws OutOfSpaceException {
            try {
                int iRemaining = byteBuffer.remaining();
                B1(this.f86790i);
                this.f86786e.put(byteBuffer);
                this.f86790i += (long) iRemaining;
            } catch (BufferOverflowException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        void D1(MessageLite messageLite, Schema schema) throws OutOfSpaceException {
            y1(((AbstractMessageLite) messageLite).k(schema));
            schema.i(messageLite, this.f86773a);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void N(int i3, ByteString byteString) throws OutOfSpaceException {
            x1(i3, 2);
            b1(byteString);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void Q(byte[] bArr, int i3, int i4) throws OutOfSpaceException {
            if (bArr != null && i3 >= 0 && i4 >= 0 && bArr.length - i4 >= i3) {
                long j3 = i4;
                long j4 = this.f86788g - j3;
                long j5 = this.f86790i;
                if (j4 >= j5) {
                    UnsafeUtil.q(bArr, i3, j5, j3);
                    this.f86790i += j3;
                    return;
                }
            }
            if (bArr != null) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f86790i), Long.valueOf(this.f86788g), Integer.valueOf(i4)));
            }
            throw new NullPointerException("value");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void R(ByteBuffer byteBuffer) throws OutOfSpaceException {
            C1(byteBuffer);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream, com.google.crypto.tink.shaded.protobuf.ByteOutput
        public void S(byte[] bArr, int i3, int i4) throws OutOfSpaceException {
            Q(bArr, i3, i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public int W0() {
            return (int) (this.f86788g - this.f86790i);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void X0(byte b3) throws OutOfSpaceException {
            long j3 = this.f86790i;
            if (j3 >= this.f86788g) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f86790i), Long.valueOf(this.f86788g), 1));
            }
            this.f86790i = 1 + j3;
            UnsafeUtil.Q(j3, b3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void a1(byte[] bArr, int i3, int i4) throws OutOfSpaceException {
            y1(i4);
            Q(bArr, i3, i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void b1(ByteString byteString) throws OutOfSpaceException {
            y1(byteString.size());
            byteString.S(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void c(int i3, int i4) throws OutOfSpaceException {
            x1(i3, 5);
            e1(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void e(int i3, String str) throws OutOfSpaceException {
            x1(i3, 2);
            w1(str);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void e1(int i3) {
            this.f86786e.putInt(A1(this.f86790i), i3);
            this.f86790i += 4;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void f(int i3, long j3) throws OutOfSpaceException {
            x1(i3, 0);
            z1(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void f1(long j3) {
            this.f86786e.putLong(A1(this.f86790i), j3);
            this.f86790i += 8;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void h(int i3, int i4) throws OutOfSpaceException {
            x1(i3, 0);
            l1(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void l1(int i3) throws OutOfSpaceException {
            if (i3 >= 0) {
                y1(i3);
            } else {
                z1(i3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void n1(int i3, MessageLite messageLite) throws OutOfSpaceException {
            x1(i3, 2);
            p1(messageLite);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void o(int i3, int i4) throws OutOfSpaceException {
            x1(i3, 0);
            y1(i4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        void o1(int i3, MessageLite messageLite, Schema schema) throws OutOfSpaceException {
            x1(i3, 2);
            D1(messageLite, schema);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void p1(MessageLite messageLite) throws OutOfSpaceException {
            y1(messageLite.c());
            messageLite.j(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void q1(int i3, MessageLite messageLite) throws OutOfSpaceException {
            x1(1, 3);
            o(2, i3);
            n1(3, messageLite);
            x1(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void r1(int i3, ByteString byteString) throws OutOfSpaceException {
            x1(1, 3);
            o(2, i3);
            N(3, byteString);
            x1(1, 4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void s(int i3, long j3) throws OutOfSpaceException {
            x1(i3, 1);
            f1(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void w(int i3, boolean z2) throws OutOfSpaceException {
            x1(i3, 0);
            X0(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void w1(String str) throws OutOfSpaceException {
            long j3 = this.f86790i;
            try {
                int iN0 = CodedOutputStream.N0(str.length() * 3);
                int iN02 = CodedOutputStream.N0(str.length());
                if (iN02 != iN0) {
                    int iK = Utf8.k(str);
                    y1(iK);
                    B1(this.f86790i);
                    Utf8.j(str, this.f86786e);
                    this.f86790i += (long) iK;
                    return;
                }
                int iA1 = A1(this.f86790i) + iN02;
                this.f86786e.position(iA1);
                Utf8.j(str, this.f86786e);
                int iPosition = this.f86786e.position() - iA1;
                y1(iPosition);
                this.f86790i += (long) iPosition;
            } catch (Utf8.UnpairedSurrogateException e3) {
                this.f86790i = j3;
                B1(j3);
                S0(str, e3);
            } catch (IllegalArgumentException e4) {
                throw new OutOfSpaceException(e4);
            } catch (IndexOutOfBoundsException e5) {
                throw new OutOfSpaceException(e5);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void x1(int i3, int i4) throws OutOfSpaceException {
            y1(WireFormat.c(i3, i4));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void y1(int i3) throws OutOfSpaceException {
            if (this.f86790i <= this.f86789h) {
                while ((i3 & (-128)) != 0) {
                    long j3 = this.f86790i;
                    this.f86790i = j3 + 1;
                    UnsafeUtil.Q(j3, (byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                    i3 >>>= 7;
                }
                long j4 = this.f86790i;
                this.f86790i = 1 + j4;
                UnsafeUtil.Q(j4, (byte) i3);
                return;
            }
            while (true) {
                long j5 = this.f86790i;
                if (j5 >= this.f86788g) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f86790i), Long.valueOf(this.f86788g), 1));
                }
                if ((i3 & (-128)) == 0) {
                    this.f86790i = 1 + j5;
                    UnsafeUtil.Q(j5, (byte) i3);
                    return;
                } else {
                    this.f86790i = j5 + 1;
                    UnsafeUtil.Q(j5, (byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                    i3 >>>= 7;
                }
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream
        public void z1(long j3) throws OutOfSpaceException {
            if (this.f86790i <= this.f86789h) {
                while ((j3 & (-128)) != 0) {
                    long j4 = this.f86790i;
                    this.f86790i = j4 + 1;
                    UnsafeUtil.Q(j4, (byte) ((((int) j3) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                    j3 >>>= 7;
                }
                long j5 = this.f86790i;
                this.f86790i = 1 + j5;
                UnsafeUtil.Q(j5, (byte) j3);
                return;
            }
            while (true) {
                long j6 = this.f86790i;
                if (j6 >= this.f86788g) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f86790i), Long.valueOf(this.f86788g), 1));
                }
                if ((j3 & (-128)) == 0) {
                    this.f86790i = 1 + j6;
                    UnsafeUtil.Q(j6, (byte) j3);
                    return;
                } else {
                    this.f86790i = j6 + 1;
                    UnsafeUtil.Q(j6, (byte) ((((int) j3) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                    j3 >>>= 7;
                }
            }
        }
    }

    public static int A0(int i3, ByteString byteString) {
        return (L0(1) * 2) + M0(2, i3) + Y(3, byteString);
    }

    public static int B0(int i3, int i4) {
        return L0(i3) + C0(i4);
    }

    public static int C0(int i3) {
        return 4;
    }

    public static int D0(int i3, long j3) {
        return L0(i3) + E0(j3);
    }

    public static int E0(long j3) {
        return 8;
    }

    public static int F0(int i3, int i4) {
        return L0(i3) + G0(i4);
    }

    public static int G0(int i3) {
        return N0(Q0(i3));
    }

    public static int H0(int i3, long j3) {
        return L0(i3) + I0(j3);
    }

    public static int I0(long j3) {
        return P0(R0(j3));
    }

    public static int J0(int i3, String str) {
        return L0(i3) + K0(str);
    }

    public static int K0(String str) {
        int length;
        try {
            length = Utf8.k(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            length = str.getBytes(Internal.f86941b).length;
        }
        return u0(length);
    }

    public static int L0(int i3) {
        return N0(WireFormat.c(i3, 0));
    }

    public static int M0(int i3, int i4) {
        return L0(i3) + N0(i4);
    }

    public static int N0(int i3) {
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

    public static int O0(int i3, long j3) {
        return L0(i3) + P0(j3);
    }

    public static int P0(long j3) {
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

    public static int Q0(int i3) {
        return (i3 >> 31) ^ (i3 << 1);
    }

    public static long R0(long j3) {
        return (j3 >> 63) ^ (j3 << 1);
    }

    public static CodedOutputStream U0(byte[] bArr) {
        return V0(bArr, 0, bArr.length);
    }

    public static int V(int i3, boolean z2) {
        return L0(i3) + W(z2);
    }

    public static CodedOutputStream V0(byte[] bArr, int i3, int i4) {
        return new ArrayEncoder(bArr, i3, i4);
    }

    public static int W(boolean z2) {
        return 1;
    }

    public static int X(byte[] bArr) {
        return u0(bArr.length);
    }

    public static int Y(int i3, ByteString byteString) {
        return L0(i3) + Z(byteString);
    }

    public static int Z(ByteString byteString) {
        return u0(byteString.size());
    }

    public static int a0(int i3, double d3) {
        return L0(i3) + b0(d3);
    }

    public static int b0(double d3) {
        return 8;
    }

    public static int c0(int i3, int i4) {
        return L0(i3) + d0(i4);
    }

    public static int d0(int i3) {
        return o0(i3);
    }

    public static int e0(int i3, int i4) {
        return L0(i3) + f0(i4);
    }

    public static int f0(int i3) {
        return 4;
    }

    public static int g0(int i3, long j3) {
        return L0(i3) + h0(j3);
    }

    public static int h0(long j3) {
        return 8;
    }

    public static int i0(int i3, float f3) {
        return L0(i3) + j0(f3);
    }

    public static int j0(float f3) {
        return 4;
    }

    static int k0(int i3, MessageLite messageLite, Schema schema) {
        return (L0(i3) * 2) + m0(messageLite, schema);
    }

    public static int l0(MessageLite messageLite) {
        return messageLite.c();
    }

    static int m0(MessageLite messageLite, Schema schema) {
        return ((AbstractMessageLite) messageLite).k(schema);
    }

    public static int n0(int i3, int i4) {
        return L0(i3) + o0(i4);
    }

    public static int o0(int i3) {
        if (i3 >= 0) {
            return N0(i3);
        }
        return 10;
    }

    public static int p0(int i3, long j3) {
        return L0(i3) + q0(j3);
    }

    public static int q0(long j3) {
        return P0(j3);
    }

    public static int r0(int i3, LazyFieldLite lazyFieldLite) {
        return (L0(1) * 2) + M0(2, i3) + s0(3, lazyFieldLite);
    }

    public static int s0(int i3, LazyFieldLite lazyFieldLite) {
        return L0(i3) + t0(lazyFieldLite);
    }

    public static int t0(LazyFieldLite lazyFieldLite) {
        return u0(lazyFieldLite.b());
    }

    static int u0(int i3) {
        return N0(i3) + i3;
    }

    public static int v0(int i3, MessageLite messageLite) {
        return (L0(1) * 2) + M0(2, i3) + w0(3, messageLite);
    }

    public static int w0(int i3, MessageLite messageLite) {
        return L0(i3) + y0(messageLite);
    }

    static int x0(int i3, MessageLite messageLite, Schema schema) {
        return L0(i3) + z0(messageLite, schema);
    }

    public static int y0(MessageLite messageLite) {
        return u0(messageLite.c());
    }

    static int z0(MessageLite messageLite, Schema schema) {
        return u0(((AbstractMessageLite) messageLite).k(schema));
    }

    public final void C(int i3, float f3) {
        c(i3, Float.floatToRawIntBits(f3));
    }

    public final void F(int i3, int i4) {
        h(i3, i4);
    }

    public final void I(int i3, int i4) {
        o(i3, Q0(i4));
    }

    public abstract void N(int i3, ByteString byteString);

    @Override // com.google.crypto.tink.shaded.protobuf.ByteOutput
    public abstract void S(byte[] bArr, int i3, int i4);

    final void S0(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws OutOfSpaceException {
        f86771c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) unpairedSurrogateException);
        byte[] bytes = str.getBytes(Internal.f86941b);
        try {
            y1(bytes.length);
            S(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e3) {
            throw new OutOfSpaceException(e3);
        }
    }

    boolean T0() {
        return this.f86774b;
    }

    public final void U() {
        if (W0() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract int W0();

    public abstract void X0(byte b3);

    public final void Y0(boolean z2) {
        X0(z2 ? (byte) 1 : (byte) 0);
    }

    public final void Z0(byte[] bArr) {
        a1(bArr, 0, bArr.length);
    }

    abstract void a1(byte[] bArr, int i3, int i4);

    public abstract void b1(ByteString byteString);

    public abstract void c(int i3, int i4);

    public final void c1(double d3) {
        f1(Double.doubleToRawLongBits(d3));
    }

    public final void d1(int i3) {
        l1(i3);
    }

    public abstract void e(int i3, String str);

    public abstract void e1(int i3);

    public abstract void f(int i3, long j3);

    public abstract void f1(long j3);

    public final void g1(float f3) {
        e1(Float.floatToRawIntBits(f3));
    }

    public abstract void h(int i3, int i4);

    public final void h1(int i3, MessageLite messageLite) {
        x1(i3, 3);
        j1(messageLite);
        x1(i3, 4);
    }

    public final void i(int i3, long j3) {
        s(i3, j3);
    }

    final void i1(int i3, MessageLite messageLite, Schema schema) {
        x1(i3, 3);
        k1(messageLite, schema);
        x1(i3, 4);
    }

    public final void j1(MessageLite messageLite) {
        messageLite.j(this);
    }

    final void k1(MessageLite messageLite, Schema schema) {
        schema.i(messageLite, this.f86773a);
    }

    public abstract void l1(int i3);

    public final void m(int i3, long j3) {
        f(i3, R0(j3));
    }

    public final void m1(long j3) {
        z1(j3);
    }

    public abstract void n1(int i3, MessageLite messageLite);

    public abstract void o(int i3, int i4);

    abstract void o1(int i3, MessageLite messageLite, Schema schema);

    public final void p(int i3, double d3) {
        s(i3, Double.doubleToRawLongBits(d3));
    }

    public abstract void p1(MessageLite messageLite);

    public abstract void q1(int i3, MessageLite messageLite);

    public abstract void r1(int i3, ByteString byteString);

    public abstract void s(int i3, long j3);

    public final void s1(int i3) {
        e1(i3);
    }

    public final void t1(long j3) {
        f1(j3);
    }

    public final void u1(int i3) {
        y1(Q0(i3));
    }

    public final void v(int i3, long j3) {
        f(i3, j3);
    }

    public final void v1(long j3) {
        z1(R0(j3));
    }

    public abstract void w(int i3, boolean z2);

    public abstract void w1(String str);

    public final void x(int i3, int i4) {
        c(i3, i4);
    }

    public abstract void x1(int i3, int i4);

    public abstract void y1(int i3);

    public abstract void z1(long j3);

    private CodedOutputStream() {
    }
}
