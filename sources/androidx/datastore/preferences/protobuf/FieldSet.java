package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.LazyField;
import androidx.datastore.preferences.protobuf.MessageLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class FieldSet<T extends FieldDescriptorLite<T>> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final FieldSet f36342d = new FieldSet(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SmallSortedMap f36343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f36344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f36345c;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.FieldSet$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f36346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f36347b;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f36347b = iArr;
            try {
                iArr[WireFormat.FieldType.f36688c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36347b[WireFormat.FieldType.f36689d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36347b[WireFormat.FieldType.f36690f.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f36347b[WireFormat.FieldType.f36691g.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f36347b[WireFormat.FieldType.f36692h.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f36347b[WireFormat.FieldType.f36693i.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f36347b[WireFormat.FieldType.f36694j.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f36347b[WireFormat.FieldType.f36695k.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f36347b[WireFormat.FieldType.f36697m.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f36347b[WireFormat.FieldType.f36698n.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f36347b[WireFormat.FieldType.f36696l.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f36347b[WireFormat.FieldType.f36699o.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f36347b[WireFormat.FieldType.f36700p.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f36347b[WireFormat.FieldType.f36702r.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f36347b[WireFormat.FieldType.f36703s.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f36347b[WireFormat.FieldType.f36704t.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f36347b[WireFormat.FieldType.f36705u.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f36347b[WireFormat.FieldType.f36701q.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[WireFormat.JavaType.values().length];
            f36346a = iArr2;
            try {
                iArr2[WireFormat.JavaType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f36346a[WireFormat.JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f36346a[WireFormat.JavaType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f36346a[WireFormat.JavaType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f36346a[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f36346a[WireFormat.JavaType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f36346a[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f36346a[WireFormat.JavaType.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f36346a[WireFormat.JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder<T extends FieldDescriptorLite<T>> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        int J();

        boolean K();

        WireFormat.FieldType L();

        WireFormat.JavaType M();

        boolean N();

        MessageLite.Builder h1(MessageLite.Builder builder, MessageLite messageLite);
    }

    private FieldSet() {
        this.f36343a = SmallSortedMap.q();
    }

    static void A(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i3, Object obj) {
        if (fieldType == WireFormat.FieldType.f36697m) {
            codedOutputStream.k1(i3, (MessageLite) obj);
        } else {
            codedOutputStream.A1(i3, m(fieldType, false));
            B(codedOutputStream, fieldType, obj);
        }
    }

    static void B(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) {
        switch (AnonymousClass1.f36347b[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.f1(((Double) obj).doubleValue());
                break;
            case 2:
                codedOutputStream.j1(((Float) obj).floatValue());
                break;
            case 3:
                codedOutputStream.p1(((Long) obj).longValue());
                break;
            case 4:
                codedOutputStream.C1(((Long) obj).longValue());
                break;
            case 5:
                codedOutputStream.o1(((Integer) obj).intValue());
                break;
            case 6:
                codedOutputStream.i1(((Long) obj).longValue());
                break;
            case 7:
                codedOutputStream.h1(((Integer) obj).intValue());
                break;
            case 8:
                codedOutputStream.b1(((Boolean) obj).booleanValue());
                break;
            case 9:
                codedOutputStream.m1((MessageLite) obj);
                break;
            case 10:
                codedOutputStream.s1((MessageLite) obj);
                break;
            case 11:
                if (!(obj instanceof ByteString)) {
                    codedOutputStream.z1((String) obj);
                } else {
                    codedOutputStream.e1((ByteString) obj);
                }
                break;
            case 12:
                if (!(obj instanceof ByteString)) {
                    codedOutputStream.c1((byte[]) obj);
                } else {
                    codedOutputStream.e1((ByteString) obj);
                }
                break;
            case 13:
                codedOutputStream.B1(((Integer) obj).intValue());
                break;
            case 14:
                codedOutputStream.v1(((Integer) obj).intValue());
                break;
            case 15:
                codedOutputStream.w1(((Long) obj).longValue());
                break;
            case 16:
                codedOutputStream.x1(((Integer) obj).intValue());
                break;
            case 17:
                codedOutputStream.y1(((Long) obj).longValue());
                break;
            case 18:
                if (!(obj instanceof Internal.EnumLite)) {
                    codedOutputStream.g1(((Integer) obj).intValue());
                } else {
                    codedOutputStream.g1(((Internal.EnumLite) obj).J());
                }
                break;
        }
    }

    private static Object c(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    static int d(WireFormat.FieldType fieldType, int i3, Object obj) {
        int iM0 = CodedOutputStream.M0(i3);
        if (fieldType == WireFormat.FieldType.f36697m) {
            iM0 *= 2;
        }
        return iM0 + e(fieldType, obj);
    }

    static int e(WireFormat.FieldType fieldType, Object obj) {
        switch (AnonymousClass1.f36347b[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.b0(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.j0(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.q0(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.Q0(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.o0(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.h0(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.f0(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.W(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.l0((MessageLite) obj);
            case 10:
                return obj instanceof LazyField ? CodedOutputStream.t0((LazyField) obj) : CodedOutputStream.y0((MessageLite) obj);
            case 11:
                return obj instanceof ByteString ? CodedOutputStream.Z((ByteString) obj) : CodedOutputStream.L0((String) obj);
            case 12:
                return obj instanceof ByteString ? CodedOutputStream.Z((ByteString) obj) : CodedOutputStream.X((byte[]) obj);
            case 13:
                return CodedOutputStream.O0(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.D0(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.F0(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.H0(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.J0(((Long) obj).longValue());
            case 18:
                return obj instanceof Internal.EnumLite ? CodedOutputStream.d0(((Internal.EnumLite) obj).J()) : CodedOutputStream.d0(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int f(FieldDescriptorLite fieldDescriptorLite, Object obj) {
        WireFormat.FieldType fieldTypeL = fieldDescriptorLite.L();
        int iJ = fieldDescriptorLite.J();
        if (!fieldDescriptorLite.K()) {
            return d(fieldTypeL, iJ, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i3 = 0;
        if (!fieldDescriptorLite.N()) {
            int iD = 0;
            while (i3 < size) {
                iD += d(fieldTypeL, iJ, list.get(i3));
                i3++;
            }
            return iD;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iE = 0;
        while (i3 < size) {
            iE += e(fieldTypeL, list.get(i3));
            i3++;
        }
        return CodedOutputStream.M0(iJ) + iE + CodedOutputStream.O0(iE);
    }

    public static FieldSet h() {
        return f36342d;
    }

    private int k(Map.Entry entry) {
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        Object value = entry.getValue();
        return (fieldDescriptorLite.M() != WireFormat.JavaType.MESSAGE || fieldDescriptorLite.K() || fieldDescriptorLite.N()) ? f(fieldDescriptorLite, value) : value instanceof LazyField ? CodedOutputStream.r0(((FieldDescriptorLite) entry.getKey()).J(), (LazyField) value) : CodedOutputStream.v0(((FieldDescriptorLite) entry.getKey()).J(), (MessageLite) value);
    }

    static int m(WireFormat.FieldType fieldType, boolean z2) {
        if (z2) {
            return 2;
        }
        return fieldType.b();
    }

    private static boolean q(Map.Entry entry) {
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        if (fieldDescriptorLite.M() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        if (!fieldDescriptorLite.K()) {
            return r(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!r(list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    private static boolean r(Object obj) {
        if (obj instanceof MessageLiteOrBuilder) {
            return ((MessageLiteOrBuilder) obj).isInitialized();
        }
        if (obj instanceof LazyField) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static boolean s(WireFormat.FieldType fieldType, Object obj) {
        Internal.a(obj);
        switch (AnonymousClass1.f36346a[fieldType.a().ordinal()]) {
            case 7:
                if ((obj instanceof ByteString) || (obj instanceof byte[])) {
                }
                break;
            case 8:
                if ((obj instanceof Integer) || (obj instanceof Internal.EnumLite)) {
                }
                break;
            case 9:
                if ((obj instanceof MessageLite) || (obj instanceof LazyField)) {
                }
                break;
        }
        return false;
    }

    private void w(Map.Entry entry) {
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        Object value = entry.getValue();
        boolean z2 = value instanceof LazyField;
        if (fieldDescriptorLite.K()) {
            if (z2) {
                throw new IllegalStateException("Lazy fields can not be repeated");
            }
            Object objI = i(fieldDescriptorLite);
            if (objI == null) {
                objI = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objI).add(c(it.next()));
            }
            this.f36343a.put(fieldDescriptorLite, objI);
            return;
        }
        if (fieldDescriptorLite.M() != WireFormat.JavaType.MESSAGE) {
            if (z2) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            this.f36343a.put(fieldDescriptorLite, c(value));
            return;
        }
        Object objI2 = i(fieldDescriptorLite);
        if (objI2 == null) {
            this.f36343a.put(fieldDescriptorLite, c(value));
            if (z2) {
                this.f36345c = true;
                return;
            }
            return;
        }
        if (z2) {
            value = ((LazyField) value).f();
        }
        this.f36343a.put(fieldDescriptorLite, fieldDescriptorLite.h1(((MessageLite) objI2).a(), (MessageLite) value).build());
    }

    public static FieldSet x() {
        return new FieldSet();
    }

    private void z(FieldDescriptorLite fieldDescriptorLite, Object obj) {
        if (!s(fieldDescriptorLite.L(), obj)) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(fieldDescriptorLite.J()), fieldDescriptorLite.L().a(), obj.getClass().getName()));
        }
    }

    public void a(FieldDescriptorLite fieldDescriptorLite, Object obj) {
        List arrayList;
        if (!fieldDescriptorLite.K()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        z(fieldDescriptorLite, obj);
        Object objI = i(fieldDescriptorLite);
        if (objI == null) {
            arrayList = new ArrayList();
            this.f36343a.put(fieldDescriptorLite, arrayList);
        } else {
            arrayList = (List) objI;
        }
        arrayList.add(obj);
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FieldSet clone() {
        FieldSet fieldSetX = x();
        int iK = this.f36343a.k();
        for (int i3 = 0; i3 < iK; i3++) {
            Map.Entry entryJ = this.f36343a.j(i3);
            fieldSetX.y((FieldDescriptorLite) entryJ.getKey(), entryJ.getValue());
        }
        for (Map.Entry entry : this.f36343a.m()) {
            fieldSetX.y((FieldDescriptorLite) entry.getKey(), entry.getValue());
        }
        fieldSetX.f36345c = this.f36345c;
        return fieldSetX;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FieldSet) {
            return this.f36343a.equals(((FieldSet) obj).f36343a);
        }
        return false;
    }

    Iterator g() {
        return n() ? Collections.emptyIterator() : this.f36345c ? new LazyField.LazyIterator(this.f36343a.h().iterator()) : this.f36343a.h().iterator();
    }

    public int hashCode() {
        return this.f36343a.hashCode();
    }

    public Object i(FieldDescriptorLite fieldDescriptorLite) {
        Object obj = this.f36343a.get(fieldDescriptorLite);
        return obj instanceof LazyField ? ((LazyField) obj).f() : obj;
    }

    public int j() {
        int iK = this.f36343a.k();
        int iK2 = 0;
        for (int i3 = 0; i3 < iK; i3++) {
            iK2 += k(this.f36343a.j(i3));
        }
        Iterator it = this.f36343a.m().iterator();
        while (it.hasNext()) {
            iK2 += k((Map.Entry) it.next());
        }
        return iK2;
    }

    public int l() {
        int iK = this.f36343a.k();
        int iF = 0;
        for (int i3 = 0; i3 < iK; i3++) {
            Map.Entry entryJ = this.f36343a.j(i3);
            iF += f((FieldDescriptorLite) entryJ.getKey(), entryJ.getValue());
        }
        for (Map.Entry entry : this.f36343a.m()) {
            iF += f((FieldDescriptorLite) entry.getKey(), entry.getValue());
        }
        return iF;
    }

    boolean n() {
        return this.f36343a.isEmpty();
    }

    public boolean o() {
        return this.f36344b;
    }

    public boolean p() {
        int iK = this.f36343a.k();
        for (int i3 = 0; i3 < iK; i3++) {
            if (!q(this.f36343a.j(i3))) {
                return false;
            }
        }
        Iterator it = this.f36343a.m().iterator();
        while (it.hasNext()) {
            if (!q((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator t() {
        return n() ? Collections.emptyIterator() : this.f36345c ? new LazyField.LazyIterator(this.f36343a.entrySet().iterator()) : this.f36343a.entrySet().iterator();
    }

    public void u() {
        if (this.f36344b) {
            return;
        }
        int iK = this.f36343a.k();
        for (int i3 = 0; i3 < iK; i3++) {
            Map.Entry entryJ = this.f36343a.j(i3);
            if (entryJ.getValue() instanceof GeneratedMessageLite) {
                ((GeneratedMessageLite) entryJ.getValue()).J();
            }
        }
        this.f36343a.p();
        this.f36344b = true;
    }

    public void v(FieldSet fieldSet) {
        int iK = fieldSet.f36343a.k();
        for (int i3 = 0; i3 < iK; i3++) {
            w(fieldSet.f36343a.j(i3));
        }
        Iterator it = fieldSet.f36343a.m().iterator();
        while (it.hasNext()) {
            w((Map.Entry) it.next());
        }
    }

    public void y(FieldDescriptorLite fieldDescriptorLite, Object obj) {
        if (!fieldDescriptorLite.K()) {
            z(fieldDescriptorLite, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj2 = arrayList.get(i3);
                i3++;
                z(fieldDescriptorLite, obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof LazyField) {
            this.f36345c = true;
        }
        this.f36343a.put(fieldDescriptorLite, obj);
    }

    private FieldSet(boolean z2) {
        this(SmallSortedMap.q());
        u();
    }

    private FieldSet(SmallSortedMap smallSortedMap) {
        this.f36343a = smallSortedMap;
        u();
    }
}
