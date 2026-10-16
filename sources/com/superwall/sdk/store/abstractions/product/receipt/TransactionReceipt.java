package com.superwall.sdk.store.abstractions.product.receipt;

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
public final class TransactionReceipt {
    private final String originalTransactionId;
    private final String purchaseToken;

    public TransactionReceipt(String originalTransactionId, String purchaseToken) {
        Intrinsics.checkNotNullParameter(originalTransactionId, "originalTransactionId");
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        this.originalTransactionId = originalTransactionId;
        this.purchaseToken = purchaseToken;
    }

    public static /* synthetic */ TransactionReceipt copy$default(TransactionReceipt transactionReceipt, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = transactionReceipt.originalTransactionId;
        }
        if ((i3 & 2) != 0) {
            str2 = transactionReceipt.purchaseToken;
        }
        return transactionReceipt.copy(str, str2);
    }

    public final String component1() {
        return this.originalTransactionId;
    }

    public final String component2() {
        return this.purchaseToken;
    }

    public final TransactionReceipt copy(String originalTransactionId, String purchaseToken) {
        Intrinsics.checkNotNullParameter(originalTransactionId, "originalTransactionId");
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        return new TransactionReceipt(originalTransactionId, purchaseToken);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransactionReceipt)) {
            return false;
        }
        TransactionReceipt transactionReceipt = (TransactionReceipt) obj;
        return Intrinsics.areEqual(this.originalTransactionId, transactionReceipt.originalTransactionId) && Intrinsics.areEqual(this.purchaseToken, transactionReceipt.purchaseToken);
    }

    public final String getOriginalTransactionId() {
        return this.originalTransactionId;
    }

    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    public int hashCode() {
        return (this.originalTransactionId.hashCode() * 31) + this.purchaseToken.hashCode();
    }

    public String toString() {
        return "TransactionReceipt(originalTransactionId=" + this.originalTransactionId + ", purchaseToken=" + this.purchaseToken + ")";
    }
}
