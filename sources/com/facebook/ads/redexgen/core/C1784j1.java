package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.j1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1784j1 extends AbstractRunnableC1135Wc {
    public final /* synthetic */ AbstractC1783j0 A00;
    public final /* synthetic */ C1120Vm A01;

    public C1784j1(AbstractC1783j0 abstractC1783j0, C1120Vm c1120Vm) {
        this.A00 = abstractC1783j0;
        this.A01 = c1120Vm;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        this.A00.A0B.A0F().A5g(this.A01.A03().getErrorCode(), this.A01.A04());
        if (this.A00.A07 != null) {
            this.A00.A07.A0G(this.A01);
        }
    }
}
