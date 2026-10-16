package com.revenuecat.purchases;

import com.revenuecat.purchases.utils.Result;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
final class CustomerInfoDataResult {
    private final Boolean hadUnsyncedPurchasesBefore;
    private final Result<CustomerInfo, PurchasesError> result;

    public CustomerInfoDataResult(Result<CustomerInfo, PurchasesError> result, Boolean bool) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.result = result;
        this.hadUnsyncedPurchasesBefore = bool;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomerInfoDataResult copy$default(CustomerInfoDataResult customerInfoDataResult, Result result, Boolean bool, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            result = customerInfoDataResult.result;
        }
        if ((i3 & 2) != 0) {
            bool = customerInfoDataResult.hadUnsyncedPurchasesBefore;
        }
        return customerInfoDataResult.copy(result, bool);
    }

    public final Result<CustomerInfo, PurchasesError> component1() {
        return this.result;
    }

    public final Boolean component2() {
        return this.hadUnsyncedPurchasesBefore;
    }

    public final CustomerInfoDataResult copy(Result<CustomerInfo, PurchasesError> result, Boolean bool) {
        Intrinsics.checkNotNullParameter(result, "result");
        return new CustomerInfoDataResult(result, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomerInfoDataResult)) {
            return false;
        }
        CustomerInfoDataResult customerInfoDataResult = (CustomerInfoDataResult) obj;
        return Intrinsics.areEqual(this.result, customerInfoDataResult.result) && Intrinsics.areEqual(this.hadUnsyncedPurchasesBefore, customerInfoDataResult.hadUnsyncedPurchasesBefore);
    }

    public final Boolean getHadUnsyncedPurchasesBefore() {
        return this.hadUnsyncedPurchasesBefore;
    }

    public final Result<CustomerInfo, PurchasesError> getResult() {
        return this.result;
    }

    public int hashCode() {
        int iHashCode = this.result.hashCode() * 31;
        Boolean bool = this.hadUnsyncedPurchasesBefore;
        return iHashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "CustomerInfoDataResult(result=" + this.result + ", hadUnsyncedPurchasesBefore=" + this.hadUnsyncedPurchasesBefore + ')';
    }

    public /* synthetic */ CustomerInfoDataResult(Result result, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(result, (i3 & 2) != 0 ? null : bool);
    }
}
