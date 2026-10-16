package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class DrawableWithAnimatedVisibilityChange extends Drawable implements Animatable2Compat {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Property f81524p = new Property<DrawableWithAnimatedVisibilityChange, Float>(Float.class, "growFraction") { // from class: com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange.3
        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange) {
            return Float.valueOf(drawableWithAnimatedVisibilityChange.h());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange, Float f3) {
            drawableWithAnimatedVisibilityChange.n(f3.floatValue());
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f81525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final BaseProgressIndicatorSpec f81526b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ValueAnimator f81528d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ValueAnimator f81529f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f81530g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f81531h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f81532i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List f81533j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Animatable2Compat.AnimationCallback f81534k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f81535l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f81536m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f81538o;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final Paint f81537n = new Paint();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    AnimatorDurationScaleProvider f81527c = new AnimatorDurationScaleProvider();

    DrawableWithAnimatedVisibilityChange(Context context, BaseProgressIndicatorSpec baseProgressIndicatorSpec) {
        this.f81525a = context;
        this.f81526b = baseProgressIndicatorSpec;
        setAlpha(255);
    }

    private void d(ValueAnimator... valueAnimatorArr) {
        boolean z2 = this.f81535l;
        this.f81535l = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.cancel();
        }
        this.f81535l = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Animatable2Compat.AnimationCallback animationCallback = this.f81534k;
        if (animationCallback != null) {
            animationCallback.b(this);
        }
        List list = this.f81533j;
        if (list == null || this.f81535l) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Animatable2Compat.AnimationCallback) it.next()).b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Animatable2Compat.AnimationCallback animationCallback = this.f81534k;
        if (animationCallback != null) {
            animationCallback.c(this);
        }
        List list = this.f81533j;
        if (list == null || this.f81535l) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Animatable2Compat.AnimationCallback) it.next()).c(this);
        }
    }

    private void g(ValueAnimator... valueAnimatorArr) {
        boolean z2 = this.f81535l;
        this.f81535l = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.end();
        }
        this.f81535l = z2;
    }

    private void l() {
        if (this.f81528d == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<DrawableWithAnimatedVisibilityChange, Float>) f81524p, 0.0f, 1.0f);
            this.f81528d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(500L);
            this.f81528d.setInterpolator(AnimationUtils.f79850b);
            p(this.f81528d);
        }
        if (this.f81529f == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, (Property<DrawableWithAnimatedVisibilityChange, Float>) f81524p, 1.0f, 0.0f);
            this.f81529f = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(500L);
            this.f81529f.setInterpolator(AnimationUtils.f79850b);
            o(this.f81529f);
        }
    }

    private void o(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f81529f;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
        }
        this.f81529f = valueAnimator;
        valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                DrawableWithAnimatedVisibilityChange.super.setVisible(false, false);
                DrawableWithAnimatedVisibilityChange.this.e();
            }
        });
    }

    private void p(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f81528d;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
        }
        this.f81528d = valueAnimator;
        valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                DrawableWithAnimatedVisibilityChange.this.f();
            }
        });
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f81538o;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    float h() {
        if (this.f81526b.b() || this.f81526b.a()) {
            return (this.f81531h || this.f81530g) ? this.f81532i : this.f81536m;
        }
        return 1.0f;
    }

    public boolean i() {
        return q(false, false, false);
    }

    public boolean isRunning() {
        return k() || j();
    }

    public boolean j() {
        ValueAnimator valueAnimator = this.f81529f;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f81531h;
    }

    public boolean k() {
        ValueAnimator valueAnimator = this.f81528d;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f81530g;
    }

    public void m(Animatable2Compat.AnimationCallback animationCallback) {
        if (this.f81533j == null) {
            this.f81533j = new ArrayList();
        }
        if (this.f81533j.contains(animationCallback)) {
            return;
        }
        this.f81533j.add(animationCallback);
    }

    void n(float f3) {
        if (this.f81536m != f3) {
            this.f81536m = f3;
            invalidateSelf();
        }
    }

    public boolean q(boolean z2, boolean z3, boolean z4) {
        return r(z2, z3, z4 && this.f81527c.a(this.f81525a.getContentResolver()) > 0.0f);
    }

    boolean r(boolean z2, boolean z3, boolean z4) {
        l();
        if (!isVisible() && !z2) {
            return false;
        }
        ValueAnimator valueAnimator = z2 ? this.f81528d : this.f81529f;
        ValueAnimator valueAnimator2 = z2 ? this.f81529f : this.f81528d;
        if (!z4) {
            if (valueAnimator2.isRunning()) {
                d(valueAnimator2);
            }
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                g(valueAnimator);
            }
            return super.setVisible(z2, false);
        }
        if (valueAnimator.isRunning()) {
            return false;
        }
        boolean z5 = !z2 || super.setVisible(z2, false);
        if (!(z2 ? this.f81526b.b() : this.f81526b.a())) {
            g(valueAnimator);
            return z5;
        }
        if (z3 || !valueAnimator.isPaused()) {
            valueAnimator.start();
            return z5;
        }
        valueAnimator.resume();
        return z5;
    }

    public boolean s(Animatable2Compat.AnimationCallback animationCallback) {
        List list = this.f81533j;
        if (list == null || !list.contains(animationCallback)) {
            return false;
        }
        this.f81533j.remove(animationCallback);
        if (!this.f81533j.isEmpty()) {
            return true;
        }
        this.f81533j = null;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f81538o = i3;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f81537n.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        return q(z2, z3, true);
    }

    public void start() {
        r(true, true, false);
    }

    public void stop() {
        r(false, true, false);
    }
}
