package antonkozyriatskyi.circularprogressindicator;

import android.animation.Animator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class CircularProgressIndicator extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f55274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Paint f55275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Paint f55276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Paint f55277d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f55278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f55279g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private RectF f55280h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f55281i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f55282j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f55283k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f55284l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f55285m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private double f55286n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private double f55287o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private double f55288p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f55289q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f55290r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f55291s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f55292t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f55293u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ValueAnimator f55294v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ProgressTextAdapter f55295w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private OnProgressChangeListener f55296x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Interpolator f55297y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Rect f55298z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Cap {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Direction {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface GradientType {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnProgressChangeListener {
        void a(double d3, double d4);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ProgressTextAdapter {
        String a(double d3);
    }

    public CircularProgressIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f55278f = 270;
        this.f55279g = 0.0f;
        this.f55286n = 100.0d;
        this.f55287o = 0.0d;
        this.f55288p = 0.0d;
        this.f55291s = 1000;
        this.f55292t = true;
        this.f55293u = 1;
        this.f55297y = new AccelerateDecelerateInterpolator();
        this.f55298z = new Rect();
        m(context, attributeSet);
    }

    public static /* synthetic */ void a(CircularProgressIndicator circularProgressIndicator, ValueAnimator valueAnimator) {
        circularProgressIndicator.getClass();
        circularProgressIndicator.f55279g = ((Float) valueAnimator.getAnimatedValue("angle")).floatValue();
        circularProgressIndicator.invalidate();
    }

    private void f(int i3, int i4) {
        float f3 = i3;
        this.f55284l = f3 / 2.0f;
        float strokeWidth = this.f55276c.getStrokeWidth();
        float strokeWidth2 = this.f55274a.getStrokeWidth();
        float strokeWidth3 = this.f55275b.getStrokeWidth();
        float fMax = (this.f55285m ? Math.max(strokeWidth, Math.max(strokeWidth2, strokeWidth3)) : Math.max(strokeWidth2, strokeWidth3)) / 2.0f;
        RectF rectF = this.f55280h;
        rectF.left = fMax;
        rectF.top = fMax;
        rectF.right = f3 - fMax;
        rectF.bottom = i4 - fMax;
        this.f55284l = rectF.width() / 2.0f;
        g();
    }

    private Rect g() {
        Rect rect = new Rect();
        Paint paint = this.f55277d;
        String str = this.f55281i;
        paint.getTextBounds(str, 0, str.length(), rect);
        this.f55282j = this.f55280h.centerX() - (rect.width() / 2.0f);
        this.f55283k = this.f55280h.centerY() + (rect.height() / 2.0f);
        return rect;
    }

    private int h(float f3) {
        return (int) TypedValue.applyDimension(1, f3, getResources().getDisplayMetrics());
    }

    private void i(Canvas canvas) {
        double radians = Math.toRadians(this.f55278f + this.f55279g + 180.0f);
        canvas.drawPoint(this.f55280h.centerX() - (this.f55284l * ((float) Math.cos(radians))), this.f55280h.centerY() - (this.f55284l * ((float) Math.sin(radians))), this.f55276c);
    }

    private void j(Canvas canvas) {
        canvas.drawArc(this.f55280h, this.f55278f, this.f55279g, false, this.f55274a);
    }

    private void k(Canvas canvas) {
        double d3 = this.f55288p;
        if (d3 == 0.0d) {
            canvas.drawArc(this.f55280h, 0.0f, 360.0f, false, this.f55275b);
            return;
        }
        float f3 = (float) ((d3 / this.f55286n) * 360.0d);
        float f4 = this.f55279g;
        float f5 = this.f55278f + f4 + f3;
        float f6 = (360.0f - f4) - (f3 * 2.0f);
        if (f6 < 0.0f) {
            return;
        }
        canvas.drawArc(this.f55280h, f5, f6, false, this.f55275b);
    }

    private void l(Canvas canvas) {
        canvas.drawText(this.f55281i, this.f55282j, this.f55283k, this.f55277d);
    }

    private void m(Context context, AttributeSet attributeSet) {
        int color;
        int color2;
        int dimensionPixelSize;
        int dimensionPixelSize2;
        Paint.Cap cap;
        int color3 = Color.parseColor("#3F51B5");
        int color4 = Color.parseColor("#e0e0e0");
        int iH = h(8.0f);
        int iS = s(24.0f);
        this.f55285m = true;
        Paint.Cap cap2 = Paint.Cap.ROUND;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.f55302a);
            color3 = typedArrayObtainStyledAttributes.getColor(R.styleable.f55315n, color3);
            color4 = typedArrayObtainStyledAttributes.getColor(R.styleable.f55312k, color4);
            iH = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.f55316o, iH);
            dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.f55313l, iH);
            color = typedArrayObtainStyledAttributes.getColor(R.styleable.f55319r, color3);
            iS = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.f55320s, iS);
            this.f55285m = typedArrayObtainStyledAttributes.getBoolean(R.styleable.f55306e, true);
            color2 = typedArrayObtainStyledAttributes.getColor(R.styleable.f55304c, color3);
            dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.f55305d, iH);
            int i3 = typedArrayObtainStyledAttributes.getInt(R.styleable.f55318q, 270);
            this.f55278f = i3;
            if (i3 < 0 || i3 > 360) {
                this.f55278f = 270;
            }
            this.f55289q = typedArrayObtainStyledAttributes.getBoolean(R.styleable.f55307f, true);
            this.f55290r = typedArrayObtainStyledAttributes.getBoolean(R.styleable.f55308g, false);
            this.f55292t = typedArrayObtainStyledAttributes.getBoolean(R.styleable.f55317p, true);
            this.f55293u = typedArrayObtainStyledAttributes.getInt(R.styleable.f55303b, 1);
            cap = typedArrayObtainStyledAttributes.getInt(R.styleable.f55314m, 0) == 0 ? cap2 : Paint.Cap.BUTT;
            String string = typedArrayObtainStyledAttributes.getString(R.styleable.f55309h);
            if (string != null) {
                this.f55295w = new PatternProgressTextAdapter(string);
            } else {
                this.f55295w = new DefaultProgressTextAdapter();
            }
            o();
            final int color5 = typedArrayObtainStyledAttributes.getColor(R.styleable.f55311j, 0);
            if (color5 != 0) {
                final int color6 = typedArrayObtainStyledAttributes.getColor(R.styleable.f55310i, -1);
                if (color6 == -1) {
                    throw new IllegalArgumentException("did you forget to specify gradientColorEnd?");
                }
                post(new Runnable() { // from class: antonkozyriatskyi.circularprogressindicator.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f55321a.p(color5, color6);
                    }
                });
            }
            typedArrayObtainStyledAttributes.recycle();
        } else {
            color = color3;
            color2 = color;
            dimensionPixelSize = iH;
            dimensionPixelSize2 = dimensionPixelSize;
            cap = cap2;
        }
        Paint paint = new Paint();
        this.f55274a = paint;
        paint.setStrokeCap(cap);
        this.f55274a.setStrokeWidth(iH);
        Paint paint2 = this.f55274a;
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        this.f55274a.setColor(color3);
        this.f55274a.setAntiAlias(true);
        if (this.f55290r) {
            style = Paint.Style.FILL_AND_STROKE;
        }
        Paint paint3 = new Paint();
        this.f55275b = paint3;
        paint3.setStrokeCap(cap);
        this.f55275b.setStyle(style);
        this.f55275b.setStrokeWidth(dimensionPixelSize);
        this.f55275b.setColor(color4);
        this.f55275b.setAntiAlias(true);
        Paint paint4 = new Paint();
        this.f55276c = paint4;
        paint4.setStrokeCap(cap2);
        this.f55276c.setStrokeWidth(dimensionPixelSize2);
        this.f55276c.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f55276c.setColor(color2);
        this.f55276c.setAntiAlias(true);
        TextPaint textPaint = new TextPaint();
        this.f55277d = textPaint;
        textPaint.setStrokeCap(cap2);
        this.f55277d.setColor(color);
        this.f55277d.setAntiAlias(true);
        this.f55277d.setTextSize(iS);
        this.f55280h = new RectF();
    }

    private void n() {
        f(getWidth(), getHeight());
        requestLayout();
        invalidate();
    }

    private void o() {
        this.f55281i = this.f55295w.a(this.f55287o);
    }

    private int s(float f3) {
        return (int) TypedValue.applyDimension(2, f3, getResources().getDisplayMetrics());
    }

    private void t(double d3, final double d4) {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat("angle", this.f55279g, (float) d4);
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new TypeEvaluator() { // from class: antonkozyriatskyi.circularprogressindicator.b
            @Override // android.animation.TypeEvaluator
            public final Object evaluate(float f3, Object obj, Object obj2) {
                Double d5 = (Double) obj;
                return Double.valueOf(d5.doubleValue() + ((((Double) obj2).doubleValue() - d5.doubleValue()) * ((double) f3)));
            }
        }, Double.valueOf(d3), Double.valueOf(this.f55287o));
        this.f55294v = valueAnimatorOfObject;
        valueAnimatorOfObject.setDuration(this.f55291s);
        this.f55294v.setValues(propertyValuesHolderOfFloat);
        this.f55294v.setInterpolator(this.f55297y);
        this.f55294v.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: antonkozyriatskyi.circularprogressindicator.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CircularProgressIndicator.a(this.f55324a, valueAnimator);
            }
        });
        this.f55294v.addListener(new DefaultAnimatorListener() { // from class: antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator.1
            @Override // antonkozyriatskyi.circularprogressindicator.DefaultAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                CircularProgressIndicator.this.f55279g = (float) d4;
                CircularProgressIndicator.this.invalidate();
                CircularProgressIndicator.this.f55294v = null;
            }
        });
        this.f55294v.start();
    }

    private void u() {
        ValueAnimator valueAnimator = this.f55294v;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public int getAnimationDuration() {
        return this.f55291s;
    }

    public int getDirection() {
        return this.f55293u;
    }

    public int getDotColor() {
        return this.f55276c.getColor();
    }

    public float getDotWidth() {
        return this.f55276c.getStrokeWidth();
    }

    public int getGradientType() {
        Shader shader = this.f55274a.getShader();
        if (shader instanceof LinearGradient) {
            return 1;
        }
        if (shader instanceof RadialGradient) {
            return 2;
        }
        return shader instanceof SweepGradient ? 3 : 0;
    }

    public Interpolator getInterpolator() {
        return this.f55297y;
    }

    public double getMaxProgress() {
        return this.f55286n;
    }

    public OnProgressChangeListener getOnProgressChangeListener() {
        return this.f55296x;
    }

    public double getProgress() {
        return this.f55287o;
    }

    public int getProgressBackgroundColor() {
        return this.f55275b.getColor();
    }

    public float getProgressBackgroundStrokeWidth() {
        return this.f55275b.getStrokeWidth();
    }

    public int getProgressColor() {
        return this.f55274a.getColor();
    }

    public double getProgressGap() {
        return this.f55288p;
    }

    public int getProgressStrokeCap() {
        return this.f55274a.getStrokeCap() == Paint.Cap.ROUND ? 0 : 1;
    }

    public float getProgressStrokeWidth() {
        return this.f55274a.getStrokeWidth();
    }

    public ProgressTextAdapter getProgressTextAdapter() {
        return this.f55295w;
    }

    public int getStartAngle() {
        return this.f55278f;
    }

    public int getTextColor() {
        return this.f55277d.getColor();
    }

    public float getTextSize() {
        return this.f55277d.getTextSize();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f55294v;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        k(canvas);
        j(canvas);
        if (this.f55285m) {
            i(canvas);
        }
        if (this.f55292t) {
            l(canvas);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i4);
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        Paint paint = this.f55277d;
        String str = this.f55281i;
        paint.getTextBounds(str, 0, str.length(), this.f55298z);
        float strokeWidth = this.f55276c.getStrokeWidth();
        float strokeWidth2 = this.f55274a.getStrokeWidth();
        float strokeWidth3 = this.f55275b.getStrokeWidth();
        float fMax = ((int) (this.f55285m ? Math.max(strokeWidth, Math.max(strokeWidth2, strokeWidth3)) : Math.max(strokeWidth2, strokeWidth3))) + h(150.0f) + Math.max(paddingBottom + paddingTop, paddingLeft + paddingRight);
        int iMax = (int) (fMax + Math.max(this.f55298z.width(), this.f55298z.height()) + (0.1f * fMax));
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(iMax, size);
        } else if (mode != 1073741824) {
            size = iMax;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(iMax, size2);
        } else if (mode2 != 1073741824) {
            size2 = iMax;
        }
        int iMin = Math.min((size2 - paddingTop) - paddingBottom, (size - paddingLeft) - paddingRight);
        setMeasuredDimension(iMin, iMin);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        f(i3, i4);
        this.f55274a.getShader();
    }

    public void p(int i3, int i4) {
        q(i3, new int[]{this.f55274a.getColor(), i4}, null);
    }

    public void q(int i3, int[] iArr, float[] fArr) {
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        if (i3 != 0) {
            Shader sweepGradient = i3 != 1 ? i3 != 2 ? i3 != 3 ? null : new SweepGradient(width, height, iArr, fArr) : new RadialGradient(width, height, width, iArr, fArr, Shader.TileMode.MIRROR) : new LinearGradient(0.0f, 0.0f, getWidth(), getHeight(), iArr, fArr, Shader.TileMode.CLAMP);
            if (sweepGradient != null) {
                Matrix matrix = new Matrix();
                matrix.postRotate(this.f55278f, width, height);
                sweepGradient.setLocalMatrix(matrix);
            }
            this.f55274a.setShader(sweepGradient);
            invalidate();
        }
    }

    public void r(double d3, double d4) {
        double d5 = this.f55293u == 1 ? -((d3 / d4) * 360.0d) : (d3 / d4) * 360.0d;
        double d6 = this.f55287o;
        this.f55286n = d4;
        double dMin = Math.min(d3, d4);
        this.f55287o = dMin;
        OnProgressChangeListener onProgressChangeListener = this.f55296x;
        if (onProgressChangeListener != null) {
            onProgressChangeListener.a(dMin, this.f55286n);
        }
        o();
        g();
        u();
        if (this.f55289q) {
            t(d6, d5);
        } else {
            this.f55279g = (float) d5;
            invalidate();
        }
    }

    public void setAnimationDuration(int i3) {
        this.f55291s = i3;
    }

    public void setAnimationEnabled(boolean z2) {
        this.f55289q = z2;
        if (z2) {
            return;
        }
        u();
    }

    public void setCurrentProgress(double d3) {
        if (d3 > this.f55286n) {
            this.f55286n = d3;
        }
        r(d3, this.f55286n);
    }

    public void setDirection(int i3) {
        this.f55293u = i3;
        invalidate();
    }

    public void setDotColor(int i3) {
        this.f55276c.setColor(i3);
        invalidate();
    }

    public void setDotWidthDp(int i3) {
        setDotWidthPx(h(i3));
    }

    public void setDotWidthPx(int i3) {
        this.f55276c.setStrokeWidth(i3);
        n();
    }

    public void setFillBackgroundEnabled(boolean z2) {
        if (z2 == this.f55290r) {
            return;
        }
        this.f55290r = z2;
        this.f55275b.setStyle(z2 ? Paint.Style.FILL_AND_STROKE : Paint.Style.STROKE);
        invalidate();
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f55297y = interpolator;
    }

    public void setMaxProgress(double d3) {
        this.f55286n = d3;
        if (d3 < this.f55287o) {
            setCurrentProgress(d3);
        }
        invalidate();
    }

    public void setOnProgressChangeListener(OnProgressChangeListener onProgressChangeListener) {
        this.f55296x = onProgressChangeListener;
    }

    public void setProgressBackgroundColor(int i3) {
        this.f55275b.setColor(i3);
        invalidate();
    }

    public void setProgressBackgroundStrokeWidthDp(int i3) {
        setProgressBackgroundStrokeWidthPx(h(i3));
    }

    public void setProgressBackgroundStrokeWidthPx(int i3) {
        this.f55275b.setStrokeWidth(i3);
        n();
    }

    public void setProgressColor(int i3) {
        this.f55274a.setColor(i3);
        invalidate();
    }

    public void setProgressGap(double d3) {
        this.f55288p = d3;
        invalidate();
    }

    public void setProgressStrokeCap(int i3) {
        Paint.Cap cap = i3 == 0 ? Paint.Cap.ROUND : Paint.Cap.BUTT;
        if (this.f55274a.getStrokeCap() != cap) {
            this.f55274a.setStrokeCap(cap);
            this.f55275b.setStrokeCap(cap);
            invalidate();
        }
    }

    public void setProgressStrokeWidthDp(int i3) {
        setProgressStrokeWidthPx(h(i3));
    }

    public void setProgressStrokeWidthPx(int i3) {
        this.f55274a.setStrokeWidth(i3);
        n();
    }

    public void setProgressTextAdapter(ProgressTextAdapter progressTextAdapter) {
        if (progressTextAdapter != null) {
            this.f55295w = progressTextAdapter;
        } else {
            this.f55295w = new DefaultProgressTextAdapter();
        }
        o();
        n();
    }

    public void setShouldDrawDot(boolean z2) {
        this.f55285m = z2;
        if (this.f55276c.getStrokeWidth() > this.f55274a.getStrokeWidth()) {
            requestLayout();
        } else {
            invalidate();
        }
    }

    public void setShowTextEnabled(boolean z2) {
        if (this.f55292t == z2) {
            return;
        }
        this.f55292t = z2;
        n();
    }

    public void setStartAngle(int i3) {
        this.f55278f = i3;
        invalidate();
    }

    public void setTextColor(int i3) {
        this.f55277d.setColor(i3);
        Rect rect = new Rect();
        Paint paint = this.f55277d;
        String str = this.f55281i;
        paint.getTextBounds(str, 0, str.length(), rect);
        invalidate(rect);
    }

    public void setTextSizePx(int i3) {
        float fMeasureText = this.f55277d.measureText(this.f55281i) / this.f55277d.getTextSize();
        float fWidth = this.f55280h.width() - (this.f55285m ? Math.max(this.f55276c.getStrokeWidth(), this.f55274a.getStrokeWidth()) : this.f55274a.getStrokeWidth());
        if (i3 * fMeasureText >= fWidth) {
            i3 = (int) (fWidth / fMeasureText);
        }
        this.f55277d.setTextSize(i3);
        invalidate(g());
    }

    public void setTextSizeSp(int i3) {
        setTextSizePx(s(i3));
    }
}
