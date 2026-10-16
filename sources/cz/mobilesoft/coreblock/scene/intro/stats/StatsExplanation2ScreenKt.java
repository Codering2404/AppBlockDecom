package cz.mobilesoft.coreblock.scene.intro.stats;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.SurfaceKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.intro.OnboardingViewState;
import cz.mobilesoft.coreblock.scene.intro.question.ExplanationScreenKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

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
public final class StatsExplanation2ScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Context context, OnboardingViewState onboardingViewState, long j3, ColumnScope ExplanationScreen, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(ExplanationScreen, "$this$ExplanationScreen");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(ExplanationScreen) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(551224050, i4, -1, "cz.mobilesoft.coreblock.scene.intro.stats.StatsExplanation2Screen.<anonymous> (StatsExplanation2Screen.kt:68)");
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalB = Arrangement.f6574a.b();
            Modifier modifierM = PaddingKt.m(PaddingKt.k(ColumnScope.b(ExplanationScreen, SizeKt.f(Modifier.b8, 0.0f, 1, null), 1.0f, false, 2, null), Dp.g(24), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.g(32), 7, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalB, Alignment.f25072a.k(), composer, 6);
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
            String strB = StringResources_androidKt.b(R.string.VC, composer, 0);
            String strL = DateHelper.l(context, onboardingViewState.c() * 1000, true);
            Intrinsics.checkNotNullExpressionValue(strL, "getRemainingTimeString(...)");
            String strL2 = DateHelper.l(context, onboardingViewState.c() * 250, true);
            Intrinsics.checkNotNullExpressionValue(strL2, "getRemainingTimeString(...)");
            i(strB, strL, strL2, 0.26f, composer, 3072);
            i(StringResources_androidKt.b(R.string.T8, composer, 0), j3 + "×", MathKt.d((j3 / 5.0f) + 0.12f) + "×", 0.32f, composer, 3072);
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
    public static final Unit B(OnboardingViewState onboardingViewState, Function0 function0, int i3, Composer composer, int i4) {
        z(onboardingViewState, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void i(final java.lang.String r38, final java.lang.String r39, final java.lang.String r40, final float r41, androidx.compose.runtime.Composer r42, final int r43) {
        /*
            Method dump skipped, instruction units count: 629
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.intro.stats.StatsExplanation2ScreenKt.i(java.lang.String, java.lang.String, java.lang.String, float, androidx.compose.runtime.Composer, int):void");
    }

    private static final Dp j(MutableState mutableState) {
        return (Dp) mutableState.getValue();
    }

    private static final boolean k(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final void l(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(MutableState mutableState, Dp dp) {
        l(mutableState, true);
        return Unit.f139807a;
    }

    private static final float n(State state) {
        return ((Dp) state.getValue()).l();
    }

    private static final float o(State state) {
        return ((Dp) state.getValue()).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(final Density density, final float f3, String str, State state, final MutableState mutableState, final float f4, final MutableState mutableState2, final MutableState mutableState3, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1108131214, i3, -1, "cz.mobilesoft.coreblock.scene.intro.stats.BarRow.<anonymous> (StatsExplanation2Screen.kt:153)");
            }
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Vertical verticalI = companion.i();
            Arrangement.HorizontalOrVertical horizontalOrVerticalE = Arrangement.f6574a.e();
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion2, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalE, verticalI, composer, 54);
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
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion.h(), false);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, companion2);
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
            Updater.e(composerA2, measurePolicyG, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            SurfaceKt.a(SizeKt.C(companion2, n(state), 0.0f, 2, null), RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(R.dimen.f95480n, composer, 0)), 0L, 0L, null, 0.0f, ComposableSingletons$StatsExplanation2ScreenKt.f104906a.e(), composer, 1572864, 60);
            TextStyle textStyleG = ComposeTypographyKt.g(composer, 0).g();
            long jL = Color.f25715b.l();
            float f5 = 16;
            Modifier modifierK = PaddingKt.k(companion2, Dp.g(f5), 0.0f, 2, null);
            boolean Z = composer.Z(density);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.stats.x
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StatsExplanation2ScreenKt.q(density, mutableState, (LayoutCoordinates) obj);
                    }
                };
                composer.w(objG);
            }
            TextKt.c(str, OnGloballyPositionedModifierKt.a(modifierK, (Function1) objG), jL, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleG, composer, 384, 0, 65528);
            composer.y();
            String strB = StringResources_androidKt.b(R.string.zH, composer, 0);
            TextStyle textStyleD = ComposeTypographyKt.g(composer, 0).d();
            long jO = ComposeColorsKt.j(composer, 0).O();
            Modifier modifierK2 = PaddingKt.k(companion2, Dp.g(f5), 0.0f, 2, null);
            boolean Z2 = composer.Z(density) | composer.c(f3);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.stats.y
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StatsExplanation2ScreenKt.r(density, f4, f3, mutableState2, mutableState3, (LayoutCoordinates) obj);
                    }
                };
                composer.w(function1);
                objG2 = function1;
            }
            TextKt.c(strB, OnGloballyPositionedModifierKt.a(modifierK2, (Function1) objG2), jO, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleD, composer, 0, 0, 65528);
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
    public static final Unit q(Density density, MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        u(mutableState, Dp.d(density.F((int) (it.a() >> 32))));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(Density density, float f3, float f4, MutableState mutableState, MutableState mutableState2, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        float fG = density.G(Float.intBitsToFloat((int) (LayoutCoordinatesKt.e(it) >> 32)));
        if (!Dp.i(fG, Dp.g(0))) {
            if (v(mutableState) == null) {
                w(mutableState, Dp.d(Dp.g(f3 * fG)));
            }
            if (x(mutableState2) == null) {
                y(mutableState2, Dp.d(Dp.g(fG * f4)));
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(String str, State state, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1062296027, i3, -1, "cz.mobilesoft.coreblock.scene.intro.stats.BarRow.<anonymous> (StatsExplanation2Screen.kt:222)");
            }
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Vertical verticalI = companion.i();
            Arrangement.HorizontalOrVertical horizontalOrVerticalE = Arrangement.f6574a.e();
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion2, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalE, verticalI, composer, 54);
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
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion.h(), false);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, companion2);
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
            Updater.e(composerA2, measurePolicyG, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            SurfaceKt.a(SizeKt.C(companion2, o(state), 0.0f, 2, null), RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(R.dimen.f95480n, composer, 0)), ComposeColorsKt.j(composer, 0).b(), 0L, null, 0.0f, ComposableSingletons$StatsExplanation2ScreenKt.f104906a.f(), composer, 1572864, 56);
            float f3 = 16;
            TextKt.c(str, PaddingKt.k(companion2, Dp.g(f3), 0.0f, 2, null), Color.f25715b.l(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 432, 0, 65528);
            composer.y();
            TextKt.c(StringResources_androidKt.c(R.string.oH, new Object[]{StringResources_androidKt.b(R.string.f95790f1, composer, 0)}, composer, 0), PaddingKt.k(companion2, Dp.g(f3), 0.0f, 2, null), ComposeColorsKt.j(composer, 0).O(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).d(), composer, 48, 0, 65528);
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
    public static final Unit t(String str, String str2, String str3, float f3, int i3, Composer composer, int i4) {
        i(str, str2, str3, f3, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void u(MutableState mutableState, Dp dp) {
        mutableState.setValue(dp);
    }

    private static final Dp v(MutableState mutableState) {
        return (Dp) mutableState.getValue();
    }

    private static final void w(MutableState mutableState, Dp dp) {
        mutableState.setValue(dp);
    }

    private static final Dp x(MutableState mutableState) {
        return (Dp) mutableState.getValue();
    }

    private static final void y(MutableState mutableState, Dp dp) {
        mutableState.setValue(dp);
    }

    public static final void z(final OnboardingViewState viewState, Function0 onContinueClicked, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onContinueClicked, "onContinueClicked");
        Composer composerK = composer.k(-1711657129);
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
                ComposerKt.U(-1711657129, i4, -1, "cz.mobilesoft.coreblock.scene.intro.stats.StatsExplanation2Screen (StatsExplanation2Screen.kt:58)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            final long jD = viewState.d();
            function0 = onContinueClicked;
            ExplanationScreenKt.e(StringResources_androidKt.b(R.string.rm, composerK, 0), StringResources_androidKt.b(R.string.qm, composerK, 0), null, function0, null, ComposableLambdaKt.e(551224050, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.stats.r
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StatsExplanation2ScreenKt.A(context, viewState, jD, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.stats.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StatsExplanation2ScreenKt.B(viewState, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
