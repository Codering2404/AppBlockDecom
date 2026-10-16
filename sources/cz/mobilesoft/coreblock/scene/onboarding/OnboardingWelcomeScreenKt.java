package cz.mobilesoft.coreblock.scene.onboarding;

import android.content.Context;
import android.net.Uri;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.Dp;
import androidx.core.text.HtmlCompat;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.intro.question.Explanation2ScreenKt;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.ExternalLinksHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsV2Kt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class OnboardingWelcomeScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(MutableState mutableState, float f3) {
        mutableState.setValue(Dp.d(f3));
    }

    private static final void i(final ColumnScope columnScope, final Function0 function0, Composer composer, final int i3, final int i4) {
        int i5;
        Composer composerK = composer.k(-930127948);
        if ((i3 & 6) == 0) {
            i5 = (composerK.Z(columnScope) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.I(function0) ? 32 : 16;
        }
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            if (i6 != 0) {
                Object objG = composerK.G();
                if (objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.w2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return OnboardingWelcomeScreenKt.j();
                        }
                    };
                    composerK.w(objG);
                }
                function0 = (Function0) objG;
            }
            Function0 function02 = function0;
            if (ComposerKt.M()) {
                ComposerKt.U(-930127948, i5, -1, "cz.mobilesoft.coreblock.scene.onboarding.AlreadyAMemberButton (OnboardingWelcomeScreen.kt:244)");
            }
            ComposeButtonsV2Kt.d(columnScope.c(PaddingKt.k(Modifier.b8, 0.0f, Dp.g(16), 1, null), Alignment.f25072a.g()), StringResources_androidKt.b(R.string.G0, composerK, 0), function02, composerK, (i5 << 3) & 896, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            function0 = function02;
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.x2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingWelcomeScreenKt.k(columnScope, function0, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(ColumnScope columnScope, Function0 function0, int i3, int i4, Composer composer, int i5) {
        i(columnScope, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void l(boolean r22, boolean r23, final kotlin.jvm.functions.Function0 r24, kotlin.jvm.functions.Function0 r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 443
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.onboarding.OnboardingWelcomeScreenKt.l(boolean, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m() {
        return Unit.f139807a;
    }

    private static final float n(State state) {
        return ((Dp) state.getValue()).l();
    }

    private static final float o(State state) {
        return ((Dp) state.getValue()).l();
    }

    private static final float p(State state) {
        return ((Dp) state.getValue()).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(final boolean z2, final Function0 function0, final boolean z3, final Function0 function02, final State state, final State state2, final State state3, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-950039172, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingWelcomeScreen.<anonymous> (OnboardingWelcomeScreen.kt:120)");
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalE = Arrangement.f6574a.e();
            Modifier modifierM = PaddingKt.m(PaddingKt.k(ScrollKt.g(SizeKt.f(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.e(WindowInsets.f7172a, composer, 6)), 0.0f, 1, null), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null), PrimitiveResources_androidKt.a(R.dimen.f95486t, composer, 0), 0.0f, 2, null), 0.0f, Dp.g(48), 0.0f, 0.0f, 13, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalE, Alignment.f25072a.k(), composer, 6);
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
            final ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            final Context context = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
            CompositionLocalKt.b(CompositionLocalsKt.f().d(DensityKt.a(((Density) composer.q(CompositionLocalsKt.f())).getDensity(), 1.0f)), ComposableLambdaKt.e(-1782903502, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.t2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingWelcomeScreenKt.r(columnScopeInstance, z2, function0, z3, function02, state, state2, state3, context, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48 | ProvidedValue.f24012i);
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
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v7, types: [cz.mobilesoft.coreblock.scene.onboarding.OnboardingWelcomeScreenKt$OnboardingWelcomeScreen$3$1$1$uriHandler$1, java.lang.Object] */
    public static final Unit r(ColumnScope columnScope, boolean z2, Function0 function0, boolean z3, Function0 function02, State state, State state2, State state3, final Context context, Composer composer, int i3) {
        String str;
        String str2;
        Function0 function03;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1782903502, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingWelcomeScreen.<anonymous>.<anonymous>.<anonymous> (OnboardingWelcomeScreen.kt:138)");
            }
            String strB = StringResources_androidKt.b(R.string.NG, composer, 0);
            TextStyle textStyleA = ComposeTypographyKt.g(composer, 0).a();
            TextAlign.Companion companion = TextAlign.f29616b;
            int iA = companion.a();
            long jQ0 = ComposeColorsKt.j(composer, 0).q0();
            Modifier.Companion companion2 = Modifier.b8;
            TextKt.c(strB, SizeKt.h(PaddingKt.k(companion2, Dp.g(24), 0.0f, 2, null), 0.0f, 1, null), jQ0, 0L, null, null, null, 0L, null, TextAlign.h(iA), 0L, 0, false, 0, 0, null, textStyleA, composer, 48, 0, 65016);
            float f3 = 12;
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composer, 6);
            float f4 = 16;
            TextKt.c(StringResources_androidKt.b(R.string.Fm, composer, 0), PaddingKt.k(SizeKt.h(companion2, 0.0f, 1, null), Dp.g(f4), 0.0f, 2, null), ComposeColorsKt.j(composer, 0).q0(), 0L, null, null, null, 0L, null, TextAlign.h(companion.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).e(), composer, 48, 0, 65016);
            Modifier modifierB = ColumnScope.b(columnScope, companion2, 1.0f, false, 2, null);
            Alignment.Companion companion3 = Alignment.f25072a;
            Modifier modifierC = columnScope.c(modifierB, companion3.g());
            MeasurePolicy measurePolicyG = BoxKt.g(companion3.e(), false);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierC);
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
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA2))) {
                composerA.w(Integer.valueOf(iA2));
                composerA.p(Integer.valueOf(iA2), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            ImageVector.Companion companion5 = ImageVector.f26323k;
            ImageKt.b(VectorResources_androidKt.b(companion5, R.drawable.D0, composer, 6), null, null, null, ContentScale.f27054a.g(), 0.0f, null, composer, 24624, 108);
            Explanation2ScreenKt.c(n(state), Color.r(ComposeColorsKt.j(composer, 0).b(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), composer, 0);
            Explanation2ScreenKt.c(o(state2), Color.r(ComposeColorsKt.j(composer, 0).b(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), composer, 0);
            Explanation2ScreenKt.c(p(state3), ComposeColorsKt.j(composer, 0).b(), composer, 0);
            IconKt.b(VectorResources_androidKt.b(companion5, R.drawable.A0, composer, 6), null, SizeKt.v(companion2, Dp.g(74)), Color.f25715b.l(), composer, 3504, 0);
            composer.y();
            final ?? r7 = new UriHandler() { // from class: cz.mobilesoft.coreblock.scene.onboarding.OnboardingWelcomeScreenKt$OnboardingWelcomeScreen$3$1$1$uriHandler$1
                @Override // androidx.compose.ui.platform.UriHandler
                public void openUri(String uri) {
                    Intrinsics.checkNotNullParameter(uri, "uri");
                    ExternalLinksHelper externalLinksHelper = ExternalLinksHelper.f127866a;
                    Context context2 = context;
                    Uri uri2 = Uri.parse(uri);
                    Intrinsics.checkNotNullExpressionValue(uri2, "parse(...)");
                    externalLinksHelper.c(context2, uri2);
                }
            };
            if (((Boolean) composer.q(InspectionModeKt.a())).booleanValue()) {
                str2 = "";
                str = "";
            } else {
                PrefManager prefManager = PrefManager.f126839a;
                String strQ0 = prefManager.Q0();
                if (strQ0 == null) {
                    strQ0 = "https://appblock.app/privacy-policy-google-play";
                }
                String strT0 = prefManager.t0();
                if (strT0 == null) {
                    strT0 = "https://appblock.app/conditions-of-use";
                }
                String str3 = strQ0;
                str = strT0;
                str2 = str3;
            }
            final String string = HtmlCompat.a(StringResources_androidKt.c(R.string.uq, new Object[]{str2, str}, composer, 0), 63).toString();
            ComposeButtonsKt.i0(PaddingKt.k(companion2, Dp.g(f4), 0.0f, 2, null), new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.Si, composer, 0), 0.0f, 11, null), new ButtonColor.Accent(z2, null, false, null, 14, null), function0, composer, 6, 0);
            if (z3) {
                composer.a0(1385846500);
                if (z2) {
                    composer.a0(321801097);
                    composer.U();
                    function03 = function02;
                } else {
                    composer.a0(1385928526);
                    Object objG = composer.G();
                    if (objG == Composer.f23746a.a()) {
                        objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.u2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return OnboardingWelcomeScreenKt.s();
                            }
                        };
                        composer.w(objG);
                    }
                    function03 = (Function0) objG;
                    composer.U();
                }
                i(columnScope, function03, composer, 0, 0);
                composer.U();
            } else {
                composer.a0(1385959030);
                SpacerKt.a(SizeKt.i(companion2, Dp.g(f4)), composer, 6);
                composer.U();
            }
            CompositionLocalKt.b(CompositionLocalsKt.s().d(r7), ComposableLambdaKt.e(-2045615630, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.v2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingWelcomeScreenKt.t(string, r7, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.f24012i | 48);
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(String str, OnboardingWelcomeScreenKt$OnboardingWelcomeScreen$3$1$1$uriHandler$1 onboardingWelcomeScreenKt$OnboardingWelcomeScreen$3$1$1$uriHandler$1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2045615630, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingWelcomeScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OnboardingWelcomeScreen.kt:219)");
            }
            float f3 = 24;
            cz.mobilesoft.coreblock.view.TextKt.h(str, PaddingKt.m(SizeKt.h(Modifier.b8, 0.0f, 1, null), Dp.g(f3), 0.0f, Dp.g(f3), Dp.g(8), 2, null), ComposeTypographyKt.g(composer, 0).d(), ComposeColorsKt.j(composer, 0).O(), TextAlign.h(TextAlign.f29616b.a()), 0, null, null, new SpanStyle(ComposeColorsKt.j(composer, 0).b(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.f29625b.d(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61438, (DefaultConstructorMarker) null), onboardingWelcomeScreenKt$OnboardingWelcomeScreen$3$1$1$uriHandler$1, composer, 48, 224);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(boolean z2, boolean z3, Function0 function0, Function0 function02, int i3, int i4, Composer composer, int i5) {
        l(z2, z3, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final float v(MutableState mutableState) {
        return ((Dp) mutableState.getValue()).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(MutableState mutableState, float f3) {
        mutableState.setValue(Dp.d(f3));
    }

    private static final float x(MutableState mutableState) {
        return ((Dp) mutableState.getValue()).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(MutableState mutableState, float f3) {
        mutableState.setValue(Dp.d(f3));
    }

    private static final float z(MutableState mutableState) {
        return ((Dp) mutableState.getValue()).l();
    }
}
