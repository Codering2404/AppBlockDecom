package com.github.mikephil.charting.utils;

import android.graphics.Color;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ColorTemplate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f68779a = {Color.rgb(207, 248, 246), Color.rgb(148, 212, 212), Color.rgb(136, SensibleDefaults.X_OFFSET, 187), Color.rgb(118, 174, 175), Color.rgb(42, 109, 130)};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f68780b = {Color.rgb(217, 80, 138), Color.rgb(254, 149, 7), Color.rgb(254, 247, 120), Color.rgb(106, 167, 134), Color.rgb(53, 194, 209)};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f68781c = {Color.rgb(64, 89, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD), Color.rgb(149, 165, 124), Color.rgb(217, 184, 162), Color.rgb(191, 134, 134), Color.rgb(179, 48, 80)};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f68782d = {Color.rgb(193, 37, 82), Color.rgb(255, 102, 0), Color.rgb(245, 199, 0), Color.rgb(106, 150, 31), Color.rgb(179, 100, 53)};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f68783e = {Color.rgb(192, 255, 140), Color.rgb(255, 247, 140), Color.rgb(255, 208, 140), Color.rgb(140, 234, 255), Color.rgb(255, 140, 157)};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f68784f = {b("#2ecc71"), b("#f1c40f"), b("#e74c3c"), b("#3498db")};

    public static int a(int i3, int i4) {
        return (i3 & 16777215) | ((i4 & 255) << 24);
    }

    public static int b(String str) {
        int i3 = (int) Long.parseLong(str.replace("#", ""), 16);
        return Color.rgb((i3 >> 16) & 255, (i3 >> 8) & 255, i3 & 255);
    }
}
