package com.facebook.ads.redexgen.core;

import android.text.TextUtils;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class H8 extends AbstractC1592fo {
    public final /* synthetic */ AbstractC0735Gj A00;

    public H8(AbstractC0735Gj abstractC0735Gj) {
        this.A00 = abstractC0735Gj;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1592fo
    public final void A03() {
        if (!this.A00.A08.A07()) {
            this.A00.A08.A05();
            if (!TextUtils.isEmpty(this.A00.A03.A2E())) {
                this.A00.A06.ABJ(this.A00.A03.A2E(), new C1305b9().A03(this.A00.A0C).A02(this.A00.A08).A04(this.A00.A03.A0z()).A05());
                if (this.A00.A03.A1u()) {
                    this.A00.A05.A0F().AEW();
                }
                C1144Wl.A00(this.A00.A05).A0E(this.A00.A0B.A8l(), this.A00.A03.A2E());
                C0912Ng.A07(this.A00.A03.A2A(), this.A00.A05);
                this.A00.A05.A0F().A3L();
                AbstractC0932Oa.A02(this.A00.A03.A0y(), AbstractC1168Xm.A00(this.A00.A03.A10()));
                this.A00.A0A.A4j(this.A00.A0B.A8G());
            }
        }
    }
}
