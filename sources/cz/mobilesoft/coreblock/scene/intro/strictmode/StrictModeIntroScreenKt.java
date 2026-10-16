package cz.mobilesoft.coreblock.scene.intro.strictmode;

import android.content.Context;
import android.content.Intent;
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
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
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
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroViewEvent;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessActivity;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.ScreenProgressBarKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
import org.xmlpull.v1.XmlPullParserException;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class StrictModeIntroScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(ScaffoldState scaffoldState, final Function1 function1, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1210618436, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavHost.<anonymous>.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:140)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.b2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StrictModeIntroScreenKt.B0();
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean Z = composer.Z(function1);
        Object objG2 = composer.G();
        if (Z || objG2 == companion.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.c2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StrictModeIntroScreenKt.C0(function1);
                }
            };
            composer.w(objG2);
        }
        StrictModeStartScreenKt.k(scaffoldState, function0, (Function0) objG2, composer, 48, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A1(NavHostController navHostController, Function1 function1, ScaffoldState scaffoldState, StrictModeIntroNavigation strictModeIntroNavigation, int i3, Composer composer, int i4) {
        x0(navHostController, function1, scaffoldState, strictModeIntroNavigation, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0() {
        AnswersHelper.f128199a.x7();
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
    public static final void B1(Function0 function0, StrictModeIntroNavigation strictModeIntroNavigation, Composer composer, final int i3, final int i4) {
        final Function0 function02;
        int i5;
        final StrictModeIntroNavigation strictModeIntroNavigation2;
        final Function0 function03;
        Bundle bundleB;
        Composer composerK = composer.k(873735137);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            function02 = function0;
        } else if ((i3 & 6) == 0) {
            function02 = function0;
            i5 = (composerK.I(function02) ? 4 : 2) | i3;
        } else {
            function02 = function0;
            i5 = i3;
        }
        int i7 = i4 & 2;
        if (i7 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.e(strictModeIntroNavigation == null ? -1 : strictModeIntroNavigation.ordinal()) ? 32 : 16;
        }
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            Function0 function04 = i6 != 0 ? null : function02;
            strictModeIntroNavigation2 = i7 != 0 ? StrictModeIntroNavigation.Start : strictModeIntroNavigation;
            if (ComposerKt.M()) {
                ComposerKt.U(873735137, i5, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroScreen (StrictModeIntroScreen.kt:63)");
            }
            NavHostController navHostControllerB = NavHostControllerKt.b(new Navigator[0], composerK, 0);
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
            KClass kClassB = Reflection.b(StrictModeIntroViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            StrictModeIntroViewModel strictModeIntroViewModel = (StrictModeIntroViewModel) viewModelA;
            final Function1 function1N = FlowExtKt.n(strictModeIntroViewModel, composerK, 0);
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composerK, 0, 3);
            if (function04 == null) {
                composerK.a0(1942316877);
                boolean Z = composerK.Z(function1N);
                Object objG = composerK.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.d2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return StrictModeIntroScreenKt.C1(function1N);
                        }
                    };
                    composerK.w(objG);
                }
                function03 = (Function0) objG;
                composerK.U();
            } else {
                composerK.a0(2140864838);
                composerK.U();
                function03 = function04;
            }
            int i8 = (i5 << 6) & 7168;
            x0(navHostControllerB, function1N, scaffoldStateG, strictModeIntroNavigation2, composerK, i8);
            boolean Z2 = composerK.Z(function03);
            Object objG2 = composerK.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.o2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeIntroScreenKt.D1(function03);
                    }
                };
                composerK.w(objG2);
            }
            t0(strictModeIntroViewModel, (Function0) objG2, navHostControllerB, strictModeIntroNavigation2, composerK, i8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            function02 = function04;
        } else {
            composerK.Q();
            strictModeIntroNavigation2 = strictModeIntroNavigation;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.u2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeIntroScreenKt.E1(function02, strictModeIntroNavigation2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(Function1 function1) {
        function1.invoke(StrictModeIntroViewEvent.OnCloseClicked.f105032a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C1(Function1 function1) {
        AnswersHelper.f128199a.H7();
        function1.invoke(StrictModeIntroViewEvent.RestartIntro.f105034a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(561502189, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavHost.<anonymous>.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:152)");
        }
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.q1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StrictModeIntroScreenKt.E0(function1);
                }
            };
            composer.w(objG);
        }
        n0(null, 1.0f, (Function0) objG, ComposableLambdaKt.e(-1248082462, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.r1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StrictModeIntroScreenKt.F0(navHostController, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 3120, 1);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D1(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(Function1 function1) {
        function1.invoke(StrictModeIntroViewEvent.OnCloseClicked.f105032a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E1(Function0 function0, StrictModeIntroNavigation strictModeIntroNavigation, int i3, int i4, Composer composer, int i5) {
        B1(function0, strictModeIntroNavigation, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(final NavHostController navHostController, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1248082462, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:158)");
            }
            boolean zI = composer.I(navHostController);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.s2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeIntroScreenKt.G0(navHostController);
                    }
                };
                composer.w(objG);
            }
            StrictModeSmartLockScreenKt.f((Function0) objG, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(NavHostController navHostController) {
        NavController.P(navHostController, StrictModeIntroNavigation.StrictModeExplanation.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(final Function1 function1, final NavHostController navHostController, final ManagedActivityResultLauncher managedActivityResultLauncher, final Context context, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(555123065, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavHost.<anonymous>.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:389)");
        }
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.i1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StrictModeIntroScreenKt.I0(function1);
                }
            };
            composer.w(objG);
        }
        n0(null, 10.0f, (Function0) objG, ComposableLambdaKt.e(292573732, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.j1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StrictModeIntroScreenKt.J0(function1, navHostController, managedActivityResultLauncher, context, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 3120, 1);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(Function1 function1) {
        function1.invoke(StrictModeIntroViewEvent.OnCloseClicked.f105032a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(final Function1 function1, final NavHostController navHostController, final ManagedActivityResultLauncher managedActivityResultLauncher, final Context context, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(292573732, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:395)");
            }
            boolean Z = composer.Z(function1) | composer.I(navHostController);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.e2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeIntroScreenKt.K0(function1, navHostController);
                    }
                };
                composer.w(objG);
            }
            Function0 function0 = (Function0) objG;
            boolean zI = composer.I(managedActivityResultLauncher) | composer.I(context);
            Object objG2 = composer.G();
            if (zI || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.f2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeIntroScreenKt.L0(managedActivityResultLauncher, context);
                    }
                };
                composer.w(objG2);
            }
            RecommendedUnlocksScreenKt.d(function0, (Function0) objG2, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(Function1 function1, NavHostController navHostController) {
        function1.invoke(new StrictModeIntroViewEvent.OnAccessMethodConfirmed(StrictModeAccessMethod.Cooldown, CollectionsKt.listOf(new AccessMethodConfiguration.Cooldown(TimeUnit.MINUTES.toMillis(2L)))));
        NavController.P(navHostController, StrictModeIntroNavigation.ThatIsItScreen.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(ManagedActivityResultLauncher managedActivityResultLauncher, Context context) {
        managedActivityResultLauncher.b(StrictModeAccessActivity.f121510f.a(context));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1726331736, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavHost.<anonymous>.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:413)");
        }
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.f1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StrictModeIntroScreenKt.N0(function1);
                }
            };
            composer.w(objG);
        }
        n0(null, 11.0f, (Function0) objG, ComposableLambdaKt.e(1463782403, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.g1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StrictModeIntroScreenKt.O0(navHostController, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 3120, 1);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(Function1 function1) {
        function1.invoke(StrictModeIntroViewEvent.OnCloseClicked.f105032a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(final NavHostController navHostController, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1463782403, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:419)");
            }
            String strB = StringResources_androidKt.b(R.string.Ry, composer, 0);
            boolean zI = composer.I(navHostController);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.t2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeIntroScreenKt.P0(navHostController);
                    }
                };
                composer.w(objG);
            }
            v0(strB, false, (Function0) objG, composer, 48, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(NavHostController navHostController) {
        NavController.P(navHostController, StrictModeIntroNavigation.ActivateWhenReadyScreen.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(final Function1 function1, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1397426889, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavHost.<anonymous>.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:429)");
        }
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.z1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StrictModeIntroScreenKt.R0(function1);
                }
            };
            composer.w(objG);
        }
        n0(null, 12.0f, (Function0) objG, ComposableLambdaKt.e(-1659976222, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.a2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StrictModeIntroScreenKt.S0(function1, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 3120, 1);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(Function1 function1) {
        function1.invoke(StrictModeIntroViewEvent.OnCloseClicked.f105032a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(final Function1 function1, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1659976222, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:435)");
            }
            String strB = StringResources_androidKt.b(R.string.Sy, composer, 0);
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.n2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeIntroScreenKt.T0(function1);
                    }
                };
                composer.w(objG);
            }
            v0(strB, false, (Function0) objG, composer, 48, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(Function1 function1) {
        function1.invoke(StrictModeIntroViewEvent.OnIntroFinished.f105033a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U0(final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1732710860, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavHost.<anonymous>.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:168)");
        }
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.o1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StrictModeIntroScreenKt.V0(function1);
                }
            };
            composer.w(objG);
        }
        n0(null, 2.0f, (Function0) objG, ComposableLambdaKt.e(-76873791, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.p1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StrictModeIntroScreenKt.W0(navHostController, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 3120, 1);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(Function1 function1) {
        function1.invoke(StrictModeIntroViewEvent.OnCloseClicked.f105032a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(final NavHostController navHostController, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-76873791, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:174)");
            }
            List listListOf = CollectionsKt.listOf((Object[]) new InfoItem[]{new InfoItem(R.drawable.Za, R.string.Ty, Color.n(ComposeColorsKt.j(composer, 0).a0()), ComposeColorsKt.j(composer, 0).q0(), ComposeColorsKt.j(composer, 0).a0(), false, 32, null), new InfoItem(R.drawable.cb, R.string.Yy, Color.n(ComposeColorsKt.j(composer, 0).b()), ComposeColorsKt.j(composer, 0).q0(), ComposeColorsKt.j(composer, 0).b(), false, 32, null), new InfoItem(R.drawable.L4, R.string.Vy, Color.n(ComposeColorsKt.j(composer, 0).A()), ComposeColorsKt.j(composer, 0).q0(), ComposeColorsKt.j(composer, 0).A(), false, 32, null)});
            String strB = StringResources_androidKt.b(R.string.Xy, composer, 0);
            String strB2 = StringResources_androidKt.b(R.string.Wy, composer, 0);
            String strB3 = StringResources_androidKt.b(R.string.Uy, composer, 0);
            boolean zI = composer.I(navHostController);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.l2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeIntroScreenKt.X0(navHostController);
                    }
                };
                composer.w(objG);
            }
            StrictModeExplanationsScreenKt.t(strB, strB2, listListOf, strB3, false, true, (Function0) objG, composer, 196608, 16);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(NavHostController navHostController) {
        NavController.P(navHostController, StrictModeIntroNavigation.HowDoesItWorkSplashScreen.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1391047765, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavHost.<anonymous>.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:212)");
        }
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.x1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StrictModeIntroScreenKt.Z0(function1);
                }
            };
            composer.w(objG);
        }
        n0(null, 3.0f, (Function0) objG, ComposableLambdaKt.e(1094334880, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.y1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StrictModeIntroScreenKt.a1(navHostController, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 3120, 1);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(Function1 function1) {
        function1.invoke(StrictModeIntroViewEvent.OnCloseClicked.f105032a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(final NavHostController navHostController, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1094334880, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:218)");
            }
            String strB = StringResources_androidKt.b(R.string.Zy, composer, 0);
            boolean zI = composer.I(navHostController);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.i2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeIntroScreenKt.b1(navHostController);
                    }
                };
                composer.w(objG);
            }
            v0(strB, false, (Function0) objG, composer, 0, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b1(NavHostController navHostController) {
        NavController.P(navHostController, StrictModeIntroNavigation.BlockingTestScreen.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c1(final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-219839094, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavHost.<anonymous>.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:225)");
        }
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.t1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StrictModeIntroScreenKt.d1(function1);
                }
            };
            composer.w(objG);
        }
        n0(null, 4.0f, (Function0) objG, ComposableLambdaKt.e(-2029423745, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.u1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StrictModeIntroScreenKt.e1(navHostController, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 3120, 1);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d1(Function1 function1) {
        function1.invoke(StrictModeIntroViewEvent.OnCloseClicked.f105032a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(final NavHostController navHostController, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2029423745, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:231)");
            }
            boolean zI = composer.I(navHostController);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.p2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeIntroScreenKt.f1(navHostController);
                    }
                };
                composer.w(objG);
            }
            StrictModeBlockingTestScreenKt.m((Function0) objG, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(NavHostController navHostController) {
        NavController.P(navHostController, StrictModeIntroNavigation.WhatStrictModeDoes.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1(final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(951369577, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavHost.<anonymous>.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:241)");
        }
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.v1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StrictModeIntroScreenKt.h1(function1);
                }
            };
            composer.w(objG);
        }
        n0(null, 5.0f, (Function0) objG, ComposableLambdaKt.e(-858215074, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.w1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StrictModeIntroScreenKt.i1(navHostController, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 3120, 1);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h1(Function1 function1) {
        function1.invoke(StrictModeIntroViewEvent.OnCloseClicked.f105032a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i1(final NavHostController navHostController, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-858215074, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:247)");
            }
            List listListOf = CollectionsKt.listOf((Object[]) new InfoItem[]{new InfoItem(R.drawable.W1, R.string.Oy, null, ComposeColorsKt.j(composer, 0).a0(), ComposeColorsKt.j(composer, 0).a0(), true, null), new InfoItem(R.drawable.f95531k1, R.string.My, null, ComposeColorsKt.j(composer, 0).a0(), ComposeColorsKt.j(composer, 0).a0(), true, null), new InfoItem(R.drawable.W, R.string.Ny, null, ComposeColorsKt.j(composer, 0).a0(), ComposeColorsKt.j(composer, 0).a0(), true, null), new InfoItem(R.drawable.f95542n0, R.string.Py, null, ComposeColorsKt.j(composer, 0).a0(), ComposeColorsKt.j(composer, 0).a0(), true, null)});
            String strB = StringResources_androidKt.b(R.string.tz, composer, 0);
            String strB2 = StringResources_androidKt.b(R.string.sz, composer, 0);
            String strB3 = StringResources_androidKt.b(R.string.rz, composer, 0);
            boolean zI = composer.I(navHostController);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.r2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeIntroScreenKt.j1(navHostController);
                    }
                };
                composer.w(objG);
            }
            StrictModeExplanationsScreenKt.t(strB, strB2, listListOf, strB3, false, false, (Function0) objG, composer, 0, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j1(NavHostController navHostController) {
        NavController.P(navHostController, StrictModeIntroNavigation.WhatAreTheBenefits.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k1(final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(2122578248, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavHost.<anonymous>.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:295)");
        }
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.m1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StrictModeIntroScreenKt.l1(function1);
                }
            };
            composer.w(objG);
        }
        n0(null, 6.0f, (Function0) objG, ComposableLambdaKt.e(312993597, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.n1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StrictModeIntroScreenKt.m1(navHostController, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 3120, 1);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l1(Function1 function1) {
        function1.invoke(StrictModeIntroViewEvent.OnCloseClicked.f105032a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m1(final NavHostController navHostController, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(312993597, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:301)");
            }
            String strB = StringResources_androidKt.b(R.string.Ly, composer, 0);
            boolean zI = composer.I(navHostController);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.k2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeIntroScreenKt.n1(navHostController);
                    }
                };
                composer.w(objG);
            }
            v0(strB, false, (Function0) objG, composer, 0, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    private static final void n0(String str, final float f3, final Function0 function0, final Function3 function3, Composer composer, final int i3, final int i4) {
        String str2;
        int i5;
        final String str3;
        Composer composerK = composer.k(-1163618118);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            str2 = str;
        } else if ((i3 & 6) == 0) {
            str2 = str;
            i5 = (composerK.Z(str2) ? 4 : 2) | i3;
        } else {
            str2 = str;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.c(f3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(function0) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.I(function3) ? 2048 : 1024;
        }
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            String str4 = i6 != 0 ? null : str2;
            if (ComposerKt.M()) {
                ComposerKt.U(-1163618118, i5, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.BaseOnboardingScreen (StrictModeIntroScreen.kt:452)");
            }
            String str5 = str4;
            ComposeBackgroundKt.m(null, false, false, false, str5, 0L, null, ComposableLambdaKt.e(1092741100, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.g2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StrictModeIntroScreenKt.o0(function0, f3, function3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, ((i5 << 12) & 57344) | 12582912, 111);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            str3 = str5;
        } else {
            composerK.Q();
            str3 = str2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.h2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeIntroScreenKt.s0(str3, f3, function0, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n1(NavHostController navHostController) {
        NavController.P(navHostController, StrictModeIntroNavigation.GainControlScreen.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(final Function0 function0, final float f3, final Function3 function3, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1092741100, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.BaseOnboardingScreen.<anonymous> (StrictModeIntroScreen.kt:456)");
            }
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.c(WindowInsets.f7172a, composer, 6)), null, ComposableLambdaKt.e(1545053681, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.w0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeIntroScreenKt.p0(function0, f3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, Color.f25715b.j(), 0L, ComposableLambdaKt.e(257321002, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.h1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StrictModeIntroScreenKt.r0(function3, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 384, 12779520, 98298);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o1(final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1001180377, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavHost.<anonymous>.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:308)");
        }
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.b1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StrictModeIntroScreenKt.p1(function1);
                }
            };
            composer.w(objG);
        }
        n0(null, 7.0f, (Function0) objG, ComposableLambdaKt.e(1484202268, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.c1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StrictModeIntroScreenKt.q1(navHostController, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 3120, 1);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(final Function0 function0, float f3, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1545053681, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.BaseOnboardingScreen.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:460)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierM = PaddingKt.m(SizeKt.h(companion, 0.0f, 1, null), 0.0f, Dp.g(16), 0.0f, 0.0f, 13, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierM);
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
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierF2 = boxScopeInstance.f(companion, companion2.h());
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6);
            long jP = ComposeColorsKt.j(composer, 0).p();
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.s1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeIntroScreenKt.q0(function0);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.q0(modifierF2, imageVectorB, null, false, 0.0f, 0.0f, jP, null, (Function0) objG, composer, 0, 188);
            ScreenProgressBarKt.b(boxScopeInstance.f(companion, companion2.e()), f3 / 12.0f, composer, 0, 0);
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
    public static final Unit p1(Function1 function1) {
        function1.invoke(StrictModeIntroViewEvent.OnCloseClicked.f105032a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q1(final NavHostController navHostController, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1484202268, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:314)");
            }
            List listListOf = CollectionsKt.listOf((Object[]) new InfoItem[]{new InfoItem(R.drawable.I4, R.string.Iy, null, ComposeColorsKt.j(composer, 0).A(), ComposeColorsKt.j(composer, 0).A(), false, 32, null), new InfoItem(R.drawable.u2, R.string.Hy, null, ComposeColorsKt.j(composer, 0).A(), ComposeColorsKt.j(composer, 0).A(), false, 32, null), new InfoItem(R.drawable.I3, R.string.Gy, null, ComposeColorsKt.j(composer, 0).A(), ComposeColorsKt.j(composer, 0).A(), false, 32, null)});
            String strB = StringResources_androidKt.b(R.string.Ky, composer, 0);
            String strB2 = StringResources_androidKt.b(R.string.Jy, composer, 0);
            String strB3 = StringResources_androidKt.b(R.string.fz, composer, 0);
            boolean zI = composer.I(navHostController);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.j2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeIntroScreenKt.r1(navHostController);
                    }
                };
                composer.w(objG);
            }
            StrictModeExplanationsScreenKt.t(strB, strB2, listListOf, strB3, true, false, (Function0) objG, composer, 24576, 32);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r0(Function3 function3, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(257321002, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.BaseOnboardingScreen.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:475)");
            }
            function3.invoke(it, composer, Integer.valueOf(i3 & 14));
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r1(NavHostController navHostController) {
        NavController.P(navHostController, StrictModeIntroNavigation.YouDecideScreen.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(String str, float f3, Function0 function0, Function3 function3, int i3, int i4, Composer composer, int i5) {
        n0(str, f3, function0, function3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s1(final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(170028294, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavHost.<anonymous>.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:352)");
        }
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.d1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StrictModeIntroScreenKt.t1(function1);
                }
            };
            composer.w(objG);
        }
        n0(null, 8.0f, (Function0) objG, ComposableLambdaKt.e(-1639556357, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.e1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StrictModeIntroScreenKt.u1(navHostController, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 3120, 1);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    private static final void t0(StrictModeIntroViewModel strictModeIntroViewModel, final Function0 function0, final NavHostController navHostController, final StrictModeIntroNavigation strictModeIntroNavigation, Composer composer, final int i3) {
        int i4;
        StrictModeIntroViewModel strictModeIntroViewModel2;
        Composer composerK = composer.k(1155473905);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(strictModeIntroViewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function0) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(navHostController) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.e(strictModeIntroNavigation.ordinal()) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1155473905, i4, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.CommandProcessor (StrictModeIntroScreen.kt:97)");
            }
            boolean zI = ((i4 & 112) == 32) | composerK.I(navHostController) | ((i4 & 7168) == 2048);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new StrictModeIntroScreenKt$CommandProcessor$1$1(function0, navHostController, strictModeIntroNavigation, null);
                composerK.w(objG);
            }
            strictModeIntroViewModel2 = strictModeIntroViewModel;
            FlowExtKt.g(strictModeIntroViewModel2, null, (Function2) objG, composerK, i4 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            strictModeIntroViewModel2 = strictModeIntroViewModel;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final StrictModeIntroViewModel strictModeIntroViewModel3 = strictModeIntroViewModel2;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.m0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeIntroScreenKt.u0(strictModeIntroViewModel3, function0, navHostController, strictModeIntroNavigation, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t1(Function1 function1) {
        function1.invoke(StrictModeIntroViewEvent.OnCloseClicked.f105032a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(StrictModeIntroViewModel strictModeIntroViewModel, Function0 function0, NavHostController navHostController, StrictModeIntroNavigation strictModeIntroNavigation, int i3, Composer composer, int i4) {
        t0(strictModeIntroViewModel, function0, navHostController, strictModeIntroNavigation, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u1(final NavHostController navHostController, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1639556357, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:358)");
            }
            boolean zI = composer.I(navHostController);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.m2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeIntroScreenKt.v1(navHostController);
                    }
                };
                composer.w(objG);
            }
            BaseStrictModeOnboardingImageScreenKt.c((Function0) objG, R.drawable.l8, StringResources_androidKt.b(R.string.vz, composer, 0), StringResources_androidKt.b(R.string.uz, composer, 0), composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0280  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void v0(final java.lang.String r22, boolean r23, final kotlin.jvm.functions.Function0 r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instruction units count: 665
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroScreenKt.v0(java.lang.String, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v1(NavHostController navHostController) {
        NavController.P(navHostController, StrictModeIntroNavigation.UnlocksScreen.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(String str, boolean z2, Function0 function0, int i3, int i4, Composer composer, int i5) {
        v0(str, z2, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w1(final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1341236965, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavHost.<anonymous>.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:370)");
        }
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.k1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StrictModeIntroScreenKt.x1(function1);
                }
            };
            composer.w(objG);
        }
        n0(null, 9.0f, (Function0) objG, ComposableLambdaKt.e(-468347686, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.l1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StrictModeIntroScreenKt.y1(navHostController, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 3120, 1);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    private static final void x0(final NavHostController navHostController, final Function1 function1, final ScaffoldState scaffoldState, final StrictModeIntroNavigation strictModeIntroNavigation, Composer composer, final int i3) {
        int i4;
        ScaffoldState scaffoldState2;
        Composer composerK = composer.k(1347320775);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(navHostController) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            scaffoldState2 = scaffoldState;
            i4 |= composerK.Z(scaffoldState2) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            scaffoldState2 = scaffoldState;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.e(strictModeIntroNavigation.ordinal()) ? 2048 : 1024;
        }
        int i5 = i4;
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1347320775, i5, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavHost (StrictModeIntroScreen.kt:115)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            int i6 = i5 & 112;
            boolean z2 = i6 == 32;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.v2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictModeIntroScreenKt.y0(function1, (ActivityResult) obj);
                    }
                };
                composerK.w(objG);
            }
            final ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG, composerK, 0);
            String route = strictModeIntroNavigation.getRoute();
            boolean zI = ((i5 & 896) == 256) | (i6 == 32) | composerK.I(navHostController) | composerK.I(managedActivityResultLauncherA) | composerK.I(context);
            Object objG2 = composerK.G();
            if (zI || objG2 == Composer.f23746a.a()) {
                final ScaffoldState scaffoldState3 = scaffoldState2;
                Function1 function12 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.w2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictModeIntroScreenKt.z0(scaffoldState3, function1, navHostController, managedActivityResultLauncherA, context, (NavGraphBuilder) obj);
                    }
                };
                composerK.w(function12);
                objG2 = function12;
            }
            NavHostKt.v(navHostController, route, null, null, null, null, null, null, null, null, (Function1) objG2, composerK, i5 & 14, 0, 1020);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.x2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeIntroScreenKt.A1(navHostController, function1, scaffoldState, strictModeIntroNavigation, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x1(Function1 function1) {
        function1.invoke(StrictModeIntroViewEvent.OnCloseClicked.f105032a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(Function1 function1, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.d() == -1) {
            Intent intentC = it.c();
            Serializable serializableExtra = intentC != null ? intentC.getSerializableExtra("ACCESS_METHOD") : null;
            StrictModeAccessMethod strictModeAccessMethod = serializableExtra instanceof StrictModeAccessMethod ? (StrictModeAccessMethod) serializableExtra : null;
            if (strictModeAccessMethod != null) {
                Intent intentC2 = it.c();
                Serializable serializableExtra2 = intentC2 != null ? intentC2.getSerializableExtra("ACCESS_METHOD_CONFIGURATION") : null;
                List listEmptyList = serializableExtra2 instanceof ArrayList ? (ArrayList) serializableExtra2 : null;
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                function1.invoke(new StrictModeIntroViewEvent.OnAccessMethodConfirmed(strictModeAccessMethod, listEmptyList));
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y1(final NavHostController navHostController, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-468347686, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeIntroNavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StrictModeIntroScreen.kt:376)");
            }
            boolean zI = composer.I(navHostController);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.q2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeIntroScreenKt.z1(navHostController);
                    }
                };
                composer.w(objG);
            }
            BaseStrictModeOnboardingImageScreenKt.c((Function0) objG, R.drawable.eb, StringResources_androidKt.b(R.string.mz, composer, 0), StringResources_androidKt.b(R.string.lz, composer, 0), composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(final ScaffoldState scaffoldState, final Function1 function1, final NavHostController navHostController, final ManagedActivityResultLauncher managedActivityResultLauncher, final Context context, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        NavGraphBuilderKt.c(NavHost, StrictModeIntroNavigation.Start.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(1210618436, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.n0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return StrictModeIntroScreenKt.A0(scaffoldState, function1, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, StrictModeIntroNavigation.SmartLock.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(561502189, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.r0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return StrictModeIntroScreenKt.D0(function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, StrictModeIntroNavigation.StrictModeExplanation.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(1732710860, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.s0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return StrictModeIntroScreenKt.U0(function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, StrictModeIntroNavigation.HowDoesItWorkSplashScreen.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1391047765, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.t0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return StrictModeIntroScreenKt.Y0(function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, StrictModeIntroNavigation.BlockingTestScreen.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-219839094, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.u0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return StrictModeIntroScreenKt.c1(function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, StrictModeIntroNavigation.WhatStrictModeDoes.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(951369577, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.v0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return StrictModeIntroScreenKt.g1(function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, StrictModeIntroNavigation.WhatAreTheBenefits.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(2122578248, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.x0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return StrictModeIntroScreenKt.k1(function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, StrictModeIntroNavigation.GainControlScreen.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1001180377, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.y0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return StrictModeIntroScreenKt.o1(function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, StrictModeIntroNavigation.YouDecideScreen.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(170028294, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.z0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return StrictModeIntroScreenKt.s1(function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, StrictModeIntroNavigation.UnlocksScreen.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(1341236965, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.a1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return StrictModeIntroScreenKt.w1(function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, StrictModeIntroNavigation.RecommendedUnlocksScreen.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(555123065, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.o0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return StrictModeIntroScreenKt.H0(function1, navHostController, managedActivityResultLauncher, context, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, StrictModeIntroNavigation.ThatIsItScreen.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(1726331736, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.p0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return StrictModeIntroScreenKt.M0(function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, StrictModeIntroNavigation.ActivateWhenReadyScreen.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1397426889, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.q0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return StrictModeIntroScreenKt.Q0(function1, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z1(NavHostController navHostController) {
        NavController.P(navHostController, StrictModeIntroNavigation.RecommendedUnlocksScreen.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }
}
