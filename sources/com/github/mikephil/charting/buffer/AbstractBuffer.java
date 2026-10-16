package com.github.mikephil.charting.buffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractBuffer<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f68280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected float f68281c = 1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected float f68282d = 1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f68283e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f68284f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f68279a = 0;

    public AbstractBuffer(int i3) {
        this.f68280b = new float[i3];
    }

    public void a() {
        this.f68279a = 0;
    }

    public void b(float f3, float f4) {
        this.f68281c = f3;
        this.f68282d = f4;
    }

    public int c() {
        return this.f68280b.length;
    }
}
