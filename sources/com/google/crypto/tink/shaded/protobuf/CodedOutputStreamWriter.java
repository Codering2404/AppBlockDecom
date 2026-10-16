package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.MapEntryLite;
import com.google.crypto.tink.shaded.protobuf.WireFormat;
import com.google.crypto.tink.shaded.protobuf.Writer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@CheckReturnValue
final class CodedOutputStreamWriter implements Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CodedOutputStream f86791a;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.CodedOutputStreamWriter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f86792a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f86792a = iArr;
            try {
                iArr[WireFormat.FieldType.f87197k.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f86792a[WireFormat.FieldType.f87196j.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f86792a[WireFormat.FieldType.f87194h.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f86792a[WireFormat.FieldType.f87204r.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f86792a[WireFormat.FieldType.f87206t.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f86792a[WireFormat.FieldType.f87202p.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f86792a[WireFormat.FieldType.f87195i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f86792a[WireFormat.FieldType.f87192f.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f86792a[WireFormat.FieldType.f87205s.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f86792a[WireFormat.FieldType.f87207u.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f86792a[WireFormat.FieldType.f87193g.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f86792a[WireFormat.FieldType.f87198l.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) Internal.b(codedOutputStream, "output");
        this.f86791a = codedOutputStream2;
        codedOutputStream2.f86773a = this;
    }

    public static CodedOutputStreamWriter Q(CodedOutputStream codedOutputStream) {
        CodedOutputStreamWriter codedOutputStreamWriter = codedOutputStream.f86773a;
        return codedOutputStreamWriter != null ? codedOutputStreamWriter : new CodedOutputStreamWriter(codedOutputStream);
    }

    private void R(int i3, boolean z2, Object obj, MapEntryLite.Metadata metadata) {
        this.f86791a.x1(i3, 2);
        this.f86791a.y1(MapEntryLite.b(metadata, Boolean.valueOf(z2), obj));
        MapEntryLite.e(this.f86791a, metadata, Boolean.valueOf(z2), obj);
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
            this.f86791a.x1(i3, 2);
            this.f86791a.y1(MapEntryLite.b(metadata, Integer.valueOf(i6), obj));
            MapEntryLite.e(this.f86791a, metadata, Integer.valueOf(i6), obj);
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
            this.f86791a.x1(i3, 2);
            this.f86791a.y1(MapEntryLite.b(metadata, Long.valueOf(j3), obj));
            MapEntryLite.e(this.f86791a, metadata, Long.valueOf(j3), obj);
        }
    }

    private void U(int i3, MapEntryLite.Metadata metadata, Map map) {
        switch (AnonymousClass1.f86792a[metadata.f87010a.ordinal()]) {
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
                throw new IllegalArgumentException("does not support key type: " + metadata.f87010a);
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
            this.f86791a.x1(i3, 2);
            this.f86791a.y1(MapEntryLite.b(metadata, str, obj));
            MapEntryLite.e(this.f86791a, metadata, str, obj);
        }
    }

    private void W(int i3, Object obj) {
        if (obj instanceof String) {
            this.f86791a.e(i3, (String) obj);
        } else {
            this.f86791a.N(i3, (ByteString) obj);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void A(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f86791a.x(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.f86791a.x1(i3, 2);
        int iC0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iC0 += CodedOutputStream.C0(((Integer) list.get(i5)).intValue());
        }
        this.f86791a.y1(iC0);
        while (i4 < list.size()) {
            this.f86791a.s1(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void B(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f86791a.w(i3, ((Boolean) list.get(i4)).booleanValue());
                i4++;
            }
            return;
        }
        this.f86791a.x1(i3, 2);
        int iW = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iW += CodedOutputStream.W(((Boolean) list.get(i5)).booleanValue());
        }
        this.f86791a.y1(iW);
        while (i4 < list.size()) {
            this.f86791a.Y0(((Boolean) list.get(i4)).booleanValue());
            i4++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void C(int i3, float f3) {
        this.f86791a.C(i3, f3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void D(int i3) {
        this.f86791a.x1(i3, 4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void E(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f86791a.I(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.f86791a.x1(i3, 2);
        int iG0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iG0 += CodedOutputStream.G0(((Integer) list.get(i5)).intValue());
        }
        this.f86791a.y1(iG0);
        while (i4 < list.size()) {
            this.f86791a.u1(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void F(int i3, int i4) {
        this.f86791a.F(i3, i4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void G(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f86791a.v(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.f86791a.x1(i3, 2);
        int iQ0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iQ0 += CodedOutputStream.q0(((Long) list.get(i5)).longValue());
        }
        this.f86791a.y1(iQ0);
        while (i4 < list.size()) {
            this.f86791a.m1(((Long) list.get(i4)).longValue());
            i4++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void H(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f86791a.p(i3, ((Double) list.get(i4)).doubleValue());
                i4++;
            }
            return;
        }
        this.f86791a.x1(i3, 2);
        int iB0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iB0 += CodedOutputStream.b0(((Double) list.get(i5)).doubleValue());
        }
        this.f86791a.y1(iB0);
        while (i4 < list.size()) {
            this.f86791a.c1(((Double) list.get(i4)).doubleValue());
            i4++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void I(int i3, int i4) {
        this.f86791a.I(i3, i4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void J(int i3, List list) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.f86791a.N(i3, (ByteString) list.get(i4));
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void K(int i3, MapEntryLite.Metadata metadata, Map map) {
        if (this.f86791a.T0()) {
            U(i3, metadata, map);
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            this.f86791a.x1(i3, 2);
            this.f86791a.y1(MapEntryLite.b(metadata, entry.getKey(), entry.getValue()));
            MapEntryLite.e(this.f86791a, metadata, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void L(int i3, Object obj, Schema schema) {
        this.f86791a.i1(i3, (MessageLite) obj, schema);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void M(int i3, List list, Schema schema) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            O(i3, list.get(i4), schema);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void N(int i3, ByteString byteString) {
        this.f86791a.N(i3, byteString);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void O(int i3, Object obj, Schema schema) {
        this.f86791a.o1(i3, (MessageLite) obj, schema);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void P(int i3, List list, Schema schema) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            L(i3, list.get(i4), schema);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void a(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f86791a.C(i3, ((Float) list.get(i4)).floatValue());
                i4++;
            }
            return;
        }
        this.f86791a.x1(i3, 2);
        int iJ0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iJ0 += CodedOutputStream.j0(((Float) list.get(i5)).floatValue());
        }
        this.f86791a.y1(iJ0);
        while (i4 < list.size()) {
            this.f86791a.g1(((Float) list.get(i4)).floatValue());
            i4++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public final void b(int i3, Object obj) {
        if (obj instanceof ByteString) {
            this.f86791a.r1(i3, (ByteString) obj);
        } else {
            this.f86791a.q1(i3, (MessageLite) obj);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void c(int i3, int i4) {
        this.f86791a.c(i3, i4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void d(int i3, List list) {
        int i4 = 0;
        if (!(list instanceof LazyStringList)) {
            while (i4 < list.size()) {
                this.f86791a.e(i3, (String) list.get(i4));
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

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void e(int i3, String str) {
        this.f86791a.e(i3, str);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void f(int i3, long j3) {
        this.f86791a.f(i3, j3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void g(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f86791a.h(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.f86791a.x1(i3, 2);
        int iO0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iO0 += CodedOutputStream.o0(((Integer) list.get(i5)).intValue());
        }
        this.f86791a.y1(iO0);
        while (i4 < list.size()) {
            this.f86791a.l1(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void h(int i3, int i4) {
        this.f86791a.h(i3, i4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void i(int i3, long j3) {
        this.f86791a.i(i3, j3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void j(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f86791a.c(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.f86791a.x1(i3, 2);
        int iF0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iF0 += CodedOutputStream.f0(((Integer) list.get(i5)).intValue());
        }
        this.f86791a.y1(iF0);
        while (i4 < list.size()) {
            this.f86791a.e1(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void k(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f86791a.o(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.f86791a.x1(i3, 2);
        int iN0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iN0 += CodedOutputStream.N0(((Integer) list.get(i5)).intValue());
        }
        this.f86791a.y1(iN0);
        while (i4 < list.size()) {
            this.f86791a.y1(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void l(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f86791a.m(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.f86791a.x1(i3, 2);
        int iI0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iI0 += CodedOutputStream.I0(((Long) list.get(i5)).longValue());
        }
        this.f86791a.y1(iI0);
        while (i4 < list.size()) {
            this.f86791a.v1(((Long) list.get(i4)).longValue());
            i4++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void m(int i3, long j3) {
        this.f86791a.m(i3, j3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void n(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f86791a.F(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.f86791a.x1(i3, 2);
        int iD0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iD0 += CodedOutputStream.d0(((Integer) list.get(i5)).intValue());
        }
        this.f86791a.y1(iD0);
        while (i4 < list.size()) {
            this.f86791a.d1(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void o(int i3, int i4) {
        this.f86791a.o(i3, i4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void p(int i3, double d3) {
        this.f86791a.p(i3, d3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void q(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f86791a.i(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.f86791a.x1(i3, 2);
        int iE0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iE0 += CodedOutputStream.E0(((Long) list.get(i5)).longValue());
        }
        this.f86791a.y1(iE0);
        while (i4 < list.size()) {
            this.f86791a.t1(((Long) list.get(i4)).longValue());
            i4++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void r(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f86791a.f(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.f86791a.x1(i3, 2);
        int iP0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iP0 += CodedOutputStream.P0(((Long) list.get(i5)).longValue());
        }
        this.f86791a.y1(iP0);
        while (i4 < list.size()) {
            this.f86791a.z1(((Long) list.get(i4)).longValue());
            i4++;
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void s(int i3, long j3) {
        this.f86791a.s(i3, j3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public Writer.FieldOrder t() {
        return Writer.FieldOrder.ASCENDING;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void u(int i3, Object obj) {
        this.f86791a.n1(i3, (MessageLite) obj);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void v(int i3, long j3) {
        this.f86791a.v(i3, j3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void w(int i3, boolean z2) {
        this.f86791a.w(i3, z2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void x(int i3, int i4) {
        this.f86791a.x(i3, i4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void y(int i3) {
        this.f86791a.x1(i3, 3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Writer
    public void z(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f86791a.s(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.f86791a.x1(i3, 2);
        int iH0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iH0 += CodedOutputStream.h0(((Long) list.get(i5)).longValue());
        }
        this.f86791a.y1(iH0);
        while (i4 < list.size()) {
            this.f86791a.f1(((Long) list.get(i4)).longValue());
            i4++;
        }
    }
}
