package com.github.mikephil.charting.charts;

import android.animation.ValueAnimator;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.PieRadarChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class PieRadarChartBase<T extends ChartData<? extends IDataSet<? extends Entry>>> extends Chart<T> {
    private float H;
    private float I;
    protected boolean J;
    protected float K;

    /* JADX INFO: renamed from: com.github.mikephil.charting.charts.PieRadarChartBase$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PieRadarChartBase f68362a;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f68362a.postInvalidate();
        }
    }

    /* JADX INFO: renamed from: com.github.mikephil.charting.charts.PieRadarChartBase$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f68363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f68364b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f68365c;

        static {
            int[] iArr = new int[Legend.LegendOrientation.values().length];
            f68365c = iArr;
            try {
                iArr[Legend.LegendOrientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f68365c[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Legend.LegendHorizontalAlignment.values().length];
            f68364b = iArr2;
            try {
                iArr2[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f68364b[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f68364b[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[Legend.LegendVerticalAlignment.values().length];
            f68363a = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f68363a[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public abstract int A(float f3);

    public MPPointF B(MPPointF mPPointF, float f3, float f4) {
        MPPointF mPPointFC = MPPointF.c(0.0f, 0.0f);
        C(mPPointF, f3, f4, mPPointFC);
        return mPPointFC;
    }

    public void C(MPPointF mPPointF, float f3, float f4, MPPointF mPPointF2) {
        double d3 = f3;
        double d4 = f4;
        mPPointF2.f68793c = (float) (((double) mPPointF.f68793c) + (Math.cos(Math.toRadians(d4)) * d3));
        mPPointF2.f68794d = (float) (((double) mPPointF.f68794d) + (d3 * Math.sin(Math.toRadians(d4))));
    }

    public boolean D() {
        return this.J;
    }

    @Override // android.view.View
    public void computeScroll() {
        ChartTouchListener chartTouchListener = this.f68333o;
        if (chartTouchListener instanceof PieRadarChartTouchListener) {
            ((PieRadarChartTouchListener) chartTouchListener).g();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x007b, code lost:
    
        if (r2 != 2) goto L19;
     */
    @Override // com.github.mikephil.charting.charts.Chart
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void f() {
        /*
            Method dump skipped, instruction units count: 542
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.charts.PieRadarChartBase.f():void");
    }

    public float getDiameter() {
        RectF rectFO = this.f68339u.o();
        rectFO.left += getExtraLeftOffset();
        rectFO.top += getExtraTopOffset();
        rectFO.right -= getExtraRightOffset();
        rectFO.bottom -= getExtraBottomOffset();
        return Math.min(rectFO.width(), rectFO.height());
    }

    @Override // com.github.mikephil.charting.charts.Chart, com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public int getMaxVisibleCount() {
        return this.f68321b.h();
    }

    public float getMinOffset() {
        return this.K;
    }

    public abstract float getRadius();

    public float getRawRotationAngle() {
        return this.I;
    }

    protected abstract float getRequiredBaseOffset();

    protected abstract float getRequiredLegendOffset();

    public float getRotationAngle() {
        return this.H;
    }

    @Override // com.github.mikephil.charting.charts.Chart, com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMax() {
        return 0.0f;
    }

    @Override // com.github.mikephil.charting.charts.Chart, com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMin() {
        return 0.0f;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected void n() {
        super.n();
        this.f68333o = new PieRadarChartTouchListener(this);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ChartTouchListener chartTouchListener;
        return (!this.f68329k || (chartTouchListener = this.f68333o) == null) ? super.onTouchEvent(motionEvent) : chartTouchListener.onTouch(this, motionEvent);
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void s() {
        if (this.f68321b == null) {
            return;
        }
        x();
        if (this.f68331m != null) {
            this.f68336r.a(this.f68321b);
        }
        f();
    }

    public void setMinOffset(float f3) {
        this.K = f3;
    }

    public void setRotationAngle(float f3) {
        this.I = f3;
        this.H = Utils.q(f3);
    }

    public void setRotationEnabled(boolean z2) {
        this.J = z2;
    }

    public float y(float f3, float f4) {
        MPPointF centerOffsets = getCenterOffsets();
        float f5 = centerOffsets.f68793c;
        float fSqrt = (float) Math.sqrt(Math.pow(f3 > f5 ? f3 - f5 : f5 - f3, 2.0d) + Math.pow(f4 > centerOffsets.f68794d ? f4 - r1 : r1 - f4, 2.0d));
        MPPointF.f(centerOffsets);
        return fSqrt;
    }

    public float z(float f3, float f4) {
        MPPointF centerOffsets = getCenterOffsets();
        double d3 = f3 - centerOffsets.f68793c;
        double d4 = f4 - centerOffsets.f68794d;
        float degrees = (float) Math.toDegrees(Math.acos(d4 / Math.sqrt((d3 * d3) + (d4 * d4))));
        if (f3 > centerOffsets.f68793c) {
            degrees = 360.0f - degrees;
        }
        float f5 = degrees + 90.0f;
        if (f5 > 360.0f) {
            f5 -= 360.0f;
        }
        MPPointF.f(centerOffsets);
        return f5;
    }

    protected void x() {
    }
}
