package com.google.android.material.slider;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class BasicLabelFormatter implements LabelFormatter {
    @Override // com.google.android.material.slider.LabelFormatter
    public String a(float f3) {
        return f3 >= 1.0E12f ? String.format(Locale.US, "%.1fT", Float.valueOf(f3 / 1.0E12f)) : f3 >= 1.0E9f ? String.format(Locale.US, "%.1fB", Float.valueOf(f3 / 1.0E9f)) : f3 >= 1000000.0f ? String.format(Locale.US, "%.1fM", Float.valueOf(f3 / 1000000.0f)) : f3 >= 1000.0f ? String.format(Locale.US, "%.1fK", Float.valueOf(f3 / 1000.0f)) : String.format(Locale.US, "%.0f", Float.valueOf(f3));
    }
}
