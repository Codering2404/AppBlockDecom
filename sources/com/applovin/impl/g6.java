package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class g6 implements fd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bl f59871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f59872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private qi f59873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private fd f59874d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f59875f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f59876g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void a(ph phVar);
    }

    public g6(a aVar, l3 l3Var) {
        this.f59872b = aVar;
        this.f59871a = new bl(l3Var);
    }

    @Override // com.applovin.impl.fd
    public ph a() {
        fd fdVar = this.f59874d;
        return fdVar != null ? fdVar.a() : this.f59871a.a();
    }

    public void b(qi qiVar) throws z7 {
        fd fdVar;
        fd fdVarL = qiVar.l();
        if (fdVarL == null || fdVarL == (fdVar = this.f59874d)) {
            return;
        }
        if (fdVar != null) {
            throw z7.a(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
        this.f59874d = fdVarL;
        this.f59873c = qiVar;
        fdVarL.a(this.f59871a.a());
    }

    public void c() {
        this.f59876g = false;
        this.f59871a.c();
    }

    @Override // com.applovin.impl.fd
    public long p() {
        return this.f59875f ? this.f59871a.p() : ((fd) b1.a(this.f59874d)).p();
    }

    private void c(boolean z2) {
        if (a(z2)) {
            this.f59875f = true;
            if (this.f59876g) {
                this.f59871a.b();
                return;
            }
            return;
        }
        fd fdVar = (fd) b1.a(this.f59874d);
        long jP = fdVar.p();
        if (this.f59875f) {
            if (jP < this.f59871a.p()) {
                this.f59871a.c();
                return;
            } else {
                this.f59875f = false;
                if (this.f59876g) {
                    this.f59871a.b();
                }
            }
        }
        this.f59871a.a(jP);
        ph phVarA = fdVar.a();
        if (phVarA.equals(this.f59871a.a())) {
            return;
        }
        this.f59871a.a(phVarA);
        this.f59872b.a(phVarA);
    }

    public void a(qi qiVar) {
        if (qiVar == this.f59873c) {
            this.f59874d = null;
            this.f59873c = null;
            this.f59875f = true;
        }
    }

    public void b() {
        this.f59876g = true;
        this.f59871a.b();
    }

    public void a(long j3) {
        this.f59871a.a(j3);
    }

    @Override // com.applovin.impl.fd
    public void a(ph phVar) {
        fd fdVar = this.f59874d;
        if (fdVar != null) {
            fdVar.a(phVar);
            phVar = this.f59874d.a();
        }
        this.f59871a.a(phVar);
    }

    public long b(boolean z2) {
        c(z2);
        return p();
    }

    private boolean a(boolean z2) {
        qi qiVar = this.f59873c;
        if (qiVar == null || qiVar.c()) {
            return true;
        }
        if (this.f59873c.d()) {
            return false;
        }
        return z2 || this.f59873c.j();
    }
}
