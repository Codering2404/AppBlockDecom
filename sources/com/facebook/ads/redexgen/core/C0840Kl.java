package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0840Kl extends AbstractRunnableC1135Wc {
    public final /* synthetic */ AbstractC1333bb A00;

    public C0840Kl(AbstractC1333bb abstractC1333bb) {
        this.A00 = abstractC1333bb;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        this.A00.setPressed(false);
        this.A00.postOnAnimationDelayed(this.A00.A09, this.A00.A08);
    }
}
