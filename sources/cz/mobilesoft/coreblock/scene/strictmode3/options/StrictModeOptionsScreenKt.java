package cz.mobilesoft.coreblock.scene.strictmode3.options;

import android.content.Context;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
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
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.enums.StrictModeOption;
import cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsViewEvent;
import cz.mobilesoft.coreblock.scene.strictmode3.options.confirm_blocking.StrictModeHeadsUpBlockingScreenKt;
import cz.mobilesoft.coreblock.scene.strictmode3.options.select_options.StrictModeSelectOptionsScreenKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.view.compose.ActivityLauncher;
import cz.mobilesoft.coreblock.view.compose.ComposeCommonsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
public final class StrictModeOptionsScreenKt {
    private static final void j(StrictModeOptionsViewModel strictModeOptionsViewModel, final Function1 function1, final Function1 function12, Composer composer, final int i3) {
        int i4;
        final StrictModeOptionsViewModel strictModeOptionsViewModel2;
        Composer composerK = composer.k(518136483);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(strictModeOptionsViewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function12) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(518136483, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.options.CommandProcessor (StrictModeOptionsScreen.kt:87)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            StrictModeOption strictModeOption = StrictModeOption.BlockEditing;
            boolean z2 = (i4 & 896) == 256;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.options.h
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return StrictModeOptionsScreenKt.k(function12, (ActivityResult) obj, (StrictModeOption) obj2);
                    }
                };
                composerK.w(objG);
            }
            ActivityLauncher activityLauncherP = ComposeCommonsKt.p(strictModeOption, (Function2) objG, composerK, 6);
            boolean zI = composerK.I(context) | composerK.I(activityLauncherP) | ((i4 & 112) == 32);
            Object objG2 = composerK.G();
            if (zI || objG2 == Composer.f23746a.a()) {
                objG2 = new StrictModeOptionsScreenKt$CommandProcessor$1$1(context, activityLauncherP, function1, null);
                composerK.w(objG2);
            }
            strictModeOptionsViewModel2 = strictModeOptionsViewModel;
            FlowExtKt.g(strictModeOptionsViewModel2, null, (Function2) objG2, composerK, i4 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            strictModeOptionsViewModel2 = strictModeOptionsViewModel;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.options.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeOptionsScreenKt.l(strictModeOptionsViewModel2, function1, function12, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Function1 function1, ActivityResult result, StrictModeOption value) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(value, "value");
        if (result.d() == -1) {
            function1.invoke(new StrictModeOptionsViewEvent.OnMissingPermissionsGranted(value));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(StrictModeOptionsViewModel strictModeOptionsViewModel, Function1 function1, Function1 function12, int i3, Composer composer, int i4) {
        j(strictModeOptionsViewModel, function1, function12, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void m(boolean z2, final Function1 onCloseClicked, Composer composer, final int i3, final int i4) {
        final boolean z3;
        int i5;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Composer composerK = composer.k(-2140991771);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            z3 = z2;
        } else if ((i3 & 6) == 0) {
            z3 = z2;
            i5 = (composerK.b(z3) ? 4 : 2) | i3;
        } else {
            z3 = z2;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.I(onCloseClicked) ? 32 : 16;
        }
        int i7 = i5;
        if (composerK.r((i7 & 19) != 18, i7 & 1)) {
            final boolean z4 = i6 != 0 ? false : z3;
            if (ComposerKt.M()) {
                ComposerKt.U(-2140991771, i7, -1, "cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsScreen (StrictModeOptionsScreen.kt:35)");
            }
            composerK.F(-101221098);
            ViewModelStoreOwner viewModelStoreOwnerC = LocalViewModelStoreOwner.f40240a.c(composerK, 8);
            if (viewModelStoreOwnerC == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            CreationExtras creationExtrasA = ViewModelComposeExtKt.a(viewModelStoreOwnerC, composerK, 8);
            Scope scopeD = GlobalContext.f145907a.get().j().d();
            composerK.F(-1072256281);
            CreationExtras creationExtrasA2 = null;
            NavBackStackEntry navBackStackEntry = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : null;
            if (navBackStackEntry != null && (bundleB = navBackStackEntry.b()) != null) {
                creationExtrasA2 = BundleExtKt.a(bundleB, viewModelStoreOwnerC);
            }
            KClass kClassB = Reflection.b(StrictModeOptionsViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            StrictModeOptionsViewModel strictModeOptionsViewModel = (StrictModeOptionsViewModel) viewModelA;
            final StrictModeOptionsViewState strictModeOptionsViewState = (StrictModeOptionsViewState) FlowExtKt.m(strictModeOptionsViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(strictModeOptionsViewModel, composerK, 0);
            final NavHostController navHostControllerB = NavHostControllerKt.b(new Navigator[0], composerK, 0);
            ScaffoldKt.a(null, null, null, null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(-1220261785, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.options.f
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StrictModeOptionsScreenKt.n(navHostControllerB, strictModeOptionsViewState, function1N, z4, onCloseClicked, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 0, 12582912, 131071);
            composerK = composerK;
            j(strictModeOptionsViewModel, onCloseClicked, function1N, composerK, i7 & 112);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            z3 = z4;
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.options.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeOptionsScreenKt.t(z3, onCloseClicked, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(final NavHostController navHostController, final StrictModeOptionsViewState strictModeOptionsViewState, final Function1 function1, final boolean z2, final Function1 function12, PaddingValues it, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(it) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1220261785, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsScreen.<anonymous> (StrictModeOptionsScreen.kt:42)");
            }
            Modifier modifierH = PaddingKt.h(Modifier.b8, it);
            String route = StrictModeOptionNavItem.SelectOptions.getRoute();
            boolean Z = composer.Z(strictModeOptionsViewState) | composer.Z(function1) | composer.b(z2) | composer.Z(function12) | composer.I(navHostController);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.options.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictModeOptionsScreenKt.o(strictModeOptionsViewState, function1, z2, function12, navHostController, (NavGraphBuilder) obj);
                    }
                };
                composer.w(objG);
            }
            NavHostKt.v(navHostController, route, modifierH, null, null, null, null, null, null, null, (Function1) objG, composer, 48, 0, 1016);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(final StrictModeOptionsViewState strictModeOptionsViewState, final Function1 function1, final boolean z2, final Function1 function12, final NavHostController navHostController, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        NavGraphBuilderKt.c(NavHost, StrictModeOptionNavItem.SelectOptions.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(1890028388, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.options.k
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return StrictModeOptionsScreenKt.p(strictModeOptionsViewState, function1, z2, function12, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, StrictModeOptionNavItem.ConfirmBlocking.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1867080819, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.options.l
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return StrictModeOptionsScreenKt.r(strictModeOptionsViewState, function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(final StrictModeOptionsViewState strictModeOptionsViewState, final Function1 function1, boolean z2, Function1 function12, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1890028388, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StrictModeOptionsScreen.kt:48)");
        }
        boolean Z = composer.Z(strictModeOptionsViewState) | composer.I(navHostController) | composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.options.m
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StrictModeOptionsScreenKt.q(strictModeOptionsViewState, navHostController, function1);
                }
            };
            composer.w(objG);
        }
        StrictModeSelectOptionsScreenKt.r(strictModeOptionsViewState, function1, z2, function12, (Function0) objG, composer, 0, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(StrictModeOptionsViewState strictModeOptionsViewState, NavHostController navHostController, Function1 function1) {
        if (StrictModeOption.Companion.a(strictModeOptionsViewState.d()).isEmpty()) {
            function1.invoke(StrictModeOptionsViewEvent.OnSaveClicked.f122299a);
        } else {
            NavController.P(navHostController, StrictModeOptionNavItem.ConfirmBlocking.getRoute(), null, null, 6, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(StrictModeOptionsViewState strictModeOptionsViewState, Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1867080819, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.options.StrictModeOptionsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StrictModeOptionsScreen.kt:64)");
        }
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.options.n
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StrictModeOptionsScreenKt.s(navHostController);
                }
            };
            composer.w(objG);
        }
        StrictModeHeadsUpBlockingScreenKt.j(strictModeOptionsViewState, function1, (Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(NavHostController navHostController) {
        navHostController.R();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(boolean z2, Function1 function1, int i3, int i4, Composer composer, int i5) {
        m(z2, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
