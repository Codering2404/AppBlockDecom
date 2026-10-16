package com.applovin.impl;

import com.applovin.impl.ij;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class d9 implements j8 {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final n8 f59176q = new n8() { // from class: com.applovin.impl.ru
        @Override // com.applovin.impl.n8
        public final j8[] a() {
            return d9.d();
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private l8 f59182f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f59184h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f59185i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f59186j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f59187k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f59188l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f59189m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f59190n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private s1 f59191o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private yq f59192p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ah f59177a = new ah(4);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ah f59178b = new ah(9);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ah f59179c = new ah(11);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ah f59180d = new ah();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ej f59181e = new ej();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f59183g = 1;

    private void b() {
        if (this.f59190n) {
            return;
        }
        this.f59182f.a(new ij.b(-9223372036854775807L));
        this.f59190n = true;
    }

    private long c() {
        if (this.f59184h) {
            return this.f59185i + this.f59189m;
        }
        if (this.f59181e.a() == -9223372036854775807L) {
            return 0L;
        }
        return this.f59189m;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean d(com.applovin.impl.k8 r10) {
        /*
            r9 = this;
            long r0 = r9.c()
            int r2 = r9.f59187k
            r3 = 8
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = 1
            if (r2 != r3) goto L23
            com.applovin.impl.s1 r3 = r9.f59191o
            if (r3 == 0) goto L23
            r9.b()
            com.applovin.impl.s1 r2 = r9.f59191o
            com.applovin.impl.ah r10 = r9.b(r10)
            boolean r10 = r2.a(r10, r0)
        L21:
            r0 = r6
            goto L75
        L23:
            r3 = 9
            if (r2 != r3) goto L39
            com.applovin.impl.yq r3 = r9.f59192p
            if (r3 == 0) goto L39
            r9.b()
            com.applovin.impl.yq r2 = r9.f59192p
            com.applovin.impl.ah r10 = r9.b(r10)
            boolean r10 = r2.a(r10, r0)
            goto L21
        L39:
            r3 = 18
            if (r2 != r3) goto L6e
            boolean r2 = r9.f59190n
            if (r2 != 0) goto L6e
            com.applovin.impl.ej r2 = r9.f59181e
            com.applovin.impl.ah r10 = r9.b(r10)
            boolean r10 = r2.a(r10, r0)
            com.applovin.impl.ej r0 = r9.f59181e
            long r0 = r0.a()
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 == 0) goto L21
            com.applovin.impl.l8 r2 = r9.f59182f
            com.applovin.impl.lb r3 = new com.applovin.impl.lb
            com.applovin.impl.ej r7 = r9.f59181e
            long[] r7 = r7.b()
            com.applovin.impl.ej r8 = r9.f59181e
            long[] r8 = r8.c()
            r3.<init>(r7, r8, r0)
            r2.a(r3)
            r9.f59190n = r6
            goto L21
        L6e:
            int r0 = r9.f59188l
            r10.a(r0)
            r10 = 0
            r0 = r10
        L75:
            boolean r1 = r9.f59184h
            if (r1 != 0) goto L8f
            if (r10 == 0) goto L8f
            r9.f59184h = r6
            com.applovin.impl.ej r10 = r9.f59181e
            long r1 = r10.a()
            int r10 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r10 != 0) goto L8b
            long r1 = r9.f59189m
            long r1 = -r1
            goto L8d
        L8b:
            r1 = 0
        L8d:
            r9.f59185i = r1
        L8f:
            r10 = 4
            r9.f59186j = r10
            r10 = 2
            r9.f59183g = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.d9.d(com.applovin.impl.k8):boolean");
    }

    private void f(k8 k8Var) {
        k8Var.a(this.f59186j);
        this.f59186j = 0;
        this.f59183g = 3;
    }

    @Override // com.applovin.impl.j8
    public void a() {
    }

    private boolean e(k8 k8Var) {
        if (!k8Var.a(this.f59179c.c(), 0, 11, true)) {
            return false;
        }
        this.f59179c.f(0);
        this.f59187k = this.f59179c.w();
        this.f59188l = this.f59179c.z();
        this.f59189m = this.f59179c.z();
        this.f59189m = (((long) (this.f59179c.w() << 24)) | this.f59189m) * 1000;
        this.f59179c.g(3);
        this.f59183g = 4;
        return true;
    }

    @Override // com.applovin.impl.j8
    public void a(l8 l8Var) {
        this.f59182f = l8Var;
    }

    @Override // com.applovin.impl.j8
    public int a(k8 k8Var, th thVar) {
        b1.b(this.f59182f);
        while (true) {
            int i3 = this.f59183g;
            if (i3 != 1) {
                if (i3 == 2) {
                    f(k8Var);
                } else if (i3 != 3) {
                    if (i3 == 4) {
                        if (d(k8Var)) {
                            return 0;
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (!e(k8Var)) {
                    return -1;
                }
            } else if (!c(k8Var)) {
                return -1;
            }
        }
    }

    private ah b(k8 k8Var) {
        if (this.f59188l > this.f59180d.b()) {
            ah ahVar = this.f59180d;
            ahVar.a(new byte[Math.max(ahVar.b() * 2, this.f59188l)], 0);
        } else {
            this.f59180d.f(0);
        }
        this.f59180d.e(this.f59188l);
        k8Var.d(this.f59180d.c(), 0, this.f59188l);
        return this.f59180d;
    }

    private boolean c(k8 k8Var) {
        if (!k8Var.a(this.f59178b.c(), 0, 9, true)) {
            return false;
        }
        this.f59178b.f(0);
        this.f59178b.g(4);
        int iW = this.f59178b.w();
        boolean z2 = (iW & 4) != 0;
        boolean z3 = (iW & 1) != 0;
        if (z2 && this.f59191o == null) {
            this.f59191o = new s1(this.f59182f.a(8, 1));
        }
        if (z3 && this.f59192p == null) {
            this.f59192p = new yq(this.f59182f.a(9, 2));
        }
        this.f59182f.c();
        this.f59186j = this.f59178b.j() - 5;
        this.f59183g = 2;
        return true;
    }

    @Override // com.applovin.impl.j8
    public void a(long j3, long j4) {
        if (j3 == 0) {
            this.f59183g = 1;
            this.f59184h = false;
        } else {
            this.f59183g = 3;
        }
        this.f59186j = 0;
    }

    @Override // com.applovin.impl.j8
    public boolean a(k8 k8Var) {
        k8Var.c(this.f59177a.c(), 0, 3);
        this.f59177a.f(0);
        if (this.f59177a.z() != 4607062) {
            return false;
        }
        k8Var.c(this.f59177a.c(), 0, 2);
        this.f59177a.f(0);
        if ((this.f59177a.C() & 250) != 0) {
            return false;
        }
        k8Var.c(this.f59177a.c(), 0, 4);
        this.f59177a.f(0);
        int iJ = this.f59177a.j();
        k8Var.b();
        k8Var.c(iJ);
        k8Var.c(this.f59177a.c(), 0, 4);
        this.f59177a.f(0);
        return this.f59177a.j() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ j8[] d() {
        return new j8[]{new d9()};
    }
}
