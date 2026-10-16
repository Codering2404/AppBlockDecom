package com.github.mikephil.charting.jobs;

import android.graphics.Matrix;
import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ZoomJob extends ViewPortJob {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static ObjectPool f68612n;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected float f68613j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected float f68614k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected YAxis.AxisDependency f68615l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected Matrix f68616m;

    static {
        ObjectPool objectPoolA = ObjectPool.a(1, new ZoomJob(null, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null));
        f68612n = objectPoolA;
        objectPoolA.g(0.5f);
    }

    public ZoomJob(ViewPortHandler viewPortHandler, float f3, float f4, float f5, float f6, Transformer transformer, YAxis.AxisDependency axisDependency, View view) {
        super(viewPortHandler, f5, f6, transformer, view);
        this.f68616m = new Matrix();
        this.f68613j = f3;
        this.f68614k = f4;
        this.f68615l = axisDependency;
    }

    public static void b(ZoomJob zoomJob) {
        f68612n.c(zoomJob);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable a() {
        return new ZoomJob(null, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null);
    }

    @Override // java.lang.Runnable
    public void run() {
        Matrix matrix = this.f68616m;
        this.f68607d.V(this.f68613j, this.f68614k, matrix);
        this.f68607d.J(matrix, this.f68611i, false);
        float fR = ((BarLineChartBase) this.f68611i).B(this.f68615l).I / this.f68607d.r();
        float fQ = ((BarLineChartBase) this.f68611i).getXAxis().I / this.f68607d.q();
        float[] fArr = this.f68606c;
        fArr[0] = this.f68608f - (fQ / 2.0f);
        fArr[1] = this.f68609g + (fR / 2.0f);
        this.f68610h.k(fArr);
        this.f68607d.T(this.f68606c, matrix);
        this.f68607d.J(matrix, this.f68611i, false);
        ((BarLineChartBase) this.f68611i).f();
        this.f68611i.postInvalidate();
        b(this);
    }
}
