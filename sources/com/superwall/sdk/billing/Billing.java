package com.superwall.sdk.billing;

import com.android.billingclient.api.Purchase;
import com.superwall.sdk.delegate.InternalPurchaseResult;
import com.superwall.sdk.dependencies.StoreTransactionFactory;
import com.superwall.sdk.store.abstractions.product.StoreProduct;
import com.superwall.sdk.store.abstractions.transactions.StoreTransaction;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.MutableStateFlow;

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
public interface Billing {
    Object awaitGetProducts(Set<String> set, Continuation<? super Set<StoreProduct>> continuation);

    /* JADX INFO: renamed from: consume-gIAlu-s, reason: not valid java name */
    Object mo1258consumegIAlus(String str, Continuation<? super Result<String>> continuation);

    Object getLatestTransaction(StoreTransactionFactory storeTransactionFactory, Continuation<? super StoreTransaction> continuation);

    MutableStateFlow<InternalPurchaseResult> getPurchaseResults();

    Object getStorefrontCountryCode(Continuation<? super String> continuation);

    Object queryAllPurchases(Continuation<? super List<? extends Purchase>> continuation);
}
