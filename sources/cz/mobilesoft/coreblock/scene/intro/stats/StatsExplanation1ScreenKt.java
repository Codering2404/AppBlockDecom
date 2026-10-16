package cz.mobilesoft.coreblock.scene.intro.stats;

import android.content.Context;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.Arrangement;
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
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.intro.OnboardingViewState;
import cz.mobilesoft.coreblock.scene.intro.question.ExplanationScreenKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class StatsExplanation1ScreenKt {
    public static final void c(final OnboardingViewState viewState, Function0 onContinueClicked, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onContinueClicked, "onContinueClicked");
        Composer composerK = composer.k(1178657625);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onContinueClicked) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1178657625, i4, -1, "cz.mobilesoft.coreblock.scene.intro.stats.StatsExplanation1Screen (StatsExplanation1Screen.kt:51)");
            }
            final DecimalFormat decimalFormat = new DecimalFormat("0.#");
            final float fC = viewState.c() / 3600.0f;
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            int i5 = R.string.Dm;
            String strL = DateHelper.l(context, viewState.c() * 1000, true);
            Intrinsics.checkNotNullExpressionValue(strL, "getRemainingTimeString(...)");
            function0 = onContinueClicked;
            ExplanationScreenKt.e(StringResources_androidKt.c(i5, new Object[]{strL}, composerK, 0), null, null, function0, null, ComposableLambdaKt.e(-853428492, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.stats.p
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StatsExplanation1ScreenKt.d(fC, decimalFormat, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, ((i4 << 6) & 7168) | 196608, 22);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onContinueClicked;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.stats.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatsExplanation1ScreenKt.h(viewState, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(float f3, DecimalFormat decimalFormat, ColumnScope ExplanationScreen, Composer composer, int i3) {
        int i4;
        String str;
        Intrinsics.checkNotNullParameter(ExplanationScreen, "$this$ExplanationScreen");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(ExplanationScreen) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-853428492, i4, -1, "cz.mobilesoft.coreblock.scene.intro.stats.StatsExplanation1Screen.<anonymous> (StatsExplanation1Screen.kt:66)");
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalB = Arrangement.f6574a.b();
            Alignment.Horizontal horizontalG = Alignment.f25072a.g();
            Modifier.Companion companion = Modifier.b8;
            float f4 = 32;
            Modifier modifierM = PaddingKt.m(PaddingKt.k(ColumnScope.b(ExplanationScreen, SizeKt.f(companion, 0.0f, 1, null), 1.0f, false, 2, null), Dp.g(24), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.g(f4), 7, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalB, horizontalG, composer, 54);
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
            TweenSpec tweenSpecN = AnimationSpecKt.n(1000, 0, EasingKt.d(), 2, null);
            Object objG = composer.G();
            Composer.Companion companion3 = Composer.f23746a;
            if (objG == companion3.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Float.valueOf(0.0f), null, 2, null);
                composer.w(objG);
            }
            MutableState mutableState = (MutableState) objG;
            State stateD = AnimateAsStateKt.d(e(mutableState), tweenSpecN, 0.0f, "animatedYears", null, composer, 3072, 20);
            Unit unit = Unit.f139807a;
            boolean zC = composer.c(f3);
            Object objG2 = composer.G();
            if (zC || objG2 == companion3.a()) {
                objG2 = new StatsExplanation1ScreenKt$StatsExplanation1Screen$1$1$1$1(f3, mutableState, null);
                composer.w(objG2);
            }
            EffectsKt.g(unit, (Function2) objG2, composer, 6);
            if (g(stateD) == e(mutableState)) {
                str = decimalFormat.format(Float.valueOf(e(mutableState)));
            } else {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                str = String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(g(stateD))}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            }
            Intrinsics.checkNotNull(str);
            TextKt.c(str, SizeKt.C(companion, Dp.g(359), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, TextStyle.c(ComposeTypographyKt.g(composer, 0).e(), Brush.Companion.b(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.n(ColorKt.d(4294939904L)), Color.n(ColorKt.d(4294916935L)), Color.n(ColorKt.d(4284832255L))}), 0.0f, 0.0f, 0, 14, null), 0.0f, TextUnitKt.i(80), new FontWeight(800), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(97), null, null, null, 0, 0, null, 33292274, null), composer, 48, 0, 65020);
            TextKt.c(StringResources_androidKt.b(R.string.tH, composer, 0), PaddingKt.m(companion, 0.0f, Dp.g(f4), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).f(), composer, 48, 0, 65532);
            TextKt.c(StringResources_androidKt.b(R.string.Xz, composer, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65534);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    private static final float e(MutableState mutableState) {
        return ((Number) mutableState.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(MutableState mutableState, float f3) {
        mutableState.setValue(Float.valueOf(f3));
    }

    private static final float g(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(OnboardingViewState onboardingViewState, Function0 function0, int i3, Composer composer, int i4) {
        c(onboardingViewState, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
