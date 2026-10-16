package cz.mobilesoft.coreblock.scene.more.signin;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.google.accompanist.systemuicontroller.SystemUiController;
import com.google.accompanist.systemuicontroller.SystemUiControllerKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.more.signin.SignInViewEvent;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeTextFieldsKt;
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
public final class NickNameScreenKt {
    public static final void i(final SignInViewState viewState, final Function1 onEvent, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(1445091623);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1445091623, i4, -1, "cz.mobilesoft.coreblock.scene.more.signin.NickNameScreen (NickNameScreen.kt:45)");
            }
            SystemUiController.b(SystemUiControllerKt.e(null, composerK, 0, 1), Color.f25715b.j(), false, null, 6, null);
            boolean Z = composerK.Z(viewState.l());
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(viewState.l(), null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            final SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) composerK.q(CompositionLocalsKt.q());
            Object objG2 = composerK.G();
            if (objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.g0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NickNameScreenKt.l();
                    }
                };
                composerK.w(objG2);
            }
            BackHandlerKt.a(false, (Function0) objG2, composerK, 48, 1);
            ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, ComposableLambdaKt.e(1512857397, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.signin.h0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NickNameScreenKt.m(viewState, softwareKeyboardController, onEvent, mutableState, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 12582912, 127);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.signin.i0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NickNameScreenKt.s(viewState, onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String j(MutableState mutableState) {
        return (String) mutableState.getValue();
    }

    private static final void k(MutableState mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(final SignInViewState signInViewState, final SoftwareKeyboardController softwareKeyboardController, final Function1 function1, final MutableState mutableState, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1512857397, i3, -1, "cz.mobilesoft.coreblock.scene.more.signin.NickNameScreen.<anonymous> (NickNameScreen.kt:57)");
            }
            ScaffoldKt.a(PaddingKt.m(SizeKt.f(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.c(WindowInsets.f7172a, composer, 6)), 0.0f, 1, null), 0.0f, Dp.g(48), 0.0f, Dp.g(16), 5, null), null, null, ComposableLambdaKt.e(-1733038417, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.signin.j0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NickNameScreenKt.n(signInViewState, softwareKeyboardController, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, Color.f25715b.j(), 0L, ComposableLambdaKt.e(-841056329, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.signin.k0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NickNameScreenKt.p(softwareKeyboardController, mutableState, function1, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
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
    public static final Unit n(SignInViewState signInViewState, final SoftwareKeyboardController softwareKeyboardController, final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1733038417, i3, -1, "cz.mobilesoft.coreblock.scene.more.signin.NickNameScreen.<anonymous>.<anonymous> (NickNameScreen.kt:64)");
            }
            String strB = StringResources_androidKt.b(R.string.l8, composer, 0);
            boolean z2 = signInViewState.l().length() > 0;
            boolean Z = composer.Z(softwareKeyboardController) | composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.f0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NickNameScreenKt.o(softwareKeyboardController, function1);
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
    public static final Unit o(SoftwareKeyboardController softwareKeyboardController, Function1 function1) {
        if (softwareKeyboardController != null) {
            softwareKeyboardController.a();
        }
        function1.invoke(SignInViewEvent.OnNickNameContinueClicked.f110426a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(final SoftwareKeyboardController softwareKeyboardController, final MutableState mutableState, final Function1 function1, PaddingValues it, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(it) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-841056329, i4, -1, "cz.mobilesoft.coreblock.scene.more.signin.NickNameScreen.<anonymous>.<anonymous> (NickNameScreen.kt:73)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierG = ScrollKt.g(PaddingKt.h(SizeKt.f(companion, 0.0f, 1, null), it), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierG);
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
            SpacerKt.a(SizeKt.i(companion, Dp.g(64)), composer, 6);
            String strB = StringResources_androidKt.b(R.string.Wv, composer, 0);
            TextStyle textStyleE = ComposeTypographyKt.g(composer, 0).e();
            TextAlign.Companion companion3 = TextAlign.f29616b;
            TextKt.c(strB, PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(32), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, textStyleE, composer, 48, 0, 65020);
            SpacerKt.a(SizeKt.i(companion, Dp.g(100)), composer, 6);
            String strJ = j(mutableState);
            TextStyle textStyleE2 = TextStyle.e(ComposeTypographyKt.g(composer, 0).f(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, companion3.a(), 0, 0L, null, null, null, 0, 0, null, 16744447, null);
            PaddingValues paddingValuesC = PaddingKt.c(Dp.g(22), 0.0f, 2, null);
            Modifier modifierK = PaddingKt.k(SizeKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(56)), Dp.g(16), 0.0f, 2, null);
            KeyboardOptions keyboardOptionsD = KeyboardOptions.d(KeyboardOptions.f9764h.a(), KeyboardCapitalization.f29372b.e(), null, 0, ImeAction.f29348b.b(), null, null, null, 118, null);
            boolean Z = composer.Z(softwareKeyboardController);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.d0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NickNameScreenKt.q(softwareKeyboardController, (KeyboardActionScope) obj);
                    }
                };
                composer.w(objG);
            }
            KeyboardActions keyboardActions = new KeyboardActions((Function1) objG, null, null, null, null, null, 62, null);
            boolean Z2 = composer.Z(mutableState) | composer.Z(function1);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.signin.e0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NickNameScreenKt.r(function1, mutableState, (String) obj);
                    }
                };
                composer.w(objG2);
            }
            ComposeTextFieldsKt.h(strJ, (Function1) objG2, modifierK, false, false, false, textStyleE2, null, ComposableSingletons$NickNameScreenKt.f110361a.b(), null, null, false, null, keyboardOptionsD, keyboardActions, true, 0, null, null, paddingValuesC, null, 0L, 0.0f, 0.0f, composer, 100663680, 805502976, 0, 16195256);
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
    public static final Unit q(SoftwareKeyboardController softwareKeyboardController, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        if (softwareKeyboardController != null) {
            softwareKeyboardController.a();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(Function1 function1, MutableState mutableState, String newValue) {
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        if (newValue.length() <= 250) {
            k(mutableState, newValue);
            function1.invoke(new SignInViewEvent.OnNicknameChanged(newValue));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(SignInViewState signInViewState, Function1 function1, int i3, Composer composer, int i4) {
        i(signInViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
