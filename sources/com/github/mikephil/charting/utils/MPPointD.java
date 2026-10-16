package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MPPointD extends ObjectPool.Poolable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static ObjectPool f68788f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f68789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f68790d;

    static {
        ObjectPool objectPoolA = ObjectPool.a(64, new MPPointD(0.0d, 0.0d));
        f68788f = objectPoolA;
        objectPoolA.g(0.5f);
    }

    private MPPointD(double d3, double d4) {
        this.f68789c = d3;
        this.f68790d = d4;
    }

    public static MPPointD b(double d3, double d4) {
        MPPointD mPPointD = (MPPointD) f68788f.b();
        mPPointD.f68789c = d3;
        mPPointD.f68790d = d4;
        return mPPointD;
    }

    public static void c(MPPointD mPPointD) {
        f68788f.c(mPPointD);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable a() {
        return new MPPointD(0.0d, 0.0d);
    }

    public String toString() {
        return "MPPointD, x: " + this.f68789c + ", y: " + this.f68790d;
    }
}
