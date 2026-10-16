package com.revenuecat.purchases.google;

import com.android.billingclient.api.QueryProductDetailsParams;
import com.android.billingclient.api.QueryPurchaseHistoryParams;
import com.android.billingclient.api.QueryPurchasesParams;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.common.LogWrapperKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class BillingClientParamBuildersKt {
    public static final QueryProductDetailsParams buildQueryProductDetailsParams(String str, Set<String> productIds) throws QueryProductDetailsParamsBuilderException {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Set<String> set = productIds;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(QueryProductDetailsParams.Product.a().b((String) it.next()).c(str).a());
        }
        try {
            QueryProductDetailsParams queryProductDetailsParamsA = QueryProductDetailsParams.a().b(arrayList).a();
            Intrinsics.checkNotNullExpressionValue(queryProductDetailsParamsA, "{\n        QueryProductDe…roductList).build()\n    }");
            return queryProductDetailsParamsA;
        } catch (ExceptionInInitializerError e3) {
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            StringBuilder sb = new StringBuilder();
            sb.append("Error while building QueryProductDetailsParams in Billing client");
            sb.append(": ");
            sb.append(e3.getMessage());
            sb.append(". Caused by: ");
            Throwable cause = e3.getCause();
            sb.append(cause != null ? cause.getMessage() : null);
            currentLogHandler.e("[Purchases] - ERROR", sb.toString(), e3);
            throw new QueryProductDetailsParamsBuilderException("Error while building QueryProductDetailsParams in Billing client", e3.getCause());
        }
    }

    public static final QueryPurchaseHistoryParams buildQueryPurchaseHistoryParams(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (Intrinsics.areEqual(str, "inapp") ? true : Intrinsics.areEqual(str, "subs")) {
            return QueryPurchaseHistoryParams.a().b(str).a();
        }
        return null;
    }

    public static final QueryPurchasesParams buildQueryPurchasesParams(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (Intrinsics.areEqual(str, "inapp") ? true : Intrinsics.areEqual(str, "subs")) {
            return QueryPurchasesParams.b().b(str).a();
        }
        return null;
    }
}
