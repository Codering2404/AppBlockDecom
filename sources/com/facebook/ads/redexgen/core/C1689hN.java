package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1689hN extends WP {
    public final /* synthetic */ C1688hM A00;

    public C1689hN(C1688hM c1688hM) {
        this.A00 = c1688hM;
    }

    @Override // com.facebook.ads.redexgen.core.WP
    public final void A01() {
        if (this.A00.A01.A06() != null) {
            this.A00.A01.A06().onLoggingImpression(this.A00.A01.A07());
        }
    }
}
