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
public final class zzab extends FragmentFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f79020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PlacesClient f79021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zznq f79022d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzpu f79023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzef f79024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f79025h;

    public zzab(int i3, zzpt zzptVar, zznq zznqVar, int i4) {
        this.f79020b = i3;
        this.f79021c = zzptVar.zzc();
        this.f79022d = zznqVar;
        this.f79023f = zzptVar.zzd();
        this.f79024g = zzptVar.zzb();
        this.f79025h = i4;
    }

    @Override // androidx.fragment.app.FragmentFactory
    public final Fragment a(ClassLoader classLoader, String str) {
        return FragmentFactory.d(classLoader, str) == BaseAutocompleteImplFragment.class ? new BaseAutocompleteImplFragment(this.f79020b, this.f79021c, this.f79022d, this.f79023f, this.f79024g, this.f79025h, null) : super.a(classLoader, str);
    }
}
