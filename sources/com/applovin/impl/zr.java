package com.applovin.impl;

import com.revenuecat.purchases.common.Constants;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f65488a = Pattern.compile("^NOTE([ \t].*)?$");

    public static boolean a(ah ahVar) {
        String strL = ahVar.l();
        return strL != null && strL.startsWith("WEBVTT");
    }

    public static long b(String str) {
        String[] strArrB = xp.b(str, "\\.");
        long j3 = 0;
        for (String str2 : xp.a(strArrB[0], Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)) {
            j3 = (j3 * 60) + Long.parseLong(str2);
        }
        long j4 = j3 * 1000;
        if (strArrB.length == 2) {
            j4 += Long.parseLong(strArrB[1]);
        }
        return j4 * 1000;
    }

    public static float a(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static void b(ah ahVar) throws ch {
        int iD = ahVar.d();
        if (a(ahVar)) {
            return;
        }
        ahVar.f(iD);
        throw ch.a("Expected WEBVTT. Got " + ahVar.l(), null);
    }
}
