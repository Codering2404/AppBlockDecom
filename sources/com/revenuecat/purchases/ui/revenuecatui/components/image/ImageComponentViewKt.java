package com.revenuecat.purchases.ui.revenuecatui.components.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.tooling.preview.PreviewParameter;
import androidx.compose.ui.unit.Dp;
import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import coil.ComponentRegistry;
import coil.ImageLoader;
import coil.decode.DataSource;
import coil.intercept.Interceptor;
import coil.request.ImageResult;
import coil.request.SuccessResult;
import com.emergetools.snapshots.annotations.EmergeSnapshotConfig;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.ImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.FitModeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.ShapeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.ThemeImageUrlsKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ImageComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ImagePreviewsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMapKt;
import com.sun.jna.Function;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
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
public final /* synthetic */ class ImageComponentViewKt {
    /* JADX WARN: Removed duplicated region for block: B:40:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void ImageComponentView(final com.revenuecat.purchases.ui.revenuecatui.components.style.ImageComponentStyle r17, final com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Components r18, androidx.compose.ui.Modifier r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instruction units count: 609
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView(com.revenuecat.purchases.ui.revenuecatui.components.style.ImageComponentStyle, com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Shape ImageComponentView$lambda$3(State<? extends Shape> state) {
        return (Shape) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(precision = 0.99f)
    public static final void ImageComponentView_Bigger_Container_Fill_Fit_FitModeFill_Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(-1105161640);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1105161640, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Bigger_Container_Fill_Fit_FitModeFill_Preview (ImageComponentView.kt:228)");
            }
            final ThemeImageUrls themeImageUrlsM720previewThemeImageUrlsfeOb9K0 = m720previewThemeImageUrlsfeOb9K0(100, 100);
            ImagePreviewsKt.ProvidePreviewImageLoader(previewImageLoader(themeImageUrlsM720previewThemeImageUrlsfeOb9K0, composerK, 0), ComposableLambdaKt.e(-1367814797, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Bigger_Container_Fill_Fit_FitModeFill_Preview.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    if ((i4 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1367814797, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Bigger_Container_Fill_Fit_FitModeFill_Preview.<anonymous> (ImageComponentView.kt:231)");
                    }
                    Modifier modifierI = PaddingKt.i(SizeKt.A(SizeKt.d(BackgroundKt.d(Modifier.b8, Color.f25715b.i(), null, 2, null), 0.0f, 1, null), Dp.g(200)), Dp.g(20));
                    ThemeImageUrls themeImageUrls = themeImageUrlsM720previewThemeImageUrlsfeOb9K0;
                    MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                    int iA = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU = composer2.u();
                    Modifier modifierF = ComposedModifierKt.f(composer2, modifierI);
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
                    Updater.e(composerA, measurePolicyG, companion.e());
                    Updater.e(composerA, compositionLocalMapU, companion.g());
                    Function2 function2B = companion.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion.f());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                    ImageComponentViewKt.ImageComponentView(ImageComponentViewKt.previewImageComponentStyle(themeImageUrls, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), FitMode.FILL, new MaskShape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), false, null, null, null, null, null, composer2, 3504, 1008), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), null, composer2, 0, 4);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Bigger_Container_Fill_Fit_FitModeFill_Preview.2
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
                    ImageComponentViewKt.ImageComponentView_Bigger_Container_Fill_Fit_FitModeFill_Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(precision = 0.99f)
    public static final void ImageComponentView_Bigger_Container_Fit_Fill_FitModeFill_Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(1217970940);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1217970940, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Bigger_Container_Fit_Fill_FitModeFill_Preview (ImageComponentView.kt:254)");
            }
            final ThemeImageUrls themeImageUrlsM720previewThemeImageUrlsfeOb9K0 = m720previewThemeImageUrlsfeOb9K0(100, 100);
            ImagePreviewsKt.ProvidePreviewImageLoader(previewImageLoader(themeImageUrlsM720previewThemeImageUrlsfeOb9K0, composerK, 0), ComposableLambdaKt.e(955317783, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Bigger_Container_Fit_Fill_FitModeFill_Preview.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    if ((i4 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(955317783, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Bigger_Container_Fit_Fill_FitModeFill_Preview.<anonymous> (ImageComponentView.kt:257)");
                    }
                    Modifier modifierI = PaddingKt.i(SizeKt.i(SizeKt.h(BackgroundKt.d(Modifier.b8, Color.f25715b.i(), null, 2, null), 0.0f, 1, null), Dp.g(200)), Dp.g(20));
                    ThemeImageUrls themeImageUrls = themeImageUrlsM720previewThemeImageUrlsfeOb9K0;
                    MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                    int iA = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU = composer2.u();
                    Modifier modifierF = ComposedModifierKt.f(composer2, modifierI);
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
                    Updater.e(composerA, measurePolicyG, companion.e());
                    Updater.e(composerA, compositionLocalMapU, companion.g());
                    Function2 function2B = companion.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion.f());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                    ImageComponentViewKt.ImageComponentView(ImageComponentViewKt.previewImageComponentStyle(themeImageUrls, new Size(SizeConstraint.Fit.INSTANCE, SizeConstraint.Fill.INSTANCE), FitMode.FILL, new MaskShape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), false, null, null, null, null, null, composer2, 3504, 1008), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), null, composer2, 0, 4);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Bigger_Container_Fit_Fill_FitModeFill_Preview.2
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
                    ImageComponentViewKt.ImageComponentView_Bigger_Container_Fit_Fill_FitModeFill_Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(precision = 0.95f)
    public static final void ImageComponentView_Preview(@PreviewParameter final PreviewParameters previewParameters, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1427202611);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(previewParameters) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1427202611, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview (ImageComponentView.kt:201)");
            }
            final ThemeImageUrls themeImageUrlsM720previewThemeImageUrlsfeOb9K0 = m720previewThemeImageUrlsfeOb9K0(previewParameters.m723getImageWidthpVg5ArA(), previewParameters.m722getImageHeightpVg5ArA());
            ImagePreviewsKt.ProvidePreviewImageLoader(previewImageLoader(themeImageUrlsM720previewThemeImageUrlsfeOb9K0, composerK, 0), ComposableLambdaKt.e(-463386670, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview.1
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
                        ComposerKt.U(-463386670, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview.<anonymous> (ImageComponentView.kt:204)");
                    }
                    Modifier modifierD = BackgroundKt.d(Modifier.b8, Color.f25715b.i(), null, 2, null);
                    ThemeImageUrls themeImageUrls = themeImageUrlsM720previewThemeImageUrlsfeOb9K0;
                    PreviewParameters previewParameters2 = previewParameters;
                    MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
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
                    Updater.e(composerA, measurePolicyG, companion.e());
                    Updater.e(composerA, compositionLocalMapU, companion.g());
                    Function2 function2B = companion.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion.f());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                    ImageComponentViewKt.ImageComponentView(ImageComponentViewKt.previewImageComponentStyle(themeImageUrls, previewParameters2.getViewSize(), previewParameters2.getFitMode(), new MaskShape.Rectangle(new CornerRadiuses.Dp(20.0d, 20.0d, 20.0d, 20.0d)), false, null, null, null, null, null, composer2, 3072, 1008), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), null, composer2, 0, 4);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview.2
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
                    ImageComponentViewKt.ImageComponentView_Preview(previewParameters, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(precision = 0.97f)
    public static final void ImageComponentView_Preview_FixedFixedFitMargin(Composer composer, final int i3) {
        Composer composerK = composer.k(1911339503);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1911339503, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview_FixedFixedFitMargin (ImageComponentView.kt:481)");
            }
            final ThemeImageUrls themeImageUrlsM720previewThemeImageUrlsfeOb9K0 = m720previewThemeImageUrlsfeOb9K0(96, 96);
            ImagePreviewsKt.ProvidePreviewImageLoader(previewImageLoader(themeImageUrlsM720previewThemeImageUrlsfeOb9K0, composerK, 0), ComposableLambdaKt.e(-1199303222, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview_FixedFixedFitMargin.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    if ((i4 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1199303222, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview_FixedFixedFitMargin.<anonymous> (ImageComponentView.kt:484)");
                    }
                    Modifier modifierD = BackgroundKt.d(Modifier.b8, Color.f25715b.i(), null, 2, null);
                    ThemeImageUrls themeImageUrls = themeImageUrlsM720previewThemeImageUrlsfeOb9K0;
                    MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
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
                    Updater.e(composerA, measurePolicyG, companion.e());
                    Updater.e(composerA, compositionLocalMapU, companion.g());
                    Function2 function2B = companion.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion.f());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                    ImageComponentViewKt.ImageComponentView(ImageComponentViewKt.previewImageComponentStyle(themeImageUrls, new Size(new SizeConstraint.Fixed(24, null), new SizeConstraint.Fixed(24, null)), FitMode.FIT, new MaskShape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), false, null, null, PaddingKt.e(0.0f, 0.0f, Dp.g(8), 0.0f, 11, null), null, null, composer2, 918556080, 112), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), null, composer2, 0, 4);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview_FixedFixedFitMargin.2
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
                    ImageComponentViewKt.ImageComponentView_Preview_FixedFixedFitMargin(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(precision = 0.99f)
    public static final void ImageComponentView_Preview_LinearGradient(Composer composer, final int i3) {
        Composer composerK = composer.k(246381111);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(246381111, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview_LinearGradient (ImageComponentView.kt:345)");
            }
            final ThemeImageUrls themeImageUrlsM720previewThemeImageUrlsfeOb9K0 = m720previewThemeImageUrlsfeOb9K0(RCHTTPStatusCodes.BAD_REQUEST, RCHTTPStatusCodes.BAD_REQUEST);
            ImagePreviewsKt.ProvidePreviewImageLoader(previewImageLoader(themeImageUrlsM720previewThemeImageUrlsfeOb9K0, composerK, 0), ComposableLambdaKt.e(1985929596, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview_LinearGradient.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    if ((i4 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(1985929596, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview_LinearGradient.<anonymous> (ImageComponentView.kt:348)");
                    }
                    Modifier.Companion companion = Modifier.b8;
                    Color.Companion companion2 = Color.f25715b;
                    Modifier modifierD = BackgroundKt.d(companion, companion2.i(), null, 2, null);
                    ThemeImageUrls themeImageUrls = themeImageUrlsM720previewThemeImageUrlsfeOb9K0;
                    MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                    int iA = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU = composer2.u();
                    Modifier modifierF = ComposedModifierKt.f(composer2, modifierD);
                    ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
                    Function0 function0A = companion3.a();
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
                    Updater.e(composerA, measurePolicyG, companion3.e());
                    Updater.e(composerA, compositionLocalMapU, companion3.g());
                    Function2 function2B = companion3.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion3.f());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                    ImageComponentViewKt.ImageComponentView(ImageComponentViewKt.previewImageComponentStyle(themeImageUrls, new Size(new SizeConstraint.Fixed(RCHTTPStatusCodes.BAD_REQUEST, null), SizeConstraint.Fit.INSTANCE), FitMode.FIT, new MaskShape.Rectangle(new CornerRadiuses.Dp(20.0d, 20.0d, 20.0d, 20.0d)), false, new ColorStyles(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Linear(0.0f, CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(android.graphics.Color.parseColor("#88FF0000"), 0.0f), new ColorInfo.Gradient.Point(android.graphics.Color.parseColor("#8800FF00"), 50.0f), new ColorInfo.Gradient.Point(android.graphics.Color.parseColor("#880000FF"), 100.0f)}))), null, 2, null), null, null, new BorderStyles(Dp.g(10), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.b())), null, 2, null), null), null, composer2, 3504, 720), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), null, composer2, 0, 4);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview_LinearGradient.2
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
                    ImageComponentViewKt.ImageComponentView_Preview_LinearGradient(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ImageComponentView_Preview_Margin_Padding(Composer composer, final int i3) {
        Composer composerK = composer.k(-370346004);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-370346004, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview_Margin_Padding (ImageComponentView.kt:310)");
            }
            final ThemeImageUrls themeImageUrlsM720previewThemeImageUrlsfeOb9K0 = m720previewThemeImageUrlsfeOb9K0(RCHTTPStatusCodes.BAD_REQUEST, RCHTTPStatusCodes.BAD_REQUEST);
            ImagePreviewsKt.ProvidePreviewImageLoader(previewImageLoader(themeImageUrlsM720previewThemeImageUrlsfeOb9K0, composerK, 0), ComposableLambdaKt.e(1369202481, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview_Margin_Padding.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    if ((i4 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(1369202481, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview_Margin_Padding.<anonymous> (ImageComponentView.kt:313)");
                    }
                    Modifier modifierD = BackgroundKt.d(SizeKt.i(Modifier.b8, Dp.g(200)), Color.f25715b.e(), null, 2, null);
                    ThemeImageUrls themeImageUrls = themeImageUrlsM720previewThemeImageUrlsfeOb9K0;
                    MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
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
                    Updater.e(composerA, measurePolicyG, companion.e());
                    Updater.e(composerA, compositionLocalMapU, companion.g());
                    Function2 function2B = companion.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion.f());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                    float f3 = 20;
                    ImageComponentViewKt.ImageComponentView(ImageComponentViewKt.previewImageComponentStyle(themeImageUrls, new Size(new SizeConstraint.Fixed(RCHTTPStatusCodes.BAD_REQUEST, null), new SizeConstraint.Fixed(RCHTTPStatusCodes.BAD_REQUEST, null)), FitMode.FIT, new MaskShape.Rectangle(new CornerRadiuses.Dp(20.0d, 20.0d, 20.0d, 20.0d)), false, null, PaddingKt.a(Dp.g(f3)), PaddingKt.a(Dp.g(f3)), null, null, composer2, 819465648, RCHTTPStatusCodes.NOT_MODIFIED), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), null, composer2, 0, 4);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview_Margin_Padding.2
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
                    ImageComponentViewKt.ImageComponentView_Preview_Margin_Padding(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(precision = 0.99f)
    public static final void ImageComponentView_Preview_MaskShape(@PreviewParameter final MaskShape maskShape, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(916782022);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(maskShape) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(916782022, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview_MaskShape (ImageComponentView.kt:461)");
            }
            final ThemeImageUrls themeImageUrlsM720previewThemeImageUrlsfeOb9K0 = m720previewThemeImageUrlsfeOb9K0(RCHTTPStatusCodes.BAD_REQUEST, 200);
            ImagePreviewsKt.ProvidePreviewImageLoader(previewImageLoader(themeImageUrlsM720previewThemeImageUrlsfeOb9K0, composerK, 0), ComposableLambdaKt.e(-569034613, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview_MaskShape.1
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
                        ComposerKt.U(-569034613, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview_MaskShape.<anonymous> (ImageComponentView.kt:464)");
                    }
                    Modifier modifierD = BackgroundKt.d(Modifier.b8, Color.f25715b.b(), null, 2, null);
                    ThemeImageUrls themeImageUrls = themeImageUrlsM720previewThemeImageUrlsfeOb9K0;
                    MaskShape maskShape2 = maskShape;
                    MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
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
                    Updater.e(composerA, measurePolicyG, companion.e());
                    Updater.e(composerA, compositionLocalMapU, companion.g());
                    Function2 function2B = companion.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion.f());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                    ImageComponentViewKt.ImageComponentView(ImageComponentViewKt.previewImageComponentStyle(themeImageUrls, new Size(new SizeConstraint.Fixed(RCHTTPStatusCodes.BAD_REQUEST, null), new SizeConstraint.Fixed(200, null)), FitMode.FIT, maskShape2, false, null, null, null, null, null, composer2, 432, 1008), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), null, composer2, 0, 4);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview_MaskShape.2
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
                    ImageComponentViewKt.ImageComponentView_Preview_MaskShape(maskShape, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(precision = 0.99f)
    public static final void ImageComponentView_Preview_RadialGradient(Composer composer, final int i3) {
        Composer composerK = composer.k(1728211453);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1728211453, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview_RadialGradient (ImageComponentView.kt:398)");
            }
            final ThemeImageUrls themeImageUrlsM720previewThemeImageUrlsfeOb9K0 = m720previewThemeImageUrlsfeOb9K0(RCHTTPStatusCodes.BAD_REQUEST, RCHTTPStatusCodes.BAD_REQUEST);
            ImagePreviewsKt.ProvidePreviewImageLoader(previewImageLoader(themeImageUrlsM720previewThemeImageUrlsfeOb9K0, composerK, 0), ComposableLambdaKt.e(-827207358, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview_RadialGradient.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    if ((i4 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-827207358, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview_RadialGradient.<anonymous> (ImageComponentView.kt:401)");
                    }
                    Modifier modifierD = BackgroundKt.d(Modifier.b8, Color.f25715b.i(), null, 2, null);
                    ThemeImageUrls themeImageUrls = themeImageUrlsM720previewThemeImageUrlsfeOb9K0;
                    MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
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
                    Updater.e(composerA, measurePolicyG, companion.e());
                    Updater.e(composerA, compositionLocalMapU, companion.g());
                    Function2 function2B = companion.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion.f());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                    ImageComponentViewKt.ImageComponentView(ImageComponentViewKt.previewImageComponentStyle(themeImageUrls, new Size(new SizeConstraint.Fixed(RCHTTPStatusCodes.BAD_REQUEST, null), SizeConstraint.Fit.INSTANCE), FitMode.FIT, new MaskShape.Rectangle(new CornerRadiuses.Dp(20.0d, 20.0d, 20.0d, 20.0d)), false, new ColorStyles(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Radial(CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(android.graphics.Color.parseColor("#88FF0000"), 0.0f), new ColorInfo.Gradient.Point(android.graphics.Color.parseColor("#8800FF00"), 50.0f), new ColorInfo.Gradient.Point(android.graphics.Color.parseColor("#880000FF"), 100.0f)}))), null, 2, null), null, null, null, null, composer2, 3504, 976), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), null, composer2, 0, 4);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview_RadialGradient.2
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
                    ImageComponentViewKt.ImageComponentView_Preview_RadialGradient(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(precision = 0.99f)
    public static final void ImageComponentView_Preview_SmallerContainer(Composer composer, final int i3) {
        Composer composerK = composer.k(-1125682689);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1125682689, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentView_Preview_SmallerContainer (ImageComponentView.kt:280)");
            }
            final ThemeImageUrls themeImageUrlsM720previewThemeImageUrlsfeOb9K0 = m720previewThemeImageUrlsfeOb9K0(RCHTTPStatusCodes.BAD_REQUEST, RCHTTPStatusCodes.BAD_REQUEST);
            ImagePreviewsKt.ProvidePreviewImageLoader(previewImageLoader(themeImageUrlsM720previewThemeImageUrlsfeOb9K0, composerK, 0), ComposableLambdaKt.e(-161866748, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview_SmallerContainer.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    if ((i4 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-161866748, i4, -1, jTYhJgqLBN.OWWoP);
                    }
                    Modifier modifierD = BackgroundKt.d(SizeKt.i(Modifier.b8, Dp.g(200)), Color.f25715b.b(), null, 2, null);
                    ThemeImageUrls themeImageUrls = themeImageUrlsM720previewThemeImageUrlsfeOb9K0;
                    MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
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
                    Updater.e(composerA, measurePolicyG, companion.e());
                    Updater.e(composerA, compositionLocalMapU, companion.g());
                    Function2 function2B = companion.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion.f());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                    ImageComponentViewKt.ImageComponentView(ImageComponentViewKt.previewImageComponentStyle(themeImageUrls, new Size(new SizeConstraint.Fixed(RCHTTPStatusCodes.BAD_REQUEST, null), new SizeConstraint.Fixed(RCHTTPStatusCodes.BAD_REQUEST, null)), FitMode.FIT, new MaskShape.Rectangle(new CornerRadiuses.Dp(20.0d, 20.0d, 20.0d, 20.0d)), false, null, null, null, null, null, composer2, 3504, 1008), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), null, composer2, 0, 4);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt.ImageComponentView_Preview_SmallerContainer.2
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
                    ImageComponentViewKt.ImageComponentView_Preview_SmallerContainer(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageComponentStyle previewImageComponentStyle(ThemeImageUrls themeImageUrls, Size size, FitMode fitMode, MaskShape maskShape, boolean z2, ColorStyles colorStyles, PaddingValues paddingValues, PaddingValues paddingValues2, BorderStyles borderStyles, ShadowStyles shadowStyles, Composer composer, int i3, int i4) {
        composer.a0(-1478132064);
        boolean z3 = (i4 & 16) != 0 ? true : z2;
        ColorStyles colorStyles2 = (i4 & 32) != 0 ? null : colorStyles;
        PaddingValues paddingValuesA = (i4 & 64) != 0 ? PaddingKt.a(Dp.g(0)) : paddingValues;
        PaddingValues paddingValuesA2 = (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? PaddingKt.a(Dp.g(0)) : paddingValues2;
        BorderStyles borderStyles2 = (i4 & Function.MAX_NARGS) != 0 ? new BorderStyles(Dp.g(2), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.c())), null, 2, null), null) : borderStyles;
        ShadowStyles shadowStyles2 = (i4 & 512) != 0 ? new ShadowStyles(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.a())), null, 2, null), Dp.g(10), Dp.g(0), Dp.g(3), null) : shadowStyles;
        if (ComposerKt.M()) {
            ComposerKt.U(-1478132064, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.previewImageComponentStyle (ImageComponentView.kt:522)");
        }
        ImageComponentStyle imageComponentStyle = new ImageComponentStyle(NonEmptyMapKt.nonEmptyMapOf(TuplesKt.a(LocaleId.m612boximpl(LocaleId.m613constructorimpl("en_US")), themeImageUrls), new Pair[0]), z3, size, paddingValuesA, paddingValuesA2, ShapeKt.toShape(maskShape), borderStyles2, shadowStyles2, colorStyles2, FitModeKt.toContentScale(fitMode), null, null, null, null, CollectionsKt.emptyList(), false, 43008, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return imageComponentStyle;
    }

    private static final ImageLoader previewImageLoader(ThemeImageUrls themeImageUrls, Composer composer, int i3) {
        composer.a0(-845849021);
        if (ComposerKt.M()) {
            ComposerKt.U(-845849021, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.previewImageLoader (ImageComponentView.kt:540)");
        }
        ImageLoader imageLoaderPreviewImageLoader = previewImageLoader(ThemeImageUrlsKt.getUrlsForCurrentTheme(themeImageUrls, composer, i3 & 14), 0, composer, 0, 2);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return imageLoaderPreviewImageLoader;
    }

    /* JADX INFO: renamed from: previewThemeImageUrls-feOb9K0, reason: not valid java name */
    private static final ThemeImageUrls m720previewThemeImageUrlsfeOb9K0(int i3, int i4) {
        return new ThemeImageUrls(new ImageUrls(new URL("https://preview"), new URL("https://preview"), new URL("https://preview"), i3, i4, null), (ImageUrls) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: renamed from: toBitmap-gd2BlFg, reason: not valid java name */
    public static final Bitmap m721toBitmapgd2BlFg(Drawable toBitmap, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(toBitmap, "$this$toBitmap");
        Rect bounds = toBitmap.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "bounds");
        int i6 = bounds.left;
        int i7 = bounds.top;
        int i8 = bounds.right;
        int i9 = bounds.bottom;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width.toInt…oInt(), Config.ARGB_8888)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(i5);
        toBitmap.setBounds(0, 0, i3, i4);
        toBitmap.draw(canvas);
        toBitmap.setBounds(i6, i7, i8, i9);
        return bitmapCreateBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int toRgbColor(String str) {
        int iHashCode = str.hashCode();
        return (iHashCode & 255) | (((iHashCode >> 16) & 255) << 16) | (-16777216) | (((iHashCode >> 8) & 255) << 8);
    }

    private static final ImageLoader previewImageLoader(final ImageUrls imageUrls, final int i3, Composer composer, int i4, int i5) {
        composer.a0(-536172673);
        if ((i5 & 2) != 0) {
            i3 = R.drawable.f92317android;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-536172673, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.previewImageLoader (ImageComponentView.kt:546)");
        }
        final Context context = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
        ImageLoader.Builder builder = new ImageLoader.Builder(context);
        ComponentRegistry.Builder builder2 = new ComponentRegistry.Builder();
        composer.a0(-2000731791);
        boolean zI = composer.I(context) | ((((i4 & 112) ^ 48) > 32 && composer.e(i3)) || (i4 & 48) == 32) | ((((i4 & 14) ^ 6) > 4 && composer.Z(imageUrls)) || (i4 & 6) == 4);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Interceptor() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentViewKt$previewImageLoader$1$1$1
                @Override // coil.intercept.Interceptor
                public final Object intercept(Interceptor.Chain chain, Continuation<? super ImageResult> continuation) {
                    Resources resources = chain.b().l().getResources();
                    Drawable drawable = context.getDrawable(i3);
                    Intrinsics.checkNotNull(drawable);
                    int iM661getWidthpVg5ArA = imageUrls.m661getWidthpVg5ArA();
                    int iM660getHeightpVg5ArA = imageUrls.m660getHeightpVg5ArA();
                    ImageUrls imageUrls2 = imageUrls;
                    StringBuilder sb = new StringBuilder();
                    sb.append(imageUrls2.getOriginal());
                    sb.append(':');
                    sb.append((Object) UInt.e(imageUrls2.m661getWidthpVg5ArA()));
                    sb.append((Object) UInt.e(imageUrls2.m660getHeightpVg5ArA()));
                    return new SuccessResult(new BitmapDrawable(resources, ImageComponentViewKt.m721toBitmapgd2BlFg(drawable, iM661getWidthpVg5ArA, iM660getHeightpVg5ArA, ImageComponentViewKt.toRgbColor(sb.toString()))), chain.b(), DataSource.MEMORY, null, null, false, false, 120, null);
                }
            };
            composer.w(objG);
        }
        composer.U();
        builder2.c((Interceptor) objG);
        ImageLoader imageLoaderB = builder.c(builder2.f()).b();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return imageLoaderB;
    }
}
