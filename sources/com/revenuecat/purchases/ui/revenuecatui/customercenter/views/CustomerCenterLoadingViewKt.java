package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.composables.Fade;
import com.revenuecat.purchases.ui.revenuecatui.composables.PlaceholderDefaults;
import com.revenuecat.purchases.ui.revenuecatui.composables.PlaceholderKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterConstants;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.theme.CustomerCenterPreviewThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class CustomerCenterLoadingViewKt {
    public static final void CustomerCenterLoadingView(Composer composer, final int i3) {
        Composer composerK = composer.k(1909589276);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1909589276, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CustomerCenterLoadingView (CustomerCenterLoadingView.kt:45)");
            }
            long jR = Color.r(MaterialTheme.f18110a.a(composerK, MaterialTheme.f18111b).d0(), 0.15f, 0.0f, 0.0f, 0.0f, 14, null);
            Fade fade = new Fade(jR, PlaceholderDefaults.INSTANCE.getFadeAnimationSpec(), null);
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierF = SizeKt.f(companion, 0.0f, 1, null);
            CustomerCenterConstants.Layout layout = CustomerCenterConstants.Layout.INSTANCE;
            Modifier modifierK = PaddingKt.k(modifierF, layout.m962getHORIZONTAL_PADDINGD9Ej5fM(), 0.0f, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierK);
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
            Updater.e(composerA, modifierF2, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            int i4 = InfiniteRepeatableSpec.f3963d;
            m1033LoadingCardPlaceholderIv8Zu3U(jR, fade, composerK, i4 << 3);
            SpacerKt.a(SizeKt.i(companion, layout.m961getBUTTONS_TOP_PADDINGD9Ej5fM()), composerK, 6);
            m1032LoadingButtonsPlaceholderIv8Zu3U(jR, fade, composerK, i4 << 3);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CustomerCenterLoadingViewKt.CustomerCenterLoadingView.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    CustomerCenterLoadingViewKt.CustomerCenterLoadingView(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void CustomerCenterLoadingViewPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(1144543300);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1144543300, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CustomerCenterLoadingViewPreview (CustomerCenterLoadingView.kt:162)");
            }
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableSingletons$CustomerCenterLoadingViewKt.INSTANCE.m1017getLambda1$revenuecatui_defaultsBc8Release(), composerK, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CustomerCenterLoadingViewKt.CustomerCenterLoadingViewPreview.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    CustomerCenterLoadingViewKt.CustomerCenterLoadingViewPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: LoadingButtonsPlaceholder-Iv8Zu3U, reason: not valid java name */
    public static final void m1032LoadingButtonsPlaceholderIv8Zu3U(final long j3, final Fade fade, Composer composer, final int i3) {
        Composer composerK = composer.k(-1444525897);
        int i4 = (i3 & 6) == 0 ? (composerK.f(j3) ? 4 : 2) | i3 : i3;
        if ((i3 & 48) == 0) {
            i4 |= (i3 & 64) == 0 ? composerK.Z(fade) : composerK.I(fade) ? 32 : 16;
        }
        int i5 = i4;
        if ((i5 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1444525897, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.LoadingButtonsPlaceholder (CustomerCenterLoadingView.kt:137)");
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = Arrangement.f6574a.o(CustomerCenterConstants.Layout.INSTANCE.m960getBUTTONS_SPACINGD9Ej5fM());
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalO, Alignment.f25072a.k(), composerK, 6);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion);
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
            composerK.a0(-1444471500);
            for (int i6 = 0; i6 < 2; i6++) {
                Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
                LoadingViewConstants loadingViewConstants = LoadingViewConstants.INSTANCE;
                BoxKt.a(PlaceholderKt.m920placeholderTgFrcIs(SizeKt.b(modifierH, 0.0f, loadingViewConstants.m1043getBUTTON_HEIGHTD9Ej5fM(), 1, null), true, j3, loadingViewConstants.getBUTTON_SHAPE(), fade, null, null, composerK, ((i5 << 6) & 896) | 3126 | (InfiniteRepeatableSpec.f3963d << 12) | ((i5 << 9) & 57344), 48), composerK, 0);
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CustomerCenterLoadingViewKt$LoadingButtonsPlaceholder$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i7) {
                    CustomerCenterLoadingViewKt.m1032LoadingButtonsPlaceholderIv8Zu3U(j3, fade, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: LoadingCardPlaceholder-Iv8Zu3U, reason: not valid java name */
    public static final void m1033LoadingCardPlaceholderIv8Zu3U(final long j3, final Fade fade, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1798499628);
        if ((i3 & 6) == 0) {
            i4 = (composerK.f(j3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= (i3 & 64) == 0 ? composerK.Z(fade) : composerK.I(fade) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1798499628, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.LoadingCardPlaceholder (CustomerCenterLoadingView.kt:65)");
            }
            SurfaceKt.a(SizeKt.h(Modifier.b8, 0.0f, 1, null), RoundedCornerShapeKt.d(CustomerCenterConstants.Card.INSTANCE.m957getROUNDED_CORNER_SIZED9Ej5fM()), ColorSchemeKt.l(MaterialTheme.f18110a.a(composerK, MaterialTheme.f18111b), Dp.g(2)), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.e(1204625137, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CustomerCenterLoadingViewKt$LoadingCardPlaceholder$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    if ((i5 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(1204625137, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.LoadingCardPlaceholder.<anonymous> (CustomerCenterLoadingView.kt:71)");
                    }
                    Modifier.Companion companion = Modifier.b8;
                    Modifier modifierI = PaddingKt.i(companion, CustomerCenterConstants.Card.INSTANCE.m955getCARD_PADDINGD9Ej5fM());
                    long j4 = j3;
                    Fade fade2 = fade;
                    MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer2, 0);
                    int iA = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU = composer2.u();
                    Modifier modifierF = ComposedModifierKt.f(composer2, modifierI);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
                    Function0 function0A = companion2.a();
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
                    Updater.e(composerA, measurePolicyA, companion2.e());
                    Updater.e(composerA, compositionLocalMapU, companion2.g());
                    Function2 function2B = companion2.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion2.f());
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
                    int i6 = InfiniteRepeatableSpec.f3963d;
                    CustomerCenterLoadingViewKt.m1034LoadingCardTitleRowIv8Zu3U(j4, fade2, composer2, i6 << 3);
                    LoadingViewConstants loadingViewConstants = LoadingViewConstants.INSTANCE;
                    BoxKt.a(PlaceholderKt.m920placeholderTgFrcIs(SizeKt.i(SizeKt.A(companion, loadingViewConstants.m1045getSUBTITLE_WIDTHD9Ej5fM()), loadingViewConstants.m1042getBODY_HEIGHTD9Ej5fM()), true, j4, loadingViewConstants.getPLACEHOLDER_SHAPE(), fade2, null, null, composer2, (i6 << 12) | 3126, 48), composer2, 0);
                    SpacerKt.a(SizeKt.i(companion, Dp.g(6)), composer2, 6);
                    BoxKt.a(PlaceholderKt.m920placeholderTgFrcIs(SizeKt.i(SizeKt.A(companion, loadingViewConstants.m1044getSTORE_WIDTHD9Ej5fM()), loadingViewConstants.m1042getBODY_HEIGHTD9Ej5fM()), true, j4, loadingViewConstants.getPLACEHOLDER_SHAPE(), fade2, null, null, composer2, (i6 << 12) | 3126, 48), composer2, 0);
                    composer2.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, 12582918, 120);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CustomerCenterLoadingViewKt$LoadingCardPlaceholder$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    CustomerCenterLoadingViewKt.m1033LoadingCardPlaceholderIv8Zu3U(j3, fade, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: LoadingCardTitleRow-Iv8Zu3U, reason: not valid java name */
    public static final void m1034LoadingCardTitleRowIv8Zu3U(long j3, Fade fade, Composer composer, final int i3) {
        int i4;
        final long j4 = j3;
        final Fade fade2 = fade;
        Composer composerK = composer.k(-1182560361);
        if ((i3 & 6) == 0) {
            i4 = (composerK.f(j4) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= (i3 & 64) == 0 ? composerK.Z(fade2) : composerK.I(fade2) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1182560361, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.LoadingCardTitleRow (CustomerCenterLoadingView.kt:103)");
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalE = Arrangement.f6574a.e();
            Alignment.Vertical verticalL = Alignment.f25072a.l();
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierM = PaddingKt.m(SizeKt.h(companion, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, CustomerCenterConstants.Card.INSTANCE.m958getTITLE_ROW_BOTTOM_PADDINGD9Ej5fM(), 7, null);
            MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalE, verticalL, composerK, 54);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            LoadingViewConstants loadingViewConstants = LoadingViewConstants.INSTANCE;
            Modifier modifierI = SizeKt.i(SizeKt.A(companion, loadingViewConstants.m1047getTITLE_WIDTHD9Ej5fM()), loadingViewConstants.m1046getTITLE_HEIGHTD9Ej5fM());
            RoundedCornerShape placeholder_shape = loadingViewConstants.getPLACEHOLDER_SHAPE();
            int i5 = ((i4 << 6) & 896) | 3126;
            int i6 = InfiniteRepeatableSpec.f3963d;
            int i7 = (i4 << 9) & 57344;
            BoxKt.a(PlaceholderKt.m920placeholderTgFrcIs(modifierI, true, j4, placeholder_shape, fade2, null, null, composerK, (i6 << 12) | i5 | i7, 48), composerK, 0);
            j4 = j3;
            fade2 = fade;
            BoxKt.a(PlaceholderKt.m920placeholderTgFrcIs(SizeKt.i(SizeKt.A(companion, loadingViewConstants.m1041getBADGE_WIDTHD9Ej5fM()), loadingViewConstants.m1040getBADGE_HEIGHTD9Ej5fM()), true, j4, loadingViewConstants.getBADGE_SHAPE(), fade2, null, null, composerK, (i6 << 12) | i5 | i7, 48), composerK, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CustomerCenterLoadingViewKt$LoadingCardTitleRow$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i8) {
                    CustomerCenterLoadingViewKt.m1034LoadingCardTitleRowIv8Zu3U(j4, fade2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
