package cz.mobilesoft.coreblock.scene.insights.weekly;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewState;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.graph.PieGraphKt;
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
public final class TotalScreenTimeScreenKt {
    public static final void c(final WeeklyInsightsViewState viewState, Function1 onTap, Composer composer, final int i3) {
        int i4;
        final Function1 function1;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onTap, "onTap");
        Composer composerK = composer.k(-717117532);
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
                ComposerKt.U(-717117532, i4, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.TotalScreenTimeScreen (TotalScreenTimeScreen.kt:31)");
            }
            composerK.a0(-1955176554);
            final float F = ((Density) composerK.q(CompositionLocalsKt.f())).F((int) (((WindowInfo) composerK.q(CompositionLocalsKt.u())).a() & 4294967295L));
            composerK.U();
            String strB = StringResources_androidKt.b(R.string.uA, composerK, 0);
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            int i5 = R.string.BG;
            String strY = viewState.y();
            if (strY == null) {
                strY = "";
            }
            function1 = onTap;
            ComponentsKt.k(strB, StringHelperExtKt.k(context, i5, strY, ComposeColorsKt.j(composerK, 0).b()), false, function1, ComposableLambdaKt.e(-1508789430, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.z0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TotalScreenTimeScreenKt.d(viewState, F, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.a1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TotalScreenTimeScreenKt.e(viewState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(WeeklyInsightsViewState weeklyInsightsViewState, float f3, ColumnScope BaseWeeklyInsightsScreen, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(BaseWeeklyInsightsScreen, "$this$BaseWeeklyInsightsScreen");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(BaseWeeklyInsightsScreen) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1508789430, i4, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.TotalScreenTimeScreen.<anonymous> (TotalScreenTimeScreen.kt:44)");
            }
            Modifier.Companion companion = Modifier.b8;
            SpacerKt.a(ColumnScope.b(BaseWeeklyInsightsScreen, companion, 1.0f, false, 2, null), composer, 0);
            PieGraphKt.d(null, weeklyInsightsViewState.e(), 0.0f, Dp.g(0.35f * f3), composer, 0, 5);
            SpacerKt.a(ColumnScope.b(BaseWeeklyInsightsScreen, companion, 1.0f, false, 2, null), composer, 0);
            Modifier modifierK = SizeKt.k(SizeKt.h(companion, 0.0f, 1, null), WeeklyInsightsActivity.f103883g.a(), 0.0f, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.g(), composer, 54);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            if (weeklyInsightsViewState.f() == null) {
                composer.a0(1160785638);
                composer.U();
            } else {
                composer.a0(1160785639);
                Context context = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
                int i5 = R.string.AG;
                TextKt.d(StringHelperExtKt.k(context, i5, ((int) ((r0.longValue() / InsightsViewState.Y.a()) * 100)) + " %", ComposeColorsKt.j(composer, 0).b()), null, ComposeColorsKt.j(composer, 0).L(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 130554);
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
    public static final Unit e(WeeklyInsightsViewState weeklyInsightsViewState, Function1 function1, int i3, Composer composer, int i4) {
        c(weeklyInsightsViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
