package com.github.mikephil.charting.jobs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AnimatedZoomJob extends AnimatedViewPortJob implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static ObjectPool f68597u = ObjectPool.a(8, new AnimatedZoomJob(null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0));

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected float f68598n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected float f68599o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected float f68600p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected float f68601q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected YAxis f68602r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected float f68603s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected Matrix f68604t;

    public AnimatedZoomJob(ViewPortHandler viewPortHandler, View view, Transformer transformer, YAxis yAxis, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, long j3) {
        super(viewPortHandler, f4, f5, transformer, view, f6, f7, j3);
        this.f68604t = new Matrix();
        this.f68600p = f8;
        this.f68601q = f9;
        this.f68598n = f10;
        this.f68599o = f11;
        this.f68593j.addListener(this);
        this.f68602r = yAxis;
        this.f68603s = f3;
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable a() {
        return new AnimatedZoomJob(null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L);
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ((BarLineChartBase) this.f68611i).f();
        this.f68611i.postInvalidate();
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f3 = this.f68595l;
        float f4 = this.f68608f - f3;
        float f5 = this.f68594k;
        float f6 = f3 + (f4 * f5);
        float f7 = this.f68596m;
        float f8 = f7 + ((this.f68609g - f7) * f5);
        Matrix matrix = this.f68604t;
        this.f68607d.S(f6, f8, matrix);
        this.f68607d.J(matrix, this.f68611i, false);
        float fR = this.f68602r.I / this.f68607d.r();
        float fQ = this.f68603s / this.f68607d.q();
        float[] fArr = this.f68606c;
        float f9 = this.f68598n;
        float f10 = (this.f68600p - (fQ / 2.0f)) - f9;
        float f11 = this.f68594k;
        fArr[0] = f9 + (f10 * f11);
        float f12 = this.f68599o;
        fArr[1] = f12 + (((this.f68601q + (fR / 2.0f)) - f12) * f11);
        this.f68610h.k(fArr);
        this.f68607d.T(this.f68606c, matrix);
        this.f68607d.J(matrix, this.f68611i, true);
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob
    public void b() {
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
