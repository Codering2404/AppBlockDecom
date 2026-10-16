package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.m1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1958m1 implements HY {
    public final /* synthetic */ C1957m0 A00;

    public C1958m1(C1957m0 c1957m0) {
        this.A00 = c1957m0;
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final long A7t() {
        return this.A00.A0B.A05(this.A00.A07);
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final HX A91(long j3) {
        long jA06 = this.A00.A0B.A06(j3);
        long j4 = this.A00.A09;
        long j5 = this.A00.A08;
        long targetGranule = this.A00.A09;
        long j6 = (j5 - targetGranule) * jA06;
        long targetGranule2 = this.A00.A07;
        long estimatedPosition = C5C.A0T((j4 + (j6 / targetGranule2)) - 30000, this.A00.A09, this.A00.A08 - 1);
        return new HX(new HZ(j3, estimatedPosition));
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final boolean AAj() {
        return true;
    }
}
