package com.google.android.libraries.places.widget.internal.autocomplete.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.google.android.libraries.places.internal.zznb;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzac implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaseAutocompleteImplFragment f79026a;

    /* synthetic */ zzac(BaseAutocompleteImplFragment baseAutocompleteImplFragment, byte[] bArr) {
        Objects.requireNonNull(baseAutocompleteImplFragment);
        this.f79026a = baseAutocompleteImplFragment;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        try {
            BaseAutocompleteImplFragment baseAutocompleteImplFragment = this.f79026a;
            baseAutocompleteImplFragment.F().A0(editable.toString(), baseAutocompleteImplFragment.G().getSelectionEnd());
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
    }
}
