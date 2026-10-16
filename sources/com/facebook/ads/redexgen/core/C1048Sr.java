package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1048Sr extends AbstractRunnableC1135Wc {
    public final /* synthetic */ long A00;
    public final /* synthetic */ WA A01;
    public final /* synthetic */ WD A02;
    public final /* synthetic */ String A03;

    public C1048Sr(WD wd, String str, long j3, WA wa) {
        this.A02 = wd;
        this.A03 = str;
        this.A00 = j3;
        this.A01 = wa;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        this.A02.A0N(this.A03, this.A00, this.A01);
    }
}
