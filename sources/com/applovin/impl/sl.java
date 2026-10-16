package com.applovin.impl;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class sl extends yg implements nl {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private nl f63814d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f63815f;

    @Override // com.applovin.impl.nl
    public long a(int i3) {
        return ((nl) b1.a(this.f63814d)).a(i3) + this.f63815f;
    }

    @Override // com.applovin.impl.l2
    public void b() {
        super.b();
        this.f63814d = null;
    }

    @Override // com.applovin.impl.nl
    public int a() {
        return ((nl) b1.a(this.f63814d)).a();
    }

    @Override // com.applovin.impl.nl
    public int a(long j3) {
        return ((nl) b1.a(this.f63814d)).a(j3 - this.f63815f);
    }

    @Override // com.applovin.impl.nl
    public List b(long j3) {
        return ((nl) b1.a(this.f63814d)).b(j3 - this.f63815f);
    }

    public void a(long j3, nl nlVar, long j4) {
        this.f65212b = j3;
        this.f63814d = nlVar;
        if (j4 != Long.MAX_VALUE) {
            j3 = j4;
        }
        this.f63815f = j3;
    }
}
