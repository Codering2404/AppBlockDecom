package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FadeThroughUpdateListener implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f81195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f81196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float[] f81197c = new float[2];

    public FadeThroughUpdateListener(View view, View view2) {
        this.f81195a = view;
        this.f81196b = view2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        FadeThroughUtils.a(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.f81197c);
        View view = this.f81195a;
        if (view != null) {
            view.setAlpha(this.f81197c[0]);
        }
        View view2 = this.f81196b;
        if (view2 != null) {
            view2.setAlpha(this.f81197c[1]);
        }
    }
}
