package com.facebook.ads.redexgen.core;

import android.view.animation.Interpolator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class InterpolatorC0995Qp implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f3) {
        float f4 = f3 - 1.0f;
        return (f4 * f4 * f4 * f4 * f4) + 1.0f;
    }
}
