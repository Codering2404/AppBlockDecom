package cz.mobilesoft.coreblock.scene.schedule.emoji;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import coil.compose.SingletonAsyncImageKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.AppIcon;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.enums.SelectableColor;
import cz.mobilesoft.coreblock.enums.SelectableIcon;
import cz.mobilesoft.coreblock.enums.SelectableIconCategory;
import cz.mobilesoft.coreblock.enums.SelectableItem;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
public final class IconPickerScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Function1 function1, ScheduleEmoji it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(Map map, SelectableItem selectableItem, Function1 function1, boolean z2, int i3, int i4, Composer composer, int i5) {
        y(map, selectableItem, function1, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean C(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(final List list, final SelectableItem selectableItem, final boolean z2, final Function1 function1, final int i3, final MutableState mutableState, LazyGridScope LazyVerticalGrid) {
        Intrinsics.checkNotNullParameter(LazyVerticalGrid, "$this$LazyVerticalGrid");
        final Function1 function12 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.emoji.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return IconPickerScreenKt.F((SelectableItem) obj);
            }
        };
        final IconPickerScreenKt$Content$lambda$9$0$$inlined$items$default$1 iconPickerScreenKt$Content$lambda$9$0$$inlined$items$default$1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.emoji.IconPickerScreenKt$Content$lambda$9$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Object obj) {
                return null;
            }
        };
        LazyVerticalGrid.g(list.size(), new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.schedule.emoji.IconPickerScreenKt$Content$lambda$9$0$$inlined$items$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i4) {
                return function12.invoke(list.get(i4));
            }
        }, null, new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.schedule.emoji.IconPickerScreenKt$Content$lambda$9$0$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i4) {
                return iconPickerScreenKt$Content$lambda$9$0$$inlined$items$default$1.invoke(list.get(i4));
            }
        }, ComposableLambdaKt.c(699646206, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.scene.schedule.emoji.IconPickerScreenKt$Content$lambda$9$0$$inlined$items$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((LazyGridItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return Unit.f139807a;
            }

            public final void invoke(LazyGridItemScope lazyGridItemScope, int i4, Composer composer, int i5) {
                int i6;
                if ((i5 & 6) == 0) {
                    i6 = (composer.Z(lazyGridItemScope) ? 4 : 2) | i5;
                } else {
                    i6 = i5;
                }
                if ((i5 & 48) == 0) {
                    i6 |= composer.e(i4) ? 32 : 16;
                }
                if (!composer.r((i6 & 147) != 146, i6 & 1)) {
                    composer.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(699646206, i6, -1, "androidx.compose.foundation.lazy.grid.items.<anonymous> (LazyGridDsl.kt:542)");
                }
                final SelectableItem selectableItem2 = (SelectableItem) list.get(i4);
                composer.a0(149126035);
                boolean z3 = selectableItem.getId() == selectableItem2.getId();
                boolean z4 = z2;
                boolean Z = composer.Z(function1) | composer.I(selectableItem2);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    final Function1 function13 = function1;
                    final MutableState mutableState2 = mutableState;
                    objG = new Function0<Unit>() { // from class: cz.mobilesoft.coreblock.scene.schedule.emoji.IconPickerScreenKt$Content$5$1$2$1$1
                        public final void c() {
                            if (IconPickerScreenKt.C(mutableState2)) {
                                IconPickerScreenKt.D(mutableState2, false);
                                function13.invoke(selectableItem2);
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
                IconPickerScreenKt.W(selectableItem2, z3, z4, (Function0) objG, composer, (i3 >> 3) & 8);
                composer.U();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object F(SelectableItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return Integer.valueOf(item.getId());
    }

    public static final void G(final ScheduleEmoji selectedEmoji, final Function1 onEvent, final Function0 onCloseClicked, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(selectedEmoji, "selectedEmoji");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Composer composerK = composer.k(-1452780335);
        if ((i3 & 6) == 0) {
            i4 = (composerK.e(selectedEmoji.ordinal()) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onCloseClicked) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1452780335, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.emoji.EmojiPickerScreen (IconPickerScreen.kt:95)");
            }
            boolean z2 = (i4 & 14) == 4;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = ScheduleEmoji.Companion.a(selectedEmoji);
                composerK.w(objG);
            }
            ScheduleEmoji scheduleEmoji = (ScheduleEmoji) objG;
            String strB = StringResources_androidKt.b(R.string.Kv, composerK, 0);
            Map mapC = ScheduleEmoji.Companion.c();
            boolean z3 = ((i4 & 112) == 32) | ((i4 & 896) == 256);
            Object objG2 = composerK.G();
            if (z3 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.emoji.w
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return IconPickerScreenKt.H(onEvent, onCloseClicked, (ScheduleEmoji) obj);
                    }
                };
                composerK.w(objG2);
            }
            function0 = onCloseClicked;
            J(strB, mapC, scheduleEmoji, function0, (Function1) objG2, false, composerK, (i4 << 3) & 7168, 32);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onCloseClicked;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.emoji.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IconPickerScreenKt.I(selectedEmoji, onEvent, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(Function1 function1, Function0 function0, ScheduleEmoji emoji) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        function1.invoke(new ScheduleViewEvent.OnEmojiSelected(emoji));
        AnswersHelper.f128199a.X4();
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(ScheduleEmoji scheduleEmoji, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        G(scheduleEmoji, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void J(final java.lang.String r24, final java.util.Map r25, final cz.mobilesoft.coreblock.enums.SelectableItem r26, final kotlin.jvm.functions.Function0 r27, final kotlin.jvm.functions.Function1 r28, boolean r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.emoji.IconPickerScreenKt.J(java.lang.String, java.util.Map, cz.mobilesoft.coreblock.enums.SelectableItem, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(609164858, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.emoji.IconPickerScreen.<anonymous> (IconPickerScreen.kt:141)");
            }
            Modifier modifierD = BackgroundKt.d(PaddingKt.k(SizeKt.h(SizeKt.i(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.d(WindowInsets.f7172a, composer, 6)), Dp.g(56)), 0.0f, 1, null), Dp.g(16), 0.0f, 2, null), Color.f25715b.j(), null, 2, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierD);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyB, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            FlatButtonsKt.K(null, Dp.g(40), R.drawable.f95577x1, FlatButtonColors.Secondary.f131167a, StringResources_androidKt.b(R.string.N7, composer, 0), function0, composer, 3120, 1);
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
    public static final Unit L(String str, Map map, SelectableItem selectableItem, Function1 function1, boolean z2, int i3, PaddingValues it, Composer composer, int i4) {
        int i5;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i4 & 6) == 0) {
            i5 = i4 | (composer.Z(it) ? 4 : 2);
        } else {
            i5 = i4;
        }
        if (composer.r((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-322198897, i5, -1, "cz.mobilesoft.coreblock.scene.schedule.emoji.IconPickerScreen.<anonymous> (IconPickerScreen.kt:160)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierF = SizeKt.f(PaddingKt.h(companion, it), 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierF);
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
            Updater.e(composerA, modifierF2, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            TextKt.c(str, PaddingKt.j(companion, PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), Dp.g(8)), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).f(), composer, 0, 0, 65532);
            y(map, selectableItem, function1, z2, composer, ((i3 >> 6) & 8) << 3, 0);
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
    public static final Unit M(String str, Map map, SelectableItem selectableItem, Function0 function0, Function1 function1, boolean z2, int i3, int i4, Composer composer, int i5) {
        J(str, map, selectableItem, function0, function1, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void N(final java.util.Map r19, final cz.mobilesoft.coreblock.enums.ScheduleEmoji r20, final kotlin.jvm.functions.Function1 r21, boolean r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instruction units count: 479
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.emoji.IconPickerScreenKt.N(java.util.Map, cz.mobilesoft.coreblock.enums.ScheduleEmoji, kotlin.jvm.functions.Function1, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean O(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable Q(ScheduleEmoji it) {
        Intrinsics.checkNotNullParameter(it, "it");
        SelectableIconCategory category = it.getCategory();
        if (category == null) {
            category = SelectableIconCategory.Others;
        }
        return Integer.valueOf(category.getOrder());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable R(ScheduleEmoji it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Integer.valueOf(it.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(List list, final ScheduleEmoji scheduleEmoji, final boolean z2, final Function1 function1, final MutableState mutableState, LazyGridScope lazyGridScope) {
        LazyGridScope LazyVerticalGrid = lazyGridScope;
        Intrinsics.checkNotNullParameter(LazyVerticalGrid, "$this$LazyVerticalGrid");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            final SelectableIconCategory selectableIconCategory = (SelectableIconCategory) pair.a();
            final List list2 = (List) pair.b();
            LazyGridScope.f(LazyVerticalGrid, "header_" + selectableIconCategory.getId(), null, ComposableLambdaKt.c(-1165806035, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.emoji.q
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return IconPickerScreenKt.T(selectableIconCategory, (LazyGridItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                }
            }), 2, null);
            final Function1 function12 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.emoji.s
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return IconPickerScreenKt.U((ScheduleEmoji) obj);
                }
            };
            final IconPickerScreenKt$ScheduleEmojiContent$lambda$4$0$0$$inlined$items$default$1 iconPickerScreenKt$ScheduleEmojiContent$lambda$4$0$0$$inlined$items$default$1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.emoji.IconPickerScreenKt$ScheduleEmojiContent$lambda$4$0$0$$inlined$items$default$1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(Object obj) {
                    return null;
                }
            };
            LazyVerticalGrid = lazyGridScope;
            LazyVerticalGrid.g(list2.size(), new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.schedule.emoji.IconPickerScreenKt$ScheduleEmojiContent$lambda$4$0$0$$inlined$items$default$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final Object invoke(int i3) {
                    return function12.invoke(list2.get(i3));
                }
            }, null, new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.schedule.emoji.IconPickerScreenKt$ScheduleEmojiContent$lambda$4$0$0$$inlined$items$default$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final Object invoke(int i3) {
                    return iconPickerScreenKt$ScheduleEmojiContent$lambda$4$0$0$$inlined$items$default$1.invoke(list2.get(i3));
                }
            }, ComposableLambdaKt.c(699646206, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.scene.schedule.emoji.IconPickerScreenKt$ScheduleEmojiContent$lambda$4$0$0$$inlined$items$default$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    invoke((LazyGridItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(LazyGridItemScope lazyGridItemScope, int i3, Composer composer, int i4) {
                    int i5;
                    if ((i4 & 6) == 0) {
                        i5 = (composer.Z(lazyGridItemScope) ? 4 : 2) | i4;
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
                        ComposerKt.U(699646206, i5, -1, "androidx.compose.foundation.lazy.grid.items.<anonymous> (LazyGridDsl.kt:542)");
                    }
                    final ScheduleEmoji scheduleEmoji2 = (ScheduleEmoji) list2.get(i3);
                    composer.a0(359678334);
                    boolean z3 = scheduleEmoji.getId() == scheduleEmoji2.getId();
                    boolean z4 = z2;
                    boolean Z = composer.Z(function1) | composer.e(scheduleEmoji2.ordinal());
                    Object objG = composer.G();
                    if (Z || objG == Composer.f23746a.a()) {
                        final Function1 function13 = function1;
                        final MutableState mutableState2 = mutableState;
                        objG = new Function0<Unit>() { // from class: cz.mobilesoft.coreblock.scene.schedule.emoji.IconPickerScreenKt$ScheduleEmojiContent$1$1$1$3$1$1
                            public final void c() {
                                if (IconPickerScreenKt.O(mutableState2)) {
                                    IconPickerScreenKt.P(mutableState2, false);
                                    function13.invoke(scheduleEmoji2);
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
                    IconPickerScreenKt.W(scheduleEmoji2, z3, z4, (Function0) objG, composer, 0);
                    composer.U();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(SelectableIconCategory selectableIconCategory, LazyGridItemScope stickyHeader, int i3, Composer composer, int i4) {
        Intrinsics.checkNotNullParameter(stickyHeader, "$this$stickyHeader");
        if (composer.r((i4 & 129) != 128, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1165806035, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.emoji.ScheduleEmojiContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (IconPickerScreen.kt:255)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 8;
            Modifier modifierJ = PaddingKt.j(BackgroundKt.d(SizeKt.h(companion, 0.0f, 1, null), ComposeColorsKt.j(composer, 0).e(), null, 2, null), Dp.g(f3), Dp.g(f3));
            Alignment.Companion companion2 = Alignment.f25072a;
            Alignment.Vertical verticalI = companion2.i();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), verticalI, composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierJ);
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
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            Modifier modifierJ2 = PaddingKt.j(SizeKt.k(BackgroundKt.d(ClipKt.a(companion, RoundedCornerShapeKt.a(50)), ComposeColorsKt.j(composer, 0).X(), null, 2, null), Dp.g(32), 0.0f, 2, null), Dp.g(12), Dp.g(f3));
            MeasurePolicy measurePolicyB2 = RowKt.b(arrangement.p(Dp.g(4), companion2.g()), companion2.i(), composer, 54);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierJ2);
            Function0 function0A2 = companion3.a();
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
            Updater.e(composerA2, measurePolicyB2, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            IconKt.c(PainterResources_androidKt.c(selectableIconCategory.getIconResId(), composer, 0), null, SizeKt.v(companion, Dp.g(16)), ComposeColorsKt.j(composer, 0).q(), composer, 432, 0);
            TextKt.c(StringResources_androidKt.b(selectableIconCategory.getTitleResId(), composer, 0), null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).i(), composer, 0, 0, 65530);
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
    public static final Object U(ScheduleEmoji item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return Integer.valueOf(item.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(Map map, ScheduleEmoji scheduleEmoji, Function1 function1, boolean z2, int i3, int i4, Composer composer, int i5) {
        N(map, scheduleEmoji, function1, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(final SelectableItem selectableItem, final boolean z2, final boolean z3, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Function0 function02;
        Alignment.Companion companion;
        Modifier.Companion companion2;
        int i5;
        Composer composerK = composer.k(-1976478246);
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? composerK.Z(selectableItem) : composerK.I(selectableItem) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            function02 = function0;
            i4 |= composerK.I(function02) ? 2048 : 1024;
        } else {
            function02 = function0;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1976478246, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.emoji.SelectableItemCell (IconPickerScreen.kt:311)");
            }
            Alignment.Companion companion3 = Alignment.f25072a;
            Alignment alignmentE = companion3.e();
            Modifier.Companion companion4 = Modifier.b8;
            float f3 = 8;
            Modifier modifierI = PaddingKt.i(AspectRatioKt.a(companion4, 1.0f, true), Dp.g(f3));
            MeasurePolicy measurePolicyG = BoxKt.g(alignmentE, false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
            ComposeUiNode.Companion companion5 = ComposeUiNode.f8;
            Function0 function0A = companion5.a();
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
            Updater.e(composerA, measurePolicyG, companion5.e());
            Updater.e(composerA, compositionLocalMapU, companion5.g());
            Function2 function2B = companion5.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion5.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Alignment alignmentE2 = companion3.e();
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.emoji.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return IconPickerScreenKt.X((Modifier) obj);
                    }
                };
                composerK.w(objG);
            }
            float f4 = 16;
            Modifier modifierI2 = PaddingKt.i(ClickableKt.f(ClipKt.a(ComposableExtKt.r(companion4, z2, (Function1) objG), RoundedCornerShapeKt.d(Dp.g(f4))), false, null, null, function02, 7, null), Dp.g(f3));
            MeasurePolicy measurePolicyG2 = BoxKt.g(alignmentE2, false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierI2);
            Function0 function0A2 = companion5.a();
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
            Updater.e(composerA2, measurePolicyG2, companion5.e());
            Updater.e(composerA2, compositionLocalMapU2, companion5.g());
            Function2 function2B2 = companion5.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion5.f());
            if (selectableItem instanceof SelectableIcon) {
                composerK.a0(2087470838);
                Integer iconResId = ((SelectableIcon) selectableItem).getIconResId();
                if (iconResId == null) {
                    composerK.a0(287086539);
                    composerK.U();
                    companion = companion3;
                    companion2 = companion4;
                    i5 = 0;
                } else {
                    composerK.a0(287086540);
                    companion = companion3;
                    companion2 = companion4;
                    i5 = 0;
                    SingletonAsyncImageKt.a(Integer.valueOf(iconResId.intValue()), "", ClipKt.a(PaddingKt.i(AspectRatioKt.b(SizeKt.v(companion4, Dp.g(80)), 1.0f, false, 2, null), Dp.g(f3)), RoundedCornerShapeKt.d(Dp.g(f4))), null, null, null, ContentScale.f27054a.d(), 0.0f, null, 0, composerK, 1572912, 952);
                    composerK = composerK;
                    Unit unit = Unit.f139807a;
                    composerK.U();
                }
                composerK.U();
            } else {
                companion = companion3;
                companion2 = companion4;
                i5 = 0;
                if (selectableItem instanceof SelectableColor) {
                    composerK.a0(287693458);
                    BoxKt.a(BackgroundKt.d(ClipKt.a(PaddingKt.i(SizeKt.v(companion2, Dp.g(80)), Dp.g(f3)), RoundedCornerShapeKt.d(Dp.g(f4))), ColorKt.b(android.graphics.Color.parseColor(((SelectableColor) selectableItem).getHex())), null, 2, null), composerK, 0);
                } else {
                    composerK.a0(274155324);
                }
                composerK.U();
            }
            if (selectableItem.isPremium() && z3) {
                composerK.a0(288144849);
                IconKt.c(PainterResources_androidKt.c(R.drawable.s4, composerK, i5), "", boxScopeInstance.f(PaddingKt.i(BackgroundKt.c(SizeKt.v(companion2, Dp.g(32)), ComposeColorsKt.j(composerK, i5).Y(), RoundedCornerShapeKt.d(Dp.g(f4))), Dp.g(4)), companion.c()), ComposeColorsKt.j(composerK, i5).q0(), composerK, 48, 0);
            } else {
                composerK.a0(274155324);
            }
            composerK.U();
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.emoji.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IconPickerScreenKt.Z(selectableItem, z2, z3, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier X(Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return ComposedModifierKt.c(applyIf, null, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.emoji.t
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return IconPickerScreenKt.Y((Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier Y(Modifier composed, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        composer.a0(1770930682);
        if (ComposerKt.M()) {
            ComposerKt.U(1770930682, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.emoji.SelectableItemCell.<anonymous>.<anonymous>.<anonymous>.<anonymous> (IconPickerScreen.kt:323)");
        }
        Modifier modifierE = BorderKt.e(composed, BorderStrokeKt.a(Dp.g(2), ComposeColorsKt.j(composer, 0).b()), RoundedCornerShapeKt.d(Dp.g(24)));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return modifierE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(SelectableItem selectableItem, boolean z2, boolean z3, Function0 function0, int i3, Composer composer, int i4) {
        W(selectableItem, z2, z3, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void v(final AppIcon selectedIcon, final Function1 onAppIconSelected, final Function0 onCloseClicked, boolean z2, Composer composer, final int i3, final int i4) {
        int i5;
        final boolean z3;
        Intrinsics.checkNotNullParameter(selectedIcon, "selectedIcon");
        Intrinsics.checkNotNullParameter(onAppIconSelected, "onAppIconSelected");
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Composer composerK = composer.k(-305181098);
        if ((i3 & 6) == 0) {
            i5 = (composerK.e(selectedIcon.ordinal()) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.I(onAppIconSelected) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(onCloseClicked) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i6 = i4 & 8;
        if (i6 != 0) {
            i5 |= 3072;
        } else if ((i3 & 3072) == 0) {
            i5 |= composerK.b(z2) ? 2048 : 1024;
        }
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            boolean z4 = i6 != 0 ? false : z2;
            if (ComposerKt.M()) {
                ComposerKt.U(-305181098, i5, -1, "cz.mobilesoft.coreblock.scene.schedule.emoji.AppIconPickerScreen (IconPickerScreen.kt:116)");
            }
            String strB = StringResources_androidKt.b(R.string.Lv, composerK, 0);
            Map mapB = AppIcon.Companion.b();
            boolean z5 = (i5 & 112) == 32;
            Object objG = composerK.G();
            if (z5 || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.emoji.u
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return IconPickerScreenKt.w(onAppIconSelected, (AppIcon) obj);
                    }
                };
                composerK.w(objG);
            }
            int i7 = i5 << 6;
            J(strB, mapB, selectedIcon, onCloseClicked, (Function1) objG, z4, composerK, (i7 & 458752) | ((i5 << 3) & 7168) | (i7 & 896), 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            z3 = z4;
        } else {
            composerK.Q();
            z3 = z2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.emoji.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IconPickerScreenKt.x(selectedIcon, onAppIconSelected, onCloseClicked, z3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Function1 function1, AppIcon appIcon) {
        Intrinsics.checkNotNullParameter(appIcon, "appIcon");
        function1.invoke(appIcon);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(AppIcon appIcon, Function1 function1, Function0 function0, boolean z2, int i3, int i4, Composer composer, int i5) {
        v(appIcon, function1, function0, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void y(final java.util.Map r25, final cz.mobilesoft.coreblock.enums.SelectableItem r26, final kotlin.jvm.functions.Function1 r27, boolean r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 696
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.emoji.IconPickerScreenKt.y(java.util.Map, cz.mobilesoft.coreblock.enums.SelectableItem, kotlin.jvm.functions.Function1, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Map map, SelectableItem selectableItem, Function1 function1, boolean z2, int i3, int i4, Composer composer, int i5) {
        y(map, selectableItem, function1, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
