package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class CodedOutputStreamWriter implements Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CodedOutputStream f36122a;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.CodedOutputStreamWriter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f36123a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f36123a = iArr;
            try {
                iArr[WireFormat.FieldType.f36695k.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36123a[WireFormat.FieldType.f36694j.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36123a[WireFormat.FieldType.f36692h.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f36123a[WireFormat.FieldType.f36702r.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f36123a[WireFormat.FieldType.f36704t.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f36123a[WireFormat.FieldType.f36700p.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f36123a[WireFormat.FieldType.f36693i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f36123a[WireFormat.FieldType.f36690f.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f36123a[WireFormat.FieldType.f36703s.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f36123a[WireFormat.FieldType.f36705u.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f36123a[WireFormat.FieldType.f36691g.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f36123a[WireFormat.FieldType.f36696l.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) Internal.b(codedOutputStream, "output");
        this.f36122a = codedOutputStream2;
        codedOutputStream2.f36100a = this;
    }

    public static CodedOutputStreamWriter Q(CodedOutputStream codedOutputStream) {
        CodedOutputStreamWriter codedOutputStreamWriter = codedOutputStream.f36100a;
        return codedOutputStreamWriter != null ? codedOutputStreamWriter : new CodedOutputStreamWriter(codedOutputStream);
    }

    private void R(int i3, BooleanArrayList booleanArrayList, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < booleanArrayList.size()) {
                this.f36122a.w(i3, booleanArrayList.l(i4));
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iW = 0;
        for (int i5 = 0; i5 < booleanArrayList.size(); i5++) {
            iW += CodedOutputStream.W(booleanArrayList.l(i5));
        }
        this.f36122a.B1(iW);
        while (i4 < booleanArrayList.size()) {
            this.f36122a.b1(booleanArrayList.l(i4));
            i4++;
        }
    }

    private void S(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f36122a.w(i3, ((Boolean) list.get(i4)).booleanValue());
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iW = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iW += CodedOutputStream.W(((Boolean) list.get(i5)).booleanValue());
        }
        this.f36122a.B1(iW);
        while (i4 < list.size()) {
            this.f36122a.b1(((Boolean) list.get(i4)).booleanValue());
            i4++;
        }
    }

    private void T(int i3, boolean z2, Object obj, MapEntryLite.Metadata metadata) {
        this.f36122a.A1(i3, 2);
        this.f36122a.B1(MapEntryLite.b(metadata, Boolean.valueOf(z2), obj));
        MapEntryLite.e(this.f36122a, metadata, Boolean.valueOf(z2), obj);
    }

    private void U(int i3, MapEntryLite.Metadata metadata, Map map) {
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
            this.f36122a.A1(i3, 2);
            this.f36122a.B1(MapEntryLite.b(metadata, Integer.valueOf(i6), obj));
            MapEntryLite.e(this.f36122a, metadata, Integer.valueOf(i6), obj);
        }
    }

    private void V(int i3, MapEntryLite.Metadata metadata, Map map) {
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
            this.f36122a.A1(i3, 2);
            this.f36122a.B1(MapEntryLite.b(metadata, Long.valueOf(j3), obj));
            MapEntryLite.e(this.f36122a, metadata, Long.valueOf(j3), obj);
        }
    }

    private void W(int i3, MapEntryLite.Metadata metadata, Map map) {
        switch (AnonymousClass1.f36123a[metadata.f36503a.ordinal()]) {
            case 1:
                Object obj = map.get(Boolean.FALSE);
                if (obj != null) {
                    T(i3, false, obj, metadata);
                }
                Object obj2 = map.get(Boolean.TRUE);
                if (obj2 != null) {
                    T(i3, true, obj2, metadata);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                U(i3, metadata, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                V(i3, metadata, map);
                return;
            case 12:
                X(i3, metadata, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + metadata.f36503a);
        }
    }

    private void X(int i3, MapEntryLite.Metadata metadata, Map map) {
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
            this.f36122a.A1(i3, 2);
            this.f36122a.B1(MapEntryLite.b(metadata, str, obj));
            MapEntryLite.e(this.f36122a, metadata, str, obj);
        }
    }

    private void Y(int i3, DoubleArrayList doubleArrayList, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < doubleArrayList.size()) {
                this.f36122a.p(i3, doubleArrayList.l(i4));
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iB0 = 0;
        for (int i5 = 0; i5 < doubleArrayList.size(); i5++) {
            iB0 += CodedOutputStream.b0(doubleArrayList.l(i5));
        }
        this.f36122a.B1(iB0);
        while (i4 < doubleArrayList.size()) {
            this.f36122a.f1(doubleArrayList.l(i4));
            i4++;
        }
    }

    private void Z(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f36122a.p(i3, ((Double) list.get(i4)).doubleValue());
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iB0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iB0 += CodedOutputStream.b0(((Double) list.get(i5)).doubleValue());
        }
        this.f36122a.B1(iB0);
        while (i4 < list.size()) {
            this.f36122a.f1(((Double) list.get(i4)).doubleValue());
            i4++;
        }
    }

    private void a0(int i3, IntArrayList intArrayList, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < intArrayList.size()) {
                this.f36122a.F(i3, intArrayList.getInt(i4));
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iD0 = 0;
        for (int i5 = 0; i5 < intArrayList.size(); i5++) {
            iD0 += CodedOutputStream.d0(intArrayList.getInt(i5));
        }
        this.f36122a.B1(iD0);
        while (i4 < intArrayList.size()) {
            this.f36122a.g1(intArrayList.getInt(i4));
            i4++;
        }
    }

    private void b0(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f36122a.F(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iD0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iD0 += CodedOutputStream.d0(((Integer) list.get(i5)).intValue());
        }
        this.f36122a.B1(iD0);
        while (i4 < list.size()) {
            this.f36122a.g1(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    private void c0(int i3, IntArrayList intArrayList, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < intArrayList.size()) {
                this.f36122a.c(i3, intArrayList.getInt(i4));
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iF0 = 0;
        for (int i5 = 0; i5 < intArrayList.size(); i5++) {
            iF0 += CodedOutputStream.f0(intArrayList.getInt(i5));
        }
        this.f36122a.B1(iF0);
        while (i4 < intArrayList.size()) {
            this.f36122a.h1(intArrayList.getInt(i4));
            i4++;
        }
    }

    private void d0(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f36122a.c(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iF0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iF0 += CodedOutputStream.f0(((Integer) list.get(i5)).intValue());
        }
        this.f36122a.B1(iF0);
        while (i4 < list.size()) {
            this.f36122a.h1(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    private void e0(int i3, LongArrayList longArrayList, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < longArrayList.size()) {
                this.f36122a.s(i3, longArrayList.l(i4));
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iH0 = 0;
        for (int i5 = 0; i5 < longArrayList.size(); i5++) {
            iH0 += CodedOutputStream.h0(longArrayList.l(i5));
        }
        this.f36122a.B1(iH0);
        while (i4 < longArrayList.size()) {
            this.f36122a.i1(longArrayList.l(i4));
            i4++;
        }
    }

    private void f0(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f36122a.s(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iH0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iH0 += CodedOutputStream.h0(((Long) list.get(i5)).longValue());
        }
        this.f36122a.B1(iH0);
        while (i4 < list.size()) {
            this.f36122a.i1(((Long) list.get(i4)).longValue());
            i4++;
        }
    }

    private void g0(int i3, FloatArrayList floatArrayList, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < floatArrayList.size()) {
                this.f36122a.C(i3, floatArrayList.l(i4));
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iJ0 = 0;
        for (int i5 = 0; i5 < floatArrayList.size(); i5++) {
            iJ0 += CodedOutputStream.j0(floatArrayList.l(i5));
        }
        this.f36122a.B1(iJ0);
        while (i4 < floatArrayList.size()) {
            this.f36122a.j1(floatArrayList.l(i4));
            i4++;
        }
    }

    private void h0(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f36122a.C(i3, ((Float) list.get(i4)).floatValue());
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iJ0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iJ0 += CodedOutputStream.j0(((Float) list.get(i5)).floatValue());
        }
        this.f36122a.B1(iJ0);
        while (i4 < list.size()) {
            this.f36122a.j1(((Float) list.get(i4)).floatValue());
            i4++;
        }
    }

    private void i0(int i3, IntArrayList intArrayList, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < intArrayList.size()) {
                this.f36122a.h(i3, intArrayList.getInt(i4));
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iO0 = 0;
        for (int i5 = 0; i5 < intArrayList.size(); i5++) {
            iO0 += CodedOutputStream.o0(intArrayList.getInt(i5));
        }
        this.f36122a.B1(iO0);
        while (i4 < intArrayList.size()) {
            this.f36122a.o1(intArrayList.getInt(i4));
            i4++;
        }
    }

    private void j0(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f36122a.h(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iO0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iO0 += CodedOutputStream.o0(((Integer) list.get(i5)).intValue());
        }
        this.f36122a.B1(iO0);
        while (i4 < list.size()) {
            this.f36122a.o1(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    private void k0(int i3, LongArrayList longArrayList, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < longArrayList.size()) {
                this.f36122a.v(i3, longArrayList.l(i4));
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iQ0 = 0;
        for (int i5 = 0; i5 < longArrayList.size(); i5++) {
            iQ0 += CodedOutputStream.q0(longArrayList.l(i5));
        }
        this.f36122a.B1(iQ0);
        while (i4 < longArrayList.size()) {
            this.f36122a.p1(longArrayList.l(i4));
            i4++;
        }
    }

    private void l0(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f36122a.v(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iQ0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iQ0 += CodedOutputStream.q0(((Long) list.get(i5)).longValue());
        }
        this.f36122a.B1(iQ0);
        while (i4 < list.size()) {
            this.f36122a.p1(((Long) list.get(i4)).longValue());
            i4++;
        }
    }

    private void m0(int i3, Object obj) {
        if (obj instanceof String) {
            this.f36122a.e(i3, (String) obj);
        } else {
            this.f36122a.L(i3, (ByteString) obj);
        }
    }

    private void n0(int i3, IntArrayList intArrayList, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < intArrayList.size()) {
                this.f36122a.x(i3, intArrayList.getInt(i4));
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iD0 = 0;
        for (int i5 = 0; i5 < intArrayList.size(); i5++) {
            iD0 += CodedOutputStream.D0(intArrayList.getInt(i5));
        }
        this.f36122a.B1(iD0);
        while (i4 < intArrayList.size()) {
            this.f36122a.v1(intArrayList.getInt(i4));
            i4++;
        }
    }

    private void o0(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f36122a.x(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iD0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iD0 += CodedOutputStream.D0(((Integer) list.get(i5)).intValue());
        }
        this.f36122a.B1(iD0);
        while (i4 < list.size()) {
            this.f36122a.v1(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    private void p0(int i3, LongArrayList longArrayList, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < longArrayList.size()) {
                this.f36122a.i(i3, longArrayList.l(i4));
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iF0 = 0;
        for (int i5 = 0; i5 < longArrayList.size(); i5++) {
            iF0 += CodedOutputStream.F0(longArrayList.l(i5));
        }
        this.f36122a.B1(iF0);
        while (i4 < longArrayList.size()) {
            this.f36122a.w1(longArrayList.l(i4));
            i4++;
        }
    }

    private void q0(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f36122a.i(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iF0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iF0 += CodedOutputStream.F0(((Long) list.get(i5)).longValue());
        }
        this.f36122a.B1(iF0);
        while (i4 < list.size()) {
            this.f36122a.w1(((Long) list.get(i4)).longValue());
            i4++;
        }
    }

    private void r0(int i3, IntArrayList intArrayList, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < intArrayList.size()) {
                this.f36122a.I(i3, intArrayList.getInt(i4));
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iH0 = 0;
        for (int i5 = 0; i5 < intArrayList.size(); i5++) {
            iH0 += CodedOutputStream.H0(intArrayList.getInt(i5));
        }
        this.f36122a.B1(iH0);
        while (i4 < intArrayList.size()) {
            this.f36122a.x1(intArrayList.getInt(i4));
            i4++;
        }
    }

    private void t0(int i3, LongArrayList longArrayList, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < longArrayList.size()) {
                this.f36122a.m(i3, longArrayList.l(i4));
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iJ0 = 0;
        for (int i5 = 0; i5 < longArrayList.size(); i5++) {
            iJ0 += CodedOutputStream.J0(longArrayList.l(i5));
        }
        this.f36122a.B1(iJ0);
        while (i4 < longArrayList.size()) {
            this.f36122a.y1(longArrayList.l(i4));
            i4++;
        }
    }

    private void u0(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f36122a.m(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iJ0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iJ0 += CodedOutputStream.J0(((Long) list.get(i5)).longValue());
        }
        this.f36122a.B1(iJ0);
        while (i4 < list.size()) {
            this.f36122a.y1(((Long) list.get(i4)).longValue());
            i4++;
        }
    }

    private void v0(int i3, IntArrayList intArrayList, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < intArrayList.size()) {
                this.f36122a.o(i3, intArrayList.getInt(i4));
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iO0 = 0;
        for (int i5 = 0; i5 < intArrayList.size(); i5++) {
            iO0 += CodedOutputStream.O0(intArrayList.getInt(i5));
        }
        this.f36122a.B1(iO0);
        while (i4 < intArrayList.size()) {
            this.f36122a.B1(intArrayList.getInt(i4));
            i4++;
        }
    }

    private void x0(int i3, LongArrayList longArrayList, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < longArrayList.size()) {
                this.f36122a.f(i3, longArrayList.l(i4));
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iQ0 = 0;
        for (int i5 = 0; i5 < longArrayList.size(); i5++) {
            iQ0 += CodedOutputStream.Q0(longArrayList.l(i5));
        }
        this.f36122a.B1(iQ0);
        while (i4 < longArrayList.size()) {
            this.f36122a.C1(longArrayList.l(i4));
            i4++;
        }
    }

    private void y0(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f36122a.f(i3, ((Long) list.get(i4)).longValue());
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iQ0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iQ0 += CodedOutputStream.Q0(((Long) list.get(i5)).longValue());
        }
        this.f36122a.B1(iQ0);
        while (i4 < list.size()) {
            this.f36122a.C1(((Long) list.get(i4)).longValue());
            i4++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void A(int i3, List list, boolean z2) {
        if (list instanceof IntArrayList) {
            n0(i3, (IntArrayList) list, z2);
        } else {
            o0(i3, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void B(int i3, List list, boolean z2) {
        if (list instanceof BooleanArrayList) {
            R(i3, (BooleanArrayList) list, z2);
        } else {
            S(i3, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void C(int i3, float f3) {
        this.f36122a.C(i3, f3);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void D(int i3) {
        this.f36122a.A1(i3, 4);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void E(int i3, List list, boolean z2) {
        if (list instanceof IntArrayList) {
            r0(i3, (IntArrayList) list, z2);
        } else {
            s0(i3, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void F(int i3, int i4) {
        this.f36122a.F(i3, i4);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void G(int i3, List list, boolean z2) {
        if (list instanceof LongArrayList) {
            k0(i3, (LongArrayList) list, z2);
        } else {
            l0(i3, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void H(int i3, List list, boolean z2) {
        if (list instanceof DoubleArrayList) {
            Y(i3, (DoubleArrayList) list, z2);
        } else {
            Z(i3, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void I(int i3, int i4) {
        this.f36122a.I(i3, i4);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void J(int i3, List list) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.f36122a.L(i3, (ByteString) list.get(i4));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void K(int i3, List list, Schema schema) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            O(i3, list.get(i4), schema);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void L(int i3, ByteString byteString) {
        this.f36122a.L(i3, byteString);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void M(int i3, Object obj, Schema schema) {
        this.f36122a.r1(i3, (MessageLite) obj, schema);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void N(int i3, MapEntryLite.Metadata metadata, Map map) {
        if (this.f36122a.V0()) {
            W(i3, metadata, map);
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            this.f36122a.A1(i3, 2);
            this.f36122a.B1(MapEntryLite.b(metadata, entry.getKey(), entry.getValue()));
            MapEntryLite.e(this.f36122a, metadata, entry.getKey(), entry.getValue());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void O(int i3, Object obj, Schema schema) {
        this.f36122a.l1(i3, (MessageLite) obj, schema);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void P(int i3, List list, Schema schema) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            M(i3, list.get(i4), schema);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void a(int i3, List list, boolean z2) {
        if (list instanceof FloatArrayList) {
            g0(i3, (FloatArrayList) list, z2);
        } else {
            h0(i3, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void b(int i3, Object obj) {
        if (obj instanceof ByteString) {
            this.f36122a.u1(i3, (ByteString) obj);
        } else {
            this.f36122a.t1(i3, (MessageLite) obj);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void c(int i3, int i4) {
        this.f36122a.c(i3, i4);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void d(int i3, List list) {
        int i4 = 0;
        if (!(list instanceof LazyStringList)) {
            while (i4 < list.size()) {
                this.f36122a.e(i3, (String) list.get(i4));
                i4++;
            }
        } else {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i4 < list.size()) {
                m0(i3, lazyStringList.r(i4));
                i4++;
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void e(int i3, String str) {
        this.f36122a.e(i3, str);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void f(int i3, long j3) {
        this.f36122a.f(i3, j3);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void g(int i3, List list, boolean z2) {
        if (list instanceof IntArrayList) {
            i0(i3, (IntArrayList) list, z2);
        } else {
            j0(i3, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void h(int i3, int i4) {
        this.f36122a.h(i3, i4);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void i(int i3, long j3) {
        this.f36122a.i(i3, j3);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void j(int i3, List list, boolean z2) {
        if (list instanceof IntArrayList) {
            c0(i3, (IntArrayList) list, z2);
        } else {
            d0(i3, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void k(int i3, List list, boolean z2) {
        if (list instanceof IntArrayList) {
            v0(i3, (IntArrayList) list, z2);
        } else {
            w0(i3, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void l(int i3, List list, boolean z2) {
        if (list instanceof LongArrayList) {
            t0(i3, (LongArrayList) list, z2);
        } else {
            u0(i3, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void m(int i3, long j3) {
        this.f36122a.m(i3, j3);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void n(int i3, List list, boolean z2) {
        if (list instanceof IntArrayList) {
            a0(i3, (IntArrayList) list, z2);
        } else {
            b0(i3, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void o(int i3, int i4) {
        this.f36122a.o(i3, i4);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void p(int i3, double d3) {
        this.f36122a.p(i3, d3);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void q(int i3, List list, boolean z2) {
        if (list instanceof LongArrayList) {
            p0(i3, (LongArrayList) list, z2);
        } else {
            q0(i3, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void r(int i3, List list, boolean z2) {
        if (list instanceof LongArrayList) {
            x0(i3, (LongArrayList) list, z2);
        } else {
            y0(i3, list, z2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void s(int i3, long j3) {
        this.f36122a.s(i3, j3);
    }

    public void s0(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f36122a.I(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iH0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iH0 += CodedOutputStream.H0(((Integer) list.get(i5)).intValue());
        }
        this.f36122a.B1(iH0);
        while (i4 < list.size()) {
            this.f36122a.x1(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public Writer.FieldOrder t() {
        return Writer.FieldOrder.ASCENDING;
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void u(int i3, Object obj) {
        this.f36122a.q1(i3, (MessageLite) obj);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void v(int i3, long j3) {
        this.f36122a.v(i3, j3);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void w(int i3, boolean z2) {
        this.f36122a.w(i3, z2);
    }

    public void w0(int i3, List list, boolean z2) {
        int i4 = 0;
        if (!z2) {
            while (i4 < list.size()) {
                this.f36122a.o(i3, ((Integer) list.get(i4)).intValue());
                i4++;
            }
            return;
        }
        this.f36122a.A1(i3, 2);
        int iO0 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            iO0 += CodedOutputStream.O0(((Integer) list.get(i5)).intValue());
        }
        this.f36122a.B1(iO0);
        while (i4 < list.size()) {
            this.f36122a.B1(((Integer) list.get(i4)).intValue());
            i4++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void x(int i3, int i4) {
        this.f36122a.x(i3, i4);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void y(int i3) {
        this.f36122a.A1(i3, 3);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void z(int i3, List list, boolean z2) {
        if (list instanceof LongArrayList) {
            e0(i3, (LongArrayList) list, z2);
        } else {
            f0(i3, list, z2);
        }
    }
}
