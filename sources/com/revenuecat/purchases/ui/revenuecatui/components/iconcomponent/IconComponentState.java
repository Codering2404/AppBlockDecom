package com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.window.core.layout.WindowWidthSizeClass;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.PartialIconComponent;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.components.ComponentViewState;
import com.revenuecat.purchases.ui.revenuecatui.components.ConditionContext;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedIconPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartialKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ScreenCondition;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.PaddingKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.ShapeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.SizeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.state.PackageAwareDelegate;
import com.revenuecat.purchases.ui.revenuecatui.components.style.IconComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
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
public final class IconComponentState {
    public static final int $stable = 0;
    private final State backgroundColorStyles$delegate;
    private final State baseUrl$delegate;
    private final State border$delegate;
    private final Function0<Map<String, CustomVariableValue>> customVariablesProvider;
    private final State formats$delegate;
    private final State iconBackground$delegate;
    private final State iconName$delegate;
    private final MutableState layoutDirection$delegate;
    private final State margin$delegate;
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
    private final IconComponentStyle style;
    private final State tintColor$delegate;
    private final State url$delegate;
    private final State visible$delegate;
    private final MutableState windowSize$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public IconComponentState(WindowWidthSizeClass initialWindowSize, LayoutDirection initialLayoutDirection, IconComponentStyle style, Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider, Function0<Integer> selectedTabIndexProvider, Function0<? extends OfferEligibility> selectedOfferEligibilityProvider, Function0<? extends Map<String, ? extends CustomVariableValue>> customVariablesProvider) {
        Intrinsics.checkNotNullParameter(initialWindowSize, "initialWindowSize");
        Intrinsics.checkNotNullParameter(initialLayoutDirection, "initialLayoutDirection");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(selectedPackageInfoProvider, "selectedPackageInfoProvider");
        Intrinsics.checkNotNullParameter(selectedTabIndexProvider, "selectedTabIndexProvider");
        Intrinsics.checkNotNullParameter(selectedOfferEligibilityProvider, "selectedOfferEligibilityProvider");
        Intrinsics.checkNotNullParameter(customVariablesProvider, "customVariablesProvider");
        this.style = style;
        this.selectedPackageInfoProvider = selectedPackageInfoProvider;
        this.selectedTabIndexProvider = selectedTabIndexProvider;
        this.selectedOfferEligibilityProvider = selectedOfferEligibilityProvider;
        this.customVariablesProvider = customVariablesProvider;
        this.windowSize$delegate = SnapshotStateKt__SnapshotStateKt.e(initialWindowSize, null, 2, null);
        this.layoutDirection$delegate = SnapshotStateKt__SnapshotStateKt.e(initialLayoutDirection, null, 2, null);
        this.packageAwareDelegate = new PackageAwareDelegate(style, selectedPackageInfoProvider, selectedTabIndexProvider, selectedOfferEligibilityProvider);
        this.presentedPartial$delegate = SnapshotStateKt.e(new Function0<PresentedIconPartial>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$presentedPartial$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PresentedIconPartial invoke() {
                Package rcPackage;
                ScreenCondition screenConditionFrom = ScreenCondition.Companion.from(this.this$0.getWindowSize());
                ComponentViewState componentViewState = this.this$0.packageAwareDelegate.isSelected() ? ComponentViewState.SELECTED : ComponentViewState.DEFAULT;
                List overrides = this.this$0.style.getOverrides();
                OfferEligibility offerEligibility = this.this$0.packageAwareDelegate.getOfferEligibility();
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = (PaywallState.Loaded.Components.SelectedPackageInfo) this.this$0.selectedPackageInfoProvider.invoke();
                return (PresentedIconPartial) PresentedPartialKt.buildPresentedPartial(overrides, screenConditionFrom, offerEligibility, componentViewState, new ConditionContext((selectedPackageInfo == null || (rcPackage = selectedPackageInfo.getRcPackage()) == null) ? null : rcPackage.getIdentifier(), (Map) this.this$0.customVariablesProvider.invoke()));
            }
        });
        this.baseUrl$delegate = SnapshotStateKt.e(new Function0<String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$baseUrl$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                PartialIconComponent partial;
                String baseUrl;
                PresentedIconPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (baseUrl = partial.getBaseUrl()) == null) ? this.this$0.style.getBaseUrl() : baseUrl;
            }
        });
        this.iconName$delegate = SnapshotStateKt.e(new Function0<String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$iconName$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                PartialIconComponent partial;
                String iconName;
                PresentedIconPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (iconName = partial.getIconName()) == null) ? this.this$0.style.getIconName() : iconName;
            }
        });
        this.formats$delegate = SnapshotStateKt.e(new Function0<IconComponent.Formats>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$formats$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final IconComponent.Formats invoke() {
                PartialIconComponent partial;
                IconComponent.Formats formats;
                PresentedIconPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (formats = partial.getFormats()) == null) ? this.this$0.style.getFormats() : formats;
            }
        });
        this.iconBackground$delegate = SnapshotStateKt.e(new Function0<IconComponentStyle.Background>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$iconBackground$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final IconComponentStyle.Background invoke() {
                IconComponentStyle.Background background;
                PresentedIconPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (background = presentedPartial.getBackground()) == null) ? this.this$0.style.getIconBackground() : background;
            }
        });
        this.visible$delegate = SnapshotStateKt.e(new Function0<Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$visible$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                PartialIconComponent partial;
                Boolean visible;
                PresentedIconPartial presentedPartial = this.this$0.getPresentedPartial();
                return Boolean.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (visible = partial.getVisible()) == null) ? this.this$0.style.getVisible() : visible.booleanValue());
            }
        });
        this.url$delegate = SnapshotStateKt.e(new Function0<String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$url$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return this.this$0.getBaseUrl() + '/' + this.this$0.getFormats().getWebp();
            }
        });
        this.size$delegate = SnapshotStateKt.e(new Function0<Size>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$size$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Size invoke() {
                PartialIconComponent partial;
                Size size;
                PresentedIconPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (size = partial.getSize()) == null) ? this.this$0.style.getSize() : size;
            }
        });
        this.padding$delegate = SnapshotStateKt.e(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$padding$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialIconComponent partial;
                Padding padding;
                PaddingValues paddingValues;
                PresentedIconPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (padding = partial.getPadding()) == null || (paddingValues = PaddingKt.toPaddingValues(padding)) == null) ? this.this$0.style.getPadding() : paddingValues;
            }
        });
        this.margin$delegate = SnapshotStateKt.e(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$margin$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialIconComponent partial;
                Padding margin;
                PaddingValues paddingValues;
                PresentedIconPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (margin = partial.getMargin()) == null || (paddingValues = PaddingKt.toPaddingValues(margin)) == null) ? this.this$0.style.getMargin() : paddingValues;
            }
        });
        this.sizePlusMargin$delegate = SnapshotStateKt.e(new Function0<Size>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$sizePlusMargin$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Size invoke() {
                return SizeKt.addMargin(this.this$0.getSize(), this.this$0.getMargin(), this.this$0.getLayoutDirection());
            }
        });
        this.shape$delegate = SnapshotStateKt.e(new Function0<Shape>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$shape$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Shape invoke() {
                MaskShape shape;
                IconComponentStyle.Background iconBackground = this.this$0.getIconBackground();
                if (iconBackground == null || (shape = iconBackground.getShape()) == null) {
                    return null;
                }
                return ShapeKt.toShape(shape);
            }
        });
        this.border$delegate = SnapshotStateKt.e(new Function0<BorderStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$border$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final BorderStyles invoke() {
                IconComponentStyle.Background iconBackground = this.this$0.getIconBackground();
                if (iconBackground != null) {
                    return iconBackground.getBorder();
                }
                return null;
            }
        });
        this.shadow$delegate = SnapshotStateKt.e(new Function0<ShadowStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$shadow$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ShadowStyles invoke() {
                IconComponentStyle.Background iconBackground = this.this$0.getIconBackground();
                if (iconBackground != null) {
                    return iconBackground.getShadow();
                }
                return null;
            }
        });
        this.backgroundColorStyles$delegate = SnapshotStateKt.e(new Function0<ColorStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$backgroundColorStyles$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ColorStyles invoke() {
                IconComponentStyle.Background iconBackground = this.this$0.getIconBackground();
                if (iconBackground != null) {
                    return iconBackground.getColor();
                }
                return null;
            }
        });
        this.tintColor$delegate = SnapshotStateKt.e(new Function0<ColorStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState$tintColor$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ColorStyles invoke() {
                ColorStyles colorStyles;
                PresentedIconPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (colorStyles = presentedPartial.getColorStyles()) == null) ? this.this$0.style.getColor() : colorStyles;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getBaseUrl() {
        return (String) this.baseUrl$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IconComponent.Formats getFormats() {
        return (IconComponent.Formats) this.formats$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IconComponentStyle.Background getIconBackground() {
        return (IconComponentStyle.Background) this.iconBackground$delegate.getValue();
    }

    private final String getIconName() {
        return (String) this.iconName$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.layoutDirection$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PresentedIconPartial getPresentedPartial() {
        return (PresentedIconPartial) this.presentedPartial$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WindowWidthSizeClass getWindowSize() {
        return (WindowWidthSizeClass) this.windowSize$delegate.getValue();
    }

    private final void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection$delegate.setValue(layoutDirection);
    }

    private final void setWindowSize(WindowWidthSizeClass windowWidthSizeClass) {
        this.windowSize$delegate.setValue(windowWidthSizeClass);
    }

    public static /* synthetic */ void update$default(IconComponentState iconComponentState, WindowWidthSizeClass windowWidthSizeClass, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            windowWidthSizeClass = null;
        }
        iconComponentState.update(windowWidthSizeClass);
    }

    public final /* synthetic */ ColorStyles getBackgroundColorStyles() {
        return (ColorStyles) this.backgroundColorStyles$delegate.getValue();
    }

    public final /* synthetic */ BorderStyles getBorder() {
        return (BorderStyles) this.border$delegate.getValue();
    }

    public final /* synthetic */ PaddingValues getMargin() {
        return (PaddingValues) this.margin$delegate.getValue();
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

    public final ColorStyles getTintColor() {
        return (ColorStyles) this.tintColor$delegate.getValue();
    }

    public final /* synthetic */ String getUrl() {
        return (String) this.url$delegate.getValue();
    }

    public final /* synthetic */ boolean getVisible() {
        return ((Boolean) this.visible$delegate.getValue()).booleanValue();
    }

    public final /* synthetic */ void update(WindowWidthSizeClass windowWidthSizeClass) {
        if (windowWidthSizeClass != null) {
            setWindowSize(windowWidthSizeClass);
        }
    }

    public /* synthetic */ IconComponentState(WindowWidthSizeClass windowWidthSizeClass, LayoutDirection layoutDirection, IconComponentStyle iconComponentStyle, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowWidthSizeClass, layoutDirection, iconComponentStyle, function0, function02, function03, (i3 & 64) != 0 ? new Function0<Map<String, ? extends CustomVariableValue>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.iconcomponent.IconComponentState.1
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, CustomVariableValue> invoke() {
                return MapsKt.emptyMap();
            }
        } : function04);
    }
}
