package com.applovin.impl;

import com.applovin.impl.af;
import com.applovin.impl.e9;
import com.applovin.impl.ij;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class xb implements j8 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private l8 f64886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f64887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f64888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f64889e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private mf f64891g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private k8 f64892h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private dl f64893i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private of f64894j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ah f64885a = new ah(6);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f64890f = -1;

    private static mf a(String str, long j3) {
        lf lfVarA;
        if (j3 == -1 || (lfVarA = hs.a(str)) == null) {
            return null;
        }
        return lfVarA.a(j3);
    }

    private void b(k8 k8Var) {
        this.f64885a.d(2);
        k8Var.c(this.f64885a.c(), 0, 2);
        k8Var.c(this.f64885a.C() - 2);
    }

    private int c(k8 k8Var) {
        this.f64885a.d(2);
        k8Var.c(this.f64885a.c(), 0, 2);
        return this.f64885a.C();
    }

    private void d(k8 k8Var) {
        this.f64885a.d(2);
        k8Var.d(this.f64885a.c(), 0, 2);
        int iC = this.f64885a.C();
        this.f64888d = iC;
        if (iC == 65498) {
            if (this.f64890f != -1) {
                this.f64887c = 4;
                return;
            } else {
                b();
                return;
            }
        }
        if ((iC < 65488 || iC > 65497) && iC != 65281) {
            this.f64887c = 1;
        }
    }

    private void e(k8 k8Var) {
        String strT;
        if (this.f64888d == 65505) {
            ah ahVar = new ah(this.f64889e);
            k8Var.d(ahVar.c(), 0, this.f64889e);
            if (this.f64891g == null && "http://ns.adobe.com/xap/1.0/".equals(ahVar.t()) && (strT = ahVar.t()) != null) {
                mf mfVarA = a(strT, k8Var.a());
                this.f64891g = mfVarA;
                if (mfVarA != null) {
                    this.f64890f = mfVarA.f61893d;
                }
            }
        } else {
            k8Var.a(this.f64889e);
        }
        this.f64887c = 0;
    }

    private void f(k8 k8Var) {
        this.f64885a.d(2);
        k8Var.d(this.f64885a.c(), 0, 2);
        this.f64889e = this.f64885a.C() - 2;
        this.f64887c = 2;
    }

    private void g(k8 k8Var) {
        if (!k8Var.b(this.f64885a.c(), 0, 1, true)) {
            b();
            return;
        }
        k8Var.b();
        if (this.f64894j == null) {
            this.f64894j = new of();
        }
        dl dlVar = new dl(k8Var, this.f64890f);
        this.f64893i = dlVar;
        if (!this.f64894j.a(dlVar)) {
            b();
        } else {
            this.f64894j.a(new el(this.f64890f, (l8) b1.a(this.f64886b)));
            c();
        }
    }

    @Override // com.applovin.impl.j8
    public void a(l8 l8Var) {
        this.f64886b = l8Var;
    }

    private void a(af.b... bVarArr) {
        ((l8) b1.a(this.f64886b)).a(1024, 4).a(new e9.b().b("image/jpeg").a(new af(bVarArr)).a());
    }

    private void c() {
        a((af.b) b1.a(this.f64891g));
        this.f64887c = 5;
    }

    private void b() {
        a(new af.b[0]);
        ((l8) b1.a(this.f64886b)).c();
        this.f64886b.a(new ij.b(-9223372036854775807L));
        this.f64887c = 6;
    }

    @Override // com.applovin.impl.j8
    public int a(k8 k8Var, th thVar) {
        int i3 = this.f64887c;
        if (i3 == 0) {
            d(k8Var);
            return 0;
        }
        if (i3 == 1) {
            f(k8Var);
            return 0;
        }
        if (i3 == 2) {
            e(k8Var);
            return 0;
        }
        if (i3 == 4) {
            long jF = k8Var.f();
            long j3 = this.f64890f;
            if (jF != j3) {
                thVar.f63943a = j3;
                return 1;
            }
            g(k8Var);
            return 0;
        }
        if (i3 != 5) {
            if (i3 == 6) {
                return -1;
            }
            throw new IllegalStateException();
        }
        if (this.f64893i == null || k8Var != this.f64892h) {
            this.f64892h = k8Var;
            this.f64893i = new dl(k8Var, this.f64890f);
        }
        int iA = ((of) b1.a(this.f64894j)).a(this.f64893i, thVar);
        if (iA == 1) {
            thVar.f63943a += this.f64890f;
        }
        return iA;
    }

    @Override // com.applovin.impl.j8
    public void a() {
        of ofVar = this.f64894j;
        if (ofVar != null) {
            ofVar.a();
        }
    }

    @Override // com.applovin.impl.j8
    public void a(long j3, long j4) {
        if (j3 == 0) {
            this.f64887c = 0;
            this.f64894j = null;
        } else if (this.f64887c == 5) {
            ((of) b1.a(this.f64894j)).a(j3, j4);
        }
    }

    @Override // com.applovin.impl.j8
    public boolean a(k8 k8Var) {
        if (c(k8Var) != 65496) {
            return false;
        }
        int iC = c(k8Var);
        this.f64888d = iC;
        if (iC == 65504) {
            b(k8Var);
            this.f64888d = c(k8Var);
        }
        if (this.f64888d != 65505) {
            return false;
        }
        k8Var.c(2);
        this.f64885a.d(6);
        k8Var.c(this.f64885a.c(), 0, 6);
        return this.f64885a.y() == 1165519206 && this.f64885a.C() == 0;
    }
}
