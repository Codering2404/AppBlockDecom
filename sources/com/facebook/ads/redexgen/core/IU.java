package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class IU implements XN {
    public final /* synthetic */ C5S A00;

    public IU(C5S c5s) {
        this.A00 = c5s;
    }

    @Override // com.facebook.ads.redexgen.core.XN
    public final void ADS() {
        this.A00.A0P.ADc(this.A00.A0F);
        this.A00.A0P.ADA();
    }

    @Override // com.facebook.ads.redexgen.core.XN
    public final void AFV(float f3) {
        int i3;
        float totalForce = (this.A00.A0F - f3) + (this.A00.A0d ? 0 : this.A00.A0S.getDuration());
        if (this.A00.A0d) {
            i3 = this.A00.A0F;
        } else {
            i3 = this.A00.A0E;
        }
        float seenTime = i3;
        this.A00.A0P.AKd(totalForce / seenTime);
    }
}
