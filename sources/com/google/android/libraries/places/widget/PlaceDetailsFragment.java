package com.google.android.libraries.places.widget;

import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.share.internal.ShareConstants;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.GenerativeSummary;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.zzamg;
import com.google.android.libraries.places.internal.zzamj;
import com.google.android.libraries.places.internal.zzaml;
import com.google.android.libraries.places.internal.zzos;
import com.google.android.libraries.places.internal.zzot;
import com.google.android.libraries.places.internal.zzou;
import com.google.android.libraries.places.internal.zzpl;
import com.google.android.libraries.places.internal.zzpt;
import com.google.android.libraries.places.widget.internal.photoviewer.PlacesLightboxActivity;
import com.google.android.libraries.places.widget.internal.placedetails.zzbj;
import com.google.android.libraries.places.widget.internal.placedetails.zzbk;
import com.google.android.libraries.places.widget.internal.placedetails.zzbl;
import com.google.android.libraries.places.widget.internal.placedetails.zzbm;
import com.google.android.libraries.places.widget.internal.placedetails.zzbn;
import com.google.android.libraries.places.widget.internal.placedetails.zzbo;
import com.google.android.libraries.places.widget.internal.placedetails.zzbp;
import com.google.android.libraries.places.widget.internal.placedetails.zzbq;
import com.google.android.libraries.places.widget.internal.placedetails.zzck;
import com.google.android.libraries.places.widget.model.Orientation;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

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
public final class PlaceDetailsFragment extends Fragment {
    private Orientation A;
    private List B;
    private com.google.android.libraries.places.widget.internal.placedetails.zzo C;
    private List D;
    private zzbj E;
    private PlaceLoadListener F;
    private boolean H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f78903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f78904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ImageView f78905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ImageView f78906d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f78907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f78908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f78909h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f78910i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextView f78911j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ImageButton f78912k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View f78913l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private TabLayout f78914m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private View f78915n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ViewPager2 f78916o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private zzck f78917p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ProgressBar f78918q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private TextView f78919r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private com.google.android.libraries.places.widget.internal.placedetails.zzad f78920s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private ImageView f78921t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private ImageView f78922u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private TextView f78923v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private View f78924w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private View f78925x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private View f78926y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private View f78927z;
    static final /* synthetic */ KProperty[] M = {Reflection.e(new MutablePropertyReference1Impl(PlaceDetailsFragment.class, "themeResId", "getThemeResId()I", 0))};
    public static final Companion J = new Companion(null);
    private static final Uri N = Uri.parse("https://support.google.com/local-listings/answer/9851099");
    public static final List K = CollectionsKt.listOf((Object[]) new Content[]{Content.f78928a, Content.f78929b, Content.f78930c, Content.f78932f, Content.f78931d, Content.f78933g, Content.f78935i, Content.f78936j, Content.f78937k, Content.f78938l, Content.f78939m, Content.f78940n, Content.f78942p});
    public static final List L = CollectionsKt.toList(Content.a());
    private final ReadWriteProperty G = Delegates.f140171a.a();
    private final View.OnClickListener I = new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.zzae
        @Override // android.view.View.OnClickListener
        public final /* synthetic */ void onClick(View view) {
            PlaceDetailsFragment.E(this.f79415a, view);
        }
    };

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
        public static final Content f78928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Content f78929b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Content f78930c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Content f78931d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Content f78932f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final Content f78933g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final Content f78934h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final Content f78935i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final Content f78936j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final Content f78937k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final Content f78938l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final Content f78939m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final Content f78940n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final Content f78941o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final Content f78942p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final Content f78943q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private static final /* synthetic */ Content[] f78944r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f78945s;

        static {
            Content content = new Content(ShareConstants.MEDIA, 0);
            f78928a = content;
            Content content2 = new Content("ADDRESS", 1);
            f78929b = content2;
            Content content3 = new Content("RATING", 2);
            f78930c = content3;
            Content content4 = new Content("PRICE", 3);
            f78931d = content4;
            Content content5 = new Content("TYPE", 4);
            f78932f = content5;
            Content content6 = new Content("ACCESSIBLE_ENTRANCE_ICON", 5);
            f78933g = content6;
            Content content7 = new Content("OPEN_NOW_STATUS", 6);
            f78934h = content7;
            Content content8 = new Content("SUMMARY", 7);
            f78935i = content8;
            Content content9 = new Content("OPENING_HOURS", 8);
            f78936j = content9;
            Content content10 = new Content("WEBSITE", 9);
            f78937k = content10;
            Content content11 = new Content("PHONE_NUMBER", 10);
            f78938l = content11;
            Content content12 = new Content("TYPE_SPECIFIC_HIGHLIGHTS", 11);
            f78939m = content12;
            Content content13 = new Content("REVIEWS", 12);
            f78940n = content13;
            Content content14 = new Content("PLUS_CODE", 13);
            f78941o = content14;
            Content content15 = new Content("FEATURES", 14);
            f78942p = content15;
            Content content16 = new Content("GENERATIVE_SUMMARY", 15);
            f78943q = content16;
            Content[] contentArr = {content, content2, content3, content4, content5, content6, content7, content8, content9, content10, content11, content12, content13, content14, content15, content16};
            f78944r = contentArr;
            f78945s = EnumEntriesKt.a(contentArr);
        }

        private Content(String str, int i3) {
        }

        public static EnumEntries a() {
            return f78945s;
        }

        public static Content valueOf(String str) {
            return (Content) Enum.valueOf(Content.class, str);
        }

        public static Content[] values() {
            return (Content[]) f78944r.clone();
        }
    }

    public static final /* synthetic */ void A(PlaceDetailsFragment placeDetailsFragment, Exception exc) {
        ProgressBar progressBar = placeDetailsFragment.f78918q;
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgressBar");
            progressBar = null;
        }
        progressBar.setVisibility(8);
        View view = placeDetailsFragment.f78903a;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("collageLayout");
            view = null;
        }
        view.setVisibility(8);
        TextView textView = placeDetailsFragment.f78919r;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingFailedMessage");
            textView = null;
        }
        textView.setVisibility(0);
        PlaceLoadListener placeLoadListener = placeDetailsFragment.F;
        if (placeLoadListener != null) {
            placeLoadListener.onFailure(exc);
        }
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar2 = placeDetailsFragment.C;
        if (zzoVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
        } else {
            zzoVar = zzoVar2;
        }
        Context contextRequireContext = placeDetailsFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        zzoVar.e(contextRequireContext);
    }

    public static final /* synthetic */ void D(PlaceDetailsFragment placeDetailsFragment, ImageView imageView) {
        ImageView imageView2 = placeDetailsFragment.f78904b;
        View view = null;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("image");
            imageView2 = null;
        }
        if (Intrinsics.areEqual(imageView, imageView2)) {
            View view2 = placeDetailsFragment.f78925x;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadFailureUi");
            } else {
                view = view2;
            }
            view.setVisibility(0);
            return;
        }
        ImageView imageView3 = placeDetailsFragment.f78905c;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("image2");
            imageView3 = null;
        }
        if (Intrinsics.areEqual(imageView, imageView3)) {
            View view3 = placeDetailsFragment.f78926y;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("image2CardView");
            } else {
                view = view3;
            }
            view.setVisibility(8);
            return;
        }
        ImageView imageView4 = placeDetailsFragment.f78906d;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("image3");
            imageView4 = null;
        }
        if (Intrinsics.areEqual(imageView, imageView4)) {
            View view4 = placeDetailsFragment.f78927z;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("image3CardView");
            } else {
                view = view4;
            }
            view.setVisibility(8);
        }
    }

    static /* synthetic */ void E(PlaceDetailsFragment placeDetailsFragment, View view) {
        ImageView imageView = placeDetailsFragment.f78904b;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("image");
            imageView = null;
        }
        if (Intrinsics.areEqual(view, imageView)) {
            placeDetailsFragment.U(0);
            return;
        }
        ImageView imageView3 = placeDetailsFragment.f78905c;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("image2");
            imageView3 = null;
        }
        if (Intrinsics.areEqual(view, imageView3)) {
            placeDetailsFragment.U(1);
            return;
        }
        ImageView imageView4 = placeDetailsFragment.f78906d;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("image3");
        } else {
            imageView2 = imageView4;
        }
        if (Intrinsics.areEqual(view, imageView2)) {
            placeDetailsFragment.U(2);
        }
    }

    static /* synthetic */ Unit G(PlaceDetailsFragment placeDetailsFragment, Unit unit) {
        placeDetailsFragment.y();
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ kotlin.Unit H(com.google.android.libraries.places.widget.PlaceDetailsFragment r8, com.google.android.libraries.places.widget.internal.placedetails.zzbq r9) {
        /*
            com.google.android.libraries.places.widget.internal.placedetails.zzbj r0 = r8.E
            java.lang.String r1 = "viewModel"
            r2 = 0
            if (r0 != 0) goto Lb
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        Lb:
            androidx.lifecycle.LiveData r0 = r0.z0()
            java.lang.Object r0 = r0.f()
            com.google.android.libraries.places.api.model.Place r0 = (com.google.android.libraries.places.api.model.Place) r0
            r3 = 0
            if (r0 == 0) goto L23
            java.util.List r0 = r0.R()
            if (r0 == 0) goto L23
            int r0 = r0.size()
            goto L24
        L23:
            r0 = r3
        L24:
            java.lang.String r4 = "numberOfPhotosChip"
            if (r0 == 0) goto L72
            com.google.android.libraries.places.widget.internal.placedetails.zzbj r5 = r8.E
            if (r5 != 0) goto L30
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r5 = r2
        L30:
            java.util.List r1 = r5.B0()
            java.lang.Object r1 = r1.get(r3)
            androidx.lifecycle.LiveData r1 = (androidx.lifecycle.LiveData) r1
            java.lang.Object r1 = r1.f()
            com.google.android.libraries.places.widget.internal.placedetails.zzbn r5 = com.google.android.libraries.places.widget.internal.placedetails.zzbn.f79275a
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r5)
            if (r1 == 0) goto L47
            goto L72
        L47:
            android.widget.TextView r1 = r8.f78923v
            if (r1 != 0) goto L51
            java.lang.String r1 = "numberOfPhotosChipLabel"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r1 = r2
        L51:
            android.content.res.Resources r5 = r8.getResources()
            int r6 = com.google.android.libraries.places.R.plurals.f74819a
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
            java.lang.Object[] r7 = new java.lang.Object[]{r7}
            java.lang.String r0 = r5.getQuantityString(r6, r0, r7)
            r1.setText(r0)
            android.view.View r0 = r8.f78924w
            if (r0 != 0) goto L6e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r2
        L6e:
            r0.setVisibility(r3)
            goto L7f
        L72:
            android.view.View r0 = r8.f78924w
            if (r0 != 0) goto L7a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r0 = r2
        L7a:
            r1 = 8
            r0.setVisibility(r1)
        L7f:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            android.widget.ImageView r0 = r8.f78904b
            java.lang.String r1 = "image"
            if (r0 != 0) goto L8c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L8c:
            android.view.View r3 = r8.f78903a
            if (r3 != 0) goto L96
            java.lang.String r3 = "collageLayout"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r3 = r2
        L96:
            android.widget.ImageView r4 = r8.f78904b
            if (r4 != 0) goto L9e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L9f
        L9e:
            r2 = r4
        L9f:
            android.view.ViewParent r1 = r2.getParent()
            java.lang.String r2 = "null cannot be cast to non-null type android.view.View"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
            android.view.View r1 = (android.view.View) r1
            android.view.View[] r1 = new android.view.View[]{r3, r1}
            r8.w(r9, r0, r1)
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.widget.PlaceDetailsFragment.H(com.google.android.libraries.places.widget.PlaceDetailsFragment, com.google.android.libraries.places.widget.internal.placedetails.zzbq):kotlin.Unit");
    }

    static /* synthetic */ Unit I(PlaceDetailsFragment placeDetailsFragment, zzbq zzbqVar) {
        Intrinsics.checkNotNull(zzbqVar);
        ImageView imageView = placeDetailsFragment.f78905c;
        View view = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("image2");
            imageView = null;
        }
        View view2 = placeDetailsFragment.f78926y;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("image2CardView");
        } else {
            view = view2;
        }
        placeDetailsFragment.w(zzbqVar, imageView, view);
        return Unit.f139807a;
    }

    static /* synthetic */ Unit J(PlaceDetailsFragment placeDetailsFragment, zzbq zzbqVar) {
        Intrinsics.checkNotNull(zzbqVar);
        ImageView imageView = placeDetailsFragment.f78906d;
        View view = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("image3");
            imageView = null;
        }
        View view2 = placeDetailsFragment.f78927z;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("image3CardView");
        } else {
            view = view2;
        }
        placeDetailsFragment.w(zzbqVar, imageView, view);
        return Unit.f139807a;
    }

    static /* synthetic */ void L(final PlaceDetailsFragment placeDetailsFragment, View view) {
        Intrinsics.checkNotNull(view);
        PopupMenu popupMenu = new PopupMenu(new ContextThemeWrapper(placeDetailsFragment.requireContext(), placeDetailsFragment.R()), view);
        popupMenu.getMenuInflater().inflate(R.menu.f74816a, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.google.android.libraries.places.widget.zzaa
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final /* synthetic */ boolean onMenuItemClick(MenuItem menuItem) {
                return PlaceDetailsFragment.M(this.f79408a, menuItem);
            }
        });
        popupMenu.show();
    }

    static /* synthetic */ boolean M(PlaceDetailsFragment placeDetailsFragment, MenuItem menuItem) {
        GenerativeSummary generativeSummaryX;
        Uri uriF;
        int itemId = menuItem.getItemId();
        if (itemId == R.id.f74695a) {
            placeDetailsFragment.S(N);
            return true;
        }
        if (itemId != R.id.R1) {
            return false;
        }
        zzbj zzbjVar = placeDetailsFragment.E;
        if (zzbjVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzbjVar = null;
        }
        Place place = (Place) zzbjVar.z0().f();
        if (place != null && (generativeSummaryX = place.x()) != null && (uriF = generativeSummaryX.f()) != null) {
            placeDetailsFragment.S(uriF);
        }
        return true;
    }

    static /* synthetic */ void O(PlaceDetailsFragment placeDetailsFragment, zzbq zzbqVar, ImageView imageView, View[] viewArr) {
        List list = placeDetailsFragment.B;
        Orientation orientation = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list = null;
        }
        if (list.contains(Content.f78928a)) {
            if (zzbqVar instanceof zzbm) {
                placeDetailsFragment.x(imageView, true);
                for (View view : viewArr) {
                    view.setVisibility(0);
                }
                BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(placeDetailsFragment), null, null, new zzak(placeDetailsFragment, zzbqVar, imageView, null), 3, null);
                return;
            }
            if (zzbqVar instanceof zzbn) {
                for (View view2 : viewArr) {
                    view2.setVisibility(0);
                }
                imageView.setImageDrawable(placeDetailsFragment.getResources().getDrawable(R.drawable.f74688d, new ContextThemeWrapper(placeDetailsFragment.requireContext(), placeDetailsFragment.R()).getTheme()));
                return;
            }
            if (zzbqVar instanceof zzbo) {
                for (View view3 : viewArr) {
                    view3.setVisibility(8);
                }
                return;
            }
            if (!(zzbqVar instanceof zzbp) && !(zzbqVar instanceof zzbl)) {
                throw new NoWhenBranchMatchedException();
            }
            Orientation orientation2 = placeDetailsFragment.A;
            if (orientation2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("orientation");
            } else {
                orientation = orientation2;
            }
            imageView.setImageDrawable(placeDetailsFragment.getResources().getDrawable(orientation == Orientation.f79403a ? R.drawable.f74689e : R.drawable.f74690f, placeDetailsFragment.requireContext().getTheme()));
            placeDetailsFragment.x(imageView, false);
        }
    }

    static /* synthetic */ void P(PlaceDetailsFragment placeDetailsFragment, TabLayout.Tab tab, int i3) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        zzck zzckVar = placeDetailsFragment.f78917p;
        String string = null;
        if (zzckVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            zzckVar = null;
        }
        int itemViewType = zzckVar.getItemViewType(i3);
        if (itemViewType == 1) {
            string = placeDetailsFragment.getString(R.string.f74865p0);
        } else if (itemViewType == 2) {
            string = placeDetailsFragment.getString(R.string.O0);
        } else if (itemViewType == 3) {
            string = placeDetailsFragment.getString(R.string.D);
        }
        tab.r(string);
    }

    static /* synthetic */ void Q(View view, PlaceDetailsFragment placeDetailsFragment) {
        view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        ViewPager2 viewPager2 = placeDetailsFragment.f78916o;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        if (viewPager2.getLayoutParams().height != view.getMeasuredHeight()) {
            ViewPager2 viewPager23 = placeDetailsFragment.f78916o;
            if (viewPager23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                viewPager23 = null;
            }
            ViewGroup.LayoutParams layoutParams = viewPager23.getLayoutParams();
            layoutParams.height = view.getMeasuredHeight();
            ViewPager2 viewPager24 = placeDetailsFragment.f78916o;
            if (viewPager24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            } else {
                viewPager22 = viewPager24;
            }
            viewPager22.setLayoutParams(layoutParams);
        }
    }

    private final int R() {
        return ((Number) this.G.a(this, M[0])).intValue();
    }

    private final void S(Uri uri) {
        try {
            requireActivity().startActivity(new Intent("android.intent.action.VIEW", uri));
        } catch (ActivityNotFoundException unused) {
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            new zzpl(contextRequireContext, R()).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void T() {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.widget.PlaceDetailsFragment.T():void");
    }

    private final void U(int i3) {
        zzbj zzbjVar = this.E;
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar = null;
        if (zzbjVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzbjVar = null;
        }
        ArrayList arrayListH0 = zzbjVar.H0();
        if (arrayListH0.isEmpty()) {
            return;
        }
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        PlacesLightboxActivity.Companion companion = PlacesLightboxActivity.f79083k;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        com.google.android.libraries.places.widget.internal.photoviewer.zzo zzoVar2 = new com.google.android.libraries.places.widget.internal.photoviewer.zzo(arrayListH0);
        int iR = R();
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar3 = this.C;
        if (zzoVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
            zzoVar3 = null;
        }
        fragmentActivityRequireActivity.startActivity(PlacesLightboxActivity.Companion.a(contextRequireContext, i3, zzoVar2, iR, zzoVar3));
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar4 = this.C;
        if (zzoVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
        } else {
            zzoVar = zzoVar4;
        }
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        zzoVar.h(contextRequireContext2);
    }

    private final boolean V() {
        GenerativeSummary generativeSummaryX;
        zzbj zzbjVar = this.E;
        List list = null;
        if (zzbjVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzbjVar = null;
        }
        Place place = (Place) zzbjVar.z0().f();
        if (place == null || (generativeSummaryX = place.x()) == null) {
            return false;
        }
        String strG = generativeSummaryX.g();
        String strD = generativeSummaryX.d();
        if (strG == null || StringsKt.p0(strG) || strD == null || StringsKt.p0(strD)) {
            return false;
        }
        TextView textView = this.f78910i;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("genAiSummary");
            textView = null;
        }
        List list2 = this.B;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list2 = null;
        }
        Content content = Content.f78943q;
        X(textView, strG, list2.contains(content));
        TextView textView2 = this.f78911j;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("genAiDisclosure");
            textView2 = null;
        }
        List list3 = this.B;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
        } else {
            list = list3;
        }
        X(textView2, strD, list.contains(content));
        return true;
    }

    private final void W() {
        TextView textView = this.f78907f;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("displayName");
            textView = null;
        }
        textView.setVisibility(8);
        com.google.android.libraries.places.widget.internal.placedetails.zzad zzadVar = this.f78920s;
        if (zzadVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("metadataViewController");
            zzadVar = null;
        }
        zzadVar.c();
        TextView textView3 = this.f78908g;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summary");
            textView3 = null;
        }
        textView3.setVisibility(8);
        View view = this.f78913l;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("summaryAndTabsDivider");
            view = null;
        }
        view.setVisibility(8);
        TabLayout tabLayout = this.f78914m;
        if (tabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabLayout = null;
        }
        tabLayout.setVisibility(8);
        View view2 = this.f78915n;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabsAndTabContentDivider");
            view2 = null;
        }
        view2.setVisibility(8);
        ViewPager2 viewPager2 = this.f78916o;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        viewPager2.setVisibility(8);
        ProgressBar progressBar = this.f78918q;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgressBar");
            progressBar = null;
        }
        progressBar.setVisibility(8);
        TextView textView4 = this.f78919r;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingFailedMessage");
        } else {
            textView2 = textView4;
        }
        textView2.setVisibility(8);
    }

    private final void X(View view, CharSequence charSequence, boolean z2) {
        if (!z2 || charSequence == null || StringsKt.p0(charSequence)) {
            view.setVisibility(8);
            return;
        }
        if (view instanceof TextView) {
            ((TextView) view).setText(charSequence);
        }
        view.setVisibility(0);
    }

    private final void w(final zzbq zzbqVar, final ImageView imageView, final View... viewArr) {
        requireView().post(new Runnable() { // from class: com.google.android.libraries.places.widget.zzac
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                PlaceDetailsFragment.O(this.f79410a, zzbqVar, imageView, viewArr);
            }
        });
    }

    private final void x(ImageView imageView, boolean z2) {
        if (z2) {
            imageView.setImportantForAccessibility(1);
            imageView.setContentDescription(requireContext().getString(R.string.V));
        } else {
            imageView.setImportantForAccessibility(4);
            imageView.setContentDescription(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        ViewPager2 viewPager2 = this.f78916o;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        int currentItem = viewPager2.getCurrentItem();
        FragmentManager childFragmentManager = getChildFragmentManager();
        StringBuilder sb = new StringBuilder(String.valueOf(currentItem).length() + 1);
        sb.append("f");
        sb.append(currentItem);
        Fragment fragmentN0 = childFragmentManager.n0(sb.toString());
        final View view = fragmentN0 != null ? fragmentN0.getView() : null;
        if (view != null) {
            view.post(new Runnable() { // from class: com.google.android.libraries.places.widget.zzu
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    PlaceDetailsFragment.Q(view, this);
                }
            });
            return;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(currentItem).length() + 34);
        sb2.append("Tab at position ");
        sb2.append(currentItem);
        sb2.append(" is not ready yet.");
        Log.d("PlaceDetailsFragment", sb2.toString());
    }

    public static final /* synthetic */ void z(final PlaceDetailsFragment placeDetailsFragment, Place place) {
        com.google.android.libraries.places.widget.internal.placedetails.zzad zzadVar;
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar;
        ProgressBar progressBar = placeDetailsFragment.f78918q;
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar2 = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingProgressBar");
            progressBar = null;
        }
        progressBar.setVisibility(8);
        TextView textView = placeDetailsFragment.f78907f;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("displayName");
            textView = null;
        }
        placeDetailsFragment.X(textView, place.p(), true);
        com.google.android.libraries.places.widget.internal.placedetails.zzad zzadVar2 = placeDetailsFragment.f78920s;
        if (zzadVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("metadataViewController");
            zzadVar = null;
        } else {
            zzadVar = zzadVar2;
        }
        List list = placeDetailsFragment.B;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list = null;
        }
        boolean zContains = list.contains(Content.f78930c);
        List list2 = placeDetailsFragment.B;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list2 = null;
        }
        boolean zContains2 = list2.contains(Content.f78932f);
        List list3 = placeDetailsFragment.B;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list3 = null;
        }
        boolean zContains3 = list3.contains(Content.f78931d);
        List list4 = placeDetailsFragment.B;
        if (list4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list4 = null;
        }
        boolean zContains4 = list4.contains(Content.f78933g);
        List list5 = placeDetailsFragment.B;
        if (list5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list5 = null;
        }
        boolean zContains5 = list5.contains(Content.f78934h);
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar3 = placeDetailsFragment.C;
        if (zzoVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
            zzoVar = null;
        } else {
            zzoVar = zzoVar3;
        }
        zzadVar.a(place, zContains, zContains2, zContains3, zContains4, zContains5, zzoVar);
        com.google.android.libraries.places.widget.internal.placedetails.zzad zzadVar3 = placeDetailsFragment.f78920s;
        if (zzadVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("metadataViewController");
            zzadVar3 = null;
        }
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar4 = placeDetailsFragment.C;
        if (zzoVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
            zzoVar4 = null;
        }
        zzadVar3.b(place, zzoVar4);
        List list6 = placeDetailsFragment.B;
        if (list6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list6 = null;
        }
        if (list6.contains(Content.f78943q) && placeDetailsFragment.V()) {
            TextView textView2 = placeDetailsFragment.f78908g;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("summary");
                textView2 = null;
            }
            textView2.setVisibility(8);
            View view = placeDetailsFragment.f78909h;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("genAiContent");
                view = null;
            }
            view.setVisibility(0);
            Log.d("PlaceDetailsFragment", "Summary is hidden since generative summary was requested.");
        } else {
            TextView textView3 = placeDetailsFragment.f78908g;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("summary");
                textView3 = null;
            }
            String strR = place.r();
            List list7 = placeDetailsFragment.B;
            if (list7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
                list7 = null;
            }
            placeDetailsFragment.X(textView3, strR, list7.contains(Content.f78935i));
            View view2 = placeDetailsFragment.f78909h;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("genAiContent");
                view2 = null;
            }
            view2.setVisibility(8);
        }
        FragmentManager childFragmentManager = placeDetailsFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Lifecycle lifecycle = placeDetailsFragment.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "<get-lifecycle>(...)");
        Context contextRequireContext = placeDetailsFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        List list8 = placeDetailsFragment.B;
        if (list8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list8 = null;
        }
        boolean zContains6 = list8.contains(Content.f78942p);
        List list9 = placeDetailsFragment.B;
        if (list9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list9 = null;
        }
        placeDetailsFragment.f78917p = new zzck(childFragmentManager, lifecycle, contextRequireContext, zContains6, list9.contains(Content.f78936j), place, placeDetailsFragment.R());
        ViewPager2 viewPager2 = placeDetailsFragment.f78916o;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        zzck zzckVar = placeDetailsFragment.f78917p;
        if (zzckVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            zzckVar = null;
        }
        viewPager2.setAdapter(zzckVar);
        ViewPager2 viewPager22 = placeDetailsFragment.f78916o;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager22 = null;
        }
        viewPager22.g(new zzai(placeDetailsFragment));
        zzck zzckVar2 = placeDetailsFragment.f78917p;
        if (zzckVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
            zzckVar2 = null;
        }
        int itemCount = zzckVar2.getItemCount();
        if (itemCount < 2) {
            TabLayout tabLayout = placeDetailsFragment.f78914m;
            if (tabLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
                tabLayout = null;
            }
            tabLayout.setVisibility(8);
            View view3 = placeDetailsFragment.f78915n;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabsAndTabContentDivider");
                view3 = null;
            }
            view3.setVisibility(8);
        } else {
            TabLayout tabLayout2 = placeDetailsFragment.f78914m;
            if (tabLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
                tabLayout2 = null;
            }
            tabLayout2.setVisibility(0);
            View view4 = placeDetailsFragment.f78915n;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabsAndTabContentDivider");
                view4 = null;
            }
            view4.setVisibility(0);
        }
        if (itemCount == 0) {
            ViewPager2 viewPager23 = placeDetailsFragment.f78916o;
            if (viewPager23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                viewPager23 = null;
            }
            viewPager23.setVisibility(8);
            View view5 = placeDetailsFragment.f78913l;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("summaryAndTabsDivider");
                view5 = null;
            }
            view5.setVisibility(8);
        } else {
            ViewPager2 viewPager24 = placeDetailsFragment.f78916o;
            if (viewPager24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                viewPager24 = null;
            }
            viewPager24.setVisibility(0);
            View view6 = placeDetailsFragment.f78913l;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("summaryAndTabsDivider");
                view6 = null;
            }
            view6.setVisibility(0);
        }
        TabLayout tabLayout3 = placeDetailsFragment.f78914m;
        if (tabLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabLayout3 = null;
        }
        ViewPager2 viewPager25 = placeDetailsFragment.f78916o;
        if (viewPager25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager25 = null;
        }
        new TabLayoutMediator(tabLayout3, viewPager25, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.google.android.libraries.places.widget.zzad
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final /* synthetic */ void a(TabLayout.Tab tab, int i3) {
                PlaceDetailsFragment.P(this.f79414a, tab, i3);
            }
        }).a();
        ImageView imageView = placeDetailsFragment.f78904b;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("image");
            imageView = null;
        }
        View.OnClickListener onClickListener = placeDetailsFragment.I;
        imageView.setOnClickListener(onClickListener);
        ImageView imageView2 = placeDetailsFragment.f78905c;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("image2");
            imageView2 = null;
        }
        imageView2.setOnClickListener(onClickListener);
        ImageView imageView3 = placeDetailsFragment.f78906d;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("image3");
            imageView3 = null;
        }
        imageView3.setOnClickListener(onClickListener);
        Place.Builder builderC = Place.c();
        builderC.D(place.G());
        builderC.s0(place.w0());
        builderC.G(place.J());
        Place placeA = builderC.a();
        PlaceLoadListener placeLoadListener = placeDetailsFragment.F;
        if (placeLoadListener != null) {
            Intrinsics.checkNotNull(placeA);
            placeLoadListener.a(placeA);
        }
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar5 = placeDetailsFragment.C;
        if (zzoVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
        } else {
            zzoVar2 = zzoVar5;
        }
        Context contextRequireContext2 = placeDetailsFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        zzoVar2.d(contextRequireContext2);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Application application = requireActivity().getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        this.E = (zzbj) new ViewModelProvider(this, com.google.android.libraries.places.widget.internal.placedetails.zzau.a(application)).a(zzbj.class);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Bundle bundleRequireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(bundleRequireArguments, "requireArguments(...)");
        this.B = ((zzs) zzou.a(bundleRequireArguments, "arg-content", zzs.class)).c();
        zzbk zzbkVar = new zzbk();
        zzbkVar.n();
        List list = this.B;
        Orientation orientation = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list = null;
        }
        if (list.contains(Content.f78928a)) {
            zzbkVar.a();
        }
        List list2 = this.B;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list2 = null;
        }
        if (list2.contains(Content.f78929b)) {
            zzbkVar.b();
        }
        List list3 = this.B;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list3 = null;
        }
        if (list3.contains(Content.f78930c)) {
            zzbkVar.c();
        }
        List list4 = this.B;
        if (list4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list4 = null;
        }
        if (list4.contains(Content.f78931d)) {
            zzbkVar.d();
        }
        List list5 = this.B;
        if (list5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list5 = null;
        }
        if (list5.contains(Content.f78932f)) {
            zzbkVar.e();
        }
        List list6 = this.B;
        if (list6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list6 = null;
        }
        if (list6.contains(Content.f78933g)) {
            zzbkVar.f();
        }
        List list7 = this.B;
        if (list7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list7 = null;
        }
        if (list7.contains(Content.f78934h)) {
            zzbkVar.g();
        }
        List list8 = this.B;
        if (list8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list8 = null;
        }
        if (list8.contains(Content.f78935i)) {
            zzbkVar.h();
        }
        List list9 = this.B;
        if (list9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list9 = null;
        }
        if (list9.contains(Content.f78936j)) {
            zzbkVar.g();
        }
        List list10 = this.B;
        if (list10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list10 = null;
        }
        if (list10.contains(Content.f78937k)) {
            zzbkVar.i();
        }
        List list11 = this.B;
        if (list11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list11 = null;
        }
        if (list11.contains(Content.f78938l)) {
            zzbkVar.j();
        }
        List list12 = this.B;
        if (list12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list12 = null;
        }
        if (list12.contains(Content.f78939m)) {
            zzbkVar.k();
        }
        List list13 = this.B;
        if (list13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list13 = null;
        }
        if (list13.contains(Content.f78940n)) {
            zzbkVar.l();
        }
        List list14 = this.B;
        if (list14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list14 = null;
        }
        if (list14.contains(Content.f78941o)) {
            zzbkVar.m();
        }
        List list15 = this.B;
        if (list15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list15 = null;
        }
        if (list15.contains(Content.f78942p)) {
            zzbkVar.o();
        }
        List list16 = this.B;
        if (list16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list16 = null;
        }
        if (list16.contains(Content.f78943q)) {
            zzbkVar.p();
        }
        this.D = zzbkVar.q();
        Bundle bundleRequireArguments2 = requireArguments();
        Intrinsics.checkNotNullExpressionValue(bundleRequireArguments2, "requireArguments(...)");
        this.A = (Orientation) zzou.a(bundleRequireArguments2, "arg-orientation", Orientation.class);
        this.G.b(this, M[0], Integer.valueOf(requireArguments().getInt("arg-theme-res-id")));
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), R());
        Orientation orientation2 = this.A;
        if (orientation2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orientation");
        } else {
            orientation = orientation2;
        }
        if (orientation == Orientation.f79403a) {
            Log.w("PlaceDetailsFragment", "Horizontal orientation is not yet available.");
        }
        View viewInflate = inflater.cloneInContext(contextThemeWrapper).inflate(R.layout.f74809t, viewGroup, false);
        Intrinsics.checkNotNull(viewInflate);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean("arg-show-legal-disclosures", this.H);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        zzamg zzamgVar;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (bundle != null) {
            boolean z2 = bundle.getBoolean("arg-show-legal-disclosures");
            this.H = z2;
            if (z2) {
                T();
            }
        }
        View viewFindViewById = view.findViewById(R.id.f74779w0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.f78903a = viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.E0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.f78904b = (ImageView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.F0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.f78905c = (ImageView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.G0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.f78906d = (ImageView) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.M0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.f78907f = (TextView) viewFindViewById5;
        View viewFindViewById6 = view.findViewById(R.id.f74721g1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.f78908g = (TextView) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.W);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.f78909h = viewFindViewById7;
        View viewFindViewById8 = view.findViewById(R.id.V);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.f78910i = (TextView) viewFindViewById8;
        View viewFindViewById9 = view.findViewById(R.id.T);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.f78911j = (TextView) viewFindViewById9;
        View viewFindViewById10 = view.findViewById(R.id.U);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.f78912k = (ImageButton) viewFindViewById10;
        View viewFindViewById11 = view.findViewById(R.id.f74718f2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.f78913l = viewFindViewById11;
        View viewFindViewById12 = view.findViewById(R.id.f74730i2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.f78916o = (ViewPager2) viewFindViewById12;
        View viewFindViewById13 = view.findViewById(R.id.f74726h2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.f78915n = viewFindViewById13;
        View viewFindViewById14 = view.findViewById(R.id.f74722g2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        TabLayout tabLayout = (TabLayout) viewFindViewById14;
        this.f78914m = tabLayout;
        ImageButton imageButton = null;
        if (tabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabLayout = null;
        }
        tabLayout.setTabGravity(0);
        View viewFindViewById15 = view.findViewById(R.id.f74720g0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById15, "findViewById(...)");
        this.f78918q = (ProgressBar) viewFindViewById15;
        View viewFindViewById16 = view.findViewById(R.id.f74712e0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById16, "findViewById(...)");
        this.f78919r = (TextView) viewFindViewById16;
        View viewFindViewById17 = view.findViewById(R.id.X);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById17, "findViewById(...)");
        this.f78921t = (ImageView) viewFindViewById17;
        View viewFindViewById18 = view.findViewById(R.id.f74696a0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById18, "findViewById(...)");
        this.f78922u = (ImageView) viewFindViewById18;
        View viewFindViewById19 = view.findViewById(R.id.K0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById19, "findViewById(...)");
        this.f78923v = (TextView) viewFindViewById19;
        View viewFindViewById20 = view.findViewById(R.id.J0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById20, "findViewById(...)");
        this.f78924w = viewFindViewById20;
        View viewFindViewById21 = view.findViewById(R.id.f74782x0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById21, "findViewById(...)");
        this.f78925x = viewFindViewById21;
        View viewFindViewById22 = view.findViewById(R.id.H0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById22, "findViewById(...)");
        this.f78926y = viewFindViewById22;
        View viewFindViewById23 = view.findViewById(R.id.I0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById23, "findViewById(...)");
        this.f78927z = viewFindViewById23;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        int iR = R();
        zzbj zzbjVar = this.E;
        if (zzbjVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzbjVar = null;
        }
        zzpt zzptVarD0 = zzbjVar.D0();
        this.f78920s = new com.google.android.libraries.places.widget.internal.placedetails.zzad(view, contextRequireContext, iR, zzptVarD0 != null ? zzptVarD0.zzb() : null, com.google.android.libraries.places.widget.internal.placedetails.zzab.f79143b);
        W();
        zzot zzotVar = zzot.f78364c;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        int iA = zzos.a(contextRequireContext2, R());
        ImageView imageView = this.f78921t;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributionImage");
            imageView = null;
        }
        imageView.setColorFilter(iA);
        ImageView imageView2 = this.f78922u;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("legalDisclosuresIcon");
            imageView2 = null;
        }
        imageView2.setColorFilter(iA);
        ImageView imageView3 = this.f78922u;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("legalDisclosuresIcon");
            imageView3 = null;
        }
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.zzt
            @Override // android.view.View.OnClickListener
            public final /* synthetic */ void onClick(View view2) {
                this.f79456a.T();
            }
        });
        zzbj zzbjVar2 = this.E;
        if (zzbjVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzbjVar2 = null;
        }
        zzbjVar2.z0().j(getViewLifecycleOwner(), new zzah(new zzaf(this)));
        zzbj zzbjVar3 = this.E;
        if (zzbjVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzbjVar3 = null;
        }
        zzbjVar3.A0().j(getViewLifecycleOwner(), new zzah(new zzag(this)));
        zzbj zzbjVar4 = this.E;
        if (zzbjVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzbjVar4 = null;
        }
        zzbjVar4.C0().j(getViewLifecycleOwner(), new zzah(new Function1() { // from class: com.google.android.libraries.places.widget.zzv
            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Object invoke(Object obj) {
                return PlaceDetailsFragment.G(this.f79459a, (Unit) obj);
            }
        }));
        zzbj zzbjVar5 = this.E;
        if (zzbjVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzbjVar5 = null;
        }
        ((LiveData) zzbjVar5.B0().get(0)).j(getViewLifecycleOwner(), new zzah(new Function1() { // from class: com.google.android.libraries.places.widget.zzw
            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Object invoke(Object obj) {
                return PlaceDetailsFragment.H(this.f79460a, (zzbq) obj);
            }
        }));
        zzbj zzbjVar6 = this.E;
        if (zzbjVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzbjVar6 = null;
        }
        ((LiveData) zzbjVar6.B0().get(1)).j(getViewLifecycleOwner(), new zzah(new Function1() { // from class: com.google.android.libraries.places.widget.zzx
            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Object invoke(Object obj) {
                return PlaceDetailsFragment.I(this.f79461a, (zzbq) obj);
            }
        }));
        zzbj zzbjVar7 = this.E;
        if (zzbjVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzbjVar7 = null;
        }
        ((LiveData) zzbjVar7.B0().get(2)).j(getViewLifecycleOwner(), new zzah(new Function1() { // from class: com.google.android.libraries.places.widget.zzy
            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Object invoke(Object obj) {
                return PlaceDetailsFragment.J(this.f79462a, (zzbq) obj);
            }
        }));
        zzaml zzamlVar = zzaml.VARIANT_FULL;
        Orientation orientation = this.A;
        if (orientation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orientation");
            orientation = null;
        }
        zzamj zzamjVar = orientation == Orientation.f79404b ? zzamj.ORIENTATION_VERTICAL : zzamj.ORIENTATION_HORIZONTAL;
        List list = this.B;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AppLovinEventTypes.USER_VIEWED_CONTENT);
            list = null;
        }
        List<Content> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Content content : list2) {
            Content content2 = Content.f78928a;
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
                case 7:
                    zzamgVar = zzamg.SUMMARY;
                    break;
                case 8:
                    zzamgVar = zzamg.OPENING_HOURS;
                    break;
                case 9:
                    zzamgVar = zzamg.WEBSITE;
                    break;
                case 10:
                    zzamgVar = zzamg.PHONE_NUMBER;
                    break;
                case 11:
                    zzamgVar = zzamg.TYPE_SPECIFIC_HIGHLIGHTS;
                    break;
                case 12:
                    zzamgVar = zzamg.REVIEWS;
                    break;
                case 13:
                    zzamgVar = zzamg.PLUS_CODE;
                    break;
                case 14:
                    zzamgVar = zzamg.FEATURES;
                    break;
                case 15:
                    zzamgVar = zzamg.GENERATIVE_SUMMARY;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            arrayList.add(zzamgVar);
        }
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar = new com.google.android.libraries.places.widget.internal.placedetails.zzo(zzamlVar, zzamjVar, arrayList, R());
        this.C = zzoVar;
        zzbj zzbjVar8 = this.E;
        if (zzbjVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            zzbjVar8 = null;
        }
        zzoVar.a(zzbjVar8.G0());
        if (bundle == null) {
            com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar2 = this.C;
            if (zzoVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
                zzoVar2 = null;
            }
            Context contextRequireContext3 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
            zzoVar2.c(contextRequireContext3);
        }
        ImageButton imageButton2 = this.f78912k;
        if (imageButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("genAiMenu");
        } else {
            imageButton = imageButton2;
        }
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.zzz
            @Override // android.view.View.OnClickListener
            public final /* synthetic */ void onClick(View view2) {
                PlaceDetailsFragment.L(this.f79463a, view2);
            }
        });
    }
}
