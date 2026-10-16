package ru.noties.markwon.utils;

import android.text.Spannable;
import android.text.SpannableString;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class NoCopySpannableFactory extends Spannable.Factory {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Holder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final NoCopySpannableFactory f147402a = new NoCopySpannableFactory();
    }

    @Override // android.text.Spannable.Factory
    public Spannable newSpannable(CharSequence charSequence) {
        return charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
    }
}
