package cz.mobilesoft.coreblock.scene.onboarding.statistics;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
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
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class OnboardingCrucialWeekScreenKt {
    public static final void h(final float f3, final Function0 onContinueClicked, Composer composer, final int i3) {
        int i4;
        final float f4;
        Intrinsics.checkNotNullParameter(onContinueClicked, "onContinueClicked");
        Composer composerK = composer.k(-205424331);
        if ((i3 & 6) == 0) {
            i4 = (composerK.c(f3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onContinueClicked) ? 32 : 16;
        }
        int i5 = i4;
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-205424331, i5, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.OnboardingCrucialWeekScreen (OnboardingCrucialWeekScreen.kt:51)");
            }
            final Density density = (Density) composerK.q(CompositionLocalsKt.f());
            long jB = ComposeColorsKt.j(composerK, 0).b();
            long jA = ComposeColorsKt.j(composerK, 0).A();
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = PrimitiveSnapshotStateKt.a(0.0f);
                composerK.w(objG);
            }
            final MutableFloatState mutableFloatState = (MutableFloatState) objG;
            final long jI = TextUnitKt.i(143);
            float fJ0 = density.J0(jI);
            TweenSpec tweenSpecN = AnimationSpecKt.n(1000, 0, EasingKt.f(), 2, null);
            TweenSpec tweenSpecN2 = AnimationSpecKt.n(1000, 0, EasingKt.e(), 2, null);
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = PrimitiveSnapshotStateKt.a(0.0f);
                composerK.w(objG2);
            }
            MutableFloatState mutableFloatState2 = (MutableFloatState) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(Color.n(jB), null, 2, null);
                composerK.w(objG3);
            }
            MutableState mutableState = (MutableState) objG3;
            final State stateD = AnimateAsStateKt.d(t(mutableFloatState2), tweenSpecN, 0.0f, null, null, composerK, 0, 28);
            final State stateA = SingleValueAnimationKt.a(v(mutableState), tweenSpecN2, null, null, composerK, 0, 12);
            Unit unit = Unit.f139807a;
            boolean zC = composerK.c(fJ0) | composerK.f(jA);
            Object objG4 = composerK.G();
            if (zC || objG4 == companion.a()) {
                f4 = fJ0;
                OnboardingCrucialWeekScreenKt$OnboardingCrucialWeekScreen$1$1 onboardingCrucialWeekScreenKt$OnboardingCrucialWeekScreen$1$1 = new OnboardingCrucialWeekScreenKt$OnboardingCrucialWeekScreen$1$1(f4, jA, mutableFloatState2, mutableState, null);
                composerK.w(onboardingCrucialWeekScreenKt$OnboardingCrucialWeekScreen$1$1);
                objG4 = onboardingCrucialWeekScreenKt$OnboardingCrucialWeekScreen$1$1;
            } else {
                f4 = fJ0;
            }
            EffectsKt.g(unit, (Function2) objG4, composerK, 6);
            Object objG5 = composerK.G();
            if (objG5 == companion.a()) {
                objG5 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.g0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OnboardingCrucialWeekScreenKt.l();
                    }
                };
                composerK.w(objG5);
            }
            BackHandlerKt.a(false, (Function0) objG5, composerK, 48, 1);
            ComposeBackgroundKt.w(null, Float.valueOf(f3), null, ComposableLambdaKt.e(1024838138, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.h0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OnboardingCrucialWeekScreenKt.m(f4, mutableFloatState, density, jI, stateD, stateA, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), ComposableLambdaKt.e(1288535163, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.i0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OnboardingCrucialWeekScreenKt.p(onContinueClicked, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, ((i5 << 3) & 112) | 27648, 5);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.j0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingCrucialWeekScreenKt.r(f3, onContinueClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float i(MutableFloatState mutableFloatState) {
        return mutableFloatState.c();
    }

    private static final float j(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final long k(State state) {
        return ((Color) state.getValue()).B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(final float f3, MutableFloatState mutableFloatState, Density density, long j3, final State state, State state2, BoxScope GradientOnboardingBox, Composer composer, int i3) {
        final MutableFloatState mutableFloatState2;
        Intrinsics.checkNotNullParameter(GradientOnboardingBox, "$this$GradientOnboardingBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1024838138, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.OnboardingCrucialWeekScreen.<anonymous> (OnboardingCrucialWeekScreen.kt:105)");
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalE = Arrangement.f6574a.e();
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion.g();
            Modifier.Companion companion2 = Modifier.b8;
            float f4 = 16;
            Modifier modifierM = PaddingKt.m(companion2, 0.0f, Dp.g(f4), 0.0f, 0.0f, 13, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalE, horizontalG, composer, 54);
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
            String strB = StringResources_androidKt.b(R.string.fm, composer, 0);
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(strB, PaddingKt.k(companion2, Dp.g(f4), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).f(), composer, 48, 0, 65020);
            SpacerKt.a(SizeKt.i(companion2, Dp.g(12)), composer, 6);
            int i4 = R.string.dm;
            int i5 = R.string.f95790f1;
            TextKt.c(StringResources_androidKt.c(i4, new Object[]{StringResources_androidKt.b(i5, composer, 0)}, composer, 0), PaddingKt.k(companion2, Dp.g(f4), 0.0f, 2, null), ComposeColorsKt.j(composer, 0).P(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 48, 0, 65016);
            Alignment alignmentB = companion.b();
            float f5 = 56;
            Modifier modifierM2 = PaddingKt.m(SizeKt.h(companion2, 0.0f, 1, null), 0.0f, Dp.g(f5), 0.0f, Dp.g(f4), 5, null);
            boolean zC = composer.c(f3);
            Object objG = composer.G();
            if (zC || objG == Composer.f23746a.a()) {
                mutableFloatState2 = mutableFloatState;
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.k0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OnboardingCrucialWeekScreenKt.n(f3, mutableFloatState2, (LayoutCoordinates) obj);
                    }
                };
                composer.w(objG);
            } else {
                mutableFloatState2 = mutableFloatState;
            }
            Modifier modifierA = OnGloballyPositionedModifierKt.a(modifierM2, (Function1) objG);
            MeasurePolicy measurePolicyG = BoxKt.g(alignmentB, false);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierA);
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
            Updater.e(composerA2, measurePolicyG, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            float fM1 = density.M1(Dp.g(1));
            long jK = k(state2);
            TextStyle textStyleE = TextStyle.e(ComposeTypographyKt.g(composer, 0).e(), 0L, j3, new FontWeight(800), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null);
            boolean Z = composer.Z(state);
            Object objG2 = composer.G();
            if (Z || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.l0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OnboardingCrucialWeekScreenKt.o(mutableFloatState2, state, (ContentDrawScope) obj);
                    }
                };
                composer.w(objG2);
            }
            TextKt.c("32%", DrawModifierKt.d(companion2, (Function1) objG2), jK, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleE, composer, 6, 0, 65528);
            TextKt.c("32%", null, k(state2), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composer, 0).e(), 0L, j3, new FontWeight(800), null, null, null, null, 0L, null, null, null, 0L, null, null, new Stroke(fM1, fM1 * 2, 0, StrokeJoin.f25940b.c(), null, 20, null), 0, 0, 0L, null, null, null, 0, 0, null, 16760825, null), composer, 6, 0, 65530);
            composer.y();
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 1.0f, false, 2, null), composer, 0);
            float f6 = 24;
            TextKt.c(StringResources_androidKt.c(R.string.x2, new Object[]{StringResources_androidKt.b(i5, composer, 0)}, composer, 0), PaddingKt.m(SizeKt.h(companion2, 0.0f, 1, null), Dp.g(f6), 0.0f, Dp.g(f6), Dp.g(f5), 2, null), ComposeColorsKt.j(composer, 0).O(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).d(), composer, 48, 0, 65016);
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
    public static final Unit n(float f3, MutableFloatState mutableFloatState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        s(mutableFloatState, (((int) (it.a() & 4294967295L)) - f3) / 2.0f);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(MutableFloatState mutableFloatState, State state, ContentDrawScope drawWithContent) {
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        float fI = i(mutableFloatState) + j(state);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawWithContent.b() >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawWithContent.b() & 4294967295L));
        int iB = ClipOp.f25711b.b();
        DrawContext drawContextQ1 = drawWithContent.Q1();
        long jB = drawContextQ1.b();
        drawContextQ1.g().t();
        try {
            drawContextQ1.e().c(0.0f, fI, fIntBitsToFloat, fIntBitsToFloat2, iB);
            drawWithContent.i2();
            drawContextQ1.g().k();
            drawContextQ1.h(jB);
            return Unit.f139807a;
        } catch (Throwable th) {
            drawContextQ1.g().k();
            drawContextQ1.h(jB);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(final Function0 function0, BoxScope GradientOnboardingBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientOnboardingBox, "$this$GradientOnboardingBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1288535163, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.OnboardingCrucialWeekScreen.<anonymous> (OnboardingCrucialWeekScreen.kt:189)");
            }
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.l8, composer, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 15, null);
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.m0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OnboardingCrucialWeekScreenKt.q(function0);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.i0(null, big, accent, (Function0) objG, composer, 0, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(float f3, Function0 function0, int i3, Composer composer, int i4) {
        h(f3, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void s(MutableFloatState mutableFloatState, float f3) {
        mutableFloatState.s(f3);
    }

    private static final float t(MutableFloatState mutableFloatState) {
        return mutableFloatState.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(MutableFloatState mutableFloatState, float f3) {
        mutableFloatState.s(f3);
    }

    private static final long v(MutableState mutableState) {
        return ((Color) mutableState.getValue()).B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(MutableState mutableState, long j3) {
        mutableState.setValue(Color.n(j3));
    }
}
