package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0704Fd implements InterfaceC1016Rk {
    public final /* synthetic */ C1010Re A00;
    public final /* synthetic */ C4T A01;

    public C0704Fd(C4T c4t, C1010Re c1010Re) {
        this.A01 = c4t;
        this.A00 = c1010Re;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1016Rk
    public final boolean AAI() {
        if (!this.A01.A0i()) {
            if (this.A01.A0j()) {
                return true;
            }
            return this.A01.A0k();
        }
        this.A01.A0h(this.A00);
        return true;
    }
}
