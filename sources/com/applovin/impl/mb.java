package com.applovin.impl;

import com.applovin.impl.ij;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class mb implements lj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f61395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final qc f61396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final qc f61397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f61398d;

    public mb(long j3, long j4, long j5) {
        this.f61398d = j3;
        this.f61395a = j5;
        qc qcVar = new qc();
        this.f61396b = qcVar;
        qc qcVar2 = new qc();
        this.f61397c = qcVar2;
        qcVar.a(0L);
        qcVar2.a(j4);
    }

    @Override // com.applovin.impl.lj
    public long a(long j3) {
        return this.f61396b.a(xp.a(this.f61397c, j3, true, true));
    }

    @Override // com.applovin.impl.ij
    public boolean b() {
        return true;
    }

    @Override // com.applovin.impl.lj
    public long c() {
        return this.f61395a;
    }

    @Override // com.applovin.impl.ij
    public long d() {
        return this.f61398d;
    }

    @Override // com.applovin.impl.ij
    public ij.a b(long j3) {
        int iA = xp.a(this.f61396b, j3, true, true);
        kj kjVar = new kj(this.f61396b.a(iA), this.f61397c.a(iA));
        if (kjVar.f61038a == j3 || iA == this.f61396b.a() - 1) {
            return new ij.a(kjVar);
        }
        int i3 = iA + 1;
        return new ij.a(kjVar, new kj(this.f61396b.a(i3), this.f61397c.a(i3)));
    }

    public boolean c(long j3) {
        qc qcVar = this.f61396b;
        return j3 - qcVar.a(qcVar.a() - 1) < 100000;
    }

    void d(long j3) {
        this.f61398d = j3;
    }

    public void a(long j3, long j4) {
        if (c(j3)) {
            return;
        }
        this.f61396b.a(j3);
        this.f61397c.a(j4);
    }
}
