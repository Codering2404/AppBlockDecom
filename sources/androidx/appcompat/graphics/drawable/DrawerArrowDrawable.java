package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.DrawableCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class DrawerArrowDrawable extends Drawable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final float f1229m = (float) Math.toRadians(45.0d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f1230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f1231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f1232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f1233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f1234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1235f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Path f1236g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f1237h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1238i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f1239j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f1240k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1241l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ArrowDirection {
    }

    public DrawerArrowDrawable(Context context) {
        Paint paint = new Paint();
        this.f1230a = paint;
        this.f1236g = new Path();
        this.f1238i = false;
        this.f1241l = 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.f811b1, R.attr.X, R.style.f800b);
        d(typedArrayObtainStyledAttributes.getColor(R.styleable.f827f1, 0));
        c(typedArrayObtainStyledAttributes.getDimension(R.styleable.f843j1, 0.0f));
        f(typedArrayObtainStyledAttributes.getBoolean(R.styleable.f839i1, true));
        e(Math.round(typedArrayObtainStyledAttributes.getDimension(R.styleable.f835h1, 0.0f)));
        this.f1237h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.f831g1, 0);
        this.f1232c = Math.round(typedArrayObtainStyledAttributes.getDimension(R.styleable.f823e1, 0.0f));
        this.f1231b = Math.round(typedArrayObtainStyledAttributes.getDimension(R.styleable.f815c1, 0.0f));
        this.f1233d = typedArrayObtainStyledAttributes.getDimension(R.styleable.f819d1, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    private static float b(float f3, float f4, float f5) {
        return f3 + ((f4 - f3) * f5);
    }

    public float a() {
        return this.f1239j;
    }

    public void c(float f3) {
        if (this.f1230a.getStrokeWidth() != f3) {
            this.f1230a.setStrokeWidth(f3);
            this.f1240k = (float) (((double) (f3 / 2.0f)) * Math.cos(f1229m));
            invalidateSelf();
        }
    }

    public void d(int i3) {
        if (i3 != this.f1230a.getColor()) {
            this.f1230a.setColor(i3);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i3 = this.f1241l;
        boolean z2 = false;
        if (i3 != 0 && (i3 == 1 || (i3 == 3 ? DrawableCompat.f(this) == 0 : DrawableCompat.f(this) == 1))) {
            z2 = true;
        }
        float f3 = this.f1231b;
        float fB = b(this.f1232c, (float) Math.sqrt(f3 * f3 * 2.0f), this.f1239j);
        float fB2 = b(this.f1232c, this.f1233d, this.f1239j);
        float fRound = Math.round(b(0.0f, this.f1240k, this.f1239j));
        float fB3 = b(0.0f, f1229m, this.f1239j);
        float fB4 = b(z2 ? 0.0f : -180.0f, z2 ? 180.0f : 0.0f, this.f1239j);
        double d3 = fB;
        double d4 = fB3;
        boolean z3 = z2;
        float fRound2 = Math.round(Math.cos(d4) * d3);
        float fRound3 = Math.round(d3 * Math.sin(d4));
        this.f1236g.rewind();
        float fB5 = b(this.f1234e + this.f1230a.getStrokeWidth(), -this.f1240k, this.f1239j);
        float f4 = (-fB2) / 2.0f;
        this.f1236g.moveTo(f4 + fRound, 0.0f);
        this.f1236g.rLineTo(fB2 - (fRound * 2.0f), 0.0f);
        this.f1236g.moveTo(f4, fB5);
        this.f1236g.rLineTo(fRound2, fRound3);
        this.f1236g.moveTo(f4, -fB5);
        this.f1236g.rLineTo(fRound2, -fRound3);
        this.f1236g.close();
        canvas.save();
        float strokeWidth = this.f1230a.getStrokeWidth();
        float fHeight = bounds.height() - (3.0f * strokeWidth);
        canvas.translate(bounds.centerX(), ((((int) (fHeight - (r5 * 2.0f))) / 4) * 2) + (strokeWidth * 1.5f) + this.f1234e);
        if (this.f1235f) {
            canvas.rotate(fB4 * (this.f1238i ^ z3 ? -1 : 1));
        } else if (z3) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.f1236g, this.f1230a);
        canvas.restore();
    }

    public void e(float f3) {
        if (f3 != this.f1234e) {
            this.f1234e = f3;
            invalidateSelf();
        }
    }

    public void f(boolean z2) {
        if (this.f1235f != z2) {
            this.f1235f = z2;
            invalidateSelf();
        }
    }

    public void g(boolean z2) {
        if (this.f1238i != z2) {
            this.f1238i = z2;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f1237h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f1237h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (i3 != this.f1230a.getAlpha()) {
            this.f1230a.setAlpha(i3);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1230a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setProgress(float f3) {
        if (this.f1239j != f3) {
            this.f1239j = f3;
            invalidateSelf();
        }
    }
}
