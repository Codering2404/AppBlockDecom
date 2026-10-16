package com.superwall.sdk.store.abstractions.product;

import com.android.billingclient.api.ProductDetails;
import com.superwall.sdk.billing.DecomposedProductIds;
import com.superwall.sdk.contrib.threeteen.AmountFormats;
import com.superwall.sdk.store.abstractions.product.RawStoreProduct;
import com.superwall.sdk.store.abstractions.product.StoreProductType;
import com.superwall.sdk.store.abstractions.product.SubscriptionPeriod;
import com.superwall.sdk.utilities.DateUtils;
import com.superwall.sdk.utilities.DateUtilsKt;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.Transient;
import org.threeten.bp.Period;

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
public final class RawStoreProduct implements StoreProductType {
    public static final Companion Companion = new Companion(null);
    private final BasePlanType basePlanType;
    private final Lazy basePriceForSelectedOffer$delegate;
    private final Lazy currencyCode$delegate;
    private final Lazy currencySymbol$delegate;
    private final Lazy dailyPrice$delegate;
    private final String fullIdentifier;
    private final Lazy hasFreeTrial$delegate;
    private final Lazy isSubscription$delegate;
    private final Lazy languageCode$delegate;
    private final Lazy locale$delegate;
    private final Lazy localizedPrice$delegate;
    private final Lazy localizedSubscriptionPeriod$delegate;
    private final Lazy localizedTrialPeriodPrice$delegate;
    private final Lazy monthlyPrice$delegate;
    private final Lazy offerId$delegate;
    private final OfferType offerType;
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
    private final Lazy productIdentifier$delegate;
    private final Lazy regionCode$delegate;
    private final Lazy selectedOffer$delegate;
    private final Lazy selectedOfferPricingPhase$delegate;
    private final Lazy subscriptionPeriod$delegate;
    private final Lazy trialPeriodDays$delegate;
    private final Lazy trialPeriodDaysString$delegate;
    private final Lazy trialPeriodEndDate$delegate;
    private final Lazy trialPeriodEndDateString$delegate;
    private final Lazy trialPeriodMonths$delegate;
    private final Lazy trialPeriodMonthsString$delegate;
    private final Lazy trialPeriodPrice$delegate;
    private final Lazy trialPeriodText$delegate;
    private final Lazy trialPeriodWeeks$delegate;
    private final Lazy trialPeriodWeeksString$delegate;
    private final Lazy trialPeriodYears$delegate;
    private final Lazy trialPeriodYearsString$delegate;
    private final Lazy trialSubscriptionPeriod$delegate;
    private final ProductDetails underlyingProductDetails;
    private final Lazy weeklyPrice$delegate;
    private final Lazy yearlyPrice$delegate;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RawStoreProduct from(ProductDetails details) {
            Intrinsics.checkNotNullParameter(details, "details");
            DecomposedProductIds.Companion companion = DecomposedProductIds.Companion;
            String strE = details.e();
            Intrinsics.checkNotNullExpressionValue(strE, "getProductId(...)");
            DecomposedProductIds decomposedProductIdsFrom = companion.from(strE);
            String strE2 = details.e();
            Intrinsics.checkNotNullExpressionValue(strE2, "getProductId(...)");
            return new RawStoreProduct(details, strE2, decomposedProductIdsFrom.getBasePlanType(), decomposedProductIdsFrom.getOfferType());
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class SelectedOfferDetails {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class OneTime extends SelectedOfferDetails {
            private final String offerId;
            private final String purchaseOptionId;
            private final ProductDetails.OneTimePurchaseOfferDetails underlying;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OneTime(ProductDetails.OneTimePurchaseOfferDetails underlying, String str, String str2) {
                super(null);
                Intrinsics.checkNotNullParameter(underlying, "underlying");
                this.underlying = underlying;
                this.purchaseOptionId = str;
                this.offerId = str2;
            }

            public static /* synthetic */ OneTime copy$default(OneTime oneTime, ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails, String str, String str2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    oneTimePurchaseOfferDetails = oneTime.underlying;
                }
                if ((i3 & 2) != 0) {
                    str = oneTime.purchaseOptionId;
                }
                if ((i3 & 4) != 0) {
                    str2 = oneTime.offerId;
                }
                return oneTime.copy(oneTimePurchaseOfferDetails, str, str2);
            }

            public final ProductDetails.OneTimePurchaseOfferDetails component1() {
                return this.underlying;
            }

            public final String component2() {
                return this.purchaseOptionId;
            }

            public final String component3() {
                return this.offerId;
            }

            public final OneTime copy(ProductDetails.OneTimePurchaseOfferDetails underlying, String str, String str2) {
                Intrinsics.checkNotNullParameter(underlying, "underlying");
                return new OneTime(underlying, str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof OneTime)) {
                    return false;
                }
                OneTime oneTime = (OneTime) obj;
                return Intrinsics.areEqual(this.underlying, oneTime.underlying) && Intrinsics.areEqual(this.purchaseOptionId, oneTime.purchaseOptionId) && Intrinsics.areEqual(this.offerId, oneTime.offerId);
            }

            public final String getOfferId() {
                return this.offerId;
            }

            public final String getPurchaseOptionId() {
                return this.purchaseOptionId;
            }

            public final ProductDetails.OneTimePurchaseOfferDetails getUnderlying() {
                return this.underlying;
            }

            public int hashCode() {
                int iHashCode = this.underlying.hashCode() * 31;
                String str = this.purchaseOptionId;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.offerId;
                return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "OneTime(underlying=" + this.underlying + ", purchaseOptionId=" + this.purchaseOptionId + ", offerId=" + this.offerId + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Subscription extends SelectedOfferDetails {
            private final ProductDetails.SubscriptionOfferDetails underlying;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Subscription(ProductDetails.SubscriptionOfferDetails underlying) {
                super(null);
                Intrinsics.checkNotNullParameter(underlying, "underlying");
                this.underlying = underlying;
            }

            public static /* synthetic */ Subscription copy$default(Subscription subscription, ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    subscriptionOfferDetails = subscription.underlying;
                }
                return subscription.copy(subscriptionOfferDetails);
            }

            public final ProductDetails.SubscriptionOfferDetails component1() {
                return this.underlying;
            }

            public final Subscription copy(ProductDetails.SubscriptionOfferDetails underlying) {
                Intrinsics.checkNotNullParameter(underlying, "underlying");
                return new Subscription(underlying);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Subscription) && Intrinsics.areEqual(this.underlying, ((Subscription) obj).underlying);
            }

            public final ProductDetails.SubscriptionOfferDetails getUnderlying() {
                return this.underlying;
            }

            public int hashCode() {
                return this.underlying.hashCode();
            }

            public String toString() {
                return "Subscription(underlying=" + this.underlying + ")";
            }
        }

        public /* synthetic */ SelectedOfferDetails(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private SelectedOfferDetails() {
        }
    }

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

