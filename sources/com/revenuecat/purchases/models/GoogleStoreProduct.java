package com.revenuecat.purchases.models;

import com.android.billingclient.api.ProductDetails;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.models.GooglePurchasingData;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class GoogleStoreProduct implements StoreProduct {
    private final String basePlanId;
    private final SubscriptionOption defaultOption;
    private final String description;
    private final String name;
    private final Period period;
    private final PresentedOfferingContext presentedOfferingContext;
    private final String presentedOfferingIdentifier;
    private final Price price;
    private final ProductDetails productDetails;
    private final String productId;
    private final SubscriptionOptions subscriptionOptions;
    private final String title;
    private final ProductType type;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public GoogleStoreProduct(String productId, String str, ProductType type, Price price, String name, String title, String description, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, ProductDetails productDetails) {
        this(productId, str, type, price, name, title, description, period, subscriptionOptions, subscriptionOption, productDetails, null, null, 6144, null);
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    @Deprecated
    public StoreProduct copyWithOfferingId(String offeringId) {
        String str;
        PresentedOfferingContext presentedOfferingContext;
        Intrinsics.checkNotNullParameter(offeringId, "offeringId");
        PresentedOfferingContext presentedOfferingContext2 = getPresentedOfferingContext();
        if (presentedOfferingContext2 != null) {
            str = offeringId;
            presentedOfferingContext = PresentedOfferingContext.copy$default(presentedOfferingContext2, str, null, null, 6, null);
            if (presentedOfferingContext == null) {
            }
            return copyWithPresentedOfferingContext(presentedOfferingContext);
        }
        str = offeringId;
        presentedOfferingContext = new PresentedOfferingContext(str);
        return copyWithPresentedOfferingContext(presentedOfferingContext);
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public StoreProduct copyWithPresentedOfferingContext(PresentedOfferingContext presentedOfferingContext) {
        ArrayList arrayList;
        SubscriptionOptions subscriptionOptions = getSubscriptionOptions();
        if (subscriptionOptions != null) {
            arrayList = new ArrayList();
            for (SubscriptionOption subscriptionOption : subscriptionOptions) {
                GoogleSubscriptionOption googleSubscriptionOption = subscriptionOption instanceof GoogleSubscriptionOption ? (GoogleSubscriptionOption) subscriptionOption : null;
                GoogleSubscriptionOption googleSubscriptionOption2 = googleSubscriptionOption != null ? new GoogleSubscriptionOption(googleSubscriptionOption, presentedOfferingContext) : null;
                if (googleSubscriptionOption2 != null) {
                    arrayList.add(googleSubscriptionOption2);
                }
            }
        } else {
            arrayList = null;
        }
        SubscriptionOption defaultOption = getDefaultOption();
        GoogleSubscriptionOption googleSubscriptionOption3 = defaultOption instanceof GoogleSubscriptionOption ? (GoogleSubscriptionOption) defaultOption : null;
        return new GoogleStoreProduct(this, googleSubscriptionOption3 != null ? new GoogleSubscriptionOption(googleSubscriptionOption3, presentedOfferingContext) : null, arrayList != null ? new SubscriptionOptions(arrayList) : null, presentedOfferingContext);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoogleStoreProduct)) {
            return false;
        }
        GoogleStoreProduct googleStoreProduct = (GoogleStoreProduct) obj;
        return Intrinsics.areEqual(this.productId, googleStoreProduct.productId) && Intrinsics.areEqual(this.basePlanId, googleStoreProduct.basePlanId) && this.type == googleStoreProduct.type && Intrinsics.areEqual(this.price, googleStoreProduct.price) && Intrinsics.areEqual(this.name, googleStoreProduct.name) && Intrinsics.areEqual(this.title, googleStoreProduct.title) && Intrinsics.areEqual(this.description, googleStoreProduct.description) && Intrinsics.areEqual(this.period, googleStoreProduct.period) && Intrinsics.areEqual(this.subscriptionOptions, googleStoreProduct.subscriptionOptions) && Intrinsics.areEqual(this.defaultOption, googleStoreProduct.defaultOption) && Intrinsics.areEqual(this.productDetails, googleStoreProduct.productDetails) && Intrinsics.areEqual(this.presentedOfferingIdentifier, googleStoreProduct.presentedOfferingIdentifier) && Intrinsics.areEqual(this.presentedOfferingContext, googleStoreProduct.presentedOfferingContext);
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String formattedPricePerMonth(Locale locale) {
        SubscriptionOption basePlan;
        List<PricingPhase> pricingPhases;
        PricingPhase pricingPhase;
        Intrinsics.checkNotNullParameter(locale, "locale");
        SubscriptionOptions subscriptionOptions = getSubscriptionOptions();
        if (subscriptionOptions == null || (basePlan = subscriptionOptions.getBasePlan()) == null || (pricingPhases = basePlan.getPricingPhases()) == null || (pricingPhase = (PricingPhase) CollectionsKt.last((List) pricingPhases)) == null) {
            return null;
        }
        return pricingPhase.formattedPriceInMonths(locale);
    }

    public final String getBasePlanId() {
        return this.basePlanId;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public SubscriptionOption getDefaultOption() {
        return this.defaultOption;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getDescription() {
        return this.description;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getId() {
        if (this.basePlanId != null) {
            String str = this.productId + ':' + this.basePlanId;
            if (str != null) {
                return str;
            }
        }
        return this.productId;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getName() {
        return this.name;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public Period getPeriod() {
        return this.period;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getPresentedOfferingIdentifier() {
        return this.presentedOfferingIdentifier;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public Price getPrice() {
        return this.price;
    }

    public final ProductDetails getProductDetails() {
        return this.productDetails;
    }

    public final String getProductId() {
        return this.productId;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public PurchasingData getPurchasingData() {
        return (getType() != ProductType.SUBS || getDefaultOption() == null) ? new GooglePurchasingData.InAppProduct(getId(), this.productDetails) : getDefaultOption().getPurchasingData();
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getSku() {
        return this.productId;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public SubscriptionOptions getSubscriptionOptions() {
        return this.subscriptionOptions;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public String getTitle() {
        return this.title;
    }

    @Override // com.revenuecat.purchases.models.StoreProduct
    public ProductType getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = this.productId.hashCode() * 31;
        String str = this.basePlanId;
        int iHashCode2 = (((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.type.hashCode()) * 31) + this.price.hashCode()) * 31) + this.name.hashCode()) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31;
        Period period = this.period;
        int iHashCode3 = (iHashCode2 + (period == null ? 0 : period.hashCode())) * 31;
        SubscriptionOptions subscriptionOptions = this.subscriptionOptions;
        int iHashCode4 = (iHashCode3 + (subscriptionOptions == null ? 0 : subscriptionOptions.hashCode())) * 31;
        SubscriptionOption subscriptionOption = this.defaultOption;
        int iHashCode5 = (((iHashCode4 + (subscriptionOption == null ? 0 : subscriptionOption.hashCode())) * 31) + this.productDetails.hashCode()) * 31;
        String str2 = this.presentedOfferingIdentifier;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        PresentedOfferingContext presentedOfferingContext = this.presentedOfferingContext;
        return iHashCode6 + (presentedOfferingContext != null ? presentedOfferingContext.hashCode() : 0);
    }

    public String toString() {
        return "GoogleStoreProduct(productId=" + this.productId + ", basePlanId=" + this.basePlanId + ", type=" + this.type + ", price=" + this.price + ", name=" + this.name + ", title=" + this.title + ", description=" + this.description + ", period=" + this.period + ", subscriptionOptions=" + this.subscriptionOptions + ", defaultOption=" + this.defaultOption + ", productDetails=" + this.productDetails + ", presentedOfferingIdentifier=" + this.presentedOfferingIdentifier + ", presentedOfferingContext=" + this.presentedOfferingContext + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public GoogleStoreProduct(String productId, String str, ProductType type, Price price, String name, String title, String description, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, ProductDetails productDetails, String str2) {
        this(productId, str, type, price, name, title, description, period, subscriptionOptions, subscriptionOption, productDetails, str2, null, 4096, null);
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
    }

    @Deprecated
    public GoogleStoreProduct(String productId, String str, ProductType type, Price price, String name, String title, String description, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, ProductDetails productDetails, String str2, PresentedOfferingContext presentedOfferingContext) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
        this.productId = productId;
        this.basePlanId = str;
        this.type = type;
        this.price = price;
        this.name = name;
        this.title = title;
        this.description = description;
        this.period = period;
        this.subscriptionOptions = subscriptionOptions;
        this.defaultOption = subscriptionOption;
        this.productDetails = productDetails;
        this.presentedOfferingIdentifier = str2;
        this.presentedOfferingContext = presentedOfferingContext;
    }

    @Deprecated
    public static /* synthetic */ void getPresentedOfferingIdentifier$annotations() {
    }

    @Deprecated
    public static /* synthetic */ void getSku$annotations() {
    }

    public /* synthetic */ GoogleStoreProduct(String str, String str2, ProductType productType, Price price, String str3, String str4, String str5, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, ProductDetails productDetails, String str6, PresentedOfferingContext presentedOfferingContext, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, productType, price, str3, str4, str5, period, subscriptionOptions, subscriptionOption, productDetails, (i3 & 2048) != 0 ? null : str6, (i3 & 4096) != 0 ? null : presentedOfferingContext);
    }

    public /* synthetic */ GoogleStoreProduct(String str, String str2, ProductType productType, Price price, String str3, String str4, String str5, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, ProductDetails productDetails, PresentedOfferingContext presentedOfferingContext, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, productType, price, str3, str4, str5, period, subscriptionOptions, subscriptionOption, productDetails, (i3 & 2048) != 0 ? null : presentedOfferingContext);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GoogleStoreProduct(String productId, String str, ProductType type, Price price, String name, String title, String description, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, ProductDetails productDetails, PresentedOfferingContext presentedOfferingContext) {
        this(productId, str, type, price, name, title, description, period, subscriptionOptions, subscriptionOption, productDetails, presentedOfferingContext != null ? presentedOfferingContext.getOfferingIdentifier() : null, presentedOfferingContext);
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
    }

    public /* synthetic */ GoogleStoreProduct(String str, String str2, ProductType productType, Price price, String str3, String str4, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, ProductDetails productDetails, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, productType, price, str3, str4, period, subscriptionOptions, subscriptionOption, productDetails, (i3 & 1024) != 0 ? null : str5);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated
    public GoogleStoreProduct(String productId, String str, ProductType type, Price price, String title, String description, Period period, SubscriptionOptions subscriptionOptions, SubscriptionOption subscriptionOption, ProductDetails productDetails, String str2) {
        this(productId, str, type, price, title, title, description, period, subscriptionOptions, subscriptionOption, productDetails, str2 != null ? new PresentedOfferingContext(str2) : null);
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(productDetails, "productDetails");
    }

    private GoogleStoreProduct(GoogleStoreProduct googleStoreProduct, SubscriptionOption subscriptionOption, SubscriptionOptions subscriptionOptions, PresentedOfferingContext presentedOfferingContext) {
        this(googleStoreProduct.productId, googleStoreProduct.basePlanId, googleStoreProduct.getType(), googleStoreProduct.getPrice(), googleStoreProduct.getName(), googleStoreProduct.getTitle(), googleStoreProduct.getDescription(), googleStoreProduct.getPeriod(), subscriptionOptions, subscriptionOption, googleStoreProduct.productDetails, presentedOfferingContext);
    }
}
