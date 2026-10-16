package cz.mobilesoft.coreblock.scene.sharing.images.ups_downs;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload;
import cz.mobilesoft.coreblock.scene.sharing.images.SocialShareTemplate;
import cz.mobilesoft.coreblock.scene.sharing.images.components.BlurredGlowKt;
import cz.mobilesoft.coreblock.scene.sharing.images.components.ShareSubtitleStringsKt;
import cz.mobilesoft.coreblock.scene.sharing.images.components.ShareTextsKt;
import cz.mobilesoft.coreblock.scene.sharing.images.components.SocialsShareTopBarKt;
import cz.mobilesoft.coreblock.scene.sharing.images.ups_downs.UpsDownsImageKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class UpsDownsImageKt {
    private static final void c(final boolean z2, final boolean z3, String str, Composer composer, final int i3) {
        int i4;
        long jK0;
        final String str2 = str;
        Composer composerK = composer.k(-2028996123);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(str2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2028996123, i4, -1, "cz.mobilesoft.coreblock.scene.sharing.images.ups_downs.TrendHero (UpsDownsImage.kt:113)");
            }
            int i5 = z2 ? R.drawable.n5 : R.drawable.m5;
            if (z2) {
                composerK.a0(49887594);
                jK0 = ComposeColorsKt.j(composerK, 0).x();
            } else {
                composerK.a0(49888172);
                jK0 = ComposeColorsKt.j(composerK, 0).k0();
            }
            composerK.U();
            long j3 = jK0;
            float fG = Dp.g(z3 ? 500 : 600);
            float fG2 = Dp.g(z3 ? 298 : 350);
            float fG3 = Dp.g(100);
            Modifier.Companion companion = Modifier.b8;
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            int i6 = i4;
            Function0 function0A = companion3.a();
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
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierM = PaddingKt.m(boxScopeInstance.f(companion, companion2.m()), 0.0f, 0.0f, 0.0f, fG3, 7, null);
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierM);
            Function0 function0A2 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A2);
            } else {
                composerK.v();
            }
            Composer composerA2 = Updater.a(composerK);
            Updater.e(composerA2, measurePolicyG2, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            BlurredGlowKt.b(j3, fG, boxScopeInstance.f(companion, companion2.e()), composerK, 0, 0);
            ImageKt.a(PainterResources_androidKt.c(i5, composerK, 0), null, SizeKt.v(boxScopeInstance.f(companion, companion2.e()), fG2), null, null, 0.0f, null, composerK, 48, 120);
            composerK = composerK;
            composerK.y();
            str2 = str;
            ShareTextsKt.n(boxScopeInstance.f(companion, companion2.b()), str2, 0L, composerK, (i6 >> 3) & 112, 4);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: s1.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return UpsDownsImageKt.d(z2, z3, str2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(boolean z2, boolean z3, String str, int i3, Composer composer, int i4) {
        c(z2, z3, str, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void e(Modifier modifier, final SocialShareTemplate template, final SocialsSharePayload graphPayload, final String topBarText, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        Composer composer2;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(graphPayload, "graphPayload");
        Intrinsics.checkNotNullParameter(topBarText, "topBarText");
        Composer composerK = composer.k(103057014);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.e(template.ordinal()) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(graphPayload) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.Z(topBarText) ? 2048 : 1024;
        }
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            Modifier modifier4 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(103057014, i5, -1, "cz.mobilesoft.coreblock.scene.sharing.images.ups_downs.UpsDownsImage (UpsDownsImage.kt:38)");
            }
            boolean z2 = template.getFormat() == SocialShareTemplate.Format.Square;
            Modifier modifierB = AspectRatioKt.b(SizeKt.h(modifier4, 0.0f, 1, null), template.getFormat().getPreviewAspectRatio(), false, 2, null);
            Alignment.Companion companion = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierB);
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
            Painter painterC = PainterResources_androidKt.c(z2 ? R.drawable.f95553q : R.drawable.f95549p, composerK, 0);
            Modifier.Companion companion3 = Modifier.b8;
            int i7 = i5;
            Modifier modifier5 = modifier4;
            composer2 = composerK;
            ImageKt.a(painterC, null, SizeKt.f(companion3, 0.0f, 1, null), null, ContentScale.f27054a.a(), 0.0f, null, composer2, 25008, 104);
            Modifier modifierF2 = SizeKt.f(companion3, 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion.g(), composer2, 48);
            int iA2 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU2 = composer2.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer2, modifierF2);
            Function0 function0A2 = companion2.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A2);
            } else {
                composer2.v();
            }
            Composer composerA2 = Updater.a(composer2);
            Updater.e(composerA2, measurePolicyA, companion2.e());
            Updater.e(composerA2, compositionLocalMapU2, companion2.g());
            Function2 function2B2 = companion2.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF3, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            SpacerKt.a(SizeKt.i(companion3, Dp.g(z2 ? 58 : 252)), composer2, 0);
            SocialsShareTopBarKt.b(topBarText, 0L, PaddingKt.k(companion3, Dp.g(43), 0.0f, 2, null), composer2, ((i7 >> 9) & 14) | 384, 2);
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion3, 1.0f, false, 2, null), composer2, 0);
            c(Intrinsics.areEqual(graphPayload.r(), Boolean.TRUE), z2, graphPayload.j(), composer2, 0);
            SpacerKt.a(SizeKt.i(companion3, Dp.g(18)), composer2, 6);
            ShareTextsKt.l(null, StringResources_androidKt.b(ShareSubtitleStringsKt.b(graphPayload.c()), composer2, 0), 0L, false, composer2, 0, 13);
            SpacerKt.a(SizeKt.i(companion3, Dp.g(8)), composer2, 6);
            int i8 = R.string.Kw;
            String strO = graphPayload.o();
            if (strO == null) {
                strO = "";
            }
            ShareTextsKt.j(null, StringResources_androidKt.c(i8, new Object[]{strO}, composer2, 0), 0L, composer2, 0, 5);
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion3, 1.0f, false, 2, null), composer2, 0);
            SpacerKt.a(SizeKt.i(companion3, Dp.g(z2 ? 94 : 252)), composer2, 0);
            composer2.y();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier3 = modifier5;
        } else {
            composer2 = composerK;
            composer2.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: s1.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return UpsDownsImageKt.f(modifier3, template, graphPayload, topBarText, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Modifier modifier, SocialShareTemplate socialShareTemplate, SocialsSharePayload socialsSharePayload, String str, int i3, int i4, Composer composer, int i5) {
        e(modifier, socialShareTemplate, socialsSharePayload, str, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
