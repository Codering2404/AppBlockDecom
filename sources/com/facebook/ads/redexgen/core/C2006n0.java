package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.n0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2006n0 implements HY {
    public final long A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final InterfaceC0749Gx A06;

    public C2006n0(InterfaceC0749Gx interfaceC0749Gx, long j3, long j4, long j5, long j6, long j7, long j8) {
        this.A06 = interfaceC0749Gx;
        this.A03 = j3;
        this.A05 = j4;
        this.A02 = j5;
        this.A04 = j6;
        this.A01 = j7;
        this.A00 = j8;
    }

    public final long A05(long j3) {
        return this.A06.AKQ(j3);
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final long A7t() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final HX A91(long j3) {
        return new HX(new HZ(j3, C0748Gw.A05(this.A06.AKQ(j3), this.A05, this.A02, this.A04, this.A01, this.A00)));
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final boolean AAj() {
        return true;
    }
}
