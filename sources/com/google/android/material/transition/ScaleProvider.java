package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class ScaleProvider implements VisibilityAnimatorProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f82668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f82669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f82670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f82671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f82672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f82673f;

    private static Animator c(final View view, float f3, float f4) {
        final float scaleX = view.getScaleX();
        final float scaleY = view.getScaleY();
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, scaleX * f3, scaleX * f4), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, f3 * scaleY, f4 * scaleY));
        objectAnimatorOfPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transition.ScaleProvider.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setScaleX(scaleX);
                view.setScaleY(scaleY);
            }
        });
        return objectAnimatorOfPropertyValuesHolder;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public Animator a(ViewGroup viewGroup, View view) {
        if (this.f82673f) {
            return this.f82672e ? c(view, this.f82668a, this.f82669b) : c(view, this.f82671d, this.f82670c);
        }
        return null;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public Animator b(ViewGroup viewGroup, View view) {
        return this.f82672e ? c(view, this.f82670c, this.f82671d) : c(view, this.f82669b, this.f82668a);
    }
}
