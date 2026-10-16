package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class SlideDistanceProvider implements VisibilityAnimatorProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f82824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f82825b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface GravityFlag {
    }

    private static Animator c(View view, View view2, int i3, int i4) {
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i3 == 3) {
            return e(view2, i4 + translationX, translationX, translationX);
        }
        if (i3 == 5) {
            return e(view2, translationX - i4, translationX, translationX);
        }
        if (i3 == 48) {
            return f(view2, translationY - i4, translationY, translationY);
        }
        if (i3 == 80) {
            return f(view2, i4 + translationY, translationY, translationY);
        }
        if (i3 == 8388611) {
            return e(view2, h(view) ? i4 + translationX : translationX - i4, translationX, translationX);
        }
        if (i3 == 8388613) {
            return e(view2, h(view) ? translationX - i4 : i4 + translationX, translationX, translationX);
        }
        throw new IllegalArgumentException("Invalid slide direction: " + i3);
    }

    private static Animator d(View view, View view2, int i3, int i4) {
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i3 == 3) {
            return e(view2, translationX, translationX - i4, translationX);
        }
        if (i3 == 5) {
            return e(view2, translationX, i4 + translationX, translationX);
        }
        if (i3 == 48) {
            return f(view2, translationY, i4 + translationY, translationY);
        }
        if (i3 == 80) {
            return f(view2, translationY, translationY - i4, translationY);
        }
        if (i3 == 8388611) {
            return e(view2, translationX, h(view) ? translationX - i4 : i4 + translationX, translationX);
        }
        if (i3 == 8388613) {
            return e(view2, translationX, h(view) ? i4 + translationX : translationX - i4, translationX);
        }
        throw new IllegalArgumentException("Invalid slide direction: " + i3);
    }

    private static Animator e(final View view, float f3, float f4, final float f5) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f3, f4));
        objectAnimatorOfPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transition.platform.SlideDistanceProvider.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setTranslationX(f5);
            }
        });
        return objectAnimatorOfPropertyValuesHolder;
    }

    private static Animator f(final View view, float f3, float f4, final float f5) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f3, f4));
        objectAnimatorOfPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transition.platform.SlideDistanceProvider.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setTranslationY(f5);
            }
        });
        return objectAnimatorOfPropertyValuesHolder;
    }

    private int g(Context context) {
        int i3 = this.f82825b;
        return i3 != -1 ? i3 : context.getResources().getDimensionPixelSize(R.dimen.O0);
    }

    private static boolean h(View view) {
        return ViewCompat.y(view) == 1;
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    public Animator a(ViewGroup viewGroup, View view) {
        return d(viewGroup, view, this.f82824a, g(view.getContext()));
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    public Animator b(ViewGroup viewGroup, View view) {
        return c(viewGroup, view, this.f82824a, g(view.getContext()));
    }
}
