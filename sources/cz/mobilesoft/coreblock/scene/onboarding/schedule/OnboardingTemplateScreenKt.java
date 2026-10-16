package cz.mobilesoft.coreblock.scene.onboarding.schedule;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewStateV2;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionsScreenKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.profile.ProfileHelper;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsV2Kt;
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
public final class OnboardingTemplateScreenKt {
    public static final void h(final float f3, final OnboardingViewStateV2.OnboardingVariant onboardingVariant, final Function0 onPartialSkipClicked, final Function1 onConditionSelected, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(onboardingVariant, "onboardingVariant");
        Intrinsics.checkNotNullParameter(onPartialSkipClicked, "onPartialSkipClicked");
        Intrinsics.checkNotNullParameter(onConditionSelected, "onConditionSelected");
        Composer composerK = composer.k(501536564);
        if ((i3 & 6) == 0) {
            i4 = (composerK.c(f3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.e(onboardingVariant.ordinal()) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onPartialSkipClicked) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onConditionSelected) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(501536564, i4, -1, "cz.mobilesoft.coreblock.scene.onboarding.schedule.OnboardingTemplateScreen (OnboardingTemplateScreen.kt:54)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.schedule.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OnboardingTemplateScreenKt.i();
                    }
                };
                composerK.w(objG);
            }
            BackHandlerKt.a(false, (Function0) objG, composerK, 48, 1);
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG2);
            }
            final MutableState mutableState = (MutableState) objG2;
            Unit unit = Unit.f139807a;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = new OnboardingTemplateScreenKt$OnboardingTemplateScreen$2$1(mutableState, null);
                composerK.w(objG3);
            }
            EffectsKt.g(unit, (Function2) objG3, composerK, 6);
            ComposeBackgroundKt.w(null, Float.valueOf(f3), null, ComposableLambdaKt.e(-207219847, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.onboarding.schedule.m
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OnboardingTemplateScreenKt.l(onConditionSelected, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), ComposableLambdaKt.e(-1247511686, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.onboarding.schedule.n
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OnboardingTemplateScreenKt.n(onboardingVariant, mutableState, onPartialSkipClicked, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, ((i4 << 3) & 112) | 27648, 5);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.schedule.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingTemplateScreenKt.q(f3, onboardingVariant, onPartialSkipClicked, onConditionSelected, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i() {
        return Unit.f139807a;
    }

    private static final boolean j(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(final Function1 function1, BoxScope GradientOnboardingBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientOnboardingBox, "$this$GradientOnboardingBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-207219847, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.schedule.OnboardingTemplateScreen.<anonymous> (OnboardingTemplateScreen.kt:68)");
            }
            Alignment.Horizontal horizontalG = Alignment.f25072a.g();
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierM = PaddingKt.m(ScrollKt.g(companion, ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null), 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), horizontalG, composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierM);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            TextKt.c(StringResources_androidKt.b(R.string.Al, composer, 0), PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).f(), composer, 48, 0, 65020);
            SpacerKt.a(SizeKt.i(companion, Dp.g(24)), composer, 6);
            composer.a0(-1600865793);
            for (ProfileType profileType : ProfileHelper.f129250a.y()) {
                Modifier.Companion companion3 = Modifier.b8;
                Modifier modifierK = PaddingKt.k(companion3, Dp.g(f3), 0.0f, 2, null);
                boolean Z = composer.Z(function1);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.schedule.q
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OnboardingTemplateScreenKt.m(function1, (ProfileType) obj);
                        }
                    };
                    composer.w(objG);
                }
                ConditionsScreenKt.m(modifierK, profileType, true, (Function1) objG, composer, 390, 0);
                SpacerKt.a(SizeKt.i(companion3, Dp.g(f3)), composer, 6);
            }
            composer.U();
            TextKt.c(StringResources_androidKt.b(R.string.Bm, composer, 0), PaddingKt.m(PaddingKt.k(Modifier.b8, Dp.g(f3), 0.0f, 2, null), 0.0f, Dp.g(8), 0.0f, 0.0f, 13, null), ComposeColorsKt.j(composer, 0).P(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 48, 0, 65016);
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
    public static final Unit m(Function1 function1, ProfileType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(OnboardingViewStateV2.OnboardingVariant onboardingVariant, MutableState mutableState, final Function0 function0, BoxScope GradientOnboardingBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientOnboardingBox, "$this$GradientOnboardingBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1247511686, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.schedule.OnboardingTemplateScreen.<anonymous> (OnboardingTemplateScreen.kt:107)");
            }
            if (onboardingVariant != OnboardingViewStateV2.OnboardingVariant.NoSkip) {
                composer.a0(-268508962);
                AnimatedVisibilityKt.j(j(mutableState), null, EnterExitTransitionKt.o(null, 0.0f, 3, null), null, null, ComposableLambdaKt.e(-1523689497, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.onboarding.schedule.p
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return OnboardingTemplateScreenKt.o(function0, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, 196992, 26);
            } else {
                composer.a0(-273146872);
            }
            composer.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(final Function0 function0, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(-1523689497, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.schedule.OnboardingTemplateScreen.<anonymous>.<anonymous> (OnboardingTemplateScreen.kt:112)");
        }
        Alignment.Horizontal horizontalG = Alignment.f25072a.g();
        Modifier.Companion companion = Modifier.b8;
        Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
        MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), horizontalG, composer, 48);
        int iA = ComposablesKt.a(composer, 0);
        CompositionLocalMap compositionLocalMapU = composer.u();
        Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
        ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
        Function0 function0A = companion2.a();
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
        Updater.e(composerA, measurePolicyA, companion2.e());
        Updater.e(composerA, compositionLocalMapU, companion2.g());
        Function2 function2B = companion2.b();
        if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
            composerA.w(Integer.valueOf(iA));
            composerA.p(Integer.valueOf(iA), function2B);
        }
        Updater.e(composerA, modifierF, companion2.f());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
        String strB = StringResources_androidKt.b(R.string.ym, composer, 0);
        Modifier modifierK = PaddingKt.k(companion, Dp.g(16), 0.0f, 2, null);
        boolean Z = composer.Z(function0);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.schedule.k
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OnboardingTemplateScreenKt.p(function0);
                }
            };
            composer.w(objG);
        }
        ComposeButtonsV2Kt.d(modifierK, strB, (Function0) objG, composer, 6, 0);
        composer.y();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(float f3, OnboardingViewStateV2.OnboardingVariant onboardingVariant, Function0 function0, Function1 function1, int i3, Composer composer, int i4) {
        h(f3, onboardingVariant, function0, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
