package com.revenuecat.purchases.amazon;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserDataRequest;
import java.util.Set;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class DefaultPurchasingServiceProvider implements PurchasingServiceProvider {
    public static final Parcelable.Creator<DefaultPurchasingServiceProvider> CREATOR = new Creator();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Creator implements Parcelable.Creator<DefaultPurchasingServiceProvider> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DefaultPurchasingServiceProvider createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return new DefaultPurchasingServiceProvider();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DefaultPurchasingServiceProvider[] newArray(int i3) {
            return new DefaultPurchasingServiceProvider[i3];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.revenuecat.purchases.amazon.PurchasingServiceProvider
    public RequestId getProductData(Set<String> skus) {
        Intrinsics.checkNotNullParameter(skus, "skus");
        RequestId productData = PurchasingService.getProductData(skus);
        Intrinsics.checkNotNullExpressionValue(productData, "getProductData(skus)");
        return productData;
    }

    @Override // com.revenuecat.purchases.amazon.PurchasingServiceProvider
    public RequestId getPurchaseUpdates(boolean z2) {
        RequestId purchaseUpdates = PurchasingService.getPurchaseUpdates(z2);
        Intrinsics.checkNotNullExpressionValue(purchaseUpdates, "getPurchaseUpdates(reset)");
        return purchaseUpdates;
    }

    @Override // com.revenuecat.purchases.amazon.PurchasingServiceProvider
    public RequestId getUserData() {
        RequestId userData = PurchasingService.getUserData(UserDataRequest.newBuilder().setFetchLWAConsentStatus(true).build());
        Intrinsics.checkNotNullExpressionValue(userData, "getUserData(UserDataRequ…sentStatus(true).build())");
        return userData;
    }

    @Override // com.revenuecat.purchases.amazon.PurchasingServiceProvider
    public void notifyFulfillment(String receiptId, FulfillmentResult fulfillmentResult) {
        Intrinsics.checkNotNullParameter(receiptId, "receiptId");
        Intrinsics.checkNotNullParameter(fulfillmentResult, "fulfillmentResult");
        PurchasingService.notifyFulfillment(receiptId, fulfillmentResult);
    }

    @Override // com.revenuecat.purchases.amazon.PurchasingServiceProvider
    public RequestId purchase(String sku) {
        Intrinsics.checkNotNullParameter(sku, "sku");
        RequestId requestIdPurchase = PurchasingService.purchase(sku);
        Intrinsics.checkNotNullExpressionValue(requestIdPurchase, "purchase(sku)");
        return requestIdPurchase;
    }

    @Override // com.revenuecat.purchases.amazon.PurchasingServiceProvider
    public void registerListener(Context context, PurchasingListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        PurchasingService.registerListener(context, listener);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(1);
    }
}
