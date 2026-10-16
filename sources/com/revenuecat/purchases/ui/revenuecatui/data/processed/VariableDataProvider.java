package com.revenuecat.purchases.ui.revenuecatui.data.processed;

import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PackageType;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PackageExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PriceExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public final class VariableDataProvider {
    public static final int $stable = 8;
    private final boolean preview;
    private final ResourceProvider resourceProvider;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PackageType.values().length];
            try {
                iArr[PackageType.LIFETIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PackageType.ANNUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PackageType.SIX_MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PackageType.THREE_MONTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PackageType.TWO_MONTH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PackageType.MONTHLY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PackageType.WEEKLY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PackageType.UNKNOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PackageType.CUSTOM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public VariableDataProvider(ResourceProvider resourceProvider, boolean z2) {
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        this.resourceProvider = resourceProvider;
        this.preview = z2;
    }

    private final PricingPhase getFirstIntroOfferToApply(Package r2) {
        PricingPhase freePhase;
        SubscriptionOption defaultOption = r2.getProduct().getDefaultOption();
        if (defaultOption != null && (freePhase = defaultOption.getFreePhase()) != null) {
            return freePhase;
        }
        if (defaultOption != null) {
            return defaultOption.getIntroPhase();
        }
        return null;
    }

    private final PricingPhase getSecondIntroOfferToApply(Package r3) {
        SubscriptionOption defaultOption = r3.getProduct().getDefaultOption();
        if ((defaultOption != null ? defaultOption.getFreePhase() : null) != null) {
            return defaultOption.getIntroPhase();
        }
        return null;
    }

    public final String firstIntroductoryOfferDuration(Package rcPackage, Locale locale) {
        Period billingPeriod;
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        PricingPhase firstIntroOfferToApply = getFirstIntroOfferToApply(rcPackage);
        if (firstIntroOfferToApply == null || (billingPeriod = firstIntroOfferToApply.getBillingPeriod()) == null) {
            return null;
        }
        return com.revenuecat.purchases.ui.revenuecatui.extensions.PeriodExtensionsKt.localizedPeriod$default(billingPeriod, locale, null, 2, null);
    }

    public final String getApplicationName() {
        return !this.preview ? this.resourceProvider.getApplicationName() : "Application Name";
    }

    public final String localizedFirstIntroductoryOfferPrice(Package rcPackage, Locale locale, boolean z2) {
        Price price;
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        PricingPhase firstIntroOfferToApply = getFirstIntroOfferToApply(rcPackage);
        if (firstIntroOfferToApply == null || (price = firstIntroOfferToApply.getPrice()) == null) {
            return null;
        }
        return price.getAmountMicros() == 0 ? price.getFormatted() : (z2 && VariableDataProviderKt.endsIn00Cents(price)) ? VariableDataProviderKt.getTruncatedFormatted(price, locale) : VariableDataProviderKt.getFormatted(price, locale);
    }

    public final String localizedPrice(Package rcPackage, Locale locale, boolean z2) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return PriceExtensionsKt.localized(rcPackage.getProduct().getPrice(), locale, z2);
    }

    public final String localizedPriceAndPerMonth(Package rcPackage, Locale locale, boolean z2) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (!PackageExtensionsKt.isSubscription(rcPackage) || PackageExtensionsKt.isMonthly(rcPackage)) {
            return localizedPricePerPeriod(rcPackage, locale, z2);
        }
        String strLocalizedAbbreviatedPeriod = com.revenuecat.purchases.ui.revenuecatui.extensions.PeriodExtensionsKt.localizedAbbreviatedPeriod(new Period(1, Period.Unit.MONTH, "P1M"), locale);
        return localizedPricePerPeriod(rcPackage, locale, z2) + " (" + localizedPricePerMonth(rcPackage, locale, z2) + '/' + strLocalizedAbbreviatedPeriod + ')';
    }

    public final String localizedPriceAndPerMonthFull(Package rcPackage, Locale locale, boolean z2) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        if (!PackageExtensionsKt.isSubscription(rcPackage) || PackageExtensionsKt.isMonthly(rcPackage)) {
            return localizedPricePerPeriodFull(rcPackage, locale, z2);
        }
        String strLocalizedUnitPeriod = com.revenuecat.purchases.ui.revenuecatui.extensions.PeriodExtensionsKt.localizedUnitPeriod(new Period(1, Period.Unit.MONTH, "P1M"), locale);
        return localizedPricePerPeriodFull(rcPackage, locale, z2) + " (" + localizedPricePerMonth(rcPackage, locale, z2) + '/' + strLocalizedUnitPeriod + ')';
    }

    public final String localizedPricePerDay(Package rcPackage, Locale locale, boolean z2) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Price pricePricePerDay = rcPackage.getProduct().pricePerDay(locale);
        if (pricePricePerDay == null) {
            return null;
        }
        return (z2 && VariableDataProviderKt.endsIn00Cents(pricePricePerDay)) ? VariableDataProviderKt.getTruncatedFormatted(pricePricePerDay, locale) : VariableDataProviderKt.getFormatted(pricePricePerDay, locale);
    }

    public final String localizedPricePerMonth(Package rcPackage, Locale locale, boolean z2) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Price pricePricePerMonth = rcPackage.getProduct().pricePerMonth(locale);
        if (pricePricePerMonth == null) {
            return null;
        }
        return (z2 && VariableDataProviderKt.endsIn00Cents(pricePricePerMonth)) ? VariableDataProviderKt.getTruncatedFormatted(pricePricePerMonth, locale) : VariableDataProviderKt.getFormatted(pricePricePerMonth, locale);
    }

    public final String localizedPricePerPeriod(Package rcPackage, Locale locale, boolean z2) {
        String strLocalizedPerPeriod;
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        StoreProduct product = rcPackage.getProduct();
        Period period = product.getPeriod();
        return (period == null || (strLocalizedPerPeriod = PriceExtensionsKt.localizedPerPeriod(product.getPrice(), period, locale, z2)) == null) ? PriceExtensionsKt.localized(product.getPrice(), locale, z2) : strLocalizedPerPeriod;
    }

    public final String localizedPricePerPeriodFull(Package rcPackage, Locale locale, boolean z2) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        StoreProduct product = rcPackage.getProduct();
        String strLocalized = PriceExtensionsKt.localized(product.getPrice(), locale, z2);
        Period period = product.getPeriod();
        if (period != null) {
            String str = strLocalized + '/' + com.revenuecat.purchases.ui.revenuecatui.extensions.PeriodExtensionsKt.localizedUnitPeriod(period, locale);
            if (str != null) {
                return str;
            }
        }
        return strLocalized;
    }

    public final String localizedPricePerWeek(Package rcPackage, Locale locale, boolean z2) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Price pricePricePerWeek = rcPackage.getProduct().pricePerWeek(locale);
        if (pricePricePerWeek == null) {
            return null;
        }
        return (z2 && VariableDataProviderKt.endsIn00Cents(pricePricePerWeek)) ? VariableDataProviderKt.getTruncatedFormatted(pricePricePerWeek, locale) : VariableDataProviderKt.getFormatted(pricePricePerWeek, locale);
    }

    public final String localizedPricePerYear(Package rcPackage, Locale locale, boolean z2) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Price pricePricePerYear = rcPackage.getProduct().pricePerYear(locale);
        if (pricePricePerYear == null) {
            return null;
        }
        return (z2 && VariableDataProviderKt.endsIn00Cents(pricePricePerYear)) ? VariableDataProviderKt.getTruncatedFormatted(pricePricePerYear, locale) : VariableDataProviderKt.getFormatted(pricePricePerYear, locale);
    }

    public final String localizedRelativeDiscount(Double d3) {
        return VariableDataProviderKt.localizedDiscount(this.resourceProvider, d3);
    }

    public final String localizedSecondIntroductoryOfferPrice(Package rcPackage, Locale locale, boolean z2) {
        Price price;
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        PricingPhase secondIntroOfferToApply = getSecondIntroOfferToApply(rcPackage);
        if (secondIntroOfferToApply == null || (price = secondIntroOfferToApply.getPrice()) == null) {
            return null;
        }
        return price.getAmountMicros() == 0 ? price.getFormatted() : (z2 && VariableDataProviderKt.endsIn00Cents(price)) ? VariableDataProviderKt.getTruncatedFormatted(price, locale) : VariableDataProviderKt.getFormatted(price, locale);
    }

    public final String periodLength(Package rcPackage, Locale locale) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Period period = rcPackage.getProduct().getPeriod();
        if (period != null) {
            return com.revenuecat.purchases.ui.revenuecatui.extensions.PeriodExtensionsKt.localizedUnitPeriod(period, locale);
        }
        return null;
    }

    public final String periodName(Package rcPackage) {
        Integer numValueOf;
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        if (rcPackage.getPackageType() == PackageType.CUSTOM || rcPackage.getPackageType() == PackageType.UNKNOWN) {
            return rcPackage.getIdentifier();
        }
        switch (WhenMappings.$EnumSwitchMapping$0[rcPackage.getPackageType().ordinal()]) {
            case 1:
                numValueOf = Integer.valueOf(R.string.lifetime);
                break;
            case 2:
                numValueOf = Integer.valueOf(R.string.annual);
                break;
            case 3:
                numValueOf = Integer.valueOf(R.string.semester);
                break;
            case 4:
                numValueOf = Integer.valueOf(R.string.quarter);
                break;
            case 5:
                numValueOf = Integer.valueOf(R.string.bimonthly);
                break;
            case 6:
                numValueOf = Integer.valueOf(R.string.monthly);
                break;
            case 7:
                numValueOf = Integer.valueOf(R.string.weekly);
                break;
            case 8:
            case 9:
                numValueOf = null;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        if (numValueOf == null) {
            return null;
        }
        return this.resourceProvider.getString(numValueOf.intValue(), new Object[0]);
    }

    public final String periodNameAbbreviation(Package rcPackage, Locale locale) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Period period = rcPackage.getProduct().getPeriod();
        if (period != null) {
            return com.revenuecat.purchases.ui.revenuecatui.extensions.PeriodExtensionsKt.localizedAbbreviatedPeriod(period, locale);
        }
        return null;
    }

    public final String productName(Package rcPackage) {
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        return rcPackage.getProduct().getName();
    }

    public final String secondIntroductoryOfferDuration(Package rcPackage, Locale locale) {
        Period billingPeriod;
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        PricingPhase secondIntroOfferToApply = getSecondIntroOfferToApply(rcPackage);
        if (secondIntroOfferToApply == null || (billingPeriod = secondIntroOfferToApply.getBillingPeriod()) == null) {
            return null;
        }
        return com.revenuecat.purchases.ui.revenuecatui.extensions.PeriodExtensionsKt.localizedPeriod$default(billingPeriod, locale, null, 2, null);
    }

    public final String subscriptionDuration(Package rcPackage, Locale locale) {
        String strLocalizedPeriod$default;
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Period period = rcPackage.getProduct().getPeriod();
        return (period == null || (strLocalizedPeriod$default = com.revenuecat.purchases.ui.revenuecatui.extensions.PeriodExtensionsKt.localizedPeriod$default(period, locale, null, 2, null)) == null) ? periodName(rcPackage) : strLocalizedPeriod$default;
    }

    public final String subscriptionDurationInMonths(Package rcPackage, Locale locale) {
        Period periodNormalizedMonths;
        String strLocalizedPeriod$default;
        Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Period period = rcPackage.getProduct().getPeriod();
        return (period == null || (periodNormalizedMonths = VariableDataProviderKt.normalizedMonths(period)) == null || (strLocalizedPeriod$default = com.revenuecat.purchases.ui.revenuecatui.extensions.PeriodExtensionsKt.localizedPeriod$default(periodNormalizedMonths, locale, null, 2, null)) == null) ? periodName(rcPackage) : strLocalizedPeriod$default;
    }

    public /* synthetic */ VariableDataProvider(ResourceProvider resourceProvider, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(resourceProvider, (i3 & 2) != 0 ? false : z2);
    }
}
