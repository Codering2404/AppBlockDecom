package com.facebook.ads.redexgen.core;

import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8P, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class C8P extends AbstractC2128oz implements InterfaceC0812Jj {
    public long A00;
    public InterfaceC0812Jj A01;

    @Override // com.facebook.ads.redexgen.core.AbstractC2128oz
    public abstract void A0B();

    @Override // com.facebook.ads.redexgen.core.AbstractC04805u
    public final void A0A() {
        super.A0A();
        this.A01 = null;
    }

    public final void A0C(long j3, InterfaceC0812Jj interfaceC0812Jj, long j4) {
        super.A01 = j3;
        this.A01 = interfaceC0812Jj;
        if (j4 == Long.MAX_VALUE) {
            j4 = super.A01;
        }
        this.A00 = j4;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0812Jj
    public final List<C2158pT> A7X(long j3) {
        return ((InterfaceC0812Jj) AbstractC04323y.A01(this.A01)).A7X(j3 - this.A00);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0812Jj
    public final long A83(int i3) {
        return ((InterfaceC0812Jj) AbstractC04323y.A01(this.A01)).A83(i3) + this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0812Jj
    public final int A84() {
        return ((InterfaceC0812Jj) AbstractC04323y.A01(this.A01)).A84();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0812Jj
    public final int A8a(long j3) {
        return ((InterfaceC0812Jj) AbstractC04323y.A01(this.A01)).A8a(j3 - this.A00);
    }
}
