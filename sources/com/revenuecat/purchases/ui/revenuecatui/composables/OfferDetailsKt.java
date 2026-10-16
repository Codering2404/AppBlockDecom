package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import com.revenuecat.purchases.ui.revenuecatui.UIConstant;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallStateKt;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PackageExtensionsKt;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class OfferDetailsKt {
    /* JADX WARN: Removed duplicated region for block: B:41:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void OfferDetails(final com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Legacy r4, final com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.Colors r5, androidx.compose.runtime.Composer r6, final int r7, final int r8) {
        /*
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = -2001121712(0xffffffff88b94e50, float:-1.1152694E-33)
            androidx.compose.runtime.Composer r6 = r6.k(r0)
            r1 = r8 & 1
            if (r1 == 0) goto L13
            r1 = r7 | 6
            goto L23
        L13:
            r1 = r7 & 6
            if (r1 != 0) goto L22
            boolean r1 = r6.Z(r4)
            if (r1 == 0) goto L1f
            r1 = 4
            goto L20
        L1f:
            r1 = 2
        L20:
            r1 = r1 | r7
            goto L23
        L22:
            r1 = r7
        L23:
            r2 = r7 & 48
            if (r2 != 0) goto L37
            r2 = r8 & 2
            if (r2 != 0) goto L34
            boolean r2 = r6.Z(r5)
            if (r2 == 0) goto L34
            r2 = 32
            goto L36
        L34:
            r2 = 16
        L36:
            r1 = r1 | r2
        L37:
            r2 = r1 & 19
            r3 = 18
            if (r2 != r3) goto L48
            boolean r2 = r6.l()
            if (r2 != 0) goto L44
            goto L48
        L44:
            r6.Q()
            goto L8f
        L48:
            r6.J()
            r2 = r7 & 1
            if (r2 == 0) goto L60
            boolean r2 = r6.S()
            if (r2 == 0) goto L56
            goto L60
        L56:
            r6.Q()
            r2 = r8 & 2
            if (r2 == 0) goto L6e
        L5d:
            r1 = r1 & (-113(0xffffffffffffff8f, float:NaN))
            goto L6e
        L60:
            r2 = r8 & 2
            if (r2 == 0) goto L6e
            com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration r5 = r4.getTemplateConfiguration()
            r2 = 0
            com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration$Colors r5 = r5.getCurrentColors(r6, r2)
            goto L5d
        L6e:
            r6.z()
            boolean r2 = androidx.compose.runtime.ComposerKt.M()
            if (r2 == 0) goto L7d
            r2 = -1
            java.lang.String r3 = "com.revenuecat.purchases.ui.revenuecatui.composables.OfferDetails (OfferDetails.kt:25)"
            androidx.compose.runtime.ComposerKt.U(r0, r1, r2, r3)
        L7d:
            long r2 = r5.m1093getText10d7_KjU()
            r0 = r1 & 14
            m912OfferDetailsRPmYEkk(r4, r2, r6, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.M()
            if (r0 == 0) goto L8f
            androidx.compose.runtime.ComposerKt.T()
        L8f:
            androidx.compose.runtime.ScopeUpdateScope r6 = r6.n()
            if (r6 == 0) goto L9d
            com.revenuecat.purchases.ui.revenuecatui.composables.OfferDetailsKt$OfferDetails$1 r0 = new com.revenuecat.purchases.ui.revenuecatui.composables.OfferDetailsKt$OfferDetails$1
            r0.<init>()
            r6.a(r0)
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.composables.OfferDetailsKt.OfferDetails(com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Legacy, com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration$Colors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: renamed from: OfferDetails-RPmYEkk, reason: not valid java name */
    public static final void m912OfferDetailsRPmYEkk(final PaywallState.Loaded.Legacy state, final long j3, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerK = composer.k(683762235);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(state) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.f(j3) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(683762235, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.OfferDetails (OfferDetails.kt:37)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierM = PaddingKt.m(companion, 0.0f, 0.0f, 0.0f, UIConstant.INSTANCE.m693getDefaultVerticalSpacingD9Ej5fM(), 7, null);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
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
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            IntroEligibilityStateViewKt.m892IntroEligibilityStateViewQETHhvg(PaywallStateKt.getSelectedLocalization(state).getOfferDetails(), PaywallStateKt.getSelectedLocalization(state).getOfferDetailsWithIntroOffer(), PaywallStateKt.getSelectedLocalization(state).getOfferDetailsWithMultipleIntroOffers(), PackageExtensionsKt.getOfferEligibility((TemplateConfiguration.PackageInfo) state.getSelectedPackage().getValue()), j3, MaterialTheme.f18110a.c(composerK, MaterialTheme.f18111b).c(), FontWeight.f29233b.g(), TextAlign.h(TextAlign.f29616b.a()), false, SizeKt.h(companion, 0.0f, 1, null), composerK, ((i4 << 9) & 57344) | 806879232, Function.MAX_NARGS);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.OfferDetailsKt.OfferDetails.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    OfferDetailsKt.m912OfferDetailsRPmYEkk(state, j3, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
