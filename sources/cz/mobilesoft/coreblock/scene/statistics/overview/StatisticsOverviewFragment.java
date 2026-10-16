package cz.mobilesoft.coreblock.scene.statistics.overview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.databinding.FragmentStatisticsOverviewBinding;
import cz.mobilesoft.coreblock.databinding.LayoutStatisticsHeaderBinding;
import cz.mobilesoft.coreblock.databinding.LayoutStatisticsToolbarBinding;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.enums.SettingsScreenType;
import cz.mobilesoft.coreblock.enums.StatisticsRecordType;
import cz.mobilesoft.coreblock.enums.StatisticsTimeFilter;
import cz.mobilesoft.coreblock.enums.StatisticsUsageTypeFilter;
import cz.mobilesoft.coreblock.scene.more.settings.SettingsActivity;
import cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment;
import cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel;
import cz.mobilesoft.coreblock.scene.statistics.StatisticsActivity;
import cz.mobilesoft.coreblock.scene.statistics.adapter.StatisticsGraphViewPagerAdapter;
import cz.mobilesoft.coreblock.scene.statistics.detail.StatisticsDetailActivity;
import cz.mobilesoft.coreblock.scene.statistics.ignorelist.IgnoreListActivity;
import cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelper;
import cz.mobilesoft.coreblock.util.helperextension.FlowsExtKt;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelper;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public final class StatisticsOverviewFragment extends BaseStatisticsFragment<BaseStatisticsFragmentViewModel.BaseStatisticsFilter, StatisticsOverviewFragmentViewModel, FragmentStatisticsOverviewBinding> implements KoinComponent {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Companion f120024u = new Companion(null);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f120025v = 8;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f120026l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Lazy f120027m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f120028n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f120029o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Pair f120030p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final ActivityResultLauncher f120031q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final ActivityResultLauncher f120032r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final ActivityResultLauncher f120033s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Integer f120034t;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StatisticsOverviewFragment a(Pair pair) {
            StatisticsOverviewFragment statisticsOverviewFragment = new StatisticsOverviewFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("STATISTICS_INTERVAL", pair);
            statisticsOverviewFragment.setArguments(bundle);
            return statisticsOverviewFragment;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StatisticsOverviewFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: cz.mobilesoft.coreblock.scene.statistics.overview.StatisticsOverviewFragment$special$$inlined$viewModel$default$1
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
        this.f120026l = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<StatisticsOverviewFragmentViewModel>() { // from class: cz.mobilesoft.coreblock.scene.statistics.overview.StatisticsOverviewFragment$special$$inlined$viewModel$default$2
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
                return GetViewModelKt.b(Reflection.b(StatisticsOverviewFragmentViewModel.class), viewModelStore, null, defaultViewModelCreationExtras, qualifier2, AndroidKoinScopeExtKt.a(fragment), function06, 4, null);
            }
        });
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        final Object[] objArr2 = 0 == true ? 1 : 0;
        this.f120027m = LazyKt.a(lazyThreadSafetyModeB, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.coreblock.scene.statistics.overview.StatisticsOverviewFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeDataStore.class), objArr, objArr2);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr3 = 0 == true ? 1 : 0;
        final Object[] objArr4 = 0 == true ? 1 : 0;
        this.f120028n = LazyKt.a(lazyThreadSafetyModeB2, new Function0<StatisticsDataStore>() { // from class: cz.mobilesoft.coreblock.scene.statistics.overview.StatisticsOverviewFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StatisticsDataStore.class), objArr3, objArr4);
            }
        });
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: cz.mobilesoft.coreblock.scene.statistics.overview.a
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                StatisticsOverviewFragment.r1(this.f120084a, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.f120031q = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: cz.mobilesoft.coreblock.scene.statistics.overview.b
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                StatisticsOverviewFragment.n1(this.f120085a, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.f120032r = activityResultLauncherRegisterForActivityResult2;
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: cz.mobilesoft.coreblock.scene.statistics.overview.c
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                StatisticsOverviewFragment.e1(this.f120086a, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult3, "registerForActivityResult(...)");
        this.f120033s = activityResultLauncherRegisterForActivityResult3;
    }

    public static final /* synthetic */ FragmentStatisticsOverviewBinding V0(StatisticsOverviewFragment statisticsOverviewFragment) {
        return (FragmentStatisticsOverviewBinding) statisticsOverviewFragment.w();
    }

    private final void Y0(int i3) {
        StatisticsRecordType statisticsRecordTypeO1 = o1(i3);
        BaseStatisticsFragmentViewModel.BaseStatisticsFilter baseStatisticsFilter = (BaseStatisticsFragmentViewModel.BaseStatisticsFilter) h0().a1().f();
        if (baseStatisticsFilter != null) {
            baseStatisticsFilter.h(statisticsRecordTypeO1);
            h0().a1().n(baseStatisticsFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(StatisticsOverviewFragment statisticsOverviewFragment, String str, Collection collection) {
        Context context = statisticsOverviewFragment.getContext();
        if (context != null) {
            Intent intent = new Intent(context, (Class<?>) StatisticsDetailActivity.class);
            intent.putExtra("PACKAGE_NAME", str);
            if (collection != null) {
                intent.putExtra("URL", new ArrayList(collection));
            }
            intent.putExtra("USAGE_TYPE_FILTER", statisticsOverviewFragment.h0().c1());
            intent.putExtra("TIME_FILTER", statisticsOverviewFragment.h0().b1());
            intent.putExtra("INTERVAL_POSITION", statisticsOverviewFragment.d0().f96819c.getCurrentItem());
            context.startActivity(intent);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(StatisticsOverviewFragment statisticsOverviewFragment, List appsWebsList) {
        Intrinsics.checkNotNullParameter(appsWebsList, "appsWebsList");
        AnswersHelper.f128199a.Q6("overview");
        if (statisticsOverviewFragment.getActivity() != null && DialogHelper.n(statisticsOverviewFragment.getActivity(), statisticsOverviewFragment.h0().O0().size(), Product.STATISTICS, PremiumFeature.STATISTICS_IGNORE_UNLIMITED)) {
            statisticsOverviewFragment.h0().d1(appsWebsList);
        }
        return Unit.f139807a;
    }

    private final StatisticsDataStore b1() {
        return (StatisticsDataStore) this.f120028n.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeDataStore c1() {
        return (StrictModeDataStore) this.f120027m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(StatisticsOverviewFragment statisticsOverviewFragment, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        statisticsOverviewFragment.h0().m1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1(StatisticsOverviewFragment statisticsOverviewFragment, BaseStatisticsFragmentViewModel.BaseStatisticsFilter baseStatisticsFilter, boolean z2, boolean z3) {
        statisticsOverviewFragment.q1(baseStatisticsFilter.c(), z2, z3);
        return Unit.f139807a;
    }

    private final void h1() {
        this.f120029o = PermissionHelper.l(getContext());
        RadioGroup radioGroup = ((FragmentStatisticsOverviewBinding) w()).f96698m;
        Intrinsics.checkNotNullExpressionValue(radioGroup, "radioGroup");
        ViewHelperExtKt.s(radioGroup);
        ((FragmentStatisticsOverviewBinding) w()).f96698m.check(this.f120029o ? R.id.f95617h : R.id.f95633l);
        ((FragmentStatisticsOverviewBinding) w()).f96698m.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: cz.mobilesoft.coreblock.scene.statistics.overview.g
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup2, int i3) {
                StatisticsOverviewFragment.i1(this.f120090a, radioGroup2, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(StatisticsOverviewFragment statisticsOverviewFragment, RadioGroup radioGroup, int i3) {
        Intrinsics.checkNotNullParameter(radioGroup, "<unused var>");
        AnswersHelper.f128199a.L6(statisticsOverviewFragment.o1(i3).getAnalyticsName());
        if (statisticsOverviewFragment.f120029o || i3 == R.id.f95633l) {
            statisticsOverviewFragment.Y0(i3);
        } else {
            CoroutinesHelperExtKt.f(statisticsOverviewFragment, new StatisticsOverviewFragment$initRadioGroup$1$1(statisticsOverviewFragment, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k1(StatisticsOverviewFragment statisticsOverviewFragment, BaseStatisticsFragmentViewModel.BaseStatisticsFilter baseStatisticsFilter) {
        RadioGroup radioGroup = ((FragmentStatisticsOverviewBinding) statisticsOverviewFragment.w()).f96698m;
        Intrinsics.checkNotNullExpressionValue(radioGroup, "radioGroup");
        radioGroup.setVisibility(baseStatisticsFilter.d() != StatisticsUsageTypeFilter.UNLOCKS ? 0 : 8);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(StatisticsOverviewFragment statisticsOverviewFragment, View view) {
        statisticsOverviewFragment.m1();
    }

    private final void m1() {
        SettingsActivity.Companion companion = SettingsActivity.f108043h;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        this.f120031q.b(SettingsActivity.Companion.b(companion, fragmentActivityRequireActivity, SettingsScreenType.STATISTICS, false, 4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(StatisticsOverviewFragment statisticsOverviewFragment, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.d() != -1) {
            ((FragmentStatisticsOverviewBinding) statisticsOverviewFragment.w()).f96688c.toggle();
        } else {
            statisticsOverviewFragment.f120029o = true;
            statisticsOverviewFragment.Y0(((FragmentStatisticsOverviewBinding) statisticsOverviewFragment.w()).f96698m.getCheckedRadioButtonId());
        }
    }

    private final StatisticsRecordType o1(int i3) {
        return i3 == R.id.f95633l ? StatisticsRecordType.APPS : i3 == R.id.t2 ? StatisticsRecordType.WEBS : StatisticsRecordType.ALL;
    }

    private final void q1(StatisticsRecordType statisticsRecordType, boolean z2, boolean z3) {
        FragmentStatisticsOverviewBinding fragmentStatisticsOverviewBinding = (FragmentStatisticsOverviewBinding) w();
        StatisticsRecordType statisticsRecordType2 = StatisticsRecordType.APPS;
        if ((statisticsRecordType != statisticsRecordType2 || z2) && (statisticsRecordType != StatisticsRecordType.WEBS || z3)) {
            fragmentStatisticsOverviewBinding.f96700o.f96818b.setVisibility(0);
            fragmentStatisticsOverviewBinding.f96694i.setVisibility(8);
            return;
        }
        fragmentStatisticsOverviewBinding.f96700o.f96818b.setVisibility(4);
        fragmentStatisticsOverviewBinding.f96694i.setVisibility(0);
        if (statisticsRecordType == statisticsRecordType2) {
            fragmentStatisticsOverviewBinding.f96693h.setText(R.string.f95798h1);
        } else {
            fragmentStatisticsOverviewBinding.f96693h.setText(R.string.fG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r1(StatisticsOverviewFragment statisticsOverviewFragment, ActivityResult result) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(result, "result");
        Intent intentC = result.c();
        if (intentC == null || !intentC.getBooleanExtra("STATS_DISABLED", false) || (activity = statisticsOverviewFragment.getActivity()) == null || !(activity instanceof StatisticsActivity)) {
            return;
        }
        activity.finish();
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment
    public void F0(Integer num) {
        this.f120034t = num;
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment
    public Function2 V() {
        return new Function2() { // from class: cz.mobilesoft.coreblock.scene.statistics.overview.i
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return StatisticsOverviewFragment.Z0(this.f120092a, (String) obj, (Collection) obj2);
            }
        };
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment
    public Function1 W() {
        return new Function1() { // from class: cz.mobilesoft.coreblock.scene.statistics.overview.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatisticsOverviewFragment.a1(this.f120091a, (List) obj);
            }
        };
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment
    public RecyclerView Z() {
        RecyclerView appsWebsRecyclerView = ((FragmentStatisticsOverviewBinding) w()).f96689d;
        Intrinsics.checkNotNullExpressionValue(appsWebsRecyclerView, "appsWebsRecyclerView");
        return appsWebsRecyclerView;
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment
    public Integer a0() {
        Pair pair = this.f120030p;
        if (pair != null) {
            RecyclerView.Adapter adapter = d0().f96819c.getAdapter();
            StatisticsGraphViewPagerAdapter statisticsGraphViewPagerAdapter = adapter instanceof StatisticsGraphViewPagerAdapter ? (StatisticsGraphViewPagerAdapter) adapter : null;
            Integer numValueOf = statisticsGraphViewPagerAdapter != null ? Integer.valueOf(statisticsGraphViewPagerAdapter.D(pair, true)) : null;
            if (numValueOf == null || numValueOf.intValue() != -1) {
                this.f120034t = numValueOf;
                this.f120030p = null;
            }
        }
        return this.f120034t;
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment
    public View c0() {
        FrameLayout fragmentContainer = ((FragmentStatisticsOverviewBinding) w()).f96696k;
        Intrinsics.checkNotNullExpressionValue(fragmentContainer, "fragmentContainer");
        return fragmentContainer;
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment
    public LayoutStatisticsHeaderBinding d0() {
        LayoutStatisticsHeaderBinding statisticsHeaderView = ((FragmentStatisticsOverviewBinding) w()).f96700o;
        Intrinsics.checkNotNullExpressionValue(statisticsHeaderView, "statisticsHeaderView");
        return statisticsHeaderView;
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment
    /* JADX INFO: renamed from: d1, reason: merged with bridge method [inline-methods] */
    public StatisticsOverviewFragmentViewModel h0() {
        return (StatisticsOverviewFragmentViewModel) this.f120026l.getValue();
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment
    public LayoutStatisticsToolbarBinding f0() {
        LayoutStatisticsToolbarBinding statisticsToolbar = ((FragmentStatisticsOverviewBinding) w()).f96701p;
        Intrinsics.checkNotNullExpressionValue(statisticsToolbar, "statisticsToolbar");
        return statisticsToolbar;
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: f1, reason: merged with bridge method [inline-methods] */
    public void x(FragmentStatisticsOverviewBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.x(binding);
        FlowsExtKt.b(this, FlowLiveDataConversions.a(h0().a1()), b1().W(), b1().Z(), new Function3() { // from class: cz.mobilesoft.coreblock.scene.statistics.overview.f
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StatisticsOverviewFragment.g1(this.f120089a, (BaseStatisticsFragmentViewModel.BaseStatisticsFilter) obj, ((Boolean) obj2).booleanValue(), ((Boolean) obj3).booleanValue());
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: j1, reason: merged with bridge method [inline-methods] */
    public void y(FragmentStatisticsOverviewBinding binding, View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(view, "view");
        super.y(binding, view, bundle);
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        ActionBar supportActionBar = ((AppCompatActivity) activity).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.v(0.0f);
        }
        h1();
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment
    public void o0() {
        AnswersHelper.f128199a.T6("overview");
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Serializable serializable;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null && (serializable = arguments.getSerializable("STATISTICS_INTERVAL")) != null) {
            this.f120030p = (Pair) serializable;
            h0().i1(StatisticsTimeFilter.WEEK);
        }
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        inflater.inflate(R.menu.f95739g, menu);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        int itemId = item.getItemId();
        if (itemId == R.id.U1) {
            this.f120033s.b(new Intent(getContext(), (Class<?>) IgnoreListActivity.class));
            return true;
        }
        if (itemId != R.id.f95592a2) {
            return super.onOptionsItemSelected(item);
        }
        m1();
        return true;
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment, cz.mobilesoft.coreblock.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        h0().l1();
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment, cz.mobilesoft.coreblock.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        i0(false);
        h0().a1().j(getViewLifecycleOwner(), new StatisticsOverviewFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.statistics.overview.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StatisticsOverviewFragment.k1(this.f120087a, (BaseStatisticsFragmentViewModel.BaseStatisticsFilter) obj);
            }
        }));
        ((FragmentStatisticsOverviewBinding) w()).f96692g.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.statistics.overview.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                StatisticsOverviewFragment.l1(this.f120088a, view2);
            }
        });
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment
    public void p0() {
        AnswersHelper.f128199a.V6("overview");
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment
    /* JADX INFO: renamed from: p1, reason: merged with bridge method [inline-methods] */
    public FragmentStatisticsOverviewBinding z(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentStatisticsOverviewBinding fragmentStatisticsOverviewBindingC = FragmentStatisticsOverviewBinding.c(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(fragmentStatisticsOverviewBindingC, "inflate(...)");
        return fragmentStatisticsOverviewBindingC;
    }
}
