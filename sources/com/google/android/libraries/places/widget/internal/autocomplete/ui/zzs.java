package com.google.android.libraries.places.widget.internal.autocomplete.ui;

import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzs implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaseAutocompleteImplFragment f79075a;

    zzs(BaseAutocompleteImplFragment baseAutocompleteImplFragment) {
        Objects.requireNonNull(baseAutocompleteImplFragment);
        this.f79075a = baseAutocompleteImplFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f79075a.E();
    }
}
