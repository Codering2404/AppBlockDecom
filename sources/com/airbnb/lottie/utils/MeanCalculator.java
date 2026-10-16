package com.airbnb.lottie.utils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MeanCalculator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f57100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f57101b;

    public void a(float f3) {
        float f4 = this.f57100a + f3;
        this.f57100a = f4;
        int i3 = this.f57101b + 1;
        this.f57101b = i3;
        if (i3 == Integer.MAX_VALUE) {
            this.f57100a = f4 / 2.0f;
            this.f57101b = i3 / 2;
        }
    }
}
