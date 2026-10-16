package com.github.mikephil.charting.animation;

import android.animation.ValueAnimator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ChartAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f68250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected float f68251b = 1.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected float f68252c = 1.0f;

    public ChartAnimator(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f68250a = animatorUpdateListener;
    }

    public float a() {
        return this.f68252c;
    }

    public float b() {
        return this.f68251b;
    }
}
