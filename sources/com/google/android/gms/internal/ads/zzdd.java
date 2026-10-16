package com.google.android.gms.internal.ads;

import android.text.Spannable;
import android.text.style.RelativeSizeSpan;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdd {
    public static void zza(Spannable spannable, Object obj, int i3, int i4, int i5) {
        for (Object obj2 : spannable.getSpans(i3, i4, obj.getClass())) {
            zzc(spannable, obj2, i3, i4, 33);
        }
        spannable.setSpan(obj, i3, i4, 33);
    }

    public static void zzb(Spannable spannable, float f3, int i3, int i4, int i5) {
        for (RelativeSizeSpan relativeSizeSpan : (RelativeSizeSpan[]) spannable.getSpans(i3, i4, RelativeSizeSpan.class)) {
            if (spannable.getSpanStart(relativeSizeSpan) <= i3 && spannable.getSpanEnd(relativeSizeSpan) >= i4) {
                f3 *= relativeSizeSpan.getSizeChange();
            }
            zzc(spannable, relativeSizeSpan, i3, i4, 33);
        }
        spannable.setSpan(new RelativeSizeSpan(f3), i3, i4, 33);
    }

    private static void zzc(Spannable spannable, Object obj, int i3, int i4, int i5) {
        if (spannable.getSpanStart(obj) == i3 && spannable.getSpanEnd(obj) == i4 && spannable.getSpanFlags(obj) == 33) {
            spannable.removeSpan(obj);
        }
    }
}
