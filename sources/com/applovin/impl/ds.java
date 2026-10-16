package com.applovin.impl;

import com.applovin.impl.ij;
import com.applovin.impl.sf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class ds implements lj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f59298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f59299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f59300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f59301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f59302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long[] f59303f;

    private ds(long j3, int i3, long j4) {
        this(j3, i3, j4, -1L, null);
    }

    public static ds a(long j3, long j4, sf.a aVar, ah ahVar) {
        int iA;
        int i3 = aVar.f63708g;
        int i4 = aVar.f63705d;
        int iJ = ahVar.j();
        if ((iJ & 1) != 1 || (iA = ahVar.A()) == 0) {
            return null;
        }
        long jC = xp.c(iA, ((long) i3) * 1000000, i4);
        if ((iJ & 6) != 6) {
            return new ds(j4, aVar.f63704c, jC);
        }
        long jY = ahVar.y();
        long[] jArr = new long[100];
        for (int i5 = 0; i5 < 100; i5++) {
            jArr[i5] = ahVar.w();
        }
        if (j3 != -1) {
            long j5 = j4 + jY;
            if (j3 != j5) {
                oc.d("XingSeeker", "XING data size mismatch: " + j3 + ", " + j5);
            }
        }
        return new ds(j4, aVar.f63704c, jC, jY, jArr);
    }

    @Override // com.applovin.impl.ij
    public ij.a b(long j3) {
        if (!b()) {
            return new ij.a(new kj(0L, this.f59298a + ((long) this.f59299b)));
        }
        long jB = xp.b(j3, 0L, this.f59300c);
        double d3 = (jB * 100.0d) / this.f59300c;
        double d4 = 0.0d;
        if (d3 > 0.0d) {
            if (d3 >= 100.0d) {
                d4 = 256.0d;
            } else {
                int i3 = (int) d3;
                double d5 = ((long[]) b1.b(this.f59303f))[i3];
                d4 = d5 + ((d3 - ((double) i3)) * ((i3 == 99 ? 256.0d : r3[i3 + 1]) - d5));
            }
        }
        return new ij.a(new kj(jB, this.f59298a + xp.b(Math.round((d4 / 256.0d) * this.f59301d), this.f59299b, this.f59301d - 1)));
    }

    @Override // com.applovin.impl.lj
    public long c() {
        return this.f59302e;
    }

    @Override // com.applovin.impl.ij
    public long d() {
        return this.f59300c;
    }

    private ds(long j3, int i3, long j4, long j5, long[] jArr) {
        this.f59298a = j3;
        this.f59299b = i3;
        this.f59300c = j4;
        this.f59303f = jArr;
        this.f59301d = j5;
        this.f59302e = j5 != -1 ? j3 + j5 : -1L;
    }

    @Override // com.applovin.impl.ij
    public boolean b() {
        return this.f59303f != null;
    }

    @Override // com.applovin.impl.lj
    public long a(long j3) {
        long j4 = j3 - this.f59298a;
        if (!b() || j4 <= this.f59299b) {
            return 0L;
        }
        long[] jArr = (long[]) b1.b(this.f59303f);
        double d3 = (j4 * 256.0d) / this.f59301d;
        int iB = xp.b(jArr, (long) d3, true, true);
        long jA = a(iB);
        long j5 = jArr[iB];
        int i3 = iB + 1;
        long jA2 = a(i3);
        return jA + Math.round((j5 == (iB == 99 ? 256L : jArr[i3]) ? 0.0d : (d3 - j5) / (r0 - j5)) * (jA2 - jA));
    }

    private long a(int i3) {
        return (this.f59300c * ((long) i3)) / 100;
    }
}
