package com.google.android.libraries.places.widget.internal.autocomplete.ui;

import androidx.activity.OnBackPressedCallback;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zza extends OnBackPressedCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AutocompleteImplFragment f79018a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zza(AutocompleteImplFragment autocompleteImplFragment, boolean z2) {
        super(true);
        Objects.requireNonNull(autocompleteImplFragment);
        this.f79018a = autocompleteImplFragment;
    }

    @Override // androidx.activity.OnBackPressedCallback
    public final void handleOnBackPressed() {
        this.f79018a.C().H0();
    }
}
