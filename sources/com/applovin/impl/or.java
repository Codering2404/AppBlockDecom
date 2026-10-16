package com.applovin.impl;

import com.applovin.impl.ij;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class or implements ij {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final mr f62378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f62379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f62380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f62381d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f62382e;

    public or(mr mrVar, int i3, long j3, long j4) {
        this.f62378a = mrVar;
        this.f62379b = i3;
        this.f62380c = j3;
        long j5 = (j4 - j3) / ((long) mrVar.f61929e);
        this.f62381d = j5;
        this.f62382e = c(j5);
    }

    private long c(long j3) {
        return xp.c(j3 * ((long) this.f62379b), 1000000L, this.f62378a.f61927c);
    }

    @Override // com.applovin.impl.ij
    public boolean b() {
        return true;
    }

    @Override // com.applovin.impl.ij
    public long d() {
        return this.f62382e;
    }

    @Override // com.applovin.impl.ij
    public ij.a b(long j3) {
        long jB = xp.b((((long) this.f62378a.f61927c) * j3) / (((long) this.f62379b) * 1000000), 0L, this.f62381d - 1);
        long j4 = this.f62380c + (((long) this.f62378a.f61929e) * jB);
        long jC = c(jB);
        kj kjVar = new kj(jC, j4);
        if (jC >= j3 || jB == this.f62381d - 1) {
            return new ij.a(kjVar);
        }
        long j5 = jB + 1;
        return new ij.a(kjVar, new kj(c(j5), this.f62380c + (((long) this.f62378a.f61929e) * j5)));
    }
}
