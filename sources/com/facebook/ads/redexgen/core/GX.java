package com.facebook.ads.redexgen.core;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class GX extends AbstractRunnableC1135Wc {
    public final /* synthetic */ InterfaceC1470dp A00;
    public final /* synthetic */ C1471dq A01;

    public GX(C1471dq c1471dq, InterfaceC1470dp interfaceC1470dp) {
        this.A01 = c1471dq;
        this.A00 = interfaceC1470dp;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setAnimationListener(new GY(this));
        this.A01.startAnimation(alphaAnimation);
    }
}
