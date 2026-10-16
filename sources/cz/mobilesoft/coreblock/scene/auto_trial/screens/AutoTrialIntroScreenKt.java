package cz.mobilesoft.coreblock.scene.auto_trial.screens;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import cz.mobilesoft.coreblock.scene.auto_trial.components.AutoTrialIntroContentKt;
import cz.mobilesoft.coreblock.scene.auto_trial.components.AutoTrialSuccessContentKt;
import cz.mobilesoft.coreblock.scene.auto_trial.components.card.AutoTrialCardKt;
import cz.mobilesoft.coreblock.scene.auto_trial.components.card.AutoTrialCelebrationKt;
import cz.mobilesoft.coreblock.scene.auto_trial.components.card.AutoTrialSettledCardKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarButtonType;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AutoTrialIntroScreenKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f98982a;

        static {
            int[] iArr = new int[AutoTrialPhase.values().length];
            try {
                iArr[AutoTrialPhase.Intro.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AutoTrialPhase.Celebrating.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AutoTrialPhase.Settled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f98982a = iArr;
        }
    }

    public static final void e(final Function0 onContinue, final Function0 onClose, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(onContinue, "onContinue");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Composer composerK = composer.k(-1702698406);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onContinue) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onClose) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1702698406, i4, -1, "cz.mobilesoft.coreblock.scene.auto_trial.screens.AutoTrialIntroScreen (AutoTrialIntroScreen.kt:41)");
            }
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(AutoTrialPhase.Intro, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            final State stateD = AnimateAsStateKt.d(f(mutableState) == AutoTrialPhase.Intro ? 1.0f : 0.0f, null, 0.0f, "introAlpha", null, composerK, 3072, 22);
            final State stateD2 = AnimateAsStateKt.d(f(mutableState) == AutoTrialPhase.Settled ? 1.0f : 0.0f, null, 0.0f, "settledAlpha", null, composerK, 3072, 22);
            ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, ComposableLambdaKt.e(-2087476468, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.auto_trial.screens.f
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AutoTrialIntroScreenKt.j(mutableState, onContinue, onClose, stateD, stateD2, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 12582912, 127);
            composerK = composerK;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.auto_trial.screens.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AutoTrialIntroScreenKt.m(onContinue, onClose, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final AutoTrialPhase f(MutableState mutableState) {
        return (AutoTrialPhase) mutableState.getValue();
    }

    private static final void g(MutableState mutableState, AutoTrialPhase autoTrialPhase) {
        mutableState.setValue(autoTrialPhase);
    }

    private static final float h(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float i(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(final MutableState mutableState, Function0 function0, Function0 function02, State state, State state2, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2087476468, i3, -1, "cz.mobilesoft.coreblock.scene.auto_trial.screens.AutoTrialIntroScreen.<anonymous> (AutoTrialIntroScreen.kt:54)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierF = SizeKt.f(companion, 0.0f, 1, null);
            Object objG = composer.G();
            Composer.Companion companion2 = Composer.f23746a;
            if (objG == companion2.a()) {
                objG = InteractionSourceKt.a();
                composer.w(objG);
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objG;
            boolean z2 = f(mutableState) == AutoTrialPhase.Intro;
            Object objG2 = composer.G();
            if (objG2 == companion2.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.auto_trial.screens.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AutoTrialIntroScreenKt.k(mutableState);
                    }
                };
                composer.w(objG2);
            }
            Modifier modifierD = ClickableKt.d(modifierF, mutableInteractionSource, null, z2, null, null, (Function0) objG2, 24, null);
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion3.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierD);
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
            Updater.e(composerA, modifierF2, companion4.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierF3 = SizeKt.f(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion3.e(), false);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer, modifierF3);
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
            Updater.e(composerA2, measurePolicyG2, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF4, companion4.f());
            int i4 = WhenMappings.f98982a[f(mutableState).ordinal()];
            if (i4 == 1) {
                composer.a0(-204147129);
                AutoTrialCardKt.d(null, 0.0f, composer, 0, 3);
                composer.U();
            } else if (i4 == 2) {
                composer.a0(-204144912);
                Object objG3 = composer.G();
                if (objG3 == companion2.a()) {
                    objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.auto_trial.screens.i
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AutoTrialIntroScreenKt.l(mutableState);
                        }
                    };
                    composer.w(objG3);
                }
                AutoTrialCelebrationKt.d(null, 0.0f, (Function0) objG3, composer, 384, 3);
                composer.U();
            } else {
                if (i4 != 3) {
                    composer.a0(-204148700);
                    composer.U();
                    throw new NoWhenBranchMatchedException();
                }
                composer.a0(-204139666);
                AutoTrialSettledCardKt.c(null, composer, 0, 1);
                composer.U();
            }
            composer.y();
            if (f(mutableState) != AutoTrialPhase.Settled) {
                composer.a0(1473448372);
                AutoTrialIntroContentKt.b(AlphaKt.a(companion, h(state)), composer, 0, 0);
                composer.U();
            } else {
                composer.a0(1473548719);
                AutoTrialSuccessContentKt.d(AlphaKt.a(companion, i(state2)), function0, composer, 0, 0);
                composer.U();
            }
            ToolbarKt.e(null, function02, null, true, ToolbarButtonType.Close, false, false, null, null, composer, 27648, 485);
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
    public static final Unit k(MutableState mutableState) {
        g(mutableState, AutoTrialPhase.Celebrating);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(MutableState mutableState) {
        g(mutableState, AutoTrialPhase.Settled);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        e(function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
