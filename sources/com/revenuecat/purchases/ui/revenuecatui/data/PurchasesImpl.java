package com.revenuecat.purchases.ui.revenuecatui.data;

import com.revenuecat.purchases.CacheFetchPolicy;
import com.revenuecat.purchases.CoroutinesExtensionsCommonKt;
import com.revenuecat.purchases.CoroutinesExtensionsKt;
import com.revenuecat.purchases.CreateSupportTicketResult;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.PurchaseParams;
import com.revenuecat.purchases.PurchaseResult;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesAreCompletedBy;
import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.common.events.FeatureEvent;
import com.revenuecat.purchases.common.workflows.WorkflowDataResult;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.customercenter.CustomerCenterListener;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class PurchasesImpl implements PurchasesType {
    public static final int $stable = 8;
    private final Purchases purchases;

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PurchasesImpl$awaitGetProduct$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.data.PurchasesImpl", f = "PurchasesType.kt", l = {95}, m = "awaitGetProduct")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PurchasesImpl.this.awaitGetProduct(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PurchasesImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitCreateSupportTicket(String str, String str2, Continuation<? super CreateSupportTicketResult> continuation) throws PurchasesException {
        return CoroutinesExtensionsKt.awaitCreateSupportTicket(this.purchases, str, str2, continuation);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitCustomerCenterConfigData(Continuation<? super CustomerCenterConfigData> continuation) {
        return CoroutinesExtensionsKt.awaitCustomerCenterConfigData(this.purchases, continuation);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitCustomerInfo(CacheFetchPolicy cacheFetchPolicy, Continuation<? super CustomerInfo> continuation) {
        return CoroutinesExtensionsKt.awaitCustomerInfo(this.purchases, cacheFetchPolicy, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object awaitGetProduct(java.lang.String r8, java.lang.String r9, kotlin.coroutines.Continuation<? super com.revenuecat.purchases.models.StoreProduct> r10) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.revenuecat.purchases.ui.revenuecatui.data.PurchasesImpl.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r10
            com.revenuecat.purchases.ui.revenuecatui.data.PurchasesImpl$awaitGetProduct$1 r0 = (com.revenuecat.purchases.ui.revenuecatui.data.PurchasesImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            com.revenuecat.purchases.ui.revenuecatui.data.PurchasesImpl$awaitGetProduct$1 r0 = new com.revenuecat.purchases.ui.revenuecatui.data.PurchasesImpl$awaitGetProduct$1
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r10 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L38
            if (r1 != r2) goto L30
            java.lang.Object r8 = r4.L$0
            r9 = r8
            java.lang.String r9 = (java.lang.String) r9
            kotlin.ResultKt.b(r10)
            goto L50
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L38:
            kotlin.ResultKt.b(r10)
            com.revenuecat.purchases.Purchases r1 = r7.purchases
            java.util.List r8 = kotlin.collections.CollectionsKt.listOf(r8)
            r4.L$0 = r9
            r4.label = r2
            r3 = 0
            r5 = 2
            r6 = 0
            r2 = r8
            java.lang.Object r10 = com.revenuecat.purchases.CoroutinesExtensionsCommonKt.awaitGetProducts$default(r1, r2, r3, r4, r5, r6)
            if (r10 != r0) goto L50
            return r0
        L50:
            java.util.List r10 = (java.util.List) r10
            if (r9 != 0) goto L5b
            java.lang.Object r8 = kotlin.collections.CollectionsKt.firstOrNull(r10)
            com.revenuecat.purchases.models.StoreProduct r8 = (com.revenuecat.purchases.models.StoreProduct) r8
            return r8
        L5b:
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r8 = r10.iterator()
        L61:
            boolean r10 = r8.hasNext()
            r0 = 0
            if (r10 == 0) goto L80
            java.lang.Object r10 = r8.next()
            r1 = r10
            com.revenuecat.purchases.models.StoreProduct r1 = (com.revenuecat.purchases.models.StoreProduct) r1
            com.revenuecat.purchases.models.GoogleStoreProduct r1 = com.revenuecat.purchases.models.GoogleStoreProductKt.getGoogleProduct(r1)
            if (r1 == 0) goto L79
            java.lang.String r0 = r1.getBasePlanId()
        L79:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r9)
            if (r0 == 0) goto L61
            r0 = r10
        L80:
            com.revenuecat.purchases.models.StoreProduct r0 = (com.revenuecat.purchases.models.StoreProduct) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.data.PurchasesImpl.awaitGetProduct(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitGetVirtualCurrencies(Continuation<? super VirtualCurrencies> continuation) throws PurchasesException {
        return CoroutinesExtensionsKt.awaitGetVirtualCurrencies(this.purchases, continuation);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitGetWorkflow(String str, Continuation<? super WorkflowDataResult> continuation) throws PurchasesException {
        return this.purchases.awaitGetWorkflow(str, continuation);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitOfferings(Continuation<? super Offerings> continuation) {
        return CoroutinesExtensionsCommonKt.awaitOfferings(this.purchases, continuation);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitPurchase(PurchaseParams.Builder builder, Continuation<? super PurchaseResult> continuation) {
        return CoroutinesExtensionsCommonKt.awaitPurchase(this.purchases, builder.build(), continuation);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitRestore(Continuation<? super CustomerInfo> continuation) {
        return CoroutinesExtensionsCommonKt.awaitRestore(this.purchases, continuation);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitSyncPurchases(Continuation<? super CustomerInfo> continuation) {
        return CoroutinesExtensionsKt.awaitSyncPurchases(this.purchases, continuation);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public CustomerCenterListener getCustomerCenterListener() {
        return this.purchases.getCustomerCenterListener();
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public String getPreferredUILocaleOverride() {
        return this.purchases.getPreferredUILocaleOverride();
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public PurchasesAreCompletedBy getPurchasesAreCompletedBy() {
        return this.purchases.getPurchasesAreCompletedBy();
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public String getStorefrontCountryCode() {
        return this.purchases.getStorefrontCountryCode();
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public void invalidateVirtualCurrenciesCache() {
        this.purchases.invalidateVirtualCurrenciesCache();
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public void track(FeatureEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.purchases.track(event);
    }

    public PurchasesImpl(Purchases purchases) {
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        this.purchases = purchases;
    }

    public /* synthetic */ PurchasesImpl(Purchases purchases, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Purchases.Companion.getSharedInstance() : purchases);
    }
}
