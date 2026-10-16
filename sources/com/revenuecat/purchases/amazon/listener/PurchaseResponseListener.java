package com.revenuecat.purchases.amazon.listener;

import android.app.Activity;
import android.os.Handler;
import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataResponse;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.models.StoreProduct;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public interface PurchaseResponseListener extends PurchasingListener {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        @Deprecated
        public static void onProductDataResponse(PurchaseResponseListener purchaseResponseListener, ProductDataResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            PurchaseResponseListener.super.onProductDataResponse(response);
        }

        @Deprecated
        public static void onPurchaseUpdatesResponse(PurchaseResponseListener purchaseResponseListener, PurchaseUpdatesResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            PurchaseResponseListener.super.onPurchaseUpdatesResponse(response);
        }

        @Deprecated
        public static void onUserDataResponse(PurchaseResponseListener purchaseResponseListener, UserDataResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            PurchaseResponseListener.super.onUserDataResponse(response);
        }
    }

    default void onProductDataResponse(ProductDataResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
    }

    default void onPurchaseUpdatesResponse(PurchaseUpdatesResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
    }

    void purchase(Handler handler, Activity activity, String str, StoreProduct storeProduct, Function2<? super Receipt, ? super UserData, Unit> function2, Function1<? super PurchasesError, Unit> function1);

    default void onUserDataResponse(UserDataResponse userDataResponse) {
        Intrinsics.checkNotNullParameter(userDataResponse, QaXmqxvjHhxVy.mAZMqijCNI);
    }
}
