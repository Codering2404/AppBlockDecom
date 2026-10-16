package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CheckedTextViewCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class AppCompatCheckedTextViewHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CheckedTextView f1764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ColorStateList f1765b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f1766c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1767d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1768e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1769f;

    AppCompatCheckedTextViewHelper(CheckedTextView checkedTextView) {
        this.f1764a = checkedTextView;
    }

    void a() {
        Drawable drawableA = CheckedTextViewCompat.a(this.f1764a);
        if (drawableA != null) {
            if (this.f1767d || this.f1768e) {
                Drawable drawableMutate = DrawableCompat.r(drawableA).mutate();
                if (this.f1767d) {
                    DrawableCompat.o(drawableMutate, this.f1765b);
                }
                if (this.f1768e) {
                    DrawableCompat.p(drawableMutate, this.f1766c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f1764a.getDrawableState());
                }
                this.f1764a.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    ColorStateList b() {
        return this.f1765b;
    }

    PorterDuff.Mode c() {
        return this.f1766c;
    }

    void d(AttributeSet attributeSet, int i3) {
        int i4;
        int iN;
        int iN2;
        Context context = this.f1764a.getContext();
        int[] iArr = R.styleable.R0;
        TintTypedArray tintTypedArrayV = TintTypedArray.v(context, attributeSet, iArr, i3, 0);
        CheckedTextView checkedTextView = this.f1764a;
        ViewCompat.k0(checkedTextView, checkedTextView.getContext(), iArr, attributeSet, tintTypedArrayV.r(), i3, 0);
        try {
            int i5 = R.styleable.T0;
            if (!tintTypedArrayV.s(i5) || (iN2 = tintTypedArrayV.n(i5, 0)) == 0) {
                i4 = R.styleable.S0;
                if (tintTypedArrayV.s(i4) && (iN = tintTypedArrayV.n(i4, 0)) != 0) {
                    CheckedTextView checkedTextView2 = this.f1764a;
                    checkedTextView2.setCheckMarkDrawable(AppCompatResources.b(checkedTextView2.getContext(), iN));
                }
            } else {
                try {
                    CheckedTextView checkedTextView3 = this.f1764a;
                    checkedTextView3.setCheckMarkDrawable(AppCompatResources.b(checkedTextView3.getContext(), iN2));
                } catch (Resources.NotFoundException unused) {
                    i4 = R.styleable.S0;
                    if (tintTypedArrayV.s(i4)) {
                        CheckedTextView checkedTextView22 = this.f1764a;
                        checkedTextView22.setCheckMarkDrawable(AppCompatResources.b(checkedTextView22.getContext(), iN));
                    }
                }
            }
            int i6 = R.styleable.U0;
            if (tintTypedArrayV.s(i6)) {
                CheckedTextViewCompat.b(this.f1764a, tintTypedArrayV.c(i6));
            }
            int i7 = R.styleable.V0;
            if (tintTypedArrayV.s(i7)) {
                CheckedTextViewCompat.c(this.f1764a, DrawableUtils.e(tintTypedArrayV.k(i7, -1), null));
            }
            tintTypedArrayV.x();
        } catch (Throwable th) {
            tintTypedArrayV.x();
            throw th;
        }
    }

    void e() {
        if (this.f1769f) {
            this.f1769f = false;
        } else {
            this.f1769f = true;
            a();
        }
    }

    void f(ColorStateList colorStateList) {
        this.f1765b = colorStateList;
        this.f1767d = true;
        a();
    }

    void g(PorterDuff.Mode mode) {
        this.f1766c = mode;
        this.f1768e = true;
        a();
    }
}
