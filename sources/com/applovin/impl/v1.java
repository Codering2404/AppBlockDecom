package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f64368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f64369b;

    public v1(int i3, float f3) {
        this.f64368a = i3;
        this.f64369b = f3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && v1.class == obj.getClass()) {
            v1 v1Var = (v1) obj;
            if (this.f64368a == v1Var.f64368a && Float.compare(v1Var.f64369b, this.f64369b) == 0) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f64368a + 527) * 31) + Float.floatToIntBits(this.f64369b);
    }
}
