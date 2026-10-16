package androidx.glance.appwidget.protobuf;

import androidx.glance.appwidget.protobuf.MapEntryLite;
import androidx.glance.appwidget.protobuf.WireFormat;
import androidx.glance.appwidget.protobuf.Writer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class CodedOutputStreamWriter implements Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CodedOutputStream f38930a;

    /* JADX INFO: renamed from: androidx.glance.appwidget.protobuf.CodedOutputStreamWriter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f38931a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f38931a = iArr;
            try {
                iArr[WireFormat.FieldType.f39336k.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38931a[WireFormat.FieldType.f39335j.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38931a[WireFormat.FieldType.f39333h.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f38931a[WireFormat.FieldType.f39343r.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f38931a[WireFormat.FieldType.f39345t.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f38931a[WireFormat.FieldType.f39341p.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f38931a[WireFormat.FieldType.f39334i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f38931a[WireFormat.FieldType.f39331f.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f38931a[WireFormat.FieldType.f39344s.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f38931a[WireFormat.FieldType.f39346u.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f38931a[WireFormat.FieldType.f39332g.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f38931a[WireFormat.FieldType.f39337l.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) Internal.b(codedOutputStream, "output");
        this.f38930a = codedOutputStream2;
        codedOutputStream2.f38908a = this;
    }

    public static CodedOutputStreamWriter Q(CodedOutputStream codedOutputStream) {
        CodedOutputStreamWriter codedOutputStreamWriter = codedOutputStream.f38908a;
        return codedOutputStreamWriter != null ? codedOutputStreamWriter : new CodedOutputStreamWriter(codedOutputStream);
    }

    private void R(int i3, boolean z2, Object obj, MapEntryLite.Metadata metadata) {
        this.f38930a.A1(i3, 2);
        this.f38930a.B1(MapEntryLite.b(metadata, Boolean.valueOf(z2), obj));
        MapEntryLite.e(this.f38930a, metadata, Boolean.valueOf(z2), obj);
    }

    private void S(int i3, MapEntryLite.Metadata metadata, Map map) {
        int size = map.size();
        int[] iArr = new int[size];
        Iterator it = map.keySet().iterator();
        int i4 = 0;
        while (it.hasNext()) {
            iArr[i4] = ((Integer) it.next()).intValue();
            i4++;
        }
        Arrays.sort(iArr);
        for (int i5 = 0; i5 < size; i5++) {
            int i6 = iArr[i5];
            Object obj = map.get(Integer.valueOf(i6));
            this.f38930a.A1(i3, 2);
            this.f38930a.B1(MapEntryLite.b(metadata, Integer.valueOf(i6), obj));
            MapEntryLite.e(this.f38930a, metadata, Integer.valueOf(i6), obj);
        }
    }

    private void T(int i3, MapEntryLite.Metadata metadata, Map map) {
        int size = map.size();
        long[] jArr = new long[size];
        Iterator it = map.keySet().iterator();
        int i4 = 0;
        while (it.hasNext()) {
            jArr[i4] = ((Long) it.next()).longValue();
            i4++;
        }
        Arrays.sort(jArr);
        for (int i5 = 0; i5 < size; i5++) {
            long j3 = jArr[i5];
            Object obj = map.get(Long.valueOf(j3));
            this.f38930a.A1(i3, 2);
            this.f38930a.B1(MapEntryLite.b(metadata, Long.valueOf(j3), obj));
            MapEntryLite.e(this.f38930a, metadata, Long.valueOf(j3), obj);
        }
    }

    private void U(int i3, MapEntryLite.Metadata metadata, Map map) {
        switch (AnonymousClass1.f38931a[metadata.f39149a.ordinal()]) {
            case 1:
                Object obj = map.get(Boolean.FALSE);
                if (obj != null) {
                    R(i3, false, obj, metadata);
                }
                Object obj2 = map.get(Boolean.TRUE);
                if (obj2 != null) {
                    R(i3, true, obj2, metadata);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                S(i3, metadata, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                T(i3, metadata, map);
                return;
            case 12:
                V(i3, metadata, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + metadata.f39149a);
        }
    }

    private void V(int i3, MapEntryLite.Metadata metadata, Map map) {
        int size = map.size();
        String[] strArr = new String[size];
        Iterator it = map.keySet().iterator();
        int i4 = 0;
        while (it.hasNext()) {
            strArr[i4] = (String) it.next();
            i4++;
        }
        Arrays.sort(strArr);
        for (int i5 = 0; i5 < size; i5++) {
            String str = strArr[i5];
            Object obj = map.get(str);
            this.f38930a.A1(i3, 2);
            this.f38930a.B1(MapEntryLite.b(metadata, str, obj));
            MapEntryLite.e(this.f38930a, metadata, str, obj);
        }
    }

    private void W(int i3, Object obj) {
        if (obj instanceof String) {
            this.f38930a.e(i3, (String) obj);
        } else {
            this.f38930a.M(i3, (ByteString) obj);
        }
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void A(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f38930a.x(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.f38930a.A1(i3, 2);
        int iD0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iD0 += CodedOutputStream.D0(((Integer) list.get(i5)).intValue());
        }
        this.f38930a.B1(iD0);
        while (i4 < list.size()) {
            this.f38930a.v1(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void B(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f38930a.w(i3, ((Boolean) list.get(i4)).booleanValue());
                i4++;
            }
            return;
        }
        this.f38930a.A1(i3, 2);
        int iW = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iW += CodedOutputStream.W(((Boolean) list.get(i5)).booleanValue());
        }
        this.f38930a.B1(iW);
        while (i4 < list.size()) {
            this.f38930a.b1(((Boolean) list.get(i4)).booleanValue());
            i4++;
        }
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void C(int i3, float f3) {
        this.f38930a.C(i3, f3);
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void D(int i3) {
        this.f38930a.A1(i3, 4);
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void E(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f38930a.I(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.f38930a.A1(i3, 2);
        int iH0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iH0 += CodedOutputStream.H0(((Integer) list.get(i5)).intValue());
        }
        this.f38930a.B1(iH0);
        while (i4 < list.size()) {
            this.f38930a.x1(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void F(int i3, int i4) {
        this.f38930a.F(i3, i4);
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void G(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f38930a.v(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.f38930a.A1(i3, 2);
        int iQ0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iQ0 += CodedOutputStream.q0(((Long) list.get(i5)).longValue());
        }
        this.f38930a.B1(iQ0);
        while (i4 < list.size()) {
            this.f38930a.p1(((Long) list.get(i4)).longValue());
            i4++;
        }
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void H(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f38930a.p(i3, ((Double) list.get(i4)).doubleValue());
                i4++;
            }
            return;
        }
        this.f38930a.A1(i3, 2);
        int iB0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iB0 += CodedOutputStream.b0(((Double) list.get(i5)).doubleValue());
        }
        this.f38930a.B1(iB0);
        while (i4 < list.size()) {
            this.f38930a.f1(((Double) list.get(i4)).doubleValue());
            i4++;
        }
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void I(int i3, int i4) {
        this.f38930a.I(i3, i4);
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void J(int i3, List list) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.f38930a.M(i3, (ByteString) list.get(i4));
        }
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void K(int i3, Object obj, Schema schema) {
        this.f38930a.l1(i3, (MessageLite) obj, schema);
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void L(int i3, Object obj, Schema schema) {
        this.f38930a.r1(i3, (MessageLite) obj, schema);
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void M(int i3, ByteString byteString) {
        this.f38930a.M(i3, byteString);
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void N(int i3, List list, Schema schema) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            K(i3, list.get(i4), schema);
        }
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void O(int i3, MapEntryLite.Metadata metadata, Map map) {
        if (this.f38930a.V0()) {
            U(i3, metadata, map);
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            this.f38930a.A1(i3, 2);
            this.f38930a.B1(MapEntryLite.b(metadata, entry.getKey(), entry.getValue()));
            MapEntryLite.e(this.f38930a, metadata, entry.getKey(), entry.getValue());
        }
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void P(int i3, List list, Schema schema) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            L(i3, list.get(i4), schema);
        }
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void a(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f38930a.C(i3, ((Float) list.get(i4)).floatValue());
                i4++;
            }
            return;
        }
        this.f38930a.A1(i3, 2);
        int iJ0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iJ0 += CodedOutputStream.j0(((Float) list.get(i5)).floatValue());
        }
        this.f38930a.B1(iJ0);
        while (i4 < list.size()) {
            this.f38930a.j1(((Float) list.get(i4)).floatValue());
            i4++;
        }
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public final void b(int i3, Object obj) {
        if (obj instanceof ByteString) {
            this.f38930a.u1(i3, (ByteString) obj);
        } else {
            this.f38930a.t1(i3, (MessageLite) obj);
        }
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void c(int i3, int i4) {
        this.f38930a.c(i3, i4);
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void d(int i3, List list) {
        int i4 = 0;
        if (!(list instanceof LazyStringList)) {
            while (i4 < list.size()) {
                this.f38930a.e(i3, (String) list.get(i4));
                i4++;
            }
        } else {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i4 < list.size()) {
                W(i3, lazyStringList.r(i4));
                i4++;
            }
        }
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void e(int i3, String str) {
        this.f38930a.e(i3, str);
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void f(int i3, long j3) {
        this.f38930a.f(i3, j3);
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void g(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f38930a.h(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.f38930a.A1(i3, 2);
        int iO0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iO0 += CodedOutputStream.o0(((Integer) list.get(i5)).intValue());
        }
        this.f38930a.B1(iO0);
        while (i4 < list.size()) {
            this.f38930a.o1(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void h(int i3, int i4) {
        this.f38930a.h(i3, i4);
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void i(int i3, long j3) {
        this.f38930a.i(i3, j3);
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void j(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f38930a.c(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.f38930a.A1(i3, 2);
        int iF0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iF0 += CodedOutputStream.f0(((Integer) list.get(i5)).intValue());
        }
        this.f38930a.B1(iF0);
        while (i4 < list.size()) {
            this.f38930a.h1(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void k(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f38930a.o(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.f38930a.A1(i3, 2);
        int iO0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iO0 += CodedOutputStream.O0(((Integer) list.get(i5)).intValue());
        }
        this.f38930a.B1(iO0);
        while (i4 < list.size()) {
            this.f38930a.B1(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void l(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f38930a.m(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.f38930a.A1(i3, 2);
        int iJ0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iJ0 += CodedOutputStream.J0(((Long) list.get(i5)).longValue());
        }
        this.f38930a.B1(iJ0);
        while (i4 < list.size()) {
            this.f38930a.y1(((Long) list.get(i4)).longValue());
            i4++;
        }
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void m(int i3, long j3) {
        this.f38930a.m(i3, j3);
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void n(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f38930a.F(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.f38930a.A1(i3, 2);
        int iD0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iD0 += CodedOutputStream.d0(((Integer) list.get(i5)).intValue());
        }
        this.f38930a.B1(iD0);
        while (i4 < list.size()) {
            this.f38930a.g1(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void o(int i3, int i4) {
        this.f38930a.o(i3, i4);
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void p(int i3, double d3) {
        this.f38930a.p(i3, d3);
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void q(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f38930a.i(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.f38930a.A1(i3, 2);
        int iF0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iF0 += CodedOutputStream.F0(((Long) list.get(i5)).longValue());
        }
        this.f38930a.B1(iF0);
        while (i4 < list.size()) {
            this.f38930a.w1(((Long) list.get(i4)).longValue());
            i4++;
        }
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void r(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f38930a.f(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.f38930a.A1(i3, 2);
        int iQ0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iQ0 += CodedOutputStream.Q0(((Long) list.get(i5)).longValue());
        }
        this.f38930a.B1(iQ0);
        while (i4 < list.size()) {
            this.f38930a.C1(((Long) list.get(i4)).longValue());
            i4++;
        }
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void s(int i3, long j3) {
        this.f38930a.s(i3, j3);
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public Writer.FieldOrder t() {
        return Writer.FieldOrder.ASCENDING;
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void u(int i3, Object obj) {
        this.f38930a.q1(i3, (MessageLite) obj);
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void v(int i3, long j3) {
        this.f38930a.v(i3, j3);
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void w(int i3, boolean z2) {
        this.f38930a.w(i3, z2);
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void x(int i3, int i4) {
        this.f38930a.x(i3, i4);
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void y(int i3) {
        this.f38930a.A1(i3, 3);
    }

    @Override // androidx.glance.appwidget.protobuf.Writer
    public void z(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f38930a.s(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.f38930a.A1(i3, 2);
        int iH0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iH0 += CodedOutputStream.h0(((Long) list.get(i5)).longValue());
        }
        this.f38930a.B1(iH0);
        while (i4 < list.size()) {
            this.f38930a.i1(((Long) list.get(i4)).longValue());
            i4++;
        }
    }
}
