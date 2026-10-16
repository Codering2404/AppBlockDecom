package com.facebook.ads.redexgen.core;

import com.facebook.ads.internal.protocol.AdErrorType;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1782iz extends AbstractRunnableC1135Wc {
    public final /* synthetic */ C1835jz A00;
    public final /* synthetic */ O8 A01;
    public final /* synthetic */ C05217j A02;

    public C1782iz(C05217j c05217j, O8 o8, C1835jz c1835jz) {
        this.A02 = c05217j;
        this.A01 = o8;
        this.A00 = c1835jz;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        this.A02.A0T(this.A01);
        this.A02.A0Q(this.A00);
        this.A02.A00 = null;
        C1120Vm c1120VmA00 = C1120Vm.A00(AdErrorType.INTERSTITIAL_AD_TIMEOUT);
        this.A02.A0B.A0F().A5g(c1120VmA00.A03().getErrorCode(), c1120VmA00.A04());
        this.A02.A07.A0G(c1120VmA00);
    }
}
