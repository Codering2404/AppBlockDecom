package com.revenuecat.purchases.ui.revenuecatui.data;

import com.revenuecat.purchases.CacheFetchPolicy;
import com.revenuecat.purchases.CreateSupportTicketResult;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.PurchaseParams;
import com.revenuecat.purchases.PurchaseResult;
import com.revenuecat.purchases.PurchasesAreCompletedBy;
import com.revenuecat.purchases.common.events.FeatureEvent;
import com.revenuecat.purchases.common.workflows.WorkflowDataResult;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.customercenter.CustomerCenterListener;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.coroutines.Continuation;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class MockPurchasesType implements PurchasesType {
    public static final int $stable = 8;
    private final CustomerCenterListener customerCenterListener;
    private final String preferredUILocaleOverride;
    private final PurchasesAreCompletedBy purchasesAreCompletedBy;
    private final String storefrontCountryCode;

    public MockPurchasesType() {
        this(null, null, null, null, 15, null);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitCreateSupportTicket(String str, String str2, Continuation<? super CreateSupportTicketResult> continuation) {
        return new CreateSupportTicketResult(true);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitCustomerCenterConfigData(Continuation<? super CustomerCenterConfigData> continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitCustomerInfo(CacheFetchPolicy cacheFetchPolicy, Continuation<? super CustomerInfo> continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitGetProduct(String str, String str2, Continuation<? super StoreProduct> continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitGetVirtualCurrencies(Continuation<? super VirtualCurrencies> continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitGetWorkflow(String str, Continuation<? super WorkflowDataResult> continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitOfferings(Continuation<? super Offerings> continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitPurchase(PurchaseParams.Builder builder, Continuation<? super PurchaseResult> continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitRestore(Continuation<? super CustomerInfo> continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public Object awaitSyncPurchases(Continuation<? super CustomerInfo> continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public CustomerCenterListener getCustomerCenterListener() {
        return this.customerCenterListener;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public String getPreferredUILocaleOverride() {
        return this.preferredUILocaleOverride;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public PurchasesAreCompletedBy getPurchasesAreCompletedBy() {
        return this.purchasesAreCompletedBy;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public String getStorefrontCountryCode() {
        return this.storefrontCountryCode;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public void track(FeatureEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    public MockPurchasesType(String str, PurchasesAreCompletedBy purchasesAreCompletedBy, String str2, CustomerCenterListener customerCenterListener) {
        Intrinsics.checkNotNullParameter(purchasesAreCompletedBy, "purchasesAreCompletedBy");
        this.preferredUILocaleOverride = str;
        this.purchasesAreCompletedBy = purchasesAreCompletedBy;
        this.storefrontCountryCode = str2;
        this.customerCenterListener = customerCenterListener;
    }

    public /* synthetic */ MockPurchasesType(String str, PurchasesAreCompletedBy purchasesAreCompletedBy, String str2, CustomerCenterListener customerCenterListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? PurchasesAreCompletedBy.REVENUECAT : purchasesAreCompletedBy, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : customerCenterListener);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType
    public void invalidateVirtualCurrenciesCache() {
    }
}
