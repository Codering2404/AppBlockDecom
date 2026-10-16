package com.applovin.impl;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class qc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f62603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long[] f62604b;

    public qc() {
        this(32);
    }

    public void a(long j3) {
        int i3 = this.f62603a;
        long[] jArr = this.f62604b;
        if (i3 == jArr.length) {
            this.f62604b = Arrays.copyOf(jArr, i3 * 2);
        }
        long[] jArr2 = this.f62604b;
        int i4 = this.f62603a;
        this.f62603a = i4 + 1;
        jArr2[i4] = j3;
    }

    public long[] b() {
        return Arrays.copyOf(this.f62604b, this.f62603a);
    }

    public qc(int i3) {
        this.f62604b = new long[i3];
    }

    public long a(int i3) {
        if (i3 >= 0 && i3 < this.f62603a) {
            return this.f62604b[i3];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i3 + ", size is " + this.f62603a);
    }

    public int a() {
        return this.f62603a;
    }
}
