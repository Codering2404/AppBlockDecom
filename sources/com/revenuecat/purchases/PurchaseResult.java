package com.revenuecat.purchases;

import com.revenuecat.purchases.models.StoreTransaction;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class PurchaseResult {
    private final CustomerInfo customerInfo;
    private final StoreTransaction storeTransaction;

    public PurchaseResult(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        this.storeTransaction = storeTransaction;
        this.customerInfo = customerInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PurchaseResult)) {
            return false;
        }
        PurchaseResult purchaseResult = (PurchaseResult) obj;
        return Intrinsics.areEqual(this.storeTransaction, purchaseResult.storeTransaction) && Intrinsics.areEqual(this.customerInfo, purchaseResult.customerInfo);
    }

    public final CustomerInfo getCustomerInfo() {
        return this.customerInfo;
    }

    public final StoreTransaction getStoreTransaction() {
        return this.storeTransaction;
    }

    public int hashCode() {
        return (this.storeTransaction.hashCode() * 31) + this.customerInfo.hashCode();
    }

    public String toString() {
        return "PurchaseResult(storeTransaction=" + this.storeTransaction + ", customerInfo=" + this.customerInfo + ')';
    }
}
