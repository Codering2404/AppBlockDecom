package com.google.android.libraries.places.internal;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zznu {
    public static int a(int i3, int i4, int i5) {
        return b(i3, i4, i5) ? i5 : i4;
    }

    public static boolean b(int i3, int i4, int i5) {
        double dE = e(i3);
        double d3 = d(e(i4), dE);
        return d3 <= 3.0d && d3 <= d(e(i5), dE);
    }

    public static void c(ImageView imageView, int i3) {
        Drawable drawable = imageView.getDrawable();
        int iRgb = Color.rgb(Color.red(i3), Color.green(i3), Color.blue(i3));
        Drawable drawableMutate = drawable.mutate();
        drawableMutate.setColorFilter(iRgb, PorterDuff.Mode.SRC_ATOP);
        drawableMutate.setAlpha(Color.alpha(i3));
    }

    private static double d(double d3, double d4) {
        return Math.round(((Math.max(d3, d4) + 0.05d) / (Math.min(d3, d4) + 0.05d)) * 100.0d) / 100.0d;
    }

    private static double e(int i3) {
        return (f(((double) Color.red(i3)) / 255.0d) * 0.2126d) + (f(((double) Color.green(i3)) / 255.0d) * 0.7152d) + (f(((double) Color.blue(i3)) / 255.0d) * 0.0722d);
    }

    private static double f(double d3) {
        return d3 <= 0.03928d ? d3 / 12.92d : Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
    }
}
