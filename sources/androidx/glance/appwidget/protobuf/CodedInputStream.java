package androidx.glance.appwidget.protobuf;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CodedInputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile int f38849f = 100;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f38850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f38851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f38852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    CodedInputStreamReader f38853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f38854e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ArrayDecoder extends CodedInputStream {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final byte[] f38855g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f38856h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f38857i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f38858j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f38859k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f38860l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f38861m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f38862n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f38863o;

        private void O() {
            int i3 = this.f38857i + this.f38858j;
            this.f38857i = i3;
            int i4 = i3 - this.f38860l;
            int i5 = this.f38863o;
            if (i4 <= i5) {
                this.f38858j = 0;
                return;
            }
            int i6 = i4 - i5;
            this.f38858j = i6;
            this.f38857i = i3 - i6;
        }

        private void R() throws InvalidProtocolBufferException {
            if (this.f38857i - this.f38859k >= 10) {
                S();
            } else {
                T();
            }
        }

        private void S() throws InvalidProtocolBufferException {
            for (int i3 = 0; i3 < 10; i3++) {
                byte[] bArr = this.f38855g;
                int i4 = this.f38859k;
                this.f38859k = i4 + 1;
                if (bArr[i4] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private void T() throws InvalidProtocolBufferException {
            for (int i3 = 0; i3 < 10; i3++) {
                if (H() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public long A() {
            return CodedInputStream.c(M());
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public String B() throws InvalidProtocolBufferException {
            int iL = L();
            if (iL > 0) {
                int i3 = this.f38857i;
                int i4 = this.f38859k;
                if (iL <= i3 - i4) {
                    String str = new String(this.f38855g, i4, iL, Internal.f39080b);
                    this.f38859k += iL;
                    return str;
                }
            }
            if (iL == 0) {
                return "";
            }
            if (iL < 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public String C() throws InvalidProtocolBufferException {
            int iL = L();
            if (iL > 0) {
                int i3 = this.f38857i;
                int i4 = this.f38859k;
                if (iL <= i3 - i4) {
                    String strH = Utf8.h(this.f38855g, i4, iL);
                    this.f38859k += iL;
                    return strH;
                }
            }
            if (iL == 0) {
                return "";
            }
            if (iL <= 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int D() throws InvalidProtocolBufferException {
            if (e()) {
                this.f38861m = 0;
                return 0;
            }
            int iL = L();
            this.f38861m = iL;
            if (WireFormat.a(iL) != 0) {
                return this.f38861m;
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int E() {
            return L();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public long F() {
            return M();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public boolean G(int i3) throws InvalidProtocolBufferException {
            int iB = WireFormat.b(i3);
            if (iB == 0) {
                R();
                return true;
            }
            if (iB == 1) {
                Q(8);
                return true;
            }
            if (iB == 2) {
                Q(L());
                return true;
            }
            if (iB == 3) {
                P();
                a(WireFormat.c(WireFormat.a(i3), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.e();
            }
            Q(4);
            return true;
        }

        public byte H() throws InvalidProtocolBufferException {
            int i3 = this.f38859k;
            if (i3 == this.f38857i) {
                throw InvalidProtocolBufferException.m();
            }
            byte[] bArr = this.f38855g;
            this.f38859k = i3 + 1;
            return bArr[i3];
        }

        public byte[] I(int i3) throws InvalidProtocolBufferException {
            if (i3 > 0) {
                int i4 = this.f38857i;
                int i5 = this.f38859k;
                if (i3 <= i4 - i5) {
                    int i6 = i3 + i5;
                    this.f38859k = i6;
                    return Arrays.copyOfRange(this.f38855g, i5, i6);
                }
            }
            if (i3 > 0) {
                throw InvalidProtocolBufferException.m();
            }
            if (i3 == 0) {
                return Internal.f39082d;
            }
            throw InvalidProtocolBufferException.g();
        }

        public int J() throws InvalidProtocolBufferException {
            int i3 = this.f38859k;
            if (this.f38857i - i3 < 4) {
                throw InvalidProtocolBufferException.m();
            }
            byte[] bArr = this.f38855g;
            this.f38859k = i3 + 4;
            return ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
        }

        public long K() throws InvalidProtocolBufferException {
            int i3 = this.f38859k;
            if (this.f38857i - i3 < 8) {
                throw InvalidProtocolBufferException.m();
            }
            byte[] bArr = this.f38855g;
            this.f38859k = i3 + 8;
            return ((((long) bArr[i3 + 7]) & 255) << 56) | (((long) bArr[i3]) & 255) | ((((long) bArr[i3 + 1]) & 255) << 8) | ((((long) bArr[i3 + 2]) & 255) << 16) | ((((long) bArr[i3 + 3]) & 255) << 24) | ((((long) bArr[i3 + 4]) & 255) << 32) | ((((long) bArr[i3 + 5]) & 255) << 40) | ((((long) bArr[i3 + 6]) & 255) << 48);
        }

        public int L() {
            int i3;
            int i4 = this.f38859k;
            int i5 = this.f38857i;
            if (i5 != i4) {
                byte[] bArr = this.f38855g;
                int i6 = i4 + 1;
                byte b3 = bArr[i4];
                if (b3 >= 0) {
                    this.f38859k = i6;
                    return b3;
                }
                if (i5 - i6 >= 9) {
                    int i7 = i4 + 2;
                    int i8 = (bArr[i6] << 7) ^ b3;
                    if (i8 < 0) {
                        i3 = i8 ^ (-128);
                    } else {
                        int i9 = i4 + 3;
                        int i10 = (bArr[i7] << Ascii.SO) ^ i8;
                        if (i10 >= 0) {
                            i3 = i10 ^ 16256;
                        } else {
                            int i11 = i4 + 4;
                            int i12 = i10 ^ (bArr[i9] << Ascii.NAK);
                            if (i12 < 0) {
                                i3 = (-2080896) ^ i12;
                            } else {
                                i9 = i4 + 5;
                                byte b4 = bArr[i11];
                                int i13 = (i12 ^ (b4 << Ascii.FS)) ^ 266354560;
                                if (b4 < 0) {
                                    i11 = i4 + 6;
                                    if (bArr[i9] < 0) {
                                        i9 = i4 + 7;
                                        if (bArr[i11] < 0) {
                                            i11 = i4 + 8;
                                            if (bArr[i9] < 0) {
                                                i9 = i4 + 9;
                                                if (bArr[i11] < 0) {
                                                    int i14 = i4 + 10;
                                                    if (bArr[i9] >= 0) {
                                                        i7 = i14;
                                                        i3 = i13;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i3 = i13;
                                }
                                i3 = i13;
                            }
                            i7 = i11;
                        }
                        i7 = i9;
                    }
                    this.f38859k = i7;
                    return i3;
                }
            }
            return (int) N();
        }

        public long M() {
            long j3;
            long j4;
            long j5;
            int i3 = this.f38859k;
            int i4 = this.f38857i;
            if (i4 != i3) {
                byte[] bArr = this.f38855g;
                int i5 = i3 + 1;
                byte b3 = bArr[i3];
                if (b3 >= 0) {
                    this.f38859k = i5;
                    return b3;
                }
                if (i4 - i5 >= 9) {
                    int i6 = i3 + 2;
                    int i7 = (bArr[i5] << 7) ^ b3;
                    if (i7 < 0) {
                        j3 = i7 ^ (-128);
                    } else {
                        int i8 = i3 + 3;
                        int i9 = (bArr[i6] << Ascii.SO) ^ i7;
                        if (i9 >= 0) {
                            j3 = i9 ^ 16256;
                            i6 = i8;
                        } else {
                            int i10 = i3 + 4;
                            int i11 = i9 ^ (bArr[i8] << Ascii.NAK);
                            if (i11 < 0) {
                                long j6 = (-2080896) ^ i11;
                                i6 = i10;
                                j3 = j6;
                            } else {
                                long j7 = i11;
                                i6 = i3 + 5;
                                long j8 = j7 ^ (((long) bArr[i10]) << 28);
                                if (j8 >= 0) {
                                    j5 = 266354560;
                                } else {
                                    int i12 = i3 + 6;
                                    long j9 = j8 ^ (((long) bArr[i6]) << 35);
                                    if (j9 < 0) {
                                        j4 = -34093383808L;
                                    } else {
                                        i6 = i3 + 7;
                                        j8 = j9 ^ (((long) bArr[i12]) << 42);
                                        if (j8 >= 0) {
                                            j5 = 4363953127296L;
                                        } else {
                                            i12 = i3 + 8;
                                            j9 = j8 ^ (((long) bArr[i6]) << 49);
                                            if (j9 < 0) {
                                                j4 = -558586000294016L;
                                            } else {
                                                i6 = i3 + 9;
                                                long j10 = (j9 ^ (((long) bArr[i12]) << 56)) ^ 71499008037633920L;
                                                if (j10 < 0) {
                                                    int i13 = i3 + 10;
                                                    if (bArr[i6] >= 0) {
                                                        i6 = i13;
                                                    }
                                                }
                                                j3 = j10;
                                            }
                                        }
                                    }
                                    j3 = j9 ^ j4;
                                    i6 = i12;
                                }
                                j3 = j8 ^ j5;
                            }
                        }
                    }
                    this.f38859k = i6;
                    return j3;
                }
            }
            return N();
        }

        long N() throws InvalidProtocolBufferException {
            long j3 = 0;
            for (int i3 = 0; i3 < 64; i3 += 7) {
                byte bH = H();
                j3 |= ((long) (bH & Ascii.DEL)) << i3;
                if ((bH & 128) == 0) {
                    return j3;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        public void P() throws InvalidProtocolBufferException {
            int iD;
            do {
                iD = D();
                if (iD == 0) {
                    return;
                }
            } while (G(iD));
        }

        public void Q(int i3) throws InvalidProtocolBufferException {
            if (i3 >= 0) {
                int i4 = this.f38857i;
                int i5 = this.f38859k;
                if (i3 <= i4 - i5) {
                    this.f38859k = i5 + i3;
                    return;
                }
            }
            if (i3 >= 0) {
                throw InvalidProtocolBufferException.m();
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public void a(int i3) throws InvalidProtocolBufferException {
            if (this.f38861m != i3) {
                throw InvalidProtocolBufferException.b();
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int d() {
            return this.f38859k - this.f38860l;
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public boolean e() {
            return this.f38859k == this.f38857i;
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public void m(int i3) {
            this.f38863o = i3;
            O();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int n(int i3) throws InvalidProtocolBufferException {
            if (i3 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            int iD = i3 + d();
            if (iD < 0) {
                throw InvalidProtocolBufferException.h();
            }
            int i4 = this.f38863o;
            if (iD > i4) {
                throw InvalidProtocolBufferException.m();
            }
            this.f38863o = iD;
            O();
            return i4;
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public boolean o() {
            return M() != 0;
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public ByteString p() {
            int iL = L();
            if (iL > 0) {
                int i3 = this.f38857i;
                int i4 = this.f38859k;
                if (iL <= i3 - i4) {
                    ByteString byteStringR = (this.f38856h && this.f38862n) ? ByteString.R(this.f38855g, i4, iL) : ByteString.q(this.f38855g, i4, iL);
                    this.f38859k += iL;
                    return byteStringR;
                }
            }
            return iL == 0 ? ByteString.f38830b : ByteString.Q(I(iL));
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public double q() {
            return Double.longBitsToDouble(K());
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int r() {
            return L();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int s() {
            return J();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public long t() {
            return K();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public float u() {
            return Float.intBitsToFloat(J());
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int v() {
            return L();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public long w() {
            return M();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int x() {
            return J();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public long y() {
            return K();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int z() {
            return CodedInputStream.b(L());
        }

        private ArrayDecoder(byte[] bArr, int i3, int i4, boolean z2) {
            super();
            this.f38863o = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f38855g = bArr;
            this.f38857i = i4 + i3;
            this.f38859k = i3;
            this.f38860l = i3;
            this.f38856h = z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class IterableDirectByteBufferDecoder extends CodedInputStream {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Iterable f38864g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Iterator f38865h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private ByteBuffer f38866i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final boolean f38867j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f38868k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f38869l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f38870m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f38871n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f38872o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f38873p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f38874q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private long f38875r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private long f38876s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private long f38877t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private long f38878u;

        private long H() {
            return this.f38878u - this.f38875r;
        }

        private void I() throws InvalidProtocolBufferException {
            if (!this.f38865h.hasNext()) {
                throw InvalidProtocolBufferException.m();
            }
            W();
        }

        private void K(byte[] bArr, int i3, int i4) throws InvalidProtocolBufferException {
            if (i4 < 0 || i4 > R()) {
                if (i4 > 0) {
                    throw InvalidProtocolBufferException.m();
                }
                if (i4 != 0) {
                    throw InvalidProtocolBufferException.g();
                }
                return;
            }
            int i5 = i4;
            while (i5 > 0) {
                if (H() == 0) {
                    I();
                }
                int iMin = Math.min(i5, (int) H());
                long j3 = iMin;
                UnsafeUtil.p(this.f38875r, bArr, (i4 - i5) + i3, j3);
                i5 -= iMin;
                this.f38875r += j3;
            }
        }

        private void Q() {
            int i3 = this.f38869l + this.f38870m;
            this.f38869l = i3;
            int i4 = i3 - this.f38874q;
            int i5 = this.f38871n;
            if (i4 <= i5) {
                this.f38870m = 0;
                return;
            }
            int i6 = i4 - i5;
            this.f38870m = i6;
            this.f38869l = i3 - i6;
        }

        private int R() {
            return (int) ((((long) (this.f38869l - this.f38873p)) - this.f38875r) + this.f38876s);
        }

        private void U() throws InvalidProtocolBufferException {
            for (int i3 = 0; i3 < 10; i3++) {
                if (J() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private ByteBuffer V(int i3, int i4) {
            int iPosition = this.f38866i.position();
            int iLimit = this.f38866i.limit();
            ByteBuffer byteBuffer = this.f38866i;
            try {
                try {
                    byteBuffer.position(i3);
                    byteBuffer.limit(i4);
                    return this.f38866i.slice();
                } catch (IllegalArgumentException unused) {
                    throw InvalidProtocolBufferException.m();
                }
            } finally {
                byteBuffer.position(iPosition);
                byteBuffer.limit(iLimit);
            }
        }

        private void W() {
            ByteBuffer byteBuffer = (ByteBuffer) this.f38865h.next();
            this.f38866i = byteBuffer;
            this.f38873p += (int) (this.f38875r - this.f38876s);
            long jPosition = byteBuffer.position();
            this.f38875r = jPosition;
            this.f38876s = jPosition;
            this.f38878u = this.f38866i.limit();
            long jK = UnsafeUtil.k(this.f38866i);
            this.f38877t = jK;
            this.f38875r += jK;
            this.f38876s += jK;
            this.f38878u += jK;
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public long A() {
            return CodedInputStream.c(O());
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public String B() throws InvalidProtocolBufferException {
            int iN = N();
            if (iN > 0) {
                long j3 = iN;
                long j4 = this.f38878u;
                long j5 = this.f38875r;
                if (j3 <= j4 - j5) {
                    byte[] bArr = new byte[iN];
                    UnsafeUtil.p(j5, bArr, 0L, j3);
                    String str = new String(bArr, Internal.f39080b);
                    this.f38875r += j3;
                    return str;
                }
            }
            if (iN > 0 && iN <= R()) {
                byte[] bArr2 = new byte[iN];
                K(bArr2, 0, iN);
                return new String(bArr2, Internal.f39080b);
            }
            if (iN == 0) {
                return "";
            }
            if (iN < 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public String C() throws InvalidProtocolBufferException {
            int iN = N();
            if (iN > 0) {
                long j3 = iN;
                long j4 = this.f38878u;
                long j5 = this.f38875r;
                if (j3 <= j4 - j5) {
                    String strG = Utf8.g(this.f38866i, (int) (j5 - this.f38876s), iN);
                    this.f38875r += j3;
                    return strG;
                }
            }
            if (iN >= 0 && iN <= R()) {
                byte[] bArr = new byte[iN];
                K(bArr, 0, iN);
                return Utf8.h(bArr, 0, iN);
            }
            if (iN == 0) {
                return "";
            }
            if (iN <= 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int D() throws InvalidProtocolBufferException {
            if (e()) {
                this.f38872o = 0;
                return 0;
            }
            int iN = N();
            this.f38872o = iN;
            if (WireFormat.a(iN) != 0) {
                return this.f38872o;
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int E() {
            return N();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public long F() {
            return O();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public boolean G(int i3) throws InvalidProtocolBufferException {
            int iB = WireFormat.b(i3);
            if (iB == 0) {
                U();
                return true;
            }
            if (iB == 1) {
                T(8);
                return true;
            }
            if (iB == 2) {
                T(N());
                return true;
            }
            if (iB == 3) {
                S();
                a(WireFormat.c(WireFormat.a(i3), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.e();
            }
            T(4);
            return true;
        }

        public byte J() throws InvalidProtocolBufferException {
            if (H() == 0) {
                I();
            }
            long j3 = this.f38875r;
            this.f38875r = 1 + j3;
            return UnsafeUtil.x(j3);
        }

        public int L() {
            if (H() < 4) {
                return (J() & 255) | ((J() & 255) << 8) | ((J() & 255) << 16) | ((J() & 255) << 24);
            }
            long j3 = this.f38875r;
            this.f38875r = 4 + j3;
            return ((UnsafeUtil.x(j3 + 3) & 255) << 24) | (UnsafeUtil.x(j3) & 255) | ((UnsafeUtil.x(1 + j3) & 255) << 8) | ((UnsafeUtil.x(2 + j3) & 255) << 16);
        }

        public long M() throws InvalidProtocolBufferException {
            char c3;
            long J;
            byte bJ;
            if (H() >= 8) {
                long j3 = this.f38875r;
                this.f38875r = 8 + j3;
                c3 = '8';
                J = (((long) UnsafeUtil.x(j3)) & 255) | ((((long) UnsafeUtil.x(1 + j3)) & 255) << 8) | ((((long) UnsafeUtil.x(2 + j3)) & 255) << 16) | ((((long) UnsafeUtil.x(3 + j3)) & 255) << 24) | ((((long) UnsafeUtil.x(4 + j3)) & 255) << 32) | ((((long) UnsafeUtil.x(5 + j3)) & 255) << 40) | ((((long) UnsafeUtil.x(6 + j3)) & 255) << 48);
                bJ = UnsafeUtil.x(j3 + 7);
            } else {
                c3 = '8';
                J = (((long) J()) & 255) | ((((long) J()) & 255) << 8) | ((((long) J()) & 255) << 16) | ((((long) J()) & 255) << 24) | ((((long) J()) & 255) << 32) | ((((long) J()) & 255) << 40) | ((((long) J()) & 255) << 48);
                bJ = J();
            }
            return J | ((((long) bJ) & 255) << c3);
        }

        public int N() {
            int i3;
            long j3 = this.f38875r;
            if (this.f38878u != j3) {
                long j4 = j3 + 1;
                byte bX = UnsafeUtil.x(j3);
                if (bX >= 0) {
                    this.f38875r++;
                    return bX;
                }
                if (this.f38878u - this.f38875r >= 10) {
                    long j5 = 2 + j3;
                    int iX = (UnsafeUtil.x(j4) << 7) ^ bX;
                    if (iX < 0) {
                        i3 = iX ^ (-128);
                    } else {
                        long j6 = 3 + j3;
                        int iX2 = (UnsafeUtil.x(j5) << Ascii.SO) ^ iX;
                        if (iX2 >= 0) {
                            i3 = iX2 ^ 16256;
                        } else {
                            long j7 = 4 + j3;
                            int iX3 = iX2 ^ (UnsafeUtil.x(j6) << Ascii.NAK);
                            if (iX3 < 0) {
                                i3 = (-2080896) ^ iX3;
                            } else {
                                j6 = 5 + j3;
                                byte bX2 = UnsafeUtil.x(j7);
                                int i4 = (iX3 ^ (bX2 << Ascii.FS)) ^ 266354560;
                                if (bX2 < 0) {
                                    j7 = 6 + j3;
                                    if (UnsafeUtil.x(j6) < 0) {
                                        j6 = 7 + j3;
                                        if (UnsafeUtil.x(j7) < 0) {
                                            j7 = 8 + j3;
                                            if (UnsafeUtil.x(j6) < 0) {
                                                j6 = 9 + j3;
                                                if (UnsafeUtil.x(j7) < 0) {
                                                    long j8 = j3 + 10;
                                                    if (UnsafeUtil.x(j6) >= 0) {
                                                        i3 = i4;
                                                        j5 = j8;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i3 = i4;
                                }
                                i3 = i4;
                            }
                            j5 = j7;
                        }
                        j5 = j6;
                    }
                    this.f38875r = j5;
                    return i3;
                }
            }
            return (int) P();
        }

        public long O() {
            long j3;
            long j4;
            long j5;
            long j6 = this.f38875r;
            if (this.f38878u != j6) {
                long j7 = j6 + 1;
                byte bX = UnsafeUtil.x(j6);
                if (bX >= 0) {
                    this.f38875r++;
                    return bX;
                }
                if (this.f38878u - this.f38875r >= 10) {
                    long j8 = 2 + j6;
                    int iX = (UnsafeUtil.x(j7) << 7) ^ bX;
                    if (iX < 0) {
                        j3 = iX ^ (-128);
                    } else {
                        long j9 = 3 + j6;
                        int iX2 = (UnsafeUtil.x(j8) << Ascii.SO) ^ iX;
                        if (iX2 >= 0) {
                            j3 = iX2 ^ 16256;
                            j8 = j9;
                        } else {
                            long j10 = 4 + j6;
                            int iX3 = iX2 ^ (UnsafeUtil.x(j9) << Ascii.NAK);
                            if (iX3 < 0) {
                                j3 = (-2080896) ^ iX3;
                                j8 = j10;
                            } else {
                                long j11 = 5 + j6;
                                long jX = (((long) UnsafeUtil.x(j10)) << 28) ^ ((long) iX3);
                                if (jX >= 0) {
                                    j5 = 266354560;
                                } else {
                                    long j12 = 6 + j6;
                                    long jX2 = jX ^ (((long) UnsafeUtil.x(j11)) << 35);
                                    if (jX2 < 0) {
                                        j4 = -34093383808L;
                                    } else {
                                        j11 = 7 + j6;
                                        jX = jX2 ^ (((long) UnsafeUtil.x(j12)) << 42);
                                        if (jX >= 0) {
                                            j5 = 4363953127296L;
                                        } else {
                                            j12 = 8 + j6;
                                            jX2 = jX ^ (((long) UnsafeUtil.x(j11)) << 49);
                                            if (jX2 < 0) {
                                                j4 = -558586000294016L;
                                            } else {
                                                j11 = 9 + j6;
                                                long jX3 = (jX2 ^ (((long) UnsafeUtil.x(j12)) << 56)) ^ 71499008037633920L;
                                                if (jX3 < 0) {
                                                    long j13 = j6 + 10;
                                                    if (UnsafeUtil.x(j11) >= 0) {
                                                        j8 = j13;
                                                        j3 = jX3;
                                                    }
                                                } else {
                                                    j3 = jX3;
                                                    j8 = j11;
                                                }
                                            }
                                        }
                                    }
                                    j3 = j4 ^ jX2;
                                    j8 = j12;
                                }
                                j3 = j5 ^ jX;
                                j8 = j11;
                            }
                        }
                    }
                    this.f38875r = j8;
                    return j3;
                }
            }
            return P();
        }

        long P() throws InvalidProtocolBufferException {
            long j3 = 0;
            for (int i3 = 0; i3 < 64; i3 += 7) {
                byte bJ = J();
                j3 |= ((long) (bJ & Ascii.DEL)) << i3;
                if ((bJ & 128) == 0) {
                    return j3;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        public void S() throws InvalidProtocolBufferException {
            int iD;
            do {
                iD = D();
                if (iD == 0) {
                    return;
                }
            } while (G(iD));
        }

        public void T(int i3) throws InvalidProtocolBufferException {
            if (i3 < 0 || i3 > (((long) (this.f38869l - this.f38873p)) - this.f38875r) + this.f38876s) {
                if (i3 >= 0) {
                    throw InvalidProtocolBufferException.m();
                }
                throw InvalidProtocolBufferException.g();
            }
            while (i3 > 0) {
                if (H() == 0) {
                    I();
                }
                int iMin = Math.min(i3, (int) H());
                i3 -= iMin;
                this.f38875r += (long) iMin;
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public void a(int i3) throws InvalidProtocolBufferException {
            if (this.f38872o != i3) {
                throw InvalidProtocolBufferException.b();
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int d() {
            return (int) ((((long) (this.f38873p - this.f38874q)) + this.f38875r) - this.f38876s);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public boolean e() {
            return (((long) this.f38873p) + this.f38875r) - this.f38876s == ((long) this.f38869l);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public void m(int i3) {
            this.f38871n = i3;
            Q();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int n(int i3) throws InvalidProtocolBufferException {
            if (i3 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            int iD = i3 + d();
            int i4 = this.f38871n;
            if (iD > i4) {
                throw InvalidProtocolBufferException.m();
            }
            this.f38871n = iD;
            Q();
            return i4;
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public boolean o() {
            return O() != 0;
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public ByteString p() throws InvalidProtocolBufferException {
            int iN = N();
            if (iN > 0) {
                long j3 = iN;
                long j4 = this.f38878u;
                long j5 = this.f38875r;
                if (j3 <= j4 - j5) {
                    if (this.f38867j && this.f38868k) {
                        int i3 = (int) (j5 - this.f38877t);
                        ByteString byteStringP = ByteString.P(V(i3, iN + i3));
                        this.f38875r += j3;
                        return byteStringP;
                    }
                    byte[] bArr = new byte[iN];
                    UnsafeUtil.p(j5, bArr, 0L, j3);
                    this.f38875r += j3;
                    return ByteString.Q(bArr);
                }
            }
            if (iN <= 0 || iN > R()) {
                if (iN == 0) {
                    return ByteString.f38830b;
                }
                if (iN < 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.m();
            }
            if (!this.f38867j || !this.f38868k) {
                byte[] bArr2 = new byte[iN];
                K(bArr2, 0, iN);
                return ByteString.Q(bArr2);
            }
            ArrayList arrayList = new ArrayList();
            while (iN > 0) {
                if (H() == 0) {
                    I();
                }
                int iMin = Math.min(iN, (int) H());
                int i4 = (int) (this.f38875r - this.f38877t);
                arrayList.add(ByteString.P(V(i4, i4 + iMin)));
                iN -= iMin;
                this.f38875r += (long) iMin;
            }
            return ByteString.l(arrayList);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public double q() {
            return Double.longBitsToDouble(M());
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int r() {
            return N();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int s() {
            return L();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public long t() {
            return M();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public float u() {
            return Float.intBitsToFloat(L());
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int v() {
            return N();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public long w() {
            return O();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int x() {
            return L();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public long y() {
            return M();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int z() {
            return CodedInputStream.b(N());
        }

        private IterableDirectByteBufferDecoder(Iterable iterable, int i3, boolean z2) {
            super();
            this.f38871n = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f38869l = i3;
            this.f38864g = iterable;
            this.f38865h = iterable.iterator();
            this.f38867j = z2;
            this.f38873p = 0;
            this.f38874q = 0;
            if (i3 != 0) {
                W();
                return;
            }
            this.f38866i = Internal.f39083e;
            this.f38875r = 0L;
            this.f38876s = 0L;
            this.f38878u = 0L;
            this.f38877t = 0L;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    private static final class StreamDecoder extends CodedInputStream {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final InputStream f38879g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final byte[] f38880h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f38881i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f38882j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f38883k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f38884l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f38885m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f38886n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private RefillCallback f38887o;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        /* JADX INFO: loaded from: classes3.dex */
        private interface RefillCallback {
            void a();
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        /* JADX INFO: loaded from: classes3.dex */
        private class SkippedDataSink implements RefillCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f38888a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private ByteArrayOutputStream f38889b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ StreamDecoder f38890c;

            @Override // androidx.glance.appwidget.protobuf.CodedInputStream.StreamDecoder.RefillCallback
            public void a() {
                if (this.f38889b == null) {
                    this.f38889b = new ByteArrayOutputStream();
                }
                this.f38889b.write(this.f38890c.f38880h, this.f38888a, this.f38890c.f38883k - this.f38888a);
                this.f38888a = 0;
            }
        }

        private static int J(InputStream inputStream) throws InvalidProtocolBufferException {
            try {
                return inputStream.available();
            } catch (InvalidProtocolBufferException e3) {
                e3.j();
                throw e3;
            }
        }

        private static int K(InputStream inputStream, byte[] bArr, int i3, int i4) throws InvalidProtocolBufferException {
            try {
                return inputStream.read(bArr, i3, i4);
            } catch (InvalidProtocolBufferException e3) {
                e3.j();
                throw e3;
            }
        }

        private ByteString L(int i3) throws IOException {
            byte[] bArrO = O(i3);
            if (bArrO != null) {
                return ByteString.p(bArrO);
            }
            int i4 = this.f38883k;
            int i5 = this.f38881i;
            int length = i5 - i4;
            this.f38885m += i5;
            this.f38883k = 0;
            this.f38881i = 0;
            List<byte[]> listP = P(i3 - length);
            byte[] bArr = new byte[i3];
            System.arraycopy(this.f38880h, i4, bArr, 0, length);
            for (byte[] bArr2 : listP) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return ByteString.Q(bArr);
        }

        private byte[] N(int i3, boolean z2) throws IOException {
            byte[] bArrO = O(i3);
            if (bArrO != null) {
                return z2 ? (byte[]) bArrO.clone() : bArrO;
            }
            int i4 = this.f38883k;
            int i5 = this.f38881i;
            int length = i5 - i4;
            this.f38885m += i5;
            this.f38883k = 0;
            this.f38881i = 0;
            List<byte[]> listP = P(i3 - length);
            byte[] bArr = new byte[i3];
            System.arraycopy(this.f38880h, i4, bArr, 0, length);
            for (byte[] bArr2 : listP) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return bArr;
        }

        private byte[] O(int i3) throws InvalidProtocolBufferException {
            if (i3 == 0) {
                return Internal.f39082d;
            }
            if (i3 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            int i4 = this.f38885m;
            int i5 = this.f38883k;
            int i6 = i4 + i5 + i3;
            if (i6 - this.f38852c > 0) {
                throw InvalidProtocolBufferException.l();
            }
            int i7 = this.f38886n;
            if (i6 > i7) {
                Z((i7 - i4) - i5);
                throw InvalidProtocolBufferException.m();
            }
            int i8 = this.f38881i - i5;
            int i9 = i3 - i8;
            if (i9 >= 4096 && i9 > J(this.f38879g)) {
                return null;
            }
            byte[] bArr = new byte[i3];
            System.arraycopy(this.f38880h, this.f38883k, bArr, 0, i8);
            this.f38885m += this.f38881i;
            this.f38883k = 0;
            this.f38881i = 0;
            while (i8 < i3) {
                int iK = K(this.f38879g, bArr, i8, i3 - i8);
                if (iK == -1) {
                    throw InvalidProtocolBufferException.m();
                }
                this.f38885m += iK;
                i8 += iK;
            }
            return bArr;
        }

        private List P(int i3) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i3 > 0) {
                int iMin = Math.min(i3, 4096);
                byte[] bArr = new byte[iMin];
                int i4 = 0;
                while (i4 < iMin) {
                    int i5 = this.f38879g.read(bArr, i4, iMin - i4);
                    if (i5 == -1) {
                        throw InvalidProtocolBufferException.m();
                    }
                    this.f38885m += i5;
                    i4 += i5;
                }
                i3 -= iMin;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private void V() {
            int i3 = this.f38881i + this.f38882j;
            this.f38881i = i3;
            int i4 = this.f38885m + i3;
            int i5 = this.f38886n;
            if (i4 <= i5) {
                this.f38882j = 0;
                return;
            }
            int i6 = i4 - i5;
            this.f38882j = i6;
            this.f38881i = i3 - i6;
        }

        private void W(int i3) throws InvalidProtocolBufferException {
            if (e0(i3)) {
                return;
            }
            if (i3 <= (this.f38852c - this.f38885m) - this.f38883k) {
                throw InvalidProtocolBufferException.m();
            }
            throw InvalidProtocolBufferException.l();
        }

        private static long X(InputStream inputStream, long j3) throws InvalidProtocolBufferException {
            try {
                return inputStream.skip(j3);
            } catch (InvalidProtocolBufferException e3) {
                e3.j();
                throw e3;
            }
        }

        private void a0(int i3) throws InvalidProtocolBufferException {
            if (i3 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            int i4 = this.f38885m;
            int i5 = this.f38883k;
            int i6 = i4 + i5 + i3;
            int i7 = this.f38886n;
            if (i6 > i7) {
                Z((i7 - i4) - i5);
                throw InvalidProtocolBufferException.m();
            }
            int i8 = 0;
            if (this.f38887o == null) {
                this.f38885m = i4 + i5;
                int i9 = this.f38881i - i5;
                this.f38881i = 0;
                this.f38883k = 0;
                i8 = i9;
                while (i8 < i3) {
                    try {
                        long j3 = i3 - i8;
                        long jX = X(this.f38879g, j3);
                        if (jX < 0 || jX > j3) {
                            throw new IllegalStateException(this.f38879g.getClass() + "#skip returned invalid result: " + jX + "\nThe InputStream implementation is buggy.");
                        }
                        if (jX == 0) {
                            break;
                        } else {
                            i8 += (int) jX;
                        }
                    } finally {
                        this.f38885m += i8;
                        V();
                    }
                }
            }
            if (i8 >= i3) {
                return;
            }
            int i10 = this.f38881i;
            int i11 = i10 - this.f38883k;
            this.f38883k = i10;
            W(1);
            while (true) {
                int i12 = i3 - i11;
                int i13 = this.f38881i;
                if (i12 <= i13) {
                    this.f38883k = i12;
                    return;
                } else {
                    i11 += i13;
                    this.f38883k = i13;
                    W(1);
                }
            }
        }

        private void b0() throws InvalidProtocolBufferException {
            if (this.f38881i - this.f38883k >= 10) {
                c0();
            } else {
                d0();
            }
        }

        private void c0() throws InvalidProtocolBufferException {
            for (int i3 = 0; i3 < 10; i3++) {
                byte[] bArr = this.f38880h;
                int i4 = this.f38883k;
                this.f38883k = i4 + 1;
                if (bArr[i4] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private void d0() throws InvalidProtocolBufferException {
            for (int i3 = 0; i3 < 10; i3++) {
                if (M() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private boolean e0(int i3) throws InvalidProtocolBufferException {
            int i4 = this.f38883k;
            if (i4 + i3 <= this.f38881i) {
                throw new IllegalStateException("refillBuffer() called when " + i3 + " bytes were already available in buffer");
            }
            int i5 = this.f38852c;
            int i6 = this.f38885m;
            if (i3 > (i5 - i6) - i4 || i6 + i4 + i3 > this.f38886n) {
                return false;
            }
            RefillCallback refillCallback = this.f38887o;
            if (refillCallback != null) {
                refillCallback.a();
            }
            int i7 = this.f38883k;
            if (i7 > 0) {
                int i8 = this.f38881i;
                if (i8 > i7) {
                    byte[] bArr = this.f38880h;
                    System.arraycopy(bArr, i7, bArr, 0, i8 - i7);
                }
                this.f38885m += i7;
                this.f38881i -= i7;
                this.f38883k = 0;
            }
            InputStream inputStream = this.f38879g;
            byte[] bArr2 = this.f38880h;
            int i9 = this.f38881i;
            int iK = K(inputStream, bArr2, i9, Math.min(bArr2.length - i9, (this.f38852c - this.f38885m) - i9));
            if (iK == 0 || iK < -1 || iK > this.f38880h.length) {
                throw new IllegalStateException(this.f38879g.getClass() + "#read(byte[]) returned invalid result: " + iK + "\nThe InputStream implementation is buggy.");
            }
            if (iK <= 0) {
                return false;
            }
            this.f38881i += iK;
            V();
            if (this.f38881i >= i3) {
                return true;
            }
            return e0(i3);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public long A() {
            return CodedInputStream.c(T());
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public String B() throws InvalidProtocolBufferException {
            int iS = S();
            if (iS > 0) {
                int i3 = this.f38881i;
                int i4 = this.f38883k;
                if (iS <= i3 - i4) {
                    String str = new String(this.f38880h, i4, iS, Internal.f39080b);
                    this.f38883k += iS;
                    return str;
                }
            }
            if (iS == 0) {
                return "";
            }
            if (iS > this.f38881i) {
                return new String(N(iS, false), Internal.f39080b);
            }
            W(iS);
            String str2 = new String(this.f38880h, this.f38883k, iS, Internal.f39080b);
            this.f38883k += iS;
            return str2;
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int D() throws InvalidProtocolBufferException {
            if (e()) {
                this.f38884l = 0;
                return 0;
            }
            int iS = S();
            this.f38884l = iS;
            if (WireFormat.a(iS) != 0) {
                return this.f38884l;
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int E() {
            return S();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public long F() {
            return T();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public boolean G(int i3) throws InvalidProtocolBufferException {
            int iB = WireFormat.b(i3);
            if (iB == 0) {
                b0();
                return true;
            }
            if (iB == 1) {
                Z(8);
                return true;
            }
            if (iB == 2) {
                Z(S());
                return true;
            }
            if (iB == 3) {
                Y();
                a(WireFormat.c(WireFormat.a(i3), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.e();
            }
            Z(4);
            return true;
        }

        public byte M() throws InvalidProtocolBufferException {
            if (this.f38883k == this.f38881i) {
                W(1);
            }
            byte[] bArr = this.f38880h;
            int i3 = this.f38883k;
            this.f38883k = i3 + 1;
            return bArr[i3];
        }

        public int Q() throws InvalidProtocolBufferException {
            int i3 = this.f38883k;
            if (this.f38881i - i3 < 4) {
                W(4);
                i3 = this.f38883k;
            }
            byte[] bArr = this.f38880h;
            this.f38883k = i3 + 4;
            return ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
        }

        public long R() throws InvalidProtocolBufferException {
            int i3 = this.f38883k;
            if (this.f38881i - i3 < 8) {
                W(8);
                i3 = this.f38883k;
            }
            byte[] bArr = this.f38880h;
            this.f38883k = i3 + 8;
            return ((((long) bArr[i3 + 7]) & 255) << 56) | (((long) bArr[i3]) & 255) | ((((long) bArr[i3 + 1]) & 255) << 8) | ((((long) bArr[i3 + 2]) & 255) << 16) | ((((long) bArr[i3 + 3]) & 255) << 24) | ((((long) bArr[i3 + 4]) & 255) << 32) | ((((long) bArr[i3 + 5]) & 255) << 40) | ((((long) bArr[i3 + 6]) & 255) << 48);
        }

        public int S() {
            int i3;
            int i4 = this.f38883k;
            int i5 = this.f38881i;
            if (i5 != i4) {
                byte[] bArr = this.f38880h;
                int i6 = i4 + 1;
                byte b3 = bArr[i4];
                if (b3 >= 0) {
                    this.f38883k = i6;
                    return b3;
                }
                if (i5 - i6 >= 9) {
                    int i7 = i4 + 2;
                    int i8 = (bArr[i6] << 7) ^ b3;
                    if (i8 < 0) {
                        i3 = i8 ^ (-128);
                    } else {
                        int i9 = i4 + 3;
                        int i10 = (bArr[i7] << Ascii.SO) ^ i8;
                        if (i10 >= 0) {
                            i3 = i10 ^ 16256;
                        } else {
                            int i11 = i4 + 4;
                            int i12 = i10 ^ (bArr[i9] << Ascii.NAK);
                            if (i12 < 0) {
                                i3 = (-2080896) ^ i12;
                            } else {
                                i9 = i4 + 5;
                                byte b4 = bArr[i11];
                                int i13 = (i12 ^ (b4 << Ascii.FS)) ^ 266354560;
                                if (b4 < 0) {
                                    i11 = i4 + 6;
                                    if (bArr[i9] < 0) {
                                        i9 = i4 + 7;
                                        if (bArr[i11] < 0) {
                                            i11 = i4 + 8;
                                            if (bArr[i9] < 0) {
                                                i9 = i4 + 9;
                                                if (bArr[i11] < 0) {
                                                    int i14 = i4 + 10;
                                                    if (bArr[i9] >= 0) {
                                                        i7 = i14;
                                                        i3 = i13;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i3 = i13;
                                }
                                i3 = i13;
                            }
                            i7 = i11;
                        }
                        i7 = i9;
                    }
                    this.f38883k = i7;
                    return i3;
                }
            }
            return (int) U();
        }

        public long T() {
            long j3;
            long j4;
            long j5;
            int i3 = this.f38883k;
            int i4 = this.f38881i;
            if (i4 != i3) {
                byte[] bArr = this.f38880h;
                int i5 = i3 + 1;
                byte b3 = bArr[i3];
                if (b3 >= 0) {
                    this.f38883k = i5;
                    return b3;
                }
                if (i4 - i5 >= 9) {
                    int i6 = i3 + 2;
                    int i7 = (bArr[i5] << 7) ^ b3;
                    if (i7 < 0) {
                        j3 = i7 ^ (-128);
                    } else {
                        int i8 = i3 + 3;
                        int i9 = (bArr[i6] << Ascii.SO) ^ i7;
                        if (i9 >= 0) {
                            j3 = i9 ^ 16256;
                            i6 = i8;
                        } else {
                            int i10 = i3 + 4;
                            int i11 = i9 ^ (bArr[i8] << Ascii.NAK);
                            if (i11 < 0) {
                                long j6 = (-2080896) ^ i11;
                                i6 = i10;
                                j3 = j6;
                            } else {
                                long j7 = i11;
                                i6 = i3 + 5;
                                long j8 = j7 ^ (((long) bArr[i10]) << 28);
                                if (j8 >= 0) {
                                    j5 = 266354560;
                                } else {
                                    int i12 = i3 + 6;
                                    long j9 = j8 ^ (((long) bArr[i6]) << 35);
                                    if (j9 < 0) {
                                        j4 = -34093383808L;
                                    } else {
                                        i6 = i3 + 7;
                                        j8 = j9 ^ (((long) bArr[i12]) << 42);
                                        if (j8 >= 0) {
                                            j5 = 4363953127296L;
                                        } else {
                                            i12 = i3 + 8;
                                            j9 = j8 ^ (((long) bArr[i6]) << 49);
                                            if (j9 < 0) {
                                                j4 = -558586000294016L;
                                            } else {
                                                i6 = i3 + 9;
                                                long j10 = (j9 ^ (((long) bArr[i12]) << 56)) ^ 71499008037633920L;
                                                if (j10 < 0) {
                                                    int i13 = i3 + 10;
                                                    if (bArr[i6] >= 0) {
                                                        i6 = i13;
                                                    }
                                                }
                                                j3 = j10;
                                            }
                                        }
                                    }
                                    j3 = j9 ^ j4;
                                    i6 = i12;
                                }
                                j3 = j8 ^ j5;
                            }
                        }
                    }
                    this.f38883k = i6;
                    return j3;
                }
            }
            return U();
        }

        long U() throws InvalidProtocolBufferException {
            long j3 = 0;
            for (int i3 = 0; i3 < 64; i3 += 7) {
                byte bM = M();
                j3 |= ((long) (bM & Ascii.DEL)) << i3;
                if ((bM & 128) == 0) {
                    return j3;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        public void Y() throws InvalidProtocolBufferException {
            int iD;
            do {
                iD = D();
                if (iD == 0) {
                    return;
                }
            } while (G(iD));
        }

        public void Z(int i3) throws InvalidProtocolBufferException {
            int i4 = this.f38881i;
            int i5 = this.f38883k;
            if (i3 > i4 - i5 || i3 < 0) {
                a0(i3);
            } else {
                this.f38883k = i5 + i3;
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public void a(int i3) throws InvalidProtocolBufferException {
            if (this.f38884l != i3) {
                throw InvalidProtocolBufferException.b();
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int d() {
            return this.f38885m + this.f38883k;
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public boolean e() {
            return this.f38883k == this.f38881i && !e0(1);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public void m(int i3) {
            this.f38886n = i3;
            V();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int n(int i3) throws InvalidProtocolBufferException {
            if (i3 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            int i4 = i3 + this.f38885m + this.f38883k;
            int i5 = this.f38886n;
            if (i4 > i5) {
                throw InvalidProtocolBufferException.m();
            }
            this.f38886n = i4;
            V();
            return i5;
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public boolean o() {
            return T() != 0;
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public ByteString p() {
            int iS = S();
            int i3 = this.f38881i;
            int i4 = this.f38883k;
            if (iS > i3 - i4 || iS <= 0) {
                return iS == 0 ? ByteString.f38830b : L(iS);
            }
            ByteString byteStringQ = ByteString.q(this.f38880h, i4, iS);
            this.f38883k += iS;
            return byteStringQ;
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public double q() {
            return Double.longBitsToDouble(R());
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int r() {
            return S();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int s() {
            return Q();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public long t() {
            return R();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public float u() {
            return Float.intBitsToFloat(Q());
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int v() {
            return S();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public long w() {
            return T();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int x() {
            return Q();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public long y() {
            return R();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int z() {
            return CodedInputStream.b(S());
        }

        private StreamDecoder(InputStream inputStream, int i3) {
            super();
            this.f38886n = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f38887o = null;
            Internal.b(inputStream, "input");
            this.f38879g = inputStream;
            this.f38880h = new byte[i3];
            this.f38881i = 0;
            this.f38883k = 0;
            this.f38885m = 0;
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public String C() throws IOException {
            byte[] bArrN;
            int iS = S();
            int i3 = this.f38883k;
            int i4 = this.f38881i;
            if (iS <= i4 - i3 && iS > 0) {
                bArrN = this.f38880h;
                this.f38883k = i3 + iS;
            } else {
                if (iS == 0) {
                    return KrzujOtzIk.OvgQrhYmgVadf;
                }
                i3 = 0;
                if (iS <= i4) {
                    W(iS);
                    bArrN = this.f38880h;
                    this.f38883k = iS;
                } else {
                    bArrN = N(iS, false);
                }
            }
            return Utf8.h(bArrN, i3, iS);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class UnsafeDirectNioDecoder extends CodedInputStream {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final ByteBuffer f38891g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f38892h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final long f38893i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f38894j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f38895k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f38896l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f38897m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f38898n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f38899o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f38900p;

        private int H(long j3) {
            return (int) (j3 - this.f38893i);
        }

        static boolean I() {
            return UnsafeUtil.K();
        }

        private void P() {
            long j3 = this.f38894j + ((long) this.f38897m);
            this.f38894j = j3;
            int i3 = (int) (j3 - this.f38896l);
            int i4 = this.f38900p;
            if (i3 <= i4) {
                this.f38897m = 0;
                return;
            }
            int i5 = i3 - i4;
            this.f38897m = i5;
            this.f38894j = j3 - ((long) i5);
        }

        private int Q() {
            return (int) (this.f38894j - this.f38895k);
        }

        private void T() throws InvalidProtocolBufferException {
            if (Q() >= 10) {
                U();
            } else {
                V();
            }
        }

        private void U() throws InvalidProtocolBufferException {
            for (int i3 = 0; i3 < 10; i3++) {
                long j3 = this.f38895k;
                this.f38895k = 1 + j3;
                if (UnsafeUtil.x(j3) >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private void V() throws InvalidProtocolBufferException {
            for (int i3 = 0; i3 < 10; i3++) {
                if (J() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private ByteBuffer W(long j3, long j4) {
            int iPosition = this.f38891g.position();
            int iLimit = this.f38891g.limit();
            ByteBuffer byteBuffer = this.f38891g;
            try {
                try {
                    byteBuffer.position(H(j3));
                    byteBuffer.limit(H(j4));
                    return this.f38891g.slice();
                } catch (IllegalArgumentException e3) {
                    InvalidProtocolBufferException invalidProtocolBufferExceptionM = InvalidProtocolBufferException.m();
                    invalidProtocolBufferExceptionM.initCause(e3);
                    throw invalidProtocolBufferExceptionM;
                }
            } finally {
                byteBuffer.position(iPosition);
                byteBuffer.limit(iLimit);
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public long A() {
            return CodedInputStream.c(N());
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public String B() throws InvalidProtocolBufferException {
            int iM = M();
            if (iM <= 0 || iM > Q()) {
                if (iM == 0) {
                    return "";
                }
                if (iM < 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.m();
            }
            byte[] bArr = new byte[iM];
            long j3 = iM;
            UnsafeUtil.p(this.f38895k, bArr, 0L, j3);
            String str = new String(bArr, Internal.f39080b);
            this.f38895k += j3;
            return str;
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public String C() throws InvalidProtocolBufferException {
            int iM = M();
            if (iM > 0 && iM <= Q()) {
                String strG = Utf8.g(this.f38891g, H(this.f38895k), iM);
                this.f38895k += (long) iM;
                return strG;
            }
            if (iM == 0) {
                return "";
            }
            if (iM <= 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int D() throws InvalidProtocolBufferException {
            if (e()) {
                this.f38898n = 0;
                return 0;
            }
            int iM = M();
            this.f38898n = iM;
            if (WireFormat.a(iM) != 0) {
                return this.f38898n;
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int E() {
            return M();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public long F() {
            return N();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public boolean G(int i3) throws InvalidProtocolBufferException {
            int iB = WireFormat.b(i3);
            if (iB == 0) {
                T();
                return true;
            }
            if (iB == 1) {
                S(8);
                return true;
            }
            if (iB == 2) {
                S(M());
                return true;
            }
            if (iB == 3) {
                R();
                a(WireFormat.c(WireFormat.a(i3), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.e();
            }
            S(4);
            return true;
        }

        public byte J() throws InvalidProtocolBufferException {
            long j3 = this.f38895k;
            if (j3 == this.f38894j) {
                throw InvalidProtocolBufferException.m();
            }
            this.f38895k = 1 + j3;
            return UnsafeUtil.x(j3);
        }

        public int K() throws InvalidProtocolBufferException {
            long j3 = this.f38895k;
            if (this.f38894j - j3 < 4) {
                throw InvalidProtocolBufferException.m();
            }
            this.f38895k = 4 + j3;
            return ((UnsafeUtil.x(j3 + 3) & 255) << 24) | (UnsafeUtil.x(j3) & 255) | ((UnsafeUtil.x(1 + j3) & 255) << 8) | ((UnsafeUtil.x(2 + j3) & 255) << 16);
        }

        public long L() throws InvalidProtocolBufferException {
            long j3 = this.f38895k;
            if (this.f38894j - j3 < 8) {
                throw InvalidProtocolBufferException.m();
            }
            this.f38895k = 8 + j3;
            return ((((long) UnsafeUtil.x(j3 + 7)) & 255) << 56) | (((long) UnsafeUtil.x(j3)) & 255) | ((((long) UnsafeUtil.x(1 + j3)) & 255) << 8) | ((((long) UnsafeUtil.x(2 + j3)) & 255) << 16) | ((((long) UnsafeUtil.x(3 + j3)) & 255) << 24) | ((((long) UnsafeUtil.x(4 + j3)) & 255) << 32) | ((((long) UnsafeUtil.x(5 + j3)) & 255) << 40) | ((((long) UnsafeUtil.x(6 + j3)) & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x008c, code lost:
        
            if (androidx.glance.appwidget.protobuf.UnsafeUtil.x(r3) < 0) goto L34;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int M() {
            /*
                r9 = this;
                long r0 = r9.f38895k
                long r2 = r9.f38894j
                int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r2 != 0) goto La
                goto L8e
            La:
                r2 = 1
                long r2 = r2 + r0
                byte r4 = androidx.glance.appwidget.protobuf.UnsafeUtil.x(r0)
                if (r4 < 0) goto L16
                r9.f38895k = r2
                return r4
            L16:
                long r5 = r9.f38894j
                long r5 = r5 - r2
                r7 = 9
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 >= 0) goto L21
                goto L8e
            L21:
                r5 = 2
                long r5 = r5 + r0
                byte r2 = androidx.glance.appwidget.protobuf.UnsafeUtil.x(r2)
                int r2 = r2 << 7
                r2 = r2 ^ r4
                if (r2 >= 0) goto L31
                r0 = r2 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L98
            L31:
                r3 = 3
                long r3 = r3 + r0
                byte r5 = androidx.glance.appwidget.protobuf.UnsafeUtil.x(r5)
                int r5 = r5 << 14
                r2 = r2 ^ r5
                if (r2 < 0) goto L41
                r0 = r2 ^ 16256(0x3f80, float:2.278E-41)
            L3f:
                r5 = r3
                goto L98
            L41:
                r5 = 4
                long r5 = r5 + r0
                byte r3 = androidx.glance.appwidget.protobuf.UnsafeUtil.x(r3)
                int r3 = r3 << 21
                r2 = r2 ^ r3
                if (r2 >= 0) goto L52
                r0 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L98
            L52:
                r3 = 5
                long r3 = r3 + r0
                byte r5 = androidx.glance.appwidget.protobuf.UnsafeUtil.x(r5)
                int r6 = r5 << 28
                r2 = r2 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r2 = r2 ^ r6
                if (r5 >= 0) goto L96
                r5 = 6
                long r5 = r5 + r0
                byte r3 = androidx.glance.appwidget.protobuf.UnsafeUtil.x(r3)
                if (r3 >= 0) goto L94
                r3 = 7
                long r3 = r3 + r0
                byte r5 = androidx.glance.appwidget.protobuf.UnsafeUtil.x(r5)
                if (r5 >= 0) goto L96
                r5 = 8
                long r5 = r5 + r0
                byte r3 = androidx.glance.appwidget.protobuf.UnsafeUtil.x(r3)
                if (r3 >= 0) goto L94
                long r3 = r0 + r7
                byte r5 = androidx.glance.appwidget.protobuf.UnsafeUtil.x(r5)
                if (r5 >= 0) goto L96
                r5 = 10
                long r5 = r5 + r0
                byte r0 = androidx.glance.appwidget.protobuf.UnsafeUtil.x(r3)
                if (r0 >= 0) goto L94
            L8e:
                long r0 = r9.O()
                int r0 = (int) r0
                return r0
            L94:
                r0 = r2
                goto L98
            L96:
                r0 = r2
                goto L3f
            L98:
                r9.f38895k = r5
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.protobuf.CodedInputStream.UnsafeDirectNioDecoder.M():int");
        }

        public long N() {
            long j3;
            long j4;
            long j5;
            int i3;
            long j6 = this.f38895k;
            if (this.f38894j != j6) {
                long j7 = 1 + j6;
                byte bX = UnsafeUtil.x(j6);
                if (bX >= 0) {
                    this.f38895k = j7;
                    return bX;
                }
                if (this.f38894j - j7 >= 9) {
                    long j8 = 2 + j6;
                    int iX = (UnsafeUtil.x(j7) << 7) ^ bX;
                    if (iX >= 0) {
                        long j9 = 3 + j6;
                        int iX2 = iX ^ (UnsafeUtil.x(j8) << Ascii.SO);
                        if (iX2 >= 0) {
                            j3 = iX2 ^ 16256;
                            j8 = j9;
                        } else {
                            j8 = 4 + j6;
                            int iX3 = iX2 ^ (UnsafeUtil.x(j9) << Ascii.NAK);
                            if (iX3 < 0) {
                                i3 = (-2080896) ^ iX3;
                            } else {
                                long j10 = 5 + j6;
                                long jX = ((long) iX3) ^ (((long) UnsafeUtil.x(j8)) << 28);
                                if (jX >= 0) {
                                    j5 = 266354560;
                                } else {
                                    long j11 = 6 + j6;
                                    long jX2 = jX ^ (((long) UnsafeUtil.x(j10)) << 35);
                                    if (jX2 < 0) {
                                        j4 = -34093383808L;
                                    } else {
                                        j10 = 7 + j6;
                                        jX = jX2 ^ (((long) UnsafeUtil.x(j11)) << 42);
                                        if (jX >= 0) {
                                            j5 = 4363953127296L;
                                        } else {
                                            j11 = 8 + j6;
                                            jX2 = jX ^ (((long) UnsafeUtil.x(j10)) << 49);
                                            if (jX2 < 0) {
                                                j4 = -558586000294016L;
                                            } else {
                                                long j12 = j6 + 9;
                                                long jX3 = (jX2 ^ (((long) UnsafeUtil.x(j11)) << 56)) ^ 71499008037633920L;
                                                if (jX3 < 0) {
                                                    long j13 = j6 + 10;
                                                    if (UnsafeUtil.x(j12) >= 0) {
                                                        j8 = j13;
                                                        j3 = jX3;
                                                    }
                                                } else {
                                                    j3 = jX3;
                                                    j8 = j12;
                                                }
                                            }
                                        }
                                    }
                                    j3 = j4 ^ jX2;
                                    j8 = j11;
                                }
                                j3 = j5 ^ jX;
                                j8 = j10;
                            }
                        }
                        this.f38895k = j8;
                        return j3;
                    }
                    i3 = iX ^ (-128);
                    j3 = i3;
                    this.f38895k = j8;
                    return j3;
                }
            }
            return O();
        }

        long O() throws InvalidProtocolBufferException {
            long j3 = 0;
            for (int i3 = 0; i3 < 64; i3 += 7) {
                byte bJ = J();
                j3 |= ((long) (bJ & Ascii.DEL)) << i3;
                if ((bJ & 128) == 0) {
                    return j3;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        public void R() throws InvalidProtocolBufferException {
            int iD;
            do {
                iD = D();
                if (iD == 0) {
                    return;
                }
            } while (G(iD));
        }

        public void S(int i3) throws InvalidProtocolBufferException {
            if (i3 >= 0 && i3 <= Q()) {
                this.f38895k += (long) i3;
            } else {
                if (i3 >= 0) {
                    throw InvalidProtocolBufferException.m();
                }
                throw InvalidProtocolBufferException.g();
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public void a(int i3) throws InvalidProtocolBufferException {
            if (this.f38898n != i3) {
                throw InvalidProtocolBufferException.b();
            }
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int d() {
            return (int) (this.f38895k - this.f38896l);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public boolean e() {
            return this.f38895k == this.f38894j;
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public void m(int i3) {
            this.f38900p = i3;
            P();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int n(int i3) throws InvalidProtocolBufferException {
            if (i3 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            int iD = i3 + d();
            int i4 = this.f38900p;
            if (iD > i4) {
                throw InvalidProtocolBufferException.m();
            }
            this.f38900p = iD;
            P();
            return i4;
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public boolean o() {
            return N() != 0;
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public ByteString p() throws InvalidProtocolBufferException {
            int iM = M();
            if (iM <= 0 || iM > Q()) {
                if (iM == 0) {
                    return ByteString.f38830b;
                }
                if (iM < 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.m();
            }
            if (this.f38892h && this.f38899o) {
                long j3 = this.f38895k;
                long j4 = iM;
                ByteBuffer byteBufferW = W(j3, j3 + j4);
                this.f38895k += j4;
                return ByteString.P(byteBufferW);
            }
            byte[] bArr = new byte[iM];
            long j5 = iM;
            UnsafeUtil.p(this.f38895k, bArr, 0L, j5);
            this.f38895k += j5;
            return ByteString.Q(bArr);
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public double q() {
            return Double.longBitsToDouble(L());
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int r() {
            return M();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int s() {
            return K();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public long t() {
            return L();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public float u() {
            return Float.intBitsToFloat(K());
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int v() {
            return M();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public long w() {
            return N();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int x() {
            return K();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public long y() {
            return L();
        }

        @Override // androidx.glance.appwidget.protobuf.CodedInputStream
        public int z() {
            return CodedInputStream.b(M());
        }

        private UnsafeDirectNioDecoder(ByteBuffer byteBuffer, boolean z2) {
            super();
            this.f38900p = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f38891g = byteBuffer;
            long jK = UnsafeUtil.k(byteBuffer);
            this.f38893i = jK;
            this.f38894j = ((long) byteBuffer.limit()) + jK;
            long jPosition = jK + ((long) byteBuffer.position());
            this.f38895k = jPosition;
            this.f38896l = jPosition;
            this.f38892h = z2;
        }
    }

    public static int b(int i3) {
        return (-(i3 & 1)) ^ (i3 >>> 1);
    }

    public static long c(long j3) {
        return (-(j3 & 1)) ^ (j3 >>> 1);
    }

    public static CodedInputStream f(InputStream inputStream) {
        return g(inputStream, 4096);
    }

    public static CodedInputStream g(InputStream inputStream, int i3) {
        if (i3 > 0) {
            return inputStream == null ? j(Internal.f39082d) : new StreamDecoder(inputStream, i3);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    static CodedInputStream h(Iterable iterable, boolean z2) {
        Iterator it = iterable.iterator();
        int i3 = 0;
        int iRemaining = 0;
        while (it.hasNext()) {
            ByteBuffer byteBuffer = (ByteBuffer) it.next();
            iRemaining += byteBuffer.remaining();
            i3 = byteBuffer.hasArray() ? i3 | 1 : byteBuffer.isDirect() ? i3 | 2 : i3 | 4;
        }
        return i3 == 2 ? new IterableDirectByteBufferDecoder(iterable, iRemaining, z2) : f(new IterableByteBufferInputStream(iterable));
    }

    static CodedInputStream i(ByteBuffer byteBuffer, boolean z2) {
        if (byteBuffer.hasArray()) {
            return l(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z2);
        }
        if (byteBuffer.isDirect() && UnsafeDirectNioDecoder.I()) {
            return new UnsafeDirectNioDecoder(byteBuffer, z2);
        }
        int iRemaining = byteBuffer.remaining();
        byte[] bArr = new byte[iRemaining];
        byteBuffer.duplicate().get(bArr);
        return l(bArr, 0, iRemaining, true);
    }

    public static CodedInputStream j(byte[] bArr) {
        return k(bArr, 0, bArr.length);
    }

    public static CodedInputStream k(byte[] bArr, int i3, int i4) {
        return l(bArr, i3, i4, false);
    }

    static CodedInputStream l(byte[] bArr, int i3, int i4, boolean z2) {
        ArrayDecoder arrayDecoder = new ArrayDecoder(bArr, i3, i4, z2);
        try {
            arrayDecoder.n(i4);
            return arrayDecoder;
        } catch (InvalidProtocolBufferException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    public abstract long A();

    public abstract String B();

    public abstract String C();

    public abstract int D();

    public abstract int E();

    public abstract long F();

    public abstract boolean G(int i3);

    public abstract void a(int i3);

    public abstract int d();

    public abstract boolean e();

    public abstract void m(int i3);

    public abstract int n(int i3);

    public abstract boolean o();

    public abstract ByteString p();

    public abstract double q();

    public abstract int r();

    public abstract int s();

    public abstract long t();

    public abstract float u();

    public abstract int v();

    public abstract long w();

    public abstract int x();

    public abstract long y();

    public abstract int z();

    private CodedInputStream() {
        this.f38851b = f38849f;
        this.f38852c = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f38854e = false;
    }
}
