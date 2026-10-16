package cz.mobilesoft.coreblock.scene.intro.question;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.material.TextFieldColors;
import androidx.compose.material.TextFieldDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class OtherAnswerScreenKt {
    public static final void g(final Function1 function1, Composer composer, final int i3, final int i4) {
        int i5;
        Composer composerK = composer.k(2032177012);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.I(function1) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if (composerK.r((i5 & 3) != 2, i5 & 1)) {
            if (i6 != 0) {
                Object objG = composerK.G();
                if (objG == Composer.f23746a.a()) {
                    objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.question.w
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return OtherAnswerScreenKt.h((String) obj);
                        }
                    };
                    composerK.w(objG);
                }
                function1 = (Function1) objG;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(2032177012, i5, -1, "cz.mobilesoft.coreblock.scene.intro.question.OtherAnswerScreen (OtherAnswerScreen.kt:38)");
            }
            Object objG2 = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e("", null, 2, null);
                composerK.w(objG2);
            }
            final MutableState mutableState = (MutableState) objG2;
            String strB = StringResources_androidKt.b(R.string.Zq, composerK, 0);
            boolean z2 = (i5 & 14) == 4;
            Object objG3 = composerK.G();
            if (z2 || objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.question.x
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OtherAnswerScreenKt.k(function1, mutableState);
                    }
                };
                composerK.w(objG3);
            }
            ExplanationScreenKt.e(strB, null, null, (Function0) objG3, null, ComposableLambdaKt.e(-885742087, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.question.y
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OtherAnswerScreenKt.l(function1, mutableState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 196608, 22);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.question.z
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OtherAnswerScreenKt.o(function1, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    private static final String i(MutableState mutableState) {
        return (String) mutableState.getValue();
    }

    private static final void j(MutableState mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Function1 function1, MutableState mutableState) {
        function1.invoke(i(mutableState));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(final Function1 function1, final MutableState mutableState, ColumnScope ExplanationScreen, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(ExplanationScreen, "$this$ExplanationScreen");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-885742087, i3, -1, "cz.mobilesoft.coreblock.scene.intro.question.OtherAnswerScreen.<anonymous> (OtherAnswerScreen.kt:47)");
            }
            FocusRequester focusRequester = new FocusRequester();
            String strI = i(mutableState);
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.question.a0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OtherAnswerScreenKt.m(function1, mutableState, (KeyboardActionScope) obj);
                    }
                };
                composer.w(objG);
            }
            KeyboardActions keyboardActions = new KeyboardActions((Function1) objG, null, null, null, null, null, 62, null);
            TextStyle textStyleA = ComposeTypographyKt.g(composer, 0).a();
            PaddingValues paddingValuesC = PaddingKt.c(Dp.g(22), 0.0f, 2, null);
            RoundedCornerShape roundedCornerShapeD = RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(R.dimen.f95478l, composer, 0));
            TextFieldColors textFieldColorsO = TextFieldDefaults.f14636a.o(0L, 0L, ComposeColorsKt.j(composer, 0).l0(), 0L, 0L, ComposeColorsKt.j(composer, 0).b(), ComposeColorsKt.j(composer, 0).N(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 0, 0, 48, 2097051);
            Modifier modifierK = PaddingKt.k(SizeKt.i(FocusRequesterModifierKt.a(SizeKt.h(Modifier.b8, 0.0f, 1, null), focusRequester), Dp.g(56)), Dp.g(16), 0.0f, 2, null);
            Object objG2 = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.question.b0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OtherAnswerScreenKt.n(mutableState, (String) obj);
                    }
                };
                composer.w(objG2);
            }
            ComposeTextFieldsKt.h(strI, (Function1) objG2, modifierK, false, false, false, textStyleA, null, ComposableSingletons$OtherAnswerScreenKt.f104678a.d(), null, null, false, null, null, keyboardActions, true, 0, null, roundedCornerShapeD, paddingValuesC, textFieldColorsO, 0L, 0.0f, 0.0f, composer, 100859952, 805502976, 0, 14892696);
            Unit unit = Unit.f139807a;
            boolean Z2 = composer.Z(focusRequester);
            Object objG3 = composer.G();
            if (Z2 || objG3 == companion.a()) {
                objG3 = new OtherAnswerScreenKt$OtherAnswerScreen$3$3$1(focusRequester, null);
                composer.w(objG3);
            }
            EffectsKt.g(unit, (Function2) objG3, composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Function1 function1, MutableState mutableState, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        function1.invoke(i(mutableState));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        j(mutableState, it);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Function1 function1, int i3, int i4, Composer composer, int i5) {
        g(function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
