package com.applovin.impl;

import android.text.Spannable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class pk {
    public static void a(Spannable spannable, Object obj, int i3, int i4, int i5) {
        for (Object obj2 : spannable.getSpans(i3, i4, obj.getClass())) {
            if (spannable.getSpanStart(obj2) == i3 && spannable.getSpanEnd(obj2) == i4 && spannable.getSpanFlags(obj2) == i5) {
                spannable.removeSpan(obj2);
            }
        }
        spannable.setSpan(obj, i3, i4, i5);
    }
}
