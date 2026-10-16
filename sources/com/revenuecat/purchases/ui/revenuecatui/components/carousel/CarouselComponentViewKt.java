package com.revenuecat.purchases.ui.revenuecatui.components.carousel;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.ShapeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.CarouselComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final /* synthetic */ class CarouselComponentViewKt {
    /* JADX WARN: Removed duplicated region for block: B:174:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void CarouselComponentView(final com.revenuecat.purchases.ui.revenuecatui.components.style.CarouselComponentStyle r28, final com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Components r29, final kotlin.jvm.functions.Function2 r30, androidx.compose.ui.Modifier r31, com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instruction units count: 1068
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt.CarouselComponentView(com.revenuecat.purchases.ui.revenuecatui.components.style.CarouselComponentStyle, com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CarouselComponentView_Loop_Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(-172536871);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-172536871, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentView_Loop_Preview (CarouselComponentView.kt:454)");
            }
            Modifier modifierD = BackgroundKt.d(Modifier.b8, Color.f25715b.l(), null, 2, null);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierD);
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            CarouselComponentView(m712previewCarouselComponentStyle2XaYeUA$default(null, 0, null, false, null, 0.0f, 0.0f, 0L, null, null, null, null, null, null, true, new CarouselComponent.AutoAdvancePages(1000, 500, CarouselComponent.AutoAdvancePages.TransitionType.FADE), 16383, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), new CarouselComponentViewKt$CarouselComponentView_Loop_Preview$1$1(null), null, null, composerK, 384, 24);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt.CarouselComponentView_Loop_Preview.2
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
                    CarouselComponentViewKt.CarouselComponentView_Loop_Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CarouselComponentView_Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(697064564);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(697064564, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentView_Preview (CarouselComponentView.kt:428)");
            }
            Modifier modifierD = BackgroundKt.d(Modifier.b8, Color.f25715b.l(), null, 2, null);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierD);
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            CarouselComponentView(m712previewCarouselComponentStyle2XaYeUA$default(null, 0, null, false, null, 0.0f, 0.0f, 0L, null, null, null, null, null, null, false, null, 65535, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), new CarouselComponentViewKt$CarouselComponentView_Preview$1$1(null), null, null, composerK, 384, 24);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt.CarouselComponentView_Preview.2
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
                    CarouselComponentViewKt.CarouselComponentView_Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CarouselComponentView_Top_Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(897820094);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(897820094, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentView_Top_Preview (CarouselComponentView.kt:440)");
            }
            Modifier modifierD = BackgroundKt.d(Modifier.b8, Color.f25715b.l(), null, 2, null);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierD);
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            CarouselComponentView(m712previewCarouselComponentStyle2XaYeUA$default(null, 0, null, false, null, 0.0f, 0.0f, 0L, null, null, null, null, null, previewPageControl(CarouselComponent.PageControl.Position.TOP), false, null, 57343, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), new CarouselComponentViewKt$CarouselComponentView_Top_Preview$1$1(null), null, null, composerK, 384, 24);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt.CarouselComponentView_Top_Preview.2
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
                    CarouselComponentViewKt.CarouselComponentView_Top_Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void EnableAutoAdvance(final CarouselComponent.AutoAdvancePages autoAdvancePages, final PagerState pagerState, final boolean z2, final int i3, final ProgrammaticPageTrackingFlag programmaticPageTrackingFlag, Composer composer, final int i4) {
        int i5;
        PagerState pagerState2;
        int i6;
        Composer composerK = composer.k(1138617307);
        if ((i4 & 6) == 0) {
            i5 = (composerK.I(autoAdvancePages) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            pagerState2 = pagerState;
            i5 |= composerK.Z(pagerState2) ? 32 : 16;
        } else {
            pagerState2 = pagerState;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerK.b(z2) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 3072) == 0) {
            i6 = i3;
            i5 |= composerK.e(i6) ? 2048 : 1024;
        } else {
            i6 = i3;
        }
        if ((i4 & 24576) == 0) {
            i5 |= composerK.I(programmaticPageTrackingFlag) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((i5 & 9363) == 9362 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1138617307, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.components.carousel.EnableAutoAdvance (CarouselComponentView.kt:344)");
            }
            Unit unit = Unit.f139807a;
            composerK.a0(906986270);
            boolean zI = composerK.I(autoAdvancePages) | ((i5 & 112) == 32) | ((i5 & 896) == 256) | ((i5 & 7168) == 2048) | composerK.I(programmaticPageTrackingFlag);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                CarouselComponentViewKt$EnableAutoAdvance$1$1 carouselComponentViewKt$EnableAutoAdvance$1$1 = new CarouselComponentViewKt$EnableAutoAdvance$1$1(autoAdvancePages, pagerState2, z2, i6, programmaticPageTrackingFlag, null);
                composerK.w(carouselComponentViewKt$EnableAutoAdvance$1$1);
                objG = carouselComponentViewKt$EnableAutoAdvance$1$1;
            }
            composerK.U();
            EffectsKt.g(unit, (Function2) objG, composerK, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt.EnableAutoAdvance.2
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
                    CarouselComponentViewKt.EnableAutoAdvance(autoAdvancePages, pagerState, z2, i3, programmaticPageTrackingFlag, composer2, RecomposeScopeImplKt.a(i4 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Indicator(final PagerState pagerState, final int i3, final int i4, final CarouselComponentStyle.PageControlStyles pageControlStyles, Composer composer, final int i5) {
        int i6;
        Composer composerK = composer.k(-532758904);
        if ((i5 & 6) == 0) {
            i6 = (composerK.Z(pagerState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= composerK.e(i3) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= composerK.e(i4) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i5 & 3072) == 0) {
            i6 |= composerK.Z(pageControlStyles) ? 2048 : 1024;
        }
        if ((i6 & 1171) == 1170 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-532758904, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.components.carousel.Indicator (CarouselComponentView.kt:247)");
            }
            composerK.a0(-106578889);
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt.e(new Function0<Float>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$Indicator$progress$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        int iV = pagerState.v() % i4;
                        int i7 = i3;
                        float fW = 0.0f;
                        if (i7 == iV) {
                            fW = pagerState.w() >= 0.0f ? 1.0f - pagerState.w() : pagerState.w() + 1.0f;
                        } else if (i7 == iV + 1 && pagerState.w() >= 0.0f) {
                            fW = pagerState.w();
                        } else if (i3 == iV - 1 && pagerState.w() < 0.0f) {
                            fW = -pagerState.w();
                        }
                        return Float.valueOf(fW);
                    }
                });
                composerK.w(objG);
            }
            final State state = (State) objG;
            composerK.U();
            composerK.a0(-106550890);
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt.e(new Function0<Dp>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$Indicator$targetWidth$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        return Dp.d(m716invokeD9Ej5fM());
                    }

                    /* JADX INFO: renamed from: invoke-D9Ej5fM, reason: not valid java name */
                    public final float m716invokeD9Ej5fM() {
                        return DpKt.c(pageControlStyles.getDefault().m828getWidthD9Ej5fM(), pageControlStyles.getActive().m828getWidthD9Ej5fM(), CarouselComponentViewKt.Indicator$lambda$22(state));
                    }
                });
                composerK.w(objG2);
            }
            State state2 = (State) objG2;
            composerK.U();
            composerK.a0(-106543752);
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt.e(new Function0<Dp>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$Indicator$targetHeight$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        return Dp.d(m714invokeD9Ej5fM());
                    }

                    /* JADX INFO: renamed from: invoke-D9Ej5fM, reason: not valid java name */
                    public final float m714invokeD9Ej5fM() {
                        return DpKt.c(pageControlStyles.getDefault().m826getHeightD9Ej5fM(), pageControlStyles.getActive().m826getHeightD9Ej5fM(), CarouselComponentViewKt.Indicator$lambda$22(state));
                    }
                });
                composerK.w(objG3);
            }
            State state3 = (State) objG3;
            composerK.U();
            composerK.a0(-106536334);
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = SnapshotStateKt.e(new Function0<Dp>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$Indicator$targetStrokeWidth$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        return Dp.d(m715invokeD9Ej5fM());
                    }

                    /* JADX INFO: renamed from: invoke-D9Ej5fM, reason: not valid java name */
                    public final float m715invokeD9Ej5fM() {
                        Dp dpM827getStrokeWidthlTKBWiU = pageControlStyles.getDefault().m827getStrokeWidthlTKBWiU();
                        float fL = dpM827getStrokeWidthlTKBWiU != null ? dpM827getStrokeWidthlTKBWiU.l() : Dp.g(0);
                        Dp dpM827getStrokeWidthlTKBWiU2 = pageControlStyles.getActive().m827getStrokeWidthlTKBWiU();
                        return DpKt.c(fL, dpM827getStrokeWidthlTKBWiU2 != null ? dpM827getStrokeWidthlTKBWiU2.l() : Dp.g(0), CarouselComponentViewKt.Indicator$lambda$22(state));
                    }
                });
                composerK.w(objG4);
            }
            State state4 = (State) objG4;
            composerK.U();
            State stateC = AnimateAsStateKt.c(Indicator$lambda$24(state2), null, null, null, composerK, 0, 14);
            State stateC2 = AnimateAsStateKt.c(Indicator$lambda$26(state3), null, null, null, composerK, 0, 14);
            ColorStyle forCurrentTheme = ColorStyleKt.getForCurrentTheme(pageControlStyles.getDefault().getColor(), composerK, 0);
            ColorStyle.Solid solid = forCurrentTheme instanceof ColorStyle.Solid ? (ColorStyle.Solid) forCurrentTheme : null;
            long jM782unboximpl = solid != null ? solid.m782unboximpl() : Color.f25715b.j();
            ColorStyle forCurrentTheme2 = ColorStyleKt.getForCurrentTheme(pageControlStyles.getActive().getColor(), composerK, 0);
            ColorStyle.Solid solid2 = forCurrentTheme2 instanceof ColorStyle.Solid ? (ColorStyle.Solid) forCurrentTheme2 : null;
            long jI = ColorKt.i(jM782unboximpl, solid2 != null ? solid2.m782unboximpl() : Color.f25715b.j(), Indicator$lambda$22(state));
            boolean z2 = ((pageControlStyles.getDefault().getStrokeColor() == null && pageControlStyles.getActive().getStrokeColor() == null) || (pageControlStyles.getDefault().m827getStrokeWidthlTKBWiU() == null && pageControlStyles.getActive().m827getStrokeWidthlTKBWiU() == null)) ? false : true;
            ColorStyles strokeColor = pageControlStyles.getDefault().getStrokeColor();
            composerK.a0(-106507393);
            ColorStyle forCurrentTheme3 = strokeColor == null ? null : ColorStyleKt.getForCurrentTheme(strokeColor, composerK, 0);
            composerK.U();
            ColorStyle.Solid solid3 = forCurrentTheme3 instanceof ColorStyle.Solid ? (ColorStyle.Solid) forCurrentTheme3 : null;
            long jM782unboximpl2 = solid3 != null ? solid3.m782unboximpl() : Color.f25715b.j();
            ColorStyles strokeColor2 = pageControlStyles.getActive().getStrokeColor();
            composerK.a0(-106503937);
            ColorStyle forCurrentTheme4 = strokeColor2 == null ? null : ColorStyleKt.getForCurrentTheme(strokeColor2, composerK, 0);
            composerK.U();
            ColorStyle.Solid solid4 = forCurrentTheme4 instanceof ColorStyle.Solid ? (ColorStyle.Solid) forCurrentTheme4 : null;
            final long jI2 = ColorKt.i(jM782unboximpl2, solid4 != null ? solid4.m782unboximpl() : Color.f25715b.j(), Indicator$lambda$22(state));
            final State stateC3 = AnimateAsStateKt.c(Indicator$lambda$28(state4), null, null, null, composerK, 0, 14);
            Modifier modifierX = SizeKt.x(BackgroundKt.d(ClipKt.a(PaddingKt.k(Modifier.b8, Dp.g(pageControlStyles.m832getSpacingD9Ej5fM() / 2), 0.0f, 2, null), ShapeKt.toShape(Shape.Pill.INSTANCE)), jI, null, 2, null), Indicator$lambda$29(stateC), Indicator$lambda$30(stateC2));
            composerK.a0(-106489698);
            boolean Z = composerK.Z(stateC3) | composerK.f(jI2);
            Object objG5 = composerK.G();
            if (Z || objG5 == companion.a()) {
                objG5 = new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$Indicator$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Modifier invoke(Modifier conditional) {
                        Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                        return BorderKt.f(conditional, CarouselComponentViewKt.Indicator$lambda$31(stateC3), jI2, ShapeKt.toShape(Shape.Pill.INSTANCE));
                    }
                };
                composerK.w(objG5);
            }
            composerK.U();
            BoxKt.a(ModifierExtensionsKt.conditional(modifierX, z2, (Function1) objG5), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt.Indicator.2
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
                    CarouselComponentViewKt.Indicator(pagerState, i3, i4, pageControlStyles, composer2, RecomposeScopeImplKt.a(i5 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Indicator$lambda$22(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float Indicator$lambda$24(State<Dp> state) {
        return ((Dp) state.getValue()).l();
    }

    private static final float Indicator$lambda$26(State<Dp> state) {
        return ((Dp) state.getValue()).l();
    }

    private static final float Indicator$lambda$28(State<Dp> state) {
        return ((Dp) state.getValue()).l();
    }

    private static final float Indicator$lambda$29(State<Dp> state) {
        return ((Dp) state.getValue()).l();
    }

    private static final float Indicator$lambda$30(State<Dp> state) {
        return ((Dp) state.getValue()).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Indicator$lambda$31(State<Dp> state) {
        return ((Dp) state.getValue()).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x023b A[LOOP:0: B:113:0x0239->B:114:0x023b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x019d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void PagerIndicator(final androidx.compose.foundation.layout.ColumnScope r16, final com.revenuecat.purchases.ui.revenuecatui.components.style.CarouselComponentStyle.PageControlStyles r17, final int r18, final androidx.compose.foundation.pager.PagerState r19, androidx.compose.ui.Modifier r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instruction units count: 642
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt.PagerIndicator(androidx.compose.foundation.layout.ColumnScope, com.revenuecat.purchases.ui.revenuecatui.components.style.CarouselComponentStyle$PageControlStyles, int, androidx.compose.foundation.pager.PagerState, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.compose.ui.graphics.Shape PagerIndicator$lambda$15(State<? extends androidx.compose.ui.graphics.Shape> state) {
        return (androidx.compose.ui.graphics.Shape) state.getValue();
    }

    private static final int getInitialPage(CarouselComponentState carouselComponentState) {
        if (!carouselComponentState.getLoop()) {
            return carouselComponentState.getInitialPageIndex();
        }
        int i3 = 1073741823;
        while (i3 % carouselComponentState.getPages().size() != carouselComponentState.getInitialPageIndex()) {
            i3++;
        }
        return i3;
    }

    public static final Integer nextAutoAdvanceTargetPage(boolean z2, int i3, int i4) {
        if (i3 <= 0) {
            return null;
        }
        if (z2) {
            return Integer.valueOf(i4 + 1);
        }
        if (i4 >= i3 - 1) {
            return null;
        }
        return Integer.valueOf(i4 + 1);
    }

    /* JADX INFO: renamed from: previewCarouselComponentStyle-2XaYeUA, reason: not valid java name */
    private static final CarouselComponentStyle m711previewCarouselComponentStyle2XaYeUA(List<StackComponentStyle> list, int i3, Alignment.Vertical vertical, boolean z2, Size size, float f3, float f4, long j3, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, CarouselComponentStyle.PageControlStyles pageControlStyles, boolean z3, CarouselComponent.AutoAdvancePages autoAdvancePages) {
        int size2 = list.size();
        ArrayList arrayList = new ArrayList(size2);
        for (int i4 = 0; i4 < size2; i4++) {
            arrayList.add(null);
        }
        return new CarouselComponentStyle(list, arrayList, i3, vertical, z2, size, f3, f4, BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(j3)), null, 2, null))), paddingValues, paddingValues2, shape, borderStyles, shadowStyles, pageControlStyles, z3, autoAdvancePages, null, null, null, null, CollectionsKt.emptyList(), null, 5505024, null);
    }

    /* JADX INFO: renamed from: previewCarouselComponentStyle-2XaYeUA$default, reason: not valid java name */
    static /* synthetic */ CarouselComponentStyle m712previewCarouselComponentStyle2XaYeUA$default(List list, int i3, Alignment.Vertical vertical, boolean z2, Size size, float f3, float f4, long j3, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, CarouselComponentStyle.PageControlStyles pageControlStyles, boolean z3, CarouselComponent.AutoAdvancePages autoAdvancePages, int i4, Object obj) {
        Size size2;
        List list2;
        int i5;
        Alignment.Vertical vertical2;
        BorderStyles borderStyles2;
        CarouselComponent.AutoAdvancePages autoAdvancePages2;
        CarouselComponentStyle.PageControlStyles pageControlStylesPreviewPageControl$default;
        List listPreviewPages = (i4 & 1) != 0 ? previewPages() : list;
        int i6 = (i4 & 2) != 0 ? 0 : i3;
        Alignment.Vertical verticalI = (i4 & 4) != 0 ? Alignment.f25072a.i() : vertical;
        boolean z4 = (i4 & 8) != 0 ? true : z2;
        if ((i4 & 16) != 0) {
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            size2 = new Size(fit, fit);
        } else {
            size2 = size;
        }
        float fG = (i4 & 32) != 0 ? Dp.g(20) : f3;
        float fG2 = (i4 & 64) != 0 ? Dp.g(8) : f4;
        long jG = (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? Color.f25715b.g() : j3;
        PaddingValues paddingValuesA = (i4 & Function.MAX_NARGS) != 0 ? PaddingKt.a(Dp.g(0)) : paddingValues;
        PaddingValues paddingValuesC = (i4 & 512) != 0 ? PaddingKt.c(0.0f, Dp.g(16), 1, null) : paddingValues2;
        Shape rectangle = (i4 & 1024) != 0 ? new Shape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null) : shape;
        if ((i4 & 2048) != 0) {
            list2 = listPreviewPages;
            i5 = i6;
            vertical2 = verticalI;
            borderStyles2 = new BorderStyles(Dp.g(2), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.b())), null, 2, null), null);
        } else {
            list2 = listPreviewPages;
            i5 = i6;
            vertical2 = verticalI;
            borderStyles2 = borderStyles;
        }
        ShadowStyles shadowStyles2 = (i4 & 4096) != 0 ? new ShadowStyles(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.a())), null, 2, null), Dp.g(5), Dp.g(0), Dp.g(3), null) : shadowStyles;
        if ((i4 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0) {
            autoAdvancePages2 = null;
            pageControlStylesPreviewPageControl$default = previewPageControl$default(null, 1, null);
        } else {
            autoAdvancePages2 = null;
            pageControlStylesPreviewPageControl$default = pageControlStyles;
        }
        boolean z5 = (i4 & 16384) != 0 ? false : z3;
        if ((i4 & 32768) != 0) {
            autoAdvancePages = autoAdvancePages2;
        }
        return m711previewCarouselComponentStyle2XaYeUA(list2, i5, vertical2, z4, size2, fG, fG2, jG, paddingValuesA, paddingValuesC, rectangle, borderStyles2, shadowStyles2, pageControlStylesPreviewPageControl$default, z5, autoAdvancePages);
    }

    /* JADX INFO: renamed from: previewPage-ecKwGiE, reason: not valid java name */
    private static final StackComponentStyle m713previewPageecKwGiE(String str, long j3, int i3) {
        return new StackComponentStyle(CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle$default(str, null, 0, null, null, null, null, null, false, null, null, null, null, null, null, null, 65534, null)), new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.CENTER), true, new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fixed(i3, null)), Dp.g(8), BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(j3)), null, 2, null))), PaddingKt.c(0.0f, Dp.g(16), 1, null), PaddingKt.a(Dp.g(0)), new Shape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null);
    }

    private static final CarouselComponentStyle.PageControlStyles previewPageControl(CarouselComponent.PageControl.Position position) {
        float f3 = 4;
        float fG = Dp.g(f3);
        float f4 = 8;
        PaddingValues paddingValuesA = PaddingKt.a(Dp.g(f4));
        PaddingValues paddingValuesA2 = PaddingKt.a(Dp.g(f4));
        Color.Companion companion = Color.f25715b;
        return new CarouselComponentStyle.PageControlStyles(position, fG, paddingValuesA, paddingValuesA2, new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.f())), null, 2, null), Shape.Pill.INSTANCE, new BorderStyles(Dp.g(f3), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.b())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.a())), null, 2, null), Dp.g(20), Dp.g(f4), Dp.g(f4), null), new CarouselComponentStyle.IndicatorStyles(Dp.g(14), Dp.g(10), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.b())), null, 2, null), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.i())), null, 2, null), Dp.d(Dp.g(2)), null), new CarouselComponentStyle.IndicatorStyles(Dp.g(f4), Dp.g(f4), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.e())), null, 2, null), null, null, null), null);
    }

    static /* synthetic */ CarouselComponentStyle.PageControlStyles previewPageControl$default(CarouselComponent.PageControl.Position position, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            position = CarouselComponent.PageControl.Position.BOTTOM;
        }
        return previewPageControl(position);
    }

    private static final List<StackComponentStyle> previewPages() {
        Color.Companion companion = Color.f25715b;
        return CollectionsKt.listOf((Object[]) new StackComponentStyle[]{m713previewPageecKwGiE("Page 1", companion.i(), 200), m713previewPageecKwGiE("Page 2", companion.f(), 100), m713previewPageecKwGiE("Page 3", companion.b(), 300), m713previewPageecKwGiE("Page 4", companion.m(), 200)});
    }
}
