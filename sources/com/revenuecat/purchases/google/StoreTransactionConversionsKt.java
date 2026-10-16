package com.revenuecat.purchases.google;

import com.android.billingclient.api.Purchase;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.models.PurchaseType;
import com.revenuecat.purchases.models.StoreReplacementMode;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class StoreTransactionConversionsKt {
    public static final Purchase getOriginalGooglePurchase(StoreTransaction storeTransaction) {
        Intrinsics.checkNotNullParameter(storeTransaction, "<this>");
        String signature = storeTransaction.getSignature();
        if (signature == null) {
            return null;
        }
        if (storeTransaction.getPurchaseType() != PurchaseType.GOOGLE_PURCHASE) {
            signature = null;
        }
        if (signature != null) {
            return new Purchase(storeTransaction.getOriginalJson().toString(), signature);
        }
        return null;
    }

    public static final StoreTransaction toStoreTransaction(Purchase purchase, ProductType productType, PresentedOfferingContext presentedOfferingContext, String str, Map<String, String> map, StoreReplacementMode storeReplacementMode) {
        Intrinsics.checkNotNullParameter(purchase, "<this>");
        Intrinsics.checkNotNullParameter(productType, "productType");
        String strA = purchase.a();
        List listC = purchase.c();
        Intrinsics.checkNotNullExpressionValue(listC, "this.products");
        long jE = purchase.e();
        String strF = purchase.f();
        Intrinsics.checkNotNullExpressionValue(strF, "this.purchaseToken");
        return new StoreTransaction(strA, listC, productType, jE, strF, PurchaseStateConversionsKt.toRevenueCatPurchaseState(purchase.d()), Boolean.valueOf(purchase.i()), purchase.g(), new JSONObject(purchase.b()), presentedOfferingContext, null, PurchaseType.GOOGLE_PURCHASE, null, str, map, storeReplacementMode);
    }

    public static /* synthetic */ StoreTransaction toStoreTransaction$default(Purchase purchase, ProductType productType, PresentedOfferingContext presentedOfferingContext, String str, Map map, StoreReplacementMode storeReplacementMode, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            presentedOfferingContext = null;
        }
        if ((i3 & 4) != 0) {
            str = null;
        }
        if ((i3 & 8) != 0) {
            map = null;
        }
        if ((i3 & 16) != 0) {
            storeReplacementMode = null;
        }
        return toStoreTransaction(purchase, productType, presentedOfferingContext, str, map, storeReplacementMode);
    }

    public static final StoreTransaction toStoreTransaction(Purchase purchase, PurchaseContext purchaseContext) {
        Intrinsics.checkNotNullParameter(purchase, "<this>");
        Intrinsics.checkNotNullParameter(purchaseContext, "purchaseContext");
        return toStoreTransaction(purchase, purchaseContext.getProductType(), purchaseContext.getPresentedOfferingContext(), purchaseContext.getSelectedSubscriptionOptionId(), purchaseContext.getSubscriptionOptionIdForProductIDs(), purchaseContext.getReplacementMode());
    }
}
