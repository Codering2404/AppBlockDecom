package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MotionUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class DropdownMenuEndIconDelegate extends EndIconDelegate {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final boolean f82221s = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f82222e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f82223f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TimeInterpolator f82224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AutoCompleteTextView f82225h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final View.OnClickListener f82226i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final View.OnFocusChangeListener f82227j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AccessibilityManagerCompat.TouchExplorationStateChangeListener f82228k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f82229l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f82230m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f82231n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f82232o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private AccessibilityManager f82233p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ValueAnimator f82234q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ValueAnimator f82235r;

    DropdownMenuEndIconDelegate(EndCompoundLayout endCompoundLayout) {
        super(endCompoundLayout);
        this.f82226i = new View.OnClickListener() { // from class: com.google.android.material.textfield.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f82397a.J();
            }
        };
        this.f82227j = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.j
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z2) {
                DropdownMenuEndIconDelegate.y(this.f82398a, view, z2);
            }
        };
        this.f82228k = new AccessibilityManagerCompat.TouchExplorationStateChangeListener() { // from class: com.google.android.material.textfield.k
            @Override // androidx.core.view.accessibility.AccessibilityManagerCompat.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z2) {
                DropdownMenuEndIconDelegate.w(this.f82399a, z2);
            }
        };
        this.f82232o = Long.MAX_VALUE;
        Context context = endCompoundLayout.getContext();
        int i3 = R.attr.f79479b0;
        this.f82223f = MotionUtils.f(context, i3, 67);
        this.f82222e = MotionUtils.f(endCompoundLayout.getContext(), i3, 50);
        this.f82224g = MotionUtils.g(endCompoundLayout.getContext(), R.attr.f79489g0, AnimationUtils.f79849a);
    }

    public static /* synthetic */ void A(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        dropdownMenuEndIconDelegate.K();
        dropdownMenuEndIconDelegate.H(false);
    }

    private static AutoCompleteTextView D(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator E(int i3, float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f82224g);
        valueAnimatorOfFloat.setDuration(i3);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DropdownMenuEndIconDelegate.x(this.f82394a, valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    private void F() {
        this.f82235r = E(this.f82223f, 0.0f, 1.0f);
        ValueAnimator valueAnimatorE = E(this.f82222e, 1.0f, 0.0f);
        this.f82234q = valueAnimatorE;
        valueAnimatorE.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                DropdownMenuEndIconDelegate.this.r();
                DropdownMenuEndIconDelegate.this.f82235r.start();
            }
        });
    }

    private boolean G() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f82232o;
        return jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300;
    }

    private void H(boolean z2) {
        if (this.f82231n != z2) {
            this.f82231n = z2;
            this.f82235r.cancel();
            this.f82234q.start();
        }
    }

    private void I() {
        this.f82225h.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.textfield.g
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return DropdownMenuEndIconDelegate.z(this.f82395a, view, motionEvent);
            }
        });
        if (f82221s) {
            this.f82225h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: com.google.android.material.textfield.h
                @Override // android.widget.AutoCompleteTextView.OnDismissListener
                public final void onDismiss() {
                    DropdownMenuEndIconDelegate.A(this.f82396a);
                }
            });
        }
        this.f82225h.setThreshold(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        if (this.f82225h == null) {
            return;
        }
        if (G()) {
            this.f82230m = false;
        }
        if (this.f82230m) {
            this.f82230m = false;
            return;
        }
        if (f82221s) {
            H(!this.f82231n);
        } else {
            this.f82231n = !this.f82231n;
            r();
        }
        if (!this.f82231n) {
            this.f82225h.dismissDropDown();
        } else {
            this.f82225h.requestFocus();
            this.f82225h.showDropDown();
        }
    }

    private void K() {
        this.f82230m = true;
        this.f82232o = System.currentTimeMillis();
    }

    public static /* synthetic */ void v(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        boolean zIsPopupShowing = dropdownMenuEndIconDelegate.f82225h.isPopupShowing();
        dropdownMenuEndIconDelegate.H(zIsPopupShowing);
        dropdownMenuEndIconDelegate.f82230m = zIsPopupShowing;
    }

    public static /* synthetic */ void w(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate, boolean z2) {
        AutoCompleteTextView autoCompleteTextView = dropdownMenuEndIconDelegate.f82225h;
        if (autoCompleteTextView == null || EditTextUtils.a(autoCompleteTextView)) {
            return;
        }
        ViewCompat.w0(dropdownMenuEndIconDelegate.f82270d, z2 ? 2 : 1);
    }

    public static /* synthetic */ void x(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate, ValueAnimator valueAnimator) {
        dropdownMenuEndIconDelegate.getClass();
        dropdownMenuEndIconDelegate.f82270d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static /* synthetic */ void y(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate, View view, boolean z2) {
        dropdownMenuEndIconDelegate.f82229l = z2;
        dropdownMenuEndIconDelegate.r();
        if (z2) {
            return;
        }
        dropdownMenuEndIconDelegate.H(false);
        dropdownMenuEndIconDelegate.f82230m = false;
    }

    public static /* synthetic */ boolean z(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate, View view, MotionEvent motionEvent) {
        dropdownMenuEndIconDelegate.getClass();
        if (motionEvent.getAction() == 1) {
            if (dropdownMenuEndIconDelegate.G()) {
                dropdownMenuEndIconDelegate.f82230m = false;
            }
            dropdownMenuEndIconDelegate.J();
            dropdownMenuEndIconDelegate.K();
        }
        return false;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void a(Editable editable) {
        if (this.f82233p.isTouchExplorationEnabled() && EditTextUtils.a(this.f82225h) && !this.f82270d.hasFocus()) {
            this.f82225h.dismissDropDown();
        }
        this.f82225h.post(new Runnable() { // from class: com.google.android.material.textfield.l
            @Override // java.lang.Runnable
            public final void run() {
                DropdownMenuEndIconDelegate.v(this.f82400a);
            }
        });
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    int c() {
        return R.string.f79708g;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    int d() {
        return f82221s ? R.drawable.f79615j : R.drawable.f79616k;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    View.OnFocusChangeListener e() {
        return this.f82227j;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    View.OnClickListener f() {
        return this.f82226i;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public AccessibilityManagerCompat.TouchExplorationStateChangeListener h() {
        return this.f82228k;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    boolean i(int i3) {
        return i3 != 0;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    boolean j() {
        return true;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    boolean k() {
        return this.f82229l;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    boolean l() {
        return true;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    boolean m() {
        return this.f82231n;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void n(EditText editText) {
        this.f82225h = D(editText);
        I();
        this.f82267a.setErrorIconDrawable((Drawable) null);
        if (!EditTextUtils.a(editText) && this.f82233p.isTouchExplorationEnabled()) {
            ViewCompat.w0(this.f82270d, 2);
        }
        this.f82267a.setEndIconVisible(true);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void o(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (!EditTextUtils.a(this.f82225h)) {
            accessibilityNodeInfoCompat.i0(Spinner.class.getName());
        }
        if (accessibilityNodeInfoCompat.S()) {
            accessibilityNodeInfoCompat.v0(null);
        }
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void p(View view, AccessibilityEvent accessibilityEvent) {
        if (!this.f82233p.isEnabled() || EditTextUtils.a(this.f82225h)) {
            return;
        }
        boolean z2 = (accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.f82231n && !this.f82225h.isPopupShowing();
        if (accessibilityEvent.getEventType() == 1 || z2) {
            J();
            K();
        }
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void s() {
        F();
        this.f82233p = (AccessibilityManager) this.f82269c.getSystemService("accessibility");
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    boolean t() {
        return true;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void u() {
        AutoCompleteTextView autoCompleteTextView = this.f82225h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            if (f82221s) {
                this.f82225h.setOnDismissListener(null);
            }
        }
    }
}
