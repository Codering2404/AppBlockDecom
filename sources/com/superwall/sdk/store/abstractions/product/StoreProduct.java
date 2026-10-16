package com.superwall.sdk.store.abstractions.product;

import com.superwall.sdk.store.abstractions.product.SubscriptionPeriod;
import com.superwall.sdk.store.testmode.models.SuperwallProductPlatform;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
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
public final class StoreProduct implements StoreProductType {
    public static final Companion Companion = new Companion(null);
    private final StoreProductType backingProduct;
    private String customTransactionId;
    private final RawStoreProduct rawStoreProduct;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final StoreProduct custom(ApiStoreProduct apiStoreProduct) {
            Intrinsics.checkNotNullParameter(apiStoreProduct, "apiStoreProduct");
            return new StoreProduct(null, apiStoreProduct, 0 == true ? 1 : 0);
        }

        private Companion() {
        }
    }

    public /* synthetic */ StoreProduct(RawStoreProduct rawStoreProduct, StoreProductType storeProductType, DefaultConstructorMarker defaultConstructorMarker) {
        this(rawStoreProduct, storeProductType);
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public Map<String, String> getAttributes() {
        return this.backingProduct.getAttributes();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getCurrencyCode() {
        return this.backingProduct.getCurrencyCode();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getCurrencySymbol() {
        return this.backingProduct.getCurrencySymbol();
    }

    public final String getCustomTransactionId() {
        return this.customTransactionId;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getDailyPrice() {
        return this.backingProduct.getDailyPrice();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getFullIdentifier() {
        return this.backingProduct.getFullIdentifier();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public boolean getHasFreeTrial() {
        return this.backingProduct.getHasFreeTrial();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getLanguageCode() {
        return this.backingProduct.getLanguageCode();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getLocale() {
        return this.backingProduct.getLocale();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getLocalizedPrice() {
        return this.backingProduct.getLocalizedPrice();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getLocalizedSubscriptionPeriod() {
        return this.backingProduct.getLocalizedSubscriptionPeriod();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getLocalizedTrialPeriodPrice() {
        return this.backingProduct.getLocalizedTrialPeriodPrice();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getMonthlyPrice() {
        return this.backingProduct.getMonthlyPrice();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getPeriod() {
        return this.backingProduct.getPeriod();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getPeriodDays() {
        return this.backingProduct.getPeriodDays();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getPeriodDaysString() {
        return this.backingProduct.getPeriodDaysString();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getPeriodMonths() {
        return this.backingProduct.getPeriodMonths();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getPeriodMonthsString() {
        return this.backingProduct.getPeriodMonthsString();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getPeriodWeeks() {
        return this.backingProduct.getPeriodWeeks();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getPeriodWeeksString() {
        return this.backingProduct.getPeriodWeeksString();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getPeriodYears() {
        return this.backingProduct.getPeriodYears();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getPeriodYearsString() {
        return this.backingProduct.getPeriodYearsString();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getPeriodly() {
        return this.backingProduct.getPeriodly();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public BigDecimal getPrice() {
        return this.backingProduct.getPrice();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getProductIdentifier() {
        return this.backingProduct.getProductIdentifier();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getProductType() {
        return this.backingProduct.getProductType();
    }

    public final RawStoreProduct getRawStoreProduct() {
        return this.rawStoreProduct;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getRegionCode() {
        return this.backingProduct.getRegionCode();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getStoreFrontCountryCode() {
        return this.backingProduct.getStoreFrontCountryCode();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public SubscriptionPeriod getSubscriptionPeriod() {
        return this.backingProduct.getSubscriptionPeriod();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getTrialPeriodDays() {
        return this.backingProduct.getTrialPeriodDays();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getTrialPeriodDaysString() {
        return this.backingProduct.getTrialPeriodDaysString();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public Date getTrialPeriodEndDate() {
        return this.backingProduct.getTrialPeriodEndDate();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getTrialPeriodEndDateString() {
        return this.backingProduct.getTrialPeriodEndDateString();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getTrialPeriodMonths() {
        return this.backingProduct.getTrialPeriodMonths();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getTrialPeriodMonthsString() {
        return this.backingProduct.getTrialPeriodMonthsString();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public BigDecimal getTrialPeriodPrice() {
        return this.backingProduct.getTrialPeriodPrice();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getTrialPeriodText() {
        return this.backingProduct.getTrialPeriodText();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getTrialPeriodWeeks() {
        return this.backingProduct.getTrialPeriodWeeks();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getTrialPeriodWeeksString() {
        return this.backingProduct.getTrialPeriodWeeksString();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getTrialPeriodYears() {
        return this.backingProduct.getTrialPeriodYears();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getTrialPeriodYearsString() {
        return this.backingProduct.getTrialPeriodYearsString();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getWeeklyPrice() {
        return this.backingProduct.getWeeklyPrice();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getYearlyPrice() {
        return this.backingProduct.getYearlyPrice();
    }

    public final boolean isCustomProduct() {
        StoreProductType storeProductType = this.backingProduct;
        ApiStoreProduct apiStoreProduct = storeProductType instanceof ApiStoreProduct ? (ApiStoreProduct) storeProductType : null;
        return (apiStoreProduct != null ? apiStoreProduct.getPlatform() : null) == SuperwallProductPlatform.CUSTOM;
    }

    public final void setCustomTransactionId(String str) {
        this.customTransactionId = str;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String trialPeriodPricePerUnit(SubscriptionPeriod.Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return this.backingProduct.trialPeriodPricePerUnit(unit);
    }

    private StoreProduct(RawStoreProduct rawStoreProduct, StoreProductType storeProductType) {
        this.rawStoreProduct = rawStoreProduct;
        this.backingProduct = storeProductType;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StoreProduct(RawStoreProduct rawStoreProduct) {
        this(rawStoreProduct, rawStoreProduct);
        Intrinsics.checkNotNullParameter(rawStoreProduct, "rawStoreProduct");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StoreProduct(StoreProductType storeProductType) {
        this(null, storeProductType);
        Intrinsics.checkNotNullParameter(storeProductType, "storeProductType");
    }
}
