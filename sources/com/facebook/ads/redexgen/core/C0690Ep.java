package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ep, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0690Ep extends AbstractRunnableC1135Wc {
    public final /* synthetic */ int A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ C0685Ek A02;

    public C0690Ep(C0685Ek c0685Ek, int i3, int i4) {
        this.A02 = c0685Ek;
        this.A00 = i3;
        this.A01 = i4;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        this.A02.A0C.A02(new C0673Dy(this.A00, this.A01));
    }
}
