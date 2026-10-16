package com.applovin.impl;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class eo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long[] f59526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object[] f59527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f59528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f59529d;

    public eo() {
        this(10);
    }

    private void b(long j3, Object obj) {
        int i3 = this.f59528c;
        int i4 = this.f59529d;
        Object[] objArr = this.f59527b;
        int length = (i3 + i4) % objArr.length;
        this.f59526a[length] = j3;
        objArr[length] = obj;
        this.f59529d = i4 + 1;
    }

    private Object d() {
        b1.b(this.f59529d > 0);
        Object[] objArr = this.f59527b;
        int i3 = this.f59528c;
        Object obj = objArr[i3];
        objArr[i3] = null;
        this.f59528c = (i3 + 1) % objArr.length;
        this.f59529d--;
        return obj;
    }

    public synchronized void a(long j3, Object obj) {
        a(j3);
        b();
        b(j3, obj);
    }

    public synchronized Object c() {
        return this.f59529d == 0 ? null : d();
    }

    public synchronized int e() {
        return this.f59529d;
    }

    public eo(int i3) {
        this.f59526a = new long[i3];
        this.f59527b = a(i3);
    }

    public synchronized Object c(long j3) {
        return a(j3, true);
    }

    public synchronized void a() {
        this.f59528c = 0;
        this.f59529d = 0;
        Arrays.fill(this.f59527b, (Object) null);
    }

    private void b() {
        int length = this.f59527b.length;
        if (this.f59529d < length) {
            return;
        }
        int i3 = length * 2;
        long[] jArr = new long[i3];
        Object[] objArrA = a(i3);
        int i4 = this.f59528c;
        int i5 = length - i4;
        System.arraycopy(this.f59526a, i4, jArr, 0, i5);
        System.arraycopy(this.f59527b, this.f59528c, objArrA, 0, i5);
        int i6 = this.f59528c;
        if (i6 > 0) {
            System.arraycopy(this.f59526a, 0, jArr, i5, i6);
            System.arraycopy(this.f59527b, 0, objArrA, i5, this.f59528c);
        }
        this.f59526a = jArr;
        this.f59527b = objArrA;
        this.f59528c = 0;
    }

    private void a(long j3) {
        if (this.f59529d > 0) {
            if (j3 <= this.f59526a[((this.f59528c + r0) - 1) % this.f59527b.length]) {
                a();
            }
        }
    }

    private static Object[] a(int i3) {
        return new Object[i3];
    }

    private Object a(long j3, boolean z2) {
        Object objD = null;
        long j4 = Long.MAX_VALUE;
        while (this.f59529d > 0) {
            long j5 = j3 - this.f59526a[this.f59528c];
            if (j5 < 0 && (z2 || (-j5) >= j4)) {
                break;
            }
            objD = d();
            j4 = j5;
        }
        return objD;
    }

    public synchronized Object b(long j3) {
        return a(j3, false);
    }
}
