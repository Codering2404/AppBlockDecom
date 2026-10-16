package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1679hD implements XN {
    public final /* synthetic */ int A00;
    public final /* synthetic */ C1678hC A01;

    public C1679hD(C1678hC c1678hC, int i3) {
        this.A01 = c1678hC;
        this.A00 = i3;
    }

    @Override // com.facebook.ads.redexgen.core.XN
    public final void ADS() {
        this.A01.A0C.A0F().ABa();
    }

    @Override // com.facebook.ads.redexgen.core.XN
    public final void AFV(float f3) {
        float f4 = 1.0f - (f3 / this.A00);
        if (this.A01.A0G != null) {
            this.A01.A0G.setProgressWithAnimation(100.0f * f4);
        }
    }
}
