package cz.mobilesoft.coreblock.scene.schedule;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
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
import androidx.navigation.NavType;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.enums.ScheduleTemplate;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity;
import cz.mobilesoft.coreblock.scene.intro.quickblock.QuickBlockBlockingTestActivity;
import cz.mobilesoft.coreblock.scene.intro.schedule.IntroScheduleActivity;
import cz.mobilesoft.coreblock.scene.more.settings.AllowCategoriesBottomSheetKt;
import cz.mobilesoft.coreblock.scene.onboarding.OnboardingActivityV2;
import cz.mobilesoft.coreblock.scene.onboarding.schedule.OnboardingExitScreenKt;
import cz.mobilesoft.coreblock.scene.onboarding.schedule.OnboardingScheduleReadyScreenKt;
import cz.mobilesoft.coreblock.scene.password.PassCodeActivity;
import cz.mobilesoft.coreblock.scene.password.PassCodeType;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionsScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.LaunchCountConditionScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.detail.ConflictingSchedulesExplanationKt;
import cz.mobilesoft.coreblock.scene.schedule.detail.ConflictingSchedulesScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.detail.DetailScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.detail.LockType;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import cz.mobilesoft.coreblock.scene.schedule.emoji.IconPickerScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.summary.ScheduleSummaryScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.usagelimit.UsageLimitTimePickerBottomSheetKt;
import cz.mobilesoft.coreblock.scene.selection.BlockingSelectScreenKt;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel;
import cz.mobilesoft.coreblock.scene.selection.recommended.RecommendedAppsScreenKt;
import cz.mobilesoft.coreblock.storage.datastore.PassCodeDataStore;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.usecase.timenudge.ApplyTimeNudgeDefaultAppsUseCase;
import cz.mobilesoft.coreblock.util.InterstitialUtils;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.analytics.FacebookLogger;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.constants.AdUnitId;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.view.compose.ActivityLauncher;
import cz.mobilesoft.coreblock.view.compose.ComposeCheckablesKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCommonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt;
import cz.mobilesoft.coreblock.view.graph.GraphData;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerConfig;
import cz.mobilesoft.coreblock.view.timeselector.TimeSelectBottomSheetKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
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
public final class ScheduleActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Companion f114377m = new Companion(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f114378n = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CoroutineScope f114379f = CoroutinesHelperExtKt.a(Dispatchers.b());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f114380g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f114381h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f114382i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ActivityResultLauncher f114383j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f114384k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Lazy f114385l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class BlockingConditionConfig {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private UsageLimit.PeriodType f114386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f114387b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class LaunchCountConfig extends BlockingConditionConfig {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final TimePickerConfig f114388c;

            @Override // cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.BlockingConditionConfig
            public TimePickerConfig c() {
                return this.f114388c;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class UsageLimitConfig extends BlockingConditionConfig {

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final /* synthetic */ class WhenMappings {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f114389a;

                static {
                    int[] iArr = new int[UsageLimit.PeriodType.values().length];
                    try {
                        iArr[UsageLimit.PeriodType.DAILY.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[UsageLimit.PeriodType.HOURLY.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f114389a = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UsageLimitConfig(UsageLimit.PeriodType period, long j3) {
                super(period, j3, null);
                Intrinsics.checkNotNullParameter(period, "period");
            }

            @Override // cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.BlockingConditionConfig
            public TimePickerConfig c() {
                int i3 = WhenMappings.f114389a[b().ordinal()];
                if (i3 == 1) {
                    return new TimePickerConfig(new TimePickerConfig.TimePickerType.Minutes(0L, 0L, 3, null), new TimePickerConfig.TimePickerType.Hours(0L, 0L, 3, null), null, false, null, false, 60, null);
                }
                if (i3 == 2) {
                    return new TimePickerConfig(new TimePickerConfig.TimePickerType.Minutes(0L, 0L, 3, null), null, null, false, null, false, 62, null);
                }
                throw new NoWhenBranchMatchedException();
            }
        }

        public /* synthetic */ BlockingConditionConfig(UsageLimit.PeriodType periodType, long j3, DefaultConstructorMarker defaultConstructorMarker) {
            this(periodType, j3);
        }

        public final long a() {
            return this.f114387b;
        }

        public final UsageLimit.PeriodType b() {
            return this.f114386a;
        }

        public abstract TimePickerConfig c();

        public final void d(UsageLimit.PeriodType periodType) {
            Intrinsics.checkNotNullParameter(periodType, "<set-?>");
            this.f114386a = periodType;
        }

        private BlockingConditionConfig(UsageLimit.PeriodType periodType, long j3) {
            this.f114386a = periodType;
            this.f114387b = j3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent b(Companion companion, Context context, ScheduleDescriptor scheduleDescriptor, boolean z2, boolean z3, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                scheduleDescriptor = new ScheduleDescriptor.NewSchedule(null, null, false, false, null, null, 63, null);
            }
            if ((i3 & 4) != 0) {
                z2 = false;
            }
            if ((i3 & 8) != 0) {
                z3 = false;
            }
            return companion.a(context, scheduleDescriptor, z2, z3);
        }

        public final Intent a(Context context, ScheduleDescriptor scheduleDescriptor, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(scheduleDescriptor, "scheduleDescriptor");
            Intent intent = new Intent(context, (Class<?>) ScheduleActivity.class);
            intent.putExtra("PROFILE_DTO", scheduleDescriptor);
            intent.putExtra("FORCE_RELOAD_SCHEDULES", z2);
            intent.putExtra("IS_FROM_WIDGET", z3);
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavItem {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ NavItem[] $VALUES;
        private final String route;
        public static final NavItem Detail = new NavItem("Detail", 0, "detail");
        public static final NavItem Conditions = new NavItem("Conditions", 1, "conditions");
        public static final NavItem LocationCondition = new NavItem("LocationCondition", 2, "location_condition");
        public static final NavItem TimeCondition = new NavItem("TimeCondition", 3, "time_condition");
        public static final NavItem WifiCondition = new NavItem("WifiCondition", 4, "wifi_condition");
        public static final NavItem UsageLimitCondition = new NavItem("UsageLimitCondition", 5, "usage_limit_condition");
        public static final NavItem LaunchCountCondition = new NavItem("LaunchCountCondition", 6, "launch_count_condition");
        public static final NavItem CombinationCondition = new NavItem("CombinationCondition", 7, "combination_condition");
        public static final NavItem BlockingModeSettings = new NavItem("BlockingModeSettings", 8, "blocking_type_settings");
        public static final NavItem ApplicationSelect = new NavItem("ApplicationSelect", 9, "application_select");
        public static final NavItem RecommendedApps = new NavItem("RecommendedApps", 10, "recommended_apps");
        public static final NavItem EmojiPicker = new NavItem("EmojiPicker", 11, "emoji_picker");
        public static final NavItem OnboardingScheduleReady = new NavItem("OnboardingScheduleReady", 12, "onboarding_schedule_ready");
        public static final NavItem OnboardingExitScreen = new NavItem("OnboardingExitScreen", 13, "onboarding_exit_screen");
        public static final NavItem ConflictingSchedules = new NavItem("ConflictingSchedules", 14, "conflicting_schedules");
        public static final NavItem ConflictingSchedulesExplanation = new NavItem("ConflictingSchedulesExplanation", 15, "conflicting_schedules_explanation");
        public static final NavItem Summary = new NavItem("Summary", 16, "schedule_summary_screen");

        private static final /* synthetic */ NavItem[] $values() {
            return new NavItem[]{Detail, Conditions, LocationCondition, TimeCondition, WifiCondition, UsageLimitCondition, LaunchCountCondition, CombinationCondition, BlockingModeSettings, ApplicationSelect, RecommendedApps, EmojiPicker, OnboardingScheduleReady, OnboardingExitScreen, ConflictingSchedules, ConflictingSchedulesExplanation, Summary};
        }

        static {
            NavItem[] navItemArr$values = $values();
            $VALUES = navItemArr$values;
            $ENTRIES = EnumEntriesKt.a(navItemArr$values);
        }

        private NavItem(String str, int i3, String str2) {
            this.route = str2;
        }

        public static EnumEntries<NavItem> getEntries() {
            return $ENTRIES;
        }

        public static NavItem valueOf(String str) {
            return (NavItem) Enum.valueOf(NavItem.class, str);
        }

        public static NavItem[] values() {
            return (NavItem[]) $VALUES.clone();
        }

        public final String getRoute() {
            return this.route;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f114426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f114427b;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f114426a = iArr;
            int[] iArr2 = new int[ProfileType.values().length];
            try {
                iArr2[ProfileType.TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[ProfileType.LOCATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ProfileType.WIFI.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ProfileType.USAGE_LIMIT.ordinal()] = 4;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ProfileType.LAUNCH_COUNT.ordinal()] = 5;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ProfileType.COMBINED.ordinal()] = 6;
            } catch (NoSuchFieldError unused7) {
            }
            f114427b = iArr2;
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity$onCreate$1", f = "ScheduleActivity.kt", l = {171, 172}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f114430a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity$onCreate$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity$onCreate$1$1", f = "ScheduleActivity.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class C02981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f114432a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ScheduleActivity f114433b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02981(ScheduleActivity scheduleActivity, Continuation continuation) {
                super(2, continuation);
                this.f114433b = scheduleActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C02981(this.f114433b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.f114432a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.f114433b.f114383j.b(PassCodeActivity.f111670f.a(this.f114433b, PassCodeType.Check));
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C02981) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return ScheduleActivity.this.new AnonymousClass1(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
        
            if (kotlinx.coroutines.BuildersKt.g(r6, r1, r5) == r0) goto L19;
         */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r5.f114430a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.b(r6)
                goto L5c
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1a:
                kotlin.ResultKt.b(r6)
                goto L3f
            L1e:
                kotlin.ResultKt.b(r6)
                cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity r6 = cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.this
                android.content.Intent r6 = r6.getIntent()
                java.lang.String r1 = "IS_FROM_WIDGET"
                r4 = 0
                boolean r6 = r6.getBooleanExtra(r1, r4)
                if (r6 == 0) goto L5c
                cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity r6 = cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.this
                cz.mobilesoft.coreblock.storage.datastore.PassCodeDataStore r6 = cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.F3(r6)
                r5.f114430a = r3
                java.lang.Object r6 = r6.B(r5)
                if (r6 != r0) goto L3f
                goto L5b
            L3f:
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                if (r6 == 0) goto L5c
                kotlinx.coroutines.MainCoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.c()
                cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity$onCreate$1$1 r1 = new cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity$onCreate$1$1
                cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity r3 = cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.this
                r4 = 0
                r1.<init>(r3, r4)
                r5.f114430a = r2
                java.lang.Object r6 = kotlinx.coroutines.BuildersKt.g(r6, r1, r5)
                if (r6 != r0) goto L5c
            L5b:
                return r0
            L5c:
                kotlin.Unit r6 = kotlin.Unit.f139807a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScheduleActivity() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139761a;
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f114380g = LazyKt.a(lazyThreadSafetyMode, new Function0<PassCodeDataStore>() { // from class: cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(PassCodeDataStore.class), qualifier, objArr);
            }
        });
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f114381h = LazyKt.a(lazyThreadSafetyMode, new Function0<FacebookLogger>() { // from class: cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(FacebookLogger.class), objArr2, objArr3);
            }
        });
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f114382i = LazyKt.a(lazyThreadSafetyMode, new Function0<ApplyTimeNudgeDefaultAppsUseCase>() { // from class: cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(ApplyTimeNudgeDefaultAppsUseCase.class), objArr4, objArr5);
            }
        });
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
        this.f114383j = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: cz.mobilesoft.coreblock.scene.schedule.b
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ScheduleActivity.Q3(this.f115044a, (ActivityResult) obj);
            }
        });
        this.f114385l = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScheduleActivity.R3(this.f117290a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A2(ScheduleDTO scheduleDTO, final Function1 function1, final ScheduleActivity scheduleActivity, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1299174701, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (ScheduleActivity.kt:602)");
        }
        boolean zD = scheduleDTO.d();
        Profile.BlockingMode blockingModeK = scheduleDTO.k();
        ProfileType profileTypeV = scheduleDTO.v();
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.b2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ScheduleActivity.B2(function1, (Profile.BlockingMode) obj);
                }
            };
            composer.w(objG);
        }
        Function1 function12 = (Function1) objG;
        boolean Z2 = composer.Z(function1);
        Object objG2 = composer.G();
        if (Z2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.c2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScheduleActivity.C2(function1);
                }
            };
            composer.w(objG2);
        }
        Function0 function0 = (Function0) objG2;
        boolean zI = composer.I(scheduleActivity);
        Object objG3 = composer.G();
        if (zI || objG3 == Composer.f23746a.a()) {
            objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.d2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScheduleActivity.D2(this.f116478a);
                }
            };
            composer.w(objG3);
        }
        BlockingModeSettingsScreenKt.H(zD, blockingModeK, profileTypeV, function12, function0, (Function0) objG3, composer, 0, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A3(ScheduleActivity scheduleActivity, Boolean bool) {
        scheduleActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B2(Function1 function1, Profile.BlockingMode it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new ScheduleViewEvent.OnBlockingModeSelected(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B3(ScheduleActivity scheduleActivity, MutableState mutableState, MutableState mutableState2, Function1 function1, ScheduleDTO scheduleDTO, NavHostController navHostController, String str, ScheduleViewState scheduleViewState, ScheduleViewModel scheduleViewModel, ModalBottomSheetState modalBottomSheetState, BaseSelectionViewModel.ApplicationWebsiteSelectDTO applicationWebsiteSelectDTO, Function1 function12, MutableState mutableState3, ScaffoldState scaffoldState, PaddingValues it, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(it) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-470859005, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.RootCompose.<anonymous> (ScheduleActivity.kt:279)");
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
            scheduleActivity.k2(navHostController, str, scheduleViewState, scheduleViewModel, modalBottomSheetState, scheduleDTO, applicationWebsiteSelectDTO, function1, function12, mutableState3, mutableState, it, scaffoldState, composer, (ModalBottomSheetState.f13222e << 12) | 905969664, ((i4 << 3) & 112) | 6);
            composer.y();
            scheduleActivity.v3(mutableState, mutableState2, function1, scheduleDTO, composer, 54);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C2(Function1 function1) {
        function1.invoke(ScheduleViewEvent.OnBlockingModeSettingsClosed.f114552a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C3(Function1 function1, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (WhenMappings.f114426a[event.ordinal()] == 1) {
            function1.invoke(ScheduleViewEvent.OnActivityCreated.f114538a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D2(ScheduleActivity scheduleActivity) {
        scheduleActivity.startActivity(Paywall.c(Paywall.f113165a, scheduleActivity, new PaywallTarget.LimitScreen(PremiumFeature.ALLOWLIST), scheduleActivity.P3() instanceof ScheduleDescriptor.ScheduleId ? "schedule_edit" : "schedule_create", "allow_list", false, false, false, null, 240, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D3(ScheduleActivity scheduleActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        scheduleActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E2(MutableState mutableState, final ScheduleActivity scheduleActivity, ScheduleViewState scheduleViewState, final Function1 function1, final NavHostController navHostController, BaseSelectionViewModel.ApplicationWebsiteSelectDTO applicationWebsiteSelectDTO, final Function1 function12, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(288508654, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (ScheduleActivity.kt:625)");
        }
        mutableState.setValue(Boolean.FALSE);
        boolean z2 = scheduleActivity.P3() instanceof ScheduleDescriptor.CombinationOnboardingV2;
        if (!scheduleViewState.n() || (scheduleActivity.P3() instanceof ScheduleDescriptor.CombinationOnboardingV2)) {
            composer.a0(732435105);
            boolean z3 = scheduleActivity.P3() instanceof ScheduleDescriptor.NewSchedule;
            String string = z2 ? scheduleActivity.getString(R.string.C4) : null;
            boolean z4 = (navHostController.B() == null && (scheduleActivity.P3() instanceof ScheduleDescriptor.CombinationOnboardingV2)) ? false : true;
            ScheduleDescriptor scheduleDescriptorP3 = scheduleActivity.P3();
            Float fO3 = scheduleActivity.O3(OnboardingActivityV2.OnboardingNavItem.FirstFocusApps);
            float fFloatValue = fO3 != null ? fO3.floatValue() : 0.95f;
            boolean Z = composer.Z(function1) | composer.I(scheduleActivity) | composer.I(navHostController);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.f1
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return ScheduleActivity.G2(function1, scheduleActivity, navHostController, (ArrayList) obj, (ArrayList) obj2, (List) obj3, (ArrayList) obj4);
                    }
                };
                composer.w(objG);
            }
            Function4 function4 = (Function4) objG;
            boolean zI = composer.I(navHostController) | composer.Z(function12);
            Object objG2 = composer.G();
            if (zI || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.g1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ScheduleActivity.H2(navHostController, function12);
                    }
                };
                composer.w(objG2);
            }
            BlockingSelectScreenKt.c(applicationWebsiteSelectDTO, function4, (Function0) objG2, z3, z4, z2, string, scheduleDescriptorP3, fFloatValue, composer, 0, 0);
            composer.U();
        } else {
            composer.a0(732047357);
            boolean Z2 = composer.Z(function1);
            Object objG3 = composer.G();
            if (Z2 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.d1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ScheduleActivity.F2(function1, ((Boolean) obj).booleanValue());
                    }
                };
                composer.w(objG3);
            }
            AllowCategoriesBottomSheetKt.f((Function1) objG3, scheduleViewState, composer, 0, 0);
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F2(Function1 function1, boolean z2) {
        function1.invoke(new ScheduleViewEvent.OnCategoriesAllowed(z2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G2(Function1 function1, ScheduleActivity scheduleActivity, NavHostController navHostController, ArrayList applications, ArrayList websites, List categories, ArrayList selectedSubApps) {
        Intrinsics.checkNotNullParameter(applications, "applications");
        Intrinsics.checkNotNullParameter(websites, "websites");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(selectedSubApps, "selectedSubApps");
        function1.invoke(new ScheduleViewEvent.OnApplicationsWebsitesSelected(applications, websites, selectedSubApps, false, categories, 8, null));
        if (!(scheduleActivity.P3() instanceof ScheduleDescriptor.CombinationOnboardingV2)) {
            NavController.P(navHostController, NavItem.Detail.getRoute(), null, null, 6, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H2(NavHostController navHostController, Function1 function1) {
        if (!navHostController.R()) {
            function1.invoke(new ScheduleResult(false, null, null, false, 15, null));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I2(ScheduleActivity scheduleActivity, MutableState mutableState, final Function1 function1, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1506822182, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (ScheduleActivity.kt:668)");
        }
        ScheduleDescriptor scheduleDescriptorP3 = scheduleActivity.P3();
        Intrinsics.checkNotNull(scheduleDescriptorP3, "null cannot be cast to non-null type cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor.QuickBlockOnboarding");
        List listC = ((ScheduleDescriptor.QuickBlockOnboarding) scheduleDescriptorP3).c();
        Integer titleResId = ProfileType.QUICK_BLOCK.getTitleResId();
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.u1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ScheduleActivity.J2(function1, (List) obj, (List) obj2, ((Boolean) obj3).booleanValue());
                }
            };
            composer.w(objG);
        }
        RecommendedAppsScreenKt.H(listC, titleResId, mutableState, (Function3) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J2(Function1 function1, List applications, List websites, boolean z2) {
        Intrinsics.checkNotNullParameter(applications, "applications");
        Intrinsics.checkNotNullParameter(websites, "websites");
        function1.invoke(new ScheduleViewEvent.OnApplicationsWebsitesSelected(new ArrayList(applications), new ArrayList(websites), null, z2, null, 20, null));
        return Unit.f139807a;
    }

    private final void J3() {
        AnswersHelper.f128199a.W2();
        BuildersKt__Builders_commonKt.d(this.f114379f, null, null, new ScheduleActivity$finishOnboarding$1(this, null), 3, null);
        M3().c();
        PrefManager.f126839a.Q2(true);
        Intent intentC = DashboardActivity.Companion.c(DashboardActivity.f99133o, this, null, DashboardActivity.NavBarItem.Blocking.f99175i, 2, null);
        intentC.setFlags(268468224);
        startActivity(intentC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K2(ScheduleViewState scheduleViewState, Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1777479067, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (ScheduleActivity.kt:685)");
        }
        ScheduleEmoji scheduleEmojiR = scheduleViewState.g().r();
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.u0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScheduleActivity.L2(navHostController);
                }
            };
            composer.w(objG);
        }
        IconPickerScreenKt.G(scheduleEmojiR, function1, (Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApplyTimeNudgeDefaultAppsUseCase K3() {
        return (ApplyTimeNudgeDefaultAppsUseCase) this.f114382i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L2(NavHostController navHostController) {
        navHostController.Q();
        return Unit.f139807a;
    }

    private final NavItem L3(ProfileType profileType) {
        int i3 = WhenMappings.f114427b[profileType.ordinal()];
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? NavItem.Conditions : NavItem.LaunchCountCondition : NavItem.UsageLimitCondition : NavItem.WifiCondition : NavItem.LocationCondition : NavItem.TimeCondition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M2(ScheduleViewState scheduleViewState, ScheduleDTO scheduleDTO, final NavHostController navHostController, final Function1 function1, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(766813020, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (ScheduleActivity.kt:695)");
        }
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.z0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScheduleActivity.N2(navHostController);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean zI2 = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.a1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScheduleActivity.O2(navHostController);
                }
            };
            composer.w(objG2);
        }
        Function0 function02 = (Function0) objG2;
        boolean Z = composer.Z(function1);
        Object objG3 = composer.G();
        if (Z || objG3 == Composer.f23746a.a()) {
            objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.b1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScheduleActivity.P2(function1);
                }
            };
            composer.w(objG3);
        }
        OnboardingScheduleReadyScreenKt.h(scheduleViewState, scheduleDTO, function0, function02, (Function0) objG3, composer, 0, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    private final FacebookLogger M3() {
        return (FacebookLogger) this.f114381h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N2(NavHostController navHostController) {
        navHostController.Q();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PassCodeDataStore N3() {
        return (PassCodeDataStore) this.f114380g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O2(NavHostController navHostController) {
        NavController.P(navHostController, NavItem.Detail.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    private final Float O3(OnboardingActivityV2.OnboardingNavItem onboardingNavItem) {
        Float fValueOf = Float.valueOf(onboardingNavItem.getProgressBarFill());
        if (P3() instanceof ScheduleDescriptor.CombinationOnboardingV2) {
            return fValueOf;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P2(Function1 function1) {
        PrefManager prefManager = PrefManager.f126839a;
        prefManager.Q2(true);
        prefManager.v1();
        function1.invoke(new ScheduleViewEvent.OnSaveButtonClicked(false, 1, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ScheduleDescriptor P3() {
        return (ScheduleDescriptor) this.f114385l.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q2(final ScheduleViewState scheduleViewState, MutableState mutableState, final Function1 function1, final NavHostController navHostController, final ScheduleActivity scheduleActivity, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-216097562, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (ScheduleActivity.kt:369)");
        }
        Bundle bundleB = it.b();
        final boolean z2 = bundleB != null ? bundleB.getBoolean("isStartScreen") : false;
        ImmutableList immutableListF = scheduleViewState.g().f();
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.h1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ScheduleActivity.R2(function1, (ProfileType) obj);
                }
            };
            composer.w(objG);
        }
        Function1 function12 = (Function1) objG;
        boolean zI = composer.I(navHostController) | composer.b(z2);
        Object objG2 = composer.G();
        if (zI || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.i1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScheduleActivity.S2(navHostController, z2);
                }
            };
            composer.w(objG2);
        }
        Function0 function0 = (Function0) objG2;
        boolean Z2 = composer.Z(function1);
        Object objG3 = composer.G();
        if (Z2 || objG3 == Composer.f23746a.a()) {
            objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.j1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ScheduleActivity.T2(function1, (ProfileType) obj);
                }
            };
            composer.w(objG3);
        }
        Function1 function13 = (Function1) objG3;
        boolean zB = composer.b(z2) | composer.I(scheduleActivity) | composer.Z(scheduleViewState) | composer.I(navHostController) | composer.Z(function1);
        Object objG4 = composer.G();
        if (zB || objG4 == Composer.f23746a.a()) {
            Function0 function02 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.k1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScheduleActivity.U2(z2, scheduleActivity, scheduleViewState, navHostController, function1);
                }
            };
            composer.w(function02);
            objG4 = function02;
        }
        ConditionsScreenKt.s(immutableListF, mutableState, z2, function12, function0, function13, (Function0) objG4, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q3(ScheduleActivity scheduleActivity, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        BuildersKt__Builders_commonKt.d(scheduleActivity.f114379f, null, null, new ScheduleActivity$passCodeLauncher$1$1(scheduleActivity, result, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R2(Function1 function1, ProfileType profileType) {
        Intrinsics.checkNotNullParameter(profileType, "profileType");
        function1.invoke(new ScheduleViewEvent.OnConditionSelected(profileType));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleDescriptor R3(ScheduleActivity scheduleActivity) {
        Object serializableExtra;
        Intent intent = scheduleActivity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        if (Build.VERSION.SDK_INT >= 33) {
            serializableExtra = intent.getSerializableExtra("PROFILE_DTO", ScheduleDescriptor.class);
        } else {
            Object serializableExtra2 = intent.getSerializableExtra("PROFILE_DTO");
            if (!(serializableExtra2 instanceof ScheduleDescriptor)) {
                serializableExtra2 = null;
            }
            serializableExtra = (ScheduleDescriptor) serializableExtra2;
        }
        ScheduleDescriptor scheduleDescriptor = (ScheduleDescriptor) serializableExtra;
        if (scheduleDescriptor != null) {
            return scheduleDescriptor;
        }
        return new ScheduleDescriptor.NewSchedule(null, null, false, false, null, null, 63, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S2(NavHostController navHostController, boolean z2) {
        NavController.P(navHostController, NavItem.CombinationCondition.getRoute() + "?isStartScreen=" + z2, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S3(NavHostController navHostController, ProfileType profileType, ConditionDTO conditionDTO) {
        boolean z2 = conditionDTO == null;
        switch (WhenMappings.f114427b[profileType.ordinal()]) {
            case 1:
                NavController.P(navHostController, NavItem.TimeCondition.getRoute() + "?isStartScreen=" + z2, null, null, 6, null);
                break;
            case 2:
                NavController.P(navHostController, NavItem.LocationCondition.getRoute() + "?isStartScreen=" + z2, null, null, 6, null);
                break;
            case 3:
                NavController.P(navHostController, NavItem.WifiCondition.getRoute() + "?isStartScreen=" + z2, null, null, 6, null);
                break;
            case 4:
                NavController.P(navHostController, NavItem.UsageLimitCondition.getRoute() + "?isStartScreen=" + z2, null, null, 6, null);
                break;
            case 5:
                NavController.P(navHostController, NavItem.LaunchCountCondition.getRoute() + "?isStartScreen=" + z2, null, null, 6, null);
                break;
            case 6:
                NavController.P(navHostController, NavItem.CombinationCondition.getRoute() + "?isStartScreen=" + z2, null, null, 6, null);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T2(Function1 function1, ProfileType profileType) {
        Intrinsics.checkNotNullParameter(profileType, "profileType");
        function1.invoke(new ScheduleViewEvent.OnDisabledConditionClick(profileType));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U1(final MutableState mutableState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1756076225, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.ChargerLockConfirmDialog.<anonymous> (ScheduleActivity.kt:1130)");
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
            String strB = StringResources_androidKt.b(R.string.Dk, composer, 0);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.g2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ScheduleActivity.V1(mutableState, ((Boolean) obj).booleanValue());
                    }
                };
                composer.w(objG);
            }
            ComposeCheckablesKt.h(mutableState, strB, null, null, null, 0L, 0.0f, (Function1) objG, composer, 12582918, 124);
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
    public static final Unit U2(boolean z2, ScheduleActivity scheduleActivity, ScheduleViewState scheduleViewState, NavHostController navHostController, Function1 function1) {
        if (z2) {
            scheduleActivity.finish();
        } else if (scheduleViewState.g().B()) {
            navHostController.Q();
        } else {
            function1.invoke(new ScheduleViewEvent.OnCloseClicked(false, 1, null));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V1(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V2(final ScheduleActivity scheduleActivity, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-243853027, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (ScheduleActivity.kt:713)");
        }
        boolean zI = composer.I(scheduleActivity);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.c1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScheduleActivity.W2(this.f115180a);
                }
            };
            composer.w(objG);
        }
        OnboardingExitScreenKt.d((Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W1(Function1 function1, MutableState mutableState) {
        function1.invoke(new ScheduleViewEvent.OnLockChargerDialogConfirmed(((Boolean) mutableState.getValue()).booleanValue()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W2(ScheduleActivity scheduleActivity) {
        scheduleActivity.J3();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X1(ScheduleActivity scheduleActivity, MutableState mutableState, boolean z2, Function1 function1, int i3, Composer composer, int i4) {
        scheduleActivity.T1(mutableState, z2, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X2(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.d(NavType.f48967n);
        navArgument.b(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y2(ScheduleViewState scheduleViewState, final NavHostController navHostController, final Function1 function1, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Function0 function0;
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1254519074, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (ScheduleActivity.kt:729)");
        }
        Bundle bundleB = it.b();
        boolean z2 = bundleB != null ? bundleB.getBoolean("withContinueButton") : false;
        if (z2) {
            AnswersHelper.f128199a.u1();
        } else {
            AnswersHelper.f128199a.v1();
        }
        List listF = scheduleViewState.f();
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.v1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScheduleActivity.Z2(navHostController);
                }
            };
            composer.w(objG);
        }
        Function0 function02 = (Function0) objG;
        boolean zI2 = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.w1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScheduleActivity.a3(navHostController);
                }
            };
            composer.w(objG2);
        }
        Function0 function03 = (Function0) objG2;
        if (z2) {
            composer.a0(1428489080);
            boolean Z = composer.Z(function1);
            Object objG3 = composer.G();
            if (Z || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.x1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ScheduleActivity.b3(function1);
                    }
                };
                composer.w(objG3);
            }
            function0 = (Function0) objG3;
            composer.U();
        } else {
            composer.a0(1428660447);
            composer.U();
            function0 = null;
        }
        ConflictingSchedulesScreenKt.l(listF, function02, function03, function0, composer, 0, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z1(ScheduleActivity scheduleActivity, Function1 function1, ActivityResult result, PermissionRequestReason value) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(value, "value");
        if (scheduleActivity.P3() instanceof ScheduleDescriptor.CombinationOnboardingV2) {
            AnswersHelper.f128199a.A3();
        }
        function1.invoke(new ScheduleViewEvent.OnMissingPermissionsChanged(value, result.d() == -1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z2(NavHostController navHostController) {
        navHostController.Q();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a2(NavHostController navHostController, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        NavController.P(navHostController, NavItem.OnboardingExitScreen.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a3(NavHostController navHostController) {
        NavController.P(navHostController, NavItem.ConflictingSchedulesExplanation.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b2(Function1 function1) {
        function1.invoke(new ScheduleResult(false, null, null, false, 15, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b3(Function1 function1) {
        function1.invoke(new ScheduleViewEvent.OnSaveButtonClicked(true));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c2(Function1 function1) {
        function1.invoke(new ScheduleViewEvent.OnAddToFollowSchedulesClicked(true));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c3(final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(2029782175, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (ScheduleActivity.kt:756)");
        }
        AnswersHelper.f128199a.t1();
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.s1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScheduleActivity.d3(navHostController);
                }
            };
            composer.w(objG);
        }
        ConflictingSchedulesExplanationKt.e((Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d2(Function1 function1) {
        function1.invoke(new ScheduleViewEvent.OnAddToFollowSchedulesClicked(false));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d3(NavHostController navHostController) {
        navHostController.Q();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e2(Function1 function1, long j3) {
        function1.invoke(new ScheduleViewEvent.OnLockTimeSelected(TimeHelperExt.f128663a.f() + j3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e3(ScheduleViewState scheduleViewState, ScheduleActivity scheduleActivity, final Function1 function1, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Function0 function0;
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1019116128, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (ScheduleActivity.kt:766)");
        }
        Float fO3 = scheduleActivity.O3(OnboardingActivityV2.OnboardingNavItem.FirstFocusSummary);
        if (scheduleActivity.P3() instanceof ScheduleDescriptor.CombinationOnboardingV2) {
            composer.a0(-634935337);
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.v0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ScheduleActivity.f3(function1);
                    }
                };
                composer.w(objG);
            }
            function0 = (Function0) objG;
            composer.U();
        } else {
            composer.a0(-634826435);
            composer.U();
            function0 = null;
        }
        Function0 function02 = function0;
        boolean Z2 = composer.Z(function1);
        Object objG2 = composer.G();
        if (Z2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.w0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScheduleActivity.g3(function1);
                }
            };
            composer.w(objG2);
        }
        ScheduleSummaryScreenKt.I(scheduleViewState, fO3, function02, (Function0) objG2, composer, 0, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f2(ScheduleActivity scheduleActivity, CoroutineScope coroutineScope, ScaffoldState scaffoldState, ModalBottomSheetState modalBottomSheetState, NavHostController navHostController, ScheduleViewModel scheduleViewModel, Function1 function1, MutableState mutableState, Function1 function12, int i3, Composer composer, int i4) {
        scheduleActivity.Y1(coroutineScope, scaffoldState, modalBottomSheetState, navHostController, scheduleViewModel, function1, mutableState, function12, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f3(Function1 function1) {
        function1.invoke(ScheduleViewEvent.OnSummaryBackClicked.f114584a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g3(Function1 function1) {
        function1.invoke(new ScheduleViewEvent.OnCloseClicked(true));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h2(MutableState mutableState, Function1 function1) {
        LockType lockType = (LockType) mutableState.getValue();
        if (lockType != null) {
            function1.invoke(new ScheduleViewEvent.OnLockUnsavedChangesDialogConfirmed(lockType));
        }
        mutableState.setValue(null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h3(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.d(NavType.f48967n);
        navArgument.b(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i2(MutableState mutableState) {
        mutableState.setValue(null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i3(ScheduleDTO scheduleDTO, final ScheduleActivity scheduleActivity, final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1226763609, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (ScheduleActivity.kt:404)");
        }
        Bundle bundleB = it.b();
        final boolean z2 = bundleB != null ? bundleB.getBoolean("isStartScreen") : true;
        ConditionDTO.LocationDTO locationDTOR = scheduleDTO.r();
        Long lO = scheduleDTO.o();
        boolean z3 = scheduleActivity.P3() instanceof ScheduleDescriptor.NewSchedule;
        boolean z4 = scheduleActivity.P3() instanceof ScheduleDescriptor.CombinationOnboardingV2;
        Float fO3 = scheduleActivity.O3(OnboardingActivityV2.OnboardingNavItem.FirstFocusCondition);
        boolean Z = composer.Z(function1) | composer.b(z2);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.e2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ScheduleActivity.j3(function1, z2, (ConditionDTO.LocationDTO) obj);
                }
            };
            composer.w(objG);
        }
        Function1 function12 = (Function1) objG;
        boolean zB = composer.b(z2) | composer.I(scheduleActivity) | composer.I(navHostController);
        Object objG2 = composer.G();
        if (zB || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.f2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScheduleActivity.k3(z2, scheduleActivity, navHostController);
                }
            };
            composer.w(objG2);
        }
        LocationConditionScreenKt.j0(locationDTOR, lO, z3, z2, z4, fO3, true, function12, (Function0) objG2, composer, 1572864, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j2(ScheduleActivity scheduleActivity, MutableState mutableState, int i3, Function1 function1, int i4, Composer composer, int i5) {
        scheduleActivity.g2(mutableState, i3, function1, composer, RecomposeScopeImplKt.a(i4 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j3(Function1 function1, boolean z2, ConditionDTO.LocationDTO condition) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        function1.invoke(new ScheduleViewEvent.OnConditionSet(condition, z2));
        return Unit.f139807a;
    }

    private final void k2(final NavHostController navHostController, final String str, final ScheduleViewState scheduleViewState, final ScheduleViewModel scheduleViewModel, final ModalBottomSheetState modalBottomSheetState, final ScheduleDTO scheduleDTO, final BaseSelectionViewModel.ApplicationWebsiteSelectDTO applicationWebsiteSelectDTO, final Function1 function1, final Function1 function12, final MutableState mutableState, final MutableState mutableState2, final PaddingValues paddingValues, final ScaffoldState scaffoldState, Composer composer, final int i3, final int i4) {
        int i5;
        ScheduleViewState scheduleViewState2;
        ScheduleDTO scheduleDTO2;
        int i6;
        Composer composer2;
        int i7;
        Composer composerK = composer.k(104846028);
        if ((i3 & 6) == 0) {
            i5 = (composerK.I(navHostController) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(str) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            scheduleViewState2 = scheduleViewState;
            i5 |= composerK.Z(scheduleViewState2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            scheduleViewState2 = scheduleViewState;
        }
        if ((i3 & 24576) == 0) {
            i5 |= (i3 & 32768) == 0 ? composerK.Z(modalBottomSheetState) : composerK.I(modalBottomSheetState) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            scheduleDTO2 = scheduleDTO;
            i5 |= composerK.Z(scheduleDTO2) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            scheduleDTO2 = scheduleDTO;
        }
        if ((i3 & 1572864) == 0) {
            i5 |= composerK.I(applicationWebsiteSelectDTO) ? 1048576 : 524288;
        }
        if ((i3 & 12582912) == 0) {
            i5 |= composerK.I(function1) ? 8388608 : 4194304;
        }
        if ((i3 & 100663296) == 0) {
            i5 |= composerK.I(function12) ? 67108864 : 33554432;
        }
        if ((i3 & 805306368) == 0) {
            i5 |= composerK.Z(mutableState) ? 536870912 : 268435456;
        }
        if ((i4 & 6) == 0) {
            i6 = i4 | (composerK.Z(mutableState2) ? 4 : 2);
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= composerK.Z(paddingValues) ? 32 : 16;
        }
        if ((i4 & 3072) == 0) {
            i6 |= composerK.I(this) ? 2048 : 1024;
        }
        int i8 = i6;
        if (composerK.r(((i5 & 306782355) == 306782354 && (i8 & 1043) == 1042) ? false : true, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(104846028, i5, i8, "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.NavigationHost (ScheduleActivity.kt:342)");
            }
            Modifier modifierH = PaddingKt.h(Modifier.b8, paddingValues);
            boolean zI = ((57344 & i5) == 16384 || ((i5 & 32768) != 0 && composerK.I(modalBottomSheetState))) | ((i5 & 896) == 256) | composerK.I(this) | ((29360128 & i5) == 8388608) | ((i8 & 14) == 4) | composerK.I(navHostController) | ((458752 & i5) == 131072) | ((1879048192 & i5) == 536870912) | composerK.I(applicationWebsiteSelectDTO) | ((234881024 & i5) == 67108864);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                i7 = i5;
                final ScheduleViewState scheduleViewState3 = scheduleViewState2;
                final ScheduleDTO scheduleDTO3 = scheduleDTO2;
                Function1 function13 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.i2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ScheduleActivity.l2(scheduleViewState3, modalBottomSheetState, this, function1, mutableState2, navHostController, scheduleDTO3, mutableState, applicationWebsiteSelectDTO, function12, (NavGraphBuilder) obj);
                    }
                };
                composerK.w(function13);
                objG = function13;
            } else {
                i7 = i5;
            }
            composer2 = composerK;
            NavHostKt.v(navHostController, str, modifierH, null, null, null, null, null, null, null, (Function1) objG, composer2, i7 & 126, 0, 1016);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScheduleActivity.u3(this.f115163a, navHostController, str, scheduleViewState, scheduleViewModel, modalBottomSheetState, scheduleDTO, applicationWebsiteSelectDTO, function1, function12, mutableState, mutableState2, paddingValues, scaffoldState, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k3(boolean z2, ScheduleActivity scheduleActivity, NavHostController navHostController) {
        if (z2) {
            scheduleActivity.finish();
        } else {
            navHostController.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l3(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.d(NavType.f48967n);
        navArgument.b(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m2(ScheduleViewState scheduleViewState, ModalBottomSheetState modalBottomSheetState, ScheduleActivity scheduleActivity, final Function1 function1, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-109732049, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (ScheduleActivity.kt:349)");
        }
        boolean z2 = scheduleActivity.P3() instanceof ScheduleDescriptor.CombinationOnboardingV2;
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.t1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScheduleActivity.n2(function1);
                }
            };
            composer.w(objG);
        }
        DetailScreenKt.b0(scheduleViewState, modalBottomSheetState, z2, function1, (Function0) objG, composer, ModalBottomSheetState.f13222e << 3);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m3(ScheduleDTO scheduleDTO, ScheduleViewState scheduleViewState, final ScheduleActivity scheduleActivity, final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(2057537640, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (ScheduleActivity.kt:435)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            Bundle bundleB = it.b();
            objG = Boolean.valueOf(bundleB != null ? bundleB.getBoolean("isStartScreen") : true);
            composer.w(objG);
        }
        final boolean zBooleanValue = ((Boolean) objG).booleanValue();
        ConditionDTO.TimeDTO timeDTOX = scheduleDTO.x();
        GraphData graphDataK = scheduleViewState.k();
        Long lO = scheduleDTO.o();
        boolean zA = scheduleActivity.P3().a();
        boolean z2 = scheduleActivity.P3() instanceof ScheduleDescriptor.CombinationOnboardingV2;
        Float fO3 = scheduleActivity.O3(OnboardingActivityV2.OnboardingNavItem.FirstFocusCondition);
        boolean Z = composer.Z(function1);
        Object objG2 = composer.G();
        if (Z || objG2 == companion.a()) {
            objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.y1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ScheduleActivity.n3(function1, zBooleanValue, (ConditionDTO.TimeDTO) obj);
                }
            };
            composer.w(objG2);
        }
        Function1 function12 = (Function1) objG2;
        boolean zI = composer.I(scheduleActivity) | composer.I(navHostController);
        Object objG3 = composer.G();
        if (zI || objG3 == companion.a()) {
            objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.z1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScheduleActivity.o3(zBooleanValue, scheduleActivity, navHostController);
                }
            };
            composer.w(objG3);
        }
        TimeConditionScreenKt.L(timeDTOX, graphDataK, lO, zA, true, function12, zBooleanValue, z2, fO3, (Function0) objG3, composer, (GraphData.f132767h << 3) | 1597440, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n2(Function1 function1) {
        function1.invoke(new ScheduleViewEvent.OnSaveButtonClicked(false, 1, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n3(Function1 function1, boolean z2, ConditionDTO.TimeDTO condition) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        function1.invoke(new ScheduleViewEvent.OnConditionSet(condition, z2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o2(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.d(NavType.f48967n);
        navArgument.b(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o3(boolean z2, ScheduleActivity scheduleActivity, NavHostController navHostController) {
        if (z2) {
            scheduleActivity.finish();
        } else {
            navHostController.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p2(ScheduleDTO scheduleDTO, final ScheduleActivity scheduleActivity, final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        boolean z2;
        final boolean z3;
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(36205546, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (ScheduleActivity.kt:508)");
        }
        Bundle bundleB = it.b();
        if (bundleB != null) {
            z3 = bundleB.getBoolean("isStartScreen");
            z2 = true;
        } else {
            z2 = true;
            z3 = true;
        }
        ConditionDTO.CombinationDTO combinationDTOM = scheduleDTO.m();
        if (scheduleDTO.k() != Profile.BlockingMode.Allowlist) {
            z2 = false;
        }
        boolean z4 = z2;
        Long lO = scheduleDTO.o();
        boolean zA = scheduleActivity.P3().a();
        boolean Z = composer.Z(function1) | composer.b(z3);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.l1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ScheduleActivity.q2(function1, z3, (ConditionDTO.CombinationDTO) obj);
                }
            };
            composer.w(objG);
        }
        Function1 function12 = (Function1) objG;
        boolean zB = composer.b(z3) | composer.I(scheduleActivity) | composer.I(navHostController);
        Object objG2 = composer.G();
        if (zB || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.m1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScheduleActivity.r2(z3, scheduleActivity, navHostController);
                }
            };
            composer.w(objG2);
        }
        CustomCombinationScreenKt.k0(combinationDTOM, lO, zA, function12, z3, z4, true, (Function0) objG2, composer, 1572864, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p3(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.d(NavType.f48967n);
        navArgument.b(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q2(Function1 function1, boolean z2, ConditionDTO.CombinationDTO condition) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        function1.invoke(new ScheduleViewEvent.OnConditionSet(condition, z2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q3(ScheduleDTO scheduleDTO, final ScheduleActivity scheduleActivity, final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1046871593, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (ScheduleActivity.kt:472)");
        }
        Bundle bundleB = it.b();
        final boolean z2 = bundleB != null ? bundleB.getBoolean("isStartScreen") : true;
        ConditionDTO.LaunchCountDTO launchCountDTOQ = scheduleDTO.q();
        Long lO = scheduleDTO.o();
        boolean z3 = scheduleActivity.P3() instanceof ScheduleDescriptor.NewSchedule;
        boolean z4 = scheduleActivity.P3() instanceof ScheduleDescriptor.CombinationOnboardingV2;
        Float fO3 = scheduleActivity.O3(OnboardingActivityV2.OnboardingNavItem.FirstFocusCondition);
        boolean Z = composer.Z(function1) | composer.b(z2);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.n1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ScheduleActivity.r3(function1, z2, (ConditionDTO.LaunchCountDTO) obj);
                }
            };
            composer.w(objG);
        }
        Function1 function12 = (Function1) objG;
        boolean zB = composer.b(z2) | composer.I(scheduleActivity) | composer.I(navHostController);
        Object objG2 = composer.G();
        if (zB || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.o1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScheduleActivity.s3(z2, scheduleActivity, navHostController);
                }
            };
            composer.w(objG2);
        }
        LaunchCountConditionScreenKt.L(launchCountDTOQ, z3, lO, function12, true, z2, z4, fO3, (Function0) objG2, composer, 24576, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r2(boolean z2, ScheduleActivity scheduleActivity, NavHostController navHostController) {
        if (z2) {
            scheduleActivity.finish();
        } else {
            navHostController.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r3(Function1 function1, boolean z2, ConditionDTO.LaunchCountDTO condition) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        function1.invoke(new ScheduleViewEvent.OnConditionSet(condition, z2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s2(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.d(NavType.f48967n);
        navArgument.b(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s3(boolean z2, ScheduleActivity scheduleActivity, NavHostController navHostController) {
        if (z2) {
            scheduleActivity.finish();
        } else {
            navHostController.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t2(ScheduleDTO scheduleDTO, final ScheduleActivity scheduleActivity, final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-974460501, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (ScheduleActivity.kt:543)");
        }
        Bundle bundleB = it.b();
        final boolean z2 = bundleB != null ? bundleB.getBoolean("isStartScreen") : true;
        ConditionDTO.UsageLimitDTO usageLimitDTOA = scheduleDTO.A();
        Long lO = scheduleDTO.o();
        boolean z3 = scheduleActivity.P3() instanceof ScheduleDescriptor.NewSchedule;
        boolean z4 = scheduleActivity.P3() instanceof ScheduleDescriptor.CombinationOnboardingV2;
        Float fO3 = scheduleActivity.O3(OnboardingActivityV2.OnboardingNavItem.FirstFocusCondition);
        boolean Z = composer.Z(function1) | composer.b(z2);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.q1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ScheduleActivity.u2(function1, z2, (ConditionDTO.UsageLimitDTO) obj);
                }
            };
            composer.w(objG);
        }
        Function1 function12 = (Function1) objG;
        boolean zB = composer.b(z2) | composer.I(scheduleActivity) | composer.I(navHostController);
        Object objG2 = composer.G();
        if (zB || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.r1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScheduleActivity.v2(z2, scheduleActivity, navHostController);
                }
            };
            composer.w(objG2);
        }
        UsageLimitConditionScreenKt.P(usageLimitDTOA, lO, z3, function12, true, z2, z4, fO3, (Function0) objG2, composer, 24576, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t3(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.d(NavType.f48967n);
        navArgument.b(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u2(Function1 function1, boolean z2, ConditionDTO.UsageLimitDTO condition) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        function1.invoke(new ScheduleViewEvent.OnConditionSet(condition, z2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u3(ScheduleActivity scheduleActivity, NavHostController navHostController, String str, ScheduleViewState scheduleViewState, ScheduleViewModel scheduleViewModel, ModalBottomSheetState modalBottomSheetState, ScheduleDTO scheduleDTO, BaseSelectionViewModel.ApplicationWebsiteSelectDTO applicationWebsiteSelectDTO, Function1 function1, Function1 function12, MutableState mutableState, MutableState mutableState2, PaddingValues paddingValues, ScaffoldState scaffoldState, int i3, int i4, Composer composer, int i5) {
        scheduleActivity.k2(navHostController, str, scheduleViewState, scheduleViewModel, modalBottomSheetState, scheduleDTO, applicationWebsiteSelectDTO, function1, function12, mutableState, mutableState2, paddingValues, scaffoldState, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v2(boolean z2, ScheduleActivity scheduleActivity, NavHostController navHostController) {
        if (z2) {
            scheduleActivity.finish();
        } else {
            navHostController.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w2(NavArgumentBuilder navArgument) {
        Intrinsics.checkNotNullParameter(navArgument, "$this$navArgument");
        navArgument.d(NavType.f48967n);
        navArgument.b(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w3(MutableState mutableState, Function1 function1, long j3, UsageLimit.PeriodType periodType) {
        Intrinsics.checkNotNullParameter(periodType, "periodType");
        if (mutableState.getValue() instanceof BlockingConditionConfig.UsageLimitConfig) {
            function1.invoke(new ScheduleViewEvent.OnSetProfileUsageLimitTime(j3, periodType));
        } else {
            function1.invoke(new ScheduleViewEvent.OnSetProfileLaunchCount(j3, periodType));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x2(ScheduleDTO scheduleDTO, final ScheduleActivity scheduleActivity, final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1985126548, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (ScheduleActivity.kt:579)");
        }
        Bundle bundleB = it.b();
        final boolean z2 = bundleB != null ? bundleB.getBoolean("isStartScreen") : true;
        ConditionDTO.WifisDTO wifisDTOD = scheduleDTO.D();
        Long lO = scheduleDTO.o();
        boolean z3 = scheduleActivity.P3() instanceof ScheduleDescriptor.NewSchedule;
        boolean z4 = scheduleActivity.P3() instanceof ScheduleDescriptor.CombinationOnboardingV2;
        Float fO3 = scheduleActivity.O3(OnboardingActivityV2.OnboardingNavItem.FirstFocusCondition);
        boolean Z = composer.Z(function1) | composer.b(z2);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.x0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ScheduleActivity.y2(function1, z2, (ConditionDTO.WifisDTO) obj);
                }
            };
            composer.w(objG);
        }
        Function1 function12 = (Function1) objG;
        boolean zB = composer.b(z2) | composer.I(scheduleActivity) | composer.I(navHostController);
        Object objG2 = composer.G();
        if (zB || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.y0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScheduleActivity.z2(z2, scheduleActivity, navHostController);
                }
            };
            composer.w(objG2);
        }
        WifiConditionScreenKt.D0(wifisDTOD, lO, z3, z2, z4, fO3, true, function12, (Function0) objG2, composer, 1572864, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x3(ScheduleActivity scheduleActivity, MutableState mutableState, MutableState mutableState2, Function1 function1, ScheduleDTO scheduleDTO, int i3, Composer composer, int i4) {
        scheduleActivity.v3(mutableState, mutableState2, function1, scheduleDTO, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y2(Function1 function1, boolean z2, ConditionDTO.WifisDTO condition) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        function1.invoke(new ScheduleViewEvent.OnConditionSet(condition, z2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder y3(ScheduleDescriptor scheduleDescriptor, boolean z2) {
        return ParametersHolderKt.b(scheduleDescriptor, Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z2(boolean z2, ScheduleActivity scheduleActivity, NavHostController navHostController) {
        if (z2) {
            scheduleActivity.finish();
        } else {
            navHostController.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z3(ScheduleDescriptor scheduleDescriptor, final ScheduleActivity scheduleActivity, Function1 function1, ScheduleViewState scheduleViewState, ScheduleResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (scheduleDescriptor instanceof ScheduleDescriptor.QuickBlockOnboarding) {
            if (result.d()) {
                scheduleActivity.startActivity(QuickBlockBlockingTestActivity.f104744f.a(scheduleActivity));
            } else {
                scheduleActivity.startActivity(IntroScheduleActivity.f104813g.a(scheduleActivity, true));
            }
            scheduleActivity.finish();
        } else if (scheduleDescriptor instanceof ScheduleDescriptor.CombinationOnboardingV2) {
            function1.invoke(ScheduleViewEvent.OnOnboardingFinished.f114575a);
        } else {
            if (result.d()) {
                Intent intent = new Intent();
                Integer numB = result.b();
                if (numB != null) {
                    intent.putExtra("PROFILE_TYPE_COMBINATIONS", numB.intValue());
                    intent.putExtra("ADD_TO_FOLLOW_SCHEDULES", result.a());
                }
                Long lC = result.c();
                if (lC != null) {
                    intent.putExtra("PROFILE_ID", lC.longValue());
                }
                Unit unit = Unit.f139807a;
                scheduleActivity.setResult(-1, intent);
                if (scheduleDescriptor instanceof ScheduleDescriptor.ScheduleTemplateDescriptor) {
                    AnswersHelper answersHelper = AnswersHelper.f128199a;
                    ScheduleTemplate scheduleTemplateC = ((ScheduleDescriptor.ScheduleTemplateDescriptor) scheduleDescriptor).c();
                    answersHelper.g5(scheduleTemplateC != null ? scheduleTemplateC.getAnalyticsKey() : null);
                }
            }
            InterstitialUtils.f127880h.t(scheduleActivity, AdUnitId.APP_INTERSTITIAL, scheduleViewState.l(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ScheduleActivity.A3(this.f116473a, (Boolean) obj);
                }
            });
        }
        return Unit.f139807a;
    }

    public final void T1(final MutableState mutableState, final boolean z2, final Function1 onEvent, Composer composer, final int i3) {
        MutableState mutableState2;
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(136748711);
        if ((i3 & 6) == 0) {
            mutableState2 = mutableState;
            i4 = (composerK.Z(mutableState2) ? 4 : 2) | i3;
        } else {
            mutableState2 = mutableState;
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onEvent) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(136748711, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.ChargerLockConfirmDialog (ScheduleActivity.kt:1121)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.TRUE, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState3 = (MutableState) objG;
            String strB = StringResources_androidKt.b(R.string.f95842s, composerK, 0);
            String strB2 = StringResources_androidKt.b(R.string.ov, composerK, 0);
            String strB3 = StringResources_androidKt.b(z2 ? R.string.jj : R.string.ij, composerK, 0);
            ComposableLambda composableLambdaE = ComposableLambdaKt.e(1756076225, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.n0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScheduleActivity.U1(mutableState3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54);
            boolean z3 = (i4 & 896) == 256;
            Object objG2 = composerK.G();
            if (z3 || objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.o0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ScheduleActivity.W1(onEvent, mutableState3);
                    }
                };
                composerK.w(objG2);
            }
            composer2 = composerK;
            ComposeDialogsKt.x0(mutableState2, strB, strB2, composableLambdaE, strB3, 0L, false, (Function0) objG2, null, 0L, null, composer2, (i4 & 14) | 3072, 0, 1888);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.p0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScheduleActivity.X1(this.f117318a, mutableState, z2, onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void Y1(final CoroutineScope scope, final ScaffoldState scaffoldState, final ModalBottomSheetState detailBottomSheetState, final NavHostController navController, final ScheduleViewModel viewModel, final Function1 onEvent, final MutableState isFirstShownRecommended, final Function1 onCloseClicked, Composer composer, final int i3) {
        int i4;
        ManagedActivityResultLauncher managedActivityResultLauncher;
        SnapshotMutationPolicy snapshotMutationPolicy;
        int i5;
        SnapshotMutationPolicy snapshotMutationPolicy2;
        MutableState mutableState;
        MutableState mutableState2;
        int i6;
        SnapshotMutationPolicy snapshotMutationPolicy3;
        int i7;
        Composer composer2;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(scaffoldState, "scaffoldState");
        Intrinsics.checkNotNullParameter(detailBottomSheetState, "detailBottomSheetState");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(isFirstShownRecommended, "isFirstShownRecommended");
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Composer composerK = composer.k(171746391);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(scope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(scaffoldState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= (i3 & 512) == 0 ? composerK.Z(detailBottomSheetState) : composerK.I(detailBottomSheetState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(navController) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(viewModel) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(onEvent) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.Z(isFirstShownRecommended) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i4 |= composerK.I(onCloseClicked) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            i4 |= composerK.I(this) ? 67108864 : 33554432;
        }
        if (composerK.r((38347923 & i4) != 38347922, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(171746391, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.CommandProcessor (ScheduleActivity.kt:790)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            PermissionRequestReason permissionRequestReason = PermissionRequestReason.General;
            int i8 = i4 & 458752;
            boolean zI = composerK.I(this) | (i8 == 131072);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.e
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScheduleActivity.Z1(this.f117096a, onEvent, (ActivityResult) obj, (PermissionRequestReason) obj2);
                    }
                };
                composerK.w(objG);
            }
            ActivityLauncher activityLauncherP = ComposeCommonsKt.p(permissionRequestReason, (Function2) objG, composerK, 6);
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            boolean zI2 = composerK.I(navController);
            Object objG2 = composerK.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ScheduleActivity.a2(navController, (ActivityResult) obj);
                    }
                };
                composerK.w(objG2);
            }
            ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG2, composerK, 0);
            Object objG3 = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG3);
            }
            MutableState mutableState3 = (MutableState) objG3;
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                managedActivityResultLauncher = managedActivityResultLauncherA;
                objG4 = SnapshotStateKt__SnapshotStateKt.e(TuplesKt.a("", ""), null, 2, null);
                composerK.w(objG4);
            } else {
                managedActivityResultLauncher = managedActivityResultLauncherA;
            }
            MutableState mutableState4 = (MutableState) objG4;
            ComposeDialogsKt.R0(mutableState3, (String) ((Pair) mutableState4.getValue()).e(), (String) ((Pair) mutableState4.getValue()).f(), null, null, null, composerK, 6, 56);
            Object objG5 = composerK.G();
            if (objG5 == companion.a()) {
                snapshotMutationPolicy = null;
                Object objE = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objE);
                objG5 = objE;
            } else {
                snapshotMutationPolicy = null;
            }
            MutableState mutableState5 = (MutableState) objG5;
            Object objG6 = composerK.G();
            int i9 = i4;
            if (objG6 == companion.a()) {
                objG6 = SnapshotStateKt__SnapshotStateKt.e(snapshotMutationPolicy, snapshotMutationPolicy, 2, snapshotMutationPolicy);
                composerK.w(objG6);
            }
            ComposeDialogsKt.R0(mutableState5, getString(R.string.Xh), (String) ((MutableState) objG6).getValue(), null, null, null, composerK, 6, 56);
            Object objG7 = composerK.G();
            if (objG7 == companion.a()) {
                i5 = 2;
                objG7 = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
                composerK.w(objG7);
            } else {
                i5 = 2;
            }
            MutableState mutableState6 = (MutableState) objG7;
            Object objG8 = composerK.G();
            if (objG8 == companion.a()) {
                Object objE2 = SnapshotStateKt__SnapshotStateKt.e(Integer.valueOf(R.string.l8), null, i5, null);
                composerK.w(objE2);
                objG8 = objE2;
            }
            MutableState mutableState7 = (MutableState) objG8;
            int i10 = ((i9 >> 9) & 896) | 6 | ((i9 >> 15) & 7168);
            ManagedActivityResultLauncher managedActivityResultLauncher2 = managedActivityResultLauncher;
            g2(mutableState6, ((Number) mutableState7.getValue()).intValue(), onEvent, composerK, i10);
            Object objG9 = composerK.G();
            if (objG9 == companion.a()) {
                snapshotMutationPolicy2 = null;
                objG9 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG9);
            } else {
                snapshotMutationPolicy2 = null;
            }
            MutableState mutableState8 = (MutableState) objG9;
            Object objG10 = composerK.G();
            if (objG10 == companion.a()) {
                objG10 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, snapshotMutationPolicy2, 2, snapshotMutationPolicy2);
                composerK.w(objG10);
            }
            MutableState mutableState9 = (MutableState) objG10;
            T1(mutableState8, ((Boolean) mutableState9.getValue()).booleanValue(), onEvent, composerK, i10);
            Object objG11 = composerK.G();
            if (objG11 == companion.a()) {
                objG11 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG11);
            }
            MutableState mutableState10 = (MutableState) objG11;
            int i11 = i9 & 29360128;
            boolean z2 = i11 == 8388608;
            Object objG12 = composerK.G();
            if (z2 || objG12 == companion.a()) {
                objG12 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ScheduleActivity.b2(onCloseClicked);
                    }
                };
                composerK.w(objG12);
            }
            ComposeDialogsKt.H0(mutableState10, (Function0) objG12, composerK, 6);
            Object objG13 = composerK.G();
            if (objG13 == companion.a()) {
                mutableState = mutableState10;
                objG13 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG13);
            } else {
                mutableState = mutableState10;
            }
            MutableState mutableState11 = (MutableState) objG13;
            if (((Boolean) mutableState11.getValue()).booleanValue()) {
                composerK.a0(1193835990);
                boolean z3 = i8 == 131072;
                Object objG14 = composerK.G();
                if (z3 || objG14 == companion.a()) {
                    objG14 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.h
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ScheduleActivity.c2(onEvent);
                        }
                    };
                    composerK.w(objG14);
                }
                Function0 function0 = (Function0) objG14;
                boolean z4 = i8 == 131072;
                Object objG15 = composerK.G();
                mutableState2 = mutableState3;
                if (z4 || objG15 == companion.a()) {
                    objG15 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.i
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ScheduleActivity.d2(onEvent);
                        }
                    };
                    composerK.w(objG15);
                }
                ComposeDialogsKt.d0(mutableState11, function0, (Function0) objG15, composerK, 6);
            } else {
                mutableState2 = mutableState3;
                composerK.a0(1151860843);
            }
            composerK.U();
            Object objG16 = composerK.G();
            if (objG16 == companion.a()) {
                objG16 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG16);
            }
            MutableState mutableState12 = (MutableState) objG16;
            String strB = StringResources_androidKt.b(R.string.oj, composerK, 0);
            TimePickerConfig timePickerConfig = new TimePickerConfig(new TimePickerConfig.TimePickerType.Minutes(0L, 0L, 3, null), new TimePickerConfig.TimePickerType.Hours(0L, 0L, 3, null), new TimePickerConfig.TimePickerType.Days(0L, 99L, 1, null), false, null, false, 56, null);
            String strB2 = StringResources_androidKt.b(R.string.ij, composerK, 0);
            boolean z5 = i8 == 131072;
            Object objG17 = composerK.G();
            if (z5 || objG17 == companion.a()) {
                objG17 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ScheduleActivity.e2(onEvent, ((Long) obj).longValue());
                    }
                };
                composerK.w(objG17);
            }
            TimeSelectBottomSheetKt.g((Function1) objG17, null, timePickerConfig, 0L, null, false, strB, strB2, null, mutableState12, null, composerK, 805306368, 0, 1338);
            Object objG18 = composerK.G();
            if (objG18 == companion.a()) {
                snapshotMutationPolicy3 = null;
                Object objE3 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objE3);
                objG18 = objE3;
                i6 = 2;
            } else {
                i6 = 2;
                snapshotMutationPolicy3 = null;
            }
            MutableState mutableState13 = (MutableState) objG18;
            Object objG19 = composerK.G();
            if (objG19 == companion.a()) {
                objG19 = SnapshotStateKt__SnapshotStateKt.e(snapshotMutationPolicy3, snapshotMutationPolicy3, i6, snapshotMutationPolicy3);
                composerK.w(objG19);
            }
            MutableState mutableState14 = (MutableState) objG19;
            ComposeDialogsKt.R0(mutableState13, (String) mutableState14.getValue(), null, null, null, null, composerK, 6, 60);
            boolean zI3 = composerK.I(navController) | (i11 == 8388608) | ((3670016 & i9) == 1048576) | composerK.I(context) | composerK.I(activityLauncherP) | composerK.I(scope) | ((i9 & 112) == 32) | composerK.I(this) | ((i9 & 896) == 256 || ((i9 & 512) != 0 && composerK.I(detailBottomSheetState))) | (i8 == 131072) | composerK.I(managedActivityResultLauncher2);
            Object objG20 = composerK.G();
            if (zI3 || objG20 == companion.a()) {
                i7 = i9;
                Object scheduleActivity$CommandProcessor$5$1 = new ScheduleActivity$CommandProcessor$5$1(navController, onCloseClicked, isFirstShownRecommended, context, activityLauncherP, mutableState, scope, this, mutableState4, mutableState2, mutableState9, mutableState8, mutableState12, mutableState7, mutableState6, detailBottomSheetState, onEvent, mutableState11, mutableState14, mutableState13, managedActivityResultLauncher2, scaffoldState, null);
                composer2 = composerK;
                composer2.w(scheduleActivity$CommandProcessor$5$1);
                objG20 = scheduleActivity$CommandProcessor$5$1;
            } else {
                i7 = i9;
                composer2 = composerK;
            }
            Composer composer3 = composer2;
            FlowExtKt.g(viewModel, null, (Function2) objG20, composer3, (i7 >> 12) & 14, 2);
            composerK = composer3;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScheduleActivity.f2(this.f117263a, scope, scaffoldState, detailBottomSheetState, navController, viewModel, onEvent, isFirstShownRecommended, onCloseClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
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
        final ScheduleActivity scheduleActivity;
        String route;
        ScheduleTemplate scheduleTemplateC;
        ScheduleViewState scheduleViewState;
        SnapshotMutationPolicy snapshotMutationPolicy;
        Bundle bundleB;
        final ScheduleActivity scheduleActivity2 = this;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(-1265918139);
        if ((i3 & 48) == 0) {
            i4 = i3 | (composerK.I(scheduleActivity2) ? 32 : 16);
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1265918139, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.RootCompose (ScheduleActivity.kt:179)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            CoroutineScope coroutineScopeI = CoroutineScopeKt.i((CoroutineScope) objG, CoroutinesHelperExtKt.b());
            final ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composerK, 0, 3);
            final ModalBottomSheetState modalBottomSheetStateJ = ModalBottomSheetKt.j(ModalBottomSheetValue.Hidden, null, null, false, composerK, 6, 14);
            final NavHostController navHostControllerB = NavHostControllerKt.b(new Navigator[0], composerK, 0);
            final ScheduleDescriptor scheduleDescriptorP3 = scheduleActivity2.P3();
            Intent intent = scheduleActivity2.getIntent();
            boolean zI = composerK.I(scheduleActivity2) | composerK.Z(scheduleDescriptorP3);
            Object objG2 = composerK.G();
            if (zI || objG2 == companion.a()) {
                objG2 = new ScheduleActivity$RootCompose$1$1(scheduleActivity2, scheduleDescriptorP3, null);
                composerK.w(objG2);
            }
            EffectsKt.g(intent, (Function2) objG2, composerK, 0);
            if ((scheduleDescriptorP3 instanceof ScheduleDescriptor.QuickBlockOnboarding) && !((ScheduleDescriptor.QuickBlockOnboarding) scheduleDescriptorP3).c().isEmpty()) {
                route = NavItem.RecommendedApps.getRoute();
            } else if (scheduleDescriptorP3 instanceof ScheduleDescriptor.CombinationOnboardingV2) {
                route = scheduleActivity2.L3(((ScheduleDescriptor.CombinationOnboardingV2) scheduleDescriptorP3).d()).getRoute();
            } else {
                boolean z2 = scheduleDescriptorP3 instanceof ScheduleDescriptor.NewSchedule;
                if (z2 && ((ScheduleDescriptor.NewSchedule) scheduleDescriptorP3).g()) {
                    route = NavItem.Conditions.getRoute();
                } else if ((scheduleDescriptorP3 instanceof ScheduleDescriptor.QuickBlock) && ((ScheduleDescriptor.QuickBlock) scheduleDescriptorP3).d()) {
                    route = NavItem.ApplicationSelect.getRoute();
                } else if (z2) {
                    ScheduleDescriptor.NewSchedule newSchedule = (ScheduleDescriptor.NewSchedule) scheduleDescriptorP3;
                    if (newSchedule.f() != null) {
                        route = scheduleActivity2.L3(newSchedule.f()).getRoute();
                    } else if (newSchedule.c() != null) {
                        route = NavItem.Detail.getRoute();
                    } else {
                        route = NavItem.Conditions.getRoute() + "?isStartScreen=true";
                    }
                } else {
                    route = ((scheduleDescriptorP3 instanceof ScheduleDescriptor.ScheduleTemplateDescriptor) && (scheduleTemplateC = ((ScheduleDescriptor.ScheduleTemplateDescriptor) scheduleDescriptorP3).c()) != null && scheduleTemplateC.getHasLocation()) ? NavItem.LocationCondition.getRoute() : NavItem.Detail.getRoute();
                }
            }
            final String str = route;
            final boolean booleanExtra = scheduleActivity2.getIntent().getBooleanExtra("FORCE_RELOAD_SCHEDULES", false);
            boolean Z = composerK.Z(scheduleDescriptorP3) | composerK.b(booleanExtra);
            Object objG3 = composerK.G();
            if (Z || objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.x
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ScheduleActivity.y3(scheduleDescriptorP3, booleanExtra);
                    }
                };
                composerK.w(objG3);
            }
            Function0 function0 = (Function0) objG3;
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
            KClass kClassB = Reflection.b(ScheduleViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, function0);
            composerK.Y();
            composerK.Y();
            final ScheduleViewModel scheduleViewModel = (ScheduleViewModel) viewModelA;
            final ScheduleViewState scheduleViewState2 = (ScheduleViewState) FlowExtKt.m(scheduleViewModel, composerK, 0);
            Long l3 = null;
            boolean z3 = false;
            ArrayList arrayList = null;
            boolean z4 = false;
            final ScheduleDTO scheduleDTO = (ScheduleDTO) androidx.lifecycle.compose.FlowExtKt.b(scheduleViewModel.l3(), new ScheduleDTO(l3, null, false, false, false, z3, false, false, 0, null, null, null, null, null, null, null, null, null, null, arrayList, null, z4, false, false, 0L, 0L, null, false, null, 536870911, null), null, null, null, composerK, 0, 14).getValue();
            final BaseSelectionViewModel.ApplicationWebsiteSelectDTO applicationWebsiteSelectDTO = (BaseSelectionViewModel.ApplicationWebsiteSelectDTO) androidx.lifecycle.compose.FlowExtKt.b(scheduleViewModel.W2(), new BaseSelectionViewModel.ApplicationWebsiteSelectDTO(l3, false ? 1 : 0, null, null, null, z3, null, null, scheduleDescriptorP3 instanceof ScheduleDescriptor.CombinationOnboardingV2, false, false, false, false, false ? 1 : 0, false ? 1 : 0, false ? 1 : 0, false ? 1 : 0, false ? 1 : 0, false ? 1 : 0, arrayList, false, z4, 4194046, null), null, null, null, composerK, 0, 14).getValue();
            final Function1 function1N = FlowExtKt.n(scheduleViewModel, composerK, 0);
            Unit unit = Unit.f139807a;
            boolean zI2 = composerK.I(context) | composerK.Z(scheduleViewState2);
            Object objG4 = composerK.G();
            if (zI2 || objG4 == companion.a()) {
                objG4 = new ScheduleActivity$RootCompose$2$1(context, scheduleViewState2, null);
                composerK.w(objG4);
            }
            EffectsKt.g(unit, (Function2) objG4, composerK, 6);
            Object objG5 = composerK.G();
            if (objG5 == companion.a()) {
                objG5 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.i0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ScheduleActivity.z3(scheduleDescriptorP3, scheduleActivity2, function1N, scheduleViewState2, (ScheduleResult) obj);
                    }
                };
                composerK.w(objG5);
            }
            final Function1 function1 = (Function1) objG5;
            Object objG6 = composerK.G();
            if (objG6 == companion.a()) {
                scheduleViewState = scheduleViewState2;
                snapshotMutationPolicy = null;
                objG6 = SnapshotStateKt__SnapshotStateKt.e(new BlockingConditionConfig.UsageLimitConfig(UsageLimit.PeriodType.DAILY, 0L), null, 2, null);
                composerK.w(objG6);
            } else {
                scheduleViewState = scheduleViewState2;
                snapshotMutationPolicy = null;
            }
            final MutableState mutableState = (MutableState) objG6;
            Object objG7 = composerK.G();
            if (objG7 == companion.a()) {
                objG7 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, snapshotMutationPolicy, 2, snapshotMutationPolicy);
                composerK.w(objG7);
            }
            final MutableState mutableState2 = (MutableState) objG7;
            Object objG8 = composerK.G();
            if (objG8 == companion.a()) {
                objG8 = SnapshotStateKt__SnapshotStateKt.e(Boolean.TRUE, snapshotMutationPolicy, 2, snapshotMutationPolicy);
                composerK.w(objG8);
            }
            final MutableState mutableState3 = (MutableState) objG8;
            final ScheduleViewState scheduleViewState3 = scheduleViewState;
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.b(WindowInsets.f7172a, composerK, 6)), scaffoldStateG, null, null, ComposableSingletons$ScheduleActivityKt.f114369a.b(), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(-470859005, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.t0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ScheduleActivity.B3(this.f117934a, mutableState2, mutableState, function1N, scheduleDTO, navHostControllerB, str, scheduleViewState3, scheduleViewModel, modalBottomSheetStateJ, applicationWebsiteSelectDTO, function1, mutableState3, scaffoldStateG, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 24576, 12582912, 131052);
            ScheduleActivity scheduleActivity3 = this;
            scheduleActivity3.Y1(coroutineScopeI, scaffoldStateG, modalBottomSheetStateJ, navHostControllerB, scheduleViewModel, function1N, mutableState3, function1, composerK, (ModalBottomSheetState.f13222e << 6) | 14155776 | ((i4 << 21) & 234881024));
            Composer composer3 = composerK;
            boolean Z2 = composer3.Z(function1N);
            Object objG9 = composer3.G();
            if (Z2 || objG9 == companion.a()) {
                objG9 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.e1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScheduleActivity.C3(function1N, (LifecycleOwner) obj, (Lifecycle.Event) obj2);
                    }
                };
                composer3.w(objG9);
            }
            ComposableExtKt.j(null, (Function2) objG9, composer3, 0, 1);
            scheduleActivity = scheduleActivity3;
            composer2 = composer3;
            if (ComposerKt.M()) {
                ComposerKt.T();
                scheduleActivity = scheduleActivity3;
                composer2 = composer3;
            }
        } else {
            Composer composer4 = composerK;
            composer4.Q();
            scheduleActivity = scheduleActivity2;
            composer2 = composer4;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.p1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScheduleActivity.D3(this.f117323a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    protected boolean f0() {
        return this.f114384k;
    }

    public final void g2(final MutableState showLockUnsavedChangesDialogForLockType, final int i3, final Function1 onEvent, Composer composer, final int i4) {
        int i5;
        Composer composer2;
        Intrinsics.checkNotNullParameter(showLockUnsavedChangesDialogForLockType, "showLockUnsavedChangesDialogForLockType");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(-426359631);
        if ((i4 & 6) == 0) {
            i5 = (composerK.Z(showLockUnsavedChangesDialogForLockType) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerK.e(i3) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerK.I(onEvent) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-426359631, i5, -1, "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.LockingUnsavedChangesConfirmDialog (ScheduleActivity.kt:1098)");
            }
            if (showLockUnsavedChangesDialogForLockType.getValue() != null) {
                composerK.a0(-1461199582);
                String strB = StringResources_androidKt.b(R.string.qF, composerK, 0);
                String strB2 = StringResources_androidKt.b(R.string.pj, composerK, 0);
                String strB3 = StringResources_androidKt.b(i3, composerK, (i5 >> 3) & 14);
                int i6 = i5 & 14;
                boolean z2 = ((i5 & 896) == 256) | (i6 == 4);
                Object objG = composerK.G();
                if (z2 || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.q0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ScheduleActivity.h2(showLockUnsavedChangesDialogForLockType, onEvent);
                        }
                    };
                    composerK.w(objG);
                }
                Function0 function0 = (Function0) objG;
                boolean z3 = i6 == 4;
                Object objG2 = composerK.G();
                if (z3 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.r0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ScheduleActivity.i2(showLockUnsavedChangesDialogForLockType);
                        }
                    };
                    composerK.w(objG2);
                }
                ComposeDialogsKt.x0(null, strB, strB2, null, strB3, 0L, false, function0, null, 0L, (Function0) objG2, composerK, 6, 0, 872);
                composer2 = composerK;
            } else {
                composer2 = composerK;
                composer2.a0(-1515595375);
            }
            composer2.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.s0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScheduleActivity.j2(this.f117916a, showLockUnsavedChangesDialogForLockType, i3, onEvent, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CoroutinesHelperExtKt.d(new AnonymousClass1(null));
    }

    public final void v3(final MutableState showPickerBottomSheet, final MutableState blockingConditionConfig, final Function1 onEvent, final ScheduleDTO scheduleState, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(showPickerBottomSheet, "showPickerBottomSheet");
        Intrinsics.checkNotNullParameter(blockingConditionConfig, "blockingConditionConfig");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(scheduleState, "scheduleState");
        Composer composerK = composer.k(-277673120);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(showPickerBottomSheet) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(blockingConditionConfig) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onEvent) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(scheduleState) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(this) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-277673120, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity.PickerBottomSheets (ScheduleActivity.kt:1062)");
            }
            if (((Boolean) showPickerBottomSheet.getValue()).booleanValue()) {
                composerK.a0(-52572262);
                BlockingConditionConfig blockingConditionConfig2 = (BlockingConditionConfig) blockingConditionConfig.getValue();
                Long lValueOf = null;
                if (blockingConditionConfig2 instanceof BlockingConditionConfig.UsageLimitConfig) {
                    ConditionDTO.UsageLimitDTO usageLimitDTOA = scheduleState.A();
                    if (usageLimitDTOA != null) {
                        lValueOf = Long.valueOf(usageLimitDTOA.h());
                    }
                } else {
                    if (!(blockingConditionConfig2 instanceof BlockingConditionConfig.LaunchCountConfig)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    ConditionDTO.LaunchCountDTO launchCountDTOQ = scheduleState.q();
                    if (launchCountDTOQ != null) {
                        lValueOf = Long.valueOf(launchCountDTOQ.h());
                    }
                }
                Long l3 = lValueOf;
                boolean z2 = P3() instanceof ScheduleDescriptor.NewSchedule;
                boolean z3 = ((i4 & 112) == 32) | ((i4 & 896) == 256);
                Object objG = composerK.G();
                if (z3 || objG == Composer.f23746a.a()) {
                    objG = new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.a2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ScheduleActivity.w3(blockingConditionConfig, onEvent, ((Long) obj).longValue(), (UsageLimit.PeriodType) obj2);
                        }
                    };
                    composerK.w(objG);
                }
                UsageLimitTimePickerBottomSheetKt.k(showPickerBottomSheet, blockingConditionConfig, l3, z2, (Function2) objG, composerK, i4 & 126, 0);
            } else {
                composerK.a0(-105234814);
            }
            composerK.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.h2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScheduleActivity.x3(this.f117228a, showPickerBottomSheet, blockingConditionConfig, onEvent, scheduleState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l2(final ScheduleViewState scheduleViewState, final ModalBottomSheetState modalBottomSheetState, final ScheduleActivity scheduleActivity, final Function1 function1, final MutableState mutableState, final NavHostController navHostController, final ScheduleDTO scheduleDTO, final MutableState mutableState2, final BaseSelectionViewModel.ApplicationWebsiteSelectDTO applicationWebsiteSelectDTO, final Function1 function12, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        NavGraphBuilderKt.c(NavHost, NavItem.Detail.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-109732049, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.l
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ScheduleActivity.m2(scheduleViewState, modalBottomSheetState, scheduleActivity, function1, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        String route = NavItem.Conditions.getRoute();
        StringBuilder sb = new StringBuilder();
        sb.append(route);
        String str = QaXmqxvjHhxVy.NQz;
        sb.append(str);
        NavGraphBuilderKt.c(NavHost, sb.toString(), CollectionsKt.listOf(NamedNavArgumentKt.a("isStartScreen", new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScheduleActivity.o2((NavArgumentBuilder) obj);
            }
        })), null, null, null, null, null, null, ComposableLambdaKt.c(-216097562, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.e0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ScheduleActivity.Q2(scheduleViewState, mutableState, function1, navHostController, scheduleActivity, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 252, null);
        NavGraphBuilderKt.c(NavHost, NavItem.LocationCondition.getRoute() + str, CollectionsKt.listOf(NamedNavArgumentKt.a("isStartScreen", new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.f0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScheduleActivity.h3((NavArgumentBuilder) obj);
            }
        })), null, null, null, null, null, null, ComposableLambdaKt.c(-1226763609, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.g0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ScheduleActivity.i3(scheduleDTO, scheduleActivity, function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 252, null);
        NavGraphBuilderKt.c(NavHost, NavItem.TimeCondition.getRoute() + str, CollectionsKt.listOf(NamedNavArgumentKt.a("isStartScreen", new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.h0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScheduleActivity.l3((NavArgumentBuilder) obj);
            }
        })), null, null, null, null, null, null, ComposableLambdaKt.c(2057537640, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.j0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ScheduleActivity.m3(scheduleDTO, scheduleViewState, scheduleActivity, function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 252, null);
        NavGraphBuilderKt.c(NavHost, NavItem.LaunchCountCondition.getRoute() + str, CollectionsKt.listOf(NamedNavArgumentKt.a("isStartScreen", new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.k0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScheduleActivity.p3((NavArgumentBuilder) obj);
            }
        })), null, null, null, null, null, null, ComposableLambdaKt.c(1046871593, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.l0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ScheduleActivity.q3(scheduleDTO, scheduleActivity, function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 252, null);
        NavGraphBuilderKt.c(NavHost, NavItem.CombinationCondition.getRoute() + str, CollectionsKt.listOf(NamedNavArgumentKt.a("isStartScreen", new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.m0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScheduleActivity.t3((NavArgumentBuilder) obj);
            }
        })), null, null, null, null, null, null, ComposableLambdaKt.c(36205546, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.n
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ScheduleActivity.p2(scheduleDTO, scheduleActivity, function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 252, null);
        NavGraphBuilderKt.c(NavHost, NavItem.UsageLimitCondition.getRoute() + str, CollectionsKt.listOf(NamedNavArgumentKt.a("isStartScreen", new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScheduleActivity.s2((NavArgumentBuilder) obj);
            }
        })), null, null, null, null, null, null, ComposableLambdaKt.c(-974460501, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.p
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ScheduleActivity.t2(scheduleDTO, scheduleActivity, function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 252, null);
        NavGraphBuilderKt.c(NavHost, NavItem.WifiCondition.getRoute() + str, CollectionsKt.listOf(NamedNavArgumentKt.a("isStartScreen", new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScheduleActivity.w2((NavArgumentBuilder) obj);
            }
        })), null, null, null, null, null, null, ComposableLambdaKt.c(-1985126548, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.r
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ScheduleActivity.x2(scheduleDTO, scheduleActivity, function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 252, null);
        NavGraphBuilderKt.c(NavHost, NavItem.BlockingModeSettings.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(1299174701, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.s
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ScheduleActivity.A2(scheduleDTO, function1, scheduleActivity, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, NavItem.ApplicationSelect.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(288508654, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.t
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ScheduleActivity.E2(mutableState2, scheduleActivity, scheduleViewState, function1, navHostController, applicationWebsiteSelectDTO, function12, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, NavItem.RecommendedApps.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1506822182, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.u
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ScheduleActivity.I2(this.f117959a, mutableState2, function1, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, NavItem.EmojiPicker.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(1777479067, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.v
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ScheduleActivity.K2(scheduleViewState, function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, NavItem.OnboardingScheduleReady.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(766813020, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.w
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ScheduleActivity.M2(scheduleViewState, scheduleDTO, navHostController, function1, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, NavItem.OnboardingExitScreen.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-243853027, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.z
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ScheduleActivity.V2(this.f118045a, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, NavItem.ConflictingSchedules.getRoute() + "?withContinueButton={withContinueButton}", CollectionsKt.listOf(NamedNavArgumentKt.a("withContinueButton", new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScheduleActivity.X2((NavArgumentBuilder) obj);
            }
        })), null, null, null, null, null, null, ComposableLambdaKt.c(-1254519074, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.b0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ScheduleActivity.Y2(scheduleViewState, navHostController, function1, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 252, null);
        NavGraphBuilderKt.c(NavHost, NavItem.ConflictingSchedulesExplanation.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(2029782175, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.c0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ScheduleActivity.c3(navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, NavItem.Summary.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(1019116128, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.d0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return ScheduleActivity.e3(scheduleViewState, scheduleActivity, function1, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        return Unit.f139807a;
    }
}
