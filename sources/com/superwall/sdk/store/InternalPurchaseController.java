package com.superwall.sdk.store;

import android.app.Activity;
import android.content.Context;
import com.android.billingclient.api.ProductDetails;
import com.superwall.sdk.delegate.PurchaseResult;
import com.superwall.sdk.delegate.RestorationResult;
import com.superwall.sdk.delegate.subscription_controller.PurchaseController;
import com.superwall.sdk.delegate.subscription_controller.PurchaseControllerJava;
import com.superwall.sdk.store.abstractions.product.RawStoreProduct;
import com.superwall.sdk.store.abstractions.product.StoreProduct;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class InternalPurchaseController implements PurchaseController {
    private final Context context;
    private final PurchaseControllerJava javaPurchaseController;
    private final PurchaseController kotlinPurchaseController;

    public InternalPurchaseController(PurchaseController purchaseController, PurchaseControllerJava purchaseControllerJava, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.kotlinPurchaseController = purchaseController;
        this.javaPurchaseController = purchaseControllerJava;
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object purchaseWithJavaController(ProductDetails productDetails, String str, String str2, Continuation<? super PurchaseResult> continuation) throws Throwable {
        if (this.javaPurchaseController == null) {
            return new PurchaseResult.Cancelled();
        }
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.c(continuation));
        this.javaPurchaseController.purchase(productDetails, str, str2, new Function1<PurchaseResult, Unit>() { // from class: com.superwall.sdk.store.InternalPurchaseController$purchaseWithJavaController$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchaseResult) obj);
                return Unit.f139807a;
            }

            public final void invoke(PurchaseResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                safeContinuation.resumeWith(Result.b(result));
            }
        });
        Object objA = safeContinuation.a();
        if (objA == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objA;
    }

    public final Context getContext() {
        return this.context;
    }

    public final boolean getHasExternalPurchaseController() {
        return !getHasInternalPurchaseController();
    }

    public final boolean getHasInternalPurchaseController() {
        return this.kotlinPurchaseController instanceof AutomaticPurchaseController;
    }

    @Override // com.superwall.sdk.delegate.subscription_controller.PurchaseController
    @Deprecated
    public Object purchase(Activity activity, ProductDetails productDetails, String str, String str2, Continuation<? super PurchaseResult> continuation) {
        PurchaseController purchaseController = this.kotlinPurchaseController;
        return purchaseController != null ? purchaseController.purchase(activity, productDetails, str, str2, continuation) : purchaseWithJavaController(productDetails, str, str2, continuation);
    }

    @Override // com.superwall.sdk.delegate.subscription_controller.PurchaseController
    public Object restorePurchases(Continuation<? super RestorationResult> continuation) throws Throwable {
        PurchaseController purchaseController = this.kotlinPurchaseController;
        if (purchaseController != null) {
            return purchaseController.restorePurchases(continuation);
        }
        if (this.javaPurchaseController == null) {
            return new RestorationResult.Failed(null);
        }
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.c(continuation));
        this.javaPurchaseController.restorePurchases(new Function2<RestorationResult, Throwable, Unit>() { // from class: com.superwall.sdk.store.InternalPurchaseController$restorePurchases$2$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((RestorationResult) obj, (Throwable) obj2);
                return Unit.f139807a;
            }

            public final void invoke(RestorationResult result, Throwable th) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (th == null) {
                    safeContinuation.resumeWith(Result.b(result));
                    return;
                }
                Continuation<RestorationResult> continuation2 = safeContinuation;
                Result.Companion companion = Result.f139772b;
                continuation2.resumeWith(Result.b(new RestorationResult.Failed(th)));
            }
        });
        Object objA = safeContinuation.a();
        if (objA == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objA;
    }

    @Override // com.superwall.sdk.delegate.subscription_controller.PurchaseController
    public Object purchase(Activity activity, StoreProduct storeProduct, String str, String str2, Continuation<? super PurchaseResult> continuation) {
        PurchaseController purchaseController = this.kotlinPurchaseController;
        if (purchaseController != null) {
            return purchaseController.purchase(activity, storeProduct, str, str2, continuation);
        }
        RawStoreProduct rawStoreProduct = storeProduct.getRawStoreProduct();
        ProductDetails underlyingProductDetails = rawStoreProduct != null ? rawStoreProduct.getUnderlyingProductDetails() : null;
        if (underlyingProductDetails != null) {
            return purchaseWithJavaController(underlyingProductDetails, str, str2, continuation);
        }
        return new PurchaseResult.Failed("No PurchaseController configured to handle custom product purchase.");
    }
}
