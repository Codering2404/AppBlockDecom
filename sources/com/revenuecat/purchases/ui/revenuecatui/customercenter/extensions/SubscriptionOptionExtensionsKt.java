package com.revenuecat.purchases.ui.revenuecatui.customercenter.extensions;

import android.icu.text.MeasureFormat;
import android.icu.util.Measure;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.models.OfferPaymentMode;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PeriodExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PriceExtensionsKt;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

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
public final /* synthetic */ class SubscriptionOptionExtensionsKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OfferPaymentMode.values().length];
            try {
                iArr[OfferPaymentMode.FREE_TRIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OfferPaymentMode.SINGLE_PAYMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OfferPaymentMode.DISCOUNTED_RECURRING_PAYMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final /* synthetic */ String getLocalizedDescription(SubscriptionOption subscriptionOption, CustomerCenterConfigData.Localization localization, Locale locale) {
        Intrinsics.checkNotNullParameter(subscriptionOption, "<this>");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Intrinsics.checkNotNullParameter(locale, "locale");
        int size = subscriptionOption.getPricingPhases().size();
        return size != 2 ? size != 3 ? ((PricingPhase) CollectionsKt.first((List) subscriptionOption.getPricingPhases())).getPrice().getFormatted() : getThreePhaseDescription(subscriptionOption, localization, locale) : getTwoPhaseDescription(subscriptionOption, localization, locale);
    }

    private static final String getThreePhaseDescription(SubscriptionOption subscriptionOption, CustomerCenterConfigData.Localization localization, Locale locale) {
        PricingPhase pricingPhase = (PricingPhase) CollectionsKt.first((List) subscriptionOption.getPricingPhases());
        PricingPhase pricingPhase2 = subscriptionOption.getPricingPhases().get(1);
        PricingPhase pricingPhase3 = (PricingPhase) CollectionsKt.last((List) subscriptionOption.getPricingPhases());
        String strLocalizedPerPeriod = PriceExtensionsKt.localizedPerPeriod(pricingPhase3.getPrice(), pricingPhase3.getBillingPeriod(), locale, false);
        if (pricingPhase.getOfferPaymentMode() != OfferPaymentMode.FREE_TRIAL) {
            return getTwoPhaseDescription(subscriptionOption, localization, locale);
        }
        String strLocalizedTotalDuration = localizedTotalDuration(pricingPhase, locale);
        String strLocalizedTotalDuration2 = localizedTotalDuration(pricingPhase2, locale);
        Integer billingCycleCount = pricingPhase2.getBillingCycleCount();
        Map mapMapOf = MapsKt.mapOf(TuplesKt.a(CustomerCenterConfigData.Localization.VariableName.SUB_OFFER_DURATION, strLocalizedTotalDuration), TuplesKt.a(CustomerCenterConfigData.Localization.VariableName.SUB_OFFER_DURATION_2, strLocalizedTotalDuration2), TuplesKt.a(CustomerCenterConfigData.Localization.VariableName.SUB_OFFER_PRICE_2, pricingPhase2.getPrice().getFormatted()), TuplesKt.a(CustomerCenterConfigData.Localization.VariableName.DISCOUNTED_RECURRING_PAYMENT_PRICE_PER_PERIOD, PriceExtensionsKt.localizedPerPeriod(pricingPhase2.getPrice(), pricingPhase2.getBillingPeriod(), locale, false)), TuplesKt.a(CustomerCenterConfigData.Localization.VariableName.PRICE, strLocalizedPerPeriod), TuplesKt.a(CustomerCenterConfigData.Localization.VariableName.DISCOUNTED_RECURRING_PAYMENT_CYCLES, String.valueOf(billingCycleCount != null ? billingCycleCount.intValue() : 1)));
        OfferPaymentMode offerPaymentMode = pricingPhase2.getOfferPaymentMode();
        int i3 = offerPaymentMode == null ? -1 : WhenMappings.$EnumSwitchMapping$0[offerPaymentMode.ordinal()];
        return i3 != 2 ? i3 != 3 ? strLocalizedPerPeriod : replaceVariables(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.FREE_TRIAL_DISCOUNTED_RECURRING_PAYMENT_THEN_PRICE), mapMapOf) : replaceVariables(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.FREE_TRIAL_SINGLE_PAYMENT_THEN_PRICE), mapMapOf);
    }

    private static final String getTwoPhaseDescription(SubscriptionOption subscriptionOption, CustomerCenterConfigData.Localization localization, Locale locale) {
        PricingPhase pricingPhase = (PricingPhase) CollectionsKt.first((List) subscriptionOption.getPricingPhases());
        String strLocalizedTotalDuration = localizedTotalDuration(pricingPhase, locale);
        PricingPhase pricingPhase2 = (PricingPhase) CollectionsKt.last((List) subscriptionOption.getPricingPhases());
        String strLocalizedPerPeriod = PriceExtensionsKt.localizedPerPeriod(pricingPhase2.getPrice(), pricingPhase2.getBillingPeriod(), locale, false);
        Integer billingCycleCount = pricingPhase.getBillingCycleCount();
        Map mapMapOf = MapsKt.mapOf(TuplesKt.a(CustomerCenterConfigData.Localization.VariableName.SUB_OFFER_DURATION, strLocalizedTotalDuration), TuplesKt.a(CustomerCenterConfigData.Localization.VariableName.SUB_OFFER_PRICE, pricingPhase.getPrice().getFormatted()), TuplesKt.a(CustomerCenterConfigData.Localization.VariableName.PRICE, strLocalizedPerPeriod), TuplesKt.a(CustomerCenterConfigData.Localization.VariableName.DISCOUNTED_RECURRING_PAYMENT_PRICE_PER_PERIOD, PriceExtensionsKt.localizedPerPeriod(pricingPhase.getPrice(), pricingPhase.getBillingPeriod(), locale, false)), TuplesKt.a(CustomerCenterConfigData.Localization.VariableName.DISCOUNTED_RECURRING_PAYMENT_CYCLES, String.valueOf(billingCycleCount != null ? billingCycleCount.intValue() : 1)));
        OfferPaymentMode offerPaymentMode = pricingPhase.getOfferPaymentMode();
        int i3 = offerPaymentMode == null ? -1 : WhenMappings.$EnumSwitchMapping$0[offerPaymentMode.ordinal()];
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? strLocalizedPerPeriod : replaceVariables(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.DISCOUNTED_RECURRING_PAYMENT_THEN_PRICE), mapMapOf) : replaceVariables(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.SINGLE_PAYMENT_THEN_PRICE), mapMapOf) : replaceVariables(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.FREE_TRIAL_THEN_PRICE), mapMapOf);
    }

    private static final String localizedTotalDuration(PricingPhase pricingPhase, Locale locale) {
        Integer billingCycleCount = pricingPhase.getBillingCycleCount();
        String str = MeasureFormat.getInstance(locale, MeasureFormat.FormatWidth.WIDE).format(new Measure(Integer.valueOf((billingCycleCount != null ? billingCycleCount.intValue() : 1) * pricingPhase.getBillingPeriod().getValue()), PeriodExtensionsKt.getMeasureUnit(pricingPhase.getBillingPeriod().getUnit())));
        Intrinsics.checkNotNullExpressionValue(str, "getInstance(locale, Meas….unit.measureUnit),\n    )");
        return str;
    }

    private static final String replaceVariables(String str, final Map<CustomerCenterConfigData.Localization.VariableName, String> map) {
        return new Regex("\\{\\{\\s*([^}]+)\\s*\\}\\}").l(str, new Function1<MatchResult, CharSequence>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.extensions.SubscriptionOptionExtensionsKt.replaceVariables.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(MatchResult matchResult) {
                Object next;
                String str2;
                Intrinsics.checkNotNullParameter(matchResult, "matchResult");
                String string = StringsKt.t1((String) matchResult.b().get(1)).toString();
                Iterator<T> it = map.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(((CustomerCenterConfigData.Localization.VariableName) ((Map.Entry) next).getKey()).getIdentifier(), string)) {
                        break;
                    }
                }
                Map.Entry entry = (Map.Entry) next;
                return (entry == null || (str2 = (String) entry.getValue()) == null) ? matchResult.getValue() : str2;
            }
        });
    }
}
