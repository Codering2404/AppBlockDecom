package com.revenuecat.purchases.ui.revenuecatui.utils;

import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.models.InstallmentsInfo;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.RecurrenceMode;
import com.revenuecat.purchases.models.RecurrenceModeKt;
import com.revenuecat.purchases.models.SubscriptionOption;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final /* synthetic */ class PreviewDataCreatorsKt {
    public static final /* synthetic */ PricingPhase previewPricingPhase(Period billingPeriod, String priceCurrencyCodeValue, double d3, int i3, Integer num) {
        String string;
        Intrinsics.checkNotNullParameter(billingPeriod, "billingPeriod");
        Intrinsics.checkNotNullParameter(priceCurrencyCodeValue, "priceCurrencyCodeValue");
        RecurrenceMode recurrenceMode = RecurrenceModeKt.toRecurrenceMode(Integer.valueOf(i3));
        if (d3 == 0.0d) {
            string = "Free";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('$');
            sb.append(d3);
            string = sb.toString();
        }
        return new PricingPhase(billingPeriod, recurrenceMode, num, new Price(string, (long) (d3 * ((double) 1000000)), priceCurrencyCodeValue));
    }

    public static /* synthetic */ PricingPhase previewPricingPhase$default(Period period, String str, double d3, int i3, Integer num, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            period = new Period(1, Period.Unit.MONTH, "P1M");
        }
        if ((i4 & 2) != 0) {
            str = "USD";
        }
        if ((i4 & 4) != 0) {
            d3 = 4.99d;
        }
        if ((i4 & 8) != 0) {
            i3 = 1;
        }
        if ((i4 & 16) != 0) {
            num = null;
        }
        double d4 = d3;
        return previewPricingPhase(period, str, d4, i3, num);
    }

    public static final /* synthetic */ SubscriptionOption previewSubscriptionOption(final String id, final String productId, Period duration, final List pricingPhases, final PresentedOfferingContext presentedOfferingContext, final InstallmentsInfo installmentsInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(duration, "duration");
        Intrinsics.checkNotNullParameter(pricingPhases, "pricingPhases");
        return new SubscriptionOption() { // from class: com.revenuecat.purchases.ui.revenuecatui.utils.PreviewDataCreatorsKt.previewSubscriptionOption.1
            @Override // com.revenuecat.purchases.models.SubscriptionOption
            public String getId() {
                return id;
            }

            @Override // com.revenuecat.purchases.models.SubscriptionOption
            public InstallmentsInfo getInstallmentsInfo() {
                return installmentsInfo;
            }

            @Override // com.revenuecat.purchases.models.SubscriptionOption
            public PresentedOfferingContext getPresentedOfferingContext() {
                return presentedOfferingContext;
            }

            @Override // com.revenuecat.purchases.models.SubscriptionOption
            public String getPresentedOfferingIdentifier() {
                PresentedOfferingContext presentedOfferingContext2 = presentedOfferingContext;
                if (presentedOfferingContext2 != null) {
                    return presentedOfferingContext2.getOfferingIdentifier();
                }
                return null;
            }

            @Override // com.revenuecat.purchases.models.SubscriptionOption
            public List<PricingPhase> getPricingPhases() {
                return pricingPhases;
            }

            @Override // com.revenuecat.purchases.models.SubscriptionOption
            public PurchasingData getPurchasingData() {
                return new PreviewPurchasingData(productId);
            }

            @Override // com.revenuecat.purchases.models.SubscriptionOption
            public List<String> getTags() {
                return CollectionsKt.listOf("tag");
            }
        };
    }

    public static /* synthetic */ SubscriptionOption previewSubscriptionOption$default(String str, String str2, Period period, List list, PresentedOfferingContext presentedOfferingContext, InstallmentsInfo installmentsInfo, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            period = new Period(1, Period.Unit.MONTH, "P1M");
        }
        Period period2 = period;
        if ((i3 & 8) != 0) {
            list = CollectionsKt.listOf(previewPricingPhase$default(period2, null, 0.0d, 0, null, 30, null));
        }
        return previewSubscriptionOption(str, str2, period2, list, (i3 & 16) != 0 ? null : presentedOfferingContext, (i3 & 32) != 0 ? null : installmentsInfo);
    }
}
