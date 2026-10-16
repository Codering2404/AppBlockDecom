package com.revenuecat.purchases;

import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
import com.revenuecat.purchases.interfaces.GetStoreProductsCallback;
import com.revenuecat.purchases.interfaces.GetStorefrontCallback;
import com.revenuecat.purchases.interfaces.PurchaseCallback;
import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback;
import com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class ListenerConversionsCommonKt {
    private static final Function1<PurchasesError, Unit> ON_ERROR_STUB = new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.ListenerConversionsCommonKt$ON_ERROR_STUB$1
        public final void invoke(PurchasesError it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PurchasesError) obj);
            return Unit.f139807a;
        }
    };
    private static final Function2<PurchasesError, Boolean, Unit> ON_PURCHASE_ERROR_STUB = new Function2<PurchasesError, Boolean, Unit>() { // from class: com.revenuecat.purchases.ListenerConversionsCommonKt$ON_PURCHASE_ERROR_STUB$1
        public final void invoke(PurchasesError purchasesError, boolean z2) {
            Intrinsics.checkNotNullParameter(purchasesError, "<anonymous parameter 0>");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((PurchasesError) obj, ((Boolean) obj2).booleanValue());
            return Unit.f139807a;
        }
    };

    public static final Function1<PurchasesError, Unit> getON_ERROR_STUB() {
        return ON_ERROR_STUB;
    }

    public static final Function2<PurchasesError, Boolean, Unit> getON_PURCHASE_ERROR_STUB() {
        return ON_PURCHASE_ERROR_STUB;
    }

    public static final void getOfferingsWith(Purchases purchases, Function1<? super PurchasesError, Unit> onError, Function1<? super Offerings, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.getOfferings(receiveOfferingsCallback(onSuccess, onError));
    }

    public static /* synthetic */ void getOfferingsWith$default(Purchases purchases, Function1 function1, Function1 function12, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = ON_ERROR_STUB;
        }
        getOfferingsWith(purchases, function1, function12);
    }

    public static final void getProductsWith(Purchases purchases, List<String> productIds, Function1<? super PurchasesError, Unit> onError, Function1<? super List<? extends StoreProduct>, Unit> onGetStoreProducts) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onGetStoreProducts, "onGetStoreProducts");
        purchases.getProducts(productIds, getStoreProductsCallback(onGetStoreProducts, onError));
    }

    public static /* synthetic */ void getProductsWith$default(Purchases purchases, List list, Function1 function1, Function1 function12, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = ON_ERROR_STUB;
        }
        getProductsWith(purchases, list, function1, function12);
    }

    public static final GetStoreProductsCallback getStoreProductsCallback(final Function1<? super List<? extends StoreProduct>, Unit> onReceived, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onReceived, "onReceived");
        Intrinsics.checkNotNullParameter(onError, "onError");
        return new GetStoreProductsCallback() { // from class: com.revenuecat.purchases.ListenerConversionsCommonKt.getStoreProductsCallback.1
            @Override // com.revenuecat.purchases.interfaces.GetStoreProductsCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.GetStoreProductsCallback
            public void onReceived(List<? extends StoreProduct> storeProducts) {
                Intrinsics.checkNotNullParameter(storeProducts, "storeProducts");
                onReceived.invoke(storeProducts);
            }
        };
    }

    public static final void getStorefrontCountryCodeWith(Purchases purchases, final Function1<? super PurchasesError, Unit> onError, final Function1<? super String, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.getStorefrontCountryCode(new GetStorefrontCallback() { // from class: com.revenuecat.purchases.ListenerConversionsCommonKt.getStorefrontCountryCodeWith.1
            @Override // com.revenuecat.purchases.interfaces.GetStorefrontCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.GetStorefrontCallback
            public void onReceived(String storefrontCountryCode) {
                Intrinsics.checkNotNullParameter(storefrontCountryCode, "storefrontCountryCode");
                onSuccess.invoke(storefrontCountryCode);
            }
        });
    }

    public static /* synthetic */ void getStorefrontCountryCodeWith$default(Purchases purchases, Function1 function1, Function1 function12, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = ON_ERROR_STUB;
        }
        getStorefrontCountryCodeWith(purchases, function1, function12);
    }

    public static final PurchaseCallback purchaseCompletedCallback(final Function2<? super StoreTransaction, ? super CustomerInfo, Unit> onSuccess, final Function2<? super PurchasesError, ? super Boolean, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        return new PurchaseCallback() { // from class: com.revenuecat.purchases.ListenerConversionsCommonKt.purchaseCompletedCallback.1
            @Override // com.revenuecat.purchases.interfaces.PurchaseCallback
            public void onCompleted(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                onSuccess.invoke(storeTransaction, customerInfo);
            }

            @Override // com.revenuecat.purchases.interfaces.PurchaseErrorCallback
            public void onError(PurchasesError error, boolean z2) {
                Intrinsics.checkNotNullParameter(error, "error");
                onError.invoke(error, Boolean.valueOf(z2));
            }
        };
    }

    public static final void purchaseWith(Purchases purchases, PurchaseParams purchaseParams, Function2<? super PurchasesError, ? super Boolean, Unit> onError, Function2<? super StoreTransaction, ? super CustomerInfo, Unit> onSuccess) throws PurchasesException {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(purchaseParams, "purchaseParams");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.purchase(purchaseParams, purchaseCompletedCallback(onSuccess, onError));
    }

    public static /* synthetic */ void purchaseWith$default(Purchases purchases, PurchaseParams purchaseParams, Function2 function2, Function2 function22, int i3, Object obj) throws PurchasesException {
        if ((i3 & 2) != 0) {
            function2 = ON_PURCHASE_ERROR_STUB;
        }
        purchaseWith(purchases, purchaseParams, function2, function22);
    }

    public static final ReceiveCustomerInfoCallback receiveCustomerInfoCallback(final Function1<? super CustomerInfo, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        return new ReceiveCustomerInfoCallback() { // from class: com.revenuecat.purchases.ListenerConversionsCommonKt.receiveCustomerInfoCallback.1
            @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                Function1<PurchasesError, Unit> function1 = onError;
                if (function1 != null) {
                }
            }

            @Override // com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
            public void onReceived(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                Function1<CustomerInfo, Unit> function1 = onSuccess;
                if (function1 != null) {
                }
            }
        };
    }

    public static final ReceiveOfferingsCallback receiveOfferingsCallback(final Function1<? super Offerings, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        return new ReceiveOfferingsCallback() { // from class: com.revenuecat.purchases.ListenerConversionsCommonKt.receiveOfferingsCallback.1
            @Override // com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.ReceiveOfferingsCallback
            public void onReceived(Offerings offerings) {
                Intrinsics.checkNotNullParameter(offerings, "offerings");
                onSuccess.invoke(offerings);
            }
        };
    }

    public static final void restorePurchasesWith(Purchases purchases, Function1<? super PurchasesError, Unit> onError, Function1<? super CustomerInfo, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.restorePurchases(receiveCustomerInfoCallback(onSuccess, onError));
    }

    public static /* synthetic */ void restorePurchasesWith$default(Purchases purchases, Function1 function1, Function1 function12, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = ON_ERROR_STUB;
        }
        restorePurchasesWith(purchases, function1, function12);
    }

    public static final void getProductsWith(Purchases purchases, List<String> productIds, ProductType productType, Function1<? super PurchasesError, Unit> function1, Function1<? super List<? extends StoreProduct>, Unit> onGetStoreProducts) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(productIds, "productIds");
        Intrinsics.checkNotNullParameter(function1, sKeKFMqmvNzY.HLZ);
        Intrinsics.checkNotNullParameter(onGetStoreProducts, "onGetStoreProducts");
        purchases.getProducts(productIds, productType, getStoreProductsCallback(onGetStoreProducts, function1));
    }

    public static /* synthetic */ void getProductsWith$default(Purchases purchases, List list, ProductType productType, Function1 function1, Function1 function12, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function1 = ON_ERROR_STUB;
        }
        getProductsWith(purchases, list, productType, function1, function12);
    }
}
