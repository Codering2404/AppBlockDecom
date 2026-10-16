package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.Writer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class UnknownFieldSetLite {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final UnknownFieldSetLite f87138f = new UnknownFieldSetLite(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f87139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f87140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object[] f87141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f87142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f87143e;

    private UnknownFieldSetLite() {
        this(0, new int[8], new Object[8], true);
    }

    private void b(int i3) {
        int[] iArr = this.f87140b;
        if (i3 > iArr.length) {
            int i4 = this.f87139a;
            int i5 = i4 + (i4 / 2);
            if (i5 >= i3) {
                i3 = i5;
            }
            if (i3 < 8) {
                i3 = 8;
            }
            this.f87140b = Arrays.copyOf(iArr, i3);
            this.f87141c = Arrays.copyOf(this.f87141c, i3);
        }
    }

    public static UnknownFieldSetLite c() {
        return f87138f;
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
        int i3 = unknownFieldSetLite.f87139a + unknownFieldSetLite2.f87139a;
        int[] iArrCopyOf = Arrays.copyOf(unknownFieldSetLite.f87140b, i3);
        System.arraycopy(unknownFieldSetLite2.f87140b, 0, iArrCopyOf, unknownFieldSetLite.f87139a, unknownFieldSetLite2.f87139a);
        Object[] objArrCopyOf = Arrays.copyOf(unknownFieldSetLite.f87141c, i3);
        System.arraycopy(unknownFieldSetLite2.f87141c, 0, objArrCopyOf, unknownFieldSetLite.f87139a, unknownFieldSetLite2.f87139a);
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
            writer.N(iA, (ByteString) obj);
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
        if (!this.f87143e) {
            throw new UnsupportedOperationException();
        }
    }

    public int d() {
        int iO0;
        int i3 = this.f87142d;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.f87139a; i5++) {
            int i6 = this.f87140b[i5];
            int iA = WireFormat.a(i6);
            int iB = WireFormat.b(i6);
            if (iB == 0) {
                iO0 = CodedOutputStream.O0(iA, ((Long) this.f87141c[i5]).longValue());
            } else if (iB == 1) {
                iO0 = CodedOutputStream.g0(iA, ((Long) this.f87141c[i5]).longValue());
            } else if (iB == 2) {
                iO0 = CodedOutputStream.Y(iA, (ByteString) this.f87141c[i5]);
            } else if (iB == 3) {
                iO0 = (CodedOutputStream.L0(iA) * 2) + ((UnknownFieldSetLite) this.f87141c[i5]).d();
            } else {
                if (iB != 5) {
                    throw new IllegalStateException(InvalidProtocolBufferException.e());
                }
                iO0 = CodedOutputStream.e0(iA, ((Integer) this.f87141c[i5]).intValue());
            }
            i4 += iO0;
        }
        this.f87142d = i4;
        return i4;
    }

    public int e() {
        int i3 = this.f87142d;
        if (i3 != -1) {
            return i3;
        }
        int iA0 = 0;
        for (int i4 = 0; i4 < this.f87139a; i4++) {
            iA0 += CodedOutputStream.A0(WireFormat.a(this.f87140b[i4]), (ByteString) this.f87141c[i4]);
        }
        this.f87142d = iA0;
        return iA0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UnknownFieldSetLite)) {
            return false;
        }
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        int i3 = this.f87139a;
        return i3 == unknownFieldSetLite.f87139a && o(this.f87140b, unknownFieldSetLite.f87140b, i3) && l(this.f87141c, unknownFieldSetLite.f87141c, this.f87139a);
    }

    public void h() {
        this.f87143e = false;
    }

    public int hashCode() {
        int i3 = this.f87139a;
        return ((((527 + i3) * 31) + f(this.f87140b, i3)) * 31) + g(this.f87141c, this.f87139a);
    }

    UnknownFieldSetLite i(UnknownFieldSetLite unknownFieldSetLite) {
        if (unknownFieldSetLite.equals(c())) {
            return this;
        }
        a();
        int i3 = this.f87139a + unknownFieldSetLite.f87139a;
        b(i3);
        System.arraycopy(unknownFieldSetLite.f87140b, 0, this.f87140b, this.f87139a, unknownFieldSetLite.f87139a);
        System.arraycopy(unknownFieldSetLite.f87141c, 0, this.f87141c, this.f87139a, unknownFieldSetLite.f87139a);
        this.f87139a = i3;
        return this;
    }

    final void m(StringBuilder sb, int i3) {
        for (int i4 = 0; i4 < this.f87139a; i4++) {
            MessageLiteToString.d(sb, i3, String.valueOf(WireFormat.a(this.f87140b[i4])), this.f87141c[i4]);
        }
    }

    void n(int i3, Object obj) {
        a();
        b(this.f87139a + 1);
        int[] iArr = this.f87140b;
        int i4 = this.f87139a;
        iArr[i4] = i3;
        this.f87141c[i4] = obj;
        this.f87139a = i4 + 1;
    }

    void p(Writer writer) {
        if (writer.t() == Writer.FieldOrder.DESCENDING) {
            for (int i3 = this.f87139a - 1; i3 >= 0; i3--) {
                writer.b(WireFormat.a(this.f87140b[i3]), this.f87141c[i3]);
            }
            return;
        }
        for (int i4 = 0; i4 < this.f87139a; i4++) {
            writer.b(WireFormat.a(this.f87140b[i4]), this.f87141c[i4]);
        }
    }

    public void r(Writer writer) {
        if (this.f87139a == 0) {
            return;
        }
        if (writer.t() == Writer.FieldOrder.ASCENDING) {
            for (int i3 = 0; i3 < this.f87139a; i3++) {
                q(this.f87140b[i3], this.f87141c[i3], writer);
            }
            return;
        }
        for (int i4 = this.f87139a - 1; i4 >= 0; i4--) {
            q(this.f87140b[i4], this.f87141c[i4], writer);
        }
    }

    private UnknownFieldSetLite(int i3, int[] iArr, Object[] objArr, boolean z2) {
        this.f87142d = -1;
        this.f87139a = i3;
        this.f87140b = iArr;
        this.f87141c = objArr;
        this.f87143e = z2;
    }
}
