package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class w6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f64608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f64609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f64610c;

    private w6(int i3, int i4, String str) {
        this.f64608a = i3;
        this.f64609b = i4;
        this.f64610c = str;
    }

    public static w6 a(ah ahVar) {
        String str;
        ahVar.g(2);
        int iW = ahVar.w();
        int i3 = iW >> 1;
        int iW2 = ((ahVar.w() >> 3) & 31) | ((iW & 1) << 5);
        if (i3 == 4 || i3 == 5 || i3 == 7) {
            str = "dvhe";
        } else if (i3 == 8) {
            str = "hev1";
        } else {
            if (i3 != 9) {
                return null;
            }
            str = "avc3";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".0");
        sb.append(i3);
        sb.append(iW2 >= 10 ? "." : ".0");
        sb.append(iW2);
        return new w6(i3, iW2, sb.toString());
    }
}
