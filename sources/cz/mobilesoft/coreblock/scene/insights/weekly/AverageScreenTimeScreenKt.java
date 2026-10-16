package cz.mobilesoft.coreblock.scene.insights.weekly;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.IconKt;
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
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
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
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.scene.insights.InsightsScreenApplicationListKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.graph.BarGraphKt;
import cz.mobilesoft.coreblock.view.graph.GraphConfiguration;
import cz.mobilesoft.coreblock.view.graph.GraphData;
import de.charlex.compose.HtmlTextKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class AverageScreenTimeScreenKt {
    public static final void d(final WeeklyInsightsViewState viewState, Function1 onTap, final Function0 onShareClick, Composer composer, final int i3) {
        int i4;
        final Function1 function1;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onTap, "onTap");
        Intrinsics.checkNotNullParameter(onShareClick, "onShareClick");
        Composer composerK = composer.k(-1986073178);
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
                ComposerKt.U(-1986073178, i4, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.AverageScreenTimeScreen (AverageScreenTimeScreen.kt:48)");
            }
            function1 = onTap;
            ComponentsKt.k(StringResources_androidKt.b(R.string.pG, composerK, 0), HtmlTextKt.e(StringResources_androidKt.b(R.string.tG, composerK, 0), (3 & 1) != 0 ? new SpanStyle(Color.f25715b.b(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.f29625b.d(), (Shadow) null, 12286, (DefaultConstructorMarker) null) : null, (3 & 2) != 0 ? MapsKt.emptyMap() : null), false, function1, ComposableLambdaKt.e(1615240908, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.a
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AverageScreenTimeScreenKt.e(viewState, onShareClick, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, ((i4 << 6) & 7168) | 24960, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function1 = onTap;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AverageScreenTimeScreenKt.f(viewState, function1, onShareClick, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(WeeklyInsightsViewState weeklyInsightsViewState, Function0 function0, ColumnScope BaseWeeklyInsightsScreen, Composer composer, int i3) {
        int i4;
        int i5;
        int i6;
        float f3;
        Modifier.Companion companion;
        Composer composer2;
        Intrinsics.checkNotNullParameter(BaseWeeklyInsightsScreen, "$this$BaseWeeklyInsightsScreen");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(BaseWeeklyInsightsScreen) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1615240908, i4, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.AverageScreenTimeScreen.<anonymous> (AverageScreenTimeScreen.kt:55)");
            }
            TextKt.c(weeklyInsightsViewState.m(), null, ComposeColorsKt.j(composer, 0).b(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composer, 0).e(), 0L, TextUnitKt.i(56), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(68), null, null, null, 0, 0, null, 16646141, null), composer, 0, 0, 65018);
            Composer composer3 = composer;
            Modifier.Companion companion2 = Modifier.b8;
            float f4 = 12;
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f4)), composer3, 6);
            g(weeklyInsightsViewState.B(), composer3, 0);
            SpacerKt.a(SizeKt.i(companion2, Dp.g(24)), composer3, 6);
            GraphData graphDataC = weeklyInsightsViewState.C();
            if (graphDataC == null) {
                composer3.a0(-1171164458);
                composer3.U();
                i5 = 2;
                i6 = 1;
            } else {
                composer3.a0(-1171164457);
                i5 = 2;
                i6 = 1;
                BarGraphKt.m(SizeKt.i(SizeKt.h(PaddingKt.k(companion2, Dp.g(16), 0.0f, 2, null), 0.0f, 1, null), Dp.g(240)), graphDataC, new GraphConfiguration(false, false, false, true, false, false, null, null, null, null, false, false, null, false, null, null, 65524, null), 0L, 0.0f, null, composer, 6, 56);
                composer3 = composer;
                Unit unit = Unit.f139807a;
                composer3.U();
            }
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f4)), composer3, 6);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.o(Dp.g(6)), Alignment.f25072a.i(), composer3, 54);
            int iA = ComposablesKt.a(composer3, 0);
            CompositionLocalMap compositionLocalMapU = composer3.u();
            Modifier modifierF = ComposedModifierKt.f(composer3, companion2);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
            if (composer3.m() == null) {
                ComposablesKt.c();
            }
            composer3.L();
            if (composer3.i()) {
                composer3.P(function0A);
            } else {
                composer3.v();
            }
            Composer composerA = Updater.a(composer3);
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            composer3.a0(-1473111228);
            Iterator<AppDistractionType> it = AppDistractionType.getEntries().iterator();
            while (it.hasNext()) {
                InsightsScreenApplicationListKt.D(it.next(), 0.0f, 0L, 0L, composer, 0, 14);
                composer3 = composer;
            }
            Composer composer4 = composer3;
            composer4.U();
            composer4.y();
            Modifier.Companion companion4 = Modifier.b8;
            int i7 = i5;
            SpacerKt.a(ColumnScope.b(BaseWeeklyInsightsScreen, companion4, 1.0f, false, 2, null), composer4, 0);
            float f5 = 16;
            SpacerKt.a(SizeKt.i(companion4, Dp.g(f5)), composer4, 6);
            Modifier modifierK = SizeKt.k(SizeKt.h(companion4, 0.0f, i6, null), WeeklyInsightsActivity.f103883g.a(), 0.0f, i7, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.g(), composer4, 54);
            int iA2 = ComposablesKt.a(composer4, 0);
            CompositionLocalMap compositionLocalMapU2 = composer4.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer4, modifierK);
            ComposeUiNode.Companion companion5 = ComposeUiNode.f8;
            Function0 function0A2 = companion5.a();
            if (composer4.m() == null) {
                ComposablesKt.c();
            }
            composer4.L();
            if (composer4.i()) {
                composer4.P(function0A2);
            } else {
                composer4.v();
            }
            Composer composerA2 = Updater.a(composer4);
            Updater.e(composerA2, measurePolicyA, companion5.e());
            Updater.e(composerA2, compositionLocalMapU2, companion5.g());
            Function2 function2B2 = companion5.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion5.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            String strP = weeklyInsightsViewState.p();
            if (strP == null) {
                composer4.a0(-2135843414);
                composer4.U();
                f3 = f5;
                companion = companion4;
                composer2 = composer4;
            } else {
                composer4.a0(-2135843413);
                f3 = f5;
                companion = companion4;
                TextKt.d(StringHelperExtKt.k((Context) composer4.q(AndroidCompositionLocals_androidKt.g()), R.string.xG, StringHelperExtKt.c(strP), ComposeColorsKt.j(composer4, 0).b()), PaddingKt.k(companion4, Dp.g(f5), 0.0f, i7, null), ComposeColorsKt.j(composer4, 0).L(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, null, ComposeTypographyKt.g(composer4, 0).a(), composer, 48, 0, 130552);
                composer2 = composer;
                Unit unit2 = Unit.f139807a;
                composer2.U();
            }
            Modifier.Companion companion6 = companion;
            SpacerKt.a(SizeKt.i(companion6, Dp.g(18)), composer2, 6);
            ComposeButtonsKt.i0(PaddingKt.k(companion6, Dp.g(f3), 0.0f, 2, null), new ButtonType.Big(ShareKt.a(Icons.f15145a.a()), null, StringResources_androidKt.b(R.string.Hw, composer2, 0), 0.0f, 10, null), new ButtonColor.Light(false, Color.n(ComposeColorsKt.j(composer2, 0).f0()), false, null, null, 29, null), function0, composer2, 6, 0);
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
    public static final Unit f(WeeklyInsightsViewState weeklyInsightsViewState, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        d(weeklyInsightsViewState, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void g(final Float f3, Composer composer, final int i3) {
        int i4;
        long jA;
        Composer composerK = composer.k(1706951631);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(f3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1706951631, i4, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.DifferenceText (AverageScreenTimeScreen.kt:149)");
            }
            if (f3 != null) {
                composerK.a0(-616637730);
                boolean z2 = f3.floatValue() >= 0.0f;
                if (z2) {
                    composerK.a0(-296984494);
                    jA = ComposeColorsKt.j(composerK, 0).c0();
                } else {
                    composerK.a0(-296983980);
                    jA = ComposeColorsKt.j(composerK, 0).A();
                }
                composerK.U();
                Alignment.Vertical verticalI = Alignment.f25072a.i();
                Modifier.Companion companion = Modifier.b8;
                MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), verticalI, composerK, 48);
                int iA = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU = composerK.u();
                Modifier modifierF = ComposedModifierKt.f(composerK, companion);
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
                Updater.e(composerA, measurePolicyB, companion2.e());
                Updater.e(composerA, compositionLocalMapU, companion2.g());
                Function2 function2B = companion2.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF, companion2.f());
                RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
                IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, z2 ? R.drawable.C6 : R.drawable.A6, composerK, 6), null, SizeKt.v(companion, Dp.g(20)), jA, composerK, 432, 0);
                TextKt.c(StringResources_androidKt.c(R.string.kA, new Object[]{Integer.valueOf(RangesKt.k((int) (f3.floatValue() * 100), 100))}, composerK, 0), PaddingKt.m(companion, Dp.g(4), 0.0f, 0.0f, 0.0f, 14, null), ComposeColorsKt.j(composerK, 0).P(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).b(), composerK, 48, 0, 65016);
                composerK = composerK;
                composerK.y();
            } else {
                composerK.a0(-622337421);
            }
            composerK.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AverageScreenTimeScreenKt.h(f3, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Float f3, int i3, Composer composer, int i4) {
        g(f3, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
