package com.superwall.sdk.paywall.presentation;

import com.superwall.sdk.paywall.presentation.internal.request.PaywallOverrides;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallState;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class TrackAndPresentRequest {
    private final boolean isFeatureGatable;
    private final Map<String, Object> params;
    private final PaywallOverrides paywallOverrides;
    private final String placement;
    private final MutableSharedFlow<PaywallState> publisher;

    public TrackAndPresentRequest(String placement, Map<String, ? extends Object> map, PaywallOverrides paywallOverrides, boolean z2, MutableSharedFlow<PaywallState> publisher) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        Intrinsics.checkNotNullParameter(publisher, "publisher");
        this.placement = placement;
        this.params = map;
        this.paywallOverrides = paywallOverrides;
        this.isFeatureGatable = z2;
        this.publisher = publisher;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TrackAndPresentRequest copy$default(TrackAndPresentRequest trackAndPresentRequest, String str, Map map, PaywallOverrides paywallOverrides, boolean z2, MutableSharedFlow mutableSharedFlow, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = trackAndPresentRequest.placement;
        }
        if ((i3 & 2) != 0) {
            map = trackAndPresentRequest.params;
        }
        if ((i3 & 4) != 0) {
            paywallOverrides = trackAndPresentRequest.paywallOverrides;
        }
        if ((i3 & 8) != 0) {
            z2 = trackAndPresentRequest.isFeatureGatable;
        }
        if ((i3 & 16) != 0) {
            mutableSharedFlow = trackAndPresentRequest.publisher;
        }
        MutableSharedFlow mutableSharedFlow2 = mutableSharedFlow;
        PaywallOverrides paywallOverrides2 = paywallOverrides;
        return trackAndPresentRequest.copy(str, map, paywallOverrides2, z2, mutableSharedFlow2);
    }

    public final String component1() {
        return this.placement;
    }

    public final Map<String, Object> component2() {
        return this.params;
    }

    public final PaywallOverrides component3() {
        return this.paywallOverrides;
    }

    public final boolean component4() {
        return this.isFeatureGatable;
    }

    public final MutableSharedFlow<PaywallState> component5() {
        return this.publisher;
    }

    public final TrackAndPresentRequest copy(String placement, Map<String, ? extends Object> map, PaywallOverrides paywallOverrides, boolean z2, MutableSharedFlow<PaywallState> publisher) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        Intrinsics.checkNotNullParameter(publisher, "publisher");
        return new TrackAndPresentRequest(placement, map, paywallOverrides, z2, publisher);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrackAndPresentRequest)) {
            return false;
        }
        TrackAndPresentRequest trackAndPresentRequest = (TrackAndPresentRequest) obj;
        return Intrinsics.areEqual(this.placement, trackAndPresentRequest.placement) && Intrinsics.areEqual(this.params, trackAndPresentRequest.params) && Intrinsics.areEqual(this.paywallOverrides, trackAndPresentRequest.paywallOverrides) && this.isFeatureGatable == trackAndPresentRequest.isFeatureGatable && Intrinsics.areEqual(this.publisher, trackAndPresentRequest.publisher);
    }

    public final Map<String, Object> getParams() {
        return this.params;
    }

    public final PaywallOverrides getPaywallOverrides() {
        return this.paywallOverrides;
    }

    public final String getPlacement() {
        return this.placement;
    }

    public final MutableSharedFlow<PaywallState> getPublisher() {
        return this.publisher;
    }

    public int hashCode() {
        int iHashCode = this.placement.hashCode() * 31;
        Map<String, Object> map = this.params;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        PaywallOverrides paywallOverrides = this.paywallOverrides;
        return ((((iHashCode2 + (paywallOverrides != null ? paywallOverrides.hashCode() : 0)) * 31) + Boolean.hashCode(this.isFeatureGatable)) * 31) + this.publisher.hashCode();
    }

    public final boolean isFeatureGatable() {
        return this.isFeatureGatable;
    }

    public String toString() {
        return "TrackAndPresentRequest(placement=" + this.placement + ", params=" + this.params + ", paywallOverrides=" + this.paywallOverrides + ", isFeatureGatable=" + this.isFeatureGatable + ", publisher=" + this.publisher + ")";
    }
}
