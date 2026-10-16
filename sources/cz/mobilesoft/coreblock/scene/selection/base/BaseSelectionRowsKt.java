package cz.mobilesoft.coreblock.scene.selection.base;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.AndroidMenu_androidKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.RadioButtonKt;
import androidx.compose.material.Shapes;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
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
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.util.compose.ComposeThemesKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeTextFieldsKt;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParserException;

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
public final class BaseSelectionRowsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType keywordType, Function1 function1, final MutableState mutableState, ColumnScope DropdownMenu, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-147770826, i3, -1, "cz.mobilesoft.coreblock.scene.selection.base.KeywordTypeSelection.<anonymous>.<anonymous>.<anonymous> (BaseSelectionRows.kt:172)");
            }
            Modifier modifierK = PaddingKt.k(Modifier.b8, Dp.g(16), 0.0f, 2, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BaseSelectionRowsKt.B(mutableState);
                    }
                };
                composer.w(objG);
            }
            D(modifierK, keywordType, function1, (Function0) objG, composer, 3078, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(Modifier modifier, BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType keywordType, Function1 function1, int i3, int i4, Composer composer, int i5) {
        w(modifier, keywordType, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void D(Modifier modifier, final BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType keywordType, final Function1 onKeywordTypeChanged, final Function0 onItemClick, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        Composer composer2;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(keywordType, "keywordType");
        Intrinsics.checkNotNullParameter(onKeywordTypeChanged, "onKeywordTypeChanged");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Composer composerK = composer.k(-985369932);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.e(keywordType.ordinal()) ? 32 : 16;
        }
        int i7 = i3 & 384;
        int i8 = Function.MAX_NARGS;
        if (i7 == 0) {
            i5 |= composerK.I(onKeywordTypeChanged) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i9 = 2048;
        if ((i3 & 3072) == 0) {
            i5 |= composerK.I(onItemClick) ? 2048 : 1024;
        }
        int i10 = 0;
        int i11 = 1;
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            modifier3 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-985369932, i5, -1, "cz.mobilesoft.coreblock.scene.selection.base.KeywordTypeSelectionRadioMenu (BaseSelectionRows.kt:190)");
            }
            for (Iterator<BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType> it = BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType.getEntries().iterator(); it.hasNext(); it = it) {
                final BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType next = it.next();
                float f3 = 8;
                Modifier modifierK = PaddingKt.k(modifier3, 0.0f, Dp.g(f3), i11, null);
                int i12 = ((i5 & 896) == i8 ? i11 : i10) | ((i5 & 7168) == i9 ? i11 : i10) | (composerK.e(next.ordinal()) ? 1 : 0);
                Object objG = composerK.G();
                if (i12 != 0 || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.d
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BaseSelectionRowsKt.E(onItemClick, onKeywordTypeChanged, next);
                        }
                    };
                    composerK.w(objG);
                }
                Modifier modifierF = ClickableKt.f(modifierK, false, null, null, (Function0) objG, 7, null);
                MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composerK, 48);
                int iA = ComposablesKt.a(composerK, i10);
                CompositionLocalMap compositionLocalMapU = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierF);
                ComposeUiNode.Companion companion = ComposeUiNode.f8;
                Function0 function0A = companion.a();
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
                Updater.e(composerA, measurePolicyB, companion.e());
                Updater.e(composerA, compositionLocalMapU, companion.g());
                Function2 function2B = companion.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF2, companion.f());
                RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
                RadioButtonKt.a(keywordType == next, null, null, false, null, null, composerK, 48, 60);
                Composer composer3 = composerK;
                TextKt.c(StringResources_androidKt.b(next.getTitle(), composerK, 0), PaddingKt.k(Modifier.b8, Dp.g(f3), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, 0, null, MaterialTheme.f13091a.c(composerK, MaterialTheme.f13092b).a(), composer3, 48, 3072, 57340);
                composer3.y();
                i10 = 0;
                composerK = composer3;
                i5 = i5;
                i9 = 2048;
                i8 = 256;
                i11 = 1;
            }
            composer2 = composerK;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseSelectionRowsKt.F(modifier3, keywordType, onKeywordTypeChanged, onItemClick, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(Function0 function0, Function1 function1, BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType keywordType) {
        function0.invoke();
        function1.invoke(keywordType);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(Modifier modifier, BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType keywordType, Function1 function1, Function0 function0, int i3, int i4, Composer composer, int i5) {
        D(modifier, keywordType, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void o(Modifier modifier, final String title, final String value, final Function1 validate, final Function0 onAddButtonClicked, final Function1 onValueChanged, final WebsiteProfileRelation.BlockingType blockingType, final MutableInteractionSource interactionSource, final Function0 onImportClicked, Composer composer, final int i3, final int i4) {
        int i5;
        Composer composer2;
        final Modifier modifier2;
        Modifier modifier3;
        boolean z2;
        long jQ;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(validate, "validate");
        Intrinsics.checkNotNullParameter(onAddButtonClicked, "onAddButtonClicked");
        Intrinsics.checkNotNullParameter(onValueChanged, "onValueChanged");
        Intrinsics.checkNotNullParameter(blockingType, "blockingType");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onImportClicked, "onImportClicked");
        Composer composerK = composer.k(-571284321);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(title) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.Z(value) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.I(validate) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= composerK.I(onAddButtonClicked) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i5 |= composerK.I(onValueChanged) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i5 |= composerK.e(blockingType.ordinal()) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i5 |= composerK.Z(interactionSource) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            i5 |= composerK.I(onImportClicked) ? 67108864 : 33554432;
        }
        if (composerK.r((38347923 & i5) != 38347922, i5 & 1)) {
            Modifier modifier4 = i6 != 0 ? Modifier.b8 : modifier;
            if (ComposerKt.M()) {
                ComposerKt.U(-571284321, i5, -1, "cz.mobilesoft.coreblock.scene.selection.base.AddWebsiteRow (BaseSelectionRows.kt:59)");
            }
            final BaseSelectionViewState.ValidationResult validationResult = (BaseSelectionViewState.ValidationResult) validate.invoke(value);
            final State stateA = FocusInteractionKt.a(interactionSource, composerK, (i5 >> 21) & 14);
            Modifier modifier5 = modifier4;
            Modifier modifierH = SizeKt.h(PaddingKt.m(modifier4, 0.0f, 0.0f, Dp.g(8), 0.0f, 11, null), 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierH2 = SizeKt.h(companion2, 0.0f, 1, null);
            boolean z3 = validationResult instanceof BaseSelectionViewState.ValidationResult.Invalid;
            boolean z4 = z3 && Intrinsics.areEqual(((BaseSelectionViewState.ValidationResult.Invalid) validationResult).a(), BaseSelectionViewState.ValidationError.InputTooLong.f118391a);
            if (z3 && Intrinsics.areEqual(((BaseSelectionViewState.ValidationResult.Invalid) validationResult).a(), BaseSelectionViewState.ValidationError.InputTooLong.f118391a)) {
                modifier3 = modifierH2;
                z2 = true;
            } else {
                modifier3 = modifierH2;
                z2 = false;
            }
            KeyboardOptions keyboardOptionsD = KeyboardOptions.d(KeyboardOptions.f9764h.a(), 0, null, blockingType == WebsiteProfileRelation.BlockingType.DOMAIN ? KeyboardType.f29379b.j() : KeyboardType.f29379b.h(), ImeAction.f29348b.b(), null, null, null, 115, null);
            Modifier modifier6 = modifier3;
            boolean Z = composerK.Z(validationResult) | ((i5 & 57344) == 16384);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseSelectionRowsKt.q(validationResult, onAddButtonClicked, (KeyboardActionScope) obj);
                    }
                };
                composerK.w(objG);
            }
            KeyboardActions keyboardActions = new KeyboardActions((Function1) objG, null, null, null, null, null, 62, null);
            TextStyle textStyle = (TextStyle) composerK.q(TextKt.f());
            if (validationResult instanceof BaseSelectionViewState.ValidationResult.Valid) {
                composerK.a0(-431778034);
                jQ = ((TextStyle) composerK.q(TextKt.f())).j();
                composerK.U();
            } else {
                composerK.a0(-431777450);
                jQ = ComposeColorsKt.j(composerK, 0).q();
                composerK.U();
            }
            TextStyle textStyleE = TextStyle.e(textStyle, jQ, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
            boolean z5 = (i5 & 458752) == 131072;
            Object objG2 = composerK.G();
            if (z5 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseSelectionRowsKt.r(onValueChanged, (String) obj);
                    }
                };
                composerK.w(objG2);
            }
            ComposeTextFieldsKt.h(value, (Function1) objG2, modifier6, false, false, z4, textStyleE, null, ComposableLambdaKt.e(-1456083094, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseSelectionRowsKt.s(title, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, ComposableLambdaKt.e(-1067281991, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseSelectionRowsKt.t(validationResult, onImportClicked, stateA, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), z2, null, keyboardOptionsD, keyboardActions, true, 0, interactionSource, null, null, null, 0L, 0.0f, 0.0f, composerK, ((i5 >> 6) & 14) | 100663680, (29360128 & i5) | 196614, 0, 16585368);
            composer2 = composerK;
            if (z3 && Intrinsics.areEqual(((BaseSelectionViewState.ValidationResult.Invalid) validationResult).a(), BaseSelectionViewState.ValidationError.InputTooLong.f118391a)) {
                composer2.a0(-499000786);
                TextKt.c(StringResources_androidKt.c(R.string.Gj, new Object[]{240}, composer2, 0), PaddingKt.k(companion2, 0.0f, Dp.g(6), 1, null), ComposeColorsKt.j(composer2, 0).k(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composer2, MaterialTheme.f13092b).b(), composer2, 48, 0, 65528);
            } else {
                composer2.a0(-504808295);
            }
            composer2.U();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier2 = modifier5;
        } else {
            composer2 = composerK;
            composer2.Q();
            modifier2 = modifier;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseSelectionRowsKt.v(modifier2, title, value, validate, onAddButtonClicked, onValueChanged, blockingType, interactionSource, onImportClicked, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean p(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(BaseSelectionViewState.ValidationResult validationResult, Function0 function0, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        if (validationResult instanceof BaseSelectionViewState.ValidationResult.Valid) {
            function0.invoke();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(String str, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1456083094, i3, -1, "cz.mobilesoft.coreblock.scene.selection.base.AddWebsiteRow.<anonymous>.<anonymous> (BaseSelectionRows.kt:88)");
            }
            TextKt.c(str, null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composer, MaterialTheme.f13092b).a(), composer, 0, 0, 65530);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(BaseSelectionViewState.ValidationResult validationResult, final Function0 function0, State state, Composer composer, int i3) throws XmlPullParserException, IOException {
        Composer composer2 = composer;
        if (composer2.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1067281991, i3, -1, "cz.mobilesoft.coreblock.scene.selection.base.AddWebsiteRow.<anonymous>.<anonymous> (BaseSelectionRows.kt:101)");
            }
            if ((validationResult instanceof BaseSelectionViewState.ValidationResult.Invalid) && Intrinsics.areEqual(((BaseSelectionViewState.ValidationResult.Invalid) validationResult).a(), BaseSelectionViewState.ValidationError.InputTooLong.f118391a)) {
                composer2.a0(245293957);
                IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.M2, composer2, 6), null, null, ComposeColorsKt.j(composer2, 0).k(), composer2, 48, 4);
                composer2.U();
            } else {
                if (p(state)) {
                    composer2.a0(240334825);
                } else {
                    composer2.a0(245619054);
                    ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.J2, composer2, 6);
                    long jB = ComposeColorsKt.j(composer2, 0).b();
                    boolean Z = composer2.Z(function0);
                    Object objG = composer2.G();
                    if (Z || objG == Composer.f23746a.a()) {
                        objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.m
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return BaseSelectionRowsKt.u(function0);
                            }
                        };
                        composer2.w(objG);
                    }
                    ComposeButtonsKt.q0(null, imageVectorB, null, false, 0.0f, 0.0f, jB, null, (Function0) objG, composer, 0, 189);
                    composer2 = composer;
                }
                composer2.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Modifier modifier, String str, String str2, Function1 function1, Function0 function0, Function1 function12, WebsiteProfileRelation.BlockingType blockingType, MutableInteractionSource mutableInteractionSource, Function0 function02, int i3, int i4, Composer composer, int i5) {
        o(modifier, str, str2, function1, function0, function12, blockingType, mutableInteractionSource, function02, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void w(Modifier modifier, final BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType keywordType, final Function1 onKeywordTypeChanged, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(keywordType, "keywordType");
        Intrinsics.checkNotNullParameter(onKeywordTypeChanged, "onKeywordTypeChanged");
        Composer composerK = composer.k(-72646156);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.e(keywordType.ordinal()) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(onKeywordTypeChanged) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            Modifier modifier4 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-72646156, i5, -1, "cz.mobilesoft.coreblock.scene.selection.base.KeywordTypeSelection (BaseSelectionRows.kt:137)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            Modifier.Companion companion2 = Modifier.b8;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BaseSelectionRowsKt.x(mutableState);
                    }
                };
                composerK.w(objG2);
            }
            float f3 = 8;
            Modifier modifierK = PaddingKt.k(SizeKt.i(ClickableKt.f(companion2, false, null, null, (Function0) objG2, 7, null).then(modifier4), Dp.g(48)), Dp.g(f3), 0.0f, 2, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.c(), Alignment.f25072a.i(), composerK, 54);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierK);
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
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            String strB = StringResources_androidKt.b(keywordType.getTitle(), composerK, 0);
            MaterialTheme materialTheme = MaterialTheme.f13091a;
            int i7 = MaterialTheme.f13092b;
            Modifier modifier5 = modifier4;
            TextKt.c(strB, null, ComposeColorsKt.j(composerK, 0).P(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, 0, null, materialTheme.c(composerK, i7).a(), composerK, 0, 3072, 57338);
            composerK = composerK;
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95571v1, composerK, 6), null, PaddingKt.m(companion2, Dp.g(f3), 0.0f, 0.0f, 0.0f, 14, null), 0L, composerK, 432, 8);
            ComposeThemesKt.b(Shapes.b(materialTheme.b(composerK, i7), null, RoundedCornerShapeKt.d(Dp.g(f3)), null, 5, null), ComposableLambdaKt.e(165050121, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseSelectionRowsKt.y(mutableState, keywordType, onKeywordTypeChanged, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 48, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier3 = modifier5;
        } else {
            composerK.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseSelectionRowsKt.C(modifier3, keywordType, onKeywordTypeChanged, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(final MutableState mutableState, final BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType keywordType, final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(165050121, i3, -1, "cz.mobilesoft.coreblock.scene.selection.base.KeywordTypeSelection.<anonymous>.<anonymous> (BaseSelectionRows.kt:167)");
            }
            boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.n
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BaseSelectionRowsKt.z(mutableState);
                    }
                };
                composer.w(objG);
            }
            AndroidMenu_androidKt.a(zBooleanValue, (Function0) objG, BackgroundKt.d(Modifier.b8, ComposeColorsKt.j(composer, 0).X(), null, 2, null), 0L, null, null, ComposableLambdaKt.e(-147770826, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.selection.base.b
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BaseSelectionRowsKt.A(keywordType, function1, mutableState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1572912, 56);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }
}
