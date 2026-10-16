package com.superwall.sdk.paywall.view;

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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class WebCheckoutSession {
    private final String checkoutId;
    private final int experimentVariantId;
    private final String paywallIdentifier;
    private final String presentedByEventName;
    private final String productIdentifier;
    private final String store;

    public WebCheckoutSession(String checkoutId, String productIdentifier, String paywallIdentifier, int i3, String presentedByEventName, String store) {
        Intrinsics.checkNotNullParameter(checkoutId, "checkoutId");
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(paywallIdentifier, "paywallIdentifier");
        Intrinsics.checkNotNullParameter(presentedByEventName, "presentedByEventName");
        Intrinsics.checkNotNullParameter(store, "store");
        this.checkoutId = checkoutId;
        this.productIdentifier = productIdentifier;
        this.paywallIdentifier = paywallIdentifier;
        this.experimentVariantId = i3;
        this.presentedByEventName = presentedByEventName;
        this.store = store;
    }

    public static /* synthetic */ WebCheckoutSession copy$default(WebCheckoutSession webCheckoutSession, String str, String str2, String str3, int i3, String str4, String str5, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = webCheckoutSession.checkoutId;
        }
        if ((i4 & 2) != 0) {
            str2 = webCheckoutSession.productIdentifier;
        }
        if ((i4 & 4) != 0) {
            str3 = webCheckoutSession.paywallIdentifier;
        }
        if ((i4 & 8) != 0) {
            i3 = webCheckoutSession.experimentVariantId;
        }
        if ((i4 & 16) != 0) {
            str4 = webCheckoutSession.presentedByEventName;
        }
        if ((i4 & 32) != 0) {
            str5 = webCheckoutSession.store;
        }
        String str6 = str4;
        String str7 = str5;
        return webCheckoutSession.copy(str, str2, str3, i3, str6, str7);
    }

    public final String component1() {
        return this.checkoutId;
    }

    public final String component2() {
        return this.productIdentifier;
    }

    public final String component3() {
        return this.paywallIdentifier;
    }

    public final int component4() {
        return this.experimentVariantId;
    }

    public final String component5() {
        return this.presentedByEventName;
    }

    public final String component6() {
        return this.store;
    }

    public final WebCheckoutSession copy(String checkoutId, String productIdentifier, String paywallIdentifier, int i3, String presentedByEventName, String store) {
        Intrinsics.checkNotNullParameter(checkoutId, "checkoutId");
        Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
        Intrinsics.checkNotNullParameter(paywallIdentifier, "paywallIdentifier");
        Intrinsics.checkNotNullParameter(presentedByEventName, "presentedByEventName");
        Intrinsics.checkNotNullParameter(store, "store");
        return new WebCheckoutSession(checkoutId, productIdentifier, paywallIdentifier, i3, presentedByEventName, store);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebCheckoutSession)) {
            return false;
        }
        WebCheckoutSession webCheckoutSession = (WebCheckoutSession) obj;
        return Intrinsics.areEqual(this.checkoutId, webCheckoutSession.checkoutId) && Intrinsics.areEqual(this.productIdentifier, webCheckoutSession.productIdentifier) && Intrinsics.areEqual(this.paywallIdentifier, webCheckoutSession.paywallIdentifier) && this.experimentVariantId == webCheckoutSession.experimentVariantId && Intrinsics.areEqual(this.presentedByEventName, webCheckoutSession.presentedByEventName) && Intrinsics.areEqual(this.store, webCheckoutSession.store);
    }

    public final String getCheckoutId() {
        return this.checkoutId;
    }

    public final int getExperimentVariantId() {
        return this.experimentVariantId;
    }

    public final String getPaywallIdentifier() {
        return this.paywallIdentifier;
    }

    public final String getPresentedByEventName() {
        return this.presentedByEventName;
    }

    public final String getProductIdentifier() {
        return this.productIdentifier;
    }

    public final String getStore() {
        return this.store;
    }

    public int hashCode() {
        return (((((((((this.checkoutId.hashCode() * 31) + this.productIdentifier.hashCode()) * 31) + this.paywallIdentifier.hashCode()) * 31) + Integer.hashCode(this.experimentVariantId)) * 31) + this.presentedByEventName.hashCode()) * 31) + this.store.hashCode();
    }

    public String toString() {
        return "WebCheckoutSession(checkoutId=" + this.checkoutId + ", productIdentifier=" + this.productIdentifier + ", paywallIdentifier=" + this.paywallIdentifier + ", experimentVariantId=" + this.experimentVariantId + ", presentedByEventName=" + this.presentedByEventName + ", store=" + this.store + ")";
    }
}
