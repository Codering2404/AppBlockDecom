package cz.mobilesoft.coreblock.scene.insights.weekly;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material3.SnackbarHostKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity;
import cz.mobilesoft.coreblock.activity.rating.RatingTriggerSource;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.enums.DayFlags;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.scene.email_consent.EmailCommunicationConsentActivity;
import cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsViewEvent;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.schedule.ApplicationDTO;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.scene.sharing.ShareFormattingKt;
import cz.mobilesoft.coreblock.scene.sharing.SocialsSharingActivity;
import cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload;
import cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayloadMappersKt;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class WeeklyInsightsActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f103883g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f103884h = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float f103885i = Dp.g(132);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f103886f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float a() {
            return WeeklyInsightsActivity.f103885i;
        }

        public final Intent b(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, (Class<?>) WeeklyInsightsActivity.class);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Navigation {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Navigation[] $VALUES;
        private final String route;
        public static final Navigation Intro = new Navigation("Intro", 0, "Intro");
        public static final Navigation AverageScreenTime = new Navigation("AverageScreenTime", 1, "AverageScreenTime");
        public static final Navigation Trend = new Navigation("Trend", 2, "Trend");
        public static final Navigation TotalScreenTime = new Navigation("TotalScreenTime", 3, "TotalScreenTime");
        public static final Navigation Distractions = new Navigation("Distractions", 4, "Distractions");
        public static final Navigation TypicalDay = new Navigation("TypicalDay", 5, "TypicalDay");
        public static final Navigation ContinuousUse = new Navigation("ContinuousUse", 6, "ContinuousUse");
        public static final Navigation BreakTheRules = new Navigation("BreakTheRules", 7, "BreakTheRules");
        public static final Navigation Share = new Navigation("Share", 8, "Share");
        public static final Navigation Outro = new Navigation("Outro", 9, "Outro");

        private static final /* synthetic */ Navigation[] $values() {
            return new Navigation[]{Intro, AverageScreenTime, Trend, TotalScreenTime, Distractions, TypicalDay, ContinuousUse, BreakTheRules, Share, Outro};
        }

        static {
            Navigation[] navigationArr$values = $values();
            $VALUES = navigationArr$values;
            $ENTRIES = EnumEntriesKt.a(navigationArr$values);
        }

        private Navigation(String str, int i3, String str2) {
            this.route = str2;
        }

        public static EnumEntries<Navigation> getEntries() {
            return $ENTRIES;
        }

        public static Navigation valueOf(String str) {
            return (Navigation) Enum.valueOf(Navigation.class, str);
        }

        public static Navigation[] values() {
            return (Navigation[]) $VALUES.clone();
        }

        public final String getRoute() {
            return this.route;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f103903a;

        static {
            int[] iArr = new int[WeeklyReportExitAction.values().length];
            try {
                iArr[WeeklyReportExitAction.EmailConsent.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WeeklyReportExitAction.RatingDialog.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WeeklyReportExitAction.None.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f103903a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A1(NavHostController navHostController, float f3, WeeklyInsightsViewState weeklyInsightsViewState, WeeklyInsightsActivity weeklyInsightsActivity, MutableFloatState mutableFloatState, Context context, Offset offset) {
        N1(navHostController, f3, weeklyInsightsViewState, weeklyInsightsActivity, mutableFloatState, context, offset.u());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B1(Context context, WeeklyInsightsViewState weeklyInsightsViewState, ManagedActivityResultLauncher managedActivityResultLauncher) {
        ArrayList arrayList;
        ScheduleActivity.Companion companion = ScheduleActivity.f114377m;
        Iterator<DayFlags> it = DayFlags.getEntries().iterator();
        int value = 0;
        while (it.hasNext()) {
            value += it.next().getValue();
        }
        IntervalDTO intervalDTOU = weeklyInsightsViewState.u();
        if (intervalDTOU == null || (arrayList = CollectionsKt.arrayListOf(intervalDTOU)) == null) {
            arrayList = new ArrayList();
        }
        managedActivityResultLauncher.b(ScheduleActivity.Companion.b(companion, context, new ScheduleDescriptor.NewSchedule(null, null, false, true, new ConditionDTO.TimeDTO(value, arrayList, 0, 4, null), null, 39, null), false, false, 12, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C1(final WeeklyInsightsViewState weeklyInsightsViewState, final NavHostController navHostController, final float f3, final MutableFloatState mutableFloatState, final WeeklyInsightsActivity weeklyInsightsActivity, final Context context, final ManagedActivityResultLauncher managedActivityResultLauncher, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(56813359, i3, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (WeeklyInsightsActivity.kt:408)");
        }
        boolean zI = composer.I(navHostController) | composer.c(f3) | composer.Z(weeklyInsightsViewState) | composer.Z(mutableFloatState) | composer.I(weeklyInsightsActivity) | composer.I(context);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.k2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WeeklyInsightsActivity.D1(navHostController, f3, weeklyInsightsViewState, weeklyInsightsActivity, mutableFloatState, context, (Offset) obj);
                }
            };
            composer.w(function1);
            objG = function1;
        }
        Function1 function12 = (Function1) objG;
        boolean zI2 = composer.I(context) | composer.I(managedActivityResultLauncher);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.l2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WeeklyInsightsActivity.E1(context, managedActivityResultLauncher, (String) obj, (String) obj2);
                }
            };
            composer.w(objG2);
        }
        ContinuousUseScreenKt.f(weeklyInsightsViewState, function12, (Function2) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D1(NavHostController navHostController, float f3, WeeklyInsightsViewState weeklyInsightsViewState, WeeklyInsightsActivity weeklyInsightsActivity, MutableFloatState mutableFloatState, Context context, Offset offset) {
        N1(navHostController, f3, weeklyInsightsViewState, weeklyInsightsActivity, mutableFloatState, context, offset.u());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E1(Context context, ManagedActivityResultLauncher managedActivityResultLauncher, String appName, String packageName) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        managedActivityResultLauncher.b(ScheduleActivity.Companion.b(ScheduleActivity.f114377m, context, new ScheduleDescriptor.NewSchedule(CollectionsKt.listOf(new ApplicationDTO(packageName, appName, CollectionsKt.emptyList())), null, false, true, new ConditionDTO.UsageLimitDTO(TimeUnit.MINUTES.toMillis(15L), null, 0L, null, null, 30, null), null, 38, null), false, false, 12, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F1(final WeeklyInsightsViewState weeklyInsightsViewState, final NavHostController navHostController, final float f3, final MutableFloatState mutableFloatState, final WeeklyInsightsActivity weeklyInsightsActivity, final Context context, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1882449136, i3, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (WeeklyInsightsActivity.kt:436)");
        }
        boolean zI = composer.I(navHostController) | composer.c(f3) | composer.Z(weeklyInsightsViewState) | composer.Z(mutableFloatState) | composer.I(weeklyInsightsActivity) | composer.I(context);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.b2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WeeklyInsightsActivity.G1(navHostController, f3, weeklyInsightsViewState, weeklyInsightsActivity, mutableFloatState, context, (Offset) obj);
                }
            };
            composer.w(function1);
            objG = function1;
        }
        BreakTheRulesScreenKt.c(weeklyInsightsViewState, (Function1) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G1(NavHostController navHostController, float f3, WeeklyInsightsViewState weeklyInsightsViewState, WeeklyInsightsActivity weeklyInsightsActivity, MutableFloatState mutableFloatState, Context context, Offset offset) {
        N1(navHostController, f3, weeklyInsightsViewState, weeklyInsightsActivity, mutableFloatState, context, offset.u());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H1(final WeeklyInsightsViewState weeklyInsightsViewState, final NavHostController navHostController, final float f3, final MutableFloatState mutableFloatState, final WeeklyInsightsActivity weeklyInsightsActivity, final Context context, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-586882383, i3, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (WeeklyInsightsActivity.kt:445)");
        }
        final SocialsSharePayload socialsSharePayloadC = SocialsSharePayloadMappersKt.c(weeklyInsightsViewState);
        boolean zI = composer.I(navHostController) | composer.c(f3) | composer.Z(weeklyInsightsViewState) | composer.Z(mutableFloatState) | composer.I(weeklyInsightsActivity) | composer.I(context);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            Object obj = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.w1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return WeeklyInsightsActivity.I1(navHostController, f3, weeklyInsightsViewState, weeklyInsightsActivity, mutableFloatState, context, (Offset) obj2);
                }
            };
            composer.w(obj);
            objG = obj;
        }
        Function1 function1 = (Function1) objG;
        String strB = ShareFormattingKt.b(socialsSharePayloadC, context);
        boolean zI2 = composer.I(context) | composer.I(socialsSharePayloadC);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.x1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return WeeklyInsightsActivity.J1(context, socialsSharePayloadC);
                }
            };
            composer.w(objG2);
        }
        ShareScreenKt.d(function1, socialsSharePayloadC, strB, (Function0) objG2, composer, SocialsSharePayload.f119374r << 3);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I1(NavHostController navHostController, float f3, WeeklyInsightsViewState weeklyInsightsViewState, WeeklyInsightsActivity weeklyInsightsActivity, MutableFloatState mutableFloatState, Context context, Offset offset) {
        N1(navHostController, f3, weeklyInsightsViewState, weeklyInsightsActivity, mutableFloatState, context, offset.u());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J1(Context context, SocialsSharePayload socialsSharePayload) {
        AnswersHelper.f128199a.B6("weekly_report_share");
        context.startActivity(SocialsSharingActivity.f119356f.a(context, socialsSharePayload));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K1(final WeeklyInsightsViewState weeklyInsightsViewState, final NavHostController navHostController, final float f3, final MutableFloatState mutableFloatState, final WeeklyInsightsActivity weeklyInsightsActivity, final Context context, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1238753394, i3, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (WeeklyInsightsActivity.kt:460)");
        }
        boolean zI = composer.I(navHostController) | composer.c(f3) | composer.Z(weeklyInsightsViewState) | composer.Z(mutableFloatState) | composer.I(weeklyInsightsActivity) | composer.I(context);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.y1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WeeklyInsightsActivity.L1(navHostController, f3, weeklyInsightsViewState, weeklyInsightsActivity, mutableFloatState, context, (Offset) obj);
                }
            };
            composer.w(function1);
            objG = function1;
        }
        OutroScreenKt.c(weeklyInsightsViewState, (Function1) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L1(NavHostController navHostController, float f3, WeeklyInsightsViewState weeklyInsightsViewState, WeeklyInsightsActivity weeklyInsightsActivity, MutableFloatState mutableFloatState, Context context, Offset offset) {
        N1(navHostController, f3, weeklyInsightsViewState, weeklyInsightsActivity, mutableFloatState, context, offset.u());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M1(WeeklyInsightsActivity weeklyInsightsActivity, WeeklyInsightsViewState weeklyInsightsViewState, NavHostController navHostController, SnackbarHostState snackbarHostState, MutableState mutableState, MutableState mutableState2, Function1 function1, MutableFloatState mutableFloatState, int i3, Composer composer, int i4) {
        weeklyInsightsActivity.i1(weeklyInsightsViewState, navHostController, snackbarHostState, mutableState, mutableState2, function1, mutableFloatState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void N1(NavHostController navHostController, float f3, WeeklyInsightsViewState weeklyInsightsViewState, WeeklyInsightsActivity weeklyInsightsActivity, MutableFloatState mutableFloatState, Context context, long j3) {
        NavDestination navDestinationV = navHostController.v();
        String strT = navDestinationV != null ? navDestinationV.t() : null;
        boolean z2 = Float.intBitsToFloat((int) (j3 >> 32)) > f3 * 0.25f;
        if (strT == null) {
            return;
        }
        String strG = z2 ? weeklyInsightsViewState.G(strT) : weeklyInsightsViewState.H(strT);
        if (strG != null) {
            mutableFloatState.s(weeklyInsightsViewState.v());
            NavController.P(navHostController, strG, null, null, 6, null);
        } else if (z2) {
            weeklyInsightsActivity.S1(context, weeklyInsightsViewState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O1(WeeklyInsightsActivity weeklyInsightsActivity, List list) {
        weeklyInsightsActivity.startActivity(ScheduleActivity.Companion.b(ScheduleActivity.f114377m, weeklyInsightsActivity, new ScheduleDescriptor.NewSchedule(list, null, false, true, null, null, 54, null), false, false, 12, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P1(WeeklyInsightsActivity weeklyInsightsActivity) {
        weeklyInsightsActivity.startActivity(Paywall.c(Paywall.f113165a, weeklyInsightsActivity, new PaywallTarget.LimitScreen(PremiumFeature.STATISTICS), "app_feel_labeling", "app_feel_exclude", false, false, false, null, 240, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q1(WeeklyInsightsActivity weeklyInsightsActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        weeklyInsightsActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void S1(Context context, WeeklyInsightsViewState weeklyInsightsViewState) {
        finish();
        int i3 = WhenMappings.f103903a[weeklyInsightsViewState.l().ordinal()];
        if (i3 == 1) {
            context.startActivity(EmailCommunicationConsentActivity.f101711g.a(context, "weekly_insights"));
        } else if (i3 == 2) {
            RatingDialogActivity.f95979p.i(context, true, RatingTriggerSource.WeeklyReport, null);
        } else if (i3 != 3) {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void Z0(final WeeklyInsightsViewModel weeklyInsightsViewModel, final MutableState mutableState, final MutableState mutableState2, final SnackbarHostState snackbarHostState, final CoroutineScope coroutineScope, final Function1 function1, final MutableState mutableState3, Function0 function0, Composer composer, final int i3, final int i4) {
        int i5;
        MutableState mutableState4;
        MutableState mutableState5;
        Function0 function02;
        Composer composer2;
        final Function0 function03;
        Function0 function04;
        int i6;
        Composer composerK = composer.k(-1961462922);
        if ((i3 & 6) == 0) {
            i5 = (composerK.I(weeklyInsightsViewModel) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            mutableState4 = mutableState;
            i5 |= composerK.Z(mutableState4) ? 32 : 16;
        } else {
            mutableState4 = mutableState;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.Z(mutableState2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.Z(snackbarHostState) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= composerK.I(coroutineScope) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i5 |= composerK.I(function1) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            mutableState5 = mutableState3;
            i5 |= composerK.Z(mutableState5) ? 1048576 : 524288;
        } else {
            mutableState5 = mutableState3;
        }
        int i7 = i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i7 != 0) {
            i5 |= 12582912;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i3 & 12582912) == 0) {
                i5 |= composerK.I(function02) ? 8388608 : 4194304;
            }
        }
        if (composerK.r((i5 & 4793491) != 4793490, i5 & 1)) {
            if (i7 != 0) {
                Object objG = composerK.G();
                if (objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.n2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return WeeklyInsightsActivity.a1();
                        }
                    };
                    composerK.w(objG);
                }
                function04 = (Function0) objG;
            } else {
                function04 = function02;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-1961462922, i5, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity.CommandProcessor (WeeklyInsightsActivity.kt:155)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            boolean zI = ((i5 & 112) == 32) | ((i5 & 896) == 256) | ((3670016 & i5) == 1048576) | composerK.I(context) | composerK.I(coroutineScope) | ((i5 & 7168) == 2048) | ((458752 & i5) == 131072) | ((29360128 & i5) == 8388608);
            Object objG2 = composerK.G();
            if (zI || objG2 == Composer.f23746a.a()) {
                i6 = i5;
                WeeklyInsightsActivity$CommandProcessor$2$1 weeklyInsightsActivity$CommandProcessor$2$1 = new WeeklyInsightsActivity$CommandProcessor$2$1(mutableState4, mutableState2, mutableState5, context, coroutineScope, function1, function04, snackbarHostState, null);
                composerK.w(weeklyInsightsActivity$CommandProcessor$2$1);
                objG2 = weeklyInsightsActivity$CommandProcessor$2$1;
            } else {
                i6 = i5;
            }
            composer2 = composerK;
            FlowExtKt.g(weeklyInsightsViewModel, null, (Function2) objG2, composer2, i6 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            function03 = function04;
        } else {
            composer2 = composerK;
            composer2.Q();
            function03 = function02;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.o2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WeeklyInsightsActivity.b1(this.f104270a, weeklyInsightsViewModel, mutableState, mutableState2, snackbarHostState, coroutineScope, function1, mutableState3, function03, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b1(WeeklyInsightsActivity weeklyInsightsActivity, WeeklyInsightsViewModel weeklyInsightsViewModel, MutableState mutableState, MutableState mutableState2, SnackbarHostState snackbarHostState, CoroutineScope coroutineScope, Function1 function1, MutableState mutableState3, Function0 function0, int i3, int i4, Composer composer, int i5) {
        weeklyInsightsActivity.Z0(weeklyInsightsViewModel, mutableState, mutableState2, snackbarHostState, coroutineScope, function1, mutableState3, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private final void c1(final WeeklyInsightsViewState weeklyInsightsViewState, final PaddingValues paddingValues, final MutableState mutableState, final MutableState mutableState2, final Function1 function1, final SnackbarHostState snackbarHostState, Composer composer, final int i3) {
        int i4;
        final MutableState mutableState3;
        final MutableState mutableState4;
        final Function1 function12;
        SnackbarHostState snackbarHostState2;
        Composer composer2;
        Composer composerK = composer.k(154959666);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(weeklyInsightsViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(paddingValues) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            mutableState3 = mutableState;
            i4 |= composerK.Z(mutableState3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            mutableState3 = mutableState;
        }
        if ((i3 & 3072) == 0) {
            mutableState4 = mutableState2;
            i4 |= composerK.Z(mutableState4) ? 2048 : 1024;
        } else {
            mutableState4 = mutableState2;
        }
        if ((i3 & 24576) == 0) {
            function12 = function1;
            i4 |= composerK.I(function12) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            function12 = function1;
        }
        if ((196608 & i3) == 0) {
            snackbarHostState2 = snackbarHostState;
            i4 |= composerK.Z(snackbarHostState2) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            snackbarHostState2 = snackbarHostState;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.I(this) ? 1048576 : 524288;
        }
        if (composerK.r((599187 & i4) != 599186, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(154959666, i4, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity.Content (WeeklyInsightsActivity.kt:219)");
            }
            final NavHostController navHostControllerB = NavHostControllerKt.b(new Navigator[0], composerK, 0);
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = PrimitiveSnapshotStateKt.a(weeklyInsightsViewState.v());
                composerK.w(objG);
            }
            final MutableFloatState mutableFloatState = (MutableFloatState) objG;
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Modifier modifierH = PaddingKt.h(Modifier.b8, paddingValues);
            Float fValueOf = Float.valueOf(mutableFloatState.c());
            boolean zI = composerK.I(this) | composerK.I(context) | ((i4 & 14) == 4);
            Object objG2 = composerK.G();
            if (zI || objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.p2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return WeeklyInsightsActivity.d1(this.f104294a, context, weeklyInsightsViewState);
                    }
                };
                composerK.w(objG2);
            }
            final SnackbarHostState snackbarHostState3 = snackbarHostState2;
            ComposableLambda composableLambdaE = ComposableLambdaKt.e(-949323862, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.q2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return WeeklyInsightsActivity.e1(snackbarHostState3, this, weeklyInsightsViewState, navHostControllerB, mutableState3, mutableState4, function12, mutableFloatState, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54);
            composer2 = composerK;
            ComposeBackgroundKt.s(modifierH, null, fValueOf, (Function0) objG2, composableLambdaE, composer2, 24576, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.r2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WeeklyInsightsActivity.h1(this.f104315a, weeklyInsightsViewState, paddingValues, mutableState, mutableState2, function1, snackbarHostState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d1(WeeklyInsightsActivity weeklyInsightsActivity, Context context, WeeklyInsightsViewState weeklyInsightsViewState) {
        weeklyInsightsActivity.S1(context, weeklyInsightsViewState);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(final SnackbarHostState snackbarHostState, final WeeklyInsightsActivity weeklyInsightsActivity, final WeeklyInsightsViewState weeklyInsightsViewState, final NavHostController navHostController, final MutableState mutableState, final MutableState mutableState2, final Function1 function1, final MutableFloatState mutableFloatState, BoxScope GradientBoxWithProgress, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBoxWithProgress, "$this$GradientBoxWithProgress");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-949323862, i3, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity.Content.<anonymous> (WeeklyInsightsActivity.kt:230)");
            }
            ScaffoldKt.a(null, null, null, null, ComposableLambdaKt.e(-1550443951, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.s2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return WeeklyInsightsActivity.f1(snackbarHostState, (androidx.compose.material.SnackbarHostState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, Color.f25715b.j(), 0L, ComposableLambdaKt.e(81247276, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.t2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return WeeklyInsightsActivity.g1(this.f104339a, weeklyInsightsViewState, navHostController, snackbarHostState, mutableState, mutableState2, function1, mutableFloatState, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 24576, 12779520, 98287);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(SnackbarHostState snackbarHostState, androidx.compose.material.SnackbarHostState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1550443951, i3, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity.Content.<anonymous>.<anonymous> (WeeklyInsightsActivity.kt:232)");
            }
            SnackbarHostKt.b(snackbarHostState, null, null, composer, 0, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1(WeeklyInsightsActivity weeklyInsightsActivity, WeeklyInsightsViewState weeklyInsightsViewState, NavHostController navHostController, SnackbarHostState snackbarHostState, MutableState mutableState, MutableState mutableState2, Function1 function1, MutableFloatState mutableFloatState, PaddingValues paddingValues, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(paddingValues) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(81247276, i4, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity.Content.<anonymous>.<anonymous> (WeeklyInsightsActivity.kt:234)");
            }
            Modifier modifierH = PaddingKt.h(SizeKt.f(Modifier.b8, 0.0f, 1, null), paddingValues);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            weeklyInsightsActivity.i1(weeklyInsightsViewState, navHostController, snackbarHostState, mutableState, mutableState2, function1, mutableFloatState, composer, 1572864);
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
    public static final Unit h1(WeeklyInsightsActivity weeklyInsightsActivity, WeeklyInsightsViewState weeklyInsightsViewState, PaddingValues paddingValues, MutableState mutableState, MutableState mutableState2, Function1 function1, SnackbarHostState snackbarHostState, int i3, Composer composer, int i4) {
        weeklyInsightsActivity.c1(weeklyInsightsViewState, paddingValues, mutableState, mutableState2, function1, snackbarHostState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void i1(final WeeklyInsightsViewState weeklyInsightsViewState, final NavHostController navHostController, final SnackbarHostState snackbarHostState, final MutableState mutableState, final MutableState mutableState2, final Function1 function1, final MutableFloatState mutableFloatState, Composer composer, final int i3) {
        int i4;
        MutableState mutableState3;
        MutableFloatState mutableFloatState2;
        Composer composer2;
        int i5;
        Composer composerK = composer.k(705779792);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(weeklyInsightsViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(navHostController) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(snackbarHostState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(mutableState) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            mutableState3 = mutableState2;
            i4 |= composerK.Z(mutableState3) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            mutableState3 = mutableState2;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(function1) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            mutableFloatState2 = mutableFloatState;
            i4 |= composerK.Z(mutableFloatState2) ? 1048576 : 524288;
        } else {
            mutableFloatState2 = mutableFloatState;
        }
        if ((i3 & 12582912) == 0) {
            i4 |= composerK.I(this) ? 8388608 : 4194304;
        }
        if (composerK.r((i4 & 4793491) != 4793490, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(705779792, i4, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity.NavigationHost (WeeklyInsightsActivity.kt:262)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Density density = (Density) composerK.q(CompositionLocalsKt.f());
            composerK.a0(-350436268);
            final float fM1 = density.M1(Dp.g(((Configuration) composerK.q(AndroidCompositionLocals_androidKt.f())).screenWidthDp));
            composerK.U();
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            int i6 = i4 & 458752;
            boolean z2 = i6 == 131072;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.h1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WeeklyInsightsActivity.j1(function1, (ActivityResult) obj);
                    }
                };
                composerK.w(objG);
            }
            final ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG, composerK, 0);
            ActivityResultContracts.StartActivityForResult startActivityForResult2 = new ActivityResultContracts.StartActivityForResult();
            boolean z3 = i6 == 131072;
            Object objG2 = composerK.G();
            if (z3 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.i1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WeeklyInsightsActivity.k1(function1, (ActivityResult) obj);
                    }
                };
                composerK.w(objG2);
            }
            final ManagedActivityResultLauncher managedActivityResultLauncherA2 = ActivityResultRegistryKt.a(startActivityForResult2, (Function1) objG2, composerK, 0);
            Modifier modifierF = SizeKt.f(Modifier.b8, 0.0f, 1, null);
            String route = Navigation.Intro.getRoute();
            boolean zI = (i6 == 131072) | ((i4 & 14) == 4) | composerK.I(navHostController) | composerK.c(fM1) | ((3670016 & i4) == 1048576) | composerK.I(this) | composerK.I(context) | ((i4 & 896) == 256) | ((i4 & 7168) == 2048) | ((57344 & i4) == 16384) | composerK.I(managedActivityResultLauncherA2) | composerK.I(managedActivityResultLauncherA);
            Object objG3 = composerK.G();
            if (zI || objG3 == Composer.f23746a.a()) {
                final MutableState mutableState4 = mutableState3;
                final MutableFloatState mutableFloatState3 = mutableFloatState2;
                i5 = i4;
                Function1 function12 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.j1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WeeklyInsightsActivity.l1(weeklyInsightsViewState, navHostController, fM1, mutableFloatState3, this, context, snackbarHostState, mutableState, mutableState4, function1, managedActivityResultLauncherA2, managedActivityResultLauncherA, (NavGraphBuilder) obj);
                    }
                };
                composerK.w(function12);
                objG3 = function12;
            } else {
                i5 = i4;
            }
            composer2 = composerK;
            NavHostKt.v(navHostController, route, modifierF, null, null, null, null, null, null, null, (Function1) objG3, composer2, ((i5 >> 3) & 14) | 432, 0, 1016);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.k1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WeeklyInsightsActivity.M1(this.f104194a, weeklyInsightsViewState, navHostController, snackbarHostState, mutableState, mutableState2, function1, mutableFloatState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j1(Function1 function1, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.d() == -1) {
            Intent intentC = it.c();
            Integer numValueOf = intentC != null ? Integer.valueOf(intentC.getIntExtra("PROFILE_TYPE_COMBINATIONS", -1)) : null;
            if (numValueOf != null && numValueOf.intValue() != -1) {
                function1.invoke(WeeklyInsightsViewEvent.OnContinuousUseScheduleCreated.f103910a);
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k1(Function1 function1, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.d() == -1) {
            Intent intentC = it.c();
            Integer numValueOf = intentC != null ? Integer.valueOf(intentC.getIntExtra("PROFILE_TYPE_COMBINATIONS", -1)) : null;
            if (numValueOf != null && numValueOf.intValue() != -1) {
                function1.invoke(WeeklyInsightsViewEvent.OnTypicalDayScheduleCreated.f103915a);
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l1(final WeeklyInsightsViewState weeklyInsightsViewState, final NavHostController navHostController, final float f3, final MutableFloatState mutableFloatState, final WeeklyInsightsActivity weeklyInsightsActivity, final Context context, final SnackbarHostState snackbarHostState, final MutableState mutableState, final MutableState mutableState2, final Function1 function1, final ManagedActivityResultLauncher managedActivityResultLauncher, final ManagedActivityResultLauncher managedActivityResultLauncher2, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        NavGraphBuilderKt.c(NavHost, Navigation.Intro.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1856258893, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.l1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return WeeklyInsightsActivity.m1(weeklyInsightsViewState, navHostController, f3, mutableFloatState, weeklyInsightsActivity, context, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, Navigation.AverageScreenTime.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-481430934, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.m1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return WeeklyInsightsActivity.o1(weeklyInsightsViewState, navHostController, f3, mutableFloatState, weeklyInsightsActivity, context, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, Navigation.Trend.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(1344204843, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.n1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return WeeklyInsightsActivity.r1(weeklyInsightsViewState, navHostController, f3, mutableFloatState, weeklyInsightsActivity, context, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, Navigation.TotalScreenTime.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1125126676, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.o1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return WeeklyInsightsActivity.u1(weeklyInsightsViewState, navHostController, f3, mutableFloatState, weeklyInsightsActivity, context, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, Navigation.Distractions.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(700509101, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.p1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return WeeklyInsightsActivity.w1(weeklyInsightsViewState, snackbarHostState, mutableState, mutableState2, function1, navHostController, f3, mutableFloatState, weeklyInsightsActivity, context, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, Navigation.TypicalDay.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1768822418, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.q1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return WeeklyInsightsActivity.z1(weeklyInsightsViewState, navHostController, f3, mutableFloatState, weeklyInsightsActivity, context, managedActivityResultLauncher, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, Navigation.ContinuousUse.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(56813359, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.s1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return WeeklyInsightsActivity.C1(weeklyInsightsViewState, navHostController, f3, mutableFloatState, weeklyInsightsActivity, context, managedActivityResultLauncher2, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, Navigation.BreakTheRules.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(1882449136, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.t1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return WeeklyInsightsActivity.F1(weeklyInsightsViewState, navHostController, f3, mutableFloatState, weeklyInsightsActivity, context, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, Navigation.Share.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-586882383, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.u1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return WeeklyInsightsActivity.H1(weeklyInsightsViewState, navHostController, f3, mutableFloatState, weeklyInsightsActivity, context, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, Navigation.Outro.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(1238753394, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.v1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return WeeklyInsightsActivity.K1(weeklyInsightsViewState, navHostController, f3, mutableFloatState, weeklyInsightsActivity, context, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m1(final WeeklyInsightsViewState weeklyInsightsViewState, final NavHostController navHostController, final float f3, final MutableFloatState mutableFloatState, final WeeklyInsightsActivity weeklyInsightsActivity, final Context context, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1856258893, i3, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (WeeklyInsightsActivity.kt:317)");
        }
        boolean zI = composer.I(navHostController) | composer.c(f3) | composer.Z(weeklyInsightsViewState) | composer.Z(mutableFloatState) | composer.I(weeklyInsightsActivity) | composer.I(context);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.j2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WeeklyInsightsActivity.n1(navHostController, f3, weeklyInsightsViewState, weeklyInsightsActivity, mutableFloatState, context, (Offset) obj);
                }
            };
            composer.w(function1);
            objG = function1;
        }
        WeeklyInsightsIntroScreenKt.d(weeklyInsightsViewState, (Function1) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n1(NavHostController navHostController, float f3, WeeklyInsightsViewState weeklyInsightsViewState, WeeklyInsightsActivity weeklyInsightsActivity, MutableFloatState mutableFloatState, Context context, Offset offset) {
        N1(navHostController, f3, weeklyInsightsViewState, weeklyInsightsActivity, mutableFloatState, context, offset.u());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o1(final WeeklyInsightsViewState weeklyInsightsViewState, final NavHostController navHostController, final float f3, final MutableFloatState mutableFloatState, final WeeklyInsightsActivity weeklyInsightsActivity, final Context context, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-481430934, i3, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (WeeklyInsightsActivity.kt:326)");
        }
        boolean zI = composer.I(navHostController) | composer.c(f3) | composer.Z(weeklyInsightsViewState) | composer.Z(mutableFloatState) | composer.I(weeklyInsightsActivity) | composer.I(context);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.d2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WeeklyInsightsActivity.p1(navHostController, f3, weeklyInsightsViewState, weeklyInsightsActivity, mutableFloatState, context, (Offset) obj);
                }
            };
            composer.w(function1);
            objG = function1;
        }
        Function1 function12 = (Function1) objG;
        boolean Z = composer.Z(weeklyInsightsViewState) | composer.I(context);
        Object objG2 = composer.G();
        if (Z || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.e2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return WeeklyInsightsActivity.q1(weeklyInsightsViewState, context);
                }
            };
            composer.w(objG2);
        }
        AverageScreenTimeScreenKt.d(weeklyInsightsViewState, function12, (Function0) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p1(NavHostController navHostController, float f3, WeeklyInsightsViewState weeklyInsightsViewState, WeeklyInsightsActivity weeklyInsightsActivity, MutableFloatState mutableFloatState, Context context, Offset offset) {
        N1(navHostController, f3, weeklyInsightsViewState, weeklyInsightsActivity, mutableFloatState, context, offset.u());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q1(WeeklyInsightsViewState weeklyInsightsViewState, Context context) {
        AnswersHelper.f128199a.B6("weekly_report_screen_time");
        context.startActivity(SocialsSharingActivity.f119356f.a(context, SocialsSharePayloadMappersKt.b(weeklyInsightsViewState)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r1(final WeeklyInsightsViewState weeklyInsightsViewState, final NavHostController navHostController, final float f3, final MutableFloatState mutableFloatState, final WeeklyInsightsActivity weeklyInsightsActivity, final Context context, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1344204843, i3, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (WeeklyInsightsActivity.kt:340)");
        }
        boolean zI = composer.I(navHostController) | composer.c(f3) | composer.Z(weeklyInsightsViewState) | composer.Z(mutableFloatState) | composer.I(weeklyInsightsActivity) | composer.I(context);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.h2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WeeklyInsightsActivity.s1(navHostController, f3, weeklyInsightsViewState, weeklyInsightsActivity, mutableFloatState, context, (Offset) obj);
                }
            };
            composer.w(function1);
            objG = function1;
        }
        Function1 function12 = (Function1) objG;
        boolean Z = composer.Z(weeklyInsightsViewState) | composer.I(context);
        Object objG2 = composer.G();
        if (Z || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.i2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return WeeklyInsightsActivity.t1(weeklyInsightsViewState, context);
                }
            };
            composer.w(objG2);
        }
        TrendScreenKt.c(weeklyInsightsViewState, function12, (Function0) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s1(NavHostController navHostController, float f3, WeeklyInsightsViewState weeklyInsightsViewState, WeeklyInsightsActivity weeklyInsightsActivity, MutableFloatState mutableFloatState, Context context, Offset offset) {
        N1(navHostController, f3, weeklyInsightsViewState, weeklyInsightsActivity, mutableFloatState, context, offset.u());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t1(WeeklyInsightsViewState weeklyInsightsViewState, Context context) {
        AnswersHelper.f128199a.B6("weekly_report_trend");
        context.startActivity(SocialsSharingActivity.f119356f.a(context, SocialsSharePayloadMappersKt.d(weeklyInsightsViewState)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u1(final WeeklyInsightsViewState weeklyInsightsViewState, final NavHostController navHostController, final float f3, final MutableFloatState mutableFloatState, final WeeklyInsightsActivity weeklyInsightsActivity, final Context context, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1125126676, i3, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (WeeklyInsightsActivity.kt:354)");
        }
        boolean zI = composer.I(navHostController) | composer.c(f3) | composer.Z(weeklyInsightsViewState) | composer.Z(mutableFloatState) | composer.I(weeklyInsightsActivity) | composer.I(context);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.m2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WeeklyInsightsActivity.v1(navHostController, f3, weeklyInsightsViewState, weeklyInsightsActivity, mutableFloatState, context, (Offset) obj);
                }
            };
            composer.w(function1);
            objG = function1;
        }
        TotalScreenTimeScreenKt.c(weeklyInsightsViewState, (Function1) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v1(NavHostController navHostController, float f3, WeeklyInsightsViewState weeklyInsightsViewState, WeeklyInsightsActivity weeklyInsightsActivity, MutableFloatState mutableFloatState, Context context, Offset offset) {
        N1(navHostController, f3, weeklyInsightsViewState, weeklyInsightsActivity, mutableFloatState, context, offset.u());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w1(final WeeklyInsightsViewState weeklyInsightsViewState, SnackbarHostState snackbarHostState, MutableState mutableState, MutableState mutableState2, Function1 function1, final NavHostController navHostController, final float f3, final MutableFloatState mutableFloatState, final WeeklyInsightsActivity weeklyInsightsActivity, final Context context, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(700509101, i3, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (WeeklyInsightsActivity.kt:363)");
        }
        boolean zI = composer.I(navHostController) | composer.c(f3) | composer.Z(weeklyInsightsViewState) | composer.Z(mutableFloatState) | composer.I(weeklyInsightsActivity) | composer.I(context);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            Function1 function12 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.z1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WeeklyInsightsActivity.x1(navHostController, f3, weeklyInsightsViewState, weeklyInsightsActivity, mutableFloatState, context, (Offset) obj);
                }
            };
            composer.w(function12);
            objG = function12;
        }
        Function1 function13 = (Function1) objG;
        boolean zI2 = composer.I(context);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.a2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WeeklyInsightsActivity.y1(context, ((Boolean) obj).booleanValue());
                }
            };
            composer.w(objG2);
        }
        DistractionsScreenKt.o(weeklyInsightsViewState, snackbarHostState, mutableState, mutableState2, function1, function13, (Function1) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x1(NavHostController navHostController, float f3, WeeklyInsightsViewState weeklyInsightsViewState, WeeklyInsightsActivity weeklyInsightsActivity, MutableFloatState mutableFloatState, Context context, Offset offset) {
        N1(navHostController, f3, weeklyInsightsViewState, weeklyInsightsActivity, mutableFloatState, context, offset.u());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y1(Context context, boolean z2) {
        context.startActivity(Paywall.c(Paywall.f113165a, context, new PaywallTarget.LimitScreen(z2 ? PremiumFeature.QUICK_BLOCK_APPS_UNLIMITED : PremiumFeature.PROFILES_APPS_UNLIMITED), "weekly_insights", "unlimited_apps", false, false, false, null, 240, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z1(final WeeklyInsightsViewState weeklyInsightsViewState, final NavHostController navHostController, final float f3, final MutableFloatState mutableFloatState, final WeeklyInsightsActivity weeklyInsightsActivity, final Context context, final ManagedActivityResultLauncher managedActivityResultLauncher, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1768822418, i3, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (WeeklyInsightsActivity.kt:386)");
        }
        boolean zI = composer.I(navHostController) | composer.c(f3) | composer.Z(weeklyInsightsViewState) | composer.Z(mutableFloatState) | composer.I(weeklyInsightsActivity) | composer.I(context);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.f2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WeeklyInsightsActivity.A1(navHostController, f3, weeklyInsightsViewState, weeklyInsightsActivity, mutableFloatState, context, (Offset) obj);
                }
            };
            composer.w(function1);
            objG = function1;
        }
        Function1 function12 = (Function1) objG;
        boolean zI2 = composer.I(context) | composer.Z(weeklyInsightsViewState) | composer.I(managedActivityResultLauncher);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.g2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return WeeklyInsightsActivity.B1(context, weeklyInsightsViewState, managedActivityResultLauncher);
                }
            };
            composer.w(objG2);
        }
        TypicalDayScreenKt.d(weeklyInsightsViewState, function12, (Function0) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    protected boolean f0() {
        return this.f103886f;
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
        final WeeklyInsightsActivity weeklyInsightsActivity;
        Bundle bundleB;
        final WeeklyInsightsActivity weeklyInsightsActivity2 = this;
        Intrinsics.checkNotNullParameter(paddingValues, wgbAZXYjrv.heCCHIE);
        Composer composerK = composer.k(-1970263676);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(weeklyInsightsActivity2) ? 32 : 16;
        }
        int i5 = i4;
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1970263676, i5, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsActivity.RootCompose (WeeklyInsightsActivity.kt:75)");
            }
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
            KClass kClassB = Reflection.b(WeeklyInsightsViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            WeeklyInsightsViewModel weeklyInsightsViewModel = (WeeklyInsightsViewModel) viewModelA;
            WeeklyInsightsViewState weeklyInsightsViewState = (WeeklyInsightsViewState) FlowExtKt.m(weeklyInsightsViewModel, composerK, 0);
            Function1 function1N = FlowExtKt.n(weeklyInsightsViewModel, composerK, 0);
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            MutableState mutableState = (MutableState) objG;
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
            MutableState mutableState3 = (MutableState) objG3;
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = new SnackbarHostState();
                composerK.w(objG4);
            }
            SnackbarHostState snackbarHostState = (SnackbarHostState) objG4;
            Object objG5 = composerK.G();
            if (objG5 == companion.a()) {
                objG5 = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG5);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objG5;
            boolean zI = composerK.I(weeklyInsightsActivity2);
            Object objG6 = composerK.G();
            if (zI || objG6 == companion.a()) {
                objG6 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.g1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WeeklyInsightsActivity.O1(this.f104138a, (List) obj);
                    }
                };
                composerK.w(objG6);
            }
            Function1 function1 = (Function1) objG6;
            boolean zI2 = composerK.I(weeklyInsightsActivity2);
            Object objG7 = composerK.G();
            if (zI2 || objG7 == companion.a()) {
                objG7 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.r1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return WeeklyInsightsActivity.P1(this.f104314a);
                    }
                };
                composerK.w(objG7);
            }
            Composer composer3 = composerK;
            weeklyInsightsActivity2.Z0(weeklyInsightsViewModel, mutableState2, mutableState, snackbarHostState, coroutineScope, function1, mutableState3, (Function0) objG7, composer3, ((i5 << 21) & 234881024) | 1576368, 0);
            WeeklyInsightsActivity weeklyInsightsActivity3 = this;
            weeklyInsightsActivity3.c1(weeklyInsightsViewState, paddingValues, mutableState2, mutableState, function1N, snackbarHostState, composer3, ((i5 << 3) & 112) | 200064 | ((i5 << 15) & 3670016));
            weeklyInsightsActivity = weeklyInsightsActivity3;
            composer2 = composer3;
            if (ComposerKt.M()) {
                ComposerKt.T();
                weeklyInsightsActivity = weeklyInsightsActivity3;
                composer2 = composer3;
            }
        } else {
            Composer composer4 = composerK;
            composer4.Q();
            weeklyInsightsActivity = weeklyInsightsActivity2;
            composer2 = composer4;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.c2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WeeklyInsightsActivity.Q1(this.f104079a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
