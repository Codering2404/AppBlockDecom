package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class W2 implements InterfaceC1304b8 {
    public final /* synthetic */ C1132Vz A00;

    public W2(C1132Vz c1132Vz) {
        this.A00 = c1132Vz;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1304b8
    public final void AE7(C1303b7 c1303b7) {
        this.A00.A0G.set(c1303b7.A00() != null);
        if (this.A00.A0H.get() && this.A00.A05 != null) {
            this.A00.A05.AFB(c1303b7.A00() != null);
        }
    }
}
