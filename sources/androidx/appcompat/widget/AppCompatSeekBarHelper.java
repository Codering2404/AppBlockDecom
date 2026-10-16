package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SeekBar f1849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f1850e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ColorStateList f1851f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private PorterDuff.Mode f1852g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1853h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1854i;

    AppCompatSeekBarHelper(SeekBar seekBar) {
        super(seekBar);
        this.f1851f = null;
        this.f1852g = null;
        this.f1853h = false;
        this.f1854i = false;
        this.f1849d = seekBar;
    }

    private void f() {
        Drawable drawable = this.f1850e;
        if (drawable != null) {
            if (this.f1853h || this.f1854i) {
                Drawable drawableR = DrawableCompat.r(drawable.mutate());
                this.f1850e = drawableR;
                if (this.f1853h) {
                    DrawableCompat.o(drawableR, this.f1851f);
                }
                if (this.f1854i) {
                    DrawableCompat.p(this.f1850e, this.f1852g);
                }
                if (this.f1850e.isStateful()) {
                    this.f1850e.setState(this.f1849d.getDrawableState());
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatProgressBarHelper
    void c(AttributeSet attributeSet, int i3) {
        super.c(attributeSet, i3);
        Context context = this.f1849d.getContext();
        int[] iArr = R.styleable.V;
        TintTypedArray tintTypedArrayV = TintTypedArray.v(context, attributeSet, iArr, i3, 0);
        SeekBar seekBar = this.f1849d;
        ViewCompat.k0(seekBar, seekBar.getContext(), iArr, attributeSet, tintTypedArrayV.r(), i3, 0);
        Drawable drawableH = tintTypedArrayV.h(R.styleable.W);
        if (drawableH != null) {
            this.f1849d.setThumb(drawableH);
        }
        j(tintTypedArrayV.g(R.styleable.X));
        int i4 = R.styleable.Z;
        if (tintTypedArrayV.s(i4)) {
            this.f1852g = DrawableUtils.e(tintTypedArrayV.k(i4, -1), this.f1852g);
            this.f1854i = true;
        }
        int i5 = R.styleable.Y;
        if (tintTypedArrayV.s(i5)) {
            this.f1851f = tintTypedArrayV.c(i5);
            this.f1853h = true;
        }
        tintTypedArrayV.x();
        f();
    }

    void g(Canvas canvas) {
        if (this.f1850e != null) {
            int max = this.f1849d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f1850e.getIntrinsicWidth();
                int intrinsicHeight = this.f1850e.getIntrinsicHeight();
                int i3 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i4 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f1850e.setBounds(-i3, -i4, i3, i4);
                float width = ((this.f1849d.getWidth() - this.f1849d.getPaddingLeft()) - this.f1849d.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.f1849d.getPaddingLeft(), this.f1849d.getHeight() / 2);
                for (int i5 = 0; i5 <= max; i5++) {
                    this.f1850e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    void h() {
        Drawable drawable = this.f1850e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1849d.getDrawableState())) {
            this.f1849d.invalidateDrawable(drawable);
        }
    }

    void i() {
        Drawable drawable = this.f1850e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void j(Drawable drawable) {
        Drawable drawable2 = this.f1850e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1850e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1849d);
            DrawableCompat.m(drawable, this.f1849d.getLayoutDirection());
            if (drawable.isStateful()) {
                drawable.setState(this.f1849d.getDrawableState());
            }
            f();
        }
        this.f1849d.invalidate();
    }
}
