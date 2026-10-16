package com.google.android.material.motion;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MaterialSideContainerBackHelper extends MaterialBackAnimationHelper<View> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f81356g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f81357h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f81358i;

    public MaterialSideContainerBackHelper(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f81356g = resources.getDimension(R.dimen.f79586q);
        this.f81357h = resources.getDimension(R.dimen.f79584p);
        this.f81358i = resources.getDimension(R.dimen.f79588r);
    }

    private boolean g(int i3, int i4) {
        return (GravityCompat.b(i3, ViewCompat.y(this.f81334b)) & i4) == i4;
    }

    private int i(boolean z2) {
        ViewGroup.LayoutParams layoutParams = this.f81334b.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return 0;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return z2 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
    }

    public void f() {
        if (super.b() == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f81334b, (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.f81334b, (Property<View, Float>) View.SCALE_Y, 1.0f));
        View view = this.f81334b;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i3), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setDuration(this.f81337e);
        animatorSet.start();
    }

    public void h(BackEventCompat backEventCompat, final int i3, Animator.AnimatorListener animatorListener, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        final boolean z2 = backEventCompat.b() == 0;
        boolean zG = g(i3, 3);
        float width = (this.f81334b.getWidth() * this.f81334b.getScaleX()) + i(zG);
        View view = this.f81334b;
        Property property = View.TRANSLATION_X;
        if (zG) {
            width = -width;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, width);
        if (animatorUpdateListener != null) {
            objectAnimatorOfFloat.addUpdateListener(animatorUpdateListener);
        }
        objectAnimatorOfFloat.setInterpolator(new FastOutSlowInInterpolator());
        objectAnimatorOfFloat.setDuration(AnimationUtils.c(this.f81335c, this.f81336d, backEventCompat.a()));
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.motion.MaterialSideContainerBackHelper.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                MaterialSideContainerBackHelper.this.f81334b.setTranslationX(0.0f);
                MaterialSideContainerBackHelper.this.k(0.0f, z2, i3);
            }
        });
        if (animatorListener != null) {
            objectAnimatorOfFloat.addListener(animatorListener);
        }
        objectAnimatorOfFloat.start();
    }

    public void j(BackEventCompat backEventCompat) {
        super.d(backEventCompat);
    }

    public void k(float f3, boolean z2, int i3) {
        float fA = a(f3);
        boolean zG = g(i3, 3);
        boolean z3 = z2 == zG;
        int width = this.f81334b.getWidth();
        int height = this.f81334b.getHeight();
        float f4 = width;
        if (f4 > 0.0f) {
            float f5 = height;
            if (f5 <= 0.0f) {
                return;
            }
            float f6 = this.f81356g / f4;
            float f7 = this.f81357h / f4;
            float f8 = this.f81358i / f5;
            View view = this.f81334b;
            if (zG) {
                f4 = 0.0f;
            }
            view.setPivotX(f4);
            if (!z3) {
                f7 = -f6;
            }
            float fA2 = AnimationUtils.a(0.0f, f7, fA);
            float f9 = fA2 + 1.0f;
            this.f81334b.setScaleX(f9);
            float fA3 = 1.0f - AnimationUtils.a(0.0f, f8, fA);
            this.f81334b.setScaleY(fA3);
            View view2 = this.f81334b;
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                    View childAt = viewGroup.getChildAt(i4);
                    childAt.setPivotX(zG ? (width - childAt.getRight()) + childAt.getWidth() : -childAt.getLeft());
                    childAt.setPivotY(-childAt.getTop());
                    float f10 = z3 ? 1.0f - fA2 : 1.0f;
                    float f11 = fA3 != 0.0f ? (f9 / fA3) * f10 : 1.0f;
                    childAt.setScaleX(f10);
                    childAt.setScaleY(f11);
                }
            }
        }
    }

    public void l(BackEventCompat backEventCompat, int i3) {
        if (super.e(backEventCompat) == null) {
            return;
        }
        k(backEventCompat.a(), backEventCompat.b() == 0, i3);
    }
}
