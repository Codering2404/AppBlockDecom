package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Writer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class UnknownFieldSetLite {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final UnknownFieldSetLite f36636f = new UnknownFieldSetLite(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f36637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f36638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object[] f36639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f36640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f36641e;

    private UnknownFieldSetLite() {
        this(0, new int[8], new Object[8], true);
    }

    private void b(int i3) {
        int[] iArr = this.f36638b;
        if (i3 > iArr.length) {
            int i4 = this.f36637a;
            int i5 = i4 + (i4 / 2);
            if (i5 >= i3) {
                i3 = i5;
            }
            if (i3 < 8) {
                i3 = 8;
            }
            this.f36638b = Arrays.copyOf(iArr, i3);
            this.f36639c = Arrays.copyOf(this.f36639c, i3);
        }
    }

    public static UnknownFieldSetLite c() {
        return f36636f;
    }

    private static int f(int[] iArr, int i3) {
        int i4 = 17;
        for (int i5 = 0; i5 < i3; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        return i4;
    }

    private static int g(Object[] objArr, int i3) {
        int iHashCode = 17;
        for (int i4 = 0; i4 < i3; i4++) {
            iHashCode = (iHashCode * 31) + objArr[i4].hashCode();
        }
        return iHashCode;
    }

    static UnknownFieldSetLite j(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        int i3 = unknownFieldSetLite.f36637a + unknownFieldSetLite2.f36637a;
        int[] iArrCopyOf = Arrays.copyOf(unknownFieldSetLite.f36638b, i3);
        System.arraycopy(unknownFieldSetLite2.f36638b, 0, iArrCopyOf, unknownFieldSetLite.f36637a, unknownFieldSetLite2.f36637a);
        Object[] objArrCopyOf = Arrays.copyOf(unknownFieldSetLite.f36639c, i3);
        System.arraycopy(unknownFieldSetLite2.f36639c, 0, objArrCopyOf, unknownFieldSetLite.f36637a, unknownFieldSetLite2.f36637a);
        return new UnknownFieldSetLite(i3, iArrCopyOf, objArrCopyOf, true);
    }

    static UnknownFieldSetLite k() {
        return new UnknownFieldSetLite();
    }

    private static boolean l(Object[] objArr, Object[] objArr2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (!objArr[i4].equals(objArr2[i4])) {
                return false;
            }
        }
        return true;
    }

    private static boolean o(int[] iArr, int[] iArr2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (iArr[i4] != iArr2[i4]) {
                return false;
            }
        }
        return true;
    }

    private static void q(int i3, Object obj, Writer writer) {
        int iA = WireFormat.a(i3);
        int iB = WireFormat.b(i3);
        if (iB == 0) {
            writer.v(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 1) {
            writer.s(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 2) {
            writer.L(iA, (ByteString) obj);
            return;
        }
        if (iB != 3) {
            if (iB != 5) {
                throw new RuntimeException(InvalidProtocolBufferException.e());
            }
            writer.c(iA, ((Integer) obj).intValue());
        } else if (writer.t() == Writer.FieldOrder.ASCENDING) {
            writer.y(iA);
            ((UnknownFieldSetLite) obj).r(writer);
            writer.D(iA);
        } else {
            writer.D(iA);
            ((UnknownFieldSetLite) obj).r(writer);
            writer.y(iA);
        }
    }

    void a() {
        if (!this.f36641e) {
            throw new UnsupportedOperationException();
        }
    }

    public int d() {
        int iP0;
        int i3 = this.f36640d;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.f36637a; i5++) {
            int i6 = this.f36638b[i5];
            int iA = WireFormat.a(i6);
            int iB = WireFormat.b(i6);
            if (iB == 0) {
                iP0 = CodedOutputStream.P0(iA, ((Long) this.f36639c[i5]).longValue());
            } else if (iB == 1) {
                iP0 = CodedOutputStream.g0(iA, ((Long) this.f36639c[i5]).longValue());
            } else if (iB == 2) {
                iP0 = CodedOutputStream.Y(iA, (ByteString) this.f36639c[i5]);
            } else if (iB == 3) {
                iP0 = (CodedOutputStream.M0(iA) * 2) + ((UnknownFieldSetLite) this.f36639c[i5]).d();
            } else {
                if (iB != 5) {
                    throw new IllegalStateException(InvalidProtocolBufferException.e());
                }
                iP0 = CodedOutputStream.e0(iA, ((Integer) this.f36639c[i5]).intValue());
            }
            i4 += iP0;
        }
        this.f36640d = i4;
        return i4;
    }

    public int e() {
        int i3 = this.f36640d;
        if (i3 != -1) {
            return i3;
        }
        int iB0 = 0;
        for (int i4 = 0; i4 < this.f36637a; i4++) {
            iB0 += CodedOutputStream.B0(WireFormat.a(this.f36638b[i4]), (ByteString) this.f36639c[i4]);
        }
        this.f36640d = iB0;
        return iB0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UnknownFieldSetLite)) {
            return false;
        }
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        int i3 = this.f36637a;
        return i3 == unknownFieldSetLite.f36637a && o(this.f36638b, unknownFieldSetLite.f36638b, i3) && l(this.f36639c, unknownFieldSetLite.f36639c, this.f36637a);
    }

    public void h() {
        if (this.f36641e) {
            this.f36641e = false;
        }
    }

    public int hashCode() {
        int i3 = this.f36637a;
        return ((((527 + i3) * 31) + f(this.f36638b, i3)) * 31) + g(this.f36639c, this.f36637a);
    }

    UnknownFieldSetLite i(UnknownFieldSetLite unknownFieldSetLite) {
        if (unknownFieldSetLite.equals(c())) {
            return this;
        }
        a();
        int i3 = this.f36637a + unknownFieldSetLite.f36637a;
        b(i3);
        System.arraycopy(unknownFieldSetLite.f36638b, 0, this.f36638b, this.f36637a, unknownFieldSetLite.f36637a);
        System.arraycopy(unknownFieldSetLite.f36639c, 0, this.f36639c, this.f36637a, unknownFieldSetLite.f36637a);
        this.f36637a = i3;
        return this;
    }

    final void m(StringBuilder sb, int i3) {
        for (int i4 = 0; i4 < this.f36637a; i4++) {
            MessageLiteToString.d(sb, i3, String.valueOf(WireFormat.a(this.f36638b[i4])), this.f36639c[i4]);
        }
    }

    void n(int i3, Object obj) {
        a();
        b(this.f36637a + 1);
        int[] iArr = this.f36638b;
        int i4 = this.f36637a;
        iArr[i4] = i3;
        this.f36639c[i4] = obj;
        this.f36637a = i4 + 1;
    }

    void p(Writer writer) {
        if (writer.t() == Writer.FieldOrder.DESCENDING) {
            for (int i3 = this.f36637a - 1; i3 >= 0; i3--) {
                writer.b(WireFormat.a(this.f36638b[i3]), this.f36639c[i3]);
            }
            return;
        }
        for (int i4 = 0; i4 < this.f36637a; i4++) {
            writer.b(WireFormat.a(this.f36638b[i4]), this.f36639c[i4]);
        }
    }

    public void r(Writer writer) {
        if (this.f36637a == 0) {
            return;
        }
        if (writer.t() == Writer.FieldOrder.ASCENDING) {
            for (int i3 = 0; i3 < this.f36637a; i3++) {
                q(this.f36638b[i3], this.f36639c[i3], writer);
            }
            return;
        }
        for (int i4 = this.f36637a - 1; i4 >= 0; i4--) {
            q(this.f36638b[i4], this.f36639c[i4], writer);
        }
    }

    private UnknownFieldSetLite(int i3, int[] iArr, Object[] objArr, boolean z2) {
        this.f36640d = -1;
        this.f36637a = i3;
        this.f36638b = iArr;
        this.f36639c = objArr;
        this.f36641e = z2;
    }
}
