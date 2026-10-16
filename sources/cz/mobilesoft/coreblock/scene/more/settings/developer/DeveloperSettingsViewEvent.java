package cz.mobilesoft.coreblock.scene.more.settings.developer;

import android.net.Uri;
import cz.mobilesoft.coreblock.activity.rating.RatingDialogType;
import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.enums.PremiumDevState;
import cz.mobilesoft.coreblock.enums.RevenueCatOffering;
import cz.mobilesoft.coreblock.scene.onboarding.OnboardingFlowVariant;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevPrefState;
import cz.mobilesoft.coreblock.util.updates.InAppUpdatesMockSettingsDTO;
import java.util.List;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class DeveloperSettingsViewEvent implements ViewEvent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnActivateCampaignClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnActivateCampaignClicked f108354a = new OnActivateCampaignClicked();

        private OnActivateCampaignClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAlwaysShowEmailConsentToggled extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnAlwaysShowEmailConsentToggled f108355a = new OnAlwaysShowEmailConsentToggled();

        private OnAlwaysShowEmailConsentToggled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnAlwaysValidateEmergencyStringToggled extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnAlwaysValidateEmergencyStringToggled f108356a = new OnAlwaysValidateEmergencyStringToggled();

        private OnAlwaysValidateEmergencyStringToggled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCampaignIdEntered extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f108357a;

        public OnCampaignIdEntered(long j3) {
            super(null);
            this.f108357a = j3;
        }

        public final long a() {
            return this.f108357a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnCampaignIdEntered) && this.f108357a == ((OnCampaignIdEntered) obj).f108357a;
        }

        public int hashCode() {
            return Long.hashCode(this.f108357a);
        }

        public String toString() {
            return "OnCampaignIdEntered(campaignId=" + this.f108357a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCategoryExpandToggled extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f108358a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnCategoryExpandToggled(String categoryId) {
            super(null);
            Intrinsics.checkNotNullParameter(categoryId, "categoryId");
            this.f108358a = categoryId;
        }

        public final String a() {
            return this.f108358a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnCategoryExpandToggled) && Intrinsics.areEqual(this.f108358a, ((OnCategoryExpandToggled) obj).f108358a);
        }

        public int hashCode() {
            return this.f108358a.hashCode();
        }

        public String toString() {
            return "OnCategoryExpandToggled(categoryId=" + this.f108358a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnClearAdultContentClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnClearAdultContentClicked f108359a = new OnClearAdultContentClicked();

        private OnClearAdultContentClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnClearStrictModeClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnClearStrictModeClicked f108360a = new OnClearStrictModeClicked();

        private OnClearStrictModeClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnClearStrictModeOnboardingClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnClearStrictModeOnboardingClicked f108361a = new OnClearStrictModeOnboardingClicked();

        private OnClearStrictModeOnboardingClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCopyCustomerIdClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnCopyCustomerIdClicked f108362a = new OnCopyCustomerIdClicked();

        private OnCopyCustomerIdClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCopyFCMTokenClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnCopyFCMTokenClicked f108363a = new OnCopyFCMTokenClicked();

        private OnCopyFCMTokenClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnCopyRevenueCatIdClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnCopyRevenueCatIdClicked f108364a = new OnCopyRevenueCatIdClicked();

        private OnCopyRevenueCatIdClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnDisableBackdoorCodeCheckToggled extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnDisableBackdoorCodeCheckToggled f108365a = new OnDisableBackdoorCodeCheckToggled();

        private OnDisableBackdoorCodeCheckToggled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnDismissDialog extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnDismissDialog f108366a = new OnDismissDialog();

        private OnDismissDialog() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnFilePicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f108367a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnFilePicked(Uri uri) {
            super(null);
            Intrinsics.checkNotNullParameter(uri, "uri");
            this.f108367a = uri;
        }

        public final Uri a() {
            return this.f108367a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnFilePicked) && Intrinsics.areEqual(this.f108367a, ((OnFilePicked) obj).f108367a);
        }

        public int hashCode() {
            return this.f108367a.hashCode();
        }

        public String toString() {
            return "OnFilePicked(uri=" + this.f108367a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnForceAutoTrialExpiredCardToggled extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnForceAutoTrialExpiredCardToggled f108368a = new OnForceAutoTrialExpiredCardToggled();

        private OnForceAutoTrialExpiredCardToggled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnForceAutoTrialExpiredToggled extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnForceAutoTrialExpiredToggled f108369a = new OnForceAutoTrialExpiredToggled();

        private OnForceAutoTrialExpiredToggled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnForceLoadingEnabledToggled extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnForceLoadingEnabledToggled f108370a = new OnForceLoadingEnabledToggled();

        private OnForceLoadingEnabledToggled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnForceRatingDialogClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnForceRatingDialogClicked f108371a = new OnForceRatingDialogClicked();

        private OnForceRatingDialogClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnForceRatingDialogTypeSelected extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final RatingDialogType f108372a;

        public OnForceRatingDialogTypeSelected(RatingDialogType ratingDialogType) {
            super(null);
            this.f108372a = ratingDialogType;
        }

        public final RatingDialogType a() {
            return this.f108372a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnForceRatingDialogTypeSelected) && this.f108372a == ((OnForceRatingDialogTypeSelected) obj).f108372a;
        }

        public int hashCode() {
            RatingDialogType ratingDialogType = this.f108372a;
            if (ratingDialogType == null) {
                return 0;
            }
            return ratingDialogType.hashCode();
        }

        public String toString() {
            return "OnForceRatingDialogTypeSelected(type=" + this.f108372a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnGenerateBackdoorCodeClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnGenerateBackdoorCodeClicked f108373a = new OnGenerateBackdoorCodeClicked();

        private OnGenerateBackdoorCodeClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnGenerateFakeInsightsDataClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnGenerateFakeInsightsDataClicked f108374a = new OnGenerateFakeInsightsDataClicked();

        private OnGenerateFakeInsightsDataClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnInternetEnabledToggled extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnInternetEnabledToggled f108375a = new OnInternetEnabledToggled();

        private OnInternetEnabledToggled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnLaunchOnboardingClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnLaunchOnboardingClicked f108376a = new OnLaunchOnboardingClicked();

        private OnLaunchOnboardingClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnListAllBrowsersClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnListAllBrowsersClicked f108377a = new OnListAllBrowsersClicked();

        private OnListAllBrowsersClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnLogLockServiceToggled extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnLogLockServiceToggled f108378a = new OnLogLockServiceToggled();

        private OnLogLockServiceToggled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMockDailyInsightsMotivationClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnMockDailyInsightsMotivationClicked f108379a = new OnMockDailyInsightsMotivationClicked();

        private OnMockDailyInsightsMotivationClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMockInAppUpdatesClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnMockInAppUpdatesClicked f108380a = new OnMockInAppUpdatesClicked();

        private OnMockInAppUpdatesClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMockInAppUpdatesSaved extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f108381b = InAppUpdatesMockSettingsDTO.$stable;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InAppUpdatesMockSettingsDTO f108382a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnMockInAppUpdatesSaved(InAppUpdatesMockSettingsDTO settings) {
            super(null);
            Intrinsics.checkNotNullParameter(settings, "settings");
            this.f108382a = settings;
        }

        public final InAppUpdatesMockSettingsDTO a() {
            return this.f108382a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnMockInAppUpdatesSaved) && Intrinsics.areEqual(this.f108382a, ((OnMockInAppUpdatesSaved) obj).f108382a);
        }

        public int hashCode() {
            return this.f108382a.hashCode();
        }

        public String toString() {
            return "OnMockInAppUpdatesSaved(settings=" + this.f108382a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMockPremiumExpiringScreenClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnMockPremiumExpiringScreenClicked f108383a = new OnMockPremiumExpiringScreenClicked();

        private OnMockPremiumExpiringScreenClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMockRemoteConfigClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnMockRemoteConfigClicked f108384a = new OnMockRemoteConfigClicked();

        private OnMockRemoteConfigClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMockRemoteConfigSaved extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f108385a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnMockRemoteConfigSaved(String config) {
            super(null);
            Intrinsics.checkNotNullParameter(config, "config");
            this.f108385a = config;
        }

        public final String a() {
            return this.f108385a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnMockRemoteConfigSaved) && Intrinsics.areEqual(this.f108385a, ((OnMockRemoteConfigSaved) obj).f108385a);
        }

        public int hashCode() {
            return this.f108385a.hashCode();
        }

        public String toString() {
            return "OnMockRemoteConfigSaved(config=" + this.f108385a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMockTrialComparisonDataToggled extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnMockTrialComparisonDataToggled f108386a = new OnMockTrialComparisonDataToggled();

        private OnMockTrialComparisonDataToggled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMockTrialConvFailedNotificationClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnMockTrialConvFailedNotificationClicked f108387a = new OnMockTrialConvFailedNotificationClicked();

        private OnMockTrialConvFailedNotificationClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMockTrialConvReminderNotificationClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnMockTrialConvReminderNotificationClicked f108388a = new OnMockTrialConvReminderNotificationClicked();

        private OnMockTrialConvReminderNotificationClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMockTrialExpiringNotificationClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnMockTrialExpiringNotificationClicked f108389a = new OnMockTrialExpiringNotificationClicked();

        private OnMockTrialExpiringNotificationClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMockWeeklyStatsDialogClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnMockWeeklyStatsDialogClicked f108390a = new OnMockWeeklyStatsDialogClicked();

        private OnMockWeeklyStatsDialogClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMockWeeklyStatsNotificationClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnMockWeeklyStatsNotificationClicked f108391a = new OnMockWeeklyStatsNotificationClicked();

        private OnMockWeeklyStatsNotificationClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnMockWeeklyStatsScreenClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnMockWeeklyStatsScreenClicked f108392a = new OnMockWeeklyStatsScreenClicked();

        private OnMockWeeklyStatsScreenClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOfferLifetimeToggled extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOfferLifetimeToggled f108393a = new OnOfferLifetimeToggled();

        private OnOfferLifetimeToggled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOnboardingFlowVariantSelected extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final OnboardingFlowVariant f108394a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnOnboardingFlowVariantSelected(OnboardingFlowVariant variant) {
            super(null);
            Intrinsics.checkNotNullParameter(variant, "variant");
            this.f108394a = variant;
        }

        public final OnboardingFlowVariant a() {
            return this.f108394a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnOnboardingFlowVariantSelected) && this.f108394a == ((OnOnboardingFlowVariantSelected) obj).f108394a;
        }

        public int hashCode() {
            return this.f108394a.hashCode();
        }

        public String toString() {
            return "OnOnboardingFlowVariantSelected(variant=" + this.f108394a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOpenAccessibilitySettings extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOpenAccessibilitySettings f108395a = new OnOpenAccessibilitySettings();

        private OnOpenAccessibilitySettings() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOpenAppSettings extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOpenAppSettings f108396a = new OnOpenAppSettings();

        private OnOpenAppSettings() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOpenAutoTrialFlowClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOpenAutoTrialFlowClicked f108397a = new OnOpenAutoTrialFlowClicked();

        private OnOpenAutoTrialFlowClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOpenCampaignPremiumClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOpenCampaignPremiumClicked f108398a = new OnOpenCampaignPremiumClicked();

        private OnOpenCampaignPremiumClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOpenDiscountPremium30Clicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOpenDiscountPremium30Clicked f108399a = new OnOpenDiscountPremium30Clicked();

        private OnOpenDiscountPremium30Clicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOpenDiscountPremium50Clicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOpenDiscountPremium50Clicked f108400a = new OnOpenDiscountPremium50Clicked();

        private OnOpenDiscountPremium50Clicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOpenDiscountPremiumClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOpenDiscountPremiumClicked f108401a = new OnOpenDiscountPremiumClicked();

        private OnOpenDiscountPremiumClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOpenDiscountPremiumReferralReceiverClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOpenDiscountPremiumReferralReceiverClicked f108402a = new OnOpenDiscountPremiumReferralReceiverClicked();

        private OnOpenDiscountPremiumReferralReceiverClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOpenDiscountPremiumReferralSenderClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOpenDiscountPremiumReferralSenderClicked f108403a = new OnOpenDiscountPremiumReferralSenderClicked();

        private OnOpenDiscountPremiumReferralSenderClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOpenDiscountScreenClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOpenDiscountScreenClicked f108404a = new OnOpenDiscountScreenClicked();

        private OnOpenDiscountScreenClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnOpenDiscountScreenClicked);
        }

        public int hashCode() {
            return 983786542;
        }

        public String toString() {
            return "OnOpenDiscountScreenClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOpenExpiredSubDiscountPremiumClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOpenExpiredSubDiscountPremiumClicked f108405a = new OnOpenExpiredSubDiscountPremiumClicked();

        private OnOpenExpiredSubDiscountPremiumClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOpenExpiredSubPremiumClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOpenExpiredSubPremiumClicked f108406a = new OnOpenExpiredSubPremiumClicked();

        private OnOpenExpiredSubPremiumClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOpenGenericPremiumClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOpenGenericPremiumClicked f108407a = new OnOpenGenericPremiumClicked();

        private OnOpenGenericPremiumClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOpenIntroTrialPremiumClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOpenIntroTrialPremiumClicked f108408a = new OnOpenIntroTrialPremiumClicked();

        private OnOpenIntroTrialPremiumClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOpenIntroTrialTogglePremiumClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOpenIntroTrialTogglePremiumClicked f108409a = new OnOpenIntroTrialTogglePremiumClicked();

        private OnOpenIntroTrialTogglePremiumClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOpenLimitScreenPremiumClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOpenLimitScreenPremiumClicked f108410a = new OnOpenLimitScreenPremiumClicked();

        private OnOpenLimitScreenPremiumClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOpenNotificationAccessSettings extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOpenNotificationAccessSettings f108411a = new OnOpenNotificationAccessSettings();

        private OnOpenNotificationAccessSettings() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOpenOneTimeToSubPremiumClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOpenOneTimeToSubPremiumClicked f108412a = new OnOpenOneTimeToSubPremiumClicked();

        private OnOpenOneTimeToSubPremiumClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOpenOverlaySettings extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOpenOverlaySettings f108413a = new OnOpenOverlaySettings();

        private OnOpenOverlaySettings() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOpenProductPlanPremiumClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOpenProductPlanPremiumClicked f108414a = new OnOpenProductPlanPremiumClicked();

        private OnOpenProductPlanPremiumClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOpenTrialRetentionPremiumClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOpenTrialRetentionPremiumClicked f108415a = new OnOpenTrialRetentionPremiumClicked();

        private OnOpenTrialRetentionPremiumClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOpenUsageSettings extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOpenUsageSettings f108416a = new OnOpenUsageSettings();

        private OnOpenUsageSettings() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOverridePaywallSettingsClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnOverridePaywallSettingsClicked f108417a = new OnOverridePaywallSettingsClicked();

        private OnOverridePaywallSettingsClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnOverridePaywallSettingsSelected extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DevPrefState f108418a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnOverridePaywallSettingsSelected(DevPrefState state) {
            super(null);
            Intrinsics.checkNotNullParameter(state, "state");
            this.f108418a = state;
        }

        public final DevPrefState a() {
            return this.f108418a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnOverridePaywallSettingsSelected) && this.f108418a == ((OnOverridePaywallSettingsSelected) obj).f108418a;
        }

        public int hashCode() {
            return this.f108418a.hashCode();
        }

        public String toString() {
            return "OnOverridePaywallSettingsSelected(state=" + this.f108418a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnParseSupportJsonClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnParseSupportJsonClicked f108419a = new OnParseSupportJsonClicked();

        private OnParseSupportJsonClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnParseSupportJsonFileClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnParseSupportJsonFileClicked f108420a = new OnParseSupportJsonFileClicked();

        private OnParseSupportJsonFileClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnParseSupportJsonSaved extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f108421a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnParseSupportJsonSaved(String json) {
            super(null);
            Intrinsics.checkNotNullParameter(json, "json");
            this.f108421a = json;
        }

        public final String a() {
            return this.f108421a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnParseSupportJsonSaved) && Intrinsics.areEqual(this.f108421a, ((OnParseSupportJsonSaved) obj).f108421a);
        }

        public int hashCode() {
            return this.f108421a.hashCode();
        }

        public String toString() {
            return "OnParseSupportJsonSaved(json=" + this.f108421a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPerformFatalCrashClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnPerformFatalCrashClicked f108422a = new OnPerformFatalCrashClicked();

        private OnPerformFatalCrashClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPomodoroInSecondsToggled extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnPomodoroInSecondsToggled f108423a = new OnPomodoroInSecondsToggled();

        private OnPomodoroInSecondsToggled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPremiumProductClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnPremiumProductClicked f108424a = new OnPremiumProductClicked();

        private OnPremiumProductClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPremiumProductSelected extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final RevenueCatOffering f108425a;

        public OnPremiumProductSelected(RevenueCatOffering revenueCatOffering) {
            super(null);
            this.f108425a = revenueCatOffering;
        }

        public final RevenueCatOffering a() {
            return this.f108425a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnPremiumProductSelected) && this.f108425a == ((OnPremiumProductSelected) obj).f108425a;
        }

        public int hashCode() {
            RevenueCatOffering revenueCatOffering = this.f108425a;
            if (revenueCatOffering == null) {
                return 0;
            }
            return revenueCatOffering.hashCode();
        }

        public String toString() {
            return "OnPremiumProductSelected(offering=" + this.f108425a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPremiumStateClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnPremiumStateClicked f108426a = new OnPremiumStateClicked();

        private OnPremiumStateClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnPremiumStateSelected extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PremiumDevState f108427a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnPremiumStateSelected(PremiumDevState state) {
            super(null);
            Intrinsics.checkNotNullParameter(state, "state");
            this.f108427a = state;
        }

        public final PremiumDevState a() {
            return this.f108427a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnPremiumStateSelected) && this.f108427a == ((OnPremiumStateSelected) obj).f108427a;
        }

        public int hashCode() {
            return this.f108427a.hashCode();
        }

        public String toString() {
            return "OnPremiumStateSelected(state=" + this.f108427a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnQuestionnaireConfigClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnQuestionnaireConfigClicked f108428a = new OnQuestionnaireConfigClicked();

        private OnQuestionnaireConfigClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnQuestionnaireConfigSaved extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f108429a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnQuestionnaireConfigSaved(String json) {
            super(null);
            Intrinsics.checkNotNullParameter(json, "json");
            this.f108429a = json;
        }

        public final String a() {
            return this.f108429a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnQuestionnaireConfigSaved) && Intrinsics.areEqual(this.f108429a, ((OnQuestionnaireConfigSaved) obj).f108429a);
        }

        public int hashCode() {
            return this.f108429a.hashCode();
        }

        public String toString() {
            return "OnQuestionnaireConfigSaved(json=" + this.f108429a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnRemoteConfigValuesClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnRemoteConfigValuesClicked f108430a = new OnRemoteConfigValuesClicked();

        private OnRemoteConfigValuesClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnRemoveDeviceAdmin extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnRemoveDeviceAdmin f108431a = new OnRemoveDeviceAdmin();

        private OnRemoveDeviceAdmin() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnRemovePremiumClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnRemovePremiumClicked f108432a = new OnRemovePremiumClicked();

        private OnRemovePremiumClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnResetDiscountOffersClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnResetDiscountOffersClicked f108433a = new OnResetDiscountOffersClicked();

        private OnResetDiscountOffersClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnResetQuickBlockClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnResetQuickBlockClicked f108434a = new OnResetQuickBlockClicked();

        private OnResetQuickBlockClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnResetStrictModeUpsellClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnResetStrictModeUpsellClicked f108435a = new OnResetStrictModeUpsellClicked();

        private OnResetStrictModeUpsellClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnResetUnlockAllAppsTimerClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnResetUnlockAllAppsTimerClicked f108436a = new OnResetUnlockAllAppsTimerClicked();

        private OnResetUnlockAllAppsTimerClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSearchQueryChanged extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f108437a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSearchQueryChanged(String query) {
            super(null);
            Intrinsics.checkNotNullParameter(query, "query");
            this.f108437a = query;
        }

        public final String a() {
            return this.f108437a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnSearchQueryChanged) && Intrinsics.areEqual(this.f108437a, ((OnSearchQueryChanged) obj).f108437a);
        }

        public int hashCode() {
            return this.f108437a.hashCode();
        }

        public String toString() {
            return "OnSearchQueryChanged(query=" + this.f108437a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShortenAutoTrialWaitToggled extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShortenAutoTrialWaitToggled f108438a = new OnShortenAutoTrialWaitToggled();

        private OnShortenAutoTrialWaitToggled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowAdsClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowAdsClicked f108439a = new OnShowAdsClicked();

        private OnShowAdsClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowAdsInspectorClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowAdsInspectorClicked f108440a = new OnShowAdsInspectorClicked();

        private OnShowAdsInspectorClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowAdsStateSelected extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DevPrefState f108441a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnShowAdsStateSelected(DevPrefState state) {
            super(null);
            Intrinsics.checkNotNullParameter(state, "state");
            this.f108441a = state;
        }

        public final DevPrefState a() {
            return this.f108441a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnShowAdsStateSelected) && this.f108441a == ((OnShowAdsStateSelected) obj).f108441a;
        }

        public int hashCode() {
            return this.f108441a.hashCode();
        }

        public String toString() {
            return "OnShowAdsStateSelected(state=" + this.f108441a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowAllDiscountsClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowAllDiscountsClicked f108442a = new OnShowAllDiscountsClicked();

        private OnShowAllDiscountsClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowAllDiscountsStateSelected extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DevPrefState f108443a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnShowAllDiscountsStateSelected(DevPrefState state) {
            super(null);
            Intrinsics.checkNotNullParameter(state, "state");
            this.f108443a = state;
        }

        public final DevPrefState a() {
            return this.f108443a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnShowAllDiscountsStateSelected) && this.f108443a == ((OnShowAllDiscountsStateSelected) obj).f108443a;
        }

        public int hashCode() {
            return this.f108443a.hashCode();
        }

        public String toString() {
            return "OnShowAllDiscountsStateSelected(state=" + this.f108443a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowAllTrendItemsToggled extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowAllTrendItemsToggled f108444a = new OnShowAllTrendItemsToggled();

        private OnShowAllTrendItemsToggled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowAniaInfoDialogClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowAniaInfoDialogClicked f108445a = new OnShowAniaInfoDialogClicked();

        private OnShowAniaInfoDialogClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowAniaInfoDialogStateSelected extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DevPrefState f108446a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnShowAniaInfoDialogStateSelected(DevPrefState state) {
            super(null);
            Intrinsics.checkNotNullParameter(state, "state");
            this.f108446a = state;
        }

        public final DevPrefState a() {
            return this.f108446a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnShowAniaInfoDialogStateSelected) && this.f108446a == ((OnShowAniaInfoDialogStateSelected) obj).f108446a;
        }

        public int hashCode() {
            return this.f108446a.hashCode();
        }

        public String toString() {
            return "OnShowAniaInfoDialogStateSelected(state=" + this.f108446a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowAppFeelOnboardingClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowAppFeelOnboardingClicked f108447a = new OnShowAppFeelOnboardingClicked();

        private OnShowAppFeelOnboardingClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowChatBotClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowChatBotClicked f108448a = new OnShowChatBotClicked();

        private OnShowChatBotClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowEventsBubbleClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowEventsBubbleClicked f108449a = new OnShowEventsBubbleClicked();

        private OnShowEventsBubbleClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowIntroClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowIntroClicked f108450a = new OnShowIntroClicked();

        private OnShowIntroClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowIntroStateSelected extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DevPrefState f108451a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnShowIntroStateSelected(DevPrefState state) {
            super(null);
            Intrinsics.checkNotNullParameter(state, "state");
            this.f108451a = state;
        }

        public final DevPrefState a() {
            return this.f108451a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnShowIntroStateSelected) && this.f108451a == ((OnShowIntroStateSelected) obj).f108451a;
        }

        public int hashCode() {
            return this.f108451a.hashCode();
        }

        public String toString() {
            return "OnShowIntroStateSelected(state=" + this.f108451a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowPirateVersionSheetToggled extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowPirateVersionSheetToggled f108452a = new OnShowPirateVersionSheetToggled();

        private OnShowPirateVersionSheetToggled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowPremiumExpiringCardsToggled extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowPremiumExpiringCardsToggled f108453a = new OnShowPremiumExpiringCardsToggled();

        private OnShowPremiumExpiringCardsToggled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowPremiumExpiringToggled extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowPremiumExpiringToggled f108454a = new OnShowPremiumExpiringToggled();

        private OnShowPremiumExpiringToggled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowRatingDialogFlowClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowRatingDialogFlowClicked f108455a = new OnShowRatingDialogFlowClicked();

        private OnShowRatingDialogFlowClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowTrialRemindersFlowClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowTrialRemindersFlowClicked f108456a = new OnShowTrialRemindersFlowClicked();

        private OnShowTrialRemindersFlowClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnShowWhatsNewFlowClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnShowWhatsNewFlowClicked f108457a = new OnShowWhatsNewFlowClicked();

        private OnShowWhatsNewFlowClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSimulateActiveTrialToggled extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnSimulateActiveTrialToggled f108458a = new OnSimulateActiveTrialToggled();

        private OnSimulateActiveTrialToggled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSimulateBillingErrorToggled extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnSimulateBillingErrorToggled f108459a = new OnSimulateBillingErrorToggled();

        private OnSimulateBillingErrorToggled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSkipDiscountTimerClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnSkipDiscountTimerClicked f108460a = new OnSkipDiscountTimerClicked();

        private OnSkipDiscountTimerClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSkipDiscountTimerStateSelected extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DevPrefState f108461a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnSkipDiscountTimerStateSelected(DevPrefState state) {
            super(null);
            Intrinsics.checkNotNullParameter(state, "state");
            this.f108461a = state;
        }

        public final DevPrefState a() {
            return this.f108461a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnSkipDiscountTimerStateSelected) && this.f108461a == ((OnSkipDiscountTimerStateSelected) obj).f108461a;
        }

        public int hashCode() {
            return this.f108461a.hashCode();
        }

        public String toString() {
            return "OnSkipDiscountTimerStateSelected(state=" + this.f108461a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSpeedUpTimersToggled extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnSpeedUpTimersToggled f108462a = new OnSpeedUpTimersToggled();

        private OnSpeedUpTimersToggled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStreakAddActivityClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStreakAddActivityClicked f108463a = new OnStreakAddActivityClicked();

        private OnStreakAddActivityClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStreakAddActivityClicked);
        }

        public int hashCode() {
            return -873805417;
        }

        public String toString() {
            return "OnStreakAddActivityClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStreakClearClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStreakClearClicked f108464a = new OnStreakClearClicked();

        private OnStreakClearClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStreakClearClicked);
        }

        public int hashCode() {
            return -339147910;
        }

        public String toString() {
            return "OnStreakClearClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStreakOpenIntroductionClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStreakOpenIntroductionClicked f108465a = new OnStreakOpenIntroductionClicked();

        private OnStreakOpenIntroductionClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStreakOpenIntroductionClicked);
        }

        public int hashCode() {
            return -1042208349;
        }

        public String toString() {
            return "OnStreakOpenIntroductionClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStreakOpenMilestoneClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStreakOpenMilestoneClicked f108466a = new OnStreakOpenMilestoneClicked();

        private OnStreakOpenMilestoneClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStreakOpenMilestoneClicked);
        }

        public int hashCode() {
            return 1426889057;
        }

        public String toString() {
            return "OnStreakOpenMilestoneClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStreakRefreshClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStreakRefreshClicked f108467a = new OnStreakRefreshClicked();

        private OnStreakRefreshClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStreakRefreshClicked);
        }

        public int hashCode() {
            return -1182239956;
        }

        public String toString() {
            return "OnStreakRefreshClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStreakResetPresentationClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStreakResetPresentationClicked f108468a = new OnStreakResetPresentationClicked();

        private OnStreakResetPresentationClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStreakResetPresentationClicked);
        }

        public int hashCode() {
            return -1948070850;
        }

        public String toString() {
            return "OnStreakResetPresentationClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStreakRunCatchUpClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStreakRunCatchUpClicked f108469a = new OnStreakRunCatchUpClicked();

        private OnStreakRunCatchUpClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStreakRunCatchUpClicked);
        }

        public int hashCode() {
            return -1140295268;
        }

        public String toString() {
            return "OnStreakRunCatchUpClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStreakSeedClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStreakSeedClicked f108470a = new OnStreakSeedClicked();

        private OnStreakSeedClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStreakSeedClicked);
        }

        public int hashCode() {
            return 2140195350;
        }

        public String toString() {
            return "OnStreakSeedClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStreakSeedPatternEntered extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f108471a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnStreakSeedPatternEntered(List statuses) {
            super(null);
            Intrinsics.checkNotNullParameter(statuses, "statuses");
            this.f108471a = statuses;
        }

        public final List a() {
            return this.f108471a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnStreakSeedPatternEntered) && Intrinsics.areEqual(this.f108471a, ((OnStreakSeedPatternEntered) obj).f108471a);
        }

        public int hashCode() {
            return this.f108471a.hashCode();
        }

        public String toString() {
            return "OnStreakSeedPatternEntered(statuses=" + this.f108471a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStreakSendAchievementClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStreakSendAchievementClicked f108472a = new OnStreakSendAchievementClicked();

        private OnStreakSendAchievementClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStreakSendAchievementClicked);
        }

        public int hashCode() {
            return -1294530048;
        }

        public String toString() {
            return "OnStreakSendAchievementClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStreakSendNudgeClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStreakSendNudgeClicked f108473a = new OnStreakSendNudgeClicked();

        private OnStreakSendNudgeClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStreakSendNudgeClicked);
        }

        public int hashCode() {
            return 1036333204;
        }

        public String toString() {
            return "OnStreakSendNudgeClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStreakShowBannerClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStreakShowBannerClicked f108474a = new OnStreakShowBannerClicked();

        private OnStreakShowBannerClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStreakShowBannerClicked);
        }

        public int hashCode() {
            return -1833238274;
        }

        public String toString() {
            return "OnStreakShowBannerClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStreakUploadClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStreakUploadClicked f108475a = new OnStreakUploadClicked();

        private OnStreakUploadClicked() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OnStreakUploadClicked);
        }

        public int hashCode() {
            return -140181370;
        }

        public String toString() {
            return "OnStreakUploadClicked";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnStrictModePauseInSecondsToggled extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnStrictModePauseInSecondsToggled f108476a = new OnStrictModePauseInSecondsToggled();

        private OnStrictModePauseInSecondsToggled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnSubscriptionOnboardingTestClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnSubscriptionOnboardingTestClicked f108477a = new OnSubscriptionOnboardingTestClicked();

        private OnSubscriptionOnboardingTestClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnTestTargetingGroupClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnTestTargetingGroupClicked f108478a = new OnTestTargetingGroupClicked();

        private OnTestTargetingGroupClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnTestTargetingGroupSaved extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f108479a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnTestTargetingGroupSaved(String group) {
            super(null);
            Intrinsics.checkNotNullParameter(group, "group");
            this.f108479a = group;
        }

        public final String a() {
            return this.f108479a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnTestTargetingGroupSaved) && Intrinsics.areEqual(this.f108479a, ((OnTestTargetingGroupSaved) obj).f108479a);
        }

        public int hashCode() {
            return this.f108479a.hashCode();
        }

        public String toString() {
            return "OnTestTargetingGroupSaved(group=" + this.f108479a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnTimeChangeLimitClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnTimeChangeLimitClicked f108480a = new OnTimeChangeLimitClicked();

        private OnTimeChangeLimitClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnTimeChangeLimitSaved extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f108481a;

        public OnTimeChangeLimitSaved(long j3) {
            super(null);
            this.f108481a = j3;
        }

        public final long a() {
            return this.f108481a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnTimeChangeLimitSaved) && this.f108481a == ((OnTimeChangeLimitSaved) obj).f108481a;
        }

        public int hashCode() {
            return Long.hashCode(this.f108481a);
        }

        public String toString() {
            return "OnTimeChangeLimitSaved(minutes=" + this.f108481a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnTimeNudgeShortIntervalsToggled extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnTimeNudgeShortIntervalsToggled f108482a = new OnTimeNudgeShortIntervalsToggled();

        private OnTimeNudgeShortIntervalsToggled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnTrialAlwaysEligibleToggled extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnTrialAlwaysEligibleToggled f108483a = new OnTrialAlwaysEligibleToggled();

        private OnTrialAlwaysEligibleToggled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnTriggerTimeNudgeClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnTriggerTimeNudgeClicked f108484a = new OnTriggerTimeNudgeClicked();

        private OnTriggerTimeNudgeClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnUseFakeReviewManagerToggled extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnUseFakeReviewManagerToggled f108485a = new OnUseFakeReviewManagerToggled();

        private OnUseFakeReviewManagerToggled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnUseNewPaywallToggled extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnUseNewPaywallToggled f108486a = new OnUseNewPaywallToggled();

        private OnUseNewPaywallToggled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnUseProductionServerToggled extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnUseProductionServerToggled f108487a = new OnUseProductionServerToggled();

        private OnUseProductionServerToggled() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnWhatsNewCardClicked extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OnWhatsNewCardClicked f108488a = new OnWhatsNewCardClicked();

        private OnWhatsNewCardClicked() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnWhatsNewCardStateSelected extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DevPrefState f108489a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnWhatsNewCardStateSelected(DevPrefState state) {
            super(null);
            Intrinsics.checkNotNullParameter(state, "state");
            this.f108489a = state;
        }

        public final DevPrefState a() {
            return this.f108489a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnWhatsNewCardStateSelected) && this.f108489a == ((OnWhatsNewCardStateSelected) obj).f108489a;
        }

        public int hashCode() {
            return this.f108489a.hashCode();
        }

        public String toString() {
            return "OnWhatsNewCardStateSelected(state=" + this.f108489a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OnWhatsNewVersionSelected extends DeveloperSettingsViewEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f108490a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnWhatsNewVersionSelected(String version) {
            super(null);
            Intrinsics.checkNotNullParameter(version, "version");
            this.f108490a = version;
        }

        public final String a() {
            return this.f108490a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnWhatsNewVersionSelected) && Intrinsics.areEqual(this.f108490a, ((OnWhatsNewVersionSelected) obj).f108490a);
        }

        public int hashCode() {
            return this.f108490a.hashCode();
        }

        public String toString() {
            return "OnWhatsNewVersionSelected(version=" + this.f108490a + ")";
        }
    }

    public /* synthetic */ DeveloperSettingsViewEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DeveloperSettingsViewEvent() {
    }
}
