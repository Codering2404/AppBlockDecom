package cz.mobilesoft.coreblock.scene.onboarding.blockingtest;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
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
import cz.mobilesoft.coreblock.scene.onboarding.blockingtest.OnboardingBlockingTestKt;
import cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screens.OnboardingBlockingTestIntroKt;
import cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.OnboardingBlockingTestScreenKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

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
public final class OnboardingBlockingTestKt {
    public static final void l(final float f3, final Function0 onContinueClicked, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onContinueClicked, "onContinueClicked");
        Composer composerK = composer.k(1769099705);
        if ((i3 & 6) == 0) {
            i4 = (composerK.c(f3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onContinueClicked) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1769099705, i4, -1, "cz.mobilesoft.coreblock.scene.onboarding.blockingtest.OnboardingBlockingTest (OnboardingBlockingTest.kt:31)");
            }
            final NavHostController navHostControllerB = NavHostControllerKt.b(new Navigator[0], composerK, 0);
            int i5 = i4;
            OnboardingBlockingTestIntro onboardingBlockingTestIntro = OnboardingBlockingTestIntro.INSTANCE;
            boolean zI = ((i5 & 14) == 4) | composerK.I(navHostControllerB) | ((i5 & 112) == 32);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: e1.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OnboardingBlockingTestKt.m(f3, navHostControllerB, onContinueClicked, (NavGraphBuilder) obj);
                    }
                };
                composerK.w(objG);
            }
            composer2 = composerK;
            NavHostKt.u(navHostControllerB, onboardingBlockingTestIntro, null, null, null, null, null, null, null, null, null, (Function1) objG, composer2, 0, 0, 2044);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: e1.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingBlockingTestKt.t(f3, onContinueClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(final float f3, final NavHostController navHostController, final Function0 function0, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        ComposableLambda composableLambdaC = ComposableLambdaKt.c(308660888, true, new Function4() { // from class: e1.l
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingBlockingTestKt.n(f3, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(OnboardingBlockingTestIntro.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC);
        ComposableLambda composableLambdaC2 = ComposableLambdaKt.c(2131395969, true, new Function4() { // from class: e1.c
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return OnboardingBlockingTestKt.q(f3, function0, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(OnboardingBlockingTestScreen.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC2);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(float f3, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(308660888, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.blockingtest.OnboardingBlockingTest.<anonymous>.<anonymous>.<anonymous> (OnboardingBlockingTest.kt:39)");
        }
        u(null, f3, null, ComposableLambdaKt.e(-290890840, true, new Function3() { // from class: e1.b
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return OnboardingBlockingTestKt.o(navHostController, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 3456, 1);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(final NavHostController navHostController, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-290890840, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.blockingtest.OnboardingBlockingTest.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OnboardingBlockingTest.kt:43)");
            }
            boolean zI = composer.I(navHostController);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: e1.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OnboardingBlockingTestKt.p(navHostController);
                    }
                };
                composer.w(objG);
            }
            OnboardingBlockingTestIntroKt.c((Function0) objG, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(NavHostController navHostController) {
        NavController.O(navHostController, OnboardingBlockingTestScreen.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(float f3, final Function0 function0, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(2131395969, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.blockingtest.OnboardingBlockingTest.<anonymous>.<anonymous>.<anonymous> (OnboardingBlockingTest.kt:52)");
        }
        u(null, f3, null, ComposableLambdaKt.e(1487803025, true, new Function3() { // from class: e1.d
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return OnboardingBlockingTestKt.r(function0, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 3456, 1);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(final Function0 function0, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1487803025, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.blockingtest.OnboardingBlockingTest.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OnboardingBlockingTest.kt:56)");
            }
            CompositionLocalKt.b(CompositionLocalsKt.f().d(DensityKt.a(((Density) composer.q(CompositionLocalsKt.f())).getDensity(), 1.0f)), ComposableLambdaKt.e(1410467281, true, new Function2() { // from class: e1.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingBlockingTestKt.s(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.f24012i | 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1410467281, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.blockingtest.OnboardingBlockingTest.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OnboardingBlockingTest.kt:63)");
            }
            OnboardingBlockingTestScreenKt.G(function0, composer, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(float f3, Function0 function0, int i3, Composer composer, int i4) {
        l(f3, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void u(String str, final float f3, final Function0 function0, final Function3 content, Composer composer, final int i3, final int i4) {
        int i5;
        Function0 function02;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerK = composer.k(-1514805845);
        if ((i3 & 48) == 0) {
            i5 = (composerK.c(f3) ? 32 : 16) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 384) == 0) {
            function02 = function0;
            i5 |= composerK.I(function02) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            function02 = function0;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.I(content) ? 2048 : 1024;
        }
        if (composerK.r((i5 & 1169) != 1168, i5 & 1)) {
            if ((i4 & 1) != 0) {
                str = null;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-1514805845, i5, -1, "cz.mobilesoft.coreblock.scene.onboarding.blockingtest.OnboardingBlockingTestGenericScreen (OnboardingBlockingTest.kt:79)");
            }
            ComposeBackgroundKt.w(null, Float.valueOf(f3), function02, ComposableLambdaKt.e(-523378064, true, new Function3() { // from class: e1.g
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OnboardingBlockingTestKt.v(content, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), null, composerK, (i5 & 112) | 27648 | (i5 & 896), 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        final String str2 = str;
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: e1.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingBlockingTestKt.x(str2, f3, function0, content, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(final Function3 function3, BoxScope GradientOnboardingBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientOnboardingBox, "$this$GradientOnboardingBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-523378064, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.blockingtest.OnboardingBlockingTestGenericScreen.<anonymous> (OnboardingBlockingTest.kt:84)");
            }
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.c(WindowInsets.f7172a, composer, 6)), null, null, null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, Color.f25715b.j(), 0L, ComposableLambdaKt.e(1490739698, true, new Function3() { // from class: e1.i
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OnboardingBlockingTestKt.w(function3, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
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
    public static final Unit w(Function3 function3, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1490739698, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.blockingtest.OnboardingBlockingTestGenericScreen.<anonymous>.<anonymous> (OnboardingBlockingTest.kt:88)");
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
    public static final Unit x(String str, float f3, Function0 function0, Function3 function3, int i3, int i4, Composer composer, int i5) {
        u(str, f3, function0, function3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
