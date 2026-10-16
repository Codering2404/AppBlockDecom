package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0733Gh implements InterfaceC1468dm {
    public final /* synthetic */ int A00;
    public final /* synthetic */ C0730Ge A01;

    public C0733Gh(C0730Ge c0730Ge, int i3) {
        this.A01 = c0730Ge;
        this.A00 = i3;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1468dm
    public final void ACQ() {
        this.A01.A0G();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1468dm
    public final void ADA() {
        this.A01.A0X(false, this.A00);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1468dm
    public final void ADc(int i3) {
        C0730Ge.A03(this.A01, i3);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1468dm
    public final void ADw(float f3) {
        if (!this.A01.A08) {
            this.A01.A0L(f3);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1468dm
    public final void AFw(boolean z2) {
        this.A01.A0W(z2);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1468dm
    public final void AGQ(String str) {
        this.A01.A0D.A0F().A3a(str);
        if (this.A01.A0A.A2H() && this.A01.A00 < this.A01.A0A.A23()) {
            this.A01.A0D.A0F().AC2();
            this.A01.A0X(false, this.A00);
        } else {
            this.A01.A0I.A4j(this.A01.A0J.A81());
            this.A01.A0M(3);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1468dm
    public final void AKc() {
        this.A01.setUnskippableSecondsComplete(false);
        this.A01.A0H.setProgressImmediate(0.0f);
        this.A01.A0H.setToolbarActionMode(2);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1468dm
    public final void AKd(float f3) {
        this.A01.A0H.setProgress(100.0f * f3);
    }
}
