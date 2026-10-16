package cz.mobilesoft.coreblock.scene.premium.premium_expiring;

import android.app.Activity;
import android.content.Context;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
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
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.TrialSummaryData;
import cz.mobilesoft.coreblock.scene.insights.trial_summary.TrialSummaryScreenKt;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewEvent;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
import cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO;
import cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringActivity;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class PremiumExpiringScreenKt {
    private static final void B(final NavHostController navHostController, final PaddingValues paddingValues, final PremiumExpiringViewState premiumExpiringViewState, final PremiumScreenViewState premiumScreenViewState, final Function1 function1, final Function0 function0, Composer composer, final int i3) {
        int i4;
        PremiumExpiringViewState premiumExpiringViewState2;
        PremiumScreenViewState premiumScreenViewState2;
        Function1 function12;
        NavDestination navDestinationD;
        Composer composerK = composer.k(364762609);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(navHostController) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(paddingValues) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            premiumExpiringViewState2 = premiumExpiringViewState;
            i4 |= composerK.Z(premiumExpiringViewState2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            premiumExpiringViewState2 = premiumExpiringViewState;
        }
        if ((i3 & 3072) == 0) {
            premiumScreenViewState2 = premiumScreenViewState;
            i4 |= composerK.Z(premiumScreenViewState2) ? 2048 : 1024;
        } else {
            premiumScreenViewState2 = premiumScreenViewState;
        }
        if ((i3 & 24576) == 0) {
            function12 = function1;
            i4 |= composerK.I(function12) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            function12 = function1;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(function0) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        int i5 = i4;
        if (composerK.r((74899 & i5) != 74898, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(364762609, i5, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.NavHost (PremiumExpiringScreen.kt:315)");
            }
            final Integer numC = premiumExpiringViewState2.c();
            Object objG = composerK.G();
            String strT = null;
            if (objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
                composerK.w(objG);
            }
            MutableState mutableState = (MutableState) objG;
            NavBackStackEntry navBackStackEntryE = E(NavHostControllerKt.a(navHostController, composerK, i5 & 14));
            if (navBackStackEntryE != null && (navDestinationD = navBackStackEntryE.d()) != null) {
                strT = navDestinationD.t();
            }
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            listCreateListBuilder.add(PremiumExpiringActivity.PremiumExpiringScreen.Intro);
            if (premiumExpiringViewState2.g() != null) {
                listCreateListBuilder.add(PremiumExpiringActivity.PremiumExpiringScreen.Summary);
                listCreateListBuilder.add(PremiumExpiringActivity.PremiumExpiringScreen.BlockSessions);
            }
            listCreateListBuilder.add(PremiumExpiringActivity.PremiumExpiringScreen.Features);
            if (!premiumExpiringViewState2.e().isEmpty()) {
                listCreateListBuilder.add(PremiumExpiringActivity.PremiumExpiringScreen.Blocking);
            }
            listCreateListBuilder.add(PremiumExpiringActivity.PremiumExpiringScreen.Savings);
            listCreateListBuilder.add(PremiumExpiringActivity.PremiumExpiringScreen.Purchase);
            List listBuild = CollectionsKt.build(listCreateListBuilder);
            D(mutableState, Float.valueOf((RangesKt.f(listBuild.indexOf(PremiumExpiringActivity.PremiumExpiringScreen.Companion.a(strT)), 0) + 1) / listBuild.size()));
            final PremiumExpiringViewState premiumExpiringViewState3 = premiumExpiringViewState2;
            final PremiumScreenViewState premiumScreenViewState3 = premiumScreenViewState2;
            final Function1 function13 = function12;
            ComposeBackgroundKt.s(PaddingKt.h(Modifier.b8, paddingValues), null, C(mutableState), function0, ComposableLambdaKt.e(250444409, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.l1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PremiumExpiringScreenKt.F(navHostController, numC, premiumExpiringViewState3, premiumScreenViewState3, function13, function0, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, ((i5 >> 6) & 7168) | 24576, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.m1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PremiumExpiringScreenKt.U(navHostController, paddingValues, premiumExpiringViewState, premiumScreenViewState, function1, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final Float C(MutableState mutableState) {
        return (Float) mutableState.getValue();
    }

    private static final void D(MutableState mutableState, Float f3) {
        mutableState.setValue(f3);
    }

    private static final NavBackStackEntry E(State state) {
        return (NavBackStackEntry) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(final NavHostController navHostController, final Integer num, final PremiumExpiringViewState premiumExpiringViewState, final PremiumScreenViewState premiumScreenViewState, final Function1 function1, final Function0 function0, BoxScope GradientBoxWithProgress, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBoxWithProgress, "$this$GradientBoxWithProgress");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(250444409, i3, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.NavHost.<anonymous> (PremiumExpiringScreen.kt:345)");
            }
            String route = PremiumExpiringActivity.PremiumExpiringScreen.Intro.getRoute();
            boolean Z = composer.Z(num) | composer.Z(premiumExpiringViewState) | composer.I(navHostController) | composer.Z(premiumScreenViewState) | composer.Z(function1) | composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.n1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PremiumExpiringScreenKt.G(num, premiumExpiringViewState, navHostController, premiumScreenViewState, function1, function0, (NavGraphBuilder) obj);
                    }
                };
                composer.w(objG);
            }
            NavHostKt.v(navHostController, route, null, null, null, null, null, null, null, null, (Function1) objG, composer, 48, 0, 1020);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(final Integer num, final PremiumExpiringViewState premiumExpiringViewState, final NavHostController navHostController, final PremiumScreenViewState premiumScreenViewState, final Function1 function1, final Function0 function0, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        NavGraphBuilderKt.c(NavHost, PremiumExpiringActivity.PremiumExpiringScreen.Intro.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1258707492, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.p1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return PremiumExpiringScreenKt.H(num, premiumExpiringViewState, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, PremiumExpiringActivity.PremiumExpiringScreen.Summary.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(1331947155, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.q1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return PremiumExpiringScreenKt.J(premiumExpiringViewState, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, PremiumExpiringActivity.PremiumExpiringScreen.BlockSessions.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1330122412, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.r1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return PremiumExpiringScreenKt.L(premiumExpiringViewState, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, PremiumExpiringActivity.PremiumExpiringScreen.Features.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(302775317, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.s1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return PremiumExpiringScreenKt.N(num, premiumExpiringViewState, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, PremiumExpiringActivity.PremiumExpiringScreen.Blocking.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(1935673046, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.t1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return PremiumExpiringScreenKt.P(premiumExpiringViewState, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, PremiumExpiringActivity.PremiumExpiringScreen.Savings.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-726396521, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.u1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return PremiumExpiringScreenKt.R(premiumScreenViewState, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, PremiumExpiringActivity.PremiumExpiringScreen.Purchase.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(906501208, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.v1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return PremiumExpiringScreenKt.T(premiumScreenViewState, function1, function0, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(Integer num, final PremiumExpiringViewState premiumExpiringViewState, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1258707492, i3, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.NavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PremiumExpiringScreen.kt:351)");
        }
        boolean Z = composer.Z(premiumExpiringViewState) | composer.I(navHostController);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.d1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PremiumExpiringScreenKt.I(premiumExpiringViewState, navHostController);
                }
            };
            composer.w(objG);
        }
        PremiumExpiringIntroScreenKt.c(num, (Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(PremiumExpiringViewState premiumExpiringViewState, NavHostController navHostController) {
        AnswersHelper.f128199a.R3();
        if (premiumExpiringViewState.g() != null) {
            NavController.P(navHostController, PremiumExpiringActivity.PremiumExpiringScreen.Summary.getRoute(), null, null, 6, null);
        } else {
            NavController.P(navHostController, PremiumExpiringActivity.PremiumExpiringScreen.Features.getRoute(), null, null, 6, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(PremiumExpiringViewState premiumExpiringViewState, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1331947155, i3, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.NavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PremiumExpiringScreen.kt:364)");
        }
        TrialSummaryData trialSummaryDataG = premiumExpiringViewState.g();
        if (trialSummaryDataG == null) {
            composer.a0(-1165095106);
        } else {
            composer.a0(-1165095105);
            String strB = StringResources_androidKt.b(R.string.l8, composer, 0);
            boolean zI = composer.I(navHostController);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.o1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PremiumExpiringScreenKt.K(navHostController);
                    }
                };
                composer.w(objG);
            }
            TrialSummaryScreenKt.w(trialSummaryDataG, strB, (Function0) objG, composer, 0);
        }
        composer.U();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(NavHostController navHostController) {
        NavController.P(navHostController, PremiumExpiringActivity.PremiumExpiringScreen.BlockSessions.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(PremiumExpiringViewState premiumExpiringViewState, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1330122412, i3, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.NavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PremiumExpiringScreen.kt:376)");
        }
        TrialSummaryData trialSummaryDataG = premiumExpiringViewState.g();
        if (trialSummaryDataG == null) {
            composer.a0(-308444901);
        } else {
            composer.a0(-308444900);
            String strB = StringResources_androidKt.b(R.string.l8, composer, 0);
            boolean zI = composer.I(navHostController);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.y1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PremiumExpiringScreenKt.M(navHostController);
                    }
                };
                composer.w(objG);
            }
            TrialSummaryScreenKt.l(trialSummaryDataG, strB, (Function0) objG, composer, 0);
        }
        composer.U();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(NavHostController navHostController) {
        NavController.P(navHostController, PremiumExpiringActivity.PremiumExpiringScreen.Features.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(Integer num, final PremiumExpiringViewState premiumExpiringViewState, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(302775317, i3, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.NavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PremiumExpiringScreen.kt:388)");
        }
        boolean Z = composer.Z(premiumExpiringViewState) | composer.I(navHostController);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.w1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PremiumExpiringScreenKt.O(premiumExpiringViewState, navHostController);
                }
            };
            composer.w(objG);
        }
        PremiumExpiringFeaturesScreenKt.c(num, (Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(PremiumExpiringViewState premiumExpiringViewState, NavHostController navHostController) {
        if (premiumExpiringViewState.e().isEmpty()) {
            AnswersHelper.f128199a.V3();
            NavController.P(navHostController, PremiumExpiringActivity.PremiumExpiringScreen.Savings.getRoute(), null, null, 6, null);
        } else {
            AnswersHelper.f128199a.O3();
            NavController.P(navHostController, PremiumExpiringActivity.PremiumExpiringScreen.Blocking.getRoute(), null, null, 6, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(PremiumExpiringViewState premiumExpiringViewState, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1935673046, i3, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.NavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PremiumExpiringScreen.kt:402)");
        }
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.z1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PremiumExpiringScreenKt.Q(navHostController);
                }
            };
            composer.w(objG);
        }
        PremiumExpiringBlockingScreenKt.d(premiumExpiringViewState, (Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(NavHostController navHostController) {
        AnswersHelper.f128199a.V3();
        NavController.P(navHostController, PremiumExpiringActivity.PremiumExpiringScreen.Savings.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(PremiumScreenViewState premiumScreenViewState, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        String strA;
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-726396521, i3, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.NavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PremiumExpiringScreen.kt:411)");
        }
        PremiumOptionDTO premiumOptionDTOH = premiumScreenViewState.h();
        if (premiumOptionDTOH == null || (strA = premiumOptionDTOH.d()) == null) {
            PremiumOptionDTO premiumOptionDTOH2 = premiumScreenViewState.h();
            strA = premiumOptionDTOH2 != null ? premiumOptionDTOH2.a() : null;
        }
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.x1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PremiumExpiringScreenKt.S(navHostController);
                }
            };
            composer.w(objG);
        }
        PremiumExpiringSavingsScreenKt.c(strA, (Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(NavHostController navHostController) {
        NavController.P(navHostController, PremiumExpiringActivity.PremiumExpiringScreen.Purchase.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.Unit T(cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState r8, kotlin.jvm.functions.Function1 r9, kotlin.jvm.functions.Function0 r10, androidx.compose.animation.AnimatedContentScope r11, androidx.navigation.NavBackStackEntry r12, androidx.compose.runtime.Composer r13, int r14) {
        /*
            java.lang.String r0 = "$this$composable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r11 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r11)
            boolean r11 = androidx.compose.runtime.ComposerKt.M()
            if (r11 == 0) goto L19
            r11 = -1
            java.lang.String r12 = "cz.mobilesoft.coreblock.scene.premium.premium_expiring.NavHost.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PremiumExpiringScreen.kt:420)"
            r0 = 906501208(0x36081c58, float:2.0282077E-6)
            androidx.compose.runtime.ComposerKt.U(r0, r14, r11, r12)
        L19:
            cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO r8 = r8.h()
            r11 = 0
            if (r8 == 0) goto L25
            java.lang.String r12 = r8.d()
            goto L26
        L25:
            r12 = r11
        L26:
            if (r12 == 0) goto L2a
            r12 = 1
            goto L2b
        L2a:
            r12 = 0
        L2b:
            if (r12 == 0) goto L33
            java.lang.String r14 = r8.d()
        L31:
            r0 = r14
            goto L3b
        L33:
            if (r8 == 0) goto L3a
            java.lang.String r14 = r8.a()
            goto L31
        L3a:
            r0 = r11
        L3b:
            if (r12 == 0) goto L43
            java.lang.String r12 = r8.a()
            r4 = r12
            goto L44
        L43:
            r4 = r11
        L44:
            if (r8 == 0) goto L4a
            java.lang.String r11 = r8.i()
        L4a:
            r1 = r11
            r6 = 0
            r7 = 0
            r2 = r9
            r3 = r10
            r5 = r13
            cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringPurchaseScreenKt.f(r0, r1, r2, r3, r4, r5, r6, r7)
            boolean r8 = androidx.compose.runtime.ComposerKt.M()
            if (r8 == 0) goto L5c
            androidx.compose.runtime.ComposerKt.T()
        L5c:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringScreenKt.T(cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.animation.AnimatedContentScope, androidx.navigation.NavBackStackEntry, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(NavHostController navHostController, PaddingValues paddingValues, PremiumExpiringViewState premiumExpiringViewState, PremiumScreenViewState premiumScreenViewState, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        B(navHostController, paddingValues, premiumExpiringViewState, premiumScreenViewState, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:119:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void V(final java.lang.Integer r39, java.lang.String r40, final kotlin.jvm.functions.Function0 r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instruction units count: 1216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringScreenKt.V(java.lang.Integer, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(Integer num, String str, Function0 function0, int i3, int i4, Composer composer, int i5) {
        V(num, str, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void Y(PaddingValues paddingValues, PremiumExpiringViewState viewState, PremiumScreenViewState premiumViewState, Function1 onPremiumEvent, Function0 onClose, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        final Function1 function1;
        final PremiumScreenViewState premiumScreenViewState;
        final PremiumExpiringViewState premiumExpiringViewState;
        final PaddingValues paddingValues2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(premiumViewState, "premiumViewState");
        Intrinsics.checkNotNullParameter(onPremiumEvent, "onPremiumEvent");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Composer composerK = composer.k(-1343910568);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(viewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(premiumViewState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onPremiumEvent) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(onClose) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1343910568, i4, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringScreenFlow (PremiumExpiringScreen.kt:295)");
            }
            B(NavHostControllerKt.b(new Navigator[0], composerK, 0), paddingValues, viewState, premiumViewState, onPremiumEvent, onClose, composerK, (i4 << 3) & 524272);
            paddingValues2 = paddingValues;
            premiumExpiringViewState = viewState;
            premiumScreenViewState = premiumViewState;
            function1 = onPremiumEvent;
            function0 = onClose;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onClose;
            function1 = onPremiumEvent;
            premiumScreenViewState = premiumViewState;
            premiumExpiringViewState = viewState;
            paddingValues2 = paddingValues;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.j1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PremiumExpiringScreenKt.Z(paddingValues2, premiumExpiringViewState, premiumScreenViewState, function1, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(PaddingValues paddingValues, PremiumExpiringViewState premiumExpiringViewState, PremiumScreenViewState premiumScreenViewState, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        Y(paddingValues, premiumExpiringViewState, premiumScreenViewState, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void a0(final PaddingValues paddingValues, final PremiumExpiringViewState viewState, final PremiumScreenViewState premiumViewState, final Function1 onPremiumEvent, final Function0 onClose, Composer composer, final int i3) {
        int i4;
        String strA;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(premiumViewState, "premiumViewState");
        Intrinsics.checkNotNullParameter(onPremiumEvent, "onPremiumEvent");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Composer composerK = composer.k(-150899662);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(viewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(premiumViewState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onPremiumEvent) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(onClose) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-150899662, i4, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringScreenSingle (PremiumExpiringScreen.kt:59)");
            }
            Integer numC = viewState.c();
            int i5 = i4;
            String strD = viewState.d();
            PremiumOptionDTO premiumOptionDTOH = premiumViewState.h();
            if (premiumOptionDTOH == null || (strA = premiumOptionDTOH.d()) == null) {
                PremiumOptionDTO premiumOptionDTOH2 = premiumViewState.h();
                strA = premiumOptionDTOH2 != null ? premiumOptionDTOH2.a() : null;
            }
            c0(paddingValues, strD, numC, strA, onClose, onPremiumEvent, composerK, (57358 & i5) | ((i5 << 6) & 458752), 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.k1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PremiumExpiringScreenKt.b0(paddingValues, viewState, premiumViewState, onPremiumEvent, onClose, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(PaddingValues paddingValues, PremiumExpiringViewState premiumExpiringViewState, PremiumScreenViewState premiumScreenViewState, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        a0(paddingValues, premiumExpiringViewState, premiumScreenViewState, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c0(final androidx.compose.foundation.layout.PaddingValues r33, java.lang.String r34, final java.lang.Integer r35, final java.lang.String r36, final kotlin.jvm.functions.Function0 r37, final kotlin.jvm.functions.Function1 r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instruction units count: 597
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringScreenKt.c0(androidx.compose.foundation.layout.PaddingValues, java.lang.String, java.lang.Integer, java.lang.String, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(final Integer num, final String str, final Function0 function0, final String str2, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(1033801691, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.g1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return PremiumExpiringScreenKt.e0(num, str, function0, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        ComposableSingletons$PremiumExpiringScreenKt composableSingletons$PremiumExpiringScreenKt = ComposableSingletons$PremiumExpiringScreenKt.f113533a;
        LazyListScope.c(LazyColumn, null, null, composableSingletons$PremiumExpiringScreenKt.p(), 3, null);
        LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(2115585443, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.h1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return PremiumExpiringScreenKt.f0(num, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.c(LazyColumn, null, null, composableSingletons$PremiumExpiringScreenKt.m(), 3, null);
        LazyListScope.c(LazyColumn, null, null, composableSingletons$PremiumExpiringScreenKt.o(), 3, null);
        LazyListScope.c(LazyColumn, null, null, composableSingletons$PremiumExpiringScreenKt.s(), 3, null);
        LazyListScope.c(LazyColumn, null, null, composableSingletons$PremiumExpiringScreenKt.q(), 3, null);
        LazyListScope.c(LazyColumn, null, null, composableSingletons$PremiumExpiringScreenKt.n(), 3, null);
        LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(-156128547, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.i1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return PremiumExpiringScreenKt.g0(str2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.c(LazyColumn, null, null, composableSingletons$PremiumExpiringScreenKt.r(), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e0(Integer num, String str, Function0 function0, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1033801691, i3, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringScreenSingleContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PremiumExpiringScreen.kt:107)");
            }
            V(num, str, function0, composer, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(Integer num, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2115585443, i3, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringScreenSingleContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PremiumExpiringScreen.kt:117)");
            }
            if (num != null) {
                composer.a0(1055888881);
                j0(StringResources_androidKt.b(R.string.Zp, composer, 0), StringResources_androidKt.b(R.string.Yp, composer, 0), composer, 0);
                composer.U();
            } else {
                composer.a0(1056194355);
                j0(StringResources_androidKt.b(R.string.Xp, composer, 0), StringResources_androidKt.b(R.string.Wp, composer, 0), composer, 0);
                composer.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(String str, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-156128547, i3, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringScreenSingleContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PremiumExpiringScreen.kt:148)");
            }
            ComponentsKt.s(null, str, true, composer, 384, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(Context context, Function1 function1) {
        AnswersHelper.f128199a.X3();
        Activity activityB = ContextExtKt.b(context);
        if (activityB != null) {
            function1.invoke(new PremiumScreenViewEvent.OnPurchase(activityB, null, 2, null));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(PaddingValues paddingValues, String str, Integer num, String str2, Function0 function0, Function1 function1, int i3, int i4, Composer composer, int i5) {
        c0(paddingValues, str, num, str2, function0, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(final String str, String str2, Composer composer, final int i3) {
        int i4;
        final String str3;
        Composer composer2;
        Composer composerK = composer.k(934628430);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(str) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(str2) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(934628430, i4, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.TitleAndSubtitle (PremiumExpiringScreen.kt:266)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierK = PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(16), 0.0f, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierK);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            composer2 = composerK;
            TextKt.c(str, null, ComposeColorsKt.j(composerK, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).g(), composer2, i4 & 14, 0, 65530);
            SpacerKt.a(SizeKt.i(companion, Dp.g(12)), composer2, 6);
            str3 = str2;
            TextKt.c(str3, null, ComposeColorsKt.j(composer2, 0).P(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).a(), composer2, (i4 >> 3) & 14, 0, 65530);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            str3 = str2;
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.a2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PremiumExpiringScreenKt.k0(str, str3, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0(String str, String str2, int i3, Composer composer, int i4) {
        j0(str, str2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
