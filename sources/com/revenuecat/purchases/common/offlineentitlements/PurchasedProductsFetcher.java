package com.revenuecat.purchases.common.offlineentitlements;

import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.offlineentitlements.ProductEntitlementMapping;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.OfflineEntitlementsStrings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class PurchasedProductsFetcher {
    private final BillingAbstract billing;
    private final DateProvider dateProvider;
    private final DeviceCache deviceCache;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProductType.values().length];
            try {
                iArr[ProductType.SUBS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PurchasedProductsFetcher(DeviceCache deviceCache, BillingAbstract billing, DateProvider dateProvider) {
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(billing, "billing");
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.deviceCache = deviceCache;
        this.billing = billing;
        this.dateProvider = dateProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<PurchasedProduct> createPurchasedProducts(StoreTransaction storeTransaction, ProductEntitlementMapping productEntitlementMapping) {
        List<String> listEmptyList;
        Date expirationDate = getExpirationDate(storeTransaction);
        List<String> productIds = storeTransaction.getProductIds();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(productIds, 10));
        for (String str : productIds) {
            ProductEntitlementMapping.Mapping mapping = productEntitlementMapping.getMappings().get(str);
            String basePlanId = mapping != null ? mapping.getBasePlanId() : null;
            if (mapping == null || (listEmptyList = mapping.getEntitlements()) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            List<String> list = listEmptyList;
            String str2 = basePlanId;
            StoreTransaction storeTransaction2 = storeTransaction;
            arrayList.add(new PurchasedProduct(str, str2, storeTransaction2, list, expirationDate));
            storeTransaction = storeTransaction2;
        }
        return arrayList;
    }

    private final Date getExpirationDate(StoreTransaction storeTransaction) {
        if (WhenMappings.$EnumSwitchMapping$0[storeTransaction.getType().ordinal()] == 1) {
            return new Date(this.dateProvider.getNow().getTime() + TimeUnit.DAYS.toMillis(1L));
        }
        return null;
    }

    public final void queryActiveProducts(String appUserID, final Function1<? super List<PurchasedProduct>, Unit> onSuccess, Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        final ProductEntitlementMapping productEntitlementMapping$purchases_defaultsBc8Release = this.deviceCache.getProductEntitlementMapping$purchases_defaultsBc8Release();
        if (productEntitlementMapping$purchases_defaultsBc8Release == null) {
            onError.invoke(new PurchasesError(PurchasesErrorCode.CustomerInfoError, OfflineEntitlementsStrings.PRODUCT_ENTITLEMENT_MAPPING_REQUIRED));
        } else {
            this.billing.queryPurchases(appUserID, new Function1<Map<String, ? extends StoreTransaction>, Unit>() { // from class: com.revenuecat.purchases.common.offlineentitlements.PurchasedProductsFetcher.queryActiveProducts.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Map<String, StoreTransaction>) obj);
                    return Unit.f139807a;
                }

                public final void invoke(Map<String, StoreTransaction> activePurchasesByHashedToken) {
                    Intrinsics.checkNotNullParameter(activePurchasesByHashedToken, "activePurchasesByHashedToken");
                    Collection<StoreTransaction> collectionValues = activePurchasesByHashedToken.values();
                    PurchasedProductsFetcher purchasedProductsFetcher = this;
                    ProductEntitlementMapping productEntitlementMapping = productEntitlementMapping$purchases_defaultsBc8Release;
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it = collectionValues.iterator();
                    while (it.hasNext()) {
                        CollectionsKt.addAll(arrayList, purchasedProductsFetcher.createPurchasedProducts((StoreTransaction) it.next(), productEntitlementMapping));
                    }
                    onSuccess.invoke(arrayList);
                }
            }, onError);
        }
    }

    public /* synthetic */ PurchasedProductsFetcher(DeviceCache deviceCache, BillingAbstract billingAbstract, DateProvider dateProvider, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(deviceCache, billingAbstract, (i3 & 4) != 0 ? new DefaultDateProvider() : dateProvider);
    }
}
