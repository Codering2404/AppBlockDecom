package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.Utf8;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
abstract class BinaryWriter extends ByteOutput implements Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BufferAllocator f35986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f35987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ArrayDeque f35988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f35989d;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.BinaryWriter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f35990a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f35990a = iArr;
            try {
                iArr[WireFormat.FieldType.f36695k.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35990a[WireFormat.FieldType.f36694j.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35990a[WireFormat.FieldType.f36693i.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35990a[WireFormat.FieldType.f36692h.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35990a[WireFormat.FieldType.f36690f.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f35990a[WireFormat.FieldType.f36702r.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f35990a[WireFormat.FieldType.f36703s.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f35990a[WireFormat.FieldType.f36704t.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f35990a[WireFormat.FieldType.f36705u.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f35990a[WireFormat.FieldType.f36696l.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f35990a[WireFormat.FieldType.f36700p.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f35990a[WireFormat.FieldType.f36691g.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f35990a[WireFormat.FieldType.f36689d.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f35990a[WireFormat.FieldType.f36688c.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f35990a[WireFormat.FieldType.f36698n.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f35990a[WireFormat.FieldType.f36699o.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f35990a[WireFormat.FieldType.f36701q.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SafeDirectWriter extends BinaryWriter {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ByteBuffer f35991e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f35992f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f35993g;

        private int G0() {
            return this.f35992f - this.f35993g;
        }

        private void I0() {
            K0(W());
        }

        private void J0(int i3) {
            K0(X(i3));
        }

        private void K0(AllocatedBuffer allocatedBuffer) {
            if (!allocatedBuffer.d()) {
                throw new RuntimeException("Allocated buffer does not have NIO buffer");
            }
            ByteBuffer byteBufferF = allocatedBuffer.f();
            if (!byteBufferF.isDirect()) {
                throw new RuntimeException("Allocator returned non-direct buffer");
            }
            H0();
            this.f35988c.addFirst(allocatedBuffer);
            this.f35991e = byteBufferF;
            Java8Compatibility.a(byteBufferF, byteBufferF.capacity());
            Java8Compatibility.c(this.f35991e, 0);
            this.f35991e.order(ByteOrder.LITTLE_ENDIAN);
            int iLimit = this.f35991e.limit() - 1;
            this.f35992f = iLimit;
            this.f35993g = iLimit;
        }

        private int L0() {
            return this.f35993g + 1;
        }

        private void O0(int i3) {
            ByteBuffer byteBuffer = this.f35991e;
            int i4 = this.f35993g;
            this.f35993g = i4 - 1;
            byteBuffer.put(i4, (byte) (i3 >>> 28));
            int i5 = this.f35993g;
            this.f35993g = i5 - 4;
            this.f35991e.putInt(i5 - 3, (i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD | ((((i3 >>> 21) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) << 24) | ((((i3 >>> 14) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) << 16) | ((((i3 >>> 7) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) << 8));
        }

        private void P0(int i3) {
            int i4 = this.f35993g;
            this.f35993g = i4 - 4;
            this.f35991e.putInt(i4 - 3, (i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD | ((266338304 & i3) << 3) | (((2080768 & i3) | 2097152) << 2) | (((i3 & 16256) | 16384) << 1));
        }

        private void Q0(int i3) {
            ByteBuffer byteBuffer = this.f35991e;
            int i4 = this.f35993g;
            this.f35993g = i4 - 1;
            byteBuffer.put(i4, (byte) i3);
        }

        private void R0(int i3) {
            int i4 = this.f35993g - 3;
            this.f35993g = i4;
            this.f35991e.putInt(i4, (((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) << 8) | ((2080768 & i3) << 10) | (((i3 & 16256) | 16384) << 9));
        }

        private void S0(int i3) {
            int i4 = this.f35993g;
            this.f35993g = i4 - 2;
            this.f35991e.putShort(i4 - 1, (short) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD | ((i3 & 16256) << 1)));
        }

        private void T0(long j3) {
            int i3 = this.f35993g;
            this.f35993g = i3 - 8;
            this.f35991e.putLong(i3 - 7, (j3 & 127) | 128 | ((71494644084506624L & j3) << 7) | (((558551906910208L & j3) | 562949953421312L) << 6) | (((4363686772736L & j3) | 4398046511104L) << 5) | (((34091302912L & j3) | 34359738368L) << 4) | (((266338304 & j3) | 268435456) << 3) | (((2080768 & j3) | 2097152) << 2) | (((16256 & j3) | 16384) << 1));
        }

        private void U0(long j3) {
            int i3 = this.f35993g;
            this.f35993g = i3 - 8;
            this.f35991e.putLong(i3 - 7, (j3 & 127) | 128 | (((71494644084506624L & j3) | 72057594037927936L) << 7) | (((558551906910208L & j3) | 562949953421312L) << 6) | (((4363686772736L & j3) | 4398046511104L) << 5) | (((34091302912L & j3) | 34359738368L) << 4) | (((266338304 & j3) | 268435456) << 3) | (((2080768 & j3) | 2097152) << 2) | (((16256 & j3) | 16384) << 1));
        }

        private void V0(long j3) {
            int i3 = this.f35993g;
            this.f35993g = i3 - 5;
            this.f35991e.putLong(i3 - 7, (((j3 & 127) | 128) << 24) | ((34091302912L & j3) << 28) | (((266338304 & j3) | 268435456) << 27) | (((2080768 & j3) | 2097152) << 26) | (((16256 & j3) | 16384) << 25));
        }

        private void W0(long j3) {
            P0((int) j3);
        }

        private void X0(long j3) {
            ByteBuffer byteBuffer = this.f35991e;
            int i3 = this.f35993g;
            this.f35993g = i3 - 1;
            byteBuffer.put(i3, (byte) (j3 >>> 56));
            U0(j3 & 72057594037927935L);
        }

        private void Y0(long j3) {
            Q0((int) j3);
        }

        private void Z0(long j3) {
            int i3 = this.f35993g - 7;
            this.f35993g = i3;
            this.f35991e.putLong(i3, (((j3 & 127) | 128) << 8) | ((558551906910208L & j3) << 14) | (((4363686772736L & j3) | 4398046511104L) << 13) | (((34091302912L & j3) | 34359738368L) << 12) | (((266338304 & j3) | 268435456) << 11) | (((2080768 & j3) | 2097152) << 10) | (((16256 & j3) | 16384) << 9));
        }

        private void a1(long j3) {
            int i3 = this.f35993g;
            this.f35993g = i3 - 6;
            this.f35991e.putLong(i3 - 7, (((j3 & 127) | 128) << 16) | ((4363686772736L & j3) << 21) | (((34091302912L & j3) | 34359738368L) << 20) | (((266338304 & j3) | 268435456) << 19) | (((2080768 & j3) | 2097152) << 18) | (((16256 & j3) | 16384) << 17));
        }

        private void b1(long j3) {
            ByteBuffer byteBuffer = this.f35991e;
            int i3 = this.f35993g;
            this.f35993g = i3 - 1;
            byteBuffer.put(i3, (byte) (j3 >>> 63));
            ByteBuffer byteBuffer2 = this.f35991e;
            int i4 = this.f35993g;
            this.f35993g = i4 - 1;
            byteBuffer2.put(i4, (byte) (((j3 >>> 56) & 127) | 128));
            U0(j3 & 72057594037927935L);
        }

        private void c1(long j3) {
            R0((int) j3);
        }

        private void d1(long j3) {
            S0((int) j3);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void D(int i3) {
            z0(i3, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void E0(int i3) {
            if ((i3 & (-128)) == 0) {
                Q0(i3);
                return;
            }
            if ((i3 & (-16384)) == 0) {
                S0(i3);
                return;
            }
            if (((-2097152) & i3) == 0) {
                R0(i3);
            } else if (((-268435456) & i3) == 0) {
                P0(i3);
            } else {
                O0(i3);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void F0(long j3) {
            switch (BinaryWriter.U(j3)) {
                case 1:
                    Y0(j3);
                    break;
                case 2:
                    d1(j3);
                    break;
                case 3:
                    c1(j3);
                    break;
                case 4:
                    W0(j3);
                    break;
                case 5:
                    V0(j3);
                    break;
                case 6:
                    a1(j3);
                    break;
                case 7:
                    Z0(j3);
                    break;
                case 8:
                    T0(j3);
                    break;
                case 9:
                    X0(j3);
                    break;
                case 10:
                    b1(j3);
                    break;
            }
        }

        void H0() {
            if (this.f35991e != null) {
                this.f35989d += G0();
                Java8Compatibility.c(this.f35991e, this.f35993g + 1);
                this.f35991e = null;
                this.f35993g = 0;
                this.f35992f = 0;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void I(int i3, int i4) {
            a0(10);
            t0(i4);
            z0(i3, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void L(int i3, ByteString byteString) {
            try {
                byteString.T(this);
                a0(10);
                E0(byteString.size());
                z0(i3, 2);
            } catch (IOException e3) {
                throw new RuntimeException(e3);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void M(int i3, Object obj, Schema schema) {
            int iV = V();
            schema.h(obj, this);
            int iV2 = V() - iV;
            a0(10);
            E0(iV2);
            z0(i3, 2);
        }

        public void M0(byte b3) {
            ByteBuffer byteBuffer = this.f35991e;
            int i3 = this.f35993g;
            this.f35993g = i3 - 1;
            byteBuffer.put(i3, b3);
        }

        void N0(String str) {
            int i3;
            int i4;
            int i5;
            char cCharAt;
            a0(str.length());
            int length = str.length() - 1;
            this.f35993g -= length;
            while (length >= 0 && (cCharAt = str.charAt(length)) < 128) {
                this.f35991e.put(this.f35993g + length, (byte) cCharAt);
                length--;
            }
            if (length == -1) {
                this.f35993g--;
                return;
            }
            this.f35993g += length;
            while (length >= 0) {
                char cCharAt2 = str.charAt(length);
                if (cCharAt2 < 128 && (i5 = this.f35993g) >= 0) {
                    ByteBuffer byteBuffer = this.f35991e;
                    this.f35993g = i5 - 1;
                    byteBuffer.put(i5, (byte) cCharAt2);
                } else if (cCharAt2 < 2048 && (i4 = this.f35993g) > 0) {
                    ByteBuffer byteBuffer2 = this.f35991e;
                    this.f35993g = i4 - 1;
                    byteBuffer2.put(i4, (byte) ((cCharAt2 & '?') | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                    ByteBuffer byteBuffer3 = this.f35991e;
                    int i6 = this.f35993g;
                    this.f35993g = i6 - 1;
                    byteBuffer3.put(i6, (byte) ((cCharAt2 >>> 6) | 960));
                } else if ((cCharAt2 < 55296 || 57343 < cCharAt2) && (i3 = this.f35993g) > 1) {
                    ByteBuffer byteBuffer4 = this.f35991e;
                    this.f35993g = i3 - 1;
                    byteBuffer4.put(i3, (byte) ((cCharAt2 & '?') | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                    ByteBuffer byteBuffer5 = this.f35991e;
                    int i7 = this.f35993g;
                    this.f35993g = i7 - 1;
                    byteBuffer5.put(i7, (byte) (((cCharAt2 >>> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                    ByteBuffer byteBuffer6 = this.f35991e;
                    int i8 = this.f35993g;
                    this.f35993g = i8 - 1;
                    byteBuffer6.put(i8, (byte) ((cCharAt2 >>> '\f') | 480));
                } else {
                    if (this.f35993g > 2) {
                        if (length != 0) {
                            char cCharAt3 = str.charAt(length - 1);
                            if (Character.isSurrogatePair(cCharAt3, cCharAt2)) {
                                length--;
                                int codePoint = Character.toCodePoint(cCharAt3, cCharAt2);
                                ByteBuffer byteBuffer7 = this.f35991e;
                                int i9 = this.f35993g;
                                this.f35993g = i9 - 1;
                                byteBuffer7.put(i9, (byte) ((codePoint & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                                ByteBuffer byteBuffer8 = this.f35991e;
                                int i10 = this.f35993g;
                                this.f35993g = i10 - 1;
                                byteBuffer8.put(i10, (byte) (((codePoint >>> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                                ByteBuffer byteBuffer9 = this.f35991e;
                                int i11 = this.f35993g;
                                this.f35993g = i11 - 1;
                                byteBuffer9.put(i11, (byte) (((codePoint >>> 12) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
                                ByteBuffer byteBuffer10 = this.f35991e;
                                int i12 = this.f35993g;
                                this.f35993g = i12 - 1;
                                byteBuffer10.put(i12, (byte) ((codePoint >>> 18) | 240));
                            }
                        }
                        throw new Utf8.UnpairedSurrogateException(length - 1, length);
                    }
                    a0(length);
                    length++;
                }
                length--;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void O(int i3, Object obj, Schema schema) {
            z0(i3, 4);
            schema.h(obj, this);
            z0(i3, 3);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void Q(byte[] bArr, int i3, int i4) {
            if (L0() < i4) {
                J0(i4);
            }
            int i5 = this.f35993g - i4;
            this.f35993g = i5;
            Java8Compatibility.c(this.f35991e, i5 + 1);
            this.f35991e.put(bArr, i3, i4);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void R(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (L0() < iRemaining) {
                this.f35989d += iRemaining;
                this.f35988c.addFirst(AllocatedBuffer.i(byteBuffer));
                I0();
            } else {
                int i3 = this.f35993g - iRemaining;
                this.f35993g = i3;
                Java8Compatibility.c(this.f35991e, i3 + 1);
                this.f35991e.put(byteBuffer);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void S(byte[] bArr, int i3, int i4) {
            if (L0() < i4) {
                this.f35989d += i4;
                this.f35988c.addFirst(AllocatedBuffer.k(bArr, i3, i4));
                I0();
            } else {
                int i5 = this.f35993g - i4;
                this.f35993g = i5;
                Java8Compatibility.c(this.f35991e, i5 + 1);
                this.f35991e.put(bArr, i3, i4);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public int V() {
            return this.f35989d + G0();
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void a0(int i3) {
            if (L0() < i3) {
                J0(i3);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void b0(boolean z2) {
            M0(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void c(int i3, int i4) {
            a0(9);
            g0(i4);
            z0(i3, 5);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void e(int i3, String str) {
            int iV = V();
            N0(str);
            int iV2 = V() - iV;
            a0(10);
            E0(iV2);
            z0(i3, 2);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void f(int i3, long j3) {
            a0(15);
            F0(j3);
            z0(i3, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void g0(int i3) {
            int i4 = this.f35993g;
            this.f35993g = i4 - 4;
            this.f35991e.putInt(i4 - 3, i3);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void h(int i3, int i4) {
            a0(15);
            o0(i4);
            z0(i3, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void j0(long j3) {
            int i3 = this.f35993g;
            this.f35993g = i3 - 8;
            this.f35991e.putLong(i3 - 7, j3);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void m(int i3, long j3) {
            a0(15);
            w0(j3);
            z0(i3, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void o(int i3, int i4) {
            a0(10);
            E0(i4);
            z0(i3, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void o0(int i3) {
            if (i3 >= 0) {
                E0(i3);
            } else {
                F0(i3);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void s(int i3, long j3) {
            a0(13);
            j0(j3);
            z0(i3, 1);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void t0(int i3) {
            E0(CodedOutputStream.R0(i3));
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void u(int i3, Object obj) {
            int iV = V();
            Protobuf.a().e(obj, this);
            int iV2 = V() - iV;
            a0(10);
            E0(iV2);
            z0(i3, 2);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void w(int i3, boolean z2) {
            a0(6);
            M0(z2 ? (byte) 1 : (byte) 0);
            z0(i3, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void w0(long j3) {
            F0(CodedOutputStream.S0(j3));
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void y(int i3) {
            z0(i3, 3);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void z0(int i3, int i4) {
            E0(WireFormat.c(i3, i4));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SafeHeapWriter extends BinaryWriter {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private AllocatedBuffer f35994e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private byte[] f35995f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f35996g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f35997h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f35998i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f35999j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f36000k;

        private void I0() {
            K0(Y());
        }

        private void J0(int i3) {
            K0(Z(i3));
        }

        private void K0(AllocatedBuffer allocatedBuffer) {
            if (!allocatedBuffer.c()) {
                throw new RuntimeException("Allocator returned non-heap buffer");
            }
            H0();
            this.f35988c.addFirst(allocatedBuffer);
            this.f35994e = allocatedBuffer;
            this.f35995f = allocatedBuffer.a();
            int iB = allocatedBuffer.b();
            this.f35997h = allocatedBuffer.e() + iB;
            int iG = iB + allocatedBuffer.g();
            this.f35996g = iG;
            this.f35998i = iG - 1;
            int i3 = this.f35997h - 1;
            this.f35999j = i3;
            this.f36000k = i3;
        }

        private void O0(int i3) {
            byte[] bArr = this.f35995f;
            int i4 = this.f36000k;
            int i5 = i4 - 1;
            this.f36000k = i5;
            bArr[i4] = (byte) (i3 >>> 28);
            int i6 = i4 - 2;
            this.f36000k = i6;
            bArr[i5] = (byte) (((i3 >>> 21) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            int i7 = i4 - 3;
            this.f36000k = i7;
            bArr[i6] = (byte) (((i3 >>> 14) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            int i8 = i4 - 4;
            this.f36000k = i8;
            bArr[i7] = (byte) (((i3 >>> 7) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            this.f36000k = i4 - 5;
            bArr[i8] = (byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        }

        private void P0(int i3) {
            byte[] bArr = this.f35995f;
            int i4 = this.f36000k;
            int i5 = i4 - 1;
            this.f36000k = i5;
            bArr[i4] = (byte) (i3 >>> 21);
            int i6 = i4 - 2;
            this.f36000k = i6;
            bArr[i5] = (byte) (((i3 >>> 14) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            int i7 = i4 - 3;
            this.f36000k = i7;
            bArr[i6] = (byte) (((i3 >>> 7) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            this.f36000k = i4 - 4;
            bArr[i7] = (byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        }

        private void Q0(int i3) {
            byte[] bArr = this.f35995f;
            int i4 = this.f36000k;
            this.f36000k = i4 - 1;
            bArr[i4] = (byte) i3;
        }

        private void R0(int i3) {
            byte[] bArr = this.f35995f;
            int i4 = this.f36000k;
            int i5 = i4 - 1;
            this.f36000k = i5;
            bArr[i4] = (byte) (i3 >>> 14);
            int i6 = i4 - 2;
            this.f36000k = i6;
            bArr[i5] = (byte) (((i3 >>> 7) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            this.f36000k = i4 - 3;
            bArr[i6] = (byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        }

        private void S0(int i3) {
            byte[] bArr = this.f35995f;
            int i4 = this.f36000k;
            int i5 = i4 - 1;
            this.f36000k = i5;
            bArr[i4] = (byte) (i3 >>> 7);
            this.f36000k = i4 - 2;
            bArr[i5] = (byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        }

        private void T0(long j3) {
            byte[] bArr = this.f35995f;
            int i3 = this.f36000k;
            int i4 = i3 - 1;
            this.f36000k = i4;
            bArr[i3] = (byte) (j3 >>> 49);
            int i5 = i3 - 2;
            this.f36000k = i5;
            bArr[i4] = (byte) (((j3 >>> 42) & 127) | 128);
            int i6 = i3 - 3;
            this.f36000k = i6;
            bArr[i5] = (byte) (((j3 >>> 35) & 127) | 128);
            int i7 = i3 - 4;
            this.f36000k = i7;
            bArr[i6] = (byte) (((j3 >>> 28) & 127) | 128);
            int i8 = i3 - 5;
            this.f36000k = i8;
            bArr[i7] = (byte) (((j3 >>> 21) & 127) | 128);
            int i9 = i3 - 6;
            this.f36000k = i9;
            bArr[i8] = (byte) (((j3 >>> 14) & 127) | 128);
            int i10 = i3 - 7;
            this.f36000k = i10;
            bArr[i9] = (byte) (((j3 >>> 7) & 127) | 128);
            this.f36000k = i3 - 8;
            bArr[i10] = (byte) ((j3 & 127) | 128);
        }

        private void U0(long j3) {
            byte[] bArr = this.f35995f;
            int i3 = this.f36000k;
            int i4 = i3 - 1;
            this.f36000k = i4;
            bArr[i3] = (byte) (j3 >>> 28);
            int i5 = i3 - 2;
            this.f36000k = i5;
            bArr[i4] = (byte) (((j3 >>> 21) & 127) | 128);
            int i6 = i3 - 3;
            this.f36000k = i6;
            bArr[i5] = (byte) (((j3 >>> 14) & 127) | 128);
            int i7 = i3 - 4;
            this.f36000k = i7;
            bArr[i6] = (byte) (((j3 >>> 7) & 127) | 128);
            this.f36000k = i3 - 5;
            bArr[i7] = (byte) ((j3 & 127) | 128);
        }

        private void V0(long j3) {
            byte[] bArr = this.f35995f;
            int i3 = this.f36000k;
            int i4 = i3 - 1;
            this.f36000k = i4;
            bArr[i3] = (byte) (j3 >>> 21);
            int i5 = i3 - 2;
            this.f36000k = i5;
            bArr[i4] = (byte) (((j3 >>> 14) & 127) | 128);
            int i6 = i3 - 3;
            this.f36000k = i6;
            bArr[i5] = (byte) (((j3 >>> 7) & 127) | 128);
            this.f36000k = i3 - 4;
            bArr[i6] = (byte) ((j3 & 127) | 128);
        }

        private void W0(long j3) {
            byte[] bArr = this.f35995f;
            int i3 = this.f36000k;
            int i4 = i3 - 1;
            this.f36000k = i4;
            bArr[i3] = (byte) (j3 >>> 56);
            int i5 = i3 - 2;
            this.f36000k = i5;
            bArr[i4] = (byte) (((j3 >>> 49) & 127) | 128);
            int i6 = i3 - 3;
            this.f36000k = i6;
            bArr[i5] = (byte) (((j3 >>> 42) & 127) | 128);
            int i7 = i3 - 4;
            this.f36000k = i7;
            bArr[i6] = (byte) (((j3 >>> 35) & 127) | 128);
            int i8 = i3 - 5;
            this.f36000k = i8;
            bArr[i7] = (byte) (((j3 >>> 28) & 127) | 128);
            int i9 = i3 - 6;
            this.f36000k = i9;
            bArr[i8] = (byte) (((j3 >>> 21) & 127) | 128);
            int i10 = i3 - 7;
            this.f36000k = i10;
            bArr[i9] = (byte) (((j3 >>> 14) & 127) | 128);
            int i11 = i3 - 8;
            this.f36000k = i11;
            bArr[i10] = (byte) (((j3 >>> 7) & 127) | 128);
            this.f36000k = i3 - 9;
            bArr[i11] = (byte) ((j3 & 127) | 128);
        }

        private void X0(long j3) {
            byte[] bArr = this.f35995f;
            int i3 = this.f36000k;
            this.f36000k = i3 - 1;
            bArr[i3] = (byte) j3;
        }

        private void Y0(long j3) {
            byte[] bArr = this.f35995f;
            int i3 = this.f36000k;
            int i4 = i3 - 1;
            this.f36000k = i4;
            bArr[i3] = (byte) (j3 >>> 42);
            int i5 = i3 - 2;
            this.f36000k = i5;
            bArr[i4] = (byte) (((j3 >>> 35) & 127) | 128);
            int i6 = i3 - 3;
            this.f36000k = i6;
            bArr[i5] = (byte) (((j3 >>> 28) & 127) | 128);
            int i7 = i3 - 4;
            this.f36000k = i7;
            bArr[i6] = (byte) (((j3 >>> 21) & 127) | 128);
            int i8 = i3 - 5;
            this.f36000k = i8;
            bArr[i7] = (byte) (((j3 >>> 14) & 127) | 128);
            int i9 = i3 - 6;
            this.f36000k = i9;
            bArr[i8] = (byte) (((j3 >>> 7) & 127) | 128);
            this.f36000k = i3 - 7;
            bArr[i9] = (byte) ((j3 & 127) | 128);
        }

        private void Z0(long j3) {
            byte[] bArr = this.f35995f;
            int i3 = this.f36000k;
            int i4 = i3 - 1;
            this.f36000k = i4;
            bArr[i3] = (byte) (j3 >>> 35);
            int i5 = i3 - 2;
            this.f36000k = i5;
            bArr[i4] = (byte) (((j3 >>> 28) & 127) | 128);
            int i6 = i3 - 3;
            this.f36000k = i6;
            bArr[i5] = (byte) (((j3 >>> 21) & 127) | 128);
            int i7 = i3 - 4;
            this.f36000k = i7;
            bArr[i6] = (byte) (((j3 >>> 14) & 127) | 128);
            int i8 = i3 - 5;
            this.f36000k = i8;
            bArr[i7] = (byte) (((j3 >>> 7) & 127) | 128);
            this.f36000k = i3 - 6;
            bArr[i8] = (byte) ((j3 & 127) | 128);
        }

        private void a1(long j3) {
            byte[] bArr = this.f35995f;
            int i3 = this.f36000k;
            int i4 = i3 - 1;
            this.f36000k = i4;
            bArr[i3] = (byte) (j3 >>> 63);
            int i5 = i3 - 2;
            this.f36000k = i5;
            bArr[i4] = (byte) (((j3 >>> 56) & 127) | 128);
            int i6 = i3 - 3;
            this.f36000k = i6;
            bArr[i5] = (byte) (((j3 >>> 49) & 127) | 128);
            int i7 = i3 - 4;
            this.f36000k = i7;
            bArr[i6] = (byte) (((j3 >>> 42) & 127) | 128);
            int i8 = i3 - 5;
            this.f36000k = i8;
            bArr[i7] = (byte) (((j3 >>> 35) & 127) | 128);
            int i9 = i3 - 6;
            this.f36000k = i9;
            bArr[i8] = (byte) (((j3 >>> 28) & 127) | 128);
            int i10 = i3 - 7;
            this.f36000k = i10;
            bArr[i9] = (byte) (((j3 >>> 21) & 127) | 128);
            int i11 = i3 - 8;
            this.f36000k = i11;
            bArr[i10] = (byte) (((j3 >>> 14) & 127) | 128);
            int i12 = i3 - 9;
            this.f36000k = i12;
            bArr[i11] = (byte) (((j3 >>> 7) & 127) | 128);
            this.f36000k = i3 - 10;
            bArr[i12] = (byte) ((j3 & 127) | 128);
        }

        private void b1(long j3) {
            byte[] bArr = this.f35995f;
            int i3 = this.f36000k;
            int i4 = i3 - 1;
            this.f36000k = i4;
            bArr[i3] = (byte) (((int) j3) >>> 14);
            int i5 = i3 - 2;
            this.f36000k = i5;
            bArr[i4] = (byte) (((j3 >>> 7) & 127) | 128);
            this.f36000k = i3 - 3;
            bArr[i5] = (byte) ((j3 & 127) | 128);
        }

        private void c1(long j3) {
            byte[] bArr = this.f35995f;
            int i3 = this.f36000k;
            int i4 = i3 - 1;
            this.f36000k = i4;
            bArr[i3] = (byte) (j3 >>> 7);
            this.f36000k = i3 - 2;
            bArr[i4] = (byte) ((((int) j3) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void D(int i3) {
            z0(i3, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void E0(int i3) {
            if ((i3 & (-128)) == 0) {
                Q0(i3);
                return;
            }
            if ((i3 & (-16384)) == 0) {
                S0(i3);
                return;
            }
            if (((-2097152) & i3) == 0) {
                R0(i3);
            } else if (((-268435456) & i3) == 0) {
                P0(i3);
            } else {
                O0(i3);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void F0(long j3) {
            switch (BinaryWriter.U(j3)) {
                case 1:
                    X0(j3);
                    break;
                case 2:
                    c1(j3);
                    break;
                case 3:
                    b1(j3);
                    break;
                case 4:
                    V0(j3);
                    break;
                case 5:
                    U0(j3);
                    break;
                case 6:
                    Z0(j3);
                    break;
                case 7:
                    Y0(j3);
                    break;
                case 8:
                    T0(j3);
                    break;
                case 9:
                    W0(j3);
                    break;
                case 10:
                    a1(j3);
                    break;
            }
        }

        int G0() {
            return this.f35999j - this.f36000k;
        }

        void H0() {
            if (this.f35994e != null) {
                this.f35989d += G0();
                AllocatedBuffer allocatedBuffer = this.f35994e;
                allocatedBuffer.h((this.f36000k - allocatedBuffer.b()) + 1);
                this.f35994e = null;
                this.f36000k = 0;
                this.f35999j = 0;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void I(int i3, int i4) {
            a0(10);
            t0(i4);
            z0(i3, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void L(int i3, ByteString byteString) {
            try {
                byteString.T(this);
                a0(10);
                E0(byteString.size());
                z0(i3, 2);
            } catch (IOException e3) {
                throw new RuntimeException(e3);
            }
        }

        int L0() {
            return this.f36000k - this.f35998i;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void M(int i3, Object obj, Schema schema) {
            int iV = V();
            schema.h(obj, this);
            int iV2 = V() - iV;
            a0(10);
            E0(iV2);
            z0(i3, 2);
        }

        public void M0(byte b3) {
            byte[] bArr = this.f35995f;
            int i3 = this.f36000k;
            this.f36000k = i3 - 1;
            bArr[i3] = b3;
        }

        void N0(String str) {
            int i3;
            int i4;
            int i5;
            char cCharAt;
            a0(str.length());
            int length = str.length() - 1;
            this.f36000k -= length;
            while (length >= 0 && (cCharAt = str.charAt(length)) < 128) {
                this.f35995f[this.f36000k + length] = (byte) cCharAt;
                length--;
            }
            if (length == -1) {
                this.f36000k--;
                return;
            }
            this.f36000k += length;
            while (length >= 0) {
                char cCharAt2 = str.charAt(length);
                if (cCharAt2 < 128 && (i5 = this.f36000k) > this.f35998i) {
                    byte[] bArr = this.f35995f;
                    this.f36000k = i5 - 1;
                    bArr[i5] = (byte) cCharAt2;
                } else if (cCharAt2 < 2048 && (i4 = this.f36000k) > this.f35996g) {
                    byte[] bArr2 = this.f35995f;
                    int i6 = i4 - 1;
                    this.f36000k = i6;
                    bArr2[i4] = (byte) ((cCharAt2 & '?') | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    this.f36000k = i4 - 2;
                    bArr2[i6] = (byte) ((cCharAt2 >>> 6) | 960);
                } else if ((cCharAt2 < 55296 || 57343 < cCharAt2) && (i3 = this.f36000k) > this.f35996g + 1) {
                    byte[] bArr3 = this.f35995f;
                    int i7 = i3 - 1;
                    this.f36000k = i7;
                    bArr3[i3] = (byte) ((cCharAt2 & '?') | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    int i8 = i3 - 2;
                    this.f36000k = i8;
                    bArr3[i7] = (byte) (((cCharAt2 >>> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                    this.f36000k = i3 - 3;
                    bArr3[i8] = (byte) ((cCharAt2 >>> '\f') | 480);
                } else {
                    if (this.f36000k > this.f35996g + 2) {
                        if (length != 0) {
                            char cCharAt3 = str.charAt(length - 1);
                            if (Character.isSurrogatePair(cCharAt3, cCharAt2)) {
                                length--;
                                int codePoint = Character.toCodePoint(cCharAt3, cCharAt2);
                                byte[] bArr4 = this.f35995f;
                                int i9 = this.f36000k;
                                int i10 = i9 - 1;
                                this.f36000k = i10;
                                bArr4[i9] = (byte) ((codePoint & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                                int i11 = i9 - 2;
                                this.f36000k = i11;
                                bArr4[i10] = (byte) (((codePoint >>> 6) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                                int i12 = i9 - 3;
                                this.f36000k = i12;
                                bArr4[i11] = (byte) (((codePoint >>> 12) & 63) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                                this.f36000k = i9 - 4;
                                bArr4[i12] = (byte) ((codePoint >>> 18) | 240);
                            }
                        }
                        throw new Utf8.UnpairedSurrogateException(length - 1, length);
                    }
                    a0(length);
                    length++;
                }
                length--;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void O(int i3, Object obj, Schema schema) {
            z0(i3, 4);
            schema.h(obj, this);
            z0(i3, 3);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void Q(byte[] bArr, int i3, int i4) {
            if (L0() < i4) {
                J0(i4);
            }
            int i5 = this.f36000k - i4;
            this.f36000k = i5;
            System.arraycopy(bArr, i3, this.f35995f, i5 + 1, i4);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void R(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (L0() < iRemaining) {
                this.f35989d += iRemaining;
                this.f35988c.addFirst(AllocatedBuffer.i(byteBuffer));
                I0();
            }
            int i3 = this.f36000k - iRemaining;
            this.f36000k = i3;
            byteBuffer.get(this.f35995f, i3 + 1, iRemaining);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void S(byte[] bArr, int i3, int i4) {
            if (L0() < i4) {
                this.f35989d += i4;
                this.f35988c.addFirst(AllocatedBuffer.k(bArr, i3, i4));
                I0();
            } else {
                int i5 = this.f36000k - i4;
                this.f36000k = i5;
                System.arraycopy(bArr, i3, this.f35995f, i5 + 1, i4);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public int V() {
            return this.f35989d + G0();
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void a0(int i3) {
            if (L0() < i3) {
                J0(i3);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void b0(boolean z2) {
            M0(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void c(int i3, int i4) {
            a0(9);
            g0(i4);
            z0(i3, 5);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void e(int i3, String str) {
            int iV = V();
            N0(str);
            int iV2 = V() - iV;
            a0(10);
            E0(iV2);
            z0(i3, 2);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void f(int i3, long j3) {
            a0(15);
            F0(j3);
            z0(i3, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void g0(int i3) {
            byte[] bArr = this.f35995f;
            int i4 = this.f36000k;
            int i5 = i4 - 1;
            this.f36000k = i5;
            bArr[i4] = (byte) ((i3 >> 24) & 255);
            int i6 = i4 - 2;
            this.f36000k = i6;
            bArr[i5] = (byte) ((i3 >> 16) & 255);
            int i7 = i4 - 3;
            this.f36000k = i7;
            bArr[i6] = (byte) ((i3 >> 8) & 255);
            this.f36000k = i4 - 4;
            bArr[i7] = (byte) (i3 & 255);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void h(int i3, int i4) {
            a0(15);
            o0(i4);
            z0(i3, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void j0(long j3) {
            byte[] bArr = this.f35995f;
            int i3 = this.f36000k;
            int i4 = i3 - 1;
            this.f36000k = i4;
            bArr[i3] = (byte) (((int) (j3 >> 56)) & 255);
            int i5 = i3 - 2;
            this.f36000k = i5;
            bArr[i4] = (byte) (((int) (j3 >> 48)) & 255);
            int i6 = i3 - 3;
            this.f36000k = i6;
            bArr[i5] = (byte) (((int) (j3 >> 40)) & 255);
            int i7 = i3 - 4;
            this.f36000k = i7;
            bArr[i6] = (byte) (((int) (j3 >> 32)) & 255);
            int i8 = i3 - 5;
            this.f36000k = i8;
            bArr[i7] = (byte) (((int) (j3 >> 24)) & 255);
            int i9 = i3 - 6;
            this.f36000k = i9;
            bArr[i8] = (byte) (((int) (j3 >> 16)) & 255);
            int i10 = i3 - 7;
            this.f36000k = i10;
            bArr[i9] = (byte) (((int) (j3 >> 8)) & 255);
            this.f36000k = i3 - 8;
            bArr[i10] = (byte) (((int) j3) & 255);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void m(int i3, long j3) {
            a0(15);
            w0(j3);
            z0(i3, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void o(int i3, int i4) {
            a0(10);
            E0(i4);
            z0(i3, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void o0(int i3) {
            if (i3 >= 0) {
                E0(i3);
            } else {
                F0(i3);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void s(int i3, long j3) {
            a0(13);
            j0(j3);
            z0(i3, 1);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void t0(int i3) {
            E0(CodedOutputStream.R0(i3));
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void u(int i3, Object obj) {
            int iV = V();
            Protobuf.a().e(obj, this);
            int iV2 = V() - iV;
            a0(10);
            E0(iV2);
            z0(i3, 2);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void w(int i3, boolean z2) {
            a0(6);
            M0(z2 ? (byte) 1 : (byte) 0);
            z0(i3, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void w0(long j3) {
            F0(CodedOutputStream.S0(j3));
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void y(int i3) {
            z0(i3, 3);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void z0(int i3, int i4) {
            E0(WireFormat.c(i3, i4));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class UnsafeDirectWriter extends BinaryWriter {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ByteBuffer f36001e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f36002f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f36003g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f36004h;

        private int G0() {
            return (int) (this.f36004h - this.f36002f);
        }

        private int H0() {
            return (int) (this.f36003g - this.f36004h);
        }

        private void J0() {
            L0(W());
        }

        private void K0(int i3) {
            L0(X(i3));
        }

        private void L0(AllocatedBuffer allocatedBuffer) {
            if (!allocatedBuffer.d()) {
                throw new RuntimeException("Allocated buffer does not have NIO buffer");
            }
            ByteBuffer byteBufferF = allocatedBuffer.f();
            if (!byteBufferF.isDirect()) {
                throw new RuntimeException("Allocator returned non-direct buffer");
            }
            I0();
            this.f35988c.addFirst(allocatedBuffer);
            this.f36001e = byteBufferF;
            Java8Compatibility.a(byteBufferF, byteBufferF.capacity());
            Java8Compatibility.c(this.f36001e, 0);
            long jK = UnsafeUtil.k(this.f36001e);
            this.f36002f = jK;
            long jLimit = jK + ((long) (this.f36001e.limit() - 1));
            this.f36003g = jLimit;
            this.f36004h = jLimit;
        }

        private int M0() {
            return G0() + 1;
        }

        private void P0(int i3) {
            long j3 = this.f36004h;
            this.f36004h = j3 - 1;
            UnsafeUtil.Q(j3, (byte) (i3 >>> 28));
            long j4 = this.f36004h;
            this.f36004h = j4 - 1;
            UnsafeUtil.Q(j4, (byte) (((i3 >>> 21) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
            long j5 = this.f36004h;
            this.f36004h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) (((i3 >>> 14) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
            long j6 = this.f36004h;
            this.f36004h = j6 - 1;
            UnsafeUtil.Q(j6, (byte) (((i3 >>> 7) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
            long j7 = this.f36004h;
            this.f36004h = j7 - 1;
            UnsafeUtil.Q(j7, (byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
        }

        private void Q0(int i3) {
            long j3 = this.f36004h;
            this.f36004h = j3 - 1;
            UnsafeUtil.Q(j3, (byte) (i3 >>> 21));
            long j4 = this.f36004h;
            this.f36004h = j4 - 1;
            UnsafeUtil.Q(j4, (byte) (((i3 >>> 14) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
            long j5 = this.f36004h;
            this.f36004h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) (((i3 >>> 7) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
            long j6 = this.f36004h;
            this.f36004h = j6 - 1;
            UnsafeUtil.Q(j6, (byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
        }

        private void R0(int i3) {
            long j3 = this.f36004h;
            this.f36004h = j3 - 1;
            UnsafeUtil.Q(j3, (byte) i3);
        }

        private void S0(int i3) {
            long j3 = this.f36004h;
            this.f36004h = j3 - 1;
            UnsafeUtil.Q(j3, (byte) (i3 >>> 14));
            long j4 = this.f36004h;
            this.f36004h = j4 - 1;
            UnsafeUtil.Q(j4, (byte) (((i3 >>> 7) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
            long j5 = this.f36004h;
            this.f36004h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
        }

        private void T0(int i3) {
            long j3 = this.f36004h;
            this.f36004h = j3 - 1;
            UnsafeUtil.Q(j3, (byte) (i3 >>> 7));
            long j4 = this.f36004h;
            this.f36004h = j4 - 1;
            UnsafeUtil.Q(j4, (byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
        }

        private void U0(long j3) {
            long j4 = this.f36004h;
            this.f36004h = j4 - 1;
            UnsafeUtil.Q(j4, (byte) (j3 >>> 49));
            long j5 = this.f36004h;
            this.f36004h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) (((j3 >>> 42) & 127) | 128));
            long j6 = this.f36004h;
            this.f36004h = j6 - 1;
            UnsafeUtil.Q(j6, (byte) (((j3 >>> 35) & 127) | 128));
            long j7 = this.f36004h;
            this.f36004h = j7 - 1;
            UnsafeUtil.Q(j7, (byte) (((j3 >>> 28) & 127) | 128));
            long j8 = this.f36004h;
            this.f36004h = j8 - 1;
            UnsafeUtil.Q(j8, (byte) (((j3 >>> 21) & 127) | 128));
            long j9 = this.f36004h;
            this.f36004h = j9 - 1;
            UnsafeUtil.Q(j9, (byte) (((j3 >>> 14) & 127) | 128));
            long j10 = this.f36004h;
            this.f36004h = j10 - 1;
            UnsafeUtil.Q(j10, (byte) (((j3 >>> 7) & 127) | 128));
            long j11 = this.f36004h;
            this.f36004h = j11 - 1;
            UnsafeUtil.Q(j11, (byte) ((j3 & 127) | 128));
        }

        private void V0(long j3) {
            long j4 = this.f36004h;
            this.f36004h = j4 - 1;
            UnsafeUtil.Q(j4, (byte) (j3 >>> 28));
            long j5 = this.f36004h;
            this.f36004h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) (((j3 >>> 21) & 127) | 128));
            long j6 = this.f36004h;
            this.f36004h = j6 - 1;
            UnsafeUtil.Q(j6, (byte) (((j3 >>> 14) & 127) | 128));
            long j7 = this.f36004h;
            this.f36004h = j7 - 1;
            UnsafeUtil.Q(j7, (byte) (((j3 >>> 7) & 127) | 128));
            long j8 = this.f36004h;
            this.f36004h = j8 - 1;
            UnsafeUtil.Q(j8, (byte) ((j3 & 127) | 128));
        }

        private void W0(long j3) {
            long j4 = this.f36004h;
            this.f36004h = j4 - 1;
            UnsafeUtil.Q(j4, (byte) (j3 >>> 21));
            long j5 = this.f36004h;
            this.f36004h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) (((j3 >>> 14) & 127) | 128));
            long j6 = this.f36004h;
            this.f36004h = j6 - 1;
            UnsafeUtil.Q(j6, (byte) (((j3 >>> 7) & 127) | 128));
            long j7 = this.f36004h;
            this.f36004h = j7 - 1;
            UnsafeUtil.Q(j7, (byte) ((j3 & 127) | 128));
        }

        private void X0(long j3) {
            long j4 = this.f36004h;
            this.f36004h = j4 - 1;
            UnsafeUtil.Q(j4, (byte) (j3 >>> 56));
            long j5 = this.f36004h;
            this.f36004h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) (((j3 >>> 49) & 127) | 128));
            long j6 = this.f36004h;
            this.f36004h = j6 - 1;
            UnsafeUtil.Q(j6, (byte) (((j3 >>> 42) & 127) | 128));
            long j7 = this.f36004h;
            this.f36004h = j7 - 1;
            UnsafeUtil.Q(j7, (byte) (((j3 >>> 35) & 127) | 128));
            long j8 = this.f36004h;
            this.f36004h = j8 - 1;
            UnsafeUtil.Q(j8, (byte) (((j3 >>> 28) & 127) | 128));
            long j9 = this.f36004h;
            this.f36004h = j9 - 1;
            UnsafeUtil.Q(j9, (byte) (((j3 >>> 21) & 127) | 128));
            long j10 = this.f36004h;
            this.f36004h = j10 - 1;
            UnsafeUtil.Q(j10, (byte) (((j3 >>> 14) & 127) | 128));
            long j11 = this.f36004h;
            this.f36004h = j11 - 1;
            UnsafeUtil.Q(j11, (byte) (((j3 >>> 7) & 127) | 128));
            long j12 = this.f36004h;
            this.f36004h = j12 - 1;
            UnsafeUtil.Q(j12, (byte) ((j3 & 127) | 128));
        }

        private void Y0(long j3) {
            long j4 = this.f36004h;
            this.f36004h = j4 - 1;
            UnsafeUtil.Q(j4, (byte) j3);
        }

        private void Z0(long j3) {
            long j4 = this.f36004h;
            this.f36004h = j4 - 1;
            UnsafeUtil.Q(j4, (byte) (j3 >>> 42));
            long j5 = this.f36004h;
            this.f36004h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) (((j3 >>> 35) & 127) | 128));
            long j6 = this.f36004h;
            this.f36004h = j6 - 1;
            UnsafeUtil.Q(j6, (byte) (((j3 >>> 28) & 127) | 128));
            long j7 = this.f36004h;
            this.f36004h = j7 - 1;
            UnsafeUtil.Q(j7, (byte) (((j3 >>> 21) & 127) | 128));
            long j8 = this.f36004h;
            this.f36004h = j8 - 1;
            UnsafeUtil.Q(j8, (byte) (((j3 >>> 14) & 127) | 128));
            long j9 = this.f36004h;
            this.f36004h = j9 - 1;
            UnsafeUtil.Q(j9, (byte) (((j3 >>> 7) & 127) | 128));
            long j10 = this.f36004h;
            this.f36004h = j10 - 1;
            UnsafeUtil.Q(j10, (byte) ((j3 & 127) | 128));
        }

        private void a1(long j3) {
            long j4 = this.f36004h;
            this.f36004h = j4 - 1;
            UnsafeUtil.Q(j4, (byte) (j3 >>> 35));
            long j5 = this.f36004h;
            this.f36004h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) (((j3 >>> 28) & 127) | 128));
            long j6 = this.f36004h;
            this.f36004h = j6 - 1;
            UnsafeUtil.Q(j6, (byte) (((j3 >>> 21) & 127) | 128));
            long j7 = this.f36004h;
            this.f36004h = j7 - 1;
            UnsafeUtil.Q(j7, (byte) (((j3 >>> 14) & 127) | 128));
            long j8 = this.f36004h;
            this.f36004h = j8 - 1;
            UnsafeUtil.Q(j8, (byte) (((j3 >>> 7) & 127) | 128));
            long j9 = this.f36004h;
            this.f36004h = j9 - 1;
            UnsafeUtil.Q(j9, (byte) ((j3 & 127) | 128));
        }

        private void b1(long j3) {
            long j4 = this.f36004h;
            this.f36004h = j4 - 1;
            UnsafeUtil.Q(j4, (byte) (j3 >>> 63));
            long j5 = this.f36004h;
            this.f36004h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) (((j3 >>> 56) & 127) | 128));
            long j6 = this.f36004h;
            this.f36004h = j6 - 1;
            UnsafeUtil.Q(j6, (byte) (((j3 >>> 49) & 127) | 128));
            long j7 = this.f36004h;
            this.f36004h = j7 - 1;
            UnsafeUtil.Q(j7, (byte) (((j3 >>> 42) & 127) | 128));
            long j8 = this.f36004h;
            this.f36004h = j8 - 1;
            UnsafeUtil.Q(j8, (byte) (((j3 >>> 35) & 127) | 128));
            long j9 = this.f36004h;
            this.f36004h = j9 - 1;
            UnsafeUtil.Q(j9, (byte) (((j3 >>> 28) & 127) | 128));
            long j10 = this.f36004h;
            this.f36004h = j10 - 1;
            UnsafeUtil.Q(j10, (byte) (((j3 >>> 21) & 127) | 128));
            long j11 = this.f36004h;
            this.f36004h = j11 - 1;
            UnsafeUtil.Q(j11, (byte) (((j3 >>> 14) & 127) | 128));
            long j12 = this.f36004h;
            this.f36004h = j12 - 1;
            UnsafeUtil.Q(j12, (byte) (((j3 >>> 7) & 127) | 128));
            long j13 = this.f36004h;
            this.f36004h = j13 - 1;
            UnsafeUtil.Q(j13, (byte) ((j3 & 127) | 128));
        }

        private void c1(long j3) {
            long j4 = this.f36004h;
            this.f36004h = j4 - 1;
            UnsafeUtil.Q(j4, (byte) (((int) j3) >>> 14));
            long j5 = this.f36004h;
            this.f36004h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) (((j3 >>> 7) & 127) | 128));
            long j6 = this.f36004h;
            this.f36004h = j6 - 1;
            UnsafeUtil.Q(j6, (byte) ((j3 & 127) | 128));
        }

        private void d1(long j3) {
            long j4 = this.f36004h;
            this.f36004h = j4 - 1;
            UnsafeUtil.Q(j4, (byte) (j3 >>> 7));
            long j5 = this.f36004h;
            this.f36004h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) ((((int) j3) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void D(int i3) {
            z0(i3, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void E0(int i3) {
            if ((i3 & (-128)) == 0) {
                R0(i3);
                return;
            }
            if ((i3 & (-16384)) == 0) {
                T0(i3);
                return;
            }
            if (((-2097152) & i3) == 0) {
                S0(i3);
            } else if (((-268435456) & i3) == 0) {
                Q0(i3);
            } else {
                P0(i3);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void F0(long j3) {
            switch (BinaryWriter.U(j3)) {
                case 1:
                    Y0(j3);
                    break;
                case 2:
                    d1(j3);
                    break;
                case 3:
                    c1(j3);
                    break;
                case 4:
                    W0(j3);
                    break;
                case 5:
                    V0(j3);
                    break;
                case 6:
                    a1(j3);
                    break;
                case 7:
                    Z0(j3);
                    break;
                case 8:
                    U0(j3);
                    break;
                case 9:
                    X0(j3);
                    break;
                case 10:
                    b1(j3);
                    break;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void I(int i3, int i4) {
            a0(10);
            t0(i4);
            z0(i3, 0);
        }

        void I0() {
            if (this.f36001e != null) {
                this.f35989d += H0();
                Java8Compatibility.c(this.f36001e, G0() + 1);
                this.f36001e = null;
                this.f36004h = 0L;
                this.f36003g = 0L;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void L(int i3, ByteString byteString) {
            try {
                byteString.T(this);
                a0(10);
                E0(byteString.size());
                z0(i3, 2);
            } catch (IOException e3) {
                throw new RuntimeException(e3);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void M(int i3, Object obj, Schema schema) {
            int iV = V();
            schema.h(obj, this);
            int iV2 = V() - iV;
            a0(10);
            E0(iV2);
            z0(i3, 2);
        }

        public void N0(byte b3) {
            long j3 = this.f36004h;
            this.f36004h = j3 - 1;
            UnsafeUtil.Q(j3, b3);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void O(int i3, Object obj, Schema schema) {
            z0(i3, 4);
            schema.h(obj, this);
            z0(i3, 3);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00a8  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void O0(java.lang.String r13) {
            /*
                Method dump skipped, instruction units count: 274
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.BinaryWriter.UnsafeDirectWriter.O0(java.lang.String):void");
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void Q(byte[] bArr, int i3, int i4) {
            if (M0() < i4) {
                K0(i4);
            }
            this.f36004h -= (long) i4;
            Java8Compatibility.c(this.f36001e, G0() + 1);
            this.f36001e.put(bArr, i3, i4);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void R(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (M0() < iRemaining) {
                this.f35989d += iRemaining;
                this.f35988c.addFirst(AllocatedBuffer.i(byteBuffer));
                J0();
            } else {
                this.f36004h -= (long) iRemaining;
                Java8Compatibility.c(this.f36001e, G0() + 1);
                this.f36001e.put(byteBuffer);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void S(byte[] bArr, int i3, int i4) {
            if (M0() < i4) {
                this.f35989d += i4;
                this.f35988c.addFirst(AllocatedBuffer.k(bArr, i3, i4));
                J0();
            } else {
                this.f36004h -= (long) i4;
                Java8Compatibility.c(this.f36001e, G0() + 1);
                this.f36001e.put(bArr, i3, i4);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public int V() {
            return this.f35989d + H0();
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void a0(int i3) {
            if (M0() < i3) {
                K0(i3);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void b0(boolean z2) {
            N0(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void c(int i3, int i4) {
            a0(9);
            g0(i4);
            z0(i3, 5);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void e(int i3, String str) {
            int iV = V();
            O0(str);
            int iV2 = V() - iV;
            a0(10);
            E0(iV2);
            z0(i3, 2);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void f(int i3, long j3) {
            a0(15);
            F0(j3);
            z0(i3, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void g0(int i3) {
            long j3 = this.f36004h;
            this.f36004h = j3 - 1;
            UnsafeUtil.Q(j3, (byte) ((i3 >> 24) & 255));
            long j4 = this.f36004h;
            this.f36004h = j4 - 1;
            UnsafeUtil.Q(j4, (byte) ((i3 >> 16) & 255));
            long j5 = this.f36004h;
            this.f36004h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) ((i3 >> 8) & 255));
            long j6 = this.f36004h;
            this.f36004h = j6 - 1;
            UnsafeUtil.Q(j6, (byte) (i3 & 255));
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void h(int i3, int i4) {
            a0(15);
            o0(i4);
            z0(i3, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void j0(long j3) {
            long j4 = this.f36004h;
            this.f36004h = j4 - 1;
            UnsafeUtil.Q(j4, (byte) (((int) (j3 >> 56)) & 255));
            long j5 = this.f36004h;
            this.f36004h = j5 - 1;
            UnsafeUtil.Q(j5, (byte) (((int) (j3 >> 48)) & 255));
            long j6 = this.f36004h;
            this.f36004h = j6 - 1;
            UnsafeUtil.Q(j6, (byte) (((int) (j3 >> 40)) & 255));
            long j7 = this.f36004h;
            this.f36004h = j7 - 1;
            UnsafeUtil.Q(j7, (byte) (((int) (j3 >> 32)) & 255));
            long j8 = this.f36004h;
            this.f36004h = j8 - 1;
            UnsafeUtil.Q(j8, (byte) (((int) (j3 >> 24)) & 255));
            long j9 = this.f36004h;
            this.f36004h = j9 - 1;
            UnsafeUtil.Q(j9, (byte) (((int) (j3 >> 16)) & 255));
            long j10 = this.f36004h;
            this.f36004h = j10 - 1;
            UnsafeUtil.Q(j10, (byte) (((int) (j3 >> 8)) & 255));
            long j11 = this.f36004h;
            this.f36004h = j11 - 1;
            UnsafeUtil.Q(j11, (byte) (((int) j3) & 255));
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void m(int i3, long j3) {
            a0(15);
            w0(j3);
            z0(i3, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void o(int i3, int i4) {
            a0(10);
            E0(i4);
            z0(i3, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void o0(int i3) {
            if (i3 >= 0) {
                E0(i3);
            } else {
                F0(i3);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void s(int i3, long j3) {
            a0(13);
            j0(j3);
            z0(i3, 1);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void t0(int i3) {
            E0(CodedOutputStream.R0(i3));
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void u(int i3, Object obj) {
            int iV = V();
            Protobuf.a().e(obj, this);
            int iV2 = V() - iV;
            a0(10);
            E0(iV2);
            z0(i3, 2);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void w(int i3, boolean z2) {
            a0(6);
            N0(z2 ? (byte) 1 : (byte) 0);
            z0(i3, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void w0(long j3) {
            F0(CodedOutputStream.S0(j3));
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void y(int i3) {
            z0(i3, 3);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void z0(int i3, int i4) {
            E0(WireFormat.c(i3, i4));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class UnsafeHeapWriter extends BinaryWriter {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private AllocatedBuffer f36005e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private byte[] f36006f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f36007g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f36008h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f36009i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f36010j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f36011k;

        private int G0() {
            return (int) this.f36011k;
        }

        private void J0() {
            L0(Y());
        }

        private void K0(int i3) {
            L0(Z(i3));
        }

        private void L0(AllocatedBuffer allocatedBuffer) {
            if (!allocatedBuffer.c()) {
                throw new RuntimeException("Allocator returned non-heap buffer");
            }
            I0();
            this.f35988c.addFirst(allocatedBuffer);
            this.f36005e = allocatedBuffer;
            this.f36006f = allocatedBuffer.a();
            long jB = allocatedBuffer.b();
            this.f36008h = ((long) allocatedBuffer.e()) + jB;
            long jG = jB + ((long) allocatedBuffer.g());
            this.f36007g = jG;
            this.f36009i = jG - 1;
            long j3 = this.f36008h - 1;
            this.f36010j = j3;
            this.f36011k = j3;
        }

        private void P0(int i3) {
            byte[] bArr = this.f36006f;
            long j3 = this.f36011k;
            this.f36011k = j3 - 1;
            UnsafeUtil.R(bArr, j3, (byte) (i3 >>> 28));
            byte[] bArr2 = this.f36006f;
            long j4 = this.f36011k;
            this.f36011k = j4 - 1;
            UnsafeUtil.R(bArr2, j4, (byte) (((i3 >>> 21) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
            byte[] bArr3 = this.f36006f;
            long j5 = this.f36011k;
            this.f36011k = j5 - 1;
            UnsafeUtil.R(bArr3, j5, (byte) (((i3 >>> 14) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
            byte[] bArr4 = this.f36006f;
            long j6 = this.f36011k;
            this.f36011k = j6 - 1;
            UnsafeUtil.R(bArr4, j6, (byte) (((i3 >>> 7) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
            byte[] bArr5 = this.f36006f;
            long j7 = this.f36011k;
            this.f36011k = j7 - 1;
            UnsafeUtil.R(bArr5, j7, (byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
        }

        private void Q0(int i3) {
            byte[] bArr = this.f36006f;
            long j3 = this.f36011k;
            this.f36011k = j3 - 1;
            UnsafeUtil.R(bArr, j3, (byte) (i3 >>> 21));
            byte[] bArr2 = this.f36006f;
            long j4 = this.f36011k;
            this.f36011k = j4 - 1;
            UnsafeUtil.R(bArr2, j4, (byte) (((i3 >>> 14) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
            byte[] bArr3 = this.f36006f;
            long j5 = this.f36011k;
            this.f36011k = j5 - 1;
            UnsafeUtil.R(bArr3, j5, (byte) (((i3 >>> 7) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
            byte[] bArr4 = this.f36006f;
            long j6 = this.f36011k;
            this.f36011k = j6 - 1;
            UnsafeUtil.R(bArr4, j6, (byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
        }

        private void R0(int i3) {
            byte[] bArr = this.f36006f;
            long j3 = this.f36011k;
            this.f36011k = j3 - 1;
            UnsafeUtil.R(bArr, j3, (byte) i3);
        }

        private void S0(int i3) {
            byte[] bArr = this.f36006f;
            long j3 = this.f36011k;
            this.f36011k = j3 - 1;
            UnsafeUtil.R(bArr, j3, (byte) (i3 >>> 14));
            byte[] bArr2 = this.f36006f;
            long j4 = this.f36011k;
            this.f36011k = j4 - 1;
            UnsafeUtil.R(bArr2, j4, (byte) (((i3 >>> 7) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
            byte[] bArr3 = this.f36006f;
            long j5 = this.f36011k;
            this.f36011k = j5 - 1;
            UnsafeUtil.R(bArr3, j5, (byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
        }

        private void T0(int i3) {
            byte[] bArr = this.f36006f;
            long j3 = this.f36011k;
            this.f36011k = j3 - 1;
            UnsafeUtil.R(bArr, j3, (byte) (i3 >>> 7));
            byte[] bArr2 = this.f36006f;
            long j4 = this.f36011k;
            this.f36011k = j4 - 1;
            UnsafeUtil.R(bArr2, j4, (byte) ((i3 & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
        }

        private void U0(long j3) {
            byte[] bArr = this.f36006f;
            long j4 = this.f36011k;
            this.f36011k = j4 - 1;
            UnsafeUtil.R(bArr, j4, (byte) (j3 >>> 49));
            byte[] bArr2 = this.f36006f;
            long j5 = this.f36011k;
            this.f36011k = j5 - 1;
            UnsafeUtil.R(bArr2, j5, (byte) (((j3 >>> 42) & 127) | 128));
            byte[] bArr3 = this.f36006f;
            long j6 = this.f36011k;
            this.f36011k = j6 - 1;
            UnsafeUtil.R(bArr3, j6, (byte) (((j3 >>> 35) & 127) | 128));
            byte[] bArr4 = this.f36006f;
            long j7 = this.f36011k;
            this.f36011k = j7 - 1;
            UnsafeUtil.R(bArr4, j7, (byte) (((j3 >>> 28) & 127) | 128));
            byte[] bArr5 = this.f36006f;
            long j8 = this.f36011k;
            this.f36011k = j8 - 1;
            UnsafeUtil.R(bArr5, j8, (byte) (((j3 >>> 21) & 127) | 128));
            byte[] bArr6 = this.f36006f;
            long j9 = this.f36011k;
            this.f36011k = j9 - 1;
            UnsafeUtil.R(bArr6, j9, (byte) (((j3 >>> 14) & 127) | 128));
            byte[] bArr7 = this.f36006f;
            long j10 = this.f36011k;
            this.f36011k = j10 - 1;
            UnsafeUtil.R(bArr7, j10, (byte) (((j3 >>> 7) & 127) | 128));
            byte[] bArr8 = this.f36006f;
            long j11 = this.f36011k;
            this.f36011k = j11 - 1;
            UnsafeUtil.R(bArr8, j11, (byte) ((j3 & 127) | 128));
        }

        private void V0(long j3) {
            byte[] bArr = this.f36006f;
            long j4 = this.f36011k;
            this.f36011k = j4 - 1;
            UnsafeUtil.R(bArr, j4, (byte) (j3 >>> 28));
            byte[] bArr2 = this.f36006f;
            long j5 = this.f36011k;
            this.f36011k = j5 - 1;
            UnsafeUtil.R(bArr2, j5, (byte) (((j3 >>> 21) & 127) | 128));
            byte[] bArr3 = this.f36006f;
            long j6 = this.f36011k;
            this.f36011k = j6 - 1;
            UnsafeUtil.R(bArr3, j6, (byte) (((j3 >>> 14) & 127) | 128));
            byte[] bArr4 = this.f36006f;
            long j7 = this.f36011k;
            this.f36011k = j7 - 1;
            UnsafeUtil.R(bArr4, j7, (byte) (((j3 >>> 7) & 127) | 128));
            byte[] bArr5 = this.f36006f;
            long j8 = this.f36011k;
            this.f36011k = j8 - 1;
            UnsafeUtil.R(bArr5, j8, (byte) ((j3 & 127) | 128));
        }

        private void W0(long j3) {
            byte[] bArr = this.f36006f;
            long j4 = this.f36011k;
            this.f36011k = j4 - 1;
            UnsafeUtil.R(bArr, j4, (byte) (j3 >>> 21));
            byte[] bArr2 = this.f36006f;
            long j5 = this.f36011k;
            this.f36011k = j5 - 1;
            UnsafeUtil.R(bArr2, j5, (byte) (((j3 >>> 14) & 127) | 128));
            byte[] bArr3 = this.f36006f;
            long j6 = this.f36011k;
            this.f36011k = j6 - 1;
            UnsafeUtil.R(bArr3, j6, (byte) (((j3 >>> 7) & 127) | 128));
            byte[] bArr4 = this.f36006f;
            long j7 = this.f36011k;
            this.f36011k = j7 - 1;
            UnsafeUtil.R(bArr4, j7, (byte) ((j3 & 127) | 128));
        }

        private void X0(long j3) {
            byte[] bArr = this.f36006f;
            long j4 = this.f36011k;
            this.f36011k = j4 - 1;
            UnsafeUtil.R(bArr, j4, (byte) (j3 >>> 56));
            byte[] bArr2 = this.f36006f;
            long j5 = this.f36011k;
            this.f36011k = j5 - 1;
            UnsafeUtil.R(bArr2, j5, (byte) (((j3 >>> 49) & 127) | 128));
            byte[] bArr3 = this.f36006f;
            long j6 = this.f36011k;
            this.f36011k = j6 - 1;
            UnsafeUtil.R(bArr3, j6, (byte) (((j3 >>> 42) & 127) | 128));
            byte[] bArr4 = this.f36006f;
            long j7 = this.f36011k;
            this.f36011k = j7 - 1;
            UnsafeUtil.R(bArr4, j7, (byte) (((j3 >>> 35) & 127) | 128));
            byte[] bArr5 = this.f36006f;
            long j8 = this.f36011k;
            this.f36011k = j8 - 1;
            UnsafeUtil.R(bArr5, j8, (byte) (((j3 >>> 28) & 127) | 128));
            byte[] bArr6 = this.f36006f;
            long j9 = this.f36011k;
            this.f36011k = j9 - 1;
            UnsafeUtil.R(bArr6, j9, (byte) (((j3 >>> 21) & 127) | 128));
            byte[] bArr7 = this.f36006f;
            long j10 = this.f36011k;
            this.f36011k = j10 - 1;
            UnsafeUtil.R(bArr7, j10, (byte) (((j3 >>> 14) & 127) | 128));
            byte[] bArr8 = this.f36006f;
            long j11 = this.f36011k;
            this.f36011k = j11 - 1;
            UnsafeUtil.R(bArr8, j11, (byte) (((j3 >>> 7) & 127) | 128));
            byte[] bArr9 = this.f36006f;
            long j12 = this.f36011k;
            this.f36011k = j12 - 1;
            UnsafeUtil.R(bArr9, j12, (byte) ((j3 & 127) | 128));
        }

        private void Y0(long j3) {
            byte[] bArr = this.f36006f;
            long j4 = this.f36011k;
            this.f36011k = j4 - 1;
            UnsafeUtil.R(bArr, j4, (byte) j3);
        }

        private void Z0(long j3) {
            byte[] bArr = this.f36006f;
            long j4 = this.f36011k;
            this.f36011k = j4 - 1;
            UnsafeUtil.R(bArr, j4, (byte) (j3 >>> 42));
            byte[] bArr2 = this.f36006f;
            long j5 = this.f36011k;
            this.f36011k = j5 - 1;
            UnsafeUtil.R(bArr2, j5, (byte) (((j3 >>> 35) & 127) | 128));
            byte[] bArr3 = this.f36006f;
            long j6 = this.f36011k;
            this.f36011k = j6 - 1;
            UnsafeUtil.R(bArr3, j6, (byte) (((j3 >>> 28) & 127) | 128));
            byte[] bArr4 = this.f36006f;
            long j7 = this.f36011k;
            this.f36011k = j7 - 1;
            UnsafeUtil.R(bArr4, j7, (byte) (((j3 >>> 21) & 127) | 128));
            byte[] bArr5 = this.f36006f;
            long j8 = this.f36011k;
            this.f36011k = j8 - 1;
            UnsafeUtil.R(bArr5, j8, (byte) (((j3 >>> 14) & 127) | 128));
            byte[] bArr6 = this.f36006f;
            long j9 = this.f36011k;
            this.f36011k = j9 - 1;
            UnsafeUtil.R(bArr6, j9, (byte) (((j3 >>> 7) & 127) | 128));
            byte[] bArr7 = this.f36006f;
            long j10 = this.f36011k;
            this.f36011k = j10 - 1;
            UnsafeUtil.R(bArr7, j10, (byte) ((j3 & 127) | 128));
        }

        private void a1(long j3) {
            byte[] bArr = this.f36006f;
            long j4 = this.f36011k;
            this.f36011k = j4 - 1;
            UnsafeUtil.R(bArr, j4, (byte) (j3 >>> 35));
            byte[] bArr2 = this.f36006f;
            long j5 = this.f36011k;
            this.f36011k = j5 - 1;
            UnsafeUtil.R(bArr2, j5, (byte) (((j3 >>> 28) & 127) | 128));
            byte[] bArr3 = this.f36006f;
            long j6 = this.f36011k;
            this.f36011k = j6 - 1;
            UnsafeUtil.R(bArr3, j6, (byte) (((j3 >>> 21) & 127) | 128));
            byte[] bArr4 = this.f36006f;
            long j7 = this.f36011k;
            this.f36011k = j7 - 1;
            UnsafeUtil.R(bArr4, j7, (byte) (((j3 >>> 14) & 127) | 128));
            byte[] bArr5 = this.f36006f;
            long j8 = this.f36011k;
            this.f36011k = j8 - 1;
            UnsafeUtil.R(bArr5, j8, (byte) (((j3 >>> 7) & 127) | 128));
            byte[] bArr6 = this.f36006f;
            long j9 = this.f36011k;
            this.f36011k = j9 - 1;
            UnsafeUtil.R(bArr6, j9, (byte) ((j3 & 127) | 128));
        }

        private void b1(long j3) {
            byte[] bArr = this.f36006f;
            long j4 = this.f36011k;
            this.f36011k = j4 - 1;
            UnsafeUtil.R(bArr, j4, (byte) (j3 >>> 63));
            byte[] bArr2 = this.f36006f;
            long j5 = this.f36011k;
            this.f36011k = j5 - 1;
            UnsafeUtil.R(bArr2, j5, (byte) (((j3 >>> 56) & 127) | 128));
            byte[] bArr3 = this.f36006f;
            long j6 = this.f36011k;
            this.f36011k = j6 - 1;
            UnsafeUtil.R(bArr3, j6, (byte) (((j3 >>> 49) & 127) | 128));
            byte[] bArr4 = this.f36006f;
            long j7 = this.f36011k;
            this.f36011k = j7 - 1;
            UnsafeUtil.R(bArr4, j7, (byte) (((j3 >>> 42) & 127) | 128));
            byte[] bArr5 = this.f36006f;
            long j8 = this.f36011k;
            this.f36011k = j8 - 1;
            UnsafeUtil.R(bArr5, j8, (byte) (((j3 >>> 35) & 127) | 128));
            byte[] bArr6 = this.f36006f;
            long j9 = this.f36011k;
            this.f36011k = j9 - 1;
            UnsafeUtil.R(bArr6, j9, (byte) (((j3 >>> 28) & 127) | 128));
            byte[] bArr7 = this.f36006f;
            long j10 = this.f36011k;
            this.f36011k = j10 - 1;
            UnsafeUtil.R(bArr7, j10, (byte) (((j3 >>> 21) & 127) | 128));
            byte[] bArr8 = this.f36006f;
            long j11 = this.f36011k;
            this.f36011k = j11 - 1;
            UnsafeUtil.R(bArr8, j11, (byte) (((j3 >>> 14) & 127) | 128));
            byte[] bArr9 = this.f36006f;
            long j12 = this.f36011k;
            this.f36011k = j12 - 1;
            UnsafeUtil.R(bArr9, j12, (byte) (((j3 >>> 7) & 127) | 128));
            byte[] bArr10 = this.f36006f;
            long j13 = this.f36011k;
            this.f36011k = j13 - 1;
            UnsafeUtil.R(bArr10, j13, (byte) ((j3 & 127) | 128));
        }

        private void c1(long j3) {
            byte[] bArr = this.f36006f;
            long j4 = this.f36011k;
            this.f36011k = j4 - 1;
            UnsafeUtil.R(bArr, j4, (byte) (((int) j3) >>> 14));
            byte[] bArr2 = this.f36006f;
            long j5 = this.f36011k;
            this.f36011k = j5 - 1;
            UnsafeUtil.R(bArr2, j5, (byte) (((j3 >>> 7) & 127) | 128));
            byte[] bArr3 = this.f36006f;
            long j6 = this.f36011k;
            this.f36011k = j6 - 1;
            UnsafeUtil.R(bArr3, j6, (byte) ((j3 & 127) | 128));
        }

        private void d1(long j3) {
            byte[] bArr = this.f36006f;
            long j4 = this.f36011k;
            this.f36011k = j4 - 1;
            UnsafeUtil.R(bArr, j4, (byte) (j3 >>> 7));
            byte[] bArr2 = this.f36006f;
            long j5 = this.f36011k;
            this.f36011k = j5 - 1;
            UnsafeUtil.R(bArr2, j5, (byte) ((((int) j3) & 127) | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD));
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void D(int i3) {
            z0(i3, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void E0(int i3) {
            if ((i3 & (-128)) == 0) {
                R0(i3);
                return;
            }
            if ((i3 & (-16384)) == 0) {
                T0(i3);
                return;
            }
            if (((-2097152) & i3) == 0) {
                S0(i3);
            } else if (((-268435456) & i3) == 0) {
                Q0(i3);
            } else {
                P0(i3);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void F0(long j3) {
            switch (BinaryWriter.U(j3)) {
                case 1:
                    Y0(j3);
                    break;
                case 2:
                    d1(j3);
                    break;
                case 3:
                    c1(j3);
                    break;
                case 4:
                    W0(j3);
                    break;
                case 5:
                    V0(j3);
                    break;
                case 6:
                    a1(j3);
                    break;
                case 7:
                    Z0(j3);
                    break;
                case 8:
                    U0(j3);
                    break;
                case 9:
                    X0(j3);
                    break;
                case 10:
                    b1(j3);
                    break;
            }
        }

        int H0() {
            return (int) (this.f36010j - this.f36011k);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void I(int i3, int i4) {
            a0(10);
            t0(i4);
            z0(i3, 0);
        }

        void I0() {
            if (this.f36005e != null) {
                this.f35989d += H0();
                this.f36005e.h((G0() - this.f36005e.b()) + 1);
                this.f36005e = null;
                this.f36011k = 0L;
                this.f36010j = 0L;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void L(int i3, ByteString byteString) {
            try {
                byteString.T(this);
                a0(10);
                E0(byteString.size());
                z0(i3, 2);
            } catch (IOException e3) {
                throw new RuntimeException(e3);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void M(int i3, Object obj, Schema schema) {
            int iV = V();
            schema.h(obj, this);
            int iV2 = V() - iV;
            a0(10);
            E0(iV2);
            z0(i3, 2);
        }

        int M0() {
            return (int) (this.f36011k - this.f36009i);
        }

        public void N0(byte b3) {
            byte[] bArr = this.f36006f;
            long j3 = this.f36011k;
            this.f36011k = j3 - 1;
            UnsafeUtil.R(bArr, j3, b3);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void O(int i3, Object obj, Schema schema) {
            z0(i3, 4);
            schema.h(obj, this);
            z0(i3, 3);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00b6  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void O0(java.lang.String r13) {
            /*
                Method dump skipped, instruction units count: 296
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.BinaryWriter.UnsafeHeapWriter.O0(java.lang.String):void");
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void Q(byte[] bArr, int i3, int i4) {
            if (i3 < 0 || i3 + i4 > bArr.length) {
                throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i3), Integer.valueOf(i4)));
            }
            a0(i4);
            this.f36011k -= (long) i4;
            System.arraycopy(bArr, i3, this.f36006f, G0() + 1, i4);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void R(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (M0() < iRemaining) {
                this.f35989d += iRemaining;
                this.f35988c.addFirst(AllocatedBuffer.i(byteBuffer));
                J0();
            }
            this.f36011k -= (long) iRemaining;
            byteBuffer.get(this.f36006f, G0() + 1, iRemaining);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public void S(byte[] bArr, int i3, int i4) {
            if (i3 < 0 || i3 + i4 > bArr.length) {
                throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i3), Integer.valueOf(i4)));
            }
            if (M0() >= i4) {
                this.f36011k -= (long) i4;
                System.arraycopy(bArr, i3, this.f36006f, G0() + 1, i4);
            } else {
                this.f35989d += i4;
                this.f35988c.addFirst(AllocatedBuffer.k(bArr, i3, i4));
                J0();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public int V() {
            return this.f35989d + H0();
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void a0(int i3) {
            if (M0() < i3) {
                K0(i3);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void b0(boolean z2) {
            N0(z2 ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void c(int i3, int i4) {
            a0(9);
            g0(i4);
            z0(i3, 5);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void e(int i3, String str) {
            int iV = V();
            O0(str);
            int iV2 = V() - iV;
            a0(10);
            E0(iV2);
            z0(i3, 2);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void f(int i3, long j3) {
            a0(15);
            F0(j3);
            z0(i3, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void g0(int i3) {
            byte[] bArr = this.f36006f;
            long j3 = this.f36011k;
            this.f36011k = j3 - 1;
            UnsafeUtil.R(bArr, j3, (byte) ((i3 >> 24) & 255));
            byte[] bArr2 = this.f36006f;
            long j4 = this.f36011k;
            this.f36011k = j4 - 1;
            UnsafeUtil.R(bArr2, j4, (byte) ((i3 >> 16) & 255));
            byte[] bArr3 = this.f36006f;
            long j5 = this.f36011k;
            this.f36011k = j5 - 1;
            UnsafeUtil.R(bArr3, j5, (byte) ((i3 >> 8) & 255));
            byte[] bArr4 = this.f36006f;
            long j6 = this.f36011k;
            this.f36011k = j6 - 1;
            UnsafeUtil.R(bArr4, j6, (byte) (i3 & 255));
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void h(int i3, int i4) {
            a0(15);
            o0(i4);
            z0(i3, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void j0(long j3) {
            byte[] bArr = this.f36006f;
            long j4 = this.f36011k;
            this.f36011k = j4 - 1;
            UnsafeUtil.R(bArr, j4, (byte) (((int) (j3 >> 56)) & 255));
            byte[] bArr2 = this.f36006f;
            long j5 = this.f36011k;
            this.f36011k = j5 - 1;
            UnsafeUtil.R(bArr2, j5, (byte) (((int) (j3 >> 48)) & 255));
            byte[] bArr3 = this.f36006f;
            long j6 = this.f36011k;
            this.f36011k = j6 - 1;
            UnsafeUtil.R(bArr3, j6, (byte) (((int) (j3 >> 40)) & 255));
            byte[] bArr4 = this.f36006f;
            long j7 = this.f36011k;
            this.f36011k = j7 - 1;
            UnsafeUtil.R(bArr4, j7, (byte) (((int) (j3 >> 32)) & 255));
            byte[] bArr5 = this.f36006f;
            long j8 = this.f36011k;
            this.f36011k = j8 - 1;
            UnsafeUtil.R(bArr5, j8, (byte) (((int) (j3 >> 24)) & 255));
            byte[] bArr6 = this.f36006f;
            long j9 = this.f36011k;
            this.f36011k = j9 - 1;
            UnsafeUtil.R(bArr6, j9, (byte) (((int) (j3 >> 16)) & 255));
            byte[] bArr7 = this.f36006f;
            long j10 = this.f36011k;
            this.f36011k = j10 - 1;
            UnsafeUtil.R(bArr7, j10, (byte) (((int) (j3 >> 8)) & 255));
            byte[] bArr8 = this.f36006f;
            long j11 = this.f36011k;
            this.f36011k = j11 - 1;
            UnsafeUtil.R(bArr8, j11, (byte) (((int) j3) & 255));
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void m(int i3, long j3) {
            a0(15);
            w0(j3);
            z0(i3, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void o(int i3, int i4) {
            a0(10);
            E0(i4);
            z0(i3, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void o0(int i3) {
            if (i3 >= 0) {
                E0(i3);
            } else {
                F0(i3);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void s(int i3, long j3) {
            a0(13);
            j0(j3);
            z0(i3, 1);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void t0(int i3) {
            E0(CodedOutputStream.R0(i3));
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void u(int i3, Object obj) {
            int iV = V();
            Protobuf.a().e(obj, this);
            int iV2 = V() - iV;
            a0(10);
            E0(iV2);
            z0(i3, 2);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void w(int i3, boolean z2) {
            a0(6);
            N0(z2 ? (byte) 1 : (byte) 0);
            z0(i3, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void w0(long j3) {
            F0(CodedOutputStream.S0(j3));
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public void y(int i3) {
            z0(i3, 3);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        void z0(int i3, int i4) {
            E0(WireFormat.c(i3, i4));
        }
    }

    private void A0(int i3, IntArrayList intArrayList, boolean z2) {
        if (!z2) {
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                o(i3, intArrayList.getInt(size));
            }
            return;
        }
        a0((intArrayList.size() * 5) + 10);
        int iV = V();
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            E0(intArrayList.getInt(size2));
        }
        E0(V() - iV);
        z0(i3, 2);
    }

    private void B0(int i3, List list, boolean z2) {
        if (!z2) {
            for (int size = list.size() - 1; size >= 0; size--) {
                o(i3, ((Integer) list.get(size)).intValue());
            }
            return;
        }
        a0((list.size() * 5) + 10);
        int iV = V();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            E0(((Integer) list.get(size2)).intValue());
        }
        E0(V() - iV);
        z0(i3, 2);
    }

    private void C0(int i3, LongArrayList longArrayList, boolean z2) {
        if (!z2) {
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                f(i3, longArrayList.l(size));
            }
            return;
        }
        a0((longArrayList.size() * 10) + 10);
        int iV = V();
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            F0(longArrayList.l(size2));
        }
        E0(V() - iV);
        z0(i3, 2);
    }

    private void D0(int i3, List list, boolean z2) {
        if (!z2) {
            for (int size = list.size() - 1; size >= 0; size--) {
                f(i3, ((Long) list.get(size)).longValue());
            }
            return;
        }
        a0((list.size() * 10) + 10);
        int iV = V();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            F0(((Long) list.get(size2)).longValue());
        }
        E0(V() - iV);
        z0(i3, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte U(long j3) {
        byte b3;
        if (((-128) & j3) == 0) {
            return (byte) 1;
        }
        if (j3 < 0) {
            return (byte) 10;
        }
        if (((-34359738368L) & j3) != 0) {
            b3 = (byte) 6;
            j3 >>>= 28;
        } else {
            b3 = 2;
        }
        if (((-2097152) & j3) != 0) {
            b3 = (byte) (b3 + 2);
            j3 >>>= 14;
        }
        return (j3 & (-16384)) != 0 ? (byte) (b3 + 1) : b3;
    }

    private void c0(int i3, BooleanArrayList booleanArrayList, boolean z2) {
        if (!z2) {
            for (int size = booleanArrayList.size() - 1; size >= 0; size--) {
                w(i3, booleanArrayList.l(size));
            }
            return;
        }
        a0(booleanArrayList.size() + 10);
        int iV = V();
        for (int size2 = booleanArrayList.size() - 1; size2 >= 0; size2--) {
            b0(booleanArrayList.l(size2));
        }
        E0(V() - iV);
        z0(i3, 2);
    }

    private void d0(int i3, List list, boolean z2) {
        if (!z2) {
            for (int size = list.size() - 1; size >= 0; size--) {
                w(i3, ((Boolean) list.get(size)).booleanValue());
            }
            return;
        }
        a0(list.size() + 10);
        int iV = V();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            b0(((Boolean) list.get(size2)).booleanValue());
        }
        E0(V() - iV);
        z0(i3, 2);
    }

    private void e0(int i3, DoubleArrayList doubleArrayList, boolean z2) {
        if (!z2) {
            for (int size = doubleArrayList.size() - 1; size >= 0; size--) {
                p(i3, doubleArrayList.l(size));
            }
            return;
        }
        a0((doubleArrayList.size() * 8) + 10);
        int iV = V();
        for (int size2 = doubleArrayList.size() - 1; size2 >= 0; size2--) {
            j0(Double.doubleToRawLongBits(doubleArrayList.l(size2)));
        }
        E0(V() - iV);
        z0(i3, 2);
    }

    private void f0(int i3, List list, boolean z2) {
        if (!z2) {
            for (int size = list.size() - 1; size >= 0; size--) {
                p(i3, ((Double) list.get(size)).doubleValue());
            }
            return;
        }
        a0((list.size() * 8) + 10);
        int iV = V();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            j0(Double.doubleToRawLongBits(((Double) list.get(size2)).doubleValue()));
        }
        E0(V() - iV);
        z0(i3, 2);
    }

    private void h0(int i3, IntArrayList intArrayList, boolean z2) {
        if (!z2) {
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                c(i3, intArrayList.getInt(size));
            }
            return;
        }
        a0((intArrayList.size() * 4) + 10);
        int iV = V();
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            g0(intArrayList.getInt(size2));
        }
        E0(V() - iV);
        z0(i3, 2);
    }

    private void i0(int i3, List list, boolean z2) {
        if (!z2) {
            for (int size = list.size() - 1; size >= 0; size--) {
                c(i3, ((Integer) list.get(size)).intValue());
            }
            return;
        }
        a0((list.size() * 4) + 10);
        int iV = V();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            g0(((Integer) list.get(size2)).intValue());
        }
        E0(V() - iV);
        z0(i3, 2);
    }

    private void k0(int i3, LongArrayList longArrayList, boolean z2) {
        if (!z2) {
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                s(i3, longArrayList.l(size));
            }
            return;
        }
        a0((longArrayList.size() * 8) + 10);
        int iV = V();
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            j0(longArrayList.l(size2));
        }
        E0(V() - iV);
        z0(i3, 2);
    }

    private void l0(int i3, List list, boolean z2) {
        if (!z2) {
            for (int size = list.size() - 1; size >= 0; size--) {
                s(i3, ((Long) list.get(size)).longValue());
            }
            return;
        }
        a0((list.size() * 8) + 10);
        int iV = V();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            j0(((Long) list.get(size2)).longValue());
        }
        E0(V() - iV);
        z0(i3, 2);
    }

    private void m0(int i3, FloatArrayList floatArrayList, boolean z2) {
        if (!z2) {
            for (int size = floatArrayList.size() - 1; size >= 0; size--) {
                C(i3, floatArrayList.l(size));
            }
            return;
        }
        a0((floatArrayList.size() * 4) + 10);
        int iV = V();
        for (int size2 = floatArrayList.size() - 1; size2 >= 0; size2--) {
            g0(Float.floatToRawIntBits(floatArrayList.l(size2)));
        }
        E0(V() - iV);
        z0(i3, 2);
    }

    private void n0(int i3, List list, boolean z2) {
        if (!z2) {
            for (int size = list.size() - 1; size >= 0; size--) {
                C(i3, ((Float) list.get(size)).floatValue());
            }
            return;
        }
        a0((list.size() * 4) + 10);
        int iV = V();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            g0(Float.floatToRawIntBits(((Float) list.get(size2)).floatValue()));
        }
        E0(V() - iV);
        z0(i3, 2);
    }

    private void p0(int i3, IntArrayList intArrayList, boolean z2) {
        if (!z2) {
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                h(i3, intArrayList.getInt(size));
            }
            return;
        }
        a0((intArrayList.size() * 10) + 10);
        int iV = V();
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            o0(intArrayList.getInt(size2));
        }
        E0(V() - iV);
        z0(i3, 2);
    }

    private void q0(int i3, List list, boolean z2) {
        if (!z2) {
            for (int size = list.size() - 1; size >= 0; size--) {
                h(i3, ((Integer) list.get(size)).intValue());
            }
            return;
        }
        a0((list.size() * 10) + 10);
        int iV = V();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            o0(((Integer) list.get(size2)).intValue());
        }
        E0(V() - iV);
        z0(i3, 2);
    }

    private void r0(int i3, Object obj) {
        if (obj instanceof String) {
            e(i3, (String) obj);
        } else {
            L(i3, (ByteString) obj);
        }
    }

    static final void s0(Writer writer, int i3, WireFormat.FieldType fieldType, Object obj) {
        switch (AnonymousClass1.f35990a[fieldType.ordinal()]) {
            case 1:
                writer.w(i3, ((Boolean) obj).booleanValue());
                return;
            case 2:
                writer.c(i3, ((Integer) obj).intValue());
                return;
            case 3:
                writer.s(i3, ((Long) obj).longValue());
                return;
            case 4:
                writer.h(i3, ((Integer) obj).intValue());
                return;
            case 5:
                writer.v(i3, ((Long) obj).longValue());
                return;
            case 6:
                writer.x(i3, ((Integer) obj).intValue());
                return;
            case 7:
                writer.i(i3, ((Long) obj).longValue());
                return;
            case 8:
                writer.I(i3, ((Integer) obj).intValue());
                return;
            case 9:
                writer.m(i3, ((Long) obj).longValue());
                return;
            case 10:
                writer.e(i3, (String) obj);
                return;
            case 11:
                writer.o(i3, ((Integer) obj).intValue());
                return;
            case 12:
                writer.f(i3, ((Long) obj).longValue());
                return;
            case 13:
                writer.C(i3, ((Float) obj).floatValue());
                return;
            case 14:
                writer.p(i3, ((Double) obj).doubleValue());
                return;
            case 15:
                writer.u(i3, obj);
                return;
            case 16:
                writer.L(i3, (ByteString) obj);
                return;
            case 17:
                if (obj instanceof Internal.EnumLite) {
                    writer.F(i3, ((Internal.EnumLite) obj).J());
                    return;
                } else {
                    if (!(obj instanceof Integer)) {
                        throw new IllegalArgumentException("Unexpected type for enum in map.");
                    }
                    writer.F(i3, ((Integer) obj).intValue());
                    return;
                }
            default:
                throw new IllegalArgumentException("Unsupported map value type for: " + fieldType);
        }
    }

    private void u0(int i3, IntArrayList intArrayList, boolean z2) {
        if (!z2) {
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                I(i3, intArrayList.getInt(size));
            }
            return;
        }
        a0((intArrayList.size() * 5) + 10);
        int iV = V();
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            t0(intArrayList.getInt(size2));
        }
        E0(V() - iV);
        z0(i3, 2);
    }

    private void v0(int i3, List list, boolean z2) {
        if (!z2) {
            for (int size = list.size() - 1; size >= 0; size--) {
                I(i3, ((Integer) list.get(size)).intValue());
            }
            return;
        }
        a0((list.size() * 5) + 10);
        int iV = V();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            t0(((Integer) list.get(size2)).intValue());
        }
        E0(V() - iV);
        z0(i3, 2);
    }

    private void x0(int i3, LongArrayList longArrayList, boolean z2) {
        if (!z2) {
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                m(i3, longArrayList.l(size));
            }
            return;
        }
        a0((longArrayList.size() * 10) + 10);
        int iV = V();
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            w0(longArrayList.l(size2));
        }
        E0(V() - iV);
        z0(i3, 2);
    }

    private void y0(int i3, List list, boolean z2) {
        if (!z2) {
            for (int size = list.size() - 1; size >= 0; size--) {
                m(i3, ((Long) list.get(size)).longValue());
            }
            return;
        }
        a0((list.size() * 10) + 10);
        int iV = V();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            w0(((Long) list.get(size2)).longValue());
        }
        E0(V() - iV);
        z0(i3, 2);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void A(int i3, List list, boolean z2) {
        j(i3, list, z2);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void B(int i3, List list, boolean z2) {
        if (list instanceof BooleanArrayList) {
            c0(i3, (BooleanArrayList) list, z2);
        } else {
            d0(i3, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void C(int i3, float f3) {
        c(i3, Float.floatToRawIntBits(f3));
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void E(int i3, List list, boolean z2) {
        if (list instanceof IntArrayList) {
            u0(i3, (IntArrayList) list, z2);
        } else {
            v0(i3, list, z2);
        }
    }

    abstract void E0(int i3);

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void F(int i3, int i4) {
        h(i3, i4);
    }

    abstract void F0(long j3);

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void G(int i3, List list, boolean z2) {
        r(i3, list, z2);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void H(int i3, List list, boolean z2) {
        if (list instanceof DoubleArrayList) {
            e0(i3, (DoubleArrayList) list, z2);
        } else {
            f0(i3, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void J(int i3, List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            L(i3, (ByteString) list.get(size));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void K(int i3, List list, Schema schema) {
        for (int size = list.size() - 1; size >= 0; size--) {
            O(i3, list.get(size), schema);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void N(int i3, MapEntryLite.Metadata metadata, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            int iV = V();
            s0(this, 2, metadata.f36505c, entry.getValue());
            s0(this, 1, metadata.f36503a, entry.getKey());
            E0(V() - iV);
            z0(i3, 2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void P(int i3, List list, Schema schema) {
        for (int size = list.size() - 1; size >= 0; size--) {
            M(i3, list.get(size), schema);
        }
    }

    public abstract int V();

    final AllocatedBuffer W() {
        return this.f35986a.a(this.f35987b);
    }

    final AllocatedBuffer X(int i3) {
        return this.f35986a.a(Math.max(i3, this.f35987b));
    }

    final AllocatedBuffer Y() {
        return this.f35986a.b(this.f35987b);
    }

    final AllocatedBuffer Z(int i3) {
        return this.f35986a.b(Math.max(i3, this.f35987b));
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void a(int i3, List list, boolean z2) {
        if (list instanceof FloatArrayList) {
            m0(i3, (FloatArrayList) list, z2);
        } else {
            n0(i3, list, z2);
        }
    }

    abstract void a0(int i3);

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void b(int i3, Object obj) {
        z0(1, 4);
        if (obj instanceof ByteString) {
            L(3, (ByteString) obj);
        } else {
            u(3, obj);
        }
        o(2, i3);
        z0(1, 3);
    }

    abstract void b0(boolean z2);

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void d(int i3, List list) {
        if (!(list instanceof LazyStringList)) {
            for (int size = list.size() - 1; size >= 0; size--) {
                e(i3, (String) list.get(size));
            }
            return;
        }
        LazyStringList lazyStringList = (LazyStringList) list;
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            r0(i3, lazyStringList.r(size2));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void g(int i3, List list, boolean z2) {
        if (list instanceof IntArrayList) {
            p0(i3, (IntArrayList) list, z2);
        } else {
            q0(i3, list, z2);
        }
    }

    abstract void g0(int i3);

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void i(int i3, long j3) {
        s(i3, j3);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void j(int i3, List list, boolean z2) {
        if (list instanceof IntArrayList) {
            h0(i3, (IntArrayList) list, z2);
        } else {
            i0(i3, list, z2);
        }
    }

    abstract void j0(long j3);

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void k(int i3, List list, boolean z2) {
        if (list instanceof IntArrayList) {
            A0(i3, (IntArrayList) list, z2);
        } else {
            B0(i3, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void l(int i3, List list, boolean z2) {
        if (list instanceof LongArrayList) {
            x0(i3, (LongArrayList) list, z2);
        } else {
            y0(i3, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void n(int i3, List list, boolean z2) {
        g(i3, list, z2);
    }

    abstract void o0(int i3);

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void p(int i3, double d3) {
        s(i3, Double.doubleToRawLongBits(d3));
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void q(int i3, List list, boolean z2) {
        z(i3, list, z2);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void r(int i3, List list, boolean z2) {
        if (list instanceof LongArrayList) {
            C0(i3, (LongArrayList) list, z2);
        } else {
            D0(i3, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final Writer.FieldOrder t() {
        return Writer.FieldOrder.DESCENDING;
    }

    abstract void t0(int i3);

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void v(int i3, long j3) {
        f(i3, j3);
    }

    abstract void w0(long j3);

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void x(int i3, int i4) {
        c(i3, i4);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void z(int i3, List list, boolean z2) {
        if (list instanceof LongArrayList) {
            k0(i3, (LongArrayList) list, z2);
        } else {
            l0(i3, list, z2);
        }
    }

    abstract void z0(int i3, int i4);
}
