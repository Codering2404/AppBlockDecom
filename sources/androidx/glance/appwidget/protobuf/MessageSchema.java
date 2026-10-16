package androidx.glance.appwidget.protobuf;

import androidx.glance.appwidget.protobuf.ArrayDecoders;
import androidx.glance.appwidget.protobuf.ByteString;
import androidx.glance.appwidget.protobuf.Internal;
import androidx.glance.appwidget.protobuf.MapEntryLite;
import androidx.glance.appwidget.protobuf.WireFormat;
import androidx.glance.appwidget.protobuf.Writer;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
final class MessageSchema<T> implements Schema<T> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int[] f39158r = new int[0];

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final Unsafe f39159s = UnsafeUtil.I();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f39160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object[] f39161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f39162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f39163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MessageLite f39164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f39165f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f39166g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f39167h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f39168i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int[] f39169j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f39170k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f39171l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final NewInstanceSchema f39172m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ListFieldSchema f39173n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final UnknownFieldSchema f39174o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ExtensionSchema f39175p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final MapFieldSchema f39176q;

    /* JADX INFO: renamed from: androidx.glance.appwidget.protobuf.MessageSchema$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f39177a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f39177a = iArr;
            try {
                iArr[WireFormat.FieldType.f39336k.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f39177a[WireFormat.FieldType.f39340o.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f39177a[WireFormat.FieldType.f39329c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f39177a[WireFormat.FieldType.f39335j.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f39177a[WireFormat.FieldType.f39343r.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f39177a[WireFormat.FieldType.f39334i.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f39177a[WireFormat.FieldType.f39344s.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f39177a[WireFormat.FieldType.f39330d.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f39177a[WireFormat.FieldType.f39342q.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f39177a[WireFormat.FieldType.f39333h.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f39177a[WireFormat.FieldType.f39341p.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f39177a[WireFormat.FieldType.f39331f.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f39177a[WireFormat.FieldType.f39332g.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f39177a[WireFormat.FieldType.f39339n.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f39177a[WireFormat.FieldType.f39345t.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f39177a[WireFormat.FieldType.f39346u.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f39177a[WireFormat.FieldType.f39337l.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i3, int i4, MessageLite messageLite, boolean z2, boolean z3, int[] iArr2, int i5, int i6, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, MapFieldSchema mapFieldSchema) {
        this.f39160a = iArr;
        this.f39161b = objArr;
        this.f39162c = i3;
        this.f39163d = i4;
        this.f39166g = messageLite instanceof GeneratedMessageLite;
        this.f39167h = z2;
        this.f39165f = extensionSchema != null && extensionSchema.e(messageLite);
        this.f39168i = z3;
        this.f39169j = iArr2;
        this.f39170k = i5;
        this.f39171l = i6;
        this.f39172m = newInstanceSchema;
        this.f39173n = listFieldSchema;
        this.f39174o = unknownFieldSchema;
        this.f39175p = extensionSchema;
        this.f39164e = messageLite;
        this.f39176q = mapFieldSchema;
    }

    private static int A(Object obj, long j3) {
        return UnsafeUtil.D(obj, j3);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0(java.lang.Object r13, androidx.glance.appwidget.protobuf.Writer r14) {
        /*
            Method dump skipped, instruction units count: 1584
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.protobuf.MessageSchema.A0(java.lang.Object, androidx.glance.appwidget.protobuf.Writer):void");
    }

    private static boolean B(int i3) {
        return (i3 & 536870912) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void B0(java.lang.Object r11, androidx.glance.appwidget.protobuf.Writer r12) {
        /*
            Method dump skipped, instruction units count: 1586
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.protobuf.MessageSchema.B0(java.lang.Object, androidx.glance.appwidget.protobuf.Writer):void");
    }

    private boolean C(Object obj, int i3) {
        boolean zEquals;
        int iL0 = l0(i3);
        long j3 = 1048575 & iL0;
        if (j3 != 1048575) {
            return (UnsafeUtil.D(obj, j3) & (1 << (iL0 >>> 20))) != 0;
        }
        int iY0 = y0(i3);
        long jY = Y(iY0);
        switch (x0(iY0)) {
            case 0:
                return Double.doubleToRawLongBits(UnsafeUtil.B(obj, jY)) != 0;
            case 1:
                return Float.floatToRawIntBits(UnsafeUtil.C(obj, jY)) != 0;
            case 2:
                return UnsafeUtil.F(obj, jY) != 0;
            case 3:
                return UnsafeUtil.F(obj, jY) != 0;
            case 4:
                return UnsafeUtil.D(obj, jY) != 0;
            case 5:
                return UnsafeUtil.F(obj, jY) != 0;
            case 6:
                return UnsafeUtil.D(obj, jY) != 0;
            case 7:
                return UnsafeUtil.u(obj, jY);
            case 8:
                Object objH = UnsafeUtil.H(obj, jY);
                if (objH instanceof String) {
                    zEquals = ((String) objH).isEmpty();
                } else {
                    if (!(objH instanceof ByteString)) {
                        throw new IllegalArgumentException();
                    }
                    zEquals = ByteString.f38830b.equals(objH);
                }
                break;
            case 9:
                return UnsafeUtil.H(obj, jY) != null;
            case 10:
                zEquals = ByteString.f38830b.equals(UnsafeUtil.H(obj, jY));
                break;
            case 11:
                return UnsafeUtil.D(obj, jY) != 0;
            case 12:
                return UnsafeUtil.D(obj, jY) != 0;
            case 13:
                return UnsafeUtil.D(obj, jY) != 0;
            case 14:
                return UnsafeUtil.F(obj, jY) != 0;
            case 15:
                return UnsafeUtil.D(obj, jY) != 0;
            case 16:
                return UnsafeUtil.F(obj, jY) != 0;
            case 17:
                return UnsafeUtil.H(obj, jY) != null;
            default:
                throw new IllegalArgumentException();
        }
        return !zEquals;
    }

    private void C0(Writer writer, int i3, Object obj, int i4) {
        if (obj != null) {
            writer.O(i3, this.f39176q.b(u(i4)), this.f39176q.e(obj));
        }
    }

    private boolean D(Object obj, int i3, int i4, int i5, int i6) {
        return i4 == 1048575 ? C(obj, i3) : (i5 & i6) != 0;
    }

    private void D0(int i3, Object obj, Writer writer) {
        if (obj instanceof String) {
            writer.e(i3, (String) obj);
        } else {
            writer.M(i3, (ByteString) obj);
        }
    }

    private static boolean E(Object obj, int i3, Schema schema) {
        return schema.c(UnsafeUtil.H(obj, Y(i3)));
    }

    private void E0(UnknownFieldSchema unknownFieldSchema, Object obj, Writer writer) {
        unknownFieldSchema.t(unknownFieldSchema.g(obj), writer);
    }

    private boolean F(Object obj, int i3, int i4) {
        List list = (List) UnsafeUtil.H(obj, Y(i3));
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

    private boolean G(Object obj, int i3, int i4) {
        Map mapE = this.f39176q.e(UnsafeUtil.H(obj, Y(i3)));
        if (mapE.isEmpty()) {
            return true;
        }
        if (this.f39176q.b(u(i4)).f39151c.a() != WireFormat.JavaType.MESSAGE) {
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

    private static boolean H(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).H();
        }
        return true;
    }

    private boolean I(Object obj, Object obj2, int i3) {
        long jL0 = l0(i3) & 1048575;
        return UnsafeUtil.D(obj, jL0) == UnsafeUtil.D(obj2, jL0);
    }

    private boolean J(Object obj, int i3, int i4) {
        return UnsafeUtil.D(obj, (long) (l0(i4) & 1048575)) == i3;
    }

    private static boolean K(int i3) {
        return (i3 & 268435456) != 0;
    }

    private static List L(Object obj, long j3) {
        return (List) UnsafeUtil.H(obj, j3);
    }

    private static long M(Object obj, long j3) {
        return UnsafeUtil.F(obj, j3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:338:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a8, code lost:
    
        r0 = r9.f39170k;
        r4 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ad, code lost:
    
        if (r0 >= r9.f39171l) goto L336;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00af, code lost:
    
        r4 = r9.q(r2, r9.f39169j[r0], r4, r5, r19);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c0, code lost:
    
        if (r4 == null) goto L338;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c2, code lost:
    
        r5.o(r2, r4);
     */
    /* JADX WARN: Removed duplicated region for block: B:240:0x06f8 A[Catch: all -> 0x0719, TRY_LEAVE, TryCatch #31 {all -> 0x0719, blocks: (B:238:0x06f2, B:240:0x06f8, B:251:0x071d, B:252:0x0722), top: B:296:0x06f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x071b  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0752 A[LOOP:4: B:265:0x074e->B:267:0x0752, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0765  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void N(androidx.glance.appwidget.protobuf.UnknownFieldSchema r17, androidx.glance.appwidget.protobuf.ExtensionSchema r18, java.lang.Object r19, androidx.glance.appwidget.protobuf.Reader r20, androidx.glance.appwidget.protobuf.ExtensionRegistryLite r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2040
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.protobuf.MessageSchema.N(androidx.glance.appwidget.protobuf.UnknownFieldSchema, androidx.glance.appwidget.protobuf.ExtensionSchema, java.lang.Object, androidx.glance.appwidget.protobuf.Reader, androidx.glance.appwidget.protobuf.ExtensionRegistryLite):void");
    }

    private final void O(Object obj, int i3, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) {
        long jY = Y(y0(i3));
        Object objH = UnsafeUtil.H(obj, jY);
        if (objH == null) {
            objH = this.f39176q.d(obj2);
            UnsafeUtil.Y(obj, jY, objH);
        } else if (this.f39176q.h(objH)) {
            Object objD = this.f39176q.d(obj2);
            this.f39176q.a(objD, objH);
            UnsafeUtil.Y(obj, jY, objD);
            objH = objD;
        }
        reader.J(this.f39176q.c(objH), this.f39176q.b(obj2), extensionRegistryLite);
    }

    private void P(Object obj, Object obj2, int i3) {
        if (C(obj2, i3)) {
            long jY = Y(y0(i3));
            Unsafe unsafe = f39159s;
            Object object = unsafe.getObject(obj2, jY);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + X(i3) + " is present but null: " + obj2);
            }
            Schema schemaV = v(i3);
            if (!C(obj, i3)) {
                if (H(object)) {
                    Object objNewInstance = schemaV.newInstance();
                    schemaV.a(objNewInstance, object);
                    unsafe.putObject(obj, jY, objNewInstance);
                } else {
                    unsafe.putObject(obj, jY, object);
                }
                r0(obj, i3);
                return;
            }
            Object object2 = unsafe.getObject(obj, jY);
            if (!H(object2)) {
                Object objNewInstance2 = schemaV.newInstance();
                schemaV.a(objNewInstance2, object2);
                unsafe.putObject(obj, jY, objNewInstance2);
                object2 = objNewInstance2;
            }
            schemaV.a(object2, object);
        }
    }

    private void Q(Object obj, Object obj2, int i3) {
        int iX = X(i3);
        if (J(obj2, iX, i3)) {
            long jY = Y(y0(i3));
            Unsafe unsafe = f39159s;
            Object object = unsafe.getObject(obj2, jY);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + X(i3) + " is present but null: " + obj2);
            }
            Schema schemaV = v(i3);
            if (!J(obj, iX, i3)) {
                if (H(object)) {
                    Object objNewInstance = schemaV.newInstance();
                    schemaV.a(objNewInstance, object);
                    unsafe.putObject(obj, jY, objNewInstance);
                } else {
                    unsafe.putObject(obj, jY, object);
                }
                s0(obj, iX, i3);
                return;
            }
            Object object2 = unsafe.getObject(obj, jY);
            if (!H(object2)) {
                Object objNewInstance2 = schemaV.newInstance();
                schemaV.a(objNewInstance2, object2);
                unsafe.putObject(obj, jY, objNewInstance2);
                object2 = objNewInstance2;
            }
            schemaV.a(object2, object);
        }
    }

    private void R(Object obj, Object obj2, int i3) {
        int iY0 = y0(i3);
        long jY = Y(iY0);
        int iX = X(i3);
        switch (x0(iY0)) {
            case 0:
                if (C(obj2, i3)) {
                    UnsafeUtil.U(obj, jY, UnsafeUtil.B(obj2, jY));
                    r0(obj, i3);
                }
                break;
            case 1:
                if (C(obj2, i3)) {
                    UnsafeUtil.V(obj, jY, UnsafeUtil.C(obj2, jY));
                    r0(obj, i3);
                }
                break;
            case 2:
                if (C(obj2, i3)) {
                    UnsafeUtil.X(obj, jY, UnsafeUtil.F(obj2, jY));
                    r0(obj, i3);
                }
                break;
            case 3:
                if (C(obj2, i3)) {
                    UnsafeUtil.X(obj, jY, UnsafeUtil.F(obj2, jY));
                    r0(obj, i3);
                }
                break;
            case 4:
                if (C(obj2, i3)) {
                    UnsafeUtil.W(obj, jY, UnsafeUtil.D(obj2, jY));
                    r0(obj, i3);
                }
                break;
            case 5:
                if (C(obj2, i3)) {
                    UnsafeUtil.X(obj, jY, UnsafeUtil.F(obj2, jY));
                    r0(obj, i3);
                }
                break;
            case 6:
                if (C(obj2, i3)) {
                    UnsafeUtil.W(obj, jY, UnsafeUtil.D(obj2, jY));
                    r0(obj, i3);
                }
                break;
            case 7:
                if (C(obj2, i3)) {
                    UnsafeUtil.N(obj, jY, UnsafeUtil.u(obj2, jY));
                    r0(obj, i3);
                }
                break;
            case 8:
                if (C(obj2, i3)) {
                    UnsafeUtil.Y(obj, jY, UnsafeUtil.H(obj2, jY));
                    r0(obj, i3);
                }
                break;
            case 9:
                P(obj, obj2, i3);
                break;
            case 10:
                if (C(obj2, i3)) {
                    UnsafeUtil.Y(obj, jY, UnsafeUtil.H(obj2, jY));
                    r0(obj, i3);
                }
                break;
            case 11:
                if (C(obj2, i3)) {
                    UnsafeUtil.W(obj, jY, UnsafeUtil.D(obj2, jY));
                    r0(obj, i3);
                }
                break;
            case 12:
                if (C(obj2, i3)) {
                    UnsafeUtil.W(obj, jY, UnsafeUtil.D(obj2, jY));
                    r0(obj, i3);
                }
                break;
            case 13:
                if (C(obj2, i3)) {
                    UnsafeUtil.W(obj, jY, UnsafeUtil.D(obj2, jY));
                    r0(obj, i3);
                }
                break;
            case 14:
                if (C(obj2, i3)) {
                    UnsafeUtil.X(obj, jY, UnsafeUtil.F(obj2, jY));
                    r0(obj, i3);
                }
                break;
            case 15:
                if (C(obj2, i3)) {
                    UnsafeUtil.W(obj, jY, UnsafeUtil.D(obj2, jY));
                    r0(obj, i3);
                }
                break;
            case 16:
                if (C(obj2, i3)) {
                    UnsafeUtil.X(obj, jY, UnsafeUtil.F(obj2, jY));
                    r0(obj, i3);
                }
                break;
            case 17:
                P(obj, obj2, i3);
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
                this.f39173n.d(obj, obj2, jY);
                break;
            case 50:
                SchemaUtil.F(this.f39176q, obj, obj2, jY);
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
                if (J(obj2, iX, i3)) {
                    UnsafeUtil.Y(obj, jY, UnsafeUtil.H(obj2, jY));
                    s0(obj, iX, i3);
                }
                break;
            case 60:
                Q(obj, obj2, i3);
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (J(obj2, iX, i3)) {
                    UnsafeUtil.Y(obj, jY, UnsafeUtil.H(obj2, jY));
                    s0(obj, iX, i3);
                }
                break;
            case 68:
                Q(obj, obj2, i3);
                break;
        }
    }

    private Object S(Object obj, int i3) {
        Schema schemaV = v(i3);
        long jY = Y(y0(i3));
        if (!C(obj, i3)) {
            return schemaV.newInstance();
        }
        Object object = f39159s.getObject(obj, jY);
        if (H(object)) {
            return object;
        }
        Object objNewInstance = schemaV.newInstance();
        if (object != null) {
            schemaV.a(objNewInstance, object);
        }
        return objNewInstance;
    }

    private Object T(Object obj, int i3, int i4) {
        Schema schemaV = v(i4);
        if (!J(obj, i3, i4)) {
            return schemaV.newInstance();
        }
        Object object = f39159s.getObject(obj, Y(y0(i4)));
        if (H(object)) {
            return object;
        }
        Object objNewInstance = schemaV.newInstance();
        if (object != null) {
            schemaV.a(objNewInstance, object);
        }
        return objNewInstance;
    }

    static MessageSchema U(Class cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, MapFieldSchema mapFieldSchema) {
        return messageInfo instanceof RawMessageInfo ? W((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema) : V((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    static MessageSchema V(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, MapFieldSchema mapFieldSchema) {
        int iE;
        int iE2;
        int i3;
        boolean z2 = structuralMessageInfo.c() == ProtoSyntax.PROTO3;
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
            if (fieldInfo.k() == FieldType.f39010e0) {
                i4++;
            } else if (fieldInfo.k().a() >= 18 && fieldInfo.k().a() <= 49) {
                i5++;
            }
        }
        int[] iArr2 = i4 > 0 ? new int[i4] : null;
        int[] iArr3 = i5 > 0 ? new int[i5] : null;
        int[] iArrD = structuralMessageInfo.d();
        if (iArrD == null) {
            iArrD = f39158r;
        }
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i6 < fieldInfoArrE.length) {
            FieldInfo fieldInfo2 = fieldInfoArrE[i6];
            int iE3 = fieldInfo2.e();
            u0(fieldInfo2, iArr, i7, objArr);
            if (i8 < iArrD.length && iArrD[i8] == iE3) {
                iArrD[i8] = i7;
                i8++;
            }
            if (fieldInfo2.k() == FieldType.f39010e0) {
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
            iArr2 = f39158r;
        }
        if (iArr3 == null) {
            iArr3 = f39158r;
        }
        int[] iArr4 = new int[iArrD.length + iArr2.length + iArr3.length];
        System.arraycopy(iArrD, 0, iArr4, 0, iArrD.length);
        System.arraycopy(iArr2, 0, iArr4, iArrD.length, iArr2.length);
        System.arraycopy(iArr3, 0, iArr4, iArrD.length + iArr2.length, iArr3.length);
        return new MessageSchema(iArr, objArr, iE, iE2, structuralMessageInfo.b(), z2, true, iArr4, iArrD.length, iArrD.length + iArr2.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0365  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static androidx.glance.appwidget.protobuf.MessageSchema W(androidx.glance.appwidget.protobuf.RawMessageInfo r33, androidx.glance.appwidget.protobuf.NewInstanceSchema r34, androidx.glance.appwidget.protobuf.ListFieldSchema r35, androidx.glance.appwidget.protobuf.UnknownFieldSchema r36, androidx.glance.appwidget.protobuf.ExtensionSchema r37, androidx.glance.appwidget.protobuf.MapFieldSchema r38) {
        /*
            Method dump skipped, instruction units count: 977
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.protobuf.MessageSchema.W(androidx.glance.appwidget.protobuf.RawMessageInfo, androidx.glance.appwidget.protobuf.NewInstanceSchema, androidx.glance.appwidget.protobuf.ListFieldSchema, androidx.glance.appwidget.protobuf.UnknownFieldSchema, androidx.glance.appwidget.protobuf.ExtensionSchema, androidx.glance.appwidget.protobuf.MapFieldSchema):androidx.glance.appwidget.protobuf.MessageSchema");
    }

    private int X(int i3) {
        return this.f39160a[i3];
    }

    private static long Y(int i3) {
        return i3 & 1048575;
    }

    private static boolean Z(Object obj, long j3) {
        return ((Boolean) UnsafeUtil.H(obj, j3)).booleanValue();
    }

    private static double a0(Object obj, long j3) {
        return ((Double) UnsafeUtil.H(obj, j3)).doubleValue();
    }

    private static float b0(Object obj, long j3) {
        return ((Float) UnsafeUtil.H(obj, j3)).floatValue();
    }

    private static int c0(Object obj, long j3) {
        return ((Integer) UnsafeUtil.H(obj, j3)).intValue();
    }

    private static long d0(Object obj, long j3) {
        return ((Long) UnsafeUtil.H(obj, j3)).longValue();
    }

    private int e0(Object obj, byte[] bArr, int i3, int i4, int i5, long j3, ArrayDecoders.Registers registers) {
        Unsafe unsafe = f39159s;
        Object objU = u(i5);
        Object object = unsafe.getObject(obj, j3);
        if (this.f39176q.h(object)) {
            Object objD = this.f39176q.d(objU);
            this.f39176q.a(objD, object);
            unsafe.putObject(obj, j3, objD);
            object = objD;
        }
        return m(bArr, i3, i4, this.f39176q.b(objU), this.f39176q.c(object), registers);
    }

    private int f0(Object obj, byte[] bArr, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j3, int i10, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        Unsafe unsafe = f39159s;
        long j4 = this.f39160a[i10 + 2] & 1048575;
        switch (i9) {
            case 51:
                if (i7 != 1) {
                    return i3;
                }
                unsafe.putObject(obj, j3, Double.valueOf(ArrayDecoders.d(bArr, i3)));
                int i11 = i3 + 8;
                unsafe.putInt(obj, j4, i6);
                return i11;
            case 52:
                if (i7 != 5) {
                    return i3;
                }
                unsafe.putObject(obj, j3, Float.valueOf(ArrayDecoders.l(bArr, i3)));
                int i12 = i3 + 4;
                unsafe.putInt(obj, j4, i6);
                return i12;
            case 53:
            case 54:
                if (i7 != 0) {
                    return i3;
                }
                int iL = ArrayDecoders.L(bArr, i3, registers);
                unsafe.putObject(obj, j3, Long.valueOf(registers.f38786b));
                unsafe.putInt(obj, j4, i6);
                return iL;
            case 55:
            case 62:
                if (i7 != 0) {
                    return i3;
                }
                int I = ArrayDecoders.I(bArr, i3, registers);
                unsafe.putObject(obj, j3, Integer.valueOf(registers.f38785a));
                unsafe.putInt(obj, j4, i6);
                return I;
            case 56:
            case 65:
                if (i7 != 1) {
                    return i3;
                }
                unsafe.putObject(obj, j3, Long.valueOf(ArrayDecoders.j(bArr, i3)));
                int i13 = i3 + 8;
                unsafe.putInt(obj, j4, i6);
                return i13;
            case 57:
            case 64:
                if (i7 != 5) {
                    return i3;
                }
                unsafe.putObject(obj, j3, Integer.valueOf(ArrayDecoders.h(bArr, i3)));
                int i14 = i3 + 4;
                unsafe.putInt(obj, j4, i6);
                return i14;
            case 58:
                if (i7 != 0) {
                    return i3;
                }
                int iL2 = ArrayDecoders.L(bArr, i3, registers);
                unsafe.putObject(obj, j3, Boolean.valueOf(registers.f38786b != 0));
                unsafe.putInt(obj, j4, i6);
                return iL2;
            case 59:
                if (i7 != 2) {
                    return i3;
                }
                int I2 = ArrayDecoders.I(bArr, i3, registers);
                int i15 = registers.f38785a;
                if (i15 == 0) {
                    unsafe.putObject(obj, j3, "");
                } else {
                    if ((i8 & 536870912) != 0 && !Utf8.u(bArr, I2, I2 + i15)) {
                        throw InvalidProtocolBufferException.d();
                    }
                    unsafe.putObject(obj, j3, new String(bArr, I2, i15, Internal.f39080b));
                    I2 += i15;
                }
                unsafe.putInt(obj, j4, i6);
                return I2;
            case 60:
                if (i7 != 2) {
                    return i3;
                }
                Object objT = T(obj, i6, i10);
                int iO = ArrayDecoders.O(objT, v(i10), bArr, i3, i4, registers);
                w0(obj, i6, i10, objT);
                return iO;
            case 61:
                if (i7 != 2) {
                    return i3;
                }
                int iB = ArrayDecoders.b(bArr, i3, registers);
                unsafe.putObject(obj, j3, registers.f38787c);
                unsafe.putInt(obj, j4, i6);
                return iB;
            case 63:
                if (i7 != 0) {
                    return i3;
                }
                int I3 = ArrayDecoders.I(bArr, i3, registers);
                int i16 = registers.f38785a;
                Internal.EnumVerifier enumVerifierT = t(i10);
                if (enumVerifierT != null && !enumVerifierT.a(i16)) {
                    w(obj).n(i5, Long.valueOf(i16));
                    return I3;
                }
                unsafe.putObject(obj, j3, Integer.valueOf(i16));
                unsafe.putInt(obj, j4, i6);
                return I3;
            case 66:
                if (i7 != 0) {
                    return i3;
                }
                int I4 = ArrayDecoders.I(bArr, i3, registers);
                unsafe.putObject(obj, j3, Integer.valueOf(CodedInputStream.b(registers.f38785a)));
                unsafe.putInt(obj, j4, i6);
                return I4;
            case 67:
                if (i7 != 0) {
                    return i3;
                }
                int iL3 = ArrayDecoders.L(bArr, i3, registers);
                unsafe.putObject(obj, j3, Long.valueOf(CodedInputStream.c(registers.f38786b)));
                unsafe.putInt(obj, j4, i6);
                return iL3;
            case 68:
                if (i7 == 3) {
                    Object objT2 = T(obj, i6, i10);
                    int iN = ArrayDecoders.N(objT2, v(i10), bArr, i3, i4, (i5 & (-8)) | 4, registers);
                    w0(obj, i6, i10, objT2);
                    return iN;
                }
                break;
        }
        return i3;
    }

    private int h0(Object obj, byte[] bArr, int i3, int i4, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        Object obj2;
        Unsafe unsafe;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        byte[] bArr2;
        ArrayDecoders.Registers registers2;
        int i10;
        int i11;
        int I;
        Object obj3;
        Unsafe unsafe2;
        int i12;
        ArrayDecoders.Registers registers3;
        byte[] bArr3;
        int iL;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        MessageSchema<T> messageSchema = this;
        Object obj4 = obj;
        byte[] bArr4 = bArr;
        int i19 = i4;
        ArrayDecoders.Registers registers4 = registers;
        l(obj4);
        Unsafe unsafe3 = f39159s;
        int i20 = -1;
        int i21 = i3;
        int i22 = -1;
        int i23 = 0;
        int i24 = 0;
        int i25 = 1048575;
        while (i21 < i19) {
            int iH = i21 + 1;
            int i26 = bArr4[i21];
            if (i26 < 0) {
                iH = ArrayDecoders.H(i26, bArr4, iH, registers4);
                i26 = registers4.f38785a;
            }
            int i27 = i26 >>> 3;
            int i28 = i26 & 7;
            int iK0 = i27 > i22 ? messageSchema.k0(i27, i23 / 3) : messageSchema.j0(i27);
            if (iK0 == i20) {
                obj2 = obj4;
                unsafe = unsafe3;
                i5 = i26;
                i6 = iH;
                i7 = i20;
                i8 = i27;
                i9 = 0;
            } else {
                int i29 = messageSchema.f39160a[iK0 + 1];
                int iX0 = x0(i29);
                i5 = i26;
                int i30 = iK0;
                long jY = Y(i29);
                if (iX0 <= 17) {
                    int i31 = messageSchema.f39160a[i30 + 2];
                    int i32 = 1 << (i31 >>> 20);
                    int i33 = i31 & 1048575;
                    if (i33 != i25) {
                        if (i25 != 1048575) {
                            unsafe3.putInt(obj4, i25, i24);
                            i14 = i33;
                            i13 = 1048575;
                        } else {
                            i13 = 1048575;
                            i14 = i33;
                        }
                        if (i14 != i13) {
                            i24 = unsafe3.getInt(obj4, i14);
                        }
                        i25 = i14;
                    }
                    switch (iX0) {
                        case 0:
                            byte[] bArr5 = bArr4;
                            i10 = iH;
                            i11 = i30;
                            if (i28 != 1) {
                                unsafe = unsafe3;
                                i6 = i10;
                                i9 = i11;
                                i8 = i27;
                                i7 = -1;
                                obj2 = obj4;
                            } else {
                                UnsafeUtil.U(obj4, jY, ArrayDecoders.d(bArr5, i10));
                                i21 = i10 + 8;
                                i24 |= i32;
                                i19 = i4;
                                i23 = i11;
                                i22 = i27;
                                bArr4 = bArr5;
                                i20 = -1;
                                registers4 = registers;
                            }
                            break;
                        case 1:
                            ArrayDecoders.Registers registers5 = registers4;
                            bArr2 = bArr4;
                            registers2 = registers5;
                            i10 = iH;
                            i11 = i30;
                            if (i28 != 5) {
                                unsafe = unsafe3;
                                i6 = i10;
                                i9 = i11;
                                i8 = i27;
                                i7 = -1;
                                obj2 = obj4;
                            } else {
                                UnsafeUtil.V(obj4, jY, ArrayDecoders.l(bArr2, i10));
                                i21 = i10 + 4;
                                i24 |= i32;
                                byte[] bArr6 = bArr2;
                                registers4 = registers2;
                                bArr4 = bArr6;
                                i19 = i4;
                                i23 = i11;
                                i22 = i27;
                                i20 = -1;
                            }
                            break;
                        case 2:
                        case 3:
                            ArrayDecoders.Registers registers6 = registers4;
                            byte[] bArr7 = bArr4;
                            i10 = iH;
                            i11 = i30;
                            if (i28 != 0) {
                                unsafe = unsafe3;
                                i6 = i10;
                                i9 = i11;
                                i8 = i27;
                                i7 = -1;
                                obj2 = obj4;
                            } else {
                                int iL2 = ArrayDecoders.L(bArr7, i10, registers6);
                                Unsafe unsafe4 = unsafe3;
                                Object obj5 = obj4;
                                unsafe4.putLong(obj5, jY, registers6.f38786b);
                                unsafe3 = unsafe4;
                                obj4 = obj5;
                                i24 |= i32;
                                registers4 = registers6;
                                bArr4 = bArr7;
                                i21 = iL2;
                                i23 = i11;
                                i22 = i27;
                                i20 = -1;
                                i19 = i4;
                            }
                            break;
                        case 4:
                        case 11:
                            ArrayDecoders.Registers registers7 = registers4;
                            byte[] bArr8 = bArr4;
                            i10 = iH;
                            i11 = i30;
                            if (i28 != 0) {
                                unsafe = unsafe3;
                                i6 = i10;
                                i9 = i11;
                                i8 = i27;
                                i7 = -1;
                                obj2 = obj4;
                            } else {
                                I = ArrayDecoders.I(bArr8, i10, registers7);
                                unsafe3.putInt(obj4, jY, registers7.f38785a);
                                i24 |= i32;
                                registers4 = registers7;
                                bArr4 = bArr8;
                                i19 = i4;
                                i21 = I;
                                i23 = i11;
                                i22 = i27;
                                i20 = -1;
                            }
                            break;
                        case 5:
                        case 14:
                            byte[] bArr9 = bArr4;
                            Object obj6 = obj4;
                            ArrayDecoders.Registers registers8 = registers4;
                            bArr2 = bArr9;
                            Unsafe unsafe5 = unsafe3;
                            int i34 = iH;
                            i11 = i30;
                            if (i28 != 1) {
                                obj4 = obj6;
                                i10 = i34;
                                unsafe3 = unsafe5;
                                unsafe = unsafe3;
                                i6 = i10;
                                i9 = i11;
                                i8 = i27;
                                i7 = -1;
                                obj2 = obj4;
                            } else {
                                registers2 = registers8;
                                unsafe5.putLong(obj6, jY, ArrayDecoders.j(bArr2, i34));
                                unsafe3 = unsafe5;
                                obj4 = obj6;
                                i21 = i34 + 8;
                                i24 |= i32;
                                byte[] bArr62 = bArr2;
                                registers4 = registers2;
                                bArr4 = bArr62;
                                i19 = i4;
                                i23 = i11;
                                i22 = i27;
                                i20 = -1;
                            }
                            break;
                        case 6:
                        case 13:
                            byte[] bArr10 = bArr4;
                            obj3 = obj4;
                            ArrayDecoders.Registers registers9 = registers4;
                            unsafe2 = unsafe3;
                            i12 = iH;
                            i11 = i30;
                            if (i28 != 5) {
                                Unsafe unsafe6 = unsafe2;
                                i10 = i12;
                                unsafe3 = unsafe6;
                                obj4 = obj3;
                                unsafe = unsafe3;
                                i6 = i10;
                                i9 = i11;
                                i8 = i27;
                                i7 = -1;
                                obj2 = obj4;
                            } else {
                                unsafe2.putInt(obj3, jY, ArrayDecoders.h(bArr10, i12));
                                i21 = i12 + 4;
                                i24 |= i32;
                                registers4 = registers9;
                                obj4 = obj3;
                                bArr4 = bArr10;
                                unsafe3 = unsafe2;
                                i23 = i11;
                                i22 = i27;
                                i20 = -1;
                                i19 = i4;
                            }
                            break;
                        case 7:
                            byte[] bArr11 = bArr4;
                            obj3 = obj4;
                            registers3 = registers4;
                            bArr3 = bArr11;
                            unsafe2 = unsafe3;
                            i12 = iH;
                            i11 = i30;
                            if (i28 != 0) {
                                Unsafe unsafe62 = unsafe2;
                                i10 = i12;
                                unsafe3 = unsafe62;
                                obj4 = obj3;
                                unsafe = unsafe3;
                                i6 = i10;
                                i9 = i11;
                                i8 = i27;
                                i7 = -1;
                                obj2 = obj4;
                            } else {
                                iL = ArrayDecoders.L(bArr3, i12, registers3);
                                UnsafeUtil.N(obj3, jY, registers3.f38786b != 0);
                                i24 |= i32;
                                byte[] bArr12 = bArr3;
                                registers4 = registers3;
                                obj4 = obj3;
                                bArr4 = bArr12;
                                i21 = iL;
                                unsafe3 = unsafe2;
                                i23 = i11;
                                i22 = i27;
                                i20 = -1;
                                i19 = i4;
                            }
                            break;
                        case 8:
                            byte[] bArr13 = bArr4;
                            obj3 = obj4;
                            registers3 = registers4;
                            bArr3 = bArr13;
                            unsafe2 = unsafe3;
                            i12 = iH;
                            i11 = i30;
                            if (i28 != 2) {
                                Unsafe unsafe622 = unsafe2;
                                i10 = i12;
                                unsafe3 = unsafe622;
                                obj4 = obj3;
                                unsafe = unsafe3;
                                i6 = i10;
                                i9 = i11;
                                i8 = i27;
                                i7 = -1;
                                obj2 = obj4;
                            } else {
                                iL = (i29 & 536870912) == 0 ? ArrayDecoders.C(bArr3, i12, registers3) : ArrayDecoders.F(bArr3, i12, registers3);
                                unsafe2.putObject(obj3, jY, registers3.f38787c);
                                i24 |= i32;
                                byte[] bArr122 = bArr3;
                                registers4 = registers3;
                                obj4 = obj3;
                                bArr4 = bArr122;
                                i21 = iL;
                                unsafe3 = unsafe2;
                                i23 = i11;
                                i22 = i27;
                                i20 = -1;
                                i19 = i4;
                            }
                            break;
                        case 9:
                            i11 = i30;
                            if (i28 != 2) {
                                obj4 = obj4;
                                i10 = iH;
                                unsafe = unsafe3;
                                i6 = i10;
                                i9 = i11;
                                i8 = i27;
                                i7 = -1;
                                obj2 = obj4;
                            } else {
                                Object obj7 = obj4;
                                Object objS = messageSchema.S(obj7, i11);
                                byte[] bArr14 = bArr4;
                                obj3 = obj7;
                                int i35 = i19;
                                unsafe2 = unsafe3;
                                int i36 = iH;
                                ArrayDecoders.Registers registers10 = registers4;
                                iL = ArrayDecoders.O(objS, messageSchema.v(i11), bArr14, i36, i35, registers10);
                                bArr3 = bArr14;
                                registers3 = registers10;
                                messageSchema.v0(obj3, i11, objS);
                                i24 |= i32;
                                byte[] bArr1222 = bArr3;
                                registers4 = registers3;
                                obj4 = obj3;
                                bArr4 = bArr1222;
                                i21 = iL;
                                unsafe3 = unsafe2;
                                i23 = i11;
                                i22 = i27;
                                i20 = -1;
                                i19 = i4;
                            }
                            break;
                        case 10:
                            i11 = i30;
                            if (i28 != 2) {
                                i10 = iH;
                                unsafe = unsafe3;
                                i6 = i10;
                                i9 = i11;
                                i8 = i27;
                                i7 = -1;
                                obj2 = obj4;
                            } else {
                                I = ArrayDecoders.b(bArr4, iH, registers4);
                                unsafe3.putObject(obj4, jY, registers4.f38787c);
                                i24 |= i32;
                                i21 = I;
                                i23 = i11;
                                i22 = i27;
                                i20 = -1;
                            }
                            break;
                        case 12:
                            i11 = i30;
                            if (i28 != 0) {
                                i10 = iH;
                                unsafe = unsafe3;
                                i6 = i10;
                                i9 = i11;
                                i8 = i27;
                                i7 = -1;
                                obj2 = obj4;
                            } else {
                                I = ArrayDecoders.I(bArr4, iH, registers4);
                                unsafe3.putInt(obj4, jY, registers4.f38785a);
                                i24 |= i32;
                                i21 = I;
                                i23 = i11;
                                i22 = i27;
                                i20 = -1;
                            }
                            break;
                        case 15:
                            i11 = i30;
                            if (i28 != 0) {
                                i10 = iH;
                                unsafe = unsafe3;
                                i6 = i10;
                                i9 = i11;
                                i8 = i27;
                                i7 = -1;
                                obj2 = obj4;
                            } else {
                                I = ArrayDecoders.I(bArr4, iH, registers4);
                                unsafe3.putInt(obj4, jY, CodedInputStream.b(registers4.f38785a));
                                i24 |= i32;
                                i21 = I;
                                i23 = i11;
                                i22 = i27;
                                i20 = -1;
                            }
                            break;
                        case 16:
                            if (i28 != 0) {
                                i10 = iH;
                                i11 = i30;
                                unsafe = unsafe3;
                                i6 = i10;
                                i9 = i11;
                                i8 = i27;
                                i7 = -1;
                                obj2 = obj4;
                            } else {
                                int iL3 = ArrayDecoders.L(bArr4, iH, registers4);
                                Unsafe unsafe7 = unsafe3;
                                Object obj8 = obj4;
                                unsafe7.putLong(obj8, jY, CodedInputStream.c(registers4.f38786b));
                                unsafe3 = unsafe7;
                                obj4 = obj8;
                                i24 |= i32;
                                i21 = iL3;
                                i22 = i27;
                                i23 = i30;
                                i20 = -1;
                            }
                            break;
                        default:
                            i10 = iH;
                            i11 = i30;
                            unsafe = unsafe3;
                            i6 = i10;
                            i9 = i11;
                            i8 = i27;
                            i7 = -1;
                            obj2 = obj4;
                            break;
                    }
                } else {
                    int i37 = iH;
                    byte[] bArr15 = bArr4;
                    if (iX0 != 27) {
                        Unsafe unsafe8 = unsafe3;
                        if (iX0 <= 49) {
                            i16 = i24;
                            unsafe = unsafe8;
                            i7 = -1;
                            i18 = i25;
                            int iI0 = messageSchema.i0(obj, bArr, i37, i4, i5 == true ? 1 : 0, i27, i28, i30, i29, iX0, jY, registers);
                            i17 = i27;
                            i9 = i30;
                            if (iI0 != i37) {
                                messageSchema = this;
                                obj4 = obj;
                                i19 = i4;
                                registers4 = registers;
                                i21 = iI0;
                                i22 = i17;
                                i25 = i18;
                                i20 = -1;
                                i23 = i9;
                                i24 = i16;
                                unsafe3 = unsafe;
                                bArr4 = bArr;
                            } else {
                                obj2 = obj;
                                i6 = iI0;
                                i8 = i17;
                            }
                        } else {
                            unsafe = unsafe8;
                            i16 = i24;
                            i9 = i30;
                            i7 = -1;
                            i18 = i25;
                            i17 = i27;
                            i15 = i37;
                            if (iX0 != 50) {
                                i8 = i17;
                                int iF0 = f0(obj, bArr, i15, i4, i5 == true ? 1 : 0, i8, i28, i29, iX0, jY, i9, registers);
                                obj2 = obj;
                                if (iF0 != i15) {
                                    messageSchema = this;
                                    registers4 = registers;
                                    i22 = i8;
                                    i21 = iF0;
                                    obj4 = obj2;
                                    i25 = i18;
                                    i20 = -1;
                                    i23 = i9;
                                    i24 = i16;
                                    unsafe3 = unsafe;
                                    bArr4 = bArr;
                                    i19 = i4;
                                } else {
                                    i6 = iF0;
                                }
                            } else if (i28 == 2) {
                                int iE0 = e0(obj, bArr, i15, i4, i9, jY, registers);
                                if (iE0 != i15) {
                                    messageSchema = this;
                                    obj4 = obj;
                                    bArr4 = bArr;
                                    i19 = i4;
                                    registers4 = registers;
                                    i21 = iE0;
                                    i22 = i17;
                                    i25 = i18;
                                    i20 = -1;
                                    i23 = i9;
                                    i24 = i16;
                                    unsafe3 = unsafe;
                                } else {
                                    obj2 = obj;
                                    i6 = iE0;
                                    i8 = i17;
                                }
                            } else {
                                obj2 = obj;
                                i6 = i15;
                                i8 = i17;
                            }
                        }
                    } else if (i28 == 2) {
                        Internal.ProtobufList protobufListC = (Internal.ProtobufList) unsafe3.getObject(obj4, jY);
                        if (!protobufListC.m()) {
                            int size = protobufListC.size();
                            protobufListC = protobufListC.c(size == 0 ? 10 : size * 2);
                            unsafe3.putObject(obj4, jY, protobufListC);
                        }
                        int iQ = ArrayDecoders.q(messageSchema.v(i30), i5 == true ? 1 : 0, bArr15, i37, i4, protobufListC, registers);
                        bArr4 = bArr;
                        registers4 = registers;
                        i21 = iQ;
                        unsafe3 = unsafe3;
                        i22 = i27;
                        i23 = i30;
                        i20 = -1;
                        obj4 = obj;
                        i19 = i4;
                    } else {
                        i15 = i37;
                        unsafe = unsafe3;
                        i16 = i24;
                        i17 = i27;
                        i9 = i30;
                        i7 = -1;
                        i18 = i25;
                        obj2 = obj;
                        i6 = i15;
                        i8 = i17;
                    }
                    i25 = i18;
                    i24 = i16;
                }
            }
            int iG = ArrayDecoders.G(i5 == true ? 1 : 0, bArr, i6, i4, w(obj2), registers);
            bArr4 = bArr;
            registers4 = registers;
            i22 = i8;
            obj4 = obj2;
            i20 = i7;
            i23 = i9;
            unsafe3 = unsafe;
            i19 = i4;
            i21 = iG;
            messageSchema = this;
        }
        Unsafe unsafe9 = unsafe3;
        int i38 = i19;
        int i39 = i25;
        int i40 = i24;
        Object obj9 = obj4;
        if (i39 != 1048575) {
            unsafe9.putInt(obj9, i39, i40);
        }
        if (i21 == i38) {
            return i21;
        }
        throw InvalidProtocolBufferException.h();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int i0(Object obj, byte[] bArr, int i3, int i4, int i5, int i6, int i7, int i8, long j3, int i9, long j4, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        int iJ;
        Unsafe unsafe = f39159s;
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
                    return ArrayDecoders.s(bArr, i3, protobufList, registers);
                }
                if (i7 == 1) {
                    return ArrayDecoders.e(i5, bArr, i3, i4, protobufList, registers);
                }
                return i3;
            case 19:
            case 36:
                if (i7 == 2) {
                    return ArrayDecoders.v(bArr, i3, protobufList, registers);
                }
                if (i7 == 5) {
                    return ArrayDecoders.m(i5, bArr, i3, i4, protobufList, registers);
                }
                return i3;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i7 == 2) {
                    return ArrayDecoders.z(bArr, i3, protobufList, registers);
                }
                if (i7 == 0) {
                    return ArrayDecoders.M(i5, bArr, i3, i4, protobufList, registers);
                }
                return i3;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i7 == 2) {
                    return ArrayDecoders.y(bArr, i3, protobufList, registers);
                }
                if (i7 == 0) {
                    return ArrayDecoders.J(i5, bArr, i3, i4, protobufList, registers);
                }
                return i3;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i7 == 2) {
                    return ArrayDecoders.u(bArr, i3, protobufList, registers);
                }
                if (i7 == 1) {
                    return ArrayDecoders.k(i5, bArr, i3, i4, protobufList, registers);
                }
                return i3;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i7 == 2) {
                    return ArrayDecoders.t(bArr, i3, protobufList, registers);
                }
                if (i7 == 5) {
                    return ArrayDecoders.i(i5, bArr, i3, i4, protobufList, registers);
                }
                return i3;
            case 25:
            case 42:
                if (i7 == 2) {
                    return ArrayDecoders.r(bArr, i3, protobufList, registers);
                }
                if (i7 == 0) {
                    return ArrayDecoders.a(i5, bArr, i3, i4, protobufList, registers);
                }
                return i3;
            case 26:
                if (i7 == 2) {
                    return (j3 & 536870912) == 0 ? ArrayDecoders.D(i5, bArr, i3, i4, protobufList, registers) : ArrayDecoders.E(i5, bArr, i3, i4, protobufList, registers);
                }
                return i3;
            case 27:
                if (i7 == 2) {
                    return ArrayDecoders.q(v(i8), i5, bArr, i3, i4, protobufList, registers);
                }
                return i3;
            case 28:
                if (i7 == 2) {
                    return ArrayDecoders.c(i5, bArr, i3, i4, protobufList, registers);
                }
                return i3;
            case 30:
            case 44:
                if (i7 != 2) {
                    if (i7 == 0) {
                        iJ = ArrayDecoders.J(i5, bArr, i3, i4, protobufList, registers);
                    }
                    return i3;
                }
                iJ = ArrayDecoders.y(bArr, i3, protobufList, registers);
                SchemaUtil.A(obj, i6, protobufList, t(i8), null, this.f39174o);
                return iJ;
            case 33:
            case 47:
                if (i7 == 2) {
                    return ArrayDecoders.w(bArr, i3, protobufList, registers);
                }
                if (i7 == 0) {
                    return ArrayDecoders.A(i5, bArr, i3, i4, protobufList, registers);
                }
                return i3;
            case 34:
            case 48:
                if (i7 == 2) {
                    return ArrayDecoders.x(bArr, i3, protobufList, registers);
                }
                if (i7 == 0) {
                    return ArrayDecoders.B(i5, bArr, i3, i4, protobufList, registers);
                }
                return i3;
            case 49:
                if (i7 == 3) {
                    return ArrayDecoders.o(v(i8), i5, bArr, i3, i4, protobufList, registers);
                }
                return i3;
            default:
                return i3;
        }
    }

    private boolean j(Object obj, Object obj2, int i3) {
        return C(obj, i3) == C(obj2, i3);
    }

    private int j0(int i3) {
        if (i3 < this.f39162c || i3 > this.f39163d) {
            return -1;
        }
        return t0(i3, 0);
    }

    private static boolean k(Object obj, long j3) {
        return UnsafeUtil.u(obj, j3);
    }

    private int k0(int i3, int i4) {
        if (i3 < this.f39162c || i3 > this.f39163d) {
            return -1;
        }
        return t0(i3, i4);
    }

    private static void l(Object obj) {
        if (H(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + obj);
    }

    private int l0(int i3) {
        return this.f39160a[i3 + 2];
    }

    private int m(byte[] bArr, int i3, int i4, MapEntryLite.Metadata metadata, Map map, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        int I = ArrayDecoders.I(bArr, i3, registers);
        int i5 = registers.f38785a;
        if (i5 < 0 || i5 > i4 - I) {
            throw InvalidProtocolBufferException.m();
        }
        int i6 = I + i5;
        Object obj = metadata.f39150b;
        Object obj2 = metadata.f39152d;
        while (I < i6) {
            int iH = I + 1;
            int i7 = bArr[I];
            if (i7 < 0) {
                iH = ArrayDecoders.H(i7, bArr, iH, registers);
                i7 = registers.f38785a;
            }
            int i8 = iH;
            int i9 = i7 >>> 3;
            int i10 = i7 & 7;
            if (i9 != 1) {
                if (i9 == 2 && i10 == metadata.f39151c.b()) {
                    I = n(bArr, i8, i4, metadata.f39151c, metadata.f39152d.getClass(), registers);
                    obj2 = registers.f38787c;
                } else {
                    I = ArrayDecoders.P(i7, bArr, i8, i4, registers);
                }
            } else if (i10 == metadata.f39149a.b()) {
                I = n(bArr, i8, i4, metadata.f39149a, null, registers);
                obj = registers.f38787c;
            } else {
                I = ArrayDecoders.P(i7, bArr, i8, i4, registers);
            }
        }
        if (I != i6) {
            throw InvalidProtocolBufferException.h();
        }
        map.put(obj, obj2);
        return i6;
    }

    private void m0(Object obj, long j3, Reader reader, Schema schema, ExtensionRegistryLite extensionRegistryLite) {
        reader.K(this.f39173n.e(obj, j3), schema, extensionRegistryLite);
    }

    private int n(byte[] bArr, int i3, int i4, WireFormat.FieldType fieldType, Class cls, ArrayDecoders.Registers registers) {
        switch (AnonymousClass1.f39177a[fieldType.ordinal()]) {
            case 1:
                int iL = ArrayDecoders.L(bArr, i3, registers);
                registers.f38787c = Boolean.valueOf(registers.f38786b != 0);
                return iL;
            case 2:
                return ArrayDecoders.b(bArr, i3, registers);
            case 3:
                registers.f38787c = Double.valueOf(ArrayDecoders.d(bArr, i3));
                return i3 + 8;
            case 4:
            case 5:
                registers.f38787c = Integer.valueOf(ArrayDecoders.h(bArr, i3));
                return i3 + 4;
            case 6:
            case 7:
                registers.f38787c = Long.valueOf(ArrayDecoders.j(bArr, i3));
                return i3 + 8;
            case 8:
                registers.f38787c = Float.valueOf(ArrayDecoders.l(bArr, i3));
                return i3 + 4;
            case 9:
            case 10:
            case 11:
                int I = ArrayDecoders.I(bArr, i3, registers);
                registers.f38787c = Integer.valueOf(registers.f38785a);
                return I;
            case 12:
            case 13:
                int iL2 = ArrayDecoders.L(bArr, i3, registers);
                registers.f38787c = Long.valueOf(registers.f38786b);
                return iL2;
            case 14:
                return ArrayDecoders.p(Protobuf.a().c(cls), bArr, i3, i4, registers);
            case 15:
                int I2 = ArrayDecoders.I(bArr, i3, registers);
                registers.f38787c = Integer.valueOf(CodedInputStream.b(registers.f38785a));
                return I2;
            case 16:
                int iL3 = ArrayDecoders.L(bArr, i3, registers);
                registers.f38787c = Long.valueOf(CodedInputStream.c(registers.f38786b));
                return iL3;
            case 17:
                return ArrayDecoders.F(bArr, i3, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private void n0(Object obj, int i3, Reader reader, Schema schema, ExtensionRegistryLite extensionRegistryLite) {
        reader.M(this.f39173n.e(obj, Y(i3)), schema, extensionRegistryLite);
    }

    private static double o(Object obj, long j3) {
        return UnsafeUtil.B(obj, j3);
    }

    private void o0(Object obj, int i3, Reader reader) {
        if (B(i3)) {
            UnsafeUtil.Y(obj, Y(i3), reader.I());
        } else if (this.f39166g) {
            UnsafeUtil.Y(obj, Y(i3), reader.z());
        } else {
            UnsafeUtil.Y(obj, Y(i3), reader.o());
        }
    }

    private boolean p(Object obj, Object obj2, int i3) {
        int iY0 = y0(i3);
        long jY = Y(iY0);
        switch (x0(iY0)) {
            case 0:
                if (!j(obj, obj2, i3) || Double.doubleToLongBits(UnsafeUtil.B(obj, jY)) != Double.doubleToLongBits(UnsafeUtil.B(obj2, jY))) {
                }
                break;
            case 1:
                if (!j(obj, obj2, i3) || Float.floatToIntBits(UnsafeUtil.C(obj, jY)) != Float.floatToIntBits(UnsafeUtil.C(obj2, jY))) {
                }
                break;
            case 2:
                if (!j(obj, obj2, i3) || UnsafeUtil.F(obj, jY) != UnsafeUtil.F(obj2, jY)) {
                }
                break;
            case 3:
                if (!j(obj, obj2, i3) || UnsafeUtil.F(obj, jY) != UnsafeUtil.F(obj2, jY)) {
                }
                break;
            case 4:
                if (!j(obj, obj2, i3) || UnsafeUtil.D(obj, jY) != UnsafeUtil.D(obj2, jY)) {
                }
                break;
            case 5:
                if (!j(obj, obj2, i3) || UnsafeUtil.F(obj, jY) != UnsafeUtil.F(obj2, jY)) {
                }
                break;
            case 6:
                if (!j(obj, obj2, i3) || UnsafeUtil.D(obj, jY) != UnsafeUtil.D(obj2, jY)) {
                }
                break;
            case 7:
                if (!j(obj, obj2, i3) || UnsafeUtil.u(obj, jY) != UnsafeUtil.u(obj2, jY)) {
                }
                break;
            case 8:
                if (!j(obj, obj2, i3) || !SchemaUtil.K(UnsafeUtil.H(obj, jY), UnsafeUtil.H(obj2, jY))) {
                }
                break;
            case 9:
                if (!j(obj, obj2, i3) || !SchemaUtil.K(UnsafeUtil.H(obj, jY), UnsafeUtil.H(obj2, jY))) {
                }
                break;
            case 10:
                if (!j(obj, obj2, i3) || !SchemaUtil.K(UnsafeUtil.H(obj, jY), UnsafeUtil.H(obj2, jY))) {
                }
                break;
            case 11:
                if (!j(obj, obj2, i3) || UnsafeUtil.D(obj, jY) != UnsafeUtil.D(obj2, jY)) {
                }
                break;
            case 12:
                if (!j(obj, obj2, i3) || UnsafeUtil.D(obj, jY) != UnsafeUtil.D(obj2, jY)) {
                }
                break;
            case 13:
                if (!j(obj, obj2, i3) || UnsafeUtil.D(obj, jY) != UnsafeUtil.D(obj2, jY)) {
                }
                break;
            case 14:
                if (!j(obj, obj2, i3) || UnsafeUtil.F(obj, jY) != UnsafeUtil.F(obj2, jY)) {
                }
                break;
            case 15:
                if (!j(obj, obj2, i3) || UnsafeUtil.D(obj, jY) != UnsafeUtil.D(obj2, jY)) {
                }
                break;
            case 16:
                if (!j(obj, obj2, i3) || UnsafeUtil.F(obj, jY) != UnsafeUtil.F(obj2, jY)) {
                }
                break;
            case 17:
                if (!j(obj, obj2, i3) || !SchemaUtil.K(UnsafeUtil.H(obj, jY), UnsafeUtil.H(obj2, jY))) {
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
                if (!I(obj, obj2, i3) || !SchemaUtil.K(UnsafeUtil.H(obj, jY), UnsafeUtil.H(obj2, jY))) {
                }
                break;
        }
        return true;
    }

    private void p0(Object obj, int i3, Reader reader) {
        if (B(i3)) {
            reader.n(this.f39173n.e(obj, Y(i3)));
        } else {
            reader.B(this.f39173n.e(obj, Y(i3)));
        }
    }

    private Object q(Object obj, int i3, Object obj2, UnknownFieldSchema unknownFieldSchema, Object obj3) {
        Internal.EnumVerifier enumVerifierT;
        int iX = X(i3);
        Object objH = UnsafeUtil.H(obj, Y(y0(i3)));
        return (objH == null || (enumVerifierT = t(i3)) == null) ? obj2 : r(i3, iX, this.f39176q.c(objH), enumVerifierT, obj2, unknownFieldSchema, obj3);
    }

    private Object r(int i3, int i4, Map map, Internal.EnumVerifier enumVerifier, Object obj, UnknownFieldSchema unknownFieldSchema, Object obj2) {
        MapEntryLite.Metadata metadataB = this.f39176q.b(u(i3));
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

    private void r0(Object obj, int i3) {
        int iL0 = l0(i3);
        long j3 = 1048575 & iL0;
        if (j3 == 1048575) {
            return;
        }
        UnsafeUtil.W(obj, j3, (1 << (iL0 >>> 20)) | UnsafeUtil.D(obj, j3));
    }

    private static float s(Object obj, long j3) {
        return UnsafeUtil.C(obj, j3);
    }

    private void s0(Object obj, int i3, int i4) {
        UnsafeUtil.W(obj, l0(i4) & 1048575, i3);
    }

    private Internal.EnumVerifier t(int i3) {
        return (Internal.EnumVerifier) this.f39161b[((i3 / 3) * 2) + 1];
    }

    private int t0(int i3, int i4) {
        int length = (this.f39160a.length / 3) - 1;
        while (i4 <= length) {
            int i5 = (length + i4) >>> 1;
            int i6 = i5 * 3;
            int iX = X(i6);
            if (i3 == iX) {
                return i6;
            }
            if (i3 < iX) {
                length = i5 - 1;
            } else {
                i4 = i5 + 1;
            }
        }
        return -1;
    }

    private Object u(int i3) {
        return this.f39161b[(i3 / 3) * 2];
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
    private static void u0(androidx.glance.appwidget.protobuf.FieldInfo r8, int[] r9, int r10, java.lang.Object[] r11) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.protobuf.MessageSchema.u0(androidx.glance.appwidget.protobuf.FieldInfo, int[], int, java.lang.Object[]):void");
    }

    private Schema v(int i3) {
        int i4 = (i3 / 3) * 2;
        Schema schema = (Schema) this.f39161b[i4];
        if (schema != null) {
            return schema;
        }
        Schema schemaC = Protobuf.a().c((Class) this.f39161b[i4 + 1]);
        this.f39161b[i4] = schemaC;
        return schemaC;
    }

    private void v0(Object obj, int i3, Object obj2) {
        f39159s.putObject(obj, Y(y0(i3)), obj2);
        r0(obj, i3);
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

    private void w0(Object obj, int i3, int i4, Object obj2) {
        f39159s.putObject(obj, Y(y0(i4)), obj2);
        s0(obj, i3, i4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int x(Object obj) {
        int i3;
        int i4;
        int iA0;
        int iV;
        boolean z2;
        int iF;
        int i5;
        int iM0;
        int iO0;
        Unsafe unsafe = f39159s;
        int i6 = 1048575;
        int i7 = 1048575;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i8 < this.f39160a.length) {
            int iY0 = y0(i8);
            int iX = X(i8);
            int iX0 = x0(iY0);
            if (iX0 <= 17) {
                i3 = this.f39160a[i8 + 2];
                int i11 = i3 & i6;
                i4 = 1 << (i3 >>> 20);
                if (i11 != i7) {
                    i10 = unsafe.getInt(obj, i11);
                    i7 = i11;
                }
            } else {
                i3 = (!this.f39168i || iX0 < FieldType.P.a() || iX0 > FieldType.f39008c0.a()) ? 0 : this.f39160a[i8 + 2] & i6;
                i4 = 0;
            }
            long jY = Y(iY0);
            switch (iX0) {
                case 0:
                    if ((i10 & i4) != 0) {
                        iA0 = CodedOutputStream.a0(iX, 0.0d);
                        i9 += iA0;
                    }
                    break;
                case 1:
                    if ((i10 & i4) != 0) {
                        iA0 = CodedOutputStream.i0(iX, 0.0f);
                        i9 += iA0;
                    }
                    break;
                case 2:
                    if ((i10 & i4) != 0) {
                        iA0 = CodedOutputStream.p0(iX, unsafe.getLong(obj, jY));
                        i9 += iA0;
                    }
                    break;
                case 3:
                    if ((i10 & i4) != 0) {
                        iA0 = CodedOutputStream.P0(iX, unsafe.getLong(obj, jY));
                        i9 += iA0;
                    }
                    break;
                case 4:
                    if ((i10 & i4) != 0) {
                        iA0 = CodedOutputStream.n0(iX, unsafe.getInt(obj, jY));
                        i9 += iA0;
                    }
                    break;
                case 5:
                    if ((i10 & i4) != 0) {
                        iA0 = CodedOutputStream.g0(iX, 0L);
                        i9 += iA0;
                    }
                    break;
                case 6:
                    if ((i10 & i4) != 0) {
                        iA0 = CodedOutputStream.e0(iX, 0);
                        i9 += iA0;
                    }
                    break;
                case 7:
                    if ((i10 & i4) != 0) {
                        iV = CodedOutputStream.V(iX, true);
                        i9 += iV;
                    }
                    break;
                case 8:
                    if ((i10 & i4) != 0) {
                        Object object = unsafe.getObject(obj, jY);
                        iV = object instanceof ByteString ? CodedOutputStream.Y(iX, (ByteString) object) : CodedOutputStream.K0(iX, (String) object);
                        i9 += iV;
                    }
                    break;
                case 9:
                    if ((i10 & i4) != 0) {
                        iV = SchemaUtil.o(iX, unsafe.getObject(obj, jY), v(i8));
                        i9 += iV;
                    }
                    break;
                case 10:
                    if ((i10 & i4) != 0) {
                        iV = CodedOutputStream.Y(iX, (ByteString) unsafe.getObject(obj, jY));
                        i9 += iV;
                    }
                    break;
                case 11:
                    if ((i10 & i4) != 0) {
                        iV = CodedOutputStream.N0(iX, unsafe.getInt(obj, jY));
                        i9 += iV;
                    }
                    break;
                case 12:
                    if ((i10 & i4) != 0) {
                        iV = CodedOutputStream.c0(iX, unsafe.getInt(obj, jY));
                        i9 += iV;
                    }
                    break;
                case 13:
                    if ((i10 & i4) != 0) {
                        iV = CodedOutputStream.C0(iX, 0);
                        i9 += iV;
                    }
                    break;
                case 14:
                    if ((i10 & i4) != 0) {
                        iV = CodedOutputStream.E0(iX, 0L);
                        i9 += iV;
                    }
                    break;
                case 15:
                    if ((i10 & i4) != 0) {
                        iV = CodedOutputStream.G0(iX, unsafe.getInt(obj, jY));
                        i9 += iV;
                    }
                    break;
                case 16:
                    if ((i10 & i4) != 0) {
                        iV = CodedOutputStream.I0(iX, unsafe.getLong(obj, jY));
                        i9 += iV;
                    }
                    break;
                case 17:
                    if ((i10 & i4) != 0) {
                        iV = CodedOutputStream.k0(iX, (MessageLite) unsafe.getObject(obj, jY), v(i8));
                        i9 += iV;
                    }
                    break;
                case 18:
                    iV = SchemaUtil.h(iX, (List) unsafe.getObject(obj, jY), false);
                    i9 += iV;
                    break;
                case 19:
                    z2 = false;
                    iF = SchemaUtil.f(iX, (List) unsafe.getObject(obj, jY), false);
                    i9 += iF;
                    break;
                case 20:
                    z2 = false;
                    iF = SchemaUtil.m(iX, (List) unsafe.getObject(obj, jY), false);
                    i9 += iF;
                    break;
                case 21:
                    z2 = false;
                    iF = SchemaUtil.x(iX, (List) unsafe.getObject(obj, jY), false);
                    i9 += iF;
                    break;
                case 22:
                    z2 = false;
                    iF = SchemaUtil.k(iX, (List) unsafe.getObject(obj, jY), false);
                    i9 += iF;
                    break;
                case 23:
                    z2 = false;
                    iF = SchemaUtil.h(iX, (List) unsafe.getObject(obj, jY), false);
                    i9 += iF;
                    break;
                case 24:
                    z2 = false;
                    iF = SchemaUtil.f(iX, (List) unsafe.getObject(obj, jY), false);
                    i9 += iF;
                    break;
                case 25:
                    z2 = false;
                    iF = SchemaUtil.a(iX, (List) unsafe.getObject(obj, jY), false);
                    i9 += iF;
                    break;
                case 26:
                    iV = SchemaUtil.u(iX, (List) unsafe.getObject(obj, jY));
                    i9 += iV;
                    break;
                case 27:
                    iV = SchemaUtil.p(iX, (List) unsafe.getObject(obj, jY), v(i8));
                    i9 += iV;
                    break;
                case 28:
                    iV = SchemaUtil.c(iX, (List) unsafe.getObject(obj, jY));
                    i9 += iV;
                    break;
                case 29:
                    iV = SchemaUtil.v(iX, (List) unsafe.getObject(obj, jY), false);
                    i9 += iV;
                    break;
                case 30:
                    z2 = false;
                    iF = SchemaUtil.d(iX, (List) unsafe.getObject(obj, jY), false);
                    i9 += iF;
                    break;
                case 31:
                    z2 = false;
                    iF = SchemaUtil.f(iX, (List) unsafe.getObject(obj, jY), false);
                    i9 += iF;
                    break;
                case 32:
                    z2 = false;
                    iF = SchemaUtil.h(iX, (List) unsafe.getObject(obj, jY), false);
                    i9 += iF;
                    break;
                case 33:
                    z2 = false;
                    iF = SchemaUtil.q(iX, (List) unsafe.getObject(obj, jY), false);
                    i9 += iF;
                    break;
                case 34:
                    z2 = false;
                    iF = SchemaUtil.s(iX, (List) unsafe.getObject(obj, jY), false);
                    i9 += iF;
                    break;
                case 35:
                    i5 = SchemaUtil.i((List) unsafe.getObject(obj, jY));
                    if (i5 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i3, i5);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i5);
                        i9 += iM0 + iO0 + i5;
                    }
                    break;
                case 36:
                    i5 = SchemaUtil.g((List) unsafe.getObject(obj, jY));
                    if (i5 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i3, i5);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i5);
                        i9 += iM0 + iO0 + i5;
                    }
                    break;
                case 37:
                    i5 = SchemaUtil.n((List) unsafe.getObject(obj, jY));
                    if (i5 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i3, i5);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i5);
                        i9 += iM0 + iO0 + i5;
                    }
                    break;
                case 38:
                    i5 = SchemaUtil.y((List) unsafe.getObject(obj, jY));
                    if (i5 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i3, i5);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i5);
                        i9 += iM0 + iO0 + i5;
                    }
                    break;
                case 39:
                    i5 = SchemaUtil.l((List) unsafe.getObject(obj, jY));
                    if (i5 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i3, i5);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i5);
                        i9 += iM0 + iO0 + i5;
                    }
                    break;
                case 40:
                    i5 = SchemaUtil.i((List) unsafe.getObject(obj, jY));
                    if (i5 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i3, i5);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i5);
                        i9 += iM0 + iO0 + i5;
                    }
                    break;
                case 41:
                    i5 = SchemaUtil.g((List) unsafe.getObject(obj, jY));
                    if (i5 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i3, i5);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i5);
                        i9 += iM0 + iO0 + i5;
                    }
                    break;
                case 42:
                    i5 = SchemaUtil.b((List) unsafe.getObject(obj, jY));
                    if (i5 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i3, i5);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i5);
                        i9 += iM0 + iO0 + i5;
                    }
                    break;
                case 43:
                    i5 = SchemaUtil.w((List) unsafe.getObject(obj, jY));
                    if (i5 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i3, i5);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i5);
                        i9 += iM0 + iO0 + i5;
                    }
                    break;
                case 44:
                    i5 = SchemaUtil.e((List) unsafe.getObject(obj, jY));
                    if (i5 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i3, i5);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i5);
                        i9 += iM0 + iO0 + i5;
                    }
                    break;
                case 45:
                    i5 = SchemaUtil.g((List) unsafe.getObject(obj, jY));
                    if (i5 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i3, i5);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i5);
                        i9 += iM0 + iO0 + i5;
                    }
                    break;
                case 46:
                    i5 = SchemaUtil.i((List) unsafe.getObject(obj, jY));
                    if (i5 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i3, i5);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i5);
                        i9 += iM0 + iO0 + i5;
                    }
                    break;
                case 47:
                    i5 = SchemaUtil.r((List) unsafe.getObject(obj, jY));
                    if (i5 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i3, i5);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i5);
                        i9 += iM0 + iO0 + i5;
                    }
                    break;
                case 48:
                    i5 = SchemaUtil.t((List) unsafe.getObject(obj, jY));
                    if (i5 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i3, i5);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i5);
                        i9 += iM0 + iO0 + i5;
                    }
                    break;
                case 49:
                    iV = SchemaUtil.j(iX, (List) unsafe.getObject(obj, jY), v(i8));
                    i9 += iV;
                    break;
                case 50:
                    iV = this.f39176q.g(iX, unsafe.getObject(obj, jY), u(i8));
                    i9 += iV;
                    break;
                case 51:
                    if (J(obj, iX, i8)) {
                        iV = CodedOutputStream.a0(iX, 0.0d);
                        i9 += iV;
                    }
                    break;
                case 52:
                    if (J(obj, iX, i8)) {
                        iV = CodedOutputStream.i0(iX, 0.0f);
                        i9 += iV;
                    }
                    break;
                case 53:
                    if (J(obj, iX, i8)) {
                        iV = CodedOutputStream.p0(iX, d0(obj, jY));
                        i9 += iV;
                    }
                    break;
                case 54:
                    if (J(obj, iX, i8)) {
                        iV = CodedOutputStream.P0(iX, d0(obj, jY));
                        i9 += iV;
                    }
                    break;
                case 55:
                    if (J(obj, iX, i8)) {
                        iV = CodedOutputStream.n0(iX, c0(obj, jY));
                        i9 += iV;
                    }
                    break;
                case 56:
                    if (J(obj, iX, i8)) {
                        iV = CodedOutputStream.g0(iX, 0L);
                        i9 += iV;
                    }
                    break;
                case 57:
                    if (J(obj, iX, i8)) {
                        iV = CodedOutputStream.e0(iX, 0);
                        i9 += iV;
                    }
                    break;
                case 58:
                    if (J(obj, iX, i8)) {
                        iV = CodedOutputStream.V(iX, true);
                        i9 += iV;
                    }
                    break;
                case 59:
                    if (J(obj, iX, i8)) {
                        Object object2 = unsafe.getObject(obj, jY);
                        iV = object2 instanceof ByteString ? CodedOutputStream.Y(iX, (ByteString) object2) : CodedOutputStream.K0(iX, (String) object2);
                        i9 += iV;
                    }
                    break;
                case 60:
                    if (J(obj, iX, i8)) {
                        iV = SchemaUtil.o(iX, unsafe.getObject(obj, jY), v(i8));
                        i9 += iV;
                    }
                    break;
                case 61:
                    if (J(obj, iX, i8)) {
                        iV = CodedOutputStream.Y(iX, (ByteString) unsafe.getObject(obj, jY));
                        i9 += iV;
                    }
                    break;
                case 62:
                    if (J(obj, iX, i8)) {
                        iV = CodedOutputStream.N0(iX, c0(obj, jY));
                        i9 += iV;
                    }
                    break;
                case 63:
                    if (J(obj, iX, i8)) {
                        iV = CodedOutputStream.c0(iX, c0(obj, jY));
                        i9 += iV;
                    }
                    break;
                case 64:
                    if (J(obj, iX, i8)) {
                        iV = CodedOutputStream.C0(iX, 0);
                        i9 += iV;
                    }
                    break;
                case 65:
                    if (J(obj, iX, i8)) {
                        iV = CodedOutputStream.E0(iX, 0L);
                        i9 += iV;
                    }
                    break;
                case 66:
                    if (J(obj, iX, i8)) {
                        iV = CodedOutputStream.G0(iX, c0(obj, jY));
                        i9 += iV;
                    }
                    break;
                case 67:
                    if (J(obj, iX, i8)) {
                        iV = CodedOutputStream.I0(iX, d0(obj, jY));
                        i9 += iV;
                    }
                    break;
                case 68:
                    if (J(obj, iX, i8)) {
                        iV = CodedOutputStream.k0(iX, (MessageLite) unsafe.getObject(obj, jY), v(i8));
                        i9 += iV;
                    }
                    break;
            }
            i8 += 3;
            i6 = 1048575;
        }
        int iZ = i9 + z(this.f39174o, obj);
        return this.f39165f ? iZ + this.f39175p.c(obj).l() : iZ;
    }

    private static int x0(int i3) {
        return (i3 & 267386880) >>> 20;
    }

    private int y(Object obj) {
        int iA0;
        int i3;
        int iM0;
        int iO0;
        Unsafe unsafe = f39159s;
        int i4 = 0;
        for (int i5 = 0; i5 < this.f39160a.length; i5 += 3) {
            int iY0 = y0(i5);
            int iX0 = x0(iY0);
            int iX = X(i5);
            long jY = Y(iY0);
            int i6 = (iX0 < FieldType.P.a() || iX0 > FieldType.f39008c0.a()) ? 0 : this.f39160a[i5 + 2] & 1048575;
            switch (iX0) {
                case 0:
                    if (C(obj, i5)) {
                        iA0 = CodedOutputStream.a0(iX, 0.0d);
                        i4 += iA0;
                    }
                    break;
                case 1:
                    if (C(obj, i5)) {
                        iA0 = CodedOutputStream.i0(iX, 0.0f);
                        i4 += iA0;
                    }
                    break;
                case 2:
                    if (C(obj, i5)) {
                        iA0 = CodedOutputStream.p0(iX, UnsafeUtil.F(obj, jY));
                        i4 += iA0;
                    }
                    break;
                case 3:
                    if (C(obj, i5)) {
                        iA0 = CodedOutputStream.P0(iX, UnsafeUtil.F(obj, jY));
                        i4 += iA0;
                    }
                    break;
                case 4:
                    if (C(obj, i5)) {
                        iA0 = CodedOutputStream.n0(iX, UnsafeUtil.D(obj, jY));
                        i4 += iA0;
                    }
                    break;
                case 5:
                    if (C(obj, i5)) {
                        iA0 = CodedOutputStream.g0(iX, 0L);
                        i4 += iA0;
                    }
                    break;
                case 6:
                    if (C(obj, i5)) {
                        iA0 = CodedOutputStream.e0(iX, 0);
                        i4 += iA0;
                    }
                    break;
                case 7:
                    if (C(obj, i5)) {
                        iA0 = CodedOutputStream.V(iX, true);
                        i4 += iA0;
                    }
                    break;
                case 8:
                    if (C(obj, i5)) {
                        Object objH = UnsafeUtil.H(obj, jY);
                        iA0 = objH instanceof ByteString ? CodedOutputStream.Y(iX, (ByteString) objH) : CodedOutputStream.K0(iX, (String) objH);
                        i4 += iA0;
                    }
                    break;
                case 9:
                    if (C(obj, i5)) {
                        iA0 = SchemaUtil.o(iX, UnsafeUtil.H(obj, jY), v(i5));
                        i4 += iA0;
                    }
                    break;
                case 10:
                    if (C(obj, i5)) {
                        iA0 = CodedOutputStream.Y(iX, (ByteString) UnsafeUtil.H(obj, jY));
                        i4 += iA0;
                    }
                    break;
                case 11:
                    if (C(obj, i5)) {
                        iA0 = CodedOutputStream.N0(iX, UnsafeUtil.D(obj, jY));
                        i4 += iA0;
                    }
                    break;
                case 12:
                    if (C(obj, i5)) {
                        iA0 = CodedOutputStream.c0(iX, UnsafeUtil.D(obj, jY));
                        i4 += iA0;
                    }
                    break;
                case 13:
                    if (C(obj, i5)) {
                        iA0 = CodedOutputStream.C0(iX, 0);
                        i4 += iA0;
                    }
                    break;
                case 14:
                    if (C(obj, i5)) {
                        iA0 = CodedOutputStream.E0(iX, 0L);
                        i4 += iA0;
                    }
                    break;
                case 15:
                    if (C(obj, i5)) {
                        iA0 = CodedOutputStream.G0(iX, UnsafeUtil.D(obj, jY));
                        i4 += iA0;
                    }
                    break;
                case 16:
                    if (C(obj, i5)) {
                        iA0 = CodedOutputStream.I0(iX, UnsafeUtil.F(obj, jY));
                        i4 += iA0;
                    }
                    break;
                case 17:
                    if (C(obj, i5)) {
                        iA0 = CodedOutputStream.k0(iX, (MessageLite) UnsafeUtil.H(obj, jY), v(i5));
                        i4 += iA0;
                    }
                    break;
                case 18:
                    iA0 = SchemaUtil.h(iX, L(obj, jY), false);
                    i4 += iA0;
                    break;
                case 19:
                    iA0 = SchemaUtil.f(iX, L(obj, jY), false);
                    i4 += iA0;
                    break;
                case 20:
                    iA0 = SchemaUtil.m(iX, L(obj, jY), false);
                    i4 += iA0;
                    break;
                case 21:
                    iA0 = SchemaUtil.x(iX, L(obj, jY), false);
                    i4 += iA0;
                    break;
                case 22:
                    iA0 = SchemaUtil.k(iX, L(obj, jY), false);
                    i4 += iA0;
                    break;
                case 23:
                    iA0 = SchemaUtil.h(iX, L(obj, jY), false);
                    i4 += iA0;
                    break;
                case 24:
                    iA0 = SchemaUtil.f(iX, L(obj, jY), false);
                    i4 += iA0;
                    break;
                case 25:
                    iA0 = SchemaUtil.a(iX, L(obj, jY), false);
                    i4 += iA0;
                    break;
                case 26:
                    iA0 = SchemaUtil.u(iX, L(obj, jY));
                    i4 += iA0;
                    break;
                case 27:
                    iA0 = SchemaUtil.p(iX, L(obj, jY), v(i5));
                    i4 += iA0;
                    break;
                case 28:
                    iA0 = SchemaUtil.c(iX, L(obj, jY));
                    i4 += iA0;
                    break;
                case 29:
                    iA0 = SchemaUtil.v(iX, L(obj, jY), false);
                    i4 += iA0;
                    break;
                case 30:
                    iA0 = SchemaUtil.d(iX, L(obj, jY), false);
                    i4 += iA0;
                    break;
                case 31:
                    iA0 = SchemaUtil.f(iX, L(obj, jY), false);
                    i4 += iA0;
                    break;
                case 32:
                    iA0 = SchemaUtil.h(iX, L(obj, jY), false);
                    i4 += iA0;
                    break;
                case 33:
                    iA0 = SchemaUtil.q(iX, L(obj, jY), false);
                    i4 += iA0;
                    break;
                case 34:
                    iA0 = SchemaUtil.s(iX, L(obj, jY), false);
                    i4 += iA0;
                    break;
                case 35:
                    i3 = SchemaUtil.i((List) unsafe.getObject(obj, jY));
                    if (i3 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i6, i3);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i3);
                        iA0 = iM0 + iO0 + i3;
                        i4 += iA0;
                    }
                    break;
                case 36:
                    i3 = SchemaUtil.g((List) unsafe.getObject(obj, jY));
                    if (i3 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i6, i3);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i3);
                        iA0 = iM0 + iO0 + i3;
                        i4 += iA0;
                    }
                    break;
                case 37:
                    i3 = SchemaUtil.n((List) unsafe.getObject(obj, jY));
                    if (i3 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i6, i3);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i3);
                        iA0 = iM0 + iO0 + i3;
                        i4 += iA0;
                    }
                    break;
                case 38:
                    i3 = SchemaUtil.y((List) unsafe.getObject(obj, jY));
                    if (i3 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i6, i3);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i3);
                        iA0 = iM0 + iO0 + i3;
                        i4 += iA0;
                    }
                    break;
                case 39:
                    i3 = SchemaUtil.l((List) unsafe.getObject(obj, jY));
                    if (i3 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i6, i3);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i3);
                        iA0 = iM0 + iO0 + i3;
                        i4 += iA0;
                    }
                    break;
                case 40:
                    i3 = SchemaUtil.i((List) unsafe.getObject(obj, jY));
                    if (i3 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i6, i3);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i3);
                        iA0 = iM0 + iO0 + i3;
                        i4 += iA0;
                    }
                    break;
                case 41:
                    i3 = SchemaUtil.g((List) unsafe.getObject(obj, jY));
                    if (i3 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i6, i3);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i3);
                        iA0 = iM0 + iO0 + i3;
                        i4 += iA0;
                    }
                    break;
                case 42:
                    i3 = SchemaUtil.b((List) unsafe.getObject(obj, jY));
                    if (i3 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i6, i3);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i3);
                        iA0 = iM0 + iO0 + i3;
                        i4 += iA0;
                    }
                    break;
                case 43:
                    i3 = SchemaUtil.w((List) unsafe.getObject(obj, jY));
                    if (i3 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i6, i3);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i3);
                        iA0 = iM0 + iO0 + i3;
                        i4 += iA0;
                    }
                    break;
                case 44:
                    i3 = SchemaUtil.e((List) unsafe.getObject(obj, jY));
                    if (i3 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i6, i3);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i3);
                        iA0 = iM0 + iO0 + i3;
                        i4 += iA0;
                    }
                    break;
                case 45:
                    i3 = SchemaUtil.g((List) unsafe.getObject(obj, jY));
                    if (i3 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i6, i3);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i3);
                        iA0 = iM0 + iO0 + i3;
                        i4 += iA0;
                    }
                    break;
                case 46:
                    i3 = SchemaUtil.i((List) unsafe.getObject(obj, jY));
                    if (i3 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i6, i3);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i3);
                        iA0 = iM0 + iO0 + i3;
                        i4 += iA0;
                    }
                    break;
                case 47:
                    i3 = SchemaUtil.r((List) unsafe.getObject(obj, jY));
                    if (i3 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i6, i3);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i3);
                        iA0 = iM0 + iO0 + i3;
                        i4 += iA0;
                    }
                    break;
                case 48:
                    i3 = SchemaUtil.t((List) unsafe.getObject(obj, jY));
                    if (i3 > 0) {
                        if (this.f39168i) {
                            unsafe.putInt(obj, i6, i3);
                        }
                        iM0 = CodedOutputStream.M0(iX);
                        iO0 = CodedOutputStream.O0(i3);
                        iA0 = iM0 + iO0 + i3;
                        i4 += iA0;
                    }
                    break;
                case 49:
                    iA0 = SchemaUtil.j(iX, L(obj, jY), v(i5));
                    i4 += iA0;
                    break;
                case 50:
                    iA0 = this.f39176q.g(iX, UnsafeUtil.H(obj, jY), u(i5));
                    i4 += iA0;
                    break;
                case 51:
                    if (J(obj, iX, i5)) {
                        iA0 = CodedOutputStream.a0(iX, 0.0d);
                        i4 += iA0;
                    }
                    break;
                case 52:
                    if (J(obj, iX, i5)) {
                        iA0 = CodedOutputStream.i0(iX, 0.0f);
                        i4 += iA0;
                    }
                    break;
                case 53:
                    if (J(obj, iX, i5)) {
                        iA0 = CodedOutputStream.p0(iX, d0(obj, jY));
                        i4 += iA0;
                    }
                    break;
                case 54:
                    if (J(obj, iX, i5)) {
                        iA0 = CodedOutputStream.P0(iX, d0(obj, jY));
                        i4 += iA0;
                    }
                    break;
                case 55:
                    if (J(obj, iX, i5)) {
                        iA0 = CodedOutputStream.n0(iX, c0(obj, jY));
                        i4 += iA0;
                    }
                    break;
                case 56:
                    if (J(obj, iX, i5)) {
                        iA0 = CodedOutputStream.g0(iX, 0L);
                        i4 += iA0;
                    }
                    break;
                case 57:
                    if (J(obj, iX, i5)) {
                        iA0 = CodedOutputStream.e0(iX, 0);
                        i4 += iA0;
                    }
                    break;
                case 58:
                    if (J(obj, iX, i5)) {
                        iA0 = CodedOutputStream.V(iX, true);
                        i4 += iA0;
                    }
                    break;
                case 59:
                    if (J(obj, iX, i5)) {
                        Object objH2 = UnsafeUtil.H(obj, jY);
                        iA0 = objH2 instanceof ByteString ? CodedOutputStream.Y(iX, (ByteString) objH2) : CodedOutputStream.K0(iX, (String) objH2);
                        i4 += iA0;
                    }
                    break;
                case 60:
                    if (J(obj, iX, i5)) {
                        iA0 = SchemaUtil.o(iX, UnsafeUtil.H(obj, jY), v(i5));
                        i4 += iA0;
                    }
                    break;
                case 61:
                    if (J(obj, iX, i5)) {
                        iA0 = CodedOutputStream.Y(iX, (ByteString) UnsafeUtil.H(obj, jY));
                        i4 += iA0;
                    }
                    break;
                case 62:
                    if (J(obj, iX, i5)) {
                        iA0 = CodedOutputStream.N0(iX, c0(obj, jY));
                        i4 += iA0;
                    }
                    break;
                case 63:
                    if (J(obj, iX, i5)) {
                        iA0 = CodedOutputStream.c0(iX, c0(obj, jY));
                        i4 += iA0;
                    }
                    break;
                case 64:
                    if (J(obj, iX, i5)) {
                        iA0 = CodedOutputStream.C0(iX, 0);
                        i4 += iA0;
                    }
                    break;
                case 65:
                    if (J(obj, iX, i5)) {
                        iA0 = CodedOutputStream.E0(iX, 0L);
                        i4 += iA0;
                    }
                    break;
                case 66:
                    if (J(obj, iX, i5)) {
                        iA0 = CodedOutputStream.G0(iX, c0(obj, jY));
                        i4 += iA0;
                    }
                    break;
                case 67:
                    if (J(obj, iX, i5)) {
                        iA0 = CodedOutputStream.I0(iX, d0(obj, jY));
                        i4 += iA0;
                    }
                    break;
                case 68:
                    if (J(obj, iX, i5)) {
                        iA0 = CodedOutputStream.k0(iX, (MessageLite) UnsafeUtil.H(obj, jY), v(i5));
                        i4 += iA0;
                    }
                    break;
            }
        }
        return i4 + z(this.f39174o, obj);
    }

    private int y0(int i3) {
        return this.f39160a[i3 + 1];
    }

    private int z(UnknownFieldSchema unknownFieldSchema, Object obj) {
        return unknownFieldSchema.h(unknownFieldSchema.g(obj));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void z0(java.lang.Object r19, androidx.glance.appwidget.protobuf.Writer r20) {
        /*
            Method dump skipped, instruction units count: 1336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.protobuf.MessageSchema.z0(java.lang.Object, androidx.glance.appwidget.protobuf.Writer):void");
    }

    @Override // androidx.glance.appwidget.protobuf.Schema
    public void a(Object obj, Object obj2) {
        l(obj);
        obj2.getClass();
        for (int i3 = 0; i3 < this.f39160a.length; i3 += 3) {
            R(obj, obj2, i3);
        }
        SchemaUtil.G(this.f39174o, obj, obj2);
        if (this.f39165f) {
            SchemaUtil.E(this.f39175p, obj, obj2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    @Override // androidx.glance.appwidget.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(java.lang.Object r8) {
        /*
            r7 = this;
            boolean r0 = H(r8)
            if (r0 != 0) goto L7
            goto L6d
        L7:
            boolean r0 = r8 instanceof androidx.glance.appwidget.protobuf.GeneratedMessageLite
            if (r0 == 0) goto L17
            r0 = r8
            androidx.glance.appwidget.protobuf.GeneratedMessageLite r0 = (androidx.glance.appwidget.protobuf.GeneratedMessageLite) r0
            r0.t()
            r0.s()
            r0.J()
        L17:
            int[] r0 = r7.f39160a
            int r0 = r0.length
            r1 = 0
        L1b:
            if (r1 >= r0) goto L5f
            int r2 = r7.y0(r1)
            long r3 = Y(r2)
            int r2 = x0(r2)
            r5 = 9
            if (r2 == r5) goto L49
            switch(r2) {
                case 17: goto L49;
                case 18: goto L43;
                case 19: goto L43;
                case 20: goto L43;
                case 21: goto L43;
                case 22: goto L43;
                case 23: goto L43;
                case 24: goto L43;
                case 25: goto L43;
                case 26: goto L43;
                case 27: goto L43;
                case 28: goto L43;
                case 29: goto L43;
                case 30: goto L43;
                case 31: goto L43;
                case 32: goto L43;
                case 33: goto L43;
                case 34: goto L43;
                case 35: goto L43;
                case 36: goto L43;
                case 37: goto L43;
                case 38: goto L43;
                case 39: goto L43;
                case 40: goto L43;
                case 41: goto L43;
                case 42: goto L43;
                case 43: goto L43;
                case 44: goto L43;
                case 45: goto L43;
                case 46: goto L43;
                case 47: goto L43;
                case 48: goto L43;
                case 49: goto L43;
                case 50: goto L31;
                default: goto L30;
            }
        L30:
            goto L5c
        L31:
            sun.misc.Unsafe r2 = androidx.glance.appwidget.protobuf.MessageSchema.f39159s
            java.lang.Object r5 = r2.getObject(r8, r3)
            if (r5 == 0) goto L5c
            androidx.glance.appwidget.protobuf.MapFieldSchema r6 = r7.f39176q
            java.lang.Object r5 = r6.f(r5)
            r2.putObject(r8, r3, r5)
            goto L5c
        L43:
            androidx.glance.appwidget.protobuf.ListFieldSchema r2 = r7.f39173n
            r2.c(r8, r3)
            goto L5c
        L49:
            boolean r2 = r7.C(r8, r1)
            if (r2 == 0) goto L5c
            androidx.glance.appwidget.protobuf.Schema r2 = r7.v(r1)
            sun.misc.Unsafe r5 = androidx.glance.appwidget.protobuf.MessageSchema.f39159s
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.b(r3)
        L5c:
            int r1 = r1 + 3
            goto L1b
        L5f:
            androidx.glance.appwidget.protobuf.UnknownFieldSchema r0 = r7.f39174o
            r0.j(r8)
            boolean r0 = r7.f39165f
            if (r0 == 0) goto L6d
            androidx.glance.appwidget.protobuf.ExtensionSchema r0 = r7.f39175p
            r0.f(r8)
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.protobuf.MessageSchema.b(java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x007c  */
    @Override // androidx.glance.appwidget.protobuf.Schema
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
            int r5 = r14.f39170k
            r6 = 1
            if (r2 >= r5) goto L9b
            int[] r5 = r14.f39169j
            r9 = r5[r2]
            int r5 = r14.X(r9)
            int r13 = r14.y0(r9)
            int[] r7 = r14.f39160a
            int r8 = r9 + 2
            r7 = r7[r8]
            r8 = r7 & r0
            int r7 = r7 >>> 20
            int r12 = r6 << r7
            if (r8 == r3) goto L32
            if (r8 == r0) goto L2f
            sun.misc.Unsafe r3 = androidx.glance.appwidget.protobuf.MessageSchema.f39159s
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
            boolean r3 = K(r13)
            r7 = r14
            r8 = r15
            if (r3 == 0) goto L43
            boolean r15 = r7.D(r8, r9, r10, r11, r12)
            if (r15 != 0) goto L43
            return r1
        L43:
            int r15 = x0(r13)
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
            boolean r15 = r14.G(r8, r13, r9)
            if (r15 != 0) goto L94
            return r1
        L6b:
            boolean r15 = r14.J(r8, r5, r9)
            if (r15 == 0) goto L94
            androidx.glance.appwidget.protobuf.Schema r15 = r14.v(r9)
            boolean r15 = E(r8, r13, r15)
            if (r15 != 0) goto L94
            return r1
        L7c:
            boolean r15 = r14.F(r8, r13, r9)
            if (r15 != 0) goto L94
            return r1
        L83:
            boolean r15 = r7.D(r8, r9, r10, r11, r12)
            if (r15 == 0) goto L94
            androidx.glance.appwidget.protobuf.Schema r15 = r14.v(r9)
            boolean r15 = E(r8, r13, r15)
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
            boolean r15 = r7.f39165f
            if (r15 == 0) goto Lae
            androidx.glance.appwidget.protobuf.ExtensionSchema r15 = r7.f39175p
            androidx.glance.appwidget.protobuf.FieldSet r15 = r15.c(r8)
            boolean r15 = r15.p()
            if (r15 != 0) goto Lae
            return r1
        Lae:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.protobuf.MessageSchema.c(java.lang.Object):boolean");
    }

    @Override // androidx.glance.appwidget.protobuf.Schema
    public int d(Object obj) {
        return this.f39167h ? y(obj) : x(obj);
    }

    @Override // androidx.glance.appwidget.protobuf.Schema
    public int e(Object obj) {
        int i3;
        int iF;
        int length = this.f39160a.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5 += 3) {
            int iY0 = y0(i5);
            int iX = X(i5);
            long jY = Y(iY0);
            int iHashCode = 37;
            switch (x0(iY0)) {
                case 0:
                    i3 = i4 * 53;
                    iF = Internal.f(Double.doubleToLongBits(UnsafeUtil.B(obj, jY)));
                    i4 = i3 + iF;
                    break;
                case 1:
                    i3 = i4 * 53;
                    iF = Float.floatToIntBits(UnsafeUtil.C(obj, jY));
                    i4 = i3 + iF;
                    break;
                case 2:
                    i3 = i4 * 53;
                    iF = Internal.f(UnsafeUtil.F(obj, jY));
                    i4 = i3 + iF;
                    break;
                case 3:
                    i3 = i4 * 53;
                    iF = Internal.f(UnsafeUtil.F(obj, jY));
                    i4 = i3 + iF;
                    break;
                case 4:
                    i3 = i4 * 53;
                    iF = UnsafeUtil.D(obj, jY);
                    i4 = i3 + iF;
                    break;
                case 5:
                    i3 = i4 * 53;
                    iF = Internal.f(UnsafeUtil.F(obj, jY));
                    i4 = i3 + iF;
                    break;
                case 6:
                    i3 = i4 * 53;
                    iF = UnsafeUtil.D(obj, jY);
                    i4 = i3 + iF;
                    break;
                case 7:
                    i3 = i4 * 53;
                    iF = Internal.c(UnsafeUtil.u(obj, jY));
                    i4 = i3 + iF;
                    break;
                case 8:
                    i3 = i4 * 53;
                    iF = ((String) UnsafeUtil.H(obj, jY)).hashCode();
                    i4 = i3 + iF;
                    break;
                case 9:
                    Object objH = UnsafeUtil.H(obj, jY);
                    if (objH != null) {
                        iHashCode = objH.hashCode();
                    }
                    i4 = (i4 * 53) + iHashCode;
                    break;
                case 10:
                    i3 = i4 * 53;
                    iF = UnsafeUtil.H(obj, jY).hashCode();
                    i4 = i3 + iF;
                    break;
                case 11:
                    i3 = i4 * 53;
                    iF = UnsafeUtil.D(obj, jY);
                    i4 = i3 + iF;
                    break;
                case 12:
                    i3 = i4 * 53;
                    iF = UnsafeUtil.D(obj, jY);
                    i4 = i3 + iF;
                    break;
                case 13:
                    i3 = i4 * 53;
                    iF = UnsafeUtil.D(obj, jY);
                    i4 = i3 + iF;
                    break;
                case 14:
                    i3 = i4 * 53;
                    iF = Internal.f(UnsafeUtil.F(obj, jY));
                    i4 = i3 + iF;
                    break;
                case 15:
                    i3 = i4 * 53;
                    iF = UnsafeUtil.D(obj, jY);
                    i4 = i3 + iF;
                    break;
                case 16:
                    i3 = i4 * 53;
                    iF = Internal.f(UnsafeUtil.F(obj, jY));
                    i4 = i3 + iF;
                    break;
                case 17:
                    Object objH2 = UnsafeUtil.H(obj, jY);
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
                    iF = UnsafeUtil.H(obj, jY).hashCode();
                    i4 = i3 + iF;
                    break;
                case 50:
                    i3 = i4 * 53;
                    iF = UnsafeUtil.H(obj, jY).hashCode();
                    i4 = i3 + iF;
                    break;
                case 51:
                    if (J(obj, iX, i5)) {
                        i3 = i4 * 53;
                        iF = Internal.f(Double.doubleToLongBits(a0(obj, jY)));
                        i4 = i3 + iF;
                    }
                    break;
                case 52:
                    if (J(obj, iX, i5)) {
                        i3 = i4 * 53;
                        iF = Float.floatToIntBits(b0(obj, jY));
                        i4 = i3 + iF;
                    }
                    break;
                case 53:
                    if (J(obj, iX, i5)) {
                        i3 = i4 * 53;
                        iF = Internal.f(d0(obj, jY));
                        i4 = i3 + iF;
                    }
                    break;
                case 54:
                    if (J(obj, iX, i5)) {
                        i3 = i4 * 53;
                        iF = Internal.f(d0(obj, jY));
                        i4 = i3 + iF;
                    }
                    break;
                case 55:
                    if (J(obj, iX, i5)) {
                        i3 = i4 * 53;
                        iF = c0(obj, jY);
                        i4 = i3 + iF;
                    }
                    break;
                case 56:
                    if (J(obj, iX, i5)) {
                        i3 = i4 * 53;
                        iF = Internal.f(d0(obj, jY));
                        i4 = i3 + iF;
                    }
                    break;
                case 57:
                    if (J(obj, iX, i5)) {
                        i3 = i4 * 53;
                        iF = c0(obj, jY);
                        i4 = i3 + iF;
                    }
                    break;
                case 58:
                    if (J(obj, iX, i5)) {
                        i3 = i4 * 53;
                        iF = Internal.c(Z(obj, jY));
                        i4 = i3 + iF;
                    }
                    break;
                case 59:
                    if (J(obj, iX, i5)) {
                        i3 = i4 * 53;
                        iF = ((String) UnsafeUtil.H(obj, jY)).hashCode();
                        i4 = i3 + iF;
                    }
                    break;
                case 60:
                    if (J(obj, iX, i5)) {
                        i3 = i4 * 53;
                        iF = UnsafeUtil.H(obj, jY).hashCode();
                        i4 = i3 + iF;
                    }
                    break;
                case 61:
                    if (J(obj, iX, i5)) {
                        i3 = i4 * 53;
                        iF = UnsafeUtil.H(obj, jY).hashCode();
                        i4 = i3 + iF;
                    }
                    break;
                case 62:
                    if (J(obj, iX, i5)) {
                        i3 = i4 * 53;
                        iF = c0(obj, jY);
                        i4 = i3 + iF;
                    }
                    break;
                case 63:
                    if (J(obj, iX, i5)) {
                        i3 = i4 * 53;
                        iF = c0(obj, jY);
                        i4 = i3 + iF;
                    }
                    break;
                case 64:
                    if (J(obj, iX, i5)) {
                        i3 = i4 * 53;
                        iF = c0(obj, jY);
                        i4 = i3 + iF;
                    }
                    break;
                case 65:
                    if (J(obj, iX, i5)) {
                        i3 = i4 * 53;
                        iF = Internal.f(d0(obj, jY));
                        i4 = i3 + iF;
                    }
                    break;
                case 66:
                    if (J(obj, iX, i5)) {
                        i3 = i4 * 53;
                        iF = c0(obj, jY);
                        i4 = i3 + iF;
                    }
                    break;
                case 67:
                    if (J(obj, iX, i5)) {
                        i3 = i4 * 53;
                        iF = Internal.f(d0(obj, jY));
                        i4 = i3 + iF;
                    }
                    break;
                case 68:
                    if (J(obj, iX, i5)) {
                        i3 = i4 * 53;
                        iF = UnsafeUtil.H(obj, jY).hashCode();
                        i4 = i3 + iF;
                    }
                    break;
            }
        }
        int iHashCode2 = (i4 * 53) + this.f39174o.g(obj).hashCode();
        return this.f39165f ? (iHashCode2 * 53) + this.f39175p.c(obj).hashCode() : iHashCode2;
    }

    @Override // androidx.glance.appwidget.protobuf.Schema
    public boolean f(Object obj, Object obj2) {
        int length = this.f39160a.length;
        for (int i3 = 0; i3 < length; i3 += 3) {
            if (!p(obj, obj2, i3)) {
                return false;
            }
        }
        if (!this.f39174o.g(obj).equals(this.f39174o.g(obj2))) {
            return false;
        }
        if (this.f39165f) {
            return this.f39175p.c(obj).equals(this.f39175p.c(obj2));
        }
        return true;
    }

    @Override // androidx.glance.appwidget.protobuf.Schema
    public void g(Object obj, Writer writer) {
        if (writer.t() == Writer.FieldOrder.DESCENDING) {
            B0(obj, writer);
        } else if (this.f39167h) {
            A0(obj, writer);
        } else {
            z0(obj, writer);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x0094. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03ee A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x041c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    int g0(java.lang.Object r26, byte[] r27, int r28, int r29, int r30, androidx.glance.appwidget.protobuf.ArrayDecoders.Registers r31) {
        /*
            Method dump skipped, instruction units count: 1202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.protobuf.MessageSchema.g0(java.lang.Object, byte[], int, int, int, androidx.glance.appwidget.protobuf.ArrayDecoders$Registers):int");
    }

    @Override // androidx.glance.appwidget.protobuf.Schema
    public void h(Object obj, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        extensionRegistryLite.getClass();
        l(obj);
        N(this.f39174o, this.f39175p, obj, reader, extensionRegistryLite);
    }

    @Override // androidx.glance.appwidget.protobuf.Schema
    public void i(Object obj, byte[] bArr, int i3, int i4, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        if (this.f39167h) {
            h0(obj, bArr, i3, i4, registers);
        } else {
            g0(obj, bArr, i3, i4, 0, registers);
        }
    }

    @Override // androidx.glance.appwidget.protobuf.Schema
    public Object newInstance() {
        return this.f39172m.a(this.f39164e);
    }

    private static java.lang.reflect.Field q0(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
            for (java.lang.reflect.Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + YgVrd.YhjLq + Arrays.toString(declaredFields));
        }
    }
}
