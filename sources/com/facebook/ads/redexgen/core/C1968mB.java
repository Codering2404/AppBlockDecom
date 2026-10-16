package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mB, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1968mB implements InterfaceC0800Ix {
    public int A00;
    public int A01;
    public final int A02;
    public final int A03;
    public final C04554v A04;

    public C1968mB(C1970mD c1970mD) {
        this.A04 = c1970mD.A00;
        this.A04.A0f(12);
        this.A02 = this.A04.A0L() & 255;
        this.A03 = this.A04.A0L();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0800Ix
    public final int A8A() {
        return -1;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0800Ix
    public final int A8v() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0800Ix
    public final int AHS() {
        if (this.A02 == 8) {
            return this.A04.A0I();
        }
        if (this.A02 == 16) {
            return this.A04.A0M();
        }
        int i3 = this.A01;
        this.A01 = i3 + 1;
        if (i3 % 2 == 0) {
            this.A00 = this.A04.A0I();
            return (this.A00 & 240) >> 4;
        }
        return this.A00 & 15;
    }
}
