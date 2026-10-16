package cz.mobilesoft.coreblock.scene.insights;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.material3.TooltipKt;
import cz.mobilesoft.coreblock.view.graph.BarGraphKt;
import cz.mobilesoft.coreblock.view.graph.GraphConfiguration;
import cz.mobilesoft.coreblock.view.graph.GraphData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
public final class InsightsScreenHabitsListKt {
    public static final void B(LazyListScope lazyListScope, final InsightsViewState viewState) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        LazyListScope.c(lazyListScope, null, null, ComposableSingletons$InsightsScreenHabitsListKt.f102581a.c(), 3, null);
        Long lK = viewState.k();
        if (lK != null) {
            final long jLongValue = lK.longValue();
            LazyListScope.c(lazyListScope, null, null, ComposableLambdaKt.c(274130322, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.w4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InsightsScreenHabitsListKt.C(jLongValue, viewState, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        }
        final GraphData graphDataZ = viewState.z();
        if (graphDataZ != null) {
            LazyListScope.c(lazyListScope, null, null, ComposableLambdaKt.c(1174587249, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.y4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InsightsScreenHabitsListKt.D(viewState, graphDataZ, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        }
        if (viewState.f() == null) {
            LazyListScope.c(lazyListScope, null, null, ComposableLambdaKt.c(2108901474, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.z4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InsightsScreenHabitsListKt.E(viewState, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(long j3, InsightsViewState insightsViewState, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(274130322, i3, -1, "cz.mobilesoft.coreblock.scene.insights.habitsList.<anonymous>.<anonymous> (InsightsScreenHabitsList.kt:73)");
            }
            l(j3, insightsViewState.f(), composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(InsightsViewState insightsViewState, GraphData graphData, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1174587249, i3, -1, "cz.mobilesoft.coreblock.scene.insights.habitsList.<anonymous>.<anonymous> (InsightsScreenHabitsList.kt:82)");
            }
            q(insightsViewState.X(), graphData, insightsViewState.f(), composer, GraphData.f132767h << 3);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(InsightsViewState insightsViewState, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2108901474, i3, -1, "cz.mobilesoft.coreblock.scene.insights.habitsList.<anonymous> (InsightsScreenHabitsList.kt:93)");
            }
            t(insightsViewState.j(), composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public static final void l(final long j3, final AppDistractionType appDistractionType, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(831000876);
        if ((i3 & 6) == 0) {
            i4 = (composerK.f(j3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.e(appDistractionType == null ? -1 : appDistractionType.ordinal()) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(831000876, i4, -1, "cz.mobilesoft.coreblock.scene.insights.BalanceSection (InsightsScreenHabitsList.kt:124)");
            }
            final int iA = (int) ((j3 / InsightsViewState.Y.a()) * 100);
            o(null, null, null, ComposableLambdaKt.e(219610983, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.g5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InsightsScreenHabitsListKt.m(iA, appDistractionType, j3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 3072, 7);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.x4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenHabitsListKt.n(j3, appDistractionType, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(int i3, AppDistractionType appDistractionType, long j3, BoxScope BorderedBox, Composer composer, int i4) {
        Intrinsics.checkNotNullParameter(BorderedBox, "$this$BorderedBox");
        if (composer.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(219610983, i4, -1, "cz.mobilesoft.coreblock.scene.insights.BalanceSection.<anonymous> (InsightsScreenHabitsList.kt:128)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Modifier modifierH2 = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.l(), composer, 0);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierH2);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            float f3 = 16;
            Modifier modifierM = PaddingKt.m(companion, 0.0f, 0.0f, Dp.g(f3), 0.0f, 11, null);
            String strB = StringResources_androidKt.b(R.string.Hg, composer, 0);
            TextStyle textStyleG = ComposeTypographyKt.g(composer, 0).g();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(strB, modifierM, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.f()), 0L, 0, false, 0, 0, null, textStyleG, composer, 48, 0, 65016);
            Modifier modifierC = RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null);
            TextKt.c(StringResources_androidKt.c(R.string.Gg, new Object[]{i3 + " %"}, composer, 0), modifierC, appDistractionType != null ? appDistractionType.m1357getColor0d7_KjU() : GraphConfiguration.f132742q.c(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.b()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65016);
            composer.y();
            SpacerKt.a(SizeKt.i(companion, Dp.g(24)), composer, 6);
            float f4 = 8;
            Modifier modifierC2 = BackgroundKt.c(SizeKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3)), ComposeColorsKt.j(composer, 0).F(), RoundedCornerShapeKt.d(Dp.g(f4)));
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, modifierC2);
            Function0 function0A3 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A3);
            } else {
                composer.v();
            }
            Composer composerA3 = Updater.a(composer);
            Updater.e(composerA3, measurePolicyG, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            BoxKt.a(BoxScopeInstance.f6642a.f(BackgroundKt.c(SizeKt.i(SizeKt.g(companion, i3 / 100), Dp.g(f3)), appDistractionType != null ? appDistractionType.m1357getColor0d7_KjU() : GraphConfiguration.f132742q.c(), RoundedCornerShapeKt.d(Dp.g(f4))), companion2.h()), composer, 0);
            composer.y();
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            Modifier modifierH3 = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyB2 = RowKt.b(arrangement.g(), companion2.i(), composer, 48);
            int iA4 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU4 = composer.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer, modifierH3);
            Function0 function0A4 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A4);
            } else {
                composer.v();
            }
            Composer composerA4 = Updater.a(composer);
            Updater.e(composerA4, measurePolicyB2, companion3.e());
            Updater.e(composerA4, compositionLocalMapU4, companion3.g());
            Function2 function2B4 = companion3.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                composerA4.w(Integer.valueOf(iA4));
                composerA4.p(Integer.valueOf(iA4), function2B4);
            }
            Updater.e(composerA4, modifierF4, companion3.f());
            ImageVector.Companion companion5 = ImageVector.f26323k;
            IconKt.b(VectorResources_androidKt.b(companion5, R.drawable.i4, composer, 6), null, PaddingKt.m(companion, 0.0f, 0.0f, Dp.g(f4), 0.0f, 11, null), appDistractionType != null ? appDistractionType.m1357getColor0d7_KjU() : GraphConfiguration.f132742q.c(), composer, 432, 0);
            TextKt.c(DateHelperExtKt.f(j3, false, false, false, 14, null), null, appDistractionType != null ? appDistractionType.m1357getColor0d7_KjU() : GraphConfiguration.f132742q.c(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65530);
            SpacerKt.a(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), composer, 0);
            IconKt.b(VectorResources_androidKt.b(companion5, R.drawable.i6, composer, 6), null, PaddingKt.m(companion, 0.0f, 0.0f, Dp.g(f4), 0.0f, 11, null), ComposeColorsKt.j(composer, 0).q(), composer, 432, 0);
            TextKt.c("16h", null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 6, 0, 65530);
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
    public static final Unit n(long j3, AppDistractionType appDistractionType, int i3, Composer composer, int i4) {
        l(j3, appDistractionType, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void o(androidx.compose.ui.Modifier r16, androidx.compose.foundation.layout.PaddingValues r17, androidx.compose.foundation.layout.PaddingValues r18, final kotlin.jvm.functions.Function3 r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instruction units count: 396
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.InsightsScreenHabitsListKt.o(androidx.compose.ui.Modifier, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Modifier modifier, PaddingValues paddingValues, PaddingValues paddingValues2, Function3 function3, int i3, int i4, Composer composer, int i5) {
        o(modifier, paddingValues, paddingValues2, function3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void q(final String str, final GraphData graphData, final AppDistractionType appDistractionType, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(graphData, "graphData");
        Composer composerK = composer.k(-1899906727);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(str) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= (i3 & 64) == 0 ? composerK.Z(graphData) : composerK.I(graphData) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.e(appDistractionType == null ? -1 : appDistractionType.ordinal()) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1899906727, i4, -1, "cz.mobilesoft.coreblock.scene.insights.PeakTimeSection (InsightsScreenHabitsList.kt:226)");
            }
            o(null, null, null, ComposableLambdaKt.e(-1451031810, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.c5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InsightsScreenHabitsListKt.r(appDistractionType, graphData, str, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 3072, 7);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.d5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenHabitsListKt.s(str, graphData, appDistractionType, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(AppDistractionType appDistractionType, GraphData graphData, String str, BoxScope BorderedBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BorderedBox, "$this$BorderedBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1451031810, i3, -1, "cz.mobilesoft.coreblock.scene.insights.PeakTimeSection.<anonymous> (InsightsScreenHabitsList.kt:228)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Modifier modifierH2 = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.i(), composer, 48);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierH2);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            String strB = StringResources_androidKt.b(R.string.Yg, composer, 0);
            TextStyle textStyleG = ComposeTypographyKt.g(composer, 0).g();
            Modifier modifierM = PaddingKt.m(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), 0.0f, 0.0f, Dp.g(16), 0.0f, 11, null);
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(strB, modifierM, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.f()), 0L, 0, false, 0, 0, null, textStyleG, composer, 0, 0, 65016);
            if (str == null) {
                composer.a0(-1739148585);
                composer.U();
            } else {
                composer.a0(-1739148584);
                TextKt.c(str, null, appDistractionType != null ? appDistractionType.m1357getColor0d7_KjU() : GraphConfiguration.f132742q.c(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.b()), 0L, 0, false, 1, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 3072, 56826);
                composer.U();
            }
            composer.y();
            BarGraphKt.m(null, graphData, new GraphConfiguration(false, false, false, false, false, false, Color.n(appDistractionType != null ? appDistractionType.m1357getColor0d7_KjU() : GraphConfiguration.f132742q.c()), null, null, null, true, false, null, false, null, null, 64416, null), 0L, Dp.g(96), null, composer, (GraphData.f132767h << 3) | 24576 | (GraphConfiguration.f132743r << 6), 41);
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
    public static final Unit s(String str, GraphData graphData, AppDistractionType appDistractionType, int i3, Composer composer, int i4) {
        q(str, graphData, appDistractionType, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void t(final Map averageDailyScreenTime, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(averageDailyScreenTime, "averageDailyScreenTime");
        Composer composerK = composer.k(214015040);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(averageDailyScreenTime) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(214015040, i4, -1, "cz.mobilesoft.coreblock.scene.insights.UsageSection (InsightsScreenHabitsList.kt:277)");
            }
            final Density density = (Density) composerK.q(CompositionLocalsKt.f());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(0, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt.h();
                composerK.w(objG2);
            }
            final SnapshotStateMap snapshotStateMap = (SnapshotStateMap) objG2;
            Integer numValueOf = Integer.valueOf(snapshotStateMap.k().size());
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = new InsightsScreenHabitsListKt$UsageSection$1$1(snapshotStateMap, mutableState, null);
                composerK.w(objG3);
            }
            EffectsKt.g(numValueOf, (Function2) objG3, composerK, 0);
            o(null, null, PaddingKt.a(Dp.g(8)), ComposableLambdaKt.e(1732044987, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.a5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InsightsScreenHabitsListKt.w(averageDailyScreenTime, density, snapshotStateMap, mutableState, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 3456, 3);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.b5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenHabitsListKt.y(averageDailyScreenTime, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int u(MutableState mutableState) {
        return ((Number) mutableState.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(MutableState mutableState, int i3) {
        mutableState.setValue(Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Map map, Density density, final SnapshotStateMap snapshotStateMap, MutableState mutableState, BoxScope BorderedBox, Composer composer, int i3) {
        final AppDistractionType appDistractionType;
        char c3;
        Intrinsics.checkNotNullParameter(BorderedBox, "$this$BorderedBox");
        int i4 = (i3 & 6) == 0 ? i3 | (composer.Z(BorderedBox) ? 4 : 2) : i3;
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1732044987, i4, -1, "cz.mobilesoft.coreblock.scene.insights.UsageSection.<anonymous> (InsightsScreenHabitsList.kt:293)");
            }
            float f3 = 8;
            Modifier modifierI = PaddingKt.i(SizeKt.h(Modifier.b8, 0.0f, 1, null), Dp.g(f3));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.o(Dp.g(16)), Alignment.f25072a.k(), composer, 6);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            int i5 = 0;
            TextKt.c(StringResources_androidKt.b(R.string.Eh, composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.f()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 0, 0, 65018);
            Composer composer2 = composer;
            Double dMaxOrNull = CollectionsKt.maxOrNull((Iterable<? extends Double>) map.values());
            double dDoubleValue = dMaxOrNull != null ? dMaxOrNull.doubleValue() : 0.0d;
            double dSumOfDouble = CollectionsKt.sumOfDouble(map.values());
            composer2.a0(-1921575859);
            for (Map.Entry entry : map.entrySet()) {
                AppDistractionType appDistractionType2 = (AppDistractionType) entry.getKey();
                double dDoubleValue2 = ((Number) entry.getValue()).doubleValue();
                int i6 = (int) ((dDoubleValue2 / dSumOfDouble) * ((double) 100));
                float f4 = (float) (dDoubleValue2 / dDoubleValue);
                Alignment.Companion companion2 = Alignment.f25072a;
                Alignment.Vertical verticalI = companion2.i();
                Modifier.Companion companion3 = Modifier.b8;
                MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), verticalI, composer2, 48);
                int iA2 = ComposablesKt.a(composer2, i5);
                CompositionLocalMap compositionLocalMapU2 = composer2.u();
                Modifier modifierF2 = ComposedModifierKt.f(composer2, companion3);
                ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
                Function0 function0A2 = companion4.a();
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
                Updater.e(composerA2, measurePolicyB, companion4.e());
                Updater.e(composerA2, compositionLocalMapU2, companion4.g());
                Function2 function2B2 = companion4.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion4.f());
                RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
                InsightsScreenComponentsKt.e1(null, 0.0f, appDistractionType2, composer2, 0, 3);
                float f5 = 4;
                Modifier modifierM = PaddingKt.m(RowScope.c(rowScopeInstance, companion3, 1.0f, false, 2, null), Dp.g(f5), 0.0f, 0.0f, 0.0f, 14, null);
                String strB = StringResources_androidKt.b(appDistractionType2.getNameRes(), composer2, i5);
                TextStyle textStyleI = ComposeTypographyKt.g(composer2, i5).i();
                long jP = ComposeColorsKt.j(composer2, i5).p();
                TextOverflow.Companion companion5 = TextOverflow.f29661b;
                TextKt.c(strB, modifierM, jP, 0L, null, null, null, 0L, null, null, 0L, companion5.b(), false, 1, 0, null, textStyleI, composer, 0, 3504, 51192);
                SpacerKt.a(SizeKt.A(companion3, Dp.g(12)), composer, 6);
                Modifier modifierC = RowScope.c(rowScopeInstance, companion3, 1.0f, false, 2, null);
                MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
                int iA3 = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU3 = composer.u();
                Modifier modifierF3 = ComposedModifierKt.f(composer, modifierC);
                Function0 function0A3 = companion4.a();
                if (composer.m() == null) {
                    ComposablesKt.c();
                }
                composer.L();
                if (composer.i()) {
                    composer.P(function0A3);
                } else {
                    composer.v();
                }
                Composer composerA3 = Updater.a(composer);
                Updater.e(composerA3, measurePolicyG, companion4.e());
                Updater.e(composerA3, compositionLocalMapU3, companion4.g());
                Function2 function2B3 = companion4.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF3, companion4.f());
                BoxKt.a(BoxScopeInstance.f6642a.f(BackgroundKt.c(SizeKt.i(SizeKt.g(companion3, f4), Dp.g(f3)), appDistractionType2.m1357getColor0d7_KjU(), RoundedCornerShapeKt.d(Dp.g(f5))), companion2.f()), composer, 0);
                composer.y();
                Modifier modifierM2 = PaddingKt.m(companion3, Dp.g(f3), 0.0f, 0.0f, 0.0f, 14, null);
                Modifier modifierA = companion3;
                boolean zE = composer.e(appDistractionType2.ordinal());
                Object objG = composer.G();
                if (zE || objG == Composer.f23746a.a()) {
                    appDistractionType = appDistractionType2;
                    objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.insights.e5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return InsightsScreenHabitsListKt.x(snapshotStateMap, appDistractionType, (IntSize) obj);
                        }
                    };
                    composer.w(objG);
                } else {
                    appDistractionType = appDistractionType2;
                }
                Modifier modifierA2 = OnRemeasuredModifierKt.a(modifierM2, (Function1) objG);
                if (u(mutableState) > 0) {
                    c3 = 2;
                    modifierA = SizeKt.A(modifierA, Dp.g(density.F(u(mutableState)) + Dp.g(2)));
                } else {
                    c3 = 2;
                }
                TextKt.c(i6 + " %", modifierA2.then(modifierA), appDistractionType.m1357getColor0d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.b()), 0L, companion5.b(), false, 1, 0, null, ComposeTypographyKt.g(composer, 0).i(), composer, 0, 3504, 50680);
                composer2 = composer;
                composer2.y();
                i5 = 0;
            }
            composer2.U();
            composer2.y();
            Modifier.Companion companion6 = Modifier.b8;
            Alignment.Companion companion7 = Alignment.f25072a;
            Modifier modifierF4 = BorderedBox.f(companion6, companion7.n());
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion7.o(), false);
            int iA4 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU4 = composer2.u();
            Modifier modifierF5 = ComposedModifierKt.f(composer2, modifierF4);
            ComposeUiNode.Companion companion8 = ComposeUiNode.f8;
            Function0 function0A4 = companion8.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A4);
            } else {
                composer2.v();
            }
            Composer composerA4 = Updater.a(composer2);
            Updater.e(composerA4, measurePolicyG2, companion8.e());
            Updater.e(composerA4, compositionLocalMapU4, companion8.g());
            Function2 function2B4 = companion8.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                composerA4.w(Integer.valueOf(iA4));
                composerA4.p(Integer.valueOf(iA4), function2B4);
            }
            Updater.e(composerA4, modifierF5, companion8.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            TooltipKt.k(StringResources_androidKt.b(R.string.YD, composer2, 0), null, null, ComposeColorsKt.j(composer2, 0).F(), 0.0f, null, composer, 0, 54);
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
    public static final Unit x(SnapshotStateMap snapshotStateMap, AppDistractionType appDistractionType, IntSize intSize) {
        Integer num = (Integer) snapshotStateMap.get(appDistractionType);
        int iJ = (int) (intSize.j() >> 32);
        if (num == null || num.intValue() != iJ) {
            snapshotStateMap.put(appDistractionType, Integer.valueOf((int) (intSize.j() >> 32)));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(Map map, int i3, Composer composer, int i4) {
        t(map, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
