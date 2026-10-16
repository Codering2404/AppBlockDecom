package cz.mobilesoft.coreblock.scene.insights.weekly;

import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ShareKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload;
import cz.mobilesoft.coreblock.scene.sharing.images.SocialShareTemplate;
import cz.mobilesoft.coreblock.scene.sharing.images.components.FixedCanvasKt;
import cz.mobilesoft.coreblock.scene.sharing.images.weekly_report.WeeklyReportImageKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ShareScreenKt {
    public static final void d(final Function1 onTap, final SocialsSharePayload weeklyReportPayload, final String topBarText, final Function0 onShareClick, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onTap, "onTap");
        Intrinsics.checkNotNullParameter(weeklyReportPayload, "weeklyReportPayload");
        Intrinsics.checkNotNullParameter(topBarText, "topBarText");
        Intrinsics.checkNotNullParameter(onShareClick, "onShareClick");
        Composer composerK = composer.k(1203786912);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onTap) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(weeklyReportPayload) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(topBarText) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onShareClick) ? 2048 : 1024;
        }
        int i5 = i4;
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1203786912, i5, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.ShareScreen (ShareScreen.kt:41)");
            }
            long jA = ((WindowInfo) composerK.q(CompositionLocalsKt.u())).a();
            int i6 = (int) (jA & 4294967295L);
            final boolean z2 = ((int) (jA >> 32)) > i6;
            final float fG = Dp.g(((Density) composerK.q(CompositionLocalsKt.f())).F(i6) * 0.6f);
            composer2 = composerK;
            ComponentsKt.k("", new AnnotatedString(StringResources_androidKt.b(R.string.Jw, composerK, 0), null, 2, null), false, onTap, ComposableLambdaKt.e(-942573638, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.w0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ShareScreenKt.e(onShareClick, z2, fG, weeklyReportPayload, topBarText, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, ((i5 << 9) & 7168) | 24582, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.x0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ShareScreenKt.g(onTap, weeklyReportPayload, topBarText, onShareClick, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Function0 function0, boolean z2, float f3, final SocialsSharePayload socialsSharePayload, final String str, ColumnScope BaseWeeklyInsightsScreen, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(BaseWeeklyInsightsScreen, "$this$BaseWeeklyInsightsScreen");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(BaseWeeklyInsightsScreen) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-942573638, i4, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.ShareScreen.<anonymous> (ShareScreen.kt:52)");
            }
            Modifier.Companion companion = Modifier.b8;
            SpacerKt.a(ColumnScope.b(BaseWeeklyInsightsScreen, companion, 1.0f, false, 2, null), composer, 0);
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.e(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
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
            Modifier modifierA = z2 ? ClipKt.a(AspectRatioKt.a(SizeKt.k(companion, 0.0f, f3, 1, null), SocialShareTemplate.Format.Portrait.getPreviewAspectRatio(), true), RoundedCornerShapeKt.d(Dp.g(24))) : ClipKt.a(AspectRatioKt.b(SizeKt.g(companion, 0.75f), SocialShareTemplate.Format.Portrait.getPreviewAspectRatio(), false, 2, null), RoundedCornerShapeKt.d(Dp.g(24)));
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierA);
            Function0 function0A2 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A2);
            } else {
                composer.v();
            }
            Composer composerA2 = Updater.a(composer);
            Updater.e(composerA2, measurePolicyG2, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            FixedCanvasKt.e(SizeKt.f(companion, 0.0f, 1, null), SocialShareTemplate.WeeklyReportPortrait, ComposableLambdaKt.e(440820933, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.y0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ShareScreenKt.f(socialsSharePayload, str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 438, 0);
            composer.y();
            composer.y();
            SpacerKt.a(ColumnScope.b(BaseWeeklyInsightsScreen, companion, 1.0f, false, 2, null), composer, 0);
            SpacerKt.a(SizeKt.i(companion, Dp.g(24)), composer, 6);
            ComposeButtonsKt.i0(null, new ButtonType.Big(ShareKt.a(Icons.f15145a.a()), null, StringResources_androidKt.b(R.string.Hw, composer, 0), 0.0f, 10, null), new ButtonColor.Light(false, Color.n(ComposeColorsKt.j(composer, 0).f0()), false, null, null, 29, null), function0, composer, 0, 1);
            SpacerKt.a(SizeKt.i(companion, Dp.g(16)), composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(SocialsSharePayload socialsSharePayload, String str, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(440820933, i3, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.ShareScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ShareScreen.kt:75)");
            }
            WeeklyReportImageKt.c(SizeKt.f(Modifier.b8, 0.0f, 1, null), socialsSharePayload, str, null, composer, 6, 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Function1 function1, SocialsSharePayload socialsSharePayload, String str, Function0 function0, int i3, Composer composer, int i4) {
        d(function1, socialsSharePayload, str, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
