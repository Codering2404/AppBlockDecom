package cz.mobilesoft.coreblock.scene.selection.base;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.AppBarKt;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.TextKt;
import androidx.compose.material3.SheetState;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.google.accompanist.systemuicontroller.SystemUiController;
import com.google.accompanist.systemuicontroller.SystemUiControllerKt;
import com.google.common.cache.LSNn.vfptEEmYY;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.ApplicationDTO;
import cz.mobilesoft.coreblock.dto.Category;
import cz.mobilesoft.coreblock.dto.RelationDTO;
import cz.mobilesoft.coreblock.dto.WebAllowlistBrowserItem;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor;
import cz.mobilesoft.coreblock.scene.selection.ApplicationStateDTO;
import cz.mobilesoft.coreblock.scene.selection.BlockingSelectScreenDialogsKt;
import cz.mobilesoft.coreblock.scene.selection.SubAppStateDTO;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewEvent;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState;
import cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.BaseWebsiteSelectionScreenKt;
import cz.mobilesoft.coreblock.scene.selection.components.ApplicationItemKt;
import cz.mobilesoft.coreblock.scene.selection.components.BrowsersForWebAllowlistBottomSheetKt;
import cz.mobilesoft.coreblock.scene.selection.components.LoadingContentKt;
import cz.mobilesoft.coreblock.scene.selection.components.TabItem;
import cz.mobilesoft.coreblock.scene.selection.components.WebsitesForSelectedAppsBottomSheetKt;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.ScreenProgressBarKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeBottomSheetsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDropdownItem;
import cz.mobilesoft.coreblock.view.compose.ComposeTextFieldsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.xmlpull.v1.XmlPullParserException;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class BaseSelectionScreenKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f118155a;

        static {
            int[] iArr = new int[BaseSelectionViewState.BottomSheetType.values().length];
            try {
                iArr[BaseSelectionViewState.BottomSheetType.WebsitesForSelectedApps.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BaseSelectionViewState.BottomSheetType.ImportDefaultList.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BaseSelectionViewState.BottomSheetType.BrowsersForWebAllowlist.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f118155a = iArr;
        }
    }

    private static final void A0(final Context context, final CoroutineScope coroutineScope, final BaseSelectionViewModel baseSelectionViewModel, final ScaffoldState scaffoldState, final PagerState pagerState, final TabItem[] tabItemArr, final ModalBottomSheetState modalBottomSheetState, final MutableState mutableState, final Function4 function4, final ImmutableList immutableList, final Function0 function0, final boolean z2, Composer composer, final int i3, final int i4) {
        int i5;
        ScaffoldState scaffoldState2;
        PagerState pagerState2;
        int i6;
        Composer composer2;
        Composer.Companion companion;
        int i7;
        Composer composerK = composer.k(498286507);
        if ((i3 & 6) == 0) {
            i5 = (composerK.I(context) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.I(coroutineScope) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(baseSelectionViewModel) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            scaffoldState2 = scaffoldState;
            i5 |= composerK.Z(scaffoldState2) ? 2048 : 1024;
        } else {
            scaffoldState2 = scaffoldState;
        }
        if ((i3 & 24576) == 0) {
            pagerState2 = pagerState;
            i5 |= composerK.Z(pagerState2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            pagerState2 = pagerState;
        }
        if ((i3 & 196608) == 0) {
            i5 |= composerK.I(tabItemArr) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((i3 & 1572864) == 0) {
            i5 |= (i3 & 2097152) == 0 ? composerK.Z(modalBottomSheetState) : composerK.I(modalBottomSheetState) ? 1048576 : 524288;
        }
        if ((i3 & 12582912) == 0) {
            i5 |= composerK.Z(mutableState) ? 8388608 : 4194304;
        }
        if ((i3 & 100663296) == 0) {
            i5 |= composerK.I(function4) ? 67108864 : 33554432;
        }
        if ((i3 & 805306368) == 0) {
            i5 |= composerK.Z(immutableList) ? 536870912 : 268435456;
        }
        if ((i4 & 6) == 0) {
            i6 = i4 | (composerK.I(function0) ? 4 : 2);
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= composerK.b(z2) ? 32 : 16;
        }
        int i8 = i6;
        if (composerK.r(((i5 & 306783379) == 306783378 && (i8 & 19) == 18) ? false : true, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(498286507, i5, i8, "cz.mobilesoft.coreblock.scene.selection.base.CommandProcessor (BaseSelectionScreen.kt:230)");
            }
            Object objG = composerK.G();
            Composer.Companion companion2 = Composer.f23746a;
            if (objG == companion2.a()) {
                companion = companion2;
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            } else {
                companion = companion2;
            }
            MutableState mutableState2 = (MutableState) objG;
            int i9 = i8 & 14;
            boolean z3 = i9 == 4;
            Object objG2 = composerK.G();
            if (z3 || objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.p0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BaseSelectionScreenKt.B0(function0);
                    }
                };
                composerK.w(objG2);
            }
            ComposeDialogsKt.H0(mutableState2, (Function0) objG2, composerK, 6);
            boolean zI = ((i8 & 112) == 32) | ((57344 & i5) == 16384) | composerK.I(tabItemArr) | composerK.I(context) | composerK.I(coroutineScope) | ((3670016 & i5) == 1048576 || ((i5 & 2097152) != 0 && composerK.I(modalBottomSheetState))) | ((234881024 & i5) == 67108864) | ((29360128 & i5) == 8388608) | ((i5 & 7168) == 2048) | ((1879048192 & i5) == 536870912) | (i9 == 4);
            Object objG3 = composerK.G();
            if (zI || objG3 == companion.a()) {
                i7 = i5;
                BaseSelectionScreenKt$CommandProcessor$2$1 baseSelectionScreenKt$CommandProcessor$2$1 = new BaseSelectionScreenKt$CommandProcessor$2$1(pagerState2, tabItemArr, context, z2, coroutineScope, function4, mutableState, function0, mutableState2, modalBottomSheetState, scaffoldState2, immutableList, null);
                composerK.w(baseSelectionScreenKt$CommandProcessor$2$1);
                objG3 = baseSelectionScreenKt$CommandProcessor$2$1;
            } else {
                i7 = i5;
            }
            composer2 = composerK;
            FlowExtKt.g(baseSelectionViewModel, null, (Function2) objG3, composer2, (i7 >> 6) & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.q0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseSelectionScreenKt.C0(context, coroutineScope, baseSelectionViewModel, scaffoldState, pagerState, tabItemArr, modalBottomSheetState, mutableState, function4, immutableList, function0, z2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(Context context, CoroutineScope coroutineScope, BaseSelectionViewModel baseSelectionViewModel, ScaffoldState scaffoldState, PagerState pagerState, TabItem[] tabItemArr, ModalBottomSheetState modalBottomSheetState, MutableState mutableState, Function4 function4, ImmutableList immutableList, Function0 function0, boolean z2, int i3, int i4, Composer composer, int i5) {
        A0(context, coroutineScope, baseSelectionViewModel, scaffoldState, pagerState, tabItemArr, modalBottomSheetState, mutableState, function4, immutableList, function0, z2, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x05b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void D0(final cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState r44, final cz.mobilesoft.coreblock.scene.selection.components.TabItem r45, kotlin.jvm.functions.Function0 r46, androidx.compose.runtime.Composer r47, final int r48) {
        /*
            Method dump skipped, instruction units count: 1497
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionScreenKt.D0(cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState, cz.mobilesoft.coreblock.scene.selection.components.TabItem, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(BaseSelectionViewState baseSelectionViewState, TabItem tabItem, Function0 function0, int i3, Composer composer, int i4) {
        D0(baseSelectionViewState, tabItem, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void F0(Modifier modifier, final PagerState pagerState, final BaseSelectionViewState baseSelectionViewState, final ScaffoldState scaffoldState, final ImmutableList immutableList, final Function1 function1, final MutableState mutableState, final TabItem[] tabItemArr, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        ScaffoldState scaffoldState2;
        Function1 function12;
        MutableState mutableState2;
        TabItem[] tabItemArr2;
        Composer composer2;
        final Modifier modifier3;
        Composer composerK = composer.k(2020841337);
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
            i5 |= composerK.Z(pagerState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.Z(baseSelectionViewState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            scaffoldState2 = scaffoldState;
            i5 |= composerK.Z(scaffoldState2) ? 2048 : 1024;
        } else {
            scaffoldState2 = scaffoldState;
        }
        if ((i3 & 24576) == 0) {
            i5 |= composerK.Z(immutableList) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            function12 = function1;
            i5 |= composerK.I(function12) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            function12 = function1;
        }
        if ((1572864 & i3) == 0) {
            mutableState2 = mutableState;
            i5 |= composerK.Z(mutableState2) ? 1048576 : 524288;
        } else {
            mutableState2 = mutableState;
        }
        if ((12582912 & i3) == 0) {
            tabItemArr2 = tabItemArr;
            i5 |= composerK.I(tabItemArr2) ? 8388608 : 4194304;
        } else {
            tabItemArr2 = tabItemArr;
        }
        if (composerK.r((4793491 & i5) != 4793490, i5 & 1)) {
            Modifier modifier4 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(2020841337, i5, -1, "cz.mobilesoft.coreblock.scene.selection.base.MainContent (BaseSelectionScreen.kt:385)");
            }
            Modifier modifierF = SizeKt.f(modifier4, 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
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
            Modifier modifier5 = modifier4;
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            SystemUiController.b(SystemUiControllerKt.e(null, composerK, 0, 1), Color.f25715b.j(), !DarkThemeKt.a(composerK, 0), null, 4, null);
            final ScaffoldState scaffoldState3 = scaffoldState2;
            final Function1 function13 = function12;
            final MutableState mutableState3 = mutableState2;
            final TabItem[] tabItemArr3 = tabItemArr2;
            composer2 = composerK;
            PagerKt.a(pagerState, ColumnScope.b(columnScopeInstance, Modifier.b8, 1.0f, false, 2, null), null, null, 1, 0.0f, null, null, false, false, null, null, null, null, ComposableLambdaKt.e(1617272432, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.selection.base.w
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return BaseSelectionScreenKt.G0(immutableList, tabItemArr3, baseSelectionViewState, function13, scaffoldState3, mutableState3, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerK, 54), composer2, ((i5 >> 3) & 14) | 24576, 24576, 16364);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier3 = modifier5;
        } else {
            composer2 = composerK;
            composer2.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseSelectionScreenKt.H0(modifier3, pagerState, baseSelectionViewState, scaffoldState, immutableList, function1, mutableState, tabItemArr, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit G0(ImmutableList immutableList, TabItem[] tabItemArr, BaseSelectionViewState baseSelectionViewState, Function1 function1, ScaffoldState scaffoldState, MutableState mutableState, PagerScope HorizontalPager, int i3, Composer composer, int i4) {
        Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
        if (ComposerKt.M()) {
            ComposerKt.U(1617272432, i4, -1, "cz.mobilesoft.coreblock.scene.selection.base.MainContent.<anonymous>.<anonymous> (BaseSelectionScreen.kt:399)");
        }
        LazyListState lazyListState = (LazyListState) immutableList.get(i3);
        TabItem tabItem = tabItemArr[i3];
        if (Intrinsics.areEqual(baseSelectionViewState.o(), Loading.f127895a)) {
            composer.a0(-779945350);
            LoadingContentKt.b(null, null, composer, 0, 3);
            composer.U();
        } else if (tabItem == TabItem.Apps) {
            composer.a0(-579345384);
            b0(baseSelectionViewState, function1, lazyListState, scaffoldState, mutableState, composer, 0);
            composer.U();
        } else if (tabItem == TabItem.Webs) {
            composer.a0(-579333398);
            BaseWebsiteSelectionScreenKt.p(baseSelectionViewState.p(), WebsiteProfileRelation.BlockingType.DOMAIN, baseSelectionViewState.d(), lazyListState, scaffoldState, function1, composer, 48, 0);
            composer.U();
        } else {
            if (tabItem == TabItem.Keywords) {
                composer.a0(-579318804);
                BaseWebsiteSelectionScreenKt.p(baseSelectionViewState.p(), WebsiteProfileRelation.BlockingType.KEYWORD, null, lazyListState, scaffoldState, function1, composer, 48, 4);
            } else {
                composer.a0(-797794158);
            }
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(Modifier modifier, PagerState pagerState, BaseSelectionViewState baseSelectionViewState, ScaffoldState scaffoldState, ImmutableList immutableList, Function1 function1, MutableState mutableState, TabItem[] tabItemArr, int i3, int i4, Composer composer, int i5) {
        F0(modifier, pagerState, baseSelectionViewState, scaffoldState, immutableList, function1, mutableState, tabItemArr, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void I0(androidx.compose.ui.Modifier r23, final cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState r24, final androidx.compose.material.ScaffoldState r25, final kotlin.jvm.functions.Function1 r26, final androidx.compose.runtime.MutableState r27, cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor r28, float r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 467
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionScreenKt.I0(androidx.compose.ui.Modifier, cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState, androidx.compose.material.ScaffoldState, kotlin.jvm.functions.Function1, androidx.compose.runtime.MutableState, cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor, float, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final String J0(MutableState mutableState) {
        return (String) mutableState.getValue();
    }

    private static final void K0(MutableState mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(BaseSelectionViewState baseSelectionViewState, Function1 function1, MutableState mutableState) {
        if (baseSelectionViewState.c().c()) {
            function1.invoke(new BaseSelectionViewEvent.OnAppSearchStateChanged(false));
            K0(mutableState, "");
        } else {
            function1.invoke(BaseSelectionViewEvent.OnBackButtonClicked.f118203a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(Modifier modifier, final ScheduleDescriptor scheduleDescriptor, final BaseSelectionViewState baseSelectionViewState, final Function1 function1, final FocusRequester focusRequester, final float f3, final MutableState mutableState, ScaffoldState scaffoldState, MutableState mutableState2, BoxScope GradientBox, Composer composer, int i3) {
        Composer composer2;
        Modifier.Companion companion;
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1392711721, i3, -1, "cz.mobilesoft.coreblock.scene.selection.base.MainOnboardingSelectionContent.<anonymous> (BaseSelectionScreen.kt:464)");
            }
            Modifier modifierD = WindowInsetsPaddingKt.d(modifier, WindowInsets_androidKt.d(WindowInsets.f7172a, composer, 6));
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.g(), composer, 48);
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
            Modifier.Companion companion4 = Modifier.b8;
            float f4 = 0;
            AppBarKt.d(SizeKt.i(SizeKt.h(companion4, 0.0f, 1, null), Dp.g(56)), Color.f25715b.j(), 0L, Dp.g(f4), PaddingKt.a(Dp.g(f4)), ComposableLambdaKt.e(-947415662, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.selection.base.r0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BaseSelectionScreenKt.N0(scheduleDescriptor, baseSelectionViewState, function1, focusRequester, f3, mutableState, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 224310, 4);
            if (scheduleDescriptor instanceof ScheduleDescriptor.CombinationOnboardingV2) {
                composer.a0(1014407455);
                companion = companion4;
                TextKt.c(StringResources_androidKt.b(R.string.P1, composer, 0), SizeKt.h(PaddingKt.m(PaddingKt.k(companion4, PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null), 0.0f, Dp.g(6), 0.0f, Dp.g(12), 5, null), 0.0f, 1, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).f(), composer, 0, 0, 65020);
                composer2 = composer;
            } else {
                composer2 = composer;
                companion = companion4;
                composer2.a0(989149089);
            }
            composer2.U();
            Modifier.Companion companion5 = companion;
            Modifier modifierB = ColumnScope.b(columnScopeInstance, SizeKt.h(companion5, 0.0f, 1, null), 1.0f, false, 2, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU2 = composer2.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierB);
            Function0 function0A2 = companion3.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A2);
            } else {
                composer2.v();
            }
            Composer composerA2 = Updater.a(composer2);
            Updater.e(composerA2, measurePolicyG, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Composer composer3 = composer2;
            b0(baseSelectionViewState, function1, LazyListStateKt.b(0, 0, composer2, 0, 3), scaffoldState, mutableState2, composer3, 0);
            composer3.y();
            int i4 = R.dimen.f95467a;
            float f5 = 16;
            Modifier modifierL = PaddingKt.l(companion5, PrimitiveResources_androidKt.a(i4, composer3, 0), Dp.g(f5), PrimitiveResources_androidKt.a(i4, composer3, 0), Dp.g(f5));
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
            int iA3 = ComposablesKt.a(composer3, 0);
            CompositionLocalMap compositionLocalMapU3 = composer3.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer3, modifierL);
            Function0 function0A3 = companion3.a();
            if (composer3.m() == null) {
                ComposablesKt.c();
            }
            composer3.L();
            if (composer3.i()) {
                composer3.P(function0A3);
            } else {
                composer3.v();
            }
            Composer composerA3 = Updater.a(composer3);
            Updater.e(composerA3, measurePolicyG2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            Modifier modifierH = SizeKt.h(companion5, 0.0f, 1, null);
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.l8, composer3, 0), 0.0f, 11, null);
            Map mapD = baseSelectionViewState.c().d();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : mapD.entrySet()) {
                if (((ApplicationStateDTO) entry.getValue()).c().h()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            ButtonColor.Accent accent = new ButtonColor.Accent(!linkedHashMap.isEmpty(), null, false, null, 10, null);
            boolean Z = composer3.Z(function1);
            Object objG = composer3.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.s0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BaseSelectionScreenKt.S0(function1);
                    }
                };
                composer3.w(objG);
            }
            ComposeButtonsKt.i0(modifierH, big, accent, (Function0) objG, composer3, 6, 0);
            composer.y();
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
    public static final Unit N0(ScheduleDescriptor scheduleDescriptor, final BaseSelectionViewState baseSelectionViewState, final Function1 function1, FocusRequester focusRequester, float f3, final MutableState mutableState, RowScope TopAppBar, Composer composer, int i3) throws XmlPullParserException, IOException {
        int i4;
        Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(TopAppBar) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-947415662, i4, -1, "cz.mobilesoft.coreblock.scene.selection.base.MainOnboardingSelectionContent.<anonymous>.<anonymous>.<anonymous> (BaseSelectionScreen.kt:477)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierM = PaddingKt.m(companion, Dp.g(16), 0.0f, 0.0f, 0.0f, 14, null);
            int i5 = scheduleDescriptor instanceof ScheduleDescriptor.CombinationOnboardingV2 ? R.drawable.f95577x1 : R.drawable.C1;
            String strB = StringResources_androidKt.b(R.string.N7, composer, 0);
            FlatButtonColors.Secondary secondary = FlatButtonColors.Secondary.f131167a;
            float fG = Dp.g(40);
            boolean Z = composer.Z(baseSelectionViewState) | composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.a1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BaseSelectionScreenKt.O0(baseSelectionViewState, function1, mutableState);
                    }
                };
                composer.w(objG);
            }
            FlatButtonsKt.K(modifierM, fG, i5, secondary, strB, (Function0) objG, composer, 3126, 0);
            if (baseSelectionViewState.c().c()) {
                composer.a0(2066291486);
                Modifier modifierA = FocusRequesterModifierKt.a(RowScope.c(TopAppBar, companion, 1.0f, false, 2, null), focusRequester);
                String strJ0 = J0(mutableState);
                KeyboardOptions keyboardOptionsD = KeyboardOptions.d(KeyboardOptions.f9764h.a(), 0, null, 0, ImeAction.f29348b.b(), null, null, null, 119, null);
                boolean Z2 = composer.Z(function1);
                Object objG2 = composer.G();
                if (Z2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.b1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BaseSelectionScreenKt.P0(function1, mutableState, (KeyboardActionScope) obj);
                        }
                    };
                    composer.w(objG2);
                }
                KeyboardActions keyboardActions = new KeyboardActions((Function1) objG2, null, null, null, null, null, 62, null);
                boolean Z3 = composer.Z(function1);
                Object objG3 = composer.G();
                if (Z3 || objG3 == Composer.f23746a.a()) {
                    objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.c1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BaseSelectionScreenKt.Q0(function1, mutableState, (String) obj);
                        }
                    };
                    composer.w(objG3);
                }
                ComposeTextFieldsKt.h(strJ0, (Function1) objG3, modifierA, false, false, false, null, null, ComposableSingletons$BaseSelectionScreenKt.f118402a.l(), null, null, false, null, keyboardOptionsD, keyboardActions, true, 0, null, null, null, null, 0L, 0.0f, 0.0f, composer, 100859904, 196608, 0, 16719576);
                composer.U();
            } else {
                composer.a0(2068734658);
                SpacerKt.a(RowScope.c(TopAppBar, companion, 1.0f, false, 2, null), composer, 0);
                ScreenProgressBarKt.b(null, f3, composer, 0, 1);
                SpacerKt.a(RowScope.c(TopAppBar, companion, 1.0f, false, 2, null), composer, 0);
                float f4 = 6;
                Modifier modifierM2 = PaddingKt.m(companion, Dp.g(f4), Dp.g(f4), Dp.g(f4), 0.0f, 8, null);
                ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.Z4, composer, 6);
                String strB2 = StringResources_androidKt.b(R.string.Dv, composer, 0);
                boolean Z4 = composer.Z(function1);
                Object objG4 = composer.G();
                if (Z4 || objG4 == Composer.f23746a.a()) {
                    objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.d1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BaseSelectionScreenKt.R0(function1);
                        }
                    };
                    composer.w(objG4);
                }
                ComposeButtonsKt.q0(modifierM2, imageVectorB, null, false, 0.0f, 0.0f, 0L, strB2, (Function0) objG4, composer, 0, 124);
                composer.U();
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
    public static final Unit O0(BaseSelectionViewState baseSelectionViewState, Function1 function1, MutableState mutableState) {
        if (baseSelectionViewState.c().c()) {
            function1.invoke(new BaseSelectionViewEvent.OnAppSearchStateChanged(false));
            K0(mutableState, "");
        } else {
            function1.invoke(BaseSelectionViewEvent.OnBackButtonClicked.f118203a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(Function1 function1, MutableState mutableState, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        function1.invoke(new BaseSelectionViewEvent.OnAppSearchStateChanged(false));
        K0(mutableState, "");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(Function1 function1, MutableState mutableState, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        K0(mutableState, text);
        function1.invoke(new BaseSelectionViewEvent.OnApplicationSearchTextChanged(text));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(Function1 function1) {
        function1.invoke(new BaseSelectionViewEvent.OnAppSearchStateChanged(true));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(Function1 function1) {
        function1.invoke(new BaseSelectionViewEvent.OnSaveButtonClicked(true));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(Modifier modifier, BaseSelectionViewState baseSelectionViewState, ScaffoldState scaffoldState, Function1 function1, MutableState mutableState, ScheduleDescriptor scheduleDescriptor, float f3, int i3, int i4, Composer composer, int i5) {
        I0(modifier, baseSelectionViewState, scaffoldState, function1, mutableState, scheduleDescriptor, f3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void U0(final BaseSelectionViewState viewState, final CoroutineScope scope, final ScaffoldState scaffoldState, final Function1 onEvent, final MutableState showContainsAppBlockErrorDialog, final boolean z2, final ModalBottomSheetState bottomSheetState, final PagerState pagerState, final ImmutableList listStates, String str, TabItem[] tabItemArr, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        boolean z3;
        TabItem[] tabItemArr2;
        int i7;
        Composer composer2;
        final TabItem[] tabItemArr3;
        final String str2;
        final TabItem[] tabItemArr4;
        String str3;
        int i8;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(scaffoldState, "scaffoldState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(showContainsAppBlockErrorDialog, "showContainsAppBlockErrorDialog");
        Intrinsics.checkNotNullParameter(bottomSheetState, "bottomSheetState");
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Intrinsics.checkNotNullParameter(listStates, "listStates");
        Composer composerK = composer.k(-973260555);
        if ((i3 & 6) == 0) {
            i6 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        if ((i3 & 48) == 0) {
            i6 |= composerK.I(scope) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i6 |= composerK.Z(scaffoldState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i6 |= composerK.I(onEvent) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i6 |= composerK.Z(showContainsAppBlockErrorDialog) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            z3 = z2;
            i6 |= composerK.b(z3) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            z3 = z2;
        }
        if ((i3 & 1572864) == 0) {
            i6 |= (i3 & 2097152) == 0 ? composerK.Z(bottomSheetState) : composerK.I(bottomSheetState) ? 1048576 : 524288;
        }
        if ((i3 & 12582912) == 0) {
            i6 |= composerK.Z(pagerState) ? 8388608 : 4194304;
        }
        if ((i3 & 100663296) == 0) {
            i6 |= composerK.Z(listStates) ? 67108864 : 33554432;
        }
        int i9 = i5 & 512;
        if (i9 != 0) {
            i6 |= 805306368;
        } else if ((i3 & 805306368) == 0) {
            i6 |= composerK.Z(str) ? 536870912 : 268435456;
        }
        if ((i4 & 6) == 0) {
            if ((i5 & 1024) == 0) {
                tabItemArr2 = tabItemArr;
                int i10 = composerK.I(tabItemArr2) ? 4 : 2;
                i7 = i4 | i10;
            } else {
                tabItemArr2 = tabItemArr;
            }
            i7 = i4 | i10;
        } else {
            tabItemArr2 = tabItemArr;
            i7 = i4;
        }
        if (composerK.r(((i6 & 306783379) == 306783378 && (i7 & 3) == 2) ? false : true, i6 & 1)) {
            composerK.J();
            if ((i3 & 1) == 0 || composerK.S()) {
                String str4 = i9 != 0 ? null : str;
                if ((i5 & 1024) != 0) {
                    i7 &= -15;
                    str3 = str4;
                    tabItemArr4 = (TabItem[]) TabItem.getEntries().toArray(new TabItem[0]);
                } else {
                    tabItemArr4 = tabItemArr2;
                    str3 = str4;
                }
                i8 = i7;
            } else {
                composerK.Q();
                if ((i5 & 1024) != 0) {
                    i7 &= -15;
                }
                tabItemArr4 = tabItemArr2;
                i8 = i7;
                str3 = str;
            }
            composerK.z();
            if (ComposerKt.M()) {
                ComposerKt.U(-973260555, i6, i8, "cz.mobilesoft.coreblock.scene.selection.base.RootCompose (BaseSelectionScreen.kt:305)");
            }
            int i11 = i6;
            final TabItem[] tabItemArr5 = tabItemArr4;
            final String str5 = str3;
            final boolean z4 = z3;
            composer2 = composerK;
            ComposeDialogsKt.n1(ComposableLambdaKt.e(779864813, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.selection.base.g1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BaseSelectionScreenKt.V0(bottomSheetState, scope, viewState, onEvent, tabItemArr4, pagerState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), null, bottomSheetState, null, 0.0f, 0L, 0L, 0L, ComposableLambdaKt.e(450509157, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.k1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseSelectionScreenKt.Y0(str5, viewState, tabItemArr5, pagerState, scope, scaffoldState, z4, bottomSheetState, listStates, onEvent, showContainsAppBlockErrorDialog, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composer2, (ModalBottomSheetState.f13222e << 6) | 100663302 | ((i11 >> 12) & 896), 250);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            str2 = str5;
            tabItemArr3 = tabItemArr5;
        } else {
            composer2 = composerK;
            composer2.Q();
            tabItemArr3 = tabItemArr2;
            str2 = str;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.l1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseSelectionScreenKt.a1(viewState, scope, scaffoldState, onEvent, showContainsAppBlockErrorDialog, z2, bottomSheetState, pagerState, listStates, str2, tabItemArr3, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(final ModalBottomSheetState modalBottomSheetState, final CoroutineScope coroutineScope, final BaseSelectionViewState baseSelectionViewState, final Function1 function1, final TabItem[] tabItemArr, final PagerState pagerState, ColumnScope ThemedBottomSheetLayout, Composer composer, int i3) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(ThemedBottomSheetLayout, "$this$ThemedBottomSheetLayout");
        if (composer2.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(779864813, i3, -1, "cz.mobilesoft.coreblock.scene.selection.base.RootCompose.<anonymous> (BaseSelectionScreen.kt:308)");
            }
            if (modalBottomSheetState.e() != ModalBottomSheetValue.Hidden) {
                composer2.a0(1474659309);
                ComposableLambda composableLambdaE = ComposableLambdaKt.e(1179041769, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.selection.base.m1
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return BaseSelectionScreenKt.W0(baseSelectionViewState, modalBottomSheetState, tabItemArr, pagerState, function1, coroutineScope, (ColumnScope) obj, (SheetState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer2, 54);
                boolean zI = composer2.I(coroutineScope) | composer2.Z(baseSelectionViewState) | composer2.Z(function1) | composer2.I(modalBottomSheetState);
                Object objG = composer2.G();
                if (zI || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.n1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BaseSelectionScreenKt.X0(coroutineScope, baseSelectionViewState, function1, modalBottomSheetState);
                        }
                    };
                    composer2.w(objG);
                }
                ComposeBottomSheetsKt.f(null, null, true, composableLambdaE, null, (Function0) objG, composer, 3456, 19);
                composer2 = composer;
            } else {
                composer2.a0(1460605397);
            }
            composer2.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(BaseSelectionViewState baseSelectionViewState, ModalBottomSheetState modalBottomSheetState, TabItem[] tabItemArr, PagerState pagerState, Function1 function1, CoroutineScope coroutineScope, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1179041769, i3, -1, "cz.mobilesoft.coreblock.scene.selection.base.RootCompose.<anonymous>.<anonymous> (BaseSelectionScreen.kt:312)");
            }
            s0(baseSelectionViewState, modalBottomSheetState, tabItemArr[pagerState.v()], function1, coroutineScope, composer, ModalBottomSheetState.f13222e << 3);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(CoroutineScope coroutineScope, BaseSelectionViewState baseSelectionViewState, Function1 function1, ModalBottomSheetState modalBottomSheetState) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new BaseSelectionScreenKt$RootCompose$1$2$1$1(baseSelectionViewState, function1, modalBottomSheetState, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(String str, final BaseSelectionViewState baseSelectionViewState, final TabItem[] tabItemArr, final PagerState pagerState, CoroutineScope coroutineScope, final ScaffoldState scaffoldState, boolean z2, ModalBottomSheetState modalBottomSheetState, final ImmutableList immutableList, final Function1 function1, final MutableState mutableState, Composer composer, int i3) {
        String str2;
        String strB;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(450509157, i3, -1, "cz.mobilesoft.coreblock.scene.selection.base.RootCompose.<anonymous> (BaseSelectionScreen.kt:333)");
            }
            if (str == null) {
                if (baseSelectionViewState.d() == Profile.BlockingMode.Blocklist) {
                    composer.a0(-852386516);
                    strB = StringResources_androidKt.b(R.string.A4, composer, 0);
                    composer.U();
                } else if (ArraysKt.singleOrNull(tabItemArr) == TabItem.Webs) {
                    composer.a0(-852383311);
                    strB = StringResources_androidKt.b(R.string.Nv, composer, 0);
                    composer.U();
                } else {
                    composer.a0(-852380980);
                    strB = StringResources_androidKt.b(R.string.A0, composer, 0);
                    composer.U();
                }
                str2 = strB;
            } else {
                str2 = str;
            }
            BaseSelectionScreenScaffoldKt.O(coroutineScope, scaffoldState, pagerState, z2, modalBottomSheetState, str2, baseSelectionViewState, tabItemArr, tabItemArr[pagerState.v()], immutableList, function1, ComposableLambdaKt.e(-1816175166, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.selection.base.o1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BaseSelectionScreenKt.Z0(baseSelectionViewState, pagerState, scaffoldState, immutableList, function1, mutableState, tabItemArr, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, ModalBottomSheetState.f13222e << 12, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(BaseSelectionViewState baseSelectionViewState, PagerState pagerState, ScaffoldState scaffoldState, ImmutableList immutableList, Function1 function1, MutableState mutableState, TabItem[] tabItemArr, PaddingValues it, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(it) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1816175166, i4, -1, "cz.mobilesoft.coreblock.scene.selection.base.RootCompose.<anonymous>.<anonymous> (BaseSelectionScreen.kt:350)");
            }
            if (Intrinsics.areEqual(baseSelectionViewState.o(), Loading.f127895a)) {
                composer.a0(-1971271695);
                LoadingContentKt.b(PaddingKt.h(Modifier.b8, it), null, composer, 0, 2);
                composer.U();
            } else {
                composer.a0(-1971040373);
                F0(PaddingKt.h(Modifier.b8, it), pagerState, baseSelectionViewState, scaffoldState, immutableList, function1, mutableState, tabItemArr, composer, 0, 0);
                composer.U();
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
    public static final Unit a1(BaseSelectionViewState baseSelectionViewState, CoroutineScope coroutineScope, ScaffoldState scaffoldState, Function1 function1, MutableState mutableState, boolean z2, ModalBottomSheetState modalBottomSheetState, PagerState pagerState, ImmutableList immutableList, String str, TabItem[] tabItemArr, int i3, int i4, int i5, Composer composer, int i6) {
        U0(baseSelectionViewState, coroutineScope, scaffoldState, function1, mutableState, z2, modalBottomSheetState, pagerState, immutableList, str, tabItemArr, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4), i5);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue c0(MutableState mutableState) {
        return (TextFieldValue) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0068 A[EDGE_INSN: B:20:0x0068->B:15:0x0068 BREAK  A[LOOP:0: B:8:0x0032->B:16:0x006d], PHI: r7
      0x0068: PHI (r7v1 androidx.compose.runtime.MutableState) = 
      (r7v0 androidx.compose.runtime.MutableState)
      (r7v0 androidx.compose.runtime.MutableState)
      (r7v3 androidx.compose.runtime.MutableState)
      (r7v3 androidx.compose.runtime.MutableState)
     binds: [B:3:0x0019, B:5:0x0027, B:20:0x0068, B:13:0x0058] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.Unit d0(cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState r2, androidx.compose.material.ScaffoldState r3, androidx.compose.runtime.snapshots.SnapshotStateMap r4, kotlin.jvm.functions.Function1 r5, final androidx.compose.runtime.MutableState r6, androidx.compose.runtime.MutableState r7, final androidx.compose.runtime.MutableState r8, final androidx.compose.runtime.MutableState r9, androidx.compose.foundation.lazy.LazyListScope r10) {
        /*
            java.lang.String r0 = "$this$LazyColumn"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState$ApplicationViewState r0 = r2.c()
            java.util.Map r0 = r0.e()
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState$ApplicationViewState r1 = r2.c()
            java.util.Map r1 = r1.d()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L68
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState$ApplicationViewState r0 = r2.c()
            java.util.Map r0 = r0.d()
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L2a
            goto L68
        L2a:
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L32:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L68
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r1 = r1.getValue()
            cz.mobilesoft.coreblock.scene.selection.ApplicationStateDTO r1 = (cz.mobilesoft.coreblock.scene.selection.ApplicationStateDTO) r1
            cz.mobilesoft.coreblock.dto.ApplicationDTO r1 = r1.c()
            java.util.List r1 = r1.c()
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L6d
            boolean r0 = r2.g()
            if (r0 == 0) goto L68
            r1 = r7
            cz.mobilesoft.coreblock.scene.selection.base.j0 r7 = new cz.mobilesoft.coreblock.scene.selection.base.j0
            r7.<init>()
            r6 = r5
            r5 = r4
            r4 = r2
            r2 = r10
            j1(r2, r3, r4, r5, r6, r7)
            goto L7b
        L68:
            r4 = r2
            r2 = r5
            r1 = r7
            r5 = r10
            goto L73
        L6d:
            r1 = r7
            r7 = r4
            r4 = r2
            r4 = r7
            r7 = r1
            goto L32
        L73:
            cz.mobilesoft.coreblock.scene.selection.base.l0 r7 = new cz.mobilesoft.coreblock.scene.selection.base.l0
            r7.<init>()
            d1(r5, r3, r4, r2, r7)
        L7b:
            kotlin.Unit r2 = kotlin.Unit.f139807a
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionScreenKt.d0(cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState, androidx.compose.material.ScaffoldState, androidx.compose.runtime.snapshots.SnapshotStateMap, kotlin.jvm.functions.Function1, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.runtime.MutableState, androidx.compose.foundation.lazy.LazyListScope):kotlin.Unit");
    }

    private static final void d1(LazyListScope lazyListScope, final ScaffoldState scaffoldState, final BaseSelectionViewState baseSelectionViewState, final Function1 function1, final Function3 function3) {
        Iterator it = baseSelectionViewState.c().e().entrySet().iterator();
        while (it.hasNext()) {
            final ApplicationStateDTO applicationStateDTO = (ApplicationStateDTO) ((Map.Entry) it.next()).getValue();
            final RelationDTO relationDTOL = baseSelectionViewState.l(applicationStateDTO.c().f());
            LazyListScope.c(lazyListScope, null, null, ComposableLambdaKt.c(624559171, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.selection.base.u0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BaseSelectionScreenKt.e1(baseSelectionViewState, scaffoldState, applicationStateDTO, function1, relationDTOL, function3, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, String text, boolean z2, ApplicationDTO application) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(application, "application");
        m0(mutableState3, TextFieldValue.e(c0(mutableState3), text, 0L, null, 6, null));
        o0(mutableState4, z2);
        mutableState.setValue(Boolean.TRUE);
        mutableState2.setValue(application);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(BaseSelectionViewState baseSelectionViewState, ScaffoldState scaffoldState, final ApplicationStateDTO applicationStateDTO, final Function1 function1, final RelationDTO relationDTO, final Function3 function3, LazyItemScope item, Composer composer, int i3) throws XmlPullParserException, IOException {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(624559171, i3, -1, "cz.mobilesoft.coreblock.scene.selection.base.applicationsContent.<anonymous>.<anonymous> (BaseSelectionScreen.kt:875)");
            }
            Profile.BlockingMode blockingModeD = baseSelectionViewState.d();
            PremiumState premiumStateK = baseSelectionViewState.k();
            if (baseSelectionViewState.r()) {
                composer.a0(-1093970901);
                composer.U();
                listEmptyList = CollectionsKt.emptyList();
            } else {
                composer.a0(444914049);
                listEmptyList = new ArrayList();
                if (relationDTO == null) {
                    composer.a0(-70115039);
                    String strB = StringResources_androidKt.b(R.string.U, composer, 0);
                    long jB = ComposeColorsKt.j(composer, 0).b();
                    ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.T6, composer, 6);
                    Color colorN = Color.n(jB);
                    boolean Z = composer.Z(function3) | composer.I(applicationStateDTO);
                    Object objG = composer.G();
                    if (Z || objG == Composer.f23746a.a()) {
                        objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.w0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return BaseSelectionScreenKt.f1(function3, applicationStateDTO);
                            }
                        };
                        composer.w(objG);
                    }
                    listEmptyList.add(new ComposeDropdownItem(strB, colorN, null, false, null, null, imageVectorB, null, (Function0) objG, 188, null));
                    composer.U();
                } else {
                    if (relationDTO.c()) {
                        composer.a0(-111140129);
                    } else {
                        composer.a0(-69383098);
                        String strB2 = StringResources_androidKt.b(R.string.Qc, composer, 0);
                        long jB2 = ComposeColorsKt.j(composer, 0).b();
                        ImageVector imageVectorB2 = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.W1, composer, 6);
                        boolean zG = applicationStateDTO.c().g();
                        Color colorN2 = Color.n(jB2);
                        Boolean bool = Boolean.TRUE;
                        boolean Z2 = composer.Z(function3) | composer.Z(relationDTO) | composer.I(applicationStateDTO);
                        Object objG2 = composer.G();
                        if (Z2 || objG2 == Composer.f23746a.a()) {
                            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.x0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return BaseSelectionScreenKt.g1(function3, relationDTO, applicationStateDTO);
                                }
                            };
                            composer.w(objG2);
                        }
                        listEmptyList.add(new ComposeDropdownItem(strB2, colorN2, null, zG, bool, null, imageVectorB2, null, (Function0) objG2, 164, null));
                    }
                    composer.U();
                }
                composer.U();
            }
            boolean Z3 = composer.Z(function1) | composer.I(applicationStateDTO);
            Object objG3 = composer.G();
            if (Z3 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.y0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseSelectionScreenKt.h1(function1, applicationStateDTO, ((Boolean) obj).booleanValue());
                    }
                };
                composer.w(objG3);
            }
            Function1 function12 = (Function1) objG3;
            boolean Z4 = composer.Z(function1) | composer.I(applicationStateDTO);
            Object objG4 = composer.G();
            if (Z4 || objG4 == Composer.f23746a.a()) {
                objG4 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.z0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BaseSelectionScreenKt.i1(function1, applicationStateDTO, (SubAppStateDTO) obj, ((Boolean) obj2).booleanValue());
                    }
                };
                composer.w(objG4);
            }
            ApplicationItemKt.m(null, scaffoldState, applicationStateDTO, function12, false, blockingModeD, (Function2) objG4, premiumStateK, listEmptyList, composer, (ApplicationStateDTO.f118052c << 6) | 24576, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, String text, boolean z2, ApplicationDTO application) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(application, "application");
        m0(mutableState3, TextFieldValue.e(c0(mutableState3), text, 0L, null, 6, null));
        o0(mutableState4, z2);
        mutableState.setValue(Boolean.TRUE);
        mutableState2.setValue(application);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(Function3 function3, ApplicationStateDTO applicationStateDTO) {
        function3.invoke("", Boolean.TRUE, applicationStateDTO.c());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(Function1 function1) {
        function1.invoke(BaseSelectionViewEvent.BlockingSelectViewEvent.OnForceBlockAppBlockClicked.f118194a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1(Function3 function3, RelationDTO relationDTO, ApplicationStateDTO applicationStateDTO) {
        function3.invoke(relationDTO.a(), Boolean.FALSE, applicationStateDTO.c());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(MutableState mutableState, Function1 function1, MutableState mutableState2) {
        ApplicationDTO applicationDTO = (ApplicationDTO) mutableState.getValue();
        if (applicationDTO != null) {
            function1.invoke(new BaseSelectionViewEvent.OnEditRelationClicked(applicationDTO, c0(mutableState2).i()));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h1(Function1 function1, ApplicationStateDTO applicationStateDTO, boolean z2) {
        function1.invoke(new BaseSelectionViewEvent.OnApplicationsSelected(CollectionsKt.listOf(applicationStateDTO), z2, null, 4, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(MutableState mutableState, MutableState mutableState2) {
        m0(mutableState2, TextFieldValue.e(c0(mutableState2), "", 0L, null, 6, null));
        mutableState.setValue(null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i1(Function1 function1, ApplicationStateDTO applicationStateDTO, SubAppStateDTO subApp, boolean z2) {
        Intrinsics.checkNotNullParameter(subApp, "subApp");
        function1.invoke(new BaseSelectionViewEvent.OnSubAppSelected(subApp, z2, applicationStateDTO.c().h()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(MutableState mutableState, TextFieldValue it) {
        Intrinsics.checkNotNullParameter(it, "it");
        m0(mutableState, it);
        return Unit.f139807a;
    }

    private static final void j1(LazyListScope lazyListScope, final ScaffoldState scaffoldState, final BaseSelectionViewState baseSelectionViewState, final Map map, final Function1 function1, final Function3 function3) {
        EnumEntries<Category> entries = Category.getEntries();
        ArrayList arrayList = new ArrayList();
        for (Category category : entries) {
            if (category != Category.NOT_FOUND) {
                arrayList.add(category);
            }
        }
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            final Category category2 = (Category) obj;
            LazyListScope.c(lazyListScope, category2, null, ComposableLambdaKt.c(-395992792, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.selection.base.t0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return BaseSelectionScreenKt.k1(map, category2, baseSelectionViewState, function1, scaffoldState, function3, (LazyItemScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k0(BaseSelectionViewState baseSelectionViewState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return baseSelectionViewState.p().p(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:132:0x051f  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0527  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x055c  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x056c  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0599  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x063c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0083 A[EDGE_INSN: B:176:0x0083->B:28:0x0083 BREAK  A[LOOP:5: B:21:0x0060->B:177:?]] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x03b6 A[EDGE_INSN: B:173:0x03b6->B:93:0x03b6 BREAK  A[LOOP:4: B:84:0x0379->B:174:?]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.Unit k1(final java.util.Map r34, final cz.mobilesoft.coreblock.dto.Category r35, final cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState r36, final kotlin.jvm.functions.Function1 r37, final androidx.compose.material.ScaffoldState r38, final kotlin.jvm.functions.Function3 r39, androidx.compose.foundation.lazy.LazyItemScope r40, androidx.compose.runtime.Composer r41, int r42) {
        /*
            Method dump skipped, instruction units count: 1606
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionScreenKt.k1(java.util.Map, cz.mobilesoft.coreblock.dto.Category, cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState, kotlin.jvm.functions.Function1, androidx.compose.material.ScaffoldState, kotlin.jvm.functions.Function3, androidx.compose.foundation.lazy.LazyItemScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(BaseSelectionViewState baseSelectionViewState, Function1 function1, LazyListState lazyListState, ScaffoldState scaffoldState, MutableState mutableState, int i3, Composer composer, int i4) {
        b0(baseSelectionViewState, function1, lazyListState, scaffoldState, mutableState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l1(Map map, Category category, boolean z2) {
        map.put(category, Boolean.valueOf(!z2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(MutableState mutableState, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m1(Map map, Category category, boolean z2) {
        map.put(category, Boolean.valueOf(!z2));
        return Unit.f139807a;
    }

    private static final boolean n0(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n1(Map map, Category category, boolean z2) {
        map.put(category, Boolean.valueOf(!z2));
        return Unit.f139807a;
    }

    private static final void o0(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o1(Function1 function1, List list, boolean z2, Category category) {
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add((ApplicationStateDTO) ((Map.Entry) it.next()).getValue());
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            if (((ApplicationStateDTO) obj).c().h() != (!z2)) {
                arrayList2.add(obj);
            }
        }
        function1.invoke(new BaseSelectionViewEvent.OnApplicationsSelected(arrayList2, !z2, category));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void p0(final cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel r28, final cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState r29, java.lang.String r30, final cz.mobilesoft.coreblock.scene.selection.components.TabItem[] r31, final kotlin.jvm.functions.Function4 r32, final kotlin.jvm.functions.Function0 r33, final boolean r34, boolean r35, boolean r36, cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor r37, float r38, androidx.compose.runtime.Composer r39, final int r40, final int r41, final int r42) {
        /*
            Method dump skipped, instruction units count: 802
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionScreenKt.p0(cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel, cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState, java.lang.String, cz.mobilesoft.coreblock.scene.selection.components.TabItem[], kotlin.jvm.functions.Function4, kotlin.jvm.functions.Function0, boolean, boolean, boolean, cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor, float, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p1(List list, BaseSelectionViewState baseSelectionViewState, ScaffoldState scaffoldState, final Function1 function1, final Function3 function3, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) throws XmlPullParserException, IOException {
        List listEmptyList;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(-871281840, i3, -1, "cz.mobilesoft.coreblock.scene.selection.base.categoriesContent.<anonymous>.<anonymous>.<anonymous> (BaseSelectionScreen.kt:804)");
        }
        Modifier modifierD = BackgroundKt.d(Modifier.b8, ComposeColorsKt.j(composer2, 0).j(), null, 2, null);
        MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer2, 0);
        int iA = ComposablesKt.a(composer2, 0);
        CompositionLocalMap compositionLocalMapU = composer2.u();
        Modifier modifierF = ComposedModifierKt.f(composer2, modifierD);
        ComposeUiNode.Companion companion = ComposeUiNode.f8;
        Function0 function0A = companion.a();
        if (composer2.m() == null) {
            ComposablesKt.c();
        }
        composer2.L();
        if (composer2.i()) {
            composer2.P(function0A);
        } else {
            composer2.v();
        }
        Composer composerA = Updater.a(composer2);
        Updater.e(composerA, measurePolicyA, companion.e());
        Updater.e(composerA, compositionLocalMapU, companion.g());
        Function2 function2B = companion.b();
        if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
            composerA.w(Integer.valueOf(iA));
            composerA.p(Integer.valueOf(iA), function2B);
        }
        Updater.e(composerA, modifierF, companion.f());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
        composer2.a0(1875062995);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final ApplicationStateDTO applicationStateDTO = (ApplicationStateDTO) ((Map.Entry) it.next()).getValue();
            final RelationDTO relationDTOL = baseSelectionViewState.l(applicationStateDTO.c().f());
            Profile.BlockingMode blockingModeD = baseSelectionViewState.d();
            PremiumState premiumStateK = baseSelectionViewState.k();
            if (baseSelectionViewState.r()) {
                composer2.a0(17624391);
                composer2.U();
                listEmptyList = CollectionsKt.emptyList();
            } else {
                composer2.a0(544306837);
                listEmptyList = new ArrayList();
                if (relationDTOL == null) {
                    composer2.a0(2098152577);
                    String strB = StringResources_androidKt.b(R.string.U, composer2, 0);
                    long jB = ComposeColorsKt.j(composer2, 0).b();
                    ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.T6, composer2, 6);
                    Color colorN = Color.n(jB);
                    boolean Z = composer2.Z(function3) | composer2.I(applicationStateDTO);
                    Object objG = composer2.G();
                    if (Z || objG == Composer.f23746a.a()) {
                        objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.o
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return BaseSelectionScreenKt.q1(function3, applicationStateDTO);
                            }
                        };
                        composer2.w(objG);
                    }
                    listEmptyList.add(new ComposeDropdownItem(strB, colorN, null, false, null, null, imageVectorB, null, (Function0) objG, 188, null));
                    composer2.U();
                } else {
                    if (relationDTOL.c()) {
                        composer2.a0(2060684675);
                    } else {
                        composer2.a0(2099016206);
                        String strB2 = StringResources_androidKt.b(R.string.Qc, composer2, 0);
                        long jB2 = ComposeColorsKt.j(composer2, 0).b();
                        ImageVector imageVectorB2 = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.W1, composer2, 6);
                        boolean zG = applicationStateDTO.c().g();
                        Color colorN2 = Color.n(jB2);
                        Boolean bool = Boolean.TRUE;
                        boolean Z2 = composer2.Z(function3) | composer2.Z(relationDTOL) | composer2.I(applicationStateDTO);
                        Object objG2 = composer2.G();
                        if (Z2 || objG2 == Composer.f23746a.a()) {
                            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.z
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return BaseSelectionScreenKt.r1(function3, relationDTOL, applicationStateDTO);
                                }
                            };
                            composer2.w(objG2);
                        }
                        listEmptyList.add(new ComposeDropdownItem(strB2, colorN2, null, zG, bool, null, imageVectorB2, null, (Function0) objG2, 164, null));
                    }
                    composer2.U();
                }
                composer2.U();
            }
            List list2 = listEmptyList;
            boolean Z3 = composer2.Z(function1) | composer2.I(applicationStateDTO);
            Object objG3 = composer2.G();
            if (Z3 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.k0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseSelectionScreenKt.s1(function1, applicationStateDTO, ((Boolean) obj).booleanValue());
                    }
                };
                composer2.w(objG3);
            }
            Function1 function12 = (Function1) objG3;
            boolean Z4 = composer2.Z(function1) | composer2.I(applicationStateDTO);
            Object objG4 = composer2.G();
            if (Z4 || objG4 == Composer.f23746a.a()) {
                objG4 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.v0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BaseSelectionScreenKt.t1(function1, applicationStateDTO, (SubAppStateDTO) obj, ((Boolean) obj2).booleanValue());
                    }
                };
                composer2.w(objG4);
            }
            ApplicationItemKt.m(null, scaffoldState, applicationStateDTO, function12, true, blockingModeD, (Function2) objG4, premiumStateK, list2, composer2, (ApplicationStateDTO.f118052c << 6) | 24576, 1);
            composer2 = composer;
        }
        composer.U();
        composer.y();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int q0(TabItem[] tabItemArr) {
        return tabItemArr.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q1(Function3 function3, ApplicationStateDTO applicationStateDTO) {
        function3.invoke("", Boolean.TRUE, applicationStateDTO.c());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r0(BaseSelectionViewModel baseSelectionViewModel, BaseSelectionViewState baseSelectionViewState, String str, TabItem[] tabItemArr, Function4 function4, Function0 function0, boolean z2, boolean z3, boolean z4, ScheduleDescriptor scheduleDescriptor, float f3, int i3, int i4, int i5, Composer composer, int i6) {
        p0(baseSelectionViewModel, baseSelectionViewState, str, tabItemArr, function4, function0, z2, z3, z4, scheduleDescriptor, f3, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4), i5);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r1(Function3 function3, RelationDTO relationDTO, ApplicationStateDTO applicationStateDTO) {
        function3.invoke(relationDTO.a(), Boolean.FALSE, applicationStateDTO.c());
        return Unit.f139807a;
    }

    public static final void s0(final BaseSelectionViewState viewState, final ModalBottomSheetState bottomSheetState, final TabItem selectedType, final Function1 onEvent, final CoroutineScope scope, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(bottomSheetState, "bottomSheetState");
        Intrinsics.checkNotNullParameter(selectedType, "selectedType");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Composer composerK = composer.k(1343433840);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= (i3 & 64) == 0 ? composerK.Z(bottomSheetState) : composerK.I(bottomSheetState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.e(selectedType.ordinal()) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onEvent) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(scope) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1343433840, i4, -1, "cz.mobilesoft.coreblock.scene.selection.base.BottomSheetContent (BaseSelectionScreen.kt:942)");
            }
            SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) composerK.q(CompositionLocalsKt.q());
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            int i5 = i4 & 7168;
            boolean z2 = (i5 == 2048) | ((i4 & 896) == 256);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseSelectionScreenKt.t0(onEvent, selectedType, (ActivityResult) obj);
                    }
                };
                composerK.w(objG);
            }
            final ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG, composerK, 0);
            ModalBottomSheetValue modalBottomSheetValueE = bottomSheetState.e();
            int i6 = i4 & 112;
            boolean Z = (i6 == 32 || ((i4 & 64) != 0 && composerK.I(bottomSheetState))) | composerK.Z(softwareKeyboardController);
            Object objG2 = composerK.G();
            if (Z || objG2 == Composer.f23746a.a()) {
                objG2 = new BaseSelectionScreenKt$BottomSheetContent$1$1(bottomSheetState, softwareKeyboardController, null);
                composerK.w(objG2);
            }
            EffectsKt.g(modalBottomSheetValueE, (Function2) objG2, composerK, 0);
            BaseSelectionViewState.BottomSheetType bottomSheetTypeE = viewState.e();
            int i7 = bottomSheetTypeE == null ? -1 : WhenMappings.f118155a[bottomSheetTypeE.ordinal()];
            if (i7 == 1) {
                composerK.a0(-1745201140);
                ImmutableList immutableListQ = viewState.q();
                boolean z3 = i5 == 2048;
                Object objG3 = composerK.G();
                if (z3 || objG3 == Composer.f23746a.a()) {
                    objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.q
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BaseSelectionScreenKt.u0(onEvent);
                        }
                    };
                    composerK.w(objG3);
                }
                Function0 function0 = (Function0) objG3;
                z = i5 == 2048;
                Object objG4 = composerK.G();
                if (z || objG4 == Composer.f23746a.a()) {
                    objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.r
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BaseSelectionScreenKt.v0(onEvent);
                        }
                    };
                    composerK.w(objG4);
                }
                WebsitesForSelectedAppsBottomSheetKt.e(immutableListQ, bottomSheetState, scope, function0, (Function0) objG4, composerK, ((i4 >> 6) & 896) | (ModalBottomSheetState.f13222e << 3) | i6);
                composerK.U();
            } else if (i7 == 2) {
                composerK.a0(-1745181760);
                boolean zI = composerK.I(managedActivityResultLauncherA);
                Object objG5 = composerK.G();
                if (zI || objG5 == Composer.f23746a.a()) {
                    objG5 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.s
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BaseSelectionScreenKt.w0(managedActivityResultLauncherA);
                        }
                    };
                    composerK.w(objG5);
                }
                D0(viewState, selectedType, (Function0) objG5, composerK, (i4 & 14) | ((i4 >> 3) & 112));
                composerK.U();
            } else if (i7 != 3) {
                composerK.a0(1735038992);
                composerK.U();
            } else {
                composerK.a0(-1745165371);
                ImmutableList immutableListF = viewState.f();
                boolean zI2 = (i5 == 2048) | composerK.I(scope) | (i6 == 32 || ((i4 & 64) != 0 && composerK.I(bottomSheetState)));
                Object objG6 = composerK.G();
                if (zI2 || objG6 == Composer.f23746a.a()) {
                    objG6 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.t
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BaseSelectionScreenKt.x0(onEvent, scope, bottomSheetState);
                        }
                    };
                    composerK.w(objG6);
                }
                Function0 function02 = (Function0) objG6;
                boolean zI3 = (i5 == 2048) | composerK.I(scope);
                if (i6 == 32 || ((i4 & 64) != 0 && composerK.I(bottomSheetState))) {
                    z = true;
                }
                boolean z4 = zI3 | z;
                Object objG7 = composerK.G();
                if (z4 || objG7 == Composer.f23746a.a()) {
                    objG7 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.u
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BaseSelectionScreenKt.y0(onEvent, scope, bottomSheetState, (List) obj);
                        }
                    };
                    composerK.w(objG7);
                }
                BrowsersForWebAllowlistBottomSheetKt.l(immutableListF, function02, (Function1) objG7, composerK, WebAllowlistBrowserItem.f96957d);
                composerK.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseSelectionScreenKt.z0(viewState, bottomSheetState, selectedType, onEvent, scope, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s1(Function1 function1, ApplicationStateDTO applicationStateDTO, boolean z2) {
        function1.invoke(new BaseSelectionViewEvent.OnApplicationsSelected(CollectionsKt.listOf(applicationStateDTO), z2, null, 4, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(Function1 function1, TabItem tabItem, ActivityResult result) {
        Uri data;
        Intrinsics.checkNotNullParameter(result, "result");
        Intent intentC = result.c();
        if (intentC != null && (data = intentC.getData()) != null) {
            function1.invoke(new BaseSelectionViewEvent.BlockingSelectViewEvent.OnCsvImported(data, tabItem == TabItem.Webs ? WebsiteProfileRelation.BlockingType.DOMAIN : WebsiteProfileRelation.BlockingType.KEYWORD));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t1(Function1 function1, ApplicationStateDTO applicationStateDTO, SubAppStateDTO subApp, boolean z2) {
        Intrinsics.checkNotNullParameter(subApp, "subApp");
        function1.invoke(new BaseSelectionViewEvent.OnSubAppSelected(subApp, z2, applicationStateDTO.c().h()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(Function1 function1) {
        function1.invoke(new BaseSelectionViewEvent.BlockingSelectViewEvent.OnBlockWebsitesForSelectedAppsClicked(false));
        return Unit.f139807a;
    }

    public static final List u1(Map map, Category category) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(category, "category");
        Set setEntrySet = map.entrySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setEntrySet) {
            List listC = ((ApplicationStateDTO) ((Map.Entry) obj).getValue()).c().c();
            Category category2 = Category.OTHER;
            if ((category == category2 && (listC.isEmpty() || listC.contains(category2) || listC.contains(Category.NOT_FOUND))) || listC.contains(category)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(Function1 function1) {
        function1.invoke(new BaseSelectionViewEvent.BlockingSelectViewEvent.OnBlockWebsitesForSelectedAppsClicked(true));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(ManagedActivityResultLauncher managedActivityResultLauncher) {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("text/*");
        managedActivityResultLauncher.b(intent);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(Function1 function1, CoroutineScope coroutineScope, ModalBottomSheetState modalBottomSheetState) {
        function1.invoke(new BaseSelectionViewEvent.BlockingSelectViewEvent.OnBrowsersForWebAllowlistClicked(false, null, 2, null));
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new BaseSelectionScreenKt$BottomSheetContent$5$1$1(modalBottomSheetState, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(Function1 function1, CoroutineScope coroutineScope, ModalBottomSheetState modalBottomSheetState, List packageNames) {
        Intrinsics.checkNotNullParameter(packageNames, "packageNames");
        function1.invoke(new BaseSelectionViewEvent.BlockingSelectViewEvent.OnBrowsersForWebAllowlistClicked(true, packageNames));
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new BaseSelectionScreenKt$BottomSheetContent$6$1$1(modalBottomSheetState, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(BaseSelectionViewState baseSelectionViewState, ModalBottomSheetState modalBottomSheetState, TabItem tabItem, Function1 function1, CoroutineScope coroutineScope, int i3, Composer composer, int i4) {
        s0(baseSelectionViewState, modalBottomSheetState, tabItem, function1, coroutineScope, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void b0(final BaseSelectionViewState baseSelectionViewState, final Function1 onEvent, final LazyListState lazyListState, final ScaffoldState scaffoldState, MutableState showContainsAppBlockErrorDialog, Composer composer, final int i3) {
        int i4;
        final Function1 function1;
        Composer composer2;
        MutableState mutableState;
        final BaseSelectionViewState baseSelectionViewState2;
        int i5;
        boolean z2;
        int i6;
        final MutableState mutableState2;
        MutableState mutableState3;
        MutableState mutableState4;
        final MutableState mutableState5;
        final MutableState mutableState6;
        Intrinsics.checkNotNullParameter(baseSelectionViewState, vfptEEmYY.QfKrTRdochft);
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Intrinsics.checkNotNullParameter(scaffoldState, "scaffoldState");
        Intrinsics.checkNotNullParameter(showContainsAppBlockErrorDialog, "showContainsAppBlockErrorDialog");
        Composer composerK = composer.k(504934958);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(baseSelectionViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(lazyListState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(scaffoldState) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.Z(showContainsAppBlockErrorDialog) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        int i7 = i4;
        if (composerK.r((i7 & 9363) != 9362, i7 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(504934958, i7, -1, "cz.mobilesoft.coreblock.scene.selection.base.ApplicationSelectScreen (BaseSelectionScreen.kt:612)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(new TextFieldValue("", 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState7 = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG2);
            }
            final MutableState mutableState8 = (MutableState) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
                composerK.w(objG3);
            }
            MutableState mutableState9 = (MutableState) objG3;
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG4);
            }
            final MutableState mutableState10 = (MutableState) objG4;
            Object objG5 = composerK.G();
            if (objG5 == companion.a()) {
                objG5 = new FocusRequester();
                composerK.w(objG5);
            }
            FocusRequester focusRequester = (FocusRequester) objG5;
            Object value = mutableState8.getValue();
            Object objG6 = composerK.G();
            if (objG6 == companion.a()) {
                objG6 = new BaseSelectionScreenKt$ApplicationSelectScreen$1$1(mutableState8, focusRequester, mutableState7, null);
                composerK.w(objG6);
            }
            EffectsKt.g(value, (Function2) objG6, composerK, 0);
            Object objG7 = composerK.G();
            if (objG7 == companion.a()) {
                objG7 = SnapshotStateKt.h();
                composerK.w(objG7);
            }
            final SnapshotStateMap snapshotStateMap = (SnapshotStateMap) objG7;
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = Arrangement.f6574a.o(Dp.g(0));
            Modifier modifierF = SizeKt.f(Modifier.b8, 0.0f, 1, null);
            int i8 = i7 & 14;
            int i9 = i7 & 112;
            boolean z3 = (i8 == 4) | ((i7 & 7168) == 2048) | (i9 == 32);
            Object objG8 = composerK.G();
            if (z3 || objG8 == companion.a()) {
                i5 = 32;
                z2 = false;
                i6 = i8;
                mutableState2 = mutableState9;
                Function1 function12 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.c0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseSelectionScreenKt.d0(baseSelectionViewState, scaffoldState, snapshotStateMap, onEvent, mutableState8, mutableState2, mutableState7, mutableState10, (LazyListScope) obj);
                    }
                };
                mutableState3 = mutableState8;
                mutableState4 = mutableState10;
                composerK.w(function12);
                objG8 = function12;
            } else {
                mutableState3 = mutableState8;
                mutableState2 = mutableState9;
                mutableState4 = mutableState10;
                i5 = 32;
                z2 = false;
                i6 = i8;
            }
            MutableState mutableState11 = mutableState2;
            function1 = onEvent;
            int i10 = i5;
            int i11 = i6;
            LazyDslKt.b(modifierF, lazyListState, null, false, horizontalOrVerticalO, null, null, false, null, (Function1) objG8, composerK, ((i7 >> 3) & 112) | 24582, 492);
            composer2 = composerK;
            boolean z4 = i9 == i10 ? true : z2;
            Object objG9 = composer2.G();
            if (z4 || objG9 == companion.a()) {
                objG9 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.d0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BaseSelectionScreenKt.g0(function1);
                    }
                };
                composer2.w(objG9);
            }
            int i12 = (i7 >> 12) & 14;
            mutableState = showContainsAppBlockErrorDialog;
            BlockingSelectScreenDialogsKt.o(mutableState, (Function0) objG9, composer2, i12);
            TextFieldValue textFieldValueC0 = c0(mutableState7);
            boolean zN0 = n0(mutableState4);
            boolean z5 = i9 == i10 ? true : z2;
            Object objG10 = composer2.G();
            if (z5 || objG10 == companion.a()) {
                mutableState5 = mutableState7;
                mutableState6 = mutableState11;
                objG10 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.e0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BaseSelectionScreenKt.h0(mutableState6, function1, mutableState5);
                    }
                };
                composer2.w(objG10);
            } else {
                mutableState5 = mutableState7;
                mutableState6 = mutableState11;
            }
            Function0 function0 = (Function0) objG10;
            Object objG11 = composer2.G();
            if (objG11 == companion.a()) {
                objG11 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.f0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BaseSelectionScreenKt.i0(mutableState6, mutableState5);
                    }
                };
                composer2.w(objG11);
            }
            Function0 function02 = (Function0) objG11;
            Object objG12 = composer2.G();
            if (objG12 == companion.a()) {
                objG12 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.g0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseSelectionScreenKt.j0(mutableState5, (TextFieldValue) obj);
                    }
                };
                composer2.w(objG12);
            }
            Function1 function13 = (Function1) objG12;
            boolean z6 = i11 == 4 ? true : z2;
            Object objG13 = composer2.G();
            if (z6 || objG13 == companion.a()) {
                baseSelectionViewState2 = baseSelectionViewState;
                objG13 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.h0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(BaseSelectionScreenKt.k0(baseSelectionViewState2, (String) obj));
                    }
                };
                composer2.w(objG13);
            } else {
                baseSelectionViewState2 = baseSelectionViewState;
            }
            BlockingSelectScreenDialogsKt.t(mutableState3, textFieldValueC0, zN0, focusRequester, function0, function02, function13, (Function1) objG13, composer2, 1772550, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function1 = onEvent;
            composer2 = composerK;
            mutableState = showContainsAppBlockErrorDialog;
            baseSelectionViewState2 = baseSelectionViewState;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            final MutableState mutableState12 = mutableState;
            final BaseSelectionViewState baseSelectionViewState3 = baseSelectionViewState2;
            final Function1 function14 = function1;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.base.i0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BaseSelectionScreenKt.l0(baseSelectionViewState3, function14, lazyListState, scaffoldState, mutableState12, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
