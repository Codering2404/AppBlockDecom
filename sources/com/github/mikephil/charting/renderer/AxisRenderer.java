package com.github.mikephil.charting.renderer;

import android.graphics.Paint;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AxisRenderer extends Renderer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected AxisBase f68664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Transformer f68665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Paint f68666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected Paint f68667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Paint f68668f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected Paint f68669g;

    public AxisRenderer(ViewPortHandler viewPortHandler, Transformer transformer, AxisBase axisBase) {
        super(viewPortHandler);
        this.f68665c = transformer;
        this.f68664b = axisBase;
        if (this.f68749a != null) {
            this.f68667e = new Paint(1);
            Paint paint = new Paint();
            this.f68666d = paint;
            paint.setColor(-7829368);
            this.f68666d.setStrokeWidth(1.0f);
            Paint paint2 = this.f68666d;
            Paint.Style style = Paint.Style.STROKE;
            paint2.setStyle(style);
            this.f68666d.setAlpha(90);
            Paint paint3 = new Paint();
            this.f68668f = paint3;
            paint3.setColor(-16777216);
            this.f68668f.setStrokeWidth(1.0f);
            this.f68668f.setStyle(style);
            Paint paint4 = new Paint(1);
            this.f68669g = paint4;
            paint4.setStyle(style);
        }
    }

    public void a(float f3, float f4, boolean z2) {
        float f5;
        double d3;
        ViewPortHandler viewPortHandler = this.f68749a;
        if (viewPortHandler != null && viewPortHandler.k() > 10.0f && !this.f68749a.w()) {
            MPPointD mPPointDG = this.f68665c.g(this.f68749a.h(), this.f68749a.j());
            MPPointD mPPointDG2 = this.f68665c.g(this.f68749a.h(), this.f68749a.f());
            if (z2) {
                f5 = (float) mPPointDG.f68790d;
                d3 = mPPointDG2.f68790d;
            } else {
                f5 = (float) mPPointDG2.f68790d;
                d3 = mPPointDG.f68790d;
            }
            float f6 = (float) d3;
            MPPointD.c(mPPointDG);
            MPPointD.c(mPPointDG2);
            f3 = f5;
            f4 = f6;
        }
        b(f3, f4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v5, types: [int] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7, types: [int] */
    /* JADX WARN: Type inference failed for: r7v9 */
    protected void b(float f3, float f4) {
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
        ?? Y = this.f68664b.y();
        if (this.f68664b.E()) {
            dY = ((float) dAbs) / (iU - 1);
            AxisBase axisBase2 = this.f68664b;
            axisBase2.f68382n = iU;
            if (axisBase2.f68380l.length < iU) {
                axisBase2.f68380l = new float[iU];
            }
            for (int i3 = 0; i3 < iU; i3++) {
                this.f68664b.f68380l[i3] = f5;
                f5 = (float) (((double) f5) + dY);
            }
        } else {
            double dCeil = dY == 0.0d ? 0.0d : Math.ceil(((double) f5) / dY) * dY;
            if (this.f68664b.y()) {
                dCeil -= dY;
            }
            double dW = dY == 0.0d ? 0.0d : Utils.w(Math.floor(((double) f4) / dY) * dY);
            if (dY != 0.0d) {
                double d3 = dCeil;
                Y = Y;
                while (d3 <= dW) {
                    d3 += dY;
                    Y++;
                }
            }
            iU = Y;
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
        if (this.f68664b.y()) {
            AxisBase axisBase4 = this.f68664b;
            if (axisBase4.f68381m.length < iU) {
                axisBase4.f68381m = new float[iU];
            }
            float f6 = ((float) dY) / 2.0f;
            for (int i5 = 0; i5 < iU; i5++) {
                AxisBase axisBase5 = this.f68664b;
                axisBase5.f68381m[i5] = axisBase5.f68380l[i5] + f6;
            }
        }
    }

    public Paint c() {
        return this.f68667e;
    }
}
