package cz.mobilesoft.coreblock.scene.onboarding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NamedNavArgumentKt;
import androidx.navigation.NavArgumentBuilder;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.NavType;
import androidx.navigation.Navigator;
import androidx.navigation.PopUpToBuilder;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import com.facebook.CallbackManager;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.enums.SignInEntryPoint;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity;
import cz.mobilesoft.coreblock.scene.more.signin.SignInActivity;
import cz.mobilesoft.coreblock.scene.more.signin.SignInConfig;
import cz.mobilesoft.coreblock.scene.more.signin.SignInContentKt;
import cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewEventV2;
import cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewStateV2;
import cz.mobilesoft.coreblock.scene.onboarding.blockingtest.OnboardingBlockingTestKt;
import cz.mobilesoft.coreblock.scene.onboarding.schedule.OnboardingTemplateScreenKt;
import cz.mobilesoft.coreblock.scene.onboarding.statistics.IntroGraphScreenKt;
import cz.mobilesoft.coreblock.scene.onboarding.statistics.IntroReportScreenKt;
import cz.mobilesoft.coreblock.scene.onboarding.statistics.OnboardingCrucialWeekScreenKt;
import cz.mobilesoft.coreblock.scene.onboarding.statistics.OnboardingOverTheYearsScreenKt;
import cz.mobilesoft.coreblock.scene.onboarding.statistics.OnboardingStatsPermissionScreenKt;
import cz.mobilesoft.coreblock.scene.onboarding.statistics.OnboardingTimeOnPhoneScreenKt;
import cz.mobilesoft.coreblock.scene.onboarding.statistics.OnboardingYourPotentialScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.util.SessionManager;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.SplashContentKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.scope.Scope;

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
public final class OnboardingActivityV2 extends BaseComposeActivity {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f110880h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f110881i = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f110882f = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.o
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return OnboardingActivityV2.v2();
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f110883g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnboardingNavItem {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ OnboardingNavItem[] $VALUES;
        private final String route;
        public static final OnboardingNavItem Welcome = new OnboardingNavItem("Welcome", 0, "welcome");
        public static final OnboardingNavItem SignIn = new OnboardingNavItem("SignIn", 1, "sign_in");
        public static final OnboardingNavItem DataInfo = new OnboardingNavItem("DataInfo", 2, "data_info");
        public static final OnboardingNavItem DataUsage = new OnboardingNavItem("DataUsage", 3, "data_usage");
        public static final OnboardingNavItem TimeOnPhone = new OnboardingNavItem("TimeOnPhone", 4, "time_on_phone");
        public static final OnboardingNavItem StatsPermission = new OnboardingNavItem("StatsPermission", 5, "stats_permission");
        public static final OnboardingNavItem Statistics = new OnboardingNavItem("Statistics", 6, "statistics");
        public static final OnboardingNavItem Graph = new OnboardingNavItem("Graph", 7, "graph");
        public static final OnboardingNavItem YearsSpentSplash = new OnboardingNavItem("YearsSpentSplash", 8, "years_spent_splash");
        public static final OnboardingNavItem YearsSpent = new OnboardingNavItem("YearsSpent", 9, "years_spent");
        public static final OnboardingNavItem YourPotential = new OnboardingNavItem("YourPotential", 10, "your_potential");
        public static final OnboardingNavItem CrucialWeek = new OnboardingNavItem("CrucialWeek", 11, "crucial_week");
        public static final OnboardingNavItem BlockingTest = new OnboardingNavItem("BlockingTest", 12, "blocking_test");
        public static final OnboardingNavItem AppBlockCanHelpYou = new OnboardingNavItem("AppBlockCanHelpYou", 13, "app_block_can_help_you");
        public static final OnboardingNavItem FirstFocusSplash = new OnboardingNavItem("FirstFocusSplash", 14, "first_focus_splash");
        public static final OnboardingNavItem FirstFocus = new OnboardingNavItem("FirstFocus", 15, "first_focus");
        public static final OnboardingNavItem FirstFocusCondition = new OnboardingNavItem("FirstFocusCondition", 16, "first_focus_condition");
        public static final OnboardingNavItem FirstFocusApps = new OnboardingNavItem("FirstFocusApps", 17, "first_focus_apps");
        public static final OnboardingNavItem FirstFocusSummary = new OnboardingNavItem("FirstFocusSummary", 18, "first_focus_summary");

        private static final /* synthetic */ OnboardingNavItem[] $values() {
            return new OnboardingNavItem[]{Welcome, SignIn, DataInfo, DataUsage, TimeOnPhone, StatsPermission, Statistics, Graph, YearsSpentSplash, YearsSpent, YourPotential, CrucialWeek, BlockingTest, AppBlockCanHelpYou, FirstFocusSplash, FirstFocus, FirstFocusCondition, FirstFocusApps, FirstFocusSummary};
        }

        static {
            OnboardingNavItem[] onboardingNavItemArr$values = $values();
            $VALUES = onboardingNavItemArr$values;
            $ENTRIES = EnumEntriesKt.a(onboardingNavItemArr$values);
        }

        private OnboardingNavItem(String str, int i3, String str2) {
            this.route = str2;
        }

        public static EnumEntries<OnboardingNavItem> getEntries() {
            return $ENTRIES;
        }

        public static OnboardingNavItem valueOf(String str) {
            return (OnboardingNavItem) Enum.valueOf(OnboardingNavItem.class, str);
        }

        public static OnboardingNavItem[] values() {
            return (OnboardingNavItem[]) $VALUES.clone();
        }

        public final float getProgressBarFill() {
            return ordinal() / getEntries().size();
        }

        public final String getRoute() {
            return this.route;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f110927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f110928b;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f110927a = iArr;
            int[] iArr2 = new int[ProfileType.values().length];
            try {
                iArr2[ProfileType.USAGE_LIMIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[ProfileType.LAUNCH_COUNT.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            f110928b = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A1(Function1 function1, MutableState mutableState, Function1 function12, MutableState mutableState2, NavHostController navHostController, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.d() == -1 && !SessionManager.f127910a.r()) {
            function1.invoke(new SignInConfig(SignInEntryPoint.ONBOARDING, null, false, false, false, false, true, false, false, true, null, 1470, null));
        } else if (((Boolean) mutableState.getValue()).booleanValue()) {
            function12.invoke(OnboardingViewEventV2.OnOnboardingSkipped.f110939a);
            mutableState.setValue(Boolean.FALSE);
        } else {
            String route = (String) mutableState2.getValue();
            if (route == null) {
                route = OnboardingNavItem.FirstFocusSplash.getRoute();
            }
            mutableState2.setValue(null);
            NavController.P(navHostController, route, null, null, 6, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B1(final OnboardingViewStateV2 onboardingViewStateV2, final NavHostController navHostController, final OnboardingActivityV2 onboardingActivityV2, final Function1 function1, final CoroutineScope coroutineScope, final MutableState mutableState, final ManagedActivityResultLauncher managedActivityResultLauncher, final MutableState mutableState2, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.Welcome.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(863552552, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.onboarding.s
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivityV2.C1(onboardingViewStateV2, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.SignIn.getRoute() + "?alreadyAMember={alreadyAMember}", CollectionsKt.listOf(NamedNavArgumentKt.a("alreadyAMember", new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.b0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OnboardingActivityV2.F1((NavArgumentBuilder) obj);
            }
        })), null, null, null, null, null, null, ComposableLambdaKt.c(2065408223, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.onboarding.c0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivityV2.U1(onboardingViewStateV2, onboardingActivityV2, navHostController, function1, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 252, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.DataInfo.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1652363360, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.onboarding.d0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivityV2.X1(onboardingViewStateV2, navHostController, coroutineScope, mutableState, onboardingActivityV2, managedActivityResultLauncher, function1, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.DataUsage.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1075167647, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.onboarding.e0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivityV2.c2(navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.TimeOnPhone.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-497971934, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.onboarding.f0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivityV2.e2(onboardingViewStateV2, function1, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.StatsPermission.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(79223779, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.onboarding.g0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivityV2.g2(onboardingViewStateV2, coroutineScope, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.Statistics.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(656419492, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.onboarding.h0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivityV2.j2(onboardingViewStateV2, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.Graph.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(1233615205, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.onboarding.i0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivityV2.l2(onboardingViewStateV2, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.YearsSpentSplash.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(1810810918, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.onboarding.j0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivityV2.n2(this.f111225a, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.YearsSpent.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1906960665, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.onboarding.t
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivityV2.G1(onboardingViewStateV2, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.YourPotential.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(1813155795, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.onboarding.u
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivityV2.I1(onboardingViewStateV2, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.CrucialWeek.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1904615788, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.onboarding.v
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivityV2.K1(onboardingViewStateV2, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.BlockingTest.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1327420075, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.onboarding.w
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivityV2.M1(onboardingViewStateV2, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.AppBlockCanHelpYou.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-750224362, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.onboarding.x
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivityV2.O1(onboardingViewStateV2, coroutineScope, mutableState2, onboardingActivityV2, managedActivityResultLauncher, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.FirstFocusSplash.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-173028649, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.onboarding.y
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivityV2.Q1(this.f111623a, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, OnboardingNavItem.FirstFocus.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(404167064, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.onboarding.a0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingActivityV2.R1(onboardingViewStateV2, function1, onboardingActivityV2, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C1(final OnboardingViewStateV2 onboardingViewStateV2, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(863552552, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivityV2.kt:277)");
        }
        boolean z2 = !onboardingViewStateV2.s();
        boolean zR = onboardingViewStateV2.r();
        boolean Z = composer.Z(onboardingViewStateV2) | composer.I(navHostController);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.i1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivityV2.D1(onboardingViewStateV2, navHostController);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean Z2 = composer.Z(onboardingViewStateV2) | composer.I(navHostController);
        Object objG2 = composer.G();
        if (Z2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.j1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivityV2.E1(onboardingViewStateV2, navHostController);
                }
            };
            composer.w(objG2);
        }
        OnboardingWelcomeScreenKt.l(z2, zR, function0, (Function0) objG2, composer, 0, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D1(OnboardingViewStateV2 onboardingViewStateV2, NavHostController navHostController) {
        AnswersHelper.f128199a.D3(onboardingViewStateV2.n(), onboardingViewStateV2.l().getKey());
        if (onboardingViewStateV2.o()) {
            NavController.P(navHostController, OnboardingNavItem.DataInfo.getRoute(), null, null, 6, null);
        } else {
            NavController.P(navHostController, OnboardingNavItem.SignIn.getRoute(), null, null, 6, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E1(OnboardingViewStateV2 onboardingViewStateV2, NavHostController navHostController) {
        AnswersHelper answersHelper = AnswersHelper.f128199a;
        answersHelper.D3(onboardingViewStateV2.n(), onboardingViewStateV2.l().getKey());
        answersHelper.h3();
        NavController.P(navHostController, OnboardingNavItem.SignIn.getRoute() + "?alreadyAMember=true", null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F1(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.d(NavType.f48967n);
        navArgument.b(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G1(OnboardingViewStateV2 onboardingViewStateV2, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1906960665, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivityV2.kt:420)");
        }
        float fU = onboardingViewStateV2.u(OnboardingNavItem.YearsSpent.getRoute());
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.w0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivityV2.H1(navHostController);
                }
            };
            composer.w(objG);
        }
        OnboardingOverTheYearsScreenKt.f(fU, onboardingViewStateV2, (Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H1(NavHostController navHostController) {
        NavController.P(navHostController, OnboardingNavItem.YourPotential.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I1(final OnboardingViewStateV2 onboardingViewStateV2, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1813155795, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivityV2.kt:429)");
        }
        float fU = onboardingViewStateV2.u(OnboardingNavItem.YourPotential.getRoute());
        boolean zI = composer.I(navHostController) | composer.Z(onboardingViewStateV2);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.d1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivityV2.J1(navHostController, onboardingViewStateV2);
                }
            };
            composer.w(objG);
        }
        OnboardingYourPotentialScreenKt.C(fU, onboardingViewStateV2, (Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J1(NavHostController navHostController, OnboardingViewStateV2 onboardingViewStateV2) {
        NavController.P(navHostController, onboardingViewStateV2.t(OnboardingNavItem.YourPotential.getRoute()), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K1(final OnboardingViewStateV2 onboardingViewStateV2, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1904615788, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivityV2.kt:438)");
        }
        float fU = onboardingViewStateV2.u(OnboardingNavItem.CrucialWeek.getRoute());
        boolean Z = composer.Z(onboardingViewStateV2) | composer.I(navHostController);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.h1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivityV2.L1(onboardingViewStateV2, navHostController);
                }
            };
            composer.w(objG);
        }
        OnboardingCrucialWeekScreenKt.h(fU, (Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L1(OnboardingViewStateV2 onboardingViewStateV2, NavHostController navHostController) {
        String strT = onboardingViewStateV2.t(OnboardingNavItem.CrucialWeek.getRoute());
        if (Intrinsics.areEqual(strT, OnboardingNavItem.BlockingTest.getRoute())) {
            AnswersHelper.f128199a.W0();
        }
        NavController.P(navHostController, strT, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M1(final OnboardingViewStateV2 onboardingViewStateV2, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1327420075, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivityV2.kt:450)");
        }
        float fU = onboardingViewStateV2.u(OnboardingNavItem.BlockingTest.getRoute());
        boolean zI = composer.I(navHostController) | composer.Z(onboardingViewStateV2);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.y0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivityV2.N1(navHostController, onboardingViewStateV2);
                }
            };
            composer.w(objG);
        }
        OnboardingBlockingTestKt.l(fU, (Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N1(NavHostController navHostController, OnboardingViewStateV2 onboardingViewStateV2) {
        NavController.P(navHostController, onboardingViewStateV2.t(OnboardingNavItem.BlockingTest.getRoute()), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O1(final OnboardingViewStateV2 onboardingViewStateV2, final CoroutineScope coroutineScope, final MutableState mutableState, final OnboardingActivityV2 onboardingActivityV2, final ManagedActivityResultLauncher managedActivityResultLauncher, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-750224362, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivityV2.kt:458)");
        }
        float fU = onboardingViewStateV2.u(OnboardingNavItem.AppBlockCanHelpYou.getRoute());
        boolean zI = composer.I(coroutineScope) | composer.Z(onboardingViewStateV2) | composer.Z(mutableState) | composer.I(onboardingActivityV2) | composer.I(managedActivityResultLauncher) | composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            Function0 function0 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.b1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivityV2.P1(coroutineScope, onboardingViewStateV2, mutableState, onboardingActivityV2, managedActivityResultLauncher, navHostController);
                }
            };
            composer.w(function0);
            objG = function0;
        }
        OnboardingAppBlockCanHelpYouScreenKt.c(fU, (Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P1(CoroutineScope coroutineScope, OnboardingViewStateV2 onboardingViewStateV2, MutableState mutableState, OnboardingActivityV2 onboardingActivityV2, ManagedActivityResultLauncher managedActivityResultLauncher, NavHostController navHostController) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new OnboardingActivityV2$NavigationHost$1$1$15$1$1$1(onboardingViewStateV2, mutableState, onboardingActivityV2, managedActivityResultLauncher, navHostController, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q1(OnboardingActivityV2 onboardingActivityV2, NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-173028649, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivityV2.kt:480)");
        }
        onboardingActivityV2.s1(navHostController, StringResources_androidKt.b(R.string.Bl, composer, 0), OnboardingNavItem.FirstFocus.getRoute(), OnboardingNavItem.FirstFocusSplash.getRoute(), composer, 3456);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R1(OnboardingViewStateV2 onboardingViewStateV2, final Function1 function1, final OnboardingActivityV2 onboardingActivityV2, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(404167064, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivityV2.kt:488)");
        }
        float fU = onboardingViewStateV2.u(OnboardingNavItem.FirstFocus.getRoute());
        OnboardingViewStateV2.OnboardingVariant onboardingVariantM = onboardingViewStateV2.m();
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.l0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivityV2.S1(function1);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean zI = composer.I(onboardingActivityV2);
        Object objG2 = composer.G();
        if (zI || objG2 == Composer.f23746a.a()) {
            objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.m0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OnboardingActivityV2.T1(this.f111243a, (ProfileType) obj);
                }
            };
            composer.w(objG2);
        }
        OnboardingTemplateScreenKt.h(fU, onboardingVariantM, function0, (Function1) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S1(Function1 function1) {
        AnswersHelper.f128199a.j3(OnboardingNavItem.FirstFocus.getRoute());
        function1.invoke(OnboardingViewEventV2.OnOnboardingSkipped.f110939a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T1(OnboardingActivityV2 onboardingActivityV2, ProfileType profileType) {
        Intrinsics.checkNotNullParameter(profileType, "profileType");
        int i3 = WhenMappings.f110928b[profileType.ordinal()];
        onboardingActivityV2.startActivity(ScheduleActivity.Companion.b(ScheduleActivity.f114377m, onboardingActivityV2, new ScheduleDescriptor.CombinationOnboardingV2(profileType, i3 != 1 ? i3 != 2 ? null : new ConditionDTO.LaunchCountDTO(0L, null, 0L, null, null, 31, null) : new ConditionDTO.UsageLimitDTO(0L, null, 0L, null, null, 31, null)), false, false, 12, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U1(OnboardingViewStateV2 onboardingViewStateV2, OnboardingActivityV2 onboardingActivityV2, final NavHostController navHostController, final Function1 function1, AnimatedContentScope composable, NavBackStackEntry backStackEntry, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
        if (ComposerKt.M()) {
            ComposerKt.U(2065408223, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivityV2.kt:302)");
        }
        Bundle bundleB = backStackEntry.b();
        boolean z2 = bundleB != null ? bundleB.getBoolean("alreadyAMember") : false;
        float fU = onboardingViewStateV2.u(OnboardingNavItem.SignIn.getRoute());
        CallbackManager callbackManagerW2 = onboardingActivityV2.w2();
        SignInConfig signInConfig = new SignInConfig(SignInEntryPoint.ONBOARDING, null, z2 && !onboardingViewStateV2.n(), !z2, true, false, false, false, !z2, true, null, 1250, null);
        Float fValueOf = Float.valueOf(fU);
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.z0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OnboardingActivityV2.V1(navHostController, ((Boolean) obj).booleanValue());
                }
            };
            composer.w(objG);
        }
        Function1 function12 = (Function1) objG;
        boolean Z = composer.Z(function1);
        Object objG2 = composer.G();
        if (Z || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.a1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivityV2.W1(function1);
                }
            };
            composer.w(objG2);
        }
        SignInContentKt.R(fValueOf, signInConfig, callbackManagerW2, function12, (Function0) objG2, composer, 0, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V1(NavHostController navHostController, boolean z2) {
        if (z2) {
            NavController.P(navHostController, OnboardingNavItem.DataInfo.getRoute(), null, null, 6, null);
        } else {
            navHostController.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W1(Function1 function1) {
        function1.invoke(OnboardingViewEventV2.OnOnboardingSkipped.f110939a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X1(OnboardingViewStateV2 onboardingViewStateV2, final NavHostController navHostController, final CoroutineScope coroutineScope, final MutableState mutableState, final OnboardingActivityV2 onboardingActivityV2, final ManagedActivityResultLauncher managedActivityResultLauncher, final Function1 function1, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1652363360, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivityV2.kt:327)");
        }
        float fU = onboardingViewStateV2.u(OnboardingNavItem.DataInfo.getRoute());
        OnboardingViewStateV2.OnboardingVariant onboardingVariantM = onboardingViewStateV2.m();
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.n0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivityV2.Y1(navHostController);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean zI2 = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.o0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivityV2.Z1(navHostController);
                }
            };
            composer.w(objG2);
        }
        Function0 function02 = (Function0) objG2;
        boolean zI3 = composer.I(navHostController);
        Object objG3 = composer.G();
        if (zI3 || objG3 == Composer.f23746a.a()) {
            objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.p0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivityV2.a2(navHostController);
                }
            };
            composer.w(objG3);
        }
        Function0 function03 = (Function0) objG3;
        boolean zI4 = composer.I(coroutineScope) | composer.Z(mutableState) | composer.I(onboardingActivityV2) | composer.I(managedActivityResultLauncher) | composer.Z(function1);
        Object objG4 = composer.G();
        if (zI4 || objG4 == Composer.f23746a.a()) {
            Function0 function04 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.q0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivityV2.b2(coroutineScope, mutableState, onboardingActivityV2, managedActivityResultLauncher, function1);
                }
            };
            composer.w(function04);
            objG4 = function04;
        }
        OnboardingDataInfoScreenKt.h(fU, function0, function02, function03, (Function0) objG4, onboardingVariantM, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y1(NavHostController navHostController) {
        NavController.P(navHostController, OnboardingNavItem.TimeOnPhone.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z1(NavHostController navHostController) {
        NavController.P(navHostController, OnboardingNavItem.DataUsage.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a2(NavHostController navHostController) {
        AnswersHelper.f128199a.j3(OnboardingNavItem.DataInfo.getRoute());
        NavController.P(navHostController, OnboardingNavItem.StatsPermission.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b2(CoroutineScope coroutineScope, MutableState mutableState, OnboardingActivityV2 onboardingActivityV2, ManagedActivityResultLauncher managedActivityResultLauncher, Function1 function1) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new OnboardingActivityV2$NavigationHost$1$1$4$4$1$1(mutableState, onboardingActivityV2, managedActivityResultLauncher, function1, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c2(final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1075167647, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivityV2.kt:359)");
        }
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.s0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivityV2.d2(navHostController);
                }
            };
            composer.w(objG);
        }
        OnboardingDataUsageScreenKt.f((Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d2(NavHostController navHostController) {
        navHostController.R();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e2(OnboardingViewStateV2 onboardingViewStateV2, final Function1 function1, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-497971934, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivityV2.kt:365)");
        }
        float fU = onboardingViewStateV2.u(OnboardingNavItem.TimeOnPhone.getRoute());
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.r0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OnboardingActivityV2.f2(function1, ((Integer) obj).intValue());
                }
            };
            composer.w(objG);
        }
        OnboardingTimeOnPhoneScreenKt.c(fU, (Function1) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f2(Function1 function1, int i3) {
        AnswersHelper.f128199a.c3(i3);
        function1.invoke(new OnboardingViewEventV2.OnTimeOnPhoneAnswered(i3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g2(final OnboardingViewStateV2 onboardingViewStateV2, final CoroutineScope coroutineScope, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(79223779, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivityV2.kt:375)");
        }
        float fU = onboardingViewStateV2.u(OnboardingNavItem.StatsPermission.getRoute());
        OnboardingViewStateV2.OnboardingVariant onboardingVariantM = onboardingViewStateV2.m();
        boolean zI = composer.I(coroutineScope) | composer.Z(onboardingViewStateV2) | composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.e1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivityV2.h2(coroutineScope, onboardingViewStateV2, navHostController);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean zI2 = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.f1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivityV2.i2(navHostController);
                }
            };
            composer.w(objG2);
        }
        OnboardingStatsPermissionScreenKt.f(fU, onboardingVariantM, function0, (Function0) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h2(CoroutineScope coroutineScope, OnboardingViewStateV2 onboardingViewStateV2, NavHostController navHostController) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new OnboardingActivityV2$NavigationHost$1$1$7$1$1$1(onboardingViewStateV2, navHostController, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i2(NavHostController navHostController) {
        NavController.P(navHostController, OnboardingNavItem.AppBlockCanHelpYou.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j2(OnboardingViewStateV2 onboardingViewStateV2, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(656419492, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivityV2.kt:394)");
        }
        float fU = onboardingViewStateV2.u(OnboardingNavItem.Statistics.getRoute());
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.c1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivityV2.k2(navHostController);
                }
            };
            composer.w(objG);
        }
        IntroReportScreenKt.m(fU, onboardingViewStateV2, (Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k2(NavHostController navHostController) {
        NavController.P(navHostController, OnboardingNavItem.Graph.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l2(OnboardingViewStateV2 onboardingViewStateV2, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1233615205, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivityV2.kt:403)");
        }
        float fU = onboardingViewStateV2.u(OnboardingNavItem.Graph.getRoute());
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.x0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingActivityV2.m2(navHostController);
                }
            };
            composer.w(objG);
        }
        IntroGraphScreenKt.D(fU, onboardingViewStateV2, (Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m2(NavHostController navHostController) {
        NavController.P(navHostController, OnboardingNavItem.YearsSpentSplash.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n2(OnboardingActivityV2 onboardingActivityV2, NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1810810918, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2.NavigationHost.<anonymous>.<anonymous>.<anonymous> (OnboardingActivityV2.kt:412)");
        }
        onboardingActivityV2.s1(navHostController, StringResources_androidKt.b(R.string.km, composer, 0), OnboardingNavItem.YearsSpent.getRoute(), OnboardingNavItem.YearsSpentSplash.getRoute(), composer, 3456);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    private final void o1(final OnboardingViewModelV2 onboardingViewModelV2, final NavHostController navHostController, final ScaffoldState scaffoldState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Function1 function12;
        Composer composer2;
        Composer composerK = composer.k(-1902311715);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onboardingViewModelV2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(navHostController) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(scaffoldState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            function12 = function1;
            i4 |= composerK.I(function12) ? 2048 : 1024;
        } else {
            function12 = function1;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(this) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        int i5 = i4;
        if (composerK.r((i5 & 9363) != 9362, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1902311715, i5, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2.CommandProcessor (OnboardingActivityV2.kt:174)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objG;
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            boolean zI = composerK.I(this) | composerK.I(context);
            Object objG2 = composerK.G();
            if (zI || objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OnboardingActivityV2.p1(this.f111263a, context, (ActivityResult) obj);
                    }
                };
                composerK.w(objG2);
            }
            ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG2, composerK, 0);
            ActivityResultContracts.StartActivityForResult startActivityForResult2 = new ActivityResultContracts.StartActivityForResult();
            boolean zI2 = composerK.I(navHostController);
            Object objG3 = composerK.G();
            if (zI2 || objG3 == companion.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OnboardingActivityV2.q1(navHostController, (ActivityResult) obj);
                    }
                };
                composerK.w(objG3);
            }
            ManagedActivityResultLauncher managedActivityResultLauncherA2 = ActivityResultRegistryKt.a(startActivityForResult2, (Function1) objG3, composerK, 0);
            boolean zI3 = composerK.I(context) | composerK.I(onboardingViewModelV2) | composerK.I(navHostController) | ((i5 & 7168) == 2048) | composerK.I(managedActivityResultLauncherA) | composerK.I(this) | composerK.I(coroutineScope) | ((i5 & 896) == 256) | composerK.I(managedActivityResultLauncherA2);
            Object objG4 = composerK.G();
            if (zI3 || objG4 == companion.a()) {
                OnboardingActivityV2$CommandProcessor$1$1 onboardingActivityV2$CommandProcessor$1$1 = new OnboardingActivityV2$CommandProcessor$1$1(context, onboardingViewModelV2, navHostController, function12, managedActivityResultLauncherA, this, coroutineScope, scaffoldState, managedActivityResultLauncherA2, null);
                composerK.w(onboardingActivityV2$CommandProcessor$1$1);
                objG4 = onboardingActivityV2$CommandProcessor$1$1;
            }
            composer2 = composerK;
            FlowExtKt.g(onboardingViewModelV2, null, (Function2) objG4, composer2, i5 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingActivityV2.r1(this.f111292a, onboardingViewModelV2, navHostController, scaffoldState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o2(OnboardingActivityV2 onboardingActivityV2, OnboardingViewStateV2 onboardingViewStateV2, NavHostController navHostController, PaddingValues paddingValues, CoroutineScope coroutineScope, Function1 function1, MutableState mutableState, MutableState mutableState2, Function1 function12, int i3, Composer composer, int i4) {
        onboardingActivityV2.z1(onboardingViewStateV2, navHostController, paddingValues, coroutineScope, function1, mutableState, mutableState2, function12, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p1(OnboardingActivityV2 onboardingActivityV2, Context context, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        onboardingActivityV2.x2(context);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p2(MutableState mutableState, Function1 function1, MutableState mutableState2, NavHostController navHostController, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(activityResult, "activityResult");
        if (activityResult.d() == -1) {
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                function1.invoke(OnboardingViewEventV2.OnOnboardingSkipped.f110939a);
                mutableState.setValue(Boolean.FALSE);
            } else {
                String route = (String) mutableState2.getValue();
                if (route == null) {
                    route = OnboardingNavItem.FirstFocusSplash.getRoute();
                }
                mutableState2.setValue(null);
                NavController.P(navHostController, route, null, null, 6, null);
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q1(NavHostController navHostController, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        NavController.P(navHostController, OnboardingNavItem.FirstFocusSplash.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q2(ManagedActivityResultLauncher managedActivityResultLauncher, Context context, SignInConfig signInConfig) {
        Intrinsics.checkNotNullParameter(signInConfig, "signInConfig");
        managedActivityResultLauncher.b(SignInActivity.f110366h.a(context, signInConfig));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r1(OnboardingActivityV2 onboardingActivityV2, OnboardingViewModelV2 onboardingViewModelV2, NavHostController navHostController, ScaffoldState scaffoldState, Function1 function1, int i3, Composer composer, int i4) {
        onboardingActivityV2.o1(onboardingViewModelV2, navHostController, scaffoldState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r2(OnboardingActivityV2 onboardingActivityV2, OnboardingViewStateV2 onboardingViewStateV2, NavHostController navHostController, CoroutineScope coroutineScope, Function1 function1, MutableState mutableState, MutableState mutableState2, Function1 function12, PaddingValues it, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(it) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1169512129, i4, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2.RootCompose.<anonymous> (OnboardingActivityV2.kt:120)");
            }
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            onboardingActivityV2.z1(onboardingViewStateV2, navHostController, it, coroutineScope, function1, mutableState, mutableState2, function12, composer, ((i4 << 6) & 896) | 1769472);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    private final void s1(final NavHostController navHostController, final String str, final String str2, final String str3, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(1927617558);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(navHostController) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(str) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(str2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(str3) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1927617558, i4, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2.GenericSplashScreen (OnboardingActivityV2.kt:523)");
            }
            composer2 = composerK;
            ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, ComposableLambdaKt.e(-1799535964, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.onboarding.t0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OnboardingActivityV2.t1(str, navHostController, str2, str3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 12582912, 127);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.u0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingActivityV2.v1(this.f111583a, navHostController, str, str2, str3, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s2(CoroutineScope coroutineScope, MutableState mutableState, Context context, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (WhenMappings.f110927a[event.ordinal()] == 1) {
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new OnboardingActivityV2$RootCompose$3$1$1(mutableState, context, null), 3, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t1(String str, final NavHostController navHostController, final String str2, final String str3, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1799535964, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2.GenericSplashScreen.<anonymous> (OnboardingActivityV2.kt:534)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierF = SizeKt.f(companion, 0.0f, 1, null);
            Arrangement.Vertical verticalH = Arrangement.f6574a.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierF);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion3.f());
            Modifier modifierB = ColumnScope.b(ColumnScopeInstance.f6666a, companion, 1.0f, false, 2, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, modifierB);
            Function0 function0A2 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A2);
            } else {
                composer.v();
            }
            Composer composerA2 = Updater.a(composer);
            Updater.e(composerA2, measurePolicyG, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF3, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            SplashContentKt.c(str, false, composer, 0, 2);
            composer.y();
            Modifier modifierM = PaddingKt.m(companion, 0.0f, 0.0f, 0.0f, Dp.g(4), 7, null);
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer, modifierM);
            Function0 function0A3 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A3);
            } else {
                composer.v();
            }
            Composer composerA3 = Updater.a(composer);
            Updater.e(composerA3, measurePolicyG2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF4, companion3.f());
            String strB = StringResources_androidKt.b(R.string.l8, composer, 0);
            boolean zI = composer.I(navHostController) | composer.Z(str2) | composer.Z(str3);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.k1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OnboardingActivityV2.u1(navHostController, str2, str3);
                    }
                };
                composer.w(objG);
            }
            FlatButtonsKt.p(null, false, strB, false, (Function0) objG, composer, 0, 11);
            composer.y();
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t2(OnboardingActivityV2 onboardingActivityV2, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        onboardingActivityV2.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u1(NavHostController navHostController, String str, String str2) {
        w1(navHostController, str, str2);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v1(OnboardingActivityV2 onboardingActivityV2, NavHostController navHostController, String str, String str2, String str3, int i3, Composer composer, int i4) {
        onboardingActivityV2.s1(navHostController, str, str2, str3, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CallbackManager v2() {
        return CallbackManager.Factory.create();
    }

    private static final void w1(NavHostController navHostController, String str, final String str2) {
        navHostController.N(str, new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.l1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OnboardingActivityV2.x1(str2, (NavOptionsBuilder) obj);
            }
        });
    }

    private final CallbackManager w2() {
        return (CallbackManager) this.f110882f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x1(String str, NavOptionsBuilder navigate) {
        Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
        navigate.d(str, new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OnboardingActivityV2.y1((PopUpToBuilder) obj);
            }
        });
        navigate.e(true);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x2(Context context) {
        Intent intentC = DashboardActivity.Companion.c(DashboardActivity.f99133o, context, null, null, 6, null);
        intentC.setFlags(268468224);
        startActivity(intentC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y1(PopUpToBuilder popUpTo) {
        Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
        popUpTo.c(true);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void z1(final cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewStateV2 r22, final androidx.navigation.NavHostController r23, final androidx.compose.foundation.layout.PaddingValues r24, final kotlinx.coroutines.CoroutineScope r25, final kotlin.jvm.functions.Function1 r26, final androidx.compose.runtime.MutableState r27, final androidx.compose.runtime.MutableState r28, final kotlin.jvm.functions.Function1 r29, androidx.compose.runtime.Composer r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 506
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2.z1(cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewStateV2, androidx.navigation.NavHostController, androidx.compose.foundation.layout.PaddingValues, kotlinx.coroutines.CoroutineScope, kotlin.jvm.functions.Function1, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        final MutableState mutableState;
        Bundle bundleB;
        final OnboardingActivityV2 onboardingActivityV2 = this;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(186260225);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(onboardingActivityV2) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(186260225, i4, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2.RootCompose (OnboardingActivityV2.kt:84)");
            }
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composerK, 0, 3);
            final NavHostController navHostControllerB = NavHostControllerKt.b(new Navigator[0], composerK, 0);
            composerK.F(-101221098);
            ViewModelStoreOwner viewModelStoreOwnerC = LocalViewModelStoreOwner.f40240a.c(composerK, 8);
            if (viewModelStoreOwnerC == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            CreationExtras creationExtrasA = ViewModelComposeExtKt.a(viewModelStoreOwnerC, composerK, 8);
            Scope scopeD = GlobalContext.f145907a.get().j().d();
            composerK.F(-1072256281);
            NavBackStackEntry navBackStackEntry = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : null;
            CreationExtras creationExtrasA2 = (navBackStackEntry == null || (bundleB = navBackStackEntry.b()) == null) ? null : BundleExtKt.a(bundleB, viewModelStoreOwnerC);
            KClass kClassB = Reflection.b(OnboardingViewModelV2.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            OnboardingViewModelV2 onboardingViewModelV2 = (OnboardingViewModelV2) viewModelA;
            final OnboardingViewStateV2 onboardingViewStateV2 = (OnboardingViewStateV2) FlowExtKt.m(onboardingViewModelV2, composerK, 0);
            final Function1 function1N = FlowExtKt.n(onboardingViewModelV2, composerK, 0);
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objG;
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG2);
            }
            MutableState mutableState2 = (MutableState) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG3);
            }
            final MutableState mutableState3 = (MutableState) objG3;
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
                composerK.w(objG4);
            }
            final MutableState mutableState4 = (MutableState) objG4;
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            boolean Z = composerK.Z(function1N) | composerK.I(navHostControllerB);
            Object objG5 = composerK.G();
            if (Z || objG5 == companion.a()) {
                objG5 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.k0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OnboardingActivityV2.p2(mutableState3, function1N, mutableState4, navHostControllerB, (ActivityResult) obj);
                    }
                };
                composerK.w(objG5);
            }
            final ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG5, composerK, 0);
            boolean zI = composerK.I(managedActivityResultLauncherA) | composerK.I(context);
            Object objG6 = composerK.G();
            if (zI || objG6 == companion.a()) {
                objG6 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.v0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OnboardingActivityV2.q2(managedActivityResultLauncherA, context, (SignInConfig) obj);
                    }
                };
                composerK.w(objG6);
            }
            final Function1 function1 = (Function1) objG6;
            int i5 = i4;
            ScaffoldKt.a(null, scaffoldStateG, null, null, ComposableSingletons$OnboardingActivityV2Kt.f110868a.b(), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(-1169512129, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.onboarding.g1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OnboardingActivityV2.r2(this.f111204a, onboardingViewStateV2, navHostControllerB, coroutineScope, function1N, mutableState3, mutableState4, function1, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 24576, 12582912, 131053);
            Object value = mutableState2.getValue();
            boolean zI2 = composerK.I(navHostControllerB) | composerK.I(onboardingViewModelV2);
            Object objG7 = composerK.G();
            if (zI2 || objG7 == companion.a()) {
                mutableState = mutableState2;
                objG7 = new OnboardingActivityV2$RootCompose$2$1(mutableState, navHostControllerB, onboardingViewModelV2, null);
                composerK.w(objG7);
            } else {
                mutableState = mutableState2;
            }
            EffectsKt.g(value, (Function2) objG7, composerK, 0);
            int i6 = (i5 << 9) & 57344;
            composer2 = composerK;
            onboardingActivityV2 = this;
            onboardingActivityV2.o1(onboardingViewModelV2, navHostControllerB, scaffoldStateG, function1, composer2, i6);
            boolean zI3 = composer2.I(coroutineScope) | composer2.I(context);
            Object objG8 = composer2.G();
            if (zI3 || objG8 == companion.a()) {
                objG8 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.m1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OnboardingActivityV2.s2(coroutineScope, mutableState, context, (LifecycleOwner) obj, (Lifecycle.Event) obj2);
                    }
                };
                composer2.w(objG8);
            }
            ComposableExtKt.j(null, (Function2) objG8, composer2, 0, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.n1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingActivityV2.t2(this.f111249a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    protected boolean f0() {
        return this.f110883g;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i3, int i4, Intent intent) {
        w2().onActivityResult(i3, i4, intent);
        super.onActivityResult(i3, i4, intent);
    }
}
