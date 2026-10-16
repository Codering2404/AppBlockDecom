package com.applovin.impl;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class qk {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final q4 f62646c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SparseArray f62645b = new SparseArray();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f62644a = -1;

    public qk(q4 q4Var) {
        this.f62646c = q4Var;
    }

    public void a(int i3, Object obj) {
        if (this.f62644a == -1) {
            b1.b(this.f62645b.size() == 0);
            this.f62644a = 0;
        }
        if (this.f62645b.size() > 0) {
            SparseArray sparseArray = this.f62645b;
            int iKeyAt = sparseArray.keyAt(sparseArray.size() - 1);
            b1.a(i3 >= iKeyAt);
            if (iKeyAt == i3) {
                q4 q4Var = this.f62646c;
                SparseArray sparseArray2 = this.f62645b;
                q4Var.accept(sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.f62645b.append(i3, obj);
    }

    public void b(int i3) {
        int i4 = 0;
        while (i4 < this.f62645b.size() - 1) {
            int i5 = i4 + 1;
            if (i3 < this.f62645b.keyAt(i5)) {
                return;
            }
            this.f62646c.accept(this.f62645b.valueAt(i4));
            this.f62645b.removeAt(i4);
            int i6 = this.f62644a;
            if (i6 > 0) {
                this.f62644a = i6 - 1;
            }
            i4 = i5;
        }
    }

    public Object c(int i3) {
        if (this.f62644a == -1) {
            this.f62644a = 0;
        }
        while (true) {
            int i4 = this.f62644a;
            if (i4 <= 0 || i3 >= this.f62645b.keyAt(i4)) {
                break;
            }
            this.f62644a--;
        }
        while (this.f62644a < this.f62645b.size() - 1 && i3 >= this.f62645b.keyAt(this.f62644a + 1)) {
            this.f62644a++;
        }
        return this.f62645b.valueAt(this.f62644a);
    }

    public Object b() {
        return this.f62645b.valueAt(r0.size() - 1);
    }

    public boolean c() {
        return this.f62645b.size() == 0;
    }

    public void a() {
        for (int i3 = 0; i3 < this.f62645b.size(); i3++) {
            this.f62646c.accept(this.f62645b.valueAt(i3));
        }
        this.f62644a = -1;
        this.f62645b.clear();
    }

    public void a(int i3) {
        for (int size = this.f62645b.size() - 1; size >= 0 && i3 < this.f62645b.keyAt(size); size--) {
            this.f62646c.accept(this.f62645b.valueAt(size));
            this.f62645b.removeAt(size);
        }
        this.f62644a = this.f62645b.size() > 0 ? Math.min(this.f62644a, this.f62645b.size() - 1) : -1;
    }
}
