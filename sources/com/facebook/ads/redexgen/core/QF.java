package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class QF implements InterfaceC1173Xr {
    public final C1172Xq A00;
    public final InterfaceC1173Xr A01;

    public QF(InterfaceC1173Xr interfaceC1173Xr, int i3, int i4) {
        this.A01 = interfaceC1173Xr;
        this.A00 = new C1172Xq(i3, i4);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1173Xr
    public final void AH8(String str) {
        this.A00.A04(str);
        if (this.A00.A02() != null && AbstractC1175Xt.A08(this.A00)) {
            this.A01.AH8(this.A00.A02());
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1173Xr
    public final void flush() {
        this.A00.A03();
        while (this.A00.A02() != null) {
            if (AbstractC1175Xt.A08(this.A00)) {
                this.A01.AH8(this.A00.A02());
            }
            this.A00.A03();
        }
    }
}
