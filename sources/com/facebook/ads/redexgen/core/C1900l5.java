package com.facebook.ads.redexgen.core;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.l5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1900l5 implements L8 {
    public final C04544u A00 = new C04544u(new byte[4]);
    public final /* synthetic */ C1898l3 A01;

    public C1900l5(C1898l3 c1898l3) {
        this.A01 = c1898l3;
    }

    @Override // com.facebook.ads.redexgen.core.L8
    public final void A5A(C04554v c04554v) {
        int tableId = c04554v.A0I();
        if (tableId != 0) {
            return;
        }
        int tableId2 = c04554v.A0I();
        if ((tableId2 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
            return;
        }
        c04554v.A0g(6);
        int iA07 = c04554v.A07() / 4;
        for (int i3 = 0; i3 < iA07; i3++) {
            c04554v.A0h(this.A00, 4);
            int programCount = this.A00.A04(16);
            this.A00.A09(3);
            if (programCount == 0) {
                this.A00.A09(13);
            } else {
                int iA04 = this.A00.A04(13);
                if (this.A01.A0B.get(iA04) == null) {
                    this.A01.A0B.put(iA04, new C1904l9(new C1899l4(this.A01, iA04)));
                    C1898l3.A02(this.A01);
                }
            }
        }
        int secondHeaderByte = this.A01.A09;
        if (secondHeaderByte != 2) {
            this.A01.A0B.remove(0);
        }
    }

    @Override // com.facebook.ads.redexgen.core.L8
    public final void AAA(AnonymousClass53 anonymousClass53, HA ha, LG lg) {
    }
}
