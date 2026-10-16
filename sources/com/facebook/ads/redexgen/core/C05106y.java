package com.facebook.ads.redexgen.core;

import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6y, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C05106y implements InterfaceC1078Tv {
    public NativeAdBase A00;
    public NativeAdListener A01;

    public C05106y(NativeAdListener nativeAdListener, NativeAdBase nativeAdBase) {
        this.A01 = nativeAdListener;
        this.A00 = nativeAdBase;
    }

    @Override // com.facebook.ads.redexgen.core.VP
    public final void ACm() {
        WT.A00(new C1073Tq(this));
    }

    @Override // com.facebook.ads.redexgen.core.VP
    public final void ACq() {
        WT.A00(new C1074Tr(this));
    }

    @Override // com.facebook.ads.redexgen.core.VP
    public final void ADp(C1120Vm c1120Vm) {
        WT.A00(new C1076Tt(this, c1120Vm));
    }

    @Override // com.facebook.ads.redexgen.core.VP
    public final void AEl() {
        WT.A00(new C1072Tp(this));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1078Tv
    public final void AEq() {
        WT.A00(new C1075Ts(this));
    }
}
