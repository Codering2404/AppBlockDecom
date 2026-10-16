package com.facebook.ads.redexgen.core;

import android.R;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class PQ extends AbstractRunnableC1135Wc {
    public final /* synthetic */ AnimationAnimationListenerC1202Yu A00;

    public PQ(AnimationAnimationListenerC1202Yu animationAnimationListenerC1202Yu) {
        this.A00 = animationAnimationListenerC1202Yu;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1135Wc
    public final void A07() {
        this.A00.A00.finish(3);
        this.A00.A00.A05().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
