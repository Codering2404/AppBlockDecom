package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.cardview.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class RoundRectDrawableWithShadow extends Drawable {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final double f2768q = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    static RoundRectHelper f2769r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2770a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Paint f2772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Paint f2773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RectF f2774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f2775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Path f2776g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f2777h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f2778i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f2779j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ColorStateList f2780k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f2782m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f2783n;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f2781l = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f2784o = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f2785p = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Paint f2771b = new Paint(5);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface RoundRectHelper {
        void a(Canvas canvas, RectF rectF, float f3, Paint paint);
    }

    RoundRectDrawableWithShadow(Resources resources, ColorStateList colorStateList, float f3, float f4, float f5) {
        this.f2782m = resources.getColor(R.color.f2726d);
        this.f2783n = resources.getColor(R.color.f2725c);
        this.f2770a = resources.getDimensionPixelSize(R.dimen.f2727a);
        n(colorStateList);
        Paint paint = new Paint(5);
        this.f2772c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f2775f = (int) (f3 + 0.5f);
        this.f2774e = new RectF();
        Paint paint2 = new Paint(this.f2772c);
        this.f2773d = paint2;
        paint2.setAntiAlias(false);
        s(f4, f5);
    }

    private void a(Rect rect) {
        float f3 = this.f2777h;
        float f4 = 1.5f * f3;
        this.f2774e.set(rect.left + f3, rect.top + f4, rect.right - f3, rect.bottom - f4);
        b();
    }

    private void b() {
        float f3 = this.f2775f;
        RectF rectF = new RectF(-f3, -f3, f3, f3);
        RectF rectF2 = new RectF(rectF);
        float f4 = this.f2778i;
        rectF2.inset(-f4, -f4);
        Path path = this.f2776g;
        if (path == null) {
            this.f2776g = new Path();
        } else {
            path.reset();
        }
        this.f2776g.setFillType(Path.FillType.EVEN_ODD);
        this.f2776g.moveTo(-this.f2775f, 0.0f);
        this.f2776g.rLineTo(-this.f2778i, 0.0f);
        this.f2776g.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f2776g.arcTo(rectF, 270.0f, -90.0f, false);
        this.f2776g.close();
        float f5 = this.f2775f;
        float f6 = f5 / (this.f2778i + f5);
        Paint paint = this.f2772c;
        float f7 = this.f2775f + this.f2778i;
        int i3 = this.f2782m;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f7, new int[]{i3, i3, this.f2783n}, new float[]{0.0f, f6, 1.0f}, tileMode));
        Paint paint2 = this.f2773d;
        float f8 = this.f2775f;
        float f9 = this.f2778i;
        float f10 = (-f8) + f9;
        float f11 = (-f8) - f9;
        int i4 = this.f2782m;
        paint2.setShader(new LinearGradient(0.0f, f10, 0.0f, f11, new int[]{i4, i4, this.f2783n}, new float[]{0.0f, 0.5f, 1.0f}, tileMode));
        this.f2773d.setAntiAlias(false);
    }

    static float c(float f3, float f4, boolean z2) {
        return z2 ? (float) (((double) f3) + ((1.0d - f2768q) * ((double) f4))) : f3;
    }

    static float d(float f3, float f4, boolean z2) {
        return z2 ? (float) (((double) (f3 * 1.5f)) + ((1.0d - f2768q) * ((double) f4))) : f3 * 1.5f;
    }

    private void e(Canvas canvas) {
        Canvas canvas2;
        float f3 = this.f2775f;
        float f4 = (-f3) - this.f2778i;
        float f5 = f3 + this.f2770a + (this.f2779j / 2.0f);
        float f6 = 2.0f * f5;
        boolean z2 = this.f2774e.width() - f6 > 0.0f;
        boolean z3 = this.f2774e.height() - f6 > 0.0f;
        int iSave = canvas.save();
        RectF rectF = this.f2774e;
        canvas.translate(rectF.left + f5, rectF.top + f5);
        canvas.drawPath(this.f2776g, this.f2772c);
        if (z2) {
            canvas2 = canvas;
            canvas2.drawRect(0.0f, f4, this.f2774e.width() - f6, -this.f2775f, this.f2773d);
        } else {
            canvas2 = canvas;
        }
        canvas2.restoreToCount(iSave);
        int iSave2 = canvas2.save();
        RectF rectF2 = this.f2774e;
        canvas2.translate(rectF2.right - f5, rectF2.bottom - f5);
        canvas2.rotate(180.0f);
        canvas2.drawPath(this.f2776g, this.f2772c);
        if (z2) {
            canvas2.drawRect(0.0f, f4, this.f2774e.width() - f6, (-this.f2775f) + this.f2778i, this.f2773d);
        }
        canvas2.restoreToCount(iSave2);
        int iSave3 = canvas2.save();
        RectF rectF3 = this.f2774e;
        canvas2.translate(rectF3.left + f5, rectF3.bottom - f5);
        canvas2.rotate(270.0f);
        canvas2.drawPath(this.f2776g, this.f2772c);
        if (z3) {
            canvas2.drawRect(0.0f, f4, this.f2774e.height() - f6, -this.f2775f, this.f2773d);
        }
        canvas2.restoreToCount(iSave3);
        int iSave4 = canvas2.save();
        RectF rectF4 = this.f2774e;
        canvas2.translate(rectF4.right - f5, rectF4.top + f5);
        canvas2.rotate(90.0f);
        canvas2.drawPath(this.f2776g, this.f2772c);
        if (z3) {
            canvas2.drawRect(0.0f, f4, this.f2774e.height() - f6, -this.f2775f, this.f2773d);
        }
        canvas2.restoreToCount(iSave4);
    }

    private void n(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f2780k = colorStateList;
        this.f2771b.setColor(colorStateList.getColorForState(getState(), this.f2780k.getDefaultColor()));
    }

    private void s(float f3, float f4) {
        if (f3 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f3 + ". Must be >= 0");
        }
        if (f4 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f4 + ". Must be >= 0");
        }
        float fT = t(f3);
        float fT2 = t(f4);
        if (fT > fT2) {
            if (!this.f2785p) {
                this.f2785p = true;
            }
            fT = fT2;
        }
        if (this.f2779j == fT && this.f2777h == fT2) {
            return;
        }
        this.f2779j = fT;
        this.f2777h = fT2;
        this.f2778i = (int) ((fT * 1.5f) + this.f2770a + 0.5f);
        this.f2781l = true;
        invalidateSelf();
    }

    private int t(float f3) {
        int i3 = (int) (f3 + 0.5f);
        return i3 % 2 == 1 ? i3 - 1 : i3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f2781l) {
            a(getBounds());
            this.f2781l = false;
        }
        canvas.translate(0.0f, this.f2779j / 2.0f);
        e(canvas);
        canvas.translate(0.0f, (-this.f2779j) / 2.0f);
        f2769r.a(canvas, this.f2774e, this.f2775f, this.f2771b);
    }

    ColorStateList f() {
        return this.f2780k;
    }

    float g() {
        return this.f2775f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iCeil = (int) Math.ceil(d(this.f2777h, this.f2775f, this.f2784o));
        int iCeil2 = (int) Math.ceil(c(this.f2777h, this.f2775f, this.f2784o));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    void h(Rect rect) {
        getPadding(rect);
    }

    float i() {
        return this.f2777h;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f2780k;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    float j() {
        float f3 = this.f2777h;
        return (Math.max(f3, this.f2775f + this.f2770a + ((f3 * 1.5f) / 2.0f)) * 2.0f) + (((this.f2777h * 1.5f) + this.f2770a) * 2.0f);
    }

    float k() {
        float f3 = this.f2777h;
        return (Math.max(f3, this.f2775f + this.f2770a + (f3 / 2.0f)) * 2.0f) + ((this.f2777h + this.f2770a) * 2.0f);
    }

    float l() {
        return this.f2779j;
    }

    void m(boolean z2) {
        this.f2784o = z2;
        invalidateSelf();
    }

    void o(ColorStateList colorStateList) {
        n(colorStateList);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f2781l = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f2780k;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f2771b.getColor() == colorForState) {
            return false;
        }
        this.f2771b.setColor(colorForState);
        this.f2781l = true;
        invalidateSelf();
        return true;
    }

    void p(float f3) {
        if (f3 < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f3 + ". Must be >= 0");
        }
        float f4 = (int) (f3 + 0.5f);
        if (this.f2775f == f4) {
            return;
        }
        this.f2775f = f4;
        this.f2781l = true;
        invalidateSelf();
    }

    void q(float f3) {
        s(this.f2779j, f3);
    }

    void r(float f3) {
        s(f3, this.f2777h);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f2771b.setAlpha(i3);
        this.f2772c.setAlpha(i3);
        this.f2773d.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2771b.setColorFilter(colorFilter);
    }
}
