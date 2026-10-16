package com.google.android.libraries.places.widget.internal.placedetails;

import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.zzpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzao extends Fragment {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f79185z = {Reflection.e(new MutablePropertyReference1Impl(zzao.class, "themeResId", "getThemeResId()I", 0)), Reflection.e(new MutablePropertyReference1Impl(zzao.class, "openingHoursRequested", "getOpeningHoursRequested()Z", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private zzbj f79186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ReadWriteProperty f79187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ReadWriteProperty f79188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzr f79189d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RecyclerView f79190f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f79191g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private RecyclerView f79192h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f79193i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private View f79194j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f79195k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ImageView f79196l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private TextView f79197m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private TextView f79198n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private TextView f79199o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ImageView f79200p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private RecyclerView f79201q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ImageView f79202r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private TextView f79203s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ImageView f79204t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TextView f79205u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ImageView f79206v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private TextView f79207w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ImageView f79208x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f79209y;

    public zzao() {
        Delegates delegates = Delegates.f140171a;
        this.f79187b = delegates.a();
        this.f79188c = delegates.a();
    }

    static /* synthetic */ void A(zzao zzaoVar, View view) {
        RecyclerView recyclerView = null;
        if (zzaoVar.f79209y) {
            ImageView imageView = zzaoVar.f79200p;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("expandOpenHours");
                imageView = null;
            }
            imageView.setContentDescription(zzaoVar.requireContext().getString(R.string.f74842g1));
            RecyclerView recyclerView2 = zzaoVar.f79201q;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("expandedOpenHours");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.setVisibility(8);
        } else {
            ImageView imageView2 = zzaoVar.f79200p;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("expandOpenHours");
                imageView2 = null;
            }
            imageView2.setContentDescription(zzaoVar.requireContext().getString(R.string.f74866q));
            RecyclerView recyclerView3 = zzaoVar.f79201q;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("expandedOpenHours");
            } else {
                recyclerView = recyclerView3;
            }
            recyclerView.setVisibility(0);
        }
        zzaoVar.f79209y = !zzaoVar.f79209y;
        zzaoVar.F();
    }

    private final int B() {
        return ((Number) this.f79187b.a(this, f79185z[0])).intValue();
    }

    private final boolean C() {
        return ((Boolean) this.f79188c.a(this, f79185z[1])).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void D(final com.google.android.libraries.places.api.model.Place r17) {
        /*
            Method dump skipped, instruction units count: 1064
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.widget.internal.placedetails.zzao.D(com.google.android.libraries.places.api.model.Place):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        try {
            requireContext().startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            new zzpl(contextRequireContext, B()).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        zzbj zzbjVar = this.f79186a;
        if (zzbjVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzbjVar = null;
        }
        zzbjVar.F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(Place place, zzao zzaoVar, View view) {
        try {
            zzaoVar.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(place.H())))));
        } catch (ActivityNotFoundException unused) {
            Log.w("OverviewFragment", "No dialer app available, cannot dial the number.");
        }
    }

    private static final void H(View view, CharSequence charSequence) {
        if (charSequence == null || StringsKt.p0(charSequence)) {
            view.setVisibility(8);
            return;
        }
        if (view instanceof TextView) {
            ((TextView) view).setText(charSequence);
        }
        view.setVisibility(0);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fragment fragmentRequireParentFragment = requireParentFragment();
        Intrinsics.checkNotNullExpressionValue(fragmentRequireParentFragment, "requireParentFragment(...)");
        Application application = requireActivity().getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        this.f79186a = (zzbj) new ViewModelProvider(fragmentRequireParentFragment, zzau.a(application)).a(zzbj.class);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        boolean z2 = requireArguments().getBoolean("arg-opening-hours-requested");
        KProperty[] kPropertyArr = f79185z;
        this.f79188c.b(this, kPropertyArr[1], Boolean.valueOf(z2));
        int i3 = requireArguments().getInt("arg-theme-res-id");
        this.f79187b.b(this, kPropertyArr[0], Integer.valueOf(i3));
        View viewInflate = inflater.cloneInContext(new ContextThemeWrapper(getContext(), B())).inflate(R.layout.f74806q, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View viewFindViewById = view.findViewById(R.id.L);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.f79190f = (RecyclerView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.K);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.f79191g = (TextView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.Q);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.f79192h = (RecyclerView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.f74714e2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.f79193i = (TextView) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.f74742l2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.f79194j = viewFindViewById5;
        View viewFindViewById6 = view.findViewById(R.id.f74719g);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.f79195k = (TextView) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.f74715f);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.f79196l = (ImageView) viewFindViewById7;
        View viewFindViewById8 = view.findViewById(R.id.f74767s0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.f79205u = (TextView) viewFindViewById8;
        View viewFindViewById9 = view.findViewById(R.id.f74764r0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.f79206v = (ImageView) viewFindViewById9;
        View viewFindViewById10 = view.findViewById(R.id.v2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.f79203s = (TextView) viewFindViewById10;
        View viewFindViewById11 = view.findViewById(R.id.u2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.f79204t = (ImageView) viewFindViewById11;
        View viewFindViewById12 = view.findViewById(R.id.D1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.f79207w = (TextView) viewFindViewById12;
        View viewFindViewById13 = view.findViewById(R.id.C1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.f79208x = (ImageView) viewFindViewById13;
        View viewFindViewById14 = view.findViewById(R.id.f74756p0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        this.f79197m = (TextView) viewFindViewById14;
        View viewFindViewById15 = view.findViewById(R.id.f74760q0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
        this.f79198n = (TextView) viewFindViewById15;
        View viewFindViewById16 = view.findViewById(R.id.f74736k0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById16, "findViewById(...)");
        this.f79199o = (TextView) viewFindViewById16;
        View viewFindViewById17 = view.findViewById(R.id.M);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById17, "findViewById(...)");
        this.f79200p = (ImageView) viewFindViewById17;
        View viewFindViewById18 = view.findViewById(R.id.N);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById18, "findViewById(...)");
        this.f79201q = (RecyclerView) viewFindViewById18;
        View viewFindViewById19 = view.findViewById(R.id.f74744m0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById19, "findViewById(...)");
        this.f79202r = (ImageView) viewFindViewById19;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.f79189d = new zzr(contextRequireContext, B(), view);
        zzbj zzbjVar = this.f79186a;
        if (zzbjVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzbjVar = null;
        }
        zzbjVar.z0().j(getViewLifecycleOwner(), new zzam(new zzal(this)));
    }
}
