package com.revenuecat.purchases.paywalls.components;

import com.facebook.share.HKJ.pnxuebdT;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
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
public final class PartialTimelineComponentItem implements PartialComponent {
    public static final Companion Companion = new Companion(null);
    private final TimelineComponent.Connector connector;
    private final Boolean visible;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<PartialTimelineComponentItem> serializer() {
            return PartialTimelineComponentItem$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PartialTimelineComponentItem() {
        this((Boolean) null, (TimelineComponent.Connector) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PartialTimelineComponentItem partialTimelineComponentItem, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.z(serialDescriptor, 0) || partialTimelineComponentItem.visible != null) {
            compositeEncoder.i(serialDescriptor, 0, BooleanSerializer.f142767a, partialTimelineComponentItem.visible);
        }
        if (!compositeEncoder.z(serialDescriptor, 1) && partialTimelineComponentItem.connector == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 1, TimelineComponent$Connector$$serializer.INSTANCE, partialTimelineComponentItem.connector);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PartialTimelineComponentItem)) {
            return false;
        }
        PartialTimelineComponentItem partialTimelineComponentItem = (PartialTimelineComponentItem) obj;
        return Intrinsics.areEqual(this.visible, partialTimelineComponentItem.visible) && Intrinsics.areEqual(this.connector, partialTimelineComponentItem.connector);
    }

    public final /* synthetic */ TimelineComponent.Connector getConnector() {
        return this.connector;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public int hashCode() {
        Boolean bool = this.visible;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        TimelineComponent.Connector connector = this.connector;
        return iHashCode + (connector != null ? connector.hashCode() : 0);
    }

    @Deprecated
    public /* synthetic */ PartialTimelineComponentItem(int i3, Boolean bool, TimelineComponent.Connector connector, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i3 & 1) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        if ((i3 & 2) == 0) {
            this.connector = null;
        } else {
            this.connector = connector;
        }
    }

    public String toString() {
        return pnxuebdT.Ffrc + this.visible + ", connector=" + this.connector + ')';
    }

    public PartialTimelineComponentItem(Boolean bool, TimelineComponent.Connector connector) {
        this.visible = bool;
        this.connector = connector;
    }

    public /* synthetic */ PartialTimelineComponentItem(Boolean bool, TimelineComponent.Connector connector, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bool, (i3 & 2) != 0 ? null : connector);
    }
}
