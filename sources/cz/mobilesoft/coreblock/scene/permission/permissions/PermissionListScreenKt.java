package cz.mobilesoft.coreblock.scene.permission.permissions;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.ScaffoldKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.unit.Dp;
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
import cz.mobilesoft.coreblock.enums.PermissionKt;
import cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeEvent;
import cz.mobilesoft.coreblock.scene.permission.permissions.components.PermissionItemKt;
import cz.mobilesoft.coreblock.scene.permission.permissions.handler.PermissionFlowHandlerKt;
import cz.mobilesoft.coreblock.scene.permission.permissions.handler.PermissionsHandler;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.SuccessScreenKt;
import cz.mobilesoft.coreblock.util.ExternalLinksHelper;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarButtonType;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarKt;
import cz.mobilesoft.coreblock.view.compose.skeleton.SkeletonPresets;
import cz.mobilesoft.coreblock.view.compose.skeleton.StructuredSkeletonKt;
import java.util.List;
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
public final class PermissionListScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(final List list, final boolean z2, final Integer num, final boolean z3, final Function1 function1, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.c(LazyColumn, "toolbar_spacer", null, ComposableSingletons$PermissionListScreenKt.f111985a.d(), 2, null);
        LazyListScope.c(LazyColumn, "header_key", null, ComposableLambdaKt.c(1949917588, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.a0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return PermissionListScreenKt.B(z2, num, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 2, null);
        final Function1 function12 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.b0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PermissionListScreenKt.C((PermissionDTO) obj);
            }
        };
        final PermissionListScreenKt$PermissionListContent$lambda$0$0$0$$inlined$items$default$1 permissionListScreenKt$PermissionListContent$lambda$0$0$0$$inlined$items$default$1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.PermissionListScreenKt$PermissionListContent$lambda$0$0$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Object obj) {
                return null;
            }
        };
        LazyColumn.h(list.size(), new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.PermissionListScreenKt$PermissionListContent$lambda$0$0$0$$inlined$items$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i3) {
                return function12.invoke(list.get(i3));
            }
        }, new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.PermissionListScreenKt$PermissionListContent$lambda$0$0$0$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i3) {
                return permissionListScreenKt$PermissionListContent$lambda$0$0$0$$inlined$items$default$1.invoke(list.get(i3));
            }
        }, ComposableLambdaKt.c(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.PermissionListScreenKt$PermissionListContent$lambda$0$0$0$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return Unit.f139807a;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i3, Composer composer, int i4) {
                int i5;
                if ((i4 & 6) == 0) {
                    i5 = i4 | (composer.Z(lazyItemScope) ? 4 : 2);
                } else {
                    i5 = i4;
                }
                if ((i4 & 48) == 0) {
                    i5 |= composer.e(i3) ? 32 : 16;
                }
                if (!composer.r((i5 & 147) != 146, i5 & 1)) {
                    composer.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(-632812321, i5, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                final PermissionDTO permissionDTO = (PermissionDTO) list.get(i3);
                composer.a0(485062363);
                Modifier modifierM = PaddingKt.m(lazyItemScope.b(Modifier.b8, null, AnimationSpecKt.n(300, 0, EasingKt.d(), 2, null), AnimationSpecKt.n(500, 0, null, 6, null)), 0.0f, 0.0f, 0.0f, Dp.g(8), 7, null);
                boolean z4 = z3;
                boolean Z = composer.Z(permissionDTO) | composer.Z(function1);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    final Function1 function13 = function1;
                    objG = new Function0<Unit>() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.PermissionListScreenKt$PermissionListContent$1$1$1$3$1$1
                        public final void c() {
                            if (permissionDTO.c()) {
                                return;
                            }
                            function13.invoke(permissionDTO);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            c();
                            return Unit.f139807a;
                        }
                    };
                    composer.w(objG);
                }
                PermissionItemKt.f(modifierM, permissionDTO, z4, (Function0) objG, composer, 0, 0);
                composer.U();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(boolean z2, Integer num, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1949917588, i3, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.PermissionListContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PermissionListScreen.kt:242)");
            }
            w(z2, num, composer, 0, 0);
            SpacerKt.a(SizeKt.i(Modifier.b8, Dp.g(24)), composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object C(PermissionDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return PermissionKt.a(it.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(Modifier modifier, List list, boolean z2, Integer num, boolean z3, Function1 function1, int i3, int i4, Composer composer, int i5) {
        z(modifier, list, z2, num, z3, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
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
    public static final void E(final PermissionsDTO permissionDTO, final PermissionsHandler permissionHandler, final NavHostController navController, Composer composer, final int i3) {
        int i4;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(permissionDTO, "permissionDTO");
        Intrinsics.checkNotNullParameter(permissionHandler, "permissionHandler");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Composer composerK = composer.k(-2117318090);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(permissionDTO) ? 4 : 2) | i3;
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
                ComposerKt.U(-2117318090, i5, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.PermissionListScreen (PermissionListScreen.kt:70)");
            }
            boolean zI = composerK.I(permissionDTO);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.e0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PermissionListScreenKt.F(permissionDTO);
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
            CreationExtras creationExtrasA2 = null;
            NavBackStackEntry navBackStackEntry = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : null;
            if (navBackStackEntry != null && (bundleB = navBackStackEntry.b()) != null) {
                creationExtrasA2 = BundleExtKt.a(bundleB, viewModelStoreOwnerC);
            }
            KClass kClassB = Reflection.b(PermissionComposeViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, function0);
            composerK.Y();
            composerK.Y();
            PermissionComposeViewModel permissionComposeViewModel = (PermissionComposeViewModel) viewModelA;
            final Function1 function1N = FlowExtKt.n(permissionComposeViewModel, composerK, 0);
            final PermissionComposeState permissionComposeState = (PermissionComposeState) FlowExtKt.m(permissionComposeViewModel, composerK, 0);
            Lifecycle.Event event = Lifecycle.Event.ON_RESUME;
            boolean Z = composerK.Z(function1N);
            Object objG2 = composerK.G();
            if (Z || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.f0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PermissionListScreenKt.G(function1N);
                    }
                };
                composerK.w(objG2);
            }
            LifecycleEffectKt.d(event, null, (Function0) objG2, composerK, 6, 2);
            Flow flowJ0 = permissionComposeViewModel.J0();
            boolean Z2 = composerK.Z(function1N);
            Object objG3 = composerK.G();
            if (Z2 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.g0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PermissionListScreenKt.H(function1N);
                    }
                };
                composerK.w(objG3);
            }
            Function0 function02 = (Function0) objG3;
            boolean Z3 = composerK.Z(function1N);
            Object objG4 = composerK.G();
            if (Z3 || objG4 == Composer.f23746a.a()) {
                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.q
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PermissionListScreenKt.I(function1N);
                    }
                };
                composerK.w(objG4);
            }
            Function0 function03 = (Function0) objG4;
            boolean Z4 = composerK.Z(function1N);
            Object objG5 = composerK.G();
            if (Z4 || objG5 == Composer.f23746a.a()) {
                objG5 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.r
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PermissionListScreenKt.J(function1N);
                    }
                };
                composerK.w(objG5);
            }
            PermissionFlowHandlerKt.s(flowJ0, permissionHandler, navController, function02, function03, (Function0) objG5, composerK, i5 & 1008, 0);
            ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, ComposableLambdaKt.e(-1406264856, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.s
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PermissionListScreenKt.K(permissionComposeState, function1N, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 12582912, 127);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PermissionListScreenKt.N(permissionDTO, permissionHandler, navController, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder F(PermissionsDTO permissionsDTO) {
        return ParametersHolderKt.b(permissionsDTO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(Function1 function1) {
        function1.invoke(PermissionComposeEvent.OnResume.f112011a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(Function1 function1) {
        function1.invoke(PermissionComposeEvent.OnRuntimePermissionGranted.f112012a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(Function1 function1) {
        function1.invoke(PermissionComposeEvent.OnDeviceAdminGranted.f112004a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(Function1 function1) {
        function1.invoke(PermissionComposeEvent.OnShowAccessibilityDisclaimer.f112013a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(final PermissionComposeState permissionComposeState, final Function1 function1, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1406264856, i3, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.PermissionListScreen.<anonymous> (PermissionListScreen.kt:90)");
            }
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.b(WindowInsets.f7172a, composer, 6)), null, null, null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, Color.f25715b.j(), 0L, ComposableLambdaKt.e(128341414, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.u
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PermissionListScreenKt.L(permissionComposeState, function1, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 0, 12779520, 98302);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(PermissionComposeState permissionComposeState, final Function1 function1, PaddingValues paddingValues, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(paddingValues) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(128341414, i4, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.PermissionListScreen.<anonymous>.<anonymous> (PermissionListScreen.kt:94)");
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
            s(permissionComposeState, function1, composer, 0);
            if (permissionComposeState.h()) {
                composer.a0(1144699948);
                SuccessScreenKt.j(SizeKt.f(companion, 0.0f, 1, null), composer, 6, 0);
            } else {
                composer.a0(1139846774);
            }
            composer.U();
            if (permissionComposeState.h()) {
                composer.a0(1139846774);
            } else {
                composer.a0(1144927147);
                boolean Z = composer.Z(function1);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.v
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PermissionListScreenKt.M(function1);
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
    public static final Unit M(Function1 function1) {
        function1.invoke(PermissionComposeEvent.OnPermissionSkipped.f112009a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(PermissionsDTO permissionsDTO, PermissionsHandler permissionsHandler, NavHostController navHostController, int i3, Composer composer, int i4) {
        E(permissionsDTO, permissionsHandler, navHostController, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void s(final PermissionComposeState permissionComposeState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-955568625);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(permissionComposeState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-955568625, i4, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.Content (PermissionListScreen.kt:121)");
            }
            StructuredSkeletonKt.E(permissionComposeState.j(), SkeletonPresets.f(SkeletonPresets.f131964a, 0, 1, null), PaddingKt.m(PaddingKt.k(SizeKt.f(Modifier.b8, 0.0f, 1, null), Dp.g(16), 0.0f, 2, null), 0.0f, Dp.g(80), 0.0f, 0.0f, 13, null), false, null, ComposableLambdaKt.e(934333077, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PermissionListScreenKt.t(permissionComposeState, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 196992, 24);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PermissionListScreenKt.v(permissionComposeState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(PermissionComposeState permissionComposeState, final Function1 function1, Composer composer, int i3) {
        Composer composer2;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(934333077, i3, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.Content.<anonymous> (PermissionListScreen.kt:130)");
            }
            if (permissionComposeState.d().isEmpty()) {
                composer2 = composer;
                composer2.a0(-972257811);
            } else {
                composer.a0(-966280701);
                Modifier modifierF = SizeKt.f(Modifier.b8, 0.0f, 1, null);
                List listD = permissionComposeState.d();
                boolean zK = permissionComposeState.k();
                Integer numE = permissionComposeState.e();
                boolean zI = permissionComposeState.i();
                boolean Z = composer.Z(function1);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.p
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PermissionListScreenKt.u(function1, (PermissionDTO) obj);
                        }
                    };
                    composer.w(objG);
                }
                composer2 = composer;
                z(modifierF, listD, zK, numE, zI, (Function1) objG, composer2, 6, 0);
            }
            composer2.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Function1 function1, PermissionDTO permissionDTO) {
        Intrinsics.checkNotNullParameter(permissionDTO, "permissionDTO");
        function1.invoke(new PermissionComposeEvent.OnPermissionClick(permissionDTO, true));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(PermissionComposeState permissionComposeState, Function1 function1, int i3, Composer composer, int i4) {
        s(permissionComposeState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void w(final boolean r36, java.lang.Integer r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instruction units count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.permission.permissions.PermissionListScreenKt.w(boolean, java.lang.Integer, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(Context context, LinkAnnotation it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ExternalLinksHelper.f127866a.c(context, Uri.parse("https://appblock.app/privacy-policy-google-play"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(boolean z2, Integer num, int i3, int i4, Composer composer, int i5) {
        w(z2, num, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void z(androidx.compose.ui.Modifier r27, final java.util.List r28, final boolean r29, java.lang.Integer r30, boolean r31, final kotlin.jvm.functions.Function1 r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instruction units count: 512
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.permission.permissions.PermissionListScreenKt.z(androidx.compose.ui.Modifier, java.util.List, boolean, java.lang.Integer, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }
}
