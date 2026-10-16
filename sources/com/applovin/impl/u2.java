package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class u2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f64065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f64066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f64067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f64068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f64069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f64070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Throwable f64071g;

    public Throwable a() {
        return this.f64071g;
    }

    public int b() {
        return this.f64070f;
    }

    public void c() {
        this.f64069e++;
    }

    public void d() {
        this.f64068d++;
    }

    public String toString() {
        return "CacheStatsTracker{totalDownloadedBytes=" + this.f64065a + ", totalCachedBytes=" + this.f64066b + ", isHTMLCachingCancelled=" + this.f64067c + ", htmlResourceCacheSuccessCount=" + this.f64068d + ", htmlResourceCacheFailureCount=" + this.f64069e + '}';
    }

    public void a(Throwable th) {
        this.f64071g = th;
    }

    public void a(int i3) {
        this.f64070f = i3;
    }

    public void a(long j3) {
        this.f64066b += j3;
    }
}
