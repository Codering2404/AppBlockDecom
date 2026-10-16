package com.google.android.material.color.utilities;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class SchemeContent extends DynamicScheme {
    public SchemeContent(Hct hct, boolean z2, double d3) {
        super(hct, Variant.CONTENT, z2, d3, TonalPalette.c(hct.d(), hct.c()), TonalPalette.c(hct.d(), Math.max(hct.c() - 32.0d, hct.c() * 0.5d)), TonalPalette.b(DislikeAnalyzer.a((Hct) new TemperatureCache(hct).b(3, 6).get(2))), TonalPalette.c(hct.d(), hct.c() / 8.0d), TonalPalette.c(hct.d(), (hct.c() / 8.0d) + 4.0d));
    }
}
