package com.applovin.impl;

import com.applovin.impl.ij;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class g3 implements ij {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f59857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f59858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f59859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long[] f59860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long[] f59861e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f59862f;

    public g3(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f59858b = iArr;
        this.f59859c = jArr;
        this.f59860d = jArr2;
        this.f59861e = jArr3;
        int length = iArr.length;
        this.f59857a = length;
        if (length <= 0) {
            this.f59862f = 0L;
        } else {
            int i3 = length - 1;
            this.f59862f = jArr2[i3] + jArr3[i3];
        }
    }

    @Override // com.applovin.impl.ij
    public boolean b() {
        return true;
    }

    public int c(long j3) {
        return xp.b(this.f59861e, j3, true, true);
    }

    @Override // com.applovin.impl.ij
    public long d() {
        return this.f59862f;
    }

    public String toString() {
        return "ChunkIndex(length=" + this.f59857a + ", sizes=" + Arrays.toString(this.f59858b) + ", offsets=" + Arrays.toString(this.f59859c) + ", timeUs=" + Arrays.toString(this.f59861e) + ", durationsUs=" + Arrays.toString(this.f59860d) + ")";
    }

    @Override // com.applovin.impl.ij
    public ij.a b(long j3) {
        int iC = c(j3);
        kj kjVar = new kj(this.f59861e[iC], this.f59859c[iC]);
        if (kjVar.f61038a >= j3 || iC == this.f59857a - 1) {
            return new ij.a(kjVar);
        }
        int i3 = iC + 1;
        return new ij.a(kjVar, new kj(this.f59861e[i3], this.f59859c[i3]));
    }
}
