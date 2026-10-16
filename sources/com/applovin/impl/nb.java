package com.applovin.impl;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class nb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f61995a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f61996b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f61997c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int[] f61998d = new int[16];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f61999e = 15;

    private void b() {
        int[] iArr = this.f61998d;
        int length = iArr.length << 1;
        if (length < 0) {
            throw new IllegalStateException();
        }
        int[] iArr2 = new int[length];
        int length2 = iArr.length;
        int i3 = this.f61995a;
        int i4 = length2 - i3;
        System.arraycopy(iArr, i3, iArr2, 0, i4);
        System.arraycopy(this.f61998d, 0, iArr2, i4, i3);
        this.f61995a = 0;
        this.f61996b = this.f61997c - 1;
        this.f61998d = iArr2;
        this.f61999e = length - 1;
    }

    public void a(int i3) {
        if (this.f61997c == this.f61998d.length) {
            b();
        }
        int i4 = (this.f61996b + 1) & this.f61999e;
        this.f61996b = i4;
        this.f61998d[i4] = i3;
        this.f61997c++;
    }

    public boolean c() {
        return this.f61997c == 0;
    }

    public int d() {
        int i3 = this.f61997c;
        if (i3 == 0) {
            throw new NoSuchElementException();
        }
        int[] iArr = this.f61998d;
        int i4 = this.f61995a;
        int i5 = iArr[i4];
        this.f61995a = (i4 + 1) & this.f61999e;
        this.f61997c = i3 - 1;
        return i5;
    }

    public void a() {
        this.f61995a = 0;
        this.f61996b = -1;
        this.f61997c = 0;
    }
}
