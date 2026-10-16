package com.google.android.libraries.places.widget.internal.photoviewer;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.internal.zzmy;
import com.google.android.libraries.places.internal.zzou;
import com.google.android.libraries.places.internal.zzpr;
import com.google.android.libraries.places.internal.zzps;
import com.google.android.libraries.places.internal.zzpt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzl extends Fragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f79111j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f79112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f79113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzd f79114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FrameLayout f79115d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzpt f79116f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f79117g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f79118h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public zze f79119i;

    static /* synthetic */ void B(zzl zzlVar, View view) {
        zzlVar.E(false);
        zzlVar.x().k();
        zzlVar.F();
    }

    static /* synthetic */ void C(zzl zzlVar, View view) {
        zzlVar.E(false);
        zzlVar.x().d();
        zzlVar.F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(boolean z2) {
        View view = this.f79117g;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previousImageButton");
            view = null;
        }
        view.setEnabled(z2);
        View view3 = this.f79118h;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextImageButton");
        } else {
            view2 = view3;
        }
        view2.setEnabled(z2);
    }

    private final void F() {
        View view = getView();
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.google.android.libraries.places.widget.internal.photoviewer.zzh
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.f79106a.E(true);
                }
            }, 300L);
        }
    }

    public static final /* synthetic */ void z(zzl zzlVar) {
        ImageView imageView = zzlVar.f79112a;
        FrameLayout frameLayout = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("image");
            imageView = null;
        }
        imageView.setVisibility(8);
        FrameLayout frameLayout2 = zzlVar.f79115d;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingFailedUi");
        } else {
            frameLayout = frameLayout2;
        }
        frameLayout.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (!(context instanceof zze)) {
            Log.e("PhotoViewerFragment", "Context must implement PhotoNavigationListener");
            return;
        }
        zze zzeVar = (zze) context;
        Intrinsics.checkNotNullParameter(zzeVar, "<set-?>");
        this.f79119i = zzeVar;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle bundleRequireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(bundleRequireArguments, "requireArguments(...)");
        this.f79114c = (zzd) zzou.a(bundleRequireArguments, "page_data", zzd.class);
        if (this.f79116f == null) {
            zzps zzpsVarA = zzpr.a();
            zzpsVarA.zzc(requireContext());
            zzpsVarA.a(zzmy.PLACES_UI_KIT);
            this.f79116f = zzpsVarA.zza();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.f74802m, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(R.id.f74781x);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.f79113b = (ImageView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.f74773u0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.f79112a = (ImageView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.f74716f0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.f79115d = (FrameLayout) viewFindViewById3;
        View viewFindViewById4 = viewInflate.findViewById(R.id.E1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.f79117g = viewFindViewById4;
        View viewFindViewById5 = viewInflate.findViewById(R.id.f74732j0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.f79118h = viewFindViewById5;
        View view = this.f79117g;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previousImageButton");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.internal.photoviewer.zzi
            @Override // android.view.View.OnClickListener
            public final /* synthetic */ void onClick(View view3) {
                zzl.B(this.f79107a, view3);
            }
        });
        View view3 = this.f79118h;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextImageButton");
        } else {
            view2 = view3;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.internal.photoviewer.zzf
            @Override // android.view.View.OnClickListener
            public final /* synthetic */ void onClick(View view4) {
                zzl.C(this.f79104a, view4);
            }
        });
        Intrinsics.checkNotNull(viewInflate);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View view2 = this.f79117g;
        ImageView imageView = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previousImageButton");
            view2 = null;
        }
        view2.setVisibility(true != requireArguments().getBoolean("has_previous") ? 8 : 0);
        View view3 = this.f79118h;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextImageButton");
            view3 = null;
        }
        view3.setVisibility(true != requireArguments().getBoolean("has_next") ? 8 : 0);
        RequestManager requestManagerT = Glide.t(requireContext());
        zzd zzdVar = this.f79114c;
        if (zzdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageData");
            zzdVar = null;
        }
        RequestBuilder requestBuilderQ = requestManagerT.q(zzdVar.d());
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        RequestBuilder requestBuilderA = requestBuilderQ.a(RequestOptions.s0(new zza(contextRequireContext, 25.0f, 0.125f)));
        ImageView imageView2 = this.f79113b;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blurredBackground");
        } else {
            imageView = imageView2;
        }
        requestBuilderA.F0(imageView);
        requireView().post(new Runnable() { // from class: com.google.android.libraries.places.widget.internal.photoviewer.zzg
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzl zzlVar = this.f79105a;
                BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(zzlVar), null, null, new zzk(zzlVar, null), 3, null);
            }
        });
    }

    public final zzpt w() {
        return this.f79116f;
    }

    public final zze x() {
        zze zzeVar = this.f79119i;
        if (zzeVar != null) {
            return zzeVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("photoNavigationListener");
        return null;
    }
}
