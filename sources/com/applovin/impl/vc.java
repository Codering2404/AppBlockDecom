package com.applovin.impl;

import com.applovin.impl.ae;
import com.applovin.impl.vd;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class vc implements vd, vd.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ae.a f64413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f64414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final n0 f64415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ae f64416d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private vd f64417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private vd.a f64418g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f64419h = -9223372036854775807L;

    public vc(ae.a aVar, n0 n0Var, long j3) {
        this.f64413a = aVar;
        this.f64415c = n0Var;
        this.f64414b = j3;
    }

    public void a(ae.a aVar) {
        long jD = d(this.f64414b);
        vd vdVarA = ((ae) b1.a(this.f64416d)).a(aVar, this.f64415c, jD);
        this.f64417f = vdVarA;
        if (this.f64418g != null) {
            vdVarA.a(this, jD);
        }
    }

    @Override // com.applovin.impl.vd
    public boolean b(long j3) {
        vd vdVar = this.f64417f;
        return vdVar != null && vdVar.b(j3);
    }

    public long c() {
        return this.f64419h;
    }

    public long d() {
        return this.f64414b;
    }

    @Override // com.applovin.impl.vd
    public long e() {
        return ((vd) xp.a(this.f64417f)).e();
    }

    @Override // com.applovin.impl.vd
    public void f() {
        vd vdVar = this.f64417f;
        if (vdVar != null) {
            vdVar.f();
            return;
        }
        ae aeVar = this.f64416d;
        if (aeVar != null) {
            aeVar.b();
        }
    }

    @Override // com.applovin.impl.vd
    public long g() {
        return ((vd) xp.a(this.f64417f)).g();
    }

    @Override // com.applovin.impl.vd
    public long h() {
        return ((vd) xp.a(this.f64417f)).h();
    }

    public void i() {
        if (this.f64417f != null) {
            ((ae) b1.a(this.f64416d)).a(this.f64417f);
        }
    }

    private long d(long j3) {
        long j4 = this.f64419h;
        return j4 != -9223372036854775807L ? j4 : j3;
    }

    @Override // com.applovin.impl.vd
    public po b() {
        return ((vd) xp.a(this.f64417f)).b();
    }

    @Override // com.applovin.impl.vd
    public void c(long j3) {
        ((vd) xp.a(this.f64417f)).c(j3);
    }

    public void e(long j3) {
        this.f64419h = j3;
    }

    @Override // com.applovin.impl.pj.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(vd vdVar) {
        ((vd.a) xp.a(this.f64418g)).a((pj) this);
    }

    @Override // com.applovin.impl.vd
    public void a(long j3, boolean z2) {
        ((vd) xp.a(this.f64417f)).a(j3, z2);
    }

    @Override // com.applovin.impl.vd
    public long a(long j3, jj jjVar) {
        return ((vd) xp.a(this.f64417f)).a(j3, jjVar);
    }

    @Override // com.applovin.impl.vd
    public boolean a() {
        vd vdVar = this.f64417f;
        return vdVar != null && vdVar.a();
    }

    @Override // com.applovin.impl.vd.a
    public void a(vd vdVar) {
        ((vd.a) xp.a(this.f64418g)).a((vd) this);
    }

    @Override // com.applovin.impl.vd
    public void a(vd.a aVar, long j3) {
        this.f64418g = aVar;
        vd vdVar = this.f64417f;
        if (vdVar != null) {
            vdVar.a(this, d(this.f64414b));
        }
    }

    @Override // com.applovin.impl.vd
    public long a(long j3) {
        return ((vd) xp.a(this.f64417f)).a(j3);
    }

    @Override // com.applovin.impl.vd
    public long a(g8[] g8VarArr, boolean[] zArr, cj[] cjVarArr, boolean[] zArr2, long j3) {
        long j4;
        long j5 = this.f64419h;
        if (j5 == -9223372036854775807L || j3 != this.f64414b) {
            j4 = j3;
        } else {
            this.f64419h = -9223372036854775807L;
            j4 = j5;
        }
        return ((vd) xp.a(this.f64417f)).a(g8VarArr, zArr, cjVarArr, zArr2, j4);
    }

    public void a(ae aeVar) {
        b1.b(this.f64416d == null);
        this.f64416d = aeVar;
    }
}
