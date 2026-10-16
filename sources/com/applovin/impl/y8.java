package com.applovin.impl;

import com.applovin.impl.ij;
import com.applovin.impl.z8;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class y8 implements ij {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z8 f65168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f65169b;

    public y8(z8 z8Var, long j3) {
        this.f65168a = z8Var;
        this.f65169b = j3;
    }

    private kj a(long j3, long j4) {
        return new kj((j3 * 1000000) / ((long) this.f65168a.f65392e), this.f65169b + j4);
    }

    @Override // com.applovin.impl.ij
    public boolean b() {
        return true;
    }

    @Override // com.applovin.impl.ij
    public long d() {
        return this.f65168a.b();
    }

    @Override // com.applovin.impl.ij
    public ij.a b(long j3) {
        b1.b(this.f65168a.f65398k);
        z8 z8Var = this.f65168a;
        z8.a aVar = z8Var.f65398k;
        long[] jArr = aVar.f65400a;
        long[] jArr2 = aVar.f65401b;
        int iB = xp.b(jArr, z8Var.a(j3), true, false);
        kj kjVarA = a(iB == -1 ? 0L : jArr[iB], iB != -1 ? jArr2[iB] : 0L);
        if (kjVarA.f61038a == j3 || iB == jArr.length - 1) {
            return new ij.a(kjVarA);
        }
        int i3 = iB + 1;
        return new ij.a(kjVarA, a(jArr[i3], jArr2[i3]));
    }
}
