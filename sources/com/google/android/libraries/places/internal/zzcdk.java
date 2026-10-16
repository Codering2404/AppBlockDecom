package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcdk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f77672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f77673b = new int[10];

    public final zzcdk a(int i3, int i4, int i5) {
        if (i3 >= 10) {
            return this;
        }
        this.f77672a = (1 << i3) | this.f77672a;
        this.f77673b[i3] = i5;
        return this;
    }

    public final boolean b(int i3) {
        return ((1 << i3) & this.f77672a) != 0;
    }

    public final int c(int i3) {
        return this.f77673b[i3];
    }

    final int d() {
        return Integer.bitCount(this.f77672a);
    }

    final int e() {
        if ((this.f77672a & 2) != 0) {
            return this.f77673b[1];
        }
        return -1;
    }

    final int f(int i3) {
        return (this.f77672a & 32) != 0 ? this.f77673b[5] : i3;
    }
}
