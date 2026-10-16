package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1956lz implements JY {
    public long A00 = -1;
    public long A01 = -1;
    public HI A02;
    public HJ A03;

    public C1956lz(HJ hj, HI hi) {
        this.A03 = hj;
        this.A02 = hi;
    }

    public final void A00(long j3) {
        this.A00 = j3;
    }

    @Override // com.facebook.ads.redexgen.core.JY
    public final HY A5Z() {
        AbstractC04323y.A08(this.A00 != -1);
        return new C1996mp(this.A03, this.A00);
    }

    @Override // com.facebook.ads.redexgen.core.JY
    public final long AHN(InterfaceC1999ms interfaceC1999ms) {
        if (this.A01 < 0) {
            return -1L;
        }
        long result = -(this.A01 + 2);
        this.A01 = -1L;
        return result;
    }

    @Override // com.facebook.ads.redexgen.core.JY
    public final void AKC(long j3) {
        long[] jArr = this.A02.A01;
        this.A01 = jArr[C5C.A0L(jArr, j3, true, true)];
    }
}
