package com.google.android.libraries.places.widget.internal.autocomplete.ui;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.internal.zznb;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzt extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaseAutocompleteImplFragment f79076a;

    zzt(BaseAutocompleteImplFragment baseAutocompleteImplFragment) {
        Objects.requireNonNull(baseAutocompleteImplFragment);
        this.f79076a = baseAutocompleteImplFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void a(RecyclerView recyclerView, int i3) {
        if (i3 == 1) {
            try {
                BaseAutocompleteImplFragment baseAutocompleteImplFragment = this.f79076a;
                baseAutocompleteImplFragment.F().C0();
                baseAutocompleteImplFragment.G().clearFocus();
            } catch (Error | RuntimeException e3) {
                zznb.b(e3);
                throw e3;
            }
        }
    }
}
