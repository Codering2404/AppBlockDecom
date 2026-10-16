package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MotionUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f80048k = R.attr.V;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f80049l = R.attr.Y;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f80050m = R.attr.f79487f0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashSet f80051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f80052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f80053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TimeInterpolator f80054d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TimeInterpolator f80055f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f80056g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f80057h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f80058i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ViewPropertyAnimator f80059j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnScrollStateChangedListener {
        void a(View view, int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public @interface ScrollState {
    }

    public HideBottomViewOnScrollBehavior() {
        this.f80051a = new LinkedHashSet();
        this.f80056g = 0;
        this.f80057h = 2;
        this.f80058i = 0;
    }

    private void L(View view, int i3, long j3, TimeInterpolator timeInterpolator) {
        this.f80059j = view.animate().translationY(i3).setInterpolator(timeInterpolator).setDuration(j3).setListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.behavior.HideBottomViewOnScrollBehavior.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                HideBottomViewOnScrollBehavior.this.f80059j = null;
            }
        });
    }

    private void T(View view, int i3) {
        this.f80057h = i3;
        Iterator it = this.f80051a.iterator();
        while (it.hasNext()) {
            ((OnScrollStateChangedListener) it.next()).a(view, this.f80057h);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean G(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i3, int i4) {
        return i3 == 2;
    }

    public boolean M() {
        return this.f80057h == 1;
    }

    public boolean N() {
        return this.f80057h == 2;
    }

    public void O(View view, int i3) {
        this.f80058i = i3;
        if (this.f80057h == 1) {
            view.setTranslationY(this.f80056g + i3);
        }
    }

    public void P(View view) {
        Q(view, true);
    }

    public void Q(View view, boolean z2) {
        if (M()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f80059j;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        T(view, 1);
        int i3 = this.f80056g + this.f80058i;
        if (z2) {
            L(view, i3, this.f80053c, this.f80055f);
        } else {
            view.setTranslationY(i3);
        }
    }

    public void R(View view) {
        S(view, true);
    }

    public void S(View view, boolean z2) {
        if (N()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f80059j;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        T(view, 2);
        if (z2) {
            L(view, 0, this.f80052b, this.f80054d);
        } else {
            view.setTranslationY(0);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean r(CoordinatorLayout coordinatorLayout, View view, int i3) {
        this.f80056g = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.f80052b = MotionUtils.f(view.getContext(), f80048k, 225);
        this.f80053c = MotionUtils.f(view.getContext(), f80049l, 175);
        Context context = view.getContext();
        int i4 = f80050m;
        this.f80054d = MotionUtils.g(context, i4, AnimationUtils.f79852d);
        this.f80055f = MotionUtils.g(view.getContext(), i4, AnimationUtils.f79851c);
        return super.r(coordinatorLayout, view, i3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void z(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
        if (i4 > 0) {
            P(view);
        } else if (i4 < 0) {
            R(view);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f80051a = new LinkedHashSet();
        this.f80056g = 0;
        this.f80057h = 2;
        this.f80058i = 0;
    }
}
