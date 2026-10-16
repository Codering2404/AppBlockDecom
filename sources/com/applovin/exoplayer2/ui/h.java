package com.applovin.exoplayer2.ui;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import com.applovin.exoplayer2.common.base.Predicate;
import com.applovin.impl.a5;
import com.applovin.impl.b1;
import com.applovin.impl.zb;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class h {
    public static float a(int i3, float f3, int i4, int i5) {
        float f4;
        if (f3 == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i3 == 0) {
            f4 = i5;
        } else {
            if (i3 != 1) {
                if (i3 != 2) {
                    return -3.4028235E38f;
                }
                return f3;
            }
            f4 = i4;
        }
        return f3 * f4;
    }

    public static void b(a5.b bVar) {
        bVar.b(-3.4028235E38f, Integer.MIN_VALUE);
        if (bVar.e() instanceof Spanned) {
            if (!(bVar.e() instanceof Spannable)) {
                bVar.a(SpannableString.valueOf(bVar.e()));
            }
            a((Spannable) b1.a(bVar.e()), new Predicate() { // from class: com.applovin.exoplayer2.ui.r
                @Override // com.applovin.exoplayer2.common.base.Predicate
                public final boolean apply(Object obj) {
                    return h.b(obj);
                }
            });
        }
    }

    public static void a(a5.b bVar) {
        bVar.b();
        if (bVar.e() instanceof Spanned) {
            if (!(bVar.e() instanceof Spannable)) {
                bVar.a(SpannableString.valueOf(bVar.e()));
            }
            a((Spannable) b1.a(bVar.e()), new Predicate() { // from class: com.applovin.exoplayer2.ui.q
                @Override // com.applovin.exoplayer2.common.base.Predicate
                public final boolean apply(Object obj) {
                    return h.a(obj);
                }
            });
        }
        b(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean b(Object obj) {
        return (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(Object obj) {
        return !(obj instanceof zb);
    }

    private static void a(Spannable spannable, Predicate predicate) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            if (predicate.apply(obj)) {
                spannable.removeSpan(obj);
            }
        }
    }
}
