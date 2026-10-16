package com.facebook.ads.redexgen.core;

import com.facebook.ads.internal.protocol.AdErrorType;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.k4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1840k4 implements SM {
    public final /* synthetic */ int A00;
    public final /* synthetic */ AnonymousClass81 A01;
    public final /* synthetic */ AnonymousClass81 A02;
    public final /* synthetic */ C1080Tx A03;

    public C1840k4(AnonymousClass81 anonymousClass81, int i3, C1080Tx c1080Tx, AnonymousClass81 anonymousClass812) {
        this.A01 = anonymousClass81;
        this.A00 = i3;
        this.A03 = c1080Tx;
        this.A02 = anonymousClass812;
    }

    @Override // com.facebook.ads.redexgen.core.SM
    public final void ACx() {
        this.A01.A0C(this.A00, this.A03);
    }

    @Override // com.facebook.ads.redexgen.core.SM
    public final void ACy() {
        this.A01.A00.AEN(this.A02, C1120Vm.A00(AdErrorType.NO_FILL));
    }
}
