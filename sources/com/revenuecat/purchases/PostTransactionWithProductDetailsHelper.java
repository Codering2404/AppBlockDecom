package com.revenuecat.purchases;

import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.GoogleStoreProduct;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class PostTransactionWithProductDetailsHelper {
    private final BillingAbstract billing;
    private final PostReceiptHelper postReceiptHelper;

    public PostTransactionWithProductDetailsHelper(BillingAbstract billing, PostReceiptHelper postReceiptHelper) {
        Intrinsics.checkNotNullParameter(billing, "billing");
        Intrinsics.checkNotNullParameter(postReceiptHelper, "postReceiptHelper");
        this.billing = billing;
        this.postReceiptHelper = postReceiptHelper;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void postTransactions$default(PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper, List list, boolean z2, String str, PostReceiptInitiationSource postReceiptInitiationSource, boolean z3, Function2 function2, Function2 function22, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            function2 = null;
        }
        if ((i3 & 64) != 0) {
            function22 = null;
        }
        postTransactionWithProductDetailsHelper.postTransactions(list, z2, str, postReceiptInitiationSource, z3, function2, function22);
    }

    public final void postTransactions(List<StoreTransaction> transactions, final boolean z2, String str, PostReceiptInitiationSource postReceiptInitiationSource, final boolean z3, final Function2<? super StoreTransaction, ? super CustomerInfo, Unit> function2, final Function2<? super StoreTransaction, ? super PurchasesError, Unit> function22) {
        Intrinsics.checkNotNullParameter(transactions, "transactions");
        final String appUserID = str;
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        final PostReceiptInitiationSource initiationSource = postReceiptInitiationSource;
        Intrinsics.checkNotNullParameter(initiationSource, "initiationSource");
        for (final StoreTransaction storeTransaction : transactions) {
            BillingAbstract billingAbstract = this.billing;
            ProductType type = storeTransaction.getType();
            Set<String> set = CollectionsKt.toSet(storeTransaction.getProductIds());
            Function1<List<? extends StoreProduct>, Unit> function1 = new Function1<List<? extends StoreProduct>, Unit>() { // from class: com.revenuecat.purchases.PostTransactionWithProductDetailsHelper$postTransactions$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((List<? extends StoreProduct>) obj);
                    return Unit.f139807a;
                }

                public final void invoke(List<? extends StoreProduct> storeProducts) {
                    Object next;
                    StoreProduct storeProduct;
                    Collection collectionEmptyList;
                    Object next2;
                    Intrinsics.checkNotNullParameter(storeProducts, "storeProducts");
                    Map<String, ? extends SubscriptionOption> mapBuild = null;
                    if (storeTransaction.getType() == ProductType.SUBS && storeTransaction.getMarketplace() == null) {
                        StoreTransaction storeTransaction2 = storeTransaction;
                        Iterator<T> it = storeProducts.iterator();
                        loop0: while (true) {
                            if (!it.hasNext()) {
                                next2 = null;
                                break;
                            }
                            next2 = it.next();
                            SubscriptionOptions subscriptionOptions = ((StoreProduct) next2).getSubscriptionOptions();
                            if (subscriptionOptions != null && !subscriptionOptions.isEmpty()) {
                                Iterator<SubscriptionOption> it2 = subscriptionOptions.iterator();
                                while (it2.hasNext()) {
                                    if (Intrinsics.areEqual(it2.next().getId(), storeTransaction2.getSubscriptionOptionId())) {
                                        break loop0;
                                    }
                                }
                            }
                        }
                        storeProduct = (StoreProduct) next2;
                    } else {
                        StoreTransaction storeTransaction3 = storeTransaction;
                        Iterator<T> it3 = storeProducts.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                next = it3.next();
                                if (Intrinsics.areEqual(((StoreProduct) next).getId(), CollectionsKt.firstOrNull((List) storeTransaction3.getProductIds()))) {
                                    break;
                                }
                            } else {
                                next = null;
                                break;
                            }
                        }
                        storeProduct = (StoreProduct) next;
                    }
                    StoreProduct storeProduct2 = storeProduct;
                    Map subscriptionOptionIdForProductIDs = storeTransaction.getSubscriptionOptionIdForProductIDs();
                    if (subscriptionOptionIdForProductIDs != null) {
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : storeProducts) {
                            if (obj instanceof GoogleStoreProduct) {
                                arrayList.add(obj);
                            }
                        }
                        ArrayList arrayList2 = new ArrayList();
                        int size = arrayList.size();
                        int i3 = 0;
                        while (i3 < size) {
                            Object obj2 = arrayList.get(i3);
                            i3++;
                            GoogleStoreProduct googleStoreProduct = (GoogleStoreProduct) obj2;
                            SubscriptionOptions subscriptionOptions2 = googleStoreProduct.getSubscriptionOptions();
                            if (subscriptionOptions2 != null) {
                                collectionEmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(subscriptionOptions2, 10));
                                for (SubscriptionOption subscriptionOption : subscriptionOptions2) {
                                    collectionEmptyList.add(TuplesKt.a(googleStoreProduct.getProductId() + '_' + subscriptionOption.getId(), subscriptionOption));
                                }
                            } else {
                                collectionEmptyList = CollectionsKt.emptyList();
                            }
                            CollectionsKt.addAll(arrayList2, collectionEmptyList);
                        }
                        Map map = MapsKt.toMap(arrayList2);
                        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
                        for (Map.Entry entry : subscriptionOptionIdForProductIDs.entrySet()) {
                            String str2 = (String) entry.getKey();
                            SubscriptionOption subscriptionOption2 = (SubscriptionOption) map.get(str2 + '_' + ((String) entry.getValue()));
                            if (subscriptionOption2 != null) {
                                mapCreateMapBuilder.put(str2, subscriptionOption2);
                            }
                        }
                        mapBuild = MapsKt.build(mapCreateMapBuilder);
                    }
                    Map<String, ? extends SubscriptionOption> map2 = mapBuild;
                    LogLevel logLevel = LogLevel.DEBUG;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.d("[Purchases] - " + logLevel.name(), "Store product found for transaction: " + storeProduct2);
                    }
                    this.postReceiptHelper.postTransactionAndConsumeIfNeeded(storeTransaction, storeProduct2, map2, z2, appUserID, initiationSource, z3, function2, function22);
                }
            };
            appUserID = str;
            initiationSource = postReceiptInitiationSource;
            billingAbstract.queryProductDetailsAsync(type, set, function1, new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.PostTransactionWithProductDetailsHelper$postTransactions$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((PurchasesError) obj);
                    return Unit.f139807a;
                }

                public final void invoke(PurchasesError it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    this.this$0.postReceiptHelper.postTransactionAndConsumeIfNeeded(storeTransaction, null, null, z2, appUserID, initiationSource, z3, function2, function22);
                }
            });
        }
    }
}
