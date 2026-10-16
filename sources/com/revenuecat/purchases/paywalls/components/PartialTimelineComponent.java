package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
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
@Metadata
@Serializable
public final class PartialTimelineComponent implements PartialComponent {
    public static final Companion Companion = new Companion(null);
    private final Integer columnGutter;
    private final TimelineComponent.IconAlignment iconAlignment;
    private final Integer itemSpacing;
    private final Padding margin;
    private final Padding padding;
    private final Size size;
    private final Integer textSpacing;
    private final Boolean visible;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PartialTimelineComponent> serializer() {
            return PartialTimelineComponent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public PartialTimelineComponent() {
        this((Boolean) null, (Integer) null, (Integer) null, (Integer) null, (TimelineComponent.IconAlignment) null, (Size) null, (Padding) null, (Padding) null, 255, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PartialTimelineComponent partialTimelineComponent, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.z(serialDescriptor, 0) || partialTimelineComponent.visible != null) {
            compositeEncoder.i(serialDescriptor, 0, BooleanSerializer.f142767a, partialTimelineComponent.visible);
        }
        if (compositeEncoder.z(serialDescriptor, 1) || partialTimelineComponent.itemSpacing != null) {
            compositeEncoder.i(serialDescriptor, 1, IntSerializer.f142823a, partialTimelineComponent.itemSpacing);
        }
        if (compositeEncoder.z(serialDescriptor, 2) || partialTimelineComponent.textSpacing != null) {
            compositeEncoder.i(serialDescriptor, 2, IntSerializer.f142823a, partialTimelineComponent.textSpacing);
        }
        if (compositeEncoder.z(serialDescriptor, 3) || partialTimelineComponent.columnGutter != null) {
            compositeEncoder.i(serialDescriptor, 3, IntSerializer.f142823a, partialTimelineComponent.columnGutter);
        }
        if (compositeEncoder.z(serialDescriptor, 4) || partialTimelineComponent.iconAlignment != null) {
            compositeEncoder.i(serialDescriptor, 4, TimelineIconAlignmentDeserializer.INSTANCE, partialTimelineComponent.iconAlignment);
        }
        if (compositeEncoder.z(serialDescriptor, 5) || partialTimelineComponent.size != null) {
            compositeEncoder.i(serialDescriptor, 5, Size$$serializer.INSTANCE, partialTimelineComponent.size);
        }
        if (compositeEncoder.z(serialDescriptor, 6) || partialTimelineComponent.padding != null) {
            compositeEncoder.i(serialDescriptor, 6, Padding$$serializer.INSTANCE, partialTimelineComponent.padding);
        }
        if (!compositeEncoder.z(serialDescriptor, 7) && partialTimelineComponent.margin == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 7, Padding$$serializer.INSTANCE, partialTimelineComponent.margin);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PartialTimelineComponent)) {
            return false;
        }
        PartialTimelineComponent partialTimelineComponent = (PartialTimelineComponent) obj;
        return Intrinsics.areEqual(this.visible, partialTimelineComponent.visible) && Intrinsics.areEqual(this.itemSpacing, partialTimelineComponent.itemSpacing) && Intrinsics.areEqual(this.textSpacing, partialTimelineComponent.textSpacing) && Intrinsics.areEqual(this.columnGutter, partialTimelineComponent.columnGutter) && this.iconAlignment == partialTimelineComponent.iconAlignment && Intrinsics.areEqual(this.size, partialTimelineComponent.size) && Intrinsics.areEqual(this.padding, partialTimelineComponent.padding) && Intrinsics.areEqual(this.margin, partialTimelineComponent.margin);
    }

    public final /* synthetic */ Integer getColumnGutter() {
        return this.columnGutter;
    }

    public final /* synthetic */ TimelineComponent.IconAlignment getIconAlignment() {
        return this.iconAlignment;
    }

    public final /* synthetic */ Integer getItemSpacing() {
        return this.itemSpacing;
    }

    public final /* synthetic */ Padding getMargin() {
        return this.margin;
    }

    public final /* synthetic */ Padding getPadding() {
        return this.padding;
    }

    public final /* synthetic */ Size getSize() {
        return this.size;
    }

    public final /* synthetic */ Integer getTextSpacing() {
        return this.textSpacing;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        Boolean bool = this.visible;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Integer num = this.itemSpacing;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.textSpacing;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.columnGutter;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        TimelineComponent.IconAlignment iconAlignment = this.iconAlignment;
        int iHashCode5 = (iHashCode4 + (iconAlignment == null ? 0 : iconAlignment.hashCode())) * 31;
        Size size = this.size;
        int iHashCode6 = (iHashCode5 + (size == null ? 0 : size.hashCode())) * 31;
        Padding padding = this.padding;
        int iHashCode7 = (iHashCode6 + (padding == null ? 0 : padding.hashCode())) * 31;
        Padding padding2 = this.margin;
        return iHashCode7 + (padding2 != null ? padding2.hashCode() : 0);
    }

    public String toString() {
        return "PartialTimelineComponent(visible=" + this.visible + ", itemSpacing=" + this.itemSpacing + ", textSpacing=" + this.textSpacing + ", columnGutter=" + this.columnGutter + ", iconAlignment=" + this.iconAlignment + ", size=" + this.size + ", padding=" + this.padding + ", margin=" + this.margin + ')';
    }

    @Deprecated
    public /* synthetic */ PartialTimelineComponent(int i3, Boolean bool, @SerialName Integer num, @SerialName Integer num2, @SerialName Integer num3, @SerialName TimelineComponent.IconAlignment iconAlignment, Size size, Padding padding, Padding padding2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i3 & 1) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        if ((i3 & 2) == 0) {
            this.itemSpacing = null;
        } else {
            this.itemSpacing = num;
        }
        if ((i3 & 4) == 0) {
            this.textSpacing = null;
        } else {
            this.textSpacing = num2;
        }
        if ((i3 & 8) == 0) {
            this.columnGutter = null;
        } else {
            this.columnGutter = num3;
        }
        if ((i3 & 16) == 0) {
            this.iconAlignment = null;
        } else {
            this.iconAlignment = iconAlignment;
        }
        if ((i3 & 32) == 0) {
            this.size = null;
        } else {
            this.size = size;
        }
        if ((i3 & 64) == 0) {
            this.padding = null;
        } else {
            this.padding = padding;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
            this.margin = null;
        } else {
            this.margin = padding2;
        }
    }

    public PartialTimelineComponent(Boolean bool, Integer num, Integer num2, Integer num3, TimelineComponent.IconAlignment iconAlignment, Size size, Padding padding, Padding padding2) {
        this.visible = bool;
        this.itemSpacing = num;
        this.textSpacing = num2;
        this.columnGutter = num3;
        this.iconAlignment = iconAlignment;
        this.size = size;
        this.padding = padding;
        this.margin = padding2;
    }

    public /* synthetic */ PartialTimelineComponent(Boolean bool, Integer num, Integer num2, Integer num3, TimelineComponent.IconAlignment iconAlignment, Size size, Padding padding, Padding padding2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bool, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : num2, (i3 & 8) != 0 ? null : num3, (i3 & 16) != 0 ? null : iconAlignment, (i3 & 32) != 0 ? null : size, (i3 & 64) != 0 ? null : padding, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : padding2);
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
}
