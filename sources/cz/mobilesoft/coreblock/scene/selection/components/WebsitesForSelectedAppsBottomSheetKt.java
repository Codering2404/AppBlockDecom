package cz.mobilesoft.coreblock.scene.selection.components;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.WebsiteDTO;
import cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.BaseWebsiteSelectionScreenKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
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
public final class WebsitesForSelectedAppsBottomSheetKt {
    public static final void e(final ImmutableList websites, final ModalBottomSheetState bottomSheetState, final CoroutineScope scope, Function0 onNotNowClicked, final Function0 onBlockClicked, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(websites, "websites");
        Intrinsics.checkNotNullParameter(bottomSheetState, "bottomSheetState");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(onNotNowClicked, "onNotNowClicked");
        Intrinsics.checkNotNullParameter(onBlockClicked, "onBlockClicked");
        Composer composerK = composer.k(-482170255);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(websites) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= (i3 & 64) == 0 ? composerK.Z(bottomSheetState) : composerK.I(bottomSheetState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(scope) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onNotNowClicked) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(onBlockClicked) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-482170255, i4, -1, "cz.mobilesoft.coreblock.scene.selection.components.WebsitesForSelectedAppsBottomSheet (WebsitesForSelectedAppsBottomSheet.kt:52)");
            }
            float fG = Dp.g(((Density) composerK.q(CompositionLocalsKt.f())).F((int) (((WindowInfo) composerK.q(CompositionLocalsKt.u())).a() & 4294967295L)) * 0.85f);
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierK = SizeKt.k(WindowInsetsPaddingKt.d(SizeKt.h(PaddingKt.i(companion, Dp.g(f3)), 0.0f, 1, null), WindowInsets_androidKt.b(WindowInsets.f7172a, composerK, 6)), 0.0f, fG, 1, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composerK, 0);
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            int i5 = i4;
            TextKt.c(StringResources_androidKt.b(R.string.jG, composerK, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).h(), composerK, 0, 0, 65534);
            float f4 = 12;
            TextKt.c(StringResources_androidKt.b(R.string.iG, composerK, 0), PaddingKt.m(companion, 0.0f, Dp.g(f4), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).b(), composerK, 48, 0, 65532);
            Modifier modifierA = columnScopeInstance.a(PaddingKt.m(SizeKt.h(companion, 0.0f, 1, null), 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null), 1.0f, false);
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = arrangement.o(Dp.g(f4));
            boolean z2 = (i5 & 14) == 4;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.components.g0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WebsitesForSelectedAppsBottomSheetKt.f(websites, (LazyListScope) obj);
                    }
                };
                composerK.w(objG);
            }
            LazyDslKt.b(modifierA, null, null, false, horizontalOrVerticalO, null, null, false, null, (Function1) objG, composerK, 24576, 494);
            composerK = composerK;
            Modifier modifierH = SizeKt.h(PaddingKt.m(companion, 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null), 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.o(Dp.g(f3)), companion2.l(), composerK, 6);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierH);
            Function0 function0A2 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A2);
            } else {
                composerK.v();
            }
            Composer composerA2 = Updater.a(composerK);
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            Modifier modifierC = RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null);
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.kl, composerK, 0), 0.0f, 11, null);
            ButtonColor.Light light = new ButtonColor.Light(false, null, false, null, null, 31, null);
            int i6 = i5 & 112;
            boolean zI = composerK.I(scope) | ((i5 & 7168) == 2048) | (i6 == 32 || ((i5 & 64) != 0 && composerK.I(bottomSheetState)));
            Object objG2 = composerK.G();
            if (zI || objG2 == Composer.f23746a.a()) {
                function0 = onNotNowClicked;
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.components.h0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return WebsitesForSelectedAppsBottomSheetKt.g(function0, scope, bottomSheetState);
                    }
                };
                composerK.w(objG2);
            } else {
                function0 = onNotNowClicked;
            }
            ComposeButtonsKt.i0(modifierC, big, light, (Function0) objG2, composerK, 0, 0);
            Modifier modifierC2 = RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null);
            boolean z3 = false;
            ButtonType.Big big2 = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.Eq, composerK, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 15, null);
            boolean zI2 = ((57344 & i5) == 16384) | composerK.I(scope);
            if (i6 == 32 || ((i5 & 64) != 0 && composerK.I(bottomSheetState))) {
                z3 = true;
            }
            boolean z4 = zI2 | z3;
            Object objG3 = composerK.G();
            if (z4 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.components.i0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return WebsitesForSelectedAppsBottomSheetKt.h(onBlockClicked, scope, bottomSheetState);
                    }
                };
                composerK.w(objG3);
            }
            ComposeButtonsKt.i0(modifierC2, big2, accent, (Function0) objG3, composerK, 0, 0);
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onNotNowClicked;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final Function0 function02 = function0;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.components.j0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WebsitesForSelectedAppsBottomSheetKt.i(websites, bottomSheetState, scope, function02, onBlockClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(final ImmutableList immutableList, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final WebsitesForSelectedAppsBottomSheetKt$WebsitesForSelectedAppsBottomSheet$lambda$1$0$0$$inlined$items$default$1 websitesForSelectedAppsBottomSheetKt$WebsitesForSelectedAppsBottomSheet$lambda$1$0$0$$inlined$items$default$1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.components.WebsitesForSelectedAppsBottomSheetKt$WebsitesForSelectedAppsBottomSheet$lambda$1$0$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Object obj) {
                return null;
            }
        };
        LazyColumn.h(immutableList.size(), null, new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.selection.components.WebsitesForSelectedAppsBottomSheetKt$WebsitesForSelectedAppsBottomSheet$lambda$1$0$0$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i3) {
                return websitesForSelectedAppsBottomSheetKt$WebsitesForSelectedAppsBottomSheet$lambda$1$0$0$$inlined$items$default$1.invoke(immutableList.get(i3));
            }
        }, ComposableLambdaKt.c(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.scene.selection.components.WebsitesForSelectedAppsBottomSheetKt$WebsitesForSelectedAppsBottomSheet$lambda$1$0$0$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return Unit.f139807a;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i3, Composer composer, int i4) {
                int i5;
                if ((i4 & 6) == 0) {
                    i5 = i4 | (composer.Z(lazyItemScope) ? 4 : 2);
                } else {
                    i5 = i4;
                }
                if ((i4 & 48) == 0) {
                    i5 |= composer.e(i3) ? 32 : 16;
                }
                if (!composer.r((i5 & 147) != 146, i5 & 1)) {
                    composer.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(-632812321, i5, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                WebsiteDTO websiteDTO = (WebsiteDTO) immutableList.get(i3);
                composer.a0(-229064992);
                Modifier.Companion companion = Modifier.b8;
                MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.l(), composer, 0);
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
                Updater.e(composerA, measurePolicyB, companion2.e());
                Updater.e(composerA, compositionLocalMapU, companion2.g());
                Function2 function2B = companion2.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF, companion2.f());
                RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
                BaseWebsiteSelectionScreenKt.D(websiteDTO.a(), ClipKt.a(SizeKt.v(companion, Dp.g(16)), RoundedCornerShapeKt.d(Dp.g(4))), composer, 0, 0);
                TextKt.c(websiteDTO.b(), PaddingKt.m(companion, Dp.g(8), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).j(), composer, 48, 0, 65532);
                composer.y();
                composer.U();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Function0 function0, CoroutineScope coroutineScope, ModalBottomSheetState modalBottomSheetState) {
        function0.invoke();
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new WebsitesForSelectedAppsBottomSheetKt$WebsitesForSelectedAppsBottomSheet$1$2$1$1$1(modalBottomSheetState, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Function0 function0, CoroutineScope coroutineScope, ModalBottomSheetState modalBottomSheetState) {
        function0.invoke();
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new WebsitesForSelectedAppsBottomSheetKt$WebsitesForSelectedAppsBottomSheet$1$2$2$1$1(modalBottomSheetState, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(ImmutableList immutableList, ModalBottomSheetState modalBottomSheetState, CoroutineScope coroutineScope, Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        e(immutableList, modalBottomSheetState, coroutineScope, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
