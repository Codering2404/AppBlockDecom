package cz.mobilesoft.coreblock.scene.statistics.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import cz.mobilesoft.coreblock.databinding.FragmentStatisticsDetailBinding;
import cz.mobilesoft.coreblock.databinding.LayoutStatisticsHeaderBinding;
import cz.mobilesoft.coreblock.databinding.LayoutStatisticsToolbarBinding;
import cz.mobilesoft.coreblock.enums.StatisticsTimeFilter;
import cz.mobilesoft.coreblock.enums.StatisticsUsageTypeFilter;
import cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment;
import cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel;
import cz.mobilesoft.coreblock.scene.statistics.StatisticsIntervalConfig;
import cz.mobilesoft.coreblock.scene.statistics.StatisticsProfileListBottomSheet;
import cz.mobilesoft.coreblock.scene.statistics.adapter.StatisticsGraphViewPagerAdapter;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.view.viewholder.StatisticsProfilesListViewHolder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StatisticsDetailFragment extends BaseStatisticsFragment<BaseStatisticsFragmentViewModel.BaseStatisticsFilter, StatisticsDetailFragmentViewModel, FragmentStatisticsDetailBinding> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Companion f119808o = new Companion(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f119809p = 8;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f119810l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final StatisticsUsageTypeFilter[] f119811m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Integer f119812n;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StatisticsDetailFragment a(String str, Collection collection, StatisticsUsageTypeFilter statisticsUsageTypeFilter, StatisticsTimeFilter statisticsTimeFilter, int i3) {
            StatisticsDetailFragment statisticsDetailFragment = new StatisticsDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString("PACKAGE_NAME", str);
            if (collection != null) {
                bundle.putSerializable("URL", new ArrayList(collection));
            }
            bundle.putSerializable("USAGE_TYPE_FILTER", statisticsUsageTypeFilter);
            bundle.putSerializable("TIME_FILTER", statisticsTimeFilter);
            bundle.putInt("INTERVAL_POSITION", i3);
            statisticsDetailFragment.setArguments(bundle);
            return statisticsDetailFragment;
        }

        private Companion() {
        }
    }

    public StatisticsDetailFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: cz.mobilesoft.coreblock.scene.statistics.detail.StatisticsDetailFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Fragment invoke() {
                return this;
            }
        };
        final Qualifier qualifier = null;
        final Function0 function02 = null;
        final Function0 function03 = null;
        this.f119810l = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<StatisticsDetailFragmentViewModel>() { // from class: cz.mobilesoft.coreblock.scene.statistics.detail.StatisticsDetailFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final ViewModel invoke() {
                CreationExtras defaultViewModelCreationExtras;
                Fragment fragment = this;
                Qualifier qualifier2 = qualifier;
                Function0 function04 = function0;
                Function0 function05 = function02;
                Function0 function06 = function03;
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function04.invoke()).getViewModelStore();
                if (function05 == null || (defaultViewModelCreationExtras = (CreationExtras) function05.invoke()) == null) {
                    defaultViewModelCreationExtras = fragment.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                }
                return GetViewModelKt.b(Reflection.b(StatisticsDetailFragmentViewModel.class), viewModelStore, null, defaultViewModelCreationExtras, qualifier2, AndroidKoinScopeExtKt.a(fragment), function06, 4, null);
            }
        });
        this.f119811m = StatisticsUsageTypeFilter.Companion.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(StatisticsDetailFragment statisticsDetailFragment, View view) {
        FragmentActivity activity = statisticsDetailFragment.getActivity();
        if (activity != null) {
            StatisticsProfileListBottomSheet.f119691u.a(statisticsDetailFragment.h0().A1(), statisticsDetailFragment.h0().u1(), statisticsDetailFragment).show(activity.getSupportFragmentManager(), "addToProfile");
        }
    }

    private final void T0() {
        final FragmentStatisticsDetailBinding fragmentStatisticsDetailBinding = (FragmentStatisticsDetailBinding) w();
        fragmentStatisticsDetailBinding.f96679e.removeAllViews();
        String strA1 = h0().A1();
        if (strA1 != null) {
            h0().s1(strA1, new Function1() { // from class: cz.mobilesoft.coreblock.scene.statistics.detail.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StatisticsDetailFragment.U0(fragmentStatisticsDetailBinding, this, ((Boolean) obj).booleanValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U0(final FragmentStatisticsDetailBinding fragmentStatisticsDetailBinding, final StatisticsDetailFragment statisticsDetailFragment, boolean z2) {
        if (z2) {
            statisticsDetailFragment.h0().B1(new Function1() { // from class: cz.mobilesoft.coreblock.scene.statistics.detail.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StatisticsDetailFragment.V0(fragmentStatisticsDetailBinding, statisticsDetailFragment, (List) obj);
                }
            });
            return Unit.f139807a;
        }
        View divider = fragmentStatisticsDetailBinding.f96681g;
        Intrinsics.checkNotNullExpressionValue(divider, "divider");
        divider.setVisibility(8);
        TextView blockedByTextView = fragmentStatisticsDetailBinding.f96678d;
        Intrinsics.checkNotNullExpressionValue(blockedByTextView, "blockedByTextView");
        blockedByTextView.setVisibility(8);
        LinearLayout cardsContainer = fragmentStatisticsDetailBinding.f96679e;
        Intrinsics.checkNotNullExpressionValue(cardsContainer, "cardsContainer");
        cardsContainer.setVisibility(8);
        Button addToBlockingButton = fragmentStatisticsDetailBinding.f96676b;
        Intrinsics.checkNotNullExpressionValue(addToBlockingButton, "addToBlockingButton");
        addToBlockingButton.setVisibility(8);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(FragmentStatisticsDetailBinding fragmentStatisticsDetailBinding, StatisticsDetailFragment statisticsDetailFragment, List profiles) {
        Intrinsics.checkNotNullParameter(profiles, "profiles");
        if (profiles.isEmpty()) {
            LinearLayout cardsContainer = fragmentStatisticsDetailBinding.f96679e;
            Intrinsics.checkNotNullExpressionValue(cardsContainer, "cardsContainer");
            cardsContainer.setVisibility(8);
        } else {
            LinearLayout cardsContainer2 = fragmentStatisticsDetailBinding.f96679e;
            Intrinsics.checkNotNullExpressionValue(cardsContainer2, "cardsContainer");
            cardsContainer2.setVisibility(0);
            Context contextRequireContext = statisticsDetailFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            StatisticsProfilesListViewHolder statisticsProfilesListViewHolder = new StatisticsProfilesListViewHolder(contextRequireContext, profiles);
            LinearLayout cardsContainer3 = fragmentStatisticsDetailBinding.f96679e;
            Intrinsics.checkNotNullExpressionValue(cardsContainer3, "cardsContainer");
            statisticsProfilesListViewHolder.j(cardsContainer3);
        }
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment
    public void F0(Integer num) {
        this.f119812n = num;
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment
    /* JADX INFO: renamed from: P0, reason: merged with bridge method [inline-methods] */
    public StatisticsDetailFragmentViewModel h0() {
        return (StatisticsDetailFragmentViewModel) this.f119810l.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0034  */
    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: Q0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void y(cz.mobilesoft.coreblock.databinding.FragmentStatisticsDetailBinding r3, android.view.View r4, android.os.Bundle r5) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            super.y(r3, r4, r5)
            cz.mobilesoft.coreblock.scene.statistics.detail.StatisticsDetailFragmentViewModel r4 = r2.h0()
            java.lang.String r4 = r4.A1()
            if (r4 == 0) goto L34
            androidx.fragment.app.FragmentActivity r5 = r2.requireActivity()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L32
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L32
            r0 = 8192(0x2000, float:1.148E-41)
            android.content.pm.ApplicationInfo r0 = r5.getApplicationInfo(r4, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L32
            java.lang.String r1 = "getApplicationInfo(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L32
            java.lang.CharSequence r5 = r5.getApplicationLabel(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L32
            java.lang.String r4 = r5.toString()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L32
        L32:
            if (r4 != 0) goto L4c
        L34:
            cz.mobilesoft.coreblock.scene.statistics.detail.StatisticsDetailFragmentViewModel r4 = r2.h0()
            java.util.Collection r4 = r4.u1()
            if (r4 == 0) goto L4b
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.lang.Object r4 = kotlin.collections.CollectionsKt.first(r4)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r4 = cz.mobilesoft.coreblock.util.helperextension.StringHelper.x(r4)
            goto L4c
        L4b:
            r4 = 0
        L4c:
            android.widget.TextView r5 = r3.f96678d
            int r0 = cz.mobilesoft.coreblock.R.string.Pf
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            java.lang.String r4 = r2.getString(r0, r4)
            r5.setText(r4)
            r4 = 1
            r2.i0(r4)
            android.widget.Button r3 = r3.f96676b
            cz.mobilesoft.coreblock.scene.statistics.detail.b r4 = new cz.mobilesoft.coreblock.scene.statistics.detail.b
            r4.<init>()
            r3.setOnClickListener(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.statistics.detail.StatisticsDetailFragment.y(cz.mobilesoft.coreblock.databinding.FragmentStatisticsDetailBinding, android.view.View, android.os.Bundle):void");
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: S0, reason: merged with bridge method [inline-methods] */
    public FragmentStatisticsDetailBinding z(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentStatisticsDetailBinding fragmentStatisticsDetailBindingC = FragmentStatisticsDetailBinding.c(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(fragmentStatisticsDetailBindingC, "inflate(...)");
        return fragmentStatisticsDetailBindingC;
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment
    public RecyclerView Z() {
        RecyclerView appsWebsRecyclerView = ((FragmentStatisticsDetailBinding) w()).f96677c;
        Intrinsics.checkNotNullExpressionValue(appsWebsRecyclerView, "appsWebsRecyclerView");
        return appsWebsRecyclerView;
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment
    public Integer a0() {
        return this.f119812n;
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment
    public View c0() {
        FrameLayout fragmentContainer = ((FragmentStatisticsDetailBinding) w()).f96682h;
        Intrinsics.checkNotNullExpressionValue(fragmentContainer, "fragmentContainer");
        return fragmentContainer;
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment
    public LayoutStatisticsHeaderBinding d0() {
        LayoutStatisticsHeaderBinding statisticsHeaderView = ((FragmentStatisticsDetailBinding) w()).f96684j;
        Intrinsics.checkNotNullExpressionValue(statisticsHeaderView, "statisticsHeaderView");
        return statisticsHeaderView;
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment
    public LayoutStatisticsToolbarBinding f0() {
        LayoutStatisticsToolbarBinding statisticsToolbar = ((FragmentStatisticsDetailBinding) w()).f96685k;
        Intrinsics.checkNotNullExpressionValue(statisticsToolbar, "statisticsToolbar");
        return statisticsToolbar;
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment
    public StatisticsUsageTypeFilter[] g0() {
        return this.f119811m;
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment
    public FragmentStateAdapter n0() {
        StatisticsUsageTypeFilter statisticsUsageTypeFilterC1 = h0().c1();
        StatisticsTimeFilter statisticsTimeFilterB1 = h0().b1();
        StatisticsIntervalConfig statisticsIntervalConfig = (StatisticsIntervalConfig) h0().V0().f();
        if (statisticsIntervalConfig == null) {
            statisticsIntervalConfig = new StatisticsIntervalConfig();
        }
        StatisticsGraphViewPagerAdapter statisticsGraphViewPagerAdapter = new StatisticsGraphViewPagerAdapter(this, statisticsUsageTypeFilterC1, statisticsTimeFilterB1, statisticsIntervalConfig, (List) BuildersKt__BuildersKt.b(null, new StatisticsDetailFragment$initViewPagerAdapter$1(this, null), 1, null), h0().y1());
        statisticsGraphViewPagerAdapter.G();
        return statisticsGraphViewPagerAdapter;
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment
    public void o0() {
        AnswersHelper.f128199a.T6("detail");
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i4, Intent intent) {
        if (i3 == 941) {
            T0();
        } else {
            super.onActivityResult(i3, i4, intent);
        }
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("PACKAGE_NAME");
            if (string != null) {
                h0().E1(string);
            }
            Serializable serializable = arguments.getSerializable("URL");
            if (serializable != null) {
                h0().D1((Collection) serializable);
            }
            Serializable serializable2 = arguments.getSerializable("USAGE_TYPE_FILTER");
            if (serializable2 != null) {
                StatisticsDetailFragmentViewModel statisticsDetailFragmentViewModelH0 = h0();
                Intrinsics.checkNotNull(serializable2, "null cannot be cast to non-null type cz.mobilesoft.coreblock.enums.StatisticsUsageTypeFilter");
                statisticsDetailFragmentViewModelH0.j1((StatisticsUsageTypeFilter) serializable2);
            }
            Serializable serializable3 = arguments.getSerializable("TIME_FILTER");
            if (serializable3 != null) {
                StatisticsDetailFragmentViewModel statisticsDetailFragmentViewModelH02 = h0();
                Intrinsics.checkNotNull(serializable3, "null cannot be cast to non-null type cz.mobilesoft.coreblock.enums.StatisticsTimeFilter");
                statisticsDetailFragmentViewModelH02.i1((StatisticsTimeFilter) serializable3);
            }
            F0(Integer.valueOf(arguments.getInt("INTERVAL_POSITION")));
        }
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment, cz.mobilesoft.coreblock.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        T0();
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment
    public void p0() {
        AnswersHelper.f128199a.V6("detail");
    }
}
