package com.google.android.libraries.places.widget.internal.placedetails;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.zzpi;
import com.google.android.libraries.places.internal.zzpj;
import com.google.android.libraries.places.internal.zzpt;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzby extends Fragment {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f79284f = {Reflection.e(new MutablePropertyReference1Impl(zzby.class, "themeResId", "getThemeResId()I", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private zzbj f79285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzr f79286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RecyclerView f79287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ReadWriteProperty f79288d = Delegates.f140171a.a();

    private final int A() {
        return ((Number) this.f79288d.a(this, f79284f[0])).intValue();
    }

    private final void B() {
        RecyclerView recyclerView = this.f79287c;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.post(new Runnable() { // from class: com.google.android.libraries.places.widget.internal.placedetails.zzbu
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzby.z(this.f79281a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(zzby zzbyVar, View view) {
        Context contextRequireContext = zzbyVar.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        new zzpj(contextRequireContext, zzbyVar.A(), CollectionsKt.listOf((Object[]) new zzpi[]{zzpi.f78393a, zzpi.f78395c})).show();
    }

    public static final /* synthetic */ void w(final zzby zzbyVar, Place place) {
        zzr zzrVar = zzbyVar.f79286b;
        if (zzrVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("consumerAlertViewController");
            zzrVar = null;
        }
        zzrVar.a(place);
        List listF0 = place.f0();
        if (listF0 != null) {
            RecyclerView recyclerView = zzbyVar.f79287c;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            zzbj zzbjVar = zzbyVar.f79285a;
            if (zzbjVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                zzbjVar = null;
            }
            zzpt zzptVarD0 = zzbjVar.D0();
            recyclerView.setAdapter(new zzci(listF0, zzptVarD0 != null ? zzptVarD0.zze() : null, LifecycleOwnerKt.a(zzbyVar), zzbyVar.A(), new Function0() { // from class: com.google.android.libraries.places.widget.internal.placedetails.zzbt
                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ Object invoke() {
                    return zzby.y(this.f79280a);
                }
            }));
            zzbyVar.B();
        }
    }

    static /* synthetic */ Unit y(zzby zzbyVar) {
        zzbyVar.B();
        return Unit.f139807a;
    }

    static /* synthetic */ void z(zzby zzbyVar) {
        zzbj zzbjVar = zzbyVar.f79285a;
        if (zzbjVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzbjVar = null;
        }
        zzbjVar.F0();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fragment fragmentRequireParentFragment = requireParentFragment();
        Intrinsics.checkNotNullExpressionValue(fragmentRequireParentFragment, "requireParentFragment(...)");
        Application application = requireActivity().getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        this.f79285a = (zzbj) new ViewModelProvider(fragmentRequireParentFragment, zzau.a(application)).a(zzbj.class);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        int i3 = requireArguments().getInt("arg-theme-res-id");
        this.f79288d.b(this, f79284f[0], Integer.valueOf(i3));
        View viewInflate = inflater.cloneInContext(new ContextThemeWrapper(getContext(), A())).inflate(R.layout.f74807r, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View viewFindViewById = view.findViewById(R.id.Z1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById;
        this.f79287c = recyclerView;
        zzbj zzbjVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        ((ImageView) view.findViewById(R.id.f74699b)).setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.internal.placedetails.zzbv
            @Override // android.view.View.OnClickListener
            public final /* synthetic */ void onClick(View view2) {
                zzby.C(this.f79282a, view2);
            }
        });
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.f79286b = new zzr(contextRequireContext, A(), view);
        zzbj zzbjVar2 = this.f79285a;
        if (zzbjVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            zzbjVar = zzbjVar2;
        }
        zzbjVar.z0().j(getViewLifecycleOwner(), new zzbx(new zzbw(this)));
    }
}
