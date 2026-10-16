package cz.mobilesoft.coreblock.scene.insights.weekly;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.TextKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.insights.InsightsScreenComponentsKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import de.charlex.compose.HtmlTextKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class TrendScreenKt {
    public static final void c(final WeeklyInsightsViewState viewState, final Function1 onTap, final Function0 onShareClick, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        final long jA;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onTap, "onTap");
        Intrinsics.checkNotNullParameter(onShareClick, "onShareClick");
        Composer composerK = composer.k(1628415192);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onTap) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onShareClick) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1628415192, i4, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.TrendScreen (TrendScreen.kt:40)");
            }
            Long lA = viewState.A();
            final boolean z2 = (lA != null ? lA.longValue() : 0L) > 0;
            if (z2) {
                composerK.a0(1538912347);
                jA = ComposeColorsKt.j(composerK, 0).c0();
            } else {
                composerK.a0(1538912861);
                jA = ComposeColorsKt.j(composerK, 0).A();
            }
            composerK.U();
            String strB = StringResources_androidKt.b(R.string.dE, composerK, 0);
            int i5 = z2 ? R.string.HG : R.string.EG;
            composer2 = composerK;
            ComponentsKt.k(strB, HtmlTextKt.e(StringResources_androidKt.b(i5, composerK, 0), (3 & 1) != 0 ? new SpanStyle(Color.f25715b.b(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.f29625b.d(), (Shadow) null, 12286, (DefaultConstructorMarker) null) : null, (3 & 2) != 0 ? MapsKt.emptyMap() : null), false, onTap, ComposableLambdaKt.e(1667557374, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.b1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TrendScreenKt.d(z2, viewState, jA, onShareClick, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, ((i4 << 6) & 7168) | 24576, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.c1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TrendScreenKt.e(viewState, onTap, onShareClick, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(boolean z2, WeeklyInsightsViewState weeklyInsightsViewState, long j3, Function0 function0, ColumnScope BaseWeeklyInsightsScreen, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(BaseWeeklyInsightsScreen, "$this$BaseWeeklyInsightsScreen");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(BaseWeeklyInsightsScreen) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1667557374, i4, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.TrendScreen.<anonymous> (TrendScreen.kt:50)");
            }
            String strQ = StringHelperExtKt.q("🙌", StringResources_androidKt.b(z2 ? R.string.GG : R.string.DG, composer, 0), null, 2, null);
            TextStyle textStyleB = ComposeTypographyKt.g(composer, 0).b();
            long jL = ComposeColorsKt.j(composer, 0).L();
            TextAlign.Companion companion = TextAlign.f29616b;
            TextKt.c(strQ, null, jL, 0L, null, null, null, 0L, null, TextAlign.h(companion.a()), 0L, 0, false, 0, 0, null, textStyleB, composer, 0, 0, 65018);
            Modifier.Companion companion2 = Modifier.b8;
            SpacerKt.a(ColumnScope.b(BaseWeeklyInsightsScreen, companion2, 2.0f, false, 2, null), composer, 0);
            SpacerKt.a(SizeKt.i(companion2, Dp.g(16)), composer, 6);
            InsightsScreenComponentsKt.G2(null, !z2, 0.0f, 0.0f, composer, 0, 13);
            float f3 = 12;
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composer, 6);
            TextKt.c(weeklyInsightsViewState.n(), SizeKt.h(companion2, 0.0f, 1, null), j3, 0L, null, null, null, 0L, null, TextAlign.h(companion.a()), 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composer, 0).e(), 0L, TextUnitKt.i(56), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null), composer, 48, 0, 65016);
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composer, 6);
            TextKt.c(StringResources_androidKt.b(z2 ? R.string.IG : R.string.FG, composer, 0), null, ComposeColorsKt.j(composer, 0).L(), 0L, null, null, null, 0L, null, TextAlign.h(companion.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 0, 0, 65018);
            SpacerKt.a(ColumnScope.b(BaseWeeklyInsightsScreen, companion2, 3.0f, false, 2, null), composer, 0);
            Modifier modifierK = SizeKt.k(SizeKt.h(companion2, 0.0f, 1, null), WeeklyInsightsActivity.f103883g.a(), 0.0f, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.g(), composer, 54);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Float fB = weeklyInsightsViewState.B();
            if (fB == null) {
                composer.a0(-929307985);
                composer.U();
            } else {
                composer.a0(-929307984);
                float fFloatValue = fB.floatValue();
                int i5 = z2 ? R.string.NF : R.string.OF;
                TextKt.d(StringHelperExtKt.k((Context) composer.q(AndroidCompositionLocals_androidKt.g()), R.string.CG, StringResources_androidKt.c(i5, new Object[]{((int) (Math.abs(fFloatValue) * 100)) + "%"}, composer, 0), ComposeColorsKt.j(composer, 0).b()), null, ComposeColorsKt.j(composer, 0).L(), 0L, null, null, null, 0L, null, TextAlign.h(companion.a()), 0L, 0, false, 0, 0, null, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 130554);
                SpacerKt.a(SizeKt.i(companion2, Dp.g((float) 18)), composer, 6);
                ComposeButtonsKt.i0(null, new ButtonType.Big(ShareKt.a(Icons.f15145a.a()), null, StringResources_androidKt.b(R.string.Hw, composer, 0), 0.0f, 10, null), new ButtonColor.Light(false, Color.n(ComposeColorsKt.j(composer, 0).f0()), false, null, null, 29, null), function0, composer, 0, 1);
                composer.U();
            }
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(WeeklyInsightsViewState weeklyInsightsViewState, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        c(weeklyInsightsViewState, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
