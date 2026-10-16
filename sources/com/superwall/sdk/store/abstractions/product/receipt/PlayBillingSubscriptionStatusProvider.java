package com.superwall.sdk.store.abstractions.product.receipt;

import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.Purchase;
import com.superwall.sdk.billing.Billing;
import com.superwall.sdk.store.abstractions.product.RawStoreProduct;
import com.superwall.sdk.store.abstractions.product.StoreProduct;
import com.superwall.sdk.store.abstractions.product.SubscriptionPeriod;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

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
public final class PlayBillingSubscriptionStatusProvider implements SubscriptionStatusProvider {
    private final Billing billing;

    public PlayBillingSubscriptionStatusProvider(Billing billing) {
        Intrinsics.checkNotNullParameter(billing, "billing");
        this.billing = billing;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.ArrayList] */
    @Override // com.superwall.sdk.store.abstractions.product.receipt.SubscriptionStatusProvider
    public LatestPeriodType getOfferType(Purchase purchase, StoreProduct storeProduct) {
        ?? EmptyList;
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        if (storeProduct == null) {
            return null;
        }
        RawStoreProduct rawStoreProduct = storeProduct.getRawStoreProduct();
        RawStoreProduct.SelectedOfferDetails selectedOffer = rawStoreProduct != null ? rawStoreProduct.getSelectedOffer() : null;
        if (selectedOffer instanceof RawStoreProduct.SelectedOfferDetails.Subscription) {
            List listA = ((RawStoreProduct.SelectedOfferDetails.Subscription) selectedOffer).getUnderlying().f().a();
            Intrinsics.checkNotNullExpressionValue(listA, "getPricingPhaseList(...)");
            EmptyList = new ArrayList();
            boolean z2 = false;
            for (Object obj : listA) {
                if (z2) {
                    EmptyList.add(obj);
                } else if (((ProductDetails.PricingPhase) obj).d() != 0) {
                    EmptyList.add(obj);
                    z2 = true;
                }
            }
        } else {
            if (!(selectedOffer instanceof RawStoreProduct.SelectedOfferDetails.OneTime) && selectedOffer != null) {
                throw new NoWhenBranchMatchedException();
            }
            EmptyList = CollectionsKt.emptyList();
        }
        Date trialPeriodEndDate = storeProduct.getTrialPeriodEndDate();
        if ((trialPeriodEndDate != null ? trialPeriodEndDate.getTime() : 0L) > System.currentTimeMillis()) {
            return LatestPeriodType.TRIAL;
        }
        if (EmptyList.size() > 1) {
            ProductDetails.PricingPhase pricingPhase = (ProductDetails.PricingPhase) CollectionsKt.firstOrNull((List) EmptyList);
            long jD = pricingPhase != null ? pricingPhase.d() : 0L;
            ProductDetails.PricingPhase pricingPhase2 = (ProductDetails.PricingPhase) CollectionsKt.lastOrNull((List) EmptyList);
            if (jD < (pricingPhase2 != null ? pricingPhase2.d() : 0L)) {
                return LatestPeriodType.PROMOTIONAL;
            }
        }
        return purchase.d() == 0 ? LatestPeriodType.REVOKED : LatestPeriodType.SUBSCRIPTION;
    }

    @Override // com.superwall.sdk.store.abstractions.product.receipt.SubscriptionStatusProvider
    public Object getSubscriptionState(Purchase purchase, StoreProduct storeProduct, Continuation<? super LatestSubscriptionState> continuation) {
        RawStoreProduct rawStoreProduct;
        SubscriptionPeriod subscriptionPeriod;
        long jCurrentTimeMillis = System.currentTimeMillis() - purchase.e();
        long toMillis = (storeProduct == null || (rawStoreProduct = storeProduct.getRawStoreProduct()) == null || (subscriptionPeriod = rawStoreProduct.getSubscriptionPeriod()) == null) ? 0L : subscriptionPeriod.getToMillis();
        return purchase.d() == 0 ? LatestSubscriptionState.REVOKED : (purchase.d() == 2 && purchase.i()) ? LatestSubscriptionState.GRACE_PERIOD : (purchase.d() != 1 || toMillis <= 0 || jCurrentTimeMillis <= toMillis) ? (purchase.d() == 1 && purchase.i() && (toMillis == 0 || jCurrentTimeMillis < toMillis)) ? LatestSubscriptionState.SUBSCRIBED : purchase.d() == 1 ? LatestSubscriptionState.EXPIRED : LatestSubscriptionState.UNKNOWN : LatestSubscriptionState.EXPIRED;
    }

    @Override // com.superwall.sdk.store.abstractions.product.receipt.SubscriptionStatusProvider
    public boolean getWillAutoRenew(Purchase purchase) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        return purchase.i();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
    @Override // com.superwall.sdk.store.abstractions.product.receipt.SubscriptionStatusProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object isActive(com.android.billingclient.api.Purchase r8, com.superwall.sdk.store.abstractions.product.StoreProduct r9, kotlin.coroutines.Continuation<? super java.lang.Boolean> r10) {
        /*
            r7 = this;
            long r0 = java.lang.System.currentTimeMillis()
            int r10 = r8.d()
            r2 = 0
            if (r10 == 0) goto L67
            r3 = 1
            if (r10 == r3) goto Lf
            goto L67
        Lf:
            if (r9 != 0) goto L16
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.a(r2)
            return r8
        L16:
            com.superwall.sdk.store.abstractions.product.RawStoreProduct r10 = r9.getRawStoreProduct()
            r4 = 0
            if (r10 == 0) goto L28
            com.android.billingclient.api.ProductDetails r10 = r10.getUnderlyingProductDetails()
            if (r10 == 0) goto L28
            java.lang.String r10 = r10.f()
            goto L29
        L28:
            r10 = r4
        L29:
            if (r10 == 0) goto L67
            int r5 = r10.hashCode()
            r6 = 3541555(0x360a33, float:4.962776E-39)
            if (r5 == r6) goto L44
            r8 = 100343516(0x5fb1edc, float:2.3615263E-35)
            if (r5 == r8) goto L3a
            goto L67
        L3a:
            java.lang.String r8 = "inapp"
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto L67
        L42:
            r2 = r3
            goto L67
        L44:
            java.lang.String r5 = "subs"
            boolean r10 = r10.equals(r5)
            if (r10 != 0) goto L4d
            goto L67
        L4d:
            com.superwall.sdk.store.abstractions.product.RawStoreProduct r9 = r9.getRawStoreProduct()
            if (r9 == 0) goto L57
            com.superwall.sdk.store.abstractions.product.SubscriptionPeriod r4 = r9.getSubscriptionPeriod()
        L57:
            if (r4 == 0) goto L42
            long r9 = r4.getToMillis()
            long r4 = r8.e()
            long r4 = r4 + r9
            int r8 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r8 <= 0) goto L67
            goto L42
        L67:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.a(r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.abstractions.product.receipt.PlayBillingSubscriptionStatusProvider.isActive(com.android.billingclient.api.Purchase, com.superwall.sdk.store.abstractions.product.StoreProduct, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
