package cz.mobilesoft.coreblock.scene.onboarding.statistics;

import android.app.Activity;
import android.content.Context;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewStateV2;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelperV2;
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
public final class OnboardingStatsPermissionScreenKt {
    public static final void f(final float f3, final OnboardingViewStateV2.OnboardingVariant onboardingVariant, final Function0 onPartialSkipClicked, Function0 onCloseClicked, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(onboardingVariant, "onboardingVariant");
        Intrinsics.checkNotNullParameter(onPartialSkipClicked, "onPartialSkipClicked");
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Composer composerK = composer.k(-234283195);
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
            i4 |= composerK.I(onCloseClicked) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-234283195, i4, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.OnboardingStatsPermissionScreen (OnboardingStatsPermissionScreen.kt:40)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.s0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OnboardingStatsPermissionScreenKt.g();
                    }
                };
                composerK.w(objG);
            }
            BackHandlerKt.a(false, (Function0) objG, composerK, 48, 1);
            Unit unit = Unit.f139807a;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = new OnboardingStatsPermissionScreenKt$OnboardingStatsPermissionScreen$2$1(null);
                composerK.w(objG2);
            }
            EffectsKt.g(unit, (Function2) objG2, composerK, 6);
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            ComposeBackgroundKt.w(null, Float.valueOf(f3), onCloseClicked, ComposableSingletons$OnboardingStatsPermissionScreenKt.f111365a.b(), ComposableLambdaKt.e(208893835, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.t0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OnboardingStatsPermissionScreenKt.h(context, onboardingVariant, onPartialSkipClicked, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, ((i4 << 3) & 112) | 27648 | ((i4 >> 3) & 896), 1);
            function0 = onCloseClicked;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onCloseClicked;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.u0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingStatsPermissionScreenKt.k(f3, onboardingVariant, onPartialSkipClicked, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(final Context context, OnboardingViewStateV2.OnboardingVariant onboardingVariant, final Function0 function0, BoxScope GradientOnboardingBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientOnboardingBox, "$this$GradientOnboardingBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(208893835, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.OnboardingStatsPermissionScreen.<anonymous> (OnboardingStatsPermissionScreen.kt:96)");
            }
            final String strB = StringResources_androidKt.b(R.string.F1, composer, 0);
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
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.Qe, composer, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 15, null);
            boolean zI = composer.I(context) | composer.Z(strB);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.v0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OnboardingStatsPermissionScreenKt.i(context, strB);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.i0(null, big, accent, (Function0) objG, composer, 0, 1);
            if (onboardingVariant != OnboardingViewStateV2.OnboardingVariant.NoSkip) {
                composer.a0(1405778974);
                SpacerKt.a(SizeKt.i(companion, Dp.g(12)), composer, 6);
                String strB2 = StringResources_androidKt.b(R.string.Yl, composer, 0);
                boolean Z = composer.Z(function0);
                Object objG2 = composer.G();
                if (Z || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.w0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return OnboardingStatsPermissionScreenKt.j(function0);
                        }
                    };
                    composer.w(objG2);
                }
                ComposeButtonsV2Kt.d(null, strB2, (Function0) objG2, composer, 0, 1);
            } else {
                composer.a0(1401299629);
            }
            composer.U();
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
    public static final Unit i(Context context, String str) {
        Activity activityB = ContextExtKt.b(context);
        if (activityB != null) {
            PermissionHelperV2.f129006a.h(activityB, str, activityB.getComponentName(), true);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(float f3, OnboardingViewStateV2.OnboardingVariant onboardingVariant, Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        f(f3, onboardingVariant, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
