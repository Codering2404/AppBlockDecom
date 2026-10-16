package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MultiViewUpdateListener implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Listener f81208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View[] f81209b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Listener {
        void a(ValueAnimator valueAnimator, View view);
    }

    public MultiViewUpdateListener(Listener listener, View... viewArr) {
        this.f81208a = listener;
        this.f81209b = viewArr;
    }

    public static MultiViewUpdateListener e(View... viewArr) {
        return new MultiViewUpdateListener(new Listener() { // from class: com.google.android.material.internal.d
            @Override // com.google.android.material.internal.MultiViewUpdateListener.Listener
            public final void a(ValueAnimator valueAnimator, View view) {
                MultiViewUpdateListener.g(valueAnimator, view);
            }
        }, viewArr);
    }

    public static MultiViewUpdateListener f(View... viewArr) {
        return new MultiViewUpdateListener(new Listener() { // from class: com.google.android.material.internal.c
            @Override // com.google.android.material.internal.MultiViewUpdateListener.Listener
            public final void a(ValueAnimator valueAnimator, View view) {
                MultiViewUpdateListener.h(valueAnimator, view);
            }
        }, viewArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(ValueAnimator valueAnimator, View view) {
        view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(ValueAnimator valueAnimator, View view) {
        Float f3 = (Float) valueAnimator.getAnimatedValue();
        view.setScaleX(f3.floatValue());
        view.setScaleY(f3.floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(ValueAnimator valueAnimator, View view) {
        view.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(ValueAnimator valueAnimator, View view) {
        view.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static MultiViewUpdateListener k(View... viewArr) {
        return new MultiViewUpdateListener(new Listener() { // from class: com.google.android.material.internal.a
            @Override // com.google.android.material.internal.MultiViewUpdateListener.Listener
            public final void a(ValueAnimator valueAnimator, View view) {
                MultiViewUpdateListener.i(valueAnimator, view);
            }
        }, viewArr);
    }

    public static MultiViewUpdateListener l(View... viewArr) {
        return new MultiViewUpdateListener(new Listener() { // from class: com.google.android.material.internal.b
            @Override // com.google.android.material.internal.MultiViewUpdateListener.Listener
            public final void a(ValueAnimator valueAnimator, View view) {
                MultiViewUpdateListener.j(valueAnimator, view);
            }
        }, viewArr);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        for (View view : this.f81209b) {
            this.f81208a.a(valueAnimator, view);
        }
    }
}
