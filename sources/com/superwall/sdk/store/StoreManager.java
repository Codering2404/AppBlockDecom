package com.superwall.sdk.store;

import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.analytics.internal.TrackingKt;
import com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent;
import com.superwall.sdk.billing.Billing;
import com.superwall.sdk.billing.DecomposedProductIds;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.models.product.PlayStoreProduct;
import com.superwall.sdk.models.product.ProductItem;
import com.superwall.sdk.network.NetworkError;
import com.superwall.sdk.store.ProductState;
import com.superwall.sdk.store.abstractions.product.StoreProduct;
import com.superwall.sdk.store.abstractions.product.receipt.ReceiptManager;
import com.superwall.sdk.store.coordinator.ProductsFetcher;
import com.superwall.sdk.store.testmode.TestMode;
import com.superwall.sdk.store.testmode.models.SuperwallProductsResponse;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class StoreManager implements ProductsFetcher, StoreKit {
    private final Billing billing;
    private final Function1<Continuation<? super Either<SuperwallProductsResponse, NetworkError>>, Object> getSuperwallProducts;
    private ConcurrentHashMap<String, ProductState> productsByFullId;
    private final InternalPurchaseController purchaseController;
    private final Lazy receiptManager$delegate;
    private String storefrontCountryCode;
    private TestMode testMode;
    private final Function2<InternalSuperwallEvent, Continuation<? super Unit>, Object> track;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: com.superwall.sdk.store.StoreManager$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.StoreManager$1", f = "StoreManager.kt", l = {37}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<InternalSuperwallEvent, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(InternalSuperwallEvent internalSuperwallEvent, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(internalSuperwallEvent, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                InternalSuperwallEvent internalSuperwallEvent = (InternalSuperwallEvent) this.L$0;
                Superwall companion = Superwall.Companion.getInstance();
                this.label = 1;
                if (TrackingKt.track(companion, internalSuperwallEvent, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                ((Result) obj).j();
            }
            return Unit.f139807a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: com.superwall.sdk.store.StoreManager$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.StoreManager$2", f = "StoreManager.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Either.Success<SuperwallProductsResponse, NetworkError>>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return new Either.Success(new SuperwallProductsResponse(CollectionsKt.emptyList()));
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Either.Success<SuperwallProductsResponse, NetworkError>> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class ProductProcessingResult {
        private final Set<String> fullProductIdsToLoad;
        private final List<ProductItem> productItems;
        private final Map<String, StoreProduct> substituteProductsById;

        public ProductProcessingResult(Set<String> fullProductIdsToLoad, Map<String, StoreProduct> substituteProductsById, List<ProductItem> productItems) {
            Intrinsics.checkNotNullParameter(fullProductIdsToLoad, "fullProductIdsToLoad");
            Intrinsics.checkNotNullParameter(substituteProductsById, "substituteProductsById");
            Intrinsics.checkNotNullParameter(productItems, "productItems");
            this.fullProductIdsToLoad = fullProductIdsToLoad;
            this.substituteProductsById = substituteProductsById;
            this.productItems = productItems;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ProductProcessingResult copy$default(ProductProcessingResult productProcessingResult, Set set, Map map, List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                set = productProcessingResult.fullProductIdsToLoad;
            }
            if ((i3 & 2) != 0) {
                map = productProcessingResult.substituteProductsById;
            }
            if ((i3 & 4) != 0) {
                list = productProcessingResult.productItems;
            }
            return productProcessingResult.copy(set, map, list);
        }

        public final Set<String> component1() {
            return this.fullProductIdsToLoad;
        }

        public final Map<String, StoreProduct> component2() {
            return this.substituteProductsById;
        }

        public final List<ProductItem> component3() {
            return this.productItems;
        }

        public final ProductProcessingResult copy(Set<String> fullProductIdsToLoad, Map<String, StoreProduct> substituteProductsById, List<ProductItem> productItems) {
            Intrinsics.checkNotNullParameter(fullProductIdsToLoad, "fullProductIdsToLoad");
            Intrinsics.checkNotNullParameter(substituteProductsById, "substituteProductsById");
            Intrinsics.checkNotNullParameter(productItems, "productItems");
            return new ProductProcessingResult(fullProductIdsToLoad, substituteProductsById, productItems);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ProductProcessingResult)) {
                return false;
            }
            ProductProcessingResult productProcessingResult = (ProductProcessingResult) obj;
            return Intrinsics.areEqual(this.fullProductIdsToLoad, productProcessingResult.fullProductIdsToLoad) && Intrinsics.areEqual(this.substituteProductsById, productProcessingResult.substituteProductsById) && Intrinsics.areEqual(this.productItems, productProcessingResult.productItems);
        }

        public final Set<String> getFullProductIdsToLoad() {
            return this.fullProductIdsToLoad;
        }

        public final List<ProductItem> getProductItems() {
            return this.productItems;
        }

        public final Map<String, StoreProduct> getSubstituteProductsById() {
            return this.substituteProductsById;
        }

        public int hashCode() {
            return (((this.fullProductIdsToLoad.hashCode() * 31) + this.substituteProductsById.hashCode()) * 31) + this.productItems.hashCode();
        }

        public String toString() {
            return "ProductProcessingResult(fullProductIdsToLoad=" + this.fullProductIdsToLoad + ", substituteProductsById=" + this.substituteProductsById + ", productItems=" + this.productItems + ")";
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.StoreManager$fetchAndCacheCustomProducts$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.StoreManager", f = "StoreManager.kt", l = {167}, m = "fetchAndCacheCustomProducts")
    static final class C29191 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C29191(Continuation<? super C29191> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StoreManager.this.fetchAndCacheCustomProducts(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.StoreManager$fetchNewProducts$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.StoreManager", f = "StoreManager.kt", l = {320}, m = "fetchNewProducts")
    static final class C29201 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C29201(Continuation<? super C29201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StoreManager.this.fetchNewProducts(null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.StoreManager$fetchOrAwaitProducts$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.StoreManager", f = "StoreManager.kt", l = {242, 288, RCHTTPStatusCodes.NOT_MODIFIED}, m = "fetchOrAwaitProducts")
    static final class C29211 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C29211(Continuation<? super C29211> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StoreManager.this.fetchOrAwaitProducts(null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.StoreManager$getProductVariables$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.StoreManager", f = "StoreManager.kt", l = {77}, m = "getProductVariables")
    static final class C29221 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C29221(Continuation<? super C29221> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StoreManager.this.getProductVariables(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.StoreManager$getProducts$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.StoreManager", f = "StoreManager.kt", l = {211, 224}, m = "getProducts")
    static final class C29231 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C29231(Continuation<? super C29231> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StoreManager.this.getProducts(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.StoreManager$getProductsWithoutPaywall$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.StoreManager", f = "StoreManager.kt", l = {118, 130}, m = "getProductsWithoutPaywall")
    static final class C29241 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C29241(Continuation<? super C29241> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StoreManager.this.getProductsWithoutPaywall(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.StoreManager$loadStorefrontCountryCode$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.StoreManager", f = "StoreManager.kt", l = {60}, m = "loadStorefrontCountryCode")
    static final class C29251 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C29251(Continuation<? super C29251> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StoreManager.this.loadStorefrontCountryCode(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreManager(InternalPurchaseController purchaseController, Billing billing, Function0<ReceiptManager> receiptManagerFactory, Function2<? super InternalSuperwallEvent, ? super Continuation<? super Unit>, ? extends Object> track, Function1<? super Continuation<? super Either<SuperwallProductsResponse, NetworkError>>, ? extends Object> getSuperwallProducts, TestMode testMode) {
        Intrinsics.checkNotNullParameter(purchaseController, "purchaseController");
        Intrinsics.checkNotNullParameter(billing, "billing");
        Intrinsics.checkNotNullParameter(receiptManagerFactory, "receiptManagerFactory");
        Intrinsics.checkNotNullParameter(track, "track");
        Intrinsics.checkNotNullParameter(getSuperwallProducts, "getSuperwallProducts");
        this.purchaseController = purchaseController;
        this.billing = billing;
        this.track = track;
        this.getSuperwallProducts = getSuperwallProducts;
        this.testMode = testMode;
        this.receiptManager$delegate = LazyKt.b(receiptManagerFactory);
        this.productsByFullId = new ConcurrentHashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013a A[LOOP:3: B:50:0x0134->B:52:0x013a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetchNewProducts(java.util.Map<java.lang.String, ? extends kotlinx.coroutines.CompletableDeferred<com.superwall.sdk.store.abstractions.product.StoreProduct>> r7, kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, com.superwall.sdk.store.abstractions.product.StoreProduct>> r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 347
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.StoreManager.fetchNewProducts(java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01ea A[Catch: all -> 0x01f9, LOOP:0: B:102:0x01e4->B:104:0x01ea, LOOP_END, TRY_LEAVE, TryCatch #3 {all -> 0x01f9, blocks: (B:101:0x01c9, B:102:0x01e4, B:104:0x01ea), top: B:142:0x01c9 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0241 A[LOOP:1: B:127:0x023b->B:129:0x0241, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x010e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetchOrAwaitProducts(java.util.Set<java.lang.String> r18, kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, com.superwall.sdk.store.abstractions.product.StoreProduct>> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 621
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.StoreManager.fetchOrAwaitProducts(java.util.Set, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final ProductProcessingResult removeAndStore(Map<String, StoreProduct> map, List<String> list, List<ProductItem> list2) {
        List mutableList = CollectionsKt.toMutableList((Collection) list);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List mutableList2 = CollectionsKt.toMutableList((Collection) list2);
        if (map != null) {
            for (Map.Entry<String, StoreProduct> entry : map.entrySet()) {
                String key = entry.getKey();
                StoreProduct value = entry.getValue();
                final String fullIdentifier = value.getFullIdentifier();
                linkedHashMap.put(fullIdentifier, value);
                cacheProduct(fullIdentifier, value);
                DecomposedProductIds decomposedProductIdsFrom = DecomposedProductIds.Companion.from(value.getFullIdentifier());
                Iterator it = mutableList2.iterator();
                int i3 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i3 = -1;
                        break;
                    }
                    if (Intrinsics.areEqual(((ProductItem) it.next()).getName(), key)) {
                        break;
                    }
                    i3++;
                }
                Integer numValueOf = Integer.valueOf(i3);
                if (numValueOf.intValue() < 0) {
                    numValueOf = null;
                }
                if (numValueOf != null) {
                    int iIntValue = numValueOf.intValue();
                    String subscriptionId = decomposedProductIdsFrom.getSubscriptionId();
                    String basePlanId = decomposedProductIdsFrom.getBasePlanId();
                    ProductItem.StoreProductType.PlayStore playStore = new ProductItem.StoreProductType.PlayStore(new PlayStoreProduct(null, subscriptionId, basePlanId == null ? "" : basePlanId, decomposedProductIdsFrom.getOfferType().toOffer(), 1, null));
                    mutableList2.set(iIntValue, new ProductItem(playStore.getProduct().getFullIdentifier(), ((ProductItem) mutableList2.get(iIntValue)).getName(), playStore, ((ProductItem) mutableList2.get(iIntValue)).getEntitlements()));
                } else {
                    String subscriptionId2 = decomposedProductIdsFrom.getSubscriptionId();
                    String basePlanId2 = decomposedProductIdsFrom.getBasePlanId();
                    ProductItem.StoreProductType.PlayStore playStore2 = new ProductItem.StoreProductType.PlayStore(new PlayStoreProduct(null, subscriptionId2, basePlanId2 == null ? "" : basePlanId2, decomposedProductIdsFrom.getOfferType().toOffer(), 1, null));
                    mutableList2.add(new ProductItem(playStore2.getProduct().getFullIdentifier(), key, playStore2, SetsKt.emptySet()));
                }
                CollectionsKt.removeAll(mutableList, new Function1() { // from class: com.superwall.sdk.store.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(StoreManager.removeAndStore$lambda$25$lambda$24(fullIdentifier, (String) obj));
                    }
                });
            }
        }
        return new ProductProcessingResult(CollectionsKt.toSet(mutableList), linkedHashMap, mutableList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeAndStore$lambda$25$lambda$24(String str, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it, str);
    }

    @Override // com.superwall.sdk.store.StoreKit
    public void cacheProduct(String fullProductIdentifier, StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(fullProductIdentifier, "fullProductIdentifier");
        Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        ProductState productState = this.productsByFullId.get(fullProductIdentifier);
        this.productsByFullId.put(fullProductIdentifier, new ProductState.Loaded(storeProduct));
        if (productState instanceof ProductState.Loading) {
            ((ProductState.Loading) productState).getDeferred().J(storeProduct);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.superwall.sdk.store.StoreKit
    /* JADX INFO: renamed from: consume-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo1342consumegIAlus(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Result<java.lang.String>> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.superwall.sdk.store.StoreManager$consume$1
            if (r0 == 0) goto L13
            r0 = r6
            com.superwall.sdk.store.StoreManager$consume$1 r0 = (com.superwall.sdk.store.StoreManager$consume$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.store.StoreManager$consume$1 r0 = new com.superwall.sdk.store.StoreManager$consume$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.b(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r5 = r6.j()
            return r5
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.b(r6)
            com.superwall.sdk.billing.Billing r6 = r4.billing
            r0.label = r3
            java.lang.Object r5 = r6.mo1258consumegIAlus(r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.StoreManager.mo1342consumegIAlus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetchAndCacheCustomProducts(java.util.Set<java.lang.String> r13, boolean r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 359
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.StoreManager.fetchAndCacheCustomProducts(java.util.Set, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Billing getBilling() {
        return this.billing;
    }

    @Override // com.superwall.sdk.store.StoreKit
    public StoreProduct getProductFromCache(String productId) {
        StoreProduct storeProduct;
        Intrinsics.checkNotNullParameter(productId, "productId");
        TestMode testMode = this.testMode;
        if (testMode != null && testMode.isTestMode() && (storeProduct = testMode.getTestProductsByFullId$superwall_release().get(productId)) != null) {
            return storeProduct;
        }
        ProductState productState = this.productsByFullId.get(productId);
        ProductState.Loaded loaded = productState instanceof ProductState.Loaded ? (ProductState.Loaded) productState : null;
        if (loaded != null) {
            return loaded.getProduct();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.superwall.sdk.store.StoreKit
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getProductVariables(com.superwall.sdk.models.paywall.Paywall r9, com.superwall.sdk.paywall.request.PaywallRequest r10, kotlin.coroutines.Continuation<? super java.util.List<com.superwall.sdk.models.product.ProductVariable>> r11) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.superwall.sdk.store.StoreManager.C29221
            if (r0 == 0) goto L14
            r0 = r11
            com.superwall.sdk.store.StoreManager$getProductVariables$1 r0 = (com.superwall.sdk.store.StoreManager.C29221) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r5 = r0
            goto L1a
        L14:
            com.superwall.sdk.store.StoreManager$getProductVariables$1 r0 = new com.superwall.sdk.store.StoreManager$getProductVariables$1
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r5.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L3b
            if (r1 != r2) goto L33
            java.lang.Object r9 = r5.L$1
            com.superwall.sdk.models.paywall.Paywall r9 = (com.superwall.sdk.models.paywall.Paywall) r9
            java.lang.Object r10 = r5.L$0
            com.superwall.sdk.store.StoreManager r10 = (com.superwall.sdk.store.StoreManager) r10
            kotlin.ResultKt.b(r11)
            goto L53
        L33:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3b:
            kotlin.ResultKt.b(r11)
            r5.L$0 = r8
            r5.L$1 = r9
            r5.label = r2
            r2 = 0
            r6 = 1
            r7 = 0
            r1 = r8
            r3 = r9
            r4 = r10
            java.lang.Object r11 = com.superwall.sdk.store.StoreKit.DefaultImpls.getProducts$default(r1, r2, r3, r4, r5, r6, r7)
            if (r11 != r0) goto L51
            return r0
        L51:
            r10 = r8
            r9 = r3
        L53:
            com.superwall.sdk.store.GetProductsResponse r11 = (com.superwall.sdk.store.GetProductsResponse) r11
            java.util.List r9 = r9.getProductItems()
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r9 = r9.iterator()
        L64:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto Lb3
            java.lang.Object r1 = r9.next()
            com.superwall.sdk.models.product.ProductItem r1 = (com.superwall.sdk.models.product.ProductItem) r1
            java.util.Map r2 = r11.getProductsByFullId()
            java.lang.String r3 = r1.getFullProductId()
            java.lang.Object r2 = r2.get(r3)
            com.superwall.sdk.store.abstractions.product.StoreProduct r2 = (com.superwall.sdk.store.abstractions.product.StoreProduct) r2
            if (r2 == 0) goto Lac
            com.superwall.sdk.models.product.ProductVariable r3 = new com.superwall.sdk.models.product.ProductVariable
            java.lang.String r1 = r1.getName()
            java.lang.String r4 = r2.getStoreFrontCountryCode()
            if (r4 != 0) goto La4
            java.lang.String r4 = r10.storefrontCountryCode
            if (r4 == 0) goto La4
            java.util.Map r2 = r2.getAttributes()
            java.lang.String r4 = r10.storefrontCountryCode
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            java.lang.String r5 = "storeFrontCountryCode"
            kotlin.Pair r4 = kotlin.TuplesKt.a(r5, r4)
            java.util.Map r2 = kotlin.collections.MapsKt.plus(r2, r4)
            goto La8
        La4:
            java.util.Map r2 = r2.getAttributes()
        La8:
            r3.<init>(r1, r2)
            goto Lad
        Lac:
            r3 = 0
        Lad:
            if (r3 == 0) goto L64
            r0.add(r3)
            goto L64
        Lb3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.StoreManager.getProductVariables(com.superwall.sdk.models.paywall.Paywall, com.superwall.sdk.paywall.request.PaywallRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00af A[Catch: all -> 0x00c5, LOOP:0: B:26:0x00a9->B:28:0x00af, LOOP_END, TRY_LEAVE, TryCatch #1 {all -> 0x00c5, blocks: (B:25:0x009f, B:26:0x00a9, B:28:0x00af), top: B:54:0x009f }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.superwall.sdk.store.StoreKit
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getProducts(java.util.Map<java.lang.String, com.superwall.sdk.store.abstractions.product.StoreProduct> r12, com.superwall.sdk.models.paywall.Paywall r13, com.superwall.sdk.paywall.request.PaywallRequest r14, kotlin.coroutines.Continuation<? super com.superwall.sdk.store.GetProductsResponse> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.StoreManager.getProducts(java.util.Map, com.superwall.sdk.models.paywall.Paywall, com.superwall.sdk.paywall.request.PaywallRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.superwall.sdk.store.StoreKit
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getProductsWithoutPaywall(java.util.List<java.lang.String> r8, java.util.Map<java.lang.String, com.superwall.sdk.store.abstractions.product.StoreProduct> r9, kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, com.superwall.sdk.store.abstractions.product.StoreProduct>> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.StoreManager.getProductsWithoutPaywall(java.util.List, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final InternalPurchaseController getPurchaseController() {
        return this.purchaseController;
    }

    public final ReceiptManager getReceiptManager() {
        return (ReceiptManager) this.receiptManager$delegate.getValue();
    }

    public final String getStorefrontCountryCode() {
        return this.storefrontCountryCode;
    }

    public final TestMode getTestMode() {
        return this.testMode;
    }

    @Override // com.superwall.sdk.store.StoreKit
    public boolean hasCached(String productId) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        TestMode testMode = this.testMode;
        if (testMode != null && testMode.isTestMode() && testMode.getTestProductsByFullId$superwall_release().containsKey(productId)) {
            return true;
        }
        return this.productsByFullId.get(productId) instanceof ProductState.Loaded;
    }

    @Override // com.superwall.sdk.store.StoreKit
    public Object loadPurchasedProducts(Map<String, ? extends Set<Entitlement>> map, Continuation<? super Unit> continuation) {
        Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.storeKitManager, "Loading purchased products from the Google Play receipt.", (Map) null, (Throwable) null, 24, (Object) null);
        Object objLoadPurchasedProducts = getReceiptManager().loadPurchasedProducts(map, continuation);
        return objLoadPurchasedProducts == IntrinsicsKt.f() ? objLoadPurchasedProducts : Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadStorefrontCountryCode(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.superwall.sdk.store.StoreManager.C29251
            if (r0 == 0) goto L13
            r0 = r5
            com.superwall.sdk.store.StoreManager$loadStorefrontCountryCode$1 r0 = (com.superwall.sdk.store.StoreManager.C29251) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.store.StoreManager$loadStorefrontCountryCode$1 r0 = new com.superwall.sdk.store.StoreManager$loadStorefrontCountryCode$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            com.superwall.sdk.store.StoreManager r0 = (com.superwall.sdk.store.StoreManager) r0
            kotlin.ResultKt.b(r5)
            goto L4a
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.ResultKt.b(r5)
            java.lang.String r5 = r4.storefrontCountryCode
            if (r5 != 0) goto L4e
            com.superwall.sdk.billing.Billing r5 = r4.billing
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.getStorefrontCountryCode(r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            r0 = r4
        L4a:
            java.lang.String r5 = (java.lang.String) r5
            r0.storefrontCountryCode = r5
        L4e:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.StoreManager.loadStorefrontCountryCode(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.superwall.sdk.store.coordinator.ProductsFetcher
    public Object products(Set<String> set, Continuation<? super Set<StoreProduct>> continuation) throws Throwable {
        return this.billing.awaitGetProducts(set, continuation);
    }

    @Override // com.superwall.sdk.store.StoreKit
    public void refreshReceipt() {
        Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.storeKitManager, "Refreshing Google Play receipt.", (Map) null, (Throwable) null, 24, (Object) null);
        getReceiptManager().refreshReceipt();
    }

    public final void setTestMode(TestMode testMode) {
        this.testMode = testMode;
    }

    public /* synthetic */ StoreManager(InternalPurchaseController internalPurchaseController, Billing billing, Function0 function0, Function2 function2, Function1 function1, TestMode testMode, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(internalPurchaseController, billing, function0, (i3 & 8) != 0 ? new AnonymousClass1(null) : function2, (i3 & 16) != 0 ? new AnonymousClass2(null) : function1, (i3 & 32) != 0 ? null : testMode);
    }
}
