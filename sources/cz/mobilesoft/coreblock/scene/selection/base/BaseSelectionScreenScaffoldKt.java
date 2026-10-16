package cz.mobilesoft.coreblock.scene.selection.base;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.AppBarKt;
import androidx.compose.material.DividerKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SurfaceKt;
import androidx.compose.material.TabKt;
import androidx.compose.material.TabRowKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewEvent;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState;
import cz.mobilesoft.coreblock.scene.selection.components.TabItem;
import cz.mobilesoft.coreblock.scene.selection.hint.KeywordsLearnMoreActivity;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ComposeTextFieldsKt;
import cz.mobilesoft.coreblock.view.compose.LazyListKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
public final class BaseSelectionScreenScaffoldKt {
    private static final void F(final TabItem tabItem, final BaseSelectionViewState.WebsiteKeywordsViewState websiteKeywordsViewState, final Function1 function1, final String str, final Function1 function12, final FocusManager focusManager, Composer composer, final int i3) {
        int i4;
        String str2;
        Composer composerK = composer.k(2015084001);
        if ((i3 & 6) == 0) {
            i4 = (composerK.e(tabItem.ordinal()) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(websiteKeywordsViewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            str2 = str;
            i4 |= composerK.Z(str2) ? 2048 : 1024;
        } else {
            str2 = str;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function12) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((i3 & 196608) == 0) {
            i4 |= composerK.I(focusManager) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if (composerK.r((74899 & i4) != 74898, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2015084001, i4, -1, "cz.mobilesoft.coreblock.scene.selection.base.AddKeywordWebsiteRow (BaseSelectionScreenScaffold.kt:387)");
            }
            if (tabItem != TabItem.Apps) {
                composerK.a0(609919221);
                final WebsiteProfileRelation.BlockingType blockingType = tabItem == TabItem.Keywords ? WebsiteProfileRelation.BlockingType.KEYWORD : WebsiteProfileRelation.BlockingType.DOMAIN;
                Object objG = composerK.G();
                Composer.Companion companion = Composer.f23746a;
                if (objG == companion.a()) {
                    objG = InteractionSourceKt.a();
                    composerK.w(objG);
                }
                MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objG;
                BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType keywordTypeD = websiteKeywordsViewState.d();
                boolean zE = composerK.e(blockingType.ordinal()) | composerK.I(websiteKeywordsViewState);
                Object objG2 = composerK.G();
                if (zE || objG2 == companion.a()) {
                    objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.x1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BaseSelectionScreenScaffoldKt.G(blockingType, websiteKeywordsViewState, (String) obj);
                        }
                    };
                    composerK.w(objG2);
                }
                Function1 function13 = (Function1) objG2;
                int i5 = i4 & 896;
                int i6 = i4 & 57344;
                boolean zE2 = (i6 == 16384) | (i5 == 256) | composerK.e(blockingType.ordinal()) | composerK.I(focusManager);
                Object objG3 = composerK.G();
                if (zE2 || objG3 == companion.a()) {
                    objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.y1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BaseSelectionScreenScaffoldKt.H(function1, blockingType, function12, focusManager);
                        }
                    };
                    composerK.w(objG3);
                }
                Function0 function0 = (Function0) objG3;
                boolean z2 = i5 == 256;
                Object objG4 = composerK.G();
                if (z2 || objG4 == companion.a()) {
                    objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.z1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BaseSelectionScreenScaffoldKt.I(function1);
                        }
                    };
                    composerK.w(objG4);
                }
                Function0 function02 = (Function0) objG4;
                boolean z3 = i5 == 256;
                Object objG5 = composerK.G();
                if (z3 || objG5 == companion.a()) {
                    objG5 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.b2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BaseSelectionScreenScaffoldKt.J(function1, (BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType) obj);
                        }
                    };
                    composerK.w(objG5);
                }
                L(blockingType, str2, function13, function0, function12, mutableInteractionSource, keywordTypeD, function02, (Function1) objG5, composerK, i6 | ((i4 >> 6) & 112) | 196608);
                composerK = composerK;
                DividerKt.a(SizeKt.h(Modifier.b8, 0.0f, 1, null), 0L, 0.0f, 0.0f, composerK, 6, 14);
            } else {
                composerK.a0(591942817);
            }
            composerK.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.c2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseSelectionScreenScaffoldKt.K(tabItem, websiteKeywordsViewState, function1, str, function12, focusManager, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseSelectionViewState.ValidationResult G(WebsiteProfileRelation.BlockingType blockingType, BaseSelectionViewState.WebsiteKeywordsViewState websiteKeywordsViewState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return blockingType == WebsiteProfileRelation.BlockingType.KEYWORD ? websiteKeywordsViewState.q(it) : websiteKeywordsViewState.r(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(Function1 function1, WebsiteProfileRelation.BlockingType blockingType, Function1 function12, FocusManager focusManager) {
        function1.invoke(new BaseSelectionViewEvent.OnWebsiteOrKeywordAdded(blockingType));
        function12.invoke("");
        FocusManager.m(focusManager, false, 1, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(Function1 function1) {
        function1.invoke(BaseSelectionViewEvent.BlockingSelectViewEvent.OnImportDefaultListClicked.f118195a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(Function1 function1, BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new BaseSelectionViewEvent.OnKeywordTypeChanged(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(TabItem tabItem, BaseSelectionViewState.WebsiteKeywordsViewState websiteKeywordsViewState, Function1 function1, String str, Function1 function12, FocusManager focusManager, int i3, Composer composer, int i4) {
        F(tabItem, websiteKeywordsViewState, function1, str, function12, focusManager, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void L(final WebsiteProfileRelation.BlockingType blockingType, final String str, final Function1 function1, final Function0 function0, final Function1 function12, final MutableInteractionSource mutableInteractionSource, final BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType keywordType, final Function0 function02, final Function1 function13, Composer composer, final int i3) {
        int i4;
        String str2;
        Function1 function14;
        Function0 function03;
        MutableInteractionSource mutableInteractionSource2;
        Function0 function04;
        Composer composerK = composer.k(2018303649);
        if ((i3 & 6) == 0) {
            i4 = (composerK.e(blockingType.ordinal()) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            str2 = str;
            i4 |= composerK.Z(str2) ? 32 : 16;
        } else {
            str2 = str;
        }
        if ((i3 & 384) == 0) {
            function14 = function1;
            i4 |= composerK.I(function14) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            function14 = function1;
        }
        if ((i3 & 3072) == 0) {
            function03 = function0;
            i4 |= composerK.I(function03) ? 2048 : 1024;
        } else {
            function03 = function0;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function12) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            mutableInteractionSource2 = mutableInteractionSource;
            i4 |= composerK.Z(mutableInteractionSource2) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.e(keywordType.ordinal()) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            function04 = function02;
            i4 |= composerK.I(function04) ? 8388608 : 4194304;
        } else {
            function04 = function02;
        }
        if ((100663296 & i3) == 0) {
            i4 |= composerK.I(function13) ? 67108864 : 33554432;
        }
        if (composerK.r((38347923 & i4) != 38347922, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2018303649, i4, -1, "cz.mobilesoft.coreblock.scene.selection.base.AddKeywordWebsiteRowInput (BaseSelectionScreenScaffold.kt:437)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierM = PaddingKt.m(companion, PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 0.0f, 0.0f, 14, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.l(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            int i5 = i4;
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            Modifier modifierC = RowScope.c(RowScopeInstance.f7101a, companion, 1.0f, false, 2, null);
            WebsiteProfileRelation.BlockingType blockingType2 = WebsiteProfileRelation.BlockingType.KEYWORD;
            String strB = StringResources_androidKt.b(blockingType == blockingType2 ? R.string.P : R.string.U, composerK, 0);
            boolean z2 = (i5 & 57344) == 16384;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.d2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseSelectionScreenScaffoldKt.M(function12, (String) obj);
                    }
                };
                composerK.w(objG);
            }
            int i6 = i5 << 3;
            BaseSelectionRowsKt.o(modifierC, strB, str2, function14, function03, (Function1) objG, blockingType, mutableInteractionSource2, function04, composerK, (i6 & 234881024) | (65408 & i6) | ((i5 << 18) & 3670016) | ((i5 << 6) & 29360128), 0);
            if (blockingType != blockingType2 || str.length() <= 0) {
                composerK.a0(526922885);
            } else {
                composerK.a0(547815397);
                float f3 = 4;
                BaseSelectionRowsKt.w(PaddingKt.m(companion, 0.0f, Dp.g(f3), Dp.g(12), Dp.g(f3), 1, null), keywordType, function13, composerK, ((i5 >> 15) & 112) | ((i5 >> 18) & 896), 0);
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.e2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseSelectionScreenScaffoldKt.N(blockingType, str, function1, function0, function12, mutableInteractionSource, keywordType, function02, function13, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(WebsiteProfileRelation.BlockingType blockingType, String str, Function1 function1, Function0 function0, Function1 function12, MutableInteractionSource mutableInteractionSource, BaseSelectionViewState.WebsiteKeywordsViewState.KeywordType keywordType, Function0 function02, Function1 function13, int i3, Composer composer, int i4) {
        L(blockingType, str, function1, function0, function12, mutableInteractionSource, keywordType, function02, function13, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void O(final CoroutineScope scope, final ScaffoldState scaffoldState, final PagerState pagerState, final boolean z2, final ModalBottomSheetState bottomSheetState, final String title, final BaseSelectionViewState viewState, final TabItem[] tabItems, final TabItem selectedType, final ImmutableList listStates, final Function1 onEvent, final Function3 content, Composer composer, final int i3, final int i4) {
        int i5;
        int i6;
        Composer composer2;
        MutableState mutableState;
        int i7;
        Object objE;
        Object baseSelectionScreenScaffoldKt$BaseSelectionScreenScaffold$2$1;
        int i8;
        FocusManager focusManager;
        int i9;
        int i10;
        Composer composer3;
        MutableState mutableState2;
        PagerState pagerState2;
        final MutableState mutableState3;
        Composer composer4;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(scaffoldState, "scaffoldState");
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Intrinsics.checkNotNullParameter(bottomSheetState, "bottomSheetState");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(tabItems, "tabItems");
        Intrinsics.checkNotNullParameter(selectedType, "selectedType");
        Intrinsics.checkNotNullParameter(listStates, "listStates");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerK = composer.k(1008401369);
        if ((i3 & 6) == 0) {
            i5 = (composerK.I(scope) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(scaffoldState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.Z(pagerState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.b(z2) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= (i3 & 32768) == 0 ? composerK.Z(bottomSheetState) : composerK.I(bottomSheetState) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i5 |= composerK.Z(title) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i5 |= composerK.Z(viewState) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i5 |= composerK.I(tabItems) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            i5 |= composerK.e(selectedType.ordinal()) ? 67108864 : 33554432;
        }
        if ((805306368 & i3) == 0) {
            i5 |= composerK.Z(listStates) ? 536870912 : 268435456;
        }
        int i11 = i5;
        if ((i4 & 6) == 0) {
            i6 = i4 | (composerK.I(onEvent) ? 4 : 2);
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= composerK.I(content) ? 32 : 16;
        }
        if (composerK.r(((i11 & 306783379) == 306783378 && (i6 & 19) == 18) ? false : true, i11 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1008401369, i11, i6, "cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionScreenScaffold (BaseSelectionScreenScaffold.kt:89)");
            }
            final View view = (View) composerK.q(AndroidCompositionLocals_androidKt.j());
            final ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                MutableState mutableStateE = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(mutableStateE);
                objG = mutableStateE;
            }
            final MutableState mutableState4 = (MutableState) objG;
            boolean zI = composerK.I(view);
            Object objG2 = composerK.G();
            if (zI || objG2 == companion.a()) {
                objG2 = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: cz.mobilesoft.coreblock.scene.selection.base.p1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public final void onGlobalLayout() {
                        BaseSelectionScreenScaffoldKt.d0(view, mutableState4);
                    }
                };
                composerK.w(objG2);
            }
            final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = (ViewTreeObserver.OnGlobalLayoutListener) objG2;
            Object objG3 = composerK.G();
            int i12 = i6;
            if (objG3 == companion.a()) {
                mutableState = mutableState4;
                i7 = 2;
                objE = SnapshotStateKt__SnapshotStateKt.e("", null, 2, null);
                composerK.w(objE);
            } else {
                mutableState = mutableState4;
                i7 = 2;
                objE = objG3;
            }
            MutableState mutableState5 = (MutableState) objE;
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = SnapshotStateKt__SnapshotStateKt.e("", null, i7, null);
                composerK.w(objG4);
            }
            MutableState mutableState6 = (MutableState) objG4;
            FocusManager focusManager2 = (FocusManager) composerK.q(CompositionLocalsKt.g());
            boolean zI2 = composerK.I(viewTreeObserver) | composerK.I(onGlobalLayoutListener);
            Object objG5 = composerK.G();
            if (zI2 || objG5 == companion.a()) {
                objG5 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.a2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseSelectionScreenScaffoldKt.Q(viewTreeObserver, onGlobalLayoutListener, (DisposableEffectScope) obj);
                    }
                };
                composerK.w(objG5);
            }
            EffectsKt.c(viewTreeObserver, (Function1) objG5, composerK, 0);
            int i13 = i12 & 14;
            boolean z3 = ((i11 & 896) == 256) | (i13 == 4);
            Object objG6 = composerK.G();
            if (z3 || objG6 == companion.a()) {
                i8 = i11;
                focusManager = focusManager2;
                i9 = 1048576;
                i10 = i13;
                composer3 = composerK;
                mutableState2 = mutableState5;
                baseSelectionScreenScaffoldKt$BaseSelectionScreenScaffold$2$1 = new BaseSelectionScreenScaffoldKt$BaseSelectionScreenScaffold$2$1(pagerState, onEvent, mutableState2, mutableState6, null);
                pagerState2 = pagerState;
                mutableState3 = mutableState6;
                composer3.w(baseSelectionScreenScaffoldKt$BaseSelectionScreenScaffold$2$1);
            } else {
                i8 = i11;
                composer3 = composerK;
                mutableState3 = mutableState6;
                focusManager = focusManager2;
                mutableState2 = mutableState5;
                i9 = 1048576;
                i10 = i13;
                baseSelectionScreenScaffoldKt$BaseSelectionScreenScaffold$2$1 = objG6;
                pagerState2 = pagerState;
            }
            EffectsKt.g(pagerState2, (Function2) baseSelectionScreenScaffoldKt$BaseSelectionScreenScaffold$2$1, composer3, (i8 >> 6) & 14);
            boolean zI3 = ((3670016 & i8) == i9) | (i10 == 4) | ((57344 & i8) == 16384 || ((i8 & 32768) != 0 && composer3.I(bottomSheetState))) | composer3.I(scope) | ((i8 & 7168) == 2048);
            Object objG7 = composer3.G();
            if (zI3 || objG7 == companion.a()) {
                final MutableState mutableState7 = mutableState2;
                composer4 = composer3;
                Function0 function0 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.l2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BaseSelectionScreenScaffoldKt.R(viewState, onEvent, bottomSheetState, scope, z2, mutableState7);
                    }
                };
                mutableState2 = mutableState7;
                composer4.w(function0);
                objG7 = function0;
            } else {
                composer4 = composer3;
            }
            BackHandlerKt.a(false, (Function0) objG7, composer4, 0, 1);
            final FocusManager focusManager3 = focusManager;
            final PagerState pagerState3 = pagerState2;
            int i14 = i8;
            final MutableState mutableState8 = mutableState2;
            Composer composer5 = composer4;
            final MutableState mutableState9 = mutableState3;
            final MutableState mutableState10 = mutableState;
            composer2 = composer5;
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.c(WindowInsets.f7172a, composer4, 6)), scaffoldState, ComposableLambdaKt.e(582892766, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.n2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseSelectionScreenScaffoldKt.S(listStates, pagerState3, title, tabItems, viewState, selectedType, z2, scope, bottomSheetState, onEvent, mutableState8, focusManager3, mutableState3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer5, 54), ComposableLambdaKt.e(1725240351, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.o2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseSelectionScreenScaffoldKt.Y(tabItems, pagerState, viewState, focusManager3, onEvent, mutableState10, mutableState9, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer5, 54), ComposableSingletons$BaseSelectionScreenScaffoldKt.f118408a.e(), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(514944535, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.selection.base.p2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BaseSelectionScreenScaffoldKt.a0(content, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer5, 54), composer2, (i14 & 112) | 28032, 12582912, 131040);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.q2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseSelectionScreenScaffoldKt.b0(scope, scaffoldState, pagerState, z2, bottomSheetState, title, viewState, tabItems, selectedType, listStates, onEvent, content, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean P(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult Q(final ViewTreeObserver viewTreeObserver, final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
        return new DisposableEffectResult() { // from class: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionScreenScaffoldKt$BaseSelectionScreenScaffold$lambda$10$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(BaseSelectionViewState baseSelectionViewState, Function1 function1, ModalBottomSheetState modalBottomSheetState, CoroutineScope coroutineScope, boolean z2, MutableState mutableState) {
        if (baseSelectionViewState.c().c()) {
            function1.invoke(new BaseSelectionViewEvent.OnAppSearchStateChanged(false));
            f0(mutableState, "");
        } else if (modalBottomSheetState.k()) {
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new BaseSelectionScreenScaffoldKt$BaseSelectionScreenScaffold$3$1$1(modalBottomSheetState, null), 3, null);
        } else if (z2) {
            function1.invoke(BaseSelectionViewEvent.OnBackButtonClicked.f118203a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(CoroutineScope coroutineScope, PagerState pagerState, TabItem[] tabItemArr, TabItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new BaseSelectionScreenScaffoldKt$BaseSelectionScreenScaffold$4$1$1$1(pagerState, tabItemArr, it, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        f0(mutableState, it);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(Function1 function1) {
        function1.invoke(BaseSelectionViewEvent.OnBackButtonClicked.f118203a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(final TabItem tabItem, BaseSelectionViewState baseSelectionViewState, final Function1 function1, FocusManager focusManager, final MutableState mutableState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-594444351, i3, -1, "cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionScreenScaffold.<anonymous>.<anonymous> (BaseSelectionScreenScaffold.kt:161)");
            }
            BaseSelectionViewState.WebsiteKeywordsViewState websiteKeywordsViewStateP = baseSelectionViewState.p();
            String strG0 = g0(mutableState);
            boolean zE = composer.e(tabItem.ordinal()) | composer.Z(function1);
            Object objG = composer.G();
            if (zE || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.s1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseSelectionScreenScaffoldKt.X(tabItem, function1, mutableState, (String) obj);
                    }
                };
                composer.w(objG);
            }
            F(tabItem, websiteKeywordsViewStateP, function1, strG0, (Function1) objG, focusManager, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(TabItem tabItem, Function1 function1, MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        h0(mutableState, it);
        if (tabItem == TabItem.Keywords) {
            function1.invoke(new BaseSelectionViewEvent.BlockingSelectViewEvent.OnKeywordChanged(it));
        } else {
            function1.invoke(new BaseSelectionViewEvent.BlockingSelectViewEvent.OnWebsiteChanged(it));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(TabItem[] tabItemArr, PagerState pagerState, final BaseSelectionViewState baseSelectionViewState, final FocusManager focusManager, final Function1 function1, MutableState mutableState, final MutableState mutableState2, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1725240351, i3, -1, "cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionScreenScaffold.<anonymous> (BaseSelectionScreenScaffold.kt:180)");
            }
            final TabItem tabItem = tabItemArr[pagerState.v()];
            final BaseSelectionViewState.ButtonType buttonType = ((tabItem != TabItem.Webs || (!P(mutableState) && baseSelectionViewState.p().j().length() <= 0)) && (tabItem != TabItem.Keywords || (!P(mutableState) && baseSelectionViewState.p().c().length() <= 0))) ? BaseSelectionViewState.ButtonType.Save : BaseSelectionViewState.ButtonType.Add;
            String strB = StringResources_androidKt.b(buttonType.getTitle(), composer, 0);
            FlatButtonColors flatButtonColors = (buttonType != BaseSelectionViewState.ButtonType.Add || baseSelectionViewState.p().m(tabItem)) ? FlatButtonColors.Primary.f131166a : FlatButtonColors.Disabled.f131162a;
            boolean zE = composer.e(buttonType.ordinal()) | composer.Z(baseSelectionViewState) | composer.e(tabItem.ordinal()) | composer.I(focusManager) | composer.Z(function1);
            Object objG = composer.G();
            if (zE || objG == Composer.f23746a.a()) {
                Function0 function0 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.r2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BaseSelectionScreenScaffoldKt.Z(buttonType, baseSelectionViewState, tabItem, focusManager, function1, mutableState2);
                    }
                };
                composer.w(function0);
                objG = function0;
            }
            FlatButtonsKt.p(flatButtonColors, false, strB, false, (Function0) objG, composer, 0, 10);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(BaseSelectionViewState.ButtonType buttonType, BaseSelectionViewState baseSelectionViewState, TabItem tabItem, FocusManager focusManager, Function1 function1, MutableState mutableState) {
        if (buttonType != BaseSelectionViewState.ButtonType.Add) {
            function1.invoke(new BaseSelectionViewEvent.OnSaveButtonClicked(false, 1, null));
        } else if (baseSelectionViewState.p().m(tabItem)) {
            h0(mutableState, "");
            FocusManager.m(focusManager, false, 1, null);
            function1.invoke(new BaseSelectionViewEvent.OnWebsiteOrKeywordAdded(tabItem == TabItem.Webs ? WebsiteProfileRelation.BlockingType.DOMAIN : WebsiteProfileRelation.BlockingType.KEYWORD));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(Function3 function3, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(514944535, i3, -1, "cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionScreenScaffold.<anonymous> (BaseSelectionScreenScaffold.kt:212)");
            }
            function3.invoke(it, composer, Integer.valueOf(i3 & 14));
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(CoroutineScope coroutineScope, ScaffoldState scaffoldState, PagerState pagerState, boolean z2, ModalBottomSheetState modalBottomSheetState, String str, BaseSelectionViewState baseSelectionViewState, TabItem[] tabItemArr, TabItem tabItem, ImmutableList immutableList, Function1 function1, Function3 function3, int i3, int i4, Composer composer, int i5) {
        O(coroutineScope, scaffoldState, pagerState, z2, modalBottomSheetState, str, baseSelectionViewState, tabItemArr, tabItem, immutableList, function1, function3, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4));
        return Unit.f139807a;
    }

    private static final void c0(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(View view, MutableState mutableState) {
        WindowInsetsCompat windowInsetsCompatF = ViewCompat.F(view);
        c0(mutableState, windowInsetsCompatF != null ? windowInsetsCompatF.s(WindowInsetsCompat.Type.d()) : true);
    }

    private static final String e0(MutableState mutableState) {
        return (String) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(MutableState mutableState, String str) {
        mutableState.setValue(str);
    }

    private static final String g0(MutableState mutableState) {
        return (String) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(MutableState mutableState, String str) {
        mutableState.setValue(str);
    }

    public static final void i0(final String title, final TabItem[] tabItems, final BaseSelectionViewState viewState, TabItem tabItem, Profile.BlockingMode blockingMode, final String searchText, final boolean z2, final Function1 onPagerSelected, final Function1 onSearchTextChanged, final LazyListState lazyListState, ModalBottomSheetState modalBottomSheetState, final CoroutineScope scope, final Function0 onCloseClicked, final Function1 onEvent, final Function2 content, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Composer composer2;
        final TabItem tabItem2;
        final Profile.BlockingMode blockingMode2;
        final ModalBottomSheetState modalBottomSheetState2;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(tabItems, "tabItems");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(searchText, "searchText");
        Intrinsics.checkNotNullParameter(onPagerSelected, "onPagerSelected");
        Intrinsics.checkNotNullParameter(onSearchTextChanged, "onSearchTextChanged");
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerK = composer.k(1054070115);
        if ((i3 & 6) == 0) {
            i6 = i3 | (composerK.Z(title) ? 4 : 2);
        } else {
            i6 = i3;
        }
        if ((i3 & 48) == 0) {
            i6 |= composerK.I(tabItems) ? 32 : 16;
        }
        int i11 = i3 & 384;
        int i12 = ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i11 == 0) {
            i6 |= composerK.Z(viewState) ? Function.MAX_NARGS : 128;
        }
        int i13 = i6;
        int i14 = i5 & 8;
        if (i14 != 0) {
            i13 |= 3072;
        } else if ((i3 & 3072) == 0) {
            i13 |= composerK.e(tabItem == null ? -1 : tabItem.ordinal()) ? 2048 : 1024;
        }
        int i15 = i5 & 16;
        int i16 = Utility.DEFAULT_STREAM_BUFFER_SIZE;
        if (i15 != 0) {
            i13 |= 24576;
            i7 = i15;
        } else {
            i7 = i15;
            if ((i3 & 24576) == 0) {
                i13 |= composerK.e(blockingMode != null ? blockingMode.ordinal() : -1) ? 16384 : 8192;
            }
        }
        if ((196608 & i3) == 0) {
            i13 |= composerK.Z(searchText) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i13 |= composerK.b(z2) ? 1048576 : 524288;
        }
        if ((i3 & 12582912) == 0) {
            i13 |= composerK.I(onPagerSelected) ? 8388608 : 4194304;
        }
        if ((i3 & 100663296) == 0) {
            i13 |= composerK.I(onSearchTextChanged) ? 67108864 : 33554432;
        }
        if ((i3 & 805306368) == 0) {
            i13 |= composerK.Z(lazyListState) ? 536870912 : 268435456;
        }
        if ((i4 & 384) == 0) {
            if (composerK.I(onCloseClicked)) {
                i12 = Function.MAX_NARGS;
            }
            i8 = i4 | i12;
        } else {
            i8 = i4;
        }
        int i17 = i8;
        if ((i4 & 3072) == 0) {
            i9 = i17 | (composerK.I(onEvent) ? 2048 : 1024);
        } else {
            i9 = i17;
        }
        int i18 = i9;
        if ((i4 & 24576) == 0) {
            if (composerK.I(content)) {
                i16 = 16384;
            }
            i10 = i18 | i16;
        } else {
            i10 = i18;
        }
        if (composerK.r(((i13 & 306783379) == 306783378 && (i10 & 9345) == 9344) ? false : true, i13 & 1)) {
            tabItem2 = i14 != 0 ? TabItem.Apps : tabItem;
            Profile.BlockingMode blockingMode3 = i7 != 0 ? Profile.BlockingMode.Blocklist : blockingMode;
            ModalBottomSheetState modalBottomSheetState3 = (i5 & 1024) != 0 ? null : modalBottomSheetState;
            if (ComposerKt.M()) {
                ComposerKt.U(1054070115, i13, i10, "cz.mobilesoft.coreblock.scene.selection.base.SelectionTopAppBar (BaseSelectionScreenScaffold.kt:233)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new FocusRequester();
                composerK.w(objG);
            }
            final FocusRequester focusRequester = (FocusRequester) objG;
            Boolean boolValueOf = Boolean.valueOf(viewState.c().c());
            final Profile.BlockingMode blockingMode4 = blockingMode3;
            boolean z3 = (i13 & 896) == 256;
            Object objG2 = composerK.G();
            if (z3 || objG2 == companion.a()) {
                objG2 = new BaseSelectionScreenScaffoldKt$SelectionTopAppBar$1$1(viewState, focusRequester, null);
                composerK.w(objG2);
            }
            EffectsKt.g(boolValueOf, (Function2) objG2, composerK, 0);
            composer2 = composerK;
            SurfaceKt.a(null, null, ComposeColorsKt.j(composerK, 0).e(), 0L, null, LazyListKt.a(lazyListState), ComposableLambdaKt.e(-987927393, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.t1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseSelectionScreenScaffoldKt.j0(title, blockingMode4, tabItems, tabItem2, content, z2, viewState, onEvent, onSearchTextChanged, onCloseClicked, focusRequester, searchText, context, onPagerSelected, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54), composer2, 1572864, 27);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            blockingMode2 = blockingMode4;
            modalBottomSheetState2 = modalBottomSheetState3;
        } else {
            composer2 = composerK;
            composer2.Q();
            tabItem2 = tabItem;
            blockingMode2 = blockingMode;
            modalBottomSheetState2 = modalBottomSheetState;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.u1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseSelectionScreenScaffoldKt.t0(title, tabItems, viewState, tabItem2, blockingMode2, searchText, z2, onPagerSelected, onSearchTextChanged, lazyListState, modalBottomSheetState2, scope, onCloseClicked, onEvent, content, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(String str, Profile.BlockingMode blockingMode, final TabItem[] tabItemArr, final TabItem tabItem, Function2 function2, final boolean z2, final BaseSelectionViewState baseSelectionViewState, final Function1 function1, final Function1 function12, final Function0 function0, final FocusRequester focusRequester, final String str2, final Context context, final Function1 function13, Composer composer, int i3) {
        int i4;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-987927393, i3, -1, "cz.mobilesoft.coreblock.scene.selection.base.SelectionTopAppBar.<anonymous> (BaseSelectionScreenScaffold.kt:246)");
            }
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion);
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
            float f3 = 0;
            AppBarKt.d(SizeKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(54)), ComposeColorsKt.j(composer, 0).e(), 0L, Dp.g(f3), PaddingKt.a(Dp.g(f3)), ComposableLambdaKt.e(-696985766, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.selection.base.v1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BaseSelectionScreenScaffoldKt.k0(z2, baseSelectionViewState, function1, function12, function0, focusRequester, str2, tabItem, context, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 224262, 4);
            TextKt.c(str, PaddingKt.m(companion, PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 0.0f, Dp.g(16), 6, null), ComposeColorsKt.j(composer, 0).L(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.f()), 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composer, MaterialTheme.f13092b).f(), composer, 0, 0, 65016);
            if (blockingMode != Profile.BlockingMode.Blocklist || tabItemArr.length <= 1) {
                i4 = 0;
                composer.a0(179108569);
            } else {
                composer.a0(195442655);
                i4 = 0;
                TabRowKt.b(tabItem.getIndex(), SizeKt.h(companion, 0.0f, 1, null), ComposeColorsKt.j(composer, 0).e(), ComposeColorsKt.j(composer, 0).b(), null, ComposableSingletons$BaseSelectionScreenScaffoldKt.f118408a.f(), ComposableLambdaKt.e(-625587690, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.w1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BaseSelectionScreenScaffoldKt.q0(tabItemArr, tabItem, function13, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer, 1769520, 16);
            }
            composer.U();
            function2.invoke(composer, Integer.valueOf(i4));
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
    public static final Unit k0(boolean z2, final BaseSelectionViewState baseSelectionViewState, final Function1 function1, final Function1 function12, final Function0 function0, FocusRequester focusRequester, String str, TabItem tabItem, final Context context, RowScope TopAppBar, Composer composer, int i3) {
        int i4;
        int i5;
        int i6;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer2.Z(TopAppBar) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer2.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-696985766, i4, -1, "cz.mobilesoft.coreblock.scene.selection.base.SelectionTopAppBar.<anonymous>.<anonymous>.<anonymous> (BaseSelectionScreenScaffold.kt:255)");
            }
            if (z2) {
                composer2.a0(-2030976414);
                Modifier modifierM = PaddingKt.m(Modifier.b8, Dp.g(16), 0.0f, 0.0f, 0.0f, 14, null);
                int i7 = R.drawable.f95577x1;
                boolean Z = composer2.Z(baseSelectionViewState) | composer2.Z(function1) | composer2.Z(function12) | composer2.Z(function0);
                Object objG = composer2.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.f2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BaseSelectionScreenScaffoldKt.l0(baseSelectionViewState, function1, function12, function0);
                        }
                    };
                    composer2.w(objG);
                }
                i5 = -2042060216;
                ToolbarKt.h(modifierM, i7, null, null, 0.0f, (Function0) objG, composer2, 6, 28);
            } else {
                i5 = -2042060216;
                composer2.a0(-2042060216);
            }
            composer2.U();
            if (baseSelectionViewState.c().c()) {
                composer2.a0(-2030048398);
                Modifier modifierA = FocusRequesterModifierKt.a(RowScope.c(TopAppBar, Modifier.b8, 1.0f, false, 2, null), focusRequester);
                KeyboardOptions keyboardOptionsD = KeyboardOptions.d(KeyboardOptions.f9764h.a(), 0, null, 0, ImeAction.f29348b.b(), null, null, null, 119, null);
                boolean Z2 = composer2.Z(function1) | composer2.Z(function12);
                Object objG2 = composer2.G();
                if (Z2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.g2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BaseSelectionScreenScaffoldKt.m0(function1, function12, (KeyboardActionScope) obj);
                        }
                    };
                    composer2.w(objG2);
                }
                KeyboardActions keyboardActions = new KeyboardActions((Function1) objG2, null, null, null, null, null, 62, null);
                boolean Z3 = composer2.Z(function12) | composer2.Z(function1);
                Object objG3 = composer2.G();
                if (Z3 || objG3 == Composer.f23746a.a()) {
                    objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.h2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BaseSelectionScreenScaffoldKt.n0(function12, function1, (String) obj);
                        }
                    };
                    composer2.w(objG3);
                }
                ComposeTextFieldsKt.h(str, (Function1) objG3, modifierA, false, false, false, null, null, ComposableSingletons$BaseSelectionScreenScaffoldKt.f118408a.d(), null, null, false, null, keyboardOptionsD, keyboardActions, true, 0, null, null, null, null, 0L, 0.0f, 0.0f, composer, 100859904, 196608, 0, 16719576);
                composer2 = composer;
                composer2.U();
                i6 = 0;
            } else {
                composer2.a0(-2027624694);
                i6 = 0;
                SpacerKt.a(RowScope.c(TopAppBar, Modifier.b8, 1.0f, false, 2, null), composer2, 0);
                composer2.U();
            }
            if (baseSelectionViewState.c().c() || tabItem != TabItem.Apps) {
                if (tabItem == TabItem.Keywords) {
                    composer2.a0(-2026824212);
                    Modifier modifierM2 = PaddingKt.m(Modifier.b8, 0.0f, 0.0f, Dp.g(16), 0.0f, 11, null);
                    int i8 = R.drawable.F4;
                    String strB = StringResources_androidKt.b(R.string.Of, composer2, i6);
                    boolean zI = composer2.I(context);
                    Object objG4 = composer2.G();
                    if (zI || objG4 == Composer.f23746a.a()) {
                        objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.j2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return BaseSelectionScreenScaffoldKt.p0(context);
                            }
                        };
                        composer2.w(objG4);
                    }
                    ToolbarKt.h(modifierM2, i8, strB, null, 0.0f, (Function0) objG4, composer2, 6, 24);
                } else {
                    composer2.a0(i5);
                }
                composer2.U();
            } else {
                composer2.a0(-2027407415);
                Modifier modifierM3 = PaddingKt.m(Modifier.b8, 0.0f, 0.0f, Dp.g(16), 0.0f, 11, null);
                int i9 = R.drawable.Z4;
                String strB2 = StringResources_androidKt.b(R.string.Dv, composer2, i6);
                boolean Z4 = composer2.Z(function1);
                Object objG5 = composer2.G();
                if (Z4 || objG5 == Composer.f23746a.a()) {
                    objG5 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.i2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BaseSelectionScreenScaffoldKt.o0(function1);
                        }
                    };
                    composer2.w(objG5);
                }
                ToolbarKt.h(modifierM3, i9, strB2, null, 0.0f, (Function0) objG5, composer2, 6, 24);
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
    public static final Unit l0(BaseSelectionViewState baseSelectionViewState, Function1 function1, Function1 function12, Function0 function0) {
        if (baseSelectionViewState.c().c()) {
            function1.invoke(new BaseSelectionViewEvent.OnAppSearchStateChanged(false));
            function12.invoke("");
        } else {
            function0.invoke();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(Function1 function1, Function1 function12, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        function1.invoke(new BaseSelectionViewEvent.OnAppSearchStateChanged(false));
        function12.invoke("");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(Function1 function1, Function1 function12, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        function12.invoke(new BaseSelectionViewEvent.OnApplicationSearchTextChanged(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(Function1 function1) {
        function1.invoke(new BaseSelectionViewEvent.OnAppSearchStateChanged(true));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(Context context) {
        context.startActivity(KeywordsLearnMoreActivity.f119096f.a(context));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(TabItem[] tabItemArr, TabItem tabItem, final Function1 function1, Composer composer, int i3) {
        int i4;
        boolean z2;
        Composer composer2 = composer;
        boolean z3 = true;
        if (composer2.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-625587690, i3, -1, "cz.mobilesoft.coreblock.scene.selection.base.SelectionTopAppBar.<anonymous>.<anonymous>.<anonymous> (BaseSelectionScreenScaffold.kt:357)");
            }
            int length = tabItemArr.length;
            int i5 = 0;
            int i6 = 0;
            while (i5 < length) {
                final TabItem tabItem2 = tabItemArr[i5];
                int i7 = i6 + 1;
                final boolean z4 = tabItem == tabItem2 ? z3 : false;
                if (tabItem.getIndex() == i6) {
                    i4 = length;
                    z2 = z3;
                } else {
                    i4 = length;
                    z2 = false;
                }
                boolean Z = composer2.Z(function1) | composer2.e(tabItem2.ordinal());
                Object objG = composer2.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.k2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BaseSelectionScreenScaffoldKt.r0(function1, tabItem2);
                        }
                    };
                    composer2.w(objG);
                }
                ComposableLambda composableLambdaE = ComposableLambdaKt.e(94287069, z3, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.m2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BaseSelectionScreenScaffoldKt.s0(tabItem2, z4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54);
                int i8 = i4;
                TabKt.b(z2, (Function0) objG, null, false, composableLambdaE, null, null, 0L, 0L, composer2, 24576, 492);
                i5++;
                composer2 = composer;
                i6 = i7;
                z3 = z3;
                length = i8;
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
    public static final Unit r0(Function1 function1, TabItem tabItem) {
        function1.invoke(tabItem);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(TabItem tabItem, boolean z2, Composer composer, int i3) {
        TextStyle textStyleA;
        long jL;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(94287069, i3, -1, "cz.mobilesoft.coreblock.scene.selection.base.SelectionTopAppBar.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BaseSelectionScreenScaffold.kt:360)");
            }
            String strC = StringHelperExtKt.c(StringResources_androidKt.b(tabItem.getTitleRes(), composer, 0));
            int iA = TextAlign.f29616b.a();
            if (z2) {
                composer.a0(415568959);
                textStyleA = ComposeTypographyKt.g(composer, 0).h();
            } else {
                composer.a0(415569570);
                textStyleA = ComposeTypographyKt.g(composer, 0).a();
            }
            composer.U();
            TextStyle textStyle = textStyleA;
            if (z2) {
                composer.a0(415571875);
                jL = ComposeColorsKt.j(composer, 0).b();
            } else {
                composer.a0(415572481);
                jL = ComposeColorsKt.j(composer, 0).L();
            }
            composer.U();
            TextKt.c(strC, null, jL, 0L, null, null, null, 0L, null, TextAlign.h(iA), 0L, 0, false, 0, 0, null, textStyle, composer, 0, 0, 65018);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(String str, TabItem[] tabItemArr, BaseSelectionViewState baseSelectionViewState, TabItem tabItem, Profile.BlockingMode blockingMode, String str2, boolean z2, Function1 function1, Function1 function12, LazyListState lazyListState, ModalBottomSheetState modalBottomSheetState, CoroutineScope coroutineScope, Function0 function0, Function1 function13, Function2 function2, int i3, int i4, int i5, Composer composer, int i6) {
        i0(str, tabItemArr, baseSelectionViewState, tabItem, blockingMode, str2, z2, function1, function12, lazyListState, modalBottomSheetState, coroutineScope, function0, function13, function2, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4), i5);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit S(ImmutableList immutableList, final PagerState pagerState, String str, final TabItem[] tabItemArr, final BaseSelectionViewState baseSelectionViewState, final TabItem tabItem, boolean z2, final CoroutineScope coroutineScope, ModalBottomSheetState modalBottomSheetState, final Function1 function1, final MutableState mutableState, final FocusManager focusManager, final MutableState mutableState2, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(582892766, i3, -1, cJfnYMIyomoWf.kquxuCPPA);
            }
            String strE0 = e0(mutableState);
            LazyListState lazyListState = (LazyListState) immutableList.get(pagerState.v());
            boolean zI = composer.I(coroutineScope) | composer.Z(pagerState) | composer.I(tabItemArr);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.s2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseSelectionScreenScaffoldKt.T(coroutineScope, pagerState, tabItemArr, (TabItem) obj);
                    }
                };
                composer.w(objG);
            }
            Function1 function12 = (Function1) objG;
            Object objG2 = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.t2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseSelectionScreenScaffoldKt.U(mutableState, (String) obj);
                    }
                };
                composer.w(objG2);
            }
            Function1 function13 = (Function1) objG2;
            boolean Z = composer.Z(function1);
            Object objG3 = composer.G();
            if (Z || objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.q1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BaseSelectionScreenScaffoldKt.V(function1);
                    }
                };
                composer.w(objG3);
            }
            i0(str, tabItemArr, baseSelectionViewState, tabItem, null, strE0, z2, function12, function13, lazyListState, modalBottomSheetState, coroutineScope, (Function0) objG3, function1, ComposableLambdaKt.e(-594444351, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.r1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseSelectionScreenScaffoldKt.W(tabItem, baseSelectionViewState, function1, focusManager, mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 100663296, ModalBottomSheetState.f13222e | 24576, 16);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }
}
