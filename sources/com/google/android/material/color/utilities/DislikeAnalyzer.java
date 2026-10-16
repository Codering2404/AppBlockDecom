package com.google.android.material.color.utilities;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class DislikeAnalyzer {
    public static Hct a(Hct hct) {
        return b(hct) ? Hct.a(hct.d(), hct.c(), 70.0d) : hct;
    }

    public static boolean b(Hct hct) {
        return ((((double) Math.round(hct.d())) > 90.0d ? 1 : (((double) Math.round(hct.d())) == 90.0d ? 0 : -1)) >= 0 && (((double) Math.round(hct.d())) > 111.0d ? 1 : (((double) Math.round(hct.d())) == 111.0d ? 0 : -1)) <= 0) && ((((double) Math.round(hct.c())) > 16.0d ? 1 : (((double) Math.round(hct.c())) == 16.0d ? 0 : -1)) > 0) && ((((double) Math.round(hct.e())) > 65.0d ? 1 : (((double) Math.round(hct.e())) == 65.0d ? 0 : -1)) < 0);
    }
}
