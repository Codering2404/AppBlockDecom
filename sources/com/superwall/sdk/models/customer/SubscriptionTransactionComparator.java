package com.superwall.sdk.models.customer;

import java.util.Comparator;
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
final class SubscriptionTransactionComparator implements Comparator<SubscriptionTransaction> {
    public static final SubscriptionTransactionComparator INSTANCE = new SubscriptionTransactionComparator();

    private SubscriptionTransactionComparator() {
    }

    @Override // java.util.Comparator
    public int compare(SubscriptionTransaction a3, SubscriptionTransaction b3) {
        Intrinsics.checkNotNullParameter(a3, "a");
        Intrinsics.checkNotNullParameter(b3, "b");
        return a3.isActive() != b3.isActive() ? a3.isActive() ? 1 : -1 : a3.isRevoked() != b3.isRevoked() ? a3.isRevoked() ? -1 : 1 : a3.getWillRenew() != b3.getWillRenew() ? a3.getWillRenew() ? 1 : -1 : a3.isInGracePeriod() != b3.isInGracePeriod() ? a3.isInGracePeriod() ? 1 : -1 : a3.getPurchaseDate().compareTo(b3.getPurchaseDate());
    }
}
