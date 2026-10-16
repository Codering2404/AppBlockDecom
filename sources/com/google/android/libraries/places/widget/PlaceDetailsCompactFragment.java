package com.google.android.libraries.places.widget;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.share.internal.ShareConstants;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.zzamg;
import com.google.android.libraries.places.internal.zzamj;
import com.google.android.libraries.places.internal.zzaml;
import com.google.android.libraries.places.internal.zzop;
import com.google.android.libraries.places.internal.zzos;
import com.google.android.libraries.places.internal.zzot;
import com.google.android.libraries.places.internal.zzou;
import com.google.android.libraries.places.internal.zzpi;
import com.google.android.libraries.places.internal.zzpj;
import com.google.android.libraries.places.internal.zzpt;
import com.google.android.libraries.places.widget.internal.photoviewer.PlacesLightboxActivity;
import com.google.android.libraries.places.widget.internal.placedetails.zzbj;
import com.google.android.libraries.places.widget.internal.placedetails.zzbk;
import com.google.android.libraries.places.widget.internal.placedetails.zzbq;
import com.google.android.libraries.places.widget.model.Orientation;
import java.util.ArrayList;
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
public final class PlaceDetailsCompactFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private zzbj f78873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f78874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f78875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f78876d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f78877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImageView f78878g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f78879h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ProgressBar f78880i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextView f78881j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.google.android.libraries.places.widget.internal.placedetails.zzad f78882k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.google.android.libraries.places.widget.internal.placedetails.zzas f78883l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Orientation f78884m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private List f78885n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private com.google.android.libraries.places.widget.internal.placedetails.zzo f78886o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private List f78887p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ReadWriteProperty f78888q = Delegates.f140171a.a();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private PlaceLoadListener f78889r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f78890s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f78891t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f78892u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f78893v;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f78872z = {Reflection.e(new MutablePropertyReference1Impl(PlaceDetailsCompactFragment.class, "themeResId", "getThemeResId()I", 0))};

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Companion f78869w = new Companion(null);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final List f78870x = CollectionsKt.listOf((Object[]) new Content[]{Content.f78894a, Content.f78896c, Content.f78898f, Content.f78897d, Content.f78899g, Content.f78900h});

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final List f78871y = CollectionsKt.toList(Content.a());

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
        public static final Content f78894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Content f78895b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Content f78896c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Content f78897d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Content f78898f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final Content f78899g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final Content f78900h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ Content[] f78901i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f78902j;

        static {
            Content content = new Content(ShareConstants.MEDIA, 0);
            f78894a = content;
            Content content2 = new Content("ADDRESS", 1);
            f78895b = content2;
            Content content3 = new Content("RATING", 2);
            f78896c = content3;
            Content content4 = new Content("PRICE", 3);
            f78897d = content4;
            Content content5 = new Content("TYPE", 4);
            f78898f = content5;
            Content content6 = new Content("ACCESSIBLE_ENTRANCE_ICON", 5);
            f78899g = content6;
            Content content7 = new Content("OPEN_NOW_STATUS", 6);
            f78900h = content7;
            Content[] contentArr = {content, content2, content3, content4, content5, content6, content7};
            f78901i = contentArr;
            f78902j = EnumEntriesKt.a(contentArr);
        }

        private Content(String str, int i3) {
        }

        public static EnumEntries a() {
            return f78902j;
        }

        public static Content valueOf(String str) {
            return (Content) Enum.valueOf(Content.class, str);
        }

        public static Content[] values() {
            return (Content[]) f78901i.clone();
        }
    }

    static /* synthetic */ Unit C(PlaceDetailsCompactFragment placeDetailsCompactFragment, zzbq zzbqVar) {
        com.google.android.libraries.places.widget.internal.placedetails.zzas zzasVar;
        List listR;
        com.google.android.libraries.places.widget.internal.placedetails.zzas zzasVar2 = placeDetailsCompactFragment.f78883l;
        zzbj zzbjVar = null;
        if (zzasVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compactViewController");
            zzasVar = null;
        } else {
            zzasVar = zzasVar2;
        }
        Intrinsics.checkNotNull(zzbqVar);
        boolean z2 = placeDetailsCompactFragment.f78890s;
        List list = placeDetailsCompactFragment.f78885n;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list = null;
        }
        boolean zContains = list.contains(Content.f78894a);
        boolean z3 = placeDetailsCompactFragment.f78893v;
        zzbj zzbjVar2 = placeDetailsCompactFragment.f78873a;
        if (zzbjVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            zzbjVar = zzbjVar2;
        }
        Place place = (Place) zzbjVar.z0().f();
        int size = 0;
        if (place != null && (listR = place.R()) != null) {
            size = listR.size();
        }
        zzasVar.c(zzbqVar, z2, zContains, z3, size);
        return Unit.f139807a;
    }

    private final int D() {
        return ((Number) this.f78888q.a(this, f78872z[0])).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E() {
        Integer numU0;
        this.f78891t = true;
        List listMutableListOf = CollectionsKt.mutableListOf(zzpi.f78396d);
        List list = this.f78885n;
        zzbj zzbjVar = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list = null;
        }
        if (list.contains(Content.f78896c)) {
            zzbj zzbjVar2 = this.f78873a;
            if (zzbjVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                zzbjVar2 = null;
            }
            Place place = (Place) zzbjVar2.z0().f();
            if ((place != null ? place.a0() : null) != null) {
                zzbj zzbjVar3 = this.f78873a;
                if (zzbjVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    zzbjVar3 = null;
                }
                Place place2 = (Place) zzbjVar3.z0().f();
                if ((place2 != null ? place2.u0() : null) != null) {
                    zzbj zzbjVar4 = this.f78873a;
                    if (zzbjVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    } else {
                        zzbjVar = zzbjVar4;
                    }
                    Place place3 = (Place) zzbjVar.z0().f();
                    if (place3 == null || (numU0 = place3.u0()) == null || numU0.intValue() != 0) {
                        listMutableListOf.add(zzpi.f78393a);
                    }
                }
            }
        }
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        zzpj zzpjVar = new zzpj(contextRequireContext, D(), listMutableListOf);
        zzpjVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.google.android.libraries.places.widget.zzk
            @Override // android.content.DialogInterface.OnDismissListener
            public final /* synthetic */ void onDismiss(DialogInterface dialogInterface) {
                this.f79449a.f78891t = false;
            }
        });
        zzpjVar.show();
    }

    private final void F() {
        ImageView imageView = this.f78874b;
        com.google.android.libraries.places.widget.internal.placedetails.zzad zzadVar = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("image");
            imageView = null;
        }
        imageView.setVisibility(8);
        View view = this.f78875c;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageContainer");
            view = null;
        }
        view.setVisibility(8);
        TextView textView = this.f78876d;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("displayName");
            textView = null;
        }
        textView.setVisibility(8);
        TextView textView2 = this.f78877f;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(IntegrityManager.INTEGRITY_TYPE_ADDRESS);
            textView2 = null;
        }
        textView2.setVisibility(8);
        View view2 = this.f78879h;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("openInMaps");
            view2 = null;
        }
        view2.setVisibility(8);
        ProgressBar progressBar = this.f78880i;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgressBar");
            progressBar = null;
        }
        progressBar.setVisibility(8);
        TextView textView3 = this.f78881j;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingFailedMessage");
            textView3 = null;
        }
        textView3.setVisibility(8);
        com.google.android.libraries.places.widget.internal.placedetails.zzad zzadVar2 = this.f78882k;
        if (zzadVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("metadataViewController");
        } else {
            zzadVar = zzadVar2;
        }
        zzadVar.c();
    }

    public static final /* synthetic */ void w(final PlaceDetailsCompactFragment placeDetailsCompactFragment, Place place) {
        com.google.android.libraries.places.widget.internal.placedetails.zzad zzadVar;
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar;
        ProgressBar progressBar = placeDetailsCompactFragment.f78880i;
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar2 = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgressBar");
            progressBar = null;
        }
        progressBar.setVisibility(8);
        com.google.android.libraries.places.widget.internal.placedetails.zzas zzasVar = placeDetailsCompactFragment.f78883l;
        if (zzasVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compactViewController");
            zzasVar = null;
        }
        boolean z2 = placeDetailsCompactFragment.f78892u;
        List list = placeDetailsCompactFragment.f78885n;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list = null;
        }
        zzasVar.b(place, z2, list.contains(Content.f78895b));
        com.google.android.libraries.places.widget.internal.placedetails.zzad zzadVar2 = placeDetailsCompactFragment.f78882k;
        if (zzadVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("metadataViewController");
            zzadVar = null;
        } else {
            zzadVar = zzadVar2;
        }
        List list2 = placeDetailsCompactFragment.f78885n;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list2 = null;
        }
        boolean zContains = list2.contains(Content.f78896c);
        List list3 = placeDetailsCompactFragment.f78885n;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list3 = null;
        }
        boolean zContains2 = list3.contains(Content.f78898f);
        List list4 = placeDetailsCompactFragment.f78885n;
        if (list4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list4 = null;
        }
        boolean zContains3 = list4.contains(Content.f78897d);
        List list5 = placeDetailsCompactFragment.f78885n;
        if (list5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list5 = null;
        }
        boolean zContains4 = list5.contains(Content.f78899g);
        List list6 = placeDetailsCompactFragment.f78885n;
        if (list6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list6 = null;
        }
        boolean zContains5 = list6.contains(Content.f78900h);
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar3 = placeDetailsCompactFragment.f78886o;
        if (zzoVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
            zzoVar = null;
        } else {
            zzoVar = zzoVar3;
        }
        zzadVar.a(place, zContains, zContains2, zContains3, zContains4, zContains5, zzoVar);
        com.google.android.libraries.places.widget.internal.placedetails.zzad zzadVar3 = placeDetailsCompactFragment.f78882k;
        if (zzadVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("metadataViewController");
            zzadVar3 = null;
        }
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar4 = placeDetailsCompactFragment.f78886o;
        if (zzoVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
            zzoVar4 = null;
        }
        zzadVar3.b(place, zzoVar4);
        if (placeDetailsCompactFragment.f78893v) {
            ImageView imageView = placeDetailsCompactFragment.f78874b;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("image");
                imageView = null;
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.zzj
                @Override // android.view.View.OnClickListener
                public final /* synthetic */ void onClick(View view) {
                    PlaceDetailsCompactFragment.z(this.f79448a, view);
                }
            });
        } else {
            ImageView imageView2 = placeDetailsCompactFragment.f78874b;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("image");
                imageView2 = null;
            }
            imageView2.setOnClickListener(null);
        }
        Place.Builder builderC = Place.c();
        builderC.D(place.G());
        builderC.s0(place.w0());
        builderC.G(place.J());
        Place placeA = builderC.a();
        PlaceLoadListener placeLoadListener = placeDetailsCompactFragment.f78889r;
        if (placeLoadListener != null) {
            Intrinsics.checkNotNull(placeA);
            placeLoadListener.a(placeA);
        }
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar5 = placeDetailsCompactFragment.f78886o;
        if (zzoVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
        } else {
            zzoVar2 = zzoVar5;
        }
        Context contextRequireContext = placeDetailsCompactFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        zzoVar2.d(contextRequireContext);
    }

    public static final /* synthetic */ void x(PlaceDetailsCompactFragment placeDetailsCompactFragment, Exception exc) {
        ProgressBar progressBar = placeDetailsCompactFragment.f78880i;
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgressBar");
            progressBar = null;
        }
        progressBar.setVisibility(8);
        ImageView imageView = placeDetailsCompactFragment.f78874b;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("image");
            imageView = null;
        }
        imageView.setVisibility(8);
        TextView textView = placeDetailsCompactFragment.f78881j;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingFailedMessage");
            textView = null;
        }
        textView.setVisibility(0);
        PlaceLoadListener placeLoadListener = placeDetailsCompactFragment.f78889r;
        if (placeLoadListener != null) {
            placeLoadListener.onFailure(exc);
        }
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar2 = placeDetailsCompactFragment.f78886o;
        if (zzoVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
        } else {
            zzoVar = zzoVar2;
        }
        Context contextRequireContext = placeDetailsCompactFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        zzoVar.e(contextRequireContext);
    }

    static /* synthetic */ void y(final PlaceDetailsCompactFragment placeDetailsCompactFragment, View view) {
        Orientation orientation = placeDetailsCompactFragment.f78884m;
        zzbj zzbjVar = null;
        if (orientation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orientation");
            orientation = null;
        }
        if (orientation == Orientation.f79403a) {
            placeDetailsCompactFragment.f78890s = ((float) view.getMeasuredWidth()) / placeDetailsCompactFragment.requireContext().getResources().getDisplayMetrics().density >= 350.0f;
        } else {
            placeDetailsCompactFragment.f78890s = true;
        }
        zzbj zzbjVar2 = placeDetailsCompactFragment.f78873a;
        if (zzbjVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzbjVar2 = null;
        }
        zzbjVar2.z0().j(placeDetailsCompactFragment.getViewLifecycleOwner(), new zzq(new zzo(placeDetailsCompactFragment)));
        zzbj zzbjVar3 = placeDetailsCompactFragment.f78873a;
        if (zzbjVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzbjVar3 = null;
        }
        zzbjVar3.A0().j(placeDetailsCompactFragment.getViewLifecycleOwner(), new zzq(new zzp(placeDetailsCompactFragment)));
        zzbj zzbjVar4 = placeDetailsCompactFragment.f78873a;
        if (zzbjVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            zzbjVar = zzbjVar4;
        }
        ((LiveData) zzbjVar.B0().get(0)).j(placeDetailsCompactFragment.getViewLifecycleOwner(), new zzq(new Function1() { // from class: com.google.android.libraries.places.widget.zzm
            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Object invoke(Object obj) {
                return PlaceDetailsCompactFragment.C(this.f79451a, (zzbq) obj);
            }
        }));
    }

    static /* synthetic */ void z(PlaceDetailsCompactFragment placeDetailsCompactFragment, View view) {
        zzbj zzbjVar = placeDetailsCompactFragment.f78873a;
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar = null;
        if (zzbjVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzbjVar = null;
        }
        ArrayList arrayListH0 = zzbjVar.H0();
        if (arrayListH0.isEmpty()) {
            return;
        }
        FragmentActivity fragmentActivityRequireActivity = placeDetailsCompactFragment.requireActivity();
        PlacesLightboxActivity.Companion companion = PlacesLightboxActivity.f79083k;
        Context contextRequireContext = placeDetailsCompactFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        com.google.android.libraries.places.widget.internal.photoviewer.zzo zzoVar2 = new com.google.android.libraries.places.widget.internal.photoviewer.zzo(arrayListH0);
        int iD = placeDetailsCompactFragment.D();
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar3 = placeDetailsCompactFragment.f78886o;
        if (zzoVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
            zzoVar3 = null;
        }
        fragmentActivityRequireActivity.startActivity(PlacesLightboxActivity.Companion.a(contextRequireContext, 0, zzoVar2, iD, zzoVar3));
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar4 = placeDetailsCompactFragment.f78886o;
        if (zzoVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
        } else {
            zzoVar = zzoVar4;
        }
        Context contextRequireContext2 = placeDetailsCompactFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        zzoVar.h(contextRequireContext2);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Application application = requireActivity().getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        this.f78873a = (zzbj) new ViewModelProvider(this, com.google.android.libraries.places.widget.internal.placedetails.zzau.a(application)).a(zzbj.class);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Bundle bundleRequireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(bundleRequireArguments, "requireArguments(...)");
        Orientation orientation = (Orientation) zzou.a(bundleRequireArguments, "arg-orientation", Orientation.class);
        this.f78884m = orientation;
        List list = null;
        if (orientation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orientation");
            orientation = null;
        }
        int i3 = orientation == Orientation.f79404b ? R.layout.f74805p : R.layout.f74804o;
        Bundle bundleRequireArguments2 = requireArguments();
        Intrinsics.checkNotNullExpressionValue(bundleRequireArguments2, "requireArguments(...)");
        this.f78885n = ((zzi) zzou.a(bundleRequireArguments2, "arg-content", zzi.class)).c();
        zzbk zzbkVar = new zzbk();
        List list2 = this.f78885n;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list2 = null;
        }
        if (list2.contains(Content.f78894a)) {
            zzbkVar.a();
        }
        List list3 = this.f78885n;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list3 = null;
        }
        if (list3.contains(Content.f78895b)) {
            zzbkVar.b();
        }
        List list4 = this.f78885n;
        if (list4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list4 = null;
        }
        if (list4.contains(Content.f78896c)) {
            zzbkVar.c();
        }
        List list5 = this.f78885n;
        if (list5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list5 = null;
        }
        if (list5.contains(Content.f78897d)) {
            zzbkVar.d();
        }
        List list6 = this.f78885n;
        if (list6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list6 = null;
        }
        if (list6.contains(Content.f78898f)) {
            zzbkVar.e();
        }
        List list7 = this.f78885n;
        if (list7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list7 = null;
        }
        if (list7.contains(Content.f78899g)) {
            zzbkVar.f();
        }
        List list8 = this.f78885n;
        if (list8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
        } else {
            list = list8;
        }
        if (list.contains(Content.f78900h)) {
            zzbkVar.g();
        }
        this.f78887p = zzbkVar.q();
        this.f78888q.b(this, f78872z[0], Integer.valueOf(requireArguments().getInt("arg-theme-res-id")));
        View viewInflate = inflater.cloneInContext(new ContextThemeWrapper(getContext(), D())).inflate(i3, viewGroup, false);
        Intrinsics.checkNotNull(viewInflate);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean("arg-show-legal-disclosures", this.f78891t);
        outState.putBoolean("arg-enable-lightbox", this.f78893v);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(final View view, Bundle bundle) {
        Orientation orientation;
        zzamg zzamgVar;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            this.f78891t = bundle.getBoolean("arg-show-legal-disclosures");
            this.f78893v = bundle.getBoolean("arg-enable-lightbox");
            if (this.f78891t) {
                E();
            }
        }
        View viewFindViewById = view.findViewById(R.id.E0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.f78874b = (ImageView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.L0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.f78875c = viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.M0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.f78876d = (TextView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.f74776v0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.f78877f = (TextView) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.f74696a0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.f78878g = (ImageView) viewFindViewById5;
        View viewFindViewById6 = view.findViewById(R.id.f74748n0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.f78879h = viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.f74720g0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.f78880i = (ProgressBar) viewFindViewById7;
        View viewFindViewById8 = view.findViewById(R.id.f74712e0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.f78881j = (TextView) viewFindViewById8;
        zzot zzotVar = zzot.f78364c;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        int iA = zzos.a(contextRequireContext, D());
        TextView textView = (TextView) view.findViewById(R.id.f74785y0);
        textView.setTextColor(iA);
        int lineHeight = textView.getLineHeight();
        ImageView imageView = this.f78878g;
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("legalDisclosuresIcon");
            imageView = null;
        }
        imageView.getLayoutParams().height = lineHeight;
        ImageView imageView2 = this.f78878g;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("legalDisclosuresIcon");
            imageView2 = null;
        }
        imageView2.getLayoutParams().width = lineHeight;
        ImageView imageView3 = this.f78878g;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("legalDisclosuresIcon");
            imageView3 = null;
        }
        imageView3.setColorFilter(iA);
        ImageView imageView4 = this.f78878g;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("legalDisclosuresIcon");
            imageView4 = null;
        }
        imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.zzl
            @Override // android.view.View.OnClickListener
            public final /* synthetic */ void onClick(View view2) {
                this.f79450a.E();
            }
        });
        ImageView imageView5 = this.f78878g;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("legalDisclosuresIcon");
            imageView5 = null;
        }
        View viewRequireView = requireView();
        Intrinsics.checkNotNullExpressionValue(viewRequireView, "requireView(...)");
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        zzop.a(imageView5, viewRequireView, contextRequireContext2, 48, 24);
        Context contextRequireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
        int iD = D();
        zzbj zzbjVar = this.f78873a;
        if (zzbjVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzbjVar = null;
        }
        zzpt zzptVarD0 = zzbjVar.D0();
        this.f78882k = new com.google.android.libraries.places.widget.internal.placedetails.zzad(view, contextRequireContext3, iD, zzptVarD0 != null ? zzptVarD0.zzb() : null, com.google.android.libraries.places.widget.internal.placedetails.zzab.f79142a);
        zzbj zzbjVar2 = this.f78873a;
        if (zzbjVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzbjVar2 = null;
        }
        zzpt zzptVarD02 = zzbjVar2.D0();
        LifecycleCoroutineScope lifecycleCoroutineScopeA = LifecycleOwnerKt.a(this);
        int iD2 = D();
        Orientation orientation2 = this.f78884m;
        if (orientation2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orientation");
            orientation = null;
        } else {
            orientation = orientation2;
        }
        com.google.android.libraries.places.widget.internal.placedetails.zzas zzasVar = new com.google.android.libraries.places.widget.internal.placedetails.zzas(view, zzptVarD02, lifecycleCoroutineScopeA, iD2, orientation);
        this.f78883l = zzasVar;
        zzasVar.a();
        F();
        zzaml zzamlVar = zzaml.VARIANT_COMPACT;
        Orientation orientation3 = this.f78884m;
        if (orientation3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orientation");
            orientation3 = null;
        }
        zzamj zzamjVar = orientation3 == Orientation.f79404b ? zzamj.ORIENTATION_VERTICAL : zzamj.ORIENTATION_HORIZONTAL;
        List list = this.f78885n;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list = null;
        }
        List<Content> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Content content : list2) {
            Content content2 = Content.f78894a;
            switch (content.ordinal()) {
                case 0:
                    zzamgVar = zzamg.PHOTO;
                    break;
                case 1:
                    zzamgVar = zzamg.ADDRESS;
                    break;
                case 2:
                    zzamgVar = zzamg.RATING;
                    break;
                case 3:
                    zzamgVar = zzamg.PRICE;
                    break;
                case 4:
                    zzamgVar = zzamg.TYPE;
                    break;
                case 5:
                    zzamgVar = zzamg.ACCESSIBILITY;
                    break;
                case 6:
                    zzamgVar = zzamg.OPEN_NOW_STATUS;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            arrayList.add(zzamgVar);
        }
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar2 = new com.google.android.libraries.places.widget.internal.placedetails.zzo(zzamlVar, zzamjVar, arrayList, D());
        this.f78886o = zzoVar2;
        zzbj zzbjVar3 = this.f78873a;
        if (zzbjVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzbjVar3 = null;
        }
        zzoVar2.a(zzbjVar3.G0());
        view.post(new Runnable() { // from class: com.google.android.libraries.places.widget.zzn
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                PlaceDetailsCompactFragment.y(this.f79452a, view);
            }
        });
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar3 = this.f78886o;
        if (zzoVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
        } else {
            zzoVar = zzoVar3;
        }
        Context contextRequireContext4 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
        zzoVar.c(contextRequireContext4);
    }
}
