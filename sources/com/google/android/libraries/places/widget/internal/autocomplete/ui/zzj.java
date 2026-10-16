package com.google.android.libraries.places.widget.internal.autocomplete.ui;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.internal.zzef;
import com.google.android.libraries.places.internal.zznq;
import com.google.android.libraries.places.internal.zzpt;
import com.google.android.libraries.places.internal.zzpu;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzj extends FragmentFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f79052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PlacesClient f79053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zznq f79054d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzpu f79055f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzef f79056g;

    public zzj(int i3, zzpt zzptVar, zznq zznqVar) {
        this.f79052b = i3;
        this.f79053c = zzptVar.zzc();
        this.f79054d = zznqVar;
        this.f79055f = zzptVar.zzd();
        this.f79056g = zzptVar.zzb();
    }

    @Override // androidx.fragment.app.FragmentFactory
    public final Fragment a(ClassLoader classLoader, String str) {
        return FragmentFactory.d(classLoader, str) == AutocompleteImplFragment.class ? new AutocompleteImplFragment(this.f79052b, this.f79053c, this.f79054d, this.f79055f, this.f79056g, null) : super.a(classLoader, str);
    }
}
