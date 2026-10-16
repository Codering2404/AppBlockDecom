package com.revenuecat.purchases.amazon.listener;

import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.UserDataResponse;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.models.StoreProduct;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public interface ProductDataResponseListener extends PurchasingListener {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        @Deprecated
        public static void onPurchaseResponse(ProductDataResponseListener productDataResponseListener, PurchaseResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            ProductDataResponseListener.super.onPurchaseResponse(response);
        }

        @Deprecated
        public static void onPurchaseUpdatesResponse(ProductDataResponseListener productDataResponseListener, PurchaseUpdatesResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            ProductDataResponseListener.super.onPurchaseUpdatesResponse(response);
        }

        @Deprecated
        public static void onUserDataResponse(ProductDataResponseListener productDataResponseListener, UserDataResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            ProductDataResponseListener.super.onUserDataResponse(response);
        }
    }

    void getProductData(Set<String> set, String str, Function1<? super List<? extends StoreProduct>, Unit> function1, Function1<? super PurchasesError, Unit> function12);

    default void onPurchaseResponse(PurchaseResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
    }

    default void onPurchaseUpdatesResponse(PurchaseUpdatesResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
    }

    default void onUserDataResponse(UserDataResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
    }
}
