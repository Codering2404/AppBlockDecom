package com.github.mikephil.charting.jobs;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AnimatedViewPortJob extends ViewPortJob implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected ObjectAnimator f68593j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected float f68594k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected float f68595l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected float f68596m;

    public AnimatedViewPortJob(ViewPortHandler viewPortHandler, float f3, float f4, Transformer transformer, View view, float f5, float f6, long j3) {
        super(viewPortHandler, f3, f4, transformer, view);
        this.f68595l = f5;
        this.f68596m = f6;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "phase", 0.0f, 1.0f);
        this.f68593j = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(j3);
        this.f68593j.addUpdateListener(this);
        this.f68593j.addListener(this);
    }

    public abstract void b();

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        try {
            b();
        } catch (IllegalArgumentException unused) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        try {
            b();
        } catch (IllegalArgumentException unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f68593j.start();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
    }
}
