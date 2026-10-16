package cz.mobilesoft.coreblock.scene.more.settings.developer;

import androidx.datastore.preferences.core.SfRj.rnFwbPAQmQTnL;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DeveloperSettingsItemId {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DeveloperSettingsItemId[] $VALUES;
    public static final Companion Companion;
    private static final Map<String, DeveloperSettingsItemId> map;
    private final String id;
    public static final DeveloperSettingsItemId StreakToday = new DeveloperSettingsItemId("StreakToday", 0, "streak_today");
    public static final DeveloperSettingsItemId StreakPausesToday = new DeveloperSettingsItemId("StreakPausesToday", 1, "streak_pauses_today");
    public static final DeveloperSettingsItemId StreakStoredDays = new DeveloperSettingsItemId("StreakStoredDays", 2, "streak_stored_days");
    public static final DeveloperSettingsItemId StreakSeed = new DeveloperSettingsItemId("StreakSeed", 3, "streak_seed");
    public static final DeveloperSettingsItemId StreakSendAchievement = new DeveloperSettingsItemId("StreakSendAchievement", 4, "streak_send_achievement");
    public static final DeveloperSettingsItemId StreakAddActivity = new DeveloperSettingsItemId("StreakAddActivity", 5, "streak_add_activity");
    public static final DeveloperSettingsItemId StreakRunCatchUp = new DeveloperSettingsItemId("StreakRunCatchUp", 6, "streak_run_catch_up");
    public static final DeveloperSettingsItemId StreakClear = new DeveloperSettingsItemId("StreakClear", 7, "streak_clear");
    public static final DeveloperSettingsItemId StreakOpenMilestone = new DeveloperSettingsItemId("StreakOpenMilestone", 8, "streak_open_milestone");
    public static final DeveloperSettingsItemId StreakOpenIntroduction = new DeveloperSettingsItemId("StreakOpenIntroduction", 9, "streak_open_introduction");
    public static final DeveloperSettingsItemId StreakShowBanner = new DeveloperSettingsItemId("StreakShowBanner", 10, "streak_show_banner");
    public static final DeveloperSettingsItemId StreakUpload = new DeveloperSettingsItemId("StreakUpload", 11, "streak_upload");
    public static final DeveloperSettingsItemId StreakSendNudge = new DeveloperSettingsItemId("StreakSendNudge", 12, "streak_send_nudge");
    public static final DeveloperSettingsItemId StreakResetPresentation = new DeveloperSettingsItemId("StreakResetPresentation", 13, "streak_reset_presentation");
    public static final DeveloperSettingsItemId StreakPresentationState = new DeveloperSettingsItemId("StreakPresentationState", 14, "streak_presentation_state");
    public static final DeveloperSettingsItemId UseProductionServer = new DeveloperSettingsItemId("UseProductionServer", 15, "use_production_server");
    public static final DeveloperSettingsItemId EnableInternet = new DeveloperSettingsItemId("EnableInternet", 16, "enable_internet");
    public static final DeveloperSettingsItemId SpeedUpTimers = new DeveloperSettingsItemId("SpeedUpTimers", 17, "speed_up_timers");
    public static final DeveloperSettingsItemId PremiumState = new DeveloperSettingsItemId("PremiumState", 18, "premium_state");
    public static final DeveloperSettingsItemId PremiumProduct = new DeveloperSettingsItemId("PremiumProduct", 19, "premium_product");
    public static final DeveloperSettingsItemId RemovePremium = new DeveloperSettingsItemId("RemovePremium", 20, "remove_premium");
    public static final DeveloperSettingsItemId ActivateCampaign = new DeveloperSettingsItemId("ActivateCampaign", 21, "activate_campaign");
    public static final DeveloperSettingsItemId OfferLifetime = new DeveloperSettingsItemId("OfferLifetime", 22, "offer_lifetime");
    public static final DeveloperSettingsItemId TrialAlwaysEligible = new DeveloperSettingsItemId("TrialAlwaysEligible", 23, "trial_always_eligible");
    public static final DeveloperSettingsItemId SimulateActiveTrial = new DeveloperSettingsItemId("SimulateActiveTrial", 24, "simulate_active_trial");
    public static final DeveloperSettingsItemId SimulateBillingError = new DeveloperSettingsItemId("SimulateBillingError", 25, "simulate_billing_error");
    public static final DeveloperSettingsItemId SubscriptionOnboardingTest = new DeveloperSettingsItemId("SubscriptionOnboardingTest", 26, "subscription_onboarding_test");
    public static final DeveloperSettingsItemId OverridePaywallSettings = new DeveloperSettingsItemId("OverridePaywallSettings", 27, "override_paywall_settings");
    public static final DeveloperSettingsItemId TestTargetingGroup = new DeveloperSettingsItemId("TestTargetingGroup", 28, "test_targeting_group");
    public static final DeveloperSettingsItemId OpenDiscountScreen = new DeveloperSettingsItemId("OpenDiscountScreen", 29, "open_discount_screen");
    public static final DeveloperSettingsItemId FcmToken = new DeveloperSettingsItemId("FcmToken", 30, "fcm_token");
    public static final DeveloperSettingsItemId RevenueCatId = new DeveloperSettingsItemId("RevenueCatId", 31, "revenuecat_id");
    public static final DeveloperSettingsItemId CustomerId = new DeveloperSettingsItemId("CustomerId", 32, "customer_id");
    public static final DeveloperSettingsItemId ShowAdsState = new DeveloperSettingsItemId("ShowAdsState", 33, "show_ads_state");
    public static final DeveloperSettingsItemId SkipDiscountTimer = new DeveloperSettingsItemId("SkipDiscountTimer", 34, "skip_discount_timer");
    public static final DeveloperSettingsItemId ShowAllDiscounts = new DeveloperSettingsItemId("ShowAllDiscounts", 35, "show_all_discounts");
    public static final DeveloperSettingsItemId ResetDiscountOffers = new DeveloperSettingsItemId("ResetDiscountOffers", 36, "reset_discount_offers");
    public static final DeveloperSettingsItemId ShowIntro = new DeveloperSettingsItemId("ShowIntro", 37, "show_intro");
    public static final DeveloperSettingsItemId WhatsNewCard = new DeveloperSettingsItemId("WhatsNewCard", 38, "whats_new_card");
    public static final DeveloperSettingsItemId ShowWhatsNewFlow = new DeveloperSettingsItemId("ShowWhatsNewFlow", 39, "show_whats_new_flow");
    public static final DeveloperSettingsItemId ShowAniaInfoDialog = new DeveloperSettingsItemId("ShowAniaInfoDialog", 40, "show_ania_info_dialog");
    public static final DeveloperSettingsItemId ShowPirateVersionSheet = new DeveloperSettingsItemId("ShowPirateVersionSheet", 41, "show_pirate_version_sheet");
    public static final DeveloperSettingsItemId UseNewPaywall = new DeveloperSettingsItemId("UseNewPaywall", 42, "use_new_paywall");
    public static final DeveloperSettingsItemId ShowAllTrendItems = new DeveloperSettingsItemId("ShowAllTrendItems", 43, "show_all_trend_items");
    public static final DeveloperSettingsItemId ShowPremiumExpiring = new DeveloperSettingsItemId("ShowPremiumExpiring", 44, "show_premium_expiring");
    public static final DeveloperSettingsItemId ShowPremiumExpiringCards = new DeveloperSettingsItemId("ShowPremiumExpiringCards", 45, "show_premium_expiring_cards");
    public static final DeveloperSettingsItemId ForceAutoTrialExpired = new DeveloperSettingsItemId("ForceAutoTrialExpired", 46, "force_auto_trial_expired");
    public static final DeveloperSettingsItemId ForceAutoTrialExpiredCard = new DeveloperSettingsItemId("ForceAutoTrialExpiredCard", 47, "force_auto_trial_expired_card");
    public static final DeveloperSettingsItemId ShortenAutoTrialWait = new DeveloperSettingsItemId("ShortenAutoTrialWait", 48, "shorten_auto_trial_wait");
    public static final DeveloperSettingsItemId UseFakeReviewManager = new DeveloperSettingsItemId("UseFakeReviewManager", 49, "use_fake_review_manager");
    public static final DeveloperSettingsItemId ForceRatingDialog = new DeveloperSettingsItemId("ForceRatingDialog", 50, "force_rating_dialog");
    public static final DeveloperSettingsItemId MockWeeklyStatsNotification = new DeveloperSettingsItemId("MockWeeklyStatsNotification", 51, "mock_weekly_stats_notification");
    public static final DeveloperSettingsItemId MockDailyInsights = new DeveloperSettingsItemId("MockDailyInsights", 52, "mock_daily_insights");
    public static final DeveloperSettingsItemId MockTrialExpiringNotification = new DeveloperSettingsItemId("MockTrialExpiringNotification", 53, "mock_trial_expiring_notification");
    public static final DeveloperSettingsItemId MockTrialConvReminderNotification = new DeveloperSettingsItemId("MockTrialConvReminderNotification", 54, "mock_trial_conv_reminder_notification");
    public static final DeveloperSettingsItemId MockTrialConvFailedNotification = new DeveloperSettingsItemId("MockTrialConvFailedNotification", 55, "mock_trial_conv_failed_notification");
    public static final DeveloperSettingsItemId MockWeeklyStatsScreen = new DeveloperSettingsItemId("MockWeeklyStatsScreen", 56, "mock_weekly_stats_screen");
    public static final DeveloperSettingsItemId MockWeeklyStatsDialog = new DeveloperSettingsItemId("MockWeeklyStatsDialog", 57, "mock_weekly_stats_dialog");
    public static final DeveloperSettingsItemId MockPremiumExpiringScreen = new DeveloperSettingsItemId("MockPremiumExpiringScreen", 58, "mock_premium_expiring_screen");
    public static final DeveloperSettingsItemId MockTrialComparisonData = new DeveloperSettingsItemId("MockTrialComparisonData", 59, "mock_trial_comparison_data");
    public static final DeveloperSettingsItemId InAppUpdatesMock = new DeveloperSettingsItemId("InAppUpdatesMock", 60, "in_app_updates_mock");
    public static final DeveloperSettingsItemId RemoteConfigMock = new DeveloperSettingsItemId("RemoteConfigMock", 61, "remote_config_mock");
    public static final DeveloperSettingsItemId ForceLoadingDelay = new DeveloperSettingsItemId("ForceLoadingDelay", 62, "force_loading_delay");
    public static final DeveloperSettingsItemId GenerateFakeInsightsData = new DeveloperSettingsItemId("GenerateFakeInsightsData", 63, "generate_fake_insights_data");
    public static final DeveloperSettingsItemId RemoteConfigValues = new DeveloperSettingsItemId("RemoteConfigValues", 64, "remote_config_values");
    public static final DeveloperSettingsItemId QuestionnaireConfig = new DeveloperSettingsItemId("QuestionnaireConfig", 65, "questionnaire_config");
    public static final DeveloperSettingsItemId TimeChangeLimit = new DeveloperSettingsItemId("TimeChangeLimit", 66, "time_change_limit");
    public static final DeveloperSettingsItemId AlwaysShowEmailConsent = new DeveloperSettingsItemId("AlwaysShowEmailConsent", 67, "always_show_email_consent");
    public static final DeveloperSettingsItemId ParseSupportJson = new DeveloperSettingsItemId("ParseSupportJson", 68, "parse_support_json");
    public static final DeveloperSettingsItemId ParseSupportJsonFile = new DeveloperSettingsItemId("ParseSupportJsonFile", 69, "parse_support_json_file");
    public static final DeveloperSettingsItemId ClearStrictMode = new DeveloperSettingsItemId("ClearStrictMode", 70, "clear_strict_mode");
    public static final DeveloperSettingsItemId ClearStrictModeOnboarding = new DeveloperSettingsItemId("ClearStrictModeOnboarding", 71, "clear_strict_mode_onboarding");
    public static final DeveloperSettingsItemId ResetQuickBlock = new DeveloperSettingsItemId("ResetQuickBlock", 72, "reset_quick_block");
    public static final DeveloperSettingsItemId ClearAdultContent = new DeveloperSettingsItemId("ClearAdultContent", 73, "clear_adult_content");
    public static final DeveloperSettingsItemId ResetStrictModeUpsell = new DeveloperSettingsItemId("ResetStrictModeUpsell", 74, "reset_strict_mode_upsell");
    public static final DeveloperSettingsItemId ResetUnlockAllAppsTimer = new DeveloperSettingsItemId("ResetUnlockAllAppsTimer", 75, "reset_unlock_all_apps_timer");
    public static final DeveloperSettingsItemId GenerateBackdoorCode = new DeveloperSettingsItemId("GenerateBackdoorCode", 76, "generate_backdoor_code");
    public static final DeveloperSettingsItemId DisableBackdoorCodeCheck = new DeveloperSettingsItemId("DisableBackdoorCodeCheck", 77, "disable_backdoor_code_check");
    public static final DeveloperSettingsItemId AlwaysValidateEmergencyString = new DeveloperSettingsItemId("AlwaysValidateEmergencyString", 78, "always_validate_emergency_string");
    public static final DeveloperSettingsItemId ListBrowsers = new DeveloperSettingsItemId("ListBrowsers", 79, "list_browsers");
    public static final DeveloperSettingsItemId ShowAdsInspector = new DeveloperSettingsItemId("ShowAdsInspector", 80, "show_ads_inspector");
    public static final DeveloperSettingsItemId ShowEventsBubble = new DeveloperSettingsItemId("ShowEventsBubble", 81, "show_events_bubble");
    public static final DeveloperSettingsItemId ShowChatbot = new DeveloperSettingsItemId("ShowChatbot", 82, "show_chatbot");
    public static final DeveloperSettingsItemId PerformFatalCrash = new DeveloperSettingsItemId("PerformFatalCrash", 83, "perform_fatal_crash");
    public static final DeveloperSettingsItemId LogLockService = new DeveloperSettingsItemId("LogLockService", 84, "log_lock_service");
    public static final DeveloperSettingsItemId PomodoroInSeconds = new DeveloperSettingsItemId("PomodoroInSeconds", 85, "pomodoro_in_seconds");
    public static final DeveloperSettingsItemId StrictModePauseInSeconds = new DeveloperSettingsItemId("StrictModePauseInSeconds", 86, "strict_mode_pause_in_seconds");
    public static final DeveloperSettingsItemId TimeNudgeShortIntervals = new DeveloperSettingsItemId("TimeNudgeShortIntervals", 87, "time_nudge_short_intervals");
    public static final DeveloperSettingsItemId TriggerTimeNudge = new DeveloperSettingsItemId("TriggerTimeNudge", 88, "trigger_time_nudge");
    public static final DeveloperSettingsItemId OpenAutoTrialFlow = new DeveloperSettingsItemId("OpenAutoTrialFlow", 89, "open_auto_trial_flow");
    public static final DeveloperSettingsItemId OpenIntroTrialPremium = new DeveloperSettingsItemId("OpenIntroTrialPremium", 90, "open_intro_trial_premium");
    public static final DeveloperSettingsItemId OpenTrialRetentionPremium = new DeveloperSettingsItemId("OpenTrialRetentionPremium", 91, "open_trial_retention_premium");
    public static final DeveloperSettingsItemId OpenGenericPremium = new DeveloperSettingsItemId("OpenGenericPremium", 92, "open_generic_premium");
    public static final DeveloperSettingsItemId OpenDiscountPremium = new DeveloperSettingsItemId("OpenDiscountPremium", 93, "open_discount_premium");
    public static final DeveloperSettingsItemId OpenDiscountPremium30 = new DeveloperSettingsItemId("OpenDiscountPremium30", 94, "open_discount_premium_30");
    public static final DeveloperSettingsItemId OpenDiscountPremium50 = new DeveloperSettingsItemId("OpenDiscountPremium50", 95, "open_discount_premium_50");
    public static final DeveloperSettingsItemId OpenExpiredSubPremium = new DeveloperSettingsItemId("OpenExpiredSubPremium", 96, "open_expired_sub_premium");
    public static final DeveloperSettingsItemId OpenProductPlanPremium = new DeveloperSettingsItemId("OpenProductPlanPremium", 97, "open_product_plan_premium");
    public static final DeveloperSettingsItemId OpenLimitScreenPremium = new DeveloperSettingsItemId("OpenLimitScreenPremium", 98, rnFwbPAQmQTnL.suLTljSECskXO);
    public static final DeveloperSettingsItemId OpenExpiredSubDiscountPremium = new DeveloperSettingsItemId("OpenExpiredSubDiscountPremium", 99, "open_expired_sub_discount_premium");
    public static final DeveloperSettingsItemId OpenIntroTrialTogglePremium = new DeveloperSettingsItemId("OpenIntroTrialTogglePremium", 100, "open_intro_trial_toggle_premium");
    public static final DeveloperSettingsItemId OpenOneTimeToSubPremium = new DeveloperSettingsItemId("OpenOneTimeToSubPremium", 101, "open_one_time_to_sub_premium");
    public static final DeveloperSettingsItemId OpenDiscountPremiumReferralSender = new DeveloperSettingsItemId("OpenDiscountPremiumReferralSender", 102, "open_discount_premium_referral_sender");
    public static final DeveloperSettingsItemId OpenDiscountPremiumReferralReceiver = new DeveloperSettingsItemId("OpenDiscountPremiumReferralReceiver", 103, "open_discount_premium_referral_receiver");
    public static final DeveloperSettingsItemId OpenCampaignPremium = new DeveloperSettingsItemId("OpenCampaignPremium", 104, "open_campaign_premium");
    public static final DeveloperSettingsItemId LaunchOnboarding = new DeveloperSettingsItemId("LaunchOnboarding", 105, "launch_onboarding");
    public static final DeveloperSettingsItemId ShowAppFeelOnboarding = new DeveloperSettingsItemId("ShowAppFeelOnboarding", 106, "show_app_feel_onboarding");
    public static final DeveloperSettingsItemId ShowTrialRemindersFlow = new DeveloperSettingsItemId("ShowTrialRemindersFlow", 107, "show_trial_reminders_flow");
    public static final DeveloperSettingsItemId ShowRatingDialogFlow = new DeveloperSettingsItemId("ShowRatingDialogFlow", 108, "show_rating_dialog_flow");
    public static final DeveloperSettingsItemId OpenAccessibilitySettings = new DeveloperSettingsItemId("OpenAccessibilitySettings", 109, "perm_accessibility_settings");
    public static final DeveloperSettingsItemId OpenOverlaySettings = new DeveloperSettingsItemId("OpenOverlaySettings", 110, "perm_overlay_settings");
    public static final DeveloperSettingsItemId OpenUsageSettings = new DeveloperSettingsItemId("OpenUsageSettings", 111, "perm_usage_settings");
    public static final DeveloperSettingsItemId OpenNotificationAccessSettings = new DeveloperSettingsItemId("OpenNotificationAccessSettings", 112, "perm_notification_access_settings");
    public static final DeveloperSettingsItemId OpenAppSettings = new DeveloperSettingsItemId("OpenAppSettings", 113, "perm_app_settings");
    public static final DeveloperSettingsItemId RemoveDeviceAdmin = new DeveloperSettingsItemId("RemoveDeviceAdmin", 114, "remove_device_admin");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DeveloperSettingsItemId a(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return (DeveloperSettingsItemId) DeveloperSettingsItemId.map.get(id);
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ DeveloperSettingsItemId[] $values() {
        return new DeveloperSettingsItemId[]{StreakToday, StreakPausesToday, StreakStoredDays, StreakSeed, StreakSendAchievement, StreakAddActivity, StreakRunCatchUp, StreakClear, StreakOpenMilestone, StreakOpenIntroduction, StreakShowBanner, StreakUpload, StreakSendNudge, StreakResetPresentation, StreakPresentationState, UseProductionServer, EnableInternet, SpeedUpTimers, PremiumState, PremiumProduct, RemovePremium, ActivateCampaign, OfferLifetime, TrialAlwaysEligible, SimulateActiveTrial, SimulateBillingError, SubscriptionOnboardingTest, OverridePaywallSettings, TestTargetingGroup, OpenDiscountScreen, FcmToken, RevenueCatId, CustomerId, ShowAdsState, SkipDiscountTimer, ShowAllDiscounts, ResetDiscountOffers, ShowIntro, WhatsNewCard, ShowWhatsNewFlow, ShowAniaInfoDialog, ShowPirateVersionSheet, UseNewPaywall, ShowAllTrendItems, ShowPremiumExpiring, ShowPremiumExpiringCards, ForceAutoTrialExpired, ForceAutoTrialExpiredCard, ShortenAutoTrialWait, UseFakeReviewManager, ForceRatingDialog, MockWeeklyStatsNotification, MockDailyInsights, MockTrialExpiringNotification, MockTrialConvReminderNotification, MockTrialConvFailedNotification, MockWeeklyStatsScreen, MockWeeklyStatsDialog, MockPremiumExpiringScreen, MockTrialComparisonData, InAppUpdatesMock, RemoteConfigMock, ForceLoadingDelay, GenerateFakeInsightsData, RemoteConfigValues, QuestionnaireConfig, TimeChangeLimit, AlwaysShowEmailConsent, ParseSupportJson, ParseSupportJsonFile, ClearStrictMode, ClearStrictModeOnboarding, ResetQuickBlock, ClearAdultContent, ResetStrictModeUpsell, ResetUnlockAllAppsTimer, GenerateBackdoorCode, DisableBackdoorCodeCheck, AlwaysValidateEmergencyString, ListBrowsers, ShowAdsInspector, ShowEventsBubble, ShowChatbot, PerformFatalCrash, LogLockService, PomodoroInSeconds, StrictModePauseInSeconds, TimeNudgeShortIntervals, TriggerTimeNudge, OpenAutoTrialFlow, OpenIntroTrialPremium, OpenTrialRetentionPremium, OpenGenericPremium, OpenDiscountPremium, OpenDiscountPremium30, OpenDiscountPremium50, OpenExpiredSubPremium, OpenProductPlanPremium, OpenLimitScreenPremium, OpenExpiredSubDiscountPremium, OpenIntroTrialTogglePremium, OpenOneTimeToSubPremium, OpenDiscountPremiumReferralSender, OpenDiscountPremiumReferralReceiver, OpenCampaignPremium, LaunchOnboarding, ShowAppFeelOnboarding, ShowTrialRemindersFlow, ShowRatingDialogFlow, OpenAccessibilitySettings, OpenOverlaySettings, OpenUsageSettings, OpenNotificationAccessSettings, OpenAppSettings, RemoveDeviceAdmin};
    }

    static {
        DeveloperSettingsItemId[] developerSettingsItemIdArr$values = $values();
        $VALUES = developerSettingsItemIdArr$values;
        $ENTRIES = EnumEntriesKt.a(developerSettingsItemIdArr$values);
        Companion = new Companion(null);
        EnumEntries<DeveloperSettingsItemId> entries = getEntries();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entries, 10)), 16));
        for (DeveloperSettingsItemId developerSettingsItemId : entries) {
            linkedHashMap.put(developerSettingsItemId.id, developerSettingsItemId);
        }
        map = linkedHashMap;
    }

    private DeveloperSettingsItemId(String str, int i3, String str2) {
        this.id = str2;
    }

    public static EnumEntries<DeveloperSettingsItemId> getEntries() {
        return $ENTRIES;
    }

    public static DeveloperSettingsItemId valueOf(String str) {
        return (DeveloperSettingsItemId) Enum.valueOf(DeveloperSettingsItemId.class, str);
    }

    public static DeveloperSettingsItemId[] values() {
        return (DeveloperSettingsItemId[]) $VALUES.clone();
    }

    public final String getId() {
        return this.id;
    }
}
