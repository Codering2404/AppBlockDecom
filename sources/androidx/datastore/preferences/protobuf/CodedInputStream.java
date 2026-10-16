package androidx.datastore.preferences.protobuf;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
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
    private static volatile int f36041f = 100;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f36042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f36043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f36044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    CodedInputStreamReader f36045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f36046e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ArrayDecoder extends CodedInputStream {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final byte[] f36047g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f36048h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f36049i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f36050j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f36051k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f36052l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f36053m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f36054n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f36055o;

        private void Q() {
            int i3 = this.f36049i + this.f36050j;
            this.f36049i = i3;
            int i4 = i3 - this.f36052l;
            int i5 = this.f36055o;
            if (i4 <= i5) {
                this.f36050j = 0;
                return;
            }
            int i6 = i4 - i5;
            this.f36050j = i6;
            this.f36049i = i3 - i6;
        }

        private void S() throws InvalidProtocolBufferException {
            if (this.f36049i - this.f36051k >= 10) {
                T();
            } else {
                U();
            }
        }

        private void T() throws InvalidProtocolBufferException {
            for (int i3 = 0; i3 < 10; i3++) {
                byte[] bArr = this.f36047g;
                int i4 = this.f36051k;
                this.f36051k = i4 + 1;
                if (bArr[i4] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private void U() throws InvalidProtocolBufferException {
            for (int i3 = 0; i3 < 10; i3++) {
                if (J() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int A() {
            return CodedInputStream.c(N());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long B() {
            return CodedInputStream.d(O());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String C() throws InvalidProtocolBufferException {
            int iN = N();
            if (iN > 0) {
                int i3 = this.f36049i;
                int i4 = this.f36051k;
                if (iN <= i3 - i4) {
                    String str = new String(this.f36047g, i4, iN, Internal.f36424b);
                    this.f36051k += iN;
                    return str;
                }
            }
            if (iN == 0) {
                return "";
            }
            if (iN < 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String D() throws InvalidProtocolBufferException {
            int iN = N();
            if (iN > 0) {
                int i3 = this.f36049i;
                int i4 = this.f36051k;
                if (iN <= i3 - i4) {
                    String strH = Utf8.h(this.f36047g, i4, iN);
                    this.f36051k += iN;
                    return strH;
                }
            }
            if (iN == 0) {
                return "";
            }
            if (iN <= 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int E() throws InvalidProtocolBufferException {
            if (f()) {
                this.f36053m = 0;
                return 0;
            }
            int iN = N();
            this.f36053m = iN;
            if (WireFormat.a(iN) != 0) {
                return this.f36053m;
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int F() {
            return N();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long G() {
            return O();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean H(int i3) throws InvalidProtocolBufferException {
            int iB = WireFormat.b(i3);
            if (iB == 0) {
                S();
                return true;
            }
            if (iB == 1) {
                R(8);
                return true;
            }
            if (iB == 2) {
                R(N());
                return true;
            }
            if (iB == 3) {
                I();
                a(WireFormat.c(WireFormat.a(i3), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.e();
            }
            R(4);
            return true;
        }

        public byte J() throws InvalidProtocolBufferException {
            int i3 = this.f36051k;
            if (i3 == this.f36049i) {
                throw InvalidProtocolBufferException.m();
            }
            byte[] bArr = this.f36047g;
            this.f36051k = i3 + 1;
            return bArr[i3];
        }

        public byte[] K(int i3) throws InvalidProtocolBufferException {
            if (i3 > 0) {
                int i4 = this.f36049i;
                int i5 = this.f36051k;
                if (i3 <= i4 - i5) {
                    int i6 = i3 + i5;
                    this.f36051k = i6;
                    return Arrays.copyOfRange(this.f36047g, i5, i6);
                }
            }
            if (i3 > 0) {
                throw InvalidProtocolBufferException.m();
            }
            if (i3 == 0) {
                return Internal.f36426d;
            }
            throw InvalidProtocolBufferException.g();
        }

        public int L() throws InvalidProtocolBufferException {
            int i3 = this.f36051k;
            if (this.f36049i - i3 < 4) {
                throw InvalidProtocolBufferException.m();
            }
            byte[] bArr = this.f36047g;
            this.f36051k = i3 + 4;
            return ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
        }

        public long M() throws InvalidProtocolBufferException {
            int i3 = this.f36051k;
            if (this.f36049i - i3 < 8) {
                throw InvalidProtocolBufferException.m();
            }
            byte[] bArr = this.f36047g;
            this.f36051k = i3 + 8;
            return ((((long) bArr[i3 + 7]) & 255) << 56) | (((long) bArr[i3]) & 255) | ((((long) bArr[i3 + 1]) & 255) << 8) | ((((long) bArr[i3 + 2]) & 255) << 16) | ((((long) bArr[i3 + 3]) & 255) << 24) | ((((long) bArr[i3 + 4]) & 255) << 32) | ((((long) bArr[i3 + 5]) & 255) << 40) | ((((long) bArr[i3 + 6]) & 255) << 48);
        }

        public int N() {
            int i3;
            int i4 = this.f36051k;
            int i5 = this.f36049i;
            if (i5 != i4) {
                byte[] bArr = this.f36047g;
                int i6 = i4 + 1;
                byte b3 = bArr[i4];
                if (b3 >= 0) {
                    this.f36051k = i6;
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
                    this.f36051k = i7;
                    return i3;
                }
            }
            return (int) P();
        }

        public long O() {
            long j3;
            long j4;
            long j5;
            int i3 = this.f36051k;
            int i4 = this.f36049i;
            if (i4 != i3) {
                byte[] bArr = this.f36047g;
                int i5 = i3 + 1;
                byte b3 = bArr[i3];
                if (b3 >= 0) {
                    this.f36051k = i5;
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
                    this.f36051k = i6;
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

        public void R(int i3) throws InvalidProtocolBufferException {
            if (i3 >= 0) {
                int i4 = this.f36049i;
                int i5 = this.f36051k;
                if (i3 <= i4 - i5) {
                    this.f36051k = i5 + i3;
                    return;
                }
            }
            if (i3 >= 0) {
                throw InvalidProtocolBufferException.m();
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void a(int i3) throws InvalidProtocolBufferException {
            if (this.f36053m != i3) {
                throw InvalidProtocolBufferException.b();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int e() {
            return this.f36051k - this.f36052l;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean f() {
            return this.f36051k == this.f36049i;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void n(int i3) {
            this.f36055o = i3;
            Q();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int o(int i3) throws InvalidProtocolBufferException {
            if (i3 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            int iE = i3 + e();
            if (iE < 0) {
                throw InvalidProtocolBufferException.h();
            }
            int i4 = this.f36055o;
            if (iE > i4) {
                throw InvalidProtocolBufferException.m();
            }
            this.f36055o = iE;
            Q();
            return i4;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean p() {
            return O() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public ByteString q() {
            int iN = N();
            if (iN > 0) {
                int i3 = this.f36049i;
                int i4 = this.f36051k;
                if (iN <= i3 - i4) {
                    ByteString byteStringR = (this.f36048h && this.f36054n) ? ByteString.R(this.f36047g, i4, iN) : ByteString.q(this.f36047g, i4, iN);
                    this.f36051k += iN;
                    return byteStringR;
                }
            }
            return iN == 0 ? ByteString.f36020b : ByteString.Q(K(iN));
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public double r() {
            return Double.longBitsToDouble(M());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int s() {
            return N();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int t() {
            return L();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long u() {
            return M();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public float v() {
            return Float.intBitsToFloat(L());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int w() {
            return N();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long x() {
            return O();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int y() {
            return L();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long z() {
            return M();
        }

        private ArrayDecoder(byte[] bArr, int i3, int i4, boolean z2) {
            super();
            this.f36055o = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f36047g = bArr;
            this.f36049i = i4 + i3;
            this.f36051k = i3;
            this.f36052l = i3;
            this.f36048h = z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class IterableDirectByteBufferDecoder extends CodedInputStream {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Iterable f36056g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Iterator f36057h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private ByteBuffer f36058i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final boolean f36059j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f36060k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f36061l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f36062m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f36063n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f36064o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f36065p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f36066q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private long f36067r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private long f36068s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private long f36069t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private long f36070u;

        private long J() {
            return this.f36070u - this.f36067r;
        }

        private void K() throws InvalidProtocolBufferException {
            if (!this.f36057h.hasNext()) {
                throw InvalidProtocolBufferException.m();
            }
            X();
        }

        private void M(byte[] bArr, int i3, int i4) throws InvalidProtocolBufferException {
            if (i4 < 0 || i4 > T()) {
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
                if (J() == 0) {
                    K();
                }
                int iMin = Math.min(i5, (int) J());
                long j3 = iMin;
                UnsafeUtil.p(this.f36067r, bArr, (i4 - i5) + i3, j3);
                i5 -= iMin;
                this.f36067r += j3;
            }
        }

        private void S() {
            int i3 = this.f36061l + this.f36062m;
            this.f36061l = i3;
            int i4 = i3 - this.f36066q;
            int i5 = this.f36063n;
            if (i4 <= i5) {
                this.f36062m = 0;
                return;
            }
            int i6 = i4 - i5;
            this.f36062m = i6;
            this.f36061l = i3 - i6;
        }

        private int T() {
            return (int) ((((long) (this.f36061l - this.f36065p)) - this.f36067r) + this.f36068s);
        }

        private void V() throws InvalidProtocolBufferException {
            for (int i3 = 0; i3 < 10; i3++) {
                if (L() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private ByteBuffer W(int i3, int i4) {
            int iPosition = this.f36058i.position();
            int iLimit = this.f36058i.limit();
            ByteBuffer byteBuffer = this.f36058i;
            try {
                try {
                    byteBuffer.position(i3);
                    byteBuffer.limit(i4);
                    return this.f36058i.slice();
                } catch (IllegalArgumentException unused) {
                    throw InvalidProtocolBufferException.m();
                }
            } finally {
                byteBuffer.position(iPosition);
                byteBuffer.limit(iLimit);
            }
        }

        private void X() {
            ByteBuffer byteBuffer = (ByteBuffer) this.f36057h.next();
            this.f36058i = byteBuffer;
            this.f36065p += (int) (this.f36067r - this.f36068s);
            long jPosition = byteBuffer.position();
            this.f36067r = jPosition;
            this.f36068s = jPosition;
            this.f36070u = this.f36058i.limit();
            long jK = UnsafeUtil.k(this.f36058i);
            this.f36069t = jK;
            this.f36067r += jK;
            this.f36068s += jK;
            this.f36070u += jK;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int A() {
            return CodedInputStream.c(P());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long B() {
            return CodedInputStream.d(Q());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String C() throws InvalidProtocolBufferException {
            int iP = P();
            if (iP > 0) {
                long j3 = iP;
                long j4 = this.f36070u;
                long j5 = this.f36067r;
                if (j3 <= j4 - j5) {
                    byte[] bArr = new byte[iP];
                    UnsafeUtil.p(j5, bArr, 0L, j3);
                    String str = new String(bArr, Internal.f36424b);
                    this.f36067r += j3;
                    return str;
                }
            }
            if (iP > 0 && iP <= T()) {
                byte[] bArr2 = new byte[iP];
                M(bArr2, 0, iP);
                return new String(bArr2, Internal.f36424b);
            }
            if (iP == 0) {
                return "";
            }
            if (iP < 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String D() throws InvalidProtocolBufferException {
            int iP = P();
            if (iP > 0) {
                long j3 = iP;
                long j4 = this.f36070u;
                long j5 = this.f36067r;
                if (j3 <= j4 - j5) {
                    String strG = Utf8.g(this.f36058i, (int) (j5 - this.f36068s), iP);
                    this.f36067r += j3;
                    return strG;
                }
            }
            if (iP >= 0 && iP <= T()) {
                byte[] bArr = new byte[iP];
                M(bArr, 0, iP);
                return Utf8.h(bArr, 0, iP);
            }
            if (iP == 0) {
                return "";
            }
            if (iP <= 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int E() throws InvalidProtocolBufferException {
            if (f()) {
                this.f36064o = 0;
                return 0;
            }
            int iP = P();
            this.f36064o = iP;
            if (WireFormat.a(iP) != 0) {
                return this.f36064o;
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int F() {
            return P();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long G() {
            return Q();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean H(int i3) throws InvalidProtocolBufferException {
            int iB = WireFormat.b(i3);
            if (iB == 0) {
                V();
                return true;
            }
            if (iB == 1) {
                U(8);
                return true;
            }
            if (iB == 2) {
                U(P());
                return true;
            }
            if (iB == 3) {
                I();
                a(WireFormat.c(WireFormat.a(i3), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.e();
            }
            U(4);
            return true;
        }

        public byte L() throws InvalidProtocolBufferException {
            if (J() == 0) {
                K();
            }
            long j3 = this.f36067r;
            this.f36067r = 1 + j3;
            return UnsafeUtil.x(j3);
        }

        public int N() {
            if (J() < 4) {
                return (L() & 255) | ((L() & 255) << 8) | ((L() & 255) << 16) | ((L() & 255) << 24);
            }
            long j3 = this.f36067r;
            this.f36067r = 4 + j3;
            return ((UnsafeUtil.x(j3 + 3) & 255) << 24) | (UnsafeUtil.x(j3) & 255) | ((UnsafeUtil.x(1 + j3) & 255) << 8) | ((UnsafeUtil.x(2 + j3) & 255) << 16);
        }

        public long O() throws InvalidProtocolBufferException {
            char c3;
            long jL;
            byte bL;
            if (J() >= 8) {
                long j3 = this.f36067r;
                this.f36067r = 8 + j3;
                c3 = '8';
                jL = (((long) UnsafeUtil.x(j3)) & 255) | ((((long) UnsafeUtil.x(1 + j3)) & 255) << 8) | ((((long) UnsafeUtil.x(2 + j3)) & 255) << 16) | ((((long) UnsafeUtil.x(3 + j3)) & 255) << 24) | ((((long) UnsafeUtil.x(4 + j3)) & 255) << 32) | ((((long) UnsafeUtil.x(5 + j3)) & 255) << 40) | ((((long) UnsafeUtil.x(6 + j3)) & 255) << 48);
                bL = UnsafeUtil.x(j3 + 7);
            } else {
                c3 = '8';
                jL = (((long) L()) & 255) | ((((long) L()) & 255) << 8) | ((((long) L()) & 255) << 16) | ((((long) L()) & 255) << 24) | ((((long) L()) & 255) << 32) | ((((long) L()) & 255) << 40) | ((((long) L()) & 255) << 48);
                bL = L();
            }
            return jL | ((((long) bL) & 255) << c3);
        }

        public int P() {
            int i3;
            long j3 = this.f36067r;
            if (this.f36070u != j3) {
                long j4 = j3 + 1;
                byte bX = UnsafeUtil.x(j3);
                if (bX >= 0) {
                    this.f36067r++;
                    return bX;
                }
                if (this.f36070u - this.f36067r >= 10) {
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
                    this.f36067r = j5;
                    return i3;
                }
            }
            return (int) R();
        }

        public long Q() {
            long j3;
            long j4;
            long j5;
            long j6 = this.f36067r;
            if (this.f36070u != j6) {
                long j7 = j6 + 1;
                byte bX = UnsafeUtil.x(j6);
                if (bX >= 0) {
                    this.f36067r++;
                    return bX;
                }
                if (this.f36070u - this.f36067r >= 10) {
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
                    this.f36067r = j8;
                    return j3;
                }
            }
            return R();
        }

        long R() throws InvalidProtocolBufferException {
            long j3 = 0;
            for (int i3 = 0; i3 < 64; i3 += 7) {
                byte bL = L();
                j3 |= ((long) (bL & Ascii.DEL)) << i3;
                if ((bL & 128) == 0) {
                    return j3;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        public void U(int i3) throws InvalidProtocolBufferException {
            if (i3 < 0 || i3 > (((long) (this.f36061l - this.f36065p)) - this.f36067r) + this.f36068s) {
                if (i3 >= 0) {
                    throw InvalidProtocolBufferException.m();
                }
                throw InvalidProtocolBufferException.g();
            }
            while (i3 > 0) {
                if (J() == 0) {
                    K();
                }
                int iMin = Math.min(i3, (int) J());
                i3 -= iMin;
                this.f36067r += (long) iMin;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void a(int i3) throws InvalidProtocolBufferException {
            if (this.f36064o != i3) {
                throw InvalidProtocolBufferException.b();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int e() {
            return (int) ((((long) (this.f36065p - this.f36066q)) + this.f36067r) - this.f36068s);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean f() {
            return (((long) this.f36065p) + this.f36067r) - this.f36068s == ((long) this.f36061l);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void n(int i3) {
            this.f36063n = i3;
            S();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int o(int i3) throws InvalidProtocolBufferException {
            if (i3 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            int iE = i3 + e();
            int i4 = this.f36063n;
            if (iE > i4) {
                throw InvalidProtocolBufferException.m();
            }
            this.f36063n = iE;
            S();
            return i4;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean p() {
            return Q() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public ByteString q() throws InvalidProtocolBufferException {
            int iP = P();
            if (iP > 0) {
                long j3 = iP;
                long j4 = this.f36070u;
                long j5 = this.f36067r;
                if (j3 <= j4 - j5) {
                    if (this.f36059j && this.f36060k) {
                        int i3 = (int) (j5 - this.f36069t);
                        ByteString byteStringP = ByteString.P(W(i3, iP + i3));
                        this.f36067r += j3;
                        return byteStringP;
                    }
                    byte[] bArr = new byte[iP];
                    UnsafeUtil.p(j5, bArr, 0L, j3);
                    this.f36067r += j3;
                    return ByteString.Q(bArr);
                }
            }
            if (iP <= 0 || iP > T()) {
                if (iP == 0) {
                    return ByteString.f36020b;
                }
                if (iP < 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.m();
            }
            if (!this.f36059j || !this.f36060k) {
                byte[] bArr2 = new byte[iP];
                M(bArr2, 0, iP);
                return ByteString.Q(bArr2);
            }
            ArrayList arrayList = new ArrayList();
            while (iP > 0) {
                if (J() == 0) {
                    K();
                }
                int iMin = Math.min(iP, (int) J());
                int i4 = (int) (this.f36067r - this.f36069t);
                arrayList.add(ByteString.P(W(i4, i4 + iMin)));
                iP -= iMin;
                this.f36067r += (long) iMin;
            }
            return ByteString.l(arrayList);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public double r() {
            return Double.longBitsToDouble(O());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int s() {
            return P();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int t() {
            return N();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long u() {
            return O();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public float v() {
            return Float.intBitsToFloat(N());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int w() {
            return P();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long x() {
            return Q();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int y() {
            return N();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long z() {
            return O();
        }

        private IterableDirectByteBufferDecoder(Iterable iterable, int i3, boolean z2) {
            super();
            this.f36063n = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f36061l = i3;
            this.f36056g = iterable;
            this.f36057h = iterable.iterator();
            this.f36059j = z2;
            this.f36065p = 0;
            this.f36066q = 0;
            if (i3 != 0) {
                X();
                return;
            }
            this.f36058i = Internal.f36427e;
            this.f36067r = 0L;
            this.f36068s = 0L;
            this.f36070u = 0L;
            this.f36069t = 0L;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    private static final class StreamDecoder extends CodedInputStream {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final InputStream f36071g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final byte[] f36072h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f36073i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f36074j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f36075k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f36076l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f36077m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f36078n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private RefillCallback f36079o;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        /* JADX INFO: loaded from: classes3.dex */
        private interface RefillCallback {
            void a();
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        /* JADX INFO: loaded from: classes3.dex */
        private class SkippedDataSink implements RefillCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f36080a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private ByteArrayOutputStream f36081b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ StreamDecoder f36082c;

            @Override // androidx.datastore.preferences.protobuf.CodedInputStream.StreamDecoder.RefillCallback
            public void a() {
                if (this.f36081b == null) {
                    this.f36081b = new ByteArrayOutputStream();
                }
                this.f36081b.write(this.f36082c.f36072h, this.f36080a, this.f36082c.f36075k - this.f36080a);
                this.f36080a = 0;
            }
        }

        private static int L(InputStream inputStream) throws InvalidProtocolBufferException {
            try {
                return inputStream.available();
            } catch (InvalidProtocolBufferException e3) {
                e3.j();
                throw e3;
            }
        }

        private static int M(InputStream inputStream, byte[] bArr, int i3, int i4) throws InvalidProtocolBufferException {
            try {
                return inputStream.read(bArr, i3, i4);
            } catch (InvalidProtocolBufferException e3) {
                e3.j();
                throw e3;
            }
        }

        private ByteString N(int i3) throws IOException {
            byte[] bArrQ = Q(i3);
            if (bArrQ != null) {
                return ByteString.p(bArrQ);
            }
            int i4 = this.f36075k;
            int i5 = this.f36073i;
            int length = i5 - i4;
            this.f36077m += i5;
            this.f36075k = 0;
            this.f36073i = 0;
            List<byte[]> listR = R(i3 - length);
            byte[] bArr = new byte[i3];
            System.arraycopy(this.f36072h, i4, bArr, 0, length);
            for (byte[] bArr2 : listR) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return ByteString.Q(bArr);
        }

        private byte[] P(int i3, boolean z2) throws IOException {
            byte[] bArrQ = Q(i3);
            if (bArrQ != null) {
                return z2 ? (byte[]) bArrQ.clone() : bArrQ;
            }
            int i4 = this.f36075k;
            int i5 = this.f36073i;
            int length = i5 - i4;
            this.f36077m += i5;
            this.f36075k = 0;
            this.f36073i = 0;
            List<byte[]> listR = R(i3 - length);
            byte[] bArr = new byte[i3];
            System.arraycopy(this.f36072h, i4, bArr, 0, length);
            for (byte[] bArr2 : listR) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return bArr;
        }

        private byte[] Q(int i3) throws InvalidProtocolBufferException {
            if (i3 == 0) {
                return Internal.f36426d;
            }
            if (i3 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            int i4 = this.f36077m;
            int i5 = this.f36075k;
            int i6 = i4 + i5 + i3;
            if (i6 - this.f36044c > 0) {
                throw InvalidProtocolBufferException.l();
            }
            int i7 = this.f36078n;
            if (i6 > i7) {
                a0((i7 - i4) - i5);
                throw InvalidProtocolBufferException.m();
            }
            int i8 = this.f36073i - i5;
            int i9 = i3 - i8;
            if (i9 >= 4096 && i9 > L(this.f36071g)) {
                return null;
            }
            byte[] bArr = new byte[i3];
            System.arraycopy(this.f36072h, this.f36075k, bArr, 0, i8);
            this.f36077m += this.f36073i;
            this.f36075k = 0;
            this.f36073i = 0;
            while (i8 < i3) {
                int iM = M(this.f36071g, bArr, i8, i3 - i8);
                if (iM == -1) {
                    throw InvalidProtocolBufferException.m();
                }
                this.f36077m += iM;
                i8 += iM;
            }
            return bArr;
        }

        private List R(int i3) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i3 > 0) {
                int iMin = Math.min(i3, 4096);
                byte[] bArr = new byte[iMin];
                int i4 = 0;
                while (i4 < iMin) {
                    int i5 = this.f36071g.read(bArr, i4, iMin - i4);
                    if (i5 == -1) {
                        throw InvalidProtocolBufferException.m();
                    }
                    this.f36077m += i5;
                    i4 += i5;
                }
                i3 -= iMin;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private void X() {
            int i3 = this.f36073i + this.f36074j;
            this.f36073i = i3;
            int i4 = this.f36077m + i3;
            int i5 = this.f36078n;
            if (i4 <= i5) {
                this.f36074j = 0;
                return;
            }
            int i6 = i4 - i5;
            this.f36074j = i6;
            this.f36073i = i3 - i6;
        }

        private void Y(int i3) throws InvalidProtocolBufferException {
            if (f0(i3)) {
                return;
            }
            if (i3 <= (this.f36044c - this.f36077m) - this.f36075k) {
                throw InvalidProtocolBufferException.m();
            }
            throw InvalidProtocolBufferException.l();
        }

        private static long Z(InputStream inputStream, long j3) throws InvalidProtocolBufferException {
            try {
                return inputStream.skip(j3);
            } catch (InvalidProtocolBufferException e3) {
                e3.j();
                throw e3;
            }
        }

        private void b0(int i3) throws InvalidProtocolBufferException {
            if (i3 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            int i4 = this.f36077m;
            int i5 = this.f36075k;
            int i6 = i4 + i5 + i3;
            int i7 = this.f36078n;
            if (i6 > i7) {
                a0((i7 - i4) - i5);
                throw InvalidProtocolBufferException.m();
            }
            int i8 = 0;
            if (this.f36079o == null) {
                this.f36077m = i4 + i5;
                int i9 = this.f36073i - i5;
                this.f36073i = 0;
                this.f36075k = 0;
                i8 = i9;
                while (i8 < i3) {
                    try {
                        long j3 = i3 - i8;
                        long jZ = Z(this.f36071g, j3);
                        if (jZ < 0 || jZ > j3) {
                            throw new IllegalStateException(this.f36071g.getClass() + "#skip returned invalid result: " + jZ + "\nThe InputStream implementation is buggy.");
                        }
                        if (jZ == 0) {
                            break;
                        } else {
                            i8 += (int) jZ;
                        }
                    } finally {
                        this.f36077m += i8;
                        X();
                    }
                }
            }
            if (i8 >= i3) {
                return;
            }
            int i10 = this.f36073i;
            int i11 = i10 - this.f36075k;
            this.f36075k = i10;
            Y(1);
            while (true) {
                int i12 = i3 - i11;
                int i13 = this.f36073i;
                if (i12 <= i13) {
                    this.f36075k = i12;
                    return;
                } else {
                    i11 += i13;
                    this.f36075k = i13;
                    Y(1);
                }
            }
        }

        private void c0() throws InvalidProtocolBufferException {
            if (this.f36073i - this.f36075k >= 10) {
                d0();
            } else {
                e0();
            }
        }

        private void d0() throws InvalidProtocolBufferException {
            for (int i3 = 0; i3 < 10; i3++) {
                byte[] bArr = this.f36072h;
                int i4 = this.f36075k;
                this.f36075k = i4 + 1;
                if (bArr[i4] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private void e0() throws InvalidProtocolBufferException {
            for (int i3 = 0; i3 < 10; i3++) {
                if (O() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private boolean f0(int i3) throws InvalidProtocolBufferException {
            int i4 = this.f36075k;
            if (i4 + i3 <= this.f36073i) {
                throw new IllegalStateException("refillBuffer() called when " + i3 + " bytes were already available in buffer");
            }
            int i5 = this.f36044c;
            int i6 = this.f36077m;
            if (i3 > (i5 - i6) - i4 || i6 + i4 + i3 > this.f36078n) {
                return false;
            }
            RefillCallback refillCallback = this.f36079o;
            if (refillCallback != null) {
                refillCallback.a();
            }
            int i7 = this.f36075k;
            if (i7 > 0) {
                int i8 = this.f36073i;
                if (i8 > i7) {
                    byte[] bArr = this.f36072h;
                    System.arraycopy(bArr, i7, bArr, 0, i8 - i7);
                }
                this.f36077m += i7;
                this.f36073i -= i7;
                this.f36075k = 0;
            }
            InputStream inputStream = this.f36071g;
            byte[] bArr2 = this.f36072h;
            int i9 = this.f36073i;
            int iM = M(inputStream, bArr2, i9, Math.min(bArr2.length - i9, (this.f36044c - this.f36077m) - i9));
            if (iM == 0 || iM < -1 || iM > this.f36072h.length) {
                throw new IllegalStateException(this.f36071g.getClass() + "#read(byte[]) returned invalid result: " + iM + "\nThe InputStream implementation is buggy.");
            }
            if (iM <= 0) {
                return false;
            }
            this.f36073i += iM;
            X();
            if (this.f36073i >= i3) {
                return true;
            }
            return f0(i3);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int A() {
            return CodedInputStream.c(U());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long B() {
            return CodedInputStream.d(V());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String C() throws InvalidProtocolBufferException {
            int iU = U();
            if (iU > 0) {
                int i3 = this.f36073i;
                int i4 = this.f36075k;
                if (iU <= i3 - i4) {
                    String str = new String(this.f36072h, i4, iU, Internal.f36424b);
                    this.f36075k += iU;
                    return str;
                }
            }
            if (iU == 0) {
                return "";
            }
            if (iU < 0) {
                throw InvalidProtocolBufferException.g();
            }
            if (iU > this.f36073i) {
                return new String(P(iU, false), Internal.f36424b);
            }
            Y(iU);
            String str2 = new String(this.f36072h, this.f36075k, iU, Internal.f36424b);
            this.f36075k += iU;
            return str2;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int E() throws InvalidProtocolBufferException {
            if (f()) {
                this.f36076l = 0;
                return 0;
            }
            int iU = U();
            this.f36076l = iU;
            if (WireFormat.a(iU) != 0) {
                return this.f36076l;
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int F() {
            return U();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long G() {
            return V();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean H(int i3) throws InvalidProtocolBufferException {
            int iB = WireFormat.b(i3);
            if (iB == 0) {
                c0();
                return true;
            }
            if (iB == 1) {
                a0(8);
                return true;
            }
            if (iB == 2) {
                a0(U());
                return true;
            }
            if (iB == 3) {
                I();
                a(WireFormat.c(WireFormat.a(i3), 4));
                return true;
            }
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.e();
            }
            a0(4);
            return true;
        }

        public byte O() throws InvalidProtocolBufferException {
            if (this.f36075k == this.f36073i) {
                Y(1);
            }
            byte[] bArr = this.f36072h;
            int i3 = this.f36075k;
            this.f36075k = i3 + 1;
            return bArr[i3];
        }

        public int S() throws InvalidProtocolBufferException {
            int i3 = this.f36075k;
            if (this.f36073i - i3 < 4) {
                Y(4);
                i3 = this.f36075k;
            }
            byte[] bArr = this.f36072h;
            this.f36075k = i3 + 4;
            return ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
        }

        public long T() throws InvalidProtocolBufferException {
            int i3 = this.f36075k;
            if (this.f36073i - i3 < 8) {
                Y(8);
                i3 = this.f36075k;
            }
            byte[] bArr = this.f36072h;
            this.f36075k = i3 + 8;
            return ((((long) bArr[i3 + 7]) & 255) << 56) | (((long) bArr[i3]) & 255) | ((((long) bArr[i3 + 1]) & 255) << 8) | ((((long) bArr[i3 + 2]) & 255) << 16) | ((((long) bArr[i3 + 3]) & 255) << 24) | ((((long) bArr[i3 + 4]) & 255) << 32) | ((((long) bArr[i3 + 5]) & 255) << 40) | ((((long) bArr[i3 + 6]) & 255) << 48);
        }

        public int U() {
            int i3;
            int i4 = this.f36075k;
            int i5 = this.f36073i;
            if (i5 != i4) {
                byte[] bArr = this.f36072h;
                int i6 = i4 + 1;
                byte b3 = bArr[i4];
                if (b3 >= 0) {
                    this.f36075k = i6;
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
                    this.f36075k = i7;
                    return i3;
                }
            }
            return (int) W();
        }

        public long V() {
            long j3;
            long j4;
            long j5;
            int i3 = this.f36075k;
            int i4 = this.f36073i;
            if (i4 != i3) {
                byte[] bArr = this.f36072h;
                int i5 = i3 + 1;
                byte b3 = bArr[i3];
                if (b3 >= 0) {
                    this.f36075k = i5;
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
                    this.f36075k = i6;
                    return j3;
                }
            }
            return W();
        }

        long W() throws InvalidProtocolBufferException {
            long j3 = 0;
            for (int i3 = 0; i3 < 64; i3 += 7) {
                byte bO = O();
                j3 |= ((long) (bO & Ascii.DEL)) << i3;
                if ((bO & 128) == 0) {
                    return j3;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void a(int i3) throws InvalidProtocolBufferException {
            if (this.f36076l != i3) {
                throw InvalidProtocolBufferException.b();
            }
        }

        public void a0(int i3) throws InvalidProtocolBufferException {
            int i4 = this.f36073i;
            int i5 = this.f36075k;
            if (i3 > i4 - i5 || i3 < 0) {
                b0(i3);
            } else {
                this.f36075k = i5 + i3;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int e() {
            return this.f36077m + this.f36075k;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean f() {
            return this.f36075k == this.f36073i && !f0(1);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void n(int i3) {
            this.f36078n = i3;
            X();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int o(int i3) throws InvalidProtocolBufferException {
            if (i3 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            int i4 = i3 + this.f36077m + this.f36075k;
            if (i4 < 0) {
                throw InvalidProtocolBufferException.h();
            }
            int i5 = this.f36078n;
            if (i4 > i5) {
                throw InvalidProtocolBufferException.m();
            }
            this.f36078n = i4;
            X();
            return i5;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean p() {
            return V() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public ByteString q() throws InvalidProtocolBufferException {
            int iU = U();
            int i3 = this.f36073i;
            int i4 = this.f36075k;
            if (iU <= i3 - i4 && iU > 0) {
                ByteString byteStringQ = ByteString.q(this.f36072h, i4, iU);
                this.f36075k += iU;
                return byteStringQ;
            }
            if (iU == 0) {
                return ByteString.f36020b;
            }
            if (iU >= 0) {
                return N(iU);
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public double r() {
            return Double.longBitsToDouble(T());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int s() {
            return U();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int t() {
            return S();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long u() {
            return T();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public float v() {
            return Float.intBitsToFloat(S());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int w() {
            return U();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long x() {
            return V();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int y() {
            return S();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long z() {
            return T();
        }

        private StreamDecoder(InputStream inputStream, int i3) {
            super();
            this.f36078n = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f36079o = null;
            Internal.b(inputStream, "input");
            this.f36071g = inputStream;
            this.f36072h = new byte[i3];
            this.f36073i = 0;
            this.f36075k = 0;
            this.f36077m = 0;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String D() throws IOException {
            byte[] bArrP;
            int iU = U();
            int i3 = this.f36075k;
            int i4 = this.f36073i;
            if (iU <= i4 - i3 && iU > 0) {
                bArrP = this.f36072h;
                this.f36075k = i3 + iU;
            } else {
                if (iU == 0) {
                    return tDEtWsFLJfe.Gdg;
                }
                if (iU >= 0) {
                    i3 = 0;
                    if (iU <= i4) {
                        Y(iU);
                        bArrP = this.f36072h;
                        this.f36075k = iU;
                    } else {
                        bArrP = P(iU, false);
                    }
                } else {
                    throw InvalidProtocolBufferException.g();
                }
            }
            return Utf8.h(bArrP, i3, iU);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class UnsafeDirectNioDecoder extends CodedInputStream {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final ByteBuffer f36083g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f36084h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final long f36085i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f36086j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f36087k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f36088l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f36089m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f36090n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private boolean f36091o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f36092p;

        private int J(long j3) {
            return (int) (j3 - this.f36085i);
        }

        static boolean K() {
            return UnsafeUtil.K();
        }

        private void R() {
            long j3 = this.f36086j + ((long) this.f36089m);
            this.f36086j = j3;
            int i3 = (int) (j3 - this.f36088l);
            int i4 = this.f36092p;
            if (i3 <= i4) {
                this.f36089m = 0;
                return;
            }
            int i5 = i3 - i4;
            this.f36089m = i5;
            this.f36086j = j3 - ((long) i5);
        }

        private int S() {
            return (int) (this.f36086j - this.f36087k);
        }

        private void U() throws InvalidProtocolBufferException {
            if (S() >= 10) {
                V();
            } else {
                W();
            }
        }

        private void V() throws InvalidProtocolBufferException {
            for (int i3 = 0; i3 < 10; i3++) {
                long j3 = this.f36087k;
                this.f36087k = 1 + j3;
                if (UnsafeUtil.x(j3) >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private void W() throws InvalidProtocolBufferException {
            for (int i3 = 0; i3 < 10; i3++) {
                if (L() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private ByteBuffer X(long j3, long j4) {
            int iPosition = this.f36083g.position();
            int iLimit = this.f36083g.limit();
            ByteBuffer byteBuffer = this.f36083g;
            try {
                try {
                    byteBuffer.position(J(j3));
                    byteBuffer.limit(J(j4));
                    return this.f36083g.slice();
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

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int A() {
            return CodedInputStream.c(O());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long B() {
            return CodedInputStream.d(P());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String C() throws InvalidProtocolBufferException {
            int iO = O();
            if (iO <= 0 || iO > S()) {
                if (iO == 0) {
                    return "";
                }
                if (iO < 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.m();
            }
            byte[] bArr = new byte[iO];
            long j3 = iO;
            UnsafeUtil.p(this.f36087k, bArr, 0L, j3);
            String str = new String(bArr, Internal.f36424b);
            this.f36087k += j3;
            return str;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String D() throws InvalidProtocolBufferException {
            int iO = O();
            if (iO > 0 && iO <= S()) {
                String strG = Utf8.g(this.f36083g, J(this.f36087k), iO);
                this.f36087k += (long) iO;
                return strG;
            }
            if (iO == 0) {
                return "";
            }
            if (iO <= 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.m();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int E() throws InvalidProtocolBufferException {
            if (f()) {
                this.f36090n = 0;
                return 0;
            }
            int iO = O();
            this.f36090n = iO;
            if (WireFormat.a(iO) != 0) {
                return this.f36090n;
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int F() {
            return O();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long G() {
            return P();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean H(int i3) throws InvalidProtocolBufferException {
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
                T(O());
                return true;
            }
            if (iB == 3) {
                I();
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

        public byte L() throws InvalidProtocolBufferException {
            long j3 = this.f36087k;
            if (j3 == this.f36086j) {
                throw InvalidProtocolBufferException.m();
            }
            this.f36087k = 1 + j3;
            return UnsafeUtil.x(j3);
        }

        public int M() throws InvalidProtocolBufferException {
            long j3 = this.f36087k;
            if (this.f36086j - j3 < 4) {
                throw InvalidProtocolBufferException.m();
            }
            this.f36087k = 4 + j3;
            return ((UnsafeUtil.x(j3 + 3) & 255) << 24) | (UnsafeUtil.x(j3) & 255) | ((UnsafeUtil.x(1 + j3) & 255) << 8) | ((UnsafeUtil.x(2 + j3) & 255) << 16);
        }

        public long N() throws InvalidProtocolBufferException {
            long j3 = this.f36087k;
            if (this.f36086j - j3 < 8) {
                throw InvalidProtocolBufferException.m();
            }
            this.f36087k = 8 + j3;
            return ((((long) UnsafeUtil.x(j3 + 7)) & 255) << 56) | (((long) UnsafeUtil.x(j3)) & 255) | ((((long) UnsafeUtil.x(1 + j3)) & 255) << 8) | ((((long) UnsafeUtil.x(2 + j3)) & 255) << 16) | ((((long) UnsafeUtil.x(3 + j3)) & 255) << 24) | ((((long) UnsafeUtil.x(4 + j3)) & 255) << 32) | ((((long) UnsafeUtil.x(5 + j3)) & 255) << 40) | ((((long) UnsafeUtil.x(6 + j3)) & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x008c, code lost:
        
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.x(r3) < 0) goto L34;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int O() {
            /*
                r9 = this;
                long r0 = r9.f36087k
                long r2 = r9.f36086j
                int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r2 != 0) goto La
                goto L8e
            La:
                r2 = 1
                long r2 = r2 + r0
                byte r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.x(r0)
                if (r4 < 0) goto L16
                r9.f36087k = r2
                return r4
            L16:
                long r5 = r9.f36086j
                long r5 = r5 - r2
                r7 = 9
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 >= 0) goto L21
                goto L8e
            L21:
                r5 = 2
                long r5 = r5 + r0
                byte r2 = androidx.datastore.preferences.protobuf.UnsafeUtil.x(r2)
                int r2 = r2 << 7
                r2 = r2 ^ r4
                if (r2 >= 0) goto L31
                r0 = r2 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L98
            L31:
                r3 = 3
                long r3 = r3 + r0
                byte r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.x(r5)
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
                byte r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.x(r3)
                int r3 = r3 << 21
                r2 = r2 ^ r3
                if (r2 >= 0) goto L52
                r0 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L98
            L52:
                r3 = 5
                long r3 = r3 + r0
                byte r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.x(r5)
                int r6 = r5 << 28
                r2 = r2 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r2 = r2 ^ r6
                if (r5 >= 0) goto L96
                r5 = 6
                long r5 = r5 + r0
                byte r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.x(r3)
                if (r3 >= 0) goto L94
                r3 = 7
                long r3 = r3 + r0
                byte r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.x(r5)
                if (r5 >= 0) goto L96
                r5 = 8
                long r5 = r5 + r0
                byte r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.x(r3)
                if (r3 >= 0) goto L94
                long r3 = r0 + r7
                byte r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.x(r5)
                if (r5 >= 0) goto L96
                r5 = 10
                long r5 = r5 + r0
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.x(r3)
                if (r0 >= 0) goto L94
            L8e:
                long r0 = r9.Q()
                int r0 = (int) r0
                return r0
            L94:
                r0 = r2
                goto L98
            L96:
                r0 = r2
                goto L3f
            L98:
                r9.f36087k = r5
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.UnsafeDirectNioDecoder.O():int");
        }

        public long P() {
            long j3;
            long j4;
            long j5;
            int i3;
            long j6 = this.f36087k;
            if (this.f36086j != j6) {
                long j7 = 1 + j6;
                byte bX = UnsafeUtil.x(j6);
                if (bX >= 0) {
                    this.f36087k = j7;
                    return bX;
                }
                if (this.f36086j - j7 >= 9) {
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
                        this.f36087k = j8;
                        return j3;
                    }
                    i3 = iX ^ (-128);
                    j3 = i3;
                    this.f36087k = j8;
                    return j3;
                }
            }
            return Q();
        }

        long Q() throws InvalidProtocolBufferException {
            long j3 = 0;
            for (int i3 = 0; i3 < 64; i3 += 7) {
                byte bL = L();
                j3 |= ((long) (bL & Ascii.DEL)) << i3;
                if ((bL & 128) == 0) {
                    return j3;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        public void T(int i3) throws InvalidProtocolBufferException {
            if (i3 >= 0 && i3 <= S()) {
                this.f36087k += (long) i3;
            } else {
                if (i3 >= 0) {
                    throw InvalidProtocolBufferException.m();
                }
                throw InvalidProtocolBufferException.g();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void a(int i3) throws InvalidProtocolBufferException {
            if (this.f36090n != i3) {
                throw InvalidProtocolBufferException.b();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int e() {
            return (int) (this.f36087k - this.f36088l);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean f() {
            return this.f36087k == this.f36086j;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void n(int i3) {
            this.f36092p = i3;
            R();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int o(int i3) throws InvalidProtocolBufferException {
            if (i3 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            int iE = i3 + e();
            int i4 = this.f36092p;
            if (iE > i4) {
                throw InvalidProtocolBufferException.m();
            }
            this.f36092p = iE;
            R();
            return i4;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean p() {
            return P() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public ByteString q() throws InvalidProtocolBufferException {
            int iO = O();
            if (iO <= 0 || iO > S()) {
                if (iO == 0) {
                    return ByteString.f36020b;
                }
                if (iO < 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.m();
            }
            if (this.f36084h && this.f36091o) {
                long j3 = this.f36087k;
                long j4 = iO;
                ByteBuffer byteBufferX = X(j3, j3 + j4);
                this.f36087k += j4;
                return ByteString.P(byteBufferX);
            }
            byte[] bArr = new byte[iO];
            long j5 = iO;
            UnsafeUtil.p(this.f36087k, bArr, 0L, j5);
            this.f36087k += j5;
            return ByteString.Q(bArr);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public double r() {
            return Double.longBitsToDouble(N());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int s() {
            return O();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int t() {
            return M();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long u() {
            return N();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public float v() {
            return Float.intBitsToFloat(M());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int w() {
            return O();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long x() {
            return P();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int y() {
            return M();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long z() {
            return N();
        }

        private UnsafeDirectNioDecoder(ByteBuffer byteBuffer, boolean z2) {
            super();
            this.f36092p = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.f36083g = byteBuffer;
            long jK = UnsafeUtil.k(byteBuffer);
            this.f36085i = jK;
            this.f36086j = ((long) byteBuffer.limit()) + jK;
            long jPosition = jK + ((long) byteBuffer.position());
            this.f36087k = jPosition;
            this.f36088l = jPosition;
            this.f36084h = z2;
        }
    }

    public static int c(int i3) {
        return (-(i3 & 1)) ^ (i3 >>> 1);
    }

    public static long d(long j3) {
        return (-(j3 & 1)) ^ (j3 >>> 1);
    }

    public static CodedInputStream g(InputStream inputStream) {
        return h(inputStream, 4096);
    }

    public static CodedInputStream h(InputStream inputStream, int i3) {
        if (i3 > 0) {
            return inputStream == null ? k(Internal.f36426d) : new StreamDecoder(inputStream, i3);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    static CodedInputStream i(Iterable iterable, boolean z2) {
        Iterator it = iterable.iterator();
        int i3 = 0;
        int iRemaining = 0;
        while (it.hasNext()) {
            ByteBuffer byteBuffer = (ByteBuffer) it.next();
            iRemaining += byteBuffer.remaining();
            i3 = byteBuffer.hasArray() ? i3 | 1 : byteBuffer.isDirect() ? i3 | 2 : i3 | 4;
        }
        return i3 == 2 ? new IterableDirectByteBufferDecoder(iterable, iRemaining, z2) : g(new IterableByteBufferInputStream(iterable));
    }

    static CodedInputStream j(ByteBuffer byteBuffer, boolean z2) {
        if (byteBuffer.hasArray()) {
            return m(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z2);
        }
        if (byteBuffer.isDirect() && UnsafeDirectNioDecoder.K()) {
            return new UnsafeDirectNioDecoder(byteBuffer, z2);
        }
        int iRemaining = byteBuffer.remaining();
        byte[] bArr = new byte[iRemaining];
        byteBuffer.duplicate().get(bArr);
        return m(bArr, 0, iRemaining, true);
    }

    public static CodedInputStream k(byte[] bArr) {
        return l(bArr, 0, bArr.length);
    }

    public static CodedInputStream l(byte[] bArr, int i3, int i4) {
        return m(bArr, i3, i4, false);
    }

    static CodedInputStream m(byte[] bArr, int i3, int i4, boolean z2) {
        ArrayDecoder arrayDecoder = new ArrayDecoder(bArr, i3, i4, z2);
        try {
            arrayDecoder.o(i4);
            return arrayDecoder;
        } catch (InvalidProtocolBufferException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    public abstract int A();

    public abstract long B();

    public abstract String C();

    public abstract String D();

    public abstract int E();

    public abstract int F();

    public abstract long G();

    public abstract boolean H(int i3);

    public void I() throws InvalidProtocolBufferException {
        int iE;
        do {
            iE = E();
            if (iE == 0) {
                return;
            }
            b();
            this.f36042a++;
            this.f36042a--;
        } while (H(iE));
    }

    public abstract void a(int i3);

    public void b() throws InvalidProtocolBufferException {
        if (this.f36042a >= this.f36043b) {
            throw InvalidProtocolBufferException.i();
        }
    }

    public abstract int e();

    public abstract boolean f();

    public abstract void n(int i3);

    public abstract int o(int i3);

    public abstract boolean p();

    public abstract ByteString q();

    public abstract double r();

    public abstract int s();

    public abstract int t();

    public abstract long u();

    public abstract float v();

    public abstract int w();

    public abstract long x();

    public abstract int y();

    public abstract long z();

    private CodedInputStream() {
        this.f36043b = f36041f;
        this.f36044c = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f36046e = false;
    }
}
