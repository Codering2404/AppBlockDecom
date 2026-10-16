package com.github.mikephil.charting.highlight;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Range {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f68590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f68591b;

    public Range(float f3, float f4) {
        this.f68590a = f3;
        this.f68591b = f4;
    }

    public boolean a(float f3) {
        return f3 > this.f68590a && f3 <= this.f68591b;
    }
}
