package com.google.android.libraries.places.widget.internal.autocomplete.ui;

import androidx.recyclerview.widget.DiffUtil;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.internal.zznb;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzm extends DiffUtil.ItemCallback {
    /* synthetic */ zzm(byte[] bArr) {
    }

    public static final boolean d(AutocompletePrediction autocompletePrediction, AutocompletePrediction autocompletePrediction2) {
        try {
            return autocompletePrediction.d().equals(autocompletePrediction2.d());
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final /* synthetic */ boolean a(Object obj, Object obj2) {
        return ((AutocompletePrediction) obj).equals((AutocompletePrediction) obj2);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final /* bridge */ /* synthetic */ boolean b(Object obj, Object obj2) {
        return d((AutocompletePrediction) obj, (AutocompletePrediction) obj2);
    }
}
