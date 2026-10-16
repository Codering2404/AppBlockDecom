package cz.mobilesoft.coreblock.scene.statistics;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.fragment.BaseFragment;
import cz.mobilesoft.coreblock.base.fragment.BaseScrollViewFragment;
import cz.mobilesoft.coreblock.databinding.LayoutStatisticsHeaderBinding;
import cz.mobilesoft.coreblock.databinding.LayoutStatisticsToolbarBinding;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.StatisticsTimeFilter;
import cz.mobilesoft.coreblock.enums.StatisticsUsageTypeFilter;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel;
import cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragmentViewModel.BaseStatisticsFilter;
import cz.mobilesoft.coreblock.scene.statistics.adapter.AppsWebsAdapter;
import cz.mobilesoft.coreblock.scene.statistics.adapter.LinearLayoutManagerCatchingInconsistencies;
import cz.mobilesoft.coreblock.scene.statistics.adapter.StatisticsGraphViewPagerAdapter;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.util.StatisticsHelper;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
import org.koin.core.Koin;
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
public abstract class BaseStatisticsFragment<F extends BaseStatisticsFragmentViewModel.BaseStatisticsFilter, VM extends BaseStatisticsFragmentViewModel<F>, Binding extends ViewBinding> extends BaseFragment<Binding> implements BaseScrollViewFragment.OnScrollStateChangedListener, KoinComponent {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AppsWebsAdapter f119605b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f119607d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f119611i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private StatisticsTimeFilter f119612j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f119613k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f119606c = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final StatisticsUsageTypeFilter[] f119608f = StatisticsUsageTypeFilter.Companion.d();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final CoroutineScope f119609g = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b(null, 1, null)).plus(CoroutinesHelperExtKt.b()));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f119610h = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.statistics.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BaseStatisticsFragment.C0(this.f119751a);
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f119614a;

        static {
            int[] iArr = new int[StatisticsTimeFilter.values().length];
            try {
                iArr[StatisticsTimeFilter.DAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StatisticsTimeFilter.WEEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f119614a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseStatisticsFragment() {
        final Qualifier qualifier = null;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f119613k = LazyKt.a(lazyThreadSafetyModeB, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), qualifier, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(LayoutStatisticsHeaderBinding layoutStatisticsHeaderBinding, BaseStatisticsFragmentViewModel.BaseStatisticsFilter baseStatisticsFilter) {
        RecyclerView.Adapter adapter = layoutStatisticsHeaderBinding.f96819c.getAdapter();
        StatisticsGraphViewPagerAdapter statisticsGraphViewPagerAdapter = adapter instanceof StatisticsGraphViewPagerAdapter ? (StatisticsGraphViewPagerAdapter) adapter : null;
        if (statisticsGraphViewPagerAdapter != null) {
            Intrinsics.checkNotNull(baseStatisticsFilter);
            statisticsGraphViewPagerAdapter.E(baseStatisticsFilter);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(BaseStatisticsFragment baseStatisticsFragment, LayoutStatisticsHeaderBinding layoutStatisticsHeaderBinding, List list) {
        baseStatisticsFragment.h0().a1().n(baseStatisticsFragment.h0().a1().f());
        baseStatisticsFragment.h0().l1();
        RecyclerView.Adapter adapter = layoutStatisticsHeaderBinding.f96819c.getAdapter();
        StatisticsGraphViewPagerAdapter statisticsGraphViewPagerAdapter = adapter instanceof StatisticsGraphViewPagerAdapter ? (StatisticsGraphViewPagerAdapter) adapter : null;
        if (statisticsGraphViewPagerAdapter != null) {
            statisticsGraphViewPagerAdapter.F(list);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NestedScrollView C0(BaseStatisticsFragment baseStatisticsFragment) {
        View view = baseStatisticsFragment.getView();
        NestedScrollView nestedScrollView = view != null ? (NestedScrollView) view.findViewById(R.id.Q1) : null;
        if (nestedScrollView != null) {
            return nestedScrollView;
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public static /* synthetic */ void E0(BaseStatisticsFragment baseStatisticsFragment, int i3, boolean z2, boolean z3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCurrentPage");
        }
        if ((i4 & 1) != 0) {
            Integer numA0 = baseStatisticsFragment.a0();
            if (numA0 != null) {
                i3 = numA0.intValue();
            } else {
                RecyclerView.Adapter adapter = baseStatisticsFragment.d0().f96819c.getAdapter();
                i3 = adapter != null ? adapter.getItemCount() - 1 : 0;
            }
        }
        if ((i4 & 2) != 0) {
            z2 = true;
        }
        if ((i4 & 4) != 0) {
            z3 = false;
        }
        baseStatisticsFragment.D0(i3, z2, z3);
    }

    private final void G0(LayoutStatisticsHeaderBinding layoutStatisticsHeaderBinding, int i3) {
        ImageButton imageButton = layoutStatisticsHeaderBinding.f96824h;
        imageButton.setEnabled(i3 != 0);
        Intrinsics.checkNotNull(imageButton);
        imageButton.setVisibility(i3 == 0 ? 4 : 0);
        ImageButton imageButton2 = layoutStatisticsHeaderBinding.f96826j;
        RecyclerView.Adapter adapter = layoutStatisticsHeaderBinding.f96819c.getAdapter();
        imageButton2.setEnabled(i3 != (adapter != null ? adapter.getItemCount() - 1 : 0));
        Intrinsics.checkNotNull(imageButton2);
        RecyclerView.Adapter adapter2 = layoutStatisticsHeaderBinding.f96819c.getAdapter();
        imageButton2.setVisibility(i3 == (adapter2 != null ? adapter2.getItemCount() - 1 : 0) ? 4 : 0);
    }

    private final void H0(LayoutStatisticsHeaderBinding layoutStatisticsHeaderBinding, long j3) {
        layoutStatisticsHeaderBinding.f96821e.setText(StatisticsHelper.f128018a.e(j3));
    }

    private final void I0(LayoutStatisticsHeaderBinding layoutStatisticsHeaderBinding, Integer num) {
        String string;
        if (num == null) {
            layoutStatisticsHeaderBinding.f96820d.setVisibility(4);
            Unit unit = Unit.f139807a;
            return;
        }
        int iIntValue = num.intValue();
        TextView textView = layoutStatisticsHeaderBinding.f96820d;
        textView.setVisibility(0);
        int i3 = WhenMappings.f119614a[h0().b1().ordinal()];
        if (i3 == 1) {
            string = getString(R.string.jA, Integer.valueOf(iIntValue));
        } else {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            string = getString(R.string.kA, Integer.valueOf(iIntValue));
        }
        textView.setText(string);
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(AppCompatResources.b(layoutStatisticsHeaderBinding.f96820d.getContext(), iIntValue > 0 ? R.drawable.F5 : R.drawable.E5), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private final void K0(LayoutStatisticsHeaderBinding layoutStatisticsHeaderBinding, BaseStatisticsFragmentViewModel.BaseStatisticsFilter baseStatisticsFilter) {
        int i3 = WhenMappings.f119614a[h0().b1().ordinal()];
        if (i3 == 1) {
            layoutStatisticsHeaderBinding.f96823g.setText(StatisticsHelper.f128018a.c(baseStatisticsFilter.b()));
            H0(layoutStatisticsHeaderBinding, baseStatisticsFilter.b());
        } else {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            TextView textView = layoutStatisticsHeaderBinding.f96823g;
            StatisticsHelper statisticsHelper = StatisticsHelper.f128018a;
            Context contextRequireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
            textView.setText(statisticsHelper.m(contextRequireContext, baseStatisticsFilter.b(), baseStatisticsFilter.a()));
        }
    }

    private final void L0(LayoutStatisticsHeaderBinding layoutStatisticsHeaderBinding) {
        if (h0().g1()) {
            layoutStatisticsHeaderBinding.f96821e.setText(getString(R.string.mG));
        } else {
            layoutStatisticsHeaderBinding.f96821e.setText(getString(R.string.S8));
        }
    }

    private final Function2 T() {
        return new Function2() { // from class: cz.mobilesoft.coreblock.scene.statistics.c
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return BaseStatisticsFragment.U(this.f119799a, (String) obj, (Collection) obj2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(BaseStatisticsFragment baseStatisticsFragment, String str, Collection collection) {
        FragmentActivity activity = baseStatisticsFragment.getActivity();
        if (activity != null) {
            StatisticsProfileListBottomSheet.f119691u.a(str, collection, baseStatisticsFragment).show(activity.getSupportFragmentManager(), "addToBlocking");
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(BaseStatisticsFragment baseStatisticsFragment) {
        FragmentActivity activity = baseStatisticsFragment.getActivity();
        if (activity != null) {
            baseStatisticsFragment.startActivity(Paywall.c(Paywall.f113165a, activity, PaywallTarget.Generic.INSTANCE, "statistics_tab", "unlimited_apps", false, false, false, null, 240, null));
        }
        return Unit.f139807a;
    }

    private final EventDataStore b0() {
        return (EventDataStore) this.f119613k.getValue();
    }

    private final NestedScrollView e0() {
        return (NestedScrollView) this.f119610h.getValue();
    }

    private final void j0(LayoutStatisticsToolbarBinding layoutStatisticsToolbarBinding) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        int i3 = R.layout.f95721s0;
        ArrayAdapter arrayAdapter = new ArrayAdapter(context, i3, android.R.id.text1, g0());
        int i4 = R.layout.f95719r0;
        arrayAdapter.setDropDownViewResource(i4);
        layoutStatisticsToolbarBinding.f96829c.setAdapter((SpinnerAdapter) arrayAdapter);
        layoutStatisticsToolbarBinding.f96829c.setSelection(ArraysKt.indexOf(g0(), h0().c1()));
        layoutStatisticsToolbarBinding.f96829c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment$initTopFilterListViews$2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView adapterView, View view, int i5, long j3) {
                this.f119615a.t0(i5);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView adapterView) {
            }
        });
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(context, i3, android.R.id.text1, StatisticsTimeFilter.values());
        arrayAdapter2.setDropDownViewResource(i4);
        layoutStatisticsToolbarBinding.f96830d.setAdapter((SpinnerAdapter) arrayAdapter2);
        layoutStatisticsToolbarBinding.f96830d.setSelection(h0().b1().ordinal());
        layoutStatisticsToolbarBinding.f96830d.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment$initTopFilterListViews$4
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView adapterView, View view, int i5, long j3) {
                if (this.f119616a.f119612j != ((StatisticsTimeFilter[]) StatisticsTimeFilter.getEntries().toArray(new StatisticsTimeFilter[0]))[i5]) {
                    this.f119616a.o0();
                }
                this.f119616a.h0().i1(((StatisticsTimeFilter[]) StatisticsTimeFilter.getEntries().toArray(new StatisticsTimeFilter[0]))[i5]);
                this.f119616a.J0();
                RecyclerView.Adapter adapter = this.f119616a.d0().f96819c.getAdapter();
                Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type cz.mobilesoft.coreblock.scene.statistics.adapter.StatisticsGraphViewPagerAdapter");
                BaseStatisticsFragment baseStatisticsFragment = this.f119616a;
                ((StatisticsGraphViewPagerAdapter) adapter).I(baseStatisticsFragment.h0().b1());
                BaseStatisticsFragment.E0(baseStatisticsFragment, 0, false, true, 1, null);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView adapterView) {
            }
        });
    }

    private final void k0(LayoutStatisticsHeaderBinding layoutStatisticsHeaderBinding) {
        final ViewPager2 viewPager2 = layoutStatisticsHeaderBinding.f96819c;
        viewPager2.setAdapter(n0());
        viewPager2.g(new ViewPager2.OnPageChangeCallback() { // from class: cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment$initViewPager$1$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void a(int i3) {
                if (i3 == 0) {
                    if (!this.f119617a.f119611i) {
                        AnswersHelper.f128199a.U6("swipe_change_interval");
                    }
                    this.f119617a.f119611i = false;
                    this.f119617a.q0();
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void c(int i3) {
                if (viewPager2.getScrollState() == 0) {
                    this.f119617a.q0();
                }
            }
        });
        ImageButton leftArrowButton = layoutStatisticsHeaderBinding.f96824h;
        Intrinsics.checkNotNullExpressionValue(leftArrowButton, "leftArrowButton");
        int i3 = R.dimen.f95487u;
        ViewHelperExtKt.i(leftArrowButton, i3);
        ImageButton rightArrowButton = layoutStatisticsHeaderBinding.f96826j;
        Intrinsics.checkNotNullExpressionValue(rightArrowButton, "rightArrowButton");
        ViewHelperExtKt.i(rightArrowButton, i3);
        layoutStatisticsHeaderBinding.f96824h.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.statistics.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseStatisticsFragment.l0(this.f120020a, viewPager2, view);
            }
        });
        layoutStatisticsHeaderBinding.f96826j.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.statistics.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseStatisticsFragment.m0(this.f119797a, viewPager2, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(BaseStatisticsFragment baseStatisticsFragment, ViewPager2 viewPager2, View view) {
        AnswersHelper.f128199a.U6("button_change_interval");
        baseStatisticsFragment.f119611i = true;
        if (viewPager2.getCurrentItem() > 0) {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(BaseStatisticsFragment baseStatisticsFragment, ViewPager2 viewPager2, View view) {
        AnswersHelper.f128199a.U6("button_change_interval");
        baseStatisticsFragment.f119611i = true;
        int currentItem = viewPager2.getCurrentItem();
        RecyclerView.Adapter adapter = viewPager2.getAdapter();
        if (currentItem < (adapter != null ? adapter.getItemCount() - 1 : 0)) {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0() {
        LayoutStatisticsHeaderBinding layoutStatisticsHeaderBindingD0 = d0();
        RecyclerView.Adapter adapter = layoutStatisticsHeaderBindingD0.f96819c.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type cz.mobilesoft.coreblock.scene.statistics.adapter.StatisticsGraphViewPagerAdapter");
        Pair pairC = ((StatisticsGraphViewPagerAdapter) adapter).C(layoutStatisticsHeaderBindingD0.f96819c.getCurrentItem());
        BaseStatisticsFragmentViewModel.BaseStatisticsFilter baseStatisticsFilter = (BaseStatisticsFragmentViewModel.BaseStatisticsFilter) h0().a1().f();
        if (baseStatisticsFilter != null) {
            baseStatisticsFilter.g(((Number) pairC.e()).longValue());
            baseStatisticsFilter.f(((Number) pairC.f()).longValue());
            h0().a1().n(baseStatisticsFilter);
            K0(layoutStatisticsHeaderBindingD0, baseStatisticsFilter);
        }
        G0(layoutStatisticsHeaderBindingD0, layoutStatisticsHeaderBindingD0.f96819c.getCurrentItem());
    }

    private final void s0(NestedScrollView nestedScrollView) {
        boolean z2 = false;
        if (nestedScrollView != null && nestedScrollView.canScrollVertically(-1)) {
            z2 = true;
        }
        e(!z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0(int i3) {
        p0();
        if (i3 == ArraysKt.indexOf(g0(), StatisticsUsageTypeFilter.USAGE_TIME) || h0().f1()) {
            e0().setVisibility(0);
            c0().setVisibility(8);
            StatisticsUsageTypeFilter statisticsUsageTypeFilter = g0()[i3];
            h0().j1(statisticsUsageTypeFilter);
            RecyclerView.Adapter adapter = d0().f96819c.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type cz.mobilesoft.coreblock.scene.statistics.adapter.StatisticsGraphViewPagerAdapter");
            ((StatisticsGraphViewPagerAdapter) adapter).J(statisticsUsageTypeFilter);
            J0();
            return;
        }
        Pair pairA = i3 == ArraysKt.indexOf(g0(), StatisticsUsageTypeFilter.UNLOCKS) ? TuplesKt.a(PremiumFeature.STATISTICS_SCREEN_UNLOCKS, "screen_unlocks") : TuplesKt.a(PremiumFeature.STATISTICS_LAUNCH_COUNT, "launch_count");
        PremiumFeature premiumFeature = (PremiumFeature) pairA.a();
        String str = (String) pairA.b();
        Paywall paywall = Paywall.f113165a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        startActivity(Paywall.c(paywall, contextRequireContext, new PaywallTarget.LimitScreen(premiumFeature), "statistics_tab", str, false, false, false, null, 240, null));
        f0().f96829c.setSelection(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(BaseStatisticsFragment baseStatisticsFragment, List list) {
        AppsWebsAdapter appsWebsAdapter = baseStatisticsFragment.f119605b;
        if (appsWebsAdapter != null) {
            appsWebsAdapter.i(list);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(BaseStatisticsFragment baseStatisticsFragment, LayoutStatisticsHeaderBinding layoutStatisticsHeaderBinding, View view) {
        if (baseStatisticsFragment.f0().f96830d.getSelectedItem() == StatisticsTimeFilter.WEEK) {
            baseStatisticsFragment.h0().k1(!baseStatisticsFragment.h0().g1());
            baseStatisticsFragment.h0().l1();
            baseStatisticsFragment.L0(layoutStatisticsHeaderBinding);
            AnswersHelper.f128199a.O6();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(BaseStatisticsFragment baseStatisticsFragment, NestedScrollView nestedScrollView, int i3, int i4, int i5, int i6) {
        baseStatisticsFragment.s0(nestedScrollView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(LayoutStatisticsHeaderBinding layoutStatisticsHeaderBinding, BaseStatisticsFragment baseStatisticsFragment, Double d3) {
        if (Intrinsics.areEqual(d3, 0.0d)) {
            layoutStatisticsHeaderBinding.f96825i.setVisibility(0);
            layoutStatisticsHeaderBinding.f96822f.setVisibility(4);
        } else {
            layoutStatisticsHeaderBinding.f96825i.setVisibility(4);
            layoutStatisticsHeaderBinding.f96822f.setVisibility(0);
        }
        if (baseStatisticsFragment.h0().c1() == StatisticsUsageTypeFilter.USAGE_TIME) {
            if (baseStatisticsFragment.getContext() != null) {
                TextView headerTimeTextView = layoutStatisticsHeaderBinding.f96822f;
                Intrinsics.checkNotNullExpressionValue(headerTimeTextView, "headerTimeTextView");
                StatisticsHelper.p(headerTimeTextView, (long) d3.doubleValue(), 0, 0, 12, null);
            }
        } else if (baseStatisticsFragment.getContext() != null) {
            TextView headerTimeTextView2 = layoutStatisticsHeaderBinding.f96822f;
            Intrinsics.checkNotNullExpressionValue(headerTimeTextView2, "headerTimeTextView");
            Intrinsics.checkNotNull(d3);
            StatisticsHelper.q(headerTimeTextView2, d3.doubleValue());
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(BaseStatisticsFragment baseStatisticsFragment, LayoutStatisticsHeaderBinding layoutStatisticsHeaderBinding, Integer num) {
        baseStatisticsFragment.I0(layoutStatisticsHeaderBinding, num);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(LayoutStatisticsHeaderBinding layoutStatisticsHeaderBinding, BaseStatisticsFragment baseStatisticsFragment, StatisticsIntervalConfig statisticsIntervalConfig) {
        RecyclerView.Adapter adapter = layoutStatisticsHeaderBinding.f96819c.getAdapter();
        StatisticsGraphViewPagerAdapter statisticsGraphViewPagerAdapter = adapter instanceof StatisticsGraphViewPagerAdapter ? (StatisticsGraphViewPagerAdapter) adapter : null;
        if (statisticsGraphViewPagerAdapter != null) {
            Intrinsics.checkNotNull(statisticsIntervalConfig);
            statisticsGraphViewPagerAdapter.H(statisticsIntervalConfig);
            E0(baseStatisticsFragment, 0, false, false, 5, null);
        }
        return Unit.f139807a;
    }

    public final void D0(int i3, boolean z2, boolean z3) {
        ViewPager2 viewPager2 = d0().f96819c;
        if (viewPager2.getCurrentItem() == i3) {
            q0();
        } else if (i3 >= 0) {
            RecyclerView.Adapter adapter = viewPager2.getAdapter();
            if (i3 < (adapter != null ? adapter.getItemCount() : 0)) {
                viewPager2.j(i3, z2);
            }
        }
        if (z3) {
            F0(null);
        }
    }

    public abstract void F0(Integer num);

    public final void J0() {
        LayoutStatisticsHeaderBinding layoutStatisticsHeaderBindingD0 = d0();
        int i3 = WhenMappings.f119614a[h0().b1().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            L0(layoutStatisticsHeaderBindingD0);
        } else {
            RecyclerView.Adapter adapter = layoutStatisticsHeaderBindingD0.f96819c.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type cz.mobilesoft.coreblock.scene.statistics.adapter.StatisticsGraphViewPagerAdapter");
            H0(layoutStatisticsHeaderBindingD0, ((Number) ((StatisticsGraphViewPagerAdapter) adapter).C(layoutStatisticsHeaderBindingD0.f96819c.getCurrentItem()).e()).longValue());
        }
    }

    public Function2 V() {
        return null;
    }

    public Function1 W() {
        return null;
    }

    public Function0 X() {
        return new Function0() { // from class: cz.mobilesoft.coreblock.scene.statistics.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BaseStatisticsFragment.Y(this.f119800a);
            }
        };
    }

    public abstract RecyclerView Z();

    public abstract Integer a0();

    public abstract View c0();

    public abstract LayoutStatisticsHeaderBinding d0();

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseScrollViewFragment.OnScrollStateChangedListener
    public void e(boolean z2) {
        if (this.f119606c != z2) {
            this.f119606c = z2;
            LayoutStatisticsToolbarBinding layoutStatisticsToolbarBindingF0 = f0();
            if (z2) {
                layoutStatisticsToolbarBindingF0.f96828b.setElevation(0.0f);
            } else {
                layoutStatisticsToolbarBindingF0.f96828b.setElevation(this.f119607d);
            }
        }
    }

    public abstract LayoutStatisticsToolbarBinding f0();

    public StatisticsUsageTypeFilter[] g0() {
        return this.f119608f;
    }

    public abstract BaseStatisticsFragmentViewModel h0();

    public final void i0(boolean z2) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.f119605b = new AppsWebsAdapter(contextRequireContext, V(), W(), X(), z2, T());
        RecyclerView recyclerViewZ = Z();
        Context context = recyclerViewZ.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        recyclerViewZ.setLayoutManager(new LinearLayoutManagerCatchingInconsistencies(context));
        recyclerViewZ.setAdapter(this.f119605b);
    }

    public FragmentStateAdapter n0() {
        StatisticsUsageTypeFilter statisticsUsageTypeFilterC1 = h0().c1();
        StatisticsTimeFilter statisticsTimeFilterB1 = h0().b1();
        StatisticsIntervalConfig statisticsIntervalConfig = (StatisticsIntervalConfig) h0().V0().f();
        if (statisticsIntervalConfig == null) {
            statisticsIntervalConfig = new StatisticsIntervalConfig();
        }
        StatisticsGraphViewPagerAdapter statisticsGraphViewPagerAdapter = new StatisticsGraphViewPagerAdapter(this, statisticsUsageTypeFilterC1, statisticsTimeFilterB1, statisticsIntervalConfig, (List) BuildersKt__BuildersKt.b(null, new BaseStatisticsFragment$initViewPagerAdapter$1(this, null), 1, null), null, 32, null);
        statisticsGraphViewPagerAdapter.G();
        return statisticsGraphViewPagerAdapter;
    }

    public abstract void o0();

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f119607d = getResources().getDimensionPixelSize(R.dimen.f95488v);
        this.f119612j = h0().b1();
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        h0().h1();
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        h0().P0().j(getViewLifecycleOwner(), new BaseStatisticsFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.statistics.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseStatisticsFragment.u0(this.f119863a, (List) obj);
            }
        }));
        final LayoutStatisticsHeaderBinding layoutStatisticsHeaderBindingD0 = d0();
        G0(layoutStatisticsHeaderBindingD0, layoutStatisticsHeaderBindingD0.f96819c.getAdapter() != null ? r5.getItemCount() - 1 : 0);
        j0(f0());
        k0(d0());
        J0();
        layoutStatisticsHeaderBindingD0.f96822f.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.statistics.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BaseStatisticsFragment.v0(this.f119864a, layoutStatisticsHeaderBindingD0, view2);
            }
        });
        s0(e0());
        e0().setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: cz.mobilesoft.coreblock.scene.statistics.g
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void a(NestedScrollView nestedScrollView, int i3, int i4, int i5, int i6) {
                BaseStatisticsFragment.w0(this.f119866a, nestedScrollView, i3, i4, i5, i6);
            }
        });
        Spinner timeUsagesSpinner = f0().f96829c;
        Intrinsics.checkNotNullExpressionValue(timeUsagesSpinner, "timeUsagesSpinner");
        int i3 = R.dimen.f95487u;
        ViewHelperExtKt.q(timeUsagesSpinner, i3);
        Spinner weekDaySpinner = f0().f96830d;
        Intrinsics.checkNotNullExpressionValue(weekDaySpinner, "weekDaySpinner");
        ViewHelperExtKt.q(weekDaySpinner, i3);
        h0().R0().j(getViewLifecycleOwner(), new BaseStatisticsFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.statistics.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseStatisticsFragment.x0(layoutStatisticsHeaderBindingD0, this, (Double) obj);
            }
        }));
        h0().Q0().j(getViewLifecycleOwner(), new BaseStatisticsFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.statistics.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseStatisticsFragment.y0(this.f119869a, layoutStatisticsHeaderBindingD0, (Integer) obj);
            }
        }));
        h0().V0().j(getViewLifecycleOwner(), new BaseStatisticsFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.statistics.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseStatisticsFragment.z0(layoutStatisticsHeaderBindingD0, this, (StatisticsIntervalConfig) obj);
            }
        }));
        h0().a1().j(getViewLifecycleOwner(), new BaseStatisticsFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.statistics.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseStatisticsFragment.A0(layoutStatisticsHeaderBindingD0, (BaseStatisticsFragmentViewModel.BaseStatisticsFilter) obj);
            }
        }));
        h0().T0().j(getViewLifecycleOwner(), new BaseStatisticsFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.statistics.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseStatisticsFragment.B0(this.f120018a, layoutStatisticsHeaderBindingD0, (List) obj);
            }
        }));
        FlowExtKt.l(b0().K0(), this.f119609g, new FlowCollector() { // from class: cz.mobilesoft.coreblock.scene.statistics.BaseStatisticsFragment$onViewCreated$2$8
            public final Object a(long j3, Continuation continuation) {
                this.f119621a.h0().N0();
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Number) obj).longValue(), continuation);
            }
        });
    }

    public abstract void p0();

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
