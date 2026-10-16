package com.github.mikephil.charting.jobs;

import android.animation.ValueAnimator;
import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AnimatedMoveViewJob extends AnimatedViewPortJob {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static ObjectPool f68592n;

    static {
        ObjectPool objectPoolA = ObjectPool.a(4, new AnimatedMoveViewJob(null, 0.0f, 0.0f, null, null, 0.0f, 0.0f, 0L));
        f68592n = objectPoolA;
        objectPoolA.g(0.5f);
    }

    public AnimatedMoveViewJob(ViewPortHandler viewPortHandler, float f3, float f4, Transformer transformer, View view, float f5, float f6, long j3) {
        super(viewPortHandler, f3, f4, transformer, view, f5, f6, j3);
    }

    public static void c(AnimatedMoveViewJob animatedMoveViewJob) {
        f68592n.c(animatedMoveViewJob);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable a() {
        return new AnimatedMoveViewJob(null, 0.0f, 0.0f, null, null, 0.0f, 0.0f, 0L);
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob
    public void b() {
        c(this);
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float[] fArr = this.f68606c;
        float f3 = this.f68595l;
        float f4 = this.f68608f - f3;
        float f5 = this.f68594k;
        fArr[0] = f3 + (f4 * f5);
        float f6 = this.f68596m;
        fArr[1] = f6 + ((this.f68609g - f6) * f5);
        this.f68610h.k(fArr);
        this.f68607d.e(this.f68606c, this.f68611i);
    }
}
