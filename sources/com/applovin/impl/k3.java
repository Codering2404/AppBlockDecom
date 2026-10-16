package com.applovin.impl;

import com.applovin.impl.vd;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class k3 implements vd, vd.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vd f60894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private vd.a f60895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a[] f60896c = new a[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f60897d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f60898f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f60899g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class a implements cj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cj f60900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f60901b;

        public a(cj cjVar) {
            this.f60900a = cjVar;
        }

        @Override // com.applovin.impl.cj
        public void a() {
            this.f60900a.a();
        }

        public void b() {
            this.f60901b = false;
        }

        @Override // com.applovin.impl.cj
        public boolean d() {
            return !k3.this.c() && this.f60900a.d();
        }

        @Override // com.applovin.impl.cj
        public int a(f9 f9Var, o5 o5Var, int i3) {
            if (k3.this.c()) {
                return -3;
            }
            if (this.f60901b) {
                o5Var.e(4);
                return -4;
            }
            int iA = this.f60900a.a(f9Var, o5Var, i3);
            if (iA == -5) {
                e9 e9Var = (e9) b1.a(f9Var.f59641b);
                int i4 = e9Var.C;
                if (i4 != 0 || e9Var.D != 0) {
                    k3 k3Var = k3.this;
                    if (k3Var.f60898f != 0) {
                        i4 = 0;
                    }
                    f9Var.f59641b = e9Var.a().e(i4).f(k3Var.f60899g == Long.MIN_VALUE ? e9Var.D : 0).a();
                }
                return -5;
            }
            k3 k3Var2 = k3.this;
            long j3 = k3Var2.f60899g;
            if (j3 == Long.MIN_VALUE || ((iA != -4 || o5Var.f62185f < j3) && !(iA == -3 && k3Var2.e() == Long.MIN_VALUE && !o5Var.f62184d))) {
                return iA;
            }
            o5Var.b();
            o5Var.e(4);
            this.f60901b = true;
            return -4;
        }

        @Override // com.applovin.impl.cj
        public int a(long j3) {
            if (k3.this.c()) {
                return -3;
            }
            return this.f60900a.a(j3);
        }
    }

    public k3(vd vdVar, boolean z2, long j3, long j4) {
        this.f60894a = vdVar;
        this.f60897d = z2 ? j3 : -9223372036854775807L;
        this.f60898f = j3;
        this.f60899g = j4;
    }

    private jj b(long j3, jj jjVar) {
        long jB = xp.b(jjVar.f60766a, 0L, j3 - this.f60898f);
        long j4 = jjVar.f60767b;
        long j5 = this.f60899g;
        long jB2 = xp.b(j4, 0L, j5 == Long.MIN_VALUE ? Long.MAX_VALUE : j5 - j3);
        return (jB == jjVar.f60766a && jB2 == jjVar.f60767b) ? jjVar : new jj(jB, jB2);
    }

    @Override // com.applovin.impl.vd
    public void a(long j3, boolean z2) {
        this.f60894a.a(j3, z2);
    }

    boolean c() {
        return this.f60897d != -9223372036854775807L;
    }

    @Override // com.applovin.impl.vd
    public long e() {
        long jE = this.f60894a.e();
        if (jE != Long.MIN_VALUE) {
            long j3 = this.f60899g;
            if (j3 == Long.MIN_VALUE || jE < j3) {
                return jE;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.applovin.impl.vd
    public void f() {
        this.f60894a.f();
    }

    @Override // com.applovin.impl.vd
    public long g() {
        long jG = this.f60894a.g();
        if (jG != Long.MIN_VALUE) {
            long j3 = this.f60899g;
            if (j3 == Long.MIN_VALUE || jG < j3) {
                return jG;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.applovin.impl.vd
    public long h() {
        if (c()) {
            long j3 = this.f60897d;
            this.f60897d = -9223372036854775807L;
            long jH = h();
            return jH != -9223372036854775807L ? jH : j3;
        }
        long jH2 = this.f60894a.h();
        if (jH2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        b1.b(jH2 >= this.f60898f);
        long j4 = this.f60899g;
        b1.b(j4 == Long.MIN_VALUE || jH2 <= j4);
        return jH2;
    }

    @Override // com.applovin.impl.vd
    public long a(long j3, jj jjVar) {
        long j4 = this.f60898f;
        if (j3 == j4) {
            return j4;
        }
        return this.f60894a.a(j3, b(j3, jjVar));
    }

    @Override // com.applovin.impl.vd
    public void c(long j3) {
        this.f60894a.c(j3);
    }

    @Override // com.applovin.impl.vd
    public boolean a() {
        return this.f60894a.a();
    }

    @Override // com.applovin.impl.vd.a
    public void a(vd vdVar) {
        ((vd.a) b1.a(this.f60895b)).a((vd) this);
    }

    @Override // com.applovin.impl.vd
    public void a(vd.a aVar, long j3) {
        this.f60895b = aVar;
        this.f60894a.a(this, j3);
    }

    @Override // com.applovin.impl.vd
    public boolean b(long j3) {
        return this.f60894a.b(j3);
    }

    @Override // com.applovin.impl.vd
    public po b() {
        return this.f60894a.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    @Override // com.applovin.impl.vd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long a(long r6) {
        /*
            r5 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5.f60897d = r0
            com.applovin.impl.k3$a[] r0 = r5.f60896c
            int r1 = r0.length
            r2 = 0
            r3 = r2
        Lc:
            if (r3 >= r1) goto L18
            r4 = r0[r3]
            if (r4 == 0) goto L15
            r4.b()
        L15:
            int r3 = r3 + 1
            goto Lc
        L18:
            com.applovin.impl.vd r0 = r5.f60894a
            long r0 = r0.a(r6)
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 == 0) goto L34
            long r6 = r5.f60898f
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 < 0) goto L35
            long r6 = r5.f60899g
            r3 = -9223372036854775808
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 == 0) goto L34
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 > 0) goto L35
        L34:
            r2 = 1
        L35:
            com.applovin.impl.b1.b(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.k3.a(long):long");
    }

    @Override // com.applovin.impl.pj.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(vd vdVar) {
        ((vd.a) b1.a(this.f60895b)).a((pj) this);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
    @Override // com.applovin.impl.vd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long a(com.applovin.impl.g8[] r10, boolean[] r11, com.applovin.impl.cj[] r12, boolean[] r13, long r14) {
        /*
            r9 = this;
            int r0 = r12.length
            com.applovin.impl.k3$a[] r0 = new com.applovin.impl.k3.a[r0]
            r9.f60896c = r0
            int r0 = r12.length
            com.applovin.impl.cj[] r4 = new com.applovin.impl.cj[r0]
            r0 = 0
            r1 = r0
        La:
            int r2 = r12.length
            r8 = 0
            if (r1 >= r2) goto L1f
            com.applovin.impl.k3$a[] r2 = r9.f60896c
            r3 = r12[r1]
            com.applovin.impl.k3$a r3 = (com.applovin.impl.k3.a) r3
            r2[r1] = r3
            if (r3 == 0) goto L1a
            com.applovin.impl.cj r8 = r3.f60900a
        L1a:
            r4[r1] = r8
            int r1 = r1 + 1
            goto La
        L1f:
            com.applovin.impl.vd r1 = r9.f60894a
            r2 = r10
            r3 = r11
            r5 = r13
            r6 = r14
            long r10 = r1.a(r2, r3, r4, r5, r6)
            boolean r13 = r9.c()
            if (r13 == 0) goto L3d
            long r13 = r9.f60898f
            int r15 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r15 != 0) goto L3d
            boolean r13 = a(r13, r2)
            if (r13 == 0) goto L3d
            r13 = r10
            goto L42
        L3d:
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L42:
            r9.f60897d = r13
            int r13 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r13 == 0) goto L5d
            long r13 = r9.f60898f
            int r13 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r13 < 0) goto L5b
            long r13 = r9.f60899g
            r1 = -9223372036854775808
            int r15 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r15 == 0) goto L5d
            int r13 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r13 > 0) goto L5b
            goto L5d
        L5b:
            r13 = r0
            goto L5e
        L5d:
            r13 = 1
        L5e:
            com.applovin.impl.b1.b(r13)
        L61:
            int r13 = r12.length
            if (r0 >= r13) goto L87
            r13 = r4[r0]
            if (r13 != 0) goto L6d
            com.applovin.impl.k3$a[] r13 = r9.f60896c
            r13[r0] = r8
            goto L7e
        L6d:
            com.applovin.impl.k3$a[] r14 = r9.f60896c
            r15 = r14[r0]
            if (r15 == 0) goto L77
            com.applovin.impl.cj r15 = r15.f60900a
            if (r15 == r13) goto L7e
        L77:
            com.applovin.impl.k3$a r15 = new com.applovin.impl.k3$a
            r15.<init>(r13)
            r14[r0] = r15
        L7e:
            com.applovin.impl.k3$a[] r13 = r9.f60896c
            r13 = r13[r0]
            r12[r0] = r13
            int r0 = r0 + 1
            goto L61
        L87:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.k3.a(com.applovin.impl.g8[], boolean[], com.applovin.impl.cj[], boolean[], long):long");
    }

    private static boolean a(long j3, g8[] g8VarArr) {
        if (j3 != 0) {
            for (g8 g8Var : g8VarArr) {
                if (g8Var != null) {
                    e9 e9VarG = g8Var.g();
                    if (!hf.a(e9VarG.f59394m, e9VarG.f59391j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void a(long j3, long j4) {
        this.f60898f = j3;
        this.f60899g = j4;
    }
}
