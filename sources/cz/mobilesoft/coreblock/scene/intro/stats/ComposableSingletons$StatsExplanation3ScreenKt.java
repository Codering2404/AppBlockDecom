package cz.mobilesoft.coreblock.scene.intro.stats;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
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
public final class ComposableSingletons$StatsExplanation3ScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$StatsExplanation3ScreenKt f104910a = new ComposableSingletons$StatsExplanation3ScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f104911b = ComposableLambdaKt.c(1889606713, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.stats.g
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StatsExplanation3ScreenKt.i((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function3 f104912c = ComposableLambdaKt.c(653297173, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.stats.h
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$StatsExplanation3ScreenKt.k((ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1889606713, i3, -1, "cz.mobilesoft.coreblock.scene.intro.stats.ComposableSingletons$StatsExplanation3ScreenKt.lambda$1889606713.<anonymous> (StatsExplanation3Screen.kt:45)");
            }
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.stats.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$StatsExplanation3ScreenKt.j();
                    }
                };
                composer.w(objG);
            }
            StatsExplanation3ScreenKt.b((Function0) objG, composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(ColumnScope ExplanationScreen, Composer composer, int i3) {
        int i4;
        final float f3;
        Float fValueOf = Float.valueOf(0.0f);
        Intrinsics.checkNotNullParameter(ExplanationScreen, "$this$ExplanationScreen");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(ExplanationScreen) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(653297173, i4, -1, "cz.mobilesoft.coreblock.scene.intro.stats.ComposableSingletons$StatsExplanation3ScreenKt.lambda$653297173.<anonymous> (StatsExplanation3Screen.kt:63)");
            }
            Density density = (Density) composer.q(CompositionLocalsKt.f());
            long jB = ComposeColorsKt.j(composer, 0).b();
            long jA = ComposeColorsKt.j(composer, 0).A();
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(fValueOf, null, 2, null);
                composer.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            long jI = TextUnitKt.i(143);
            float fJ0 = density.J0(jI);
            TweenSpec tweenSpecN = AnimationSpecKt.n(1000, 0, EasingKt.f(), 2, null);
            TweenSpec tweenSpecN2 = AnimationSpecKt.n(1000, 0, EasingKt.e(), 2, null);
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(fValueOf, null, 2, null);
                composer.w(objG2);
            }
            MutableState mutableState2 = (MutableState) objG2;
            Object objG3 = composer.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(Color.n(jB), null, 2, null);
                composer.w(objG3);
            }
            MutableState mutableState3 = (MutableState) objG3;
            final State stateD = AnimateAsStateKt.d(r(mutableState2), tweenSpecN, 0.0f, null, null, composer, 0, 28);
            State stateA = SingleValueAnimationKt.a(t(mutableState3), tweenSpecN2, null, null, composer, 0, 12);
            Unit unit = Unit.f139807a;
            boolean zC = composer.c(fJ0) | composer.f(jA);
            Object objG4 = composer.G();
            if (zC || objG4 == companion.a()) {
                f3 = fJ0;
                Object composableSingletons$StatsExplanation3ScreenKt$lambda$653297173$1$1$1 = new ComposableSingletons$StatsExplanation3ScreenKt$lambda$653297173$1$1$1(f3, jA, mutableState2, mutableState3, null);
                composer.w(composableSingletons$StatsExplanation3ScreenKt$lambda$653297173$1$1$1);
                objG4 = composableSingletons$StatsExplanation3ScreenKt$lambda$653297173$1$1$1;
            } else {
                f3 = fJ0;
            }
            EffectsKt.g(unit, (Function2) objG4, composer, 6);
            Alignment alignmentB = Alignment.f25072a.b();
            Modifier.Companion companion2 = Modifier.b8;
            float f4 = 56;
            Modifier modifierM = PaddingKt.m(SizeKt.h(companion2, 0.0f, 1, null), 0.0f, Dp.g(f4), 0.0f, Dp.g(16), 5, null);
            boolean zC2 = composer.c(f3);
            Object objG5 = composer.G();
            if (zC2 || objG5 == companion.a()) {
                objG5 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.stats.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$StatsExplanation3ScreenKt.o(f3, mutableState, (LayoutCoordinates) obj);
                    }
                };
                composer.w(objG5);
            }
            Modifier modifierA = OnGloballyPositionedModifierKt.a(modifierM, (Function1) objG5);
            MeasurePolicy measurePolicyG = BoxKt.g(alignmentB, false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierA);
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
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            float fM1 = density.M1(Dp.g(1));
            long jN = n(stateA);
            TextStyle textStyleE = TextStyle.e(ComposeTypographyKt.g(composer, 0).e(), 0L, jI, new FontWeight(800), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null);
            boolean Z = composer.Z(stateD);
            Object objG6 = composer.G();
            if (Z || objG6 == companion.a()) {
                objG6 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.stats.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposableSingletons$StatsExplanation3ScreenKt.p(mutableState, stateD, (ContentDrawScope) obj);
                    }
                };
                composer.w(objG6);
            }
            TextKt.c("32%", DrawModifierKt.d(companion2, (Function1) objG6), jN, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleE, composer, 6, 0, 65528);
            TextKt.c("32%", null, n(stateA), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composer, 0).e(), 0L, jI, new FontWeight(800), null, null, null, null, 0L, null, null, null, 0L, null, null, new Stroke(fM1, fM1 * 2, 0, StrokeJoin.f25940b.c(), null, 20, null), 0, 0, 0L, null, null, null, 0, 0, null, 16760825, null), composer, 6, 0, 65530);
            composer.y();
            SpacerKt.a(ColumnScope.b(ExplanationScreen, companion2, 1.0f, false, 2, null), composer, 0);
            float f5 = 24;
            TextKt.c(StringResources_androidKt.c(R.string.x2, new Object[]{StringResources_androidKt.b(R.string.f95790f1, composer, 0)}, composer, 0), PaddingKt.m(SizeKt.h(companion2, 0.0f, 1, null), Dp.g(f5), 0.0f, Dp.g(f5), Dp.g(f4), 2, null), ComposeColorsKt.j(composer, 0).O(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).d(), composer, 48, 0, 65016);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    private static final float l(MutableState mutableState) {
        return ((Number) mutableState.getValue()).floatValue();
    }

    private static final float m(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final long n(State state) {
        return ((Color) state.getValue()).B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(float f3, MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        q(mutableState, (((int) (it.a() & 4294967295L)) - f3) / 2.0f);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(MutableState mutableState, State state, ContentDrawScope drawWithContent) {
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        float fL = l(mutableState) + m(state);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawWithContent.b() >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawWithContent.b() & 4294967295L));
        int iB = ClipOp.f25711b.b();
        DrawContext drawContextQ1 = drawWithContent.Q1();
        long jB = drawContextQ1.b();
        drawContextQ1.g().t();
        try {
            drawContextQ1.e().c(0.0f, fL, fIntBitsToFloat, fIntBitsToFloat2, iB);
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

    private static final void q(MutableState mutableState, float f3) {
        mutableState.setValue(Float.valueOf(f3));
    }

    private static final float r(MutableState mutableState) {
        return ((Number) mutableState.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(MutableState mutableState, float f3) {
        mutableState.setValue(Float.valueOf(f3));
    }

    private static final long t(MutableState mutableState) {
        return ((Color) mutableState.getValue()).B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(MutableState mutableState, long j3) {
        mutableState.setValue(Color.n(j3));
    }

    public final Function3 h() {
        return f104912c;
    }
}
