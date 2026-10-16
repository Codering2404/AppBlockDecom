package com.revenuecat.purchases.ui.revenuecatui.components.tabs;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Shape;
import androidx.window.core.layout.WindowWidthSizeClass;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.PartialTabsComponent;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.components.ComponentViewState;
import com.revenuecat.purchases.ui.revenuecatui.components.ConditionContext;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartialKt;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedTabsPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.ScreenCondition;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.PaddingKt;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.ShapeKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TabsComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PackageExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyList;
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
public final class TabsComponentState {
    public static final int $stable = 0;
    private final State background$delegate;
    private final State border$delegate;
    private final Function0<Map<String, CustomVariableValue>> customVariablesProvider;
    private final State margin$delegate;
    private final State offerEligibility$delegate;
    private final State padding$delegate;
    private final State presentedPartial$delegate;
    private final Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider;
    private final State shadow$delegate;
    private final State shape$delegate;
    private final State size$delegate;
    private final TabsComponentStyle style;
    private final NonEmptyList<TabsComponentStyle.Tab> tabs;
    private final State visible$delegate;
    private final MutableState windowSize$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public TabsComponentState(WindowWidthSizeClass initialWindowSize, TabsComponentStyle style, Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider, Function0<? extends Map<String, ? extends CustomVariableValue>> customVariablesProvider) {
        Intrinsics.checkNotNullParameter(initialWindowSize, "initialWindowSize");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(selectedPackageInfoProvider, "selectedPackageInfoProvider");
        Intrinsics.checkNotNullParameter(customVariablesProvider, "customVariablesProvider");
        this.style = style;
        this.selectedPackageInfoProvider = selectedPackageInfoProvider;
        this.customVariablesProvider = customVariablesProvider;
        this.windowSize$delegate = SnapshotStateKt__SnapshotStateKt.e(initialWindowSize, null, 2, null);
        this.offerEligibility$delegate = SnapshotStateKt.e(new Function0<OfferEligibility>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentState$offerEligibility$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final OfferEligibility invoke() {
                OfferEligibility offerEligibilityCalculateOfferEligibility;
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = (PaywallState.Loaded.Components.SelectedPackageInfo) this.this$0.selectedPackageInfoProvider.invoke();
                return (selectedPackageInfo == null || (offerEligibilityCalculateOfferEligibility = PackageExtensionsKt.calculateOfferEligibility(selectedPackageInfo.getResolvedOffer(), selectedPackageInfo.getRcPackage())) == null) ? OfferEligibility.Ineligible.INSTANCE : offerEligibilityCalculateOfferEligibility;
            }
        });
        this.presentedPartial$delegate = SnapshotStateKt.e(new Function0<PresentedTabsPartial>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentState$presentedPartial$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PresentedTabsPartial invoke() {
                Package rcPackage;
                ScreenCondition screenConditionFrom = ScreenCondition.Companion.from(this.this$0.getWindowSize());
                ComponentViewState componentViewState = ComponentViewState.DEFAULT;
                List overrides = this.this$0.style.getOverrides();
                OfferEligibility offerEligibility = this.this$0.getOfferEligibility();
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = (PaywallState.Loaded.Components.SelectedPackageInfo) this.this$0.selectedPackageInfoProvider.invoke();
                return (PresentedTabsPartial) PresentedPartialKt.buildPresentedPartial(overrides, screenConditionFrom, offerEligibility, componentViewState, new ConditionContext((selectedPackageInfo == null || (rcPackage = selectedPackageInfo.getRcPackage()) == null) ? null : rcPackage.getIdentifier(), (Map) this.this$0.customVariablesProvider.invoke()));
            }
        });
        this.visible$delegate = SnapshotStateKt.e(new Function0<Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentState$visible$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                PartialTabsComponent partial;
                Boolean visible;
                PresentedTabsPartial presentedPartial = this.this$0.getPresentedPartial();
                return Boolean.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (visible = partial.getVisible()) == null) ? this.this$0.style.getVisible() : visible.booleanValue());
            }
        });
        this.tabs = style.getTabs();
        this.size$delegate = SnapshotStateKt.e(new Function0<Size>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentState$size$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Size invoke() {
                PartialTabsComponent partial;
                Size size;
                PresentedTabsPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (size = partial.getSize()) == null) ? this.this$0.style.getSize() : size;
            }
        });
        this.background$delegate = SnapshotStateKt.e(new Function0<BackgroundStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentState$background$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final BackgroundStyles invoke() {
                BackgroundStyles backgroundStyles;
                PresentedTabsPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (backgroundStyles = presentedPartial.getBackgroundStyles()) == null) ? this.this$0.style.getBackground() : backgroundStyles;
            }
        });
        this.padding$delegate = SnapshotStateKt.e(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentState$padding$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialTabsComponent partial;
                Padding padding;
                PaddingValues paddingValues;
                PresentedTabsPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (padding = partial.getPadding()) == null || (paddingValues = PaddingKt.toPaddingValues(padding)) == null) ? this.this$0.style.getPadding() : paddingValues;
            }
        });
        this.margin$delegate = SnapshotStateKt.e(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentState$margin$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialTabsComponent partial;
                Padding margin;
                PaddingValues paddingValues;
                PresentedTabsPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (margin = partial.getMargin()) == null || (paddingValues = PaddingKt.toPaddingValues(margin)) == null) ? this.this$0.style.getMargin() : paddingValues;
            }
        });
        this.shape$delegate = SnapshotStateKt.e(new Function0<Shape>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentState$shape$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Shape invoke() {
                com.revenuecat.purchases.paywalls.components.properties.Shape shape;
                PartialTabsComponent partial;
                PresentedTabsPartial presentedPartial = this.this$0.getPresentedPartial();
                if (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (shape = partial.getShape()) == null) {
                    shape = this.this$0.style.getShape();
                }
                return ShapeKt.toShape(shape);
            }
        });
        this.border$delegate = SnapshotStateKt.e(new Function0<BorderStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentState$border$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final BorderStyles invoke() {
                BorderStyles borderStyles;
                PresentedTabsPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (borderStyles = presentedPartial.getBorderStyles()) == null) ? this.this$0.style.getBorder() : borderStyles;
            }
        });
        this.shadow$delegate = SnapshotStateKt.e(new Function0<ShadowStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentState$shadow$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ShadowStyles invoke() {
                ShadowStyles shadowStyles;
                PresentedTabsPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (shadowStyles = presentedPartial.getShadowStyles()) == null) ? this.this$0.style.getShadow() : shadowStyles;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OfferEligibility getOfferEligibility() {
        return (OfferEligibility) this.offerEligibility$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PresentedTabsPartial getPresentedPartial() {
        return (PresentedTabsPartial) this.presentedPartial$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WindowWidthSizeClass getWindowSize() {
        return (WindowWidthSizeClass) this.windowSize$delegate.getValue();
    }

    private final void setWindowSize(WindowWidthSizeClass windowWidthSizeClass) {
        this.windowSize$delegate.setValue(windowWidthSizeClass);
    }

    public static /* synthetic */ void update$default(TabsComponentState tabsComponentState, WindowWidthSizeClass windowWidthSizeClass, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            windowWidthSizeClass = null;
        }
        tabsComponentState.update(windowWidthSizeClass);
    }

    public final /* synthetic */ BackgroundStyles getBackground() {
        return (BackgroundStyles) this.background$delegate.getValue();
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

    public final /* synthetic */ NonEmptyList getTabs() {
        return this.tabs;
    }

    public final /* synthetic */ boolean getVisible() {
        return ((Boolean) this.visible$delegate.getValue()).booleanValue();
    }

    public final /* synthetic */ void update(WindowWidthSizeClass windowWidthSizeClass) {
        if (windowWidthSizeClass != null) {
            setWindowSize(windowWidthSizeClass);
        }
    }

    public /* synthetic */ TabsComponentState(WindowWidthSizeClass windowWidthSizeClass, TabsComponentStyle tabsComponentStyle, Function0 function0, Function0 function02, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowWidthSizeClass, tabsComponentStyle, function0, (i3 & 8) != 0 ? new Function0<Map<String, ? extends CustomVariableValue>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentState.1
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, CustomVariableValue> invoke() {
                return MapsKt.emptyMap();
            }
        } : function02);
    }
}
