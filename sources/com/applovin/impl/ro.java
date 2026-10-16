package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class ro {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final lo f62895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f62896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f62897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f62898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f62899e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long[] f62900f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f62901g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f62902h;

    public ro(lo loVar, long[] jArr, int[] iArr, int i3, long[] jArr2, int[] iArr2, long j3) {
        b1.a(iArr.length == jArr2.length);
        b1.a(jArr.length == jArr2.length);
        b1.a(iArr2.length == jArr2.length);
        this.f62895a = loVar;
        this.f62897c = jArr;
        this.f62898d = iArr;
        this.f62899e = i3;
        this.f62900f = jArr2;
        this.f62901g = iArr2;
        this.f62902h = j3;
        this.f62896b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public int a(long j3) {
        for (int iB = xp.b(this.f62900f, j3, true, false); iB >= 0; iB--) {
            if ((this.f62901g[iB] & 1) != 0) {
                return iB;
            }
        }
        return -1;
    }

    public int b(long j3) {
        for (int iA = xp.a(this.f62900f, j3, true, false); iA < this.f62900f.length; iA++) {
            if ((this.f62901g[iA] & 1) != 0) {
                return iA;
            }
        }
        return -1;
    }
}
