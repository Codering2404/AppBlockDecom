package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import androidx.datastore.preferences.protobuf.WireFormat;
import com.google.android.gms.common.api.Api;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class CodedInputStreamReader implements Reader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CodedInputStream f36093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f36094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f36095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f36096d = 0;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.CodedInputStreamReader$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f36097a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f36097a = iArr;
            try {
                iArr[WireFormat.FieldType.f36695k.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36097a[WireFormat.FieldType.f36699o.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36097a[WireFormat.FieldType.f36688c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f36097a[WireFormat.FieldType.f36701q.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f36097a[WireFormat.FieldType.f36694j.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f36097a[WireFormat.FieldType.f36693i.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f36097a[WireFormat.FieldType.f36689d.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f36097a[WireFormat.FieldType.f36692h.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f36097a[WireFormat.FieldType.f36690f.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f36097a[WireFormat.FieldType.f36698n.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f36097a[WireFormat.FieldType.f36702r.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f36097a[WireFormat.FieldType.f36703s.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f36097a[WireFormat.FieldType.f36704t.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f36097a[WireFormat.FieldType.f36705u.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f36097a[WireFormat.FieldType.f36696l.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f36097a[WireFormat.FieldType.f36700p.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f36097a[WireFormat.FieldType.f36691g.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private CodedInputStreamReader(CodedInputStream codedInputStream) {
        CodedInputStream codedInputStream2 = (CodedInputStream) Internal.b(codedInputStream, "input");
        this.f36093a = codedInputStream2;
        codedInputStream2.f36045d = this;
    }

    public static CodedInputStreamReader Q(CodedInputStream codedInputStream) {
        CodedInputStreamReader codedInputStreamReader = codedInputStream.f36045d;
        return codedInputStreamReader != null ? codedInputStreamReader : new CodedInputStreamReader(codedInputStream);
    }

    private void R(Object obj, Schema schema, ExtensionRegistryLite extensionRegistryLite) {
        int i3 = this.f36095c;
        this.f36095c = WireFormat.c(WireFormat.a(this.f36094b), 4);
        try {
            schema.g(obj, this, extensionRegistryLite);
            if (this.f36094b == this.f36095c) {
            } else {
                throw InvalidProtocolBufferException.h();
            }
        } finally {
            this.f36095c = i3;
        }
    }

    private void S(Object obj, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        int iF = this.f36093a.F();
        CodedInputStream codedInputStream = this.f36093a;
        if (codedInputStream.f36042a >= codedInputStream.f36043b) {
            throw InvalidProtocolBufferException.i();
        }
        int iO = codedInputStream.o(iF);
        this.f36093a.f36042a++;
        schema.g(obj, this, extensionRegistryLite);
        this.f36093a.a(0);
        r5.f36042a--;
        this.f36093a.n(iO);
    }

    private Object T(WireFormat.FieldType fieldType, Class cls, ExtensionRegistryLite extensionRegistryLite) {
        switch (AnonymousClass1.f36097a[fieldType.ordinal()]) {
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
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    private Object U(Schema schema, ExtensionRegistryLite extensionRegistryLite) {
        Object objNewInstance = schema.newInstance();
        R(objNewInstance, schema, extensionRegistryLite);
        schema.b(objNewInstance);
        return objNewInstance;
    }

    private Object V(Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        Object objNewInstance = schema.newInstance();
        S(objNewInstance, schema, extensionRegistryLite);
        schema.b(objNewInstance);
        return objNewInstance;
    }

    private void X(int i3) throws InvalidProtocolBufferException {
        if (this.f36093a.e() != i3) {
            throw InvalidProtocolBufferException.m();
        }
    }

    private void Y(int i3) throws InvalidProtocolBufferException.InvalidWireTypeException {
        if (WireFormat.b(this.f36094b) != i3) {
            throw InvalidProtocolBufferException.e();
        }
    }

    private void Z(int i3) throws InvalidProtocolBufferException {
        if ((i3 & 3) != 0) {
            throw InvalidProtocolBufferException.h();
        }
    }

    private void a0(int i3) throws InvalidProtocolBufferException {
        if ((i3 & 7) != 0) {
            throw InvalidProtocolBufferException.h();
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public int A() {
        int i3 = this.f36096d;
        if (i3 != 0) {
            this.f36094b = i3;
            this.f36096d = 0;
        } else {
            this.f36094b = this.f36093a.E();
        }
        int i4 = this.f36094b;
        return (i4 == 0 || i4 == this.f36095c) ? Api.BaseClientBuilder.API_PRIORITY_OTHER : WireFormat.a(i4);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void B(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        W(list, false);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void C(List list) throws InvalidProtocolBufferException {
        int iE;
        int iE2;
        if (!(list instanceof FloatArrayList)) {
            int iB = WireFormat.b(this.f36094b);
            if (iB == 2) {
                int iF = this.f36093a.F();
                Z(iF);
                int iE3 = this.f36093a.e() + iF;
                do {
                    list.add(Float.valueOf(this.f36093a.v()));
                } while (this.f36093a.e() < iE3);
                return;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.e();
            }
            do {
                list.add(Float.valueOf(this.f36093a.v()));
                if (this.f36093a.f()) {
                    return;
                } else {
                    iE = this.f36093a.E();
                }
            } while (iE == this.f36094b);
            this.f36096d = iE;
            return;
        }
        FloatArrayList floatArrayList = (FloatArrayList) list;
        int iB2 = WireFormat.b(this.f36094b);
        if (iB2 == 2) {
            int iF2 = this.f36093a.F();
            Z(iF2);
            int iE4 = this.f36093a.e() + iF2;
            do {
                floatArrayList.e(this.f36093a.v());
            } while (this.f36093a.e() < iE4);
            return;
        }
        if (iB2 != 5) {
            throw InvalidProtocolBufferException.e();
        }
        do {
            floatArrayList.e(this.f36093a.v());
            if (this.f36093a.f()) {
                return;
            } else {
                iE2 = this.f36093a.E();
            }
        } while (iE2 == this.f36094b);
        this.f36096d = iE2;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public boolean D() {
        int i3;
        if (this.f36093a.f() || (i3 = this.f36094b) == this.f36095c) {
            return false;
        }
        return this.f36093a.H(i3);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public int E() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(5);
        return this.f36093a.y();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void F(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iE;
        if (WireFormat.b(this.f36094b) != 2) {
            throw InvalidProtocolBufferException.e();
        }
        do {
            list.add(o());
            if (this.f36093a.f()) {
                return;
            } else {
                iE = this.f36093a.E();
            }
        } while (iE == this.f36094b);
        this.f36096d = iE;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void G(List list) throws InvalidProtocolBufferException {
        int iE;
        int iE2;
        if (!(list instanceof DoubleArrayList)) {
            int iB = WireFormat.b(this.f36094b);
            if (iB == 1) {
                do {
                    list.add(Double.valueOf(this.f36093a.r()));
                    if (this.f36093a.f()) {
                        return;
                    } else {
                        iE = this.f36093a.E();
                    }
                } while (iE == this.f36094b);
                this.f36096d = iE;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iF = this.f36093a.F();
            a0(iF);
            int iE3 = this.f36093a.e() + iF;
            do {
                list.add(Double.valueOf(this.f36093a.r()));
            } while (this.f36093a.e() < iE3);
            return;
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) list;
        int iB2 = WireFormat.b(this.f36094b);
        if (iB2 == 1) {
            do {
                doubleArrayList.e(this.f36093a.r());
                if (this.f36093a.f()) {
                    return;
                } else {
                    iE2 = this.f36093a.E();
                }
            } while (iE2 == this.f36094b);
            this.f36096d = iE2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iF2 = this.f36093a.F();
        a0(iF2);
        int iE4 = this.f36093a.e() + iF2;
        do {
            doubleArrayList.e(this.f36093a.r());
        } while (this.f36093a.e() < iE4);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public long H() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(0);
        return this.f36093a.x();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public String I() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(2);
        return this.f36093a.D();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void J(Object obj, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        Y(2);
        S(obj, schema, extensionRegistryLite);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void K(List list, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iE;
        if (WireFormat.b(this.f36094b) != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int i3 = this.f36094b;
        do {
            list.add(V(schema, extensionRegistryLite));
            if (this.f36093a.f() || this.f36096d != 0) {
                return;
            } else {
                iE = this.f36093a.E();
            }
        } while (iE == i3);
        this.f36096d = iE;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public Object L(Class cls, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(2);
        return V(Protobuf.a().c(cls), extensionRegistryLite);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public Object M(Class cls, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(3);
        return U(Protobuf.a().c(cls), extensionRegistryLite);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
    
        r7.f36093a.n(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        return;
     */
    @Override // androidx.datastore.preferences.protobuf.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void N(java.util.Map r8, androidx.datastore.preferences.protobuf.MapEntryLite.Metadata r9, androidx.datastore.preferences.protobuf.ExtensionRegistryLite r10) throws androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException {
        /*
            r7 = this;
            r0 = 2
            r7.Y(r0)
            androidx.datastore.preferences.protobuf.CodedInputStream r1 = r7.f36093a
            int r1 = r1.F()
            androidx.datastore.preferences.protobuf.CodedInputStream r2 = r7.f36093a
            int r1 = r2.o(r1)
            java.lang.Object r2 = r9.f36504b
            java.lang.Object r3 = r9.f36506d
        L14:
            int r4 = r7.A()     // Catch: java.lang.Throwable -> L3a
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5e
            androidx.datastore.preferences.protobuf.CodedInputStream r5 = r7.f36093a     // Catch: java.lang.Throwable -> L3a
            boolean r5 = r5.f()     // Catch: java.lang.Throwable -> L3a
            if (r5 == 0) goto L26
            goto L5e
        L26:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L49
            if (r4 == r0) goto L3c
            boolean r4 = r7.D()     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            if (r4 == 0) goto L34
            goto L14
        L34:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            throw r4     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
        L3a:
            r8 = move-exception
            goto L67
        L3c:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.f36505c     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            java.lang.Object r5 = r9.f36506d     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            java.lang.Object r3 = r7.T(r4, r5, r10)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            goto L14
        L49:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.f36503a     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            r5 = 0
            java.lang.Object r2 = r7.T(r4, r5, r5)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            goto L14
        L51:
            boolean r4 = r7.D()     // Catch: java.lang.Throwable -> L3a
            if (r4 == 0) goto L58
            goto L14
        L58:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r8 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L3a
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L3a
            throw r8     // Catch: java.lang.Throwable -> L3a
        L5e:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L3a
            androidx.datastore.preferences.protobuf.CodedInputStream r8 = r7.f36093a
            r8.n(r1)
            return
        L67:
            androidx.datastore.preferences.protobuf.CodedInputStream r9 = r7.f36093a
            r9.n(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStreamReader.N(java.util.Map, androidx.datastore.preferences.protobuf.MapEntryLite$Metadata, androidx.datastore.preferences.protobuf.ExtensionRegistryLite):void");
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void O(Object obj, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(3);
        R(obj, schema, extensionRegistryLite);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void P(List list, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iE;
        if (WireFormat.b(this.f36094b) != 3) {
            throw InvalidProtocolBufferException.e();
        }
        int i3 = this.f36094b;
        do {
            list.add(U(schema, extensionRegistryLite));
            if (this.f36093a.f() || this.f36096d != 0) {
                return;
            } else {
                iE = this.f36093a.E();
            }
        } while (iE == i3);
        this.f36096d = iE;
    }

    public void W(List list, boolean z2) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iE;
        int iE2;
        if (WireFormat.b(this.f36094b) != 2) {
            throw InvalidProtocolBufferException.e();
        }
        if (!(list instanceof LazyStringList) || z2) {
            do {
                list.add(z2 ? I() : z());
                if (this.f36093a.f()) {
                    return;
                } else {
                    iE = this.f36093a.E();
                }
            } while (iE == this.f36094b);
            this.f36096d = iE;
            return;
        }
        LazyStringList lazyStringList = (LazyStringList) list;
        do {
            lazyStringList.K1(o());
            if (this.f36093a.f()) {
                return;
            } else {
                iE2 = this.f36093a.E();
            }
        } while (iE2 == this.f36094b);
        this.f36096d = iE2;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public long a() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(1);
        return this.f36093a.u();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void b(List list) throws InvalidProtocolBufferException {
        int iE;
        int iE2;
        if (!(list instanceof IntArrayList)) {
            int iB = WireFormat.b(this.f36094b);
            if (iB == 2) {
                int iF = this.f36093a.F();
                Z(iF);
                int iE3 = this.f36093a.e() + iF;
                do {
                    list.add(Integer.valueOf(this.f36093a.y()));
                } while (this.f36093a.e() < iE3);
                return;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.e();
            }
            do {
                list.add(Integer.valueOf(this.f36093a.y()));
                if (this.f36093a.f()) {
                    return;
                } else {
                    iE = this.f36093a.E();
                }
            } while (iE == this.f36094b);
            this.f36096d = iE;
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iB2 = WireFormat.b(this.f36094b);
        if (iB2 == 2) {
            int iF2 = this.f36093a.F();
            Z(iF2);
            int iE4 = this.f36093a.e() + iF2;
            do {
                intArrayList.e(this.f36093a.y());
            } while (this.f36093a.e() < iE4);
            return;
        }
        if (iB2 != 5) {
            throw InvalidProtocolBufferException.e();
        }
        do {
            intArrayList.e(this.f36093a.y());
            if (this.f36093a.f()) {
                return;
            } else {
                iE2 = this.f36093a.E();
            }
        } while (iE2 == this.f36094b);
        this.f36096d = iE2;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public int c() {
        return this.f36094b;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void d(List list) throws InvalidProtocolBufferException {
        int iE;
        int iE2;
        if (!(list instanceof LongArrayList)) {
            int iB = WireFormat.b(this.f36094b);
            if (iB == 0) {
                do {
                    list.add(Long.valueOf(this.f36093a.B()));
                    if (this.f36093a.f()) {
                        return;
                    } else {
                        iE = this.f36093a.E();
                    }
                } while (iE == this.f36094b);
                this.f36096d = iE;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iE3 = this.f36093a.e() + this.f36093a.F();
            do {
                list.add(Long.valueOf(this.f36093a.B()));
            } while (this.f36093a.e() < iE3);
            X(iE3);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int iB2 = WireFormat.b(this.f36094b);
        if (iB2 == 0) {
            do {
                longArrayList.f(this.f36093a.B());
                if (this.f36093a.f()) {
                    return;
                } else {
                    iE2 = this.f36093a.E();
                }
            } while (iE2 == this.f36094b);
            this.f36096d = iE2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iE4 = this.f36093a.e() + this.f36093a.F();
        do {
            longArrayList.f(this.f36093a.B());
        } while (this.f36093a.e() < iE4);
        X(iE4);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public boolean e() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(0);
        return this.f36093a.p();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public long f() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(1);
        return this.f36093a.z();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void g(List list) throws InvalidProtocolBufferException {
        int iE;
        int iE2;
        if (!(list instanceof LongArrayList)) {
            int iB = WireFormat.b(this.f36094b);
            if (iB == 0) {
                do {
                    list.add(Long.valueOf(this.f36093a.G()));
                    if (this.f36093a.f()) {
                        return;
                    } else {
                        iE = this.f36093a.E();
                    }
                } while (iE == this.f36094b);
                this.f36096d = iE;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iE3 = this.f36093a.e() + this.f36093a.F();
            do {
                list.add(Long.valueOf(this.f36093a.G()));
            } while (this.f36093a.e() < iE3);
            X(iE3);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int iB2 = WireFormat.b(this.f36094b);
        if (iB2 == 0) {
            do {
                longArrayList.f(this.f36093a.G());
                if (this.f36093a.f()) {
                    return;
                } else {
                    iE2 = this.f36093a.E();
                }
            } while (iE2 == this.f36094b);
            this.f36096d = iE2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iE4 = this.f36093a.e() + this.f36093a.F();
        do {
            longArrayList.f(this.f36093a.G());
        } while (this.f36093a.e() < iE4);
        X(iE4);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public int h() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(0);
        return this.f36093a.F();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void i(List list) throws InvalidProtocolBufferException {
        int iE;
        int iE2;
        if (!(list instanceof LongArrayList)) {
            int iB = WireFormat.b(this.f36094b);
            if (iB == 0) {
                do {
                    list.add(Long.valueOf(this.f36093a.x()));
                    if (this.f36093a.f()) {
                        return;
                    } else {
                        iE = this.f36093a.E();
                    }
                } while (iE == this.f36094b);
                this.f36096d = iE;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iE3 = this.f36093a.e() + this.f36093a.F();
            do {
                list.add(Long.valueOf(this.f36093a.x()));
            } while (this.f36093a.e() < iE3);
            X(iE3);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int iB2 = WireFormat.b(this.f36094b);
        if (iB2 == 0) {
            do {
                longArrayList.f(this.f36093a.x());
                if (this.f36093a.f()) {
                    return;
                } else {
                    iE2 = this.f36093a.E();
                }
            } while (iE2 == this.f36094b);
            this.f36096d = iE2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iE4 = this.f36093a.e() + this.f36093a.F();
        do {
            longArrayList.f(this.f36093a.x());
        } while (this.f36093a.e() < iE4);
        X(iE4);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void j(List list) throws InvalidProtocolBufferException {
        int iE;
        int iE2;
        if (!(list instanceof IntArrayList)) {
            int iB = WireFormat.b(this.f36094b);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.f36093a.s()));
                    if (this.f36093a.f()) {
                        return;
                    } else {
                        iE = this.f36093a.E();
                    }
                } while (iE == this.f36094b);
                this.f36096d = iE;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iE3 = this.f36093a.e() + this.f36093a.F();
            do {
                list.add(Integer.valueOf(this.f36093a.s()));
            } while (this.f36093a.e() < iE3);
            X(iE3);
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iB2 = WireFormat.b(this.f36094b);
        if (iB2 == 0) {
            do {
                intArrayList.e(this.f36093a.s());
                if (this.f36093a.f()) {
                    return;
                } else {
                    iE2 = this.f36093a.E();
                }
            } while (iE2 == this.f36094b);
            this.f36096d = iE2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iE4 = this.f36093a.e() + this.f36093a.F();
        do {
            intArrayList.e(this.f36093a.s());
        } while (this.f36093a.e() < iE4);
        X(iE4);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public int k() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(0);
        return this.f36093a.s();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public int l() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(0);
        return this.f36093a.A();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void m(List list) throws InvalidProtocolBufferException {
        int iE;
        int iE2;
        if (!(list instanceof BooleanArrayList)) {
            int iB = WireFormat.b(this.f36094b);
            if (iB == 0) {
                do {
                    list.add(Boolean.valueOf(this.f36093a.p()));
                    if (this.f36093a.f()) {
                        return;
                    } else {
                        iE = this.f36093a.E();
                    }
                } while (iE == this.f36094b);
                this.f36096d = iE;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iE3 = this.f36093a.e() + this.f36093a.F();
            do {
                list.add(Boolean.valueOf(this.f36093a.p()));
            } while (this.f36093a.e() < iE3);
            X(iE3);
            return;
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) list;
        int iB2 = WireFormat.b(this.f36094b);
        if (iB2 == 0) {
            do {
                booleanArrayList.f(this.f36093a.p());
                if (this.f36093a.f()) {
                    return;
                } else {
                    iE2 = this.f36093a.E();
                }
            } while (iE2 == this.f36094b);
            this.f36096d = iE2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iE4 = this.f36093a.e() + this.f36093a.F();
        do {
            booleanArrayList.f(this.f36093a.p());
        } while (this.f36093a.e() < iE4);
        X(iE4);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void n(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        W(list, true);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public ByteString o() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(2);
        return this.f36093a.q();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public int p() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(0);
        return this.f36093a.w();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void q(List list) throws InvalidProtocolBufferException {
        int iE;
        int iE2;
        if (!(list instanceof LongArrayList)) {
            int iB = WireFormat.b(this.f36094b);
            if (iB == 1) {
                do {
                    list.add(Long.valueOf(this.f36093a.u()));
                    if (this.f36093a.f()) {
                        return;
                    } else {
                        iE = this.f36093a.E();
                    }
                } while (iE == this.f36094b);
                this.f36096d = iE;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iF = this.f36093a.F();
            a0(iF);
            int iE3 = this.f36093a.e() + iF;
            do {
                list.add(Long.valueOf(this.f36093a.u()));
            } while (this.f36093a.e() < iE3);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int iB2 = WireFormat.b(this.f36094b);
        if (iB2 == 1) {
            do {
                longArrayList.f(this.f36093a.u());
                if (this.f36093a.f()) {
                    return;
                } else {
                    iE2 = this.f36093a.E();
                }
            } while (iE2 == this.f36094b);
            this.f36096d = iE2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iF2 = this.f36093a.F();
        a0(iF2);
        int iE4 = this.f36093a.e() + iF2;
        do {
            longArrayList.f(this.f36093a.u());
        } while (this.f36093a.e() < iE4);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void r(List list) throws InvalidProtocolBufferException {
        int iE;
        int iE2;
        if (!(list instanceof IntArrayList)) {
            int iB = WireFormat.b(this.f36094b);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.f36093a.A()));
                    if (this.f36093a.f()) {
                        return;
                    } else {
                        iE = this.f36093a.E();
                    }
                } while (iE == this.f36094b);
                this.f36096d = iE;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iE3 = this.f36093a.e() + this.f36093a.F();
            do {
                list.add(Integer.valueOf(this.f36093a.A()));
            } while (this.f36093a.e() < iE3);
            X(iE3);
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iB2 = WireFormat.b(this.f36094b);
        if (iB2 == 0) {
            do {
                intArrayList.e(this.f36093a.A());
                if (this.f36093a.f()) {
                    return;
                } else {
                    iE2 = this.f36093a.E();
                }
            } while (iE2 == this.f36094b);
            this.f36096d = iE2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iE4 = this.f36093a.e() + this.f36093a.F();
        do {
            intArrayList.e(this.f36093a.A());
        } while (this.f36093a.e() < iE4);
        X(iE4);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public double readDouble() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(1);
        return this.f36093a.r();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public float readFloat() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(5);
        return this.f36093a.v();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public long s() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(0);
        return this.f36093a.G();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void t(List list) throws InvalidProtocolBufferException {
        int iE;
        int iE2;
        if (!(list instanceof IntArrayList)) {
            int iB = WireFormat.b(this.f36094b);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.f36093a.F()));
                    if (this.f36093a.f()) {
                        return;
                    } else {
                        iE = this.f36093a.E();
                    }
                } while (iE == this.f36094b);
                this.f36096d = iE;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iE3 = this.f36093a.e() + this.f36093a.F();
            do {
                list.add(Integer.valueOf(this.f36093a.F()));
            } while (this.f36093a.e() < iE3);
            X(iE3);
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iB2 = WireFormat.b(this.f36094b);
        if (iB2 == 0) {
            do {
                intArrayList.e(this.f36093a.F());
                if (this.f36093a.f()) {
                    return;
                } else {
                    iE2 = this.f36093a.E();
                }
            } while (iE2 == this.f36094b);
            this.f36096d = iE2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iE4 = this.f36093a.e() + this.f36093a.F();
        do {
            intArrayList.e(this.f36093a.F());
        } while (this.f36093a.e() < iE4);
        X(iE4);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public int u() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(5);
        return this.f36093a.t();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void v(List list) throws InvalidProtocolBufferException {
        int iE;
        int iE2;
        if (!(list instanceof LongArrayList)) {
            int iB = WireFormat.b(this.f36094b);
            if (iB == 1) {
                do {
                    list.add(Long.valueOf(this.f36093a.z()));
                    if (this.f36093a.f()) {
                        return;
                    } else {
                        iE = this.f36093a.E();
                    }
                } while (iE == this.f36094b);
                this.f36096d = iE;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iF = this.f36093a.F();
            a0(iF);
            int iE3 = this.f36093a.e() + iF;
            do {
                list.add(Long.valueOf(this.f36093a.z()));
            } while (this.f36093a.e() < iE3);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int iB2 = WireFormat.b(this.f36094b);
        if (iB2 == 1) {
            do {
                longArrayList.f(this.f36093a.z());
                if (this.f36093a.f()) {
                    return;
                } else {
                    iE2 = this.f36093a.E();
                }
            } while (iE2 == this.f36094b);
            this.f36096d = iE2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iF2 = this.f36093a.F();
        a0(iF2);
        int iE4 = this.f36093a.e() + iF2;
        do {
            longArrayList.f(this.f36093a.z());
        } while (this.f36093a.e() < iE4);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void w(List list) throws InvalidProtocolBufferException {
        int iE;
        int iE2;
        if (!(list instanceof IntArrayList)) {
            int iB = WireFormat.b(this.f36094b);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.f36093a.w()));
                    if (this.f36093a.f()) {
                        return;
                    } else {
                        iE = this.f36093a.E();
                    }
                } while (iE == this.f36094b);
                this.f36096d = iE;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iE3 = this.f36093a.e() + this.f36093a.F();
            do {
                list.add(Integer.valueOf(this.f36093a.w()));
            } while (this.f36093a.e() < iE3);
            X(iE3);
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iB2 = WireFormat.b(this.f36094b);
        if (iB2 == 0) {
            do {
                intArrayList.e(this.f36093a.w());
                if (this.f36093a.f()) {
                    return;
                } else {
                    iE2 = this.f36093a.E();
                }
            } while (iE2 == this.f36094b);
            this.f36096d = iE2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iE4 = this.f36093a.e() + this.f36093a.F();
        do {
            intArrayList.e(this.f36093a.w());
        } while (this.f36093a.e() < iE4);
        X(iE4);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void x(List list) throws InvalidProtocolBufferException {
        int iE;
        int iE2;
        if (!(list instanceof IntArrayList)) {
            int iB = WireFormat.b(this.f36094b);
            if (iB == 2) {
                int iF = this.f36093a.F();
                Z(iF);
                int iE3 = this.f36093a.e() + iF;
                do {
                    list.add(Integer.valueOf(this.f36093a.t()));
                } while (this.f36093a.e() < iE3);
                return;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.e();
            }
            do {
                list.add(Integer.valueOf(this.f36093a.t()));
                if (this.f36093a.f()) {
                    return;
                } else {
                    iE = this.f36093a.E();
                }
            } while (iE == this.f36094b);
            this.f36096d = iE;
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iB2 = WireFormat.b(this.f36094b);
        if (iB2 == 2) {
            int iF2 = this.f36093a.F();
            Z(iF2);
            int iE4 = this.f36093a.e() + iF2;
            do {
                intArrayList.e(this.f36093a.t());
            } while (this.f36093a.e() < iE4);
            return;
        }
        if (iB2 != 5) {
            throw InvalidProtocolBufferException.e();
        }
        do {
            intArrayList.e(this.f36093a.t());
            if (this.f36093a.f()) {
                return;
            } else {
                iE2 = this.f36093a.E();
            }
        } while (iE2 == this.f36094b);
        this.f36096d = iE2;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public long y() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(0);
        return this.f36093a.B();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public String z() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(2);
        return this.f36093a.C();
    }
}
