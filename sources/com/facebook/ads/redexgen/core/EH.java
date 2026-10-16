package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class EH extends AbstractC0935Od {
    public final /* synthetic */ EF A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EH(EF ef, double d3, double d4, double d5, boolean z2) {
        super(d3, d4, d5, z2);
        this.A00 = ef;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0935Od
    public final void A00(boolean z2, boolean z3, C0937Of c0937Of) {
        if ((!C1098Up.A0z(this.A00.A0D) || !this.A00.A09) && z3) {
            this.A00.A09 = true;
            this.A00.A0R(this.A00.A0J, this.A00.A0J(EnumC1526ek.A03));
        }
    }
}
