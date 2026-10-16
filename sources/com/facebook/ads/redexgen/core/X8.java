package com.facebook.ads.redexgen.core;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class X8 implements Interpolator {
    public final float A00;

    public X8(float f3) {
        this.A00 = f3;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f3) {
        return (float) (1.0d - Math.pow(1.0f - f3, this.A00));
    }
}
