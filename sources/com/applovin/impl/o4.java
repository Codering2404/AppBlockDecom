package com.applovin.impl;

import com.applovin.impl.ij;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class o4 implements ij {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f62174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f62175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f62176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f62177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f62178e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f62179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f62180g;

    public o4(long j3, long j4, int i3, int i4, boolean z2) {
        this.f62174a = j3;
        this.f62175b = j4;
        this.f62176c = i4 == -1 ? 1 : i4;
        this.f62178e = i3;
        this.f62180g = z2;
        if (j3 == -1) {
            this.f62177d = -1L;
            this.f62179f = -9223372036854775807L;
        } else {
            this.f62177d = j3 - j4;
            this.f62179f = a(j3, j4, i3);
        }
    }

    private static long a(long j3, long j4, int i3) {
        return (Math.max(0L, j3 - j4) * 8000000) / ((long) i3);
    }

    private long c(long j3) {
        long j4 = (j3 * ((long) this.f62178e)) / 8000000;
        long j5 = this.f62176c;
        long jMin = (j4 / j5) * j5;
        long j6 = this.f62177d;
        if (j6 != -1) {
            jMin = Math.min(jMin, j6 - j5);
        }
        return this.f62175b + Math.max(jMin, 0L);
    }

    @Override // com.applovin.impl.ij
    public ij.a b(long j3) {
        if (this.f62177d == -1 && !this.f62180g) {
            return new ij.a(new kj(0L, this.f62175b));
        }
        long jC = c(j3);
        long jD = d(jC);
        kj kjVar = new kj(jD, jC);
        if (this.f62177d != -1 && jD < j3) {
            long j4 = jC + ((long) this.f62176c);
            if (j4 < this.f62174a) {
                return new ij.a(kjVar, new kj(d(j4), j4));
            }
        }
        return new ij.a(kjVar);
    }

    @Override // com.applovin.impl.ij
    public long d() {
        return this.f62179f;
    }

    public long d(long j3) {
        return a(j3, this.f62175b, this.f62178e);
    }

    @Override // com.applovin.impl.ij
    public boolean b() {
        return this.f62177d != -1 || this.f62180g;
    }
}
