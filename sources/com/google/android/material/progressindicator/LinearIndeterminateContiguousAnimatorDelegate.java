package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.DrawingDelegate;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class LinearIndeterminateContiguousAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Property f81556i = new Property<LinearIndeterminateContiguousAnimatorDelegate, Float>(Float.class, "animationFraction") { // from class: com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate.2
        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate) {
            return Float.valueOf(linearIndeterminateContiguousAnimatorDelegate.n());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate, Float f3) {
            linearIndeterminateContiguousAnimatorDelegate.r(f3.floatValue());
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ObjectAnimator f81557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FastOutSlowInInterpolator f81558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final BaseProgressIndicatorSpec f81559e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f81560f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f81561g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f81562h;

    public LinearIndeterminateContiguousAnimatorDelegate(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(3);
        this.f81560f = 1;
        this.f81559e = linearProgressIndicatorSpec;
        this.f81558d = new FastOutSlowInInterpolator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n() {
        return this.f81562h;
    }

    private void o() {
        if (this.f81557c == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<LinearIndeterminateContiguousAnimatorDelegate, Float>) f81556i, 0.0f, 1.0f);
            this.f81557c = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(333L);
            this.f81557c.setInterpolator(null);
            this.f81557c.setRepeatCount(-1);
            this.f81557c.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate = LinearIndeterminateContiguousAnimatorDelegate.this;
                    linearIndeterminateContiguousAnimatorDelegate.f81560f = (linearIndeterminateContiguousAnimatorDelegate.f81560f + 1) % LinearIndeterminateContiguousAnimatorDelegate.this.f81559e.f81489c.length;
                    LinearIndeterminateContiguousAnimatorDelegate.this.f81561g = true;
                }
            });
        }
    }

    private void p() {
        if (!this.f81561g || ((DrawingDelegate.ActiveIndicator) this.f81547b.get(1)).f81543b >= 1.0f) {
            return;
        }
        ((DrawingDelegate.ActiveIndicator) this.f81547b.get(2)).f81544c = ((DrawingDelegate.ActiveIndicator) this.f81547b.get(1)).f81544c;
        ((DrawingDelegate.ActiveIndicator) this.f81547b.get(1)).f81544c = ((DrawingDelegate.ActiveIndicator) this.f81547b.get(0)).f81544c;
        ((DrawingDelegate.ActiveIndicator) this.f81547b.get(0)).f81544c = this.f81559e.f81489c[this.f81560f];
        this.f81561g = false;
    }

    private void s(int i3) {
        ((DrawingDelegate.ActiveIndicator) this.f81547b.get(0)).f81542a = 0.0f;
        float fB = b(i3, 0, 667);
        DrawingDelegate.ActiveIndicator activeIndicator = (DrawingDelegate.ActiveIndicator) this.f81547b.get(0);
        DrawingDelegate.ActiveIndicator activeIndicator2 = (DrawingDelegate.ActiveIndicator) this.f81547b.get(1);
        float interpolation = this.f81558d.getInterpolation(fB);
        activeIndicator2.f81542a = interpolation;
        activeIndicator.f81543b = interpolation;
        DrawingDelegate.ActiveIndicator activeIndicator3 = (DrawingDelegate.ActiveIndicator) this.f81547b.get(1);
        DrawingDelegate.ActiveIndicator activeIndicator4 = (DrawingDelegate.ActiveIndicator) this.f81547b.get(2);
        float interpolation2 = this.f81558d.getInterpolation(fB + 0.49925038f);
        activeIndicator4.f81542a = interpolation2;
        activeIndicator3.f81543b = interpolation2;
        ((DrawingDelegate.ActiveIndicator) this.f81547b.get(2)).f81543b = 1.0f;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void a() {
        ObjectAnimator objectAnimator = this.f81557c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void c() {
        q();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void g() {
        o();
        q();
        this.f81557c.start();
    }

    void q() {
        this.f81561g = true;
        this.f81560f = 1;
        for (DrawingDelegate.ActiveIndicator activeIndicator : this.f81547b) {
            BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f81559e;
            activeIndicator.f81544c = baseProgressIndicatorSpec.f81489c[0];
            activeIndicator.f81545d = baseProgressIndicatorSpec.f81493g / 2;
        }
    }

    void r(float f3) {
        this.f81562h = f3;
        s((int) (f3 * 333.0f));
        p();
        this.f81546a.invalidateSelf();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void f() {
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void h() {
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void d(Animatable2Compat.AnimationCallback animationCallback) {
    }
}
