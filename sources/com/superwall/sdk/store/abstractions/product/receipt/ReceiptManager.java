package com.superwall.sdk.store.abstractions.product.receipt;

import com.superwall.sdk.billing.Billing;
import com.superwall.sdk.customer.CustomerInfoManager;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.IOScope;
import com.superwall.sdk.models.customer.NonSubscriptionTransaction;
import com.superwall.sdk.models.customer.SubscriptionTransaction;
import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.storage.Storage;
import com.superwall.sdk.store.abstractions.product.StoreProduct;
import com.superwall.sdk.store.coordinator.ProductsFetcher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

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
public final class ReceiptManager {
    private Set<InAppPurchase> _purchases;
    private final Billing billing;
    private final Function0<CustomerInfoManager> customerInfoManager;
    private ProductsFetcher delegate;
    private final EntitlementProcessor entitlementProcessor;
    private final IOScope ioScope;
    private LatestPeriodType latestSubscriptionPeriodType;
    private final MutableStateFlow<LatestSubscriptionState> latestSubscriptionState;
    private Boolean latestSubscriptionWillAutoRenew;
    private final Storage storage;
    private final SubscriptionStatusProvider subscriptionStatusProvider;
    private List<TransactionReceipt> transactionReceipts;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PurchaseSnapshot {
        private final Map<String, List<Entitlement>> entitlementsByProductId;
        private final List<NonSubscriptionTransaction> nonSubscriptions;
        private final Set<InAppPurchase> purchases;
        private final List<SubscriptionTransaction> subscriptions;

        /* JADX WARN: Multi-variable type inference failed */
        public PurchaseSnapshot(Set<InAppPurchase> purchases, Map<String, ? extends List<Entitlement>> entitlementsByProductId, List<NonSubscriptionTransaction> nonSubscriptions, List<SubscriptionTransaction> subscriptions) {
            Intrinsics.checkNotNullParameter(purchases, "purchases");
            Intrinsics.checkNotNullParameter(entitlementsByProductId, "entitlementsByProductId");
            Intrinsics.checkNotNullParameter(nonSubscriptions, "nonSubscriptions");
            Intrinsics.checkNotNullParameter(subscriptions, "subscriptions");
            this.purchases = purchases;
            this.entitlementsByProductId = entitlementsByProductId;
            this.nonSubscriptions = nonSubscriptions;
            this.subscriptions = subscriptions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PurchaseSnapshot copy$default(PurchaseSnapshot purchaseSnapshot, Set set, Map map, List list, List list2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                set = purchaseSnapshot.purchases;
            }
            if ((i3 & 2) != 0) {
                map = purchaseSnapshot.entitlementsByProductId;
            }
            if ((i3 & 4) != 0) {
                list = purchaseSnapshot.nonSubscriptions;
            }
            if ((i3 & 8) != 0) {
                list2 = purchaseSnapshot.subscriptions;
            }
            return purchaseSnapshot.copy(set, map, list, list2);
        }

        public final Set<InAppPurchase> component1() {
            return this.purchases;
        }

        public final Map<String, List<Entitlement>> component2() {
            return this.entitlementsByProductId;
        }

        public final List<NonSubscriptionTransaction> component3() {
            return this.nonSubscriptions;
        }

        public final List<SubscriptionTransaction> component4() {
            return this.subscriptions;
        }

        public final PurchaseSnapshot copy(Set<InAppPurchase> purchases, Map<String, ? extends List<Entitlement>> entitlementsByProductId, List<NonSubscriptionTransaction> nonSubscriptions, List<SubscriptionTransaction> subscriptions) {
            Intrinsics.checkNotNullParameter(purchases, "purchases");
            Intrinsics.checkNotNullParameter(entitlementsByProductId, "entitlementsByProductId");
            Intrinsics.checkNotNullParameter(nonSubscriptions, "nonSubscriptions");
            Intrinsics.checkNotNullParameter(subscriptions, "subscriptions");
            return new PurchaseSnapshot(purchases, entitlementsByProductId, nonSubscriptions, subscriptions);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PurchaseSnapshot)) {
                return false;
            }
            PurchaseSnapshot purchaseSnapshot = (PurchaseSnapshot) obj;
            return Intrinsics.areEqual(this.purchases, purchaseSnapshot.purchases) && Intrinsics.areEqual(this.entitlementsByProductId, purchaseSnapshot.entitlementsByProductId) && Intrinsics.areEqual(this.nonSubscriptions, purchaseSnapshot.nonSubscriptions) && Intrinsics.areEqual(this.subscriptions, purchaseSnapshot.subscriptions);
        }

        public final Map<String, List<Entitlement>> getEntitlementsByProductId() {
            return this.entitlementsByProductId;
        }

        public final List<NonSubscriptionTransaction> getNonSubscriptions() {
            return this.nonSubscriptions;
        }

        public final Set<InAppPurchase> getPurchases() {
            return this.purchases;
        }

        public final List<SubscriptionTransaction> getSubscriptions() {
            return this.subscriptions;
        }

        public int hashCode() {
            return (((((this.purchases.hashCode() * 31) + this.entitlementsByProductId.hashCode()) * 31) + this.nonSubscriptions.hashCode()) * 31) + this.subscriptions.hashCode();
        }

        public String toString() {
            return "PurchaseSnapshot(purchases=" + this.purchases + ", entitlementsByProductId=" + this.entitlementsByProductId + ", nonSubscriptions=" + this.nonSubscriptions + ", subscriptions=" + this.subscriptions + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LatestPeriodType.values().length];
            try {
                iArr[LatestPeriodType.TRIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LatestPeriodType.CODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LatestPeriodType.SUBSCRIPTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LatestPeriodType.PROMOTIONAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LatestPeriodType.WINBACK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[LatestPeriodType.REVOKED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.abstractions.product.receipt.ReceiptManager$lastSubscriptionProperties$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.abstractions.product.receipt.ReceiptManager", f = "ReceiptManager.kt", l = {274, 278, 281}, m = "lastSubscriptionProperties")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReceiptManager.this.lastSubscriptionProperties(this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.abstractions.product.receipt.ReceiptManager$loadPurchases$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.abstractions.product.receipt.ReceiptManager", f = "ReceiptManager.kt", l = {103, 122, 200}, m = "loadPurchases")
    static final class C29261 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C29261(Continuation<? super C29261> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReceiptManager.this.loadPurchases(null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.abstractions.product.receipt.ReceiptManager$refreshReceipt$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.abstractions.product.receipt.ReceiptManager$refreshReceipt$1", f = "ReceiptManager.kt", l = {264}, m = "invokeSuspend")
    static final class C29271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C29271(Continuation<? super C29271> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReceiptManager.this.new C29271(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            MutableStateFlow mutableStateFlow;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                MutableStateFlow mutableStateFlow2 = ReceiptManager.this.latestSubscriptionState;
                ReceiptManager receiptManager = ReceiptManager.this;
                this.L$0 = mutableStateFlow2;
                this.label = 1;
                Object objLastSubscriptionProperties = receiptManager.lastSubscriptionProperties(this);
                if (objLastSubscriptionProperties == objF) {
                    return objF;
                }
                mutableStateFlow = mutableStateFlow2;
                obj = objLastSubscriptionProperties;
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableStateFlow = (MutableStateFlow) this.L$0;
                ResultKt.b(obj);
            }
            mutableStateFlow.setValue(obj);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29271) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.store.abstractions.product.receipt.ReceiptManager$updateExperimentalDeviceVariables$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.store.abstractions.product.receipt.ReceiptManager", f = "ReceiptManager.kt", l = {253}, m = "updateExperimentalDeviceVariables")
    static final class C29281 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C29281(Continuation<? super C29281> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReceiptManager.this.updateExperimentalDeviceVariables(null, null, this);
        }
    }

    public ReceiptManager(ProductsFetcher productsFetcher, Billing billing, IOScope ioScope, Storage storage, Function0<CustomerInfoManager> customerInfoManager, EntitlementProcessor entitlementProcessor, SubscriptionStatusProvider subscriptionStatusProvider) {
        Intrinsics.checkNotNullParameter(billing, "billing");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(customerInfoManager, "customerInfoManager");
        Intrinsics.checkNotNullParameter(entitlementProcessor, "entitlementProcessor");
        Intrinsics.checkNotNullParameter(subscriptionStatusProvider, "subscriptionStatusProvider");
        this.delegate = productsFetcher;
        this.billing = billing;
        this.ioScope = ioScope;
        this.storage = storage;
        this.customerInfoManager = customerInfoManager;
        this.entitlementProcessor = entitlementProcessor;
        this.subscriptionStatusProvider = subscriptionStatusProvider;
        this.transactionReceipts = new ArrayList();
        this._purchases = new LinkedHashSet();
        this.latestSubscriptionState = StateFlowKt.a(LatestSubscriptionState.UNKNOWN);
        refreshReceipt();
    }

    private final String determinePeriodType() {
        LatestPeriodType latestPeriodType = this.latestSubscriptionPeriodType;
        switch (latestPeriodType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[latestPeriodType.ordinal()]) {
            case -1:
                return null;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                return "trial";
            case 2:
                return "code";
            case 3:
                return "normal";
            case 4:
                return "intro";
            case 5:
                return "winback";
            case 6:
                return "revoked";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object updateExperimentalDeviceVariables(java.util.List<? extends com.android.billingclient.api.Purchase> r10, java.util.Map<java.lang.String, com.superwall.sdk.store.abstractions.product.StoreProduct> r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.abstractions.product.receipt.ReceiptManager.updateExperimentalDeviceVariables(java.util.List, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Map<String, Object> experimentalProperties() {
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        String strDeterminePeriodType = determinePeriodType();
        if (strDeterminePeriodType != null) {
            mapCreateMapBuilder.put("latestSubscriptionPeriodType", strDeterminePeriodType);
        }
        Boolean bool = this.latestSubscriptionWillAutoRenew;
        if (bool != null) {
            mapCreateMapBuilder.put("latestSubscriptionWillAutoRenew", bool);
        }
        mapCreateMapBuilder.put("latestSubscriptionState", ((LatestSubscriptionState) this.latestSubscriptionState.getValue()).name());
        return MapsKt.build(mapCreateMapBuilder);
    }

    public final Function0<CustomerInfoManager> getCustomerInfoManager$superwall_release() {
        return this.customerInfoManager;
    }

    public final LatestPeriodType getLatestSubscriptionPeriodType() {
        return this.latestSubscriptionPeriodType;
    }

    public final Boolean getLatestSubscriptionWillAutoRenew() {
        return this.latestSubscriptionWillAutoRenew;
    }

    public final Set<String> getPurchases() {
        Set<InAppPurchase> set = this._purchases;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(((InAppPurchase) it.next()).getProductIdentifier());
        }
        return CollectionsKt.toSet(arrayList);
    }

    public final List<TransactionReceipt> getTransactionReceipts() {
        return this.transactionReceipts;
    }

    public final boolean hasPurchasedProduct(String productId) {
        Object next;
        Intrinsics.checkNotNullParameter(productId, "productId");
        Iterator<T> it = this._purchases.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((InAppPurchase) next).getProductIdentifier(), productId)) {
                break;
            }
        }
        return next != null;
    }

    public final Object isEligibleForIntroOffer(StoreProduct storeProduct, Continuation<? super Boolean> continuation) {
        Set<InAppPurchase> set = this._purchases;
        boolean z2 = false;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator<T> it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (Intrinsics.areEqual(((InAppPurchase) it.next()).getProductIdentifier(), storeProduct.getProductIdentifier())) {
                    z2 = true;
                    break;
                }
            }
        }
        return Boxing.a(!z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object lastSubscriptionProperties(kotlin.coroutines.Continuation<? super com.superwall.sdk.store.abstractions.product.receipt.LatestSubscriptionState> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.abstractions.product.receipt.ReceiptManager.lastSubscriptionProperties(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object loadPurchasedProducts(Map<String, ? extends Set<Entitlement>> map, Continuation<? super Unit> continuation) {
        Object objLoadPurchases = loadPurchases(map, continuation);
        return objLoadPurchases == IntrinsicsKt.f() ? objLoadPurchases : Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0289 A[LOOP:1: B:72:0x0283->B:74:0x0289, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadPurchases(java.util.Map<java.lang.String, ? extends java.util.Set<com.superwall.sdk.models.entitlements.Entitlement>> r29, kotlin.coroutines.Continuation<? super com.superwall.sdk.store.abstractions.product.receipt.ReceiptManager.PurchaseSnapshot> r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.store.abstractions.product.receipt.ReceiptManager.loadPurchases(java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void refreshReceipt() {
        Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.receipts, "Refreshing receipts", (Map) null, (Throwable) null, 24, (Object) null);
        BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new C29271(null), 3, null);
    }

    public final void setLatestSubscriptionPeriodType(LatestPeriodType latestPeriodType) {
        this.latestSubscriptionPeriodType = latestPeriodType;
    }

    public final void setLatestSubscriptionWillAutoRenew(Boolean bool) {
        this.latestSubscriptionWillAutoRenew = bool;
    }

    public final void setTransactionReceipts(List<TransactionReceipt> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.transactionReceipts = list;
    }

    public /* synthetic */ ReceiptManager(ProductsFetcher productsFetcher, Billing billing, IOScope iOScope, Storage storage, Function0 function0, EntitlementProcessor entitlementProcessor, SubscriptionStatusProvider subscriptionStatusProvider, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(productsFetcher, billing, (i3 & 4) != 0 ? new IOScope(null, 1, null) : iOScope, storage, function0, (i3 & 32) != 0 ? new EntitlementProcessor() : entitlementProcessor, (i3 & 64) != 0 ? new PlayBillingSubscriptionStatusProvider(billing) : subscriptionStatusProvider);
    }
}
