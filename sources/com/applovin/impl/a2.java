package com.applovin.impl;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a2 implements h5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f58148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList f58149b = new ArrayList(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f58150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private k5 f58151d;

    protected a2(boolean z2) {
        this.f58148a = z2;
    }

    @Override // com.applovin.impl.h5
    public final void a(xo xoVar) {
        b1.a(xoVar);
        if (this.f58149b.contains(xoVar)) {
            return;
        }
        this.f58149b.add(xoVar);
        this.f58150c++;
    }

    protected final void b(k5 k5Var) {
        for (int i3 = 0; i3 < this.f58150c; i3++) {
            ((xo) this.f58149b.get(i3)).b(this, k5Var, this.f58148a);
        }
    }

    protected final void c(k5 k5Var) {
        this.f58151d = k5Var;
        for (int i3 = 0; i3 < this.f58150c; i3++) {
            ((xo) this.f58149b.get(i3)).a(this, k5Var, this.f58148a);
        }
    }

    protected final void d(int i3) {
        k5 k5Var = (k5) xp.a(this.f58151d);
        for (int i4 = 0; i4 < this.f58150c; i4++) {
            ((xo) this.f58149b.get(i4)).a(this, k5Var, this.f58148a, i3);
        }
    }

    protected final void g() {
        k5 k5Var = (k5) xp.a(this.f58151d);
        for (int i3 = 0; i3 < this.f58150c; i3++) {
            ((xo) this.f58149b.get(i3)).c(this, k5Var, this.f58148a);
        }
        this.f58151d = null;
    }
}
