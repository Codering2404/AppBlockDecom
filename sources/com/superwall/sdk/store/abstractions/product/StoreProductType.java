package com.superwall.sdk.store.abstractions.product;

import com.appsflyer.AppsFlyerProperties;
import com.superwall.sdk.store.abstractions.product.SubscriptionPeriod;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

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
public interface StoreProductType {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        public static Map<String, String> getAttributes(StoreProductType storeProductType) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("rawPrice", storeProductType.getPrice().toString());
            linkedHashMap.put("price", storeProductType.getLocalizedPrice());
            linkedHashMap.put("periodAlt", storeProductType.getLocalizedSubscriptionPeriod());
            linkedHashMap.put("localizedPeriod", storeProductType.getLocalizedSubscriptionPeriod());
            linkedHashMap.put("period", storeProductType.getPeriod());
            linkedHashMap.put("periodly", storeProductType.getPeriodly());
            linkedHashMap.put("weeklyPrice", storeProductType.getWeeklyPrice());
            linkedHashMap.put("dailyPrice", storeProductType.getDailyPrice());
            linkedHashMap.put("monthlyPrice", storeProductType.getMonthlyPrice());
            linkedHashMap.put("yearlyPrice", storeProductType.getYearlyPrice());
            linkedHashMap.put("rawTrialPeriodPrice", storeProductType.getTrialPeriodPrice().toString());
            linkedHashMap.put("trialPeriodPrice", storeProductType.getLocalizedTrialPeriodPrice());
            linkedHashMap.put("trialPeriodDailyPrice", storeProductType.trialPeriodPricePerUnit(SubscriptionPeriod.Unit.day));
            linkedHashMap.put("trialPeriodWeeklyPrice", storeProductType.trialPeriodPricePerUnit(SubscriptionPeriod.Unit.week));
            linkedHashMap.put("trialPeriodMonthlyPrice", storeProductType.trialPeriodPricePerUnit(SubscriptionPeriod.Unit.month));
            linkedHashMap.put("trialPeriodYearlyPrice", storeProductType.trialPeriodPricePerUnit(SubscriptionPeriod.Unit.year));
            linkedHashMap.put("trialPeriodDays", storeProductType.getTrialPeriodDaysString());
            linkedHashMap.put("trialPeriodWeeks", storeProductType.getTrialPeriodWeeksString());
            linkedHashMap.put("trialPeriodMonths", storeProductType.getTrialPeriodMonthsString());
            linkedHashMap.put("trialPeriodYears", storeProductType.getTrialPeriodYearsString());
            linkedHashMap.put("trialPeriodText", storeProductType.getTrialPeriodText());
            linkedHashMap.put("trialPeriodEndDate", storeProductType.getTrialPeriodEndDateString());
            linkedHashMap.put("periodDays", storeProductType.getPeriodDaysString());
            linkedHashMap.put("periodWeeks", storeProductType.getPeriodWeeksString());
            linkedHashMap.put("periodMonths", storeProductType.getPeriodMonthsString());
            linkedHashMap.put("periodYears", storeProductType.getPeriodYearsString());
            linkedHashMap.put("locale", storeProductType.getLocale());
            String languageCode = storeProductType.getLanguageCode();
            if (languageCode == null) {
                languageCode = "n/a";
            }
            linkedHashMap.put("languageCode", languageCode);
            String currencyCode = storeProductType.getCurrencyCode();
            if (currencyCode == null) {
                currencyCode = "n/a";
            }
            linkedHashMap.put(AppsFlyerProperties.CURRENCY_CODE, currencyCode);
            String currencySymbol = storeProductType.getCurrencySymbol();
            if (currencySymbol == null) {
                currencySymbol = "n/a";
            }
            linkedHashMap.put("currencySymbol", currencySymbol);
            String storeFrontCountryCode = storeProductType.getStoreFrontCountryCode();
            linkedHashMap.put("storeFrontCountryCode", storeFrontCountryCode != null ? storeFrontCountryCode : "n/a");
            linkedHashMap.put("identifier", storeProductType.getFullIdentifier());
            linkedHashMap.put("productIdentifier", storeProductType.getProductIdentifier());
            return linkedHashMap;
        }

        public static String getStoreFrontCountryCode(StoreProductType storeProductType) {
            return null;
        }
    }

    Map<String, String> getAttributes();

    String getCurrencyCode();

    String getCurrencySymbol();

    String getDailyPrice();

    String getFullIdentifier();

    boolean getHasFreeTrial();

    String getLanguageCode();

    String getLocale();

    String getLocalizedPrice();

    String getLocalizedSubscriptionPeriod();

    String getLocalizedTrialPeriodPrice();

    String getMonthlyPrice();

    String getPeriod();

    int getPeriodDays();

    String getPeriodDaysString();

    int getPeriodMonths();

    String getPeriodMonthsString();

    int getPeriodWeeks();

    String getPeriodWeeksString();

    int getPeriodYears();

    String getPeriodYearsString();

    String getPeriodly();

    BigDecimal getPrice();

    String getProductIdentifier();

    String getProductType();

    String getRegionCode();

    String getStoreFrontCountryCode();

    SubscriptionPeriod getSubscriptionPeriod();

    int getTrialPeriodDays();

    String getTrialPeriodDaysString();

    Date getTrialPeriodEndDate();

    String getTrialPeriodEndDateString();

    int getTrialPeriodMonths();

    String getTrialPeriodMonthsString();

    BigDecimal getTrialPeriodPrice();

    String getTrialPeriodText();

    int getTrialPeriodWeeks();

    String getTrialPeriodWeeksString();

    int getTrialPeriodYears();

    String getTrialPeriodYearsString();

    String getWeeklyPrice();

    String getYearlyPrice();

    String trialPeriodPricePerUnit(SubscriptionPeriod.Unit unit);
}
