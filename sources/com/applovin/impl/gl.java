package com.applovin.impl;

import com.applovin.impl.ij;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class gl {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private qo f59998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private l8 f59999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private jg f60000d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f60001e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f60002f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f60003g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f60004h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f60005i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f60007k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f60008l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f60009m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final hg f59997a = new hg();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private b f60006j = new b();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        e9 f60010a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        jg f60011b;

        b() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class c implements jg {
        private c() {
        }

        @Override // com.applovin.impl.jg
        public long a(k8 k8Var) {
            return -1L;
        }

        @Override // com.applovin.impl.jg
        public void a(long j3) {
        }

        @Override // com.applovin.impl.jg
        public ij a() {
            return new ij.b(-9223372036854775807L);
        }
    }

    private void a() {
        b1.b(this.f59998b);
        xp.a(this.f59999c);
    }

    protected abstract long a(ah ahVar);

    protected abstract boolean a(ah ahVar, long j3, b bVar);

    protected long b(long j3) {
        return (((long) this.f60005i) * j3) / 1000000;
    }

    protected void c(long j3) {
        this.f60003g = j3;
    }

    private int b(k8 k8Var) {
        if (!a(k8Var)) {
            return -1;
        }
        e9 e9Var = this.f60006j.f60010a;
        this.f60005i = e9Var.A;
        if (!this.f60009m) {
            this.f59998b.a(e9Var);
            this.f60009m = true;
        }
        jg jgVar = this.f60006j.f60011b;
        if (jgVar != null) {
            this.f60000d = jgVar;
        } else if (k8Var.a() == -1) {
            this.f60000d = new c();
        } else {
            ig igVarA = this.f59997a.a();
            this.f60000d = new i6(this, this.f60002f, k8Var.a(), igVarA.f60453h + igVarA.f60454i, igVarA.f60448c, (igVarA.f60447b & 4) != 0);
        }
        this.f60004h = 2;
        this.f59997a.d();
        return 0;
    }

    protected long a(long j3) {
        return (j3 * 1000000) / ((long) this.f60005i);
    }

    void a(l8 l8Var, qo qoVar) {
        this.f59999c = l8Var;
        this.f59998b = qoVar;
        a(true);
    }

    final int a(k8 k8Var, th thVar) {
        a();
        int i3 = this.f60004h;
        if (i3 == 0) {
            return b(k8Var);
        }
        if (i3 == 1) {
            k8Var.a((int) this.f60002f);
            this.f60004h = 2;
            return 0;
        }
        if (i3 == 2) {
            xp.a(this.f60000d);
            return b(k8Var, thVar);
        }
        if (i3 == 3) {
            return -1;
        }
        throw new IllegalStateException();
    }

    private boolean a(k8 k8Var) {
        while (this.f59997a.a(k8Var)) {
            this.f60007k = k8Var.f() - this.f60002f;
            if (!a(this.f59997a.b(), this.f60002f, this.f60006j)) {
                return true;
            }
            this.f60002f = k8Var.f();
        }
        this.f60004h = 3;
        return false;
    }

    private int b(k8 k8Var, th thVar) {
        long jA = this.f60000d.a(k8Var);
        if (jA >= 0) {
            thVar.f63943a = jA;
            return 1;
        }
        if (jA < -1) {
            c(-(jA + 2));
        }
        if (!this.f60008l) {
            this.f59999c.a((ij) b1.b(this.f60000d.a()));
            this.f60008l = true;
        }
        if (this.f60007k <= 0 && !this.f59997a.a(k8Var)) {
            this.f60004h = 3;
            return -1;
        }
        this.f60007k = 0L;
        ah ahVarB = this.f59997a.b();
        long jA2 = a(ahVarB);
        if (jA2 >= 0) {
            long j3 = this.f60003g;
            if (j3 + jA2 >= this.f60001e) {
                long jA3 = a(j3);
                this.f59998b.a(ahVarB, ahVarB.e());
                this.f59998b.a(jA3, 1, ahVarB.e(), 0, null);
                this.f60001e = -1L;
            }
        }
        this.f60003g += jA2;
        return 0;
    }

    protected void a(boolean z2) {
        if (z2) {
            this.f60006j = new b();
            this.f60002f = 0L;
            this.f60004h = 0;
        } else {
            this.f60004h = 1;
        }
        this.f60001e = -1L;
        this.f60003g = 0L;
    }

    final void a(long j3, long j4) {
        this.f59997a.c();
        if (j3 == 0) {
            a(!this.f60008l);
        } else if (this.f60004h != 0) {
            this.f60001e = b(j4);
            ((jg) xp.a(this.f60000d)).a(this.f60001e);
            this.f60004h = 2;
        }
    }
}
