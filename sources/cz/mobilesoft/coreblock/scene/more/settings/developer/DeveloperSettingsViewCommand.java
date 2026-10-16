package cz.mobilesoft.coreblock.scene.more.settings.developer;

import cz.mobilesoft.coreblock.base.ViewCommand;
import cz.mobilesoft.coreblock.enums.ContactReason;
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
public abstract class DeveloperSettingsViewCommand implements ViewCommand {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LaunchEventsBubble extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LaunchEventsBubble f108310a = new LaunchEventsBubble();

        private LaunchEventsBubble() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToAppFeelOnboarding extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToAppFeelOnboarding f108311a = new NavigateToAppFeelOnboarding();

        private NavigateToAppFeelOnboarding() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToAutoTrialFlow extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToAutoTrialFlow f108312a = new NavigateToAutoTrialFlow();

        private NavigateToAutoTrialFlow() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToBrowsersList extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToBrowsersList f108313a = new NavigateToBrowsersList();

        private NavigateToBrowsersList() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToCampaignPremium extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f108314a;

        public NavigateToCampaignPremium(long j3) {
            super(null);
            this.f108314a = j3;
        }

        public final long a() {
            return this.f108314a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NavigateToCampaignPremium) && this.f108314a == ((NavigateToCampaignPremium) obj).f108314a;
        }

        public int hashCode() {
            return Long.hashCode(this.f108314a);
        }

        public String toString() {
            return "NavigateToCampaignPremium(campaignId=" + this.f108314a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToCampaignPremiumDefault extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToCampaignPremiumDefault f108315a = new NavigateToCampaignPremiumDefault();

        private NavigateToCampaignPremiumDefault() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToChatBot extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContactReason f108316a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavigateToChatBot(ContactReason contactReason) {
            super(null);
            Intrinsics.checkNotNullParameter(contactReason, "contactReason");
            this.f108316a = contactReason;
        }

        public final ContactReason a() {
            return this.f108316a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NavigateToChatBot) && this.f108316a == ((NavigateToChatBot) obj).f108316a;
        }

        public int hashCode() {
            return this.f108316a.hashCode();
        }

        public String toString() {
            return "NavigateToChatBot(contactReason=" + this.f108316a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToDiscountPremium extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToDiscountPremium f108317a = new NavigateToDiscountPremium();

        private NavigateToDiscountPremium() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToDiscountPremium30 extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToDiscountPremium30 f108318a = new NavigateToDiscountPremium30();

        private NavigateToDiscountPremium30() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToDiscountPremium50 extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToDiscountPremium50 f108319a = new NavigateToDiscountPremium50();

        private NavigateToDiscountPremium50() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToDiscountPremiumReferralReceiver extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToDiscountPremiumReferralReceiver f108320a = new NavigateToDiscountPremiumReferralReceiver();

        private NavigateToDiscountPremiumReferralReceiver() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToDiscountPremiumReferralSender extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToDiscountPremiumReferralSender f108321a = new NavigateToDiscountPremiumReferralSender();

        private NavigateToDiscountPremiumReferralSender() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToExpiredSubDiscountPremium extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToExpiredSubDiscountPremium f108322a = new NavigateToExpiredSubDiscountPremium();

        private NavigateToExpiredSubDiscountPremium() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToExpiredSubPremium extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToExpiredSubPremium f108323a = new NavigateToExpiredSubPremium();

        private NavigateToExpiredSubPremium() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToGenericPremium extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToGenericPremium f108324a = new NavigateToGenericPremium();

        private NavigateToGenericPremium() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToIntroTrialPremium extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToIntroTrialPremium f108325a = new NavigateToIntroTrialPremium();

        private NavigateToIntroTrialPremium() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToIntroTrialTogglePremium extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToIntroTrialTogglePremium f108326a = new NavigateToIntroTrialTogglePremium();

        private NavigateToIntroTrialTogglePremium() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToLimitScreenPremium extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToLimitScreenPremium f108327a = new NavigateToLimitScreenPremium();

        private NavigateToLimitScreenPremium() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToOnboarding extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToOnboarding f108328a = new NavigateToOnboarding();

        private NavigateToOnboarding() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToOneTimeToSubPremium extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToOneTimeToSubPremium f108329a = new NavigateToOneTimeToSubPremium();

        private NavigateToOneTimeToSubPremium() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToPremiumExpiring extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToPremiumExpiring f108330a = new NavigateToPremiumExpiring();

        private NavigateToPremiumExpiring() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToProductPlanPremium extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToProductPlanPremium f108331a = new NavigateToProductPlanPremium();

        private NavigateToProductPlanPremium() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToRatingDialogFlow extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToRatingDialogFlow f108332a = new NavigateToRatingDialogFlow();

        private NavigateToRatingDialogFlow() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToRemoteConfigValues extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToRemoteConfigValues f108333a = new NavigateToRemoteConfigValues();

        private NavigateToRemoteConfigValues() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToSubscriptionOnboarding extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToSubscriptionOnboarding f108334a = new NavigateToSubscriptionOnboarding();

        private NavigateToSubscriptionOnboarding() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToTrialReminders extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToTrialReminders f108335a = new NavigateToTrialReminders();

        private NavigateToTrialReminders() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToTrialRetentionPremium extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToTrialRetentionPremium f108336a = new NavigateToTrialRetentionPremium();

        private NavigateToTrialRetentionPremium() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NavigateToWeeklyInsights extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NavigateToWeeklyInsights f108337a = new NavigateToWeeklyInsights();

        private NavigateToWeeklyInsights() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenAccessibilitySettings extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenAccessibilitySettings f108338a = new OpenAccessibilitySettings();

        private OpenAccessibilitySettings() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenAppSettings extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenAppSettings f108339a = new OpenAppSettings();

        private OpenAppSettings() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenDiscountScreen extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenDiscountScreen f108340a = new OpenDiscountScreen();

        private OpenDiscountScreen() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OpenDiscountScreen);
        }

        public int hashCode() {
            return 938007081;
        }

        public String toString() {
            return "OpenDiscountScreen";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenFilePicker extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenFilePicker f108341a = new OpenFilePicker();

        private OpenFilePicker() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenNotificationAccessSettings extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenNotificationAccessSettings f108342a = new OpenNotificationAccessSettings();

        private OpenNotificationAccessSettings() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenOverlaySettings extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenOverlaySettings f108343a = new OpenOverlaySettings();

        private OpenOverlaySettings() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenStreakIntroduction extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenStreakIntroduction f108344a = new OpenStreakIntroduction();

        private OpenStreakIntroduction() {
            super(null);
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof OpenStreakIntroduction);
        }

        public int hashCode() {
            return 1790717396;
        }

        public String toString() {
            return "OpenStreakIntroduction";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenStreakMilestone extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f108345a;

        public OpenStreakMilestone(int i3) {
            super(null);
            this.f108345a = i3;
        }

        public final int a() {
            return this.f108345a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OpenStreakMilestone) && this.f108345a == ((OpenStreakMilestone) obj).f108345a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f108345a);
        }

        public String toString() {
            return "OpenStreakMilestone(streakCount=" + this.f108345a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class OpenUsageSettings extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenUsageSettings f108346a = new OpenUsageSettings();

        private OpenUsageSettings() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RemoveDeviceAdmin extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final RemoveDeviceAdmin f108347a = new RemoveDeviceAdmin();

        private RemoveDeviceAdmin() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RestartApp extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final RestartApp f108348a = new RestartApp();

        private RestartApp() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowAdsInspector extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowAdsInspector f108349a = new ShowAdsInspector();

        private ShowAdsInspector() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowBackdoorCodeDialog extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ShowBackdoorCodeDialog f108350a = new ShowBackdoorCodeDialog();

        private ShowBackdoorCodeDialog() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowSnackbar extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f108351a;

        public ShowSnackbar(int i3) {
            super(null);
            this.f108351a = i3;
        }

        public final int a() {
            return this.f108351a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowSnackbar) && this.f108351a == ((ShowSnackbar) obj).f108351a;
        }

        public int hashCode() {
            return Integer.hashCode(this.f108351a);
        }

        public String toString() {
            return "ShowSnackbar(messageRes=" + this.f108351a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowToWhatsNewFlow extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f108352a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowToWhatsNewFlow(String version) {
            super(null);
            Intrinsics.checkNotNullParameter(version, "version");
            this.f108352a = version;
        }

        public final String a() {
            return this.f108352a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowToWhatsNewFlow) && Intrinsics.areEqual(this.f108352a, ((ShowToWhatsNewFlow) obj).f108352a);
        }

        public int hashCode() {
            return this.f108352a.hashCode();
        }

        public String toString() {
            return "ShowToWhatsNewFlow(version=" + this.f108352a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ShowToast extends DeveloperSettingsViewCommand {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f108353a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowToast(String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.f108353a = message;
        }

        public final String a() {
            return this.f108353a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowToast) && Intrinsics.areEqual(this.f108353a, ((ShowToast) obj).f108353a);
        }

        public int hashCode() {
            return this.f108353a.hashCode();
        }

        public String toString() {
            return "ShowToast(message=" + this.f108353a + ")";
        }
    }

    public /* synthetic */ DeveloperSettingsViewCommand(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DeveloperSettingsViewCommand() {
    }
}
