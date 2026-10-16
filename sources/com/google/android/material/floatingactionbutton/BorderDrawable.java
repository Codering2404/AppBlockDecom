package com.google.android.material.floatingactionbutton;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class BorderDrawable extends Drawable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f80979b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f80985h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f80986i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f80987j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f80988k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f80989l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f80990m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ShapeAppearanceModel f80992o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ColorStateList f80993p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ShapeAppearancePathProvider f80978a = ShapeAppearancePathProvider.k();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Path f80980c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f80981d = new Rect();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RectF f80982e = new RectF();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RectF f80983f = new RectF();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final BorderState f80984g = new BorderState();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f80991n = true;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class BorderState extends Drawable.ConstantState {
        private BorderState() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return BorderDrawable.this;
        }
    }

    BorderDrawable(ShapeAppearanceModel shapeAppearanceModel) {
        this.f80992o = shapeAppearanceModel;
        Paint paint = new Paint(1);
        this.f80979b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    private Shader a() {
        copyBounds(this.f80981d);
        float fHeight = this.f80985h / r1.height();
        return new LinearGradient(0.0f, r1.top, 0.0f, r1.bottom, new int[]{ColorUtils.g(this.f80986i, this.f80990m), ColorUtils.g(this.f80987j, this.f80990m), ColorUtils.g(ColorUtils.k(this.f80987j, 0), this.f80990m), ColorUtils.g(ColorUtils.k(this.f80989l, 0), this.f80990m), ColorUtils.g(this.f80989l, this.f80990m), ColorUtils.g(this.f80988k, this.f80990m)}, new float[]{0.0f, fHeight, 0.5f, 0.5f, 1.0f - fHeight, 1.0f}, Shader.TileMode.CLAMP);
    }

    protected RectF b() {
        this.f80983f.set(getBounds());
        return this.f80983f;
    }

    void c(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f80990m = colorStateList.getColorForState(getState(), this.f80990m);
        }
        this.f80993p = colorStateList;
        this.f80991n = true;
        invalidateSelf();
    }

    public void d(float f3) {
        if (this.f80985h != f3) {
            this.f80985h = f3;
            this.f80979b.setStrokeWidth(f3 * 1.3333f);
            this.f80991n = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f80991n) {
            this.f80979b.setShader(a());
            this.f80991n = false;
        }
        float strokeWidth = this.f80979b.getStrokeWidth() / 2.0f;
        copyBounds(this.f80981d);
        this.f80982e.set(this.f80981d);
        float fMin = Math.min(this.f80992o.r().a(b()), this.f80982e.width() / 2.0f);
        if (this.f80992o.u(b())) {
            this.f80982e.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f80982e, fMin, fMin, this.f80979b);
        }
    }

    void e(int i3, int i4, int i5, int i6) {
        this.f80986i = i3;
        this.f80987j = i4;
        this.f80988k = i5;
        this.f80989l = i6;
    }

    public void f(ShapeAppearanceModel shapeAppearanceModel) {
        this.f80992o = shapeAppearanceModel;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f80984g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f80985h > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f80992o.u(b())) {
            outline.setRoundRect(getBounds(), this.f80992o.r().a(b()));
        } else {
            copyBounds(this.f80981d);
            this.f80982e.set(this.f80981d);
            this.f80978a.d(this.f80992o, 1.0f, this.f80982e, this.f80980c);
            DrawableUtils.l(outline, this.f80980c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        if (!this.f80992o.u(b())) {
            return true;
        }
        int iRound = Math.round(this.f80985h);
        rect.set(iRound, iRound, iRound, iRound);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f80993p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f80991n = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f80993p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.f80990m)) != this.f80990m) {
            this.f80991n = true;
            this.f80990m = colorForState;
        }
        if (this.f80991n) {
            invalidateSelf();
        }
        return this.f80991n;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f80979b.setAlpha(i3);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f80979b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
