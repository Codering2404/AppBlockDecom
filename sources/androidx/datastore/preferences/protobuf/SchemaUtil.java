package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class SchemaUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Class f36590a = B();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final UnknownFieldSchema f36591b = C();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final UnknownFieldSchema f36592c = new UnknownFieldSetLiteSchema();

    static Object A(Object obj, int i3, List list, Internal.EnumVerifier enumVerifier, Object obj2, UnknownFieldSchema unknownFieldSchema) {
        if (enumVerifier == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (!enumVerifier.a(iIntValue)) {
                    obj2 = J(obj, i3, iIntValue, obj2, unknownFieldSchema);
                    it.remove();
                }
            }
            return obj2;
        }
        int size = list.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Integer num = (Integer) list.get(i5);
            int iIntValue2 = num.intValue();
            if (enumVerifier.a(iIntValue2)) {
                if (i5 != i4) {
                    list.set(i4, num);
                }
                i4++;
            } else {
                obj2 = J(obj, i3, iIntValue2, obj2, unknownFieldSchema);
            }
        }
        if (i4 != size) {
            list.subList(i4, size).clear();
        }
        return obj2;
    }

    private static Class B() {
        if (Protobuf.f36554d) {
            return null;
        }
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static UnknownFieldSchema C() {
        try {
            Class clsD = D();
            if (clsD == null) {
                return null;
            }
            return (UnknownFieldSchema) clsD.getConstructor(null).newInstance(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class D() {
        if (Protobuf.f36554d) {
            return null;
        }
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static void E(ExtensionSchema extensionSchema, Object obj, Object obj2) {
        FieldSet fieldSetC = extensionSchema.c(obj2);
        if (fieldSetC.n()) {
            return;
        }
        extensionSchema.d(obj).v(fieldSetC);
    }

    static void F(MapFieldSchema mapFieldSchema, Object obj, Object obj2, long j3) {
        UnsafeUtil.Y(obj, j3, mapFieldSchema.a(UnsafeUtil.H(obj, j3), UnsafeUtil.H(obj2, j3)));
    }

    static void G(UnknownFieldSchema unknownFieldSchema, Object obj, Object obj2) {
        unknownFieldSchema.p(obj, unknownFieldSchema.k(unknownFieldSchema.g(obj), unknownFieldSchema.g(obj2)));
    }

    public static void H(Class cls) {
        Class cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && !Protobuf.f36554d && (cls2 = f36590a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean I(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static Object J(Object obj, int i3, int i4, Object obj2, UnknownFieldSchema unknownFieldSchema) {
        if (obj2 == null) {
            obj2 = unknownFieldSchema.f(obj);
        }
        unknownFieldSchema.e(obj2, i3, i4);
        return obj2;
    }

    public static UnknownFieldSchema K() {
        return f36591b;
    }

    public static UnknownFieldSchema L() {
        return f36592c;
    }

    public static void M(int i3, List list, Writer writer, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.B(i3, list, z2);
    }

    public static void N(int i3, List list, Writer writer) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.J(i3, list);
    }

    public static void O(int i3, List list, Writer writer, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.H(i3, list, z2);
    }

    public static void P(int i3, List list, Writer writer, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.n(i3, list, z2);
    }

    public static void Q(int i3, List list, Writer writer, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.j(i3, list, z2);
    }

    public static void R(int i3, List list, Writer writer, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.z(i3, list, z2);
    }

    public static void S(int i3, List list, Writer writer, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.a(i3, list, z2);
    }

    public static void T(int i3, List list, Writer writer, Schema schema) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.K(i3, list, schema);
    }

    public static void U(int i3, List list, Writer writer, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.g(i3, list, z2);
    }

    public static void V(int i3, List list, Writer writer, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.G(i3, list, z2);
    }

    public static void W(int i3, List list, Writer writer, Schema schema) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.P(i3, list, schema);
    }

    public static void X(int i3, List list, Writer writer, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.A(i3, list, z2);
    }

    public static void Y(int i3, List list, Writer writer, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.q(i3, list, z2);
    }

    public static void Z(int i3, List list, Writer writer, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.E(i3, list, z2);
    }

    static int a(int i3, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z2 ? CodedOutputStream.M0(i3) + CodedOutputStream.u0(size) : size * CodedOutputStream.V(i3, true);
    }

    public static void a0(int i3, List list, Writer writer, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.l(i3, list, z2);
    }

    static int b(List list) {
        return list.size();
    }

    public static void b0(int i3, List list, Writer writer) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.d(i3, list);
    }

    static int c(int i3, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iM0 = size * CodedOutputStream.M0(i3);
        for (int i4 = 0; i4 < list.size(); i4++) {
            iM0 += CodedOutputStream.Z((ByteString) list.get(i4));
        }
        return iM0;
    }

    public static void c0(int i3, List list, Writer writer, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.k(i3, list, z2);
    }

    static int d(int i3, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iE = e(list);
        return z2 ? CodedOutputStream.M0(i3) + CodedOutputStream.u0(iE) : iE + (size * CodedOutputStream.M0(i3));
    }

    public static void d0(int i3, List list, Writer writer, boolean z2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.r(i3, list, z2);
    }

    static int e(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof IntArrayList)) {
            int iD0 = 0;
            while (i3 < size) {
                iD0 += CodedOutputStream.d0(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return iD0;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iD02 = 0;
        while (i3 < size) {
            iD02 += CodedOutputStream.d0(intArrayList.getInt(i3));
            i3++;
        }
        return iD02;
    }

    static int f(int i3, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z2 ? CodedOutputStream.M0(i3) + CodedOutputStream.u0(size * 4) : size * CodedOutputStream.e0(i3, 0);
    }

    static int g(List list) {
        return list.size() * 4;
    }

    static int h(int i3, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z2 ? CodedOutputStream.M0(i3) + CodedOutputStream.u0(size * 8) : size * CodedOutputStream.g0(i3, 0L);
    }

    static int i(List list) {
        return list.size() * 8;
    }

    static int j(int i3, List list, Schema schema) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iK0 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            iK0 += CodedOutputStream.k0(i3, (MessageLite) list.get(i4), schema);
        }
        return iK0;
    }

    static int k(int i3, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iL = l(list);
        return z2 ? CodedOutputStream.M0(i3) + CodedOutputStream.u0(iL) : iL + (size * CodedOutputStream.M0(i3));
    }

    static int l(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof IntArrayList)) {
            int iO0 = 0;
            while (i3 < size) {
                iO0 += CodedOutputStream.o0(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return iO0;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iO02 = 0;
        while (i3 < size) {
            iO02 += CodedOutputStream.o0(intArrayList.getInt(i3));
            i3++;
        }
        return iO02;
    }

    static int m(int i3, List list, boolean z2) {
        if (list.size() == 0) {
            return 0;
        }
        int iN = n(list);
        return z2 ? CodedOutputStream.M0(i3) + CodedOutputStream.u0(iN) : iN + (list.size() * CodedOutputStream.M0(i3));
    }

    static int n(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof LongArrayList)) {
            int iQ0 = 0;
            while (i3 < size) {
                iQ0 += CodedOutputStream.q0(((Long) list.get(i3)).longValue());
                i3++;
            }
            return iQ0;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int iQ02 = 0;
        while (i3 < size) {
            iQ02 += CodedOutputStream.q0(longArrayList.l(i3));
            i3++;
        }
        return iQ02;
    }

    static int o(int i3, Object obj, Schema schema) {
        return obj instanceof LazyFieldLite ? CodedOutputStream.s0(i3, (LazyFieldLite) obj) : CodedOutputStream.x0(i3, (MessageLite) obj, schema);
    }

    static int p(int i3, List list, Schema schema) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iM0 = CodedOutputStream.M0(i3) * size;
        for (int i4 = 0; i4 < size; i4++) {
            Object obj = list.get(i4);
            iM0 += obj instanceof LazyFieldLite ? CodedOutputStream.t0((LazyFieldLite) obj) : CodedOutputStream.z0((MessageLite) obj, schema);
        }
        return iM0;
    }

    static int q(int i3, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iR = r(list);
        return z2 ? CodedOutputStream.M0(i3) + CodedOutputStream.u0(iR) : iR + (size * CodedOutputStream.M0(i3));
    }

    static int r(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof IntArrayList)) {
            int iH0 = 0;
            while (i3 < size) {
                iH0 += CodedOutputStream.H0(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return iH0;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iH02 = 0;
        while (i3 < size) {
            iH02 += CodedOutputStream.H0(intArrayList.getInt(i3));
            i3++;
        }
        return iH02;
    }

    static int s(int i3, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iT = t(list);
        return z2 ? CodedOutputStream.M0(i3) + CodedOutputStream.u0(iT) : iT + (size * CodedOutputStream.M0(i3));
    }

    static int t(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof LongArrayList)) {
            int iJ0 = 0;
            while (i3 < size) {
                iJ0 += CodedOutputStream.J0(((Long) list.get(i3)).longValue());
                i3++;
            }
            return iJ0;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int iJ02 = 0;
        while (i3 < size) {
            iJ02 += CodedOutputStream.J0(longArrayList.l(i3));
            i3++;
        }
        return iJ02;
    }

    static int u(int i3, List list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int iM0 = CodedOutputStream.M0(i3) * size;
        if (!(list instanceof LazyStringList)) {
            while (i4 < size) {
                Object obj = list.get(i4);
                iM0 += obj instanceof ByteString ? CodedOutputStream.Z((ByteString) obj) : CodedOutputStream.L0((String) obj);
                i4++;
            }
            return iM0;
        }
        LazyStringList lazyStringList = (LazyStringList) list;
        while (i4 < size) {
            Object objR = lazyStringList.r(i4);
            iM0 += objR instanceof ByteString ? CodedOutputStream.Z((ByteString) objR) : CodedOutputStream.L0((String) objR);
            i4++;
        }
        return iM0;
    }

    static int v(int i3, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iW = w(list);
        return z2 ? CodedOutputStream.M0(i3) + CodedOutputStream.u0(iW) : iW + (size * CodedOutputStream.M0(i3));
    }

    static int w(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof IntArrayList)) {
            int iO0 = 0;
            while (i3 < size) {
                iO0 += CodedOutputStream.O0(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return iO0;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iO02 = 0;
        while (i3 < size) {
            iO02 += CodedOutputStream.O0(intArrayList.getInt(i3));
            i3++;
        }
        return iO02;
    }

    static int x(int i3, List list, boolean z2) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iY = y(list);
        return z2 ? CodedOutputStream.M0(i3) + CodedOutputStream.u0(iY) : iY + (size * CodedOutputStream.M0(i3));
    }

    static int y(List list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof LongArrayList)) {
            int iQ0 = 0;
            while (i3 < size) {
                iQ0 += CodedOutputStream.Q0(((Long) list.get(i3)).longValue());
                i3++;
            }
            return iQ0;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int iQ02 = 0;
        while (i3 < size) {
            iQ02 += CodedOutputStream.Q0(longArrayList.l(i3));
            i3++;
        }
        return iQ02;
    }

    static Object z(Object obj, int i3, List list, Internal.EnumLiteMap enumLiteMap, Object obj2, UnknownFieldSchema unknownFieldSchema) {
        if (enumLiteMap == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (enumLiteMap.a(iIntValue) == null) {
                    obj2 = J(obj, i3, iIntValue, obj2, unknownFieldSchema);
                    it.remove();
                }
            }
            return obj2;
        }
        int size = list.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Integer num = (Integer) list.get(i5);
            int iIntValue2 = num.intValue();
            if (enumLiteMap.a(iIntValue2) != null) {
                if (i5 != i4) {
                    list.set(i4, num);
                }
                i4++;
            } else {
                obj2 = J(obj, i3, iIntValue2, obj2, unknownFieldSchema);
            }
        }
        if (i4 != size) {
            list.subList(i4, size).clear();
        }
        return obj2;
    }
}
