package cz.mobilesoft.coreblock.scene.dashboard.blocking.pause;

import android.content.Context;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconKt;
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
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
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
import cz.mobilesoft.coreblock.storage.room.entity.core.SchedulePauseHistoryEntity;
import cz.mobilesoft.coreblock.storage.room.entity.core.SchedulePauseHistoryEntityKt;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParserException;

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
public final class PauseBlockingWarningScreenKt {
    public static final void f(final Function0 onBackClicked, final Function0 onPauseClicked, final PauseBlockingViewState viewState, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(onBackClicked, "onBackClicked");
        Intrinsics.checkNotNullParameter(onPauseClicked, "onPauseClicked");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Composer composerK = composer.k(-1716159957);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onBackClicked) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onPauseClicked) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(viewState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1716159957, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingWarningScreen (PauseBlockingWarningScreen.kt:67)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, ComposableLambdaKt.e(786147769, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.s0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PauseBlockingWarningScreenKt.g(onBackClicked, viewState, context, onPauseClicked, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 12582912, 127);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.t0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PauseBlockingWarningScreenKt.k(onBackClicked, onPauseClicked, viewState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(final Function0 function0, PauseBlockingViewState pauseBlockingViewState, Context context, final Function0 function02, BoxScope GradientBox, Composer composer, int i3) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(786147769, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingWarningScreen.<anonymous> (PauseBlockingWarningScreen.kt:70)");
            }
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion.g();
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierK = PaddingKt.k(ScrollKt.g(SizeKt.f(WindowInsetsPaddingKt.d(companion2, WindowInsets_androidKt.c(WindowInsets.f7172a, composer, 6)), 0.0f, 1, null), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null), PrimitiveResources_androidKt.a(R.dimen.f95486t, composer, 0), 0.0f, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), horizontalG, composer, 48);
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
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6);
            Modifier modifierC = columnScopeInstance.c(companion2, companion.k());
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.u0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PauseBlockingWarningScreenKt.h(function0);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.q0(modifierC, imageVectorB, null, false, 0.0f, 0.0f, 0L, null, (Function0) objG, composer, 0, 252);
            SpacerKt.a(SizeKt.i(companion2, Dp.g(20)), composer, 6);
            String strB = StringResources_androidKt.b(R.string.xn, composer, 0);
            TextStyle textStyleF = ComposeTypographyKt.g(composer, 0).f();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            float f3 = 24;
            TextKt.c(strB, PaddingKt.k(companion2, Dp.g(f3), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleF, composer, 48, 0, 65020);
            SpacerKt.a(SizeKt.i(companion2, Dp.g(80)), composer, 6);
            TextKt.c(StringHelperExtKt.p(String.valueOf(pauseBlockingViewState.d().size()), "×", ""), null, ComposeColorsKt.j(composer, 0).b(), TextUnitKt.i(56), null, FontWeight.f29233b.l(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 199680, 0, 131026);
            TextKt.c(StringResources_androidKt.b(R.string.Cn, composer, 0), PaddingKt.k(companion2, Dp.g(f3), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 48, 0, 65020);
            float f4 = 4;
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f4)), composer, 6);
            Iterator it = pauseBlockingViewState.d().iterator();
            long jA = 0;
            while (it.hasNext()) {
                jA += SchedulePauseHistoryEntityKt.a((SchedulePauseHistoryEntity) it.next());
            }
            String strM = DateHelper.m(context, jA, true, true);
            Intrinsics.checkNotNullExpressionValue(strM, "getRemainingTimeString(...)");
            TextStyle textStyleA = ComposeTypographyKt.g(composer, 0).a();
            int iA2 = TextAlign.f29616b.a();
            long jQ = ComposeColorsKt.j(composer, 0).q();
            Modifier.Companion companion5 = Modifier.b8;
            TextKt.c(strM, PaddingKt.k(companion5, Dp.g(f3), 0.0f, 2, null), jQ, 0L, null, null, null, 0L, null, TextAlign.h(iA2), 0L, 0, false, 0, 0, null, textStyleA, composer, 48, 0, 65016);
            SpacerKt.a(SizeKt.i(companion5, Dp.g(40)), composer, 6);
            float f5 = 16;
            Modifier modifierH = SizeKt.h(BorderKt.f(PaddingKt.k(companion5, Dp.g(f5), 0.0f, 2, null), Dp.g((float) 0.5d), ComposeColorsKt.j(composer, 0).q(), RoundedCornerShapeKt.d(Dp.g(f5))), 0.0f, 1, null);
            Alignment.Companion companion6 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion6.o(), false);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierH);
            ComposeUiNode.Companion companion7 = ComposeUiNode.f8;
            Function0 function0A2 = companion7.a();
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
            Updater.e(composerA2, measurePolicyG, companion7.e());
            Updater.e(composerA2, compositionLocalMapU2, companion7.g());
            Function2 function2B2 = companion7.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA3))) {
                composerA2.w(Integer.valueOf(iA3));
                composerA2.p(Integer.valueOf(iA3), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion7.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Alignment.Vertical verticalI = companion6.i();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), verticalI, composer, 48);
            int iA4 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, companion5);
            Function0 function0A3 = companion7.a();
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
            Updater.e(composerA3, measurePolicyB, companion7.e());
            Updater.e(composerA3, compositionLocalMapU3, companion7.g());
            Function2 function2B3 = companion7.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA4))) {
                composerA3.w(Integer.valueOf(iA4));
                composerA3.p(Integer.valueOf(iA4), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion7.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            IconKt.a(PainterResources_androidKt.c(R.drawable.kb, composer, 0), null, SizeKt.v(PaddingKt.i(companion5, Dp.g(f5)), Dp.g(32)), ComposeColorsKt.j(composer, 0).b(), composer, 432, 0);
            SpacerKt.a(SizeKt.A(companion5, Dp.g(8)), composer, 6);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion6.k(), composer, 0);
            int iA5 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU4 = composer.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer, companion5);
            Function0 function0A4 = companion7.a();
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
            Updater.e(composerA4, measurePolicyA2, companion7.e());
            Updater.e(composerA4, compositionLocalMapU4, companion7.g());
            Function2 function2B4 = companion7.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA5))) {
                composerA4.w(Integer.valueOf(iA5));
                composerA4.p(Integer.valueOf(iA5), function2B4);
            }
            Updater.e(composerA4, modifierF4, companion7.f());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.f6666a;
            TextKt.c(StringResources_androidKt.b(R.string.OC, composer, 0), PaddingKt.m(companion5, 0.0f, Dp.g(f5), 0.0f, 0.0f, 13, null), ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 48, 0, 65528);
            SpacerKt.a(SizeKt.i(companion5, Dp.g(f4)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.aE, composer, 0), PaddingKt.m(companion5, 0.0f, 0.0f, 0.0f, Dp.g(f5), 7, null), ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 48, 0, 65528);
            composer.y();
            SpacerKt.a(RowScope.c(rowScopeInstance, companion5, 1.0f, false, 2, null), composer, 0);
            MeasurePolicy measurePolicyA3 = ColumnKt.a(arrangement.h(), companion6.j(), composer, 48);
            int iA6 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU5 = composer.u();
            Modifier modifierF5 = ComposedModifierKt.f(composer, companion5);
            Function0 function0A5 = companion7.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A5);
            } else {
                composer.v();
            }
            Composer composerA5 = Updater.a(composer);
            Updater.e(composerA5, measurePolicyA3, companion7.e());
            Updater.e(composerA5, compositionLocalMapU5, companion7.g());
            Function2 function2B5 = companion7.b();
            if (composerA5.i() || !Intrinsics.areEqual(composerA5.G(), Integer.valueOf(iA6))) {
                composerA5.w(Integer.valueOf(iA6));
                composerA5.p(Integer.valueOf(iA6), function2B5);
            }
            Updater.e(composerA5, modifierF5, companion7.f());
            TextKt.c(StringHelperExtKt.p(String.valueOf(pauseBlockingViewState.g().size()), "×", ""), PaddingKt.m(companion5, 0.0f, Dp.g(f5), 0.0f, 0.0f, 13, null), ComposeColorsKt.j(composer, 0).b(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 48, 0, 65528);
            SpacerKt.a(SizeKt.i(companion5, Dp.g(f4)), composer, 6);
            Iterator it2 = pauseBlockingViewState.g().iterator();
            long jA2 = 0;
            while (it2.hasNext()) {
                jA2 += SchedulePauseHistoryEntityKt.a((SchedulePauseHistoryEntity) it2.next());
            }
            String strM2 = DateHelper.m(context, jA2, true, true);
            Intrinsics.checkNotNullExpressionValue(strM2, "getRemainingTimeString(...)");
            TextStyle textStyleA2 = ComposeTypographyKt.g(composer, 0).a();
            long jQ2 = ComposeColorsKt.j(composer, 0).q();
            Modifier.Companion companion8 = Modifier.b8;
            TextKt.c(strM2, PaddingKt.m(companion8, 0.0f, 0.0f, 0.0f, Dp.g(f5), 7, null), jQ2, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleA2, composer, 48, 0, 65528);
            composer.y();
            SpacerKt.a(SizeKt.A(companion8, Dp.g(f5)), composer, 6);
            composer.y();
            composer.y();
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion8, 1.0f, false, 2, null), composer, 0);
            Modifier modifierI = PaddingKt.i(companion8, Dp.g(f5));
            MeasurePolicy measurePolicyA4 = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA7 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU6 = composer.u();
            Modifier modifierF6 = ComposedModifierKt.f(composer, modifierI);
            ComposeUiNode.Companion companion9 = ComposeUiNode.f8;
            Function0 function0A6 = companion9.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A6);
            } else {
                composer.v();
            }
            Composer composerA6 = Updater.a(composer);
            Updater.e(composerA6, measurePolicyA4, companion9.e());
            Updater.e(composerA6, compositionLocalMapU6, companion9.g());
            Function2 function2B6 = companion9.b();
            if (composerA6.i() || !Intrinsics.areEqual(composerA6.G(), Integer.valueOf(iA7))) {
                composerA6.w(Integer.valueOf(iA7));
                composerA6.p(Integer.valueOf(iA7), function2B6);
            }
            Updater.e(composerA6, modifierF6, companion9.f());
            ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.f6666a;
            float f6 = 56;
            Modifier modifierI2 = SizeKt.i(SizeKt.h(companion8, 0.0f, 1, null), Dp.g(f6));
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.xH, composer, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 15, null);
            boolean Z2 = composer.Z(function02);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.v0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PauseBlockingWarningScreenKt.i(function02);
                    }
                };
                composer.w(objG2);
            }
            ComposeButtonsKt.i0(modifierI2, big, accent, (Function0) objG2, composer, 6, 0);
            Modifier modifierI3 = SizeKt.i(SizeKt.h(PaddingKt.m(companion8, 0.0f, Dp.g(f5), 0.0f, 0.0f, 13, null), 0.0f, 1, null), Dp.g(f6));
            ButtonType.Big big2 = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.gi, composer, 0), 0.0f, 11, null);
            ButtonColor.Surface surface = new ButtonColor.Surface(false, null, false, null, null, 31, null);
            boolean Z3 = composer.Z(function0);
            Object objG3 = composer.G();
            if (Z3 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.w0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PauseBlockingWarningScreenKt.j(function0);
                    }
                };
                composer.w(objG3);
            }
            ComposeButtonsKt.i0(modifierI3, big2, surface, (Function0) objG3, composer, 6, 0);
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
    public static final Unit h(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Function0 function0) {
        AnswersHelper.f128199a.a5();
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Function0 function0) {
        AnswersHelper.f128199a.Z4();
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Function0 function0, Function0 function02, PauseBlockingViewState pauseBlockingViewState, int i3, Composer composer, int i4) {
        f(function0, function02, pauseBlockingViewState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
