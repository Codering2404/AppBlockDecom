package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.Range;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BarChartRenderer extends BarLineScatterCandleBubbleRenderer {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected BarDataProvider f68670h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected RectF f68671i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected BarBuffer[] f68672j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected Paint f68673k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected Paint f68674l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private RectF f68675m;

    public BarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f68671i = new RectF();
        this.f68675m = new RectF();
        this.f68670h = barDataProvider;
        Paint paint = new Paint(1);
        this.f68697d = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.f68697d.setColor(Color.rgb(0, 0, 0));
        this.f68697d.setAlpha(120);
        Paint paint2 = new Paint(1);
        this.f68673k = paint2;
        paint2.setStyle(style);
        Paint paint3 = new Paint(1);
        this.f68674l = paint3;
        paint3.setStyle(Paint.Style.STROKE);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void b(Canvas canvas) {
        BarData barData = this.f68670h.getBarData();
        for (int i3 = 0; i3 < barData.f(); i3++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.e(i3);
            if (iBarDataSet.isVisible()) {
                j(canvas, iBarDataSet, i3);
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void d(Canvas canvas, Highlight[] highlightArr) {
        float fE;
        float f3;
        BarData barData = this.f68670h.getBarData();
        for (Highlight highlight : highlightArr) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.e(highlight.d());
            if (iBarDataSet != null && iBarDataSet.M0()) {
                BarEntry barEntry = (BarEntry) iBarDataSet.a0(highlight.h(), highlight.j());
                if (h(barEntry, iBarDataSet)) {
                    Transformer transformerA = this.f68670h.a(iBarDataSet.K());
                    this.f68697d.setColor(iBarDataSet.H0());
                    this.f68697d.setAlpha(iBarDataSet.A0());
                    if (highlight.g() < 0 || !barEntry.p()) {
                        fE = barEntry.e();
                        f3 = 0.0f;
                    } else if (this.f68670h.c()) {
                        fE = barEntry.m();
                        f3 = -barEntry.l();
                    } else {
                        Range range = barEntry.n()[highlight.g()];
                        float f4 = range.f68590a;
                        f3 = range.f68591b;
                        fE = f4;
                    }
                    l(barEntry.h(), fE, f3, barData.t() / 2.0f, transformerA);
                    m(highlight, this.f68671i);
                    canvas.drawRect(this.f68671i, this.f68697d);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void e(Canvas canvas) {
        List list;
        MPPointF mPPointF;
        int i3;
        boolean z2;
        int i4;
        float[] fArr;
        float f3;
        Transformer transformer;
        int i5;
        float f4;
        int i6;
        float f5;
        float f6;
        BarEntry barEntry;
        float f7;
        float f8;
        boolean z3;
        int i7;
        ValueFormatter valueFormatter;
        List list2;
        MPPointF mPPointF2;
        BarEntry barEntry2;
        BarChartRenderer barChartRenderer = this;
        if (barChartRenderer.g(barChartRenderer.f68670h)) {
            List listG = barChartRenderer.f68670h.getBarData().g();
            float fE = Utils.e(4.5f);
            boolean zB = barChartRenderer.f68670h.b();
            int i8 = 0;
            while (i8 < barChartRenderer.f68670h.getBarData().f()) {
                IBarDataSet iBarDataSet = (IBarDataSet) listG.get(i8);
                if (barChartRenderer.i(iBarDataSet)) {
                    barChartRenderer.a(iBarDataSet);
                    boolean zD = barChartRenderer.f68670h.d(iBarDataSet.K());
                    float fA = Utils.a(barChartRenderer.f68699f, "8");
                    float f9 = zB ? -fE : fA + fE;
                    float f10 = zB ? fA + fE : -fE;
                    if (zD) {
                        f9 = (-f9) - fA;
                        f10 = (-f10) - fA;
                    }
                    float f11 = f9;
                    float f12 = f10;
                    BarBuffer barBuffer = barChartRenderer.f68672j[i8];
                    float fB = barChartRenderer.f68695b.b();
                    ValueFormatter valueFormatterP = iBarDataSet.p();
                    MPPointF mPPointFD = MPPointF.d(iBarDataSet.K0());
                    mPPointFD.f68793c = Utils.e(mPPointFD.f68793c);
                    mPPointFD.f68794d = Utils.e(mPPointFD.f68794d);
                    if (iBarDataSet.F0()) {
                        list = listG;
                        mPPointF = mPPointFD;
                        Transformer transformerA = barChartRenderer.f68670h.a(iBarDataSet.K());
                        int i9 = 0;
                        int length = 0;
                        while (i9 < iBarDataSet.J0() * barChartRenderer.f68695b.a()) {
                            BarEntry barEntry3 = (BarEntry) iBarDataSet.r(i9);
                            float[] fArrO = barEntry3.o();
                            float[] fArr2 = barBuffer.f68280b;
                            float f13 = (fArr2[length] + fArr2[length + 2]) / 2.0f;
                            int iX = iBarDataSet.x(i9);
                            if (fArrO == null) {
                                Transformer transformer2 = transformerA;
                                if (!barChartRenderer.f68749a.A(f13)) {
                                    break;
                                }
                                i3 = i9;
                                int i10 = length + 1;
                                if (barChartRenderer.f68749a.D(barBuffer.f68280b[i10]) && barChartRenderer.f68749a.z(f13)) {
                                    if (iBarDataSet.I()) {
                                        String strB = valueFormatterP.b(barEntry3);
                                        float f14 = barBuffer.f68280b[i10] + (barEntry3.e() >= 0.0f ? f11 : f12);
                                        barEntry = barEntry3;
                                        f7 = f13;
                                        f3 = fE;
                                        transformer = transformer2;
                                        z2 = zB;
                                        fArr = fArrO;
                                        barChartRenderer.k(canvas, strB, f7, f14, iX);
                                    } else {
                                        f3 = fE;
                                        z2 = zB;
                                        transformer = transformer2;
                                        barEntry = barEntry3;
                                        fArr = fArrO;
                                        f7 = f13;
                                    }
                                    if (barEntry.d() == null || !iBarDataSet.c0()) {
                                        i4 = i8;
                                    } else {
                                        Drawable drawableD = barEntry.d();
                                        float f15 = barBuffer.f68280b[i10] + (barEntry.e() >= 0.0f ? f11 : f12);
                                        i4 = i8;
                                        Utils.f(canvas, drawableD, (int) (f7 + mPPointF.f68793c), (int) (f15 + mPPointF.f68794d), drawableD.getIntrinsicWidth(), drawableD.getIntrinsicHeight());
                                    }
                                } else {
                                    z2 = zB;
                                    i4 = i8;
                                    transformerA = transformer2;
                                    barChartRenderer = barChartRenderer;
                                    fE = fE;
                                    i9 = i3;
                                    i8 = i4;
                                    zB = z2;
                                }
                            } else {
                                i3 = i9;
                                BarEntry barEntry4 = barEntry3;
                                float f16 = f13;
                                z2 = zB;
                                i4 = i8;
                                int i11 = iX;
                                BarChartRenderer barChartRenderer2 = barChartRenderer;
                                fArr = fArrO;
                                f3 = fE;
                                transformer = transformerA;
                                int length2 = fArr.length * 2;
                                float[] fArr3 = new float[length2];
                                float f17 = -barEntry4.l();
                                float f18 = 0.0f;
                                int i12 = 0;
                                int i13 = 0;
                                while (i12 < length2) {
                                    float f19 = fArr[i13];
                                    if (f19 == 0.0f && (f18 == 0.0f || f17 == 0.0f)) {
                                        f6 = f17;
                                        f17 = f19;
                                    } else if (f19 >= 0.0f) {
                                        f18 += f19;
                                        f6 = f17;
                                        f17 = f18;
                                    } else {
                                        f6 = f17 - f19;
                                    }
                                    fArr3[i12 + 1] = f17 * fB;
                                    i12 += 2;
                                    i13++;
                                    f17 = f6;
                                }
                                transformer.k(fArr3);
                                int i14 = 0;
                                while (i14 < length2) {
                                    float f20 = fArr[i14 / 2];
                                    int i15 = length2;
                                    float f21 = fArr3[i14 + 1] + (((f20 > 0.0f ? 1 : (f20 == 0.0f ? 0 : -1)) == 0 && (f17 > 0.0f ? 1 : (f17 == 0.0f ? 0 : -1)) == 0 && (f18 > 0.0f ? 1 : (f18 == 0.0f ? 0 : -1)) > 0) || (f20 > 0.0f ? 1 : (f20 == 0.0f ? 0 : -1)) < 0 ? f12 : f11);
                                    float[] fArr4 = fArr3;
                                    if (!barChartRenderer2.f68749a.A(f16)) {
                                        break;
                                    }
                                    if (barChartRenderer2.f68749a.D(f21) && barChartRenderer2.f68749a.z(f16)) {
                                        if (iBarDataSet.I()) {
                                            BarEntry barEntry5 = barEntry4;
                                            String strC = valueFormatterP.c(f20, barEntry5);
                                            f5 = f21;
                                            BarChartRenderer barChartRenderer3 = barChartRenderer2;
                                            i5 = i14;
                                            barEntry4 = barEntry5;
                                            barChartRenderer3.k(canvas, strC, f16, f5, i11);
                                        } else {
                                            f5 = f21;
                                            i5 = i14;
                                        }
                                        f4 = f16;
                                        i6 = i11;
                                        if (barEntry4.d() != null && iBarDataSet.c0()) {
                                            Drawable drawableD2 = barEntry4.d();
                                            Utils.f(canvas, drawableD2, (int) (f4 + mPPointF.f68793c), (int) (mPPointF.f68794d + f5), drawableD2.getIntrinsicWidth(), drawableD2.getIntrinsicHeight());
                                        }
                                    } else {
                                        i5 = i14;
                                        f4 = f16;
                                        i6 = i11;
                                    }
                                    i14 = i5 + 2;
                                    barChartRenderer2 = this;
                                    fArr3 = fArr4;
                                    f16 = f4;
                                    length2 = i15;
                                    i11 = i6;
                                }
                            }
                            length = fArr == null ? length + 4 : length + (fArr.length * 4);
                            i9 = i3 + 1;
                            barChartRenderer = this;
                            transformerA = transformer;
                            fE = f3;
                            i8 = i4;
                            zB = z2;
                        }
                    } else {
                        int i16 = 0;
                        while (i16 < barBuffer.f68280b.length * barChartRenderer.f68695b.a()) {
                            float[] fArr5 = barBuffer.f68280b;
                            float f22 = (fArr5[i16] + fArr5[i16 + 2]) / 2.0f;
                            if (!barChartRenderer.f68749a.A(f22)) {
                                break;
                            }
                            int i17 = i16 + 1;
                            if (barChartRenderer.f68749a.D(barBuffer.f68280b[i17]) && barChartRenderer.f68749a.z(f22)) {
                                int i18 = i16 / 4;
                                BarEntry barEntry6 = (BarEntry) iBarDataSet.r(i18);
                                float fE2 = barEntry6.e();
                                if (iBarDataSet.I()) {
                                    MPPointF mPPointF3 = mPPointFD;
                                    String strB2 = valueFormatterP.b(barEntry6);
                                    float[] fArr6 = barBuffer.f68280b;
                                    float f23 = fE2 >= 0.0f ? fArr6[i17] + f11 : fArr6[i16 + 3] + f12;
                                    int iX2 = iBarDataSet.x(i18);
                                    list2 = listG;
                                    mPPointF2 = mPPointF3;
                                    barEntry2 = barEntry6;
                                    float f24 = f23;
                                    valueFormatter = valueFormatterP;
                                    barChartRenderer.k(canvas, strB2, f22, f24, iX2);
                                } else {
                                    valueFormatter = valueFormatterP;
                                    barEntry2 = barEntry6;
                                    list2 = listG;
                                    mPPointF2 = mPPointFD;
                                }
                                if (barEntry2.d() != null && iBarDataSet.c0()) {
                                    Drawable drawableD3 = barEntry2.d();
                                    Utils.f(canvas, drawableD3, (int) (f22 + mPPointF2.f68793c), (int) ((fE2 >= 0.0f ? barBuffer.f68280b[i17] + f11 : barBuffer.f68280b[i16 + 3] + f12) + mPPointF2.f68794d), drawableD3.getIntrinsicWidth(), drawableD3.getIntrinsicHeight());
                                }
                            } else {
                                valueFormatter = valueFormatterP;
                                list2 = listG;
                                mPPointF2 = mPPointFD;
                            }
                            i16 += 4;
                            mPPointFD = mPPointF2;
                            valueFormatterP = valueFormatter;
                            listG = list2;
                        }
                        list = listG;
                        mPPointF = mPPointFD;
                    }
                    f8 = fE;
                    z3 = zB;
                    i7 = i8;
                    MPPointF.f(mPPointF);
                } else {
                    list = listG;
                    f8 = fE;
                    z3 = zB;
                    i7 = i8;
                }
                i8 = i7 + 1;
                barChartRenderer = this;
                fE = f8;
                listG = list;
                zB = z3;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void f() {
        BarData barData = this.f68670h.getBarData();
        this.f68672j = new BarBuffer[barData.f()];
        for (int i3 = 0; i3 < this.f68672j.length; i3++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.e(i3);
            this.f68672j[i3] = new BarBuffer(iBarDataSet.J0() * 4 * (iBarDataSet.F0() ? iBarDataSet.A() : 1), barData.f(), iBarDataSet.F0());
        }
    }

    protected void j(Canvas canvas, IBarDataSet iBarDataSet, int i3) {
        Transformer transformerA = this.f68670h.a(iBarDataSet.K());
        this.f68674l.setColor(iBarDataSet.h());
        this.f68674l.setStrokeWidth(Utils.e(iBarDataSet.d0()));
        int i4 = 0;
        boolean z2 = iBarDataSet.d0() > 0.0f;
        float fA = this.f68695b.a();
        float fB = this.f68695b.b();
        if (this.f68670h.e()) {
            this.f68673k.setColor(iBarDataSet.s0());
            float fT = this.f68670h.getBarData().t() / 2.0f;
            int iMin = Math.min((int) Math.ceil(iBarDataSet.J0() * fA), iBarDataSet.J0());
            for (int i5 = 0; i5 < iMin; i5++) {
                float fH = ((BarEntry) iBarDataSet.r(i5)).h();
                RectF rectF = this.f68675m;
                rectF.left = fH - fT;
                rectF.right = fH + fT;
                transformerA.p(rectF);
                if (this.f68749a.z(this.f68675m.right)) {
                    if (!this.f68749a.A(this.f68675m.left)) {
                        break;
                    }
                    this.f68675m.top = this.f68749a.j();
                    this.f68675m.bottom = this.f68749a.f();
                    canvas.drawRect(this.f68675m, this.f68673k);
                }
            }
        }
        Canvas canvas2 = canvas;
        BarBuffer barBuffer = this.f68672j[i3];
        barBuffer.b(fA, fB);
        barBuffer.g(i3);
        barBuffer.h(this.f68670h.d(iBarDataSet.K()));
        barBuffer.f(this.f68670h.getBarData().t());
        barBuffer.e(iBarDataSet);
        transformerA.k(barBuffer.f68280b);
        boolean z3 = iBarDataSet.z().size() == 1;
        if (z3) {
            this.f68696c.setColor(iBarDataSet.M());
        }
        while (i4 < barBuffer.c()) {
            int i6 = i4 + 2;
            if (this.f68749a.z(barBuffer.f68280b[i6])) {
                if (!this.f68749a.A(barBuffer.f68280b[i4])) {
                    return;
                }
                if (!z3) {
                    this.f68696c.setColor(iBarDataSet.p0(i4 / 4));
                }
                if (iBarDataSet.f0() != null) {
                    GradientColor gradientColorF0 = iBarDataSet.f0();
                    Paint paint = this.f68696c;
                    float[] fArr = barBuffer.f68280b;
                    float f3 = fArr[i4];
                    paint.setShader(new LinearGradient(f3, fArr[i4 + 3], f3, fArr[i4 + 1], gradientColorF0.b(), gradientColorF0.a(), Shader.TileMode.MIRROR));
                }
                if (iBarDataSet.F() != null) {
                    Paint paint2 = this.f68696c;
                    float[] fArr2 = barBuffer.f68280b;
                    float f4 = fArr2[i4];
                    float f5 = fArr2[i4 + 3];
                    float f6 = fArr2[i4 + 1];
                    int i7 = i4 / 4;
                    paint2.setShader(new LinearGradient(f4, f5, f4, f6, iBarDataSet.O0(i7).b(), iBarDataSet.O0(i7).a(), Shader.TileMode.MIRROR));
                }
                float[] fArr3 = barBuffer.f68280b;
                int i8 = i4 + 1;
                int i9 = i4 + 3;
                canvas2.drawRect(fArr3[i4], fArr3[i8], fArr3[i6], fArr3[i9], this.f68696c);
                if (z2) {
                    float[] fArr4 = barBuffer.f68280b;
                    canvas.drawRect(fArr4[i4], fArr4[i8], fArr4[i6], fArr4[i9], this.f68674l);
                }
            }
            i4 += 4;
            canvas2 = canvas;
        }
    }

    public void k(Canvas canvas, String str, float f3, float f4, int i3) {
        this.f68699f.setColor(i3);
        canvas.drawText(str, f3, f4, this.f68699f);
    }

    protected void l(float f3, float f4, float f5, float f6, Transformer transformer) {
        this.f68671i.set(f3 - f6, f4, f3 + f6, f5);
        transformer.n(this.f68671i, this.f68695b.b());
    }

    protected void m(Highlight highlight, RectF rectF) {
        highlight.m(rectF.centerX(), rectF.top);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void c(Canvas canvas) {
    }
}
