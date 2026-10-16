package com.superwall.sdk.store;

import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.Purchase;
import java.util.List;
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
public abstract class PurchasingObserverState {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PurchaseError extends PurchasingObserverState {
        private final Throwable error;
        private final ProductDetails product;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PurchaseError(ProductDetails product, Throwable error) {
            super(null);
            Intrinsics.checkNotNullParameter(product, "product");
            Intrinsics.checkNotNullParameter(error, "error");
            this.product = product;
            this.error = error;
        }

        public final Throwable getError() {
            return this.error;
        }

        public final ProductDetails getProduct() {
            return this.product;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PurchaseResult extends PurchasingObserverState {
        private final List<Purchase> purchases;
        private final BillingResult result;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public PurchaseResult(BillingResult result, List<? extends Purchase> list) {
            super(null);
            Intrinsics.checkNotNullParameter(result, "result");
            this.result = result;
            this.purchases = list;
        }

        public final List<Purchase> getPurchases() {
            return this.purchases;
        }

        public final BillingResult getResult() {
            return this.result;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PurchaseWillBegin extends PurchasingObserverState {
        private final ProductDetails product;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PurchaseWillBegin(ProductDetails product) {
            super(null);
            Intrinsics.checkNotNullParameter(product, "product");
            this.product = product;
        }

        public final ProductDetails getProduct() {
            return this.product;
        }
    }

    public /* synthetic */ PurchasingObserverState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PurchasingObserverState() {
    }
}
