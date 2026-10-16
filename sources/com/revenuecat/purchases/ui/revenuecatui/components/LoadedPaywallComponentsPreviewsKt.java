package com.revenuecat.purchases.ui.revenuecatui.components;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.emergetools.snapshots.annotations.EmergeSnapshotConfig;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.components.HeaderComponent;
import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.ImageComponent;
import com.revenuecat.purchases.paywalls.components.PackageComponent;
import com.revenuecat.purchases.paywalls.components.PaywallComponent;
import com.revenuecat.purchases.paywalls.components.PaywallTransition;
import com.revenuecat.purchases.paywalls.components.PurchaseButtonComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent;
import com.revenuecat.purchases.paywalls.components.TextComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.ComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.ExitOffers;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.LocalizationData;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData;
import com.revenuecat.purchases.paywalls.components.common.ProductChangeConfig;
import com.revenuecat.purchases.paywalls.components.common.PromoOfferConfig;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.ImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.TwoDimensionalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignment;
import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.data.MockPurchasesType;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ImagePreviewsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.OfferingToStateMapperKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallValidationResult;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
public final /* synthetic */ class LoadedPaywallComponentsPreviewsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_Header_ZLayer_Preview(Composer composer, final int i3) {
        Composer composer2;
        Composer composerK = composer.k(-187042489);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-187042489, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Header_ZLayer_Preview (LoadedPaywallComponentsPreviews.kt:65)");
            }
            ColorScheme colorScheme = new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.d(4280756007L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme2 = new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.d(4294835709L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            URL url = new URL("https://assets.pawwalls.com/1172568_1774614615_69db5d9d.webp");
            IconComponent iconComponent = new IconComponent("https://icons.pawwalls.com/icons", "x", new IconComponent.Formats("x.webp"), (Boolean) null, new Size(new SizeConstraint.Fixed(32, null), new SizeConstraint.Fixed(32, null)), new ColorScheme(new ColorInfo.Hex(ColorKt.k(Color.f25715b.a())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), new Padding(6.0d, 6.0d, 6.0d, 6.0d), (Padding) null, new IconComponent.IconBackground(colorScheme2, MaskShape.Circle.INSTANCE, (Border) null, (Shadow) null, 12, (DefaultConstructorMarker) null), (List) null, 648, (DefaultConstructorMarker) null);
            ButtonComponent.Action.NavigateBack navigateBack = ButtonComponent.Action.NavigateBack.INSTANCE;
            List listListOf = CollectionsKt.listOf(iconComponent);
            HorizontalAlignment horizontalAlignment = HorizontalAlignment.LEADING;
            FlexDistribution flexDistribution = FlexDistribution.START;
            Dimension.Vertical vertical = new Dimension.Vertical(horizontalAlignment, flexDistribution);
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            ButtonComponent buttonComponent = new ButtonComponent(navigateBack, new StackComponent(listListOf, (Boolean) null, vertical, new Size(fit, fit), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, new Padding(16.0d, 16.0d, 16.0d, 16.0d), (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65266, (DefaultConstructorMarker) null), (PaywallTransition) null, (String) null, (String) null, 28, (DefaultConstructorMarker) null);
            ThemeImageUrls themeImageUrls = new ThemeImageUrls(new ImageUrls(url, url, url, 1024, 1024, null), (ImageUrls) null, 2, (DefaultConstructorMarker) null);
            FitMode fitMode = FitMode.FIT;
            SizeConstraint.Fill fill = SizeConstraint.Fill.INSTANCE;
            StackComponent stackComponent = new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new ImageComponent(themeImageUrls, (Boolean) null, new Size(fill, fit), (String) null, (MaskShape) null, (ColorScheme) null, fitMode, (Padding) null, (Padding) null, (Border) null, (Shadow) null, (List) null, 4026, (DefaultConstructorMarker) null), new TextComponent(LocalizationKey.m649constructorimpl("overlay-text"), new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.d(4284677123L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 14, horizontalAlignment, new Size(fit, fit), (Padding) null, (Padding) null, (List) null, (String) null, 15484, (DefaultConstructorMarker) null)}), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.TOP_LEADING), new Size(fill, fit), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65522, (DefaultConstructorMarker) null);
            URL url2 = new URL("https://assets.pawwalls.com");
            String strM649constructorimpl = LocalizationKey.m649constructorimpl("title");
            FontWeight fontWeight = FontWeight.BOLD;
            HorizontalAlignment horizontalAlignment2 = HorizontalAlignment.CENTER;
            Offering offering = new Offering("header_zlayer", "Header with ZLayer image + text", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getMonthly()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData("preview_header_zlayer", SDKConstants.PARAM_UPDATE_TEMPLATE, url2, new ComponentsConfig(new PaywallComponentsConfig(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{stackComponent, new TextComponent(strM649constructorimpl, colorScheme, (Boolean) null, (ColorScheme) null, (String) null, fontWeight, (Integer) null, 24, horizontalAlignment2, new Size(fit, fit), (Padding) null, new Padding(0.0d, 0.0d, 50.0d, 50.0d), (List) null, (String) null, 13404, (DefaultConstructorMarker) null)}), (Boolean) null, new Dimension.Vertical(horizontalAlignment2, flexDistribution), new Size(fill, fit), Float.valueOf(8.0f), (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65506, (DefaultConstructorMarker) null), new Background.Color(colorScheme2), new StickyFooterComponent(new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m649constructorimpl("footer"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 0, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, (List) null, (String) null, 16380, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(horizontalAlignment2, flexDistribution), (Size) null, (Float) null, colorScheme2, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65498, (DefaultConstructorMarker) null)), new HeaderComponent(new StackComponent(CollectionsKt.listOf(new StackComponent(CollectionsKt.listOf(buttonComponent), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.TOP_TRAILING), new Size(fill, fit), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65522, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(horizontalAlignment, flexDistribution), new Size(fill, fit), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, new Shadow(new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.b(855638016))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), 16.0d, 0.0d, 4.0d), (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 63474, (DefaultConstructorMarker) null)))), MapsKt.mapOf(TuplesKt.a(LocaleId.m612boximpl(LocaleId.m613constructorimpl("en_US")), MapsKt.mapOf(TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("title")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("Unlock Your Smartest Study Routine"))), TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("overlay-text")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("Featured"))), TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("footer")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("Try free for 1 week")))))), LocaleId.m613constructorimpl("en_US"), 0, (List) null, (ExitOffers) null, (ProductChangeConfig) null, 960, (DefaultConstructorMarker) null)), null, 80, null);
            composer2 = composerK;
            Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composer2, 0);
            PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
            Intrinsics.checkNotNull(components);
            final PaywallState.Loaded.Components componentsPaywallState$default = OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, null, new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Header_ZLayer_Preview$state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, 15, null), null, null, 48, null);
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composer2, 0, 1), ComposableLambdaKt.e(-969555742, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Header_ZLayer_Preview.1

                /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Header_ZLayer_Preview$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Header_ZLayer_Preview$1$1", f = "LoadedPaywallComponentsPreviews.kt", l = {}, m = "invokeSuspend")
                static final class C01991 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
                    int label;

                    C01991(Continuation<? super C01991> continuation) {
                        super(2, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C01991(continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
                        return ((C01991) create(external, continuation)).invokeSuspend(Unit.f139807a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        IntrinsicsKt.f();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.ResultKt.b(obj);
                        return Unit.f139807a;
                    }
                }

                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i4) {
                    if ((i4 & 3) == 2 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-969555742, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Header_ZLayer_Preview.<anonymous> (LoadedPaywallComponentsPreviews.kt:205)");
                    }
                    LoadedPaywallComponentsKt.LoadedPaywallComponents(componentsPaywallState$default, new C01991(null), SizeKt.f(Modifier.b8, 0.0f, 1, null), null, composer3, 432, 8);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composer2, 54), composer2, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Header_ZLayer_Preview.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i4) {
                    LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Header_ZLayer_Preview(composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_Preview_DirectImageAsBackground(Composer composer, final int i3) {
        Composer composerK = composer.k(-1936797168);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1936797168, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_DirectImageAsBackground (LoadedPaywallComponentsPreviews.kt:832)");
            }
            ColorScheme colorScheme = new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.d(4280756007L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme2 = new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.d(4294835709L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            URL url = new URL("https://assets.pawwalls.com/1172568_1774614837_7df8aa27.webp");
            String strM649constructorimpl = LocalizationKey.m649constructorimpl("overlay-text");
            ColorScheme colorScheme3 = new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.d(4294508801L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            HorizontalAlignment horizontalAlignment = HorizontalAlignment.LEADING;
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            List listListOf = CollectionsKt.listOf(new TextComponent(strM649constructorimpl, colorScheme3, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 14, horizontalAlignment, new Size(fit, fit), (Padding) null, (Padding) null, (List) null, (String) null, 15484, (DefaultConstructorMarker) null));
            Dimension.ZLayer zLayer = new Dimension.ZLayer(TwoDimensionalAlignment.TOP_LEADING);
            SizeConstraint.Fill fill = SizeConstraint.Fill.INSTANCE;
            StackComponent stackComponent = new StackComponent(listListOf, (Boolean) null, zLayer, new Size(fill, new SizeConstraint.Fixed(300, null)), (Float) null, (ColorScheme) null, new Background.Image(new ThemeImageUrls(new ImageUrls(url, url, url, 1024, 1024, null), (ImageUrls) null, 2, (DefaultConstructorMarker) null), FitMode.FILL, (ColorScheme) null, 4, (DefaultConstructorMarker) null), (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65458, (DefaultConstructorMarker) null);
            URL url2 = new URL("https://assets.pawwalls.com");
            String strM649constructorimpl2 = LocalizationKey.m649constructorimpl("title");
            FontWeight fontWeight = FontWeight.BOLD;
            HorizontalAlignment horizontalAlignment2 = HorizontalAlignment.CENTER;
            List listListOf2 = CollectionsKt.listOf((Object[]) new PaywallComponent[]{stackComponent, new TextComponent(strM649constructorimpl2, colorScheme, (Boolean) null, (ColorScheme) null, (String) null, fontWeight, (Integer) null, 24, horizontalAlignment2, new Size(fit, fit), (Padding) null, new Padding(0.0d, 0.0d, 50.0d, 50.0d), (List) null, (String) null, 13404, (DefaultConstructorMarker) null), TestData.Components.INSTANCE.getMonthlyPackageComponent()});
            FlexDistribution flexDistribution = FlexDistribution.START;
            Offering offering = new Offering("direct_image_background", "Direct image as background, no header", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getAnnual()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData("preview_direct_image_background", SDKConstants.PARAM_UPDATE_TEMPLATE, url2, new ComponentsConfig(new PaywallComponentsConfig(new StackComponent(listListOf2, (Boolean) null, new Dimension.Vertical(horizontalAlignment2, flexDistribution), new Size(fill, fit), Float.valueOf(8.0f), (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65506, (DefaultConstructorMarker) null), new Background.Color(colorScheme2), new StickyFooterComponent(new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m649constructorimpl("footer"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 0, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, (List) null, (String) null, 16380, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(horizontalAlignment2, flexDistribution), (Size) null, (Float) null, colorScheme2, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65498, (DefaultConstructorMarker) null)), (HeaderComponent) null, 8, (DefaultConstructorMarker) null)), MapsKt.mapOf(TuplesKt.a(LocaleId.m612boximpl(LocaleId.m613constructorimpl("en_US")), MapsKt.mapOf(TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("title")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("Unlock Your Smartest Study Routine"))), TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("overlay-text")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("Text in stack"))), TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("footer")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("Try free for 1 week")))))), LocaleId.m613constructorimpl("en_US"), 0, (List) null, (ExitOffers) null, (ProductChangeConfig) null, 960, (DefaultConstructorMarker) null)), null, 80, null);
            Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composerK, 0);
            PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
            Intrinsics.checkNotNull(components);
            final PaywallState.Loaded.Components componentsPaywallState$default = OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, "US", new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_DirectImageAsBackground$state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, 15, null), null, null, 48, null);
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerK, 0, 1), ComposableLambdaKt.e(677451755, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_DirectImageAsBackground.1

                /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_DirectImageAsBackground$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_DirectImageAsBackground$1$1", f = "LoadedPaywallComponentsPreviews.kt", l = {}, m = "invokeSuspend")
                static final class C02001 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
                    int label;

                    C02001(Continuation<? super C02001> continuation) {
                        super(2, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C02001(continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
                        return ((C02001) create(external, continuation)).invokeSuspend(Unit.f139807a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        IntrinsicsKt.f();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.ResultKt.b(obj);
                        return Unit.f139807a;
                    }
                }

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
                        ComposerKt.U(677451755, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_DirectImageAsBackground.<anonymous> (LoadedPaywallComponentsPreviews.kt:929)");
                    }
                    LoadedPaywallComponentsKt.LoadedPaywallComponents(componentsPaywallState$default, new C02001(null), SizeKt.f(Modifier.b8, 0.0f, 1, null), null, composer2, 432, 8);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_DirectImageAsBackground.2
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
                    LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_DirectImageAsBackground(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(precision = 0.99f)
    public static final void LoadedPaywallComponents_Preview_HeaderDirectHeroImage(Composer composer, final int i3) {
        Composer composer2;
        Composer composerK = composer.k(-1461797559);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1461797559, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_HeaderDirectHeroImage (LoadedPaywallComponentsPreviews.kt:218)");
            }
            ColorScheme colorScheme = new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.d(4280756007L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            Color.Companion companion = Color.f25715b;
            ColorScheme colorScheme2 = new ColorScheme(new ColorInfo.Hex(ColorKt.k(companion.l())), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme3 = new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.d(4283782485L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            URL url = new URL("https://assets.pawwalls.com/1172568_1774614837_7df8aa27.webp");
            ThemeImageUrls themeImageUrls = new ThemeImageUrls(new ImageUrls(url, url, url, 1024, 1024, null), (ImageUrls) null, 2, (DefaultConstructorMarker) null);
            FitMode fitMode = FitMode.FIT;
            SizeConstraint.Fill fill = SizeConstraint.Fill.INSTANCE;
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            ImageComponent imageComponent = new ImageComponent(themeImageUrls, (Boolean) null, new Size(fill, fit), (String) null, (MaskShape) null, new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.b(855638016))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), fitMode, (Padding) null, (Padding) null, (Border) null, (Shadow) null, (List) null, 3994, (DefaultConstructorMarker) null);
            IconComponent iconComponent = new IconComponent("https://icons.pawwalls.com/icons", "x", new IconComponent.Formats("x.webp"), (Boolean) null, new Size(new SizeConstraint.Fixed(32, null), new SizeConstraint.Fixed(32, null)), new ColorScheme(new ColorInfo.Hex(ColorKt.k(companion.a())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), new Padding(6.0d, 6.0d, 6.0d, 6.0d), (Padding) null, new IconComponent.IconBackground(colorScheme2, MaskShape.Circle.INSTANCE, (Border) null, (Shadow) null, 12, (DefaultConstructorMarker) null), (List) null, 648, (DefaultConstructorMarker) null);
            ButtonComponent.Action.NavigateBack navigateBack = ButtonComponent.Action.NavigateBack.INSTANCE;
            List listListOf = CollectionsKt.listOf(iconComponent);
            HorizontalAlignment horizontalAlignment = HorizontalAlignment.LEADING;
            FlexDistribution flexDistribution = FlexDistribution.START;
            ButtonComponent buttonComponent = new ButtonComponent(navigateBack, new StackComponent(listListOf, (Boolean) null, new Dimension.Vertical(horizontalAlignment, flexDistribution), new Size(fit, fit), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, new Padding(16.0d, 16.0d, 16.0d, 16.0d), (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65266, (DefaultConstructorMarker) null), (PaywallTransition) null, (String) null, (String) null, 28, (DefaultConstructorMarker) null);
            URL url2 = new URL("https://assets.pawwalls.com");
            String strM649constructorimpl = LocalizationKey.m649constructorimpl("title");
            FontWeight fontWeight = FontWeight.BOLD;
            HorizontalAlignment horizontalAlignment2 = HorizontalAlignment.CENTER;
            StackComponent stackComponent = new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new TextComponent(strM649constructorimpl, colorScheme, (Boolean) null, (ColorScheme) null, (String) null, fontWeight, (Integer) null, 24, horizontalAlignment2, new Size(fit, fit), (Padding) null, new Padding(16.0d, 0.0d, 50.0d, 50.0d), (List) null, (String) null, 13404, (DefaultConstructorMarker) null), new TextComponent(LocalizationKey.m649constructorimpl("subtitle"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 15, horizontalAlignment2, new Size(fit, fit), (Padding) null, new Padding(8.0d, 0.0d, 24.0d, 24.0d), (List) null, (String) null, 13436, (DefaultConstructorMarker) null), TestData.Components.INSTANCE.getMonthlyPackageComponent()}), (Boolean) null, new Dimension.Vertical(horizontalAlignment2, flexDistribution), new Size(fill, fit), Float.valueOf(8.0f), (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65506, (DefaultConstructorMarker) null);
            Background.Color color = new Background.Color(colorScheme2);
            HeaderComponent headerComponent = new HeaderComponent(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{imageComponent, buttonComponent}), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.TOP_TRAILING), new Size(fill, fit), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, new Border(new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.b(1140850688))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), 1.0d), (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 64498, (DefaultConstructorMarker) null));
            PackageComponent packageComponent = new PackageComponent("$rc_annual", true, new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m649constructorimpl("package-info"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 14, horizontalAlignment, new Size(fit, fit), (Padding) null, (Padding) null, (List) null, (String) null, 15484, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(horizontalAlignment2, flexDistribution), new Size(fill, fit), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, new Shape.Rectangle(new CornerRadiuses.Dp(8.0d)), (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65010, (DefaultConstructorMarker) null), (PromoOfferConfig) null, (String) null, (Boolean) null, (List) null, 120, (DefaultConstructorMarker) null);
            String strM649constructorimpl2 = LocalizationKey.m649constructorimpl(SDKConstants.PARAM_GAME_REQUESTS_CTA);
            ColorScheme colorScheme4 = new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.d(4278979596L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            FontWeight fontWeight2 = FontWeight.SEMI_BOLD;
            Offering offering = new Offering("header_direct_hero", "Header with direct hero image", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getAnnual()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData("preview_header_direct_hero", SDKConstants.PARAM_UPDATE_TEMPLATE, url2, new ComponentsConfig(new PaywallComponentsConfig(stackComponent, color, new StickyFooterComponent(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{packageComponent, new PurchaseButtonComponent(new StackComponent(CollectionsKt.listOf(new TextComponent(strM649constructorimpl2, colorScheme4, (Boolean) null, (ColorScheme) null, (String) null, fontWeight2, (Integer) null, 16, horizontalAlignment2, new Size(fit, fit), (Padding) null, (Padding) null, (List) null, (String) null, 15452, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(horizontalAlignment2, flexDistribution), new Size(fill, fit), (Float) null, new ColorScheme(new ColorInfo.Gradient.Linear(15.0f, CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.k(ColorKt.d(4286377127L)), 0.0f), new ColorInfo.Gradient.Point(ColorKt.k(ColorKt.d(4286509283L)), 100.0f)})), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Background) null, new Padding(12.0d, 12.0d, 8.0d, 8.0d), (Padding) null, new Shape.Rectangle(new CornerRadiuses.Dp(12.0d)), (Border) null, new Shadow(new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.d(2156724156L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), 8.0d, 4.0d, 4.0d), (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 62802, (DefaultConstructorMarker) null), (PurchaseButtonComponent.Action) null, (PurchaseButtonComponent.Method) null, (String) null, 14, (DefaultConstructorMarker) null), new StackComponent(CollectionsKt.listOf(new ButtonComponent(ButtonComponent.Action.RestorePurchases.INSTANCE, new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m649constructorimpl("restore"), colorScheme3, (Boolean) null, (ColorScheme) null, (String) null, fontWeight2, (Integer) null, 13, horizontalAlignment, new Size(fit, fit), (Padding) null, (Padding) null, (List) null, (String) null, 15452, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(horizontalAlignment, FlexDistribution.SPACE_BETWEEN), new Size(fit, fit), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65522, (DefaultConstructorMarker) null), (PaywallTransition) null, (String) null, (String) null, 28, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Horizontal(VerticalAlignment.TOP, FlexDistribution.CENTER), new Size(fill, fit), Float.valueOf(32.0f), (ColorScheme) null, (Background) null, (Padding) null, new Padding(12.0d, 0.0d, 0.0d, 0.0d), (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65250, (DefaultConstructorMarker) null)}), (Boolean) null, new Dimension.Vertical(horizontalAlignment, flexDistribution), new Size(fill, fit), (Float) null, colorScheme2, (Background) null, new Padding(12.0d, 0.0d, 16.0d, 16.0d), (Padding) null, (Shape) null, (Border) null, new Shadow(new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.b(251658240))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), 16.0d, 0.0d, -4.0d), (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 63314, (DefaultConstructorMarker) null)), headerComponent)), MapsKt.mapOf(TuplesKt.a(LocaleId.m612boximpl(LocaleId.m613constructorimpl("en_US")), MapsKt.mapOf(TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("title")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("Unlock Your Smartest Study Routine"))), TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("subtitle")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("AI-powered flashcards, smart scheduling, and progress tracking."))), TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("package-info")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("Subscribe to Pro for just {{ product.price_per_period_abbreviated }}"))), TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl(SDKConstants.PARAM_GAME_REQUESTS_CTA)), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("Continue"))), TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("restore")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("Restore Purchases")))))), LocaleId.m613constructorimpl("en_US"), 0, (List) null, (ExitOffers) null, (ProductChangeConfig) null, 960, (DefaultConstructorMarker) null)), null, 80, null);
            composer2 = composerK;
            Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composer2, 0);
            PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
            Intrinsics.checkNotNull(components);
            final PaywallState.Loaded.Components componentsPaywallState$default = OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, "US", new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderDirectHeroImage$state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, 15, null), null, null, 48, null);
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composer2, 0, 1), ComposableLambdaKt.e(-122765852, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderDirectHeroImage.1

                /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderDirectHeroImage$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderDirectHeroImage$1$1", f = "LoadedPaywallComponentsPreviews.kt", l = {}, m = "invokeSuspend")
                static final class C02011 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
                    int label;

                    C02011(Continuation<? super C02011> continuation) {
                        super(2, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C02011(continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
                        return ((C02011) create(external, continuation)).invokeSuspend(Unit.f139807a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        IntrinsicsKt.f();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.ResultKt.b(obj);
                        return Unit.f139807a;
                    }
                }

                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i4) {
                    if ((i4 & 3) == 2 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-122765852, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_HeaderDirectHeroImage.<anonymous> (LoadedPaywallComponentsPreviews.kt:464)");
                    }
                    LoadedPaywallComponentsKt.LoadedPaywallComponents(componentsPaywallState$default, new C02011(null), SizeKt.f(Modifier.b8, 0.0f, 1, null), null, composer3, 432, 8);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composer2, 54), composer2, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderDirectHeroImage.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i4) {
                    LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderDirectHeroImage(composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_Preview_HeaderNestedStackWithImage(Composer composer, final int i3) {
        Composer composer2;
        Composer composerK = composer.k(847814897);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(847814897, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_HeaderNestedStackWithImage (LoadedPaywallComponentsPreviews.kt:940)");
            }
            ColorScheme colorScheme = new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.d(4280756007L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme2 = new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.d(4294835709L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            URL url = new URL("https://assets.pawwalls.com/1172568_1774614837_7df8aa27.webp");
            IconComponent iconComponent = new IconComponent("https://icons.pawwalls.com/icons", "x", new IconComponent.Formats("x.webp"), (Boolean) null, new Size(new SizeConstraint.Fixed(32, null), new SizeConstraint.Fixed(32, null)), new ColorScheme(new ColorInfo.Hex(ColorKt.k(Color.f25715b.a())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), new Padding(6.0d, 6.0d, 6.0d, 6.0d), (Padding) null, new IconComponent.IconBackground(colorScheme2, MaskShape.Circle.INSTANCE, (Border) null, (Shadow) null, 12, (DefaultConstructorMarker) null), (List) null, 648, (DefaultConstructorMarker) null);
            ButtonComponent.Action.NavigateBack navigateBack = ButtonComponent.Action.NavigateBack.INSTANCE;
            List listListOf = CollectionsKt.listOf(iconComponent);
            HorizontalAlignment horizontalAlignment = HorizontalAlignment.LEADING;
            FlexDistribution flexDistribution = FlexDistribution.START;
            Dimension.Vertical vertical = new Dimension.Vertical(horizontalAlignment, flexDistribution);
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            ButtonComponent buttonComponent = new ButtonComponent(navigateBack, new StackComponent(listListOf, (Boolean) null, vertical, new Size(fit, fit), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, new Padding(16.0d, 16.0d, 16.0d, 16.0d), (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65266, (DefaultConstructorMarker) null), (PaywallTransition) null, (String) null, (String) null, 28, (DefaultConstructorMarker) null);
            ThemeImageUrls themeImageUrls = new ThemeImageUrls(new ImageUrls(url, url, url, 1024, 1024, null), (ImageUrls) null, 2, (DefaultConstructorMarker) null);
            FitMode fitMode = FitMode.FIT;
            SizeConstraint.Fill fill = SizeConstraint.Fill.INSTANCE;
            List listListOf2 = CollectionsKt.listOf(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new ImageComponent(themeImageUrls, (Boolean) null, new Size(fill, fit), (String) null, (MaskShape) null, (ColorScheme) null, fitMode, (Padding) null, (Padding) null, (Border) null, (Shadow) null, (List) null, 4026, (DefaultConstructorMarker) null), new TextComponent(LocalizationKey.m649constructorimpl("overlay-text"), new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.d(4294508801L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 14, horizontalAlignment, new Size(fit, fit), (Padding) null, (Padding) null, (List) null, (String) null, 15484, (DefaultConstructorMarker) null)}), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.TOP_LEADING), new Size(fill, fit), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65522, (DefaultConstructorMarker) null));
            HorizontalAlignment horizontalAlignment2 = HorizontalAlignment.CENTER;
            Offering offering = new Offering("header_nested_stack_image", "Header with nested stack containing image", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getAnnual()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData("preview_header_nested_stack_image", SDKConstants.PARAM_UPDATE_TEMPLATE, new URL("https://assets.pawwalls.com"), new ComponentsConfig(new PaywallComponentsConfig(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new StackComponent(listListOf2, (Boolean) null, new Dimension.Vertical(horizontalAlignment2, flexDistribution), new Size(fill, fit), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65522, (DefaultConstructorMarker) null), new TextComponent(LocalizationKey.m649constructorimpl("title"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, FontWeight.BOLD, (Integer) null, 24, horizontalAlignment2, new Size(fit, fit), (Padding) null, new Padding(0.0d, 0.0d, 50.0d, 50.0d), (List) null, (String) null, 13404, (DefaultConstructorMarker) null), TestData.Components.INSTANCE.getMonthlyPackageComponent()}), (Boolean) null, new Dimension.Vertical(horizontalAlignment2, flexDistribution), new Size(fill, fit), Float.valueOf(8.0f), (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65506, (DefaultConstructorMarker) null), new Background.Color(colorScheme2), new StickyFooterComponent(new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m649constructorimpl("footer"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 0, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, (List) null, (String) null, 16380, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(horizontalAlignment2, flexDistribution), (Size) null, (Float) null, colorScheme2, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65498, (DefaultConstructorMarker) null)), new HeaderComponent(new StackComponent(CollectionsKt.listOf(new StackComponent(CollectionsKt.listOf(buttonComponent), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.TOP_TRAILING), new Size(fill, fit), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65522, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(horizontalAlignment, flexDistribution), new Size(fill, fit), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, new Shadow(new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.b(855638016))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), 16.0d, 0.0d, 4.0d), (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 63474, (DefaultConstructorMarker) null)))), MapsKt.mapOf(TuplesKt.a(LocaleId.m612boximpl(LocaleId.m613constructorimpl("en_US")), MapsKt.mapOf(TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("title")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("Unlock Your Smartest Study Routine"))), TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("overlay-text")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("Text in stack"))), TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("footer")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("Try free for 1 week")))))), LocaleId.m613constructorimpl("en_US"), 0, (List) null, (ExitOffers) null, (ProductChangeConfig) null, 960, (DefaultConstructorMarker) null)), null, 80, null);
            composer2 = composerK;
            Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composer2, 0);
            PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
            Intrinsics.checkNotNull(components);
            final PaywallState.Loaded.Components componentsPaywallState$default = OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, "US", new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderNestedStackWithImage$state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, 15, null), null, null, 48, null);
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composer2, 0, 1), ComposableLambdaKt.e(1295501622, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderNestedStackWithImage.1

                /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderNestedStackWithImage$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderNestedStackWithImage$1$1", f = "LoadedPaywallComponentsPreviews.kt", l = {}, m = "invokeSuspend")
                static final class C02021 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
                    int label;

                    C02021(Continuation<? super C02021> continuation) {
                        super(2, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C02021(continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
                        return ((C02021) create(external, continuation)).invokeSuspend(Unit.f139807a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        IntrinsicsKt.f();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.ResultKt.b(obj);
                        return Unit.f139807a;
                    }
                }

                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i4) {
                    if ((i4 & 3) == 2 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(1295501622, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_HeaderNestedStackWithImage.<anonymous> (LoadedPaywallComponentsPreviews.kt:1086)");
                    }
                    LoadedPaywallComponentsKt.LoadedPaywallComponents(componentsPaywallState$default, new C02021(null), SizeKt.f(Modifier.b8, 0.0f, 1, null), null, composer3, 432, 8);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composer2, 54), composer2, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderNestedStackWithImage.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i4) {
                    LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderNestedStackWithImage(composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_Preview_HeaderNoZStackNoImage(Composer composer, final int i3) {
        Composer composer2;
        Composer composerK = composer.k(1717104956);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1717104956, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_HeaderNoZStackNoImage (LoadedPaywallComponentsPreviews.kt:713)");
            }
            ColorScheme colorScheme = new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.d(4280756007L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme2 = new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.d(4294835709L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            IconComponent iconComponent = new IconComponent("https://icons.pawwalls.com/icons", "x", new IconComponent.Formats("x.webp"), (Boolean) null, new Size(new SizeConstraint.Fixed(32, null), new SizeConstraint.Fixed(32, null)), new ColorScheme(new ColorInfo.Hex(ColorKt.k(Color.f25715b.a())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), new Padding(6.0d, 6.0d, 6.0d, 6.0d), (Padding) null, new IconComponent.IconBackground(colorScheme2, MaskShape.Circle.INSTANCE, (Border) null, (Shadow) null, 12, (DefaultConstructorMarker) null), (List) null, 648, (DefaultConstructorMarker) null);
            ButtonComponent.Action.NavigateBack navigateBack = ButtonComponent.Action.NavigateBack.INSTANCE;
            List listListOf = CollectionsKt.listOf(iconComponent);
            HorizontalAlignment horizontalAlignment = HorizontalAlignment.LEADING;
            FlexDistribution flexDistribution = FlexDistribution.START;
            Dimension.Vertical vertical = new Dimension.Vertical(horizontalAlignment, flexDistribution);
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            ButtonComponent buttonComponent = new ButtonComponent(navigateBack, new StackComponent(listListOf, (Boolean) null, vertical, new Size(fit, fit), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, new Padding(16.0d, 16.0d, 16.0d, 16.0d), (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65266, (DefaultConstructorMarker) null), (PaywallTransition) null, (String) null, (String) null, 28, (DefaultConstructorMarker) null);
            URL url = new URL("https://assets.pawwalls.com");
            String strM649constructorimpl = LocalizationKey.m649constructorimpl("title");
            FontWeight fontWeight = FontWeight.BOLD;
            HorizontalAlignment horizontalAlignment2 = HorizontalAlignment.CENTER;
            List listListOf2 = CollectionsKt.listOf((Object[]) new PaywallComponent[]{new TextComponent(strM649constructorimpl, colorScheme, (Boolean) null, (ColorScheme) null, (String) null, fontWeight, (Integer) null, 24, horizontalAlignment2, new Size(fit, fit), (Padding) null, new Padding(0.0d, 0.0d, 50.0d, 50.0d), (List) null, (String) null, 13404, (DefaultConstructorMarker) null), TestData.Components.INSTANCE.getMonthlyPackageComponent()});
            Dimension.Vertical vertical2 = new Dimension.Vertical(horizontalAlignment2, flexDistribution);
            SizeConstraint.Fill fill = SizeConstraint.Fill.INSTANCE;
            Offering offering = new Offering("header_no_zstack_no_image", "Header with no ZStack and no image", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getAnnual()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData("preview_header_no_zstack_no_image", SDKConstants.PARAM_UPDATE_TEMPLATE, url, new ComponentsConfig(new PaywallComponentsConfig(new StackComponent(listListOf2, (Boolean) null, vertical2, new Size(fill, fit), Float.valueOf(8.0f), (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65506, (DefaultConstructorMarker) null), new Background.Color(colorScheme2), new StickyFooterComponent(new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m649constructorimpl("footer"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 0, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, (List) null, (String) null, 16380, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(horizontalAlignment2, flexDistribution), (Size) null, (Float) null, colorScheme2, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65498, (DefaultConstructorMarker) null)), new HeaderComponent(new StackComponent(CollectionsKt.listOf(new StackComponent(CollectionsKt.listOf(buttonComponent), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.TOP_TRAILING), new Size(fill, fit), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65522, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(horizontalAlignment, flexDistribution), new Size(fill, fit), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, new Shadow(new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.b(855638016))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), 16.0d, 0.0d, 4.0d), (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 63474, (DefaultConstructorMarker) null)))), MapsKt.mapOf(TuplesKt.a(LocaleId.m612boximpl(LocaleId.m613constructorimpl("en_US")), MapsKt.mapOf(TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("title")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("Unlock Your Smartest Study Routine"))), TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("footer")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("Try free for 1 week")))))), LocaleId.m613constructorimpl("en_US"), 0, (List) null, (ExitOffers) null, (ProductChangeConfig) null, 960, (DefaultConstructorMarker) null)), null, 80, null);
            composer2 = composerK;
            Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composer2, 0);
            PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
            Intrinsics.checkNotNull(components);
            final PaywallState.Loaded.Components componentsPaywallState$default = OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, "US", new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderNoZStackNoImage$state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, 15, null), null, null, 48, null);
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composer2, 0, 1), ComposableLambdaKt.e(-1238830633, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderNoZStackNoImage.1

                /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderNoZStackNoImage$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderNoZStackNoImage$1$1", f = "LoadedPaywallComponentsPreviews.kt", l = {}, m = "invokeSuspend")
                static final class C02031 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
                    int label;

                    C02031(Continuation<? super C02031> continuation) {
                        super(2, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C02031(continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
                        return ((C02031) create(external, continuation)).invokeSuspend(Unit.f139807a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        IntrinsicsKt.f();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.ResultKt.b(obj);
                        return Unit.f139807a;
                    }
                }

                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i4) {
                    if ((i4 & 3) == 2 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1238830633, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_HeaderNoZStackNoImage.<anonymous> (LoadedPaywallComponentsPreviews.kt:821)");
                    }
                    LoadedPaywallComponentsKt.LoadedPaywallComponents(componentsPaywallState$default, new C02031(null), SizeKt.f(Modifier.b8, 0.0f, 1, null), null, composer3, 432, 8);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composer2, 54), composer2, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderNoZStackNoImage.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i4) {
                    LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderNoZStackNoImage(composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_Preview_HeaderTextOnly(Composer composer, final int i3) {
        Composer composerK = composer.k(762914118);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(762914118, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_HeaderTextOnly (LoadedPaywallComponentsPreviews.kt:475)");
            }
            ColorScheme colorScheme = new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.d(4280756007L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme2 = new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.d(4294835709L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            ColorScheme colorScheme3 = new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.d(4283124041L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            IconComponent iconComponent = new IconComponent("https://icons.pawwalls.com/icons", "x", new IconComponent.Formats("x.webp"), (Boolean) null, new Size(new SizeConstraint.Fixed(32, null), new SizeConstraint.Fixed(32, null)), new ColorScheme(new ColorInfo.Hex(ColorKt.k(Color.f25715b.a())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), new Padding(6.0d, 6.0d, 6.0d, 6.0d), (Padding) null, new IconComponent.IconBackground(colorScheme2, MaskShape.Circle.INSTANCE, (Border) null, (Shadow) null, 12, (DefaultConstructorMarker) null), (List) null, 648, (DefaultConstructorMarker) null);
            ButtonComponent.Action.NavigateBack navigateBack = ButtonComponent.Action.NavigateBack.INSTANCE;
            List listListOf = CollectionsKt.listOf(iconComponent);
            Dimension.Vertical vertical = new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.START);
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            ButtonComponent buttonComponent = new ButtonComponent(navigateBack, new StackComponent(listListOf, (Boolean) null, vertical, new Size(fit, fit), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, new Padding(16.0d, 16.0d, 16.0d, 16.0d), (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65266, (DefaultConstructorMarker) null), (PaywallTransition) null, (String) null, (String) null, 28, (DefaultConstructorMarker) null);
            List listListOf2 = CollectionsKt.listOf((Object[]) new String[]{"feature-1", "feature-2"});
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf2, 10));
            Iterator it = listListOf2.iterator();
            while (it.hasNext()) {
                arrayList.add(new TextComponent(LocalizationKey.m649constructorimpl((String) it.next()), colorScheme3, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 14, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE), new Padding(2.0d, 2.0d, 0.0d, 0.0d), (Padding) null, (List) null, (String) null, 14460, (DefaultConstructorMarker) null));
            }
            URL url = new URL("https://assets.pawwalls.com");
            String strM649constructorimpl = LocalizationKey.m649constructorimpl("title");
            FontWeight fontWeight = FontWeight.BOLD;
            HorizontalAlignment horizontalAlignment = HorizontalAlignment.CENTER;
            SizeConstraint.Fit fit2 = SizeConstraint.Fit.INSTANCE;
            TextComponent textComponent = new TextComponent(strM649constructorimpl, colorScheme, (Boolean) null, (ColorScheme) null, (String) null, fontWeight, (Integer) null, 24, horizontalAlignment, new Size(fit2, fit2), (Padding) null, new Padding(0.0d, 0.0d, 50.0d, 50.0d), (List) null, (String) null, 13404, (DefaultConstructorMarker) null);
            String strM649constructorimpl2 = LocalizationKey.m649constructorimpl("features-header");
            HorizontalAlignment horizontalAlignment2 = HorizontalAlignment.LEADING;
            List listPlus = CollectionsKt.plus((Collection) CollectionsKt.listOf(new TextComponent(strM649constructorimpl2, colorScheme2, (Boolean) null, (ColorScheme) null, (String) null, fontWeight, (Integer) null, 16, horizontalAlignment2, new Size(fit2, fit2), (Padding) null, (Padding) null, (List) null, (String) null, 15452, (DefaultConstructorMarker) null)), (Iterable) arrayList);
            FlexDistribution flexDistribution = FlexDistribution.START;
            Dimension.Vertical vertical2 = new Dimension.Vertical(horizontalAlignment2, flexDistribution);
            SizeConstraint.Fill fill = SizeConstraint.Fill.INSTANCE;
            StackComponent stackComponent = new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{textComponent, new StackComponent(CollectionsKt.listOf(new StackComponent(listPlus, (Boolean) null, vertical2, new Size(fill, fit2), Float.valueOf(4.0f), (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65506, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(horizontalAlignment2, flexDistribution), new Size(fill, fit2), (Float) null, (ColorScheme) null, (Background) null, new Padding(16.0d, 16.0d, 16.0d, 16.0d), (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65394, (DefaultConstructorMarker) null), TestData.Components.INSTANCE.getMonthlyPackageComponent()}), (Boolean) null, new Dimension.Vertical(horizontalAlignment, flexDistribution), new Size(fill, fit2), Float.valueOf(8.0f), (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65506, (DefaultConstructorMarker) null);
            Background.Color color = new Background.Color(colorScheme2);
            HeaderComponent headerComponent = new HeaderComponent(new StackComponent(CollectionsKt.listOf(new StackComponent(CollectionsKt.listOf(buttonComponent), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.TOP_TRAILING), new Size(fill, fit2), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65522, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(horizontalAlignment2, flexDistribution), new Size(fill, fit2), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, new Shadow(new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.b(855638016))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), 16.0d, 0.0d, 4.0d), (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 63474, (DefaultConstructorMarker) null));
            String strM649constructorimpl3 = LocalizationKey.m649constructorimpl(SDKConstants.PARAM_GAME_REQUESTS_CTA);
            ColorScheme colorScheme4 = new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.d(4278979596L))), (ColorInfo) null, 2, (DefaultConstructorMarker) null);
            FontWeight fontWeight2 = FontWeight.SEMI_BOLD;
            Offering offering = new Offering("header_text_only", "Header with text only (no hero image)", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getAnnual()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData("preview_header_text_only", SDKConstants.PARAM_UPDATE_TEMPLATE, url, new ComponentsConfig(new PaywallComponentsConfig(stackComponent, color, new StickyFooterComponent(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new PurchaseButtonComponent(new StackComponent(CollectionsKt.listOf(new TextComponent(strM649constructorimpl3, colorScheme4, (Boolean) null, (ColorScheme) null, (String) null, fontWeight2, (Integer) null, 16, horizontalAlignment, new Size(fit2, fit2), (Padding) null, (Padding) null, (List) null, (String) null, 15452, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(horizontalAlignment, flexDistribution), new Size(fill, fit2), (Float) null, new ColorScheme(new ColorInfo.Gradient.Linear(15.0f, CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.k(ColorKt.d(4286377127L)), 0.0f), new ColorInfo.Gradient.Point(ColorKt.k(ColorKt.d(4286509283L)), 100.0f)})), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Background) null, new Padding(12.0d, 12.0d, 8.0d, 8.0d), (Padding) null, new Shape.Rectangle(new CornerRadiuses.Dp(12.0d)), (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 64850, (DefaultConstructorMarker) null), (PurchaseButtonComponent.Action) null, (PurchaseButtonComponent.Method) null, (String) null, 14, (DefaultConstructorMarker) null), new StackComponent(CollectionsKt.listOf(new ButtonComponent(ButtonComponent.Action.RestorePurchases.INSTANCE, new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m649constructorimpl("restore"), colorScheme3, (Boolean) null, (ColorScheme) null, (String) null, fontWeight2, (Integer) null, 13, horizontalAlignment2, new Size(fit2, fit2), (Padding) null, (Padding) null, (List) null, (String) null, 15452, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(horizontalAlignment2, FlexDistribution.SPACE_BETWEEN), new Size(fit2, fit2), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65522, (DefaultConstructorMarker) null), (PaywallTransition) null, (String) null, (String) null, 28, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Horizontal(VerticalAlignment.TOP, FlexDistribution.CENTER), new Size(fill, fit2), (Float) null, (ColorScheme) null, (Background) null, (Padding) null, new Padding(12.0d, 0.0d, 0.0d, 0.0d), (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65266, (DefaultConstructorMarker) null)}), (Boolean) null, new Dimension.Vertical(horizontalAlignment2, flexDistribution), new Size(fill, fit2), (Float) null, colorScheme2, (Background) null, new Padding(12.0d, 0.0d, 16.0d, 16.0d), (Padding) null, (Shape) null, (Border) null, new Shadow(new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.b(251658240))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), 16.0d, 0.0d, -4.0d), (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 63314, (DefaultConstructorMarker) null)), headerComponent)), MapsKt.mapOf(TuplesKt.a(LocaleId.m612boximpl(LocaleId.m613constructorimpl("en_US")), MapsKt.mapOf(TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("title")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("Unlock Your Smartest Study Routine"))), TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("features-header")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("Features"))), TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("feature-1")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("Assignment Tracker"))), TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("feature-2")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("AI-generated Study Plans"))), TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl(SDKConstants.PARAM_GAME_REQUESTS_CTA)), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("Continue"))), TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("restore")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("Restore Purchases")))))), LocaleId.m613constructorimpl("en_US"), 0, (List) null, (ExitOffers) null, (ProductChangeConfig) null, 960, (DefaultConstructorMarker) null)), null, 80, null);
            Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composerK, 0);
            PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
            Intrinsics.checkNotNull(components);
            final PaywallState.Loaded.Components componentsPaywallState$default = OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, "US", new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderTextOnly$state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, 15, null), null, null, 48, null);
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerK, 0, 1), ComposableLambdaKt.e(-2020160245, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderTextOnly.1

                /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderTextOnly$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt$LoadedPaywallComponents_Preview_HeaderTextOnly$1$1", f = "LoadedPaywallComponentsPreviews.kt", l = {}, m = "invokeSuspend")
                static final class C02041 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
                    int label;

                    C02041(Continuation<? super C02041> continuation) {
                        super(2, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C02041(continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
                        return ((C02041) create(external, continuation)).invokeSuspend(Unit.f139807a);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        IntrinsicsKt.f();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.ResultKt.b(obj);
                        return Unit.f139807a;
                    }
                }

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
                        ComposerKt.U(-2020160245, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_HeaderTextOnly.<anonymous> (LoadedPaywallComponentsPreviews.kt:702)");
                    }
                    LoadedPaywallComponentsKt.LoadedPaywallComponents(componentsPaywallState$default, new C02041(null), SizeKt.f(Modifier.b8, 0.0f, 1, null), null, composer2, 432, 8);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderTextOnly.2
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
                    LoadedPaywallComponentsPreviewsKt.LoadedPaywallComponents_Preview_HeaderTextOnly(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
