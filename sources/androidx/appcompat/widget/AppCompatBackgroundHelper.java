package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class AppCompatBackgroundHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f1723a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TintInfo f1726d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TintInfo f1727e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TintInfo f1728f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1725c = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AppCompatDrawableManager f1724b = AppCompatDrawableManager.b();

    AppCompatBackgroundHelper(View view) {
        this.f1723a = view;
    }

    private boolean a(Drawable drawable) {
        if (this.f1728f == null) {
            this.f1728f = new TintInfo();
        }
        TintInfo tintInfo = this.f1728f;
        tintInfo.a();
        ColorStateList colorStateListQ = ViewCompat.q(this.f1723a);
        if (colorStateListQ != null) {
            tintInfo.f2244d = true;
            tintInfo.f2241a = colorStateListQ;
        }
        PorterDuff.Mode modeR = ViewCompat.r(this.f1723a);
        if (modeR != null) {
            tintInfo.f2243c = true;
            tintInfo.f2242b = modeR;
        }
        if (!tintInfo.f2244d && !tintInfo.f2243c) {
            return false;
        }
        AppCompatDrawableManager.i(drawable, tintInfo, this.f1723a.getDrawableState());
        return true;
    }

    private boolean k() {
        return this.f1726d != null;
    }

    void b() {
        Drawable background = this.f1723a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            TintInfo tintInfo = this.f1727e;
            if (tintInfo != null) {
                AppCompatDrawableManager.i(background, tintInfo, this.f1723a.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.f1726d;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.i(background, tintInfo2, this.f1723a.getDrawableState());
            }
        }
    }

    ColorStateList c() {
        TintInfo tintInfo = this.f1727e;
        if (tintInfo != null) {
            return tintInfo.f2241a;
        }
        return null;
    }

    PorterDuff.Mode d() {
        TintInfo tintInfo = this.f1727e;
        if (tintInfo != null) {
            return tintInfo.f2242b;
        }
        return null;
    }

    void e(AttributeSet attributeSet, int i3) {
        Context context = this.f1723a.getContext();
        int[] iArr = R.styleable.U3;
        TintTypedArray tintTypedArrayV = TintTypedArray.v(context, attributeSet, iArr, i3, 0);
        View view = this.f1723a;
        ViewCompat.k0(view, view.getContext(), iArr, attributeSet, tintTypedArrayV.r(), i3, 0);
        try {
            int i4 = R.styleable.V3;
            if (tintTypedArrayV.s(i4)) {
                this.f1725c = tintTypedArrayV.n(i4, -1);
                ColorStateList colorStateListF = this.f1724b.f(this.f1723a.getContext(), this.f1725c);
                if (colorStateListF != null) {
                    h(colorStateListF);
                }
            }
            int i5 = R.styleable.W3;
            if (tintTypedArrayV.s(i5)) {
                ViewCompat.r0(this.f1723a, tintTypedArrayV.c(i5));
            }
            int i6 = R.styleable.X3;
            if (tintTypedArrayV.s(i6)) {
                ViewCompat.s0(this.f1723a, DrawableUtils.e(tintTypedArrayV.k(i6, -1), null));
            }
            tintTypedArrayV.x();
        } catch (Throwable th) {
            tintTypedArrayV.x();
            throw th;
        }
    }

    void f(Drawable drawable) {
        this.f1725c = -1;
        h(null);
        b();
    }

    void g(int i3) {
        this.f1725c = i3;
        AppCompatDrawableManager appCompatDrawableManager = this.f1724b;
        h(appCompatDrawableManager != null ? appCompatDrawableManager.f(this.f1723a.getContext(), i3) : null);
        b();
    }

    void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1726d == null) {
                this.f1726d = new TintInfo();
            }
            TintInfo tintInfo = this.f1726d;
            tintInfo.f2241a = colorStateList;
            tintInfo.f2244d = true;
        } else {
            this.f1726d = null;
        }
        b();
    }

    void i(ColorStateList colorStateList) {
        if (this.f1727e == null) {
            this.f1727e = new TintInfo();
        }
        TintInfo tintInfo = this.f1727e;
        tintInfo.f2241a = colorStateList;
        tintInfo.f2244d = true;
        b();
    }

    void j(PorterDuff.Mode mode) {
        if (this.f1727e == null) {
            this.f1727e = new TintInfo();
        }
        TintInfo tintInfo = this.f1727e;
        tintInfo.f2242b = mode;
        tintInfo.f2243c = true;
        b();
    }
}
