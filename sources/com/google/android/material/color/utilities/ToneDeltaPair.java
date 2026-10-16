package com.google.android.material.color.utilities;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class ToneDeltaPair {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DynamicColor f80685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DynamicColor f80686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f80687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TonePolarity f80688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f80689e;

    public ToneDeltaPair(DynamicColor dynamicColor, DynamicColor dynamicColor2, double d3, TonePolarity tonePolarity, boolean z2) {
        this.f80685a = dynamicColor;
        this.f80686b = dynamicColor2;
        this.f80687c = d3;
        this.f80688d = tonePolarity;
        this.f80689e = z2;
    }

    public double a() {
        return this.f80687c;
    }

    public TonePolarity b() {
        return this.f80688d;
    }

    public DynamicColor c() {
        return this.f80685a;
    }

    public DynamicColor d() {
        return this.f80686b;
    }

    public boolean e() {
        return this.f80689e;
    }
}