    public RawStoreProduct(ProductDetails underlyingProductDetails, String fullIdentifier, BasePlanType basePlanType, OfferType offerType) {
        Intrinsics.checkNotNullParameter(underlyingProductDetails, "underlyingProductDetails");
        Intrinsics.checkNotNullParameter(fullIdentifier, "fullIdentifier");
        Intrinsics.checkNotNullParameter(basePlanType, "basePlanType");
        Intrinsics.checkNotNullParameter(offerType, "offerType");
        this.underlyingProductDetails = underlyingProductDetails;
        this.fullIdentifier = fullIdentifier;
        this.basePlanType = basePlanType;
        this.offerType = offerType;
        this.priceFormatterProvider = new PriceFormatterProvider();
        this.priceFormatter$delegate = LazyKt.b(new Function0() { // from class: k0.o0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.priceFormatter_delegate$lambda$1(this.f139689a);
            }
        });
        this.offerId$delegate = LazyKt.b(new Function0() { // from class: k0.q0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.offerId_delegate$lambda$2(this.f139695a);
            }
        });
        this.selectedOffer$delegate = LazyKt.b(new Function0() { // from class: k0.c1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f139653a.getSelectedOfferDetails();
            }
        });
        this.basePriceForSelectedOffer$delegate = LazyKt.b(new Function0() { // from class: k0.o1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.basePriceForSelectedOffer_delegate$lambda$4(this.f139690a);
            }
        });
        this.selectedOfferPricingPhase$delegate = LazyKt.b(new Function0() { // from class: k0.u1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.selectedOfferPricingPhase_delegate$lambda$7(this.f139705a);
            }
        });
        this.productIdentifier$delegate = LazyKt.b(new Function0() { // from class: k0.w1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.productIdentifier_delegate$lambda$8(this.f139711a);
            }
        });
        this.price$delegate = LazyKt.b(new Function0() { // from class: k0.x1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.price_delegate$lambda$10(this.f139713a);
            }
        });
        this.localizedPrice$delegate = LazyKt.b(new Function0() { // from class: k0.y1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.localizedPrice_delegate$lambda$11(this.f139716a);
            }
        });
        this.localizedSubscriptionPeriod$delegate = LazyKt.b(new Function0() { // from class: k0.z1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.localizedSubscriptionPeriod_delegate$lambda$13(this.f139719a);
            }
        });
        this.period$delegate = LazyKt.b(new Function0() { // from class: k0.a2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.period_delegate$lambda$15(this.f139646a);
            }
        });
        this.periodly$delegate = LazyKt.b(new Function0() { // from class: k0.z0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.periodly_delegate$lambda$17(this.f139718a);
            }
        });
        this.periodWeeks$delegate = LazyKt.b(new Function0() { // from class: k0.k1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(RawStoreProduct.periodWeeks_delegate$lambda$19(this.f139682a));
            }
        });
        this.periodWeeksString$delegate = LazyKt.b(new Function0() { // from class: k0.v1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.periodWeeksString_delegate$lambda$20(this.f139708a);
            }
        });
        this.periodMonths$delegate = LazyKt.b(new Function0() { // from class: k0.b2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(RawStoreProduct.periodMonths_delegate$lambda$22(this.f139650a));
            }
        });
        this.periodMonthsString$delegate = LazyKt.b(new Function0() { // from class: k0.c2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.periodMonthsString_delegate$lambda$23(this.f139654a);
            }
        });
        this.periodYears$delegate = LazyKt.b(new Function0() { // from class: k0.d2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(RawStoreProduct.periodYears_delegate$lambda$25(this.f139658a));
            }
        });
        this.periodYearsString$delegate = LazyKt.b(new Function0() { // from class: k0.e2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.periodYearsString_delegate$lambda$26(this.f139662a);
            }
        });
        this.periodDays$delegate = LazyKt.b(new Function0() { // from class: k0.f2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(RawStoreProduct.periodDays_delegate$lambda$28(this.f139666a));
            }
        });
        this.periodDaysString$delegate = LazyKt.b(new Function0() { // from class: k0.g2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.periodDaysString_delegate$lambda$29(this.f139670a);
            }
        });
        this.dailyPrice$delegate = LazyKt.b(new Function0() { // from class: k0.p0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.dailyPrice_delegate$lambda$30(this.f139692a);
            }
        });
        this.weeklyPrice$delegate = LazyKt.b(new Function0() { // from class: k0.r0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.weeklyPrice_delegate$lambda$31(this.f139697a);
            }
        });
        this.monthlyPrice$delegate = LazyKt.b(new Function0() { // from class: k0.s0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.monthlyPrice_delegate$lambda$32(this.f139699a);
            }
        });
        this.yearlyPrice$delegate = LazyKt.b(new Function0() { // from class: k0.t0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.yearlyPrice_delegate$lambda$33(this.f139701a);
            }
        });
        this.hasFreeTrial$delegate = LazyKt.b(new Function0() { // from class: k0.u0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(RawStoreProduct.hasFreeTrial_delegate$lambda$34(this.f139704a));
            }
        });
        this.localizedTrialPeriodPrice$delegate = LazyKt.b(new Function0() { // from class: k0.v0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.localizedTrialPeriodPrice_delegate$lambda$35(this.f139707a);
            }
        });
        this.trialPeriodPrice$delegate = LazyKt.b(new Function0() { // from class: k0.w0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.trialPeriodPrice_delegate$lambda$39(this.f139710a);
            }
        });
        this.trialPeriodEndDate$delegate = LazyKt.b(new Function0() { // from class: k0.x0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.trialPeriodEndDate_delegate$lambda$74(this.f139712a);
            }
        });
        this.trialPeriodEndDateString$delegate = LazyKt.b(new Function0() { // from class: k0.y0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.trialPeriodEndDateString_delegate$lambda$76(this.f139715a);
            }
        });
        this.trialPeriodDays$delegate = LazyKt.b(new Function0() { // from class: k0.a1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(RawStoreProduct.trialPeriodDays_delegate$lambda$78(this.f139645a));
            }
        });
        this.trialPeriodDaysString$delegate = LazyKt.b(new Function0() { // from class: k0.b1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.trialPeriodDaysString_delegate$lambda$79(this.f139649a);
            }
        });
        this.trialPeriodWeeks$delegate = LazyKt.b(new Function0() { // from class: k0.d1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(RawStoreProduct.trialPeriodWeeks_delegate$lambda$80(this.f139657a));
            }
        });
        this.trialPeriodWeeksString$delegate = LazyKt.b(new Function0() { // from class: k0.e1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.trialPeriodWeeksString_delegate$lambda$81(this.f139661a);
            }
        });
        this.trialPeriodMonths$delegate = LazyKt.b(new Function0() { // from class: k0.f1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(RawStoreProduct.trialPeriodMonths_delegate$lambda$83(this.f139665a));
            }
        });
        this.trialPeriodMonthsString$delegate = LazyKt.b(new Function0() { // from class: k0.g1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.trialPeriodMonthsString_delegate$lambda$84(this.f139669a);
            }
        });
        this.trialPeriodYears$delegate = LazyKt.b(new Function0() { // from class: k0.h1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(RawStoreProduct.trialPeriodYears_delegate$lambda$86(this.f139673a));
            }
        });
        this.trialPeriodYearsString$delegate = LazyKt.b(new Function0() { // from class: k0.i1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.trialPeriodYearsString_delegate$lambda$87(this.f139676a);
            }
        });
        this.trialPeriodText$delegate = LazyKt.b(new Function0() { // from class: k0.j1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.trialPeriodText_delegate$lambda$88(this.f139679a);
            }
        });
        this.locale$delegate = LazyKt.b(new Function0() { // from class: k0.l1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.locale_delegate$lambda$89();
            }
        });
        this.languageCode$delegate = LazyKt.b(new Function0() { // from class: k0.m1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.languageCode_delegate$lambda$90();
            }
        });
        this.currencyCode$delegate = LazyKt.b(new Function0() { // from class: k0.n1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.currencyCode_delegate$lambda$91(this.f139687a);
            }
        });
        this.currencySymbol$delegate = LazyKt.b(new Function0() { // from class: k0.p1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.currencySymbol_delegate$lambda$93(this.f139693a);
            }
        });
        this.regionCode$delegate = LazyKt.b(new Function0() { // from class: k0.q1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.regionCode_delegate$lambda$94();
            }
        });
        this.subscriptionPeriod$delegate = LazyKt.b(new Function0() { // from class: k0.r1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.subscriptionPeriod_delegate$lambda$95(this.f139698a);
            }
        });
        this.trialSubscriptionPeriod$delegate = LazyKt.b(new Function0() { // from class: k0.s1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RawStoreProduct.trialSubscriptionPeriod_delegate$lambda$98(this.f139700a);
            }
        });
        this.isSubscription$delegate = LazyKt.b(new Function0() { // from class: k0.t1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(RawStoreProduct.isSubscription_delegate$lambda$99(this.f139702a));
            }
        });
    }

    private final SelectedOfferDetails.Subscription automaticallySelectSubscriptionOffer() {
        boolean z2;
        List listG = this.underlyingProductDetails.g();
        if (listG == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : listG) {
            if (Intrinsics.areEqual(((ProductDetails.SubscriptionOfferDetails) obj).a(), getBasePlanId())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            if (((ProductDetails.SubscriptionOfferDetails) obj2).f().a().size() != 1) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        int size2 = arrayList2.size();
        int i4 = 0;
        while (i4 < size2) {
            Object obj3 = arrayList2.get(i4);
            i4++;
            List listD = ((ProductDetails.SubscriptionOfferDetails) obj3).d();
            Intrinsics.checkNotNullExpressionValue(listD, "getOfferTags(...)");
            List<String> list = listD;
            if ((list instanceof Collection) && list.isEmpty()) {
                z2 = false;
            } else {
                for (String str : list) {
                    Intrinsics.checkNotNull(str);
                    if (StringsKt.a0(str, "-ignore-offer", false, 2, null)) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
            }
            if (!z2) {
                arrayList3.add(obj3);
            }
        }
        ProductDetails.SubscriptionOfferDetails subscriptionOfferDetailsFindLongestFreeTrial = findLongestFreeTrial(arrayList3);
        ProductDetails.SubscriptionOfferDetails subscriptionOfferDetailsFindLowestNonFreeOffer = findLowestNonFreeOffer(arrayList3);
        if (subscriptionOfferDetailsFindLongestFreeTrial == null) {
            subscriptionOfferDetailsFindLongestFreeTrial = subscriptionOfferDetailsFindLowestNonFreeOffer;
        }
        if (subscriptionOfferDetailsFindLongestFreeTrial != null) {
            return new SelectedOfferDetails.Subscription(subscriptionOfferDetailsFindLongestFreeTrial);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BigDecimal basePriceForSelectedOffer_delegate$lambda$4(RawStoreProduct rawStoreProduct) {
        SelectedOfferDetails selectedOffer = rawStoreProduct.getSelectedOffer();
        if (selectedOffer instanceof SelectedOfferDetails.Subscription) {
            List listA = ((SelectedOfferDetails.Subscription) selectedOffer).getUnderlying().f().a();
            Intrinsics.checkNotNullExpressionValue(listA, "getPricingPhaseList(...)");
            return new BigDecimal(((ProductDetails.PricingPhase) CollectionsKt.last(listA)).d()).divide(new BigDecimal(1000000), 2, RoundingMode.DOWN);
        }
        if (selectedOffer instanceof SelectedOfferDetails.OneTime) {
            return new BigDecimal(((SelectedOfferDetails.OneTime) selectedOffer).getUnderlying().d()).divide(new BigDecimal(1000000), 2, RoundingMode.DOWN);
        }
        if (selectedOffer == null) {
            return BigDecimal.ZERO;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String currencyCode_delegate$lambda$91(RawStoreProduct rawStoreProduct) {
        SelectedOfferDetails selectedOffer = rawStoreProduct.getSelectedOffer();
        if (selectedOffer instanceof SelectedOfferDetails.Subscription) {
            List listA = ((SelectedOfferDetails.Subscription) selectedOffer).getUnderlying().f().a();
            Intrinsics.checkNotNullExpressionValue(listA, "getPricingPhaseList(...)");
            return ((ProductDetails.PricingPhase) CollectionsKt.last(listA)).e();
        }
        if (selectedOffer instanceof SelectedOfferDetails.OneTime) {
            return ((SelectedOfferDetails.OneTime) selectedOffer).getUnderlying().e();
        }
        if (selectedOffer == null) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String currencySymbol_delegate$lambda$93(RawStoreProduct rawStoreProduct) {
        String currencyCode = rawStoreProduct.getCurrencyCode();
        if (currencyCode != null) {
            return Currency.getInstance(currencyCode).getSymbol();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String dailyPrice_delegate$lambda$30(RawStoreProduct rawStoreProduct) {
        String str;
        String str2;
        if (rawStoreProduct.getSelectedOffer() instanceof SelectedOfferDetails.OneTime) {
            return "n/a";
        }
        BigDecimal basePriceForSelectedOffer = rawStoreProduct.getBasePriceForSelectedOffer();
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (Intrinsics.areEqual(basePriceForSelectedOffer, bigDecimal)) {
            NumberFormat priceFormatter = rawStoreProduct.getPriceFormatter();
            return (priceFormatter == null || (str2 = priceFormatter.format(bigDecimal)) == null) ? "$0.00" : str2;
        }
        SubscriptionPeriod subscriptionPeriod = rawStoreProduct.getSubscriptionPeriod();
        if (subscriptionPeriod == null) {
            return "n/a";
        }
        Intrinsics.checkNotNull(basePriceForSelectedOffer);
        BigDecimal bigDecimalPricePerDay = subscriptionPeriod.pricePerDay(basePriceForSelectedOffer);
        NumberFormat priceFormatter2 = rawStoreProduct.getPriceFormatter();
        return (priceFormatter2 == null || (str = priceFormatter2.format(bigDecimalPricePerDay)) == null) ? "n/a" : str;
    }

    private final ProductDetails.SubscriptionOfferDetails findLongestFreeTrial(List<ProductDetails.SubscriptionOfferDetails> list) {
        Object next;
        Object next2;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            Pair pair = null;
            if (!it.hasNext()) {
                break;
            }
            ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails = (ProductDetails.SubscriptionOfferDetails) it.next();
            List listA = subscriptionOfferDetails.f().a();
            Intrinsics.checkNotNullExpressionValue(listA, "getPricingPhaseList(...)");
            Iterator it2 = CollectionsKt.dropLast(listA, 1).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it2.next();
                if (((ProductDetails.PricingPhase) next2).d() == 0) {
                    break;
                }
            }
            ProductDetails.PricingPhase pricingPhase = (ProductDetails.PricingPhase) next2;
            if (pricingPhase != null) {
                Period periodO = Period.o(pricingPhase.b());
                pair = new Pair(subscriptionOfferDetails, Long.valueOf((periodO.q() * ((long) 30)) + ((long) periodO.g())));
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        Iterator it3 = arrayList.iterator();
        if (it3.hasNext()) {
            next = it3.next();
            if (it3.hasNext()) {
                long jLongValue = ((Number) ((Pair) next).f()).longValue();
                do {
                    Object next3 = it3.next();
                    long jLongValue2 = ((Number) ((Pair) next3).f()).longValue();
                    if (jLongValue < jLongValue2) {
                        next = next3;
                        jLongValue = jLongValue2;
                    }
                } while (it3.hasNext());
            }
        } else {
            next = null;
        }
        Pair pair2 = (Pair) next;
        if (pair2 != null) {
            return (ProductDetails.SubscriptionOfferDetails) pair2.e();
        }
        return null;
    }

    private final ProductDetails.SubscriptionOfferDetails findLowestNonFreeOffer(List<ProductDetails.SubscriptionOfferDetails> list) {
        Object next;
        Object next2;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails = (ProductDetails.SubscriptionOfferDetails) it.next();
            List listA = subscriptionOfferDetails.f().a();
            Intrinsics.checkNotNullExpressionValue(listA, "getPricingPhaseList(...)");
            Iterator it2 = CollectionsKt.dropLast(listA, 1).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it2.next();
                if (((ProductDetails.PricingPhase) next2).d() > 0) {
                    break;
                }
            }
            ProductDetails.PricingPhase pricingPhase = (ProductDetails.PricingPhase) next2;
            Pair pair = pricingPhase != null ? new Pair(subscriptionOfferDetails, Long.valueOf(pricingPhase.d())) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        Iterator it3 = arrayList.iterator();
        if (it3.hasNext()) {
            next = it3.next();
            if (it3.hasNext()) {
                long jLongValue = ((Number) ((Pair) next).f()).longValue();
                do {
                    Object next3 = it3.next();
                    long jLongValue2 = ((Number) ((Pair) next3).f()).longValue();
                    if (jLongValue > jLongValue2) {
                        next = next3;
                        jLongValue = jLongValue2;
                    }
                } while (it3.hasNext());
            }
        } else {
            next = null;
        }
        Pair pair2 = (Pair) next;
        if (pair2 != null) {
            return (ProductDetails.SubscriptionOfferDetails) pair2.e();
        }
        return null;
    }

    private final BigDecimal getBasePriceForSelectedOffer() {
        return (BigDecimal) this.basePriceForSelectedOffer$delegate.getValue();
    }

    private final NumberFormat getPriceFormatter() {
        return (NumberFormat) this.priceFormatter$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0126 A[PHI: r2
      0x0126: PHI (r2v30 com.android.billingclient.api.ProductDetails$OneTimePurchaseOfferDetails) = 
      (r2v14 com.android.billingclient.api.ProductDetails$OneTimePurchaseOfferDetails)
      (r2v33 com.android.billingclient.api.ProductDetails$OneTimePurchaseOfferDetails)
     binds: [B:134:0x025f, B:56:0x00fe] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.superwall.sdk.store.abstractions.product.RawStoreProduct.SelectedOfferDetails getSelectedOfferDetails() {
        /*
            Method dump skipped, instruction units count: 945
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.abstractions.product.RawStoreProduct.getSelectedOfferDetails():com.superwall.sdk.store.abstractions.product.RawStoreProduct$SelectedOfferDetails");
    }

    private final ProductDetails.PricingPhase getSelectedOfferPricingPhase() {
        return (ProductDetails.PricingPhase) this.selectedOfferPricingPhase$delegate.getValue();
    }

    private final SubscriptionPeriod getTrialSubscriptionPeriod() {
        return (SubscriptionPeriod) this.trialSubscriptionPeriod$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasFreeTrial_delegate$lambda$34(RawStoreProduct rawStoreProduct) {
        SelectedOfferDetails selectedOffer = rawStoreProduct.getSelectedOffer();
        if (selectedOffer instanceof SelectedOfferDetails.Subscription) {
            List listA = ((SelectedOfferDetails.Subscription) selectedOffer).getUnderlying().f().a();
            Intrinsics.checkNotNullExpressionValue(listA, "getPricingPhaseList(...)");
            return !CollectionsKt.dropLast(listA, 1).isEmpty();
        }
        if ((selectedOffer instanceof SelectedOfferDetails.OneTime) || selectedOffer == null) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isSubscription_delegate$lambda$99(RawStoreProduct rawStoreProduct) {
        if (rawStoreProduct.underlyingProductDetails.g() != null) {
            return !r0.isEmpty();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String languageCode_delegate$lambda$90() {
        return Locale.getDefault().getLanguage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String locale_delegate$lambda$89() {
        return Locale.getDefault().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String localizedPrice_delegate$lambda$11(RawStoreProduct rawStoreProduct) {
        String str;
        NumberFormat priceFormatter = rawStoreProduct.getPriceFormatter();
        return (priceFormatter == null || (str = priceFormatter.format(rawStoreProduct.getPrice())) == null) ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String localizedSubscriptionPeriod_delegate$lambda$13(RawStoreProduct rawStoreProduct) {
        SubscriptionPeriod subscriptionPeriod = rawStoreProduct.getSubscriptionPeriod();
        if (subscriptionPeriod == null) {
            return "";
        }
        AmountFormats amountFormats = AmountFormats.INSTANCE;
        Period period = subscriptionPeriod.toPeriod();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String strWordBased = amountFormats.wordBased(period, locale);
        return strWordBased == null ? "" : strWordBased;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String localizedTrialPeriodPrice_delegate$lambda$35(RawStoreProduct rawStoreProduct) {
        String str;
        NumberFormat priceFormatter = rawStoreProduct.getPriceFormatter();
        return (priceFormatter == null || (str = priceFormatter.format(rawStoreProduct.getTrialPeriodPrice())) == null) ? "$0.00" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String monthlyPrice_delegate$lambda$32(RawStoreProduct rawStoreProduct) {
        String str;
        String str2;
        if (rawStoreProduct.getSelectedOffer() instanceof SelectedOfferDetails.OneTime) {
            return "n/a";
        }
        BigDecimal basePriceForSelectedOffer = rawStoreProduct.getBasePriceForSelectedOffer();
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (Intrinsics.areEqual(basePriceForSelectedOffer, bigDecimal)) {
            NumberFormat priceFormatter = rawStoreProduct.getPriceFormatter();
            return (priceFormatter == null || (str2 = priceFormatter.format(bigDecimal)) == null) ? "$0.00" : str2;
        }
        SubscriptionPeriod subscriptionPeriod = rawStoreProduct.getSubscriptionPeriod();
        if (subscriptionPeriod == null) {
            return "n/a";
        }
        Intrinsics.checkNotNull(basePriceForSelectedOffer);
        BigDecimal bigDecimalPricePerMonth = subscriptionPeriod.pricePerMonth(basePriceForSelectedOffer);
        NumberFormat priceFormatter2 = rawStoreProduct.getPriceFormatter();
        return (priceFormatter2 == null || (str = priceFormatter2.format(bigDecimalPricePerMonth)) == null) ? "n/a" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String offerId_delegate$lambda$2(RawStoreProduct rawStoreProduct) {
        SelectedOfferDetails selectedOffer = rawStoreProduct.getSelectedOffer();
        if (selectedOffer instanceof SelectedOfferDetails.Subscription) {
            return ((SelectedOfferDetails.Subscription) selectedOffer).getUnderlying().c();
        }
        if (selectedOffer instanceof SelectedOfferDetails.OneTime) {
            return ((SelectedOfferDetails.OneTime) selectedOffer).getOfferId();
        }
        if (selectedOffer == null) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String periodDaysString_delegate$lambda$29(RawStoreProduct rawStoreProduct) {
        return String.valueOf(rawStoreProduct.getPeriodDays());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int periodDays_delegate$lambda$28(RawStoreProduct rawStoreProduct) {
        SubscriptionPeriod subscriptionPeriod = rawStoreProduct.getSubscriptionPeriod();
        if (subscriptionPeriod == null) {
            return 0;
        }
        int value = subscriptionPeriod.getValue();
        int i3 = WhenMappings.$EnumSwitchMapping$0[subscriptionPeriod.getUnit().ordinal()];
        if (i3 == 1) {
            return value;
        }
        if (i3 == 2) {
            return value * 7;
        }
        if (i3 == 3) {
            return value * 30;
        }
        if (i3 == 4) {
            return value * 365;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String periodMonthsString_delegate$lambda$23(RawStoreProduct rawStoreProduct) {
        return String.valueOf(rawStoreProduct.getPeriodMonths());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int periodMonths_delegate$lambda$22(RawStoreProduct rawStoreProduct) {
        SubscriptionPeriod subscriptionPeriod = rawStoreProduct.getSubscriptionPeriod();
        if (subscriptionPeriod == null) {
            return 0;
        }
        int value = subscriptionPeriod.getValue();
        int i3 = WhenMappings.$EnumSwitchMapping$0[subscriptionPeriod.getUnit().ordinal()];
        if (i3 == 1) {
            return value / 30;
        }
        if (i3 == 2) {
            return value / 4;
        }
        if (i3 == 3) {
            return value;
        }
        if (i3 == 4) {
            return value * 12;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String periodWeeksString_delegate$lambda$20(RawStoreProduct rawStoreProduct) {
        return String.valueOf(rawStoreProduct.getPeriodWeeks());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int periodWeeks_delegate$lambda$19(RawStoreProduct rawStoreProduct) {
        SubscriptionPeriod subscriptionPeriod = rawStoreProduct.getSubscriptionPeriod();
        if (subscriptionPeriod == null) {
            return 0;
        }
        int value = subscriptionPeriod.getValue();
        int i3 = WhenMappings.$EnumSwitchMapping$0[subscriptionPeriod.getUnit().ordinal()];
        if (i3 == 1) {
            return value / 7;
        }
        if (i3 == 2) {
            return value;
        }
        if (i3 == 3) {
            return value * 4;
        }
        if (i3 == 4) {
            return value * 52;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String periodYearsString_delegate$lambda$26(RawStoreProduct rawStoreProduct) {
        return String.valueOf(rawStoreProduct.getPeriodYears());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int periodYears_delegate$lambda$25(RawStoreProduct rawStoreProduct) {
        SubscriptionPeriod subscriptionPeriod = rawStoreProduct.getSubscriptionPeriod();
        if (subscriptionPeriod == null) {
            return 0;
        }
        int value = subscriptionPeriod.getValue();
        int i3 = WhenMappings.$EnumSwitchMapping$0[subscriptionPeriod.getUnit().ordinal()];
        if (i3 == 1) {
            return value / 365;
        }
        if (i3 == 2) {
            return value / 52;
        }
        if (i3 == 3) {
            return value / 12;
        }
        if (i3 == 4) {
            return value;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String period_delegate$lambda$15(RawStoreProduct rawStoreProduct) {
        SubscriptionPeriod subscriptionPeriod = rawStoreProduct.getSubscriptionPeriod();
        if (subscriptionPeriod == null) {
            return "";
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[subscriptionPeriod.getUnit().ordinal()];
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
    public static final String periodly_delegate$lambda$17(RawStoreProduct rawStoreProduct) {
        String str;
        SubscriptionPeriod subscriptionPeriod = rawStoreProduct.getSubscriptionPeriod();
        if (subscriptionPeriod == null) {
            return "";
        }
        if (WhenMappings.$EnumSwitchMapping$0[subscriptionPeriod.getUnit().ordinal()] == 3) {
            int value = subscriptionPeriod.getValue();
            if (value == 2 || value == 6) {
                str = "every " + rawStoreProduct.getPeriod();
            } else {
                str = rawStoreProduct.getPeriod() + "ly";
            }
        } else {
            str = rawStoreProduct.getPeriod() + "ly";
        }
        return str == null ? "" : str;
    }

    private final BigDecimal periodsPerUnit(SubscriptionPeriod.Unit unit) {
        SubscriptionPeriod.Unit unit2;
        int i3;
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        int i4 = iArr[unit.ordinal()];
        if (i4 == 1) {
            SubscriptionPeriod trialSubscriptionPeriod = getTrialSubscriptionPeriod();
            unit2 = trialSubscriptionPeriod != null ? trialSubscriptionPeriod.getUnit() : null;
            i3 = unit2 != null ? iArr[unit2.ordinal()] : -1;
            if (i3 == 1) {
                return new BigDecimal(1);
            }
            if (i3 == 2) {
                return new BigDecimal(7);
            }
            if (i3 == 3) {
                BigDecimal bigDecimalDivide = new BigDecimal(365).divide(new BigDecimal(12), 6, RoundingMode.DOWN);
                Intrinsics.checkNotNullExpressionValue(bigDecimalDivide, "divide(...)");
                return bigDecimalDivide;
            }
            if (i3 == 4) {
                return new BigDecimal(365);
            }
            BigDecimal ZERO = BigDecimal.ZERO;
            Intrinsics.checkNotNullExpressionValue(ZERO, "ZERO");
            return ZERO;
        }
        if (i4 == 2) {
            SubscriptionPeriod trialSubscriptionPeriod2 = getTrialSubscriptionPeriod();
            unit2 = trialSubscriptionPeriod2 != null ? trialSubscriptionPeriod2.getUnit() : null;
            i3 = unit2 != null ? iArr[unit2.ordinal()] : -1;
            if (i3 == 1) {
                BigDecimal bigDecimalDivide2 = BigDecimal.ONE.divide(new BigDecimal(7), 6, RoundingMode.DOWN);
                Intrinsics.checkNotNullExpressionValue(bigDecimalDivide2, "divide(...)");
                return bigDecimalDivide2;
            }
            if (i3 == 2) {
                return new BigDecimal(1);
            }
            if (i3 == 3) {
                BigDecimal bigDecimalDivide3 = new BigDecimal(52).divide(new BigDecimal(12), 6, RoundingMode.DOWN);
                Intrinsics.checkNotNullExpressionValue(bigDecimalDivide3, "divide(...)");
                return bigDecimalDivide3;
            }
            if (i3 == 4) {
                return new BigDecimal(52);
            }
            BigDecimal ZERO2 = BigDecimal.ZERO;
            Intrinsics.checkNotNullExpressionValue(ZERO2, "ZERO");
            return ZERO2;
        }
        if (i4 != 3) {
            if (i4 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            SubscriptionPeriod trialSubscriptionPeriod3 = getTrialSubscriptionPeriod();
            unit2 = trialSubscriptionPeriod3 != null ? trialSubscriptionPeriod3.getUnit() : null;
            i3 = unit2 != null ? iArr[unit2.ordinal()] : -1;
            BigDecimal bigDecimalDivide4 = i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? BigDecimal.ZERO : BigDecimal.ONE : new BigDecimal(1).divide(new BigDecimal(12), 6, RoundingMode.DOWN) : new BigDecimal(1).divide(new BigDecimal(52), 6, RoundingMode.DOWN) : new BigDecimal(1).divide(new BigDecimal(365), 6, RoundingMode.DOWN);
            Intrinsics.checkNotNull(bigDecimalDivide4);
            return bigDecimalDivide4;
        }
        SubscriptionPeriod trialSubscriptionPeriod4 = getTrialSubscriptionPeriod();
        unit2 = trialSubscriptionPeriod4 != null ? trialSubscriptionPeriod4.getUnit() : null;
        i3 = unit2 != null ? iArr[unit2.ordinal()] : -1;
        if (i3 == 1) {
            BigDecimal bigDecimalDivide5 = new BigDecimal(12).divide(new BigDecimal(365), 6, RoundingMode.DOWN);
            Intrinsics.checkNotNullExpressionValue(bigDecimalDivide5, "divide(...)");
            return bigDecimalDivide5;
        }
        if (i3 == 2) {
            BigDecimal bigDecimalDivide6 = new BigDecimal(12).divide(new BigDecimal(52), 6, RoundingMode.DOWN);
            Intrinsics.checkNotNullExpressionValue(bigDecimalDivide6, "divide(...)");
            return bigDecimalDivide6;
        }
        if (i3 == 3) {
            return new BigDecimal(1);
        }
        if (i3 == 4) {
            return new BigDecimal(12);
        }
        BigDecimal ZERO3 = BigDecimal.ZERO;
        Intrinsics.checkNotNullExpressionValue(ZERO3, "ZERO");
        return ZERO3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NumberFormat priceFormatter_delegate$lambda$1(RawStoreProduct rawStoreProduct) {
        String currencyCode = rawStoreProduct.getCurrencyCode();
        if (currencyCode != null) {
            return rawStoreProduct.priceFormatterProvider.priceFormatter(currencyCode);
        }
        return null;
    }

    private final BigDecimal pricePerUnit(SubscriptionPeriod.Unit unit, ProductDetails.PricingPhase pricingPhase) {
        if (pricingPhase.d() == 0) {
            BigDecimal ZERO = BigDecimal.ZERO;
            Intrinsics.checkNotNullExpressionValue(ZERO, "ZERO");
            return ZERO;
        }
        BigDecimal bigDecimalMultiply = new BigDecimal(pricingPhase.d()).divide(new BigDecimal(1000000), 6, RoundingMode.DOWN).multiply(new BigDecimal(pricingPhase.a()));
        ProductDetails.PricingPhase selectedOfferPricingPhase = getSelectedOfferPricingPhase();
        SubscriptionPeriod subscriptionPeriodFrom = null;
        String strB = selectedOfferPricingPhase != null ? selectedOfferPricingPhase.b() : null;
        if (strB != null) {
            try {
                subscriptionPeriodFrom = SubscriptionPeriod.Companion.from(strB);
            } catch (Throwable unused) {
            }
        }
        BigDecimal bigDecimalMultiply2 = periodsPerUnit(unit).multiply(new BigDecimal(pricingPhase.a())).multiply(new BigDecimal(subscriptionPeriodFrom != null ? subscriptionPeriodFrom.getValue() : 0));
        if (bigDecimalMultiply2.compareTo(BigDecimal.ONE) < 0) {
            Intrinsics.checkNotNull(bigDecimalMultiply);
            return bigDecimalMultiply;
        }
        BigDecimal bigDecimalDivide = bigDecimalMultiply.divide(bigDecimalMultiply2, 2, RoundingMode.DOWN);
        Intrinsics.checkNotNull(bigDecimalDivide);
        return bigDecimalDivide;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BigDecimal price_delegate$lambda$10(RawStoreProduct rawStoreProduct) {
        BigDecimal bigDecimalDivide;
        if (rawStoreProduct.getSelectedOffer() != null) {
            return rawStoreProduct.getBasePriceForSelectedOffer();
        }
        ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetailsC = rawStoreProduct.underlyingProductDetails.c();
        return (oneTimePurchaseOfferDetailsC == null || (bigDecimalDivide = new BigDecimal(oneTimePurchaseOfferDetailsC.d()).divide(new BigDecimal(1000000), 2, RoundingMode.DOWN)) == null) ? BigDecimal.ZERO : bigDecimalDivide;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String productIdentifier_delegate$lambda$8(RawStoreProduct rawStoreProduct) {
        return rawStoreProduct.underlyingProductDetails.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String regionCode_delegate$lambda$94() {
        return Locale.getDefault().getCountry();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProductDetails.PricingPhase selectedOfferPricingPhase_delegate$lambda$7(RawStoreProduct rawStoreProduct) {
        Object next;
        SelectedOfferDetails selectedOffer = rawStoreProduct.getSelectedOffer();
        Object obj = null;
        if (!(selectedOffer instanceof SelectedOfferDetails.Subscription)) {
            if ((selectedOffer instanceof SelectedOfferDetails.OneTime) || selectedOffer == null) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }
        SelectedOfferDetails.Subscription subscription = (SelectedOfferDetails.Subscription) selectedOffer;
        List listA = subscription.getUnderlying().f().a();
        Intrinsics.checkNotNullExpressionValue(listA, "getPricingPhaseList(...)");
        Iterator it = listA.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((ProductDetails.PricingPhase) next).d() == 0) {
                break;
            }
        }
        ProductDetails.PricingPhase pricingPhase = (ProductDetails.PricingPhase) next;
        if (pricingPhase != null) {
            return pricingPhase;
        }
        List listA2 = subscription.getUnderlying().f().a();
        Intrinsics.checkNotNullExpressionValue(listA2, "getPricingPhaseList(...)");
        Iterator it2 = CollectionsKt.dropLast(listA2, 1).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (((ProductDetails.PricingPhase) next2).d() != 0) {
                obj = next2;
                break;
            }
        }
        return (ProductDetails.PricingPhase) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SubscriptionPeriod subscriptionPeriod_delegate$lambda$95(RawStoreProduct rawStoreProduct) {
        SelectedOfferDetails selectedOffer = rawStoreProduct.getSelectedOffer();
        if (!(selectedOffer instanceof SelectedOfferDetails.Subscription)) {
            if ((selectedOffer instanceof SelectedOfferDetails.OneTime) || selectedOffer == null) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }
        List listA = ((SelectedOfferDetails.Subscription) selectedOffer).getUnderlying().f().a();
        Intrinsics.checkNotNullExpressionValue(listA, "getPricingPhaseList(...)");
        String strB = ((ProductDetails.PricingPhase) CollectionsKt.last(listA)).b();
        Intrinsics.checkNotNullExpressionValue(strB, "getBillingPeriod(...)");
        try {
            return SubscriptionPeriod.Companion.from(strB);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String trialPeriodDaysString_delegate$lambda$79(RawStoreProduct rawStoreProduct) {
        return String.valueOf(rawStoreProduct.getTrialPeriodDays());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int trialPeriodDays_delegate$lambda$78(RawStoreProduct rawStoreProduct) {
        SubscriptionPeriod trialSubscriptionPeriod = rawStoreProduct.getTrialSubscriptionPeriod();
        if (trialSubscriptionPeriod == null) {
            return 0;
        }
        int value = trialSubscriptionPeriod.getValue();
        int i3 = WhenMappings.$EnumSwitchMapping$0[trialSubscriptionPeriod.getUnit().ordinal()];
        if (i3 == 1) {
            return value;
        }
        if (i3 == 2) {
            return value * 7;
        }
        if (i3 == 3) {
            return value * 30;
        }
        if (i3 == 4) {
            return value * 365;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String trialPeriodEndDateString_delegate$lambda$76(RawStoreProduct rawStoreProduct) {
        String str;
        Date trialPeriodEndDate = rawStoreProduct.getTrialPeriodEndDate();
        return (trialPeriodEndDate == null || (str = DateUtilsKt.localizedDateFormat(DateUtils.INSTANCE.getMMM_dd_yyyy()).format(trialPeriodEndDate)) == null) ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Date trialPeriodEndDate_delegate$lambda$74(RawStoreProduct rawStoreProduct) {
        SubscriptionPeriod trialSubscriptionPeriod = rawStoreProduct.getTrialSubscriptionPeriod();
        if (trialSubscriptionPeriod == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        int i3 = WhenMappings.$EnumSwitchMapping$0[trialSubscriptionPeriod.getUnit().ordinal()];
        if (i3 == 1) {
            calendar.add(6, trialSubscriptionPeriod.getValue());
        } else if (i3 == 2) {
            calendar.add(3, trialSubscriptionPeriod.getValue());
        } else if (i3 == 3) {
            calendar.add(2, trialSubscriptionPeriod.getValue());
        } else {
            if (i3 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            calendar.add(1, trialSubscriptionPeriod.getValue());
        }
        return calendar.getTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String trialPeriodMonthsString_delegate$lambda$84(RawStoreProduct rawStoreProduct) {
        return String.valueOf(rawStoreProduct.getTrialPeriodMonths());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int trialPeriodMonths_delegate$lambda$83(RawStoreProduct rawStoreProduct) {
        SubscriptionPeriod trialSubscriptionPeriod = rawStoreProduct.getTrialSubscriptionPeriod();
        if (trialSubscriptionPeriod == null) {
            return 0;
        }
        int value = trialSubscriptionPeriod.getValue();
        int i3 = WhenMappings.$EnumSwitchMapping$0[trialSubscriptionPeriod.getUnit().ordinal()];
        if (i3 == 1) {
            return value / 30;
        }
        if (i3 == 2) {
            return value / 4;
        }
        if (i3 == 3) {
            return value;
        }
        if (i3 == 4) {
            return value * 12;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BigDecimal trialPeriodPrice_delegate$lambda$39(RawStoreProduct rawStoreProduct) {
        Object obj;
        Object next;
        BigDecimal bigDecimalDivide;
        SelectedOfferDetails selectedOffer = rawStoreProduct.getSelectedOffer();
        if (!(selectedOffer instanceof SelectedOfferDetails.Subscription)) {
            if (selectedOffer instanceof SelectedOfferDetails.OneTime) {
                return BigDecimal.ZERO;
            }
            if (selectedOffer == null) {
                return BigDecimal.ZERO;
            }
            throw new NoWhenBranchMatchedException();
        }
        List listA = ((SelectedOfferDetails.Subscription) selectedOffer).getUnderlying().f().a();
        Intrinsics.checkNotNullExpressionValue(listA, "getPricingPhaseList(...)");
        List listDropLast = CollectionsKt.dropLast(listA, 1);
        if (listDropLast.isEmpty()) {
            return BigDecimal.ZERO;
        }
        List list = listDropLast;
        Iterator it = list.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((ProductDetails.PricingPhase) next).d() == 0) {
                break;
            }
        }
        if (((ProductDetails.PricingPhase) next) != null) {
            return BigDecimal.ZERO;
        }
        Iterator it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (((ProductDetails.PricingPhase) next2).d() > 0) {
                obj = next2;
                break;
            }
        }
        ProductDetails.PricingPhase pricingPhase = (ProductDetails.PricingPhase) obj;
        return (pricingPhase == null || (bigDecimalDivide = new BigDecimal(pricingPhase.d()).divide(new BigDecimal(1000000), 2, RoundingMode.DOWN)) == null) ? BigDecimal.ZERO : bigDecimalDivide;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String trialPeriodText_delegate$lambda$88(RawStoreProduct rawStoreProduct) {
        SubscriptionPeriod trialSubscriptionPeriod = rawStoreProduct.getTrialSubscriptionPeriod();
        if (trialSubscriptionPeriod == null) {
            return "";
        }
        int value = trialSubscriptionPeriod.getValue();
        int i3 = WhenMappings.$EnumSwitchMapping$0[trialSubscriptionPeriod.getUnit().ordinal()];
        if (i3 == 1) {
            return value + "-day";
        }
        if (i3 == 2) {
            return (value * 7) + "-day";
        }
        if (i3 == 3) {
            return (value * 30) + "-day";
        }
        if (i3 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return (value * 365) + "-day";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String trialPeriodWeeksString_delegate$lambda$81(RawStoreProduct rawStoreProduct) {
        return String.valueOf(rawStoreProduct.getTrialPeriodWeeks());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int trialPeriodWeeks_delegate$lambda$80(RawStoreProduct rawStoreProduct) {
        SubscriptionPeriod trialSubscriptionPeriod = rawStoreProduct.getTrialSubscriptionPeriod();
        if (trialSubscriptionPeriod == null) {
            return 0;
        }
        int value = trialSubscriptionPeriod.getValue();
        int i3 = WhenMappings.$EnumSwitchMapping$0[trialSubscriptionPeriod.getUnit().ordinal()];
        if (i3 == 1) {
            return value / 7;
        }
        if (i3 == 2) {
            return value;
        }
        if (i3 == 3) {
            return value * 4;
        }
        if (i3 == 4) {
            return value * 52;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String trialPeriodYearsString_delegate$lambda$87(RawStoreProduct rawStoreProduct) {
        return String.valueOf(rawStoreProduct.getTrialPeriodYears());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int trialPeriodYears_delegate$lambda$86(RawStoreProduct rawStoreProduct) {
        SubscriptionPeriod trialSubscriptionPeriod = rawStoreProduct.getTrialSubscriptionPeriod();
        if (trialSubscriptionPeriod == null) {
            return 0;
        }
        int value = trialSubscriptionPeriod.getValue();
        int i3 = WhenMappings.$EnumSwitchMapping$0[trialSubscriptionPeriod.getUnit().ordinal()];
        if (i3 == 1) {
            return value / 365;
        }
        if (i3 == 2) {
            return value / 52;
        }
        if (i3 == 3) {
            return value / 12;
        }
        if (i3 == 4) {
            return value;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SubscriptionPeriod trialSubscriptionPeriod_delegate$lambda$98(RawStoreProduct rawStoreProduct) {
        if (rawStoreProduct.underlyingProductDetails.c() != null) {
            return null;
        }
        ProductDetails.PricingPhase selectedOfferPricingPhase = rawStoreProduct.getSelectedOfferPricingPhase();
        String strB = selectedOfferPricingPhase != null ? selectedOfferPricingPhase.b() : null;
        if (strB != null) {
            try {
                return SubscriptionPeriod.Companion.from(strB);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String weeklyPrice_delegate$lambda$31(RawStoreProduct rawStoreProduct) {
        String str;
        String str2;
        if (rawStoreProduct.getSelectedOffer() instanceof SelectedOfferDetails.OneTime) {
            return "n/a";
        }
        BigDecimal basePriceForSelectedOffer = rawStoreProduct.getBasePriceForSelectedOffer();
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (Intrinsics.areEqual(basePriceForSelectedOffer, bigDecimal)) {
            NumberFormat priceFormatter = rawStoreProduct.getPriceFormatter();
            return (priceFormatter == null || (str2 = priceFormatter.format(bigDecimal)) == null) ? "$0.00" : str2;
        }
        SubscriptionPeriod subscriptionPeriod = rawStoreProduct.getSubscriptionPeriod();
        if (subscriptionPeriod == null) {
            return "n/a";
        }
        Intrinsics.checkNotNull(basePriceForSelectedOffer);
        BigDecimal bigDecimalPricePerWeek = subscriptionPeriod.pricePerWeek(basePriceForSelectedOffer);
        NumberFormat priceFormatter2 = rawStoreProduct.getPriceFormatter();
        return (priceFormatter2 == null || (str = priceFormatter2.format(bigDecimalPricePerWeek)) == null) ? "n/a" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String yearlyPrice_delegate$lambda$33(RawStoreProduct rawStoreProduct) {
        String str;
        String str2;
        if (rawStoreProduct.getSelectedOffer() instanceof SelectedOfferDetails.OneTime) {
            return "n/a";
        }
        BigDecimal basePriceForSelectedOffer = rawStoreProduct.getBasePriceForSelectedOffer();
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (Intrinsics.areEqual(basePriceForSelectedOffer, bigDecimal)) {
            NumberFormat priceFormatter = rawStoreProduct.getPriceFormatter();
            return (priceFormatter == null || (str2 = priceFormatter.format(bigDecimal)) == null) ? "$0.00" : str2;
        }
        SubscriptionPeriod subscriptionPeriod = rawStoreProduct.getSubscriptionPeriod();
        if (subscriptionPeriod == null) {
            return "n/a";
        }
        Intrinsics.checkNotNull(basePriceForSelectedOffer);
        BigDecimal bigDecimalPricePerYear = subscriptionPeriod.pricePerYear(basePriceForSelectedOffer);
        NumberFormat priceFormatter2 = rawStoreProduct.getPriceFormatter();
        return (priceFormatter2 == null || (str = priceFormatter2.format(bigDecimalPricePerYear)) == null) ? "n/a" : str;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public Map<String, String> getAttributes() {
        return StoreProductType.DefaultImpls.getAttributes(this);
    }

    public final String getBasePlanId() {
        return this.basePlanType.getSpecificId();
    }

    public final BasePlanType getBasePlanType() {
        return this.basePlanType;
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
        return this.fullIdentifier;
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

    public final String getOfferId$superwall_release() {
        return (String) this.offerId$delegate.getValue();
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

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public BigDecimal getPrice() {
        return (BigDecimal) this.price$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getProductIdentifier() {
        return (String) this.productIdentifier$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getProductType() {
        String strF = this.underlyingProductDetails.f();
        Intrinsics.checkNotNullExpressionValue(strF, "getProductType(...)");
        return strF;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getRegionCode() {
        return (String) this.regionCode$delegate.getValue();
    }

    public final SelectedOfferDetails getSelectedOffer() {
        return (SelectedOfferDetails) this.selectedOffer$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getStoreFrontCountryCode() {
        return StoreProductType.DefaultImpls.getStoreFrontCountryCode(this);
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
        Object value = this.trialPeriodPrice$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (BigDecimal) value;
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

    public final ProductDetails getUnderlyingProductDetails() {
        return this.underlyingProductDetails;
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getWeeklyPrice() {
        return (String) this.weeklyPrice$delegate.getValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String getYearlyPrice() {
        return (String) this.yearlyPrice$delegate.getValue();
    }

    public final boolean isSubscription$superwall_release() {
        return ((Boolean) this.isSubscription$delegate.getValue()).booleanValue();
    }

    @Override // com.superwall.sdk.store.abstractions.product.StoreProductType
    public String trialPeriodPricePerUnit(SubscriptionPeriod.Unit unit) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(unit, "unit");
        ProductDetails.PricingPhase selectedOfferPricingPhase = getSelectedOfferPricingPhase();
        if (selectedOfferPricingPhase == null) {
            NumberFormat priceFormatter = getPriceFormatter();
            return (priceFormatter == null || (str3 = priceFormatter.format(0L)) == null) ? "$0.00" : str3;
        }
        if (selectedOfferPricingPhase.d() == 0) {
            NumberFormat priceFormatter2 = getPriceFormatter();
            return (priceFormatter2 == null || (str2 = priceFormatter2.format(0L)) == null) ? "$0.00" : str2;
        }
        BigDecimal bigDecimalPricePerUnit = pricePerUnit(unit, selectedOfferPricingPhase);
        NumberFormat priceFormatter3 = getPriceFormatter();
        return (priceFormatter3 == null || (str = priceFormatter3.format(bigDecimalPricePerUnit)) == null) ? "$0.00" : str;
    }

    @Transient
    private static /* synthetic */ void getPriceFormatterProvider$annotations() {
    }
}
