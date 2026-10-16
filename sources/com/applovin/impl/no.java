package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class no {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k6 f62099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f62100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f62101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f62102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f62103e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f62104f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f62111m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public mo f62113o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f62115q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f62116r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f62117s;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f62105g = new long[0];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f62106h = new int[0];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f62107i = new int[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f62108j = new int[0];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long[] f62109k = new long[0];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean[] f62110l = new boolean[0];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean[] f62112n = new boolean[0];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ah f62114p = new ah();

    public void a(k8 k8Var) {
        k8Var.d(this.f62114p.c(), 0, this.f62114p.e());
        this.f62114p.f(0);
        this.f62115q = false;
    }

    public void b(int i3) {
        this.f62114p.d(i3);
        this.f62111m = true;
        this.f62115q = true;
    }

    public boolean c(int i3) {
        return this.f62111m && this.f62112n[i3];
    }

    public void a(ah ahVar) {
        ahVar.a(this.f62114p.c(), 0, this.f62114p.e());
        this.f62114p.f(0);
        this.f62115q = false;
    }

    public long a(int i3) {
        return this.f62109k[i3] + ((long) this.f62108j[i3]);
    }

    public void a(int i3, int i4) {
        this.f62103e = i3;
        this.f62104f = i4;
        if (this.f62106h.length < i3) {
            this.f62105g = new long[i3];
            this.f62106h = new int[i3];
        }
        if (this.f62107i.length < i4) {
            int i5 = (i4 * 125) / 100;
            this.f62107i = new int[i5];
            this.f62108j = new int[i5];
            this.f62109k = new long[i5];
            this.f62110l = new boolean[i5];
            this.f62112n = new boolean[i5];
        }
    }

    public void a() {
        this.f62103e = 0;
        this.f62116r = 0L;
        this.f62117s = false;
        this.f62111m = false;
        this.f62115q = false;
        this.f62113o = null;
    }
}
