package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

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
/* JADX INFO: loaded from: classes6.dex */
@SerialName
@Metadata
@Serializable
public final class TimelineComponent implements PaywallComponent {
    private final int columnGutter;
    private final IconAlignment iconAlignment;
    private final int itemSpacing;
    private final List<Item> items;
    private final Padding margin;
    private final List<ComponentOverride<PartialTimelineComponent>> overrides;
    private final Padding padding;
    private final Size size;
    private final int textSpacing;
    private final Boolean visible;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, new ArrayListSerializer(TimelineComponent$Item$$serializer.INSTANCE), new ArrayListSerializer(ComponentOverride.Companion.serializer(PartialTimelineComponent$$serializer.INSTANCE))};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<TimelineComponent> serializer() {
            return TimelineComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Connector {
        public static final Companion Companion = new Companion(null);
        private final ColorScheme color;
        private final Padding margin;
        private final int width;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Connector> serializer() {
                return TimelineComponent$Connector$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        @Deprecated
        public /* synthetic */ Connector(int i3, int i4, Padding padding, ColorScheme colorScheme, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i3 & 7)) {
                PluginExceptionsKt.b(i3, 7, TimelineComponent$Connector$$serializer.INSTANCE.getDescriptor());
            }
            this.width = i4;
            this.margin = padding;
            this.color = colorScheme;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Connector connector, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            compositeEncoder.w(serialDescriptor, 0, connector.width);
            compositeEncoder.C(serialDescriptor, 1, Padding$$serializer.INSTANCE, connector.margin);
            compositeEncoder.C(serialDescriptor, 2, ColorScheme$$serializer.INSTANCE, connector.color);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Connector)) {
                return false;
            }
            Connector connector = (Connector) obj;
            return this.width == connector.width && Intrinsics.areEqual(this.margin, connector.margin) && Intrinsics.areEqual(this.color, connector.color);
        }

        public final /* synthetic */ ColorScheme getColor() {
            return this.color;
        }

        public final /* synthetic */ Padding getMargin() {
            return this.margin;
        }

        public final /* synthetic */ int getWidth() {
            return this.width;
        }

        public int hashCode() {
            return (((this.width * 31) + this.margin.hashCode()) * 31) + this.color.hashCode();
        }

        public String toString() {
            return "Connector(width=" + this.width + ", margin=" + this.margin + ", color=" + this.color + ')';
        }

        public Connector(int i3, Padding margin, ColorScheme color) {
            Intrinsics.checkNotNullParameter(margin, "margin");
            Intrinsics.checkNotNullParameter(color, "color");
            this.width = i3;
            this.margin = margin;
            this.color = color;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable(with = TimelineIconAlignmentDeserializer.class)
    public enum IconAlignment {
        Title,
        TitleAndDescription;

        public static final Companion Companion = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<IconAlignment> serializer() {
                return TimelineIconAlignmentDeserializer.INSTANCE;
            }

            private Companion() {
            }
        }
    }

    @Deprecated
    public /* synthetic */ TimelineComponent(int i3, @SerialName int i4, @SerialName int i5, @SerialName int i6, @SerialName IconAlignment iconAlignment, Boolean bool, Size size, Padding padding, Padding padding2, List list, List list2, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i3 & 15)) {
            PluginExceptionsKt.b(i3, 15, TimelineComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.itemSpacing = i4;
        this.textSpacing = i5;
        this.columnGutter = i6;
        this.iconAlignment = iconAlignment;
        if ((i3 & 16) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        if ((i3 & 32) == 0) {
            this.size = new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE);
        } else {
            this.size = size;
        }
        if ((i3 & 64) == 0) {
            this.padding = Padding.Companion.getZero();
        } else {
            this.padding = padding;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
            this.margin = Padding.Companion.getZero();
        } else {
            this.margin = padding2;
        }
        if ((i3 & Function.MAX_NARGS) == 0) {
            this.items = CollectionsKt.emptyList();
        } else {
            this.items = list;
        }
        if ((i3 & 512) == 0) {
            this.overrides = CollectionsKt.emptyList();
        } else {
            this.overrides = list2;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(TimelineComponent timelineComponent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.w(serialDescriptor, 0, timelineComponent.itemSpacing);
        compositeEncoder.w(serialDescriptor, 1, timelineComponent.textSpacing);
        compositeEncoder.w(serialDescriptor, 2, timelineComponent.columnGutter);
        compositeEncoder.C(serialDescriptor, 3, TimelineIconAlignmentDeserializer.INSTANCE, timelineComponent.iconAlignment);
        if (compositeEncoder.z(serialDescriptor, 4) || timelineComponent.visible != null) {
            compositeEncoder.i(serialDescriptor, 4, BooleanSerializer.f142767a, timelineComponent.visible);
        }
        if (compositeEncoder.z(serialDescriptor, 5) || !Intrinsics.areEqual(timelineComponent.size, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE))) {
            compositeEncoder.C(serialDescriptor, 5, Size$$serializer.INSTANCE, timelineComponent.size);
        }
        if (compositeEncoder.z(serialDescriptor, 6) || !Intrinsics.areEqual(timelineComponent.padding, Padding.Companion.getZero())) {
            compositeEncoder.C(serialDescriptor, 6, Padding$$serializer.INSTANCE, timelineComponent.padding);
        }
        if (compositeEncoder.z(serialDescriptor, 7) || !Intrinsics.areEqual(timelineComponent.margin, Padding.Companion.getZero())) {
            compositeEncoder.C(serialDescriptor, 7, Padding$$serializer.INSTANCE, timelineComponent.margin);
        }
        if (compositeEncoder.z(serialDescriptor, 8) || !Intrinsics.areEqual(timelineComponent.items, CollectionsKt.emptyList())) {
            compositeEncoder.C(serialDescriptor, 8, kSerializerArr[8], timelineComponent.items);
        }
        if (!compositeEncoder.z(serialDescriptor, 9) && Intrinsics.areEqual(timelineComponent.overrides, CollectionsKt.emptyList())) {
            return;
        }
        compositeEncoder.C(serialDescriptor, 9, kSerializerArr[9], timelineComponent.overrides);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimelineComponent)) {
            return false;
        }
        TimelineComponent timelineComponent = (TimelineComponent) obj;
        return this.itemSpacing == timelineComponent.itemSpacing && this.textSpacing == timelineComponent.textSpacing && this.columnGutter == timelineComponent.columnGutter && this.iconAlignment == timelineComponent.iconAlignment && Intrinsics.areEqual(this.visible, timelineComponent.visible) && Intrinsics.areEqual(this.size, timelineComponent.size) && Intrinsics.areEqual(this.padding, timelineComponent.padding) && Intrinsics.areEqual(this.margin, timelineComponent.margin) && Intrinsics.areEqual(this.items, timelineComponent.items) && Intrinsics.areEqual(this.overrides, timelineComponent.overrides);
    }

    public final /* synthetic */ int getColumnGutter() {
        return this.columnGutter;
    }

    public final /* synthetic */ IconAlignment getIconAlignment() {
        return this.iconAlignment;
    }

    public final /* synthetic */ int getItemSpacing() {
        return this.itemSpacing;
    }

    public final /* synthetic */ List getItems() {
        return this.items;
    }

    public final /* synthetic */ Padding getMargin() {
        return this.margin;
    }

    public final /* synthetic */ List getOverrides() {
        return this.overrides;
    }

    public final /* synthetic */ Padding getPadding() {
        return this.padding;
    }

    public final /* synthetic */ Size getSize() {
        return this.size;
    }

    public final /* synthetic */ int getTextSpacing() {
        return this.textSpacing;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        int iHashCode = ((((((this.itemSpacing * 31) + this.textSpacing) * 31) + this.columnGutter) * 31) + this.iconAlignment.hashCode()) * 31;
        Boolean bool = this.visible;
        return ((((((((((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31) + this.size.hashCode()) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31) + this.items.hashCode()) * 31) + this.overrides.hashCode();
    }

    public String toString() {
        return "TimelineComponent(itemSpacing=" + this.itemSpacing + ", textSpacing=" + this.textSpacing + ", columnGutter=" + this.columnGutter + ", iconAlignment=" + this.iconAlignment + ", visible=" + this.visible + ", size=" + this.size + ", padding=" + this.padding + ", margin=" + this.margin + ", items=" + this.items + ", overrides=" + this.overrides + ')';
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class Item {
        private final Connector connector;
        private final TextComponent description;
        private final IconComponent icon;
        private final List<ComponentOverride<PartialTimelineComponentItem>> overrides;
        private final TextComponent title;
        private final Boolean visible;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, new ArrayListSerializer(ComponentOverride.Companion.serializer(PartialTimelineComponentItem$$serializer.INSTANCE))};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<Item> serializer() {
                return TimelineComponent$Item$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        @Deprecated
        public /* synthetic */ Item(int i3, TextComponent textComponent, Boolean bool, TextComponent textComponent2, IconComponent iconComponent, Connector connector, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (9 != (i3 & 9)) {
                PluginExceptionsKt.b(i3, 9, TimelineComponent$Item$$serializer.INSTANCE.getDescriptor());
            }
            this.title = textComponent;
            if ((i3 & 2) == 0) {
                this.visible = null;
            } else {
                this.visible = bool;
            }
            if ((i3 & 4) == 0) {
                this.description = null;
            } else {
                this.description = textComponent2;
            }
            this.icon = iconComponent;
            if ((i3 & 16) == 0) {
                this.connector = null;
            } else {
                this.connector = connector;
            }
            if ((i3 & 32) == 0) {
                this.overrides = CollectionsKt.emptyList();
            } else {
                this.overrides = list;
            }
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Item item, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            TextComponent$$serializer textComponent$$serializer = TextComponent$$serializer.INSTANCE;
            compositeEncoder.C(serialDescriptor, 0, textComponent$$serializer, item.title);
            if (compositeEncoder.z(serialDescriptor, 1) || item.visible != null) {
                compositeEncoder.i(serialDescriptor, 1, BooleanSerializer.f142767a, item.visible);
            }
            if (compositeEncoder.z(serialDescriptor, 2) || item.description != null) {
                compositeEncoder.i(serialDescriptor, 2, textComponent$$serializer, item.description);
            }
            compositeEncoder.C(serialDescriptor, 3, IconComponent$$serializer.INSTANCE, item.icon);
            if (compositeEncoder.z(serialDescriptor, 4) || item.connector != null) {
                compositeEncoder.i(serialDescriptor, 4, TimelineComponent$Connector$$serializer.INSTANCE, item.connector);
            }
            if (!compositeEncoder.z(serialDescriptor, 5) && Intrinsics.areEqual(item.overrides, CollectionsKt.emptyList())) {
                return;
            }
            compositeEncoder.C(serialDescriptor, 5, kSerializerArr[5], item.overrides);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Item)) {
                return false;
            }
            Item item = (Item) obj;
            return Intrinsics.areEqual(this.title, item.title) && Intrinsics.areEqual(this.visible, item.visible) && Intrinsics.areEqual(this.description, item.description) && Intrinsics.areEqual(this.icon, item.icon) && Intrinsics.areEqual(this.connector, item.connector) && Intrinsics.areEqual(this.overrides, item.overrides);
        }

        public final /* synthetic */ Connector getConnector() {
            return this.connector;
        }

        public final /* synthetic */ TextComponent getDescription() {
            return this.description;
        }

        public final /* synthetic */ IconComponent getIcon() {
            return this.icon;
        }

        public final /* synthetic */ List getOverrides() {
            return this.overrides;
        }

        public final /* synthetic */ TextComponent getTitle() {
            return this.title;
        }

        public final /* synthetic */ Boolean getVisible() {
            return this.visible;
        }

        public int hashCode() {
            int iHashCode = this.title.hashCode() * 31;
            Boolean bool = this.visible;
            int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            TextComponent textComponent = this.description;
            int iHashCode3 = (((iHashCode2 + (textComponent == null ? 0 : textComponent.hashCode())) * 31) + this.icon.hashCode()) * 31;
            Connector connector = this.connector;
            return ((iHashCode3 + (connector != null ? connector.hashCode() : 0)) * 31) + this.overrides.hashCode();
        }

        public String toString() {
            return "Item(title=" + this.title + ", visible=" + this.visible + ", description=" + this.description + ", icon=" + this.icon + ", connector=" + this.connector + ", overrides=" + this.overrides + ')';
        }

        public Item(TextComponent title, Boolean bool, TextComponent textComponent, IconComponent icon, Connector connector, List<ComponentOverride<PartialTimelineComponentItem>> overrides) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(icon, "icon");
            Intrinsics.checkNotNullParameter(overrides, "overrides");
            this.title = title;
            this.visible = bool;
            this.description = textComponent;
            this.icon = icon;
            this.connector = connector;
            this.overrides = overrides;
        }

        public /* synthetic */ Item(TextComponent textComponent, Boolean bool, TextComponent textComponent2, IconComponent iconComponent, Connector connector, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(textComponent, (i3 & 2) != 0 ? null : bool, (i3 & 4) != 0 ? null : textComponent2, iconComponent, (i3 & 16) != 0 ? null : connector, (i3 & 32) != 0 ? CollectionsKt.emptyList() : list);
        }
    }

    public TimelineComponent(int i3, int i4, int i5, IconAlignment iconAlignment, Boolean bool, Size size, Padding padding, Padding margin, List<Item> items, List<ComponentOverride<PartialTimelineComponent>> overrides) {
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
        this.visible = bool;
        this.size = size;
        this.padding = padding;
        this.margin = margin;
        this.items = items;
        this.overrides = overrides;
    }

    @SerialName
    public static /* synthetic */ void getColumnGutter$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getIconAlignment$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getItemSpacing$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getTextSpacing$annotations() {
    }

    public /* synthetic */ TimelineComponent(int i3, int i4, int i5, IconAlignment iconAlignment, Boolean bool, Size size, Padding padding, Padding padding2, List list, List list2, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i4, i5, iconAlignment, (i6 & 16) != 0 ? null : bool, (i6 & 32) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE) : size, (i6 & 64) != 0 ? Padding.Companion.getZero() : padding, (i6 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? Padding.Companion.getZero() : padding2, (i6 & Function.MAX_NARGS) != 0 ? CollectionsKt.emptyList() : list, (i6 & 512) != 0 ? CollectionsKt.emptyList() : list2);
    }
}
