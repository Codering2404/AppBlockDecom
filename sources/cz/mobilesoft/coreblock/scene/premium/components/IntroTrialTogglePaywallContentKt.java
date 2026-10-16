package cz.mobilesoft.coreblock.scene.premium.components;

import android.app.Activity;
import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.valentinilk.shimmer.Shimmer;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenKt;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewEvent;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
import cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.ModifierExtKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
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
public final class IntroTrialTogglePaywallContentKt {
    public static final void l(PaddingValues paddingValues, final PremiumScreenViewState viewState, final Shimmer shimmerInstance, final Function0 onClosedOrSkipped, final Function1 onEvent, Composer composer, final int i3) {
        int i4;
        PaddingValues paddingValues2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(shimmerInstance, "shimmerInstance");
        Intrinsics.checkNotNullParameter(onClosedOrSkipped, "onClosedOrSkipped");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(1992378798);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(viewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= (i3 & 512) == 0 ? composerK.Z(shimmerInstance) : composerK.I(shimmerInstance) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onClosedOrSkipped) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(onEvent) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1992378798, i4, -1, "cz.mobilesoft.coreblock.scene.premium.components.IntroTrialTogglePaywallContent (IntroTrialTogglePaywallContent.kt:78)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Unit unit = Unit.f139807a;
            boolean z2 = (i4 & 112) == 32;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new IntroTrialTogglePaywallContentKt$IntroTrialTogglePaywallContent$1$1(viewState, null);
                composerK.w(objG);
            }
            EffectsKt.g(unit, (Function2) objG, composerK, 6);
            paddingValues2 = paddingValues;
            PremiumScreenKt.n(paddingValues2, ComposableLambdaKt.e(948005431, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.o0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IntroTrialTogglePaywallContentKt.m(viewState, onClosedOrSkipped, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), ComposableLambdaKt.e(1926057672, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.components.q0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return IntroTrialTogglePaywallContentKt.o(viewState, shimmerInstance, onEvent, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), ComposableLambdaKt.e(-814820295, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.r0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IntroTrialTogglePaywallContentKt.q(viewState, onEvent, context, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, (i4 & 14) | 3504, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            paddingValues2 = paddingValues;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final PaddingValues paddingValues3 = paddingValues2;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.s0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IntroTrialTogglePaywallContentKt.t(paddingValues3, viewState, shimmerInstance, onClosedOrSkipped, onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(final PremiumScreenViewState premiumScreenViewState, final Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(948005431, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.IntroTrialTogglePaywallContent.<anonymous> (IntroTrialTogglePaywallContent.kt:86)");
            }
            boolean zM = premiumScreenViewState.m();
            boolean Z = composer.Z(premiumScreenViewState) | composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.components.t0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return IntroTrialTogglePaywallContentKt.n(premiumScreenViewState, function0);
                    }
                };
                composer.w(objG);
            }
            PremiumTitleAndSubtitleKt.i(zM, (Function0) objG, composer, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(PremiumScreenViewState premiumScreenViewState, Function0 function0) {
        AnswersHelper.f128199a.x2(premiumScreenViewState.q().getId());
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(final PremiumScreenViewState premiumScreenViewState, Shimmer shimmer, Function1 function1, ColumnScope PremiumScreen, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(PremiumScreen, "$this$PremiumScreen");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(PremiumScreen) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1926057672, i4, -1, "cz.mobilesoft.coreblock.scene.premium.components.IntroTrialTogglePaywallContent.<anonymous> (IntroTrialTogglePaywallContent.kt:95)");
            }
            PremiumTitleAndSubtitleKt.e(premiumScreenViewState, false, false, false, false, shimmer, null, composer, Shimmer.f93784d << 15, 94);
            PremiumScreenKt.p(PremiumScreen, premiumScreenViewState, function1, null, ComposableLambdaKt.e(-714940546, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.components.w0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return IntroTrialTogglePaywallContentKt.p(premiumScreenViewState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, (i4 & 14) | 24576, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(PremiumScreenViewState premiumScreenViewState, ColumnScope PremiumScreenContent, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(PremiumScreenContent, "$this$PremiumScreenContent");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-714940546, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.IntroTrialTogglePaywallContent.<anonymous>.<anonymous> (IntroTrialTogglePaywallContent.kt:104)");
            }
            if (premiumScreenViewState.Z()) {
                composer.a0(-50861082);
                PremiumTrialTimelineKt.k(PaddingKt.m(PaddingKt.k(Modifier.b8, PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null), 0.0f, Dp.g(16), 0.0f, 0.0f, 13, null), 0L, premiumScreenViewState.Q(), false, premiumScreenViewState.W(), true, composer, 199680, 2);
                composer.U();
            } else {
                composer.a0(-49971754);
                float f3 = 32;
                Modifier modifierM = PaddingKt.m(PaddingKt.k(Modifier.b8, Dp.g(f3), 0.0f, 2, null), 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null);
                MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
                int iA = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU = composer.u();
                Modifier modifierF = ComposedModifierKt.f(composer, modifierM);
                ComposeUiNode.Companion companion = ComposeUiNode.f8;
                Function0 function0A = companion.a();
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
                Updater.e(composerA, measurePolicyA, companion.e());
                Updater.e(composerA, compositionLocalMapU, companion.g());
                Function2 function2B = companion.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF, companion.f());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
                PremiumBenefitsCardKt.k(ComposeColorsKt.j(composer, 0).p(), ComposeColorsKt.j(composer, 0).q(), composer, 0, 0);
                composer.y();
                composer.U();
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
    public static final Unit q(final PremiumScreenViewState premiumScreenViewState, final Function1 function1, final Context context, Composer composer, int i3) {
        int i4;
        String strP;
        float f3;
        Modifier.Companion companion;
        Composer composer2 = composer;
        if (composer2.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-814820295, i3, -1, "cz.mobilesoft.coreblock.scene.premium.components.IntroTrialTogglePaywallContent.<anonymous> (IntroTrialTogglePaywallContent.kt:135)");
            }
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierH = PaddingKt.h(companion2, ComposableExtKt.i(composer2, 0));
            Alignment.Companion companion3 = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion3.g();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composer2, 48);
            int iA = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF = ComposedModifierKt.f(composer2, modifierH);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A);
            } else {
                composer2.v();
            }
            Composer composerA = Updater.a(composer2);
            Updater.e(composerA, measurePolicyA, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            if (premiumScreenViewState.G()) {
                composer2.a0(1174420020);
                boolean Z = premiumScreenViewState.Z();
                boolean Z2 = composer2.Z(premiumScreenViewState) | composer2.Z(function1);
                Object objG = composer2.G();
                if (Z2 || objG == Composer.f23746a.a()) {
                    objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.components.u0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return IntroTrialTogglePaywallContentKt.r(premiumScreenViewState, function1, ((Boolean) obj).booleanValue());
                        }
                    };
                    composer2.w(objG);
                }
                u(Z, (Function1) objG, null, composer, 0, 4);
                composer2 = composer;
                float f4 = 16;
                SpacerKt.a(SizeKt.i(companion2, Dp.g(f4)), composer2, 6);
                Modifier modifierH2 = SizeKt.h(companion2, 0.0f, 1, null);
                MeasurePolicy measurePolicyB = RowKt.b(arrangement.o(Dp.g(f4)), companion3.l(), composer2, 6);
                int iA2 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU2 = composer2.u();
                Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierH2);
                Function0 function0A2 = companion4.a();
                if (composer2.m() == null) {
                    ComposablesKt.c();
                }
                composer2.L();
                if (composer2.i()) {
                    composer2.P(function0A2);
                } else {
                    composer2.v();
                }
                Composer composerA2 = Updater.a(composer2);
                Updater.e(composerA2, measurePolicyB, companion4.e());
                Updater.e(composerA2, compositionLocalMapU2, companion4.g());
                Function2 function2B2 = companion4.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion4.f());
                Modifier modifierC = RowScope.c(RowScopeInstance.f7101a, companion2, 1.0f, false, 2, null);
                if (premiumScreenViewState.Z()) {
                    composer2.a0(-1986329446);
                    i4 = R.string.ze;
                } else {
                    composer2.a0(-1986327856);
                    i4 = R.string.bC;
                }
                String strB = StringResources_androidKt.b(i4, composer2, 0);
                composer2.U();
                ButtonType.ProgressButton progressButton = new ButtonType.ProgressButton(strB, null, premiumScreenViewState.X(), 2, null);
                ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 15, null);
                boolean zI = composer2.I(context) | composer2.Z(function1) | composer2.Z(premiumScreenViewState);
                Object objG2 = composer2.G();
                if (zI || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.components.v0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return IntroTrialTogglePaywallContentKt.s(context, function1, premiumScreenViewState);
                        }
                    };
                    composer2.w(objG2);
                }
                ComposeButtonsKt.i0(modifierC, progressButton, accent, (Function0) objG2, composer2, 0, 0);
                composer2.y();
                PremiumOptionDTO premiumOptionDTOD = premiumScreenViewState.D();
                String strA = premiumOptionDTOD != null ? premiumOptionDTOD.a() : null;
                if (strA == null) {
                    composer2.a0(1176152857);
                    composer2.U();
                    f3 = f4;
                    companion = companion2;
                } else {
                    composer2.a0(1176152858);
                    SpacerKt.a(SizeKt.i(companion2, Dp.g(f4)), composer2, 6);
                    if (premiumScreenViewState.Z()) {
                        composer2.a0(1556980755);
                        strP = StringHelperExtKt.q(StringResources_androidKt.c(R.string.Ae, new Object[]{Integer.valueOf(premiumScreenViewState.Q())}, composer2, 0), StringResources_androidKt.c(R.string.lq, new Object[]{strA}, composer2, 0), null, 2, null);
                        composer2.U();
                    } else {
                        composer2.a0(1556986393);
                        strP = StringHelperExtKt.p(StringResources_androidKt.c(R.string.ci, new Object[]{strA}, composer2, 0), StringResources_androidKt.b(R.string.P4, composer2, 0), ". ");
                        composer2.U();
                    }
                    f3 = f4;
                    companion = companion2;
                    TextKt.c(strP, null, ComposeColorsKt.j(composer2, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).b(), composer, 0, 0, 65530);
                    composer2 = composer;
                    Unit unit = Unit.f139807a;
                    composer2.U();
                }
                SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer2, 6);
            } else {
                composer2.a0(1167525651);
            }
            composer2.U();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(PremiumScreenViewState premiumScreenViewState, Function1 function1, boolean z2) {
        AnswersHelper.f128199a.z2(z2, premiumScreenViewState.q().getId());
        function1.invoke(new PremiumScreenViewEvent.OnTrialToggleClicked(z2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Context context, Function1 function1, PremiumScreenViewState premiumScreenViewState) {
        Activity activityB = ContextExtKt.b(context);
        if (activityB != null) {
            function1.invoke(new PremiumScreenViewEvent.OnPurchase(activityB, premiumScreenViewState.D()));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(PaddingValues paddingValues, PremiumScreenViewState premiumScreenViewState, Shimmer shimmer, Function0 function0, Function1 function1, int i3, Composer composer, int i4) {
        l(paddingValues, premiumScreenViewState, shimmer, function0, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x033b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void u(final boolean r39, final kotlin.jvm.functions.Function1 r40, androidx.compose.ui.Modifier r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instruction units count: 844
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.components.IntroTrialTogglePaywallContentKt.u(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final long v(State state) {
        return ((Color) state.getValue()).B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(HapticFeedback hapticFeedback, Function1 function1, boolean z2) {
        hapticFeedback.a(HapticFeedbackType.f26611b.e());
        function1.invoke(Boolean.valueOf(z2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier x(long j3, long j4, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return ModifierExtKt.h(applyIf, j3, j4, 3000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(boolean z2, Function1 function1, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        u(z2, function1, modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
