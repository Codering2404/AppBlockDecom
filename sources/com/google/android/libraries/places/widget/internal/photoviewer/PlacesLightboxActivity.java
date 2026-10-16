package com.google.android.libraries.places.widget.internal.photoviewer;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.internal.zzou;
import com.google.android.libraries.places.internal.zzpl;
import com.google.android.libraries.places.widget.internal.photoviewer.PlacesLightboxActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class PlacesLightboxActivity extends AppCompatActivity implements zze {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewPager2 f79085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f79086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f79087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List f79088d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.google.android.libraries.places.widget.internal.placedetails.zzo f79089f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f79090g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f79091h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ReadWriteProperty f79092i = Delegates.f140171a.a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private zzx f79093j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f79084l = {Reflection.e(new MutablePropertyReference1Impl(PlacesLightboxActivity.class, "themeResId", "getThemeResId()I", 0))};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Companion f79083k = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final Intent a(Context context, int i3, zzo pageDataList, int i4, com.google.android.libraries.places.widget.internal.placedetails.zzo analyticsReporter) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(pageDataList, "pageDataList");
            Intrinsics.checkNotNullParameter(analyticsReporter, "analyticsReporter");
            Intent intent = new Intent(context, (Class<?>) PlacesLightboxActivity.class);
            intent.putExtra("extra-photo-page-data-list", pageDataList);
            intent.putExtra("extra-start-index", i3);
            intent.putExtra("extra-theme-res-id", i4);
            intent.putExtra("extra-analytics-reporter", analyticsReporter);
            return intent;
        }
    }

    static /* synthetic */ void Y(PlacesLightboxActivity placesLightboxActivity, View view) {
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar = placesLightboxActivity.f79089f;
        if (zzoVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
            zzoVar = null;
        }
        zzoVar.i(placesLightboxActivity);
        placesLightboxActivity.finish();
    }

    static /* synthetic */ WindowInsetsCompat b0(PlacesLightboxActivity placesLightboxActivity, float f3, View v2, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v2, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insetsF = insets.f(WindowInsetsCompat.Type.i());
        Intrinsics.checkNotNullExpressionValue(insetsF, "getInsets(...)");
        ViewGroup.LayoutParams layoutParams = v2.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMarginStart(l0(insetsF, v2) + ((int) f3));
        v2.setLayoutParams(marginLayoutParams);
        return insets;
    }

    static /* synthetic */ WindowInsetsCompat c0(PlacesLightboxActivity placesLightboxActivity, float f3, View v2, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v2, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insetsF = insets.f(WindowInsetsCompat.Type.i());
        Intrinsics.checkNotNullExpressionValue(insetsF, "getInsets(...)");
        ViewGroup.LayoutParams layoutParams = v2.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMarginEnd(k0(insetsF, v2) + ((int) f3));
        v2.setLayoutParams(marginLayoutParams);
        return insets;
    }

    static /* synthetic */ WindowInsetsCompat d0(PlacesLightboxActivity placesLightboxActivity, float f3, View v2, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v2, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insetsF = insets.f(WindowInsetsCompat.Type.i());
        Intrinsics.checkNotNullExpressionValue(insetsF, "getInsets(...)");
        ViewGroup.LayoutParams layoutParams = v2.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = insetsF.f33965b;
        int i3 = (int) f3;
        marginLayoutParams.setMarginStart(l0(insetsF, v2) + i3);
        marginLayoutParams.setMarginEnd(k0(insetsF, v2) + i3);
        v2.setLayoutParams(marginLayoutParams);
        return insets;
    }

    private final int f0() {
        return ((Number) this.f79092i.a(this, f79084l[0])).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0() {
        String strH;
        List list = this.f79088d;
        ViewPager2 viewPager2 = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageDataList");
            list = null;
        }
        ViewPager2 viewPager22 = this.f79085a;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPager2 = viewPager22;
        }
        zzd zzdVar = (zzd) CollectionsKt.getOrNull(list, viewPager2.getCurrentItem());
        if (zzdVar == null || (strH = zzdVar.h()) == null) {
            return;
        }
        h0(strH);
    }

    private final void h0(String str) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (ActivityNotFoundException unused) {
            new zzpl(this, f0()).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(int i3) {
        List list = this.f79088d;
        ImageView imageView = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageDataList");
            list = null;
        }
        zzd zzdVar = (zzd) CollectionsKt.getOrNull(list, i3);
        if (zzdVar != null) {
            TextView textView = this.f79087c;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userName");
                textView = null;
            }
            textView.setText(zzdVar.f());
            RequestBuilder requestBuilder = (RequestBuilder) Glide.u(this).q(zzdVar.g()).c();
            ImageView imageView2 = this.f79086b;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userProfileImageView");
            } else {
                imageView = imageView2;
            }
            requestBuilder.F0(imageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j0(PlacesLightboxActivity placesLightboxActivity, MenuItem menuItem) {
        String strE;
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        if (menuItem.getItemId() != R.id.N1) {
            return false;
        }
        List list = placesLightboxActivity.f79088d;
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageDataList");
            list = null;
        }
        ViewPager2 viewPager2 = placesLightboxActivity.f79085a;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        zzd zzdVar = (zzd) CollectionsKt.getOrNull(list, viewPager2.getCurrentItem());
        if (zzdVar != null && (strE = zzdVar.e()) != null) {
            com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar2 = placesLightboxActivity.f79089f;
            if (zzoVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
            } else {
                zzoVar = zzoVar2;
            }
            zzoVar.j(placesLightboxActivity);
            placesLightboxActivity.h0(strE);
        }
        return true;
    }

    private static final int k0(Insets insets, View view) {
        return view.getLayoutDirection() == 1 ? insets.f33964a : insets.f33966c;
    }

    private static final int l0(Insets insets, View view) {
        return view.getLayoutDirection() == 1 ? insets.f33966c : insets.f33964a;
    }

    @Override // com.google.android.libraries.places.widget.internal.photoviewer.zze
    public void d() {
        ViewPager2 viewPager2 = this.f79085a;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        List list = this.f79088d;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageDataList");
            list = null;
        }
        int size = list.size() - 1;
        ViewPager2 viewPager23 = this.f79085a;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPager22 = viewPager23;
        }
        viewPager2.j(Math.min(size, viewPager22.getCurrentItem() + 1), false);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        com.google.android.libraries.places.widget.internal.placedetails.zzo zzoVar = this.f79089f;
        if (zzoVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
            zzoVar = null;
        }
        zzoVar.k(this, this.f79090g);
    }

    @Override // com.google.android.libraries.places.widget.internal.photoviewer.zze
    public void k() {
        ViewPager2 viewPager2 = this.f79085a;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        ViewPager2 viewPager23 = this.f79085a;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPager22 = viewPager23;
        }
        viewPager2.j(Math.max(0, viewPager22.getCurrentItem() - 1), false);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        RecyclerView.Adapter adapter;
        this.f79090g = bundle != null ? bundle.getInt("extra-number-of-photos-shown-in-gallery") : 0;
        this.f79091h = bundle != null ? bundle.getInt("extra-previous-photo-index") : -1;
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        this.f79092i.b(this, f79084l[0], Integer.valueOf(extras.getInt("extra-theme-res-id")));
        setTheme(f0());
        super.onCreate(bundle);
        setContentView(R.layout.B);
        this.f79093j = new zzx(this, f0());
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.k();
        }
        EdgeToEdge.b(this, null, null, 3, null);
        int i3 = R.id.f74770t0;
        View viewFindViewById = findViewById(i3);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.f79085a = (ViewPager2) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.F1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.f79086b = (ImageView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.f74746m2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.f79087c = (TextView) viewFindViewById3;
        PageSelectionIndicator pageSelectionIndicator = (PageSelectionIndicator) findViewById(R.id.f74710d2);
        View viewFindViewById4 = findViewById(R.id.A);
        View viewFindViewById5 = findViewById(R.id.f74728i0);
        View viewFindViewById6 = findViewById(R.id.f74750n2);
        viewFindViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.internal.photoviewer.zzw
            @Override // android.view.View.OnClickListener
            public final /* synthetic */ void onClick(View view) {
                PlacesLightboxActivity.Y(this.f79133a, view);
            }
        });
        viewFindViewById5.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.internal.photoviewer.zzp
            @Override // android.view.View.OnClickListener
            public final /* synthetic */ void onClick(View view) {
                Intrinsics.checkNotNull(view);
                final PlacesLightboxActivity placesLightboxActivity = this.f79122a;
                PopupMenu popupMenu = new PopupMenu(placesLightboxActivity, view);
                popupMenu.getMenuInflater().inflate(R.menu.f74817b, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.google.android.libraries.places.widget.internal.photoviewer.zzr
                    @Override // android.widget.PopupMenu.OnMenuItemClickListener
                    public final /* synthetic */ boolean onMenuItemClick(MenuItem menuItem) {
                        return PlacesLightboxActivity.j0(placesLightboxActivity, menuItem);
                    }
                });
                popupMenu.show();
            }
        });
        viewFindViewById6.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.internal.photoviewer.zzq
            @Override // android.view.View.OnClickListener
            public final /* synthetic */ void onClick(View view) {
                this.f79123a.g0();
            }
        });
        Intrinsics.checkNotNull(pageSelectionIndicator);
        zzx zzxVar = this.f79093j;
        if (zzxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("themeDimensionHelper");
            zzxVar = null;
        }
        final float fA = zzxVar.a();
        ViewCompat.C0(pageSelectionIndicator, new OnApplyWindowInsetsListener() { // from class: com.google.android.libraries.places.widget.internal.photoviewer.zzv
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final /* synthetic */ WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                PlacesLightboxActivity.d0(this.f79131a, fA, view, windowInsetsCompat);
                return windowInsetsCompat;
            }
        });
        Intrinsics.checkNotNull(viewFindViewById4);
        zzx zzxVar2 = this.f79093j;
        if (zzxVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("themeDimensionHelper");
            zzxVar2 = null;
        }
        final float fA2 = zzxVar2.a();
        ViewCompat.C0(viewFindViewById4, new OnApplyWindowInsetsListener() { // from class: com.google.android.libraries.places.widget.internal.photoviewer.zzu
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final /* synthetic */ WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                PlacesLightboxActivity.c0(this.f79129a, fA2, view, windowInsetsCompat);
                return windowInsetsCompat;
            }
        });
        Intrinsics.checkNotNull(viewFindViewById6);
        zzx zzxVar3 = this.f79093j;
        if (zzxVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("themeDimensionHelper");
            zzxVar3 = null;
        }
        final float fA3 = zzxVar3.a();
        ViewCompat.C0(viewFindViewById6, new OnApplyWindowInsetsListener() { // from class: com.google.android.libraries.places.widget.internal.photoviewer.zzt
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final /* synthetic */ WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                PlacesLightboxActivity.b0(this.f79127a, fA3, view, windowInsetsCompat);
                return windowInsetsCompat;
            }
        });
        final View viewFindViewById7 = findViewById(R.id.Y);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        int iF0 = f0();
        int[] PlacesMaterialThemeAttrs = R.styleable.f74889a;
        Intrinsics.checkNotNullExpressionValue(PlacesMaterialThemeAttrs, "PlacesMaterialThemeAttrs");
        TypedArray typedArrayObtainStyledAttributes = obtainStyledAttributes(iF0, PlacesMaterialThemeAttrs);
        zzx zzxVar4 = this.f79093j;
        if (zzxVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("themeDimensionHelper");
            zzxVar4 = null;
        }
        final float fB = zzxVar4.b();
        ViewCompat.C0(viewFindViewById7, new OnApplyWindowInsetsListener() { // from class: com.google.android.libraries.places.widget.internal.photoviewer.zzs
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final /* synthetic */ WindowInsetsCompat a(View view, WindowInsetsCompat insets) {
                PlacesLightboxActivity.Companion companion = PlacesLightboxActivity.f79083k;
                Intrinsics.checkNotNullParameter(view, "<unused var>");
                Intrinsics.checkNotNullParameter(insets, "insets");
                ViewGroup.LayoutParams layoutParams = viewFindViewById7.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, insets.f(WindowInsetsCompat.Type.i()).f33967d + ((int) fB));
                return insets;
            }
        });
        typedArrayObtainStyledAttributes.recycle();
        ViewPager2 viewPager2 = this.f79085a;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        viewPager2.setOffscreenPageLimit(4);
        ViewPager2 viewPager22 = this.f79085a;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager22 = null;
        }
        viewPager22.g(new zzy(this));
        ViewPager2 viewPager23 = this.f79085a;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager23 = null;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        viewPager23.setAdapter(new zzm(supportFragmentManager, getLifecycle()));
        Bundle extras2 = getIntent().getExtras();
        if (extras2 != null) {
            int i4 = extras2.getInt("extra-start-index", 0);
            this.f79089f = (com.google.android.libraries.places.widget.internal.placedetails.zzo) zzou.a(extras2, "extra-analytics-reporter", com.google.android.libraries.places.widget.internal.placedetails.zzo.class);
            int i5 = this.f79091h;
            if (i5 != -1) {
                i4 = i5;
            }
            List listC = ((zzo) zzou.a(extras2, "extra-photo-page-data-list", zzo.class)).c();
            this.f79088d = listC;
            if (listC == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageDataList");
                listC = null;
            }
            ViewPager2 viewPager24 = (ViewPager2) findViewById(i3);
            if (viewPager24 != null && (adapter = viewPager24.getAdapter()) != null && (adapter instanceof zzm)) {
                zzm zzmVar = (zzm) adapter;
                zzmVar.A(listC);
                zzmVar.notifyDataSetChanged();
                ViewPager2 viewPager25 = this.f79085a;
                if (viewPager25 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                    viewPager25 = null;
                }
                viewPager25.j(i4, false);
                i0(i4);
            }
            ViewPager2 viewpager2 = this.f79085a;
            if (viewpager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                viewpager2 = null;
            }
            com.google.android.libraries.places.widget.internal.placedetails.zzo analyticsReporter = this.f79089f;
            if (analyticsReporter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analyticsReporter");
                analyticsReporter = null;
            }
            Intrinsics.checkNotNullParameter(viewpager2, "viewpager2");
            Intrinsics.checkNotNullParameter(analyticsReporter, "analyticsReporter");
            RecyclerView.Adapter adapter2 = viewpager2.getAdapter();
            Integer numValueOf = adapter2 != null ? Integer.valueOf(adapter2.getItemCount()) : null;
            if (numValueOf == null) {
                Context context = pageSelectionIndicator.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                analyticsReporter.l(context);
            } else {
                pageSelectionIndicator.removeAllViews();
                int iIntValue = numValueOf.intValue();
                for (int i6 = 0; i6 < iIntValue; i6++) {
                    View viewInflate = LayoutInflater.from(pageSelectionIndicator.getContext()).inflate(R.layout.f74801l, (ViewGroup) pageSelectionIndicator, false);
                    Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.view.View");
                    pageSelectionIndicator.addView(viewInflate);
                }
                viewpager2.g(new zzb(pageSelectionIndicator));
            }
            pageSelectionIndicator.a(i4);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ViewPager2 viewPager2 = this.f79085a;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        viewPager2.setAdapter(null);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putInt("extra-number-of-photos-shown-in-gallery", this.f79090g);
        outState.putInt("extra-previous-photo-index", this.f79091h);
    }
}
