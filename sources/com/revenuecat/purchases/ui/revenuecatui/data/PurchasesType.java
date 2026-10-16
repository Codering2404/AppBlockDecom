package com.revenuecat.purchases.ui.revenuecatui.data;

import com.revenuecat.purchases.CacheFetchPolicy;
import com.revenuecat.purchases.CreateSupportTicketResult;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.PurchaseParams;
import com.revenuecat.purchases.PurchaseResult;
import com.revenuecat.purchases.PurchasesAreCompletedBy;
import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.common.events.FeatureEvent;
import com.revenuecat.purchases.common.workflows.WorkflowDataResult;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.customercenter.CustomerCenterListener;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

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
public interface PurchasesType {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        public static /* synthetic */ Object awaitCustomerInfo$default(PurchasesType purchasesType, CacheFetchPolicy cacheFetchPolicy, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitCustomerInfo");
            }
            if ((i3 & 1) != 0) {
                cacheFetchPolicy = CacheFetchPolicy.Companion.m413default();
            }
            return purchasesType.awaitCustomerInfo(cacheFetchPolicy, continuation);
        }
    }

    Object awaitCreateSupportTicket(String str, String str2, Continuation<? super CreateSupportTicketResult> continuation) throws PurchasesException;

    Object awaitCustomerCenterConfigData(Continuation<? super CustomerCenterConfigData> continuation);

    Object awaitCustomerInfo(CacheFetchPolicy cacheFetchPolicy, Continuation<? super CustomerInfo> continuation);

    Object awaitGetProduct(String str, String str2, Continuation<? super StoreProduct> continuation);

    Object awaitGetVirtualCurrencies(Continuation<? super VirtualCurrencies> continuation) throws PurchasesException;

    Object awaitGetWorkflow(String str, Continuation<? super WorkflowDataResult> continuation) throws PurchasesException;

    Object awaitOfferings(Continuation<? super Offerings> continuation);

    Object awaitPurchase(PurchaseParams.Builder builder, Continuation<? super PurchaseResult> continuation);

    Object awaitRestore(Continuation<? super CustomerInfo> continuation);

    Object awaitSyncPurchases(Continuation<? super CustomerInfo> continuation);

    CustomerCenterListener getCustomerCenterListener();

    String getPreferredUILocaleOverride();

    PurchasesAreCompletedBy getPurchasesAreCompletedBy();

    String getStorefrontCountryCode();

    void invalidateVirtualCurrenciesCache();

    void track(FeatureEvent featureEvent);
}
