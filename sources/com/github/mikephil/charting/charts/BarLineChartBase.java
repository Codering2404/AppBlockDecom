package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.listener.BarLineChartTouchListener;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnDrawListener;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.XAxisRenderer;
import com.github.mikephil.charting.renderer.YAxisRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BarLineChartBase<T extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>> extends Chart<T> implements BarLineScatterCandleBubbleDataProvider {
    protected int H;
    protected boolean I;
    protected boolean J;
    protected boolean K;
    protected boolean L;
    private boolean M;
    private boolean N;
    private boolean O;
    private boolean P;
    protected Paint Q;
    protected Paint R;
    protected boolean S;
    protected boolean T;
    protected boolean U;
    protected float V;
    protected boolean W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    protected OnDrawListener f68294a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    protected YAxis f68295b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    protected YAxis f68296c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    protected YAxisRenderer f68297d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    protected YAxisRenderer f68298e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    protected Transformer f68299f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    protected Transformer f68300g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    protected XAxisRenderer f68301h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private long f68302i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private long f68303j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private RectF f68304k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    protected Matrix f68305l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    protected Matrix f68306m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private boolean f68307n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    protected float[] f68308o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    protected MPPointD f68309p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    protected MPPointD f68310q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    protected float[] f68311r0;

    /* JADX INFO: renamed from: com.github.mikephil.charting.charts.BarLineChartBase$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f68312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f68313b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f68314c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f68315d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ BarLineChartBase f68316f;

        @Override // java.lang.Runnable
        public void run() {
            this.f68316f.f68339u.K(this.f68312a, this.f68313b, this.f68314c, this.f68315d);
            this.f68316f.P();
            this.f68316f.Q();
        }
    }

    /* JADX INFO: renamed from: com.github.mikephil.charting.charts.BarLineChartBase$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f68317a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f68318b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f68319c;

        static {
            int[] iArr = new int[Legend.LegendOrientation.values().length];
            f68319c = iArr;
            try {
                iArr[Legend.LegendOrientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f68319c[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Legend.LegendHorizontalAlignment.values().length];
            f68318b = iArr2;
            try {
                iArr2[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f68318b[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f68318b[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[Legend.LegendVerticalAlignment.values().length];
            f68317a = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f68317a[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public BarLineChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.H = 100;
        this.I = false;
        this.J = false;
        this.K = true;
        this.L = true;
        this.M = true;
        this.N = true;
        this.O = true;
        this.P = true;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = 15.0f;
        this.W = false;
        this.f68302i0 = 0L;
        this.f68303j0 = 0L;
        this.f68304k0 = new RectF();
        this.f68305l0 = new Matrix();
        this.f68306m0 = new Matrix();
        this.f68307n0 = false;
        this.f68308o0 = new float[2];
        this.f68309p0 = MPPointD.b(0.0d, 0.0d);
        this.f68310q0 = MPPointD.b(0.0d, 0.0d);
        this.f68311r0 = new float[2];
    }

    protected void A(Canvas canvas) {
        if (this.S) {
            canvas.drawRect(this.f68339u.o(), this.Q);
        }
        if (this.T) {
            canvas.drawRect(this.f68339u.o(), this.R);
        }
    }

    public YAxis B(YAxis.AxisDependency axisDependency) {
        return axisDependency == YAxis.AxisDependency.LEFT ? this.f68295b0 : this.f68296c0;
    }

    public IBarLineScatterCandleBubbleDataSet C(float f3, float f4) {
        Highlight highlightK = k(f3, f4);
        if (highlightK != null) {
            return (IBarLineScatterCandleBubbleDataSet) ((BarLineScatterCandleBubbleData) this.f68321b).e(highlightK.d());
        }
        return null;
    }

    public boolean D() {
        return this.f68339u.t();
    }

    public boolean E() {
        return this.f68295b0.i0() || this.f68296c0.i0();
    }

    public boolean F() {
        return this.U;
    }

    public boolean G() {
        return this.K;
    }

    public boolean H() {
        return this.M || this.N;
    }

    public boolean I() {
        return this.M;
    }

    public boolean J() {
        return this.N;
    }

    public boolean K() {
        return this.f68339u.u();
    }

    public boolean L() {
        return this.L;
    }

    public boolean M() {
        return this.J;
    }

    public boolean N() {
        return this.O;
    }

    public boolean O() {
        return this.P;
    }

    protected void P() {
        this.f68300g0.l(this.f68296c0.i0());
        this.f68299f0.l(this.f68295b0.i0());
    }

    protected void Q() {
        if (this.f68320a) {
            Log.i("MPAndroidChart", "Preparing Value-Px Matrix, xmin: " + this.f68328j.H + ", xmax: " + this.f68328j.G + ", xdelta: " + this.f68328j.I);
        }
        Transformer transformer = this.f68300g0;
        XAxis xAxis = this.f68328j;
        float f3 = xAxis.H;
        float f4 = xAxis.I;
        YAxis yAxis = this.f68296c0;
        transformer.m(f3, f4, yAxis.I, yAxis.H);
        Transformer transformer2 = this.f68299f0;
        XAxis xAxis2 = this.f68328j;
        float f5 = xAxis2.H;
        float f6 = xAxis2.I;
        YAxis yAxis2 = this.f68295b0;
        transformer2.m(f5, f6, yAxis2.I, yAxis2.H);
    }

    public void R(float f3, float f4, float f5, float f6) {
        this.f68339u.U(f3, f4, f5, -f6, this.f68305l0);
        this.f68339u.J(this.f68305l0, this, false);
        f();
        postInvalidate();
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public Transformer a(YAxis.AxisDependency axisDependency) {
        return axisDependency == YAxis.AxisDependency.LEFT ? this.f68299f0 : this.f68300g0;
    }

    @Override // android.view.View
    public void computeScroll() {
        ChartTouchListener chartTouchListener = this.f68333o;
        if (chartTouchListener instanceof BarLineChartTouchListener) {
            ((BarLineChartTouchListener) chartTouchListener).f();
        }
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public boolean d(YAxis.AxisDependency axisDependency) {
        return B(axisDependency).i0();
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void f() {
        if (!this.f68307n0) {
            z(this.f68304k0);
            RectF rectF = this.f68304k0;
            float fA0 = rectF.left + 0.0f;
            float f3 = rectF.top + 0.0f;
            float fA02 = rectF.right + 0.0f;
            float f4 = rectF.bottom + 0.0f;
            if (this.f68295b0.j0()) {
                fA0 += this.f68295b0.a0(this.f68297d0.c());
            }
            if (this.f68296c0.j0()) {
                fA02 += this.f68296c0.a0(this.f68298e0.c());
            }
            if (this.f68328j.f() && this.f68328j.C()) {
                float fE = r2.M + this.f68328j.e();
                if (this.f68328j.W() == XAxis.XAxisPosition.BOTTOM) {
                    f4 += fE;
                } else if (this.f68328j.W() == XAxis.XAxisPosition.TOP) {
                    f3 += fE;
                } else if (this.f68328j.W() == XAxis.XAxisPosition.BOTH_SIDED) {
                    f4 += fE;
                    f3 += fE;
                }
            }
            float extraTopOffset = f3 + getExtraTopOffset();
            float extraRightOffset = fA02 + getExtraRightOffset();
            float extraBottomOffset = f4 + getExtraBottomOffset();
            float extraLeftOffset = fA0 + getExtraLeftOffset();
            float fE2 = Utils.e(this.V);
            this.f68339u.K(Math.max(fE2, extraLeftOffset), Math.max(fE2, extraTopOffset), Math.max(fE2, extraRightOffset), Math.max(fE2, extraBottomOffset));
            if (this.f68320a) {
                Log.i("MPAndroidChart", "offsetLeft: " + extraLeftOffset + ", offsetTop: " + extraTopOffset + ", offsetRight: " + extraRightOffset + ", offsetBottom: " + extraBottomOffset);
                StringBuilder sb = new StringBuilder();
                sb.append("Content: ");
                sb.append(this.f68339u.o().toString());
                Log.i("MPAndroidChart", sb.toString());
            }
        }
        P();
        Q();
    }

    public YAxis getAxisLeft() {
        return this.f68295b0;
    }

    public YAxis getAxisRight() {
        return this.f68296c0;
    }

    @Override // com.github.mikephil.charting.charts.Chart, com.github.mikephil.charting.interfaces.dataprovider.ChartInterface, com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public /* bridge */ /* synthetic */ BarLineScatterCandleBubbleData getData() {
        return (BarLineScatterCandleBubbleData) super.getData();
    }

    public OnDrawListener getDrawListener() {
        return this.f68294a0;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public float getHighestVisibleX() {
        a(YAxis.AxisDependency.LEFT).h(this.f68339u.i(), this.f68339u.f(), this.f68310q0);
        return (float) Math.min(this.f68328j.G, this.f68310q0.f68789c);
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public float getLowestVisibleX() {
        a(YAxis.AxisDependency.LEFT).h(this.f68339u.h(), this.f68339u.f(), this.f68309p0);
        return (float) Math.max(this.f68328j.H, this.f68309p0.f68789c);
    }

    @Override // com.github.mikephil.charting.charts.Chart, com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public int getMaxVisibleCount() {
        return this.H;
    }

    public float getMinOffset() {
        return this.V;
    }

    public YAxisRenderer getRendererLeftYAxis() {
        return this.f68297d0;
    }

    public YAxisRenderer getRendererRightYAxis() {
        return this.f68298e0;
    }

    public XAxisRenderer getRendererXAxis() {
        return this.f68301h0;
    }

    @Override // android.view.View
    public float getScaleX() {
        ViewPortHandler viewPortHandler = this.f68339u;
        if (viewPortHandler == null) {
            return 1.0f;
        }
        return viewPortHandler.q();
    }

    @Override // android.view.View
    public float getScaleY() {
        ViewPortHandler viewPortHandler = this.f68339u;
        if (viewPortHandler == null) {
            return 1.0f;
        }
        return viewPortHandler.r();
    }

    public float getVisibleXRange() {
        return Math.abs(getHighestVisibleX() - getLowestVisibleX());
    }

    @Override // com.github.mikephil.charting.charts.Chart, com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMax() {
        return Math.max(this.f68295b0.G, this.f68296c0.G);
    }

    @Override // com.github.mikephil.charting.charts.Chart, com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMin() {
        return Math.min(this.f68295b0.H, this.f68296c0.H);
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected void n() {
        super.n();
        this.f68295b0 = new YAxis(YAxis.AxisDependency.LEFT);
        this.f68296c0 = new YAxis(YAxis.AxisDependency.RIGHT);
        this.f68299f0 = new Transformer(this.f68339u);
        this.f68300g0 = new Transformer(this.f68339u);
        this.f68297d0 = new YAxisRenderer(this.f68339u, this.f68295b0, this.f68299f0);
        this.f68298e0 = new YAxisRenderer(this.f68339u, this.f68296c0, this.f68300g0);
        this.f68301h0 = new XAxisRenderer(this.f68339u, this.f68328j, this.f68299f0);
        setHighlighter(new ChartHighlighter(this));
        this.f68333o = new BarLineChartTouchListener(this, this.f68339u.p(), 3.0f);
        Paint paint = new Paint();
        this.Q = paint;
        paint.setStyle(Paint.Style.FILL);
        this.Q.setColor(Color.rgb(240, 240, 240));
        Paint paint2 = new Paint();
        this.R = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.R.setColor(-16777216);
        this.R.setStrokeWidth(Utils.e(1.0f));
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f68321b == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        A(canvas);
        if (this.I) {
            x();
        }
        if (this.f68295b0.f()) {
            YAxisRenderer yAxisRenderer = this.f68297d0;
            YAxis yAxis = this.f68295b0;
            yAxisRenderer.a(yAxis.H, yAxis.G, yAxis.i0());
        }
        if (this.f68296c0.f()) {
            YAxisRenderer yAxisRenderer2 = this.f68298e0;
            YAxis yAxis2 = this.f68296c0;
            yAxisRenderer2.a(yAxis2.H, yAxis2.G, yAxis2.i0());
        }
        if (this.f68328j.f()) {
            XAxisRenderer xAxisRenderer = this.f68301h0;
            XAxis xAxis = this.f68328j;
            xAxisRenderer.a(xAxis.H, xAxis.G, false);
        }
        this.f68301h0.j(canvas);
        this.f68297d0.j(canvas);
        this.f68298e0.j(canvas);
        if (this.f68328j.A()) {
            this.f68301h0.k(canvas);
        }
        if (this.f68295b0.A()) {
            this.f68297d0.k(canvas);
        }
        if (this.f68296c0.A()) {
            this.f68298e0.k(canvas);
        }
        if (this.f68328j.f() && this.f68328j.D()) {
            this.f68301h0.n(canvas);
        }
        if (this.f68295b0.f() && this.f68295b0.D()) {
            this.f68297d0.l(canvas);
        }
        if (this.f68296c0.f() && this.f68296c0.D()) {
            this.f68298e0.l(canvas);
        }
        int iSave = canvas.save();
        canvas.clipRect(this.f68339u.o());
        this.f68337s.b(canvas);
        if (!this.f68328j.A()) {
            this.f68301h0.k(canvas);
        }
        if (!this.f68295b0.A()) {
            this.f68297d0.k(canvas);
        }
        if (!this.f68296c0.A()) {
            this.f68298e0.k(canvas);
        }
        if (w()) {
            this.f68337s.d(canvas, this.B);
        }
        canvas.restoreToCount(iSave);
        this.f68337s.c(canvas);
        if (this.f68328j.f() && !this.f68328j.D()) {
            this.f68301h0.n(canvas);
        }
        if (this.f68295b0.f() && !this.f68295b0.D()) {
            this.f68297d0.l(canvas);
        }
        if (this.f68296c0.f() && !this.f68296c0.D()) {
            this.f68298e0.l(canvas);
        }
        this.f68301h0.i(canvas);
        this.f68297d0.i(canvas);
        this.f68298e0.i(canvas);
        if (F()) {
            int iSave2 = canvas.save();
            canvas.clipRect(this.f68339u.o());
            this.f68337s.e(canvas);
            canvas.restoreToCount(iSave2);
        } else {
            this.f68337s.e(canvas);
        }
        this.f68336r.e(canvas);
        h(canvas);
        i(canvas);
        if (this.f68320a) {
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            long j3 = this.f68302i0 + jCurrentTimeMillis2;
            this.f68302i0 = j3;
            long j4 = this.f68303j0 + 1;
            this.f68303j0 = j4;
            Log.i("MPAndroidChart", "Drawtime: " + jCurrentTimeMillis2 + " ms, average: " + (j3 / j4) + " ms, cycles: " + this.f68303j0);
        }
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        float[] fArr = this.f68311r0;
        fArr[1] = 0.0f;
        fArr[0] = 0.0f;
        if (this.W) {
            fArr[0] = this.f68339u.h();
            this.f68311r0[1] = this.f68339u.j();
            a(YAxis.AxisDependency.LEFT).j(this.f68311r0);
        }
        super.onSizeChanged(i3, i4, i5, i6);
        if (this.W) {
            a(YAxis.AxisDependency.LEFT).k(this.f68311r0);
            this.f68339u.e(this.f68311r0, this);
        } else {
            ViewPortHandler viewPortHandler = this.f68339u;
            viewPortHandler.J(viewPortHandler.p(), this, true);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        ChartTouchListener chartTouchListener = this.f68333o;
        if (chartTouchListener == null || this.f68321b == null || !this.f68329k) {
            return false;
        }
        return chartTouchListener.onTouch(this, motionEvent);
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void s() {
        if (this.f68321b == null) {
            if (this.f68320a) {
                Log.i("MPAndroidChart", "Preparing... DATA NOT SET.");
                return;
            }
            return;
        }
        if (this.f68320a) {
            Log.i("MPAndroidChart", "Preparing...");
        }
        DataRenderer dataRenderer = this.f68337s;
        if (dataRenderer != null) {
            dataRenderer.f();
        }
        y();
        YAxisRenderer yAxisRenderer = this.f68297d0;
        YAxis yAxis = this.f68295b0;
        yAxisRenderer.a(yAxis.H, yAxis.G, yAxis.i0());
        YAxisRenderer yAxisRenderer2 = this.f68298e0;
        YAxis yAxis2 = this.f68296c0;
        yAxisRenderer2.a(yAxis2.H, yAxis2.G, yAxis2.i0());
        XAxisRenderer xAxisRenderer = this.f68301h0;
        XAxis xAxis = this.f68328j;
        xAxisRenderer.a(xAxis.H, xAxis.G, false);
        if (this.f68331m != null) {
            this.f68336r.a(this.f68321b);
        }
        f();
    }

    public void setAutoScaleMinMaxEnabled(boolean z2) {
        this.I = z2;
    }

    public void setBorderColor(int i3) {
        this.R.setColor(i3);
    }

    public void setBorderWidth(float f3) {
        this.R.setStrokeWidth(Utils.e(f3));
    }

    public void setClipValuesToContent(boolean z2) {
        this.U = z2;
    }

    public void setDoubleTapToZoomEnabled(boolean z2) {
        this.K = z2;
    }

    public void setDragEnabled(boolean z2) {
        this.M = z2;
        this.N = z2;
    }

    public void setDragOffsetX(float f3) {
        this.f68339u.M(f3);
    }

    public void setDragOffsetY(float f3) {
        this.f68339u.N(f3);
    }

    public void setDragXEnabled(boolean z2) {
        this.M = z2;
    }

    public void setDragYEnabled(boolean z2) {
        this.N = z2;
    }

    public void setDrawBorders(boolean z2) {
        this.T = z2;
    }

    public void setDrawGridBackground(boolean z2) {
        this.S = z2;
    }

    public void setGridBackgroundColor(int i3) {
        this.Q.setColor(i3);
    }

    public void setHighlightPerDragEnabled(boolean z2) {
        this.L = z2;
    }

    public void setKeepPositionOnRotation(boolean z2) {
        this.W = z2;
    }

    public void setMaxVisibleValueCount(int i3) {
        this.H = i3;
    }

    public void setMinOffset(float f3) {
        this.V = f3;
    }

    public void setOnDrawListener(OnDrawListener onDrawListener) {
        this.f68294a0 = onDrawListener;
    }

    public void setPinchZoom(boolean z2) {
        this.J = z2;
    }

    public void setRendererLeftYAxis(YAxisRenderer yAxisRenderer) {
        this.f68297d0 = yAxisRenderer;
    }

    public void setRendererRightYAxis(YAxisRenderer yAxisRenderer) {
        this.f68298e0 = yAxisRenderer;
    }

    public void setScaleEnabled(boolean z2) {
        this.O = z2;
        this.P = z2;
    }

    public void setScaleXEnabled(boolean z2) {
        this.O = z2;
    }

    public void setScaleYEnabled(boolean z2) {
        this.P = z2;
    }

    public void setVisibleXRangeMaximum(float f3) {
        this.f68339u.Q(this.f68328j.I / f3);
    }

    public void setVisibleXRangeMinimum(float f3) {
        this.f68339u.O(this.f68328j.I / f3);
    }

    public void setXAxisRenderer(XAxisRenderer xAxisRenderer) {
        this.f68301h0 = xAxisRenderer;
    }

    protected void x() {
        ((BarLineScatterCandleBubbleData) this.f68321b).d(getLowestVisibleX(), getHighestVisibleX());
        this.f68328j.l(((BarLineScatterCandleBubbleData) this.f68321b).n(), ((BarLineScatterCandleBubbleData) this.f68321b).m());
        if (this.f68295b0.f()) {
            YAxis yAxis = this.f68295b0;
            BarLineScatterCandleBubbleData barLineScatterCandleBubbleData = (BarLineScatterCandleBubbleData) this.f68321b;
            YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
            yAxis.l(barLineScatterCandleBubbleData.r(axisDependency), ((BarLineScatterCandleBubbleData) this.f68321b).p(axisDependency));
        }
        if (this.f68296c0.f()) {
            YAxis yAxis2 = this.f68296c0;
            BarLineScatterCandleBubbleData barLineScatterCandleBubbleData2 = (BarLineScatterCandleBubbleData) this.f68321b;
            YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
            yAxis2.l(barLineScatterCandleBubbleData2.r(axisDependency2), ((BarLineScatterCandleBubbleData) this.f68321b).p(axisDependency2));
        }
        f();
    }

    protected void y() {
        this.f68328j.l(((BarLineScatterCandleBubbleData) this.f68321b).n(), ((BarLineScatterCandleBubbleData) this.f68321b).m());
        YAxis yAxis = this.f68295b0;
        BarLineScatterCandleBubbleData barLineScatterCandleBubbleData = (BarLineScatterCandleBubbleData) this.f68321b;
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        yAxis.l(barLineScatterCandleBubbleData.r(axisDependency), ((BarLineScatterCandleBubbleData) this.f68321b).p(axisDependency));
        YAxis yAxis2 = this.f68296c0;
        BarLineScatterCandleBubbleData barLineScatterCandleBubbleData2 = (BarLineScatterCandleBubbleData) this.f68321b;
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
        yAxis2.l(barLineScatterCandleBubbleData2.r(axisDependency2), ((BarLineScatterCandleBubbleData) this.f68321b).p(axisDependency2));
    }

    protected void z(RectF rectF) {
        rectF.left = 0.0f;
        rectF.right = 0.0f;
        rectF.top = 0.0f;
        rectF.bottom = 0.0f;
        Legend legend = this.f68331m;
        if (legend == null || !legend.f() || this.f68331m.G()) {
            return;
        }
        int i3 = AnonymousClass2.f68319c[this.f68331m.B().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            int i4 = AnonymousClass2.f68317a[this.f68331m.D().ordinal()];
            if (i4 == 1) {
                rectF.top += Math.min(this.f68331m.f68422y, this.f68339u.l() * this.f68331m.y()) + this.f68331m.e();
                return;
            } else {
                if (i4 != 2) {
                    return;
                }
                rectF.bottom += Math.min(this.f68331m.f68422y, this.f68339u.l() * this.f68331m.y()) + this.f68331m.e();
                return;
            }
        }
        int i5 = AnonymousClass2.f68318b[this.f68331m.x().ordinal()];
        if (i5 == 1) {
            rectF.left += Math.min(this.f68331m.f68421x, this.f68339u.m() * this.f68331m.y()) + this.f68331m.d();
            return;
        }
        if (i5 == 2) {
            rectF.right += Math.min(this.f68331m.f68421x, this.f68339u.m() * this.f68331m.y()) + this.f68331m.d();
            return;
        }
        if (i5 != 3) {
            return;
        }
        int i6 = AnonymousClass2.f68317a[this.f68331m.D().ordinal()];
        if (i6 == 1) {
            rectF.top += Math.min(this.f68331m.f68422y, this.f68339u.l() * this.f68331m.y()) + this.f68331m.e();
        } else {
            if (i6 != 2) {
                return;
            }
            rectF.bottom += Math.min(this.f68331m.f68422y, this.f68339u.l() * this.f68331m.y()) + this.f68331m.e();
        }
    }
}
