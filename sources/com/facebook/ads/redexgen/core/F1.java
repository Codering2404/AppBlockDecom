package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class F1 extends AbstractRunnableC1135Wc {
    public final /* synthetic */ C0695Eu A00;

    public F1(C0695Eu c0695Eu) {
        this.A00 = c0695Eu;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        this.A00.A03.A07();
        this.A00.A04.getEventBus().A04(this.A00.A06, this.A00.A05);
    }
}
