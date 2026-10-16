package com.revenuecat.purchases.ui.revenuecatui.components.carousel;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.window.core.layout.WindowWidthSizeClass;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.PartialCarouselComponent;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignment;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.components.ComponentViewState;
import com.revenuecat.purchases.ui.revenuecatui.components.ConditionContext;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedCarouselPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartialKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ScreenCondition;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.AlignmentKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.PaddingKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.ShapeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.state.PackageAwareDelegate;
import com.revenuecat.purchases.ui.revenuecatui.components.style.CarouselComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle;
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
public final class CarouselComponentState {
    public static final int $stable = 0;
    private final State autoAdvance$delegate;
    private final State background$delegate;
    private final State border$delegate;
    private final Function0<Map<String, CustomVariableValue>> customVariablesProvider;
    private final State initialPageIndex$delegate;
    private final State loop$delegate;
    private final State margin$delegate;
    private final PackageAwareDelegate packageAwareDelegate;
    private final State padding$delegate;
    private final State pageAlignment$delegate;
    private final State pageControl$delegate;
    private final State pagePeek$delegate;
    private final State pageSpacing$delegate;
    private final State pages$delegate;
    private final State presentedPartial$delegate;
    private final Function0<OfferEligibility> selectedOfferEligibilityProvider;
    private final Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider;
    private final Function0<Integer> selectedTabIndexProvider;
    private final State shadow$delegate;
    private final State shape$delegate;
    private final State size$delegate;
    private final CarouselComponentStyle style;
    private final State visible$delegate;
    private final MutableState windowSize$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public CarouselComponentState(WindowWidthSizeClass initialWindowSize, CarouselComponentStyle style, Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider, Function0<Integer> selectedTabIndexProvider, Function0<? extends OfferEligibility> selectedOfferEligibilityProvider, Function0<? extends Map<String, ? extends CustomVariableValue>> customVariablesProvider) {
        Intrinsics.checkNotNullParameter(initialWindowSize, "initialWindowSize");
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
        this.packageAwareDelegate = new PackageAwareDelegate(style, selectedPackageInfoProvider, selectedTabIndexProvider, selectedOfferEligibilityProvider);
        this.presentedPartial$delegate = SnapshotStateKt.e(new Function0<PresentedCarouselPartial>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$presentedPartial$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PresentedCarouselPartial invoke() {
                Package rcPackage;
                ScreenCondition screenConditionFrom = ScreenCondition.Companion.from(this.this$0.getWindowSize());
                ComponentViewState componentViewState = this.this$0.packageAwareDelegate.isSelected() ? ComponentViewState.SELECTED : ComponentViewState.DEFAULT;
                List overrides = this.this$0.style.getOverrides();
                OfferEligibility offerEligibility = this.this$0.packageAwareDelegate.getOfferEligibility();
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = (PaywallState.Loaded.Components.SelectedPackageInfo) this.this$0.selectedPackageInfoProvider.invoke();
                return (PresentedCarouselPartial) PresentedPartialKt.buildPresentedPartial(overrides, screenConditionFrom, offerEligibility, componentViewState, new ConditionContext((selectedPackageInfo == null || (rcPackage = selectedPackageInfo.getRcPackage()) == null) ? null : rcPackage.getIdentifier(), (Map) this.this$0.customVariablesProvider.invoke()));
            }
        });
        this.visible$delegate = SnapshotStateKt.e(new Function0<Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$visible$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                PartialCarouselComponent partial;
                Boolean visible;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return Boolean.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (visible = partial.getVisible()) == null) ? this.this$0.style.getVisible() : visible.booleanValue());
            }
        });
        this.initialPageIndex$delegate = SnapshotStateKt.e(new Function0<Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$initialPageIndex$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                PartialCarouselComponent partial;
                Integer initialPageIndex;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return Integer.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (initialPageIndex = partial.getInitialPageIndex()) == null) ? this.this$0.style.getInitialPageIndex() : initialPageIndex.intValue());
            }
        });
        this.pages$delegate = SnapshotStateKt.e(new Function0<List<? extends StackComponentStyle>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$pages$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<StackComponentStyle> invoke() {
                return this.this$0.style.getPages();
            }
        });
        this.pageAlignment$delegate = SnapshotStateKt.e(new Function0<Alignment.Vertical>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$pageAlignment$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Alignment.Vertical invoke() {
                PartialCarouselComponent partial;
                VerticalAlignment pageAlignment;
                Alignment.Vertical alignment;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (pageAlignment = partial.getPageAlignment()) == null || (alignment = AlignmentKt.toAlignment(pageAlignment)) == null) ? this.this$0.style.getPageAlignment() : alignment;
            }
        });
        this.size$delegate = SnapshotStateKt.e(new Function0<Size>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$size$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Size invoke() {
                PartialCarouselComponent partial;
                Size size;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (size = partial.getSize()) == null) ? this.this$0.style.getSize() : size;
            }
        });
        this.pagePeek$delegate = SnapshotStateKt.e(new Function0<Dp>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$pagePeek$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                return Dp.d(m709invokeD9Ej5fM());
            }

            /* JADX INFO: renamed from: invoke-D9Ej5fM, reason: not valid java name */
            public final float m709invokeD9Ej5fM() {
                PartialCarouselComponent partial;
                Integer pagePeek;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (pagePeek = partial.getPagePeek()) == null) ? this.this$0.style.m819getPagePeekD9Ej5fM() : Dp.g(pagePeek.intValue());
            }
        });
        this.background$delegate = SnapshotStateKt.e(new Function0<BackgroundStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$background$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final BackgroundStyles invoke() {
                BackgroundStyles backgroundStyles;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (backgroundStyles = presentedPartial.getBackgroundStyles()) == null) ? this.this$0.style.getBackground() : backgroundStyles;
            }
        });
        this.pageSpacing$delegate = SnapshotStateKt.e(new Function0<Dp>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$pageSpacing$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                return Dp.d(m710invokeD9Ej5fM());
            }

            /* JADX INFO: renamed from: invoke-D9Ej5fM, reason: not valid java name */
            public final float m710invokeD9Ej5fM() {
                PartialCarouselComponent partial;
                Float pageSpacing;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (pageSpacing = partial.getPageSpacing()) == null) ? this.this$0.style.m820getPageSpacingD9Ej5fM() : Dp.g(pageSpacing.floatValue());
            }
        });
        this.padding$delegate = SnapshotStateKt.e(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$padding$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialCarouselComponent partial;
                Padding padding;
                PaddingValues paddingValues;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (padding = partial.getPadding()) == null || (paddingValues = PaddingKt.toPaddingValues(padding)) == null) ? this.this$0.style.getPadding() : paddingValues;
            }
        });
        this.margin$delegate = SnapshotStateKt.e(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$margin$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialCarouselComponent partial;
                Padding margin;
                PaddingValues paddingValues;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (margin = partial.getMargin()) == null || (paddingValues = PaddingKt.toPaddingValues(margin)) == null) ? this.this$0.style.getMargin() : paddingValues;
            }
        });
        this.shape$delegate = SnapshotStateKt.e(new Function0<Shape>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$shape$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Shape invoke() {
                PartialCarouselComponent partial;
                com.revenuecat.purchases.paywalls.components.properties.Shape shape;
                Shape shape2;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (shape = partial.getShape()) == null || (shape2 = ShapeKt.toShape(shape)) == null) ? ShapeKt.toShape(this.this$0.style.getShape()) : shape2;
            }
        });
        this.border$delegate = SnapshotStateKt.e(new Function0<BorderStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$border$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final BorderStyles invoke() {
                BorderStyles borderStyles;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (borderStyles = presentedPartial.getBorderStyles()) == null) ? this.this$0.style.getBorder() : borderStyles;
            }
        });
        this.shadow$delegate = SnapshotStateKt.e(new Function0<ShadowStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$shadow$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ShadowStyles invoke() {
                ShadowStyles shadowStyles;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (shadowStyles = presentedPartial.getShadowStyles()) == null) ? this.this$0.style.getShadow() : shadowStyles;
            }
        });
        this.pageControl$delegate = SnapshotStateKt.e(new Function0<CarouselComponentStyle.PageControlStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$pageControl$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CarouselComponentStyle.PageControlStyles invoke() {
                CarouselComponentStyle.PageControlStyles pageControlStyles;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (pageControlStyles = presentedPartial.getPageControlStyles()) == null) ? this.this$0.style.getPageControl() : pageControlStyles;
            }
        });
        this.loop$delegate = SnapshotStateKt.e(new Function0<Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$loop$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                PartialCarouselComponent partial;
                Boolean loop;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return Boolean.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (loop = partial.getLoop()) == null) ? this.this$0.style.getLoop() : loop.booleanValue());
            }
        });
        this.autoAdvance$delegate = SnapshotStateKt.e(new Function0<CarouselComponent.AutoAdvancePages>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState$autoAdvance$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CarouselComponent.AutoAdvancePages invoke() {
                PartialCarouselComponent partial;
                CarouselComponent.AutoAdvancePages autoAdvance;
                PresentedCarouselPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (autoAdvance = partial.getAutoAdvance()) == null) ? this.this$0.style.getAutoAdvance() : autoAdvance;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PresentedCarouselPartial getPresentedPartial() {
        return (PresentedCarouselPartial) this.presentedPartial$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WindowWidthSizeClass getWindowSize() {
        return (WindowWidthSizeClass) this.windowSize$delegate.getValue();
    }

    private final void setWindowSize(WindowWidthSizeClass windowWidthSizeClass) {
        this.windowSize$delegate.setValue(windowWidthSizeClass);
    }

    public static /* synthetic */ void update$default(CarouselComponentState carouselComponentState, WindowWidthSizeClass windowWidthSizeClass, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            windowWidthSizeClass = null;
        }
        carouselComponentState.update(windowWidthSizeClass);
    }

    public final /* synthetic */ CarouselComponent.AutoAdvancePages getAutoAdvance() {
        return (CarouselComponent.AutoAdvancePages) this.autoAdvance$delegate.getValue();
    }

    public final /* synthetic */ BackgroundStyles getBackground() {
        return (BackgroundStyles) this.background$delegate.getValue();
    }

    public final /* synthetic */ BorderStyles getBorder() {
        return (BorderStyles) this.border$delegate.getValue();
    }

    public final /* synthetic */ int getInitialPageIndex() {
        return ((Number) this.initialPageIndex$delegate.getValue()).intValue();
    }

    public final /* synthetic */ boolean getLoop() {
        return ((Boolean) this.loop$delegate.getValue()).booleanValue();
    }

    public final /* synthetic */ PaddingValues getMargin() {
        return (PaddingValues) this.margin$delegate.getValue();
    }

    public final /* synthetic */ PaddingValues getPadding() {
        return (PaddingValues) this.padding$delegate.getValue();
    }

    public final /* synthetic */ Alignment.Vertical getPageAlignment() {
        return (Alignment.Vertical) this.pageAlignment$delegate.getValue();
    }

    public final /* synthetic */ CarouselComponentStyle.PageControlStyles getPageControl() {
        return (CarouselComponentStyle.PageControlStyles) this.pageControl$delegate.getValue();
    }

    /* JADX INFO: renamed from: getPagePeek-D9Ej5fM, reason: not valid java name */
    public final /* synthetic */ float m707getPagePeekD9Ej5fM() {
        return ((Dp) this.pagePeek$delegate.getValue()).l();
    }

    /* JADX INFO: renamed from: getPageSpacing-D9Ej5fM, reason: not valid java name */
    public final /* synthetic */ float m708getPageSpacingD9Ej5fM() {
        return ((Dp) this.pageSpacing$delegate.getValue()).l();
    }

    public final /* synthetic */ List getPages() {
        return (List) this.pages$delegate.getValue();
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

    public final /* synthetic */ boolean getVisible() {
        return ((Boolean) this.visible$delegate.getValue()).booleanValue();
    }

    public final /* synthetic */ void update(WindowWidthSizeClass windowWidthSizeClass) {
        if (windowWidthSizeClass != null) {
            setWindowSize(windowWidthSizeClass);
        }
    }

    public /* synthetic */ CarouselComponentState(WindowWidthSizeClass windowWidthSizeClass, CarouselComponentStyle carouselComponentStyle, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowWidthSizeClass, carouselComponentStyle, function0, function02, function03, (i3 & 32) != 0 ? new Function0<Map<String, ? extends CustomVariableValue>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentState.1
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, CustomVariableValue> invoke() {
                return MapsKt.emptyMap();
            }
        } : function04);
    }
}
