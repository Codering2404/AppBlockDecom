package com.revenuecat.purchases;

import android.app.Activity;
import com.android.billingclient.api.ProductDetails;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.GooglePurchasingData;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreReplacementMode;
import com.revenuecat.purchases.models.StoreReplacementModeConversionsKt;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
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
public final class PurchaseParams {
    private final Activity activity;
    private final Builder builder;
    private final Boolean isPersonalizedPrice;
    private final String oldProductId;
    private PresentedOfferingContext presentedOfferingContext;
    private final PurchasingData purchasingData;
    private final StoreReplacementMode replacementMode;

    public PurchaseParams(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
        this.isPersonalizedPrice = builder.isPersonalizedPrice$purchases_defaultsBc8Release();
        this.oldProductId = builder.getOldProductId$purchases_defaultsBc8Release();
        this.replacementMode = builder.getReplacementMode$purchases_defaultsBc8Release();
        this.purchasingData = builder.getPurchasingData$purchases_defaultsBc8Release();
        this.activity = builder.getActivity$purchases_defaultsBc8Release();
        this.presentedOfferingContext = builder.getPresentedOfferingContext$purchases_defaultsBc8Release();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PurchaseParams) && Intrinsics.areEqual(this.builder, ((PurchaseParams) obj).builder);
    }

    public final /* synthetic */ Activity getActivity$purchases_defaultsBc8Release() {
        return this.activity;
    }

    public final Builder getBuilder() {
        return this.builder;
    }

    public final /* synthetic */ boolean getContainsAddOnItems$purchases_defaultsBc8Release() {
        List addOnProducts;
        PurchasingData purchasingData = this.purchasingData;
        GooglePurchasingData.Subscription subscription = purchasingData instanceof GooglePurchasingData.Subscription ? (GooglePurchasingData.Subscription) purchasingData : null;
        if (subscription == null || (addOnProducts = subscription.getAddOnProducts()) == null) {
            return false;
        }
        return !addOnProducts.isEmpty();
    }

    public final GoogleReplacementMode getGoogleReplacementMode() {
        return StoreReplacementModeConversionsKt.toGoogleReplacementMode(this.replacementMode);
    }

    public final String getOldProductId() {
        return this.oldProductId;
    }

    public final /* synthetic */ PresentedOfferingContext getPresentedOfferingContext$purchases_defaultsBc8Release() {
        return this.presentedOfferingContext;
    }

    public final /* synthetic */ PurchasingData getPurchasingData$purchases_defaultsBc8Release() {
        return this.purchasingData;
    }

    public final StoreReplacementMode getReplacementMode() {
        return this.replacementMode;
    }

    public int hashCode() {
        return this.builder.hashCode();
    }

    public final Boolean isPersonalizedPrice() {
        return this.isPersonalizedPrice;
    }

    public final void setPresentedOfferingContext$purchases_defaultsBc8Release(PresentedOfferingContext presentedOfferingContext) {
        this.presentedOfferingContext = presentedOfferingContext;
    }

    public String toString() {
        return "PurchaseParams(builder=" + this.builder + ')';
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class Builder {
        private final Activity activity;
        private Boolean isPersonalizedPrice;
        private String oldProductId;
        private PresentedOfferingContext presentedOfferingContext;
        private final StoreProduct product;
        private PurchasingData purchasingData;
        private StoreReplacementMode replacementMode;

        private Builder(Activity activity, PurchasingData purchasingData, PresentedOfferingContext presentedOfferingContext, StoreProduct storeProduct) {
            this.activity = activity;
            this.purchasingData = purchasingData;
            this.presentedOfferingContext = presentedOfferingContext;
            this.product = storeProduct;
            this.replacementMode = StoreReplacementMode.WITHOUT_PRORATION;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private final Builder attachSubscriptionAddOns(List<? extends GooglePurchasingData> list) {
            if (list.isEmpty()) {
                final LogIntent logIntent = LogIntent.DEBUG;
                Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.PurchaseParams$Builder$attachSubscriptionAddOns$lambda$14$$inlined$log$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + PurchaseStrings.EMPTY_ADD_ONS_LIST_PASSED;
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel = LogLevel.DEBUG;
                        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler.d("[Purchases] - " + logLevel.name(), (String) function0.invoke());
                            return this;
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        return this;
                    case 3:
                        LogLevel logLevel2 = LogLevel.WARN;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                            return this;
                        }
                        break;
                    case 4:
                        LogLevel logLevel3 = LogLevel.INFO;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                            return this;
                        }
                        break;
                    case 5:
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            currentLogHandler4.d("[Purchases] - " + logLevel4.name(), (String) function0.invoke());
                            return this;
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        return this;
                    case 7:
                        LogLevel logLevel5 = LogLevel.INFO;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                            return this;
                        }
                        break;
                    case 8:
                        LogLevel logLevel6 = LogLevel.DEBUG;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            currentLogHandler6.d("[Purchases] - " + logLevel6.name(), (String) function0.invoke());
                            return this;
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            currentLogHandler7.d("[Purchases] - " + logLevel7.name(), (String) function0.invoke());
                            return this;
                        }
                        break;
                    case 10:
                        LogLevel logLevel8 = LogLevel.WARN;
                        LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            currentLogHandler8.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                            return this;
                        }
                        break;
                    case 11:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler9.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                            return this;
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        return this;
                    case 13:
                        LogLevel logLevel10 = LogLevel.WARN;
                        LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                            currentLogHandler10.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                            return this;
                        }
                        break;
                    case 14:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        return this;
                }
            } else {
                PurchasingData purchasingData = this.purchasingData;
                GooglePurchasingData.Subscription subscription = purchasingData instanceof GooglePurchasingData.Subscription ? (GooglePurchasingData.Subscription) purchasingData : null;
                if (subscription != null) {
                    ArrayList arrayList = new ArrayList();
                    for (GooglePurchasingData googlePurchasingData : list) {
                        GooglePurchasingData.Subscription subscription2 = googlePurchasingData instanceof GooglePurchasingData.Subscription ? (GooglePurchasingData.Subscription) googlePurchasingData : null;
                        if (subscription2 != null) {
                            arrayList.add(subscription2);
                        }
                    }
                    String productId = subscription.getProductId();
                    String optionId = subscription.getOptionId();
                    ProductDetails productDetails = subscription.getProductDetails();
                    String token = subscription.getToken();
                    Period billingPeriod = subscription.getBillingPeriod();
                    List addOnProducts = subscription.getAddOnProducts();
                    if (addOnProducts == null) {
                        addOnProducts = CollectionsKt.emptyList();
                    }
                    this.purchasingData = new GooglePurchasingData.Subscription(productId, optionId, productDetails, token, billingPeriod, CollectionsKt.plus((Collection) addOnProducts, (Iterable) arrayList));
                }
            }
            return this;
        }

        public final Builder addOnPackages(List<Package> addOnPackages) {
            Intrinsics.checkNotNullParameter(addOnPackages, "addOnPackages");
            List<Package> list = addOnPackages;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((Package) it.next()).getProduct());
            }
            addOnStoreProducts(arrayList);
            return this;
        }

        public final Builder addOnStoreProducts(List<? extends StoreProduct> addOnStoreProducts) {
            Intrinsics.checkNotNullParameter(addOnStoreProducts, "addOnStoreProducts");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = addOnStoreProducts.iterator();
            while (it.hasNext()) {
                PurchasingData purchasingData = ((StoreProduct) it.next()).getPurchasingData();
                GooglePurchasingData.Subscription subscription = purchasingData instanceof GooglePurchasingData.Subscription ? (GooglePurchasingData.Subscription) purchasingData : null;
                if (subscription != null) {
                    arrayList.add(subscription);
                }
            }
            attachSubscriptionAddOns(arrayList);
            return this;
        }

        public final Builder addOnSubscriptionOptions(List<? extends SubscriptionOption> addOnSubscriptionOptions) {
            Intrinsics.checkNotNullParameter(addOnSubscriptionOptions, "addOnSubscriptionOptions");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = addOnSubscriptionOptions.iterator();
            while (it.hasNext()) {
                PurchasingData purchasingData = ((SubscriptionOption) it.next()).getPurchasingData();
                GooglePurchasingData.Subscription subscription = purchasingData instanceof GooglePurchasingData.Subscription ? (GooglePurchasingData.Subscription) purchasingData : null;
                if (subscription != null) {
                    arrayList.add(subscription);
                }
            }
            attachSubscriptionAddOns(arrayList);
            return this;
        }

        public PurchaseParams build() {
            return new PurchaseParams(this);
        }

        public final /* synthetic */ Activity getActivity$purchases_defaultsBc8Release() {
            return this.activity;
        }

        public final /* synthetic */ String getOldProductId$purchases_defaultsBc8Release() {
            return this.oldProductId;
        }

        public final /* synthetic */ PresentedOfferingContext getPresentedOfferingContext$purchases_defaultsBc8Release() {
            return this.presentedOfferingContext;
        }

        public final /* synthetic */ StoreProduct getProduct$purchases_defaultsBc8Release() {
            return this.product;
        }

        public final /* synthetic */ PurchasingData getPurchasingData$purchases_defaultsBc8Release() {
            return this.purchasingData;
        }

        public final /* synthetic */ StoreReplacementMode getReplacementMode$purchases_defaultsBc8Release() {
            return this.replacementMode;
        }

        @Deprecated
        public final Builder googleReplacementMode(GoogleReplacementMode googleReplacementMode) {
            Intrinsics.checkNotNullParameter(googleReplacementMode, "googleReplacementMode");
            this.replacementMode = StoreReplacementModeConversionsKt.toStoreReplacementMode(googleReplacementMode);
            return this;
        }

        public final Builder isPersonalizedPrice(boolean z2) {
            this.isPersonalizedPrice = Boolean.valueOf(z2);
            return this;
        }

        public final /* synthetic */ Boolean isPersonalizedPrice$purchases_defaultsBc8Release() {
            return this.isPersonalizedPrice;
        }

        public final Builder oldProductId(String oldProductId) {
            Intrinsics.checkNotNullParameter(oldProductId, "oldProductId");
            this.oldProductId = oldProductId;
            return this;
        }

        public final Builder presentedOfferingContext(PresentedOfferingContext presentedOfferingContext) {
            Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
            this.presentedOfferingContext = presentedOfferingContext;
            return this;
        }

        public final Builder replacementMode(StoreReplacementMode replacementMode) {
            Intrinsics.checkNotNullParameter(replacementMode, "replacementMode");
            this.replacementMode = replacementMode;
            return this;
        }

        public final /* synthetic */ void setOldProductId$purchases_defaultsBc8Release(String str) {
            this.oldProductId = str;
        }

        public final /* synthetic */ void setPersonalizedPrice$purchases_defaultsBc8Release(Boolean bool) {
            this.isPersonalizedPrice = bool;
        }

        public final void setPresentedOfferingContext$purchases_defaultsBc8Release(PresentedOfferingContext presentedOfferingContext) {
            this.presentedOfferingContext = presentedOfferingContext;
        }

        public final void setPurchasingData$purchases_defaultsBc8Release(PurchasingData purchasingData) {
            Intrinsics.checkNotNullParameter(purchasingData, "<set-?>");
            this.purchasingData = purchasingData;
        }

        public final /* synthetic */ void setReplacementMode$purchases_defaultsBc8Release(StoreReplacementMode storeReplacementMode) {
            Intrinsics.checkNotNullParameter(storeReplacementMode, "<set-?>");
            this.replacementMode = storeReplacementMode;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Activity activity, Package packageToPurchase) {
            this(activity, packageToPurchase.getProduct().getPurchasingData(), packageToPurchase.getPresentedOfferingContext(), packageToPurchase.getProduct());
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(packageToPurchase, "packageToPurchase");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Activity activity, StoreProduct storeProduct) {
            this(activity, storeProduct.getPurchasingData(), storeProduct.getPresentedOfferingContext(), storeProduct);
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Activity activity, SubscriptionOption subscriptionOption) {
            this(activity, subscriptionOption.getPurchasingData(), subscriptionOption.getPresentedOfferingContext(), null);
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(subscriptionOption, "subscriptionOption");
        }
    }

    public static /* synthetic */ void getContainsAddOnItems$purchases_defaultsBc8Release$annotations() {
    }

    @Deprecated
    public static /* synthetic */ void getGoogleReplacementMode$annotations() {
    }
}
