package com.superwall.sdk.billing.observer;

import android.app.Activity;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.facebook.GraphRequest;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.billing.observer.SuperwallBillingFlowParams;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.store.PurchasingObserverState;
import com.superwall.sdk.store.abstractions.product.RawStoreProduct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
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
public final class LaunchBillingFlowWithSuperwallKt {
    public static final BillingResult launchBillingFlowWithSuperwall(BillingClient billingClient, Activity activity, SuperwallBillingFlowParams params) {
        Intrinsics.checkNotNullParameter(billingClient, "<this>");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(params, "params");
        Superwall.Companion companion = Superwall.Companion;
        if (!companion.getInitialized()) {
            throw new IllegalStateException("Superwall SDK is not initialized");
        }
        if (companion.getInstance().getOptions().getShouldObservePurchases()) {
            Iterator<T> it = params.getProductDetailsParams$superwall_release().iterator();
            while (it.hasNext()) {
                Superwall.Companion.getInstance().observe(new PurchasingObserverState.PurchaseWillBegin(RawStoreProduct.Companion.from(((SuperwallBillingFlowParams.ProductDetailsParams) it.next()).getDetails$superwall_release()).getUnderlyingProductDetails()));
            }
            BillingResult billingResultG = billingClient.g(activity, params.toOriginal());
            Intrinsics.checkNotNullExpressionValue(billingResultG, "launchBillingFlow(...)");
            return billingResultG;
        }
        Logger logger = Logger.INSTANCE;
        LogLevel logLevel = LogLevel.error;
        LogScope logScope = LogScope.superwallCore;
        Pair pairA = TuplesKt.a(GraphRequest.BATCH_METHOD_PARAM, "launchBillingFlowWithSuperwall");
        List<SuperwallBillingFlowParams.ProductDetailsParams> productDetailsParams$superwall_release = params.getProductDetailsParams$superwall_release();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(productDetailsParams$superwall_release, 10));
        Iterator<T> it2 = productDetailsParams$superwall_release.iterator();
        while (it2.hasNext()) {
            arrayList.add(((SuperwallBillingFlowParams.ProductDetailsParams) it2.next()).getDetails$superwall_release().e());
        }
        Logger.debug$default(logger, logLevel, logScope, "Observer mode is not enabled. In order to observe purchases, please enable it in the SuperwallOptions by setting `shouldObservePurchases` to true.", MapsKt.mapOf(pairA, TuplesKt.a("products", CollectionsKt.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null))), (Throwable) null, 16, (Object) null);
        BillingResult billingResultG2 = billingClient.g(activity, params.toOriginal());
        Intrinsics.checkNotNullExpressionValue(billingResultG2, "launchBillingFlow(...)");
        return billingResultG2;
    }
}
