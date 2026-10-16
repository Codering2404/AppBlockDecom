package com.google.android.libraries.places.widget;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.share.internal.ShareConstants;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.zzamz;
import com.google.android.libraries.places.internal.zzanb;
import com.google.android.libraries.places.internal.zzane;
import com.google.android.libraries.places.internal.zzanj;
import com.google.android.libraries.places.internal.zzop;
import com.google.android.libraries.places.internal.zzos;
import com.google.android.libraries.places.internal.zzot;
import com.google.android.libraries.places.internal.zzou;
import com.google.android.libraries.places.internal.zzpi;
import com.google.android.libraries.places.internal.zzpj;
import com.google.android.libraries.places.internal.zzpt;
import com.google.android.libraries.places.internal.zzpw;
import com.google.android.libraries.places.internal.zzpx;
import com.google.android.libraries.places.internal.zzqd;
import com.google.android.libraries.places.internal.zzqf;
import com.google.android.libraries.places.internal.zzqr;
import com.google.android.libraries.places.widget.model.AttributionPosition;
import com.google.android.libraries.places.widget.model.MediaSize;
import com.google.android.libraries.places.widget.model.Orientation;
import com.google.android.material.color.MaterialColors;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class PlaceSearchFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private zzqr f78950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RecyclerView f78951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LinearLayoutManager f78952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzqd f78953d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ProgressBar f78954f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzpw f78955g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private PlaceSearchFragmentListener f78956h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Parcelable f78957i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f78958j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Orientation f78959k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List f78960l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f78962n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f78963o;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f78949u = {Reflection.e(new MutablePropertyReference1Impl(PlaceSearchFragment.class, "themeResId", "getThemeResId()I", 0))};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Companion f78946r = new Companion(null);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final List f78947s = CollectionsKt.listOf((Object[]) new Content[]{Content.f78966a, Content.f78968c, Content.f78970f, Content.f78969d, Content.f78971g});

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final List f78948t = CollectionsKt.toList(Content.a());

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ReadWriteProperty f78961m = Delegates.f140171a.a();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private AttributionPosition f78964p = AttributionPosition.f79378a;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private MediaSize f78965q = MediaSize.f79398a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Content {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Content f78966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Content f78967b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Content f78968c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Content f78969d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Content f78970f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final Content f78971g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final Content f78972h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ Content[] f78973i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f78974j;

        static {
            Content content = new Content(ShareConstants.MEDIA, 0);
            f78966a = content;
            Content content2 = new Content("ADDRESS", 1);
            f78967b = content2;
            Content content3 = new Content("RATING", 2);
            f78968c = content3;
            Content content4 = new Content("PRICE", 3);
            f78969d = content4;
            Content content5 = new Content("TYPE", 4);
            f78970f = content5;
            Content content6 = new Content("ACCESSIBLE_ENTRANCE_ICON", 5);
            f78971g = content6;
            Content content7 = new Content("OPEN_NOW_STATUS", 6);
            f78972h = content7;
            Content[] contentArr = {content, content2, content3, content4, content5, content6, content7};
            f78973i = contentArr;
            f78974j = EnumEntriesKt.a(contentArr);
        }

        private Content(String str, int i3) {
        }

        public static EnumEntries a() {
            return f78974j;
        }

        public static Content valueOf(String str) {
            return (Content) Enum.valueOf(Content.class, str);
        }

        public static Content[] values() {
            return (Content[]) f78973i.clone();
        }
    }

    static /* synthetic */ Unit A(PlaceSearchFragment placeSearchFragment, List list) {
        zzqd zzqdVar = placeSearchFragment.f78953d;
        if (zzqdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentAdapter");
            zzqdVar = null;
        }
        Intrinsics.checkNotNull(list);
        zzqdVar.i(list);
        return Unit.f139807a;
    }

    static /* synthetic */ Unit B(PlaceSearchFragment placeSearchFragment, Exception exc) {
        ProgressBar progressBar = placeSearchFragment.f78954f;
        zzpw zzpwVar = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgressBar");
            progressBar = null;
        }
        progressBar.setVisibility(8);
        placeSearchFragment.L(null, placeSearchFragment.requireContext().getString(R.string.W0));
        PlaceSearchFragmentListener placeSearchFragmentListener = placeSearchFragment.f78956h;
        if (placeSearchFragmentListener != null) {
            Intrinsics.checkNotNull(exc);
            placeSearchFragmentListener.e(exc);
        }
        zzpw zzpwVar2 = placeSearchFragment.f78955g;
        if (zzpwVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
        } else {
            zzpwVar = zzpwVar2;
        }
        zzpwVar.e();
        return Unit.f139807a;
    }

    static /* synthetic */ Unit F(PlaceSearchFragment placeSearchFragment, List list, int i3) {
        PlaceSearchFragmentListener placeSearchFragmentListener = placeSearchFragment.f78956h;
        if (placeSearchFragmentListener != null) {
            placeSearchFragmentListener.c(M((Place) list.get(i3)));
        }
        zzpw zzpwVar = placeSearchFragment.f78955g;
        if (zzpwVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
            zzpwVar = null;
        }
        zzpwVar.d();
        return Unit.f139807a;
    }

    static /* synthetic */ void G(PlaceSearchFragment placeSearchFragment) {
        Parcelable parcelable = placeSearchFragment.f78957i;
        if (parcelable != null) {
            RecyclerView recyclerView = placeSearchFragment.f78951b;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                layoutManager.h1(parcelable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int H() {
        return ((Number) this.f78961m.a(this, f78949u[0])).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I() {
        Integer numU0;
        this.f78958j = true;
        List listMutableListOf = CollectionsKt.mutableListOf(zzpi.f78394b);
        List list = this.f78960l;
        zzqr zzqrVar = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list = null;
        }
        if (list.contains(Content.f78968c)) {
            zzqr zzqrVar2 = this.f78950a;
            if (zzqrVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                zzqrVar = zzqrVar2;
            }
            List list2 = (List) zzqrVar.z0().f();
            if (list2 != null) {
                List<Place> list3 = list2;
                if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                    for (Place place : list3) {
                        if (place.a0() != null && place.u0() != null && ((numU0 = place.u0()) == null || numU0.intValue() != 0)) {
                            listMutableListOf.add(zzpi.f78393a);
                            break;
                        }
                    }
                }
            }
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        zzpj zzpjVar = new zzpj(contextRequireContext, H(), listMutableListOf);
        zzpjVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.google.android.libraries.places.widget.zzap
            @Override // android.content.DialogInterface.OnDismissListener
            public final /* synthetic */ void onDismiss(DialogInterface dialogInterface) {
                this.f79426a.f78958j = false;
            }
        });
        zzpjVar.show();
    }

    private final void J(List list) {
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(M((Place) it.next()));
        }
        PlaceSearchFragmentListener placeSearchFragmentListener = this.f78956h;
        if (placeSearchFragmentListener != null) {
            placeSearchFragmentListener.d(arrayList);
        }
        zzpw zzpwVar = this.f78955g;
        if (zzpwVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
            zzpwVar = null;
        }
        zzpwVar.c();
    }

    private final void L(List list, String str) {
        View viewRequireView = requireView();
        int i3 = R.id.W0;
        LinearLayout linearLayout = (LinearLayout) viewRequireView.findViewById(i3);
        if (linearLayout != null) {
            linearLayout.setVisibility(this.f78964p == AttributionPosition.f79378a ? 0 : 8);
        }
        View viewRequireView2 = requireView();
        int i4 = R.id.V0;
        LinearLayout linearLayout2 = (LinearLayout) viewRequireView2.findViewById(i4);
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(this.f78964p == AttributionPosition.f79379b ? 0 : 8);
        }
        if (list == null || list.size() == 0) {
            View viewFindViewById = requireView().findViewById(R.id.f74705c1);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
            View viewFindViewById2 = requireView().findViewById(R.id.f74701b1);
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(8);
            }
        } else {
            View viewFindViewById3 = requireView().findViewById(R.id.f74705c1);
            if (viewFindViewById3 != null) {
                viewFindViewById3.setVisibility(this.f78964p == AttributionPosition.f79379b ? 0 : 8);
            }
            View viewFindViewById4 = requireView().findViewById(R.id.f74701b1);
            if (viewFindViewById4 != null) {
                viewFindViewById4.setVisibility(this.f78964p == AttributionPosition.f79378a ? 0 : 8);
            }
        }
        TextView textView = (TextView) requireView().findViewById(R.id.f74717f1);
        TextView textView2 = (TextView) requireView().findViewById(R.id.f74713e1);
        if (str == null) {
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        } else if (this.f78964p == AttributionPosition.f79378a) {
            if (textView != null) {
                textView.setText(str);
            } else {
                textView = null;
            }
            if (textView != null) {
                textView.setVisibility(0);
            }
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        } else {
            if (textView2 != null) {
                textView2.setText(str);
            } else {
                textView2 = null;
            }
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
        zzot zzotVar = zzot.f78364c;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        int iA = zzos.a(contextRequireContext, H());
        View viewFindViewById5 = requireView().findViewById(i3);
        View viewFindViewById6 = requireView().findViewById(i4);
        ImageView imageView = viewFindViewById5 != null ? (ImageView) viewFindViewById5.findViewById(R.id.f74697a1) : null;
        if (imageView != null) {
            imageView.setColorFilter(iA);
        }
        ImageView imageView2 = viewFindViewById6 != null ? (ImageView) viewFindViewById6.findViewById(R.id.f74697a1) : null;
        if (imageView2 != null) {
            imageView2.setColorFilter(iA);
        }
        ImageView imageView3 = viewFindViewById5 != null ? (ImageView) viewFindViewById5.findViewById(R.id.Z0) : null;
        if (imageView3 != null) {
            imageView3.setColorFilter(iA);
        }
        ImageView imageView4 = viewFindViewById6 != null ? (ImageView) viewFindViewById6.findViewById(R.id.Z0) : null;
        if (imageView4 != null) {
            imageView4.setColorFilter(iA);
        }
        View viewFindViewById7 = viewFindViewById5 != null ? viewFindViewById5.findViewById(R.id.Y0) : null;
        View viewFindViewById8 = viewFindViewById6 != null ? viewFindViewById6.findViewById(R.id.Y0) : null;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.zzaq
                @Override // android.view.View.OnClickListener
                public final /* synthetic */ void onClick(View view) {
                    this.f79427a.I();
                }
            });
        }
        if (viewFindViewById7 != null) {
            zzop.b(viewFindViewById7);
        }
        if (viewFindViewById8 != null) {
            viewFindViewById8.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.zzar
                @Override // android.view.View.OnClickListener
                public final /* synthetic */ void onClick(View view) {
                    this.f79428a.I();
                }
            });
        }
        if (viewFindViewById8 != null) {
            zzop.b(viewFindViewById8);
        }
    }

    private static final Place M(Place place) {
        Place.Builder builderC = Place.c();
        builderC.D(place.G());
        builderC.G(place.J());
        builderC.s0(place.w0());
        Place placeA = builderC.a();
        Intrinsics.checkNotNullExpressionValue(placeA, "build(...)");
        return placeA;
    }

    static /* synthetic */ Unit z(final PlaceSearchFragment placeSearchFragment, final List list) {
        ProgressBar progressBar;
        if (list.isEmpty()) {
            placeSearchFragment.L(null, placeSearchFragment.requireContext().getString(R.string.X0));
        } else {
            placeSearchFragment.L(list, null);
        }
        Intrinsics.checkNotNull(list);
        Orientation orientation = placeSearchFragment.f78959k;
        if (orientation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orientation");
            orientation = null;
        }
        Orientation orientation2 = Orientation.f79404b;
        if (orientation == orientation2) {
            placeSearchFragment.f78952c = new LinearLayoutManager(placeSearchFragment.getContext(), 1, false);
        } else {
            placeSearchFragment.f78952c = new LinearLayoutManager(placeSearchFragment.getContext(), 0, false);
        }
        RecyclerView recyclerView = placeSearchFragment.f78951b;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        LinearLayoutManager linearLayoutManager = placeSearchFragment.f78952c;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            linearLayoutManager = null;
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        Orientation orientation3 = orientation2;
        LifecycleCoroutineScope lifecycleCoroutineScopeA = LifecycleOwnerKt.a(placeSearchFragment);
        Orientation orientation4 = placeSearchFragment.f78959k;
        if (orientation4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orientation");
            orientation4 = null;
        }
        Orientation orientation5 = Orientation.f79403a;
        if (orientation4 != orientation5) {
            orientation3 = orientation5;
        }
        int iH = placeSearchFragment.H();
        MediaSize mediaSize = placeSearchFragment.f78965q;
        Parcelable.Creator<MediaSize> creator = MediaSize.CREATOR;
        Content content = Content.f78966a;
        Parcelable.Creator<AttributionPosition> creator2 = AttributionPosition.CREATOR;
        int iOrdinal = mediaSize.ordinal();
        int dimensionPixelSize = iOrdinal != 1 ? iOrdinal != 2 ? placeSearchFragment.requireContext().getResources().getDimensionPixelSize(R.dimen.f74682h) : placeSearchFragment.requireContext().getResources().getDimensionPixelSize(R.dimen.f74680f) : placeSearchFragment.requireContext().getResources().getDimensionPixelSize(R.dimen.f74681g);
        boolean z2 = placeSearchFragment.f78962n;
        boolean z3 = placeSearchFragment.f78963o;
        zzqr zzqrVar = placeSearchFragment.f78950a;
        if (zzqrVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzqrVar = null;
        }
        zzpt zzptVarD0 = zzqrVar.D0();
        ArrayList arrayList = new ArrayList();
        List list2 = placeSearchFragment.f78960l;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list2 = null;
        }
        if (list2.contains(Content.f78966a)) {
            arrayList.add(zzpx.f78430a);
        }
        List list3 = placeSearchFragment.f78960l;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list3 = null;
        }
        if (list3.contains(Content.f78967b)) {
            arrayList.add(zzpx.f78431b);
        }
        List list4 = placeSearchFragment.f78960l;
        if (list4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list4 = null;
        }
        if (list4.contains(Content.f78968c)) {
            arrayList.add(zzpx.f78432c);
        }
        List list5 = placeSearchFragment.f78960l;
        if (list5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list5 = null;
        }
        if (list5.contains(Content.f78969d)) {
            arrayList.add(zzpx.f78433d);
        }
        List list6 = placeSearchFragment.f78960l;
        if (list6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list6 = null;
        }
        if (list6.contains(Content.f78970f)) {
            arrayList.add(zzpx.f78434f);
        }
        List list7 = placeSearchFragment.f78960l;
        if (list7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list7 = null;
        }
        if (list7.contains(Content.f78971g)) {
            arrayList.add(zzpx.f78435g);
        }
        List list8 = placeSearchFragment.f78960l;
        if (list8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list8 = null;
        }
        if (list8.contains(Content.f78972h)) {
            arrayList.add(zzpx.f78436h);
        }
        placeSearchFragment.f78953d = new zzqd(lifecycleCoroutineScopeA, orientation3, iH, dimensionPixelSize, z2, z3, list, zzptVarD0, arrayList, new Function1() { // from class: com.google.android.libraries.places.widget.zzas
            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Object invoke(Object obj) {
                return PlaceSearchFragment.F(this.f79429a, list, ((Integer) obj).intValue());
            }
        });
        RecyclerView recyclerView2 = placeSearchFragment.f78951b;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        zzqd zzqdVar = placeSearchFragment.f78953d;
        if (zzqdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentAdapter");
            zzqdVar = null;
        }
        recyclerView2.setAdapter(zzqdVar);
        RecyclerView recyclerView3 = placeSearchFragment.f78951b;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setItemViewCacheSize(10);
        Orientation orientation6 = placeSearchFragment.f78959k;
        if (orientation6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orientation");
            orientation6 = null;
        }
        if (orientation6 == orientation5) {
            RecyclerView recyclerView4 = placeSearchFragment.f78951b;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView4 = null;
            }
            recyclerView4.j(new zzaw(placeSearchFragment));
        } else {
            int iD = MaterialColors.d(placeSearchFragment.requireView(), R.attr.f74653p);
            int dimensionPixelSize2 = placeSearchFragment.requireContext().getResources().getDimensionPixelSize(R.dimen.f74683i);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColors(new int[]{iD, iD});
            gradientDrawable.setSize(dimensionPixelSize2, dimensionPixelSize2);
            RecyclerView recyclerView5 = placeSearchFragment.f78951b;
            if (recyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView5 = null;
            }
            Context context = recyclerView5.getContext();
            LinearLayoutManager linearLayoutManager2 = placeSearchFragment.f78952c;
            if (linearLayoutManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
                linearLayoutManager2 = null;
            }
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context, linearLayoutManager2.q2());
            dividerItemDecoration.n(gradientDrawable);
            RecyclerView recyclerView6 = placeSearchFragment.f78951b;
            if (recyclerView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView6 = null;
            }
            recyclerView6.j(dividerItemDecoration);
        }
        RecyclerView recyclerView7 = placeSearchFragment.f78951b;
        if (recyclerView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView7 = null;
        }
        recyclerView7.post(new Runnable() { // from class: com.google.android.libraries.places.widget.zzat
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                PlaceSearchFragment.G(this.f79431a);
            }
        });
        RecyclerView recyclerView8 = placeSearchFragment.f78951b;
        if (recyclerView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView8 = null;
        }
        recyclerView8.n(new zzax(placeSearchFragment));
        ProgressBar progressBar2 = placeSearchFragment.f78954f;
        if (progressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgressBar");
            progressBar = null;
        } else {
            progressBar = progressBar2;
        }
        progressBar.setVisibility(8);
        placeSearchFragment.J(list);
        return Unit.f139807a;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Application application = requireActivity().getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        this.f78950a = (zzqr) new ViewModelProvider(this, zzqf.a(application)).a(zzqr.class);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Bundle bundleRequireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(bundleRequireArguments, "requireArguments(...)");
        Orientation orientation = (Orientation) zzou.a(bundleRequireArguments, "arg-orientation", Orientation.class);
        this.f78959k = orientation;
        if (orientation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orientation");
            orientation = null;
        }
        int i3 = orientation == Orientation.f79404b ? R.layout.f74811v : R.layout.f74810u;
        Bundle bundleRequireArguments2 = requireArguments();
        Intrinsics.checkNotNullExpressionValue(bundleRequireArguments2, "requireArguments(...)");
        this.f78960l = ((zzam) zzou.a(bundleRequireArguments2, "arg-content", zzam.class)).c();
        this.f78961m.b(this, f78949u[0], Integer.valueOf(requireArguments().getInt("arg-theme-res-id")));
        View viewInflate = inflater.cloneInContext(new ContextThemeWrapper(getContext(), H())).inflate(i3, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        zzamz zzamzVar;
        zzanj zzanjVar;
        zzanb zzanbVar;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            this.f78963o = bundle.getBoolean("arg-prefer-truncation");
            this.f78962n = bundle.getBoolean("arg-selectable");
            this.f78965q = (MediaSize) zzou.a(bundle, "arg-media-size", MediaSize.class);
            this.f78964p = (AttributionPosition) zzou.a(bundle, "arg-attribution-position", AttributionPosition.class);
            if (bundle.containsKey("arg-scroll-state")) {
                this.f78957i = zzou.a(bundle, "arg-scroll-state", Parcelable.class);
            }
            boolean z2 = bundle.getBoolean("arg-show-legal-disclosures");
            this.f78958j = z2;
            if (z2) {
                I();
            }
        }
        View viewFindViewById = view.findViewById(R.id.f74720g0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.f78954f = (ProgressBar) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.f74709d1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.f78951b = (RecyclerView) viewFindViewById2;
        Orientation orientation = this.f78959k;
        zzpw zzpwVar = null;
        if (orientation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orientation");
            orientation = null;
        }
        zzane zzaneVar = orientation == Orientation.f79404b ? zzane.ORIENTATION_VERTICAL : zzane.ORIENTATION_HORIZONTAL;
        List list = this.f78960l;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list = null;
        }
        List<Content> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Content content : list2) {
            Parcelable.Creator<MediaSize> creator = MediaSize.CREATOR;
            Content content2 = Content.f78966a;
            Parcelable.Creator<AttributionPosition> creator2 = AttributionPosition.CREATOR;
            switch (content.ordinal()) {
                case 0:
                    zzanbVar = zzanb.PHOTO;
                    break;
                case 1:
                    zzanbVar = zzanb.ADDRESS;
                    break;
                case 2:
                    zzanbVar = zzanb.RATING;
                    break;
                case 3:
                    zzanbVar = zzanb.PRICE;
                    break;
                case 4:
                    zzanbVar = zzanb.TYPE;
                    break;
                case 5:
                    zzanbVar = zzanb.ACCESSIBILITY;
                    break;
                case 6:
                    zzanbVar = zzanb.OPEN_NOW_STATUS;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            arrayList.add(zzanbVar);
        }
        boolean z3 = this.f78962n;
        boolean z4 = this.f78963o;
        MediaSize mediaSize = this.f78965q;
        Parcelable.Creator<MediaSize> creator3 = MediaSize.CREATOR;
        Content content3 = Content.f78966a;
        Parcelable.Creator<AttributionPosition> creator4 = AttributionPosition.CREATOR;
        int iOrdinal = mediaSize.ordinal();
        if (iOrdinal == 0) {
            zzamzVar = zzamz.SMALL;
        } else if (iOrdinal == 1) {
            zzamzVar = zzamz.MEDIUM;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            zzamzVar = zzamz.LARGE;
        }
        zzamz zzamzVar2 = zzamzVar;
        int iOrdinal2 = this.f78964p.ordinal();
        if (iOrdinal2 == 0) {
            zzanjVar = zzanj.POSITION_TOP;
        } else {
            if (iOrdinal2 != 1) {
                throw new NoWhenBranchMatchedException();
            }
            zzanjVar = zzanj.POSITION_BOTTOM;
        }
        zzanj zzanjVar2 = zzanjVar;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        zzpw zzpwVar2 = new zzpw(zzaneVar, arrayList, z3, z4, zzamzVar2, zzanjVar2, contextRequireContext, H());
        this.f78955g = zzpwVar2;
        zzqr zzqrVar = this.f78950a;
        if (zzqrVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzqrVar = null;
        }
        zzpt zzptVarD0 = zzqrVar.D0();
        zzpwVar2.a(zzptVarD0 != null ? zzptVarD0.zzd() : null);
        L(null, "");
        zzqr zzqrVar2 = this.f78950a;
        if (zzqrVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzqrVar2 = null;
        }
        zzqrVar2.z0().j(getViewLifecycleOwner(), new zzav(new Function1() { // from class: com.google.android.libraries.places.widget.zzau
            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Object invoke(Object obj) {
                return PlaceSearchFragment.z(this.f79432a, (List) obj);
            }
        }));
        zzqr zzqrVar3 = this.f78950a;
        if (zzqrVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzqrVar3 = null;
        }
        zzqrVar3.B0().j(getViewLifecycleOwner(), new zzav(new Function1() { // from class: com.google.android.libraries.places.widget.zzan
            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Object invoke(Object obj) {
                return PlaceSearchFragment.A(this.f79424a, (List) obj);
            }
        }));
        zzqr zzqrVar4 = this.f78950a;
        if (zzqrVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzqrVar4 = null;
        }
        zzqrVar4.A0().j(getViewLifecycleOwner(), new zzav(new Function1() { // from class: com.google.android.libraries.places.widget.zzao
            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Object invoke(Object obj) {
                return PlaceSearchFragment.B(this.f79425a, (Exception) obj);
            }
        }));
        if (bundle == null) {
            zzpw zzpwVar3 = this.f78955g;
            if (zzpwVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
            } else {
                zzpwVar = zzpwVar3;
            }
            zzpwVar.b();
        }
    }

    public final AttributionPosition w() {
        return this.f78964p;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putParcelable("arg-media-size", this.f78965q);
        outState.putParcelable("arg-attribution-position", this.f78964p);
        outState.putBoolean("arg-selectable", this.f78962n);
        outState.putBoolean("arg-prefer-truncation", this.f78963o);
        outState.putBoolean(tDEtWsFLJfe.RjyKzk, this.f78958j);
        RecyclerView recyclerView = this.f78951b;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Parcelable parcelableI1 = layoutManager != null ? layoutManager.i1() : null;
        if (parcelableI1 != null) {
            outState.putParcelable("arg-scroll-state", parcelableI1);
        }
    }
}
