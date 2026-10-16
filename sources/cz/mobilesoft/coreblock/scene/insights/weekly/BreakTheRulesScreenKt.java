package cz.mobilesoft.coreblock.scene.insights.weekly;

import androidx.compose.foundation.layout.Arrangement;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
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
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.storage.room.entity.core.AggregatedPauseHistory;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.TextKt;
import de.charlex.compose.HtmlTextKt;
import java.util.Locale;
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
public final class BreakTheRulesScreenKt {
    public static final void c(final WeeklyInsightsViewState viewState, Function1 onTap, Composer composer, final int i3) {
        int i4;
        final Function1 function1;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onTap, "onTap");
        Composer composerK = composer.k(1385161172);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onTap) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1385161172, i4, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.BreakTheRulesScreen (BreakTheRulesScreen.kt:33)");
            }
            function1 = onTap;
            ComponentsKt.k(StringResources_androidKt.b(R.string.qG, composerK, 0), HtmlTextKt.e(StringResources_androidKt.b(R.string.sG, composerK, 0), (3 & 1) != 0 ? new SpanStyle(Color.f25715b.b(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.f29625b.d(), (Shadow) null, 12286, (DefaultConstructorMarker) null) : null, (3 & 2) != 0 ? MapsKt.emptyMap() : null), false, function1, ComposableLambdaKt.e(-1663848326, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.d
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BreakTheRulesScreenKt.d(viewState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, ((i4 << 6) & 7168) | 24576, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function1 = onTap;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BreakTheRulesScreenKt.e(viewState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(WeeklyInsightsViewState weeklyInsightsViewState, ColumnScope BaseWeeklyInsightsScreen, Composer composer, int i3) {
        int i4;
        Modifier.Companion companion;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(BaseWeeklyInsightsScreen, "$this$BaseWeeklyInsightsScreen");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer2.Z(BaseWeeklyInsightsScreen) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer2.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1663848326, i4, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.BreakTheRulesScreen.<anonymous> (BreakTheRulesScreen.kt:39)");
            }
            String upperCase = StringResources_androidKt.b(R.string.Fn, composer2, 0).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            TextKt.b(upperCase, composer2, 0);
            Modifier.Companion companion2 = Modifier.b8;
            SpacerKt.a(ColumnScope.b(BaseWeeklyInsightsScreen, companion2, 1.0f, false, 2, null), composer2, 0);
            AggregatedPauseHistory aggregatedPauseHistoryS = weeklyInsightsViewState.s();
            if (aggregatedPauseHistoryS == null) {
                composer2.a0(512271286);
                composer2.U();
                companion = companion2;
            } else {
                composer2.a0(512271287);
                String str = aggregatedPauseHistoryS.a() + "×";
                TextStyle textStyleE = TextStyle.e(ComposeTypographyKt.g(composer2, 0).e(), 0L, TextUnitKt.i(56), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(68), null, null, null, 0, 0, null, 16646141, null);
                long jB = ComposeColorsKt.j(composer2, 0).b();
                TextAlign.Companion companion3 = TextAlign.f29616b;
                androidx.compose.material.TextKt.c(str, null, jB, 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, textStyleE, composer, 0, 0, 65018);
                SpacerKt.a(SizeKt.i(companion2, Dp.g(6)), composer, 6);
                androidx.compose.material.TextKt.c(StringResources_androidKt.b(R.string.zG, composer, 0), null, ComposeColorsKt.j(composer, 0).L(), 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 0, 0, 65018);
                composer2 = composer;
                SpacerKt.a(SizeKt.i(companion2, Dp.g(2)), composer2, 6);
                Long lB = aggregatedPauseHistoryS.b();
                if (lB == null) {
                    composer2.a0(508432070);
                    composer2.U();
                    companion = companion2;
                } else {
                    composer2.a0(508432071);
                    companion = companion2;
                    androidx.compose.material.TextKt.c(StringResources_androidKt.c(R.string.ZD, new Object[]{DateHelperExtKt.f(lB.longValue(), false, false, false, 14, null)}, composer2, 0), null, ComposeColorsKt.j(composer2, 0).P(), 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).a(), composer, 0, 0, 65018);
                    composer2 = composer;
                    composer2.U();
                    Unit unit = Unit.f139807a;
                }
                composer2.U();
            }
            Modifier.Companion companion4 = companion;
            SpacerKt.a(ColumnScope.b(BaseWeeklyInsightsScreen, companion4, 1.0f, false, 2, null), composer2, 0);
            Modifier modifierK = SizeKt.k(SizeKt.h(companion4, 0.0f, 1, null), WeeklyInsightsActivity.f103883g.a(), 0.0f, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.g(), composer2, 54);
            int iA = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF = ComposedModifierKt.f(composer2, modifierK);
            ComposeUiNode.Companion companion5 = ComposeUiNode.f8;
            Function0 function0A = companion5.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A);
            } else {
                composer2.v();
            }
            Composer composerA = Updater.a(composer2);
            Updater.e(composerA, measurePolicyA, companion5.e());
            Updater.e(composerA, compositionLocalMapU, companion5.g());
            Function2 function2B = companion5.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion5.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            androidx.compose.material.TextKt.c(StringResources_androidKt.b(R.string.rG, composer2, 0), PaddingKt.k(companion4, Dp.g(16), 0.0f, 2, null), ComposeColorsKt.j(composer2, 0).L(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).a(), composer, 48, 0, 65016);
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
    public static final Unit e(WeeklyInsightsViewState weeklyInsightsViewState, Function1 function1, int i3, Composer composer, int i4) {
        c(weeklyInsightsViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
