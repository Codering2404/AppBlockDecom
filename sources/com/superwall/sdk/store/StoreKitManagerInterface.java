package com.superwall.sdk.store;

import com.superwall.sdk.delegate.RestorationResult;
import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.models.paywall.Paywall;
import com.superwall.sdk.models.paywall.PaywallProducts;
import com.superwall.sdk.models.product.ProductItem;
import com.superwall.sdk.models.product.ProductVariable;
import com.superwall.sdk.paywall.view.PaywallView;
import com.superwall.sdk.store.abstractions.product.StoreProduct;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
public interface StoreKitManagerInterface {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object getProducts$default(StoreKitManagerInterface storeKitManagerInterface, List list, String str, List list2, PaywallProducts paywallProducts, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getProducts");
            }
            if ((i3 & 2) != 0) {
                str = null;
            }
            if ((i3 & 4) != 0) {
                list2 = CollectionsKt.emptyList();
            }
            if ((i3 & 8) != 0) {
                paywallProducts = null;
            }
            return storeKitManagerInterface.getProducts(list, str, list2, paywallProducts, continuation);
        }

        public static /* synthetic */ Object products$default(StoreKitManagerInterface storeKitManagerInterface, Set set, String str, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: products");
            }
            if ((i3 & 2) != 0) {
                str = null;
            }
            return storeKitManagerInterface.products(set, str, continuation);
        }
    }

    Object getProductVariables(Paywall paywall, Continuation<? super List<ProductVariable>> continuation);

    Object getProducts(List<String> list, String str, List<ProductItem> list2, PaywallProducts paywallProducts, Continuation<? super GetProductsResponse> continuation);

    Map<String, StoreProduct> getProductsById();

    Object isFreeTrialAvailable(StoreProduct storeProduct, Continuation<? super Boolean> continuation);

    Object loadPurchasedProducts(Map<String, ? extends Set<Entitlement>> map, Continuation<? super Unit> continuation);

    Object processRestoration(RestorationResult restorationResult, PaywallView paywallView, Continuation<? super Unit> continuation);

    Object products(Set<String> set, String str, Continuation<? super Set<StoreProduct>> continuation);

    Object refreshReceipt(Continuation<? super Unit> continuation);

    Object tryToRestore(PaywallView paywallView, Continuation<? super Unit> continuation);
}
