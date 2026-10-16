package cz.mobilesoft.coreblock.scene.premium.components;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.valentinilk.shimmer.Shimmer;
import cz.mobilesoft.coreblock.rest.response.CampaignOfferResponse;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenKt;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
import cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO;
import cz.mobilesoft.coreblock.scene.premium.host.CampaignPaywallViewModel;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallLayout;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.view.compose.GradientTextKt;
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
public final class IllustratedPaywallContentKt {
    public static final void g(PaddingValues paddingValues, final PremiumScreenViewState viewState, final Shimmer shimmerInstance, final Function0 onClosedOrSkipped, final Function1 onEvent, final PaywallLayout.Illustrated layout, Composer composer, final int i3) {
        int i4;
        PaddingValues paddingValues2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(shimmerInstance, "shimmerInstance");
        Intrinsics.checkNotNullParameter(onClosedOrSkipped, "onClosedOrSkipped");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(layout, "layout");
        Composer composerK = composer.k(-1687653205);
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
        if ((196608 & i3) == 0) {
            i4 |= composerK.Z(layout) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if (composerK.r((74899 & i4) != 74898, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1687653205, i4, -1, "cz.mobilesoft.coreblock.scene.premium.components.IllustratedPaywallContent (IllustratedPaywallContent.kt:44)");
            }
            paddingValues2 = paddingValues;
            PremiumScreenKt.r(paddingValues2, ComposableLambdaKt.e(22704350, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.i0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IllustratedPaywallContentKt.h(viewState, onClosedOrSkipped, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), ComposableLambdaKt.e(-1686719697, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.components.j0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return IllustratedPaywallContentKt.i(viewState, layout, shimmerInstance, onEvent, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), ComposableLambdaKt.e(-84461879, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.components.k0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return IllustratedPaywallContentKt.l(viewState, layout, onClosedOrSkipped, onEvent, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.l0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IllustratedPaywallContentKt.m(paddingValues3, viewState, shimmerInstance, onClosedOrSkipped, onEvent, layout, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(PremiumScreenViewState premiumScreenViewState, Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(22704350, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.IllustratedPaywallContent.<anonymous> (IllustratedPaywallContent.kt:48)");
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
    public static final Unit i(final PremiumScreenViewState premiumScreenViewState, final PaywallLayout.Illustrated illustrated, Shimmer shimmer, Function1 function1, ColumnScope PremiumScreenWithIllustration, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(PremiumScreenWithIllustration, "$this$PremiumScreenWithIllustration");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(PremiumScreenWithIllustration) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1686719697, i4, -1, "cz.mobilesoft.coreblock.scene.premium.components.IllustratedPaywallContent.<anonymous> (IllustratedPaywallContent.kt:54)");
            }
            PremiumTitleAndSubtitleKt.e(premiumScreenViewState, false, true, premiumScreenViewState.e() instanceof Loading, illustrated.f(), shimmer, ComposableLambdaKt.e(-746445172, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.m0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IllustratedPaywallContentKt.j(illustrated, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, (Shimmer.f93784d << 15) | 1573248, 2);
            PremiumScreenKt.p(PremiumScreenWithIllustration, premiumScreenViewState, function1, null, ComposableLambdaKt.e(1894367845, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.components.n0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return IllustratedPaywallContentKt.k(premiumScreenViewState, illustrated, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
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
    public static final Unit j(PaywallLayout.Illustrated illustrated, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-746445172, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.IllustratedPaywallContent.<anonymous>.<anonymous> (IllustratedPaywallContent.kt:63)");
            }
            Integer numA = illustrated.a();
            if (numA == null) {
                composer.a0(1992583843);
                composer.U();
            } else {
                composer.a0(1992583844);
                GradientTextKt.e(StringResources_androidKt.b(numA.intValue(), composer, 0), 0.0f, ComposeTypographyKt.g(composer, 0).g(), composer, 0, 2);
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
    public static final Unit k(PremiumScreenViewState premiumScreenViewState, PaywallLayout.Illustrated illustrated, ColumnScope PremiumScreenContent, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(PremiumScreenContent, "$this$PremiumScreenContent");
        if ((i3 & 6) == 0) {
            i4 = (composer.Z(PremiumScreenContent) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1894367845, i4, -1, "cz.mobilesoft.coreblock.scene.premium.components.IllustratedPaywallContent.<anonymous>.<anonymous> (IllustratedPaywallContent.kt:72)");
            }
            Modifier modifierB = ColumnScope.b(PremiumScreenContent, Modifier.b8, 1.0f, false, 2, null);
            String strN = n(premiumScreenViewState);
            PremiumOptionDTO premiumOptionDTOD = premiumScreenViewState.D();
            Long lB = premiumScreenViewState.B();
            if (!illustrated.c()) {
                lB = null;
            }
            boolean zF = premiumScreenViewState.F();
            Integer numG = premiumScreenViewState.g();
            if (illustrated.b()) {
                numG = null;
            }
            PremiumIllustratedLayoutKt.k(modifierB, strN, premiumOptionDTOD, lB, zF, numG, illustrated.b() ? premiumScreenViewState.g() : null, composer, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(PremiumScreenViewState premiumScreenViewState, PaywallLayout.Illustrated illustrated, Function0 function0, Function1 function1, Modifier offerExplanationModifier, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(offerExplanationModifier, "offerExplanationModifier");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(offerExplanationModifier) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-84461879, i4, -1, "cz.mobilesoft.coreblock.scene.premium.components.IllustratedPaywallContent.<anonymous> (IllustratedPaywallContent.kt:87)");
            }
            PremiumFooterKt.h(premiumScreenViewState, false, illustrated.d(), false, false, illustrated.e(), null, function0, function1, offerExplanationModifier, false, composer, (i4 << 27) & 1879048192, 0, 1114);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(PaddingValues paddingValues, PremiumScreenViewState premiumScreenViewState, Shimmer shimmer, Function0 function0, Function1 function1, PaywallLayout.Illustrated illustrated, int i3, Composer composer, int i4) {
        g(paddingValues, premiumScreenViewState, shimmer, function0, function1, illustrated, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final String n(PremiumScreenViewState premiumScreenViewState) {
        CampaignOfferResponse campaignOfferResponseJ;
        PremiumScreenViewState.PremiumScreenTypeViewState premiumScreenTypeViewStateX = premiumScreenViewState.x();
        CampaignPaywallViewModel.CampaignScreenTypeViewState campaignScreenTypeViewState = premiumScreenTypeViewStateX instanceof CampaignPaywallViewModel.CampaignScreenTypeViewState ? (CampaignPaywallViewModel.CampaignScreenTypeViewState) premiumScreenTypeViewStateX : null;
        if (campaignScreenTypeViewState == null || (campaignOfferResponseJ = campaignScreenTypeViewState.j()) == null) {
            return null;
        }
        return campaignOfferResponseJ.getImagePath();
    }
}
