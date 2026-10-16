package com.airbnb.lottie.model;

import android.graphics.PointF;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class CubicCurveData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PointF f56677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PointF f56678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PointF f56679c;

    public CubicCurveData() {
        this.f56677a = new PointF();
        this.f56678b = new PointF();
        this.f56679c = new PointF();
    }

    public PointF a() {
        return this.f56677a;
    }

    public PointF b() {
        return this.f56678b;
    }

    public PointF c() {
        return this.f56679c;
    }

    public void d(float f3, float f4) {
        this.f56677a.set(f3, f4);
    }

    public void e(float f3, float f4) {
        this.f56678b.set(f3, f4);
    }

    public void f(float f3, float f4) {
        this.f56679c.set(f3, f4);
    }

    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.f56679c.x), Float.valueOf(this.f56679c.y), Float.valueOf(this.f56677a.x), Float.valueOf(this.f56677a.y), Float.valueOf(this.f56678b.x), Float.valueOf(this.f56678b.y));
    }

    public CubicCurveData(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f56677a = pointF;
        this.f56678b = pointF2;
        this.f56679c = pointF3;
    }
}
