package com.revenuecat.purchases;

import android.app.Activity;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.interfaces.GetAmazonLWAConsentStatusCallback;
import com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback;
import com.revenuecat.purchases.interfaces.GetStorefrontLocaleCallback;
import com.revenuecat.purchases.interfaces.GetVirtualCurrenciesCallback;
import com.revenuecat.purchases.interfaces.LogInCallback;
import com.revenuecat.purchases.interfaces.ProductChangeCallback;
import com.revenuecat.purchases.interfaces.SyncAttributesAndOfferingsCallback;
import com.revenuecat.purchases.interfaces.SyncPurchasesCallback;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import java.util.List;
import java.util.Locale;
import kotlin.Deprecated;
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
public final class ListenerConversionsKt {
    public static final GetAmazonLWAConsentStatusCallback getAmazonLWAConsentStatusListener(final Function1<? super AmazonLWAConsentStatus, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        return new GetAmazonLWAConsentStatusCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.getAmazonLWAConsentStatusListener.1
            @Override // com.revenuecat.purchases.interfaces.GetAmazonLWAConsentStatusCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.GetAmazonLWAConsentStatusCallback
            public void onSuccess(AmazonLWAConsentStatus consentStatus) {
                Intrinsics.checkNotNullParameter(consentStatus, "consentStatus");
                onSuccess.invoke(consentStatus);
            }
        };
    }

    public static final void getAmazonLWAConsentStatusWith(Purchases purchases, Function1<? super PurchasesError, Unit> onError, Function1<? super AmazonLWAConsentStatus, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.getAmazonLWAConsentStatus(getAmazonLWAConsentStatusListener(onSuccess, onError));
    }

    public static /* synthetic */ void getAmazonLWAConsentStatusWith$default(Purchases purchases, Function1 function1, Function1 function12, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        getAmazonLWAConsentStatusWith(purchases, function1, function12);
    }

    public static final GetCustomerCenterConfigCallback getCustomerCenterConfigDataListener(final Function1<? super CustomerCenterConfigData, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        return new GetCustomerCenterConfigCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.getCustomerCenterConfigDataListener.1
            @Override // com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.GetCustomerCenterConfigCallback
            public void onSuccess(CustomerCenterConfigData customerCenterConfig) {
                Intrinsics.checkNotNullParameter(customerCenterConfig, "customerCenterConfig");
                onSuccess.invoke(customerCenterConfig);
            }
        };
    }

    public static final void getCustomerInfoWith(Purchases purchases, Function1<? super PurchasesError, Unit> onError, Function1<? super CustomerInfo, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.getCustomerInfo(ListenerConversionsCommonKt.receiveCustomerInfoCallback(onSuccess, onError));
    }

    public static /* synthetic */ void getCustomerInfoWith$default(Purchases purchases, Function1 function1, Function1 function12, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        getCustomerInfoWith(purchases, function1, function12);
    }

    @Deprecated
    public static final void getNonSubscriptionSkusWith(Purchases purchases, List<String> skus, Function1<? super PurchasesError, Unit> onError, Function1<? super List<? extends StoreProduct>, Unit> onReceiveSkus) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(skus, "skus");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onReceiveSkus, "onReceiveSkus");
        purchases.getProducts(skus, ProductType.INAPP, ListenerConversionsCommonKt.getStoreProductsCallback(onReceiveSkus, onError));
    }

    public static final void getStorefrontLocaleWith(Purchases purchases, final Function1<? super PurchasesError, Unit> onError, final Function1<? super Locale, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.getStorefrontLocale(new GetStorefrontLocaleCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.getStorefrontLocaleWith.1
            @Override // com.revenuecat.purchases.interfaces.GetStorefrontLocaleCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.GetStorefrontLocaleCallback
            public void onReceived(Locale storefrontLocale) {
                Intrinsics.checkNotNullParameter(storefrontLocale, "storefrontLocale");
                onSuccess.invoke(storefrontLocale);
            }
        });
    }

    public static /* synthetic */ void getStorefrontLocaleWith$default(Purchases purchases, Function1 function1, Function1 function12, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        getStorefrontLocaleWith(purchases, function1, function12);
    }

    @Deprecated
    public static final void getSubscriptionSkusWith(Purchases purchases, List<String> skus, Function1<? super PurchasesError, Unit> onError, Function1<? super List<? extends StoreProduct>, Unit> onReceiveSkus) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(skus, "skus");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onReceiveSkus, "onReceiveSkus");
        purchases.getProducts(skus, ProductType.SUBS, ListenerConversionsCommonKt.getStoreProductsCallback(onReceiveSkus, onError));
    }

    public static /* synthetic */ void getSubscriptionSkusWith$default(Purchases purchases, List list, Function1 function1, Function1 function12, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        getSubscriptionSkusWith(purchases, list, function1, function12);
    }

    public static final GetVirtualCurrenciesCallback getVirtualCurrenciesCallback(final Function1<? super VirtualCurrencies, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        return new GetVirtualCurrenciesCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.getVirtualCurrenciesCallback.1
            @Override // com.revenuecat.purchases.interfaces.GetVirtualCurrenciesCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.GetVirtualCurrenciesCallback
            public void onReceived(VirtualCurrencies virtualCurrencies) {
                Intrinsics.checkNotNullParameter(virtualCurrencies, "virtualCurrencies");
                onSuccess.invoke(virtualCurrencies);
            }
        };
    }

    public static final void getVirtualCurrenciesWith(Purchases purchases, Function1<? super PurchasesError, Unit> onError, Function1<? super VirtualCurrencies, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.getVirtualCurrencies(getVirtualCurrenciesCallback(onSuccess, onError));
    }

    public static /* synthetic */ void getVirtualCurrenciesWith$default(Purchases purchases, Function1 function1, Function1 function12, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        getVirtualCurrenciesWith(purchases, function1, function12);
    }

    public static final LogInCallback logInSuccessListener(final Function2<? super CustomerInfo, ? super Boolean, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        return new LogInCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.logInSuccessListener.1
            @Override // com.revenuecat.purchases.interfaces.LogInCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                Function1<PurchasesError, Unit> function1 = onError;
                if (function1 != null) {
                }
            }

            @Override // com.revenuecat.purchases.interfaces.LogInCallback
            public void onReceived(CustomerInfo customerInfo, boolean z2) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                Function2<CustomerInfo, Boolean, Unit> function2 = onSuccess;
                if (function2 != null) {
                }
            }
        };
    }

    public static final void logInWith(Purchases purchases, String appUserID, Function1<? super PurchasesError, Unit> onError, Function2<? super CustomerInfo, ? super Boolean, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.logIn(appUserID, logInSuccessListener(onSuccess, onError));
    }

    public static /* synthetic */ void logInWith$default(Purchases purchases, String str, Function1 function1, Function2 function2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        logInWith(purchases, str, function1, function2);
    }

    public static final void logOutWith(Purchases purchases, Function1<? super PurchasesError, Unit> onError, Function1<? super CustomerInfo, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.logOut(ListenerConversionsCommonKt.receiveCustomerInfoCallback(onSuccess, onError));
    }

    public static /* synthetic */ void logOutWith$default(Purchases purchases, Function1 function1, Function1 function12, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        logOutWith(purchases, function1, function12);
    }

    public static final ProductChangeCallback productChangeCompletedListener(final Function2<? super StoreTransaction, ? super CustomerInfo, Unit> onSuccess, final Function2<? super PurchasesError, ? super Boolean, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        return new ProductChangeCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.productChangeCompletedListener.1
            @Override // com.revenuecat.purchases.interfaces.ProductChangeCallback
            public void onCompleted(StoreTransaction storeTransaction, CustomerInfo customerInfo) {
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

    @Deprecated
    public static final void purchasePackageWith(Purchases purchases, Activity activity, Package packageToPurchase, Function2<? super PurchasesError, ? super Boolean, Unit> onError, Function2<? super StoreTransaction, ? super CustomerInfo, Unit> onSuccess) throws PurchasesException {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(packageToPurchase, "packageToPurchase");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.purchasePackage(activity, packageToPurchase, ListenerConversionsCommonKt.purchaseCompletedCallback(onSuccess, onError));
    }

    public static /* synthetic */ void purchasePackageWith$default(Purchases purchases, Activity activity, Package r2, Function2 function2, Function2 function22, int i3, Object obj) throws PurchasesException {
        if ((i3 & 4) != 0) {
            function2 = ListenerConversionsCommonKt.getON_PURCHASE_ERROR_STUB();
        }
        purchasePackageWith(purchases, activity, r2, function2, function22);
    }

    @Deprecated
    public static final void purchaseProductWith(Purchases purchases, Activity activity, StoreProduct storeProduct, Function2<? super PurchasesError, ? super Boolean, Unit> onError, Function2<? super StoreTransaction, ? super CustomerInfo, Unit> onSuccess) throws PurchasesException {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.purchaseProduct(activity, storeProduct, ListenerConversionsCommonKt.purchaseCompletedCallback(onSuccess, onError));
    }

    public static /* synthetic */ void purchaseProductWith$default(Purchases purchases, Activity activity, StoreProduct storeProduct, Function2 function2, Function2 function22, int i3, Object obj) throws PurchasesException {
        if ((i3 & 4) != 0) {
            function2 = ListenerConversionsCommonKt.getON_PURCHASE_ERROR_STUB();
        }
        purchaseProductWith(purchases, activity, storeProduct, function2, function22);
    }

    public static final void syncAttributesAndOfferingsIfNeededWith(Purchases purchases, Function1<? super PurchasesError, Unit> onError, Function1<? super Offerings, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.syncAttributesAndOfferingsIfNeeded(syncAttributesAndOfferingsListener(onSuccess, onError));
    }

    public static /* synthetic */ void syncAttributesAndOfferingsIfNeededWith$default(Purchases purchases, Function1 function1, Function1 function12, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        syncAttributesAndOfferingsIfNeededWith(purchases, function1, function12);
    }

    public static final SyncAttributesAndOfferingsCallback syncAttributesAndOfferingsListener(final Function1<? super Offerings, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        return new SyncAttributesAndOfferingsCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.syncAttributesAndOfferingsListener.1
            @Override // com.revenuecat.purchases.interfaces.SyncAttributesAndOfferingsCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.SyncAttributesAndOfferingsCallback
            public void onSuccess(Offerings offerings) {
                Intrinsics.checkNotNullParameter(offerings, "offerings");
                onSuccess.invoke(offerings);
            }
        };
    }

    public static final SyncPurchasesCallback syncPurchasesListener(final Function1<? super CustomerInfo, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        return new SyncPurchasesCallback() { // from class: com.revenuecat.purchases.ListenerConversionsKt.syncPurchasesListener.1
            @Override // com.revenuecat.purchases.interfaces.SyncPurchasesCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                onError.invoke(error);
            }

            @Override // com.revenuecat.purchases.interfaces.SyncPurchasesCallback
            public void onSuccess(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                onSuccess.invoke(customerInfo);
            }
        };
    }

    public static final void syncPurchasesWith(Purchases purchases, Function1<? super PurchasesError, Unit> onError, Function1<? super CustomerInfo, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.syncPurchases(syncPurchasesListener(onSuccess, onError));
    }

    public static /* synthetic */ void syncPurchasesWith$default(Purchases purchases, Function1 function1, Function1 function12, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        syncPurchasesWith(purchases, function1, function12);
    }

    public static final void getCustomerInfoWith(Purchases purchases, CacheFetchPolicy fetchPolicy, Function1<? super PurchasesError, Unit> onError, Function1<? super CustomerInfo, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(purchases, "<this>");
        Intrinsics.checkNotNullParameter(fetchPolicy, "fetchPolicy");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        purchases.getCustomerInfo(fetchPolicy, ListenerConversionsCommonKt.receiveCustomerInfoCallback(onSuccess, onError));
    }

    public static /* synthetic */ void getCustomerInfoWith$default(Purchases purchases, CacheFetchPolicy cacheFetchPolicy, Function1 function1, Function1 function12, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = ListenerConversionsCommonKt.getON_ERROR_STUB();
        }
        getCustomerInfoWith(purchases, cacheFetchPolicy, function1, function12);
    }
}
