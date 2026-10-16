package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class KY implements XN {
    public final /* synthetic */ C6K A00;

    public KY(C6K c6k) {
        this.A00 = c6k;
    }

    @Override // com.facebook.ads.redexgen.core.XN
    public final void ADS() {
        this.A00.A02 = false;
        if (this.A00.A07 != null) {
            this.A00.A07.setToolbarActionMode(this.A00.getCloseButtonStyle());
        }
    }

    @Override // com.facebook.ads.redexgen.core.XN
    public final void AFV(float f3) {
        if (this.A00.A07 != null) {
            this.A00.A07.setProgressImmediate(100.0f * (1.0f - (f3 / this.A00.getAdInfo().A0K().A00())));
        }
    }
}
