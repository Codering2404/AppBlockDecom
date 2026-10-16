package com.revenuecat.purchases.ui.revenuecatui.components.style;

import androidx.compose.foundation.layout.PaddingValues;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedOverride;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedTimelineItemPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedTimelinePartial;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import com.sun.jna.Function;
import java.util.List;
import kotlin.Metadata;
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
public final class TimelineComponentStyle implements ComponentStyle, PackageContext {
    public static final int $stable = 0;
    private final int columnGutter;
    private final TimelineComponent.IconAlignment iconAlignment;
    private final int itemSpacing;
    private final List<ItemStyle> items;
    private final PaddingValues margin;
    private final OfferEligibility offerEligibility;
    private final List<PresentedOverride<PresentedTimelinePartial>> overrides;
    private final PaddingValues padding;
    private final Package rcPackage;
    private final ResolvedOffer resolvedOffer;
    private final Size size;
    private final Integer tabIndex;
    private final int textSpacing;
    private final boolean visible;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ConnectorStyle {
        public static final int $stable = 0;
        private final ColorStyles color;
        private final PaddingValues margin;
        private final int width;

        public ConnectorStyle(int i3, PaddingValues margin, ColorStyles color) {
            Intrinsics.checkNotNullParameter(margin, "margin");
            Intrinsics.checkNotNullParameter(color, "color");
            this.width = i3;
            this.margin = margin;
            this.color = color;
        }

        public static /* synthetic */ ConnectorStyle copy$default(ConnectorStyle connectorStyle, int i3, PaddingValues paddingValues, ColorStyles colorStyles, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i3 = connectorStyle.width;
            }
            if ((i4 & 2) != 0) {
                paddingValues = connectorStyle.margin;
            }
            if ((i4 & 4) != 0) {
                colorStyles = connectorStyle.color;
            }
            return connectorStyle.copy(i3, paddingValues, colorStyles);
        }

        public final int component1() {
            return this.width;
        }

        public final PaddingValues component2() {
            return this.margin;
        }

        public final ColorStyles component3() {
            return this.color;
        }

