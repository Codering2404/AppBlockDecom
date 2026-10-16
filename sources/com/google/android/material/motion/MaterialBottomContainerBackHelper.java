package com.google.android.material.motion;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MaterialBottomContainerBackHelper extends MaterialBackAnimationHelper<View> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f81345g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f81346h;

    public MaterialBottomContainerBackHelper(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f81345g = resources.getDimension(R.dimen.f79580n);
        this.f81346h = resources.getDimension(R.dimen.f79582o);
    }

    private Animator g() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f81334b, (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.f81334b, (Property<View, Float>) View.SCALE_Y, 1.0f));
        View view = this.f81334b;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i3), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setInterpolator(new FastOutSlowInInterpolator());
        return animatorSet;
    }

    public void f() {
        if (super.b() == null) {
            return;
        }
        Animator animatorG = g();
        animatorG.setDuration(this.f81337e);
        animatorG.start();
    }

    public void h(BackEventCompat backEventCompat, Animator.AnimatorListener animatorListener) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f81334b, (Property<View, Float>) View.TRANSLATION_Y, this.f81334b.getHeight() * this.f81334b.getScaleY());
        objectAnimatorOfFloat.setInterpolator(new FastOutSlowInInterpolator());
        objectAnimatorOfFloat.setDuration(AnimationUtils.c(this.f81335c, this.f81336d, backEventCompat.a()));
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.motion.MaterialBottomContainerBackHelper.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                MaterialBottomContainerBackHelper.this.f81334b.setTranslationY(0.0f);
                MaterialBottomContainerBackHelper.this.k(0.0f);
            }
        });
        if (animatorListener != null) {
            objectAnimatorOfFloat.addListener(animatorListener);
        }
        objectAnimatorOfFloat.start();
    }

    public void i(BackEventCompat backEventCompat, Animator.AnimatorListener animatorListener) {
        Animator animatorG = g();
        animatorG.setDuration(AnimationUtils.c(this.f81335c, this.f81336d, backEventCompat.a()));
        if (animatorListener != null) {
            animatorG.addListener(animatorListener);
        }
        animatorG.start();
    }

    public void j(BackEventCompat backEventCompat) {
        super.d(backEventCompat);
    }

    public void k(float f3) {
        float fA = a(f3);
        float width = this.f81334b.getWidth();
        float height = this.f81334b.getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            return;
        }
        float f4 = this.f81345g / width;
        float f5 = this.f81346h / height;
        float fA2 = 1.0f - AnimationUtils.a(0.0f, f4, fA);
        float fA3 = 1.0f - AnimationUtils.a(0.0f, f5, fA);
        this.f81334b.setScaleX(fA2);
        this.f81334b.setPivotY(height);
        this.f81334b.setScaleY(fA3);
        View view = this.f81334b;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                View childAt = viewGroup.getChildAt(i3);
                childAt.setPivotY(-childAt.getTop());
                childAt.setScaleY(fA3 != 0.0f ? fA2 / fA3 : 1.0f);
            }
        }
    }

    public void l(BackEventCompat backEventCompat) {
        if (super.e(backEventCompat) == null) {
            return;
        }
        k(backEventCompat.a());
    }
}
