package com.facebook.ads.redexgen.core;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class DA implements InterfaceC1562fK {
    public ValueAnimator A00;
    public EnumC1561fJ A01 = EnumC1561fJ.A04;
    public final int A02;
    public final int A03;
    public final int A04;
    public final View A05;

    public DA(View view, int i3, int i4, int i5) {
        this.A05 = view;
        this.A02 = i3;
        this.A04 = i4;
        this.A03 = i5;
    }

    private ValueAnimator A00(View view, int i3, int i4) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i3, i4);
        valueAnimatorOfInt.setDuration(this.A02);
        valueAnimatorOfInt.addUpdateListener(new C1571fT(this, view));
        return valueAnimatorOfInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04() {
        if (this.A00 != null) {
            this.A00.removeAllListeners();
            this.A00 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A08(boolean z2) {
        if (z2) {
            this.A01 = EnumC1561fJ.A05;
            this.A00 = A00(this.A05, this.A03, this.A04);
            this.A00.addListener(new C1570fS(this));
            this.A00.start();
            return;
        }
        this.A05.setTranslationY(this.A04);
        YB.A0H(this.A05);
        this.A01 = EnumC1561fJ.A04;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09(boolean z2) {
        YB.A0L(this.A05);
        if (z2) {
            this.A01 = EnumC1561fJ.A03;
            this.A00 = A00(this.A05, this.A04, this.A03);
            this.A00.addListener(new C1569fR(this));
            this.A00.start();
            return;
        }
        this.A05.setTranslationY(this.A03);
        this.A01 = EnumC1561fJ.A02;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1562fK
    public final void A4A(boolean z2, boolean z3) {
        if (z3) {
            A08(z2);
        } else {
            A09(z2);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1562fK
    public final EnumC1561fJ A9B() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1562fK
    public final void cancel() {
        if (this.A00 != null) {
            this.A00.cancel();
        }
    }
}
