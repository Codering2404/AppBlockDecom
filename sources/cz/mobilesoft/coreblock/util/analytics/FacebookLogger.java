package cz.mobilesoft.coreblock.util.analytics;

import android.content.Context;
import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.revenuecat.purchases.models.StoreProduct;
import cz.mobilesoft.coreblock.util.CrashHelper;
import java.math.BigDecimal;
import java.util.Currency;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class FacebookLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AppEventsLogger f128215a;

    public FacebookLogger(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f128215a = AppEventsLogger.Companion.newLogger(context);
    }

    private final Bundle a(StoreProduct storeProduct) {
        Bundle bundle = new Bundle();
        bundle.putString(AppEventsConstants.EVENT_PARAM_CONTENT, storeProduct.toString());
        bundle.putString(AppEventsConstants.EVENT_PARAM_CONTENT_ID, storeProduct.getPurchasingData().getProductId());
        bundle.putString(AppEventsConstants.EVENT_PARAM_CONTENT_TYPE, storeProduct.getSubscriptionOptions() != null ? "subs" : "inapp");
        bundle.putInt(AppEventsConstants.EVENT_PARAM_NUM_ITEMS, 1);
        bundle.putInt(AppEventsConstants.EVENT_PARAM_PAYMENT_INFO_AVAILABLE, 1);
        return bundle;
    }

    public final void b(StoreProduct product) {
        Intrinsics.checkNotNullParameter(product, "product");
        try {
            Bundle bundleA = a(product);
            bundleA.putString(AppEventsConstants.EVENT_PARAM_CURRENCY, product.getPrice().getCurrencyCode());
            this.f128215a.logEvent(AppEventsConstants.EVENT_NAME_INITIATED_CHECKOUT, product.getPrice().getAmountMicros() / 1000000.0d, bundleA);
        } catch (Throwable th) {
            th.printStackTrace();
            CrashHelper.j(th);
        }
    }

    public final void c() {
        try {
            Bundle bundle = new Bundle();
            bundle.putString(AppEventsConstants.EVENT_PARAM_REGISTRATION_METHOD, "onboarding");
            this.f128215a.logEvent(AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION, bundle);
        } catch (Throwable th) {
            th.printStackTrace();
            CrashHelper.j(th);
        }
    }

    public final void d(String contentId) {
        Intrinsics.checkNotNullParameter(contentId, "contentId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(AppEventsConstants.EVENT_PARAM_CONTENT_ID, contentId);
            bundle.putString(AppEventsConstants.EVENT_PARAM_CONTENT_TYPE, "premium_screen");
            this.f128215a.logEvent(AppEventsConstants.EVENT_NAME_VIEWED_CONTENT, bundle);
        } catch (Throwable th) {
            th.printStackTrace();
            CrashHelper.j(th);
        }
    }

    public final void e(StoreProduct product) {
        Intrinsics.checkNotNullParameter(product, "product");
        try {
            this.f128215a.logPurchase(BigDecimal.valueOf(product.getPrice().getAmountMicros()).divide(BigDecimal.valueOf(1000000L)), Currency.getInstance(product.getPrice().getCurrencyCode()), a(product));
        } catch (Throwable th) {
            th.printStackTrace();
            CrashHelper.j(th);
        }
    }

    public final void f(StoreProduct product) {
        Intrinsics.checkNotNullParameter(product, "product");
        try {
            Bundle bundleA = a(product);
            bundleA.putString(AppEventsConstants.EVENT_PARAM_CURRENCY, product.getPrice().getCurrencyCode());
            this.f128215a.logEvent(AppEventsConstants.EVENT_NAME_START_TRIAL, product.getPrice().getAmountMicros() / 1000000.0d, bundleA);
        } catch (Throwable th) {
            th.printStackTrace();
            CrashHelper.j(th);
        }
    }

    public final void g(StoreProduct product) {
        Intrinsics.checkNotNullParameter(product, "product");
        try {
            Bundle bundleA = a(product);
            bundleA.putString(AppEventsConstants.EVENT_PARAM_CURRENCY, product.getPrice().getCurrencyCode());
            this.f128215a.logEvent(AppEventsConstants.EVENT_NAME_SUBSCRIBE, product.getPrice().getAmountMicros() / 1000000.0d, bundleA);
        } catch (Throwable th) {
            th.printStackTrace();
            CrashHelper.j(th);
        }
    }
}
