package com.github.mikephil.charting.jobs;

import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MoveViewJob extends ViewPortJob {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static ObjectPool f68605j;

    static {
        ObjectPool objectPoolA = ObjectPool.a(2, new MoveViewJob(null, 0.0f, 0.0f, null, null));
        f68605j = objectPoolA;
        objectPoolA.g(0.5f);
    }

    public MoveViewJob(ViewPortHandler viewPortHandler, float f3, float f4, Transformer transformer, View view) {
        super(viewPortHandler, f3, f4, transformer, view);
    }

    public static void b(MoveViewJob moveViewJob) {
        f68605j.c(moveViewJob);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable a() {
        return new MoveViewJob(this.f68607d, this.f68608f, this.f68609g, this.f68610h, this.f68611i);
    }

    @Override // java.lang.Runnable
    public void run() {
        float[] fArr = this.f68606c;
        fArr[0] = this.f68608f;
        fArr[1] = this.f68609g;
        this.f68610h.k(fArr);
        this.f68607d.e(this.f68606c, this.f68611i);
        b(this);
    }
}
