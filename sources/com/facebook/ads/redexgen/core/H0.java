package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class H0 implements XN {
    public final /* synthetic */ int A00;
    public final /* synthetic */ AbstractRunnableC1135Wc A01;
    public final /* synthetic */ AbstractC0735Gj A02;
    public final /* synthetic */ DZ A03;

    public H0(AbstractC0735Gj abstractC0735Gj, int i3, DZ dz, AbstractRunnableC1135Wc abstractRunnableC1135Wc) {
        this.A02 = abstractC0735Gj;
        this.A00 = i3;
        this.A03 = dz;
        this.A01 = abstractRunnableC1135Wc;
    }

    @Override // com.facebook.ads.redexgen.core.XN
    public final void ADS() throws Throwable {
        this.A01.run();
    }

    @Override // com.facebook.ads.redexgen.core.XN
    public final void AFV(float f3) {
        this.A02.A09.setProgress(100.0f * (1.0f - (f3 / this.A00)));
        if (this.A03 != null) {
            DZ dz = this.A03;
            float percentage = this.A00;
            dz.A07((int) ((percentage - f3) * 1000.0f));
        }
    }
}
