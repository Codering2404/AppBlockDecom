package cz.mobilesoft.coreblock.scene.strictmode3.access;

import android.os.Bundle;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
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
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.scene.password.PassCodeType;
import cz.mobilesoft.coreblock.scene.strictmode.passcode.StrictModePassCodeScreenKt;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessViewEvent;
import cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectScreenKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerConfig;
import cz.mobilesoft.coreblock.view.timeselector.TimeSelectScreenKt;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StrictModeAccessActivityKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(MutableState mutableState, MutableState mutableState2, StrictModeAccessMethod accessMethod) {
        Intrinsics.checkNotNullParameter(accessMethod, "accessMethod");
        mutableState.setValue(Boolean.TRUE);
        if (accessMethod != mutableState2.getValue()) {
            mutableState2.setValue(accessMethod);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(Function2 function2, Function0 function0, int i3, Composer composer, int i4) {
        w(function2, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void D(NavGraphBuilder navGraphBuilder, final NavController navController, final StrictModeAccessViewState strictModeAccessViewState, final Function0 function0, final Function1 function1) {
        NavGraphBuilderKt.c(navGraphBuilder, AccessNavigation.Selection.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(1876637167, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.y
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return StrictModeAccessActivityKt.E(strictModeAccessViewState, function1, function0, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(navGraphBuilder, AccessNavigation.PinCode.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(357655270, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.z
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return StrictModeAccessActivityKt.G(function1, navController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(navGraphBuilder, AccessNavigation.Timer.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1728187545, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.a0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return StrictModeAccessActivityKt.J(function1, navController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(navGraphBuilder, AccessNavigation.Cooldown.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(480936936, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.b0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return StrictModeAccessActivityKt.M(function1, navController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(navGraphBuilder, AccessNavigation.FollowSchedules.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1604905879, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.c0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return StrictModeAccessActivityKt.P(strictModeAccessViewState, function1, navController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(StrictModeAccessViewState strictModeAccessViewState, Function1 function1, final Function0 function0, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1876637167, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.access.accessNavigation.<anonymous> (StrictModeAccessActivity.kt:155)");
        }
        boolean Z = composer.Z(function0);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.n
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StrictModeAccessActivityKt.F(function0);
                }
            };
            composer.w(objG);
        }
        StrictModeAccessScreenKt.X(strictModeAccessViewState, function1, (Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(final Function1 function1, final NavController navController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(357655270, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.access.accessNavigation.<anonymous> (StrictModeAccessActivity.kt:167)");
        }
        PassCodeType passCodeType = PassCodeType.Create;
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.l
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StrictModeAccessActivityKt.H(function1, (String) obj);
                }
            };
            composer.w(objG);
        }
        Function1 function12 = (Function1) objG;
        boolean zI = composer.I(navController);
        Object objG2 = composer.G();
        if (zI || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.m
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StrictModeAccessActivityKt.I(navController);
                }
            };
            composer.w(objG2);
        }
        StrictModePassCodeScreenKt.g(passCodeType, function12, (Function0) objG2, composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new StrictModeAccessViewEvent.OnPinConfirmed(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(NavController navController) {
        navController.Q();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(final Function1 function1, final NavController navController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1728187545, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.access.accessNavigation.<anonymous> (StrictModeAccessActivity.kt:181)");
        }
        TimePickerConfig timePickerConfig = new TimePickerConfig(new TimePickerConfig.TimePickerType.Minutes(0L, 0L, 3, null), new TimePickerConfig.TimePickerType.Hours(0L, 0L, 3, null), new TimePickerConfig.TimePickerType.Days(0L, 99L), false, null, false, 56, null);
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.q
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StrictModeAccessActivityKt.K(function1, ((Long) obj).longValue());
                }
            };
            composer.w(objG);
        }
        Function1 function12 = (Function1) objG;
        boolean zI = composer.I(navController);
        Object objG2 = composer.G();
        if (zI || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.r
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StrictModeAccessActivityKt.L(navController);
                }
            };
            composer.w(objG2);
        }
        TimeSelectScreenKt.E(function12, (Function0) objG2, timePickerConfig, 0L, null, true, composer, 196608, 24);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(Function1 function1, long j3) {
        function1.invoke(new StrictModeAccessViewEvent.OnTimerSet(j3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(NavController navController) {
        navController.Q();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(final Function1 function1, final NavController navController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(480936936, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.access.accessNavigation.<anonymous> (StrictModeAccessActivity.kt:200)");
        }
        TimePickerConfig timePickerConfigA = TimePickerConfig.f133036h.a();
        long millis = TimeUnit.MINUTES.toMillis(3L);
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.o
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StrictModeAccessActivityKt.N(function1, ((Long) obj).longValue());
                }
            };
            composer.w(objG);
        }
        Function1 function12 = (Function1) objG;
        boolean zI = composer.I(navController);
        Object objG2 = composer.G();
        if (zI || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.p
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StrictModeAccessActivityKt.O(navController);
                }
            };
            composer.w(objG2);
        }
        TimeSelectScreenKt.E(function12, (Function0) objG2, timePickerConfigA, millis, null, false, composer, 0, 48);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(Function1 function1, long j3) {
        function1.invoke(new StrictModeAccessViewEvent.OnCooldownSet(j3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(NavController navController) {
        navController.Q();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(StrictModeAccessViewState strictModeAccessViewState, final Function1 function1, final NavController navController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1604905879, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.access.accessNavigation.<anonymous> (StrictModeAccessActivity.kt:215)");
        }
        StrictModeAccessMethod strictModeAccessMethodC = strictModeAccessViewState.c();
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeAccessActivityKt.Q(function1, (long[]) obj, (AccessMethodConfiguration.Schedules.SchedulesBlockingMode) obj2);
                }
            };
            composer.w(objG);
        }
        Function2 function2 = (Function2) objG;
        boolean zI = composer.I(navController);
        Object objG2 = composer.G();
        if (zI || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.t
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StrictModeAccessActivityKt.R(navController);
                }
            };
            composer.w(objG2);
        }
        ScheduleSelectScreenKt.P(strictModeAccessMethodC, null, false, function2, (Function0) objG2, composer, 0, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(Function1 function1, long[] profileIds, AccessMethodConfiguration.Schedules.SchedulesBlockingMode blockingMode) {
        Intrinsics.checkNotNullParameter(profileIds, "profileIds");
        Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
        function1.invoke(new StrictModeAccessViewEvent.OnSchedulesSet(profileIds, blockingMode));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(NavController navController) {
        navController.Q();
        return Unit.f139807a;
    }

    public static final void u(final NavController navController, StrictModeAccessViewModel viewModel, final Function2 onAccessMethodConfirmed, final Function1 onTimerMethodSelected, Composer composer, final int i3) {
        int i4;
        StrictModeAccessViewModel strictModeAccessViewModel;
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onAccessMethodConfirmed, "onAccessMethodConfirmed");
        Intrinsics.checkNotNullParameter(onTimerMethodSelected, "onTimerMethodSelected");
        Composer composerK = composer.k(-1847073268);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(navController) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(viewModel) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onAccessMethodConfirmed) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onTimerMethodSelected) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1847073268, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.access.CommandProcessor (StrictModeAccessActivity.kt:126)");
            }
            boolean zI = composerK.I(navController) | ((i4 & 7168) == 2048) | ((i4 & 896) == 256);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new StrictModeAccessActivityKt$CommandProcessor$1$1(navController, onTimerMethodSelected, onAccessMethodConfirmed, null);
                composerK.w(objG);
            }
            strictModeAccessViewModel = viewModel;
            FlowExtKt.g(strictModeAccessViewModel, null, (Function2) objG, composerK, (i4 >> 3) & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            strictModeAccessViewModel = viewModel;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final StrictModeAccessViewModel strictModeAccessViewModel2 = strictModeAccessViewModel;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeAccessActivityKt.v(navController, strictModeAccessViewModel2, onAccessMethodConfirmed, onTimerMethodSelected, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(NavController navController, StrictModeAccessViewModel strictModeAccessViewModel, Function2 function2, Function1 function1, int i3, Composer composer, int i4) {
        u(navController, strictModeAccessViewModel, function2, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(final Function2 function2, final Function0 function0, Composer composer, final int i3) {
        int i4;
        String strB;
        Bundle bundleB;
        Composer composerK = composer.k(1557638930);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function0) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1557638930, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.access.Content (StrictModeAccessActivity.kt:60)");
            }
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
            KClass kClassB = Reflection.b(StrictModeAccessViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            StrictModeAccessViewModel strictModeAccessViewModel = (StrictModeAccessViewModel) viewModelA;
            final StrictModeAccessViewState strictModeAccessViewState = (StrictModeAccessViewState) FlowExtKt.m(strictModeAccessViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(strictModeAccessViewModel, composerK, 0);
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(StrictModeAccessMethod.Timer, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG2);
            }
            final MutableState mutableState2 = (MutableState) objG2;
            int i5 = i4 & 112;
            boolean zI = composerK.I(navHostControllerB) | (i5 == 32);
            Object objG3 = composerK.G();
            if (zI || objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeAccessActivityKt.x(navHostControllerB, function0);
                    }
                };
                composerK.w(objG3);
            }
            BackHandlerKt.a(false, (Function0) objG3, composerK, 0, 1);
            String route = AccessNavigation.Selection.getRoute();
            boolean zI2 = composerK.I(navHostControllerB) | composerK.Z(strictModeAccessViewState) | (i5 == 32) | composerK.Z(function1N);
            Object objG4 = composerK.G();
            if (zI2 || objG4 == companion.a()) {
                objG4 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.u
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictModeAccessActivityKt.y(navHostControllerB, strictModeAccessViewState, function0, function1N, (NavGraphBuilder) obj);
                    }
                };
                composerK.w(objG4);
            }
            NavHostKt.v(navHostControllerB, route, null, null, null, null, null, null, null, null, (Function1) objG4, composerK, 48, 0, 1020);
            composerK = composerK;
            if (mutableState.getValue() == StrictModeAccessMethod.Timer) {
                composerK.a0(796211502);
                strB = StringResources_androidKt.b(R.string.Zv, composerK, 0);
                composerK.U();
            } else {
                composerK.a0(796283298);
                strB = StringResources_androidKt.b(R.string.Hz, composerK, 0);
                composerK.U();
            }
            String str = strB;
            boolean Z = composerK.Z(function1N);
            Object objG5 = composerK.G();
            if (Z || objG5 == companion.a()) {
                objG5 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.v
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictModeAccessActivityKt.z(mutableState, function1N, ((Long) obj).longValue());
                    }
                };
                composerK.w(objG5);
            }
            StrictModeTimerBottomSheetKt.m(str, mutableState2, mutableState, (Function1) objG5, composerK, 432, 0);
            Object objG6 = composerK.G();
            if (objG6 == companion.a()) {
                objG6 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.w
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictModeAccessActivityKt.A(mutableState2, mutableState, (StrictModeAccessMethod) obj);
                    }
                };
                composerK.w(objG6);
            }
            u(navHostControllerB, strictModeAccessViewModel, function2, (Function1) objG6, composerK, ((i4 << 6) & 896) | 3072);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeAccessActivityKt.B(function2, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(NavHostController navHostController, Function0 function0) {
        NavDestination navDestinationD;
        NavBackStackEntry navBackStackEntryT = navHostController.t();
        if (Intrinsics.areEqual((navBackStackEntryT == null || (navDestinationD = navBackStackEntryT.d()) == null) ? null : navDestinationD.t(), AccessNavigation.Selection.getRoute())) {
            function0.invoke();
        } else {
            navHostController.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(NavHostController navHostController, StrictModeAccessViewState strictModeAccessViewState, Function0 function0, Function1 function1, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        D(NavHost, navHostController, strictModeAccessViewState, function0, function1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(MutableState mutableState, Function1 function1, long j3) {
        if (mutableState.getValue() == StrictModeAccessMethod.Timer) {
            function1.invoke(new StrictModeAccessViewEvent.OnTimerSet(j3));
        } else {
            function1.invoke(new StrictModeAccessViewEvent.OnCooldownSet(j3));
        }
        return Unit.f139807a;
    }
}
