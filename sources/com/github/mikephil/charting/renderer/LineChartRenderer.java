package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LineChartRenderer extends LineRadarRenderer {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected LineDataProvider f68711i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected Paint f68712j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected WeakReference f68713k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected Canvas f68714l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected Bitmap.Config f68715m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected Path f68716n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected Path f68717o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float[] f68718p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected Path f68719q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private HashMap f68720r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float[] f68721s;

    /* JADX INFO: renamed from: com.github.mikephil.charting.renderer.LineChartRenderer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f68722a;

        static {
            int[] iArr = new int[LineDataSet.Mode.values().length];
            f68722a = iArr;
            try {
                iArr[LineDataSet.Mode.LINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f68722a[LineDataSet.Mode.STEPPED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f68722a[LineDataSet.Mode.CUBIC_BEZIER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f68722a[LineDataSet.Mode.HORIZONTAL_BEZIER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public LineChartRenderer(LineDataProvider lineDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f68715m = Bitmap.Config.ARGB_8888;
        this.f68716n = new Path();
        this.f68717o = new Path();
        this.f68718p = new float[4];
        this.f68719q = new Path();
        this.f68720r = new HashMap();
        this.f68721s = new float[2];
        this.f68711i = lineDataProvider;
        Paint paint = new Paint(1);
        this.f68712j = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f68712j.setColor(-1);
    }

    private void v(ILineDataSet iLineDataSet, int i3, int i4, Path path) {
        float fA = iLineDataSet.X().a(iLineDataSet, this.f68711i);
        float fB = this.f68695b.b();
        boolean z2 = iLineDataSet.o0() == LineDataSet.Mode.STEPPED;
        path.reset();
        Entry entryR = iLineDataSet.r(i3);
        path.moveTo(entryR.h(), fA);
        path.lineTo(entryR.h(), entryR.e() * fB);
        int i5 = i3 + 1;
        Entry entryR2 = null;
        while (i5 <= i4) {
            entryR2 = iLineDataSet.r(i5);
            if (z2) {
                path.lineTo(entryR2.h(), entryR.e() * fB);
            }
            path.lineTo(entryR2.h(), entryR2.e() * fB);
            i5++;
            entryR = entryR2;
        }
        if (entryR2 != null) {
            path.lineTo(entryR2.h(), fA);
        }
        path.close();
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void b(Canvas canvas) {
        int iM = (int) this.f68749a.m();
        int iL = (int) this.f68749a.l();
        WeakReference weakReference = this.f68713k;
        Bitmap bitmapCreateBitmap = weakReference == null ? null : (Bitmap) weakReference.get();
        if (bitmapCreateBitmap == null || bitmapCreateBitmap.getWidth() != iM || bitmapCreateBitmap.getHeight() != iL) {
            if (iM <= 0 || iL <= 0) {
                return;
            }
            bitmapCreateBitmap = Bitmap.createBitmap(iM, iL, this.f68715m);
            this.f68713k = new WeakReference(bitmapCreateBitmap);
            this.f68714l = new Canvas(bitmapCreateBitmap);
        }
        bitmapCreateBitmap.eraseColor(0);
        for (ILineDataSet iLineDataSet : this.f68711i.getLineData().g()) {
            if (iLineDataSet.isVisible()) {
                q(canvas, iLineDataSet);
            }
        }
        canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, this.f68696c);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void c(Canvas canvas) {
        n(canvas);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void d(Canvas canvas, Highlight[] highlightArr) {
        LineData lineData = this.f68711i.getLineData();
        for (Highlight highlight : highlightArr) {
            ILineScatterCandleRadarDataSet iLineScatterCandleRadarDataSet = (ILineDataSet) lineData.e(highlight.d());
            if (iLineScatterCandleRadarDataSet != null && iLineScatterCandleRadarDataSet.M0()) {
                Entry entryA0 = iLineScatterCandleRadarDataSet.a0(highlight.h(), highlight.j());
                if (h(entryA0, iLineScatterCandleRadarDataSet)) {
                    MPPointD mPPointDE = this.f68711i.a(iLineScatterCandleRadarDataSet.K()).e(entryA0.h(), entryA0.e() * this.f68695b.b());
                    highlight.m((float) mPPointDE.f68789c, (float) mPPointDE.f68790d);
                    j(canvas, (float) mPPointDE.f68789c, (float) mPPointDE.f68790d, iLineScatterCandleRadarDataSet);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void e(Canvas canvas) {
        Entry entry;
        LineChartRenderer lineChartRenderer = this;
        if (lineChartRenderer.g(lineChartRenderer.f68711i)) {
            List listG = lineChartRenderer.f68711i.getLineData().g();
            int i3 = 0;
            while (i3 < listG.size()) {
                ILineDataSet iLineDataSet = (ILineDataSet) listG.get(i3);
                if (lineChartRenderer.i(iLineDataSet) && iLineDataSet.J0() >= 1) {
                    lineChartRenderer.a(iLineDataSet);
                    Transformer transformerA = lineChartRenderer.f68711i.a(iLineDataSet.K());
                    int iL0 = (int) (iLineDataSet.l0() * 1.75f);
                    if (!iLineDataSet.L0()) {
                        iL0 /= 2;
                    }
                    int i4 = iL0;
                    lineChartRenderer.f68676g.a(lineChartRenderer.f68711i, iLineDataSet);
                    float fA = lineChartRenderer.f68695b.a();
                    float fB = lineChartRenderer.f68695b.b();
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds = lineChartRenderer.f68676g;
                    float[] fArrC = transformerA.c(iLineDataSet, fA, fB, xBounds.f68677a, xBounds.f68678b);
                    ValueFormatter valueFormatterP = iLineDataSet.p();
                    MPPointF mPPointFD = MPPointF.d(iLineDataSet.K0());
                    mPPointFD.f68793c = Utils.e(mPPointFD.f68793c);
                    mPPointFD.f68794d = Utils.e(mPPointFD.f68794d);
                    int i5 = 0;
                    while (i5 < fArrC.length) {
                        float f3 = fArrC[i5];
                        float f4 = fArrC[i5 + 1];
                        if (!lineChartRenderer.f68749a.A(f3)) {
                            break;
                        }
                        if (lineChartRenderer.f68749a.z(f3) && lineChartRenderer.f68749a.D(f4)) {
                            int i6 = i5 / 2;
                            Entry entryR = iLineDataSet.r(lineChartRenderer.f68676g.f68677a + i6);
                            if (iLineDataSet.I()) {
                                entry = entryR;
                                lineChartRenderer.u(canvas, valueFormatterP.h(entryR), f3, f4 - i4, iLineDataSet.x(i6));
                            } else {
                                entry = entryR;
                            }
                            if (entry.d() != null && iLineDataSet.c0()) {
                                Drawable drawableD = entry.d();
                                Utils.f(canvas, drawableD, (int) (f3 + mPPointFD.f68793c), (int) (f4 + mPPointFD.f68794d), drawableD.getIntrinsicWidth(), drawableD.getIntrinsicHeight());
                            }
                        }
                        i5 += 2;
                        lineChartRenderer = this;
                    }
                    MPPointF.f(mPPointFD);
                }
                i3++;
                lineChartRenderer = this;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void n(Canvas canvas) {
        DataSetImageCache dataSetImageCache;
        Bitmap bitmapB;
        this.f68696c.setStyle(Paint.Style.FILL);
        float fB = this.f68695b.b();
        float[] fArr = this.f68721s;
        char c3 = 0;
        float f3 = 0.0f;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        List listG = this.f68711i.getLineData().g();
        int i3 = 0;
        while (i3 < listG.size()) {
            ILineDataSet iLineDataSet = (ILineDataSet) listG.get(i3);
            if (iLineDataSet.isVisible() && iLineDataSet.L0() && iLineDataSet.J0() != 0) {
                this.f68712j.setColor(iLineDataSet.k());
                Transformer transformerA = this.f68711i.a(iLineDataSet.K());
                this.f68676g.a(this.f68711i, iLineDataSet);
                float fL0 = iLineDataSet.l0();
                float fN0 = iLineDataSet.N0();
                boolean z2 = (!iLineDataSet.S0() || fN0 >= fL0 || fN0 <= f3) ? c3 : 1;
                boolean z3 = (z2 == 0 || iLineDataSet.k() != 1122867) ? c3 : 1;
                AnonymousClass1 anonymousClass1 = null;
                if (this.f68720r.containsKey(iLineDataSet)) {
                    dataSetImageCache = (DataSetImageCache) this.f68720r.get(iLineDataSet);
                } else {
                    DataSetImageCache dataSetImageCache2 = new DataSetImageCache(this, anonymousClass1);
                    this.f68720r.put(iLineDataSet, dataSetImageCache2);
                    dataSetImageCache = dataSetImageCache2;
                }
                if (dataSetImageCache.c(iLineDataSet)) {
                    dataSetImageCache.a(iLineDataSet, z2, z3);
                }
                BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.f68676g;
                int i4 = xBounds.f68679c;
                int i5 = xBounds.f68677a;
                int i6 = i4 + i5;
                while (i5 <= i6) {
                    Entry entryR = iLineDataSet.r(i5);
                    if (entryR == null) {
                        break;
                    }
                    this.f68721s[c3] = entryR.h();
                    this.f68721s[1] = entryR.e() * fB;
                    transformerA.k(this.f68721s);
                    if (!this.f68749a.A(this.f68721s[c3])) {
                        break;
                    }
                    if (this.f68749a.z(this.f68721s[c3]) && this.f68749a.D(this.f68721s[1]) && (bitmapB = dataSetImageCache.b(i5)) != null) {
                        float[] fArr2 = this.f68721s;
                        canvas.drawBitmap(bitmapB, fArr2[c3] - fL0, fArr2[1] - fL0, (Paint) null);
                    }
                    i5++;
                    c3 = 0;
                }
            }
            i3++;
            c3 = 0;
            f3 = 0.0f;
        }
    }

    protected void o(ILineDataSet iLineDataSet) {
        float fB = this.f68695b.b();
        Transformer transformerA = this.f68711i.a(iLineDataSet.K());
        this.f68676g.a(this.f68711i, iLineDataSet);
        float fN = iLineDataSet.n();
        this.f68716n.reset();
        BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.f68676g;
        if (xBounds.f68679c >= 1) {
            int i3 = xBounds.f68677a;
            Entry entryR = iLineDataSet.r(Math.max(i3 - 1, 0));
            Entry entryR2 = iLineDataSet.r(Math.max(i3, 0));
            if (entryR2 != null) {
                this.f68716n.moveTo(entryR2.h(), entryR2.e() * fB);
                int i4 = this.f68676g.f68677a + 1;
                int i5 = -1;
                Entry entry = entryR2;
                while (true) {
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds2 = this.f68676g;
                    if (i4 > xBounds2.f68679c + xBounds2.f68677a) {
                        break;
                    }
                    if (i5 != i4) {
                        entryR2 = iLineDataSet.r(i4);
                    }
                    int i6 = i4 + 1;
                    if (i6 < iLineDataSet.J0()) {
                        i4 = i6;
                    }
                    Entry entryR3 = iLineDataSet.r(i4);
                    this.f68716n.cubicTo(entry.h() + ((entryR2.h() - entryR.h()) * fN), (entry.e() + ((entryR2.e() - entryR.e()) * fN)) * fB, entryR2.h() - ((entryR3.h() - entry.h()) * fN), (entryR2.e() - ((entryR3.e() - entry.e()) * fN)) * fB, entryR2.h(), entryR2.e() * fB);
                    int i7 = i4;
                    i4 = i6;
                    i5 = i7;
                    entryR = entry;
                    entry = entryR2;
                    entryR2 = entryR3;
                }
            } else {
                return;
            }
        }
        if (iLineDataSet.m0()) {
            this.f68717o.reset();
            this.f68717o.addPath(this.f68716n);
            p(this.f68714l, iLineDataSet, this.f68717o, transformerA, this.f68676g);
        }
        this.f68696c.setColor(iLineDataSet.M());
        this.f68696c.setStyle(Paint.Style.STROKE);
        transformerA.i(this.f68716n);
        this.f68714l.drawPath(this.f68716n, this.f68696c);
        this.f68696c.setPathEffect(null);
    }

    protected void p(Canvas canvas, ILineDataSet iLineDataSet, Path path, Transformer transformer, BarLineScatterCandleBubbleRenderer.XBounds xBounds) {
        float fA = iLineDataSet.X().a(iLineDataSet, this.f68711i);
        path.lineTo(iLineDataSet.r(xBounds.f68677a + xBounds.f68679c).h(), fA);
        path.lineTo(iLineDataSet.r(xBounds.f68677a).h(), fA);
        path.close();
        transformer.i(path);
        Drawable drawableO = iLineDataSet.o();
        if (drawableO != null) {
            m(canvas, path, drawableO);
        } else {
            l(canvas, path, iLineDataSet.S(), iLineDataSet.b());
        }
    }

    protected void q(Canvas canvas, ILineDataSet iLineDataSet) {
        if (iLineDataSet.J0() < 1) {
            return;
        }
        this.f68696c.setStrokeWidth(iLineDataSet.g());
        this.f68696c.setPathEffect(iLineDataSet.g0());
        int i3 = AnonymousClass1.f68722a[iLineDataSet.o0().ordinal()];
        if (i3 == 3) {
            o(iLineDataSet);
        } else if (i3 != 4) {
            s(canvas, iLineDataSet);
        } else {
            r(iLineDataSet);
        }
        this.f68696c.setPathEffect(null);
    }

    protected void r(ILineDataSet iLineDataSet) {
        float fB = this.f68695b.b();
        Transformer transformerA = this.f68711i.a(iLineDataSet.K());
        this.f68676g.a(this.f68711i, iLineDataSet);
        this.f68716n.reset();
        BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.f68676g;
        if (xBounds.f68679c >= 1) {
            Entry entryR = iLineDataSet.r(xBounds.f68677a);
            this.f68716n.moveTo(entryR.h(), entryR.e() * fB);
            int i3 = this.f68676g.f68677a + 1;
            while (true) {
                BarLineScatterCandleBubbleRenderer.XBounds xBounds2 = this.f68676g;
                if (i3 > xBounds2.f68679c + xBounds2.f68677a) {
                    break;
                }
                Entry entryR2 = iLineDataSet.r(i3);
                float fH = entryR.h() + ((entryR2.h() - entryR.h()) / 2.0f);
                this.f68716n.cubicTo(fH, entryR.e() * fB, fH, entryR2.e() * fB, entryR2.h(), entryR2.e() * fB);
                i3++;
                entryR = entryR2;
            }
        }
        if (iLineDataSet.m0()) {
            this.f68717o.reset();
            this.f68717o.addPath(this.f68716n);
            p(this.f68714l, iLineDataSet, this.f68717o, transformerA, this.f68676g);
        }
        this.f68696c.setColor(iLineDataSet.M());
        this.f68696c.setStyle(Paint.Style.STROKE);
        transformerA.i(this.f68716n);
        this.f68714l.drawPath(this.f68716n, this.f68696c);
        this.f68696c.setPathEffect(null);
    }

    protected void s(Canvas canvas, ILineDataSet iLineDataSet) {
        int iJ0 = iLineDataSet.J0();
        boolean z2 = iLineDataSet.o0() == LineDataSet.Mode.STEPPED;
        int i3 = z2 ? 4 : 2;
        Transformer transformerA = this.f68711i.a(iLineDataSet.K());
        float fB = this.f68695b.b();
        this.f68696c.setStyle(Paint.Style.STROKE);
        Canvas canvas2 = iLineDataSet.i() ? this.f68714l : canvas;
        this.f68676g.a(this.f68711i, iLineDataSet);
        if (iLineDataSet.m0() && iJ0 > 0) {
            t(canvas, iLineDataSet, transformerA, this.f68676g);
        }
        if (iLineDataSet.z().size() > 1) {
            int i4 = i3 * 2;
            if (this.f68718p.length <= i4) {
                this.f68718p = new float[i3 * 4];
            }
            int i5 = this.f68676g.f68677a;
            while (true) {
                BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.f68676g;
                if (i5 > xBounds.f68679c + xBounds.f68677a) {
                    break;
                }
                Entry entryR = iLineDataSet.r(i5);
                if (entryR != null) {
                    this.f68718p[0] = entryR.h();
                    this.f68718p[1] = entryR.e() * fB;
                    if (i5 < this.f68676g.f68678b) {
                        Entry entryR2 = iLineDataSet.r(i5 + 1);
                        if (entryR2 == null) {
                            break;
                        }
                        if (z2) {
                            this.f68718p[2] = entryR2.h();
                            float[] fArr = this.f68718p;
                            float f3 = fArr[1];
                            fArr[3] = f3;
                            fArr[4] = fArr[2];
                            fArr[5] = f3;
                            fArr[6] = entryR2.h();
                            this.f68718p[7] = entryR2.e() * fB;
                        } else {
                            this.f68718p[2] = entryR2.h();
                            this.f68718p[3] = entryR2.e() * fB;
                        }
                    } else {
                        float[] fArr2 = this.f68718p;
                        fArr2[2] = fArr2[0];
                        fArr2[3] = fArr2[1];
                    }
                    transformerA.k(this.f68718p);
                    if (!this.f68749a.A(this.f68718p[0])) {
                        break;
                    }
                    if (this.f68749a.z(this.f68718p[2]) && (this.f68749a.B(this.f68718p[1]) || this.f68749a.y(this.f68718p[3]))) {
                        this.f68696c.setColor(iLineDataSet.p0(i5));
                        canvas2.drawLines(this.f68718p, 0, i4, this.f68696c);
                    }
                }
                i5++;
            }
        } else {
            int i6 = iJ0 * i3;
            if (this.f68718p.length < Math.max(i6, i3) * 2) {
                this.f68718p = new float[Math.max(i6, i3) * 4];
            }
            if (iLineDataSet.r(this.f68676g.f68677a) != null) {
                int i7 = this.f68676g.f68677a;
                int i8 = 0;
                while (true) {
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds2 = this.f68676g;
                    if (i7 > xBounds2.f68679c + xBounds2.f68677a) {
                        break;
                    }
                    Entry entryR3 = iLineDataSet.r(i7 == 0 ? 0 : i7 - 1);
                    Entry entryR4 = iLineDataSet.r(i7);
                    if (entryR3 != null && entryR4 != null) {
                        this.f68718p[i8] = entryR3.h();
                        int i9 = i8 + 2;
                        this.f68718p[i8 + 1] = entryR3.e() * fB;
                        if (z2) {
                            this.f68718p[i9] = entryR4.h();
                            this.f68718p[i8 + 3] = entryR3.e() * fB;
                            this.f68718p[i8 + 4] = entryR4.h();
                            i9 = i8 + 6;
                            this.f68718p[i8 + 5] = entryR3.e() * fB;
                        }
                        this.f68718p[i9] = entryR4.h();
                        this.f68718p[i9 + 1] = entryR4.e() * fB;
                        i8 = i9 + 2;
                    }
                    i7++;
                }
                if (i8 > 0) {
                    transformerA.k(this.f68718p);
                    int iMax = Math.max((this.f68676g.f68679c + 1) * i3, i3) * 2;
                    this.f68696c.setColor(iLineDataSet.M());
                    canvas2.drawLines(this.f68718p, 0, iMax, this.f68696c);
                }
            }
        }
        this.f68696c.setPathEffect(null);
    }

    protected void t(Canvas canvas, ILineDataSet iLineDataSet, Transformer transformer, BarLineScatterCandleBubbleRenderer.XBounds xBounds) {
        int i3;
        int i4;
        Path path = this.f68719q;
        int i5 = xBounds.f68677a;
        int i6 = xBounds.f68679c + i5;
        int i7 = 0;
        do {
            i3 = (i7 * ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) + i5;
            i4 = i3 + ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
            if (i4 > i6) {
                i4 = i6;
            }
            if (i3 <= i4) {
                v(iLineDataSet, i3, i4, path);
                transformer.i(path);
                Drawable drawableO = iLineDataSet.o();
                if (drawableO != null) {
                    m(canvas, path, drawableO);
                } else {
                    l(canvas, path, iLineDataSet.S(), iLineDataSet.b());
                }
            }
            i7++;
        } while (i3 <= i4);
    }

    public void u(Canvas canvas, String str, float f3, float f4, int i3) {
        this.f68699f.setColor(i3);
        canvas.drawText(str, f3, f4, this.f68699f);
    }

    public void w() {
        Canvas canvas = this.f68714l;
        if (canvas != null) {
            canvas.setBitmap(null);
            this.f68714l = null;
        }
        WeakReference weakReference = this.f68713k;
        if (weakReference != null) {
            Bitmap bitmap = (Bitmap) weakReference.get();
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f68713k.clear();
            this.f68713k = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class DataSetImageCache {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Path f68723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Bitmap[] f68724b;

        private DataSetImageCache() {
            this.f68723a = new Path();
        }

        protected void a(ILineDataSet iLineDataSet, boolean z2, boolean z3) {
            int iR = iLineDataSet.R();
            float fL0 = iLineDataSet.l0();
            float fN0 = iLineDataSet.N0();
            for (int i3 = 0; i3 < iR; i3++) {
                int i4 = (int) (((double) fL0) * 2.1d);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i4, i4, Bitmap.Config.ARGB_4444);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                this.f68724b[i3] = bitmapCreateBitmap;
                LineChartRenderer.this.f68696c.setColor(iLineDataSet.I0(i3));
                if (z3) {
                    this.f68723a.reset();
                    this.f68723a.addCircle(fL0, fL0, fL0, Path.Direction.CW);
                    this.f68723a.addCircle(fL0, fL0, fN0, Path.Direction.CCW);
                    canvas.drawPath(this.f68723a, LineChartRenderer.this.f68696c);
                } else {
                    canvas.drawCircle(fL0, fL0, fL0, LineChartRenderer.this.f68696c);
                    if (z2) {
                        canvas.drawCircle(fL0, fL0, fN0, LineChartRenderer.this.f68712j);
                    }
                }
            }
        }

        protected Bitmap b(int i3) {
            Bitmap[] bitmapArr = this.f68724b;
            return bitmapArr[i3 % bitmapArr.length];
        }

        protected boolean c(ILineDataSet iLineDataSet) {
            int iR = iLineDataSet.R();
            Bitmap[] bitmapArr = this.f68724b;
            if (bitmapArr == null) {
                this.f68724b = new Bitmap[iR];
                return true;
            }
            if (bitmapArr.length == iR) {
                return false;
            }
            this.f68724b = new Bitmap[iR];
            return true;
        }

        /* synthetic */ DataSetImageCache(LineChartRenderer lineChartRenderer, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void f() {
    }
}
