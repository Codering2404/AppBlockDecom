package com.github.mikephil.charting.formatter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class IndexAxisValueFormatter extends ValueFormatter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String[] f68564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f68565b;

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String f(float f3) {
        int iRound = Math.round(f3);
        return (iRound < 0 || iRound >= this.f68565b || iRound != ((int) f3)) ? "" : this.f68564a[iRound];
    }
}
