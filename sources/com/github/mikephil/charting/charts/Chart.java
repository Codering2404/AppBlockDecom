package com.github.mikephil.charting.charts;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.IMarker;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.IHighlighter;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LegendRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Chart<T extends ChartData<? extends IDataSet<? extends Entry>>> extends ViewGroup implements ChartInterface {
    private boolean A;
    protected Highlight[] B;
    protected float C;
    protected boolean D;
    protected IMarker E;
    protected ArrayList F;
    private boolean G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f68320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected ChartData f68321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected boolean f68322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f68323d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f68324f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected DefaultValueFormatter f68325g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected Paint f68326h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected Paint f68327i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected XAxis f68328j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected boolean f68329k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected Description f68330l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected Legend f68331m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected OnChartValueSelectedListener f68332n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected ChartTouchListener f68333o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f68334p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private OnChartGestureListener f68335q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected LegendRenderer f68336r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected DataRenderer f68337s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected IHighlighter f68338t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected ViewPortHandler f68339u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected ChartAnimator f68340v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f68341w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f68342x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f68343y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f68344z;

    /* JADX INFO: renamed from: com.github.mikephil.charting.charts.Chart$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f68346a;

        static {
            int[] iArr = new int[Bitmap.CompressFormat.values().length];
            f68346a = iArr;
            try {
                iArr[Bitmap.CompressFormat.PNG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f68346a[Bitmap.CompressFormat.WEBP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f68346a[Bitmap.CompressFormat.JPEG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public Chart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f68320a = false;
        this.f68321b = null;
        this.f68322c = true;
        this.f68323d = true;
        this.f68324f = 0.9f;
        this.f68325g = new DefaultValueFormatter(0);
        this.f68329k = true;
        this.f68334p = "No chart data available.";
        this.f68339u = new ViewPortHandler();
        this.f68341w = 0.0f;
        this.f68342x = 0.0f;
        this.f68343y = 0.0f;
        this.f68344z = 0.0f;
        this.A = false;
        this.C = 0.0f;
        this.D = true;
        this.F = new ArrayList();
        this.G = false;
        n();
    }

    private void v(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i3 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i3 >= viewGroup.getChildCount()) {
                viewGroup.removeAllViews();
                return;
            } else {
                v(viewGroup.getChildAt(i3));
                i3++;
            }
        }
    }

    protected abstract void f();

    public void g() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public ChartAnimator getAnimator() {
        return this.f68340v;
    }

    public MPPointF getCenter() {
        return MPPointF.c(getWidth() / 2.0f, getHeight() / 2.0f);
    }

    public MPPointF getCenterOfView() {
        return getCenter();
    }

    public MPPointF getCenterOffsets() {
        return this.f68339u.n();
    }

    public Bitmap getChartBitmap() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Drawable background = getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        draw(canvas);
        return bitmapCreateBitmap;
    }

    public RectF getContentRect() {
        return this.f68339u.o();
    }

    public T getData() {
        return (T) this.f68321b;
    }

    public ValueFormatter getDefaultValueFormatter() {
        return this.f68325g;
    }

    public Description getDescription() {
        return this.f68330l;
    }

    public float getDragDecelerationFrictionCoef() {
        return this.f68324f;
    }

    public float getExtraBottomOffset() {
        return this.f68343y;
    }

    public float getExtraLeftOffset() {
        return this.f68344z;
    }

    public float getExtraRightOffset() {
        return this.f68342x;
    }

    public float getExtraTopOffset() {
        return this.f68341w;
    }

    public Highlight[] getHighlighted() {
        return this.B;
    }

    public IHighlighter getHighlighter() {
        return this.f68338t;
    }

    public ArrayList<Runnable> getJobs() {
        return this.F;
    }

    public Legend getLegend() {
        return this.f68331m;
    }

    public LegendRenderer getLegendRenderer() {
        return this.f68336r;
    }

    public IMarker getMarker() {
        return this.E;
    }

    @Deprecated
    public IMarker getMarkerView() {
        return getMarker();
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getMaxHighlightDistance() {
        return this.C;
    }

    public abstract /* synthetic */ int getMaxVisibleCount();

    public OnChartGestureListener getOnChartGestureListener() {
        return this.f68335q;
    }

    public ChartTouchListener getOnTouchListener() {
        return this.f68333o;
    }

    public DataRenderer getRenderer() {
        return this.f68337s;
    }

    public ViewPortHandler getViewPortHandler() {
        return this.f68339u;
    }

    public XAxis getXAxis() {
        return this.f68328j;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getXChartMax() {
        return this.f68328j.G;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getXChartMin() {
        return this.f68328j.H;
    }

    public float getXRange() {
        return this.f68328j.I;
    }

    public abstract /* synthetic */ float getYChartMax();

    public abstract /* synthetic */ float getYChartMin();

    public float getYMax() {
        return this.f68321b.o();
    }

    public float getYMin() {
        return this.f68321b.q();
    }

    protected void h(Canvas canvas) {
        float height;
        float width;
        Description description = this.f68330l;
        if (description == null || !description.f()) {
            return;
        }
        MPPointF mPPointFL = this.f68330l.l();
        this.f68326h.setTypeface(this.f68330l.c());
        this.f68326h.setTextSize(this.f68330l.b());
        this.f68326h.setColor(this.f68330l.a());
        this.f68326h.setTextAlign(this.f68330l.n());
        if (mPPointFL == null) {
            width = (getWidth() - this.f68339u.H()) - this.f68330l.d();
            height = (getHeight() - this.f68339u.F()) - this.f68330l.e();
        } else {
            float f3 = mPPointFL.f68793c;
            height = mPPointFL.f68794d;
            width = f3;
        }
        canvas.drawText(this.f68330l.m(), width, height, this.f68326h);
    }

    protected void i(Canvas canvas) {
        if (this.E == null || !p() || !w()) {
            return;
        }
        int i3 = 0;
        while (true) {
            Highlight[] highlightArr = this.B;
            if (i3 >= highlightArr.length) {
                return;
            }
            Highlight highlight = highlightArr[i3];
            IDataSet iDataSetE = this.f68321b.e(highlight.d());
            Entry entryI = this.f68321b.i(this.B[i3]);
            int iE = iDataSetE.e(entryI);
            if (entryI != null && iE <= iDataSetE.J0() * this.f68340v.a()) {
                float[] fArrL = l(highlight);
                if (this.f68339u.x(fArrL[0], fArrL[1])) {
                    this.E.b(entryI, highlight);
                    this.E.a(canvas, fArrL[0], fArrL[1]);
                }
            }
            i3++;
        }
    }

    public void j() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    public Highlight k(float f3, float f4) {
        if (this.f68321b != null) {
            return getHighlighter().a(f3, f4);
        }
        Log.e("MPAndroidChart", "Can't select by touch. No data set.");
        return null;
    }

    protected float[] l(Highlight highlight) {
        return new float[]{highlight.e(), highlight.f()};
    }

    public void m(Highlight highlight, boolean z2) {
        Entry entry = null;
        if (highlight == null) {
            this.B = null;
        } else {
            if (this.f68320a) {
                Log.i("MPAndroidChart", "Highlighted: " + highlight.toString());
            }
            Entry entryI = this.f68321b.i(highlight);
            if (entryI == null) {
                this.B = null;
                highlight = null;
            } else {
                this.B = new Highlight[]{highlight};
            }
            entry = entryI;
        }
        setLastHighlighted(this.B);
        if (z2 && this.f68332n != null) {
            if (w()) {
                this.f68332n.a(entry, highlight);
            } else {
                this.f68332n.b();
            }
        }
        invalidate();
    }

    protected void n() {
        setWillNotDraw(false);
        this.f68340v = new ChartAnimator(new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.mikephil.charting.charts.Chart.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Chart.this.postInvalidate();
            }
        });
        Utils.v(getContext());
        this.C = Utils.e(500.0f);
        this.f68330l = new Description();
        Legend legend = new Legend();
        this.f68331m = legend;
        this.f68336r = new LegendRenderer(this.f68339u, legend);
        this.f68328j = new XAxis();
        this.f68326h = new Paint(1);
        Paint paint = new Paint(1);
        this.f68327i = paint;
        paint.setColor(Color.rgb(247, 189, 51));
        this.f68327i.setTextAlign(Paint.Align.CENTER);
        this.f68327i.setTextSize(Utils.e(12.0f));
        if (this.f68320a) {
            Log.i("", "Chart.init()");
        }
    }

    public boolean o() {
        return this.f68323d;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.G) {
            v(this);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f68321b == null) {
            if (TextUtils.isEmpty(this.f68334p)) {
                return;
            }
            MPPointF center = getCenter();
            canvas.drawText(this.f68334p, center.f68793c, center.f68794d, this.f68327i);
            return;
        }
        if (this.A) {
            return;
        }
        f();
        this.A = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            getChildAt(i7).layout(i3, i4, i5, i6);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        int iE = (int) Utils.e(50.0f);
        setMeasuredDimension(Math.max(getSuggestedMinimumWidth(), View.resolveSize(iE, i3)), Math.max(getSuggestedMinimumHeight(), View.resolveSize(iE, i4)));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        if (this.f68320a) {
            Log.i("MPAndroidChart", "OnSizeChanged()");
        }
        if (i3 > 0 && i4 > 0 && i3 < 10000 && i4 < 10000) {
            if (this.f68320a) {
                Log.i("MPAndroidChart", "Setting chart dimens, width: " + i3 + ", height: " + i4);
            }
            this.f68339u.L(i3, i4);
        } else if (this.f68320a) {
            Log.w("MPAndroidChart", "*Avoiding* setting chart dimens! width: " + i3 + ", height: " + i4);
        }
        s();
        ArrayList arrayList = this.F;
        int size = arrayList.size();
        int i7 = 0;
        while (i7 < size) {
            Object obj = arrayList.get(i7);
            i7++;
            post((Runnable) obj);
        }
        this.F.clear();
        super.onSizeChanged(i3, i4, i5, i6);
    }

    public boolean p() {
        return this.D;
    }

    public boolean q() {
        return this.f68322c;
    }

    public boolean r() {
        return this.f68320a;
    }

    public abstract void s();

    public void setData(T t2) {
        this.f68321b = t2;
        this.A = false;
        if (t2 == null) {
            return;
        }
        u(t2.q(), t2.o());
        for (IDataSet iDataSet : this.f68321b.g()) {
            if (iDataSet.t0() || iDataSet.p() == this.f68325g) {
                iDataSet.u0(this.f68325g);
            }
        }
        s();
        if (this.f68320a) {
            Log.i("MPAndroidChart", "Data is set.");
        }
    }

    public void setDescription(Description description) {
        this.f68330l = description;
    }

    public void setDragDecelerationEnabled(boolean z2) {
        this.f68323d = z2;
    }

    public void setDragDecelerationFrictionCoef(float f3) {
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 >= 1.0f) {
            f3 = 0.999f;
        }
        this.f68324f = f3;
    }

    @Deprecated
    public void setDrawMarkerViews(boolean z2) {
        setDrawMarkers(z2);
    }

    public void setDrawMarkers(boolean z2) {
        this.D = z2;
    }

    public void setExtraBottomOffset(float f3) {
        this.f68343y = Utils.e(f3);
    }

    public void setExtraLeftOffset(float f3) {
        this.f68344z = Utils.e(f3);
    }

    public void setExtraRightOffset(float f3) {
        this.f68342x = Utils.e(f3);
    }

    public void setExtraTopOffset(float f3) {
        this.f68341w = Utils.e(f3);
    }

    public void setHardwareAccelerationEnabled(boolean z2) {
        if (z2) {
            setLayerType(2, null);
        } else {
            setLayerType(1, null);
        }
    }

    public void setHighlightPerTapEnabled(boolean z2) {
        this.f68322c = z2;
    }

    public void setHighlighter(ChartHighlighter chartHighlighter) {
        this.f68338t = chartHighlighter;
    }

    protected void setLastHighlighted(Highlight[] highlightArr) {
        Highlight highlight;
        if (highlightArr == null || highlightArr.length <= 0 || (highlight = highlightArr[0]) == null) {
            this.f68333o.d(null);
        } else {
            this.f68333o.d(highlight);
        }
    }

    public void setLogEnabled(boolean z2) {
        this.f68320a = z2;
    }

    public void setMarker(IMarker iMarker) {
        this.E = iMarker;
    }

    @Deprecated
    public void setMarkerView(IMarker iMarker) {
        setMarker(iMarker);
    }

    public void setMaxHighlightDistance(float f3) {
        this.C = Utils.e(f3);
    }

    public void setNoDataText(String str) {
        this.f68334p = str;
    }

    public void setNoDataTextColor(int i3) {
        this.f68327i.setColor(i3);
    }

    public void setNoDataTextTypeface(Typeface typeface) {
        this.f68327i.setTypeface(typeface);
    }

    public void setOnChartGestureListener(OnChartGestureListener onChartGestureListener) {
        this.f68335q = onChartGestureListener;
    }

    public void setOnChartValueSelectedListener(OnChartValueSelectedListener onChartValueSelectedListener) {
        this.f68332n = onChartValueSelectedListener;
    }

    public void setOnTouchListener(ChartTouchListener chartTouchListener) {
        this.f68333o = chartTouchListener;
    }

    public void setRenderer(DataRenderer dataRenderer) {
        if (dataRenderer != null) {
            this.f68337s = dataRenderer;
        }
    }

    public void setTouchEnabled(boolean z2) {
        this.f68329k = z2;
    }

    public void setUnbindEnabled(boolean z2) {
        this.G = z2;
    }

    public void t(float f3, float f4, float f5, float f6) {
        setExtraLeftOffset(f3);
        setExtraTopOffset(f4);
        setExtraRightOffset(f5);
        setExtraBottomOffset(f6);
    }

    protected void u(float f3, float f4) {
        ChartData chartData = this.f68321b;
        this.f68325g.j(Utils.i((chartData == null || chartData.h() < 2) ? Math.max(Math.abs(f3), Math.abs(f4)) : Math.abs(f4 - f3)));
    }

    public boolean w() {
        Highlight[] highlightArr = this.B;
        return (highlightArr == null || highlightArr.length <= 0 || highlightArr[0] == null) ? false : true;
    }
}
