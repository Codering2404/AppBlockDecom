package com.facebook.ads.redexgen.core;

import com.facebook.ads.CacheFlag;
import java.util.EnumSet;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7j, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C05217j extends AbstractC1783j0 {
    public C05217j(C1648gi c1648gi, O7 o7) {
        super(c1648gi, o7);
    }

    private C1781iy A00(Runnable runnable) {
        return new C1781iy(this, runnable);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1783j0
    public final NQ A0I() {
        C1835jz successfullyLoadedAdapter = (C1835jz) this.A01;
        if (successfullyLoadedAdapter != null) {
            return successfullyLoadedAdapter.A09();
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1783j0
    public final void A0P() {
        C1835jz interstitialAdapter = (C1835jz) this.A01;
        interstitialAdapter.A0B();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1783j0
    public final void A0R(N1 n12, C1079Tw c1079Tw, C1077Tu c1077Tu, O8 o8) {
        C1835jz c1835jz = (C1835jz) n12;
        C1782iz c1782iz = new C1782iz(this, o8, c1835jz);
        A0H().postDelayed(c1782iz, c1079Tw.A05().A05());
        EnumSet<CacheFlag> enumSet = this.A08.A0B;
        if (enumSet == null) {
            enumSet = CacheFlag.ALL;
        }
        c1835jz.A0A(this.A0B, A00(c1782iz), o8, enumSet, this.A08.A04, this.A08.A05, this.A08.A02);
    }
}
