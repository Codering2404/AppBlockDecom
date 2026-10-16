package com.applovin.impl;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class f2 implements g8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final oo f59612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final int f59613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int[] f59614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f59615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final e9[] f59616e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long[] f59617f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f59618g;

    public f2(oo ooVar, int[] iArr, int i3) {
        int i4 = 0;
        b1.b(iArr.length > 0);
        this.f59615d = i3;
        this.f59612a = (oo) b1.a(ooVar);
        int length = iArr.length;
        this.f59613b = length;
        this.f59616e = new e9[length];
        for (int i5 = 0; i5 < iArr.length; i5++) {
            this.f59616e[i5] = ooVar.a(iArr[i5]);
        }
        Arrays.sort(this.f59616e, new Comparator() { // from class: com.applovin.impl.bv
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return f2.a((e9) obj, (e9) obj2);
            }
        });
        this.f59614c = new int[this.f59613b];
        while (true) {
            int i6 = this.f59613b;
            if (i4 >= i6) {
                this.f59617f = new long[i6];
                return;
            } else {
                this.f59614c[i4] = ooVar.a(this.f59616e[i4]);
                i4++;
            }
        }
    }

    @Override // com.applovin.impl.g8
    public void a(float f3) {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            f2 f2Var = (f2) obj;
            if (this.f59612a == f2Var.f59612a && Arrays.equals(this.f59614c, f2Var.f59614c)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.applovin.impl.g8
    public final e9 g() {
        return this.f59616e[h()];
    }

    public int hashCode() {
        if (this.f59618g == 0) {
            this.f59618g = (System.identityHashCode(this.f59612a) * 31) + Arrays.hashCode(this.f59614c);
        }
        return this.f59618g;
    }

    @Override // com.applovin.impl.so
    public final e9 a(int i3) {
        return this.f59616e[i3];
    }

    @Override // com.applovin.impl.so
    public final int b(int i3) {
        return this.f59614c[i3];
    }

    @Override // com.applovin.impl.so
    public final oo a() {
        return this.f59612a;
    }

    @Override // com.applovin.impl.so
    public final int b() {
        return this.f59614c.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(e9 e9Var, e9 e9Var2) {
        return e9Var2.f59390i - e9Var.f59390i;
    }

    @Override // com.applovin.impl.g8
    public void f() {
    }

    @Override // com.applovin.impl.g8
    public void i() {
    }
}
