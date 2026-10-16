package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.h8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1674h8 extends WP {
    public final /* synthetic */ C1671h5 A00;
    public final /* synthetic */ C1120Vm A01;

    public C1674h8(C1671h5 c1671h5, C1120Vm c1120Vm) {
        this.A00 = c1671h5;
        this.A01 = c1120Vm;
    }

    @Override // com.facebook.ads.redexgen.core.WP
    public final void A01() {
        if (this.A00.A01.A00() != null) {
            this.A00.A01.A00().onAdError(XE.A00(this.A01));
        }
    }
}
