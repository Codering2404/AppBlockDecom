package com.superwall.sdk.analytics.superwall;

import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import com.facebook.internal.NativeProtocol;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
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
public final class SuperwallEvents {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SuperwallEvents[] $VALUES;
    private final String rawName;
    public static final SuperwallEvents FirstSeen = new SuperwallEvents("FirstSeen", 0, CustomerInfoResponseJsonKeys.FIRST_SEEN);
    public static final SuperwallEvents AppOpen = new SuperwallEvents("AppOpen", 1, "app_open");
    public static final SuperwallEvents AppLaunch = new SuperwallEvents("AppLaunch", 2, "app_launch");
    public static final SuperwallEvents AppInstall = new SuperwallEvents("AppInstall", 3, "app_install");
    public static final SuperwallEvents SessionStart = new SuperwallEvents("SessionStart", 4, "session_start");
    public static final SuperwallEvents AppClose = new SuperwallEvents("AppClose", 5, "app_close");
    public static final SuperwallEvents DeepLink = new SuperwallEvents("DeepLink", 6, "deepLink_open");
    public static final SuperwallEvents TriggerFire = new SuperwallEvents("TriggerFire", 7, "trigger_fire");
    public static final SuperwallEvents PaywallOpen = new SuperwallEvents("PaywallOpen", 8, "paywall_open");
    public static final SuperwallEvents PaywallClose = new SuperwallEvents("PaywallClose", 9, "paywall_close");
    public static final SuperwallEvents PaywallDecline = new SuperwallEvents("PaywallDecline", 10, "paywall_decline");
    public static final SuperwallEvents TransactionStart = new SuperwallEvents("TransactionStart", 11, "transaction_start");
    public static final SuperwallEvents TransactionFail = new SuperwallEvents("TransactionFail", 12, "transaction_fail");
    public static final SuperwallEvents TransactionAbandon = new SuperwallEvents("TransactionAbandon", 13, "transaction_abandon");
    public static final SuperwallEvents TransactionComplete = new SuperwallEvents("TransactionComplete", 14, "transaction_complete");
    public static final SuperwallEvents TransactionRestore = new SuperwallEvents("TransactionRestore", 15, "transaction_restore");
    public static final SuperwallEvents TransactionTimeout = new SuperwallEvents("TransactionTimeout", 16, "transaction_timeout");
    public static final SuperwallEvents SubscriptionStart = new SuperwallEvents("SubscriptionStart", 17, "subscription_start");
    public static final SuperwallEvents SurveyResponse = new SuperwallEvents("SurveyResponse", 18, "survey_response");
    public static final SuperwallEvents SurveyClose = new SuperwallEvents("SurveyClose", 19, "survey_close");
    public static final SuperwallEvents SubscriptionStatusDidChange = new SuperwallEvents("SubscriptionStatusDidChange", 20, "subscriptionStatus_didChange");
    public static final SuperwallEvents FreeTrialStart = new SuperwallEvents("FreeTrialStart", 21, "freeTrial_start");
    public static final SuperwallEvents UserAttributes = new SuperwallEvents("UserAttributes", 22, "user_attributes");
    public static final SuperwallEvents NonRecurringProductPurchase = new SuperwallEvents("NonRecurringProductPurchase", 23, "nonRecurringProduct_purchase");
    public static final SuperwallEvents PaywallResponseLoadStart = new SuperwallEvents("PaywallResponseLoadStart", 24, "paywallResponseLoad_start");
    public static final SuperwallEvents PaywallResponseLoadNotFound = new SuperwallEvents(bfIdKSjLOVjG.jUxOWB, 25, "paywallResponseLoad_notFound");
    public static final SuperwallEvents PaywallResponseLoadFail = new SuperwallEvents("PaywallResponseLoadFail", 26, "paywallResponseLoad_fail");
    public static final SuperwallEvents PaywallResponseLoadComplete = new SuperwallEvents("PaywallResponseLoadComplete", 27, "paywallResponseLoad_complete");
    public static final SuperwallEvents PaywallWebviewLoadStart = new SuperwallEvents("PaywallWebviewLoadStart", 28, "paywallWebviewLoad_start");
    public static final SuperwallEvents PaywallWebviewLoadFail = new SuperwallEvents("PaywallWebviewLoadFail", 29, "paywallWebviewLoad_fail");
    public static final SuperwallEvents PaywallWebviewLoadComplete = new SuperwallEvents("PaywallWebviewLoadComplete", 30, "paywallWebviewLoad_complete");

