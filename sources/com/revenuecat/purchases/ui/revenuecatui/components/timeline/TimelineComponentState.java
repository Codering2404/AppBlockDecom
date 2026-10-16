package com.revenuecat.purchases.ui.revenuecatui.components.timeline;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.window.core.layout.WindowWidthSizeClass;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.PartialTimelineComponent;
import com.revenuecat.purchases.paywalls.components.PartialTimelineComponentItem;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.components.ComponentViewState;
import com.revenuecat.purchases.ui.revenuecatui.components.ConditionContext;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartialKt;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedTimelineItemPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedTimelinePartial;
import com.revenuecat.purchases.ui.revenuecatui.components.ScreenCondition;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.PaddingKt;
import com.revenuecat.purchases.ui.revenuecatui.components.state.PackageAwareDelegate;
import com.revenuecat.purchases.ui.revenuecatui.components.style.IconComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TextComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TimelineComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class TimelineComponentState {
    public static final int $stable = 0;
    private final State columnGutter$delegate;
    private final Function0<Map<String, CustomVariableValue>> customVariablesProvider;
    private final State iconAlignment$delegate;
    private final State itemSpacing$delegate;
    private final State items$delegate;
    private final State margin$delegate;
    private final PackageAwareDelegate packageAwareDelegate;
    private final State padding$delegate;
    private final State presentedPartial$delegate;
    private final Function0<OfferEligibility> selectedOfferEligibilityProvider;
    private final Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider;
    private final Function0<Integer> selectedTabIndexProvider;
    private final State size$delegate;
    private final TimelineComponentStyle style;
    private final State textSpacing$delegate;
    private final State visible$delegate;
    private final MutableState windowSize$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public TimelineComponentState(WindowWidthSizeClass initialWindowSize, TimelineComponentStyle style, Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider, Function0<Integer> selectedTabIndexProvider, Function0<? extends OfferEligibility> selectedOfferEligibilityProvider, Function0<? extends Map<String, ? extends CustomVariableValue>> customVariablesProvider) {
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
        this.presentedPartial$delegate = SnapshotStateKt.e(new Function0<PresentedTimelinePartial>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$presentedPartial$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PresentedTimelinePartial invoke() {
                Package rcPackage;
                ScreenCondition screenConditionFrom = ScreenCondition.Companion.from(this.this$0.getWindowSize());
                ComponentViewState componentViewState = this.this$0.packageAwareDelegate.isSelected() ? ComponentViewState.SELECTED : ComponentViewState.DEFAULT;
                List overrides = this.this$0.style.getOverrides();
                OfferEligibility offerEligibility = this.this$0.packageAwareDelegate.getOfferEligibility();
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = (PaywallState.Loaded.Components.SelectedPackageInfo) this.this$0.selectedPackageInfoProvider.invoke();
                return (PresentedTimelinePartial) PresentedPartialKt.buildPresentedPartial(overrides, screenConditionFrom, offerEligibility, componentViewState, new ConditionContext((selectedPackageInfo == null || (rcPackage = selectedPackageInfo.getRcPackage()) == null) ? null : rcPackage.getIdentifier(), (Map) this.this$0.customVariablesProvider.invoke()));
            }
        });
        this.visible$delegate = SnapshotStateKt.e(new Function0<Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$visible$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                PartialTimelineComponent partial;
                Boolean visible;
                PresentedTimelinePartial presentedPartial = this.this$0.getPresentedPartial();
                return Boolean.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (visible = partial.getVisible()) == null) ? this.this$0.style.getVisible() : visible.booleanValue());
            }
        });
        this.itemSpacing$delegate = SnapshotStateKt.e(new Function0<Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$itemSpacing$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                PartialTimelineComponent partial;
                Integer itemSpacing;
                PresentedTimelinePartial presentedPartial = this.this$0.getPresentedPartial();
                return Integer.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (itemSpacing = partial.getItemSpacing()) == null) ? this.this$0.style.getItemSpacing() : itemSpacing.intValue());
            }
        });
        this.textSpacing$delegate = SnapshotStateKt.e(new Function0<Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$textSpacing$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                PartialTimelineComponent partial;
                Integer textSpacing;
                PresentedTimelinePartial presentedPartial = this.this$0.getPresentedPartial();
                return Integer.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (textSpacing = partial.getTextSpacing()) == null) ? this.this$0.style.getTextSpacing() : textSpacing.intValue());
            }
        });
        this.columnGutter$delegate = SnapshotStateKt.e(new Function0<Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$columnGutter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                PartialTimelineComponent partial;
                Integer columnGutter;
                PresentedTimelinePartial presentedPartial = this.this$0.getPresentedPartial();
                return Integer.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (columnGutter = partial.getColumnGutter()) == null) ? this.this$0.style.getColumnGutter() : columnGutter.intValue());
            }
        });
        this.iconAlignment$delegate = SnapshotStateKt.e(new Function0<TimelineComponent.IconAlignment>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$iconAlignment$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final TimelineComponent.IconAlignment invoke() {
                PartialTimelineComponent partial;
                TimelineComponent.IconAlignment iconAlignment;
                PresentedTimelinePartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (iconAlignment = partial.getIconAlignment()) == null) ? this.this$0.style.getIconAlignment() : iconAlignment;
            }
        });
        this.size$delegate = SnapshotStateKt.e(new Function0<Size>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$size$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Size invoke() {
                PartialTimelineComponent partial;
                Size size;
                PresentedTimelinePartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (size = partial.getSize()) == null) ? this.this$0.style.getSize() : size;
            }
        });
        this.padding$delegate = SnapshotStateKt.e(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$padding$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialTimelineComponent partial;
                Padding padding;
                PaddingValues paddingValues;
                PresentedTimelinePartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (padding = partial.getPadding()) == null || (paddingValues = PaddingKt.toPaddingValues(padding)) == null) ? this.this$0.style.getPadding() : paddingValues;
            }
        });
        this.margin$delegate = SnapshotStateKt.e(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$margin$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialTimelineComponent partial;
                Padding margin;
                PaddingValues paddingValues;
                PresentedTimelinePartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (margin = partial.getMargin()) == null || (paddingValues = PaddingKt.toPaddingValues(margin)) == null) ? this.this$0.style.getMargin() : paddingValues;
            }
        });
        this.items$delegate = SnapshotStateKt.e(new Function0<List<? extends ItemState>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$items$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<TimelineComponentState.ItemState> invoke() {
                List items = this.this$0.style.getItems();
                TimelineComponentState timelineComponentState = this.this$0;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
                Iterator it = items.iterator();
                while (it.hasNext()) {
                    arrayList.add(new TimelineComponentState.ItemState(timelineComponentState.getWindowSize(), (TimelineComponentStyle.ItemStyle) it.next(), timelineComponentState.selectedPackageInfoProvider, timelineComponentState.selectedTabIndexProvider, timelineComponentState.selectedOfferEligibilityProvider, timelineComponentState.customVariablesProvider));
                }
                return arrayList;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PresentedTimelinePartial getPresentedPartial() {
        return (PresentedTimelinePartial) this.presentedPartial$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WindowWidthSizeClass getWindowSize() {
        return (WindowWidthSizeClass) this.windowSize$delegate.getValue();
    }

    private final void setWindowSize(WindowWidthSizeClass windowWidthSizeClass) {
        this.windowSize$delegate.setValue(windowWidthSizeClass);
    }

    public static /* synthetic */ void update$default(TimelineComponentState timelineComponentState, WindowWidthSizeClass windowWidthSizeClass, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            windowWidthSizeClass = null;
        }
        timelineComponentState.update(windowWidthSizeClass);
    }

    public final /* synthetic */ int getColumnGutter() {
        return ((Number) this.columnGutter$delegate.getValue()).intValue();
    }

    public final /* synthetic */ TimelineComponent.IconAlignment getIconAlignment() {
        return (TimelineComponent.IconAlignment) this.iconAlignment$delegate.getValue();
    }

    public final /* synthetic */ int getItemSpacing() {
        return ((Number) this.itemSpacing$delegate.getValue()).intValue();
    }

    public final /* synthetic */ List getItems() {
        return (List) this.items$delegate.getValue();
    }

    public final /* synthetic */ PaddingValues getMargin() {
        return (PaddingValues) this.margin$delegate.getValue();
    }

    public final /* synthetic */ PaddingValues getPadding() {
        return (PaddingValues) this.padding$delegate.getValue();
    }

    public final /* synthetic */ Size getSize() {
        return (Size) this.size$delegate.getValue();
    }

    public final /* synthetic */ int getTextSpacing() {
        return ((Number) this.textSpacing$delegate.getValue()).intValue();
    }

    public final /* synthetic */ boolean getVisible() {
        return ((Boolean) this.visible$delegate.getValue()).booleanValue();
    }

    public final /* synthetic */ void update(WindowWidthSizeClass windowWidthSizeClass) {
        if (windowWidthSizeClass != null) {
            setWindowSize(windowWidthSizeClass);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ItemState {
        public static final int $stable = 0;
        private final State connector$delegate;
        private final Function0<Map<String, CustomVariableValue>> customVariablesProvider;
        private final State description$delegate;
        private final State icon$delegate;
        private final PackageAwareDelegate packageAwareDelegate;
        private final State presentedPartial$delegate;
        private final Function0<OfferEligibility> selectedOfferEligibilityProvider;
        private final Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider;
        private final Function0<Integer> selectedTabIndexProvider;
        private final TimelineComponentStyle.ItemStyle style;
        private final State title$delegate;
        private final State visible$delegate;
        private final MutableState windowSize$delegate;

        /* JADX WARN: Multi-variable type inference failed */
        public ItemState(WindowWidthSizeClass initialWindowSize, TimelineComponentStyle.ItemStyle style, Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider, Function0<Integer> selectedTabIndexProvider, Function0<? extends OfferEligibility> selectedOfferEligibilityProvider, Function0<? extends Map<String, ? extends CustomVariableValue>> customVariablesProvider) {
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
            this.presentedPartial$delegate = SnapshotStateKt.e(new Function0<PresentedTimelineItemPartial>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$ItemState$presentedPartial$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final PresentedTimelineItemPartial invoke() {
                    Package rcPackage;
                    ScreenCondition screenConditionFrom = ScreenCondition.Companion.from(this.this$0.getWindowSize());
                    ComponentViewState componentViewState = this.this$0.packageAwareDelegate.isSelected() ? ComponentViewState.SELECTED : ComponentViewState.DEFAULT;
                    List overrides = this.this$0.style.getOverrides();
                    OfferEligibility offerEligibility = this.this$0.packageAwareDelegate.getOfferEligibility();
                    PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = (PaywallState.Loaded.Components.SelectedPackageInfo) this.this$0.selectedPackageInfoProvider.invoke();
                    return (PresentedTimelineItemPartial) PresentedPartialKt.buildPresentedPartial(overrides, screenConditionFrom, offerEligibility, componentViewState, new ConditionContext((selectedPackageInfo == null || (rcPackage = selectedPackageInfo.getRcPackage()) == null) ? null : rcPackage.getIdentifier(), (Map) this.this$0.customVariablesProvider.invoke()));
                }
            });
            this.visible$delegate = SnapshotStateKt.e(new Function0<Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$ItemState$visible$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    PartialTimelineComponentItem partial;
                    Boolean visible;
                    PresentedTimelineItemPartial presentedPartial = this.this$0.getPresentedPartial();
                    return Boolean.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (visible = partial.getVisible()) == null) ? this.this$0.style.getVisible() : visible.booleanValue());
                }
            });
            this.title$delegate = SnapshotStateKt.e(new Function0<TextComponentStyle>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$ItemState$title$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final TextComponentStyle invoke() {
                    return this.this$0.style.getTitle();
                }
            });
            this.description$delegate = SnapshotStateKt.e(new Function0<TextComponentStyle>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$ItemState$description$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final TextComponentStyle invoke() {
                    return this.this$0.style.getDescription();
                }
            });
            this.icon$delegate = SnapshotStateKt.e(new Function0<IconComponentStyle>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$ItemState$icon$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final IconComponentStyle invoke() {
                    return this.this$0.style.getIcon();
                }
            });
            this.connector$delegate = SnapshotStateKt.e(new Function0<TimelineComponentStyle.ConnectorStyle>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState$ItemState$connector$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final TimelineComponentStyle.ConnectorStyle invoke() {
                    TimelineComponentStyle.ConnectorStyle connectorStyle;
                    PresentedTimelineItemPartial presentedPartial = this.this$0.getPresentedPartial();
                    return (presentedPartial == null || (connectorStyle = presentedPartial.getConnectorStyle()) == null) ? this.this$0.style.getConnector() : connectorStyle;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final PresentedTimelineItemPartial getPresentedPartial() {
            return (PresentedTimelineItemPartial) this.presentedPartial$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final WindowWidthSizeClass getWindowSize() {
            return (WindowWidthSizeClass) this.windowSize$delegate.getValue();
        }

        private final void setWindowSize(WindowWidthSizeClass windowWidthSizeClass) {
            this.windowSize$delegate.setValue(windowWidthSizeClass);
        }

        public static /* synthetic */ void update$default(ItemState itemState, WindowWidthSizeClass windowWidthSizeClass, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                windowWidthSizeClass = null;
            }
            itemState.update(windowWidthSizeClass);
        }

        public final /* synthetic */ TimelineComponentStyle.ConnectorStyle getConnector() {
            return (TimelineComponentStyle.ConnectorStyle) this.connector$delegate.getValue();
        }

        public final /* synthetic */ TextComponentStyle getDescription() {
            return (TextComponentStyle) this.description$delegate.getValue();
        }

        public final /* synthetic */ IconComponentStyle getIcon() {
            return (IconComponentStyle) this.icon$delegate.getValue();
        }

        public final /* synthetic */ TextComponentStyle getTitle() {
            return (TextComponentStyle) this.title$delegate.getValue();
        }

        public final /* synthetic */ boolean getVisible() {
            return ((Boolean) this.visible$delegate.getValue()).booleanValue();
        }

        public final /* synthetic */ void update(WindowWidthSizeClass windowWidthSizeClass) {
            if (windowWidthSizeClass != null) {
                setWindowSize(windowWidthSizeClass);
            }
        }

        public /* synthetic */ ItemState(WindowWidthSizeClass windowWidthSizeClass, TimelineComponentStyle.ItemStyle itemStyle, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(windowWidthSizeClass, itemStyle, function0, function02, function03, (i3 & 32) != 0 ? new Function0<Map<String, ? extends CustomVariableValue>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState.ItemState.1
                @Override // kotlin.jvm.functions.Function0
                public final Map<String, CustomVariableValue> invoke() {
                    return MapsKt.emptyMap();
                }
            } : function04);
        }
    }

    public /* synthetic */ TimelineComponentState(WindowWidthSizeClass windowWidthSizeClass, TimelineComponentStyle timelineComponentStyle, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowWidthSizeClass, timelineComponentStyle, function0, function02, function03, (i3 & 32) != 0 ? new Function0<Map<String, ? extends CustomVariableValue>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentState.1
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, CustomVariableValue> invoke() {
                return MapsKt.emptyMap();
            }
        } : function04);
    }
}
