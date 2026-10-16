package com.applovin.impl;

import com.applovin.impl.ij;
import com.applovin.impl.v8;
import com.applovin.impl.w8;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class u8 implements j8 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final n8 f64119o = new n8() { // from class: com.applovin.impl.d60
        @Override // com.applovin.impl.n8
        public final j8[] a() {
            return u8.b();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f64120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ah f64121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f64122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final v8.a f64123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private l8 f64124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private qo f64125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f64126g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private af f64127h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private z8 f64128i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f64129j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f64130k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private t8 f64131l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f64132m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f64133n;

    public u8() {
        this(0);
    }

    private void b(k8 k8Var) {
        this.f64130k = w8.b(k8Var);
        ((l8) xp.a(this.f64124e)).a(b(k8Var.f(), k8Var.a()));
        this.f64126g = 5;
    }

    private void c(k8 k8Var) {
        byte[] bArr = this.f64120a;
        k8Var.c(bArr, 0, bArr.length);
        k8Var.b();
        this.f64126g = 2;
    }

    private void e(k8 k8Var) {
        w8.a aVar = new w8.a(this.f64128i);
        boolean zA = false;
        while (!zA) {
            zA = w8.a(k8Var, aVar);
            this.f64128i = (z8) xp.a(aVar.f64614a);
        }
        b1.a(this.f64128i);
        this.f64129j = Math.max(this.f64128i.f65390c, 6);
        ((qo) xp.a(this.f64125f)).a(this.f64128i.a(this.f64120a, this.f64127h));
        this.f64126g = 4;
    }

    private void f(k8 k8Var) throws ch {
        w8.d(k8Var);
        this.f64126g = 3;
    }

    @Override // com.applovin.impl.j8
    public void a() {
    }

    public u8(int i3) {
        this.f64120a = new byte[42];
        this.f64121b = new ah(new byte[32768], 0);
        this.f64122c = (i3 & 1) != 0;
        this.f64123d = new v8.a();
        this.f64126g = 0;
    }

    private long a(ah ahVar, boolean z2) {
        boolean zA;
        b1.a(this.f64128i);
        int iD = ahVar.d();
        while (iD <= ahVar.e() - 16) {
            ahVar.f(iD);
            if (v8.a(ahVar, this.f64128i, this.f64130k, this.f64123d)) {
                ahVar.f(iD);
                return this.f64123d.f64409a;
            }
            iD++;
        }
        if (!z2) {
            ahVar.f(iD);
            return -1L;
        }
        while (iD <= ahVar.e() - this.f64129j) {
            ahVar.f(iD);
            try {
                zA = v8.a(ahVar, this.f64128i, this.f64130k, this.f64123d);
            } catch (IndexOutOfBoundsException unused) {
                zA = false;
            }
            if (ahVar.d() <= ahVar.e() && zA) {
                ahVar.f(iD);
                return this.f64123d.f64409a;
            }
            iD++;
        }
        ahVar.f(ahVar.e());
        return -1L;
    }

    private void d(k8 k8Var) {
        this.f64127h = w8.b(k8Var, !this.f64122c);
        this.f64126g = 1;
    }

    private void c() {
        ((qo) xp.a(this.f64125f)).a((this.f64133n * 1000000) / ((long) ((z8) xp.a(this.f64128i)).f65392e), 1, this.f64132m, 0, null);
    }

    private ij b(long j3, long j4) {
        b1.a(this.f64128i);
        z8 z8Var = this.f64128i;
        if (z8Var.f65398k != null) {
            return new y8(z8Var, j3);
        }
        if (j4 != -1 && z8Var.f65397j > 0) {
            t8 t8Var = new t8(z8Var, this.f64130k, j3, j4);
            this.f64131l = t8Var;
            return t8Var.a();
        }
        return new ij.b(z8Var.b());
    }

    private int b(k8 k8Var, th thVar) {
        boolean z2;
        b1.a(this.f64125f);
        b1.a(this.f64128i);
        t8 t8Var = this.f64131l;
        if (t8Var != null && t8Var.b()) {
            return this.f64131l.a(k8Var, thVar);
        }
        if (this.f64133n == -1) {
            this.f64133n = v8.a(k8Var, this.f64128i);
            return 0;
        }
        int iE = this.f64121b.e();
        if (iE < 32768) {
            int iA = k8Var.a(this.f64121b.c(), iE, 32768 - iE);
            z2 = iA == -1;
            if (!z2) {
                this.f64121b.e(iE + iA);
            } else if (this.f64121b.a() == 0) {
                c();
                return -1;
            }
        } else {
            z2 = false;
        }
        int iD = this.f64121b.d();
        int i3 = this.f64132m;
        int i4 = this.f64129j;
        if (i3 < i4) {
            ah ahVar = this.f64121b;
            ahVar.g(Math.min(i4 - i3, ahVar.a()));
        }
        long jA = a(this.f64121b, z2);
        int iD2 = this.f64121b.d() - iD;
        this.f64121b.f(iD);
        this.f64125f.a(this.f64121b, iD2);
        this.f64132m += iD2;
        if (jA != -1) {
            c();
            this.f64132m = 0;
            this.f64133n = jA;
        }
        if (this.f64121b.a() < 16) {
            int iA2 = this.f64121b.a();
            System.arraycopy(this.f64121b.c(), this.f64121b.d(), this.f64121b.c(), 0, iA2);
            this.f64121b.f(0);
            this.f64121b.e(iA2);
        }
        return 0;
    }

    @Override // com.applovin.impl.j8
    public void a(l8 l8Var) {
        this.f64124e = l8Var;
        this.f64125f = l8Var.a(0, 1);
        l8Var.c();
    }

    @Override // com.applovin.impl.j8
    public int a(k8 k8Var, th thVar) throws ch {
        int i3 = this.f64126g;
        if (i3 == 0) {
            d(k8Var);
            return 0;
        }
        if (i3 == 1) {
            c(k8Var);
            return 0;
        }
        if (i3 == 2) {
            f(k8Var);
            return 0;
        }
        if (i3 == 3) {
            e(k8Var);
            return 0;
        }
        if (i3 == 4) {
            b(k8Var);
            return 0;
        }
        if (i3 == 5) {
            return b(k8Var, thVar);
        }
        throw new IllegalStateException();
    }

    @Override // com.applovin.impl.j8
    public void a(long j3, long j4) {
        if (j3 == 0) {
            this.f64126g = 0;
        } else {
            t8 t8Var = this.f64131l;
            if (t8Var != null) {
                t8Var.b(j4);
            }
        }
        this.f64133n = j4 != 0 ? -1L : 0L;
        this.f64132m = 0;
        this.f64121b.d(0);
    }

    @Override // com.applovin.impl.j8
    public boolean a(k8 k8Var) throws Throwable {
        w8.a(k8Var, false);
        return w8.a(k8Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ j8[] b() {
        return new j8[]{new u8()};
    }
}
