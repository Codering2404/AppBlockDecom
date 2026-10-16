package com.facebook.ads.redexgen.core;

import android.widget.FrameLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0741Gp implements InterfaceC1187Yf {
    public final /* synthetic */ AbstractC0735Gj A00;

    public C0741Gp(AbstractC0735Gj abstractC0735Gj) {
        this.A00 = abstractC0735Gj;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1187Yf
    public final void AEZ(int i3) {
        this.A00.A0d();
        if (this.A00.A01 != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = i3;
            this.A00.A01.setLayoutParams(layoutParams);
        }
    }
}
