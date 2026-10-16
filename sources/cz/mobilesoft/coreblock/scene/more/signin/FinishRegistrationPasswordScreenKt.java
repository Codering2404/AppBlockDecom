package cz.mobilesoft.coreblock.scene.more.signin;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.TextFieldColors;
import androidx.compose.material.TextFieldDefaults;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
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
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.more.signin.SignInViewEvent;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
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
public final class FinishRegistrationPasswordScreenKt {
    public static final void l(final Function1 onEvent, final SignInViewState viewState, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Composer composerK = composer.k(805388103);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onEvent) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(viewState) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(805388103, i4, -1, "cz.mobilesoft.coreblock.scene.more.signin.FinishRegistrationPasswordScreen (FinishRegistrationPasswordScreen.kt:61)");
            }
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinishRegistrationPasswordScreenKt.m();
                    }
                };
                composerK.w(objG);
            }
            BackHandlerKt.a(false, (Function0) objG, composerK, 48, 1);
            if (Intrinsics.areEqual(viewState.s(), Loading.f127895a)) {
                composerK.a0(1629853033);
                Modifier.Companion companion = Modifier.b8;
                Modifier modifierF = SizeKt.f(companion, 0.0f, 1, null);
                Alignment.Companion companion2 = Alignment.f25072a;
                MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
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
                Updater.e(composerA, measurePolicyG, companion3.e());
                Updater.e(composerA, compositionLocalMapU, companion3.g());
                Function2 function2B = companion3.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF2, companion3.f());
                composer2 = composerK;
                ProgressIndicatorKt.b(BoxScopeInstance.f6642a.f(PaddingKt.i(companion, Dp.g(8)), companion2.e()), ComposeColorsKt.j(composerK, 0).b(), Dp.g(4), 0L, StrokeCap.f25935b.b(), composer2, 384, 8);
                composer2.y();
                composer2.U();
            } else {
                composerK.a0(1630505335);
                ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, ComposableLambdaKt.e(-352238604, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.signin.p
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return FinishRegistrationPasswordScreenKt.n(viewState, onEvent, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerK, 54), composerK, 12582912, 127);
                composer2 = composerK;
                composer2.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.signin.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FinishRegistrationPasswordScreenKt.u(onEvent, viewState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(final SignInViewState signInViewState, final Function1 function1, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-352238604, i3, -1, "cz.mobilesoft.coreblock.scene.more.signin.FinishRegistrationPasswordScreen.<anonymous> (FinishRegistrationPasswordScreen.kt:82)");
            }
            ScaffoldKt.a(SizeKt.f(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.c(WindowInsets.f7172a, composer, 6)), 0.0f, 1, null), null, null, ComposableLambdaKt.e(215797230, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.signin.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FinishRegistrationPasswordScreenKt.o(signInViewState, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, Color.f25715b.j(), 0L, ComposableLambdaKt.e(-1543319306, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.signin.i
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return FinishRegistrationPasswordScreenKt.q(signInViewState, function1, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 3072, 12779520, 98294);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(SignInViewState signInViewState, final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(215797230, i3, -1, "cz.mobilesoft.coreblock.scene.more.signin.FinishRegistrationPasswordScreen.<anonymous>.<anonymous> (FinishRegistrationPasswordScreen.kt:88)");
            }
            String strB = StringResources_androidKt.b(R.string.l8, composer, 0);
            boolean z2 = (StringsKt.p0(signInViewState.m()) || signInViewState.n()) ? false : true;
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinishRegistrationPasswordScreenKt.p(function1);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.J(null, strB, z2, false, null, (Function0) objG, composer, 0, 25);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Function1 function1) {
        function1.invoke(SignInViewEvent.OnSignUpClicked.f110434a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(SignInViewState signInViewState, final Function1 function1, PaddingValues paddingValues, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(paddingValues) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1543319306, i4, -1, "cz.mobilesoft.coreblock.scene.more.signin.FinishRegistrationPasswordScreen.<anonymous>.<anonymous> (FinishRegistrationPasswordScreen.kt:96)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierD = BackgroundKt.d(ScrollKt.g(PaddingKt.h(SizeKt.f(companion, 0.0f, 1, null), paddingValues), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null), Color.f25715b.j(), null, 2, null);
            Arrangement.Vertical verticalH = Arrangement.f6574a.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierD);
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
            float f3 = 32;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            final String strB = StringResources_androidKt.b(R.string.oe, composer, 0);
            String strB2 = StringResources_androidKt.b(R.string.f95865z1, composer, 0);
            String strB3 = StringResources_androidKt.b(R.string.f95790f1, composer, 0);
            composer.a0(1417976450);
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
            Regex.Companion companion4 = Regex.f140573b;
            String strC = companion4.c(strB2);
            RegexOption regexOption = RegexOption.f140589c;
            Sequence sequenceM = SequencesKt.m(new Regex(strC, regexOption), new Regex(companion4.c(strB3) + "\\s+\\S+", regexOption), new Regex("\\S+\\s+" + companion4.c(strB3), regexOption), new Regex(companion4.c(strB3), regexOption));
            boolean Z = composer.Z(strB);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FinishRegistrationPasswordScreenKt.r(strB, (Regex) obj);
                    }
                };
                composer.w(objG);
            }
            IntRange intRange = (IntRange) SequencesKt.E(SequencesKt.N(sequenceM, (Function1) objG));
            if (intRange != null) {
                composer.a0(173161111);
                builder.l(StringsKt.B1(strB, intRange.g()));
                int iS = builder.s(new SpanStyle(ComposeColorsKt.j(composer, 0).b(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null));
                try {
                    String strSubstring = strB.substring(intRange.g(), intRange.h() + 1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    builder.l(strSubstring);
                    Unit unit = Unit.f139807a;
                    builder.q(iS);
                    String strSubstring2 = strB.substring(intRange.h() + 1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                    builder.l(strSubstring2);
                    composer.U();
                } catch (Throwable th) {
                    builder.q(iS);
                    throw th;
                }
            } else {
                composer.a0(173623662);
                composer.U();
                builder.l(strB);
            }
            AnnotatedString annotatedStringT = builder.t();
            composer.U();
            TextStyle textStyleE = ComposeTypographyKt.g(composer, 0).e();
            TextAlign.Companion companion5 = TextAlign.f29616b;
            TextKt.d(annotatedStringT, PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion5.a()), 0L, 0, false, 0, 0, null, null, textStyleE, composer, 48, 0, 130556);
            SpacerKt.a(SizeKt.i(companion, Dp.g(12)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.K8, composer, 0), PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3), 0.0f, 2, null), ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion5.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 48, 0, 65016);
            TextKt.c(StringResources_androidKt.c(R.string.EH, new Object[]{signInViewState.d()}, composer, 0), PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3), 0.0f, 2, null), ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion5.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 48, 0, 65016);
            Composer composer2 = composer;
            SpacerKt.a(SizeKt.i(companion, Dp.g(24)), composer2, 6);
            v(signInViewState.d(), composer2, 0);
            String strM = signInViewState.m();
            boolean Z2 = composer2.Z(function1);
            Object objG2 = composer2.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.k
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FinishRegistrationPasswordScreenKt.s(function1, (String) obj);
                    }
                };
                composer2.w(objG2);
            }
            Function1 function12 = (Function1) objG2;
            int i5 = R.string.vn;
            boolean zN = signInViewState.n();
            int i6 = R.drawable.v3;
            boolean Z3 = composer2.Z(function1);
            Object objG3 = composer2.G();
            if (Z3 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FinishRegistrationPasswordScreenKt.t(function1);
                    }
                };
                composer2.w(objG3);
            }
            SignInUpWithEmailScreenKt.J(false, strM, function12, i5, zN, i6, true, (Function0) objG3, composer2, 1572870, 0);
            if (signInViewState.n()) {
                composer2.a0(1011407326);
                TextKt.c(StringResources_androidKt.c(R.string.Bd, new Object[]{8}, composer2, 0), columnScopeInstance.c(PaddingKt.m(companion, 0.0f, 0.0f, Dp.g(16), 0.0f, 11, null), companion2.j()), ComposeColorsKt.j(composer2, 0).k(), 0L, null, null, null, 0L, null, TextAlign.h(companion5.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).d(), composer, 0, 0, 65016);
                composer2 = composer;
            } else {
                composer2.a0(1002984130);
            }
            composer2.U();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntRange r(String str, Regex it) {
        Intrinsics.checkNotNullParameter(it, "it");
        MatchResult matchResultE = Regex.e(it, str, 0, 2, null);
        if (matchResultE != null) {
            return matchResultE.c();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new SignInViewEvent.OnPasswordChanged(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(Function1 function1) {
        function1.invoke(SignInViewEvent.OnSignUpClicked.f110434a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Function1 function1, SignInViewState signInViewState, int i3, Composer composer, int i4) {
        l(function1, signInViewState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void v(final String str, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-14619444);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(str) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-14619444, i4, -1, "cz.mobilesoft.coreblock.scene.more.signin.FixedEmailField (FinishRegistrationPasswordScreen.kt:194)");
            }
            float f3 = 16;
            Modifier modifierH = SizeKt.h(BackgroundKt.c(PaddingKt.j(Modifier.b8, Dp.g(f3), Dp.g(8)), ComposeColorsKt.j(composerK, 0).l0(), RoundedCornerShapeKt.d(Dp.g(f3))), 0.0f, 1, null);
            RoundedCornerShape roundedCornerShapeD = RoundedCornerShapeKt.d(Dp.g(f3));
            TextStyle textStyleE = TextStyle.e(ComposeTypographyKt.g(composerK, 0).a(), ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
            TextFieldDefaults textFieldDefaults = TextFieldDefaults.f14636a;
            long jP = ComposeColorsKt.j(composerK, 0).p();
            long jL0 = ComposeColorsKt.j(composerK, 0).l0();
            long jQ = ComposeColorsKt.j(composerK, 0).q();
            long jS = ComposeColorsKt.j(composerK, 0).s();
            long jQ2 = ComposeColorsKt.j(composerK, 0).q();
            Color.Companion companion = Color.f25715b;
            int i5 = i4;
            TextFieldColors textFieldColorsO = textFieldDefaults.o(jP, jQ, jL0, 0L, 0L, companion.j(), companion.j(), companion.j(), 0L, 0L, jS, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, jQ2, composerK, 14352384, 0, 48, 1047320);
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FinishRegistrationPasswordScreenKt.w((String) obj);
                    }
                };
                composerK.w(objG);
            }
            ComposableSingletons$FinishRegistrationPasswordScreenKt composableSingletons$FinishRegistrationPasswordScreenKt = ComposableSingletons$FinishRegistrationPasswordScreenKt.f110358a;
            composer2 = composerK;
            OutlinedTextFieldKt.c(str, (Function1) objG, modifierH, false, true, textStyleE, null, composableSingletons$FinishRegistrationPasswordScreenKt.c(), composableSingletons$FinishRegistrationPasswordScreenKt.d(), null, false, null, null, null, true, 1, 0, null, roundedCornerShapeD, textFieldColorsO, composer2, (i5 & 14) | 113273904, 221184, 212544);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.signin.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FinishRegistrationPasswordScreenKt.x(str, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(String str, int i3, Composer composer, int i4) {
        v(str, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
