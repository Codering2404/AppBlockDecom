package com.github.mikephil.charting.jobs;

import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ViewPortJob extends ObjectPool.Poolable implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected float[] f68606c = new float[2];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected ViewPortHandler f68607d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected float f68608f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected float f68609g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected Transformer f68610h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected View f68611i;

    public ViewPortJob(ViewPortHandler viewPortHandler, float f3, float f4, Transformer transformer, View view) {
        this.f68607d = viewPortHandler;
        this.f68608f = f3;
        this.f68609g = f4;
        this.f68610h = transformer;
        this.f68611i = view;
    }
}
