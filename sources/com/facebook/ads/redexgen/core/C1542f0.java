package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.f0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1542f0 implements InterfaceC1059Tc {
    public final T8 A00;

    public C1542f0(T8 t8) {
        this.A00 = t8;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1059Tc
    public final void A4I(Throwable th) {
        TX.A0E(th);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1059Tc
    public final void AA3(String str) {
        VL.A08(this.A00, str);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1059Tc
    public final void AA4(String str) {
        VL.A09(this.A00, str);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1059Tc
    public final void ABC(String str, int i3, C1061Te c1061Te) {
        TX.A06(this.A00, str, i3, c1061Te);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1059Tc
    public final void ABD(String str, int i3, C1061Te c1061Te) {
        TX.A06(this.A00, str, i3, c1061Te);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1059Tc
    public final void ABo(long j3, long j4, long j5, long j6, int i3, Exception exc) {
        AbstractC1065Ti.A03(this.A00, j3, j4, j5, j6, i3, exc);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1059Tc
    public final void ABz(String str, int i3, C1061Te c1061Te) {
        TX.A07(this.A00, str, i3, c1061Te);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1059Tc
    public final void ACA(String str, int i3, C1061Te c1061Te) {
        TX.A08(this.A00, str, i3, c1061Te);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1059Tc
    public final void ACP() {
        this.A00.A04().ACP();
    }
}
