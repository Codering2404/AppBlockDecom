package cz.mobilesoft.coreblock.scene.onboarding;

import android.content.res.Configuration;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.ImageKt;
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
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewStateV2;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsV2Kt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class OnboardingDataInfoScreenKt {
    public static final void h(float f3, final Function0 onContinueClicked, final Function0 onDataPolicyClicked, final Function0 onPartialSkipClicked, final Function0 onFullSkipClicked, final OnboardingViewStateV2.OnboardingVariant onboardingVariant, Composer composer, final int i3) {
        final float f4;
        int i4;
        Intrinsics.checkNotNullParameter(onContinueClicked, "onContinueClicked");
        Intrinsics.checkNotNullParameter(onDataPolicyClicked, "onDataPolicyClicked");
        Intrinsics.checkNotNullParameter(onPartialSkipClicked, "onPartialSkipClicked");
        Intrinsics.checkNotNullParameter(onFullSkipClicked, "onFullSkipClicked");
        Intrinsics.checkNotNullParameter(onboardingVariant, "onboardingVariant");
        Composer composerK = composer.k(-178705412);
        if ((i3 & 6) == 0) {
            f4 = f3;
            i4 = (composerK.c(f4) ? 4 : 2) | i3;
        } else {
            f4 = f3;
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onContinueClicked) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onDataPolicyClicked) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onPartialSkipClicked) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(onFullSkipClicked) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.e(onboardingVariant.ordinal()) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if (composerK.r((74899 & i4) != 74898, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-178705412, i4, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingDataInfoScreen (OnboardingDataInfoScreen.kt:58)");
            }
            final boolean z2 = ((Configuration) composerK.q(AndroidCompositionLocals_androidKt.f())).orientation == 2;
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.t1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OnboardingDataInfoScreenKt.i();
                    }
                };
                composerK.w(objG);
            }
            BackHandlerKt.a(false, (Function0) objG, composerK, 48, 1);
            Unit unit = Unit.f139807a;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = new OnboardingDataInfoScreenKt$OnboardingDataInfoScreen$2$1(null);
                composerK.w(objG2);
            }
            EffectsKt.g(unit, (Function2) objG2, composerK, 6);
            ComposeBackgroundKt.w(null, Float.valueOf(f4), null, ComposableLambdaKt.e(1654391447, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.onboarding.u1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OnboardingDataInfoScreenKt.j(onDataPolicyClicked, z2, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), ComposableLambdaKt.e(1220427766, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.onboarding.v1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OnboardingDataInfoScreenKt.l(onContinueClicked, onboardingVariant, onPartialSkipClicked, onFullSkipClicked, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.w1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingDataInfoScreenKt.o(f4, onContinueClicked, onDataPolicyClicked, onPartialSkipClicked, onFullSkipClicked, onboardingVariant, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(final Function0 function0, boolean z2, BoxScope GradientOnboardingBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientOnboardingBox, "$this$GradientOnboardingBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1654391447, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingDataInfoScreen.<anonymous> (OnboardingDataInfoScreen.kt:70)");
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
            String strB = StringResources_androidKt.b(R.string.um, composer, 0);
            TextStyle textStyleF = ComposeTypographyKt.g(composer, 0).f();
            TextAlign.Companion companion3 = TextAlign.f29616b;
            TextKt.c(strB, PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, textStyleF, composer, 48, 0, 65020);
            SpacerKt.a(SizeKt.i(companion, Dp.g(12)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.tm, composer, 0), PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null), ComposeColorsKt.j(composer, 0).P(), 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 48, 0, 65016);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            String strB2 = StringResources_androidKt.b(R.string.Z8, composer, 0);
            int i4 = R.drawable.f95580y1;
            Modifier modifierK = PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null);
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.x1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OnboardingDataInfoScreenKt.k(function0);
                    }
                };
                composer.w(objG);
            }
            Function0 function02 = (Function0) objG;
            Modifier modifierZ = companion;
            ComposeButtonsV2Kt.c(modifierK, strB2, i4, function02, composer, 6, 0);
            SpacerKt.a(SizeKt.i(modifierZ, Dp.g(24)), composer, 6);
            Painter painterC = PainterResources_androidKt.c(R.drawable.v8, composer, 0);
            Modifier modifierZ2 = SizeKt.z(PaddingKt.k(modifierZ, Dp.g(f3), 0.0f, 2, null), Dp.g(330), Dp.g(300), 0.0f, 0.0f, 12, null);
            if (z2) {
                modifierZ = SizeKt.z(modifierZ, 0.0f, 0.0f, 0.0f, Dp.g(RCHTTPStatusCodes.BAD_REQUEST), 7, null);
            }
            ImageKt.a(painterC, null, modifierZ2.then(modifierZ), null, null, 0.0f, null, composer, 48, 120);
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
    public static final Unit k(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Function0 function0, OnboardingViewStateV2.OnboardingVariant onboardingVariant, final Function0 function02, final Function0 function03, BoxScope GradientOnboardingBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientOnboardingBox, "$this$GradientOnboardingBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1220427766, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingDataInfoScreen.<anonymous> (OnboardingDataInfoScreen.kt:116)");
            }
            Alignment.Horizontal horizontalG = Alignment.f25072a.g();
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), horizontalG, composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion);
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
            ComposeButtonsKt.i0(null, new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.l8, composer, 0), 0.0f, 11, null), new ButtonColor.Accent(false, null, false, null, 15, null), function0, composer, 0, 1);
            if (onboardingVariant == OnboardingViewStateV2.OnboardingVariant.PartialSkip) {
                composer.a0(1219949546);
                SpacerKt.a(SizeKt.i(companion, Dp.g(12)), composer, 6);
                String strB = StringResources_androidKt.b(R.string.zm, composer, 0);
                boolean Z = composer.Z(function02);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.y1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return OnboardingDataInfoScreenKt.m(function02);
                        }
                    };
                    composer.w(objG);
                }
                ComposeButtonsV2Kt.d(null, strB, (Function0) objG, composer, 0, 1);
                composer.U();
            } else {
                if (onboardingVariant == OnboardingViewStateV2.OnboardingVariant.FullSkip) {
                    composer.a0(1220327467);
                    SpacerKt.a(SizeKt.i(companion, Dp.g(12)), composer, 6);
                    String strB2 = StringResources_androidKt.b(R.string.Zl, composer, 0);
                    boolean Z2 = composer.Z(function03);
                    Object objG2 = composer.G();
                    if (Z2 || objG2 == Composer.f23746a.a()) {
                        objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.z1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return OnboardingDataInfoScreenKt.n(function03);
                            }
                        };
                        composer.w(objG2);
                    }
                    ComposeButtonsV2Kt.d(null, strB2, (Function0) objG2, composer, 0, 1);
                } else {
                    composer.a0(1214880054);
                }
                composer.U();
            }
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
    public static final Unit m(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(float f3, Function0 function0, Function0 function02, Function0 function03, Function0 function04, OnboardingViewStateV2.OnboardingVariant onboardingVariant, int i3, Composer composer, int i4) {
        h(f3, function0, function02, function03, function04, onboardingVariant, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