        public final ConnectorStyle copy(int i3, PaddingValues margin, ColorStyles color) {
            Intrinsics.checkNotNullParameter(margin, "margin");
            Intrinsics.checkNotNullParameter(color, "color");
            return new ConnectorStyle(i3, margin, color);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ConnectorStyle)) {
                return false;
            }
            ConnectorStyle connectorStyle = (ConnectorStyle) obj;
            return this.width == connectorStyle.width && Intrinsics.areEqual(this.margin, connectorStyle.margin) && Intrinsics.areEqual(this.color, connectorStyle.color);
        }

        public final /* synthetic */ ColorStyles getColor() {
            return this.color;
        }

        public final /* synthetic */ PaddingValues getMargin() {
            return this.margin;
        }

        public final /* synthetic */ int getWidth() {
            return this.width;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.width) * 31) + this.margin.hashCode()) * 31) + this.color.hashCode();
        }

        public String toString() {
            return "ConnectorStyle(width=" + this.width + ", margin=" + this.margin + ", color=" + this.color + ')';
        }
    }

    public TimelineComponentStyle(int i3, int i4, int i5, TimelineComponent.IconAlignment iconAlignment, boolean z2, Size size, PaddingValues padding, PaddingValues margin, List<ItemStyle> items, Package r11, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List<PresentedOverride<PresentedTimelinePartial>> overrides) {
        Intrinsics.checkNotNullParameter(iconAlignment, "iconAlignment");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.itemSpacing = i3;
        this.textSpacing = i4;
        this.columnGutter = i5;
        this.iconAlignment = iconAlignment;
        this.visible = z2;
        this.size = size;
        this.padding = padding;
        this.margin = margin;
        this.items = items;
        this.rcPackage = r11;
        this.resolvedOffer = resolvedOffer;
        this.tabIndex = num;
        this.offerEligibility = offerEligibility;
        this.overrides = overrides;
    }

    public final int component1() {
        return this.itemSpacing;
    }

    public final Package component10() {
        return this.rcPackage;
    }

    public final ResolvedOffer component11() {
        return this.resolvedOffer;
    }

    public final Integer component12() {
        return this.tabIndex;
    }

    public final OfferEligibility component13() {
        return this.offerEligibility;
    }

    public final List<PresentedOverride<PresentedTimelinePartial>> component14() {
        return this.overrides;
    }

    public final int component2() {
        return this.textSpacing;
    }

    public final int component3() {
        return this.columnGutter;
    }

    public final TimelineComponent.IconAlignment component4() {
        return this.iconAlignment;
    }

    public final boolean component5() {
        return this.visible;
    }

    public final Size component6() {
        return this.size;
    }

    public final PaddingValues component7() {
        return this.padding;
    }

    public final PaddingValues component8() {
        return this.margin;
    }

    public final List<ItemStyle> component9() {
        return this.items;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ boolean computeIsSelected(PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo, int i3) {
        return PackageContext.DefaultImpls.computeIsSelected(this, selectedPackageInfo, i3);
    }

    public final TimelineComponentStyle copy(int i3, int i4, int i5, TimelineComponent.IconAlignment iconAlignment, boolean z2, Size size, PaddingValues padding, PaddingValues margin, List<ItemStyle> items, Package r26, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List<PresentedOverride<PresentedTimelinePartial>> overrides) {
        Intrinsics.checkNotNullParameter(iconAlignment, "iconAlignment");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        return new TimelineComponentStyle(i3, i4, i5, iconAlignment, z2, size, padding, margin, items, r26, resolvedOffer, num, offerEligibility, overrides);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimelineComponentStyle)) {
            return false;
        }
        TimelineComponentStyle timelineComponentStyle = (TimelineComponentStyle) obj;
        return this.itemSpacing == timelineComponentStyle.itemSpacing && this.textSpacing == timelineComponentStyle.textSpacing && this.columnGutter == timelineComponentStyle.columnGutter && this.iconAlignment == timelineComponentStyle.iconAlignment && this.visible == timelineComponentStyle.visible && Intrinsics.areEqual(this.size, timelineComponentStyle.size) && Intrinsics.areEqual(this.padding, timelineComponentStyle.padding) && Intrinsics.areEqual(this.margin, timelineComponentStyle.margin) && Intrinsics.areEqual(this.items, timelineComponentStyle.items) && Intrinsics.areEqual(this.rcPackage, timelineComponentStyle.rcPackage) && Intrinsics.areEqual(this.resolvedOffer, timelineComponentStyle.resolvedOffer) && Intrinsics.areEqual(this.tabIndex, timelineComponentStyle.tabIndex) && Intrinsics.areEqual(this.offerEligibility, timelineComponentStyle.offerEligibility) && Intrinsics.areEqual(this.overrides, timelineComponentStyle.overrides);
    }

    public final /* synthetic */ int getColumnGutter() {
        return this.columnGutter;
    }

    public final /* synthetic */ TimelineComponent.IconAlignment getIconAlignment() {
        return this.iconAlignment;
    }

    public final /* synthetic */ int getItemSpacing() {
        return this.itemSpacing;
    }

    public final /* synthetic */ List getItems() {
        return this.items;
    }

    public final /* synthetic */ PaddingValues getMargin() {
        return this.margin;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ OfferEligibility getOfferEligibility() {
        return this.offerEligibility;
    }

    public final /* synthetic */ List getOverrides() {
        return this.overrides;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public String getPackageUniqueId() {
        return PackageContext.DefaultImpls.getPackageUniqueId(this);
    }

    public final /* synthetic */ PaddingValues getPadding() {
        return this.padding;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ Package getRcPackage() {
        return this.rcPackage;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ ResolvedOffer getResolvedOffer() {
        return this.resolvedOffer;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public /* synthetic */ Size getSize() {
        return this.size;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ Integer getTabIndex() {
        return this.tabIndex;
    }

    public final /* synthetic */ int getTextSpacing() {
        return this.textSpacing;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
    public /* synthetic */ boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((Integer.hashCode(this.itemSpacing) * 31) + Integer.hashCode(this.textSpacing)) * 31) + Integer.hashCode(this.columnGutter)) * 31) + this.iconAlignment.hashCode()) * 31) + Boolean.hashCode(this.visible)) * 31) + this.size.hashCode()) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31) + this.items.hashCode()) * 31;
        Package r12 = this.rcPackage;
        int iHashCode2 = (iHashCode + (r12 == null ? 0 : r12.hashCode())) * 31;
        ResolvedOffer resolvedOffer = this.resolvedOffer;
        int iHashCode3 = (iHashCode2 + (resolvedOffer == null ? 0 : resolvedOffer.hashCode())) * 31;
        Integer num = this.tabIndex;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        OfferEligibility offerEligibility = this.offerEligibility;
        return ((iHashCode4 + (offerEligibility != null ? offerEligibility.hashCode() : 0)) * 31) + this.overrides.hashCode();
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ OfferEligibility resolveOfferEligibility(OfferEligibility offerEligibility) {
        return PackageContext.DefaultImpls.resolveOfferEligibility(this, offerEligibility);
    }

    public String toString() {
        return "TimelineComponentStyle(itemSpacing=" + this.itemSpacing + ", textSpacing=" + this.textSpacing + ", columnGutter=" + this.columnGutter + ", iconAlignment=" + this.iconAlignment + ", visible=" + this.visible + ", size=" + this.size + ", padding=" + this.padding + ", margin=" + this.margin + ", items=" + this.items + ", rcPackage=" + this.rcPackage + ", resolvedOffer=" + this.resolvedOffer + ", tabIndex=" + this.tabIndex + ", offerEligibility=" + this.offerEligibility + ", overrides=" + this.overrides + ')';
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ItemStyle implements PackageContext {
        public static final int $stable = 0;
        private final ConnectorStyle connector;
        private final TextComponentStyle description;
        private final IconComponentStyle icon;
        private final OfferEligibility offerEligibility;
        private final List<PresentedOverride<PresentedTimelineItemPartial>> overrides;
        private final Package rcPackage;
        private final ResolvedOffer resolvedOffer;
        private final Integer tabIndex;
        private final TextComponentStyle title;
        private final boolean visible;

        public ItemStyle(TextComponentStyle title, boolean z2, TextComponentStyle textComponentStyle, IconComponentStyle icon, ConnectorStyle connectorStyle, Package r7, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List<PresentedOverride<PresentedTimelineItemPartial>> overrides) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(icon, "icon");
            Intrinsics.checkNotNullParameter(overrides, "overrides");
            this.title = title;
            this.visible = z2;
            this.description = textComponentStyle;
            this.icon = icon;
            this.connector = connectorStyle;
            this.rcPackage = r7;
            this.resolvedOffer = resolvedOffer;
            this.tabIndex = num;
            this.offerEligibility = offerEligibility;
            this.overrides = overrides;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ItemStyle copy$default(ItemStyle itemStyle, TextComponentStyle textComponentStyle, boolean z2, TextComponentStyle textComponentStyle2, IconComponentStyle iconComponentStyle, ConnectorStyle connectorStyle, Package r6, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                textComponentStyle = itemStyle.title;
            }
            if ((i3 & 2) != 0) {
                z2 = itemStyle.visible;
            }
            if ((i3 & 4) != 0) {
                textComponentStyle2 = itemStyle.description;
            }
            if ((i3 & 8) != 0) {
                iconComponentStyle = itemStyle.icon;
            }
            if ((i3 & 16) != 0) {
                connectorStyle = itemStyle.connector;
            }
            if ((i3 & 32) != 0) {
                r6 = itemStyle.rcPackage;
            }
            if ((i3 & 64) != 0) {
                resolvedOffer = itemStyle.resolvedOffer;
            }
            if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                num = itemStyle.tabIndex;
            }
            if ((i3 & Function.MAX_NARGS) != 0) {
                offerEligibility = itemStyle.offerEligibility;
            }
            if ((i3 & 512) != 0) {
                list = itemStyle.overrides;
            }
            OfferEligibility offerEligibility2 = offerEligibility;
            List list2 = list;
            ResolvedOffer resolvedOffer2 = resolvedOffer;
            Integer num2 = num;
            ConnectorStyle connectorStyle2 = connectorStyle;
            Package r8 = r6;
            return itemStyle.copy(textComponentStyle, z2, textComponentStyle2, iconComponentStyle, connectorStyle2, r8, resolvedOffer2, num2, offerEligibility2, list2);
        }

        public final TextComponentStyle component1() {
            return this.title;
        }

        public final List<PresentedOverride<PresentedTimelineItemPartial>> component10() {
            return this.overrides;
        }

        public final boolean component2() {
            return this.visible;
        }

        public final TextComponentStyle component3() {
            return this.description;
        }

        public final IconComponentStyle component4() {
            return this.icon;
        }

        public final ConnectorStyle component5() {
            return this.connector;
        }

        public final Package component6() {
            return this.rcPackage;
        }

        public final ResolvedOffer component7() {
            return this.resolvedOffer;
        }

        public final Integer component8() {
            return this.tabIndex;
        }

        public final OfferEligibility component9() {
            return this.offerEligibility;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
        public /* synthetic */ boolean computeIsSelected(PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo, int i3) {
            return PackageContext.DefaultImpls.computeIsSelected(this, selectedPackageInfo, i3);
        }

        public final ItemStyle copy(TextComponentStyle title, boolean z2, TextComponentStyle textComponentStyle, IconComponentStyle icon, ConnectorStyle connectorStyle, Package r18, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List<PresentedOverride<PresentedTimelineItemPartial>> overrides) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(icon, "icon");
            Intrinsics.checkNotNullParameter(overrides, "overrides");
            return new ItemStyle(title, z2, textComponentStyle, icon, connectorStyle, r18, resolvedOffer, num, offerEligibility, overrides);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ItemStyle)) {
                return false;
            }
            ItemStyle itemStyle = (ItemStyle) obj;
            return Intrinsics.areEqual(this.title, itemStyle.title) && this.visible == itemStyle.visible && Intrinsics.areEqual(this.description, itemStyle.description) && Intrinsics.areEqual(this.icon, itemStyle.icon) && Intrinsics.areEqual(this.connector, itemStyle.connector) && Intrinsics.areEqual(this.rcPackage, itemStyle.rcPackage) && Intrinsics.areEqual(this.resolvedOffer, itemStyle.resolvedOffer) && Intrinsics.areEqual(this.tabIndex, itemStyle.tabIndex) && Intrinsics.areEqual(this.offerEligibility, itemStyle.offerEligibility) && Intrinsics.areEqual(this.overrides, itemStyle.overrides);
        }

        public final /* synthetic */ ConnectorStyle getConnector() {
            return this.connector;
        }

        public final /* synthetic */ TextComponentStyle getDescription() {
            return this.description;
        }

        public final /* synthetic */ IconComponentStyle getIcon() {
            return this.icon;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
        public /* synthetic */ OfferEligibility getOfferEligibility() {
            return this.offerEligibility;
        }

        public final /* synthetic */ List getOverrides() {
            return this.overrides;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
        public String getPackageUniqueId() {
            return PackageContext.DefaultImpls.getPackageUniqueId(this);
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
        public /* synthetic */ Package getRcPackage() {
            return this.rcPackage;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
        public /* synthetic */ ResolvedOffer getResolvedOffer() {
            return this.resolvedOffer;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
        public /* synthetic */ Integer getTabIndex() {
            return this.tabIndex;
        }

        public final /* synthetic */ TextComponentStyle getTitle() {
            return this.title;
        }

        public final /* synthetic */ boolean getVisible() {
            return this.visible;
        }

        public int hashCode() {
            int iHashCode = ((this.title.hashCode() * 31) + Boolean.hashCode(this.visible)) * 31;
            TextComponentStyle textComponentStyle = this.description;
            int iHashCode2 = (((iHashCode + (textComponentStyle == null ? 0 : textComponentStyle.hashCode())) * 31) + this.icon.hashCode()) * 31;
            ConnectorStyle connectorStyle = this.connector;
            int iHashCode3 = (iHashCode2 + (connectorStyle == null ? 0 : connectorStyle.hashCode())) * 31;
            Package r12 = this.rcPackage;
            int iHashCode4 = (iHashCode3 + (r12 == null ? 0 : r12.hashCode())) * 31;
            ResolvedOffer resolvedOffer = this.resolvedOffer;
            int iHashCode5 = (iHashCode4 + (resolvedOffer == null ? 0 : resolvedOffer.hashCode())) * 31;
            Integer num = this.tabIndex;
            int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
            OfferEligibility offerEligibility = this.offerEligibility;
            return ((iHashCode6 + (offerEligibility != null ? offerEligibility.hashCode() : 0)) * 31) + this.overrides.hashCode();
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.components.state.PackageContext
        public /* synthetic */ OfferEligibility resolveOfferEligibility(OfferEligibility offerEligibility) {
            return PackageContext.DefaultImpls.resolveOfferEligibility(this, offerEligibility);
        }

        public String toString() {
            return "ItemStyle(title=" + this.title + ", visible=" + this.visible + ", description=" + this.description + ", icon=" + this.icon + ", connector=" + this.connector + ", rcPackage=" + this.rcPackage + ", resolvedOffer=" + this.resolvedOffer + ", tabIndex=" + this.tabIndex + ", offerEligibility=" + this.offerEligibility + ", overrides=" + this.overrides + ')';
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ ItemStyle(TextComponentStyle textComponentStyle, boolean z2, TextComponentStyle textComponentStyle2, IconComponentStyle iconComponentStyle, ConnectorStyle connectorStyle, Package r7, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            List list2;
            OfferEligibility offerEligibility2;
            resolvedOffer = (i3 & 64) != 0 ? null : resolvedOffer;
            if ((i3 & Function.MAX_NARGS) != 0) {
                list2 = list;
                offerEligibility2 = null;
            } else {
                list2 = list;
                offerEligibility2 = offerEligibility;
            }
            this(textComponentStyle, z2, textComponentStyle2, iconComponentStyle, connectorStyle, r7, resolvedOffer, num, offerEligibility2, list2);
        }
    }

    public /* synthetic */ TimelineComponentStyle(int i3, int i4, int i5, TimelineComponent.IconAlignment iconAlignment, boolean z2, Size size, PaddingValues paddingValues, PaddingValues paddingValues2, List list, Package r28, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, List list2, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i4, i5, iconAlignment, z2, size, paddingValues, paddingValues2, list, r28, (i6 & 1024) != 0 ? null : resolvedOffer, num, (i6 & 4096) != 0 ? null : offerEligibility, list2);
    }
}
