package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class e2 implements qi, ri {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f59331a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private si f59333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f59334d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f59335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private cj f59336g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private e9[] f59337h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f59338i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f59339j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f59341l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f59342m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f9 f59332b = new f9();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f59340k = Long.MIN_VALUE;

    public e2(int i3) {
        this.f59331a = i3;
    }

    @Override // com.applovin.impl.rh.b
    public void a(int i3, Object obj) {
    }

    protected abstract void a(long j3, boolean z2);

    protected abstract void a(e9[] e9VarArr, long j3, long j4);

    @Override // com.applovin.impl.qi
    public final int b() {
        return this.f59335f;
    }

    @Override // com.applovin.impl.qi, com.applovin.impl.ri
    public final int e() {
        return this.f59331a;
    }

    @Override // com.applovin.impl.qi
    public final void f() {
        b1.b(this.f59335f == 1);
        this.f59332b.a();
        this.f59335f = 0;
        this.f59336g = null;
        this.f59337h = null;
        this.f59341l = false;
        v();
    }

    @Override // com.applovin.impl.qi
    public final void g() {
        this.f59341l = true;
    }

    @Override // com.applovin.impl.qi
    public final void h() {
        ((cj) b1.a(this.f59336g)).a();
    }

    @Override // com.applovin.impl.qi
    public final long i() {
        return this.f59340k;
    }

    @Override // com.applovin.impl.qi
    public final boolean j() {
        return this.f59340k == Long.MIN_VALUE;
    }

    @Override // com.applovin.impl.qi
    public final boolean k() {
        return this.f59341l;
    }

    @Override // com.applovin.impl.qi
    public fd l() {
        return null;
    }

    @Override // com.applovin.impl.ri
    public int m() {
        return 0;
    }

    @Override // com.applovin.impl.qi
    public final cj o() {
        return this.f59336g;
    }

    protected final si q() {
        return (si) b1.a(this.f59333c);
    }

    protected final f9 r() {
        this.f59332b.a();
        return this.f59332b;
    }

    @Override // com.applovin.impl.qi
    public final void reset() {
        b1.b(this.f59335f == 0);
        this.f59332b.a();
        w();
    }

    protected final int s() {
        return this.f59334d;
    }

    @Override // com.applovin.impl.qi
    public final void start() {
        b1.b(this.f59335f == 1);
        this.f59335f = 2;
        x();
    }

    @Override // com.applovin.impl.qi
    public final void stop() {
        b1.b(this.f59335f == 2);
        this.f59335f = 1;
        y();
    }

    protected final e9[] t() {
        return (e9[]) b1.a(this.f59337h);
    }

    protected final boolean u() {
        return j() ? this.f59341l : ((cj) b1.a(this.f59336g)).d();
    }

    protected abstract void v();

    protected void a(boolean z2, boolean z3) {
    }

    @Override // com.applovin.impl.qi
    public final void b(int i3) {
        this.f59334d = i3;
    }

    protected final z7 a(Throwable th, e9 e9Var, int i3) {
        return a(th, e9Var, false, i3);
    }

    protected int b(long j3) {
        return ((cj) b1.a(this.f59336g)).a(j3 - this.f59338i);
    }

    protected final z7 a(Throwable th, e9 e9Var, boolean z2, int i3) {
        int iD;
        if (e9Var == null || this.f59342m) {
            iD = 4;
        } else {
            this.f59342m = true;
            try {
                iD = ri.d(a(e9Var));
            } catch (z7 unused) {
                iD = 4;
            } finally {
                this.f59342m = false;
            }
        }
        return z7.a(th, getName(), s(), e9Var, iD, z2, i3);
    }

    @Override // com.applovin.impl.qi
    public final void a(si siVar, e9[] e9VarArr, cj cjVar, long j3, boolean z2, boolean z3, long j4, long j5) {
        b1.b(this.f59335f == 0);
        this.f59333c = siVar;
        this.f59335f = 1;
        this.f59339j = j3;
        a(z2, z3);
        a(e9VarArr, cjVar, j4, j5);
        a(j3, z2);
    }

    @Override // com.applovin.impl.qi
    public final ri n() {
        return this;
    }

    protected void w() {
    }

    protected void x() {
    }

    protected void y() {
    }

    protected final int a(f9 f9Var, o5 o5Var, int i3) {
        int iA = ((cj) b1.a(this.f59336g)).a(f9Var, o5Var, i3);
        if (iA != -4) {
            if (iA == -5) {
                e9 e9Var = (e9) b1.a(f9Var.f59641b);
                if (e9Var.f59398q != Long.MAX_VALUE) {
                    f9Var.f59641b = e9Var.a().a(e9Var.f59398q + this.f59338i).a();
                }
            }
            return iA;
        }
        if (o5Var.e()) {
            this.f59340k = Long.MIN_VALUE;
            return this.f59341l ? -4 : -3;
        }
        long j3 = o5Var.f62185f + this.f59338i;
        o5Var.f62185f = j3;
        this.f59340k = Math.max(this.f59340k, j3);
        return iA;
    }

    @Override // com.applovin.impl.qi
    public final void a(e9[] e9VarArr, cj cjVar, long j3, long j4) {
        b1.b(!this.f59341l);
        this.f59336g = cjVar;
        if (this.f59340k == Long.MIN_VALUE) {
            this.f59340k = j3;
        }
        this.f59337h = e9VarArr;
        this.f59338i = j4;
        a(e9VarArr, j3, j4);
    }

    @Override // com.applovin.impl.qi
    public final void a(long j3) {
        this.f59341l = false;
        this.f59339j = j3;
        this.f59340k = j3;
        a(j3, false);
    }
}
