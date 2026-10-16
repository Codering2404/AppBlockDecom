package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class IndicatorViewController {
    private ColorStateList A;
    private Typeface B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f82271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f82272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f82273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TimeInterpolator f82274d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TimeInterpolator f82275e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TimeInterpolator f82276f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f82277g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final TextInputLayout f82278h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private LinearLayout f82279i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f82280j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private FrameLayout f82281k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Animator f82282l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final float f82283m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f82284n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f82285o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private CharSequence f82286p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f82287q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private TextView f82288r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private CharSequence f82289s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f82290t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f82291u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ColorStateList f82292v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private CharSequence f82293w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f82294x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private TextView f82295y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f82296z;

    public IndicatorViewController(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f82277g = context;
        this.f82278h = textInputLayout;
        this.f82283m = context.getResources().getDimensionPixelSize(R.dimen.f79578m);
        int i3 = R.attr.f79481c0;
        this.f82271a = MotionUtils.f(context, i3, 217);
        this.f82272b = MotionUtils.f(context, R.attr.Y, 167);
        this.f82273c = MotionUtils.f(context, i3, 167);
        int i4 = R.attr.f79485e0;
        this.f82274d = MotionUtils.g(context, i4, AnimationUtils.f79852d);
        TimeInterpolator timeInterpolator = AnimationUtils.f79849a;
        this.f82275e = MotionUtils.g(context, i4, timeInterpolator);
        this.f82276f = MotionUtils.g(context, R.attr.f79489g0, timeInterpolator);
    }

    private void D(int i3, int i4) {
        TextView textViewM;
        TextView textViewM2;
        if (i3 == i4) {
            return;
        }
        if (i4 != 0 && (textViewM2 = m(i4)) != null) {
            textViewM2.setVisibility(0);
            textViewM2.setAlpha(1.0f);
        }
        if (i3 != 0 && (textViewM = m(i3)) != null) {
            textViewM.setVisibility(4);
            if (i3 == 1) {
                textViewM.setText((CharSequence) null);
            }
        }
        this.f82284n = i4;
    }

    private void M(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void O(ViewGroup viewGroup, int i3) {
        if (i3 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean P(TextView textView, CharSequence charSequence) {
        if (ViewCompat.R(this.f82278h) && this.f82278h.isEnabled()) {
            return (this.f82285o == this.f82284n && textView != null && TextUtils.equals(textView.getText(), charSequence)) ? false : true;
        }
        return false;
    }

    private void S(final int i3, final int i4, boolean z2) {
        IndicatorViewController indicatorViewController;
        if (i3 == i4) {
            return;
        }
        if (z2) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f82282l = animatorSet;
            ArrayList arrayList = new ArrayList();
            indicatorViewController = this;
            indicatorViewController.i(arrayList, this.f82294x, this.f82295y, 2, i3, i4);
            indicatorViewController.i(arrayList, indicatorViewController.f82287q, indicatorViewController.f82288r, 1, i3, i4);
            AnimatorSetCompat.a(animatorSet, arrayList);
            final TextView textViewM = m(i3);
            final TextView textViewM2 = m(i4);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.IndicatorViewController.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    IndicatorViewController.this.f82284n = i4;
                    IndicatorViewController.this.f82282l = null;
                    TextView textView = textViewM;
                    if (textView != null) {
                        textView.setVisibility(4);
                        if (i3 == 1 && IndicatorViewController.this.f82288r != null) {
                            IndicatorViewController.this.f82288r.setText((CharSequence) null);
                        }
                    }
                    TextView textView2 = textViewM2;
                    if (textView2 != null) {
                        textView2.setTranslationY(0.0f);
                        textViewM2.setAlpha(1.0f);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    TextView textView = textViewM2;
                    if (textView != null) {
                        textView.setVisibility(0);
                        textViewM2.setAlpha(0.0f);
                    }
                }
            });
            animatorSet.start();
        } else {
            indicatorViewController = this;
            D(i3, i4);
        }
        indicatorViewController.f82278h.n0();
        indicatorViewController.f82278h.s0(z2);
        indicatorViewController.f82278h.y0();
    }

    private boolean g() {
        return (this.f82279i == null || this.f82278h.getEditText() == null) ? false : true;
    }

    private void i(List list, boolean z2, TextView textView, int i3, int i4, int i5) {
        if (textView == null || !z2) {
            return;
        }
        if (i3 == i5 || i3 == i4) {
            ObjectAnimator objectAnimatorJ = j(textView, i5 == i3);
            if (i3 == i5 && i4 != 0) {
                objectAnimatorJ.setStartDelay(this.f82273c);
            }
            list.add(objectAnimatorJ);
            if (i5 != i3 || i4 == 0) {
                return;
            }
            ObjectAnimator objectAnimatorK = k(textView);
            objectAnimatorK.setStartDelay(this.f82273c);
            list.add(objectAnimatorK);
        }
    }

    private ObjectAnimator j(TextView textView, boolean z2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z2 ? 1.0f : 0.0f);
        objectAnimatorOfFloat.setDuration(z2 ? this.f82272b : this.f82273c);
        objectAnimatorOfFloat.setInterpolator(z2 ? this.f82275e : this.f82276f);
        return objectAnimatorOfFloat;
    }

    private ObjectAnimator k(TextView textView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f82283m, 0.0f);
        objectAnimatorOfFloat.setDuration(this.f82271a);
        objectAnimatorOfFloat.setInterpolator(this.f82274d);
        return objectAnimatorOfFloat;
    }

    private TextView m(int i3) {
        if (i3 == 1) {
            return this.f82288r;
        }
        if (i3 != 2) {
            return null;
        }
        return this.f82295y;
    }

    private int v(boolean z2, int i3, int i4) {
        return z2 ? this.f82277g.getResources().getDimensionPixelSize(i3) : i4;
    }

    private boolean y(int i3) {
        return (i3 != 1 || this.f82288r == null || TextUtils.isEmpty(this.f82286p)) ? false : true;
    }

    boolean A() {
        return this.f82287q;
    }

    boolean B() {
        return this.f82294x;
    }

    void C(TextView textView, int i3) {
        FrameLayout frameLayout;
        if (this.f82279i == null) {
            return;
        }
        if (!z(i3) || (frameLayout = this.f82281k) == null) {
            this.f82279i.removeView(textView);
        } else {
            frameLayout.removeView(textView);
        }
        int i4 = this.f82280j - 1;
        this.f82280j = i4;
        O(this.f82279i, i4);
    }

    void E(int i3) {
        this.f82290t = i3;
        TextView textView = this.f82288r;
        if (textView != null) {
            ViewCompat.o0(textView, i3);
        }
    }

    void F(CharSequence charSequence) {
        this.f82289s = charSequence;
        TextView textView = this.f82288r;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    void G(boolean z2) {
        if (this.f82287q == z2) {
            return;
        }
        h();
        if (z2) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f82277g);
            this.f82288r = appCompatTextView;
            appCompatTextView.setId(R.id.f79647n0);
            this.f82288r.setTextAlignment(5);
            Typeface typeface = this.B;
            if (typeface != null) {
                this.f82288r.setTypeface(typeface);
            }
            H(this.f82291u);
            I(this.f82292v);
            F(this.f82289s);
            E(this.f82290t);
            this.f82288r.setVisibility(4);
            e(this.f82288r, 0);
        } else {
            w();
            C(this.f82288r, 0);
            this.f82288r = null;
            this.f82278h.n0();
            this.f82278h.y0();
        }
        this.f82287q = z2;
    }

    void H(int i3) {
        this.f82291u = i3;
        TextView textView = this.f82288r;
        if (textView != null) {
            this.f82278h.a0(textView, i3);
        }
    }

    void I(ColorStateList colorStateList) {
        this.f82292v = colorStateList;
        TextView textView = this.f82288r;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    void J(int i3) {
        this.f82296z = i3;
        TextView textView = this.f82295y;
        if (textView != null) {
            TextViewCompat.o(textView, i3);
        }
    }

    void K(boolean z2) {
        if (this.f82294x == z2) {
            return;
        }
        h();
        if (z2) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f82277g);
            this.f82295y = appCompatTextView;
            appCompatTextView.setId(R.id.f79649o0);
            this.f82295y.setTextAlignment(5);
            Typeface typeface = this.B;
            if (typeface != null) {
                this.f82295y.setTypeface(typeface);
            }
            this.f82295y.setVisibility(4);
            ViewCompat.o0(this.f82295y, 1);
            J(this.f82296z);
            L(this.A);
            e(this.f82295y, 1);
            this.f82295y.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.google.android.material.textfield.IndicatorViewController.2
                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                    EditText editText = IndicatorViewController.this.f82278h.getEditText();
                    if (editText != null) {
                        accessibilityNodeInfo.setLabeledBy(editText);
                    }
                }
            });
        } else {
            x();
            C(this.f82295y, 1);
            this.f82295y = null;
            this.f82278h.n0();
            this.f82278h.y0();
        }
        this.f82294x = z2;
    }

    void L(ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.f82295y;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    void N(Typeface typeface) {
        if (typeface != this.B) {
            this.B = typeface;
            M(this.f82288r, typeface);
            M(this.f82295y, typeface);
        }
    }

    void Q(CharSequence charSequence) {
        h();
        this.f82286p = charSequence;
        this.f82288r.setText(charSequence);
        int i3 = this.f82284n;
        if (i3 != 1) {
            this.f82285o = 1;
        }
        S(i3, this.f82285o, P(this.f82288r, charSequence));
    }

    void R(CharSequence charSequence) {
        h();
        this.f82293w = charSequence;
        this.f82295y.setText(charSequence);
        int i3 = this.f82284n;
        if (i3 != 2) {
            this.f82285o = 2;
        }
        S(i3, this.f82285o, P(this.f82295y, charSequence));
    }

    void e(TextView textView, int i3) {
        if (this.f82279i == null && this.f82281k == null) {
            LinearLayout linearLayout = new LinearLayout(this.f82277g);
            this.f82279i = linearLayout;
            linearLayout.setOrientation(0);
            this.f82278h.addView(this.f82279i, -1, -2);
            this.f82281k = new FrameLayout(this.f82277g);
            this.f82279i.addView(this.f82281k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f82278h.getEditText() != null) {
                f();
            }
        }
        if (z(i3)) {
            this.f82281k.setVisibility(0);
            this.f82281k.addView(textView);
        } else {
            this.f82279i.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f82279i.setVisibility(0);
        this.f82280j++;
    }

    void f() {
        if (g()) {
            EditText editText = this.f82278h.getEditText();
            boolean zJ = MaterialResources.j(this.f82277g);
            LinearLayout linearLayout = this.f82279i;
            int i3 = R.dimen.W;
            ViewCompat.D0(linearLayout, v(zJ, i3, ViewCompat.D(editText)), v(zJ, R.dimen.X, this.f82277g.getResources().getDimensionPixelSize(R.dimen.V)), v(zJ, i3, ViewCompat.C(editText)), 0);
        }
    }

    void h() {
        Animator animator = this.f82282l;
        if (animator != null) {
            animator.cancel();
        }
    }

    boolean l() {
        return y(this.f82285o);
    }

    int n() {
        return this.f82290t;
    }

    CharSequence o() {
        return this.f82289s;
    }

    CharSequence p() {
        return this.f82286p;
    }

    int q() {
        TextView textView = this.f82288r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    ColorStateList r() {
        TextView textView = this.f82288r;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    CharSequence s() {
        return this.f82293w;
    }

    View t() {
        return this.f82295y;
    }

    int u() {
        TextView textView = this.f82295y;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    void w() {
        this.f82286p = null;
        h();
        if (this.f82284n == 1) {
            if (!this.f82294x || TextUtils.isEmpty(this.f82293w)) {
                this.f82285o = 0;
            } else {
                this.f82285o = 2;
            }
        }
        S(this.f82284n, this.f82285o, P(this.f82288r, ""));
    }

    void x() {
        h();
        int i3 = this.f82284n;
        if (i3 == 2) {
            this.f82285o = 0;
        }
        S(i3, this.f82285o, P(this.f82295y, ""));
    }

    boolean z(int i3) {
        return i3 == 0 || i3 == 1;
    }
}
