package com.superwall.sdk.billing;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.android.billingclient.api.QueryProductDetailsResult;
import com.revenuecat.purchases.strings.OfferingStrings;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.store.abstractions.product.RawStoreProduct;
import com.superwall.sdk.store.abstractions.product.StoreProduct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class QueryProductDetailsUseCase extends BillingClientUseCase<QueryProductDetailsResult> {
    private final Function1<BillingError, Unit> onError;
    private final Function1<List<StoreProduct>, Unit> onReceive;
    private final QueryProductDetailsUseCaseParams useCaseParams;
    private final Function1<Function1<? super BillingClient, Unit>, Unit> withConnectedClient;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QueryProductDetailsUseCase(QueryProductDetailsUseCaseParams useCaseParams, Function1<? super List<StoreProduct>, Unit> onReceive, Function1<? super BillingError, Unit> onError, Function1<? super Function1<? super BillingClient, Unit>, Unit> withConnectedClient, Function2<? super Long, ? super Function1<? super BillingError, Unit>, Unit> executeRequestOnUIThread) {
        super(useCaseParams, onError, executeRequestOnUIThread);
        Intrinsics.checkNotNullParameter(useCaseParams, "useCaseParams");
        Intrinsics.checkNotNullParameter(onReceive, "onReceive");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(withConnectedClient, "withConnectedClient");
        Intrinsics.checkNotNullParameter(executeRequestOnUIThread, "executeRequestOnUIThread");
        this.useCaseParams = useCaseParams;
        this.onReceive = onReceive;
        this.onError = onError;
        this.withConnectedClient = withConnectedClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit executeAsync$lambda$1(final QueryProductDetailsUseCase queryProductDetailsUseCase, Set set, BillingClient withConnectedClient) {
        Intrinsics.checkNotNullParameter(withConnectedClient, "$this$withConnectedClient");
        queryProductDetailsUseCase.queryProductDetailsAsyncEnsuringOneResponse(withConnectedClient, BillingClientParamBuildersKt.buildQueryProductDetailsParams(queryProductDetailsUseCase.useCaseParams.getProductType(), set), new ProductDetailsResponseListener() { // from class: com.superwall.sdk.billing.t
            @Override // com.android.billingclient.api.ProductDetailsResponseListener
            public final void a(BillingResult billingResult, QueryProductDetailsResult queryProductDetailsResult) {
                BillingClientUseCase.processResult$default(this.f93491a, billingResult, queryProductDetailsResult, null, null, 12, null);
            }
        });
        return Unit.f139807a;
    }

    private final void log(String str) {
        Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.productsManager, str, (Map) null, (Throwable) null, 24, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence onOk$lambda$2(ProductDetails productDetails) {
        String string = productDetails.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final synchronized void queryProductDetailsAsyncEnsuringOneResponse(BillingClient billingClient, QueryProductDetailsParams queryProductDetailsParams, final ProductDetailsResponseListener productDetailsResponseListener) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        billingClient.i(queryProductDetailsParams, new ProductDetailsResponseListener() { // from class: com.superwall.sdk.billing.v
            @Override // com.android.billingclient.api.ProductDetailsResponseListener
            public final void a(BillingResult billingResult, QueryProductDetailsResult queryProductDetailsResult) {
                QueryProductDetailsUseCase.queryProductDetailsAsyncEnsuringOneResponse$lambda$7(atomicBoolean, this, productDetailsResponseListener, billingResult, queryProductDetailsResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryProductDetailsAsyncEnsuringOneResponse$lambda$7(AtomicBoolean atomicBoolean, QueryProductDetailsUseCase queryProductDetailsUseCase, ProductDetailsResponseListener productDetailsResponseListener, BillingResult billingResult, QueryProductDetailsResult productDetailsList) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(productDetailsList, "productDetailsList");
        if (!atomicBoolean.getAndSet(true)) {
            productDetailsResponseListener.a(billingResult, productDetailsList);
            return;
        }
        queryProductDetailsUseCase.log("BillingClient queryProductDetails has returned more than once, with result " + billingResult.c());
    }

    @Override // com.superwall.sdk.billing.BillingClientUseCase
    public void executeAsync() {
        Set<String> subscriptionIds = this.useCaseParams.getSubscriptionIds();
        ArrayList arrayList = new ArrayList();
        for (Object obj : subscriptionIds) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        final Set set = CollectionsKt.toSet(arrayList);
        if (!set.isEmpty()) {
            this.withConnectedClient.invoke(new Function1() { // from class: com.superwall.sdk.billing.s
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return QueryProductDetailsUseCase.executeAsync$lambda$1(this.f93489a, set, (BillingClient) obj2);
                }
            });
        } else {
            log(OfferingStrings.EMPTY_PRODUCT_ID_LIST);
            this.onReceive.invoke(CollectionsKt.emptyList());
        }
    }

    public final Function1<BillingError, Unit> getOnError() {
        return this.onError;
    }

    public final Function1<List<StoreProduct>, Unit> getOnReceive() {
        return this.onReceive;
    }

    public final Function1<Function1<? super BillingClient, Unit>, Unit> getWithConnectedClient() {
        return this.withConnectedClient;
    }

    @Override // com.superwall.sdk.billing.BillingClientUseCase
    public void onOk(QueryProductDetailsResult received) {
        Collection collectionEmptyList;
        Intrinsics.checkNotNullParameter(received, "received");
        List<ProductDetails> listA = received.a();
        Intrinsics.checkNotNullExpressionValue(listA, "getProductDetailsList(...)");
        log("Products request finished for " + CollectionsKt.joinToString$default(this.useCaseParams.getSubscriptionIds(), null, null, null, 0, null, null, 63, null));
        log("Retrieved productDetailsList: " + CollectionsKt.joinToString$default(listA, null, null, null, 0, null, new Function1() { // from class: com.superwall.sdk.billing.u
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return QueryProductDetailsUseCase.onOk$lambda$2((ProductDetails) obj);
            }
        }, 31, null));
        List<ProductDetails> list = !listA.isEmpty() ? listA : null;
        if (list != null) {
            for (ProductDetails productDetails : list) {
                log(productDetails.e() + " - " + productDetails);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (ProductDetails productDetails2 : listA) {
            List<DecomposedProductIds> list2 = this.useCaseParams.getDecomposedProductIdsBySubscriptionId().get(productDetails2.e());
            if (list2 != null) {
                List<DecomposedProductIds> list3 = list2;
                collectionEmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                for (DecomposedProductIds decomposedProductIds : list3) {
                    Intrinsics.checkNotNull(productDetails2);
                    collectionEmptyList.add(new StoreProduct(new RawStoreProduct(productDetails2, decomposedProductIds.getFullId(), decomposedProductIds.getBasePlanType(), decomposedProductIds.getOfferType())));
                }
            } else {
                collectionEmptyList = CollectionsKt.emptyList();
            }
            CollectionsKt.addAll(arrayList, collectionEmptyList);
        }
        this.onReceive.invoke(arrayList);
    }
}
