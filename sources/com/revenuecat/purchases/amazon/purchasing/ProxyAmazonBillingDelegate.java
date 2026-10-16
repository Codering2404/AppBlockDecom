package com.revenuecat.purchases.amazon.purchasing;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.amazon.device.iap.model.RequestId;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.amazon.AmazonStrings;
import com.revenuecat.purchases.amazon.PurchasingServiceProvider;
import com.revenuecat.purchases.common.LogUtilsKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class ProxyAmazonBillingDelegate {
    private /* synthetic */ ProxyAmazonBillingActivityBroadcastReceiver broadcastReceiver;
    private final IntentFilter filter = ProxyAmazonBillingActivityBroadcastReceiver.Companion.newPurchaseFinishedIntentFilter();

    public final ProxyAmazonBillingActivityBroadcastReceiver getBroadcastReceiver$purchases_defaultsBc8Release() {
        return this.broadcastReceiver;
    }

    public final void onCreate(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ProxyAmazonBillingActivityBroadcastReceiver proxyAmazonBillingActivityBroadcastReceiver = new ProxyAmazonBillingActivityBroadcastReceiver(activity);
        this.broadcastReceiver = proxyAmazonBillingActivityBroadcastReceiver;
        if (Build.VERSION.SDK_INT >= 33) {
            activity.registerReceiver(proxyAmazonBillingActivityBroadcastReceiver, this.filter, 2);
        } else {
            activity.registerReceiver(proxyAmazonBillingActivityBroadcastReceiver, this.filter);
        }
        if (bundle == null) {
            Intent intent = activity.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
            if (startAmazonPurchase$purchases_defaultsBc8Release(intent) == null) {
                activity.finish();
            }
        }
    }

    public final void onDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.unregisterReceiver(this.broadcastReceiver);
        this.broadcastReceiver = null;
    }

    public final void setBroadcastReceiver$purchases_defaultsBc8Release(ProxyAmazonBillingActivityBroadcastReceiver proxyAmazonBillingActivityBroadcastReceiver) {
        this.broadcastReceiver = proxyAmazonBillingActivityBroadcastReceiver;
    }

    public final RequestId startAmazonPurchase$purchases_defaultsBc8Release(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra("sku");
        ResultReceiver resultReceiver = (ResultReceiver) intent.getParcelableExtra(ProxyAmazonBillingActivity.EXTRAS_RESULT_RECEIVER);
        PurchasingServiceProvider purchasingServiceProvider = (PurchasingServiceProvider) intent.getParcelableExtra(ProxyAmazonBillingActivity.EXTRAS_PURCHASING_SERVICE_PROVIDER);
        if (stringExtra != null && resultReceiver != null && purchasingServiceProvider != null) {
            RequestId requestIdPurchase = purchasingServiceProvider.purchase(stringExtra);
            Bundle bundle = new Bundle();
            bundle.putParcelable("request_id", (Parcelable) requestIdPurchase);
            resultReceiver.send(0, bundle);
            return requestIdPurchase;
        }
        PurchasesErrorCode purchasesErrorCode = PurchasesErrorCode.PurchaseInvalidError;
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str = String.format(AmazonStrings.ERROR_PURCHASE_INVALID_PROXY_ACTIVITY_ARGUMENTS, Arrays.copyOf(new Object[]{intent.toUri(0)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LogUtilsKt.errorLog(new PurchasesError(purchasesErrorCode, str));
        return null;
    }

    public static /* synthetic */ void getBroadcastReceiver$purchases_defaultsBc8Release$annotations() {
    }
}
