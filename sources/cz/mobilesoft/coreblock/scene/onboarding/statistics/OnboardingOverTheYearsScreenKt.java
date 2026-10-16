package cz.mobilesoft.coreblock.scene.onboarding.statistics;

import android.content.Context;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewStateV2;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

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
public final class OnboardingOverTheYearsScreenKt {
    public static final void f(final float f3, final OnboardingViewStateV2 viewState, final Function0 onContinueClicked, Composer composer, final int i3) {
        int i4;
        String str;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onContinueClicked, "onContinueClicked");
        Composer composerK = composer.k(-828612226);
        if ((i3 & 6) == 0) {
            i4 = (composerK.c(f3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(viewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onContinueClicked) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-828612226, i4, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.OnboardingOverTheYearsScreen (OnboardingOverTheYearsScreen.kt:48)");
            }
            DecimalFormat decimalFormat = new DecimalFormat("0.#");
            final float fI = viewState.i() / 3600.0f;
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            TweenSpec tweenSpecN = AnimationSpecKt.n(1000, 0, EasingKt.d(), 2, null);
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = PrimitiveSnapshotStateKt.a(0.0f);
                composerK.w(objG);
            }
            final MutableFloatState mutableFloatState = (MutableFloatState) objG;
            State stateD = AnimateAsStateKt.d(g(mutableFloatState), tweenSpecN, 0.0f, "animatedYears", null, composerK, 3072, 20);
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.n0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OnboardingOverTheYearsScreenKt.j();
                    }
                };
                composerK.w(objG2);
            }
            BackHandlerKt.a(false, (Function0) objG2, composerK, 48, 1);
            if (i(stateD) == g(mutableFloatState)) {
                str = decimalFormat.format(Float.valueOf(g(mutableFloatState)));
            } else {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                str = String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(i(stateD))}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            }
            final String str2 = str;
            ComposeBackgroundKt.w(null, Float.valueOf(f3), null, ComposableLambdaKt.e(757855043, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.o0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OnboardingOverTheYearsScreenKt.k(fI, mutableFloatState, context, viewState, str2, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), ComposableLambdaKt.e(2042917572, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.p0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OnboardingOverTheYearsScreenKt.l(onContinueClicked, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.q0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingOverTheYearsScreenKt.n(f3, viewState, onContinueClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float g(MutableFloatState mutableFloatState) {
        return mutableFloatState.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(MutableFloatState mutableFloatState, float f3) {
        mutableFloatState.s(f3);
    }

    private static final float i(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(float f3, MutableFloatState mutableFloatState, Context context, OnboardingViewStateV2 onboardingViewStateV2, String str, BoxScope GradientOnboardingBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientOnboardingBox, "$this$GradientOnboardingBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(757855043, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.OnboardingOverTheYearsScreen.<anonymous> (OnboardingOverTheYearsScreen.kt:81)");
            }
            Unit unit = Unit.f139807a;
            boolean zC = composer.c(f3);
            Object objG = composer.G();
            if (zC || objG == Composer.f23746a.a()) {
                objG = new OnboardingOverTheYearsScreenKt$OnboardingOverTheYearsScreen$2$1$1(f3, mutableFloatState, null);
                composer.w(objG);
            }
            EffectsKt.g(unit, (Function2) objG, composer, 6);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.HorizontalOrVertical horizontalOrVerticalE = arrangement.e();
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion.g();
            Modifier.Companion companion2 = Modifier.b8;
            float f4 = 16;
            Modifier modifierH = SizeKt.h(PaddingKt.m(companion2, 0.0f, Dp.g(f4), 0.0f, 0.0f, 13, null), 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalE, horizontalG, composer, 54);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
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
            int i4 = R.string.nm;
            String strL = DateHelper.l(context, onboardingViewStateV2.i() * 1000, true);
            Intrinsics.checkNotNullExpressionValue(strL, "getRemainingTimeString(...)");
            String strC = StringResources_androidKt.c(i4, new Object[]{strL}, composer, 0);
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(strC, PaddingKt.k(companion2, Dp.g(f4), 0.0f, 2, null), ComposeColorsKt.j(composer, 0).b(), 0L, FontStyle.c(FontStyle.f29211b.a()), null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 48, 0, 65000);
            TextKt.c(StringResources_androidKt.b(R.string.mm, composer, 0), PaddingKt.k(companion2, Dp.g(f4), 0.0f, 2, null), ComposeColorsKt.j(composer, 0).L(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).f(), composer, 48, 0, 65016);
            Arrangement.HorizontalOrVertical horizontalOrVerticalB = arrangement.b();
            Alignment.Horizontal horizontalG2 = companion.g();
            Modifier modifierB = ColumnScope.b(columnScopeInstance, companion2, 1.0f, false, 2, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(horizontalOrVerticalB, horizontalG2, composer, 54);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierB);
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
            Updater.e(composerA2, measurePolicyA2, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            Intrinsics.checkNotNull(str);
            TextKt.c(str, SizeKt.C(companion2, Dp.g(359), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, TextStyle.c(ComposeTypographyKt.g(composer, 0).e(), Brush.Companion.b(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.n(ColorKt.d(4288104447L)), Color.n(ColorKt.d(4294916935L))}), 0.0f, 0.0f, 0, 14, null), 0.0f, TextUnitKt.i(140), new FontWeight(900), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(169), null, null, null, 0, 0, null, 33292274, null), composer, 48, 0, 65020);
            String upperCase = StringResources_androidKt.b(R.string.tH, composer, 0).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            TextKt.c(upperCase, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).f(), composer, 0, 0, 65534);
            TextKt.c(StringResources_androidKt.b(R.string.Xz, composer, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65534);
            composer.y();
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
    public static final Unit l(final Function0 function0, BoxScope GradientOnboardingBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientOnboardingBox, "$this$GradientOnboardingBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2042917572, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.OnboardingOverTheYearsScreen.<anonymous> (OnboardingOverTheYearsScreen.kt:149)");
            }
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.l8, composer, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 15, null);
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.r0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OnboardingOverTheYearsScreenKt.m(function0);
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
    public static final Unit m(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(float f3, OnboardingViewStateV2 onboardingViewStateV2, Function0 function0, int i3, Composer composer, int i4) {
        f(f3, onboardingViewStateV2, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
