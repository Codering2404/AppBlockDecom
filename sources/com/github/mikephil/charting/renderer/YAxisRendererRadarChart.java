package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Path;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class YAxisRendererRadarChart extends YAxisRenderer {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private RadarChart f68776r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Path f68777s;

    public YAxisRendererRadarChart(ViewPortHandler viewPortHandler, YAxis yAxis, RadarChart radarChart) {
        super(viewPortHandler, yAxis, null);
        this.f68777s = new Path();
        this.f68776r = radarChart;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    protected void b(float f3, float f4) {
        ?? r3;
        float f5 = f3;
        int iU = this.f68664b.u();
        double dAbs = Math.abs(f4 - f5);
        if (iU == 0 || dAbs <= 0.0d || Double.isInfinite(dAbs)) {
            AxisBase axisBase = this.f68664b;
            axisBase.f68380l = new float[0];
            axisBase.f68381m = new float[0];
            axisBase.f68382n = 0;
            return;
        }
        double dY = Utils.y(dAbs / ((double) iU));
        if (this.f68664b.F() && dY < this.f68664b.q()) {
            dY = this.f68664b.q();
        }
        double dY2 = Utils.y(Math.pow(10.0d, (int) Math.log10(dY)));
        if (((int) (dY / dY2)) > 5) {
            dY = Math.floor(dY2 * 10.0d);
        }
        boolean zY = this.f68664b.y();
        if (this.f68664b.E()) {
            float f6 = ((float) dAbs) / (iU - 1);
            AxisBase axisBase2 = this.f68664b;
            axisBase2.f68382n = iU;
            if (axisBase2.f68380l.length < iU) {
                axisBase2.f68380l = new float[iU];
            }
            for (int i3 = 0; i3 < iU; i3++) {
                this.f68664b.f68380l[i3] = f5;
                f5 += f6;
            }
        } else {
            double dCeil = dY == 0.0d ? 0.0d : Math.ceil(((double) f5) / dY) * dY;
            if (zY) {
                dCeil -= dY;
            }
            double dW = dY == 0.0d ? 0.0d : Utils.w(Math.floor(((double) f4) / dY) * dY);
            if (dY != 0.0d) {
                double d3 = dCeil;
                r3 = zY;
                while (d3 <= dW) {
                    d3 += dY;
                    r3 = (r3 == true ? 1 : 0) + 1;
                }
            } else {
                r3 = zY;
            }
            iU = r3 + 1;
            AxisBase axisBase3 = this.f68664b;
            axisBase3.f68382n = iU;
            if (axisBase3.f68380l.length < iU) {
                axisBase3.f68380l = new float[iU];
            }
            for (int i4 = 0; i4 < iU; i4++) {
                if (dCeil == 0.0d) {
                    dCeil = 0.0d;
                }
                this.f68664b.f68380l[i4] = (float) dCeil;
                dCeil += dY;
            }
        }
        if (dY < 1.0d) {
            this.f68664b.f68383o = (int) Math.ceil(-Math.log10(dY));
        } else {
            this.f68664b.f68383o = 0;
        }
        if (zY) {
            AxisBase axisBase4 = this.f68664b;
            if (axisBase4.f68381m.length < iU) {
                axisBase4.f68381m = new float[iU];
            }
            float[] fArr = axisBase4.f68380l;
            float f7 = (fArr[1] - fArr[0]) / 2.0f;
            for (int i5 = 0; i5 < iU; i5++) {
                AxisBase axisBase5 = this.f68664b;
                axisBase5.f68381m[i5] = axisBase5.f68380l[i5] + f7;
            }
        }
        AxisBase axisBase6 = this.f68664b;
        float[] fArr2 = axisBase6.f68380l;
        float f8 = fArr2[0];
        axisBase6.H = f8;
        float f9 = fArr2[iU - 1];
        axisBase6.G = f9;
        axisBase6.I = Math.abs(f9 - f8);
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public void i(Canvas canvas) {
        if (this.f68763h.f() && this.f68763h.C()) {
            this.f68667e.setTypeface(this.f68763h.c());
            this.f68667e.setTextSize(this.f68763h.b());
            this.f68667e.setColor(this.f68763h.a());
            MPPointF centerOffsets = this.f68776r.getCenterOffsets();
            MPPointF mPPointFC = MPPointF.c(0.0f, 0.0f);
            float factor = this.f68776r.getFactor();
            int i3 = this.f68763h.g0() ? this.f68763h.f68382n : this.f68763h.f68382n - 1;
            for (int i4 = !this.f68763h.f0() ? 1 : 0; i4 < i3; i4++) {
                YAxis yAxis = this.f68763h;
                Utils.r(centerOffsets, (yAxis.f68380l[i4] - yAxis.H) * factor, this.f68776r.getRotationAngle(), mPPointFC);
                canvas.drawText(this.f68763h.p(i4), mPPointFC.f68793c + 10.0f, mPPointFC.f68794d, this.f68667e);
            }
            MPPointF.f(centerOffsets);
            MPPointF.f(mPPointFC);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public void l(Canvas canvas) {
        List listV = this.f68763h.v();
        if (listV == null) {
            return;
        }
        float sliceAngle = this.f68776r.getSliceAngle();
        float factor = this.f68776r.getFactor();
        MPPointF centerOffsets = this.f68776r.getCenterOffsets();
        MPPointF mPPointFC = MPPointF.c(0.0f, 0.0f);
        for (int i3 = 0; i3 < listV.size(); i3++) {
            LimitLine limitLine = (LimitLine) listV.get(i3);
            if (limitLine.f()) {
                this.f68669g.setColor(limitLine.p());
                this.f68669g.setPathEffect(limitLine.l());
                this.f68669g.setStrokeWidth(limitLine.q());
                float fO = (limitLine.o() - this.f68776r.getYChartMin()) * factor;
                Path path = this.f68777s;
                path.reset();
                for (int i4 = 0; i4 < ((IRadarDataSet) ((RadarData) this.f68776r.getData()).l()).J0(); i4++) {
                    Utils.r(centerOffsets, fO, (i4 * sliceAngle) + this.f68776r.getRotationAngle(), mPPointFC);
                    if (i4 == 0) {
                        path.moveTo(mPPointFC.f68793c, mPPointFC.f68794d);
                    } else {
                        path.lineTo(mPPointFC.f68793c, mPPointFC.f68794d);
                    }
                }
                path.close();
                canvas.drawPath(path, this.f68669g);
            }
        }
        MPPointF.f(centerOffsets);
        MPPointF.f(mPPointFC);
    }
}
