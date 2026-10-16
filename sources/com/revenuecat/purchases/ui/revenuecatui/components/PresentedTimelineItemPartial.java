package com.revenuecat.purchases.ui.revenuecatui.components;

import com.revenuecat.purchases.paywalls.components.PartialTimelineComponentItem;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.PaddingKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TimelineComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public final class PresentedTimelineItemPartial implements PresentedPartial<PresentedTimelineItemPartial> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final TimelineComponentStyle.ConnectorStyle connectorStyle;
    private final PartialTimelineComponentItem partial;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final /* synthetic */ Result invoke(PartialTimelineComponentItem from, Map aliases) {
            ColorScheme color;
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(aliases, "aliases");
            TimelineComponent.Connector connector = from.getConnector();
            TimelineComponentStyle.ConnectorStyle connectorStyle = null;
            Result resultOrSuccessfullyNull = ResultKt.orSuccessfullyNull((connector == null || (color = connector.getColor()) == null) ? null : ColorStyleKt.toColorStyles(color, aliases));
            if (!(resultOrSuccessfullyNull instanceof Result.Success)) {
                if (resultOrSuccessfullyNull instanceof Result.Error) {
                    return resultOrSuccessfullyNull;
                }
                throw new NoWhenBranchMatchedException();
            }
            ColorStyles colorStyles = (ColorStyles) ((Result.Success) resultOrSuccessfullyNull).getValue();
            TimelineComponent.Connector connector2 = from.getConnector();
            if (connector2 != null && colorStyles != null) {
                connectorStyle = new TimelineComponentStyle.ConnectorStyle(connector2.getWidth(), PaddingKt.toPaddingValues(connector2.getMargin()), colorStyles);
            }
            return new Result.Success(new PresentedTimelineItemPartial(from, connectorStyle));
        }

        private Companion() {
        }
    }

    public PresentedTimelineItemPartial(PartialTimelineComponentItem partial, TimelineComponentStyle.ConnectorStyle connectorStyle) {
        Intrinsics.checkNotNullParameter(partial, "partial");
        this.partial = partial;
        this.connectorStyle = connectorStyle;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PresentedTimelineItemPartial)) {
            return false;
        }
        PresentedTimelineItemPartial presentedTimelineItemPartial = (PresentedTimelineItemPartial) obj;
        return Intrinsics.areEqual(this.partial, presentedTimelineItemPartial.partial) && Intrinsics.areEqual(this.connectorStyle, presentedTimelineItemPartial.connectorStyle);
    }

    public final /* synthetic */ TimelineComponentStyle.ConnectorStyle getConnectorStyle() {
        return this.connectorStyle;
    }

    public final /* synthetic */ PartialTimelineComponentItem getPartial() {
        return this.partial;
    }

    public int hashCode() {
        int iHashCode = this.partial.hashCode() * 31;
        TimelineComponentStyle.ConnectorStyle connectorStyle = this.connectorStyle;
        return iHashCode + (connectorStyle == null ? 0 : connectorStyle.hashCode());
    }

    public String toString() {
        return "PresentedTimelineItemPartial(partial=" + this.partial + ", connectorStyle=" + this.connectorStyle + ')';
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartial
    public PresentedTimelineItemPartial combine(PresentedTimelineItemPartial presentedTimelineItemPartial) {
        Boolean visible;
        TimelineComponent.Connector connector;
        TimelineComponentStyle.ConnectorStyle connectorStyle;
        PartialTimelineComponentItem partialTimelineComponentItem = presentedTimelineItemPartial != null ? presentedTimelineItemPartial.partial : null;
        if (partialTimelineComponentItem == null || (visible = partialTimelineComponentItem.getVisible()) == null) {
            visible = this.partial.getVisible();
        }
        if (partialTimelineComponentItem == null || (connector = partialTimelineComponentItem.getConnector()) == null) {
            connector = this.partial.getConnector();
        }
        PartialTimelineComponentItem partialTimelineComponentItem2 = new PartialTimelineComponentItem(visible, connector);
        if (presentedTimelineItemPartial == null || (connectorStyle = presentedTimelineItemPartial.connectorStyle) == null) {
            connectorStyle = this.connectorStyle;
        }
        return new PresentedTimelineItemPartial(partialTimelineComponentItem2, connectorStyle);
    }
}
