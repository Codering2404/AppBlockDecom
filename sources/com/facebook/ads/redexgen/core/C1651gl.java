package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1651gl extends AbstractRunnableC1135Wc {
    public final /* synthetic */ CallableC1049Ss A00;
    public final /* synthetic */ C1050St A01;
    public final /* synthetic */ C1054Sx A02;

    public C1651gl(CallableC1049Ss callableC1049Ss, C1054Sx c1054Sx, C1050St c1050St) {
        this.A00 = callableC1049Ss;
        this.A02 = c1054Sx;
        this.A01 = c1050St;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        this.A00.A03(this.A01);
    }
}
