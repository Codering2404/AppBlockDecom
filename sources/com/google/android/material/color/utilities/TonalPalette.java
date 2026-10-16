package com.google.android.material.color.utilities;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class TonalPalette {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Map f80681a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Hct f80682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    double f80683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    double f80684d;

    private TonalPalette(double d3, double d4, Hct hct) {
        this.f80683c = d3;
        this.f80684d = d4;
        this.f80682b = hct;
    }

    private static Hct a(double d3, double d4) {
        Hct hctA = Hct.a(d3, d4, 50.0d);
        double dAbs = Math.abs(hctA.c() - d4);
        for (double d5 = 1.0d; d5 < 50.0d && Math.round(d4) != Math.round(hctA.c()); d5 += 1.0d) {
            Hct hctA2 = Hct.a(d3, d4, 50.0d + d5);
            double dAbs2 = Math.abs(hctA2.c() - d4);
            if (dAbs2 < dAbs) {
                dAbs = dAbs2;
                hctA = hctA2;
            }
            Hct hctA3 = Hct.a(d3, d4, 50.0d - d5);
            double dAbs3 = Math.abs(hctA3.c() - d4);
            if (dAbs3 < dAbs) {
                dAbs = dAbs3;
                hctA = hctA3;
            }
        }
        return hctA;
    }

    public static TonalPalette b(Hct hct) {
        return new TonalPalette(hct.d(), hct.c(), hct);
    }

    public static TonalPalette c(double d3, double d4) {
        return new TonalPalette(d3, d4, a(d3, d4));
    }

    public double d() {
        return this.f80684d;
    }

    public Hct e(double d3) {
        return Hct.a(this.f80683c, this.f80684d, d3);
    }

    public double f() {
        return this.f80683c;
    }
}
