package com.google.android.gms.auth.api.signin.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class HashAccumulator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f71233a = 1;

    public HashAccumulator a(Object obj) {
        this.f71233a = (this.f71233a * 31) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    public int b() {
        return this.f71233a;
    }

    public final HashAccumulator c(boolean z2) {
        this.f71233a = (this.f71233a * 31) + (z2 ? 1 : 0);
        return this;
    }
}
