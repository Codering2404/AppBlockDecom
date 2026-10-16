package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PieChartRenderer extends DataRenderer {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected PieChart f68727g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected Paint f68728h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected Paint f68729i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected Paint f68730j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextPaint f68731k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Paint f68732l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private StaticLayout f68733m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private CharSequence f68734n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private RectF f68735o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private RectF[] f68736p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected WeakReference f68737q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected Canvas f68738r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Path f68739s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private RectF f68740t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Path f68741u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected Path f68742v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected RectF f68743w;

    public PieChartRenderer(PieChart pieChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f68735o = new RectF();
        this.f68736p = new RectF[]{new RectF(), new RectF(), new RectF()};
        this.f68739s = new Path();
        this.f68740t = new RectF();
        this.f68741u = new Path();
        this.f68742v = new Path();
        this.f68743w = new RectF();
        this.f68727g = pieChart;
        Paint paint = new Paint(1);
        this.f68728h = paint;
        paint.setColor(-1);
        Paint paint2 = this.f68728h;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        Paint paint3 = new Paint(1);
        this.f68729i = paint3;
        paint3.setColor(-1);
        this.f68729i.setStyle(style);
        this.f68729i.setAlpha(105);
        TextPaint textPaint = new TextPaint(1);
        this.f68731k = textPaint;
        textPaint.setColor(-16777216);
        this.f68731k.setTextSize(Utils.e(12.0f));
        this.f68699f.setTextSize(Utils.e(13.0f));
        this.f68699f.setColor(-1);
        Paint paint4 = this.f68699f;
        Paint.Align align = Paint.Align.CENTER;
        paint4.setTextAlign(align);
        Paint paint5 = new Paint(1);
        this.f68732l = paint5;
        paint5.setColor(-1);
        this.f68732l.setTextAlign(align);
        this.f68732l.setTextSize(Utils.e(13.0f));
        Paint paint6 = new Paint(1);
        this.f68730j = paint6;
        paint6.setStyle(Paint.Style.STROKE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void b(Canvas canvas) {
        int iM = (int) this.f68749a.m();
        int iL = (int) this.f68749a.l();
        WeakReference weakReference = this.f68737q;
        Bitmap bitmapCreateBitmap = weakReference == null ? null : (Bitmap) weakReference.get();
        if (bitmapCreateBitmap == null || bitmapCreateBitmap.getWidth() != iM || bitmapCreateBitmap.getHeight() != iL) {
            if (iM <= 0 || iL <= 0) {
                return;
            }
            bitmapCreateBitmap = Bitmap.createBitmap(iM, iL, Bitmap.Config.ARGB_4444);
            this.f68737q = new WeakReference(bitmapCreateBitmap);
            this.f68738r = new Canvas(bitmapCreateBitmap);
        }
        bitmapCreateBitmap.eraseColor(0);
        for (IPieDataSet iPieDataSet : ((PieData) this.f68727g.getData()).g()) {
            if (iPieDataSet.isVisible() && iPieDataSet.J0() > 0) {
                j(canvas, iPieDataSet);
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void c(Canvas canvas) {
        l(canvas);
        canvas.drawBitmap((Bitmap) this.f68737q.get(), 0.0f, 0.0f, (Paint) null);
        i(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void d(Canvas canvas, Highlight[] highlightArr) {
        IPieDataSet iPieDataSetE;
        int i3;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        RectF rectF;
        float fH;
        float f10;
        float fMax;
        Highlight[] highlightArr2 = highlightArr;
        boolean z2 = this.f68727g.I() && !this.f68727g.K();
        if (z2 && this.f68727g.J()) {
            return;
        }
        float fA = this.f68695b.a();
        float fB = this.f68695b.b();
        float rotationAngle = this.f68727g.getRotationAngle();
        float[] drawAngles = this.f68727g.getDrawAngles();
        float[] absoluteAngles = this.f68727g.getAbsoluteAngles();
        MPPointF centerCircleBox = this.f68727g.getCenterCircleBox();
        float radius = this.f68727g.getRadius();
        float f11 = 0.0f;
        float holeRadius = z2 ? (this.f68727g.getHoleRadius() / 100.0f) * radius : 0.0f;
        RectF rectF2 = this.f68743w;
        rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
        int i4 = 0;
        while (i4 < highlightArr2.length) {
            int iH = (int) highlightArr2[i4].h();
            float f12 = f11;
            if (iH < drawAngles.length && (iPieDataSetE = ((PieData) this.f68727g.getData()).e(highlightArr2[i4].d())) != null && iPieDataSetE.M0()) {
                int iJ0 = iPieDataSetE.J0();
                int i5 = 0;
                for (int i6 = 0; i6 < iJ0; i6++) {
                    if (Math.abs(((PieEntry) iPieDataSetE.r(i6)).e()) > Utils.f68819e) {
                        i5++;
                    }
                }
                float f13 = iH == 0 ? f12 : absoluteAngles[iH - 1] * fA;
                float fT = i5 <= 1 ? f12 : iPieDataSetE.T();
                float f14 = drawAngles[iH];
                float f15 = radius;
                float fG = iPieDataSetE.G();
                float f16 = holeRadius;
                float f17 = f15 + fG;
                i3 = i4;
                rectF2.set(this.f68727g.getCircleBox());
                float f18 = -fG;
                rectF2.inset(f18, f18);
                boolean z3 = fT > f12 && f14 <= 180.0f;
                this.f68696c.setColor(iPieDataSetE.p0(iH));
                float f19 = i5 == 1 ? f12 : fT / (f15 * 0.017453292f);
                float f20 = i5 == 1 ? f12 : fT / (f17 * 0.017453292f);
                float f21 = (((f19 / 2.0f) + f13) * fB) + rotationAngle;
                float f22 = (f14 - f19) * fB;
                float f23 = f22 < f12 ? f12 : f22;
                float f24 = (((f20 / 2.0f) + f13) * fB) + rotationAngle;
                float f25 = (f14 - f20) * fB;
                if (f25 < f12) {
                    f25 = f12;
                }
                this.f68739s.reset();
                if (f23 < 360.0f || f23 % 360.0f > Utils.f68819e) {
                    f3 = f23;
                    f4 = f13;
                    f5 = fT;
                    double d3 = f24 * 0.017453292f;
                    this.f68739s.moveTo(centerCircleBox.f68793c + (((float) Math.cos(d3)) * f17), centerCircleBox.f68794d + (((float) Math.sin(d3)) * f17));
                    this.f68739s.arcTo(rectF2, f24, f25);
                } else {
                    f3 = f23;
                    this.f68739s.addCircle(centerCircleBox.f68793c, centerCircleBox.f68794d, f17, Path.Direction.CW);
                    f4 = f13;
                    f5 = fT;
                }
                if (z3) {
                    double d4 = f21 * 0.017453292f;
                    float fCos = (((float) Math.cos(d4)) * f15) + centerCircleBox.f68793c;
                    float fSin = centerCircleBox.f68794d + (((float) Math.sin(d4)) * f15);
                    f7 = f15;
                    rectF = rectF2;
                    f6 = f12;
                    f8 = f16;
                    f9 = f21;
                    fH = h(centerCircleBox, f7, f14 * fB, fCos, fSin, f9, f3);
                } else {
                    f6 = f12;
                    f7 = f15;
                    f8 = f16;
                    f9 = f21;
                    rectF = rectF2;
                    fH = f6;
                }
                RectF rectF3 = this.f68740t;
                float f26 = centerCircleBox.f68793c;
                f12 = f6;
                float f27 = centerCircleBox.f68794d;
                f10 = f7;
                rectF3.set(f26 - f8, f27 - f8, f26 + f8, f27 + f8);
                if (z2 && (f8 > f12 || z3)) {
                    if (z3) {
                        if (fH < f12) {
                            fH = -fH;
                        }
                        fMax = Math.max(f8, fH);
                    } else {
                        fMax = f8;
                    }
                    float f28 = (i5 == 1 || fMax == f12) ? f12 : f5 / (fMax * 0.017453292f);
                    float f29 = ((f4 + (f28 / 2.0f)) * fB) + rotationAngle;
                    float f30 = (f14 - f28) * fB;
                    if (f30 < f12) {
                        f30 = f12;
                    }
                    float f31 = f29 + f30;
                    if (f23 < 360.0f || f3 % 360.0f > Utils.f68819e) {
                        double d5 = f31 * 0.017453292f;
                        this.f68739s.lineTo(centerCircleBox.f68793c + (((float) Math.cos(d5)) * fMax), centerCircleBox.f68794d + (fMax * ((float) Math.sin(d5))));
                        this.f68739s.arcTo(this.f68740t, f31, -f30);
                    } else {
                        this.f68739s.addCircle(centerCircleBox.f68793c, centerCircleBox.f68794d, fMax, Path.Direction.CCW);
                    }
                } else if (f3 % 360.0f > Utils.f68819e) {
                    if (z3) {
                        double d6 = (f9 + (f3 / 2.0f)) * 0.017453292f;
                        this.f68739s.lineTo(centerCircleBox.f68793c + (((float) Math.cos(d6)) * fH), centerCircleBox.f68794d + (fH * ((float) Math.sin(d6))));
                    } else {
                        this.f68739s.lineTo(centerCircleBox.f68793c, centerCircleBox.f68794d);
                    }
                }
                this.f68739s.close();
                this.f68738r.drawPath(this.f68739s, this.f68696c);
            } else {
                f10 = radius;
                f8 = holeRadius;
                rectF = rectF2;
                i3 = i4;
            }
            i4 = i3 + 1;
            f11 = f12;
            highlightArr2 = highlightArr;
            holeRadius = f8;
            rectF2 = rectF;
            radius = f10;
        }
        MPPointF.f(centerCircleBox);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x007e A[PHI: r3
      0x007e: PHI (r3v5 float) = (r3v4 float), (r3v42 float), (r3v42 float) binds: [B:3:0x0051, B:5:0x005e, B:7:0x0066] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e(android.graphics.Canvas r51) {
        /*
            Method dump skipped, instruction units count: 958
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.PieChartRenderer.e(android.graphics.Canvas):void");
    }

    protected float h(MPPointF mPPointF, float f3, float f4, float f5, float f6, float f7, float f8) {
        double d3 = (f7 + f8) * 0.017453292f;
        float fCos = mPPointF.f68793c + (((float) Math.cos(d3)) * f3);
        float fSin = mPPointF.f68794d + (((float) Math.sin(d3)) * f3);
        double d4 = (f7 + (f8 / 2.0f)) * 0.017453292f;
        return (float) (((double) (f3 - ((float) ((Math.sqrt(Math.pow(fCos - f5, 2.0d) + Math.pow(fSin - f6, 2.0d)) / 2.0d) * Math.tan(((180.0d - ((double) f4)) / 2.0d) * 0.017453292519943295d))))) - Math.sqrt(Math.pow((mPPointF.f68793c + (((float) Math.cos(d4)) * f3)) - ((fCos + f5) / 2.0f), 2.0d) + Math.pow((mPPointF.f68794d + (((float) Math.sin(d4)) * f3)) - ((fSin + f6) / 2.0f), 2.0d)));
    }

    protected void i(Canvas canvas) {
        CharSequence centerText = this.f68727g.getCenterText();
        if (!this.f68727g.G() || centerText == null) {
            return;
        }
        MPPointF centerCircleBox = this.f68727g.getCenterCircleBox();
        MPPointF centerTextOffset = this.f68727g.getCenterTextOffset();
        float f3 = centerCircleBox.f68793c + centerTextOffset.f68793c;
        float f4 = centerCircleBox.f68794d + centerTextOffset.f68794d;
        float radius = (!this.f68727g.I() || this.f68727g.K()) ? this.f68727g.getRadius() : this.f68727g.getRadius() * (this.f68727g.getHoleRadius() / 100.0f);
        RectF[] rectFArr = this.f68736p;
        RectF rectF = rectFArr[0];
        rectF.left = f3 - radius;
        rectF.top = f4 - radius;
        rectF.right = f3 + radius;
        rectF.bottom = f4 + radius;
        RectF rectF2 = rectFArr[1];
        rectF2.set(rectF);
        float centerTextRadiusPercent = this.f68727g.getCenterTextRadiusPercent() / 100.0f;
        if (centerTextRadiusPercent > 0.0d) {
            rectF2.inset((rectF2.width() - (rectF2.width() * centerTextRadiusPercent)) / 2.0f, (rectF2.height() - (rectF2.height() * centerTextRadiusPercent)) / 2.0f);
        }
        if (!centerText.equals(this.f68734n) || !rectF2.equals(this.f68735o)) {
            this.f68735o.set(rectF2);
            this.f68734n = centerText;
            this.f68733m = new StaticLayout(centerText, 0, centerText.length(), this.f68731k, (int) Math.max(Math.ceil(this.f68735o.width()), 1.0d), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        }
        float height = this.f68733m.getHeight();
        canvas.save();
        Path path = this.f68742v;
        path.reset();
        path.addOval(rectF, Path.Direction.CW);
        canvas.clipPath(path);
        canvas.translate(rectF2.left, rectF2.top + ((rectF2.height() - height) / 2.0f));
        this.f68733m.draw(canvas);
        canvas.restore();
        MPPointF.f(centerCircleBox);
        MPPointF.f(centerTextOffset);
    }

    protected void j(Canvas canvas, IPieDataSet iPieDataSet) {
        float f3;
        int i3;
        int i4;
        float f4;
        float f5;
        float f6;
        float f7;
        int i5;
        RectF rectF;
        float f8;
        float f9;
        int i6;
        float f10;
        float f11;
        int i7;
        int i8;
        float fMax;
        PieChartRenderer pieChartRenderer = this;
        IPieDataSet iPieDataSet2 = iPieDataSet;
        float rotationAngle = pieChartRenderer.f68727g.getRotationAngle();
        float fA = pieChartRenderer.f68695b.a();
        float fB = pieChartRenderer.f68695b.b();
        RectF circleBox = pieChartRenderer.f68727g.getCircleBox();
        int iJ0 = iPieDataSet2.J0();
        float[] drawAngles = pieChartRenderer.f68727g.getDrawAngles();
        MPPointF centerCircleBox = pieChartRenderer.f68727g.getCenterCircleBox();
        float radius = pieChartRenderer.f68727g.getRadius();
        boolean z2 = pieChartRenderer.f68727g.I() && !pieChartRenderer.f68727g.K();
        float holeRadius = z2 ? (pieChartRenderer.f68727g.getHoleRadius() / 100.0f) * radius : 0.0f;
        float holeRadius2 = (radius - ((pieChartRenderer.f68727g.getHoleRadius() * radius) / 100.0f)) / 2.0f;
        RectF rectF2 = new RectF();
        boolean z3 = z2 && pieChartRenderer.f68727g.J();
        int i9 = 0;
        for (int i10 = 0; i10 < iJ0; i10++) {
            if (Math.abs(((PieEntry) iPieDataSet2.r(i10)).e()) > Utils.f68819e) {
                i9++;
            }
        }
        float fR = i9 <= 1 ? 0.0f : pieChartRenderer.r(iPieDataSet2);
        float f12 = 0.0f;
        int i11 = 0;
        while (i11 < iJ0) {
            float f13 = drawAngles[i11];
            float fAbs = Math.abs(iPieDataSet2.r(i11).e());
            float f14 = Utils.f68819e;
            if (fAbs > f14 && (!pieChartRenderer.f68727g.M(i11) || z3)) {
                boolean z4 = fR > 0.0f && f13 <= 180.0f;
                f3 = holeRadius;
                pieChartRenderer.f68696c.setColor(iPieDataSet2.p0(i11));
                float f15 = i9 == 1 ? 0.0f : fR / (radius * 0.017453292f);
                float f16 = rotationAngle + ((f12 + (f15 / 2.0f)) * fB);
                float f17 = (f13 - f15) * fB;
                if (f17 < 0.0f) {
                    f17 = 0.0f;
                }
                i3 = i11;
                pieChartRenderer.f68739s.reset();
                if (z3) {
                    float f18 = radius - holeRadius2;
                    i4 = i9;
                    double d3 = f16 * 0.017453292f;
                    float fCos = centerCircleBox.f68793c + (((float) Math.cos(d3)) * f18);
                    float fSin = centerCircleBox.f68794d + (f18 * ((float) Math.sin(d3)));
                    f4 = rotationAngle;
                    rectF2.set(fCos - holeRadius2, fSin - holeRadius2, fCos + holeRadius2, fSin + holeRadius2);
                } else {
                    i4 = i9;
                    f4 = rotationAngle;
                }
                double d4 = f16 * 0.017453292f;
                float fCos2 = (((float) Math.cos(d4)) * radius) + centerCircleBox.f68793c;
                float fSin2 = centerCircleBox.f68794d + (((float) Math.sin(d4)) * radius);
                int i12 = (f17 > 360.0f ? 1 : (f17 == 360.0f ? 0 : -1));
                if (i12 < 0 || f17 % 360.0f > f14) {
                    f5 = fCos2;
                    f6 = fSin2;
                    f7 = 360.0f;
                    i5 = i12;
                    if (z3) {
                        pieChartRenderer.f68739s.arcTo(rectF2, f16 + 180.0f, -180.0f);
                    }
                    pieChartRenderer.f68739s.arcTo(circleBox, f16, f17);
                } else {
                    f7 = 360.0f;
                    f5 = fCos2;
                    f6 = fSin2;
                    i5 = i12;
                    pieChartRenderer.f68739s.addCircle(centerCircleBox.f68793c, centerCircleBox.f68794d, radius, Path.Direction.CW);
                }
                RectF rectF3 = pieChartRenderer.f68740t;
                float f19 = centerCircleBox.f68793c;
                float f20 = centerCircleBox.f68794d;
                rectF3.set(f19 - f3, f20 - f3, f19 + f3, f20 + f3);
                if (!z2 || (f3 <= 0.0f && !z4)) {
                    pieChartRenderer = this;
                    rectF = rectF2;
                    float f21 = f17;
                    f8 = fA;
                    f9 = fB;
                    i6 = i4;
                    float f22 = f5;
                    float f23 = f6;
                    if (f21 % f7 > f14) {
                        if (z4) {
                            float fH = pieChartRenderer.h(centerCircleBox, radius, f13 * f9, f22, f23, f16, f21);
                            double d5 = (f16 + (f21 / 2.0f)) * 0.017453292f;
                            pieChartRenderer.f68739s.lineTo(centerCircleBox.f68793c + (((float) Math.cos(d5)) * fH), centerCircleBox.f68794d + (fH * ((float) Math.sin(d5))));
                        } else {
                            pieChartRenderer.f68739s.lineTo(centerCircleBox.f68793c, centerCircleBox.f68794d);
                        }
                    }
                } else {
                    if (z4) {
                        rectF = rectF2;
                        f10 = f17;
                        f8 = fA;
                        f11 = f3;
                        i7 = i4;
                        i8 = 1;
                        pieChartRenderer = this;
                        float fH2 = pieChartRenderer.h(centerCircleBox, radius, f13 * fB, f5, f6, f16, f10);
                        if (fH2 < 0.0f) {
                            fH2 = -fH2;
                        }
                        fMax = Math.max(f11, fH2);
                    } else {
                        pieChartRenderer = this;
                        rectF = rectF2;
                        f10 = f17;
                        f8 = fA;
                        f11 = f3;
                        i7 = i4;
                        i8 = 1;
                        fMax = f11;
                    }
                    float f24 = (i7 == i8 || fMax == 0.0f) ? 0.0f : fR / (fMax * 0.017453292f);
                    float f25 = f4 + ((f12 + (f24 / 2.0f)) * fB);
                    float f26 = (f13 - f24) * fB;
                    if (f26 < 0.0f) {
                        f26 = 0.0f;
                    }
                    float f27 = f25 + f26;
                    if (i5 < 0 || f10 % f7 > f14) {
                        if (z3) {
                            float f28 = radius - holeRadius2;
                            f9 = fB;
                            double d6 = f27 * 0.017453292f;
                            float fCos3 = centerCircleBox.f68793c + (f28 * ((float) Math.cos(d6)));
                            float fSin3 = centerCircleBox.f68794d + (((float) Math.sin(d6)) * f28);
                            rectF.set(fCos3 - holeRadius2, fSin3 - holeRadius2, fCos3 + holeRadius2, fSin3 + holeRadius2);
                            pieChartRenderer.f68739s.arcTo(rectF, f27, 180.0f);
                            f3 = f11;
                        } else {
                            f9 = fB;
                            double d7 = f27 * 0.017453292f;
                            f3 = f11;
                            pieChartRenderer.f68739s.lineTo(centerCircleBox.f68793c + (((float) Math.cos(d7)) * fMax), centerCircleBox.f68794d + (fMax * ((float) Math.sin(d7))));
                        }
                        pieChartRenderer.f68739s.arcTo(pieChartRenderer.f68740t, f27, -f26);
                    } else {
                        pieChartRenderer.f68739s.addCircle(centerCircleBox.f68793c, centerCircleBox.f68794d, fMax, Path.Direction.CCW);
                        f3 = f11;
                        f9 = fB;
                    }
                    i6 = i7;
                }
                pieChartRenderer.f68739s.close();
                pieChartRenderer.f68738r.drawPath(pieChartRenderer.f68739s, pieChartRenderer.f68696c);
                f12 += f13 * f8;
            } else {
                f12 += f13 * fA;
                f3 = holeRadius;
                i3 = i11;
                i6 = i9;
                f4 = rotationAngle;
                f8 = fA;
                f9 = fB;
                rectF = rectF2;
            }
            i11 = i3 + 1;
            i9 = i6;
            rectF2 = rectF;
            fA = f8;
            holeRadius = f3;
            fB = f9;
            rotationAngle = f4;
            iPieDataSet2 = iPieDataSet;
        }
        MPPointF.f(centerCircleBox);
    }

    protected void k(Canvas canvas, String str, float f3, float f4) {
        canvas.drawText(str, f3, f4, this.f68732l);
    }

    protected void l(Canvas canvas) {
        if (!this.f68727g.I() || this.f68738r == null) {
            return;
        }
        float radius = this.f68727g.getRadius();
        float holeRadius = (this.f68727g.getHoleRadius() / 100.0f) * radius;
        MPPointF centerCircleBox = this.f68727g.getCenterCircleBox();
        if (Color.alpha(this.f68728h.getColor()) > 0) {
            this.f68738r.drawCircle(centerCircleBox.f68793c, centerCircleBox.f68794d, holeRadius, this.f68728h);
        }
        if (Color.alpha(this.f68729i.getColor()) > 0 && this.f68727g.getTransparentCircleRadius() > this.f68727g.getHoleRadius()) {
            int alpha = this.f68729i.getAlpha();
            float transparentCircleRadius = radius * (this.f68727g.getTransparentCircleRadius() / 100.0f);
            this.f68729i.setAlpha((int) (alpha * this.f68695b.a() * this.f68695b.b()));
            this.f68741u.reset();
            this.f68741u.addCircle(centerCircleBox.f68793c, centerCircleBox.f68794d, transparentCircleRadius, Path.Direction.CW);
            this.f68741u.addCircle(centerCircleBox.f68793c, centerCircleBox.f68794d, holeRadius, Path.Direction.CCW);
            this.f68738r.drawPath(this.f68741u, this.f68729i);
            this.f68729i.setAlpha(alpha);
        }
        MPPointF.f(centerCircleBox);
    }

    public void m(Canvas canvas, String str, float f3, float f4, int i3) {
        this.f68699f.setColor(i3);
        canvas.drawText(str, f3, f4, this.f68699f);
    }

    public TextPaint n() {
        return this.f68731k;
    }

    public Paint o() {
        return this.f68732l;
    }

    public Paint p() {
        return this.f68728h;
    }

    public Paint q() {
        return this.f68729i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected float r(IPieDataSet iPieDataSet) {
        if (!iPieDataSet.q()) {
            return iPieDataSet.T();
        }
        if (iPieDataSet.T() / this.f68749a.s() > (iPieDataSet.l() / ((PieData) this.f68727g.getData()).v()) * 2.0f) {
            return 0.0f;
        }
        return iPieDataSet.T();
    }

    public void s() {
        Canvas canvas = this.f68738r;
        if (canvas != null) {
            canvas.setBitmap(null);
            this.f68738r = null;
        }
        WeakReference weakReference = this.f68737q;
        if (weakReference != null) {
            Bitmap bitmap = (Bitmap) weakReference.get();
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.f68737q.clear();
            this.f68737q = null;
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void f() {
    }
}
