package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class MaxInputValidator implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f82476a;

    public MaxInputValidator(int i3) {
        this.f82476a = i3;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i3, int i4, Spanned spanned, int i5, int i6) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i5, i6, charSequence.subSequence(i3, i4).toString());
            if (Integer.parseInt(sb.toString()) <= this.f82476a) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
