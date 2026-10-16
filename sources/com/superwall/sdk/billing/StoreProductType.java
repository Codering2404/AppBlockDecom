package com.superwall.sdk.billing;

import java.math.BigDecimal;
import java.util.Date;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface StoreProductType {
    String getCurrencyCode();

    String getCurrencySymbol();

    String getDailyPrice();

    boolean getHasFreeTrial();

    String getLanguageCode();

    String getLocale();

    String getLocalizedPrice();

    String getLocalizedSubscriptionPeriod();

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

    String getRegionCode();

    String getSubscriptionGroupIdentifier();

    Map<String, Object> getSwProductTemplateVariablesJson();

    int getTrialPeriodDays();

    String getTrialPeriodDaysString();

    Date getTrialPeriodEndDate();

    String getTrialPeriodEndDateString();

    int getTrialPeriodMonths();

    String getTrialPeriodMonthsString();

    String getTrialPeriodText();

    int getTrialPeriodWeeks();

    String getTrialPeriodWeeksString();

    int getTrialPeriodYears();

    String getTrialPeriodYearsString();

    String getWeeklyPrice();

    String getYearlyPrice();
}
