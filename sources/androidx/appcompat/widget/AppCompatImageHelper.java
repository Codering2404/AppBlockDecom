package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatImageHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImageView f1809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TintInfo f1810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TintInfo f1811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TintInfo f1812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1813e = 0;

    public AppCompatImageHelper(ImageView imageView) {
        this.f1809a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.f1812d == null) {
            this.f1812d = new TintInfo();
        }
        TintInfo tintInfo = this.f1812d;
        tintInfo.a();
        ColorStateList colorStateListA = ImageViewCompat.a(this.f1809a);
        if (colorStateListA != null) {
            tintInfo.f2244d = true;
            tintInfo.f2241a = colorStateListA;
        }
        PorterDuff.Mode modeB = ImageViewCompat.b(this.f1809a);
        if (modeB != null) {
            tintInfo.f2243c = true;
            tintInfo.f2242b = modeB;
        }
        if (!tintInfo.f2244d && !tintInfo.f2243c) {
            return false;
        }
        AppCompatDrawableManager.i(drawable, tintInfo, this.f1809a.getDrawableState());
        return true;
    }

    private boolean l() {
        return this.f1810b != null;
    }

    void b() {
        if (this.f1809a.getDrawable() != null) {
            this.f1809a.getDrawable().setLevel(this.f1813e);
        }
    }

    void c() {
        Drawable drawable = this.f1809a.getDrawable();
        if (drawable != null) {
            DrawableUtils.b(drawable);
        }
        if (drawable != null) {
            if (l() && a(drawable)) {
                return;
            }
            TintInfo tintInfo = this.f1811c;
            if (tintInfo != null) {
                AppCompatDrawableManager.i(drawable, tintInfo, this.f1809a.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.f1810b;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.i(drawable, tintInfo2, this.f1809a.getDrawableState());
            }
        }
    }

    ColorStateList d() {
        TintInfo tintInfo = this.f1811c;
        if (tintInfo != null) {
            return tintInfo.f2241a;
        }
        return null;
    }

    PorterDuff.Mode e() {
        TintInfo tintInfo = this.f1811c;
        if (tintInfo != null) {
            return tintInfo.f2242b;
        }
        return null;
    }

    boolean f() {
        return !(this.f1809a.getBackground() instanceof RippleDrawable);
    }

    public void g(AttributeSet attributeSet, int i3) {
        int iN;
        Context context = this.f1809a.getContext();
        int[] iArr = R.styleable.R;
        TintTypedArray tintTypedArrayV = TintTypedArray.v(context, attributeSet, iArr, i3, 0);
        ImageView imageView = this.f1809a;
        ViewCompat.k0(imageView, imageView.getContext(), iArr, attributeSet, tintTypedArrayV.r(), i3, 0);
        try {
            Drawable drawable = this.f1809a.getDrawable();
            if (drawable == null && (iN = tintTypedArrayV.n(R.styleable.S, -1)) != -1 && (drawable = AppCompatResources.b(this.f1809a.getContext(), iN)) != null) {
                this.f1809a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                DrawableUtils.b(drawable);
            }
            int i4 = R.styleable.T;
            if (tintTypedArrayV.s(i4)) {
                ImageViewCompat.c(this.f1809a, tintTypedArrayV.c(i4));
            }
            int i5 = R.styleable.U;
            if (tintTypedArrayV.s(i5)) {
                ImageViewCompat.d(this.f1809a, DrawableUtils.e(tintTypedArrayV.k(i5, -1), null));
            }
            tintTypedArrayV.x();
        } catch (Throwable th) {
            tintTypedArrayV.x();
            throw th;
        }
    }

    void h(Drawable drawable) {
        this.f1813e = drawable.getLevel();
    }

    public void i(int i3) {
        if (i3 != 0) {
            Drawable drawableB = AppCompatResources.b(this.f1809a.getContext(), i3);
            if (drawableB != null) {
                DrawableUtils.b(drawableB);
            }
            this.f1809a.setImageDrawable(drawableB);
        } else {
            this.f1809a.setImageDrawable(null);
        }
        c();
    }

    void j(ColorStateList colorStateList) {
        if (this.f1811c == null) {
            this.f1811c = new TintInfo();
        }
        TintInfo tintInfo = this.f1811c;
        tintInfo.f2241a = colorStateList;
        tintInfo.f2244d = true;
        c();
    }

    void k(PorterDuff.Mode mode) {
        if (this.f1811c == null) {
            this.f1811c = new TintInfo();
        }
        TintInfo tintInfo = this.f1811c;
        tintInfo.f2242b = mode;
        tintInfo.f2243c = true;
        c();
    }
}
