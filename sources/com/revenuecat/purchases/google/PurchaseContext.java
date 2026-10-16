package com.revenuecat.purchases.google;

import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.models.StoreReplacementMode;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class PurchaseContext {
    private final PresentedOfferingContext presentedOfferingContext;
    private final ProductType productType;
    private final StoreReplacementMode replacementMode;
    private final String selectedSubscriptionOptionId;
    private final Map<String, String> subscriptionOptionIdForProductIDs;

    public PurchaseContext(ProductType productType, PresentedOfferingContext presentedOfferingContext, String str, StoreReplacementMode storeReplacementMode, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        this.productType = productType;
        this.presentedOfferingContext = presentedOfferingContext;
        this.selectedSubscriptionOptionId = str;
        this.replacementMode = storeReplacementMode;
        this.subscriptionOptionIdForProductIDs = map;
    }

    public final PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    public final ProductType getProductType() {
        return this.productType;
    }

    public final StoreReplacementMode getReplacementMode() {
        return this.replacementMode;
    }

    public final String getSelectedSubscriptionOptionId() {
        return this.selectedSubscriptionOptionId;
    }

    public final Map<String, String> getSubscriptionOptionIdForProductIDs() {
        return this.subscriptionOptionIdForProductIDs;
    }
}
