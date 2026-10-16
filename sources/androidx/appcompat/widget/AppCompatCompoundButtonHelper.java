package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CompoundButtonCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class AppCompatCompoundButtonHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CompoundButton f1770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ColorStateList f1771b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f1772c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1773d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1774e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1775f;

    AppCompatCompoundButtonHelper(CompoundButton compoundButton) {
        this.f1770a = compoundButton;
    }

    void a() {
        Drawable drawableA = CompoundButtonCompat.a(this.f1770a);
        if (drawableA != null) {
            if (this.f1773d || this.f1774e) {
                Drawable drawableMutate = DrawableCompat.r(drawableA).mutate();
                if (this.f1773d) {
                    DrawableCompat.o(drawableMutate, this.f1771b);
                }
                if (this.f1774e) {
                    DrawableCompat.p(drawableMutate, this.f1772c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f1770a.getDrawableState());
                }
                this.f1770a.setButtonDrawable(drawableMutate);
            }
        }
    }

    ColorStateList b() {
        return this.f1771b;
    }

    PorterDuff.Mode c() {
        return this.f1772c;
    }

    void d(AttributeSet attributeSet, int i3) {
        int i4;
        int iN;
        int iN2;
        Context context = this.f1770a.getContext();
        int[] iArr = R.styleable.W0;
        TintTypedArray tintTypedArrayV = TintTypedArray.v(context, attributeSet, iArr, i3, 0);
        CompoundButton compoundButton = this.f1770a;
        ViewCompat.k0(compoundButton, compoundButton.getContext(), iArr, attributeSet, tintTypedArrayV.r(), i3, 0);
        try {
            int i5 = R.styleable.Y0;
            if (!tintTypedArrayV.s(i5) || (iN2 = tintTypedArrayV.n(i5, 0)) == 0) {
                i4 = R.styleable.X0;
                if (tintTypedArrayV.s(i4) && (iN = tintTypedArrayV.n(i4, 0)) != 0) {
                    CompoundButton compoundButton2 = this.f1770a;
                    compoundButton2.setButtonDrawable(AppCompatResources.b(compoundButton2.getContext(), iN));
                }
            } else {
                try {
                    CompoundButton compoundButton3 = this.f1770a;
                    compoundButton3.setButtonDrawable(AppCompatResources.b(compoundButton3.getContext(), iN2));
                } catch (Resources.NotFoundException unused) {
                    i4 = R.styleable.X0;
                    if (tintTypedArrayV.s(i4)) {
                        CompoundButton compoundButton22 = this.f1770a;
                        compoundButton22.setButtonDrawable(AppCompatResources.b(compoundButton22.getContext(), iN));
                    }
                }
            }
            int i6 = R.styleable.Z0;
            if (tintTypedArrayV.s(i6)) {
                CompoundButtonCompat.d(this.f1770a, tintTypedArrayV.c(i6));
            }
            int i7 = R.styleable.f807a1;
            if (tintTypedArrayV.s(i7)) {
                CompoundButtonCompat.e(this.f1770a, DrawableUtils.e(tintTypedArrayV.k(i7, -1), null));
            }
            tintTypedArrayV.x();
        } catch (Throwable th) {
            tintTypedArrayV.x();
            throw th;
        }
    }

    void e() {
        if (this.f1775f) {
            this.f1775f = false;
        } else {
            this.f1775f = true;
            a();
        }
    }

    void f(ColorStateList colorStateList) {
        this.f1771b = colorStateList;
        this.f1773d = true;
        a();
    }

    void g(PorterDuff.Mode mode) {
        this.f1772c = mode;
        this.f1774e = true;
        a();
    }
}
