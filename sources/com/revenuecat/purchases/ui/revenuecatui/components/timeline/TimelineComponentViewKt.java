package com.revenuecat.purchases.ui.revenuecatui.components.timeline;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.tooling.preview.PreviewParameter;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.IconComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TextComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TimelineComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ImagePreviewsKt;
import com.sun.jna.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
public final /* synthetic */ class TimelineComponentViewKt {
    /* JADX WARN: Removed duplicated region for block: B:41:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void TimelineComponentView(final com.revenuecat.purchases.ui.revenuecatui.components.style.TimelineComponentStyle r16, final com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Components r17, androidx.compose.ui.Modifier r18, androidx.compose.runtime.Composer r19, final int r20, final int r21) {
        /*
            Method dump skipped, instruction units count: 493
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.TimelineComponentView(com.revenuecat.purchases.ui.revenuecatui.components.style.TimelineComponentStyle, com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Dp TimelineComponentView$lambda$13$lambda$1(State<Dp> state) {
        return (Dp) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TimelineComponentView_Align_TitleAndDescription_Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(1930279475);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1930279475, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentView_Align_TitleAndDescription_Preview (TimelineComponentView.kt:227)");
            }
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerK, 0, 1), ComposableSingletons$TimelineComponentViewKt.INSTANCE.m854getLambda2$revenuecatui_defaultsBc8Release(), composerK, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.TimelineComponentView_Align_TitleAndDescription_Preview.1
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
                    TimelineComponentViewKt.TimelineComponentView_Align_TitleAndDescription_Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TimelineComponentView_Align_Title_Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(747423832);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(747423832, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentView_Align_Title_Preview (TimelineComponentView.kt:214)");
            }
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerK, 0, 1), ComposableSingletons$TimelineComponentViewKt.INSTANCE.m853getLambda1$revenuecatui_defaultsBc8Release(), composerK, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.TimelineComponentView_Align_Title_Preview.1
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
                    TimelineComponentViewKt.TimelineComponentView_Align_Title_Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TimelineComponentView_Connector_Margin_Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(475255038);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(475255038, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentView_Connector_Margin_Preview (TimelineComponentView.kt:240)");
            }
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerK, 0, 1), ComposableSingletons$TimelineComponentViewKt.INSTANCE.m855getLambda3$revenuecatui_defaultsBc8Release(), composerK, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.TimelineComponentView_Connector_Margin_Preview.1
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
                    TimelineComponentViewKt.TimelineComponentView_Connector_Margin_Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TimelineComponentView_Size_Preview(@PreviewParameter final Size size, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(74978622);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(size) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(74978622, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentView_Size_Preview (TimelineComponentView.kt:270)");
            }
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerK, 0, 1), ComposableLambdaKt.e(-111498279, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.TimelineComponentView_Size_Preview.1
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
                        ComposerKt.U(-111498279, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentView_Size_Preview.<anonymous> (TimelineComponentView.kt:272)");
                    }
                    Modifier.Companion companion = Modifier.b8;
                    Color.Companion companion2 = Color.f25715b;
                    Modifier modifierD = BackgroundKt.d(companion, companion2.l(), null, 2, null);
                    Size size2 = size;
                    Alignment.Companion companion3 = Alignment.f25072a;
                    MeasurePolicy measurePolicyG = BoxKt.g(companion3.o(), false);
                    int iA = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU = composer2.u();
                    Modifier modifierF = ComposedModifierKt.f(composer2, modifierD);
                    ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
                    Function0 function0A = companion4.a();
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
                    Updater.e(composerA, measurePolicyG, companion4.e());
                    Updater.e(composerA, compositionLocalMapU, companion4.g());
                    Function2 function2B = companion4.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion4.f());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                    TimelineComponentViewKt.TimelineComponentView(TimelineComponentViewKt.previewStyle(0, 0, 0, null, false, size2, null, null, null, composer2, 0, 479), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), null, composer2, 0, 4);
                    float f3 = 16;
                    TextKt.c("timeline = w:" + size2.getWidth().getClass().getSimpleName() + " x h:" + size2.getHeight().getClass().getSimpleName(), PaddingKt.i(BorderKt.f(BackgroundKt.c(ShadowKt.b(boxScopeInstance.f(companion, companion3.e()), Dp.g(f3), RoundedCornerShapeKt.a(50), false, 0L, 0L, 28, null), companion2.l(), RoundedCornerShapeKt.a(50)), Dp.g(2), companion2.a(), RoundedCornerShapeKt.a(50)), Dp.g(f3)), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 131068);
                    composer2.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.TimelineComponentView_Size_Preview.2
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
                    TimelineComponentViewKt.TimelineComponentView_Size_Preview(size, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TimelineComponentView_TextSize_Preview(@PreviewParameter final SizeConstraint sizeConstraint, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(774105102);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(sizeConstraint) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(774105102, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentView_TextSize_Preview (TimelineComponentView.kt:305)");
            }
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerK, 0, 1), ComposableLambdaKt.e(-408857751, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.TimelineComponentView_TextSize_Preview.1
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
                        ComposerKt.U(-408857751, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentView_TextSize_Preview.<anonymous> (TimelineComponentView.kt:307)");
                    }
                    Modifier.Companion companion = Modifier.b8;
                    Color.Companion companion2 = Color.f25715b;
                    Modifier modifierD = BackgroundKt.d(companion, companion2.l(), null, 2, null);
                    SizeConstraint sizeConstraint2 = sizeConstraint;
                    Alignment.Companion companion3 = Alignment.f25072a;
                    MeasurePolicy measurePolicyG = BoxKt.g(companion3.o(), false);
                    int iA = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU = composer2.u();
                    Modifier modifierF = ComposedModifierKt.f(composer2, modifierD);
                    ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
                    Function0 function0A = companion4.a();
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
                    Updater.e(composerA, measurePolicyG, companion4.e());
                    Updater.e(composerA, compositionLocalMapU, companion4.g());
                    Function2 function2B = companion4.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion4.f());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                    SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
                    Size size = new Size(fit, fit);
                    float f3 = 8;
                    IconComponentStyle iconComponentStyleM857previewIcon6xbWgXg = TimelineComponentViewKt.m857previewIcon6xbWgXg(0L, 0L, new Size(new SizeConstraint.Fixed(39, null), new SizeConstraint.Fixed(39, null)), PaddingKt.a(Dp.g(f3)), composer2, 3456, 3);
                    FontWeight fontWeight = FontWeight.MEDIUM;
                    HorizontalAlignment horizontalAlignment = HorizontalAlignment.LEADING;
                    TimelineComponentViewKt.TimelineComponentView(TimelineComponentViewKt.previewStyle(0, 0, 0, null, false, size, null, null, CollectionsKt.listOf((Object[]) new TimelineComponentStyle.ItemStyle[]{TimelineComponentViewKt.previewItem(PreviewHelpersKt.previewTextComponentStyle$default("Today", null, 0, fontWeight, null, horizontalAlignment, horizontalAlignment, null, false, new Size(sizeConstraint2, fit), null, null, null, null, null, null, 64918, null), PreviewHelpersKt.previewTextComponentStyle$default("Description of what you get today if you subscribe with multiple lines to check wrapping", null, 0, null, null, horizontalAlignment, horizontalAlignment, null, false, new Size(sizeConstraint2, fit), null, null, null, null, null, null, 64926, null), iconComponentStyleM857previewIcon6xbWgXg, (TimelineComponentStyle.ConnectorStyle) null, composer2, 0, 8), TimelineComponentViewKt.previewItem(PreviewHelpersKt.previewTextComponentStyle$default("Day X", null, 0, fontWeight, null, horizontalAlignment, horizontalAlignment, null, false, new Size(sizeConstraint2, fit), null, null, null, null, null, null, 64918, null), PreviewHelpersKt.previewTextComponentStyle$default("We'll remind you that your trial is ending soon", null, 0, null, null, horizontalAlignment, horizontalAlignment, null, false, new Size(sizeConstraint2, fit), null, null, null, null, null, null, 64926, null), TimelineComponentViewKt.m857previewIcon6xbWgXg(0L, 0L, new Size(new SizeConstraint.Fixed(39, null), new SizeConstraint.Fixed(39, null)), PaddingKt.a(Dp.g(f3)), composer2, 3456, 3), (TimelineComponentStyle.ConnectorStyle) null, composer2, 0, 8), TimelineComponentViewKt.previewItem(PreviewHelpersKt.previewTextComponentStyle$default("Day Y", null, 0, fontWeight, null, horizontalAlignment, horizontalAlignment, null, false, new Size(sizeConstraint2, fit), null, null, null, null, null, null, 64918, null), PreviewHelpersKt.previewTextComponentStyle$default("You'll be charged. You can cancel anytime before.", null, 0, null, null, horizontalAlignment, horizontalAlignment, null, false, new Size(sizeConstraint2, fit), null, null, null, null, null, null, 64926, null), TimelineComponentViewKt.m857previewIcon6xbWgXg(0L, 0L, new Size(new SizeConstraint.Fixed(39, null), new SizeConstraint.Fixed(39, null)), PaddingKt.a(Dp.g(f3)), composer2, 3456, 3), (TimelineComponentStyle.ConnectorStyle) null, composer2, 3072, 0)}), composer2, 196608, 223), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), null, composer2, 0, 4);
                    float f4 = 16;
                    TextKt.c("text = w:" + sizeConstraint2.getClass().getSimpleName() + " x h:Fit", PaddingKt.i(BorderKt.f(BackgroundKt.c(ShadowKt.b(boxScopeInstance.f(companion, companion3.e()), Dp.g(f4), RoundedCornerShapeKt.a(50), false, 0L, 0L, 28, null), companion2.l(), RoundedCornerShapeKt.a(50)), Dp.g(2), companion2.a(), RoundedCornerShapeKt.a(50)), Dp.g(f4)), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 131068);
                    composer2.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.TimelineComponentView_TextSize_Preview.2
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
                    TimelineComponentViewKt.TimelineComponentView_TextSize_Preview(sizeConstraint, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    private static final TimelineComponentStyle.ConnectorStyle previewConnectorStyle(int i3, PaddingValues paddingValues, ColorStyle colorStyle) {
        return new TimelineComponentStyle.ConnectorStyle(i3, paddingValues, new ColorStyles(colorStyle, null, 2, null));
    }

    static /* synthetic */ TimelineComponentStyle.ConnectorStyle previewConnectorStyle$default(int i3, PaddingValues paddingValues, ColorStyle colorStyle, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = 8;
        }
        if ((i4 & 2) != 0) {
            paddingValues = PaddingKt.a(Dp.g(0));
        }
        if ((i4 & 4) != 0) {
            colorStyle = ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(ColorKt.d(4290561265L)));
        }
        return previewConnectorStyle(i3, paddingValues, colorStyle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: previewIcon-6xbWgXg, reason: not valid java name */
    public static final IconComponentStyle m857previewIcon6xbWgXg(long j3, long j4, Size size, PaddingValues paddingValues, Composer composer, int i3, int i4) {
        composer.a0(-254474895);
        if ((i4 & 1) != 0) {
            j3 = Color.f25715b.l();
        }
        long jD = (i4 & 2) != 0 ? ColorKt.d(4283919579L) : j4;
        Size size2 = (i4 & 4) != 0 ? new Size(new SizeConstraint.Fixed(20, null), new SizeConstraint.Fixed(20, null)) : size;
        PaddingValues paddingValuesA = (i4 & 8) != 0 ? PaddingKt.a(Dp.g(4)) : paddingValues;
        if (ComposerKt.M()) {
            ComposerKt.U(-254474895, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.previewIcon (TimelineComponentView.kt:502)");
        }
        IconComponentStyle iconComponentStylePreviewIconComponentStyle = PreviewHelpersKt.previewIconComponentStyle(size2, false, new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(j3)), null, 2, null), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(jD)), null, 2, null), paddingValuesA, PaddingKt.a(Dp.g(0)), null, null, null, composer, ((i3 >> 6) & 14) | 14352384 | ((i3 << 3) & 57344), 258);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return iconComponentStylePreviewIconComponentStyle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimelineComponentStyle.ItemStyle previewItem(TextComponentStyle textComponentStyle, TextComponentStyle textComponentStyle2, IconComponentStyle iconComponentStyle, TimelineComponentStyle.ConnectorStyle connectorStyle, Composer composer, int i3, int i4) {
        composer.a0(-1551417669);
        IconComponentStyle iconComponentStyleM857previewIcon6xbWgXg = (i4 & 4) != 0 ? m857previewIcon6xbWgXg(0L, 0L, null, null, composer, 0, 15) : iconComponentStyle;
        TimelineComponentStyle.ConnectorStyle connectorStylePreviewConnectorStyle$default = (i4 & 8) != 0 ? previewConnectorStyle$default(0, null, null, 7, null) : connectorStyle;
        if (ComposerKt.M()) {
            ComposerKt.U(-1551417669, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.previewItem (TimelineComponentView.kt:459)");
        }
        TimelineComponentStyle.ItemStyle itemStyle = new TimelineComponentStyle.ItemStyle(textComponentStyle, true, textComponentStyle2, iconComponentStyleM857previewIcon6xbWgXg, connectorStylePreviewConnectorStyle$default, null, null, null, null, CollectionsKt.emptyList(), 320, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return itemStyle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<TimelineComponentStyle.ItemStyle> previewItems(PaddingValues paddingValues, Composer composer, int i3, int i4) {
        composer.a0(-2140988222);
        PaddingValues paddingValuesA = (i4 & 1) != 0 ? PaddingKt.a(Dp.g(0)) : paddingValues;
        if (ComposerKt.M()) {
            ComposerKt.U(-2140988222, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.previewItems (TimelineComponentView.kt:422)");
        }
        List<TimelineComponentStyle.ItemStyle> listListOf = CollectionsKt.listOf((Object[]) new TimelineComponentStyle.ItemStyle[]{previewItem("Today", "Description of what you get today if you subscribe with multiple lines to check wrapping", (IconComponentStyle) null, previewConnectorStyle$default(0, paddingValuesA, null, 5, null), composer, 54, 4), previewItem("Day X", "We'll remind you that your trial is ending soon", m857previewIcon6xbWgXg(0L, 0L, new Size(new SizeConstraint.Fixed(30, null), new SizeConstraint.Fixed(30, null)), null, composer, 384, 11), previewConnectorStyle$default(0, paddingValuesA, null, 5, null), composer, 54, 0), previewItem("Day Y", "You'll be charged. You can cancel anytime before.", m857previewIcon6xbWgXg(Color.f25715b.a(), ColorKt.d(4279227523L), null, null, composer, 54, 12), previewConnectorStyle$default(0, paddingValuesA, ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Linear(0.0f, CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.k(ColorKt.b(1037443)), 0.0f), new ColorInfo.Gradient.Point(ColorKt.k(ColorKt.d(4279227523L)), 100.0f)}))), 1, null), composer, 54, 0)});
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return listListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimelineComponentStyle previewStyle(int i3, int i4, int i5, TimelineComponent.IconAlignment iconAlignment, boolean z2, Size size, PaddingValues paddingValues, PaddingValues paddingValues2, List<TimelineComponentStyle.ItemStyle> list, Composer composer, int i6, int i7) {
        composer.a0(-1453577113);
        int i8 = (i7 & 1) != 0 ? 24 : i3;
        int i9 = (i7 & 2) != 0 ? 4 : i4;
        int i10 = (i7 & 4) != 0 ? 8 : i5;
        TimelineComponent.IconAlignment iconAlignment2 = (i7 & 8) != 0 ? TimelineComponent.IconAlignment.TitleAndDescription : iconAlignment;
        boolean z3 = (i7 & 16) != 0 ? true : z2;
        Size size2 = (i7 & 32) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE) : size;
        PaddingValues paddingValuesA = (i7 & 64) != 0 ? PaddingKt.a(Dp.g(5)) : paddingValues;
        PaddingValues paddingValuesA2 = (i7 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? PaddingKt.a(Dp.g(5)) : paddingValues2;
        List<TimelineComponentStyle.ItemStyle> listPreviewItems = (i7 & Function.MAX_NARGS) != 0 ? previewItems(null, composer, 0, 1) : list;
        if (ComposerKt.M()) {
            ComposerKt.U(-1453577113, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.previewStyle (TimelineComponentView.kt:401)");
        }
        TimelineComponentStyle timelineComponentStyle = new TimelineComponentStyle(i8, i9, i10, iconAlignment2, z3, size2, paddingValuesA, paddingValuesA2, listPreviewItems, null, null, null, null, CollectionsKt.emptyList(), 5120, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return timelineComponentStyle;
    }

    private static final TimelineComponentStyle.ItemStyle previewItem(String str, String str2, IconComponentStyle iconComponentStyle, TimelineComponentStyle.ConnectorStyle connectorStyle, Composer composer, int i3, int i4) {
        composer.a0(66138427);
        IconComponentStyle iconComponentStyleM857previewIcon6xbWgXg = (i4 & 4) != 0 ? m857previewIcon6xbWgXg(0L, 0L, null, null, composer, 0, 15) : iconComponentStyle;
        TimelineComponentStyle.ConnectorStyle connectorStylePreviewConnectorStyle$default = (i4 & 8) != 0 ? previewConnectorStyle$default(0, null, null, 7, null) : connectorStyle;
        if (ComposerKt.M()) {
            ComposerKt.U(66138427, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.previewItem (TimelineComponentView.kt:476)");
        }
        HorizontalAlignment horizontalAlignment = HorizontalAlignment.LEADING;
        TimelineComponentStyle.ItemStyle itemStyle = new TimelineComponentStyle.ItemStyle(PreviewHelpersKt.previewTextComponentStyle$default(str, null, 0, FontWeight.BOLD, null, horizontalAlignment, horizontalAlignment, null, false, null, null, null, null, null, null, null, 65430, null), true, PreviewHelpersKt.previewTextComponentStyle$default(str2, null, 0, null, null, horizontalAlignment, horizontalAlignment, null, false, null, null, null, null, null, null, null, 65438, null), iconComponentStyleM857previewIcon6xbWgXg, connectorStylePreviewConnectorStyle$default, null, null, null, null, CollectionsKt.emptyList(), 320, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return itemStyle;
    }
}
