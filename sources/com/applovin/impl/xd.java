package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class xd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f64962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f64963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f64964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f64965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f64966e;

    protected xd(xd xdVar) {
        this.f64962a = xdVar.f64962a;
        this.f64963b = xdVar.f64963b;
        this.f64964c = xdVar.f64964c;
        this.f64965d = xdVar.f64965d;
        this.f64966e = xdVar.f64966e;
    }

    public xd a(Object obj) {
        return this.f64962a.equals(obj) ? this : new xd(obj, this.f64963b, this.f64964c, this.f64965d, this.f64966e);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xd)) {
            return false;
        }
        xd xdVar = (xd) obj;
        return this.f64962a.equals(xdVar.f64962a) && this.f64963b == xdVar.f64963b && this.f64964c == xdVar.f64964c && this.f64965d == xdVar.f64965d && this.f64966e == xdVar.f64966e;
    }

    public int hashCode() {
        return ((((((((this.f64962a.hashCode() + 527) * 31) + this.f64963b) * 31) + this.f64964c) * 31) + ((int) this.f64965d)) * 31) + this.f64966e;
    }

    public boolean a() {
        return this.f64963b != -1;
    }

    public xd(Object obj) {
        this(obj, -1L);
    }

    public xd(Object obj, int i3, int i4, long j3) {
        this(obj, i3, i4, j3, -1);
    }

    private xd(Object obj, int i3, int i4, long j3, int i5) {
        this.f64962a = obj;
        this.f64963b = i3;
        this.f64964c = i4;
        this.f64965d = j3;
        this.f64966e = i5;
    }

    public xd(Object obj, long j3) {
        this(obj, -1, -1, j3, -1);
    }

    public xd(Object obj, long j3, int i3) {
        this(obj, -1, -1, j3, i3);
    }
}
