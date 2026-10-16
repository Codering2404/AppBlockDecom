package com.facebook.ads.redexgen.core;

import android.text.Spannable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3t, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC04273t {
    public static void A00(Spannable spannable, Object obj, int i3, int i4, int i5) {
        for (Object obj2 : spannable.getSpans(i3, i4, obj.getClass())) {
            if (spannable.getSpanStart(obj2) == i3 && spannable.getSpanEnd(obj2) == i4 && spannable.getSpanFlags(obj2) == i5) {
                spannable.removeSpan(obj2);
            }
        }
        spannable.setSpan(obj, i3, i4, i5);
    }
}
