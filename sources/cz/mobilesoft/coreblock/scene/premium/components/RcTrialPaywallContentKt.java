package cz.mobilesoft.coreblock.scene.premium.components;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenKt;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
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
public final class RcTrialPaywallContentKt {
    public static final void f(PaddingValues paddingValues, final PremiumScreenViewState viewState, final Function0 onClosedOrSkipped, final Function1 onEvent, Composer composer, final int i3) {
        int i4;
        PaddingValues paddingValues2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onClosedOrSkipped, "onClosedOrSkipped");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(528352079);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(viewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onClosedOrSkipped) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onEvent) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(528352079, i4, -1, "cz.mobilesoft.coreblock.scene.premium.components.RcTrialPaywallContent (RcTrialPaywallContent.kt:34)");
            }
            paddingValues2 = paddingValues;
            PremiumScreenKt.n(paddingValues2, ComposableLambdaKt.e(211631384, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.f4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RcTrialPaywallContentKt.g(viewState, onClosedOrSkipped, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), ComposableLambdaKt.e(-833538839, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.components.g4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RcTrialPaywallContentKt.h(viewState, onEvent, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), ComposableLambdaKt.e(-1573771878, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.h4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RcTrialPaywallContentKt.j(viewState, onEvent, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, (i4 & 14) | 3504, 0);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.i4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RcTrialPaywallContentKt.k(paddingValues3, viewState, onClosedOrSkipped, onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(PremiumScreenViewState premiumScreenViewState, Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(211631384, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.RcTrialPaywallContent.<anonymous> (RcTrialPaywallContent.kt:38)");
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
    public static final Unit h(final PremiumScreenViewState premiumScreenViewState, Function1 function1, ColumnScope PremiumScreen, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(PremiumScreen, "$this$PremiumScreen");
        if ((i3 & 6) == 0) {
            i4 = (composer.Z(PremiumScreen) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-833538839, i4, -1, "cz.mobilesoft.coreblock.scene.premium.components.RcTrialPaywallContent.<anonymous> (RcTrialPaywallContent.kt:44)");
            }
            RcTrialPremiumTitleAndSubtitleKt.c(premiumScreenViewState, null, composer, 0, 2);
            PremiumScreenKt.p(PremiumScreen, premiumScreenViewState, function1, null, ComposableLambdaKt.e(1489452319, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.components.j4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RcTrialPaywallContentKt.i(premiumScreenViewState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, (i4 & 14) | 24576, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(PremiumScreenViewState premiumScreenViewState, ColumnScope PremiumScreenContent, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(PremiumScreenContent, "$this$PremiumScreenContent");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1489452319, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.RcTrialPaywallContent.<anonymous>.<anonymous> (RcTrialPaywallContent.kt:53)");
            }
            RcTrialPremiumContentKt.b(premiumScreenViewState.C(), null, composer, 0, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(PremiumScreenViewState premiumScreenViewState, Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1573771878, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.RcTrialPaywallContent.<anonymous> (RcTrialPaywallContent.kt:58)");
            }
            RcTrialPremiumFooterKt.g(premiumScreenViewState, function1, null, composer, 0, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(PaddingValues paddingValues, PremiumScreenViewState premiumScreenViewState, Function0 function0, Function1 function1, int i3, Composer composer, int i4) {
        f(paddingValues, premiumScreenViewState, function0, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
