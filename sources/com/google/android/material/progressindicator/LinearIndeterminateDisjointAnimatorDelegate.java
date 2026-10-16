package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import androidx.core.math.MathUtils;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat;
import com.google.android.material.R;
import com.google.android.material.progressindicator.DrawingDelegate;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class LinearIndeterminateDisjointAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f81564k = {533, 567, 850, 750};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int[] f81565l = {1267, 1000, 333, 0};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Property f81566m = new Property<LinearIndeterminateDisjointAnimatorDelegate, Float>(Float.class, "animationFraction") { // from class: com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.3
        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate) {
            return Float.valueOf(linearIndeterminateDisjointAnimatorDelegate.n());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate, Float f3) {
            linearIndeterminateDisjointAnimatorDelegate.r(f3.floatValue());
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ObjectAnimator f81567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ObjectAnimator f81568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Interpolator[] f81569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final BaseProgressIndicatorSpec f81570f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f81571g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f81572h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f81573i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Animatable2Compat.AnimationCallback f81574j;

    public LinearIndeterminateDisjointAnimatorDelegate(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(2);
        this.f81571g = 0;
        this.f81574j = null;
        this.f81570f = linearProgressIndicatorSpec;
        this.f81569e = new Interpolator[]{AnimationUtilsCompat.a(context, R.anim.f79464a), AnimationUtilsCompat.a(context, R.anim.f79465b), AnimationUtilsCompat.a(context, R.anim.f79466c), AnimationUtilsCompat.a(context, R.anim.f79467d)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n() {
        return this.f81573i;
    }

    private void o() {
        if (this.f81567c == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<LinearIndeterminateDisjointAnimatorDelegate, Float>) f81566m, 0.0f, 1.0f);
            this.f81567c = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(1800L);
            this.f81567c.setInterpolator(null);
            this.f81567c.setRepeatCount(-1);
            this.f81567c.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate = LinearIndeterminateDisjointAnimatorDelegate.this;
                    linearIndeterminateDisjointAnimatorDelegate.f81571g = (linearIndeterminateDisjointAnimatorDelegate.f81571g + 1) % LinearIndeterminateDisjointAnimatorDelegate.this.f81570f.f81489c.length;
                    LinearIndeterminateDisjointAnimatorDelegate.this.f81572h = true;
                }
            });
        }
        if (this.f81568d == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, (Property<LinearIndeterminateDisjointAnimatorDelegate, Float>) f81566m, 1.0f);
            this.f81568d = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(1800L);
            this.f81568d.setInterpolator(null);
            this.f81568d.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    LinearIndeterminateDisjointAnimatorDelegate.this.a();
                    LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate = LinearIndeterminateDisjointAnimatorDelegate.this;
                    Animatable2Compat.AnimationCallback animationCallback = linearIndeterminateDisjointAnimatorDelegate.f81574j;
                    if (animationCallback != null) {
                        animationCallback.b(linearIndeterminateDisjointAnimatorDelegate.f81546a);
                    }
                }
            });
        }
    }

    private void p() {
        if (this.f81572h) {
            Iterator it = this.f81547b.iterator();
            while (it.hasNext()) {
                ((DrawingDelegate.ActiveIndicator) it.next()).f81544c = this.f81570f.f81489c[this.f81571g];
            }
            this.f81572h = false;
        }
    }

    private void s(int i3) {
        for (int i4 = 0; i4 < this.f81547b.size(); i4++) {
            DrawingDelegate.ActiveIndicator activeIndicator = (DrawingDelegate.ActiveIndicator) this.f81547b.get(i4);
            int[] iArr = f81565l;
            int i5 = i4 * 2;
            int i6 = iArr[i5];
            int[] iArr2 = f81564k;
            activeIndicator.f81542a = MathUtils.a(this.f81569e[i5].getInterpolation(b(i3, i6, iArr2[i5])), 0.0f, 1.0f);
            int i7 = i5 + 1;
            activeIndicator.f81543b = MathUtils.a(this.f81569e[i7].getInterpolation(b(i3, iArr[i7], iArr2[i7])), 0.0f, 1.0f);
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void a() {
        ObjectAnimator objectAnimator = this.f81567c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void c() {
        q();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void d(Animatable2Compat.AnimationCallback animationCallback) {
        this.f81574j = animationCallback;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void f() {
        ObjectAnimator objectAnimator = this.f81568d;
        if (objectAnimator == null || objectAnimator.isRunning()) {
            return;
        }
        a();
        if (this.f81546a.isVisible()) {
            this.f81568d.setFloatValues(this.f81573i, 1.0f);
            this.f81568d.setDuration((long) ((1.0f - this.f81573i) * 1800.0f));
            this.f81568d.start();
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void g() {
        o();
        q();
        this.f81567c.start();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void h() {
        this.f81574j = null;
    }

    void q() {
        this.f81571g = 0;
        Iterator it = this.f81547b.iterator();
        while (it.hasNext()) {
            ((DrawingDelegate.ActiveIndicator) it.next()).f81544c = this.f81570f.f81489c[0];
        }
    }

    void r(float f3) {
        this.f81573i = f3;
        s((int) (f3 * 1800.0f));
        p();
        this.f81546a.invalidateSelf();
    }
}
