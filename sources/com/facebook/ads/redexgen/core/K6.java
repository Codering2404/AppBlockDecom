package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class K6 extends AbstractRunnableC1135Wc {
    public final /* synthetic */ C0811Ji A00;
    public final /* synthetic */ boolean A01;

    public K6(C0811Ji c0811Ji, boolean z2) {
        this.A00 = c0811Ji;
        this.A01 = z2;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        AbstractC1183Yb abstractC1183YbA0B = this.A00.A0b.A0B();
        if (abstractC1183YbA0B == null) {
            return;
        }
        abstractC1183YbA0B.setPageDetailsVisible((this.A01 || abstractC1183YbA0B.A0E()) ? false : true);
        abstractC1183YbA0B.setToolbarActionMode(this.A00.getCloseButtonStyle());
    }
}
