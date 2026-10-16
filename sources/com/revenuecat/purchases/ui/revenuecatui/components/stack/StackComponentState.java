package com.revenuecat.purchases.ui.revenuecatui.components.stack;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.window.core.layout.WindowWidthSizeClass;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.PartialStackComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.components.ComponentViewState;
import com.revenuecat.purchases.ui.revenuecatui.components.ConditionContext;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartialKt;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedStackPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.ScreenCondition;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.PaddingKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.state.PackageAwareDelegate;
import com.revenuecat.purchases.ui.revenuecatui.components.style.BadgeStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.extensions.OverflowExtensionsKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
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
public final class StackComponentState {
    public static final int $stable = 0;
    private final boolean applyBottomWindowInsets;
    private final boolean applyHorizontalWindowInsets;
    private final boolean applyTopWindowInsets;
    private final State background$delegate;
    private final State badge$delegate;
    private final State border$delegate;
    private final List<ComponentStyle> children;
    private final Function0<Map<String, CustomVariableValue>> customVariablesProvider;
    private final State dimension$delegate;
    private final boolean ignoreHeaderHeight;
    private final MutableState layoutDirection$delegate;
    private final State margin$delegate;
    private final PackageAwareDelegate packageAwareDelegate;
    private final State padding$delegate;
    private final State presentedPartial$delegate;
    private final State scrollOrientation$delegate;
    private final Function0<OfferEligibility> selectedOfferEligibilityProvider;
    private final Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider;
    private final Function0<Integer> selectedTabIndexProvider;
    private final State shadow$delegate;
    private final State shape$delegate;
    private final State size$delegate;
    private final State spacing$delegate;
    private final StackComponentStyle style;
    private final State visible$delegate;
    private final MutableState windowSize$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public StackComponentState(WindowWidthSizeClass initialWindowSize, LayoutDirection initialLayoutDirection, StackComponentStyle style, Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider, Function0<Integer> selectedTabIndexProvider, Function0<? extends OfferEligibility> selectedOfferEligibilityProvider, Function0<? extends Map<String, ? extends CustomVariableValue>> customVariablesProvider) {
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
        this.presentedPartial$delegate = SnapshotStateKt.e(new Function0<PresentedStackPartial>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$presentedPartial$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PresentedStackPartial invoke() {
                Package rcPackage;
                ScreenCondition screenConditionFrom = ScreenCondition.Companion.from(this.this$0.getWindowSize());
                ComponentViewState componentViewState = this.this$0.packageAwareDelegate.isSelected() ? ComponentViewState.SELECTED : ComponentViewState.DEFAULT;
                List overrides = this.this$0.style.getOverrides();
                OfferEligibility offerEligibility = this.this$0.packageAwareDelegate.getOfferEligibility();
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = (PaywallState.Loaded.Components.SelectedPackageInfo) this.this$0.selectedPackageInfoProvider.invoke();
                return (PresentedStackPartial) PresentedPartialKt.buildPresentedPartial(overrides, screenConditionFrom, offerEligibility, componentViewState, new ConditionContext((selectedPackageInfo == null || (rcPackage = selectedPackageInfo.getRcPackage()) == null) ? null : rcPackage.getIdentifier(), (Map) this.this$0.customVariablesProvider.invoke()));
            }
        });
        this.visible$delegate = SnapshotStateKt.e(new Function0<Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$visible$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                PartialStackComponent partial;
                Boolean visible;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return Boolean.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (visible = partial.getVisible()) == null) ? this.this$0.style.getVisible() : visible.booleanValue());
            }
        });
        this.children = style.getChildren();
        this.applyTopWindowInsets = style.getApplyTopWindowInsets();
        this.ignoreHeaderHeight = style.getIgnoreHeaderHeight();
        this.applyBottomWindowInsets = style.getApplyBottomWindowInsets();
        this.applyHorizontalWindowInsets = style.getApplyHorizontalWindowInsets();
        this.dimension$delegate = SnapshotStateKt.e(new Function0<Dimension>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$dimension$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Dimension invoke() {
                PartialStackComponent partial;
                Dimension dimension;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (dimension = partial.getDimension()) == null) ? this.this$0.style.getDimension() : dimension;
            }
        });
        this.spacing$delegate = SnapshotStateKt.e(new Function0<Dp>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$spacing$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                return Dp.d(m809invokeD9Ej5fM());
            }

            /* JADX INFO: renamed from: invoke-D9Ej5fM, reason: not valid java name */
            public final float m809invokeD9Ej5fM() {
                PartialStackComponent partial;
                Float spacing;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (spacing = partial.getSpacing()) == null) ? this.this$0.style.m836getSpacingD9Ej5fM() : Dp.g(spacing.floatValue());
            }
        });
        this.background$delegate = SnapshotStateKt.e(new Function0<BackgroundStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$background$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final BackgroundStyles invoke() {
                BackgroundStyles backgroundStyles;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (backgroundStyles = presentedPartial.getBackgroundStyles()) == null) ? this.this$0.style.getBackground() : backgroundStyles;
            }
        });
        this.padding$delegate = SnapshotStateKt.e(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$padding$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialStackComponent partial;
                Padding padding;
                PaddingValues paddingValues;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (padding = partial.getPadding()) == null || (paddingValues = PaddingKt.toPaddingValues(padding)) == null) ? this.this$0.style.getPadding() : paddingValues;
            }
        });
        this.margin$delegate = SnapshotStateKt.e(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$margin$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialStackComponent partial;
                Padding margin;
                PaddingValues paddingValues;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (margin = partial.getMargin()) == null || (paddingValues = PaddingKt.toPaddingValues(margin)) == null) ? this.this$0.style.getMargin() : paddingValues;
            }
        });
        this.size$delegate = SnapshotStateKt.e(new Function0<Size>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$size$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Size invoke() {
                Size size;
                PartialStackComponent partial;
                StackComponentState stackComponentState = this.this$0;
                PresentedStackPartial presentedPartial = stackComponentState.getPresentedPartial();
                if (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (size = partial.getSize()) == null) {
                    size = this.this$0.style.getSize();
                }
                return stackComponentState.adjustForMargin(size, this.this$0.getMargin(), this.this$0.getLayoutDirection());
            }
        });
        this.shape$delegate = SnapshotStateKt.e(new Function0<Shape>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$shape$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Shape invoke() {
                PartialStackComponent partial;
                Shape shape;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (shape = partial.getShape()) == null) ? this.this$0.style.getShape() : shape;
            }
        });
        this.border$delegate = SnapshotStateKt.e(new Function0<BorderStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$border$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final BorderStyles invoke() {
                BorderStyles borderStyles;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (borderStyles = presentedPartial.getBorderStyles()) == null) ? this.this$0.style.getBorder() : borderStyles;
            }
        });
        this.shadow$delegate = SnapshotStateKt.e(new Function0<ShadowStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$shadow$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ShadowStyles invoke() {
                ShadowStyles shadowStyles;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (shadowStyles = presentedPartial.getShadowStyles()) == null) ? this.this$0.style.getShadow() : shadowStyles;
            }
        });
        this.badge$delegate = SnapshotStateKt.e(new Function0<BadgeStyle>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$badge$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final BadgeStyle invoke() {
                BadgeStyle badgeStyle;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (badgeStyle = presentedPartial.getBadgeStyle()) == null) ? this.this$0.style.getBadge() : badgeStyle;
            }
        });
        this.scrollOrientation$delegate = SnapshotStateKt.e(new Function0<Orientation>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$scrollOrientation$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Orientation invoke() {
                PartialStackComponent partial;
                StackComponent.Overflow overflow;
                Orientation orientation;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (overflow = partial.getOverflow()) == null || (orientation = OverflowExtensionsKt.toOrientation(overflow, this.this$0.getDimension())) == null) ? this.this$0.style.getScrollOrientation() : orientation;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Size adjustForMargin(Size size, PaddingValues paddingValues, LayoutDirection layoutDirection) {
        SizeConstraint width = size.getWidth();
        if (width instanceof SizeConstraint.Fixed) {
            width = new SizeConstraint.Fixed(UInt.b(UInt.b(((SizeConstraint.Fixed) width).m662getValuepVg5ArA() + UnsignedKt.a(androidx.compose.foundation.layout.PaddingKt.g(paddingValues, layoutDirection))) + UnsignedKt.a(androidx.compose.foundation.layout.PaddingKt.f(paddingValues, layoutDirection))), null);
        } else {
            if (!(width instanceof SizeConstraint.Fill ? true : width instanceof SizeConstraint.Fit)) {
                throw new NoWhenBranchMatchedException();
            }
        }
        SizeConstraint height = size.getHeight();
        if (height instanceof SizeConstraint.Fixed) {
            height = new SizeConstraint.Fixed(UInt.b(UInt.b(((SizeConstraint.Fixed) height).m662getValuepVg5ArA() + UnsignedKt.a(paddingValues.d())) + UnsignedKt.a(paddingValues.a())), null);
        } else {
            if (!(height instanceof SizeConstraint.Fill ? true : height instanceof SizeConstraint.Fit)) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return new Size(width, height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.layoutDirection$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PresentedStackPartial getPresentedPartial() {
        return (PresentedStackPartial) this.presentedPartial$delegate.getValue();
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

    public static /* synthetic */ void update$default(StackComponentState stackComponentState, WindowWidthSizeClass windowWidthSizeClass, LayoutDirection layoutDirection, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            windowWidthSizeClass = null;
        }
        if ((i3 & 2) != 0) {
            layoutDirection = null;
        }
        stackComponentState.update(windowWidthSizeClass, layoutDirection);
    }

    public final /* synthetic */ boolean getApplyBottomWindowInsets() {
        return this.applyBottomWindowInsets;
    }

    public final /* synthetic */ boolean getApplyHorizontalWindowInsets() {
        return this.applyHorizontalWindowInsets;
    }

    public final /* synthetic */ boolean getApplyTopWindowInsets() {
        return this.applyTopWindowInsets;
    }

    public final /* synthetic */ BackgroundStyles getBackground() {
        return (BackgroundStyles) this.background$delegate.getValue();
    }

    public final /* synthetic */ BadgeStyle getBadge() {
        return (BadgeStyle) this.badge$delegate.getValue();
    }

    public final /* synthetic */ BorderStyles getBorder() {
        return (BorderStyles) this.border$delegate.getValue();
    }

    public final /* synthetic */ List getChildren() {
        return this.children;
    }

    public final /* synthetic */ Dimension getDimension() {
        return (Dimension) this.dimension$delegate.getValue();
    }

    public final /* synthetic */ boolean getIgnoreHeaderHeight() {
        return this.ignoreHeaderHeight;
    }

    public final /* synthetic */ PaddingValues getMargin() {
        return (PaddingValues) this.margin$delegate.getValue();
    }

    public final /* synthetic */ PaddingValues getPadding() {
        return (PaddingValues) this.padding$delegate.getValue();
    }

    public final /* synthetic */ Orientation getScrollOrientation() {
        return (Orientation) this.scrollOrientation$delegate.getValue();
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

    /* JADX INFO: renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
    public final /* synthetic */ float m808getSpacingD9Ej5fM() {
        return ((Dp) this.spacing$delegate.getValue()).l();
    }

    public final /* synthetic */ boolean getVisible() {
        return ((Boolean) this.visible$delegate.getValue()).booleanValue();
    }

    public final /* synthetic */ void update(WindowWidthSizeClass windowWidthSizeClass, LayoutDirection layoutDirection) {
        if (windowWidthSizeClass != null) {
            setWindowSize(windowWidthSizeClass);
        }
        if (layoutDirection != null) {
            setLayoutDirection(layoutDirection);
        }
    }

    public /* synthetic */ StackComponentState(WindowWidthSizeClass windowWidthSizeClass, LayoutDirection layoutDirection, StackComponentStyle stackComponentStyle, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowWidthSizeClass, layoutDirection, stackComponentStyle, function0, function02, function03, (i3 & 64) != 0 ? new Function0<Map<String, ? extends CustomVariableValue>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState.1
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, CustomVariableValue> invoke() {
                return MapsKt.emptyMap();
            }
        } : function04);
    }
}
