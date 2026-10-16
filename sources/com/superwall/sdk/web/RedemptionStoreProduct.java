package com.superwall.sdk.web;

import com.superwall.sdk.models.internal.RedemptionResult;
import com.superwall.sdk.store.abstractions.product.StoreProductType;
import com.superwall.sdk.store.abstractions.product.SubscriptionPeriod;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.format.DateTimeParseException;

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
public final class RedemptionStoreProduct implements StoreProductType {
    private final String currencyCode;
    private final String currencySymbol;
    private final String dailyPrice;
    private final String fullIdentifier;
    private final boolean hasFreeTrial;
    private final String languageCode;
    private final String locale;
    private final String localizedPrice;
    private final String localizedSubscriptionPeriod;
    private final String localizedTrialPeriodPrice;
    private final String monthlyPrice;
    private final String period;
    private final int periodDays;
    private final String periodDaysString;
    private final int periodMonths;
    private final String periodMonthsString;
    private final int periodWeeks;
    private final String periodWeeksString;
    private final int periodYears;
    private final String periodYearsString;
    private final String periodly;
    private final BigDecimal price;
    private final RedemptionResult.PaywallInfo.PaywallProduct product;
    private final String productIdentifier;
    private final String productType;
    private final String regionCode;
    private final SubscriptionPeriod subscriptionPeriod;
    private final int trialPeriodDays;
    private final String trialPeriodDaysString;
    private final Lazy trialPeriodEndDate$delegate;
    private final String trialPeriodEndDateString;
    private final int trialPeriodMonths;
    private final String trialPeriodMonthsString;
    private final BigDecimal trialPeriodPrice;
    private final String trialPeriodText;
    private final int trialPeriodWeeks;
    private final String trialPeriodWeeksString;
    private final int trialPeriodYears;
    private final String trialPeriodYearsString;
    private final String weeklyPrice;
    private final String yearlyPrice;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SubscriptionPeriod.Unit.values().length];
            try {
                iArr[SubscriptionPeriod.Unit.day.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SubscriptionPeriod.Unit.week.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SubscriptionPeriod.Unit.month.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SubscriptionPeriod.Unit.year.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RedemptionStoreProduct(RedemptionResult.PaywallInfo.PaywallProduct product) {
        Intrinsics.checkNotNullParameter(product, "product");
        this.product = product;
        this.fullIdentifier = product.getIdentifier();
        this.productIdentifier = product.getIdentifier();
        this.price = BigDecimal.valueOf(product.getRawPrice());
        this.localizedPrice = product.getPrice();
        this.localizedSubscriptionPeriod = product.getLocalizedPeriod();
        this.period = product.getPeriod();
        this.periodly = product.getPeriodly();
        this.periodDays = product.getPeriodDays();
        this.periodWeeks = product.getPeriodWeeks();
        this.periodMonths = product.getPeriodMonths();
        this.periodYears = product.getPeriodYears();
        this.periodDaysString = String.valueOf(getPeriodDays());
        this.periodWeeksString = String.valueOf(getPeriodWeeks());
        this.periodMonthsString = String.valueOf(getPeriodMonths());
        this.periodYearsString = String.valueOf(getPeriodYears());
        this.dailyPrice = product.getDailyPrice();
        this.weeklyPrice = product.getWeeklyPrice();
        this.monthlyPrice = product.getMonthlyPrice();
        this.yearlyPrice = product.getYearlyPrice();
        this.hasFreeTrial = product.getTrialPeriodDays() > 0;
        this.localizedTrialPeriodPrice = product.getTrialPeriodPrice();
        this.trialPeriodPrice = BigDecimal.valueOf(product.getRawTrialPeriodPrice());
        this.trialPeriodEndDateString = product.getTrialPeriodEndDate();
        this.trialPeriodEndDate$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.web.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RedemptionStoreProduct.trialPeriodEndDate_delegate$lambda$0(this.f93783a);
            }
        });
        this.trialPeriodDays = product.getTrialPeriodDays();
        this.trialPeriodWeeks = product.getTrialPeriodWeeks();
        this.trialPeriodMonths = product.getTrialPeriodMonths();
        this.trialPeriodYears = product.getTrialPeriodYears();
        this.trialPeriodDaysString = String.valueOf(getTrialPeriodDays());
        this.trialPeriodWeeksString = String.valueOf(getTrialPeriodWeeks());
        this.trialPeriodMonthsString = String.valueOf(getTrialPeriodMonths());
        this.trialPeriodYearsString = String.valueOf(getTrialPeriodYears());
        this.trialPeriodText = product.getTrialPeriodText();
        this.locale = product.getLocale();
        this.languageCode = product.getLanguageCode();
        this.currencyCode = product.getCurrencyCode();
        this.currencySymbol = product.getCurrencySymbol();
        Integer numValueOf = Integer.valueOf(product.getPeriodDays());
        numValueOf = numValueOf.intValue() <= 0 ? null : numValueOf;
        this.subscriptionPeriod = numValueOf != null ? new SubscriptionPeriod(numValueOf.intValue(), SubscriptionPeriod.Unit.day).normalized() : null;
        this.productType = getSubscriptionPeriod() != null ? "subs" : "inapp";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Date trialPeriodEndDate_delegate$lambda$0(RedemptionStoreProduct redemptionStoreProduct) {
        Instant instantY;
        String trialPeriodEndDate = redemptionStoreProduct.product.getTrialPeriodEndDate();
        try {
            try {
                instantY = OffsetDateTime.y(trialPeriodEndDate).D();
            } catch (DateTimeParseException unused) {
                instantY = LocalDate.l0(trialPeriodEndDate).B().y(ZoneOffset.f146222i);
            }
            return new Date(instantY.S());
        } catch (ArithmeticException | DateTimeException unused2) {
            return null;
        }
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public Map<String, String> getAttributes() {
        return MapsKt.plus(StoreProductType.DefaultImpls.getAttributes(this), TuplesKt.a("periodAlt", this.product.getPeriodAlt()));
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getCurrencyCode() {
        return this.currencyCode;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getCurrencySymbol() {
        return this.currencySymbol;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getDailyPrice() {
        return this.dailyPrice;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getFullIdentifier() {
        return this.fullIdentifier;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public boolean getHasFreeTrial() {
        return this.hasFreeTrial;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getLanguageCode() {
        return this.languageCode;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getLocale() {
        return this.locale;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getLocalizedPrice() {
        return this.localizedPrice;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getLocalizedSubscriptionPeriod() {
        return this.localizedSubscriptionPeriod;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getLocalizedTrialPeriodPrice() {
        return this.localizedTrialPeriodPrice;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getMonthlyPrice() {
        return this.monthlyPrice;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getPeriod() {
        return this.period;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getPeriodDays() {
        return this.periodDays;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getPeriodDaysString() {
        return this.periodDaysString;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getPeriodMonths() {
        return this.periodMonths;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getPeriodMonthsString() {
        return this.periodMonthsString;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getPeriodWeeks() {
        return this.periodWeeks;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getPeriodWeeksString() {
        return this.periodWeeksString;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getPeriodYears() {
        return this.periodYears;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getPeriodYearsString() {
        return this.periodYearsString;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getPeriodly() {
        return this.periodly;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getProductIdentifier() {
        return this.productIdentifier;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getProductType() {
        return this.productType;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getRegionCode() {
        return this.regionCode;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getStoreFrontCountryCode() {
        return StoreProductType.DefaultImpls.getStoreFrontCountryCode(this);
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public SubscriptionPeriod getSubscriptionPeriod() {
        return this.subscriptionPeriod;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getTrialPeriodDays() {
        return this.trialPeriodDays;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getTrialPeriodDaysString() {
        return this.trialPeriodDaysString;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public Date getTrialPeriodEndDate() {
        return (Date) this.trialPeriodEndDate$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getTrialPeriodEndDateString() {
        return this.trialPeriodEndDateString;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getTrialPeriodMonths() {
        return this.trialPeriodMonths;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getTrialPeriodMonthsString() {
        return this.trialPeriodMonthsString;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public BigDecimal getTrialPeriodPrice() {
        return this.trialPeriodPrice;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getTrialPeriodText() {
        return this.trialPeriodText;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getTrialPeriodWeeks() {
        return this.trialPeriodWeeks;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getTrialPeriodWeeksString() {
        return this.trialPeriodWeeksString;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getTrialPeriodYears() {
        return this.trialPeriodYears;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getTrialPeriodYearsString() {
        return this.trialPeriodYearsString;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getWeeklyPrice() {
        return this.weeklyPrice;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getYearlyPrice() {
        return this.yearlyPrice;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String trialPeriodPricePerUnit(SubscriptionPeriod.Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        int i3 = WhenMappings.$EnumSwitchMapping$0[unit.ordinal()];
        if (i3 == 1) {
            return this.product.getTrialPeriodDailyPrice();
        }
        if (i3 == 2) {
            return this.product.getTrialPeriodWeeklyPrice();
        }
        if (i3 == 3) {
            return this.product.getTrialPeriodMonthlyPrice();
        }
        if (i3 == 4) {
            return this.product.getTrialPeriodYearlyPrice();
        }
        throw new NoWhenBranchMatchedException();
    }
}
