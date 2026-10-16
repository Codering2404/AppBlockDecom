package com.revenuecat.purchases.common;

import com.facebook.internal.Utility;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PresentedOfferingContextSerializer;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.ReplacementModeSerializer;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.PeriodSerializer;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.PricingPhaseSerializer;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LongSerializer;
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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
@Serializable
public final class ReceiptInfo {
    private static final KSerializer<Object>[] $childSerializers;
    public static final Companion Companion = new Companion(null);
    private final String currency;
    private final String duration;
    private final String formattedPrice;
    private final String marketplace;
    private final Period period;
    private final List<Map<String, String>> platformProductIds;
    private final PresentedOfferingContext presentedOfferingContext;
    private final Double price;
    private final List<PricingPhase> pricingPhases;
    private final List<String> productIDs;
    private final Long purchaseTime;
    private final ReplacementMode replacementMode;
    private final boolean sdkOriginated;
    private final String storeUserID;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ReceiptInfo from$default(Companion companion, StoreTransaction storeTransaction, StoreProduct storeProduct, Map map, boolean z2, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                z2 = false;
            }
            return companion.from(storeTransaction, storeProduct, map, z2);
        }

        public final ReceiptInfo from(StoreTransaction storeTransaction, StoreProduct storeProduct, Map<String, ? extends SubscriptionOption> map, boolean z2) {
            SubscriptionOption subscriptionOption;
            PlatformProductId platformProductId;
            Price price;
            Price price2;
            Price price3;
            SubscriptionOption subscriptionOption2;
            PlatformProductId platformProductId2;
            Map<String, String> asMap;
            SubscriptionOptions subscriptionOptions;
            SubscriptionOption next;
            Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
            if (storeProduct == null || (subscriptionOptions = storeProduct.getSubscriptionOptions()) == null) {
                subscriptionOption = null;
            } else {
                Iterator<SubscriptionOption> it = subscriptionOptions.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (Intrinsics.areEqual(next.getId(), storeTransaction.getSubscriptionOptionId())) {
                        break;
                    }
                }
                subscriptionOption = next;
            }
            if (subscriptionOption == null || (platformProductId = ReceiptInfoKt.platformProductId(subscriptionOption)) == null) {
                platformProductId = storeProduct != null ? ReceiptInfoKt.platformProductId(storeProduct) : null;
            }
            List<String> productIds = storeTransaction.getProductIds();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(productIds, 10));
            for (String str : productIds) {
                arrayList.add(Intrinsics.areEqual(str, platformProductId != null ? platformProductId.getProductId() : null) ? platformProductId.getAsMap() : (map == null || (subscriptionOption2 = map.get(str)) == null || (platformProductId2 = ReceiptInfoKt.platformProductId(subscriptionOption2)) == null || (asMap = platformProductId2.getAsMap()) == null) ? new PlatformProductId(str).getAsMap() : asMap);
            }
            return new ReceiptInfo(storeTransaction.getProductIds(), Long.valueOf(storeTransaction.getPurchaseTime()), storeTransaction.getPresentedOfferingContext(), (storeProduct == null || (price3 = storeProduct.getPrice()) == null) ? null : Double.valueOf(price3.getAmountMicros() / 1000000.0d), (storeProduct == null || (price2 = storeProduct.getPrice()) == null) ? null : price2.getFormatted(), (storeProduct == null || (price = storeProduct.getPrice()) == null) ? null : price.getCurrencyCode(), storeProduct != null ? storeProduct.getPeriod() : null, subscriptionOption != null ? subscriptionOption.getPricingPhases() : null, storeTransaction.getReplacementMode(), arrayList, z2, storeTransaction.getStoreUserID(), storeTransaction.getMarketplace());
        }

        public final KSerializer<ReceiptInfo> serializer() {
            return ReceiptInfo$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        StringSerializer stringSerializer = StringSerializer.f142891a;
        $childSerializers = new KSerializer[]{new ArrayListSerializer(stringSerializer), null, null, null, null, null, null, new ArrayListSerializer(PricingPhaseSerializer.INSTANCE), null, new ArrayListSerializer(new LinkedHashMapSerializer(stringSerializer, BuiltinSerializersKt.u(stringSerializer))), null, null, null, null};
    }

    @Deprecated
    public /* synthetic */ ReceiptInfo(int i3, List list, Long l3, @Serializable(with = PresentedOfferingContextSerializer.class) PresentedOfferingContext presentedOfferingContext, Double d3, String str, String str2, @Serializable(with = PeriodSerializer.class) Period period, List list2, @Serializable(with = ReplacementModeSerializer.class) ReplacementMode replacementMode, List list3, boolean z2, String str3, String str4, String str5, SerializationConstructorMarker serializationConstructorMarker) {
        String iso8601;
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, ReceiptInfo$$serializer.INSTANCE.getDescriptor());
        }
        this.productIDs = list;
        String str6 = null;
        if ((i3 & 2) == 0) {
            this.purchaseTime = null;
        } else {
            this.purchaseTime = l3;
        }
        if ((i3 & 4) == 0) {
            this.presentedOfferingContext = null;
        } else {
            this.presentedOfferingContext = presentedOfferingContext;
        }
        if ((i3 & 8) == 0) {
            this.price = null;
        } else {
            this.price = d3;
        }
        if ((i3 & 16) == 0) {
            this.formattedPrice = null;
        } else {
            this.formattedPrice = str;
        }
        if ((i3 & 32) == 0) {
            this.currency = null;
        } else {
            this.currency = str2;
        }
        if ((i3 & 64) == 0) {
            this.period = null;
        } else {
            this.period = period;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
            this.pricingPhases = null;
        } else {
            this.pricingPhases = list2;
        }
        if ((i3 & Function.MAX_NARGS) == 0) {
            this.replacementMode = null;
        } else {
            this.replacementMode = replacementMode;
        }
        if ((i3 & 512) == 0) {
            this.platformProductIds = CollectionsKt.emptyList();
        } else {
            this.platformProductIds = list3;
        }
        if ((i3 & 1024) == 0) {
            this.sdkOriginated = false;
        } else {
            this.sdkOriginated = z2;
        }
        if ((i3 & 2048) == 0) {
            this.storeUserID = null;
        } else {
            this.storeUserID = str3;
        }
        if ((i3 & 4096) == 0) {
            this.marketplace = null;
        } else {
            this.marketplace = str4;
        }
        if ((i3 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0) {
            this.duration = str5;
            return;
        }
        Period period2 = this.period;
        if (period2 != null && (iso8601 = period2.getIso8601()) != null && iso8601.length() != 0) {
            str6 = iso8601;
        }
        this.duration = str6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReceiptInfo copy$default(ReceiptInfo receiptInfo, List list, Long l3, PresentedOfferingContext presentedOfferingContext, Double d3, String str, String str2, Period period, List list2, ReplacementMode replacementMode, List list3, boolean z2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = receiptInfo.productIDs;
        }
        return receiptInfo.copy(list, (i3 & 2) != 0 ? receiptInfo.purchaseTime : l3, (i3 & 4) != 0 ? receiptInfo.presentedOfferingContext : presentedOfferingContext, (i3 & 8) != 0 ? receiptInfo.price : d3, (i3 & 16) != 0 ? receiptInfo.formattedPrice : str, (i3 & 32) != 0 ? receiptInfo.currency : str2, (i3 & 64) != 0 ? receiptInfo.period : period, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? receiptInfo.pricingPhases : list2, (i3 & Function.MAX_NARGS) != 0 ? receiptInfo.replacementMode : replacementMode, (i3 & 512) != 0 ? receiptInfo.platformProductIds : list3, (i3 & 1024) != 0 ? receiptInfo.sdkOriginated : z2, (i3 & 2048) != 0 ? receiptInfo.storeUserID : str3, (i3 & 4096) != 0 ? receiptInfo.marketplace : str4);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(ReceiptInfo receiptInfo, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        String iso8601;
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        compositeEncoder.C(serialDescriptor, 0, kSerializerArr[0], receiptInfo.productIDs);
        if (compositeEncoder.z(serialDescriptor, 1) || receiptInfo.purchaseTime != null) {
            compositeEncoder.i(serialDescriptor, 1, LongSerializer.f142836a, receiptInfo.purchaseTime);
        }
        if (compositeEncoder.z(serialDescriptor, 2) || receiptInfo.presentedOfferingContext != null) {
            compositeEncoder.i(serialDescriptor, 2, PresentedOfferingContextSerializer.INSTANCE, receiptInfo.presentedOfferingContext);
        }
        if (compositeEncoder.z(serialDescriptor, 3) || receiptInfo.price != null) {
            compositeEncoder.i(serialDescriptor, 3, DoubleSerializer.f142796a, receiptInfo.price);
        }
        if (compositeEncoder.z(serialDescriptor, 4) || receiptInfo.formattedPrice != null) {
            compositeEncoder.i(serialDescriptor, 4, StringSerializer.f142891a, receiptInfo.formattedPrice);
        }
        if (compositeEncoder.z(serialDescriptor, 5) || receiptInfo.currency != null) {
            compositeEncoder.i(serialDescriptor, 5, StringSerializer.f142891a, receiptInfo.currency);
        }
        if (compositeEncoder.z(serialDescriptor, 6) || receiptInfo.period != null) {
            compositeEncoder.i(serialDescriptor, 6, PeriodSerializer.INSTANCE, receiptInfo.period);
        }
        if (compositeEncoder.z(serialDescriptor, 7) || receiptInfo.pricingPhases != null) {
            compositeEncoder.i(serialDescriptor, 7, kSerializerArr[7], receiptInfo.pricingPhases);
        }
        if (compositeEncoder.z(serialDescriptor, 8) || receiptInfo.replacementMode != null) {
            compositeEncoder.i(serialDescriptor, 8, ReplacementModeSerializer.INSTANCE, receiptInfo.replacementMode);
        }
        if (compositeEncoder.z(serialDescriptor, 9) || !Intrinsics.areEqual(receiptInfo.platformProductIds, CollectionsKt.emptyList())) {
            compositeEncoder.C(serialDescriptor, 9, kSerializerArr[9], receiptInfo.platformProductIds);
        }
        if (compositeEncoder.z(serialDescriptor, 10) || receiptInfo.sdkOriginated) {
            compositeEncoder.x(serialDescriptor, 10, receiptInfo.sdkOriginated);
        }
        if (compositeEncoder.z(serialDescriptor, 11) || receiptInfo.storeUserID != null) {
            compositeEncoder.i(serialDescriptor, 11, StringSerializer.f142891a, receiptInfo.storeUserID);
        }
        if (compositeEncoder.z(serialDescriptor, 12) || receiptInfo.marketplace != null) {
            compositeEncoder.i(serialDescriptor, 12, StringSerializer.f142891a, receiptInfo.marketplace);
        }
        if (!compositeEncoder.z(serialDescriptor, 13)) {
            String str = receiptInfo.duration;
            Period period = receiptInfo.period;
            String str2 = null;
            if (period != null && (iso8601 = period.getIso8601()) != null && iso8601.length() != 0) {
                str2 = iso8601;
            }
            if (Intrinsics.areEqual(str, str2)) {
                return;
            }
        }
        compositeEncoder.i(serialDescriptor, 13, StringSerializer.f142891a, receiptInfo.duration);
    }

    public final List<String> component1() {
        return this.productIDs;
    }

    public final List<Map<String, String>> component10() {
        return this.platformProductIds;
    }

    public final boolean component11() {
        return this.sdkOriginated;
    }

    public final String component12() {
        return this.storeUserID;
    }

    public final String component13() {
        return this.marketplace;
    }

    public final Long component2() {
        return this.purchaseTime;
    }

    public final PresentedOfferingContext component3() {
        return this.presentedOfferingContext;
    }

    public final Double component4() {
        return this.price;
    }

    public final String component5() {
        return this.formattedPrice;
    }

    public final String component6() {
        return this.currency;
    }

    public final Period component7() {
        return this.period;
    }

    public final List<PricingPhase> component8() {
        return this.pricingPhases;
    }

    public final ReplacementMode component9() {
        return this.replacementMode;
    }

    public final ReceiptInfo copy(List<String> productIDs, Long l3, PresentedOfferingContext presentedOfferingContext, Double d3, String str, String str2, Period period, List<PricingPhase> list, ReplacementMode replacementMode, List<? extends Map<String, String>> platformProductIds, boolean z2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(productIDs, "productIDs");
        Intrinsics.checkNotNullParameter(platformProductIds, "platformProductIds");
        return new ReceiptInfo(productIDs, l3, presentedOfferingContext, d3, str, str2, period, list, replacementMode, platformProductIds, z2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReceiptInfo)) {
            return false;
        }
        ReceiptInfo receiptInfo = (ReceiptInfo) obj;
        return Intrinsics.areEqual(this.productIDs, receiptInfo.productIDs) && Intrinsics.areEqual(this.purchaseTime, receiptInfo.purchaseTime) && Intrinsics.areEqual(this.presentedOfferingContext, receiptInfo.presentedOfferingContext) && Intrinsics.areEqual((Object) this.price, (Object) receiptInfo.price) && Intrinsics.areEqual(this.formattedPrice, receiptInfo.formattedPrice) && Intrinsics.areEqual(this.currency, receiptInfo.currency) && Intrinsics.areEqual(this.period, receiptInfo.period) && Intrinsics.areEqual(this.pricingPhases, receiptInfo.pricingPhases) && Intrinsics.areEqual(this.replacementMode, receiptInfo.replacementMode) && Intrinsics.areEqual(this.platformProductIds, receiptInfo.platformProductIds) && this.sdkOriginated == receiptInfo.sdkOriginated && Intrinsics.areEqual(this.storeUserID, receiptInfo.storeUserID) && Intrinsics.areEqual(this.marketplace, receiptInfo.marketplace);
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getFormattedPrice() {
        return this.formattedPrice;
    }

    public final String getMarketplace() {
        return this.marketplace;
    }

    public final Period getPeriod() {
        return this.period;
    }

    public final List<Map<String, String>> getPlatformProductIds() {
        return this.platformProductIds;
    }

    public final PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    public final Double getPrice() {
        return this.price;
    }

    public final List<PricingPhase> getPricingPhases() {
        return this.pricingPhases;
    }

    public final List<String> getProductIDs() {
        return this.productIDs;
    }

    public final Long getPurchaseTime() {
        return this.purchaseTime;
    }

    public final ReplacementMode getReplacementMode() {
        return this.replacementMode;
    }

    public final boolean getSdkOriginated() {
        return this.sdkOriginated;
    }

    public final String getStoreUserID() {
        return this.storeUserID;
    }

    public int hashCode() {
        int iHashCode = this.productIDs.hashCode() * 31;
        Long l3 = this.purchaseTime;
        int iHashCode2 = (iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31;
        PresentedOfferingContext presentedOfferingContext = this.presentedOfferingContext;
        int iHashCode3 = (iHashCode2 + (presentedOfferingContext == null ? 0 : presentedOfferingContext.hashCode())) * 31;
        Double d3 = this.price;
        int iHashCode4 = (iHashCode3 + (d3 == null ? 0 : d3.hashCode())) * 31;
        String str = this.formattedPrice;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.currency;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Period period = this.period;
        int iHashCode7 = (iHashCode6 + (period == null ? 0 : period.hashCode())) * 31;
        List<PricingPhase> list = this.pricingPhases;
        int iHashCode8 = (iHashCode7 + (list == null ? 0 : list.hashCode())) * 31;
        ReplacementMode replacementMode = this.replacementMode;
        int iHashCode9 = (((((iHashCode8 + (replacementMode == null ? 0 : replacementMode.hashCode())) * 31) + this.platformProductIds.hashCode()) * 31) + Boolean.hashCode(this.sdkOriginated)) * 31;
        String str3 = this.storeUserID;
        int iHashCode10 = (iHashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.marketplace;
        return iHashCode10 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "ReceiptInfo(productIDs=" + this.productIDs + ", purchaseTime=" + this.purchaseTime + ", presentedOfferingContext=" + this.presentedOfferingContext + ", price=" + this.price + ", formattedPrice=" + this.formattedPrice + ", currency=" + this.currency + ", period=" + this.period + ", pricingPhases=" + this.pricingPhases + ", replacementMode=" + this.replacementMode + ", platformProductIds=" + this.platformProductIds + ", sdkOriginated=" + this.sdkOriginated + ", storeUserID=" + this.storeUserID + ", marketplace=" + this.marketplace + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ReceiptInfo(List<String> productIDs, Long l3, PresentedOfferingContext presentedOfferingContext, Double d3, String str, String str2, Period period, List<PricingPhase> list, ReplacementMode replacementMode, List<? extends Map<String, String>> platformProductIds, boolean z2, String str3, String str4) {
        String iso8601;
        Intrinsics.checkNotNullParameter(productIDs, "productIDs");
        Intrinsics.checkNotNullParameter(platformProductIds, "platformProductIds");
        this.productIDs = productIDs;
        this.purchaseTime = l3;
        this.presentedOfferingContext = presentedOfferingContext;
        this.price = d3;
        this.formattedPrice = str;
        this.currency = str2;
        this.period = period;
        this.pricingPhases = list;
        this.replacementMode = replacementMode;
        this.platformProductIds = platformProductIds;
        this.sdkOriginated = z2;
        this.storeUserID = str3;
        this.marketplace = str4;
        String str5 = null;
        if (period != null && (iso8601 = period.getIso8601()) != null && iso8601.length() != 0) {
            str5 = iso8601;
        }
        this.duration = str5;
    }

    public static /* synthetic */ void getDuration$annotations() {
    }

    @Serializable(with = PeriodSerializer.class)
    public static /* synthetic */ void getPeriod$annotations() {
    }

    @Serializable(with = PresentedOfferingContextSerializer.class)
    public static /* synthetic */ void getPresentedOfferingContext$annotations() {
    }

    @Serializable(with = ReplacementModeSerializer.class)
    public static /* synthetic */ void getReplacementMode$annotations() {
    }

    public /* synthetic */ ReceiptInfo(List list, Long l3, PresentedOfferingContext presentedOfferingContext, Double d3, String str, String str2, Period period, List list2, ReplacementMode replacementMode, List list3, boolean z2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i3 & 2) != 0 ? null : l3, (i3 & 4) != 0 ? null : presentedOfferingContext, (i3 & 8) != 0 ? null : d3, (i3 & 16) != 0 ? null : str, (i3 & 32) != 0 ? null : str2, (i3 & 64) != 0 ? null : period, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : list2, (i3 & Function.MAX_NARGS) != 0 ? null : replacementMode, (i3 & 512) != 0 ? CollectionsKt.emptyList() : list3, (i3 & 1024) != 0 ? false : z2, (i3 & 2048) != 0 ? null : str3, (i3 & 4096) != 0 ? null : str4);
    }
}
