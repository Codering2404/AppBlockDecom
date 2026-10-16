package cz.mobilesoft.coreblock.scene.onboarding.statistics;

import android.content.Context;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.AccessTokenManager;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.insights.InsightsScreenComponentsKt;
import cz.mobilesoft.coreblock.scene.intro.OnboardingComposeCommonsKt;
import cz.mobilesoft.coreblock.scene.intro.stats.IntroReportPermissionFragment;
import cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewStateV2;
import cz.mobilesoft.coreblock.util.ViewModelState;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.FragmentContainerKt;
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
public final class IntroReportScreenKt {
    private static final float A(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float B(State state) {
        return ((Dp) state.getValue()).l();
    }

    private static final float C(State state) {
        return ((Dp) state.getValue()).l();
    }

    public static final void j(final Function0 onCloseClicked, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Composer composerK = composer.k(-635947946);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onCloseClicked) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-635947946, i4, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.IntroReportPermissionScreen (IntroReportScreen.kt:60)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierF = SizeKt.f(WindowInsetsPaddingKt.d(companion, WindowInsets_androidKt.e(WindowInsets.f7172a, composerK, 6)), 0.0f, 1, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierF);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Arrangement.HorizontalOrVertical horizontalOrVerticalE = arrangement.e();
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalE, companion2.l(), composerK, 6);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierH);
            Function0 function0A2 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A2);
            } else {
                composerK.v();
            }
            Composer composerA2 = Updater.a(composerK);
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF3, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            ComposeButtonsKt.o0(null, null, 0, onCloseClicked, composerK, (i4 << 9) & 7168, 7);
            float f3 = 6;
            OnboardingComposeCommonsKt.g(PaddingKt.m(companion, 0.0f, Dp.g(f3), Dp.g(f3), 0.0f, 9, null), composerK, 6, 0);
            composerK.y();
            Modifier modifierM = PaddingKt.m(ColumnScope.b(columnScopeInstance, SizeKt.f(companion, 0.0f, 1, null), 1.0f, false, 2, null), 0.0f, Dp.g(8), 0.0f, 0.0f, 13, null);
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.e0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return IntroReportScreenKt.k((FragmentTransaction) obj, ((Integer) obj2).intValue());
                    }
                };
                composerK.w(objG);
            }
            FragmentContainerKt.f(modifierM, (Function2) objG, composerK, 48, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.f0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IntroReportScreenKt.l(onCloseClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(FragmentTransaction FragmentContainer, int i3) {
        Intrinsics.checkNotNullParameter(FragmentContainer, "$this$FragmentContainer");
        FragmentContainer.s(i3, IntroReportPermissionFragment.f104922l.a());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Function0 function0, int i3, Composer composer, int i4) {
        j(function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void m(final float f3, final OnboardingViewStateV2 viewState, final Function0 onContinueClicked, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onContinueClicked, "onContinueClicked");
        Composer composerK = composer.k(258992020);
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
                ComposerKt.U(258992020, i4, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.IntroReportScreen (IntroReportScreen.kt:92)");
            }
            ViewModelState viewModelStateE = viewState.e();
            boolean zK = viewState.k();
            int iIntValue = 0;
            long jI = viewState.i();
            Integer numG = viewState.g();
            if (numG != null) {
                iIntValue = numG.intValue();
            }
            q(f3, viewModelStateE, zK, jI, iIntValue, viewState.h(), onContinueClicked, composerK, (i4 & 14) | ((i4 << 12) & 3670016), 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IntroReportScreenKt.n(f3, viewState, onContinueClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(float f3, OnboardingViewStateV2 onboardingViewStateV2, Function0 function0, int i3, Composer composer, int i4) {
        m(f3, onboardingViewStateV2, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x04f3  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x04f7  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0598  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0267  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void o(final int r41, final int r42, java.lang.String r43, java.lang.String r44, androidx.compose.runtime.Composer r45, final int r46, final int r47) {
        /*
            Method dump skipped, instruction units count: 1467
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.onboarding.statistics.IntroReportScreenKt.o(int, int, java.lang.String, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(int i3, int i4, String str, String str2, int i5, int i6, Composer composer, int i7) {
        o(i3, i4, str, str2, composer, RecomposeScopeImplKt.a(i5 | 1), i6);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void q(final float r28, final cz.mobilesoft.coreblock.util.ViewModelState r29, final boolean r30, final long r31, final int r33, final int r34, kotlin.jvm.functions.Function0 r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instruction units count: 612
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.onboarding.statistics.IntroReportScreenKt.q(float, cz.mobilesoft.coreblock.util.ViewModelState, boolean, long, int, int, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(final boolean z2, final State state, final State state2, final State state3, final State state4, final State state5, final long j3, final int i3, final int i4, BoxScope GradientOnboardingBox, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(GradientOnboardingBox, "$this$GradientOnboardingBox");
        if (composer.r((i5 & 17) != 16, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1644668633, i5, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.ReportScreen.<anonymous> (IntroReportScreen.kt:163)");
            }
            BoxWithConstraintsKt.a(SizeKt.f(Modifier.b8, 0.0f, 1, null), null, false, ComposableLambdaKt.e(831048445, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.c0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return IntroReportScreenKt.t(z2, state, state2, state3, state4, state5, j3, i3, i4, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 3078, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(boolean z2, State state, State state2, State state3, State state4, State state5, long j3, int i3, int i4, BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i5) {
        int i6;
        long jC0;
        float f3;
        int i7;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        if ((i5 & 6) == 0) {
            i6 = i5 | (composer.Z(BoxWithConstraints) ? 4 : 2);
        } else {
            i6 = i5;
        }
        if (composer.r((i6 & 19) != 18, i6 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(831048445, i6, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.ReportScreen.<anonymous>.<anonymous> (IntroReportScreen.kt:164)");
            }
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.HorizontalOrVertical horizontalOrVerticalE = arrangement.e();
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion.g();
            Modifier.Companion companion2 = Modifier.b8;
            float f4 = 16;
            Modifier modifierM = PaddingKt.m(PaddingKt.k(SizeKt.k(ScrollKt.g(companion2, ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null), BoxWithConstraints.g(), 0.0f, 2, null), PrimitiveResources_androidKt.a(R.dimen.f95486t, composer, 0), 0.0f, 2, null), 0.0f, Dp.g(f4), 0.0f, 0.0f, 13, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalE, horizontalG, composer, 54);
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            if (z2) {
                composer.a0(-1198139848);
                jC0 = ComposeColorsKt.j(composer, 0).A();
            } else {
                composer.a0(-1198139274);
                jC0 = ComposeColorsKt.j(composer, 0).c0();
            }
            composer.U();
            long j4 = jC0;
            Alignment.Horizontal horizontalG2 = companion.g();
            Modifier modifierH = SizeKt.h(AlphaKt.a(companion2, z(state)), 0.0f, 1, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), horizontalG2, composer, 48);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierH);
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
            String strB = StringResources_androidKt.b(z2 ? R.string.Cl : R.string.El, composer, 0);
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(strB, PaddingKt.k(companion2, Dp.g(f4), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).f(), composer, 48, 0, 65020);
            Composer composer2 = composer;
            float f5 = 12;
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f5)), composer2, 6);
            if (z2) {
                composer2.a0(-955522766);
                String strB2 = StringResources_androidKt.b(R.string.Dl, composer2, 0);
                TextStyle textStyleB = ComposeTypographyKt.g(composer2, 0).b();
                int iA3 = companion4.a();
                f3 = f5;
                i7 = 6;
                TextKt.c(strB2, PaddingKt.k(companion2, Dp.g(f4), 0.0f, 2, null), ComposeColorsKt.j(composer2, 0).P(), 0L, null, null, null, 0L, null, TextAlign.h(iA3), 0L, 0, false, 0, 0, null, textStyleB, composer, 48, 0, 65016);
                composer2 = composer;
            } else {
                f3 = f5;
                i7 = 6;
                composer2.a0(-963455015);
            }
            composer2.U();
            composer2.y();
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composer2, i7);
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 1.0f, false, 2, null), composer2, 0);
            Modifier modifierA = AlphaKt.a(companion2, y(state2));
            MeasurePolicy measurePolicyG = BoxKt.g(companion.o(), false);
            int iA4 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU3 = composer2.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer2, modifierA);
            Function0 function0A3 = companion3.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A3);
            } else {
                composer2.v();
            }
            Composer composerA3 = Updater.a(composer2);
            Updater.e(composerA3, measurePolicyG, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA4))) {
                composerA3.w(Integer.valueOf(iA4));
                composerA3.p(Integer.valueOf(iA4), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            InsightsScreenComponentsKt.G2(null, z2, B(state3), C(state4), composer2, 0, 1);
            composer2.y();
            Modifier modifierA2 = AlphaKt.a(companion2, A(state5));
            MeasurePolicy measurePolicyA3 = ColumnKt.a(arrangement.h(), companion.g(), composer2, 48);
            int iA5 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU4 = composer2.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer2, modifierA2);
            Function0 function0A4 = companion3.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A4);
            } else {
                composer2.v();
            }
            Composer composerA4 = Updater.a(composer2);
            Updater.e(composerA4, measurePolicyA3, companion3.e());
            Updater.e(composerA4, compositionLocalMapU4, companion3.g());
            Function2 function2B4 = companion3.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA5))) {
                composerA4.w(Integer.valueOf(iA5));
                composerA4.p(Integer.valueOf(iA5), function2B4);
            }
            Updater.e(composerA4, modifierF4, companion3.f());
            TextKt.c(StringHelper.f((Context) composer2.q(AndroidCompositionLocals_androidKt.g()), ((long) 1000) * j3), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composer2, 0).e(), 0L, TextUnitKt.i(56), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(68), null, null, null, 0, 0, null, 16646141, null), composer, 0, 0, 65534);
            TextKt.c(StringResources_androidKt.c(z2 ? R.string.Sh : R.string.Th, new Object[]{Integer.valueOf(i3)}, composer, 0), null, j4, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65530);
            composer.y();
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composer, i7);
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 1.0f, false, 2, null), composer, 0);
            Modifier modifierH2 = SizeKt.h(AlphaKt.a(companion2, z(state)), 0.0f, 1, null);
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion.o(), false);
            int iA6 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU5 = composer.u();
            Modifier modifierF5 = ComposedModifierKt.f(composer, modifierH2);
            Function0 function0A5 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A5);
            } else {
                composer.v();
            }
            Composer composerA5 = Updater.a(composer);
            Updater.e(composerA5, measurePolicyG2, companion3.e());
            Updater.e(composerA5, compositionLocalMapU5, companion3.g());
            Function2 function2B5 = companion3.b();
            if (composerA5.i() || !Intrinsics.areEqual(composerA5.G(), Integer.valueOf(iA6))) {
                composerA5.w(Integer.valueOf(iA6));
                composerA5.p(Integer.valueOf(iA6), function2B5);
            }
            Updater.e(composerA5, modifierF5, companion3.f());
            o(i4 * AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS, (int) j3, null, null, composer, 0, 12);
            composer.y();
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composer, i7);
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 3.0f, false, 2, null), composer, 0);
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
    public static final Unit u(State state, Function0 function0, BoxScope GradientOnboardingBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientOnboardingBox, "$this$GradientOnboardingBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-882787322, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.ReportScreen.<anonymous> (IntroReportScreen.kt:265)");
            }
            Modifier modifierH = SizeKt.h(AlphaKt.a(Modifier.b8, z(state)), 0.0f, 1, null);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            ComposeButtonsKt.J(null, StringResources_androidKt.b(R.string.xh, composer, 0), false, false, null, function0, composer, 0, 29);
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
    public static final Unit v(float f3, ViewModelState viewModelState, boolean z2, long j3, int i3, int i4, Function0 function0, int i5, int i6, Composer composer, int i7) {
        q(f3, viewModelState, z2, j3, i3, i4, function0, composer, RecomposeScopeImplKt.a(i5 | 1), i6);
        return Unit.f139807a;
    }

    private static final AnimationState w(MutableState mutableState) {
        return (AnimationState) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(MutableState mutableState, AnimationState animationState) {
        mutableState.setValue(animationState);
    }

    private static final float y(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float z(State state) {
        return ((Number) state.getValue()).floatValue();
    }
}
