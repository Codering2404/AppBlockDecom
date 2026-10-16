package cz.mobilesoft.coreblock.scene.intro.strictmode;

import android.content.res.Configuration;
import android.os.Build;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.SurfaceKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.BlurKt;
import androidx.compose.ui.draw.BlurredEdgeTreatment;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
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
public final class StrictModeSmartLockScreenKt {
    public static final void f(Function0 onContinueClicked, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Composer composer2;
        Modifier.Companion companion;
        final Animatable animatable;
        Animatable animatable2;
        int i5;
        MutableState mutableState;
        Easing easing;
        int i6;
        Intrinsics.checkNotNullParameter(onContinueClicked, "onContinueClicked");
        Composer composerK = composer.k(563707193);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.I(onContinueClicked) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(563707193, i4, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeSmartLockScreen (StrictModeSmartLockScreen.kt:62)");
            }
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierG = ScrollKt.g(SizeKt.f(companion2, 0.0f, 1, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null);
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.b(), companion3.g(), composerK, 54);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierG);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
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
            Updater.e(composerA, measurePolicyA, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            SpacerKt.a(SizeKt.i(companion2, Dp.g(64)), composerK, 6);
            float fM1 = ((Density) composerK.q(CompositionLocalsKt.f())).M1(Dp.g(((Configuration) composerK.q(AndroidCompositionLocals_androidKt.f())).screenHeightDp));
            Object objG = composerK.G();
            Composer.Companion companion5 = Composer.f23746a;
            if (objG == companion5.a()) {
                objG = AnimatableKt.b(fM1 / 4, 0.0f, 2, null);
                composerK.w(objG);
            }
            Animatable animatable3 = (Animatable) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion5.a()) {
                objG2 = AnimatableKt.b(0.0f, 0.0f, 2, null);
                composerK.w(objG2);
            }
            Animatable animatable4 = (Animatable) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion5.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG3);
            }
            MutableState mutableState2 = (MutableState) objG3;
            Unit unit = Unit.f139807a;
            boolean zI = composerK.I(animatable3) | composerK.I(animatable4);
            Object objG4 = composerK.G();
            if (zI || objG4 == companion5.a()) {
                objG4 = new StrictModeSmartLockScreenKt$StrictModeSmartLockScreen$1$1$1(animatable3, animatable4, mutableState2, null);
                composerK.w(objG4);
            }
            EffectsKt.g(unit, (Function2) objG4, composerK, 6);
            MeasurePolicy measurePolicyG = BoxKt.g(companion3.e(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, companion2);
            Function0 function0A2 = companion4.a();
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
            Updater.e(composerA2, measurePolicyG, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion4.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            if (Build.VERSION.SDK_INT >= 31) {
                composerK.a0(-595030185);
                float f3 = 280;
                Modifier modifierB = BlurKt.b(SizeKt.v(companion2, Dp.g(f3)), Dp.g(90), BlurredEdgeTreatment.f25380b.b());
                MeasurePolicy measurePolicyG2 = BoxKt.g(companion3.o(), false);
                int iA3 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU3 = composerK.u();
                Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierB);
                Function0 function0A3 = companion4.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A3);
                } else {
                    composerK.v();
                }
                Composer composerA3 = Updater.a(composerK);
                Updater.e(composerA3, measurePolicyG2, companion4.e());
                Updater.e(composerA3, compositionLocalMapU3, companion4.g());
                Function2 function2B3 = companion4.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF3, companion4.f());
                animatable = animatable3;
                animatable2 = animatable4;
                companion = companion2;
                mutableState = mutableState2;
                i5 = 0;
                easing = null;
                i6 = 6;
                SurfaceKt.a(boxScopeInstance.f(SizeKt.v(companion2, Dp.g(f3)), companion3.e()), RoundedCornerShapeKt.g(), Color.r(ComposeColorsKt.j(composerK, 0).a0(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), 0L, null, 0.0f, ComposableSingletons$StrictModeSmartLockScreenKt.f104986a.d(), composerK, 1572864, 56);
                composerK = composerK;
                composerK.y();
            } else {
                companion = companion2;
                animatable = animatable3;
                animatable2 = animatable4;
                i5 = 0;
                mutableState = mutableState2;
                easing = null;
                i6 = 6;
                composerK.a0(-598810387);
            }
            composerK.U();
            final Animatable animatable5 = animatable2;
            CrossfadeKt.b(Boolean.valueOf(g(mutableState)), null, AnimationSpecKt.n(500, i5, easing, i6, easing), null, ComposableLambdaKt.e(684639028, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.z2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StrictModeSmartLockScreenKt.i(animatable, animatable5, ((Boolean) obj).booleanValue(), (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 24960, 10);
            composerK.y();
            float f4 = 32;
            Modifier.Companion companion6 = companion;
            SpacerKt.a(SizeKt.i(companion6, Dp.g(f4)), composerK, i6);
            String strB = StringResources_androidKt.b(R.string.PD, composerK, i5);
            TextStyle textStyleG = ComposeTypographyKt.g(composerK, i5).g();
            long jO = ComposeColorsKt.j(composerK, i5).O();
            TextAlign.Companion companion7 = TextAlign.f29616b;
            composer2 = composerK;
            TextKt.c(strB, null, jO, 0L, null, null, null, 0L, null, TextAlign.h(companion7.a()), 0L, 0, false, 0, 0, null, textStyleG, composer2, 0, 0, 65018);
            SpacerKt.a(SizeKt.i(companion6, Dp.g(8)), composer2, i6);
            TextKt.c(StringResources_androidKt.b(R.string.qz, composer2, i5), PaddingKt.k(companion6, Dp.g(f4), 0.0f, 2, null), ComposeColorsKt.j(composer2, i5).L(), 0L, null, null, null, 0L, null, TextAlign.h(companion7.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, i5).e(), composer2, 48, 0, 65016);
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion6, 1.0f, false, 2, null), composer2, i5);
            boolean zG = g(mutableState);
            EnterTransition enterTransitionO = EnterExitTransitionKt.o(AnimationSpecKt.n(500, i5, null, i6, null), 0.0f, 2, null);
            ExitTransition exitTransitionQ = EnterExitTransitionKt.q(AnimationSpecKt.n(500, i5, null, i6, null), 0.0f, 2, null);
            function0 = onContinueClicked;
            AnimatedVisibilityKt.g(columnScopeInstance, zG, PaddingKt.k(companion6, Dp.g(i5), 0.0f, 2, null), enterTransitionO, exitTransitionQ, null, ComposableLambdaKt.e(-1562984057, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.a3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StrictModeSmartLockScreenKt.k(function0, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), composer2, 1600902, 16);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onContinueClicked;
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.b3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeSmartLockScreenKt.m(function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean g(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(final Animatable animatable, Animatable animatable2, boolean z2, Composer composer, int i3) {
        int i4;
        if ((i3 & 6) == 0) {
            i4 = (composer.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(684639028, i4, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeSmartLockScreen.<anonymous>.<anonymous>.<anonymous> (StrictModeSmartLockScreen.kt:116)");
            }
            Painter painterC = PainterResources_androidKt.c(z2 ? R.drawable.l8 : R.drawable.m8, composer, 0);
            Modifier.Companion companion = Modifier.b8;
            boolean zI = composer.I(animatable);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.d3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictModeSmartLockScreenKt.j(animatable, (Density) obj);
                    }
                };
                composer.w(objG);
            }
            ImageKt.a(painterC, null, AlphaKt.a(OffsetKt.b(companion, (Function1) objG), ((Number) animatable2.n()).floatValue()), null, null, 0.0f, null, composer, 48, 120);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset j(Animatable animatable, Density offset) {
        Intrinsics.checkNotNullParameter(offset, "$this$offset");
        return IntOffset.c(IntOffset.f((((long) ((int) ((Number) animatable.n()).floatValue())) & 4294967295L) | (((long) 0) << 32)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(final Function0 function0, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(-1562984057, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeSmartLockScreen.<anonymous>.<anonymous> (StrictModeSmartLockScreen.kt:155)");
        }
        String strB = StringResources_androidKt.b(R.string.l8, composer, 0);
        Modifier modifierK = PaddingKt.k(Modifier.b8, Dp.g(0), 0.0f, 2, null);
        boolean Z = composer.Z(function0);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.c3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StrictModeSmartLockScreenKt.l(function0);
                }
            };
            composer.w(objG);
        }
        ComposeButtonsKt.J(modifierK, strB, false, false, null, (Function0) objG, composer, 6, 28);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Function0 function0, int i3, Composer composer, int i4) {
        f(function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
