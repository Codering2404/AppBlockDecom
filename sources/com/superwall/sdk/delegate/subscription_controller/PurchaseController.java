package com.superwall.sdk.delegate.subscription_controller;

import android.app.Activity;
import com.android.billingclient.api.ProductDetails;
import com.superwall.sdk.delegate.PurchaseResult;
import com.superwall.sdk.delegate.RestorationResult;
import com.superwall.sdk.store.abstractions.product.RawStoreProduct;
import com.superwall.sdk.store.abstractions.product.StoreProduct;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

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
public interface PurchaseController {
    @Deprecated
    Object purchase(Activity activity, ProductDetails productDetails, String str, String str2, Continuation<? super PurchaseResult> continuation);

    Object purchase(Activity activity, StoreProduct storeProduct, String str, String str2, Continuation<? super PurchaseResult> continuation);

    Object restorePurchases(Continuation<? super RestorationResult> continuation);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        @Deprecated
        public static Object purchase(PurchaseController purchaseController, Activity activity, ProductDetails productDetails, String str, String str2, Continuation<? super PurchaseResult> continuation) {
            return new PurchaseResult.Failed("This PurchaseController does not implement a purchase method. Override purchase(activity, product, basePlanId, offerId).");
        }

        public static Object purchase(PurchaseController purchaseController, Activity activity, StoreProduct storeProduct, String str, String str2, Continuation<? super PurchaseResult> continuation) {
            RawStoreProduct rawStoreProduct = storeProduct.getRawStoreProduct();
            if (rawStoreProduct == null) {
                return new PurchaseResult.Failed("This PurchaseController does not handle custom products. Override purchase(activity, product, basePlanId, offerId) and handle products where isCustomProduct == true to purchase " + storeProduct.getFullIdentifier() + ".");
            }
            return purchaseController.purchase(activity, rawStoreProduct.getUnderlyingProductDetails(), str, str2, continuation);
        }
    }
}
