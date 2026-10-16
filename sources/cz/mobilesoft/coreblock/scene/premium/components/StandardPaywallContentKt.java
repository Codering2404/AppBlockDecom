package cz.mobilesoft.coreblock.scene.premium.components;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.valentinilk.shimmer.Shimmer;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenKt;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallLayout;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
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
public final class StandardPaywallContentKt {
    public static final void h(final PaddingValues paddingValues, final PremiumScreenViewState viewState, final Shimmer shimmerInstance, final boolean z2, final Function0 onClosedOrSkipped, final Function1 onEvent, final PaywallLayout.Standard layout, Composer composer, final int i3) {
        int i4;
        boolean z3;
        final PremiumScreenViewState premiumScreenViewState;
        final Function1 function1;
        Composer composer2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(shimmerInstance, "shimmerInstance");
        Intrinsics.checkNotNullParameter(onClosedOrSkipped, "onClosedOrSkipped");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(layout, "layout");
        Composer composerK = composer.k(627217485);
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
            z3 = z2;
            i4 |= composerK.b(z3) ? 2048 : 1024;
        } else {
            z3 = z2;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(onClosedOrSkipped) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(onEvent) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.Z(layout) ? 1048576 : 524288;
        }
        int i5 = i4;
        if (composerK.r((599187 & i5) != 599186, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(627217485, i5, -1, "cz.mobilesoft.coreblock.scene.premium.components.StandardPaywallContent (StandardPaywallContent.kt:47)");
            }
            final boolean z4 = z3;
            premiumScreenViewState = viewState;
            function1 = onEvent;
            composer2 = composerK;
            PremiumScreenKt.n(paddingValues, ComposableLambdaKt.e(-1683585820, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.t4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StandardPaywallContentKt.i(viewState, onClosedOrSkipped, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), ComposableLambdaKt.e(-1428737421, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.components.u4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StandardPaywallContentKt.j(viewState, layout, shimmerInstance, onEvent, z4, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), ComposableLambdaKt.e(-496608478, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.v4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StandardPaywallContentKt.m(layout, premiumScreenViewState, onClosedOrSkipped, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composer2, (i5 & 14) | 3504, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            premiumScreenViewState = viewState;
            function1 = onEvent;
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            final PremiumScreenViewState premiumScreenViewState2 = premiumScreenViewState;
            final Function1 function12 = function1;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.w4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StandardPaywallContentKt.n(paddingValues, premiumScreenViewState2, shimmerInstance, z2, onClosedOrSkipped, function12, layout, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(PremiumScreenViewState premiumScreenViewState, Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1683585820, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.StandardPaywallContent.<anonymous> (StandardPaywallContent.kt:51)");
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
    public static final Unit j(final PremiumScreenViewState premiumScreenViewState, final PaywallLayout.Standard standard, Shimmer shimmer, final Function1 function1, final boolean z2, ColumnScope PremiumScreen, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(PremiumScreen, "$this$PremiumScreen");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(PremiumScreen) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1428737421, i4, -1, "cz.mobilesoft.coreblock.scene.premium.components.StandardPaywallContent.<anonymous> (StandardPaywallContent.kt:57)");
            }
            PremiumTitleAndSubtitleKt.e(premiumScreenViewState, standard.f(), false, false, false, shimmer, null, composer, Shimmer.f93784d << 15, 92);
            PremiumScreenKt.p(PremiumScreen, premiumScreenViewState, function1, ComposableLambdaKt.e(307007774, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.components.x4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StandardPaywallContentKt.k(standard, premiumScreenViewState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), ComposableLambdaKt.e(-1695303555, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.components.y4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StandardPaywallContentKt.l(standard, premiumScreenViewState, z2, function1, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
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
    public static final Unit k(PaywallLayout.Standard standard, PremiumScreenViewState premiumScreenViewState, ColumnScope PremiumScreenContent, Composer composer, int i3) {
        Composer composer2;
        Intrinsics.checkNotNullParameter(PremiumScreenContent, "$this$PremiumScreenContent");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(307007774, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.StandardPaywallContent.<anonymous>.<anonymous> (StandardPaywallContent.kt:67)");
            }
            if (standard.a()) {
                composer.a0(2083286966);
                PremiumBenefitsCardKt.g(PaddingKt.m(PaddingKt.h(Modifier.b8, ComposableExtKt.i(composer, 0)), 0.0f, Dp.g(24), 0.0f, 0.0f, 13, null), composer, 0, 0);
            } else {
                composer.a0(2080148836);
            }
            composer.U();
            if (standard.e() && standard.b()) {
                composer.a0(2083686339);
                o(premiumScreenViewState, true, composer, 48);
            } else {
                composer.a0(2080148836);
            }
            composer.U();
            if (standard.c()) {
                composer.a0(2083934091);
                composer2 = composer;
                PremiumReviewsCarouselCardKt.q(premiumScreenViewState.C(), PaddingKt.m(Modifier.b8, 0.0f, Dp.g(16), 0.0f, 0.0f, 13, null), false, composer2, 48, 4);
            } else {
                composer2 = composer;
                composer2.a0(2080148836);
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
    public static final Unit l(PaywallLayout.Standard standard, PremiumScreenViewState premiumScreenViewState, boolean z2, Function1 function1, ColumnScope PremiumScreenContent, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(PremiumScreenContent, "$this$PremiumScreenContent");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1695303555, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.StandardPaywallContent.<anonymous>.<anonymous> (StandardPaywallContent.kt:88)");
            }
            if (standard.b()) {
                composer.a0(-267711215);
                PremiumOffersLayoutKt.w(premiumScreenViewState, null, null, false, z2, function1, composer, 0, 14);
                composer.U();
            } else {
                if (standard.e()) {
                    composer.a0(-267381685);
                    o(premiumScreenViewState, false, composer, 48);
                } else {
                    composer.a0(-271894107);
                }
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
    public static final Unit m(PaywallLayout.Standard standard, PremiumScreenViewState premiumScreenViewState, Function0 function0, Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-496608478, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.StandardPaywallContent.<anonymous> (StandardPaywallContent.kt:102)");
            }
            PremiumFooterKt.h(premiumScreenViewState, false, false, true, false, false, null, function0, function1, null, standard.d(), composer, 3072, 0, 630);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(PaddingValues paddingValues, PremiumScreenViewState premiumScreenViewState, Shimmer shimmer, boolean z2, Function0 function0, Function1 function1, PaywallLayout.Standard standard, int i3, Composer composer, int i4) {
        h(paddingValues, premiumScreenViewState, shimmer, z2, function0, function1, standard, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void o(final PremiumScreenViewState premiumScreenViewState, boolean z2, Composer composer, final int i3) {
        int i4;
        final boolean z3;
        Composer composerK = composer.k(1686611404);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(premiumScreenViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1686611404, i4, -1, "cz.mobilesoft.coreblock.scene.premium.components.TrialBlock (StandardPaywallContent.kt:114)");
            }
            z3 = z2;
            PremiumScreenKt.C(premiumScreenViewState.Y(), premiumScreenViewState.Q(), z3, premiumScreenViewState.W(), composerK, (i4 << 3) & 896, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            z3 = z2;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.z4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StandardPaywallContentKt.p(premiumScreenViewState, z3, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(PremiumScreenViewState premiumScreenViewState, boolean z2, int i3, Composer composer, int i4) {
        o(premiumScreenViewState, z2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
