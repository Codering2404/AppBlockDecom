package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class RoundRectDrawable extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f2757a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RectF f2759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f2760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f2761e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ColorStateList f2764h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private PorterDuffColorFilter f2765i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ColorStateList f2766j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2762f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f2763g = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PorterDuff.Mode f2767k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f2758b = new Paint(5);

    RoundRectDrawable(ColorStateList colorStateList, float f3) {
        this.f2757a = f3;
        e(colorStateList);
        this.f2759c = new RectF();
        this.f2760d = new Rect();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f2764h = colorStateList;
        this.f2758b.setColor(colorStateList.getColorForState(getState(), this.f2764h.getDefaultColor()));
    }

    private void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f2759c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f2760d.set(rect);
        if (this.f2762f) {
            this.f2760d.inset((int) Math.ceil(RoundRectDrawableWithShadow.c(this.f2761e, this.f2757a, this.f2763g)), (int) Math.ceil(RoundRectDrawableWithShadow.d(this.f2761e, this.f2757a, this.f2763g)));
            this.f2759c.set(this.f2760d);
        }
    }

    public ColorStateList b() {
        return this.f2764h;
    }

    float c() {
        return this.f2761e;
    }

    public float d() {
        return this.f2757a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z2;
        Paint paint = this.f2758b;
        if (this.f2765i == null || paint.getColorFilter() != null) {
            z2 = false;
        } else {
            paint.setColorFilter(this.f2765i);
            z2 = true;
        }
        RectF rectF = this.f2759c;
        float f3 = this.f2757a;
        canvas.drawRoundRect(rectF, f3, f3, paint);
        if (z2) {
            paint.setColorFilter(null);
        }
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    void g(float f3, boolean z2, boolean z3) {
        if (f3 == this.f2761e && this.f2762f == z2 && this.f2763g == z3) {
            return;
        }
        this.f2761e = f3;
        this.f2762f = z2;
        this.f2763g = z3;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f2760d, this.f2757a);
    }

    void h(float f3) {
        if (f3 == this.f2757a) {
            return;
        }
        this.f2757a = f3;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f2766j;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.f2764h;
        return (colorStateList2 != null && colorStateList2.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f2764h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z2 = colorForState != this.f2758b.getColor();
        if (z2) {
            this.f2758b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f2766j;
        if (colorStateList2 == null || (mode = this.f2767k) == null) {
            return z2;
        }
        this.f2765i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f2758b.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2758b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f2766j = colorStateList;
        this.f2765i = a(colorStateList, this.f2767k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f2767k = mode;
        this.f2765i = a(this.f2766j, mode);
        invalidateSelf();
    }
}
