package com.github.mikephil.charting.formatter;

import java.text.DecimalFormat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LargeValueFormatter extends ValueFormatter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String[] f68566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f68567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DecimalFormat f68568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f68569d;

    private String j(double d3) {
        String str = this.f68568c.format(d3);
        int numericValue = Character.getNumericValue(str.charAt(str.length() - 1));
        String strReplaceAll = str.replaceAll("E[0-9][0-9]", this.f68566a[Integer.valueOf(Character.getNumericValue(str.charAt(str.length() - 2)) + "" + numericValue).intValue() / 3]);
        while (true) {
            if (strReplaceAll.length() <= this.f68567b && !strReplaceAll.matches("[0-9]+\\.[a-z]")) {
                return strReplaceAll;
            }
            strReplaceAll = strReplaceAll.substring(0, strReplaceAll.length() - 2) + strReplaceAll.substring(strReplaceAll.length() - 1);
        }
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String f(float f3) {
        return j(f3) + this.f68569d;
    }
}
