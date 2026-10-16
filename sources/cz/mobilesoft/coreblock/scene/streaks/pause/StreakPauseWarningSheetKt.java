package cz.mobilesoft.coreblock.scene.streaks.pause;

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
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.material3.SheetState;
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
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.streaks.StreakConfiguration;
import cz.mobilesoft.coreblock.scene.streaks.StreakEvaluator;
import cz.mobilesoft.coreblock.scene.streaks.pause.StreakPauseWarningSheetKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBottomSheetsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StreakPauseWarningSheetKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f121038a;

        static {
            int[] iArr = new int[StreakEvaluator.PauseSummary.LossTrigger.values().length];
            try {
                iArr[StreakEvaluator.PauseSummary.LossTrigger.PAUSE_TOO_LONG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StreakEvaluator.PauseSummary.LossTrigger.TOO_MANY_PAUSES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f121038a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final StreakEvaluator.PauseRisk pauseRisk, Function0 function0, Function0 function02, Composer composer, final int i3) {
        int i4;
        final Function0 function03;
        final Function0 function04;
        Composer composerK = composer.k(1406523535);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(pauseRisk) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function0) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function02) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i5 = i4;
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1406523535, i5, -1, "cz.mobilesoft.coreblock.scene.streaks.pause.StreakPauseWarningContent (StreakPauseWarningSheet.kt:68)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierM = PaddingKt.m(PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(16), 0.0f, 2, null), 0.0f, Dp.g(48), 0.0f, Dp.g(24), 5, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion2.g();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.o(Dp.g(12)), horizontalG, composerK, 54);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.i(), composerK, 48);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, companion);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.L5, composerK, 6), null, SizeKt.v(companion, Dp.g(50)), Color.f25715b.k(), composerK, 3504, 0);
            float f3 = 8;
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composerK, 6);
            TextKt.c(String.valueOf(pauseRisk.b()), null, ComposeColorsKt.j(composerK, 0).p(), TextUnitKt.i(56), null, FontWeight.f29233b.b(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerK, 199680, 0, 131026);
            composerK.y();
            String strB = StringResources_androidKt.b(R.string.wB, composerK, 0);
            MaterialTheme materialTheme = MaterialTheme.f13091a;
            int i6 = MaterialTheme.f13092b;
            TextStyle textStyleF = materialTheme.c(composerK, i6).f();
            long jP = ComposeColorsKt.j(composerK, 0).p();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(strB, null, jP, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleF, composerK, 0, 0, 65018);
            TextKt.c(l(pauseRisk, composerK, i5 & 14), null, ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, materialTheme.c(composerK, i6).a(), composerK, 0, 0, 65018);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            FlatButtonsKt.u(null, 0.0f, 0.0f, null, FlatButtonColors.Primary.f131166a, null, StringResources_androidKt.b(R.string.vB, composerK, 0), null, 0L, null, null, false, false, function0, composerK, 24576, (i5 << 6) & 7168, 8111);
            function04 = function02;
            function03 = function0;
            FlatButtonsKt.u(null, 0.0f, 0.0f, null, FlatButtonColors.Secondary.f131167a, null, StringResources_androidKt.b(R.string.uB, composerK, 0), null, 0L, null, null, false, false, function04, composerK, 24576, (i5 << 3) & 7168, 8111);
            composerK = composerK;
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function03 = function0;
            function04 = function02;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: w1.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreakPauseWarningSheetKt.e(pauseRisk, function03, function04, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(StreakEvaluator.PauseRisk pauseRisk, Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        d(pauseRisk, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void f(final StreakEvaluator.PauseRisk risk, final Function0 onTakeBack, final Function0 onPauseAnyway, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(risk, "risk");
        Intrinsics.checkNotNullParameter(onTakeBack, "onTakeBack");
        Intrinsics.checkNotNullParameter(onPauseAnyway, "onPauseAnyway");
        Composer composerK = composer.k(1059583593);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(risk) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onTakeBack) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onPauseAnyway) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1059583593, i4, -1, "cz.mobilesoft.coreblock.scene.streaks.pause.StreakPauseWarningSheet (StreakPauseWarningSheet.kt:47)");
            }
            function0 = onTakeBack;
            ComposeBottomSheetsKt.f(null, null, true, ComposableLambdaKt.e(1799228328, true, new Function4() { // from class: w1.h
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return StreakPauseWarningSheetKt.g(risk, onTakeBack, onPauseAnyway, (ColumnScope) obj, (SheetState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerK, 54), null, function0, composerK, ((i4 << 12) & 458752) | 3456, 19);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onTakeBack;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: w1.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreakPauseWarningSheetKt.h(risk, function0, onPauseAnyway, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(StreakEvaluator.PauseRisk pauseRisk, Function0 function0, Function0 function02, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1799228328, i3, -1, "cz.mobilesoft.coreblock.scene.streaks.pause.StreakPauseWarningSheet.<anonymous> (StreakPauseWarningSheet.kt:52)");
            }
            d(pauseRisk, function0, function02, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(StreakEvaluator.PauseRisk pauseRisk, Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        f(pauseRisk, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakEvaluator.PauseRisk k(StreakEvaluator.PauseSummary.LossTrigger lossTrigger) {
        return new StreakEvaluator.PauseRisk(12, 3, TimeUnit.MINUTES.toMillis(30L), lossTrigger);
    }

    private static final String l(StreakEvaluator.PauseRisk pauseRisk, Composer composer, int i3) {
        String strC;
        if (ComposerKt.M()) {
            ComposerKt.U(1503749472, i3, -1, "cz.mobilesoft.coreblock.scene.streaks.pause.warningText (StreakPauseWarningSheet.kt:129)");
        }
        int i4 = WhenMappings.f121038a[pauseRisk.c().ordinal()];
        if (i4 == 1) {
            composer.a0(1994241993);
            strC = StringResources_androidKt.c(R.string.xB, new Object[]{StringResources_androidKt.c(R.string.Nj, new Object[]{Integer.valueOf((int) TimeUnit.MILLISECONDS.toMinutes(StreakConfiguration.f120230a.a()))}, composer, 0)}, composer, 0);
            composer.U();
        } else {
            if (i4 != 2) {
                composer.a0(1994233802);
                composer.U();
                throw new NoWhenBranchMatchedException();
            }
            composer.a0(1994254415);
            strC = StringResources_androidKt.c(R.string.yB, new Object[]{Integer.valueOf(pauseRisk.a())}, composer, 0);
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return strC;
    }
}
