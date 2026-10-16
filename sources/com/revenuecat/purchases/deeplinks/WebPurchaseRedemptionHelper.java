package com.revenuecat.purchases.deeplinks;

import android.os.Handler;
import android.os.Looper;
import com.revenuecat.purchases.CustomerInfoUpdateHandler;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.WebPurchaseRedemption;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.offlineentitlements.OfflineEntitlementsManager;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.interfaces.RedeemWebPurchaseListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class WebPurchaseRedemptionHelper {
    private final Backend backend;
    private final CustomerInfoUpdateHandler customerInfoUpdateHandler;
    private final IdentityManager identityManager;
    private final Handler mainHandler;
    private final OfflineEntitlementsManager offlineEntitlementsManager;

    public WebPurchaseRedemptionHelper(Backend backend, IdentityManager identityManager, OfflineEntitlementsManager offlineEntitlementsManager, CustomerInfoUpdateHandler customerInfoUpdateHandler, Handler handler) {
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(identityManager, "identityManager");
        Intrinsics.checkNotNullParameter(offlineEntitlementsManager, "offlineEntitlementsManager");
        Intrinsics.checkNotNullParameter(customerInfoUpdateHandler, "customerInfoUpdateHandler");
        this.backend = backend;
        this.identityManager = identityManager;
        this.offlineEntitlementsManager = offlineEntitlementsManager;
        this.customerInfoUpdateHandler = customerInfoUpdateHandler;
        this.mainHandler = handler;
    }

    private final void dispatch(final Function0<Unit> function0) {
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            function0.invoke();
            return;
        }
        Handler handler = this.mainHandler;
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.post(new Runnable() { // from class: com.revenuecat.purchases.deeplinks.a
            @Override // java.lang.Runnable
            public final void run() {
                function0.invoke();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchResult(final RedeemWebPurchaseListener redeemWebPurchaseListener, final RedeemWebPurchaseListener.Result result) {
        dispatch(new Function0<Unit>() { // from class: com.revenuecat.purchases.deeplinks.WebPurchaseRedemptionHelper.dispatchResult.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m564invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m564invoke() {
                redeemWebPurchaseListener.handleResult(result);
            }
        });
    }

    public final void handleRedeemWebPurchase(WebPurchaseRedemption webPurchaseRedemption, final RedeemWebPurchaseListener listener) {
        Intrinsics.checkNotNullParameter(webPurchaseRedemption, "webPurchaseRedemption");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LogLevel logLevel = LogLevel.DEBUG;
        LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
            currentLogHandler.d("[Purchases] - " + logLevel.name(), "Starting web purchase redemption.");
        }
        this.backend.postRedeemWebPurchase(this.identityManager.getCurrentAppUserID(), webPurchaseRedemption.getRedemptionToken$purchases_defaultsBc8Release(), new Function1<RedeemWebPurchaseListener.Result, Unit>() { // from class: com.revenuecat.purchases.deeplinks.WebPurchaseRedemptionHelper.handleRedeemWebPurchase.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((RedeemWebPurchaseListener.Result) obj);
                return Unit.f139807a;
            }

            public final void invoke(RedeemWebPurchaseListener.Result result) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (!(result instanceof RedeemWebPurchaseListener.Result.Success)) {
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error redeeming web purchase: " + result, null);
                    WebPurchaseRedemptionHelper.this.dispatchResult(listener, result);
                    return;
                }
                LogLevel logLevel2 = LogLevel.DEBUG;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.d("[Purchases] - " + logLevel2.name(), "Successfully redeemed web purchase. Updating customer info.");
                }
                WebPurchaseRedemptionHelper.this.offlineEntitlementsManager.resetOfflineCustomerInfoCache();
                WebPurchaseRedemptionHelper.this.customerInfoUpdateHandler.cacheAndNotifyListeners(((RedeemWebPurchaseListener.Result.Success) result).getCustomerInfo());
                WebPurchaseRedemptionHelper.this.dispatchResult(listener, result);
            }
        });
    }

    public /* synthetic */ WebPurchaseRedemptionHelper(Backend backend, IdentityManager identityManager, OfflineEntitlementsManager offlineEntitlementsManager, CustomerInfoUpdateHandler customerInfoUpdateHandler, Handler handler, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(backend, identityManager, offlineEntitlementsManager, customerInfoUpdateHandler, (i3 & 16) != 0 ? new Handler(Looper.getMainLooper()) : handler);
    }
}
