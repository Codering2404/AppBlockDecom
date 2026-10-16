package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite;
import com.google.crypto.tink.shaded.protobuf.Internal;
import com.google.crypto.tink.shaded.protobuf.LazyField;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.WireFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class FieldSet<T extends FieldDescriptorLite<T>> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final FieldSet f86861d = new FieldSet(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SmallSortedMap f86862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f86863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f86864c;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.FieldSet$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f86865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f86866b;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f86866b = iArr;
            try {
                iArr[WireFormat.FieldType.f87190c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f86866b[WireFormat.FieldType.f87191d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f86866b[WireFormat.FieldType.f87192f.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f86866b[WireFormat.FieldType.f87193g.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f86866b[WireFormat.FieldType.f87194h.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f86866b[WireFormat.FieldType.f87195i.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f86866b[WireFormat.FieldType.f87196j.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f86866b[WireFormat.FieldType.f87197k.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f86866b[WireFormat.FieldType.f87199m.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f86866b[WireFormat.FieldType.f87200n.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f86866b[WireFormat.FieldType.f87198l.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f86866b[WireFormat.FieldType.f87201o.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f86866b[WireFormat.FieldType.f87202p.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f86866b[WireFormat.FieldType.f87204r.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f86866b[WireFormat.FieldType.f87205s.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f86866b[WireFormat.FieldType.f87206t.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f86866b[WireFormat.FieldType.f87207u.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f86866b[WireFormat.FieldType.f87203q.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[WireFormat.JavaType.values().length];
            f86865a = iArr2;
            try {
                iArr2[WireFormat.JavaType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f86865a[WireFormat.JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f86865a[WireFormat.JavaType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f86865a[WireFormat.JavaType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f86865a[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f86865a[WireFormat.JavaType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f86865a[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f86865a[WireFormat.JavaType.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f86865a[WireFormat.JavaType.MESSAGE.ordinal()] = 9;
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

        MessageLite.Builder w0(MessageLite.Builder builder, MessageLite messageLite);
    }

    private FieldSet() {
        this.f86862a = SmallSortedMap.q(16);
    }

    static void A(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i3, Object obj) {
        if (fieldType == WireFormat.FieldType.f87199m) {
            codedOutputStream.h1(i3, (MessageLite) obj);
        } else {
            codedOutputStream.x1(i3, m(fieldType, false));
            B(codedOutputStream, fieldType, obj);
        }
    }

    static void B(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) {
        switch (AnonymousClass1.f86866b[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.c1(((Double) obj).doubleValue());
                break;
            case 2:
                codedOutputStream.g1(((Float) obj).floatValue());
                break;
            case 3:
                codedOutputStream.m1(((Long) obj).longValue());
                break;
            case 4:
                codedOutputStream.z1(((Long) obj).longValue());
                break;
            case 5:
                codedOutputStream.l1(((Integer) obj).intValue());
                break;
            case 6:
                codedOutputStream.f1(((Long) obj).longValue());
                break;
            case 7:
                codedOutputStream.e1(((Integer) obj).intValue());
                break;
            case 8:
                codedOutputStream.Y0(((Boolean) obj).booleanValue());
                break;
            case 9:
                codedOutputStream.j1((MessageLite) obj);
                break;
            case 10:
                codedOutputStream.p1((MessageLite) obj);
                break;
            case 11:
                if (!(obj instanceof ByteString)) {
                    codedOutputStream.w1((String) obj);
                } else {
                    codedOutputStream.b1((ByteString) obj);
                }
                break;
            case 12:
                if (!(obj instanceof ByteString)) {
                    codedOutputStream.Z0((byte[]) obj);
                } else {
                    codedOutputStream.b1((ByteString) obj);
                }
                break;
            case 13:
                codedOutputStream.y1(((Integer) obj).intValue());
                break;
            case 14:
                codedOutputStream.s1(((Integer) obj).intValue());
                break;
            case 15:
                codedOutputStream.t1(((Long) obj).longValue());
                break;
            case 16:
                codedOutputStream.u1(((Integer) obj).intValue());
                break;
            case 17:
                codedOutputStream.v1(((Long) obj).longValue());
                break;
            case 18:
                if (!(obj instanceof Internal.EnumLite)) {
                    codedOutputStream.d1(((Integer) obj).intValue());
                } else {
                    codedOutputStream.d1(((Internal.EnumLite) obj).J());
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
        int iL0 = CodedOutputStream.L0(i3);
        if (fieldType == WireFormat.FieldType.f87199m) {
            iL0 *= 2;
        }
        return iL0 + e(fieldType, obj);
    }

    static int e(WireFormat.FieldType fieldType, Object obj) {
        switch (AnonymousClass1.f86866b[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.b0(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.j0(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.q0(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.P0(((Long) obj).longValue());
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
                return obj instanceof ByteString ? CodedOutputStream.Z((ByteString) obj) : CodedOutputStream.K0((String) obj);
            case 12:
                return obj instanceof ByteString ? CodedOutputStream.Z((ByteString) obj) : CodedOutputStream.X((byte[]) obj);
            case 13:
                return CodedOutputStream.N0(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.C0(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.E0(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.G0(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.I0(((Long) obj).longValue());
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
        int iD = 0;
        if (fieldDescriptorLite.N()) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                iD += e(fieldTypeL, it.next());
            }
            return CodedOutputStream.L0(iJ) + iD + CodedOutputStream.N0(iD);
        }
        Iterator it2 = ((List) obj).iterator();
        while (it2.hasNext()) {
            iD += d(fieldTypeL, iJ, it2.next());
        }
        return iD;
    }

    public static FieldSet h() {
        return f86861d;
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
        Iterator it = ((List) entry.getValue()).iterator();
        while (it.hasNext()) {
            if (!r(it.next())) {
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
        switch (AnonymousClass1.f86865a[fieldType.a().ordinal()]) {
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
        if (value instanceof LazyField) {
            value = ((LazyField) value).f();
        }
        if (fieldDescriptorLite.K()) {
            Object objI = i(fieldDescriptorLite);
            if (objI == null) {
                objI = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objI).add(c(it.next()));
            }
            this.f86862a.put(fieldDescriptorLite, objI);
            return;
        }
        if (fieldDescriptorLite.M() != WireFormat.JavaType.MESSAGE) {
            this.f86862a.put(fieldDescriptorLite, c(value));
            return;
        }
        Object objI2 = i(fieldDescriptorLite);
        if (objI2 == null) {
            this.f86862a.put(fieldDescriptorLite, c(value));
        } else {
            this.f86862a.put(fieldDescriptorLite, fieldDescriptorLite.w0(((MessageLite) objI2).a(), (MessageLite) value).build());
        }
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
            this.f86862a.put(fieldDescriptorLite, arrayList);
        } else {
            arrayList = (List) objI;
        }
        arrayList.add(obj);
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FieldSet clone() {
        FieldSet fieldSetX = x();
        for (int i3 = 0; i3 < this.f86862a.k(); i3++) {
            Map.Entry entryJ = this.f86862a.j(i3);
            fieldSetX.y((FieldDescriptorLite) entryJ.getKey(), entryJ.getValue());
        }
        for (Map.Entry entry : this.f86862a.m()) {
            fieldSetX.y((FieldDescriptorLite) entry.getKey(), entry.getValue());
        }
        fieldSetX.f86864c = this.f86864c;
        return fieldSetX;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FieldSet) {
            return this.f86862a.equals(((FieldSet) obj).f86862a);
        }
        return false;
    }

    Iterator g() {
        return this.f86864c ? new LazyField.LazyIterator(this.f86862a.h().iterator()) : this.f86862a.h().iterator();
    }

    public int hashCode() {
        return this.f86862a.hashCode();
    }

    public Object i(FieldDescriptorLite fieldDescriptorLite) {
        Object obj = this.f86862a.get(fieldDescriptorLite);
        return obj instanceof LazyField ? ((LazyField) obj).f() : obj;
    }

    public int j() {
        int iK = 0;
        for (int i3 = 0; i3 < this.f86862a.k(); i3++) {
            iK += k(this.f86862a.j(i3));
        }
        Iterator it = this.f86862a.m().iterator();
        while (it.hasNext()) {
            iK += k((Map.Entry) it.next());
        }
        return iK;
    }

    public int l() {
        int iF = 0;
        for (int i3 = 0; i3 < this.f86862a.k(); i3++) {
            Map.Entry entryJ = this.f86862a.j(i3);
            iF += f((FieldDescriptorLite) entryJ.getKey(), entryJ.getValue());
        }
        for (Map.Entry entry : this.f86862a.m()) {
            iF += f((FieldDescriptorLite) entry.getKey(), entry.getValue());
        }
        return iF;
    }

    boolean n() {
        return this.f86862a.isEmpty();
    }

    public boolean o() {
        return this.f86863b;
    }

    public boolean p() {
        for (int i3 = 0; i3 < this.f86862a.k(); i3++) {
            if (!q(this.f86862a.j(i3))) {
                return false;
            }
        }
        Iterator it = this.f86862a.m().iterator();
        while (it.hasNext()) {
            if (!q((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator t() {
        return this.f86864c ? new LazyField.LazyIterator(this.f86862a.entrySet().iterator()) : this.f86862a.entrySet().iterator();
    }

    public void u() {
        if (this.f86863b) {
            return;
        }
        for (int i3 = 0; i3 < this.f86862a.k(); i3++) {
            Map.Entry entryJ = this.f86862a.j(i3);
            if (entryJ.getValue() instanceof GeneratedMessageLite) {
                ((GeneratedMessageLite) entryJ.getValue()).G();
            }
        }
        this.f86862a.p();
        this.f86863b = true;
    }

    public void v(FieldSet fieldSet) {
        for (int i3 = 0; i3 < fieldSet.f86862a.k(); i3++) {
            w(fieldSet.f86862a.j(i3));
        }
        Iterator it = fieldSet.f86862a.m().iterator();
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
            this.f86864c = true;
        }
        this.f86862a.put(fieldDescriptorLite, obj);
    }

    private FieldSet(boolean z2) {
        this(SmallSortedMap.q(0));
        u();
    }

    private FieldSet(SmallSortedMap smallSortedMap) {
        this.f86862a = smallSortedMap;
        u();
    }
}
