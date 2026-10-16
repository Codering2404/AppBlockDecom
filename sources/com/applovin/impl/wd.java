package com.applovin.impl;

import com.applovin.impl.ae;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class wd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vd f64641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f64642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final cj[] f64643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f64644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f64645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public yd f64646f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f64647g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean[] f64648h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ri[] f64649i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final vo f64650j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ee f64651k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private wd f64652l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private po f64653m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private wo f64654n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f64655o;

    public wd(ri[] riVarArr, long j3, vo voVar, n0 n0Var, ee eeVar, yd ydVar, wo woVar) {
        this.f64649i = riVarArr;
        this.f64655o = j3;
        this.f64650j = voVar;
        this.f64651k = eeVar;
        ae.a aVar = ydVar.f65182a;
        this.f64642b = aVar.f64962a;
        this.f64646f = ydVar;
        this.f64653m = po.f62471d;
        this.f64654n = woVar;
        this.f64643c = new cj[riVarArr.length];
        this.f64648h = new boolean[riVarArr.length];
        this.f64641a = a(aVar, eeVar, n0Var, ydVar.f65183b, ydVar.f65185d);
    }

    private void b(cj[] cjVarArr) {
        int i3 = 0;
        while (true) {
            ri[] riVarArr = this.f64649i;
            if (i3 >= riVarArr.length) {
                return;
            }
            if (riVarArr[i3].e() == -2) {
                cjVarArr[i3] = null;
            }
            i3++;
        }
    }

    private boolean k() {
        return this.f64652l == null;
    }

    public long a(wo woVar, long j3, boolean z2) {
        return a(woVar, j3, z2, new boolean[this.f64649i.length]);
    }

    public long c() {
        if (!this.f64644d) {
            return this.f64646f.f65183b;
        }
        long jE = this.f64645e ? this.f64641a.e() : Long.MIN_VALUE;
        return jE == Long.MIN_VALUE ? this.f64646f.f65186e : jE;
    }

    public wd d() {
        return this.f64652l;
    }

    public long e() {
        if (this.f64644d) {
            return this.f64641a.g();
        }
        return 0L;
    }

    public long f() {
        return this.f64655o;
    }

    public long g() {
        return this.f64646f.f65183b + this.f64655o;
    }

    public po h() {
        return this.f64653m;
    }

    public wo i() {
        return this.f64654n;
    }

    public boolean j() {
        if (this.f64644d) {
            return !this.f64645e || this.f64641a.e() == Long.MIN_VALUE;
        }
        return false;
    }

    public void l() {
        a();
        a(this.f64651k, this.f64641a);
    }

    public void m() {
        vd vdVar = this.f64641a;
        if (vdVar instanceof k3) {
            long j3 = this.f64646f.f65185d;
            if (j3 == -9223372036854775807L) {
                j3 = Long.MIN_VALUE;
            }
            ((k3) vdVar).a(0L, j3);
        }
    }

    public long a(wo woVar, long j3, boolean z2, boolean[] zArr) {
        int i3 = 0;
        while (true) {
            boolean z3 = true;
            if (i3 >= woVar.f64723a) {
                break;
            }
            boolean[] zArr2 = this.f64648h;
            if (z2 || !woVar.a(this.f64654n, i3)) {
                z3 = false;
            }
            zArr2[i3] = z3;
            i3++;
        }
        b(this.f64643c);
        a();
        this.f64654n = woVar;
        b();
        long jA = this.f64641a.a(woVar.f64725c, this.f64648h, this.f64643c, zArr, j3);
        a(this.f64643c);
        this.f64645e = false;
        int i4 = 0;
        while (true) {
            cj[] cjVarArr = this.f64643c;
            if (i4 >= cjVarArr.length) {
                return jA;
            }
            if (cjVarArr[i4] != null) {
                b1.b(woVar.a(i4));
                if (this.f64649i[i4].e() != -2) {
                    this.f64645e = true;
                }
            } else {
                b1.b(woVar.f64725c[i4] == null);
            }
            i4++;
        }
    }

    public long d(long j3) {
        return j3 - f();
    }

    public long e(long j3) {
        return j3 + f();
    }

    private void b() {
        if (!k()) {
            return;
        }
        int i3 = 0;
        while (true) {
            wo woVar = this.f64654n;
            if (i3 >= woVar.f64723a) {
                return;
            }
            boolean zA = woVar.a(i3);
            g8 g8Var = this.f64654n.f64725c[i3];
            if (zA && g8Var != null) {
                g8Var.i();
            }
            i3++;
        }
    }

    public void c(long j3) {
        this.f64655o = j3;
    }

    public void b(long j3) {
        b1.b(k());
        if (this.f64644d) {
            this.f64641a.c(d(j3));
        }
    }

    public wo b(float f3, fo foVar) {
        wo woVarA = this.f64650j.a(this.f64649i, h(), this.f64646f.f65182a, foVar);
        for (g8 g8Var : woVarA.f64725c) {
            if (g8Var != null) {
                g8Var.a(f3);
            }
        }
        return woVarA;
    }

    private void a(cj[] cjVarArr) {
        int i3 = 0;
        while (true) {
            ri[] riVarArr = this.f64649i;
            if (i3 >= riVarArr.length) {
                return;
            }
            if (riVarArr[i3].e() == -2 && this.f64654n.a(i3)) {
                cjVarArr[i3] = new r7();
            }
            i3++;
        }
    }

    public void a(long j3) {
        b1.b(k());
        this.f64641a.b(d(j3));
    }

    private static vd a(ae.a aVar, ee eeVar, n0 n0Var, long j3, long j4) {
        vd vdVarA = eeVar.a(aVar, n0Var, j3);
        return j4 != -9223372036854775807L ? new k3(vdVarA, true, 0L, j4) : vdVarA;
    }

    private void a() {
        if (!k()) {
            return;
        }
        int i3 = 0;
        while (true) {
            wo woVar = this.f64654n;
            if (i3 >= woVar.f64723a) {
                return;
            }
            boolean zA = woVar.a(i3);
            g8 g8Var = this.f64654n.f64725c[i3];
            if (zA && g8Var != null) {
                g8Var.f();
            }
            i3++;
        }
    }

    public void a(float f3, fo foVar) {
        this.f64644d = true;
        this.f64653m = this.f64641a.b();
        wo woVarB = b(f3, foVar);
        yd ydVar = this.f64646f;
        long jMax = ydVar.f65183b;
        long j3 = ydVar.f65186e;
        if (j3 != -9223372036854775807L && jMax >= j3) {
            jMax = Math.max(0L, j3 - 1);
        }
        long jA = a(woVarB, jMax, false);
        long j4 = this.f64655o;
        yd ydVar2 = this.f64646f;
        this.f64655o = j4 + (ydVar2.f65183b - jA);
        this.f64646f = ydVar2.b(jA);
    }

    private static void a(ee eeVar, vd vdVar) {
        try {
            if (vdVar instanceof k3) {
                eeVar.a(((k3) vdVar).f60894a);
            } else {
                eeVar.a(vdVar);
            }
        } catch (RuntimeException e3) {
            oc.a("MediaPeriodHolder", "Period release failed.", e3);
        }
    }

    public void a(wd wdVar) {
        if (wdVar == this.f64652l) {
            return;
        }
        a();
        this.f64652l = wdVar;
        b();
    }
}
