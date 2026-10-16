package com.superwall.sdk.analytics.internal;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
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
public final class TrackingParameters {
    public static final Companion Companion = new Companion(null);
    private final Map<String, Object> audienceFilterParams;
    private final Map<String, Object> delegateParams;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TrackingParameters stub() {
            return new TrackingParameters(MapsKt.emptyMap(), MapsKt.emptyMap());
        }

        private Companion() {
        }
    }

    public TrackingParameters(Map<String, ? extends Object> delegateParams, Map<String, ? extends Object> audienceFilterParams) {
        Intrinsics.checkNotNullParameter(delegateParams, "delegateParams");
        Intrinsics.checkNotNullParameter(audienceFilterParams, "audienceFilterParams");
        this.delegateParams = delegateParams;
        this.audienceFilterParams = audienceFilterParams;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TrackingParameters copy$default(TrackingParameters trackingParameters, Map map, Map map2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            map = trackingParameters.delegateParams;
        }
        if ((i3 & 2) != 0) {
            map2 = trackingParameters.audienceFilterParams;
        }
        return trackingParameters.copy(map, map2);
    }

    public final Map<String, Object> component1() {
        return this.delegateParams;
    }

    public final Map<String, Object> component2() {
        return this.audienceFilterParams;
    }

    public final TrackingParameters copy(Map<String, ? extends Object> delegateParams, Map<String, ? extends Object> audienceFilterParams) {
        Intrinsics.checkNotNullParameter(delegateParams, "delegateParams");
        Intrinsics.checkNotNullParameter(audienceFilterParams, "audienceFilterParams");
        return new TrackingParameters(delegateParams, audienceFilterParams);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrackingParameters)) {
            return false;
        }
        TrackingParameters trackingParameters = (TrackingParameters) obj;
        return Intrinsics.areEqual(this.delegateParams, trackingParameters.delegateParams) && Intrinsics.areEqual(this.audienceFilterParams, trackingParameters.audienceFilterParams);
    }

    public final Map<String, Object> getAudienceFilterParams() {
        return this.audienceFilterParams;
    }

    public final Map<String, Object> getDelegateParams() {
        return this.delegateParams;
    }

    public int hashCode() {
        return (this.delegateParams.hashCode() * 31) + this.audienceFilterParams.hashCode();
    }

    public String toString() {
        return "TrackingParameters(delegateParams=" + this.delegateParams + ", audienceFilterParams=" + this.audienceFilterParams + ")";
    }
}
