package cz.mobilesoft.coreblock.scene.intro.question;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingFunctionsKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.intro.HelpItemWithExplanation;
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
public final class Explanation1ScreenKt {
    private static final void d(final HelpItemWithExplanation helpItemWithExplanation, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-536982600);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(helpItemWithExplanation) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-536982600, i4, -1, "cz.mobilesoft.coreblock.scene.intro.question.AnimatedIcon (Explanation1Screen.kt:63)");
            }
            float f3 = 52;
            State stateB = InfiniteTransitionKt.b(InfiniteTransitionKt.c(null, composerK, 0, 1), Dp.d(Dp.g(46)), Dp.d(Dp.g(f3)), VectorConvertersKt.e(Dp.f29970b), AnimationSpecKt.e(AnimationSpecKt.n(1000, 0, EasingFunctionsKt.m(), 2, null), RepeatMode.f4053b, 0L, 4, null), null, composerK, InfiniteTransition.f3967f | 432 | (InfiniteRepeatableSpec.f3963d << 12), 16);
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierV = SizeKt.v(PaddingKt.m(companion, Dp.g(252), Dp.g(76), 0.0f, 0.0f, 12, null), Dp.g(f3));
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierV);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            ImageKt.b(VectorResources_androidKt.b(ImageVector.f26323k, helpItemWithExplanation.a(), composerK, 6), null, SizeKt.v(companion, e(stateB)), null, null, 0.0f, null, composerK, 48, 120);
            composerK = composerK;
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.question.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Explanation1ScreenKt.f(helpItemWithExplanation, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float e(State state) {
        return ((Dp) state.getValue()).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(HelpItemWithExplanation helpItemWithExplanation, int i3, Composer composer, int i4) {
        d(helpItemWithExplanation, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void g(final HelpItemWithExplanation item, Function0 onContinueClicked, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(onContinueClicked, "onContinueClicked");
        Composer composerK = composer.k(1148098660);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(item) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onContinueClicked) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1148098660, i4, -1, "cz.mobilesoft.coreblock.scene.intro.question.Explanation1Screen (Explanation1Screen.kt:38)");
            }
            function0 = onContinueClicked;
            ExplanationScreenKt.e(StringResources_androidKt.b(R.string.Gm, composerK, 0), StringResources_androidKt.b(item.g(), composerK, 0), null, function0, null, ComposableLambdaKt.e(605086377, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.question.n
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Explanation1ScreenKt.h(item, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, ((i4 << 6) & 7168) | 196608, 20);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onContinueClicked;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.question.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Explanation1ScreenKt.i(item, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(HelpItemWithExplanation helpItemWithExplanation, ColumnScope ExplanationScreen, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(ExplanationScreen, "$this$ExplanationScreen");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(ExplanationScreen) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(605086377, i4, -1, "cz.mobilesoft.coreblock.scene.intro.question.Explanation1Screen.<anonymous> (Explanation1Screen.kt:44)");
            }
            Modifier.Companion companion = Modifier.b8;
            SpacerKt.a(ColumnScope.b(ExplanationScreen, companion, 1.0f, false, 2, null), composer, 0);
            Alignment.Companion companion2 = Alignment.f25072a;
            Modifier modifierM = PaddingKt.m(ExplanationScreen.c(companion, companion2.g()), 0.0f, Dp.g(16), 0.0f, Dp.g(56), 5, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
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
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            ImageKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.P7, composer, 6), null, null, null, ContentScale.f27054a.g(), 0.0f, null, composer, 24624, 108);
            d(helpItemWithExplanation, composer, 0);
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
    public static final Unit i(HelpItemWithExplanation helpItemWithExplanation, Function0 function0, int i3, Composer composer, int i4) {
        g(helpItemWithExplanation, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
