package com.revenuecat.purchases.amazon.purchasing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.revenuecat.purchases.amazon.PurchasingServiceProvider;
import com.revenuecat.purchases.api.R;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class ProxyAmazonBillingActivity extends Activity {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRAS_PURCHASING_SERVICE_PROVIDER = "purchasing_service_provider";
    public static final String EXTRAS_REQUEST_ID = "request_id";
    public static final String EXTRAS_RESULT_RECEIVER = "result_receiver";
    public static final String EXTRAS_SKU = "sku";
    private ProxyAmazonBillingDelegate proxyAmazonBillingDelegate;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent newStartIntent(Context context, ResultReceiver resultReceiver, String sku, PurchasingServiceProvider purchasingServiceProvider) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(resultReceiver, "resultReceiver");
            Intrinsics.checkNotNullParameter(sku, "sku");
            Intrinsics.checkNotNullParameter(purchasingServiceProvider, "purchasingServiceProvider");
            Intent intent = new Intent(context, (Class<?>) ProxyAmazonBillingActivity.class);
            intent.putExtra(ProxyAmazonBillingActivity.EXTRAS_RESULT_RECEIVER, resultReceiver);
            intent.putExtra("sku", sku);
            intent.putExtra(ProxyAmazonBillingActivity.EXTRAS_PURCHASING_SERVICE_PROVIDER, purchasingServiceProvider);
            return intent;
        }

        private Companion() {
        }
    }

    public final ProxyAmazonBillingDelegate getProxyAmazonBillingDelegate$purchases_defaultsBc8Release() {
        return this.proxyAmazonBillingDelegate;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        setTheme(R.style.ProxyAmazonBillingActivityTheme);
        super.onCreate(bundle);
        ProxyAmazonBillingDelegate proxyAmazonBillingDelegate = new ProxyAmazonBillingDelegate();
        this.proxyAmazonBillingDelegate = proxyAmazonBillingDelegate;
        proxyAmazonBillingDelegate.onCreate(this, bundle);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ProxyAmazonBillingDelegate proxyAmazonBillingDelegate = this.proxyAmazonBillingDelegate;
        if (proxyAmazonBillingDelegate != null) {
            proxyAmazonBillingDelegate.onDestroy(this);
        }
        this.proxyAmazonBillingDelegate = null;
    }

    public final void setProxyAmazonBillingDelegate$purchases_defaultsBc8Release(ProxyAmazonBillingDelegate proxyAmazonBillingDelegate) {
        this.proxyAmazonBillingDelegate = proxyAmazonBillingDelegate;
    }

    public static /* synthetic */ void getProxyAmazonBillingDelegate$purchases_defaultsBc8Release$annotations() {
    }
}
