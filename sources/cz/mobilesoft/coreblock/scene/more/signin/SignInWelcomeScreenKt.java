package cz.mobilesoft.coreblock.scene.more.signin;

import android.content.Context;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import com.google.accompanist.systemuicontroller.SystemUiController;
import com.google.accompanist.systemuicontroller.SystemUiControllerKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.intro.question.Explanation2ScreenKt;
import cz.mobilesoft.coreblock.scene.more.signin.SignInViewEvent;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsV2Kt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class SignInWelcomeScreenKt {
    public static final void f(final String nickName, final boolean z2, final Function1 onEvent, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(-860175628);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(nickName) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onEvent) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-860175628, i4, -1, "cz.mobilesoft.coreblock.scene.more.signin.SignInWelcomeScreen (SignInWelcomeScreen.kt:70)");
            }
            SystemUiController.b(SystemUiControllerKt.e(null, composerK, 0, 1), Color.f25715b.j(), false, null, 6, null);
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Dp.d(Dp.g(140)), null, 2, null);
                composerK.w(objG);
            }
            MutableState mutableState = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Dp.d(Dp.g(140)), null, 2, null);
                composerK.w(objG2);
            }
            MutableState mutableState2 = (MutableState) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(Dp.d(Dp.g(140)), null, 2, null);
                composerK.w(objG3);
            }
            MutableState mutableState3 = (MutableState) objG3;
            TweenSpec tweenSpecN = AnimationSpecKt.n(1000, 0, EasingKt.d(), 2, null);
            final State stateC = AnimateAsStateKt.c(g(mutableState), tweenSpecN, null, null, composerK, 0, 12);
            final State stateC2 = AnimateAsStateKt.c(p(mutableState2), tweenSpecN, null, null, composerK, 0, 12);
            final State stateC3 = AnimateAsStateKt.c(r(mutableState3), tweenSpecN, null, null, composerK, 0, 12);
            Unit unit = Unit.f139807a;
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = new SignInWelcomeScreenKt$SignInWelcomeScreen$1$1(mutableState, mutableState2, mutableState3, null);
                composerK.w(objG4);
            }
            EffectsKt.g(unit, (Function2) objG4, composerK, 6);
            Object objG5 = composerK.G();
            if (objG5 == companion.a()) {
                objG5 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.y3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SignInWelcomeScreenKt.j();
                    }
                };
                composerK.w(objG5);
            }
            BackHandlerKt.a(false, (Function0) objG5, composerK, 48, 1);
            ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, ComposableLambdaKt.e(-929321818, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.signin.z3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SignInWelcomeScreenKt.k(nickName, onEvent, context, z2, stateC, stateC2, stateC3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.signin.a4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SignInWelcomeScreenKt.n(nickName, z2, onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float g(MutableState mutableState) {
        return ((Dp) mutableState.getValue()).l();
    }

    private static final float h(State state) {
        return ((Dp) state.getValue()).l();
    }

    private static final float i(State state) {
        return ((Dp) state.getValue()).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(String str, final Function1 function1, final Context context, boolean z2, State state, State state2, State state3, BoxScope GradientBox, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(GradientBox) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-929321818, i4, -1, "cz.mobilesoft.coreblock.scene.more.signin.SignInWelcomeScreen.<anonymous> (SignInWelcomeScreen.kt:108)");
            }
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion.g();
            Modifier.Companion companion2 = Modifier.b8;
            WindowInsets.Companion companion3 = WindowInsets.f7172a;
            float f3 = 32;
            float f4 = 16;
            Modifier modifierG = ScrollKt.g(PaddingKt.m(GradientBox.f(SizeKt.f(WindowInsetsPaddingKt.d(companion2, WindowInsets_androidKt.e(companion3, composer, 6)), 0.0f, 1, null), companion.m()), 0.0f, Dp.g(f3), 0.0f, Dp.g(f4), 5, null), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), horizontalG, composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierG);
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
            Updater.e(composerA, measurePolicyA, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            SpacerKt.a(SizeKt.i(companion2, Dp.g(64)), composer, 6);
            String strC = StringResources_androidKt.c(R.string.OG, new Object[]{str}, composer, 0);
            int iN0 = StringsKt.n0(strC, str, 0, false, 6, null);
            composer.a0(2069144110);
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
            String strSubstring = strC.substring(0, iN0);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            builder.l(strSubstring);
            int iS = builder.s(new SpanStyle(ComposeColorsKt.j(composer, 0).b(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null));
            try {
                builder.l(str);
                Unit unit = Unit.f139807a;
                builder.q(iS);
                String strSubstring2 = strC.substring(iN0 + str.length());
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                builder.l(strSubstring2);
                AnnotatedString annotatedStringT = builder.t();
                composer.U();
                TextKt.d(annotatedStringT, PaddingKt.k(SizeKt.h(companion2, 0.0f, 1, null), Dp.g(f3), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, null, ComposeTypographyKt.g(composer, 0).e(), composer, 48, 0, 130556);
                SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composer, 6);
                Modifier modifierC = columnScopeInstance.c(companion2, companion.g());
                MeasurePolicy measurePolicyG = BoxKt.g(companion.e(), false);
                int iA2 = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU2 = composer.u();
                Modifier modifierF2 = ComposedModifierKt.f(composer, modifierC);
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
                Updater.e(composerA2, measurePolicyG, companion4.e());
                Updater.e(composerA2, compositionLocalMapU2, companion4.g());
                Function2 function2B2 = companion4.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion4.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                ImageKt.a(PainterResources_androidKt.c(R.drawable.D0, composer, 0), null, null, null, ContentScale.f27054a.g(), 0.0f, null, composer, 24624, 108);
                Explanation2ScreenKt.c(t(state), Color.r(ComposeColorsKt.j(composer, 0).b(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null), composer, 0);
                Explanation2ScreenKt.c(h(state2), Color.r(ComposeColorsKt.j(composer, 0).b(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), composer, 0);
                Explanation2ScreenKt.c(i(state3), ComposeColorsKt.j(composer, 0).b(), composer, 0);
                IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.A0, composer, 6), null, SizeKt.v(companion2, Dp.g(74)), Color.f25715b.l(), composer, 3504, 0);
                composer.y();
                SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 1.0f, false, 2, null), composer, 0);
                String strB = StringResources_androidKt.b(R.string.l8, composer, 0);
                boolean Z = composer.Z(function1) | composer.I(context);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.b4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SignInWelcomeScreenKt.l(function1, context);
                        }
                    };
                    composer.w(objG);
                }
                ComposeButtonsKt.J(null, strB, false, false, null, (Function0) objG, composer, 0, 29);
                if (z2) {
                    composer.a0(-279079635);
                    Modifier modifierD = WindowInsetsPaddingKt.d(columnScopeInstance.c(PaddingKt.k(companion2, 0.0f, Dp.g(f4), 1, null), companion.g()), WindowInsets_androidKt.b(companion3, composer, 6));
                    String strB2 = StringResources_androidKt.b(R.string.xx, composer, 0);
                    boolean Z2 = composer.Z(function1);
                    Object objG2 = composer.G();
                    if (Z2 || objG2 == Composer.f23746a.a()) {
                        objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.c4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SignInWelcomeScreenKt.m(function1);
                            }
                        };
                        composer.w(objG2);
                    }
                    ComposeButtonsV2Kt.d(modifierD, strB2, (Function0) objG2, composer, 0, 0);
                } else {
                    composer.a0(-285535354);
                }
                composer.U();
                composer.y();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            } catch (Throwable th) {
                builder.q(iS);
                throw th;
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Function1 function1, Context context) {
        function1.invoke(new SignInViewEvent.OnSignInWelcomeContinueClicked(context));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Function1 function1) {
        function1.invoke(SignInViewEvent.OnSignInWelcomeSkipClicked.f110433a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(String str, boolean z2, Function1 function1, int i3, Composer composer, int i4) {
        f(str, z2, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(MutableState mutableState, float f3) {
        mutableState.setValue(Dp.d(f3));
    }

    private static final float p(MutableState mutableState) {
        return ((Dp) mutableState.getValue()).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(MutableState mutableState, float f3) {
        mutableState.setValue(Dp.d(f3));
    }

    private static final float r(MutableState mutableState) {
        return ((Dp) mutableState.getValue()).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(MutableState mutableState, float f3) {
        mutableState.setValue(Dp.d(f3));
    }

    private static final float t(State state) {
        return ((Dp) state.getValue()).l();
    }
}
