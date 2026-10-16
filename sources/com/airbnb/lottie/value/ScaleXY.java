package com.airbnb.lottie.value;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ScaleXY {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f57141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f57142b;

    public ScaleXY(float f3, float f4) {
        this.f57141a = f3;
        this.f57142b = f4;
    }

    public boolean a(float f3, float f4) {
        return this.f57141a == f3 && this.f57142b == f4;
    }

    public float b() {
        return this.f57141a;
    }

    public float c() {
        return this.f57142b;
    }

    public void d(float f3, float f4) {
        this.f57141a = f3;
        this.f57142b = f4;
    }

    public String toString() {
        return b() + "x" + c();
    }

    public ScaleXY() {
        this(1.0f, 1.0f);
    }
}
