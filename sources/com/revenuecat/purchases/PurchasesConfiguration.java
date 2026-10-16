package com.revenuecat.purchases;

import android.content.Context;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.galaxy.GalaxyBillingMode;
import java.util.concurrent.ExecutorService;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public class PurchasesConfiguration {
    private final String apiKey;
    private final String appUserID;
    private final boolean automaticDeviceIdentifierCollectionEnabled;
    private final Context context;
    private final DangerousSettings dangerousSettings;
    private final boolean diagnosticsEnabled;
    private final GalaxyBillingMode galaxyBillingMode;
    private final boolean pendingTransactionsForPrepaidPlansEnabled;
    private final String preferredUILocaleOverride;
    private final PurchasesAreCompletedBy purchasesAreCompletedBy;
    private final ExecutorService service;
    private final boolean showInAppMessagesAutomatically;
    private final Store store;
    private final EntitlementVerificationMode verificationMode;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PurchasesAreCompletedBy.values().length];
            try {
                iArr[PurchasesAreCompletedBy.REVENUECAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PurchasesAreCompletedBy.MY_APP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PurchasesConfiguration(Builder builder) {
        Context applicationContext;
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (UtilsKt.isDeviceProtectedStorageCompat(builder.getContext$purchases_defaultsBc8Release())) {
            applicationContext = builder.getContext$purchases_defaultsBc8Release();
        } else {
            applicationContext = builder.getContext$purchases_defaultsBc8Release().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "{\n                builde…tionContext\n            }");
        }
        this.context = applicationContext;
        this.apiKey = StringsKt.t1(builder.getApiKey$purchases_defaultsBc8Release()).toString();
        this.appUserID = builder.getAppUserID$purchases_defaultsBc8Release();
        this.purchasesAreCompletedBy = builder.getPurchasesAreCompletedBy$purchases_defaultsBc8Release();
        this.service = builder.getService$purchases_defaultsBc8Release();
        this.store = builder.getStore$purchases_defaultsBc8Release();
        this.diagnosticsEnabled = builder.getDiagnosticsEnabled$purchases_defaultsBc8Release();
        this.verificationMode = builder.getVerificationMode$purchases_defaultsBc8Release();
        this.dangerousSettings = builder.getDangerousSettings$purchases_defaultsBc8Release();
        this.showInAppMessagesAutomatically = builder.getShowInAppMessagesAutomatically$purchases_defaultsBc8Release();
        this.pendingTransactionsForPrepaidPlansEnabled = builder.getPendingTransactionsForPrepaidPlansEnabled$purchases_defaultsBc8Release();
        this.automaticDeviceIdentifierCollectionEnabled = builder.getAutomaticDeviceIdentifierCollectionEnabled$purchases_defaultsBc8Release();
        this.preferredUILocaleOverride = builder.getPreferredUILocaleOverride$purchases_defaultsBc8Release();
        this.galaxyBillingMode = builder.getGalaxyBillingMode$purchases_defaultsBc8Release();
    }

    public static /* synthetic */ PurchasesConfiguration copy$purchases_defaultsBc8Release$default(PurchasesConfiguration purchasesConfiguration, String str, ExecutorService executorService, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        }
        if ((i3 & 1) != 0) {
            str = purchasesConfiguration.appUserID;
        }
        if ((i3 & 2) != 0) {
            executorService = purchasesConfiguration.service;
        }
        return purchasesConfiguration.copy$purchases_defaultsBc8Release(str, executorService);
    }

    public final PurchasesConfiguration copy$purchases_defaultsBc8Release(String str, ExecutorService executorService) {
        Builder builderGalaxyBillingMode = new Builder(this.context, this.apiKey).appUserID(str).purchasesAreCompletedBy(this.purchasesAreCompletedBy).store(this.store).diagnosticsEnabled(this.diagnosticsEnabled).entitlementVerificationMode(this.verificationMode).dangerousSettings(this.dangerousSettings).showInAppMessagesAutomatically(this.showInAppMessagesAutomatically).pendingTransactionsForPrepaidPlansEnabled(this.pendingTransactionsForPrepaidPlansEnabled).automaticDeviceIdentifierCollectionEnabled(this.automaticDeviceIdentifierCollectionEnabled).preferredUILocaleOverride(this.preferredUILocaleOverride).galaxyBillingMode(this.galaxyBillingMode);
        if (executorService != null) {
            builderGalaxyBillingMode = builderGalaxyBillingMode.service(executorService);
        }
        return builderGalaxyBillingMode.build();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.revenuecat.purchases.PurchasesConfiguration");
        PurchasesConfiguration purchasesConfiguration = (PurchasesConfiguration) obj;
        return Intrinsics.areEqual(this.apiKey, purchasesConfiguration.apiKey) && Intrinsics.areEqual(this.appUserID, purchasesConfiguration.appUserID) && this.purchasesAreCompletedBy == purchasesConfiguration.purchasesAreCompletedBy && this.showInAppMessagesAutomatically == purchasesConfiguration.showInAppMessagesAutomatically && this.store == purchasesConfiguration.store && this.diagnosticsEnabled == purchasesConfiguration.diagnosticsEnabled && Intrinsics.areEqual(this.dangerousSettings, purchasesConfiguration.dangerousSettings) && this.verificationMode == purchasesConfiguration.verificationMode && this.pendingTransactionsForPrepaidPlansEnabled == purchasesConfiguration.pendingTransactionsForPrepaidPlansEnabled && this.automaticDeviceIdentifierCollectionEnabled == purchasesConfiguration.automaticDeviceIdentifierCollectionEnabled && Intrinsics.areEqual(this.preferredUILocaleOverride, purchasesConfiguration.preferredUILocaleOverride) && this.galaxyBillingMode == purchasesConfiguration.galaxyBillingMode;
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final String getAppUserID() {
        return this.appUserID;
    }

    public final boolean getAutomaticDeviceIdentifierCollectionEnabled() {
        return this.automaticDeviceIdentifierCollectionEnabled;
    }

    public final Context getContext() {
        return this.context;
    }

    public final DangerousSettings getDangerousSettings() {
        return this.dangerousSettings;
    }

    public final boolean getDiagnosticsEnabled() {
        return this.diagnosticsEnabled;
    }

    public final GalaxyBillingMode getGalaxyBillingMode() {
        return this.galaxyBillingMode;
    }

    public final boolean getObserverMode() {
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.purchasesAreCompletedBy.ordinal()];
        if (i3 == 1) {
            return false;
        }
        if (i3 == 2) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean getPendingTransactionsForPrepaidPlansEnabled() {
        return this.pendingTransactionsForPrepaidPlansEnabled;
    }

    public final String getPreferredUILocaleOverride() {
        return this.preferredUILocaleOverride;
    }

    public final PurchasesAreCompletedBy getPurchasesAreCompletedBy() {
        return this.purchasesAreCompletedBy;
    }

    public final ExecutorService getService() {
        return this.service;
    }

    public final boolean getShowInAppMessagesAutomatically() {
        return this.showInAppMessagesAutomatically;
    }

    public final Store getStore() {
        return this.store;
    }

    public final EntitlementVerificationMode getVerificationMode() {
        return this.verificationMode;
    }

    public int hashCode() {
        int iHashCode = this.apiKey.hashCode() * 31;
        String str = this.appUserID;
        int iHashCode2 = (((((((((((((((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.purchasesAreCompletedBy.hashCode()) * 31) + Boolean.hashCode(this.showInAppMessagesAutomatically)) * 31) + this.store.hashCode()) * 31) + Boolean.hashCode(this.diagnosticsEnabled)) * 31) + this.dangerousSettings.hashCode()) * 31) + this.verificationMode.hashCode()) * 31) + Boolean.hashCode(this.pendingTransactionsForPrepaidPlansEnabled)) * 31) + Boolean.hashCode(this.automaticDeviceIdentifierCollectionEnabled)) * 31;
        String str2 = this.preferredUILocaleOverride;
        return ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.galaxyBillingMode.hashCode();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class Builder {
        private final String apiKey;
        private String appUserID;
        private boolean automaticDeviceIdentifierCollectionEnabled;
        private final Context context;
        private DangerousSettings dangerousSettings;
        private boolean diagnosticsEnabled;
        private GalaxyBillingMode galaxyBillingMode;
        private boolean pendingTransactionsForPrepaidPlansEnabled;
        private String preferredUILocaleOverride;
        private PurchasesAreCompletedBy purchasesAreCompletedBy;
        private ExecutorService service;
        private boolean showInAppMessagesAutomatically;
        private Store store;
        private EntitlementVerificationMode verificationMode;

        public Builder(Context context, String apiKey) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(apiKey, "apiKey");
            this.context = context;
            this.apiKey = apiKey;
            this.purchasesAreCompletedBy = PurchasesAreCompletedBy.REVENUECAT;
            this.showInAppMessagesAutomatically = true;
            this.store = Store.PLAY_STORE;
            this.verificationMode = EntitlementVerificationMode.Companion.getDefault();
            this.dangerousSettings = new DangerousSettings(false, 1, (DefaultConstructorMarker) null);
            this.automaticDeviceIdentifierCollectionEnabled = true;
            this.galaxyBillingMode = GalaxyBillingMode.PRODUCTION;
        }

        public final Builder appUserID(String str) {
            this.appUserID = str;
            return this;
        }

        public final Builder automaticDeviceIdentifierCollectionEnabled(boolean z2) {
            this.automaticDeviceIdentifierCollectionEnabled = z2;
            return this;
        }

        public PurchasesConfiguration build() {
            return new PurchasesConfiguration(this);
        }

        public final Builder dangerousSettings(DangerousSettings dangerousSettings) {
            Intrinsics.checkNotNullParameter(dangerousSettings, "dangerousSettings");
            this.dangerousSettings = dangerousSettings;
            return this;
        }

        public final Builder diagnosticsEnabled(boolean z2) {
            this.diagnosticsEnabled = z2;
            return this;
        }

        public final Builder entitlementVerificationMode(EntitlementVerificationMode verificationMode) {
            Intrinsics.checkNotNullParameter(verificationMode, "verificationMode");
            this.verificationMode = verificationMode;
            return this;
        }

        public final Builder galaxyBillingMode(GalaxyBillingMode galaxyBillingMode) {
            Intrinsics.checkNotNullParameter(galaxyBillingMode, "galaxyBillingMode");
            this.galaxyBillingMode = galaxyBillingMode;
            return this;
        }

        public final /* synthetic */ String getApiKey$purchases_defaultsBc8Release() {
            return this.apiKey;
        }

        public final /* synthetic */ String getAppUserID$purchases_defaultsBc8Release() {
            return this.appUserID;
        }

        public final /* synthetic */ boolean getAutomaticDeviceIdentifierCollectionEnabled$purchases_defaultsBc8Release() {
            return this.automaticDeviceIdentifierCollectionEnabled;
        }

        public final /* synthetic */ Context getContext$purchases_defaultsBc8Release() {
            return this.context;
        }

        public final /* synthetic */ DangerousSettings getDangerousSettings$purchases_defaultsBc8Release() {
            return this.dangerousSettings;
        }

        public final /* synthetic */ boolean getDiagnosticsEnabled$purchases_defaultsBc8Release() {
            return this.diagnosticsEnabled;
        }

        public final /* synthetic */ GalaxyBillingMode getGalaxyBillingMode$purchases_defaultsBc8Release() {
            return this.galaxyBillingMode;
        }

        public final /* synthetic */ boolean getPendingTransactionsForPrepaidPlansEnabled$purchases_defaultsBc8Release() {
            return this.pendingTransactionsForPrepaidPlansEnabled;
        }

        public final /* synthetic */ String getPreferredUILocaleOverride$purchases_defaultsBc8Release() {
            return this.preferredUILocaleOverride;
        }

        public final /* synthetic */ PurchasesAreCompletedBy getPurchasesAreCompletedBy$purchases_defaultsBc8Release() {
            return this.purchasesAreCompletedBy;
        }

        public final /* synthetic */ ExecutorService getService$purchases_defaultsBc8Release() {
            return this.service;
        }

        public final /* synthetic */ boolean getShowInAppMessagesAutomatically$purchases_defaultsBc8Release() {
            return this.showInAppMessagesAutomatically;
        }

        public final /* synthetic */ Store getStore$purchases_defaultsBc8Release() {
            return this.store;
        }

        public final /* synthetic */ EntitlementVerificationMode getVerificationMode$purchases_defaultsBc8Release() {
            return this.verificationMode;
        }

        @Deprecated
        public final /* synthetic */ Builder informationalVerificationModeAndDiagnosticsEnabled(boolean z2) {
            if (z2) {
                this.verificationMode = EntitlementVerificationMode.INFORMATIONAL;
                this.diagnosticsEnabled = true;
                return this;
            }
            this.verificationMode = EntitlementVerificationMode.DISABLED;
            this.diagnosticsEnabled = false;
            return this;
        }

        @Deprecated
        public final Builder observerMode(boolean z2) {
            purchasesAreCompletedBy(z2 ? PurchasesAreCompletedBy.MY_APP : PurchasesAreCompletedBy.REVENUECAT);
            return this;
        }

        public final Builder pendingTransactionsForPrepaidPlansEnabled(boolean z2) {
            this.pendingTransactionsForPrepaidPlansEnabled = z2;
            return this;
        }

        public final Builder preferredUILocaleOverride(String str) {
            this.preferredUILocaleOverride = str;
            return this;
        }

        public final Builder purchasesAreCompletedBy(PurchasesAreCompletedBy purchasesAreCompletedBy) {
            Intrinsics.checkNotNullParameter(purchasesAreCompletedBy, "purchasesAreCompletedBy");
            this.purchasesAreCompletedBy = purchasesAreCompletedBy;
            return this;
        }

        public final Builder service(ExecutorService service) {
            Intrinsics.checkNotNullParameter(service, "service");
            this.service = service;
            return this;
        }

        public final /* synthetic */ void setAppUserID$purchases_defaultsBc8Release(String str) {
            this.appUserID = str;
        }

        public final /* synthetic */ void setAutomaticDeviceIdentifierCollectionEnabled$purchases_defaultsBc8Release(boolean z2) {
            this.automaticDeviceIdentifierCollectionEnabled = z2;
        }

        public final /* synthetic */ void setDangerousSettings$purchases_defaultsBc8Release(DangerousSettings dangerousSettings) {
            Intrinsics.checkNotNullParameter(dangerousSettings, "<set-?>");
            this.dangerousSettings = dangerousSettings;
        }

        public final /* synthetic */ void setDiagnosticsEnabled$purchases_defaultsBc8Release(boolean z2) {
            this.diagnosticsEnabled = z2;
        }

        public final /* synthetic */ void setGalaxyBillingMode$purchases_defaultsBc8Release(GalaxyBillingMode galaxyBillingMode) {
            Intrinsics.checkNotNullParameter(galaxyBillingMode, "<set-?>");
            this.galaxyBillingMode = galaxyBillingMode;
        }

        public final /* synthetic */ void setPendingTransactionsForPrepaidPlansEnabled$purchases_defaultsBc8Release(boolean z2) {
            this.pendingTransactionsForPrepaidPlansEnabled = z2;
        }

        public final /* synthetic */ void setPreferredUILocaleOverride$purchases_defaultsBc8Release(String str) {
            this.preferredUILocaleOverride = str;
        }

        public final /* synthetic */ void setPurchasesAreCompletedBy$purchases_defaultsBc8Release(PurchasesAreCompletedBy purchasesAreCompletedBy) {
            Intrinsics.checkNotNullParameter(purchasesAreCompletedBy, "<set-?>");
            this.purchasesAreCompletedBy = purchasesAreCompletedBy;
        }

        public final /* synthetic */ void setService$purchases_defaultsBc8Release(ExecutorService executorService) {
            this.service = executorService;
        }

        public final /* synthetic */ void setShowInAppMessagesAutomatically$purchases_defaultsBc8Release(boolean z2) {
            this.showInAppMessagesAutomatically = z2;
        }

        public final /* synthetic */ void setStore$purchases_defaultsBc8Release(Store store) {
            Intrinsics.checkNotNullParameter(store, "<set-?>");
            this.store = store;
        }

        public final /* synthetic */ void setVerificationMode$purchases_defaultsBc8Release(EntitlementVerificationMode entitlementVerificationMode) {
            Intrinsics.checkNotNullParameter(entitlementVerificationMode, "<set-?>");
            this.verificationMode = entitlementVerificationMode;
        }

        public final Builder showInAppMessagesAutomatically(boolean z2) {
            this.showInAppMessagesAutomatically = z2;
            return this;
        }

        public final Builder store(Store store) {
            Intrinsics.checkNotNullParameter(store, "store");
            this.store = store;
            return this;
        }

        public static /* synthetic */ void getGalaxyBillingMode$purchases_defaultsBc8Release$annotations() {
        }
    }

    public static /* synthetic */ void getGalaxyBillingMode$annotations() {
    }

    @Deprecated
    public static /* synthetic */ void getObserverMode$annotations() {
    }
}
