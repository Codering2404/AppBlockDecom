package com.google.android.libraries.places.internal;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbfz {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final zzbfz f76171f = new zzbfz(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f76172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f76173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object[] f76174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f76175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f76176e;

    private zzbfz(int i3, int[] iArr, Object[] objArr, boolean z2) {
        this.f76175d = -1;
        this.f76172a = i3;
        this.f76173b = iArr;
        this.f76174c = objArr;
        this.f76176e = z2;
    }

    public static zzbfz a() {
        return f76171f;
    }

    static zzbfz b() {
        return new zzbfz(0, new int[8], new Object[8], true);
    }

    static zzbfz c(zzbfz zzbfzVar, zzbfz zzbfzVar2) {
        int i3 = zzbfzVar.f76172a + zzbfzVar2.f76172a;
        int[] iArrCopyOf = Arrays.copyOf(zzbfzVar.f76173b, i3);
        System.arraycopy(zzbfzVar2.f76173b, 0, iArrCopyOf, zzbfzVar.f76172a, zzbfzVar2.f76172a);
        Object[] objArrCopyOf = Arrays.copyOf(zzbfzVar.f76174c, i3);
        System.arraycopy(zzbfzVar2.f76174c, 0, objArrCopyOf, zzbfzVar.f76172a, zzbfzVar2.f76172a);
        return new zzbfz(i3, iArrCopyOf, objArrCopyOf, true);
    }

    private final void m(int i3) {
        int[] iArr = this.f76173b;
        if (i3 > iArr.length) {
            int i4 = this.f76172a;
            int i5 = i4 + (i4 / 2);
            if (i5 >= i3) {
                i3 = i5;
            }
            if (i3 < 8) {
                i3 = 8;
            }
            this.f76173b = Arrays.copyOf(iArr, i3);
            this.f76174c = Arrays.copyOf(this.f76174c, i3);
        }
    }

    public final void d() {
        if (this.f76176e) {
            this.f76176e = false;
        }
    }

    final void e() {
        if (!this.f76176e) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzbfz)) {
            return false;
        }
        zzbfz zzbfzVar = (zzbfz) obj;
        int i3 = this.f76172a;
        if (i3 == zzbfzVar.f76172a) {
            int[] iArr = this.f76173b;
            int[] iArr2 = zzbfzVar.f76173b;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    Object[] objArr = this.f76174c;
                    Object[] objArr2 = zzbfzVar.f76174c;
                    int i5 = this.f76172a;
                    for (int i6 = 0; i6 < i5; i6++) {
                        if (objArr[i6].equals(objArr2[i6])) {
                        }
                    }
                    return true;
                }
                if (iArr[i4] != iArr2[i4]) {
                    break;
                }
                i4++;
            }
        }
        return false;
    }

    final void f(zzbgl zzbglVar) {
        for (int i3 = 0; i3 < this.f76172a; i3++) {
            zzbglVar.zzv(this.f76173b[i3] >>> 3, this.f76174c[i3]);
        }
    }

    public final void g(zzbgl zzbglVar) {
        if (this.f76172a != 0) {
            for (int i3 = 0; i3 < this.f76172a; i3++) {
                int i4 = this.f76173b[i3];
                Object obj = this.f76174c[i3];
                int i5 = i4 & 7;
                int i6 = i4 >>> 3;
                if (i5 == 0) {
                    zzbglVar.zzc(i6, ((Long) obj).longValue());
                } else if (i5 == 1) {
                    zzbglVar.zzj(i6, ((Long) obj).longValue());
                } else if (i5 == 2) {
                    zzbglVar.a(i6, (zzbcl) obj);
                } else if (i5 == 3) {
                    zzbglVar.zzt(i6);
                    ((zzbfz) obj).g(zzbglVar);
                    zzbglVar.zzu(i6);
                } else {
                    if (i5 != 5) {
                        throw new RuntimeException(new zzbec("Protocol message tag had invalid wire type."));
                    }
                    zzbglVar.zzk(i6, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final int h() {
        int i3 = this.f76175d;
        if (i3 != -1) {
            return i3;
        }
        int iB = 0;
        for (int i4 = 0; i4 < this.f76172a; i4++) {
            int i5 = this.f76173b[i4] >>> 3;
            zzbcl zzbclVar = (zzbcl) this.f76174c[i4];
            int iB2 = zzbcu.B(8);
            int iB3 = zzbcu.B(16) + zzbcu.B(i5);
            int iB4 = zzbcu.B(24);
            int iD = zzbclVar.d();
            iB += iB2 + iB2 + iB3 + iB4 + zzbcu.B(iD) + iD;
        }
        this.f76175d = iB;
        return iB;
    }

    public final int hashCode() {
        int i3 = this.f76172a;
        int i4 = i3 + 527;
        int[] iArr = this.f76173b;
        int iHashCode = 17;
        int i5 = 17;
        for (int i6 = 0; i6 < i3; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        int i7 = ((i4 * 31) + i5) * 31;
        Object[] objArr = this.f76174c;
        int i8 = this.f76172a;
        for (int i9 = 0; i9 < i8; i9++) {
            iHashCode = (iHashCode * 31) + objArr[i9].hashCode();
        }
        return i7 + iHashCode;
    }

    public final int i() {
        int iB;
        int iC;
        int iB2;
        int i3 = this.f76175d;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.f76172a; i5++) {
            int i6 = this.f76173b[i5];
            int i7 = i6 >>> 3;
            int i8 = i6 & 7;
            if (i8 != 0) {
                if (i8 == 1) {
                    ((Long) this.f76174c[i5]).getClass();
                    iB2 = zzbcu.B(i7 << 3) + 8;
                } else if (i8 == 2) {
                    int i9 = i7 << 3;
                    zzbcl zzbclVar = (zzbcl) this.f76174c[i5];
                    int iB3 = zzbcu.B(i9);
                    int iD = zzbclVar.d();
                    iB2 = iB3 + zzbcu.B(iD) + iD;
                } else if (i8 == 3) {
                    int iB4 = zzbcu.B(i7 << 3);
                    iB = iB4 + iB4;
                    iC = ((zzbfz) this.f76174c[i5]).i();
                } else {
                    if (i8 != 5) {
                        throw new IllegalStateException(new zzbec("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.f76174c[i5]).getClass();
                    iB2 = zzbcu.B(i7 << 3) + 4;
                }
                i4 += iB2;
            } else {
                int i10 = i7 << 3;
                long jLongValue = ((Long) this.f76174c[i5]).longValue();
                iB = zzbcu.B(i10);
                iC = zzbcu.C(jLongValue);
            }
            iB2 = iB + iC;
            i4 += iB2;
        }
        this.f76175d = i4;
        return i4;
    }

    final void j(StringBuilder sb, int i3) {
        for (int i4 = 0; i4 < this.f76172a; i4++) {
            zzbez.b(sb, i3, String.valueOf(this.f76173b[i4] >>> 3), this.f76174c[i4]);
        }
    }

    final void k(int i3, Object obj) {
        e();
        m(this.f76172a + 1);
        int[] iArr = this.f76173b;
        int i4 = this.f76172a;
        iArr[i4] = i3;
        this.f76174c[i4] = obj;
        this.f76172a = i4 + 1;
    }

    final zzbfz l(zzbfz zzbfzVar) {
        if (zzbfzVar.equals(f76171f)) {
            return this;
        }
        e();
        int i3 = this.f76172a + zzbfzVar.f76172a;
        m(i3);
        System.arraycopy(zzbfzVar.f76173b, 0, this.f76173b, this.f76172a, zzbfzVar.f76172a);
        System.arraycopy(zzbfzVar.f76174c, 0, this.f76174c, this.f76172a, zzbfzVar.f76172a);
        this.f76172a = i3;
        return this;
    }

    private zzbfz() {
        this(0, new int[8], new Object[8], true);
    }
}
