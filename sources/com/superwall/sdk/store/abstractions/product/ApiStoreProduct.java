package com.superwall.sdk.store.abstractions.product;

import com.superwall.sdk.store.abstractions.product.ApiStoreProduct;
import com.superwall.sdk.store.abstractions.product.StoreProductType;
import com.superwall.sdk.store.abstractions.product.SubscriptionPeriod;
import com.superwall.sdk.store.testmode.models.SuperwallProduct;
import com.superwall.sdk.store.testmode.models.SuperwallProductPlatform;
import com.superwall.sdk.store.testmode.models.SuperwallProductPrice;
import com.superwall.sdk.store.testmode.models.SuperwallProductSubscription;
import com.superwall.sdk.store.testmode.models.SuperwallSubscriptionPeriod;
import com.superwall.sdk.utilities.DateUtils;
import com.superwall.sdk.utilities.DateUtilsKt;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public class ApiStoreProduct implements StoreProductType {
    private final Lazy currencyCode$delegate;
    private final Lazy currencySymbol$delegate;
    private final Lazy dailyPrice$delegate;
    private final Lazy hasFreeTrial$delegate;
    private final Lazy languageCode$delegate;
    private final Lazy locale$delegate;
    private final Lazy localizedPrice$delegate;
    private final Lazy localizedSubscriptionPeriod$delegate;
    private final Lazy localizedTrialPeriodPrice$delegate;
    private final Lazy monthlyPrice$delegate;
    private final Lazy period$delegate;
    private final Lazy periodDays$delegate;
    private final Lazy periodDaysString$delegate;
    private final Lazy periodMonths$delegate;
    private final Lazy periodMonthsString$delegate;
    private final Lazy periodWeeks$delegate;
    private final Lazy periodWeeksString$delegate;
    private final Lazy periodYears$delegate;
    private final Lazy periodYearsString$delegate;
    private final Lazy periodly$delegate;
    private final Lazy price$delegate;
    private final Lazy priceFormatter$delegate;
    private final PriceFormatterProvider priceFormatterProvider;
    private final Lazy regionCode$delegate;
    private final Lazy subscriptionPeriod$delegate;
    private final SuperwallProduct superwallProduct;
    private final Lazy trialPeriodDays$delegate;
    private final Lazy trialPeriodDaysString$delegate;
    private final Lazy trialPeriodEndDate$delegate;
    private final Lazy trialPeriodEndDateString$delegate;
    private final Lazy trialPeriodMonths$delegate;
    private final Lazy trialPeriodMonthsString$delegate;
    private final BigDecimal trialPeriodPrice;
    private final Lazy trialPeriodText$delegate;
    private final Lazy trialPeriodWeeks$delegate;
    private final Lazy trialPeriodWeeksString$delegate;
    private final Lazy trialPeriodYears$delegate;
    private final Lazy trialPeriodYearsString$delegate;
    private final Lazy trialSubscriptionPeriod$delegate;
    private final Lazy weeklyPrice$delegate;
    private final Lazy yearlyPrice$delegate;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SuperwallSubscriptionPeriod.values().length];
            try {
                iArr[SuperwallSubscriptionPeriod.DAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SuperwallSubscriptionPeriod.WEEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SuperwallSubscriptionPeriod.MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SuperwallSubscriptionPeriod.YEAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SubscriptionPeriod.Unit.values().length];
            try {
                iArr2[SubscriptionPeriod.Unit.day.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[SubscriptionPeriod.Unit.week.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[SubscriptionPeriod.Unit.month.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[SubscriptionPeriod.Unit.year.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public ApiStoreProduct(SuperwallProduct superwallProduct) {
        Intrinsics.checkNotNullParameter(superwallProduct, "superwallProduct");
        this.superwallProduct = superwallProduct;
        this.priceFormatterProvider = new PriceFormatterProvider();
        this.priceFormatter$delegate = LazyKt.b(new Function0() { // from class: k0.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.priceFormatter_delegate$lambda$1(this.f139643a);
            }
        });
        this.price$delegate = LazyKt.b(new Function0() { // from class: k0.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.price_delegate$lambda$2(this.f139651a);
            }
        });
        this.localizedPrice$delegate = LazyKt.b(new Function0() { // from class: k0.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.localizedPrice_delegate$lambda$3(this.f139688a);
            }
        });
        this.subscriptionPeriod$delegate = LazyKt.b(new Function0() { // from class: k0.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.subscriptionPeriod_delegate$lambda$5(this.f139714a);
            }
        });
        this.localizedSubscriptionPeriod$delegate = LazyKt.b(new Function0() { // from class: k0.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.localizedSubscriptionPeriod_delegate$lambda$7(this.f139717a);
            }
        });
        this.period$delegate = LazyKt.b(new Function0() { // from class: k0.a0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.period_delegate$lambda$9(this.f139644a);
            }
        });
        this.periodly$delegate = LazyKt.b(new Function0() { // from class: k0.b0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.periodly_delegate$lambda$11(this.f139648a);
            }
        });
        this.periodWeeks$delegate = LazyKt.b(new Function0() { // from class: k0.c0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(ApiStoreProduct.periodWeeks_delegate$lambda$13(this.f139652a));
            }
        });
        this.periodWeeksString$delegate = LazyKt.b(new Function0() { // from class: k0.d0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.periodWeeksString_delegate$lambda$14(this.f139656a);
            }
        });
        this.periodMonths$delegate = LazyKt.b(new Function0() { // from class: k0.e0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(ApiStoreProduct.periodMonths_delegate$lambda$16(this.f139660a));
            }
        });
        this.periodMonthsString$delegate = LazyKt.b(new Function0() { // from class: k0.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.periodMonthsString_delegate$lambda$17(this.f139683a);
            }
        });
        this.periodYears$delegate = LazyKt.b(new Function0() { // from class: k0.w
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(ApiStoreProduct.periodYears_delegate$lambda$19(this.f139709a));
            }
        });
        this.periodYearsString$delegate = LazyKt.b(new Function0() { // from class: k0.f0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.periodYearsString_delegate$lambda$20(this.f139664a);
            }
        });
        this.periodDays$delegate = LazyKt.b(new Function0() { // from class: k0.g0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(ApiStoreProduct.periodDays_delegate$lambda$22(this.f139668a));
            }
        });
        this.periodDaysString$delegate = LazyKt.b(new Function0() { // from class: k0.h0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.periodDaysString_delegate$lambda$23(this.f139672a);
            }
        });
        this.dailyPrice$delegate = LazyKt.b(new Function0() { // from class: k0.i0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.dailyPrice_delegate$lambda$24(this.f139675a);
            }
        });
        this.weeklyPrice$delegate = LazyKt.b(new Function0() { // from class: k0.j0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.weeklyPrice_delegate$lambda$25(this.f139678a);
            }
        });
        this.monthlyPrice$delegate = LazyKt.b(new Function0() { // from class: k0.k0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.monthlyPrice_delegate$lambda$26(this.f139681a);
            }
        });
        this.yearlyPrice$delegate = LazyKt.b(new Function0() { // from class: k0.l0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.yearlyPrice_delegate$lambda$27(this.f139684a);
            }
        });
        this.hasFreeTrial$delegate = LazyKt.b(new Function0() { // from class: k0.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(ApiStoreProduct.hasFreeTrial_delegate$lambda$28(this.f139647a));
            }
        });
        this.localizedTrialPeriodPrice$delegate = LazyKt.b(new Function0() { // from class: k0.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.localizedTrialPeriodPrice_delegate$lambda$29(this.f139655a);
            }
        });
        BigDecimal ZERO = BigDecimal.ZERO;
        Intrinsics.checkNotNullExpressionValue(ZERO, "ZERO");
        this.trialPeriodPrice = ZERO;
        this.trialSubscriptionPeriod$delegate = LazyKt.b(new Function0() { // from class: k0.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.trialSubscriptionPeriod_delegate$lambda$30(this.f139659a);
            }
        });
        this.trialPeriodEndDate$delegate = LazyKt.b(new Function0() { // from class: k0.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.trialPeriodEndDate_delegate$lambda$31(this.f139663a);
            }
        });
        this.trialPeriodEndDateString$delegate = LazyKt.b(new Function0() { // from class: k0.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.trialPeriodEndDateString_delegate$lambda$33(this.f139667a);
            }
        });
        this.trialPeriodDays$delegate = LazyKt.b(new Function0() { // from class: k0.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(ApiStoreProduct.trialPeriodDays_delegate$lambda$35(this.f139671a));
            }
        });
        this.trialPeriodDaysString$delegate = LazyKt.b(new Function0() { // from class: k0.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.trialPeriodDaysString_delegate$lambda$36(this.f139674a);
            }
        });
        this.trialPeriodWeeks$delegate = LazyKt.b(new Function0() { // from class: k0.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(ApiStoreProduct.trialPeriodWeeks_delegate$lambda$38(this.f139677a));
            }
        });
        this.trialPeriodWeeksString$delegate = LazyKt.b(new Function0() { // from class: k0.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.trialPeriodWeeksString_delegate$lambda$39(this.f139680a);
            }
        });
        this.trialPeriodMonths$delegate = LazyKt.b(new Function0() { // from class: k0.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(ApiStoreProduct.trialPeriodMonths_delegate$lambda$41(this.f139685a));
            }
        });
        this.trialPeriodMonthsString$delegate = LazyKt.b(new Function0() { // from class: k0.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.trialPeriodMonthsString_delegate$lambda$42(this.f139686a);
            }
        });
        this.trialPeriodYears$delegate = LazyKt.b(new Function0() { // from class: k0.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(ApiStoreProduct.trialPeriodYears_delegate$lambda$44(this.f139691a));
            }
        });
        this.trialPeriodYearsString$delegate = LazyKt.b(new Function0() { // from class: k0.q
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.trialPeriodYearsString_delegate$lambda$45(this.f139694a);
            }
        });
        this.trialPeriodText$delegate = LazyKt.b(new Function0() { // from class: k0.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.trialPeriodText_delegate$lambda$46(this.f139696a);
            }
        });
        this.locale$delegate = LazyKt.b(new Function0() { // from class: k0.s
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.locale_delegate$lambda$47();
            }
        });
        this.languageCode$delegate = LazyKt.b(new Function0() { // from class: k0.t
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.languageCode_delegate$lambda$48();
            }
        });
        this.currencyCode$delegate = LazyKt.b(new Function0() { // from class: k0.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.currencyCode_delegate$lambda$49(this.f139703a);
            }
        });
        this.currencySymbol$delegate = LazyKt.b(new Function0() { // from class: k0.v
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.currencySymbol_delegate$lambda$51(this.f139706a);
            }
        });
        this.regionCode$delegate = LazyKt.b(new Function0() { // from class: k0.x
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ApiStoreProduct.regionCode_delegate$lambda$52();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String currencyCode_delegate$lambda$49(ApiStoreProduct apiStoreProduct) {
        SuperwallProductPrice price = apiStoreProduct.superwallProduct.getPrice();
        if (price != null) {
            return price.getCurrency();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String currencySymbol_delegate$lambda$51(ApiStoreProduct apiStoreProduct) {
        String currencyCode = apiStoreProduct.getCurrencyCode();
        if (currencyCode == null) {
            return null;
        }
        try {
            return Currency.getInstance(currencyCode).getSymbol();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String dailyPrice_delegate$lambda$24(ApiStoreProduct apiStoreProduct) {
        String str;
        String str2;
        SubscriptionPeriod subscriptionPeriod = apiStoreProduct.getSubscriptionPeriod();
        if (subscriptionPeriod == null) {
            return "n/a";
        }
        BigDecimal price = apiStoreProduct.getPrice();
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (price.compareTo(bigDecimal) == 0) {
            NumberFormat priceFormatter = apiStoreProduct.getPriceFormatter();
            return (priceFormatter == null || (str2 = priceFormatter.format(bigDecimal)) == null) ? "$0.00" : str2;
        }
        NumberFormat priceFormatter2 = apiStoreProduct.getPriceFormatter();
        return (priceFormatter2 == null || (str = priceFormatter2.format(subscriptionPeriod.pricePerDay(apiStoreProduct.getPrice()))) == null) ? "n/a" : str;
    }

    private final NumberFormat getPriceFormatter() {
        return (NumberFormat) this.priceFormatter$delegate.getValue();
    }

    private final int getTrialDays() {
        Integer trialPeriodDays;
        SuperwallProductSubscription subscription = this.superwallProduct.getSubscription();
        if (subscription == null || (trialPeriodDays = subscription.getTrialPeriodDays()) == null) {
            return 0;
        }
        return trialPeriodDays.intValue();
    }

    private final SubscriptionPeriod getTrialSubscriptionPeriod() {
        return (SubscriptionPeriod) this.trialSubscriptionPeriod$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasFreeTrial_delegate$lambda$28(ApiStoreProduct apiStoreProduct) {
        return apiStoreProduct.getTrialDays() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String languageCode_delegate$lambda$48() {
        return Locale.getDefault().getLanguage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String locale_delegate$lambda$47() {
        String string = Locale.getDefault().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String localizedPrice_delegate$lambda$3(ApiStoreProduct apiStoreProduct) {
        String str;
        NumberFormat priceFormatter = apiStoreProduct.getPriceFormatter();
        if (priceFormatter != null && (str = priceFormatter.format(apiStoreProduct.getPrice())) != null) {
            return str;
        }
        String currencySymbol = apiStoreProduct.getCurrencySymbol();
        if (currencySymbol == null) {
            currencySymbol = "$";
        }
        return currencySymbol + apiStoreProduct.getPrice();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String localizedSubscriptionPeriod_delegate$lambda$7(ApiStoreProduct apiStoreProduct) {
        String str;
        SubscriptionPeriod subscriptionPeriod = apiStoreProduct.getSubscriptionPeriod();
        if (subscriptionPeriod == null) {
            return "";
        }
        int value = subscriptionPeriod.getValue();
        int i3 = WhenMappings.$EnumSwitchMapping$1[subscriptionPeriod.getUnit().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (value == 1) {
                        str = "1 year";
                    } else {
                        str = value + " years";
                    }
                } else if (value == 1) {
                    str = "1 month";
                } else {
                    str = value + " months";
                }
            } else if (value == 1) {
                str = "1 week";
            } else {
                str = value + " weeks";
            }
        } else if (value == 1) {
            str = "1 day";
        } else {
            str = value + " days";
        }
        return str == null ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String localizedTrialPeriodPrice_delegate$lambda$29(ApiStoreProduct apiStoreProduct) {
        String str;
        NumberFormat priceFormatter = apiStoreProduct.getPriceFormatter();
        return (priceFormatter == null || (str = priceFormatter.format(apiStoreProduct.getTrialPeriodPrice())) == null) ? "$0.00" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String monthlyPrice_delegate$lambda$26(ApiStoreProduct apiStoreProduct) {
        String str;
        String str2;
        SubscriptionPeriod subscriptionPeriod = apiStoreProduct.getSubscriptionPeriod();
        if (subscriptionPeriod == null) {
            return "n/a";
        }
        BigDecimal price = apiStoreProduct.getPrice();
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (price.compareTo(bigDecimal) == 0) {
            NumberFormat priceFormatter = apiStoreProduct.getPriceFormatter();
            return (priceFormatter == null || (str2 = priceFormatter.format(bigDecimal)) == null) ? "$0.00" : str2;
        }
        NumberFormat priceFormatter2 = apiStoreProduct.getPriceFormatter();
        return (priceFormatter2 == null || (str = priceFormatter2.format(subscriptionPeriod.pricePerMonth(apiStoreProduct.getPrice()))) == null) ? "n/a" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String periodDaysString_delegate$lambda$23(ApiStoreProduct apiStoreProduct) {
        return String.valueOf(apiStoreProduct.getPeriodDays());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int periodDays_delegate$lambda$22(ApiStoreProduct apiStoreProduct) {
        SubscriptionPeriod subscriptionPeriod = apiStoreProduct.getSubscriptionPeriod();
        if (subscriptionPeriod == null) {
            return 0;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$1[subscriptionPeriod.getUnit().ordinal()];
        if (i3 == 1) {
            return subscriptionPeriod.getValue();
        }
        if (i3 == 2) {
            return subscriptionPeriod.getValue() * 7;
        }
        if (i3 == 3) {
            return subscriptionPeriod.getValue() * 30;
        }
        if (i3 == 4) {
            return subscriptionPeriod.getValue() * 365;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String periodMonthsString_delegate$lambda$17(ApiStoreProduct apiStoreProduct) {
        return String.valueOf(apiStoreProduct.getPeriodMonths());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int periodMonths_delegate$lambda$16(ApiStoreProduct apiStoreProduct) {
        SubscriptionPeriod subscriptionPeriod = apiStoreProduct.getSubscriptionPeriod();
        if (subscriptionPeriod == null) {
            return 0;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$1[subscriptionPeriod.getUnit().ordinal()];
        if (i3 == 1) {
            return subscriptionPeriod.getValue() / 30;
        }
        if (i3 == 2) {
            return subscriptionPeriod.getValue() / 4;
        }
        if (i3 == 3) {
            return subscriptionPeriod.getValue();
        }
        if (i3 == 4) {
            return subscriptionPeriod.getValue() * 12;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String periodWeeksString_delegate$lambda$14(ApiStoreProduct apiStoreProduct) {
        return String.valueOf(apiStoreProduct.getPeriodWeeks());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int periodWeeks_delegate$lambda$13(ApiStoreProduct apiStoreProduct) {
        SubscriptionPeriod subscriptionPeriod = apiStoreProduct.getSubscriptionPeriod();
        if (subscriptionPeriod == null) {
            return 0;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$1[subscriptionPeriod.getUnit().ordinal()];
        if (i3 == 1) {
            return subscriptionPeriod.getValue() / 7;
        }
        if (i3 == 2) {
            return subscriptionPeriod.getValue();
        }
        if (i3 == 3) {
            return subscriptionPeriod.getValue() * 4;
        }
        if (i3 == 4) {
            return subscriptionPeriod.getValue() * 52;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String periodYearsString_delegate$lambda$20(ApiStoreProduct apiStoreProduct) {
        return String.valueOf(apiStoreProduct.getPeriodYears());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int periodYears_delegate$lambda$19(ApiStoreProduct apiStoreProduct) {
        SubscriptionPeriod subscriptionPeriod = apiStoreProduct.getSubscriptionPeriod();
        if (subscriptionPeriod == null) {
            return 0;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$1[subscriptionPeriod.getUnit().ordinal()];
        if (i3 == 1) {
            return subscriptionPeriod.getValue() / 365;
        }
        if (i3 == 2) {
            return subscriptionPeriod.getValue() / 52;
        }
        if (i3 == 3) {
            return subscriptionPeriod.getValue() / 12;
        }
        if (i3 == 4) {
            return subscriptionPeriod.getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String period_delegate$lambda$9(ApiStoreProduct apiStoreProduct) {
        SubscriptionPeriod subscriptionPeriod = apiStoreProduct.getSubscriptionPeriod();
        if (subscriptionPeriod == null) {
            return "";
        }
        int i3 = WhenMappings.$EnumSwitchMapping$1[subscriptionPeriod.getUnit().ordinal()];
        if (i3 == 1) {
            return subscriptionPeriod.getValue() == 7 ? "week" : "day";
        }
        if (i3 == 2) {
            return "week";
        }
        if (i3 == 3) {
            int value = subscriptionPeriod.getValue();
            return value != 2 ? value != 3 ? value != 6 ? "month" : "6 months" : "quarter" : "2 months";
        }
        if (i3 == 4) {
            return "year";
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String periodly_delegate$lambda$11(ApiStoreProduct apiStoreProduct) {
        String str;
        SubscriptionPeriod subscriptionPeriod = apiStoreProduct.getSubscriptionPeriod();
        if (subscriptionPeriod == null) {
            return "";
        }
        if (WhenMappings.$EnumSwitchMapping$1[subscriptionPeriod.getUnit().ordinal()] == 3) {
            int value = subscriptionPeriod.getValue();
            if (value == 2 || value == 6) {
                str = "every " + apiStoreProduct.getPeriod();
            } else {
                str = apiStoreProduct.getPeriod() + "ly";
            }
        } else {
            str = apiStoreProduct.getPeriod() + "ly";
        }
        return str == null ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NumberFormat priceFormatter_delegate$lambda$1(ApiStoreProduct apiStoreProduct) {
        String currencyCode = apiStoreProduct.getCurrencyCode();
        if (currencyCode != null) {
            return apiStoreProduct.priceFormatterProvider.priceFormatter(currencyCode);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BigDecimal price_delegate$lambda$2(ApiStoreProduct apiStoreProduct) {
        SuperwallProductPrice price = apiStoreProduct.superwallProduct.getPrice();
        return new BigDecimal(price != null ? price.getAmount() : 0).divide(new BigDecimal(100), 2, RoundingMode.DOWN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String regionCode_delegate$lambda$52() {
        return Locale.getDefault().getCountry();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SubscriptionPeriod subscriptionPeriod_delegate$lambda$5(ApiStoreProduct apiStoreProduct) {
        SubscriptionPeriod.Unit unit;
        SuperwallProductSubscription subscription = apiStoreProduct.superwallProduct.getSubscription();
        if (subscription == null) {
            return null;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[subscription.getPeriod().ordinal()];
        if (i3 == 1) {
            unit = SubscriptionPeriod.Unit.day;
        } else if (i3 == 2) {
            unit = SubscriptionPeriod.Unit.week;
        } else if (i3 == 3) {
            unit = SubscriptionPeriod.Unit.month;
        } else {
            if (i3 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            unit = SubscriptionPeriod.Unit.year;
        }
        return new SubscriptionPeriod(subscription.getPeriodCount(), unit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String trialPeriodDaysString_delegate$lambda$36(ApiStoreProduct apiStoreProduct) {
        return String.valueOf(apiStoreProduct.getTrialPeriodDays());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int trialPeriodDays_delegate$lambda$35(ApiStoreProduct apiStoreProduct) {
        SubscriptionPeriod trialSubscriptionPeriod = apiStoreProduct.getTrialSubscriptionPeriod();
        if (trialSubscriptionPeriod == null) {
            return 0;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$1[trialSubscriptionPeriod.getUnit().ordinal()];
        if (i3 == 1) {
            return trialSubscriptionPeriod.getValue();
        }
        if (i3 == 2) {
            return trialSubscriptionPeriod.getValue() * 7;
        }
        if (i3 == 3) {
            return trialSubscriptionPeriod.getValue() * 30;
        }
        if (i3 == 4) {
            return trialSubscriptionPeriod.getValue() * 365;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String trialPeriodEndDateString_delegate$lambda$33(ApiStoreProduct apiStoreProduct) {
        String str;
        Date trialPeriodEndDate = apiStoreProduct.getTrialPeriodEndDate();
        return (trialPeriodEndDate == null || (str = DateUtilsKt.localizedDateFormat(DateUtils.INSTANCE.getMMM_dd_yyyy()).format(trialPeriodEndDate)) == null) ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Date trialPeriodEndDate_delegate$lambda$31(ApiStoreProduct apiStoreProduct) {
        if (apiStoreProduct.getTrialDays() <= 0) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(6, apiStoreProduct.getTrialDays());
        return calendar.getTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String trialPeriodMonthsString_delegate$lambda$42(ApiStoreProduct apiStoreProduct) {
        return String.valueOf(apiStoreProduct.getTrialPeriodMonths());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int trialPeriodMonths_delegate$lambda$41(ApiStoreProduct apiStoreProduct) {
        SubscriptionPeriod trialSubscriptionPeriod = apiStoreProduct.getTrialSubscriptionPeriod();
        if (trialSubscriptionPeriod == null) {
            return 0;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$1[trialSubscriptionPeriod.getUnit().ordinal()];
        if (i3 == 1) {
            return trialSubscriptionPeriod.getValue() / 30;
        }
        if (i3 == 2) {
            return trialSubscriptionPeriod.getValue() / 4;
        }
        if (i3 == 3) {
            return trialSubscriptionPeriod.getValue();
        }
        if (i3 == 4) {
            return trialSubscriptionPeriod.getValue() * 12;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String trialPeriodText_delegate$lambda$46(ApiStoreProduct apiStoreProduct) {
        if (apiStoreProduct.getTrialDays() <= 0) {
            return "";
        }
        return apiStoreProduct.getTrialDays() + "-day";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String trialPeriodWeeksString_delegate$lambda$39(ApiStoreProduct apiStoreProduct) {
        return String.valueOf(apiStoreProduct.getTrialPeriodWeeks());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int trialPeriodWeeks_delegate$lambda$38(ApiStoreProduct apiStoreProduct) {
        SubscriptionPeriod trialSubscriptionPeriod = apiStoreProduct.getTrialSubscriptionPeriod();
        if (trialSubscriptionPeriod == null) {
            return 0;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$1[trialSubscriptionPeriod.getUnit().ordinal()];
        if (i3 == 1) {
            return trialSubscriptionPeriod.getValue() / 7;
        }
        if (i3 == 2) {
            return trialSubscriptionPeriod.getValue();
        }
        if (i3 == 3) {
            return trialSubscriptionPeriod.getValue() * 4;
        }
        if (i3 == 4) {
            return trialSubscriptionPeriod.getValue() * 52;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String trialPeriodYearsString_delegate$lambda$45(ApiStoreProduct apiStoreProduct) {
        return String.valueOf(apiStoreProduct.getTrialPeriodYears());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int trialPeriodYears_delegate$lambda$44(ApiStoreProduct apiStoreProduct) {
        SubscriptionPeriod trialSubscriptionPeriod = apiStoreProduct.getTrialSubscriptionPeriod();
        if (trialSubscriptionPeriod == null) {
            return 0;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$1[trialSubscriptionPeriod.getUnit().ordinal()];
        if (i3 == 1) {
            return trialSubscriptionPeriod.getValue() / 365;
        }
        if (i3 == 2) {
            return trialSubscriptionPeriod.getValue() / 52;
        }
        if (i3 == 3) {
            return trialSubscriptionPeriod.getValue() / 12;
        }
        if (i3 == 4) {
            return trialSubscriptionPeriod.getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SubscriptionPeriod trialSubscriptionPeriod_delegate$lambda$30(ApiStoreProduct apiStoreProduct) {
        if (apiStoreProduct.getTrialDays() <= 0) {
            return null;
        }
        return new SubscriptionPeriod(apiStoreProduct.getTrialDays(), SubscriptionPeriod.Unit.day).normalized();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String weeklyPrice_delegate$lambda$25(ApiStoreProduct apiStoreProduct) {
        String str;
        String str2;
        SubscriptionPeriod subscriptionPeriod = apiStoreProduct.getSubscriptionPeriod();
        if (subscriptionPeriod == null) {
            return "n/a";
        }
        BigDecimal price = apiStoreProduct.getPrice();
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (price.compareTo(bigDecimal) == 0) {
            NumberFormat priceFormatter = apiStoreProduct.getPriceFormatter();
            return (priceFormatter == null || (str2 = priceFormatter.format(bigDecimal)) == null) ? "$0.00" : str2;
        }
        NumberFormat priceFormatter2 = apiStoreProduct.getPriceFormatter();
        return (priceFormatter2 == null || (str = priceFormatter2.format(subscriptionPeriod.pricePerWeek(apiStoreProduct.getPrice()))) == null) ? "n/a" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String yearlyPrice_delegate$lambda$27(ApiStoreProduct apiStoreProduct) {
        String str;
        String str2;
        SubscriptionPeriod subscriptionPeriod = apiStoreProduct.getSubscriptionPeriod();
        if (subscriptionPeriod == null) {
            return "n/a";
        }
        BigDecimal price = apiStoreProduct.getPrice();
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (Intrinsics.areEqual(price, bigDecimal)) {
            NumberFormat priceFormatter = apiStoreProduct.getPriceFormatter();
            return (priceFormatter == null || (str2 = priceFormatter.format(bigDecimal)) == null) ? "$0.00" : str2;
        }
        NumberFormat priceFormatter2 = apiStoreProduct.getPriceFormatter();
        return (priceFormatter2 == null || (str = priceFormatter2.format(subscriptionPeriod.pricePerYear(apiStoreProduct.getPrice()))) == null) ? "n/a" : str;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public Map<String, String> getAttributes() {
        return StoreProductType.DefaultImpls.getAttributes(this);
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getCurrencyCode() {
        return (String) this.currencyCode$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getCurrencySymbol() {
        return (String) this.currencySymbol$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getDailyPrice() {
        return (String) this.dailyPrice$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getFullIdentifier() {
        return this.superwallProduct.getIdentifier();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public boolean getHasFreeTrial() {
        return ((Boolean) this.hasFreeTrial$delegate.getValue()).booleanValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getLanguageCode() {
        return (String) this.languageCode$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getLocale() {
        return (String) this.locale$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getLocalizedPrice() {
        return (String) this.localizedPrice$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getLocalizedSubscriptionPeriod() {
        return (String) this.localizedSubscriptionPeriod$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getLocalizedTrialPeriodPrice() {
        return (String) this.localizedTrialPeriodPrice$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getMonthlyPrice() {
        return (String) this.monthlyPrice$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getPeriod() {
        return (String) this.period$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getPeriodDays() {
        return ((Number) this.periodDays$delegate.getValue()).intValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getPeriodDaysString() {
        return (String) this.periodDaysString$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getPeriodMonths() {
        return ((Number) this.periodMonths$delegate.getValue()).intValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getPeriodMonthsString() {
        return (String) this.periodMonthsString$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getPeriodWeeks() {
        return ((Number) this.periodWeeks$delegate.getValue()).intValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getPeriodWeeksString() {
        return (String) this.periodWeeksString$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getPeriodYears() {
        return ((Number) this.periodYears$delegate.getValue()).intValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getPeriodYearsString() {
        return (String) this.periodYearsString$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getPeriodly() {
        return (String) this.periodly$delegate.getValue();
    }

    public final SuperwallProductPlatform getPlatform() {
        return this.superwallProduct.getPlatform();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public BigDecimal getPrice() {
        Object value = this.price$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (BigDecimal) value;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getProductIdentifier() {
        return this.superwallProduct.getIdentifier();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getProductType() {
        return this.superwallProduct.getSubscription() != null ? "subs" : "inapp";
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getRegionCode() {
        return (String) this.regionCode$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getStoreFrontCountryCode() {
        return this.superwallProduct.getStorefront();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public SubscriptionPeriod getSubscriptionPeriod() {
        return (SubscriptionPeriod) this.subscriptionPeriod$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getTrialPeriodDays() {
        return ((Number) this.trialPeriodDays$delegate.getValue()).intValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getTrialPeriodDaysString() {
        return (String) this.trialPeriodDaysString$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public Date getTrialPeriodEndDate() {
        return (Date) this.trialPeriodEndDate$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getTrialPeriodEndDateString() {
        return (String) this.trialPeriodEndDateString$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getTrialPeriodMonths() {
        return ((Number) this.trialPeriodMonths$delegate.getValue()).intValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getTrialPeriodMonthsString() {
        return (String) this.trialPeriodMonthsString$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public BigDecimal getTrialPeriodPrice() {
        return this.trialPeriodPrice;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getTrialPeriodText() {
        return (String) this.trialPeriodText$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getTrialPeriodWeeks() {
        return ((Number) this.trialPeriodWeeks$delegate.getValue()).intValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getTrialPeriodWeeksString() {
        return (String) this.trialPeriodWeeksString$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getTrialPeriodYears() {
        return ((Number) this.trialPeriodYears$delegate.getValue()).intValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getTrialPeriodYearsString() {
        return (String) this.trialPeriodYearsString$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getWeeklyPrice() {
        return (String) this.weeklyPrice$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getYearlyPrice() {
        return (String) this.yearlyPrice$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String trialPeriodPricePerUnit(SubscriptionPeriod.Unit unit) {
        String str;
        Intrinsics.checkNotNullParameter(unit, "unit");
        NumberFormat priceFormatter = getPriceFormatter();
        return (priceFormatter == null || (str = priceFormatter.format(BigDecimal.ZERO)) == null) ? "$0.00" : str;
    }
}
