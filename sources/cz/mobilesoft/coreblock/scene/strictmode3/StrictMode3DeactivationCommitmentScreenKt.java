package cz.mobilesoft.coreblock.scene.strictmode3;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material.TextKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.lifecycle.compose.FlowExtKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.StrictModeDeactivation;
import cz.mobilesoft.coreblock.enums.StrictModeState;
import cz.mobilesoft.coreblock.scene.strictmode3.component.StrictModeBallKt;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.Flow;

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
public final class StrictMode3DeactivationCommitmentScreenKt {
    public static final void h(final int i3, final long j3, final Function0 onCloseClicked, final Function1 onContinueClicked, Composer composer, final int i4) {
        final int i5;
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Intrinsics.checkNotNullParameter(onContinueClicked, "onContinueClicked");
        Composer composerK = composer.k(488944243);
        if ((i4 & 6) == 0) {
            i5 = i3;
            i6 = (composerK.e(i5) ? 4 : 2) | i4;
        } else {
            i5 = i3;
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= composerK.f(j3) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i6 |= composerK.I(onCloseClicked) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 3072) == 0) {
            i6 |= composerK.I(onContinueClicked) ? 2048 : 1024;
        }
        if (composerK.r((i6 & 1171) != 1170, i6 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(488944243, i6, -1, "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3DeactivationScreen (StrictMode3DeactivationCommitmentScreen.kt:103)");
            }
            composer2 = composerK;
            ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, ComposableLambdaKt.e(-364859483, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.s
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StrictMode3DeactivationCommitmentScreenKt.i(i5, onContinueClicked, onCloseClicked, j3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 12582912, 127);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictMode3DeactivationCommitmentScreenKt.q(i3, j3, onCloseClicked, onContinueClicked, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(final int i3, final Function1 function1, final Function0 function0, final long j3, BoxScope GradientBox, Composer composer, int i4) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-364859483, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3DeactivationScreen.<anonymous> (StrictMode3DeactivationCommitmentScreen.kt:105)");
            }
            ScaffoldKt.a(WindowInsetsPaddingKt.d(SizeKt.f(Modifier.b8, 0.0f, 1, null), WindowInsets_androidKt.c(WindowInsets.f7172a, composer, 6)), null, ComposableLambdaKt.e(-269576022, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictMode3DeactivationCommitmentScreenKt.j(i3, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, null, 0, Color.f25715b.j(), 0L, null, ComposableLambdaKt.e(-2045229580, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.v
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StrictMode3DeactivationCommitmentScreenKt.m(function0, j3, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 806879616, 442);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(int i3, final Function1 function1, Composer composer, int i4) {
        if (composer.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-269576022, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3DeactivationScreen.<anonymous>.<anonymous> (StrictMode3DeactivationCommitmentScreen.kt:111)");
            }
            String strT = ComposableExtKt.t(R.plurals.f95744e, i3, new Object[]{Integer.valueOf(i3)}, composer, 0);
            Modifier.Companion companion = Modifier.b8;
            float f3 = 12;
            Modifier modifierM = PaddingKt.m(PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null), 0.0f, Dp.g(f3), 0.0f, Dp.g(40), 5, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion2.g();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.o(Dp.g(24)), horizontalG, composer, 54);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierM);
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
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.o(Dp.g(f3)), companion2.g(), composer, 54);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierH);
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
            Updater.e(composerA2, measurePolicyA2, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            String strC = StringResources_androidKt.c(R.string.nF, new Object[]{strT}, composer, 0);
            FlatButtonColors.Primary primary = FlatButtonColors.Primary.f131166a;
            TextStyle textStyleG = ComposeTypographyKt.g(composer, 0).g();
            FontWeight.Companion companion4 = FontWeight.f29233b;
            TextStyle textStyleE = TextStyle.e(textStyleG, 0L, 0L, companion4.h(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null);
            long jI = TextUnitKt.i(20);
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.w
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictMode3DeactivationCommitmentScreenKt.k(function1);
                    }
                };
                composer.w(objG);
            }
            FlatButtonsKt.u(null, 0.0f, 0.0f, null, primary, null, strC, textStyleE, jI, null, null, false, false, (Function0) objG, composer, 100687872, 0, 7727);
            String strB = StringResources_androidKt.b(R.string.SB, composer, 0);
            TextStyle textStyleE2 = TextStyle.e(ComposeTypographyKt.g(composer, 0).d(), 0L, 0L, companion4.g(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null);
            long jQ = ComposeColorsKt.j(composer, 0).q();
            TextAlign.Companion companion5 = TextAlign.f29616b;
            TextKt.c(strB, SizeKt.h(companion, 0.0f, 1, null), jQ, 0L, null, null, null, 0L, null, TextAlign.h(companion5.a()), 0L, 0, false, 0, 0, null, textStyleE2, composer, 48, 0, 65016);
            composer.y();
            Modifier modifierH2 = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyA3 = ColumnKt.a(arrangement.o(Dp.g(f3)), companion2.g(), composer, 54);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, modifierH2);
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
            Updater.e(composerA3, measurePolicyA3, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            String strB2 = StringResources_androidKt.b(R.string.QE, composer, 0);
            FlatButtonColors flatButtonColorsB = FlatButtonColors.b(FlatButtonColors.Secondary.f131167a, Color.n(ComposeColorsKt.j(composer, 0).O()), null, 2, null);
            TextStyle textStyleE3 = TextStyle.e(ComposeTypographyKt.g(composer, 0).g(), 0L, 0L, companion4.h(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null);
            long jI2 = TextUnitKt.i(20);
            boolean Z2 = composer.Z(function1);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.x
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictMode3DeactivationCommitmentScreenKt.l(function1);
                    }
                };
                composer.w(objG2);
            }
            FlatButtonsKt.u(null, 0.0f, 0.0f, null, flatButtonColorsB, null, strB2, textStyleE3, jI2, null, null, false, false, (Function0) objG2, composer, 100663296, 0, 7727);
            TextKt.c(StringResources_androidKt.b(R.string.RE, composer, 0), SizeKt.h(companion, 0.0f, 1, null), ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion5.a()), 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composer, 0).d(), 0L, 0L, companion4.g(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 48, 0, 65016);
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
    public static final Unit k(Function1 function1) {
        AnswersHelper.f128199a.A7();
        function1.invoke(StrictModeDeactivation.Pause);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Function1 function1) {
        function1.invoke(StrictModeDeactivation.Deactivate);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Function0 function0, long j3, PaddingValues paddingValues, Composer composer, int i3) {
        int i4;
        final MutableIntState mutableIntState;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(paddingValues) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2045229580, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3DeactivationScreen.<anonymous>.<anonymous> (StrictMode3DeactivationCommitmentScreen.kt:174)");
            }
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotIntStateKt.a(0);
                composer.w(objG);
            }
            MutableIntState mutableIntState2 = (MutableIntState) objG;
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierM = PaddingKt.m(PaddingKt.k(PaddingKt.h(SizeKt.f(companion2, 0.0f, 1, null), paddingValues), PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null), 0.0f, Dp.g(8), 0.0f, 0.0f, 13, null);
            Alignment.Companion companion3 = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion3.g();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierM);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
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
            Updater.e(composerA, measurePolicyA, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Modifier modifierH = SizeKt.h(companion2, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion3.i(), composer, 48);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierH);
            Function0 function0A2 = companion4.a();
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
            Updater.e(composerA2, measurePolicyB, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion4.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            FlatButtonsKt.K(null, Dp.g(40), R.drawable.f95577x1, FlatButtonColors.Secondary.f131167a, null, function0, composer, 27696, 1);
            composer.y();
            float f3 = 28;
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composer, 6);
            String strB = StringResources_androidKt.b(R.string.Vx, composer, 0);
            TextStyle textStyleF = ComposeTypographyKt.g(composer, 0).f();
            FontWeight.Companion companion5 = FontWeight.f29233b;
            TextStyle textStyleE = TextStyle.e(textStyleF, 0L, 0L, companion5.h(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(34), null, null, null, 0, 0, null, 16646139, null);
            long jP = ComposeColorsKt.j(composer, 0).p();
            TextAlign.Companion companion6 = TextAlign.f29616b;
            TextKt.c(strB, SizeKt.h(companion2, 0.0f, 1, null), jP, 0L, null, null, null, 0L, null, TextAlign.h(companion6.a()), 0L, 0, false, 0, 0, null, textStyleE, composer, 48, 0, 65016);
            SpacerKt.a(SizeKt.i(companion2, Dp.g(12)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.Ux, composer, 0), SizeKt.h(companion2, 0.0f, 1, null), ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion6.a()), 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composer, 0).a(), 0L, 0L, companion5.g(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 48, 0, 65016);
            Modifier modifierB = ColumnScope.b(columnScopeInstance, SizeKt.h(companion2, 0.0f, 1, null), 1.0f, false, 2, null);
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                mutableIntState = mutableIntState2;
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.y
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictMode3DeactivationCommitmentScreenKt.p(mutableIntState, (IntSize) obj);
                    }
                };
                composer.w(objG2);
            } else {
                mutableIntState = mutableIntState2;
            }
            Modifier modifierA = OnRemeasuredModifierKt.a(modifierB, (Function1) objG2);
            MeasurePolicy measurePolicyG = BoxKt.g(companion3.e(), false);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, modifierA);
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
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            float F = ((Density) composer.q(CompositionLocalsKt.f())).F(n(mutableIntState));
            float f4 = 48;
            float fL = ((Dp) RangesKt.t(Dp.d(Dp.g(F - Dp.g(f4))), Dp.d(Dp.g(96)), Dp.d(Dp.g(200)))).l();
            float fL2 = ((Dp) RangesKt.t(Dp.d(Dp.g(0.24f * fL)), Dp.d(Dp.g(f3)), Dp.d(Dp.g(f4)))).l();
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion3.g(), composer, 48);
            int iA4 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU4 = composer.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer, companion2);
            Function0 function0A4 = companion4.a();
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
            Updater.e(composerA4, measurePolicyA2, companion4.e());
            Updater.e(composerA4, compositionLocalMapU4, companion4.g());
            Function2 function2B4 = companion4.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                composerA4.w(Integer.valueOf(iA4));
                composerA4.p(Integer.valueOf(iA4), function2B4);
            }
            Updater.e(composerA4, modifierF4, companion4.f());
            StrictModeBallKt.r(StrictModeState.Active, null, Dp.d(fL), fL2, false, composer, 6, 18);
            TextKt.c(r(j3, composer, 0), SizeKt.h(companion2, 0.0f, 1, null), ComposeColorsKt.j(composer, 0).j0(), 0L, null, null, null, 0L, null, TextAlign.h(companion6.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).i(), composer, 48, 0, 65016);
            composer.y();
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

    private static final int n(MutableIntState mutableIntState) {
        return mutableIntState.g();
    }

    private static final void o(MutableIntState mutableIntState, int i3) {
        mutableIntState.a(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(MutableIntState mutableIntState, IntSize intSize) {
        o(mutableIntState, (int) (intSize.j() & 4294967295L));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(int i3, long j3, Function0 function0, Function1 function1, int i4, Composer composer, int i5) {
        h(i3, j3, function0, function1, composer, RecomposeScopeImplKt.a(i4 | 1));
        return Unit.f139807a;
    }

    private static final String r(long j3, Composer composer, int i3) {
        composer.a0(231255461);
        if (ComposerKt.M()) {
            ComposerKt.U(231255461, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.formatStrictModeActiveDuration (StrictMode3DeactivationCommitmentScreen.kt:257)");
        }
        TimeUnit timeUnit = TimeUnit.MINUTES;
        long millis = timeUnit.toMillis(15L);
        if (j3 <= 0) {
            composer.a0(204066741);
            String strB = StringResources_androidKt.b(R.string.QD, composer, 0);
            composer.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composer.U();
            return strB;
        }
        composer.a0(191365917);
        composer.U();
        Context context = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
        boolean z2 = (((i3 & 14) ^ 6) > 4 && composer.f(j3)) || (i3 & 6) == 4;
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            objG = TimeHelperExt.f128663a.d(j3, timeUnit.toMillis(1L));
            composer.w(objG);
        }
        State stateB = FlowExtKt.b((Flow) objG, Long.valueOf(RangesKt.g(TimeHelperExt.f128663a.f() - j3, 0L)), null, null, null, composer, 0, 14);
        if (s(stateB) < millis) {
            composer.a0(204631189);
            String strB2 = StringResources_androidKt.b(R.string.QD, composer, 0);
            composer.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composer.U();
            return strB2;
        }
        composer.a0(191365917);
        composer.U();
        String strC = StringResources_androidKt.c(R.string.IB, new Object[]{DateHelperExtKt.d(context, s(stateB))}, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strC;
    }

    private static final long s(State state) {
        return ((Number) state.getValue()).longValue();
    }
}
