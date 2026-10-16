package com.revenuecat.purchases.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import com.revenuecat.purchases.utils.PriceExtensionsKt;
import java.util.Locale;
import kotlin.Deprecated;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class PricingPhase implements Parcelable {
    public static final Parcelable.Creator<PricingPhase> CREATOR = new Creator();
    private final Integer billingCycleCount;
    private final Period billingPeriod;
    private final Price price;
    private final RecurrenceMode recurrenceMode;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Creator implements Parcelable.Creator<PricingPhase> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PricingPhase createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PricingPhase(Period.CREATOR.createFromParcel(parcel), RecurrenceMode.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), Price.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PricingPhase[] newArray(int i3) {
            return new PricingPhase[i3];
        }
    }

    public PricingPhase(Period billingPeriod, RecurrenceMode recurrenceMode, Integer num, Price price) {
        Intrinsics.checkNotNullParameter(billingPeriod, "billingPeriod");
        Intrinsics.checkNotNullParameter(recurrenceMode, "recurrenceMode");
        Intrinsics.checkNotNullParameter(price, "price");
        this.billingPeriod = billingPeriod;
        this.recurrenceMode = recurrenceMode;
        this.billingCycleCount = num;
        this.price = price;
    }

    public static /* synthetic */ String formattedPriceInMonths$default(PricingPhase pricingPhase, Locale locale, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        return pricingPhase.formattedPriceInMonths(locale);
    }

    public static /* synthetic */ Price pricePerDay$default(PricingPhase pricingPhase, Locale locale, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        return pricingPhase.pricePerDay(locale);
    }

    public static /* synthetic */ Price pricePerMonth$default(PricingPhase pricingPhase, Locale locale, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        return pricingPhase.pricePerMonth(locale);
    }

    public static /* synthetic */ Price pricePerWeek$default(PricingPhase pricingPhase, Locale locale, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        return pricingPhase.pricePerWeek(locale);
    }

    public static /* synthetic */ Price pricePerYear$default(PricingPhase pricingPhase, Locale locale, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        return pricingPhase.pricePerYear(locale);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PricingPhase)) {
            return false;
        }
        PricingPhase pricingPhase = (PricingPhase) obj;
        return Intrinsics.areEqual(this.billingPeriod, pricingPhase.billingPeriod) && this.recurrenceMode == pricingPhase.recurrenceMode && Intrinsics.areEqual(this.billingCycleCount, pricingPhase.billingCycleCount) && Intrinsics.areEqual(this.price, pricingPhase.price);
    }

    @Deprecated
    public final String formattedPriceInMonths() {
        return formattedPriceInMonths$default(this, null, 1, null);
    }

    public final Integer getBillingCycleCount() {
        return this.billingCycleCount;
    }

    public final Period getBillingPeriod() {
        return this.billingPeriod;
    }

    public final OfferPaymentMode getOfferPaymentMode() {
        if (this.recurrenceMode != RecurrenceMode.FINITE_RECURRING) {
            return null;
        }
        if (this.price.getAmountMicros() == 0) {
            return OfferPaymentMode.FREE_TRIAL;
        }
        Integer num = this.billingCycleCount;
        if (num != null && num.intValue() == 1) {
            return OfferPaymentMode.SINGLE_PAYMENT;
        }
        Integer num2 = this.billingCycleCount;
        if (num2 == null || num2.intValue() <= 1) {
            return null;
        }
        return OfferPaymentMode.DISCOUNTED_RECURRING_PAYMENT;
    }

    public final Price getPrice() {
        return this.price;
    }

    public final RecurrenceMode getRecurrenceMode() {
        return this.recurrenceMode;
    }

    public int hashCode() {
        int iHashCode = ((this.billingPeriod.hashCode() * 31) + this.recurrenceMode.hashCode()) * 31;
        Integer num = this.billingCycleCount;
        return ((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.price.hashCode();
    }

    public final Price pricePerDay() {
        return pricePerDay$default(this, null, 1, null);
    }

    public final Price pricePerMonth() {
        return pricePerMonth$default(this, null, 1, null);
    }

    public final Price pricePerWeek() {
        return pricePerWeek$default(this, null, 1, null);
    }

    public final Price pricePerYear() {
        return pricePerYear$default(this, null, 1, null);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(out, "out");
        this.billingPeriod.writeToParcel(out, i3);
        out.writeString(this.recurrenceMode.name());
        Integer num = this.billingCycleCount;
        if (num == null) {
            iIntValue = 0;
        } else {
            out.writeInt(1);
            iIntValue = num.intValue();
        }
        out.writeInt(iIntValue);
        this.price.writeToParcel(out, i3);
    }

    @Deprecated
    public final String formattedPriceInMonths(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        return pricePerMonth(locale).getFormatted();
    }

    public final Price pricePerDay(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        return PriceExtensionsKt.pricePerDay(this.price, this.billingPeriod, locale);
    }

    public final Price pricePerMonth(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        return PriceExtensionsKt.pricePerMonth(this.price, this.billingPeriod, locale);
    }

    public final Price pricePerWeek(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        return PriceExtensionsKt.pricePerWeek(this.price, this.billingPeriod, locale);
    }

    public final Price pricePerYear(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        return PriceExtensionsKt.pricePerYear(this.price, this.billingPeriod, locale);
    }

    public String toString() {
        return "PricingPhase(billingPeriod=" + this.billingPeriod + ", recurrenceMode=" + this.recurrenceMode + ", billingCycleCount=" + this.billingCycleCount + SbbqvQlxi.Eirmx + this.price + ')';
    }
}
