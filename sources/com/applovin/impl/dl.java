package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class dl extends g9 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f59257b;

    public dl(k8 k8Var, long j3) {
        super(k8Var);
        b1.a(k8Var.f() >= j3);
        this.f59257b = j3;
    }

    @Override // com.applovin.impl.g9, com.applovin.impl.k8
    public long a() {
        return super.a() - this.f59257b;
    }

    @Override // com.applovin.impl.g9, com.applovin.impl.k8
    public long d() {
        return super.d() - this.f59257b;
    }

    @Override // com.applovin.impl.g9, com.applovin.impl.k8
    public long f() {
        return super.f() - this.f59257b;
    }
}
