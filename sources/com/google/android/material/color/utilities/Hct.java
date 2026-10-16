package com.google.android.material.color.utilities;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class Hct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f80630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f80631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f80632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f80633d;

    private Hct(int i3) {
        g(i3);
    }

    public static Hct a(double d3, double d4, double d5) {
        return new Hct(HctSolver.q(d3, d4, d5));
    }

    public static Hct b(int i3) {
        return new Hct(i3);
    }

    private void g(int i3) {
        this.f80633d = i3;
        Cam16 cam16A = Cam16.a(i3);
        this.f80630a = cam16A.e();
        this.f80631b = cam16A.d();
        this.f80632c = ColorUtils.k(i3);
    }

    public double c() {
        return this.f80631b;
    }

    public double d() {
        return this.f80630a;
    }

    public double e() {
        return this.f80632c;
    }

    public Hct f(ViewingConditions viewingConditions) {
        double[] dArrG = Cam16.a(h()).g(viewingConditions, null);
        Cam16 cam16C = Cam16.c(dArrG[0], dArrG[1], dArrG[2], ViewingConditions.f80705k);
        return a(cam16C.e(), cam16C.d(), ColorUtils.l(dArrG[1]));
    }

    public int h() {
        return this.f80633d;
    }
}
