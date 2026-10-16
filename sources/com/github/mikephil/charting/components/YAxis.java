package com.github.mikephil.charting.components;

import android.graphics.Paint;
import com.github.mikephil.charting.utils.Utils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class YAxis extends AxisBase {
    private AxisDependency U;
    private boolean J = true;
    private boolean K = true;
    protected boolean L = false;
    protected boolean M = false;
    private boolean N = false;
    private boolean O = false;
    protected int P = -7829368;
    protected float Q = 1.0f;
    protected float R = 10.0f;
    protected float S = 10.0f;
    private YAxisLabelPosition T = YAxisLabelPosition.OUTSIDE_CHART;
    protected float V = 0.0f;
    protected float W = Float.POSITIVE_INFINITY;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum AxisDependency {
        LEFT,
        RIGHT
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum YAxisLabelPosition {
        OUTSIDE_CHART,
        INSIDE_CHART
    }

    public YAxis(AxisDependency axisDependency) {
        this.U = axisDependency;
        this.f68397c = 0.0f;
    }

    public AxisDependency V() {
        return this.U;
    }

    public YAxisLabelPosition W() {
        return this.T;
    }

    public float X() {
        return this.W;
    }

    public float Y() {
        return this.V;
    }

    public float Z(Paint paint) {
        paint.setTextSize(this.f68399e);
        return Utils.a(paint, w()) + (e() * 2.0f);
    }

    public float a0(Paint paint) {
        paint.setTextSize(this.f68399e);
        float fD = Utils.d(paint, w()) + (d() * 2.0f);
        float fY = Y();
        float fX = X();
        if (fY > 0.0f) {
            fY = Utils.e(fY);
        }
        if (fX > 0.0f && fX != Float.POSITIVE_INFINITY) {
            fX = Utils.e(fX);
        }
        if (fX <= 0.0d) {
            fX = fD;
        }
        return Math.max(fY, Math.min(fD, fX));
    }

    public float b0() {
        return this.S;
    }

    public float c0() {
        return this.R;
    }

    public int d0() {
        return this.P;
    }

    public float e0() {
        return this.Q;
    }

    public boolean f0() {
        return this.J;
    }

    public boolean g0() {
        return this.K;
    }

    public boolean h0() {
        return this.M;
    }

    public boolean i0() {
        return this.L;
    }

    public boolean j0() {
        return f() && C() && W() == YAxisLabelPosition.OUTSIDE_CHART;
    }

    public void k0(boolean z2) {
        this.K = z2;
    }

    @Override // com.github.mikephil.charting.components.AxisBase
    public void l(float f3, float f4) {
        if (Math.abs(f4 - f3) == 0.0f) {
            f4 += 1.0f;
            f3 -= 1.0f;
        }
        float fAbs = Math.abs(f4 - f3);
        this.H = this.E ? this.H : f3 - ((fAbs / 100.0f) * b0());
        float fC0 = this.F ? this.G : f4 + ((fAbs / 100.0f) * c0());
        this.G = fC0;
        this.I = Math.abs(this.H - fC0);
    }

    public void l0(boolean z2) {
        this.M = z2;
    }
}
