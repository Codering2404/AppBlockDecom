package com.revenuecat.purchases.ui.revenuecatui.data;

import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.models.GoogleStoreProduct;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.StoreProduct;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
public final class ProductChangeCalculator {
    private static final int MONTHS_IN_HALF_YEAR = 6;
    private static final int MONTHS_IN_QUARTER = 3;
    private static final int MONTHS_IN_YEAR = 12;
    private static final long SANDBOX_HALF_YEAR_MINUTES = 15;
    private static final long SANDBOX_MONTHLY_MINUTES = 5;
    private static final long SANDBOX_QUARTER_MINUTES = 10;
    private static final long SANDBOX_YEARLY_MINUTES = 30;
    private final PurchasesType purchases;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Long getNormalizedPrice$revenuecatui_defaultsBc8Release(StoreProduct storeProduct, boolean z2) {
            Intrinsics.checkNotNullParameter(storeProduct, "<this>");
            Period period = storeProduct.getPeriod();
            if (period == null) {
                return null;
            }
            long amountMicros = storeProduct.getPrice().getAmountMicros();
            if (z2) {
                return Long.valueOf(amountMicros / getSandboxRenewalMinutes$revenuecatui_defaultsBc8Release(period));
            }
            Price pricePricePerMonth$default = StoreProduct.pricePerMonth$default(storeProduct, null, 1, null);
            if (pricePricePerMonth$default != null) {
                return Long.valueOf(pricePricePerMonth$default.getAmountMicros());
            }
            return null;
        }

        public final long getSandboxRenewalMinutes$revenuecatui_defaultsBc8Release(Period period) {
            Intrinsics.checkNotNullParameter(period, "period");
            double valueInMonths = period.getValueInMonths();
            if (valueInMonths >= 12.0d) {
                return ProductChangeCalculator.SANDBOX_YEARLY_MINUTES;
            }
            if (valueInMonths >= 6.0d) {
                return ProductChangeCalculator.SANDBOX_HALF_YEAR_MINUTES;
            }
            if (valueInMonths >= 3.0d) {
                return 10L;
            }
            return ProductChangeCalculator.SANDBOX_MONTHLY_MINUTES;
        }

        public final Pair<String, String> parseProductIdentifier$revenuecatui_defaultsBc8Release(String productIdentifier) {
            Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
            String strN1 = StringsKt.n1(productIdentifier, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, null, 2, null);
            String strD1 = StringsKt.d1(productIdentifier, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, "");
            return TuplesKt.a(strN1, strD1.length() > 0 ? strD1 : null);
        }

        public final Pair<String, String> subscriptionIdentifiers$revenuecatui_defaultsBc8Release(StoreProduct storeProduct) {
            Intrinsics.checkNotNullParameter(storeProduct, "<this>");
            if (!(storeProduct instanceof GoogleStoreProduct)) {
                return parseProductIdentifier$revenuecatui_defaultsBc8Release(storeProduct.getId());
            }
            GoogleStoreProduct googleStoreProduct = (GoogleStoreProduct) storeProduct;
            return TuplesKt.a(googleStoreProduct.getProductId(), googleStoreProduct.getBasePlanId());
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.ProductChangeCalculator$calculateProductChange$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.data.ProductChangeCalculator", f = "ProductChangeCalculator.kt", l = {72}, m = "calculateProductChange")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProductChangeCalculator.this.calculateProductChange(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.ProductChangeCalculator$calculateProductChangeInfo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.data.ProductChangeCalculator", f = "ProductChangeCalculator.kt", l = {40, 45}, m = "calculateProductChangeInfo")
    static final class C26661 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C26661(Continuation<? super C26661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProductChangeCalculator.this.calculateProductChangeInfo(null, null, this);
        }
    }

    public ProductChangeCalculator(PurchasesType purchases) {
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        this.purchases = purchases;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object calculateProductChange(com.revenuecat.purchases.SubscriptionInfo r12, com.revenuecat.purchases.Package r13, com.revenuecat.purchases.paywalls.components.common.ProductChangeConfig r14, kotlin.coroutines.Continuation<? super com.revenuecat.purchases.ui.revenuecatui.data.ProductChangeInfo> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.data.ProductChangeCalculator.calculateProductChange(com.revenuecat.purchases.SubscriptionInfo, com.revenuecat.purchases.Package, com.revenuecat.purchases.paywalls.components.common.ProductChangeConfig, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a9, code lost:
    
        if (r11 == r1) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object calculateProductChangeInfo(com.revenuecat.purchases.Package r9, com.revenuecat.purchases.paywalls.components.common.ProductChangeConfig r10, kotlin.coroutines.Continuation<? super com.revenuecat.purchases.ui.revenuecatui.data.ProductChangeInfo> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.data.ProductChangeCalculator.calculateProductChangeInfo(com.revenuecat.purchases.Package, com.revenuecat.purchases.paywalls.components.common.ProductChangeConfig, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
