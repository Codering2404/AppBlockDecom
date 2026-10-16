package com.applovin.impl;

import android.util.SparseBooleanArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class a9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseBooleanArray f58220a;

    private a9(SparseBooleanArray sparseBooleanArray) {
        this.f58220a = sparseBooleanArray;
    }

    public boolean a(int i3) {
        return this.f58220a.get(i3);
    }

    public int b(int i3) {
        b1.a(i3, 0, a());
        return this.f58220a.keyAt(i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a9)) {
            return false;
        }
        a9 a9Var = (a9) obj;
        if (xp.f65027a >= 24) {
            return this.f58220a.equals(a9Var.f58220a);
        }
        if (a() != a9Var.a()) {
            return false;
        }
        for (int i3 = 0; i3 < a(); i3++) {
            if (b(i3) != a9Var.b(i3)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (xp.f65027a >= 24) {
            return this.f58220a.hashCode();
        }
        int iA = a();
        for (int i3 = 0; i3 < a(); i3++) {
            iA = (iA * 31) + b(i3);
        }
        return iA;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SparseBooleanArray f58221a = new SparseBooleanArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f58222b;

        public b a(int i3) {
            b1.b(!this.f58222b);
            this.f58221a.append(i3, true);
            return this;
        }

        public b a(a9 a9Var) {
            for (int i3 = 0; i3 < a9Var.a(); i3++) {
                a(a9Var.b(i3));
            }
            return this;
        }

        public b a(int... iArr) {
            for (int i3 : iArr) {
                a(i3);
            }
            return this;
        }

        public b a(int i3, boolean z2) {
            return z2 ? a(i3) : this;
        }

        public a9 a() {
            b1.b(!this.f58222b);
            this.f58222b = true;
            return new a9(this.f58221a);
        }
    }

    public boolean a(int... iArr) {
        for (int i3 : iArr) {
            if (a(i3)) {
                return true;
            }
        }
        return false;
    }

    public int a() {
        return this.f58220a.size();
    }
}
