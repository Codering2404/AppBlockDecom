package com.android.billingclient.api;

import android.app.Activity;
import android.content.Context;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BillingClient {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface BillingProgram {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface BillingResponseCode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile PendingPurchasesParams f57153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f57154b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile PurchasesUpdatedListener f57155c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private volatile UserChoiceBillingListener f57156d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private volatile DeveloperProvidedBillingListener f57157e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private volatile boolean f57158f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private volatile boolean f57159g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private volatile boolean f57160h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private volatile boolean f57161i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private volatile boolean f57162j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile boolean f57163k;

        /* synthetic */ Builder(Context context, zzac zzacVar) {
            this.f57154b = context;
        }

        private final boolean d() {
            try {
                Context context = this.f57154b;
                return context.getPackageManager().getApplicationInfo(context.getPackageName(), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD).metaData.getBoolean("com.google.android.play.billingclient.enableBillingOverridesTesting", false);
            } catch (Exception e3) {
                com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Unable to retrieve metadata value for enableBillingOverridesTesting.", e3);
                return false;
            }
        }

        public BillingClient a() {
            Context context = this.f57154b;
            if (context == null) {
                throw new IllegalArgumentException("Please provide a valid Context.");
            }
            if (this.f57155c == null) {
                if (this.f57156d != null) {
                    throw new IllegalArgumentException("Please provide a valid listener for Google Play Billing purchases updates when enabling User Choice Billing.");
                }
                if (this.f57158f || this.f57159g || this.f57160h || this.f57161i || this.f57162j) {
                    return d() ? new zzcw(null, context, null, null, this) : new BillingClientImpl(null, context, null, null, this);
                }
                throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
            }
            if (this.f57153a == null || !this.f57153a.a()) {
                throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
            }
            if (this.f57155c == null) {
                PendingPurchasesParams pendingPurchasesParams = this.f57153a;
                return d() ? new zzcw(null, pendingPurchasesParams, context, null, null, null, this) : new BillingClientImpl(null, pendingPurchasesParams, context, null, null, null, this);
            }
            if (this.f57156d == null && this.f57157e == null) {
                PendingPurchasesParams pendingPurchasesParams2 = this.f57153a;
                PurchasesUpdatedListener purchasesUpdatedListener = this.f57155c;
                return d() ? new zzcw(null, pendingPurchasesParams2, context, purchasesUpdatedListener, null, null, null, this) : new BillingClientImpl(null, pendingPurchasesParams2, context, purchasesUpdatedListener, null, null, null, this);
            }
            PendingPurchasesParams pendingPurchasesParams3 = this.f57153a;
            PurchasesUpdatedListener purchasesUpdatedListener2 = this.f57155c;
            UserChoiceBillingListener userChoiceBillingListener = this.f57156d;
            DeveloperProvidedBillingListener developerProvidedBillingListener = this.f57157e;
            return d() ? new zzcw(null, pendingPurchasesParams3, context, purchasesUpdatedListener2, userChoiceBillingListener, developerProvidedBillingListener, null, null, this) : new BillingClientImpl(null, pendingPurchasesParams3, context, purchasesUpdatedListener2, userChoiceBillingListener, developerProvidedBillingListener, null, null, this);
        }

        public Builder b(PendingPurchasesParams pendingPurchasesParams) {
            this.f57153a = pendingPurchasesParams;
            return this;
        }

        public Builder c(PurchasesUpdatedListener purchasesUpdatedListener) {
            this.f57155c = purchasesUpdatedListener;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ConnectionState {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FeatureType {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface OnPurchasesUpdatedSubResponseCode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ProductType {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    @Deprecated
    public @interface SkuType {
    }

    public static Builder h(Context context) {
        return new Builder(context, null);
    }

    public abstract void a(AcknowledgePurchaseParams acknowledgePurchaseParams, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener);

    public abstract void b(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener);

    public abstract void c();

    public abstract void d(GetBillingConfigParams getBillingConfigParams, BillingConfigResponseListener billingConfigResponseListener);

    public abstract BillingResult e(String str);

    public abstract boolean f();

    public abstract BillingResult g(Activity activity, BillingFlowParams billingFlowParams);

    public abstract void i(QueryProductDetailsParams queryProductDetailsParams, ProductDetailsResponseListener productDetailsResponseListener);

    public abstract void j(QueryPurchasesParams queryPurchasesParams, PurchasesResponseListener purchasesResponseListener);

    public abstract BillingResult k(Activity activity, InAppMessageParams inAppMessageParams, InAppMessageResponseListener inAppMessageResponseListener);

    public abstract void l(BillingClientStateListener billingClientStateListener);
}
