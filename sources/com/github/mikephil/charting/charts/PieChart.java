package com.github.mikephil.charting.charts;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.PieHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.PieChartRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PieChart extends PieRadarChartBase<PieData> {
    private RectF L;
    private boolean M;
    private float[] N;
    private float[] O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private CharSequence T;
    private MPPointF U;
    private float V;
    protected float W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private boolean f68358a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private float f68359b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    protected float f68360c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private float f68361d0;

    private float E(float f3, float f4) {
        return (f3 / f4) * this.f68360c0;
    }

    private void F() {
        float f3;
        int iH = ((PieData) this.f68321b).h();
        float f4 = 0.0f;
        if (this.N.length != iH) {
            this.N = new float[iH];
        } else {
            for (int i3 = 0; i3 < iH; i3++) {
                this.N[i3] = 0.0f;
            }
        }
        if (this.O.length != iH) {
            this.O = new float[iH];
        } else {
            for (int i4 = 0; i4 < iH; i4++) {
                this.O[i4] = 0.0f;
            }
        }
        float fV = ((PieData) this.f68321b).v();
        List listG = ((PieData) this.f68321b).g();
        float f5 = this.f68361d0;
        boolean z2 = f5 != 0.0f && ((float) iH) * f5 <= this.f68360c0;
        float[] fArr = new float[iH];
        float f6 = 0.0f;
        float f7 = 0.0f;
        int i5 = 0;
        for (int i6 = 0; i6 < ((PieData) this.f68321b).f(); i6++) {
            IPieDataSet iPieDataSet = (IPieDataSet) listG.get(i6);
            int i7 = 0;
            while (i7 < iPieDataSet.J0()) {
                float fE = E(Math.abs(((PieEntry) iPieDataSet.r(i7)).e()), fV);
                if (z2) {
                    float f8 = this.f68361d0;
                    f3 = f4;
                    float f9 = fE - f8;
                    if (f9 <= f3) {
                        fArr[i5] = f8;
                        f6 += -f9;
                    } else {
                        fArr[i5] = fE;
                        f7 += f9;
                    }
                } else {
                    f3 = f4;
                }
                this.N[i5] = fE;
                if (i5 == 0) {
                    this.O[i5] = fE;
                } else {
                    float[] fArr2 = this.O;
                    fArr2[i5] = fArr2[i5 - 1] + fE;
                }
                i5++;
                i7++;
                f4 = f3;
            }
        }
        if (z2) {
            for (int i8 = 0; i8 < iH; i8++) {
                float f10 = fArr[i8];
                float f11 = f10 - (((f10 - this.f68361d0) / f7) * f6);
                fArr[i8] = f11;
                if (i8 == 0) {
                    this.O[0] = fArr[0];
                } else {
                    float[] fArr3 = this.O;
                    fArr3[i8] = fArr3[i8 - 1] + f11;
                }
            }
            this.N = fArr;
        }
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public int A(float f3) {
        float fQ = Utils.q(f3 - getRotationAngle());
        int i3 = 0;
        while (true) {
            float[] fArr = this.O;
            if (i3 >= fArr.length) {
                return -1;
            }
            if (fArr[i3] > fQ) {
                return i3;
            }
            i3++;
        }
    }

    public boolean G() {
        return this.f68358a0;
    }

    public boolean H() {
        return this.M;
    }

    public boolean I() {
        return this.P;
    }

    public boolean J() {
        return this.S;
    }

    public boolean K() {
        return this.Q;
    }

    public boolean L() {
        return this.R;
    }

    public boolean M(int i3) {
        if (!w()) {
            return false;
        }
        int i4 = 0;
        while (true) {
            Highlight[] highlightArr = this.B;
            if (i4 >= highlightArr.length) {
                return false;
            }
            if (((int) highlightArr[i4].h()) == i3) {
                return true;
            }
            i4++;
        }
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void f() {
        super.f();
        if (this.f68321b == null) {
            return;
        }
        float diameter = getDiameter() / 2.0f;
        MPPointF centerOffsets = getCenterOffsets();
        float fG = ((PieData) this.f68321b).t().G();
        RectF rectF = this.L;
        float f3 = centerOffsets.f68793c;
        float f4 = centerOffsets.f68794d;
        rectF.set((f3 - diameter) + fG, (f4 - diameter) + fG, (f3 + diameter) - fG, (f4 + diameter) - fG);
        MPPointF.f(centerOffsets);
    }

    public float[] getAbsoluteAngles() {
        return this.O;
    }

    public MPPointF getCenterCircleBox() {
        return MPPointF.c(this.L.centerX(), this.L.centerY());
    }

    public CharSequence getCenterText() {
        return this.T;
    }

    public MPPointF getCenterTextOffset() {
        MPPointF mPPointF = this.U;
        return MPPointF.c(mPPointF.f68793c, mPPointF.f68794d);
    }

    public float getCenterTextRadiusPercent() {
        return this.f68359b0;
    }

    public RectF getCircleBox() {
        return this.L;
    }

    public float[] getDrawAngles() {
        return this.N;
    }

    public float getHoleRadius() {
        return this.V;
    }

    public float getMaxAngle() {
        return this.f68360c0;
    }

    public float getMinAngleForSlices() {
        return this.f68361d0;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRadius() {
        RectF rectF = this.L;
        if (rectF == null) {
            return 0.0f;
        }
        return Math.min(rectF.width() / 2.0f, this.L.height() / 2.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredBaseOffset() {
        return 0.0f;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredLegendOffset() {
        return this.f68336r.d().getTextSize() * 2.0f;
    }

    public float getTransparentCircleRadius() {
        return this.W;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    @Deprecated
    public XAxis getXAxis() {
        throw new RuntimeException("PieChart has no XAxis");
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected float[] l(Highlight highlight) {
        MPPointF centerCircleBox = getCenterCircleBox();
        float radius = getRadius();
        float holeRadius = (radius / 10.0f) * 3.6f;
        if (I()) {
            holeRadius = (radius - ((radius / 100.0f) * getHoleRadius())) / 2.0f;
        }
        float f3 = radius - holeRadius;
        float rotationAngle = getRotationAngle();
        float f4 = this.N[(int) highlight.h()] / 2.0f;
        double d3 = f3;
        float fCos = (float) ((Math.cos(Math.toRadians(((this.O[r11] + rotationAngle) - f4) * this.f68340v.b())) * d3) + ((double) centerCircleBox.f68793c));
        float fSin = (float) ((d3 * Math.sin(Math.toRadians(((rotationAngle + this.O[r11]) - f4) * this.f68340v.b()))) + ((double) centerCircleBox.f68794d));
        MPPointF.f(centerCircleBox);
        return new float[]{fCos, fSin};
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    protected void n() {
        super.n();
        this.f68337s = new PieChartRenderer(this, this.f68340v, this.f68339u);
        this.f68328j = null;
        this.f68338t = new PieHighlighter(this);
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        DataRenderer dataRenderer = this.f68337s;
        if (dataRenderer != null && (dataRenderer instanceof PieChartRenderer)) {
            ((PieChartRenderer) dataRenderer).s();
        }
        super.onDetachedFromWindow();
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f68321b == null) {
            return;
        }
        this.f68337s.b(canvas);
        if (w()) {
            this.f68337s.d(canvas, this.B);
        }
        this.f68337s.c(canvas);
        this.f68337s.e(canvas);
        this.f68336r.e(canvas);
        h(canvas);
        i(canvas);
    }

    public void setCenterText(CharSequence charSequence) {
        if (charSequence == null) {
            this.T = "";
        } else {
            this.T = charSequence;
        }
    }

    public void setCenterTextColor(int i3) {
        ((PieChartRenderer) this.f68337s).n().setColor(i3);
    }

    public void setCenterTextRadiusPercent(float f3) {
        this.f68359b0 = f3;
    }

    public void setCenterTextSize(float f3) {
        ((PieChartRenderer) this.f68337s).n().setTextSize(Utils.e(f3));
    }

    public void setCenterTextSizePixels(float f3) {
        ((PieChartRenderer) this.f68337s).n().setTextSize(f3);
    }

    public void setCenterTextTypeface(Typeface typeface) {
        ((PieChartRenderer) this.f68337s).n().setTypeface(typeface);
    }

    public void setDrawCenterText(boolean z2) {
        this.f68358a0 = z2;
    }

    public void setDrawEntryLabels(boolean z2) {
        this.M = z2;
    }

    public void setDrawHoleEnabled(boolean z2) {
        this.P = z2;
    }

    public void setDrawRoundedSlices(boolean z2) {
        this.S = z2;
    }

    @Deprecated
    public void setDrawSliceText(boolean z2) {
        this.M = z2;
    }

    public void setDrawSlicesUnderHole(boolean z2) {
        this.Q = z2;
    }

    public void setEntryLabelColor(int i3) {
        ((PieChartRenderer) this.f68337s).o().setColor(i3);
    }

    public void setEntryLabelTextSize(float f3) {
        ((PieChartRenderer) this.f68337s).o().setTextSize(Utils.e(f3));
    }

    public void setEntryLabelTypeface(Typeface typeface) {
        ((PieChartRenderer) this.f68337s).o().setTypeface(typeface);
    }

    public void setHoleColor(int i3) {
        ((PieChartRenderer) this.f68337s).p().setColor(i3);
    }

    public void setHoleRadius(float f3) {
        this.V = f3;
    }

    public void setMaxAngle(float f3) {
        if (f3 > 360.0f) {
            f3 = 360.0f;
        }
        if (f3 < 90.0f) {
            f3 = 90.0f;
        }
        this.f68360c0 = f3;
    }

    public void setMinAngleForSlices(float f3) {
        float f4 = this.f68360c0;
        if (f3 > f4 / 2.0f) {
            f3 = f4 / 2.0f;
        } else if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        this.f68361d0 = f3;
    }

    public void setTransparentCircleAlpha(int i3) {
        ((PieChartRenderer) this.f68337s).q().setAlpha(i3);
    }

    public void setTransparentCircleColor(int i3) {
        Paint paintQ = ((PieChartRenderer) this.f68337s).q();
        int alpha = paintQ.getAlpha();
        paintQ.setColor(i3);
        paintQ.setAlpha(alpha);
    }

    public void setTransparentCircleRadius(float f3) {
        this.W = f3;
    }

    public void setUsePercentValues(boolean z2) {
        this.R = z2;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected void x() {
        F();
    }
}
