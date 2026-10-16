package com.applovin.impl;

import android.text.Layout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class jp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f60790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f60791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f60792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f60793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f60794e;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f60800k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f60801l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Layout.Alignment f60804o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Layout.Alignment f60805p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private xn f60807r;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f60795f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f60796g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f60797h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f60798i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f60799j = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f60802m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f60803n = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f60806q = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f60808s = Float.MAX_VALUE;

    public jp a(jp jpVar) {
        return a(jpVar, true);
    }

    public int b() {
        if (this.f60792c) {
            return this.f60791b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public String c() {
        return this.f60790a;
    }

    public float d() {
        return this.f60800k;
    }

    public int e() {
        return this.f60799j;
    }

    public String f() {
        return this.f60801l;
    }

    public Layout.Alignment g() {
        return this.f60805p;
    }

    public int h() {
        return this.f60803n;
    }

    public int i() {
        return this.f60802m;
    }

    public float j() {
        return this.f60808s;
    }

    public int k() {
        int i3 = this.f60797h;
        if (i3 == -1 && this.f60798i == -1) {
            return -1;
        }
        return (i3 == 1 ? 1 : 0) | (this.f60798i == 1 ? 2 : 0);
    }

    public Layout.Alignment l() {
        return this.f60804o;
    }

    public boolean m() {
        return this.f60806q == 1;
    }

    public xn n() {
        return this.f60807r;
    }

    public boolean o() {
        return this.f60794e;
    }

    public boolean p() {
        return this.f60792c;
    }

    public boolean q() {
        return this.f60795f == 1;
    }

    public boolean r() {
        return this.f60796g == 1;
    }

    public int a() {
        if (this.f60794e) {
            return this.f60793d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public jp c(int i3) {
        this.f60799j = i3;
        return this;
    }

    public jp d(int i3) {
        this.f60803n = i3;
        return this;
    }

    public jp e(int i3) {
        this.f60802m = i3;
        return this;
    }

    public jp c(boolean z2) {
        this.f60795f = z2 ? 1 : 0;
        return this;
    }

    public jp d(boolean z2) {
        this.f60806q = z2 ? 1 : 0;
        return this;
    }

    public jp e(boolean z2) {
        this.f60796g = z2 ? 1 : 0;
        return this;
    }

    public jp b(int i3) {
        this.f60791b = i3;
        this.f60792c = true;
        return this;
    }

    private jp a(jp jpVar, boolean z2) {
        int i3;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (jpVar != null) {
            if (!this.f60792c && jpVar.f60792c) {
                b(jpVar.f60791b);
            }
            if (this.f60797h == -1) {
                this.f60797h = jpVar.f60797h;
            }
            if (this.f60798i == -1) {
                this.f60798i = jpVar.f60798i;
            }
            if (this.f60790a == null && (str = jpVar.f60790a) != null) {
                this.f60790a = str;
            }
            if (this.f60795f == -1) {
                this.f60795f = jpVar.f60795f;
            }
            if (this.f60796g == -1) {
                this.f60796g = jpVar.f60796g;
            }
            if (this.f60803n == -1) {
                this.f60803n = jpVar.f60803n;
            }
            if (this.f60804o == null && (alignment2 = jpVar.f60804o) != null) {
                this.f60804o = alignment2;
            }
            if (this.f60805p == null && (alignment = jpVar.f60805p) != null) {
                this.f60805p = alignment;
            }
            if (this.f60806q == -1) {
                this.f60806q = jpVar.f60806q;
            }
            if (this.f60799j == -1) {
                this.f60799j = jpVar.f60799j;
                this.f60800k = jpVar.f60800k;
            }
            if (this.f60807r == null) {
                this.f60807r = jpVar.f60807r;
            }
            if (this.f60808s == Float.MAX_VALUE) {
                this.f60808s = jpVar.f60808s;
            }
            if (z2 && !this.f60794e && jpVar.f60794e) {
                a(jpVar.f60793d);
            }
            if (z2 && this.f60802m == -1 && (i3 = jpVar.f60802m) != -1) {
                this.f60802m = i3;
            }
        }
        return this;
    }

    public jp b(String str) {
        this.f60801l = str;
        return this;
    }

    public jp b(boolean z2) {
        this.f60798i = z2 ? 1 : 0;
        return this;
    }

    public jp b(float f3) {
        this.f60808s = f3;
        return this;
    }

    public jp b(Layout.Alignment alignment) {
        this.f60804o = alignment;
        return this;
    }

    public jp a(int i3) {
        this.f60793d = i3;
        this.f60794e = true;
        return this;
    }

    public jp a(boolean z2) {
        this.f60797h = z2 ? 1 : 0;
        return this;
    }

    public jp a(String str) {
        this.f60790a = str;
        return this;
    }

    public jp a(float f3) {
        this.f60800k = f3;
        return this;
    }

    public jp a(Layout.Alignment alignment) {
        this.f60805p = alignment;
        return this;
    }

    public jp a(xn xnVar) {
        this.f60807r = xnVar;
        return this;
    }
}
