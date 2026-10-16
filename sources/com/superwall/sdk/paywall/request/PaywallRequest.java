package com.superwall.sdk.paywall.request;

import com.superwall.sdk.models.events.EventData;
import com.superwall.sdk.store.abstractions.product.StoreProduct;
import java.util.Map;
import kotlin.Metadata;
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
public final class PaywallRequest {
    private EventData eventData;
    private final boolean isDebuggerLaunched;
    private final Overrides overrides;
    private final String presentationSourceType;
    private final ResponseIdentifiers responseIdentifiers;
    private final int retryCount;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Overrides {
        private final Boolean isFreeTrial;
        private final Map<String, StoreProduct> products;

        public Overrides(Map<String, StoreProduct> map, Boolean bool) {
            this.products = map;
            this.isFreeTrial = bool;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Overrides copy$default(Overrides overrides, Map map, Boolean bool, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                map = overrides.products;
            }
            if ((i3 & 2) != 0) {
                bool = overrides.isFreeTrial;
            }
            return overrides.copy(map, bool);
        }

        public final Map<String, StoreProduct> component1() {
            return this.products;
        }

        public final Boolean component2() {
            return this.isFreeTrial;
        }

        public final Overrides copy(Map<String, StoreProduct> map, Boolean bool) {
            return new Overrides(map, bool);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Overrides)) {
                return false;
            }
            Overrides overrides = (Overrides) obj;
            return Intrinsics.areEqual(this.products, overrides.products) && Intrinsics.areEqual(this.isFreeTrial, overrides.isFreeTrial);
        }

        public final Map<String, StoreProduct> getProducts() {
            return this.products;
        }

        public int hashCode() {
            Map<String, StoreProduct> map = this.products;
            int iHashCode = (map == null ? 0 : map.hashCode()) * 31;
            Boolean bool = this.isFreeTrial;
            return iHashCode + (bool != null ? bool.hashCode() : 0);
        }

        public final Boolean isFreeTrial() {
            return this.isFreeTrial;
        }

        public String toString() {
            return "Overrides(products=" + this.products + ", isFreeTrial=" + this.isFreeTrial + ")";
        }
    }

    public PaywallRequest(EventData eventData, ResponseIdentifiers responseIdentifiers, Overrides overrides, boolean z2, String str, int i3) {
        Intrinsics.checkNotNullParameter(responseIdentifiers, "responseIdentifiers");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.eventData = eventData;
        this.responseIdentifiers = responseIdentifiers;
        this.overrides = overrides;
        this.isDebuggerLaunched = z2;
        this.presentationSourceType = str;
        this.retryCount = i3;
    }

    public static /* synthetic */ PaywallRequest copy$default(PaywallRequest paywallRequest, EventData eventData, ResponseIdentifiers responseIdentifiers, Overrides overrides, boolean z2, String str, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            eventData = paywallRequest.eventData;
        }
        if ((i4 & 2) != 0) {
            responseIdentifiers = paywallRequest.responseIdentifiers;
        }
        if ((i4 & 4) != 0) {
            overrides = paywallRequest.overrides;
        }
        if ((i4 & 8) != 0) {
            z2 = paywallRequest.isDebuggerLaunched;
        }
        if ((i4 & 16) != 0) {
            str = paywallRequest.presentationSourceType;
        }
        if ((i4 & 32) != 0) {
            i3 = paywallRequest.retryCount;
        }
        String str2 = str;
        int i5 = i3;
        return paywallRequest.copy(eventData, responseIdentifiers, overrides, z2, str2, i5);
    }

    public final EventData component1() {
        return this.eventData;
    }

    public final ResponseIdentifiers component2() {
        return this.responseIdentifiers;
    }

    public final Overrides component3() {
        return this.overrides;
    }

    public final boolean component4() {
        return this.isDebuggerLaunched;
    }

    public final String component5() {
        return this.presentationSourceType;
    }

    public final int component6() {
        return this.retryCount;
    }

    public final PaywallRequest copy(EventData eventData, ResponseIdentifiers responseIdentifiers, Overrides overrides, boolean z2, String str, int i3) {
        Intrinsics.checkNotNullParameter(responseIdentifiers, "responseIdentifiers");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        return new PaywallRequest(eventData, responseIdentifiers, overrides, z2, str, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallRequest)) {
            return false;
        }
        PaywallRequest paywallRequest = (PaywallRequest) obj;
        return Intrinsics.areEqual(this.eventData, paywallRequest.eventData) && Intrinsics.areEqual(this.responseIdentifiers, paywallRequest.responseIdentifiers) && Intrinsics.areEqual(this.overrides, paywallRequest.overrides) && this.isDebuggerLaunched == paywallRequest.isDebuggerLaunched && Intrinsics.areEqual(this.presentationSourceType, paywallRequest.presentationSourceType) && this.retryCount == paywallRequest.retryCount;
    }

    public final EventData getEventData() {
        return this.eventData;
    }

    public final Overrides getOverrides() {
        return this.overrides;
    }

    public final String getPresentationSourceType() {
        return this.presentationSourceType;
    }

    public final ResponseIdentifiers getResponseIdentifiers() {
        return this.responseIdentifiers;
    }

    public final int getRetryCount() {
        return this.retryCount;
    }

    public int hashCode() {
        EventData eventData = this.eventData;
        int iHashCode = (((((((eventData == null ? 0 : eventData.hashCode()) * 31) + this.responseIdentifiers.hashCode()) * 31) + this.overrides.hashCode()) * 31) + Boolean.hashCode(this.isDebuggerLaunched)) * 31;
        String str = this.presentationSourceType;
        return ((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + Integer.hashCode(this.retryCount);
    }

    public final boolean isDebuggerLaunched() {
        return this.isDebuggerLaunched;
    }

    public final void setEventData(EventData eventData) {
        this.eventData = eventData;
    }

    public String toString() {
        return "PaywallRequest(eventData=" + this.eventData + ", responseIdentifiers=" + this.responseIdentifiers + ", overrides=" + this.overrides + ", isDebuggerLaunched=" + this.isDebuggerLaunched + ", presentationSourceType=" + this.presentationSourceType + ", retryCount=" + this.retryCount + ")";
    }
}
