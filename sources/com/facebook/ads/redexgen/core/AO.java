package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AO implements C5Y {
    public InterfaceC04795t A02;
    public InterfaceC1879kj<String> A03;
    public String A04;
    public boolean A05;
    public boolean A06;
    public final C04745o A07 = new C04745o();
    public int A00 = 8000;
    public int A01 = 8000;

    public final AO A00(InterfaceC04795t interfaceC04795t) {
        this.A02 = interfaceC04795t;
        return this;
    }

    public final AO A01(String str) {
        this.A04 = str;
        return this;
    }

    @Override // com.facebook.ads.redexgen.core.C5Y
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final C03701k A5I() {
        C03701k c03701k = new C03701k(this.A04, this.A00, this.A01, this.A05, this.A07, this.A03, this.A06);
        if (this.A02 != null) {
            c03701k.A43(this.A02);
        }
        return c03701k;
    }
}
