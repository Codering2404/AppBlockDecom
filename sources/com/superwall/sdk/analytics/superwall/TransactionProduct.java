package com.superwall.sdk.analytics.superwall;

import com.superwall.sdk.store.abstractions.product.StoreProduct;
import com.superwall.sdk.store.abstractions.product.SubscriptionPeriod;
import java.math.BigDecimal;
import java.util.Date;
import kotlin.Metadata;
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
public final class TransactionProduct {
    private final Currency currency;
    private final String id;
    private final String languageCode;
    private final String locale;
    private final Period period;
    private final Price price;
    private final TrialPeriod trialPeriod;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Currency {
        private final String code;
        private final String symbol;

        public Currency(String str, String str2) {
            this.code = str;
            this.symbol = str2;
        }

        public static /* synthetic */ Currency copy$default(Currency currency, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = currency.code;
            }
            if ((i3 & 2) != 0) {
                str2 = currency.symbol;
            }
            return currency.copy(str, str2);
        }

        public final String component1() {
            return this.code;
        }

        public final String component2() {
            return this.symbol;
        }

        public final Currency copy(String str, String str2) {
            return new Currency(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Currency)) {
                return false;
            }
            Currency currency = (Currency) obj;
            return Intrinsics.areEqual(this.code, currency.code) && Intrinsics.areEqual(this.symbol, currency.symbol);
        }

        public final String getCode() {
            return this.code;
        }

        public final String getSymbol() {
            return this.symbol;
        }

        public int hashCode() {
            String str = this.code;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.symbol;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Currency(code=" + this.code + ", symbol=" + this.symbol + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Period {
        private final String alt;
        private final int days;
        private final String ly;
        private final int months;
        private final SubscriptionPeriod.Unit unit;
        private final int weeks;
        private final int years;

        public Period(String alt, String ly, SubscriptionPeriod.Unit unit, int i3, int i4, int i5, int i6) {
            Intrinsics.checkNotNullParameter(alt, "alt");
            Intrinsics.checkNotNullParameter(ly, "ly");
            Intrinsics.checkNotNullParameter(unit, "unit");
            this.alt = alt;
            this.ly = ly;
            this.unit = unit;
            this.days = i3;
            this.weeks = i4;
            this.months = i5;
            this.years = i6;
        }

        public static /* synthetic */ Period copy$default(Period period, String str, String str2, SubscriptionPeriod.Unit unit, int i3, int i4, int i5, int i6, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                str = period.alt;
            }
            if ((i7 & 2) != 0) {
                str2 = period.ly;
            }
            if ((i7 & 4) != 0) {
                unit = period.unit;
            }
            if ((i7 & 8) != 0) {
                i3 = period.days;
            }
            if ((i7 & 16) != 0) {
                i4 = period.weeks;
            }
            if ((i7 & 32) != 0) {
                i5 = period.months;
            }
            if ((i7 & 64) != 0) {
                i6 = period.years;
            }
            int i8 = i5;
            int i9 = i6;
            int i10 = i4;
            SubscriptionPeriod.Unit unit2 = unit;
            return period.copy(str, str2, unit2, i3, i10, i8, i9);
        }

        public final String component1() {
            return this.alt;
        }

        public final String component2() {
            return this.ly;
        }

        public final SubscriptionPeriod.Unit component3() {
            return this.unit;
        }

        public final int component4() {
            return this.days;
        }

        public final int component5() {
            return this.weeks;
        }

        public final int component6() {
            return this.months;
        }

        public final int component7() {
            return this.years;
        }

        public final Period copy(String alt, String ly, SubscriptionPeriod.Unit unit, int i3, int i4, int i5, int i6) {
            Intrinsics.checkNotNullParameter(alt, "alt");
            Intrinsics.checkNotNullParameter(ly, "ly");
            Intrinsics.checkNotNullParameter(unit, "unit");
            return new Period(alt, ly, unit, i3, i4, i5, i6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Period)) {
                return false;
            }
            Period period = (Period) obj;
            return Intrinsics.areEqual(this.alt, period.alt) && Intrinsics.areEqual(this.ly, period.ly) && this.unit == period.unit && this.days == period.days && this.weeks == period.weeks && this.months == period.months && this.years == period.years;
        }

        public final String getAlt() {
            return this.alt;
        }

        public final int getDays() {
            return this.days;
        }

        public final String getLy() {
            return this.ly;
        }

        public final int getMonths() {
            return this.months;
        }

        public final SubscriptionPeriod.Unit getUnit() {
            return this.unit;
        }

        public final int getWeeks() {
            return this.weeks;
        }

        public final int getYears() {
            return this.years;
        }

        public int hashCode() {
            return (((((((((((this.alt.hashCode() * 31) + this.ly.hashCode()) * 31) + this.unit.hashCode()) * 31) + Integer.hashCode(this.days)) * 31) + Integer.hashCode(this.weeks)) * 31) + Integer.hashCode(this.months)) * 31) + Integer.hashCode(this.years);
        }

        public String toString() {
            return "Period(alt=" + this.alt + ", ly=" + this.ly + ", unit=" + this.unit + ", days=" + this.days + ", weeks=" + this.weeks + ", months=" + this.months + ", years=" + this.years + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Price {
        private final String daily;
        private final String localized;
        private final String monthly;
        private final BigDecimal raw;
        private final String weekly;
        private final String yearly;

        public Price(BigDecimal raw, String localized, String daily, String weekly, String monthly, String yearly) {
            Intrinsics.checkNotNullParameter(raw, "raw");
            Intrinsics.checkNotNullParameter(localized, "localized");
            Intrinsics.checkNotNullParameter(daily, "daily");
            Intrinsics.checkNotNullParameter(weekly, "weekly");
            Intrinsics.checkNotNullParameter(monthly, "monthly");
            Intrinsics.checkNotNullParameter(yearly, "yearly");
            this.raw = raw;
            this.localized = localized;
            this.daily = daily;
            this.weekly = weekly;
            this.monthly = monthly;
            this.yearly = yearly;
        }

        public static /* synthetic */ Price copy$default(Price price, BigDecimal bigDecimal, String str, String str2, String str3, String str4, String str5, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                bigDecimal = price.raw;
            }
            if ((i3 & 2) != 0) {
                str = price.localized;
            }
            if ((i3 & 4) != 0) {
                str2 = price.daily;
            }
            if ((i3 & 8) != 0) {
                str3 = price.weekly;
            }
            if ((i3 & 16) != 0) {
                str4 = price.monthly;
            }
            if ((i3 & 32) != 0) {
                str5 = price.yearly;
            }
            String str6 = str4;
            String str7 = str5;
            return price.copy(bigDecimal, str, str2, str3, str6, str7);
        }

        public final BigDecimal component1() {
            return this.raw;
        }

        public final String component2() {
            return this.localized;
        }

        public final String component3() {
            return this.daily;
        }

        public final String component4() {
            return this.weekly;
        }

        public final String component5() {
            return this.monthly;
        }

        public final String component6() {
            return this.yearly;
        }

        public final Price copy(BigDecimal raw, String localized, String daily, String weekly, String monthly, String yearly) {
            Intrinsics.checkNotNullParameter(raw, "raw");
            Intrinsics.checkNotNullParameter(localized, "localized");
            Intrinsics.checkNotNullParameter(daily, "daily");
            Intrinsics.checkNotNullParameter(weekly, "weekly");
            Intrinsics.checkNotNullParameter(monthly, "monthly");
            Intrinsics.checkNotNullParameter(yearly, "yearly");
            return new Price(raw, localized, daily, weekly, monthly, yearly);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Price)) {
                return false;
            }
            Price price = (Price) obj;
            return Intrinsics.areEqual(this.raw, price.raw) && Intrinsics.areEqual(this.localized, price.localized) && Intrinsics.areEqual(this.daily, price.daily) && Intrinsics.areEqual(this.weekly, price.weekly) && Intrinsics.areEqual(this.monthly, price.monthly) && Intrinsics.areEqual(this.yearly, price.yearly);
        }

        public final String getDaily() {
            return this.daily;
        }

        public final String getLocalized() {
            return this.localized;
        }

        public final String getMonthly() {
            return this.monthly;
        }

        public final BigDecimal getRaw() {
            return this.raw;
        }

        public final String getWeekly() {
            return this.weekly;
        }

        public final String getYearly() {
            return this.yearly;
        }

        public int hashCode() {
            return (((((((((this.raw.hashCode() * 31) + this.localized.hashCode()) * 31) + this.daily.hashCode()) * 31) + this.weekly.hashCode()) * 31) + this.monthly.hashCode()) * 31) + this.yearly.hashCode();
        }

        public String toString() {
            return "Price(raw=" + this.raw + ", localized=" + this.localized + ", daily=" + this.daily + ", weekly=" + this.weekly + ", monthly=" + this.monthly + ", yearly=" + this.yearly + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TrialPeriod {
        private final int days;
        private final Date endAt;
        private final int months;
        private final String text;
        private final int weeks;
        private final int years;

        public TrialPeriod(int i3, int i4, int i5, int i6, String text, Date date) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.days = i3;
            this.weeks = i4;
            this.months = i5;
            this.years = i6;
            this.text = text;
            this.endAt = date;
        }

        public static /* synthetic */ TrialPeriod copy$default(TrialPeriod trialPeriod, int i3, int i4, int i5, int i6, String str, Date date, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                i3 = trialPeriod.days;
            }
            if ((i7 & 2) != 0) {
                i4 = trialPeriod.weeks;
            }
            if ((i7 & 4) != 0) {
                i5 = trialPeriod.months;
            }
            if ((i7 & 8) != 0) {
                i6 = trialPeriod.years;
            }
            if ((i7 & 16) != 0) {
                str = trialPeriod.text;
            }
            if ((i7 & 32) != 0) {
                date = trialPeriod.endAt;
            }
            String str2 = str;
            Date date2 = date;
            return trialPeriod.copy(i3, i4, i5, i6, str2, date2);
        }

        public final int component1() {
            return this.days;
        }

        public final int component2() {
            return this.weeks;
        }

        public final int component3() {
            return this.months;
        }

        public final int component4() {
            return this.years;
        }

        public final String component5() {
            return this.text;
        }

        public final Date component6() {
            return this.endAt;
        }

        public final TrialPeriod copy(int i3, int i4, int i5, int i6, String text, Date date) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new TrialPeriod(i3, i4, i5, i6, text, date);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TrialPeriod)) {
                return false;
            }
            TrialPeriod trialPeriod = (TrialPeriod) obj;
            return this.days == trialPeriod.days && this.weeks == trialPeriod.weeks && this.months == trialPeriod.months && this.years == trialPeriod.years && Intrinsics.areEqual(this.text, trialPeriod.text) && Intrinsics.areEqual(this.endAt, trialPeriod.endAt);
        }

        public final int getDays() {
            return this.days;
        }

        public final Date getEndAt() {
            return this.endAt;
        }

        public final int getMonths() {
            return this.months;
        }

        public final String getText() {
            return this.text;
        }

        public final int getWeeks() {
            return this.weeks;
        }

        public final int getYears() {
            return this.years;
        }

        public int hashCode() {
            int iHashCode = ((((((((Integer.hashCode(this.days) * 31) + Integer.hashCode(this.weeks)) * 31) + Integer.hashCode(this.months)) * 31) + Integer.hashCode(this.years)) * 31) + this.text.hashCode()) * 31;
            Date date = this.endAt;
            return iHashCode + (date == null ? 0 : date.hashCode());
        }

        public String toString() {
            return "TrialPeriod(days=" + this.days + ", weeks=" + this.weeks + ", months=" + this.months + ", years=" + this.years + ", text=" + this.text + ", endAt=" + this.endAt + ")";
        }
    }

    public TransactionProduct(String id, Price price, TrialPeriod trialPeriod, Period period, String locale, String str, Currency currency) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(currency, "currency");
        this.id = id;
        this.price = price;
        this.trialPeriod = trialPeriod;
        this.period = period;
        this.locale = locale;
        this.languageCode = str;
        this.currency = currency;
    }

    public static /* synthetic */ TransactionProduct copy$default(TransactionProduct transactionProduct, String str, Price price, TrialPeriod trialPeriod, Period period, String str2, String str3, Currency currency, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = transactionProduct.id;
        }
        if ((i3 & 2) != 0) {
            price = transactionProduct.price;
        }
        if ((i3 & 4) != 0) {
            trialPeriod = transactionProduct.trialPeriod;
        }
        if ((i3 & 8) != 0) {
            period = transactionProduct.period;
        }
        if ((i3 & 16) != 0) {
            str2 = transactionProduct.locale;
        }
        if ((i3 & 32) != 0) {
            str3 = transactionProduct.languageCode;
        }
        if ((i3 & 64) != 0) {
            currency = transactionProduct.currency;
        }
        String str4 = str3;
        Currency currency2 = currency;
        String str5 = str2;
        TrialPeriod trialPeriod2 = trialPeriod;
        return transactionProduct.copy(str, price, trialPeriod2, period, str5, str4, currency2);
    }

    public final String component1() {
        return this.id;
    }

    public final Price component2() {
        return this.price;
    }

    public final TrialPeriod component3() {
        return this.trialPeriod;
    }

    public final Period component4() {
        return this.period;
    }

    public final String component5() {
        return this.locale;
    }

    public final String component6() {
        return this.languageCode;
    }

    public final Currency component7() {
        return this.currency;
    }

    public final TransactionProduct copy(String id, Price price, TrialPeriod trialPeriod, Period period, String locale, String str, Currency currency) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(currency, "currency");
        return new TransactionProduct(id, price, trialPeriod, period, locale, str, currency);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransactionProduct)) {
            return false;
        }
        TransactionProduct transactionProduct = (TransactionProduct) obj;
        return Intrinsics.areEqual(this.id, transactionProduct.id) && Intrinsics.areEqual(this.price, transactionProduct.price) && Intrinsics.areEqual(this.trialPeriod, transactionProduct.trialPeriod) && Intrinsics.areEqual(this.period, transactionProduct.period) && Intrinsics.areEqual(this.locale, transactionProduct.locale) && Intrinsics.areEqual(this.languageCode, transactionProduct.languageCode) && Intrinsics.areEqual(this.currency, transactionProduct.currency);
    }

    public final Currency getCurrency() {
        return this.currency;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLanguageCode() {
        return this.languageCode;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final Period getPeriod() {
        return this.period;
    }

    public final Price getPrice() {
        return this.price;
    }

    public final TrialPeriod getTrialPeriod() {
        return this.trialPeriod;
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.price.hashCode()) * 31;
        TrialPeriod trialPeriod = this.trialPeriod;
        int iHashCode2 = (iHashCode + (trialPeriod == null ? 0 : trialPeriod.hashCode())) * 31;
        Period period = this.period;
        int iHashCode3 = (((iHashCode2 + (period == null ? 0 : period.hashCode())) * 31) + this.locale.hashCode()) * 31;
        String str = this.languageCode;
        return ((iHashCode3 + (str != null ? str.hashCode() : 0)) * 31) + this.currency.hashCode();
    }

    public String toString() {
        return "TransactionProduct(id=" + this.id + ", price=" + this.price + ", trialPeriod=" + this.trialPeriod + ", period=" + this.period + ", locale=" + this.locale + ", languageCode=" + this.languageCode + ", currency=" + this.currency + ")";
    }

    public TransactionProduct(StoreProduct product) {
        Period period;
        Intrinsics.checkNotNullParameter(product, "product");
        String fullIdentifier = product.getFullIdentifier();
        Price price = new Price(product.getPrice(), product.getLocalizedPrice(), product.getDailyPrice(), product.getWeeklyPrice(), product.getMonthlyPrice(), product.getYearlyPrice());
        Date trialPeriodEndDate = product.getTrialPeriodEndDate();
        TrialPeriod trialPeriod = trialPeriodEndDate != null ? new TrialPeriod(product.getTrialPeriodDays(), product.getTrialPeriodWeeks(), product.getTrialPeriodMonths(), product.getTrialPeriodYears(), product.getTrialPeriodText(), trialPeriodEndDate) : null;
        SubscriptionPeriod subscriptionPeriod = product.getSubscriptionPeriod();
        if (subscriptionPeriod != null) {
            period = new Period(product.getLocalizedSubscriptionPeriod(), product.getPeriod() + "ly", subscriptionPeriod.getUnit(), product.getPeriodDays(), product.getPeriodWeeks(), product.getPeriodMonths(), product.getPeriodYears());
        } else {
            period = null;
        }
        this(fullIdentifier, price, trialPeriod, period, product.getLocale(), product.getLanguageCode(), new Currency(product.getCurrencyCode(), product.getCurrencySymbol()));
    }
}
