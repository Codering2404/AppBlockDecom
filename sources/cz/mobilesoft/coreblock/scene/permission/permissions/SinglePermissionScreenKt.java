package cz.mobilesoft.coreblock.scene.permission.permissions;

import android.app.Activity;
import android.os.Bundle;
import androidx.activity.compose.LocalActivityKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.LifecycleEffectKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavHostController;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeEvent;
import cz.mobilesoft.coreblock.scene.permission.permissions.components.AccessibilityBottomSheetKt;
import cz.mobilesoft.coreblock.scene.permission.permissions.handler.PermissionFlowHandlerKt;
import cz.mobilesoft.coreblock.scene.permission.permissions.handler.PermissionsHandler;
import cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.AccessibilityPermissionConfigKt;
import cz.mobilesoft.coreblock.scene.permission.permissions.singlepermissions.SimplePermissionsConfigsKt;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.SuccessScreenKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarButtonType;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.Flow;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
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
public final class SinglePermissionScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Function1 function1) {
        function1.invoke(PermissionComposeEvent.OnShowAccessibilityDisclaimer.f112013a);
        return Unit.f139807a;
    }

    private static final SinglePermissionScreenConfig B(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-957610330, i3, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.emptyPermissionConfig (SinglePermissionScreen.kt:176)");
        }
        ComposableSingletons$SinglePermissionScreenKt composableSingletons$SinglePermissionScreenKt = ComposableSingletons$SinglePermissionScreenKt.f111988a;
        SinglePermissionScreenConfig singlePermissionScreenConfig = new SinglePermissionScreenConfig(composableSingletons$SinglePermissionScreenKt.c(), composableSingletons$SinglePermissionScreenKt.d());
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return singlePermissionScreenConfig;
    }

    private static final SinglePermissionScreenConfig C(PermissionDTO permissionDTO, Function1 function1, PermissionComposeState permissionComposeState, boolean z2, Composer composer, int i3) {
        SinglePermissionScreenConfig singlePermissionScreenConfigM;
        if (ComposerKt.M()) {
            ComposerKt.U(-1412756042, i3, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.getPermissionConfig (SinglePermissionScreen.kt:135)");
        }
        Object objQ = composer.q(LocalActivityKt.a());
        Intrinsics.checkNotNull(objQ, "null cannot be cast to non-null type android.app.Activity");
        Activity activity = (Activity) objQ;
        boolean zK = permissionComposeState.k();
        Permission permissionE = permissionDTO.e();
        if (permissionE instanceof Permission.ACCESSIBILITY) {
            composer.a0(-448877493);
            singlePermissionScreenConfigM = AccessibilityPermissionConfigKt.P(permissionDTO, function1, activity, zK, permissionComposeState.g(), permissionComposeState.i(), z2, composer, (i3 & 126) | ((i3 << 9) & 3670016), 0);
            composer.U();
        } else if (permissionE instanceof Permission.USAGE_ACCESS) {
            composer.a0(-448862607);
            singlePermissionScreenConfigM = SimplePermissionsConfigsKt.m(permissionDTO, function1, activity, zK, composer, i3 & 126, 0);
            composer.U();
        } else if (permissionE instanceof Permission.LOCATION) {
            composer.a0(-448855795);
            singlePermissionScreenConfigM = B(composer, 0);
            composer.U();
        } else if (permissionE instanceof Permission.POST_NOTIFICATIONS) {
            composer.a0(-448853551);
            singlePermissionScreenConfigM = SimplePermissionsConfigsKt.m(permissionDTO, function1, activity, zK, composer, i3 & 126, 0);
            composer.U();
        } else if (Intrinsics.areEqual(permissionE, Permission.NOTIFICATION_ACCESS.f97001d)) {
            composer.a0(-448849263);
            singlePermissionScreenConfigM = SimplePermissionsConfigsKt.m(permissionDTO, function1, activity, zK, composer, i3 & 126, 0);
            composer.U();
        } else if (Intrinsics.areEqual(permissionE, Permission.DEVICE_ADMIN.f96998d)) {
            composer.a0(-448845199);
            singlePermissionScreenConfigM = SimplePermissionsConfigsKt.m(permissionDTO, function1, activity, zK, composer, i3 & 126, 0);
            composer.U();
        } else if (Intrinsics.areEqual(permissionE, Permission.ALARM_EXACT.f96997d)) {
            composer.a0(-448841167);
            singlePermissionScreenConfigM = SimplePermissionsConfigsKt.m(permissionDTO, function1, activity, zK, composer, i3 & 126, 0);
            composer.U();
        } else if (Intrinsics.areEqual(permissionE, Permission.MIUI_11_POP_UP.f97000d)) {
            composer.a0(-448837039);
            singlePermissionScreenConfigM = SimplePermissionsConfigsKt.m(permissionDTO, function1, activity, zK, composer, i3 & 126, 0);
            composer.U();
        } else {
            if (!Intrinsics.areEqual(permissionE, Permission.SYSTEM_OVERLAY.f97003d)) {
                composer.a0(-448878599);
                composer.U();
                throw new NoWhenBranchMatchedException();
            }
            composer.a0(-448832911);
            singlePermissionScreenConfigM = SimplePermissionsConfigsKt.m(permissionDTO, function1, activity, zK, composer, i3 & 126, 0);
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return singlePermissionScreenConfigM;
    }

    public static final void n(final PermissionsDTO singlePermissionDTO, final PermissionsHandler permissionHandler, final NavHostController navController, Composer composer, final int i3) {
        int i4;
        final PermissionsHandler permissionsHandler;
        final NavHostController navHostController;
        Function2 function2;
        ScopeUpdateScope scopeUpdateScopeN;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(singlePermissionDTO, "singlePermissionDTO");
        Intrinsics.checkNotNullParameter(permissionHandler, "permissionHandler");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Composer composerK = composer.k(-418454174);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(singlePermissionDTO) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(permissionHandler) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(navController) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i5 = i4;
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-418454174, i5, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.SinglePermissionScreen (SinglePermissionScreen.kt:42)");
            }
            boolean zI = composerK.I(singlePermissionDTO);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.h0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SinglePermissionScreenKt.o(singlePermissionDTO);
                    }
                };
                composerK.w(objG);
            }
            Function0 function0 = (Function0) objG;
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
            KClass kClassB = Reflection.b(PermissionComposeViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, function0);
            composerK.Y();
            composerK.Y();
            PermissionComposeViewModel permissionComposeViewModel = (PermissionComposeViewModel) viewModelA;
            final Function1 function1N = FlowExtKt.n(permissionComposeViewModel, composerK, 0);
            final PermissionComposeState permissionComposeState = (PermissionComposeState) FlowExtKt.m(permissionComposeViewModel, composerK, 0);
            if (permissionComposeState.j() || permissionComposeState.d().isEmpty()) {
                composerK.a0(2122179234);
                Modifier modifierF = SizeKt.f(Modifier.b8, 0.0f, 1, null);
                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
                int iA = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierF);
                ComposeUiNode.Companion companion = ComposeUiNode.f8;
                Function0 function0A = companion.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A);
                } else {
                    composerK.v();
                }
                Composer composerA = Updater.a(composerK);
                Updater.e(composerA, measurePolicyG, companion.e());
                Updater.e(composerA, compositionLocalMapU, companion.g());
                Function2 function2B = companion.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF2, companion.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                ProgressIndicatorKt.b(null, 0L, 0.0f, 0L, 0, composerK, 0, 31);
                composerK.y();
                composerK.U();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN != null) {
                    function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.l0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SinglePermissionScreenKt.u(singlePermissionDTO, permissionHandler, navController, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    scopeUpdateScopeN.a(function2);
                }
                return;
            }
            composerK.a0(2119739968);
            composerK.U();
            PermissionDTO permissionDTO = (PermissionDTO) CollectionsKt.first(permissionComposeState.d());
            if (permissionDTO.e() instanceof Permission.LOCATION) {
                composerK.a0(2122447415);
                Unit unit = Unit.f139807a;
                boolean Z = composerK.Z(function1N) | composerK.Z(permissionDTO);
                Object objG2 = composerK.G();
                if (Z || objG2 == Composer.f23746a.a()) {
                    objG2 = new SinglePermissionScreenKt$SinglePermissionScreen$3$1(function1N, permissionDTO, null);
                    composerK.w(objG2);
                }
                EffectsKt.g(unit, (Function2) objG2, composerK, 6);
            } else {
                composerK.a0(2119739968);
            }
            composerK.U();
            Lifecycle.Event event = Lifecycle.Event.ON_RESUME;
            boolean Z2 = composerK.Z(function1N);
            Object objG3 = composerK.G();
            if (Z2 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.m0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SinglePermissionScreenKt.v(function1N);
                    }
                };
                composerK.w(objG3);
            }
            LifecycleEffectKt.d(event, null, (Function0) objG3, composerK, 6, 2);
            if (permissionComposeState.f()) {
                composerK.a0(2122950328);
                boolean Z3 = composerK.Z(function1N);
                Object objG4 = composerK.G();
                if (Z3 || objG4 == Composer.f23746a.a()) {
                    objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.n0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SinglePermissionScreenKt.w(function1N);
                        }
                    };
                    composerK.w(objG4);
                }
                Function0 function02 = (Function0) objG4;
                boolean Z4 = composerK.Z(function1N);
                Object objG5 = composerK.G();
                if (Z4 || objG5 == Composer.f23746a.a()) {
                    objG5 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.o0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SinglePermissionScreenKt.x(function1N);
                        }
                    };
                    composerK.w(objG5);
                }
                AccessibilityBottomSheetKt.f(false, function02, (Function0) objG5, composerK, 6);
            } else {
                composerK.a0(2119739968);
            }
            composerK.U();
            Flow flowJ0 = permissionComposeViewModel.J0();
            boolean Z5 = composerK.Z(function1N);
            Object objG6 = composerK.G();
            if (Z5 || objG6 == Composer.f23746a.a()) {
                objG6 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.p0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SinglePermissionScreenKt.y(function1N);
                    }
                };
                composerK.w(objG6);
            }
            Function0 function03 = (Function0) objG6;
            boolean Z6 = composerK.Z(function1N);
            Object objG7 = composerK.G();
            if (Z6 || objG7 == Composer.f23746a.a()) {
                objG7 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.q0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SinglePermissionScreenKt.z(function1N);
                    }
                };
                composerK.w(objG7);
            }
            Function0 function04 = (Function0) objG7;
            boolean Z7 = composerK.Z(function1N);
            Object objG8 = composerK.G();
            if (Z7 || objG8 == Composer.f23746a.a()) {
                objG8 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.r0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SinglePermissionScreenKt.A(function1N);
                    }
                };
                composerK.w(objG8);
            }
            PermissionFlowHandlerKt.s(flowJ0, permissionHandler, navController, function03, function04, (Function0) objG8, composerK, i5 & 1008, 0);
            permissionsHandler = permissionHandler;
            navHostController = navController;
            final SinglePermissionScreenConfig singlePermissionScreenConfigC = C(permissionDTO, function1N, permissionComposeState, singlePermissionDTO.j(), composerK, 0);
            composerK = composerK;
            ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, ComposableLambdaKt.e(1740475412, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.s0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SinglePermissionScreenKt.p(permissionComposeState, singlePermissionScreenConfigC, function1N, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 12582912, 127);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            permissionsHandler = permissionHandler;
            navHostController = navController;
            composerK.Q();
        }
        scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.t0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SinglePermissionScreenKt.t(singlePermissionDTO, permissionsHandler, navHostController, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeN.a(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder o(PermissionsDTO permissionsDTO) {
        return ParametersHolderKt.b(permissionsDTO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(final PermissionComposeState permissionComposeState, final SinglePermissionScreenConfig singlePermissionScreenConfig, final Function1 function1, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1740475412, i3, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.SinglePermissionScreen.<anonymous> (SinglePermissionScreen.kt:99)");
            }
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.b(WindowInsets.f7172a, composer, 6)), null, null, ComposableLambdaKt.e(2087433434, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.i0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SinglePermissionScreenKt.q(permissionComposeState, singlePermissionScreenConfig, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, Color.f25715b.j(), 0L, ComposableLambdaKt.e(-1860847406, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.j0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SinglePermissionScreenKt.r(singlePermissionScreenConfig, permissionComposeState, function1, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 3072, 12779520, 98294);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(PermissionComposeState permissionComposeState, SinglePermissionScreenConfig singlePermissionScreenConfig, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2087433434, i3, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.SinglePermissionScreen.<anonymous>.<anonymous> (SinglePermissionScreen.kt:104)");
            }
            if (permissionComposeState.h()) {
                composer.a0(-106501560);
            } else {
                composer.a0(-101995834);
                singlePermissionScreenConfig.a().invoke(composer, 0);
            }
            composer.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(SinglePermissionScreenConfig singlePermissionScreenConfig, PermissionComposeState permissionComposeState, final Function1 function1, PaddingValues paddingValues, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(paddingValues) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1860847406, i4, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.SinglePermissionScreen.<anonymous>.<anonymous> (SinglePermissionScreen.kt:109)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = PaddingKt.h(companion, paddingValues);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
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
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            singlePermissionScreenConfig.b().invoke(SizeKt.f(companion, 0.0f, 1, null), composer, 6);
            if (permissionComposeState.h()) {
                composer.a0(-1376566976);
                SuccessScreenKt.j(SizeKt.f(companion, 0.0f, 1, null), composer, 6, 0);
            } else {
                composer.a0(-1381388406);
            }
            composer.U();
            if (permissionComposeState.h()) {
                composer.a0(-1381388406);
            } else {
                composer.a0(-1376339777);
                boolean Z = composer.Z(function1);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.k0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SinglePermissionScreenKt.s(function1);
                        }
                    };
                    composer.w(objG);
                }
                ToolbarKt.e(null, (Function0) objG, null, permissionComposeState.c(), ToolbarButtonType.Close, false, false, null, null, composer, 24576, 485);
            }
            composer.U();
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
    public static final Unit s(Function1 function1) {
        function1.invoke(PermissionComposeEvent.OnPermissionSkipped.f112009a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(PermissionsDTO permissionsDTO, PermissionsHandler permissionsHandler, NavHostController navHostController, int i3, Composer composer, int i4) {
        n(permissionsDTO, permissionsHandler, navHostController, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(PermissionsDTO permissionsDTO, PermissionsHandler permissionsHandler, NavHostController navHostController, int i3, Composer composer, int i4) {
        n(permissionsDTO, permissionsHandler, navHostController, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Function1 function1) {
        function1.invoke(PermissionComposeEvent.OnResume.f112011a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Function1 function1) {
        function1.invoke(PermissionComposeEvent.OnAccessibilityDisclaimerDismissed.f112002a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(Function1 function1) {
        function1.invoke(PermissionComposeEvent.OnAccessibilityDisclaimerConfirmed.f112001a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(Function1 function1) {
        function1.invoke(PermissionComposeEvent.OnRuntimePermissionGranted.f112012a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Function1 function1) {
        function1.invoke(PermissionComposeEvent.OnDeviceAdminGranted.f112004a);
        return Unit.f139807a;
    }
}