    @Deprecated
    public static final SuperwallEvents PaywallWebviewLoadTimeout = new SuperwallEvents("PaywallWebviewLoadTimeout", 31, "paywallWebviewLoad_timeout");
    public static final SuperwallEvents PaywallWebviewLoadFallback = new SuperwallEvents("PaywallWebviewLoadFallback", 32, "paywallWebviewLoad_fallback");
    public static final SuperwallEvents PaywallResourceLoadFail = new SuperwallEvents("PaywallResourceLoadFail", 33, "paywallResourceLoad_fail");
    public static final SuperwallEvents PaywallProductsLoadStart = new SuperwallEvents("PaywallProductsLoadStart", 34, "paywallProductsLoad_start");
    public static final SuperwallEvents PaywallProductsLoadFail = new SuperwallEvents("PaywallProductsLoadFail", 35, "paywallProductsLoad_fail");
    public static final SuperwallEvents PaywallProductsLoadComplete = new SuperwallEvents("PaywallProductsLoadComplete", 36, "paywallProductsLoad_complete");
    public static final SuperwallEvents PaywallPresentationRequest = new SuperwallEvents("PaywallPresentationRequest", 37, "paywallPresentationRequest");
    public static final SuperwallEvents RestoreStart = new SuperwallEvents("RestoreStart", 38, "restore_start");
    public static final SuperwallEvents RestoreFail = new SuperwallEvents("RestoreFail", 39, "restore_fail");
    public static final SuperwallEvents RestoreComplete = new SuperwallEvents("RestoreComplete", 40, "restore_complete");
    public static final SuperwallEvents CustomPlacement = new SuperwallEvents("CustomPlacement", 41, "custom_placement");
    public static final SuperwallEvents ShimmerViewStart = new SuperwallEvents("ShimmerViewStart", 42, "shimmerView_start");
    public static final SuperwallEvents ShimmerViewComplete = new SuperwallEvents("ShimmerViewComplete", 43, "shimmerView_complete");
    public static final SuperwallEvents ConfigAttributes = new SuperwallEvents("ConfigAttributes", 44, "config_attributes");
    public static final SuperwallEvents ConfirmAllAssignments = new SuperwallEvents("ConfirmAllAssignments", 45, "confirm_all_assignments");
    public static final SuperwallEvents ConfigFail = new SuperwallEvents("ConfigFail", 46, "config_fail");
    public static final SuperwallEvents RedemptionStart = new SuperwallEvents("RedemptionStart", 47, "redemption_start");
    public static final SuperwallEvents RedemptionComplete = new SuperwallEvents("RedemptionComplete", 48, "redemption_complete");
    public static final SuperwallEvents RedemptionFail = new SuperwallEvents("RedemptionFail", 49, "redemption_fail");
    public static final SuperwallEvents ReviewRequested = new SuperwallEvents("ReviewRequested", 50, "review_requested");
    public static final SuperwallEvents ReviewGranted = new SuperwallEvents("ReviewGranted", 51, "review_granted");
    public static final SuperwallEvents ReviewDenied = new SuperwallEvents("ReviewDenied", 52, "review_denied");
    public static final SuperwallEvents IntegrationAttributes = new SuperwallEvents("IntegrationAttributes", 53, "integration_attributes");
    public static final SuperwallEvents CustomerInfoDidChange = new SuperwallEvents("CustomerInfoDidChange", 54, "customerInfo_didChange");
    public static final SuperwallEvents PermissionRequested = new SuperwallEvents("PermissionRequested", 55, "permission_requested");
    public static final SuperwallEvents PermissionGranted = new SuperwallEvents("PermissionGranted", 56, "permission_granted");
    public static final SuperwallEvents PermissionDenied = new SuperwallEvents(NativeProtocol.ERROR_PERMISSION_DENIED, 57, "permission_denied");
    public static final SuperwallEvents PaywallPreloadStart = new SuperwallEvents("PaywallPreloadStart", 58, "paywallPreload_start");
    public static final SuperwallEvents PaywallPreloadComplete = new SuperwallEvents("PaywallPreloadComplete", 59, "paywallPreload_complete");
    public static final SuperwallEvents PaywallPageView = new SuperwallEvents("PaywallPageView", 60, "paywall_page_view");
    public static final SuperwallEvents TestModeModalOpen = new SuperwallEvents("TestModeModalOpen", 61, "testModeModal_open");
    public static final SuperwallEvents TestModeModalClose = new SuperwallEvents("TestModeModalClose", 62, "testModeModal_close");

    private static final /* synthetic */ SuperwallEvents[] $values() {
        return new SuperwallEvents[]{FirstSeen, AppOpen, AppLaunch, AppInstall, SessionStart, AppClose, DeepLink, TriggerFire, PaywallOpen, PaywallClose, PaywallDecline, TransactionStart, TransactionFail, TransactionAbandon, TransactionComplete, TransactionRestore, TransactionTimeout, SubscriptionStart, SurveyResponse, SurveyClose, SubscriptionStatusDidChange, FreeTrialStart, UserAttributes, NonRecurringProductPurchase, PaywallResponseLoadStart, PaywallResponseLoadNotFound, PaywallResponseLoadFail, PaywallResponseLoadComplete, PaywallWebviewLoadStart, PaywallWebviewLoadFail, PaywallWebviewLoadComplete, PaywallWebviewLoadTimeout, PaywallWebviewLoadFallback, PaywallResourceLoadFail, PaywallProductsLoadStart, PaywallProductsLoadFail, PaywallProductsLoadComplete, PaywallPresentationRequest, RestoreStart, RestoreFail, RestoreComplete, CustomPlacement, ShimmerViewStart, ShimmerViewComplete, ConfigAttributes, ConfirmAllAssignments, ConfigFail, RedemptionStart, RedemptionComplete, RedemptionFail, ReviewRequested, ReviewGranted, ReviewDenied, IntegrationAttributes, CustomerInfoDidChange, PermissionRequested, PermissionGranted, PermissionDenied, PaywallPreloadStart, PaywallPreloadComplete, PaywallPageView, TestModeModalOpen, TestModeModalClose};
    }

    private SuperwallEvents(String str, int i3, String str2) {
        this.rawName = str2;
    }

    public static EnumEntries<SuperwallEvents> getEntries() {
        return $ENTRIES;
    }

    public static SuperwallEvents valueOf(String str) {
        return (SuperwallEvents) Enum.valueOf(SuperwallEvents.class, str);
    }

    public static SuperwallEvents[] values() {
        return (SuperwallEvents[]) $VALUES.clone();
    }

    public final String getRawName() {
        return this.rawName;
    }

    static {
        SuperwallEvents[] superwallEventsArr$values = $values();
        $VALUES = superwallEventsArr$values;
        $ENTRIES = EnumEntriesKt.a(superwallEventsArr$values);
    }
}
