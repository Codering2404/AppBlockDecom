package cz.mobilesoft.coreblock.scene.selection.components;

import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.material3.CheckboxColors;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.WebAllowlistBrowserItem;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
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
public final class BrowsersForWebAllowlistBottomSheetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(final WebAllowlistBrowserItem webAllowlistBrowserItem, final boolean z2, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1833867637);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(webAllowlistBrowserItem) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function0) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i5 = i4;
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1833867637, i5, -1, "cz.mobilesoft.coreblock.scene.selection.components.BrowserItem (BrowsersForWebAllowlistBottomSheet.kt:117)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            int i6 = i5 & 896;
            boolean z3 = i6 == 256;
            Object objG = composerK.G();
            if (z3 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.components.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BrowsersForWebAllowlistBottomSheetKt.i(function0);
                    }
                };
                composerK.w(objG);
            }
            Modifier modifierF = ClickableKt.f(modifierH, false, null, null, (Function0) objG, 7, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierF);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            ApplicationItemKt.k(webAllowlistBrowserItem.a(), false, null, true, composerK, 3072, 6);
            TextKt.c(webAllowlistBrowserItem.b(), RowScope.c(rowScopeInstance, PaddingKt.m(companion, Dp.g(8), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).j(), composerK, 0, 0, 65532);
            CheckboxColors checkboxColorsH = ComposeColorsKt.h(composerK, 0);
            boolean z4 = i6 == 256;
            Object objG2 = composerK.G();
            if (z4 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.components.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BrowsersForWebAllowlistBottomSheetKt.j(function0, ((Boolean) obj).booleanValue());
                    }
                };
                composerK.w(objG2);
            }
            CheckboxKt.a(z2, (Function1) objG2, null, false, checkboxColorsH, null, composerK, (i5 >> 3) & 14, 44);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.components.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BrowsersForWebAllowlistBottomSheetKt.k(webAllowlistBrowserItem, z2, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Function0 function0, boolean z2) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(WebAllowlistBrowserItem webAllowlistBrowserItem, boolean z2, Function0 function0, int i3, Composer composer, int i4) {
        h(webAllowlistBrowserItem, z2, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void l(final List browsers, Function0 onNotNowClicked, Function1 onSaveClicked, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        final Function1 function1;
        Arrangement arrangement;
        Intrinsics.checkNotNullParameter(browsers, "browsers");
        Intrinsics.checkNotNullParameter(onNotNowClicked, "onNotNowClicked");
        Intrinsics.checkNotNullParameter(onSaveClicked, "onSaveClicked");
        Composer composerK = composer.k(-1225075268);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(browsers) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onNotNowClicked) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onSaveClicked) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1225075268, i4, -1, "cz.mobilesoft.coreblock.scene.selection.components.BrowsersForWebAllowlistBottomSheet (BrowsersForWebAllowlistBottomSheet.kt:37)");
            }
            boolean Z = composerK.Z(browsers);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt.f();
                composerK.w(objG);
            }
            final SnapshotStateList snapshotStateList = (SnapshotStateList) objG;
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierD = WindowInsetsPaddingKt.d(SizeKt.h(PaddingKt.i(companion, Dp.g(f3)), 0.0f, 1, null), WindowInsets_androidKt.b(WindowInsets.f7172a, composerK, 6));
            Arrangement arrangement2 = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement2.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierD);
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
            TextKt.c(StringResources_androidKt.b(R.string.f95839r0, composerK, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).g(), composerK, 0, 0, 65534);
            TextKt.c(StringResources_androidKt.b(R.string.x7, composerK, 0), PaddingKt.m(companion, 0.0f, Dp.g(12), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).a(), composerK, 48, 0, 65532);
            composerK = composerK;
            if (browsers.isEmpty()) {
                arrangement = arrangement2;
                composerK.a0(-609112580);
            } else {
                composerK.a0(-606742971);
                Modifier modifierA = columnScopeInstance.a(PaddingKt.m(SizeKt.h(companion, 0.0f, 1, null), 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null), 1.0f, false);
                Arrangement.HorizontalOrVertical horizontalOrVerticalO = arrangement2.o(Dp.g(4));
                boolean zI = composerK.I(browsers) | composerK.Z(snapshotStateList);
                Object objG2 = composerK.G();
                if (zI || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.components.o
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BrowsersForWebAllowlistBottomSheetKt.m(browsers, snapshotStateList, (LazyListScope) obj);
                        }
                    };
                    composerK.w(objG2);
                }
                arrangement = arrangement2;
                LazyDslKt.b(modifierA, null, null, false, horizontalOrVerticalO, null, null, false, null, (Function1) objG2, composerK, 24576, 494);
                composerK = composerK;
            }
            composerK.U();
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
            boolean z2 = (i5 & 112) == 32;
            Object objG3 = composerK.G();
            if (z2 || objG3 == Composer.f23746a.a()) {
                function0 = onNotNowClicked;
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.components.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BrowsersForWebAllowlistBottomSheetKt.n(function0);
                    }
                };
                composerK.w(objG3);
            } else {
                function0 = onNotNowClicked;
            }
            ComposeButtonsKt.i0(modifierC, big, light, (Function0) objG3, composerK, 0, 0);
            Modifier modifierC2 = RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null);
            ButtonType.Big big2 = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.f95831p0, composerK, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 15, null);
            boolean Z2 = composerK.Z(snapshotStateList) | ((i5 & 896) == 256);
            Object objG4 = composerK.G();
            if (Z2 || objG4 == Composer.f23746a.a()) {
                function1 = onSaveClicked;
                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.components.q
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BrowsersForWebAllowlistBottomSheetKt.o(function1, snapshotStateList);
                    }
                };
                composerK.w(objG4);
            } else {
                function1 = onSaveClicked;
            }
            ComposeButtonsKt.i0(modifierC2, big2, accent, (Function0) objG4, composerK, 0, 0);
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onNotNowClicked;
            function1 = onSaveClicked;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.components.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BrowsersForWebAllowlistBottomSheetKt.p(browsers, function0, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(final List list, final SnapshotStateList snapshotStateList, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final BrowsersForWebAllowlistBottomSheetKt$BrowsersForWebAllowlistBottomSheet$lambda$1$0$0$$inlined$items$default$1 browsersForWebAllowlistBottomSheetKt$BrowsersForWebAllowlistBottomSheet$lambda$1$0$0$$inlined$items$default$1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.components.BrowsersForWebAllowlistBottomSheetKt$BrowsersForWebAllowlistBottomSheet$lambda$1$0$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Object obj) {
                return null;
            }
        };
        LazyColumn.h(list.size(), null, new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.selection.components.BrowsersForWebAllowlistBottomSheetKt$BrowsersForWebAllowlistBottomSheet$lambda$1$0$0$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i3) {
                return browsersForWebAllowlistBottomSheetKt$BrowsersForWebAllowlistBottomSheet$lambda$1$0$0$$inlined$items$default$1.invoke(list.get(i3));
            }
        }, ComposableLambdaKt.c(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.scene.selection.components.BrowsersForWebAllowlistBottomSheetKt$BrowsersForWebAllowlistBottomSheet$lambda$1$0$0$$inlined$items$default$4
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
                    i5 = (composer.Z(lazyItemScope) ? 4 : 2) | i4;
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
                final WebAllowlistBrowserItem webAllowlistBrowserItem = (WebAllowlistBrowserItem) list.get(i3);
                composer.a0(-34235728);
                boolean zContains = snapshotStateList.contains(webAllowlistBrowserItem.c());
                boolean Z = composer.Z(snapshotStateList) | composer.I(webAllowlistBrowserItem);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    final SnapshotStateList snapshotStateList2 = snapshotStateList;
                    objG = new Function0<Unit>() { // from class: cz.mobilesoft.coreblock.scene.selection.components.BrowsersForWebAllowlistBottomSheetKt$BrowsersForWebAllowlistBottomSheet$1$1$1$1$1$1
                        public final void c() {
                            if (snapshotStateList2.contains(webAllowlistBrowserItem.c())) {
                                snapshotStateList2.remove(webAllowlistBrowserItem.c());
                            } else {
                                snapshotStateList2.add(webAllowlistBrowserItem.c());
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            c();
                            return Unit.f139807a;
                        }
                    };
                    composer.w(objG);
                }
                BrowsersForWebAllowlistBottomSheetKt.h(webAllowlistBrowserItem, zContains, (Function0) objG, composer, 0);
                composer.U();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Function1 function1, SnapshotStateList snapshotStateList) {
        function1.invoke(snapshotStateList.t());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(List list, Function0 function0, Function1 function1, int i3, Composer composer, int i4) {
        l(list, function0, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
