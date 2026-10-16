package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ni, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2050ni implements InterfaceC0700Ez {
    public long A00;
    public long A01;
    public C2050ni A02;
    public C0699Ey A03;

    public C2050ni(long j3, int i3) {
        A02(j3, i3);
    }

    public final int A00(long j3) {
        return ((int) (j3 - this.A01)) + this.A03.A00;
    }

    public final C2050ni A01() {
        this.A03 = null;
        C2050ni c2050ni = this.A02;
        this.A02 = null;
        return c2050ni;
    }

    public final void A02(long j3, int i3) {
        AbstractC04323y.A08(this.A03 == null);
        this.A01 = j3;
        this.A00 = ((long) i3) + j3;
    }

    public final void A03(C0699Ey c0699Ey, C2050ni c2050ni) {
        this.A03 = c0699Ey;
        this.A02 = c2050ni;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0700Ez
    public final C0699Ey A6u() {
        return (C0699Ey) AbstractC04323y.A01(this.A03);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0700Ez
    public final C2050ni ACc() {
        if (this.A02 == null || this.A02.A03 == null) {
            return null;
        }
        return this.A02;
    }
}
