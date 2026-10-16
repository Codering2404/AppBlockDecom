package com.superwall.sdk.billing;

import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.superwall.sdk.delegate.InternalPurchaseResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
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
public final class GoogleBillingWrapperKt {
    public static final long RECONNECT_TIMER_MAX_TIME_MILLISECONDS = 16000;
    public static final long RECONNECT_TIMER_START_MILLISECONDS = 1000;

    public static final List<InternalPurchaseResult> toInternalResult(Pair<BillingResult, ? extends List<? extends Purchase>> pair) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        BillingResult billingResult = (BillingResult) pair.a();
        List list = (List) pair.b();
        if (billingResult.c() != 0 || list == null) {
            return billingResult.c() == 1 ? CollectionsKt.listOf(InternalPurchaseResult.Cancelled.INSTANCE) : CollectionsKt.listOf(new InternalPurchaseResult.Failed(new Exception(String.valueOf(billingResult.c()))));
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new InternalPurchaseResult.Purchased((Purchase) it.next()));
        }
        return arrayList;
    }
}
