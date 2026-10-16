package com.google.android.material.motion;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.RoundedCorner;
import android.view.View;
import android.view.WindowInsets;
import androidx.activity.BackEventCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.ViewUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MaterialMainContainerBackHelper extends MaterialBackAnimationHelper<View> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f81348g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f81349h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f81350i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Rect f81351j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Rect f81352k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Integer f81353l;

    private ValueAnimator h(final ClippableRoundedCornerLayout clippableRoundedCornerLayout) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(clippableRoundedCornerLayout.getCornerRadius(), k());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.motion.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                clippableRoundedCornerLayout.e(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return valueAnimatorOfFloat;
    }

    private AnimatorSet i(final View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f81334b, (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.f81334b, (Property<View, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.f81334b, (Property<View, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(this.f81334b, (Property<View, Float>) View.TRANSLATION_Y, 0.0f));
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.motion.MaterialMainContainerBackHelper.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                View view2 = view;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
            }
        });
        return animatorSet;
    }

    private int n() {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 31 || (rootWindowInsets = this.f81334b.getRootWindowInsets()) == null) {
            return 0;
        }
        return Math.max(Math.max(o(rootWindowInsets, 0), o(rootWindowInsets, 1)), Math.max(o(rootWindowInsets, 3), o(rootWindowInsets, 2)));
    }

    private int o(WindowInsets windowInsets, int i3) {
        RoundedCorner roundedCorner = windowInsets.getRoundedCorner(i3);
        if (roundedCorner != null) {
            return roundedCorner.getRadius();
        }
        return 0;
    }

    private boolean p() {
        int[] iArr = new int[2];
        this.f81334b.getLocationOnScreen(iArr);
        return iArr[1] == 0;
    }

    private void q() {
        this.f81350i = 0.0f;
        this.f81351j = null;
        this.f81352k = null;
    }

    public void g(View view) {
        if (super.b() == null) {
            return;
        }
        AnimatorSet animatorSetI = i(view);
        View view2 = this.f81334b;
        if (view2 instanceof ClippableRoundedCornerLayout) {
            animatorSetI.playTogether(h((ClippableRoundedCornerLayout) view2));
        }
        animatorSetI.setDuration(this.f81337e);
        animatorSetI.start();
        q();
    }

    public void j(long j3, View view) {
        AnimatorSet animatorSetI = i(view);
        animatorSetI.setDuration(j3);
        animatorSetI.start();
        q();
    }

    public int k() {
        if (this.f81353l == null) {
            this.f81353l = Integer.valueOf(p() ? n() : 0);
        }
        return this.f81353l.intValue();
    }

    public Rect l() {
        return this.f81352k;
    }

    public Rect m() {
        return this.f81351j;
    }

    public void r(float f3, View view) {
        this.f81351j = ViewUtils.d(this.f81334b);
        if (view != null) {
            this.f81352k = ViewUtils.c(this.f81334b, view);
        }
        this.f81350i = f3;
    }

    public void s(BackEventCompat backEventCompat, View view) {
        super.d(backEventCompat);
        r(backEventCompat.c(), view);
    }

    public void t(float f3, boolean z2, float f4, float f5) {
        float fA = a(f3);
        float width = this.f81334b.getWidth();
        float height = this.f81334b.getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            return;
        }
        float fA2 = AnimationUtils.a(1.0f, 0.9f, fA);
        float fA3 = AnimationUtils.a(0.0f, Math.max(0.0f, ((width - (0.9f * width)) / 2.0f) - this.f81348g), fA) * (z2 ? 1 : -1);
        float fMin = Math.min(Math.max(0.0f, ((height - (fA2 * height)) / 2.0f) - this.f81348g), this.f81349h);
        float f6 = f4 - this.f81350i;
        float fA4 = AnimationUtils.a(0.0f, fMin, Math.abs(f6) / height) * Math.signum(f6);
        this.f81334b.setScaleX(fA2);
        this.f81334b.setScaleY(fA2);
        this.f81334b.setTranslationX(fA3);
        this.f81334b.setTranslationY(fA4);
        View view = this.f81334b;
        if (view instanceof ClippableRoundedCornerLayout) {
            ((ClippableRoundedCornerLayout) view).e(AnimationUtils.a(k(), f5, fA));
        }
    }

    public void u(BackEventCompat backEventCompat, View view, float f3) {
        if (super.e(backEventCompat) == null) {
            return;
        }
        if (view != null && view.getVisibility() != 4) {
            view.setVisibility(4);
        }
        t(backEventCompat.a(), backEventCompat.b() == 0, backEventCompat.c(), f3);
    }
}
