package cz.mobilesoft.coreblock.scene.intro.question;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.IconKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class ComposableSingletons$Explanation2ScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$Explanation2ScreenKt f104670a = new ComposableSingletons$Explanation2ScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f104671b = ComposableLambdaKt.c(-556328234, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.question.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$Explanation2ScreenKt.u((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function3 f104672c = ComposableLambdaKt.c(266356698, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.question.d
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$Explanation2ScreenKt.k((ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f104673d = ComposableLambdaKt.c(1290550578, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.question.e
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$Explanation2ScreenKt.j((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1290550578, i3, -1, "cz.mobilesoft.coreblock.scene.intro.question.ComposableSingletons$Explanation2ScreenKt.lambda$1290550578.<anonymous> (Explanation2Screen.kt:112)");
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(ColumnScope ExplanationScreen, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(ExplanationScreen, "$this$ExplanationScreen");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(ExplanationScreen) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(266356698, i4, -1, "cz.mobilesoft.coreblock.scene.intro.question.ComposableSingletons$Explanation2ScreenKt.lambda$266356698.<anonymous> (Explanation2Screen.kt:48)");
            }
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Dp.d(Dp.g(140)), null, 2, null);
                composer.w(objG);
            }
            MutableState mutableState = (MutableState) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Dp.d(Dp.g(140)), null, 2, null);
                composer.w(objG2);
            }
            MutableState mutableState2 = (MutableState) objG2;
            Object objG3 = composer.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(Dp.d(Dp.g(140)), null, 2, null);
                composer.w(objG3);
            }
            MutableState mutableState3 = (MutableState) objG3;
            TweenSpec tweenSpecN = AnimationSpecKt.n(1000, 0, EasingKt.d(), 2, null);
            State stateC = AnimateAsStateKt.c(l(mutableState), tweenSpecN, null, null, composer, 0, 12);
            State stateC2 = AnimateAsStateKt.c(p(mutableState2), tweenSpecN, null, null, composer, 0, 12);
            State stateC3 = AnimateAsStateKt.c(r(mutableState3), tweenSpecN, null, null, composer, 0, 12);
            Unit unit = Unit.f139807a;
            Object objG4 = composer.G();
            if (objG4 == companion.a()) {
                objG4 = new ComposableSingletons$Explanation2ScreenKt$lambda$266356698$1$1$1(mutableState, mutableState2, mutableState3, null);
                composer.w(objG4);
            }
            EffectsKt.g(unit, (Function2) objG4, composer, 6);
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierB = ColumnScope.b(ExplanationScreen, companion2, 1.0f, false, 2, null);
            Alignment.Companion companion3 = Alignment.f25072a;
            Modifier modifierC = ExplanationScreen.c(modifierB, companion3.g());
            MeasurePolicy measurePolicyG = BoxKt.g(companion3.e(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierC);
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
            Updater.e(composerA, measurePolicyG, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            ImageVector.Companion companion5 = ImageVector.f26323k;
            ImageKt.b(VectorResources_androidKt.b(companion5, R.drawable.D0, composer, 6), null, null, null, ContentScale.f27054a.g(), 0.0f, null, composer, 24624, 108);
            Explanation2ScreenKt.c(t(stateC), Color.r(ComposeColorsKt.j(composer, 0).b(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), composer, 0);
            Explanation2ScreenKt.c(m(stateC2), Color.r(ComposeColorsKt.j(composer, 0).b(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), composer, 0);
            Explanation2ScreenKt.c(n(stateC3), ComposeColorsKt.j(composer, 0).b(), composer, 0);
            IconKt.b(VectorResources_androidKt.b(companion5, R.drawable.A0, composer, 6), null, SizeKt.v(companion2, Dp.g(74)), Color.f25715b.l(), composer, 3504, 0);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    private static final float l(MutableState mutableState) {
        return ((Dp) mutableState.getValue()).l();
    }

    private static final float m(State state) {
        return ((Dp) state.getValue()).l();
    }

    private static final float n(State state) {
        return ((Dp) state.getValue()).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(MutableState mutableState, float f3) {
        mutableState.setValue(Dp.d(f3));
    }

    private static final float p(MutableState mutableState) {
        return ((Dp) mutableState.getValue()).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(MutableState mutableState, float f3) {
        mutableState.setValue(Dp.d(f3));
    }

    private static final float r(MutableState mutableState) {
        return ((Dp) mutableState.getValue()).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(MutableState mutableState, float f3) {
        mutableState.setValue(Dp.d(f3));
    }

    private static final float t(State state) {
        return ((Dp) state.getValue()).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-556328234, i3, -1, "cz.mobilesoft.coreblock.scene.intro.question.ComposableSingletons$Explanation2ScreenKt.lambda$-556328234.<anonymous> (Explanation2Screen.kt:37)");
            }
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.question.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$Explanation2ScreenKt.v();
                    }
                };
                composer.w(objG);
            }
            Explanation2ScreenKt.e((Function0) objG, composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v() {
        return Unit.f139807a;
    }

    public final Function2 h() {
        return f104673d;
    }

    public final Function3 i() {
        return f104672c;
    }
}
