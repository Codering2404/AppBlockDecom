package com.superwall.sdk.store;

import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.models.paywall.Paywall;
import com.superwall.sdk.models.product.ProductVariable;
import com.superwall.sdk.paywall.request.PaywallRequest;
import com.superwall.sdk.store.abstractions.product.StoreProduct;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
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
public interface StoreKit {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object getProducts$default(StoreKit storeKit, Map map, Paywall paywall, PaywallRequest paywallRequest, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getProducts");
            }
            if ((i3 & 1) != 0) {
                map = null;
            }
            if ((i3 & 4) != 0) {
                paywallRequest = null;
            }
            return storeKit.getProducts(map, paywall, paywallRequest, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object getProductsWithoutPaywall$default(StoreKit storeKit, List list, Map map, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getProductsWithoutPaywall");
            }
            if ((i3 & 2) != 0) {
                map = null;
            }
            return storeKit.getProductsWithoutPaywall(list, map, continuation);
        }
    }

    void cacheProduct(String str, StoreProduct storeProduct);

    /* JADX INFO: renamed from: consume-gIAlu-s, reason: not valid java name */
    Object mo1342consumegIAlus(String str, Continuation<? super Result<String>> continuation);

    StoreProduct getProductFromCache(String str);

    Object getProductVariables(Paywall paywall, PaywallRequest paywallRequest, Continuation<? super List<ProductVariable>> continuation);

    Object getProducts(Map<String, StoreProduct> map, Paywall paywall, PaywallRequest paywallRequest, Continuation<? super GetProductsResponse> continuation);

    Object getProductsWithoutPaywall(List<String> list, Map<String, StoreProduct> map, Continuation<? super Map<String, StoreProduct>> continuation);

    boolean hasCached(String str);

    Object loadPurchasedProducts(Map<String, ? extends Set<Entitlement>> map, Continuation<? super Unit> continuation);

    void refreshReceipt();
}
