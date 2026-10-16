package com.google.android.libraries.places.widget.internal.placedetails;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.Place;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzf extends Fragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f79337d = {Reflection.e(new MutablePropertyReference1Impl(zzf.class, "themeResId", "getThemeResId()I", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private zzbj f79338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RecyclerView f79339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ReadWriteProperty f79340c = Delegates.f140171a.a();

    public static final /* synthetic */ void w(final zzf zzfVar, Place place) {
        Context contextRequireContext = zzfVar.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        zzl zzlVar = new zzl(zzm.a(place, contextRequireContext));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(zzfVar.requireContext(), 2);
        gridLayoutManager.i3(new zze(zzlVar));
        RecyclerView recyclerView = zzfVar.f79339b;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(gridLayoutManager);
        RecyclerView recyclerView3 = zzfVar.f79339b;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setAdapter(zzlVar);
        RecyclerView recyclerView4 = zzfVar.f79339b;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView4 = null;
        }
        Context contextRequireContext2 = zzfVar.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        recyclerView4.j(new zzb(contextRequireContext2, zzfVar.y()));
        RecyclerView recyclerView5 = zzfVar.f79339b;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView2 = recyclerView5;
        }
        recyclerView2.post(new Runnable() { // from class: com.google.android.libraries.places.widget.internal.placedetails.zza
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzf.x(this.f79138a);
            }
        });
    }

    static /* synthetic */ void x(zzf zzfVar) {
        zzbj zzbjVar = zzfVar.f79338a;
        if (zzbjVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzbjVar = null;
        }
        zzbjVar.F0();
    }

    private final int y() {
        return ((Number) this.f79340c.a(this, f79337d[0])).intValue();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fragment fragmentRequireParentFragment = requireParentFragment();
        Intrinsics.checkNotNullExpressionValue(fragmentRequireParentFragment, "requireParentFragment(...)");
        Application application = requireActivity().getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        this.f79338a = (zzbj) new ViewModelProvider(fragmentRequireParentFragment, zzau.a(application)).a(zzbj.class);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        int i3 = requireArguments().getInt("arg-theme-res-id");
        this.f79340c.b(this, f79337d[0], Integer.valueOf(i3));
        View viewInflate = inflater.cloneInContext(new ContextThemeWrapper(getContext(), y())).inflate(R.layout.f74803n, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View viewFindViewById = view.findViewById(R.id.P);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.f79339b = (RecyclerView) viewFindViewById;
        zzbj zzbjVar = this.f79338a;
        if (zzbjVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzbjVar = null;
        }
        zzbjVar.z0().j(getViewLifecycleOwner(), new zzd(new zzc(this)));
    }
}
