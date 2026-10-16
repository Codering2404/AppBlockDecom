package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MotionUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class ClearTextEndIconDelegate extends EndIconDelegate {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f82209e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f82210f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TimeInterpolator f82211g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final TimeInterpolator f82212h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private EditText f82213i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final View.OnClickListener f82214j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final View.OnFocusChangeListener f82215k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private AnimatorSet f82216l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ValueAnimator f82217m;

    ClearTextEndIconDelegate(EndCompoundLayout endCompoundLayout) {
        super(endCompoundLayout);
        this.f82214j = new View.OnClickListener() { // from class: com.google.android.material.textfield.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClearTextEndIconDelegate.v(this.f82389a, view);
            }
        };
        this.f82215k = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.b
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z2) {
                ClearTextEndIconDelegate clearTextEndIconDelegate = this.f82390a;
                clearTextEndIconDelegate.A(clearTextEndIconDelegate.E());
            }
        };
        Context context = endCompoundLayout.getContext();
        int i3 = R.attr.f79479b0;
        this.f82209e = MotionUtils.f(context, i3, 100);
        this.f82210f = MotionUtils.f(endCompoundLayout.getContext(), i3, 150);
        this.f82211g = MotionUtils.g(endCompoundLayout.getContext(), R.attr.f79489g0, AnimationUtils.f79849a);
        this.f82212h = MotionUtils.g(endCompoundLayout.getContext(), R.attr.f79487f0, AnimationUtils.f79852d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(boolean z2) {
        boolean z3 = this.f82268b.F() == z2;
        if (z2 && !this.f82216l.isRunning()) {
            this.f82217m.cancel();
            this.f82216l.start();
            if (z3) {
                this.f82216l.end();
                return;
            }
            return;
        }
        if (z2) {
            return;
        }
        this.f82216l.cancel();
        this.f82217m.start();
        if (z3) {
            this.f82217m.end();
        }
    }

    private ValueAnimator B(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f82211g);
        valueAnimatorOfFloat.setDuration(this.f82209e);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ClearTextEndIconDelegate.x(this.f82391a, valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    private ValueAnimator C() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(this.f82212h);
        valueAnimatorOfFloat.setDuration(this.f82210f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ClearTextEndIconDelegate.y(this.f82393a, valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    private void D() {
        ValueAnimator valueAnimatorC = C();
        ValueAnimator valueAnimatorB = B(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f82216l = animatorSet;
        animatorSet.playTogether(valueAnimatorC, valueAnimatorB);
        this.f82216l.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ClearTextEndIconDelegate.this.f82268b.a0(true);
            }
        });
        ValueAnimator valueAnimatorB2 = B(1.0f, 0.0f);
        this.f82217m = valueAnimatorB2;
        valueAnimatorB2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ClearTextEndIconDelegate.this.f82268b.a0(false);
            }
        });
    }

    private boolean E() {
        EditText editText = this.f82213i;
        if (editText != null) {
            return (editText.hasFocus() || this.f82270d.hasFocus()) && this.f82213i.getText().length() > 0;
        }
        return false;
    }

    public static /* synthetic */ void v(ClearTextEndIconDelegate clearTextEndIconDelegate, View view) {
        EditText editText = clearTextEndIconDelegate.f82213i;
        if (editText == null) {
            return;
        }
        Editable text = editText.getText();
        if (text != null) {
            text.clear();
        }
        clearTextEndIconDelegate.r();
    }

    public static /* synthetic */ void x(ClearTextEndIconDelegate clearTextEndIconDelegate, ValueAnimator valueAnimator) {
        clearTextEndIconDelegate.getClass();
        clearTextEndIconDelegate.f82270d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static /* synthetic */ void y(ClearTextEndIconDelegate clearTextEndIconDelegate, ValueAnimator valueAnimator) {
        clearTextEndIconDelegate.getClass();
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        clearTextEndIconDelegate.f82270d.setScaleX(fFloatValue);
        clearTextEndIconDelegate.f82270d.setScaleY(fFloatValue);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void a(Editable editable) {
        if (this.f82268b.w() != null) {
            return;
        }
        A(E());
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    int c() {
        return R.string.f79705e;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    int d() {
        return R.drawable.f79617l;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    View.OnFocusChangeListener e() {
        return this.f82215k;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    View.OnClickListener f() {
        return this.f82214j;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    View.OnFocusChangeListener g() {
        return this.f82215k;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void n(EditText editText) {
        this.f82213i = editText;
        this.f82267a.setEndIconVisible(E());
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void q(boolean z2) {
        if (this.f82268b.w() == null) {
            return;
        }
        A(z2);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void s() {
        D();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void u() {
        EditText editText = this.f82213i;
        if (editText != null) {
            editText.post(new Runnable() { // from class: com.google.android.material.textfield.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f82392a.A(true);
                }
            });
        }
    }
}
