package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class EndCompoundLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final TextInputLayout f82237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FrameLayout f82238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CheckableImageButton f82239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ColorStateList f82240d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private PorterDuff.Mode f82241f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View.OnLongClickListener f82242g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CheckableImageButton f82243h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final EndIconDelegates f82244i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f82245j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final LinkedHashSet f82246k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ColorStateList f82247l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private PorterDuff.Mode f82248m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f82249n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ImageView.ScaleType f82250o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private View.OnLongClickListener f82251p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private CharSequence f82252q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final TextView f82253r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f82254s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private EditText f82255t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final AccessibilityManager f82256u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private AccessibilityManagerCompat.TouchExplorationStateChangeListener f82257v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final TextWatcher f82258w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final TextInputLayout.OnEditTextAttachedListener f82259x;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class EndIconDelegates {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SparseArray f82263a = new SparseArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final EndCompoundLayout f82264b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f82265c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f82266d;

        EndIconDelegates(EndCompoundLayout endCompoundLayout, TintTypedArray tintTypedArray) {
            this.f82264b = endCompoundLayout;
            this.f82265c = tintTypedArray.n(R.styleable.K8, 0);
            this.f82266d = tintTypedArray.n(R.styleable.i9, 0);
        }

        private EndIconDelegate b(int i3) {
            if (i3 == -1) {
                return new CustomEndIconDelegate(this.f82264b);
            }
            if (i3 == 0) {
                return new NoEndIconDelegate(this.f82264b);
            }
            if (i3 == 1) {
                return new PasswordToggleEndIconDelegate(this.f82264b, this.f82266d);
            }
            if (i3 == 2) {
                return new ClearTextEndIconDelegate(this.f82264b);
            }
            if (i3 == 3) {
                return new DropdownMenuEndIconDelegate(this.f82264b);
            }
            throw new IllegalArgumentException("Invalid end icon mode: " + i3);
        }

        EndIconDelegate c(int i3) {
            EndIconDelegate endIconDelegate = (EndIconDelegate) this.f82263a.get(i3);
            if (endIconDelegate != null) {
                return endIconDelegate;
            }
            EndIconDelegate endIconDelegateB = b(i3);
            this.f82263a.append(i3, endIconDelegateB);
            return endIconDelegateB;
        }
    }

    EndCompoundLayout(TextInputLayout textInputLayout, TintTypedArray tintTypedArray) {
        super(textInputLayout.getContext());
        this.f82245j = 0;
        this.f82246k = new LinkedHashSet();
        this.f82258w = new TextWatcherAdapter() { // from class: com.google.android.material.textfield.EndCompoundLayout.1
            @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                EndCompoundLayout.this.m().a(editable);
            }

            @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                EndCompoundLayout.this.m().b(charSequence, i3, i4, i5);
            }
        };
        TextInputLayout.OnEditTextAttachedListener onEditTextAttachedListener = new TextInputLayout.OnEditTextAttachedListener() { // from class: com.google.android.material.textfield.EndCompoundLayout.2
            @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
            public void a(TextInputLayout textInputLayout2) {
                if (EndCompoundLayout.this.f82255t == textInputLayout2.getEditText()) {
                    return;
                }
                if (EndCompoundLayout.this.f82255t != null) {
                    EndCompoundLayout.this.f82255t.removeTextChangedListener(EndCompoundLayout.this.f82258w);
                    if (EndCompoundLayout.this.f82255t.getOnFocusChangeListener() == EndCompoundLayout.this.m().e()) {
                        EndCompoundLayout.this.f82255t.setOnFocusChangeListener(null);
                    }
                }
                EndCompoundLayout.this.f82255t = textInputLayout2.getEditText();
                if (EndCompoundLayout.this.f82255t != null) {
                    EndCompoundLayout.this.f82255t.addTextChangedListener(EndCompoundLayout.this.f82258w);
                }
                EndCompoundLayout.this.m().n(EndCompoundLayout.this.f82255t);
                EndCompoundLayout endCompoundLayout = EndCompoundLayout.this;
                endCompoundLayout.h0(endCompoundLayout.m());
            }
        };
        this.f82259x = onEditTextAttachedListener;
        this.f82256u = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f82237a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f82238b = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonI = i(this, layoutInflaterFrom, R.id.f79643l0);
        this.f82239c = checkableImageButtonI;
        CheckableImageButton checkableImageButtonI2 = i(frameLayout, layoutInflaterFrom, R.id.f79641k0);
        this.f82243h = checkableImageButtonI2;
        this.f82244i = new EndIconDelegates(this, tintTypedArray);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f82253r = appCompatTextView;
        C(tintTypedArray);
        B(tintTypedArray);
        D(tintTypedArray);
        frameLayout.addView(checkableImageButtonI2);
        addView(appCompatTextView);
        addView(frameLayout);
        addView(checkableImageButtonI);
        textInputLayout.i(onEditTextAttachedListener);
        addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.google.android.material.textfield.EndCompoundLayout.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                EndCompoundLayout.this.g();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                EndCompoundLayout.this.M();
            }
        });
    }

    private void B(TintTypedArray tintTypedArray) {
        int i3 = R.styleable.j9;
        if (!tintTypedArray.s(i3)) {
            int i4 = R.styleable.O8;
            if (tintTypedArray.s(i4)) {
                this.f82247l = MaterialResources.b(getContext(), tintTypedArray, i4);
            }
            int i5 = R.styleable.P8;
            if (tintTypedArray.s(i5)) {
                this.f82248m = ViewUtils.p(tintTypedArray.k(i5, -1), null);
            }
        }
        int i6 = R.styleable.M8;
        if (tintTypedArray.s(i6)) {
            U(tintTypedArray.k(i6, 0));
            int i7 = R.styleable.J8;
            if (tintTypedArray.s(i7)) {
                Q(tintTypedArray.p(i7));
            }
            O(tintTypedArray.a(R.styleable.I8, true));
        } else if (tintTypedArray.s(i3)) {
            int i8 = R.styleable.k9;
            if (tintTypedArray.s(i8)) {
                this.f82247l = MaterialResources.b(getContext(), tintTypedArray, i8);
            }
            int i9 = R.styleable.l9;
            if (tintTypedArray.s(i9)) {
                this.f82248m = ViewUtils.p(tintTypedArray.k(i9, -1), null);
            }
            U(tintTypedArray.a(i3, false) ? 1 : 0);
            Q(tintTypedArray.p(R.styleable.h9));
        }
        T(tintTypedArray.f(R.styleable.L8, getResources().getDimensionPixelSize(R.dimen.A0)));
        int i10 = R.styleable.N8;
        if (tintTypedArray.s(i10)) {
            X(IconHelper.b(tintTypedArray.k(i10, -1)));
        }
    }

    private void C(TintTypedArray tintTypedArray) {
        int i3 = R.styleable.U8;
        if (tintTypedArray.s(i3)) {
            this.f82240d = MaterialResources.b(getContext(), tintTypedArray, i3);
        }
        int i4 = R.styleable.V8;
        if (tintTypedArray.s(i4)) {
            this.f82241f = ViewUtils.p(tintTypedArray.k(i4, -1), null);
        }
        int i5 = R.styleable.T8;
        if (tintTypedArray.s(i5)) {
            c0(tintTypedArray.g(i5));
        }
        this.f82239c.setContentDescription(getResources().getText(R.string.f79707f));
        ViewCompat.w0(this.f82239c, 2);
        this.f82239c.setClickable(false);
        this.f82239c.setPressable(false);
        this.f82239c.setFocusable(false);
    }

    private void D(TintTypedArray tintTypedArray) {
        this.f82253r.setVisibility(8);
        this.f82253r.setId(R.id.f79655r0);
        this.f82253r.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        ViewCompat.o0(this.f82253r, 1);
        q0(tintTypedArray.n(R.styleable.A9, 0));
        int i3 = R.styleable.B9;
        if (tintTypedArray.s(i3)) {
            r0(tintTypedArray.c(i3));
        }
        p0(tintTypedArray.p(R.styleable.z9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        AccessibilityManager accessibilityManager;
        AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.f82257v;
        if (touchExplorationStateChangeListener == null || (accessibilityManager = this.f82256u) == null) {
            return;
        }
        AccessibilityManagerCompat.b(accessibilityManager, touchExplorationStateChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f82257v == null || this.f82256u == null || !ViewCompat.Q(this)) {
            return;
        }
        AccessibilityManagerCompat.a(this.f82256u, this.f82257v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(EndIconDelegate endIconDelegate) {
        if (this.f82255t == null) {
            return;
        }
        if (endIconDelegate.e() != null) {
            this.f82255t.setOnFocusChangeListener(endIconDelegate.e());
        }
        if (endIconDelegate.g() != null) {
            this.f82243h.setOnFocusChangeListener(endIconDelegate.g());
        }
    }

    private CheckableImageButton i(ViewGroup viewGroup, LayoutInflater layoutInflater, int i3) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.f79680k, viewGroup, false);
        checkableImageButton.setId(i3);
        IconHelper.e(checkableImageButton);
        if (MaterialResources.j(getContext())) {
            MarginLayoutParamsCompat.d((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        return checkableImageButton;
    }

    private void j(int i3) {
        Iterator it = this.f82246k.iterator();
        while (it.hasNext()) {
            ((TextInputLayout.OnEndIconChangedListener) it.next()).a(this.f82237a, i3);
        }
    }

    private void s0(EndIconDelegate endIconDelegate) {
        endIconDelegate.s();
        this.f82257v = endIconDelegate.h();
        g();
    }

    private int t(EndIconDelegate endIconDelegate) {
        int i3 = this.f82244i.f82265c;
        return i3 == 0 ? endIconDelegate.d() : i3;
    }

    private void t0(EndIconDelegate endIconDelegate) {
        M();
        this.f82257v = null;
        endIconDelegate.u();
    }

    private void u0(boolean z2) {
        if (!z2 || n() == null) {
            IconHelper.a(this.f82237a, this.f82243h, this.f82247l, this.f82248m);
            return;
        }
        Drawable drawableMutate = DrawableCompat.r(n()).mutate();
        DrawableCompat.n(drawableMutate, this.f82237a.getErrorCurrentTextColors());
        this.f82243h.setImageDrawable(drawableMutate);
    }

    private void v0() {
        this.f82238b.setVisibility((this.f82243h.getVisibility() != 0 || G()) ? 8 : 0);
        setVisibility((F() || G() || ((this.f82252q == null || this.f82254s) ? '\b' : (char) 0) == 0) ? 0 : 8);
    }

    private void w0() {
        this.f82239c.setVisibility(s() != null && this.f82237a.N() && this.f82237a.b0() ? 0 : 8);
        v0();
        x0();
        if (A()) {
            return;
        }
        this.f82237a.m0();
    }

    private void y0() {
        int visibility = this.f82253r.getVisibility();
        int i3 = (this.f82252q == null || this.f82254s) ? 8 : 0;
        if (visibility != i3) {
            m().q(i3 == 0);
        }
        v0();
        this.f82253r.setVisibility(i3);
        this.f82237a.m0();
    }

    boolean A() {
        return this.f82245j != 0;
    }

    boolean E() {
        return A() && this.f82243h.isChecked();
    }

    boolean F() {
        return this.f82238b.getVisibility() == 0 && this.f82243h.getVisibility() == 0;
    }

    boolean G() {
        return this.f82239c.getVisibility() == 0;
    }

    void H(boolean z2) {
        this.f82254s = z2;
        y0();
    }

    void I() {
        w0();
        K();
        J();
        if (m().t()) {
            u0(this.f82237a.b0());
        }
    }

    void J() {
        IconHelper.d(this.f82237a, this.f82243h, this.f82247l);
    }

    void K() {
        IconHelper.d(this.f82237a, this.f82239c, this.f82240d);
    }

    void L(boolean z2) {
        boolean z3;
        boolean zIsActivated;
        boolean zIsChecked;
        EndIconDelegate endIconDelegateM = m();
        boolean z4 = true;
        if (!endIconDelegateM.l() || (zIsChecked = this.f82243h.isChecked()) == endIconDelegateM.m()) {
            z3 = false;
        } else {
            this.f82243h.setChecked(!zIsChecked);
            z3 = true;
        }
        if (!endIconDelegateM.j() || (zIsActivated = this.f82243h.isActivated()) == endIconDelegateM.k()) {
            z4 = z3;
        } else {
            N(!zIsActivated);
        }
        if (z2 || z4) {
            J();
        }
    }

    void N(boolean z2) {
        this.f82243h.setActivated(z2);
    }

    void O(boolean z2) {
        this.f82243h.setCheckable(z2);
    }

    void P(int i3) {
        Q(i3 != 0 ? getResources().getText(i3) : null);
    }

    void Q(CharSequence charSequence) {
        if (l() != charSequence) {
            this.f82243h.setContentDescription(charSequence);
        }
    }

    void R(int i3) {
        S(i3 != 0 ? AppCompatResources.b(getContext(), i3) : null);
    }

    void S(Drawable drawable) {
        this.f82243h.setImageDrawable(drawable);
        if (drawable != null) {
            IconHelper.a(this.f82237a, this.f82243h, this.f82247l, this.f82248m);
            J();
        }
    }

    void T(int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (i3 != this.f82249n) {
            this.f82249n = i3;
            IconHelper.g(this.f82243h, i3);
            IconHelper.g(this.f82239c, i3);
        }
    }

    void U(int i3) {
        if (this.f82245j == i3) {
            return;
        }
        t0(m());
        int i4 = this.f82245j;
        this.f82245j = i3;
        j(i4);
        a0(i3 != 0);
        EndIconDelegate endIconDelegateM = m();
        R(t(endIconDelegateM));
        P(endIconDelegateM.c());
        O(endIconDelegateM.l());
        if (!endIconDelegateM.i(this.f82237a.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + this.f82237a.getBoxBackgroundMode() + " is not supported by the end icon mode " + i3);
        }
        s0(endIconDelegateM);
        V(endIconDelegateM.f());
        EditText editText = this.f82255t;
        if (editText != null) {
            endIconDelegateM.n(editText);
            h0(endIconDelegateM);
        }
        IconHelper.a(this.f82237a, this.f82243h, this.f82247l, this.f82248m);
        L(true);
    }

    void V(View.OnClickListener onClickListener) {
        IconHelper.h(this.f82243h, onClickListener, this.f82251p);
    }

    void W(View.OnLongClickListener onLongClickListener) {
        this.f82251p = onLongClickListener;
        IconHelper.i(this.f82243h, onLongClickListener);
    }

    void X(ImageView.ScaleType scaleType) {
        this.f82250o = scaleType;
        IconHelper.j(this.f82243h, scaleType);
        IconHelper.j(this.f82239c, scaleType);
    }

    void Y(ColorStateList colorStateList) {
        if (this.f82247l != colorStateList) {
            this.f82247l = colorStateList;
            IconHelper.a(this.f82237a, this.f82243h, colorStateList, this.f82248m);
        }
    }

    void Z(PorterDuff.Mode mode) {
        if (this.f82248m != mode) {
            this.f82248m = mode;
            IconHelper.a(this.f82237a, this.f82243h, this.f82247l, mode);
        }
    }

    void a0(boolean z2) {
        if (F() != z2) {
            this.f82243h.setVisibility(z2 ? 0 : 8);
            v0();
            x0();
            this.f82237a.m0();
        }
    }

    void b0(int i3) {
        c0(i3 != 0 ? AppCompatResources.b(getContext(), i3) : null);
        K();
    }

    void c0(Drawable drawable) {
        this.f82239c.setImageDrawable(drawable);
        w0();
        IconHelper.a(this.f82237a, this.f82239c, this.f82240d, this.f82241f);
    }

    void d0(View.OnClickListener onClickListener) {
        IconHelper.h(this.f82239c, onClickListener, this.f82242g);
    }

    void e0(View.OnLongClickListener onLongClickListener) {
        this.f82242g = onLongClickListener;
        IconHelper.i(this.f82239c, onLongClickListener);
    }

    void f0(ColorStateList colorStateList) {
        if (this.f82240d != colorStateList) {
            this.f82240d = colorStateList;
            IconHelper.a(this.f82237a, this.f82239c, colorStateList, this.f82241f);
        }
    }

    void g0(PorterDuff.Mode mode) {
        if (this.f82241f != mode) {
            this.f82241f = mode;
            IconHelper.a(this.f82237a, this.f82239c, this.f82240d, mode);
        }
    }

    void h() {
        this.f82243h.performClick();
        this.f82243h.jumpDrawablesToCurrentState();
    }

    void i0(int i3) {
        j0(i3 != 0 ? getResources().getText(i3) : null);
    }

    void j0(CharSequence charSequence) {
        this.f82243h.setContentDescription(charSequence);
    }

    CheckableImageButton k() {
        if (G()) {
            return this.f82239c;
        }
        if (A() && F()) {
            return this.f82243h;
        }
        return null;
    }

    void k0(int i3) {
        l0(i3 != 0 ? AppCompatResources.b(getContext(), i3) : null);
    }

    CharSequence l() {
        return this.f82243h.getContentDescription();
    }

    void l0(Drawable drawable) {
        this.f82243h.setImageDrawable(drawable);
    }

    EndIconDelegate m() {
        return this.f82244i.c(this.f82245j);
    }

    void m0(boolean z2) {
        if (z2 && this.f82245j != 1) {
            U(1);
        } else {
            if (z2) {
                return;
            }
            U(0);
        }
    }

    Drawable n() {
        return this.f82243h.getDrawable();
    }

    void n0(ColorStateList colorStateList) {
        this.f82247l = colorStateList;
        IconHelper.a(this.f82237a, this.f82243h, colorStateList, this.f82248m);
    }

    int o() {
        return this.f82249n;
    }

    void o0(PorterDuff.Mode mode) {
        this.f82248m = mode;
        IconHelper.a(this.f82237a, this.f82243h, this.f82247l, mode);
    }

    int p() {
        return this.f82245j;
    }

    void p0(CharSequence charSequence) {
        this.f82252q = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f82253r.setText(charSequence);
        y0();
    }

    ImageView.ScaleType q() {
        return this.f82250o;
    }

    void q0(int i3) {
        TextViewCompat.o(this.f82253r, i3);
    }

    CheckableImageButton r() {
        return this.f82243h;
    }

    void r0(ColorStateList colorStateList) {
        this.f82253r.setTextColor(colorStateList);
    }

    Drawable s() {
        return this.f82239c.getDrawable();
    }

    CharSequence u() {
        return this.f82243h.getContentDescription();
    }

    Drawable v() {
        return this.f82243h.getDrawable();
    }

    CharSequence w() {
        return this.f82252q;
    }

    ColorStateList x() {
        return this.f82253r.getTextColors();
    }

    void x0() {
        if (this.f82237a.f82336d == null) {
            return;
        }
        ViewCompat.D0(this.f82253r, getContext().getResources().getDimensionPixelSize(R.dimen.Y), this.f82237a.f82336d.getPaddingTop(), (F() || G()) ? 0 : ViewCompat.C(this.f82237a.f82336d), this.f82237a.f82336d.getPaddingBottom());
    }

    int y() {
        return ViewCompat.C(this) + ViewCompat.C(this.f82253r) + ((F() || G()) ? this.f82243h.getMeasuredWidth() + MarginLayoutParamsCompat.b((ViewGroup.MarginLayoutParams) this.f82243h.getLayoutParams()) : 0);
    }

    TextView z() {
        return this.f82253r;
    }
}
