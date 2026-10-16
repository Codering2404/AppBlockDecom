package androidx.constraintlayout.utils.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.FloatLayout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MotionLabel extends View implements FloatLayout {
    static String R = "MotionLabel";
    private float A;
    Matrix B;
    private Bitmap C;
    private BitmapShader D;
    private Matrix E;
    private float F;
    private float G;
    private float H;
    private float I;
    Paint J;
    Rect K;
    Paint L;
    float M;
    float N;
    float O;
    float P;
    float Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    TextPaint f33042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Path f33043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f33044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f33045d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f33046f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f33047g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f33048h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    ViewOutlineProvider f33049i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    RectF f33050j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f33051k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f33052l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f33053m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f33054n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f33055o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Rect f33056p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f33057q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f33058r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f33059s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f33060t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Layout f33061u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f33062v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f33063w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f33064x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f33065y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f33066z;

    private void d(float f3, float f4, float f5, float f6) {
        if (this.E == null) {
            return;
        }
        this.f33066z = f5 - f3;
        this.A = f6 - f4;
        f();
    }

    private void f() {
        float f3 = Float.isNaN(this.N) ? 0.0f : this.N;
        float f4 = Float.isNaN(this.O) ? 0.0f : this.O;
        float f5 = Float.isNaN(this.P) ? 1.0f : this.P;
        float f6 = Float.isNaN(this.Q) ? 0.0f : this.Q;
        this.E.reset();
        float width = this.C.getWidth();
        float height = this.C.getHeight();
        float f7 = Float.isNaN(this.G) ? this.f33066z : this.G;
        float f8 = Float.isNaN(this.F) ? this.A : this.F;
        float f9 = f5 * (width * f8 < height * f7 ? f7 / width : f8 / height);
        this.E.postScale(f9, f9);
        float f10 = width * f9;
        float f11 = f7 - f10;
        float f12 = f9 * height;
        float f13 = f8 - f12;
        if (!Float.isNaN(this.F)) {
            f13 = this.F / 2.0f;
        }
        if (!Float.isNaN(this.G)) {
            f11 = this.G / 2.0f;
        }
        this.E.postTranslate((((f3 * f11) + f7) - f10) * 0.5f, (((f4 * f13) + f8) - f12) * 0.5f);
        this.E.postRotate(f6, f7 / 2.0f, f8 / 2.0f);
        this.D.setLocalMatrix(this.E);
    }

    private float getHorizontalOffset() {
        float f3 = Float.isNaN(this.f33052l) ? 1.0f : this.f33051k / this.f33052l;
        TextPaint textPaint = this.f33042a;
        String str = this.f33054n;
        return (((((Float.isNaN(this.f33066z) ? getMeasuredWidth() : this.f33066z) - getPaddingLeft()) - getPaddingRight()) - (f3 * textPaint.measureText(str, 0, str.length()))) * (this.H + 1.0f)) / 2.0f;
    }

    private float getVerticalOffset() {
        float f3 = Float.isNaN(this.f33052l) ? 1.0f : this.f33051k / this.f33052l;
        Paint.FontMetrics fontMetrics = this.f33042a.getFontMetrics();
        float measuredHeight = ((Float.isNaN(this.A) ? getMeasuredHeight() : this.A) - getPaddingTop()) - getPaddingBottom();
        float f4 = fontMetrics.descent;
        float f5 = fontMetrics.ascent;
        return (((measuredHeight - ((f4 - f5) * f3)) * (1.0f - this.I)) / 2.0f) - (f3 * f5);
    }

    @Override // androidx.constraintlayout.motion.widget.FloatLayout
    public void a(float f3, float f4, float f5, float f6) {
        int i3 = (int) (f3 + 0.5f);
        this.f33065y = f3 - i3;
        int i4 = (int) (f5 + 0.5f);
        int i5 = i4 - i3;
        int i6 = (int) (f6 + 0.5f);
        int i7 = (int) (0.5f + f4);
        int i8 = i6 - i7;
        float f7 = f5 - f3;
        this.f33066z = f7;
        float f8 = f6 - f4;
        this.A = f8;
        d(f3, f4, f5, f6);
        if (getMeasuredHeight() == i8 && getMeasuredWidth() == i5) {
            super.layout(i3, i7, i4, i6);
        } else {
            measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
            super.layout(i3, i7, i4, i6);
        }
        if (this.f33064x) {
            if (this.K == null) {
                this.L = new Paint();
                this.K = new Rect();
                this.L.set(this.f33042a);
                this.M = this.L.getTextSize();
            }
            this.f33066z = f7;
            this.A = f8;
            Paint paint = this.L;
            String str = this.f33054n;
            paint.getTextBounds(str, 0, str.length(), this.K);
            float fHeight = this.K.height() * 1.3f;
            float f9 = (f7 - this.f33058r) - this.f33057q;
            float f10 = (f8 - this.f33060t) - this.f33059s;
            float fWidth = this.K.width();
            if (fWidth * f10 > fHeight * f9) {
                this.f33042a.setTextSize((this.M * f9) / fWidth);
            } else {
                this.f33042a.setTextSize((this.M * f10) / fHeight);
            }
            if (this.f33046f || !Float.isNaN(this.f33052l)) {
                e(Float.isNaN(this.f33052l) ? 1.0f : this.f33051k / this.f33052l);
            }
        }
    }

    void e(float f3) {
        if (this.f33046f || f3 != 1.0f) {
            this.f33043b.reset();
            String str = this.f33054n;
            int length = str.length();
            this.f33042a.getTextBounds(str, 0, length, this.f33056p);
            this.f33042a.getTextPath(str, 0, length, 0.0f, 0.0f, this.f33043b);
            if (f3 != 1.0f) {
                Log.v(R, Debug.a() + " scale " + f3);
                Matrix matrix = new Matrix();
                matrix.postScale(f3, f3);
                this.f33043b.transform(matrix);
            }
            Rect rect = this.f33056p;
            rect.right--;
            rect.left++;
            rect.bottom++;
            rect.top--;
            RectF rectF = new RectF();
            rectF.bottom = getHeight();
            rectF.right = getWidth();
            this.f33055o = false;
        }
    }

    public float getRound() {
        return this.f33048h;
    }

    public float getRoundPercent() {
        return this.f33047g;
    }

    public float getScaleFromTextSize() {
        return this.f33052l;
    }

    public float getTextBackgroundPanX() {
        return this.N;
    }

    public float getTextBackgroundPanY() {
        return this.O;
    }

    public float getTextBackgroundRotate() {
        return this.Q;
    }

    public float getTextBackgroundZoom() {
        return this.P;
    }

    public int getTextOutlineColor() {
        return this.f33045d;
    }

    public float getTextPanX() {
        return this.H;
    }

    public float getTextPanY() {
        return this.I;
    }

    public float getTextureHeight() {
        return this.F;
    }

    public float getTextureWidth() {
        return this.G;
    }

    public Typeface getTypeface() {
        return this.f33042a.getTypeface();
    }

    @Override // android.view.View
    public void layout(int i3, int i4, int i5, int i6) {
        super.layout(i3, i4, i5, i6);
        boolean zIsNaN = Float.isNaN(this.f33052l);
        float f3 = zIsNaN ? 1.0f : this.f33051k / this.f33052l;
        this.f33066z = i5 - i3;
        this.A = i6 - i4;
        if (this.f33064x) {
            if (this.K == null) {
                this.L = new Paint();
                this.K = new Rect();
                this.L.set(this.f33042a);
                this.M = this.L.getTextSize();
            }
            Paint paint = this.L;
            String str = this.f33054n;
            paint.getTextBounds(str, 0, str.length(), this.K);
            int iWidth = this.K.width();
            int iHeight = (int) (this.K.height() * 1.3f);
            float f4 = (this.f33066z - this.f33058r) - this.f33057q;
            float f5 = (this.A - this.f33060t) - this.f33059s;
            if (zIsNaN) {
                float f6 = iWidth;
                float f7 = iHeight;
                if (f6 * f5 > f7 * f4) {
                    this.f33042a.setTextSize((this.M * f4) / f6);
                } else {
                    this.f33042a.setTextSize((this.M * f5) / f7);
                }
            } else {
                float f8 = iWidth;
                float f9 = iHeight;
                f3 = f8 * f5 > f9 * f4 ? f4 / f8 : f5 / f9;
            }
        }
        if (this.f33046f || !zIsNaN) {
            d(i3, i4, i5, i6);
            e(f3);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f3 = Float.isNaN(this.f33052l) ? 1.0f : this.f33051k / this.f33052l;
        super.onDraw(canvas);
        if (!this.f33046f && f3 == 1.0f) {
            canvas.drawText(this.f33054n, this.f33065y + this.f33057q + getHorizontalOffset(), this.f33059s + getVerticalOffset(), this.f33042a);
            return;
        }
        if (this.f33055o) {
            e(f3);
        }
        if (this.B == null) {
            this.B = new Matrix();
        }
        if (!this.f33046f) {
            float horizontalOffset = this.f33057q + getHorizontalOffset();
            float verticalOffset = this.f33059s + getVerticalOffset();
            this.B.reset();
            this.B.preTranslate(horizontalOffset, verticalOffset);
            this.f33043b.transform(this.B);
            this.f33042a.setColor(this.f33044c);
            this.f33042a.setStyle(Paint.Style.FILL_AND_STROKE);
            this.f33042a.setStrokeWidth(this.f33053m);
            canvas.drawPath(this.f33043b, this.f33042a);
            this.B.reset();
            this.B.preTranslate(-horizontalOffset, -verticalOffset);
            this.f33043b.transform(this.B);
            return;
        }
        this.J.set(this.f33042a);
        this.B.reset();
        float horizontalOffset2 = this.f33057q + getHorizontalOffset();
        float verticalOffset2 = this.f33059s + getVerticalOffset();
        this.B.postTranslate(horizontalOffset2, verticalOffset2);
        this.B.preScale(f3, f3);
        this.f33043b.transform(this.B);
        if (this.D != null) {
            this.f33042a.setFilterBitmap(true);
            this.f33042a.setShader(this.D);
        } else {
            this.f33042a.setColor(this.f33044c);
        }
        this.f33042a.setStyle(Paint.Style.FILL);
        this.f33042a.setStrokeWidth(this.f33053m);
        canvas.drawPath(this.f33043b, this.f33042a);
        if (this.D != null) {
            this.f33042a.setShader(null);
        }
        this.f33042a.setColor(this.f33045d);
        this.f33042a.setStyle(Paint.Style.STROKE);
        this.f33042a.setStrokeWidth(this.f33053m);
        canvas.drawPath(this.f33043b, this.f33042a);
        this.B.reset();
        this.B.postTranslate(-horizontalOffset2, -verticalOffset2);
        this.f33043b.transform(this.B);
        this.f33042a.set(this.J);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i4);
        this.f33064x = false;
        this.f33057q = getPaddingLeft();
        this.f33058r = getPaddingRight();
        this.f33059s = getPaddingTop();
        this.f33060t = getPaddingBottom();
        if (mode != 1073741824 || mode2 != 1073741824) {
            TextPaint textPaint = this.f33042a;
            String str = this.f33054n;
            textPaint.getTextBounds(str, 0, str.length(), this.f33056p);
            if (mode != 1073741824) {
                size = (int) (this.f33056p.width() + 0.99999f);
            }
            size += this.f33057q + this.f33058r;
            if (mode2 != 1073741824) {
                int fontMetricsInt = (int) (this.f33042a.getFontMetricsInt(null) + 0.99999f);
                if (mode2 == Integer.MIN_VALUE) {
                    fontMetricsInt = Math.min(size2, fontMetricsInt);
                }
                size2 = this.f33059s + this.f33060t + fontMetricsInt;
            }
        } else if (this.f33063w != 0) {
            this.f33064x = true;
        }
        setMeasuredDimension(size, size2);
    }

    public void setGravity(int i3) {
        if ((i3 & 8388615) == 0) {
            i3 |= 8388611;
        }
        if ((i3 & 112) == 0) {
            i3 |= 48;
        }
        if (i3 != this.f33062v) {
            invalidate();
        }
        this.f33062v = i3;
        int i4 = i3 & 112;
        if (i4 == 48) {
            this.I = -1.0f;
        } else if (i4 != 80) {
            this.I = 0.0f;
        } else {
            this.I = 1.0f;
        }
        int i5 = i3 & 8388615;
        if (i5 != 3) {
            if (i5 != 5) {
                if (i5 != 8388611) {
                    if (i5 != 8388613) {
                        this.H = 0.0f;
                        return;
                    }
                }
            }
            this.H = 1.0f;
            return;
        }
        this.H = -1.0f;
    }

    public void setRound(float f3) {
        if (Float.isNaN(f3)) {
            this.f33048h = f3;
            float f4 = this.f33047g;
            this.f33047g = -1.0f;
            setRoundPercent(f4);
            return;
        }
        boolean z2 = this.f33048h != f3;
        this.f33048h = f3;
        if (f3 != 0.0f) {
            if (this.f33043b == null) {
                this.f33043b = new Path();
            }
            if (this.f33050j == null) {
                this.f33050j = new RectF();
            }
            if (this.f33049i == null) {
                ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.MotionLabel.2
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), MotionLabel.this.f33048h);
                    }
                };
                this.f33049i = viewOutlineProvider;
                setOutlineProvider(viewOutlineProvider);
            }
            setClipToOutline(true);
            this.f33050j.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f33043b.reset();
            Path path = this.f33043b;
            RectF rectF = this.f33050j;
            float f5 = this.f33048h;
            path.addRoundRect(rectF, f5, f5, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z2) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f3) {
        boolean z2 = this.f33047g != f3;
        this.f33047g = f3;
        if (f3 != 0.0f) {
            if (this.f33043b == null) {
                this.f33043b = new Path();
            }
            if (this.f33050j == null) {
                this.f33050j = new RectF();
            }
            if (this.f33049i == null) {
                ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.MotionLabel.1
                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), (Math.min(r3, r4) * MotionLabel.this.f33047g) / 2.0f);
                    }
                };
                this.f33049i = viewOutlineProvider;
                setOutlineProvider(viewOutlineProvider);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f33047g) / 2.0f;
            this.f33050j.set(0.0f, 0.0f, width, height);
            this.f33043b.reset();
            this.f33043b.addRoundRect(this.f33050j, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z2) {
            invalidateOutline();
        }
    }

    public void setScaleFromTextSize(float f3) {
        this.f33052l = f3;
    }

    public void setText(CharSequence charSequence) {
        this.f33054n = charSequence.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float f3) {
        this.N = f3;
        f();
        invalidate();
    }

    public void setTextBackgroundPanY(float f3) {
        this.O = f3;
        f();
        invalidate();
    }

    public void setTextBackgroundRotate(float f3) {
        this.Q = f3;
        f();
        invalidate();
    }

    public void setTextBackgroundZoom(float f3) {
        this.P = f3;
        f();
        invalidate();
    }

    public void setTextFillColor(int i3) {
        this.f33044c = i3;
        invalidate();
    }

    public void setTextOutlineColor(int i3) {
        this.f33045d = i3;
        this.f33046f = true;
        invalidate();
    }

    public void setTextOutlineThickness(float f3) {
        this.f33053m = f3;
        this.f33046f = true;
        if (Float.isNaN(f3)) {
            this.f33053m = 1.0f;
            this.f33046f = false;
        }
        invalidate();
    }

    public void setTextPanX(float f3) {
        this.H = f3;
        invalidate();
    }

    public void setTextPanY(float f3) {
        this.I = f3;
        invalidate();
    }

    public void setTextSize(float f3) {
        this.f33051k = f3;
        Log.v(R, Debug.a() + "  " + f3 + " / " + this.f33052l);
        TextPaint textPaint = this.f33042a;
        if (!Float.isNaN(this.f33052l)) {
            f3 = this.f33052l;
        }
        textPaint.setTextSize(f3);
        e(Float.isNaN(this.f33052l) ? 1.0f : this.f33051k / this.f33052l);
        requestLayout();
        invalidate();
    }

    public void setTextureHeight(float f3) {
        this.F = f3;
        f();
        invalidate();
    }

    public void setTextureWidth(float f3) {
        this.G = f3;
        f();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        if (this.f33042a.getTypeface() != typeface) {
            this.f33042a.setTypeface(typeface);
            if (this.f33061u != null) {
                this.f33061u = null;
                requestLayout();
                invalidate();
            }
        }
    }
}
