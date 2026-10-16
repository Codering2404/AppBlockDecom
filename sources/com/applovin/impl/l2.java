package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class l2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f61103a;

    public final void b(int i3) {
        this.f61103a = i3 | this.f61103a;
    }

    public final void c(int i3) {
        this.f61103a = (~i3) & this.f61103a;
    }

    protected final boolean d(int i3) {
        return (this.f61103a & i3) == i3;
    }

    public final boolean e() {
        return d(4);
    }

    public final boolean f() {
        return d(1);
    }

    public void b() {
        this.f61103a = 0;
    }

    public final boolean c() {
        return d(268435456);
    }

    public final boolean d() {
        return d(Integer.MIN_VALUE);
    }

    public final void e(int i3) {
        this.f61103a = i3;
    }
}
