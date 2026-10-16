package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.Color;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class IntroEligibilityStateViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void IntroEligibilityPreviewBothTextsEligibleMultipleOffers(Composer composer, final int i3) {
        Composer composerK = composer.k(-420223294);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-420223294, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityPreviewBothTextsEligibleMultipleOffers (IntroEligibilityStateView.kt:152)");
            }
            m892IntroEligibilityStateViewQETHhvg("$3.99/mo", "7 day trial, then $3.99/mo", "7 days for free, then $1.99 for your first month, and just $4.99/mo thereafter.", OfferEligibility.IntroOfferMultiple.INSTANCE, Color.f25715b.a(), null, null, null, false, null, composerK, 28086, 992);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityStateViewKt.IntroEligibilityPreviewBothTextsEligibleMultipleOffers.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    IntroEligibilityStateViewKt.IntroEligibilityPreviewBothTextsEligibleMultipleOffers(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void IntroEligibilityPreviewBothTextsEligibleSingleOffer(Composer composer, final int i3) {
        Composer composerK = composer.k(1448735195);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1448735195, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityPreviewBothTextsEligibleSingleOffer (IntroEligibilityStateView.kt:140)");
            }
            m892IntroEligibilityStateViewQETHhvg("$3.99/mo", "7 day trial, then $3.99/mo", "7 days for free, then $1.99 for your first month, and just $3.99/mo thereafter.", OfferEligibility.IntroOfferSingle.INSTANCE, Color.f25715b.a(), null, null, null, false, null, composerK, 28086, 992);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityStateViewKt.IntroEligibilityPreviewBothTextsEligibleSingleOffer.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    IntroEligibilityStateViewKt.IntroEligibilityPreviewBothTextsEligibleSingleOffer(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void IntroEligibilityPreviewBothTextsIneligible(Composer composer, final int i3) {
        Composer composerK = composer.k(170689540);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(170689540, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityPreviewBothTextsIneligible (IntroEligibilityStateView.kt:128)");
            }
            m892IntroEligibilityStateViewQETHhvg("$3.99/mo", "7 day trial, then $3.99/mo", "7 days for free, then $1.99 for your first month, and just $4.99/mo thereafter.", OfferEligibility.Ineligible.INSTANCE, Color.f25715b.a(), null, null, null, false, null, composerK, 28086, 992);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityStateViewKt.IntroEligibilityPreviewBothTextsIneligible.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    IntroEligibilityStateViewKt.IntroEligibilityPreviewBothTextsIneligible(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void IntroEligibilityPreviewNoOffer(Composer composer, final int i3) {
        Composer composerK = composer.k(-255198870);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-255198870, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityPreviewNoOffer (IntroEligibilityStateView.kt:116)");
            }
            m892IntroEligibilityStateViewQETHhvg("$3.99/mo", null, null, OfferEligibility.IntroOfferSingle.INSTANCE, Color.f25715b.a(), null, null, null, false, null, composerK, 28086, 992);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityStateViewKt.IntroEligibilityPreviewNoOffer.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    IntroEligibilityStateViewKt.IntroEligibilityPreviewNoOffer(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:155:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x010e  */
    /* JADX INFO: renamed from: IntroEligibilityStateView-QETHhvg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m892IntroEligibilityStateViewQETHhvg(final java.lang.String r20, final java.lang.String r21, final java.lang.String r22, final com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility r23, long r24, androidx.compose.ui.text.TextStyle r26, androidx.compose.ui.text.font.FontWeight r27, androidx.compose.ui.text.style.TextAlign r28, boolean r29, androidx.compose.ui.Modifier r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instruction units count: 561
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.composables.IntroEligibilityStateViewKt.m892IntroEligibilityStateViewQETHhvg(java.lang.String, java.lang.String, java.lang.String, com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility, long, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.style.TextAlign, boolean, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final String introEligibilityText(OfferEligibility eligibility, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(eligibility, "eligibility");
        if (Intrinsics.areEqual(eligibility, OfferEligibility.IntroOfferSingle.INSTANCE) ? true : Intrinsics.areEqual(eligibility, OfferEligibility.PromoOfferSingle.INSTANCE)) {
            str2 = str;
        } else {
            if (!(Intrinsics.areEqual(eligibility, OfferEligibility.IntroOfferMultiple.INSTANCE) ? true : Intrinsics.areEqual(eligibility, OfferEligibility.PromoOfferMultiple.INSTANCE))) {
                if (!(Intrinsics.areEqual(eligibility, OfferEligibility.Ineligible.INSTANCE) ? true : Intrinsics.areEqual(eligibility, OfferEligibility.PromoOfferIneligible.INSTANCE))) {
                    throw new NoWhenBranchMatchedException();
                }
                str2 = str3;
            }
        }
        return str2 == null ? str3 == null ? str == null ? "" : str : str3 : str2;
    }
}
