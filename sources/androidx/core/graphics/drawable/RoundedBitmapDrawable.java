package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class RoundedBitmapDrawable extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Bitmap f34027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f34028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Paint f34029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final BitmapShader f34030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Matrix f34031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f34032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Rect f34033g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final RectF f34034h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f34035i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f34036j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f34037k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f34038l;

    private static boolean c(float f3) {
        return f3 > 0.05f;
    }

    private void d() {
        this.f34032f = Math.min(this.f34038l, this.f34037k) / 2;
    }

    public float a() {
        return this.f34032f;
    }

    void b(int i3, int i4, int i5, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f34027a;
        if (bitmap == null) {
            return;
        }
        e();
        if (this.f34029c.getShader() == null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.f34033g, this.f34029c);
            return;
        }
        RectF rectF = this.f34034h;
        float f3 = this.f34032f;
        canvas.drawRoundRect(rectF, f3, f3, this.f34029c);
    }

    void e() {
        RoundedBitmapDrawable roundedBitmapDrawable;
        if (this.f34035i) {
            if (this.f34036j) {
                int iMin = Math.min(this.f34037k, this.f34038l);
                roundedBitmapDrawable = this;
                roundedBitmapDrawable.b(this.f34028b, iMin, iMin, getBounds(), this.f34033g);
                int iMin2 = Math.min(roundedBitmapDrawable.f34033g.width(), roundedBitmapDrawable.f34033g.height());
                roundedBitmapDrawable.f34033g.inset(Math.max(0, (roundedBitmapDrawable.f34033g.width() - iMin2) / 2), Math.max(0, (roundedBitmapDrawable.f34033g.height() - iMin2) / 2));
                roundedBitmapDrawable.f34032f = iMin2 * 0.5f;
            } else {
                roundedBitmapDrawable = this;
                roundedBitmapDrawable.b(roundedBitmapDrawable.f34028b, roundedBitmapDrawable.f34037k, roundedBitmapDrawable.f34038l, getBounds(), roundedBitmapDrawable.f34033g);
            }
            roundedBitmapDrawable.f34034h.set(roundedBitmapDrawable.f34033g);
            if (roundedBitmapDrawable.f34030d != null) {
                Matrix matrix = roundedBitmapDrawable.f34031e;
                RectF rectF = roundedBitmapDrawable.f34034h;
                matrix.setTranslate(rectF.left, rectF.top);
                roundedBitmapDrawable.f34031e.preScale(roundedBitmapDrawable.f34034h.width() / roundedBitmapDrawable.f34027a.getWidth(), roundedBitmapDrawable.f34034h.height() / roundedBitmapDrawable.f34027a.getHeight());
                roundedBitmapDrawable.f34030d.setLocalMatrix(roundedBitmapDrawable.f34031e);
                roundedBitmapDrawable.f34029c.setShader(roundedBitmapDrawable.f34030d);
            }
            roundedBitmapDrawable.f34035i = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f34029c.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f34029c.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f34038l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f34037k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap;
        return (this.f34028b != 119 || this.f34036j || (bitmap = this.f34027a) == null || bitmap.hasAlpha() || this.f34029c.getAlpha() < 255 || c(this.f34032f)) ? -3 : -1;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.f34036j) {
            d();
        }
        this.f34035i = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (i3 != this.f34029c.getAlpha()) {
            this.f34029c.setAlpha(i3);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f34029c.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z2) {
        this.f34029c.setDither(z2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z2) {
        this.f34029c.setFilterBitmap(z2);
        invalidateSelf();
    }
}
