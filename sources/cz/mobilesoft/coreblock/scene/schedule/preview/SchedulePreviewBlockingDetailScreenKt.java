package cz.mobilesoft.coreblock.scene.schedule.preview;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.ApplicationDTO;
import cz.mobilesoft.coreblock.scene.schedule.preview.BlockingListItem;
import cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewState;
import cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.BaseWebsiteSelectionScreenKt;
import cz.mobilesoft.coreblock.scene.selection.components.ApplicationItemKt;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.ApplicationProfileRelation;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.view.AppIconCache;
import cz.mobilesoft.coreblock.view.compose.SectionedItemKt;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarButtonType;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
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
public final class SchedulePreviewBlockingDetailScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(SchedulePreviewViewState.BlockingOption blockingOption, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-596495790, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.BlockingOptionItem.<anonymous> (SchedulePreviewBlockingDetailScreen.kt:372)");
            }
            ApplicationItemKt.k(null, false, Integer.valueOf(blockingOption.a()), true, composer, 3078, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(SchedulePreviewViewState.BlockingOption blockingOption, Shape shape, int i3, Composer composer, int i4) {
        z(blockingOption, shape, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void C(Function0 function0, Composer composer, final int i3) {
        int i4;
        final Function0 function02;
        Composer composerK = composer.k(1470812477);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function0) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1470812477, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewBlockingDetailHeader (SchedulePreviewBlockingDetailScreen.kt:120)");
            }
            function02 = function0;
            ToolbarKt.e(null, function02, null, false, ToolbarButtonType.Close, false, false, null, null, composerK, ((i4 << 3) & 112) | 221184, 461);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function02 = function0;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.e0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulePreviewBlockingDetailScreenKt.D(function02, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(Function0 function0, int i3, Composer composer, int i4) {
        C(function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x027e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void E(final kotlin.jvm.functions.Function2 r34, final java.lang.String r35, java.lang.String r36, androidx.compose.ui.graphics.Shape r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instruction units count: 873
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewBlockingDetailScreenKt.E(kotlin.jvm.functions.Function2, java.lang.String, java.lang.String, androidx.compose.ui.graphics.Shape, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(Function2 function2, String str, String str2, Shape shape, int i3, int i4, Composer composer, int i5) {
        E(function2, str, str2, shape, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void G(final SchedulePreviewViewState schedulePreviewViewState, final ProfileWithConfiguration profileWithConfiguration, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1914921614);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(schedulePreviewViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(profileWithConfiguration) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1914921614, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewBlockingDetailList (SchedulePreviewBlockingDetailScreen.kt:132)");
            }
            boolean Z = composerK.Z(schedulePreviewViewState.v()) | composerK.Z(profileWithConfiguration);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = T(schedulePreviewViewState.v(), profileWithConfiguration);
                composerK.w(objG);
            }
            final List list = (List) objG;
            Object objG2 = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG2 == companion.a()) {
                objG2 = new AppIconCache();
                composerK.w(objG2);
            }
            final AppIconCache appIconCache = (AppIconCache) objG2;
            boolean zI = composerK.I(list);
            Object objG3 = composerK.G();
            if (zI || objG3 == companion.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.c0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SchedulePreviewBlockingDetailScreenKt.H(list, appIconCache, (LazyListScope) obj);
                    }
                };
                composerK.w(objG3);
            }
            LazyDslKt.b(null, null, null, false, null, null, null, false, null, (Function1) objG3, composerK, 0, 511);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulePreviewBlockingDetailScreenKt.K(schedulePreviewViewState, profileWithConfiguration, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(List list, final AppIconCache appIconCache, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final int i3 = 0;
        for (Object obj : list) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            final BlockingSection blockingSection = (BlockingSection) obj;
            LazyListScope lazyListScope = LazyColumn;
            LazyListScope.c(lazyListScope, "section_" + blockingSection.b(), null, ComposableLambdaKt.c(1542914072, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.f0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return SchedulePreviewBlockingDetailScreenKt.I(blockingSection, i3, (LazyItemScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }), 2, null);
            final List listA = blockingSection.a();
            final Function2 function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.g0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return SchedulePreviewBlockingDetailScreenKt.J(((Integer) obj2).intValue(), (BlockingListItem) obj3);
                }
            };
            lazyListScope.h(listA.size(), new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewBlockingDetailScreenKt$SchedulePreviewBlockingDetailList$lambda$2$0$0$$inlined$itemsIndexed$default$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }

                public final Object invoke(int i5) {
                    return function2.invoke(Integer.valueOf(i5), listA.get(i5));
                }
            }, new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewBlockingDetailScreenKt$SchedulePreviewBlockingDetailList$lambda$2$0$0$$inlined$itemsIndexed$default$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }

                public final Object invoke(int i5) {
                    listA.get(i5);
                    return null;
                }
            }, ComposableLambdaKt.c(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewBlockingDetailScreenKt$SchedulePreviewBlockingDetailList$lambda$2$0$0$$inlined$itemsIndexed$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                    invoke((LazyItemScope) obj2, ((Number) obj3).intValue(), (Composer) obj4, ((Number) obj5).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(LazyItemScope lazyItemScope, int i5, Composer composer, int i6) {
                    int i7;
                    if ((i6 & 6) == 0) {
                        i7 = (composer.Z(lazyItemScope) ? 4 : 2) | i6;
                    } else {
                        i7 = i6;
                    }
                    if ((i6 & 48) == 0) {
                        i7 |= composer.e(i5) ? 32 : 16;
                    }
                    if (!composer.r((i7 & 147) != 146, i7 & 1)) {
                        composer.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1091073711, i7, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                    }
                    BlockingListItem blockingListItem = (BlockingListItem) listA.get(i5);
                    composer.a0(-123971756);
                    SchedulePreviewBlockingDetailScreenKt.L(blockingListItem, SectionedItemKt.e0(i5, blockingSection.a().size(), composer, ((i7 & 126) >> 3) & 14), appIconCache, composer, 384);
                    composer.U();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }));
            i3 = i4;
            LazyColumn = lazyListScope;
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(BlockingSection blockingSection, int i3, LazyItemScope item, Composer composer, int i4) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1542914072, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewBlockingDetailList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SchedulePreviewBlockingDetailScreen.kt:145)");
            }
            Q(blockingSection.b(), PaddingKt.m(Modifier.b8, 0.0f, Dp.g(i3 == 0 ? 0 : 24), 0.0f, 0.0f, 13, null), composer, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object J(int i3, BlockingListItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item.getKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(SchedulePreviewViewState schedulePreviewViewState, ProfileWithConfiguration profileWithConfiguration, int i3, Composer composer, int i4) {
        G(schedulePreviewViewState, profileWithConfiguration, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(final BlockingListItem blockingListItem, final Shape shape, final AppIconCache appIconCache, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1607225881);
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? composerK.Z(blockingListItem) : composerK.I(blockingListItem) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(shape) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(appIconCache) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1607225881, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewBlockingDetailRow (SchedulePreviewBlockingDetailScreen.kt:251)");
            }
            if (blockingListItem instanceof BlockingListItem.App) {
                composerK.a0(-1644148830);
                r(((BlockingListItem.App) blockingListItem).a(), appIconCache, shape, composerK, ((i4 << 3) & 896) | ApplicationDTO.f96901j | ((i4 >> 3) & 112));
                composerK.U();
            } else if (blockingListItem instanceof BlockingListItem.Domain) {
                composerK.a0(-1644143232);
                u(((BlockingListItem.Domain) blockingListItem).a(), shape, composerK, (i4 & 112) | WebsiteProfileRelation.f126515i);
                composerK.U();
            } else if (blockingListItem instanceof BlockingListItem.Keyword) {
                composerK.a0(-1644138655);
                x(((BlockingListItem.Keyword) blockingListItem).a(), shape, composerK, (i4 & 112) | WebsiteProfileRelation.f126515i);
                composerK.U();
            } else {
                if (!(blockingListItem instanceof BlockingListItem.Option)) {
                    composerK.a0(-1644149917);
                    composerK.U();
                    throw new NoWhenBranchMatchedException();
                }
                composerK.a0(-1644134082);
                z(((BlockingListItem.Option) blockingListItem).a(), shape, composerK, i4 & 112);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulePreviewBlockingDetailScreenKt.M(blockingListItem, shape, appIconCache, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(BlockingListItem blockingListItem, Shape shape, AppIconCache appIconCache, int i3, Composer composer, int i4) {
        L(blockingListItem, shape, appIconCache, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void N(final SchedulePreviewViewState viewState, final Function0 onCloseClicked, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Composer composerK = composer.k(1043356561);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onCloseClicked) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1043356561, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewBlockingDetailScreen (SchedulePreviewBlockingDetailScreen.kt:83)");
            }
            ProfileWithConfiguration profileWithConfigurationI = viewState.I();
            if (profileWithConfigurationI == null) {
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                ScopeUpdateScope scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN != null) {
                    scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.a0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SchedulePreviewBlockingDetailScreenKt.O(viewState, onCloseClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierM = PaddingKt.m(PaddingKt.k(BackgroundKt.d(WindowInsetsPaddingKt.d(companion, WindowInsets_androidKt.b(WindowInsets.f7172a, composerK, 6)), ComposeColorsKt.j(composerK, 0).e(), null, 2, null), Dp.g(f3), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.g(f3), 7, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            C(onCloseClicked, composerK, (i4 >> 3) & 14);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            TextKt.c(StringResources_androidKt.b(profileWithConfigurationI.p().o() == Profile.BlockingMode.Blocklist ? R.string.A4 : R.string.A0, composerK, 0), null, ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).f(), composerK, 0, 0, 65530);
            composerK = composerK;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            G(viewState, profileWithConfigurationI, composerK, i4 & 14);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN2 = composerK.n();
        if (scopeUpdateScopeN2 != null) {
            scopeUpdateScopeN2.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.b0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulePreviewBlockingDetailScreenKt.P(viewState, onCloseClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(SchedulePreviewViewState schedulePreviewViewState, Function0 function0, int i3, Composer composer, int i4) {
        N(schedulePreviewViewState, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(SchedulePreviewViewState schedulePreviewViewState, Function0 function0, int i3, Composer composer, int i4) {
        N(schedulePreviewViewState, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void Q(final int r30, androidx.compose.ui.Modifier r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewBlockingDetailScreenKt.Q(int, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(int i3, Modifier modifier, int i4, int i5, Composer composer, int i6) {
        Q(i3, modifier, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    public static final List T(List allApplications, ProfileWithConfiguration profileWithConfiguration) {
        Intrinsics.checkNotNullParameter(allApplications, "allApplications");
        Intrinsics.checkNotNullParameter(profileWithConfiguration, "profileWithConfiguration");
        ArrayList arrayList = new ArrayList();
        for (Object obj : allApplications) {
            ApplicationDTO applicationDTO = (ApplicationDTO) obj;
            List listG = profileWithConfiguration.g();
            if (!(listG instanceof Collection) || !listG.isEmpty()) {
                Iterator it = listG.iterator();
                while (true) {
                    if (it.hasNext()) {
                        ApplicationProfileRelation applicationProfileRelation = (ApplicationProfileRelation) it.next();
                        if (Intrinsics.areEqual(applicationDTO.f(), applicationProfileRelation.d()) && !applicationProfileRelation.g(2)) {
                            arrayList.add(obj);
                            break;
                        }
                    }
                }
            }
        }
        List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewBlockingDetailScreenKt$buildBlockingSections$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj2, Object obj3) {
                return ComparisonsKt.d(((ApplicationDTO) obj2).d(), ((ApplicationDTO) obj3).d());
            }
        });
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSortedWith, 10));
        Iterator it2 = listSortedWith.iterator();
        while (it2.hasNext()) {
            arrayList2.add(new BlockingListItem.App((ApplicationDTO) it2.next()));
        }
        List listS = profileWithConfiguration.s();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listS) {
            if (((WebsiteProfileRelation) obj2).a() == WebsiteProfileRelation.BlockingType.DOMAIN) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        int size = arrayList3.size();
        int i3 = 0;
        int i4 = 0;
        while (i4 < size) {
            Object obj3 = arrayList3.get(i4);
            i4++;
            arrayList4.add(new BlockingListItem.Domain((WebsiteProfileRelation) obj3));
        }
        List listS2 = profileWithConfiguration.s();
        ArrayList arrayList5 = new ArrayList();
        for (Object obj4 : listS2) {
            if (((WebsiteProfileRelation) obj4).a() == WebsiteProfileRelation.BlockingType.KEYWORD) {
                arrayList5.add(obj4);
            }
        }
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
        int size2 = arrayList5.size();
        while (i3 < size2) {
            Object obj5 = arrayList5.get(i3);
            i3++;
            arrayList6.add(new BlockingListItem.Keyword((WebsiteProfileRelation) obj5));
        }
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        if (profileWithConfiguration.p().i()) {
            listCreateListBuilder.add(new SchedulePreviewViewState.BlockingOption(R.drawable.V0, R.string.Q));
        }
        if (profileWithConfiguration.p().j()) {
            listCreateListBuilder.add(new SchedulePreviewViewState.BlockingOption(R.drawable.T0, R.string.W));
        }
        if (profileWithConfiguration.p().k()) {
            listCreateListBuilder.add(new SchedulePreviewViewState.BlockingOption(R.drawable.K2, R.string.Rq));
        }
        if (profileWithConfiguration.p().n()) {
            listCreateListBuilder.add(new SchedulePreviewViewState.BlockingOption(R.drawable.f95499c1, R.string.U3));
        }
        List listBuild = CollectionsKt.build(listCreateListBuilder);
        ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listBuild, 10));
        Iterator it3 = listBuild.iterator();
        while (it3.hasNext()) {
            arrayList7.add(new BlockingListItem.Option((SchedulePreviewViewState.BlockingOption) it3.next()));
        }
        List listListOf = CollectionsKt.listOf((Object[]) new BlockingSection[]{new BlockingSection(R.string.M1, arrayList2), new BlockingSection(R.string.hG, arrayList4), new BlockingSection(R.string.oi, arrayList6), new BlockingSection(R.string.HD, arrayList7)});
        ArrayList arrayList8 = new ArrayList();
        for (Object obj6 : listListOf) {
            if (!((BlockingSection) obj6).a().isEmpty()) {
                arrayList8.add(obj6);
            }
        }
        return arrayList8;
    }

    private static final void r(final ApplicationDTO applicationDTO, final AppIconCache appIconCache, Shape shape, Composer composer, final int i3) {
        int i4;
        final Shape shape2;
        Composer composerK = composer.k(770328922);
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? composerK.Z(applicationDTO) : composerK.I(applicationDTO) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(appIconCache) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(shape) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(770328922, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.BlockingAppItem (SchedulePreviewBlockingDetailScreen.kt:304)");
            }
            boolean Z = composerK.Z(applicationDTO.f());
            Object objG = composerK.G();
            String strB = null;
            if (Z || objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(new ColorDrawable(Color.z(Color.f25715b.j())), null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            if (((Boolean) composerK.q(InspectionModeKt.a())).booleanValue()) {
                composerK.a0(847414408);
            } else {
                composerK.a0(858938069);
                String strF = applicationDTO.f();
                boolean Z2 = composerK.Z(mutableState) | ((i4 & 112) == 32) | ((i4 & 14) == 4 || ((i4 & 8) != 0 && composerK.I(applicationDTO)));
                Object objG2 = composerK.G();
                if (Z2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new SchedulePreviewBlockingDetailScreenKt$BlockingAppItem$1$1(mutableState, appIconCache, applicationDTO, null);
                    composerK.w(objG2);
                }
                EffectsKt.g(strF, (Function2) objG2, composerK, 0);
            }
            composerK.U();
            ComposableLambda composableLambdaE = ComposableLambdaKt.e(165815449, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.k0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulePreviewBlockingDetailScreenKt.s(mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54);
            String strD = applicationDTO.d();
            if (applicationDTO.i()) {
                composerK.a0(1551742371);
                strB = StringResources_androidKt.b(R.string.ZE, composerK, 0);
            } else {
                composerK.a0(859418723);
            }
            composerK.U();
            shape2 = shape;
            E(composableLambdaE, strD, strB, shape2, composerK, ((i4 << 3) & 7168) | 6, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            shape2 = shape;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.l0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulePreviewBlockingDetailScreenKt.t(applicationDTO, appIconCache, shape2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(MutableState mutableState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(165815449, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.BlockingAppItem.<anonymous> (SchedulePreviewBlockingDetailScreen.kt:317)");
            }
            ApplicationItemKt.k((Drawable) mutableState.getValue(), false, null, true, composer, 3072, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(ApplicationDTO applicationDTO, AppIconCache appIconCache, Shape shape, int i3, Composer composer, int i4) {
        r(applicationDTO, appIconCache, shape, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void u(final WebsiteProfileRelation websiteProfileRelation, Shape shape, Composer composer, final int i3) {
        int i4;
        final Shape shape2;
        Composer composerK = composer.k(1823228932);
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? composerK.Z(websiteProfileRelation) : composerK.I(websiteProfileRelation) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(shape) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1823228932, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.BlockingDomainItem (SchedulePreviewBlockingDetailScreen.kt:332)");
            }
            shape2 = shape;
            E(ComposableLambdaKt.e(1393550083, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.i0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulePreviewBlockingDetailScreenKt.v(websiteProfileRelation, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), websiteProfileRelation.c(), null, shape2, composerK, ((i4 << 6) & 7168) | 6, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            shape2 = shape;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.j0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulePreviewBlockingDetailScreenKt.w(websiteProfileRelation, shape2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(WebsiteProfileRelation websiteProfileRelation, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1393550083, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.BlockingDomainItem.<anonymous> (SchedulePreviewBlockingDetailScreen.kt:335)");
            }
            BaseWebsiteSelectionScreenKt.D(websiteProfileRelation.c(), ClipKt.a(SizeKt.v(Modifier.b8, Dp.g(32)), RoundedCornerShapeKt.d(Dp.g(8))), composer, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(WebsiteProfileRelation websiteProfileRelation, Shape shape, int i3, Composer composer, int i4) {
        u(websiteProfileRelation, shape, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void x(final WebsiteProfileRelation websiteProfileRelation, Shape shape, Composer composer, final int i3) {
        int i4;
        final Shape shape2;
        Composer composerK = composer.k(-404803739);
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? composerK.Z(websiteProfileRelation) : composerK.I(websiteProfileRelation) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(shape) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-404803739, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.BlockingKeywordItem (SchedulePreviewBlockingDetailScreen.kt:351)");
            }
            shape2 = shape;
            E(ComposableSingletons$SchedulePreviewBlockingDetailScreenKt.f117338a.b(), websiteProfileRelation.c(), null, shape2, composerK, ((i4 << 6) & 7168) | 6, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            shape2 = shape;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.m0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulePreviewBlockingDetailScreenKt.y(websiteProfileRelation, shape2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(WebsiteProfileRelation websiteProfileRelation, Shape shape, int i3, Composer composer, int i4) {
        x(websiteProfileRelation, shape, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void z(final SchedulePreviewViewState.BlockingOption blockingOption, Shape shape, Composer composer, final int i3) {
        int i4;
        final Shape shape2;
        Composer composerK = composer.k(702293075);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(blockingOption) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(shape) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(702293075, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.BlockingOptionItem (SchedulePreviewBlockingDetailScreen.kt:369)");
            }
            shape2 = shape;
            E(ComposableLambdaKt.e(-596495790, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.n0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulePreviewBlockingDetailScreenKt.A(blockingOption, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), StringResources_androidKt.b(blockingOption.b(), composerK, 0), null, shape2, composerK, ((i4 << 6) & 7168) | 6, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            shape2 = shape;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulePreviewBlockingDetailScreenKt.B(blockingOption, shape2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
