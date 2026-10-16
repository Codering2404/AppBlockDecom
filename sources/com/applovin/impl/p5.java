package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class p5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f62411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e9 f62412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e9 f62413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f62414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f62415e;

    public p5(String str, e9 e9Var, e9 e9Var2, int i3, int i4) {
        b1.a(i3 == 0 || i4 == 0);
        this.f62411a = b1.a(str);
        this.f62412b = (e9) b1.a(e9Var);
        this.f62413c = (e9) b1.a(e9Var2);
        this.f62414d = i3;
        this.f62415e = i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && p5.class == obj.getClass()) {
            p5 p5Var = (p5) obj;
            if (this.f62414d == p5Var.f62414d && this.f62415e == p5Var.f62415e && this.f62411a.equals(p5Var.f62411a) && this.f62412b.equals(p5Var.f62412b) && this.f62413c.equals(p5Var.f62413c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.f62414d + 527) * 31) + this.f62415e) * 31) + this.f62411a.hashCode()) * 31) + this.f62412b.hashCode()) * 31) + this.f62413c.hashCode();
    }
}
