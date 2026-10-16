package com.applovin.impl;

import com.applovin.impl.ij;
import com.applovin.impl.sf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class pq implements lj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long[] f62476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f62477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f62478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f62479d;

    private pq(long[] jArr, long[] jArr2, long j3, long j4) {
        this.f62476a = jArr;
        this.f62477b = jArr2;
        this.f62478c = j3;
        this.f62479d = j4;
    }

    public static pq a(long j3, long j4, sf.a aVar, ah ahVar) {
        int iW;
        ahVar.g(10);
        int iJ = ahVar.j();
        pq pqVar = null;
        if (iJ <= 0) {
            return null;
        }
        int i3 = aVar.f63705d;
        long jC = xp.c(iJ, ((long) (i3 >= 32000 ? 1152 : 576)) * 1000000, i3);
        int iC = ahVar.C();
        int iC2 = ahVar.C();
        int iC3 = ahVar.C();
        ahVar.g(2);
        long j5 = j4 + ((long) aVar.f63704c);
        long[] jArr = new long[iC];
        long[] jArr2 = new long[iC];
        int i4 = 0;
        long j6 = j4;
        while (i4 < iC) {
            pq pqVar2 = pqVar;
            int i5 = iC2;
            long[] jArr3 = jArr;
            jArr3[i4] = (((long) i4) * jC) / ((long) iC);
            jArr2[i4] = Math.max(j6, j5);
            if (iC3 == 1) {
                iW = ahVar.w();
            } else if (iC3 == 2) {
                iW = ahVar.C();
            } else if (iC3 == 3) {
                iW = ahVar.z();
            } else {
                if (iC3 != 4) {
                    return pqVar2;
                }
                iW = ahVar.A();
            }
            j6 += (long) (iW * i5);
            i4++;
            pqVar = pqVar2;
            iC2 = i5;
            jArr = jArr3;
        }
        long[] jArr4 = jArr;
        if (j3 != -1 && j3 != j6) {
            oc.d("VbriSeeker", "VBRI data size mismatch: " + j3 + ", " + j6);
        }
        return new pq(jArr4, jArr2, jC, j6);
    }

    @Override // com.applovin.impl.ij
    public boolean b() {
        return true;
    }

    @Override // com.applovin.impl.lj
    public long c() {
        return this.f62479d;
    }

    @Override // com.applovin.impl.ij
    public long d() {
        return this.f62478c;
    }

    @Override // com.applovin.impl.ij
    public ij.a b(long j3) {
        int iB = xp.b(this.f62476a, j3, true, true);
        kj kjVar = new kj(this.f62476a[iB], this.f62477b[iB]);
        if (kjVar.f61038a >= j3 || iB == this.f62476a.length - 1) {
            return new ij.a(kjVar);
        }
        int i3 = iB + 1;
        return new ij.a(kjVar, new kj(this.f62476a[i3], this.f62477b[i3]));
    }

    @Override // com.applovin.impl.lj
    public long a(long j3) {
        return this.f62476a[xp.b(this.f62477b, j3, true, true)];
    }
}
