package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ArrayDecoders;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class MessageSchema<T> implements Schema<T> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int[] f36512r = new int[0];

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final Unsafe f36513s = UnsafeUtil.I();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f36514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object[] f36515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f36516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f36517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MessageLite f36518e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f36519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f36520g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ProtoSyntax f36521h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f36522i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int[] f36523j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f36524k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f36525l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final NewInstanceSchema f36526m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ListFieldSchema f36527n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final UnknownFieldSchema f36528o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ExtensionSchema f36529p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final MapFieldSchema f36530q;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.MessageSchema$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f36531a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f36531a = iArr;
            try {
                iArr[WireFormat.FieldType.f36695k.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36531a[WireFormat.FieldType.f36699o.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36531a[WireFormat.FieldType.f36688c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f36531a[WireFormat.FieldType.f36694j.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f36531a[WireFormat.FieldType.f36702r.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f36531a[WireFormat.FieldType.f36693i.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f36531a[WireFormat.FieldType.f36703s.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f36531a[WireFormat.FieldType.f36689d.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f36531a[WireFormat.FieldType.f36701q.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f36531a[WireFormat.FieldType.f36692h.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f36531a[WireFormat.FieldType.f36700p.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f36531a[WireFormat.FieldType.f36690f.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f36531a[WireFormat.FieldType.f36691g.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f36531a[WireFormat.FieldType.f36698n.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f36531a[WireFormat.FieldType.f36704t.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f36531a[WireFormat.FieldType.f36705u.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f36531a[WireFormat.FieldType.f36696l.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i3, int i4, MessageLite messageLite, ProtoSyntax protoSyntax, boolean z2, int[] iArr2, int i5, int i6, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, MapFieldSchema mapFieldSchema) {
        this.f36514a = iArr;
        this.f36515b = objArr;
        this.f36516c = i3;
        this.f36517d = i4;
        this.f36520g = messageLite instanceof GeneratedMessageLite;
        this.f36521h = protoSyntax;
        this.f36519f = extensionSchema != null && extensionSchema.e(messageLite);
        this.f36522i = z2;
        this.f36523j = iArr2;
        this.f36524k = i5;
        this.f36525l = i6;
        this.f36526m = newInstanceSchema;
        this.f36527n = listFieldSchema;
        this.f36528o = unknownFieldSchema;
        this.f36529p = extensionSchema;
        this.f36518e = messageLite;
        this.f36530q = mapFieldSchema;
    }

    private boolean A(Object obj, int i3) {
        boolean zEquals;
        int iI0 = i0(i3);
        long j3 = 1048575 & iI0;
        if (j3 != 1048575) {
            return (UnsafeUtil.D(obj, j3) & (1 << (iI0 >>> 20))) != 0;
        }
        int iV0 = v0(i3);
        long jW = W(iV0);
        switch (u0(iV0)) {
            case 0:
                return Double.doubleToRawLongBits(UnsafeUtil.B(obj, jW)) != 0;
            case 1:
                return Float.floatToRawIntBits(UnsafeUtil.C(obj, jW)) != 0;
            case 2:
                return UnsafeUtil.F(obj, jW) != 0;
            case 3:
                return UnsafeUtil.F(obj, jW) != 0;
            case 4:
                return UnsafeUtil.D(obj, jW) != 0;
            case 5:
                return UnsafeUtil.F(obj, jW) != 0;
            case 6:
                return UnsafeUtil.D(obj, jW) != 0;
            case 7:
                return UnsafeUtil.u(obj, jW);
            case 8:
                Object objH = UnsafeUtil.H(obj, jW);
                if (objH instanceof String) {
                    zEquals = ((String) objH).isEmpty();
                } else {
                    if (!(objH instanceof ByteString)) {
                        throw new IllegalArgumentException();
                    }
                    zEquals = ByteString.f36020b.equals(objH);
                }
                break;
            case 9:
                return UnsafeUtil.H(obj, jW) != null;
            case 10:
                zEquals = ByteString.f36020b.equals(UnsafeUtil.H(obj, jW));
                break;
            case 11:
                return UnsafeUtil.D(obj, jW) != 0;
            case 12:
                return UnsafeUtil.D(obj, jW) != 0;
            case 13:
                return UnsafeUtil.D(obj, jW) != 0;
            case 14:
                return UnsafeUtil.F(obj, jW) != 0;
            case 15:
                return UnsafeUtil.D(obj, jW) != 0;
            case 16:
                return UnsafeUtil.F(obj, jW) != 0;
            case 17:
                return UnsafeUtil.H(obj, jW) != null;
            default:
                throw new IllegalArgumentException();
        }
        return !zEquals;
    }

    private void A0(UnknownFieldSchema unknownFieldSchema, Object obj, Writer writer) {
        unknownFieldSchema.t(unknownFieldSchema.g(obj), writer);
    }

    private boolean B(Object obj, int i3, int i4, int i5, int i6) {
        return i4 == 1048575 ? A(obj, i3) : (i5 & i6) != 0;
    }

    private static boolean C(Object obj, int i3, Schema schema) {
        return schema.c(UnsafeUtil.H(obj, W(i3)));
    }

    private static boolean D(int i3) {
        return (i3 & Integer.MIN_VALUE) != 0;
    }

    private boolean E(Object obj, int i3, int i4) {
        List list = (List) UnsafeUtil.H(obj, W(i3));
        if (list.isEmpty()) {
            return true;
        }
        Schema schemaV = v(i4);
        for (int i5 = 0; i5 < list.size(); i5++) {
            if (!schemaV.c(list.get(i5))) {
                return false;
            }
        }
        return true;
    }

    private boolean F(Object obj, int i3, int i4) {
        Map mapE = this.f36530q.e(UnsafeUtil.H(obj, W(i3)));
        if (mapE.isEmpty()) {
            return true;
        }
        if (this.f36530q.b(u(i4)).f36505c.a() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        Schema schemaC = null;
        for (Object obj2 : mapE.values()) {
            if (schemaC == null) {
                schemaC = Protobuf.a().c(obj2.getClass());
            }
            if (!schemaC.c(obj2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean G(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).I();
        }
        return true;
    }

    private boolean H(Object obj, Object obj2, int i3) {
        long jI0 = i0(i3) & 1048575;
        return UnsafeUtil.D(obj, jI0) == UnsafeUtil.D(obj2, jI0);
    }

    private boolean I(Object obj, int i3, int i4) {
        return UnsafeUtil.D(obj, (long) (i0(i4) & 1048575)) == i3;
    }

    private static boolean J(int i3) {
        return (i3 & 268435456) != 0;
    }

    private static long K(Object obj, long j3) {
        return UnsafeUtil.F(obj, j3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:339:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a8, code lost:
    
        r0 = r10.f36524k;
        r4 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ad, code lost:
    
        if (r0 >= r10.f36525l) goto L337;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00af, code lost:
    
        r4 = r10.q(r2, r10.f36523j[r0], r4, r5, r20);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c0, code lost:
    
        if (r4 == null) goto L339;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c2, code lost:
    
        r5.o(r2, r4);
     */
    /* JADX WARN: Removed duplicated region for block: B:241:0x06f7 A[Catch: all -> 0x0718, TRY_LEAVE, TryCatch #26 {all -> 0x0718, blocks: (B:239:0x06f1, B:241:0x06f7, B:252:0x071c, B:253:0x0721), top: B:295:0x06f1 }] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x071a  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0752 A[LOOP:4: B:266:0x074e->B:268:0x0752, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0765  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void L(androidx.datastore.preferences.protobuf.UnknownFieldSchema r18, androidx.datastore.preferences.protobuf.ExtensionSchema r19, java.lang.Object r20, androidx.datastore.preferences.protobuf.Reader r21, androidx.datastore.preferences.protobuf.ExtensionRegistryLite r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2040
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.L(androidx.datastore.preferences.protobuf.UnknownFieldSchema, androidx.datastore.preferences.protobuf.ExtensionSchema, java.lang.Object, androidx.datastore.preferences.protobuf.Reader, androidx.datastore.preferences.protobuf.ExtensionRegistryLite):void");
    }

    private final void M(Object obj, int i3, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) {
        long jW = W(v0(i3));
        Object objH = UnsafeUtil.H(obj, jW);
        if (objH == null) {
            objH = this.f36530q.d(obj2);
            UnsafeUtil.Y(obj, jW, objH);
        } else if (this.f36530q.h(objH)) {
            Object objD = this.f36530q.d(obj2);
            this.f36530q.a(objD, objH);
            UnsafeUtil.Y(obj, jW, objD);
            objH = objD;
        }
        reader.N(this.f36530q.c(objH), this.f36530q.b(obj2), extensionRegistryLite);
    }

    private void N(Object obj, Object obj2, int i3) {
        if (A(obj2, i3)) {
            long jW = W(v0(i3));
            Unsafe unsafe = f36513s;
            Object object = unsafe.getObject(obj2, jW);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + V(i3) + " is present but null: " + obj2);
            }
            Schema schemaV = v(i3);
            if (!A(obj, i3)) {
                if (G(object)) {
                    Object objNewInstance = schemaV.newInstance();
                    schemaV.a(objNewInstance, object);
                    unsafe.putObject(obj, jW, objNewInstance);
                } else {
                    unsafe.putObject(obj, jW, object);
                }
                o0(obj, i3);
                return;
            }
            Object object2 = unsafe.getObject(obj, jW);
            if (!G(object2)) {
                Object objNewInstance2 = schemaV.newInstance();
                schemaV.a(objNewInstance2, object2);
                unsafe.putObject(obj, jW, objNewInstance2);
                object2 = objNewInstance2;
            }
            schemaV.a(object2, object);
        }
    }

    private void O(Object obj, Object obj2, int i3) {
        int iV = V(i3);
        if (I(obj2, iV, i3)) {
            long jW = W(v0(i3));
            Unsafe unsafe = f36513s;
            Object object = unsafe.getObject(obj2, jW);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + V(i3) + " is present but null: " + obj2);
            }
            Schema schemaV = v(i3);
            if (!I(obj, iV, i3)) {
                if (G(object)) {
                    Object objNewInstance = schemaV.newInstance();
                    schemaV.a(objNewInstance, object);
                    unsafe.putObject(obj, jW, objNewInstance);
                } else {
                    unsafe.putObject(obj, jW, object);
                }
                p0(obj, iV, i3);
                return;
            }
            Object object2 = unsafe.getObject(obj, jW);
            if (!G(object2)) {
                Object objNewInstance2 = schemaV.newInstance();
                schemaV.a(objNewInstance2, object2);
                unsafe.putObject(obj, jW, objNewInstance2);
                object2 = objNewInstance2;
            }
            schemaV.a(object2, object);
        }
    }

    private void P(Object obj, Object obj2, int i3) {
        int iV0 = v0(i3);
        long jW = W(iV0);
        int iV = V(i3);
        switch (u0(iV0)) {
            case 0:
                if (A(obj2, i3)) {
                    UnsafeUtil.U(obj, jW, UnsafeUtil.B(obj2, jW));
                    o0(obj, i3);
                }
                break;
            case 1:
                if (A(obj2, i3)) {
                    UnsafeUtil.V(obj, jW, UnsafeUtil.C(obj2, jW));
                    o0(obj, i3);
                }
                break;
            case 2:
                if (A(obj2, i3)) {
                    UnsafeUtil.X(obj, jW, UnsafeUtil.F(obj2, jW));
                    o0(obj, i3);
                }
                break;
            case 3:
                if (A(obj2, i3)) {
                    UnsafeUtil.X(obj, jW, UnsafeUtil.F(obj2, jW));
                    o0(obj, i3);
                }
                break;
            case 4:
                if (A(obj2, i3)) {
                    UnsafeUtil.W(obj, jW, UnsafeUtil.D(obj2, jW));
                    o0(obj, i3);
                }
                break;
            case 5:
                if (A(obj2, i3)) {
                    UnsafeUtil.X(obj, jW, UnsafeUtil.F(obj2, jW));
                    o0(obj, i3);
                }
                break;
            case 6:
                if (A(obj2, i3)) {
                    UnsafeUtil.W(obj, jW, UnsafeUtil.D(obj2, jW));
                    o0(obj, i3);
                }
                break;
            case 7:
                if (A(obj2, i3)) {
                    UnsafeUtil.N(obj, jW, UnsafeUtil.u(obj2, jW));
                    o0(obj, i3);
                }
                break;
            case 8:
                if (A(obj2, i3)) {
                    UnsafeUtil.Y(obj, jW, UnsafeUtil.H(obj2, jW));
                    o0(obj, i3);
                }
                break;
            case 9:
                N(obj, obj2, i3);
                break;
            case 10:
                if (A(obj2, i3)) {
                    UnsafeUtil.Y(obj, jW, UnsafeUtil.H(obj2, jW));
                    o0(obj, i3);
                }
                break;
            case 11:
                if (A(obj2, i3)) {
                    UnsafeUtil.W(obj, jW, UnsafeUtil.D(obj2, jW));
                    o0(obj, i3);
                }
                break;
            case 12:
                if (A(obj2, i3)) {
                    UnsafeUtil.W(obj, jW, UnsafeUtil.D(obj2, jW));
                    o0(obj, i3);
                }
                break;
            case 13:
                if (A(obj2, i3)) {
                    UnsafeUtil.W(obj, jW, UnsafeUtil.D(obj2, jW));
                    o0(obj, i3);
                }
                break;
            case 14:
                if (A(obj2, i3)) {
                    UnsafeUtil.X(obj, jW, UnsafeUtil.F(obj2, jW));
                    o0(obj, i3);
                }
                break;
            case 15:
                if (A(obj2, i3)) {
                    UnsafeUtil.W(obj, jW, UnsafeUtil.D(obj2, jW));
                    o0(obj, i3);
                }
                break;
            case 16:
                if (A(obj2, i3)) {
                    UnsafeUtil.X(obj, jW, UnsafeUtil.F(obj2, jW));
                    o0(obj, i3);
                }
                break;
            case 17:
                N(obj, obj2, i3);
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.f36527n.b(obj, obj2, jW);
                break;
            case 50:
                SchemaUtil.F(this.f36530q, obj, obj2, jW);
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (I(obj2, iV, i3)) {
                    UnsafeUtil.Y(obj, jW, UnsafeUtil.H(obj2, jW));
                    p0(obj, iV, i3);
                }
                break;
            case 60:
                O(obj, obj2, i3);
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (I(obj2, iV, i3)) {
                    UnsafeUtil.Y(obj, jW, UnsafeUtil.H(obj2, jW));
                    p0(obj, iV, i3);
                }
                break;
            case 68:
                O(obj, obj2, i3);
                break;
        }
    }

    private Object Q(Object obj, int i3) {
        Schema schemaV = v(i3);
        long jW = W(v0(i3));
        if (!A(obj, i3)) {
            return schemaV.newInstance();
        }
        Object object = f36513s.getObject(obj, jW);
        if (G(object)) {
            return object;
        }
        Object objNewInstance = schemaV.newInstance();
        if (object != null) {
            schemaV.a(objNewInstance, object);
        }
        return objNewInstance;
    }

    private Object R(Object obj, int i3, int i4) {
        Schema schemaV = v(i4);
        if (!I(obj, i3, i4)) {
            return schemaV.newInstance();
        }
        Object object = f36513s.getObject(obj, W(v0(i4)));
        if (G(object)) {
            return object;
        }
        Object objNewInstance = schemaV.newInstance();
        if (object != null) {
            schemaV.a(objNewInstance, object);
        }
        return objNewInstance;
    }

    static MessageSchema S(Class cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, MapFieldSchema mapFieldSchema) {
        return messageInfo instanceof RawMessageInfo ? U((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema) : T((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    static MessageSchema T(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, MapFieldSchema mapFieldSchema) {
        int iE;
        int iE2;
        int i3;
        FieldInfo[] fieldInfoArrE = structuralMessageInfo.e();
        if (fieldInfoArrE.length == 0) {
            iE = 0;
            iE2 = 0;
        } else {
            iE = fieldInfoArrE[0].e();
            iE2 = fieldInfoArrE[fieldInfoArrE.length - 1].e();
        }
        int length = fieldInfoArrE.length;
        int[] iArr = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        int i4 = 0;
        int i5 = 0;
        for (FieldInfo fieldInfo : fieldInfoArrE) {
            if (fieldInfo.k() == FieldType.f36352e0) {
                i4++;
            } else if (fieldInfo.k().a() >= 18 && fieldInfo.k().a() <= 49) {
                i5++;
            }
        }
        int[] iArr2 = i4 > 0 ? new int[i4] : null;
        int[] iArr3 = i5 > 0 ? new int[i5] : null;
        int[] iArrD = structuralMessageInfo.d();
        if (iArrD == null) {
            iArrD = f36512r;
        }
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i6 < fieldInfoArrE.length) {
            FieldInfo fieldInfo2 = fieldInfoArrE[i6];
            int iE3 = fieldInfo2.e();
            r0(fieldInfo2, iArr, i7, objArr);
            if (i8 < iArrD.length && iArrD[i8] == iE3) {
                iArrD[i8] = i7;
                i8++;
            }
            if (fieldInfo2.k() == FieldType.f36352e0) {
                iArr2[i9] = i7;
                i9++;
            } else {
                if (fieldInfo2.k().a() >= 18 && fieldInfo2.k().a() <= 49) {
                    i3 = i7;
                    iArr3[i10] = (int) UnsafeUtil.M(fieldInfo2.d());
                    i10++;
                }
                i6++;
                i7 = i3 + 3;
            }
            i3 = i7;
            i6++;
            i7 = i3 + 3;
        }
        if (iArr2 == null) {
            iArr2 = f36512r;
        }
        if (iArr3 == null) {
            iArr3 = f36512r;
        }
        int[] iArr4 = new int[iArrD.length + iArr2.length + iArr3.length];
        System.arraycopy(iArrD, 0, iArr4, 0, iArrD.length);
        System.arraycopy(iArr2, 0, iArr4, iArrD.length, iArr2.length);
        System.arraycopy(iArr3, 0, iArr4, iArrD.length + iArr2.length, iArr3.length);
        return new MessageSchema(iArr, objArr, iE, iE2, structuralMessageInfo.b(), structuralMessageInfo.c(), true, iArr4, iArrD.length, iArrD.length + iArr2.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0375  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static androidx.datastore.preferences.protobuf.MessageSchema U(androidx.datastore.preferences.protobuf.RawMessageInfo r33, androidx.datastore.preferences.protobuf.NewInstanceSchema r34, androidx.datastore.preferences.protobuf.ListFieldSchema r35, androidx.datastore.preferences.protobuf.UnknownFieldSchema r36, androidx.datastore.preferences.protobuf.ExtensionSchema r37, androidx.datastore.preferences.protobuf.MapFieldSchema r38) {
        /*
            Method dump skipped, instruction units count: 1008
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.U(androidx.datastore.preferences.protobuf.RawMessageInfo, androidx.datastore.preferences.protobuf.NewInstanceSchema, androidx.datastore.preferences.protobuf.ListFieldSchema, androidx.datastore.preferences.protobuf.UnknownFieldSchema, androidx.datastore.preferences.protobuf.ExtensionSchema, androidx.datastore.preferences.protobuf.MapFieldSchema):androidx.datastore.preferences.protobuf.MessageSchema");
    }

    private int V(int i3) {
        return this.f36514a[i3];
    }

    private static long W(int i3) {
        return i3 & 1048575;
    }

    private static boolean X(Object obj, long j3) {
        return ((Boolean) UnsafeUtil.H(obj, j3)).booleanValue();
    }

    private static double Y(Object obj, long j3) {
        return ((Double) UnsafeUtil.H(obj, j3)).doubleValue();
    }

    private static float Z(Object obj, long j3) {
        return ((Float) UnsafeUtil.H(obj, j3)).floatValue();
    }

    private static int a0(Object obj, long j3) {
        return ((Integer) UnsafeUtil.H(obj, j3)).intValue();
    }

    private static long b0(Object obj, long j3) {
        return ((Long) UnsafeUtil.H(obj, j3)).longValue();
    }

    private int c0(Object obj, byte[] bArr, int i3, int i4, int i5, long j3, ArrayDecoders.Registers registers) {
        Unsafe unsafe = f36513s;
        Object objU = u(i5);
        Object object = unsafe.getObject(obj, j3);
        if (this.f36530q.h(object)) {
            Object objD = this.f36530q.d(objU);
            this.f36530q.a(objD, object);
            unsafe.putObject(obj, j3, objD);
            object = objD;
        }
        return m(bArr, i3, i4, this.f36530q.b(objU), this.f36530q.c(object), registers);
    }

    private int e0(Object obj, byte[] bArr, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j3, int i10, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        Unsafe unsafe = f36513s;
        long j4 = this.f36514a[i10 + 2] & 1048575;
        switch (i9) {
            case 51:
                if (i7 != 1) {
                    return i3;
                }
                unsafe.putObject(obj, j3, Double.valueOf(ArrayDecoders.e(bArr, i3)));
                int i11 = i3 + 8;
                unsafe.putInt(obj, j4, i6);
                return i11;
            case 52:
                if (i7 != 5) {
                    return i3;
                }
                unsafe.putObject(obj, j3, Float.valueOf(ArrayDecoders.m(bArr, i3)));
                int i12 = i3 + 4;
                unsafe.putInt(obj, j4, i6);
                return i12;
            case 53:
            case 54:
                if (i7 != 0) {
                    return i3;
                }
                int iM = ArrayDecoders.M(bArr, i3, registers);
                unsafe.putObject(obj, j3, Long.valueOf(registers.f35975b));
                unsafe.putInt(obj, j4, i6);
                return iM;
            case 55:
            case 62:
                if (i7 != 0) {
                    return i3;
                }
                int iJ = ArrayDecoders.J(bArr, i3, registers);
                unsafe.putObject(obj, j3, Integer.valueOf(registers.f35974a));
                unsafe.putInt(obj, j4, i6);
                return iJ;
            case 56:
            case 65:
                if (i7 != 1) {
                    return i3;
                }
                unsafe.putObject(obj, j3, Long.valueOf(ArrayDecoders.k(bArr, i3)));
                int i13 = i3 + 8;
                unsafe.putInt(obj, j4, i6);
                return i13;
            case 57:
            case 64:
                if (i7 != 5) {
                    return i3;
                }
                unsafe.putObject(obj, j3, Integer.valueOf(ArrayDecoders.i(bArr, i3)));
                int i14 = i3 + 4;
                unsafe.putInt(obj, j4, i6);
                return i14;
            case 58:
                if (i7 != 0) {
                    return i3;
                }
                int iM2 = ArrayDecoders.M(bArr, i3, registers);
                unsafe.putObject(obj, j3, Boolean.valueOf(registers.f35975b != 0));
                unsafe.putInt(obj, j4, i6);
                return iM2;
            case 59:
                if (i7 != 2) {
                    return i3;
                }
                int iJ2 = ArrayDecoders.J(bArr, i3, registers);
                int i15 = registers.f35974a;
                if (i15 == 0) {
                    unsafe.putObject(obj, j3, "");
                } else {
                    if ((i8 & 536870912) != 0 && !Utf8.u(bArr, iJ2, iJ2 + i15)) {
                        throw InvalidProtocolBufferException.d();
                    }
                    unsafe.putObject(obj, j3, new String(bArr, iJ2, i15, Internal.f36424b));
                    iJ2 += i15;
                }
                unsafe.putInt(obj, j4, i6);
                return iJ2;
            case 60:
                if (i7 != 2) {
                    return i3;
                }
                Object objR = R(obj, i6, i10);
                int iP = ArrayDecoders.P(objR, v(i10), bArr, i3, i4, registers);
                t0(obj, i6, i10, objR);
                return iP;
            case 61:
                if (i7 != 2) {
                    return i3;
                }
                int iC = ArrayDecoders.c(bArr, i3, registers);
                unsafe.putObject(obj, j3, registers.f35976c);
                unsafe.putInt(obj, j4, i6);
                return iC;
            case 63:
                if (i7 != 0) {
                    return i3;
                }
                int iJ3 = ArrayDecoders.J(bArr, i3, registers);
                int i16 = registers.f35974a;
                Internal.EnumVerifier enumVerifierT = t(i10);
                if (enumVerifierT != null && !enumVerifierT.a(i16)) {
                    w(obj).n(i5, Long.valueOf(i16));
                    return iJ3;
                }
                unsafe.putObject(obj, j3, Integer.valueOf(i16));
                unsafe.putInt(obj, j4, i6);
                return iJ3;
            case 66:
                if (i7 != 0) {
                    return i3;
                }
                int iJ4 = ArrayDecoders.J(bArr, i3, registers);
                unsafe.putObject(obj, j3, Integer.valueOf(CodedInputStream.c(registers.f35974a)));
                unsafe.putInt(obj, j4, i6);
                return iJ4;
            case 67:
                if (i7 != 0) {
                    return i3;
                }
                int iM3 = ArrayDecoders.M(bArr, i3, registers);
                unsafe.putObject(obj, j3, Long.valueOf(CodedInputStream.d(registers.f35975b)));
                unsafe.putInt(obj, j4, i6);
                return iM3;
            case 68:
                if (i7 == 3) {
                    Object objR2 = R(obj, i6, i10);
                    int iO = ArrayDecoders.O(objR2, v(i10), bArr, i3, i4, (i5 & (-8)) | 4, registers);
                    t0(obj, i6, i10, objR2);
                    return iO;
                }
                break;
        }
        return i3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int f0(Object obj, byte[] bArr, int i3, int i4, int i5, int i6, int i7, int i8, long j3, int i9, long j4, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        int iK;
        Unsafe unsafe = f36513s;
        Internal.ProtobufList protobufListC = (Internal.ProtobufList) unsafe.getObject(obj, j4);
        if (!protobufListC.m()) {
            int size = protobufListC.size();
            protobufListC = protobufListC.c(size == 0 ? 10 : size * 2);
            unsafe.putObject(obj, j4, protobufListC);
        }
        Internal.ProtobufList protobufList = protobufListC;
        switch (i9) {
            case 18:
            case 35:
                if (i7 == 2) {
                    return ArrayDecoders.t(bArr, i3, protobufList, registers);
                }
                if (i7 == 1) {
                    return ArrayDecoders.f(i5, bArr, i3, i4, protobufList, registers);
                }
                return i3;
            case 19:
            case 36:
                if (i7 == 2) {
                    return ArrayDecoders.w(bArr, i3, protobufList, registers);
                }
                if (i7 == 5) {
                    return ArrayDecoders.n(i5, bArr, i3, i4, protobufList, registers);
                }
                return i3;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i7 == 2) {
                    return ArrayDecoders.A(bArr, i3, protobufList, registers);
                }
                if (i7 == 0) {
                    return ArrayDecoders.N(i5, bArr, i3, i4, protobufList, registers);
                }
                return i3;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i7 == 2) {
                    return ArrayDecoders.z(bArr, i3, protobufList, registers);
                }
                if (i7 == 0) {
                    return ArrayDecoders.K(i5, bArr, i3, i4, protobufList, registers);
                }
                return i3;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i7 == 2) {
                    return ArrayDecoders.v(bArr, i3, protobufList, registers);
                }
                if (i7 == 1) {
                    return ArrayDecoders.l(i5, bArr, i3, i4, protobufList, registers);
                }
                return i3;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i7 == 2) {
                    return ArrayDecoders.u(bArr, i3, protobufList, registers);
                }
                if (i7 == 5) {
                    return ArrayDecoders.j(i5, bArr, i3, i4, protobufList, registers);
                }
                return i3;
            case 25:
            case 42:
                if (i7 == 2) {
                    return ArrayDecoders.s(bArr, i3, protobufList, registers);
                }
                if (i7 == 0) {
                    return ArrayDecoders.b(i5, bArr, i3, i4, protobufList, registers);
                }
                return i3;
            case 26:
                if (i7 == 2) {
                    return (j3 & 536870912) == 0 ? ArrayDecoders.E(i5, bArr, i3, i4, protobufList, registers) : ArrayDecoders.F(i5, bArr, i3, i4, protobufList, registers);
                }
                return i3;
            case 27:
                if (i7 == 2) {
                    return ArrayDecoders.r(v(i8), i5, bArr, i3, i4, protobufList, registers);
                }
                return i3;
            case 28:
                if (i7 == 2) {
                    return ArrayDecoders.d(i5, bArr, i3, i4, protobufList, registers);
                }
                return i3;
            case 30:
            case 44:
                if (i7 != 2) {
                    if (i7 == 0) {
                        iK = ArrayDecoders.K(i5, bArr, i3, i4, protobufList, registers);
                    }
                    return i3;
                }
                iK = ArrayDecoders.z(bArr, i3, protobufList, registers);
                SchemaUtil.A(obj, i6, protobufList, t(i8), null, this.f36528o);
                return iK;
            case 33:
            case 47:
                if (i7 == 2) {
                    return ArrayDecoders.x(bArr, i3, protobufList, registers);
                }
                if (i7 == 0) {
                    return ArrayDecoders.B(i5, bArr, i3, i4, protobufList, registers);
                }
                return i3;
            case 34:
            case 48:
                if (i7 == 2) {
                    return ArrayDecoders.y(bArr, i3, protobufList, registers);
                }
                if (i7 == 0) {
                    return ArrayDecoders.C(i5, bArr, i3, i4, protobufList, registers);
                }
                return i3;
            case 49:
                if (i7 == 3) {
                    return ArrayDecoders.p(v(i8), i5, bArr, i3, i4, protobufList, registers);
                }
                return i3;
            default:
                return i3;
        }
    }

    private int g0(int i3) {
        if (i3 < this.f36516c || i3 > this.f36517d) {
            return -1;
        }
        return q0(i3, 0);
    }

    private int h0(int i3, int i4) {
        if (i3 < this.f36516c || i3 > this.f36517d) {
            return -1;
        }
        return q0(i3, i4);
    }

    private int i0(int i3) {
        return this.f36514a[i3 + 2];
    }

    private boolean j(Object obj, Object obj2, int i3) {
        return A(obj, i3) == A(obj2, i3);
    }

    private void j0(Object obj, long j3, Reader reader, Schema schema, ExtensionRegistryLite extensionRegistryLite) {
        reader.P(this.f36527n.c(obj, j3), schema, extensionRegistryLite);
    }

    private static boolean k(Object obj, long j3) {
        return UnsafeUtil.u(obj, j3);
    }

    private void k0(Object obj, int i3, Reader reader, Schema schema, ExtensionRegistryLite extensionRegistryLite) {
        reader.K(this.f36527n.c(obj, W(i3)), schema, extensionRegistryLite);
    }

    private static void l(Object obj) {
        if (G(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + obj);
    }

    private void l0(Object obj, int i3, Reader reader) {
        if (z(i3)) {
            UnsafeUtil.Y(obj, W(i3), reader.I());
        } else if (this.f36520g) {
            UnsafeUtil.Y(obj, W(i3), reader.z());
        } else {
            UnsafeUtil.Y(obj, W(i3), reader.o());
        }
    }

    private int m(byte[] bArr, int i3, int i4, MapEntryLite.Metadata metadata, Map map, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        int iJ = ArrayDecoders.J(bArr, i3, registers);
        int i5 = registers.f35974a;
        if (i5 < 0 || i5 > i4 - iJ) {
            throw InvalidProtocolBufferException.m();
        }
        int i6 = iJ + i5;
        Object obj = metadata.f36504b;
        Object obj2 = metadata.f36506d;
        while (iJ < i6) {
            int I = iJ + 1;
            int i7 = bArr[iJ];
            if (i7 < 0) {
                I = ArrayDecoders.I(i7, bArr, I, registers);
                i7 = registers.f35974a;
            }
            int i8 = I;
            int i9 = i7 >>> 3;
            int i10 = i7 & 7;
            if (i9 != 1) {
                if (i9 == 2 && i10 == metadata.f36505c.b()) {
                    iJ = n(bArr, i8, i4, metadata.f36505c, metadata.f36506d.getClass(), registers);
                    obj2 = registers.f35976c;
                } else {
                    iJ = ArrayDecoders.Q(i7, bArr, i8, i4, registers);
                }
            } else if (i10 == metadata.f36503a.b()) {
                iJ = n(bArr, i8, i4, metadata.f36503a, null, registers);
                obj = registers.f35976c;
            } else {
                iJ = ArrayDecoders.Q(i7, bArr, i8, i4, registers);
            }
        }
        if (iJ != i6) {
            throw InvalidProtocolBufferException.h();
        }
        map.put(obj, obj2);
        return i6;
    }

    private void m0(Object obj, int i3, Reader reader) {
        if (z(i3)) {
            reader.n(this.f36527n.c(obj, W(i3)));
        } else {
            reader.B(this.f36527n.c(obj, W(i3)));
        }
    }

    private int n(byte[] bArr, int i3, int i4, WireFormat.FieldType fieldType, Class cls, ArrayDecoders.Registers registers) {
        switch (AnonymousClass1.f36531a[fieldType.ordinal()]) {
            case 1:
                int iM = ArrayDecoders.M(bArr, i3, registers);
                registers.f35976c = Boolean.valueOf(registers.f35975b != 0);
                return iM;
            case 2:
                return ArrayDecoders.c(bArr, i3, registers);
            case 3:
                registers.f35976c = Double.valueOf(ArrayDecoders.e(bArr, i3));
                return i3 + 8;
            case 4:
            case 5:
                registers.f35976c = Integer.valueOf(ArrayDecoders.i(bArr, i3));
                return i3 + 4;
            case 6:
            case 7:
                registers.f35976c = Long.valueOf(ArrayDecoders.k(bArr, i3));
                return i3 + 8;
            case 8:
                registers.f35976c = Float.valueOf(ArrayDecoders.m(bArr, i3));
                return i3 + 4;
            case 9:
            case 10:
            case 11:
                int iJ = ArrayDecoders.J(bArr, i3, registers);
                registers.f35976c = Integer.valueOf(registers.f35974a);
                return iJ;
            case 12:
            case 13:
                int iM2 = ArrayDecoders.M(bArr, i3, registers);
                registers.f35976c = Long.valueOf(registers.f35975b);
                return iM2;
            case 14:
                return ArrayDecoders.q(Protobuf.a().c(cls), bArr, i3, i4, registers);
            case 15:
                int iJ2 = ArrayDecoders.J(bArr, i3, registers);
                registers.f35976c = Integer.valueOf(CodedInputStream.c(registers.f35974a));
                return iJ2;
            case 16:
                int iM3 = ArrayDecoders.M(bArr, i3, registers);
                registers.f35976c = Long.valueOf(CodedInputStream.d(registers.f35975b));
                return iM3;
            case 17:
                return ArrayDecoders.G(bArr, i3, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static java.lang.reflect.Field n0(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
            for (java.lang.reflect.Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static double o(Object obj, long j3) {
        return UnsafeUtil.B(obj, j3);
    }

    private void o0(Object obj, int i3) {
        int iI0 = i0(i3);
        long j3 = 1048575 & iI0;
        if (j3 == 1048575) {
            return;
        }
        UnsafeUtil.W(obj, j3, (1 << (iI0 >>> 20)) | UnsafeUtil.D(obj, j3));
    }

    private boolean p(Object obj, Object obj2, int i3) {
        int iV0 = v0(i3);
        long jW = W(iV0);
        switch (u0(iV0)) {
            case 0:
                if (!j(obj, obj2, i3) || Double.doubleToLongBits(UnsafeUtil.B(obj, jW)) != Double.doubleToLongBits(UnsafeUtil.B(obj2, jW))) {
                }
                break;
            case 1:
                if (!j(obj, obj2, i3) || Float.floatToIntBits(UnsafeUtil.C(obj, jW)) != Float.floatToIntBits(UnsafeUtil.C(obj2, jW))) {
                }
                break;
            case 2:
                if (!j(obj, obj2, i3) || UnsafeUtil.F(obj, jW) != UnsafeUtil.F(obj2, jW)) {
                }
                break;
            case 3:
                if (!j(obj, obj2, i3) || UnsafeUtil.F(obj, jW) != UnsafeUtil.F(obj2, jW)) {
                }
                break;
            case 4:
                if (!j(obj, obj2, i3) || UnsafeUtil.D(obj, jW) != UnsafeUtil.D(obj2, jW)) {
                }
                break;
            case 5:
                if (!j(obj, obj2, i3) || UnsafeUtil.F(obj, jW) != UnsafeUtil.F(obj2, jW)) {
                }
                break;
            case 6:
                if (!j(obj, obj2, i3) || UnsafeUtil.D(obj, jW) != UnsafeUtil.D(obj2, jW)) {
                }
                break;
            case 7:
                if (!j(obj, obj2, i3) || UnsafeUtil.u(obj, jW) != UnsafeUtil.u(obj2, jW)) {
                }
                break;
            case 8:
                if (!j(obj, obj2, i3) || !SchemaUtil.I(UnsafeUtil.H(obj, jW), UnsafeUtil.H(obj2, jW))) {
                }
                break;
            case 9:
                if (!j(obj, obj2, i3) || !SchemaUtil.I(UnsafeUtil.H(obj, jW), UnsafeUtil.H(obj2, jW))) {
                }
                break;
            case 10:
                if (!j(obj, obj2, i3) || !SchemaUtil.I(UnsafeUtil.H(obj, jW), UnsafeUtil.H(obj2, jW))) {
                }
                break;
            case 11:
                if (!j(obj, obj2, i3) || UnsafeUtil.D(obj, jW) != UnsafeUtil.D(obj2, jW)) {
                }
                break;
            case 12:
                if (!j(obj, obj2, i3) || UnsafeUtil.D(obj, jW) != UnsafeUtil.D(obj2, jW)) {
                }
                break;
            case 13:
                if (!j(obj, obj2, i3) || UnsafeUtil.D(obj, jW) != UnsafeUtil.D(obj2, jW)) {
                }
                break;
            case 14:
                if (!j(obj, obj2, i3) || UnsafeUtil.F(obj, jW) != UnsafeUtil.F(obj2, jW)) {
                }
                break;
            case 15:
                if (!j(obj, obj2, i3) || UnsafeUtil.D(obj, jW) != UnsafeUtil.D(obj2, jW)) {
                }
                break;
            case 16:
                if (!j(obj, obj2, i3) || UnsafeUtil.F(obj, jW) != UnsafeUtil.F(obj2, jW)) {
                }
                break;
            case 17:
                if (!j(obj, obj2, i3) || !SchemaUtil.I(UnsafeUtil.H(obj, jW), UnsafeUtil.H(obj2, jW))) {
                }
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                if (!H(obj, obj2, i3) || !SchemaUtil.I(UnsafeUtil.H(obj, jW), UnsafeUtil.H(obj2, jW))) {
                }
                break;
        }
        return true;
    }

    private void p0(Object obj, int i3, int i4) {
        UnsafeUtil.W(obj, i0(i4) & 1048575, i3);
    }

    private Object q(Object obj, int i3, Object obj2, UnknownFieldSchema unknownFieldSchema, Object obj3) {
        Internal.EnumVerifier enumVerifierT;
        int iV = V(i3);
        Object objH = UnsafeUtil.H(obj, W(v0(i3)));
        return (objH == null || (enumVerifierT = t(i3)) == null) ? obj2 : r(i3, iV, this.f36530q.c(objH), enumVerifierT, obj2, unknownFieldSchema, obj3);
    }

    private int q0(int i3, int i4) {
        int length = (this.f36514a.length / 3) - 1;
        while (i4 <= length) {
            int i5 = (length + i4) >>> 1;
            int i6 = i5 * 3;
            int iV = V(i6);
            if (i3 == iV) {
                return i6;
            }
            if (i3 < iV) {
                length = i5 - 1;
            } else {
                i4 = i5 + 1;
            }
        }
        return -1;
    }

    private Object r(int i3, int i4, Map map, Internal.EnumVerifier enumVerifier, Object obj, UnknownFieldSchema unknownFieldSchema, Object obj2) {
        MapEntryLite.Metadata metadataB = this.f36530q.b(u(i3));
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!enumVerifier.a(((Integer) entry.getValue()).intValue())) {
                if (obj == null) {
                    obj = unknownFieldSchema.f(obj2);
                }
                ByteString.CodedBuilder codedBuilderA = ByteString.A(MapEntryLite.b(metadataB, entry.getKey(), entry.getValue()));
                try {
                    MapEntryLite.e(codedBuilderA.b(), metadataB, entry.getKey(), entry.getValue());
                    unknownFieldSchema.d(obj, i4, codedBuilderA.a());
                    it.remove();
                } catch (IOException e3) {
                    throw new RuntimeException(e3);
                }
            }
        }
        return obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void r0(androidx.datastore.preferences.protobuf.FieldInfo r8, int[] r9, int r10, java.lang.Object[] r11) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.r0(androidx.datastore.preferences.protobuf.FieldInfo, int[], int, java.lang.Object[]):void");
    }

    private static float s(Object obj, long j3) {
        return UnsafeUtil.C(obj, j3);
    }

    private void s0(Object obj, int i3, Object obj2) {
        f36513s.putObject(obj, W(v0(i3)), obj2);
        o0(obj, i3);
    }

    private Internal.EnumVerifier t(int i3) {
        return (Internal.EnumVerifier) this.f36515b[((i3 / 3) * 2) + 1];
    }

    private void t0(Object obj, int i3, int i4, Object obj2) {
        f36513s.putObject(obj, W(v0(i4)), obj2);
        p0(obj, i3, i4);
    }

    private Object u(int i3) {
        return this.f36515b[(i3 / 3) * 2];
    }

    private static int u0(int i3) {
        return (i3 & 267386880) >>> 20;
    }

    private Schema v(int i3) {
        int i4 = (i3 / 3) * 2;
        Schema schema = (Schema) this.f36515b[i4];
        if (schema != null) {
            return schema;
        }
        Schema schemaC = Protobuf.a().c((Class) this.f36515b[i4 + 1]);
        this.f36515b[i4] = schemaC;
        return schemaC;
    }

    private int v0(int i3) {
        return this.f36514a[i3 + 1];
    }

    static UnknownFieldSetLite w(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.c()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite unknownFieldSetLiteK = UnknownFieldSetLite.k();
        generatedMessageLite.unknownFields = unknownFieldSetLiteK;
        return unknownFieldSetLiteK;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void w0(java.lang.Object r19, androidx.datastore.preferences.protobuf.Writer r20) {
        /*
            Method dump skipped, instruction units count: 1424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.w0(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    private int x(UnknownFieldSchema unknownFieldSchema, Object obj) {
        return unknownFieldSchema.h(unknownFieldSchema.g(obj));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void x0(java.lang.Object r11, androidx.datastore.preferences.protobuf.Writer r12) {
        /*
            Method dump skipped, instruction units count: 1586
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.x0(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    private static int y(Object obj, long j3) {
        return UnsafeUtil.D(obj, j3);
    }

    private void y0(Writer writer, int i3, Object obj, int i4) {
        if (obj != null) {
            writer.N(i3, this.f36530q.b(u(i4)), this.f36530q.e(obj));
        }
    }

    private static boolean z(int i3) {
        return (i3 & 536870912) != 0;
    }

    private void z0(int i3, Object obj, Writer writer) {
        if (obj instanceof String) {
            writer.e(i3, (String) obj);
        } else {
            writer.L(i3, (ByteString) obj);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void a(Object obj, Object obj2) {
        l(obj);
        obj2.getClass();
        for (int i3 = 0; i3 < this.f36514a.length; i3 += 3) {
            P(obj, obj2, i3);
        }
        SchemaUtil.G(this.f36528o, obj, obj2);
        if (this.f36519f) {
            SchemaUtil.E(this.f36529p, obj, obj2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
    @Override // androidx.datastore.preferences.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(java.lang.Object r8) {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.b(java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x007c  */
    @Override // androidx.datastore.preferences.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean c(java.lang.Object r15) {
        /*
            r14 = this;
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r1 = 0
            r3 = r0
            r2 = r1
            r4 = r2
        L7:
            int r5 = r14.f36524k
            r6 = 1
            if (r2 >= r5) goto L9b
            int[] r5 = r14.f36523j
            r9 = r5[r2]
            int r5 = r14.V(r9)
            int r13 = r14.v0(r9)
            int[] r7 = r14.f36514a
            int r8 = r9 + 2
            r7 = r7[r8]
            r8 = r7 & r0
            int r7 = r7 >>> 20
            int r12 = r6 << r7
            if (r8 == r3) goto L32
            if (r8 == r0) goto L2f
            sun.misc.Unsafe r3 = androidx.datastore.preferences.protobuf.MessageSchema.f36513s
            long r6 = (long) r8
            int r4 = r3.getInt(r15, r6)
        L2f:
            r11 = r4
            r10 = r8
            goto L34
        L32:
            r10 = r3
            r11 = r4
        L34:
            boolean r3 = J(r13)
            r7 = r14
            r8 = r15
            if (r3 == 0) goto L43
            boolean r15 = r7.B(r8, r9, r10, r11, r12)
            if (r15 != 0) goto L43
            return r1
        L43:
            int r15 = u0(r13)
            r3 = 9
            if (r15 == r3) goto L83
            r3 = 17
            if (r15 == r3) goto L83
            r3 = 27
            if (r15 == r3) goto L7c
            r3 = 60
            if (r15 == r3) goto L6b
            r3 = 68
            if (r15 == r3) goto L6b
            r3 = 49
            if (r15 == r3) goto L7c
            r3 = 50
            if (r15 == r3) goto L64
            goto L94
        L64:
            boolean r15 = r14.F(r8, r13, r9)
            if (r15 != 0) goto L94
            return r1
        L6b:
            boolean r15 = r14.I(r8, r5, r9)
            if (r15 == 0) goto L94
            androidx.datastore.preferences.protobuf.Schema r15 = r14.v(r9)
            boolean r15 = C(r8, r13, r15)
            if (r15 != 0) goto L94
            return r1
        L7c:
            boolean r15 = r14.E(r8, r13, r9)
            if (r15 != 0) goto L94
            return r1
        L83:
            boolean r15 = r7.B(r8, r9, r10, r11, r12)
            if (r15 == 0) goto L94
            androidx.datastore.preferences.protobuf.Schema r15 = r14.v(r9)
            boolean r15 = C(r8, r13, r15)
            if (r15 != 0) goto L94
            return r1
        L94:
            int r2 = r2 + 1
            r15 = r8
            r3 = r10
            r4 = r11
            goto L7
        L9b:
            r7 = r14
            r8 = r15
            boolean r15 = r7.f36519f
            if (r15 == 0) goto Lae
            androidx.datastore.preferences.protobuf.ExtensionSchema r15 = r7.f36529p
            androidx.datastore.preferences.protobuf.FieldSet r15 = r15.c(r8)
            boolean r15 = r15.p()
            if (r15 != 0) goto Lae
            return r1
        Lae:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.c(java.lang.Object):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.datastore.preferences.protobuf.Schema
    public int d(Object obj) {
        int i3;
        int iA0;
        int iI0;
        int iP0;
        int i4;
        int iM0;
        int iO0;
        MessageSchema<T> messageSchema = this;
        Object obj2 = obj;
        Unsafe unsafe = f36513s;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 1048575;
        while (i6 < messageSchema.f36514a.length) {
            int iV0 = messageSchema.v0(i6);
            int iU0 = u0(iV0);
            int iV = messageSchema.V(i6);
            int i10 = messageSchema.f36514a[i6 + 2];
            int i11 = i10 & i5;
            if (iU0 <= 17) {
                if (i11 != i9) {
                    i7 = i11 == i5 ? 0 : unsafe.getInt(obj2, i11);
                    i9 = i11;
                }
                i3 = 1 << (i10 >>> 20);
            } else {
                i3 = 0;
            }
            int i12 = i8;
            long jW = W(iV0);
            if (iU0 < FieldType.P.a() || iU0 > FieldType.f36350c0.a()) {
                i11 = 0;
            }
            switch (iU0) {
                case 0:
                    if (messageSchema.B(obj2, i6, i9, i7, i3)) {
                        iA0 = CodedOutputStream.a0(iV, 0.0d);
                        i8 = i12 + iA0;
                    }
                    i8 = i12;
                    break;
                case 1:
                    if (messageSchema.B(obj2, i6, i9, i7, i3)) {
                        iI0 = CodedOutputStream.i0(iV, 0.0f);
                        i8 = i12 + iI0;
                        messageSchema = this;
                        obj2 = obj;
                    }
                    messageSchema = this;
                    obj2 = obj;
                    i8 = i12;
                    break;
                case 2:
                    if (messageSchema.B(obj2, i6, i9, i7, i3)) {
                        iP0 = CodedOutputStream.p0(iV, unsafe.getLong(obj2, jW));
                        i8 = i12 + iP0;
                        messageSchema = this;
                    }
                    messageSchema = this;
                    i8 = i12;
                    break;
                case 3:
                    if (messageSchema.B(obj2, i6, i9, i7, i3)) {
                        iP0 = CodedOutputStream.P0(iV, unsafe.getLong(obj2, jW));
                        i8 = i12 + iP0;
                        messageSchema = this;
                    }
                    messageSchema = this;
                    i8 = i12;
                    break;
                case 4:
                    if (messageSchema.B(obj2, i6, i9, i7, i3)) {
                        iP0 = CodedOutputStream.n0(iV, unsafe.getInt(obj2, jW));
                        i8 = i12 + iP0;
                        messageSchema = this;
                    }
                    messageSchema = this;
                    i8 = i12;
                    break;
                case 5:
                    if (messageSchema.B(obj2, i6, i9, i7, i3)) {
                        iI0 = CodedOutputStream.g0(iV, 0L);
                        i8 = i12 + iI0;
                        messageSchema = this;
                        obj2 = obj;
                    }
                    messageSchema = this;
                    obj2 = obj;
                    i8 = i12;
                    break;
                case 6:
                    if (messageSchema.B(obj2, i6, i9, i7, i3)) {
                        iI0 = CodedOutputStream.e0(iV, 0);
                        i8 = i12 + iI0;
                        messageSchema = this;
                        obj2 = obj;
                    }
                    messageSchema = this;
                    obj2 = obj;
                    i8 = i12;
                    break;
                case 7:
                    if (messageSchema.B(obj2, i6, i9, i7, i3)) {
                        iI0 = CodedOutputStream.V(iV, true);
                        i8 = i12 + iI0;
                        messageSchema = this;
                        obj2 = obj;
                    }
                    messageSchema = this;
                    obj2 = obj;
                    i8 = i12;
                    break;
                case 8:
                    if (messageSchema.B(obj2, i6, i9, i7, i3)) {
                        Object object = unsafe.getObject(obj2, jW);
                        iP0 = object instanceof ByteString ? CodedOutputStream.Y(iV, (ByteString) object) : CodedOutputStream.K0(iV, (String) object);
                        i8 = i12 + iP0;
                        messageSchema = this;
                    }
                    messageSchema = this;
                    i8 = i12;
                    break;
                case 9:
                    if (messageSchema.B(obj2, i6, i9, i7, i3)) {
                        iA0 = SchemaUtil.o(iV, unsafe.getObject(obj2, jW), messageSchema.v(i6));
                        i8 = i12 + iA0;
                    }
                    i8 = i12;
                    break;
                case 10:
                    if (messageSchema.B(obj2, i6, i9, i7, i3)) {
                        iP0 = CodedOutputStream.Y(iV, (ByteString) unsafe.getObject(obj2, jW));
                        i8 = i12 + iP0;
                        messageSchema = this;
                    }
                    messageSchema = this;
                    i8 = i12;
                    break;
                case 11:
                    if (messageSchema.B(obj2, i6, i9, i7, i3)) {
                        iP0 = CodedOutputStream.N0(iV, unsafe.getInt(obj2, jW));
                        i8 = i12 + iP0;
                        messageSchema = this;
                    }
                    messageSchema = this;
                    i8 = i12;
                    break;
                case 12:
                    if (messageSchema.B(obj2, i6, i9, i7, i3)) {
                        iP0 = CodedOutputStream.c0(iV, unsafe.getInt(obj2, jW));
                        i8 = i12 + iP0;
                        messageSchema = this;
                    }
                    messageSchema = this;
                    i8 = i12;
                    break;
                case 13:
                    if (messageSchema.B(obj2, i6, i9, i7, i3)) {
                        iI0 = CodedOutputStream.C0(iV, 0);
                        i8 = i12 + iI0;
                        messageSchema = this;
                        obj2 = obj;
                    }
                    messageSchema = this;
                    obj2 = obj;
                    i8 = i12;
                    break;
                case 14:
                    if (messageSchema.B(obj2, i6, i9, i7, i3)) {
                        iI0 = CodedOutputStream.E0(iV, 0L);
                        i8 = i12 + iI0;
                        messageSchema = this;
                        obj2 = obj;
                    }
                    messageSchema = this;
                    obj2 = obj;
                    i8 = i12;
                    break;
                case 15:
                    if (messageSchema.B(obj2, i6, i9, i7, i3)) {
                        iP0 = CodedOutputStream.G0(iV, unsafe.getInt(obj2, jW));
                        i8 = i12 + iP0;
                        messageSchema = this;
                    }
                    messageSchema = this;
                    i8 = i12;
                    break;
                case 16:
                    if (messageSchema.B(obj2, i6, i9, i7, i3)) {
                        iP0 = CodedOutputStream.I0(iV, unsafe.getLong(obj2, jW));
                        i8 = i12 + iP0;
                        messageSchema = this;
                    }
                    messageSchema = this;
                    i8 = i12;
                    break;
                case 17:
                    if (messageSchema.B(obj2, i6, i9, i7, i3)) {
                        iA0 = CodedOutputStream.k0(iV, (MessageLite) unsafe.getObject(obj2, jW), messageSchema.v(i6));
                        i8 = i12 + iA0;
                    }
                    i8 = i12;
                    break;
                case 18:
                    iA0 = SchemaUtil.h(iV, (List) unsafe.getObject(obj2, jW), false);
                    i8 = i12 + iA0;
                    break;
                case 19:
                    iA0 = SchemaUtil.f(iV, (List) unsafe.getObject(obj2, jW), false);
                    i8 = i12 + iA0;
                    break;
                case 20:
                    iA0 = SchemaUtil.m(iV, (List) unsafe.getObject(obj2, jW), false);
                    i8 = i12 + iA0;
                    break;
                case 21:
                    iA0 = SchemaUtil.x(iV, (List) unsafe.getObject(obj2, jW), false);
                    i8 = i12 + iA0;
                    break;
                case 22:
                    iA0 = SchemaUtil.k(iV, (List) unsafe.getObject(obj2, jW), false);
                    i8 = i12 + iA0;
                    break;
                case 23:
                    iA0 = SchemaUtil.h(iV, (List) unsafe.getObject(obj2, jW), false);
                    i8 = i12 + iA0;
                    break;
                case 24:
                    iA0 = SchemaUtil.f(iV, (List) unsafe.getObject(obj2, jW), false);
                    i8 = i12 + iA0;
                    break;
                case 25:
                    iA0 = SchemaUtil.a(iV, (List) unsafe.getObject(obj2, jW), false);
                    i8 = i12 + iA0;
                    break;
                case 26:
                    iA0 = SchemaUtil.u(iV, (List) unsafe.getObject(obj2, jW));
                    i8 = i12 + iA0;
                    break;
                case 27:
                    iA0 = SchemaUtil.p(iV, (List) unsafe.getObject(obj2, jW), messageSchema.v(i6));
                    i8 = i12 + iA0;
                    break;
                case 28:
                    iA0 = SchemaUtil.c(iV, (List) unsafe.getObject(obj2, jW));
                    i8 = i12 + iA0;
                    break;
                case 29:
                    iA0 = SchemaUtil.v(iV, (List) unsafe.getObject(obj2, jW), false);
                    i8 = i12 + iA0;
                    break;
                case 30:
                    iA0 = SchemaUtil.d(iV, (List) unsafe.getObject(obj2, jW), false);
                    i8 = i12 + iA0;
                    break;
                case 31:
                    iA0 = SchemaUtil.f(iV, (List) unsafe.getObject(obj2, jW), false);
                    i8 = i12 + iA0;
                    break;
                case 32:
                    iA0 = SchemaUtil.h(iV, (List) unsafe.getObject(obj2, jW), false);
                    i8 = i12 + iA0;
                    break;
                case 33:
                    iA0 = SchemaUtil.q(iV, (List) unsafe.getObject(obj2, jW), false);
                    i8 = i12 + iA0;
                    break;
                case 34:
                    iA0 = SchemaUtil.s(iV, (List) unsafe.getObject(obj2, jW), false);
                    i8 = i12 + iA0;
                    break;
                case 35:
                    i4 = SchemaUtil.i((List) unsafe.getObject(obj2, jW));
                    if (i4 > 0) {
                        if (messageSchema.f36522i) {
                            unsafe.putInt(obj2, i11, i4);
                        }
                        iM0 = CodedOutputStream.M0(iV);
                        iO0 = CodedOutputStream.O0(i4);
                        i8 = i12 + iM0 + iO0 + i4;
                    }
                    i8 = i12;
                    break;
                case 36:
                    i4 = SchemaUtil.g((List) unsafe.getObject(obj2, jW));
                    if (i4 > 0) {
                        if (messageSchema.f36522i) {
                            unsafe.putInt(obj2, i11, i4);
                        }
                        iM0 = CodedOutputStream.M0(iV);
                        iO0 = CodedOutputStream.O0(i4);
                        i8 = i12 + iM0 + iO0 + i4;
                    }
                    i8 = i12;
                    break;
                case 37:
                    i4 = SchemaUtil.n((List) unsafe.getObject(obj2, jW));
                    if (i4 > 0) {
                        if (messageSchema.f36522i) {
                            unsafe.putInt(obj2, i11, i4);
                        }
                        iM0 = CodedOutputStream.M0(iV);
                        iO0 = CodedOutputStream.O0(i4);
                        i8 = i12 + iM0 + iO0 + i4;
                    }
                    i8 = i12;
                    break;
                case 38:
                    i4 = SchemaUtil.y((List) unsafe.getObject(obj2, jW));
                    if (i4 > 0) {
                        if (messageSchema.f36522i) {
                            unsafe.putInt(obj2, i11, i4);
                        }
                        iM0 = CodedOutputStream.M0(iV);
                        iO0 = CodedOutputStream.O0(i4);
                        i8 = i12 + iM0 + iO0 + i4;
                    }
                    i8 = i12;
                    break;
                case 39:
                    i4 = SchemaUtil.l((List) unsafe.getObject(obj2, jW));
                    if (i4 > 0) {
                        if (messageSchema.f36522i) {
                            unsafe.putInt(obj2, i11, i4);
                        }
                        iM0 = CodedOutputStream.M0(iV);
                        iO0 = CodedOutputStream.O0(i4);
                        i8 = i12 + iM0 + iO0 + i4;
                    }
                    i8 = i12;
                    break;
                case 40:
                    i4 = SchemaUtil.i((List) unsafe.getObject(obj2, jW));
                    if (i4 > 0) {
                        if (messageSchema.f36522i) {
                            unsafe.putInt(obj2, i11, i4);
                        }
                        iM0 = CodedOutputStream.M0(iV);
                        iO0 = CodedOutputStream.O0(i4);
                        i8 = i12 + iM0 + iO0 + i4;
                    }
                    i8 = i12;
                    break;
                case 41:
                    i4 = SchemaUtil.g((List) unsafe.getObject(obj2, jW));
                    if (i4 > 0) {
                        if (messageSchema.f36522i) {
                            unsafe.putInt(obj2, i11, i4);
                        }
                        iM0 = CodedOutputStream.M0(iV);
                        iO0 = CodedOutputStream.O0(i4);
                        i8 = i12 + iM0 + iO0 + i4;
                    }
                    i8 = i12;
                    break;
                case 42:
                    i4 = SchemaUtil.b((List) unsafe.getObject(obj2, jW));
                    if (i4 > 0) {
                        if (messageSchema.f36522i) {
                            unsafe.putInt(obj2, i11, i4);
                        }
                        iM0 = CodedOutputStream.M0(iV);
                        iO0 = CodedOutputStream.O0(i4);
                        i8 = i12 + iM0 + iO0 + i4;
                    }
                    i8 = i12;
                    break;
                case 43:
                    i4 = SchemaUtil.w((List) unsafe.getObject(obj2, jW));
                    if (i4 > 0) {
                        if (messageSchema.f36522i) {
                            unsafe.putInt(obj2, i11, i4);
                        }
                        iM0 = CodedOutputStream.M0(iV);
                        iO0 = CodedOutputStream.O0(i4);
                        i8 = i12 + iM0 + iO0 + i4;
                    }
                    i8 = i12;
                    break;
                case 44:
                    i4 = SchemaUtil.e((List) unsafe.getObject(obj2, jW));
                    if (i4 > 0) {
                        if (messageSchema.f36522i) {
                            unsafe.putInt(obj2, i11, i4);
                        }
                        iM0 = CodedOutputStream.M0(iV);
                        iO0 = CodedOutputStream.O0(i4);
                        i8 = i12 + iM0 + iO0 + i4;
                    }
                    i8 = i12;
                    break;
                case 45:
                    i4 = SchemaUtil.g((List) unsafe.getObject(obj2, jW));
                    if (i4 > 0) {
                        if (messageSchema.f36522i) {
                            unsafe.putInt(obj2, i11, i4);
                        }
                        iM0 = CodedOutputStream.M0(iV);
                        iO0 = CodedOutputStream.O0(i4);
                        i8 = i12 + iM0 + iO0 + i4;
                    }
                    i8 = i12;
                    break;
                case 46:
                    i4 = SchemaUtil.i((List) unsafe.getObject(obj2, jW));
                    if (i4 > 0) {
                        if (messageSchema.f36522i) {
                            unsafe.putInt(obj2, i11, i4);
                        }
                        iM0 = CodedOutputStream.M0(iV);
                        iO0 = CodedOutputStream.O0(i4);
                        i8 = i12 + iM0 + iO0 + i4;
                    }
                    i8 = i12;
                    break;
                case 47:
                    i4 = SchemaUtil.r((List) unsafe.getObject(obj2, jW));
                    if (i4 > 0) {
                        if (messageSchema.f36522i) {
                            unsafe.putInt(obj2, i11, i4);
                        }
                        iM0 = CodedOutputStream.M0(iV);
                        iO0 = CodedOutputStream.O0(i4);
                        i8 = i12 + iM0 + iO0 + i4;
                    }
                    i8 = i12;
                    break;
                case 48:
                    i4 = SchemaUtil.t((List) unsafe.getObject(obj2, jW));
                    if (i4 > 0) {
                        if (messageSchema.f36522i) {
                            unsafe.putInt(obj2, i11, i4);
                        }
                        iM0 = CodedOutputStream.M0(iV);
                        iO0 = CodedOutputStream.O0(i4);
                        i8 = i12 + iM0 + iO0 + i4;
                    }
                    i8 = i12;
                    break;
                case 49:
                    iA0 = SchemaUtil.j(iV, (List) unsafe.getObject(obj2, jW), messageSchema.v(i6));
                    i8 = i12 + iA0;
                    break;
                case 50:
                    iA0 = messageSchema.f36530q.g(iV, unsafe.getObject(obj2, jW), messageSchema.u(i6));
                    i8 = i12 + iA0;
                    break;
                case 51:
                    if (messageSchema.I(obj2, iV, i6)) {
                        iA0 = CodedOutputStream.a0(iV, 0.0d);
                        i8 = i12 + iA0;
                    }
                    i8 = i12;
                    break;
                case 52:
                    if (messageSchema.I(obj2, iV, i6)) {
                        iA0 = CodedOutputStream.i0(iV, 0.0f);
                        i8 = i12 + iA0;
                    }
                    i8 = i12;
                    break;
                case 53:
                    if (messageSchema.I(obj2, iV, i6)) {
                        iA0 = CodedOutputStream.p0(iV, b0(obj2, jW));
                        i8 = i12 + iA0;
                    }
                    i8 = i12;
                    break;
                case 54:
                    if (messageSchema.I(obj2, iV, i6)) {
                        iA0 = CodedOutputStream.P0(iV, b0(obj2, jW));
                        i8 = i12 + iA0;
                    }
                    i8 = i12;
                    break;
                case 55:
                    if (messageSchema.I(obj2, iV, i6)) {
                        iA0 = CodedOutputStream.n0(iV, a0(obj2, jW));
                        i8 = i12 + iA0;
                    }
                    i8 = i12;
                    break;
                case 56:
                    if (messageSchema.I(obj2, iV, i6)) {
                        iA0 = CodedOutputStream.g0(iV, 0L);
                        i8 = i12 + iA0;
                    }
                    i8 = i12;
                    break;
                case 57:
                    if (messageSchema.I(obj2, iV, i6)) {
                        iA0 = CodedOutputStream.e0(iV, 0);
                        i8 = i12 + iA0;
                    }
                    i8 = i12;
                    break;
                case 58:
                    if (messageSchema.I(obj2, iV, i6)) {
                        iA0 = CodedOutputStream.V(iV, true);
                        i8 = i12 + iA0;
                    }
                    i8 = i12;
                    break;
                case 59:
                    if (messageSchema.I(obj2, iV, i6)) {
                        Object object2 = unsafe.getObject(obj2, jW);
                        iA0 = object2 instanceof ByteString ? CodedOutputStream.Y(iV, (ByteString) object2) : CodedOutputStream.K0(iV, (String) object2);
                        i8 = i12 + iA0;
                    }
                    i8 = i12;
                    break;
                case 60:
                    if (messageSchema.I(obj2, iV, i6)) {
                        iA0 = SchemaUtil.o(iV, unsafe.getObject(obj2, jW), messageSchema.v(i6));
                        i8 = i12 + iA0;
                    }
                    i8 = i12;
                    break;
                case 61:
                    if (messageSchema.I(obj2, iV, i6)) {
                        iA0 = CodedOutputStream.Y(iV, (ByteString) unsafe.getObject(obj2, jW));
                        i8 = i12 + iA0;
                    }
                    i8 = i12;
                    break;
                case 62:
                    if (messageSchema.I(obj2, iV, i6)) {
                        iA0 = CodedOutputStream.N0(iV, a0(obj2, jW));
                        i8 = i12 + iA0;
                    }
                    i8 = i12;
                    break;
                case 63:
                    if (messageSchema.I(obj2, iV, i6)) {
                        iA0 = CodedOutputStream.c0(iV, a0(obj2, jW));
                        i8 = i12 + iA0;
                    }
                    i8 = i12;
                    break;
                case 64:
                    if (messageSchema.I(obj2, iV, i6)) {
                        iA0 = CodedOutputStream.C0(iV, 0);
                        i8 = i12 + iA0;
                    }
                    i8 = i12;
                    break;
                case 65:
                    if (messageSchema.I(obj2, iV, i6)) {
                        iA0 = CodedOutputStream.E0(iV, 0L);
                        i8 = i12 + iA0;
                    }
                    i8 = i12;
                    break;
                case 66:
                    if (messageSchema.I(obj2, iV, i6)) {
                        iA0 = CodedOutputStream.G0(iV, a0(obj2, jW));
                        i8 = i12 + iA0;
                    }
                    i8 = i12;
                    break;
                case 67:
                    if (messageSchema.I(obj2, iV, i6)) {
                        iA0 = CodedOutputStream.I0(iV, b0(obj2, jW));
                        i8 = i12 + iA0;
                    }
                    i8 = i12;
                    break;
                case 68:
                    if (messageSchema.I(obj2, iV, i6)) {
                        iA0 = CodedOutputStream.k0(iV, (MessageLite) unsafe.getObject(obj2, jW), messageSchema.v(i6));
                        i8 = i12 + iA0;
                    }
                    i8 = i12;
                    break;
                default:
                    i8 = i12;
                    break;
            }
            i6 += 3;
            i5 = 1048575;
        }
        int iX = i8 + messageSchema.x(messageSchema.f36528o, obj2);
        return messageSchema.f36519f ? iX + messageSchema.f36529p.c(obj2).l() : iX;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:27:0x009d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0410 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x043e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    int d0(java.lang.Object r27, byte[] r28, int r29, int r30, int r31, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r32) {
        /*
            Method dump skipped, instruction units count: 1232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.d0(java.lang.Object, byte[], int, int, int, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public int e(Object obj) {
        int i3;
        int iF;
        int length = this.f36514a.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5 += 3) {
            int iV0 = v0(i5);
            int iV = V(i5);
            long jW = W(iV0);
            int iHashCode = 37;
            switch (u0(iV0)) {
                case 0:
                    i3 = i4 * 53;
                    iF = Internal.f(Double.doubleToLongBits(UnsafeUtil.B(obj, jW)));
                    i4 = i3 + iF;
                    break;
                case 1:
                    i3 = i4 * 53;
                    iF = Float.floatToIntBits(UnsafeUtil.C(obj, jW));
                    i4 = i3 + iF;
                    break;
                case 2:
                    i3 = i4 * 53;
                    iF = Internal.f(UnsafeUtil.F(obj, jW));
                    i4 = i3 + iF;
                    break;
                case 3:
                    i3 = i4 * 53;
                    iF = Internal.f(UnsafeUtil.F(obj, jW));
                    i4 = i3 + iF;
                    break;
                case 4:
                    i3 = i4 * 53;
                    iF = UnsafeUtil.D(obj, jW);
                    i4 = i3 + iF;
                    break;
                case 5:
                    i3 = i4 * 53;
                    iF = Internal.f(UnsafeUtil.F(obj, jW));
                    i4 = i3 + iF;
                    break;
                case 6:
                    i3 = i4 * 53;
                    iF = UnsafeUtil.D(obj, jW);
                    i4 = i3 + iF;
                    break;
                case 7:
                    i3 = i4 * 53;
                    iF = Internal.c(UnsafeUtil.u(obj, jW));
                    i4 = i3 + iF;
                    break;
                case 8:
                    i3 = i4 * 53;
                    iF = ((String) UnsafeUtil.H(obj, jW)).hashCode();
                    i4 = i3 + iF;
                    break;
                case 9:
                    Object objH = UnsafeUtil.H(obj, jW);
                    if (objH != null) {
                        iHashCode = objH.hashCode();
                    }
                    i4 = (i4 * 53) + iHashCode;
                    break;
                case 10:
                    i3 = i4 * 53;
                    iF = UnsafeUtil.H(obj, jW).hashCode();
                    i4 = i3 + iF;
                    break;
                case 11:
                    i3 = i4 * 53;
                    iF = UnsafeUtil.D(obj, jW);
                    i4 = i3 + iF;
                    break;
                case 12:
                    i3 = i4 * 53;
                    iF = UnsafeUtil.D(obj, jW);
                    i4 = i3 + iF;
                    break;
                case 13:
                    i3 = i4 * 53;
                    iF = UnsafeUtil.D(obj, jW);
                    i4 = i3 + iF;
                    break;
                case 14:
                    i3 = i4 * 53;
                    iF = Internal.f(UnsafeUtil.F(obj, jW));
                    i4 = i3 + iF;
                    break;
                case 15:
                    i3 = i4 * 53;
                    iF = UnsafeUtil.D(obj, jW);
                    i4 = i3 + iF;
                    break;
                case 16:
                    i3 = i4 * 53;
                    iF = Internal.f(UnsafeUtil.F(obj, jW));
                    i4 = i3 + iF;
                    break;
                case 17:
                    Object objH2 = UnsafeUtil.H(obj, jW);
                    if (objH2 != null) {
                        iHashCode = objH2.hashCode();
                    }
                    i4 = (i4 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i3 = i4 * 53;
                    iF = UnsafeUtil.H(obj, jW).hashCode();
                    i4 = i3 + iF;
                    break;
                case 50:
                    i3 = i4 * 53;
                    iF = UnsafeUtil.H(obj, jW).hashCode();
                    i4 = i3 + iF;
                    break;
                case 51:
                    if (I(obj, iV, i5)) {
                        i3 = i4 * 53;
                        iF = Internal.f(Double.doubleToLongBits(Y(obj, jW)));
                        i4 = i3 + iF;
                    }
                    break;
                case 52:
                    if (I(obj, iV, i5)) {
                        i3 = i4 * 53;
                        iF = Float.floatToIntBits(Z(obj, jW));
                        i4 = i3 + iF;
                    }
                    break;
                case 53:
                    if (I(obj, iV, i5)) {
                        i3 = i4 * 53;
                        iF = Internal.f(b0(obj, jW));
                        i4 = i3 + iF;
                    }
                    break;
                case 54:
                    if (I(obj, iV, i5)) {
                        i3 = i4 * 53;
                        iF = Internal.f(b0(obj, jW));
                        i4 = i3 + iF;
                    }
                    break;
                case 55:
                    if (I(obj, iV, i5)) {
                        i3 = i4 * 53;
                        iF = a0(obj, jW);
                        i4 = i3 + iF;
                    }
                    break;
                case 56:
                    if (I(obj, iV, i5)) {
                        i3 = i4 * 53;
                        iF = Internal.f(b0(obj, jW));
                        i4 = i3 + iF;
                    }
                    break;
                case 57:
                    if (I(obj, iV, i5)) {
                        i3 = i4 * 53;
                        iF = a0(obj, jW);
                        i4 = i3 + iF;
                    }
                    break;
                case 58:
                    if (I(obj, iV, i5)) {
                        i3 = i4 * 53;
                        iF = Internal.c(X(obj, jW));
                        i4 = i3 + iF;
                    }
                    break;
                case 59:
                    if (I(obj, iV, i5)) {
                        i3 = i4 * 53;
                        iF = ((String) UnsafeUtil.H(obj, jW)).hashCode();
                        i4 = i3 + iF;
                    }
                    break;
                case 60:
                    if (I(obj, iV, i5)) {
                        i3 = i4 * 53;
                        iF = UnsafeUtil.H(obj, jW).hashCode();
                        i4 = i3 + iF;
                    }
                    break;
                case 61:
                    if (I(obj, iV, i5)) {
                        i3 = i4 * 53;
                        iF = UnsafeUtil.H(obj, jW).hashCode();
                        i4 = i3 + iF;
                    }
                    break;
                case 62:
                    if (I(obj, iV, i5)) {
                        i3 = i4 * 53;
                        iF = a0(obj, jW);
                        i4 = i3 + iF;
                    }
                    break;
                case 63:
                    if (I(obj, iV, i5)) {
                        i3 = i4 * 53;
                        iF = a0(obj, jW);
                        i4 = i3 + iF;
                    }
                    break;
                case 64:
                    if (I(obj, iV, i5)) {
                        i3 = i4 * 53;
                        iF = a0(obj, jW);
                        i4 = i3 + iF;
                    }
                    break;
                case 65:
                    if (I(obj, iV, i5)) {
                        i3 = i4 * 53;
                        iF = Internal.f(b0(obj, jW));
                        i4 = i3 + iF;
                    }
                    break;
                case 66:
                    if (I(obj, iV, i5)) {
                        i3 = i4 * 53;
                        iF = a0(obj, jW);
                        i4 = i3 + iF;
                    }
                    break;
                case 67:
                    if (I(obj, iV, i5)) {
                        i3 = i4 * 53;
                        iF = Internal.f(b0(obj, jW));
                        i4 = i3 + iF;
                    }
                    break;
                case 68:
                    if (I(obj, iV, i5)) {
                        i3 = i4 * 53;
                        iF = UnsafeUtil.H(obj, jW).hashCode();
                        i4 = i3 + iF;
                    }
                    break;
            }
        }
        int iHashCode2 = (i4 * 53) + this.f36528o.g(obj).hashCode();
        return this.f36519f ? (iHashCode2 * 53) + this.f36529p.c(obj).hashCode() : iHashCode2;
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public boolean f(Object obj, Object obj2) {
        int length = this.f36514a.length;
        for (int i3 = 0; i3 < length; i3 += 3) {
            if (!p(obj, obj2, i3)) {
                return false;
            }
        }
        if (!this.f36528o.g(obj).equals(this.f36528o.g(obj2))) {
            return false;
        }
        if (this.f36519f) {
            return this.f36529p.c(obj).equals(this.f36529p.c(obj2));
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void g(Object obj, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        extensionRegistryLite.getClass();
        l(obj);
        L(this.f36528o, this.f36529p, obj, reader, extensionRegistryLite);
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void h(Object obj, Writer writer) {
        if (writer.t() == Writer.FieldOrder.DESCENDING) {
            x0(obj, writer);
        } else {
            w0(obj, writer);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void i(Object obj, byte[] bArr, int i3, int i4, ArrayDecoders.Registers registers) {
        d0(obj, bArr, i3, i4, 0, registers);
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public Object newInstance() {
        return this.f36526m.a(this.f36518e);
    }
}
