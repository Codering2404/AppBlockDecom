package com.superwall.sdk.models.product;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.superwall.sdk.models.product.StripeProductType;
import com.superwall.sdk.models.serialization.BigDecimalSerializer;
import com.superwall.sdk.store.abstractions.product.StoreProductType;
import com.superwall.sdk.store.abstractions.product.SubscriptionPeriod;
import com.superwall.sdk.utilities.DateUtils;
import com.superwall.sdk.utilities.DateUtilsKt;
import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

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
@Serializable
public final class StripeProductType implements StoreProductType {
    private final String currencyCode;
    private final String currencySymbol;
    private final List<String> entitlements;
    private final String id;
    private final String localizedPrice;
    private final BigDecimal price;
    private final PriceLocale priceLocale;
    private final StripeSubscriptionPeriod stripeSubscriptionPeriod;
    private final SubscriptionIntroductoryOffer subscriptionIntroOffer;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, new ArrayListSerializer(StringSerializer.f142891a)};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<StripeProductType> serializer() {
            return StripeProductType$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class PriceLocale {
        public static final Companion Companion = new Companion(null);
        private final String currencyCode;
        private final String currencySymbol;
        private final String identifier;
        private final String languageCode;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<PriceLocale> serializer() {
                return StripeProductType$PriceLocale$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ PriceLocale(int i3, String str, String str2, String str3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i3 & 15)) {
                PluginExceptionsKt.b(i3, 15, StripeProductType$PriceLocale$$serializer.INSTANCE.getDescriptor());
            }
            this.identifier = str;
            this.languageCode = str2;
            this.currencyCode = str3;
            this.currencySymbol = str4;
        }

        public static /* synthetic */ PriceLocale copy$default(PriceLocale priceLocale, String str, String str2, String str3, String str4, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = priceLocale.identifier;
            }
            if ((i3 & 2) != 0) {
                str2 = priceLocale.languageCode;
            }
            if ((i3 & 4) != 0) {
                str3 = priceLocale.currencyCode;
            }
            if ((i3 & 8) != 0) {
                str4 = priceLocale.currencySymbol;
            }
            return priceLocale.copy(str, str2, str3, str4);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(PriceLocale priceLocale, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            compositeEncoder.y(serialDescriptor, 0, priceLocale.identifier);
            compositeEncoder.y(serialDescriptor, 1, priceLocale.languageCode);
            compositeEncoder.y(serialDescriptor, 2, priceLocale.currencyCode);
            compositeEncoder.y(serialDescriptor, 3, priceLocale.currencySymbol);
        }

        public final String component1() {
            return this.identifier;
        }

        public final String component2() {
            return this.languageCode;
        }

        public final String component3() {
            return this.currencyCode;
        }

        public final String component4() {
            return this.currencySymbol;
        }

        public final PriceLocale copy(String identifier, String languageCode, String currencyCode, String currencySymbol) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(languageCode, "languageCode");
            Intrinsics.checkNotNullParameter(currencyCode, "currencyCode");
            Intrinsics.checkNotNullParameter(currencySymbol, "currencySymbol");
            return new PriceLocale(identifier, languageCode, currencyCode, currencySymbol);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PriceLocale)) {
                return false;
            }
            PriceLocale priceLocale = (PriceLocale) obj;
            return Intrinsics.areEqual(this.identifier, priceLocale.identifier) && Intrinsics.areEqual(this.languageCode, priceLocale.languageCode) && Intrinsics.areEqual(this.currencyCode, priceLocale.currencyCode) && Intrinsics.areEqual(this.currencySymbol, priceLocale.currencySymbol);
        }

        public final String getCurrencyCode() {
            return this.currencyCode;
        }

        public final String getCurrencySymbol() {
            return this.currencySymbol;
        }

        public final String getIdentifier() {
            return this.identifier;
        }

        public final String getLanguageCode() {
            return this.languageCode;
        }

        public int hashCode() {
            return (((((this.identifier.hashCode() * 31) + this.languageCode.hashCode()) * 31) + this.currencyCode.hashCode()) * 31) + this.currencySymbol.hashCode();
        }

        public String toString() {
            return "PriceLocale(identifier=" + this.identifier + ", languageCode=" + this.languageCode + ", currencyCode=" + this.currencyCode + ", currencySymbol=" + this.currencySymbol + ")";
        }

        public PriceLocale(String identifier, String languageCode, String currencyCode, String currencySymbol) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(languageCode, "languageCode");
            Intrinsics.checkNotNullParameter(currencyCode, "currencyCode");
            Intrinsics.checkNotNullParameter(currencySymbol, "currencySymbol");
            this.identifier = identifier;
            this.languageCode = languageCode;
            this.currencyCode = currencyCode;
            this.currencySymbol = currencySymbol;
        }

        @SerialName
        public static /* synthetic */ void getCurrencyCode$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getCurrencySymbol$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getIdentifier$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getLanguageCode$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class StripeSubscriptionPeriod {
        private final Unit unit;
        private final int value;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {Unit.Companion.serializer(), null};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<StripeSubscriptionPeriod> serializer() {
                return StripeProductType$StripeSubscriptionPeriod$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Unit {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ Unit[] $VALUES;
            private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
            public static final Companion Companion;

            @SerialName
            public static final Unit day = new Unit("day", 0);

            @SerialName
            public static final Unit week = new Unit("week", 1);

            @SerialName
            public static final Unit month = new Unit("month", 2);

            @SerialName
            public static final Unit year = new Unit("year", 3);

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                private Companion() {
                }

                private final /* synthetic */ KSerializer get$cachedSerializer() {
                    return (KSerializer) Unit.$cachedSerializer$delegate.getValue();
                }

                public final KSerializer<Unit> serializer() {
                    return get$cachedSerializer();
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            private static final /* synthetic */ Unit[] $values() {
                return new Unit[]{day, week, month, year};
            }

            static {
                Unit[] unitArr$values = $values();
                $VALUES = unitArr$values;
                $ENTRIES = EnumEntriesKt.a(unitArr$values);
                Companion = new Companion(null);
                $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: h0.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StripeProductType.StripeSubscriptionPeriod.Unit._init_$_anonymous_();
                    }
                });
            }

            private Unit(String str, int i3) {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _init_$_anonymous_() {
                return EnumsKt.a("com.superwall.sdk.models.product.StripeProductType.StripeSubscriptionPeriod.Unit", values(), new String[]{"day", "week", "month", "year"}, new Annotation[][]{null, null, null, null}, null);
            }

            public static EnumEntries<Unit> getEntries() {
                return $ENTRIES;
            }

            public static Unit valueOf(String str) {
                return (Unit) Enum.valueOf(Unit.class, str);
            }

            public static Unit[] values() {
                return (Unit[]) $VALUES.clone();
            }
        }

        public /* synthetic */ StripeSubscriptionPeriod(int i3, Unit unit, int i4, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i3 & 3)) {
                PluginExceptionsKt.b(i3, 3, StripeProductType$StripeSubscriptionPeriod$$serializer.INSTANCE.getDescriptor());
            }
            this.unit = unit;
            this.value = i4;
        }

        public static /* synthetic */ StripeSubscriptionPeriod copy$default(StripeSubscriptionPeriod stripeSubscriptionPeriod, Unit unit, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                unit = stripeSubscriptionPeriod.unit;
            }
            if ((i4 & 2) != 0) {
                i3 = stripeSubscriptionPeriod.value;
            }
            return stripeSubscriptionPeriod.copy(unit, i3);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(StripeSubscriptionPeriod stripeSubscriptionPeriod, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            compositeEncoder.C(serialDescriptor, 0, $childSerializers[0], stripeSubscriptionPeriod.unit);
            compositeEncoder.w(serialDescriptor, 1, stripeSubscriptionPeriod.value);
        }

        public final Unit component1() {
            return this.unit;
        }

        public final int component2() {
            return this.value;
        }

        public final StripeSubscriptionPeriod copy(Unit unit, int i3) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            return new StripeSubscriptionPeriod(unit, i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StripeSubscriptionPeriod)) {
                return false;
            }
            StripeSubscriptionPeriod stripeSubscriptionPeriod = (StripeSubscriptionPeriod) obj;
            return this.unit == stripeSubscriptionPeriod.unit && this.value == stripeSubscriptionPeriod.value;
        }

        public final Unit getUnit() {
            return this.unit;
        }

        public final int getValue() {
            return this.value;
        }

        public int hashCode() {
            return (this.unit.hashCode() * 31) + Integer.hashCode(this.value);
        }

        public String toString() {
            return "StripeSubscriptionPeriod(unit=" + this.unit + ", value=" + this.value + ")";
        }

        public StripeSubscriptionPeriod(Unit unit, int i3) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            this.unit = unit;
            this.value = i3;
        }

        @SerialName
        public static /* synthetic */ void getUnit$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getValue$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class SubscriptionIntroductoryOffer {
        private final String localizedPrice;
        private final PaymentMethod paymentMethod;
        private final StripeSubscriptionPeriod period;
        private final int periodCount;
        private final BigDecimal price;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, PaymentMethod.Companion.serializer()};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<SubscriptionIntroductoryOffer> serializer() {
                return StripeProductType$SubscriptionIntroductoryOffer$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class PaymentMethod {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ PaymentMethod[] $VALUES;
            private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
            public static final Companion Companion;

            @SerialName
            public static final PaymentMethod freeTrial = new PaymentMethod("freeTrial", 0);

            @SerialName
            public static final PaymentMethod payAsYouGo = new PaymentMethod("payAsYouGo", 1);

            @SerialName
            public static final PaymentMethod payUpFront = new PaymentMethod("payUpFront", 2);

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                private Companion() {
                }

                private final /* synthetic */ KSerializer get$cachedSerializer() {
                    return (KSerializer) PaymentMethod.$cachedSerializer$delegate.getValue();
                }

                public final KSerializer<PaymentMethod> serializer() {
                    return get$cachedSerializer();
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            private static final /* synthetic */ PaymentMethod[] $values() {
                return new PaymentMethod[]{freeTrial, payAsYouGo, payUpFront};
            }

            static {
                PaymentMethod[] paymentMethodArr$values = $values();
                $VALUES = paymentMethodArr$values;
                $ENTRIES = EnumEntriesKt.a(paymentMethodArr$values);
                Companion = new Companion(null);
                $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: h0.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StripeProductType.SubscriptionIntroductoryOffer.PaymentMethod._init_$_anonymous_();
                    }
                });
            }

            private PaymentMethod(String str, int i3) {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _init_$_anonymous_() {
                return EnumsKt.a("com.superwall.sdk.models.product.StripeProductType.SubscriptionIntroductoryOffer.PaymentMethod", values(), new String[]{"free_trial", "pay_as_you_go", "pay_up_front"}, new Annotation[][]{null, null, null}, null);
            }

            public static EnumEntries<PaymentMethod> getEntries() {
                return $ENTRIES;
            }

            public static PaymentMethod valueOf(String str) {
                return (PaymentMethod) Enum.valueOf(PaymentMethod.class, str);
            }

            public static PaymentMethod[] values() {
                return (PaymentMethod[]) $VALUES.clone();
            }
        }

        public /* synthetic */ SubscriptionIntroductoryOffer(int i3, StripeSubscriptionPeriod stripeSubscriptionPeriod, String str, BigDecimal bigDecimal, int i4, PaymentMethod paymentMethod, SerializationConstructorMarker serializationConstructorMarker) {
            if (31 != (i3 & 31)) {
                PluginExceptionsKt.b(i3, 31, StripeProductType$SubscriptionIntroductoryOffer$$serializer.INSTANCE.getDescriptor());
            }
            this.period = stripeSubscriptionPeriod;
            this.localizedPrice = str;
            this.price = bigDecimal;
            this.periodCount = i4;
            this.paymentMethod = paymentMethod;
        }

        public static /* synthetic */ SubscriptionIntroductoryOffer copy$default(SubscriptionIntroductoryOffer subscriptionIntroductoryOffer, StripeSubscriptionPeriod stripeSubscriptionPeriod, String str, BigDecimal bigDecimal, int i3, PaymentMethod paymentMethod, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                stripeSubscriptionPeriod = subscriptionIntroductoryOffer.period;
            }
            if ((i4 & 2) != 0) {
                str = subscriptionIntroductoryOffer.localizedPrice;
            }
            if ((i4 & 4) != 0) {
                bigDecimal = subscriptionIntroductoryOffer.price;
            }
            if ((i4 & 8) != 0) {
                i3 = subscriptionIntroductoryOffer.periodCount;
            }
            if ((i4 & 16) != 0) {
                paymentMethod = subscriptionIntroductoryOffer.paymentMethod;
            }
            PaymentMethod paymentMethod2 = paymentMethod;
            BigDecimal bigDecimal2 = bigDecimal;
            return subscriptionIntroductoryOffer.copy(stripeSubscriptionPeriod, str, bigDecimal2, i3, paymentMethod2);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(SubscriptionIntroductoryOffer subscriptionIntroductoryOffer, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            compositeEncoder.C(serialDescriptor, 0, StripeProductType$StripeSubscriptionPeriod$$serializer.INSTANCE, subscriptionIntroductoryOffer.period);
            compositeEncoder.y(serialDescriptor, 1, subscriptionIntroductoryOffer.localizedPrice);
            compositeEncoder.C(serialDescriptor, 2, BigDecimalSerializer.INSTANCE, subscriptionIntroductoryOffer.price);
            compositeEncoder.w(serialDescriptor, 3, subscriptionIntroductoryOffer.periodCount);
            compositeEncoder.C(serialDescriptor, 4, kSerializerArr[4], subscriptionIntroductoryOffer.paymentMethod);
        }

        public final StripeSubscriptionPeriod component1() {
            return this.period;
        }

        public final String component2() {
            return this.localizedPrice;
        }

        public final BigDecimal component3() {
            return this.price;
        }

        public final int component4() {
            return this.periodCount;
        }

        public final PaymentMethod component5() {
            return this.paymentMethod;
        }

        public final SubscriptionIntroductoryOffer copy(StripeSubscriptionPeriod period, String localizedPrice, BigDecimal price, int i3, PaymentMethod paymentMethod) {
            Intrinsics.checkNotNullParameter(period, "period");
            Intrinsics.checkNotNullParameter(localizedPrice, "localizedPrice");
            Intrinsics.checkNotNullParameter(price, "price");
            Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
            return new SubscriptionIntroductoryOffer(period, localizedPrice, price, i3, paymentMethod);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubscriptionIntroductoryOffer)) {
                return false;
            }
            SubscriptionIntroductoryOffer subscriptionIntroductoryOffer = (SubscriptionIntroductoryOffer) obj;
            return Intrinsics.areEqual(this.period, subscriptionIntroductoryOffer.period) && Intrinsics.areEqual(this.localizedPrice, subscriptionIntroductoryOffer.localizedPrice) && Intrinsics.areEqual(this.price, subscriptionIntroductoryOffer.price) && this.periodCount == subscriptionIntroductoryOffer.periodCount && this.paymentMethod == subscriptionIntroductoryOffer.paymentMethod;
        }

        public final String getLocalizedPrice() {
            return this.localizedPrice;
        }

        public final PaymentMethod getPaymentMethod() {
            return this.paymentMethod;
        }

        public final StripeSubscriptionPeriod getPeriod() {
            return this.period;
        }

        public final int getPeriodCount() {
            return this.periodCount;
        }

        public final BigDecimal getPrice() {
            return this.price;
        }

        public int hashCode() {
            return (((((((this.period.hashCode() * 31) + this.localizedPrice.hashCode()) * 31) + this.price.hashCode()) * 31) + Integer.hashCode(this.periodCount)) * 31) + this.paymentMethod.hashCode();
        }

        public String toString() {
            return "SubscriptionIntroductoryOffer(period=" + this.period + ", localizedPrice=" + this.localizedPrice + ", price=" + this.price + ", periodCount=" + this.periodCount + ", paymentMethod=" + this.paymentMethod + ")";
        }

        public SubscriptionIntroductoryOffer(StripeSubscriptionPeriod period, String localizedPrice, BigDecimal price, int i3, PaymentMethod paymentMethod) {
            Intrinsics.checkNotNullParameter(period, "period");
            Intrinsics.checkNotNullParameter(localizedPrice, "localizedPrice");
            Intrinsics.checkNotNullParameter(price, "price");
            Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
            this.period = period;
            this.localizedPrice = localizedPrice;
            this.price = price;
            this.periodCount = i3;
            this.paymentMethod = paymentMethod;
        }

        @SerialName
        public static /* synthetic */ void getLocalizedPrice$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getPaymentMethod$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getPeriod$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getPeriodCount$annotations() {
        }

        @SerialName
        @Serializable(with = BigDecimalSerializer.class)
        public static /* synthetic */ void getPrice$annotations() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[StripeSubscriptionPeriod.Unit.values().length];
            try {
                iArr[StripeSubscriptionPeriod.Unit.day.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StripeSubscriptionPeriod.Unit.week.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StripeSubscriptionPeriod.Unit.month.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[StripeSubscriptionPeriod.Unit.year.ordinal()] = 4;
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

    public /* synthetic */ StripeProductType(int i3, String str, BigDecimal bigDecimal, String str2, String str3, String str4, PriceLocale priceLocale, StripeSubscriptionPeriod stripeSubscriptionPeriod, SubscriptionIntroductoryOffer subscriptionIntroductoryOffer, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (511 != (i3 & 511)) {
            PluginExceptionsKt.b(i3, 511, StripeProductType$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.price = bigDecimal;
        this.localizedPrice = str2;
        this.currencyCode = str3;
        this.currencySymbol = str4;
        this.priceLocale = priceLocale;
        this.stripeSubscriptionPeriod = stripeSubscriptionPeriod;
        this.subscriptionIntroOffer = subscriptionIntroductoryOffer;
        this.entitlements = list;
    }

    private final String calculateAnnualizedPrice(int i3) {
        BigDecimal bigDecimal;
        StripeSubscriptionPeriod stripeSubscriptionPeriod = this.stripeSubscriptionPeriod;
        if (stripeSubscriptionPeriod == null) {
            return "";
        }
        BigDecimal price = getPrice();
        BigDecimal ZERO = BigDecimal.ZERO;
        if (Intrinsics.areEqual(price, ZERO)) {
            Intrinsics.checkNotNullExpressionValue(ZERO, "ZERO");
            return formatPrice(ZERO);
        }
        int i4 = WhenMappings.$EnumSwitchMapping$0[stripeSubscriptionPeriod.getUnit().ordinal()];
        if (i4 == 1) {
            bigDecimal = new BigDecimal(365);
        } else if (i4 == 2) {
            bigDecimal = new BigDecimal(52);
        } else if (i4 == 3) {
            bigDecimal = new BigDecimal(12);
        } else {
            if (i4 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            bigDecimal = BigDecimal.ONE;
        }
        BigDecimal bigDecimalMultiply = getPrice().multiply(bigDecimal);
        BigDecimal bigDecimal2 = new BigDecimal(stripeSubscriptionPeriod.getValue());
        RoundingMode roundingMode = RoundingMode.DOWN;
        BigDecimal bigDecimalDivide = bigDecimalMultiply.divide(bigDecimal2, 6, roundingMode).divide(new BigDecimal(i3), 2, roundingMode);
        Intrinsics.checkNotNull(bigDecimalDivide);
        return formatPrice(bigDecimalDivide);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StripeProductType copy$default(StripeProductType stripeProductType, String str, BigDecimal bigDecimal, String str2, String str3, String str4, PriceLocale priceLocale, StripeSubscriptionPeriod stripeSubscriptionPeriod, SubscriptionIntroductoryOffer subscriptionIntroductoryOffer, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = stripeProductType.id;
        }
        if ((i3 & 2) != 0) {
            bigDecimal = stripeProductType.price;
        }
        if ((i3 & 4) != 0) {
            str2 = stripeProductType.localizedPrice;
        }
        if ((i3 & 8) != 0) {
            str3 = stripeProductType.currencyCode;
        }
        if ((i3 & 16) != 0) {
            str4 = stripeProductType.currencySymbol;
        }
        if ((i3 & 32) != 0) {
            priceLocale = stripeProductType.priceLocale;
        }
        if ((i3 & 64) != 0) {
            stripeSubscriptionPeriod = stripeProductType.stripeSubscriptionPeriod;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            subscriptionIntroductoryOffer = stripeProductType.subscriptionIntroOffer;
        }
        if ((i3 & Function.MAX_NARGS) != 0) {
            list = stripeProductType.entitlements;
        }
        SubscriptionIntroductoryOffer subscriptionIntroductoryOffer2 = subscriptionIntroductoryOffer;
        List list2 = list;
        PriceLocale priceLocale2 = priceLocale;
        StripeSubscriptionPeriod stripeSubscriptionPeriod2 = stripeSubscriptionPeriod;
        String str5 = str4;
        String str6 = str2;
        return stripeProductType.copy(str, bigDecimal, str6, str3, str5, priceLocale2, stripeSubscriptionPeriod2, subscriptionIntroductoryOffer2, list2);
    }

    private final String formatPrice(BigDecimal bigDecimal) {
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.forLanguageTag(getLocale()));
        try {
            currencyInstance.setCurrency(Currency.getInstance(getCurrencyCode()));
        } catch (Exception unused) {
        }
        String str = currencyInstance.format(bigDecimal.doubleValue());
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$superwall_release(StripeProductType stripeProductType, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.y(serialDescriptor, 0, stripeProductType.id);
        compositeEncoder.C(serialDescriptor, 1, BigDecimalSerializer.INSTANCE, stripeProductType.getPrice());
        compositeEncoder.y(serialDescriptor, 2, stripeProductType.getLocalizedPrice());
        compositeEncoder.y(serialDescriptor, 3, stripeProductType.getCurrencyCode());
        compositeEncoder.y(serialDescriptor, 4, stripeProductType.getCurrencySymbol());
        compositeEncoder.C(serialDescriptor, 5, StripeProductType$PriceLocale$$serializer.INSTANCE, stripeProductType.priceLocale);
        compositeEncoder.i(serialDescriptor, 6, StripeProductType$StripeSubscriptionPeriod$$serializer.INSTANCE, stripeProductType.stripeSubscriptionPeriod);
        compositeEncoder.i(serialDescriptor, 7, StripeProductType$SubscriptionIntroductoryOffer$$serializer.INSTANCE, stripeProductType.subscriptionIntroOffer);
        compositeEncoder.C(serialDescriptor, 8, kSerializerArr[8], stripeProductType.entitlements);
    }

    public final String component1() {
        return this.id;
    }

    public final BigDecimal component2() {
        return this.price;
    }

    public final String component3() {
        return this.localizedPrice;
    }

    public final String component4() {
        return this.currencyCode;
    }

    public final String component5() {
        return this.currencySymbol;
    }

    public final PriceLocale component6() {
        return this.priceLocale;
    }

    public final StripeSubscriptionPeriod component7() {
        return this.stripeSubscriptionPeriod;
    }

    public final SubscriptionIntroductoryOffer component8() {
        return this.subscriptionIntroOffer;
    }

    public final List<String> component9() {
        return this.entitlements;
    }

    public final StripeProductType copy(String id, BigDecimal price, String localizedPrice, String currencyCode, String currencySymbol, PriceLocale priceLocale, StripeSubscriptionPeriod stripeSubscriptionPeriod, SubscriptionIntroductoryOffer subscriptionIntroductoryOffer, List<String> entitlements) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(localizedPrice, "localizedPrice");
        Intrinsics.checkNotNullParameter(currencyCode, "currencyCode");
        Intrinsics.checkNotNullParameter(currencySymbol, "currencySymbol");
        Intrinsics.checkNotNullParameter(priceLocale, "priceLocale");
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        return new StripeProductType(id, price, localizedPrice, currencyCode, currencySymbol, priceLocale, stripeSubscriptionPeriod, subscriptionIntroductoryOffer, entitlements);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StripeProductType)) {
            return false;
        }
        StripeProductType stripeProductType = (StripeProductType) obj;
        return Intrinsics.areEqual(this.id, stripeProductType.id) && Intrinsics.areEqual(this.price, stripeProductType.price) && Intrinsics.areEqual(this.localizedPrice, stripeProductType.localizedPrice) && Intrinsics.areEqual(this.currencyCode, stripeProductType.currencyCode) && Intrinsics.areEqual(this.currencySymbol, stripeProductType.currencySymbol) && Intrinsics.areEqual(this.priceLocale, stripeProductType.priceLocale) && Intrinsics.areEqual(this.stripeSubscriptionPeriod, stripeProductType.stripeSubscriptionPeriod) && Intrinsics.areEqual(this.subscriptionIntroOffer, stripeProductType.subscriptionIntroOffer) && Intrinsics.areEqual(this.entitlements, stripeProductType.entitlements);
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public Map<String, String> getAttributes() {
        return StoreProductType.DefaultImpls.getAttributes(this);
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
        return calculateAnnualizedPrice(365);
    }

    public final List<String> getEntitlements() {
        return this.entitlements;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getFullIdentifier() {
        return this.id;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public boolean getHasFreeTrial() {
        SubscriptionIntroductoryOffer subscriptionIntroductoryOffer = this.subscriptionIntroOffer;
        return (subscriptionIntroductoryOffer != null ? subscriptionIntroductoryOffer.getPaymentMethod() : null) == SubscriptionIntroductoryOffer.PaymentMethod.freeTrial;
    }

    public final String getId() {
        return this.id;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getLanguageCode() {
        return this.priceLocale.getLanguageCode();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getLocale() {
        return this.priceLocale.getIdentifier();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getLocalizedPrice() {
        return this.localizedPrice;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getLocalizedSubscriptionPeriod() {
        String str;
        StripeSubscriptionPeriod stripeSubscriptionPeriod = this.stripeSubscriptionPeriod;
        if (stripeSubscriptionPeriod == null) {
            return "";
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[stripeSubscriptionPeriod.getUnit().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (stripeSubscriptionPeriod.getValue() == 1) {
                        str = "Yearly";
                    } else {
                        str = stripeSubscriptionPeriod.getValue() + " years";
                    }
                } else if (stripeSubscriptionPeriod.getValue() == 1) {
                    str = "Monthly";
                } else {
                    str = stripeSubscriptionPeriod.getValue() + " months";
                }
            } else if (stripeSubscriptionPeriod.getValue() == 1) {
                str = "Weekly";
            } else {
                str = stripeSubscriptionPeriod.getValue() + " weeks";
            }
        } else if (stripeSubscriptionPeriod.getValue() == 1) {
            str = "Daily";
        } else {
            str = stripeSubscriptionPeriod.getValue() + " days";
        }
        return str == null ? "" : str;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getLocalizedTrialPeriodPrice() {
        String localizedPrice;
        SubscriptionIntroductoryOffer subscriptionIntroductoryOffer = this.subscriptionIntroOffer;
        return (subscriptionIntroductoryOffer == null || (localizedPrice = subscriptionIntroductoryOffer.getLocalizedPrice()) == null) ? "" : localizedPrice;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getMonthlyPrice() {
        return calculateAnnualizedPrice(12);
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getPeriod() {
        StripeSubscriptionPeriod stripeSubscriptionPeriod = this.stripeSubscriptionPeriod;
        if (stripeSubscriptionPeriod == null) {
            return "";
        }
        int value = stripeSubscriptionPeriod.getValue();
        String upperCase = stripeSubscriptionPeriod.getUnit().name().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        String str = "P" + value + upperCase;
        return str == null ? "" : str;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getPeriodDays() {
        StripeSubscriptionPeriod stripeSubscriptionPeriod = this.stripeSubscriptionPeriod;
        if (stripeSubscriptionPeriod == null) {
            return 0;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[stripeSubscriptionPeriod.getUnit().ordinal()];
        if (i3 == 1) {
            return stripeSubscriptionPeriod.getValue();
        }
        if (i3 == 2) {
            return stripeSubscriptionPeriod.getValue() * 7;
        }
        if (i3 == 3) {
            return stripeSubscriptionPeriod.getValue() * 30;
        }
        if (i3 == 4) {
            return stripeSubscriptionPeriod.getValue() * 365;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getPeriodDaysString() {
        return String.valueOf(getPeriodDays());
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getPeriodMonths() {
        StripeSubscriptionPeriod stripeSubscriptionPeriod = this.stripeSubscriptionPeriod;
        if (stripeSubscriptionPeriod == null) {
            return 0;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[stripeSubscriptionPeriod.getUnit().ordinal()];
        if (i3 == 1) {
            return stripeSubscriptionPeriod.getValue() / 30;
        }
        if (i3 == 2) {
            return stripeSubscriptionPeriod.getValue() / 4;
        }
        if (i3 == 3) {
            return stripeSubscriptionPeriod.getValue();
        }
        if (i3 == 4) {
            return stripeSubscriptionPeriod.getValue() * 12;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getPeriodMonthsString() {
        return String.valueOf(getPeriodMonths());
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getPeriodWeeks() {
        StripeSubscriptionPeriod stripeSubscriptionPeriod = this.stripeSubscriptionPeriod;
        if (stripeSubscriptionPeriod == null) {
            return 0;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[stripeSubscriptionPeriod.getUnit().ordinal()];
        if (i3 == 1) {
            return stripeSubscriptionPeriod.getValue() / 7;
        }
        if (i3 == 2) {
            return stripeSubscriptionPeriod.getValue();
        }
        if (i3 == 3) {
            return stripeSubscriptionPeriod.getValue() * 4;
        }
        if (i3 == 4) {
            return stripeSubscriptionPeriod.getValue() * 52;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getPeriodWeeksString() {
        return String.valueOf(getPeriodWeeks());
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getPeriodYears() {
        StripeSubscriptionPeriod stripeSubscriptionPeriod = this.stripeSubscriptionPeriod;
        if (stripeSubscriptionPeriod == null) {
            return 0;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[stripeSubscriptionPeriod.getUnit().ordinal()];
        if (i3 == 1) {
            return stripeSubscriptionPeriod.getValue() / 365;
        }
        if (i3 == 2) {
            return stripeSubscriptionPeriod.getValue() / 52;
        }
        if (i3 == 3) {
            return stripeSubscriptionPeriod.getValue() / 12;
        }
        if (i3 == 4) {
            return stripeSubscriptionPeriod.getValue();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getPeriodYearsString() {
        return String.valueOf(getPeriodYears());
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getPeriodly() {
        StripeSubscriptionPeriod stripeSubscriptionPeriod = this.stripeSubscriptionPeriod;
        if (stripeSubscriptionPeriod == null) {
            return "";
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[stripeSubscriptionPeriod.getUnit().ordinal()];
        if (i3 == 1) {
            return "daily";
        }
        if (i3 == 2) {
            return "weekly";
        }
        if (i3 == 3) {
            return "monthly";
        }
        if (i3 == 4) {
            return "yearly";
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public BigDecimal getPrice() {
        return this.price;
    }

    public final PriceLocale getPriceLocale() {
        return this.priceLocale;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getProductIdentifier() {
        return this.id;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getProductType() {
        return "stripe";
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getRegionCode() {
        return (String) CollectionsKt.getOrNull(StringsKt.V0(this.priceLocale.getIdentifier(), new String[]{"_"}, false, 0, 6, null), 1);
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getStoreFrontCountryCode() {
        return StoreProductType.DefaultImpls.getStoreFrontCountryCode(this);
    }

    public final StripeSubscriptionPeriod getStripeSubscriptionPeriod() {
        return this.stripeSubscriptionPeriod;
    }

    public final SubscriptionIntroductoryOffer getSubscriptionIntroOffer() {
        return this.subscriptionIntroOffer;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public SubscriptionPeriod getSubscriptionPeriod() {
        SubscriptionPeriod.Unit unit;
        StripeSubscriptionPeriod stripeSubscriptionPeriod = this.stripeSubscriptionPeriod;
        if (stripeSubscriptionPeriod == null) {
            return null;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[stripeSubscriptionPeriod.getUnit().ordinal()];
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
        return new SubscriptionPeriod(stripeSubscriptionPeriod.getValue(), unit);
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getTrialPeriodDays() {
        SubscriptionIntroductoryOffer subscriptionIntroductoryOffer = this.subscriptionIntroOffer;
        if (subscriptionIntroductoryOffer == null) {
            return 0;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[subscriptionIntroductoryOffer.getPeriod().getUnit().ordinal()];
        if (i3 == 1) {
            return subscriptionIntroductoryOffer.getPeriod().getValue() * subscriptionIntroductoryOffer.getPeriodCount();
        }
        if (i3 == 2) {
            return subscriptionIntroductoryOffer.getPeriod().getValue() * subscriptionIntroductoryOffer.getPeriodCount() * 7;
        }
        if (i3 == 3) {
            return subscriptionIntroductoryOffer.getPeriod().getValue() * subscriptionIntroductoryOffer.getPeriodCount() * 30;
        }
        if (i3 == 4) {
            return subscriptionIntroductoryOffer.getPeriod().getValue() * subscriptionIntroductoryOffer.getPeriodCount() * 365;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getTrialPeriodDaysString() {
        return String.valueOf(getTrialPeriodDays());
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public Date getTrialPeriodEndDate() {
        if (!getHasFreeTrial()) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        SubscriptionIntroductoryOffer subscriptionIntroductoryOffer = this.subscriptionIntroOffer;
        if (subscriptionIntroductoryOffer != null) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[subscriptionIntroductoryOffer.getPeriod().getUnit().ordinal()];
            if (i3 == 1) {
                calendar.add(5, subscriptionIntroductoryOffer.getPeriod().getValue() * subscriptionIntroductoryOffer.getPeriodCount());
            } else if (i3 == 2) {
                calendar.add(3, subscriptionIntroductoryOffer.getPeriod().getValue() * subscriptionIntroductoryOffer.getPeriodCount());
            } else if (i3 == 3) {
                calendar.add(2, subscriptionIntroductoryOffer.getPeriod().getValue() * subscriptionIntroductoryOffer.getPeriodCount());
            } else {
                if (i3 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                calendar.add(1, subscriptionIntroductoryOffer.getPeriod().getValue() * subscriptionIntroductoryOffer.getPeriodCount());
            }
        }
        return calendar.getTime();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getTrialPeriodEndDateString() {
        String str;
        Date trialPeriodEndDate = getTrialPeriodEndDate();
        return (trialPeriodEndDate == null || (str = DateUtilsKt.localizedDateFormat(DateUtils.INSTANCE.getMMM_dd_yyyy()).format(trialPeriodEndDate)) == null) ? "" : str;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getTrialPeriodMonths() {
        return getTrialPeriodDays() / 30;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getTrialPeriodMonthsString() {
        return String.valueOf(getTrialPeriodMonths());
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public BigDecimal getTrialPeriodPrice() {
        BigDecimal price;
        SubscriptionIntroductoryOffer subscriptionIntroductoryOffer = this.subscriptionIntroOffer;
        if (subscriptionIntroductoryOffer != null && (price = subscriptionIntroductoryOffer.getPrice()) != null) {
            return price;
        }
        BigDecimal ZERO = BigDecimal.ZERO;
        Intrinsics.checkNotNullExpressionValue(ZERO, "ZERO");
        return ZERO;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getTrialPeriodText() {
        String str;
        SubscriptionIntroductoryOffer subscriptionIntroductoryOffer = this.subscriptionIntroOffer;
        if (subscriptionIntroductoryOffer == null) {
            return "";
        }
        int periodCount = subscriptionIntroductoryOffer.getPeriodCount();
        int i3 = WhenMappings.$EnumSwitchMapping$0[subscriptionIntroductoryOffer.getPeriod().getUnit().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (periodCount == 1) {
                        str = "1 year free trial";
                    } else {
                        str = periodCount + " years free trial";
                    }
                } else if (periodCount == 1) {
                    str = "1 month free trial";
                } else {
                    str = periodCount + " months free trial";
                }
            } else if (periodCount == 1) {
                str = "1 week free trial";
            } else {
                str = periodCount + " weeks free trial";
            }
        } else if (periodCount == 1) {
            str = "1 day free trial";
        } else {
            str = periodCount + " days free trial";
        }
        return str == null ? "" : str;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getTrialPeriodWeeks() {
        return getTrialPeriodDays() / 7;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getTrialPeriodWeeksString() {
        return String.valueOf(getTrialPeriodWeeks());
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public int getTrialPeriodYears() {
        return getTrialPeriodDays() / 365;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getTrialPeriodYearsString() {
        return String.valueOf(getTrialPeriodYears());
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getWeeklyPrice() {
        return calculateAnnualizedPrice(52);
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getYearlyPrice() {
        return calculateAnnualizedPrice(1);
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.id.hashCode() * 31) + this.price.hashCode()) * 31) + this.localizedPrice.hashCode()) * 31) + this.currencyCode.hashCode()) * 31) + this.currencySymbol.hashCode()) * 31) + this.priceLocale.hashCode()) * 31;
        StripeSubscriptionPeriod stripeSubscriptionPeriod = this.stripeSubscriptionPeriod;
        int iHashCode2 = (iHashCode + (stripeSubscriptionPeriod == null ? 0 : stripeSubscriptionPeriod.hashCode())) * 31;
        SubscriptionIntroductoryOffer subscriptionIntroductoryOffer = this.subscriptionIntroOffer;
        return ((iHashCode2 + (subscriptionIntroductoryOffer != null ? subscriptionIntroductoryOffer.hashCode() : 0)) * 31) + this.entitlements.hashCode();
    }

    public String toString() {
        return "StripeProductType(id=" + this.id + ", price=" + this.price + ", localizedPrice=" + this.localizedPrice + ", currencyCode=" + this.currencyCode + ", currencySymbol=" + this.currencySymbol + ", priceLocale=" + this.priceLocale + ", stripeSubscriptionPeriod=" + this.stripeSubscriptionPeriod + ", subscriptionIntroOffer=" + this.subscriptionIntroOffer + ", entitlements=" + this.entitlements + ")";
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String trialPeriodPricePerUnit(SubscriptionPeriod.Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        int trialPeriodDays = getTrialPeriodDays();
        if (trialPeriodDays == 0) {
            return "";
        }
        int i3 = WhenMappings.$EnumSwitchMapping$1[unit.ordinal()];
        int i4 = 1;
        if (i3 == 1) {
            i4 = 365;
        } else if (i3 == 2) {
            i4 = 52;
        } else if (i3 == 3) {
            i4 = 12;
        } else if (i3 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        BigDecimal bigDecimalMultiply = getTrialPeriodPrice().multiply(new BigDecimal(365));
        BigDecimal bigDecimal = new BigDecimal(trialPeriodDays);
        RoundingMode roundingMode = RoundingMode.DOWN;
        BigDecimal bigDecimalDivide = bigDecimalMultiply.divide(bigDecimal, 6, roundingMode).divide(new BigDecimal(i4), 2, roundingMode);
        Intrinsics.checkNotNull(bigDecimalDivide);
        return formatPrice(bigDecimalDivide);
    }

    public StripeProductType(String id, BigDecimal price, String localizedPrice, String currencyCode, String currencySymbol, PriceLocale priceLocale, StripeSubscriptionPeriod stripeSubscriptionPeriod, SubscriptionIntroductoryOffer subscriptionIntroductoryOffer, List<String> entitlements) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(localizedPrice, "localizedPrice");
        Intrinsics.checkNotNullParameter(currencyCode, "currencyCode");
        Intrinsics.checkNotNullParameter(currencySymbol, "currencySymbol");
        Intrinsics.checkNotNullParameter(priceLocale, "priceLocale");
        Intrinsics.checkNotNullParameter(entitlements, "entitlements");
        this.id = id;
        this.price = price;
        this.localizedPrice = localizedPrice;
        this.currencyCode = currencyCode;
        this.currencySymbol = currencySymbol;
        this.priceLocale = priceLocale;
        this.stripeSubscriptionPeriod = stripeSubscriptionPeriod;
        this.subscriptionIntroOffer = subscriptionIntroductoryOffer;
        this.entitlements = entitlements;
    }

    @SerialName
    public static /* synthetic */ void getCurrencyCode$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getCurrencySymbol$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getEntitlements$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getId$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getLocalizedPrice$annotations() {
    }

    @SerialName
    @Serializable(with = BigDecimalSerializer.class)
    public static /* synthetic */ void getPrice$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getPriceLocale$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getStripeSubscriptionPeriod$annotations() {
    }

    @SerialName
    public static /* synthetic */ void getSubscriptionIntroOffer$annotations() {
    }
}
