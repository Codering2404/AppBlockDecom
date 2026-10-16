package com.google.android.material.internal;

import android.animation.TimeInterpolator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ReversableAnimatedValueInterpolator implements TimeInterpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TimeInterpolator f81254a;

    public ReversableAnimatedValueInterpolator(TimeInterpolator timeInterpolator) {
        this.f81254a = timeInterpolator;
    }

    public static TimeInterpolator a(boolean z2, TimeInterpolator timeInterpolator) {
        return z2 ? timeInterpolator : new ReversableAnimatedValueInterpolator(timeInterpolator);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f3) {
        return 1.0f - this.f81254a.getInterpolation(f3);
    }
}
