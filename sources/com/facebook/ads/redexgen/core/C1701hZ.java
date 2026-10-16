package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hZ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1701hZ extends R7 {
    public boolean A00 = false;
    public final /* synthetic */ AbstractC1696hU A01;

    public C1701hZ(AbstractC1696hU abstractC1696hU) {
        this.A01 = abstractC1696hU;
    }

    @Override // com.facebook.ads.redexgen.core.R7
    public final void A0L(C7M c7m, int i3) {
        super.A0L(c7m, i3);
        if (i3 == 0 && this.A00) {
            this.A00 = false;
            this.A01.A0F();
        }
    }

    @Override // com.facebook.ads.redexgen.core.R7
    public final void A0M(C7M c7m, int i3, int i4) {
        if (i3 != 0 || i4 != 0) {
            this.A00 = true;
        }
    }
}
