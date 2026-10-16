package com.google.android.material.color.utilities;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class ContrastCurve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f80605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f80606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f80607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final double f80608d;

    public ContrastCurve(double d3, double d4, double d5, double d6) {
        this.f80605a = d3;
        this.f80606b = d4;
        this.f80607c = d5;
        this.f80608d = d6;
    }

    public double a(double d3) {
        return d3 <= -1.0d ? this.f80605a : d3 < 0.0d ? MathUtils.c(this.f80605a, this.f80606b, (d3 - (-1.0d)) / 1.0d) : d3 < 0.5d ? MathUtils.c(this.f80606b, this.f80607c, (d3 - 0.0d) / 0.5d) : d3 < 1.0d ? MathUtils.c(this.f80607c, this.f80608d, (d3 - 0.5d) / 0.5d) : this.f80608d;
    }
}
