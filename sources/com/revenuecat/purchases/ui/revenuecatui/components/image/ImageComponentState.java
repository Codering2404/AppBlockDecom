package com.revenuecat.purchases.ui.revenuecatui.components.image;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.window.core.layout.WindowWidthSizeClass;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.PartialImageComponent;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.ImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.components.ComponentViewState;
import com.revenuecat.purchases.ui.revenuecatui.components.ConditionContext;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedImagePartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartialKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ScreenCondition;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.FitModeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.LocalizationKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.PaddingKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.ShapeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.SizeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.modifier.AspectRatio;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.state.PackageAwareDelegate;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ImageComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UnsignedKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
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
public final class ImageComponentState {
    public static final int $stable = 0;
    private final State aspectRatio$delegate;
    private final State border$delegate;
    private final State contentScale$delegate;
    private final Function0<Map<String, CustomVariableValue>> customVariablesProvider;
    private final MutableState darkMode$delegate;
    private final MutableState density$delegate;
    private final State imageAspectRatio$delegate;
    private final State imageUrls$delegate;
    private final MutableState layoutDirection$delegate;
    private final Function0<Locale> localeProvider;
    private final State margin$delegate;
    private final State marginAdjustedAspectRatio$delegate;
    private final State overlay$delegate;
    private final PackageAwareDelegate packageAwareDelegate;
    private final State padding$delegate;
    private final State presentedPartial$delegate;
    private final Function0<OfferEligibility> selectedOfferEligibilityProvider;
    private final Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider;
    private final Function0<Integer> selectedTabIndexProvider;
    private final State shadow$delegate;
    private final State shape$delegate;
    private final State size$delegate;
    private final State sizePlusMargin$delegate;
    private final ImageComponentStyle style;
    private final State themeImageUrls$delegate;
    private final State visible$delegate;
    private final MutableState windowSize$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public ImageComponentState(WindowWidthSizeClass initialWindowSize, Density initialDensity, boolean z2, LayoutDirection initialLayoutDirection, ImageComponentStyle style, Function0<Locale> localeProvider, Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider, Function0<Integer> selectedTabIndexProvider, Function0<? extends OfferEligibility> selectedOfferEligibilityProvider, Function0<? extends Map<String, ? extends CustomVariableValue>> customVariablesProvider) {
        Intrinsics.checkNotNullParameter(initialWindowSize, "initialWindowSize");
        Intrinsics.checkNotNullParameter(initialDensity, "initialDensity");
        Intrinsics.checkNotNullParameter(initialLayoutDirection, "initialLayoutDirection");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(localeProvider, "localeProvider");
        Intrinsics.checkNotNullParameter(selectedPackageInfoProvider, "selectedPackageInfoProvider");
        Intrinsics.checkNotNullParameter(selectedTabIndexProvider, "selectedTabIndexProvider");
        Intrinsics.checkNotNullParameter(selectedOfferEligibilityProvider, "selectedOfferEligibilityProvider");
        Intrinsics.checkNotNullParameter(customVariablesProvider, "customVariablesProvider");
        this.style = style;
        this.localeProvider = localeProvider;
        this.selectedPackageInfoProvider = selectedPackageInfoProvider;
        this.selectedTabIndexProvider = selectedTabIndexProvider;
        this.selectedOfferEligibilityProvider = selectedOfferEligibilityProvider;
        this.customVariablesProvider = customVariablesProvider;
        this.windowSize$delegate = SnapshotStateKt__SnapshotStateKt.e(initialWindowSize, null, 2, null);
        this.density$delegate = SnapshotStateKt__SnapshotStateKt.e(initialDensity, null, 2, null);
        this.darkMode$delegate = SnapshotStateKt__SnapshotStateKt.e(Boolean.valueOf(z2), null, 2, null);
        this.layoutDirection$delegate = SnapshotStateKt__SnapshotStateKt.e(initialLayoutDirection, null, 2, null);
        this.packageAwareDelegate = new PackageAwareDelegate(style, selectedPackageInfoProvider, selectedTabIndexProvider, selectedOfferEligibilityProvider);
        this.presentedPartial$delegate = SnapshotStateKt.e(new Function0<PresentedImagePartial>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$presentedPartial$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PresentedImagePartial invoke() {
                Package rcPackage;
                ScreenCondition screenConditionFrom = ScreenCondition.Companion.from(this.this$0.getWindowSize());
                ComponentViewState componentViewState = this.this$0.packageAwareDelegate.isSelected() ? ComponentViewState.SELECTED : ComponentViewState.DEFAULT;
                List overrides = this.this$0.style.getOverrides();
                OfferEligibility offerEligibility = this.this$0.packageAwareDelegate.getOfferEligibility();
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = (PaywallState.Loaded.Components.SelectedPackageInfo) this.this$0.selectedPackageInfoProvider.invoke();
                return (PresentedImagePartial) PresentedPartialKt.buildPresentedPartial(overrides, screenConditionFrom, offerEligibility, componentViewState, new ConditionContext((selectedPackageInfo == null || (rcPackage = selectedPackageInfo.getRcPackage()) == null) ? null : rcPackage.getIdentifier(), (Map) this.this$0.customVariablesProvider.invoke()));
            }
        });
        this.themeImageUrls$delegate = SnapshotStateKt.e(new Function0<ThemeImageUrls>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$themeImageUrls$2
            {
                super(0);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public final ThemeImageUrls invoke() {
                NonEmptyMap sources;
                ThemeImageUrls themeImageUrls;
                String localeId = LocalizationKt.toLocaleId((Locale) this.this$0.localeProvider.invoke());
                PresentedImagePartial presentedPartial = this.this$0.getPresentedPartial();
                if (presentedPartial != null && (sources = presentedPartial.getSources()) != null && (themeImageUrls = (ThemeImageUrls) sources.getOrDefault(LocaleId.m612boximpl(localeId), sources.getEntry().getValue())) != null) {
                    return themeImageUrls;
                }
                NonEmptyMap sources2 = this.this$0.style.getSources();
                return (ThemeImageUrls) sources2.getOrDefault(LocaleId.m612boximpl(localeId), sources2.getEntry().getValue());
            }
        });
        this.visible$delegate = SnapshotStateKt.e(new Function0<Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$visible$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                PartialImageComponent partial;
                Boolean visible;
                PresentedImagePartial presentedPartial = this.this$0.getPresentedPartial();
                return Boolean.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (visible = partial.getVisible()) == null) ? this.this$0.style.getVisible() : visible.booleanValue());
            }
        });
        this.imageUrls$delegate = SnapshotStateKt.e(new Function0<ImageUrls>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$imageUrls$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ImageUrls invoke() {
                ImageUrls dark;
                return (!this.this$0.getDarkMode() || (dark = this.this$0.getThemeImageUrls().getDark()) == null) ? this.this$0.getThemeImageUrls().getLight() : dark;
            }
        });
        this.imageAspectRatio$delegate = SnapshotStateKt.e(new Function0<Float>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$imageAspectRatio$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(((float) UnsignedKt.c(this.this$0.getImageUrls().m661getWidthpVg5ArA())) / ((float) UnsignedKt.c(this.this$0.getImageUrls().m660getHeightpVg5ArA())));
            }
        });
        this.size$delegate = SnapshotStateKt.e(new Function0<Size>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$size$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Size invoke() {
                Size size;
                PartialImageComponent partial;
                ImageComponentState imageComponentState = this.this$0;
                PresentedImagePartial presentedPartial = imageComponentState.getPresentedPartial();
                if (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (size = partial.getSize()) == null) {
                    size = this.this$0.style.getSize();
                }
                return imageComponentState.adjustForImage(size, this.this$0.getImageUrls(), this.this$0.getDensity());
            }
        });
        this.aspectRatio$delegate = SnapshotStateKt.e(new Function0<AspectRatio>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$aspectRatio$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final AspectRatio invoke() {
                Size size = this.this$0.getSize();
                ImageComponentState imageComponentState = this.this$0;
                SizeConstraint height = size.getHeight();
                if (height instanceof SizeConstraint.Fit) {
                    SizeConstraint width = size.getWidth();
                    if (!(width instanceof SizeConstraint.Fit) && !(width instanceof SizeConstraint.Fill)) {
                        if (width instanceof SizeConstraint.Fixed) {
                            return null;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    return new AspectRatio(imageComponentState.getImageAspectRatio(), true);
                }
                if (height instanceof SizeConstraint.Fill) {
                    SizeConstraint width2 = size.getWidth();
                    if (width2 instanceof SizeConstraint.Fit) {
                        return new AspectRatio(imageComponentState.getImageAspectRatio(), false);
                    }
                    if ((width2 instanceof SizeConstraint.Fill) || (width2 instanceof SizeConstraint.Fixed)) {
                        return null;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                if (!(height instanceof SizeConstraint.Fixed)) {
                    throw new NoWhenBranchMatchedException();
                }
                SizeConstraint width3 = size.getWidth();
                if ((width3 instanceof SizeConstraint.Fit) || (width3 instanceof SizeConstraint.Fill)) {
                    return null;
                }
                if (width3 instanceof SizeConstraint.Fixed) {
                    return new AspectRatio(((float) UnsignedKt.c(((SizeConstraint.Fixed) width3).m662getValuepVg5ArA())) / ((float) UnsignedKt.c(((SizeConstraint.Fixed) height).m662getValuepVg5ArA())), true);
                }
                throw new NoWhenBranchMatchedException();
            }
        });
        this.padding$delegate = SnapshotStateKt.e(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$padding$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialImageComponent partial;
                Padding padding;
                PaddingValues paddingValues;
                PresentedImagePartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (padding = partial.getPadding()) == null || (paddingValues = PaddingKt.toPaddingValues(padding)) == null) ? this.this$0.style.getPadding() : paddingValues;
            }
        });
        this.margin$delegate = SnapshotStateKt.e(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$margin$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialImageComponent partial;
                Padding margin;
                PaddingValues paddingValues;
                PresentedImagePartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (margin = partial.getMargin()) == null || (paddingValues = PaddingKt.toPaddingValues(margin)) == null) ? this.this$0.style.getMargin() : paddingValues;
            }
        });
        this.sizePlusMargin$delegate = SnapshotStateKt.e(new Function0<Size>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$sizePlusMargin$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Size invoke() {
                return SizeKt.addMargin(this.this$0.getSize(), this.this$0.getMargin(), this.this$0.getLayoutDirection());
            }
        });
        this.marginAdjustedAspectRatio$delegate = SnapshotStateKt.e(new Function0<AspectRatio>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$marginAdjustedAspectRatio$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final AspectRatio invoke() {
                Size sizePlusMargin = this.this$0.getSizePlusMargin();
                SizeConstraint height = sizePlusMargin.getHeight();
                if (!(height instanceof SizeConstraint.Fixed)) {
                    if (height instanceof SizeConstraint.Fit ? true : height instanceof SizeConstraint.Fill) {
                        return null;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                SizeConstraint width = sizePlusMargin.getWidth();
                if (width instanceof SizeConstraint.Fit ? true : width instanceof SizeConstraint.Fill) {
                    return null;
                }
                if (width instanceof SizeConstraint.Fixed) {
                    return new AspectRatio(((float) UnsignedKt.c(((SizeConstraint.Fixed) width).m662getValuepVg5ArA())) / ((float) UnsignedKt.c(((SizeConstraint.Fixed) height).m662getValuepVg5ArA())), true);
                }
                throw new NoWhenBranchMatchedException();
            }
        });
        this.shape$delegate = SnapshotStateKt.e(new Function0<Shape>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$shape$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Shape invoke() {
                PartialImageComponent partial;
                MaskShape maskShape;
                Shape shape;
                PresentedImagePartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (maskShape = partial.getMaskShape()) == null || (shape = ShapeKt.toShape(maskShape)) == null) ? this.this$0.style.getShape() : shape;
            }
        });
        this.border$delegate = SnapshotStateKt.e(new Function0<BorderStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$border$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final BorderStyles invoke() {
                BorderStyles border;
                PresentedImagePartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (border = presentedPartial.getBorder()) == null) ? this.this$0.style.getBorder() : border;
            }
        });
        this.shadow$delegate = SnapshotStateKt.e(new Function0<ShadowStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$shadow$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ShadowStyles invoke() {
                ShadowStyles shadow;
                PresentedImagePartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (shadow = presentedPartial.getShadow()) == null) ? this.this$0.style.getShadow() : shadow;
            }
        });
        this.overlay$delegate = SnapshotStateKt.e(new Function0<ColorStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$overlay$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ColorStyles invoke() {
                ColorStyles overlay;
                PresentedImagePartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (overlay = presentedPartial.getOverlay()) == null) ? this.this$0.style.getOverlay() : overlay;
            }
        });
        this.contentScale$delegate = SnapshotStateKt.e(new Function0<ContentScale>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$contentScale$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ContentScale invoke() {
                PartialImageComponent partial;
                FitMode fitMode;
                ContentScale contentScale;
                PresentedImagePartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (fitMode = partial.getFitMode()) == null || (contentScale = FitModeKt.toContentScale(fitMode)) == null) ? this.this$0.style.getContentScale() : contentScale;
            }
        });
    }

    /* JADX INFO: renamed from: adjustDimension-yOCu0fQ, reason: not valid java name */
    private final SizeConstraint m719adjustDimensionyOCu0fQ(SizeConstraint sizeConstraint, SizeConstraint sizeConstraint2, int i3, int i4, Density density) {
        if (!(sizeConstraint instanceof SizeConstraint.Fit)) {
            if (sizeConstraint instanceof SizeConstraint.Fill ? true : sizeConstraint instanceof SizeConstraint.Fixed) {
                return sizeConstraint;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (sizeConstraint2 instanceof SizeConstraint.Fit) {
            return new SizeConstraint.Fixed(UnsignedKt.a(density.F(i3)), null);
        }
        if (sizeConstraint2 instanceof SizeConstraint.Fill) {
            return sizeConstraint;
        }
        if (sizeConstraint2 instanceof SizeConstraint.Fixed) {
            return new SizeConstraint.Fixed(UnsignedKt.a(density.G((((float) UnsignedKt.c(((SizeConstraint.Fixed) sizeConstraint2).m662getValuepVg5ArA())) / density.F(i4)) * i3)), null);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Size adjustForImage(Size size, ImageUrls imageUrls, Density density) {
        return new Size(m719adjustDimensionyOCu0fQ(size.getWidth(), size.getHeight(), imageUrls.m661getWidthpVg5ArA(), imageUrls.m660getHeightpVg5ArA(), density), m719adjustDimensionyOCu0fQ(size.getHeight(), size.getWidth(), imageUrls.m660getHeightpVg5ArA(), imageUrls.m661getWidthpVg5ArA(), density));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getDarkMode() {
        return ((Boolean) this.darkMode$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Density getDensity() {
        return (Density) this.density$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getImageAspectRatio() {
        return ((Number) this.imageAspectRatio$delegate.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.layoutDirection$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PresentedImagePartial getPresentedPartial() {
        return (PresentedImagePartial) this.presentedPartial$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ThemeImageUrls getThemeImageUrls() {
        return (ThemeImageUrls) this.themeImageUrls$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WindowWidthSizeClass getWindowSize() {
        return (WindowWidthSizeClass) this.windowSize$delegate.getValue();
    }

    private final void setDarkMode(boolean z2) {
        this.darkMode$delegate.setValue(Boolean.valueOf(z2));
    }

    private final void setDensity(Density density) {
        this.density$delegate.setValue(density);
    }

    private final void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection$delegate.setValue(layoutDirection);
    }

    private final void setWindowSize(WindowWidthSizeClass windowWidthSizeClass) {
        this.windowSize$delegate.setValue(windowWidthSizeClass);
    }

    public static /* synthetic */ void update$default(ImageComponentState imageComponentState, WindowWidthSizeClass windowWidthSizeClass, Density density, Boolean bool, LayoutDirection layoutDirection, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            windowWidthSizeClass = null;
        }
        if ((i3 & 2) != 0) {
            density = null;
        }
        if ((i3 & 4) != 0) {
            bool = null;
        }
        if ((i3 & 8) != 0) {
            layoutDirection = null;
        }
        imageComponentState.update(windowWidthSizeClass, density, bool, layoutDirection);
    }

    public final /* synthetic */ AspectRatio getAspectRatio() {
        return (AspectRatio) this.aspectRatio$delegate.getValue();
    }

    public final /* synthetic */ BorderStyles getBorder() {
        return (BorderStyles) this.border$delegate.getValue();
    }

    public final /* synthetic */ ContentScale getContentScale() {
        return (ContentScale) this.contentScale$delegate.getValue();
    }

    public final /* synthetic */ ImageUrls getImageUrls() {
        return (ImageUrls) this.imageUrls$delegate.getValue();
    }

    public final /* synthetic */ PaddingValues getMargin() {
        return (PaddingValues) this.margin$delegate.getValue();
    }

    public final /* synthetic */ AspectRatio getMarginAdjustedAspectRatio() {
        return (AspectRatio) this.marginAdjustedAspectRatio$delegate.getValue();
    }

    public final /* synthetic */ ColorStyles getOverlay() {
        return (ColorStyles) this.overlay$delegate.getValue();
    }

    public final /* synthetic */ PaddingValues getPadding() {
        return (PaddingValues) this.padding$delegate.getValue();
    }

    public final /* synthetic */ ShadowStyles getShadow() {
        return (ShadowStyles) this.shadow$delegate.getValue();
    }

    public final /* synthetic */ Shape getShape() {
        return (Shape) this.shape$delegate.getValue();
    }

    public final /* synthetic */ Size getSize() {
        return (Size) this.size$delegate.getValue();
    }

    public final /* synthetic */ Size getSizePlusMargin() {
        return (Size) this.sizePlusMargin$delegate.getValue();
    }

    public final /* synthetic */ boolean getVisible() {
        return ((Boolean) this.visible$delegate.getValue()).booleanValue();
    }

    public final /* synthetic */ void update(WindowWidthSizeClass windowWidthSizeClass, Density density, Boolean bool, LayoutDirection layoutDirection) {
        if (windowWidthSizeClass != null) {
            setWindowSize(windowWidthSizeClass);
        }
        if (density != null) {
            setDensity(density);
        }
        if (bool != null) {
            setDarkMode(bool.booleanValue());
        }
        if (layoutDirection != null) {
            setLayoutDirection(layoutDirection);
        }
    }

    public /* synthetic */ ImageComponentState(WindowWidthSizeClass windowWidthSizeClass, Density density, boolean z2, LayoutDirection layoutDirection, ImageComponentStyle imageComponentStyle, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowWidthSizeClass, density, z2, layoutDirection, imageComponentStyle, function0, function02, function03, function04, (i3 & 512) != 0 ? new Function0<Map<String, ? extends CustomVariableValue>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState.1
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, CustomVariableValue> invoke() {
                return MapsKt.emptyMap();
            }
        } : function05);
    }
}
