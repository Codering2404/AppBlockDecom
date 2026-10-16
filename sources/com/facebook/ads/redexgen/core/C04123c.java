package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3c, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C04123c extends AbstractC0668Dt {
    public final /* synthetic */ C0656Dh A00;

    public C04123c(C0656Dh c0656Dh) {
        this.A00 = c0656Dh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.UN
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(C0669Du c0669Du) {
        if (this.A00.A01 == null || c0669Du.A00().getAction() != 0) {
            return;
        }
        this.A00.A04.removeCallbacksAndMessages(null);
        this.A00.A07(new C1549f7(this));
    }
}
