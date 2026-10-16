package cz.mobilesoft.coreblock.scene.premium.components;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.valentinilk.shimmer.Shimmer;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenKt;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewEvent;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
import cz.mobilesoft.coreblock.scene.premium.ProductPlanPremiumScreenKt;
import cz.mobilesoft.coreblock.scene.premium.host.MySubscriptionPaywallViewModel;
import cz.mobilesoft.coreblock.usecase.YearlySavingsData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

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
public final class MySubscriptionPaywallContentKt {
    public static final void i(PaddingValues paddingValues, final PremiumScreenViewState viewState, final Shimmer shimmerInstance, final Function0 onClosedOrSkipped, final Function1 onEvent, Composer composer, final int i3) {
        int i4;
        PaddingValues paddingValues2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(shimmerInstance, "shimmerInstance");
        Intrinsics.checkNotNullParameter(onClosedOrSkipped, "onClosedOrSkipped");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(-1252324274);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(viewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= (i3 & 512) == 0 ? composerK.Z(shimmerInstance) : composerK.I(shimmerInstance) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onClosedOrSkipped) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(onEvent) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1252324274, i4, -1, "cz.mobilesoft.coreblock.scene.premium.components.MySubscriptionPaywallContent (MySubscriptionPaywallContent.kt:53)");
            }
            PremiumScreenViewState.PremiumScreenTypeViewState premiumScreenTypeViewStateX = viewState.x();
            final MySubscriptionPaywallViewModel.ProductPlanScreenTypeViewState productPlanScreenTypeViewState = premiumScreenTypeViewStateX instanceof MySubscriptionPaywallViewModel.ProductPlanScreenTypeViewState ? (MySubscriptionPaywallViewModel.ProductPlanScreenTypeViewState) premiumScreenTypeViewStateX : null;
            paddingValues2 = paddingValues;
            PremiumScreenKt.n(paddingValues2, ComposableLambdaKt.e(-1119168169, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.z0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MySubscriptionPaywallContentKt.j(viewState, onClosedOrSkipped, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), ComposableLambdaKt.e(1410969192, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.components.a1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MySubscriptionPaywallContentKt.k(viewState, shimmerInstance, onEvent, productPlanScreenTypeViewState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), ComposableSingletons$MySubscriptionPaywallContentKt.f112542a.e(), composerK, (i4 & 14) | 3504, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            paddingValues2 = paddingValues;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final PaddingValues paddingValues3 = paddingValues2;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.b1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MySubscriptionPaywallContentKt.q(paddingValues3, viewState, shimmerInstance, onClosedOrSkipped, onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(PremiumScreenViewState premiumScreenViewState, Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1119168169, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.MySubscriptionPaywallContent.<anonymous> (MySubscriptionPaywallContent.kt:59)");
            }
            PremiumTitleAndSubtitleKt.i(premiumScreenViewState.m(), function0, composer, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(final PremiumScreenViewState premiumScreenViewState, Shimmer shimmer, final Function1 function1, final MySubscriptionPaywallViewModel.ProductPlanScreenTypeViewState productPlanScreenTypeViewState, ColumnScope PremiumScreen, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(PremiumScreen, "$this$PremiumScreen");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(PremiumScreen) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1410969192, i4, -1, "cz.mobilesoft.coreblock.scene.premium.components.MySubscriptionPaywallContent.<anonymous> (MySubscriptionPaywallContent.kt:65)");
            }
            PremiumTitleAndSubtitleKt.e(premiumScreenViewState, true, false, false, false, shimmer, null, composer, (Shimmer.f93784d << 15) | 48, 92);
            PremiumScreenKt.p(PremiumScreen, premiumScreenViewState, function1, ComposableLambdaKt.e(-934768419, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.components.c1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MySubscriptionPaywallContentKt.l(premiumScreenViewState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), ComposableLambdaKt.e(894437918, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.components.d1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MySubscriptionPaywallContentKt.m(productPlanScreenTypeViewState, function1, premiumScreenViewState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, (i4 & 14) | 27648, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(PremiumScreenViewState premiumScreenViewState, ColumnScope PremiumScreenContent, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(PremiumScreenContent, "$this$PremiumScreenContent");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-934768419, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.MySubscriptionPaywallContent.<anonymous>.<anonymous> (MySubscriptionPaywallContent.kt:75)");
            }
            PremiumScreenKt.C(premiumScreenViewState.Y() && !premiumScreenViewState.n(), premiumScreenViewState.Q(), false, premiumScreenViewState.W(), composer, 0, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(MySubscriptionPaywallViewModel.ProductPlanScreenTypeViewState productPlanScreenTypeViewState, final Function1 function1, PremiumScreenViewState premiumScreenViewState, ColumnScope PremiumScreenContent, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(PremiumScreenContent, "$this$PremiumScreenContent");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(894437918, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.MySubscriptionPaywallContent.<anonymous>.<anonymous> (MySubscriptionPaywallContent.kt:82)");
            }
            if (productPlanScreenTypeViewState == null) {
                composer.a0(223032151);
                composer.U();
            } else {
                composer.a0(223032152);
                Modifier.Companion companion = Modifier.b8;
                Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
                MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.g(), composer, 48);
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
                Updater.e(composerA, measurePolicyA, companion2.e());
                Updater.e(composerA, compositionLocalMapU, companion2.g());
                Function2 function2B = companion2.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF, companion2.f());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
                float f3 = 32;
                SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
                ProductPlanPremiumScreenKt.k(composer, 0);
                SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
                List listJ = productPlanScreenTypeViewState.j();
                boolean zM = productPlanScreenTypeViewState.m();
                boolean Z = composer.Z(function1);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.components.e1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MySubscriptionPaywallContentKt.n(function1);
                        }
                    };
                    composer.w(objG);
                }
                ProductPlanPremiumScreenKt.q(listJ, zM, (Function0) objG, composer, 0, 0);
                YearlySavingsData yearlySavingsDataN = productPlanScreenTypeViewState.n();
                if (yearlySavingsDataN == null) {
                    composer.a0(1009298463);
                } else {
                    composer.a0(1009298464);
                    SpacerKt.a(SizeKt.i(companion, Dp.g(16)), composer, 6);
                    boolean Z2 = composer.Z(function1);
                    Object objG2 = composer.G();
                    if (Z2 || objG2 == Composer.f23746a.a()) {
                        objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.components.f1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MySubscriptionPaywallContentKt.o(function1);
                            }
                        };
                        composer.w(objG2);
                    }
                    ProductPlanPremiumScreenKt.z(yearlySavingsDataN, (Function0) objG2, composer, 0);
                }
                composer.U();
                if (premiumScreenViewState.f()) {
                    composer.a0(1009907893);
                    SpacerKt.a(SizeKt.i(companion, Dp.g(16)), composer, 6);
                    String strK = productPlanScreenTypeViewState.k();
                    boolean Z3 = composer.Z(function1);
                    Object objG3 = composer.G();
                    if (Z3 || objG3 == Composer.f23746a.a()) {
                        objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.components.g1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MySubscriptionPaywallContentKt.p(function1);
                            }
                        };
                        composer.w(objG3);
                    }
                    ProductPlanPremiumScreenKt.u(strK, (Function0) objG3, composer, 0);
                } else {
                    composer.a0(1004326715);
                }
                composer.U();
                composer.y();
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
    public static final Unit n(Function1 function1) {
        function1.invoke(PremiumScreenViewEvent.OnOtherOptionsClicked.f112355a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Function1 function1) {
        function1.invoke(PremiumScreenViewEvent.OnOtherOptionsClicked.f112355a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Function1 function1) {
        function1.invoke(PremiumScreenViewEvent.ManageSubscriptionClicked.f112350a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(PaddingValues paddingValues, PremiumScreenViewState premiumScreenViewState, Shimmer shimmer, Function0 function0, Function1 function1, int i3, Composer composer, int i4) {
        i(paddingValues, premiumScreenViewState, shimmer, function0, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
