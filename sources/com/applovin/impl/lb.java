package com.applovin.impl;

import com.applovin.impl.ij;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class lb implements ij {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long[] f61185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f61186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f61187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f61188d;

    public lb(long[] jArr, long[] jArr2, long j3) {
        b1.a(jArr.length == jArr2.length);
        int length = jArr2.length;
        boolean z2 = length > 0;
        this.f61188d = z2;
        if (!z2 || jArr2[0] <= 0) {
            this.f61185a = jArr;
            this.f61186b = jArr2;
        } else {
            int i3 = length + 1;
            long[] jArr3 = new long[i3];
            this.f61185a = jArr3;
            long[] jArr4 = new long[i3];
            this.f61186b = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.f61187c = j3;
    }

    @Override // com.applovin.impl.ij
    public ij.a b(long j3) {
        if (!this.f61188d) {
            return new ij.a(kj.f61037c);
        }
        int iB = xp.b(this.f61186b, j3, true, true);
        kj kjVar = new kj(this.f61186b[iB], this.f61185a[iB]);
        if (kjVar.f61038a == j3 || iB == this.f61186b.length - 1) {
            return new ij.a(kjVar);
        }
        int i3 = iB + 1;
        return new ij.a(kjVar, new kj(this.f61186b[i3], this.f61185a[i3]));
    }

    @Override // com.applovin.impl.ij
    public long d() {
        return this.f61187c;
    }

    @Override // com.applovin.impl.ij
    public boolean b() {
        return this.f61188d;
    }
}
