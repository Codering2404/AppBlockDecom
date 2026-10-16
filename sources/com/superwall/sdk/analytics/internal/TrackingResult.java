package com.superwall.sdk.analytics.internal;

import com.superwall.sdk.models.events.EventData;
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
public final class TrackingResult {
    public static final Companion Companion = new Companion(null);
    private EventData data;
    private final TrackingParameters parameters;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TrackingResult stub() {
            return new TrackingResult(EventData.Companion.stub(), TrackingParameters.Companion.stub());
        }

        private Companion() {
        }
    }

    public TrackingResult(EventData data, TrackingParameters parameters) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        this.data = data;
        this.parameters = parameters;
    }

    public static /* synthetic */ TrackingResult copy$default(TrackingResult trackingResult, EventData eventData, TrackingParameters trackingParameters, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            eventData = trackingResult.data;
        }
        if ((i3 & 2) != 0) {
            trackingParameters = trackingResult.parameters;
        }
        return trackingResult.copy(eventData, trackingParameters);
    }

    public final EventData component1() {
        return this.data;
    }

    public final TrackingParameters component2() {
        return this.parameters;
    }

    public final TrackingResult copy(EventData data, TrackingParameters parameters) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        return new TrackingResult(data, parameters);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrackingResult)) {
            return false;
        }
        TrackingResult trackingResult = (TrackingResult) obj;
        return Intrinsics.areEqual(this.data, trackingResult.data) && Intrinsics.areEqual(this.parameters, trackingResult.parameters);
    }

    public final EventData getData() {
        return this.data;
    }

    public final TrackingParameters getParameters() {
        return this.parameters;
    }

    public int hashCode() {
        return (this.data.hashCode() * 31) + this.parameters.hashCode();
    }

    public final void setData(EventData eventData) {
        Intrinsics.checkNotNullParameter(eventData, "<set-?>");
        this.data = eventData;
    }

    public String toString() {
        return "TrackingResult(data=" + this.data + ", parameters=" + this.parameters + ")";
    }
}
