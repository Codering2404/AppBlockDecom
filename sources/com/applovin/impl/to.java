package com.applovin.impl;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class to {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f63984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final so[] f63985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f63986c;

    public to(so... soVarArr) {
        this.f63985b = soVarArr;
        this.f63984a = soVarArr.length;
    }

    public so a(int i3) {
        return this.f63985b[i3];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || to.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f63985b, ((to) obj).f63985b);
    }

    public int hashCode() {
        if (this.f63986c == 0) {
            this.f63986c = Arrays.hashCode(this.f63985b) + 527;
        }
        return this.f63986c;
    }
}
