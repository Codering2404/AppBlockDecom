package com.facebook.ads.redexgen.core;

import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1910lF implements L8 {
    public C2208qI A00;
    public AnonymousClass53 A01;
    public InterfaceC0755Hd A02;

    public C1910lF(String str) {
        this.A00 = new C03992p().A11(str).A14();
    }

    @EnsuresNonNull({"timestampAdjuster", "output"})
    private void A00() {
        AbstractC04323y.A02(this.A01);
    }

    @Override // com.facebook.ads.redexgen.core.L8
    public final void A5A(C04554v c04554v) {
        A00();
        long jA03 = this.A01.A03();
        long jA04 = this.A01.A04();
        if (jA03 == -9223372036854775807L || jA04 == -9223372036854775807L) {
            return;
        }
        if (jA04 != this.A00.A0M) {
            this.A00 = this.A00.A07().A0s(jA04).A14();
            this.A02.A6e(this.A00);
        }
        int iA07 = c04554v.A07();
        this.A02.AIr(c04554v, iA07);
        this.A02.AIu(jA03, 1, iA07, 0, null);
    }

    @Override // com.facebook.ads.redexgen.core.L8
    public final void AAA(AnonymousClass53 anonymousClass53, HA ha, LG lg) {
        this.A01 = anonymousClass53;
        lg.A05();
        this.A02 = ha.AKS(lg.A03(), 5);
        this.A02.A6e(this.A00);
    }
}
