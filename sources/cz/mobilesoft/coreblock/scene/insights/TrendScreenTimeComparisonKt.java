package cz.mobilesoft.coreblock.scene.insights;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.TextKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.coreblock.view.graph.BarGraphKt;
import cz.mobilesoft.coreblock.view.graph.GraphConfiguration;
import cz.mobilesoft.coreblock.view.graph.GraphData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

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
public final class TrendScreenTimeComparisonKt {
    private static final void d(final Context context, final float f3, final GraphData graphData, final GraphData graphData2, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        long jA;
        Composer composerK = composer.k(-1142465700);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(context) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.c(f3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= (i3 & 512) == 0 ? composerK.Z(graphData) : composerK.I(graphData) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= (i3 & 4096) == 0 ? composerK.Z(graphData2) : composerK.I(graphData2) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1142465700, i4, -1, "cz.mobilesoft.coreblock.scene.insights.TrendScreenTimeComparisonContent (TrendScreenTimeComparison.kt:53)");
            }
            final boolean z2 = f3 > 0.0f;
            if (z2) {
                composerK.a0(1602097727);
                jA = ComposeColorsKt.j(composerK, 0).c0();
            } else {
                composerK.a0(1602098241);
                jA = ComposeColorsKt.j(composerK, 0).A();
            }
            composerK.U();
            final long j3 = jA;
            composer2 = composerK;
            InsightsScreenHabitsListKt.o(null, null, null, ComposableLambdaKt.e(-1569539327, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.l8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TrendScreenTimeComparisonKt.e(z2, context, f3, graphData, graphData2, j3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 3072, 7);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.m8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TrendScreenTimeComparisonKt.f(context, f3, graphData, graphData2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v6 */
    public static final Unit e(boolean z2, Context context, float f3, GraphData graphData, GraphData graphData2, long j3, BoxScope BorderedBox, Composer composer, int i3) {
        RowScopeInstance rowScopeInstance;
        Modifier.Companion companion;
        long j4;
        int i4;
        int i5;
        GraphConfiguration.CustomAverageLabel customAverageLabel;
        int i6;
        int i7;
        int i8;
        ?? r15;
        Context context2;
        Modifier.Companion companion2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(BorderedBox, "$this$BorderedBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1569539327, i3, -1, "cz.mobilesoft.coreblock.scene.insights.TrendScreenTimeComparisonContent.<anonymous> (TrendScreenTimeComparison.kt:58)");
            }
            Modifier.Companion companion3 = Modifier.b8;
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion4 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion4.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion3);
            ComposeUiNode.Companion companion5 = ComposeUiNode.f8;
            Function0 function0A = companion5.a();
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
            Updater.e(composerA, measurePolicyA, companion5.e());
            Updater.e(composerA, compositionLocalMapU, companion5.g());
            Function2 function2B = companion5.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion5.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            TextKt.c(StringResources_androidKt.b(z2 ? R.string.uh : R.string.sh, composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 0, 0, 65530);
            float f4 = 8;
            SpacerKt.a(SizeKt.i(companion3, Dp.g(f4)), composer, 6);
            TextKt.c(StringResources_androidKt.c(z2 ? R.string.vh : R.string.th, new Object[]{StringHelper.f(context, MathKt.f(Math.abs(60 * f3 * 1000)))}, composer, 0), null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65530);
            Composer composer3 = composer;
            SpacerKt.a(SizeKt.i(companion3, Dp.g(24)), composer3, 6);
            Modifier modifierI = SizeKt.i(SizeKt.h(companion3, 0.0f, 1, null), Dp.g(82));
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion4.l(), composer3, 0);
            int iA2 = ComposablesKt.a(composer3, 0);
            CompositionLocalMap compositionLocalMapU2 = composer3.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer3, modifierI);
            Function0 function0A2 = companion5.a();
            if (composer3.m() == null) {
                ComposablesKt.c();
            }
            composer3.L();
            if (composer3.i()) {
                composer3.P(function0A2);
            } else {
                composer3.v();
            }
            Composer composerA2 = Updater.a(composer3);
            Updater.e(composerA2, measurePolicyB, companion5.e());
            Updater.e(composerA2, compositionLocalMapU2, companion5.g());
            Function2 function2B2 = companion5.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion5.f());
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.f7101a;
            if (graphData == null) {
                composer3.a0(-146491072);
                composer3.U();
                companion = companion3;
                i7 = 0;
                rowScopeInstance = rowScopeInstance2;
                i8 = 6;
                i4 = 60;
                i6 = 1000;
                context2 = context;
                r15 = 1;
            } else {
                composer3.a0(-146491071);
                Modifier modifierC = RowScope.c(rowScopeInstance2, companion3, 1.0f, false, 2, null);
                rowScopeInstance = rowScopeInstance2;
                companion = companion3;
                long jR = Color.r(ComposeColorsKt.j(composer3, 0).z(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null);
                long jR2 = Color.r(ComposeColorsKt.j(composer3, 0).z(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null);
                if (graphData.a() == null) {
                    composer3.a0(1128673313);
                    composer3.U();
                    j4 = jR;
                    customAverageLabel = null;
                    i5 = 1000;
                    i4 = 60;
                } else {
                    composer3.a0(1128673314);
                    j4 = jR;
                    i4 = 60;
                    i5 = 1000;
                    GraphConfiguration.CustomAverageLabel customAverageLabel2 = new GraphConfiguration.CustomAverageLabel(StringHelper.f(context, Math.abs(MathKt.f(graphData.a().floatValue()) * ((long) 60) * ((long) 1000))), Color.n(ComposeColorsKt.j(composer3, 0).p()), false, 4, null);
                    composer3.U();
                    customAverageLabel = customAverageLabel2;
                }
                i6 = i5;
                i7 = 0;
                i8 = 6;
                r15 = 1;
                context2 = context;
                BarGraphKt.m(modifierC, graphData, new GraphConfiguration(false, false, false, false, true, false, Color.n(jR2), null, Color.n(j4), customAverageLabel, false, false, null, false, null, null, 64672, null), 0L, 0.0f, null, composer3, (GraphData.f132767h << 3) | (GraphConfiguration.f132743r << 6), 56);
                composer3 = composer3;
                Unit unit = Unit.f139807a;
                composer3.U();
            }
            if (graphData2 == null) {
                composer3.a0(-145163063);
                composer3.U();
                composer2 = composer3;
                companion2 = companion;
            } else {
                composer3.a0(-145163062);
                RowScopeInstance rowScopeInstance3 = rowScopeInstance;
                int i9 = i4;
                Modifier.Companion companion6 = companion;
                Modifier modifierC2 = RowScope.c(rowScopeInstance3, companion6, 1.0f, false, 2, null);
                rowScopeInstance = rowScopeInstance3;
                companion2 = companion6;
                composer2 = composer3;
                BarGraphKt.m(modifierC2, graphData2, new GraphConfiguration(false, false, false, false, true, false, Color.n(Color.r(ComposeColorsKt.j(composer3, i7).z(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null)), null, Color.n(j3), graphData2.a() != null ? new GraphConfiguration.CustomAverageLabel(StringHelper.f(context2, Math.abs(MathKt.f(graphData2.a().floatValue()) * ((long) i9) * ((long) i6))), Color.n(j3), r15, null) : null, false, false, null, false, null, null, 64672, null), 0L, 0.0f, null, composer2, (GraphData.f132767h << 3) | (GraphConfiguration.f132743r << 6), 56);
                Unit unit2 = Unit.f139807a;
                composer2.U();
            }
            composer2.y();
            Modifier modifierI2 = SizeKt.i(companion2, Dp.g(f4));
            int i10 = i8;
            SpacerKt.a(modifierI2, composer2, i10);
            Modifier modifierH = SizeKt.h(companion2, 0.0f, r15, null);
            MeasurePolicy measurePolicyB2 = RowKt.b(arrangement.o(Dp.g(f4)), companion4.l(), composer2, i10);
            int iA3 = ComposablesKt.a(composer2, i7);
            CompositionLocalMap compositionLocalMapU3 = composer2.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer2, modifierH);
            Function0 function0A3 = companion5.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A3);
            } else {
                composer2.v();
            }
            Composer composerA3 = Updater.a(composer2);
            Updater.e(composerA3, measurePolicyB2, companion5.e());
            Updater.e(composerA3, compositionLocalMapU3, companion5.g());
            Function2 function2B3 = companion5.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion5.f());
            Modifier.Companion companion7 = companion2;
            RowScopeInstance rowScopeInstance4 = rowScopeInstance;
            Modifier modifierC3 = RowScope.c(rowScopeInstance4, companion7, 1.0f, false, 2, null);
            String strB = StringResources_androidKt.b(R.string.Qg, composer2, i7);
            TextStyle textStyleD = ComposeTypographyKt.g(composer2, i7).d();
            long jQ = ComposeColorsKt.j(composer2, i7).q();
            TextAlign.Companion companion8 = TextAlign.f29616b;
            TextKt.c(strB, modifierC3, jQ, 0L, null, null, null, 0L, null, TextAlign.h(companion8.a()), 0L, 0, false, 0, 0, null, textStyleD, composer, 0, 0, 65016);
            TextKt.c(StringResources_androidKt.b(R.string.qA, composer, 0), RowScope.c(rowScopeInstance4, companion7, 1.0f, false, 2, null), ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion8.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).d(), composer, 0, 0, 65016);
            composer.y();
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
    public static final Unit f(Context context, float f3, GraphData graphData, GraphData graphData2, int i3, Composer composer, int i4) {
        d(context, f3, graphData, graphData2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void g(LazyListScope lazyListScope, final Context context, final InsightsViewState viewState) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Float fN0 = viewState.n0();
        if (fN0 != null) {
            final float fFloatValue = fN0.floatValue();
            LazyListScope.c(lazyListScope, null, null, ComposableLambdaKt.c(467480718, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.k8
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TrendScreenTimeComparisonKt.h(context, fFloatValue, viewState, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Context context, float f3, InsightsViewState insightsViewState, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(467480718, i3, -1, "cz.mobilesoft.coreblock.scene.insights.trendScreenTimeComparison.<anonymous>.<anonymous> (TrendScreenTimeComparison.kt:37)");
            }
            GraphData graphDataC = insightsViewState.C();
            GraphData graphDataL = insightsViewState.L();
            int i4 = GraphData.f132767h;
            d(context, f3, graphDataC, graphDataL, composer, (i4 << 6) | (i4 << 9));
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }
}
