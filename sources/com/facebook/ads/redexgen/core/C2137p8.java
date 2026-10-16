package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.p8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2137p8 implements C5Y {
    public final InterfaceC04795t A00;

    public C2137p8() {
        this(null);
    }

    public C2137p8(InterfaceC04795t interfaceC04795t) {
        this.A00 = interfaceC04795t;
    }

    @Override // com.facebook.ads.redexgen.core.C5Y
    public final InterfaceC2144pF A5I() {
        C03691j c03691j = new C03691j();
        if (this.A00 != null) {
            c03691j.A43(this.A00);
        }
        return c03691j;
    }
}
