package com.applovin.impl;

import android.util.Pair;
import com.applovin.impl.ij;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class jf implements lj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long[] f60742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f60743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f60744c;

    private jf(long[] jArr, long[] jArr2, long j3) {
        this.f60742a = jArr;
        this.f60743b = jArr2;
        this.f60744c = j3 == -9223372036854775807L ? t2.a(jArr2[jArr2.length - 1]) : j3;
    }

    public static jf a(long j3, Cif cif, long j4) {
        int length = cif.f60444f.length;
        int i3 = length + 1;
        long[] jArr = new long[i3];
        long[] jArr2 = new long[i3];
        jArr[0] = j3;
        long j5 = 0;
        jArr2[0] = 0;
        for (int i4 = 1; i4 <= length; i4++) {
            int i5 = i4 - 1;
            j3 += (long) (cif.f60442c + cif.f60444f[i5]);
            j5 += (long) (cif.f60443d + cif.f60445g[i5]);
            jArr[i4] = j3;
            jArr2[i4] = j5;
        }
        return new jf(jArr, jArr2, j4);
    }

    @Override // com.applovin.impl.ij
    public boolean b() {
        return true;
    }

    @Override // com.applovin.impl.lj
    public long c() {
        return -1L;
    }

    @Override // com.applovin.impl.ij
    public long d() {
        return this.f60744c;
    }

    @Override // com.applovin.impl.ij
    public ij.a b(long j3) {
        Pair pairA = a(t2.b(xp.b(j3, 0L, this.f60744c)), this.f60743b, this.f60742a);
        return new ij.a(new kj(t2.a(((Long) pairA.first).longValue()), ((Long) pairA.second).longValue()));
    }

    @Override // com.applovin.impl.lj
    public long a(long j3) {
        return t2.a(((Long) a(j3, this.f60742a, this.f60743b).second).longValue());
    }

    private static Pair a(long j3, long[] jArr, long[] jArr2) {
        int iB = xp.b(jArr, j3, true, true);
        long j4 = jArr[iB];
        long j5 = jArr2[iB];
        int i3 = iB + 1;
        if (i3 == jArr.length) {
            return Pair.create(Long.valueOf(j4), Long.valueOf(j5));
        }
        return Pair.create(Long.valueOf(j3), Long.valueOf(((long) ((jArr[i3] == j4 ? 0.0d : (j3 - j4) / (r6 - j4)) * (jArr2[i3] - j5))) + j5));
    }
}
