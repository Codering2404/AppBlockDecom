package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
abstract class BinaryReader implements Reader {

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.BinaryReader$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f35979a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f35979a = iArr;
            try {
                iArr[WireFormat.FieldType.f36695k.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35979a[WireFormat.FieldType.f36699o.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35979a[WireFormat.FieldType.f36688c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35979a[WireFormat.FieldType.f36701q.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35979a[WireFormat.FieldType.f36694j.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f35979a[WireFormat.FieldType.f36693i.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f35979a[WireFormat.FieldType.f36689d.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f35979a[WireFormat.FieldType.f36692h.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f35979a[WireFormat.FieldType.f36690f.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f35979a[WireFormat.FieldType.f36698n.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f35979a[WireFormat.FieldType.f36702r.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f35979a[WireFormat.FieldType.f36703s.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f35979a[WireFormat.FieldType.f36704t.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f35979a[WireFormat.FieldType.f36705u.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f35979a[WireFormat.FieldType.f36696l.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f35979a[WireFormat.FieldType.f36700p.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f35979a[WireFormat.FieldType.f36691g.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SafeHeapReader extends BinaryReader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f35980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f35981b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f35982c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f35983d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f35984e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f35985f;

        private boolean Q() {
            return this.f35982c == this.f35983d;
        }

        private byte R() throws InvalidProtocolBufferException {
            int i3 = this.f35982c;
            if (i3 == this.f35983d) {
                throw InvalidProtocolBufferException.m();
            }
            byte[] bArr = this.f35981b;
            this.f35982c = i3 + 1;
            return bArr[i3];
        }

        private Object S(WireFormat.FieldType fieldType, Class cls, ExtensionRegistryLite extensionRegistryLite) {
            switch (AnonymousClass1.f35979a[fieldType.ordinal()]) {
                case 1:
                    return Boolean.valueOf(e());
                case 2:
                    return o();
                case 3:
                    return Double.valueOf(readDouble());
                case 4:
                    return Integer.valueOf(k());
                case 5:
                    return Integer.valueOf(u());
                case 6:
                    return Long.valueOf(a());
                case 7:
                    return Float.valueOf(readFloat());
                case 8:
                    return Integer.valueOf(p());
                case 9:
                    return Long.valueOf(H());
                case 10:
                    return L(cls, extensionRegistryLite);
                case 11:
                    return Integer.valueOf(E());
                case 12:
                    return Long.valueOf(f());
                case 13:
                    return Integer.valueOf(l());
                case 14:
                    return Long.valueOf(y());
                case 15:
                    return I();
                case 16:
                    return Integer.valueOf(h());
                case 17:
                    return Long.valueOf(s());
                default:
                    throw new RuntimeException("unsupported field type.");
            }
        }

        private Object T(Schema schema, ExtensionRegistryLite extensionRegistryLite) {
            Object objNewInstance = schema.newInstance();
            O(objNewInstance, schema, extensionRegistryLite);
            schema.b(objNewInstance);
            return objNewInstance;
        }

        private int U() throws InvalidProtocolBufferException {
            e0(4);
            return V();
        }

        private int V() {
            int i3 = this.f35982c;
            byte[] bArr = this.f35981b;
            this.f35982c = i3 + 4;
            return ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
        }

        private long W() throws InvalidProtocolBufferException {
            e0(8);
            return X();
        }

        private long X() {
            int i3 = this.f35982c;
            byte[] bArr = this.f35981b;
            this.f35982c = i3 + 8;
            return ((((long) bArr[i3 + 7]) & 255) << 56) | (((long) bArr[i3]) & 255) | ((((long) bArr[i3 + 1]) & 255) << 8) | ((((long) bArr[i3 + 2]) & 255) << 16) | ((((long) bArr[i3 + 3]) & 255) << 24) | ((((long) bArr[i3 + 4]) & 255) << 32) | ((((long) bArr[i3 + 5]) & 255) << 40) | ((((long) bArr[i3 + 6]) & 255) << 48);
        }

        private Object Y(Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Object objNewInstance = schema.newInstance();
            J(objNewInstance, schema, extensionRegistryLite);
            schema.b(objNewInstance);
            return objNewInstance;
        }

        private int b0() throws InvalidProtocolBufferException {
            int i3;
            int i4 = this.f35982c;
            int i5 = this.f35983d;
            if (i5 == i4) {
                throw InvalidProtocolBufferException.m();
            }
            byte[] bArr = this.f35981b;
            int i6 = i4 + 1;
            byte b3 = bArr[i4];
            if (b3 >= 0) {
                this.f35982c = i6;
                return b3;
            }
            if (i5 - i6 < 9) {
                return (int) d0();
            }
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
                                            if (bArr[i9] < 0) {
                                                throw InvalidProtocolBufferException.f();
                                            }
                                            i7 = i14;
                                            i3 = i13;
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
            this.f35982c = i7;
            return i3;
        }

        private long d0() throws InvalidProtocolBufferException {
            long j3 = 0;
            for (int i3 = 0; i3 < 64; i3 += 7) {
                byte bR = R();
                j3 |= ((long) (bR & Ascii.DEL)) << i3;
                if ((bR & 128) == 0) {
                    return j3;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private void e0(int i3) throws InvalidProtocolBufferException {
            if (i3 < 0 || i3 > this.f35983d - this.f35982c) {
                throw InvalidProtocolBufferException.m();
            }
        }

        private void f0(int i3) throws InvalidProtocolBufferException {
            if (this.f35982c != i3) {
                throw InvalidProtocolBufferException.m();
            }
        }

        private void g0(int i3) throws InvalidProtocolBufferException.InvalidWireTypeException {
            if (WireFormat.b(this.f35984e) != i3) {
                throw InvalidProtocolBufferException.e();
            }
        }

        private void h0(int i3) throws InvalidProtocolBufferException {
            e0(i3);
            this.f35982c += i3;
        }

        private void i0() throws InvalidProtocolBufferException {
            int i3 = this.f35985f;
            this.f35985f = WireFormat.c(WireFormat.a(this.f35984e), 4);
            while (A() != Integer.MAX_VALUE && D()) {
            }
            if (this.f35984e != this.f35985f) {
                throw InvalidProtocolBufferException.h();
            }
            this.f35985f = i3;
        }

        private void j0() throws InvalidProtocolBufferException {
            int i3 = this.f35983d;
            int i4 = this.f35982c;
            if (i3 - i4 >= 10) {
                byte[] bArr = this.f35981b;
                int i5 = 0;
                while (i5 < 10) {
                    int i6 = i4 + 1;
                    if (bArr[i4] >= 0) {
                        this.f35982c = i6;
                        return;
                    } else {
                        i5++;
                        i4 = i6;
                    }
                }
            }
            k0();
        }

        private void k0() throws InvalidProtocolBufferException {
            for (int i3 = 0; i3 < 10; i3++) {
                if (R() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.f();
        }

        private void l0(int i3) throws InvalidProtocolBufferException {
            e0(i3);
            if ((i3 & 3) != 0) {
                throw InvalidProtocolBufferException.h();
            }
        }

        private void m0(int i3) throws InvalidProtocolBufferException {
            e0(i3);
            if ((i3 & 7) != 0) {
                throw InvalidProtocolBufferException.h();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public int A() throws InvalidProtocolBufferException {
            if (Q()) {
                return Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            int iB0 = b0();
            this.f35984e = iB0;
            return iB0 == this.f35985f ? Api.BaseClientBuilder.API_PRIORITY_OTHER : WireFormat.a(iB0);
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void B(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
            a0(list, false);
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void C(List list) throws InvalidProtocolBufferException {
            int i3;
            int i4;
            if (!(list instanceof FloatArrayList)) {
                int iB = WireFormat.b(this.f35984e);
                if (iB == 2) {
                    int iB0 = b0();
                    l0(iB0);
                    int i5 = this.f35982c + iB0;
                    while (this.f35982c < i5) {
                        list.add(Float.valueOf(Float.intBitsToFloat(V())));
                    }
                    return;
                }
                if (iB != 5) {
                    throw InvalidProtocolBufferException.e();
                }
                do {
                    list.add(Float.valueOf(readFloat()));
                    if (Q()) {
                        return;
                    } else {
                        i3 = this.f35982c;
                    }
                } while (b0() == this.f35984e);
                this.f35982c = i3;
                return;
            }
            FloatArrayList floatArrayList = (FloatArrayList) list;
            int iB2 = WireFormat.b(this.f35984e);
            if (iB2 == 2) {
                int iB02 = b0();
                l0(iB02);
                int i6 = this.f35982c + iB02;
                while (this.f35982c < i6) {
                    floatArrayList.e(Float.intBitsToFloat(V()));
                }
                return;
            }
            if (iB2 != 5) {
                throw InvalidProtocolBufferException.e();
            }
            do {
                floatArrayList.e(readFloat());
                if (Q()) {
                    return;
                } else {
                    i4 = this.f35982c;
                }
            } while (b0() == this.f35984e);
            this.f35982c = i4;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public boolean D() throws InvalidProtocolBufferException {
            int i3;
            if (Q() || (i3 = this.f35984e) == this.f35985f) {
                return false;
            }
            int iB = WireFormat.b(i3);
            if (iB == 0) {
                j0();
                return true;
            }
            if (iB == 1) {
                h0(8);
                return true;
            }
            if (iB == 2) {
                h0(b0());
                return true;
            }
            if (iB == 3) {
                i0();
                return true;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.e();
            }
            h0(4);
            return true;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public int E() throws InvalidProtocolBufferException.InvalidWireTypeException {
            g0(5);
            return U();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void F(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
            int i3;
            if (WireFormat.b(this.f35984e) != 2) {
                throw InvalidProtocolBufferException.e();
            }
            do {
                list.add(o());
                if (Q()) {
                    return;
                } else {
                    i3 = this.f35982c;
                }
            } while (b0() == this.f35984e);
            this.f35982c = i3;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void G(List list) throws InvalidProtocolBufferException {
            int i3;
            int i4;
            if (!(list instanceof DoubleArrayList)) {
                int iB = WireFormat.b(this.f35984e);
                if (iB == 1) {
                    do {
                        list.add(Double.valueOf(readDouble()));
                        if (Q()) {
                            return;
                        } else {
                            i3 = this.f35982c;
                        }
                    } while (b0() == this.f35984e);
                    this.f35982c = i3;
                    return;
                }
                if (iB != 2) {
                    throw InvalidProtocolBufferException.e();
                }
                int iB0 = b0();
                m0(iB0);
                int i5 = this.f35982c + iB0;
                while (this.f35982c < i5) {
                    list.add(Double.valueOf(Double.longBitsToDouble(X())));
                }
                return;
            }
            DoubleArrayList doubleArrayList = (DoubleArrayList) list;
            int iB2 = WireFormat.b(this.f35984e);
            if (iB2 == 1) {
                do {
                    doubleArrayList.e(readDouble());
                    if (Q()) {
                        return;
                    } else {
                        i4 = this.f35982c;
                    }
                } while (b0() == this.f35984e);
                this.f35982c = i4;
                return;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iB02 = b0();
            m0(iB02);
            int i6 = this.f35982c + iB02;
            while (this.f35982c < i6) {
                doubleArrayList.e(Double.longBitsToDouble(X()));
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public long H() throws InvalidProtocolBufferException.InvalidWireTypeException {
            g0(0);
            return c0();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public String I() {
            return Z(true);
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void J(Object obj, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int iB0 = b0();
            e0(iB0);
            int i3 = this.f35983d;
            int i4 = this.f35982c + iB0;
            this.f35983d = i4;
            try {
                schema.g(obj, this, extensionRegistryLite);
                if (this.f35982c == i4) {
                } else {
                    throw InvalidProtocolBufferException.h();
                }
            } finally {
                this.f35983d = i3;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void K(List list, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
            int i3;
            if (WireFormat.b(this.f35984e) != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int i4 = this.f35984e;
            do {
                list.add(Y(schema, extensionRegistryLite));
                if (Q()) {
                    return;
                } else {
                    i3 = this.f35982c;
                }
            } while (b0() == i4);
            this.f35982c = i3;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public Object L(Class cls, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
            g0(2);
            return Y(Protobuf.a().c(cls), extensionRegistryLite);
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public Object M(Class cls, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
            g0(3);
            return T(Protobuf.a().c(cls), extensionRegistryLite);
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void N(Map map, MapEntryLite.Metadata metadata, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            g0(2);
            int iB0 = b0();
            e0(iB0);
            int i3 = this.f35983d;
            this.f35983d = this.f35982c + iB0;
            try {
                Object objS = metadata.f36504b;
                Object objS2 = metadata.f36506d;
                while (true) {
                    int iA = A();
                    if (iA == Integer.MAX_VALUE) {
                        map.put(objS, objS2);
                        return;
                    }
                    if (iA == 1) {
                        objS = S(metadata.f36503a, null, null);
                    } else if (iA != 2) {
                        try {
                            if (!D()) {
                                throw new InvalidProtocolBufferException("Unable to parse map entry.");
                            }
                        } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                            if (!D()) {
                                throw new InvalidProtocolBufferException("Unable to parse map entry.");
                            }
                        }
                    } else {
                        objS2 = S(metadata.f36505c, metadata.f36506d.getClass(), extensionRegistryLite);
                    }
                }
            } finally {
                this.f35983d = i3;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void O(Object obj, Schema schema, ExtensionRegistryLite extensionRegistryLite) {
            int i3 = this.f35985f;
            this.f35985f = WireFormat.c(WireFormat.a(this.f35984e), 4);
            try {
                schema.g(obj, this, extensionRegistryLite);
                if (this.f35984e == this.f35985f) {
                } else {
                    throw InvalidProtocolBufferException.h();
                }
            } finally {
                this.f35985f = i3;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void P(List list, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
            int i3;
            if (WireFormat.b(this.f35984e) != 3) {
                throw InvalidProtocolBufferException.e();
            }
            int i4 = this.f35984e;
            do {
                list.add(T(schema, extensionRegistryLite));
                if (Q()) {
                    return;
                } else {
                    i3 = this.f35982c;
                }
            } while (b0() == i4);
            this.f35982c = i3;
        }

        public String Z(boolean z2) throws InvalidProtocolBufferException {
            g0(2);
            int iB0 = b0();
            if (iB0 == 0) {
                return "";
            }
            e0(iB0);
            if (z2) {
                byte[] bArr = this.f35981b;
                int i3 = this.f35982c;
                if (!Utf8.u(bArr, i3, i3 + iB0)) {
                    throw InvalidProtocolBufferException.d();
                }
            }
            String str = new String(this.f35981b, this.f35982c, iB0, Internal.f36424b);
            this.f35982c += iB0;
            return str;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public long a() throws InvalidProtocolBufferException.InvalidWireTypeException {
            g0(1);
            return W();
        }

        public void a0(List list, boolean z2) throws InvalidProtocolBufferException.InvalidWireTypeException {
            int i3;
            int i4;
            if (WireFormat.b(this.f35984e) != 2) {
                throw InvalidProtocolBufferException.e();
            }
            if (!(list instanceof LazyStringList) || z2) {
                do {
                    list.add(Z(z2));
                    if (Q()) {
                        return;
                    } else {
                        i3 = this.f35982c;
                    }
                } while (b0() == this.f35984e);
                this.f35982c = i3;
                return;
            }
            LazyStringList lazyStringList = (LazyStringList) list;
            do {
                lazyStringList.K1(o());
                if (Q()) {
                    return;
                } else {
                    i4 = this.f35982c;
                }
            } while (b0() == this.f35984e);
            this.f35982c = i4;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void b(List list) throws InvalidProtocolBufferException {
            int i3;
            int i4;
            if (!(list instanceof IntArrayList)) {
                int iB = WireFormat.b(this.f35984e);
                if (iB == 2) {
                    int iB0 = b0();
                    l0(iB0);
                    int i5 = this.f35982c + iB0;
                    while (this.f35982c < i5) {
                        list.add(Integer.valueOf(V()));
                    }
                    return;
                }
                if (iB != 5) {
                    throw InvalidProtocolBufferException.e();
                }
                do {
                    list.add(Integer.valueOf(E()));
                    if (Q()) {
                        return;
                    } else {
                        i3 = this.f35982c;
                    }
                } while (b0() == this.f35984e);
                this.f35982c = i3;
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int iB2 = WireFormat.b(this.f35984e);
            if (iB2 == 2) {
                int iB02 = b0();
                l0(iB02);
                int i6 = this.f35982c + iB02;
                while (this.f35982c < i6) {
                    intArrayList.e(V());
                }
                return;
            }
            if (iB2 != 5) {
                throw InvalidProtocolBufferException.e();
            }
            do {
                intArrayList.e(E());
                if (Q()) {
                    return;
                } else {
                    i4 = this.f35982c;
                }
            } while (b0() == this.f35984e);
            this.f35982c = i4;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public int c() {
            return this.f35984e;
        }

        public long c0() throws InvalidProtocolBufferException {
            long j3;
            long j4;
            long j5;
            int i3 = this.f35982c;
            int i4 = this.f35983d;
            if (i4 == i3) {
                throw InvalidProtocolBufferException.m();
            }
            byte[] bArr = this.f35981b;
            int i5 = i3 + 1;
            byte b3 = bArr[i3];
            if (b3 >= 0) {
                this.f35982c = i5;
                return b3;
            }
            if (i4 - i5 < 9) {
                return d0();
            }
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
                                            if (bArr[i6] < 0) {
                                                throw InvalidProtocolBufferException.f();
                                            }
                                            i6 = i13;
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
            this.f35982c = i6;
            return j3;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void d(List list) throws InvalidProtocolBufferException {
            int i3;
            int i4;
            if (!(list instanceof LongArrayList)) {
                int iB = WireFormat.b(this.f35984e);
                if (iB != 0) {
                    if (iB != 2) {
                        throw InvalidProtocolBufferException.e();
                    }
                    int iB0 = this.f35982c + b0();
                    while (this.f35982c < iB0) {
                        list.add(Long.valueOf(CodedInputStream.d(c0())));
                    }
                    return;
                }
                do {
                    list.add(Long.valueOf(y()));
                    if (Q()) {
                        return;
                    } else {
                        i3 = this.f35982c;
                    }
                } while (b0() == this.f35984e);
                this.f35982c = i3;
                return;
            }
            LongArrayList longArrayList = (LongArrayList) list;
            int iB2 = WireFormat.b(this.f35984e);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw InvalidProtocolBufferException.e();
                }
                int iB02 = this.f35982c + b0();
                while (this.f35982c < iB02) {
                    longArrayList.f(CodedInputStream.d(c0()));
                }
                return;
            }
            do {
                longArrayList.f(y());
                if (Q()) {
                    return;
                } else {
                    i4 = this.f35982c;
                }
            } while (b0() == this.f35984e);
            this.f35982c = i4;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public boolean e() throws InvalidProtocolBufferException.InvalidWireTypeException {
            g0(0);
            return b0() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public long f() throws InvalidProtocolBufferException.InvalidWireTypeException {
            g0(1);
            return W();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void g(List list) throws InvalidProtocolBufferException {
            int i3;
            int i4;
            if (!(list instanceof LongArrayList)) {
                int iB = WireFormat.b(this.f35984e);
                if (iB == 0) {
                    do {
                        list.add(Long.valueOf(s()));
                        if (Q()) {
                            return;
                        } else {
                            i3 = this.f35982c;
                        }
                    } while (b0() == this.f35984e);
                    this.f35982c = i3;
                    return;
                }
                if (iB != 2) {
                    throw InvalidProtocolBufferException.e();
                }
                int iB0 = this.f35982c + b0();
                while (this.f35982c < iB0) {
                    list.add(Long.valueOf(c0()));
                }
                f0(iB0);
                return;
            }
            LongArrayList longArrayList = (LongArrayList) list;
            int iB2 = WireFormat.b(this.f35984e);
            if (iB2 == 0) {
                do {
                    longArrayList.f(s());
                    if (Q()) {
                        return;
                    } else {
                        i4 = this.f35982c;
                    }
                } while (b0() == this.f35984e);
                this.f35982c = i4;
                return;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iB02 = this.f35982c + b0();
            while (this.f35982c < iB02) {
                longArrayList.f(c0());
            }
            f0(iB02);
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public int h() throws InvalidProtocolBufferException.InvalidWireTypeException {
            g0(0);
            return b0();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void i(List list) throws InvalidProtocolBufferException {
            int i3;
            int i4;
            if (!(list instanceof LongArrayList)) {
                int iB = WireFormat.b(this.f35984e);
                if (iB == 0) {
                    do {
                        list.add(Long.valueOf(H()));
                        if (Q()) {
                            return;
                        } else {
                            i3 = this.f35982c;
                        }
                    } while (b0() == this.f35984e);
                    this.f35982c = i3;
                    return;
                }
                if (iB != 2) {
                    throw InvalidProtocolBufferException.e();
                }
                int iB0 = this.f35982c + b0();
                while (this.f35982c < iB0) {
                    list.add(Long.valueOf(c0()));
                }
                f0(iB0);
                return;
            }
            LongArrayList longArrayList = (LongArrayList) list;
            int iB2 = WireFormat.b(this.f35984e);
            if (iB2 == 0) {
                do {
                    longArrayList.f(H());
                    if (Q()) {
                        return;
                    } else {
                        i4 = this.f35982c;
                    }
                } while (b0() == this.f35984e);
                this.f35982c = i4;
                return;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iB02 = this.f35982c + b0();
            while (this.f35982c < iB02) {
                longArrayList.f(c0());
            }
            f0(iB02);
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void j(List list) throws InvalidProtocolBufferException {
            int i3;
            int i4;
            if (!(list instanceof IntArrayList)) {
                int iB = WireFormat.b(this.f35984e);
                if (iB != 0) {
                    if (iB != 2) {
                        throw InvalidProtocolBufferException.e();
                    }
                    int iB0 = this.f35982c + b0();
                    while (this.f35982c < iB0) {
                        list.add(Integer.valueOf(b0()));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(k()));
                    if (Q()) {
                        return;
                    } else {
                        i3 = this.f35982c;
                    }
                } while (b0() == this.f35984e);
                this.f35982c = i3;
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int iB2 = WireFormat.b(this.f35984e);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw InvalidProtocolBufferException.e();
                }
                int iB02 = this.f35982c + b0();
                while (this.f35982c < iB02) {
                    intArrayList.e(b0());
                }
                return;
            }
            do {
                intArrayList.e(k());
                if (Q()) {
                    return;
                } else {
                    i4 = this.f35982c;
                }
            } while (b0() == this.f35984e);
            this.f35982c = i4;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public int k() throws InvalidProtocolBufferException.InvalidWireTypeException {
            g0(0);
            return b0();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public int l() throws InvalidProtocolBufferException.InvalidWireTypeException {
            g0(0);
            return CodedInputStream.c(b0());
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void m(List list) throws InvalidProtocolBufferException {
            int i3;
            int i4;
            if (!(list instanceof BooleanArrayList)) {
                int iB = WireFormat.b(this.f35984e);
                if (iB != 0) {
                    if (iB != 2) {
                        throw InvalidProtocolBufferException.e();
                    }
                    int iB0 = this.f35982c + b0();
                    while (this.f35982c < iB0) {
                        list.add(Boolean.valueOf(b0() != 0));
                    }
                    f0(iB0);
                    return;
                }
                do {
                    list.add(Boolean.valueOf(e()));
                    if (Q()) {
                        return;
                    } else {
                        i3 = this.f35982c;
                    }
                } while (b0() == this.f35984e);
                this.f35982c = i3;
                return;
            }
            BooleanArrayList booleanArrayList = (BooleanArrayList) list;
            int iB2 = WireFormat.b(this.f35984e);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw InvalidProtocolBufferException.e();
                }
                int iB02 = this.f35982c + b0();
                while (this.f35982c < iB02) {
                    booleanArrayList.f(b0() != 0);
                }
                f0(iB02);
                return;
            }
            do {
                booleanArrayList.f(e());
                if (Q()) {
                    return;
                } else {
                    i4 = this.f35982c;
                }
            } while (b0() == this.f35984e);
            this.f35982c = i4;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void n(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
            a0(list, true);
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public ByteString o() throws InvalidProtocolBufferException {
            g0(2);
            int iB0 = b0();
            if (iB0 == 0) {
                return ByteString.f36020b;
            }
            e0(iB0);
            ByteString byteStringR = this.f35980a ? ByteString.R(this.f35981b, this.f35982c, iB0) : ByteString.q(this.f35981b, this.f35982c, iB0);
            this.f35982c += iB0;
            return byteStringR;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public int p() throws InvalidProtocolBufferException.InvalidWireTypeException {
            g0(0);
            return b0();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void q(List list) throws InvalidProtocolBufferException {
            int i3;
            int i4;
            if (!(list instanceof LongArrayList)) {
                int iB = WireFormat.b(this.f35984e);
                if (iB == 1) {
                    do {
                        list.add(Long.valueOf(a()));
                        if (Q()) {
                            return;
                        } else {
                            i3 = this.f35982c;
                        }
                    } while (b0() == this.f35984e);
                    this.f35982c = i3;
                    return;
                }
                if (iB != 2) {
                    throw InvalidProtocolBufferException.e();
                }
                int iB0 = b0();
                m0(iB0);
                int i5 = this.f35982c + iB0;
                while (this.f35982c < i5) {
                    list.add(Long.valueOf(X()));
                }
                return;
            }
            LongArrayList longArrayList = (LongArrayList) list;
            int iB2 = WireFormat.b(this.f35984e);
            if (iB2 == 1) {
                do {
                    longArrayList.f(a());
                    if (Q()) {
                        return;
                    } else {
                        i4 = this.f35982c;
                    }
                } while (b0() == this.f35984e);
                this.f35982c = i4;
                return;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iB02 = b0();
            m0(iB02);
            int i6 = this.f35982c + iB02;
            while (this.f35982c < i6) {
                longArrayList.f(X());
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void r(List list) throws InvalidProtocolBufferException {
            int i3;
            int i4;
            if (!(list instanceof IntArrayList)) {
                int iB = WireFormat.b(this.f35984e);
                if (iB != 0) {
                    if (iB != 2) {
                        throw InvalidProtocolBufferException.e();
                    }
                    int iB0 = this.f35982c + b0();
                    while (this.f35982c < iB0) {
                        list.add(Integer.valueOf(CodedInputStream.c(b0())));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(l()));
                    if (Q()) {
                        return;
                    } else {
                        i3 = this.f35982c;
                    }
                } while (b0() == this.f35984e);
                this.f35982c = i3;
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int iB2 = WireFormat.b(this.f35984e);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw InvalidProtocolBufferException.e();
                }
                int iB02 = this.f35982c + b0();
                while (this.f35982c < iB02) {
                    intArrayList.e(CodedInputStream.c(b0()));
                }
                return;
            }
            do {
                intArrayList.e(l());
                if (Q()) {
                    return;
                } else {
                    i4 = this.f35982c;
                }
            } while (b0() == this.f35984e);
            this.f35982c = i4;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public double readDouble() throws InvalidProtocolBufferException.InvalidWireTypeException {
            g0(1);
            return Double.longBitsToDouble(W());
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public float readFloat() throws InvalidProtocolBufferException.InvalidWireTypeException {
            g0(5);
            return Float.intBitsToFloat(U());
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public long s() throws InvalidProtocolBufferException.InvalidWireTypeException {
            g0(0);
            return c0();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void t(List list) throws InvalidProtocolBufferException {
            int i3;
            int i4;
            if (!(list instanceof IntArrayList)) {
                int iB = WireFormat.b(this.f35984e);
                if (iB != 0) {
                    if (iB != 2) {
                        throw InvalidProtocolBufferException.e();
                    }
                    int iB0 = this.f35982c + b0();
                    while (this.f35982c < iB0) {
                        list.add(Integer.valueOf(b0()));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(h()));
                    if (Q()) {
                        return;
                    } else {
                        i3 = this.f35982c;
                    }
                } while (b0() == this.f35984e);
                this.f35982c = i3;
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int iB2 = WireFormat.b(this.f35984e);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw InvalidProtocolBufferException.e();
                }
                int iB02 = this.f35982c + b0();
                while (this.f35982c < iB02) {
                    intArrayList.e(b0());
                }
                return;
            }
            do {
                intArrayList.e(h());
                if (Q()) {
                    return;
                } else {
                    i4 = this.f35982c;
                }
            } while (b0() == this.f35984e);
            this.f35982c = i4;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public int u() throws InvalidProtocolBufferException.InvalidWireTypeException {
            g0(5);
            return U();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void v(List list) throws InvalidProtocolBufferException {
            int i3;
            int i4;
            if (!(list instanceof LongArrayList)) {
                int iB = WireFormat.b(this.f35984e);
                if (iB == 1) {
                    do {
                        list.add(Long.valueOf(f()));
                        if (Q()) {
                            return;
                        } else {
                            i3 = this.f35982c;
                        }
                    } while (b0() == this.f35984e);
                    this.f35982c = i3;
                    return;
                }
                if (iB != 2) {
                    throw InvalidProtocolBufferException.e();
                }
                int iB0 = b0();
                m0(iB0);
                int i5 = this.f35982c + iB0;
                while (this.f35982c < i5) {
                    list.add(Long.valueOf(X()));
                }
                return;
            }
            LongArrayList longArrayList = (LongArrayList) list;
            int iB2 = WireFormat.b(this.f35984e);
            if (iB2 == 1) {
                do {
                    longArrayList.f(f());
                    if (Q()) {
                        return;
                    } else {
                        i4 = this.f35982c;
                    }
                } while (b0() == this.f35984e);
                this.f35982c = i4;
                return;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iB02 = b0();
            m0(iB02);
            int i6 = this.f35982c + iB02;
            while (this.f35982c < i6) {
                longArrayList.f(X());
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void w(List list) throws InvalidProtocolBufferException {
            int i3;
            int i4;
            if (!(list instanceof IntArrayList)) {
                int iB = WireFormat.b(this.f35984e);
                if (iB == 0) {
                    do {
                        list.add(Integer.valueOf(p()));
                        if (Q()) {
                            return;
                        } else {
                            i3 = this.f35982c;
                        }
                    } while (b0() == this.f35984e);
                    this.f35982c = i3;
                    return;
                }
                if (iB != 2) {
                    throw InvalidProtocolBufferException.e();
                }
                int iB0 = this.f35982c + b0();
                while (this.f35982c < iB0) {
                    list.add(Integer.valueOf(b0()));
                }
                f0(iB0);
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int iB2 = WireFormat.b(this.f35984e);
            if (iB2 == 0) {
                do {
                    intArrayList.e(p());
                    if (Q()) {
                        return;
                    } else {
                        i4 = this.f35982c;
                    }
                } while (b0() == this.f35984e);
                this.f35982c = i4;
                return;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iB02 = this.f35982c + b0();
            while (this.f35982c < iB02) {
                intArrayList.e(b0());
            }
            f0(iB02);
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public void x(List list) throws InvalidProtocolBufferException {
            int i3;
            int i4;
            if (!(list instanceof IntArrayList)) {
                int iB = WireFormat.b(this.f35984e);
                if (iB == 2) {
                    int iB0 = b0();
                    l0(iB0);
                    int i5 = this.f35982c + iB0;
                    while (this.f35982c < i5) {
                        list.add(Integer.valueOf(V()));
                    }
                    return;
                }
                if (iB != 5) {
                    throw InvalidProtocolBufferException.e();
                }
                do {
                    list.add(Integer.valueOf(u()));
                    if (Q()) {
                        return;
                    } else {
                        i3 = this.f35982c;
                    }
                } while (b0() == this.f35984e);
                this.f35982c = i3;
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int iB2 = WireFormat.b(this.f35984e);
            if (iB2 == 2) {
                int iB02 = b0();
                l0(iB02);
                int i6 = this.f35982c + iB02;
                while (this.f35982c < i6) {
                    intArrayList.e(V());
                }
                return;
            }
            if (iB2 != 5) {
                throw InvalidProtocolBufferException.e();
            }
            do {
                intArrayList.e(u());
                if (Q()) {
                    return;
                } else {
                    i4 = this.f35982c;
                }
            } while (b0() == this.f35984e);
            this.f35982c = i4;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public long y() throws InvalidProtocolBufferException.InvalidWireTypeException {
            g0(0);
            return CodedInputStream.d(c0());
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public String z() {
            return Z(false);
        }
    }
}
