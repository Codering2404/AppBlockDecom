package cz.mobilesoft.coreblock.scene.intro.schedule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.BackHandlerKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO;
import cz.mobilesoft.coreblock.scene.intro.schedule.IntroScheduleViewEvent;
import cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroActivity;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.view.AppIconCache;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class IntroScheduleActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f104813g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f104814h = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f104815f = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.schedule.l
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Boolean.valueOf(IntroScheduleActivity.R0(this.f104852a));
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent b(Companion companion, Context context, boolean z2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                z2 = false;
            }
            return companion.a(context, z2);
        }

        public final Intent a(Context context, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) IntroScheduleActivity.class);
            intent.putExtra("QUICK_BLOCK_SKIPPED", z2);
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
        public static final NavItem GoodJob = new NavItem("GoodJob", 0, "good_job");
        public static final NavItem ScheduleIntro = new NavItem("ScheduleIntro", 1, "schedule_intro");
        public static final NavItem ScheduleReady = new NavItem("ScheduleReady", 2, "schedule_ready");
        private final String route;

        private static final /* synthetic */ NavItem[] $values() {
            return new NavItem[]{GoodJob, ScheduleIntro, ScheduleReady};
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
        public static final /* synthetic */ int[] f104816a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f104816a = iArr;
        }
    }

    private final void A0(final ScaffoldState scaffoldState, final NavHostController navHostController, final NavItem navItem, final AppIconCache appIconCache, final IntroScheduleViewState introScheduleViewState, final PaddingValues paddingValues, final Function1 function1, final Function0 function0, Composer composer, final int i3) {
        int i4;
        IntroScheduleViewState introScheduleViewState2;
        Function0 function02;
        Object obj;
        int i5;
        Composer composerK = composer.k(-1883359483);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(scaffoldState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(navHostController) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.e(navItem.ordinal()) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(appIconCache) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            introScheduleViewState2 = introScheduleViewState;
            i4 |= composerK.Z(introScheduleViewState2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            introScheduleViewState2 = introScheduleViewState;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.Z(paddingValues) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.I(function1) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            function02 = function0;
            i4 |= composerK.I(function02) ? 8388608 : 4194304;
        } else {
            function02 = function0;
        }
        if (composerK.r((i4 & 4793491) != 4793490, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1883359483, i4, -1, "cz.mobilesoft.coreblock.scene.intro.schedule.IntroScheduleActivity.NavigationHost (IntroScheduleActivity.kt:115)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            boolean zI = ((3670016 & i4) == 1048576) | composerK.I(navHostController);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.schedule.w
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return IntroScheduleActivity.B0(function1, navHostController, (ActivityResult) obj2);
                    }
                };
                composerK.w(objG);
            }
            final ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG, composerK, 0);
            Modifier modifierH = PaddingKt.h(Modifier.b8, paddingValues);
            String route = navItem.getRoute();
            boolean zI2 = composerK.I(navHostController) | composerK.I(managedActivityResultLauncherA) | composerK.I(context) | ((i4 & 29360128) == 8388608) | ((57344 & i4) == 16384) | ((i4 & 14) == 4) | ((i4 & 7168) == 2048);
            Object objG2 = composerK.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                i5 = i4;
                final IntroScheduleViewState introScheduleViewState3 = introScheduleViewState2;
                final Function0 function03 = function02;
                obj = new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.schedule.x
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return IntroScheduleActivity.C0(navHostController, managedActivityResultLauncherA, context, function03, introScheduleViewState3, scaffoldState, appIconCache, (NavGraphBuilder) obj2);
                    }
                };
                composerK.w(obj);
            } else {
                obj = objG2;
                i5 = i4;
            }
            NavHostKt.v(navHostController, route, modifierH, null, null, null, null, null, null, null, (Function1) obj, composerK, (i5 >> 3) & 14, 0, 1016);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.schedule.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return IntroScheduleActivity.J0(this.f104893a, scaffoldState, navHostController, navItem, appIconCache, introScheduleViewState, paddingValues, function1, function0, i3, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(Function1 function1, NavHostController navHostController, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.d() == -1) {
            Intent intentC = it.c();
            long longExtra = intentC != null ? intentC.getLongExtra("PROFILE_ID", -1L) : -1L;
            Intent intentC2 = it.c();
            int intExtra = intentC2 != null ? intentC2.getIntExtra("PROFILE_TYPE_COMBINATIONS", 0) : 0;
            if (longExtra != -1) {
                function1.invoke(new IntroScheduleViewEvent.OnScheduleCreated(longExtra, intExtra));
                NavController.P(navHostController, NavItem.ScheduleReady.getRoute(), null, null, 6, null);
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(final NavHostController navHostController, final ManagedActivityResultLauncher managedActivityResultLauncher, final Context context, final Function0 function0, final IntroScheduleViewState introScheduleViewState, final ScaffoldState scaffoldState, final AppIconCache appIconCache, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        NavGraphBuilderKt.c(NavHost, NavItem.GoodJob.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-606950398, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.schedule.z
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return IntroScheduleActivity.D0(navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, NavItem.ScheduleIntro.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-2004130261, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.schedule.m
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return IntroScheduleActivity.F0(managedActivityResultLauncher, context, function0, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, NavItem.ScheduleReady.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1290932342, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.schedule.n
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return IntroScheduleActivity.H0(introScheduleViewState, scaffoldState, appIconCache, managedActivityResultLauncher, context, function0, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-606950398, i3, -1, "cz.mobilesoft.coreblock.scene.intro.schedule.IntroScheduleActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (IntroScheduleActivity.kt:135)");
        }
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.schedule.q
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return IntroScheduleActivity.E0(navHostController);
                }
            };
            composer.w(objG);
        }
        GoodJobScreenKt.d((Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(NavHostController navHostController) {
        NavController.P(navHostController, NavItem.ScheduleIntro.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(final ManagedActivityResultLauncher managedActivityResultLauncher, final Context context, Function0 function0, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-2004130261, i3, -1, "cz.mobilesoft.coreblock.scene.intro.schedule.IntroScheduleActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (IntroScheduleActivity.kt:142)");
        }
        boolean zI = composer.I(managedActivityResultLauncher) | composer.I(context);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.schedule.p
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return IntroScheduleActivity.G0(managedActivityResultLauncher, context);
                }
            };
            composer.w(objG);
        }
        ScheduleAboutSceenKt.c((Function0) objG, function0, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(ManagedActivityResultLauncher managedActivityResultLauncher, Context context) {
        managedActivityResultLauncher.b(ScheduleActivity.Companion.b(ScheduleActivity.f114377m, context, null, false, false, 14, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(final IntroScheduleViewState introScheduleViewState, ScaffoldState scaffoldState, AppIconCache appIconCache, final ManagedActivityResultLauncher managedActivityResultLauncher, final Context context, Function0 function0, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1290932342, i3, -1, "cz.mobilesoft.coreblock.scene.intro.schedule.IntroScheduleActivity.NavigationHost.<anonymous>.<anonymous>.<anonymous> (IntroScheduleActivity.kt:151)");
        }
        ProfileViewDTO profileViewDTOB = introScheduleViewState.b();
        boolean Z = composer.Z(introScheduleViewState) | composer.I(managedActivityResultLauncher) | composer.I(context);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.schedule.o
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return IntroScheduleActivity.I0(introScheduleViewState, managedActivityResultLauncher, context);
                }
            };
            composer.w(objG);
        }
        ScheduleReadyScreenKt.f(scaffoldState, appIconCache, profileViewDTOB, (Function0) objG, function0, composer, 0, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(IntroScheduleViewState introScheduleViewState, ManagedActivityResultLauncher managedActivityResultLauncher, Context context) {
        if (introScheduleViewState.b() != null) {
            managedActivityResultLauncher.b(ScheduleActivity.Companion.b(ScheduleActivity.f114377m, context, new ScheduleDescriptor.ScheduleId(introScheduleViewState.b().k(), introScheduleViewState.b().x()), false, false, 12, null));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(IntroScheduleActivity introScheduleActivity, ScaffoldState scaffoldState, NavHostController navHostController, NavItem navItem, AppIconCache appIconCache, IntroScheduleViewState introScheduleViewState, PaddingValues paddingValues, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        introScheduleActivity.A0(scaffoldState, navHostController, navItem, appIconCache, introScheduleViewState, paddingValues, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(IntroScheduleActivity introScheduleActivity, IntroScheduleViewState introScheduleViewState) {
        introScheduleActivity.P0(introScheduleViewState.c());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(IntroScheduleActivity introScheduleActivity, IntroScheduleViewState introScheduleViewState) {
        introScheduleActivity.P0(introScheduleViewState.c());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(IntroScheduleActivity introScheduleActivity, ScaffoldState scaffoldState, NavHostController navHostController, NavItem navItem, IntroScheduleViewModel introScheduleViewModel, IntroScheduleViewState introScheduleViewState, Function1 function1, Function0 function0, PaddingValues it, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(it) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1881309171, i4, -1, "cz.mobilesoft.coreblock.scene.intro.schedule.IntroScheduleActivity.RootCompose.<anonymous> (IntroScheduleActivity.kt:82)");
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
            introScheduleActivity.A0(scaffoldState, navHostController, navItem, introScheduleViewModel.W0(), introScheduleViewState, it, function1, function0, composer, (i4 << 15) & 458752);
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
    public static final Unit N0(Function1 function1, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(event, "event");
        if (WhenMappings.f104816a[event.ordinal()] == 1) {
            function1.invoke(IntroScheduleViewEvent.OnResume.f104823a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(IntroScheduleActivity introScheduleActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        introScheduleActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void P0(Integer num) {
        if (Q0() && num == null) {
            CoroutinesHelperExtKt.e(this, new IntroScheduleActivity$close$1(this, null));
        } else {
            startActivity(StrictModeIntroActivity.Companion.b(StrictModeIntroActivity.f105009i, this, num, null, false, 12, null));
        }
    }

    private final boolean Q0() {
        return ((Boolean) this.f104815f.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean R0(IntroScheduleActivity introScheduleActivity) {
        return introScheduleActivity.getIntent().getBooleanExtra("QUICK_BLOCK_SKIPPED", false);
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(-2146625457);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2146625457, i4, -1, "cz.mobilesoft.coreblock.scene.intro.schedule.IntroScheduleActivity.RootCompose (IntroScheduleActivity.kt:55)");
            }
            final ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composerK, 0, 3);
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
            KClass kClassB = Reflection.b(IntroScheduleViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            final IntroScheduleViewModel introScheduleViewModel = (IntroScheduleViewModel) viewModelA;
            final IntroScheduleViewState introScheduleViewState = (IntroScheduleViewState) FlowExtKt.m(introScheduleViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(introScheduleViewModel, composerK, 0);
            final NavHostController navHostControllerB = NavHostControllerKt.b(new Navigator[0], composerK, 0);
            final NavItem navItem = Q0() ? NavItem.ScheduleIntro : NavItem.GoodJob;
            boolean zI = composerK.I(this) | composerK.Z(introScheduleViewState);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.schedule.r
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return IntroScheduleActivity.K0(this.f104868a, introScheduleViewState);
                    }
                };
                composerK.w(objG);
            }
            BackHandlerKt.a(false, (Function0) objG, composerK, 0, 1);
            boolean Z = composerK.Z(introScheduleViewState.c());
            Object objG2 = composerK.G();
            if (Z || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.schedule.s
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return IntroScheduleActivity.L0(this.f104870a, introScheduleViewState);
                    }
                };
                composerK.w(objG2);
            }
            final Function0 function0 = (Function0) objG2;
            ScaffoldKt.a(null, scaffoldStateG, null, null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(-1881309171, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.schedule.t
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return IntroScheduleActivity.M0(this.f104872a, scaffoldStateG, navHostControllerB, navItem, introScheduleViewModel, introScheduleViewState, function1N, function0, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 0, 12582912, 131069);
            composer2 = composerK;
            boolean Z2 = composer2.Z(function1N);
            Object objG3 = composer2.G();
            if (Z2 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.schedule.u
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return IntroScheduleActivity.N0(function1N, (LifecycleOwner) obj, (Lifecycle.Event) obj2);
                    }
                };
                composer2.w(objG3);
            }
            ComposableExtKt.j(null, (Function2) objG3, composer2, 0, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.schedule.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IntroScheduleActivity.O0(this.f104881a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
