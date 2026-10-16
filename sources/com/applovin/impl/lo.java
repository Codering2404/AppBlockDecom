package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class lo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f61249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f61250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f61251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f61252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f61253e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e9 f61254f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f61255g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long[] f61256h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long[] f61257i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f61258j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final mo[] f61259k;

    public lo(int i3, int i4, long j3, long j4, long j5, e9 e9Var, int i5, mo[] moVarArr, int i6, long[] jArr, long[] jArr2) {
        this.f61249a = i3;
        this.f61250b = i4;
        this.f61251c = j3;
        this.f61252d = j4;
        this.f61253e = j5;
        this.f61254f = e9Var;
        this.f61255g = i5;
        this.f61259k = moVarArr;
        this.f61258j = i6;
        this.f61256h = jArr;
        this.f61257i = jArr2;
    }

    public mo a(int i3) {
        mo[] moVarArr = this.f61259k;
        if (moVarArr == null) {
            return null;
        }
        return moVarArr[i3];
    }
}
