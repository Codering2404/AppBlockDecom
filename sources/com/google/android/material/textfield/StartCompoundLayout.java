package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class StartCompoundLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextInputLayout f82318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextView f82319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CharSequence f82320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CheckableImageButton f82321d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ColorStateList f82322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private PorterDuff.Mode f82323g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f82324h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ImageView.ScaleType f82325i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private View.OnLongClickListener f82326j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f82327k;

    StartCompoundLayout(TextInputLayout textInputLayout, TintTypedArray tintTypedArray) {
        super(textInputLayout.getContext());
        this.f82318a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.f79681l, (ViewGroup) this, false);
        this.f82321d = checkableImageButton;
        IconHelper.e(checkableImageButton);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f82319b = appCompatTextView;
        j(tintTypedArray);
        i(tintTypedArray);
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    private void C() {
        int i3 = (this.f82320c == null || this.f82327k) ? 8 : 0;
        setVisibility((this.f82321d.getVisibility() == 0 || i3 == 0) ? 0 : 8);
        this.f82319b.setVisibility(i3);
        this.f82318a.m0();
    }

    private void i(TintTypedArray tintTypedArray) {
        this.f82319b.setVisibility(8);
        this.f82319b.setId(R.id.f79653q0);
        this.f82319b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ViewCompat.o0(this.f82319b, 1);
        o(tintTypedArray.n(R.styleable.q9, 0));
        int i3 = R.styleable.r9;
        if (tintTypedArray.s(i3)) {
            p(tintTypedArray.c(i3));
        }
        n(tintTypedArray.p(R.styleable.p9));
    }

    private void j(TintTypedArray tintTypedArray) {
        if (MaterialResources.j(getContext())) {
            MarginLayoutParamsCompat.c((ViewGroup.MarginLayoutParams) this.f82321d.getLayoutParams(), 0);
        }
        u(null);
        v(null);
        int i3 = R.styleable.x9;
        if (tintTypedArray.s(i3)) {
            this.f82322f = MaterialResources.b(getContext(), tintTypedArray, i3);
        }
        int i4 = R.styleable.y9;
        if (tintTypedArray.s(i4)) {
            this.f82323g = ViewUtils.p(tintTypedArray.k(i4, -1), null);
        }
        int i5 = R.styleable.u9;
        if (tintTypedArray.s(i5)) {
            s(tintTypedArray.g(i5));
            int i6 = R.styleable.t9;
            if (tintTypedArray.s(i6)) {
                r(tintTypedArray.p(i6));
            }
            q(tintTypedArray.a(R.styleable.s9, true));
        }
        t(tintTypedArray.f(R.styleable.v9, getResources().getDimensionPixelSize(R.dimen.A0)));
        int i7 = R.styleable.w9;
        if (tintTypedArray.s(i7)) {
            w(IconHelper.b(tintTypedArray.k(i7, -1)));
        }
    }

    void A(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (this.f82319b.getVisibility() != 0) {
            accessibilityNodeInfoCompat.S0(this.f82321d);
        } else {
            accessibilityNodeInfoCompat.x0(this.f82319b);
            accessibilityNodeInfoCompat.S0(this.f82319b);
        }
    }

    void B() {
        EditText editText = this.f82318a.f82336d;
        if (editText == null) {
            return;
        }
        ViewCompat.D0(this.f82319b, k() ? 0 : ViewCompat.D(editText), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.Y), editText.getCompoundPaddingBottom());
    }

    CharSequence a() {
        return this.f82320c;
    }

    ColorStateList b() {
        return this.f82319b.getTextColors();
    }

    int c() {
        return ViewCompat.D(this) + ViewCompat.D(this.f82319b) + (k() ? this.f82321d.getMeasuredWidth() + MarginLayoutParamsCompat.a((ViewGroup.MarginLayoutParams) this.f82321d.getLayoutParams()) : 0);
    }

    TextView d() {
        return this.f82319b;
    }

    CharSequence e() {
        return this.f82321d.getContentDescription();
    }

    Drawable f() {
        return this.f82321d.getDrawable();
    }

    int g() {
        return this.f82324h;
    }

    ImageView.ScaleType h() {
        return this.f82325i;
    }

    boolean k() {
        return this.f82321d.getVisibility() == 0;
    }

    void l(boolean z2) {
        this.f82327k = z2;
        C();
    }

    void m() {
        IconHelper.d(this.f82318a, this.f82321d, this.f82322f);
    }

    void n(CharSequence charSequence) {
        this.f82320c = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f82319b.setText(charSequence);
        C();
    }

    void o(int i3) {
        TextViewCompat.o(this.f82319b, i3);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        B();
    }

    void p(ColorStateList colorStateList) {
        this.f82319b.setTextColor(colorStateList);
    }

    void q(boolean z2) {
        this.f82321d.setCheckable(z2);
    }

    void r(CharSequence charSequence) {
        if (e() != charSequence) {
            this.f82321d.setContentDescription(charSequence);
        }
    }

    void s(Drawable drawable) {
        this.f82321d.setImageDrawable(drawable);
        if (drawable != null) {
            IconHelper.a(this.f82318a, this.f82321d, this.f82322f, this.f82323g);
            z(true);
            m();
        } else {
            z(false);
            u(null);
            v(null);
            r(null);
        }
    }

    void t(int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (i3 != this.f82324h) {
            this.f82324h = i3;
            IconHelper.g(this.f82321d, i3);
        }
    }

    void u(View.OnClickListener onClickListener) {
        IconHelper.h(this.f82321d, onClickListener, this.f82326j);
    }

    void v(View.OnLongClickListener onLongClickListener) {
        this.f82326j = onLongClickListener;
        IconHelper.i(this.f82321d, onLongClickListener);
    }

    void w(ImageView.ScaleType scaleType) {
        this.f82325i = scaleType;
        IconHelper.j(this.f82321d, scaleType);
    }

    void x(ColorStateList colorStateList) {
        if (this.f82322f != colorStateList) {
            this.f82322f = colorStateList;
            IconHelper.a(this.f82318a, this.f82321d, colorStateList, this.f82323g);
        }
    }

    void y(PorterDuff.Mode mode) {
        if (this.f82323g != mode) {
            this.f82323g = mode;
            IconHelper.a(this.f82318a, this.f82321d, this.f82322f, mode);
        }
    }

    void z(boolean z2) {
        if (k() != z2) {
            this.f82321d.setVisibility(z2 ? 0 : 8);
            B();
            C();
        }
    }
}
