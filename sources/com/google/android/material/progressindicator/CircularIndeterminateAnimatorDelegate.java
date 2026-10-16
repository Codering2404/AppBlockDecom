package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.progressindicator.DrawingDelegate;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class CircularIndeterminateAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f81499k = {0, 1350, 2700, 4050};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int[] f81500l = {667, 2017, 3367, 4717};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int[] f81501m = {1000, 2350, 3700, 5050};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Property f81502n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Property f81503o;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ObjectAnimator f81504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ObjectAnimator f81505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final FastOutSlowInInterpolator f81506e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final BaseProgressIndicatorSpec f81507f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f81508g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f81509h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f81510i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Animatable2Compat.AnimationCallback f81511j;

    static {
        Class<Float> cls = Float.class;
        f81502n = new Property<CircularIndeterminateAnimatorDelegate, Float>(cls, "animationFraction") { // from class: com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.3
            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Float get(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate) {
                return Float.valueOf(circularIndeterminateAnimatorDelegate.o());
            }

            @Override // android.util.Property
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void set(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate, Float f3) {
                circularIndeterminateAnimatorDelegate.t(f3.floatValue());
            }
        };
        f81503o = new Property<CircularIndeterminateAnimatorDelegate, Float>(cls, "completeEndFraction") { // from class: com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.4
            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Float get(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate) {
                return Float.valueOf(circularIndeterminateAnimatorDelegate.p());
            }

            @Override // android.util.Property
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void set(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate, Float f3) {
                circularIndeterminateAnimatorDelegate.u(f3.floatValue());
            }
        };
    }

    public CircularIndeterminateAnimatorDelegate(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.f81508g = 0;
        this.f81511j = null;
        this.f81507f = circularProgressIndicatorSpec;
        this.f81506e = new FastOutSlowInInterpolator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float o() {
        return this.f81509h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float p() {
        return this.f81510i;
    }

    private void q() {
        if (this.f81504c == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<CircularIndeterminateAnimatorDelegate, Float>) f81502n, 0.0f, 1.0f);
            this.f81504c = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(5400L);
            this.f81504c.setInterpolator(null);
            this.f81504c.setRepeatCount(-1);
            this.f81504c.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate = CircularIndeterminateAnimatorDelegate.this;
                    circularIndeterminateAnimatorDelegate.f81508g = (circularIndeterminateAnimatorDelegate.f81508g + 4) % CircularIndeterminateAnimatorDelegate.this.f81507f.f81489c.length;
                }
            });
        }
        if (this.f81505d == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, (Property<CircularIndeterminateAnimatorDelegate, Float>) f81503o, 0.0f, 1.0f);
            this.f81505d = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(333L);
            this.f81505d.setInterpolator(this.f81506e);
            this.f81505d.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    CircularIndeterminateAnimatorDelegate.this.a();
                    CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate = CircularIndeterminateAnimatorDelegate.this;
                    Animatable2Compat.AnimationCallback animationCallback = circularIndeterminateAnimatorDelegate.f81511j;
                    if (animationCallback != null) {
                        animationCallback.b(circularIndeterminateAnimatorDelegate.f81546a);
                    }
                }
            });
        }
    }

    private void r(int i3) {
        for (int i4 = 0; i4 < 4; i4++) {
            float fB = b(i3, f81501m[i4], 333);
            if (fB >= 0.0f && fB <= 1.0f) {
                int i5 = i4 + this.f81508g;
                int[] iArr = this.f81507f.f81489c;
                int length = i5 % iArr.length;
                int length2 = (length + 1) % iArr.length;
                int i6 = iArr[length];
                int i7 = iArr[length2];
                ((DrawingDelegate.ActiveIndicator) this.f81547b.get(0)).f81544c = ArgbEvaluatorCompat.b().evaluate(this.f81506e.getInterpolation(fB), Integer.valueOf(i6), Integer.valueOf(i7)).intValue();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(float f3) {
        this.f81510i = f3;
    }

    private void v(int i3) {
        DrawingDelegate.ActiveIndicator activeIndicator = (DrawingDelegate.ActiveIndicator) this.f81547b.get(0);
        float f3 = this.f81509h;
        activeIndicator.f81542a = (f3 * 1520.0f) - 20.0f;
        activeIndicator.f81543b = f3 * 1520.0f;
        for (int i4 = 0; i4 < 4; i4++) {
            activeIndicator.f81543b += this.f81506e.getInterpolation(b(i3, f81499k[i4], 667)) * 250.0f;
            activeIndicator.f81542a += this.f81506e.getInterpolation(b(i3, f81500l[i4], 667)) * 250.0f;
        }
        float f4 = activeIndicator.f81542a;
        float f5 = activeIndicator.f81543b;
        activeIndicator.f81542a = (f4 + ((f5 - f4) * this.f81510i)) / 360.0f;
        activeIndicator.f81543b = f5 / 360.0f;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    void a() {
        ObjectAnimator objectAnimator = this.f81504c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void c() {
        s();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void d(Animatable2Compat.AnimationCallback animationCallback) {
        this.f81511j = animationCallback;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    void f() {
        ObjectAnimator objectAnimator = this.f81505d;
        if (objectAnimator == null || objectAnimator.isRunning()) {
            return;
        }
        if (this.f81546a.isVisible()) {
            this.f81505d.start();
        } else {
            a();
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    void g() {
        q();
        s();
        this.f81504c.start();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void h() {
        this.f81511j = null;
    }

    void s() {
        this.f81508g = 0;
        ((DrawingDelegate.ActiveIndicator) this.f81547b.get(0)).f81544c = this.f81507f.f81489c[0];
        this.f81510i = 0.0f;
    }

    void t(float f3) {
        this.f81509h = f3;
        int i3 = (int) (f3 * 5400.0f);
        v(i3);
        r(i3);
        this.f81546a.invalidateSelf();
    }
}
