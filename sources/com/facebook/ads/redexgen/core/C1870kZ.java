package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kZ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1870kZ implements InterfaceC0878Lx {
    public final InterfaceC0875Lu A00;

    public C1870kZ(InterfaceC0875Lu interfaceC0875Lu) {
        this.A00 = interfaceC0875Lu;
    }

    public final InterfaceC0875Lu A00() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0878Lx
    public final C8J ACL() {
        return new C8J(this);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0878Lx
    public final C1874kd ACM() {
        return new C1874kd(this);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0878Lx
    public final C1874kd ACN(String str) {
        return new C1874kd(this, str);
    }
}
