package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.BarEntry;
import java.text.DecimalFormat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class StackedValueFormatter extends ValueFormatter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f68572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f68573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DecimalFormat f68574c;

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String c(float f3, BarEntry barEntry) {
        float[] fArrO;
        if (this.f68572a || (fArrO = barEntry.o()) == null) {
            return this.f68574c.format(f3) + this.f68573b;
        }
        if (fArrO[fArrO.length - 1] != f3) {
            return "";
        }
        return this.f68574c.format(barEntry.e()) + this.f68573b;
    }
}
