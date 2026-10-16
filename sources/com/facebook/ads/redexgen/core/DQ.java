package com.facebook.ads.redexgen.core;

import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class DQ implements InterfaceC1562fK {
    public ViewPropertyAnimator A00;
    public EnumC1561fJ A01 = EnumC1561fJ.A04;
    public final int A02;
    public final View A03;
    public final boolean A04;

    public DQ(View view, int i3, boolean z2) {
        this.A02 = i3;
        this.A03 = view;
        this.A04 = z2;
    }

    private void A04(boolean z2) {
        this.A01 = EnumC1561fJ.A03;
        if (this.A04) {
            YB.A0L(this.A03);
        }
        if (!z2) {
            this.A03.setAlpha(1.0f);
            this.A01 = EnumC1561fJ.A02;
        } else {
            this.A00 = this.A03.animate().alpha(1.0f).setDuration(this.A02).setListener(new C1566fO(this));
        }
    }

    private void A05(boolean z2) {
        this.A01 = EnumC1561fJ.A05;
        if (!z2) {
            this.A03.setAlpha(0.0f);
            this.A01 = EnumC1561fJ.A04;
        } else {
            this.A00 = this.A03.animate().alpha(0.0f).setDuration(this.A02).setListener(new C1567fP(this));
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1562fK
    public final void A4A(boolean z2, boolean z3) {
        if (z3) {
            A05(z2);
        } else {
            A04(z2);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1562fK
    public final EnumC1561fJ A9B() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1562fK
    public final void cancel() {
        this.A03.clearAnimation();
        if (this.A00 != null) {
            this.A00.cancel();
        }
    }
}
