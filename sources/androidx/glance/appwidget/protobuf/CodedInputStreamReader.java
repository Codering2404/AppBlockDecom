package androidx.glance.appwidget.protobuf;

import androidx.glance.appwidget.protobuf.InvalidProtocolBufferException;
import androidx.glance.appwidget.protobuf.WireFormat;
import com.google.android.gms.common.api.Api;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class CodedInputStreamReader implements Reader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CodedInputStream f38901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f38902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f38903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f38904d = 0;

    /* JADX INFO: renamed from: androidx.glance.appwidget.protobuf.CodedInputStreamReader$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f38905a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f38905a = iArr;
            try {
                iArr[WireFormat.FieldType.f39336k.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38905a[WireFormat.FieldType.f39340o.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38905a[WireFormat.FieldType.f39329c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f38905a[WireFormat.FieldType.f39342q.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f38905a[WireFormat.FieldType.f39335j.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f38905a[WireFormat.FieldType.f39334i.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f38905a[WireFormat.FieldType.f39330d.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f38905a[WireFormat.FieldType.f39333h.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f38905a[WireFormat.FieldType.f39331f.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f38905a[WireFormat.FieldType.f39339n.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f38905a[WireFormat.FieldType.f39343r.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f38905a[WireFormat.FieldType.f39344s.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f38905a[WireFormat.FieldType.f39345t.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f38905a[WireFormat.FieldType.f39346u.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f38905a[WireFormat.FieldType.f39337l.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f38905a[WireFormat.FieldType.f39341p.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f38905a[WireFormat.FieldType.f39332g.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private CodedInputStreamReader(CodedInputStream codedInputStream) {
        CodedInputStream codedInputStream2 = (CodedInputStream) Internal.b(codedInputStream, "input");
        this.f38901a = codedInputStream2;
        codedInputStream2.f38853d = this;
    }

    public static CodedInputStreamReader Q(CodedInputStream codedInputStream) {
        CodedInputStreamReader codedInputStreamReader = codedInputStream.f38853d;
        return codedInputStreamReader != null ? codedInputStreamReader : new CodedInputStreamReader(codedInputStream);
    }

    private void R(Object obj, Schema schema, ExtensionRegistryLite extensionRegistryLite) {
        int i3 = this.f38903c;
        this.f38903c = WireFormat.c(WireFormat.a(this.f38902b), 4);
        try {
            schema.h(obj, this, extensionRegistryLite);
            if (this.f38902b == this.f38903c) {
            } else {
                throw InvalidProtocolBufferException.h();
            }
        } finally {
            this.f38903c = i3;
        }
    }

    private void S(Object obj, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        int iE = this.f38901a.E();
        CodedInputStream codedInputStream = this.f38901a;
        if (codedInputStream.f38850a >= codedInputStream.f38851b) {
            throw InvalidProtocolBufferException.i();
        }
        int iN = codedInputStream.n(iE);
        this.f38901a.f38850a++;
        schema.h(obj, this, extensionRegistryLite);
        this.f38901a.a(0);
        r5.f38850a--;
        this.f38901a.m(iN);
    }

    private Object T(WireFormat.FieldType fieldType, Class cls, ExtensionRegistryLite extensionRegistryLite) {
        switch (AnonymousClass1.f38905a[fieldType.ordinal()]) {
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
                return N(cls, extensionRegistryLite);
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
        if (this.f38901a.d() != i3) {
            throw InvalidProtocolBufferException.m();
        }
    }

    private void Y(int i3) throws InvalidProtocolBufferException.InvalidWireTypeException {
        if (WireFormat.b(this.f38902b) != i3) {
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

    @Override // androidx.glance.appwidget.protobuf.Reader
    public int A() {
        int i3 = this.f38904d;
        if (i3 != 0) {
            this.f38902b = i3;
            this.f38904d = 0;
        } else {
            this.f38902b = this.f38901a.D();
        }
        int i4 = this.f38902b;
        return (i4 == 0 || i4 == this.f38903c) ? Api.BaseClientBuilder.API_PRIORITY_OTHER : WireFormat.a(i4);
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public void B(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        W(list, false);
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public void C(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        if (!(list instanceof FloatArrayList)) {
            int iB = WireFormat.b(this.f38902b);
            if (iB == 2) {
                int iE = this.f38901a.E();
                Z(iE);
                int iD3 = this.f38901a.d() + iE;
                do {
                    list.add(Float.valueOf(this.f38901a.u()));
                } while (this.f38901a.d() < iD3);
                return;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.e();
            }
            do {
                list.add(Float.valueOf(this.f38901a.u()));
                if (this.f38901a.e()) {
                    return;
                } else {
                    iD = this.f38901a.D();
                }
            } while (iD == this.f38902b);
            this.f38904d = iD;
            return;
        }
        FloatArrayList floatArrayList = (FloatArrayList) list;
        int iB2 = WireFormat.b(this.f38902b);
        if (iB2 == 2) {
            int iE2 = this.f38901a.E();
            Z(iE2);
            int iD4 = this.f38901a.d() + iE2;
            do {
                floatArrayList.e(this.f38901a.u());
            } while (this.f38901a.d() < iD4);
            return;
        }
        if (iB2 != 5) {
            throw InvalidProtocolBufferException.e();
        }
        do {
            floatArrayList.e(this.f38901a.u());
            if (this.f38901a.e()) {
                return;
            } else {
                iD2 = this.f38901a.D();
            }
        } while (iD2 == this.f38902b);
        this.f38904d = iD2;
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public boolean D() {
        int i3;
        if (this.f38901a.e() || (i3 = this.f38902b) == this.f38903c) {
            return false;
        }
        return this.f38901a.G(i3);
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public int E() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(5);
        return this.f38901a.x();
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public void F(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iD;
        if (WireFormat.b(this.f38902b) != 2) {
            throw InvalidProtocolBufferException.e();
        }
        do {
            list.add(o());
            if (this.f38901a.e()) {
                return;
            } else {
                iD = this.f38901a.D();
            }
        } while (iD == this.f38902b);
        this.f38904d = iD;
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public void G(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        if (!(list instanceof DoubleArrayList)) {
            int iB = WireFormat.b(this.f38902b);
            if (iB == 1) {
                do {
                    list.add(Double.valueOf(this.f38901a.q()));
                    if (this.f38901a.e()) {
                        return;
                    } else {
                        iD = this.f38901a.D();
                    }
                } while (iD == this.f38902b);
                this.f38904d = iD;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iE = this.f38901a.E();
            a0(iE);
            int iD3 = this.f38901a.d() + iE;
            do {
                list.add(Double.valueOf(this.f38901a.q()));
            } while (this.f38901a.d() < iD3);
            return;
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) list;
        int iB2 = WireFormat.b(this.f38902b);
        if (iB2 == 1) {
            do {
                doubleArrayList.e(this.f38901a.q());
                if (this.f38901a.e()) {
                    return;
                } else {
                    iD2 = this.f38901a.D();
                }
            } while (iD2 == this.f38902b);
            this.f38904d = iD2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iE2 = this.f38901a.E();
        a0(iE2);
        int iD4 = this.f38901a.d() + iE2;
        do {
            doubleArrayList.e(this.f38901a.q());
        } while (this.f38901a.d() < iD4);
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public long H() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(0);
        return this.f38901a.w();
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public String I() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(2);
        return this.f38901a.C();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
    
        r7.f38901a.m(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        return;
     */
    @Override // androidx.glance.appwidget.protobuf.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void J(java.util.Map r8, androidx.glance.appwidget.protobuf.MapEntryLite.Metadata r9, androidx.glance.appwidget.protobuf.ExtensionRegistryLite r10) throws androidx.glance.appwidget.protobuf.InvalidProtocolBufferException.InvalidWireTypeException {
        /*
            r7 = this;
            r0 = 2
            r7.Y(r0)
            androidx.glance.appwidget.protobuf.CodedInputStream r1 = r7.f38901a
            int r1 = r1.E()
            androidx.glance.appwidget.protobuf.CodedInputStream r2 = r7.f38901a
            int r1 = r2.n(r1)
            java.lang.Object r2 = r9.f39150b
            java.lang.Object r3 = r9.f39152d
        L14:
            int r4 = r7.A()     // Catch: java.lang.Throwable -> L3a
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5e
            androidx.glance.appwidget.protobuf.CodedInputStream r5 = r7.f38901a     // Catch: java.lang.Throwable -> L3a
            boolean r5 = r5.e()     // Catch: java.lang.Throwable -> L3a
            if (r5 == 0) goto L26
            goto L5e
        L26:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L49
            if (r4 == r0) goto L3c
            boolean r4 = r7.D()     // Catch: java.lang.Throwable -> L3a androidx.glance.appwidget.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            if (r4 == 0) goto L34
            goto L14
        L34:
            androidx.glance.appwidget.protobuf.InvalidProtocolBufferException r4 = new androidx.glance.appwidget.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L3a androidx.glance.appwidget.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L3a androidx.glance.appwidget.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            throw r4     // Catch: java.lang.Throwable -> L3a androidx.glance.appwidget.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
        L3a:
            r8 = move-exception
            goto L67
        L3c:
            androidx.glance.appwidget.protobuf.WireFormat$FieldType r4 = r9.f39151c     // Catch: java.lang.Throwable -> L3a androidx.glance.appwidget.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            java.lang.Object r5 = r9.f39152d     // Catch: java.lang.Throwable -> L3a androidx.glance.appwidget.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Throwable -> L3a androidx.glance.appwidget.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            java.lang.Object r3 = r7.T(r4, r5, r10)     // Catch: java.lang.Throwable -> L3a androidx.glance.appwidget.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            goto L14
        L49:
            androidx.glance.appwidget.protobuf.WireFormat$FieldType r4 = r9.f39149a     // Catch: java.lang.Throwable -> L3a androidx.glance.appwidget.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            r5 = 0
            java.lang.Object r2 = r7.T(r4, r5, r5)     // Catch: java.lang.Throwable -> L3a androidx.glance.appwidget.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            goto L14
        L51:
            boolean r4 = r7.D()     // Catch: java.lang.Throwable -> L3a
            if (r4 == 0) goto L58
            goto L14
        L58:
            androidx.glance.appwidget.protobuf.InvalidProtocolBufferException r8 = new androidx.glance.appwidget.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L3a
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L3a
            throw r8     // Catch: java.lang.Throwable -> L3a
        L5e:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L3a
            androidx.glance.appwidget.protobuf.CodedInputStream r8 = r7.f38901a
            r8.m(r1)
            return
        L67:
            androidx.glance.appwidget.protobuf.CodedInputStream r9 = r7.f38901a
            r9.m(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.protobuf.CodedInputStreamReader.J(java.util.Map, androidx.glance.appwidget.protobuf.MapEntryLite$Metadata, androidx.glance.appwidget.protobuf.ExtensionRegistryLite):void");
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public void K(List list, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iD;
        if (WireFormat.b(this.f38902b) != 3) {
            throw InvalidProtocolBufferException.e();
        }
        int i3 = this.f38902b;
        do {
            list.add(U(schema, extensionRegistryLite));
            if (this.f38901a.e() || this.f38904d != 0) {
                return;
            } else {
                iD = this.f38901a.D();
            }
        } while (iD == i3);
        this.f38904d = iD;
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public Object L(Class cls, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(3);
        return U(Protobuf.a().c(cls), extensionRegistryLite);
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public void M(List list, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iD;
        if (WireFormat.b(this.f38902b) != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int i3 = this.f38902b;
        do {
            list.add(V(schema, extensionRegistryLite));
            if (this.f38901a.e() || this.f38904d != 0) {
                return;
            } else {
                iD = this.f38901a.D();
            }
        } while (iD == i3);
        this.f38904d = iD;
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public Object N(Class cls, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(2);
        return V(Protobuf.a().c(cls), extensionRegistryLite);
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public void O(Object obj, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(3);
        R(obj, schema, extensionRegistryLite);
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public void P(Object obj, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        Y(2);
        S(obj, schema, extensionRegistryLite);
    }

    public void W(List list, boolean z2) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iD;
        int iD2;
        if (WireFormat.b(this.f38902b) != 2) {
            throw InvalidProtocolBufferException.e();
        }
        if (!(list instanceof LazyStringList) || z2) {
            do {
                list.add(z2 ? I() : z());
                if (this.f38901a.e()) {
                    return;
                } else {
                    iD = this.f38901a.D();
                }
            } while (iD == this.f38902b);
            this.f38904d = iD;
            return;
        }
        LazyStringList lazyStringList = (LazyStringList) list;
        do {
            lazyStringList.X0(o());
            if (this.f38901a.e()) {
                return;
            } else {
                iD2 = this.f38901a.D();
            }
        } while (iD2 == this.f38902b);
        this.f38904d = iD2;
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public long a() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(1);
        return this.f38901a.t();
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public void b(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        if (!(list instanceof IntArrayList)) {
            int iB = WireFormat.b(this.f38902b);
            if (iB == 2) {
                int iE = this.f38901a.E();
                Z(iE);
                int iD3 = this.f38901a.d() + iE;
                do {
                    list.add(Integer.valueOf(this.f38901a.x()));
                } while (this.f38901a.d() < iD3);
                return;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.e();
            }
            do {
                list.add(Integer.valueOf(this.f38901a.x()));
                if (this.f38901a.e()) {
                    return;
                } else {
                    iD = this.f38901a.D();
                }
            } while (iD == this.f38902b);
            this.f38904d = iD;
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iB2 = WireFormat.b(this.f38902b);
        if (iB2 == 2) {
            int iE2 = this.f38901a.E();
            Z(iE2);
            int iD4 = this.f38901a.d() + iE2;
            do {
                intArrayList.e(this.f38901a.x());
            } while (this.f38901a.d() < iD4);
            return;
        }
        if (iB2 != 5) {
            throw InvalidProtocolBufferException.e();
        }
        do {
            intArrayList.e(this.f38901a.x());
            if (this.f38901a.e()) {
                return;
            } else {
                iD2 = this.f38901a.D();
            }
        } while (iD2 == this.f38902b);
        this.f38904d = iD2;
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public int c() {
        return this.f38902b;
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public void d(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        if (!(list instanceof LongArrayList)) {
            int iB = WireFormat.b(this.f38902b);
            if (iB == 0) {
                do {
                    list.add(Long.valueOf(this.f38901a.A()));
                    if (this.f38901a.e()) {
                        return;
                    } else {
                        iD = this.f38901a.D();
                    }
                } while (iD == this.f38902b);
                this.f38904d = iD;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iD3 = this.f38901a.d() + this.f38901a.E();
            do {
                list.add(Long.valueOf(this.f38901a.A()));
            } while (this.f38901a.d() < iD3);
            X(iD3);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int iB2 = WireFormat.b(this.f38902b);
        if (iB2 == 0) {
            do {
                longArrayList.f(this.f38901a.A());
                if (this.f38901a.e()) {
                    return;
                } else {
                    iD2 = this.f38901a.D();
                }
            } while (iD2 == this.f38902b);
            this.f38904d = iD2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iD4 = this.f38901a.d() + this.f38901a.E();
        do {
            longArrayList.f(this.f38901a.A());
        } while (this.f38901a.d() < iD4);
        X(iD4);
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public boolean e() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(0);
        return this.f38901a.o();
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public long f() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(1);
        return this.f38901a.y();
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public void g(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        if (!(list instanceof LongArrayList)) {
            int iB = WireFormat.b(this.f38902b);
            if (iB == 0) {
                do {
                    list.add(Long.valueOf(this.f38901a.F()));
                    if (this.f38901a.e()) {
                        return;
                    } else {
                        iD = this.f38901a.D();
                    }
                } while (iD == this.f38902b);
                this.f38904d = iD;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iD3 = this.f38901a.d() + this.f38901a.E();
            do {
                list.add(Long.valueOf(this.f38901a.F()));
            } while (this.f38901a.d() < iD3);
            X(iD3);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int iB2 = WireFormat.b(this.f38902b);
        if (iB2 == 0) {
            do {
                longArrayList.f(this.f38901a.F());
                if (this.f38901a.e()) {
                    return;
                } else {
                    iD2 = this.f38901a.D();
                }
            } while (iD2 == this.f38902b);
            this.f38904d = iD2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iD4 = this.f38901a.d() + this.f38901a.E();
        do {
            longArrayList.f(this.f38901a.F());
        } while (this.f38901a.d() < iD4);
        X(iD4);
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public int h() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(0);
        return this.f38901a.E();
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public void i(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        if (!(list instanceof LongArrayList)) {
            int iB = WireFormat.b(this.f38902b);
            if (iB == 0) {
                do {
                    list.add(Long.valueOf(this.f38901a.w()));
                    if (this.f38901a.e()) {
                        return;
                    } else {
                        iD = this.f38901a.D();
                    }
                } while (iD == this.f38902b);
                this.f38904d = iD;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iD3 = this.f38901a.d() + this.f38901a.E();
            do {
                list.add(Long.valueOf(this.f38901a.w()));
            } while (this.f38901a.d() < iD3);
            X(iD3);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int iB2 = WireFormat.b(this.f38902b);
        if (iB2 == 0) {
            do {
                longArrayList.f(this.f38901a.w());
                if (this.f38901a.e()) {
                    return;
                } else {
                    iD2 = this.f38901a.D();
                }
            } while (iD2 == this.f38902b);
            this.f38904d = iD2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iD4 = this.f38901a.d() + this.f38901a.E();
        do {
            longArrayList.f(this.f38901a.w());
        } while (this.f38901a.d() < iD4);
        X(iD4);
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public void j(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        if (!(list instanceof IntArrayList)) {
            int iB = WireFormat.b(this.f38902b);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.f38901a.r()));
                    if (this.f38901a.e()) {
                        return;
                    } else {
                        iD = this.f38901a.D();
                    }
                } while (iD == this.f38902b);
                this.f38904d = iD;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iD3 = this.f38901a.d() + this.f38901a.E();
            do {
                list.add(Integer.valueOf(this.f38901a.r()));
            } while (this.f38901a.d() < iD3);
            X(iD3);
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iB2 = WireFormat.b(this.f38902b);
        if (iB2 == 0) {
            do {
                intArrayList.e(this.f38901a.r());
                if (this.f38901a.e()) {
                    return;
                } else {
                    iD2 = this.f38901a.D();
                }
            } while (iD2 == this.f38902b);
            this.f38904d = iD2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iD4 = this.f38901a.d() + this.f38901a.E();
        do {
            intArrayList.e(this.f38901a.r());
        } while (this.f38901a.d() < iD4);
        X(iD4);
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public int k() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(0);
        return this.f38901a.r();
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public int l() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(0);
        return this.f38901a.z();
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public void m(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        if (!(list instanceof BooleanArrayList)) {
            int iB = WireFormat.b(this.f38902b);
            if (iB == 0) {
                do {
                    list.add(Boolean.valueOf(this.f38901a.o()));
                    if (this.f38901a.e()) {
                        return;
                    } else {
                        iD = this.f38901a.D();
                    }
                } while (iD == this.f38902b);
                this.f38904d = iD;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iD3 = this.f38901a.d() + this.f38901a.E();
            do {
                list.add(Boolean.valueOf(this.f38901a.o()));
            } while (this.f38901a.d() < iD3);
            X(iD3);
            return;
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) list;
        int iB2 = WireFormat.b(this.f38902b);
        if (iB2 == 0) {
            do {
                booleanArrayList.f(this.f38901a.o());
                if (this.f38901a.e()) {
                    return;
                } else {
                    iD2 = this.f38901a.D();
                }
            } while (iD2 == this.f38902b);
            this.f38904d = iD2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iD4 = this.f38901a.d() + this.f38901a.E();
        do {
            booleanArrayList.f(this.f38901a.o());
        } while (this.f38901a.d() < iD4);
        X(iD4);
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public void n(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        W(list, true);
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public ByteString o() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(2);
        return this.f38901a.p();
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public int p() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(0);
        return this.f38901a.v();
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public void q(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        if (!(list instanceof LongArrayList)) {
            int iB = WireFormat.b(this.f38902b);
            if (iB == 1) {
                do {
                    list.add(Long.valueOf(this.f38901a.t()));
                    if (this.f38901a.e()) {
                        return;
                    } else {
                        iD = this.f38901a.D();
                    }
                } while (iD == this.f38902b);
                this.f38904d = iD;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iE = this.f38901a.E();
            a0(iE);
            int iD3 = this.f38901a.d() + iE;
            do {
                list.add(Long.valueOf(this.f38901a.t()));
            } while (this.f38901a.d() < iD3);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int iB2 = WireFormat.b(this.f38902b);
        if (iB2 == 1) {
            do {
                longArrayList.f(this.f38901a.t());
                if (this.f38901a.e()) {
                    return;
                } else {
                    iD2 = this.f38901a.D();
                }
            } while (iD2 == this.f38902b);
            this.f38904d = iD2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iE2 = this.f38901a.E();
        a0(iE2);
        int iD4 = this.f38901a.d() + iE2;
        do {
            longArrayList.f(this.f38901a.t());
        } while (this.f38901a.d() < iD4);
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public void r(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        if (!(list instanceof IntArrayList)) {
            int iB = WireFormat.b(this.f38902b);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.f38901a.z()));
                    if (this.f38901a.e()) {
                        return;
                    } else {
                        iD = this.f38901a.D();
                    }
                } while (iD == this.f38902b);
                this.f38904d = iD;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iD3 = this.f38901a.d() + this.f38901a.E();
            do {
                list.add(Integer.valueOf(this.f38901a.z()));
            } while (this.f38901a.d() < iD3);
            X(iD3);
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iB2 = WireFormat.b(this.f38902b);
        if (iB2 == 0) {
            do {
                intArrayList.e(this.f38901a.z());
                if (this.f38901a.e()) {
                    return;
                } else {
                    iD2 = this.f38901a.D();
                }
            } while (iD2 == this.f38902b);
            this.f38904d = iD2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iD4 = this.f38901a.d() + this.f38901a.E();
        do {
            intArrayList.e(this.f38901a.z());
        } while (this.f38901a.d() < iD4);
        X(iD4);
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public double readDouble() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(1);
        return this.f38901a.q();
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public float readFloat() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(5);
        return this.f38901a.u();
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public long s() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(0);
        return this.f38901a.F();
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public void t(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        if (!(list instanceof IntArrayList)) {
            int iB = WireFormat.b(this.f38902b);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.f38901a.E()));
                    if (this.f38901a.e()) {
                        return;
                    } else {
                        iD = this.f38901a.D();
                    }
                } while (iD == this.f38902b);
                this.f38904d = iD;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iD3 = this.f38901a.d() + this.f38901a.E();
            do {
                list.add(Integer.valueOf(this.f38901a.E()));
            } while (this.f38901a.d() < iD3);
            X(iD3);
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iB2 = WireFormat.b(this.f38902b);
        if (iB2 == 0) {
            do {
                intArrayList.e(this.f38901a.E());
                if (this.f38901a.e()) {
                    return;
                } else {
                    iD2 = this.f38901a.D();
                }
            } while (iD2 == this.f38902b);
            this.f38904d = iD2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iD4 = this.f38901a.d() + this.f38901a.E();
        do {
            intArrayList.e(this.f38901a.E());
        } while (this.f38901a.d() < iD4);
        X(iD4);
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public int u() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(5);
        return this.f38901a.s();
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public void v(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        if (!(list instanceof LongArrayList)) {
            int iB = WireFormat.b(this.f38902b);
            if (iB == 1) {
                do {
                    list.add(Long.valueOf(this.f38901a.y()));
                    if (this.f38901a.e()) {
                        return;
                    } else {
                        iD = this.f38901a.D();
                    }
                } while (iD == this.f38902b);
                this.f38904d = iD;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iE = this.f38901a.E();
            a0(iE);
            int iD3 = this.f38901a.d() + iE;
            do {
                list.add(Long.valueOf(this.f38901a.y()));
            } while (this.f38901a.d() < iD3);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int iB2 = WireFormat.b(this.f38902b);
        if (iB2 == 1) {
            do {
                longArrayList.f(this.f38901a.y());
                if (this.f38901a.e()) {
                    return;
                } else {
                    iD2 = this.f38901a.D();
                }
            } while (iD2 == this.f38902b);
            this.f38904d = iD2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iE2 = this.f38901a.E();
        a0(iE2);
        int iD4 = this.f38901a.d() + iE2;
        do {
            longArrayList.f(this.f38901a.y());
        } while (this.f38901a.d() < iD4);
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public void w(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        if (!(list instanceof IntArrayList)) {
            int iB = WireFormat.b(this.f38902b);
            if (iB == 0) {
                do {
                    list.add(Integer.valueOf(this.f38901a.v()));
                    if (this.f38901a.e()) {
                        return;
                    } else {
                        iD = this.f38901a.D();
                    }
                } while (iD == this.f38902b);
                this.f38904d = iD;
                return;
            }
            if (iB != 2) {
                throw InvalidProtocolBufferException.e();
            }
            int iD3 = this.f38901a.d() + this.f38901a.E();
            do {
                list.add(Integer.valueOf(this.f38901a.v()));
            } while (this.f38901a.d() < iD3);
            X(iD3);
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iB2 = WireFormat.b(this.f38902b);
        if (iB2 == 0) {
            do {
                intArrayList.e(this.f38901a.v());
                if (this.f38901a.e()) {
                    return;
                } else {
                    iD2 = this.f38901a.D();
                }
            } while (iD2 == this.f38902b);
            this.f38904d = iD2;
            return;
        }
        if (iB2 != 2) {
            throw InvalidProtocolBufferException.e();
        }
        int iD4 = this.f38901a.d() + this.f38901a.E();
        do {
            intArrayList.e(this.f38901a.v());
        } while (this.f38901a.d() < iD4);
        X(iD4);
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public void x(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        if (!(list instanceof IntArrayList)) {
            int iB = WireFormat.b(this.f38902b);
            if (iB == 2) {
                int iE = this.f38901a.E();
                Z(iE);
                int iD3 = this.f38901a.d() + iE;
                do {
                    list.add(Integer.valueOf(this.f38901a.s()));
                } while (this.f38901a.d() < iD3);
                return;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.e();
            }
            do {
                list.add(Integer.valueOf(this.f38901a.s()));
                if (this.f38901a.e()) {
                    return;
                } else {
                    iD = this.f38901a.D();
                }
            } while (iD == this.f38902b);
            this.f38904d = iD;
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iB2 = WireFormat.b(this.f38902b);
        if (iB2 == 2) {
            int iE2 = this.f38901a.E();
            Z(iE2);
            int iD4 = this.f38901a.d() + iE2;
            do {
                intArrayList.e(this.f38901a.s());
            } while (this.f38901a.d() < iD4);
            return;
        }
        if (iB2 != 5) {
            throw InvalidProtocolBufferException.e();
        }
        do {
            intArrayList.e(this.f38901a.s());
            if (this.f38901a.e()) {
                return;
            } else {
                iD2 = this.f38901a.D();
            }
        } while (iD2 == this.f38902b);
        this.f38904d = iD2;
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public long y() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(0);
        return this.f38901a.A();
    }

    @Override // androidx.glance.appwidget.protobuf.Reader
    public String z() throws InvalidProtocolBufferException.InvalidWireTypeException {
        Y(2);
        return this.f38901a.B();
    }
}
