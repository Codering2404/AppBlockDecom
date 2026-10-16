package com.applovin.impl;

import com.applovin.impl.a;
import com.applovin.impl.dp;
import com.applovin.impl.e9;
import com.sun.jna.Function;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class k0 implements p7 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final byte[] f60842v = {73, 68, 51};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f60843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zg f60844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ah f60845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f60846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f60847e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private qo f60848f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private qo f60849g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f60850h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f60851i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f60852j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f60853k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f60854l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f60855m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f60856n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f60857o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f60858p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f60859q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f60860r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f60861s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private qo f60862t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f60863u;

    public k0(boolean z2) {
        this(z2, null);
    }

    public static boolean a(int i3) {
        return (i3 & 65526) == 65520;
    }

    private void c() {
        b1.a(this.f60848f);
        xp.a(this.f60862t);
        xp.a(this.f60849g);
    }

    private void e() {
        this.f60844b.c(0);
        if (this.f60858p) {
            this.f60844b.d(10);
        } else {
            int i3 = 2;
            int iA = this.f60844b.a(2) + 1;
            if (iA != 2) {
                oc.d("AdtsReader", "Detected audio object type: " + iA + ", but assuming AAC LC.");
            } else {
                i3 = iA;
            }
            this.f60844b.d(5);
            byte[] bArrA = a.a(i3, this.f60856n, this.f60844b.a(3));
            a.b bVarA = a.a(bArrA);
            e9 e9VarA = new e9.b().c(this.f60847e).f("audio/mp4a-latm").a(bVarA.f58135c).c(bVarA.f58134b).n(bVarA.f58133a).a(Collections.singletonList(bArrA)).e(this.f60846d).a();
            this.f60859q = 1024000000 / ((long) e9VarA.A);
            this.f60848f.a(e9VarA);
            this.f60858p = true;
        }
        this.f60844b.d(4);
        int iA2 = this.f60844b.a(13);
        int i4 = iA2 - 7;
        if (this.f60853k) {
            i4 = iA2 - 9;
        }
        a(this.f60848f, this.f60859q, 0, i4);
    }

    private void f() {
        this.f60849g.a(this.f60845c, 10);
        this.f60845c.f(6);
        a(this.f60849g, 0L, 10, this.f60845c.v() + 10);
    }

    private void g() {
        this.f60854l = false;
        i();
    }

    private void h() {
        this.f60850h = 1;
        this.f60851i = 0;
    }

    private void i() {
        this.f60850h = 0;
        this.f60851i = 0;
        this.f60852j = Function.MAX_NARGS;
    }

    private void j() {
        this.f60850h = 3;
        this.f60851i = 0;
    }

    private void k() {
        this.f60850h = 2;
        this.f60851i = f60842v.length;
        this.f60860r = 0;
        this.f60845c.f(0);
    }

    @Override // com.applovin.impl.p7
    public void b() {
    }

    public long d() {
        return this.f60859q;
    }

    public k0(boolean z2, String str) {
        this.f60844b = new zg(new byte[7]);
        this.f60845c = new ah(Arrays.copyOf(f60842v, 10));
        i();
        this.f60855m = -1;
        this.f60856n = -1;
        this.f60859q = -9223372036854775807L;
        this.f60861s = -9223372036854775807L;
        this.f60843a = z2;
        this.f60846d = str;
    }

    private boolean a(ah ahVar, int i3) {
        ahVar.f(i3 + 1);
        if (!b(ahVar, this.f60844b.f65436a, 1)) {
            return false;
        }
        this.f60844b.c(4);
        int iA = this.f60844b.a(1);
        int i4 = this.f60855m;
        if (i4 != -1 && iA != i4) {
            return false;
        }
        if (this.f60856n != -1) {
            if (!b(ahVar, this.f60844b.f65436a, 1)) {
                return true;
            }
            this.f60844b.c(2);
            if (this.f60844b.a(4) != this.f60856n) {
                return false;
            }
            ahVar.f(i3 + 2);
        }
        if (!b(ahVar, this.f60844b.f65436a, 4)) {
            return true;
        }
        this.f60844b.c(14);
        int iA2 = this.f60844b.a(13);
        if (iA2 < 7) {
            return false;
        }
        byte[] bArrC = ahVar.c();
        int iE = ahVar.e();
        int i5 = i3 + iA2;
        if (i5 >= iE) {
            return true;
        }
        byte b3 = bArrC[i5];
        if (b3 == -1) {
            int i6 = i5 + 1;
            if (i6 == iE) {
                return true;
            }
            return a((byte) -1, bArrC[i6]) && ((bArrC[i6] & 8) >> 3) == iA;
        }
        if (b3 != 73) {
            return false;
        }
        int i7 = i5 + 1;
        if (i7 == iE) {
            return true;
        }
        if (bArrC[i7] != 68) {
            return false;
        }
        int i8 = i5 + 2;
        return i8 == iE || bArrC[i8] == 51;
    }

    private void b(ah ahVar) {
        if (ahVar.a() == 0) {
            return;
        }
        this.f60844b.f65436a[0] = ahVar.c()[ahVar.d()];
        this.f60844b.c(2);
        int iA = this.f60844b.a(4);
        int i3 = this.f60856n;
        if (i3 != -1 && iA != i3) {
            g();
            return;
        }
        if (!this.f60854l) {
            this.f60854l = true;
            this.f60855m = this.f60857o;
            this.f60856n = iA;
        }
        j();
    }

    private void d(ah ahVar) {
        int iMin = Math.min(ahVar.a(), this.f60860r - this.f60851i);
        this.f60862t.a(ahVar, iMin);
        int i3 = this.f60851i + iMin;
        this.f60851i = i3;
        int i4 = this.f60860r;
        if (i3 == i4) {
            long j3 = this.f60861s;
            if (j3 != -9223372036854775807L) {
                this.f60862t.a(j3, 1, i4, 0, null);
                this.f60861s += this.f60863u;
            }
            i();
        }
    }

    private void c(ah ahVar) {
        byte[] bArrC = ahVar.c();
        int iD = ahVar.d();
        int iE = ahVar.e();
        while (iD < iE) {
            int i3 = iD + 1;
            byte b3 = bArrC[iD];
            int i4 = b3 & 255;
            if (this.f60852j == 512 && a((byte) -1, (byte) i4) && (this.f60854l || a(ahVar, iD - 1))) {
                this.f60857o = (b3 & 8) >> 3;
                this.f60853k = (b3 & 1) == 0;
                if (!this.f60854l) {
                    h();
                } else {
                    j();
                }
                ahVar.f(i3);
                return;
            }
            int i5 = this.f60852j;
            int i6 = i4 | i5;
            if (i6 == 329) {
                this.f60852j = 768;
            } else if (i6 == 511) {
                this.f60852j = 512;
            } else if (i6 == 836) {
                this.f60852j = 1024;
            } else if (i6 == 1075) {
                k();
                ahVar.f(i3);
                return;
            } else if (i5 != 256) {
                this.f60852j = Function.MAX_NARGS;
            }
            iD = i3;
        }
        ahVar.f(iD);
    }

    private boolean b(ah ahVar, byte[] bArr, int i3) {
        if (ahVar.a() < i3) {
            return false;
        }
        ahVar.a(bArr, 0, i3);
        return true;
    }

    @Override // com.applovin.impl.p7
    public void a(ah ahVar) {
        c();
        while (ahVar.a() > 0) {
            int i3 = this.f60850h;
            if (i3 == 0) {
                c(ahVar);
            } else if (i3 == 1) {
                b(ahVar);
            } else if (i3 != 2) {
                if (i3 == 3) {
                    if (a(ahVar, this.f60844b.f65436a, this.f60853k ? 7 : 5)) {
                        e();
                    }
                } else if (i3 == 4) {
                    d(ahVar);
                } else {
                    throw new IllegalStateException();
                }
            } else if (a(ahVar, this.f60845c.c(), 10)) {
                f();
            }
        }
    }

    private boolean a(ah ahVar, byte[] bArr, int i3) {
        int iMin = Math.min(ahVar.a(), i3 - this.f60851i);
        ahVar.a(bArr, this.f60851i, iMin);
        int i4 = this.f60851i + iMin;
        this.f60851i = i4;
        return i4 == i3;
    }

    @Override // com.applovin.impl.p7
    public void a(l8 l8Var, dp.d dVar) {
        dVar.a();
        this.f60847e = dVar.b();
        qo qoVarA = l8Var.a(dVar.c(), 1);
        this.f60848f = qoVarA;
        this.f60862t = qoVarA;
        if (this.f60843a) {
            dVar.a();
            qo qoVarA2 = l8Var.a(dVar.c(), 5);
            this.f60849g = qoVarA2;
            qoVarA2.a(new e9.b().c(dVar.b()).f("application/id3").a());
            return;
        }
        this.f60849g = new h7();
    }

    private boolean a(byte b3, byte b4) {
        return a(((b3 & 255) << 8) | (b4 & 255));
    }

    @Override // com.applovin.impl.p7
    public void a(long j3, int i3) {
        if (j3 != -9223372036854775807L) {
            this.f60861s = j3;
        }
    }

    @Override // com.applovin.impl.p7
    public void a() {
        this.f60861s = -9223372036854775807L;
        g();
    }

    private void a(qo qoVar, long j3, int i3, int i4) {
        this.f60850h = 4;
        this.f60851i = i3;
        this.f60862t = qoVar;
        this.f60863u = j3;
        this.f60860r = i4;
    }
}
