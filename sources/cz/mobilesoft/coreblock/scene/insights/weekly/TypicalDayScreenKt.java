package cz.mobilesoft.coreblock.scene.insights.weekly;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.SpanStyle;
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
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.ScheduleTemplatesSectionKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.CardType;
import cz.mobilesoft.coreblock.view.compose.ComposeCardsKt;
import cz.mobilesoft.coreblock.view.graph.BarGraphKt;
import cz.mobilesoft.coreblock.view.graph.GraphConfiguration;
import cz.mobilesoft.coreblock.view.graph.GraphData;
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
public final class TypicalDayScreenKt {
    public static final void d(final WeeklyInsightsViewState viewState, Function1 onTap, final Function0 onNewScheduleClicked, Composer composer, final int i3) {
        int i4;
        final Function1 function1;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onTap, "onTap");
        Intrinsics.checkNotNullParameter(onNewScheduleClicked, "onNewScheduleClicked");
        Composer composerK = composer.k(985443520);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onTap) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onNewScheduleClicked) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(985443520, i4, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.TypicalDayScreen (TypicalDayScreen.kt:32)");
            }
            function1 = onTap;
            ComponentsKt.k(StringResources_androidKt.b(R.string.JG, composerK, 0), HtmlTextKt.e(StringResources_androidKt.b(R.string.KG, composerK, 0), (3 & 1) != 0 ? new SpanStyle(Color.f25715b.b(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.f29625b.d(), (Shadow) null, 12286, (DefaultConstructorMarker) null) : null, (3 & 2) != 0 ? MapsKt.emptyMap() : null), false, function1, ComposableLambdaKt.e(193771622, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.d1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TypicalDayScreenKt.e(viewState, onNewScheduleClicked, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.e1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TypicalDayScreenKt.g(viewState, function1, onNewScheduleClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(WeeklyInsightsViewState weeklyInsightsViewState, Function0 function0, ColumnScope BaseWeeklyInsightsScreen, Composer composer, int i3) {
        int i4;
        Composer composer2;
        Composer composer3;
        Composer composer4 = composer;
        Intrinsics.checkNotNullParameter(BaseWeeklyInsightsScreen, "$this$BaseWeeklyInsightsScreen");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer4.Z(BaseWeeklyInsightsScreen) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer4.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(193771622, i4, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.TypicalDayScreen.<anonymous> (TypicalDayScreen.kt:38)");
            }
            String strT = weeklyInsightsViewState.t();
            if (strT == null) {
                composer4.a0(214397073);
            } else {
                composer4.a0(214397074);
                TextKt.c(strT, SizeKt.h(Modifier.b8, 0.0f, 1, null), ComposeColorsKt.j(composer4, 0).b(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer4, 0).e(), composer, 48, 0, 65016);
                composer4 = composer;
            }
            composer4.U();
            Modifier.Companion companion = Modifier.b8;
            SpacerKt.a(SizeKt.i(companion, Dp.g(12)), composer4, 6);
            GraphData graphDataK = weeklyInsightsViewState.k();
            if (graphDataK == null) {
                composer4.a0(214786278);
                composer4.U();
                composer2 = composer4;
            } else {
                composer4.a0(214786279);
                composer2 = composer;
                BarGraphKt.m(null, graphDataK, new GraphConfiguration(false, false, false, false, false, false, Color.n(GraphConfiguration.f132742q.c()), null, null, null, true, false, null, false, null, null, 64420, null), 0L, 0.0f, null, composer2, 0, 57);
                composer2.U();
            }
            SpacerKt.a(SizeKt.i(companion, Dp.g(36)), composer2, 6);
            SpacerKt.a(ColumnScope.b(BaseWeeklyInsightsScreen, companion, 1.0f, false, 2, null), composer2, 0);
            if (weeklyInsightsViewState.i()) {
                composer2.a0(1530973112);
                final String strT2 = weeklyInsightsViewState.t();
                if (strT2 == null) {
                    composer2.a0(215526217);
                    composer2.U();
                    composer3 = composer2;
                } else {
                    composer2.a0(215526218);
                    ComponentsKt.o(StringResources_androidKt.b(R.string.cw, composer2, 0), composer2, 0);
                    SpacerKt.a(SizeKt.i(companion, Dp.g(26)), composer2, 6);
                    composer3 = composer2;
                    ComposeCardsKt.m(SizeKt.k(companion, Dp.g(120), 0.0f, 2, null), new CardType.Custom(ComposeColorsKt.j(composer2, 0).e(), Color.n(ComposeColorsKt.j(composer2, 0).F()), null, Dp.d(Dp.g(1)), 4, null), function0, ComposableLambdaKt.e(1501323620, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.f1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TypicalDayScreenKt.f(strT2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer2, 54), composer3, 3078, 0);
                    composer3.U();
                }
            } else {
                composer3 = composer2;
                composer3.a0(212699452);
            }
            composer3.U();
            SpacerKt.a(SizeKt.i(companion, Dp.g(44)), composer3, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer4.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(String str, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1501323620, i3, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.TypicalDayScreen.<anonymous>.<anonymous>.<anonymous> (TypicalDayScreen.kt:82)");
            }
            ScheduleTemplatesSectionKt.O(R.drawable.S4, R.string.g4, ScheduleEmoji.Timer, str, composer, 384);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(WeeklyInsightsViewState weeklyInsightsViewState, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        d(weeklyInsightsViewState, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
