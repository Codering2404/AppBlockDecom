package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class si {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final si f63718b = new si(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f63719a;

    public si(boolean z2) {
        this.f63719a = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && si.class == obj.getClass() && this.f63719a == ((si) obj).f63719a;
    }

    public int hashCode() {
        return !this.f63719a ? 1 : 0;
    }
}
