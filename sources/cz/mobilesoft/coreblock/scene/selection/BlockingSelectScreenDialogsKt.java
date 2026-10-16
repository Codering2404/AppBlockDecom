package cz.mobilesoft.coreblock.scene.selection;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionRowsKt;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.util.compose.ComposeThemesKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeTextFieldsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class BlockingSelectScreenDialogsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(MutableState mutableState, TextFieldValue textFieldValue, boolean z2, FocusRequester focusRequester, Function0 function0, Function0 function02, Function1 function1, Function1 function12, int i3, int i4, Composer composer, int i5) {
        t(mutableState, textFieldValue, z2, focusRequester, function0, function02, function1, function12, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void B(final MutableState showDialog, final TextFieldValue dialogText, final FocusRequester focusRequester, final BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType keywordType, final Function0 onConfirmClick, final Function0 onDismissClick, final Function1 onValueChanged, final Function1 onKeywordTypeChanged, final WebsiteProfileRelation.BlockingType blockingType, final Function1 validate, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(showDialog, "showDialog");
        Intrinsics.checkNotNullParameter(dialogText, "dialogText");
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        Intrinsics.checkNotNullParameter(keywordType, "keywordType");
        Intrinsics.checkNotNullParameter(onConfirmClick, "onConfirmClick");
        Intrinsics.checkNotNullParameter(onDismissClick, "onDismissClick");
        Intrinsics.checkNotNullParameter(onValueChanged, "onValueChanged");
        Intrinsics.checkNotNullParameter(onKeywordTypeChanged, "onKeywordTypeChanged");
        Intrinsics.checkNotNullParameter(blockingType, "blockingType");
        Intrinsics.checkNotNullParameter(validate, "validate");
        Composer composerK = composer.k(-1912785703);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(showDialog) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(dialogText) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(focusRequester) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.e(keywordType.ordinal()) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(onConfirmClick) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(onDismissClick) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.I(onValueChanged) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i4 |= composerK.I(onKeywordTypeChanged) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            i4 |= composerK.e(blockingType.ordinal()) ? 67108864 : 33554432;
        }
        if ((805306368 & i3) == 0) {
            i4 |= composerK.I(validate) ? 536870912 : 268435456;
        }
        int i5 = i4;
        if (composerK.r((306783379 & i5) != 306783378, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1912785703, i5, -1, "cz.mobilesoft.coreblock.scene.selection.EditWebsiteKeywordConfirmDialog (BlockingSelectScreenDialogs.kt:47)");
            }
            final boolean zBooleanValue = ((Boolean) validate.invoke(dialogText.i())).booleanValue();
            ComposeDialogsKt.x0(showDialog, StringResources_androidKt.b(blockingType == WebsiteProfileRelation.BlockingType.DOMAIN ? R.string.Qc : R.string.Oc, composerK, 0), null, ComposableLambdaKt.e(-1995337601, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingSelectScreenDialogsKt.C(focusRequester, blockingType, zBooleanValue, onConfirmClick, showDialog, dialogText, onValueChanged, keywordType, onKeywordTypeChanged, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), StringResources_androidKt.b(R.string.Lt, composerK, 0), 0L, zBooleanValue, onConfirmClick, StringResources_androidKt.b(R.string.O4, composerK, 0), 0L, onDismissClick, composerK, (i5 & 14) | 3072 | ((i5 << 9) & 29360128), (i5 >> 15) & 14, 548);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingSelectScreenDialogsKt.G(showDialog, dialogText, focusRequester, keywordType, onConfirmClick, onDismissClick, onValueChanged, onKeywordTypeChanged, blockingType, validate, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(final FocusRequester focusRequester, final WebsiteProfileRelation.BlockingType blockingType, final boolean z2, final Function0 function0, final MutableState mutableState, final TextFieldValue textFieldValue, final Function1 function1, final BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType keywordType, final Function1 function12, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1995337601, i3, -1, "cz.mobilesoft.coreblock.scene.selection.EditWebsiteKeywordConfirmDialog.<anonymous> (BlockingSelectScreenDialogs.kt:59)");
            }
            ComposeThemesKt.b(null, ComposableLambdaKt.e(856833840, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingSelectScreenDialogsKt.D(focusRequester, blockingType, z2, function0, mutableState, textFieldValue, function1, keywordType, function12, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(FocusRequester focusRequester, WebsiteProfileRelation.BlockingType blockingType, final boolean z2, final Function0 function0, final MutableState mutableState, TextFieldValue textFieldValue, Function1 function1, BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType keywordType, Function1 function12, Composer composer, int i3) {
        long jM;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(856833840, i3, -1, "cz.mobilesoft.coreblock.scene.selection.EditWebsiteKeywordConfirmDialog.<anonymous>.<anonymous> (BlockingSelectScreenDialogs.kt:60)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
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
            Modifier modifierA = FocusRequesterModifierKt.a(SizeKt.h(companion, 0.0f, 1, null), focusRequester);
            KeyboardOptions keyboardOptionsD = KeyboardOptions.d(KeyboardOptions.f9764h.a(), 0, null, blockingType == WebsiteProfileRelation.BlockingType.DOMAIN ? KeyboardType.f29379b.j() : KeyboardType.f29379b.h(), ImeAction.f29348b.b(), null, null, null, 115, null);
            boolean zB = composer.b(z2) | composer.Z(function0) | composer.Z(mutableState);
            Object objG = composer.G();
            if (zB || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.k
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingSelectScreenDialogsKt.E(z2, function0, mutableState, (KeyboardActionScope) obj);
                    }
                };
                composer.w(objG);
            }
            KeyboardActions keyboardActions = new KeyboardActions((Function1) objG, null, null, null, null, null, 62, null);
            PaddingValues paddingValuesA = PaddingKt.a(Dp.g(0));
            TextStyle textStyle = (TextStyle) composer.q(TextKt.f());
            if (z2) {
                composer.a0(1422683743);
                jM = ((TextStyle) composer.q(TextKt.f())).j();
            } else {
                composer.a0(1422684326);
                jM = ComposeColorsKt.j(composer, 0).M();
            }
            composer.U();
            ComposeTextFieldsKt.g(textFieldValue, function1, modifierA, false, false, true, TextStyle.e(textStyle, jM, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), null, null, null, null, false, null, keyboardOptionsD, keyboardActions, true, 0, null, null, paddingValuesA, null, 0.0f, 0.0f, composer, 196608, 805502976, 0, 7806872);
            if (blockingType == WebsiteProfileRelation.BlockingType.KEYWORD) {
                composer.a0(1153714717);
                SpacerKt.a(SizeKt.i(companion, Dp.g(16)), composer, 6);
                Object objG2 = composer.G();
                if (objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.l
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BlockingSelectScreenDialogsKt.F();
                        }
                    };
                    composer.w(objG2);
                }
                BaseSelectionRowsKt.D(null, keywordType, function12, (Function0) objG2, composer, 3072, 1);
            } else {
                composer.a0(1149122408);
            }
            composer.U();
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
    public static final Unit E(boolean z2, Function0 function0, MutableState mutableState, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        if (z2) {
            function0.invoke();
            mutableState.setValue(Boolean.FALSE);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(MutableState mutableState, TextFieldValue textFieldValue, FocusRequester focusRequester, BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType keywordType, Function0 function0, Function0 function02, Function1 function1, Function1 function12, WebsiteProfileRelation.BlockingType blockingType, Function1 function13, int i3, Composer composer, int i4) {
        B(mutableState, textFieldValue, focusRequester, keywordType, function0, function02, function1, function12, blockingType, function13, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void H(final MutableState showDialog, final Function0 onConfirmClick, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(showDialog, "showDialog");
        Intrinsics.checkNotNullParameter(onConfirmClick, "onConfirmClick");
        Composer composerK = composer.k(-1789784688);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(showDialog) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onConfirmClick) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1789784688, i4, -1, "cz.mobilesoft.coreblock.scene.selection.MoodCheckInDisableDialog (BlockingSelectScreenDialogs.kt:202)");
            }
            ComposeDialogsKt.x0(showDialog, StringResources_androidKt.b(R.string.PE, composerK, 0), StringResources_androidKt.c(R.string.OE, new Object[]{StringResources_androidKt.b(R.string.uC, composerK, 0) + "/" + StringResources_androidKt.b(R.string.Ee, composerK, 0)}, composerK, 0), null, StringResources_androidKt.b(R.string.NE, composerK, 0), 0L, false, onConfirmClick, null, 0L, null, composerK, (i4 & 14) | ((i4 << 18) & 29360128), 0, 1896);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingSelectScreenDialogsKt.I(showDialog, onConfirmClick, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(MutableState mutableState, Function0 function0, int i3, Composer composer, int i4) {
        H(mutableState, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void o(final MutableState showDialog, final Function0 onConfirmClick, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(showDialog, "showDialog");
        Intrinsics.checkNotNullParameter(onConfirmClick, "onConfirmClick");
        Composer composerK = composer.k(-1786890081);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(showDialog) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onConfirmClick) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1786890081, i4, -1, "cz.mobilesoft.coreblock.scene.selection.ContainsAppBlockErrorDialog (BlockingSelectScreenDialogs.kt:186)");
            }
            int i5 = R.string.Dq;
            int i6 = R.string.f95790f1;
            ComposeDialogsKt.x0(showDialog, StringResources_androidKt.c(R.string.Fq, new Object[]{StringResources_androidKt.b(i6, composerK, 0)}, composerK, 0), StringHelper.h(StringResources_androidKt.c(i5, new Object[]{StringResources_androidKt.b(i6, composerK, 0)}, composerK, 0)).toString(), null, StringResources_androidKt.b(R.string.Eq, composerK, 0), 0L, false, onConfirmClick, null, 0L, null, composerK, (i4 & 14) | ((i4 << 18) & 29360128), 0, 1896);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingSelectScreenDialogsKt.p(showDialog, onConfirmClick, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(MutableState mutableState, Function0 function0, int i3, Composer composer, int i4) {
        o(mutableState, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void q(final MutableState showDialog, final WebsiteProfileRelation.BlockingType blockingType, final Function0 onConfirmClick, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(showDialog, "showDialog");
        Intrinsics.checkNotNullParameter(blockingType, "blockingType");
        Intrinsics.checkNotNullParameter(onConfirmClick, "onConfirmClick");
        Composer composerK = composer.k(111389197);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(showDialog) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.e(blockingType.ordinal()) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onConfirmClick) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(111389197, i4, -1, "cz.mobilesoft.coreblock.scene.selection.DeleteWebsiteConfirmDialog (BlockingSelectScreenDialogs.kt:170)");
            }
            String strB = StringResources_androidKt.b(blockingType == WebsiteProfileRelation.BlockingType.DOMAIN ? R.string.A9 : R.string.x9, composerK, 0);
            String strB2 = StringResources_androidKt.b(R.string.q9, composerK, 0);
            int i5 = i4 & 14;
            boolean z2 = i5 == 4;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlockingSelectScreenDialogsKt.r(showDialog);
                    }
                };
                composerK.w(objG);
            }
            ComposeDialogsKt.x0(showDialog, strB, null, null, strB2, 0L, false, onConfirmClick, null, 0L, (Function0) objG, composerK, i5 | ((i4 << 15) & 29360128), 0, 876);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingSelectScreenDialogsKt.s(showDialog, blockingType, onConfirmClick, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(MutableState mutableState, WebsiteProfileRelation.BlockingType blockingType, Function0 function0, int i3, Composer composer, int i4) {
        q(mutableState, blockingType, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void t(final androidx.compose.runtime.MutableState r18, final androidx.compose.ui.text.input.TextFieldValue r19, boolean r20, final androidx.compose.ui.focus.FocusRequester r21, final kotlin.jvm.functions.Function0 r22, final kotlin.jvm.functions.Function0 r23, final kotlin.jvm.functions.Function1 r24, final kotlin.jvm.functions.Function1 r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 421
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.BlockingSelectScreenDialogsKt.t(androidx.compose.runtime.MutableState, androidx.compose.ui.text.input.TextFieldValue, boolean, androidx.compose.ui.focus.FocusRequester, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final boolean u(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final void v(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(final FocusRequester focusRequester, final MutableState mutableState, final Function0 function0, final MutableState mutableState2, final TextFieldValue textFieldValue, final Function1 function1, final Function1 function12, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1824614784, i3, -1, "cz.mobilesoft.coreblock.scene.selection.EditRelationDialog.<anonymous> (BlockingSelectScreenDialogs.kt:130)");
            }
            ComposeThemesKt.b(null, ComposableLambdaKt.e(-667722447, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingSelectScreenDialogsKt.x(focusRequester, mutableState, function0, mutableState2, textFieldValue, function1, function12, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(FocusRequester focusRequester, final MutableState mutableState, final Function0 function0, final MutableState mutableState2, TextFieldValue textFieldValue, final Function1 function1, final Function1 function12, Composer composer, int i3) {
        long jM;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-667722447, i3, -1, "cz.mobilesoft.coreblock.scene.selection.EditRelationDialog.<anonymous>.<anonymous> (BlockingSelectScreenDialogs.kt:131)");
            }
            Modifier modifierA = FocusRequesterModifierKt.a(SizeKt.h(Modifier.b8, 0.0f, 1, null), focusRequester);
            KeyboardOptions keyboardOptionsD = KeyboardOptions.d(KeyboardOptions.f9764h.a(), 0, null, KeyboardType.f29379b.j(), ImeAction.f29348b.b(), null, null, null, 115, null);
            boolean Z = composer.Z(mutableState) | composer.Z(function0) | composer.Z(mutableState2);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingSelectScreenDialogsKt.y(function0, mutableState2, mutableState, (KeyboardActionScope) obj);
                    }
                };
                composer.w(objG);
            }
            KeyboardActions keyboardActions = new KeyboardActions((Function1) objG, null, null, null, null, null, 62, null);
            PaddingValues paddingValuesA = PaddingKt.a(Dp.g(0));
            TextStyle textStyle = (TextStyle) composer.q(TextKt.f());
            if (u(mutableState)) {
                composer.a0(-1731099018);
                jM = ((TextStyle) composer.q(TextKt.f())).j();
            } else {
                composer.a0(-1731098435);
                jM = ComposeColorsKt.j(composer, 0).M();
            }
            composer.U();
            TextStyle textStyleE = TextStyle.e(textStyle, jM, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
            boolean Z2 = composer.Z(function1) | composer.Z(mutableState) | composer.Z(function12);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockingSelectScreenDialogsKt.z(function1, function12, mutableState, (TextFieldValue) obj);
                    }
                };
                composer.w(objG2);
            }
            ComposeTextFieldsKt.g(textFieldValue, (Function1) objG2, modifierA, false, false, true, textStyleE, null, null, null, null, false, null, keyboardOptionsD, keyboardActions, true, 0, null, null, paddingValuesA, null, 0.0f, 0.0f, composer, 196608, 805502976, 0, 7806872);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(Function0 function0, MutableState mutableState, MutableState mutableState2, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        if (u(mutableState2)) {
            function0.invoke();
            mutableState.setValue(Boolean.FALSE);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Function1 function1, Function1 function12, MutableState mutableState, TextFieldValue it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        v(mutableState, ((Boolean) function12.invoke(it.i())).booleanValue());
        return Unit.f139807a;
    }
}
