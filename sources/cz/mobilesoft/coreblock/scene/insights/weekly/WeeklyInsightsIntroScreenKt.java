package cz.mobilesoft.coreblock.scene.insights.weekly;

import android.content.Context;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileImageKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
public final class WeeklyInsightsIntroScreenKt {
    public static final void d(final WeeklyInsightsViewState viewState, final Function1 onTap, Composer composer, final int i3) {
        int i4;
        String string;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onTap, "onTap");
        Composer composerK = composer.k(1079386658);
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
                ComposerKt.U(1079386658, i4, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.IntroScreen (WeeklyInsightsIntroScreen.kt:46)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            long jA = ((WindowInfo) composerK.q(CompositionLocalsKt.u())).a();
            final boolean z2 = ((int) (jA >> 32)) > ((int) (jA & 4294967295L));
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG2);
            }
            MutableState mutableState2 = (MutableState) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG3);
            }
            MutableState mutableState3 = (MutableState) objG3;
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                String strZ = viewState.z();
                if (strZ == null || strZ.length() == 0) {
                    string = context.getString(R.string.LG);
                } else {
                    String strZ2 = viewState.z();
                    String string2 = context.getString(R.string.LG);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    string = StringHelperExtKt.p(strZ2, StringHelperExtKt.e(string2), ", ");
                }
                objG4 = string;
                composerK.w(objG4);
            }
            final String str = (String) objG4;
            Intrinsics.checkNotNull(str);
            Unit unit = Unit.f139807a;
            Object objG5 = composerK.G();
            if (objG5 == companion.a()) {
                objG5 = new WeeklyInsightsIntroScreenKt$IntroScreen$1$1(mutableState2, mutableState3, null);
                composerK.w(objG5);
            }
            EffectsKt.g(unit, (Function2) objG5, composerK, 6);
            Modifier.Companion companion2 = Modifier.b8;
            int i5 = i4;
            Modifier modifierF = SizeKt.f(companion2, 0.0f, 1, null);
            boolean z3 = (i5 & 112) == 32;
            Object objG6 = composerK.G();
            if (z3 || objG6 == companion.a()) {
                objG6 = new PointerInputEventHandler() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.WeeklyInsightsIntroScreenKt$IntroScreen$2$1
                    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                    public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                        Object objM = TapGestureDetectorKt.m(pointerInputScope, null, null, null, onTap, continuation, 7, null);
                        return objM == IntrinsicsKt.f() ? objM : Unit.f139807a;
                    }
                };
                composerK.w(objG6);
            }
            Modifier modifierD = SuspendingPointerInputFilterKt.d(modifierF, unit, (PointerInputEventHandler) objG6);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierD);
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
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            AnimatedVisibilityKt.j(((Boolean) mutableState2.getValue()).booleanValue(), PaddingKt.m(SizeKt.h(companion2, 0.0f, 1, null), 0.0f, Dp.g(32), 0.0f, 0.0f, 13, null), EnterExitTransitionKt.o(AnimationSpecKt.n(1500, 0, null, 6, null), 0.0f, 2, null), null, null, ComposableLambdaKt.e(36663812, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.u2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return WeeklyInsightsIntroScreenKt.e(z2, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 197040, 24);
            AnimatedVisibilityKt.j(((Boolean) mutableState3.getValue()).booleanValue(), null, EnterExitTransitionKt.o(AnimationSpecKt.n(1500, 0, null, 6, null), 0.0f, 2, null), null, null, ComposableLambdaKt.e(-1645389715, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.v2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return WeeklyInsightsIntroScreenKt.f(viewState, str, context, mutableState, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 196992, 26);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.weekly.w2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WeeklyInsightsIntroScreenKt.g(viewState, onTap, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(boolean z2, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(36663812, i3, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.IntroScreen.<anonymous>.<anonymous> (WeeklyInsightsIntroScreen.kt:87)");
        }
        ImageKt.a(PainterResources_androidKt.c(R.drawable.n7, composer, 0), null, SizeKt.h(Modifier.b8, 0.0f, 1, null), null, z2 ? ContentScale.f27054a.c() : ContentScale.f27054a.d(), 0.0f, null, composer, 432, 104);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(WeeklyInsightsViewState weeklyInsightsViewState, String str, Context context, MutableState mutableState, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        Modifier.Companion companion;
        Composer composer2;
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(-1645389715, i3, -1, "cz.mobilesoft.coreblock.scene.insights.weekly.IntroScreen.<anonymous>.<anonymous> (WeeklyInsightsIntroScreen.kt:99)");
        }
        Modifier.Companion companion2 = Modifier.b8;
        float f3 = 32;
        Modifier modifierK = PaddingKt.k(SizeKt.f(companion2, 0.0f, 1, null), Dp.g(f3), 0.0f, 2, null);
        Alignment.Companion companion3 = Alignment.f25072a;
        MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion3.g(), composer, 48);
        int iA = ComposablesKt.a(composer, 0);
        CompositionLocalMap compositionLocalMapU = composer.u();
        Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
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
        SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 5.0f, false, 2, null), composer, 0);
        String strO = weeklyInsightsViewState.o();
        if (strO == null) {
            composer.a0(1503600797);
        } else {
            composer.a0(1503600798);
            Modifier modifierV = SizeKt.v(companion2, Dp.g(56));
            MeasurePolicy measurePolicyG = BoxKt.g(companion3.o(), false);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierV);
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
            Updater.e(composerA2, measurePolicyG, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion4.f());
            ProfileImageKt.D(BoxScopeInstance.f6642a, context, strO, mutableState, null, composer, 27654, 0);
            composer.y();
        }
        composer.U();
        SpacerKt.a(SizeKt.i(companion2, Dp.g(24)), composer, 6);
        String strB = StringResources_androidKt.b(R.string.MG, composer, 0);
        TextStyle textStyleE = TextStyle.e(ComposeTypographyKt.g(composer, 0).e(), 0L, TextUnitKt.i(56), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(68), null, null, null, 0, 0, null, 16646141, null);
        TextAlign.Companion companion5 = TextAlign.f29616b;
        TextKt.c(strB, null, 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion5.a()), 0L, 0, false, 0, 0, null, textStyleE, composer, 0, 0, 65022);
        SpacerKt.a(SizeKt.i(companion2, Dp.g(16)), composer, 6);
        TextKt.c(str, null, 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion5.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65022);
        SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composer, 6);
        String strD = weeklyInsightsViewState.D();
        if (strD == null) {
            composer.a0(1505030269);
            composer.U();
            companion = companion2;
            composer2 = composer;
        } else {
            composer.a0(1505030270);
            companion = companion2;
            TextKt.c(strD, null, ComposeColorsKt.j(composer, 0).b(), 0L, null, null, null, 0L, null, TextAlign.h(companion5.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65018);
            composer2 = composer;
            composer2.U();
        }
        SpacerKt.a(ColumnScope.b(columnScopeInstance, companion, 2.0f, false, 2, null), composer2, 0);
        composer2.y();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(WeeklyInsightsViewState weeklyInsightsViewState, Function1 function1, int i3, Composer composer, int i4) {
        d(weeklyInsightsViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
