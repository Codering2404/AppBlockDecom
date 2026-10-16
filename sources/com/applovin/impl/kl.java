package com.applovin.impl;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class kl implements nl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a5[] f61042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f61043b;

    public kl(a5[] a5VarArr, long[] jArr) {
        this.f61042a = a5VarArr;
        this.f61043b = jArr;
    }

    @Override // com.applovin.impl.nl
    public long a(int i3) {
        b1.a(i3 >= 0);
        b1.a(i3 < this.f61043b.length);
        return this.f61043b[i3];
    }

    @Override // com.applovin.impl.nl
    public List b(long j3) {
        a5 a5Var;
        int iB = xp.b(this.f61043b, j3, true, false);
        return (iB == -1 || (a5Var = this.f61042a[iB]) == a5.f58171s) ? Collections.EMPTY_LIST : Collections.singletonList(a5Var);
    }

    @Override // com.applovin.impl.nl
    public int a() {
        return this.f61043b.length;
    }

    @Override // com.applovin.impl.nl
    public int a(long j3) {
        int iA = xp.a(this.f61043b, j3, false, false);
        if (iA < this.f61043b.length) {
            return iA;
        }
        return -1;
    }
}
