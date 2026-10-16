package com.facebook.ads.redexgen.core;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class DR implements InterfaceC1562fK {
    public int A00;
    public ValueAnimator A01;
    public EnumC1561fJ A02 = EnumC1561fJ.A04;
    public final int A03;
    public final int A04;
    public final View A05;

    public DR(View view, int i3, int i4, int i5) {
        this.A05 = view;
        this.A03 = i3;
        this.A00 = i4;
        this.A04 = i5;
    }

    private ValueAnimator A00(int i3, int i4, View view) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i3, i4);
        valueAnimatorOfInt.setDuration(this.A03);
        valueAnimatorOfInt.addUpdateListener(new C1565fN(this, view));
        return valueAnimatorOfInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(boolean z2) {
        if (z2) {
            this.A02 = EnumC1561fJ.A05;
            this.A01 = A00(this.A00, this.A04, this.A05);
            this.A01.addListener(new C1564fM(this));
            this.A01.start();
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.A05.getLayoutParams();
        layoutParams.height = this.A04;
        this.A05.setLayoutParams(layoutParams);
        YB.A0H(this.A05);
        this.A02 = EnumC1561fJ.A04;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A08(boolean z2) {
        YB.A0L(this.A05);
        if (z2) {
            this.A02 = EnumC1561fJ.A03;
            this.A01 = A00(this.A04, this.A00, this.A05);
            this.A01.addListener(new C1563fL(this));
            this.A01.start();
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.A05.getLayoutParams();
        layoutParams.height = this.A00;
        this.A05.setLayoutParams(layoutParams);
        this.A02 = EnumC1561fJ.A02;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1562fK
    public final void A4A(boolean z2, boolean z3) {
        if (z3) {
            A07(z2);
        } else {
            A08(z2);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1562fK
    public final EnumC1561fJ A9B() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1562fK
    public final void cancel() {
        if (this.A01 != null) {
            this.A01.cancel();
        }
    }
}
